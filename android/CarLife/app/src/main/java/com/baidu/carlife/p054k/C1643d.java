package com.baidu.carlife.p054k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1628b;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.speech.asr.SpeechConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FeedBackRegisterRequest */
/* renamed from: com.baidu.carlife.k.d */
public class C1643d extends C1626e {
    /* renamed from: a */
    private String f5056a;
    /* renamed from: b */
    private Context f5057b;

    public C1643d(String appName, Context context) {
        this.f5056a = appName;
        this.f5057b = context;
    }

    protected String getUrl() {
        return C1631f.m5915a(C1628b.REGISTER);
    }

    protected C1622d getPostRequestParams() {
        String strDeviceName = VDeviceAPI.getPhoneType().replace(" ", "");
        C1622d params = new C1622d();
        params.put("appname", this.f5056a);
        params.put("appvn", PackageUtil.getVersionName());
        params.put("pkgname", PackageUtil.getPackageName());
        params.put("sdkvn", "1.0.0");
        params.put("os", "android");
        params.put("model", strDeviceName);
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONObject dataJson = new JSONObject(data);
        if (dataJson == null && !dataJson.has("clientid") && !dataJson.has(SpeechConstant.APP_ID) && !dataJson.has("devid")) {
            return -1;
        }
        String clientid = dataJson.optString("clientid");
        String appid = dataJson.getString(SpeechConstant.APP_ID);
        String devid = dataJson.getString("devid");
        if (TextUtils.isEmpty(clientid) || TextUtils.isEmpty(appid) || TextUtils.isEmpty(devid)) {
            return -3;
        }
        PreferenceHelper.getInstance(this.f5057b).putString(C1253f.jE, clientid);
        PreferenceHelper.getInstance(this.f5057b).putString(C1253f.jF, appid);
        PreferenceHelper.getInstance(this.f5057b).putString(C1253f.jG, devid);
        return 0;
    }
}
