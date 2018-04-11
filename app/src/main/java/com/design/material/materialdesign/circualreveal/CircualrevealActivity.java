package com.design.material.materialdesign.circualreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.CardView;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.design.material.materialdesign.circualreveal.codetail.animation.SpringForce;
import com.design.material.materialdesign.circualreveal.codetail.animation.SpringViewAnimatorManager;
import com.design.material.materialdesign.circualreveal.codetail.animation.ViewAnimationUtils;
import com.design.material.materialdesign.circualreveal.codetail.animation.ViewRevealManager;
import com.design.material.materialdesign.circualreveal.codetail.widget.RevealFrameLayout;

import butterknife.ButterKnife;

/**
 * Created by beixinyuan_android on 2018/4/8.
 */

public class CircualrevealActivity extends BaseActivity {

    final static int SLOW_DURATION = 400;
    final static int FAST_DURATION = 200;

    private RevealFrameLayout parent;
    private ViewGroup circlesLine;
    private ViewGroup cardsLine;
    private CardView activatorMask;
    private SpringSettingsBottomDialog settingsView;

    private float maskElevation;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_circualreveal, null);
    }

    @Override
    protected void initView() {
        parent = (RevealFrameLayout) findViewById(R.id.parent);
        circlesLine = (ViewGroup) findViewById(R.id.circlesLine);
        cardsLine = (ViewGroup) findViewById(R.id.cardsLine);
        activatorMask = (CardView) findViewById(R.id.activator_mask);
        settingsView = (SpringSettingsBottomDialog) findViewById(R.id.springSettings);


        final ViewRevealManager revealManager = new ViewRevealManager();
        final SpringViewAnimatorManager springManager = new SpringViewAnimatorManager();
        springManager.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        springManager.setStiffness(SpringForce.STIFFNESS_LOW);

        parent.setViewRevealManager(revealManager);

        settingsView.addSwitch("Enable Spring", false, new CompoundButton.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                parent.setViewRevealManager(isChecked ? springManager : revealManager);
            }
        });
        settingsView.setAnimatorManager(springManager);

        final BottomSheetBehavior behavior = BottomSheetBehavior.from(settingsView);
        behavior.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.bottom_peek_height));
        behavior.setSkipCollapsed(false);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        findViewById(R.id.activator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateAwareMotion(v);
            }
        });
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetUi(v);
            }
        });
        findViewById(R.id.open_radial_transformation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2Example();
            }
        });
    }

    void activateAwareMotion(View target) {
        // Cancel all concurrent events on view
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            target.cancelPendingInputEvents();
        }
        target.setEnabled(false);

        // Coordinates of circle initial point
        final ViewGroup parent = (ViewGroup) activatorMask.getParent();
        final Rect bounds = new Rect();
        final Rect maskBounds = new Rect();

        target.getDrawingRect(bounds);
        activatorMask.getDrawingRect(maskBounds);
        parent.offsetDescendantRectToMyCoords(target, bounds);
        parent.offsetDescendantRectToMyCoords(activatorMask, maskBounds);

        // Put Mask view at circle 8initial points
        maskElevation = activatorMask.getCardElevation();
        activatorMask.setCardElevation(0);
        activatorMask.setVisibility(View.VISIBLE);
        activatorMask.setX(bounds.left - maskBounds.centerX());
        activatorMask.setY(bounds.top - maskBounds.centerY());

        circlesLine.setVisibility(View.INVISIBLE);

        final int cX = maskBounds.centerX();
        final int cY = maskBounds.centerY();

        final float endRadius = (float) Math.hypot(maskBounds.width() * .5f, maskBounds.height() * .5f);

        Animator circularReveal =
                ViewAnimationUtils.createCircularReveal(activatorMask, cX, cY, target.getWidth() / 2,
                        endRadius, View.LAYER_TYPE_HARDWARE);

        final float c0X = bounds.centerX() - maskBounds.centerX();
        final float c0Y = bounds.centerY() - maskBounds.centerY();

        AnimatorPath path = new AnimatorPath();
        path.moveTo(c0X, c0Y);
        path.curveTo(c0X, c0Y, 0, c0Y, 0, 0);

        ObjectAnimator pathAnimator = ObjectAnimator.ofObject(this, "maskLocation", new PathEvaluator(),
                path.getPoints().toArray());

        AnimatorSet set = new AnimatorSet();
        set.playTogether(circularReveal, pathAnimator);
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.setDuration(SLOW_DURATION);
        set.addListener(new AnimatorListenerAdapter() {
            @Override public void onAnimationEnd(Animator animation) {
                executeCardsSequentialAnimation();
                activatorMask.setCardElevation(maskElevation);
            }
        });
        set.start();
    }

    private void executeCardsSequentialAnimation() {
        final int length = cardsLine.getChildCount();
        cardsLine.setVisibility(View.VISIBLE);

        final Animator[] animators = new Animator[length];
        for (int i = 0; i < length; i++) {
            View target = cardsLine.getChildAt(i);
            final float x0 = 0;// i == 0 ? 0 : -10 * (1 + i * 0.2f);
            final float y0 = 10 * i;

            target.setTranslationX(x0);
            target.setTranslationY(y0);

            AnimatorPath path = new AnimatorPath();
            path.moveTo(x0, y0);
            path.lineTo(0, 0);

            PathPoint[] points = new PathPoint[path.getPoints().size()];
            path.getPoints().toArray(points);

            AnimatorSet set = new AnimatorSet();
            set.play(ObjectAnimator.ofObject(target, PATH_POINT, new PathEvaluator(), points))
                    .with(ObjectAnimator.ofFloat(target, View.ALPHA, 0.8f, 1f));

            animators[i] = set;
            animators[i].setStartDelay(15 * i);
        }

        final AnimatorSet sequential = new AnimatorSet();
        sequential.playTogether(animators);
        sequential.setInterpolator(new FastOutLinearInInterpolator());
        sequential.setDuration(FAST_DURATION);
        sequential.start();
    }

    void resetUi(View resetCard) {
        cardsLine.setVisibility(View.INVISIBLE);

        final View target = ButterKnife.findById(this, R.id.activator);

        // Coordinates of circle initial point
        final ViewGroup parent = (ViewGroup) activatorMask.getParent();
        final Rect bounds = new Rect();
        final Rect maskBounds = new Rect();

        target.getDrawingRect(bounds);
        activatorMask.getDrawingRect(maskBounds);
        parent.offsetDescendantRectToMyCoords(target, bounds);
        parent.offsetDescendantRectToMyCoords(activatorMask, maskBounds);

        maskElevation = activatorMask.getCardElevation();
        activatorMask.setCardElevation(0);

        final int cX = maskBounds.centerX();
        final int cY = maskBounds.centerY();

        final Animator circularReveal = ViewAnimationUtils.createCircularReveal(activatorMask, cX, cY,
                (float) Math.hypot(maskBounds.width() * .5f, maskBounds.height() * .5f),
                target.getWidth() / 2f, View.LAYER_TYPE_HARDWARE);

        final float c0X = bounds.centerX() - maskBounds.centerX();
        final float c0Y = bounds.centerY() - maskBounds.centerY();

        AnimatorPath path = new AnimatorPath();
        path.moveTo(0, 0);
        path.curveTo(0, 0, 0, c0Y, c0X, c0Y);

        ObjectAnimator pathAnimator = ObjectAnimator.ofObject(this, "maskLocation", new PathEvaluator(),
                path.getPoints().toArray());

        AnimatorSet set = new AnimatorSet();
        set.playTogether(circularReveal, pathAnimator);
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.setDuration(SLOW_DURATION);
        set.addListener(new AnimatorListenerAdapter() {
            @Override public void onAnimationEnd(Animator animation) {
                activatorMask.setCardElevation(maskElevation);
                activatorMask.setVisibility(View.INVISIBLE);

                circlesLine.setVisibility(View.VISIBLE);
                executeCirclesDropDown();
                target.setEnabled(true);
            }
        });
        set.start();
    }

    private void executeCirclesDropDown() {
        final int length = circlesLine.getChildCount();
        Animator[] animators = new Animator[length];
        for (int i = 0; i < length; i++) {
            View target = circlesLine.getChildAt(i);
            final float x0 = -10 * i;
            final float y0 = -10 * i;

            target.setTranslationX(x0);
            target.setTranslationY(y0);

            AnimatorPath path = new AnimatorPath();
            path.moveTo(x0, y0);
            path.curveTo(x0, y0, 0, y0, 0, 0);

            PathPoint[] points = new PathPoint[path.getPoints().size()];
            path.getPoints().toArray(points);

            AnimatorSet set = new AnimatorSet();
            set.play(ObjectAnimator.ofObject(target, PATH_POINT, new PathEvaluator(), points))
                    .with(ObjectAnimator.ofFloat(target, View.ALPHA, (length - i) * 0.1f + 0.6f, 1f));

            animators[i] = set;
            animators[i].setStartDelay(15 * i);
        }

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animators);
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.setDuration(FAST_DURATION);
        set.start();
    }

    private final static Property<View, PathPoint> PATH_POINT =
            new Property<View, PathPoint>(PathPoint.class, "PATH_POINT") {
                PathPoint point;

                @Override public PathPoint get(View object) {
                    return point;
                }

                @Override public void set(View object, PathPoint value) {
                    point = value;

                    object.setTranslationX(value.mX);
                    object.setTranslationY(value.mY);
                }
            };

    public void setMaskLocation(PathPoint location) {
        activatorMask.setX(location.mX);
        activatorMask.setY(location.mY);
    }

    private void open2Example() {
        Intent intent = new Intent(this, RadialTransformationActivity.class);
        startActivity(intent);
    }

}
