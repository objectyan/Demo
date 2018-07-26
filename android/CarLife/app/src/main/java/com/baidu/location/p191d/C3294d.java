package com.baidu.location.p191d;

import android.content.Context;
import android.location.Location;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.Jni;
import com.baidu.location.p187a.C3181a;
import com.baidu.location.p187a.C3200h;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p188h.C3391g;
import com.baidu.location.p194f.C3371d;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* renamed from: com.baidu.location.d.d */
public class C3294d {
    /* renamed from: f */
    public static String f17846f = "0";
    /* renamed from: g */
    public static int f17847g = 6;
    /* renamed from: q */
    private static final char[] f17848q = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /* renamed from: A */
    private boolean f17849A;
    /* renamed from: B */
    private int f17850B;
    /* renamed from: C */
    private int f17851C;
    /* renamed from: D */
    private byte[] f17852D;
    /* renamed from: E */
    private List<C3292b> f17853E;
    /* renamed from: F */
    private byte f17854F;
    /* renamed from: G */
    private byte f17855G;
    /* renamed from: H */
    private boolean f17856H;
    /* renamed from: I */
    private C3291a f17857I;
    /* renamed from: a */
    boolean f17858a;
    /* renamed from: b */
    long f17859b;
    /* renamed from: c */
    Location f17860c;
    /* renamed from: d */
    StringBuilder f17861d;
    /* renamed from: e */
    long f17862e;
    /* renamed from: h */
    FileChannel f17863h;
    /* renamed from: i */
    FileLock f17864i;
    /* renamed from: j */
    RandomAccessFile f17865j;
    /* renamed from: k */
    boolean f17866k;
    /* renamed from: l */
    int f17867l;
    /* renamed from: m */
    double f17868m;
    /* renamed from: n */
    double f17869n;
    /* renamed from: o */
    private int f17870o;
    /* renamed from: p */
    private int f17871p;
    /* renamed from: r */
    private Handler f17872r;
    /* renamed from: s */
    private byte[] f17873s;
    /* renamed from: t */
    private byte[] f17874t;
    /* renamed from: u */
    private byte[] f17875u;
    /* renamed from: v */
    private boolean f17876v;
    /* renamed from: w */
    private int f17877w;
    /* renamed from: x */
    private List<Byte> f17878x;
    /* renamed from: y */
    private List<Byte> f17879y;
    /* renamed from: z */
    private long f17880z;

    /* renamed from: com.baidu.location.d.d$1 */
    class C32871 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3294d f17834a;

        C32871(C3294d c3294d) {
            this.f17834a = c3294d;
        }

