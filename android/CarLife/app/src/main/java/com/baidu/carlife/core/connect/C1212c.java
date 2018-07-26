package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C1260i;

/* compiled from: CarlifeCmdMessage */
/* renamed from: com.baidu.carlife.core.connect.c */
public class C1212c implements C0689h {
    /* renamed from: b */
    private static final String f3299b = "CarlifeCmdMessage";
    /* renamed from: c */
    private static int f3300c = 0;
    /* renamed from: a */
    byte[] f3301a = null;
    /* renamed from: d */
    private int f3302d = 0;
    /* renamed from: e */
    private int f3303e = 0;
    /* renamed from: f */
    private int f3304f = 0;
    /* renamed from: g */
    private int f3305g = 0;

    public C1212c(boolean isSend) {
        if (isSend) {
            int i = f3300c + 1;
            f3300c = i;
            this.f3302d = i;
        }
    }

    /* renamed from: a */
    public boolean m4195a(byte[] msg) {
        if (msg.length != 8) {
            C1260i.m4445e(f3299b, "fromByteArray fail: length not equal");
            return false;
        }
        try {
            m4203d(C1211b.m4188d(new byte[]{msg[0], msg[1]}));
            m4198b(C1211b.m4188d(new byte[]{msg[2], msg[3]}));
            m4201c(C1211b.m4178b(new byte[]{msg[4], msg[5], msg[6], msg[7]}));
            return true;
        } catch (Exception e) {
            C1260i.m4445e(f3299b, "fromByteArray fail: get exception");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public byte[] m4196a() {
        Exception e;
        byte[] bytes = new byte[8];
        try {
            byte[] tmpBytes = C1211b.m4175a(this.f3303e);
            int i = 0 + 1;
            int i2;
            try {
                bytes[0] = tmpBytes[2];
                i2 = i + 1;
                bytes[i] = tmpBytes[3];
                tmpBytes = C1211b.m4175a(this.f3304f);
                i = i2 + 1;
                bytes[i2] = tmpBytes[2];
                i2 = i + 1;
                bytes[i] = tmpBytes[3];
                tmpBytes = C1211b.m4175a(this.f3305g);
                i = i2 + 1;
                bytes[i2] = tmpBytes[0];
                i2 = i + 1;
                bytes[i] = tmpBytes[1];
                i = i2 + 1;
                bytes[i2] = tmpBytes[2];
                i2 = i + 1;
                bytes[i] = tmpBytes[3];
                return bytes;
            } catch (Exception e2) {
                e = e2;
                i2 = i;
                C1260i.m4445e(f3299b, "toByteArray fail: get exception");
                e.printStackTrace();
                return null;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* renamed from: b */
    public int m4197b() {
        return this.f3302d;
    }

    /* renamed from: a */
    public void m4194a(int ind) {
        if (ind < 0 || ind > Integer.MAX_VALUE) {
            C1260i.m4446e(f3299b, "set index fail: %d", Integer.valueOf(ind));
            return;
        }
        this.f3302d = ind;
    }

    /* renamed from: c */
    public int m4200c() {
        return this.f3304f;
    }

    /* renamed from: b */
    public void m4198b(int ty) {
        if (ty < 0 || ty > Integer.MAX_VALUE) {
            C1260i.m4446e(f3299b, "set reserved fail: %d", Integer.valueOf(ty));
            return;
        }
        this.f3304f = ty;
    }

    /* renamed from: d */
    public int m4202d() {
        return this.f3305g;
    }

    /* renamed from: c */
    public void m4201c(int ty) {
        if (ty < 0 || ty > Integer.MAX_VALUE) {
            C1260i.m4446e(f3299b, "set service type fail: %d", Integer.valueOf(ty));
            return;
        }
        this.f3305g = ty;
    }

    /* renamed from: e */
    public int m4204e() {
        return this.f3303e;
    }

    /* renamed from: d */
    public void m4203d(int len) {
        if (len < 0 || len > 32768) {
            C1260i.m4446e(f3299b, "set data len fail: %d", Integer.valueOf(len));
            return;
        }
        this.f3303e = len;
    }

    /* renamed from: f */
    public byte[] m4205f() {
        return this.f3301a;
    }

    /* renamed from: b */
    public void m4199b(byte[] obj) {
        this.f3301a = obj;
    }
}
