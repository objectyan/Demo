package com.baidu.sapi2;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.JsonHttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.C4894c.C4893a;
import com.baidu.sapi2.C4894c.C4893a.C4892a;
import com.baidu.sapi2.utils.C4913L;
import com.baidu.sapi2.utils.C4920d;
import com.baidu.sapi2.utils.C4923f;
import com.baidu.sapi2.utils.SapiUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class SapiCache {
    /* renamed from: a */
    private static final Map<String, SoftReference<String>> f20034a = new ConcurrentHashMap();
    /* renamed from: b */
    private static final List<String> f20035b = new ArrayList();
    /* renamed from: c */
    private static final List<String> f20036c = new ArrayList();
    /* renamed from: d */
    private static Context f20037d;

    /* renamed from: com.baidu.sapi2.SapiCache$a */
    interface C4846a {
        /* renamed from: a */
        void mo3729a(C4892a c4892a);

        /* renamed from: a */
        void mo3730a(C4892a c4892a, String str);
    }

    /* renamed from: com.baidu.sapi2.SapiCache$2 */
    static class C48482 implements C4846a {
        C48482() {
        }

        /* renamed from: a */
        public void mo3730a(C4892a m, String data) {
            SapiCache.m16082a(m.f20424a, data);
        }

        /* renamed from: a */
        public void mo3729a(C4892a m) {
            SapiCache.m16078a(SapiCache.f20037d, m);
        }
    }

    private SapiCache() {
    }

    /* renamed from: a */
    static void m16082a(String key, String value) {
        f20034a.put(key, new SoftReference(value));
    }

    /* renamed from: a */
    static void m16081a(String key) {
        f20034a.remove(key);
    }

    /* renamed from: a */
    static String m16075a(Context context, String url) {
        return m16085b(context, m16090c(url));
    }

    /* renamed from: b */
    static String m16085b(final Context context, String moduleId) {
        m16095e();
        if (!C4891b.m16250a(context).m16288j().m16319f().m16307a()) {
            return null;
        }
        String data = m16086b(moduleId);
        if (!TextUtils.isEmpty(data)) {
            return data;
        }
        C4892a module = m16089c(context, moduleId);
        if (module == null) {
            return m16092d(context, moduleId);
        }
        m16080a(module, new C4846a() {
            /* renamed from: a */
            public void mo3730a(C4892a m, String data) {
                SapiCache.m16082a(m.f20424a, data);
            }

            /* renamed from: a */
            public void mo3729a(C4892a m) {
                SapiCache.m16078a(context, m);
            }
        });
        return m16086b(moduleId);
    }

    /* renamed from: b */
    static String m16086b(String moduleId) {
        if (f20034a.containsKey(moduleId) && f20034a.get(moduleId) != null) {
            String data = (String) ((SoftReference) f20034a.get(moduleId)).get();
            if (!TextUtils.isEmpty(data)) {
                return data;
            }
        }
        return null;
    }

    /* renamed from: c */
    static C4892a m16089c(Context context, String moduleId) {
        for (C4892a module : C4891b.m16250a(context).m16288j().m16319f().m16308b()) {
            if (module.f20424a.equals(moduleId)) {
                return module;
            }
        }
        return null;
    }

    public static void init(Context ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        f20037d = ctx.getApplicationContext();
        m16077a();
        m16087b();
    }

    /* renamed from: a */
    static void m16077a() {
        C4893a cacheOptions = C4891b.m16250a(f20037d).m16288j().m16319f();
        if (cacheOptions.m16307a()) {
            for (C4892a module : cacheOptions.m16308b()) {
                f20035b.add(module.f20424a);
            }
            f20036c.addAll(f20035b);
            for (C4892a module2 : cacheOptions.m16308b()) {
                m16080a(module2, new C48482());
            }
        }
    }

    /* renamed from: a */
    static void m16080a(C4892a module, C4846a listener) {
        if (listener == null) {
            throw new IllegalArgumentException(C4846a.class.getName() + "can't be null");
        }
        String externalFile = C4892a.m16304c(module.f20424a);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), externalFile).exists()) {
                String data = m16093d(externalFile);
                if (MD5Util.toMd5(data.getBytes(), false).equals(module.f20426c)) {
                    listener.mo3730a(module, data);
                    return;
                } else {
                    listener.mo3729a(module);
                    return;
                }
            }
            listener.mo3729a(module);
        } catch (Throwable th) {
            listener.mo3729a(module);
        }
    }

    /* renamed from: a */
    static void m16078a(Context context, C4892a module) {
        String internalFile = C4892a.m16302a(module.f20424a);
        if (new File(context.getFilesDir(), internalFile).exists()) {
            try {
                m16082a(module.f20424a, m16094e(context, internalFile));
                return;
            } catch (Throwable th) {
                m16092d(context, module.f20424a);
                return;
            }
        }
        m16092d(context, module.f20424a);
    }

    /* renamed from: d */
    static String m16092d(Context context, String moduleId) {
        try {
            m16082a(moduleId, m16097f(context, C4892a.m16303b(moduleId)));
            return m16085b(context, moduleId);
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: c */
    static String m16090c(String url) {
        Uri uri = Uri.parse(url);
        String cacheModuleId = uri.getHost() + (uri.getPort() == -1 ? "" : Config.TRACE_TODAY_VISIT_SPLIT + uri.getPort()) + uri.getPath();
        if (cacheModuleId.endsWith(".html")) {
            return cacheModuleId;
        }
        return cacheModuleId + ".html";
    }

    /* renamed from: b */
    static void m16087b() {
        if (SapiUtils.hasActiveNetwork(f20037d)) {
            try {
                RequestParams params = m16088c();
                String deviceInfo = C4920d.m16400b(C4923f.f20576A);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    params.put("di", deviceInfo);
                }
                params.put("cdnversion", String.valueOf((int) (System.currentTimeMillis() / 300000)));
                new AsyncHttpClient().get(f20037d, m16091d(), params, new JsonHttpResponseHandler(Looper.getMainLooper()) {

                    /* renamed from: com.baidu.sapi2.SapiCache$3$2 */
                    class C48512 implements C4846a {
                        /* renamed from: a */
                        final /* synthetic */ C48523 f20033a;

                        C48512(C48523 c48523) {
                            this.f20033a = c48523;
                        }

                        /* renamed from: a */
                        public void mo3730a(C4892a module, String data) {
                        }

                        /* renamed from: a */
                        public void mo3729a(C4892a module) {
                            String internalFile = C4892a.m16302a(module.f20424a);
                            String externalFile = C4892a.m16304c(module.f20424a);
                            if (new File(SapiCache.f20037d.getFilesDir(), internalFile).exists()) {
                                try {
                                    String data = SapiCache.m16094e(SapiCache.f20037d, internalFile);
                                    if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.f20037d)) {
                                        SapiCache.m16083a(externalFile, data.getBytes());
                                    }
                                } catch (Throwable e) {
                                    C4913L.m16374e(e);
                                }
                            }
                        }
                    }

                    public void onSuccess(JSONObject response) {
                        if (response != null) {
                            C4894c oldOptions = C4891b.m16250a(SapiCache.f20037d).m16288j();
                            final C4894c newOptions = C4894c.m16310a(response);
                            C4893a newCache = newOptions.m16319f();
                            C4891b.m16250a(SapiCache.f20037d).m16266a(newOptions);
                            SapiCache.f20036c.clear();
                            if (newCache.m16307a()) {
                                for (C4892a newModule : newCache.m16308b()) {
                                    SapiCache.f20036c.add(newModule.f20424a);
                                }
                                for (final C4892a newModule2 : newCache.m16308b()) {
                                    C4892a oldModule = null;
                                    for (C4892a m : oldOptions.m16319f().m16308b()) {
                                        if (m.f20424a.equals(newModule2.f20424a)) {
                                            oldModule = m;
                                        }
                                    }
                                    if (SapiCache.m16084a(newModule2, oldModule)) {
                                        SapiCache.m16080a(newModule2, new C4846a(this) {
                                            /* renamed from: c */
                                            final /* synthetic */ C48523 f20032c;

                                            /* renamed from: a */
                                            public void mo3730a(C4892a module, String data) {
                                                C4891b.m16250a(SapiCache.f20037d).m16266a(newOptions);
                                                if (!TextUtils.isEmpty(newModule2.f20424a) && !TextUtils.isEmpty(data)) {
                                                    SapiCache.m16082a(newModule2.f20424a, data);
                                                    SapiCache.m16079a(SapiCache.f20037d, C4892a.m16302a(newModule2.f20424a), data.getBytes());
                                                }
                                            }

                                            /* renamed from: a */
                                            public void mo3729a(C4892a module) {
                                                new AsyncHttpClient().get(SapiCache.f20037d, newModule2.f20425b, SapiCache.m16088c(), new HttpResponseHandler(this, Looper.getMainLooper()) {
                                                    /* renamed from: a */
                                                    final /* synthetic */ C48501 f20029a;

                                                    public void onSuccess(String content) {
                                                        if (!TextUtils.isEmpty(newModule2.f20424a) && !TextUtils.isEmpty(content) && newModule2.f20426c.equals(MD5Util.toMd5(content.getBytes(), false))) {
                                                            C4891b.m16250a(SapiCache.f20037d).m16266a(newOptions);
                                                            SapiCache.m16082a(newModule2.f20424a, content);
                                                            SapiCache.m16079a(SapiCache.f20037d, C4892a.m16302a(newModule2.f20424a), content.getBytes());
                                                            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.f20037d)) {
                                                                SapiCache.m16083a(C4892a.m16304c(newModule2.f20424a), content.getBytes());
                                                            }
                                                        }
                                                    }

                                                    public void onFailure(Throwable error, String content) {
                                                    }
                                                });
                                            }
                                        });
                                    } else {
                                        C4891b.m16250a(SapiCache.f20037d).m16266a(newOptions);
                                        SapiCache.m16080a(newModule2, new C48512(this));
                                    }
                                }
                            }
                        }
                    }
                });
            } catch (Throwable e) {
                C4913L.m16374e(e);
            }
        }
    }

    /* renamed from: c */
    static synchronized RequestParams m16088c() {
        RequestParams params;
        synchronized (SapiCache.class) {
            params = new RequestParams();
            params.put("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl);
            params.put("sdk_version", SapiAccountManager.VERSION_NAME);
            params.put("app_version", SapiUtils.getVersionName(f20037d));
        }
        return params;
    }

    /* renamed from: a */
    static boolean m16084a(C4892a newModule, C4892a oldModule) {
        return !TextUtils.isEmpty(newModule.f20426c) && (oldModule == null || !newModule.f20426c.equals(oldModule.f20426c));
    }

    /* renamed from: d */
    static String m16091d() {
        return SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + C4923f.f20576A;
    }

    /* renamed from: e */
    static void m16095e() {
        List<String> removedModuleIds = new ArrayList();
        for (String oldModuleId : f20035b) {
            if (!f20036c.contains(oldModuleId)) {
                removedModuleIds.add(oldModuleId);
                m16081a(oldModuleId);
            }
        }
        for (String moduleId : removedModuleIds) {
            if (f20035b.contains(moduleId)) {
                f20035b.remove(moduleId);
            }
        }
    }

    /* renamed from: a */
    static void m16079a(Context context, String fileName, byte[] data) {
        OutputStream outputStream = null;
        try {
            outputStream = context.openFileOutput(fileName, 0);
            outputStream.write(data);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    /* renamed from: a */
    static void m16083a(String fileName, byte[] data) {
        Throwable e;
        Throwable th;
        OutputStream outputStream = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File outputFile = new File(Environment.getExternalStorageDirectory(), fileName);
                if (!outputFile.getParentFile().exists()) {
                    outputFile.getParentFile().mkdirs();
                }
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }
                OutputStream outputStream2 = new FileOutputStream(outputFile);
                try {
                    outputStream2.write(data);
                    outputStream = outputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e2) {
                    C4913L.m16374e(e2);
                }
            }
        } catch (Throwable th3) {
            e2 = th3;
            C4913L.m16374e(e2);
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /* renamed from: d */
    static String m16093d(String fileName) throws IOException {
        return m16076a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), fileName)));
    }

    /* renamed from: e */
    static String m16094e(Context context, String fileName) throws IOException {
        return m16076a(context.openFileInput(fileName));
    }

    /* renamed from: f */
    static String m16097f(Context context, String fileName) throws IOException {
        return m16076a(context.getAssets().open(fileName));
    }

    /* renamed from: a */
    static String m16076a(InputStream inputStream) throws IOException {
        try {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String str = new String(buffer);
            return str;
        } finally {
            inputStream.close();
        }
    }
}
