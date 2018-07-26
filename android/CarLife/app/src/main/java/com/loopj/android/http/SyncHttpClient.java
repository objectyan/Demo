package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.p158b.p159d.C6034q;
import cz.msebera.android.httpclient.p162e.p169c.C3024j;
import cz.msebera.android.httpclient.p173i.p175b.C3059s;
import cz.msebera.android.httpclient.p185n.C6198g;

public class SyncHttpClient extends AsyncHttpClient {
    public SyncHttpClient() {
        super(false, 80, 443);
    }

    public SyncHttpClient(int httpPort) {
        super(false, httpPort, 443);
    }

    public SyncHttpClient(int httpPort, int httpsPort) {
        super(false, httpPort, httpsPort);
    }

    public SyncHttpClient(boolean fixNoHttpResponseException, int httpPort, int httpsPort) {
        super(fixNoHttpResponseException, httpPort, httpsPort);
    }

    public SyncHttpClient(C3024j schemeRegistry) {
        super(schemeRegistry);
    }

    protected RequestHandle sendRequest(C3059s client, C6198g httpContext, C6034q uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        if (contentType != null) {
            uriRequest.addHeader("Content-Type", contentType);
        }
        responseHandler.setUseSynchronousMode(true);
        newAsyncHttpRequest(client, httpContext, uriRequest, contentType, responseHandler, context).run();
        return new RequestHandle(null);
    }
}
