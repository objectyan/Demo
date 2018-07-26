package com.baidu.location.p187a;

import android.location.Location;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3390f;
import com.baidu.location.p188h.C3391g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

/* renamed from: com.baidu.location.a.d */
public class C3190d {
    /* renamed from: a */
    private static C3190d f17326a = null;
    /* renamed from: b */
    private static String f17327b = "Temp_in.dat";
    /* renamed from: c */
    private static File f17328c = new File(C3390f.f18346a, f17327b);
    /* renamed from: d */
    private static StringBuffer f17329d = null;
    /* renamed from: e */
    private static boolean f17330e = true;
    /* renamed from: f */
    private static int f17331f = 0;
    /* renamed from: g */
    private static int f17332g = 0;
    /* renamed from: h */
    private static long f17333h = 0;
    /* renamed from: i */
    private static long f17334i = 0;
    /* renamed from: j */
    private static long f17335j = 0;
    /* renamed from: k */
    private static double f17336k = 0.0d;
    /* renamed from: l */
    private static double f17337l = 0.0d;
    /* renamed from: m */
    private static int f17338m = 0;
    /* renamed from: n */
    private static int f17339n = 0;
    /* renamed from: o */
    private static int f17340o = 0;
    /* renamed from: p */
    private String f17341p = null;
    /* renamed from: q */
    private boolean f17342q = true;

    private C3190d(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.f17341p = str;
    }

    /* renamed from: a */
    public static C3190d m13315a() {
        if (f17326a == null) {
            f17326a = new C3190d(C3381b.m14398a().m14407f());
        }
        return f17326a;
    }

