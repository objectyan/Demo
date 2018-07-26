package com.tencent.wxop.stat;

import com.baidu.navisdk.util.common.HttpsClient;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

class ax extends DefaultConnectionKeepAliveStrategy {
    /* renamed from: a */
    final /* synthetic */ aw f24868a;

    ax(aw awVar) {
        this.f24868a = awVar;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? HttpsClient.CONN_MGR_TIMEOUT : keepAliveDuration;
    }
}
