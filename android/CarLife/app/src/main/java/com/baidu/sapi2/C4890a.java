package com.baidu.sapi2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.baidunavis.BaiduNaviParams;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.sapi2.C4890a.43.C48821;
import com.baidu.sapi2.a.AnonymousClass18;
import com.baidu.sapi2.a.AnonymousClass43;
import com.baidu.sapi2.callback.FaceCheckCallback;
import com.baidu.sapi2.callback.FaceDelCallback;
import com.baidu.sapi2.callback.FaceLoginCallback;
import com.baidu.sapi2.callback.FaceModifyCallback;
import com.baidu.sapi2.callback.FaceRegCallback;
import com.baidu.sapi2.callback.FillUserProfileCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetRegCodeCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.LoginCallback;
import com.baidu.sapi2.callback.QrPcLoginCallback;
import com.baidu.sapi2.callback.QuickUserRegCallback;
import com.baidu.sapi2.callback.SSOConfirmCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SapiCallbackInterceptor;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.VoiceCheckCallback;
import com.baidu.sapi2.callback.VoiceCodeSetCallback;
import com.baidu.sapi2.callback.VoiceLoginCallback;
import com.baidu.sapi2.callback.VoiceSwitchSetCallback;
import com.baidu.sapi2.callback.VoiceVerifyCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.FaceCheckDTO;
import com.baidu.sapi2.dto.FaceDelDTO;
import com.baidu.sapi2.dto.FaceLoginDTO;
import com.baidu.sapi2.dto.FaceModifyDTO;
import com.baidu.sapi2.dto.FaceRegDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.LoginDTO.LoginType;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QuickUserRegDTO;
import com.baidu.sapi2.dto.ReloginDTO;
import com.baidu.sapi2.dto.ReloginDTO.PasswordType;
import com.baidu.sapi2.dto.SSOConfirmDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO.AccountType;
import com.baidu.sapi2.dto.VoiceCodeSetDTO;
import com.baidu.sapi2.dto.VoiceSwitchSetDTO;
import com.baidu.sapi2.dto.VoiceVerifyDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceCheckResult;
import com.baidu.sapi2.result.FaceDelResult;
import com.baidu.sapi2.result.FaceLoginResult;
import com.baidu.sapi2.result.FaceModifyResult;
import com.baidu.sapi2.result.FaceRegResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.FillUserProfileResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult.PopularPortraitsInfo;
import com.baidu.sapi2.result.GetRegCodeResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrPcLoginResult;
import com.baidu.sapi2.result.QuickUserRegResult;
import com.baidu.sapi2.result.ReloginResult;
import com.baidu.sapi2.result.SSOConfirmResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SapiResult.Action;
import com.baidu.sapi2.result.SapiResult.ActionMode;
import com.baidu.sapi2.result.SapiResult.ActionType;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.result.VoiceCheckResult;
import com.baidu.sapi2.result.VoiceCodeSetResult;
import com.baidu.sapi2.result.VoiceLoginResult;
import com.baidu.sapi2.result.VoiceRegResult;
import com.baidu.sapi2.result.VoiceSwitchSetResult;
import com.baidu.sapi2.result.VoiceVerifyResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.C4908a;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.GetUserInfoResponse;
import com.baidu.sapi2.shell.response.QrAppLoginResponse;
import com.baidu.sapi2.shell.response.QrPCLoginResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4919c;
import com.baidu.sapi2.utils.C4920d;
import com.baidu.sapi2.utils.C4922e;
import com.baidu.sapi2.utils.C4922e.C4921a;
import com.baidu.sapi2.utils.C4923f;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDataEncryptor.C4914a;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.speech.asr.SpeechConstant;
import com.facebook.common.p141m.C2924g;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: SapiAccountRepository */
/* renamed from: com.baidu.sapi2.a */
final class C4890a {
    /* renamed from: a */
    private static final int f20397a = 6;
    /* renamed from: b */
    private static final String f20398b = "3";
    /* renamed from: c */
    private SapiConfiguration f20399c = SapiAccountManager.getInstance().getSapiConfiguration();
    /* renamed from: d */
    private AsyncHttpClient f20400d;
    /* renamed from: e */
    private C4889a f20401e;
    /* renamed from: f */
    private String f20402f;
    /* renamed from: g */
    private String f20403g;
    /* renamed from: h */
    private LoginDTO f20404h;

    /* compiled from: SapiAccountRepository */
    /* renamed from: com.baidu.sapi2.a$a */
    static class C4889a {
        /* renamed from: b */
        static List<String> f20394b = new ArrayList();
        /* renamed from: c */
        static int f20395c;
        /* renamed from: a */
        Context f20396a;

        /* renamed from: e */
        private void m16128e() {
            f20394b.clear();
            f20394b.add(C4923f.f20599d);
            f20394b.add(C4923f.f20600e);
            f20394b.add(C4923f.f20601f);
        }

        public C4889a(Context context) {
            this.f20396a = context;
            m16132d();
            m16128e();
        }

        /* renamed from: a */
        public String m16129a() {
            String domain = SapiAccountManager.getInstance().getSapiConfiguration().environment.getURL();
            if (f20395c <= 0) {
                return domain;
            }
            if (f20395c > f20394b.size()) {
                f20395c = 1;
            }
            return (String) f20394b.get(f20395c - 1);
        }

        /* renamed from: b */
        public void m16130b() {
            f20395c++;
        }

        /* renamed from: c */
        public boolean m16131c() {
            return f20395c >= f20394b.size();
        }

        /* renamed from: d */
        public void m16132d() {
            f20395c = 0;
        }
    }

    C4890a(Context context) {
        this.f20401e = new C4889a(context);
    }

    /* renamed from: a */
    void m16170a() {
        if (this.f20400d != null) {
            this.f20400d.cancelRequests(this.f20399c.context, true);
        }
    }