    /* renamed from: a */
    private String m13316a(int i) {
        if (!f17328c.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(f17328c, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            if (!C3190d.m13317a(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
                randomAccessFile.close();
                C3190d.m13322d();
                return null;
            } else if (i == 0 || i == readInt + 1) {
                randomAccessFile.close();
                return null;
            } else {
                long j = (12 + 0) + ((long) ((i - 1) * 1024));
                randomAccessFile.seek(j);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.seek(j + 4);
                for (readInt = 0; readInt < readInt2; readInt++) {
                    bArr[readInt] = randomAccessFile.readByte();
                }
                randomAccessFile.close();
                return new String(bArr);
            }
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m13317a(int i, int i2, int i3) {
        return (i < 0 || i > C3391g.ad) ? false : (i2 < 0 || i2 > i + 1) ? false : i3 >= 1 && i3 <= i + 1 && i3 <= C3391g.ad;
    }

    /* renamed from: a */
    private boolean m13318a(Location location, int i, int i2) {
        if (location == null || !C3391g.f18373Z || !this.f17342q) {
            return false;
        }
        if (C3391g.ab < 5) {
            C3391g.ab = 5;
        } else if (C3391g.ab > 1000) {
            C3391g.ab = 1000;
        }
        if (C3391g.ac < 5) {
            C3391g.ac = 5;
        } else if (C3391g.ac > 3600) {
            C3391g.ac = 3600;
        }
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        long time = location.getTime() / 1000;
        if (f17330e) {
            f17331f = 1;
            f17329d = new StringBuffer("");
            f17329d.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", new Object[]{this.f17341p, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)}));
            f17332g = f17329d.length();
            f17333h = time;
            f17336k = longitude;
            f17337l = latitude;
            f17334i = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            f17335j = (long) Math.floor((latitude * 100000.0d) + 0.5d);
            f17330e = false;
            return true;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(latitude, longitude, f17337l, f17336k, fArr);
        long j = time - f17333h;
        if (fArr[0] < ((float) C3391g.ab) && j < ((long) C3391g.ac)) {
            return false;
        }
        if (f17329d == null) {
            f17331f++;
            f17332g = 0;
            f17329d = new StringBuffer("");
            f17329d.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", new Object[]{this.f17341p, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)}));
            f17332g = f17329d.length();
            f17333h = time;
            f17336k = longitude;
            f17337l = latitude;
            f17334i = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            f17335j = (long) Math.floor((latitude * 100000.0d) + 0.5d);
        } else {
            f17336k = longitude;
            f17337l = latitude;
            long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
            f17338m = (int) (time - f17333h);
            f17339n = (int) (floor - f17334i);
            f17340o = (int) (floor2 - f17335j);
            f17329d.append(String.format(Locale.CHINA, "%d,%d,%d|", new Object[]{Integer.valueOf(f17338m), Integer.valueOf(f17339n), Integer.valueOf(f17340o)}));
            f17332g = f17329d.length();
            f17333h = time;
            f17334i = floor;
            f17335j = floor2;
        }
        if (f17332g + 15 > 750) {
            m13319a(f17329d.toString());
            f17329d = null;
        }
        if (f17331f >= C3391g.ad) {
            this.f17342q = false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m13319a(String str) {
        if (str == null || !str.startsWith("&nr")) {
            return false;
        }
        if (!f17328c.exists() && !C3190d.m13322d()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(f17328c, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            if (C3190d.m13317a(readInt, readInt2, readInt3)) {
                if (C3391g.aa) {
                    if (readInt == C3391g.ad) {
                        if (str.equals(m13316a(readInt3 == 1 ? C3391g.ad : readInt3 - 1))) {
                            randomAccessFile.close();
                            return false;
                        }
                    } else if (readInt3 > 1 && str.equals(m13316a(readInt3 - 1))) {
                        randomAccessFile.close();
                        return false;
                    }
                }
                randomAccessFile.seek(((long) (((readInt3 - 1) * 1024) + 12)) + 0);
                if (str.length() > 750) {
                    randomAccessFile.close();
                    return false;
                }
                String encode = Jni.encode(str);
                int length = encode.length();
                if (length > 1020) {
                    randomAccessFile.close();
                    return false;
                }
                randomAccessFile.writeInt(length);
                randomAccessFile.writeBytes(encode);
                if (readInt == 0) {
                    randomAccessFile.seek(0);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(2);
                } else if (readInt < C3391g.ad - 1) {
                    randomAccessFile.seek(0);
                    randomAccessFile.writeInt(readInt + 1);
                    randomAccessFile.seek(8);
                    randomAccessFile.writeInt(readInt + 2);
                } else if (readInt == C3391g.ad - 1) {
                    randomAccessFile.seek(0);
                    randomAccessFile.writeInt(C3391g.ad);
                    if (readInt2 == 0 || readInt2 == 1) {
                        randomAccessFile.writeInt(2);
                    }
                    randomAccessFile.seek(8);
                    randomAccessFile.writeInt(1);
                } else if (readInt3 == readInt2) {
                    readInt = readInt3 == C3391g.ad ? 1 : readInt3 + 1;
                    r2 = readInt == C3391g.ad ? 1 : readInt + 1;
                    randomAccessFile.seek(4);
                    randomAccessFile.writeInt(r2);
                    randomAccessFile.writeInt(readInt);
                } else {
                    readInt = readInt3 == C3391g.ad ? 1 : readInt3 + 1;
                    if (readInt == readInt2) {
                        r2 = readInt == C3391g.ad ? 1 : readInt + 1;
                        randomAccessFile.seek(4);
                        randomAccessFile.writeInt(r2);
                    }
                    randomAccessFile.seek(8);
                    randomAccessFile.writeInt(readInt);
                }
                randomAccessFile.close();
                return true;
            }
            randomAccessFile.close();
            C3190d.m13322d();
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m13320b() {
        if (f17328c == null) {
            return null;
        }
        if (!f17328c.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(f17328c, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            if (!C3190d.m13317a(readInt, readInt2, readInt3)) {
                randomAccessFile.close();
                C3190d.m13322d();
                return null;
            } else if (readInt2 == 0 || readInt2 == readInt3) {
                randomAccessFile.close();
                return null;
            } else {
                long j = 0 + ((long) (((readInt2 - 1) * 1024) + 12));
                randomAccessFile.seek(j);
                int readInt4 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt4];
                randomAccessFile.seek(j + 4);
                for (readInt3 = 0; readInt3 < readInt4; readInt3++) {
                    bArr[readInt3] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                readInt3 = readInt < C3391g.ad ? readInt2 + 1 : readInt2 == C3391g.ad ? 1 : readInt2 + 1;
                randomAccessFile.seek(4);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return str;
            }
        } catch (IOException e) {
            return null;
        }
    }

    /* renamed from: c */
    private static void m13321c() {
        f17330e = true;
        f17329d = null;
        f17331f = 0;
        f17332g = 0;
        f17333h = 0;
        f17334i = 0;
        f17335j = 0;
        f17336k = 0.0d;
        f17337l = 0.0d;
        f17338m = 0;
        f17339n = 0;
        f17340o = 0;
    }

    /* renamed from: d */
    private static boolean m13322d() {
        if (f17328c.exists()) {
            f17328c.delete();
        }
        if (!f17328c.getParentFile().exists()) {
            f17328c.getParentFile().mkdirs();
        }
        try {
            f17328c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(f17328c, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            C3190d.m13321c();
            return f17328c.exists();
        } catch (IOException e) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m13323a(Location location) {
        return m13318a(location, C3391g.ab, C3391g.ac);
    }
}
