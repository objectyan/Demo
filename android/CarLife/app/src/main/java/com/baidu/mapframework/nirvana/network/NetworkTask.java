package com.baidu.mapframework.nirvana.network;

import com.baidu.mapframework.nirvana.C3480g;
import org.apache.http.client.methods.HttpUriRequest;

public final class NetworkTask extends C3480g {
    /* renamed from: a */
    Runnable f19225a;
    /* renamed from: b */
    private String f19226b;
    /* renamed from: c */
    private HttpUriRequest f19227c;
    /* renamed from: d */
    private IResponseHandler f19228d;

    public NetworkTask(String url, HttpUriRequest httpUriRequest, IResponseHandler responseHandler, Runnable taskRunnable) {
        this.f19226b = url;
        this.f19227c = httpUriRequest;
        this.f19228d = responseHandler;
        this.f19225a = taskRunnable;
    }
}
