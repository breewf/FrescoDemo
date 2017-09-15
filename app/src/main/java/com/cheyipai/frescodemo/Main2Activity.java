package com.cheyipai.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 背景图及叠加图示例
 */
public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.iv_background1)
    SimpleDraweeView ivBackground1;
    @Bind(R.id.iv_background2)
    SimpleDraweeView ivBackground2;
    @Bind(R.id.iv_overlay1)
    SimpleDraweeView ivOverlay1;
    @Bind(R.id.iv_overlay2)
    SimpleDraweeView ivOverlay2;

    //头像图片url
    private String url = "http://avatar.csdn.net/4/E/8/1_y1scp.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        //背景图
        Uri uri = Uri.parse(url);
        ivBackground1.setImageURI(uri);

        //叠加图
        ivOverlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //按压叠加图
        ivOverlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
