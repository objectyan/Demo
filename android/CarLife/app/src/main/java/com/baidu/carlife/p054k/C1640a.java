package com.baidu.carlife.p054k;

import android.os.Build;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.model.C1923c;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1630d;
import com.baidu.carlife.util.C2172c;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.speech.asr.SpeechConstant;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppUpdateRequest */
/* renamed from: com.baidu.carlife.k.a */
public class C1640a extends C1626e {
    /* renamed from: a */
    private C1923c f5052a;

    public C1640a() {
        this.tag = C1640a.class.getSimpleName();
    }

    /* renamed from: a */
    public C1923c m5947a() {
        return this.f5052a;
    }

    protected String getUrl() {
        return C1631f.m5917a(C1630d.APP_UPDATE);
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("protocolVersion", "1.0");
        params.put("appID", C1251e.m4371f());
        params.put("appVersionCode", String.valueOf(C1251e.m4375h()));
        params.put("appVersionName", C1251e.m4373g());
        params.put("channel", C2172c.m8224c());
        params.put("model", Build.MODEL);
        params.put("subModel", "unknow");
        params.put("platform", C1253f.jb);
        params.put(SpeechConstant.LANGUAGE, Locale.getDefault().getLanguage());
        params.put("resolution", C1251e.m4363c());
        params.put("carModel", C1253f.jx.m4403a());
        params.put("chipModel", Build.HARDWARE);
        LocData currentPoint = BNLocationManagerProxy.getInstance().getCurLocation();
        if (currentPoint != null) {
            params.put("longitude", String.valueOf(currentPoint.longitude));
            params.put("latitude", String.valueOf(currentPoint.latitude));
        } else {
            params.put("longitude", "unknow");
            params.put("latitude", "unknow");
        }
        params.toSign();
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        this.f5052a = C1923c.m7383a(new JSONObject(data));
        return 0;
    }
}
