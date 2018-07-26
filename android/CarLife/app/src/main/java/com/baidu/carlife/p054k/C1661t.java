package com.baidu.carlife.p054k;

import android.os.Build;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
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

/* compiled from: VehicleUpdateRequest */
/* renamed from: com.baidu.carlife.k.t */
public class C1661t extends C1626e {
    /* renamed from: c */
    private static String f5107c = null;
    /* renamed from: a */
    private String f5108a;
    /* renamed from: b */
    private C1923c f5109b;

    public C1661t() {
        this.tag = C1661t.class.getSimpleName();
    }

    /* renamed from: a */
    public C1923c m5976a() {
        return this.f5109b;
    }

    /* renamed from: a */
    public void m5977a(String versionCode) {
        this.f5108a = versionCode;
    }

    protected String getUrl() {
        if (f5107c == null || f5107c.isEmpty()) {
            return C1631f.m5917a(C1630d.APP_UPDATE);
        }
        C1260i.m4435b("#######", "VehicleUpdate URL: " + f5107c);
        return f5107c;
    }

    /* renamed from: b */
    public static void m5975b(String strUrl) {
        f5107c = strUrl;
    }

    protected C1622d getPostRequestParams() {
        C1622d params = new C1622d();
        params.put("protocolVersion", "1.0");
        params.put("appID", "com.baidu.ota.carlife");
        params.put("appVersionCode", this.f5108a);
        params.put("appVersionName", "1.0.0");
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
        this.f5109b = C1923c.m7383a(new JSONObject(data));
        return 0;
    }
}
