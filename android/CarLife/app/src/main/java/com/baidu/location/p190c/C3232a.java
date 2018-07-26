package com.baidu.location.p190c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C1253f;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p191d.p192a.C3264d;
import com.baidu.location.p194f.C3376f;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.c.a */
public class C3232a extends C3186e {
    /* renamed from: f */
    static C3232a f17562f = null;
    /* renamed from: v */
    private static int f17563v = 3;
    /* renamed from: w */
    private static int f17564w = C1253f.fQ;
    /* renamed from: a */
    ArrayList<String> f17565a;
    /* renamed from: b */
    boolean f17566b;
    /* renamed from: c */
    long f17567c;
    /* renamed from: d */
    long f17568d;
    /* renamed from: e */
    int f17569e;
    /* renamed from: p */
    private Handler f17570p;
    /* renamed from: q */
    private C3231a f17571q;
    /* renamed from: r */
    private int f17572r;
    /* renamed from: s */
    private SharedPreferences f17573s;
    /* renamed from: t */
    private long f17574t;
    /* renamed from: u */
    private String f17575u;
    /* renamed from: x */
    private String f17576x;
    /* renamed from: y */
    private boolean f17577y;

    /* renamed from: com.baidu.location.c.a$1 */
    class C32301 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3232a f17557a;

        C32301(C3232a c3232a) {
            this.f17557a = c3232a;
        }

        public void handleMessage(Message message) {
            if (C3377f.isServing) {
                switch (message.what) {
                    case 1:
                        this.f17557a.m13557f();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.c.a$a */
    class C3231a extends C3186e {
        /* renamed from: a */
        String f17558a = null;
        /* renamed from: b */
        int f17559b = 0;
        /* renamed from: c */
        boolean f17560c = false;
        /* renamed from: d */
        final /* synthetic */ C3232a f17561d;

        C3231a(C3232a c3232a) {
            this.f17561d = c3232a;
        }

        /* renamed from: a */
        public void mo2494a() {
            String a;
            this.l = this.f17558a;
            try {
                a = C3391g.m14435a(new File(this.l), "MD5");
            } catch (Exception e) {
                a = null;
            }
            this.h = C3391g.m14452h() + "?&qt=indoor&trtm=" + System.currentTimeMillis();
            if (a != null) {
                this.h += "&md5=" + a;
            }
            this.i = 1;
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z) {
                try {
                    new File(this.f17558a).delete();
                    this.f17559b = 0;
                } catch (Exception e) {
                }
            } else {
                this.f17559b += 2;
            }
            this.f17558a = null;
            this.f17560c = false;
            this.f17561d.f17570p.sendEmptyMessageDelayed(1, 1500);
        }

        /* renamed from: b */
        public boolean mo2500b() {
            if (this.f17560c) {
                return true;
            }
            this.f17558a = C3264d.m13668a().m13677b();
            if (this.f17558a == null) {
                return false;
            }
            this.f17560c = true;
            m13302j();
            return true;
        }
    }

    public C3232a() {
        this.f17565a = null;
        this.f17566b = false;
        this.f17567c = 0;
        this.f17568d = 0;
        this.f17569e = 0;
        this.f17570p = null;
        this.f17571q = null;
        this.f17572r = 0;
        this.f17573s = null;
        this.f17574t = 0;
        this.f17575u = null;
        this.f17577y = true;
        this.k = new HashMap();
        this.f17571q = new C3231a(this);
        this.i = 2;
        this.f17570p = new C32301(this);
        try {
            this.f17576x = C3377f.getServiceContext().getFilesDir() + File.separator + "lltg" + File.separator + "llg.dat";
        } catch (Exception e) {
            e.printStackTrace();
            this.f17576x = null;
        }
        m13556e();
    }

    /* renamed from: a */
    private synchronized void m13551a(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            m13555b(str);
        }
        try {
            int i;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            int readInt5 = randomAccessFile.readInt();
            if (readInt3 < readInt) {
                randomAccessFile.seek((long) ((readInt2 * readInt3) + 128));
                byte[] bytes = (str2 + '\u0000').getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes, 0, bytes.length);
                i = readInt3 + 1;
            } else {
                randomAccessFile.seek((long) ((readInt4 * readInt2) + 128));
                byte[] bytes2 = (str2 + '\u0000').getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2, 0, bytes2.length);
                readInt4++;
                if (readInt4 > readInt3) {
                    readInt4 = 0;
                    i = readInt3;
                } else {
                    i = readInt3;
                }
            }
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(i);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeInt(readInt5);
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m13552a(String str, List<String> list) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            byte[] bArr = new byte[f17564w];
            int i = readInt2;
            readInt2 = f17563v + 1;
            boolean z = false;
            while (readInt2 > 0 && i > 0) {
                if (i < readInt3) {
                    readInt3 = 0;
                }
                try {
                    randomAccessFile.seek((long) (((i - 1) * readInt) + 128));
                    int readInt4 = randomAccessFile.readInt();
                    if (readInt4 > 0 && readInt4 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt4);
                        if (bArr[readInt4 - 1] == (byte) 0) {
                            list.add(0, new String(bArr, 0, readInt4 - 1));
                            z = true;
                        }
                    }
                    readInt2--;
                    i--;
                } catch (Exception e) {
                    return z;
                }
            }
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(i);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.close();
            return z;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: b */
    public static C3232a m13554b() {
        if (f17562f == null) {
            f17562f = new C3232a();
        }
        return f17562f;
    }

