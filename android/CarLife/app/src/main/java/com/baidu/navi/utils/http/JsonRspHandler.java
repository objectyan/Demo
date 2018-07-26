package com.baidu.navi.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class JsonRspHandler extends BaseRspHandler {
    private static final String CHARSET = "UTF-8";
    private String mCharset = "UTF-8";

    public void setCharset(String charset) {
        this.mCharset = charset;
    }

    protected void handleResponse(HttpResponse response) {
        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() != 200) {
            handleFailureMessage(new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()));
            return;
        }
        String ret = null;
        try {
            ret = EntityUtils.toString(response.getEntity(), this.mCharset);
        } catch (Exception e) {
            handleFailureMessage(e);
        }
        JSONObject obj = null;
        try {
            obj = new JSONObject(ret);
        } catch (Exception e2) {
            handleFailureMessage(e2);
        }
        if (obj != null) {
            handleSuccessMessage(obj);
        }
    }
}
