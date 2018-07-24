package com.baidu.carlife.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* compiled from: ImageUtils */
/* renamed from: com.baidu.carlife.util.j */
public class C2179j {
    /* renamed from: a */
    private static final int f6970a = 200;
    /* renamed from: b */
    private static final int f6971b = 20;

    /* renamed from: a */
    public static Bitmap m8279a(Context context, Bitmap bitmap) {
        int bmpWidth = bitmap.getWidth();
        int bmpHeight = bitmap.getHeight();
        int maxEdge = Math.max(bmpWidth, bmpHeight);
        if (maxEdge > 200) {
            float scale = (((float) maxEdge) * 1.0f) / 200.0f;
            bmpWidth = (int) (((float) bmpWidth) / scale);
            bmpHeight = (int) (((float) bmpHeight) / scale);
        }
        Bitmap inputBitmap = Bitmap.createScaledBitmap(bitmap, bmpWidth, bmpHeight, false);
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);
        RenderScript renderScript = RenderScript.create(context);
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        Allocation tmpIn = Allocation.createFromBitmap(renderScript, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);
        blurScript.setRadius(20.0f);
        blurScript.setInput(tmpIn);
        blurScript.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }
}
