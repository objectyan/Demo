package com.baidu.carlife.p054k;

import android.content.Context;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.logic.C1872t;
import com.baidu.carlife.model.C1934l;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1627a;
import com.baidu.carlife.util.C2172c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SkinPkgListRequest */
/* renamed from: com.baidu.carlife.k.m */
public class C1652m extends C1626e {
    /* renamed from: a */
    private List<C1934l> f5079a;

    public C1652m(Context context) {
        super(context, "sign");
        this.tag = C1652m.class.getSimpleName();
    }

    /* renamed from: a */
    public List<C1934l> m5962a() {
        return this.f5079a;
    }

    protected String getUrl() {
        return C1631f.m5914a(C1627a.SKIN_PKG_LIST);
    }

    protected C1622d getUrlParams() {
        C1622d params = new C1622d();
        params.put("cuid", C2172c.m8223b());
        params.put("os", "0");
        params.put("sv", C1251e.m4373g());
        return params;
    }

    protected int responseSuccessCallBack(String data) throws JSONException {
        JSONArray jsonArray = new JSONObject(data).optJSONArray("list");
        if (jsonArray != null) {
            int arrayLength = jsonArray.length();
            if (arrayLength >= 1) {
                C1872t manager = C1872t.m7136a();
                this.f5079a = new ArrayList();
                for (int i = 0; i < arrayLength; i++) {
                    C1934l model = C1934l.m7399a(jsonArray.optJSONObject(i));
                    if (model != null) {
                        this.f5079a.add(model);
                    }
                }
                return 0;
            }
        }
        return -3;
    }
}
