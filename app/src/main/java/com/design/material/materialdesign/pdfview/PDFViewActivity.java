package com.design.material.materialdesign.pdfview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.shockwave.pdfium.PdfDocument;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by beixinyuan_android on 2018/3/15.
 */

public class PDFViewActivity extends BaseActivity implements OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {

    private static final String TAG = PDFViewActivity.class.getSimpleName();

    private final static int REQUEST_CODE = 42;
    public static final int PERMISSION_CODE = 42042;

    public static final String SAMPLE_FILE = "sample.pdf";
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";

    private PDFView pdfView;;
    private Uri uri;
    private Integer pageNumber = 0;
    private String pdfFileName;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if(menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pickFile:
                pickFile();
                break;
        }
        return true;
    }

    @Override
    protected int getRootView() {
        return R.layout.activity_pdfview;
    }

    @Override
    protected void initView() {
        pdfView = (PDFView) findViewById(R.id.pdfView);
    }

    @Override
    protected void initData() {
        pdfView.setBackgroundColor(Color.LTGRAY);
        if (uri != null) {
            displayFromUri(uri);
        } else {
            displayFromAsset(SAMPLE_FILE);
        }
        setTitle(pdfFileName);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onPageError(int page, Throwable t) {
        Log.e(TAG, "Cannot load page " + page);
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        Log.e(TAG, "title = " + meta.getTitle());
        Log.e(TAG, "author = " + meta.getAuthor());
        Log.e(TAG, "subject = " + meta.getSubject());
        Log.e(TAG, "keywords = " + meta.getKeywords());
        Log.e(TAG, "creator = " + meta.getCreator());
        Log.e(TAG, "producer = " + meta.getProducer());
        Log.e(TAG, "creationDate = " + meta.getCreationDate());
        Log.e(TAG, "modDate = " + meta.getModDate());

        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    /**
     * 选择文件
     */
    void pickFile() {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                READ_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{READ_EXTERNAL_STORAGE},
                    PERMISSION_CODE
            );

            return;
        }

        launchPicker();
    }

    void launchPicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            //alert user that file manager not working
            Toast.makeText(this, "Unable to pick file. Check status of file manager", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .pageFitPolicy(FitPolicy.BOTH)
                .load();
    }

    private void displayFromUri(Uri uri) {
        pdfFileName = getFileName(uri);

        pdfView.fromUri(uri)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .load();
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                launchPicker();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            uri = intent.getData();
            displayFromUri(uri);
        }
    }
}
