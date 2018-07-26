package com.baidu.tts.loopj;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class PersistentCookieStore implements CookieStore {
    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String LOG_TAG = "PersistentCookieStore";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap<String, Cookie> cookies;
    private boolean omitNonPersistentCookies = false;

    public PersistentCookieStore(Context context) {
        int i = 0;
        this.cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        this.cookies = new ConcurrentHashMap();
        String string = this.cookiePrefs.getString(COOKIE_NAME_STORE, null);
        if (string != null) {
            String[] split = TextUtils.split(string, ",");
            int length = split.length;
            while (i < length) {
                String str = split[i];
                String string2 = this.cookiePrefs.getString(COOKIE_NAME_PREFIX + str, null);
                if (string2 != null) {
                    Cookie decodeCookie = decodeCookie(string2);
                    if (decodeCookie != null) {
                        this.cookies.put(str, decodeCookie);
                    }
                }
                i++;
            }
            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie) {
        if (!this.omitNonPersistentCookies || cookie.isPersistent()) {
            String str = cookie.getName() + cookie.getDomain();
            if (cookie.isExpired(new Date())) {
                this.cookies.remove(str);
            } else {
                this.cookies.put(str, cookie);
            }
            Editor edit = this.cookiePrefs.edit();
            edit.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
            edit.putString(COOKIE_NAME_PREFIX + str, encodeCookie(new SerializableCookie(cookie)));
            edit.commit();
        }
    }

    public void clear() {
        Editor edit = this.cookiePrefs.edit();
        for (String str : this.cookies.keySet()) {
            edit.remove(COOKIE_NAME_PREFIX + str);
        }
        edit.remove(COOKIE_NAME_STORE);
        edit.commit();
        this.cookies.clear();
    }

    public boolean clearExpired(Date date) {
        Editor edit = this.cookiePrefs.edit();
        boolean z = false;
        for (Entry entry : this.cookies.entrySet()) {
            boolean z2;
            String str = (String) entry.getKey();
            if (((Cookie) entry.getValue()).isExpired(date)) {
                this.cookies.remove(str);
                edit.remove(COOKIE_NAME_PREFIX + str);
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z) {
            edit.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
        }
        edit.commit();
        return z;
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.cookies.values());
    }

    public void setOmitNonPersistentCookies(boolean omitNonPersistentCookies) {
        this.omitNonPersistentCookies = omitNonPersistentCookies;
    }

    public void deleteCookie(Cookie cookie) {
        String str = cookie.getName() + cookie.getDomain();
        this.cookies.remove(str);
        Editor edit = this.cookiePrefs.edit();
        edit.remove(COOKIE_NAME_PREFIX + str);
        edit.commit();
    }

    protected String encodeCookie(SerializableCookie cookie) {
        if (cookie == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(cookie);
            return byteArrayToHexString(byteArrayOutputStream.toByteArray());
        } catch (Throwable e) {
            AsyncHttpClient.log.mo3895d(LOG_TAG, "IOException in encodeCookie", e);
            return null;
        }
    }

    protected Cookie decodeCookie(String cookieString) {
        try {
            return ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(cookieString))).readObject()).getCookie();
        } catch (Throwable e) {
            AsyncHttpClient.log.mo3895d(LOG_TAG, "IOException in decodeCookie", e);
            return null;
        } catch (Throwable e2) {
            AsyncHttpClient.log.mo3895d(LOG_TAG, "ClassNotFoundException in decodeCookie", e2);
            return null;
        }
    }

    protected String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            int i = b & 255;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    protected byte[] hexStringToByteArray(String hexString) {
        int length = hexString.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i + 1), 16));
        }
        return bArr;
    }
}
