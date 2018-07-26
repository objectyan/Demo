package com.baidu.navisdk.util.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.InputStream;

public class ImageTools {
    public static Bitmap getBitmapFromByteArray(byte[] data) {
        try {
            return BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromPath(String path) {
        try {
            return BitmapFactory.decodeFile(path);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromResId(int resId) {
        try {
            return BitmapFactory.decodeResource(JarUtils.getResources(), resId);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromStream(InputStream stream) {
        Bitmap bmp;
        try {
            bmp = BitmapFactory.decodeStream(stream);
            try {
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (OutOfMemoryError e2) {
            bmp = null;
            try {
                stream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                stream.close();
            } catch (Exception e32) {
                e32.printStackTrace();
            }
            throw th;
        }
        return bmp;
    }

    public static Rect calcSquareRect(Rect r) {
        int w = r.right - r.left;
        int h = r.bottom - r.top;
        int s = Math.min(w, h);
        int horiMargin = (w - s) / 2;
        int vertMargin = (h - s) / 2;
        if (horiMargin == 0) {
            r.top += vertMargin;
            r.bottom -= vertMargin;
        } else {
            r.left += horiMargin;
            r.right -= horiMargin;
        }
        return r;
    }
}
