package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.model.C1942q;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.protocol.C2566d;
import com.baidu.che.codriver.protocol.C2566d.C2565a;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.protocol.p125a.C2559c;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2708j;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2848p;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RouteCommand */
/* renamed from: com.baidu.che.codriver.vr.a.y */
public class C2807y extends C2747a implements C2566d<Place>, C2784s {
    /* renamed from: e */
    public static final String f9171e = "RouteCommand";
    /* renamed from: j */
    private static int f9172j;
    /* renamed from: f */
    private Result f9173f;
    /* renamed from: g */
    private List<Result> f9174g;
    /* renamed from: h */
    private String f9175h;
    /* renamed from: i */
    private Context f9176i;
    /* renamed from: k */
    private Handler f9177k = new Handler(Looper.getMainLooper());

    /* compiled from: RouteCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.y$1 */
    class C28041 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2807y f9168a;

        C28041(C2807y this$0) {
            this.f9168a = this$0;
        }

        public void run() {
            this.f9168a.m10617r();
            NaviCmdController.getInstance().handleNaviAppAddress(this.f9168a.b.m10795g());
            C2761c.m10463a().m10470a(8, this.f9168a.mo1952c(), Boolean.valueOf(false));
            this.f9168a.m10408l();
            C2761c.m10463a().m10471a(this.f9168a);
            C2761c.m10463a().m10478d();
            this.f9168a.c.mo1930a(C2837c.STATE_NORMAL);
            C2807y.f9172j = 0;
            C2549b model = new C2549b();
            model.f8464f = C2695a.TYPE_NORMAL_REQ;
            model.f8468j = 2;
            model.f8465g = this.f9168a.f9176i.getString(C0965R.string.navi_command_set_address_success);
            this.f9168a.c.mo1928a(model);
        }
    }

    /* compiled from: RouteCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.y$2 */
    class C28062 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2807y f9170a;

        /* compiled from: RouteCommand */
        /* renamed from: com.baidu.che.codriver.vr.a.y$2$1 */
        class C28051 implements C2752a {
            /* renamed from: a */
            final /* synthetic */ C28062 f9169a;

            C28051(C28062 this$1) {
                this.f9169a = this$1;
            }

            /* renamed from: a */
            public void mo1964a() {
                C2761c.m10463a().m10471a(this.f9169a.f9170a);
            }
        }

        C28062(C2807y this$0) {
            this.f9170a = this$0;
        }

        public void run() {
            this.f9170a.m10408l();
            C2761c.m10463a().m10478d();
            C2807y.f9172j = 0;
            C2549b model = new C2549b();
            model.f8468j = 2;
            this.f9170a.c.mo1929a(model, new C28051(this), null);
        }
    }

    public C2807y(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
        this.f9176i = context;
    }

    /* renamed from: j */
    protected void mo1958j() {
        if (this.b != null) {
            try {
                JSONObject result = new JSONObject(mo1956g());
                C2725h.m10207b(f9171e, result.toString());
                if ("poi".equals(mo1954e())) {
                    this.f9175h = result.optString("centre", mo1955f());
                } else if ("route".equals(mo1954e())) {
                    this.f9175h = result.optString(C1942q.f6129B);
                }
                String jsonPoiList = result.optString("poi");
                if (!TextUtils.isEmpty(jsonPoiList)) {
                    this.f9174g = Arrays.asList((Result[]) new Gson().fromJson(jsonPoiList, Result[].class));
                }
                C2725h.m10207b(f9171e, "parseParam: " + result.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public void mo1957h() {
        C2725h.m10207b(f9171e, "---excute：-----00");
        C2716c.m10143a(this.f9176i, "10005");
        if (this.f9173f != null) {
            C2725h.m10207b(f9171e, "---excute：-----01");
            C2549b model = new C2549b();
            model.f8465g = this.f9176i.getString(C0965R.string.common_command_ok);
            model.f8468j = 2;
            this.c.mo1928a(model);
        } else if (this.f9174g == null || this.f9174g.size() <= 0) {
            C2725h.m10207b(f9171e, "---excute：-----02");
            if (LocationUtil.getInstance().isReady()) {
                new C2559c((C2566d) this, Place.class, this.f9175h, true).m9666d();
                return;
            }
            C2549b conversationModel = new C2549b();
            conversationModel.f8467i = 21;
            conversationModel.f8464f = C2695a.TYPE_NORMAL_REQ;
            this.c.mo1928a(conversationModel);
        } else {
            m10612a(this.f9174g);
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        C2716c.m10144a(this.f9176i, C2536a.f8324y, "进入多轮");
        if (newCommand != null && C2848p.f9315p.equals(newCommand.mo1953d()) && C2848p.f9278E.equals(newCommand.mo1954e())) {
            C2549b model;
            try {
                int selectIndex = C2747a.m10395a(new JSONObject(newCommand.mo1956g()).optString("option"), this.f9174g.size());
                C2725h.m10207b(f9171e, "selectIndex:" + selectIndex);
                if (this.f9174g == null || selectIndex >= this.f9174g.size() || selectIndex < 0) {
                    model = new C2549b();
                    model.f8464f = C2695a.TYPE_NORMAL_REQ;
                    model.f8468j = 1;
                    model.f8465g = this.f9176i.getString(C0965R.string.phone_command_say_right_index);
                    model.f8466h = C2539c.f8338F;
                    this.c.mo1928a(model);
                    return;
                }
                C2716c.m10144a(this.f9176i, C2536a.f8324y, "澄清成功");
                if (this.c.mo1945s() == C2837c.STATE_SET_HOME || this.c.mo1945s() == C2837c.STATE_SET_COMPANY) {
                    m10615b((Result) this.f9174g.get(selectIndex));
                    return;
                } else {
                    m10616c((Result) this.f9174g.get(selectIndex));
                    return;
                }
            } catch (JSONException e) {
                model = new C2549b();
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8467i = 5;
                this.c.mo1928a(model);
                return;
            }
        }
        C2725h.m10207b(f9171e, "merge error");
        this.c.mo1928a(null);
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: a */
    public void mo1971a(C2565a error) {
        m10614b();
    }

    /* renamed from: a */
    public void m10621a(Place place) {
        if (place == null || place.results == null || place.results.size() == 0) {
            m10614b();
            return;
        }
        this.f9174g = place.results;
        m10612a(this.f9174g);
    }

    /* renamed from: a */
    private void m10612a(List<Result> resultList) {
        int i = 10;
        for (Result it : resultList) {
            if (it.location == null) {
                m10614b();
                return;
            }
        }
        if (resultList.size() <= 0 || resultList.size() != 1) {
            Resources resources = this.f9176i.getResources();
            Object[] objArr = new Object[1];
            if (resultList.size() <= 10) {
                i = resultList.size();
            }
            objArr[0] = Integer.valueOf(i);
            String tts = resources.getString(C0965R.string.route_command_header, objArr);
            for (Result it2 : resultList) {
                if (it2.location == null) {
                    m10614b();
                    return;
                }
                it2.distance = ((double) Math.round(LocationUtil.getInstance().calculateDistance(it2.location.lat, it2.location.lng) / 100.0d)) / 10.0d;
            }
            f9172j = 0;
            C2761c.m10463a().m10475b(this);
            C2725h.m10207b(f9171e, "more than one result");
            C2549b routeModel = new C2708j(resultList, this);
            routeModel.g = tts;
            routeModel.j = 1;
            this.c.mo1928a(routeModel);
            return;
        }
        C2725h.m10207b(f9171e, "only on result: " + ((Result) resultList.get(0)).toString());
        if (this.c.mo1945s() == C2837c.STATE_SET_HOME || this.c.mo1945s() == C2837c.STATE_SET_COMPANY) {
            m10615b((Result) resultList.get(0));
        } else {
            m10616c((Result) resultList.get(0));
        }
    }

    /* renamed from: b */
    private void m10615b(Result result) {
        if (!(result == null || result.location == null)) {
            this.f9173f = result;
        }
        this.f9177k.postDelayed(new C28041(this), 1000);
    }

    /* renamed from: c */
    private void m10616c(Result result) {
        if (!(result == null || result.location == null)) {
            this.f9173f = result;
        }
        this.f9177k.postDelayed(new C28062(this), 1000);
    }

    /* renamed from: b */
    private void m10614b() {
        C2725h.m10207b(f9171e, "---定位结果为空---" + f9172j);
        C2549b conversationModel = new C2549b();
        if (f9172j == 0) {
            conversationModel.f8468j = 1;
            conversationModel.f8465g = this.f9176i.getResources().getString(C0965R.string.route_command_no_poi_once);
            conversationModel.f8466h = C2539c.f8356X;
        } else {
            conversationModel.f8465g = this.f9176i.getResources().getString(C0965R.string.route_command_no_poi_more);
            conversationModel.f8466h = C2539c.f8355W;
        }
        conversationModel.f8464f = C2695a.TYPE_NORMAL_REQ;
        this.c.mo1928a(conversationModel);
        f9172j = 1;
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        JSONObject params = new JSONObject();
        try {
            params.putOpt("lat", new BigDecimal(this.f9173f.location.lat * 100000.0d).toString());
            params.putOpt(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, new BigDecimal(this.f9173f.location.lng * 100000.0d).toString());
            params.putOpt("poiName", this.f9173f.name);
            params.putOpt("poiRegion", this.f9173f.address);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C2725h.m10207b(f9171e, "createParamJson result = " + params.toString());
        return params;
    }

    /* renamed from: a */
    protected JSONObject m10618a() {
        JSONObject params = new JSONObject();
        try {
            params.putOpt("name", this.f9173f.name);
            params.putOpt(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, this.f9173f.address);
            params.putOpt("lat", new BigDecimal(this.f9173f.location.lat * 100000.0d).toString());
            params.putOpt(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, new BigDecimal(this.f9173f.location.lng * 100000.0d).toString());
            if (this.c.mo1945s() == C2837c.STATE_SET_COMPANY) {
                params.putOpt("type", NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY);
            } else if (this.c.mo1945s() == C2837c.STATE_SET_HOME) {
                params.putOpt("type", "home");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C2725h.m10207b(f9171e, "createParamJsonForSetAddress result = " + params.toString());
        return params;
    }

    /* renamed from: r */
    private void m10617r() {
        JSONObject result = new JSONObject();
        try {
            result.put("domain", "navigate_instruction");
            if (this.c.mo1945s() == C2837c.STATE_SET_COMPANY) {
                result.put("intent", "set_work");
            } else if (this.c.mo1945s() == C2837c.STATE_SET_HOME) {
                result.put("intent", "set_home");
            }
            result.putOpt("data", m10618a());
        } catch (JSONException e) {
            C2725h.m10214e(f9171e, "updateJsonResultForSetAddress error");
            e.printStackTrace();
        }
        this.b.m10792e(result.toString());
        C2725h.m10207b(f9171e, "updateJsonResultForSetAddress result = " + result.toString());
    }

    /* renamed from: a */
    public void mo1975a(Result result) {
        if (this.c.mo1945s() == C2837c.STATE_SET_HOME || this.c.mo1945s() == C2837c.STATE_SET_COMPANY) {
            m10615b(result);
        } else {
            m10616c(result);
        }
        this.c.mo1936d();
        C2725h.m10207b(f9171e, "onItemClick");
    }
}
