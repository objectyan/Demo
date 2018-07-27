package com.baidu.carlife.p054k;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OpenNaviRequest */
/* renamed from: com.baidu.carlife.k.l */
public class C1651l extends C1626e {
    public C1651l() {
        this.tag = "OpenNaviRequest导航开关";
    }

    protected String getUrl() {
        return C1631f.m5914a(C1627a.OPEN_NAVI);
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        boolean z = true;
        if (new JSONObject(data).optInt("open_flag", 0) != 1) {
            z = false;
        }
        CommonParams.jr = z;
        return 0;
    }
}