    /* renamed from: a */
    void m16212a(final SapiCallBack<SapiResponse> callBack, final SapiAccount$ReloginCredentials credentials) {
        if (credentials == null) {
            throw new IllegalArgumentException("ReloginCredentials can't be null");
        } else if (TextUtils.isEmpty(credentials.account)) {
            if (callBack != null) {
                callBack.onSystemError(SapiErrorCode.USERNAME_EMPTY);
            }
        } else if (TextUtils.isEmpty(credentials.password)) {
            if (callBack != null) {
                callBack.onSystemError(SapiErrorCode.PWD_EMPTY);
            }
        } else if (TextUtils.isEmpty(credentials.ubi)) {
            if (callBack != null) {
                callBack.onSystemError(SapiErrorCode.NEED_REQUIRED_ITEMS);
            }
        } else if (this.f20399c == null || this.f20399c.context == null) {
            if (callBack != null) {
                callBack.onSystemError(-100);
            }
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            SapiDataEncryptor encryptor = new SapiDataEncryptor();
            try {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("crypttype", "11");
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                if (TextUtils.isEmpty(this.f20399c.clientId)) {
                    this.f20399c.clientId = SapiUtils.getClientId(this.f20399c.context);
                }
                postParams.put("cuid", this.f20399c.clientId);
                postParams.put("cert_id", String.valueOf(2));
                postParams.put("isdpass", "0");
                postParams.put("username", credentials.account);
                postParams.put("password", credentials.password);
                postParams.put("UBI", credentials.ubi);
                postParams.put("isphone", "3".equals(credentials.accountType) ? "1" : "0");
                postParams.put("login_type", "3");
                postParams.put("key", encryptor.m16384a());
                postParams.put("sdk_version", "2");
                postParams.put("pinfo", C4922e.m16412b());
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                this.f20400d.post(this.f20399c.context, m16244r(), new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: c */
                    final /* synthetic */ C4890a f20205c;

                    public void onSuccess(int statusCode, String content) {
                        this.f20205c.f20401e.m16132d();
                        this.f20205c.m16160d(this.f20205c.m16218b(content), callBack, content);
                    }

                    public void onFailure(Throwable error, String content) {
                        if (this.f20205c.f20401e.m16131c()) {
                            this.f20205c.f20401e.m16132d();
                            this.f20205c.m16160d(this.f20205c.m16218b(content), callBack, content);
                            return;
                        }
                        this.f20205c.f20401e.m16130b();
                        this.f20205c.m16212a(callBack, credentials);
                    }
                });
            } catch (Exception e) {
                m16160d(-100, callBack, null);
                C4913L.m16374e(e);
            }
        } else if (callBack != null) {
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: a */
    void m16194a(SapiCallback<ReloginResult> callback, ReloginDTO reloginDTO) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (reloginDTO == null) {
            throw new IllegalArgumentException(ReloginDTO.class.getSimpleName() + " can't be null");
        } else {
            final ReloginResult result = new ReloginResult();
            if (TextUtils.isEmpty(reloginDTO.bduss)) {
                result.setResultCode(-101);
                callback.onFailure(result);
            } else if (TextUtils.isEmpty(reloginDTO.password)) {
                result.setResultCode(-102);
                callback.onFailure(result);
            } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = m16169a(C4923f.f20597b);
                postParams.put("crypttype", String.valueOf(6));
                postParams.put("cert_id", String.valueOf(1));
                postParams.put("bduss", reloginDTO.bduss);
                final SapiDataEncryptor encryptor = new SapiDataEncryptor();
                try {
                    JSONObject obj = new JSONObject();
                    if (reloginDTO.getPasswordType() == PasswordType.PLAIN) {
                        obj.put("password", SapiDataEncryptor.encryptPwd(reloginDTO.password));
                    } else {
                        obj.put("password", reloginDTO.password);
                    }
                    obj.put("key", encryptor.m16384a());
                    postParams.put("userinfo", encryptor.m16386a(C4914a.f20514b, obj.toString()));
                    postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                    final SapiCallback<ReloginResult> sapiCallback = callback;
                    final ReloginDTO reloginDTO2 = reloginDTO;
                    this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20597b, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                        /* renamed from: e */
                        final /* synthetic */ C4890a f20168e;

                        protected void onStart() {
                            sapiCallback.onStart();
                        }

                        protected void onFinish() {
                            sapiCallback.onFinish();
                        }

                        protected void onSuccess(int statusCode, String responseBody) {
                            this.f20168e.f20401e.m16132d();
                            int resultCode = this.f20168e.m16218b(responseBody);
                            result.setResultCode(resultCode);
                            try {
                                JSONObject userInfoJSONObj = new JSONObject(encryptor.m16385a(new JSONObject(responseBody).optString("userinfo")));
                                result.setResultMsg(userInfoJSONObj.optString(C2125n.f6746N));
                                switch (resultCode) {
                                    case 0:
                                        result.session = this.f20168e.m16167a(userInfoJSONObj);
                                        sapiCallback.onSuccess(result);
                                        return;
                                    default:
                                        sapiCallback.onFailure(result);
                                        return;
                                }
                            } catch (Exception e) {
                                sapiCallback.onFailure(result);
                                C4913L.m16374e(e);
                            }
                        }

                        protected void onFailure(Throwable error, String responseBody) {
                            if (this.f20168e.f20401e.m16131c()) {
                                this.f20168e.f20401e.m16132d();
                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                sapiCallback.onFailure(result);
                                return;
                            }
                            this.f20168e.f20401e.m16130b();
                            this.f20168e.m16194a(sapiCallback, reloginDTO2);
                        }
                    });
                } catch (Exception e) {
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    callback.onFailure(result);
                    C4913L.m16374e(e);
                }
            } else {
                result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                callback.onFailure(result);
            }
        }
    }

    /* renamed from: a */
    int m16165a(SapiAccount$ReloginCredentials credentials) {
        if (credentials == null) {
            throw new IllegalArgumentException("ReloginCredentials can't be null");
        } else if (TextUtils.isEmpty(credentials.account)) {
            return SapiErrorCode.USERNAME_EMPTY;
        } else {
            if (TextUtils.isEmpty(credentials.password)) {
                return SapiErrorCode.PWD_EMPTY;
            }
            if (TextUtils.isEmpty(credentials.ubi)) {
                return SapiErrorCode.NEED_REQUIRED_ITEMS;
            }
            if (!SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                return SapiErrorCode.NETWORK_FAILED;
            }
            SapiDataEncryptor encryptor = new SapiDataEncryptor();
            try {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("crypttype", "11");
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                if (TextUtils.isEmpty(this.f20399c.clientId)) {
                    this.f20399c.clientId = SapiUtils.getClientId(this.f20399c.context);
                }
                postParams.put("cuid", this.f20399c.clientId);
                postParams.put("cert_id", "2");
                postParams.put("isdpass", "0");
                postParams.put("username", credentials.account);
                postParams.put("password", credentials.password);
                postParams.put("UBI", credentials.ubi);
                postParams.put("isphone", "3".equals(credentials.accountType) ? "1" : "0");
                postParams.put("login_type", "3");
                postParams.put("key", encryptor.m16384a());
                postParams.put("sdk_version", "2");
                postParams.put("pinfo", C4922e.m16412b());
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                List<NameValuePair> params = new ArrayList();
                for (Entry<String, String> entry : postParams.entrySet()) {
                    params.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                }
                HttpPost httpPost = new HttpPost(m16244r());
                httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                HttpResponse httpResponse = this.f20400d.execute(httpPost);
                if (200 == httpResponse.getStatusLine().getStatusCode()) {
                    String content = EntityUtils.toString(httpResponse.getEntity());
                    if (!TextUtils.isEmpty(content)) {
                        int code = m16218b(content);
                        if (code != 0) {
                            return code;
                        }
                        C4908a.m16342a().m16350a(m16167a(new JSONObject(content)));
                        return code;
                    }
                }
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
            return -100;
        }
    }

    /* renamed from: d */
    private void m16160d(int code, SapiCallBack<SapiResponse> callBack, String json) {
        if (json != null) {
            SapiAccountResponse response = new SapiAccountResponse();
            response.errorCode = code;
            try {
                JSONObject obj = new JSONObject(json);
                response.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                response.username = obj.optString("uname");
                response.uid = obj.optString("uid");
                response.email = obj.optString("email");
                response.bduss = obj.optString("bduss");
                response.ptoken = obj.optString(SapiAccountManager.SESSION_PTOKEN);
                response.stoken = obj.optString(SapiAccountManager.SESSION_STOKEN);
                response.authSid = obj.optString("authsid");
                if (callBack != null) {
                    switch (code) {
                        case 0:
                            SapiAccount account = m16166a(response);
                            account.extra = json;
                            C4908a.m16342a().m16350a(account);
                            callBack.onSuccess(response);
                            return;
                        default:
                            callBack.onSystemError(code);
                            return;
                    }
                }
            } catch (Exception e) {
                C4913L.m16374e(e);
                if (callBack != null) {
                    callBack.onSystemError(-100);
                }
            }
        } else if (callBack != null) {
            callBack.onSystemError(code);
        }
    }

    /* renamed from: a */
    void m16187a(LoginCallback callback, LoginDTO loginDTO) {
        if (callback == null) {
            throw new IllegalArgumentException(LoginCallback.class.getSimpleName() + " can't be null");
        } else if (loginDTO == null) {
            throw new IllegalArgumentException(LoginDTO.class.getSimpleName() + " can't be null");
        } else {
            final LoginResult result = new LoginResult();
            if (TextUtils.isEmpty(loginDTO.account)) {
                result.setResultCode(-101);
                callback.onFailure(result);
            } else if (TextUtils.isEmpty(loginDTO.password)) {
                result.setResultCode(-102);
                callback.onFailure(result);
            } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = m16169a(C4923f.f20596a);
                postParams.put("crypttype", String.valueOf(6));
                postParams.put("cert_id", String.valueOf(1));
                if (!(TextUtils.isEmpty(this.f20402f) || TextUtils.isEmpty(loginDTO.captcha))) {
                    postParams.put("verifycode", loginDTO.captcha);
                    postParams.put("vcodestr", this.f20402f);
                }
                if (this.f20399c.quickUserEnabled) {
                    postParams.put("quick_user", "1");
                }
                if (loginDTO.loginType == null || loginDTO.loginType == LoginType.MERGE) {
                    postParams.put("loginmerge", "true");
                }
                if (loginDTO.loginType == LoginType.USERNAME) {
                    postParams.put("isphone", "0");
                }
                if (loginDTO.loginType == LoginType.PHONE) {
                    postParams.put("isphone", "1");
                }
                final SapiDataEncryptor encryptor = new SapiDataEncryptor();
                try {
                    JSONObject obj = new JSONObject();
                    obj.put("username", loginDTO.account);
                    obj.put("password", loginDTO.password);
                    obj.put("login_type", "3");
                    obj.put("key", encryptor.m16384a());
                    postParams.put("userinfo", encryptor.m16386a(C4914a.f20514b, obj.toString()));
                    postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                    final LoginCallback loginCallback = callback;
                    final LoginDTO loginDTO2 = loginDTO;
                    this.f20400d.post(this.f20399c.context, m16244r(), new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                        /* renamed from: e */
                        final /* synthetic */ C4890a f20226e;

                        protected void onStart() {
                            loginCallback.onStart();
                        }

                        protected void onFinish() {
                            loginCallback.onFinish();
                        }

                        protected void onSuccess(int statusCode, String responseBody) {
                            this.f20226e.f20401e.m16132d();
                            int resultCode = this.f20226e.m16218b(responseBody);
                            result.setResultCode(resultCode);
                            try {
                                JSONObject userInfoJSONObj = new JSONObject(encryptor.m16385a(new JSONObject(responseBody).optString("userinfo")));
                                JSONObject sdkJSONObj = userInfoJSONObj.optJSONObject("sdk");
                                result.setResultMsg(sdkJSONObj.optString("msg"));
                                Action action = new Action();
                                action.actionMode = ActionMode.fromString(sdkJSONObj.optString(VoiceKey.ACTION));
                                action.actionType = ActionType.fromString(sdkJSONObj.optString("type"));
                                action.actionTitle = sdkJSONObj.optString("title");
                                action.actionUrl = sdkJSONObj.optString("url");
                                result.action = action;
                                if (userInfoJSONObj.optInt("needvcode") == 1) {
                                    this.f20226e.f20402f = userInfoJSONObj.optString("vcodestr");
                                    loginCallback.onCaptchaRequired(result);
                                }
                                switch (action.actionMode) {
                                    case URL:
                                        this.f20226e.f20404h = loginDTO2;
                                        loginCallback.onProxyActionRequired(result);
                                        return;
                                    case MSG:
                                        if (resultCode == 0) {
                                            SapiAccount account = this.f20226e.m16167a(userInfoJSONObj);
                                            SapiAccount$ReloginCredentials reloginCredentials = new SapiAccount$ReloginCredentials();
                                            reloginCredentials.account = loginDTO2.account;
                                            reloginCredentials.accountType = userInfoJSONObj.optString("logintype");
                                            reloginCredentials.password = SapiDataEncryptor.encryptPwd(loginDTO2.password);
                                            reloginCredentials.ubi = userInfoJSONObj.optString("ubi");
                                            C4891b.m16250a(this.f20226e.f20399c.context).m16268a(account.uid, reloginCredentials);
                                            C4908a.m16342a().m16350a(account);
                                            loginCallback.onSuccess(result);
                                            return;
                                        } else if (resultCode == 18) {
                                            loginCallback.onLoginTypeConflict(result);
                                            return;
                                        } else {
                                            loginCallback.onFailure(result);
                                            return;
                                        }
                                    default:
                                        loginCallback.onFailure(result);
                                        return;
                                }
                            } catch (Exception e) {
                                loginCallback.onFailure(result);
                                C4913L.m16374e(e);
                            }
                            loginCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }

                        protected void onFailure(Throwable error, String responseBody) {
                            if (this.f20226e.f20401e.m16131c()) {
                                this.f20226e.f20401e.m16132d();
                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                loginCallback.onFailure(result);
                                return;
                            }
                            this.f20226e.f20401e.m16130b();
                            this.f20226e.m16187a(loginCallback, loginDTO2);
                        }
                    });
                } catch (Exception e) {
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    callback.onFailure(result);
                    C4913L.m16374e(e);
                }
            } else {
                result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                callback.onFailure(result);
            }
        }
    }

    /* renamed from: a */
    void m16195a(final SapiCallback<LoginResult> callback, String url) {
        final LoginResult result = new LoginResult();
        if (TextUtils.isEmpty(url)) {
            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            callback.onFailure(result);
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            this.f20400d.get(this.f20399c.context, url, new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: c */
                final /* synthetic */ C4890a f20278c;

                protected void onStart() {
                    callback.onStart();
                }

                protected void onFinish() {
                    callback.onFinish();
                }

                protected void onSuccess(int statusCode, String responseText) {
                    try {
                        JSONObject obj = new JSONObject(responseText);
                        JSONObject errInfo = obj.optJSONObject("errInfo");
                        int resultCode = errInfo.optInt(C2848p.f9292S, SapiResult.ERROR_CODE_UNKNOWN);
                        result.setResultCode(resultCode);
                        result.setResultMsg(errInfo.optString("msg"));
                        switch (resultCode) {
                            case 0:
                                result.setResultMsg("登录成功");
                                String xml = obj.optJSONObject("data").optString("xml");
                                SapiAccount account = new SapiAccount();
                                account.app = SapiUtils.getAppName(this.f20278c.f20399c.context);
                                SapiAccount$ReloginCredentials reloginCredentials = new SapiAccount$ReloginCredentials();
                                reloginCredentials.account = this.f20278c.f20404h.account;
                                reloginCredentials.password = SapiDataEncryptor.encryptPwd(this.f20278c.f20404h.password);
                                XmlPullParser parser = Xml.newPullParser();
                                parser.setInput(new ByteArrayInputStream(xml.getBytes()), "UTF-8");
                                for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                                    switch (eventType) {
                                        case 2:
                                            String tag = parser.getName();
                                            if (!tag.equalsIgnoreCase("uname")) {
                                                if (!tag.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                                    if (!tag.equalsIgnoreCase("uid")) {
                                                        if (!tag.equalsIgnoreCase("bduss")) {
                                                            if (!tag.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                                                if (!tag.equalsIgnoreCase(SapiAccountManager.SESSION_STOKEN)) {
                                                                    if (!tag.equalsIgnoreCase("ubi")) {
                                                                        if (!tag.equalsIgnoreCase("accounttype")) {
                                                                            break;
                                                                        }
                                                                        reloginCredentials.accountType = parser.nextText();
                                                                        break;
                                                                    }
                                                                    reloginCredentials.ubi = parser.nextText();
                                                                    break;
                                                                }
                                                                account.stoken = parser.nextText();
                                                                break;
                                                            }
                                                            account.ptoken = parser.nextText();
                                                            break;
                                                        }
                                                        account.bduss = parser.nextText();
                                                        break;
                                                    }
                                                    account.uid = parser.nextText();
                                                    break;
                                                }
                                                account.displayname = parser.nextText();
                                                break;
                                            }
                                            account.username = parser.nextText();
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                C4891b.m16250a(this.f20278c.f20399c.context).m16268a(account.uid, reloginCredentials);
                                C4908a.m16342a().m16350a(account);
                                callback.onSuccess(result);
                                return;
                            default:
                                callback.onFailure(result);
                                return;
                        }
                    } catch (Exception e) {
                        callback.onFailure(result);
                        C4913L.m16374e(e);
                    }
                    callback.onFailure(result);
                    C4913L.m16374e(e);
                }

                protected void onFailure(Throwable error, String responseText) {
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    callback.onFailure(result);
                }
            });
        } else {
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: b */
    String m16219b() {
        return this.f20402f;
    }

    /* renamed from: a */
    void m16191a(SapiCallback<GetCaptchaResult> callback) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(this.f20402f)) {
            throw new IllegalArgumentException("captchaKey can't be empty");
        } else {
            final GetCaptchaResult result = new GetCaptchaResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                final SapiCallback<GetCaptchaResult> sapiCallback = callback;
                this.f20400d.get(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20602g + this.f20402f, new BinaryHttpResponseHandler(this, Looper.getMainLooper(), new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"}) {
                    /* renamed from: c */
                    final /* synthetic */ C4890a f20325c;

                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    protected void onSuccess(byte[] binaryData) {
                        this.f20325c.f20401e.m16132d();
                        if (binaryData != null) {
                            result.setResultCode(0);
                            result.captchaImage = binaryData;
                            sapiCallback.onSuccess(result);
                            return;
                        }
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        sapiCallback.onFailure(result);
                    }

                    protected void onFailure(Throwable error, byte[] binaryData) {
                        if (this.f20325c.f20401e.m16131c()) {
                            this.f20325c.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(result);
                            return;
                        }
                        this.f20325c.f20401e.m16130b();
                        this.f20325c.m16191a(sapiCallback);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16184a(GetRegCodeCallback callback, String phoneNumber) {
        if (callback == null) {
            throw new IllegalArgumentException(GetRegCodeCallback.class.getSimpleName() + " can't be null");
        }
        final GetRegCodeResult result = new GetRegCodeResult();
        if (TextUtils.isEmpty(phoneNumber)) {
            result.setResultCode(-101);
            callback.onFailure(result);
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map postParams = m16169a(C4923f.f20603h);
            postParams.put("phonenum", phoneNumber);
            postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
            final GetRegCodeCallback getRegCodeCallback = callback;
            final String str = phoneNumber;
            this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20603h, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: d */
                final /* synthetic */ C4890a f20351d;

                protected void onStart() {
                    getRegCodeCallback.onStart();
                }

                protected void onFinish() {
                    getRegCodeCallback.onFinish();
                }

                protected void onSuccess(int statusCode, String responseText) {
                    this.f20351d.f20401e.m16132d();
                    int resultCode = this.f20351d.m16218b(responseText);
                    result.setResultCode(resultCode);
                    try {
                        result.setResultMsg(new JSONObject(responseText).optJSONObject("sdk").optString("msg"));
                        switch (resultCode) {
                            case 0:
                                getRegCodeCallback.onSuccess(result);
                                return;
                            case 8:
                                getRegCodeCallback.onPhoneNumberExist(result);
                                return;
                            default:
                                getRegCodeCallback.onFailure(result);
                                return;
                        }
                    } catch (Exception e) {
                        getRegCodeCallback.onFailure(result);
                        C4913L.m16374e(e);
                    }
                    getRegCodeCallback.onFailure(result);
                    C4913L.m16374e(e);
                }

                protected void onFailure(Throwable error, String responseBody) {
                    if (this.f20351d.f20401e.m16131c()) {
                        this.f20351d.f20401e.m16132d();
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getRegCodeCallback.onFailure(result);
                        return;
                    }
                    this.f20351d.f20401e.m16130b();
                    this.f20351d.m16184a(getRegCodeCallback, str);
                }
            });
        } else {
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16193a(SapiCallback<PhoneRegResult> callback, PhoneRegDTO phoneRegDTO) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (phoneRegDTO == null) {
            throw new IllegalArgumentException(PhoneRegDTO.class.getSimpleName() + " can't be null");
        } else {
            final PhoneRegResult result = new PhoneRegResult();
            if (TextUtils.isEmpty(phoneRegDTO.phoneNumber)) {
                result.setResultCode(-101);
                callback.onFailure(result);
            } else if (TextUtils.isEmpty(phoneRegDTO.password) && !phoneRegDTO.noPwd) {
                result.setResultCode(-102);
                callback.onFailure(result);
            } else if (TextUtils.isEmpty(phoneRegDTO.regCode)) {
                result.setResultCode(-103);
                callback.onFailure(result);
            } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = m16169a(C4923f.f20604i);
                postParams.put("crypttype", String.valueOf(6));
                postParams.put("cert_id", String.valueOf(1));
                final SapiDataEncryptor encryptor = new SapiDataEncryptor();
                try {
                    JSONObject obj = new JSONObject();
                    obj.put("phonenum", phoneRegDTO.phoneNumber);
                    if (!phoneRegDTO.noPwd) {
                        obj.put("passwd", phoneRegDTO.password);
                    }
                    obj.put("smscode", phoneRegDTO.regCode);
                    obj.put("key", encryptor.m16384a());
                    postParams.put("userinfo", encryptor.m16386a(C4914a.f20514b, obj.toString()));
                    postParams.put("nopsw", phoneRegDTO.noPwd ? "1" : "0");
                    postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                    final SapiCallback<PhoneRegResult> sapiCallback = callback;
                    final PhoneRegDTO phoneRegDTO2 = phoneRegDTO;
                    this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20604i, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                        /* renamed from: e */
                        final /* synthetic */ C4890a f20356e;

                        protected void onStart() {
                            sapiCallback.onStart();
                        }

                        protected void onFinish() {
                            sapiCallback.onFinish();
                        }

                        protected void onSuccess(int statusCode, String responseText) {
                            this.f20356e.f20401e.m16132d();
                            int resultCode = this.f20356e.m16218b(responseText);
                            result.setResultCode(resultCode);
                            try {
                                JSONObject userInfoJSONObj = new JSONObject(encryptor.m16385a(new JSONObject(responseText).optString("userinfo")));
                                result.setResultMsg(userInfoJSONObj.optJSONObject("sdk").optString("msg"));
                                switch (resultCode) {
                                    case 0:
                                        SapiAccount account = this.f20356e.m16167a(userInfoJSONObj);
                                        SapiAccount$ReloginCredentials reloginCredentials = new SapiAccount$ReloginCredentials();
                                        reloginCredentials.account = phoneRegDTO2.phoneNumber;
                                        reloginCredentials.accountType = userInfoJSONObj.optString("logintype");
                                        reloginCredentials.password = SapiDataEncryptor.encryptPwd(phoneRegDTO2.password);
                                        reloginCredentials.ubi = userInfoJSONObj.optString("ubi");
                                        C4891b.m16250a(this.f20356e.f20399c.context).m16268a(account.uid, reloginCredentials);
                                        C4908a.m16342a().m16350a(account);
                                        sapiCallback.onSuccess(result);
                                        return;
                                    default:
                                        sapiCallback.onFailure(result);
                                        return;
                                }
                            } catch (Exception e) {
                                sapiCallback.onFailure(result);
                                C4913L.m16374e(e);
                            }
                        }

                        protected void onFailure(Throwable error, String responseBody) {
                            if (this.f20356e.f20401e.m16131c()) {
                                this.f20356e.f20401e.m16132d();
                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                sapiCallback.onFailure(result);
                                return;
                            }
                            this.f20356e.f20401e.m16130b();
                            this.f20356e.m16193a(sapiCallback, phoneRegDTO2);
                        }
                    });
                } catch (Exception e) {
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    callback.onFailure(result);
                    C4913L.m16374e(e);
                }
            } else {
                result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                callback.onFailure(result);
            }
        }
    }

    /* renamed from: a */
    void m16189a(QuickUserRegCallback callback, QuickUserRegDTO quickUserRegDTO) {
        if (!this.f20399c.quickUserEnabled) {
            throw new IllegalStateException("quick user not enabled");
        } else if (callback == null) {
            throw new IllegalArgumentException(QuickUserRegCallback.class.getSimpleName() + " can't be null");
        } else if (quickUserRegDTO == null) {
            throw new IllegalArgumentException(QuickUserRegDTO.class.getSimpleName() + " can't be null");
        } else {
            final QuickUserRegResult result = new QuickUserRegResult();
            if (TextUtils.isEmpty(quickUserRegDTO.username)) {
                result.setResultCode(-101);
                callback.onFailure(result);
            } else if (TextUtils.isEmpty(quickUserRegDTO.password)) {
                result.setResultCode(-102);
                callback.onFailure(result);
            } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = m16169a(C4923f.f20605j);
                postParams.put("crypttype", String.valueOf(6));
                postParams.put("cert_id", String.valueOf(1));
                if (!(TextUtils.isEmpty(this.f20402f) || TextUtils.isEmpty(quickUserRegDTO.captcha))) {
                    postParams.put("verifycode", quickUserRegDTO.captcha);
                    postParams.put("vcodestr", this.f20402f);
                }
                final SapiDataEncryptor encryptor = new SapiDataEncryptor();
                try {
                    JSONObject obj = new JSONObject();
                    obj.put("username", quickUserRegDTO.username);
                    obj.put("loginpass", quickUserRegDTO.password);
                    obj.put("key", encryptor.m16384a());
                    postParams.put("userinfo", encryptor.m16386a(C4914a.f20514b, obj.toString()));
                    postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                    final QuickUserRegCallback quickUserRegCallback = callback;
                    final QuickUserRegDTO quickUserRegDTO2 = quickUserRegDTO;
                    this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20605j, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                        /* renamed from: e */
                        final /* synthetic */ C4890a f20361e;

                        protected void onStart() {
                            quickUserRegCallback.onStart();
                        }

                        protected void onFinish() {
                            quickUserRegCallback.onFinish();
                        }

                        protected void onSuccess(int statusCode, String responseBody) {
                            this.f20361e.f20401e.m16132d();
                            int resultCode = this.f20361e.m16218b(responseBody);
                            result.setResultCode(resultCode);
                            try {
                                JSONObject userInfoJSONObj = new JSONObject(encryptor.m16385a(new JSONObject(responseBody).optString("userinfo")));
                                result.setResultMsg(userInfoJSONObj.optJSONObject("sdk").optString("msg"));
                                if (userInfoJSONObj.optInt("needvcode") == 1) {
                                    this.f20361e.f20402f = userInfoJSONObj.optString("vcodestr");
                                    quickUserRegCallback.onCaptchaRequired(result);
                                }
                                switch (resultCode) {
                                    case 0:
                                        SapiAccount account = this.f20361e.m16167a(userInfoJSONObj);
                                        SapiAccount$ReloginCredentials reloginCredentials = new SapiAccount$ReloginCredentials();
                                        reloginCredentials.account = quickUserRegDTO2.username;
                                        reloginCredentials.accountType = userInfoJSONObj.optString("logintype");
                                        reloginCredentials.password = SapiDataEncryptor.encryptPwd(quickUserRegDTO2.password);
                                        reloginCredentials.ubi = userInfoJSONObj.optString("ubi");
                                        C4891b.m16250a(this.f20361e.f20399c.context).m16268a(account.uid, reloginCredentials);
                                        C4908a.m16342a().m16350a(account);
                                        quickUserRegCallback.onSuccess(result);
                                        return;
                                    case 5:
                                        JSONArray array = userInfoJSONObj.optJSONArray("suggnames");
                                        if (array != null) {
                                            for (int i = 0; i < array.length(); i++) {
                                                result.sugUsernameList.add(array.optString(i));
                                            }
                                        }
                                        quickUserRegCallback.onUsernameExist(result);
                                        return;
                                    default:
                                        quickUserRegCallback.onFailure(result);
                                        return;
                                }
                            } catch (Exception e) {
                                quickUserRegCallback.onFailure(result);
                                C4913L.m16374e(e);
                            }
                            quickUserRegCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }

                        protected void onFailure(Throwable error, String responseBody) {
                            if (this.f20361e.f20401e.m16131c()) {
                                this.f20361e.f20401e.m16132d();
                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                quickUserRegCallback.onFailure(result);
                                return;
                            }
                            this.f20361e.f20401e.m16130b();
                            this.f20361e.m16189a(quickUserRegCallback, quickUserRegDTO2);
                        }
                    });
                } catch (Exception e) {
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    callback.onFailure(result);
                    C4913L.m16374e(e);
                }
            } else {
                result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                callback.onFailure(result);
            }
        }
    }

    /* renamed from: a */
    void m16206a(final Web2NativeLoginCallback callback) {
        final Web2NativeLoginResult result = new Web2NativeLoginResult();
        final String bduss = SapiUtils.getCookieBduss();
        if (!TextUtils.isEmpty(bduss)) {
            m16185a(new GetUserInfoCallback(this) {
                /* renamed from: d */
                final /* synthetic */ C4890a f20365d;

                public /* synthetic */ void onBdussExpired(SapiResult x0) {
                    m16125a((GetUserInfoResult) x0);
                }

                public /* synthetic */ void onFailure(SapiResult x0) {
                    m16127c((GetUserInfoResult) x0);
                }

                public /* synthetic */ void onSuccess(SapiResult x0) {
                    m16126b((GetUserInfoResult) x0);
                }

                /* renamed from: a */
                public void m16125a(GetUserInfoResult getUserInfoResult) {
                    if (callback != null) {
                        result.setResultCode(400021);
                        callback.onBdussExpired(result);
                    }
                }

                /* renamed from: b */
                public void m16126b(GetUserInfoResult getUserInfoResult) {
                    SapiAccount account = new SapiAccount();
                    account.uid = getUserInfoResult.uid;
                    account.username = getUserInfoResult.username;
                    account.displayname = getUserInfoResult.displayname;
                    account.bduss = bduss;
                    C4908a.m16342a().m16350a(account);
                    if (callback != null) {
                        result.setResultCode(0);
                        callback.onSuccess(result);
                    }
                }

                /* renamed from: c */
                public void m16127c(GetUserInfoResult getUserInfoResult) {
                    if (callback != null) {
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        callback.onFailure(result);
                    }
                }

                public void onStart() {
                    if (callback != null) {
                        callback.onStart();
                    }
                }

                public void onFinish() {
                    if (callback != null) {
                        callback.onFinish();
                    }
                }
            }, bduss);
        } else if (callback != null) {
            result.setResultCode(-101);
            callback.onBdussEmpty(result);
        }
    }

    /* renamed from: a */
    void m16181a(GetDynamicPwdCallback callback, String phoneNumber, String captcha) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetDynamicPwdResult result = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(phoneNumber)) {
            result.setResultCode(-101);
            callback.onFailure(result);
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map postParams = m16169a(C4923f.f20616u);
            postParams.put("username", phoneNumber);
            postParams.put("svcd", "1");
            if (!(TextUtils.isEmpty(this.f20402f) || TextUtils.isEmpty(this.f20403g) || TextUtils.isEmpty(captcha))) {
                postParams.put("vcodestr", this.f20402f);
                postParams.put("vcodesign", this.f20403g);
                postParams.put("verifycode", captcha);
            }
            postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
            final GetDynamicPwdCallback getDynamicPwdCallback = callback;
            final String str = phoneNumber;
            final String str2 = captcha;
            this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20616u, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: e */
                final /* synthetic */ C4890a f20256e;

                protected void onStart() {
                    getDynamicPwdCallback.onStart();
                }

                protected void onFinish() {
                    getDynamicPwdCallback.onFinish();
                }

                public void onSuccess(int statusCode, String content) {
                    this.f20256e.f20401e.m16132d();
                    int resultCode = this.f20256e.m16218b(content);
                    result.setResultCode(resultCode);
                    try {
                        JSONObject sdkJSONObj = new JSONObject(content).optJSONObject("sdk");
                        result.setResultMsg(sdkJSONObj.optString("msg"));
                        switch (resultCode) {
                            case 0:
                                getDynamicPwdCallback.onSuccess(result);
                                return;
                            case 5:
                                this.f20256e.f20402f = sdkJSONObj.optString("vcodestr");
                                this.f20256e.f20403g = sdkJSONObj.optString("vcodesign");
                                getDynamicPwdCallback.onCaptchaRequired(result);
                                return;
                            default:
                                getDynamicPwdCallback.onFailure(result);
                                return;
                        }
                    } catch (Exception e) {
                        getDynamicPwdCallback.onFailure(result);
                        C4913L.m16374e(e);
                    }
                    getDynamicPwdCallback.onFailure(result);
                    C4913L.m16374e(e);
                }

                public void onFailure(Throwable error, String content) {
                    if (this.f20256e.f20401e.m16131c()) {
                        this.f20256e.f20401e.m16132d();
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getDynamicPwdCallback.onFailure(result);
                        return;
                    }
                    this.f20256e.f20401e.m16130b();
                    this.f20256e.m16181a(getDynamicPwdCallback, str, str2);
                }
            });
        } else {
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16196a(SapiCallback<DynamicPwdLoginResult> callback, String phoneNumber, String dynamicPwd) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final DynamicPwdLoginResult result = new DynamicPwdLoginResult();
        if (TextUtils.isEmpty(phoneNumber)) {
            result.setResultCode(-101);
            callback.onFailure(result);
        } else if (TextUtils.isEmpty(dynamicPwd)) {
            result.setResultCode(-102);
            callback.onFailure(result);
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map postParams = m16169a(C4923f.f20596a);
            postParams.put("crypttype", String.valueOf(6));
            postParams.put("cert_id", String.valueOf(1));
            postParams.put("isphone", "1");
            postParams.put("isdpass", "1");
            final SapiDataEncryptor encryptor = new SapiDataEncryptor();
            try {
                JSONObject obj = new JSONObject();
                obj.put("username", phoneNumber);
                obj.put("password", dynamicPwd);
                obj.put("login_type", "3");
                obj.put("key", encryptor.m16384a());
                postParams.put("userinfo", encryptor.m16386a(C4914a.f20514b, obj.toString()));
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                RequestParams params = new RequestParams(postParams);
                final SapiCallback<DynamicPwdLoginResult> sapiCallback = callback;
                final String str = phoneNumber;
                final String str2 = dynamicPwd;
                this.f20400d.post(this.f20399c.context, m16244r(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: f */
                    final /* synthetic */ C4890a f20306f;

                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20306f.f20401e.m16132d();
                        int resultCode = this.f20306f.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject userInfoJSONObj = new JSONObject(encryptor.m16385a(new JSONObject(responseBody).optString("userinfo")));
                            result.setResultMsg(userInfoJSONObj.optJSONObject("sdk").optString("msg"));
                            switch (resultCode) {
                                case 0:
                                    SapiAccount account = this.f20306f.m16167a(userInfoJSONObj);
                                    if (sapiCallback instanceof SapiCallbackInterceptor) {
                                        try {
                                            result.session = account;
                                            ((SapiCallbackInterceptor) sapiCallback).beforeSuccess(result);
                                        } catch (Throwable e) {
                                            C4913L.m16374e(e);
                                        }
                                    }
                                    C4908a.m16342a().m16350a(account);
                                    sapiCallback.onSuccess(result);
                                    return;
                                default:
                                    sapiCallback.onFailure(result);
                                    return;
                            }
                        } catch (Exception e2) {
                            sapiCallback.onFailure(result);
                            C4913L.m16374e(e2);
                        }
                        sapiCallback.onFailure(result);
                        C4913L.m16374e(e2);
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20306f.f20401e.m16131c()) {
                            this.f20306f.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(result);
                            return;
                        }
                        this.f20306f.f20401e.m16130b();
                        this.f20306f.m16196a(sapiCallback, str, str2);
                    }
                });
            } catch (Exception e) {
                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                callback.onFailure(result);
                C4913L.m16374e(e);
            }
        } else {
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    boolean m16217a(SapiCallBack<SapiAccountResponse> callBack, String username, String password, boolean needShare) {
        if (this.f20399c == null || this.f20399c.context == null) {
            return false;
        }
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            final SapiDataEncryptor helper = new SapiDataEncryptor();
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            final SapiCallBack<SapiAccountResponse> sapiCallBack = callBack;
            final boolean z = needShare;
            final String str = username;
            final String str2 = password;
            this.f20400d.get(this.f20399c.context, m16164z(), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: f */
                final /* synthetic */ C4890a f20342f;

                public void onFailure(Throwable error, String content) {
                    super.onFailure(error, content);
                    JSONObject obj = new JSONObject();
                    String json = "";
                    try {
                        obj.put("failure_info", content);
                        json = obj.toString();
                    } catch (JSONException e) {
                        this.f20342f.m16173a(-100, sapiCallBack, json, z, helper);
                        C4913L.m16374e(e);
                    }
                    if (this.f20342f.f20401e.m16131c()) {
                        this.f20342f.f20401e.m16132d();
                        this.f20342f.m16173a(-100, sapiCallBack, json, z, helper);
                        return;
                    }
                    this.f20342f.f20401e.m16130b();
                    this.f20342f.m16217a(sapiCallBack, str, str2, z);
                }

                public void onSuccess(int statusCode, String content) {
                    super.onSuccess(statusCode, content);
                    try {
                        JSONObject jSONObject = new JSONObject(content);
                        this.f20342f.m16155a(sapiCallBack, jSONObject.optString("cert"), jSONObject.optString("cert_id"), str, str2, z, helper);
                    } catch (Exception e) {
                        this.f20342f.m16173a(-100, sapiCallBack, content, z, helper);
                        C4913L.m16374e(e);
                    }
                }
            });
            return true;
        }
        if (callBack != null) {
            callBack.onNetworkFailed();
        }
        return true;
    }

    /* renamed from: a */
    private void m16155a(SapiCallBack<SapiAccountResponse> callBack, String cert, String certid, String username, String password, boolean needShare, SapiDataEncryptor helper) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        this.f20400d = new AsyncHttpClient();
        this.f20400d.setUserAgent(m16162x());
        Map postParams = new HashMap();
        postParams.put("crypttype", C2578b.f8568g);
        postParams.put("tpl", this.f20399c.tpl);
        postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
        String cuid = this.f20399c.clientId;
        if (!TextUtils.isEmpty(cuid)) {
            postParams.put("cuid", cuid);
        }
        postParams.put("cert_id", certid);
        postParams.put("isdpass", "1");
        JSONObject obj = new JSONObject();
        obj.put("username", username);
        obj.put("isphone", "1");
        obj.put("password", password);
        obj.put("login_type", "3");
        obj.put("key", helper.m16384a());
        obj.put("sdk_version", "2");
        obj.put("pinfo", C4922e.m16412b());
        postParams.put("userinfo", helper.m16386a(cert, obj.toString()));
        postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
        RequestParams params = new RequestParams(postParams);
        AsyncHttpClient asyncHttpClient = this.f20400d;
        Context context = this.f20399c.context;
        final SapiCallBack<SapiAccountResponse> sapiCallBack = callBack;
        final boolean z = needShare;
        final SapiDataEncryptor sapiDataEncryptor = helper;
        final String str = username;
        final String str2 = password;
        asyncHttpClient.post(context, m16244r(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
            /* renamed from: f */
            final /* synthetic */ C4890a f20371f;

            public void onSuccess(int statusCode, String content) {
                super.onSuccess(statusCode, content);
                this.f20371f.m16173a(this.f20371f.m16218b(content), sapiCallBack, content, z, sapiDataEncryptor);
            }

            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                if (this.f20371f.f20401e.m16131c()) {
                    this.f20371f.f20401e.m16132d();
                    this.f20371f.m16173a(this.f20371f.m16218b(content), sapiCallBack, content, z, sapiDataEncryptor);
                    return;
                }
                this.f20371f.f20401e.m16130b();
                this.f20371f.m16217a(sapiCallBack, str, str2, z);
            }
        });
    }

    /* renamed from: a */
    void m16173a(int code, SapiCallBack<SapiAccountResponse> callBack, String json, boolean needShare, SapiDataEncryptor helper) {
        if (json != null) {
            SapiAccountResponse response = new SapiAccountResponse();
            try {
                String strUserInfo = new JSONObject(json).optString("userinfo");
                String decryptStr = "";
                if (!TextUtils.isEmpty(strUserInfo)) {
                    decryptStr = helper.m16385a(strUserInfo);
                    JSONObject jsonInfo = new JSONObject(decryptStr);
                    response.displayname = jsonInfo.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    response.username = jsonInfo.optString("uname");
                    response.uid = jsonInfo.optString("uid");
                    response.email = jsonInfo.optString("email");
                    response.bduss = jsonInfo.optString("bduss");
                    response.ptoken = jsonInfo.optString(SapiAccountManager.SESSION_PTOKEN);
                    response.stoken = jsonInfo.optString(SapiAccountManager.SESSION_STOKEN);
                    response.authSid = jsonInfo.optString("authsid");
                }
                if (callBack != null) {
                    switch (code) {
                        case 0:
                            if (needShare) {
                                SapiAccount account = m16166a(response);
                                account.extra = decryptStr;
                                C4908a.m16342a().m16350a(account);
                            }
                            callBack.onSuccess(response);
                            return;
                        default:
                            callBack.onSystemError(code);
                            return;
                    }
                }
            } catch (Exception e) {
                C4913L.m16374e(e);
                if (callBack != null) {
                    callBack.onSystemError(-100);
                }
            }
        } else if (callBack != null) {
            callBack.onSystemError(code);
        }
    }

    /* renamed from: a */
    void m16214a(SapiCallBack<SapiResponse> callBack, String bduss, String ptoken, String stoken, byte[] file, String contentType) {
        if (callBack == null) {
            throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (file == null || file.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            String mime;
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map<String, String> paramMap = new HashMap();
            paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
            paramMap.put("tpl", this.f20399c.tpl);
            if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                paramMap.put("clientid", this.f20399c.clientId);
            }
            if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                paramMap.put("clientip", this.f20399c.clientIp);
            }
            paramMap.put("bduss", bduss);
            if (!TextUtils.isEmpty(ptoken)) {
                paramMap.put(SapiAccountManager.SESSION_PTOKEN, ptoken);
            }
            if (!TextUtils.isEmpty(stoken)) {
                paramMap.put(SapiAccountManager.SESSION_STOKEN, stoken);
            }
            String sig = m16138a((Map) paramMap, this.f20399c.appSignKey);
            RequestParams params = new MultipartRequestParams();
            for (Entry<String, String> entry : paramMap.entrySet()) {
                params.put((String) entry.getKey(), (String) entry.getValue());
            }
            params.put("sig", sig);
            if (TextUtils.isEmpty(contentType)) {
                mime = "image/jpeg";
            } else {
                mime = contentType;
            }
            params.put(C2924g.f12889c, new ByteArrayInputStream(file), "portrait.jpg", mime);
            AsyncHttpClient asyncHttpClient = this.f20400d;
            Context context = this.f20399c.context;
            final SapiCallBack<SapiResponse> sapiCallBack = callBack;
            final String str = bduss;
            final String str2 = ptoken;
            final String str3 = stoken;
            final byte[] bArr = file;
            final String str4 = contentType;
            asyncHttpClient.post(context, m16239m(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: g */
                final /* synthetic */ C4890a f20378g;

                public void onFailure(Throwable error, String content) {
                    if (this.f20378g.f20401e.m16131c()) {
                        this.f20378g.f20401e.m16132d();
                        sapiCallBack.onSystemError(-100);
                        return;
                    }
                    this.f20378g.f20401e.m16130b();
                    this.f20378g.m16214a(sapiCallBack, str, str2, str3, bArr, str4);
                }

                public void onSuccess(int statusCode, String content) {
                    this.f20378g.f20401e.m16132d();
                    int errorNo = this.f20378g.m16218b(content);
                    if (errorNo == 0) {
                        SapiResponse response = new SapiResponse();
                        response.errorCode = errorNo;
                        response.errorMsg = SetPortraitResult.RESULT_MSG_SUCCESS;
                        sapiCallBack.onSuccess(response);
                        return;
                    }
                    sapiCallBack.onSystemError(errorNo);
                }
            });
        } else {
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: a */
    void m16199a(SetPortraitCallback callback, String bduss, byte[] file, String contentType) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (file == null || file.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        } else {
            final SetPortraitResult result = new SetPortraitResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                String mime;
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map paramMap = new HashMap();
                paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
                paramMap.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    paramMap.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    paramMap.put("clientip", this.f20399c.clientIp);
                }
                paramMap.put("bduss", bduss);
                String sig = m16138a(paramMap, this.f20399c.appSignKey);
                MultipartRequestParams params = new MultipartRequestParams();
                for (Entry<String, String> entry : paramMap.entrySet()) {
                    params.put((String) entry.getKey(), (String) entry.getValue());
                }
                params.put("sig", sig);
                if (TextUtils.isEmpty(contentType)) {
                    mime = "image/jpeg";
                } else {
                    mime = contentType;
                }
                params.put(C2924g.f12889c, new ByteArrayInputStream(file), "portrait.jpg", mime);
                AsyncHttpClient asyncHttpClient = this.f20400d;
                Context context = this.f20399c.context;
                final SetPortraitCallback setPortraitCallback = callback;
                final String str = bduss;
                final byte[] bArr = file;
                final String str2 = contentType;
                asyncHttpClient.post(context, m16239m(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: f */
                    final /* synthetic */ C4890a f20384f;

                    protected void onStart() {
                        setPortraitCallback.onStart();
                    }

                    protected void onFinish() {
                        setPortraitCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20384f.f20401e.m16132d();
                        result.setResultCode(this.f20384f.m16218b(responseBody));
                        switch (result.getResultCode()) {
                            case 0:
                                setPortraitCallback.onSuccess(result);
                                return;
                            case 160103:
                                setPortraitCallback.onBdussExpired(result);
                                return;
                            default:
                                setPortraitCallback.onFailure(result);
                                return;
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20384f.f20401e.m16131c()) {
                            this.f20384f.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            setPortraitCallback.onFailure(result);
                            return;
                        }
                        this.f20384f.f20401e.m16130b();
                        this.f20384f.m16199a(setPortraitCallback, str, bArr, str2);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16198a(SetPopularPortraitCallback callback, SetPopularPortraitDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException("SetPopularPortraitCallback can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException("SetPopularPortraitDto can't be null");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (TextUtils.isEmpty(dto.series)) {
            throw new IllegalArgumentException("series can't be empty");
        } else {
            final SetPopularPortraitResult result = new SetPopularPortraitResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map paramMap = new HashMap();
                paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
                paramMap.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    paramMap.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    paramMap.put("clientip", this.f20399c.clientIp);
                }
                paramMap.put("bduss", dto.bduss);
                paramMap.put("serie", dto.series);
                paramMap.put("num", String.valueOf(dto.num));
                String sig = m16138a(paramMap, this.f20399c.appSignKey);
                MultipartRequestParams params = new MultipartRequestParams();
                for (Entry<String, String> entry : paramMap.entrySet()) {
                    params.put((String) entry.getKey(), (String) entry.getValue());
                }
                params.put("sig", sig);
                final SetPopularPortraitCallback setPopularPortraitCallback = callback;
                final SetPopularPortraitDTO setPopularPortraitDTO = dto;
                this.f20400d.post(this.f20399c.context, m16243q(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20388d;

                    public void onFailure(Throwable error, String content) {
                        if (this.f20388d.f20401e.m16131c()) {
                            this.f20388d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            setPopularPortraitCallback.onFailure(result);
                            return;
                        }
                        this.f20388d.f20401e.m16130b();
                        this.f20388d.m16198a(setPopularPortraitCallback, setPopularPortraitDTO);
                    }

                    public void onSuccess(int statusCode, String content) {
                        this.f20388d.f20401e.m16132d();
                        try {
                            JSONObject obj = new JSONObject(content);
                            int errorNo = obj.getInt(C2125n.f6745M);
                            result.setResultCode(errorNo);
                            result.setResultMsg(obj.optString(C2125n.f6746N));
                            if (errorNo == 0) {
                                setPopularPortraitCallback.onSuccess(result);
                            } else {
                                setPopularPortraitCallback.onFailure(result);
                            }
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            setPopularPortraitCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }
                    }

                    public void onStart() {
                        setPopularPortraitCallback.onStart();
                    }

                    public void onFinish() {
                        setPopularPortraitCallback.onFinish();
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    public void m16213a(SapiCallBack<GetPortraitResponse> callBack, String bduss, String ptoken, String stoken) {
        if (callBack == null) {
            throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map paramMap = new HashMap();
            paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
            paramMap.put("tpl", this.f20399c.tpl);
            if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                paramMap.put("clientid", this.f20399c.clientId);
            }
            if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                paramMap.put("clientip", this.f20399c.clientIp);
            }
            paramMap.put("bduss", bduss);
            if (!TextUtils.isEmpty(ptoken)) {
                paramMap.put(SapiAccountManager.SESSION_PTOKEN, ptoken);
            }
            if (!TextUtils.isEmpty(stoken)) {
                paramMap.put(SapiAccountManager.SESSION_STOKEN, stoken);
            }
            String sig = m16138a(paramMap, this.f20399c.appSignKey);
            RequestParams params = new RequestParams();
            for (Entry<String, String> entry : paramMap.entrySet()) {
                params.put((String) entry.getKey(), (String) entry.getValue());
            }
            params.put("sig", sig);
            final SapiCallBack<GetPortraitResponse> sapiCallBack = callBack;
            final String str = bduss;
            final String str2 = ptoken;
            final String str3 = stoken;
            this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + "/v2/sapi/center/getportrait", params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: e */
                final /* synthetic */ C4890a f20393e;

                public void onFailure(Throwable error, String content) {
                    if (this.f20393e.f20401e.m16131c()) {
                        this.f20393e.f20401e.m16132d();
                        sapiCallBack.onSystemError(-100);
                        return;
                    }
                    this.f20393e.f20401e.m16130b();
                    this.f20393e.m16213a(sapiCallBack, str, str2, str3);
                }

                public void onSuccess(int statusCode, String content) {
                    this.f20393e.f20401e.m16132d();
                    int errorNo = this.f20393e.m16218b(content);
                    if (errorNo == 0) {
                        try {
                            JSONObject obj = new JSONObject(content);
                            GetPortraitResponse response = new GetPortraitResponse();
                            response.errorCode = errorNo;
                            response.errorMsg = obj.optString(C2125n.f6746N);
                            if (!TextUtils.isEmpty(obj.optString(BNRCEventDetailsModel.BN_RC_KEY_POTAIT))) {
                                response.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", new Object[]{obj.optString(BNRCEventDetailsModel.BN_RC_KEY_POTAIT)});
                            }
                            sapiCallBack.onSuccess(response);
                            return;
                        } catch (JSONException e) {
                            sapiCallBack.onSystemError(errorNo);
                            C4913L.m16374e(e);
                            return;
                        }
                    }
                    sapiCallBack.onSystemError(errorNo);
                }
            });
        } else {
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: a */
    void m16182a(GetHistoryPortraitsCallback callback, GetHistoryPortraitsDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException("getHistoryPortaits callback can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException("getHistoryPortrats dto can't be null");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (dto.maxNum < 0 || dto.maxNum > 10) {
            throw new IllegalArgumentException("abnormal request history number");
        } else {
            final GetHistoryPortraitsResult result = new GetHistoryPortraitsResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map paramMap = new HashMap();
                paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
                paramMap.put("tpl", this.f20399c.tpl);
                paramMap.put("length", String.valueOf(dto.maxNum));
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    paramMap.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    paramMap.put("clientip", this.f20399c.clientIp);
                }
                paramMap.put("bduss", dto.bduss);
                String sig = m16138a(paramMap, this.f20399c.appSignKey);
                RequestParams params = new RequestParams();
                for (Entry<String, String> entry : paramMap.entrySet()) {
                    params.put((String) entry.getKey(), (String) entry.getValue());
                }
                params.put("sig", sig);
                final GetHistoryPortraitsCallback getHistoryPortraitsCallback = callback;
                final GetHistoryPortraitsDTO getHistoryPortraitsDTO = dto;
                this.f20400d.post(this.f20399c.context, m16240n(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20159d;

                    public void onFailure(Throwable error, String content) {
                        if (this.f20159d.f20401e.m16131c()) {
                            this.f20159d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            getHistoryPortraitsCallback.onFailure(result);
                            return;
                        }
                        this.f20159d.f20401e.m16130b();
                        this.f20159d.m16182a(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
                    }

                    public void onSuccess(int statusCode, String content) {
                        this.f20159d.f20401e.m16132d();
                        try {
                            JSONObject obj = new JSONObject(content);
                            int errorNo = obj.getInt(C2125n.f6745M);
                            result.setResultCode(errorNo);
                            result.setResultMsg(obj.optString(C2125n.f6746N));
                            if (errorNo == 0) {
                                JSONArray portraits = obj.optJSONArray("history");
                                int arrLen = portraits.length();
                                result.historyPortraits = new ArrayList(arrLen);
                                for (int i = 0; i < arrLen; i++) {
                                    result.historyPortraits.add(portraits.optString(i));
                                }
                                getHistoryPortraitsCallback.onSuccess(result);
                                return;
                            }
                            getHistoryPortraitsCallback.onFailure(result);
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            getHistoryPortraitsCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16183a(GetPopularPortraitsCallback callback, String bduss) {
        if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty nor null");
        }
        final GetPopularPortraitsInfoResult result = new GetPopularPortraitsInfoResult();
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map<String, String> paramMap = new HashMap();
            paramMap.put("bduss", bduss);
            RequestParams params = new RequestParams();
            for (Entry<String, String> entry : paramMap.entrySet()) {
                params.put((String) entry.getKey(), (String) entry.getValue());
            }
            final GetPopularPortraitsCallback getPopularPortraitsCallback = callback;
            final String str = bduss;
            this.f20400d.post(this.f20399c.context, m16242p(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: d */
                final /* synthetic */ C4890a f20163d;

                public void onStart() {
                    getPopularPortraitsCallback.onStart();
                }

                public void onFinish() {
                    getPopularPortraitsCallback.onFinish();
                }

                public void onFailure(Throwable error, String content) {
                    if (this.f20163d.f20401e.m16131c()) {
                        this.f20163d.f20401e.m16132d();
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getPopularPortraitsCallback.onFailure(result);
                        return;
                    }
                    this.f20163d.f20401e.m16130b();
                    this.f20163d.m16183a(getPopularPortraitsCallback, str);
                }

                public void onSuccess(int statusCode, String content) {
                    this.f20163d.f20401e.m16132d();
                    try {
                        JSONObject obj = new JSONObject(content);
                        int errno = obj.optInt(C2125n.f6745M);
                        result.setResultCode(errno);
                        result.setResultMsg(obj.optString(C2125n.f6746N));
                        if (errno == 0) {
                            JSONArray infoList = obj.optJSONArray("list");
                            int infoListLen = infoList.length();
                            result.popularPortraitsInfoList = new ArrayList(infoListLen);
                            for (int i = 0; i < infoListLen; i++) {
                                JSONObject info = infoList.optJSONObject(i);
                                if (info != null) {
                                    PopularPortraitsInfo item = new PopularPortraitsInfo();
                                    item.num = info.optInt("num");
                                    item.series = info.optString("serie");
                                    item.url = info.optString("url");
                                    item.myItem = info.optInt("myitem");
                                    result.popularPortraitsInfoList.add(item);
                                }
                            }
                            getPopularPortraitsCallback.onSuccess(result);
                            return;
                        }
                        getPopularPortraitsCallback.onFailure(result);
                    } catch (JSONException e) {
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getPopularPortraitsCallback.onFailure(result);
                        C4913L.m16374e(e);
                    }
                }
            });
            return;
        }
        result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
        callback.onFailure(result);
    }

    /* renamed from: a */
    void m16185a(GetUserInfoCallback callback, String bduss) {
        if (callback == null) {
            throw new IllegalArgumentException(GetUserInfoCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final GetUserInfoResult result = new GetUserInfoResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map paramMap = new HashMap();
                paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
                paramMap.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    paramMap.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    paramMap.put("clientip", this.f20399c.clientIp);
                }
                paramMap.put("bduss", bduss);
                String sig = m16138a(paramMap, this.f20399c.appSignKey);
                RequestParams params = new RequestParams();
                for (Entry<String, String> entry : paramMap.entrySet()) {
                    params.put((String) entry.getKey(), (String) entry.getValue());
                }
                params.put("sig", sig);
                final GetUserInfoCallback getUserInfoCallback = callback;
                final String str = bduss;
                this.f20400d.post(this.f20399c.context, m16241o(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20172d;

                    protected void onStart() {
                        getUserInfoCallback.onStart();
                    }

                    protected void onFinish() {
                        getUserInfoCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20172d.f20401e.m16132d();
                        int resultCode = this.f20172d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        switch (resultCode) {
                            case 0:
                                try {
                                    JSONObject obj = new JSONObject(responseBody);
                                    result.portraitSign = obj.optString("portrait_tag");
                                    result.isInitialPortrait = "0".equals(result.portraitSign);
                                    if (!TextUtils.isEmpty(obj.optString(BNRCEventDetailsModel.BN_RC_KEY_POTAIT))) {
                                        result.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[]{portrait, result.portraitSign});
                                    }
                                    result.username = obj.optString("username");
                                    result.uid = obj.optString("userid");
                                    result.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                    result.incompleteUser = "1".equals(obj.optString("incomplete_user"));
                                    result.secureMobile = obj.optString("securemobil");
                                    result.secureEmail = obj.optString("secureemail");
                                    result.havePwd = "1".equals(obj.optString("have_psw"));
                                    getUserInfoCallback.onSuccess(result);
                                    return;
                                } catch (Exception e) {
                                    getUserInfoCallback.onFailure(result);
                                    C4913L.m16374e(e);
                                    return;
                                }
                            case 400021:
                                getUserInfoCallback.onBdussExpired(result);
                                return;
                            default:
                                getUserInfoCallback.onFailure(result);
                                return;
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20172d.f20401e.m16131c()) {
                            this.f20172d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            getUserInfoCallback.onFailure(result);
                            return;
                        }
                        this.f20172d.f20401e.m16130b();
                        this.f20172d.m16185a(getUserInfoCallback, str);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    public void m16208a(final GetUserInfoCallBack callBack, final String bduss) {
        if (callBack == null) {
            throw new IllegalArgumentException(GetUserInfoCallBack.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            Map paramMap = new HashMap();
            paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
            paramMap.put("tpl", this.f20399c.tpl);
            if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                paramMap.put("clientid", this.f20399c.clientId);
            }
            if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                paramMap.put("clientip", this.f20399c.clientIp);
            }
            paramMap.put("bduss", bduss);
            String sig = m16138a(paramMap, this.f20399c.appSignKey);
            RequestParams params = new RequestParams();
            for (Entry<String, String> entry : paramMap.entrySet()) {
                params.put((String) entry.getKey(), (String) entry.getValue());
            }
            params.put("sig", sig);
            this.f20400d.post(this.f20399c.context, m16241o(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: c */
                final /* synthetic */ C4890a f20175c;

                protected void onSuccess(int statusCode, String responseBody) {
                    this.f20175c.f20401e.m16132d();
                    callBack.onFinish();
                    int errorNo = this.f20175c.m16218b(responseBody);
                    switch (errorNo) {
                        case 0:
                            try {
                                JSONObject obj = new JSONObject(responseBody);
                                GetUserInfoResponse response = new GetUserInfoResponse();
                                response.errorCode = errorNo;
                                response.errorMsg = obj.optString(C2125n.f6746N);
                                if (!TextUtils.isEmpty(obj.optString(BNRCEventDetailsModel.BN_RC_KEY_POTAIT))) {
                                    response.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", new Object[]{obj.optString(BNRCEventDetailsModel.BN_RC_KEY_POTAIT)});
                                }
                                response.username = obj.optString("username");
                                response.uid = obj.optString("userid");
                                response.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                response.incompleteUser = "1".equals(obj.optString("incomplete_user"));
                                response.secureMobile = obj.optString("securemobil");
                                response.secureEmail = obj.optString("secureemail");
                                callBack.onSuccess(response);
                                return;
                            } catch (JSONException e) {
                                callBack.onSystemError(errorNo);
                                C4913L.m16374e(e);
                                return;
                            }
                        case 400021:
                            callBack.onBdussInvalid();
                            return;
                        default:
                            callBack.onSystemError(errorNo);
                            return;
                    }
                }

                protected void onFailure(Throwable error, String responseBody) {
                    if (this.f20175c.f20401e.m16131c()) {
                        this.f20175c.f20401e.m16132d();
                        callBack.onFinish();
                        callBack.onSystemError(-100);
                        return;
                    }
                    this.f20175c.f20401e.m16130b();
                    this.f20175c.m16208a(callBack, bduss);
                }
            });
        } else {
            callBack.onFinish();
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: a */
    void m16180a(FillUsernameCallback callback, String bduss, String username) {
        if (callback == null) {
            throw new IllegalArgumentException(FillUsernameCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (TextUtils.isEmpty(username)) {
            throw new IllegalArgumentException("username can't be empty");
        } else {
            final FillUsernameResult result = new FillUsernameResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map paramMap = new HashMap();
                paramMap.put(SpeechConstant.APP_ID, this.f20399c.appId);
                paramMap.put("tpl", this.f20399c.tpl);
                paramMap.put("cert_id", String.valueOf(1));
                paramMap.put("crypttype", String.valueOf(6));
                JSONObject obj = new JSONObject();
                final SapiDataEncryptor encryptor = new SapiDataEncryptor();
                try {
                    obj.put("bduss", bduss);
                    if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                        obj.put("clientid", this.f20399c.clientId);
                    }
                    if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                        obj.put("clientip", this.f20399c.clientIp);
                    }
                    obj.put("username", username);
                    obj.put("key", encryptor.m16384a());
                    paramMap.put("userinfo", encryptor.m16386a(C4914a.f20514b, obj.toString()));
                    paramMap.put("sig", m16138a(paramMap, this.f20399c.appSignKey));
                    RequestParams params = new RequestParams(paramMap);
                    final FillUsernameCallback fillUsernameCallback = callback;
                    final String str = bduss;
                    final String str2 = username;
                    this.f20400d.post(this.f20399c.context, m16238l(), params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                        /* renamed from: f */
                        final /* synthetic */ C4890a f20181f;

                        protected void onStart() {
                            fillUsernameCallback.onStart();
                        }

                        protected void onFinish() {
                            fillUsernameCallback.onFinish();
                        }

                        protected void onSuccess(int statusCode, String responseBody) {
                            this.f20181f.f20401e.m16132d();
                            int resultCode = this.f20181f.m16218b(responseBody);
                            result.setResultCode(resultCode);
                            try {
                                JSONObject userInfoJSONObj = new JSONObject(encryptor.m16385a(new JSONObject(responseBody).optString("userinfo")));
                                switch (resultCode) {
                                    case 0:
                                    case 110000:
                                        SapiAccount session = new SapiAccount();
                                        session.bduss = userInfoJSONObj.optString("bduss");
                                        session.ptoken = userInfoJSONObj.optString(SapiAccountManager.SESSION_PTOKEN);
                                        session.stoken = userInfoJSONObj.optString(SapiAccountManager.SESSION_STOKEN);
                                        session.displayname = userInfoJSONObj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                        session.username = userInfoJSONObj.optString("uname");
                                        session.uid = userInfoJSONObj.optString("uid");
                                        session.extra = userInfoJSONObj.toString();
                                        C4908a.m16342a().m16350a(session);
                                        result.session = session;
                                        fillUsernameCallback.onSuccess(result);
                                        return;
                                    case 160103:
                                        fillUsernameCallback.onBdussExpired(result);
                                        return;
                                    case 160104:
                                        fillUsernameCallback.onUserHaveUsername(result);
                                        return;
                                    default:
                                        fillUsernameCallback.onFailure(result);
                                        return;
                                }
                            } catch (Throwable e) {
                                fillUsernameCallback.onFailure(result);
                                C4913L.m16374e(e);
                            }
                            fillUsernameCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }

                        protected void onFailure(Throwable error, String responseBody) {
                            if (this.f20181f.f20401e.m16131c()) {
                                this.f20181f.f20401e.m16132d();
                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                fillUsernameCallback.onFailure(result);
                                return;
                            }
                            this.f20181f.f20401e.m16130b();
                            this.f20181f.m16180a(fillUsernameCallback, str, str2);
                        }
                    });
                    return;
                } catch (Throwable e) {
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    callback.onFailure(result);
                    C4913L.m16374e(e);
                    return;
                }
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16207a(FillUsernameCallBack callBack, String bduss, String ptoken, String username) {
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            final SapiDataEncryptor helper = new SapiDataEncryptor();
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            final FillUsernameCallBack fillUsernameCallBack = callBack;
            final String str = bduss;
            final String str2 = ptoken;
            final String str3 = username;
            this.f20400d.get(this.f20399c.context, m16164z(), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: f */
                final /* synthetic */ C4890a f20187f;

                public void onFailure(Throwable error, String content) {
                    super.onFailure(error, content);
                    JSONObject obj = new JSONObject();
                    String json = "";
                    try {
                        obj.put("failure_info", content);
                        json = obj.toString();
                    } catch (JSONException e) {
                        C4913L.m16374e(e);
                    }
                    if (this.f20187f.f20401e.m16131c()) {
                        this.f20187f.f20401e.m16132d();
                        this.f20187f.m16139a(-100, fillUsernameCallBack, json, helper);
                        return;
                    }
                    this.f20187f.m16207a(fillUsernameCallBack, str, str2, str3);
                }

                public void onSuccess(int statusCode, String content) {
                    super.onSuccess(statusCode, content);
                    this.f20187f.f20401e.m16132d();
                    try {
                        JSONObject jSONObject = new JSONObject(content);
                        this.f20187f.m16154a(fillUsernameCallBack, str, str2, str3, jSONObject.optString("cert"), jSONObject.optString("cert_id"), helper);
                    } catch (Exception e) {
                        this.f20187f.m16139a(this.f20187f.m16224c(content), fillUsernameCallBack, content, helper);
                        C4913L.m16374e(e);
                    }
                }
            });
        } else if (callBack != null) {
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: a */
    private void m16154a(final FillUsernameCallBack callBack, String bduss, String ptoken, String username, String cert, String certId, SapiDataEncryptor helper) throws JSONException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException {
        this.f20400d = new AsyncHttpClient();
        this.f20400d.setUserAgent(m16162x());
        Map postParams = new HashMap();
        postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
        postParams.put("tpl", this.f20399c.tpl);
        postParams.put("cert_id", certId);
        postParams.put("crypttype", String.valueOf(6));
        JSONObject obj = new JSONObject();
        obj.put("bduss", bduss);
        if (!TextUtils.isEmpty(this.f20399c.clientId)) {
            obj.put("clientid", this.f20399c.clientId);
        }
        if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
            obj.put("clientip", this.f20399c.clientIp);
        }
        if (!TextUtils.isEmpty(ptoken)) {
            obj.put(SapiAccountManager.SESSION_PTOKEN, ptoken);
        }
        obj.put("username", username);
        obj.put("key", helper.m16384a());
        postParams.put("userinfo", helper.m16386a(cert, obj.toString()));
        postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
        final SapiDataEncryptor sapiDataEncryptor = helper;
        this.f20400d.post(this.f20399c.context, m16238l(), new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
            /* renamed from: c */
            final /* synthetic */ C4890a f20190c;

            public void onSuccess(int statusCode, String content) {
                super.onSuccess(statusCode, content);
                this.f20190c.m16139a(this.f20190c.m16224c(content), callBack, content, sapiDataEncryptor);
            }

            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                this.f20190c.m16139a(this.f20190c.m16224c(content), callBack, content, sapiDataEncryptor);
            }
        });
    }

    /* renamed from: a */
    void m16179a(FillUserProfileCallback callback, String bduss) {
        if (callback == null) {
            throw new IllegalArgumentException(FillUserProfileCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final FillUserProfileResult result = new FillUserProfileResult();
            if (!SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                callback.onFailure(result);
            } else if (SapiUtils.isSimReady(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                postParams.put("bduss", bduss);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final FillUserProfileCallback fillUserProfileCallback = callback;
                final String str = bduss;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20582G, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20198d;

                    protected void onStart() {
                        fillUserProfileCallback.onStart();
                    }

                    protected void onFinish() {
                        fillUserProfileCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            int resultCode = this.f20198d.m16218b(responseBody);
                            result.setResultCode(resultCode);
                            switch (resultCode) {
                                case 0:
                                    String smsDestination = obj.optString("sms");
                                    final String smsCode = obj.optString("vcode");
                                    final String statusChannelId = obj.optString("upsmschannel");
                                    boolean success = false;
                                    if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.f20198d.f20399c.context)) {
                                        success = SapiUtils.sendSms(this.f20198d.f20399c.context, smsCode, smsDestination);
                                    }
                                    if (!success || TextUtils.isEmpty(statusChannelId)) {
                                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                        fillUserProfileCallback.onFailure(result);
                                        return;
                                    }
                                    this.f20198d.f20400d = new AsyncHttpClient();
                                    this.f20198d.f20400d.setUserAgent(this.f20198d.m16162x());
                                    BasicCookieStore cookieStore = new BasicCookieStore();
                                    BasicClientCookie cookie = new BasicClientCookie("BAIDUID", SapiUtils.getClientId(this.f20198d.f20399c.context));
                                    cookie.setDomain("baidu.com");
                                    cookie.setPath("/");
                                    cookieStore.addCookie(cookie);
                                    this.f20198d.f20400d.setCookieStore(cookieStore);
                                    RequestParams params = new RequestParams();
                                    params.put("channel_id", statusChannelId);
                                    params.put("callback", "p");
                                    params.put("apiver", "v3");
                                    params.put("tt", String.valueOf(System.currentTimeMillis()));
                                    this.f20198d.f20400d.get(this.f20198d.f20399c.context, "https://passport.baidu.com/channel/unicast", params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                                        /* renamed from: c */
                                        final /* synthetic */ AnonymousClass18 f20194c;

                                        protected void onStart() {
                                            fillUserProfileCallback.onStart();
                                        }

                                        protected void onFinish() {
                                            fillUserProfileCallback.onFinish();
                                        }

                                        protected void onSuccess(int statusCode, String responseText) {
                                            if (TextUtils.isEmpty(responseText)) {
                                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                fillUserProfileCallback.onFailure(result);
                                                return;
                                            }
                                            int dataStart = responseText.indexOf("(");
                                            int dataEnd = responseText.indexOf(")");
                                            if (dataStart >= 0) {
                                                try {
                                                    int resultCode = this.f20194c.f20198d.m16218b(responseText.substring(dataStart + 1, dataEnd));
                                                    result.setResultCode(resultCode);
                                                    switch (resultCode) {
                                                        case 0:
                                                            Map postParams = new HashMap();
                                                            postParams.put(SpeechConstant.APP_ID, this.f20194c.f20198d.f20399c.appId);
                                                            postParams.put("tpl", this.f20194c.f20198d.f20399c.tpl);
                                                            if (!TextUtils.isEmpty(this.f20194c.f20198d.f20399c.clientId)) {
                                                                postParams.put("clientid", this.f20194c.f20198d.f20399c.clientId);
                                                            }
                                                            postParams.put("upsmschannel", statusChannelId);
                                                            postParams.put("bduss", str);
                                                            postParams.put("vcode", smsCode);
                                                            postParams.put("sig", this.f20194c.f20198d.m16138a(postParams, this.f20194c.f20198d.f20399c.appSignKey));
                                                            this.f20194c.f20198d.f20400d = new AsyncHttpClient();
                                                            this.f20194c.f20198d.f20400d.setUserAgent(this.f20194c.f20198d.m16162x());
                                                            this.f20194c.f20198d.f20400d.post(this.f20194c.f20198d.f20399c.context, this.f20194c.f20198d.f20401e.m16129a() + C4923f.f20583H, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                                                                /* renamed from: a */
                                                                final /* synthetic */ C48781 f20191a;

                                                                protected void onStart() {
                                                                    fillUserProfileCallback.onStart();
                                                                }

                                                                protected void onFinish() {
                                                                    fillUserProfileCallback.onFinish();
                                                                }

                                                                protected void onSuccess(int statusCode, String resBody) {
                                                                    try {
                                                                        int resultCode = this.f20191a.f20194c.f20198d.m16218b(resBody);
                                                                        result.setResultCode(resultCode);
                                                                        switch (resultCode) {
                                                                            case 0:
                                                                                SapiAccount account = new SapiAccount();
                                                                                JSONObject obj = new JSONObject(resBody);
                                                                                account.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                                                                account.bduss = obj.optString("bduss");
                                                                                account.uid = obj.optString("uid");
                                                                                account.ptoken = obj.optString(SapiAccountManager.SESSION_PTOKEN);
                                                                                account.stoken = obj.optString(SapiAccountManager.SESSION_STOKEN);
                                                                                result.session = account;
                                                                                fillUserProfileCallback.onSuccess(result);
                                                                                return;
                                                                            default:
                                                                                fillUserProfileCallback.onFailure(result);
                                                                                return;
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                                        fillUserProfileCallback.onFailure(result);
                                                                    }
                                                                }

                                                                protected void onFailure(Throwable error, String responseBody) {
                                                                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                                    fillUserProfileCallback.onFailure(result);
                                                                }
                                                            });
                                                            return;
                                                        default:
                                                            fillUserProfileCallback.onFailure(result);
                                                            return;
                                                    }
                                                } catch (Throwable e) {
                                                    C4913L.m16374e(e);
                                                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                    fillUserProfileCallback.onFailure(result);
                                                    return;
                                                }
                                                C4913L.m16374e(e);
                                                result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                fillUserProfileCallback.onFailure(result);
                                                return;
                                            }
                                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                            fillUserProfileCallback.onFailure(result);
                                        }

                                        protected void onFailure(Throwable error, String responseText) {
                                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                            fillUserProfileCallback.onFailure(result);
                                        }
                                    });
                                    return;
                                case 1:
                                    fillUserProfileCallback.onBdussExpired(result);
                                    return;
                                case FillUserProfileResult.RESULT_CODE_COMPLETE_USER /*61002*/:
                                    fillUserProfileCallback.onCompleteUser(result);
                                    return;
                                default:
                                    fillUserProfileCallback.onFailure(result);
                                    return;
                            }
                        } catch (Throwable th) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            fillUserProfileCallback.onFailure(result);
                        }
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        fillUserProfileCallback.onFailure(result);
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        fillUserProfileCallback.onFailure(result);
                    }
                });
            } else {
                result.setResultCode(-101);
                callback.onFailure(result);
            }
        }
    }

    /* renamed from: a */
    void m16200a(VoiceCheckCallback callback, VoiceCheckDTO voiceCheckDTO) {
        if (callback == null) {
            throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
        } else if (voiceCheckDTO == null) {
            throw new IllegalArgumentException(VoiceCheckDTO.class.getSimpleName() + " can't be null");
        } else {
            final VoiceCheckResult result = new VoiceCheckResult();
            if (TextUtils.isEmpty(voiceCheckDTO.account)) {
                result.setResultCode(-101);
                callback.onFailure(result);
            } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20584I);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put("username", voiceCheckDTO.account);
                if (voiceCheckDTO.accountType == null || voiceCheckDTO.accountType == AccountType.MERGE) {
                    postParams.put("merge", "1");
                }
                if (voiceCheckDTO.accountType == AccountType.USERNAME) {
                    postParams.put("isphone", "0");
                }
                if (voiceCheckDTO.accountType == AccountType.PHONE) {
                    postParams.put("isphone", "1");
                }
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final VoiceCheckCallback voiceCheckCallback = callback;
                final VoiceCheckDTO voiceCheckDTO2 = voiceCheckDTO;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20584I, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20202d;

                    protected void onStart() {
                        voiceCheckCallback.onStart();
                    }

                    protected void onFinish() {
                        voiceCheckCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20202d.f20401e.m16132d();
                        this.f20202d.m16152a(voiceCheckCallback, responseBody);
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20202d.f20401e.m16131c()) {
                            this.f20202d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceCheckCallback.onFailure(result);
                            return;
                        }
                        this.f20202d.f20401e.m16130b();
                        this.f20202d.m16200a(voiceCheckCallback, voiceCheckDTO2);
                    }
                });
            } else {
                result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
                callback.onFailure(result);
            }
        }
    }

    /* renamed from: a */
    void m16201a(VoiceCheckCallback callback, String bduss, String uid) {
        if (callback == null) {
            throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss) && TextUtils.isEmpty(uid)) {
            throw new IllegalArgumentException("either uid or bduss should be assigned");
        } else {
            final VoiceCheckResult result = new VoiceCheckResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20584I);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                if (!TextUtils.isEmpty(bduss)) {
                    postParams.put("bduss", bduss);
                }
                if (!TextUtils.isEmpty(uid)) {
                    postParams.put("userid", uid);
                }
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final VoiceCheckCallback voiceCheckCallback = callback;
                final String str = bduss;
                final String str2 = uid;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20584I, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: e */
                    final /* synthetic */ C4890a f20210e;

                    protected void onStart() {
                        voiceCheckCallback.onStart();
                    }

                    protected void onFinish() {
                        voiceCheckCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20210e.f20401e.m16132d();
                        this.f20210e.m16152a(voiceCheckCallback, responseBody);
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20210e.f20401e.m16131c()) {
                            this.f20210e.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceCheckCallback.onFailure(result);
                            return;
                        }
                        this.f20210e.f20401e.m16130b();
                        this.f20210e.m16201a(voiceCheckCallback, str, str2);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    private void m16152a(VoiceCheckCallback callback, String json) {
        VoiceCheckResult result = new VoiceCheckResult();
        JSONObject obj = new JSONObject(json);
        int resultCode = Integer.parseInt(obj.optString(C2125n.f6745M));
        result.setResultCode(resultCode);
        switch (resultCode) {
            case 0:
                result.uid = SapiDataEncryptor.m16381b(obj.optString("id"), SapiDataEncryptor.f20517a);
                result.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                result.signUp = "1".equals(obj.optString("voice"));
                result.needVerify = "1".equals(obj.optString("needverify"));
                result.authToken = obj.optString("token");
                if (TextUtils.isEmpty(obj.optString("loginswitch")) || !obj.optString("loginswitch").equals("1")) {
                    try {
                        result.switchState = Switch.OFF;
                    } catch (Exception e) {
                        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        callback.onFailure(result);
                    }
                }
                result.switchState = Switch.ON;
                if ("null".equals(result.authToken)) {
                    result.authToken = null;
                }
                result.authSid = obj.optString("authsid");
                if ("null".equals(result.authSid)) {
                    result.authSid = null;
                }
                try {
                    result.voiceCode = Integer.parseInt(SapiDataEncryptor.m16381b(obj.optString("password"), SapiDataEncryptor.f20517a));
                } catch (Exception e2) {
                    result.voiceCode = -1;
                    C4913L.m16374e(e2);
                }
                callback.onSuccess(result);
                return;
            case 3:
                callback.onIncompleteUser(result);
                return;
            case 400021:
                callback.onBdussExpired(result);
                return;
            case VoiceCheckResult.RESULT_CODE_ACCOUNT_TYPE_CONFLICT /*400401*/:
                callback.onAccountTypeConflict(result);
                return;
            default:
                callback.onFailure(result);
                return;
        }
        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
        callback.onFailure(result);
    }

    /* renamed from: b */
    void m16221b(SapiCallback<OAuthResult> callback, String bduss) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final OAuthResult result = new OAuthResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("bduss", bduss);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final SapiCallback<OAuthResult> sapiCallback = callback;
                final String str = bduss;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20581F, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20214d;

                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20214d.f20401e.m16132d();
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            int resultCode = Integer.parseInt(obj.optString(C2125n.f6745M));
                            result.setResultCode(resultCode);
                            switch (resultCode) {
                                case 0:
                                    result.accessToken = obj.optString("access_token");
                                    result.expiresIn = obj.optInt("expires_in");
                                    result.scope = obj.optString("scope");
                                    result.refreshToken = obj.optString("refresh_token");
                                    result.sessionKey = obj.optString("session_key");
                                    result.sessionSecret = obj.optString("session_secret");
                                    result.extra = responseBody;
                                    sapiCallback.onSuccess(result);
                                    return;
                                default:
                                    sapiCallback.onFailure(result);
                                    return;
                            }
                        } catch (Throwable th) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20214d.f20401e.m16131c()) {
                            this.f20214d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(result);
                            return;
                        }
                        this.f20214d.f20401e.m16130b();
                        this.f20214d.m16221b(sapiCallback, str);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16197a(SapiCallback<VoiceRegResult> callback, String voiceMd5, String bduss, String authSid, boolean newUser) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(voiceMd5)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        } else {
            final VoiceRegResult result = new VoiceRegResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20585J);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put("voicemd5", voiceMd5);
                if (!TextUtils.isEmpty(bduss)) {
                    postParams.put("bduss", bduss);
                }
                if (!TextUtils.isEmpty(authSid)) {
                    postParams.put("authsid", authSid);
                }
                if (newUser) {
                    postParams.put("newuser", "1");
                } else {
                    postParams.put("newuser", "0");
                }
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                RequestParams params = new RequestParams(postParams);
                final SapiCallback<VoiceRegResult> sapiCallback = callback;
                final boolean z = newUser;
                final String str = voiceMd5;
                final String str2 = bduss;
                final String str3 = authSid;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20585J, params, new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: g */
                    final /* synthetic */ C4890a f20221g;

                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20221g.f20401e.m16132d();
                        this.f20221g.m16151a(sapiCallback, responseBody, z);
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20221g.f20401e.m16131c()) {
                            this.f20221g.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(result);
                            return;
                        }
                        this.f20221g.f20401e.m16130b();
                        this.f20221g.m16197a(sapiCallback, str, str2, str3, z);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    private void m16151a(SapiCallback<VoiceRegResult> callback, String json, boolean newUser) {
        VoiceRegResult result = new VoiceRegResult();
        try {
            JSONObject obj = new JSONObject(json);
            int resultCode = Integer.parseInt(obj.optString(C2125n.f6745M));
            result.setResultCode(resultCode);
            switch (resultCode) {
                case 0:
                    if (newUser) {
                        C4908a.m16342a().m16350a(m16167a(obj));
                    }
                    callback.onSuccess(result);
                    return;
                default:
                    callback.onFailure(result);
                    return;
            }
        } catch (Exception e) {
            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16203a(VoiceLoginCallback callback, String voiceMd5, String uid) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(voiceMd5)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        } else if (TextUtils.isEmpty(uid)) {
            throw new IllegalArgumentException("uid can't be empty");
        } else {
            final VoiceLoginResult result = new VoiceLoginResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20586K);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put("voicemd5", voiceMd5);
                postParams.put("id", SapiDataEncryptor.m16383c(uid, SapiDataEncryptor.f20517a));
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final VoiceLoginCallback voiceLoginCallback = callback;
                final String str = voiceMd5;
                final String str2 = uid;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20586K, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: e */
                    final /* synthetic */ C4890a f20231e;

                    protected void onStart() {
                        voiceLoginCallback.onStart();
                    }

                    protected void onFinish() {
                        voiceLoginCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20231e.f20401e.m16132d();
                        this.f20231e.m16153a(voiceLoginCallback, responseBody);
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20231e.f20401e.m16131c()) {
                            this.f20231e.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceLoginCallback.onFailure(result);
                            return;
                        }
                        this.f20231e.f20401e.m16130b();
                        this.f20231e.m16203a(voiceLoginCallback, str, str2);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    private void m16153a(VoiceLoginCallback callback, String json) {
        VoiceLoginResult result = new VoiceLoginResult();
        try {
            JSONObject obj = new JSONObject(json);
            int resultCode = Integer.parseInt(obj.optString(C2125n.f6745M));
            result.setResultCode(resultCode);
            switch (resultCode) {
                case 0:
                    C4908a.m16342a().m16350a(m16167a(obj));
                    callback.onSuccess(result);
                    return;
                case VoiceLoginResult.RESULT_CODE_PWD_VERIFY_FAILURE /*71042*/:
                    callback.onPwdVerifyFailure(result);
                    return;
                default:
                    callback.onFailure(result);
                    return;
            }
        } catch (Exception e) {
            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            callback.onFailure(result);
        }
        result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
        callback.onFailure(result);
    }

    /* renamed from: a */
    void m16202a(VoiceCodeSetCallback callback, VoiceCodeSetDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(VoiceCodeSetCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException("VoiceCodeSetDTO can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (dto.voiceCode > 10 || dto.voiceCode < 0) {
            throw new IllegalArgumentException("abnormal voice code");
        } else {
            final VoiceCodeSetResult result = new VoiceCodeSetResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20587L);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put(BaiduNaviParams.KEY_TIME, String.valueOf(C4891b.m16250a(this.f20399c.context).m16297s()));
                postParams.put("bduss", dto.bduss);
                postParams.put("password", SapiDataEncryptor.m16383c(String.valueOf(dto.voiceCode), SapiDataEncryptor.f20517a));
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final VoiceCodeSetCallback voiceCodeSetCallback = callback;
                final VoiceCodeSetDTO voiceCodeSetDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20587L, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20235d;

                    protected void onStart() {
                        voiceCodeSetCallback.onStart();
                    }

                    protected void onFinish() {
                        voiceCodeSetCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20235d.f20401e.m16132d();
                        try {
                            int resultCode = Integer.parseInt(new JSONObject(responseBody).optString(C2125n.f6745M));
                            result.setResultCode(resultCode);
                            if (resultCode == 0) {
                                voiceCodeSetCallback.onSuccess(result);
                            } else if (1 == resultCode) {
                                voiceCodeSetCallback.onBdussExpired(result);
                            } else {
                                voiceCodeSetCallback.onFailure(result);
                            }
                        } catch (Exception e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceCodeSetCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20235d.f20401e.m16131c()) {
                            this.f20235d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceCodeSetCallback.onFailure(result);
                            return;
                        }
                        this.f20235d.f20401e.m16130b();
                        this.f20235d.m16202a(voiceCodeSetCallback, voiceCodeSetDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16204a(VoiceSwitchSetCallback callback, VoiceSwitchSetDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(VoiceSwitchSetCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException("VoiceSwitchSetDTO can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final VoiceSwitchSetResult result = new VoiceSwitchSetResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20588M);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put(BaiduNaviParams.KEY_TIME, String.valueOf(C4891b.m16250a(this.f20399c.context).m16297s()));
                postParams.put("bduss", dto.bduss);
                postParams.put("status", dto.action == Switch.ON ? "1" : "0");
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final VoiceSwitchSetCallback voiceSwitchSetCallback = callback;
                final VoiceSwitchSetDTO voiceSwitchSetDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20588M, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20239d;

                    protected void onStart() {
                        voiceSwitchSetCallback.onStart();
                    }

                    protected void onFinish() {
                        voiceSwitchSetCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20239d.f20401e.m16132d();
                        try {
                            int resultCode = Integer.parseInt(new JSONObject(responseBody).optString(C2125n.f6745M));
                            result.setResultCode(resultCode);
                            if (resultCode == 0) {
                                voiceSwitchSetCallback.onSuccess(result);
                            } else if (1 == resultCode) {
                                voiceSwitchSetCallback.onBdussExpired(result);
                            } else {
                                voiceSwitchSetCallback.onFailure(result);
                            }
                        } catch (Exception e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceSwitchSetCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20239d.f20401e.m16131c()) {
                            this.f20239d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceSwitchSetCallback.onFailure(result);
                            return;
                        }
                        this.f20239d.f20401e.m16130b();
                        this.f20239d.m16204a(voiceSwitchSetCallback, voiceSwitchSetDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16205a(VoiceVerifyCallback callback, VoiceVerifyDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(VoiceVerifyCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(VoiceVerifyDTO.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(dto.voiceMD5)) {
            throw new IllegalArgumentException("voiceMD5 must be assigned");
        } else {
            final VoiceVerifyResult result = new VoiceVerifyResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20589N);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put("md5", dto.voiceMD5);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final VoiceVerifyCallback voiceVerifyCallback = callback;
                final VoiceVerifyDTO voiceVerifyDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20589N, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20243d;

                    protected void onStart() {
                        voiceVerifyCallback.onStart();
                    }

                    protected void onFinish() {
                        voiceVerifyCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20243d.f20401e.m16132d();
                        int resultCode = this.f20243d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody);
                            if (resultCode == 0) {
                                voiceVerifyCallback.onSuccess(result);
                                return;
                            }
                            result.setResultMsg(jsonObject.optString(C2125n.f6746N));
                            voiceVerifyCallback.onFailure(result);
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceVerifyCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20243d.f20401e.m16131c()) {
                            this.f20243d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            voiceVerifyCallback.onFailure(result);
                            return;
                        }
                        this.f20243d.f20401e.m16130b();
                        this.f20243d.m16205a(voiceVerifyCallback, voiceVerifyDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16174a(FaceCheckCallback callback, FaceCheckDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(FaceCheckCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(FaceCheckDTO.class.getSimpleName() + " can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss) && TextUtils.isEmpty(dto.account)) {
            throw new IllegalArgumentException("either bduss or account must be assigned");
        } else {
            final FaceCheckResult result = new FaceCheckResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20592Q);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                if (TextUtils.isEmpty(dto.bduss)) {
                    postParams.put("username", dto.account);
                    if (dto.accountType == null || dto.accountType == FaceCheckDTO.AccountType.MERGE) {
                        postParams.put("merge", "1");
                    }
                    if (dto.accountType == FaceCheckDTO.AccountType.USERNAME) {
                        postParams.put("isphone", "0");
                    }
                    if (dto.accountType == FaceCheckDTO.AccountType.PHONE) {
                        postParams.put("isphone", "1");
                    }
                } else {
                    postParams.put("bduss", dto.bduss);
                }
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final FaceCheckCallback faceCheckCallback = callback;
                final FaceCheckDTO faceCheckDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20592Q, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20247d;

                    protected void onStart() {
                        faceCheckCallback.onStart();
                    }

                    protected void onFinish() {
                        faceCheckCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        boolean z = true;
                        this.f20247d.f20401e.m16132d();
                        int resultCode = this.f20247d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody);
                            if (resultCode == 0) {
                                boolean z2;
                                result.faceId = jsonObject.optString("faceid");
                                result.uid = SapiDataEncryptor.m16381b(result.faceId, SapiDataEncryptor.f20518b);
                                FaceCheckResult faceCheckResult = result;
                                if (jsonObject.optInt("hasface") == 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                faceCheckResult.hasFace = z2;
                                if (result.hasFace) {
                                    FaceCheckResult faceCheckResult2 = result;
                                    if (jsonObject.optInt("isTrusted") == 0) {
                                        z = false;
                                    }
                                    faceCheckResult2.isTrusted = z;
                                    if (result.isTrusted) {
                                        result.authId = jsonObject.optString("authsid");
                                        faceCheckCallback.onSuccess(result);
                                        return;
                                    }
                                    result.authToken = jsonObject.optString("authtoken");
                                    faceCheckCallback.onNeedVerify(result);
                                    return;
                                }
                                faceCheckCallback.onNoRegistered(result);
                            } else if (3 == resultCode) {
                                faceCheckCallback.onAccountTypeConflict(result);
                            } else if (1 == resultCode) {
                                faceCheckCallback.onBdussExpired(result);
                            } else {
                                result.setResultMsg(jsonObject.optString(C2125n.f6746N));
                                faceCheckCallback.onFailure(result);
                            }
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceCheckCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20247d.f20401e.m16131c()) {
                            this.f20247d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceCheckCallback.onFailure(result);
                            return;
                        }
                        this.f20247d.f20401e.m16130b();
                        this.f20247d.m16174a(faceCheckCallback, faceCheckDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16176a(FaceLoginCallback callback, FaceLoginDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(FaceLoginCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(FaceLoginDTO.class.getSimpleName() + " can't be empty");
        } else if (TextUtils.isEmpty(dto.faceId)) {
            throw new IllegalArgumentException("face id can't be empty");
        } else if (TextUtils.isEmpty(dto.authId)) {
            throw new IllegalArgumentException("auth id can't be empty");
        } else if (TextUtils.isEmpty(dto.facePictureEncoded)) {
            throw new IllegalArgumentException("face picture can't be empty");
        } else {
            final FaceLoginResult result = new FaceLoginResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20591P);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                postParams.put("faceid", dto.faceId);
                postParams.put("authsid", dto.authId);
                postParams.put("facepic", dto.facePictureEncoded);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final FaceLoginCallback faceLoginCallback = callback;
                final FaceLoginDTO faceLoginDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20591P, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20251d;

                    protected void onStart() {
                        faceLoginCallback.onStart();
                    }

                    protected void onFinish() {
                        faceLoginCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20251d.f20401e.m16132d();
                        int resultCode = this.f20251d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject jsonObject = new JSONObject(responseBody);
                            if (resultCode == 0) {
                                SapiAccountManager.getInstance().validate(this.f20251d.m16167a(jsonObject));
                                faceLoginCallback.onSuccess(result);
                            } else if (4 == resultCode) {
                                faceLoginCallback.onPwdVerifyFailure(result);
                            } else {
                                result.setResultMsg(jsonObject.optString(C2125n.f6746N));
                                faceLoginCallback.onFailure(result);
                            }
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceLoginCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20251d.f20401e.m16131c()) {
                            this.f20251d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceLoginCallback.onFailure(result);
                            return;
                        }
                        this.f20251d.f20401e.m16130b();
                        this.f20251d.m16176a(faceLoginCallback, faceLoginDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16178a(FaceRegCallback callback, FaceRegDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (TextUtils.isEmpty(dto.picturesEncoded)) {
            throw new IllegalArgumentException("face pictures can't be empty");
        } else {
            final FaceRegResult result = new FaceRegResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20590O);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                if (!TextUtils.isEmpty(dto.bduss)) {
                    postParams.put("bduss", dto.bduss);
                }
                postParams.put("facepics", dto.picturesEncoded);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final FaceRegCallback faceRegCallback = callback;
                final FaceRegDTO faceRegDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20590O, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20260d;

                    protected void onStart() {
                        faceRegCallback.onStart();
                    }

                    protected void onFinish() {
                        faceRegCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20260d.f20401e.m16132d();
                        int resultCode = this.f20260d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            if (resultCode == 0) {
                                faceRegCallback.onSuccess(result);
                            } else if (1 == resultCode) {
                                faceRegCallback.onBdussExpired(result);
                            } else {
                                result.setResultMsg(obj.optString(C2125n.f6746N));
                                faceRegCallback.onFailure(result);
                            }
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceRegCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20260d.f20401e.m16131c()) {
                            this.f20260d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceRegCallback.onFailure(result);
                            return;
                        }
                        this.f20260d.f20401e.m16130b();
                        this.f20260d.m16178a(faceRegCallback, faceRegDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16177a(FaceModifyCallback callback, FaceModifyDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else if (TextUtils.isEmpty(dto.picturesEncoded)) {
            throw new IllegalArgumentException("face images can't be empty");
        } else {
            final FaceModifyResult result = new FaceModifyResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20593R);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                if (!TextUtils.isEmpty(dto.bduss)) {
                    postParams.put("bduss", dto.bduss);
                }
                postParams.put("facepics", dto.picturesEncoded);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final FaceModifyCallback faceModifyCallback = callback;
                final FaceModifyDTO faceModifyDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20593R, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20264d;

                    protected void onStart() {
                        faceModifyCallback.onStart();
                    }

                    protected void onFinish() {
                        faceModifyCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20264d.f20401e.m16132d();
                        int resultCode = this.f20264d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            if (resultCode == 0) {
                                faceModifyCallback.onSuccess(result);
                            } else if (1 == resultCode) {
                                faceModifyCallback.onBdussExpired(result);
                            } else {
                                result.setResultMsg(obj.optString(C2125n.f6746N));
                                faceModifyCallback.onFailure(result);
                            }
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceModifyCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20264d.f20401e.m16131c()) {
                            this.f20264d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceModifyCallback.onFailure(result);
                            return;
                        }
                        this.f20264d.f20401e.m16130b();
                        this.f20264d.m16177a(faceModifyCallback, faceModifyDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16175a(FaceDelCallback callback, FaceDelDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final FaceDelResult result = new FaceDelResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("tpl", this.f20399c.tpl);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                String deviceInfo = C4920d.m16400b(C4923f.f20594S);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    postParams.put("di", deviceInfo);
                }
                if (!TextUtils.isEmpty(dto.bduss)) {
                    postParams.put("bduss", dto.bduss);
                }
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final FaceDelCallback faceDelCallback = callback;
                final FaceDelDTO faceDelDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20594S, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20268d;

                    protected void onStart() {
                        faceDelCallback.onStart();
                    }

                    protected void onFinish() {
                        faceDelCallback.onFinish();
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20268d.f20401e.m16132d();
                        int resultCode = this.f20268d.m16218b(responseBody);
                        result.setResultCode(resultCode);
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            if (resultCode == 0) {
                                faceDelCallback.onSuccess(result);
                            } else if (1 == resultCode) {
                                faceDelCallback.onBdussExpired(result);
                            } else {
                                result.setResultMsg(obj.optString(C2125n.f6746N));
                                faceDelCallback.onFailure(result);
                            }
                        } catch (JSONException e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceDelCallback.onFailure(result);
                        }
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20268d.f20401e.m16131c()) {
                            this.f20268d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            faceDelCallback.onFailure(result);
                            return;
                        }
                        this.f20268d.f20401e.m16130b();
                        this.f20268d.m16175a(faceDelCallback, faceDelDTO);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16211a(QrPCLoginCallBack callBack, String qrSign, String qrCmd, String bduss, String stoken, String ptoken) {
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            if (TextUtils.isEmpty(qrSign) || TextUtils.isEmpty(qrCmd)) {
                if (callBack != null) {
                    callBack.onFinish();
                    callBack.onQrCodeInvalid();
                }
            } else if (!TextUtils.isEmpty(bduss) || !QrLoginAction.LOGIN.getName().equals(qrCmd)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("sign", qrSign);
                postParams.put("cmd", qrCmd);
                if (!TextUtils.isEmpty(bduss)) {
                    postParams.put("bduss", bduss);
                }
                if (!TextUtils.isEmpty(ptoken)) {
                    postParams.put(SapiAccountManager.SESSION_PTOKEN, ptoken);
                }
                if (!TextUtils.isEmpty(stoken)) {
                    postParams.put(SapiAccountManager.SESSION_STOKEN, stoken);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final QrPCLoginCallBack qrPCLoginCallBack = callBack;
                final String str = qrSign;
                final String str2 = qrCmd;
                final String str3 = bduss;
                final String str4 = stoken;
                final String str5 = ptoken;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20612q, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: g */
                    final /* synthetic */ C4890a f20275g;

                    public void onSuccess(int statusCode, String content) {
                        super.onSuccess(statusCode, content);
                        this.f20275g.f20401e.m16132d();
                        this.f20275g.m16210a(qrPCLoginCallBack, content);
                    }

                    public void onFailure(Throwable error, String content) {
                        super.onFailure(error, content);
                        if (this.f20275g.f20401e.m16131c()) {
                            this.f20275g.f20401e.m16132d();
                            this.f20275g.m16210a(qrPCLoginCallBack, content);
                            return;
                        }
                        this.f20275g.f20401e.m16130b();
                        this.f20275g.m16211a(qrPCLoginCallBack, str, str2, str3, str4, str5);
                    }
                });
            } else if (callBack != null) {
                callBack.onFinish();
                callBack.onBdussInvalid();
            }
        } else if (callBack != null) {
            callBack.onFinish();
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: a */
    void m16188a(QrPcLoginCallback callback, String sign, String cmd, String bduss) {
        if (callback == null) {
            throw new IllegalArgumentException(QrPcLoginCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(sign)) {
            throw new IllegalArgumentException("sign can't be empty");
        } else if (TextUtils.isEmpty(cmd)) {
            throw new IllegalArgumentException("cmd can't be empty");
        } else if (TextUtils.isEmpty(bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final QrPcLoginResult result = new QrPcLoginResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("sign", sign);
                postParams.put("cmd", cmd);
                postParams.put("bduss", bduss);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final QrPcLoginCallback qrPcLoginCallback = callback;
                final String str = sign;
                final String str2 = cmd;
                final String str3 = bduss;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20612q, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: f */
                    final /* synthetic */ C4890a f20284f;

                    protected void onStart() {
                        qrPcLoginCallback.onStart();
                    }

                    protected void onFinish() {
                        qrPcLoginCallback.onFinish();
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20284f.f20401e.m16131c()) {
                            this.f20284f.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            qrPcLoginCallback.onFailure(result);
                            return;
                        }
                        this.f20284f.f20401e.m16130b();
                        this.f20284f.m16188a(qrPcLoginCallback, str, str2, str3);
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20284f.f20401e.m16132d();
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            result.setResultCode(Integer.parseInt(obj.optString(C2125n.f6745M)));
                            switch (result.getResultCode()) {
                                case 0:
                                    JSONObject locale = obj.optJSONObject(PlatformConstants.CONNECT_EXTRA_VALUE_LOCAL);
                                    if (locale != null) {
                                        result.country = locale.optString("country");
                                        result.province = locale.optString("provice");
                                        result.city = locale.optString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY);
                                    }
                                    qrPcLoginCallback.onSuccess(result);
                                    return;
                                case 2:
                                case 160102:
                                    qrPcLoginCallback.onBdussExpired(result);
                                    return;
                                case 3:
                                    qrPcLoginCallback.onIncompleteUser(result);
                                    return;
                                default:
                                    qrPcLoginCallback.onFailure(result);
                                    return;
                            }
                        } catch (Throwable e) {
                            qrPcLoginCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }
                        qrPcLoginCallback.onFailure(result);
                        C4913L.m16374e(e);
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    void m16209a(QrAppLoginCallBack callBack, String qrSign, String qrCmd) {
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            if (!TextUtils.isEmpty(qrSign) && !TextUtils.isEmpty(qrCmd)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("sign", qrSign);
                postParams.put("cmd", qrCmd);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final QrAppLoginCallBack qrAppLoginCallBack = callBack;
                final String str = qrSign;
                final String str2 = qrCmd;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20613r, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20288d;

                    public void onSuccess(int statusCode, String content) {
                        super.onSuccess(statusCode, content);
                        this.f20288d.f20401e.m16132d();
                        this.f20288d.m16171a(statusCode, qrAppLoginCallBack, content);
                    }

                    public void onFailure(Throwable error, String content) {
                        super.onFailure(error, content);
                        if (this.f20288d.f20401e.m16131c()) {
                            this.f20288d.f20401e.m16132d();
                            this.f20288d.m16171a(this.f20288d.m16224c(content), qrAppLoginCallBack, content);
                            return;
                        }
                        this.f20288d.f20401e.m16130b();
                        this.f20288d.m16209a(qrAppLoginCallBack, str, str2);
                    }
                });
            } else if (callBack != null) {
                callBack.onFinish();
                callBack.onQrCodeInvalid();
            }
        } else if (callBack != null) {
            callBack.onFinish();
            callBack.onNetworkFailed();
        }
    }

    /* renamed from: b */
    void m16222b(SapiCallback<QrAppLoginResult> callback, String sign, String cmd) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        } else if (TextUtils.isEmpty(sign)) {
            throw new IllegalArgumentException("sign can't be empty");
        } else if (TextUtils.isEmpty(cmd)) {
            throw new IllegalArgumentException("cmd can't be empty");
        } else {
            final QrAppLoginResult result = new QrAppLoginResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("sign", sign);
                postParams.put("cmd", cmd);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final SapiCallback<QrAppLoginResult> sapiCallback = callback;
                final String str = sign;
                final String str2 = cmd;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20613r, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: e */
                    final /* synthetic */ C4890a f20293e;

                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20293e.f20401e.m16131c()) {
                            this.f20293e.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(result);
                            return;
                        }
                        this.f20293e.f20401e.m16130b();
                        this.f20293e.m16222b(sapiCallback, str, str2);
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20293e.f20401e.m16132d();
                        try {
                            JSONObject obj = new JSONObject(responseBody);
                            int resultCode = Integer.parseInt(obj.optString(C2125n.f6745M));
                            result.setResultCode(resultCode);
                            switch (resultCode) {
                                case 0:
                                    JSONObject locale = obj.optJSONObject(PlatformConstants.CONNECT_EXTRA_VALUE_LOCAL);
                                    if (locale != null) {
                                        result.country = locale.optString("country");
                                        result.province = locale.optString("provice");
                                        result.city = locale.optString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY);
                                    }
                                    C4908a.m16342a().m16350a(this.f20293e.m16167a(obj));
                                    sapiCallback.onSuccess(result);
                                    return;
                                default:
                                    sapiCallback.onFailure(result);
                                    return;
                            }
                        } catch (Throwable e) {
                            sapiCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    public void m16190a(SSOConfirmCallback callback, SSOConfirmDTO dto) {
        if (callback == null) {
            throw new IllegalArgumentException(SSOConfirmCallback.class.getSimpleName() + " can't be null");
        } else if (dto == null) {
            throw new IllegalArgumentException(SSOConfirmDTO.class.getSimpleName() + "can't be null");
        } else if (TextUtils.isEmpty(dto.channelID)) {
            throw new IllegalArgumentException("channel id can't be empty");
        } else if (TextUtils.isEmpty(dto.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        } else {
            final SSOConfirmResult result = new SSOConfirmResult();
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = m16169a(C4923f.f20595T);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("cuid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("channel_id", dto.channelID);
                postParams.put("bduss", dto.bduss);
                postParams.put("refuse", dto.authorized ? "0" : "1");
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                final SSOConfirmCallback sSOConfirmCallback = callback;
                final SSOConfirmDTO sSOConfirmDTO = dto;
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20595T, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: d */
                    final /* synthetic */ C4890a f20297d;

                    protected void onStart() {
                        sSOConfirmCallback.onStart();
                    }

                    protected void onFinish() {
                        sSOConfirmCallback.onFinish();
                    }

                    protected void onFailure(Throwable error, String responseBody) {
                        if (this.f20297d.f20401e.m16131c()) {
                            this.f20297d.f20401e.m16132d();
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sSOConfirmCallback.onFailure(result);
                            return;
                        }
                        this.f20297d.f20401e.m16130b();
                        this.f20297d.m16190a(sSOConfirmCallback, sSOConfirmDTO);
                    }

                    protected void onSuccess(int statusCode, String responseBody) {
                        this.f20297d.f20401e.m16132d();
                        try {
                            int resultCode = this.f20297d.m16218b(responseBody);
                            result.setResultCode(resultCode);
                            if (resultCode == 0) {
                                sSOConfirmCallback.onSuccess(result);
                            } else {
                                sSOConfirmCallback.onFailure(result);
                            }
                        } catch (Throwable e) {
                            result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sSOConfirmCallback.onFailure(result);
                            C4913L.m16374e(e);
                        }
                    }
                });
                return;
            }
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    boolean m16216a(final SapiCallBack<SapiResponse> callBack, final String mobile) {
        if (this.f20399c == null || this.f20399c.context == null) {
            return false;
        }
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            if (!TextUtils.isEmpty(mobile)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("username", mobile);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20616u, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: c */
                    final /* synthetic */ C4890a f20300c;

                    public void onSuccess(int statusCode, String content) {
                        super.onSuccess(statusCode, content);
                        this.f20300c.f20401e.m16132d();
                        this.f20300c.m16231e(callBack, content);
                    }

                    public void onFailure(Throwable error, String content) {
                        super.onFailure(error, content);
                        if (this.f20300c.f20401e.m16131c()) {
                            this.f20300c.f20401e.m16132d();
                            this.f20300c.m16231e(callBack, content);
                            return;
                        }
                        this.f20300c.f20401e.m16130b();
                        this.f20300c.m16216a(callBack, mobile);
                    }
                });
                return true;
            } else if (callBack == null) {
                return false;
            } else {
                callBack.onSystemError(257);
                return false;
            }
        } else if (callBack == null) {
            return false;
        } else {
            callBack.onNetworkFailed();
            return false;
        }
    }

    /* renamed from: b */
    boolean m16223b(final SapiCallBack<SapiAccountResponse> callBack, final String sms) {
        if (this.f20399c == null || this.f20399c.context == null) {
            return false;
        }
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            if (!TextUtils.isEmpty(sms)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = new HashMap();
                postParams.put("sms", sms);
                if (!TextUtils.isEmpty(this.f20399c.clientId)) {
                    postParams.put("clientid", this.f20399c.clientId);
                }
                if (!TextUtils.isEmpty(this.f20399c.clientIp)) {
                    postParams.put("clientip", this.f20399c.clientIp);
                }
                postParams.put("tpl", this.f20399c.tpl);
                postParams.put(SpeechConstant.APP_ID, this.f20399c.appId);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20614s, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: c */
                    final /* synthetic */ C4890a f20309c;

                    public void onSuccess(int statusCode, String content) {
                        super.onSuccess(statusCode, content);
                        this.f20309c.f20401e.m16132d();
                        this.f20309c.m16226c(statusCode, callBack, content);
                    }

                    public void onFailure(Throwable error, String content) {
                        super.onFailure(error, content);
                        if (this.f20309c.f20401e.m16131c()) {
                            this.f20309c.f20401e.m16132d();
                            this.f20309c.m16226c(this.f20309c.m16224c(content), callBack, content);
                            return;
                        }
                        this.f20309c.f20401e.m16130b();
                        this.f20309c.m16223b(callBack, sms);
                    }
                });
                return true;
            } else if (callBack == null) {
                return false;
            } else {
                callBack.onSystemError(-103);
                return false;
            }
        } else if (callBack == null) {
            return false;
        } else {
            callBack.onNetworkFailed();
            return false;
        }
    }

    /* renamed from: a */
    void m16192a(SapiCallback<FastRegResult> callback, int timeoutSeconds) {
        if (callback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        FastRegResult result = new FastRegResult();
        if (timeoutSeconds < 10 || timeoutSeconds > 90) {
            throw new IllegalArgumentException("timeoutSeconds must between 10 and 90");
        } else if (!SapiUtils.isSimReady(this.f20399c.context)) {
            result.setResultCode(-101);
            callback.onFailure(result);
        } else if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            final boolean[] timeout = new boolean[]{false};
            String sms = UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + "," + "点击发送直接登录";
            final Handler mainHandler = new Handler(this, Looper.getMainLooper()) {
                /* renamed from: b */
                final /* synthetic */ C4890a f20311b;

                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 1001:
                            timeout[0] = true;
                            return;
                        default:
                            return;
                    }
                }
            };
            Runnable timeoutTask = new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C4890a f20313b;

                public void run() {
                    Message.obtain(mainHandler, 1001).sendToTarget();
                }
            };
            boolean sendSuccess = false;
            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.f20399c.context)) {
                sendSuccess = SapiUtils.sendSms(this.f20399c.context, sms, SapiUtils.getFastRegChannel(this.f20399c.context));
            }
            if (sendSuccess) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                Map postParams = m16169a(C4923f.f20614s);
                postParams.put("sms", sms);
                postParams.put("sig", m16138a(postParams, this.f20399c.appSignKey));
                RequestParams params = new RequestParams(postParams);
                mainHandler.postDelayed(timeoutTask, (long) (timeoutSeconds * 1000));
                callback.onStart();
                m16150a((SapiCallback) callback, params, mainHandler, timeoutTask, timeout);
                return;
            }
            result.setResultCode(-102);
            callback.onFailure(result);
        } else {
            result.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            callback.onFailure(result);
        }
    }

    /* renamed from: a */
    private void m16150a(SapiCallback<FastRegResult> callback, RequestParams params, Handler mainHandler, Runnable timeoutTask, boolean[] timeout) {
        final FastRegResult result = new FastRegResult();
        if (timeout[0]) {
            this.f20401e.m16132d();
            result.setResultCode(-103);
            callback.onFinish();
            callback.onFailure(result);
            return;
        }
        final Handler handler = mainHandler;
        final Runnable runnable = timeoutTask;
        final SapiCallback<FastRegResult> sapiCallback = callback;
        final RequestParams requestParams = params;
        final boolean[] zArr = timeout;
        this.f20400d.post(this.f20399c.context, this.f20401e.m16129a() + C4923f.f20614s, params, new HttpResponseHandler(this, Looper.getMainLooper()) {
            /* renamed from: g */
            final /* synthetic */ C4890a f20321g;

            /* compiled from: SapiAccountRepository */
            /* renamed from: com.baidu.sapi2.a$43$1 */
            class C48821 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass43 f20314a;

                C48821(AnonymousClass43 anonymousClass43) {
                    this.f20314a = anonymousClass43;
                }

                public void run() {
                    this.f20314a.f20321g.m16150a(sapiCallback, requestParams, handler, runnable, zArr);
                }
            }

            protected void onSuccess(int statusCode, String responseBody) {
                int resultCode = this.f20321g.m16218b(responseBody);
                result.setResultCode(resultCode);
                try {
                    JSONObject responseJSONObj = new JSONObject(responseBody);
                    result.setResultMsg(responseJSONObj.optJSONObject("sdk").optString("msg"));
                    switch (resultCode) {
                        case 0:
                            this.f20321g.f20401e.m16132d();
                            C4908a.m16342a().m16350a(this.f20321g.m16167a(responseJSONObj));
                            result.newReg = responseJSONObj.optBoolean("newreg");
                            result.authSid = responseJSONObj.optString("authsid");
                            if ("null".equals(result.authSid)) {
                                result.authSid = null;
                            }
                            handler.removeCallbacks(runnable);
                            sapiCallback.onFinish();
                            sapiCallback.onSuccess(result);
                            return;
                        case 7:
                            handler.postDelayed(new C48821(this), 400);
                            return;
                        default:
                            this.f20321g.f20401e.m16132d();
                            handler.removeCallbacks(runnable);
                            sapiCallback.onFinish();
                            sapiCallback.onFailure(result);
                            return;
                    }
                } catch (Exception e) {
                    this.f20321g.f20401e.m16132d();
                    handler.removeCallbacks(runnable);
                    sapiCallback.onFinish();
                    sapiCallback.onFailure(result);
                    C4913L.m16374e(e);
                }
                this.f20321g.f20401e.m16132d();
                handler.removeCallbacks(runnable);
                sapiCallback.onFinish();
                sapiCallback.onFailure(result);
                C4913L.m16374e(e);
            }

            protected void onFailure(Throwable error, String responseBody) {
                if (this.f20321g.f20401e.m16131c()) {
                    this.f20321g.f20401e.m16132d();
                    result.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    handler.removeCallbacks(runnable);
                    sapiCallback.onFinish();
                    sapiCallback.onFailure(result);
                    return;
                }
                this.f20321g.f20401e.m16130b();
                this.f20321g.m16150a(sapiCallback, requestParams, handler, runnable, zArr);
            }
        });
    }

    /* renamed from: c */
    void m16225c() {
        if (this.f20399c != null && this.f20399c.context != null && SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            HashMap<String, String> postParams = new HashMap();
            if (C4891b.m16250a(this.f20399c.context).m16262a() != null) {
                postParams.put("device_id", C4922e.m16417d(this.f20399c.context));
                postParams.put("device_token", C4891b.m16250a(this.f20399c.context).m16262a());
            }
            this.f20400d.get(this.f20399c.context, m16163y().getDeviceUrl() + C4923f.f20577B, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: a */
                final /* synthetic */ C4890a f20322a;

                public void onSuccess(int statusCode, String content) {
                    if (content != null) {
                        try {
                            JSONObject obj = new JSONObject(content);
                            if (!obj.has("error_code") && !obj.has(PushConstants.EXTRA_ERROR_CODE) && obj.optInt("fulfilbind") == 0) {
                                if (obj.optInt("reg") == 1 || obj.optInt("login") == 1) {
                                    C4891b.m16250a(this.f20322a.f20399c.context).m16270a(true);
                                }
                            }
                        } catch (JSONException e) {
                            C4913L.m16374e(e);
                            C4891b.m16250a(this.f20322a.f20399c.context).m16270a(false);
                        }
                    }
                }

                public void onFailure(Throwable error, String content) {
                    super.onFailure(error, content);
                    C4891b.m16250a(this.f20322a.f20399c.context).m16270a(false);
                }
            });
        }
    }

    /* renamed from: a */
    boolean m16215a(final SapiCallBack<SapiResponse> callBack) {
        if (this.f20399c == null || this.f20399c.context == null || TextUtils.isEmpty(this.f20399c.deviceLoginSignKey) || !C4891b.m16250a(this.f20399c.context).m16274b()) {
            return false;
        }
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            HashMap<String, String> postParams = new HashMap();
            String deviceID = C4921a.m16403a(C4922e.m16417d(this.f20399c.context));
            postParams.put("ptpl", this.f20399c.tpl);
            postParams.put("device_id", deviceID);
            postParams.put("device_info", C4922e.m16416d());
            postParams.put("package_sign", this.f20399c.deviceLoginSignKey);
            this.f20400d.post(this.f20399c.context, m16163y().getDeviceUrl() + C4923f.f20578C, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: b */
                final /* synthetic */ C4890a f20327b;

                public void onSuccess(int statusCode, String content) {
                    super.onSuccess(statusCode, content);
                    this.f20327b.m16172a(statusCode, callBack, content);
                }

                public void onFailure(Throwable error, String content) {
                    super.onFailure(error, content);
                    this.f20327b.m16172a(this.f20327b.m16224c(content), callBack, content);
                }
            });
            return true;
        } else if (callBack == null) {
            return false;
        } else {
            callBack.onNetworkFailed();
            return false;
        }
    }

    /* renamed from: c */
    void m16227c(final SapiCallBack<SapiResponse> callBack, String forceRegToken) {
        if (this.f20399c != null && this.f20399c.context != null && !TextUtils.isEmpty(this.f20399c.deviceLoginSignKey)) {
            if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
                this.f20400d = new AsyncHttpClient();
                this.f20400d.setUserAgent(m16162x());
                HashMap<String, String> postParams = new HashMap();
                String deviceID = C4921a.m16403a(C4922e.m16417d(this.f20399c.context));
                postParams.put("ptpl", this.f20399c.tpl);
                postParams.put("device_id", deviceID);
                postParams.put("device_info", C4922e.m16416d());
                postParams.put("force_reg_token", forceRegToken);
                this.f20400d.post(this.f20399c.context, m16163y().getDeviceUrl() + C4923f.f20580E, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                    /* renamed from: b */
                    final /* synthetic */ C4890a f20329b;

                    public void onSuccess(int statusCode, String content) {
                        this.f20329b.m16220b(statusCode, callBack, content);
                        super.onSuccess(statusCode, content);
                    }

                    public void onFailure(Throwable error, String content) {
                        this.f20329b.m16220b(this.f20329b.m16224c(content), callBack, content);
                        super.onFailure(error, content);
                    }
                });
            } else if (callBack != null) {
                callBack.onNetworkFailed();
            }
        }
    }

    /* renamed from: d */
    boolean m16229d(final SapiCallBack<SapiResponse> callBack, String deviceToken) {
        if (this.f20399c == null || this.f20399c.context == null || TextUtils.isEmpty(this.f20399c.deviceLoginSignKey)) {
            return false;
        }
        if (SapiUtils.hasActiveNetwork(this.f20399c.context)) {
            this.f20400d = new AsyncHttpClient();
            this.f20400d.setUserAgent(m16162x());
            HashMap<String, String> postParams = new HashMap();
            String deviceID = C4921a.m16403a(C4922e.m16417d(this.f20399c.context));
            postParams.put("ptpl", this.f20399c.tpl);
            postParams.put("device_id", deviceID);
            postParams.put("device_token", deviceToken);
            postParams.put("package_sign", this.f20399c.deviceLoginSignKey);
            this.f20400d.post(this.f20399c.context, m16163y().getDeviceUrl() + C4923f.f20579D, new RequestParams(postParams), new HttpResponseHandler(this, Looper.getMainLooper()) {
                /* renamed from: b */
                final /* synthetic */ C4890a f20331b;

                public void onSuccess(int statusCode, String content) {
                    this.f20331b.m16172a(statusCode, callBack, content);
                    super.onSuccess(statusCode, content);
                }

                public void onFailure(Throwable error, String content) {
                    this.f20331b.m16172a(this.f20331b.m16224c(content), callBack, content);
                    super.onFailure(error, content);
                }
            });
            return true;
        } else if (callBack == null) {
            return false;
        } else {
            callBack.onNetworkFailed();
            return false;
        }
    }

    /* renamed from: a */
    void m16172a(int code, SapiCallBack<SapiResponse> callBack, String json) {
        if (json != null) {
            SapiAccountResponse response = new SapiAccountResponse();
            try {
                JSONObject obj = new JSONObject(json);
                response.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                response.uid = obj.optString("uid");
                response.bduss = obj.optString("bduss");
                response.ptoken = obj.optString(SapiAccountManager.SESSION_PTOKEN);
                if (obj.optInt("error_code") == 104) {
                    m16227c(callBack, obj.optString("force_reg_token"));
                    return;
                }
                if (!(obj.has("error_code") || obj.has(PushConstants.EXTRA_ERROR_CODE))) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = response.uid;
                    sapiAccount.bduss = response.bduss;
                    sapiAccount.displayname = response.displayname;
                    sapiAccount.stoken = response.stoken;
                    sapiAccount.ptoken = response.ptoken;
                    sapiAccount.app = SapiUtils.getAppName(this.f20399c.context);
                    if (obj.has("device_token")) {
                        C4891b.m16250a(this.f20399c.context).m16267a(obj.getString("device_token"));
                    }
                    C4908a.m16342a().m16350a(sapiAccount);
                }
                if (callBack != null) {
                    switch (obj.optInt("error_code")) {
                        case 0:
                            callBack.onSuccess(null);
                            return;
                        default:
                            callBack.onSystemError(obj.optInt("error_code"));
                            return;
                    }
                    if (callBack != null) {
                        callBack.onSystemError(-100);
                    }
                }
            } catch (Exception e) {
                if (callBack != null) {
                    callBack.onSystemError(-100);
                }
            }
        } else if (callBack != null) {
            callBack.onSystemError(code);
        }
    }

    /* renamed from: b */
    void m16220b(int code, SapiCallBack<SapiResponse> callBack, String json) {
        if (json != null) {
            SapiAccountResponse response = new SapiAccountResponse();
            try {
                JSONObject obj = new JSONObject(json);
                response.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                response.uid = obj.optString("uid");
                response.bduss = obj.optString("bduss");
                response.ptoken = obj.optString(SapiAccountManager.SESSION_PTOKEN);
                if (!(obj.has("error_code") || obj.has(PushConstants.EXTRA_ERROR_CODE))) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = response.uid;
                    sapiAccount.bduss = response.bduss;
                    sapiAccount.displayname = response.displayname;
                    sapiAccount.stoken = response.stoken;
                    sapiAccount.ptoken = response.ptoken;
                    sapiAccount.app = SapiUtils.getAppName(this.f20399c.context);
                    if (obj.has("device_token")) {
                        C4891b.m16250a(this.f20399c.context).m16267a(obj.getString("device_token"));
                    }
                    C4908a.m16342a().m16350a(sapiAccount);
                }
                if (callBack != null) {
                    switch (obj.optInt("error_code")) {
                        case 0:
                            callBack.onSuccess(null);
                            return;
                        default:
                            callBack.onSystemError(obj.optInt("error_code"));
                            return;
                    }
                }
            } catch (Exception e) {
                if (callBack != null) {
                    callBack.onSystemError(-100);
                }
            }
        } else if (callBack != null) {
            callBack.onSystemError(code);
        }
    }

    /* renamed from: a */
    Map<String, String> m16169a(String situation) {
        Map<String, String> params = new HashMap();
        params.put("tpl", this.f20399c.tpl);
        params.put(SpeechConstant.APP_ID, this.f20399c.appId);
        if (TextUtils.isEmpty(this.f20399c.clientId)) {
            this.f20399c.clientId = SapiUtils.getClientId(this.f20399c.context);
        }
        if (!TextUtils.isEmpty(this.f20399c.clientId)) {
            params.put("clientid", this.f20399c.clientId);
        }
        String deviceInfo = C4920d.m16400b(situation);
        if (!TextUtils.isEmpty(deviceInfo)) {
            params.put("di", deviceInfo);
        }
        params.put("clientfrom", "mobilesdk_enhanced");
        params.put("sdk_version", "3");
        return params;
    }

    /* renamed from: a */
    private String m16138a(Map<String, String> urlParams, String sign_key) {
        ArrayList<String> al = new ArrayList();
        for (Object add : urlParams.keySet()) {
            al.add(add);
        }
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        Iterator i$ = al.iterator();
        while (i$.hasNext()) {
            String string = (String) i$.next();
            sb.append(string);
            sb.append("=");
            try {
                String key = (String) urlParams.get(string);
                if (!TextUtils.isEmpty(key)) {
                    sb.append(URLEncoder.encode(key, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                C4913L.m16374e(e);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(sign_key);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    /* renamed from: x */
    private String m16162x() {
        return "tpl:" + this.f20399c.tpl + ";android_sapi_v" + SapiAccountManager.VERSION_NAME;
    }

    /* renamed from: b */
    int m16218b(String json) {
        try {
            return new JSONObject(json).getInt(C2125n.f6745M);
        } catch (Exception e) {
            C4913L.m16374e(e);
            return -100;
        }
    }

    /* renamed from: c */
    int m16224c(String json) {
        int errCode = m16218b(json);
        if (errCode == 110000) {
            return 0;
        }
        return errCode;
    }

    /* renamed from: a */
    private void m16139a(int code, FillUsernameCallBack callBack, String json, SapiDataEncryptor helper) {
        if (json != null) {
            SapiAccountResponse response = new SapiAccountResponse();
            try {
                String strUserInfo = new JSONObject(json).optString("userinfo");
                if (!TextUtils.isEmpty(strUserInfo)) {
                    JSONObject jsonInfo = new JSONObject(helper.m16385a(strUserInfo));
                    response.bduss = jsonInfo.optString("bduss");
                    response.ptoken = jsonInfo.optString(SapiAccountManager.SESSION_PTOKEN);
                    response.stoken = jsonInfo.optString(SapiAccountManager.SESSION_STOKEN);
                    response.displayname = jsonInfo.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    response.uid = jsonInfo.optString("uid");
                    response.username = jsonInfo.optString("uname");
                    response.email = jsonInfo.optString("email");
                    switch (code) {
                        case 0:
                            SapiAccount account = m16166a(response);
                            account.extra = jsonInfo.toString();
                            C4908a.m16342a().m16350a(account);
                            callBack.onSuccess(response);
                            return;
                        case 160103:
                            callBack.onInvalidBduss();
                            return;
                        case 160104:
                            callBack.onUserHaveUsername();
                            return;
                        case 160105:
                        case 160111:
                            callBack.onUsernameAlreadyExist();
                            return;
                        case 160110:
                            callBack.onUsernameFormatError();
                            return;
                        default:
                            callBack.onSystemError(code);
                            return;
                    }
                    callBack.onSystemError(code);
                    return;
                }
                return;
            } catch (Throwable th) {
                callBack.onSystemError(code);
                return;
            }
        }
        callBack.onSystemError(code);
    }

    /* renamed from: a */
    void m16210a(QrPCLoginCallBack callBack, String json) {
        callBack.onFinish();
        try {
            JSONObject obj = new JSONObject(json);
            int code = Integer.parseInt(obj.optString(C2125n.f6745M));
            switch (code) {
                case -103:
                case 1:
                    callBack.onQrCodeInvalid();
                    return;
                case 0:
                    QrPCLoginResponse response = new QrPCLoginResponse();
                    response.errorCode = code;
                    JSONObject locale = obj.optJSONObject(PlatformConstants.CONNECT_EXTRA_VALUE_LOCAL);
                    if (locale != null) {
                        response.country = locale.optString("country");
                        response.province = locale.optString("provice");
                        response.city = locale.optString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY);
                    }
                    callBack.onSuccess(response);
                    return;
                case 2:
                case 160102:
                    callBack.onBdussInvalid();
                    return;
                case 3:
                    callBack.onUserNotNormalized();
                    return;
                default:
                    callBack.onSystemError(code);
                    return;
            }
        } catch (Exception e) {
            callBack.onSystemError(-100);
        }
        callBack.onSystemError(-100);
    }

    /* renamed from: a */
    void m16171a(int code, QrAppLoginCallBack callBack, String json) {
        if (callBack != null) {
            callBack.onFinish();
        }
        if (json != null) {
            QrAppLoginResponse response = new QrAppLoginResponse();
            try {
                JSONObject obj = new JSONObject(json);
                code = Integer.parseInt(obj.optString(C2125n.f6745M));
                response.errorCode = code;
                JSONObject locale = obj.optJSONObject(PlatformConstants.CONNECT_EXTRA_VALUE_LOCAL);
                if (locale != null) {
                    response.country = locale.optString("country");
                    response.province = locale.optString("provice");
                    response.city = locale.optString(NaviStatConstants.K_NSC_KEY_FINISHNAVI_CITY);
                }
                if (!TextUtils.isEmpty(obj.optString(C2125n.f6745M)) && obj.optString(C2125n.f6745M).equals("0")) {
                    C4908a.m16342a().m16350a(m16167a(obj));
                }
                if (callBack != null) {
                    switch (code) {
                        case -103:
                        case 1:
                            callBack.onQrCodeInvalid();
                            return;
                        case 0:
                            callBack.onSuccess(response);
                            return;
                        case 2:
                        case 160102:
                            callBack.onBdussInvalid();
                            return;
                        case 3:
                            callBack.onUserNotNormalized();
                            return;
                        default:
                            callBack.onSystemError(code);
                            return;
                    }
                    if (callBack != null) {
                        callBack.onSystemError(-100);
                    }
                }
            } catch (Exception e) {
                if (callBack != null) {
                    callBack.onSystemError(-100);
                }
            }
        } else if (callBack != null) {
            callBack.onSystemError(code);
        }
    }

    /* renamed from: c */
    void m16226c(int code, SapiCallBack<SapiAccountResponse> callBack, String json) {
        if (json != null) {
            SapiAccountResponse response = new SapiAccountResponse();
            try {
                JSONObject obj = new JSONObject(json);
                response.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                response.username = obj.optString("uname");
                response.uid = obj.optString("uid");
                response.bduss = obj.optString("bduss");
                response.ptoken = obj.optString(SapiAccountManager.SESSION_PTOKEN);
                response.stoken = obj.optString(SapiAccountManager.SESSION_STOKEN);
                response.newReg = obj.optBoolean("newreg");
                if (response.newReg) {
                    response.authSid = obj.optString("authsid");
                }
                if (callBack != null) {
                    switch (obj.optInt(C2125n.f6745M)) {
                        case 0:
                            callBack.onSuccess(response);
                            return;
                        case 2:
                        case 16:
                        case SapiErrorCode.SMS_LOGIN_TOO_MUCH /*190016*/:
                            callBack.onSystemError(obj.optInt(C2125n.f6745M));
                            return;
                        default:
                            callBack.onSystemError(code);
                            return;
                    }
                    if (callBack != null) {
                        callBack.onSystemError(-100);
                    }
                }
            } catch (Exception e) {
                if (callBack != null) {
                    callBack.onSystemError(-100);
                }
            }
        } else if (callBack != null) {
            callBack.onSystemError(code);
        }
    }

    /* renamed from: a */
    void m16186a(IqiyiLoginCallback callback, IqiyiLoginDTO iqiyiLoginDTO) {
        if (callback != null) {
            callback.onStart();
            String accessToken = iqiyiLoginDTO.accessToken;
            final String phoneNum = iqiyiLoginDTO.phoneNum;
            String openID = iqiyiLoginDTO.openID;
            final IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            boolean isIqiyiLogin = (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openID)) ? false : true;
            if (!isIqiyiLogin && session == null) {
                callback.onLogin(iqiyiLoginResult);
            } else if (isIqiyiLogin && session == null) {
                m16149a(callback, iqiyiLoginDTO, iqiyiLoginResult);
            } else {
                final IqiyiLoginCallback iqiyiLoginCallback = callback;
                final IqiyiLoginDTO iqiyiLoginDTO2 = iqiyiLoginDTO;
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback(this) {
                    /* renamed from: e */
                    final /* synthetic */ C4890a f20336e;

                    public /* synthetic */ void onBdussExpired(SapiResult x0) {
                        m16122a((GetUserInfoResult) x0);
                    }

                    public /* synthetic */ void onFailure(SapiResult x0) {
                        m16124c((GetUserInfoResult) x0);
                    }

                    public /* synthetic */ void onSuccess(SapiResult x0) {
                        m16123b((GetUserInfoResult) x0);
                    }

                    /* renamed from: a */
                    public void m16122a(GetUserInfoResult result) {
                        this.f20336e.m16149a(iqiyiLoginCallback, iqiyiLoginDTO2, iqiyiLoginResult);
                    }

                    /* renamed from: b */
                    public void m16123b(GetUserInfoResult result) {
                        String sapiPhoneNum = result.secureMobile;
                        boolean isIncompleteUser = result.incompleteUser;
                        if (!TextUtils.isEmpty(sapiPhoneNum)) {
                            iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                        } else if (isIncompleteUser) {
                            this.f20336e.m16149a(iqiyiLoginCallback, iqiyiLoginDTO2, iqiyiLoginResult);
                        } else if (TextUtils.isEmpty(phoneNum)) {
                            iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                        } else {
                            this.f20336e.m16149a(iqiyiLoginCallback, iqiyiLoginDTO2, iqiyiLoginResult);
                        }
                    }

                    /* renamed from: c */
                    public void m16124c(GetUserInfoResult result) {
                        iqiyiLoginResult.setResultCode(result.getResultCode());
                        iqiyiLoginResult.setResultMsg(result.getResultMsg());
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    }

                    public void onStart() {
                    }

                    public void onFinish() {
                    }
                }, session.bduss);
            }
        }
    }

    /* renamed from: a */
    private void m16149a(IqiyiLoginCallback callback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult result) {
        if (TextUtils.isEmpty(iqiyiLoginDTO.accessToken) || TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            callback.onLogin(result);
            return;
        }
        this.f20400d = new AsyncHttpClient();
        this.f20400d.setUserAgent(m16162x());
        Map paramMap = m16169a(m16245s());
        paramMap.put("crypt_m", iqiyiLoginDTO.phoneNum);
        paramMap.put("access_token", iqiyiLoginDTO.accessToken);
        paramMap.put("osuid", iqiyiLoginDTO.openID);
        paramMap.put("json", "1");
        paramMap.put("type", SocialType.IQIYI.getType() + "");
        paramMap.put(NaviStatConstants.STAT_ACT_PARAM, "special");
        paramMap.put("display", "native");
        paramMap.put("client", "android");
        paramMap.put("sig", m16138a(paramMap, this.f20399c.appSignKey));
        final IqiyiLoginCallback iqiyiLoginCallback = callback;
        final IqiyiLoginResult iqiyiLoginResult = result;
        final IqiyiLoginDTO iqiyiLoginDTO2 = iqiyiLoginDTO;
        this.f20400d.get(this.f20399c.context, m16245s(), new RequestParams(paramMap), new HttpResponseHandler(this, Looper.getMainLooper()) {
            /* renamed from: d */
            final /* synthetic */ C4890a f20346d;

            protected void onStart() {
            }

            protected void onFinish() {
                iqiyiLoginCallback.onFinish();
            }

            protected void onSuccess(int statusCode, String response) {
                super.onSuccess(statusCode, response);
                this.f20346d.f20401e.m16132d();
                if (this.f20346d.m16218b(response) == 302) {
                    try {
                        JSONObject object = new JSONObject(response);
                        iqiyiLoginResult.nextUrl = object.optString("next_url");
                        iqiyiLoginCallback.onBindWebview(iqiyiLoginResult);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                SapiAccountResponse socialResponse = SapiWebView.b(response);
                if (socialResponse == null) {
                    iqiyiLoginResult.setResultCode(-100);
                    iqiyiLoginResult.setResultMsg("登录失败");
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                } else if (socialResponse.errorCode != -100) {
                    iqiyiLoginResult.setResultCode(-100);
                    iqiyiLoginResult.setResultMsg("登录失败");
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                } else {
                    SapiAccount sapiAccount = this.f20346d.m16166a(socialResponse);
                    C4919c.m16395a(sapiAccount, socialResponse.socialType, socialResponse.socialPortraitUrl);
                    C4908a.m16342a().m16350a(sapiAccount);
                    iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                }
            }

            protected void onFailure(Throwable error, String responseBody) {
                super.onFailure(error, responseBody);
                if (this.f20346d.f20401e.m16131c()) {
                    this.f20346d.f20401e.m16132d();
                    iqiyiLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    return;
                }
                this.f20346d.f20401e.m16130b();
                iqiyiLoginCallback.onStart();
                this.f20346d.m16149a(iqiyiLoginCallback, iqiyiLoginDTO2, iqiyiLoginResult);
            }
        });
    }

    /* renamed from: a */
    SapiAccount m16167a(JSONObject obj) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = obj.optString("uid");
        sapiAccount.bduss = obj.optString("bduss");
        sapiAccount.displayname = obj.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = obj.optString("uname");
        sapiAccount.stoken = obj.optString(SapiAccountManager.SESSION_STOKEN);
        sapiAccount.ptoken = obj.optString(SapiAccountManager.SESSION_PTOKEN);
        sapiAccount.extra = obj.toString();
        sapiAccount.app = SapiUtils.getAppName(this.f20399c.context);
        return sapiAccount;
    }

    /* renamed from: a */
    SapiAccount m16166a(SapiAccountResponse response) {
        SapiAccount account = new SapiAccount();
        account.displayname = response.displayname;
        account.bduss = response.bduss;
        account.ptoken = response.ptoken;
        account.stoken = response.stoken;
        account.uid = response.uid;
        account.username = response.username;
        account.app = SapiUtils.getAppName(this.f20399c.context);
        return account;
    }

    /* renamed from: e */
    void m16231e(SapiCallBack<SapiResponse> callBack, String json) {
        try {
            int code = Integer.parseInt(new JSONObject(json).optString(C2125n.f6745M));
            switch (code) {
                case 0:
                    SapiResponse response = new SapiResponse();
                    response.errorCode = code;
                    response.errorMsg = "短信验证码发送成功";
                    callBack.onSuccess(response);
                    return;
                default:
                    callBack.onSystemError(code);
                    return;
            }
        } catch (Exception e) {
            callBack.onSystemError(-100);
        }
    }

    /* renamed from: y */
    private Domain m16163y() {
        return this.f20399c.environment;
    }

    /* renamed from: z */
    private String m16164z() {
        return this.f20401e.m16129a() + "/sslcrypt/get_last_cert";
    }

    /* renamed from: d */
    String m16228d() {
        return m16163y().getWap() + "/passport/login";
    }

    /* renamed from: e */
    String m16230e() {
        return m16163y().getWap() + "/passport/getpass";
    }

    /* renamed from: f */
    String m16232f() {
        return m16163y().getWap() + "/wp/wappassword";
    }

    /* renamed from: g */
    String m16233g() {
        return m16163y().getWap() + "/wp/recordindex";
    }

    /* renamed from: h */
    String m16234h() {
        return m16163y().getWap() + "/v2/?bindingaccount&";
    }

    /* renamed from: i */
    String m16235i() {
        return m16163y().getWap() + "/v2/?bindingret";
    }

    /* renamed from: a */
    String m16168a(BindWidgetAction action) {
        return m16163y().getWap() + action.getUri();
    }

    /* renamed from: j */
    String m16236j() {
        return m16163y().getWap() + "/passport/authwidget";
    }

    /* renamed from: k */
    String m16237k() {
        return m16163y().getWap() + "/wp/unitewidget";
    }

    /* renamed from: l */
    String m16238l() {
        return this.f20401e.m16129a() + "/v2/sapi/center/filluname";
    }

    /* renamed from: m */
    String m16239m() {
        return this.f20401e.m16129a() + "/v2/sapi/center/setportrait";
    }

    /* renamed from: n */
    String m16240n() {
        return m16163y().getPortraitUrl() + "/sys/history";
    }

    /* renamed from: o */
    String m16241o() {
        return this.f20401e.m16129a() + "/v2/sapi/center/getuinfo";
    }

    /* renamed from: p */
    String m16242p() {
        return m16163y().getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    /* renamed from: q */
    String m16243q() {
        return m16163y().getPortraitUrl() + "/sys/sethotitem";
    }

    /* renamed from: r */
    String m16244r() {
        return this.f20401e.m16129a() + C4923f.f20596a;
    }

    /* renamed from: s */
    String m16245s() {
        return this.f20401e.m16129a() + "/phoenix/account/ssologin";
    }

    /* renamed from: t */
    String m16246t() {
        return this.f20401e.m16129a() + "/phoenix/account/ssologin";
    }

    /* renamed from: u */
    String m16247u() {
        return this.f20401e.m16129a() + C4923f.f20609n;
    }

    /* renamed from: v */
    String m16248v() {
        return this.f20401e.m16129a() + C4923f.f20610o;
    }

    /* renamed from: w */
    String m16249w() {
        return this.f20401e.m16129a() + C4923f.f20611p;
    }
}
