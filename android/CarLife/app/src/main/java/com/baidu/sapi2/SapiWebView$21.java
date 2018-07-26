package com.baidu.sapi2;

import android.app.ProgressDialog;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.sapi2.utils.C4913L;
import com.tencent.mm.sdk.modelmsg.SendAuth.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import org.json.JSONException;
import org.json.JSONObject;

class SapiWebView$21 extends HttpResponseHandler {
    /* renamed from: a */
    final /* synthetic */ SapiWebView f20065a;

    SapiWebView$21(SapiWebView sapiWebView, Looper x0) {
        this.f20065a = sapiWebView;
        super(x0);
    }

    public void onStart() {
        try {
            SapiWebView.a(this.f20065a, ProgressDialog.show(this.f20065a.getContext(), null, "加载中...", true));
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
    }

    public void onFinish() {
        if (SapiWebView.i(this.f20065a) != null) {
            try {
                SapiWebView.i(this.f20065a).dismiss();
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    public void onFailure(Throwable e, String errorCode) {
        if (SapiWebView.F(this.f20065a) != null) {
            SapiWebView.F(this.f20065a).setVisibility(0);
        } else {
            SapiWebView.G(this.f20065a).handleServerError(errorCode);
        }
    }

    public void onSuccess(int status, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            String mkey = jsonObject.optString("mkey", "");
            if (TextUtils.isEmpty(mkey)) {
                String errorCode = jsonObject.optString("error_code", "");
                if (SapiWebView.G(this.f20065a) != null) {
                    SapiWebView.G(this.f20065a).handleServerError(errorCode);
                    return;
                }
                return;
            }
            Req req = new Req();
            req.scope = "snsapi_userinfo";
            req.state = mkey;
            WXAPIFactory.createWXAPI(this.f20065a.getContext(), SapiWebView.d(this.f20065a).wxAppID).sendReq(req);
            this.f20065a.finish();
        } catch (JSONException e) {
            C4913L.m16374e(e);
        }
    }
}
