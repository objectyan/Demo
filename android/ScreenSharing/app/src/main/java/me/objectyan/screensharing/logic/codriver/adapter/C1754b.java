package com.baidu.carlife.logic.codriver.adapter;

import android.content.Context;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.C1879v;
import com.baidu.carlife.logic.music.C1823k;
import com.baidu.carlife.logic.p088a.C1696h;
import com.baidu.carlife.p101o.C1983b;
import com.baidu.carlife.wechat.p112f.C2453c;
import com.baidu.che.codriver.p120e.C2534b;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.platform.navi.NaviCmdController;
import com.baidu.che.codriver.sdk.p081a.C1695n;
import com.baidu.che.codriver.sdk.p081a.C2452p;
import com.baidu.che.codriver.sdk.p081a.C2575a;
import com.baidu.che.codriver.sdk.p081a.C2575a.C1979b;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.che.codriver.sdk.p081a.C2578b.C2576a;
import com.baidu.che.codriver.sdk.p081a.C2580c;
import com.baidu.che.codriver.sdk.p081a.C2589f;
import com.baidu.che.codriver.sdk.p081a.C2589f.C1821a;
import com.baidu.che.codriver.sdk.p081a.C2593g;
import com.baidu.che.codriver.sdk.p081a.C2593g.C1499a;
import com.baidu.che.codriver.sdk.p081a.C2595h;
import com.baidu.che.codriver.sdk.p081a.C2595h.C1878b;
import com.baidu.che.codriver.sdk.p081a.C2598i;
import com.baidu.che.codriver.sdk.p081a.C2598i.C1752b;
import com.baidu.che.codriver.sdk.p081a.C2600j;
import com.baidu.che.codriver.sdk.p081a.C2600j.C1822a;
import com.baidu.che.codriver.sdk.p081a.C2602k;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.che.codriver.sdk.p081a.C2607m;
import com.baidu.che.codriver.sdk.p126b.C2617a;
import com.baidu.che.codriver.ui.p128b.C2674b;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.LocationUtil;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.voice.NaviToolImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoDriverCustomManager */
/* renamed from: com.baidu.carlife.logic.codriver.adapter.b */
public class C1754b {
    /* renamed from: a */
    public static C1754b f5302a;
    /* renamed from: c */
    private static final String f5303c = C1754b.class.getSimpleName();
    /* renamed from: b */
    private Context f5304b;

    /* compiled from: CoDriverCustomManager */
    /* renamed from: com.baidu.carlife.logic.codriver.adapter.b$1 */
    class C17531 implements C1752b {
        /* renamed from: a */
        final /* synthetic */ C1754b f5301a;

        C17531(C1754b this$0) {
            this.f5301a = this$0;
        }

        /* renamed from: a */
        public void mo1636a(String num) {
            C2725h.m10207b(C1754b.f5303c, "-----dialNum-num:" + num);
            C1868q.m7089f().m7107a(this.f5301a.f5304b, num);
            StatisticManager.onEvent(StatisticConstants.VOICE_0007);
        }
    }

    /* renamed from: a */
    public static C1754b m6365a() {
        if (f5302a == null) {
            synchronized (C1754b.class) {
                if (f5302a == null) {
                    f5302a = new C1754b();
                }
            }
        }
        return f5302a;
    }

    /* renamed from: a */
    public void m6371a(C1752b tool) {
        C2598i.m9805b().m9807a(tool);
    }

    /* renamed from: a */
    public void m6369a(C1821a tool) {
        C2589f.m9787a().m9790b(tool);
    }

    /* renamed from: a */
    public void m6372a(C1822a tool) {
        C2600j.m9814a().m9815a(tool);
    }

    /* renamed from: a */
    public void m6374a(C2607m tool) {
        C2580c.m9750a().m9751a(tool);
    }

    /* renamed from: a */
    public void m6373a(C1981b tool) {
        C2602k.m9819a().m9820a(tool);
    }

    /* renamed from: a */
    public void m6376a(C2452p wechatTool) {
        C2580c.m9750a().m9753a(wechatTool);
    }

    /* renamed from: a */
    public void m6375a(C1695n tool) {
        C2580c.m9750a().m9752a(tool);
    }

    /* renamed from: a */
    public void m6370a(C1878b tool) {
        C2595h.m9801a().m9802a(tool);
    }

    /* renamed from: a */
    public void m6367a(Context context) {
        this.f5304b = context;
        LocationUtil.getInstance().setCoordinateSystem("bd09ll");
        PlatformManager.getInstance().init(this.f5304b);
        C2534b.m9598a().m9608a(this.f5304b);
        C1983b.m7576a().m7587a(this.f5304b);
        C2578b.m9741a().m9743a(C2576a.CONNECTED);
        m6371a(new C17531(this));
        C1822a musicTool = new C1823k();
        m6374a(new NaviToolImpl());
        m6376a(new C2453c());
        m6369a((C1821a) musicTool);
        m6375a(new C1696h());
        m6372a(musicTool);
        m6370a(new C1879v());
    }

    /* renamed from: a */
    public void m6368a(C1979b sceneCommand) {
        C2575a.m9709a().m9729a(sceneCommand);
    }

    /* renamed from: b */
    public void m6382b(C1979b sceneCommand) {
        C2575a.m9709a().m9732b(sceneCommand);
    }

    /* renamed from: b */
    public void m6381b() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("domain", "navigate_instruction");
            jsonObject.put("intent", "set_work");
            JSONObject data = new JSONObject();
            data.put("name", "");
            data.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, "");
            data.put("type", NaviCmdConstants.KEY_NAVI_CMD_SET_ADDRESS_COMPANY);
            jsonObject.put("data", data);
            m6379a(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m6383c() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("domain", "navigate_instruction");
            jsonObject.put("intent", "set_home");
            JSONObject data = new JSONObject();
            data.put("name", "");
            data.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_ADDRESS, "");
            data.put("type", "home");
            jsonObject.put("data", data);
            m6379a(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m6379a(String json) {
        NaviCmdController.getInstance().handleNaviAppAddress(json);
    }

    /* renamed from: a */
    public void m6377a(C2617a model) {
        C2674b.m9985b().m10006a(model);
    }

    /* renamed from: a */
    public void m6378a(C2837c state) {
        C2674b.m9985b().m10020b(state);
    }

    /* renamed from: a */
    public void m6380a(String rawText, C1499a tool) {
        C2593g.m9796a().m9798a(rawText, tool);
    }
}
