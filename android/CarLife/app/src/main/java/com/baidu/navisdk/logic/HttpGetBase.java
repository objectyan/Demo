package com.baidu.navisdk.logic;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.statistic.NetFlowStat.HttpNetFlowInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpGetBase extends CommandBase {
    private static final String TAG = "HttpGetBase";
    protected List<NameValuePair> mHttpParams = new ArrayList();
    protected JSONObject mJson;

    protected abstract String generateParams();

    protected abstract List<NameValuePair> getRequestParams();

    protected abstract String getUrl();

    protected void parseJson() {
    }

    protected CommandResult exec() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            String url = getUrl();
            LogUtil.m15791e(TAG, "exec() url=" + url);
            final HttpNetFlowInfo mHttpNetFlowInfo = new HttpNetFlowInfo();
            try {
                mHttpNetFlowInfo.setSendDataInfo(System.currentTimeMillis(), (long) (url.getBytes("utf-8").length * 8), getUrl());
            } catch (Exception e) {
            }
            BNHttpParams httpParams = new BNHttpParams();
            httpParams.isAsync = false;
            BNHttpCenter.getInstance().get(getUrl(), BNHttpCenterHelper.formatParams(getRequestParams()), new BNHttpTextResponseHandler() {
                public void onSuccess(int statusCode, String responseString) {
                    LogUtil.m15791e(HttpGetBase.TAG, "exec.ok statusCode=" + statusCode + ", s=" + responseString);
                    if (TextUtils.isEmpty(responseString)) {
                        HttpGetBase.this.mRet.set(NaviErrCode.getAppError(4));
                        return;
                    }
                    if (mHttpNetFlowInfo != null) {
                        try {
                            mHttpNetFlowInfo.setReceiveDataInfo((long) (responseString.getBytes("utf-8").length * 8));
                        } catch (Exception e) {
                        }
                    }
                    try {
                        HttpGetBase.this.mJson = new JSONObject(responseString);
                        HttpGetBase.this.mRet.setSuccess();
                    } catch (JSONException e2) {
                        HttpGetBase.this.mRet.set(NaviErrCode.getAppError(3));
                    }
                }

                public void onFailure(int statusCode, String responseString, Throwable throwable) {
                    LogUtil.m15791e(HttpGetBase.TAG, "exec.err statusCode=" + statusCode + ", s=" + responseString);
                    HttpGetBase.this.mRet.set(NaviErrCode.getAppError(5));
                }
            }, httpParams);
            if (!this.mRet.isSuccess()) {
                return this.mRet;
            }
            if (mHttpNetFlowInfo != null) {
                mHttpNetFlowInfo.submit();
            }
            parseJson();
            if (this.mRet.isSuccess()) {
                handleSuccess();
            } else {
                handleError();
            }
            return this.mRet;
        }
        this.mRet.set(NaviErrCode.getSDKError(1));
        return this.mRet;
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent && this.mReqData.mRetryTimes == 1) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mJson);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected String formatNameValuePair(List<NameValuePair> params) {
        if (params == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < params.size(); index++) {
            try {
                sb.append(URLEncoder.encode(((NameValuePair) params.get(index)).getName(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(((NameValuePair) params.get(index)).getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            } catch (Exception e22) {
                e22.printStackTrace();
            }
            if (index < params.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }
}
