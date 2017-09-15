package com.cheyipai.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 圆形图及圆角图示例
 */
public class Main3Activity extends AppCompatActivity {

    @Bind(R.id.iv_circle1)
    SimpleDraweeView ivCircle1;
    @Bind(R.id.iv_circle2)
    SimpleDraweeView ivCircle2;
    @Bind(R.id.iv_round1)
    SimpleDraweeView ivRound1;
    @Bind(R.id.iv_round2)
    SimpleDraweeView ivRound2;


    //头像图片url
    private String url = "http://avatar.csdn.net/4/E/8/1_y1scp.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        Uri uri = Uri.parse(url);

        //圆形图
        ivCircle2.setImageURI(uri);

        //圆角图
        ivRound2.setImageURI(uri);
    }
}
