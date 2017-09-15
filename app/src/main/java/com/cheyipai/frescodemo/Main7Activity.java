package com.cheyipai.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 改变图片大小和缩放
 */
public class Main7Activity extends AppCompatActivity {

    @Bind(R.id.iv_scan1)
    SimpleDraweeView ivScan1;
    @Bind(R.id.iv_scan2)
    SimpleDraweeView ivScan2;

    boolean isShowDefault  = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);

        final Uri uri = Uri.parse("res://mipmap-xxhdpi/" + R.mipmap.image02);
        Uri uri2 = Uri.parse("res://mipmap-xxhdpi/" + R.mipmap.image01);

        showImageSizeDefault(uri);

        ivScan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowDefault){
                    changeImageSize(uri);
                    isShowDefault = false;
                }else {
                    showImageSizeDefault(uri);
                    isShowDefault = true;
                }
            }
        });

        //图片自动旋转
        ImageRequest request2 = ImageRequestBuilder.newBuilderWithSource(uri2)
                //自动旋转
                .setAutoRotateEnabled(true)
                .build();
        DraweeController controller2 = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request2)
                .setOldController(ivScan2.getController())
                .build();
        ivScan2.setController(controller2);

    }

    //显示默认图片尺寸大小
    private void showImageSizeDefault(Uri uri){
        ivScan1.setImageURI(uri);
    }

    //修改图片尺寸大小
    private void changeImageSize(Uri uri) {
        int width = 400, height = 340;
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                //设置尺寸
                .setResizeOptions(new ResizeOptions(width, height))
                .build();
        final PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(ivScan1.getController())
                .setImageRequest(request)
                .build();
        ivScan1.setController(controller);
    }
}
