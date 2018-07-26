package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import cz.msebera.android.httpclient.p158b.C6045h;
import cz.msebera.android.httpclient.p164f.C6329b;
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

public class PersistentCookieStore implements C6045h {
    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String LOG_TAG = "PersistentCookieStore";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap<String, C6329b> cookies;
    private boolean omitNonPersistentCookies = false;

    public PersistentCookieStore(Context context) {
        int i = 0;
        this.cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        this.cookies = new ConcurrentHashMap();
        String storedCookieNames = this.cookiePrefs.getString(COOKIE_NAME_STORE, null);
        if (storedCookieNames != null) {
            String[] cookieNames = TextUtils.split(storedCookieNames, ",");
            int length = cookieNames.length;
            while (i < length) {
                String name = cookieNames[i];
                String encodedCookie = this.cookiePrefs.getString(COOKIE_NAME_PREFIX + name, null);
                if (encodedCookie != null) {
                    C6329b decodedCookie = decodeCookie(encodedCookie);
                    if (decodedCookie != null) {
                        this.cookies.put(name, decodedCookie);
                    }
                }
                i++;
            }
            clearExpired(new Date());
        }
    }

    public void addCookie(C6329b cookie) {
        if (!this.omitNonPersistentCookies || cookie.mo5205f()) {
            String name = cookie.mo5190a() + cookie.mo5206g();
            if (cookie.mo5194a(new Date())) {
                this.cookies.remove(name);
            } else {
                this.cookies.put(name, cookie);
            }
            Editor prefsWriter = this.cookiePrefs.edit();
            prefsWriter.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
            prefsWriter.putString(COOKIE_NAME_PREFIX + name, encodeCookie(new SerializableCookie(cookie)));
            prefsWriter.commit();
        }
    }

    public void clear() {
        Editor prefsWriter = this.cookiePrefs.edit();
        for (String name : this.cookies.keySet()) {
            prefsWriter.remove(COOKIE_NAME_PREFIX + name);
        }
        prefsWriter.remove(COOKIE_NAME_STORE);
        prefsWriter.commit();
        this.cookies.clear();
    }

    public boolean clearExpired(Date date) {
        boolean clearedAny = false;
        Editor prefsWriter = this.cookiePrefs.edit();
        for (Entry<String, C6329b> entry : this.cookies.entrySet()) {
            String name = (String) entry.getKey();
            if (((C6329b) entry.getValue()).mo5194a(date)) {
                this.cookies.remove(name);
                prefsWriter.remove(COOKIE_NAME_PREFIX + name);
                clearedAny = true;
            }
        }
        if (clearedAny) {
            prefsWriter.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
        }
        prefsWriter.commit();
        return clearedAny;
    }

    public List<C6329b> getCookies() {
        return new ArrayList(this.cookies.values());
    }

    public void setOmitNonPersistentCookies(boolean omitNonPersistentCookies) {
        this.omitNonPersistentCookies = omitNonPersistentCookies;
    }

    public void deleteCookie(C6329b cookie) {
        String name = cookie.mo5190a() + cookie.mo5206g();
        this.cookies.remove(name);
        Editor prefsWriter = this.cookiePrefs.edit();
        prefsWriter.remove(COOKIE_NAME_PREFIX + name);
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
            AsyncHttpClient.log.mo4879d(LOG_TAG, "IOException in encodeCookie", e);
            return null;
        }
    }

    protected C6329b decodeCookie(String cookieString) {
        C6329b cookie = null;
        try {
            cookie = ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(cookieString))).readObject()).getCookie();
        } catch (IOException e) {
            AsyncHttpClient.log.mo4879d(LOG_TAG, "IOException in decodeCookie", e);
        } catch (ClassNotFoundException e2) {
            AsyncHttpClient.log.mo4879d(LOG_TAG, "ClassNotFoundException in decodeCookie", e2);
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
