package com.baidu.navisdk.util.common;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;

public class BitmapLoadUtils {
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

    public static Bitmap getBitmapFromResId(Resources res, int resId) {
        try {
            return BitmapFactory.decodeResource(res, resId);
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
}
