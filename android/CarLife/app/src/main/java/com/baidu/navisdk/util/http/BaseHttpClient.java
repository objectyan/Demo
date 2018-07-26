package com.baidu.navisdk.util.http;

import android.graphics.BitmapFactory;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;

public class BaseHttpClient {
    public void get(String url, final BitmapRspHandler responseHandler) {
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = false;
        BNHttpCenter.getInstance().get(url, null, new BNHttpBinaryResponseHandler() {
            public void onSuccess(int statusCode, byte[] binaryData) {
                LogUtil.m15791e("BaseHttpClient", "onSuccess().statusCode=" + statusCode);
                if (responseHandler != null && binaryData != null) {
                    responseHandler.handleSuccessMessage(BitmapFactory.decodeByteArray(binaryData, 0, binaryData.length));
                }
            }

            public void onFailure(int statusCode, byte[] binaryData, Throwable error) {
                LogUtil.m15791e("BaseHttpClient", "onFailure().statusCode=" + statusCode);
                if (responseHandler != null) {
                    responseHandler.onFailure(error);
                }
            }
        }, httpParams);
    }
}
