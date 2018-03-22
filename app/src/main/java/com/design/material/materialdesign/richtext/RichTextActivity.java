package com.design.material.materialdesign.richtext;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.design.material.materialdesign.BaseActivity;
import com.design.material.materialdesign.R;
import com.zzhoujay.richtext.CacheType;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnImageClickListener;
import com.zzhoujay.richtext.callback.SimpleImageFixCallback;

import java.util.Calendar;
import java.util.List;

/**
 * Created by beixinyuan_android on 2018/3/15.
 */

public class RichTextActivity extends BaseActivity {

    private TextView textView;

    private static final String IMAGE = "<img title=\"\" src=\"http://g.hiphotos.baidu.com/image/pic/item/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg\"  style=\"cursor: pointer;\"><br><br>" +
            "<img src=\"http://img.ugirls.com/uploads/cooperate/baidu/20160519menghuli.jpg\" width=\"1080\" height=\"1620\"/><a href=\"http://www.baidu.com\">baidu</a>" +
            "hello asdkjfgsduk <a href=\"http://www.jd.com\">jd</a>";
    private static final String IMAGE1 = "<h1>RichText</h1><p>Android平台下的富文本解析器</p><img title=\"\" src=\"http://g.hiphotos.baidu.com/image/pic/item/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg\"  style=\"cursor: pointer;\"><br><br>" +
            "<h3>点击菜单查看更多Demo</h3><img src=\"http://ww2.sinaimg.cn/bmiddle/813a1fc7jw1ee4xpejq4lj20g00o0gnu.jpg\" /><p><a href=\"http://www.baidu.com\">baidu</a>" +
            "hello asdkjfgsduk <a href=\"http://www.jd.com\">jd</a></p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>bottom";


    private static final String GIF_TEST = "<img src=\"http://ww4.sinaimg.cn/large/5cfc088ejw1f3jcujb6d6g20ap08mb2c.gif\">";

    private static final String markdown_test = "image:![image](http://image.tianjimedia.com/uploadImages/2015/129/56/J63MI042Z4P8.jpg)\n[link](https://github.com/zzhoujay/RichText/issues)";

    private static final String gif_test = "<h3>Test1</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/1.gif\" />" +
            "            <h3>Test2</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/2.gif\" />" +
            "            <h3>Test3</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/3.gif\" />" +
            "            <h3>Test4</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/4.gif\" />" +
            "            <h3>Test5</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/5.gif\" />" +
            "            <h3>Test6</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/6.gif\" />" +
            "            <h3>Test7</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/7.gif\" />" +
            "            <h3>Test8</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/8.gif\" />" +
            "            <h3>Test9</h3><img src=\"http://www.aikf.com/ask/resources/images/facialExpression/qq/9.gif\" />";

    private static final String list_test = "<ol>\n" +
            "   <li>Coffee</li>\n" +
            "   <li>Tea</li>\n" +
            "   <li>Milk</li>\n" +
            "</ol>\n" +
            "\n" +
            "<ul>\n" +
            "   <li>Coffee</li>\n" +
            "   <li>Tea</li>\n" +
            "   <li>Milk</li>\n" +
            "</ul>";

    private static final String large_image = "<img src=\"http://static.tme.im/article_1_1471686391302fue\"/>";

    private static final String text = "";
    private static final String TAG = "MainActivityTest";


    private final String issue142 = "<p><img src=\"http://image.wangchao.net.cn/it/1233190350268.gif?size=528*388\" width=\"528\" height=\"388\" /></p>";

    private final String issue143 = "<img src=\"file:///C:\\Users\\ADMINI~1\\AppData\\Local\\Temp\\ksohtml\\wpsB8DD.tmp.png\">";

    private final String issue147 = "<div class=\"pictureBox\"> \n" +
            " <img src=\"http://static.storeer.com/wlwb/productDetail/234be0ec-e90a-4eda-90bd-98d64b55280a_580x4339.jpeg\">\n" +
            "</div>";

    private final String issue149 = null;

    private final String issue150 = "<img src='http://cuncxforum-10008003.image.myqcloud.com/642def77-373f-434f-8e68-42dedbd9f880'/><br><img src='http://cuncxforum-10008003.image.myqcloud.com/bf153d9f-e8c3-4dcc-a23e-bfe0358cb429'/>";

    private static final String assets_image_test = "<h1>Assets Image Test</h1><img src=\"file:///android_asset/doge.jpg\">";

    int loading = 0;
    int failure = 0;
    int ready = 0;
    int init = 0;


    @Override
    protected int getRootView() {
        return R.layout.activity_richtext;
    }

    @Override
    protected void initView() {
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void initData() {
        RichText.initCacheDir(this);
        RichText.debugMode = true;

        String test_text_2 = "<p>我是文本内容 <img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' /> 下一个" +
                "<img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' />似懂非懂撒范德萨咖啡机盛大开放惊世毒妃</p><p>我是文本内容 <img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' /> 下一个" +
                "<img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' />似懂非懂撒范德萨咖啡机盛大开放惊世毒妃</p><p>我是文本内容 <img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' /> 下一个" +
                "<img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' />似懂非懂撒范德萨咖啡机盛大开放惊世毒妃</p><p>我是文本内容 <img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' /> 下一个" +
                "<img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' />似懂非懂撒范德萨咖啡机盛大开放惊世毒妃</p><img src='http://wx1.sinaimg.cn/mw690/eaaf2affly1fihvjpekzwj21el0qotfq.jpg' />似懂非懂撒范德萨咖啡机盛大开放惊世毒妃";

        RichText.from("").into(textView);

        RichText.from(test_text_2).showBorder(true).cache(CacheType.all).into(textView);
        //recylerview-jpg展示
        //RichText.from(testString1[position]).singleLoad(false).into(h.text);
        //listview-gif和jpg混用
//        RichText.from(text).autoPlay(true).singleLoad(false).fix(new SimpleImageFixCallback() {
//            @Override
//            public void onInit(ImageHolder holder) {
//                if (holder.isGif()) {
//                    holder.setAutoFix(false);
//                }
//            }
//        }).into(holder.text);
        //git-加载gif
        //RichText.from(GIF_TEST).autoFix(false).showBorder(true).autoPlay(true).into(textView);
        //jpg
//        richText = RichText.from(test)
//                .imageClick(new OnImageClickListener() {
//                    @Override
//                    public void imageClicked(List<String> imageUrls, int position) {
//                        Calendar calendar = Calendar.getInstance();
//                        int m = calendar.get(Calendar.MINUTE);
//                        int s = calendar.get(Calendar.SECOND);
//                        Toast.makeText(TestActivity.this, "M:" + m + ",S:" + s, Toast.LENGTH_SHORT).show();
//                    }
//                }).into(textView);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "RecyclerView");
        menu.add(0, 1, 1, "ListView");
        menu.add(0, 2, 2, "Gif");
        menu.add(0, 3, 3, "Test");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == 0) {
//            startActivity(new Intent(this, RecyclerViewActivity.class));
//        } else if (item.getItemId() == 1) {
//            startActivity(new Intent(this, ListViewActivity.class));
//        } else if (item.getItemId() == 2) {
//            startActivity(new Intent(this, GifActivity.class));
//        } else if (item.getItemId() == 3) {
//            startActivity(new Intent(this, TestActivity.class));
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RichText.recycle();
    }

    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
