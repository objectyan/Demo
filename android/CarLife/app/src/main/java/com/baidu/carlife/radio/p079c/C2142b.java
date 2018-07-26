package com.baidu.carlife.radio.p079c;

import android.text.TextUtils;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.carlife.radio.p102a.C2105a;
import com.baidu.carlife.util.C2177h;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RadioCache */
/* renamed from: com.baidu.carlife.radio.c.b */
public class C2142b {
    /* renamed from: a */
    protected static final String f6817a = "radio_channel_cache";
    /* renamed from: b */
    public static final String f6818b = "10";
    /* renamed from: c */
    private static final String f6819c = "radio_channel_list.json";
    /* renamed from: d */
    private static final String f6820d = "radio_channel_list.json";
    /* renamed from: e */
    private static boolean f6821e = true;
    /* renamed from: f */
    private static final long f6822f = 10800;
    /* renamed from: g */
    private List<C2105a> f6823g;
    /* renamed from: h */
    private long f6824h;

    /* compiled from: RadioCache */
    /* renamed from: com.baidu.carlife.radio.c.b$a */
    private static class C2141a {
        /* renamed from: a */
        public static final C2142b f6816a = new C2142b();

        private C2141a() {
        }
    }

    private C2142b() {
        this.f6823g = new ArrayList();
        this.f6824h = 0;
    }

    /* renamed from: a */
    public static C2142b m8067a() {
        return C2141a.f6816a;
    }

    /* renamed from: b */
    public boolean m8075b() {
        return f6821e;
    }

    /* renamed from: a */
    public void m8072a(boolean enable) {
        f6821e = enable;
    }

    /* renamed from: a */
    public boolean m8073a(String channelId) {
        return TextUtils.equals(channelId, f6818b);
    }

    /* renamed from: c */
    public C2105a m8076c() {
        C2105a channelModel = new C2105a();
        channelModel.m7894a(f6818b);
        channelModel.m7896b("语音点播");
        channelModel.m7898c("res://com.baidu.carlife/2130839326");
        channelModel.m7900d("CONTENT_REC_0011");
        return channelModel;
    }

    /* renamed from: b */
    public String m8074b(String channelId) {
        C2105a channelModel = m8077c(channelId);
        return channelModel == null ? "" : channelModel.m7897c();
    }

    /* renamed from: d */
    public C2105a m8078d() {
        if (this.f6823g.size() == 0) {
            m8080e();
        }
        return this.f6823g.size() == 0 ? null : (C2105a) this.f6823g.get(0);
    }

    /* renamed from: c */
    public C2105a m8077c(String channelId) {
        if (this.f6823g.size() == 0) {
            m8080e();
        }
        for (C2105a channel : this.f6823g) {
            if (channel.m7893a().equals(channelId)) {
                return channel;
            }
        }
        return this.f6823g.size() == 0 ? null : (C2105a) this.f6823g.get(0);
    }

    /* renamed from: e */
    public List<C2105a> m8080e() {
        if (this.f6823g.size() > 0) {
            C1260i.m4440c(f6817a, "use memory cache");
            return this.f6823g;
        }
        String json = m8070h();
        if (TextUtils.isEmpty(json)) {
            this.f6823g = m8068e(m8071i());
        } else {
            this.f6823g = m8068e(json);
            if (this.f6823g.size() == 0) {
                this.f6823g = m8068e(m8071i());
            }
        }
        this.f6823g.add(m8076c());
        return this.f6823g;
    }

    /* renamed from: d */
    public void m8079d(String data) {
        C1260i.m4440c(f6817a, "write cache data");
        this.f6823g.clear();
        this.f6824h = 0;
        FileOutputStream fos = null;
        try {
            fos = C1157a.m3876a().openFileOutput("radio_channel_list.json", 0);
            fos.write(data.getBytes("UTF-8"));
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            }
        }
    }

    /* renamed from: f */
    public boolean m8081f() {
        if (this.f6824h == 0) {
            this.f6824h = m8069g();
        }
        return (System.currentTimeMillis() / 1000) - this.f6824h < f6822f;
    }

    /* renamed from: g */
    private long m8069g() {
        C1260i.m4440c(f6817a, "get cache time");
        try {
            String json = m8070h();
            if (!TextUtils.isEmpty(json)) {
                return new JSONObject(json).getLong(C2125n.f6748P);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /* renamed from: h */
    private String m8070h() {
        C1260i.m4440c(f6817a, "read cache data");
        FileInputStream fis = null;
        try {
            fis = C1157a.m3876a().openFileInput("radio_channel_list.json");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            String data = new String(buffer, "UTF-8");
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return data;
                }
            }
            return data;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (fis == null) {
                return null;
            }
            try {
                fis.close();
                return null;
            } catch (Exception e22) {
                e22.printStackTrace();
                return null;
            }
        } catch (Throwable th) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            }
        }
    }

    /* renamed from: i */
    private String m8071i() {
        C1260i.m4440c(f6817a, "read default data");
        return C2177h.m8268a(C1157a.m3876a(), "radio_channel_list.json");
    }

    /* renamed from: e */
    private List<C2105a> m8068e(String json) {
        List<C2105a> list = new ArrayList();
        try {
            JSONArray jsonArray = new JSONObject(json).getJSONObject("data").getJSONArray("list");
            int len = jsonArray.length();
            for (int i = 0; i < len; i++) {
                C2105a model = new C2105a();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                model.m7894a(jsonObject.getString("channel_id"));
                model.m7896b(jsonObject.getString("name"));
                model.m7898c(jsonObject.getString("picture"));
                model.m7900d(jsonObject.getString(C2125n.ar));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            list.clear();
        }
        return list;
    }
}
