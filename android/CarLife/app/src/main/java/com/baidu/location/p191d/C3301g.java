package com.baidu.location.p191d;

import com.baidu.carlife.core.C1253f;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3390f;
import com.baidu.location.p188h.C3391g;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.location.d.g */
public class C3301g {
    /* renamed from: a */
    public static final String f17908a = (C3390f.f18346a + "/llin.dat");
    /* renamed from: b */
    private static volatile C3301g f17909b = null;
    /* renamed from: c */
    private static String f17910c = "LogSDK";
    /* renamed from: d */
    private static int f17911d = 5;
    /* renamed from: e */
    private static int f17912e = 1024;
    /* renamed from: f */
    private static final String f17913f = (C3390f.f18346a + "/llg.dat");
    /* renamed from: g */
    private static final String f17914g = (C3390f.f18346a + "/ller.dat");
    /* renamed from: h */
    private SimpleDateFormat f17915h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /* renamed from: i */
    private C3320m f17916i = null;
    /* renamed from: j */
    private C3320m f17917j = null;
    /* renamed from: k */
    private C3300a f17918k = null;
    /* renamed from: l */
    private long f17919l = 0;

    /* renamed from: com.baidu.location.d.g$a */
    private class C3300a extends C3186e {
        /* renamed from: a */
        final /* synthetic */ C3301g f17905a;
        /* renamed from: b */
        private String f17906b;
        /* renamed from: c */
        private boolean f17907c;

        C3300a(C3301g c3301g) {
            this.f17905a = c3301g;
            this.f17906b = null;
            this.f17907c = false;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.k.clear();
            this.k.put("qt", "stat");
            this.k.put("req", this.f17906b);
            this.h = "http://ofloc.map.baidu.com/statloc";
        }

        /* renamed from: a */
        public void m13875a(String str) {
            this.f17906b = str;
            if (this.f17906b != null) {
                m13299c("https://ofloc.map.baidu.com/statloc");
                this.f17907c = true;
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            this.f17907c = false;
            if (!z || this.j == null) {
                this.f17905a.f17919l = System.currentTimeMillis();
                return;
            }
            try {
                String str = this.j;
            } catch (Exception e) {
            }
        }

        /* renamed from: b */
        public boolean mo2500b() {
            return this.f17907c;
        }
    }

    private C3301g() {
        if (this.f17916i == null) {
            this.f17916i = new C3320m();
        }
    }

    /* renamed from: a */
    public static C3301g m13879a() {
        if (f17909b == null) {
            synchronized (C3301g.class) {
                if (f17909b == null) {
                    f17909b = new C3301g();
                }
            }
        }
        return f17909b;
    }

    /* renamed from: a */
    public static synchronized void m13880a(String str, String str2) {
        synchronized (C3301g.class) {
            File file = new File(str);
            if (!file.exists()) {
                C3301g.m13883c(str);
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
            }
        }
    }

    /* renamed from: a */
    public static boolean m13881a(String str, List<String> list) {
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
            byte[] bArr = new byte[f17912e];
            int i = readInt2;
            readInt2 = f17911d + 1;
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
    public static synchronized void m13882b(String str) {
        synchronized (C3301g.class) {
            C3301g.m13880a(f17908a, str);
        }
    }

    /* renamed from: c */
    private static void m13883c(String str) {
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
                randomAccessFile.writeInt(1000);
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
    public void m13884a(C3320m c3320m) {
        if (c3320m != null) {
            C3301g.m13880a(f17913f, Jni.encode(c3320m.m13969c()));
        }
    }

    /* renamed from: a */
    public void m13885a(String str) {
        if (str != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String format = this.f17915h.format(new Date());
                stringBuffer.append("&time=");
                stringBuffer.append(format);
                stringBuffer.append("&err=");
                stringBuffer.append(str);
                stringBuffer.append(C3381b.m14398a().m14399a(false));
                stringBuffer.append(C3181a.m13265a().m13283f());
                C3301g.m13880a(f17914g, Jni.encode(stringBuffer.toString()));
                if ((str.contains("Criteria") || str.contains("locType")) && !C3391g.m14449e(C3377f.getServiceContext()).equals("&netc=-1")) {
                    m13890f();
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public C3320m m13886b() {
        return this.f17916i;
    }

    /* renamed from: c */
    public C3320m m13887c() {
        if (this.f17917j == null) {
            this.f17917j = new C3320m();
        }
        return this.f17917j;
    }

    /* renamed from: d */
    public void m13888d() {
        if (this.f17916i != null) {
            C3301g.m13880a(f17913f, Jni.encode(this.f17916i.m13969c()));
        }
    }

    /* renamed from: e */
    public void m13889e() {
        if (this.f17917j != null) {
            C3301g.m13880a(f17913f, Jni.encode(this.f17917j.m13971d()));
        }
    }

    /* renamed from: f */
    public void m13890f() {
        if (this.f17918k == null) {
            this.f17918k = new C3300a(this);
        }
        if (System.currentTimeMillis() - this.f17919l >= 3600000 && !this.f17918k.mo2500b()) {
            try {
                Object obj;
                Object obj2;
                List arrayList = new ArrayList();
                C3301g.m13881a(f17914g, arrayList);
                if (arrayList.size() > 0) {
                    obj = null;
                    obj2 = 1;
                } else {
                    C3301g.m13881a(f17913f, arrayList);
                    if (arrayList.size() == 0) {
                        C3301g.m13881a(f17908a, arrayList);
                        int i = 1;
                        obj2 = null;
                    } else {
                        obj = null;
                        obj2 = null;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                if (arrayList.size() > 0) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put((String) arrayList.get(i2));
                    }
                    if (obj2 != null) {
                        jSONObject.put("locpt", jSONArray);
                    } else if (obj != null) {
                        jSONObject.put("locup", jSONArray);
                    } else {
                        jSONObject.put("loctc", jSONArray);
                    }
                    this.f17918k.m13875a(jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}
