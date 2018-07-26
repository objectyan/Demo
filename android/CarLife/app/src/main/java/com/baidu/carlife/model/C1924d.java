package com.baidu.carlife.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CarServiceFactory */
/* renamed from: com.baidu.carlife.model.d */
public class C1924d {
    /* renamed from: a */
    public String f5953a;
    /* renamed from: b */
    public String f5954b;
    /* renamed from: c */
    public String f5955c;
    /* renamed from: d */
    public String f5956d;
    /* renamed from: e */
    public String f5957e;
    /* renamed from: f */
    public String f5958f;
    /* renamed from: g */
    public String f5959g;
    /* renamed from: h */
    public String f5960h;

    /* renamed from: a */
    public static List<C1924d> m7384a(String data) {
        JSONException e;
        List<C1924d> result = null;
        try {
            JSONArray dataArray = new JSONArray(data);
            if (dataArray == null) {
                return null;
            }
            List<C1924d> result2 = new ArrayList();
            int i = 0;
            while (i < dataArray.length()) {
                try {
                    C1924d car = new C1924d();
                    JSONObject object = dataArray.optJSONObject(i);
                    car.f5953a = object.optString("car_factory_name");
                    car.f5954b = object.optString("car_factory_channel_id");
                    car.f5955c = object.optString("access_type");
                    car.f5956d = object.optString("plugin_platform");
                    car.f5957e = object.optString("plugin_version");
                    car.f5958f = object.optString("package_address");
                    car.f5959g = object.optString("plugin_bundle_id");
                    car.f5960h = object.optString("logo_icon_address");
                    result2.add(car);
                    i++;
                } catch (JSONException e2) {
                    e = e2;
                    result = result2;
                }
            }
            return result2;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return result;
        }
    }
}
