package com.baidu.mobstat;

import android.content.Context;
import org.json.JSONObject;

class aw implements C3587l {
    /* renamed from: a */
    private ba f19404a = ba.f19429a;
    /* renamed from: b */
    private Object f19405b;
    /* renamed from: c */
    private Class<?> f19406c;

    public aw(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("proxy is null.");
        } else if ("com.baidu.bottom.remote.BPStretegyController2".equals(obj.getClass().getName())) {
            this.f19405b = obj;
            this.f19406c = obj.getClass();
        } else {
            throw new IllegalArgumentException("class isn't com.baidu.bottom.remote.BPStretegyController2");
        }
    }

    /* renamed from: a */
    public void mo2728a(Context context, JSONObject jSONObject) {
        try {
            m15368a(new Object[]{context, jSONObject}, "startDataAnynalyze", new Class[]{Context.class, JSONObject.class});
        } catch (Throwable e) {
            bd.m15432b(e);
            this.f19404a.m15422a(context, jSONObject);
        }
    }

    /* renamed from: a */
    public void mo2727a(Context context, String str) {
        try {
            m15368a(new Object[]{context, str}, "saveRemoteConfig2", new Class[]{Context.class, String.class});
        } catch (Throwable e) {
            bd.m15432b(e);
            this.f19404a.m15421a(context, str);
        }
    }

    /* renamed from: b */
    public void mo2730b(Context context, String str) {
        try {
            m15368a(new Object[]{context, str}, "saveRemoteSign", new Class[]{Context.class, String.class});
        } catch (Throwable e) {
            bd.m15432b(e);
            this.f19404a.m15424b(context, str);
        }
    }

    /* renamed from: a */
    public void mo2726a(Context context, long j) {
        try {
            m15368a(new Object[]{context, Long.valueOf(j)}, "setLastUpdateTime", new Class[]{Context.class, Long.TYPE});
        } catch (Throwable e) {
            bd.m15432b(e);
            this.f19404a.m15420a(context, j);
        }
    }

    /* renamed from: a */
    public boolean mo2729a(Context context) {
        try {
            return ((Boolean) m15368a(new Object[]{context}, "needUpdate", new Class[]{Context.class})).booleanValue();
        } catch (Throwable e) {
            bd.m15432b(e);
            return this.f19404a.m15423a(context);
        }
    }

    /* renamed from: b */
    public boolean mo2731b(Context context) {
        try {
            return ((Boolean) m15368a(new Object[]{context}, "canStartService", new Class[]{Context.class})).booleanValue();
        } catch (Throwable e) {
            bd.m15432b(e);
            return this.f19404a.m15425b(context);
        }
    }

    /* renamed from: a */
    private <T> T m15368a(Object[] objArr, String str, Class<?>[] clsArr) {
        return this.f19406c.getMethod(str, clsArr).invoke(this.f19405b, objArr);
    }
}
