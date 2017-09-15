package com.cheyipai.frescodemo;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 动画图GIF和WebP
 */
public class Main6Activity extends AppCompatActivity {

    @Bind(R.id.iv_gif1)
    SimpleDraweeView ivGif1;
    @Bind(R.id.iv_gif2)
    SimpleDraweeView ivGif2;
    @Bind(R.id.iv_gif3)
    SimpleDraweeView ivGif3;

    private String url_gif = "http://img3.3lian.com/2006/013/08/20051103121420947.gif";
    boolean isPlay = true;

    //webp动画图
    private String url_webp = "http://gtms01.alicdn.com/tps/i1/T1EXtgXy4eXXX_WqbX.webp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);

        Uri uri_gif = Uri.parse(url_gif);
        Uri uri_gif2 = Uri.parse("res://mipmap-xxhdpi/" + R.mipmap.xiaohuangren);
        Uri uri_webp = Uri.parse(url_webp);

        //设置动画图自动播放
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri_gif)
                .setAutoPlayAnimations(true)
                .build();
        ivGif1.setController(controller);

        DraweeController controller2 = Fresco.newDraweeControllerBuilder()
                .setUri(uri_gif2)
//                .setAutoPlayAnimations(true)
                .setControllerListener(controllerListener)
                .build();
        ivGif2.setController(controller2);

        ivGif2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animatable animation = ivGif2.getController().getAnimatable();
                if (animation != null && !isPlay) {
                    // 开始播放
                    animation.start();
                    isPlay = true;
                } else {
                    // 停止播放
                    animation.stop();
                    isPlay = false;
                }
            }
        });

        //webp格式动画支持
        DraweeController controller3 = Fresco.newDraweeControllerBuilder()
                .setUri(uri_webp)
                .setAutoPlayAnimations(true)
                .build();
        ivGif3.setController(controller3);
    }

    /**
     * 也许你希望在代码中直接控制动画的播放。
     * 这种情况下，你需要监听图片是否加载完毕，然后才能控制动画的播放
     */
    ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
        @Override
        public void onFinalImageSet(
                String id,
                @Nullable ImageInfo imageInfo,
                @Nullable Animatable anim) {
            if (anim != null) {
                anim.start();
            }
        }
    };

}
