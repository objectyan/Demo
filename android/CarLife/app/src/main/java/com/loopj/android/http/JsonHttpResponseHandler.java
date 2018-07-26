package com.loopj.android.http;

import cz.msebera.android.httpclient.C6327f;
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

    public void onSuccess(int statusCode, C6327f[] headers, JSONObject response) {
        AsyncHttpClient.log.mo4891w(LOG_TAG, "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public void onSuccess(int statusCode, C6327f[] headers, JSONArray response) {
        AsyncHttpClient.log.mo4891w(LOG_TAG, "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onFailure(int statusCode, C6327f[] headers, Throwable throwable, JSONObject errorResponse) {
        AsyncHttpClient.log.mo4892w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int statusCode, C6327f[] headers, Throwable throwable, JSONArray errorResponse) {
        AsyncHttpClient.log.mo4892w(LOG_TAG, "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int statusCode, C6327f[] headers, String responseString, Throwable throwable) {
        AsyncHttpClient.log.mo4892w(LOG_TAG, "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", throwable);
    }

    public void onSuccess(int statusCode, C6327f[] headers, String responseString) {
        AsyncHttpClient.log.mo4891w(LOG_TAG, "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public final void onSuccess(final int statusCode, final C6327f[] headers, final byte[] responseBytes) {
        if (statusCode != 204) {
            Runnable parser = new Runnable() {
                public void run() {
                    try {
                        final Object jsonResponse = JsonHttpResponseHandler.this.parseResponse(responseBytes);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode && jsonResponse == null) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (String) null);
                                } else if (jsonResponse instanceof JSONObject) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONObject) jsonResponse);
                                } else if (jsonResponse instanceof JSONArray) {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (JSONArray) jsonResponse);
                                } else if (!(jsonResponse instanceof String)) {
                                    JsonHttpResponseHandler.this.onFailure(statusCode, headers, new JSONException("Unexpected response type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                } else if (JsonHttpResponseHandler.this.useRFC5179CompatibilityMode) {
                                    JsonHttpResponseHandler.this.onFailure(statusCode, headers, (String) jsonResponse, new JSONException("Response cannot be parsed as JSON data"));
                                } else {
                                    JsonHttpResponseHandler.this.onSuccess(statusCode, headers, (String) jsonResponse);
                                }
                            }
                        });
                    } catch (final JSONException ex) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                JsonHttpResponseHandler.this.onFailure(statusCode, headers, ex, (JSONObject) null);
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

    public final void onFailure(int statusCode, C6327f[] headers, byte[] responseBytes, Throwable throwable) {
        if (responseBytes != null) {
            final byte[] bArr = responseBytes;
            final int i = statusCode;
            final C6327f[] c6327fArr = headers;
            final Throwable th = throwable;
            Runnable parser = new Runnable() {
                public void run() {
                    try {
                        final Object jsonResponse = JsonHttpResponseHandler.this.parseResponse(bArr);
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                if (!JsonHttpResponseHandler.this.useRFC5179CompatibilityMode && jsonResponse == null) {
                                    JsonHttpResponseHandler.this.onFailure(i, c6327fArr, (String) null, th);
                                } else if (jsonResponse instanceof JSONObject) {
                                    JsonHttpResponseHandler.this.onFailure(i, c6327fArr, th, (JSONObject) jsonResponse);
                                } else if (jsonResponse instanceof JSONArray) {
                                    JsonHttpResponseHandler.this.onFailure(i, c6327fArr, th, (JSONArray) jsonResponse);
                                } else if (jsonResponse instanceof String) {
                                    JsonHttpResponseHandler.this.onFailure(i, c6327fArr, (String) jsonResponse, th);
                                } else {
                                    JsonHttpResponseHandler.this.onFailure(i, c6327fArr, new JSONException("Unexpected response type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                }
                            }
                        });
                    } catch (final JSONException ex) {
                        JsonHttpResponseHandler.this.postRunnable(new Runnable() {
                            public void run() {
                                JsonHttpResponseHandler.this.onFailure(i, c6327fArr, ex, (JSONObject) null);
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
        AsyncHttpClient.log.mo4889v(LOG_TAG, "response body is null, calling onFailure(Throwable, JSONObject)");
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
