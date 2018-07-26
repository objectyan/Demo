package com.baidu.tts.loopj;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends TextHttpResponseHandler {
    private static final String LOG_TAG = "JsonHttpRH";
    private boolean useRFC5179CompatibilityMode = true;

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
        AsyncHttpClient.log.mo3907w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        AsyncHttpClient.log.mo3907w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        AsyncHttpClient.log.mo3908w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
        AsyncHttpClient.log.mo3908w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        AsyncHttpClient.log.mo3908w(LOG_TAG, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", throwable);
    }

    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        AsyncHttpClient.log.mo3907w(LOG_TAG, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public final void onSuccess(final int statusCode, final Header[] headers, final byte[] responseBytes) {
        if (statusCode != 204) {
            Runnable c51331 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(responseBytes);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode && parseResponse == null) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (String) null);
                                } else if (parseResponse instanceof JSONObject) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONObject) parseResponse);
                                } else if (parseResponse instanceof JSONArray) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONArray) parseResponse);
                                } else if (!(parseResponse instanceof String)) {
                                    JsonHttpResponseHandler.this.onFailure(statusCode, headers, new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                                } else if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode) {
                                    JsonHttpResponseHandler.this.onFailure(statusCode, headers, (String) parseResponse, new JSONException("Response cannot be parsed as JSON data"));
                                } else {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (String) parseResponse);
                                }
                            }
                        });
                    } catch (final JSONException e) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                JsonHttpResponseHandler.this.onFailure(statusCode, headers, e, (JSONObject) null);
                            }
                        });
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                c51331.run();
                return;
            } else {
                new Thread(c51331).start();
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
            Runnable c51362 = new Runnable() {
                public void run() {
                    try {
                        final Object parseResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode && parseResponse == null) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) null, th);
                                } else if (parseResponse instanceof JSONObject) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONObject) parseResponse);
                                } else if (parseResponse instanceof JSONArray) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, th, (JSONArray) parseResponse);
                                } else if (parseResponse instanceof String) {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, (String) parseResponse, th);
                                } else {
                                    JsonHttpResponseHandler.this.onFailure(i, headerArr, new JSONException("Unexpected response type " + parseResponse.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (final JSONException e) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                JsonHttpResponseHandler.this.onFailure(i, headerArr, e, (JSONObject) null);
                            }
                        });
                    }
                }
            };
            if (getUseSynchronousMode() || getUsePoolThread()) {
                c51362.run();
                return;
            } else {
                new Thread(c51362).start();
                return;
            }
        }
        AsyncHttpClient.log.mo3905v(LOG_TAG, "response body is null, calling onFailure(Throwable, JSONObject)");
        onFailure(statusCode, headers, throwable, (JSONObject) null);
    }

    protected Object parseResponse(byte[] responseBody) throws JSONException {
        if (responseBody == null) {
            return null;
        }
        String str;
        Object nextValue;
        Object obj;
        String str2;
        String responseString = TextHttpResponseHandler.getResponseString(responseBody, getCharset());
        if (responseString != null) {
            responseString = responseString.trim();
            if (this.useRFC5179CompatibilityMode) {
                if (responseString.startsWith("{") || responseString.startsWith("[")) {
                    str = responseString;
                    nextValue = new JSONTokener(responseString).nextValue();
                    obj = str;
                    if (nextValue == null) {
                        return nextValue;
                    }
                    return obj;
                }
            } else if ((responseString.startsWith("{") && responseString.endsWith("}")) || (responseString.startsWith("[") && responseString.endsWith("]"))) {
                str = responseString;
                nextValue = new JSONTokener(responseString).nextValue();
                str2 = str;
                if (nextValue == null) {
                    return nextValue;
                }
                return obj;
            } else if (responseString.startsWith("\"") && responseString.endsWith("\"")) {
                str = responseString;
                responseString = responseString.substring(1, responseString.length() - 1);
                str2 = str;
                if (nextValue == null) {
                    return obj;
                }
                return nextValue;
            }
        }
        str = responseString;
        nextValue = null;
        str2 = str;
        if (nextValue == null) {
            return obj;
        }
        return nextValue;
    }

    public boolean isUseRFC5179CompatibilityMode() {
        return this.useRFC5179CompatibilityMode;
    }

    public void setUseRFC5179CompatibilityMode(boolean useRFC5179CompatibilityMode) {
        this.useRFC5179CompatibilityMode = useRFC5179CompatibilityMode;
    }
}
