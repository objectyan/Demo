package com.baidu.carlife.p054k;

import android.text.TextUtils;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import com.baidu.carlife.p077e.C1435a;
import com.baidu.carlife.p077e.C1435a.C1433a;
import com.baidu.carlife.util.C2177h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigRequest */
/* renamed from: com.baidu.carlife.k.c */
public class C1642c extends C1626e {
    /* renamed from: a */
    private C1433a f5055a;

    public C1642c(C1433a callback) {
        this.tag = "ConfigRequest";
        this.f5055a = callback;
    }

    protected C1622d getUrlParams() {
        C1622d map = new C1622d();
        map.put("appversioncode", String.valueOf(C1251e.m4375h()));
        map.put("appversionname", C1251e.m4373g());
        return map;
    }

    protected String getUrl() {
        return C1631f.m5914a(C1627a.CARLIFE_CONFIG);
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        C1260i.m4435b(this.tag, "ConfigRequest responseSuccessCallBack :" + data);
        if (!TextUtils.isEmpty(data)) {
            JSONObject resultObject = new JSONObject(data).optJSONObject("results");
            if (resultObject != null) {
                C2177h.m8271a(C1435a.m5229c(), resultObject.toString());
                if (this.f5055a != null) {
                    this.f5055a.mo1551a();
                }
            }
        }
        return 0;
    }

    protected void responseErrorCallBack(int errorType) {
        this.f5055a.mo1552a(errorType);
    }
}
