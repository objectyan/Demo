package com.baidu.speech.asr;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.common.p141m.C2924g;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class EventContext extends ContextWrapper {
    private static final String TAG = "EventContext";
    private static final Logger logger = Logger.getLogger(TAG);

    private static class SmartLogger {
        private static final String TAG = "baidu_speech";
        private static final Logger logger = Logger.getLogger(TAG);

        static {
            logger.setLevel(Level.OFF);
        }

        private SmartLogger() {
        }

        public static <T> T wrap(Object obj, String[] strArr) {
            return wrap(TAG, obj, strArr);
        }

        public static <T> T wrap(String str, final Object obj, final String... strArr) {
            final boolean isLoggable = Log.isLoggable(TAG, 3);
            if (Log.isLoggable(TAG, 3)) {
                logger.setLevel(Level.ALL);
            }
            ArrayList arrayList = new ArrayList();
            Class cls = obj.getClass();
            do {
                arrayList.addAll(Arrays.asList(cls.getInterfaces()));
                cls = cls.getSuperclass();
            } while (cls != Object.class);
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), (Class[]) arrayList.toArray(new Class[0]), new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    Object invoke = method.invoke(obj, objArr);
                    StringBuffer stringBuffer = new StringBuffer();
                    String name = (strArr == null || strArr.length <= 0) ? obj.getClass().getName() : strArr[0];
                    stringBuffer.append(name + "@" + Integer.toHexString(obj.hashCode()));
                    stringBuffer.append("." + method.getName() + "(");
                    if (objArr != null) {
                        for (Object obj2 : objArr) {
                            name = obj2 + "";
                            if (!isLoggable) {
                                name = name.replaceAll("[\r\n]]", "");
                                name = name.substring(0, Math.min(50, name.length()));
                            }
                            stringBuffer.append(name + ", ");
                        }
                    }
                    stringBuffer.append(") : " + invoke);
                    SmartLogger.logger.info(stringBuffer.toString());
                    return invoke;
                }
            });
        }
    }

    public EventContext(Context context) {
        super(context);
    }

    public static short[] byteToShortArray(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return new short[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.nativeOrder());
        allocate.put(bArr, i, i2);
        allocate.clear();
        short[] sArr = new short[(i2 / 2)];
        allocate.asShortBuffer().get(sArr);
        return sArr;
    }

    public static long computePower(short[] sArr, int i) {
        if (sArr == null) {
            return 0;
        }
        System.currentTimeMillis();
        int min = Math.min(i / 2, 512);
        if (min <= 0) {
            return 0;
        }
        long j = 0;
        for (int i2 = 0; i2 < min; i2++) {
            j += (long) (sArr[i2 * 2] * sArr[i2 * 2]);
        }
        return (long) Math.sqrt((double) (j / ((long) min)));
    }

    public long computePower(byte[] bArr, int i) {
        short[] sArr = new short[(i / 2)];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
        }
        return computePower(sArr, sArr.length);
    }

    public SharedPreferences getSdkSharedPreferences() {
        return super.getSharedPreferences("bds", 0);
    }

    public String httpRequest(String str, Map<String, String> map, byte[] bArr, boolean z) throws Exception {
        Throwable th;
        Throwable th2;
        HttpURLConnection httpURLConnection = null;
        try {
            if (Log.isLoggable(TAG, 3) || logger.isLoggable(Level.ALL)) {
                logger.info("cur time: " + (System.currentTimeMillis() % 1000000) + ", http req: " + str);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(8000);
                httpURLConnection2.setReadTimeout(8000);
                httpURLConnection2.setInstanceFollowRedirects(false);
                for (Entry entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (bArr != null || z) {
                    httpURLConnection2.setRequestMethod("POST");
                }
                httpURLConnection2.connect();
                if (bArr != null) {
                    httpURLConnection2.getOutputStream().write(bArr);
                }
                String next = new Scanner(httpURLConnection2.getInputStream()).useDelimiter("\\A").next();
                if (Log.isLoggable(TAG, 3) || logger.isLoggable(Level.ALL)) {
                    logger.info("http res: " + next);
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return next;
            } catch (Throwable e) {
                th = e;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                try {
                    if (Log.isLoggable(TAG, 3) || logger.isLoggable(Level.ALL)) {
                        logger.log(Level.WARNING, "", th2);
                    }
                    throw th2;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable e2) {
                th = e2;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Exception e3) {
            th2 = e3;
            logger.log(Level.WARNING, "", th2);
            throw th2;
        }
    }

    public String join(List<String> list, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str2 : list) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(str);
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    public byte[] loadBytesFromUri(String str) throws IOException {
        InputStream inputStream = null;
        try {
            CharSequence charSequence;
            if (!str.contains("://")) {
                charSequence = "file://" + str;
            }
            Matcher matcher = Pattern.compile("(.*?)://(.*)").matcher(charSequence);
            if (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (group.equalsIgnoreCase(C2924g.f12889c)) {
                    inputStream = new FileInputStream(group2);
                } else if (group.equalsIgnoreCase(C2924g.f12891e) || group.equalsIgnoreCase("assets")) {
                    inputStream = getClass().getResourceAsStream("/assets" + (group2.startsWith("/") ? "" : "/") + group2);
                } else if (group.equalsIgnoreCase(C2924g.f12892f)) {
                    inputStream = getClass().getResourceAsStream(group2);
                }
            }
            if (inputStream == null) {
                throw new IOException("bad data source");
            }
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
            return bArr;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public JSONObject loadJsonFromUri(String str) {
        return loadJsonFromUri(str, false, false);
    }

    public JSONObject loadJsonFromUri(String str, boolean z, boolean z2) {
        try {
            return loadJsonFromUriOrThrow(str, z, z2);
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject loadJsonFromUriOrThrow(String str) throws IOException, JSONException {
        return loadJsonFromUriOrThrow(str, false, false);
    }

    public JSONObject loadJsonFromUriOrThrow(String str, boolean z, boolean z2) throws IOException, JSONException {
        String loadStringFromUri = loadStringFromUri(str, z);
        if (z2) {
            loadStringFromUri = URLDecoder.decode(loadStringFromUri, "UTF-8");
        }
        return new JSONObject(loadStringFromUri);
    }

    public String loadStringFromUri(String str) throws IOException {
        return loadStringFromUri(str, false);
    }

    public String loadStringFromUri(String str, boolean z) throws IOException {
        byte[] loadBytesFromUri = loadBytesFromUri(str);
        return z ? new String(Base64.decode(loadBytesFromUri, 0), "UTF-8") : new String(loadBytesFromUri, "UTF-8");
    }

    public <T> T loggerIt(Object obj, String... strArr) {
        return SmartLogger.wrap(obj, strArr);
    }

    public Object searchItemFromJson(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (str2.equals(str)) {
                return jSONObject.get(str);
            }
            Object obj = jSONObject.get(str2);
            if (obj instanceof JSONObject) {
                obj = searchItemFromJson((JSONObject) obj, str);
                if (obj != null) {
                    return obj;
                }
            }
        }
        return null;
    }
}
