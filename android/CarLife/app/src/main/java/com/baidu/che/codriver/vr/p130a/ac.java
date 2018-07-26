package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.protocol.data.Place;
import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p124d.C2704g;
import com.baidu.che.codriver.ui.p124d.C2705h;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.math.BigDecimal;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TravelCommand */
/* renamed from: com.baidu.che.codriver.vr.a.ac */
public class ac extends C2747a {
    /* renamed from: e */
    public static final String f9034e = "NearbyCommand";
    /* renamed from: m */
    private static int f9035m;
    /* renamed from: f */
    private String f9036f;
    /* renamed from: g */
    private String f9037g;
    /* renamed from: h */
    private String f9038h;
    /* renamed from: i */
    private String f9039i;
    /* renamed from: j */
    private Context f9040j;
    /* renamed from: k */
    private List<Result> f9041k;
    /* renamed from: l */
    private NLPResponseData f9042l;

    /* compiled from: TravelCommand */
    /* renamed from: com.baidu.che.codriver.vr.a.ac$1 */
    class C27481 extends TypeToken<Place> {
        /* renamed from: a */
        final /* synthetic */ ac f9033a;

        C27481(ac this$0) {
            this.f9033a = this$0;
        }
    }

    public ac(NLPResponseData data, C2673m callback, Context context) {
        super(null, callback, context);
        this.f9042l = data;
        this.f9040j = context;
        mo1958j();
    }

    /* renamed from: j */
    protected void mo1958j() {
        if (this.f9042l != null) {
            NLPResponseData.Result result = C2704g.m10120a(this.f9042l);
            try {
                this.f9041k = ((Place) new Gson().fromJson(result.data, new C27481(this).getType())).list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: h */
    public void mo1957h() {
        C2725h.m10207b("NearbyCommand", "---excute：-----1");
        if (!TextUtils.isEmpty(this.f9036f) && !TextUtils.isEmpty(this.f9037g)) {
            C2725h.m10207b("NearbyCommand", "---excute：-----2");
            C2549b model = new C2549b();
            model.f8465g = this.f9040j.getString(C0965R.string.common_command_ok);
            model.f8468j = 2;
            this.c.mo1928a(model);
            C2761c.m10463a().m10473a("map", "route", new Pair("lat", this.f9036f), new Pair(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, this.f9037g), new Pair("poiName", this.f9038h), new Pair("poiRegion", this.f9039i));
        } else if (this.f9041k != null && this.f9041k.size() > 0) {
            m10418a(this.f9041k);
        } else if (LocationUtil.getInstance().isReady()) {
            m10416a();
        } else {
            C2549b conversationModel = new C2549b();
            conversationModel.f8465g = this.f9040j.getString(C0965R.string.travel_no_scenic);
            this.c.mo1928a(conversationModel);
        }
    }

    /* renamed from: a */
    public void mo1959a(C2747a newCommand) {
        C2549b model;
        if (newCommand == null || !C2747a.m10396b(newCommand)) {
            C2725h.m10207b("NearbyCommand", "---不是导航多轮命令，提示用户选择------");
            this.c.mo1928a(new C2549b());
            return;
        }
        try {
            JSONObject obj = new JSONObject(newCommand.mo1956g());
            C2725h.m10207b("NearbyCommand", "---多轮命令---" + obj.toString());
            int selectIndex = C2747a.m10395a(obj.optString("option"), this.f9041k.size());
            C2725h.m10207b("NearbyCommand", "---多轮命令---selectIndex:" + selectIndex);
            if (selectIndex >= this.f9041k.size() || selectIndex < 0) {
                model = new C2549b();
                model.f8464f = C2695a.TYPE_NORMAL_REQ;
                model.f8468j = 1;
                model.f8465g = this.f9040j.getString(C0965R.string.phone_command_say_right_index);
                this.c.mo1928a(model);
                return;
            }
            m10417a((Result) this.f9041k.get(selectIndex));
        } catch (JSONException e) {
            model = new C2549b();
            model.f8468j = 2;
            model.f8465g = this.f9040j.getString(C0965R.string.xiaodu_is_uncomfortable);
            this.c.mo1928a(model);
        }
    }

    /* renamed from: a */
    private void m10417a(Result result) {
        C2725h.m10207b("NearbyCommand", "---sendCommand---" + result.toString());
        this.f9036f = new BigDecimal(result.location.lat * 100000.0d).toString();
        this.f9037g = new BigDecimal(result.location.lng * 100000.0d).toString();
        this.f9038h = result.name;
        this.f9039i = result.address;
        C2549b model = new C2549b();
        model.f8468j = 2;
        this.c.mo1928a(model);
        C2725h.m10207b("NearbyCommand", "handle: " + C2761c.m10463a().m10473a("map", "route", new Pair("lat", this.f9036f), new Pair(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, this.f9037g), new Pair("poiName", result.name), new Pair("poiRegion", result.address)));
        C2761c.m10463a().m10478d();
        f9035m = 0;
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: a */
    private void m10418a(List<Result> resultList) {
        String tts;
        for (Result it : resultList) {
            if (it.location == null) {
                m10416a();
                return;
            }
        }
        if (resultList.size() > 3) {
            tts = this.f9040j.getResources().getString(C0965R.string.travel_header_text, new Object[]{Integer.valueOf(resultList.size())});
        } else {
            tts = this.f9040j.getResources().getString(C0965R.string.travel_header_text_one_page);
        }
        for (Result it2 : resultList) {
            it2.distance = ((double) Math.round(LocationUtil.getInstance().calculateDistance(it2.location.lat, it2.location.lng) / 100.0d)) / 10.0d;
        }
        C2725h.m10207b("NearbyCommand", "---存在多个相关地点，再次发起语音识别------");
        C2761c.m10463a().m10475b(this);
        C2549b model = new C2705h(resultList);
        model.g = tts;
        model.j = 1;
        this.c.mo1928a(model);
        f9035m = 0;
    }

    /* renamed from: a */
    private void m10416a() {
        C2725h.m10207b("NearbyCommand", "---结果为空或者无法解析---");
        C2549b conversationModel = new C2549b();
        if (f9035m == 0) {
            conversationModel.f8465g = this.f9040j.getResources().getString(C0965R.string.route_command_no_poi_once);
            conversationModel.f8468j = 1;
            this.c.mo1928a(conversationModel);
        } else {
            conversationModel.f8465g = this.f9040j.getResources().getString(C0965R.string.route_command_no_poi_more);
            this.c.mo1928a(conversationModel);
            this.c.mo1930a(C2837c.STATE_NORMAL);
        }
        f9035m = 1;
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }
}
