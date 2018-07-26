package com.baidu.location.p193e;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.C3377f;
import com.baidu.location.p188h.C3380a;
import com.baidu.location.p188h.C3381b;
import com.baidu.location.p191d.C3301g;
import com.baidu.location.p193e.C3351e.C3350a;
import com.baidu.location.p194f.C3362a;
import com.baidu.location.p194f.C3372e;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.baidu.location.e.d */
public final class C3349d {
    /* renamed from: a */
    public static final String f18150a = C3380a.f18302a;
    /* renamed from: b */
    static final String f18151b = "http://ofloc.map.baidu.com/offline_loc";
    /* renamed from: c */
    static final String f18152c = "com.baidu.lbs.offlinelocationprovider";
    /* renamed from: d */
    private static Context f18153d;
    /* renamed from: e */
    private static volatile C3349d f18154e;
    /* renamed from: f */
    private final File f18155f;
    /* renamed from: g */
    private final C3353f f18156g;
    /* renamed from: h */
    private final C3341b f18157h;
    /* renamed from: i */
    private final C3361g f18158i;
    /* renamed from: j */
    private final C3344c f18159j;

    /* renamed from: com.baidu.location.e.d$a */
    public enum C3346a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    /* renamed from: com.baidu.location.e.d$b */
    public enum C3347b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    /* renamed from: com.baidu.location.e.d$c */
    private enum C3348c {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    private C3349d() {
        File file;
        try {
            file = new File(f18153d.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            file = null;
        }
        this.f18155f = file;
        this.f18157h = new C3341b(this);
        this.f18156g = new C3353f(this.f18157h.m14097a());
        this.f18159j = new C3344c(this, this.f18157h.m14097a());
        this.f18158i = new C3361g(this, this.f18157h.m14097a(), this.f18159j.m14165o());
    }

    /* renamed from: a */
    public static C3349d m14171a() {
        if (f18154e == null) {
            synchronized (C3349d.class) {
                if (f18154e == null) {
                    if (f18153d == null) {
                        C3349d.m14172a(C3377f.getServiceContext());
                    }
                    f18154e = new C3349d();
                }
            }
        }
        f18154e.m14178r();
        return f18154e;
    }

    /* renamed from: a */
    public static void m14172a(Context context) {
        if (f18153d == null) {
            f18153d = context;
            C3381b.m14398a().m14401a(f18153d);
        }
    }

    /* renamed from: b */
    private BDLocation m14173b(final String[] strArr) {
        BDLocation bDLocation = new BDLocation();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        bDLocation = (FutureTask) newSingleThreadExecutor.submit(new Callable<BDLocation>(this) {
            /* renamed from: b */
            final /* synthetic */ C3349d f18137b;

            /* renamed from: a */
            public BDLocation m14169a() {
                BDLocation a;
                Cursor cursor;
                Throwable th;
                Cursor cursor2 = null;
                BDLocation bDLocation = new BDLocation();
                if (strArr.length > 0) {
                    ProviderInfo resolveContentProvider;
                    try {
                        resolveContentProvider = C3349d.f18153d.getPackageManager().resolveContentProvider(C3349d.f18152c, 0);
                    } catch (Exception e) {
                        resolveContentProvider = null;
                    }
                    if (resolveContentProvider == null) {
                        String[] p = this.f18137b.f18159j.m14166p();
                        for (String resolveContentProvider2 : p) {
                            try {
                                resolveContentProvider = C3349d.f18153d.getPackageManager().resolveContentProvider(resolveContentProvider2, 0);
                            } catch (Exception e2) {
                                resolveContentProvider = null;
                            }
                            if (resolveContentProvider != null) {
                                break;
                            }
                        }
                    }
                    if (resolveContentProvider != null) {
                        try {
                            Cursor query = C3349d.f18153d.getContentResolver().query(C3349d.m14176d(resolveContentProvider.authority), strArr, null, null, null);
                            try {
                                a = C3351e.m14200a(query);
                                if (query != null) {
                                    try {
                                        query.close();
                                    } catch (Exception e3) {
                                    }
                                }
                            } catch (Exception e4) {
                                cursor = query;
                                if (cursor == null) {
                                    try {
                                        cursor.close();
                                        a = bDLocation;
                                    } catch (Exception e5) {
                                        a = bDLocation;
                                    }
                                } else {
                                    a = bDLocation;
                                }
                                bDLocation = a;
                                bDLocation.setLocType(66);
                                return bDLocation;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = query;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e6) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e7) {
                            cursor = null;
                            if (cursor == null) {
                                a = bDLocation;
                            } else {
                                cursor.close();
                                a = bDLocation;
                            }
                            bDLocation = a;
                            bDLocation.setLocType(66);
                            return bDLocation;
                        } catch (Throwable th3) {
                            th = th3;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                        bDLocation = a;
                    } else {
                        try {
                            cursor2 = this.f18137b.f18157h.m14096a(new C3350a(strArr));
                            bDLocation = C3351e.m14200a(cursor2);
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e8) {
                                }
                            }
                        } catch (Exception e9) {
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e10) {
                                }
                            }
                        } catch (Throwable th4) {
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e11) {
                                }
                            }
                        }
                    }
                    if (!(bDLocation == null || bDLocation.getLocType() == 67)) {
                        bDLocation.setLocType(66);
                    }
                }
                return bDLocation;
            }

