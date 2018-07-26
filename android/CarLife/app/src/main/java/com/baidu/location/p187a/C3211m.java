package com.baidu.location.p187a;

import android.location.Location;
import com.baidu.carlife.core.C1253f;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3380a;
import com.baidu.location.p188h.C3390f;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p189b.C3218c;
import com.baidu.location.p189b.C3220d;
import com.baidu.location.p190c.C3232a;
import com.baidu.location.p190c.C3243b;
import com.baidu.location.p193e.C3335a;
import com.baidu.location.p193e.C3349d;
import com.baidu.location.p193e.C3349d.C3346a;
import com.baidu.location.p193e.C3349d.C3347b;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3364b;
import com.baidu.location.p194f.C3371d;
import com.baidu.location.p194f.C3372e;
import com.baidu.location.p194f.C3376f;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.m */
public class C3211m {
    /* renamed from: A */
    private static C3211m f17452A = null;
    /* renamed from: b */
    private static ArrayList<String> f17453b = new ArrayList();
    /* renamed from: c */
    private static ArrayList<String> f17454c = new ArrayList();
    /* renamed from: d */
    private static ArrayList<String> f17455d = new ArrayList();
    /* renamed from: e */
    private static String f17456e = (C3390f.f18346a + "/yo.dat");
    /* renamed from: f */
    private static final String f17457f = (C3390f.f18346a + "/yoh.dat");
    /* renamed from: g */
    private static final String f17458g = (C3390f.f18346a + "/yom.dat");
    /* renamed from: h */
    private static final String f17459h = (C3390f.f18346a + "/yol.dat");
    /* renamed from: i */
    private static final String f17460i = (C3390f.f18346a + "/yor.dat");
    /* renamed from: j */
    private static File f17461j = null;
    /* renamed from: k */
    private static int f17462k = 8;
    /* renamed from: l */
    private static int f17463l = 8;
    /* renamed from: m */
    private static int f17464m = 16;
    /* renamed from: n */
    private static int f17465n = 1024;
    /* renamed from: o */
    private static double f17466o = 0.0d;
    /* renamed from: p */
    private static double f17467p = 0.1d;
    /* renamed from: q */
    private static double f17468q = 30.0d;
    /* renamed from: r */
    private static double f17469r = 100.0d;
    /* renamed from: s */
    private static int f17470s = 0;
    /* renamed from: t */
    private static int f17471t = 64;
    /* renamed from: u */
    private static int f17472u = 128;
    /* renamed from: v */
    private static Location f17473v = null;
    /* renamed from: w */
    private static Location f17474w = null;
    /* renamed from: x */
    private static Location f17475x = null;
    /* renamed from: y */
    private static C3372e f17476y = null;
    /* renamed from: B */
    private int f17477B;
    /* renamed from: a */
    long f17478a;
    /* renamed from: z */
    private C3210a f17479z;

    /* renamed from: com.baidu.location.a.m$a */
    private class C3210a extends C3186e {
        /* renamed from: a */
        boolean f17446a;
        /* renamed from: b */
        int f17447b;
        /* renamed from: c */
        int f17448c;
        /* renamed from: d */
        final /* synthetic */ C3211m f17449d;
        /* renamed from: e */
        private ArrayList<String> f17450e;
        /* renamed from: f */
        private boolean f17451f;

