package com.baidu.navi.utils.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

public abstract class BitmapRspHandler extends BaseRspHandler {
    public abstract void onRevBitmap(Bitmap bitmap);

    public void onSuccess(Object obj) {
        onRevBitmap((Bitmap) obj);
    }

    protected void handleResponse(HttpResponse response) {
        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() != 200) {
            handleFailureMessage(new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()));
            return;
        }
        byte[] responseBody = null;
        try {
            responseBody = EntityUtils.toByteArray(response.getEntity());
        } catch (IOException e) {
            handleFailureMessage(e);
        }
        if (responseBody != null) {
            handleSuccessMessage(BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length));
        }
    }
}
