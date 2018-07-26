package com.baidu.navisdk.util.common;

import com.facebook.common.p141m.C2924g;
import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpsClient extends DefaultHttpClient {
    public static final String CHARSET = "UTF-8";
    public static final long CONN_MGR_TIMEOUT = 30000;
    public static final int CONN_TIMEOUT = 60000;
    public static final int MAX_CONNS_PER_ROUTE = 2;
    public static final int MAX_TOTAL_CONNECTIONS = 4;
    public static final int SOCKET_TIMEOUT = 60000;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-cn; HTC_DesireS_S510e Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1";

    private HttpsClient(ClientConnectionManager connManager, HttpParams params) {
        super(connManager, params);
    }

    public static synchronized HttpsClient getHttpClient() {
        HttpsClient httpsClient;
        synchronized (HttpsClient.class) {
            HttpParams params = new BasicHttpParams();
            params.setParameter("http.protocol.handle-redirects", Boolean.valueOf(false));
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, "UTF-8");
            HttpProtocolParams.setUseExpectContinue(params, false);
            HttpProtocolParams.setUserAgent(params, USER_AGENT);
            ConnManagerParams.setMaxTotalConnections(params, 4);
            ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(2));
            ConnManagerParams.setTimeout(params, CONN_MGR_TIMEOUT);
            HttpConnectionParams.setConnectionTimeout(params, 60000);
            HttpConnectionParams.setSoTimeout(params, 60000);
            SSLSocketFactory sslSocketFactory = SSLSocketFactory.getSocketFactory();
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(C2924g.f12888b, sslSocketFactory, 443));
            httpsClient = new HttpsClient(new SingleClientConnManager(params, schemeRegistry), params);
        }
        return httpsClient;
    }
}
