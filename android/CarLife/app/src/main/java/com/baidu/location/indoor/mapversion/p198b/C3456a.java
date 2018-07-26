package com.baidu.location.indoor.mapversion.p198b;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.util.HashMap;

/* renamed from: com.baidu.location.indoor.mapversion.b.a */
public class C3456a {
    /* renamed from: a */
    private static C3456a f18722a;
    /* renamed from: b */
    private C3428c f18723b;
    /* renamed from: c */
    private String f18724c;
    /* renamed from: d */
    private boolean f18725d = false;
    /* renamed from: e */
    private String f18726e = "rn";
    /* renamed from: f */
    private C3454b f18727f;
    /* renamed from: g */
    private String f18728g = "gcj02";
    /* renamed from: h */
    private HashMap<String, C3455d> f18729h = new HashMap();

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$c */
    public interface C3428c {
        /* renamed from: a */
        void mo2520a(boolean z, String str);
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$a */
    public static class C3453a {
        /* renamed from: a */
        public double f18703a;
        /* renamed from: b */
        public double f18704b;
        /* renamed from: c */
        public double f18705c;
        /* renamed from: d */
        public double f18706d;
        /* renamed from: e */
        public double f18707e;
        /* renamed from: f */
        public double f18708f;
        /* renamed from: g */
        public double f18709g;
        /* renamed from: h */
        public double f18710h;

        public C3453a(String str) {
            m14821a(str);
        }

        /* renamed from: a */
        public void m14821a(String str) {
            String[] split = str.trim().split("\\|");
            this.f18703a = Double.valueOf(split[0]).doubleValue();
            this.f18704b = Double.valueOf(split[1]).doubleValue();
            this.f18705c = Double.valueOf(split[2]).doubleValue();
            this.f18706d = Double.valueOf(split[3]).doubleValue();
            this.f18707e = Double.valueOf(split[4]).doubleValue();
            this.f18708f = Double.valueOf(split[5]).doubleValue();
            this.f18709g = Double.valueOf(split[6]).doubleValue();
            this.f18710h = Double.valueOf(split[7]).doubleValue();
        }
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$b */
    private class C3454b extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3456a f18711a;
        /* renamed from: b */
        private String f18712b;
        /* renamed from: c */
        private String f18713c;

        public C3454b(C3456a c3456a, String str, String str2) {
            this.f18711a = c3456a;
            this.f18712b = str;
            this.f18713c = str2;
        }

