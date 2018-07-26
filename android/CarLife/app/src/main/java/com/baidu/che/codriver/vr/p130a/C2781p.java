package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.protocol.C2566d;
import com.baidu.che.codriver.protocol.C2566d.C2565a;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.protocol.p125a.C2559c;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2705h;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2848p;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NearbyCommand */
/* renamed from: com.baidu.che.codriver.vr.a.p */
public class C2781p extends C2747a implements C2566d<Place> {
    /* renamed from: e */
    public static final String f9113e = "NearbyCommand";
    /* renamed from: n */
    private static int f9114n;
    /* renamed from: f */
    private String f9115f;
    /* renamed from: g */
    private String f9116g;
    /* renamed from: h */
    private String f9117h;
    /* renamed from: i */
    private String f9118i;
    /* renamed from: j */
    private String f9119j;
    /* renamed from: k */
    private String f9120k;
    /* renamed from: l */
    private Context f9121l;
    /* renamed from: m */
    private List<Result> f9122m;
    /* renamed from: o */
    private Handler f9123o = new Handler(Looper.getMainLooper());

    public C2781p(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        this.f9121l = context;
    }

    /* renamed from: j */
    protected void mo1958j() {
        if (this.b != null) {
            try {
                JSONObject result = new JSONObject(this.b.m10789d());
                this.f9115f = result.optString("keywords");
                this.f9116g = result.optString("centre");
                C2725h.m10207b("NearbyCommand", "---语音指令：-----" + result.toString());
                String jsonPoiList = result.optString("poi");
                if (!TextUtils.isEmpty(jsonPoiList)) {
                    this.f9122m = Arrays.asList((Result[]) new Gson().fromJson(jsonPoiList, Result[].class));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f9115f)) {
                this.f9115f = "餐馆";
            }
        }
    }

    /* renamed from: h */
    public void mo1957h() {
        C2725h.m10207b("NearbyCommand", "---excute：-----1");
        if (this.c.mo1945s() == C2837c.STATE_WHERE_GOING) {
            C2725h.m10207b("NearbyCommand", "UICallBack.State.STATE_WHERE_GOING");
            C2716c.m10144a(this.f9121l, C2536a.f8299E, C2536a.f8299E);
        }
        if (!TextUtils.isEmpty(this.f9117h) && !TextUtils.isEmpty(this.f9118i)) {
            C2725h.m10207b("NearbyCommand", "---excute：-----2");
            C2549b model = new C2549b();
            model.f8465g = this.f9121l.getString(C0965R.string.common_command_ok);
            model.f8468j = 2;
            this.c.mo1928a(model);
            C2761c.m10463a().m10473a("map", "route", new Pair("lat", this.f9117h), new Pair(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, this.f9118i), new Pair("poiName", this.f9119j), new Pair("poiRegion", this.f9120k));
        } else if (this.f9122m == null || this.f9122m.size() <= 0) {
            C2725h.m10207b("NearbyCommand", "---excute：-----3");
            if (LocationUtil.getInstance().isReady()) {
                new C2559c((C2566d) this, Place.class, this.f9115f, this.f9116g).m9666d();
            } else {
                C2549b conversationModel = new C2549b();
                conversationModel.f8467i = 21;
                conversationModel.f8464f = C2695a.TYPE_NORMAL_REQ;
                this.c.mo1928a(conversationModel);
            }
        } else {
            m10542a(this.f9122m);
        }
        C2716c.m10143a(this.f9121l, C2536a.f8310k);
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        C2716c.m10144a(this.f9121l, C2536a.f8296B, "进入多轮");
        if (newCommand == null || !C2747a.m10396b(newCommand)) {
            C2725h.m10207b("NearbyCommand", "---不是导航多轮命令，提示用户选择------");
            this.c.mo1928a(null);
            return;
        }
        C2549b model;
        try {
            JSONObject obj = new JSONObject(newCommand.mo1956g());
            C2725h.m10207b("NearbyCommand", "---多轮命令---" + obj.toString());
            int selectIndex = C2747a.m10395a(obj.optString("option"), this.f9122m.size());
            C2725h.m10207b("NearbyCommand", "---多轮命令---selectIndex:" + selectIndex);
            if (this.f9122m == null || selectIndex >= this.f9122m.size() || selectIndex < 0) {
                model = new C2549b();
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8468j = 1;
                model.f8465g = this.f9121l.getString(C0965R.string.phone_command_say_right_index);
                model.f8466h = C2539c.f8338F;
                this.c.mo1928a(model);
                return;
            }
            m10541a((Result) this.f9122m.get(selectIndex));
            C2716c.m10144a(this.f9121l, C2536a.f8296B, "澄清成功");
        } catch (JSONException e) {
            model = new C2549b();
            model.f8464f = C2695a.TYPE_NORMAL_REQ;
            model.f8467i = 5;
            this.c.mo1928a(model);
        }
    }

    /* renamed from: a */
    private void m10541a(Result result) {
        C2725h.m10207b("NearbyCommand", "---sendCommand---" + result.toString());
        this.f9117h = new BigDecimal(result.location.lat * 100000.0d).toString();
        this.f9118i = new BigDecimal(result.location.lng * 100000.0d).toString();
        this.f9119j = result.name;
        this.f9120k = result.address;
        C2549b model = new C2549b();
        model.f8468j = 2;
        this.c.mo1928a(model);
        C2725h.m10207b("NearbyCommand", "handle: " + C2761c.m10463a().m10473a("map", "route", new Pair("lat", this.f9117h), new Pair(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, this.f9118i), new Pair("poiName", result.name), new Pair("poiRegion", result.address)));
        C2761c.m10463a().m10478d();
        f9114n = 0;
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: a */
    public void mo1971a(C2565a error) {
        m10540a();
    }

    /* renamed from: a */
    public void m10544a(Place place) {
        C2725h.m10207b("NearbyCommand", "--------请求成功-------" + place.toString());
        if (place == null || place.results == null || place.results.size() == 0) {
            m10540a();
            return;
        }
        for (Result it : place.results) {
            if (it.location == null) {
                m10540a();
                return;
            }
        }
        this.f9122m = place.results;
        m10542a(this.f9122m);
    }

    /* renamed from: a */
    private void m10542a(List<Result> resultList) {
        if (resultList.size() == 1) {
            m10541a((Result) resultList.get(0));
            return;
        }
        String tts = this.f9121l.getResources().getString(C0965R.string.nearby_header_text, new Object[]{Integer.valueOf(Math.min(resultList.size(), 10))});
        C2725h.m10207b("NearbyCommand", "---存在多个相关地点，再次发起语音识别------");
        C2761c.m10463a().m10475b(this);
        C2549b model = new C2705h(resultList);
        model.g = tts;
        model.j = 1;
        this.c.mo1928a(model);
        f9114n = 0;
    }

    /* renamed from: a */
    private void m10540a() {
        C2725h.m10207b("NearbyCommand", "---结果为空或者无法解析---");
        C2549b conversationModel = new C2549b();
        if (f9114n == 0) {
            conversationModel.f8468j = 1;
            conversationModel.f8465g = this.f9121l.getResources().getString(C0965R.string.nearby_command_no_poi_once);
            conversationModel.f8466h = C2539c.f8356X;
        } else {
            conversationModel.f8465g = this.f9121l.getResources().getString(C0965R.string.nearby_command_no_poi_more);
            conversationModel.f8466h = C2539c.f8355W;
        }
        conversationModel.f8464f = C2695a.TYPE_NORMAL_REQ;
        this.c.mo1928a(conversationModel);
        f9114n = 1;
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
