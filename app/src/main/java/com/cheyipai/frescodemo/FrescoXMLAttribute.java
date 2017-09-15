package com.cheyipai.frescodemo;

/**
 * Created by GHY on 2016/1/19.
 * Fresco XML属性
 * Fresco 缩放属性
 */
public class FrescoXMLAttribute {

    /**
     * XML属性	意义
     fadeDuration	淡入淡出动画持续时间(单位：毫秒ms)
     actualImageScaleType	实际图像的缩放类型
     placeholderImage	占位图
     placeholderImageScaleType	占位图的缩放类型
     progressBarImage	进度图
     progressBarImageScaleType	进度图的缩放类型
     progressBarAutoRotateInterval	进度图自动旋转间隔时间(单位：毫秒ms)
     failureImage	失败图
     failureImageScaleType	失败图的缩放类型
     retryImage	重试图
     retryImageScaleType	重试图的缩放类型
     backgroundImage	背景图
     overlayImage	叠加图
     pressedStateOverlayImage	按压状态下所显示的叠加图
     roundAsCircle	设置为圆形图
     roundedCornerRadius	圆角半径
     roundTopLeft	左上角是否为圆角
     roundTopRight	右上角是否为圆角
     roundBottomLeft	左下角是否为圆角
     roundBottomRight	右下角是否为圆角
     roundingBorderWidth	圆形或者圆角图边框的宽度
     roundingBorderColor	圆形或者圆角图边框的颜色
     roundWithOverlayColor	圆形或者圆角图底下的叠加颜色(只能设置颜色)
     viewAspectRatio	控件纵横比
     */


    /**
     * 缩放
     对于 Drawee 的各种效果配置，其中一些是支持缩放类型的。
     可用的缩放类型
     类型	描述
     center	居中，无缩放。
     centerCrop	保持宽高比缩小或放大，使得两边都大于或等于显示边界，且宽或高契合显示边界。居中显示。
     focusCrop	同centerCrop, 但居中点不是中点，而是指定的某个点。
     centerInside	缩放图片使两边都在显示边界内，居中显示。和 fitCenter 不同，不会对图片进行放大。
     如果图尺寸大于显示边界，则保持长宽比缩小图片。
     fitCenter	保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，且宽或高契合显示边界。居中显示。
     fitStart	同上。但不居中，和显示边界左上对齐。
     fitEnd	同fitCenter， 但不居中，和显示边界右下对齐。
     fitXY	不保存宽高比，填充满显示边界。
     none	如要使用tile mode显示, 需要设置为none
     这些缩放类型和Android ImageView 支持的缩放类型几乎一样.

     唯一不支持的缩放类型是 matrix。Fresco 提供了 focusCrop 作为补充，通常这个使用效果更佳。

     focusCrop:

     centerCrop缩放模式会保持长宽比，放大或缩小图片，填充满显示边界，居中显示。这个缩放模式在通常情况下很有用。

     但是对于人脸等图片时，一味地居中显示，这个模式可能会裁剪掉一些有用的信息。

     以人脸图片为例，借助一些类库，我们可以识别出人脸所在位置。如果可以设置以人脸位置居中裁剪显示，那么效果会好很多。

     Fresco的focusCrop缩放模式正是为此而设计。只要提供一个居中聚焦点，显示时就会尽量以此点为中心。

     居中点是以相对方式给出的，比如 (0f, 0f) 是左上对齐显示，(1f, 1f) 是右下角对齐。相对坐标使得居中点位置和具体尺寸无关，这是非常实用的。

     (0.5f, 0.5f) 的居中点位置和缩放类型 centerCrop 是等价的。

     如果要使用此缩放模式，首先在 XML 中指定缩放模式:
     fresco:actualImageScaleType="focusCrop"
     在Java代码中，给你的图片指定居中点：
     PointF focusPoint;
     // your app populates the focus point
     mSimpleDraweeView
     .getHierarchy()
     .setActualImageFocusPoint(focusPoint);

     */
}
