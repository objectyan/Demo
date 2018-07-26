package com.baidu.ufosdk.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.baidu.ufosdk.C5167a;

/* compiled from: IconBitmap */
/* renamed from: com.baidu.ufosdk.util.p */
public final class C5223p {
    /* renamed from: a */
    public static byte[] m17782a(Context context) {
        byte[] bArr = null;
        try {
            bArr = C5216i.m17764a(context.getAssets().open("ufo_res/ufo_addpic_icon.png"));
        } catch (Throwable e) {
            C5210c.m17733a("bmpProblemIcon fail", e);
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m17783b(Context context) {
        byte[] bArr = null;
        try {
            bArr = C5216i.m17764a(context.getAssets().open("ufo_res/ufo_addpicplus_icon.png"));
        } catch (Throwable e) {
            C5210c.m17733a("bmpProblemIcon fail", e);
        }
        return bArr;
    }

    /* renamed from: c */
    public static Bitmap m17784c(Context context) {
        Bitmap bitmap = null;
        if (C5167a.f21359e != null) {
            return C5167a.f21359e;
        }
        try {
            byte[] a = C5216i.m17764a(context.getAssets().open("ufo_res/ufo_defult_me_icon.png"));
            return BitmapFactory.decodeByteArray(a, 0, a.length, null);
        } catch (Throwable e) {
            C5210c.m17733a("bmpProblemIcon fail", e);
            return bitmap;
        }
    }

    /* renamed from: a */
    public static Bitmap m17779a(Context context, String str) {
        Bitmap bitmap = null;
        try {
            byte[] a = C5216i.m17764a(context.getAssets().open("ufo_res/" + str));
            bitmap = BitmapFactory.decodeByteArray(a, 0, a.length, null);
        } catch (Throwable e) {
            C5210c.m17733a("bmpProblemIcon fail", e);
        }
        return bitmap;
    }

    /* renamed from: a */
    public static StateListDrawable m17780a(Context context, int i, String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable colorDrawable = new ColorDrawable(i);
        int[] iArr = new int[]{16842919};
        stateListDrawable.addState(iArr, new BitmapDrawable(C5223p.m17779a(context, str)));
        stateListDrawable.addState(new int[0], colorDrawable);
        return stateListDrawable;
    }

    /* renamed from: a */
    public static StateListDrawable m17781a(Context context, String str, String str2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        try {
            int[] iArr = new int[]{16842919};
            stateListDrawable.addState(iArr, C5225r.m17786a(context, str2));
            if (str != null) {
                stateListDrawable.addState(new int[0], C5225r.m17786a(context, str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stateListDrawable;
    }
}
