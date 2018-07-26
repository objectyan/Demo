package com.baidu.carlife.model;

import com.baidu.che.codriver.platform.PlatformConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FoodQueueModel */
/* renamed from: com.baidu.carlife.model.f */
public class C1926f implements Serializable {
    /* renamed from: a */
    public int f5993a;
    /* renamed from: b */
    public String f5994b;
    /* renamed from: c */
    public String f5995c;
    /* renamed from: d */
    public int f5996d;
    /* renamed from: e */
    public int f5997e;
    /* renamed from: f */
    public String f5998f;
    /* renamed from: g */
    public int f5999g;
    /* renamed from: h */
    public int f6000h;
    /* renamed from: i */
    public String f6001i;
    /* renamed from: j */
    public String f6002j;
    /* renamed from: k */
    public String f6003k;
    /* renamed from: l */
    public int f6004l;
    /* renamed from: m */
    public String f6005m;
    /* renamed from: n */
    public String f6006n;
    /* renamed from: o */
    public String f6007o;
    /* renamed from: p */
    public String f6008p;
    /* renamed from: q */
    public String f6009q;
    /* renamed from: r */
    public String f6010r;

    /* renamed from: a */
    public static List<C1926f> m7389a(JSONArray jsonArray) {
        if (jsonArray != null) {
            int length = jsonArray.length();
            if (length >= 1) {
                List<C1926f> queueList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    C1926f queue = new C1926f();
                    queue.f5994b = jsonObject.optString("qname");
                    queue.f5995c = jsonObject.optString("qattr");
                    queue.f5996d = jsonObject.optInt("wait");
                    queue.f6001i = jsonObject.optString("waittime");
                    queue.f5999g = jsonObject.optInt(PlatformConstants.CONNECT_EXTRA_KEY);
                    queue.f6000h = jsonObject.optInt("to");
                    queue.f5997e = jsonObject.optInt("type");
                    queue.f6010r = jsonObject.optString("sid");
                    queue.f6009q = jsonObject.optString("name");
                    queue.f6008p = jsonObject.optString("num");
                    queue.f6002j = jsonObject.optString("orderid");
                    queue.f6003k = jsonObject.optString("serialid");
                    queue.f6004l = jsonObject.optInt("state");
                    queue.f6005m = jsonObject.optString("sname");
                    queue.f6007o = jsonObject.optString("nowwait");
                    queue.f6006n = jsonObject.optString("notice");
                    queueList.add(queue);
                }
                return queueList;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static List<C1926f> m7391b(JSONArray jsonArray) {
        if (jsonArray != null) {
            int length = jsonArray.length();
            if (length >= 1) {
                List<C1926f> queueList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    C1926f queue = new C1926f();
                    queue.f5994b = jsonObject.optString("qname");
                    queue.f5995c = jsonObject.optString("qattr");
                    queue.f5996d = jsonObject.optInt("wait");
                    queue.f6001i = jsonObject.optString("waittime");
                    queue.f5999g = jsonObject.optInt(PlatformConstants.CONNECT_EXTRA_KEY);
                    queue.f6000h = jsonObject.optInt("to");
                    queue.f5997e = jsonObject.optInt("type");
                    queueList.add(queue);
                }
                return queueList;
            }
        }
        return null;
    }

    @Deprecated
    /* renamed from: c */
    private static List<C1926f> m7392c(JSONArray jsonArray) {
        if (jsonArray != null) {
            int length = jsonArray.length();
            if (length >= 1) {
                List<C1926f> queueList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    C1926f queue = new C1926f();
                    queue.f5993a = jsonObject.optInt("queueId");
                    queue.f5994b = jsonObject.optString("name");
                    queue.f5995c = jsonObject.optString("qattr");
                    queue.f5996d = jsonObject.optInt("wait");
                    queue.f6001i = jsonObject.optString("waittime");
                    queueList.add(queue);
                }
                return queueList;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m7390a(int queueState) {
        if (queueState <= 0 || queueState >= 5) {
            return false;
        }
        return true;
    }
}
