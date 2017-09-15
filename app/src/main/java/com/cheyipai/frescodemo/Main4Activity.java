package com.cheyipai.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cheyipai.frescodemo.view.CustomProgressBar;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main4Activity extends AppCompatActivity {

    @Bind(R.id.iv_progress_bar1)
    SimpleDraweeView ivProgressBar1;
    @Bind(R.id.iv_progress_bar2)
    SimpleDraweeView ivProgressBar2;


    private String url1 = "http://down1.cnmo.com/app/a130/haibian0.jpg";
    private String url2 = "http://hiphotos.baidu.com/zhidao/pic/item/6f061d95b09e72727af48004.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);

        final Uri uri1 = Uri.parse(url1);
        final Uri uri2 = Uri.parse(url2);

        /**
         * 要显示进度，最简单的办法就是在 构建 hierarchy 时使用 ProgressBarDrawable
         */

        //获取引用
        GenericDraweeHierarchy hierarchy = ivProgressBar1.getHierarchy();
        //使用默认的进度条 new ProgressBarDrawable()
        hierarchy.setProgressBarImage(new ProgressBarDrawable());

        ivProgressBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivProgressBar1.setImageURI(uri1);
            }
        });


        //使用自定义的进度条 CustomProgressBar()
        CustomProgressBar customProgressBar = new CustomProgressBar();
        customProgressBar.setBackgroundColor(this.getResources().getColor(R.color.holo_gray_bright));
        customProgressBar.setColor(this.getResources().getColor(R.color.holo_orange_dark));
        customProgressBar.setPadding(0);
        GenericDraweeHierarchy hierarchy2 = ivProgressBar2.getHierarchy();
        hierarchy2.setProgressBarImage(customProgressBar);

        ivProgressBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivProgressBar2.setImageURI(uri2);
            }
        });




    }

}
