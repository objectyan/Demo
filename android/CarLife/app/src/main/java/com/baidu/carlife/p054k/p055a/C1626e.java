package com.baidu.carlife.p054k.p055a;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetWorkBaseRequest */
/* renamed from: com.baidu.carlife.k.a.e */
public abstract class C1626e {
    public static final int RESPONSE_DATA_ERROR = -4;
    public static final int RESPONSE_DATA_NULL = -3;
    public static final int RESPONSE_DELETE_NOT_HAVE_RECORD_ERROR = 56;
    public static final int RESPONSE_ERROR = -1;
    public static final int RESPONSE_ERROR_NONETWORK = -2;
    public static final int RESPONSE_GET_ALL_RECORD_ERROR = 53;
    public static final int RESPONSE_REPEAT_ADD_ERROR = 54;
    public static final int RESPONSE_SERVER_LINE_ERROR = 51;
    public static final int RESPONSE_SUCCESS = 0;
    private static ImageLoader mImageLoader;
    private static RequestQueue mQueue;
    private final String filterTag;
    private String mErrMsg;
    private int mErrNo;
    private C0924a mListener;
    private C1622d mPostParams;
    private C1619c mRequest;
    private long mRequestId;
    private boolean shouldCache;
    private String signKey;
    protected String tag;
    private boolean urlSignNeed;

    /* compiled from: NetWorkBaseRequest */
    /* renamed from: com.baidu.carlife.k.a.e$a */
    public interface C0924a {
        void onNetWorkResponse(int i);
    }

    /* compiled from: NetWorkBaseRequest */
    /* renamed from: com.baidu.carlife.k.a.e$b */
    private class C1624b implements ErrorListener {
        /* renamed from: a */
        final /* synthetic */ C1626e f4962a;

        private C1624b(C1626e c1626e) {
            this.f4962a = c1626e;
        }

        public void onErrorResponse(VolleyError error) {
            this.f4962a.closeInputSteams();
            if (C1251e.m4358a().m4401r()) {
                this.f4962a.reponseNoJsonCallBack(null);
                this.f4962a.responseErrorCallBack(-1);
                this.f4962a.notifyResponseListener(-1);
                return;
            }
            this.f4962a.responseErrorCallBack(-2);
            this.f4962a.notifyResponseListener(-2);
        }
    }

    /* compiled from: NetWorkBaseRequest */
    /* renamed from: com.baidu.carlife.k.a.e$c */
    private class C1625c implements Listener<String> {
        /* renamed from: a */
        final /* synthetic */ C1626e f4963a;

        private C1625c(C1626e c1626e) {
            this.f4963a = c1626e;
        }

        public /* synthetic */ void onResponse(Object obj) {
            m5908a((String) obj);
        }

        /* renamed from: a */
        public void m5908a(String response) {
            C1260i.m4435b("NetWork#" + this.f4963a.tag, "The Response is:" + response);
            this.f4963a.closeInputSteams();
            this.f4963a.parseResponse(response);
        }
    }

    protected abstract String getUrl();

    protected abstract int responseSuccessCallBack(String str) throws JSONException;

    public C1626e() {
        this(BaiduNaviApplication.getInstance(), null, false);
    }

    public C1626e(Context context) {
        this(context, null, false);
    }

    public C1626e(Context context, String signKey) {
        this(context, signKey, true);
    }

    private C1626e(Context context, String signKey, boolean urlSignNeed) {
        this.tag = C1626e.class.getSimpleName();
        this.filterTag = "NetWork#";
        this.signKey = "sign";
        this.shouldCache = false;
        this.mErrNo = -1;
        if (mQueue == null) {
            mQueue = Volley.newRequestQueue(context);
        }
        this.signKey = signKey;
        this.urlSignNeed = urlSignNeed;
    }

    protected void responseErrorCallBack(int errorType) {
    }

    public void setShouldCache(boolean shouldCache) {
        this.shouldCache = shouldCache;
    }

    protected C1622d getUrlParams() {
        return null;
    }

    protected C1622d getPostRequestParams() {
        return null;
    }

    public void toGetRequest() {
        toRequest(0);
    }

    public void toPostRequest() {
        toRequest(1);
    }

    public void toRequest(int method) {
        this.mPostParams = getPostRequestParams();
        this.mRequest = new C1619c(method, generateUrl(), this.mPostParams, new C1625c(), new C1624b(), this.shouldCache, "NetWork#" + this.tag);
        this.mRequestId = this.mRequest.m5904a();
        mQueue.add(this.mRequest);
    }

    public boolean isThisRequest() {
        return this.mRequestId == this.mRequest.m5904a();
    }

    public void cancel() {
        if (this.mRequest != null) {
            this.mRequest.cancel();
        }
    }

    public static ImageLoader getImageLoader() {
        if (mQueue == null) {
            return null;
        }
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(mQueue, new C1617a());
        }
        return mImageLoader;
    }

    private String generateUrl() {
        return getUrl() + C1622d.getUrlParamsString(getUrlParams(), this.urlSignNeed, this.signKey);
    }

    public void registerResponseListener(C0924a listener) {
        this.mListener = listener;
    }

    public int getErrNo() {
        return this.mErrNo;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    private void closeInputSteams() {
        if (this.mPostParams != null) {
            this.mPostParams.closeInputSteams();
        }
    }

    public void notifyResponseListener(int responseCode) {
        if (this.mListener != null) {
            this.mListener.onNetWorkResponse(responseCode);
        }
    }

    private void parseResponse(String response) {
        reponseNoJsonCallBack(response);
        if (TextUtils.isEmpty(response)) {
            responseErrorCallBack(-1);
            notifyResponseListener(-1);
            return;
        }
        try {
            JSONObject json = new JSONObject(response);
            int errNo = parseError(json);
            if (errNo == 0) {
                int tempSucCode;
                if (json.has("data")) {
                    tempSucCode = responseSuccessCallBack(json.getString("data"));
                } else if (json.has("sync")) {
                    tempSucCode = responseSuccessCallBack(json.getJSONObject("sync").toString());
                } else {
                    tempSucCode = responseSuccessCallBack(response);
                }
                notifyResponseListener(tempSucCode);
            } else if (errNo == 53 || errNo == 56 || errNo == 54 || errNo == 51) {
                notifyResponseListener(responseSuccessCallBack(response));
            } else {
                responseErrorCallBack(-1);
                notifyResponseListener(-1);
            }
        } catch (JSONException e) {
            C1260i.m4445e("NetWork#" + this.tag, "The Response throw JSONException");
            responseErrorCallBack(-1);
            notifyResponseListener(-1);
        }
    }

    public void reponseNoJsonCallBack(String response) {
    }

    private int parseError(JSONObject json) throws JSONException {
        if (json.has("code")) {
            this.mErrNo = json.getInt("code");
        } else if (json.has(C2125n.f6745M)) {
            this.mErrNo = json.getInt(C2125n.f6745M);
        } else if (json.has("status")) {
            this.mErrNo = json.getInt("status");
        } else if (json.has("result")) {
            JSONObject result = json.optJSONObject("result");
            if (result != null && result.has(ParamKey.KEY_MSG_ERRORS)) {
                this.mErrNo = result.getInt(ParamKey.KEY_MSG_ERRORS);
            }
        }
        if (json.has(C2125n.f6746N)) {
            this.mErrMsg = json.getString(C2125n.f6746N);
        } else if (json.has(PushConstants.EXTRA_PUSH_MESSAGE)) {
            this.mErrMsg = json.getString(PushConstants.EXTRA_PUSH_MESSAGE);
        }
        return this.mErrNo;
    }
}
