package com.baidu.tts.p229d.p230a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.RangeFileAsyncHttpResponseHandler;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import java.io.File;
import org.apache.http.Header;

/* compiled from: ModelFileResponseHandler */
/* renamed from: com.baidu.tts.d.a.g */
public class C5045g extends RangeFileAsyncHttpResponseHandler {
    /* renamed from: a */
    private C5049c f20893a;

    public C5045g(File file, C5049c c5049c) {
        super(file);
        this.f20893a = c5049c;
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
        String str = null;
        if (throwable != null) {
            Throwable cause = throwable.getCause();
            if (cause == null) {
                str = throwable.getMessage();
            } else {
                str = cause.getMessage();
            }
        }
        LoggerProxy.m17001d("ModelFileResponseHandler", "onFailure statuscode=" + statusCode + "--msg=" + str);
        this.f20893a.m17076a(C5105c.m17295a().m17298a(C5097n.MODEL_REQUEST_ERROR, statusCode, "download failure", throwable));
    }

    public void onSuccess(int statusCode, Header[] headers, File file) {
        LoggerProxy.m17001d("ModelFileResponseHandler", "onSuccess");
        this.f20893a.m17081e();
    }

    public void onProgress(long bytesWritten, long totalSize) {
        this.f20893a.m17075a(bytesWritten, totalSize);
    }
}
