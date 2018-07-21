package com.baidu.ufosdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.ufosdk.ui.FeedbackFacePageActivity;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import com.baidu.ufosdk.ui.FeedbackListActivity;
import com.baidu.ufosdk.util.NativeClass;
import com.baidu.ufosdk.util.f;
import com.baidu.ufosdk.util.m;
import com.baidu.ufosdk.util.n;
import com.baidu.ufosdk.util.s;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class UfoSDK
{
  public static String appid;
  public static String clientid = "";
  public static boolean contactDialogSwitch;
  public static String devid;
  public static String firstServerText = "您好，请简要描述您的问题或建议";
  public static boolean hasRegistered;
  public static boolean isShowFeedbackBtn;
  public static boolean isUninstallFeedback;
  public static long lastSendTime;
  public static boolean localFirstCall;
  private static Context mApplication;
  public static boolean neverFeedback;
  public static String notSolvedReplyText;
  public static String productid;
  public static boolean robotAnswer;
  public static String solvedReplyText;
  
  static
  {
    appid = "";
    devid = "";
    productid = "";
    lastSendTime = -1L;
    robotAnswer = false;
    contactDialogSwitch = false;
    isUninstallFeedback = false;
    hasRegistered = false;
    isShowFeedbackBtn = false;
    notSolvedReplyText = "您的反馈已收到,我们会尽快跟进。";
    solvedReplyText = "您的肯定是我们继续努力的动力！感谢您对我们的支持！。";
  }
  
  public static void captureScreenAndFeedback(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    n.a(paramActivity).a(paramActivity, 0);
  }
  
  public static void captureScreenAndFeedback(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    n.a(paramActivity).a(paramActivity, paramInt);
  }
  
  public static void closeInputContactSwitch()
  {
    contactDialogSwitch = false;
  }
  
  public static void closeRobotAnswer()
  {
    robotAnswer = false;
  }
  
  public static HashMap getChineseMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("0", "找不到相册应用");
    localHashMap.put("1", "        继续描述您遇到的问题");
    localHashMap.put("2", "天以前");
    localHashMap.put("3", "删除");
    localHashMap.put("4", "删除中...");
    localHashMap.put("5", "反馈详情");
    localHashMap.put("6", "您好，请描述您遇到的问题...");
    localHashMap.put("7", "帮助和反馈");
    localHashMap.put("8", "热门问题");
    localHashMap.put("9", "小时以前");
    localHashMap.put("10", "我要反馈");
    localHashMap.put("11", "刚刚");
    localHashMap.put("12", "请输入反馈内容");
    localHashMap.put("13", "加载中");
    localHashMap.put("14", "分钟以前");
    localHashMap.put("15", "个月以前");
    localHashMap.put("16", "输入超过200字");
    localHashMap.put("17", "我的反馈");
    localHashMap.put("18", "网络中断，请检查网络配置");
    localHashMap.put("19", "网络不给力，请稍后再试");
    localHashMap.put("20", "您还没有反馈");
    localHashMap.put("21", "图片过大，请调整上传图片大小");
    localHashMap.put("22", "重新加载");
    localHashMap.put("23", "请重新加载网络");
    localHashMap.put("24", "发送");
    localHashMap.put("25", "发送中...");
    localHashMap.put("26", "谢谢支持");
    localHashMap.put("27", "字");
    localHashMap.put("28", "确认");
    localHashMap.put("29", "发送超时");
    localHashMap.put("30", "昨天");
    localHashMap.put("31", "选填：请留下您的邮箱/手机/QQ号");
    localHashMap.put("32", "不能超过10个字");
    return localHashMap;
  }
  
  public static Intent getFeedbackInputIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, FeedbackInputActivity.class);
    paramContext.putExtra("currentview", 1);
    return paramContext;
  }
  
  public static Intent getFeedbackInputIntent(Context paramContext, int paramInt)
  {
    paramContext = getFeedbackInputIntent(paramContext);
    paramContext.putExtra("feedback_channel", paramInt);
    return paramContext;
  }
  
  public static Intent getFeedbackInputIntent(Context paramContext, HashMap paramHashMap, int paramInt)
  {
    setExtraData(paramHashMap);
    return getFeedbackInputIntent(paramContext, paramInt);
  }
  
  public static Intent getFeedbackListIntent(Context paramContext)
  {
    return new Intent(paramContext, FeedbackListActivity.class);
  }
  
  public static Intent getFeedbackListIntent(Context paramContext, int paramInt)
  {
    paramContext = getFeedbackListIntent(paramContext);
    paramContext.putExtra("feedback_channel", paramInt);
    return paramContext;
  }
  
  public static Intent getFeedbackListIntent(Context paramContext, HashMap paramHashMap, int paramInt)
  {
    setExtraData(paramHashMap);
    return getFeedbackListIntent(paramContext, paramInt);
  }
  
  public static String getFeedbackNoticeFlag()
  {
    if (clientid.length() == 0) {
      return null;
    }
    if (localFirstCall)
    {
      localObject1 = getMyFeekackNum();
      if ((localObject1 != null) && (((String)localObject1).length() != 0) && (Integer.parseInt((String)localObject1) != 0))
      {
        neverFeedback = false;
        localObject1 = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("UfoNeverFeedback", false);
        ((SharedPreferences.Editor)localObject1).commit();
      }
      localFirstCall = false;
      localObject1 = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
      ((SharedPreferences.Editor)localObject1).putBoolean("UfoLocalFirstCall", false);
      ((SharedPreferences.Editor)localObject1).commit();
    }
    if (neverFeedback) {
      return null;
    }
    Object localObject1 = a.av;
    try
    {
      Object localObject2 = new HashMap();
      ((Map)localObject2).put("clientid", clientid);
      ((Map)localObject2).put("appid", appid);
      ((Map)localObject2).put("devid", devid);
      ((Map)localObject2).put("uid", a.b);
      ((Map)localObject2).put("interval", String.valueOf(a.ao));
      localObject2 = m.a(com.baidu.ufosdk.c.a.a((Map)localObject2));
      localObject1 = com.baidu.ufosdk.e.b.a((String)localObject1, "sdk_encrypt=" + URLEncoder.encode((String)localObject2, "UTF-8"));
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONObject(m.b((String)localObject1));
        if (((Integer)((JSONObject)localObject1).get("errno")).intValue() == 0)
        {
          localObject1 = String.valueOf(((JSONObject)localObject1).get("newmsg"));
          return (String)localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      com.baidu.ufosdk.util.c.a("sendRecord fail.", localException);
    }
    return null;
  }
  
  public static long getLastSendMessageTime()
  {
    return lastSendTime;
  }
  
  private static String getMyFeekackNum()
  {
    Object localObject1 = a.aw;
    try
    {
      Object localObject2 = new HashMap();
      ((Map)localObject2).put("clientid", clientid);
      ((Map)localObject2).put("appid", appid);
      ((Map)localObject2).put("devid", devid);
      ((Map)localObject2).put("uid", a.b);
      ((Map)localObject2).put("interval", String.valueOf(a.ao));
      localObject2 = m.a(com.baidu.ufosdk.c.a.a((Map)localObject2));
      localObject1 = com.baidu.ufosdk.e.b.a((String)localObject1, "sdk_encrypt=" + URLEncoder.encode((String)localObject2, "UTF-8"));
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONObject(m.b((String)localObject1));
        if (((Integer)((JSONObject)localObject1).get("errno")).intValue() == 0)
        {
          localObject1 = String.valueOf(((JSONObject)localObject1).get("msgnum"));
          return (String)localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      com.baidu.ufosdk.util.c.a("sendRecord fail.", localException);
    }
    return null;
  }
  
  private static String getNoticeFlag()
  {
    Object localObject1;
    if (clientid.length() == 0)
    {
      if (a.aj != null) {
        a.aj.getNoticeFlagResult(null);
      }
      localObject1 = null;
    }
    for (;;)
    {
      return (String)localObject1;
      if (localFirstCall)
      {
        localObject1 = getMyFeekackNum();
        if ((localObject1 != null) && (((String)localObject1).length() != 0) && (Integer.parseInt((String)localObject1) != 0))
        {
          neverFeedback = false;
          localObject1 = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
          ((SharedPreferences.Editor)localObject1).putBoolean("UfoNeverFeedback", false);
          ((SharedPreferences.Editor)localObject1).commit();
        }
        localFirstCall = false;
        localObject1 = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("UfoLocalFirstCall", false);
        ((SharedPreferences.Editor)localObject1).commit();
      }
      if (neverFeedback)
      {
        if (a.aj != null) {
          a.aj.getNoticeFlagResult(null);
        }
        return null;
      }
      localObject1 = a.av;
      try
      {
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("clientid", clientid);
        ((Map)localObject2).put("appid", appid);
        ((Map)localObject2).put("devid", devid);
        ((Map)localObject2).put("uid", a.b);
        ((Map)localObject2).put("interval", String.valueOf(a.ao));
        localObject2 = m.a(com.baidu.ufosdk.c.a.a((Map)localObject2));
        localObject1 = com.baidu.ufosdk.e.b.a((String)localObject1, "sdk_encrypt=" + URLEncoder.encode((String)localObject2, "UTF-8"));
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONObject(m.b((String)localObject1));
          if (((Integer)((JSONObject)localObject1).get("errno")).intValue() == 0)
          {
            localObject2 = String.valueOf(((JSONObject)localObject1).get("newmsg"));
            localObject1 = localObject2;
            if (a.aj == null) {
              continue;
            }
            a.aj.getNoticeFlagResult((String)localObject2);
            return (String)localObject2;
          }
        }
      }
      catch (Exception localException)
      {
        com.baidu.ufosdk.util.c.a("sendRecord fail.", localException);
        if (a.aj != null) {
          a.aj.getNoticeFlagResult(null);
        }
      }
    }
    return null;
  }
  
  public static void getNoticeFlagInThread()
  {
    new Thread(new d()).start();
  }
  
  public static Intent getStartFaqIntent(Context paramContext)
  {
    return new Intent(paramContext, FeedbackFacePageActivity.class);
  }
  
  public static Intent getStartFaqIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = getStartFaqIntent(paramContext);
    paramContext.putExtra("feedback_channel", paramInt1);
    paramContext.putExtra("faq_channel", paramInt2);
    return paramContext;
  }
  
  public static Intent getStartFaqIntent(Context paramContext, HashMap paramHashMap, int paramInt1, int paramInt2)
  {
    setExtraData(paramHashMap);
    return getStartFaqIntent(paramContext, paramInt1, paramInt2);
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null) {
      com.baidu.ufosdk.util.c.d("UfoSDK.init application is null.");
    }
    do
    {
      return;
      if (mApplication != null)
      {
        com.baidu.ufosdk.util.c.d("UfoSDK#init called more than once.");
        return;
      }
      Object localObject = paramContext.getApplicationContext();
      mApplication = (Context)localObject;
      s.a((Context)localObject);
      com.baidu.ufosdk.b.d.a(mApplication);
      a.ag = getChineseMap();
      localObject = mApplication.getSharedPreferences("UfoSharePreference", 0);
      if (localObject == null)
      {
        com.baidu.ufosdk.util.c.d("UfoSDK#sharepreference is null.");
        return;
      }
      clientid = ((SharedPreferences)localObject).getString("UfoClientId", "");
      appid = ((SharedPreferences)localObject).getString("UfoAppId", "");
      devid = ((SharedPreferences)localObject).getString("UfoDevId", "");
      productid = ((SharedPreferences)localObject).getString("UfoProductId", "");
      lastSendTime = ((SharedPreferences)localObject).getLong("Ufolastsendtime", -1L);
      neverFeedback = ((SharedPreferences)localObject).getBoolean("UfoNeverFeedback", true);
      localFirstCall = ((SharedPreferences)localObject).getBoolean("UfoLocalFirstCall", true);
      if (clientid.length() == 0)
      {
        new Thread(new b(paramContext)).start();
        return;
      }
    } while (!new com.baidu.ufosdk.util.d(mApplication).e());
    new Thread(new c()).start();
  }
  
  public static void isShowFeedbackBtn(boolean paramBoolean)
  {
    isShowFeedbackBtn = paramBoolean;
  }
  
  public static void openInputContactSwitch()
  {
    contactDialogSwitch = true;
  }
  
  public static void openLogcatSwitch()
  {
    a.a = true;
  }
  
  public static void openRobotAnswer()
  {
    robotAnswer = true;
  }
  
  public static boolean regUninstalledFeedback()
  {
    NativeClass localNativeClass = new NativeClass(mApplication);
    if (localNativeClass.loadUFONativeLib())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("a", "commonuninstall");
      localHashMap.put("uid", a.b);
      localHashMap.put("channel", "appsearch");
      localHashMap.put("appid", "210070");
      localHashMap.put("clientid", clientid);
      localHashMap.put("devid", devid);
      localNativeClass.init(com.baidu.ufosdk.b.d.a(), "http://ufosdk.baidu.com/?m=Client", localHashMap);
      return true;
    }
    return false;
  }
  
  public static void removeAllCache()
  {
    f.a();
    f.b();
  }
  
  public static void setBackTextSize(float paramFloat)
  {
    a.K = paramFloat;
  }
  
  public static void setBackbtnText(String paramString)
  {
    a.g = paramString;
  }
  
  public static void setBackbtnTextColor(int paramInt)
  {
    a.D = paramInt;
  }
  
  public static void setBaiduCuid(String paramString)
  {
    a.c = paramString;
  }
  
  public static void setChatThreadTime(int paramInt)
  {
    a.an = paramInt;
  }
  
  public static void setChatViewTextSize(float paramFloat)
  {
    a.P = paramFloat;
  }
  
  public static void setContactWayEnable(boolean paramBoolean)
  {
    a.p = paramBoolean;
  }
  
  public static void setCurrentUserIcon(Bitmap paramBitmap)
  {
    a.e = paramBitmap;
  }
  
  public static void setCurrentUserName(String paramString)
  {
    a.b = paramString;
  }
  
  public static void setCustomLocation(String paramString)
  {
    a.f = paramString;
  }
  
  public static void setCustomText(HashMap paramHashMap)
  {
    a.ag = paramHashMap;
  }
  
  public static void setEnglishMyFeedbackOffsetSize(float paramFloat)
  {
    a.ae = paramFloat;
  }
  
  public static void setExtraData(Map paramMap)
  {
    a.d = com.baidu.ufosdk.c.a.a(paramMap);
  }
  
  public static void setFeedBackUrl(String paramString)
  {
    a.ak = paramString;
  }
  
  public static void setFeedbackDetailsTextSize(float paramFloat)
  {
    a.L = paramFloat;
  }
  
  public static void setFeedbackInputHintTextSize(float paramFloat)
  {
    a.T = paramFloat;
  }
  
  public static void setFeedbackInputWordCountTextSize(float paramFloat)
  {
    a.U = paramFloat;
  }
  
  public static void setFeedbackPrefix(String paramString)
  {
    a.j = paramString;
  }
  
  public static void setFeedbackSubfix(String paramString)
  {
    a.k = paramString;
  }
  
  public static void setFirstServerText(String paramString)
  {
    firstServerText = paramString;
  }
  
  public static void setGetNoticeFlagCallBack(GetNoticeFlagCallBack paramGetNoticeFlagCallBack)
  {
    a.aj = paramGetNoticeFlagCallBack;
  }
  
  public static void setHotProblemTextSize(float paramFloat)
  {
    a.Q = paramFloat;
  }
  
  public static void setInputBootomBackgroundColor(int paramInt)
  {
    a.E = paramInt;
  }
  
  public static void setInternationalizationValid(boolean paramBoolean)
  {
    a.o = paramBoolean;
  }
  
  public static void setListBgColor(int paramInt)
  {
    a.z = paramInt;
  }
  
  public static void setListDeleteTextSize(float paramFloat)
  {
    a.ab = paramFloat;
  }
  
  public static void setListDividerColor(int paramInt)
  {
    a.C = paramInt;
  }
  
  public static void setListItemTextSize(float paramFloat)
  {
    a.aa = paramFloat;
  }
  
  public static void setListTimeTextColor(int paramInt)
  {
    a.B = paramInt;
  }
  
  public static void setListTimeTextSize(float paramFloat)
  {
    a.Y = paramFloat;
  }
  
  public static void setListTitleTextColor(int paramInt)
  {
    a.A = paramInt;
  }
  
  public static void setListTitleTextSize(float paramFloat)
  {
    a.W = paramFloat;
  }
  
  public static void setLogLevel(int paramInt)
  {
    a.m = paramInt;
  }
  
  public static void setMyFeedbackBtnTextSize(float paramFloat)
  {
    a.S = paramFloat;
  }
  
  public static void setNoHaveFeedbackTextSize(float paramFloat)
  {
    a.X = paramFloat;
  }
  
  public static void setNotSolvedReplyText(String paramString)
  {
    notSolvedReplyText = paramString;
  }
  
  public static void setPlaceholder(String paramString)
  {
    a.l = paramString;
  }
  
  public static void setReferer(String paramString)
  {
    a.n = paramString;
  }
  
  public static void setReloadBtnTextSize(float paramFloat)
  {
    a.N = paramFloat;
  }
  
  public static void setReloadTextSize(float paramFloat)
  {
    a.M = paramFloat;
  }
  
  public static void setResumeCallBack(ResumeCallBack paramResumeCallBack)
  {
    a.ah = paramResumeCallBack;
  }
  
  public static void setRightBtnTextColor(int paramInt)
  {
    a.t = paramInt;
  }
  
  public static void setRootBackgroundColor(int paramInt)
  {
    a.y = paramInt;
  }
  
  public static void setSearchProblemColor(int paramInt)
  {
    a.J = paramInt;
  }
  
  public static void setSearchProblemTextSize(float paramFloat)
  {
    a.ad = paramFloat;
  }
  
  public static void setSendBtnTextSize(float paramFloat)
  {
    a.V = paramFloat;
  }
  
  public static void setSentBtnTextColor(int paramInt)
  {
    a.w = paramInt;
  }
  
  public static void setSolvedReplyText(String paramString)
  {
    solvedReplyText = paramString;
  }
  
  public static void setSubmitMessageCallBack(SubmitMessageCallBack paramSubmitMessageCallBack)
  {
    a.ai = paramSubmitMessageCallBack;
  }
  
  public static void setTabBgTextColor(int paramInt)
  {
    a.v = paramInt;
  }
  
  public static void setTabCheckedStyle(int paramInt)
  {
    a.r = paramInt;
  }
  
  public static void setTabDefaultTextSize(float paramFloat)
  {
    a.ac = paramFloat;
  }
  
  public static void setTabDefultTextColor(int paramInt)
  {
    a.u = paramInt;
  }
  
  public static void setTimeViewTextSize(float paramFloat)
  {
    a.O = paramFloat;
  }
  
  public static void setTitleHelpAndFeedbackTextSize(float paramFloat)
  {
    a.R = paramFloat;
  }
  
  public static void setTitleTextColor(int paramInt)
  {
    a.s = paramInt;
  }
  
  public static void setToastShowTime(long paramLong)
  {
    a.q = paramLong;
  }
  
  public static void setToggleUpBgColor(int paramInt)
  {
    a.G = paramInt;
  }
  
  public static void setToggleUpTextColor(int paramInt)
  {
    a.I = paramInt;
  }
  
  public static void setUninstallFeedback(boolean paramBoolean)
  {
    isUninstallFeedback = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/UfoSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */