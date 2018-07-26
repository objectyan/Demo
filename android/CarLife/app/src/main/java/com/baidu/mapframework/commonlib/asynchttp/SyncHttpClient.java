package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import java.net.URI;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

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

    public SyncHttpClient(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }

    protected RequestHandle sendRequest(DefaultHttpClient client, HttpContext httpContext, HttpUriRequest uriRequest, String contentType, ResponseHandlerInterface responseHandler, Context context) {
        if (contentType != null) {
            uriRequest.addHeader("Content-Type", contentType);
        }
        responseHandler.setUseSynchronousMode(true);
        URI uri = uriRequest.getURI();
        String url = uri.toString();
        String host = uri.getHost();
        if (sDNS_PROXY != null) {
            String ip = sDNS_PROXY.getIP(host);
            if (!(ip == null || ip.equals(""))) {
                sDNS_PROXY.putIP2DomainsRecord(ip, host);
                url = url.replace(host, ip);
                if (uriRequest instanceof HttpRequestBase) {
                    ((HttpRequestBase) uriRequest).setURI(URI.create(url));
                }
                uriRequest.setHeader(AsyncHttpClient.HEADER_ORG_HOST, host);
            }
        }
        newAsyncHttpRequest(client, httpContext, uriRequest, contentType, responseHandler, context).run();
        return new RequestHandle(null);
    }
}
