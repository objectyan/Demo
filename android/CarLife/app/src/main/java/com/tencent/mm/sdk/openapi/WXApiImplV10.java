package com.tencent.mm.sdk.openapi;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.constants.ConstantsAPI.Token;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.sdk.modelbiz.CreateChatroom;
import com.tencent.mm.sdk.modelbiz.JoinChatroom;
import com.tencent.mm.sdk.modelbiz.OpenWebview;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.mm.sdk.p285a.C6091a;
import com.tencent.mm.sdk.p285a.C6091a.C6087a;
import com.tencent.mm.sdk.p285a.p286a.C6089a;
import com.tencent.mm.sdk.p285a.p286a.C6089a.C6088a;
import com.tencent.mm.sdk.p285a.p286a.C6090b;
import com.tencent.mm.sdk.p287b.C6094b;
import com.tencent.wxop.stat.C6131a;
import com.tencent.wxop.stat.C6156f;
import com.tencent.wxop.stat.C6158h;
import com.tencent.wxop.stat.C6159i;
import com.tencent.wxop.stat.p291b.C6132a;

final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static ActivityLifecycleCb activityCb = null;
    private static String wxappPayEntryClassname = null;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    private static final class ActivityLifecycleCb implements ActivityLifecycleCallbacks {
        private static final int DELAYED = 800;
        private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
        private Context context;
        private Handler handler;
        private boolean isForeground;
        private Runnable onPausedRunnable;
        private Runnable onResumedRunnable;

        /* renamed from: com.tencent.mm.sdk.openapi.WXApiImplV10$ActivityLifecycleCb$1 */
        class C61161 implements Runnable {
            C61161() {
            }

            public void run() {
                if (WXApiImplV10.activityCb != null && ActivityLifecycleCb.this.isForeground) {
                    Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onBackground");
                    C6159i.m22069a(ActivityLifecycleCb.this.context, "onBackground_WX", null);
                    ActivityLifecycleCb.this.isForeground = false;
                }
            }
        }

        /* renamed from: com.tencent.mm.sdk.openapi.WXApiImplV10$ActivityLifecycleCb$2 */
        class C61172 implements Runnable {
            C61172() {
            }

            public void run() {
                if (WXApiImplV10.activityCb != null && !ActivityLifecycleCb.this.isForeground) {
                    Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onForeground");
                    C6159i.m22069a(ActivityLifecycleCb.this.context, "onForeground_WX", null);
                    ActivityLifecycleCb.this.isForeground = true;
                }
            }
        }

        private ActivityLifecycleCb(Context context) {
            this.isForeground = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.onPausedRunnable = new C61161();
            this.onResumedRunnable = new C61172();
            this.context = context;
        }

        public final void detach() {
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.context = null;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityPaused");
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.postDelayed(this.onPausedRunnable, 800);
        }

        public final void onActivityResumed(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityResumed");
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.handler.postDelayed(this.onResumedRunnable, 800);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    WXApiImplV10(Context context, String str, boolean z) {
        C6094b.m21685e(TAG, "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            C6094b.m21682b(TAG, "checkSumConsistent fail, invalid arguments");
            return false;
        } else if (bArr.length != bArr2.length) {
            C6094b.m21682b(TAG, "checkSumConsistent fail, length is different");
            return false;
        } else {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction"), bundle.getString("_wxapi_create_chatroom_group_id"), bundle.getString("_wxapi_create_chatroom_chatroom_name"), bundle.getString("_wxapi_create_chatroom_chatroom_nickname"), bundle.getString("_wxapi_create_chatroom_ext_msg")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private void initMta(Context context, String str) {
        String str2 = "AWXOP" + str;
        C6156f.m21992b(context, str2);
        C6156f.m22002c(true);
        C6156f.m21983a(C6158h.PERIOD);
        C6156f.m22022g(60);
        C6156f.m22000c(context, "Wechat_Sdk");
        try {
            C6159i.m22074a(context, str2, C6132a.f24873a);
        } catch (C6131a e) {
            e.printStackTrace();
        }
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction"), bundle.getString("_wxapi_join_chatroom_group_id"), bundle.getString("_wxapi_join_chatroom_chatroom_nickname"), bundle.getString("_wxapi_join_chatroom_ext_msg")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizTempSessionReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_session_from"), bundle.getInt("_wxapi_jump_to_biz_webview_req_show_type")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), bundle.getInt("_wxapi_jump_to_biz_webview_req_scene")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            C6094b.m21685e(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                C6094b.m21682b(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        C6087a c6087a = new C6087a();
        c6087a.f24748Z = bundle;
        c6087a.f24745W = WXApp.WXAPP_PACKAGE_NAME;
        c6087a.f24746X = wxappPayEntryClassname;
        return C6091a.m21674a(context, c6087a);
    }

    public final void detach() {
        C6094b.m21685e(TAG, "detach");
        this.detached = true;
        if (activityCb != null && VERSION.SDK_INT >= 14) {
            if (this.context instanceof Activity) {
                ((Activity) this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
            } else if (this.context instanceof Service) {
                ((Service) this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
            }
            activityCb.detach();
        }
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            return new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
        } else {
            C6094b.m21682b(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, Token.WX_TOKEN_VALUE_MSG)) {
                C6094b.m21684d(TAG, "handleIntent fail, intent not from weixin msg");
                return false;
            } else if (this.detached) {
                throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
            } else {
                String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
                int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
                String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    C6094b.m21682b(TAG, "invalid argument");
                    return false;
                } else if (checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), C6090b.m21673a(stringExtra, intExtra, stringExtra2))) {
                    int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                    switch (intExtra2) {
                        case 1:
                            iWXAPIEventHandler.onResp(new Resp(intent.getExtras()));
                            return true;
                        case 2:
                            iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                            return true;
                        case 3:
                            iWXAPIEventHandler.onReq(new Req(intent.getExtras()));
                            return true;
                        case 4:
                            iWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(intent.getExtras()));
                            return true;
                        case 5:
                            iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                            return true;
                        case 6:
                            iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                            return true;
                        case 9:
                            iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                            return true;
                        case 12:
                            iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                            return true;
                        case 14:
                            iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                            return true;
                        case 15:
                            iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                            return true;
                        default:
                            C6094b.m21682b(TAG, "unknown cmd = " + intExtra2);
                            return false;
                    }
                } else {
                    C6094b.m21682b(TAG, "checksum fail");
                    return false;
                }
            }
        } catch (Exception e) {
            C6094b.m21681a(TAG, "handleIntent fail, ex = %s", e.getMessage());
            return false;
        }
    }

    public final boolean isWXAppInstalled() {
        boolean z = false;
        if (this.detached) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(WXApp.WXAPP_PACKAGE_NAME, 64);
            if (packageInfo != null) {
                z = WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            }
        } catch (NameNotFoundException e) {
        }
        return z;
    }

    public final boolean isWXAppSupportAPI() {
        if (!this.detached) {
            return getWXAppSupportAPI() >= 587268097;
        } else {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
    }

    public final boolean openWXApp() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            try {
                this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage(WXApp.WXAPP_PACKAGE_NAME));
                return true;
            } catch (Exception e) {
                C6094b.m21682b(TAG, "startActivity fail, exception = " + e.getMessage());
                return false;
            }
        } else {
            C6094b.m21682b(TAG, "open wx app failed, not installed or signature check failed");
            return false;
        }
    }

    public final boolean registerApp(String str) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            if (activityCb == null && VERSION.SDK_INT >= 14) {
                if (this.context instanceof Activity) {
                    initMta(this.context, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    ((Activity) this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
                } else if (this.context instanceof Service) {
                    initMta(this.context, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    ((Service) this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
                } else {
                    C6094b.m21683c(TAG, "context is not instanceof Activity or Service, disable WXStat");
                }
            }
            C6094b.m21685e(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            C6094b.m21685e(TAG, "register app " + this.context.getPackageName());
            C6088a c6088a = new C6088a();
            c6088a.aa = WXApp.WXAPP_PACKAGE_NAME;
            c6088a.ab = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            c6088a.f24749Y = "weixin://registerapp?appid=" + this.appId;
            return C6089a.m21672a(this.context, c6088a);
        } else {
            C6094b.m21682b(TAG, "register app failed for wechat app signature check failed");
            return false;
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            C6094b.m21682b(TAG, "sendReq failed for wechat app signature check failed");
            return false;
        } else if (baseReq.checkArgs()) {
            C6094b.m21685e(TAG, "sendReq, req type = " + baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5) {
                return sendPayReq(this.context, bundle);
            }
            if (baseReq.getType() == 7) {
                return sendJumpToBizProfileReq(this.context, bundle);
            }
            if (baseReq.getType() == 8) {
                return sendJumpToBizWebviewReq(this.context, bundle);
            }
            if (baseReq.getType() == 10) {
                return sendJumpToBizTempSessionReq(this.context, bundle);
            }
            if (baseReq.getType() == 9) {
                return sendAddCardToWX(this.context, bundle);
            }
            if (baseReq.getType() == 11) {
                return sendOpenRankListReq(this.context, bundle);
            }
            if (baseReq.getType() == 12) {
                return sendOpenWebview(this.context, bundle);
            }
            if (baseReq.getType() == 13) {
                return sendOpenBusiLuckyMoney(this.context, bundle);
            }
            if (baseReq.getType() == 14) {
                return createChatroom(this.context, bundle);
            }
            if (baseReq.getType() == 15) {
                return joinChatroom(this.context, bundle);
            }
            C6087a c6087a = new C6087a();
            c6087a.f24748Z = bundle;
            c6087a.f24747Y = "weixin://sendreq?appid=" + this.appId;
            c6087a.f24745W = WXApp.WXAPP_PACKAGE_NAME;
            c6087a.f24746X = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
            return C6091a.m21674a(this.context, c6087a);
        } else {
            C6094b.m21682b(TAG, "sendReq checkArgs fail");
            return false;
        }
    }

    public final boolean sendResp(BaseResp baseResp) {
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            C6094b.m21682b(TAG, "sendResp failed for wechat app signature check failed");
            return false;
        } else if (baseResp.checkArgs()) {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            C6087a c6087a = new C6087a();
            c6087a.f24748Z = bundle;
            c6087a.f24747Y = "weixin://sendresp?appid=" + this.appId;
            c6087a.f24745W = WXApp.WXAPP_PACKAGE_NAME;
            c6087a.f24746X = WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
            return C6091a.m21674a(this.context, c6087a);
        } else {
            C6094b.m21682b(TAG, "sendResp checkArgs fail");
            return false;
        }
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (WXApiImplComm.validateAppSignatureForPackage(this.context, WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            C6094b.m21685e(TAG, "unregisterApp, appId = " + this.appId);
            if (this.appId == null || this.appId.length() == 0) {
                C6094b.m21682b(TAG, "unregisterApp fail, appId is empty");
                return;
            }
            C6094b.m21685e(TAG, "unregister app " + this.context.getPackageName());
            C6088a c6088a = new C6088a();
            c6088a.aa = WXApp.WXAPP_PACKAGE_NAME;
            c6088a.ab = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            c6088a.f24749Y = "weixin://unregisterapp?appid=" + this.appId;
            C6089a.m21672a(this.context, c6088a);
        } else {
            C6094b.m21682b(TAG, "unregister app failed for wechat app signature check failed");
        }
    }
}
