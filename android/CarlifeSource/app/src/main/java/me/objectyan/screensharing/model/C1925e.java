package com.baidu.carlife.model;

import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.mobstat.Config;
import com.baidu.navi.protocol.model.GeoPointInfo;
import com.baidu.navi.track.database.DataService;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navisdk.comapi.mapcontrol.MapParams.Const;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import org.json.JSONObject;

/* compiled from: FoodCafeModel */
/* renamed from: com.baidu.carlife.model.e */
public class C1925e implements Serializable {
    /* renamed from: a */
    public static final int f5961a = 0;
    /* renamed from: b */
    public static final int f5962b = 100;
    /* renamed from: c */
    public static final int f5963c = 101;
    /* renamed from: d */
    public static final int f5964d = 102;
    /* renamed from: e */
    public static final int f5965e = 103;
    /* renamed from: f */
    public static final int f5966f = 104;
    /* renamed from: g */
    public static final int f5967g = 200;
    /* renamed from: A */
    public int f5968A;
    /* renamed from: B */
    public Double f5969B = Double.valueOf(0.0d);
    /* renamed from: C */
    public int f5970C;
    /* renamed from: D */
    public String f5971D;
    /* renamed from: E */
    public String f5972E;
    /* renamed from: F */
    public List<C1926f> f5973F;
    /* renamed from: h */
    public String f5974h;
    /* renamed from: i */
    public String f5975i;
    /* renamed from: j */
    public String f5976j;
    /* renamed from: k */
    public int f5977k;
    /* renamed from: l */
    public String f5978l;
    /* renamed from: m */
    public int f5979m;
    /* renamed from: n */
    public Integer f5980n = Integer.valueOf(0);
    /* renamed from: o */
    public int f5981o;
    /* renamed from: p */
    public String f5982p;
    /* renamed from: q */
    public String f5983q;
    /* renamed from: r */
    public int f5984r;
    /* renamed from: s */
    public int f5985s;
    /* renamed from: t */
    public String f5986t;
    /* renamed from: u */
    public String f5987u;
    /* renamed from: v */
    public String f5988v;
    /* renamed from: w */
    public String f5989w;
    /* renamed from: x */
    public String f5990x;
    /* renamed from: y */
    public String f5991y;
    /* renamed from: z */
    public String f5992z;

    /* renamed from: a */
    public static C1925e m7387a(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        C1925e model = new C1925e();
        model.f5974h = jsonObject.optString("id");
        model.f5975i = jsonObject.optString("name");
        model.f5976j = jsonObject.optString("logo");
        model.f5969B = Double.valueOf(jsonObject.optDouble(C2125n.ag));
        model.f5968A = jsonObject.optInt("avg");
        model.f5990x = jsonObject.optString(OVERLAY_KEY.AREA_STYLE);
        model.f5980n = Integer.valueOf(jsonObject.optInt("distant"));
        model.f5979m = jsonObject.optInt(Config.EXCEPTION_MEMORY_TOTAL);
        model.f5978l = jsonObject.optString("notice");
        return model;
    }

    /* renamed from: a */
    public static C1925e m7386a(C1925e model, JSONObject jsonObject) {
        if (jsonObject != null) {
            if (model == null) {
                model = new C1925e();
            }
            model.f5974h = jsonObject.optString("sid");
            model.f5975i = jsonObject.optString("name");
            model.f5968A = jsonObject.optInt("avg");
            model.f5976j = jsonObject.optString("logo");
            model.f5977k = jsonObject.optInt("state", -1);
            model.f5978l = jsonObject.optString("notice");
            model.f5971D = jsonObject.optString("qnotice");
            model.f5981o = jsonObject.optInt(DataService.EXTRA_LIMIT);
            model.f5972E = jsonObject.optString(Const.DISCOUNT);
            model.f5989w = jsonObject.optString(GeoPointInfo.KEY_ADDR);
            model.f5991y = jsonObject.optString(SearchParamKey.TEL);
            model.f5992z = jsonObject.optString("open");
            if (!TextUtils.isEmpty(model.f5991y)) {
                String[] telephoneNum = TextUtils.split(model.f5991y, " ");
                if (telephoneNum.length > 0) {
                    model.f5991y = telephoneNum[0];
                }
            }
            model.f5973F = C1926f.m7391b(jsonObject.optJSONArray("queues"));
        }
        return model;
    }

    /* renamed from: a */
    public static String m7388a(int distance) {
        if (distance > 0 && distance < 1000) {
            return distance + Config.MODEL;
        }
        if (distance >= 1000) {
            return new DecimalFormat("0.0").format(((double) distance) / 1000.0d) + "km";
        }
        return "";
    }

    /* renamed from: a */
    public static int m7385a(C1925e model) {
        if (model.f5981o < model.f5980n.intValue()) {
            return 102;
        }
        if (model.f5977k == 2) {
            return 100;
        }
        if (model.f5977k == 0) {
            return 0;
        }
        if (model.f5977k == 3 || model.f5977k == 4) {
            return 103;
        }
        if (model.f5977k < 6 || model.f5977k > 9) {
            return 101;
        }
        return 104;
    }
}
