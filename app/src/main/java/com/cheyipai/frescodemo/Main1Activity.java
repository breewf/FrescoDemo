package com.cheyipai.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 加载中及加载失败示例
 */
public class Main1Activity extends AppCompatActivity {

    @Bind(R.id.iv_loading)
    SimpleDraweeView ivLoading;
    @Bind(R.id.iv_loading_error)
    SimpleDraweeView ivLoadingError;
    @Bind(R.id.iv_retry)
    SimpleDraweeView ivRetry;

    private String url = "http://a.hiphotos.baidu.com/zhidao/pic/item/bd315c6034a85edf2d0a30ce4b540923dc54755d.jpg";

    //使用一个错误的url
    private String url_error = "http://a.hiphotos.baidu.com/zhidao/pic/bd315c6034a85edf2d0a30ce4b540923dc54755d.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);

        //加载中
        Uri uri = Uri.parse(url);
        ivLoading.setImageURI(uri);

        //加载失败，使用错误的url
        Uri uri_error = Uri.parse(url_error);
        ivLoadingError.setImageURI(uri_error);

        //重试加载图片，使用错误的url
        //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                //加载的图片URI地址
                .setUri(uri_error)
                        //设置点击重试是否开启
                .setTapToRetryEnabled(true)
                        //设置旧的Controller
                .setOldController(ivRetry.getController())
                        //构建
                .build();
        ivRetry.setController(controller);

    }
}