    /* renamed from: b */
    private void m13555b(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(C3377f.getServiceContext().getFilesDir() + File.separator + "lltg");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(32);
                randomAccessFile.writeInt(500);
                randomAccessFile.writeInt(2040);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m13556e() {
        if (this.f17573s == null) {
            this.f17573s = C3377f.getServiceContext().getSharedPreferences("ltconfig", 0);
        }
        if (this.f17573s != null) {
            try {
                this.f17574t = this.f17573s.getLong("tt", 0);
                this.f17575u = this.f17573s.getString("cfg", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    private void m13557f() {
        if (o >= 6 || this.f17572r >= 10 || !C3218c.m13487a().m13494e()) {
            this.f17572r = 0;
            return;
        }
        this.f17572r++;
        if (!m13563d()) {
            this.f17572r = 0;
        }
    }

    /* renamed from: a */
    public void mo2494a() {
        this.k.put("qt", "cltr");
        try {
            this.k.put("info", Jni.encode(C3381b.m14398a().m14405d()));
        } catch (Exception e) {
        }
        for (int i = 0; i < this.f17565a.size(); i++) {
            this.k.put("cltr[" + i + "]", this.f17565a.get(i));
        }
        this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        if (System.currentTimeMillis() - this.f17574t > 86400000) {
            this.k.put("cfg", Integer.valueOf(1));
        }
        this.h = C3391g.m14453i();
    }

    /* renamed from: a */
    public void m13559a(String str) {
        if (this.f17576x != null) {
            m13551a(this.f17576x, str);
        }
    }

    /* renamed from: a */
    public void mo2495a(boolean z) {
        if (this.f17565a != null) {
            this.f17565a.clear();
        }
        if (!z || this.j == null) {
            this.f17567c = 0;
        } else {
            try {
                String str = this.j;
                JSONObject jSONObject = new JSONObject(this.j);
                if (jSONObject != null && jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                    this.f17577y = false;
                }
                if (!(jSONObject == null || !jSONObject.has("cfg") || this.f17573s == null)) {
                    try {
                        Editor edit = this.f17573s.edit();
                        edit.putLong("tt", System.currentTimeMillis());
                        this.f17574t = System.currentTimeMillis();
                        edit.putString("cfg", jSONObject.getJSONObject("cfg").toString());
                        edit.commit();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.k != null) {
            this.k.clear();
        }
        this.f17566b = false;
        this.f17570p.sendEmptyMessageDelayed(1, 1500);
    }

    /* renamed from: b */
    public boolean m13561b(boolean z) {
        if (this.f17566b || !this.f17577y) {
            return true;
        }
        if (System.currentTimeMillis() - this.f17567c < 7200000) {
            return false;
        }
        if (System.currentTimeMillis() - this.f17568d > 3600000) {
            this.f17569e = 0;
        }
        if (this.f17569e > 10 && z) {
            return false;
        }
        C3376f.m14355a();
        if (!C3376f.m14363j()) {
            return false;
        }
        if (!C3218c.m13487a().m13494e() && z) {
            return false;
        }
        if (this.f17565a == null || this.f17565a.size() < 1) {
            if (C3391g.m14457m() == null || this.f17576x == null) {
                return false;
            }
            if (this.f17565a == null) {
                this.f17565a = new ArrayList();
            }
            m13552a(this.f17576x, this.f17565a);
        }
        if (this.f17565a == null || this.f17565a.size() <= 0) {
            return false;
        }
        this.f17569e++;
        this.f17568d = System.currentTimeMillis();
        this.f17566b = true;
        m13299c(C3391g.m14453i());
        return true;
    }

    /* renamed from: c */
    public String mo2499c() {
        return this.f17575u;
    }

    /* renamed from: d */
    public boolean m13563d() {
        C3376f.m14355a();
        return !C3376f.m14363j() ? false : !m13561b(true) ? this.f17571q.mo2500b() : true;
    }
}
