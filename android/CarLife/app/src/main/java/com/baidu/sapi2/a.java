package com.baidu.sapi2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
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
import com.baidu.sapi2.dto.FaceCheckDTO.AccountType;
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
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.c;
import com.baidu.sapi2.utils.d;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.e.a;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.Switch;
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
import java.util.Set;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

final class a
{
  private static final int a = 6;
  private static final String b = "3";
  private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();
  private AsyncHttpClient d;
  private a e;
  private String f;
  private String g;
  private LoginDTO h;
  
  a(Context paramContext)
  {
    this.e = new a(paramContext);
  }
  
  private String a(Map<String, String> paramMap, String paramString)
  {
    Object localObject1 = paramMap.keySet().iterator();
    Object localObject2 = new ArrayList();
    while (((Iterator)localObject1).hasNext()) {
      ((ArrayList)localObject2).add(((Iterator)localObject1).next());
    }
    Collections.sort((List)localObject2);
    localObject1 = new StringBuilder();
    localObject2 = ((ArrayList)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("=");
        try
        {
          str = (String)paramMap.get(str);
          if (!TextUtils.isEmpty(str)) {
            ((StringBuilder)localObject1).append(URLEncoder.encode(str, "UTF-8"));
          }
          ((StringBuilder)localObject1).append("&");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            L.e(localUnsupportedEncodingException);
          }
        }
      }
    }
    ((StringBuilder)localObject1).append("sign_key=").append(paramString);
    return MD5Util.toMd5(((StringBuilder)localObject1).toString().getBytes(), false);
  }
  
  private void a(int paramInt, FillUsernameCallBack paramFillUsernameCallBack, String paramString, SapiDataEncryptor paramSapiDataEncryptor)
  {
    SapiAccountResponse localSapiAccountResponse;
    if (paramString != null) {
      localSapiAccountResponse = new SapiAccountResponse();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("userinfo");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        paramString = new JSONObject(paramSapiDataEncryptor.a(paramString));
        localSapiAccountResponse.bduss = paramString.optString("bduss");
        localSapiAccountResponse.ptoken = paramString.optString("ptoken");
        localSapiAccountResponse.stoken = paramString.optString("stoken");
        localSapiAccountResponse.displayname = paramString.optString("displayname");
        localSapiAccountResponse.uid = paramString.optString("uid");
        localSapiAccountResponse.username = paramString.optString("uname");
        localSapiAccountResponse.email = paramString.optString("email");
        switch (paramInt)
        {
        case 0: 
          paramFillUsernameCallBack.onSystemError(paramInt);
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramFillUsernameCallBack.onSystemError(paramInt);
        return;
      }
      paramSapiDataEncryptor = a(localSapiAccountResponse);
      paramSapiDataEncryptor.extra = paramString.toString();
      com.baidu.sapi2.share.a.a().a(paramSapiDataEncryptor);
      paramFillUsernameCallBack.onSuccess(localSapiAccountResponse);
      return;
      paramFillUsernameCallBack.onUsernameFormatError();
      return;
      paramFillUsernameCallBack.onUsernameAlreadyExist();
      return;
      paramFillUsernameCallBack.onUserHaveUsername();
      return;
      paramFillUsernameCallBack.onInvalidBduss();
      return;
      paramFillUsernameCallBack.onSystemError(paramInt);
      return;
    }
  }
  
  private void a(final IqiyiLoginCallback paramIqiyiLoginCallback, final IqiyiLoginDTO paramIqiyiLoginDTO, final IqiyiLoginResult paramIqiyiLoginResult)
  {
    if ((TextUtils.isEmpty(paramIqiyiLoginDTO.accessToken)) || (TextUtils.isEmpty(paramIqiyiLoginDTO.openID)))
    {
      paramIqiyiLoginCallback.onLogin(paramIqiyiLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a(s());
    ((Map)localObject).put("crypt_m", paramIqiyiLoginDTO.phoneNum);
    ((Map)localObject).put("access_token", paramIqiyiLoginDTO.accessToken);
    ((Map)localObject).put("osuid", paramIqiyiLoginDTO.openID);
    ((Map)localObject).put("json", "1");
    ((Map)localObject).put("type", SocialType.IQIYI.getType() + "");
    ((Map)localObject).put("act", "special");
    ((Map)localObject).put("display", "native");
    ((Map)localObject).put("client", "android");
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.get(this.c.context, s(), (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          paramIqiyiLoginResult.setResultCode(65334);
          paramIqiyiLoginCallback.onFailure(paramIqiyiLoginResult);
          return;
        }
        a.a(a.this).b();
        paramIqiyiLoginCallback.onStart();
        a.a(a.this, paramIqiyiLoginCallback, paramIqiyiLoginDTO, paramIqiyiLoginResult);
      }
      
      protected void onFinish()
      {
        paramIqiyiLoginCallback.onFinish();
      }
      
      protected void onStart() {}
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this).d();
        if (a.this.b(paramAnonymousString) == 302) {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            paramIqiyiLoginResult.nextUrl = paramAnonymousString.optString("next_url");
            paramIqiyiLoginCallback.onBindWebview(paramIqiyiLoginResult);
            return;
          }
          catch (JSONException paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            return;
          }
        }
        paramAnonymousString = SapiWebView.b(paramAnonymousString);
        if (paramAnonymousString == null)
        {
          paramIqiyiLoginResult.setResultCode(-100);
          paramIqiyiLoginResult.setResultMsg("登录失败");
          paramIqiyiLoginCallback.onFailure(paramIqiyiLoginResult);
          return;
        }
        if (paramAnonymousString.errorCode != -100)
        {
          paramIqiyiLoginResult.setResultCode(-100);
          paramIqiyiLoginResult.setResultMsg("登录失败");
          paramIqiyiLoginCallback.onFailure(paramIqiyiLoginResult);
          return;
        }
        SapiAccount localSapiAccount = a.this.a(paramAnonymousString);
        c.a(localSapiAccount, paramAnonymousString.socialType, paramAnonymousString.socialPortraitUrl);
        com.baidu.sapi2.share.a.a().a(localSapiAccount);
        paramIqiyiLoginCallback.onSuccess(paramIqiyiLoginResult);
      }
    });
  }
  
  private void a(final SapiCallback<FastRegResult> paramSapiCallback, final RequestParams paramRequestParams, final Handler paramHandler, final Runnable paramRunnable, final boolean[] paramArrayOfBoolean)
  {
    final FastRegResult localFastRegResult = new FastRegResult();
    if (paramArrayOfBoolean[0] != 0)
    {
      this.e.d();
      localFastRegResult.setResultCode(-103);
      paramSapiCallback.onFinish();
      paramSapiCallback.onFailure(localFastRegResult);
      return;
    }
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/smsgetlogin", paramRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localFastRegResult.setResultCode(65334);
          paramHandler.removeCallbacks(paramRunnable);
          paramSapiCallback.onFinish();
          paramSapiCallback.onFailure(localFastRegResult);
          return;
        }
        a.a(a.this).b();
        a.a(a.this, paramSapiCallback, paramRequestParams, paramHandler, paramRunnable, paramArrayOfBoolean);
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localFastRegResult.setResultCode(paramAnonymousInt);
        for (;;)
        {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            localObject = paramAnonymousString.optJSONObject("sdk").optString("msg");
            localFastRegResult.setResultMsg((String)localObject);
            switch (paramAnonymousInt)
            {
            case 0: 
              a.a(a.this).d();
              paramHandler.removeCallbacks(paramRunnable);
              paramSapiCallback.onFinish();
              paramSapiCallback.onFailure(localFastRegResult);
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            Object localObject;
            a.a(a.this).d();
            paramHandler.removeCallbacks(paramRunnable);
            paramSapiCallback.onFinish();
            paramSapiCallback.onFailure(localFastRegResult);
            L.e(paramAnonymousString);
            return;
          }
          a.a(a.this).d();
          localObject = a.this.a(paramAnonymousString);
          com.baidu.sapi2.share.a.a().a((SapiAccount)localObject);
          localFastRegResult.newReg = paramAnonymousString.optBoolean("newreg");
          localFastRegResult.authSid = paramAnonymousString.optString("authsid");
          if ("null".equals(localFastRegResult.authSid)) {
            localFastRegResult.authSid = null;
          }
          paramHandler.removeCallbacks(paramRunnable);
          paramSapiCallback.onFinish();
          paramSapiCallback.onSuccess(localFastRegResult);
          return;
          paramHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              a.a(a.this, a.43.this.d, a.43.this.e, a.43.this.b, a.43.this.c, a.43.this.f);
            }
          }, 400L);
          return;
        }
      }
    });
  }
  
  private void a(SapiCallback<VoiceRegResult> paramSapiCallback, String paramString, boolean paramBoolean)
  {
    VoiceRegResult localVoiceRegResult = new VoiceRegResult();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = Integer.parseInt(paramString.optString("errno"));
        localVoiceRegResult.setResultCode(i);
        switch (i)
        {
        case 0: 
          paramSapiCallback.onFailure(localVoiceRegResult);
          return;
        }
      }
      catch (Exception paramString)
      {
        localVoiceRegResult.setResultCode(65334);
        paramSapiCallback.onFailure(localVoiceRegResult);
        return;
      }
      if (paramBoolean)
      {
        paramString = a(paramString);
        com.baidu.sapi2.share.a.a().a(paramString);
      }
      paramSapiCallback.onSuccess(localVoiceRegResult);
      return;
    }
  }
  
  /* Error */
  private void a(VoiceCheckCallback paramVoiceCheckCallback, String paramString)
  {
    // Byte code:
    //   0: new 559	com/baidu/sapi2/result/VoiceCheckResult
    //   3: dup
    //   4: invokespecial 560	com/baidu/sapi2/result/VoiceCheckResult:<init>	()V
    //   7: astore 4
    //   9: new 275	org/json/JSONObject
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 278	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 544
    //   22: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 550	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: aload 4
    //   31: iload_3
    //   32: invokevirtual 561	com/baidu/sapi2/result/VoiceCheckResult:setResultCode	(I)V
    //   35: iload_3
    //   36: lookupswitch	default:+308->344, 0:+51->87, 3:+287->323, 400021:+301->337, 400401:+294->330
    //   80: aload_1
    //   81: aload 4
    //   83: invokevirtual 564	com/baidu/sapi2/callback/VoiceCheckCallback:onFailure	(Lcom/baidu/sapi2/result/SapiResult;)V
    //   86: return
    //   87: aload 4
    //   89: aload_2
    //   90: ldc_w 566
    //   93: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   96: getstatic 568	com/baidu/sapi2/utils/SapiDataEncryptor:a	Ljava/lang/String;
    //   99: invokestatic 570	com/baidu/sapi2/utils/SapiDataEncryptor:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 571	com/baidu/sapi2/result/VoiceCheckResult:uid	Ljava/lang/String;
    //   105: aload 4
    //   107: aload_2
    //   108: ldc_w 302
    //   111: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 572	com/baidu/sapi2/result/VoiceCheckResult:displayname	Ljava/lang/String;
    //   117: aload 4
    //   119: ldc_w 452
    //   122: aload_2
    //   123: ldc_w 574
    //   126: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokevirtual 577	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: putfield 581	com/baidu/sapi2/result/VoiceCheckResult:signUp	Z
    //   135: aload 4
    //   137: ldc_w 452
    //   140: aload_2
    //   141: ldc_w 583
    //   144: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 577	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: putfield 586	com/baidu/sapi2/result/VoiceCheckResult:needVerify	Z
    //   153: aload 4
    //   155: aload_2
    //   156: ldc_w 588
    //   159: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   162: putfield 591	com/baidu/sapi2/result/VoiceCheckResult:authToken	Ljava/lang/String;
    //   165: aload_2
    //   166: ldc_w 593
    //   169: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   175: ifne +123 -> 298
    //   178: aload_2
    //   179: ldc_w 593
    //   182: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: ldc_w 452
    //   188: invokevirtual 577	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifeq +107 -> 298
    //   194: aload 4
    //   196: getstatic 599	com/baidu/sapi2/utils/enums/Switch:ON	Lcom/baidu/sapi2/utils/enums/Switch;
    //   199: putfield 602	com/baidu/sapi2/result/VoiceCheckResult:switchState	Lcom/baidu/sapi2/utils/enums/Switch;
    //   202: ldc_w 604
    //   205: aload 4
    //   207: getfield 591	com/baidu/sapi2/result/VoiceCheckResult:authToken	Ljava/lang/String;
    //   210: invokevirtual 577	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +9 -> 222
    //   216: aload 4
    //   218: aconst_null
    //   219: putfield 591	com/baidu/sapi2/result/VoiceCheckResult:authToken	Ljava/lang/String;
    //   222: aload 4
    //   224: aload_2
    //   225: ldc_w 606
    //   228: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: putfield 609	com/baidu/sapi2/result/VoiceCheckResult:authSid	Ljava/lang/String;
    //   234: ldc_w 604
    //   237: aload 4
    //   239: getfield 609	com/baidu/sapi2/result/VoiceCheckResult:authSid	Ljava/lang/String;
    //   242: invokevirtual 577	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifeq +9 -> 254
    //   248: aload 4
    //   250: aconst_null
    //   251: putfield 609	com/baidu/sapi2/result/VoiceCheckResult:authSid	Ljava/lang/String;
    //   254: aload 4
    //   256: aload_2
    //   257: ldc_w 611
    //   260: invokevirtual 284	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   263: getstatic 568	com/baidu/sapi2/utils/SapiDataEncryptor:a	Ljava/lang/String;
    //   266: invokestatic 570	com/baidu/sapi2/utils/SapiDataEncryptor:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   269: invokestatic 550	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   272: putfield 614	com/baidu/sapi2/result/VoiceCheckResult:voiceCode	I
    //   275: aload_1
    //   276: aload 4
    //   278: invokevirtual 615	com/baidu/sapi2/callback/VoiceCheckCallback:onSuccess	(Lcom/baidu/sapi2/result/SapiResult;)V
    //   281: return
    //   282: astore_2
    //   283: aload 4
    //   285: sipush 65334
    //   288: invokevirtual 561	com/baidu/sapi2/result/VoiceCheckResult:setResultCode	(I)V
    //   291: aload_1
    //   292: aload 4
    //   294: invokevirtual 564	com/baidu/sapi2/callback/VoiceCheckCallback:onFailure	(Lcom/baidu/sapi2/result/SapiResult;)V
    //   297: return
    //   298: aload 4
    //   300: getstatic 618	com/baidu/sapi2/utils/enums/Switch:OFF	Lcom/baidu/sapi2/utils/enums/Switch;
    //   303: putfield 602	com/baidu/sapi2/result/VoiceCheckResult:switchState	Lcom/baidu/sapi2/utils/enums/Switch;
    //   306: goto -104 -> 202
    //   309: astore_2
    //   310: aload 4
    //   312: iconst_m1
    //   313: putfield 614	com/baidu/sapi2/result/VoiceCheckResult:voiceCode	I
    //   316: aload_2
    //   317: invokestatic 249	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   320: goto -45 -> 275
    //   323: aload_1
    //   324: aload 4
    //   326: invokevirtual 621	com/baidu/sapi2/callback/VoiceCheckCallback:onIncompleteUser	(Lcom/baidu/sapi2/result/SapiResult;)V
    //   329: return
    //   330: aload_1
    //   331: aload 4
    //   333: invokevirtual 625	com/baidu/sapi2/callback/VoiceCheckCallback:onAccountTypeConflict	(Lcom/baidu/sapi2/result/VoiceCheckResult;)V
    //   336: return
    //   337: aload_1
    //   338: aload 4
    //   340: invokevirtual 628	com/baidu/sapi2/callback/VoiceCheckCallback:onBdussExpired	(Lcom/baidu/sapi2/result/SapiResult;)V
    //   343: return
    //   344: goto -264 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	a
    //   0	347	1	paramVoiceCheckCallback	VoiceCheckCallback
    //   0	347	2	paramString	String
    //   28	8	3	i	int
    //   7	332	4	localVoiceCheckResult	VoiceCheckResult
    // Exception table:
    //   from	to	target	type
    //   9	35	282	java/lang/Exception
    //   80	86	282	java/lang/Exception
    //   87	202	282	java/lang/Exception
    //   202	222	282	java/lang/Exception
    //   222	254	282	java/lang/Exception
    //   275	281	282	java/lang/Exception
    //   298	306	282	java/lang/Exception
    //   310	320	282	java/lang/Exception
    //   323	329	282	java/lang/Exception
    //   330	336	282	java/lang/Exception
    //   337	343	282	java/lang/Exception
    //   254	275	309	java/lang/Exception
  }
  
  private void a(VoiceLoginCallback paramVoiceLoginCallback, String paramString)
  {
    VoiceLoginResult localVoiceLoginResult = new VoiceLoginResult();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = Integer.parseInt(paramString.optString("errno"));
        localVoiceLoginResult.setResultCode(i);
        switch (i)
        {
        case 0: 
          paramVoiceLoginCallback.onFailure(localVoiceLoginResult);
          return;
        }
      }
      catch (Exception paramString)
      {
        localVoiceLoginResult.setResultCode(65334);
        paramVoiceLoginCallback.onFailure(localVoiceLoginResult);
        return;
      }
      paramString = a(paramString);
      com.baidu.sapi2.share.a.a().a(paramString);
      paramVoiceLoginCallback.onSuccess(localVoiceLoginResult);
      return;
      paramVoiceLoginCallback.onPwdVerifyFailure(localVoiceLoginResult);
      return;
    }
  }
  
  private void a(final FillUsernameCallBack paramFillUsernameCallBack, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final SapiDataEncryptor paramSapiDataEncryptor)
    throws JSONException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException
  {
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", this.c.appId);
    localHashMap.put("tpl", this.c.tpl);
    localHashMap.put("cert_id", paramString5);
    localHashMap.put("crypttype", String.valueOf(6));
    paramString5 = new JSONObject();
    paramString5.put("bduss", paramString1);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      paramString5.put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      paramString5.put("clientip", this.c.clientIp);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramString5.put("ptoken", paramString2);
    }
    paramString5.put("username", paramString3);
    paramString5.put("key", paramSapiDataEncryptor.a());
    localHashMap.put("userinfo", paramSapiDataEncryptor.a(paramString4, paramString5.toString()));
    localHashMap.put("sig", a(localHashMap, this.c.appSignKey));
    paramString1 = new RequestParams(localHashMap);
    this.d.post(this.c.context, l(), paramString1, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        a.a(a.this, a.this.c(paramAnonymousString), paramFillUsernameCallBack, paramAnonymousString, paramSapiDataEncryptor);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this, a.this.c(paramAnonymousString), paramFillUsernameCallBack, paramAnonymousString, paramSapiDataEncryptor);
      }
    });
  }
  
  private void a(final SapiCallBack<SapiAccountResponse> paramSapiCallBack, String paramString1, String paramString2, final String paramString3, final String paramString4, final boolean paramBoolean, final SapiDataEncryptor paramSapiDataEncryptor)
    throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException
  {
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    HashMap localHashMap = new HashMap();
    localHashMap.put("crypttype", "6");
    localHashMap.put("tpl", this.c.tpl);
    localHashMap.put("appid", this.c.appId);
    String str = this.c.clientId;
    if (!TextUtils.isEmpty(str)) {
      localHashMap.put("cuid", str);
    }
    localHashMap.put("cert_id", paramString2);
    localHashMap.put("isdpass", "1");
    paramString2 = new JSONObject();
    paramString2.put("username", paramString3);
    paramString2.put("isphone", "1");
    paramString2.put("password", paramString4);
    paramString2.put("login_type", "3");
    paramString2.put("key", paramSapiDataEncryptor.a());
    paramString2.put("sdk_version", "2");
    paramString2.put("pinfo", e.b());
    localHashMap.put("userinfo", paramSapiDataEncryptor.a(paramString1, paramString2.toString()));
    localHashMap.put("sig", a(localHashMap, this.c.appSignKey));
    paramString1 = new RequestParams(localHashMap);
    this.d.post(this.c.context, r(), paramString1, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.this.a(a.this.b(paramAnonymousString), paramSapiCallBack, paramAnonymousString, paramBoolean, paramSapiDataEncryptor);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramSapiCallBack, paramString3, paramString4, paramBoolean);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.this.a(a.this.b(paramAnonymousString), paramSapiCallBack, paramAnonymousString, paramBoolean, paramSapiDataEncryptor);
      }
    });
  }
  
  private void d(int paramInt, SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    SapiAccountResponse localSapiAccountResponse;
    if (paramString != null)
    {
      localSapiAccountResponse = new SapiAccountResponse();
      localSapiAccountResponse.errorCode = paramInt;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        localSapiAccountResponse.displayname = ((JSONObject)localObject).optString("displayname");
        localSapiAccountResponse.username = ((JSONObject)localObject).optString("uname");
        localSapiAccountResponse.uid = ((JSONObject)localObject).optString("uid");
        localSapiAccountResponse.email = ((JSONObject)localObject).optString("email");
        localSapiAccountResponse.bduss = ((JSONObject)localObject).optString("bduss");
        localSapiAccountResponse.ptoken = ((JSONObject)localObject).optString("ptoken");
        localSapiAccountResponse.stoken = ((JSONObject)localObject).optString("stoken");
        localSapiAccountResponse.authSid = ((JSONObject)localObject).optString("authsid");
        if (paramSapiCallBack == null) {
          break;
        }
        switch (paramInt)
        {
        case 0: 
          paramSapiCallBack.onSystemError(paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        L.e(paramString);
        if (paramSapiCallBack == null) {
          break;
        }
      }
      localObject = a(localSapiAccountResponse);
      ((SapiAccount)localObject).extra = paramString;
      com.baidu.sapi2.share.a.a().a((SapiAccount)localObject);
      paramSapiCallBack.onSuccess(localSapiAccountResponse);
      return;
      paramSapiCallBack.onSystemError(-100);
      return;
      if (paramSapiCallBack == null) {
        break;
      }
      paramSapiCallBack.onSystemError(paramInt);
      return;
    }
  }
  
  private String x()
  {
    return "tpl:" + this.c.tpl + ";android_sapi_v" + "6.14.5";
  }
  
  private Domain y()
  {
    return this.c.environment;
  }
  
  private String z()
  {
    return this.e.a() + "/sslcrypt/get_last_cert";
  }
  
  int a(SapiAccount.ReloginCredentials paramReloginCredentials)
  {
    if (paramReloginCredentials == null) {
      throw new IllegalArgumentException("ReloginCredentials can't be null");
    }
    int i;
    if (TextUtils.isEmpty(paramReloginCredentials.account)) {
      i = 130005;
    }
    int j;
    do
    {
      return i;
      if (TextUtils.isEmpty(paramReloginCredentials.password)) {
        return 130010;
      }
      if (TextUtils.isEmpty(paramReloginCredentials.ubi)) {
        return 130025;
      }
      if (!SapiUtils.hasActiveNetwork(this.c.context)) {
        return 65336;
      }
      Object localObject2 = new SapiDataEncryptor();
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              this.d = new AsyncHttpClient();
              this.d.setUserAgent(x());
              localObject1 = new HashMap();
              ((Map)localObject1).put("crypttype", "11");
              ((Map)localObject1).put("tpl", this.c.tpl);
              ((Map)localObject1).put("appid", this.c.appId);
              if (TextUtils.isEmpty(this.c.clientId)) {
                this.c.clientId = SapiUtils.getClientId(this.c.context);
              }
              ((Map)localObject1).put("cuid", this.c.clientId);
              ((Map)localObject1).put("cert_id", "2");
              ((Map)localObject1).put("isdpass", "0");
              ((Map)localObject1).put("username", paramReloginCredentials.account);
              ((Map)localObject1).put("password", paramReloginCredentials.password);
              ((Map)localObject1).put("UBI", paramReloginCredentials.ubi);
              if ("3".equals(paramReloginCredentials.accountType))
              {
                paramReloginCredentials = "1";
                ((Map)localObject1).put("isphone", paramReloginCredentials);
                ((Map)localObject1).put("login_type", "3");
                ((Map)localObject1).put("key", ((SapiDataEncryptor)localObject2).a());
                ((Map)localObject1).put("sdk_version", "2");
                ((Map)localObject1).put("pinfo", e.b());
                ((Map)localObject1).put("sig", a((Map)localObject1, this.c.appSignKey));
                paramReloginCredentials = new ArrayList();
                localObject1 = ((Map)localObject1).entrySet().iterator();
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                paramReloginCredentials.add(new BasicNameValuePair((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue()));
                continue;
              }
              paramReloginCredentials = "0";
            }
            catch (Throwable paramReloginCredentials)
            {
              L.e(paramReloginCredentials);
              return -100;
            }
          }
          Object localObject1 = new HttpPost(r());
          ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity(paramReloginCredentials, "UTF-8"));
          paramReloginCredentials = this.d.execute((HttpUriRequest)localObject1);
        } while (200 != paramReloginCredentials.getStatusLine().getStatusCode());
        paramReloginCredentials = EntityUtils.toString(paramReloginCredentials.getEntity());
      } while (TextUtils.isEmpty(paramReloginCredentials));
      j = b(paramReloginCredentials);
      i = j;
    } while (j != 0);
    paramReloginCredentials = a(new JSONObject(paramReloginCredentials));
    com.baidu.sapi2.share.a.a().a(paramReloginCredentials);
    return j;
  }
  
  SapiAccount a(SapiAccountResponse paramSapiAccountResponse)
  {
    SapiAccount localSapiAccount = new SapiAccount();
    localSapiAccount.displayname = paramSapiAccountResponse.displayname;
    localSapiAccount.bduss = paramSapiAccountResponse.bduss;
    localSapiAccount.ptoken = paramSapiAccountResponse.ptoken;
    localSapiAccount.stoken = paramSapiAccountResponse.stoken;
    localSapiAccount.uid = paramSapiAccountResponse.uid;
    localSapiAccount.username = paramSapiAccountResponse.username;
    localSapiAccount.app = SapiUtils.getAppName(this.c.context);
    return localSapiAccount;
  }
  
  SapiAccount a(JSONObject paramJSONObject)
  {
    SapiAccount localSapiAccount = new SapiAccount();
    localSapiAccount.uid = paramJSONObject.optString("uid");
    localSapiAccount.bduss = paramJSONObject.optString("bduss");
    localSapiAccount.displayname = paramJSONObject.optString("displayname");
    localSapiAccount.username = paramJSONObject.optString("uname");
    localSapiAccount.stoken = paramJSONObject.optString("stoken");
    localSapiAccount.ptoken = paramJSONObject.optString("ptoken");
    localSapiAccount.extra = paramJSONObject.toString();
    localSapiAccount.app = SapiUtils.getAppName(this.c.context);
    return localSapiAccount;
  }
  
  String a(BindWidgetAction paramBindWidgetAction)
  {
    return y().getWap() + paramBindWidgetAction.getUri();
  }
  
  Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tpl", this.c.tpl);
    localHashMap.put("appid", this.c.appId);
    if (TextUtils.isEmpty(this.c.clientId)) {
      this.c.clientId = SapiUtils.getClientId(this.c.context);
    }
    if (!TextUtils.isEmpty(this.c.clientId)) {
      localHashMap.put("clientid", this.c.clientId);
    }
    paramString = d.b(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      localHashMap.put("di", paramString);
    }
    localHashMap.put("clientfrom", "mobilesdk_enhanced");
    localHashMap.put("sdk_version", "3");
    return localHashMap;
  }
  
  void a()
  {
    if (this.d != null) {
      this.d.cancelRequests(this.c.context, true);
    }
  }
  
  void a(int paramInt, QrAppLoginCallBack paramQrAppLoginCallBack, String paramString)
  {
    if (paramQrAppLoginCallBack != null) {
      paramQrAppLoginCallBack.onFinish();
    }
    QrAppLoginResponse localQrAppLoginResponse;
    if (paramString != null) {
      localQrAppLoginResponse = new QrAppLoginResponse();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramInt = Integer.parseInt(paramString.optString("errno"));
        localQrAppLoginResponse.errorCode = paramInt;
        JSONObject localJSONObject = paramString.optJSONObject("local");
        if (localJSONObject != null)
        {
          localQrAppLoginResponse.country = localJSONObject.optString("country");
          localQrAppLoginResponse.province = localJSONObject.optString("provice");
          localQrAppLoginResponse.city = localJSONObject.optString("city");
        }
        if ((TextUtils.isEmpty(paramString.optString("errno"))) || (!paramString.optString("errno").equals("0"))) {
          break label195;
        }
        paramString = a(paramString);
        com.baidu.sapi2.share.a.a().a(paramString);
      }
      catch (Exception paramString)
      {
        if (paramQrAppLoginCallBack == null) {
          break;
        }
      }
      paramQrAppLoginCallBack.onSystemError(paramInt);
      return;
      paramQrAppLoginCallBack.onSuccess(localQrAppLoginResponse);
      return;
      paramQrAppLoginCallBack.onSystemError(-100);
      return;
      paramQrAppLoginCallBack.onQrCodeInvalid();
      return;
      paramQrAppLoginCallBack.onBdussInvalid();
      return;
      paramQrAppLoginCallBack.onUserNotNormalized();
      return;
      if (paramQrAppLoginCallBack == null) {
        break;
      }
      paramQrAppLoginCallBack.onSystemError(paramInt);
      return;
      label195:
      if (paramQrAppLoginCallBack == null) {
        break;
      }
      switch (paramInt)
      {
      }
    }
  }
  
  void a(int paramInt, SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    SapiAccountResponse localSapiAccountResponse;
    if (paramString != null) {
      localSapiAccountResponse = new SapiAccountResponse();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localSapiAccountResponse.displayname = paramString.optString("displayname");
        localSapiAccountResponse.uid = paramString.optString("uid");
        localSapiAccountResponse.bduss = paramString.optString("bduss");
        localSapiAccountResponse.ptoken = paramString.optString("ptoken");
        if (paramString.optInt("error_code") == 104)
        {
          c(paramSapiCallBack, paramString.optString("force_reg_token"));
          return;
        }
        if ((!paramString.has("error_code")) && (!paramString.has("error_msg")))
        {
          SapiAccount localSapiAccount = new SapiAccount();
          localSapiAccount.uid = localSapiAccountResponse.uid;
          localSapiAccount.bduss = localSapiAccountResponse.bduss;
          localSapiAccount.displayname = localSapiAccountResponse.displayname;
          localSapiAccount.stoken = localSapiAccountResponse.stoken;
          localSapiAccount.ptoken = localSapiAccountResponse.ptoken;
          localSapiAccount.app = SapiUtils.getAppName(this.c.context);
          if (paramString.has("device_token")) {
            b.a(this.c.context).a(paramString.getString("device_token"));
          }
          com.baidu.sapi2.share.a.a().a(localSapiAccount);
        }
        if (paramSapiCallBack == null) {
          break label303;
        }
        switch (paramString.optInt("error_code"))
        {
        case 0: 
          paramSapiCallBack.onSystemError(paramString.optInt("error_code"));
          return;
        }
      }
      catch (Exception paramString)
      {
        if (paramSapiCallBack == null) {
          break label303;
        }
      }
      paramSapiCallBack.onSystemError(-100);
      return;
      paramSapiCallBack.onSuccess(null);
      return;
      if (paramSapiCallBack != null) {
        paramSapiCallBack.onSystemError(paramInt);
      }
      label303:
      return;
    }
  }
  
  void a(int paramInt, SapiCallBack<SapiAccountResponse> paramSapiCallBack, String paramString, boolean paramBoolean, SapiDataEncryptor paramSapiDataEncryptor)
  {
    SapiAccountResponse localSapiAccountResponse;
    if (paramString != null) {
      localSapiAccountResponse = new SapiAccountResponse();
    }
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString).optString("userinfo");
        paramString = "";
        if (TextUtils.isEmpty(str)) {
          break label240;
        }
        paramString = paramSapiDataEncryptor.a(str);
        paramSapiDataEncryptor = new JSONObject(paramString);
        localSapiAccountResponse.displayname = paramSapiDataEncryptor.optString("displayname");
        localSapiAccountResponse.username = paramSapiDataEncryptor.optString("uname");
        localSapiAccountResponse.uid = paramSapiDataEncryptor.optString("uid");
        localSapiAccountResponse.email = paramSapiDataEncryptor.optString("email");
        localSapiAccountResponse.bduss = paramSapiDataEncryptor.optString("bduss");
        localSapiAccountResponse.ptoken = paramSapiDataEncryptor.optString("ptoken");
        localSapiAccountResponse.stoken = paramSapiDataEncryptor.optString("stoken");
        localSapiAccountResponse.authSid = paramSapiDataEncryptor.optString("authsid");
      }
      catch (Exception paramString)
      {
        L.e(paramString);
        if (paramSapiCallBack == null) {
          break;
        }
      }
      paramSapiCallBack.onSystemError(paramInt);
      return;
      if (paramBoolean)
      {
        paramSapiDataEncryptor = a(localSapiAccountResponse);
        paramSapiDataEncryptor.extra = paramString;
        com.baidu.sapi2.share.a.a().a(paramSapiDataEncryptor);
      }
      paramSapiCallBack.onSuccess(localSapiAccountResponse);
      return;
      paramSapiCallBack.onSystemError(-100);
      return;
      if (paramSapiCallBack == null) {
        break;
      }
      paramSapiCallBack.onSystemError(paramInt);
      return;
      label240:
      if (paramSapiCallBack == null) {
        break;
      }
      switch (paramInt)
      {
      }
    }
  }
  
  void a(final FaceCheckCallback paramFaceCheckCallback, final FaceCheckDTO paramFaceCheckDTO)
  {
    if (paramFaceCheckCallback == null) {
      throw new IllegalArgumentException(FaceCheckCallback.class.getSimpleName() + " can't be null");
    }
    if (paramFaceCheckDTO == null) {
      throw new IllegalArgumentException(FaceCheckDTO.class.getSimpleName() + " can't be empty");
    }
    if ((TextUtils.isEmpty(paramFaceCheckDTO.bduss)) && (TextUtils.isEmpty(paramFaceCheckDTO.account))) {
      throw new IllegalArgumentException("either bduss or account must be assigned");
    }
    final FaceCheckResult localFaceCheckResult = new FaceCheckResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFaceCheckResult.setResultCode(65335);
      paramFaceCheckCallback.onFailure(localFaceCheckResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/getfaceid");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    if (!TextUtils.isEmpty(paramFaceCheckDTO.bduss)) {
      ((Map)localObject).put("bduss", paramFaceCheckDTO.bduss);
    }
    for (;;)
    {
      ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
      localObject = new RequestParams((Map)localObject);
      this.d.post(this.c.context, this.e.a() + "/v2/sapi/getfaceid", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localFaceCheckResult.setResultCode(65334);
            paramFaceCheckCallback.onFailure(localFaceCheckResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramFaceCheckCallback, paramFaceCheckDTO);
        }
        
        protected void onFinish()
        {
          paramFaceCheckCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramFaceCheckCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          boolean bool2 = true;
          a.a(a.this).d();
          paramAnonymousInt = a.this.b(paramAnonymousString);
          localFaceCheckResult.setResultCode(paramAnonymousInt);
          for (;;)
          {
            try
            {
              paramAnonymousString = new JSONObject(paramAnonymousString);
              if (paramAnonymousInt != 0) {
                break label234;
              }
              localFaceCheckResult.faceId = paramAnonymousString.optString("faceid");
              localFaceCheckResult.uid = SapiDataEncryptor.b(localFaceCheckResult.faceId, SapiDataEncryptor.b);
              FaceCheckResult localFaceCheckResult = localFaceCheckResult;
              if (paramAnonymousString.optInt("hasface") != 1) {
                break label293;
              }
              bool1 = true;
              localFaceCheckResult.hasFace = bool1;
              if (!localFaceCheckResult.hasFace)
              {
                paramFaceCheckCallback.onNoRegistered(localFaceCheckResult);
                return;
              }
              localFaceCheckResult = localFaceCheckResult;
              if (paramAnonymousString.optInt("isTrusted") != 0)
              {
                bool1 = bool2;
                localFaceCheckResult.isTrusted = bool1;
                if (!localFaceCheckResult.isTrusted) {
                  break label209;
                }
                localFaceCheckResult.authId = paramAnonymousString.optString("authsid");
                paramFaceCheckCallback.onSuccess(localFaceCheckResult);
                return;
              }
            }
            catch (JSONException paramAnonymousString)
            {
              localFaceCheckResult.setResultCode(65334);
              paramFaceCheckCallback.onFailure(localFaceCheckResult);
              return;
            }
            boolean bool1 = false;
            continue;
            label209:
            localFaceCheckResult.authToken = paramAnonymousString.optString("authtoken");
            paramFaceCheckCallback.onNeedVerify(localFaceCheckResult);
            return;
            label234:
            if (3 == paramAnonymousInt)
            {
              paramFaceCheckCallback.onAccountTypeConflict(localFaceCheckResult);
              return;
            }
            if (1 == paramAnonymousInt)
            {
              paramFaceCheckCallback.onBdussExpired(localFaceCheckResult);
              return;
            }
            localFaceCheckResult.setResultMsg(paramAnonymousString.optString("errmsg"));
            paramFaceCheckCallback.onFailure(localFaceCheckResult);
            return;
            label293:
            bool1 = false;
          }
        }
      });
      return;
      ((Map)localObject).put("username", paramFaceCheckDTO.account);
      if ((paramFaceCheckDTO.accountType == null) || (paramFaceCheckDTO.accountType == FaceCheckDTO.AccountType.MERGE)) {
        ((Map)localObject).put("merge", "1");
      }
      if (paramFaceCheckDTO.accountType == FaceCheckDTO.AccountType.USERNAME) {
        ((Map)localObject).put("isphone", "0");
      }
      if (paramFaceCheckDTO.accountType == FaceCheckDTO.AccountType.PHONE) {
        ((Map)localObject).put("isphone", "1");
      }
    }
  }
  
  void a(final FaceDelCallback paramFaceDelCallback, final FaceDelDTO paramFaceDelDTO)
  {
    if (paramFaceDelCallback == null) {
      throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
    }
    if (paramFaceDelDTO == null) {
      throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceDelDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final FaceDelResult localFaceDelResult = new FaceDelResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFaceDelResult.setResultCode(65335);
      paramFaceDelCallback.onFailure(localFaceDelResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/delface");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    if (!TextUtils.isEmpty(paramFaceDelDTO.bduss)) {
      ((Map)localObject).put("bduss", paramFaceDelDTO.bduss);
    }
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/delface", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localFaceDelResult.setResultCode(65334);
          paramFaceDelCallback.onFailure(localFaceDelResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramFaceDelCallback, paramFaceDelDTO);
      }
      
      protected void onFinish()
      {
        paramFaceDelCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramFaceDelCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localFaceDelResult.setResultCode(paramAnonymousInt);
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          if (paramAnonymousInt == 0)
          {
            paramFaceDelCallback.onSuccess(localFaceDelResult);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramFaceDelCallback.onBdussExpired(localFaceDelResult);
            return;
          }
        }
        catch (JSONException paramAnonymousString)
        {
          localFaceDelResult.setResultCode(65334);
          paramFaceDelCallback.onFailure(localFaceDelResult);
          return;
        }
        localFaceDelResult.setResultMsg(paramAnonymousString.optString("errmsg"));
        paramFaceDelCallback.onFailure(localFaceDelResult);
      }
    });
  }
  
  void a(final FaceLoginCallback paramFaceLoginCallback, final FaceLoginDTO paramFaceLoginDTO)
  {
    if (paramFaceLoginCallback == null) {
      throw new IllegalArgumentException(FaceLoginCallback.class.getSimpleName() + " can't be null");
    }
    if (paramFaceLoginDTO == null) {
      throw new IllegalArgumentException(FaceLoginDTO.class.getSimpleName() + " can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceLoginDTO.faceId)) {
      throw new IllegalArgumentException("face id can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceLoginDTO.authId)) {
      throw new IllegalArgumentException("auth id can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceLoginDTO.facePictureEncoded)) {
      throw new IllegalArgumentException("face picture can't be empty");
    }
    final FaceLoginResult localFaceLoginResult = new FaceLoginResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFaceLoginResult.setResultCode(65335);
      paramFaceLoginCallback.onFailure(localFaceLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/facelogin");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    ((Map)localObject).put("faceid", paramFaceLoginDTO.faceId);
    ((Map)localObject).put("authsid", paramFaceLoginDTO.authId);
    ((Map)localObject).put("facepic", paramFaceLoginDTO.facePictureEncoded);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/facelogin", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localFaceLoginResult.setResultCode(65334);
          paramFaceLoginCallback.onFailure(localFaceLoginResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramFaceLoginCallback, paramFaceLoginDTO);
      }
      
      protected void onFinish()
      {
        paramFaceLoginCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramFaceLoginCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localFaceLoginResult.setResultCode(paramAnonymousInt);
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = a.this.a(paramAnonymousString);
            SapiAccountManager.getInstance().validate(paramAnonymousString);
            paramFaceLoginCallback.onSuccess(localFaceLoginResult);
            return;
          }
          if (4 == paramAnonymousInt)
          {
            paramFaceLoginCallback.onPwdVerifyFailure(localFaceLoginResult);
            return;
          }
        }
        catch (JSONException paramAnonymousString)
        {
          localFaceLoginResult.setResultCode(65334);
          paramFaceLoginCallback.onFailure(localFaceLoginResult);
          return;
        }
        localFaceLoginResult.setResultMsg(paramAnonymousString.optString("errmsg"));
        paramFaceLoginCallback.onFailure(localFaceLoginResult);
      }
    });
  }
  
  void a(final FaceModifyCallback paramFaceModifyCallback, final FaceModifyDTO paramFaceModifyDTO)
  {
    if (paramFaceModifyCallback == null) {
      throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
    }
    if (paramFaceModifyDTO == null) {
      throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceModifyDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceModifyDTO.picturesEncoded)) {
      throw new IllegalArgumentException("face images can't be empty");
    }
    final FaceModifyResult localFaceModifyResult = new FaceModifyResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFaceModifyResult.setResultCode(65335);
      paramFaceModifyCallback.onFailure(localFaceModifyResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/updateface");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    if (!TextUtils.isEmpty(paramFaceModifyDTO.bduss)) {
      ((Map)localObject).put("bduss", paramFaceModifyDTO.bduss);
    }
    ((Map)localObject).put("facepics", paramFaceModifyDTO.picturesEncoded);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/updateface", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localFaceModifyResult.setResultCode(65334);
          paramFaceModifyCallback.onFailure(localFaceModifyResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramFaceModifyCallback, paramFaceModifyDTO);
      }
      
      protected void onFinish()
      {
        paramFaceModifyCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramFaceModifyCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localFaceModifyResult.setResultCode(paramAnonymousInt);
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          if (paramAnonymousInt == 0)
          {
            paramFaceModifyCallback.onSuccess(localFaceModifyResult);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramFaceModifyCallback.onBdussExpired(localFaceModifyResult);
            return;
          }
        }
        catch (JSONException paramAnonymousString)
        {
          localFaceModifyResult.setResultCode(65334);
          paramFaceModifyCallback.onFailure(localFaceModifyResult);
          return;
        }
        localFaceModifyResult.setResultMsg(paramAnonymousString.optString("errmsg"));
        paramFaceModifyCallback.onFailure(localFaceModifyResult);
      }
    });
  }
  
  void a(final FaceRegCallback paramFaceRegCallback, final FaceRegDTO paramFaceRegDTO)
  {
    if (paramFaceRegCallback == null) {
      throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
    }
    if (paramFaceRegDTO == null) {
      throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceRegDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if (TextUtils.isEmpty(paramFaceRegDTO.picturesEncoded)) {
      throw new IllegalArgumentException("face pictures can't be empty");
    }
    final FaceRegResult localFaceRegResult = new FaceRegResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFaceRegResult.setResultCode(65335);
      paramFaceRegCallback.onFailure(localFaceRegResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/regface");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    if (!TextUtils.isEmpty(paramFaceRegDTO.bduss)) {
      ((Map)localObject).put("bduss", paramFaceRegDTO.bduss);
    }
    ((Map)localObject).put("facepics", paramFaceRegDTO.picturesEncoded);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/regface", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localFaceRegResult.setResultCode(65334);
          paramFaceRegCallback.onFailure(localFaceRegResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramFaceRegCallback, paramFaceRegDTO);
      }
      
      protected void onFinish()
      {
        paramFaceRegCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramFaceRegCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localFaceRegResult.setResultCode(paramAnonymousInt);
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          if (paramAnonymousInt == 0)
          {
            paramFaceRegCallback.onSuccess(localFaceRegResult);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramFaceRegCallback.onBdussExpired(localFaceRegResult);
            return;
          }
        }
        catch (JSONException paramAnonymousString)
        {
          localFaceRegResult.setResultCode(65334);
          paramFaceRegCallback.onFailure(localFaceRegResult);
          return;
        }
        localFaceRegResult.setResultMsg(paramAnonymousString.optString("errmsg"));
        paramFaceRegCallback.onFailure(localFaceRegResult);
      }
    });
  }
  
  void a(final FillUserProfileCallback paramFillUserProfileCallback, final String paramString)
  {
    if (paramFillUserProfileCallback == null) {
      throw new IllegalArgumentException(FillUserProfileCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final FillUserProfileResult localFillUserProfileResult = new FillUserProfileResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFillUserProfileResult.setResultCode(65335);
      paramFillUserProfileCallback.onFailure(localFillUserProfileResult);
      return;
    }
    if (!SapiUtils.isSimReady(this.c.context))
    {
      localFillUserProfileResult.setResultCode(-101);
      paramFillUserProfileCallback.onFailure(localFillUserProfileResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    ((Map)localObject).put("bduss", paramString);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/security/sapibindwidgetsend", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        localFillUserProfileResult.setResultCode(65334);
        paramFillUserProfileCallback.onFailure(localFillUserProfileResult);
      }
      
      protected void onFinish()
      {
        paramFillUserProfileCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramFillUserProfileCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, final String paramAnonymousString)
      {
        for (;;)
        {
          try
          {
            localObject1 = new JSONObject(paramAnonymousString);
            paramAnonymousInt = a.this.b(paramAnonymousString);
            localFillUserProfileResult.setResultCode(paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            case 0: 
              paramFillUserProfileCallback.onFailure(localFillUserProfileResult);
              return;
            }
          }
          catch (Throwable paramAnonymousString)
          {
            final Object localObject1;
            Object localObject2;
            boolean bool;
            BasicClientCookie localBasicClientCookie;
            localFillUserProfileResult.setResultCode(65334);
            paramFillUserProfileCallback.onFailure(localFillUserProfileResult);
            return;
          }
          localObject2 = ((JSONObject)localObject1).optString("sms");
          paramAnonymousString = ((JSONObject)localObject1).optString("vcode");
          localObject1 = ((JSONObject)localObject1).optString("upsmschannel");
          bool = false;
          if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", a.b(a.this).context)) {
            bool = SapiUtils.sendSms(a.b(a.this).context, paramAnonymousString, (String)localObject2);
          }
          if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            a.a(a.this, new AsyncHttpClient());
            a.e(a.this).setUserAgent(a.d(a.this));
            localObject2 = new BasicCookieStore();
            localBasicClientCookie = new BasicClientCookie("BAIDUID", SapiUtils.getClientId(a.b(a.this).context));
            localBasicClientCookie.setDomain("baidu.com");
            localBasicClientCookie.setPath("/");
            ((BasicCookieStore)localObject2).addCookie(localBasicClientCookie);
            a.e(a.this).setCookieStore((CookieStore)localObject2);
            localObject2 = new RequestParams();
            ((RequestParams)localObject2).put("channel_id", (String)localObject1);
            ((RequestParams)localObject2).put("callback", "p");
            ((RequestParams)localObject2).put("apiver", "v3");
            ((RequestParams)localObject2).put("tt", String.valueOf(System.currentTimeMillis()));
            a.e(a.this).get(a.b(a.this).context, "https://passport.baidu.com/channel/unicast", (RequestParams)localObject2, new HttpResponseHandler(Looper.getMainLooper())
            {
              protected void onFailure(Throwable paramAnonymous2Throwable, String paramAnonymous2String)
              {
                a.18.this.b.setResultCode(65334);
                a.18.this.a.onFailure(a.18.this.b);
              }
              
              protected void onFinish()
              {
                a.18.this.a.onFinish();
              }
              
              protected void onStart()
              {
                a.18.this.a.onStart();
              }
              
              protected void onSuccess(int paramAnonymous2Int, String paramAnonymous2String)
              {
                if (TextUtils.isEmpty(paramAnonymous2String))
                {
                  a.18.this.b.setResultCode(65334);
                  a.18.this.a.onFailure(a.18.this.b);
                  return;
                }
                paramAnonymous2Int = paramAnonymous2String.indexOf("(");
                int i = paramAnonymous2String.indexOf(")");
                if (paramAnonymous2Int >= 0) {}
                for (;;)
                {
                  try
                  {
                    paramAnonymous2String = paramAnonymous2String.substring(paramAnonymous2Int + 1, i);
                    paramAnonymous2Int = a.this.b(paramAnonymous2String);
                    a.18.this.b.setResultCode(paramAnonymous2Int);
                    switch (paramAnonymous2Int)
                    {
                    case 0: 
                      a.18.this.a.onFailure(a.18.this.b);
                      return;
                    }
                  }
                  catch (Throwable paramAnonymous2String)
                  {
                    L.e(paramAnonymous2String);
                    a.18.this.b.setResultCode(65334);
                    a.18.this.a.onFailure(a.18.this.b);
                    return;
                  }
                  paramAnonymous2String = new HashMap();
                  paramAnonymous2String.put("appid", a.b(a.this).appId);
                  paramAnonymous2String.put("tpl", a.b(a.this).tpl);
                  if (!TextUtils.isEmpty(a.b(a.this).clientId)) {
                    paramAnonymous2String.put("clientid", a.b(a.this).clientId);
                  }
                  paramAnonymous2String.put("upsmschannel", localObject1);
                  paramAnonymous2String.put("bduss", a.18.this.c);
                  paramAnonymous2String.put("vcode", paramAnonymousString);
                  paramAnonymous2String.put("sig", a.a(a.this, paramAnonymous2String, a.b(a.this).appSignKey));
                  a.a(a.this, new AsyncHttpClient());
                  a.e(a.this).setUserAgent(a.d(a.this));
                  a.e(a.this).post(a.b(a.this).context, a.a(a.this).a() + "/v2/security/sapibindwidgetbind", new RequestParams(paramAnonymous2String), new HttpResponseHandler(Looper.getMainLooper())
                  {
                    protected void onFailure(Throwable paramAnonymous3Throwable, String paramAnonymous3String)
                    {
                      a.18.this.b.setResultCode(65334);
                      a.18.this.a.onFailure(a.18.this.b);
                    }
                    
                    protected void onFinish()
                    {
                      a.18.this.a.onFinish();
                    }
                    
                    protected void onStart()
                    {
                      a.18.this.a.onStart();
                    }
                    
                    protected void onSuccess(int paramAnonymous3Int, String paramAnonymous3String)
                    {
                      for (;;)
                      {
                        try
                        {
                          paramAnonymous3Int = a.this.b(paramAnonymous3String);
                          a.18.this.b.setResultCode(paramAnonymous3Int);
                          switch (paramAnonymous3Int)
                          {
                          case 0: 
                            a.18.this.a.onFailure(a.18.this.b);
                            return;
                          }
                        }
                        catch (Throwable paramAnonymous3String)
                        {
                          SapiAccount localSapiAccount;
                          a.18.this.b.setResultCode(65334);
                          a.18.this.a.onFailure(a.18.this.b);
                          return;
                        }
                        localSapiAccount = new SapiAccount();
                        paramAnonymous3String = new JSONObject(paramAnonymous3String);
                        localSapiAccount.displayname = paramAnonymous3String.optString("displayname");
                        localSapiAccount.bduss = paramAnonymous3String.optString("bduss");
                        localSapiAccount.uid = paramAnonymous3String.optString("uid");
                        localSapiAccount.ptoken = paramAnonymous3String.optString("ptoken");
                        localSapiAccount.stoken = paramAnonymous3String.optString("stoken");
                        a.18.this.b.session = localSapiAccount;
                        a.18.this.a.onSuccess(a.18.this.b);
                        return;
                      }
                    }
                  });
                  return;
                  a.18.this.b.setResultCode(65334);
                  a.18.this.a.onFailure(a.18.this.b);
                  return;
                }
              }
            });
            return;
          }
          localFillUserProfileResult.setResultCode(65334);
          paramFillUserProfileCallback.onFailure(localFillUserProfileResult);
          return;
          paramFillUserProfileCallback.onCompleteUser(localFillUserProfileResult);
          return;
          paramFillUserProfileCallback.onBdussExpired(localFillUserProfileResult);
          return;
        }
      }
    });
  }
  
  void a(final FillUsernameCallback paramFillUsernameCallback, final String paramString1, final String paramString2)
  {
    if (paramFillUsernameCallback == null) {
      throw new IllegalArgumentException(FillUsernameCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("username can't be empty");
    }
    final FillUsernameResult localFillUsernameResult = new FillUsernameResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localFillUsernameResult.setResultCode(65335);
      paramFillUsernameCallback.onFailure(localFillUsernameResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    ((Map)localObject).put("cert_id", String.valueOf(1));
    ((Map)localObject).put("crypttype", String.valueOf(6));
    JSONObject localJSONObject = new JSONObject();
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    try
    {
      localJSONObject.put("bduss", paramString1);
      if (!TextUtils.isEmpty(this.c.clientId)) {
        localJSONObject.put("clientid", this.c.clientId);
      }
      if (!TextUtils.isEmpty(this.c.clientIp)) {
        localJSONObject.put("clientip", this.c.clientIp);
      }
      localJSONObject.put("username", paramString2);
      localJSONObject.put("key", localSapiDataEncryptor.a());
      ((Map)localObject).put("userinfo", localSapiDataEncryptor.a("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", localJSONObject.toString()));
      ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
      localObject = new RequestParams((Map)localObject);
      this.d.post(this.c.context, l(), (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localFillUsernameResult.setResultCode(65334);
            paramFillUsernameCallback.onFailure(localFillUsernameResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramFillUsernameCallback, paramString1, paramString2);
        }
        
        protected void onFinish()
        {
          paramFillUsernameCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramFillUsernameCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          paramAnonymousInt = a.this.b(paramAnonymousString);
          localFillUsernameResult.setResultCode(paramAnonymousInt);
          for (;;)
          {
            try
            {
              paramAnonymousString = new JSONObject(paramAnonymousString).optString("userinfo");
              paramAnonymousString = new JSONObject(localSapiDataEncryptor.a(paramAnonymousString));
              switch (paramAnonymousInt)
              {
              case 0: 
                paramFillUsernameCallback.onFailure(localFillUsernameResult);
                return;
              }
            }
            catch (Throwable paramAnonymousString)
            {
              SapiAccount localSapiAccount;
              paramFillUsernameCallback.onFailure(localFillUsernameResult);
              L.e(paramAnonymousString);
              return;
            }
            localSapiAccount = new SapiAccount();
            localSapiAccount.bduss = paramAnonymousString.optString("bduss");
            localSapiAccount.ptoken = paramAnonymousString.optString("ptoken");
            localSapiAccount.stoken = paramAnonymousString.optString("stoken");
            localSapiAccount.displayname = paramAnonymousString.optString("displayname");
            localSapiAccount.username = paramAnonymousString.optString("uname");
            localSapiAccount.uid = paramAnonymousString.optString("uid");
            localSapiAccount.extra = paramAnonymousString.toString();
            com.baidu.sapi2.share.a.a().a(localSapiAccount);
            localFillUsernameResult.session = localSapiAccount;
            paramFillUsernameCallback.onSuccess(localFillUsernameResult);
            return;
            paramFillUsernameCallback.onUserHaveUsername(localFillUsernameResult);
            return;
            paramFillUsernameCallback.onBdussExpired(localFillUsernameResult);
            return;
          }
        }
      });
      return;
    }
    catch (Throwable paramString1)
    {
      localFillUsernameResult.setResultCode(65334);
      paramFillUsernameCallback.onFailure(localFillUsernameResult);
      L.e(paramString1);
    }
  }
  
  void a(final GetDynamicPwdCallback paramGetDynamicPwdCallback, final String paramString1, final String paramString2)
  {
    if (paramGetDynamicPwdCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    final GetDynamicPwdResult localGetDynamicPwdResult = new GetDynamicPwdResult();
    if (TextUtils.isEmpty(paramString1))
    {
      localGetDynamicPwdResult.setResultCode(-101);
      paramGetDynamicPwdCallback.onFailure(localGetDynamicPwdResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localGetDynamicPwdResult.setResultCode(65335);
      paramGetDynamicPwdCallback.onFailure(localGetDynamicPwdResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a("/v2/sapi/getdpass");
    ((Map)localObject).put("username", paramString1);
    ((Map)localObject).put("svcd", "1");
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(paramString2)))
    {
      ((Map)localObject).put("vcodestr", this.f);
      ((Map)localObject).put("vcodesign", this.g);
      ((Map)localObject).put("verifycode", paramString2);
    }
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/getdpass", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localGetDynamicPwdResult.setResultCode(65334);
          paramGetDynamicPwdCallback.onFailure(localGetDynamicPwdResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramGetDynamicPwdCallback, paramString1, paramString2);
      }
      
      protected void onFinish()
      {
        paramGetDynamicPwdCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramGetDynamicPwdCallback.onStart();
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localGetDynamicPwdResult.setResultCode(paramAnonymousInt);
        for (;;)
        {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString).optJSONObject("sdk");
            String str = paramAnonymousString.optString("msg");
            localGetDynamicPwdResult.setResultMsg(str);
            switch (paramAnonymousInt)
            {
            case 0: 
              paramGetDynamicPwdCallback.onFailure(localGetDynamicPwdResult);
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramGetDynamicPwdCallback.onFailure(localGetDynamicPwdResult);
            L.e(paramAnonymousString);
            return;
          }
          paramGetDynamicPwdCallback.onSuccess(localGetDynamicPwdResult);
          return;
          a.a(a.this, paramAnonymousString.optString("vcodestr"));
          a.b(a.this, paramAnonymousString.optString("vcodesign"));
          paramGetDynamicPwdCallback.onCaptchaRequired(localGetDynamicPwdResult);
          return;
        }
      }
    });
  }
  
  void a(final GetHistoryPortraitsCallback paramGetHistoryPortraitsCallback, final GetHistoryPortraitsDTO paramGetHistoryPortraitsDTO)
  {
    if (paramGetHistoryPortraitsCallback == null) {
      throw new IllegalArgumentException("getHistoryPortaits callback can't be null");
    }
    if (paramGetHistoryPortraitsDTO == null) {
      throw new IllegalArgumentException("getHistoryPortrats dto can't be null");
    }
    if (TextUtils.isEmpty(paramGetHistoryPortraitsDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if ((paramGetHistoryPortraitsDTO.maxNum < 0) || (paramGetHistoryPortraitsDTO.maxNum > 10)) {
      throw new IllegalArgumentException("abnormal request history number");
    }
    final GetHistoryPortraitsResult localGetHistoryPortraitsResult = new GetHistoryPortraitsResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localGetHistoryPortraitsResult.setResultCode(65335);
      paramGetHistoryPortraitsCallback.onFailure(localGetHistoryPortraitsResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    ((Map)localObject).put("length", String.valueOf(paramGetHistoryPortraitsDTO.maxNum));
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramGetHistoryPortraitsDTO.bduss);
    String str = a((Map)localObject, this.c.appSignKey);
    RequestParams localRequestParams = new RequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localRequestParams.put("sig", str);
    this.d.post(this.c.context, n(), localRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localGetHistoryPortraitsResult.setResultCode(65334);
          paramGetHistoryPortraitsCallback.onFailure(localGetHistoryPortraitsResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramGetHistoryPortraitsCallback, paramGetHistoryPortraitsDTO);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          paramAnonymousInt = paramAnonymousString.getInt("errno");
          localGetHistoryPortraitsResult.setResultCode(paramAnonymousInt);
          localGetHistoryPortraitsResult.setResultMsg(paramAnonymousString.optString("errmsg"));
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = paramAnonymousString.optJSONArray("history");
            int i = paramAnonymousString.length();
            localGetHistoryPortraitsResult.historyPortraits = new ArrayList(i);
            paramAnonymousInt = 0;
            while (paramAnonymousInt < i)
            {
              localGetHistoryPortraitsResult.historyPortraits.add(paramAnonymousString.optString(paramAnonymousInt));
              paramAnonymousInt += 1;
            }
            paramGetHistoryPortraitsCallback.onSuccess(localGetHistoryPortraitsResult);
            return;
          }
          paramGetHistoryPortraitsCallback.onFailure(localGetHistoryPortraitsResult);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          localGetHistoryPortraitsResult.setResultCode(65334);
          paramGetHistoryPortraitsCallback.onFailure(localGetHistoryPortraitsResult);
          L.e(paramAnonymousString);
        }
      }
    });
  }
  
  void a(final GetPopularPortraitsCallback paramGetPopularPortraitsCallback, final String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("bduss can't be empty nor null");
    }
    final GetPopularPortraitsInfoResult localGetPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localGetPopularPortraitsInfoResult.setResultCode(65335);
      paramGetPopularPortraitsCallback.onFailure(localGetPopularPortraitsInfoResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("bduss", paramString);
    RequestParams localRequestParams = new RequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    this.d.post(this.c.context, p(), localRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localGetPopularPortraitsInfoResult.setResultCode(65334);
          paramGetPopularPortraitsCallback.onFailure(localGetPopularPortraitsInfoResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramGetPopularPortraitsCallback, paramString);
      }
      
      public void onFinish()
      {
        paramGetPopularPortraitsCallback.onFinish();
      }
      
      public void onStart()
      {
        paramGetPopularPortraitsCallback.onStart();
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        for (;;)
        {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            paramAnonymousInt = paramAnonymousString.optInt("errno");
            localGetPopularPortraitsInfoResult.setResultCode(paramAnonymousInt);
            localGetPopularPortraitsInfoResult.setResultMsg(paramAnonymousString.optString("errmsg"));
            if (paramAnonymousInt == 0)
            {
              paramAnonymousString = paramAnonymousString.optJSONArray("list");
              int i = paramAnonymousString.length();
              localGetPopularPortraitsInfoResult.popularPortraitsInfoList = new ArrayList(i);
              paramAnonymousInt = 0;
              if (paramAnonymousInt < i)
              {
                JSONObject localJSONObject = paramAnonymousString.optJSONObject(paramAnonymousInt);
                if (localJSONObject != null)
                {
                  GetPopularPortraitsInfoResult.PopularPortraitsInfo localPopularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                  localPopularPortraitsInfo.num = localJSONObject.optInt("num");
                  localPopularPortraitsInfo.series = localJSONObject.optString("serie");
                  localPopularPortraitsInfo.url = localJSONObject.optString("url");
                  localPopularPortraitsInfo.myItem = localJSONObject.optInt("myitem");
                  localGetPopularPortraitsInfoResult.popularPortraitsInfoList.add(localPopularPortraitsInfo);
                }
              }
              else
              {
                paramGetPopularPortraitsCallback.onSuccess(localGetPopularPortraitsInfoResult);
              }
            }
            else
            {
              paramGetPopularPortraitsCallback.onFailure(localGetPopularPortraitsInfoResult);
              return;
            }
          }
          catch (JSONException paramAnonymousString)
          {
            localGetPopularPortraitsInfoResult.setResultCode(65334);
            paramGetPopularPortraitsCallback.onFailure(localGetPopularPortraitsInfoResult);
            L.e(paramAnonymousString);
            return;
          }
          paramAnonymousInt += 1;
        }
      }
    });
  }
  
  void a(final GetRegCodeCallback paramGetRegCodeCallback, final String paramString)
  {
    if (paramGetRegCodeCallback == null) {
      throw new IllegalArgumentException(GetRegCodeCallback.class.getSimpleName() + " can't be null");
    }
    final GetRegCodeResult localGetRegCodeResult = new GetRegCodeResult();
    if (TextUtils.isEmpty(paramString))
    {
      localGetRegCodeResult.setResultCode(-101);
      paramGetRegCodeCallback.onFailure(localGetRegCodeResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localGetRegCodeResult.setResultCode(65335);
      paramGetRegCodeCallback.onFailure(localGetRegCodeResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a("/v2/sapi/applyregcode");
    ((Map)localObject).put("phonenum", paramString);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/applyregcode", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localGetRegCodeResult.setResultCode(65334);
          paramGetRegCodeCallback.onFailure(localGetRegCodeResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramGetRegCodeCallback, paramString);
      }
      
      protected void onFinish()
      {
        paramGetRegCodeCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramGetRegCodeCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localGetRegCodeResult.setResultCode(paramAnonymousInt);
        for (;;)
        {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString).optJSONObject("sdk").optString("msg");
            localGetRegCodeResult.setResultMsg(paramAnonymousString);
            switch (paramAnonymousInt)
            {
            case 0: 
              paramGetRegCodeCallback.onFailure(localGetRegCodeResult);
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramGetRegCodeCallback.onFailure(localGetRegCodeResult);
            L.e(paramAnonymousString);
            return;
          }
          paramGetRegCodeCallback.onSuccess(localGetRegCodeResult);
          return;
          paramGetRegCodeCallback.onPhoneNumberExist(localGetRegCodeResult);
          return;
        }
      }
    });
  }
  
  void a(final GetUserInfoCallback paramGetUserInfoCallback, final String paramString)
  {
    if (paramGetUserInfoCallback == null) {
      throw new IllegalArgumentException(GetUserInfoCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final GetUserInfoResult localGetUserInfoResult = new GetUserInfoResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localGetUserInfoResult.setResultCode(65335);
      paramGetUserInfoCallback.onFailure(localGetUserInfoResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramString);
    String str = a((Map)localObject, this.c.appSignKey);
    RequestParams localRequestParams = new RequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localRequestParams.put("sig", str);
    this.d.post(this.c.context, o(), localRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localGetUserInfoResult.setResultCode(65334);
          paramGetUserInfoCallback.onFailure(localGetUserInfoResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramGetUserInfoCallback, paramString);
      }
      
      protected void onFinish()
      {
        paramGetUserInfoCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramGetUserInfoCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localGetUserInfoResult.setResultCode(paramAnonymousInt);
        switch (paramAnonymousInt)
        {
        default: 
          paramGetUserInfoCallback.onFailure(localGetUserInfoResult);
          return;
        case 0: 
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            localGetUserInfoResult.portraitSign = paramAnonymousString.optString("portrait_tag");
            localGetUserInfoResult.isInitialPortrait = "0".equals(localGetUserInfoResult.portraitSign);
            String str = paramAnonymousString.optString("portrait");
            if (!TextUtils.isEmpty(str)) {
              localGetUserInfoResult.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", new Object[] { str, localGetUserInfoResult.portraitSign });
            }
            localGetUserInfoResult.username = paramAnonymousString.optString("username");
            localGetUserInfoResult.uid = paramAnonymousString.optString("userid");
            localGetUserInfoResult.displayname = paramAnonymousString.optString("displayname");
            localGetUserInfoResult.incompleteUser = "1".equals(paramAnonymousString.optString("incomplete_user"));
            localGetUserInfoResult.secureMobile = paramAnonymousString.optString("securemobil");
            localGetUserInfoResult.secureEmail = paramAnonymousString.optString("secureemail");
            localGetUserInfoResult.havePwd = "1".equals(paramAnonymousString.optString("have_psw"));
            paramGetUserInfoCallback.onSuccess(localGetUserInfoResult);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            paramGetUserInfoCallback.onFailure(localGetUserInfoResult);
            L.e(paramAnonymousString);
            return;
          }
        }
        paramGetUserInfoCallback.onBdussExpired(localGetUserInfoResult);
      }
    });
  }
  
  void a(final IqiyiLoginCallback paramIqiyiLoginCallback, final IqiyiLoginDTO paramIqiyiLoginDTO)
  {
    if (paramIqiyiLoginCallback == null) {
      return;
    }
    paramIqiyiLoginCallback.onStart();
    String str1 = paramIqiyiLoginDTO.accessToken;
    final String str2 = paramIqiyiLoginDTO.phoneNum;
    String str3 = paramIqiyiLoginDTO.openID;
    final IqiyiLoginResult localIqiyiLoginResult = new IqiyiLoginResult();
    SapiAccount localSapiAccount = SapiAccountManager.getInstance().getSession();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3))) {}
    for (int i = 1; (i == 0) && (localSapiAccount == null); i = 0)
    {
      paramIqiyiLoginCallback.onLogin(localIqiyiLoginResult);
      return;
    }
    if ((i != 0) && (localSapiAccount == null))
    {
      a(paramIqiyiLoginCallback, paramIqiyiLoginDTO, localIqiyiLoginResult);
      return;
    }
    SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback()
    {
      public void a(GetUserInfoResult paramAnonymousGetUserInfoResult)
      {
        a.a(a.this, paramIqiyiLoginCallback, paramIqiyiLoginDTO, localIqiyiLoginResult);
      }
      
      public void b(GetUserInfoResult paramAnonymousGetUserInfoResult)
      {
        String str = paramAnonymousGetUserInfoResult.secureMobile;
        boolean bool = paramAnonymousGetUserInfoResult.incompleteUser;
        if (TextUtils.isEmpty(str))
        {
          if (bool)
          {
            a.a(a.this, paramIqiyiLoginCallback, paramIqiyiLoginDTO, localIqiyiLoginResult);
            return;
          }
          if (TextUtils.isEmpty(str2))
          {
            paramIqiyiLoginCallback.onSuccess(localIqiyiLoginResult);
            return;
          }
          a.a(a.this, paramIqiyiLoginCallback, paramIqiyiLoginDTO, localIqiyiLoginResult);
          return;
        }
        paramIqiyiLoginCallback.onSuccess(localIqiyiLoginResult);
      }
      
      public void c(GetUserInfoResult paramAnonymousGetUserInfoResult)
      {
        localIqiyiLoginResult.setResultCode(paramAnonymousGetUserInfoResult.getResultCode());
        localIqiyiLoginResult.setResultMsg(paramAnonymousGetUserInfoResult.getResultMsg());
        paramIqiyiLoginCallback.onFailure(localIqiyiLoginResult);
      }
      
      public void onFinish() {}
      
      public void onStart() {}
    }, localSapiAccount.bduss);
  }
  
  void a(final LoginCallback paramLoginCallback, final LoginDTO paramLoginDTO)
  {
    if (paramLoginCallback == null) {
      throw new IllegalArgumentException(LoginCallback.class.getSimpleName() + " can't be null");
    }
    if (paramLoginDTO == null) {
      throw new IllegalArgumentException(LoginDTO.class.getSimpleName() + " can't be null");
    }
    final LoginResult localLoginResult = new LoginResult();
    if (TextUtils.isEmpty(paramLoginDTO.account))
    {
      localLoginResult.setResultCode(-101);
      paramLoginCallback.onFailure(localLoginResult);
      return;
    }
    if (TextUtils.isEmpty(paramLoginDTO.password))
    {
      localLoginResult.setResultCode(-102);
      paramLoginCallback.onFailure(localLoginResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localLoginResult.setResultCode(65335);
      paramLoginCallback.onFailure(localLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a("/v2/sapi/login");
    ((Map)localObject).put("crypttype", String.valueOf(6));
    ((Map)localObject).put("cert_id", String.valueOf(1));
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(paramLoginDTO.captcha)))
    {
      ((Map)localObject).put("verifycode", paramLoginDTO.captcha);
      ((Map)localObject).put("vcodestr", this.f);
    }
    if (this.c.quickUserEnabled) {
      ((Map)localObject).put("quick_user", "1");
    }
    if ((paramLoginDTO.loginType == null) || (paramLoginDTO.loginType == LoginDTO.LoginType.MERGE)) {
      ((Map)localObject).put("loginmerge", "true");
    }
    if (paramLoginDTO.loginType == LoginDTO.LoginType.USERNAME) {
      ((Map)localObject).put("isphone", "0");
    }
    if (paramLoginDTO.loginType == LoginDTO.LoginType.PHONE) {
      ((Map)localObject).put("isphone", "1");
    }
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("username", paramLoginDTO.account);
      localJSONObject.put("password", paramLoginDTO.password);
      localJSONObject.put("login_type", "3");
      localJSONObject.put("key", localSapiDataEncryptor.a());
      ((Map)localObject).put("userinfo", localSapiDataEncryptor.a("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", localJSONObject.toString()));
      ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
      localObject = new RequestParams((Map)localObject);
      this.d.post(this.c.context, r(), (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localLoginResult.setResultCode(65334);
            paramLoginCallback.onFailure(localLoginResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramLoginCallback, paramLoginDTO);
        }
        
        protected void onFinish()
        {
          paramLoginCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramLoginCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          int i = a.this.b(paramAnonymousString);
          localLoginResult.setResultCode(i);
          for (;;)
          {
            Object localObject1;
            Object localObject2;
            try
            {
              paramAnonymousString = new JSONObject(paramAnonymousString).optString("userinfo");
              paramAnonymousString = new JSONObject(localSapiDataEncryptor.a(paramAnonymousString));
              localObject1 = paramAnonymousString.optJSONObject("sdk");
              localObject2 = ((JSONObject)localObject1).optString("msg");
              localLoginResult.setResultMsg((String)localObject2);
              localObject2 = new SapiResult.Action();
              ((SapiResult.Action)localObject2).actionMode = SapiResult.ActionMode.fromString(((JSONObject)localObject1).optString("action"));
              ((SapiResult.Action)localObject2).actionType = SapiResult.ActionType.fromString(((JSONObject)localObject1).optString("type"));
              ((SapiResult.Action)localObject2).actionTitle = ((JSONObject)localObject1).optString("title");
              ((SapiResult.Action)localObject2).actionUrl = ((JSONObject)localObject1).optString("url");
              localLoginResult.action = ((SapiResult.Action)localObject2);
              if (paramAnonymousString.optInt("needvcode") != 1) {
                break label433;
              }
              paramAnonymousInt = 1;
              if (paramAnonymousInt != 0)
              {
                a.a(a.this, paramAnonymousString.optString("vcodestr"));
                paramLoginCallback.onCaptchaRequired(localLoginResult);
              }
              switch (a.51.a[localObject2.actionMode.ordinal()])
              {
              case 1: 
                paramLoginCallback.onFailure(localLoginResult);
                return;
              }
            }
            catch (Exception paramAnonymousString)
            {
              paramLoginCallback.onFailure(localLoginResult);
              L.e(paramAnonymousString);
              return;
            }
            a.a(a.this, paramLoginDTO);
            paramLoginCallback.onProxyActionRequired(localLoginResult);
            return;
            if (i == 0)
            {
              localObject1 = a.this.a(paramAnonymousString);
              localObject2 = new SapiAccount.ReloginCredentials();
              ((SapiAccount.ReloginCredentials)localObject2).account = paramLoginDTO.account;
              ((SapiAccount.ReloginCredentials)localObject2).accountType = paramAnonymousString.optString("logintype");
              ((SapiAccount.ReloginCredentials)localObject2).password = SapiDataEncryptor.encryptPwd(paramLoginDTO.password);
              ((SapiAccount.ReloginCredentials)localObject2).ubi = paramAnonymousString.optString("ubi");
              b.a(a.b(a.this).context).a(((SapiAccount)localObject1).uid, (SapiAccount.ReloginCredentials)localObject2);
              com.baidu.sapi2.share.a.a().a((SapiAccount)localObject1);
              paramLoginCallback.onSuccess(localLoginResult);
              return;
            }
            if (i == 18)
            {
              paramLoginCallback.onLoginTypeConflict(localLoginResult);
              return;
            }
            paramLoginCallback.onFailure(localLoginResult);
            return;
            continue;
            label433:
            paramAnonymousInt = 0;
          }
        }
      });
      return;
    }
    catch (Exception paramLoginDTO)
    {
      localLoginResult.setResultCode(65334);
      paramLoginCallback.onFailure(localLoginResult);
      L.e(paramLoginDTO);
    }
  }
  
  void a(final QrPcLoginCallback paramQrPcLoginCallback, final String paramString1, final String paramString2, final String paramString3)
  {
    if (paramQrPcLoginCallback == null) {
      throw new IllegalArgumentException(QrPcLoginCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("sign can't be empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("cmd can't be empty");
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final QrPcLoginResult localQrPcLoginResult = new QrPcLoginResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localQrPcLoginResult.setResultCode(65335);
      paramQrPcLoginCallback.onFailure(localQrPcLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("sign", paramString1);
    ((Map)localObject).put("cmd", paramString2);
    ((Map)localObject).put("bduss", paramString3);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("tpl", this.c.tpl);
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/qrlogin?lp=pc", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localQrPcLoginResult.setResultCode(65334);
          paramQrPcLoginCallback.onFailure(localQrPcLoginResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramQrPcLoginCallback, paramString1, paramString2, paramString3);
      }
      
      protected void onFinish()
      {
        paramQrPcLoginCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramQrPcLoginCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        for (;;)
        {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            paramAnonymousInt = Integer.parseInt(paramAnonymousString.optString("errno"));
            localQrPcLoginResult.setResultCode(paramAnonymousInt);
            switch (localQrPcLoginResult.getResultCode())
            {
            case 0: 
              paramQrPcLoginCallback.onFailure(localQrPcLoginResult);
              return;
            }
          }
          catch (Throwable paramAnonymousString)
          {
            paramQrPcLoginCallback.onFailure(localQrPcLoginResult);
            L.e(paramAnonymousString);
            return;
          }
          paramAnonymousString = paramAnonymousString.optJSONObject("local");
          if (paramAnonymousString != null)
          {
            localQrPcLoginResult.country = paramAnonymousString.optString("country");
            localQrPcLoginResult.province = paramAnonymousString.optString("provice");
            localQrPcLoginResult.city = paramAnonymousString.optString("city");
          }
          paramQrPcLoginCallback.onSuccess(localQrPcLoginResult);
          return;
          paramQrPcLoginCallback.onIncompleteUser(localQrPcLoginResult);
          return;
          paramQrPcLoginCallback.onBdussExpired(localQrPcLoginResult);
          return;
        }
      }
    });
  }
  
  void a(final QuickUserRegCallback paramQuickUserRegCallback, final QuickUserRegDTO paramQuickUserRegDTO)
  {
    if (!this.c.quickUserEnabled) {
      throw new IllegalStateException("quick user not enabled");
    }
    if (paramQuickUserRegCallback == null) {
      throw new IllegalArgumentException(QuickUserRegCallback.class.getSimpleName() + " can't be null");
    }
    if (paramQuickUserRegDTO == null) {
      throw new IllegalArgumentException(QuickUserRegDTO.class.getSimpleName() + " can't be null");
    }
    final QuickUserRegResult localQuickUserRegResult = new QuickUserRegResult();
    if (TextUtils.isEmpty(paramQuickUserRegDTO.username))
    {
      localQuickUserRegResult.setResultCode(-101);
      paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
      return;
    }
    if (TextUtils.isEmpty(paramQuickUserRegDTO.password))
    {
      localQuickUserRegResult.setResultCode(-102);
      paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localQuickUserRegResult.setResultCode(65335);
      paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a("/v2/sapi/reg/quick");
    ((Map)localObject).put("crypttype", String.valueOf(6));
    ((Map)localObject).put("cert_id", String.valueOf(1));
    if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(paramQuickUserRegDTO.captcha)))
    {
      ((Map)localObject).put("verifycode", paramQuickUserRegDTO.captcha);
      ((Map)localObject).put("vcodestr", this.f);
    }
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("username", paramQuickUserRegDTO.username);
      localJSONObject.put("loginpass", paramQuickUserRegDTO.password);
      localJSONObject.put("key", localSapiDataEncryptor.a());
      ((Map)localObject).put("userinfo", localSapiDataEncryptor.a("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", localJSONObject.toString()));
      ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
      localObject = new RequestParams((Map)localObject);
      this.d.post(this.c.context, this.e.a() + "/v2/sapi/reg/quick", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localQuickUserRegResult.setResultCode(65334);
            paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramQuickUserRegCallback, paramQuickUserRegDTO);
        }
        
        protected void onFinish()
        {
          paramQuickUserRegCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramQuickUserRegCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          int i = a.this.b(paramAnonymousString);
          localQuickUserRegResult.setResultCode(i);
          for (;;)
          {
            try
            {
              paramAnonymousString = new JSONObject(paramAnonymousString).optString("userinfo");
              paramAnonymousString = new JSONObject(localSapiDataEncryptor.a(paramAnonymousString));
              localObject = paramAnonymousString.optJSONObject("sdk").optString("msg");
              localQuickUserRegResult.setResultMsg((String)localObject);
              if (paramAnonymousString.optInt("needvcode") != 1) {
                break label351;
              }
              paramAnonymousInt = 1;
              if (paramAnonymousInt == 0) {
                break label321;
              }
              a.a(a.this, paramAnonymousString.optString("vcodestr"));
              paramQuickUserRegCallback.onCaptchaRequired(localQuickUserRegResult);
            }
            catch (Exception paramAnonymousString)
            {
              Object localObject;
              SapiAccount.ReloginCredentials localReloginCredentials;
              paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
              L.e(paramAnonymousString);
              return;
            }
            paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
            return;
            localObject = a.this.a(paramAnonymousString);
            localReloginCredentials = new SapiAccount.ReloginCredentials();
            localReloginCredentials.account = paramQuickUserRegDTO.username;
            localReloginCredentials.accountType = paramAnonymousString.optString("logintype");
            localReloginCredentials.password = SapiDataEncryptor.encryptPwd(paramQuickUserRegDTO.password);
            localReloginCredentials.ubi = paramAnonymousString.optString("ubi");
            b.a(a.b(a.this).context).a(((SapiAccount)localObject).uid, localReloginCredentials);
            com.baidu.sapi2.share.a.a().a((SapiAccount)localObject);
            paramQuickUserRegCallback.onSuccess(localQuickUserRegResult);
            return;
            paramAnonymousString = paramAnonymousString.optJSONArray("suggnames");
            if (paramAnonymousString != null)
            {
              paramAnonymousInt = 0;
              while (paramAnonymousInt < paramAnonymousString.length())
              {
                localQuickUserRegResult.sugUsernameList.add(paramAnonymousString.optString(paramAnonymousInt));
                paramAnonymousInt += 1;
              }
            }
            paramQuickUserRegCallback.onUsernameExist(localQuickUserRegResult);
            return;
            label321:
            switch (i)
            {
            }
            continue;
            label351:
            paramAnonymousInt = 0;
          }
        }
      });
      return;
    }
    catch (Exception paramQuickUserRegDTO)
    {
      localQuickUserRegResult.setResultCode(65334);
      paramQuickUserRegCallback.onFailure(localQuickUserRegResult);
      L.e(paramQuickUserRegDTO);
    }
  }
  
  public void a(final SSOConfirmCallback paramSSOConfirmCallback, final SSOConfirmDTO paramSSOConfirmDTO)
  {
    if (paramSSOConfirmCallback == null) {
      throw new IllegalArgumentException(SSOConfirmCallback.class.getSimpleName() + " can't be null");
    }
    if (paramSSOConfirmDTO == null) {
      throw new IllegalArgumentException(SSOConfirmDTO.class.getSimpleName() + "can't be null");
    }
    if (TextUtils.isEmpty(paramSSOConfirmDTO.channelID)) {
      throw new IllegalArgumentException("channel id can't be empty");
    }
    if (TextUtils.isEmpty(paramSSOConfirmDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final SSOConfirmResult localSSOConfirmResult = new SSOConfirmResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localSSOConfirmResult.setResultCode(65335);
      paramSSOConfirmCallback.onFailure(localSSOConfirmResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Map localMap = a("/v2/sapi/setssochannelinfo");
    if (!TextUtils.isEmpty(this.c.clientId)) {
      localMap.put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      localMap.put("clientip", this.c.clientIp);
    }
    localMap.put("channel_id", paramSSOConfirmDTO.channelID);
    localMap.put("bduss", paramSSOConfirmDTO.bduss);
    if (paramSSOConfirmDTO.authorized) {}
    for (Object localObject = "0";; localObject = "1")
    {
      localMap.put("refuse", localObject);
      localMap.put("sig", a(localMap, this.c.appSignKey));
      localObject = new RequestParams(localMap);
      this.d.post(this.c.context, this.e.a() + "/v2/sapi/setssochannelinfo", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localSSOConfirmResult.setResultCode(65334);
            paramSSOConfirmCallback.onFailure(localSSOConfirmResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramSSOConfirmCallback, paramSSOConfirmDTO);
        }
        
        protected void onFinish()
        {
          paramSSOConfirmCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramSSOConfirmCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          try
          {
            paramAnonymousInt = a.this.b(paramAnonymousString);
            localSSOConfirmResult.setResultCode(paramAnonymousInt);
            if (paramAnonymousInt == 0)
            {
              paramSSOConfirmCallback.onSuccess(localSSOConfirmResult);
              return;
            }
            paramSSOConfirmCallback.onFailure(localSSOConfirmResult);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            localSSOConfirmResult.setResultCode(65334);
            paramSSOConfirmCallback.onFailure(localSSOConfirmResult);
            L.e(paramAnonymousString);
          }
        }
      });
      return;
    }
  }
  
  void a(final SapiCallback<GetCaptchaResult> paramSapiCallback)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(this.f)) {
      throw new IllegalArgumentException("captchaKey can't be empty");
    }
    final GetCaptchaResult localGetCaptchaResult = new GetCaptchaResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localGetCaptchaResult.setResultCode(65335);
      paramSapiCallback.onFailure(localGetCaptchaResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    this.d.get(this.c.context, this.e.a() + "/cgi-bin/genimage?" + this.f, new BinaryHttpResponseHandler(Looper.getMainLooper(), new String[] { "image/png", "image/jpeg", "image/jpg", "image/gif" })
    {
      protected void onFailure(Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localGetCaptchaResult.setResultCode(65334);
          paramSapiCallback.onFailure(localGetCaptchaResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramSapiCallback);
      }
      
      protected void onFinish()
      {
        paramSapiCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramSapiCallback.onStart();
      }
      
      protected void onSuccess(byte[] paramAnonymousArrayOfByte)
      {
        a.a(a.this).d();
        if (paramAnonymousArrayOfByte != null)
        {
          localGetCaptchaResult.setResultCode(0);
          localGetCaptchaResult.captchaImage = paramAnonymousArrayOfByte;
          paramSapiCallback.onSuccess(localGetCaptchaResult);
          return;
        }
        localGetCaptchaResult.setResultCode(65334);
        paramSapiCallback.onFailure(localGetCaptchaResult);
      }
    });
  }
  
  void a(SapiCallback<FastRegResult> paramSapiCallback, int paramInt)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    Object localObject2 = new FastRegResult();
    if ((paramInt < 10) || (paramInt > 90)) {
      throw new IllegalArgumentException("timeoutSeconds must between 10 and 90");
    }
    if (!SapiUtils.isSimReady(this.c.context))
    {
      ((FastRegResult)localObject2).setResultCode(-101);
      paramSapiCallback.onFailure((SapiResult)localObject2);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      ((FastRegResult)localObject2).setResultCode(65335);
      paramSapiCallback.onFailure((SapiResult)localObject2);
      return;
    }
    final boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    Object localObject1 = UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + "," + "点击发送直接登录";
    final Handler local41 = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        arrayOfBoolean[0] = true;
      }
    };
    Runnable local42 = new Runnable()
    {
      public void run()
      {
        Message.obtain(local41, 1001).sendToTarget();
      }
    };
    boolean bool = false;
    if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.c.context)) {
      bool = SapiUtils.sendSms(this.c.context, (String)localObject1, SapiUtils.getFastRegChannel(this.c.context));
    }
    if (bool)
    {
      this.d = new AsyncHttpClient();
      this.d.setUserAgent(x());
      localObject2 = a("/v2/sapi/smsgetlogin");
      ((Map)localObject2).put("sms", localObject1);
      ((Map)localObject2).put("sig", a((Map)localObject2, this.c.appSignKey));
      localObject1 = new RequestParams((Map)localObject2);
      local41.postDelayed(local42, paramInt * 1000);
      paramSapiCallback.onStart();
      a(paramSapiCallback, (RequestParams)localObject1, local41, local42, arrayOfBoolean);
      return;
    }
    ((FastRegResult)localObject2).setResultCode(-102);
    paramSapiCallback.onFailure((SapiResult)localObject2);
  }
  
  void a(final SapiCallback<PhoneRegResult> paramSapiCallback, final PhoneRegDTO paramPhoneRegDTO)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (paramPhoneRegDTO == null) {
      throw new IllegalArgumentException(PhoneRegDTO.class.getSimpleName() + " can't be null");
    }
    final PhoneRegResult localPhoneRegResult = new PhoneRegResult();
    if (TextUtils.isEmpty(paramPhoneRegDTO.phoneNumber))
    {
      localPhoneRegResult.setResultCode(-101);
      paramSapiCallback.onFailure(localPhoneRegResult);
      return;
    }
    if ((TextUtils.isEmpty(paramPhoneRegDTO.password)) && (!paramPhoneRegDTO.noPwd))
    {
      localPhoneRegResult.setResultCode(-102);
      paramSapiCallback.onFailure(localPhoneRegResult);
      return;
    }
    if (TextUtils.isEmpty(paramPhoneRegDTO.regCode))
    {
      localPhoneRegResult.setResultCode(-103);
      paramSapiCallback.onFailure(localPhoneRegResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localPhoneRegResult.setResultCode(65335);
      paramSapiCallback.onFailure(localPhoneRegResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Map localMap = a("/v2/sapi/phoneregverify");
    localMap.put("crypttype", String.valueOf(6));
    localMap.put("cert_id", String.valueOf(1));
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("phonenum", paramPhoneRegDTO.phoneNumber);
        if (!paramPhoneRegDTO.noPwd) {
          ((JSONObject)localObject).put("passwd", paramPhoneRegDTO.password);
        }
        ((JSONObject)localObject).put("smscode", paramPhoneRegDTO.regCode);
        ((JSONObject)localObject).put("key", localSapiDataEncryptor.a());
        localMap.put("userinfo", localSapiDataEncryptor.a("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", ((JSONObject)localObject).toString()));
        if (paramPhoneRegDTO.noPwd)
        {
          localObject = "1";
          localMap.put("nopsw", localObject);
          localMap.put("sig", a(localMap, this.c.appSignKey));
          localObject = new RequestParams(localMap);
          this.d.post(this.c.context, this.e.a() + "/v2/sapi/phoneregverify", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
          {
            protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
            {
              if (a.a(a.this).c())
              {
                a.a(a.this).d();
                localPhoneRegResult.setResultCode(65334);
                paramSapiCallback.onFailure(localPhoneRegResult);
                return;
              }
              a.a(a.this).b();
              a.this.a(paramSapiCallback, paramPhoneRegDTO);
            }
            
            protected void onFinish()
            {
              paramSapiCallback.onFinish();
            }
            
            protected void onStart()
            {
              paramSapiCallback.onStart();
            }
            
            protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
            {
              a.a(a.this).d();
              paramAnonymousInt = a.this.b(paramAnonymousString);
              localPhoneRegResult.setResultCode(paramAnonymousInt);
              for (;;)
              {
                try
                {
                  paramAnonymousString = new JSONObject(paramAnonymousString).optString("userinfo");
                  paramAnonymousString = new JSONObject(localSapiDataEncryptor.a(paramAnonymousString));
                  localObject = paramAnonymousString.optJSONObject("sdk").optString("msg");
                  localPhoneRegResult.setResultMsg((String)localObject);
                  switch (paramAnonymousInt)
                  {
                  case 0: 
                    paramSapiCallback.onFailure(localPhoneRegResult);
                    return;
                  }
                }
                catch (Exception paramAnonymousString)
                {
                  Object localObject;
                  SapiAccount.ReloginCredentials localReloginCredentials;
                  paramSapiCallback.onFailure(localPhoneRegResult);
                  L.e(paramAnonymousString);
                  return;
                }
                localObject = a.this.a(paramAnonymousString);
                localReloginCredentials = new SapiAccount.ReloginCredentials();
                localReloginCredentials.account = paramPhoneRegDTO.phoneNumber;
                localReloginCredentials.accountType = paramAnonymousString.optString("logintype");
                localReloginCredentials.password = SapiDataEncryptor.encryptPwd(paramPhoneRegDTO.password);
                localReloginCredentials.ubi = paramAnonymousString.optString("ubi");
                b.a(a.b(a.this).context).a(((SapiAccount)localObject).uid, localReloginCredentials);
                com.baidu.sapi2.share.a.a().a((SapiAccount)localObject);
                paramSapiCallback.onSuccess(localPhoneRegResult);
                return;
              }
            }
          });
          return;
        }
      }
      catch (Exception paramPhoneRegDTO)
      {
        localPhoneRegResult.setResultCode(65334);
        paramSapiCallback.onFailure(localPhoneRegResult);
        L.e(paramPhoneRegDTO);
        return;
      }
      Object localObject = "0";
    }
  }
  
  void a(final SapiCallback<ReloginResult> paramSapiCallback, final ReloginDTO paramReloginDTO)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (paramReloginDTO == null) {
      throw new IllegalArgumentException(ReloginDTO.class.getSimpleName() + " can't be null");
    }
    final ReloginResult localReloginResult = new ReloginResult();
    if (TextUtils.isEmpty(paramReloginDTO.bduss))
    {
      localReloginResult.setResultCode(-101);
      paramSapiCallback.onFailure(localReloginResult);
      return;
    }
    if (TextUtils.isEmpty(paramReloginDTO.password))
    {
      localReloginResult.setResultCode(-102);
      paramSapiCallback.onFailure(localReloginResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localReloginResult.setResultCode(65335);
      paramSapiCallback.onFailure(localReloginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a("/v5/login/sapi/relogin");
    ((Map)localObject).put("crypttype", String.valueOf(6));
    ((Map)localObject).put("cert_id", String.valueOf(1));
    ((Map)localObject).put("bduss", paramReloginDTO.bduss);
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (paramReloginDTO.getPasswordType() == ReloginDTO.PasswordType.PLAIN)
        {
          localJSONObject.put("password", SapiDataEncryptor.encryptPwd(paramReloginDTO.password));
          localJSONObject.put("key", localSapiDataEncryptor.a());
          ((Map)localObject).put("userinfo", localSapiDataEncryptor.a("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", localJSONObject.toString()));
          ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
          localObject = new RequestParams((Map)localObject);
          this.d.post(this.c.context, this.e.a() + "/v5/login/sapi/relogin", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
          {
            protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
            {
              if (a.a(a.this).c())
              {
                a.a(a.this).d();
                localReloginResult.setResultCode(65334);
                paramSapiCallback.onFailure(localReloginResult);
                return;
              }
              a.a(a.this).b();
              a.this.a(paramSapiCallback, paramReloginDTO);
            }
            
            protected void onFinish()
            {
              paramSapiCallback.onFinish();
            }
            
            protected void onStart()
            {
              paramSapiCallback.onStart();
            }
            
            protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
            {
              a.a(a.this).d();
              paramAnonymousInt = a.this.b(paramAnonymousString);
              localReloginResult.setResultCode(paramAnonymousInt);
              for (;;)
              {
                try
                {
                  paramAnonymousString = new JSONObject(paramAnonymousString).optString("userinfo");
                  paramAnonymousString = new JSONObject(localSapiDataEncryptor.a(paramAnonymousString));
                  localReloginResult.setResultMsg(paramAnonymousString.optString("errmsg"));
                  switch (paramAnonymousInt)
                  {
                  case 0: 
                    paramSapiCallback.onFailure(localReloginResult);
                    return;
                  }
                }
                catch (Exception paramAnonymousString)
                {
                  paramSapiCallback.onFailure(localReloginResult);
                  L.e(paramAnonymousString);
                  return;
                }
                localReloginResult.session = a.this.a(paramAnonymousString);
                paramSapiCallback.onSuccess(localReloginResult);
                return;
              }
            }
          });
          return;
        }
      }
      catch (Exception paramReloginDTO)
      {
        localReloginResult.setResultCode(65334);
        paramSapiCallback.onFailure(localReloginResult);
        L.e(paramReloginDTO);
        return;
      }
      localJSONObject.put("password", paramReloginDTO.password);
    }
  }
  
  void a(final SapiCallback<LoginResult> paramSapiCallback, String paramString)
  {
    final LoginResult localLoginResult = new LoginResult();
    if (TextUtils.isEmpty(paramString))
    {
      localLoginResult.setResultCode(65334);
      paramSapiCallback.onFailure(localLoginResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localLoginResult.setResultCode(65335);
      paramSapiCallback.onFailure(localLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    this.d.get(this.c.context, paramString, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        localLoginResult.setResultCode(65334);
        paramSapiCallback.onFailure(localLoginResult);
      }
      
      protected void onFinish()
      {
        paramSapiCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramSapiCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          localObject = paramAnonymousString.optJSONObject("errInfo");
          paramAnonymousInt = ((JSONObject)localObject).optInt("no", 65334);
          localLoginResult.setResultCode(paramAnonymousInt);
          localObject = ((JSONObject)localObject).optString("msg");
          localLoginResult.setResultMsg((String)localObject);
          switch (paramAnonymousInt)
          {
          case 0: 
            paramSapiCallback.onFailure(localLoginResult);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          paramSapiCallback.onFailure(localLoginResult);
          L.e(paramAnonymousString);
          return;
        }
        localLoginResult.setResultMsg("登录成功");
        String str = paramAnonymousString.optJSONObject("data").optString("xml");
        paramAnonymousString = new SapiAccount();
        paramAnonymousString.app = SapiUtils.getAppName(a.b(a.this).context);
        Object localObject = new SapiAccount.ReloginCredentials();
        ((SapiAccount.ReloginCredentials)localObject).account = a.c(a.this).account;
        ((SapiAccount.ReloginCredentials)localObject).password = SapiDataEncryptor.encryptPwd(a.c(a.this).password);
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
        paramAnonymousInt = localXmlPullParser.getEventType();
        for (;;)
        {
          paramAnonymousInt = localXmlPullParser.next();
          break label481;
          str = localXmlPullParser.getName();
          if (str.equalsIgnoreCase("uname"))
          {
            paramAnonymousString.username = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("displayname"))
          {
            paramAnonymousString.displayname = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("uid"))
          {
            paramAnonymousString.uid = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("bduss"))
          {
            paramAnonymousString.bduss = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("ptoken"))
          {
            paramAnonymousString.ptoken = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("stoken"))
          {
            paramAnonymousString.stoken = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("ubi"))
          {
            ((SapiAccount.ReloginCredentials)localObject).ubi = localXmlPullParser.nextText();
          }
          else if (str.equalsIgnoreCase("accounttype"))
          {
            ((SapiAccount.ReloginCredentials)localObject).accountType = localXmlPullParser.nextText();
            label481:
            while (paramAnonymousInt == 1)
            {
              b.a(a.b(a.this).context).a(paramAnonymousString.uid, (SapiAccount.ReloginCredentials)localObject);
              com.baidu.sapi2.share.a.a().a(paramAnonymousString);
              paramSapiCallback.onSuccess(localLoginResult);
              return;
              break;
            }
            switch (paramAnonymousInt)
            {
            }
          }
        }
      }
    });
  }
  
  void a(final SapiCallback<DynamicPwdLoginResult> paramSapiCallback, final String paramString1, final String paramString2)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    final DynamicPwdLoginResult localDynamicPwdLoginResult = new DynamicPwdLoginResult();
    if (TextUtils.isEmpty(paramString1))
    {
      localDynamicPwdLoginResult.setResultCode(-101);
      paramSapiCallback.onFailure(localDynamicPwdLoginResult);
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      localDynamicPwdLoginResult.setResultCode(-102);
      paramSapiCallback.onFailure(localDynamicPwdLoginResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localDynamicPwdLoginResult.setResultCode(65335);
      paramSapiCallback.onFailure(localDynamicPwdLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = a("/v2/sapi/login");
    ((Map)localObject).put("crypttype", String.valueOf(6));
    ((Map)localObject).put("cert_id", String.valueOf(1));
    ((Map)localObject).put("isphone", "1");
    ((Map)localObject).put("isdpass", "1");
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("username", paramString1);
      localJSONObject.put("password", paramString2);
      localJSONObject.put("login_type", "3");
      localJSONObject.put("key", localSapiDataEncryptor.a());
      ((Map)localObject).put("userinfo", localSapiDataEncryptor.a("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", localJSONObject.toString()));
      ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
      localObject = new RequestParams((Map)localObject);
      this.d.post(this.c.context, r(), (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localDynamicPwdLoginResult.setResultCode(65334);
            paramSapiCallback.onFailure(localDynamicPwdLoginResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramSapiCallback, paramString1, paramString2);
        }
        
        protected void onFinish()
        {
          paramSapiCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramSapiCallback.onStart();
        }
        
        /* Error */
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 23	com/baidu/sapi2/a$3:f	Lcom/baidu/sapi2/a;
          //   4: invokestatic 42	com/baidu/sapi2/a:a	(Lcom/baidu/sapi2/a;)Lcom/baidu/sapi2/a$a;
          //   7: invokevirtual 50	com/baidu/sapi2/a$a:d	()V
          //   10: aload_0
          //   11: getfield 23	com/baidu/sapi2/a$3:f	Lcom/baidu/sapi2/a;
          //   14: aload_2
          //   15: invokevirtual 79	com/baidu/sapi2/a:b	(Ljava/lang/String;)I
          //   18: istore_1
          //   19: aload_0
          //   20: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   23: iload_1
          //   24: invokevirtual 56	com/baidu/sapi2/result/DynamicPwdLoginResult:setResultCode	(I)V
          //   27: new 81	org/json/JSONObject
          //   30: dup
          //   31: aload_2
          //   32: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   35: ldc 86
          //   37: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
          //   40: astore_2
          //   41: new 81	org/json/JSONObject
          //   44: dup
          //   45: aload_0
          //   46: getfield 29	com/baidu/sapi2/a$3:c	Lcom/baidu/sapi2/utils/SapiDataEncryptor;
          //   49: aload_2
          //   50: invokevirtual 94	com/baidu/sapi2/utils/SapiDataEncryptor:a	(Ljava/lang/String;)Ljava/lang/String;
          //   53: invokespecial 84	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   56: astore_2
          //   57: aload_2
          //   58: ldc 96
          //   60: invokevirtual 100	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
          //   63: ldc 102
          //   65: invokevirtual 90	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
          //   68: astore 4
          //   70: aload_0
          //   71: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   74: aload 4
          //   76: invokevirtual 105	com/baidu/sapi2/result/DynamicPwdLoginResult:setResultMsg	(Ljava/lang/String;)V
          //   79: iload_1
          //   80: tableswitch	default:+129->209, 0:+34->114
          //   100: aload_0
          //   101: getfield 25	com/baidu/sapi2/a$3:a	Lcom/baidu/sapi2/callback/SapiCallback;
          //   104: aload_0
          //   105: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   108: invokeinterface 61 2 0
          //   113: return
          //   114: aload_0
          //   115: getfield 23	com/baidu/sapi2/a$3:f	Lcom/baidu/sapi2/a;
          //   118: aload_2
          //   119: invokevirtual 108	com/baidu/sapi2/a:a	(Lorg/json/JSONObject;)Lcom/baidu/sapi2/SapiAccount;
          //   122: astore_2
          //   123: aload_0
          //   124: getfield 25	com/baidu/sapi2/a$3:a	Lcom/baidu/sapi2/callback/SapiCallback;
          //   127: instanceof 110
          //   130: istore_3
          //   131: iload_3
          //   132: ifeq +27 -> 159
          //   135: aload_0
          //   136: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   139: aload_2
          //   140: putfield 114	com/baidu/sapi2/result/DynamicPwdLoginResult:session	Lcom/baidu/sapi2/SapiAccount;
          //   143: aload_0
          //   144: getfield 25	com/baidu/sapi2/a$3:a	Lcom/baidu/sapi2/callback/SapiCallback;
          //   147: checkcast 110	com/baidu/sapi2/callback/SapiCallbackInterceptor
          //   150: aload_0
          //   151: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   154: invokeinterface 117 2 0
          //   159: invokestatic 122	com/baidu/sapi2/share/a:a	()Lcom/baidu/sapi2/share/a;
          //   162: aload_2
          //   163: invokevirtual 125	com/baidu/sapi2/share/a:a	(Lcom/baidu/sapi2/SapiAccount;)V
          //   166: aload_0
          //   167: getfield 25	com/baidu/sapi2/a$3:a	Lcom/baidu/sapi2/callback/SapiCallback;
          //   170: aload_0
          //   171: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   174: invokeinterface 127 2 0
          //   179: return
          //   180: astore_2
          //   181: aload_0
          //   182: getfield 25	com/baidu/sapi2/a$3:a	Lcom/baidu/sapi2/callback/SapiCallback;
          //   185: aload_0
          //   186: getfield 27	com/baidu/sapi2/a$3:b	Lcom/baidu/sapi2/result/DynamicPwdLoginResult;
          //   189: invokeinterface 61 2 0
          //   194: aload_2
          //   195: invokestatic 132	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
          //   198: return
          //   199: astore 4
          //   201: aload 4
          //   203: invokestatic 132	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
          //   206: goto -47 -> 159
          //   209: goto -109 -> 100
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	212	0	this	3
          //   0	212	1	paramAnonymousInt	int
          //   0	212	2	paramAnonymousString	String
          //   130	2	3	bool	boolean
          //   68	7	4	str	String
          //   199	3	4	localThrowable	Throwable
          // Exception table:
          //   from	to	target	type
          //   27	79	180	java/lang/Exception
          //   100	113	180	java/lang/Exception
          //   114	131	180	java/lang/Exception
          //   135	159	180	java/lang/Exception
          //   159	179	180	java/lang/Exception
          //   201	206	180	java/lang/Exception
          //   135	159	199	java/lang/Throwable
        }
      });
      return;
    }
    catch (Exception paramString1)
    {
      localDynamicPwdLoginResult.setResultCode(65334);
      paramSapiCallback.onFailure(localDynamicPwdLoginResult);
      L.e(paramString1);
    }
  }
  
  void a(final SapiCallback<VoiceRegResult> paramSapiCallback, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("voiceMd5 can't be empty");
    }
    final VoiceRegResult localVoiceRegResult = new VoiceRegResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceRegResult.setResultCode(65335);
      paramSapiCallback.onFailure(localVoiceRegResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/regvoice");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    ((Map)localObject).put("voicemd5", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      ((Map)localObject).put("bduss", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      ((Map)localObject).put("authsid", paramString3);
    }
    if (paramBoolean) {
      ((Map)localObject).put("newuser", "1");
    }
    for (;;)
    {
      ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
      localObject = new RequestParams((Map)localObject);
      this.d.post(this.c.context, this.e.a() + "/v2/sapi/regvoice", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localVoiceRegResult.setResultCode(65334);
            paramSapiCallback.onFailure(localVoiceRegResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramSapiCallback, paramString1, paramString2, paramString3, paramBoolean);
        }
        
        protected void onFinish()
        {
          paramSapiCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramSapiCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          a.a(a.this, paramSapiCallback, paramAnonymousString, paramBoolean);
        }
      });
      return;
      ((Map)localObject).put("newuser", "0");
    }
  }
  
  void a(final SetPopularPortraitCallback paramSetPopularPortraitCallback, final SetPopularPortraitDTO paramSetPopularPortraitDTO)
  {
    if (paramSetPopularPortraitCallback == null) {
      throw new IllegalArgumentException("SetPopularPortraitCallback can't be null");
    }
    if (paramSetPopularPortraitDTO == null) {
      throw new IllegalArgumentException("SetPopularPortraitDto can't be null");
    }
    if (TextUtils.isEmpty(paramSetPopularPortraitDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if (TextUtils.isEmpty(paramSetPopularPortraitDTO.series)) {
      throw new IllegalArgumentException("series can't be empty");
    }
    final SetPopularPortraitResult localSetPopularPortraitResult = new SetPopularPortraitResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localSetPopularPortraitResult.setResultCode(65335);
      paramSetPopularPortraitCallback.onFailure(localSetPopularPortraitResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramSetPopularPortraitDTO.bduss);
    ((Map)localObject).put("serie", paramSetPopularPortraitDTO.series);
    ((Map)localObject).put("num", String.valueOf(paramSetPopularPortraitDTO.num));
    String str = a((Map)localObject, this.c.appSignKey);
    MultipartRequestParams localMultipartRequestParams = new MultipartRequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localMultipartRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localMultipartRequestParams.put("sig", str);
    this.d.post(this.c.context, q(), localMultipartRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localSetPopularPortraitResult.setResultCode(65334);
          paramSetPopularPortraitCallback.onFailure(localSetPopularPortraitResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramSetPopularPortraitCallback, paramSetPopularPortraitDTO);
      }
      
      public void onFinish()
      {
        paramSetPopularPortraitCallback.onFinish();
      }
      
      public void onStart()
      {
        paramSetPopularPortraitCallback.onStart();
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          paramAnonymousInt = paramAnonymousString.getInt("errno");
          localSetPopularPortraitResult.setResultCode(paramAnonymousInt);
          localSetPopularPortraitResult.setResultMsg(paramAnonymousString.optString("errmsg"));
          if (paramAnonymousInt == 0)
          {
            paramSetPopularPortraitCallback.onSuccess(localSetPopularPortraitResult);
            return;
          }
          paramSetPopularPortraitCallback.onFailure(localSetPopularPortraitResult);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          localSetPopularPortraitResult.setResultCode(65334);
          paramSetPopularPortraitCallback.onFailure(localSetPopularPortraitResult);
          L.e(paramAnonymousString);
        }
      }
    });
  }
  
  void a(final SetPortraitCallback paramSetPortraitCallback, final String paramString1, final byte[] paramArrayOfByte, final String paramString2)
  {
    if (paramSetPortraitCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new IllegalArgumentException("file can't be empty");
    }
    final SetPortraitResult localSetPortraitResult = new SetPortraitResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localSetPortraitResult.setResultCode(65335);
      paramSetPortraitCallback.onFailure(localSetPortraitResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramString1);
    String str = a((Map)localObject, this.c.appSignKey);
    MultipartRequestParams localMultipartRequestParams = new MultipartRequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localMultipartRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localMultipartRequestParams.put("sig", str);
    if (TextUtils.isEmpty(paramString2)) {}
    for (str = "image/jpeg";; str = paramString2)
    {
      localMultipartRequestParams.put("file", new ByteArrayInputStream(paramArrayOfByte), "portrait.jpg", str);
      this.d.post(this.c.context, m(), localMultipartRequestParams, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localSetPortraitResult.setResultCode(65334);
            paramSetPortraitCallback.onFailure(localSetPortraitResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramSetPortraitCallback, paramString1, paramArrayOfByte, paramString2);
        }
        
        protected void onFinish()
        {
          paramSetPortraitCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramSetPortraitCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          paramAnonymousInt = a.this.b(paramAnonymousString);
          localSetPortraitResult.setResultCode(paramAnonymousInt);
          switch (localSetPortraitResult.getResultCode())
          {
          default: 
            paramSetPortraitCallback.onFailure(localSetPortraitResult);
            return;
          case 0: 
            paramSetPortraitCallback.onSuccess(localSetPortraitResult);
            return;
          }
          paramSetPortraitCallback.onBdussExpired(localSetPortraitResult);
        }
      });
      return;
    }
  }
  
  void a(final VoiceCheckCallback paramVoiceCheckCallback, final VoiceCheckDTO paramVoiceCheckDTO)
  {
    if (paramVoiceCheckCallback == null) {
      throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
    }
    if (paramVoiceCheckDTO == null) {
      throw new IllegalArgumentException(VoiceCheckDTO.class.getSimpleName() + " can't be null");
    }
    final VoiceCheckResult localVoiceCheckResult = new VoiceCheckResult();
    if (TextUtils.isEmpty(paramVoiceCheckDTO.account))
    {
      localVoiceCheckResult.setResultCode(-101);
      paramVoiceCheckCallback.onFailure(localVoiceCheckResult);
      return;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceCheckResult.setResultCode(65335);
      paramVoiceCheckCallback.onFailure(localVoiceCheckResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    String str = d.b("/v2/sapi/getvoiceid");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    ((Map)localObject).put("username", paramVoiceCheckDTO.account);
    if ((paramVoiceCheckDTO.accountType == null) || (paramVoiceCheckDTO.accountType == VoiceCheckDTO.AccountType.MERGE)) {
      ((Map)localObject).put("merge", "1");
    }
    if (paramVoiceCheckDTO.accountType == VoiceCheckDTO.AccountType.USERNAME) {
      ((Map)localObject).put("isphone", "0");
    }
    if (paramVoiceCheckDTO.accountType == VoiceCheckDTO.AccountType.PHONE) {
      ((Map)localObject).put("isphone", "1");
    }
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/getvoiceid", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localVoiceCheckResult.setResultCode(65334);
          paramVoiceCheckCallback.onFailure(localVoiceCheckResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramVoiceCheckCallback, paramVoiceCheckDTO);
      }
      
      protected void onFinish()
      {
        paramVoiceCheckCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramVoiceCheckCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        a.a(a.this, paramVoiceCheckCallback, paramAnonymousString);
      }
    });
  }
  
  void a(final VoiceCheckCallback paramVoiceCheckCallback, final String paramString1, final String paramString2)
  {
    if (paramVoiceCheckCallback == null) {
      throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      throw new IllegalArgumentException("either uid or bduss should be assigned");
    }
    final VoiceCheckResult localVoiceCheckResult = new VoiceCheckResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceCheckResult.setResultCode(65335);
      paramVoiceCheckCallback.onFailure(localVoiceCheckResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/getvoiceid");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      ((Map)localObject).put("bduss", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((Map)localObject).put("userid", paramString2);
    }
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/getvoiceid", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localVoiceCheckResult.setResultCode(65334);
          paramVoiceCheckCallback.onFailure(localVoiceCheckResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramVoiceCheckCallback, paramString1, paramString2);
      }
      
      protected void onFinish()
      {
        paramVoiceCheckCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramVoiceCheckCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        a.a(a.this, paramVoiceCheckCallback, paramAnonymousString);
      }
    });
  }
  
  void a(final VoiceCodeSetCallback paramVoiceCodeSetCallback, final VoiceCodeSetDTO paramVoiceCodeSetDTO)
  {
    if (paramVoiceCodeSetCallback == null) {
      throw new IllegalArgumentException(VoiceCodeSetCallback.class.getSimpleName() + " can't be null");
    }
    if (paramVoiceCodeSetDTO == null) {
      throw new IllegalArgumentException("VoiceCodeSetDTO can't be empty");
    }
    if (TextUtils.isEmpty(paramVoiceCodeSetDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if ((paramVoiceCodeSetDTO.voiceCode > 10) || (paramVoiceCodeSetDTO.voiceCode < 0)) {
      throw new IllegalArgumentException("abnormal voice code");
    }
    final VoiceCodeSetResult localVoiceCodeSetResult = new VoiceCodeSetResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceCodeSetResult.setResultCode(65335);
      paramVoiceCodeSetCallback.onFailure(localVoiceCodeSetResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/updatevoicepassword");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    ((Map)localObject).put("time", String.valueOf(b.a(this.c.context).s()));
    ((Map)localObject).put("bduss", paramVoiceCodeSetDTO.bduss);
    ((Map)localObject).put("password", SapiDataEncryptor.c(String.valueOf(paramVoiceCodeSetDTO.voiceCode), SapiDataEncryptor.a));
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/updatevoicepassword", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localVoiceCodeSetResult.setResultCode(65334);
          paramVoiceCodeSetCallback.onFailure(localVoiceCodeSetResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramVoiceCodeSetCallback, paramVoiceCodeSetDTO);
      }
      
      protected void onFinish()
      {
        paramVoiceCodeSetCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramVoiceCodeSetCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        try
        {
          paramAnonymousInt = Integer.parseInt(new JSONObject(paramAnonymousString).optString("errno"));
          localVoiceCodeSetResult.setResultCode(paramAnonymousInt);
          if (paramAnonymousInt == 0)
          {
            paramVoiceCodeSetCallback.onSuccess(localVoiceCodeSetResult);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramVoiceCodeSetCallback.onBdussExpired(localVoiceCodeSetResult);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          localVoiceCodeSetResult.setResultCode(65334);
          paramVoiceCodeSetCallback.onFailure(localVoiceCodeSetResult);
          return;
        }
        paramVoiceCodeSetCallback.onFailure(localVoiceCodeSetResult);
      }
    });
  }
  
  void a(final VoiceLoginCallback paramVoiceLoginCallback, final String paramString1, final String paramString2)
  {
    if (paramVoiceLoginCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("voiceMd5 can't be empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("uid can't be empty");
    }
    final VoiceLoginResult localVoiceLoginResult = new VoiceLoginResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceLoginResult.setResultCode(65335);
      paramVoiceLoginCallback.onFailure(localVoiceLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/voicelogin");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    ((Map)localObject).put("voicemd5", paramString1);
    ((Map)localObject).put("id", SapiDataEncryptor.c(paramString2, SapiDataEncryptor.a));
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/voicelogin", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localVoiceLoginResult.setResultCode(65334);
          paramVoiceLoginCallback.onFailure(localVoiceLoginResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramVoiceLoginCallback, paramString1, paramString2);
      }
      
      protected void onFinish()
      {
        paramVoiceLoginCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramVoiceLoginCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        a.a(a.this, paramVoiceLoginCallback, paramAnonymousString);
      }
    });
  }
  
  void a(final VoiceSwitchSetCallback paramVoiceSwitchSetCallback, final VoiceSwitchSetDTO paramVoiceSwitchSetDTO)
  {
    if (paramVoiceSwitchSetCallback == null) {
      throw new IllegalArgumentException(VoiceSwitchSetCallback.class.getSimpleName() + " can't be null");
    }
    if (paramVoiceSwitchSetDTO == null) {
      throw new IllegalArgumentException("VoiceSwitchSetDTO can't be empty");
    }
    if (TextUtils.isEmpty(paramVoiceSwitchSetDTO.bduss)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final VoiceSwitchSetResult localVoiceSwitchSetResult = new VoiceSwitchSetResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceSwitchSetResult.setResultCode(65335);
      paramVoiceSwitchSetCallback.onFailure(localVoiceSwitchSetResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", this.c.appId);
    localHashMap.put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      localHashMap.put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      localHashMap.put("clientip", this.c.clientIp);
    }
    Object localObject = d.b("/v2/sapi/updatevoiceloginswitch");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localHashMap.put("di", localObject);
    }
    localHashMap.put("time", String.valueOf(b.a(this.c.context).s()));
    localHashMap.put("bduss", paramVoiceSwitchSetDTO.bduss);
    if (paramVoiceSwitchSetDTO.action == Switch.ON) {}
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("status", localObject);
      localHashMap.put("sig", a(localHashMap, this.c.appSignKey));
      localObject = new RequestParams(localHashMap);
      this.d.post(this.c.context, this.e.a() + "/v2/sapi/updatevoiceloginswitch", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
      {
        protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            localVoiceSwitchSetResult.setResultCode(65334);
            paramVoiceSwitchSetCallback.onFailure(localVoiceSwitchSetResult);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramVoiceSwitchSetCallback, paramVoiceSwitchSetDTO);
        }
        
        protected void onFinish()
        {
          paramVoiceSwitchSetCallback.onFinish();
        }
        
        protected void onStart()
        {
          paramVoiceSwitchSetCallback.onStart();
        }
        
        protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          try
          {
            paramAnonymousInt = Integer.parseInt(new JSONObject(paramAnonymousString).optString("errno"));
            localVoiceSwitchSetResult.setResultCode(paramAnonymousInt);
            if (paramAnonymousInt == 0)
            {
              paramVoiceSwitchSetCallback.onSuccess(localVoiceSwitchSetResult);
              return;
            }
            if (1 == paramAnonymousInt)
            {
              paramVoiceSwitchSetCallback.onBdussExpired(localVoiceSwitchSetResult);
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            localVoiceSwitchSetResult.setResultCode(65334);
            paramVoiceSwitchSetCallback.onFailure(localVoiceSwitchSetResult);
            return;
          }
          paramVoiceSwitchSetCallback.onFailure(localVoiceSwitchSetResult);
        }
      });
      return;
    }
  }
  
  void a(final VoiceVerifyCallback paramVoiceVerifyCallback, final VoiceVerifyDTO paramVoiceVerifyDTO)
  {
    if (paramVoiceVerifyCallback == null) {
      throw new IllegalArgumentException(VoiceVerifyCallback.class.getSimpleName() + " can't be null");
    }
    if (paramVoiceVerifyDTO == null) {
      throw new IllegalArgumentException(VoiceVerifyDTO.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramVoiceVerifyDTO.voiceMD5)) {
      throw new IllegalArgumentException("voiceMD5 must be assigned");
    }
    final VoiceVerifyResult localVoiceVerifyResult = new VoiceVerifyResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localVoiceVerifyResult.setResultCode(65335);
      paramVoiceVerifyCallback.onFailure(localVoiceVerifyResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId))
    {
      ((Map)localObject).put("clientid", this.c.clientId);
      ((Map)localObject).put("cuid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    String str = d.b("/v2/sapi/verifyvoice");
    if (!TextUtils.isEmpty(str)) {
      ((Map)localObject).put("di", str);
    }
    ((Map)localObject).put("md5", paramVoiceVerifyDTO.voiceMD5);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/verifyvoice", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localVoiceVerifyResult.setResultCode(65334);
          paramVoiceVerifyCallback.onFailure(localVoiceVerifyResult);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramVoiceVerifyCallback, paramVoiceVerifyDTO);
      }
      
      protected void onFinish()
      {
        paramVoiceVerifyCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramVoiceVerifyCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        localVoiceVerifyResult.setResultCode(paramAnonymousInt);
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          if (paramAnonymousInt == 0)
          {
            paramVoiceVerifyCallback.onSuccess(localVoiceVerifyResult);
            return;
          }
          localVoiceVerifyResult.setResultMsg(paramAnonymousString.optString("errmsg"));
          paramVoiceVerifyCallback.onFailure(localVoiceVerifyResult);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          localVoiceVerifyResult.setResultCode(65334);
          paramVoiceVerifyCallback.onFailure(localVoiceVerifyResult);
        }
      }
    });
  }
  
  void a(final Web2NativeLoginCallback paramWeb2NativeLoginCallback)
  {
    final Web2NativeLoginResult localWeb2NativeLoginResult = new Web2NativeLoginResult();
    final String str = SapiUtils.getCookieBduss();
    if (TextUtils.isEmpty(str))
    {
      if (paramWeb2NativeLoginCallback != null)
      {
        localWeb2NativeLoginResult.setResultCode(-101);
        paramWeb2NativeLoginCallback.onBdussEmpty(localWeb2NativeLoginResult);
      }
      return;
    }
    a(new GetUserInfoCallback()
    {
      public void a(GetUserInfoResult paramAnonymousGetUserInfoResult)
      {
        if (paramWeb2NativeLoginCallback != null)
        {
          localWeb2NativeLoginResult.setResultCode(400021);
          paramWeb2NativeLoginCallback.onBdussExpired(localWeb2NativeLoginResult);
        }
      }
      
      public void b(GetUserInfoResult paramAnonymousGetUserInfoResult)
      {
        SapiAccount localSapiAccount = new SapiAccount();
        localSapiAccount.uid = paramAnonymousGetUserInfoResult.uid;
        localSapiAccount.username = paramAnonymousGetUserInfoResult.username;
        localSapiAccount.displayname = paramAnonymousGetUserInfoResult.displayname;
        localSapiAccount.bduss = str;
        com.baidu.sapi2.share.a.a().a(localSapiAccount);
        if (paramWeb2NativeLoginCallback != null)
        {
          localWeb2NativeLoginResult.setResultCode(0);
          paramWeb2NativeLoginCallback.onSuccess(localWeb2NativeLoginResult);
        }
      }
      
      public void c(GetUserInfoResult paramAnonymousGetUserInfoResult)
      {
        if (paramWeb2NativeLoginCallback != null)
        {
          localWeb2NativeLoginResult.setResultCode(65334);
          paramWeb2NativeLoginCallback.onFailure(localWeb2NativeLoginResult);
        }
      }
      
      public void onFinish()
      {
        if (paramWeb2NativeLoginCallback != null) {
          paramWeb2NativeLoginCallback.onFinish();
        }
      }
      
      public void onStart()
      {
        if (paramWeb2NativeLoginCallback != null) {
          paramWeb2NativeLoginCallback.onStart();
        }
      }
    }, str);
  }
  
  void a(final FillUsernameCallBack paramFillUsernameCallBack, final String paramString1, final String paramString2, final String paramString3)
  {
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      if (paramFillUsernameCallBack != null) {
        paramFillUsernameCallBack.onNetworkFailed();
      }
      return;
    }
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    this.d.get(this.c.context, z(), new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        JSONObject localJSONObject = new JSONObject();
        paramAnonymousThrowable = "";
        try
        {
          localJSONObject.put("failure_info", paramAnonymousString);
          paramAnonymousString = localJSONObject.toString();
          paramAnonymousThrowable = paramAnonymousString;
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            L.e(paramAnonymousString);
          }
          a.this.a(paramFillUsernameCallBack, paramString1, paramString2, paramString3);
        }
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.a(a.this, -100, paramFillUsernameCallBack, paramAnonymousThrowable, localSapiDataEncryptor);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this).d();
        try
        {
          Object localObject = new JSONObject(paramAnonymousString);
          String str = ((JSONObject)localObject).optString("cert");
          localObject = ((JSONObject)localObject).optString("cert_id");
          a.a(a.this, paramFillUsernameCallBack, paramString1, paramString2, paramString3, str, (String)localObject, localSapiDataEncryptor);
          return;
        }
        catch (Exception localException)
        {
          a.a(a.this, a.this.c(paramAnonymousString), paramFillUsernameCallBack, paramAnonymousString, localSapiDataEncryptor);
          L.e(localException);
        }
      }
    });
  }
  
  public void a(final GetUserInfoCallBack paramGetUserInfoCallBack, final String paramString)
  {
    if (paramGetUserInfoCallBack == null) {
      throw new IllegalArgumentException(GetUserInfoCallBack.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      paramGetUserInfoCallBack.onFinish();
      paramGetUserInfoCallBack.onNetworkFailed();
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramString);
    String str = a((Map)localObject, this.c.appSignKey);
    RequestParams localRequestParams = new RequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localRequestParams.put("sig", str);
    this.d.post(this.c.context, o(), localRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          paramGetUserInfoCallBack.onFinish();
          paramGetUserInfoCallBack.onSystemError(-100);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramGetUserInfoCallBack, paramString);
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramGetUserInfoCallBack.onFinish();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        switch (paramAnonymousInt)
        {
        default: 
          paramGetUserInfoCallBack.onSystemError(paramAnonymousInt);
          return;
        case 0: 
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            GetUserInfoResponse localGetUserInfoResponse = new GetUserInfoResponse();
            localGetUserInfoResponse.errorCode = paramAnonymousInt;
            localGetUserInfoResponse.errorMsg = paramAnonymousString.optString("errmsg");
            String str = paramAnonymousString.optString("portrait");
            if (!TextUtils.isEmpty(str)) {
              localGetUserInfoResponse.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", new Object[] { str });
            }
            localGetUserInfoResponse.username = paramAnonymousString.optString("username");
            localGetUserInfoResponse.uid = paramAnonymousString.optString("userid");
            localGetUserInfoResponse.displayname = paramAnonymousString.optString("displayname");
            localGetUserInfoResponse.incompleteUser = "1".equals(paramAnonymousString.optString("incomplete_user"));
            localGetUserInfoResponse.secureMobile = paramAnonymousString.optString("securemobil");
            localGetUserInfoResponse.secureEmail = paramAnonymousString.optString("secureemail");
            paramGetUserInfoCallBack.onSuccess(localGetUserInfoResponse);
            return;
          }
          catch (JSONException paramAnonymousString)
          {
            paramGetUserInfoCallBack.onSystemError(paramAnonymousInt);
            L.e(paramAnonymousString);
            return;
          }
        }
        paramGetUserInfoCallBack.onBdussInvalid();
      }
    });
  }
  
  void a(final QrAppLoginCallBack paramQrAppLoginCallBack, final String paramString1, final String paramString2)
  {
    if (!SapiUtils.hasActiveNetwork(this.c.context)) {
      if (paramQrAppLoginCallBack != null)
      {
        paramQrAppLoginCallBack.onFinish();
        paramQrAppLoginCallBack.onNetworkFailed();
      }
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (paramQrAppLoginCallBack == null);
    paramQrAppLoginCallBack.onFinish();
    paramQrAppLoginCallBack.onQrCodeInvalid();
    return;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sign", paramString1);
    ((HashMap)localObject).put("cmd", paramString2);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((HashMap)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((HashMap)localObject).put("clientip", this.c.clientIp);
    }
    ((HashMap)localObject).put("tpl", this.c.tpl);
    ((HashMap)localObject).put("appid", this.c.appId);
    ((HashMap)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/qrlogin?lp=app", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.this.a(a.this.c(paramAnonymousString), paramQrAppLoginCallBack, paramAnonymousString);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramQrAppLoginCallBack, paramString1, paramString2);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this).d();
        a.this.a(paramAnonymousInt, paramQrAppLoginCallBack, paramAnonymousString);
      }
    });
  }
  
  void a(QrPCLoginCallBack paramQrPCLoginCallBack, String paramString)
  {
    paramQrPCLoginCallBack.onFinish();
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        i = Integer.parseInt(localJSONObject.optString("errno"));
        switch (i)
        {
        case 0: 
          paramQrPCLoginCallBack.onSystemError(i);
          return;
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        int i;
        paramQrPCLoginCallBack.onSystemError(-100);
        return;
      }
      paramString = new QrPCLoginResponse();
      paramString.errorCode = i;
      localJSONObject = localJSONObject.optJSONObject("local");
      if (localJSONObject != null)
      {
        paramString.country = localJSONObject.optString("country");
        paramString.province = localJSONObject.optString("provice");
        paramString.city = localJSONObject.optString("city");
      }
      paramQrPCLoginCallBack.onSuccess(paramString);
      return;
      paramQrPCLoginCallBack.onQrCodeInvalid();
      return;
      paramQrPCLoginCallBack.onBdussInvalid();
      return;
      paramQrPCLoginCallBack.onUserNotNormalized();
      return;
    }
  }
  
  void a(final QrPCLoginCallBack paramQrPCLoginCallBack, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5)
  {
    if (!SapiUtils.hasActiveNetwork(this.c.context)) {
      if (paramQrPCLoginCallBack != null)
      {
        paramQrPCLoginCallBack.onFinish();
        paramQrPCLoginCallBack.onNetworkFailed();
      }
    }
    do
    {
      do
      {
        return;
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
          break;
        }
      } while (paramQrPCLoginCallBack == null);
      paramQrPCLoginCallBack.onFinish();
      paramQrPCLoginCallBack.onQrCodeInvalid();
      return;
      if ((!TextUtils.isEmpty(paramString3)) || (!QrLoginAction.LOGIN.getName().equals(paramString2))) {
        break;
      }
    } while (paramQrPCLoginCallBack == null);
    paramQrPCLoginCallBack.onFinish();
    paramQrPCLoginCallBack.onBdussInvalid();
    return;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sign", paramString1);
    ((HashMap)localObject).put("cmd", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      ((HashMap)localObject).put("bduss", paramString3);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      ((HashMap)localObject).put("ptoken", paramString5);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      ((HashMap)localObject).put("stoken", paramString4);
    }
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((HashMap)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((HashMap)localObject).put("clientip", this.c.clientIp);
    }
    ((HashMap)localObject).put("tpl", this.c.tpl);
    ((HashMap)localObject).put("appid", this.c.appId);
    ((HashMap)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/qrlogin?lp=pc", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.this.a(paramQrPCLoginCallBack, paramAnonymousString);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramQrPCLoginCallBack, paramString1, paramString2, paramString3, paramString4, paramString5);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this).d();
        a.this.a(paramQrPCLoginCallBack, paramAnonymousString);
      }
    });
  }
  
  void a(final SapiCallBack<SapiResponse> paramSapiCallBack, final SapiAccount.ReloginCredentials paramReloginCredentials)
  {
    if (paramReloginCredentials == null) {
      throw new IllegalArgumentException("ReloginCredentials can't be null");
    }
    if (TextUtils.isEmpty(paramReloginCredentials.account)) {
      if (paramSapiCallBack != null) {
        paramSapiCallBack.onSystemError(130005);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!TextUtils.isEmpty(paramReloginCredentials.password)) {
              break;
            }
          } while (paramSapiCallBack == null);
          paramSapiCallBack.onSystemError(130010);
          return;
          if (!TextUtils.isEmpty(paramReloginCredentials.ubi)) {
            break;
          }
        } while (paramSapiCallBack == null);
        paramSapiCallBack.onSystemError(130025);
        return;
        if ((this.c != null) && (this.c.context != null)) {
          break;
        }
      } while (paramSapiCallBack == null);
      paramSapiCallBack.onSystemError(-100);
      return;
      if (SapiUtils.hasActiveNetwork(this.c.context)) {
        break;
      }
    } while (paramSapiCallBack == null);
    paramSapiCallBack.onNetworkFailed();
    return;
    SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    for (;;)
    {
      try
      {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(x());
        HashMap localHashMap = new HashMap();
        localHashMap.put("crypttype", "11");
        localHashMap.put("tpl", this.c.tpl);
        localHashMap.put("appid", this.c.appId);
        if (TextUtils.isEmpty(this.c.clientId)) {
          this.c.clientId = SapiUtils.getClientId(this.c.context);
        }
        localHashMap.put("cuid", this.c.clientId);
        localHashMap.put("cert_id", String.valueOf(2));
        localHashMap.put("isdpass", "0");
        localHashMap.put("username", paramReloginCredentials.account);
        localHashMap.put("password", paramReloginCredentials.password);
        localHashMap.put("UBI", paramReloginCredentials.ubi);
        if ("3".equals(paramReloginCredentials.accountType))
        {
          localObject = "1";
          localHashMap.put("isphone", localObject);
          localHashMap.put("login_type", "3");
          localHashMap.put("key", localSapiDataEncryptor.a());
          localHashMap.put("sdk_version", "2");
          localHashMap.put("pinfo", e.b());
          localHashMap.put("sig", a(localHashMap, this.c.appSignKey));
          localObject = new RequestParams(localHashMap);
          this.d.post(this.c.context, r(), (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
          {
            public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
            {
              if (a.a(a.this).c())
              {
                a.a(a.this).d();
                a.a(a.this, a.this.b(paramAnonymousString), paramSapiCallBack, paramAnonymousString);
                return;
              }
              a.a(a.this).b();
              a.this.a(paramSapiCallBack, paramReloginCredentials);
            }
            
            public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
            {
              a.a(a.this).d();
              a.a(a.this, a.this.b(paramAnonymousString), paramSapiCallBack, paramAnonymousString);
            }
          });
          return;
        }
      }
      catch (Exception paramReloginCredentials)
      {
        d(-100, paramSapiCallBack, null);
        L.e(paramReloginCredentials);
        return;
      }
      Object localObject = "0";
    }
  }
  
  public void a(final SapiCallBack<GetPortraitResponse> paramSapiCallBack, final String paramString1, final String paramString2, final String paramString3)
  {
    if (paramSapiCallBack == null) {
      throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      paramSapiCallBack.onNetworkFailed();
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      ((Map)localObject).put("ptoken", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      ((Map)localObject).put("stoken", paramString3);
    }
    String str = a((Map)localObject, this.c.appSignKey);
    RequestParams localRequestParams = new RequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localRequestParams.put("sig", str);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/center/getportrait", localRequestParams, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          paramSapiCallBack.onSystemError(-100);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramSapiCallBack, paramString1, paramString2, paramString3);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        paramAnonymousInt = a.this.b(paramAnonymousString);
        if (paramAnonymousInt == 0) {
          try
          {
            Object localObject = new JSONObject(paramAnonymousString);
            paramAnonymousString = new GetPortraitResponse();
            paramAnonymousString.errorCode = paramAnonymousInt;
            paramAnonymousString.errorMsg = ((JSONObject)localObject).optString("errmsg");
            localObject = ((JSONObject)localObject).optString("portrait");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramAnonymousString.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", new Object[] { localObject });
            }
            paramSapiCallBack.onSuccess(paramAnonymousString);
            return;
          }
          catch (JSONException paramAnonymousString)
          {
            paramSapiCallBack.onSystemError(paramAnonymousInt);
            L.e(paramAnonymousString);
            return;
          }
        }
        paramSapiCallBack.onSystemError(paramAnonymousInt);
      }
    });
  }
  
  void a(final SapiCallBack<SapiResponse> paramSapiCallBack, final String paramString1, final String paramString2, final String paramString3, final byte[] paramArrayOfByte, final String paramString4)
  {
    if (paramSapiCallBack == null) {
      throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new IllegalArgumentException("file can't be empty");
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      paramSapiCallBack.onNetworkFailed();
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      ((Map)localObject).put("ptoken", paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      ((Map)localObject).put("stoken", paramString3);
    }
    String str = a((Map)localObject, this.c.appSignKey);
    MultipartRequestParams localMultipartRequestParams = new MultipartRequestParams();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localMultipartRequestParams.put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localMultipartRequestParams.put("sig", str);
    if (TextUtils.isEmpty(paramString4)) {}
    for (str = "image/jpeg";; str = paramString4)
    {
      localMultipartRequestParams.put("file", new ByteArrayInputStream(paramArrayOfByte), "portrait.jpg", str);
      this.d.post(this.c.context, m(), localMultipartRequestParams, new HttpResponseHandler(Looper.getMainLooper())
      {
        public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
        {
          if (a.a(a.this).c())
          {
            a.a(a.this).d();
            paramSapiCallBack.onSystemError(-100);
            return;
          }
          a.a(a.this).b();
          a.this.a(paramSapiCallBack, paramString1, paramString2, paramString3, paramArrayOfByte, paramString4);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          a.a(a.this).d();
          paramAnonymousInt = a.this.b(paramAnonymousString);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = new SapiResponse();
            paramAnonymousString.errorCode = paramAnonymousInt;
            paramAnonymousString.errorMsg = "设置头像成功";
            paramSapiCallBack.onSuccess(paramAnonymousString);
            return;
          }
          paramSapiCallBack.onSystemError(paramAnonymousInt);
        }
      });
      return;
    }
  }
  
  boolean a(final SapiCallBack<SapiResponse> paramSapiCallBack)
  {
    if ((this.c == null) || (this.c.context == null) || (TextUtils.isEmpty(this.c.deviceLoginSignKey)) || (!b.a(this.c.context).b())) {}
    do
    {
      return false;
      if (SapiUtils.hasActiveNetwork(this.c.context)) {
        break;
      }
    } while (paramSapiCallBack == null);
    paramSapiCallBack.onNetworkFailed();
    return false;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    String str = e.a.a(e.d(this.c.context));
    ((HashMap)localObject).put("ptpl", this.c.tpl);
    ((HashMap)localObject).put("device_id", str);
    ((HashMap)localObject).put("device_info", e.d());
    ((HashMap)localObject).put("package_sign", this.c.deviceLoginSignKey);
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, y().getDeviceUrl() + "/yunid/device/reg", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        a.this.a(a.this.c(paramAnonymousString), paramSapiCallBack, paramAnonymousString);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.this.a(paramAnonymousInt, paramSapiCallBack, paramAnonymousString);
      }
    });
    return true;
  }
  
  boolean a(final SapiCallBack<SapiResponse> paramSapiCallBack, final String paramString)
  {
    if ((this.c == null) || (this.c.context == null)) {}
    do
    {
      do
      {
        return false;
        if (SapiUtils.hasActiveNetwork(this.c.context)) {
          break;
        }
      } while (paramSapiCallBack == null);
      paramSapiCallBack.onNetworkFailed();
      return false;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (paramSapiCallBack == null);
    paramSapiCallBack.onSystemError(257);
    return false;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("username", paramString);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((HashMap)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((HashMap)localObject).put("clientip", this.c.clientIp);
    }
    ((HashMap)localObject).put("tpl", this.c.tpl);
    ((HashMap)localObject).put("appid", this.c.appId);
    ((HashMap)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/getdpass", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.this.e(paramSapiCallBack, paramAnonymousString);
          return;
        }
        a.a(a.this).b();
        a.this.a(paramSapiCallBack, paramString);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this).d();
        a.this.e(paramSapiCallBack, paramAnonymousString);
      }
    });
    return true;
  }
  
  boolean a(final SapiCallBack<SapiAccountResponse> paramSapiCallBack, final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    if ((this.c == null) || (this.c.context == null)) {
      return false;
    }
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      if (paramSapiCallBack != null) {
        paramSapiCallBack.onNetworkFailed();
      }
      return true;
    }
    final SapiDataEncryptor localSapiDataEncryptor = new SapiDataEncryptor();
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    this.d.get(this.c.context, z(), new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        JSONObject localJSONObject = new JSONObject();
        paramAnonymousThrowable = "";
        try
        {
          localJSONObject.put("failure_info", paramAnonymousString);
          paramAnonymousString = localJSONObject.toString();
          paramAnonymousThrowable = paramAnonymousString;
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            a.this.a(-100, paramSapiCallBack, "", paramBoolean, localSapiDataEncryptor);
            L.e(paramAnonymousString);
          }
          a.a(a.this).b();
          a.this.a(paramSapiCallBack, paramString1, paramString2, paramBoolean);
        }
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.this.a(-100, paramSapiCallBack, paramAnonymousThrowable, paramBoolean, localSapiDataEncryptor);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        try
        {
          Object localObject = new JSONObject(paramAnonymousString);
          String str = ((JSONObject)localObject).optString("cert");
          localObject = ((JSONObject)localObject).optString("cert_id");
          a.a(a.this, paramSapiCallBack, str, (String)localObject, paramString1, paramString2, paramBoolean, localSapiDataEncryptor);
          return;
        }
        catch (Exception localException)
        {
          a.this.a(-100, paramSapiCallBack, paramAnonymousString, paramBoolean, localSapiDataEncryptor);
          L.e(localException);
        }
      }
    });
    return true;
  }
  
  int b(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("errno");
      return i;
    }
    catch (Exception paramString)
    {
      L.e(paramString);
    }
    return -100;
  }
  
  String b()
  {
    return this.f;
  }
  
  void b(int paramInt, SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    SapiAccountResponse localSapiAccountResponse;
    if (paramString != null) {
      localSapiAccountResponse = new SapiAccountResponse();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localSapiAccountResponse.displayname = paramString.optString("displayname");
        localSapiAccountResponse.uid = paramString.optString("uid");
        localSapiAccountResponse.bduss = paramString.optString("bduss");
        localSapiAccountResponse.ptoken = paramString.optString("ptoken");
        if ((!paramString.has("error_code")) && (!paramString.has("error_msg")))
        {
          SapiAccount localSapiAccount = new SapiAccount();
          localSapiAccount.uid = localSapiAccountResponse.uid;
          localSapiAccount.bduss = localSapiAccountResponse.bduss;
          localSapiAccount.displayname = localSapiAccountResponse.displayname;
          localSapiAccount.stoken = localSapiAccountResponse.stoken;
          localSapiAccount.ptoken = localSapiAccountResponse.ptoken;
          localSapiAccount.app = SapiUtils.getAppName(this.c.context);
          if (paramString.has("device_token")) {
            b.a(this.c.context).a(paramString.getString("device_token"));
          }
          com.baidu.sapi2.share.a.a().a(localSapiAccount);
        }
        if (paramSapiCallBack == null) {
          break;
        }
        switch (paramString.optInt("error_code"))
        {
        case 0: 
          paramSapiCallBack.onSystemError(paramString.optInt("error_code"));
          return;
        }
      }
      catch (Exception paramString)
      {
        if (paramSapiCallBack == null) {
          break;
        }
      }
      paramSapiCallBack.onSuccess(null);
      return;
      paramSapiCallBack.onSystemError(-100);
      return;
      if (paramSapiCallBack == null) {
        break;
      }
      paramSapiCallBack.onSystemError(paramInt);
      return;
    }
  }
  
  void b(final SapiCallback<OAuthResult> paramSapiCallback, final String paramString)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("bduss can't be empty");
    }
    final OAuthResult localOAuthResult = new OAuthResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localOAuthResult.setResultCode(65335);
      paramSapiCallback.onFailure(localOAuthResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((Map)localObject).put("appid", this.c.appId);
    ((Map)localObject).put("tpl", this.c.tpl);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((Map)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((Map)localObject).put("clientip", this.c.clientIp);
    }
    ((Map)localObject).put("bduss", paramString);
    ((Map)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/bdussexchangeaccesstoken", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localOAuthResult.setResultCode(65334);
          paramSapiCallback.onFailure(localOAuthResult);
          return;
        }
        a.a(a.this).b();
        a.this.b(paramSapiCallback, paramString);
      }
      
      protected void onFinish()
      {
        paramSapiCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramSapiCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(paramAnonymousString);
            paramAnonymousInt = Integer.parseInt(localJSONObject.optString("errno"));
            localOAuthResult.setResultCode(paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            case 0: 
              paramSapiCallback.onFailure(localOAuthResult);
              return;
            }
          }
          catch (Throwable paramAnonymousString)
          {
            JSONObject localJSONObject;
            localOAuthResult.setResultCode(65334);
            paramSapiCallback.onFailure(localOAuthResult);
            return;
          }
          localOAuthResult.accessToken = localJSONObject.optString("access_token");
          localOAuthResult.expiresIn = localJSONObject.optInt("expires_in");
          localOAuthResult.scope = localJSONObject.optString("scope");
          localOAuthResult.refreshToken = localJSONObject.optString("refresh_token");
          localOAuthResult.sessionKey = localJSONObject.optString("session_key");
          localOAuthResult.sessionSecret = localJSONObject.optString("session_secret");
          localOAuthResult.extra = paramAnonymousString;
          paramSapiCallback.onSuccess(localOAuthResult);
          return;
        }
      }
    });
  }
  
  void b(final SapiCallback<QrAppLoginResult> paramSapiCallback, final String paramString1, final String paramString2)
  {
    if (paramSapiCallback == null) {
      throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
    }
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("sign can't be empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("cmd can't be empty");
    }
    final QrAppLoginResult localQrAppLoginResult = new QrAppLoginResult();
    if (!SapiUtils.hasActiveNetwork(this.c.context))
    {
      localQrAppLoginResult.setResultCode(65335);
      paramSapiCallback.onFailure(localQrAppLoginResult);
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sign", paramString1);
    ((HashMap)localObject).put("cmd", paramString2);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((HashMap)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((HashMap)localObject).put("clientip", this.c.clientIp);
    }
    ((HashMap)localObject).put("tpl", this.c.tpl);
    ((HashMap)localObject).put("appid", this.c.appId);
    ((HashMap)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/qrlogin?lp=app", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      protected void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          localQrAppLoginResult.setResultCode(65334);
          paramSapiCallback.onFailure(localQrAppLoginResult);
          return;
        }
        a.a(a.this).b();
        a.this.b(paramSapiCallback, paramString1, paramString2);
      }
      
      protected void onFinish()
      {
        paramSapiCallback.onFinish();
      }
      
      protected void onStart()
      {
        paramSapiCallback.onStart();
      }
      
      protected void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a(a.this).d();
        for (;;)
        {
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            paramAnonymousInt = Integer.parseInt(paramAnonymousString.optString("errno"));
            localQrAppLoginResult.setResultCode(paramAnonymousInt);
            switch (paramAnonymousInt)
            {
            case 0: 
              paramSapiCallback.onFailure(localQrAppLoginResult);
              return;
            }
          }
          catch (Throwable paramAnonymousString)
          {
            JSONObject localJSONObject;
            paramSapiCallback.onFailure(localQrAppLoginResult);
            L.e(paramAnonymousString);
            return;
          }
          localJSONObject = paramAnonymousString.optJSONObject("local");
          if (localJSONObject != null)
          {
            localQrAppLoginResult.country = localJSONObject.optString("country");
            localQrAppLoginResult.province = localJSONObject.optString("provice");
            localQrAppLoginResult.city = localJSONObject.optString("city");
          }
          paramAnonymousString = a.this.a(paramAnonymousString);
          com.baidu.sapi2.share.a.a().a(paramAnonymousString);
          paramSapiCallback.onSuccess(localQrAppLoginResult);
          return;
        }
      }
    });
  }
  
  boolean b(final SapiCallBack<SapiAccountResponse> paramSapiCallBack, final String paramString)
  {
    if ((this.c == null) || (this.c.context == null)) {}
    do
    {
      do
      {
        return false;
        if (SapiUtils.hasActiveNetwork(this.c.context)) {
          break;
        }
      } while (paramSapiCallBack == null);
      paramSapiCallBack.onNetworkFailed();
      return false;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (paramSapiCallBack == null);
    paramSapiCallBack.onSystemError(-103);
    return false;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("sms", paramString);
    if (!TextUtils.isEmpty(this.c.clientId)) {
      ((HashMap)localObject).put("clientid", this.c.clientId);
    }
    if (!TextUtils.isEmpty(this.c.clientIp)) {
      ((HashMap)localObject).put("clientip", this.c.clientIp);
    }
    ((HashMap)localObject).put("tpl", this.c.tpl);
    ((HashMap)localObject).put("appid", this.c.appId);
    ((HashMap)localObject).put("sig", a((Map)localObject, this.c.appSignKey));
    localObject = new RequestParams((Map)localObject);
    this.d.post(this.c.context, this.e.a() + "/v2/sapi/smsgetlogin", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        if (a.a(a.this).c())
        {
          a.a(a.this).d();
          a.this.c(a.this.c(paramAnonymousString), paramSapiCallBack, paramAnonymousString);
          return;
        }
        a.a(a.this).b();
        a.this.b(paramSapiCallBack, paramString);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.a(a.this).d();
        a.this.c(paramAnonymousInt, paramSapiCallBack, paramAnonymousString);
      }
    });
    return true;
  }
  
  int c(String paramString)
  {
    int j = b(paramString);
    int i = j;
    if (j == 110000) {
      i = 0;
    }
    return i;
  }
  
  void c()
  {
    if ((this.c == null) || (this.c.context == null) || (!SapiUtils.hasActiveNetwork(this.c.context))) {
      return;
    }
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    Object localObject = new HashMap();
    if (b.a(this.c.context).a() != null)
    {
      ((HashMap)localObject).put("device_id", e.d(this.c.context));
      ((HashMap)localObject).put("device_token", b.a(this.c.context).a());
    }
    localObject = new RequestParams((Map)localObject);
    this.d.get(this.c.context, y().getDeviceUrl() + "/yunid/device/service/status", (RequestParams)localObject, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
        b.a(a.b(a.this).context).a(false);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        if (paramAnonymousString != null) {}
        try
        {
          paramAnonymousString = new JSONObject(paramAnonymousString);
          if ((!paramAnonymousString.has("error_code")) && (!paramAnonymousString.has("error_msg")) && (paramAnonymousString.optInt("fulfilbind") == 0) && ((paramAnonymousString.optInt("reg") == 1) || (paramAnonymousString.optInt("login") == 1))) {
            b.a(a.b(a.this).context).a(true);
          }
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          L.e(paramAnonymousString);
          b.a(a.b(a.this).context).a(false);
        }
      }
    });
  }
  
  void c(int paramInt, SapiCallBack<SapiAccountResponse> paramSapiCallBack, String paramString)
  {
    SapiAccountResponse localSapiAccountResponse;
    if (paramString != null) {
      localSapiAccountResponse = new SapiAccountResponse();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localSapiAccountResponse.displayname = paramString.optString("displayname");
        localSapiAccountResponse.username = paramString.optString("uname");
        localSapiAccountResponse.uid = paramString.optString("uid");
        localSapiAccountResponse.bduss = paramString.optString("bduss");
        localSapiAccountResponse.ptoken = paramString.optString("ptoken");
        localSapiAccountResponse.stoken = paramString.optString("stoken");
        localSapiAccountResponse.newReg = paramString.optBoolean("newreg");
        if (localSapiAccountResponse.newReg) {
          localSapiAccountResponse.authSid = paramString.optString("authsid");
        }
        if (paramSapiCallBack == null) {
          break;
        }
        switch (paramString.optInt("errno"))
        {
        case 0: 
          paramSapiCallBack.onSystemError(paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        if (paramSapiCallBack == null) {
          break;
        }
      }
      paramSapiCallBack.onSuccess(localSapiAccountResponse);
      return;
      paramSapiCallBack.onSystemError(-100);
      return;
      paramSapiCallBack.onSystemError(paramString.optInt("errno"));
      return;
      if (paramSapiCallBack == null) {
        break;
      }
      paramSapiCallBack.onSystemError(paramInt);
      return;
    }
  }
  
  void c(final SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    if ((this.c == null) || (this.c.context == null) || (TextUtils.isEmpty(this.c.deviceLoginSignKey))) {}
    do
    {
      return;
      if (SapiUtils.hasActiveNetwork(this.c.context)) {
        break;
      }
    } while (paramSapiCallBack == null);
    paramSapiCallBack.onNetworkFailed();
    return;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    HashMap localHashMap = new HashMap();
    String str = e.a.a(e.d(this.c.context));
    localHashMap.put("ptpl", this.c.tpl);
    localHashMap.put("device_id", str);
    localHashMap.put("device_info", e.d());
    localHashMap.put("force_reg_token", paramString);
    paramString = new RequestParams(localHashMap);
    this.d.post(this.c.context, y().getDeviceUrl() + "/yunid/device/forcereg", paramString, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        a.this.b(a.this.c(paramAnonymousString), paramSapiCallBack, paramAnonymousString);
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.this.b(paramAnonymousInt, paramSapiCallBack, paramAnonymousString);
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    });
  }
  
  String d()
  {
    return y().getWap() + "/passport/login";
  }
  
  boolean d(final SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    if ((this.c == null) || (this.c.context == null) || (TextUtils.isEmpty(this.c.deviceLoginSignKey))) {}
    do
    {
      return false;
      if (SapiUtils.hasActiveNetwork(this.c.context)) {
        break;
      }
    } while (paramSapiCallBack == null);
    paramSapiCallBack.onNetworkFailed();
    return false;
    this.d = new AsyncHttpClient();
    this.d.setUserAgent(x());
    HashMap localHashMap = new HashMap();
    String str = e.a.a(e.d(this.c.context));
    localHashMap.put("ptpl", this.c.tpl);
    localHashMap.put("device_id", str);
    localHashMap.put("device_token", paramString);
    localHashMap.put("package_sign", this.c.deviceLoginSignKey);
    paramString = new RequestParams(localHashMap);
    this.d.post(this.c.context, y().getDeviceUrl() + "/yunid/device/login", paramString, new HttpResponseHandler(Looper.getMainLooper())
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        a.this.a(a.this.c(paramAnonymousString), paramSapiCallBack, paramAnonymousString);
        super.onFailure(paramAnonymousThrowable, paramAnonymousString);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        a.this.a(paramAnonymousInt, paramSapiCallBack, paramAnonymousString);
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
      }
    });
    return true;
  }
  
  String e()
  {
    return y().getWap() + "/passport/getpass";
  }
  
  void e(SapiCallBack<SapiResponse> paramSapiCallBack, String paramString)
  {
    for (;;)
    {
      try
      {
        i = Integer.parseInt(new JSONObject(paramString).optString("errno"));
        switch (i)
        {
        case 0: 
          paramSapiCallBack.onSystemError(i);
          return;
        }
      }
      catch (Exception paramString)
      {
        int i;
        paramSapiCallBack.onSystemError(-100);
        return;
      }
      paramString = new SapiResponse();
      paramString.errorCode = i;
      paramString.errorMsg = "短信验证码发送成功";
      paramSapiCallBack.onSuccess(paramString);
      return;
    }
  }
  
  String f()
  {
    return y().getWap() + "/wp/wappassword";
  }
  
  String g()
  {
    return y().getWap() + "/wp/recordindex";
  }
  
  String h()
  {
    return y().getWap() + "/v2/?bindingaccount&";
  }
  
  String i()
  {
    return y().getWap() + "/v2/?bindingret";
  }
  
  String j()
  {
    return y().getWap() + "/passport/authwidget";
  }
  
  String k()
  {
    return y().getWap() + "/wp/unitewidget";
  }
  
  String l()
  {
    return this.e.a() + "/v2/sapi/center/filluname";
  }
  
  String m()
  {
    return this.e.a() + "/v2/sapi/center/setportrait";
  }
  
  String n()
  {
    return y().getPortraitUrl() + "/sys/history";
  }
  
  String o()
  {
    return this.e.a() + "/v2/sapi/center/getuinfo";
  }
  
  String p()
  {
    return y().getPortraitUrl() + "/sys/portrait/hotitemlist";
  }
  
  String q()
  {
    return y().getPortraitUrl() + "/sys/sethotitem";
  }
  
  String r()
  {
    return this.e.a() + "/v2/sapi/login";
  }
  
  String s()
  {
    return this.e.a() + "/phoenix/account/ssologin";
  }
  
  String t()
  {
    return this.e.a() + "/phoenix/account/ssologin";
  }
  
  String u()
  {
    return this.e.a() + "/phoenix/account/startlogin";
  }
  
  String v()
  {
    return this.e.a() + "/phoenix/account/afterauth";
  }
  
  String w()
  {
    return this.e.a() + "/phoenix/account/finishbind";
  }
  
  static class a
  {
    static List<String> b = new ArrayList();
    static int c;
    Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
      d();
      e();
    }
    
    private void e()
    {
      b.clear();
      b.add("http://119.75.220.29");
      b.add("http://220.181.111.48");
      b.add("http://123.125.115.81");
    }
    
    public String a()
    {
      String str = SapiAccountManager.getInstance().getSapiConfiguration().environment.getURL();
      if (c > 0)
      {
        if (c > b.size()) {
          c = 1;
        }
        str = (String)b.get(c - 1);
      }
      return str;
    }
    
    public void b()
    {
      c += 1;
    }
    
    public boolean c()
    {
      return c >= b.size();
    }
    
    public void d()
    {
      c = 0;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */