package com.baidu.tts.p218b.p219a.p223b;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p213a.p214a.C4949a;
import com.baidu.tts.p213a.p214a.C4951b;
import com.baidu.tts.p218b.p219a.p223b.C5013f.C5010b;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p233f.C5086d;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.tools.CommonUtility;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TtsResponseHandler */
/* renamed from: com.baidu.tts.b.a.b.h */
public class C5015h extends C5014g {
    /* renamed from: a */
    private C4949a<byte[], byte[]> f20782a = new C4949a();
    /* renamed from: b */
    private C5010b f20783b;
    /* renamed from: c */
    private C5145h f20784c;

    public C5015h(C5145h c5145h) {
        this.f20784c = c5145h;
        this.f20782a.m16435a(new C4951b());
        this.f20782a.m16434a();
    }

    /* renamed from: a */
    public void m16869a(C5010b c5010b) {
        this.f20783b = c5010b;
    }

    /* renamed from: a */
    public void mo3852a(int i, Header[] headerArr, String str, HttpEntity httpEntity) {
        if ("application/json".equals(str)) {
            m16866c(httpEntity);
        } else {
            m16865b(httpEntity);
        }
    }

    /* renamed from: b */
    private void m16865b(HttpEntity httpEntity) {
        byte[] bytes;
        byte[] bArr = null;
        try {
            bytes = ("--" + "--BD**TTS++LIB").getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bytes = bArr;
        }
        try {
            bArr = EntityUtils.toByteArray(httpEntity);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        int indexOf = CommonUtility.indexOf(bArr, bytes, 0);
        if (indexOf < 0) {
            this.f20784c.m17419a(C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR));
            return;
        }
        int indexOf2 = CommonUtility.indexOf(bArr, bytes, bytes.length + indexOf);
        if (indexOf2 < 0) {
            this.f20784c.m17419a(C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR));
            return;
        }
        try {
            m16864a(new String(CommonUtility.copyBytesOfRange(bArr, indexOf + bytes.length, indexOf2), "utf-8"));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        indexOf = CommonUtility.indexOf(bArr, bytes, bytes.length + indexOf2);
        if (indexOf >= 0) {
            this.f20784c.m17424a(CommonUtility.copyBytesOfRange(bArr, bytes.length + indexOf2, indexOf));
        }
    }

    /* renamed from: c */
    private void m16866c(HttpEntity httpEntity) {
        String str = null;
        try {
            str = EntityUtils.toString(httpEntity, C5086d.UTF8.m17269a());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        m16864a(str);
    }

    /* renamed from: a */
    private void m16864a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(C5089g.ERROR_NUMBER.m17273a());
            LoggerProxy.m17001d("TtsResponseHandler", "parseJSON errNo=" + optInt);
            this.f20784c.m17418a(optInt);
            if (optInt != 0) {
                this.f20784c.m17419a(C5105c.m17295a().m17297a(C5097n.ONLINE_ENGINE_REQUEST_RESULT_ERROR, optInt, jSONObject.getString(C5089g.ERROR_MESSAGE.m17273a())));
                return;
            }
            this.f20784c.m17423a(jSONObject.optString(C5089g.SERIAL_NUMBER.m17273a()));
            this.f20784c.m17426b(jSONObject.optInt(C5089g.INDEX.m17273a()));
            this.f20784c.m17429d(jSONObject.optInt(C5089g.PERCENT.m17274b()));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo3853a(int i, Header[] headerArr, String str, HttpEntity httpEntity, Throwable th) {
        LoggerProxy.m17001d("TtsResponseHandler", "onFailure error = " + th.getMessage());
        this.f20784c.m17419a(C5105c.m17295a().m17298a(C5097n.ONLINE_ENGINE_HTTP_REQUEST_FAILURE, i, null, th));
    }
}
