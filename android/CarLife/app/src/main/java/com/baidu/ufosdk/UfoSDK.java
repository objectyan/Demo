package com.baidu.ufosdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.carlife.radio.p079c.C2142b;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.mobstat.Config;
import com.baidu.navi.track.sync.SyncChannelConstant.Key;
import com.baidu.navisdk.util.statistic.PerformStatItem;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.ufosdk.p248b.C5171d;
import com.baidu.ufosdk.p249c.C5174a;
import com.baidu.ufosdk.p251e.C5181b;
import com.baidu.ufosdk.ui.FeedbackFacePageActivity;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import com.baidu.ufosdk.ui.FeedbackListActivity;
import com.baidu.ufosdk.util.C5210c;
import com.baidu.ufosdk.util.C5211d;
import com.baidu.ufosdk.util.C5213f;
import com.baidu.ufosdk.util.C5220m;
import com.baidu.ufosdk.util.C5221n;
import com.baidu.ufosdk.util.C5226s;
import com.baidu.ufosdk.util.NativeClass;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class UfoSDK {
    public static String appid = "";
    public static String clientid = "";
    public static boolean contactDialogSwitch = false;
    public static String devid = "";
    public static String firstServerText = "您好，请简要描述您的问题或建议";
    public static boolean hasRegistered = false;
    public static boolean isShowFeedbackBtn = false;
    public static boolean isUninstallFeedback = false;
    public static long lastSendTime = -1;
    public static boolean localFirstCall;
    private static Context mApplication;
    public static boolean neverFeedback;
    public static String notSolvedReplyText = "您的反馈已收到,我们会尽快跟进。";
    public static String productid = "";
    public static boolean robotAnswer = false;
    public static String solvedReplyText = "您的肯定是我们继续努力的动力！感谢您对我们的支持！。";

    public static HashMap getChineseMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("0", "找不到相册应用");
        hashMap.put("1", "        继续描述您遇到的问题");
        hashMap.put("2", "天以前");
        hashMap.put("3", "删除");
        hashMap.put("4", "删除中...");
        hashMap.put("5", "反馈详情");
        hashMap.put(C2578b.f8568g, "您好，请描述您遇到的问题...");
        hashMap.put("7", "帮助和反馈");
        hashMap.put(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL, "热门问题");
        hashMap.put("9", "小时以前");
        hashMap.put(C2142b.f6818b, "我要反馈");
        hashMap.put("11", "刚刚");
        hashMap.put(PerformStatItem.DATA_HANDLE_AFTER_LIGHT_STEP_INDEX, "请输入反馈内容");
        hashMap.put("13", "加载中");
        hashMap.put("14", "分钟以前");
        hashMap.put("15", "个月以前");
        hashMap.put("16", "输入超过200字");
        hashMap.put(PerformStatItem.RP_SUCCESS_NORMAL_STEP_INDEX, "我的反馈");
        hashMap.put("18", "网络中断，请检查网络配置");
        hashMap.put("19", "网络不给力，请稍后再试");
        hashMap.put("20", "您还没有反馈");
        hashMap.put("21", "图片过大，请调整上传图片大小");
        hashMap.put("22", "重新加载");
        hashMap.put("23", "请重新加载网络");
        hashMap.put("24", "发送");
        hashMap.put("25", "发送中...");
        hashMap.put("26", "谢谢支持");
        hashMap.put("27", "字");
        hashMap.put("28", "确认");
        hashMap.put("29", "发送超时");
        hashMap.put("30", "昨天");
        hashMap.put("31", "选填：请留下您的邮箱/手机/QQ号");
        hashMap.put("32", "不能超过10个字");
        return hashMap;
    }

    public static void init(Context context) {
        if (context == null) {
            C5210c.m17736d("UfoSDK.init application is null.");
        } else if (mApplication != null) {
            C5210c.m17736d("UfoSDK#init called more than once.");
        } else {
            Context applicationContext = context.getApplicationContext();
            mApplication = applicationContext;
            C5226s.m17791a(applicationContext);
            C5171d.m17559a(mApplication);
            C5167a.ag = getChineseMap();
            SharedPreferences sharedPreferences = mApplication.getSharedPreferences("UfoSharePreference", 0);
            if (sharedPreferences == null) {
                C5210c.m17736d("UfoSDK#sharepreference is null.");
                return;
            }
            clientid = sharedPreferences.getString("UfoClientId", "");
            appid = sharedPreferences.getString("UfoAppId", "");
            devid = sharedPreferences.getString("UfoDevId", "");
            productid = sharedPreferences.getString("UfoProductId", "");
            lastSendTime = sharedPreferences.getLong("Ufolastsendtime", -1);
            neverFeedback = sharedPreferences.getBoolean("UfoNeverFeedback", true);
            localFirstCall = sharedPreferences.getBoolean("UfoLocalFirstCall", true);
            if (clientid.length() == 0) {
                new Thread(new C5173b(context)).start();
            } else if (new C5211d(mApplication).m17747e()) {
                new Thread(new C5175c()).start();
            }
        }
    }

    public static void isShowFeedbackBtn(boolean z) {
        isShowFeedbackBtn = z;
    }

    public static void setNotSolvedReplyText(String str) {
        notSolvedReplyText = str;
    }

    public static void setSolvedReplyText(String str) {
        solvedReplyText = str;
    }

    public static void setFirstServerText(String str) {
        firstServerText = str;
    }

    public static Intent getFeedbackListIntent(Context context) {
        return new Intent(context, FeedbackListActivity.class);
    }

    public static Intent getFeedbackListIntent(Context context, int i) {
        Intent feedbackListIntent = getFeedbackListIntent(context);
        feedbackListIntent.putExtra("feedback_channel", i);
        return feedbackListIntent;
    }

    public static Intent getFeedbackListIntent(Context context, HashMap hashMap, int i) {
        setExtraData(hashMap);
        return getFeedbackListIntent(context, i);
    }

    public static Intent getStartFaqIntent(Context context) {
        return new Intent(context, FeedbackFacePageActivity.class);
    }

    public static Intent getStartFaqIntent(Context context, int i, int i2) {
        Intent startFaqIntent = getStartFaqIntent(context);
        startFaqIntent.putExtra("feedback_channel", i);
        startFaqIntent.putExtra("faq_channel", i2);
        return startFaqIntent;
    }

    public static Intent getStartFaqIntent(Context context, HashMap hashMap, int i, int i2) {
        setExtraData(hashMap);
        return getStartFaqIntent(context, i, i2);
    }

    public static Intent getFeedbackInputIntent(Context context) {
        Intent intent = new Intent(context, FeedbackInputActivity.class);
        intent.putExtra("currentview", 1);
        return intent;
    }

    public static Intent getFeedbackInputIntent(Context context, int i) {
        Intent feedbackInputIntent = getFeedbackInputIntent(context);
        feedbackInputIntent.putExtra("feedback_channel", i);
        return feedbackInputIntent;
    }

    public static Intent getFeedbackInputIntent(Context context, HashMap hashMap, int i) {
        setExtraData(hashMap);
        return getFeedbackInputIntent(context, i);
    }

    public static void captureScreenAndFeedback(Activity activity) {
        if (activity != null) {
            C5221n.m17776a((Context) activity).m17778a(activity, 0);
        }
    }

    public static void captureScreenAndFeedback(Activity activity, int i) {
        if (activity != null) {
            C5221n.m17776a((Context) activity).m17778a(activity, i);
        }
    }

    public static long getLastSendMessageTime() {
        return lastSendTime;
    }

    public static void removeAllCache() {
        C5213f.m17749a();
        C5213f.m17751b();
    }

    public static void setCurrentUserName(String str) {
        C5167a.f21356b = str;
    }

    public static void setInternationalizationValid(boolean z) {
        C5167a.f21369o = z;
    }

    public static void setContactWayEnable(boolean z) {
        C5167a.f21370p = z;
    }

    public static void setExtraData(Map map) {
        C5167a.f21358d = C5174a.m17564a(map);
    }

    public static void setLogLevel(int i) {
        C5167a.f21367m = i;
    }

    public static void setFeedBackUrl(String str) {
        C5167a.ak = str;
    }

    public static void openRobotAnswer() {
        robotAnswer = true;
    }

    public static void closeRobotAnswer() {
        robotAnswer = false;
    }

    public static void openInputContactSwitch() {
        contactDialogSwitch = true;
    }

    public static void closeInputContactSwitch() {
        contactDialogSwitch = false;
    }

    public static void setFeedbackPrefix(String str) {
        C5167a.f21364j = str;
    }

    public static void setFeedbackSubfix(String str) {
        C5167a.f21365k = str;
    }

    public static void setReferer(String str) {
        C5167a.f21368n = str;
    }

    public static void setBaiduCuid(String str) {
        C5167a.f21357c = str;
    }

    public static void setCustomLocation(String str) {
        C5167a.f21360f = str;
    }

    public static void setPlaceholder(String str) {
        C5167a.f21366l = str;
    }

    public static void openLogcatSwitch() {
        C5167a.f21355a = true;
    }

    public static void setRootBackgroundColor(int i) {
        C5167a.f21379y = i;
    }

    public static void setTitleTextColor(int i) {
        C5167a.f21373s = i;
    }

    public static void setTabDefultTextColor(int i) {
        C5167a.f21375u = i;
    }

    public static void setTabBgTextColor(int i) {
        C5167a.f21376v = i;
    }

    public static void setSentBtnTextColor(int i) {
        C5167a.f21377w = i;
    }

    public static void setRightBtnTextColor(int i) {
        C5167a.f21374t = i;
    }

    public static void setListBgColor(int i) {
        C5167a.f21380z = i;
    }

    public static void setListTitleTextColor(int i) {
        C5167a.f21329A = i;
    }

    public static void setListTimeTextColor(int i) {
        C5167a.f21330B = i;
    }

    public static void setListDividerColor(int i) {
        C5167a.f21331C = i;
    }

    public static void setBackbtnTextColor(int i) {
        C5167a.f21332D = i;
    }

    public static void setToggleUpBgColor(int i) {
        C5167a.f21335G = i;
    }

    public static void setToggleUpTextColor(int i) {
        C5167a.f21337I = i;
    }

    public static void setInputBootomBackgroundColor(int i) {
        C5167a.f21333E = i;
    }

    public static void setSearchProblemColor(int i) {
        C5167a.f21338J = i;
    }

    public static void setCurrentUserIcon(Bitmap bitmap) {
        C5167a.f21359e = bitmap;
    }

    public static void setChatThreadTime(int i) {
        C5167a.an = i;
    }

    public static void setBackbtnText(String str) {
        C5167a.f21361g = str;
    }

    public static void setBackTextSize(float f) {
        C5167a.f21339K = f;
    }

    public static void setFeedbackDetailsTextSize(float f) {
        C5167a.f21340L = f;
    }

    public static void setReloadTextSize(float f) {
        C5167a.f21341M = f;
    }

    public static void setReloadBtnTextSize(float f) {
        C5167a.f21342N = f;
    }

    public static void setTimeViewTextSize(float f) {
        C5167a.f21343O = f;
    }

    public static void setChatViewTextSize(float f) {
        C5167a.f21344P = f;
    }

    public static void setHotProblemTextSize(float f) {
        C5167a.f21345Q = f;
    }

    public static void setTitleHelpAndFeedbackTextSize(float f) {
        C5167a.f21346R = f;
    }

    public static void setMyFeedbackBtnTextSize(float f) {
        C5167a.f21347S = f;
    }

    public static void setEnglishMyFeedbackOffsetSize(float f) {
        C5167a.ae = f;
    }

    public static void setFeedbackInputHintTextSize(float f) {
        C5167a.f21348T = f;
    }

    public static void setFeedbackInputWordCountTextSize(float f) {
        C5167a.f21349U = f;
    }

    public static void setSendBtnTextSize(float f) {
        C5167a.f21350V = f;
    }

    public static void setListTitleTextSize(float f) {
        C5167a.f21351W = f;
    }

    public static void setNoHaveFeedbackTextSize(float f) {
        C5167a.f21352X = f;
    }

    public static void setListTimeTextSize(float f) {
        C5167a.f21353Y = f;
    }

    public static void setListItemTextSize(float f) {
        C5167a.aa = f;
    }

    public static void setListDeleteTextSize(float f) {
        C5167a.ab = f;
    }

    public static void setTabDefaultTextSize(float f) {
        C5167a.ac = f;
    }

    public static void setSearchProblemTextSize(float f) {
        C5167a.ad = f;
    }

    public static void setToastShowTime(long j) {
        C5167a.f21371q = j;
    }

    public static void setTabCheckedStyle(int i) {
        C5167a.f21372r = i;
    }

    public static void setCustomText(HashMap hashMap) {
        C5167a.ag = hashMap;
    }

    public static void setResumeCallBack(ResumeCallBack resumeCallBack) {
        C5167a.ah = resumeCallBack;
    }

    public static void setSubmitMessageCallBack(SubmitMessageCallBack submitMessageCallBack) {
        C5167a.ai = submitMessageCallBack;
    }

    public static void setGetNoticeFlagCallBack(GetNoticeFlagCallBack getNoticeFlagCallBack) {
        C5167a.aj = getNoticeFlagCallBack;
    }

    public static void setUninstallFeedback(boolean z) {
        isUninstallFeedback = z;
    }

    public static boolean regUninstalledFeedback() {
        NativeClass nativeClass = new NativeClass(mApplication);
        if (!nativeClass.loadUFONativeLib()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Config.APP_VERSION_CODE, "commonuninstall");
        hashMap.put("uid", C5167a.f21356b);
        hashMap.put("channel", "appsearch");
        hashMap.put(SpeechConstant.APP_ID, "210070");
        hashMap.put("clientid", clientid);
        hashMap.put("devid", devid);
        nativeClass.init(C5171d.m17558a(), "http://ufosdk.baidu.com/?m=Client", hashMap);
        return true;
    }

    public static String getFeedbackNoticeFlag() {
        if (clientid.length() == 0) {
            return null;
        }
        String myFeekackNum;
        if (localFirstCall) {
            Editor edit;
            myFeekackNum = getMyFeekackNum();
            if (!(myFeekackNum == null || myFeekackNum.length() == 0 || Integer.parseInt(myFeekackNum) == 0)) {
                neverFeedback = false;
                edit = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
                edit.putBoolean("UfoNeverFeedback", false);
                edit.commit();
            }
            localFirstCall = false;
            edit = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
            edit.putBoolean("UfoLocalFirstCall", false);
            edit.commit();
        }
        if (neverFeedback) {
            return null;
        }
        myFeekackNum = C5167a.av;
        try {
            Map hashMap = new HashMap();
            hashMap.put("clientid", clientid);
            hashMap.put(SpeechConstant.APP_ID, appid);
            hashMap.put("devid", devid);
            hashMap.put("uid", C5167a.f21356b);
            hashMap.put(Key.INTERVAL, String.valueOf(C5167a.ao));
            Object a = C5181b.m17578a(myFeekackNum, "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(C5220m.m17773b(a));
                if (((Integer) jSONObject.get(C2125n.f6745M)).intValue() == 0) {
                    return String.valueOf(jSONObject.get("newmsg"));
                }
            }
        } catch (Throwable e) {
            C5210c.m17733a("sendRecord fail.", e);
        }
        return null;
    }

    public static void getNoticeFlagInThread() {
        new Thread(new C5179d()).start();
    }

    private static String getNoticeFlag() {
        if (clientid.length() == 0) {
            if (C5167a.aj != null) {
                C5167a.aj.getNoticeFlagResult(null);
            }
            return null;
        }
        String myFeekackNum;
        if (localFirstCall) {
            Editor edit;
            myFeekackNum = getMyFeekackNum();
            if (!(myFeekackNum == null || myFeekackNum.length() == 0 || Integer.parseInt(myFeekackNum) == 0)) {
                neverFeedback = false;
                edit = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
                edit.putBoolean("UfoNeverFeedback", false);
                edit.commit();
            }
            localFirstCall = false;
            edit = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
            edit.putBoolean("UfoLocalFirstCall", false);
            edit.commit();
        }
        if (neverFeedback) {
            if (C5167a.aj != null) {
                C5167a.aj.getNoticeFlagResult(null);
            }
            return null;
        }
        myFeekackNum = C5167a.av;
        try {
            Map hashMap = new HashMap();
            hashMap.put("clientid", clientid);
            hashMap.put(SpeechConstant.APP_ID, appid);
            hashMap.put("devid", devid);
            hashMap.put("uid", C5167a.f21356b);
            hashMap.put(Key.INTERVAL, String.valueOf(C5167a.ao));
            Object a = C5181b.m17578a(myFeekackNum, "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(C5220m.m17773b(a));
                if (((Integer) jSONObject.get(C2125n.f6745M)).intValue() == 0) {
                    myFeekackNum = String.valueOf(jSONObject.get("newmsg"));
                    if (C5167a.aj == null) {
                        return myFeekackNum;
                    }
                    C5167a.aj.getNoticeFlagResult(myFeekackNum);
                    return myFeekackNum;
                }
            }
        } catch (Throwable e) {
            C5210c.m17733a("sendRecord fail.", e);
        }
        if (C5167a.aj != null) {
            C5167a.aj.getNoticeFlagResult(null);
        }
        return null;
    }

    private static String getMyFeekackNum() {
        String str = C5167a.aw;
        try {
            Map hashMap = new HashMap();
            hashMap.put("clientid", clientid);
            hashMap.put(SpeechConstant.APP_ID, appid);
            hashMap.put("devid", devid);
            hashMap.put("uid", C5167a.f21356b);
            hashMap.put(Key.INTERVAL, String.valueOf(C5167a.ao));
            Object a = C5181b.m17578a(str, "sdk_encrypt=" + URLEncoder.encode(C5220m.m17770a(C5174a.m17564a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(C5220m.m17773b(a));
                if (((Integer) jSONObject.get(C2125n.f6745M)).intValue() == 0) {
                    return String.valueOf(jSONObject.get("msgnum"));
                }
            }
        } catch (Throwable e) {
            C5210c.m17733a("sendRecord fail.", e);
        }
        return null;
    }
}
