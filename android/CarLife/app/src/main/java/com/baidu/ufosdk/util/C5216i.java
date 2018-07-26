package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.ufosdk.p248b.C5170c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"SimpleDateFormat", "InlinedApi"})
/* compiled from: CommonUtil */
/* renamed from: com.baidu.ufosdk.util.i */
public final class C5216i {
    /* renamed from: a */
    private static SimpleDateFormat f21705a;

    /* renamed from: a */
    public static String m17760a(long j) {
        if (f21705a == null) {
            f21705a = new SimpleDateFormat("MM-dd HH:mm");
        }
        return f21705a.format(new Date(j));
    }

    /* renamed from: b */
    public static String m17766b(long j) {
        if (f21705a == null) {
            f21705a = new SimpleDateFormat("MM-dd HH:mm");
        }
        return f21705a.format(new Date(j)).split(" ")[1];
    }

    /* renamed from: c */
    public static String m17767c(long j) {
        if (j / 1000000000 > 0) {
            return (((float) (j / 100000000)) / 10.0f) + "G";
        } else if (j / 1000000 > 0) {
            return (((float) (j / 100000)) / 10.0f) + "M";
        } else if (j / 1000 <= 0) {
            return j + "B";
        } else {
            return (((float) (j / 100)) / 10.0f) + "K";
        }
    }

    /* renamed from: a */
    public static byte[] m17764a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr, 0, 16384);
            if (read == -1) {
                break;
            }
            try {
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable e) {
                C5210c.m17733a("stream2ByteArray fail", e);
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static int m17757a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* renamed from: a */
    public static void m17761a(Activity activity, String str, long j) {
        activity.runOnUiThread(new C5217j(activity, str, j));
    }

    /* renamed from: a */
    public static int m17758a(Context context, String str) {
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    /* renamed from: b */
    public static View m17765b(Context context, String str) {
        View relativeLayout = new RelativeLayout(context);
        View relativeLayout2 = new RelativeLayout(context);
        try {
            relativeLayout.setBackgroundDrawable(C5225r.m17786a(context, "ufo_loading_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        relativeLayout2.setLayoutParams(new LayoutParams(-2, -2));
        View progressBar = new ProgressBar(context);
        try {
            progressBar.setIndeterminateDrawable(new BitmapDrawable(C5223p.m17779a(context, "ufo_loading_icon.png")));
        } catch (Exception e2) {
        }
        Interpolator linearInterpolator = new LinearInterpolator();
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(linearInterpolator);
        progressBar.startAnimation(rotateAnimation);
        progressBar.setId(C0965R.array.space_catalog_name);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(C5216i.m17757a(context, 17.0f), C5216i.m17757a(context, 17.0f));
        layoutParams.addRule(15);
        layoutParams.setMargins(C5216i.m17757a(context, 3.0f), 0, 0, 0);
        relativeLayout2.addView(progressBar, layoutParams);
        View textView = new TextView(context);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(1, progressBar.getId());
        textView.setPadding(C5216i.m17757a(context, 5.0f), 0, C5216i.m17757a(context, 3.0f), 0);
        textView.setTextColor(-1);
        textView.setText(str);
        layoutParams2.addRule(15);
        relativeLayout2.addView(textView, layoutParams2);
        layoutParams = new LayoutParams(-2, -2);
        relativeLayout2.setPadding(C5216i.m17757a(context, 8.0f), C5216i.m17757a(context, 9.0f), C5216i.m17757a(context, 8.0f), C5216i.m17757a(context, 9.0f));
        layoutParams.addRule(15);
        relativeLayout.addView(relativeLayout2, layoutParams);
        return relativeLayout;
    }

    /* renamed from: a */
    public static void m17763a(RelativeLayout relativeLayout, String str) {
        int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = relativeLayout.getChildAt(i);
            if (childAt instanceof RelativeLayout) {
                C5216i.m17763a((RelativeLayout) childAt, str);
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setText(str);
            }
        }
    }

    /* renamed from: a */
    public static ColorStateList m17759a(int i, int i2, int i3, int i4) {
        int[] iArr = new int[]{i2, i3, i, i3, i4, i};
        int[][] iArr2 = new int[6][];
        iArr2[0] = new int[]{16842919, 16842910};
        iArr2[1] = new int[]{16842910, 16842908};
        iArr2[2] = new int[]{16842910};
        iArr2[3] = new int[]{16842908};
        iArr2[4] = new int[]{16842909};
        iArr2[5] = new int[0];
        return new ColorStateList(iArr2, iArr);
    }

    /* renamed from: a */
    public static int m17756a() {
        try {
            return VERSION.class.getField("SDK_INT").getInt(null);
        } catch (Exception e) {
            return Integer.parseInt(VERSION.SDK);
        }
    }

    /* renamed from: a */
    public static void m17762a(Context context, TextView textView) {
        if (context != null && textView != null) {
            Object obj;
            if (C5170c.m17557b(context).contains("UNKNOWN") || C5170c.m17557b(context).contains("NONE")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                textView.setText(C5228u.m17794a("19"));
            } else {
                textView.setText(C5228u.m17794a("18"));
            }
        }
    }
}
