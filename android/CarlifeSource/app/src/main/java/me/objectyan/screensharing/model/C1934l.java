package com.baidu.carlife.model;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.carlife.R;
import org.json.JSONObject;

/* compiled from: SkinPkgModel */
/* renamed from: com.baidu.carlife.model.l */
public class C1934l {
    /* renamed from: a */
    public static final int f6086a = 0;
    /* renamed from: b */
    public static final int f6087b = 1;
    /* renamed from: c */
    public static final int f6088c = 2;
    /* renamed from: d */
    public String f6089d;
    /* renamed from: e */
    public int f6090e;
    /* renamed from: f */
    public String f6091f;
    /* renamed from: g */
    public String f6092g;
    /* renamed from: h */
    public String f6093h;
    /* renamed from: i */
    public int f6094i;
    /* renamed from: j */
    public int f6095j = 2;
    /* renamed from: k */
    public int f6096k = R.drawable.home_ic_my_skin_default;
    /* renamed from: l */
    public C1933a f6097l = C1933a.DOWNLOAD;

    /* compiled from: SkinPkgModel */
    /* renamed from: com.baidu.carlife.model.l$a */
    public enum C1933a {
        APPLY,
        DOWNLOAD,
        DOWNLOADING
    }

    /* renamed from: a */
    public static C1934l m7399a(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        C1934l model = new C1934l();
        model.f6089d = jsonObject.optString("name");
        model.f6090e = jsonObject.optInt("version");
        model.f6091f = jsonObject.optString("thumb");
        model.f6092g = jsonObject.optString("download_link");
        model.f6093h = jsonObject.optString(PushConstants.PACKAGE_NAME);
        model.f6094i = jsonObject.optInt("size");
        return model;
    }
}
