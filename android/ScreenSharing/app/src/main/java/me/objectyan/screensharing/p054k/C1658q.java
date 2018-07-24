package com.baidu.carlife.p054k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.model.C1931j;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import com.baidu.speech.asr.SpeechConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ThirdPartyAppListRequest */
/* renamed from: com.baidu.carlife.k.q */
public class C1658q extends C1626e {
    /* renamed from: a */
    private List<C1931j> f5101a;
    /* renamed from: b */
    private String f5102b;

    public C1658q(Context context) {
        this.tag = C1658q.class.getSimpleName();
    }

    /* renamed from: a */
    public List<C1931j> m5969a() {
        return this.f5101a;
    }

    /* renamed from: b */
    public String m5970b() {
        return this.f5102b;
    }

    protected String getUrl() {
        return C1631f.m5914a(C1627a.MUSIC_THIRDPARTY);
    }

    protected C1622d getUrlParams() {
        C1622d params = new C1622d();
        params.put("cl_platform", "android");
        params.put("cl_app_version", CarlifeUtil.m4373g());
        params.put("cl_sdk_version", "1.0");
        params.put("cl_device_id", CarlifeUtil.m4359b());
        params.put("cl_width", String.valueOf(CarlifeUtil.m4367d()));
        params.put("cl_height", String.valueOf(CarlifeUtil.m4369e()));
        params.put("cl_system_version", CarlifeUtil.m4377i());
        params.put("cl_device_type", CarlifeUtil.m4378j());
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        if (TextUtils.isEmpty(data)) {
            return -3;
        }
        JSONArray jsonArray = new JSONArray(data);
        if (jsonArray == null) {
            return -3;
        }
        int arrayLength = jsonArray.length();
        if (arrayLength < 1) {
            return -3;
        }
        this.f5102b = data;
        this.f5101a = new ArrayList();
        for (int i = 0; i < arrayLength; i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            if (jsonObject != null) {
                C1931j model = new C1931j();
                model.i = jsonObject.optString("sdk_address");
                model.h = jsonObject.optString(SpeechConstant.APP_ID);
                model.g = jsonObject.optInt("app_type");
                model.k = jsonObject.optString("app_description");
                model.m = jsonObject.optString("sdk_name");
                model.n = jsonObject.optString("akey");
                model.l = jsonObject.optString("app_name");
                model.j = jsonObject.optString("app_icon_address");
                model.f6068c = i + 3;
                this.f5101a.add(model);
            }
        }
        return 0;
    }

    protected void responseErrorCallBack(int errorType) {
        super.responseErrorCallBack(errorType);
    }
}
