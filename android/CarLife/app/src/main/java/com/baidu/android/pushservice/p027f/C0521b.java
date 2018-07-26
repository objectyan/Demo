package com.baidu.android.pushservice.p027f;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.baidu.android.pushservice.f.b */
public class C0521b {
    static {
        if (VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    /* renamed from: a */
    public static C0520a m2163a(String str, String str2, HashMap<String, String> hashMap) {
        HttpURLConnection httpURLConnection = null;
        C0520a c0520a = new C0520a();
        try {
            httpURLConnection = C0521b.m2167a(str, str2, null);
            C0521b.m2168a(str2, (HashMap) hashMap, httpURLConnection);
            c0520a = C0521b.m2165a(httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return c0520a;
    }

    /* renamed from: a */
    public static C0520a m2164a(String str, String str2, HashMap<String, String> hashMap, String str3) {
        HttpURLConnection httpURLConnection = null;
        C0520a c0520a = new C0520a();
        try {
            httpURLConnection = C0521b.m2167a(str, str2, str3);
            C0521b.m2168a(str2, (HashMap) hashMap, httpURLConnection);
            c0520a = C0521b.m2165a(httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return c0520a;
    }

    /* renamed from: a */
    private static C0520a m2165a(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        C0520a c0520a = new C0520a();
        int i = 0;
        try {
            i = httpURLConnection.getResponseCode();
            InputStream errorStream = C0521b.m2170a(i) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            try {
                inputStream = new BufferedInputStream(errorStream);
                errorStream = C0521b.m2173b(httpURLConnection) ? new GZIPInputStream(inputStream) : inputStream;
                try {
                    inputStream = new ByteArrayInputStream(C0521b.m2172a(errorStream));
                } catch (Exception e) {
                    inputStream = errorStream;
                }
            } catch (Exception e2) {
                inputStream = errorStream;
            }
        } catch (Exception e3) {
        }
        c0520a.m2160a(i);
        c0520a.m2161a(inputStream);
        return c0520a;
    }

    /* renamed from: a */
    private static String m2166a(HashMap<String, String> hashMap) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("");
        int i = 0;
        for (Entry entry : hashMap.entrySet()) {
            if (i != 0) {
                stringBuffer.append("&");
            }
            String str = (String) entry.getKey();
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str).append("=");
                String str2 = (String) entry.getValue();
                if (TextUtils.isEmpty(str2)) {
                    stringBuffer.append(URLEncoder.encode("", "UTF-8"));
                } else {
                    stringBuffer.append(URLEncoder.encode(str2, "UTF-8"));
                }
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static HttpURLConnection m2167a(String str, String str2, String str3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                if ("POST".equals(str2) || "PUT".equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                } else if ("DELETE".equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                } else if ("GET".equals(str2)) {
                    httpURLConnection.setDoOutput(false);
                }
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty("User-Agent", str3);
                }
                if (httpURLConnection instanceof HttpsURLConnection) {
                    httpURLConnection.connect();
                } else {
                    httpURLConnection.connect();
                }
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m2168a(String str, HashMap<String, String> hashMap, HttpURLConnection httpURLConnection) throws IOException {
        if (("POST".equals(str) || "PUT".equals(str) || "DELETE".equals(str)) && !C0521b.m2171a(httpURLConnection, hashMap)) {
            throw new IOException("failed to writeRequestParams");
        }
    }

    /* renamed from: a */
    public static void m2169a(Closeable... closeableArr) {
        if (closeableArr != null) {
            try {
                if (closeableArr.length > 0) {
                    for (Closeable closeable : closeableArr) {
                        if (closeable != null) {
                            closeable.close();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private static boolean m2170a(int i) {
        int i2 = i / 100;
        return i2 == 4 || i2 == 5 || i2 == 6;
    }

    /* renamed from: a */
    private static boolean m2171a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        DataOutputStream dataOutputStream;
        Object obj;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        boolean z = (hashMap == null || hashMap.isEmpty()) ? false : true;
        OutputStream outputStream;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                dataOutputStream = new DataOutputStream(outputStream);
                try {
                    dataOutputStream.write(C0521b.m2166a((HashMap) hashMap).getBytes("UTF-8"));
                    dataOutputStream.flush();
                    C0521b.m2169a(dataOutputStream, outputStream);
                    return z;
                } catch (Exception e) {
                    Object obj2 = dataOutputStream;
                    obj = outputStream;
                    C0521b.m2169a(closeable, closeable2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    C0521b.m2169a(dataOutputStream, outputStream);
                    throw th;
                }
            } catch (Exception e2) {
                closeable = null;
                obj = outputStream;
                C0521b.m2169a(closeable, closeable2);
                return false;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                C0521b.m2169a(dataOutputStream, outputStream);
                throw th;
            }
        } catch (Exception e3) {
            closeable = null;
            C0521b.m2169a(closeable, closeable2);
            return false;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            outputStream = null;
            C0521b.m2169a(dataOutputStream, outputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m2172a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                C0521b.m2169a(byteArrayOutputStream, inputStream);
            } catch (Throwable th) {
                C0521b.m2169a(byteArrayOutputStream, inputStream);
            }
        }
        C0521b.m2169a(byteArrayOutputStream, inputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private static boolean m2173b(HttpURLConnection httpURLConnection) {
        Object headerField = httpURLConnection.getHeaderField("Content-Encoding");
        return !TextUtils.isEmpty(headerField) && headerField.contains("zip");
    }
}