        public C3210a(C3211m c3211m) {
            this.f17449d = c3211m;
            this.f17446a = false;
            this.f17447b = 0;
            this.f17448c = 0;
            this.f17450e = null;
            this.f17451f = true;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            if (this.f17447b != 1) {
                this.h = C3391g.m14453i();
            }
            this.i = 2;
            if (this.f17450e != null) {
                for (int i = 0; i < this.f17450e.size(); i++) {
                    if (this.f17447b == 1) {
                        this.k.put("cldc[" + i + "]", this.f17450e.get(i));
                    } else {
                        this.k.put("cltr[" + i + "]", this.f17450e.get(i));
                    }
                }
                this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                if (this.f17447b != 1) {
                    this.k.put("qt", "cltrg");
                }
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (z && this.j != null) {
                if (this.f17450e != null) {
                    this.f17450e.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f17451f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f17446a = false;
        }

        /* renamed from: b */
        public void mo2500b() {
            if (!this.f17446a) {
                if (o <= 4 || this.f17448c >= o) {
                    this.f17448c = 0;
                    this.f17446a = true;
                    this.f17447b = 0;
                    if (this.f17450e == null || this.f17450e.size() < 1) {
                        if (this.f17450e == null) {
                            this.f17450e = new ArrayList();
                        }
                        this.f17447b = 0;
                        int i = 0;
                        while (true) {
                            String b = this.f17447b < 2 ? C3211m.m13451b() : null;
                            if (b == null && this.f17447b != 1 && this.f17451f) {
                                this.f17447b = 2;
                                try {
                                    b = C3190d.m13320b();
                                } catch (Exception e) {
                                    b = null;
                                }
                            } else {
                                this.f17447b = 1;
                            }
                            if (b == null) {
                                break;
                            } else if (!b.contains("err!")) {
                                this.f17450e.add(b);
                                i += b.length();
                                if (i >= C3380a.f18310i) {
                                    break;
                                }
                            }
                        }
                    }
                    if (this.f17450e == null || this.f17450e.size() < 1) {
                        this.f17450e = null;
                        this.f17446a = false;
                        return;
                    } else if (this.f17447b != 1) {
                        m13299c(C3391g.m14453i());
                        return;
                    } else {
                        m13299c(C3391g.f18379f);
                        return;
                    }
                }
                this.f17448c++;
            }
        }
    }

    private C3211m() {
        this.f17479z = null;
        this.f17477B = 0;
        this.f17478a = 0;
        this.f17479z = new C3210a(this);
        this.f17477B = 0;
    }

    /* renamed from: a */
    private static synchronized int m13440a(List<String> list, int i) {
        int i2;
        synchronized (C3211m.class) {
            if (list == null || i > 256 || i < 0) {
                i2 = -1;
            } else {
                try {
                    if (f17461j == null) {
                        f17461j = new File(f17456e);
                        if (!f17461j.exists()) {
                            f17461j = null;
                            i2 = -2;
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f17461j, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        i2 = -3;
                    } else {
                        randomAccessFile.seek((long) i);
                        i2 = randomAccessFile.readInt();
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        long readLong = randomAccessFile.readLong();
                        if (!C3211m.m13446a(i2, readInt, readInt2, readInt3, readLong) || readInt < 1) {
                            randomAccessFile.close();
                            i2 = -4;
                        } else {
                            byte[] bArr = new byte[f17465n];
                            int i3 = readInt;
                            readInt = f17462k;
                            while (readInt > 0 && i3 > 0) {
                                randomAccessFile.seek(((long) ((((i2 + i3) - 1) % readInt2) * readInt3)) + readLong);
                                int readInt4 = randomAccessFile.readInt();
                                if (readInt4 > 0 && readInt4 < readInt3) {
                                    randomAccessFile.read(bArr, 0, readInt4);
                                    if (bArr[readInt4 - 1] == (byte) 0) {
                                        list.add(new String(bArr, 0, readInt4 - 1));
                                    }
                                }
                                readInt--;
                                i3--;
                            }
                            randomAccessFile.seek((long) i);
                            randomAccessFile.writeInt(i2);
                            randomAccessFile.writeInt(i3);
                            randomAccessFile.writeInt(readInt2);
                            randomAccessFile.writeInt(readInt3);
                            randomAccessFile.writeLong(readLong);
                            randomAccessFile.close();
                            i2 = f17462k - readInt;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    i2 = -5;
                }
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static synchronized C3211m m13441a() {
        C3211m c3211m;
        synchronized (C3211m.class) {
            if (f17452A == null) {
                f17452A = new C3211m();
            }
            c3211m = f17452A;
        }
        return c3211m;
    }

    /* renamed from: a */
    public static String m13442a(int i) {
        String str;
        String str2 = null;
        String str3;
        if (i == 1) {
            str3 = f17457f;
            str = str3;
            List list = f17453b;
        } else if (i == 2) {
            str3 = f17458g;
            str = str3;
            r2 = f17454c;
        } else if (i == 3) {
            str3 = f17459h;
            str = str3;
            r2 = f17455d;
        } else if (i != 4) {
            return null;
        } else {
            str3 = f17460i;
            str = str3;
            r2 = f17455d;
        }
        if (list == null) {
            return null;
        }
        if (list.size() < 1) {
            C3211m.m13450a(str, list);
        }
        synchronized (C3211m.class) {
            int size = list.size();
            if (size > 0) {
                try {
                    str = (String) list.get(size - 1);
                    try {
                        list.remove(size - 1);
                    } catch (Exception e) {
                        str2 = str;
                        str = str2;
                        return str;
                    }
                } catch (Exception e2) {
                    str = str2;
                    return str;
                }
            }
            str = null;
        }
        return str;
    }

    /* renamed from: a */
    public static void m13443a(int i, boolean z) {
        String str;
        Object obj;
        String str2;
        if (i == 1) {
            str2 = f17457f;
            if (!z) {
                str = str2;
                List list = f17453b;
            } else {
                return;
            }
        } else if (i == 2) {
            str2 = f17458g;
            if (z) {
                str = str2;
                obj = f17453b;
            } else {
                str = str2;
                obj = f17454c;
            }
        } else if (i == 3) {
            str2 = f17459h;
            if (z) {
                str = str2;
                obj = f17454c;
            } else {
                str = str2;
                obj = f17455d;
            }
        } else if (i == 4) {
            str2 = f17460i;
            if (z) {
                str = str2;
                obj = f17455d;
            } else {
                return;
            }
        } else {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            C3211m.m13445a(str);
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            int readInt4 = randomAccessFile.readInt();
            int readInt5 = randomAccessFile.readInt();
            int size = list.size();
            int i2 = readInt5;
            while (size > f17463l) {
                readInt5 = z ? i2 + 1 : i2;
                byte[] bytes;
                if (readInt3 >= readInt) {
                    if (!z) {
                        obj = 1;
                        i2 = readInt5;
                        break;
                    }
                    randomAccessFile.seek((long) ((readInt4 * readInt2) + 128));
                    bytes = (((String) list.get(0)) + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    list.remove(0);
                    i2 = readInt4 + 1;
                    if (i2 > readInt3) {
                        i2 = 0;
                    }
                    readInt4 = readInt3;
                } else {
                    randomAccessFile.seek((long) ((readInt2 * readInt3) + 128));
                    bytes = (((String) list.get(0)) + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    list.remove(0);
                    int i3 = readInt4;
                    readInt4 = readInt3 + 1;
                    i2 = i3;
                }
                size--;
                readInt3 = readInt4;
                readInt4 = i2;
                i2 = readInt5;
            }
            obj = null;
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.writeInt(readInt4);
            randomAccessFile.writeInt(i2);
            randomAccessFile.close();
            if (obj != null && i < 4) {
                C3211m.m13443a(i + 1, true);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m13444a(C3362a c3362a, C3372e c3372e, Location location, String str) {
        if (!C3220d.m13499a().f17519a) {
            return;
        }
        if ((C3391g.f18394u != 3 || C3211m.m13448a(location, c3372e) || C3211m.m13449a(location, false)) && c3362a != null && !c3362a.m14249c()) {
            BDLocation a;
            String str2;
            if (C3335a.m14038a().f18053a) {
                if (C3335a.m14038a().m14056a(true).getLocType() == 66) {
                    str = str + String.format(Locale.CHINA, "&ofrt=%f|%f|%d", new Object[]{Double.valueOf(r0.getLongitude()), Double.valueOf(r0.getLatitude()), Integer.valueOf((int) r0.getRadius())});
                }
            }
            BDLocation a2 = C3243b.m13581a().m13589a(c3362a, c3372e, false, location);
            if (a2 != null && a2.getLocType() == 66) {
                str = str + String.format(Locale.CHINA, "&of2t=%.6f|%.6f|%d|%s", new Object[]{Double.valueOf(a2.getLongitude()), Double.valueOf(a2.getLatitude()), Integer.valueOf((int) a2.getRadius()), a2.getNetworkLocationType()});
            }
            if (C3391g.m14437a(C3377f.getServiceContext())) {
                a = C3349d.m14171a().m14182a(c3362a, c3372e, null, C3347b.IS_MIX_MODE, C3346a.NO_NEED_TO_LOG);
            } else {
                a = C3349d.m14171a().m14182a(c3362a, c3372e, null, C3347b.IS_NOT_MIX_MODE, C3346a.NO_NEED_TO_LOG);
            }
            if (a == null || a.getLocType() == 67) {
                str2 = str + String.format(Locale.CHINA, "&ofl=%s|0", new Object[]{"1"});
            } else {
                int i = 0;
                String str3 = null;
                if (!(a == null || a.getNetworkLocationType() == null)) {
                    str3 = a.getNetworkLocationType();
                }
                if (str3 != null && str3.equals("cl")) {
                    i = 1;
                } else if (str3 != null && str3.equals("wf")) {
                    i = 2;
                }
                str2 = str + String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[]{"1", Integer.valueOf(i), Double.valueOf(a.getLongitude()), Double.valueOf(a.getLatitude()), Integer.valueOf((int) a.getRadius())});
            }
            if (c3362a != null && c3362a.m14246a()) {
                if (!C3211m.m13448a(location, c3372e)) {
                    c3372e = null;
                }
                str2 = C3391g.m14433a(c3362a, c3372e, location, str2, 1);
                if (str2 != null) {
                    C3211m.m13453c(Jni.encode(str2));
                    f17474w = location;
                    f17473v = location;
                    if (c3372e != null) {
                        f17476y = c3372e;
                    }
                }
            } else if (c3372e != null && c3372e.m14354n() && C3211m.m13448a(location, c3372e)) {
                if (!C3211m.m13447a(location) && !C3364b.m14262a().m14278d()) {
                    str2 = "&cfr=1" + str2;
                } else if (!C3211m.m13447a(location) && C3364b.m14262a().m14278d()) {
                    str2 = "&cfr=3" + str2;
                } else if (C3364b.m14262a().m14278d()) {
                    str2 = "&cfr=2" + str2;
                }
                str2 = C3391g.m14433a(c3362a, c3372e, location, str2, 2);
                if (str2 != null) {
                    C3211m.m13454d(Jni.encode(str2));
                    f17475x = location;
                    f17473v = location;
                    if (c3372e != null) {
                        f17476y = c3372e;
                    }
                }
            } else {
                if (!C3211m.m13447a(location) && !C3364b.m14262a().m14278d()) {
                    str2 = "&cfr=1" + str2;
                } else if (!C3211m.m13447a(location) && C3364b.m14262a().m14278d()) {
                    str2 = "&cfr=3" + str2;
                } else if (C3364b.m14262a().m14278d()) {
                    str2 = "&cfr=2" + str2;
                }
                if (!C3211m.m13448a(location, c3372e)) {
                    c3372e = null;
                }
                if (c3362a != null || c3372e != null) {
                    str2 = C3391g.m14433a(c3362a, c3372e, location, str2, 3);
                    if (str2 != null) {
                        C3211m.m13455e(Jni.encode(str2));
                        f17473v = location;
                        if (c3372e != null) {
                            f17476y = c3372e;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m13445a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(C3390f.f18346a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(32);
                randomAccessFile.writeInt(2048);
                randomAccessFile.writeInt(C1253f.fm);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private static boolean m13446a(int i, int i2, int i3, int i4, long j) {
        return i >= 0 && i < i3 && i2 >= 0 && i2 <= i3 && i3 >= 0 && i3 <= 1024 && i4 >= 128 && i4 <= 1024;
    }

    /* renamed from: a */
    private static boolean m13447a(Location location) {
        if (location == null) {
            return false;
        }
        if (f17474w == null || f17473v == null) {
            f17474w = location;
            return true;
        }
        double distanceTo = (double) location.distanceTo(f17474w);
        return ((double) location.distanceTo(f17473v)) > ((distanceTo * ((double) C3391g.f18366S)) + ((((double) C3391g.f18365R) * distanceTo) * distanceTo)) + ((double) C3391g.f18367T);
    }

    /* renamed from: a */
    private static boolean m13448a(Location location, C3372e c3372e) {
        if (location == null || c3372e == null || c3372e.f18275a == null || c3372e.f18275a.isEmpty() || c3372e.m14337b(f17476y)) {
            return false;
        }
        if (f17475x != null) {
            return true;
        }
        f17475x = location;
        return true;
    }

    /* renamed from: a */
    public static boolean m13449a(Location location, boolean z) {
        return C3371d.m14297a(f17473v, location, z);
    }

    /* renamed from: a */
    public static boolean m13450a(String str, List<String> list) {
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
            byte[] bArr = new byte[f17465n];
            int i = readInt2;
            readInt2 = f17463l + 1;
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
    public static String m13451b() {
        return C3211m.m13456f();
    }

    /* renamed from: b */
    public static synchronized void m13452b(String str) {
        synchronized (C3211m.class) {
            if (!str.contains("err!")) {
                List list;
                int i = C3391g.f18389p;
                if (i == 1) {
                    list = f17453b;
                } else if (i == 2) {
                    list = f17454c;
                } else if (i == 3) {
                    list = f17455d;
                }
                if (list != null) {
                    if (list.size() <= f17464m) {
                        list.add(str);
                    }
                    if (list.size() >= f17464m) {
                        C3211m.m13443a(i, false);
                    }
                    while (list.size() > f17464m) {
                        list.remove(0);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private static void m13453c(String str) {
        C3211m.m13452b(str);
    }

    /* renamed from: d */
    private static void m13454d(String str) {
        C3211m.m13452b(str);
    }

    /* renamed from: e */
    private static void m13455e(String str) {
        C3211m.m13452b(str);
    }

    /* renamed from: f */
    public static String m13456f() {
        String str = null;
        for (int i = 1; i < 5; i++) {
            str = C3211m.m13442a(i);
            if (str != null) {
                return str;
            }
        }
        C3211m.m13440a(f17455d, f17471t);
        if (f17455d.size() > 0) {
            str = (String) f17455d.get(0);
            f17455d.remove(0);
        }
        if (str != null) {
            return str;
        }
        C3211m.m13440a(f17455d, f17470s);
        if (f17455d.size() > 0) {
            str = (String) f17455d.get(0);
            f17455d.remove(0);
        }
        if (str != null) {
            return str;
        }
        C3211m.m13440a(f17455d, f17472u);
        if (f17455d.size() <= 0) {
            return str;
        }
        str = (String) f17455d.get(0);
        f17455d.remove(0);
        return str;
    }

    /* renamed from: g */
    public static void m13457g() {
        f17463l = 0;
        C3211m.m13443a(1, false);
        C3211m.m13443a(2, false);
        C3211m.m13443a(3, false);
        f17463l = 8;
    }

    /* renamed from: h */
    public static String m13458h() {
        RandomAccessFile randomAccessFile;
        int readInt;
        File file = new File(f17458g);
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    String str = "&p1=" + readInt;
                    randomAccessFile.seek(20);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
        file = new File(f17459h);
        if (file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20);
                readInt = randomAccessFile.readInt();
                if (readInt > 256) {
                    str = "&p2=" + readInt;
                    randomAccessFile.seek(20);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
            } catch (Exception e2) {
            }
        }
        file = new File(f17460i);
        if (!file.exists()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(20);
            readInt = randomAccessFile.readInt();
            if (readInt > 512) {
                str = "&p3=" + readInt;
                randomAccessFile.seek(20);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
                return str;
            }
            randomAccessFile.close();
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    /* renamed from: c */
    public void m13459c() {
        if (C3218c.m13487a().m13494e() && this.f17478a != 0 && System.currentTimeMillis() - this.f17478a > 1200000) {
            m13460d();
        }
    }

    /* renamed from: d */
    public void m13460d() {
        this.f17478a = System.currentTimeMillis();
        if (!C3232a.m13554b().m13563d()) {
            this.f17477B++;
            if (this.f17477B > 1) {
                this.f17477B = 0;
                m13461e();
            }
        }
    }

    /* renamed from: e */
    public void m13461e() {
        if (C3376f.m14363j()) {
            this.f17479z.mo2500b();
        }
    }
}
