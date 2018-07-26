package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

public class NirvanaAsyncHttpClient extends AsyncHttpClient {
    public ExecutorService getThreadPool() {
        return super.getThreadPool();
    }

    protected ExecutorService getDefaultThreadPool() {
        return super.getDefaultThreadPool();
    }

    public RequestHandle get(String url, NirvanaResponseHandlerInterface responseHandler) {
        return get(null, url, null, responseHandler);
    }

    public RequestHandle get(String url, RequestParams params, NirvanaResponseHandlerInterface responseHandler) {
        return get(null, url, params, responseHandler);
    }

    public RequestHandle get(Context context, String url, NirvanaResponseHandlerInterface responseHandler) {
        return get(context, url, null, responseHandler);
    }

    public RequestHandle get(Context context, String url, RequestParams params, NirvanaResponseHandlerInterface responseHandler) {
        return sendNirvanaRequest(this.httpClient, this.httpContext, new HttpGet(AsyncHttpClient.getUrlWithQueryString(this.b, url, params)), null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, Header[] headers, RequestParams params, NirvanaResponseHandlerInterface responseHandler) {
        HttpUriRequest request = new HttpGet(AsyncHttpClient.getUrlWithQueryString(this.b, url, params));
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendNirvanaRequest(this.httpClient, this.httpContext, request, null, responseHandler, context);
    }

    public RequestHandle get(Context context, String url, HttpEntity entity, String contentType, NirvanaResponseHandlerInterface responseHandler) {
        return sendNirvanaRequest(this.httpClient, this.httpContext, m14930a(new HttpGet(URI.create(url).normalize()), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(String url, NirvanaResponseHandlerInterface responseHandler) {
        return post(null, url, null, responseHandler);
    }

    public RequestHandle post(String url, RequestParams params, NirvanaResponseHandlerInterface responseHandler) {
        return post(null, url, params, responseHandler);
    }

    public RequestHandle post(Context context, String url, RequestParams params, NirvanaResponseHandlerInterface responseHandler) {
        return post(context, url, m14929a(params, (ResponseHandlerInterface) responseHandler), null, responseHandler);
    }

    public RequestHandle post(Context context, String url, HttpEntity entity, String contentType, NirvanaResponseHandlerInterface responseHandler) {
        return sendRequest(this.httpClient, this.httpContext, m14930a(new HttpPost(getURI(url)), entity), contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, RequestParams params, String contentType, NirvanaResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = new HttpPost(getURI(url));
        if (params != null) {
            request.setEntity(m14929a(params, (ResponseHandlerInterface) responseHandler));
        }
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }

    public RequestHandle post(Context context, String url, Header[] headers, HttpEntity entity, String contentType, NirvanaResponseHandlerInterface responseHandler) {
        HttpEntityEnclosingRequestBase request = m14930a(new HttpPost(getURI(url)), entity);
        if (headers != null) {
            request.setHeaders(headers);
        }
        return sendRequest(this.httpClient, this.httpContext, request, contentType, responseHandler, context);
    }
}
