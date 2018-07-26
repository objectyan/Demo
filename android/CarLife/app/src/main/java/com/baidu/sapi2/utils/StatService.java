package com.baidu.sapi2.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.navi.protocol.model.UpdateDeviceStatusDataStruct;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.sapi2.C4891b;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class StatService {
    /* renamed from: a */
    private static final String f20531a = "http://nsclick.baidu.com/v.gif";
    /* renamed from: b */
    private static final Map<String, String> f20532b = new HashMap();

    private StatService() {
    }

    static {
        f20532b.put("pid", "111");
        f20532b.put("type", StatisticConstants.PHONE_CALL_TYPE_NUMBER_VOICE);
        f20532b.put(UpdateDeviceStatusDataStruct.KEY_DEVICE, "android");
    }

    public static void onEvent(StatEvent statEvent) {
        if (statEvent != null && !TextUtils.isEmpty(statEvent.f20527a)) {
            Map<String, String> extras = new HashMap();
            extras.put("di", C4920d.m16400b(statEvent.f20528b));
            m16390a(statEvent.f20527a, extras);
        }
    }

    /* renamed from: a */
    public static void m16390a(final String name, Map<String, String> extras) {
        if (!TextUtils.isEmpty(name)) {
            try {
                final SapiConfiguration config = SapiAccountManager.getInstance().getSapiConfiguration();
                C4891b.m16250a(config.context).m16269a(name, (Map) extras);
                if (SapiUtils.hasActiveNetwork(config.context)) {
                    Map<String, String> params = new HashMap();
                    params.putAll(f20532b);
                    params.put("name", name);
                    params.put("tpl", config.tpl);
                    params.put("clientfrom", "mobilesdk_enhanced");
                    params.put("app_version", SapiUtils.getVersionName(config.context));
                    params.put("sdk_version", SapiAccountManager.VERSION_NAME);
                    if (!TextUtils.isEmpty(config.clientId)) {
                        params.put("cuid", config.clientId);
                    }
                    params.put("v", String.valueOf(System.currentTimeMillis()));
                    if (extras != null) {
                        for (Entry<String, String> extra : extras.entrySet()) {
                            if (!(TextUtils.isEmpty((CharSequence) extra.getKey()) || TextUtils.isEmpty((CharSequence) extra.getValue()))) {
                                params.put(extra.getKey(), extra.getValue());
                            }
                        }
                    }
                    new AsyncHttpClient().get(config.context, f20531a, new RequestParams(params), new HttpResponseHandler(Looper.getMainLooper()) {
                        protected void onSuccess(int statusCode, String responseBody) {
                            C4891b.m16250a(config.context).m16280d(name);
                        }
                    });
                }
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: a */
    public static void m16389a() {
        try {
            for (Entry<String, Map<String, String>> entry : C4891b.m16250a(SapiAccountManager.getInstance().getSapiConfiguration().context).m16295q().entrySet()) {
                m16390a((String) entry.getKey(), (Map) entry.getValue());
            }
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
    }
}
