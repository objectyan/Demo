package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
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
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.Switch;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public final class SapiAccountService
{
  private static final String a = "native";
  private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
  private a c;
  
  SapiAccountService(Context paramContext)
  {
    this.c = new a(paramContext);
  }
  
  String a()
  {
    return this.c.d() + "?" + i();
  }
  
  String a(BindWidgetAction paramBindWidgetAction)
  {
    if (paramBindWidgetAction == null) {
      throw new IllegalArgumentException("BindWidgetAction can't be null");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adapter", "3"));
    return this.c.a(paramBindWidgetAction) + "?" + i() + "&" + SapiUtils.createRequestParams(localArrayList);
  }
  
  String a(SocialType paramSocialType)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
    localArrayList.add(new BasicNameValuePair("display", "native"));
    localArrayList.add(new BasicNameValuePair("type", paramSocialType.getType() + ""));
    localArrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
    localArrayList.add(new BasicNameValuePair("guidebind", "1"));
    return this.c.u() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  String a(SocialType paramSocialType, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
    localArrayList.add(new BasicNameValuePair("display", "native"));
    localArrayList.add(new BasicNameValuePair("type", paramSocialType.getType() + ""));
    localArrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
    localArrayList.add(new BasicNameValuePair("access_token", paramString1));
    localArrayList.add(new BasicNameValuePair("osuid", paramString2));
    return this.c.s() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  String a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("type", SocialType.QQ.getType() + ""));
    localArrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
    localArrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
    localArrayList.add(new BasicNameValuePair("appid", this.b.qqAppID));
    localArrayList.add(new BasicNameValuePair("access_token", paramString1));
    localArrayList.add(new BasicNameValuePair("osuid", paramString2));
    return this.c.s() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  void a(SapiCallback<LoginResult> paramSapiCallback, String paramString)
  {
    this.c.a(paramSapiCallback, paramString);
  }
  
  boolean a(SapiCallBack<SapiAccountResponse> paramSapiCallBack, String paramString)
  {
    return this.c.b(paramSapiCallBack, paramString);
  }
  
  boolean a(SapiCallBack<SapiAccountResponse> paramSapiCallBack, String paramString1, String paramString2)
  {
    return this.c.a(paramSapiCallBack, paramString1, paramString2, false);
  }
  
  String b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adapter", "3"));
    localArrayList.add(new BasicNameValuePair("banner", "1"));
    localArrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
    return this.c.e() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  String b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(new BasicNameValuePair("mkey", paramString2));
    localArrayList.add(new BasicNameValuePair("code", paramString1));
    localArrayList.add(new BasicNameValuePair("appid", this.b.wxAppID));
    localArrayList.add(new BasicNameValuePair("display", "native"));
    return this.c.v() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  public int blockingRelogin(SapiAccount.ReloginCredentials paramReloginCredentials)
  {
    return this.c.a(paramReloginCredentials);
  }
  
  String c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adapter", "3"));
    localArrayList.add(new BasicNameValuePair("banner", "1"));
    localArrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
    return this.c.f() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  public void cancelRequest()
  {
    this.c.a();
  }
  
  String d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adapter", "3"));
    localArrayList.add(new BasicNameValuePair("banner", "1"));
    return this.c.g() + "?" + i() + "&" + SapiUtils.createRequestParams(localArrayList);
  }
  
  @Deprecated
  public boolean deviceLogin(SapiCallBack<SapiResponse> paramSapiCallBack)
  {
    if (!b.a(this.b.context).b()) {
      return false;
    }
    String str = b.a(this.b.context).a();
    if ((TextUtils.isEmpty(str)) || ("null".equalsIgnoreCase(str))) {
      return this.c.a(paramSapiCallBack);
    }
    return this.c.d(paramSapiCallBack, str);
  }
  
  @Deprecated
  public void deviceLoginCheck()
  {
    this.c.c();
  }
  
  public void dynamicPwdLogin(DynamicPwdLoginCallback paramDynamicPwdLoginCallback, String paramString1, String paramString2)
  {
    this.c.a(paramDynamicPwdLoginCallback, paramString1, paramString2);
  }
  
  @Deprecated
  public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> paramSapiCallback, String paramString1, String paramString2)
  {
    this.c.a(paramSapiCallback, paramString1, paramString2);
  }
  
  @Deprecated
  public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> paramSapiCallBack, String paramString1, String paramString2)
  {
    return this.c.a(paramSapiCallBack, paramString1, paramString2, true);
  }
  
  String e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adapter", "3"));
    return this.c.j() + "?" + i() + "&" + SapiUtils.createRequestParams(localArrayList);
  }
  
  String f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("adapter", "3"));
    return this.c.k() + "?" + i() + "&" + SapiUtils.createRequestParams(localArrayList);
  }
  
  public void faceCheck(FaceCheckCallback paramFaceCheckCallback, FaceCheckDTO paramFaceCheckDTO)
  {
    this.c.a(paramFaceCheckCallback, paramFaceCheckDTO);
  }
  
  public void faceDel(FaceDelCallback paramFaceDelCallback, FaceDelDTO paramFaceDelDTO)
  {
    this.c.a(paramFaceDelCallback, paramFaceDelDTO);
  }
  
  public void faceLogin(FaceLoginCallback paramFaceLoginCallback, FaceLoginDTO paramFaceLoginDTO)
  {
    this.c.a(paramFaceLoginCallback, paramFaceLoginDTO);
  }
  
  public void faceModify(FaceModifyCallback paramFaceModifyCallback, FaceModifyDTO paramFaceModifyDTO)
  {
    this.c.a(paramFaceModifyCallback, paramFaceModifyDTO);
  }
  
  public void faceReg(FaceRegCallback paramFaceRegCallback, FaceRegDTO paramFaceRegDTO)
  {
    this.c.a(paramFaceRegCallback, paramFaceRegDTO);
  }
  
  public void fastReg(SapiCallback<FastRegResult> paramSapiCallback)
  {
    fastReg(paramSapiCallback, 15);
  }
  
  public void fastReg(SapiCallback<FastRegResult> paramSapiCallback, int paramInt)
  {
    this.c.a(paramSapiCallback, paramInt);
  }
  
  public void fillUserProfile(FillUserProfileCallback paramFillUserProfileCallback, String paramString)
  {
    this.c.a(paramFillUserProfileCallback, paramString);
  }
  
  public void fillUsername(FillUsernameCallback paramFillUsernameCallback, String paramString1, String paramString2)
  {
    this.c.a(paramFillUsernameCallback, paramString1, paramString2);
  }
  
  @Deprecated
  public void fillUsername(FillUsernameCallBack paramFillUsernameCallBack, String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramFillUsernameCallBack, paramString1, paramString2, paramString3);
  }
  
  String g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl));
    localArrayList.add(new BasicNameValuePair("showtype", "phone"));
    localArrayList.add(new BasicNameValuePair("device", "wap"));
    localArrayList.add(new BasicNameValuePair("adapter", "apps"));
    return this.c.h() + i() + "&" + SapiUtils.createRequestParams(localArrayList);
  }
  
  public void getCaptcha(SapiCallback<GetCaptchaResult> paramSapiCallback)
  {
    this.c.a(paramSapiCallback);
  }
  
  public String getCaptchaKey()
  {
    return this.c.b();
  }
  
  public void getDynamicPwd(GetDynamicPwdCallback paramGetDynamicPwdCallback, String paramString1, String paramString2)
  {
    this.c.a(paramGetDynamicPwdCallback, paramString1, paramString2);
  }
  
  @Deprecated
  public boolean getDynamicPwd(SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    return this.c.a(paramSapiCallBack, paramString);
  }
  
  public void getHistoryPortraits(GetHistoryPortraitsCallback paramGetHistoryPortraitsCallback, GetHistoryPortraitsDTO paramGetHistoryPortraitsDTO)
  {
    this.c.a(paramGetHistoryPortraitsCallback, paramGetHistoryPortraitsDTO);
  }
  
  public void getPopularPortraitsInfo(GetPopularPortraitsCallback paramGetPopularPortraitsCallback, String paramString)
  {
    this.c.a(paramGetPopularPortraitsCallback, paramString);
  }
  
  @Deprecated
  public void getPortrait(SapiCallBack<GetPortraitResponse> paramSapiCallBack, String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramSapiCallBack, paramString1, paramString2, paramString3);
  }
  
  public void getRegCode(GetRegCodeCallback paramGetRegCodeCallback, String paramString)
  {
    this.c.a(paramGetRegCodeCallback, paramString);
  }
  
  public void getUserInfo(GetUserInfoCallback paramGetUserInfoCallback, String paramString)
  {
    this.c.a(paramGetUserInfoCallback, paramString);
  }
  
  @Deprecated
  public void getUserInfo(GetUserInfoCallBack paramGetUserInfoCallBack, String paramString)
  {
    this.c.a(paramGetUserInfoCallBack, paramString);
  }
  
  String h()
  {
    return this.c.i();
  }
  
  String i()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("clientfrom", "native"));
    localArrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
    localArrayList.add(new BasicNameValuePair("login_share_strategy", this.b.loginShareStrategy().getStrValue()));
    localArrayList.add(new BasicNameValuePair("client", "android"));
    String str;
    if (this.b.customActionBarEnabled) {
      str = "3";
    }
    for (;;)
    {
      localArrayList.add(new BasicNameValuePair("adapter", str));
      localArrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
      localArrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
      localArrayList.add(new BasicNameValuePair("loginLink", String.valueOf(this.b.smsLoginConfig.flagShowLoginLink.ordinal())));
      localArrayList.add(new BasicNameValuePair("smsLoginLink", String.valueOf(this.b.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
      localArrayList.add(new BasicNameValuePair("lPFastRegLink", String.valueOf(this.b.smsLoginConfig.flagShowFastRegLink.ordinal())));
      if (this.b.registMode == RegistMode.FAST) {
        localArrayList.add(new BasicNameValuePair("fastRegLink", "1"));
      }
      if (this.b.quickUserEnabled)
      {
        localArrayList.add(new BasicNameValuePair("quick_user", "1"));
        if (this.b.registMode == RegistMode.QUICK_USER) {
          localArrayList.add(new BasicNameValuePair("regtype", "2"));
        }
      }
      localArrayList.add(new BasicNameValuePair("lPlayout", String.valueOf(this.b.configurableViewLayout.ordinal())));
      if (!this.b.showRegLink) {
        localArrayList.add(new BasicNameValuePair("regLink", "0"));
      }
      if (!TextUtils.isEmpty(this.b.fastRegTitleText)) {}
      try
      {
        localArrayList.add(new BasicNameValuePair("fastRegText", URLEncoder.encode(this.b.fastRegTitleText, "UTF-8")));
        if (this.b.uniteVerify) {
          localArrayList.add(new BasicNameValuePair("connect", "1"));
        }
        return SapiUtils.createRequestParams(localArrayList);
        str = "";
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          L.e(localThrowable);
        }
      }
    }
  }
  
  public void iqiyiSSOLogin(IqiyiLoginCallback paramIqiyiLoginCallback, IqiyiLoginDTO paramIqiyiLoginDTO)
  {
    this.c.a(paramIqiyiLoginCallback, paramIqiyiLoginDTO);
  }
  
  @Deprecated
  public boolean isDeviceLoginAvailable()
  {
    return b.a(this.b.context).b();
  }
  
  String j()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("type", SocialType.WEIXIN.getType() + ""));
    localArrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
    localArrayList.add(new BasicNameValuePair("display", "native"));
    localArrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
    localArrayList.add(new BasicNameValuePair("app_key", this.b.wxAppID));
    localArrayList.add(new BasicNameValuePair("scope", "snsapi_login"));
    return this.c.u() + "?" + SapiUtils.createRequestParams(localArrayList);
  }
  
  String k()
  {
    return this.c.t();
  }
  
  String l()
  {
    return this.c.v();
  }
  
  public void login(LoginCallback paramLoginCallback, LoginDTO paramLoginDTO)
  {
    this.c.a(paramLoginCallback, paramLoginDTO);
  }
  
  String m()
  {
    return this.c.w();
  }
  
  public void oauth(SapiCallback<OAuthResult> paramSapiCallback, String paramString)
  {
    this.c.b(paramSapiCallback, paramString);
  }
  
  public void phoneReg(SapiCallback<PhoneRegResult> paramSapiCallback, PhoneRegDTO paramPhoneRegDTO)
  {
    this.c.a(paramSapiCallback, paramPhoneRegDTO);
  }
  
  public void qrAppLogin(SapiCallback<QrAppLoginResult> paramSapiCallback, String paramString1, String paramString2)
  {
    this.c.b(paramSapiCallback, paramString1, paramString2);
  }
  
  @Deprecated
  public void qrAppLogin(QrAppLoginCallBack paramQrAppLoginCallBack, String paramString1, String paramString2)
  {
    this.c.a(paramQrAppLoginCallBack, paramString1, paramString2);
  }
  
  @Deprecated
  public void qrPCLogin(QrPCLoginCallBack paramQrPCLoginCallBack, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.c.a(paramQrPCLoginCallBack, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void qrPcLogin(QrPcLoginCallback paramQrPcLoginCallback, String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramQrPcLoginCallback, paramString1, paramString2, paramString3);
  }
  
  public void quickUserReg(QuickUserRegCallback paramQuickUserRegCallback, QuickUserRegDTO paramQuickUserRegDTO)
  {
    this.c.a(paramQuickUserRegCallback, paramQuickUserRegDTO);
  }
  
  public void relogin(SapiCallback<ReloginResult> paramSapiCallback, ReloginDTO paramReloginDTO)
  {
    this.c.a(paramSapiCallback, paramReloginDTO);
  }
  
  @Deprecated
  public void relogin(SapiCallBack<SapiResponse> paramSapiCallBack, SapiAccount.ReloginCredentials paramReloginCredentials)
  {
    this.c.a(paramSapiCallBack, paramReloginCredentials);
  }
  
  public void setPopularPortrait(SetPopularPortraitCallback paramSetPopularPortraitCallback, SetPopularPortraitDTO paramSetPopularPortraitDTO)
  {
    this.c.a(paramSetPopularPortraitCallback, paramSetPopularPortraitDTO);
  }
  
  public void setPortrait(SetPortraitCallback paramSetPortraitCallback, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.c.a(paramSetPortraitCallback, paramString1, paramArrayOfByte, paramString2);
  }
  
  @Deprecated
  public void setPortrait(SapiCallBack<SapiResponse> paramSapiCallBack, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    this.c.a(paramSapiCallBack, paramString1, paramString2, paramString3, paramArrayOfByte, paramString4);
  }
  
  public void voiceCheck(VoiceCheckCallback paramVoiceCheckCallback, VoiceCheckDTO paramVoiceCheckDTO)
  {
    this.c.a(paramVoiceCheckCallback, paramVoiceCheckDTO);
  }
  
  public void voiceCheck(VoiceCheckCallback paramVoiceCheckCallback, String paramString)
  {
    this.c.a(paramVoiceCheckCallback, paramString, null);
  }
  
  public void voiceCheckByUid(VoiceCheckCallback paramVoiceCheckCallback, String paramString)
  {
    this.c.a(paramVoiceCheckCallback, null, paramString);
  }
  
  public void voiceCodeSet(VoiceCodeSetCallback paramVoiceCodeSetCallback, VoiceCodeSetDTO paramVoiceCodeSetDTO)
  {
    this.c.a(paramVoiceCodeSetCallback, paramVoiceCodeSetDTO);
  }
  
  public void voiceLogin(VoiceLoginCallback paramVoiceLoginCallback, String paramString1, String paramString2)
  {
    this.c.a(paramVoiceLoginCallback, paramString1, paramString2);
  }
  
  public void voiceReg(SapiCallback<VoiceRegResult> paramSapiCallback, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.c.a(paramSapiCallback, paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void voiceSwitchSet(VoiceSwitchSetCallback paramVoiceSwitchSetCallback, VoiceSwitchSetDTO paramVoiceSwitchSetDTO)
  {
    this.c.a(paramVoiceSwitchSetCallback, paramVoiceSwitchSetDTO);
  }
  
  public void voiceVerify(VoiceVerifyCallback paramVoiceVerifyCallback, VoiceVerifyDTO paramVoiceVerifyDTO)
  {
    this.c.a(paramVoiceVerifyCallback, paramVoiceVerifyDTO);
  }
  
  public void wapSSOConfirm(SSOConfirmCallback paramSSOConfirmCallback, SSOConfirmDTO paramSSOConfirmDTO)
  {
    this.c.a(paramSSOConfirmCallback, paramSSOConfirmDTO);
  }
  
  public void web2NativeLogin(Web2NativeLoginCallback paramWeb2NativeLoginCallback)
  {
    this.c.a(paramWeb2NativeLoginCallback);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/sapi2/SapiAccountService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */