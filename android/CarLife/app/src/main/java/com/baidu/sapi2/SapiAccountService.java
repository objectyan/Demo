package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
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
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QuickUserRegDTO;
import com.baidu.sapi2.dto.ReloginDTO;
import com.baidu.sapi2.dto.SSOConfirmDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO;
import com.baidu.sapi2.dto.VoiceCodeSetDTO;
import com.baidu.sapi2.dto.VoiceSwitchSetDTO;
import com.baidu.sapi2.dto.VoiceVerifyDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.ReloginResult;
import com.baidu.sapi2.result.VoiceRegResult;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.speech.asr.SpeechConstant;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public final class SapiAccountService {
    /* renamed from: a */
    private static final String f12760a = "native";
    /* renamed from: b */
    private SapiConfiguration f12761b = SapiAccountManager.getInstance().getSapiConfiguration();
    /* renamed from: c */
    private C4890a f12762c;

    SapiAccountService(Context context) {
        this.f12762c = new C4890a(context);
    }

    /* renamed from: a */
    String m11026a() {
        return this.f12762c.d() + "?" + m11042i();
    }

    /* renamed from: b */
    String m11034b() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("adapter", "3"));
        list.add(new BasicNameValuePair("banner", "1"));
        list.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.f12762c.e() + "?" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: c */
    String m11036c() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("adapter", "3"));
        list.add(new BasicNameValuePair("banner", "1"));
        list.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.f12762c.f() + "?" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: d */
    String m11037d() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("adapter", "3"));
        list.add(new BasicNameValuePair("banner", "1"));
        return this.f12762c.g() + "?" + m11042i() + "&" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: a */
    String m11027a(BindWidgetAction action) {
        if (action == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("adapter", "3"));
        return this.f12762c.a(action) + "?" + m11042i() + "&" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: e */
    String m11038e() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("adapter", "3"));
        return this.f12762c.j() + "?" + m11042i() + "&" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: f */
    String m11039f() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("adapter", "3"));
        return this.f12762c.k() + "?" + m11042i() + "&" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: g */
    String m11040g() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        list.add(new BasicNameValuePair("showtype", "phone"));
        list.add(new BasicNameValuePair(UpdateDeviceStatusDataStruct.KEY_DEVICE, "wap"));
        list.add(new BasicNameValuePair("adapter", "apps"));
        return this.f12762c.h() + m11042i() + "&" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: h */
    String m11041h() {
        return this.f12762c.i();
    }

    /* renamed from: i */
    String m11042i() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("clientfrom", f12760a));
        list.add(new BasicNameValuePair("tpl", this.f12761b.tpl));
        list.add(new BasicNameValuePair("login_share_strategy", this.f12761b.loginShareStrategy().getStrValue()));
        list.add(new BasicNameValuePair("client", "android"));
        list.add(new BasicNameValuePair("adapter", this.f12761b.customActionBarEnabled ? "3" : ""));
        list.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        list.add(new BasicNameValuePair(NaviStatConstants.STAT_ACT_PARAM, this.f12761b.socialBindType.getName()));
        list.add(new BasicNameValuePair("loginLink", String.valueOf(this.f12761b.smsLoginConfig.flagShowLoginLink.ordinal())));
        list.add(new BasicNameValuePair("smsLoginLink", String.valueOf(this.f12761b.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        list.add(new BasicNameValuePair("lPFastRegLink", String.valueOf(this.f12761b.smsLoginConfig.flagShowFastRegLink.ordinal())));
        if (this.f12761b.registMode == RegistMode.FAST) {
            list.add(new BasicNameValuePair("fastRegLink", "1"));
        }
        if (this.f12761b.quickUserEnabled) {
            list.add(new BasicNameValuePair("quick_user", "1"));
            if (this.f12761b.registMode == RegistMode.QUICK_USER) {
                list.add(new BasicNameValuePair("regtype", "2"));
            }
        }
        list.add(new BasicNameValuePair("lPlayout", String.valueOf(this.f12761b.configurableViewLayout.ordinal())));
        if (!this.f12761b.showRegLink) {
            list.add(new BasicNameValuePair("regLink", "0"));
        }
        if (!TextUtils.isEmpty(this.f12761b.fastRegTitleText)) {
            try {
                list.add(new BasicNameValuePair("fastRegText", URLEncoder.encode(this.f12761b.fastRegTitleText, "UTF-8")));
            } catch (Throwable e) {
                C4913L.e(e);
            }
        }
        if (this.f12761b.uniteVerify) {
            list.add(new BasicNameValuePair("connect", "1"));
        }
        return SapiUtils.createRequestParams(list);
    }

    /* renamed from: a */
    String m11029a(SocialType type, String accessToken, String osuid) {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("tpl", this.f12761b.tpl));
        list.add(new BasicNameValuePair("display", f12760a));
        list.add(new BasicNameValuePair("type", type.getType() + ""));
        list.add(new BasicNameValuePair(NaviStatConstants.STAT_ACT_PARAM, this.f12761b.socialBindType.getName()));
        list.add(new BasicNameValuePair("access_token", accessToken));
        list.add(new BasicNameValuePair("osuid", osuid));
        return this.f12762c.s() + "?" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: a */
    String m11030a(String accessToken, String osuid) {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("type", SocialType.QQ.getType() + ""));
        list.add(new BasicNameValuePair("tpl", this.f12761b.tpl));
        list.add(new BasicNameValuePair(NaviStatConstants.STAT_ACT_PARAM, this.f12761b.socialBindType.getName()));
        list.add(new BasicNameValuePair(SpeechConstant.APP_ID, this.f12761b.qqAppID));
        list.add(new BasicNameValuePair("access_token", accessToken));
        list.add(new BasicNameValuePair("osuid", osuid));
        return this.f12762c.s() + "?" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: j */
    String m11043j() {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("type", SocialType.WEIXIN.getType() + ""));
        list.add(new BasicNameValuePair("tpl", this.f12761b.tpl));
        list.add(new BasicNameValuePair("display", f12760a));
        list.add(new BasicNameValuePair(NaviStatConstants.STAT_ACT_PARAM, this.f12761b.socialBindType.getName()));
        list.add(new BasicNameValuePair("app_key", this.f12761b.wxAppID));
        list.add(new BasicNameValuePair("scope", "snsapi_login"));
        return this.f12762c.u() + "?" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: b */
    String m11035b(String code, String mkey) {
        List<NameValuePair> params = new ArrayList(4);
        params.add(new BasicNameValuePair("mkey", mkey));
        params.add(new BasicNameValuePair("code", code));
        params.add(new BasicNameValuePair(SpeechConstant.APP_ID, this.f12761b.wxAppID));
        params.add(new BasicNameValuePair("display", f12760a));
        return this.f12762c.v() + "?" + SapiUtils.createRequestParams(params);
    }

    /* renamed from: k */
    String m11044k() {
        return this.f12762c.t();
    }

    /* renamed from: a */
    String m11028a(SocialType type) {
        List<NameValuePair> list = new ArrayList();
        list.add(new BasicNameValuePair("tpl", this.f12761b.tpl));
        list.add(new BasicNameValuePair("display", f12760a));
        list.add(new BasicNameValuePair("type", type.getType() + ""));
        list.add(new BasicNameValuePair(NaviStatConstants.STAT_ACT_PARAM, this.f12761b.socialBindType.getName()));
        list.add(new BasicNameValuePair("guidebind", "1"));
        return this.f12762c.u() + "?" + SapiUtils.createRequestParams(list);
    }

    /* renamed from: l */
    String m11045l() {
        return this.f12762c.v();
    }

    /* renamed from: m */
    String m11046m() {
        return this.f12762c.w();
    }

    /* renamed from: a */
    boolean m11033a(SapiCallBack<SapiAccountResponse> callBack, String phoneNum, String password) {
        return this.f12762c.a(callBack, phoneNum, password, false);
    }

    public void cancelRequest() {
        this.f12762c.a();
    }

    @Deprecated
    public void fillUsername(FillUsernameCallBack callBack, String bduss, String ptoken, String username) {
        this.f12762c.a(callBack, bduss, ptoken, username);
    }

    public void fillUsername(FillUsernameCallback callback, String bduss, String username) {
        this.f12762c.a(callback, bduss, username);
    }

    public void fillUserProfile(FillUserProfileCallback callback, String bduss) {
        this.f12762c.a(callback, bduss);
    }

    public void voiceCheck(VoiceCheckCallback callback, VoiceCheckDTO voiceCheckDTO) {
        this.f12762c.a(callback, voiceCheckDTO);
    }

    public void voiceCheck(VoiceCheckCallback callback, String bduss) {
        this.f12762c.a(callback, bduss, null);
    }

    public void voiceCheckByUid(VoiceCheckCallback callback, String uid) {
        this.f12762c.a(callback, null, uid);
    }

    public void voiceReg(SapiCallback<VoiceRegResult> callback, String voiceMd5, String bduss, String authSid, boolean newUser) {
        this.f12762c.a(callback, voiceMd5, bduss, authSid, newUser);
    }

    public void voiceLogin(VoiceLoginCallback callback, String voiceMd5, String uid) {
        this.f12762c.a(callback, voiceMd5, uid);
    }

    public void voiceCodeSet(VoiceCodeSetCallback callback, VoiceCodeSetDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void voiceSwitchSet(VoiceSwitchSetCallback callback, VoiceSwitchSetDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void voiceVerify(VoiceVerifyCallback callback, VoiceVerifyDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void faceCheck(FaceCheckCallback callback, FaceCheckDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void faceReg(FaceRegCallback callback, FaceRegDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void faceLogin(FaceLoginCallback callback, FaceLoginDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void faceModify(FaceModifyCallback callback, FaceModifyDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void faceDel(FaceDelCallback callback, FaceDelDTO dto) {
        this.f12762c.a(callback, dto);
    }

    @Deprecated
    public void setPortrait(SapiCallBack<SapiResponse> callBack, String bduss, String ptoken, String stoken, byte[] file, String contentType) {
        this.f12762c.a(callBack, bduss, ptoken, stoken, file, contentType);
    }

    public void setPortrait(SetPortraitCallback callback, String bduss, byte[] file, String contentType) {
        this.f12762c.a(callback, bduss, file, contentType);
    }

    public void setPopularPortrait(SetPopularPortraitCallback callback, SetPopularPortraitDTO dto) {
        this.f12762c.a(callback, dto);
    }

    @Deprecated
    public void getPortrait(SapiCallBack<GetPortraitResponse> callBack, String bduss, String ptoken, String stoken) {
        this.f12762c.a(callBack, bduss, ptoken, stoken);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback callback, GetHistoryPortraitsDTO dto) {
        this.f12762c.a(callback, dto);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback callback, String bduss) {
        this.f12762c.a(callback, bduss);
    }

    public void getUserInfo(GetUserInfoCallback callback, String bduss) {
        this.f12762c.a(callback, bduss);
    }

    @Deprecated
    public void getUserInfo(GetUserInfoCallBack callBack, String bduss) {
        this.f12762c.a(callBack, bduss);
    }

    @Deprecated
    public void qrPCLogin(QrPCLoginCallBack callBack, String qrSign, String qrCmd, String bduss, String stoken, String ptoken) {
        this.f12762c.a(callBack, qrSign, qrCmd, bduss, stoken, ptoken);
    }

    public void qrPcLogin(QrPcLoginCallback callback, String sign, String cmd, String bduss) {
        this.f12762c.a(callback, sign, cmd, bduss);
    }

    @Deprecated
    public void qrAppLogin(QrAppLoginCallBack callBack, String qrSign, String qrCmd) {
        this.f12762c.a(callBack, qrSign, qrCmd);
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> callback, String sign, String cmd) {
        this.f12762c.b(callback, sign, cmd);
    }

    public void wapSSOConfirm(SSOConfirmCallback callback, SSOConfirmDTO dto) {
        this.f12762c.a(callback, dto);
    }

    /* renamed from: a */
    boolean m11032a(SapiCallBack<SapiAccountResponse> callBack, String sms) {
        return this.f12762c.b(callBack, sms);
    }

    public void fastReg(SapiCallback<FastRegResult> callback, int timeoutSeconds) {
        this.f12762c.a(callback, timeoutSeconds);
    }

    public void fastReg(SapiCallback<FastRegResult> callback) {
        fastReg(callback, 15);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> callBack, String phoneNum) {
        return this.f12762c.a(callBack, phoneNum);
    }

    public void getDynamicPwd(GetDynamicPwdCallback callback, String phoneNumber, String captcha) {
        this.f12762c.a(callback, phoneNumber, captcha);
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> callBack, String phoneNum, String password) {
        return this.f12762c.a(callBack, phoneNum, password, true);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> callback, String phoneNumber, String dynamicPwd) {
        this.f12762c.a(callback, phoneNumber, dynamicPwd);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback callback, String phoneNumber, String dynamicPwd) {
        this.f12762c.a(callback, phoneNumber, dynamicPwd);
    }

    @Deprecated
    public void relogin(SapiCallBack<SapiResponse> callBack, SapiAccount$ReloginCredentials credentials) {
        this.f12762c.a(callBack, credentials);
    }

    public void relogin(SapiCallback<ReloginResult> callback, ReloginDTO reloginDTO) {
        this.f12762c.a(callback, reloginDTO);
    }

    public int blockingRelogin(SapiAccount$ReloginCredentials credentials) {
        return this.f12762c.a(credentials);
    }

    @Deprecated
    public void deviceLoginCheck() {
        this.f12762c.c();
    }

    @Deprecated
    public boolean isDeviceLoginAvailable() {
        return C4891b.a(this.f12761b.context).b();
    }

    @Deprecated
    public boolean deviceLogin(SapiCallBack<SapiResponse> callBack) {
        if (!C4891b.a(this.f12761b.context).b()) {
            return false;
        }
        String deviceToken = C4891b.a(this.f12761b.context).a();
        if (TextUtils.isEmpty(deviceToken) || "null".equalsIgnoreCase(deviceToken)) {
            return this.f12762c.a(callBack);
        }
        return this.f12762c.d(callBack, deviceToken);
    }

    public void oauth(SapiCallback<OAuthResult> callback, String bduss) {
        this.f12762c.b(callback, bduss);
    }

    public void login(LoginCallback callback, LoginDTO loginDTO) {
        this.f12762c.a(callback, loginDTO);
    }

    /* renamed from: a */
    void m11031a(SapiCallback<LoginResult> callback, String url) {
        this.f12762c.a(callback, url);
    }

    public String getCaptchaKey() {
        return this.f12762c.b();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> callback) {
        this.f12762c.a(callback);
    }

    public void getRegCode(GetRegCodeCallback callback, String phoneNumber) {
        this.f12762c.a(callback, phoneNumber);
    }

    public void phoneReg(SapiCallback<PhoneRegResult> callback, PhoneRegDTO phoneRegDTO) {
        this.f12762c.a(callback, phoneRegDTO);
    }

    public void quickUserReg(QuickUserRegCallback callback, QuickUserRegDTO quickUserRegDTO) {
        this.f12762c.a(callback, quickUserRegDTO);
    }

    public void web2NativeLogin(Web2NativeLoginCallback callback) {
        this.f12762c.a(callback);
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback callback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.f12762c.a(callback, iqiyiLoginDTO);
    }
}
