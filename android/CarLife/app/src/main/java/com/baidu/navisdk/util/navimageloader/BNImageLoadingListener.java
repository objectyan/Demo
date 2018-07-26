package com.baidu.navisdk.util.navimageloader;

import android.graphics.Bitmap;
import android.view.View;

public interface BNImageLoadingListener {
    void onLoadingComplete(String str, View view, Bitmap bitmap, int i);

    void onLoadingFailed(String str, View view, String str2);

    void onLoadingStarted(String str, View view);
}
