package com.baidu.tts.p241l.p242a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.loopj.JsonHttpResponseHandler;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetModelFileInfosHttpHandler */
/* renamed from: com.baidu.tts.l.a.d */
public class C5115d extends JsonHttpResponseHandler {
    /* renamed from: a */
    private TtsError f21234a;
    /* renamed from: b */
    private ModelFileBags f21235b;

    /* renamed from: a */
    public ModelFileBags m17343a() {
        return this.f21235b;
    }

    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        LoggerProxy.m17001d("GetModelFileInfosHttpHandler", "onSuccess response=" + response);
        int optInt = response.optInt(C5089g.ERROR_NUMBER.m17273a());
        String optString = response.optString(C5089g.ERROR_MESSAGE.m17273a());
        if (optInt == 0 || optInt == -4005) {
            JSONArray optJSONArray = response.optJSONArray(C5089g.DATA.m17274b());
            this.f21235b = new ModelFileBags();
            this.f21235b.parseJson(optJSONArray);
            return;
        }
        this.f21234a = C5105c.m17295a().m17297a(C5097n.MODEL_SERVER_ERROR, optInt, optString);
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        LoggerProxy.m17001d("GetModelFileInfosHttpHandler", "onFailure1");
        this.f21234a = C5105c.m17295a().m17298a(C5097n.MODEL_REQUEST_ERROR, statusCode, responseString, throwable);
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        LoggerProxy.m17001d("GetModelFileInfosHttpHandler", "onFailure2");
        String str = null;
        if (errorResponse != null) {
            str = errorResponse.toString();
        }
        this.f21234a = C5105c.m17295a().m17298a(C5097n.MODEL_REQUEST_ERROR, statusCode, str, throwable);
    }
}
