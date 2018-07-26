package com.baidu.location.p189b;

import android.content.SharedPreferences.Editor;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p188h.C3186e;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3382c;
import com.baidu.location.p188h.C3390f;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p190c.C3248c;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.d */
public class C3220d {
    /* renamed from: i */
    private static C3220d f17514i = null;
    /* renamed from: k */
    private static final String f17515k = (C3390f.f18346a + "/conlts.dat");
    /* renamed from: l */
    private static int f17516l = -1;
    /* renamed from: m */
    private static int f17517m = -1;
    /* renamed from: n */
    private static int f17518n = 0;
    /* renamed from: a */
    public boolean f17519a = true;
    /* renamed from: b */
    public boolean f17520b = true;
    /* renamed from: c */
    public boolean f17521c = false;
    /* renamed from: d */
    public boolean f17522d = true;
    /* renamed from: e */
    public boolean f17523e = true;
    /* renamed from: f */
    public boolean f17524f = true;
    /* renamed from: g */
    public boolean f17525g = true;
    /* renamed from: h */
    public boolean f17526h = false;
    /* renamed from: j */
    private C3219a f17527j = null;

    /* renamed from: com.baidu.location.b.d$a */
    class C3219a extends C3186e {
        /* renamed from: a */
        String f17510a;
        /* renamed from: b */
        boolean f17511b;
        /* renamed from: c */
        boolean f17512c;
        /* renamed from: d */
        final /* synthetic */ C3220d f17513d;

        public C3219a(C3220d c3220d) {
            this.f17513d = c3220d;
            this.f17510a = null;
            this.f17511b = false;
            this.f17512c = false;
            this.k = new HashMap();
        }

        /* renamed from: a */
        public void mo2494a() {
            this.h = C3391g.m14448e();
            this.i = 2;
            String encode = Jni.encode(this.f17510a);
            this.f17510a = null;
            if (this.f17511b) {
                this.k.put("qt", "grid");
            } else {
                this.k.put("qt", "conf");
            }
            this.k.put("req", encode);
        }

        /* renamed from: a */
        public void m13497a(String str, boolean z) {
            if (!this.f17512c) {
                this.f17512c = true;
                this.f17510a = str;
                this.f17511b = z;
                if (z) {
                    m13298a(true, "loc.map.baidu.com");
                } else {
                    m13299c(C3391g.f18379f);
                }
            }
        }

        /* renamed from: a */
        public void mo2495a(boolean z) {
            if (!z || this.j == null) {
                this.f17513d.m13507c(null);
            } else if (this.f17511b) {
                this.f17513d.m13504a(this.m);
            } else {
                this.f17513d.m13507c(this.j);
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.f17512c = false;
        }
    }

    private C3220d() {
    }

    /* renamed from: a */
    public static C3220d m13499a() {
        if (f17514i == null) {
            f17514i = new C3220d();
        }
        return f17514i;
    }

    /* renamed from: a */
    private void m13500a(int i) {
        boolean z = true;
        this.f17519a = (i & 1) == 1;
        this.f17520b = (i & 2) == 2;
        this.f17521c = (i & 4) == 4;
        this.f17522d = (i & 8) == 8;
        this.f17524f = (i & 65536) == 65536;
        if ((i & 131072) != 131072) {
            z = false;
        }
        this.f17525g = z;
        if ((i & 16) == 16) {
            this.f17523e = false;
        }
    }

