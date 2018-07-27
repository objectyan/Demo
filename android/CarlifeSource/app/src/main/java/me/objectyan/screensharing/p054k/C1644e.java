package com.baidu.carlife.p054k;

import android.content.Context;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1628b;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.speech.asr.SpeechConstant;
import com.google.gson.Gson;
import java.util.List;
import org.json.JSONException;

/* compiled from: FeedBackRequest */
/* renamed from: com.baidu.carlife.k.e */
public class C1644e extends C1626e {
    /* renamed from: a */
    private String f5058a;
    /* renamed from: b */
    private String f5059b;
    /* renamed from: c */
    private String f5060c;
    /* renamed from: d */
    private List<String> f5061d;
    /* renamed from: e */
    private Context f5062e;

    public C1644e(String content, String contact, String mType, List<String> picList, Context context) {
        this.tag = C1644e.class.getSimpleName();
        this.f5058a = content;
        this.f5059b = contact;
        this.f5060c = mType;
        this.f5061d = picList;
        this.f5062e = context;
    }

    /* renamed from: a */
    public void m5952a(String contact) {
        this.f5059b = contact;
    }

    /* renamed from: b */
    public void m5954b(String content) {
        this.f5058a = content;
    }

    /* renamed from: a */
    public void m5953a(List<String> picList) {
        this.f5061d = picList;
    }

    protected String getUrl() {
        return C1631f.m5915a(C1628b.FEEDBACK);
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        String strDeviceName = VDeviceAPI.getPhoneType().replace(" ", "");
        String clientid = PreferenceHelper.getInstance(this.f5062e).getString(CommonParams.jE, "");
        String appid = PreferenceHelper.getInstance(this.f5062e).getString(CommonParams.jF, "");
        String deviceid = PreferenceHelper.getInstance(this.f5062e).getString(CommonParams.jG, "");
        String screenshot = new Gson().toJson(this.f5061d);
        params.put("clientid", clientid);
        params.put("devid", deviceid);
        params.put(SpeechConstant.APP_ID, appid);
        params.put("uid", NaviAccountUtils.getInstance().getUid());
        params.put("userid", NaviAccountUtils.getInstance().getUid());
        params.put("username", NaviAccountUtils.getInstance().getUserName());
        params.put("osvn", PackageUtil.strOSVersion);
        params.put("appvn", PackageUtil.getVersionName());
        params.put("model", strDeviceName);
        params.put("content", this.f5058a);
        params.put("contact_way", this.f5059b);
        if (this.f5061d != null) {
            params.put("screenshot", screenshot);
        }
        params.put("feedback_type", this.f5060c);
        params.put("baiducuid", PackageUtil.getCuid());
        params.toSign("token");
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        StatisticManager.onEvent(StatisticConstants.SETTINGS_SUGGESTION, "UPLOAD_FEEDBACK_SUCCESS");
        return 0;
    }

    protected void responseErrorCallBack(int errorType) {
        super.responseErrorCallBack(errorType);
        StatisticManager.onEvent(StatisticConstants.SETTINGS_SUGGESTION, "UPLOAD_FEEDBACK_FAIL");
    }
}
