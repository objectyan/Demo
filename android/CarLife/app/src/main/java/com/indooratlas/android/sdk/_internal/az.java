package com.indooratlas.android.sdk._internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.BuildConfig;
import com.indooratlas.android.sdk.IAExtraInfo;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IALocationService;
import com.indooratlas.android.sdk.IAOrientationListener;
import com.indooratlas.android.sdk.IAOrientationRequest;
import com.indooratlas.android.sdk.IARegion;
import com.indooratlas.android.sdk.IARegion.Listener;
import com.indooratlas.android.sdk._internal.bo.C5778a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class az extends IALocationManager {
    /* renamed from: a */
    boolean f23051a = false;
    /* renamed from: b */
    C5778a f23052b;
    /* renamed from: c */
    Messenger f23053c;
    /* renamed from: d */
    Context f23054d;
    /* renamed from: e */
    C5780c f23055e;
    /* renamed from: f */
    IALocation f23056f;
    /* renamed from: g */
    IARegion f23057g;
    /* renamed from: h */
    IARegion f23058h;
    /* renamed from: i */
    ax f23059i;
    /* renamed from: j */
    final ConcurrentHashMap<IALocationListener, C5784e> f23060j;
    /* renamed from: k */
    final ArrayList<C5785f> f23061k = new ArrayList();
    /* renamed from: l */
    final HashMap<Object, C5782d> f23062l;
    /* renamed from: m */
    private Bundle f23063m;
    /* renamed from: n */
    private String f23064n;
    /* renamed from: o */
    private String f23065o;
    /* renamed from: p */
    private bp f23066p;
    /* renamed from: q */
    private final HashMap<IAOrientationListener, IAOrientationRequest> f23067q = new HashMap();
    /* renamed from: r */
    private final cr f23068r;

    /* renamed from: com.indooratlas.android.sdk._internal.az$a */
    public static class C5777a {
        /* renamed from: a */
        final Context f23030a;
        /* renamed from: b */
        public Bundle f23031b;
        /* renamed from: c */
        cr f23032c = bk.m20104b();

        public C5777a(Context context) {
            bk bkVar = new bk();
            this.f23030a = context;
        }

        /* renamed from: a */
        public final az m19895a() {
            return new az(this);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.az$b */
    class C5779b extends C5778a {
        /* renamed from: a */
        static final /* synthetic */ boolean f23035a = (!az.class.desiredAssertionStatus());
        /* renamed from: b */
        final /* synthetic */ az f23036b;

        C5779b(az azVar) {
            this.f23036b = azVar;
        }

        /* renamed from: a */
        protected final void mo4603a(IALocation iALocation) {
            az azVar = this.f23036b;
            azVar.f23056f = iALocation;
            IARegion region = iALocation.getRegion();
            if (region == null) {
                azVar.f23057g = null;
                azVar.f23058h = null;
            } else if (region.getType() == 2) {
                azVar.f23057g = region;
                azVar.f23058h = null;
            } else if (region.getType() == 1) {
                azVar.f23058h = region;
            }
            Iterator it = azVar.f23061k.iterator();
            while (it.hasNext()) {
                C5785f c5785f = (C5785f) it.next();
                if (azVar.f23057g == null) {
                    if (c5785f.f23048b != null) {
                        c5785f.f23047a.onExitRegion(c5785f.f23048b);
                    }
                    c5785f.f23048b = null;
                } else {
                    c5785f.m19914a(azVar.f23057g);
                }
                if (azVar.f23058h == null) {
                    if (c5785f.f23049c != null) {
                        c5785f.f23047a.onExitRegion(c5785f.f23049c);
                    }
                    c5785f.f23049c = null;
                } else {
                    c5785f.m19914a(azVar.f23058h);
                }
            }
            if (!azVar.f23060j.isEmpty()) {
                new Object[1][0] = Integer.valueOf(azVar.f23060j.size());
                for (Entry value : azVar.f23060j.entrySet()) {
                    ((C5784e) value.getValue()).m19913a(iALocation);
                }
            }
        }

        /* renamed from: a */
        protected final void mo4605a(bp bpVar) {
            this.f23036b.f23066p = bpVar;
            az.m19924a(this.f23036b, bpVar.f23221b, bpVar.f23222c);
        }

        /* renamed from: a */
        protected final void mo4602a(Bundle bundle) {
            if (f23035a || bundle != null) {
                this.f23036b.f23064n = bundle.getString("idaKey");
                this.f23036b.f23065o = bundle.getString("setupId");
                return;
            }
            throw new AssertionError("argument to onSdkInitialized cannot be null");
        }

        /* renamed from: b */
        protected final void mo4606b(Bundle bundle) {
            if (bundle.containsKey("lastKnownLocation")) {
                this.f23036b.f23056f = (IALocation) bundle.getParcelable("lastKnownLocation");
            }
            if (bundle.containsKey("currentVenue")) {
                this.f23036b.f23057g = (IARegion) bundle.getParcelable("currentVenue");
            }
            if (bundle.containsKey("currentFloorPlan")) {
                this.f23036b.f23058h = (IARegion) bundle.getParcelable("currentFloorPlan");
            }
            if (bundle.containsKey("lastGeofenceEvent")) {
                this.f23036b.f23059i = (ax) bundle.getParcelable("lastGeofenceEvent");
            }
        }

        /* renamed from: c */
        protected final void mo4585c(Message message) {
            Object[] objArr;
            switch (message.what) {
                case 102:
                    Bundle bundle = new Bundle(1);
                    bundle.putInt("quality", message.arg1);
                    az.m19924a(this.f23036b, 11, bundle);
                    return;
                case 104:
                    objArr = (Object[]) message.obj;
                    this.f23036b.m19930a(((Long) objArr[0]).longValue(), ((Double) objArr[1]).doubleValue());
                    return;
                case 105:
                    objArr = (Object[]) message.obj;
                    this.f23036b.m19931a(((Long) objArr[0]).longValue(), (double[]) objArr[1]);
                    return;
                default:
                    az azVar = this.f23036b;
                    Object[] objArr2 = new Object[]{message, azVar};
                    return;
            }
        }

        /* renamed from: a */
        protected final void mo4604a(ax axVar) {
            az azVar = this.f23036b;
            azVar.f23059i = axVar;
            if (!azVar.f23062l.isEmpty()) {
                new Object[1][0] = Integer.valueOf(azVar.f23062l.size());
                for (Entry value : azVar.f23062l.entrySet()) {
                    C5782d c5782d = (C5782d) value.getValue();
                    c5782d.f23040a.post(new C57811(c5782d, axVar));
                }
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.az$c */
    class C5780c implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ az f23037a;

        C5780c(az azVar) {
            this.f23037a = azVar;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder service) {
            this.f23037a.f23053c = az.m19917a(service);
            try {
                this.f23037a.f23052b.m19898a(this.f23037a.f23053c, this.f23037a.f23063m);
            } catch (RemoteException e) {
            }
            if (this.f23037a.f23051a) {
                this.f23037a.f23054d.unbindService(this.f23037a.f23055e);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f23037a.f23055e = null;
            this.f23037a.f23053c = null;
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.az$d */
    class C5782d {
        /* renamed from: a */
        Handler f23040a;

        /* renamed from: com.indooratlas.android.sdk._internal.az$d$1 */
        class C57811 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ ax f23038a;
            /* renamed from: b */
            final /* synthetic */ C5782d f23039b;

            C57811(C5782d c5782d, ax axVar) {
                this.f23039b = c5782d;
                this.f23038a = axVar;
            }

            public final void run() {
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.az$e */
    class C5784e {
        /* renamed from: a */
        IALocationListener f23043a;
        /* renamed from: b */
        final /* synthetic */ az f23044b;
        /* renamed from: c */
        private IALocationRequest f23045c;
        /* renamed from: d */
        private Handler f23046d;

        C5784e(az azVar, IALocationRequest iALocationRequest, IALocationListener iALocationListener, Looper looper) {
            this.f23044b = azVar;
            this.f23045c = iALocationRequest;
            this.f23043a = iALocationListener;
            this.f23046d = looper != null ? new Handler(looper) : new Handler();
        }

        /* renamed from: a */
        final void m19913a(final IALocation iALocation) {
            this.f23046d.post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C5784e f23042b;

                public final void run() {
                    this.f23042b.f23043a.onLocationChanged(iALocation);
                }
            });
        }

        /* renamed from: a */
        final void m19912a(int i, Bundle bundle) {
            Object[] objArr = new Object[]{Integer.valueOf(i), bundle};
            this.f23043a.onStatusChanged("IndoorAtlas", i, bundle);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.az$f */
    class C5785f {
        @NonNull
        /* renamed from: a */
        final Listener f23047a;
        @Nullable
        /* renamed from: b */
        IARegion f23048b;
        @Nullable
        /* renamed from: c */
        IARegion f23049c;
        /* renamed from: d */
        final /* synthetic */ az f23050d;

        private C5785f(az azVar, @NonNull Listener listener) {
            this.f23050d = azVar;
            this.f23047a = listener;
        }

        /* renamed from: a */
        final void m19914a(IARegion iARegion) {
            if (iARegion == null) {
                return;
            }
            if (iARegion.getType() == 2) {
                if (!iARegion.equals(this.f23048b)) {
                    if (this.f23048b != null) {
                        this.f23047a.onExitRegion(this.f23048b);
                    }
                    this.f23047a.onEnterRegion(iARegion);
                }
                this.f23048b = iARegion;
            } else if (iARegion.getType() == 1) {
                if (!iARegion.equals(this.f23049c)) {
                    if (this.f23049c != null) {
                        this.f23047a.onExitRegion(this.f23049c);
                    }
                    this.f23047a.onEnterRegion(iARegion);
                }
                this.f23049c = iARegion;
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof C5785f) {
                if (((C5785f) obj).f23047a == this.f23047a) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Listener)) {
                return false;
            } else {
                if (obj != this.f23047a) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            return this.f23047a.hashCode();
        }
    }

    public boolean requestLocationUpdates(@android.support.annotation.NonNull com.indooratlas.android.sdk.IALocationRequest r9, @android.support.annotation.NonNull com.indooratlas.android.sdk.IALocationListener r10, @android.support.annotation.Nullable android.os.Looper r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.fixSplitterBlock(BlockFinish.java:63)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:34)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r8 = this;
        r1 = 1;
        r2 = 0;
        r3 = new java.lang.Object[r1];
        r3[r2] = r10;
        r8.m19923a();
        r3 = "request must be non null";
        r4 = new java.lang.Object[r2];
        com.indooratlas.android.sdk._internal.eg.m20413a(r9, r3, r4);
        r3 = "listener must be non null";
        r4 = new java.lang.Object[r2];
        com.indooratlas.android.sdk._internal.eg.m20413a(r10, r3, r4);
        m19929d();
        r3 = r8.f23060j;
        monitor-enter(r3);
        r4 = r8.f23060j;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r4 = r4.containsKey(r10);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        if (r4 == 0) goto L_0x002f;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
    L_0x0027:
        r2 = 1;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r2 = new java.lang.Object[r2];	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r4 = 0;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r2[r4] = r10;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        monitor-exit(r3);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
    L_0x002e:
        return r1;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
    L_0x002f:
        r4 = new com.indooratlas.android.sdk._internal.az$e;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r4.<init>(r8, r9, r10, r11);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r5 = r8.f23060j;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r5.put(r10, r4);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        monitor-exit(r3);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r3 = r8.m19928c();	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        if (r3 != 0) goto L_0x0047;
    L_0x0040:
        r1 = r2;
        goto L_0x002e;
    L_0x0042:
        r1 = move-exception;
        r0 = r9;
        r9 = r1;
    L_0x0045:
        monitor-exit(r3);	 Catch:{ all -> 0x0077 }
        throw r9;
    L_0x0047:
        r3 = r8.f23052b;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r5 = 3;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r5 = r3.m19701a(r5);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r6 = r5.getData();	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r7 = "request";	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r6.putParcelable(r7, r9);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r3.m19897a(r5);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r3 = r8.f23066p;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        if (r3 == 0) goto L_0x006a;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
    L_0x005f:
        r3 = r8.f23066p;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r3 = r3.f23221b;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r5 = r8.f23066p;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r5 = r5.f23222c;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r4.m19912a(r3, r5);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
    L_0x006a:
        r3 = r8.f23056f;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        if (r3 == 0) goto L_0x002e;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
    L_0x006e:
        r3 = r8.f23056f;	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        r4.m19913a(r3);	 Catch:{ RemoteException -> 0x0074, all -> 0x0042 }
        goto L_0x002e;
    L_0x0074:
        r1 = move-exception;
        r1 = r2;
        goto L_0x002e;
    L_0x0077:
        r1 = move-exception;
        r0 = r9;
        r9 = r1;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.indooratlas.android.sdk._internal.az.requestLocationUpdates(com.indooratlas.android.sdk.IALocationRequest, com.indooratlas.android.sdk.IALocationListener, android.os.Looper):boolean");
    }

    az(@NonNull C5777a c5777a) {
        m19929d();
        this.f23052b = new C5779b(this);
        this.f23054d = (Context) eg.m20413a(c5777a.f23030a, "context must be non null", new Object[0]);
        this.f23060j = new ConcurrentHashMap();
        this.f23063m = c5777a.f23031b;
        this.f23068r = c5777a.f23032c;
        this.f23062l = new HashMap();
        m19928c();
    }

    public void destroy() {
        if (!this.f23051a) {
            this.f23051a = true;
            if (this.f23055e != null) {
                try {
                    if (this.f23053c != null) {
                        C5778a c5778a = this.f23052b;
                        this.f23053c.send(c5778a.m19701a(2));
                        c5778a.m19904c();
                        this.f23054d.unbindService(this.f23055e);
                    }
                } catch (RemoteException e) {
                }
            }
            this.f23060j.clear();
        }
    }

    public boolean requestLocationUpdates(IALocationRequest request, IALocationListener listener) {
        return requestLocationUpdates(request, listener, null);
    }

    public void requestLocationUpdates(@NonNull IALocationRequest request, @NonNull PendingIntent pendingIntent) {
        new Object[1][0] = pendingIntent;
        m19923a();
        eg.m20413a((Object) request, "request must be non null", new Object[0]);
        eg.m20413a((Object) pendingIntent, "pendingIntent must be non null", new Object[0]);
        m19929d();
        try {
            if (m19928c()) {
                C5778a c5778a = this.f23052b;
                Message a = c5778a.m19701a(7);
                a.getData().putParcelable("request", request);
                a.getData().putParcelable("pendingIntent", pendingIntent);
                c5778a.m19897a(a);
            }
        } catch (RemoteException e) {
        }
    }

    public boolean removeLocationUpdates(@NonNull IALocationListener listener) {
        new Object[1][0] = listener;
        m19923a();
        eg.m20413a((Object) listener, "listener must be non null", new Object[0]);
        m19929d();
        synchronized (this.f23060j) {
            if (((C5784e) this.f23060j.remove(listener)) == null) {
                return false;
            }
            if (this.f23060j.isEmpty()) {
                try {
                    C5778a c5778a = this.f23052b;
                    c5778a.m19897a(c5778a.m19701a(4));
                } catch (RemoteException e) {
                }
                Iterator it = this.f23061k.iterator();
                while (it.hasNext()) {
                    C5785f c5785f = (C5785f) it.next();
                    c5785f.f23048b = null;
                    c5785f.f23049c = null;
                }
                this.f23056f = null;
                this.f23057g = null;
                this.f23058h = null;
                this.f23059i = null;
            }
            Object[] objArr = new Object[]{r0, Integer.valueOf(this.f23060j.size())};
            return true;
        }
    }

    public void removeLocationUpdates(@NonNull PendingIntent pendingIntent) {
        new Object[1][0] = pendingIntent;
        m19923a();
        eg.m20413a((Object) pendingIntent, "pendingIntent must be non null", new Object[0]);
        m19929d();
        try {
            C5778a c5778a = this.f23052b;
            Message a = c5778a.m19701a(8);
            a.getData().putParcelable("pendingIntent", pendingIntent);
            c5778a.m19897a(a);
        } catch (RemoteException e) {
        }
    }

    public void setLocation(@NonNull IALocation location) {
        m19923a();
        eg.m20413a((Object) location, "location must be non empty", new Object[0]);
        m19929d();
        try {
            C5778a c5778a = this.f23052b;
            Location toLocation = location.toLocation();
            IARegion region = location.getRegion();
            if (!"com.indooratlas.android.sdk.intent.extras.groundTruth".equals(toLocation.getProvider())) {
                toLocation.setProvider("com.indooratlas.android.sdk.intent.extras.userInput");
            }
            Parcelable build = new Builder().withLocation(toLocation).withRegion(region).build();
            Message a = c5778a.m19701a(5);
            a.getData().putParcelable("location", build);
            c5778a.m19897a(a);
        } catch (RemoteException e) {
            ee.m20409a("IASDK", "service died, location not sent", new Object[0]);
        }
    }

    public boolean registerRegionListener(Listener listener) {
        m19923a();
        eg.m20413a((Object) listener, "listener must be non null", new Object[0]);
        m19929d();
        C5785f c5785f = new C5785f(listener);
        if (this.f23061k.contains(c5785f)) {
            return false;
        }
        this.f23061k.add(c5785f);
        if (this.f23057g != null) {
            c5785f.m19914a(this.f23057g);
        }
        if (this.f23058h != null) {
            c5785f.m19914a(this.f23058h);
        }
        return true;
    }

    public boolean unregisterRegionListener(Listener listener) {
        m19923a();
        eg.m20413a((Object) listener, "listener must be non null", new Object[0]);
        m19929d();
        Iterator it = this.f23061k.iterator();
        while (it.hasNext()) {
            C5785f c5785f = (C5785f) it.next();
            if (c5785f.f23047a == listener) {
                this.f23061k.remove(c5785f);
                return true;
            }
        }
        return false;
    }

    public boolean registerOrientationListener(@NonNull IAOrientationRequest request, @NonNull IAOrientationListener listener) {
        boolean z = false;
        m19923a();
        eg.m20413a((Object) request, "request must be non null", new Object[0]);
        eg.m20413a((Object) listener, "listener must be non null", new Object[0]);
        m19929d();
        if (!this.f23067q.containsKey(listener)) {
            z = true;
        }
        this.f23067q.put(listener, request);
        try {
            this.f23052b.m19900a(m19925b());
        } catch (RemoteException e) {
        }
        return z;
    }

    public boolean unregisterOrientationListener(@NonNull IAOrientationListener listener) {
        m19923a();
        eg.m20413a((Object) listener, "listener must be non null", new Object[0]);
        m19929d();
        if (!this.f23067q.containsKey(listener)) {
            return false;
        }
        this.f23067q.remove(listener);
        try {
            this.f23052b.m19900a(m19925b());
        } catch (RemoteException e) {
        }
        return true;
    }

    @NonNull
    public IAExtraInfo getExtraInfo() {
        m19923a();
        String str = BuildConfig.VERSION_NAME;
        String str2 = null;
        if (this.f23065o != null) {
            str2 = this.f23065o + "." + this.f23068r.mo4655b() + "." + this.f23068r.mo4654a();
        }
        return new IAExtraInfo(str, str2);
    }

    /* renamed from: a */
    private void m19923a() {
        if (this.f23051a) {
            throw new IllegalStateException("using destroyed IALocationManager");
        }
    }

    /* renamed from: b */
    private IAOrientationRequest m19925b() {
        double d = -1.0d;
        double d2 = -1.0d;
        for (IAOrientationRequest iAOrientationRequest : this.f23067q.values()) {
            d2 = m19915a(d2, iAOrientationRequest.getHeadingSensitivity());
            d = m19915a(d, iAOrientationRequest.getOrientationSensitivity());
        }
        return new IAOrientationRequest(d2, d);
    }

    /* renamed from: a */
    private static double m19915a(double d, double d2) {
        return (d2 < 0.0d || (d >= 0.0d && d2 >= d)) ? d : d2;
    }

    /* renamed from: c */
    private boolean m19928c() {
        if (this.f23055e != null) {
            return true;
        }
        this.f23055e = new C5780c(this);
        Intent intent = new Intent(this.f23054d, IALocationService.class);
        this.f23054d.startService(intent);
        if (this.f23054d.bindService(intent, this.f23055e, 1)) {
            return true;
        }
        ee.m20409a("IASDK", "failed to connect with location service. make sure you have declared service in your manifest.", new Object[0]);
        this.f23055e = null;
        this.f23052b.m19904c();
        return false;
    }

    /* renamed from: d */
    private static void m19929d() {
        String str = IALocationManager.class.getSimpleName() + " must be called from main thread, %s <> %s";
        if (Looper.getMainLooper() != Looper.myLooper() && !Looper.myLooper().getThread().getName().contains("Instr: android.test.InstrumentationTestRunner")) {
            throw new RuntimeException(ei.m20417a(str, Looper.myLooper(), Looper.getMainLooper()));
        }
    }

    /* renamed from: a */
    protected static Messenger m19917a(IBinder iBinder) {
        return new Messenger(iBinder);
    }

    /* renamed from: a */
    final void m19930a(long j, double d) {
        for (Entry entry : this.f23067q.entrySet()) {
            if (((IAOrientationRequest) entry.getValue()).getHeadingSensitivity() >= 0.0d) {
                ((IAOrientationListener) entry.getKey()).onHeadingChanged(j, d);
            }
        }
    }

    /* renamed from: a */
    final void m19931a(long j, double[] dArr) {
        for (Entry entry : this.f23067q.entrySet()) {
            if (((IAOrientationRequest) entry.getValue()).getOrientationSensitivity() >= 0.0d) {
                ((IAOrientationListener) entry.getKey()).onOrientationChange(j, dArr);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19924a(az azVar, int i, Bundle bundle) {
        if (!azVar.f23060j.isEmpty()) {
            for (C5784e a : azVar.f23060j.values()) {
                a.m19912a(i, bundle);
            }
        }
    }
}