    /* renamed from: a */
    private void m13503a(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            int i = 14400000;
            int i2 = 10;
            try {
                if (!(jSONObject.has("ipen") && jSONObject.getInt("ipen") == 0)) {
                    z = true;
                }
                if (jSONObject.has("ipvt")) {
                    i = jSONObject.getInt("ipvt");
                }
                if (jSONObject.has("ipvn")) {
                    i2 = jSONObject.getInt("ipvn");
                }
                Editor edit = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
                edit.putBoolean("ipLocInfoUpload", z);
                edit.putInt("ipValidTime", i);
                edit.putInt("ipLocInfoUploadTimesPerDay", i2);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private void m13504a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            if (bArr.length < 640) {
                C3391g.f18396w = false;
                C3391g.f18393t = C3391g.f18391r + 0.025d;
                C3391g.f18392s = C3391g.f18390q - 0.025d;
                i = 1;
            } else {
                C3391g.f18396w = true;
                C3391g.f18392s = Double.longBitsToDouble(((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255));
                C3391g.f18393t = Double.longBitsToDouble(((((((((((long) bArr[15]) & 255) << 56) | ((((long) bArr[14]) & 255) << 48)) | ((((long) bArr[13]) & 255) << 40)) | ((((long) bArr[12]) & 255) << 32)) | ((((long) bArr[11]) & 255) << 24)) | ((((long) bArr[10]) & 255) << 16)) | ((((long) bArr[9]) & 255) << 8)) | (((long) bArr[8]) & 255));
                C3391g.f18395v = new byte[625];
                while (i < 625) {
                    C3391g.f18395v[i] = bArr[i + 16];
                    i++;
                }
                i = 1;
            }
        }
        if (i != 0) {
            try {
                m13510g();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    private void m13505b(int i) {
        File file = new File(f17515k);
        if (!file.exists()) {
            m13512i();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((long) ((readInt * f17518n) + 128));
            byte[] bytes = (C3381b.f18311d + '\u0000').getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == f17518n) {
                randomAccessFile.seek(8);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private boolean m13506b(String str) {
        boolean z = true;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ipconf")) {
                    try {
                        m13503a(jSONObject.getJSONObject("ipconf"));
                    } catch (Exception e) {
                    }
                }
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > C3391g.f18397x) {
                    String[] split;
                    C3391g.f18397x = parseInt;
                    if (jSONObject.has("gps")) {
                        split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                C3391g.f18398y = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                C3391g.f18399z = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.f18348A = Float.parseFloat(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                C3391g.f18349B = Float.parseFloat(split[3]);
                            }
                            if (!(split[4] == null || split[4].equals(""))) {
                                C3391g.f18350C = Integer.parseInt(split[4]);
                            }
                            if (!(split[5] == null || split[5].equals(""))) {
                                C3391g.f18351D = Integer.parseInt(split[5]);
                            }
                            if (!(split[6] == null || split[6].equals(""))) {
                                C3391g.f18352E = Integer.parseInt(split[6]);
                            }
                            if (!(split[7] == null || split[7].equals(""))) {
                                C3391g.f18353F = Integer.parseInt(split[7]);
                            }
                            if (!(split[8] == null || split[8].equals(""))) {
                                C3391g.f18354G = Integer.parseInt(split[8]);
                            }
                            if (!(split[9] == null || split[9].equals(""))) {
                                C3391g.f18355H = Integer.parseInt(split[9]);
                            }
                            if (!(split[10] == null || split[10].equals(""))) {
                                C3391g.f18356I = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has(OfflineMapKey.OFFLINE_UPDATE)) {
                        split = jSONObject.getString(OfflineMapKey.OFFLINE_UPDATE).split("\\|");
                        if (split.length > 3) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                C3391g.f18357J = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                C3391g.f18358K = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.f18359L = Float.parseFloat(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                C3391g.f18360M = Float.parseFloat(split[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        split = jSONObject.getString("wf").split("\\|");
                        if (split.length > 3) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                C3391g.f18361N = Integer.parseInt(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                C3391g.f18362O = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.f18363P = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                C3391g.f18364Q = Float.parseFloat(split[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        split = jSONObject.getString("ab").split("\\|");
                        if (split.length > 3) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                C3391g.f18365R = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                C3391g.f18366S = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.f18367T = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                C3391g.f18368U = Integer.parseInt(split[3]);
                            }
                        }
                    }
                    if (jSONObject.has("zxd")) {
                        split = jSONObject.getString("zxd").split("\\|");
                        if (split.length > 4) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                C3391g.aq = Float.parseFloat(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                C3391g.ar = Float.parseFloat(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.as = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                C3391g.at = Integer.parseInt(split[3]);
                            }
                            if (!(split[4] == null || split[4].equals(""))) {
                                C3391g.au = Integer.parseInt(split[4]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        split = jSONObject.getString("gpc").split("\\|");
                        if (split.length > 5) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                if (Integer.parseInt(split[0]) > 0) {
                                    C3391g.f18373Z = true;
                                } else {
                                    C3391g.f18373Z = false;
                                }
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                if (Integer.parseInt(split[1]) > 0) {
                                    C3391g.aa = true;
                                } else {
                                    C3391g.aa = false;
                                }
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.ab = Integer.parseInt(split[2]);
                            }
                            if (!(split[3] == null || split[3].equals(""))) {
                                C3391g.ad = Integer.parseInt(split[3]);
                            }
                            if (!(split[4] == null || split[4].equals(""))) {
                                int parseInt2 = Integer.parseInt(split[4]);
                                if (parseInt2 > 0) {
                                    C3391g.aj = (long) parseInt2;
                                    C3391g.af = (C3391g.aj * 1000) * 60;
                                    C3391g.ak = C3391g.af >> 2;
                                } else {
                                    C3391g.f18388o = false;
                                }
                            }
                            if (!(split[5] == null || split[5].equals(""))) {
                                C3391g.am = Integer.parseInt(split[5]);
                            }
                        }
                    }
                    if (jSONObject.has("shak")) {
                        split = jSONObject.getString("shak").split("\\|");
                        if (split.length > 2) {
                            if (!(split[0] == null || split[0].equals(""))) {
                                C3391g.an = Integer.parseInt(split[0]);
                            }
                            if (!(split[1] == null || split[1].equals(""))) {
                                C3391g.ao = Integer.parseInt(split[1]);
                            }
                            if (!(split[2] == null || split[2].equals(""))) {
                                C3391g.ap = Float.parseFloat(split[2]);
                            }
                        }
                    }
                    if (jSONObject.has("dmx")) {
                        C3391g.al = jSONObject.getInt("dmx");
                    }
                    return z;
                }
            } catch (Exception e2) {
                return false;
            }
        }
        z = false;
        return z;
    }

    /* renamed from: c */
    private void m13507c(String str) {
        f17517m = -1;
        if (str != null) {
            try {
                if (m13506b(str)) {
                    m13509f();
                }
            } catch (Exception e) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    f17517m = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception e2) {
            }
            try {
                int i;
                m13513j();
                if (f17517m != -1) {
                    i = f17517m;
                    m13505b(f17517m);
                } else {
                    i = f17516l != -1 ? f17516l : -1;
                }
                if (i != -1) {
                    m13500a(i);
                }
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: e */
    private void m13508e() {
        String str = "&ver=" + C3391g.f18397x + "&usr=" + C3381b.m14398a().m14404c() + "&app=" + C3381b.f18311d + "&prod=" + C3381b.f18312e;
        if (this.f17527j == null) {
            this.f17527j = new C3219a(this);
        }
        this.f17527j.m13497a(str, false);
    }

    /* renamed from: f */
    private void m13509f() {
        String str = C3390f.f18346a + "/config.dat";
        int i = C3391g.f18373Z ? 1 : 0;
        int i2 = C3391g.aa ? 1 : 0;
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", new Object[]{Integer.valueOf(C3391g.f18397x), Float.valueOf(C3391g.f18398y), Float.valueOf(C3391g.f18399z), Float.valueOf(C3391g.f18348A), Float.valueOf(C3391g.f18349B), Integer.valueOf(C3391g.f18350C), Integer.valueOf(C3391g.f18351D), Integer.valueOf(C3391g.f18352E), Integer.valueOf(C3391g.f18353F), Integer.valueOf(C3391g.f18354G), Integer.valueOf(C3391g.f18355H), Integer.valueOf(C3391g.f18356I), Float.valueOf(C3391g.f18357J), Float.valueOf(C3391g.f18358K), Float.valueOf(C3391g.f18359L), Float.valueOf(C3391g.f18360M), Integer.valueOf(C3391g.f18361N), Float.valueOf(C3391g.f18362O), Integer.valueOf(C3391g.f18363P), Float.valueOf(C3391g.f18364Q), Float.valueOf(C3391g.f18365R), Float.valueOf(C3391g.f18366S), Integer.valueOf(C3391g.f18367T), Integer.valueOf(C3391g.f18368U), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(C3391g.ab), Integer.valueOf(C3391g.ad), Long.valueOf(C3391g.aj), Integer.valueOf(C3391g.am), Float.valueOf(C3391g.aq), Float.valueOf(C3391g.ar), Integer.valueOf(C3391g.as), Integer.valueOf(C3391g.at), Integer.valueOf(C3391g.au), Integer.valueOf(C3391g.an), Integer.valueOf(C3391g.ao), Float.valueOf(C3391g.ap), Integer.valueOf(C3391g.al)}).getBytes();
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(C3390f.f18346a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.seek(2);
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: g */
    private void m13510g() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(C3390f.f18346a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(C3390f.f18346a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(1);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.seek(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            randomAccessFile.writeDouble(C3391g.f18392s);
            randomAccessFile.writeDouble(C3391g.f18393t);
            randomAccessFile.writeBoolean(C3391g.f18396w);
            if (C3391g.f18396w && C3391g.f18395v != null) {
                randomAccessFile.write(C3391g.f18395v);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: h */
    private void m13511h() {
        try {
            File file = new File(C3390f.f18346a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    m13506b(new String(bArr));
                }
                randomAccessFile.seek(1);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
                    C3391g.f18392s = randomAccessFile.readDouble();
                    C3391g.f18393t = randomAccessFile.readDouble();
                    C3391g.f18396w = randomAccessFile.readBoolean();
                    if (C3391g.f18396w) {
                        C3391g.f18395v = new byte[625];
                        randomAccessFile.read(C3391g.f18395v, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        if (C3391g.f18388o && C3377f.isServing) {
            try {
                C3248c.m13596a().m13606b();
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: i */
    private void m13512i() {
        try {
            File file = new File(f17515k);
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
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(128);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: j */
    private void m13513j() {
        int i = 0;
        try {
            File file = new File(f17515k);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    f17518n = 0;
                    m13512i();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128);
                byte[] bArr = new byte[readInt];
                while (i < readInt2) {
                    randomAccessFile.seek((long) ((readInt * i) + 128));
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        if (bArr[readInt3 - 1] == (byte) 0) {
                            String str = new String(bArr, 0, readInt3 - 1);
                            C3381b.m14398a();
                            if (str.equals(C3381b.f18311d)) {
                                f17516l = randomAccessFile.readInt();
                                f17518n = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    f17518n = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m13514a(String str) {
        if (this.f17527j == null) {
            this.f17527j = new C3219a(this);
        }
        this.f17527j.m13497a(str, true);
    }

    /* renamed from: b */
    public void m13515b() {
        m13511h();
    }

    /* renamed from: c */
    public void m13516c() {
        C3248c.m13596a().m13607c();
    }

    /* renamed from: d */
    public void m13517d() {
        if (System.currentTimeMillis() - C3382c.m14410a().m14417d() > 86400000) {
            C3382c.m14410a().m14418d(System.currentTimeMillis());
            m13508e();
        }
    }
}
