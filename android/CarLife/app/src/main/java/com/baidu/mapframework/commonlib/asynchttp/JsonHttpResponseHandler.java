package com.baidu.mapframework.commonlib.asynchttp;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    /* renamed from: a */
    private static final String f18868a = "JsonHttpRH";
    protected boolean useRFC5179CompatibilityMode = true;

    public JsonHttpResponseHandler() {
        super("UTF-8");
    }

    public JsonHttpResponseHandler(String encoding) {
        super(encoding);
    }

    public JsonHttpResponseHandler(boolean useRFC5179CompatibilityMode) {
        super("UTF-8");
        this.useRFC5179CompatibilityMode = useRFC5179CompatibilityMode;
    }

    public JsonHttpResponseHandler(String encoding, boolean useRFC5179CompatibilityMode) {
        super(encoding);
        this.useRFC5179CompatibilityMode = useRFC5179CompatibilityMode;
    }

    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        AsyncHttpClient.log.mo2636w(f18868a, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        AsyncHttpClient.log.mo2636w(f18868a, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        AsyncHttpClient.log.mo2637w(f18868a, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        AsyncHttpClient.log.mo2637w(f18868a, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        AsyncHttpClient.log.mo2637w(f18868a, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", throwable);
    }

    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        AsyncHttpClient.log.mo2636w(f18868a, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public final void onSuccess(final int statusCode, final Header[] headers, final byte[] responseBytes) {
        if (statusCode != 204) {
            Runnable parser = new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ JsonHttpResponseHandler f18858d;

                public void run() {
                    try {
                        final Object jsonResponse = this.f18858d.parseResponse(responseBytes);
                        this.f18858d.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C35001 f18852b;

                            public void run() {
                                if (!this.f18852b.f18858d.useRFC5179CompatibilityMode && jsonResponse == null) {
                                    this.f18852b.f18858d.onSuccess(statusCode, headers, (String) null);
                                } else if (jsonResponse instanceof JSONObject) {
                                    this.f18852b.f18858d.onSuccess(statusCode, headers, (JSONObject) jsonResponse);
                                } else if (jsonResponse instanceof JSONArray) {
                                    this.f18852b.f18858d.onSuccess(statusCode, headers, (JSONArray) jsonResponse);
                                } else if (!(jsonResponse instanceof String)) {
                                    this.f18852b.f18858d.onFailure(statusCode, headers, new JSONException("Unexpected response type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                } else if (this.f18852b.f18858d.useRFC5179CompatibilityMode) {
                                    this.f18852b.f18858d.onFailure(statusCode, headers, (String) jsonResponse, new JSONException("Response cannot be parsed as JSON data"));
                                } else {
                                    this.f18852b.f18858d.onSuccess(statusCode, headers, (String) jsonResponse);
                                }
                            }
                        });
                    } catch (final JSONException ex) {
                        this.f18858d.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C35001 f18854b;

                            public void run() {
                                this.f18854b.f18858d.onFailure(statusCode, headers, ex, (JSONObject) null);
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
        onSuccess(statusCode, headers, new JSONObject());
    }

    public final void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
        if (responseBytes != null) {
            final byte[] bArr = responseBytes;
            final int i = statusCode;
            final Header[] headerArr = headers;
            final Throwable th = throwable;
            Runnable parser = new Runnable(this) {
                /* renamed from: e */
                final /* synthetic */ JsonHttpResponseHandler f18867e;

                public void run() {
                    try {
                        final Object jsonResponse = this.f18867e.parseResponse(bArr);
                        this.f18867e.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C35032 f18860b;

                            public void run() {
                                if (!this.f18860b.f18867e.useRFC5179CompatibilityMode && jsonResponse == null) {
                                    this.f18860b.f18867e.onFailure(i, headerArr, (String) null, th);
                                } else if (jsonResponse instanceof JSONObject) {
                                    this.f18860b.f18867e.onFailure(i, headerArr, th, (JSONObject) jsonResponse);
                                } else if (jsonResponse instanceof JSONArray) {
                                    this.f18860b.f18867e.onFailure(i, headerArr, th, (JSONArray) jsonResponse);
                                } else if (jsonResponse instanceof String) {
                                    this.f18860b.f18867e.onFailure(i, headerArr, (String) jsonResponse, th);
                                } else {
                                    this.f18860b.f18867e.onFailure(i, headerArr, new JSONException("Unexpected response type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (final JSONException ex) {
                        this.f18867e.postRunnable(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C35032 f18862b;

                            public void run() {
                                this.f18862b.f18867e.onFailure(i, headerArr, ex, (JSONObject) null);
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
        AsyncHttpClient.log.mo2634v(f18868a, "response body is null, calling onFailure(Throwable, JSONObject)");
        onFailure(statusCode, headers, throwable, (JSONObject) null);
    }

    protected Object parseResponse(byte[] responseBody) throws JSONException {
        if (responseBody == null) {
            return null;
        }
        Object result = null;
        String jsonString = TextHttpResponseHandler.getResponseString(responseBody, getCharset());
        if (jsonString != null) {
            jsonString = jsonString.trim();
            if (this.useRFC5179CompatibilityMode) {
                if (jsonString.startsWith("{") || jsonString.startsWith("[")) {
                    result = new JSONTokener(jsonString).nextValue();
                }
            } else if ((jsonString.startsWith("{") && jsonString.endsWith("}")) || (jsonString.startsWith("[") && jsonString.endsWith("]"))) {
                result = new JSONTokener(jsonString).nextValue();
            } else if (jsonString.startsWith("\"") && jsonString.endsWith("\"")) {
                result = jsonString.substring(1, jsonString.length() - 1);
            }
        }
        if (result == null) {
            return jsonString;
        }
        return result;
    }

    public boolean isUseRFC5179CompatibilityMode() {
        return this.useRFC5179CompatibilityMode;
    }

    public void setUseRFC5179CompatibilityMode(boolean useRFC5179CompatibilityMode) {
        this.useRFC5179CompatibilityMode = useRFC5179CompatibilityMode;
    }
}
