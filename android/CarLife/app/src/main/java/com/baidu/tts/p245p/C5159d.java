package com.baidu.tts.p245p;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.loopj.JsonHttpResponseHandler;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UploadStatisticsHandler */
/* renamed from: com.baidu.tts.p.d */
public class C5159d extends JsonHttpResponseHandler {
    /* renamed from: a */
    private TtsError f21298a;
    /* renamed from: b */
    private int f21299b = -1;

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        String str = null;
        if (errorResponse != null) {
            str = errorResponse.toString();
        }
        this.f21298a = C5105c.m17295a().m17298a(C5097n.MODEL_REQUEST_ERROR, statusCode, str, throwable);
    }

    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        int optInt = response.optInt(C5089g.ERROR_NUMBER.m17273a());
        String optString = response.optString(C5089g.ERROR_MESSAGE.m17273a());
        if (optInt == 0) {
            this.f21299b = optInt;
        } else {
            this.f21298a = C5105c.m17295a().m17297a(C5097n.MODEL_SERVER_ERROR, optInt, optString);
        }
    }

    /* renamed from: a */
    public int m17512a() {
        return this.f21299b;
    }
}
