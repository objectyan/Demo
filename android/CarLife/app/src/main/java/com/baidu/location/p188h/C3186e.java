package com.baidu.location.p188h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.C3377f;
import cz.msebera.android.httpclient.C6591q;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.baidu.location.h.e */
public abstract class C3186e {
    /* renamed from: a */
    private static String f17290a = "10.0.0.172";
    /* renamed from: b */
    private static int f17291b = 80;
    /* renamed from: g */
    public static int f17292g = C3380a.f18308g;
    /* renamed from: o */
    protected static int f17293o = 0;
    /* renamed from: h */
    public String f17294h = null;
    /* renamed from: i */
    public int f17295i = 3;
    /* renamed from: j */
    public String f17296j = null;
    /* renamed from: k */
    public Map<String, Object> f17297k = null;
    /* renamed from: l */
    public String f17298l = null;
    /* renamed from: m */
    public byte[] f17299m = null;
    /* renamed from: n */
    public String f17300n = null;

    /* renamed from: com.baidu.location.h.e$1 */
    class C33861 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3186e f18339a;

        C33861(C3186e c3186e) {
            this.f18339a = c3186e;
        }

        public void run() {
            boolean z;
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            Throwable th2;
            boolean z2;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            this.f18339a.f17294h = C3391g.m14448e();
            this.f18339a.mo2500b();
            this.f18339a.mo2494a();
            HttpURLConnection httpURLConnection2 = null;
            for (int i = this.f18339a.f17295i; i > 0; i--) {
                InputStream inputStream2;
                boolean z3;
                try {
                    HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.f18339a.f17294h).openConnection();
                    try {
                        InputStream inputStream3;
                        ByteArrayOutputStream byteArrayOutputStream3;
                        httpURLConnection3.setRequestMethod("GET");
                        httpURLConnection3.setDoInput(true);
                        httpURLConnection3.setDoOutput(true);
                        httpURLConnection3.setUseCaches(false);
                        httpURLConnection3.setConnectTimeout(C3380a.f18303b);
                        httpURLConnection3.setReadTimeout(C3380a.f18303b);
                        httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpURLConnection3.setRequestProperty(C6591q.f26545b, "UTF-8");
                        if (httpURLConnection3.getResponseCode() == 200) {
                            inputStream2 = httpURLConnection3.getInputStream();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream4.write(bArr, 0, read);
                                    }
                                    inputStream2.close();
                                    byteArrayOutputStream4.close();
                                    this.f18339a.f17296j = new String(byteArrayOutputStream4.toByteArray(), "utf-8");
                                    this.f18339a.mo2495a(true);
                                    httpURLConnection3.disconnect();
                                    inputStream3 = inputStream2;
                                    byteArrayOutputStream3 = byteArrayOutputStream4;
                                    z = true;
                                } catch (Exception e) {
                                    ByteArrayOutputStream byteArrayOutputStream5 = byteArrayOutputStream4;
                                    inputStream = inputStream2;
                                    httpURLConnection = httpURLConnection3;
                                    byteArrayOutputStream = byteArrayOutputStream5;
                                    try {
                                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (byteArrayOutputStream == null) {
                                            try {
                                                byteArrayOutputStream.close();
                                                z3 = false;
                                                httpURLConnection2 = httpURLConnection;
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                z3 = false;
                                                httpURLConnection2 = httpURLConnection;
                                            }
                                        } else {
                                            z3 = false;
                                            httpURLConnection2 = httpURLConnection;
                                        }
                                        if (z3) {
                                        } else if (i <= 0) {
                                            C3186e.f17293o = 0;
                                            return;
                                        } else {
                                            C3186e.f17293o++;
                                            this.f18339a.f17296j = null;
                                            this.f18339a.mo2495a(false);
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        th2 = th;
                                        InputStream inputStream4 = inputStream;
                                        httpURLConnection2 = httpURLConnection;
                                        inputStream2 = inputStream4;
                                    }
                                } catch (Throwable th32) {
                                    th = th32;
                                    byteArrayOutputStream2 = byteArrayOutputStream4;
                                    httpURLConnection2 = httpURLConnection3;
                                    th2 = th;
                                }
                            } catch (Exception e4) {
                                inputStream = inputStream2;
                                httpURLConnection = httpURLConnection3;
                                byteArrayOutputStream = null;
                                Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream == null) {
                                    byteArrayOutputStream.close();
                                    z3 = false;
                                    httpURLConnection2 = httpURLConnection;
                                } else {
                                    z3 = false;
                                    httpURLConnection2 = httpURLConnection;
                                }
                                if (z3) {
                                } else if (i <= 0) {
                                    C3186e.f17293o = 0;
                                    return;
                                } else {
                                    C3186e.f17293o++;
                                    this.f18339a.f17296j = null;
                                    this.f18339a.mo2495a(false);
                                    return;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                httpURLConnection2 = httpURLConnection3;
                                th2 = th;
                            }
                        } else {
                            httpURLConnection3.disconnect();
                            z = false;
                            byteArrayOutputStream3 = null;
                            inputStream3 = null;
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream3 != null) {
                            try {
                                byteArrayOutputStream3.close();
                                z2 = z;
                                httpURLConnection2 = httpURLConnection3;
                                z3 = z2;
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                z2 = z;
                                httpURLConnection2 = httpURLConnection3;
                                z3 = z2;
                            }
                        } else {
                            z2 = z;
                            httpURLConnection2 = httpURLConnection3;
                            z3 = z2;
                        }
                    } catch (Exception e7) {
                        inputStream = null;
                        httpURLConnection = httpURLConnection3;
                        byteArrayOutputStream = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream == null) {
                            z3 = false;
                            httpURLConnection2 = httpURLConnection;
                        } else {
                            byteArrayOutputStream.close();
                            z3 = false;
                            httpURLConnection2 = httpURLConnection;
                        }
                        if (z3) {
                        } else if (i <= 0) {
                            C3186e.f17293o++;
                            this.f18339a.f17296j = null;
                            this.f18339a.mo2495a(false);
                            return;
                        } else {
                            C3186e.f17293o = 0;
                            return;
                        }
                    } catch (Throwable th42) {
                        inputStream2 = null;
                        th = th42;
                        httpURLConnection2 = httpURLConnection3;
                        th2 = th;
                    }
                } catch (Exception e8) {
                    byteArrayOutputStream = null;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                    Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream == null) {
                        z3 = false;
                        httpURLConnection2 = httpURLConnection;
                    } else {
                        byteArrayOutputStream.close();
                        z3 = false;
                        httpURLConnection2 = httpURLConnection;
                    }
                    if (z3) {
                    } else if (i <= 0) {
                        C3186e.f17293o++;
                        this.f18339a.f17296j = null;
                        this.f18339a.mo2495a(false);
                        return;
                    } else {
                        C3186e.f17293o = 0;
                        return;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    inputStream2 = null;
                }
                if (z3) {
                    break;
                }
            }
            if (i <= 0) {
                C3186e.f17293o++;
                this.f18339a.f17296j = null;
                this.f18339a.mo2495a(false);
                return;
            }
            C3186e.f17293o = 0;
            return;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
            throw th2;
            throw th2;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e222) {
                    e222.printStackTrace();
                }
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th2;
        }
    }

    /* renamed from: com.baidu.location.h.e$3 */
    class C33883 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3186e f18343a;

        C33883(C3186e c3186e) {
            this.f18343a = c3186e;
        }

        public void run() {
            FileInputStream fileInputStream;
            HttpURLConnection httpURLConnection;
            OutputStream outputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            HttpURLConnection httpURLConnection2;
            FileInputStream fileInputStream2;
            OutputStream outputStream2;
            boolean z;
            Throwable th;
            Throwable th2;
            InputStream inputStream2;
            ByteArrayOutputStream byteArrayOutputStream2;
            boolean z2;
            OutputStream outputStream3 = null;
            this.f18343a.f17294h = C3391g.m14448e();
            this.f18343a.mo2500b();
            this.f18343a.mo2494a();
            HttpURLConnection httpURLConnection3 = null;
            for (int i = this.f18343a.f17295i; i > 0; i--) {
                try {
                    byte[] bArr;
                    URL url = new URL(this.f18343a.f17294h);
                    fileInputStream = new FileInputStream(this.f18343a.f17298l);
                    try {
                        bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setConnectTimeout(C3380a.f18303b);
                            httpURLConnection.setReadTimeout(C3380a.f18304c);
                            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                            httpURLConnection.setRequestProperty(C6591q.f26545b, "UTF-8");
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            httpURLConnection.setRequestProperty("Host", "loc.map.baidu.com");
                            outputStream = httpURLConnection.getOutputStream();
                        } catch (Exception e) {
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpURLConnection2 = httpURLConnection;
                            fileInputStream2 = fileInputStream;
                            outputStream2 = null;
                            try {
                                Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (Exception e2) {
                                        Log.d(C3380a.f18302a, "close fileInput IOException!");
                                    }
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Exception e3) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e5) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                        z = false;
                                        httpURLConnection3 = httpURLConnection2;
                                    }
                                }
                                z = false;
                                httpURLConnection3 = httpURLConnection2;
                                if (!z) {
                                } else if (i <= 0) {
                                    C3186e.f17293o = 0;
                                    return;
                                } else {
                                    C3186e.f17293o++;
                                    this.f18343a.f17296j = null;
                                    this.f18343a.mo2495a(false);
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream3 = outputStream2;
                                fileInputStream = fileInputStream2;
                                th2 = th;
                                ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                                httpURLConnection3 = httpURLConnection2;
                                inputStream2 = inputStream;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                            }
                        } catch (Error e6) {
                            outputStream = null;
                            byteArrayOutputStream2 = null;
                            inputStream2 = null;
                            try {
                                Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e7) {
                                        Log.d(C3380a.f18302a, "close fileInput IOException!");
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception e8) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e9) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e10) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                        httpURLConnection3 = httpURLConnection;
                                        z = false;
                                    }
                                }
                                httpURLConnection3 = httpURLConnection;
                                z = false;
                                if (!z) {
                                } else if (i <= 0) {
                                    C3186e.f17293o++;
                                    this.f18343a.f17296j = null;
                                    this.f18343a.mo2495a(false);
                                    return;
                                } else {
                                    C3186e.f17293o = 0;
                                    return;
                                }
                            } catch (Throwable th32) {
                                th = th32;
                                outputStream3 = outputStream;
                                httpURLConnection3 = httpURLConnection;
                                th2 = th;
                            }
                        } catch (Throwable th4) {
                            byteArrayOutputStream2 = null;
                            inputStream2 = null;
                            th = th4;
                            httpURLConnection3 = httpURLConnection;
                            th2 = th;
                        }
                    } catch (Exception e11) {
                        fileInputStream2 = fileInputStream;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection3;
                        outputStream2 = null;
                        byteArrayOutputStream = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        z = false;
                        httpURLConnection3 = httpURLConnection2;
                        if (!z) {
                        } else if (i <= 0) {
                            C3186e.f17293o = 0;
                            return;
                        } else {
                            C3186e.f17293o++;
                            this.f18343a.f17296j = null;
                            this.f18343a.mo2495a(false);
                            return;
                        }
                    } catch (Error e12) {
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        httpURLConnection = httpURLConnection3;
                        outputStream = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        httpURLConnection3 = httpURLConnection;
                        z = false;
                        if (!z) {
                        } else if (i <= 0) {
                            C3186e.f17293o++;
                            this.f18343a.f17296j = null;
                            this.f18343a.mo2495a(false);
                            return;
                        } else {
                            C3186e.f17293o = 0;
                            return;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                    }
                    try {
                        InputStream inputStream3;
                        ByteArrayOutputStream byteArrayOutputStream4;
                        outputStream.write(bArr);
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() == 200) {
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                String contentEncoding = httpURLConnection.getContentEncoding();
                                inputStream2 = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(new BufferedInputStream(inputStream));
                                try {
                                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr2 = new byte[1024];
                                        while (true) {
                                            int read = inputStream2.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream2.write(bArr2, 0, read);
                                        }
                                        this.f18343a.f17296j = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                        this.f18343a.mo2495a(true);
                                        inputStream3 = inputStream2;
                                        byteArrayOutputStream4 = byteArrayOutputStream2;
                                        z2 = true;
                                    } catch (Exception e13) {
                                        FileInputStream fileInputStream3 = fileInputStream;
                                        outputStream2 = outputStream;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        inputStream = inputStream2;
                                        httpURLConnection2 = httpURLConnection;
                                        fileInputStream2 = fileInputStream3;
                                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        z = false;
                                        httpURLConnection3 = httpURLConnection2;
                                        if (!z) {
                                        } else if (i <= 0) {
                                            C3186e.f17293o = 0;
                                            return;
                                        } else {
                                            C3186e.f17293o++;
                                            this.f18343a.f17296j = null;
                                            this.f18343a.mo2495a(false);
                                            return;
                                        }
                                    } catch (Error e14) {
                                        Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        httpURLConnection3 = httpURLConnection;
                                        z = false;
                                        if (!z) {
                                        } else if (i <= 0) {
                                            C3186e.f17293o++;
                                            this.f18343a.f17296j = null;
                                            this.f18343a.mo2495a(false);
                                            return;
                                        } else {
                                            C3186e.f17293o = 0;
                                            return;
                                        }
                                    }
                                } catch (Exception e15) {
                                    inputStream = inputStream2;
                                    httpURLConnection2 = httpURLConnection;
                                    fileInputStream2 = fileInputStream;
                                    outputStream2 = outputStream;
                                    byteArrayOutputStream = null;
                                    Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    if (fileInputStream2 != null) {
                                        fileInputStream2.close();
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z = false;
                                    httpURLConnection3 = httpURLConnection2;
                                    if (!z) {
                                    } else if (i <= 0) {
                                        C3186e.f17293o = 0;
                                        return;
                                    } else {
                                        C3186e.f17293o++;
                                        this.f18343a.f17296j = null;
                                        this.f18343a.mo2495a(false);
                                        return;
                                    }
                                } catch (Error e16) {
                                    byteArrayOutputStream2 = null;
                                    Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    httpURLConnection3 = httpURLConnection;
                                    z = false;
                                    if (!z) {
                                    } else if (i <= 0) {
                                        C3186e.f17293o++;
                                        this.f18343a.f17296j = null;
                                        this.f18343a.mo2495a(false);
                                        return;
                                    } else {
                                        C3186e.f17293o = 0;
                                        return;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    byteArrayOutputStream2 = null;
                                    outputStream3 = outputStream;
                                    httpURLConnection3 = httpURLConnection;
                                    th2 = th;
                                }
                            } catch (Exception e17) {
                                httpURLConnection2 = httpURLConnection;
                                fileInputStream2 = fileInputStream;
                                outputStream2 = outputStream;
                                byteArrayOutputStream = null;
                                Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z = false;
                                httpURLConnection3 = httpURLConnection2;
                                if (!z) {
                                } else if (i <= 0) {
                                    C3186e.f17293o = 0;
                                    return;
                                } else {
                                    C3186e.f17293o++;
                                    this.f18343a.f17296j = null;
                                    this.f18343a.mo2495a(false);
                                    return;
                                }
                            } catch (Error e18) {
                                inputStream2 = inputStream;
                                byteArrayOutputStream2 = null;
                                Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                httpURLConnection3 = httpURLConnection;
                                z = false;
                                if (!z) {
                                } else if (i <= 0) {
                                    C3186e.f17293o++;
                                    this.f18343a.f17296j = null;
                                    this.f18343a.mo2495a(false);
                                    return;
                                } else {
                                    C3186e.f17293o = 0;
                                    return;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                inputStream2 = inputStream;
                                byteArrayOutputStream2 = null;
                                outputStream3 = outputStream;
                                httpURLConnection3 = httpURLConnection;
                                th2 = th;
                            }
                        } else {
                            z2 = false;
                            byteArrayOutputStream4 = null;
                            inputStream3 = null;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e19) {
                                Log.d(C3380a.f18302a, "close fileInput IOException!");
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e20) {
                                Log.d(C3380a.f18302a, "close os IOException!");
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e21) {
                                Log.d(C3380a.f18302a, "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream4 != null) {
                            try {
                                byteArrayOutputStream4.close();
                            } catch (Exception e22) {
                                Log.d(C3380a.f18302a, "close baos IOException!");
                                httpURLConnection3 = httpURLConnection;
                                z = z2;
                            }
                        }
                        httpURLConnection3 = httpURLConnection;
                        z = z2;
                    } catch (Exception e23) {
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection;
                        fileInputStream2 = fileInputStream;
                        outputStream2 = outputStream;
                        byteArrayOutputStream = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        z = false;
                        httpURLConnection3 = httpURLConnection2;
                        if (!z) {
                        } else if (i <= 0) {
                            C3186e.f17293o = 0;
                            return;
                        } else {
                            C3186e.f17293o++;
                            this.f18343a.f17296j = null;
                            this.f18343a.mo2495a(false);
                            return;
                        }
                    } catch (Error e24) {
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        httpURLConnection3 = httpURLConnection;
                        z = false;
                        if (!z) {
                        } else if (i <= 0) {
                            C3186e.f17293o++;
                            this.f18343a.f17296j = null;
                            this.f18343a.mo2495a(false);
                            return;
                        } else {
                            C3186e.f17293o = 0;
                            return;
                        }
                    } catch (Throwable th62) {
                        inputStream2 = null;
                        OutputStream outputStream4 = outputStream;
                        httpURLConnection3 = httpURLConnection;
                        th2 = th62;
                        byteArrayOutputStream2 = null;
                        outputStream3 = outputStream4;
                    }
                } catch (Exception e25) {
                    fileInputStream2 = null;
                    outputStream2 = null;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection3;
                    byteArrayOutputStream = null;
                    Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    z = false;
                    httpURLConnection3 = httpURLConnection2;
                    if (!z) {
                    } else if (i <= 0) {
                        C3186e.f17293o = 0;
                        return;
                    } else {
                        C3186e.f17293o++;
                        this.f18343a.f17296j = null;
                        this.f18343a.mo2495a(false);
                        return;
                    }
                } catch (Error e26) {
                    fileInputStream = null;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    httpURLConnection = httpURLConnection3;
                    outputStream = null;
                    Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    httpURLConnection3 = httpURLConnection;
                    z = false;
                    if (!z) {
                    } else if (i <= 0) {
                        C3186e.f17293o++;
                        this.f18343a.f17296j = null;
                        this.f18343a.mo2495a(false);
                        return;
                    } else {
                        C3186e.f17293o = 0;
                        return;
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    fileInputStream = null;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                }
                if (!z) {
                    break;
                }
            }
            if (i <= 0) {
                C3186e.f17293o++;
                this.f18343a.f17296j = null;
                this.f18343a.mo2495a(false);
                return;
            }
            C3186e.f17293o = 0;
            return;
            throw th2;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e27) {
                    Log.d(C3380a.f18302a, "close fileInput IOException!");
                }
            }
            if (outputStream3 != null) {
                try {
                    outputStream3.close();
                } catch (Exception e28) {
                    Log.d(C3380a.f18302a, "close os IOException!");
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e29) {
                    Log.d(C3380a.f18302a, "close is IOException!");
                }
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception e30) {
                    Log.d(C3380a.f18302a, "close baos IOException!");
                }
            }
            throw th2;
            if (outputStream3 != null) {
                outputStream3.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th2;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th2;
        }
    }

    /* renamed from: a */
    private static int m13292a(Context context, NetworkInfo networkInfo) {
        String toLowerCase;
        if (!(networkInfo == null || networkInfo.getExtraInfo() == null)) {
            toLowerCase = networkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase != null) {
                if (toLowerCase.startsWith("cmwap") || toLowerCase.startsWith("uniwap") || toLowerCase.startsWith("3gwap")) {
                    toLowerCase = Proxy.getDefaultHost();
                    if (toLowerCase == null || toLowerCase.equals("") || toLowerCase.equals("null")) {
                        toLowerCase = "10.0.0.172";
                    }
                    f17290a = toLowerCase;
                    return C3380a.f18305d;
                } else if (toLowerCase.startsWith("ctwap")) {
                    toLowerCase = Proxy.getDefaultHost();
                    if (toLowerCase == null || toLowerCase.equals("") || toLowerCase.equals("null")) {
                        toLowerCase = "10.0.0.200";
                    }
                    f17290a = toLowerCase;
                    return C3380a.f18305d;
                } else if (toLowerCase.startsWith("cmnet") || toLowerCase.startsWith("uninet") || toLowerCase.startsWith("ctnet") || toLowerCase.startsWith("3gnet")) {
                    return C3380a.f18306e;
                }
            }
        }
        toLowerCase = Proxy.getDefaultHost();
        if (toLowerCase != null && toLowerCase.length() > 0) {
            if ("10.0.0.172".equals(toLowerCase.trim())) {
                f17290a = "10.0.0.172";
                return C3380a.f18305d;
            } else if ("10.0.0.200".equals(toLowerCase.trim())) {
                f17290a = "10.0.0.200";
                return C3380a.f18305d;
            }
        }
        return C3380a.f18306e;
    }

    /* renamed from: b */
    private void mo2500b() {
        f17292g = mo2499c();
    }

    /* renamed from: c */
    private int mo2499c() {
        Context serviceContext = C3377f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return C3380a.f18308g;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return C3380a.f18308g;
            }
            if (activeNetworkInfo.getType() != 1) {
                return C3186e.m13292a(serviceContext, activeNetworkInfo);
            }
            String defaultHost = Proxy.getDefaultHost();
            return (defaultHost == null || defaultHost.length() <= 0) ? C3380a.f18307f : C3380a.f18309h;
        } catch (Exception e) {
            return C3380a.f18308g;
        }
    }

    /* renamed from: a */
    public abstract void mo2494a();

    /* renamed from: a */
    public abstract void mo2495a(boolean z);

    /* renamed from: a */
    public void m13298a(final boolean z, final String str) {
        new Thread(this) {
            /* renamed from: c */
            final /* synthetic */ C3186e f18342c;

            public void run() {
                OutputStream outputStream;
                InputStream inputStream;
                HttpURLConnection httpURLConnection;
                OutputStream outputStream2;
                ByteArrayOutputStream byteArrayOutputStream;
                boolean z;
                Object obj;
                Throwable th;
                Throwable th2;
                HttpURLConnection httpURLConnection2;
                boolean z2;
                OutputStream outputStream3;
                boolean z3;
                OutputStream outputStream4 = null;
                this.f18342c.f17294h = C3391g.m14448e();
                this.f18342c.mo2500b();
                this.f18342c.mo2494a();
                OutputStream outputStream5 = null;
                for (int i = this.f18342c.f17295i; i > 0; i--) {
                    InputStream gZIPInputStream;
                    ByteArrayOutputStream byteArrayOutputStream2;
                    HttpURLConnection httpURLConnection3;
                    try {
                        URL url = new URL(this.f18342c.f17294h);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Entry entry : this.f18342c.f17297k.entrySet()) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append(entry.getValue());
                            stringBuffer.append("&");
                        }
                        if (stringBuffer.length() > 0) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        }
                        httpURLConnection3 = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection3.setRequestMethod("POST");
                            httpURLConnection3.setDoInput(true);
                            httpURLConnection3.setDoOutput(true);
                            httpURLConnection3.setUseCaches(false);
                            httpURLConnection3.setConnectTimeout(C3380a.f18303b);
                            httpURLConnection3.setReadTimeout(C3380a.f18303b);
                            httpURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                            httpURLConnection3.setRequestProperty(C6591q.f26545b, "UTF-8");
                            httpURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                            if (!TextUtils.isEmpty(str)) {
                                httpURLConnection3.setRequestProperty("Host", str);
                            }
                            outputStream = httpURLConnection3.getOutputStream();
                            try {
                                InputStream inputStream2;
                                ByteArrayOutputStream byteArrayOutputStream3;
                                outputStream.write(stringBuffer.toString().getBytes());
                                outputStream.flush();
                                if (httpURLConnection3.getResponseCode() == 200) {
                                    inputStream = httpURLConnection3.getInputStream();
                                    try {
                                        String contentEncoding = httpURLConnection3.getContentEncoding();
                                        gZIPInputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(new BufferedInputStream(inputStream));
                                    } catch (Exception e) {
                                        httpURLConnection = httpURLConnection3;
                                        outputStream2 = outputStream;
                                        byteArrayOutputStream = null;
                                        try {
                                            Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (outputStream2 != null) {
                                                try {
                                                    outputStream2.close();
                                                } catch (Exception e2) {
                                                    Log.d(C3380a.f18302a, "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e3) {
                                                    Log.d(C3380a.f18302a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception e4) {
                                                    Log.d(C3380a.f18302a, "close baos IOException!");
                                                    z = false;
                                                    obj = httpURLConnection;
                                                }
                                            }
                                            z = false;
                                            outputStream5 = httpURLConnection;
                                            if (z) {
                                            } else if (i <= 0) {
                                                C3186e.f17293o = 0;
                                                return;
                                            } else {
                                                C3186e.f17293o++;
                                                this.f18342c.f17296j = null;
                                                this.f18342c.mo2495a(false);
                                                return;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream4 = outputStream2;
                                            th2 = th;
                                            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream;
                                            httpURLConnection2 = httpURLConnection;
                                            gZIPInputStream = inputStream;
                                            byteArrayOutputStream2 = byteArrayOutputStream4;
                                        }
                                    } catch (Error e5) {
                                        gZIPInputStream = inputStream;
                                        byteArrayOutputStream2 = null;
                                        try {
                                            Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                            if (httpURLConnection3 != null) {
                                                httpURLConnection3.disconnect();
                                            }
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e6) {
                                                    Log.d(C3380a.f18302a, "close os IOException!");
                                                }
                                            }
                                            if (gZIPInputStream != null) {
                                                try {
                                                    gZIPInputStream.close();
                                                } catch (Exception e7) {
                                                    Log.d(C3380a.f18302a, "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                try {
                                                    byteArrayOutputStream2.close();
                                                } catch (Exception e8) {
                                                    Log.d(C3380a.f18302a, "close baos IOException!");
                                                    obj = httpURLConnection3;
                                                    z = false;
                                                }
                                            }
                                            obj = httpURLConnection3;
                                            z = false;
                                            if (z) {
                                            } else if (i <= 0) {
                                                C3186e.f17293o++;
                                                this.f18342c.f17296j = null;
                                                this.f18342c.mo2495a(false);
                                                return;
                                            } else {
                                                C3186e.f17293o = 0;
                                                return;
                                            }
                                        } catch (Throwable th32) {
                                            th = th32;
                                            outputStream4 = outputStream;
                                            httpURLConnection2 = httpURLConnection3;
                                            th2 = th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        gZIPInputStream = inputStream;
                                        byteArrayOutputStream2 = null;
                                        outputStream4 = outputStream;
                                        httpURLConnection2 = httpURLConnection3;
                                        th2 = th;
                                    }
                                    try {
                                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                                        try {
                                            byte[] bArr = new byte[1024];
                                            while (true) {
                                                int read = gZIPInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream2.write(bArr, 0, read);
                                            }
                                            this.f18342c.f17296j = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                            if (z) {
                                                this.f18342c.f17299m = byteArrayOutputStream2.toByteArray();
                                            }
                                            this.f18342c.mo2495a(true);
                                            inputStream2 = gZIPInputStream;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            z2 = true;
                                        } catch (Exception e9) {
                                            outputStream3 = outputStream;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            inputStream = gZIPInputStream;
                                            httpURLConnection = httpURLConnection3;
                                            outputStream2 = outputStream3;
                                            Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (outputStream2 != null) {
                                                outputStream2.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            z = false;
                                            outputStream5 = httpURLConnection;
                                            if (z) {
                                            } else if (i <= 0) {
                                                C3186e.f17293o = 0;
                                                return;
                                            } else {
                                                C3186e.f17293o++;
                                                this.f18342c.f17296j = null;
                                                this.f18342c.mo2495a(false);
                                                return;
                                            }
                                        } catch (Error e10) {
                                            Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                            if (httpURLConnection3 != null) {
                                                httpURLConnection3.disconnect();
                                            }
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            if (gZIPInputStream != null) {
                                                gZIPInputStream.close();
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                byteArrayOutputStream2.close();
                                            }
                                            obj = httpURLConnection3;
                                            z = false;
                                            if (z) {
                                            } else if (i <= 0) {
                                                C3186e.f17293o++;
                                                this.f18342c.f17296j = null;
                                                this.f18342c.mo2495a(false);
                                                return;
                                            } else {
                                                C3186e.f17293o = 0;
                                                return;
                                            }
                                        }
                                    } catch (Exception e11) {
                                        inputStream = gZIPInputStream;
                                        httpURLConnection = httpURLConnection3;
                                        outputStream2 = outputStream;
                                        byteArrayOutputStream = null;
                                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        z = false;
                                        outputStream5 = httpURLConnection;
                                        if (z) {
                                        } else if (i <= 0) {
                                            C3186e.f17293o = 0;
                                            return;
                                        } else {
                                            C3186e.f17293o++;
                                            this.f18342c.f17296j = null;
                                            this.f18342c.mo2495a(false);
                                            return;
                                        }
                                    } catch (Error e12) {
                                        byteArrayOutputStream2 = null;
                                        Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                        if (httpURLConnection3 != null) {
                                            httpURLConnection3.disconnect();
                                        }
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (gZIPInputStream != null) {
                                            gZIPInputStream.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        obj = httpURLConnection3;
                                        z = false;
                                        if (z) {
                                        } else if (i <= 0) {
                                            C3186e.f17293o++;
                                            this.f18342c.f17296j = null;
                                            this.f18342c.mo2495a(false);
                                            return;
                                        } else {
                                            C3186e.f17293o = 0;
                                            return;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        byteArrayOutputStream2 = null;
                                        outputStream4 = outputStream;
                                        httpURLConnection2 = httpURLConnection3;
                                        th2 = th;
                                    }
                                } else {
                                    z2 = false;
                                    byteArrayOutputStream3 = null;
                                    inputStream2 = null;
                                }
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception e13) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e14) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream3 != null) {
                                    try {
                                        byteArrayOutputStream3.close();
                                    } catch (Exception e15) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                        z3 = z2;
                                        obj = httpURLConnection3;
                                        z = z3;
                                    }
                                }
                                z3 = z2;
                                obj = httpURLConnection3;
                                z = z3;
                            } catch (Exception e16) {
                                inputStream = null;
                                httpURLConnection = httpURLConnection3;
                                outputStream2 = outputStream;
                                byteArrayOutputStream = null;
                                Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z = false;
                                outputStream5 = httpURLConnection;
                                if (z) {
                                } else if (i <= 0) {
                                    C3186e.f17293o = 0;
                                    return;
                                } else {
                                    C3186e.f17293o++;
                                    this.f18342c.f17296j = null;
                                    this.f18342c.mo2495a(false);
                                    return;
                                }
                            } catch (Error e17) {
                                byteArrayOutputStream2 = null;
                                gZIPInputStream = null;
                                Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                obj = httpURLConnection3;
                                z = false;
                                if (z) {
                                } else if (i <= 0) {
                                    C3186e.f17293o++;
                                    this.f18342c.f17296j = null;
                                    this.f18342c.mo2495a(false);
                                    return;
                                } else {
                                    C3186e.f17293o = 0;
                                    return;
                                }
                            } catch (Throwable th52) {
                                gZIPInputStream = null;
                                outputStream3 = outputStream;
                                httpURLConnection2 = httpURLConnection3;
                                th2 = th52;
                                byteArrayOutputStream2 = null;
                                outputStream4 = outputStream3;
                            }
                        } catch (Exception e18) {
                            byteArrayOutputStream = null;
                            inputStream = null;
                            httpURLConnection = httpURLConnection3;
                            outputStream2 = null;
                            Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            z = false;
                            outputStream5 = httpURLConnection;
                            if (z) {
                            } else if (i <= 0) {
                                C3186e.f17293o = 0;
                                return;
                            } else {
                                C3186e.f17293o++;
                                this.f18342c.f17296j = null;
                                this.f18342c.mo2495a(false);
                                return;
                            }
                        } catch (Error e19) {
                            outputStream = null;
                            byteArrayOutputStream2 = null;
                            gZIPInputStream = null;
                            Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            obj = httpURLConnection3;
                            z = false;
                            if (z) {
                            } else if (i <= 0) {
                                C3186e.f17293o++;
                                this.f18342c.f17296j = null;
                                this.f18342c.mo2495a(false);
                                return;
                            } else {
                                C3186e.f17293o = 0;
                                return;
                            }
                        } catch (Throwable th6) {
                            byteArrayOutputStream2 = null;
                            gZIPInputStream = null;
                            th = th6;
                            httpURLConnection2 = httpURLConnection3;
                            th2 = th;
                        }
                    } catch (Exception e20) {
                        outputStream2 = null;
                        byteArrayOutputStream = null;
                        httpURLConnection = outputStream5;
                        inputStream = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationException!");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        z = false;
                        outputStream5 = httpURLConnection;
                        if (z) {
                        } else if (i <= 0) {
                            C3186e.f17293o = 0;
                            return;
                        } else {
                            C3186e.f17293o++;
                            this.f18342c.f17296j = null;
                            this.f18342c.mo2495a(false);
                            return;
                        }
                    } catch (Error e21) {
                        outputStream = null;
                        gZIPInputStream = null;
                        Object obj2 = outputStream5;
                        byteArrayOutputStream2 = null;
                        Log.d(C3380a.f18302a, "NetworkCommunicationError!");
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        obj = httpURLConnection3;
                        z = false;
                        if (z) {
                        } else if (i <= 0) {
                            C3186e.f17293o++;
                            this.f18342c.f17296j = null;
                            this.f18342c.mo2495a(false);
                            return;
                        } else {
                            C3186e.f17293o = 0;
                            return;
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        gZIPInputStream = null;
                        Object obj3 = outputStream5;
                        byteArrayOutputStream2 = null;
                    }
                    if (z) {
                        break;
                    }
                }
                if (i <= 0) {
                    C3186e.f17293o++;
                    this.f18342c.f17296j = null;
                    this.f18342c.mo2495a(false);
                    return;
                }
                C3186e.f17293o = 0;
                return;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e22) {
                        Log.d(C3380a.f18302a, "close baos IOException!");
                    }
                }
                throw th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (outputStream4 != null) {
                    try {
                        outputStream4.close();
                    } catch (Exception e23) {
                        Log.d(C3380a.f18302a, "close os IOException!");
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e24) {
                        Log.d(C3380a.f18302a, "close is IOException!");
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                throw th2;
                throw th2;
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                throw th2;
            }
        }.start();
    }

    /* renamed from: c */
    public void m13299c(final String str) {
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ C3186e f18345b;

            public void run() {
                URL url;
                Exception e;
                OutputStream outputStream;
                InputStream inputStream;
                URL url2;
                HttpsURLConnection httpsURLConnection;
                ByteArrayOutputStream byteArrayOutputStream;
                Throwable th;
                ByteArrayOutputStream byteArrayOutputStream2;
                HttpsURLConnection httpsURLConnection2;
                Error e2;
                Error error;
                Throwable th2;
                OutputStream outputStream2 = null;
                this.f18345b.mo2494a();
                this.f18345b.mo2500b();
                this.f18345b.f17294h = str;
                InputStream inputStream2;
                try {
                    HttpsURLConnection httpsURLConnection3;
                    StringBuffer stringBuffer = new StringBuffer();
                    url = new URL(this.f18345b.f17294h);
                    try {
                        httpsURLConnection3 = (HttpsURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        e = e3;
                        outputStream = null;
                        inputStream = null;
                        url2 = url;
                        httpsURLConnection = null;
                        try {
                            e.printStackTrace();
                            Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                            this.f18345b.f17296j = null;
                            this.f18345b.mo2495a(false);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (url2 != null) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Exception e4) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e5) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e6) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                        return;
                                    }
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            url = url2;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            outputStream2 = outputStream;
                            httpsURLConnection2 = httpsURLConnection;
                            inputStream2 = inputStream;
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (url != null) {
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Exception e7) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e8) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e9) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                    }
                                }
                                throw th;
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Error e10) {
                        e2 = e10;
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        httpsURLConnection2 = null;
                        try {
                            e2.printStackTrace();
                            Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                            this.f18345b.f17296j = null;
                            this.f18345b.mo2495a(false);
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (url != null) {
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Exception e11) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e12) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e13) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                        return;
                                    }
                                }
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (url != null) {
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                throw th;
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        httpsURLConnection2 = null;
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (url != null) {
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            throw th;
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        throw th;
                    }
                    try {
                        httpsURLConnection3.setInstanceFollowRedirects(false);
                        httpsURLConnection3.setDoOutput(true);
                        httpsURLConnection3.setDoInput(true);
                        httpsURLConnection3.setConnectTimeout(C3380a.f18303b);
                        httpsURLConnection3.setReadTimeout(C3380a.f18304c);
                        httpsURLConnection3.setRequestMethod("POST");
                        httpsURLConnection3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpsURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                        for (Entry entry : this.f18345b.f17297k.entrySet()) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append(entry.getValue());
                            stringBuffer.append("&");
                        }
                        if (stringBuffer.length() > 0) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        }
                        OutputStream outputStream3 = httpsURLConnection3.getOutputStream();
                        try {
                            outputStream3.write(stringBuffer.toString().getBytes());
                            outputStream3.flush();
                            if (httpsURLConnection3.getResponseCode() == 200) {
                                InputStream inputStream3 = httpsURLConnection3.getInputStream();
                                try {
                                    String contentEncoding = httpsURLConnection3.getContentEncoding();
                                    inputStream2 = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream3 : new GZIPInputStream(new BufferedInputStream(inputStream3));
                                } catch (Exception e14) {
                                    httpsURLConnection = httpsURLConnection3;
                                    e = e14;
                                    outputStream = outputStream3;
                                    inputStream = inputStream3;
                                    url2 = url;
                                    e.printStackTrace();
                                    Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                                    this.f18345b.f17296j = null;
                                    this.f18345b.mo2495a(false);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (url2 != null) {
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } catch (Error e15) {
                                    inputStream2 = inputStream3;
                                    byteArrayOutputStream2 = null;
                                    outputStream2 = outputStream3;
                                    error = e15;
                                    httpsURLConnection2 = httpsURLConnection3;
                                    e2 = error;
                                    e2.printStackTrace();
                                    Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                                    this.f18345b.f17296j = null;
                                    this.f18345b.mo2495a(false);
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (url != null) {
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                } catch (Throwable th6) {
                                    inputStream2 = inputStream3;
                                    byteArrayOutputStream2 = null;
                                    outputStream2 = outputStream3;
                                    th2 = th6;
                                    httpsURLConnection2 = httpsURLConnection3;
                                    th = th2;
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (url != null) {
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = inputStream2.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            byteArrayOutputStream2.write(bArr, 0, read);
                                        }
                                        this.f18345b.f17296j = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                        this.f18345b.mo2495a(true);
                                    } catch (Exception e142) {
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        url2 = url;
                                        Exception exception = e142;
                                        outputStream = outputStream3;
                                        inputStream = inputStream2;
                                        httpsURLConnection = httpsURLConnection3;
                                        e = exception;
                                        e.printStackTrace();
                                        Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                                        this.f18345b.f17296j = null;
                                        this.f18345b.mo2495a(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (url2 != null) {
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        }
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (Error e152) {
                                        outputStream2 = outputStream3;
                                        error = e152;
                                        httpsURLConnection2 = httpsURLConnection3;
                                        e2 = error;
                                        e2.printStackTrace();
                                        Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                                        this.f18345b.f17296j = null;
                                        this.f18345b.mo2495a(false);
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        if (url != null) {
                                            if (outputStream2 != null) {
                                                outputStream2.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                byteArrayOutputStream2.close();
                                            }
                                        }
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                    } catch (Throwable th62) {
                                        outputStream2 = outputStream3;
                                        th2 = th62;
                                        httpsURLConnection2 = httpsURLConnection3;
                                        th = th2;
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        if (url != null) {
                                            if (outputStream2 != null) {
                                                outputStream2.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (byteArrayOutputStream2 != null) {
                                                byteArrayOutputStream2.close();
                                            }
                                            throw th;
                                        }
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e1422) {
                                    url2 = url;
                                    OutputStream outputStream4 = outputStream3;
                                    inputStream = inputStream2;
                                    httpsURLConnection = httpsURLConnection3;
                                    e = e1422;
                                    outputStream = outputStream4;
                                    e.printStackTrace();
                                    Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                                    this.f18345b.f17296j = null;
                                    this.f18345b.mo2495a(false);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (url2 != null) {
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } catch (Error e1522) {
                                    byteArrayOutputStream2 = null;
                                    outputStream2 = outputStream3;
                                    error = e1522;
                                    httpsURLConnection2 = httpsURLConnection3;
                                    e2 = error;
                                    e2.printStackTrace();
                                    Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                                    this.f18345b.f17296j = null;
                                    this.f18345b.mo2495a(false);
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (url != null) {
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                } catch (Throwable th622) {
                                    byteArrayOutputStream2 = null;
                                    outputStream2 = outputStream3;
                                    th2 = th622;
                                    httpsURLConnection2 = httpsURLConnection3;
                                    th = th2;
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (url != null) {
                                        if (outputStream2 != null) {
                                            outputStream2.close();
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (byteArrayOutputStream2 != null) {
                                            byteArrayOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                    throw th;
                                }
                            }
                            this.f18345b.f17296j = null;
                            this.f18345b.mo2495a(false);
                            byteArrayOutputStream2 = null;
                            inputStream2 = null;
                            if (httpsURLConnection3 != null) {
                                httpsURLConnection3.disconnect();
                            }
                            if (url != null) {
                                if (outputStream3 != null) {
                                    try {
                                        outputStream3.close();
                                    } catch (Exception e16) {
                                        Log.d(C3380a.f18302a, "close os IOException!");
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e17) {
                                        Log.d(C3380a.f18302a, "close is IOException!");
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e18) {
                                        Log.d(C3380a.f18302a, "close baos IOException!");
                                        return;
                                    }
                                }
                            }
                            if (outputStream3 != null) {
                                outputStream3.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                        } catch (Exception e14222) {
                            url2 = url;
                            httpsURLConnection = httpsURLConnection3;
                            e = e14222;
                            outputStream = outputStream3;
                            inputStream = null;
                            e.printStackTrace();
                            Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                            this.f18345b.f17296j = null;
                            this.f18345b.mo2495a(false);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (url2 != null) {
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (Error e15222) {
                            byteArrayOutputStream2 = null;
                            inputStream2 = null;
                            outputStream2 = outputStream3;
                            error = e15222;
                            httpsURLConnection2 = httpsURLConnection3;
                            e2 = error;
                            e2.printStackTrace();
                            Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                            this.f18345b.f17296j = null;
                            this.f18345b.mo2495a(false);
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (url != null) {
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                        } catch (Throwable th6222) {
                            byteArrayOutputStream2 = null;
                            inputStream2 = null;
                            outputStream2 = outputStream3;
                            th2 = th6222;
                            httpsURLConnection2 = httpsURLConnection3;
                            th = th2;
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (url != null) {
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                throw th;
                            }
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e142222) {
                        inputStream = null;
                        url2 = url;
                        httpsURLConnection = httpsURLConnection3;
                        e = e142222;
                        outputStream = null;
                        e.printStackTrace();
                        Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                        this.f18345b.f17296j = null;
                        this.f18345b.mo2495a(false);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (url2 != null) {
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (Error e152222) {
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        error = e152222;
                        httpsURLConnection2 = httpsURLConnection3;
                        e2 = error;
                        e2.printStackTrace();
                        Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                        this.f18345b.f17296j = null;
                        this.f18345b.mo2495a(false);
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (url != null) {
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                    } catch (Throwable th62222) {
                        byteArrayOutputStream2 = null;
                        inputStream2 = null;
                        th2 = th62222;
                        httpsURLConnection2 = httpsURLConnection3;
                        th = th2;
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (url != null) {
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            throw th;
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    outputStream = null;
                    inputStream = null;
                    Object obj = null;
                    httpsURLConnection = null;
                    e.printStackTrace();
                    Log.i(C3380a.f18302a, "https NetworkCommunicationException!");
                    this.f18345b.f17296j = null;
                    this.f18345b.mo2495a(false);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (url2 != null) {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                } catch (Error e20) {
                    e2 = e20;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url = null;
                    httpsURLConnection2 = null;
                    e2.printStackTrace();
                    Log.i(C3380a.f18302a, "https NetworkCommunicationError!");
                    this.f18345b.f17296j = null;
                    this.f18345b.mo2495a(false);
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    if (url != null) {
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    byteArrayOutputStream2 = null;
                    inputStream2 = null;
                    url = null;
                    httpsURLConnection2 = null;
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                    if (url != null) {
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        throw th;
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    throw th;
                }
            }
        }.start();
    }

    /* renamed from: h */
    public void m13300h() {
        new C33861(this).start();
    }

    /* renamed from: i */
    public void m13301i() {
        m13298a(false, "loc.map.baidu.com");
    }

    /* renamed from: j */
    public void m13302j() {
        new C33883(this).start();
    }
}
