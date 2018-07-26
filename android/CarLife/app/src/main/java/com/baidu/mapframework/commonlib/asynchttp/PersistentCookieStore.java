package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class PersistentCookieStore implements CookieStore {
    /* renamed from: a */
    private static final String f18891a = "PersistentCookieStore";
    /* renamed from: b */
    private static final String f18892b = "CookiePrefsFile";
    /* renamed from: c */
    private static final String f18893c = "names";
    /* renamed from: d */
    private static final String f18894d = "cookie_";
    /* renamed from: e */
    private final ConcurrentHashMap<String, Cookie> f18895e;
    /* renamed from: f */
    private final SharedPreferences f18896f;
    /* renamed from: g */
    private boolean f18897g = false;

    public PersistentCookieStore(Context context) {
        int i = 0;
        this.f18896f = context.getSharedPreferences(f18892b, 0);
        this.f18895e = new ConcurrentHashMap();
        String storedCookieNames = this.f18896f.getString(f18893c, null);
        if (storedCookieNames != null) {
            String[] cookieNames = TextUtils.split(storedCookieNames, ",");
            int length = cookieNames.length;
            while (i < length) {
                String name = cookieNames[i];
                String encodedCookie = this.f18896f.getString(f18894d + name, null);
                if (encodedCookie != null) {
                    Cookie decodedCookie = decodeCookie(encodedCookie);
                    if (decodedCookie != null) {
                        this.f18895e.put(name, decodedCookie);
                    }
                }
                i++;
            }
            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie) {
        if (!this.f18897g || cookie.isPersistent()) {
            String name = cookie.getName() + cookie.getDomain();
            if (cookie.isExpired(new Date())) {
                this.f18895e.remove(name);
            } else {
                this.f18895e.put(name, cookie);
            }
            Editor prefsWriter = this.f18896f.edit();
            prefsWriter.putString(f18893c, TextUtils.join(",", this.f18895e.keySet()));
            prefsWriter.putString(f18894d + name, encodeCookie(new SerializableCookie(cookie)));
            prefsWriter.commit();
        }
    }

    public void clear() {
        Editor prefsWriter = this.f18896f.edit();
        for (String name : this.f18895e.keySet()) {
            prefsWriter.remove(f18894d + name);
        }
        prefsWriter.remove(f18893c);
        prefsWriter.commit();
        this.f18895e.clear();
    }

    public boolean clearExpired(Date date) {
        boolean clearedAny = false;
        Editor prefsWriter = this.f18896f.edit();
        for (Entry<String, Cookie> entry : this.f18895e.entrySet()) {
            String name = (String) entry.getKey();
            if (((Cookie) entry.getValue()).isExpired(date)) {
                this.f18895e.remove(name);
                prefsWriter.remove(f18894d + name);
                clearedAny = true;
            }
        }
        if (clearedAny) {
            prefsWriter.putString(f18893c, TextUtils.join(",", this.f18895e.keySet()));
        }
        prefsWriter.commit();
        return clearedAny;
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.f18895e.values());
    }

    public void setOmitNonPersistentCookies(boolean omitNonPersistentCookies) {
        this.f18897g = omitNonPersistentCookies;
    }

    public void deleteCookie(Cookie cookie) {
        String name = cookie.getName() + cookie.getDomain();
        this.f18895e.remove(name);
        Editor prefsWriter = this.f18896f.edit();
        prefsWriter.remove(f18894d + name);
        prefsWriter.commit();
    }

    protected String encodeCookie(SerializableCookie cookie) {
        if (cookie == null) {
            return null;
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(os).writeObject(cookie);
            return byteArrayToHexString(os.toByteArray());
        } catch (IOException e) {
            AsyncHttpClient.log.mo2624d(f18891a, "IOException in encodeCookie", e);
            return null;
        }
    }

    protected Cookie decodeCookie(String cookieString) {
        Cookie cookie = null;
        try {
            cookie = ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(cookieString))).readObject()).getCookie();
        } catch (IOException e) {
            AsyncHttpClient.log.mo2624d(f18891a, "IOException in decodeCookie", e);
        } catch (ClassNotFoundException e2) {
            AsyncHttpClient.log.mo2624d(f18891a, "ClassNotFoundException in decodeCookie", e2);
        }
        return cookie;
    }

    protected String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte element : bytes) {
            int v = element & 255;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    protected byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[(len / 2)];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }
}
