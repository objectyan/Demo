package com.baidu.android.pushservice.p029h;

import android.content.Context;
import com.baidu.android.pushservice.p025d.C0463a;
import com.baidu.android.pushservice.p025d.C0472c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.android.pushservice.h.p */
public final class C0550p {
    /* renamed from: a */
    private static volatile C0550p f1814a = null;
    /* renamed from: b */
    private Context f1815b = null;

    private C0550p(Context context) {
        this.f1815b = context.getApplicationContext();
        if (this.f1815b != null) {
        }
    }

    /* renamed from: a */
    public static C0550p m2348a(Context context) {
        if (f1814a == null) {
            f1814a = new C0550p(context);
        }
        return f1814a;
    }

    /* renamed from: a */
    public String m2349a(long j, long j2, int i) {
        JSONArray jSONArray = new JSONArray();
        List<C0544j> a = C0463a.m1997a(this.f1815b);
        List<C0543i> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        List<C0539f> arrayList2 = new ArrayList();
        List<C0538e> a2 = C0463a.m1998a(this.f1815b, j, j2, 1500);
        Collection h = C0472c.m2041h(this.f1815b);
        if (a2 == null) {
            return null;
        }
        int i2;
        Object obj = a2.size() > i ? 1 : null;
        if (h != null) {
            a2.addAll(h);
        }
        int i3 = 0;
        for (C0538e c0538e : a2) {
            List list;
            if (c0538e.m2278a().startsWith(C0535n.f1750r)) {
                if (!hashMap.containsKey(c0538e.m2282b())) {
                    hashMap.put(c0538e.m2282b(), new ArrayList());
                }
                list = (List) hashMap.get(c0538e.m2282b());
                if (list != null) {
                    list.add(c0538e.m2291e());
                }
            } else if (c0538e.m2278a().startsWith(C0535n.f1751s)) {
                if (!hashMap2.containsKey(c0538e.m2282b())) {
                    hashMap2.put(c0538e.m2282b(), new ArrayList());
                }
                list = (List) hashMap2.get(c0538e.m2282b());
                if (list != null) {
                    list.add(c0538e.m2294f());
                }
            } else if (c0538e.m2278a().startsWith(C0535n.f1754v)) {
                if (!hashMap3.containsKey(c0538e.m2282b())) {
                    hashMap3.put(c0538e.m2282b(), new ArrayList());
                }
                list = (List) hashMap3.get(c0538e.m2282b());
                if (list != null) {
                    list.add(c0538e.m2300h());
                }
            } else if (c0538e.m2278a().startsWith(C0535n.f1753u)) {
                arrayList2.add(c0538e.m2297g());
            }
            if (obj != null) {
                i2 = i3 + 1;
                if (i2 >= i) {
                    break;
                }
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        i2 = i3;
        if (i2 < i) {
            int i4 = i2;
            for (C0538e c0538e2 : a2) {
                if (c0538e2.m2278a().startsWith(C0535n.f1752t)) {
                    arrayList.add(c0538e2.m2288d());
                }
                if (obj != null) {
                    i2 = i4 + 1;
                    if (i2 < i) {
                    }
                } else {
                    i2 = i4;
                }
                i4 = i2;
            }
        }
        try {
            JSONObject jSONObject;
            JSONArray jSONArray2;
            if (arrayList.size() > 0) {
                jSONObject = new JSONObject();
                jSONObject.put("app_appid", "9527");
                jSONArray2 = new JSONArray();
                for (C0543i a3 : arrayList) {
                    jSONArray2.put(a3.m2326a());
                }
                jSONObject.put("push_action", jSONArray2);
                jSONArray.put(jSONObject);
            }
            if (a != null) {
                for (C0544j c0544j : a) {
                    JSONObject a4 = c0544j.m2327a(this.f1815b);
                    JSONArray jSONArray3 = new JSONArray();
                    List<C0545k> list2 = (List) hashMap.get(c0544j.m2267b());
                    List<C0536b> list3 = (List) hashMap2.get(c0544j.m2267b());
                    List<C0542h> list4 = (List) hashMap3.get(c0544j.m2267b());
                    if (list2 != null) {
                        try {
                            if (list2.size() != 0) {
                                for (C0545k a5 : list2) {
                                    jSONArray3.put(a5.m2330a());
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                    if (list3 != null) {
                        if (list3.size() != 0) {
                            for (C0536b a6 : list3) {
                                jSONArray3.put(a6.m2263a());
                            }
                        }
                    }
                    if (list4 != null) {
                        for (C0542h c0542h : list4) {
                            if (c0542h.j.equals(c0544j.m2267b())) {
                                jSONArray3.put(c0542h.m2325a());
                                hashMap3.remove(c0544j.m2267b());
                            }
                        }
                    }
                    if (jSONArray3.length() > 0) {
                        a4.put("push_action", jSONArray3);
                    }
                    jSONArray.put(a4);
                }
                for (String str : hashMap3.keySet()) {
                    try {
                        C0542h c0542h2;
                        List<C0542h> list5 = (List) hashMap3.get(str);
                        JSONArray jSONArray4 = new JSONArray();
                        if (list5 != null) {
                            c0542h2 = null;
                            for (C0542h c0542h22 : list5) {
                                jSONArray4.put(c0542h22.m2325a());
                            }
                        } else {
                            c0542h22 = null;
                        }
                        if (c0542h22 != null) {
                            jSONObject = new JSONObject();
                            jSONObject.put("app_type", C0544j.f1798b);
                            jSONObject.put("app_package_name", c0542h22.j);
                            jSONObject.put("app_vercode", c0542h22.f1792b);
                            jSONObject.put("app_vername", c0542h22.f1791a);
                            if (jSONArray4.length() > 0) {
                                jSONObject.put("push_action", jSONArray4);
                            }
                            jSONArray.put(jSONObject);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            if (arrayList2.size() > 0) {
                jSONObject = new JSONObject();
                jSONObject.put("app_appid", "9528");
                jSONArray2 = new JSONArray();
                for (C0539f a7 : arrayList2) {
                    jSONArray2.put(a7.m2304a());
                }
                jSONObject.put("crash_info", jSONArray2);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e3) {
        }
        return jSONArray.length() == 0 ? "" : jSONArray.toString();
    }
}
