package com.baidu.carlife.radio.p080b.p103a;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.p075d.p076a.C1408c;
import com.baidu.carlife.p075d.p076a.C1416e;
import com.baidu.carlife.radio.p080b.C2111b;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.carlife.util.C2172c;
import com.baidu.carlife.util.C2180k;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AbsRadioRequest */
/* renamed from: com.baidu.carlife.radio.b.a.a */
public abstract class C2108a implements C1408c, C2107b {
    /* renamed from: a */
    protected static final String f6696a = "radio_request";
    /* renamed from: b */
    protected long f6697b = 0;
    /* renamed from: c */
    private Map<String, String> f6698c;

    /* renamed from: c */
    public void mo1769c() {
        Map<String, String> paramMap = mo1768b();
        if (paramMap == null) {
            paramMap = m7922e();
        } else {
            paramMap.putAll(m7922e());
        }
        paramMap.put("sign", m7920b(paramMap));
        String bduss = NaviAccountUtils.getInstance().syncGetBduss();
        if (TextUtils.isEmpty(bduss)) {
            C1416e.m5212c();
        } else {
            C1416e.m5208a("bduss", bduss, C2109c.m7928b());
        }
        this.f6697b = System.currentTimeMillis();
        mo1776a(mo1770a(), paramMap, this);
    }

    /* renamed from: a */
    protected void mo1776a(String url, Map<String, String> paramMap, C1408c httpCallback) {
        C1416e.m5209a(url, (Map) paramMap, httpCallback);
    }

    /* renamed from: a */
    public void m7923a(Bundle bundle) {
        this.f6698c = C2111b.m7954a(bundle);
        mo1769c();
    }

    /* renamed from: b */
    public Map<String, String> mo1768b() {
        return this.f6698c;
    }

    /* renamed from: d */
    private String m7921d() {
        return "208f3bc80b5167f299f5928c2c22feac";
    }

    /* renamed from: b */
    private String m7920b(Map<String, String> params) {
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        try {
            for (String key : keys) {
                if (index > 0) {
                    sb.append("&");
                }
                sb.append(String.format("%s=%s", new Object[]{key, params.get(key)}));
                index++;
            }
            sb.append("&");
            sb.append(String.format("%s=%s", new Object[]{"token", m7921d()}));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return C2180k.m8280a(sb.toString());
    }

    /* renamed from: e */
    private Map<String, String> m7922e() {
        Map<String, String> paramMap = new HashMap();
        paramMap.put("cuid", PackageUtil.getCuid());
        paramMap.put("device_from", "1");
        paramMap.put("sv", C1251e.m4373g());
        paramMap.put("channel", C2172c.m8224c());
        paramMap.put("vehicle_channel", C1253f.jx.m4403a());
        LocData currentPoint = BNLocationManagerProxy.getInstance().getCurLocation();
        if (currentPoint != null) {
            GeoPoint geoPoint = CoordinateTransformUtil.transferGCJ02ToBD09(currentPoint.longitude, currentPoint.latitude);
            double latitude = ((double) geoPoint.getLatitudeE6()) / 100000.0d;
            paramMap.put(NaviCmdConstants.KEY_NAVI_CMD_DEST_LNG, String.valueOf(((double) geoPoint.getLongitudeE6()) / 100000.0d));
            paramMap.put("lat", String.valueOf(latitude));
        }
        String uid = NaviAccountUtils.getInstance().getUid();
        if (!TextUtils.isEmpty(uid)) {
            paramMap.put("uuid", uid);
        }
        paramMap.put("product", C2848p.f9316q);
        paramMap.put(C2125n.f6748P, String.valueOf(System.currentTimeMillis() / 1000));
        return paramMap;
    }
}
