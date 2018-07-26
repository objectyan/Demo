package com.baidu.carlife.wechat.p113g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import java.io.InputStream;
import java.lang.reflect.Field;

/* compiled from: ImageUtils */
/* renamed from: com.baidu.carlife.wechat.g.a */
public class C2497a {

    /* compiled from: ImageUtils */
    /* renamed from: com.baidu.carlife.wechat.g.a$a */
    public static class C2496a {
        /* renamed from: a */
        int f8129a;
        /* renamed from: b */
        int f8130b;

        public C2496a(int width, int height) {
            this.f8129a = width;
            this.f8130b = height;
        }

        public String toString() {
            return "ImageSize[width=" + this.f8129a + ", height=" + this.f8130b + ']';
        }
    }

    /* renamed from: a */
    public static C2496a m9478a(InputStream imageStream) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(imageStream, null, options);
        return new C2496a(options.outWidth, options.outHeight);
    }

    /* renamed from: a */
    public static int m9474a(C2496a srcSize, C2496a targetSize) {
        int width = srcSize.f8129a;
        int height = srcSize.f8130b;
        int reqWidth = targetSize.f8129a;
        int reqHeight = targetSize.f8130b;
        if (width <= reqWidth || height <= reqHeight) {
            return 1;
        }
        return Math.max(Math.round(((float) width) / ((float) reqWidth)), Math.round(((float) height) / ((float) reqHeight)));
    }

    /* renamed from: a */
    public static C2496a m9477a(View view) {
        C2496a imageSize = new C2496a();
        imageSize.f8129a = C2497a.m9480c(view);
        imageSize.f8130b = C2497a.m9479b(view);
        return imageSize;
    }

    /* renamed from: b */
    private static int m9479b(View view) {
        int height = 0;
        if (view == null) {
            return 0;
        }
        LayoutParams params = view.getLayoutParams();
        if (!(params == null || params.height == -2)) {
            height = view.getWidth();
        }
        if (height <= 0 && params != null) {
            height = params.height;
        }
        if (height <= 0) {
            height = C2497a.m9475a((Object) view, "mMaxHeight");
        }
        if (height <= 0) {
            height = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }

    /* renamed from: c */
    private static int m9480c(View view) {
        int width = 0;
        if (view == null) {
            return 0;
        }
        LayoutParams params = view.getLayoutParams();
        if (!(params == null || params.width == -2)) {
            width = view.getWidth();
        }
        if (width <= 0 && params != null) {
            width = params.width;
        }
        if (width <= 0) {
            width = C2497a.m9475a((Object) view, "mMaxWidth");
        }
        if (width <= 0) {
            width = view.getContext().getResources().getDisplayMetrics().widthPixels;
        }
        return width;
    }

    /* renamed from: a */
    private static int m9475a(Object object, String fieldName) {
        try {
            Field field = ImageView.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            int fieldValue = field.getInt(object);
            if (fieldValue <= 0 || fieldValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return fieldValue;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static Bitmap m9476a(String base64String) {
        byte[] bytes = Base64.decode(base64String, 0);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
