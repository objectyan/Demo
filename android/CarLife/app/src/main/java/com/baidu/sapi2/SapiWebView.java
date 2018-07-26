package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.navisdk.util.common.SystemAuth;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.plugin.sso.SsoHandler;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4919c;
import com.baidu.sapi2.utils.C4923f;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.huawei.hwid.openapi.OpenHwID;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public final class SapiWebView extends WebView {
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final NameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new BasicNameValuePair("bindToSmsLogin", "1");
    public static final NameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new BasicNameValuePair("smsfastlogin", "1");
    public static final NameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new BasicNameValuePair("overseas", "1");
    public static final NameValuePair EXTRA_SUPPORT_VOICE_CODE = new BasicNameValuePair("is_voice_sms", "1");
    /* renamed from: a */
    private static final int f12791a = 1;
    private static final String ai = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    /* renamed from: b */
    private static final int f12792b = 0;
    /* renamed from: c */
    private static final String f12793c = "http://www.baidu.com";
    /* renamed from: d */
    private static final String f12794d = "__wp-action";
    /* renamed from: e */
    private static final String f12795e = "renren-offline";
    /* renamed from: f */
    private static final String f12796f = "auth-widget";
    /* renamed from: g */
    private static final String f12797g = "forget-pwd";
    /* renamed from: h */
    private static final String f12798h = "modify-pwd";
    /* renamed from: i */
    private static final String f12799i = "text/html";
    /* renamed from: j */
    private static final String f12800j = "UTF-8";
    /* renamed from: k */
    private static final String f12801k = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    /* renamed from: l */
    private static final String f12802l = "file:///android_asset";
    /* renamed from: m */
    private static final String f12803m = "#login";
    /* renamed from: n */
    private static final String f12804n = "#authPwd";
    /* renamed from: o */
    private static final String f12805o = "#reg";
    /* renamed from: p */
    private static final String f12806p = "#canshare_accounts";
    /* renamed from: q */
    private static final String f12807q = "#sms_login";
    /* renamed from: r */
    private static final String f12808r = "#fastReg";
    /* renamed from: s */
    private static final String f12809s = "#fastRegSuccess";
    /* renamed from: t */
    private static final String f12810t = "#fastRegVerify";
    /* renamed from: u */
    private static final String f12811u = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    /* renamed from: v */
    private static final String f12812v = "发送一条短信，即可完成注册。";
    /* renamed from: w */
    private static final String f12813w = "服务错误，请稍后重试";
    /* renamed from: x */
    private static final String f12814x = "微信未安装";
    /* renamed from: y */
    private static final String f12815y = "未登录华为帐号";
    /* renamed from: A */
    private SapiConfiguration f12816A;
    /* renamed from: B */
    private IUiListener f12817B;
    /* renamed from: C */
    private AuthorizationListener f12818C;
    /* renamed from: D */
    private Handler f12819D;
    /* renamed from: E */
    private Handler f12820E;
    /* renamed from: F */
    private Handler f12821F;
    /* renamed from: G */
    private SapiWebView$FastRegHandler f12822G;
    /* renamed from: H */
    private SapiWebView$VoiceLoginHandler f12823H;
    /* renamed from: I */
    private SapiWebView$NMLoginHandler f12824I;
    /* renamed from: J */
    private SapiWebView$LCLoginHandler f12825J;
    /* renamed from: K */
    private SapiWebView$UniteVerifyHandler f12826K;
    /* renamed from: L */
    private SapiWebView$WeixinHandler f12827L;
    /* renamed from: M */
    private SapiWebView$HuaweiHandler f12828M;
    /* renamed from: N */
    private SapiWebView$QuickLoginHandler f12829N;
    /* renamed from: O */
    private SapiWebView$ChangePwdCallback f12830O;
    /* renamed from: P */
    private SapiWebView$AuthWidgetCallback f12831P;
    /* renamed from: Q */
    private SapiWebView$BindWidgetCallback f12832Q;
    /* renamed from: R */
    private SapiWebView$UniteVerifyCallback f12833R;
    /* renamed from: S */
    private SsoHandler f12834S;
    /* renamed from: T */
    private View f12835T;
    /* renamed from: U */
    private View f12836U;
    /* renamed from: V */
    private ProgressBar f12837V;
    /* renamed from: W */
    private ProgressDialog f12838W;
    private long aa;
    private Handler ab = new SapiWebView$1(this);
    private SapiWebView$TimeoutTask ac = new SapiWebView$TimeoutTask(this, null);
    private BroadcastReceiver ad;
    private SapiWebView$SmsHandler ae;
    private Runnable af;
    private SapiWebView$OnFinishCallback ag;
    private SapiWebView$OnBackCallback ah;
    private SapiWebView$FastRegAction aj;
    private SapiAccountResponse ak;
    private SapiCallback<LoginResult> al;
    private SocialResponse am;
    /* renamed from: z */
    private Map<String, SapiWebView$AbstractInterpreter> f12839z = new HashMap();

    public void setOnFinishCallback(SapiWebView$OnFinishCallback callback) {
        this.ag = callback;
    }

    public void setOnBackCallback(SapiWebView$OnBackCallback onBackCallback) {
        this.ah = onBackCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        m11105b();
    }

    public SapiWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m11105b();
    }

    public SapiWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m11105b();
    }

    public final void setNoNetworkView(View view) {
        if (this.f12835T == null) {
            this.f12835T = view;
            this.f12835T.setVisibility(4);
            addView(this.f12835T, new LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.f12836U == null) {
            this.f12836U = view;
            this.f12836U.setVisibility(4);
            addView(this.f12836U, new LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.f12837V == null) {
            this.f12837V = progressBar;
            if (this.f12837V != null) {
                addView(progressBar);
            }
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    /* renamed from: b */
    private void m11105b() {
        this.aa = DEFAULT_TIMEOUT_MILLIS;
        this.f12816A = SapiAccountManager.getInstance().getSapiConfiguration();
        m11113d();
        if (VERSION.SDK_INT > 10 && VERSION.SDK_INT < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new SapiWebView$2(this));
        setWebChromeClient(new SapiWebView$3(this));
        if (this.f12818C == null) {
            this.f12818C = new SapiWebView$DefaultAuthorizationListener(this);
        }
        if (this.f12827L == null) {
            this.f12827L = new SapiWebView$DefaultWeixinHandler(this);
        }
        this.ae = new SapiWebView$SmsHandler(this, null);
        this.af = new SapiWebView$4(this);
        try {
            resumeTimers();
        } catch (Throwable e) {
            C4913L.e(e);
        }
        m11110c();
    }

    /* renamed from: c */
    private void m11110c() {
        this.f12839z.put("config_fastlogin_features", new SapiWebView$ConfigFastloginFeaturesInterpreter(this));
        this.f12839z.put("action_feifan_login", new SapiWebView$FeifanWebviewInterpreter(this));
        this.f12839z.put("action_social_renren_webview", new SapiWebView$RenRenWebviewInterpreter(this));
        this.f12839z.put("action_social_sina_sso", new SapiWebView$SinaSSOInterpreter(this));
        this.f12839z.put("action_social_weixin_sso", new SapiWebView$WeiXinSSOInterpreter(this));
        this.f12839z.put("action_social_qzone_webview", new SapiWebView$QzoneWebviewInterpreter(this));
        this.f12839z.put("action_social_tx_weibo_webview", new SapiWebView$TXWeiboWebviewInterpreter(this));
        this.f12839z.put("action_social_sina_weibo_webview", new SapiWebView$SinaWeiboWebviewInterpreter(this));
        this.f12839z.put("action_huawei_login", new SapiWebView$HuaweiSSOintrpreter(this));
        this.f12839z.put("action_nuomi_login", new SapiWebView$NuomiLoginInterpreter(this));
        this.f12839z.put("action_lecai_login", new SapiWebView$LecaiLoginInterpreter(this));
        this.f12839z.put("action_voice_login", new SapiWebView$VoiceLoginInterpreter(this));
        this.f12839z.put("action_unite_verify", new SapiWebView$UniteVerifyInterpreter(this));
        this.f12839z.put("loginWithQRCode", new SapiWebView$QRcodeLoginInterpreter(this));
        this.f12839z.put("loginWithDeviceId", new SapiWebView$DeviceIdLoginInterpreter(this));
        this.f12839z.put("authorized_response", new SapiWebView$AuthorizedResponseInterpreter(this));
        this.f12839z.put("config_login_share_strategy", new SapiWebView$ShareStrategyConfigInterpreter(this));
        this.f12839z.put("config_canshare_accounts", new SapiWebView$ShareAccountsConfigInterpreter(this));
        this.f12839z.put("action_remove_share_account", new SapiWebView$ShareAccountsRemoveInterpreter(this));
        this.f12839z.put("unite_verify_result", new SapiWebView$UniteVerifyResultInterpreter(this));
        this.f12839z.put("action_share_accounts_view_btn_clicked", new SapiWebView$5(this));
        this.f12839z.put("action_bind_widget_phone_number_exist", new SapiWebView$6(this));
        this.f12839z.put("finish", new SapiWebView$7(this));
        this.f12839z.put(C2848p.f9295V, new SapiWebView$8(this));
        this.f12839z.put("action_fast_reg", new SapiWebView$9(this));
        this.f12839z.put("action_forget_pwd", new SapiWebView$10(this));
        this.f12839z.put("action_received_sms_code", new SapiWebView$11(this));
        this.f12839z.put("set_pass_canceled", new SapiWebView$12(this));
        this.f12839z.put("get_preset_phone_number", new SapiWebView$13(this));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: d */
    private void m11113d() {
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            C4913L.e(e);
        }
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        setDownloadListener(new SapiWebView$14(this));
    }

    public void setAuthorizationListener(AuthorizationListener listener) {
        this.f12818C = listener;
    }

    public void setQrAppLoginHandler(Handler handler) {
        this.f12820E = handler;
    }

    public void setDeviceLoginHandler(Handler handler) {
        this.f12821F = handler;
    }

    public void setFastRegHandler(SapiWebView$FastRegHandler handler) {
        this.f12822G = handler;
    }

    public void setVoiceLoginHandler(SapiWebView$VoiceLoginHandler handler) {
        this.f12823H = handler;
    }

    public void setNmLoginHandler(SapiWebView$NMLoginHandler handler) {
        this.f12824I = handler;
    }

    public void setLcLoginHandler(SapiWebView$LCLoginHandler handler) {
        this.f12825J = handler;
    }

    public void setWeixinHandler(SapiWebView$WeixinHandler handler) {
        this.f12827L = handler;
    }

    public void setHuaweiHandler(SapiWebView$HuaweiHandler handler) {
        this.f12828M = handler;
    }

    public void setUniteVerifyHandler(SapiWebView$UniteVerifyHandler handler) {
        this.f12826K = handler;
    }

    public void setChangePwdCallback(SapiWebView$ChangePwdCallback callback) {
        this.f12830O = callback;
    }

    public void setAuthWidgetCallback(SapiWebView$AuthWidgetCallback callback) {
        this.f12831P = callback;
    }

    public void setBindWidgetCallback(SapiWebView$BindWidgetCallback callback) {
        this.f12832Q = callback;
    }

    public void setUniteVerifyCallback(SapiWebView$UniteVerifyCallback callback) {
        this.f12833R = callback;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.f12819D = handler;
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadLogin(int loginType) {
        loadLogin(loginType, null);
    }

    public void loadLogin(List<NameValuePair> extras) {
        loadLogin(0, extras);
    }

    public void loadLogin(int loginType, List<NameValuePair> extras) {
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            m11089a(loginType, extras, this.f12816A.customActionBarEnabled);
            return;
        }
        String url = m11088a(SapiAccountManager.getInstance().getAccountService().m11026a(), (List) extras);
        switch (loginType) {
            case 0:
                loadUrl(url + f12803m);
                return;
            case 1:
                loadUrl(url + f12807q);
                return;
            case 2:
                if (this.f12822G != null) {
                    post(new SapiWebView$15(this));
                    return;
                } else {
                    loadFastReg();
                    return;
                }
            default:
                loadUrl(url + f12803m);
                return;
        }
    }

    public void loadLoginWithUserName(String userName) {
        if (TextUtils.isEmpty(userName)) {
            loadLogin();
            return;
        }
        String paramUserName = "";
        try {
            paramUserName = "disusername=" + URLEncoder.encode(userName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4913L.e(e);
        }
        if (TextUtils.isEmpty(paramUserName)) {
            loadLogin();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().m11026a() + "&" + paramUserName + f12804n);
        }
    }

    @Deprecated
    public void loadSmsLogin() {
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            m11116e();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().m11026a() + f12807q);
        }
    }

    public void loadQuickLogin(SapiWebView$QuickLoginHandler quickLoginHandler) {
        if (quickLoginHandler == null) {
            throw new IllegalArgumentException(SapiWebView$QuickLoginHandler.class.getSimpleName() + " can't be null");
        }
        this.f12829N = quickLoginHandler;
        m11089a(3, null, true);
    }

    /* renamed from: e */
    private void m11116e() {
        m11089a(0, null, this.f12816A.customActionBarEnabled);
    }

    /* renamed from: a */
    private void m11089a(int quickLoginViewBtnAction, List<NameValuePair> extras, boolean customActionBar) {
        String url = SapiAccountManager.getInstance().getAccountService().m11026a() + "&loginInitType=" + m11083a(quickLoginViewBtnAction);
        if (customActionBar && !this.f12816A.customActionBarEnabled) {
            url = url + "&adapter=3";
        }
        loadUrl(m11088a(url, (List) extras) + f12806p);
    }

    /* renamed from: a */
    private int m11083a(int quickLoginViewBtnAction) {
        if (quickLoginViewBtnAction == 0) {
            return this.f12816A.smsLoginConfig.flagLoginBtnType.ordinal();
        }
        if (quickLoginViewBtnAction == 1 || quickLoginViewBtnAction == 2 || quickLoginViewBtnAction == 3) {
            return quickLoginViewBtnAction;
        }
        return 0;
    }

    public void loadLoginProxy(SapiCallback<LoginResult> callback, String actionUrl) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(actionUrl)) {
            throw new IllegalArgumentException("actionUrl can't be empty");
        } else {
            this.al = callback;
            loadUrl(actionUrl);
        }
    }

    public void loadRegist() {
        loadRegist(null);
    }

    public void loadRegist(List<NameValuePair> extras) {
        String url = SapiAccountManager.getInstance().getAccountService().m11026a();
        if (this.f12816A.quickUserEnabled && this.f12816A.registMode == RegistMode.QUICK_USER) {
            url = url.replace("regtype=2", "regtype=1");
        }
        loadUrl(m11088a(url, (List) extras) + f12805o);
    }

    /* renamed from: a */
    private String m11088a(String url, List<NameValuePair> extras) {
        if (extras == null) {
            return url;
        }
        List<NameValuePair> params = new ArrayList();
        for (NameValuePair param : extras) {
            if (!(TextUtils.isEmpty(param.getName()) || TextUtils.isEmpty(param.getValue()))) {
                try {
                    params.add(new BasicNameValuePair(URLEncoder.encode(param.getName(), "UTF-8"), URLEncoder.encode(param.getValue(), "UTF-8")));
                } catch (UnsupportedEncodingException e) {
                    C4913L.e(e);
                }
            }
        }
        if (params.isEmpty()) {
            return url;
        }
        return url + "&" + SapiUtils.createRequestParams(params);
    }

    public void loadQuickUserReg() {
        if (this.f12816A.quickUserEnabled) {
            String url = SapiAccountManager.getInstance().getAccountService().m11026a();
            if (this.f12816A.registMode != RegistMode.QUICK_USER) {
                url = url + "&regtype=2";
            }
            loadUrl(url + f12805o);
            return;
        }
        loadRegist();
    }

    public void loadModifyPwd(String bduss) {
        loadModifyPwd(bduss, null);
    }

    public void loadModifyPwd(String bduss, String skinUrl) {
        if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), bduss);
        List<NameValuePair> list = new ArrayList();
        try {
            list.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=modify-pwd", "UTF-8")));
            if (!TextUtils.isEmpty(skinUrl)) {
                list.add(new BasicNameValuePair("skin", skinUrl));
            }
        } catch (UnsupportedEncodingException e) {
            C4913L.e(e);
        }
        String modifyPwdUrl = SapiAccountManager.getInstance().getAccountService().m11036c();
        if (list.size() > 0) {
            modifyPwdUrl = modifyPwdUrl + "&" + SapiUtils.createRequestParams(list);
        }
        String bindBdussCookie = m11142a();
        List<NameValuePair> cookies = new ArrayList();
        cookies.add(new BasicNameValuePair(this.f12816A.environment.getWap(), bindBdussCookie));
        loadUrl(modifyPwdUrl, cookies);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadForgetPwd(String skinUrl) {
        List<NameValuePair> list = new ArrayList();
        try {
            list.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=forget-pwd", "UTF-8")));
            if (!TextUtils.isEmpty(skinUrl)) {
                list.add(new BasicNameValuePair("skin", skinUrl));
            }
        } catch (UnsupportedEncodingException e) {
            C4913L.e(e);
        }
        String forgetPwdUrl = SapiAccountManager.getInstance().getAccountService().m11034b();
        if (list.size() > 0) {
            forgetPwdUrl = forgetPwdUrl + "&" + SapiUtils.createRequestParams(list);
        }
        loadUrl(forgetPwdUrl);
    }

    public void loadUserAgreement() {
        loadUrl(this.f12816A.environment.getWap() + "/passport/agreement?adapter=3");
    }

    public void loadOperationRecord(String bduss) {
        loadOperationRecord(bduss, null);
    }

    public void loadOperationRecord(String bduss, String skinUrl) {
        if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), bduss);
        List<NameValuePair> list = new ArrayList();
        if (!TextUtils.isEmpty(skinUrl)) {
            list.add(new BasicNameValuePair("skin", skinUrl));
        }
        String operationRecordUrl = SapiAccountManager.getInstance().getAccountService().m11037d();
        if (list.size() > 0) {
            operationRecordUrl = operationRecordUrl + "&" + SapiUtils.createRequestParams(list);
        }
        loadUrl(operationRecordUrl);
    }

    public void loadBindWidget(BindWidgetAction action, String bduss) {
        loadBindWidget(action, bduss, null, true, null);
    }

    public void loadBindWidget(BindWidgetAction action, String bduss, List<NameValuePair> extras) {
        loadBindWidget(action, bduss, null, true, extras);
    }

    public void loadBindWidget(BindWidgetAction action, String bduss, boolean skipSuccessTip) {
        loadBindWidget(action, bduss, null, skipSuccessTip, null);
    }

    public void loadBindWidget(BindWidgetAction action, String bduss, String skinUrl, boolean skipSuccessTip, List<NameValuePair> extras) {
        if (action == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            SapiUtils.webLogin(getContext(), bduss);
            List<NameValuePair> list = new ArrayList();
            if (!TextUtils.isEmpty(skinUrl)) {
                list.add(new BasicNameValuePair("skin", skinUrl));
            }
            if (skipSuccessTip) {
                list.add(new BasicNameValuePair("skip", "1"));
            }
            String bindWidgetUrl = SapiAccountManager.getInstance().getAccountService().m11027a(action);
            if (list.size() > 0) {
                bindWidgetUrl = bindWidgetUrl + "&" + SapiUtils.createRequestParams(list);
            }
            bindWidgetUrl = m11088a(bindWidgetUrl, (List) extras);
            String bindBdussCookie = m11142a();
            List<NameValuePair> cookies = new ArrayList();
            cookies.add(new BasicNameValuePair(this.f12816A.environment.getWap(), bindBdussCookie));
            loadUrl(bindWidgetUrl, cookies);
        }
    }

    public void loadAuthWidget(String authToken) {
        loadAuthWidget(null, authToken, null);
    }

    @Deprecated
    public void loadAuthWidget(String bduss, String authToken) {
        loadAuthWidget(bduss, authToken, null);
    }

    @Deprecated
    public void loadAuthWidget(String bduss, String authToken, String skinUrl) {
        if (TextUtils.isEmpty(authToken)) {
            throw new IllegalArgumentException("authToken can't be empty");
        }
        SapiUtils.webLogin(getContext(), bduss);
        List<NameValuePair> list = new ArrayList();
        try {
            list.add(new BasicNameValuePair("token", URLEncoder.encode(authToken, "UTF-8")));
            list.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=auth-widget", "UTF-8")));
            if (!TextUtils.isEmpty(skinUrl)) {
                list.add(new BasicNameValuePair("skin", skinUrl));
            }
        } catch (UnsupportedEncodingException e) {
            C4913L.e(e);
        }
        String authWidgetUrl = SapiAccountManager.getInstance().getAccountService().m11038e();
        if (list.size() > 0) {
            authWidgetUrl = authWidgetUrl + "&" + SapiUtils.createRequestParams(list);
        }
        loadUrl(authWidgetUrl);
    }

    public void loadFillUProfile(String bduss) {
        loadFillUProfile(bduss, false);
    }

    public void loadFillUProfile(String bduss, boolean simplified) {
        loadFillUProfile(bduss, simplified, null);
    }

    public void loadFillUProfile(String bduss, boolean simplified, String skinUrl) {
        if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), bduss);
        List<NameValuePair> list = new ArrayList();
        if (!TextUtils.isEmpty(skinUrl)) {
            list.add(new BasicNameValuePair("skin", skinUrl));
        }
        if (simplified) {
            list.add(new BasicNameValuePair("simplify", "1"));
        }
        String fillStartUrl = SapiAccountManager.getInstance().getAccountService().m11040g();
        if (list.size() > 0) {
            fillStartUrl = fillStartUrl + "&" + SapiUtils.createRequestParams(list);
        }
        loadUrl(fillStartUrl);
    }

    public void loadUniteVerify(String verifyToken, String returnUrl, String adText) {
        if (TextUtils.isEmpty(verifyToken)) {
            throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
        }
        List<NameValuePair> list = new ArrayList();
        try {
            list.add(new BasicNameValuePair("token", URLEncoder.encode(verifyToken, "UTF-8")));
            if (returnUrl != null) {
                list.add(new BasicNameValuePair("u", returnUrl));
            }
            if (adText != null) {
                list.add(new BasicNameValuePair("adtext", URLEncoder.encode(adText, "UTF-8")));
            }
        } catch (UnsupportedEncodingException e) {
            C4913L.e(e);
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().m11039f() + "&" + SapiUtils.createRequestParams(list));
    }

    public void loadFastReg() {
        if (SapiUtils.isSimReady(getContext()) && SapiUtils.hasActiveNetwork(getContext())) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().m11026a() + f12808r);
            this.aj = new SapiWebView$FastRegAction(this);
            SapiWebView$FastRegAction.a(this.aj);
            return;
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().m11026a() + "&regLink=0" + f12807q);
    }

    /* renamed from: a */
    private void m11098a(SapiAccountResponse response) {
        this.ak = response;
        loadUrl(SapiAccountManager.getInstance().getAccountService().m11026a() + "&authsid=" + response.authSid + "&bduss=" + response.bduss + "&ptoken=" + response.ptoken + "&stoken=" + response.stoken + f12809s);
    }

    public long getTimeoutMillis() {
        return this.aa;
    }

    public void setTimeoutMillis(long timeoutMillis) {
        this.aa = timeoutMillis;
    }

    public void loadUrl(String url) {
        loadUrl(url, Collections.emptyList());
    }

    public void loadUrl(String url, List<NameValuePair> cookies) {
        SapiUtils.syncCookies(getContext(), cookies);
        String data = m11109c(SapiCache.a(getContext(), url));
        if (TextUtils.isEmpty(data)) {
            m11114d(url);
            return;
        }
        loadDataWithBaseURL(url, data, f12799i, "UTF-8", url);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String failUrl) {
        post(new SapiWebView$16(this, baseUrl, data, mimeType, encoding, failUrl));
    }

    public void back() {
        m11107b(this.ak);
        super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
        m11099a(this.am);
        if ((this.f12835T != null && this.f12835T.getVisibility() == 0) || (this.f12836U != null && this.f12836U.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        m11124i();
        if (this.aj != null) {
            SapiWebView$FastRegAction.a(this.aj, true);
            SapiWebView$FastRegAction.c(this.aj).removeCallbacks(SapiWebView$FastRegAction.b(this.aj));
        }
        if (this.ag != null) {
            this.ag.onFinish();
        }
    }

    public void onAuthorizedResult(int requestCode, int resultCode, Intent data) {
        if (this.f12834S != null) {
            this.f12834S.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    public void onActivityResultData(int requestCode, int resultCode, Intent data) {
        if (requestCode == 11101 || requestCode == 10102) {
            Tencent.onActivityResultData(requestCode, resultCode, data, this.f12817B);
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyUp(keyCode, event);
        }
        if (this.ah != null) {
            this.ah.onBack();
        }
        back();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static com.baidu.sapi2.shell.response.SapiAccountResponse m11086a(java.lang.String r12) {
        /*
        r9 = 1;
        r10 = 0;
        r8 = "<client>([\\S\\s]*?)</client>";
        r6 = m11087a(r8, r12);
        r8 = android.text.TextUtils.isEmpty(r6);
        if (r8 == 0) goto L_0x0011;
    L_0x000f:
        r4 = 0;
    L_0x0010:
        return r4;
    L_0x0011:
        r4 = 0;
        r3 = android.util.Xml.newPullParser();	 Catch:{ Throwable -> 0x0066 }
        r8 = new java.io.ByteArrayInputStream;	 Catch:{ Throwable -> 0x0066 }
        r11 = r6.getBytes();	 Catch:{ Throwable -> 0x0066 }
        r8.<init>(r11);	 Catch:{ Throwable -> 0x0066 }
        r11 = "UTF-8";
        r3.setInput(r8, r11);	 Catch:{ Throwable -> 0x0066 }
        r1 = r3.getEventType();	 Catch:{ Throwable -> 0x0066 }
        r5 = r4;
    L_0x002a:
        if (r1 == r9) goto L_0x01cf;
    L_0x002c:
        switch(r1) {
            case 2: goto L_0x0036;
            case 3: goto L_0x01cc;
            default: goto L_0x002f;
        };	 Catch:{ Throwable -> 0x0066 }
    L_0x002f:
        r4 = r5;
    L_0x0030:
        r1 = r3.next();	 Catch:{ Throwable -> 0x0066 }
        r5 = r4;
        goto L_0x002a;
    L_0x0036:
        r7 = r3.getName();	 Catch:{ Throwable -> 0x01c3 }
        r8 = "data";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x004b;
    L_0x0043:
        if (r5 != 0) goto L_0x002f;
    L_0x0045:
        r4 = new com.baidu.sapi2.shell.response.SapiAccountResponse;	 Catch:{ Throwable -> 0x01c3 }
        r4.<init>();	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x0030;
    L_0x004b:
        if (r5 != 0) goto L_0x007d;
    L_0x004d:
        r8 = "error_code";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x007d;
    L_0x0056:
        r4 = new com.baidu.sapi2.shell.response.SapiAccountResponse;	 Catch:{ Throwable -> 0x01c3 }
        r4.<init>();	 Catch:{ Throwable -> 0x01c3 }
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x0066 }
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ Throwable -> 0x0066 }
        r4.errorCode = r8;	 Catch:{ Throwable -> 0x0066 }
        goto L_0x0030;
    L_0x0066:
        r0 = move-exception;
    L_0x0067:
        com.baidu.sapi2.utils.C4913L.e(r0);
    L_0x006a:
        if (r4 == 0) goto L_0x0010;
    L_0x006c:
        r8 = r4.bduss;
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 != 0) goto L_0x0010;
    L_0x0074:
        r8 = r4.errorCode;
        r9 = -100;
        if (r8 != r9) goto L_0x0010;
    L_0x007a:
        r4.errorCode = r10;
        goto L_0x0010;
    L_0x007d:
        if (r5 != 0) goto L_0x0094;
    L_0x007f:
        r8 = "error_description";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0094;
    L_0x0088:
        r4 = new com.baidu.sapi2.shell.response.SapiAccountResponse;	 Catch:{ Throwable -> 0x01c3 }
        r4.<init>();	 Catch:{ Throwable -> 0x01c3 }
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x0066 }
        r4.errorMsg = r8;	 Catch:{ Throwable -> 0x0066 }
        goto L_0x0030;
    L_0x0094:
        if (r5 == 0) goto L_0x002f;
    L_0x0096:
        r8 = "errno";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x00ab;
    L_0x009f:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ Throwable -> 0x01c3 }
        r5.errorCode = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x00ab:
        r8 = "uname";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x00bd;
    L_0x00b4:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.username = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x00bd:
        r8 = "errmsg";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x00cf;
    L_0x00c6:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.errorMsg = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x00cf:
        r8 = "bduss";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x00e1;
    L_0x00d8:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.bduss = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x00e1:
        r8 = "ptoken";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x00f3;
    L_0x00ea:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.ptoken = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x00f3:
        r8 = "stoken";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0105;
    L_0x00fc:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.stoken = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0105:
        r8 = "displayname";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0117;
    L_0x010e:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.displayname = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0117:
        r8 = "uid";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0129;
    L_0x0120:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.uid = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0129:
        r8 = "authsid";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0148;
    L_0x0132:
        r8 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r5.authSid = r8;	 Catch:{ Throwable -> 0x01c3 }
        r8 = r5.authSid;	 Catch:{ Throwable -> 0x01c3 }
        r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 != 0) goto L_0x0146;
    L_0x0140:
        r8 = r9;
    L_0x0141:
        r5.newReg = r8;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0146:
        r8 = r10;
        goto L_0x0141;
    L_0x0148:
        r8 = "account";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x015c;
    L_0x0151:
        r8 = r5.reloginCredentials;	 Catch:{ Throwable -> 0x01c3 }
        r11 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r8.account = r11;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x015c:
        r8 = "accounttype";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0170;
    L_0x0165:
        r8 = r5.reloginCredentials;	 Catch:{ Throwable -> 0x01c3 }
        r11 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r8.accountType = r11;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0170:
        r8 = "password";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0184;
    L_0x0179:
        r8 = r5.reloginCredentials;	 Catch:{ Throwable -> 0x01c3 }
        r11 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r8.password = r11;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0184:
        r8 = "ubi";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x0198;
    L_0x018d:
        r8 = r5.reloginCredentials;	 Catch:{ Throwable -> 0x01c3 }
        r11 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r8.ubi = r11;	 Catch:{ Throwable -> 0x01c3 }
        r4 = r5;
        goto L_0x0030;
    L_0x0198:
        r8 = "incomplete_user";
        r8 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x002f;
    L_0x01a1:
        r2 = r3.nextText();	 Catch:{ Throwable -> 0x01c3 }
        r8 = "0";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x01b5;
    L_0x01ae:
        r8 = com.baidu.sapi2.utils.enums.AccountType.NORMAL;	 Catch:{ Throwable -> 0x01c3 }
        r5.accountType = r8;	 Catch:{ Throwable -> 0x01c3 }
    L_0x01b2:
        r4 = r5;
        goto L_0x0030;
    L_0x01b5:
        r8 = "1";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x01c3 }
        if (r8 == 0) goto L_0x01c7;
    L_0x01be:
        r8 = com.baidu.sapi2.utils.enums.AccountType.INCOMPLETE_USER;	 Catch:{ Throwable -> 0x01c3 }
        r5.accountType = r8;	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x01b2;
    L_0x01c3:
        r0 = move-exception;
        r4 = r5;
        goto L_0x0067;
    L_0x01c7:
        r8 = com.baidu.sapi2.utils.enums.AccountType.UNKNOWN;	 Catch:{ Throwable -> 0x01c3 }
        r5.accountType = r8;	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x01b2;
    L_0x01cc:
        r4 = r5;
        goto L_0x0030;
    L_0x01cf:
        r4 = r5;
        goto L_0x006a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiWebView.a(java.lang.String):com.baidu.sapi2.shell.response.SapiAccountResponse");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static com.baidu.sapi2.shell.response.SocialResponse m11104b(java.lang.String r9) {
        /*
        r7 = "<client>([\\S\\s]*?)</client>";
        r5 = m11087a(r7, r9);
        r7 = android.text.TextUtils.isEmpty(r5);
        if (r7 == 0) goto L_0x000f;
    L_0x000d:
        r3 = 0;
    L_0x000e:
        return r3;
    L_0x000f:
        r3 = 0;
        r2 = android.util.Xml.newPullParser();	 Catch:{ Exception -> 0x0065 }
        r7 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0065 }
        r8 = r5.getBytes();	 Catch:{ Exception -> 0x0065 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0065 }
        r8 = "UTF-8";
        r2.setInput(r7, r8);	 Catch:{ Exception -> 0x0065 }
        r1 = r2.getEventType();	 Catch:{ Exception -> 0x0065 }
        r4 = r3;
    L_0x0028:
        r7 = 1;
        if (r1 == r7) goto L_0x018f;
    L_0x002b:
        switch(r1) {
            case 2: goto L_0x0035;
            case 3: goto L_0x018c;
            default: goto L_0x002e;
        };	 Catch:{ Exception -> 0x0065 }
    L_0x002e:
        r3 = r4;
    L_0x002f:
        r1 = r2.next();	 Catch:{ Exception -> 0x0065 }
        r4 = r3;
        goto L_0x0028;
    L_0x0035:
        r6 = r2.getName();	 Catch:{ Exception -> 0x0192 }
        r7 = "data";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x004a;
    L_0x0042:
        if (r4 != 0) goto L_0x002e;
    L_0x0044:
        r3 = new com.baidu.sapi2.shell.response.SocialResponse;	 Catch:{ Exception -> 0x0192 }
        r3.<init>();	 Catch:{ Exception -> 0x0192 }
        goto L_0x002f;
    L_0x004a:
        if (r4 != 0) goto L_0x006a;
    L_0x004c:
        r7 = "error_code";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x006a;
    L_0x0055:
        r3 = new com.baidu.sapi2.shell.response.SocialResponse;	 Catch:{ Exception -> 0x0192 }
        r3.<init>();	 Catch:{ Exception -> 0x0192 }
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0065 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0065 }
        r3.errorCode = r7;	 Catch:{ Exception -> 0x0065 }
        goto L_0x002f;
    L_0x0065:
        r0 = move-exception;
    L_0x0066:
        com.baidu.sapi2.utils.C4913L.e(r0);
        goto L_0x000e;
    L_0x006a:
        if (r4 != 0) goto L_0x0081;
    L_0x006c:
        r7 = "error_description";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x0081;
    L_0x0075:
        r3 = new com.baidu.sapi2.shell.response.SocialResponse;	 Catch:{ Exception -> 0x0192 }
        r3.<init>();	 Catch:{ Exception -> 0x0192 }
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0065 }
        r3.errorMsg = r7;	 Catch:{ Exception -> 0x0065 }
        goto L_0x002f;
    L_0x0081:
        if (r4 == 0) goto L_0x002e;
    L_0x0083:
        r7 = "error_code";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x0098;
    L_0x008c:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0192 }
        r4.errorCode = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x0098:
        r7 = "error_description";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x00a9;
    L_0x00a1:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.errorMsg = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x00a9:
        r7 = "is_binded";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x00c2;
    L_0x00b2:
        r7 = "1";
        r8 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0192 }
        r4.isBinded = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x00c2:
        r7 = "display_name";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x00d4;
    L_0x00cb:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.displayname = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x00d4:
        r7 = "passport_uname";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x00e6;
    L_0x00dd:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.username = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x00e6:
        r7 = "bduid";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x00f8;
    L_0x00ef:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.uid = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x00f8:
        r7 = "bduss";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x010a;
    L_0x0101:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.bduss = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x010a:
        r7 = "ptoken";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x011c;
    L_0x0113:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.ptoken = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x011c:
        r7 = "os_username";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x012e;
    L_0x0125:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.socialUname = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x012e:
        r7 = "os_headurl";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x0140;
    L_0x0137:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r4.socialPortraitUrl = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x0140:
        r7 = "os_type";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x015a;
    L_0x0149:
        r7 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0192 }
        r7 = com.baidu.sapi2.utils.enums.SocialType.getSocialType(r7);	 Catch:{ Exception -> 0x0192 }
        r4.socialType = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x015a:
        r7 = "notice_offline";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x0173;
    L_0x0163:
        r7 = "1";
        r8 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0192 }
        r4.offlineNotice = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x0173:
        r7 = "guidebind";
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0192 }
        if (r7 == 0) goto L_0x002e;
    L_0x017c:
        r7 = "1";
        r8 = r2.nextText();	 Catch:{ Exception -> 0x0192 }
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0192 }
        r4.bindGuide = r7;	 Catch:{ Exception -> 0x0192 }
        r3 = r4;
        goto L_0x002f;
    L_0x018c:
        r3 = r4;
        goto L_0x002f;
    L_0x018f:
        r3 = r4;
        goto L_0x000e;
    L_0x0192:
        r0 = move-exception;
        r3 = r4;
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiWebView.b(java.lang.String):com.baidu.sapi2.shell.response.SocialResponse");
    }

    /* renamed from: f */
    private void m11118f() {
        stopLoading();
        post(new SapiWebView$17(this));
    }

    /* renamed from: g */
    private void m11120g() {
        post(new SapiWebView$18(this));
    }

    public void loadSinaSSOLogin() {
        m11143a(true);
    }

    public void loadIqiyiBindServer(String nextUrl) {
        if (nextUrl != null) {
            String bindCookie = SapiUtils.buildIqiyiCookie(this.f12816A.environment.getURL().replace("http://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(nextUrl).getQueryParameter("mkey"));
            List<NameValuePair> cookies = new ArrayList();
            cookies.add(new BasicNameValuePair(this.f12816A.environment.getURL(), bindCookie));
            loadUrl(nextUrl, cookies);
        }
    }

    /* renamed from: a */
    void m11143a(boolean closeOnCancel) {
        this.f12834S = new SsoHandler((Activity) getContext(), C4923f.f20606k, f12793c);
        this.f12834S.authorize(new SapiWebView$19(this, closeOnCancel));
        if (C4891b.a(getContext()).c()) {
            post(new SapiWebView$20(this));
        }
    }

    public void loadWeixinSSOLogin() {
        if (WXAPIFactory.createWXAPI(getContext(), this.f12816A.wxAppID).isWXAppInstalled()) {
            new AsyncHttpClient().get(getContext(), SapiAccountManager.getInstance().getAccountService().m11043j(), new SapiWebView$21(this, Looper.getMainLooper()));
        } else if (this.f12827L != null) {
            this.f12827L.handleNotInstall();
        }
    }

    public void loadQQSSOLogin() {
        Tencent mTencent = Tencent.createInstance(this.f12816A.qqAppID, getContext());
        this.f12817B = new SapiWebView$22(this, mTencent);
        if (mTencent.isSessionValid()) {
            mTencent.reAuth((Activity) getContext(), "all", this.f12817B);
        } else if (mTencent.isSupportSSOLogin((Activity) getContext())) {
            mTencent.login((Activity) getContext(), "all", this.f12817B);
        } else if (this.f12819D != null) {
            Message msg = new Message();
            msg.what = SocialType.QQ.getType();
            this.f12819D.sendMessage(msg);
        }
        if (C4891b.a(getContext()).c()) {
            Toast.makeText(getContext(), f12811u, 0).show();
        }
    }

    public void weixinSSOLogin(String code, String state) {
        if (TextUtils.isEmpty(code) || TextUtils.isEmpty(state)) {
            throw new IllegalArgumentException();
        }
        String url = SapiAccountManager.getInstance().getAccountService().m11035b(code, state);
        List<NameValuePair> cookie = new ArrayList(1);
        cookie.add(new BasicNameValuePair(this.f12816A.environment.getURL(), "mkey=" + state + ";domain=." + this.f12816A.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/"));
        loadUrl(url, cookie);
    }

    public void loadHuaWeiSSOLogin() {
        if (getContext() instanceof Activity) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("useSMSLogin", false);
            OpenHwID.setLoginProxy((Activity) getContext(), this.f12816A.hwAppId, new SapiWebView$23(this), bundle);
            OpenHwID.logout();
            OpenHwID.login(new Bundle());
            if (C4891b.a(getContext()).c()) {
                post(new SapiWebView$24(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("context not Activity");
    }

    public void loadSocialLogin(SocialType socialType) {
        loadSocialLogin(socialType, false);
    }

    public void loadSocialLogin(SocialType socialType, boolean forceLogin) {
        if (socialType == null) {
            throw new IllegalArgumentException("SocialType can't be null");
        } else if (socialType == SocialType.UNKNOWN) {
            throw new IllegalArgumentException("Unknown SocialType");
        } else {
            String url = SapiAccountManager.getInstance().getAccountService().m11028a(socialType);
            if (forceLogin) {
                url = url + "&is_force_login=1";
            }
            if (socialType == SocialType.RENREN) {
                try {
                    url = url + "&u=" + URLEncoder.encode("http://www.baidu.com?__wp-action=renren-offline", "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4913L.e(e);
                }
            }
            loadUrl(url);
            if (C4891b.a(getContext()).c()) {
                post(new SapiWebView$25(this));
            }
        }
    }

    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (this.f12837V != null) {
            AbsoluteLayout.LayoutParams lp = (AbsoluteLayout.LayoutParams) this.f12837V.getLayoutParams();
            lp.x = l;
            lp.y = t;
            this.f12837V.setLayoutParams(lp);
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    /* renamed from: d */
    private void m11114d(String url) {
        if (SapiUtils.hasActiveNetwork(getContext()) || url.startsWith("javascript:")) {
            post(new SapiWebView$26(this, url));
        } else {
            m11120g();
        }
    }

    /* renamed from: b */
    private void m11107b(SapiAccountResponse response) {
        if (response != null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = response.uid;
            sapiAccount.bduss = response.bduss;
            sapiAccount.displayname = response.displayname;
            sapiAccount.stoken = response.stoken;
            sapiAccount.ptoken = response.ptoken;
            sapiAccount.email = response.email;
            sapiAccount.username = response.username;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            C4891b.a(getContext()).a(response.uid, response.reloginCredentials);
            if (this.f12818C != null) {
                post(new SapiWebView$27(this, sapiAccount, response));
            }
        }
    }

    /* renamed from: a */
    private void m11099a(SocialResponse response) {
        if (response != null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = response.uid;
            sapiAccount.bduss = response.bduss;
            sapiAccount.displayname = response.displayname;
            sapiAccount.username = response.username;
            sapiAccount.stoken = response.stoken;
            sapiAccount.ptoken = response.ptoken;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            C4919c.a(sapiAccount, response.socialType, response.socialPortraitUrl);
            if (SapiUtils.isValidAccount(sapiAccount)) {
                response.errorCode = 0;
            }
            if (this.f12818C == null) {
                return;
            }
            if (response.errorCode == 0 || response.errorCode == 110000) {
                post(new SapiWebView$28(this, sapiAccount));
            } else {
                post(new SapiWebView$29(this, response));
            }
        }
    }

    /* renamed from: a */
    private void m11100a(AccountType accountType) {
        try {
            if (!AuthorizationListener.class.equals(this.f12818C.getClass().getMethod("onSuccess", new Class[]{AccountType.class}).getDeclaringClass())) {
                this.f12818C.onSuccess(accountType);
                return;
            }
        } catch (NoSuchMethodException e) {
            C4913L.e(e);
        }
        this.f12818C.onSuccess();
    }

    /* renamed from: h */
    private String m11122h() {
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        String phoneNum = null;
        if (SapiUtils.checkRequestPermission(SystemAuth.READ_PHONE_STATE_AUTH, getContext())) {
            phoneNum = telephonyManager.getLine1Number();
        }
        if (TextUtils.isEmpty(phoneNum)) {
            return null;
        }
        return phoneNum.replace("+86", "");
    }

    /* renamed from: a */
    private void m11090a(Handler handler) {
        if (this.ad == null) {
            this.ad = new SapiWebView$SMSReceiver(handler);
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.provider.Telephony.SMS_RECEIVED");
            filter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(this.ad, filter);
        }
    }

    /* renamed from: i */
    private void m11124i() {
        if (this.ad != null) {
            try {
                getContext().unregisterReceiver(this.ad);
            } catch (Throwable th) {
            }
        }
        this.ad = null;
    }

    /* renamed from: c */
    static String m11109c(String data) {
        try {
            String skin = SapiAccountManager.getInstance().getSapiConfiguration().skin;
            if (TextUtils.isEmpty(data)) {
                return data;
            }
            if (TextUtils.isEmpty(skin) || !skin.startsWith(f12802l)) {
                return data.replace(f12801k, "");
            }
            return data.replace(f12801k, "<link type=\"text/css\" rel=\"stylesheet\" href=\"" + skin + "\">");
        } catch (Throwable e) {
            C4913L.e(e);
            return data;
        }
    }

    /* renamed from: a */
    String m11142a() {
        return SapiUtils.buildBDUSSCookie(this.f12816A.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    /* renamed from: a */
    static String m11087a(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        if (TextUtils.isEmpty(source)) {
            return result;
        }
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException e) {
        }
    }
}