            public /* synthetic */ Object call() throws Exception {
                return m14169a();
            }
        });
        try {
            bDLocation = (BDLocation) bDLocation.get(2000, TimeUnit.MILLISECONDS);
            return bDLocation;
        } catch (InterruptedException e) {
            bDLocation.cancel(true);
            return null;
        } catch (ExecutionException e2) {
            bDLocation.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            C3301g.m13879a().m13885a("offlineLocation Timeout Exception!");
            bDLocation.cancel(true);
            return null;
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    /* renamed from: d */
    private static final Uri m14176d(String str) {
        return Uri.parse(String.format("content://%s/", new Object[]{str}));
    }

    /* renamed from: r */
    private void m14178r() {
        this.f18159j.m14157g();
    }

    /* renamed from: s */
    private boolean m14179s() {
        ProviderInfo resolveContentProvider;
        ProviderInfo providerInfo;
        String packageName = f18153d.getPackageName();
        try {
            resolveContentProvider = f18153d.getPackageManager().resolveContentProvider(f18152c, 0);
        } catch (Exception e) {
            resolveContentProvider = null;
        }
        if (resolveContentProvider == null) {
            String[] p = this.f18159j.m14166p();
            providerInfo = resolveContentProvider;
            for (String resolveContentProvider2 : p) {
                try {
                    providerInfo = f18153d.getPackageManager().resolveContentProvider(resolveContentProvider2, 0);
                } catch (Exception e2) {
                    providerInfo = null;
                }
                if (providerInfo != null) {
                    break;
                }
            }
        } else {
            providerInfo = resolveContentProvider;
        }
        return providerInfo == null ? true : packageName.equals(providerInfo.packageName);
    }

    /* renamed from: a */
    public long m14180a(String str) {
        return this.f18159j.m14149a(str);
    }

    /* renamed from: a */
    public Cursor m14181a(String[] strArr) {
        return this.f18157h.m14096a(new C3350a(strArr));
    }

    /* renamed from: a */
    public BDLocation m14182a(C3362a c3362a, C3372e c3372e, BDLocation bDLocation, C3347b c3347b, C3346a c3346a) {
        int a;
        String str;
        if (c3347b == C3347b.IS_MIX_MODE) {
            a = this.f18159j.m14148a();
            str = C3381b.m14398a().m14408g() + "&mixMode=1";
        } else {
            str = C3381b.m14398a().m14408g();
            a = 0;
        }
        String[] a2 = C3351e.m14203a(c3362a, c3372e, bDLocation, str, (c3346a == C3346a.NEED_TO_LOG ? Boolean.valueOf(true) : Boolean.valueOf(false)).booleanValue(), a);
        BDLocation bDLocation2 = null;
        if (a2.length > 0) {
            bDLocation2 = m14173b(a2);
            if (bDLocation2 == null || bDLocation2.getLocType() != 67) {
                return bDLocation2;
            }
        }
        return bDLocation2;
    }

    /* renamed from: b */
    public Context m14183b() {
        return f18153d;
    }

    /* renamed from: b */
    public boolean m14184b(String str) {
        return this.f18159j.m14152b(str);
    }

    /* renamed from: c */
    File m14185c() {
        return this.f18155f;
    }

    /* renamed from: d */
    public boolean m14186d() {
        return this.f18159j.m14158h();
    }

    /* renamed from: e */
    public boolean m14187e() {
        return this.f18159j.m14159i();
    }

    /* renamed from: f */
    public boolean m14188f() {
        return this.f18159j.m14160j();
    }

    /* renamed from: g */
    public boolean m14189g() {
        return this.f18159j.m14161k();
    }

    /* renamed from: h */
    public boolean m14190h() {
        return this.f18159j.m14162l();
    }

    /* renamed from: i */
    public boolean m14191i() {
        return this.f18159j.m14164n();
    }

    /* renamed from: j */
    public void m14192j() {
        this.f18156g.m14212a();
    }

    /* renamed from: k */
    C3353f m14193k() {
        return this.f18156g;
    }

    /* renamed from: l */
    C3361g m14194l() {
        return this.f18158i;
    }

    /* renamed from: m */
    C3344c m14195m() {
        return this.f18159j;
    }

    /* renamed from: n */
    public void m14196n() {
        if (m14179s()) {
            this.f18157h.m14098b();
        }
    }

    /* renamed from: o */
    public void m14197o() {
    }

    /* renamed from: p */
    public double m14198p() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) f18153d.getSystemService("connectivity")).getActiveNetworkInfo();
        C3348c c3348c = C3348c.NETWORK_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                c3348c = C3348c.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    c3348c = C3348c.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    c3348c = C3348c.NETWORK_3G;
                } else if (subtype == 13) {
                    c3348c = C3348c.NETWORK_4G;
                }
            }
        }
        return c3348c == C3348c.NETWORK_UNKNOWN ? this.f18159j.m14151b() : c3348c == C3348c.NETWORK_WIFI ? this.f18159j.m14153c() : c3348c == C3348c.NETWORK_2G ? this.f18159j.m14154d() : c3348c == C3348c.NETWORK_3G ? this.f18159j.m14155e() : c3348c == C3348c.NETWORK_4G ? this.f18159j.m14156f() : 0.0d;
    }
}