        public void handleMessage(Message message) {
            int i = (byte) 0;
            if (C3377f.isServing) {
                int i2;
                int i3;
                Bundle data;
                switch (message.what) {
                    case 1:
                        if (this.f17834a.f17877w >= 9) {
                            this.f17834a.f17850B = this.f17834a.f17877w;
                            Bundle data2 = message.getData();
                            this.f17834a.f17851C = data2.getInt("num", 0);
                            if (this.f17834a.f17851C > 0 && this.f17834a.f17851C <= 3) {
                                if (this.f17834a.f17852D == null) {
                                    this.f17834a.f17852D = new byte[(this.f17834a.f17851C * 6)];
                                }
                                for (i2 = 0; i2 < this.f17834a.f17851C; i2++) {
                                    byte[] byteArray = data2.getByteArray("mac" + i2);
                                    for (i3 = 0; i3 < 6; i3++) {
                                        this.f17834a.f17852D[(i2 * 6) + i3] = byteArray[i3];
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 2:
                        data = message.getData();
                        if (data != null) {
                            String string = data.getString("ugcInfo");
                            if (string != null) {
                                this.f17834a.f17854F = (byte) 0;
                                this.f17834a.f17855G = (byte) 0;
                                if (string.equals("0")) {
                                    C3294d.f17846f = "0";
                                    return;
                                }
                                byte d;
                                C3294d.f17846f = "1";
                                int a = this.f17834a.f17877w;
                                if (string.contains("d")) {
                                    String[] split = string.split("d");
                                    if (split.length == 2) {
                                        i2 = Integer.valueOf(split[1]).intValue();
                                        if (split[0].equals("1")) {
                                            this.f17834a.f17854F = (byte) 1;
                                        } else if (split[0].equals("2")) {
                                            this.f17834a.f17854F = (byte) 2;
                                        } else if (split[0].equals("3")) {
                                            this.f17834a.f17854F = (byte) 3;
                                        } else if (split[0].equals("4")) {
                                            this.f17834a.f17854F = (byte) 4;
                                        } else if (split[0].equals("5")) {
                                            this.f17834a.f17854F = (byte) 5;
                                        } else if (split[0].equals(C2578b.f8568g)) {
                                            this.f17834a.f17854F = (byte) 6;
                                        } else if (split[0].equals("7")) {
                                            this.f17834a.f17854F = (byte) 7;
                                        } else if (split[0].equals(NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL)) {
                                            this.f17834a.f17854F = (byte) 8;
                                        }
                                        if (string.equals("9")) {
                                            this.f17834a.f17854F = (byte) 9;
                                        }
                                        i3 = string.contains("g1") ? 32 : 0;
                                        if (string.contains("f1")) {
                                            i = (byte) 16;
                                        }
                                        if (string.contains("f0")) {
                                            i = 64;
                                        }
                                        if (string.contains("g0")) {
                                            i3 = -128;
                                        }
                                        this.f17834a.f17855G = (byte) (i | i3);
                                        d = (byte) (this.f17834a.f17854F | this.f17834a.f17855G);
                                        if (d != (byte) 0) {
                                            this.f17834a.f17853E.add(new C3292b(this.f17834a, a, d, i2));
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i2 = 0;
                                if (string.equals("9")) {
                                    this.f17834a.f17854F = (byte) 9;
                                }
                                if (string.contains("g1")) {
                                }
                                if (string.contains("f1")) {
                                    i = (byte) 16;
                                }
                                if (string.contains("f0")) {
                                    i = 64;
                                }
                                if (string.contains("g0")) {
                                    i3 = -128;
                                }
                                this.f17834a.f17855G = (byte) (i | i3);
                                d = (byte) (this.f17834a.f17854F | this.f17834a.f17855G);
                                if (d != (byte) 0) {
                                    this.f17834a.f17853E.add(new C3292b(this.f17834a, a, d, i2));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 3:
                        try {
                            data = message.getData();
                            i3 = data.getInt("plan_order", -1);
                            int i4 = data.getInt("type_value", -1);
                            i2 = data.getInt("time_stamp", 0);
                            if (i3 > -1 && i4 > -1) {
                                if (i4 == 0 && i2 > 0) {
                                    this.f17834a.f17880z = System.currentTimeMillis();
                                    byte[] c;
                                    if (this.f17834a.f17877w > 0) {
                                        if (this.f17834a.f17875u == null) {
                                            this.f17834a.f17875u = new byte[6];
                                        }
                                        this.f17834a.f17875u[0] = (byte) (((byte) (((byte) (i3 & 255)) << 4)) | 1);
                                        this.f17834a.f17875u[5] = (byte) (((byte) (((byte) ((this.f17834a.f17877w - 1) & 255)) << 2)) | ((byte) (i4 & 255)));
                                        c = this.f17834a.m13806a(i2);
                                        this.f17834a.f17875u[1] = c[0];
                                        this.f17834a.f17875u[2] = c[1];
                                        this.f17834a.f17875u[3] = c[2];
                                        this.f17834a.f17875u[4] = c[3];
                                        return;
                                    }
                                    BDLocation l = C3200h.m13362c().m13393l();
                                    if (l != null && l.getLatitude() > 0.0d) {
                                        if (this.f17834a.f17875u == null) {
                                            this.f17834a.f17875u = new byte[6];
                                        }
                                        this.f17834a.f17875u[0] = (byte) (((byte) (((byte) (((byte) (i3 & 255)) | 8)) << 4)) | 1);
                                        this.f17834a.f17875u[5] = (byte) (0 | ((byte) (i4 & 255)));
                                        c = this.f17834a.m13806a(i2);
                                        this.f17834a.f17875u[1] = c[0];
                                        this.f17834a.f17875u[2] = c[1];
                                        this.f17834a.f17875u[3] = c[2];
                                        this.f17834a.f17875u[4] = c[3];
                                        this.f17834a.m13831a(l);
                                        return;
                                    }
                                    return;
                                } else if (i4 == 1) {
                                    this.f17834a.f17875u = null;
                                    this.f17834a.f17876v = true;
                                    this.f17834a.f17880z = 0;
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.d$3 */
    class C32893 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3294d f17838a;

        C32893(C3294d c3294d) {
            this.f17838a = c3294d;
        }

        public void run() {
            this.f17838a.m13802a(new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
        }
    }

    /* renamed from: com.baidu.location.d.d$4 */
    class C32904 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3294d f17839a;

        C32904(C3294d c3294d) {
            this.f17839a = c3294d;
        }

        public void run() {
            this.f17839a.f17866k = false;
            if (this.f17839a.f17858a) {
                this.f17839a.m13823f();
                if (C3371d.m14289a().m14319g()) {
                    this.f17839a.f17872r.postDelayed(this, (long) (this.f17839a.f17871p + 5000));
                    this.f17839a.f17866k = true;
                }
            }
        }
    }

    /* renamed from: com.baidu.location.d.d$a */
    private class C3291a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3294d f17840a;

        private C3291a(C3294d c3294d) {
            this.f17840a = c3294d;
        }

        public void run() {
            this.f17840a.f17856H = false;
            C3319l.m13952a().m13959c();
        }
    }

    /* renamed from: com.baidu.location.d.d$b */
    private class C3292b {
        /* renamed from: a */
        int f17841a = 0;
        /* renamed from: b */
        byte f17842b = (byte) 0;
        /* renamed from: c */
        int f17843c = 0;
        /* renamed from: d */
        final /* synthetic */ C3294d f17844d;

        C3292b(C3294d c3294d, int i, byte b, int i2) {
            this.f17844d = c3294d;
            this.f17841a = i;
            this.f17842b = b;
            this.f17843c = i2;
        }
    }

    /* renamed from: com.baidu.location.d.d$c */
    private static class C3293c {
        /* renamed from: a */
        public static final C3294d f17845a = new C3294d();
    }

    private C3294d() {
        this.f17870o = 500;
        this.f17871p = 15000;
        this.f17858a = true;
        this.f17859b = 0;
        this.f17860c = null;
        this.f17861d = null;
        this.f17862e = 0;
        this.f17872r = null;
        this.f17873s = new byte[4];
        this.f17874t = null;
        this.f17875u = null;
        this.f17876v = true;
        this.f17877w = 0;
        this.f17878x = null;
        this.f17879y = null;
        this.f17880z = 0;
        this.f17849A = false;
        this.f17850B = 0;
        this.f17851C = 0;
        this.f17852D = null;
        this.f17853E = new ArrayList();
        this.f17854F = (byte) 0;
        this.f17855G = (byte) 0;
        this.f17863h = null;
        this.f17864i = null;
        this.f17865j = null;
        this.f17856H = false;
        this.f17866k = false;
        this.f17867l = 0;
        this.f17868m = 116.22345545d;
        this.f17869n = 40.245667323d;
        if (!this.f17849A) {
            m13834d();
        }
    }

    /* renamed from: a */
    public static C3294d m13799a() {
        return C3293c.f17845a;
    }

    /* renamed from: a */
    private static String m13800a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private String m13802a(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        String str2 = "--";
        String str3 = "\r\n";
        String str4 = "multipart/form-data";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "close");
            httpURLConnection.setRequestProperty("Content-Type", str4 + ";boundary=" + uuid);
            if (file != null && file.exists()) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str2);
                stringBuffer.append(uuid);
                stringBuffer.append(str3);
                stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"" + str3);
                stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8" + str3);
                stringBuffer.append(str3);
                dataOutputStream.write(stringBuffer.toString().getBytes());
                InputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write(str3.getBytes());
                dataOutputStream.write((str2 + uuid + str2 + str3).getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                outputStream.close();
                httpURLConnection.disconnect();
                if (responseCode == 200) {
                    return "1";
                }
            }
        } catch (MalformedURLException e) {
        } catch (Exception e2) {
        }
        return "0";
    }

    /* renamed from: a */
    private void m13803a(Location location) {
        boolean z = true;
        this.f17862e = System.currentTimeMillis();
        m13812b((int) (location.getTime() / 1000));
        m13812b((int) (location.getLongitude() * 1000000.0d));
        m13812b((int) (location.getLatitude() * 1000000.0d));
        boolean z2 = !location.hasBearing();
        if (location.hasSpeed()) {
            z = false;
        }
        if (z2 <= false) {
            this.f17878x.add(Byte.valueOf((byte) 32));
        } else {
            this.f17878x.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & -33)));
        }
        if (z <= false) {
            this.f17878x.add(Byte.valueOf(Byte.MIN_VALUE));
        } else {
            this.f17878x.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & TransportMediator.KEYCODE_MEDIA_PAUSE)));
        }
        if (C3371d.m14289a().m14325m()) {
            C3319l.m13952a().m13958b();
            C3319l.m13952a().m13961e();
            if (this.f17856H && this.f17857I != null) {
                this.f17872r.removeCallbacks(this.f17857I);
                this.f17856H = false;
            }
        }
        this.f17860c = location;
    }

    /* renamed from: a */
    private byte[] m13806a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((-16777216 & i) >> 24)};
    }

    /* renamed from: a */
    private byte[] m13808a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        i = i2 + 1;
        bArr[i2] = nextInt;
        i2 = i + 1;
        bArr[i] = nextInt2;
        return bArr;
    }

    /* renamed from: b */
    private void m13812b(int i) {
        byte[] a = m13806a(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.f17878x.add(Byte.valueOf(a[i2]));
        }
    }

    /* renamed from: b */
    private void m13813b(Location location) {
        Object obj = null;
        int longitude = (int) ((location.getLongitude() - this.f17860c.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.f17860c.getLatitude()) * 1000000.0d);
        if (location.hasBearing()) {
            Object obj2 = null;
        } else {
            int i = 1;
        }
        if (location.hasSpeed()) {
            Object obj3 = null;
        } else {
            int i2 = 1;
        }
        if (longitude > 0) {
            Object obj4 = null;
        } else {
            int i3 = 1;
        }
        longitude = Math.abs(longitude);
        if (latitude <= 0) {
            int i4 = 1;
        }
        int abs = Math.abs(latitude);
        this.f17860c = location;
        this.f17878x.add(Byte.valueOf((byte) (longitude & 255)));
        this.f17878x.add(Byte.valueOf((byte) ((longitude & 65280) >> 8)));
        this.f17878x.add(Byte.valueOf((byte) (abs & 255)));
        this.f17878x.add(Byte.valueOf((byte) ((abs & 65280) >> 8)));
        byte b;
        if (obj2 > null) {
            b = (byte) 32;
            if (obj > null) {
                b = (byte) 96;
            }
            if (obj4 > null) {
                b = (byte) (b | -128);
            }
            this.f17878x.add(Byte.valueOf(b));
        } else {
            b = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (obj > null) {
                b = (byte) (b | 64);
            }
            if (obj4 > null) {
                b = (byte) (b | -128);
            }
            this.f17878x.add(Byte.valueOf(b));
        }
        if (obj3 > null) {
            this.f17878x.add(Byte.valueOf(Byte.MIN_VALUE));
            return;
        }
        this.f17878x.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & TransportMediator.KEYCODE_MEDIA_PAUSE)));
    }

    /* renamed from: b */
    private void m13814b(Location location, int i) {
        m13817c(location, i);
        m13823f();
        m13826h();
    }

    /* renamed from: c */
    private void m13817c(Location location, int i) {
        if (System.currentTimeMillis() - this.f17859b >= ((long) this.f17870o) && location != null) {
            this.f17859b = System.currentTimeMillis();
            try {
                if (this.f17878x == null) {
                    this.f17878x = new ArrayList();
                    m13824g();
                    m13803a(location);
                    if (this.f17879y != null) {
                        this.f17879y.clear();
                        this.f17879y = null;
                    }
                    this.f17879y = new ArrayList();
                    if (!location.hasAccuracy()) {
                        this.f17879y.add(Byte.valueOf((byte) -1));
                    } else if (location.getAccuracy() > 127.0f) {
                        this.f17879y.add(Byte.valueOf(Byte.MAX_VALUE));
                    } else {
                        this.f17879y.add(Byte.valueOf((byte) (((int) location.getAccuracy()) & TransportMediator.KEYCODE_MEDIA_PAUSE)));
                    }
                    if (i > 0) {
                        this.f17879y.add(Byte.valueOf((byte) (i & 255)));
                    } else {
                        this.f17879y.add(Byte.valueOf((byte) 0));
                    }
                } else {
                    m13813b(location);
                    if (this.f17879y != null) {
                        if (!location.hasAccuracy()) {
                            this.f17879y.add(Byte.valueOf((byte) -1));
                        } else if (location.getAccuracy() > 127.0f) {
                            this.f17879y.add(Byte.valueOf(Byte.MAX_VALUE));
                        } else {
                            this.f17879y.add(Byte.valueOf((byte) (((int) location.getAccuracy()) & TransportMediator.KEYCODE_MEDIA_PAUSE)));
                        }
                        if (i > 0) {
                            this.f17879y.add(Byte.valueOf((byte) (i & 255)));
                        } else {
                            this.f17879y.add(Byte.valueOf((byte) 0));
                        }
                    }
                }
            } catch (Exception e) {
            }
            this.f17877w++;
            if (this.f17877w == 9) {
                C3314j.m13917b().mo2499c();
            }
        }
    }

    /* renamed from: f */
    private void m13823f() {
        if (this.f17862e != 0 && System.currentTimeMillis() - this.f17862e >= ((long) this.f17871p)) {
            if (!this.f17856H) {
                if (this.f17857I == null) {
                    this.f17857I = new C3291a();
                }
                this.f17856H = true;
                this.f17872r.postDelayed(this.f17857I, BNOffScreenParams.MIN_ENTER_INTERVAL);
            }
            if (this.f17878x != null) {
                int i;
                int size;
                int size2;
                if (this.f17852D != null) {
                    this.f17878x.add(Byte.valueOf((byte) 85));
                    this.f17878x.add(Byte.valueOf((byte) (this.f17850B & 255)));
                    this.f17878x.add(Byte.valueOf((byte) (this.f17851C & 255)));
                    for (byte valueOf : this.f17852D) {
                        this.f17878x.add(Byte.valueOf(valueOf));
                    }
                }
                if (this.f17853E != null && this.f17853E.size() > 0) {
                    this.f17878x.add(Byte.valueOf((byte) 86));
                    this.f17878x.add(Byte.valueOf((byte) (this.f17853E.size() & 255)));
                    for (C3292b c3292b : this.f17853E) {
                        this.f17878x.add(Byte.valueOf((byte) (c3292b.f17841a & 255)));
                        this.f17878x.add(Byte.valueOf(c3292b.f17842b));
                        this.f17878x.add(Byte.valueOf((byte) (c3292b.f17843c & 255)));
                        this.f17878x.add(Byte.valueOf((byte) ((c3292b.f17843c & 65280) >> 8)));
                    }
                    this.f17853E.clear();
                }
                if (!(this.f17875u == null || this.f17880z == 0)) {
                    this.f17878x.add(Byte.valueOf((byte) 83));
                    if (this.f17876v) {
                        this.f17876v = false;
                    } else if (C3371d.m14289a().m14325m()) {
                        this.f17875u[0] = (byte) (this.f17875u[0] & TransportMediator.KEYCODE_MEDIA_PAUSE);
                        this.f17875u[5] = (byte) (((byte) (((byte) ((this.f17877w - 1) & 255)) << 2)) | 2);
                    } else {
                        this.f17875u[0] = (byte) (this.f17875u[0] | 128);
                        this.f17875u[5] = (byte) (((byte) (((byte) ((this.f17877w - 1) & 255)) << 2)) | 2);
                    }
                    for (i = 0; i < 6; i++) {
                        this.f17878x.add(Byte.valueOf(this.f17875u[i]));
                    }
                    if (System.currentTimeMillis() - this.f17880z > 7200000) {
                        this.f17875u = null;
                    }
                }
                List d = C3319l.m13952a().m13960d();
                if (d != null && d.size() > 0) {
                    size = d.size();
                    for (i = 0; i < size; i++) {
                        this.f17878x.add(d.get(i));
                    }
                }
                if (this.f17879y != null) {
                    size2 = this.f17879y.size();
                    if (size2 == this.f17877w * 2) {
                        this.f17878x.add(Byte.valueOf((byte) 81));
                        this.f17878x.add(Byte.valueOf((byte) (this.f17877w & 255)));
                        for (i = 0; i < size2; i++) {
                            this.f17878x.add(this.f17879y.get(i));
                        }
                    }
                }
                size = this.f17878x.size();
                this.f17878x.set(0, Byte.valueOf((byte) (size & 255)));
                this.f17878x.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
                this.f17878x.set(3, Byte.valueOf((byte) (this.f17877w & 255)));
                if (!(f17846f.equals("0") || C3181a.m13265a().m13278c())) {
                    this.f17878x.set(2, Byte.valueOf((byte) -71));
                }
                byte[] bArr = new byte[size];
                for (size2 = 0; size2 < size; size2++) {
                    bArr[size2] = ((Byte) this.f17878x.get(size2)).byteValue();
                }
                if (C3181a.m13265a().m13278c()) {
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("gpsintimedata", bArr);
                    C3181a.m13265a().m13270a(bundle, 501);
                } else if (Environment.getExternalStorageState().equals("mounted")) {
                    File file = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (file.exists()) {
                        File file2 = new File(file, "intime.dat");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            new C32893(this).start();
                        } catch (Exception e) {
                        }
                    }
                }
                this.f17878x = null;
                this.f17879y = null;
                this.f17862e = 0;
                this.f17877w = 0;
                this.f17850B = 0;
                this.f17851C = 0;
                this.f17852D = null;
            }
        }
    }

    /* renamed from: g */
    private void m13824g() {
        int i = 0;
        this.f17878x.add(Byte.valueOf((byte) 0));
        this.f17878x.add(Byte.valueOf((byte) 0));
        if (f17846f.equals("0")) {
            this.f17878x.add(Byte.valueOf((byte) -86));
        } else {
            this.f17878x.add(Byte.valueOf((byte) -70));
        }
        this.f17878x.add(Byte.valueOf((byte) 0));
        this.f17878x.add(Byte.valueOf(this.f17873s[0]));
        this.f17878x.add(Byte.valueOf(this.f17873s[1]));
        this.f17878x.add(Byte.valueOf(this.f17873s[2]));
        this.f17878x.add(Byte.valueOf(this.f17873s[3]));
        int length = this.f17874t.length;
        this.f17878x.add(Byte.valueOf((byte) ((length + 1) & 255)));
        while (i < length) {
            this.f17878x.add(Byte.valueOf(this.f17874t[i]));
            i++;
        }
    }

    /* renamed from: h */
    private void m13826h() {
        if (!this.f17866k) {
            this.f17872r.postDelayed(new C32904(this), (long) (this.f17871p + 3000));
            this.f17866k = true;
        }
    }

    /* renamed from: a */
    public void m13830a(final Location location, final int i) {
        if (this.f17858a) {
            m13834d();
            this.f17872r.post(new Runnable(this) {
                /* renamed from: c */
                final /* synthetic */ C3294d f17837c;

                public void run() {
                    this.f17837c.m13814b(location, i);
                }
            });
        }
    }

    /* renamed from: a */
    public void m13831a(BDLocation bDLocation) {
        if (!C3371d.m14289a().m14325m() && this.f17875u != null) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            Location location = new Location(C1981b.f6367g);
            double[] dArr = new double[2];
            double[] coorEncrypt = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), "gcj2wgs");
            location.setLatitude(coorEncrypt[1]);
            location.setLongitude(coorEncrypt[0]);
            m13830a(location, -1);
        }
    }

    /* renamed from: b */
    public void m13832b() {
        try {
            File file = new File(C3391g.m14455k() + File.separator + "gflk.dat");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (this.f17865j == null) {
                this.f17865j = new RandomAccessFile(file, "rw");
                this.f17863h = this.f17865j.getChannel();
                this.f17864i = this.f17863h.tryLock();
            }
        } catch (Exception e) {
            m13833c();
        }
    }

    /* renamed from: c */
    public void m13833c() {
        try {
            if (this.f17864i != null) {
                this.f17864i.release();
                this.f17864i = null;
            }
            if (this.f17863h != null) {
                this.f17863h.close();
                this.f17863h = null;
            }
            if (this.f17865j != null) {
                this.f17865j.close();
                this.f17865j = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    public void m13834d() {
        if (!this.f17849A) {
            this.f17849A = true;
            String a = C3294d.m13800a(C3377f.getServiceContext());
            if (a == null) {
                a = "7.3.2";
            }
            String[] split = a.split("\\.");
            int length = split.length;
            this.f17873s[0] = (byte) 0;
            this.f17873s[1] = (byte) 0;
            this.f17873s[2] = (byte) 0;
            this.f17873s[3] = (byte) 0;
            if (length >= 4) {
                length = 4;
            }
            int i = 0;
            while (i < length) {
                try {
                    this.f17873s[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
                    i++;
                } catch (Exception e) {
                }
            }
            this.f17874t = m13808a(C3381b.m14398a().f18317b);
            this.f17872r = new C32871(this);
        }
    }

    /* renamed from: e */
    public Handler m13835e() {
        return this.f17872r;
    }
}
