package com.baidu.mapframework.nirvana.runtime.http;

import android.text.TextUtils;
import com.baidu.mapframework.commonlib.asynchttp.AsyncHttpClient;
import com.baidu.mapframework.commonlib.asynchttp.RequestParams;
import com.baidu.mapframework.commonlib.asynchttp.ResponseHandlerInterface;
import com.baidu.mapframework.commonlib.asynchttp.SyncHttpClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

public class HttpRequestManager {
    /* renamed from: a */
    private int f19236a = 10000;
    /* renamed from: b */
    private String f19237b;
    /* renamed from: c */
    private final byte[] f19238c = new byte[0];
    /* renamed from: d */
    private AsyncHttpClient f19239d;
    /* renamed from: e */
    private SyncHttpClient f19240e;
    /* renamed from: f */
    private CookieStore f19241f = new BasicCookieStore();

    public HttpRequestManager(int timeOut, String cookiePolicy) {
        this.f19236a = timeOut;
        this.f19237b = cookiePolicy;
    }

    public void cancelAllRequests(boolean mayInterruptIfRunning) {
        if (this.f19239d != null) {
            this.f19239d.cancelAllRequests(mayInterruptIfRunning);
        }
        if (this.f19240e != null) {
            this.f19240e.cancelAllRequests(mayInterruptIfRunning);
        }
    }

    /* renamed from: a */
    private void m15219a(boolean isSync) {
        synchronized (this.f19238c) {
            if (Utils.isOnUiThread()) {
                if (this.f19239d == null) {
                    this.f19239d = new AsyncHttpClient();
                }
                this.f19239d.setTimeout(this.f19236a);
                if (!TextUtils.isEmpty(this.f19237b)) {
                    HttpClientParams.setCookiePolicy(this.f19239d.getHttpClient().getParams(), this.f19237b);
                }
            } else {
                if (this.f19240e == null) {
                    this.f19240e = new SyncHttpClient();
                }
                this.f19240e.setTimeout(this.f19236a);
                if (!TextUtils.isEmpty(this.f19237b)) {
                    HttpClientParams.setCookiePolicy(this.f19240e.getHttpClient().getParams(), this.f19237b);
                }
            }
        }
    }

    public void setCookieStore(CookieStore cookieStore) {
        if (cookieStore != null) {
            m15219a(false);
            if (this.f19239d != null) {
                this.f19239d.setCookieStore(cookieStore);
            }
            if (this.f19240e != null) {
                this.f19240e.setCookieStore(cookieStore);
            }
        }
    }

    public void getRequest(String baseUrl, HashMap<String, String> headers, HashMap<String, String> urlParams, ResponseHandlerInterface responseHandler) {
        getRequest(false, baseUrl, headers, urlParams, responseHandler);
    }

    public void getRequest(boolean isSync, String baseUrl, HashMap<String, String> headers, HashMap<String, String> urlParams, ResponseHandlerInterface responseHandler) {
        boolean z = isSync;
        String str = baseUrl;
        m15222b(z, str, m15221a((HashMap) headers), new RequestParams((Map) urlParams), responseHandler);
    }

    public void postRequest(boolean isSync, String baseUrl, HashMap<String, String> headers, HashMap<String, String> bodyParams, HashMap<String, File> fileParams, HashMap<String, InputStream> inputStreamHashMap, ResponseHandlerInterface responseHandler) {
        RequestParams requestParams = new RequestParams((Map) bodyParams);
        if (!(fileParams == null || fileParams.isEmpty())) {
            for (Entry<String, File> pair : fileParams.entrySet()) {
                try {
                    requestParams.put((String) pair.getKey(), (File) pair.getValue());
                } catch (FileNotFoundException e) {
                }
            }
        }
        if (!(inputStreamHashMap == null || inputStreamHashMap.isEmpty())) {
            for (Entry<String, InputStream> pair2 : inputStreamHashMap.entrySet()) {
                try {
                    requestParams.put((String) pair2.getKey(), (InputStream) pair2.getValue());
                } catch (Exception e2) {
                }
            }
        }
        m15220a(isSync, baseUrl, m15221a((HashMap) headers), requestParams, responseHandler);
    }

    /* renamed from: a */
    private Header[] m15221a(HashMap<String, String> params) {
        if (m15223b(params)) {
            params.remove("Cookie");
        }
        Header[] headerParams = null;
        if (params != null) {
            headerParams = new Header[params.size()];
            int index = 0;
            for (String key : params.keySet()) {
                headerParams[index] = new BasicHeader(key, (String) params.get(key));
                index++;
            }
        }
        return headerParams;
    }

    /* renamed from: b */
    private boolean m15223b(HashMap<String, String> params) {
        String cookieString = "";
        if (params != null) {
            cookieString = (String) params.get("Cookie");
        }
        if (cookieString == null || cookieString.isEmpty()) {
            return false;
        }
        String[] cookiePairs = cookieString.split(";");
        if (cookiePairs == null || cookiePairs.length <= 0) {
            return true;
        }
        this.f19241f.clear();
        for (String pair : cookiePairs) {
            String[] entry = pair.split("=", 2);
            if (entry != null && entry.length == 2) {
                BasicClientCookie cookie = new BasicClientCookie(entry[0], entry[1]);
                cookie.setDomain(".baidu.com");
                cookie.setPath("/");
                cookie.setVersion(0);
                this.f19241f.addCookie(cookie);
                BasicClientCookie cookieNuomi = new BasicClientCookie(entry[0], entry[1]);
                cookieNuomi.setDomain(".nuomi.com");
                cookieNuomi.setPath("/");
                cookieNuomi.setVersion(0);
                this.f19241f.addCookie(cookieNuomi);
            }
        }
        setCookieStore(this.f19241f);
        return true;
    }

