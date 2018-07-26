package com.baidu.cloudsdk.common.http;

import android.os.Looper;
import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends HttpResponseHandler {
    protected static final int SUCCESS_JSON_MESSAGE = 100;

    public JsonHttpResponseHandler(Looper looper) {
        super(looper);
    }

    protected void onFailure(Throwable error, JSONArray errorResponse) {
    }

    protected void onFailure(Throwable error, JSONObject errorResponse) {
    }

    protected void onSuccess(JSONArray response) {
    }

    protected void onSuccess(JSONObject response) {
    }

    protected void onSuccess(int statusCode, JSONArray response) {
        onSuccess(response);
    }

    protected void onSuccess(int statusCode, JSONObject response) {
        onSuccess(response);
    }

    protected void sendSuccessMessage(int statusCode, String responseBody) {
        if (statusCode != 204) {
            try {
                Object json = parseResponse(responseBody);
                sendMessage(obtainMessage(100, new Object[]{Integer.valueOf(statusCode), json}));
                return;
            } catch (JSONException e) {
                sendFailureMessage((Throwable) e, responseBody);
                return;
            }
        }
        sendMessage(obtainMessage(100, new Object[]{Integer.valueOf(statusCode), new JSONObject()}));
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 100:
                Object[] objs = (Object[]) msg.obj;
                handleSuccessJsonMessage(((Integer) objs[0]).intValue(), objs[1]);
                return;
            default:
                super.handleMessage(msg);
                return;
        }
    }

    protected void handleSuccessJsonMessage(int statusCode, Object json) {
        if (json instanceof JSONObject) {
            onSuccess(statusCode, (JSONObject) json);
        } else if (json instanceof JSONArray) {
            onSuccess(statusCode, (JSONArray) json);
        } else {
            onFailure(new JSONException("Unexpected type " + json.getClass().getName()), "");
        }
    }

    protected void handleFailureMessage(Throwable e, String responseBody) {
        if (responseBody != null) {
            try {
                Object json = parseResponse(responseBody);
                if (json instanceof JSONObject) {
                    onFailure(e, (JSONObject) json);
                    return;
                } else if (json instanceof JSONArray) {
                    onFailure(e, (JSONArray) json);
                    return;
                } else {
                    onFailure(e, responseBody);
                    return;
                }
            } catch (JSONException e2) {
                onFailure(e, responseBody);
                return;
            }
        }
        onFailure(e, "");
    }

    protected Object parseResponse(String responseBody) throws JSONException {
        Object result = null;
        responseBody = responseBody.trim();
        if (responseBody.startsWith("{") || responseBody.startsWith("[")) {
            result = new JSONTokener(responseBody).nextValue();
        }
        if (result == null) {
            return responseBody;
        }
        return result;
    }
}
