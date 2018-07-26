package com.baidu.tts.p241l.p242a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5098o;
import com.baidu.tts.tools.JsonTool;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetServerModelFileInfosWork */
/* renamed from: com.baidu.tts.l.a.f */
public class C5117f implements Callable<ModelFileBags> {
    /* renamed from: a */
    private RequestHandle f21237a;
    /* renamed from: b */
    private Set<String> f21238b;

    public /* synthetic */ Object call() throws Exception {
        return m17347a();
    }

    public C5117f(Set<String> set) {
        this.f21238b = set;
    }

    /* renamed from: a */
    public ModelFileBags m17347a() throws Exception {
        SyncHttpClient syncHttpClient = new SyncHttpClient(true, 80, 443);
        String str = C5098o.MODEL_SERVER.m17287a() + "https=1";
        HttpEntity b = m17346b();
        Object c5115d = new C5115d();
        this.f21237a = syncHttpClient.post(null, str, b, "application/json", c5115d);
        return c5115d.m17343a();
    }

    /* renamed from: b */
    private StringEntity m17346b() throws UnsupportedEncodingException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C5089g.FUNCTION.m17273a(), "getURL");
            jSONObject.put(C5089g.IVERSION.m17274b(), "1");
            jSONObject.put(C5089g.ID.m17274b(), JsonTool.fromSetToJson(this.f21238b));
            String jSONObject2 = jSONObject.toString();
            LoggerProxy.m17001d("GetServerModelFileInfosWork", "geturl params=" + jSONObject2);
            return new StringEntity(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }
}
