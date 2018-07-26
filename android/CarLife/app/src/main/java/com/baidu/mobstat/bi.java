package com.baidu.mobstat;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.baidunavis.BaiduNaviParams.VoiceKey;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class bi extends WebViewClient {
    /* renamed from: a */
    private WeakReference<Context> f12689a;
    /* renamed from: b */
    private WebViewClient f12690b;

    public bi(Context context, WebViewClient webViewClient) {
        this.f12689a = new WeakReference(context);
        this.f12690b = webViewClient;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String decode;
        Throwable e;
        try {
            decode = URLDecoder.decode(str, "UTF-8");
            try {
                if (!TextUtils.isEmpty(decode) && decode.startsWith("bmtj:")) {
                    m10956a(decode.substring(5));
                    return true;
                }
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                db.b(e);
                if (this.f12690b != null) {
                    return false;
                }
                return this.f12690b.shouldOverrideUrlLoading(webView, decode);
            } catch (JSONException e3) {
                e = e3;
                db.b(e);
                if (this.f12690b != null) {
                    return this.f12690b.shouldOverrideUrlLoading(webView, decode);
                }
                return false;
            }
        } catch (Throwable e4) {
            e = e4;
            decode = str;
            db.b(e);
            if (this.f12690b != null) {
                return false;
            }
            return this.f12690b.shouldOverrideUrlLoading(webView, decode);
        } catch (Throwable e42) {
            e = e42;
            decode = str;
            db.b(e);
            if (this.f12690b != null) {
                return this.f12690b.shouldOverrideUrlLoading(webView, decode);
            }
            return false;
        }
        if (this.f12690b != null) {
            return this.f12690b.shouldOverrideUrlLoading(webView, decode);
        }
        return false;
    }

    /* renamed from: a */
    private void m10956a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString(VoiceKey.ACTION);
        jSONObject = jSONObject.getJSONObject(MapObjKey.OBJ_SL_OBJ);
        Context context = (Context) this.f12689a.get();
        if (context != null) {
            if ("onPageStart".equals(string)) {
                StatService.onPageStart(context, jSONObject.getString("page"));
            } else if ("onPageEnd".equals(string)) {
                StatService.onPageEnd(context, jSONObject.getString("page"));
            } else if ("onEvent".equals(string)) {
                string = jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID);
                r3 = jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_LABEL);
                int i = jSONObject.getInt("acc");
                try {
                    jSONObject = (JSONObject) jSONObject.get("attributes");
                } catch (Exception e) {
                    jSONObject = null;
                }
                StatService.onEvent(context, string, r3, i, m10955a(jSONObject));
            } else if ("onEventStart".equals(string)) {
                StatService.onEventStart(context, jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID), jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_LABEL));
            } else if ("onEventEnd".equals(string)) {
                string = jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID);
                r3 = jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_LABEL);
                try {
                    jSONObject = (JSONObject) jSONObject.get("attributes");
                } catch (Exception e2) {
                    jSONObject = null;
                }
                StatService.onEventEnd(context, string, r3, m10955a(jSONObject));
            } else if ("onEventDuration".equals(string)) {
                string = jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_EVENT_ID);
                r3 = jSONObject.getString(BNRCEventDetailsModel.BN_RC_KEY_LABEL);
                long j = jSONObject.getLong("duration");
                try {
                    jSONObject = (JSONObject) jSONObject.get("attributes");
                } catch (Exception e3) {
                    jSONObject = null;
                }
                StatService.onEventDuration(context, string, r3, j, m10955a(jSONObject));
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, String> m10955a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap;
        if (jSONObject.length() != 0) {
            hashMap = new HashMap();
        } else {
            hashMap = null;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject.getString(str));
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f12690b != null) {
            this.f12690b.onPageStarted(webView, str, bitmap);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.f12690b != null) {
            this.f12690b.onPageFinished(webView, str);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        if (this.f12690b != null) {
            this.f12690b.onLoadResource(webView, str);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.f12690b != null) {
            return this.f12690b.shouldInterceptRequest(webView, str);
        }
        return null;
    }

    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        if (this.f12690b != null) {
            this.f12690b.onTooManyRedirects(webView, message, message2);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.f12690b != null) {
            this.f12690b.onReceivedError(webView, i, str, str2);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        if (this.f12690b != null) {
            this.f12690b.onFormResubmission(webView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.f12690b != null) {
            this.f12690b.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f12690b != null) {
            this.f12690b.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.f12690b != null) {
            this.f12690b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.f12690b != null) {
            return this.f12690b.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return false;
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.f12690b != null) {
            this.f12690b.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        if (this.f12690b != null) {
            this.f12690b.onScaleChanged(webView, f, f2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (this.f12690b != null) {
            this.f12690b.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }
}
