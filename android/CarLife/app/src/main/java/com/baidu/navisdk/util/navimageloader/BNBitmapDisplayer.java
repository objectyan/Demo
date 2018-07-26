package com.baidu.navisdk.util.navimageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public interface BNBitmapDisplayer {
    void display(String str, Bitmap bitmap, ImageView imageView);

    void display(String str, Drawable drawable, ImageView imageView);
}
