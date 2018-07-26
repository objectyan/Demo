package com.baidu.tts.p218b.p219a.p223b;

import com.baidu.tts.loopj.AsyncHttpResponseHandler;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

/* compiled from: ResponseHandler */
/* renamed from: com.baidu.tts.b.a.b.g */
public abstract class C5014g extends AsyncHttpResponseHandler {
    /* renamed from: a */
    private String f20780a;
    /* renamed from: b */
    private HttpEntity f20781b;

    /* renamed from: a */
    public abstract void mo3852a(int i, Header[] headerArr, String str, HttpEntity httpEntity);

    /* renamed from: a */
    public abstract void mo3853a(int i, Header[] headerArr, String str, HttpEntity httpEntity, Throwable th);

    public void sendResponseMessage(HttpResponse response) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = response.getStatusLine();
            this.f20781b = response.getEntity();
            this.f20780a = m16861a(this.f20781b);
            if (!Thread.currentThread().isInterrupted()) {
                if (statusLine.getStatusCode() >= 300) {
                    sendFailureMessage(statusLine.getStatusCode(), response.getAllHeaders(), null, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
                } else {
                    sendSuccessMessage(statusLine.getStatusCode(), response.getAllHeaders(), null);
                }
            }
        }
    }

    /* renamed from: a */
    String m16861a(HttpEntity httpEntity) {
        Header contentType = httpEntity.getContentType();
        if (contentType != null) {
            if ("application/json".equals(contentType.getValue())) {
                return "application/json";
            }
        }
        return null;
    }

    public void onSuccess(int statusCode, Header[] headers, byte[] flag) {
        mo3852a(statusCode, headers, this.f20780a, this.f20781b);
    }

    public void onFailure(int statusCode, Header[] headers, byte[] flag, Throwable error) {
        mo3853a(statusCode, headers, this.f20780a, this.f20781b, error);
    }
}
