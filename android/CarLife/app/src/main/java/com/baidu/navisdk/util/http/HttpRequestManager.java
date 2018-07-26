package com.baidu.navisdk.util.http;

import android.os.Bundle;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class HttpRequestManager {
    private static volatile HttpRequestManager mInstance;
    private Map<String, Set<String>> ip2HostsMap = new ConcurrentHashMap();

    private HttpRequestManager() {
    }

    public static HttpRequestManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpRequestManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpRequestManager();
                }
            }
        }
        return mInstance;
    }

    public synchronized HttpGet getHttpGet(String url) {
        HttpGet httpGet;
        httpGet = new HttpGet(url);
        doDnsProxy(httpGet);
        return httpGet;
    }

    public synchronized HttpPost getHttpPost(String url) {
        HttpPost httpPost;
        httpPost = new HttpPost(url);
        doDnsProxy(httpPost);
        return httpPost;
    }

    private void doDnsProxy(HttpRequestBase uriRequest) {
        URI uri = uriRequest.getURI();
        String url = uri.toString();
        String host = uri.getHost();
        String request = BNaviEngineManager.getInstance().getIPByHost(host);
        if (!StringUtils.isEmpty(request)) {
            Bundle bd = new Bundle();
            bd.putString("IP", request);
            bd.putString("HOST", host);
            BNaviModuleManager.putIP2DomainsRecord(bd);
            url = url.replace(host, request);
            uriRequest.setURI(URI.create(url));
            uriRequest.addHeader("Host", host);
        }
        LogUtil.m15791e("HttpRequestManager", "  doDnsProxy  url: " + url + "    request: " + request);
    }

    public void putIP2DomainsRecord(String ip, String domain) {
        Set<String> hosts = (Set) this.ip2HostsMap.get(ip);
        if (hosts == null) {
            hosts = new HashSet();
            this.ip2HostsMap.put(ip, hosts);
        }
        hosts.add(domain);
    }

    public Set<String> getDomains(String ip) {
        return (Set) this.ip2HostsMap.get(ip);
    }

    public void clear() {
        this.ip2HostsMap.clear();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        SSLSocketFactory sslSocketFactory = SSLSocketFactory.getSocketFactory();
        sslSocketFactory.setHostnameVerifier(new NavDNSProxyCompatX509HostnameVerifier(sslSocketFactory.getHostnameVerifier()));
        return sslSocketFactory;
    }
}
