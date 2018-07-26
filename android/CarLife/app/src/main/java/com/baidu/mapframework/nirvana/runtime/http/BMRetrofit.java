package com.baidu.mapframework.nirvana.runtime.http;

public class BMRetrofit {
    /* renamed from: a */
    String f19229a;
    /* renamed from: b */
    private HttpRequestManager f19230b;
    /* renamed from: c */
    private int f19231c = 10000;

    public BMRetrofit setTimeout(int value) {
        this.f19231c = value;
        return this;
    }

    public BMRetrofit setCookiePolicy(String cookiePolicy) {
        this.f19229a = cookiePolicy;
        return this;
    }

    public BMRetrofit cancelAllRequests(boolean mayInterruptIfRunning) {
        if (this.f19230b != null) {
            this.f19230b.cancelAllRequests(mayInterruptIfRunning);
        }
        return this;
    }

    public synchronized HttpRequestManager build() {
        if (this.f19230b == null) {
            this.f19230b = new HttpRequestManager(this.f19231c, this.f19229a);
        }
        return this.f19230b;
    }
}
