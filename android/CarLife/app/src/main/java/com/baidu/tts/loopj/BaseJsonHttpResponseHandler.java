package com.baidu.tts.loopj;

import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {
    private static final String LOG_TAG = "BaseJsonHttpRH";

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
            Runnable c51271 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = BaseJsonHttpResponseHandler.this.parseResponse(responseString, false);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                BaseJsonHttpResponseHandler.this.onSuccess(statusCode, headers, responseString, parseResponse);
                            }
                        });
                    } catch (final Throwable th) {
                        AsyncHttpClient.log.mo3895d(BaseJsonHttpResponseHandler.LOG_TAG, "parseResponse thrown an problem", th);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                BaseJsonHttpResponseHandler.this.onFailure(statusCode, headers, th, responseString, null);
                            }
                        });
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                c51271.run();
                return;
            } else {
                new Thread(c51271).start();
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
            Runnable c51302 = new Runnable() {

                /* renamed from: com.baidu.tts.loopj.BaseJsonHttpResponseHandler$2$2 */
                class C51292 implements Runnable {
                    C51292() {
                    }

                    public void run() {
                        BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, null);
                    }
                }

                public void run() {
                    try {
                        final Object parseResponse = BaseJsonHttpResponseHandler.this.parseResponse(str, true);
                        BaseJsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                BaseJsonHttpResponseHandler.this.onFailure(i, headerArr, th, str, parseResponse);
                            }
                        });
                    } catch (Throwable th) {
                        AsyncHttpClient.log.mo3895d(BaseJsonHttpResponseHandler.LOG_TAG, "parseResponse thrown an problem", th);
                        BaseJsonHttpResponseHandler.this.postRunnable(new C51292());
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                c51302.run();
                return;
            } else {
                new Thread(c51302).start();
                return;
            }
        }
        onFailure(statusCode, headers, throwable, null, null);
    }
}
