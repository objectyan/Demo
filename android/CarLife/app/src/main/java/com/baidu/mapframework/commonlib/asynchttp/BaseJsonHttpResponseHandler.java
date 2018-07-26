package com.baidu.mapframework.commonlib.asynchttp;

import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {
    /* renamed from: a */
    private static final String f18849a = "BaseJsonHttpRH";

    public abstract void onFailure(int i, Header[] headerArr, Throwable th, String str, JSON_TYPE json_type);

    public abstract void onSuccess(int i, Header[] headerArr, String str, JSON_TYPE json_type);

    protected abstract JSON_TYPE parseResponse(String str, boolean z) throws Throwable;

    public BaseJsonHttpResponseHandler() {
        this("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String encoding) {
        super(encoding);
    }

    public final void onSuccess(final int statusCode, final Header[] headers, final String responseString) {
        if (statusCode != 204) {
            Runnable parser = new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ BaseJsonHttpResponseHandler f18840d;

                public void run() {
                    try {
                        final JSON_TYPE jsonResponse = this.f18840d.parseResponse(responseString, false);
                        this.f18840d.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C34941 f18834b;

                            public void run() {
                                this.f18834b.f18840d.onSuccess(statusCode, headers, responseString, jsonResponse);
                            }
                        });
                    } catch (final Throwable t) {
                        AsyncHttpClient.log.mo2624d(BaseJsonHttpResponseHandler.f18849a, "parseResponse thrown an problem", t);
                        this.f18840d.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C34941 f18836b;

                            public void run() {
                                this.f18836b.f18840d.onFailure(statusCode, headers, t, responseString, null);
                            }
                        });
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                parser.run();
                return;
            } else {
                new Thread(parser).start();
                return;
            }
        }
        onSuccess(statusCode, headers, null, null);
    }

    public final void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        if (responseString != null) {
            final String str = responseString;
            final int i = statusCode;
            final Header[] headerArr = headers;
            final Throwable th = throwable;
            Runnable parser = new Runnable(this) {
                /* renamed from: e */
                final /* synthetic */ BaseJsonHttpResponseHandler f18848e;

                /* renamed from: com.baidu.mapframework.commonlib.asynchttp.BaseJsonHttpResponseHandler$2$2 */
                class C34962 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C34972 f18843a;

                    C34962(C34972 this$1) {
                        this.f18843a = this$1;
                    }

                    public void run() {
                        this.f18843a.f18848e.onFailure(i, headerArr, th, str, null);
                    }
                }

                public void run() {
                    try {
                        final JSON_TYPE jsonResponse = this.f18848e.parseResponse(str, true);
                        this.f18848e.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C34972 f18842b;

                            public void run() {
                                this.f18842b.f18848e.onFailure(i, headerArr, th, str, jsonResponse);
                            }
                        });
                    } catch (Throwable t) {
                        AsyncHttpClient.log.mo2624d(BaseJsonHttpResponseHandler.f18849a, "parseResponse thrown an problem", t);
                        this.f18848e.postRunnable(new C34962(this));
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                parser.run();
                return;
            } else {
                new Thread(parser).start();
                return;
            }
        }
        onFailure(statusCode, headers, throwable, null, null);
    }
}