    public void postRequest(String baseUrl, HashMap<String, String> headers, HashMap<String, String> bodyParams, ResponseHandlerInterface responseHandler) {
        postRequest(false, baseUrl, headers, bodyParams, null, null, responseHandler);
    }

    public void postRequest(String baseUrl, HashMap<String, String> headers, HashMap<String, String> bodyParams, HashMap<String, File> fileParams, ResponseHandlerInterface responseHandler) {
        postRequest(false, baseUrl, headers, bodyParams, fileParams, null, responseHandler);
    }

    public void postRequest(boolean isSync, String url, HashMap<String, String> headers, HttpEntity httpEntity, ResponseHandlerInterface responseHandler) {
        if (isSync) {
            Utils.assertNotOnUiThread();
        }
        m15219a(isSync);
        Header[] headerParams = m15221a((HashMap) headers);
        if (Utils.isOnUiThread()) {
            this.f19239d.post(null, url, headerParams, httpEntity, null, responseHandler);
        } else {
            this.f19240e.post(null, url, headerParams, httpEntity, null, responseHandler);
        }
    }

    public void putRequest(boolean isSync, String url, HashMap<String, String> headers, HttpEntity httpEntity, ResponseHandlerInterface responseHandler) {
        if (isSync) {
            Utils.assertNotOnUiThread();
        }
        m15219a(isSync);
        Header[] headerParams = m15221a((HashMap) headers);
        if (Utils.isOnUiThread()) {
            this.f19239d.put(null, url, headerParams, httpEntity, null, responseHandler);
        } else {
            this.f19240e.put(null, url, headerParams, httpEntity, null, responseHandler);
        }
    }

    /* renamed from: a */
    private void m15220a(boolean isSync, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        if (isSync) {
            Utils.assertNotOnUiThread();
        }
        m15219a(isSync);
        if (Utils.isOnUiThread()) {
            this.f19239d.post(null, url, headers, params, null, responseHandler);
        } else {
            this.f19240e.post(null, url, headers, params, null, responseHandler);
        }
    }

    /* renamed from: b */
    private void m15222b(boolean isSync, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        if (isSync) {
            Utils.assertNotOnUiThread();
        }
        m15219a(isSync);
        if (Utils.isOnUiThread()) {
            this.f19239d.get(null, url, headers, params, responseHandler);
        } else {
            this.f19240e.get(null, url, headers, params, responseHandler);
        }
    }

    public void putRequest(boolean isSync, String url, HashMap<String, String> headerParams, HashMap<String, String> bodyParams, HashMap<String, File> fileParams, HashMap<String, InputStream> streamHashMap, ResponseHandlerInterface responseHandler) {
        Header[] headers = m15221a((HashMap) headerParams);
        RequestParams requestParams = new RequestParams((Map) bodyParams);
        if (!(fileParams == null || fileParams.isEmpty())) {
            for (Entry<String, File> pair : fileParams.entrySet()) {
                try {
                    requestParams.put((String) pair.getKey(), (File) pair.getValue());
                } catch (FileNotFoundException e) {
                }
            }
        }
        if (!(streamHashMap == null || streamHashMap.isEmpty())) {
            for (Entry<String, InputStream> pair2 : streamHashMap.entrySet()) {
                try {
                    requestParams.put((String) pair2.getKey(), (InputStream) pair2.getValue());
                } catch (Exception e2) {
                }
            }
        }
        m15224c(isSync, url, headers, requestParams, responseHandler);
    }

    public void deleteRequest(boolean isSync, String url, HashMap<String, String> headers, HashMap<String, String> body, ResponseHandlerInterface responseHandler) {
        m15225d(isSync, url, m15221a((HashMap) headers), new RequestParams((Map) body), responseHandler);
    }

    /* renamed from: c */
    private void m15224c(boolean isSync, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        if (isSync) {
            Utils.assertNotOnUiThread();
        }
        m15219a(isSync);
        HttpEntity entity;
        if (Utils.isOnUiThread()) {
            entity = null;
            try {
                entity = params.getEntity(responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f19239d.put(null, url, headers, entity, null, responseHandler);
            return;
        }
        entity = null;
        try {
            entity = params.getEntity(responseHandler);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f19240e.put(null, url, headers, entity, null, responseHandler);
    }

    /* renamed from: d */
    private void m15225d(boolean isSync, String url, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        if (isSync) {
            Utils.assertNotOnUiThread();
        }
        m15219a(isSync);
        if (Utils.isOnUiThread()) {
            this.f19239d.delete(null, url, headers, params, responseHandler);
        } else {
            this.f19240e.delete(null, url, headers, params, responseHandler);
        }
    }
}
