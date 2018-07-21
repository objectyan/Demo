package com.baidu.navi.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.utils.http.BaseHttpClient;
import com.baidu.navi.utils.http.BitmapRspHandler;
import com.baidu.navisdk.util.common.UserTask;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareTools
{
  public static final String APP_ID = "wxbc677c875691da4e";
  public static final String BUNDLE_KEY_CONTENT = "content";
  public static final String BUNDLE_KEY_CONTENTTYPE = "contentType";
  public static final String BUNDLE_KEY_DISTANCE = "distance";
  public static final String BUNDLE_KEY_DURATION = "duration";
  public static final String BUNDLE_KEY_FILEPATH = "filepath";
  public static final String BUNDLE_KEY_IMAGESOURCE = "imageSource";
  public static final String BUNDLE_KEY_IMG_URL = "img_url";
  public static final String BUNDLE_KEY_NAVTYPE = "nav_type";
  public static final String BUNDLE_KEY_ROUTE = "route";
  public static final String BUNDLE_KEY_SHARE_SHORT_URL = "share_short_url";
  public static final String BUNDLE_KEY_SHARE_URL = "share_url";
  public static final String BUNDLE_KEY_SPEED = "speed";
  public static final String BUNDLE_KEY_START_END = "nav_start_end";
  public static final String BUNDLE_KEY_STREET_SHORT_CONTENT = "bundle_key_street_short_content";
  public static final String BUNDLE_KEY_SUBJECT = "subject";
  public static final String BUNDLE_KEY_TITLE = "title";
  public static final String BUNDLE_KEY_TOTAL_STEP = "total_step";
  public static final String BUNDLE_KEY_WEIBO_FILEPATH = "weibo_filepath";
  public static final String BUNDLE_KEY_WEIXIN_FILEPATH = "weixin_filepath";
  private static final String CONSUMER_KEY = "3770889857";
  public static final String DEFAULT_MYLOC_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_myloc_wb.png";
  public static final String DEFAULT_MYLOC_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_myloc_wx.png";
  public static final String DEFAULT_NAV_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_route_wb.png";
  public static final String DEFAULT_NAV_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_route_wx.png";
  public static final String DEFAULT_POI_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_poi_wb.png";
  public static final String DEFAULT_POI_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_poi_wx.png";
  public static final String DEFAULT_STREET_WEIBO_IMG = "http://client.map.baidu.com/imap/cfg/static/share_street_wb.png";
  public static final String DEFAULT_STREET_WEIXIN_IMG = "http://client.map.baidu.com/imap/cfg/static/share_street_wx.png";
  private static final int ERROR_CODE_AUTHORIZE = 403;
  private static final int ERROR_CODE_REPEAT = 400;
  private static final float PROPORTION = 2.56F;
  private static final String REDIRECT_URL = "https://openapi.baidu.com/social/oauth/2.0/receiver";
  public static final String SHARE_TO_CAT_URL = "http://client.map.baidu.com/sendtocar/";
  public static final int SHARE_TYPE_HAPPINESS = 4;
  public static final int SHARE_TYPE_HEATMAP = 7;
  public static final int SHARE_TYPE_MYLOC = 3;
  public static final int SHARE_TYPE_NAV = 1;
  public static final int SHARE_TYPE_NEWS = 8;
  public static final int SHARE_TYPE_POI = 2;
  public static final int SHARE_TYPE_STREETSCAPE = 5;
  public static final int SHARE_TYPE_VOICES = 9;
  private static final int STREET_WB_HEIGHT = 250;
  private static final int STREET_WB_WIDTH = 460;
  private static final int TYPE_WEIXIN = 0;
  private static final int TYPE_WEIXIN_TIMELINE = 1;
  private static final int WB_IMG_HEIGHT = 118;
  private static final int WB_IMG_WIDTH = 302;
  private static final int WEIXIN_THUMB_SIZE = 150;
  private int TYPE_NON_STREET = 0;
  private int TYPE_STREET_WEIBO = 1;
  private int TYPE_STREET_WEIXIN = 2;
  private Bitmap mBitmap = null;
  private Context mContext;
  private PackageManager mPkgManager = null;
  private ProgressDialog mProgressDialog = null;
  private List<ResolveInfo> mResolveInfos = null;
  private Bundle mShareBundle;
  private int mShareType = 0;
  private String[] mmsPackage = new String[2];
  
  public ShareTools(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mPkgManager = this.mContext.getPackageManager();
    this.mShareType = paramInt;
  }
  
  private void UrlBitmap(final String paramString, final UrlBitmapListener paramUrlBitmapListener)
  {
    this.mProgressDialog = ProgressDialog.show(this.mContext, null, "准备分享", true);
    this.mProgressDialog.setCancelable(true);
    new UserTask()
    {
      Bitmap mBmp;
      
      public Bitmap doInBackground(String... paramAnonymousVarArgs)
      {
        new BaseHttpClient().get(paramString, new BitmapRspHandler()
        {
          public void onFailure(Throwable paramAnonymous2Throwable)
          {
            ShareTools.2.this.mBmp = StyleManager.getBitmap(2130838698);
          }
          
          public void onRevBitmap(Bitmap paramAnonymous2Bitmap)
          {
            ShareTools.2.this.mBmp = paramAnonymous2Bitmap;
          }
        });
        return this.mBmp;
      }
      
      public void onPostExecute(Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap != null) {
          paramUrlBitmapListener.onUrlBitmapLoadSucess(paramAnonymousBitmap);
        }
      }
    }.execute(new String[] { "" });
  }
  
  private void authorizeSinaWeibo() {}
  
  private void autoPutDefaultImageUrlWithBundle(String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      int i = 0;
      if (!paramBundle.containsKey(paramString1)) {
        i = 1;
      }
      while (i != 0)
      {
        paramBundle.putString(paramString1, paramString2);
        return;
        if (TextUtils.isEmpty(paramBundle.getString(paramString1))) {
          i = 1;
        }
      }
    } while (paramInt == this.TYPE_NON_STREET);
    String str = paramBundle.getString(paramString1);
    if (paramInt == this.TYPE_STREET_WEIBO) {
      paramString2 = str + "&width=460&height=250";
    }
    for (;;)
    {
      paramBundle.putString(paramString1, paramString2);
      return;
      paramString2 = str;
      if (paramInt == this.TYPE_STREET_WEIXIN) {
        paramString2 = str + "&width=150&height=150";
      }
    }
  }
  
  private byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int m = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    int i;
    if ((m > j) && (m > 400))
    {
      i = 400;
      j = j * 400 / m;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, j, i, false);
      localBitmap.compress(Bitmap.CompressFormat.PNG, 60, localByteArrayOutputStream);
      i = 60 - 10;
      do
      {
        if (localByteArrayOutputStream.toByteArray().length <= paramInt) {
          break;
        }
        localByteArrayOutputStream.reset();
        localBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
        j = i - 10;
        i = j;
      } while (j >= 0);
      if (paramBoolean) {
        paramBitmap.recycle();
      }
      localBitmap.recycle();
      paramBitmap = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        return null;
      }
      if ((j > m) && (j > 400))
      {
        int k = 400;
        i = m * 400 / j;
        j = k;
      }
      else
      {
        i = m;
      }
    }
  }
  
  private String buildWeixinTransaction(String paramString)
  {
    if (paramString == null) {
      return String.valueOf(System.currentTimeMillis());
    }
    return paramString + System.currentTimeMillis();
  }
  
  private String formatRoute(String paramString)
  {
    if (paramString.length() > 8) {
      return paramString.substring(0, 7) + "...";
    }
    return "";
  }
  
  private void getMmsInfo(String paramString)
  {
    Object localObject = new Intent("android.intent.action.SEND");
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    if ((paramString != null) && (paramString.length() != 0))
    {
      ((Intent)localObject).setType("image/png");
      this.mResolveInfos = this.mPkgManager.queryIntentActivities((Intent)localObject, 65536);
      paramString = this.mResolveInfos.iterator();
      while (paramString.hasNext())
      {
        localObject = (ResolveInfo)paramString.next();
        if ("com.android.mms".equals(((ResolveInfo)localObject).activityInfo.packageName)) {
          this.mmsPackage[0] = ((ResolveInfo)localObject).activityInfo.packageName;
        }
      }
    }
    do
    {
      this.mmsPackage[1] = ((ResolveInfo)localObject).activityInfo.name;
      return;
      while (!paramString.hasNext())
      {
        ((Intent)localObject).setType("text/plain");
        break;
        paramString = this.mResolveInfos.iterator();
      }
      localObject = (ResolveInfo)paramString.next();
    } while ((!((ResolveInfo)localObject).activityInfo.name.equalsIgnoreCase("com.android.mms.ui.ComposeMessageActivity")) && (!((ResolveInfo)localObject).activityInfo.name.equalsIgnoreCase("com.dataviz.stargate.MessageEditView")) && (!((ResolveInfo)localObject).activityInfo.name.contains("Message")) && (!((ResolveInfo)localObject).activityInfo.name.contains("com.android.mms")) && (!((ResolveInfo)localObject).activityInfo.packageName.contains("com.google.android.talk")));
    this.mmsPackage[0] = ((ResolveInfo)localObject).activityInfo.packageName;
    this.mmsPackage[1] = ((ResolveInfo)localObject).activityInfo.name;
  }
  
  private Boolean hasCurApp(Bundle paramBundle, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.addCategory("android.intent.category.DEFAULT");
    paramBundle = paramBundle.getString("filepath");
    int i;
    if ((paramBundle != null) && (paramBundle.length() != 0))
    {
      localIntent.setType("image/png");
      this.mResolveInfos = this.mPkgManager.queryIntentActivities(localIntent, 65536);
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mResolveInfos.size()) {
        break label135;
      }
      paramBundle = ((ResolveInfo)this.mResolveInfos.get(i)).activityInfo.packageName;
      if ((paramBundle != null) && (paramBundle.startsWith(paramString)))
      {
        return Boolean.valueOf(true);
        localIntent.setType("text/plain");
        break;
      }
      i += 1;
    }
    label135:
    return Boolean.valueOf(false);
  }
  
  private void preSendWeixinMsg(final Bundle paramBundle, final int paramInt)
  {
    switch (this.mShareType)
    {
    }
    while (9 == this.mShareType)
    {
      UrlBitmap(paramBundle.getString("img_url"), new UrlBitmapListener()
      {
        public void onUrlBitmapLoadSucess(Bitmap paramAnonymousBitmap)
        {
          if ((ShareTools.this.mProgressDialog != null) && (ShareTools.this.mProgressDialog.isShowing()))
          {
            ShareTools.this.mProgressDialog.cancel();
            ShareTools.access$002(ShareTools.this, null);
            ShareTools.access$102(ShareTools.this, paramAnonymousBitmap);
            ShareTools.this.sendWeixinMsg(paramBundle, paramInt, ShareTools.this.mBitmap);
          }
        }
      });
      return;
      paramBundle.putString("img_url", "http://client.map.baidu.com/imap/cfg/static/share_poi_wx.png");
      this.mBitmap = StyleManager.getBitmap(2130838698);
      continue;
      paramBundle.putString("img_url", "http://client.map.baidu.com/imap/cfg/static/share_route_wx.png");
      continue;
      paramBundle.putString("img_url", "http://client.map.baidu.com/imap/cfg/static/share_myloc_wx.png");
      continue;
      paramBundle.putString("img_url", "http://client.map.baidu.com/imap/cfg/static/share_myloc_wx.png");
      Object localObject = paramBundle.getString("filepath");
      String str = paramBundle.getString("weixin_filepath");
      if (!TextUtils.isEmpty(str)) {
        localObject = str;
      }
      if ((localObject != null) && (((String)localObject).startsWith("file:/")))
      {
        localObject = BitmapFactory.decodeFile(((String)localObject).replace("file:/", ""));
        if (localObject != null)
        {
          sendWeixinMsg(paramBundle, paramInt, (Bitmap)localObject);
          return;
          autoPutDefaultImageUrlWithBundle("img_url", "http://client.map.baidu.com/imap/cfg/static/share_street_wx.png", paramBundle, this.TYPE_STREET_WEIXIN);
          continue;
          this.mBitmap = StyleManager.getBitmap(2130838698);
        }
      }
    }
    sendWeixinMsg(paramBundle, paramInt, this.mBitmap);
  }
  
  private void sendWeixinMsg(Bundle paramBundle, int paramInt, Bitmap paramBitmap) {}
  
  private void setTextStyle(Bundle paramBundle)
  {
    paramBundle.putString("content", paramBundle.getString("content").replace(65292, '\n'));
  }
  
  private void shareToSinaWeibo(Bundle paramBundle) {}
  
  private void shareToSms(Bundle paramBundle)
  {
    setTextStyle(paramBundle);
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.SUBJECT", paramBundle.getString("subject"));
    String str2 = paramBundle.getString("content");
    String str1;
    if ((this.mShareType == 7) && (!TextUtils.isEmpty(paramBundle.getString("share_url"))))
    {
      str1 = paramBundle.getString("subject") + "--" + str2 + paramBundle.getString("share_url");
      localIntent.putExtra("android.intent.extra.TEXT", str1);
      localIntent.putExtra("sms_body", str1);
      str1 = paramBundle.getString("filepath");
      if ((str1 == null) || (!str1.startsWith("file:/"))) {
        break label315;
      }
      paramBundle = str1.replace("file:/", "");
      label150:
      if ((paramBundle == null) || (paramBundle.length() <= 0)) {
        break label332;
      }
      paramBundle = new File(paramBundle);
      if (!paramBundle.exists()) {
        break label320;
      }
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramBundle));
      localIntent.setType("image/jpeg");
    }
    for (;;)
    {
      getMmsInfo(str1);
      if (this.mmsPackage[0] != null) {
        localIntent.setComponent(new ComponentName(this.mmsPackage[0], this.mmsPackage[1]));
      }
      try
      {
        this.mContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramBundle) {}
      str1 = str2;
      if (this.mShareType != 8) {
        break;
      }
      str1 = str2;
      if (TextUtils.isEmpty(paramBundle.getString("share_short_url"))) {
        break;
      }
      str1 = paramBundle.getString("subject") + "--" + str2 + paramBundle.getString("share_short_url");
      break;
      label315:
      paramBundle = str1;
      break label150;
      label320:
      localIntent.setType("text/plain");
      continue;
      label332:
      localIntent.setType("text/plain");
    }
  }
  
  private void shareToWeixin(Bundle paramBundle)
  {
    preSendWeixinMsg(paramBundle, 0);
  }
  
  private void shareToWeixinTimeline(Bundle paramBundle)
  {
    preSendWeixinMsg(paramBundle, 1);
  }
  
  private Bitmap small(Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(0.5F, 0.5F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public Bitmap getmBitmap()
  {
    return this.mBitmap;
  }
  
  public void onSinaAuthorizeCallback(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void setmBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = small(paramBitmap);
  }
  
  public void share(Bundle paramBundle)
  {
    if (((Activity)this.mContext).isFinishing()) {
      return;
    }
    new ArrayList().add(paramBundle);
  }
  
  public void share(List<Bundle> paramList)
  {
    if (((Activity)this.mContext).isFinishing()) {}
  }
  
  public static class AccessTokenKeeper
  {
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";
    
    public static void clear(Context paramContext)
    {
      paramContext = paramContext.getSharedPreferences("com_weibo_sdk_android", 32768).edit();
      paramContext.clear();
      paramContext.commit();
    }
  }
  
  private static abstract interface UrlBitmapListener
  {
    public abstract void onUrlBitmapLoadSucess(Bitmap paramBitmap);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/util/ShareTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */