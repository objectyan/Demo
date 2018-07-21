package com.baidu.ufosdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"SimpleDateFormat", "InlinedApi"})
public final class i
{
  private static SimpleDateFormat a;
  
  public static int a()
  {
    try
    {
      int i = Build.VERSION.class.getField("SDK_INT").getInt(null);
      return i;
    }
    catch (Exception localException) {}
    return Integer.parseInt(Build.VERSION.SDK);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "anim", paramContext.getPackageName());
  }
  
  public static ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842910, 16842908 };
    int[] arrayOfInt2 = { 16842908 };
    int[] arrayOfInt3 = new int[0];
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, arrayOfInt1, { 16842910 }, arrayOfInt2, { 16842909 }, arrayOfInt3 }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  public static String a(long paramLong)
  {
    if (a == null) {
      a = new SimpleDateFormat("MM-dd HH:mm");
    }
    return a.format(new Date(paramLong));
  }
  
  public static void a(Activity paramActivity, String paramString, long paramLong)
  {
    paramActivity.runOnUiThread(new j(paramActivity, paramString, paramLong));
  }
  
  public static void a(Context paramContext, TextView paramTextView)
  {
    if ((paramContext == null) || (paramTextView == null)) {
      return;
    }
    if ((com.baidu.ufosdk.b.c.b(paramContext).contains("UNKNOWN")) || (com.baidu.ufosdk.b.c.b(paramContext).contains("NONE"))) {}
    for (int i = 0; i != 0; i = 1)
    {
      paramTextView.setText(u.a("19"));
      return;
    }
    paramTextView.setText(u.a("18"));
  }
  
  public static void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    int j = paramRelativeLayout.getChildCount();
    int i = 0;
    if (i >= j) {
      return;
    }
    View localView = paramRelativeLayout.getChildAt(i);
    if ((localView instanceof RelativeLayout)) {
      a((RelativeLayout)localView, paramString);
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localView instanceof TextView)) {
        ((TextView)localView).setText(paramString);
      }
    }
  }
  
  public static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['䀀'];
    for (;;)
    {
      try
      {
        i = paramInputStream.read(arrayOfByte, 0, 16384);
        if (i != -1) {
          continue;
        }
        localByteArrayOutputStream.flush();
      }
      catch (IOException paramInputStream)
      {
        int i;
        c.a("stream2ByteArray fail", paramInputStream);
        continue;
      }
      return localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static View b(Context paramContext, String paramString)
  {
    RelativeLayout localRelativeLayout1 = new RelativeLayout(paramContext);
    RelativeLayout localRelativeLayout2 = new RelativeLayout(paramContext);
    try
    {
      localRelativeLayout1.setBackgroundDrawable(r.a(paramContext, "ufo_loading_bg.9.png"));
      localRelativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      localProgressBar = new ProgressBar(paramContext);
    }
    catch (Exception localException1)
    {
      try
      {
        ProgressBar localProgressBar;
        localProgressBar.setIndeterminateDrawable(new BitmapDrawable(p.a(paramContext, "ufo_loading_icon.png")));
        Object localObject1 = new LinearInterpolator();
        Object localObject2 = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject2).setDuration(1000L);
        ((Animation)localObject2).setRepeatCount(-1);
        ((Animation)localObject2).setRepeatCount(-1);
        ((Animation)localObject2).setInterpolator((Interpolator)localObject1);
        localProgressBar.startAnimation((Animation)localObject2);
        localProgressBar.setId(2131230771);
        localObject1 = new RelativeLayout.LayoutParams(a(paramContext, 17.0F), a(paramContext, 17.0F));
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(a(paramContext, 3.0F), 0, 0, 0);
        localRelativeLayout2.addView(localProgressBar, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new TextView(paramContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(1, localProgressBar.getId());
        ((TextView)localObject1).setPadding(a(paramContext, 5.0F), 0, a(paramContext, 3.0F), 0);
        ((TextView)localObject1).setTextColor(-1);
        ((TextView)localObject1).setText(paramString);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        localRelativeLayout2.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        localRelativeLayout2.setPadding(a(paramContext, 8.0F), a(paramContext, 9.0F), a(paramContext, 8.0F), a(paramContext, 9.0F));
        paramString.addRule(15);
        localRelativeLayout1.addView(localRelativeLayout2, paramString);
        return localRelativeLayout1;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public static String b(long paramLong)
  {
    if (a == null) {
      a = new SimpleDateFormat("MM-dd HH:mm");
    }
    return a.format(new Date(paramLong)).split(" ")[1];
  }
  
  public static String c(long paramLong)
  {
    if (paramLong / 1000000000L > 0L)
    {
      paramLong /= 100000000L;
      return (float)paramLong / 10.0F + "G";
    }
    if (paramLong / 1000000L > 0L)
    {
      paramLong /= 100000L;
      return (float)paramLong / 10.0F + "M";
    }
    if (paramLong / 1000L > 0L)
    {
      paramLong /= 100L;
      return (float)paramLong / 10.0F + "K";
    }
    return paramLong + "B";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */