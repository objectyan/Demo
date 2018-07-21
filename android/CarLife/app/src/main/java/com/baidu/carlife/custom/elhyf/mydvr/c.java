package com.baidu.carlife.custom.elhyf.mydvr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.baidu.carlife.util.w;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class c
{
  public static final String a = "wxecea17450eadc380";
  private static final int b = 553779201;
  private static final int c = 100;
  private static c f;
  private Context d;
  private IWXAPI e;
  
  public static c a()
  {
    if (f == null) {
      f = new c();
    }
    return f;
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  private void a(WXImageObject paramWXImageObject, Bitmap paramBitmap, a parama)
  {
    int i = 1;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = paramWXImageObject;
    paramWXImageObject = Bitmap.createScaledBitmap(paramBitmap, 100, 100, true);
    paramBitmap.recycle();
    localWXMediaMessage.thumbData = a(paramWXImageObject, true);
    paramWXImageObject = new SendMessageToWX.Req();
    paramWXImageObject.transaction = a("img");
    paramWXImageObject.message = localWXMediaMessage;
    if (parama == a.a) {
      i = 0;
    }
    paramWXImageObject.scene = i;
    this.e.sendReq(paramWXImageObject);
  }
  
  private byte[] a(Bitmap paramBitmap, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramBitmap;
  }
  
  private boolean b()
  {
    if (this.e.isWXAppInstalled()) {
      return true;
    }
    w.a(this.d.getString(2131298972), 1);
    return false;
  }
  
  private boolean c()
  {
    if (this.e.getWXAppSupportAPI() >= 553779201) {
      return true;
    }
    w.a(this.d.getString(2131298971), 1);
    return false;
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
    this.e = WXAPIFactory.createWXAPI(paramContext, "wxecea17450eadc380", true);
    this.e.registerApp("wxecea17450eadc380");
  }
  
  public void a(Bitmap paramBitmap, a parama)
  {
    if (!b()) {}
    while ((parama == a.b) && (!c())) {
      return;
    }
    a(new WXImageObject(paramBitmap), paramBitmap, parama);
  }
  
  public void a(String paramString, a parama)
  {
    if (!b()) {}
    while ((parama == a.b) && (!c())) {
      return;
    }
    if (!new File(paramString).exists())
    {
      w.a(this.d.getString(2131298968), 1);
      return;
    }
    WXImageObject localWXImageObject = new WXImageObject();
    localWXImageObject.setImagePath(paramString);
    a(localWXImageObject, BitmapFactory.decodeFile(paramString), parama);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/mydvr/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */