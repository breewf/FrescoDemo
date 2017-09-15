package com.cheyipai.frescodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 渐进式图片显示
 * Fresco 支持渐进式的网络JPEG图。在开始加载之后，图会从模糊到清晰渐渐呈现。

 你可以设置一个清晰度标准，在未达到这个清晰度之前，会一直显示占位图。

 渐进式JPEG图仅仅支持网络图。
 */
public class Main5Activity extends AppCompatActivity {

    @Bind(R.id.iv_jpeg)
    SimpleDraweeView ivJpeg;

    private String url = "http://img.daimg.com/uploads/allimg/120621/3-1206211F522957.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 除了自己实现ProgressiveJpegConfig， 也可以直接使用SimpleProgressiveJpegConfig.
         */
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(pjpegConfig)
                .build();
        Fresco.initialize(this, config);

        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);

        final Uri uri = Uri.parse(url);


        /**
         * 目前，我们必须显式地在加载时，允许渐进式JPEG图片加载。
         * 我们希望在后续的版本中，在setImageURI方法中可以直接支持渐进式图片加载。
         */

        ivJpeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage(uri);
            }
        });


    }

    private void loadImage(Uri uri) {
        ImageRequest request = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(ivJpeg.getController())
                .build();

        PipelineDraweeController controller2 = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(ivJpeg.getController())
                .build();

        ivJpeg.setController(controller2);
    }

    /**
     * 这个实例需要完成两个事情: 1. 返回下一个需要解码的扫描次数 2. 确定多少个扫描次数之后的图片才能开始显示。

     下面的实例中，为了实现节省CPU，并不是每个扫描都进行解码。

     注意:

     每次解码完之后，调用getNextScanNumberToDecode, 等待扫描值大于返回值，才有可能进行解码。
     假设，随着下载的进行，下载完的扫描序列如下: 1, 4, 5, 10。那么：

     首次调用getNextScanNumberToDecode返回为2， 因为初始时，解码的扫描数为0。
     那么1将不会解码，下载完成4个扫描时，解码一次。下个解码为扫描数为6
     5不会解码，10才会解码
     */

    ProgressiveJpegConfig pjpegConfig = new ProgressiveJpegConfig() {
        @Override
        public int getNextScanNumberToDecode(int scanNumber) {
            return scanNumber + 2;
        }

        public QualityInfo getQualityInfo(int scanNumber) {
            boolean isGoodEnough = (scanNumber >= 5);
            return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
        }
    };
}