        public void run() {
            try {
                boolean b;
                String str;
                File file = new File(this.f18711a.f18726e);
                if (!(file.exists() && file.isDirectory())) {
                    file.mkdirs();
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet").openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.addRequestProperty("Accept-encoding", "gzip");
                httpURLConnection.getOutputStream().write(("bldg=" + this.f18712b + "&md5=" + (this.f18713c == null ? "null" : this.f18713c)).getBytes());
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    String headerField = httpURLConnection.getHeaderField("Hash");
                    InputStream inputStream = httpURLConnection.getInputStream();
                    File file2 = new File(file, this.f18711a.m14835a(this.f18712b, headerField));
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (C3456a.m14834a(file2).equalsIgnoreCase(headerField)) {
                        this.f18711a.m14839b(this.f18712b, this.f18713c);
                        this.f18711a.f18724c = this.f18712b;
                        b = this.f18711a.m14843c();
                        str = "OK";
                    } else {
                        str = "Download failed";
                        file2.delete();
                        b = false;
                    }
                } else if (responseCode == 304) {
                    this.f18711a.f18724c = this.f18712b;
                    b = this.f18711a.m14843c();
                    str = "No roadnet update for " + this.f18712b + "," + this.f18713c;
                } else if (responseCode == 204) {
                    str = "Not found bldg " + this.f18712b;
                    b = false;
                } else {
                    str = null;
                    b = false;
                }
                if (this.f18711a.f18723b != null) {
                    this.f18711a.f18723b.mo2520a(b, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f18711a.f18725d = false;
        }
    }

    /* renamed from: com.baidu.location.indoor.mapversion.b.a$d */
    public static class C3455d implements Serializable {
        /* renamed from: a */
        public String f18714a;
        /* renamed from: b */
        public String f18715b;
        /* renamed from: c */
        public C3453a f18716c;
        /* renamed from: d */
        public C3453a f18717d;
        /* renamed from: e */
        public C3453a f18718e;
        /* renamed from: f */
        public C3453a f18719f = this.f18717d;
        /* renamed from: g */
        public short[][] f18720g;
        /* renamed from: h */
        private String f18721h = "gcj02";

        public C3455d(String str) {
            this.f18714a = str;
        }

        /* renamed from: a */
        public double m14822a(double d) {
            return (this.f18719f.f18706d + d) * this.f18719f.f18705c;
        }

        /* renamed from: a */
        public C3453a m14823a() {
            return this.f18719f;
        }

        /* renamed from: a */
        public void m14824a(String str) {
            if (str != null) {
                this.f18721h = str.toLowerCase();
                if (this.f18721h.startsWith("wgs84")) {
                    this.f18719f = this.f18716c;
                } else if (this.f18721h.startsWith(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    this.f18719f = this.f18718e;
                } else if (this.f18721h.startsWith("gcj02")) {
                    this.f18719f = this.f18717d;
                }
            }
        }

        /* renamed from: b */
        public double m14825b(double d) {
            return (this.f18719f.f18708f + d) * this.f18719f.f18707e;
        }

        /* renamed from: b */
        public void m14826b(String str) {
            String[] split = str.split("\\t");
            this.f18715b = split[1];
            this.f18716c = new C3453a(split[2]);
            this.f18718e = new C3453a(split[3]);
            this.f18717d = new C3453a(split[4]);
            this.f18719f = this.f18717d;
            this.f18720g = (short[][]) Array.newInstance(Short.TYPE, new int[]{(int) this.f18719f.f18709g, (int) this.f18719f.f18710h});
            for (int i = 0; ((double) i) < this.f18719f.f18709g; i++) {
                for (int i2 = 0; ((double) i2) < this.f18719f.f18710h; i2++) {
                    this.f18720g[i][i2] = (short) (split[5].charAt((((int) this.f18719f.f18710h) * i) + i2) - 48);
                }
            }
        }

        /* renamed from: c */
        public double m14827c(double d) {
            return (d / this.f18719f.f18705c) - this.f18719f.f18706d;
        }

        /* renamed from: d */
        public double m14828d(double d) {
            return (d / this.f18719f.f18707e) - this.f18719f.f18708f;
        }
    }

    private C3456a(Context context) {
        this.f18726e = new File(context.getCacheDir(), this.f18726e).getAbsolutePath();
    }

    /* renamed from: a */
    public static C3456a m14829a() {
        return f18722a;
    }

    /* renamed from: a */
    public static C3456a m14830a(Context context) {
        if (f18722a == null) {
            f18722a = new C3456a(context);
        }
        return f18722a;
    }

    /* renamed from: a */
    public static String m14834a(File file) {
        String str;
        Exception e;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteBuffer map = fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length());
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(map);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
                str = bigInteger;
                int length = 32 - bigInteger.length();
                while (length > 0) {
                    try {
                        length--;
                        str = "0" + str;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            } catch (Exception e3) {
                Exception exception = e3;
                str = bigInteger;
                e = exception;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e32) {
            e = e32;
            str = null;
            e.printStackTrace();
            return str;
        }
        return str;
    }

    /* renamed from: a */
    private String m14835a(String str, String str2) {
        return m14842c(str) + JNISearchConst.LAYER_ID_DIVIDER + str2;
    }

    /* renamed from: b */
    private void m14839b(String str, String str2) {
        try {
            File file = new File(this.f18726e + "/" + m14835a(str, str2));
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private String m14842c(String str) {
        return str;
    }

    /* renamed from: c */
    private boolean m14843c() {
        if (this.f18724c == null) {
            return false;
        }
        File e = m14845e(this.f18724c);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!C3457b.m14853a(e, byteArrayOutputStream)) {
            return false;
        }
        this.f18729h.clear();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                C3455d c3455d = new C3455d(this.f18724c);
                c3455d.m14826b(readLine);
                c3455d.m14824a(this.f18728g);
                this.f18729h.put(c3455d.f18715b.toLowerCase(), c3455d);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        bufferedReader.close();
        return true;
    }

    /* renamed from: d */
    private String m14844d(final String str) {
        int i = 0;
        File file = new File(this.f18726e);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles(new FilenameFilter(this) {
            /* renamed from: b */
            final /* synthetic */ C3456a f18702b;

            public boolean accept(File file, String str) {
                return str.startsWith(new StringBuilder().append(this.f18702b.m14842c(str)).append(JNISearchConst.LAYER_ID_DIVIDER).toString());
            }
        });
        if (listFiles == null || listFiles.length != 1) {
            while (listFiles != null && i < listFiles.length) {
                listFiles[i].delete();
                i++;
            }
            return null;
        }
        String[] split = listFiles[0].getName().split(JNISearchConst.LAYER_ID_DIVIDER);
        return split.length >= 2 ? split[1] : null;
    }

    /* renamed from: e */
    private File m14845e(String str) {
        return new File(this.f18726e + "/" + m14835a(str, m14844d(str)));
    }

    /* renamed from: f */
    private boolean m14846f(String str) {
        File e = m14845e(str);
        return e.exists() && e.length() > 0;
    }

    /* renamed from: g */
    private boolean m14847g(String str) {
        return System.currentTimeMillis() - m14845e(str).lastModified() > 1296000000;
    }

    /* renamed from: h */
    private void m14848h(String str) {
        if (!this.f18725d) {
            this.f18725d = true;
            this.f18727f = new C3454b(this, str, m14844d(str));
            this.f18727f.start();
        }
    }

    /* renamed from: a */
    public void m14849a(String str) {
        this.f18728g = str;
    }

    /* renamed from: a */
    public void m14850a(String str, C3428c c3428c) {
        if (this.f18724c == null || !str.equals(this.f18724c)) {
            this.f18723b = c3428c;
            if (!m14846f(str) || m14847g(str)) {
                m14848h(str);
                return;
            }
            this.f18724c = str;
            m14843c();
            if (this.f18723b != null) {
                this.f18723b.mo2520a(true, "OK");
            }
        }
    }

    /* renamed from: b */
    public C3455d m14851b(String str) {
        return (C3455d) this.f18729h.get(str.toLowerCase());
    }

    /* renamed from: b */
    public void m14852b() {
        this.f18729h.clear();
        this.f18724c = null;
        this.f18725d = false;
    }
}
