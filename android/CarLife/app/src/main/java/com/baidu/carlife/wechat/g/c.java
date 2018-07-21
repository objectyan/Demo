package com.baidu.carlife.wechat.g;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.util.DisplayMetrics;
import com.baidu.carlife.core.a;
import com.baidu.carlife.wechat.b.d;
import com.baidu.carlife.wechat.b.e;
import com.baidu.carlife.wechat.b.f;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int i = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawCircle(i / 2, i / 2, i / 2, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    return Bitmap.createBitmap(paramBitmap, (int)(i - i * paramFloat) / 2, (int)(j - j * paramFloat) / 2, (int)(i * paramFloat), (int)(j * paramFloat));
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = new Hashtable();
        ((Hashtable)localObject).put(EncodeHintType.CHARACTER_SET, "utf-8");
        localObject = new QRCodeWriter().encode(paramString, BarcodeFormat.QR_CODE, paramInt1, paramInt2, (Map)localObject);
        i = ((BitMatrix)localObject).getWidth();
        j = ((BitMatrix)localObject).getHeight();
        paramString = new int[i * j];
        paramInt1 = 0;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if (paramInt2 < i)
      {
        if (((BitMatrix)localObject).get(paramInt2, paramInt1)) {
          paramString[(paramInt1 * i + paramInt2)] = -230341307;
        } else {
          paramString[(paramInt1 * i + paramInt2)] = -1;
        }
      }
      else
      {
        paramInt1 += 1;
        while (paramInt1 >= j)
        {
          localObject = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
          ((Bitmap)localObject).setPixels(paramString, 0, i, 0, 0, i, j);
          return (Bitmap)localObject;
        }
        paramInt2 = 0;
        continue;
      }
      paramInt2 += 1;
    }
  }
  
  public static String a()
  {
    return System.currentTimeMillis() + "0" + (new Random().nextInt(900) + 100);
  }
  
  public static String a(d paramd)
  {
    if (paramd.i() != null) {
      return "[位置]" + paramd.i().a();
    }
    if (paramd.h() != null) {
      return "[音乐分享] " + Html.fromHtml(paramd.h().b()) + " : " + Html.fromHtml(paramd.h().a());
    }
    int i = paramd.b();
    paramd = paramd.f();
    switch (i)
    {
    default: 
      return paramd;
    case 1: 
      return paramd;
    case 3: 
      return "[图片消息，请在手机上查看]";
    case 34: 
      return "[语音]";
    case 42: 
      return "[名片消息，请在手机上查看]";
    case 47: 
      return "[动画表情，请在手机上查看]";
    case 43: 
    case 62: 
      return "[视频消息，请在手机上查看]";
    }
    return paramd;
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {
      return Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if (!a(paramActivity, paramString)) {
      ActivityCompat.requestPermissions(paramActivity, new String[] { paramString }, paramInt);
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (ContextCompat.checkSelfPermission(paramContext, paramString) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.baidu.carlife.wechat.a.b.c.c(paramString + "  " + bool);
      return bool;
    }
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight()), paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public static String b()
  {
    String str2 = String.valueOf((1.0D + new Random().nextDouble()) * Math.pow(10.0D, 15.0D));
    String str1 = "";
    if (str2.length() >= 17) {
      str1 = str2.substring(2, 17);
    }
    return "e" + str1;
  }
  
  public static float c()
  {
    return a.a().getResources().getDisplayMetrics().density;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/wechat/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */