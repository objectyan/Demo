package com.baidu.tts.p241l.p242a;

import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
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

/* compiled from: GetServerDefaultModelsWork */
/* renamed from: com.baidu.tts.l.a.e */
public class C5116e implements Callable<ModelBags> {
    /* renamed from: a */
    private RequestHandle f21236a;

    public /* synthetic */ Object call() throws Exception {
        return m17345a();
    }

    /* renamed from: a */
    public ModelBags m17345a() throws Exception {
        SyncHttpClient syncHttpClient = new SyncHttpClient(true, 80, 443);
        String a = C5098o.MODEL_SERVER.m17287a();
        HttpEntity b = m17344b();
        Object c5112a = new C5112a();
        this.f21236a = syncHttpClient.post(null, a, b, "application/json", c5112a);
        return c5112a.m17340a();
    }

    /* renamed from: b */
    private StringEntity m17344b() throws UnsupportedEncodingException {
        try {
            JSONObject jSONObject = new JSONObject(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
            jSONObject.put(C5089g.FUNCTION.m17273a(), "getDefaultList");
            return new StringEntity(jSONObject.toString());
        } catch (JSONException e) {
            return null;
        }
    }
}
