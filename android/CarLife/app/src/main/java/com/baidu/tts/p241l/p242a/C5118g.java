package com.baidu.tts.p241l.p242a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5098o;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetServerModelsWork */
/* renamed from: com.baidu.tts.l.a.g */
public class C5118g implements Callable<ModelBags> {
    /* renamed from: a */
    private Conditions f21239a;
    /* renamed from: b */
    private RequestHandle f21240b;

    public /* synthetic */ Object call() throws Exception {
        return m17349a();
    }

    public C5118g(Conditions conditions) {
        this.f21239a = conditions;
    }

    /* renamed from: a */
    public ModelBags m17349a() throws Exception {
        SyncHttpClient syncHttpClient = new SyncHttpClient(true, 80, 443);
        String a = C5098o.MODEL_SERVER.m17287a();
        HttpEntity b = m17348b();
        Object c5112a = new C5112a();
        this.f21240b = syncHttpClient.post(null, a, b, "application/json", c5112a);
        return c5112a.m17340a();
    }

    /* renamed from: b */
    private StringEntity m17348b() throws UnsupportedEncodingException {
        JSONObject jSONConditions = this.f21239a.getJSONConditions();
        try {
            jSONConditions.put(C5089g.IVERSION.m17274b(), "1");
            jSONConditions.put(C5089g.FUNCTION.m17273a(), "getList");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject = jSONConditions.toString();
        LoggerProxy.m17001d("GetServerModelsWork", "getlist params=" + jSONObject);
        return new StringEntity(jSONObject);
    }
}
