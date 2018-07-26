package com.baidu.che.codriver.sdk.handler;

import com.baidu.che.codriver.platform.PlatformConstants;
import com.baidu.che.codriver.sdk.p081a.C2575a;
import com.baidu.che.codriver.sdk.p081a.C2575a.C1979b;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.sdk.p081a.C2606l.C2603a;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.C2848p;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AsrControlHandler */
/* renamed from: com.baidu.che.codriver.sdk.handler.a */
public class C2621a implements C2603a {
    /* renamed from: a */
    public static final String f8669a = "AsrControlHandler";
    /* renamed from: b */
    private List<String> f8670b = new CopyOnWriteArrayList();
    /* renamed from: c */
    private Map<String, C1979b> f8671c = new HashMap();
    /* renamed from: d */
    private C1979b f8672d;

    /* compiled from: AsrControlHandler */
    /* renamed from: com.baidu.che.codriver.sdk.handler.a$1 */
    class C26201 extends C1979b {
        /* renamed from: a */
        final /* synthetic */ C2621a f8668a;

        C26201(C2621a this$0) {
            this.f8668a = this$0;
        }

        public void onCommand(String type, String cmd) {
            for (Entry entry : this.f8668a.f8671c.entrySet()) {
                if (equals(entry.getValue())) {
                    C2575a.m9709a().m9730a("register_cmd", this.f8668a.m9855a(entry.getKey().toString(), type, cmd));
                }
            }
            C2725h.m10214e(C2621a.f8669a, "mSceneCommand onCommand(): type=" + type + " cmd=" + cmd);
        }
    }

    /* renamed from: a */
    public String mo1889a(String pkg, String cmdType, String param, String data) {
        C2725h.m10214e(f8669a, "onReceiveCommand-cmdType:" + cmdType + ";param:" + param);
        if (C2848p.af.equals(param)) {
            C2606l.m9828a().m9831a(pkg, cmdType);
        } else if ("open_dialog".equals(param)) {
            C2725h.m10214e(f8669a, "open_dialog-cmdType:" + cmdType + ";param:" + param);
            C2575a.m9709a().m9734c();
        } else if ("close_dialog".equals(param)) {
            C2725h.m10214e(f8669a, "close_dialog-cmdType:" + cmdType + ";param:" + param);
            C2575a.m9709a().m9735d();
        } else if (PlatformConstants.VALUE_START_RECORD.equals(param)) {
            C2725h.m10214e(f8669a, "start_record-cmdType:" + cmdType + ";param:" + param);
        } else if ("stop_record".equals(param)) {
            C2725h.m10214e(f8669a, "stop_record-cmdType:" + cmdType + ";param:" + param);
        } else if ("register_cmd".equals(param)) {
            m9858a(data);
        } else if ("unregister_cmd".equals(param)) {
            m9859b(data);
        } else if ("add_wakeup".equals(param)) {
            C2575a.m9709a().m9731a(data, false);
        }
        return null;
    }

    /* renamed from: a */
    public boolean m9858a(String data) {
        this.f8672d = new C26201(this);
        try {
            JSONObject dataObject = new JSONObject(data);
            JSONArray contentObject = dataObject.getJSONArray("cmd_content");
            String cmdId = dataObject.optString("cmd_id");
            if (this.f8671c.containsKey(cmdId)) {
                return false;
            }
            for (int x = 0; x < contentObject.length(); x++) {
                JSONObject tempObject = contentObject.optJSONObject(x);
                String cmdKey = tempObject.optString("cmd_key");
                JSONArray cmdTextArray = tempObject.getJSONArray("cmd_text");
                String[] cmdText = new String[cmdTextArray.length()];
                for (int i = 0; i < cmdTextArray.length(); i++) {
                    cmdText[i] = cmdTextArray.optString(i);
                }
                C2725h.m10214e(f8669a, "cmdKey:" + cmdKey + ";cmdText:" + cmdText[0].toString());
                this.f8672d.addCommand(cmdKey, cmdText);
            }
            this.f8671c.put(cmdId, this.f8672d);
            this.f8670b.add(cmdId);
            C2575a.m9709a().m9729a(this.f8672d);
            C2725h.m10214e(f8669a, "mCmdMap.size():" + this.f8671c.size());
            return true;
        } catch (JSONException e) {
            C2725h.m10214e(f8669a, e.getMessage().toString());
            return false;
        }
    }

    /* renamed from: b */
    public void m9859b(String data) {
        if (this.f8671c.containsKey(data)) {
            C2575a.m9709a().m9732b((C1979b) this.f8671c.get(data));
            this.f8671c.remove(data);
            this.f8670b.remove(data);
            C2725h.m10214e(f8669a, "mCmdMap.size():" + this.f8671c.size() + ";data=" + data);
        }
    }

    /* renamed from: a */
    private String m9855a(String cmdId, String cmdType, String cmdText) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("cmd_id", cmdId);
            JSONObject contentObject = new JSONObject();
            contentObject.put("cmd_key", cmdType);
            contentObject.put("cmd_text", cmdText);
            obj.put("cmd_content", contentObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
    }
}
