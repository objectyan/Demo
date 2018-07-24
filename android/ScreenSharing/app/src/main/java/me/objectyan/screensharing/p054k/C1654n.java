package com.baidu.carlife.p054k;

import android.text.TextUtils;
import com.baidu.carlife.core.CommonParams.EnumVehicleChannel;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p054k.p055a.C1622d;
import com.baidu.carlife.p054k.p055a.C1626e;
import com.baidu.carlife.p054k.p055a.C1631f;
import com.baidu.carlife.p054k.p055a.C1631f.C1630d;
import com.baidu.carlife.util.C2191s;
import com.baidu.navi.track.database.DataBaseConstants;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: StatisticMobileRequest */
/* renamed from: com.baidu.carlife.k.n */
public class C1654n extends C1626e {
    /* renamed from: a */
    private C1653a f5090a;
    /* renamed from: b */
    private String f5091b;

    /* compiled from: StatisticMobileRequest */
    /* renamed from: com.baidu.carlife.k.n$a */
    public static class C1653a {
        /* renamed from: a */
        public String f5080a;
        /* renamed from: b */
        public String f5081b;
        /* renamed from: c */
        public String f5082c;
        /* renamed from: d */
        public String f5083d;
        /* renamed from: e */
        public String f5084e;
        /* renamed from: f */
        public String f5085f;
        /* renamed from: g */
        public String f5086g;
        /* renamed from: h */
        public int f5087h;
        /* renamed from: i */
        public int f5088i;
        /* renamed from: j */
        public ArrayList<String> f5089j;

        /* renamed from: a */
        public JSONObject m5964a(String act, Map<String, String> actParam, long time) {
            JSONObject jsonItem = new JSONObject();
            try {
                JSONObject jsonTmp = new JSONObject();
                for (String key : actParam.keySet()) {
                    jsonTmp.put(key, actParam.get(key));
                }
                jsonItem.put(NaviStatConstants.STAT_ACT_PARAM, act);
                jsonItem.put("ActParam", jsonTmp);
                jsonItem.put("tm", time);
                m5963a(jsonItem.toString());
                return jsonItem;
            } catch (Exception e) {
                LogUtil.m4445e("StatisticMobileParams", e.toString());
                return null;
            }
        }

        /* renamed from: a */
        public String m5963a(String item) {
            if (this.f5089j == null) {
                this.f5089j = new ArrayList();
            }
            this.f5089j.add(item);
            return item;
        }
    }

    /* renamed from: a */
    public void m5966a(String statisticFileName) {
        this.f5091b = statisticFileName;
    }

    /* renamed from: a */
    public void m5965a(C1653a params) {
        this.f5090a = params;
    }

    public C1654n() {
        this.tag = C1654n.class.getSimpleName();
    }

    protected String getUrl() {
        return C1631f.m5917a(C1630d.STATISTICS_VEHICLE);
    }

    protected C1622d getPostRequestParams() {
        if (this.f5090a == null) {
            return null;
        }
        C1622d params = new C1622d();
        params.put("channel", this.f5090a.f5081b);
        if ("harman".equals(this.f5090a.f5080a.toLowerCase()) || EnumVehicleChannel.VEHICLE_CHANNEL_AUDI.getChannel().equals(this.f5090a.f5080a) || EnumVehicleChannel.VEHICLE_CHANNEL_AUDI_DUAL_AUDIO.getChannel().equals(this.f5090a.f5080a)) {
            this.f5090a.f5080a = this.f5090a.f5085f;
        }
        params.put("cuid", this.f5090a.f5080a);
        params.put("version", this.f5090a.f5082c);
        params.put("os", this.f5090a.f5083d);
        params.put("mb", this.f5090a.f5084e);
        params.put("mCuid", this.f5090a.f5085f);
        params.put("appVer", this.f5090a.f5086g);
        params.put(DataBaseConstants.TYPE_LOC, "" + this.f5090a.f5087h);
        params.put("isConn", "" + this.f5090a.f5088i);
        if (this.f5090a.f5089j == null) {
            return params;
        }
        for (int i = 0; i < this.f5090a.f5089j.size(); i++) {
            params.put("item" + i, (String) this.f5090a.f5089j.get(i));
        }
        return params;
    }

    protected int responseSuccessCallBack(String data) {
        if (!TextUtils.isEmpty(this.f5091b)) {
            File file = new File(C2191s.f7008b + this.f5091b);
            if (file.exists()) {
                file.delete();
            }
        }
        return 0;
    }
}
