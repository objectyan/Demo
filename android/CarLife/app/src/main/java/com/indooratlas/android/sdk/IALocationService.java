package com.indooratlas.android.sdk;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.indooratlas.android.sdk._internal.ax;
import com.indooratlas.android.sdk._internal.ay;
import com.indooratlas.android.sdk._internal.bf;
import com.indooratlas.android.sdk._internal.bf.C5790a;
import com.indooratlas.android.sdk._internal.bh;
import com.indooratlas.android.sdk._internal.bj;
import com.indooratlas.android.sdk._internal.bo;
import com.indooratlas.android.sdk._internal.bo.C5753c;
import com.indooratlas.android.sdk._internal.bp;
import com.indooratlas.android.sdk._internal.br;
import com.indooratlas.android.sdk._internal.cc;
import com.indooratlas.android.sdk._internal.dc;
import com.indooratlas.android.sdk._internal.ee;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class IALocationService extends Service {
    /* renamed from: a */
    final HashSet<PendingIntent> f22893a = new HashSet();
    /* renamed from: b */
    private bf f22894b;
    /* renamed from: c */
    private final HashMap<String, C5751a> f22895c = new HashMap();
    /* renamed from: d */
    private final HashSet<PendingIntent> f22896d = new HashSet();
    /* renamed from: e */
    private final C5753c f22897e = new C5754c(this);
    /* renamed from: f */
    private IALocation f22898f;
    /* renamed from: g */
    private IARegion f22899g;
    /* renamed from: h */
    private IARegion f22900h;
    /* renamed from: i */
    private ax f22901i;
    /* renamed from: j */
    private boolean f22902j = false;

    /* renamed from: com.indooratlas.android.sdk.IALocationService$a */
    class C5751a {
        /* renamed from: a */
        final String f22883a;
        /* renamed from: b */
        boolean f22884b;
        /* renamed from: c */
        final Messenger f22885c;
        /* renamed from: d */
        final DeathRecipient f22886d = new C5750a(this);
        /* renamed from: e */
        final /* synthetic */ IALocationService f22887e;

        /* renamed from: com.indooratlas.android.sdk.IALocationService$a$a */
        class C5750a implements DeathRecipient {
            /* renamed from: a */
            final /* synthetic */ C5751a f22882a;

            C5750a(C5751a c5751a) {
                this.f22882a = c5751a;
            }

            public final void binderDied() {
                this.f22882a.f22887e.m19755a(this.f22882a.f22883a);
            }
        }

        C5751a(IALocationService iALocationService, String str, Messenger messenger) {
            this.f22887e = iALocationService;
            this.f22883a = str;
            this.f22885c = messenger;
        }

        public final String toString() {
            return "ConnectionInfo{uuid=" + this.f22883a + ", listeningPositions=" + this.f22884b + '}';
        }
    }

    /* renamed from: com.indooratlas.android.sdk.IALocationService$b */
    class C5752b extends bj {
        /* renamed from: a */
        final /* synthetic */ IALocationService f22888a;

        C5752b(IALocationService iALocationService) {
            this.f22888a = iALocationService;
        }

        /* renamed from: a */
        public final void mo4566a(bh bhVar) {
            new StringBuilder("onUnrecoverableError: ").append(bhVar);
        }

        /* renamed from: a */
        public final void mo4567a(bp bpVar) {
            this.f22888a.f22897e.m19703b().obtainMessage(1002, bpVar).sendToTarget();
        }

        /* renamed from: a */
        public final void mo4569a(JSONObject jSONObject) {
            Bundle bundle = new Bundle(2);
            try {
                String string = jSONObject.getString("key");
                String optString = jSONObject.optString("id", null);
                bundle.putString("idaKey", string);
                bundle.putString("setupId", optString);
                this.f22888a.f22897e.m19703b().obtainMessage(1003, bundle).sendToTarget();
            } catch (JSONException e) {
            }
        }

        /* renamed from: a */
        public final void mo4568a(String str) {
            if (this.f22888a.f22902j) {
                this.f22888a.m19753a(501, -1, (Object) str);
            }
        }

        /* renamed from: b */
        public final void mo4571b(String str) {
            if (this.f22888a.f22902j) {
                this.f22888a.m19753a(502, -1, (Object) str);
            }
        }

        /* renamed from: a */
        public final void mo4563a(Bundle bundle) {
            if (this.f22888a.f22902j) {
                this.f22888a.m19753a(503, -1, (Object) bundle);
            }
        }

        /* renamed from: b */
        public final void mo4570b(Bundle bundle) {
            if (this.f22888a.f22902j) {
                this.f22888a.m19753a(504, -1, (Object) bundle);
            }
        }

        /* renamed from: a */
        public final void mo4560a(int i) {
            this.f22888a.m19753a(102, i, null);
        }

        /* renamed from: a */
        public final void mo4564a(IALocation iALocation) {
            this.f22888a.f22898f = iALocation;
            this.f22888a.m19753a(103, -1, (Object) iALocation);
            Context context = this.f22888a;
            synchronized (context.f22893a) {
                Collection linkedList = new LinkedList();
                if (context.f22893a.size() > 0) {
                    byte[] bArr;
                    Intent intent = new Intent();
                    String str = IALocationManager.EXTRA_LOCATION;
                    if (iALocation == null) {
                        bArr = null;
                    } else {
                        Parcel obtain = Parcel.obtain();
                        iALocation.writeToParcel(obtain, 0);
                        bArr = obtain.marshall();
                        obtain.recycle();
                    }
                    intent.putExtra(str, bArr);
                    Iterator it = context.f22893a.iterator();
                    while (it.hasNext()) {
                        PendingIntent pendingIntent = (PendingIntent) it.next();
                        try {
                            pendingIntent.send(context, 0, intent);
                        } catch (CanceledException e) {
                            linkedList.add(pendingIntent);
                        }
                    }
                    if (!linkedList.isEmpty()) {
                        context.f22893a.removeAll(linkedList);
                        context.m19759c();
                        context.m19756a(true);
                        context.m19758b();
                    }
                }
            }
        }

        /* renamed from: a */
        public final void mo4561a(long j, double d) {
            this.f22888a.m19753a(104, -1, new Object[]{Long.valueOf(j), Double.valueOf(d)});
        }

        /* renamed from: a */
        public final void mo4562a(long j, double[] dArr) {
            this.f22888a.m19753a(105, -1, new Object[]{Long.valueOf(j), dArr});
        }

        /* renamed from: a */
        public final void mo4565a(ax axVar) {
            this.f22888a.f22901i = axVar;
            this.f22888a.m19753a(106, -1, (Object) axVar);
            this.f22888a.m19754a(axVar);
        }
    }

    /* renamed from: com.indooratlas.android.sdk.IALocationService$c */
    class C5754c extends C5753c {
        /* renamed from: a */
        final /* synthetic */ IALocationService f22892a;

        C5754c(IALocationService iALocationService) {
            this.f22892a = iALocationService;
        }

        /* renamed from: a */
        protected final void mo4575a(Message message, Messenger messenger) {
            IALocationService.m19736a(this.f22892a, message.getData().getBundle("_extras"));
            C5751a a = this.f22892a.m19752a(bo.m19699e(message), messenger);
            if (a != null) {
                IALocationService.m19737a(this.f22892a, a);
            }
        }

        /* renamed from: a */
        protected final void mo4574a(Message message) {
            this.f22892a.m19755a(bo.m19699e(message));
        }

        /* renamed from: a */
        protected final void mo4576a(Message message, IALocationRequest iALocationRequest) {
            new Object[1][0] = iALocationRequest;
            C5751a a = ((C5751a) this.f22892a.f22895c.get(bo.m19699e(message)));
            if (a == null) {
                ee.m20409a("IAService", "no such ConnectionInfo: %s", bo.m19699e(message));
                return;
            }
            boolean a2 = this.f22892a.m19757a();
            a.f22884b = true;
            this.f22892a.m19759c();
            IALocationService.m19741a(this.f22892a, a2, iALocationRequest);
        }

        /* renamed from: a */
        protected final void mo4578a(IALocationRequest iALocationRequest, PendingIntent pendingIntent) {
            new Object[1][0] = iALocationRequest;
            synchronized (this.f22892a.f22893a) {
                boolean a = this.f22892a.m19757a();
                this.f22892a.f22893a.add(pendingIntent);
                this.f22892a.m19759c();
                IALocationService.m19741a(this.f22892a, a, iALocationRequest);
            }
        }

        /* renamed from: b */
        protected final void mo4583b(Message message) {
            C5751a a = ((C5751a) this.f22892a.f22895c.get(bo.m19699e(message)));
            if (a == null) {
                ee.m20409a("IAService", "no such ConnectionInfo: %s", bo.m19699e(message));
                return;
            }
            boolean a2 = this.f22892a.m19757a();
            a.f22884b = false;
            this.f22892a.m19759c();
            this.f22892a.m19756a(a2);
        }

        /* renamed from: a */
        protected final void mo4573a(PendingIntent pendingIntent) {
            synchronized (this.f22892a.f22893a) {
                boolean a = this.f22892a.m19757a();
                this.f22892a.f22893a.remove(pendingIntent);
                this.f22892a.m19759c();
                this.f22892a.m19756a(a);
                this.f22892a.m19758b();
            }
        }

        /* renamed from: a */
        protected final void mo4577a(IALocation iALocation) {
            bf f = this.f22892a.f22894b;
            new Object[1][0] = iALocation;
            if (f.m20093c()) {
                f.f23156a.m19878a(7, (Object) iALocation.newBuilder().withLongExtra("com.indooratlas.android.sdk.intent.extras.clientTime", f.f23177v.mo4654a()).build()).sendToTarget();
            }
        }

        /* renamed from: a */
        protected final void mo4579a(IAOrientationRequest iAOrientationRequest) {
            bf f = this.f22892a.f22894b;
            new Object[1][0] = iAOrientationRequest;
            if (f.m20093c()) {
                f.f23156a.m19878a(8, (Object) iAOrientationRequest).sendToTarget();
            }
        }

        /* renamed from: a */
        protected final void mo4580a(ay ayVar) {
            bf f = this.f22892a.f22894b;
            Log.d("IACore", "Adding " + ayVar.m19894a().size() + " geofences.");
            if (f.m20093c()) {
                f.f23156a.m19878a(109, (Object) ayVar).sendToTarget();
            }
        }

        /* renamed from: a */
        protected final void mo4581a(ArrayList<String> arrayList) {
            bf f = this.f22892a.f22894b;
            if (f.m20093c()) {
                f.f23156a.m19878a(110, (Object) arrayList).sendToTarget();
            }
        }

        /* renamed from: b */
        protected final void mo4582b(PendingIntent pendingIntent) {
            synchronized (this.f22892a.f22896d) {
                if (this.f22892a.f22896d.add(pendingIntent) && this.f22892a.f22901i != null) {
                    this.f22892a.m19754a(this.f22892a.f22901i);
                }
                this.f22892a.m19759c();
            }
        }

        /* renamed from: c */
        protected final void mo4584c(PendingIntent pendingIntent) {
            synchronized (this.f22892a.f22896d) {
                this.f22892a.f22896d.remove(pendingIntent);
                this.f22892a.m19759c();
            }
        }

        /* renamed from: c */
        protected final void mo4585c(Message message) {
            dc dcVar;
            bf f;
            switch (message.what) {
                case 10:
                    dcVar = (dc) message.obj;
                    f = this.f22892a.f22894b;
                    if (f.m20093c()) {
                        f.f23156a.m19878a(105, (Object) dcVar).sendToTarget();
                        return;
                    }
                    return;
                case 11:
                    dcVar = (dc) message.obj;
                    f = this.f22892a.f22894b;
                    if (f.m20093c()) {
                        f.f23156a.m19878a(106, (Object) dcVar).sendToTarget();
                        return;
                    }
                    return;
                case 12:
                    this.f22892a.f22894b.m20091a((br) message.obj, true);
                    return;
                case 13:
                    this.f22892a.f22894b.m20091a((br) message.obj, false);
                    return;
                case 1002:
                    IALocationService.m19738a(this.f22892a, (bp) message.obj);
                    return;
                case 1003:
                    IALocationService.m19742b(this.f22892a, (Bundle) message.obj);
                    return;
                default:
                    super.mo4585c(message);
                    return;
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        new Object[1][0] = this;
    }

    public void onDestroy() {
        new Object[1][0] = this;
        m19747d();
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        new Object[1][0] = intent;
        return this.f22897e.m19700a();
    }

    public boolean onUnbind(Intent intent) {
        new Object[1][0] = intent;
        return super.onUnbind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    /* renamed from: d */
    private void m19747d() {
        if (this.f22894b != null) {
            this.f22894b.m20089a();
            this.f22894b.m20092b();
            this.f22894b = null;
        }
    }

    /* renamed from: a */
    final boolean m19757a() {
        for (C5751a c5751a : this.f22895c.values()) {
            if (c5751a.f22884b) {
                return true;
            }
        }
        return !this.f22893a.isEmpty();
    }

    /* renamed from: a */
    final void m19756a(boolean z) {
        if (z && !m19757a()) {
            bf bfVar = this.f22894b;
            if (bfVar.m20093c()) {
                bfVar.f23156a.m19876a(6).sendToTarget();
            }
        }
    }

    /* renamed from: a */
    final C5751a m19752a(String str, Messenger messenger) {
        C5751a c5751a;
        new Object[1][0] = str;
        synchronized (this.f22895c) {
            this.f22895c.containsKey(str);
            c5751a = new C5751a(this, str, messenger);
            try {
                messenger.getBinder().linkToDeath(c5751a.f22886d, 0);
                this.f22895c.put(str, c5751a);
                m19759c();
            } catch (RemoteException e) {
                c5751a = null;
            }
        }
        return c5751a;
    }

    /* renamed from: a */
    final void m19755a(String str) {
        new Object[1][0] = str;
        synchronized (this.f22895c) {
            boolean a = m19757a();
            C5751a c5751a = (C5751a) this.f22895c.remove(str);
            if (c5751a != null) {
                c5751a.f22885c.getBinder().unlinkToDeath(c5751a.f22886d, 0);
                m19759c();
                m19756a(a);
                m19758b();
                return;
            }
            new Object[1][0] = str;
        }
    }

    /* renamed from: b */
    private void m19743b(String str) {
        m19755a(str);
    }

    /* renamed from: a */
    final void m19753a(int i, int i2, Object obj) {
        synchronized (this.f22895c) {
            for (C5751a c5751a : this.f22895c.values()) {
                try {
                    Message a = this.f22897e.m19701a(i);
                    a.arg1 = i2;
                    a.arg2 = -1;
                    a.obj = obj;
                    c5751a.f22885c.send(a);
                } catch (RemoteException e) {
                    m19755a(c5751a.f22883a);
                }
            }
        }
    }

    /* renamed from: a */
    final void m19754a(ax axVar) {
        synchronized (this.f22896d) {
            Collection linkedList = new LinkedList();
            if (this.f22896d.size() > 0) {
                byte[] bArr;
                Intent intent = new Intent();
                String str = "com.indooratlas.android.sdk.intent.extras.geofenceEvent";
                if (axVar == null) {
                    bArr = null;
                } else {
                    Parcel obtain = Parcel.obtain();
                    axVar.writeToParcel(obtain, 0);
                    bArr = obtain.marshall();
                    obtain.recycle();
                }
                intent.putExtra(str, bArr);
                Iterator it = this.f22896d.iterator();
                while (it.hasNext()) {
                    PendingIntent pendingIntent = (PendingIntent) it.next();
                    try {
                        pendingIntent.send(this, 0, intent);
                    } catch (CanceledException e) {
                        linkedList.add(pendingIntent);
                    }
                }
                if (!linkedList.isEmpty()) {
                    this.f22896d.removeAll(linkedList);
                    m19759c();
                }
            }
        }
    }

    /* renamed from: c */
    final void m19759c() {
        if (ee.m20411a("IAService", 3)) {
            int i;
            int size = this.f22895c.size();
            int i2 = 0;
            for (C5751a c5751a : this.f22895c.values()) {
                if (c5751a.f22884b) {
                    i = i2 + 1;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            i = this.f22893a.size();
            new StringBuilder("active connections = ").append(size).append(" (").append(i2).append(" requesting position), pending intents for location updates = ").append(i).append(", pending intents for geofence events = ").append(this.f22896d.size());
        }
    }

    /* renamed from: b */
    final void m19758b() {
        Object obj;
        if (this.f22895c.isEmpty() && this.f22893a.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            m19747d();
            stopSelf();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19736a(IALocationService iALocationService, Bundle bundle) {
        if (iALocationService.f22894b == null) {
            C5790a c5790a = new C5790a(iALocationService, new C5752b(iALocationService));
            c5790a.f23090e.f23182a = bundle;
            c5790a.f23091f = new cc();
            bf bfVar = new bf(c5790a);
            if (bfVar.m20093c()) {
                bfVar.f23156a.m19876a(1).sendToTarget();
            }
            iALocationService.f22894b = bfVar;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19737a(IALocationService iALocationService, C5751a c5751a) {
        if (iALocationService.f22898f != null || iALocationService.f22899g != null || iALocationService.f22900h != null || iALocationService.f22901i != null) {
            Bundle bundle = new Bundle();
            if (iALocationService.f22899g != null) {
                bundle.putParcelable("currentVenue", iALocationService.f22899g);
            }
            if (iALocationService.f22900h != null) {
                bundle.putParcelable("currentFloorPlan", iALocationService.f22900h);
            }
            if (iALocationService.f22898f != null) {
                bundle.putParcelable("lastKnownLocation", iALocationService.f22898f);
            }
            if (iALocationService.f22901i != null) {
                bundle.putParcelable("lastGeofenceEvent", iALocationService.f22901i);
            }
            try {
                c5751a.f22885c.send(iALocationService.f22897e.m19702a(25, (Object) bundle));
            } catch (RemoteException e) {
                iALocationService.m19743b(c5751a.f22883a);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19741a(IALocationService iALocationService, boolean z, IALocationRequest iALocationRequest) {
        if (!z && iALocationService.m19757a()) {
            bf bfVar = iALocationService.f22894b;
            new Object[1][0] = iALocationRequest;
            if (bfVar.m20093c()) {
                bfVar.f23156a.m19878a(5, (Object) iALocationRequest).sendToTarget();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m19738a(IALocationService iALocationService, bp bpVar) {
        synchronized (iALocationService.f22895c) {
            for (C5751a c5751a : iALocationService.f22895c.values()) {
                try {
                    C5753c c5753c = iALocationService.f22897e;
                    Messenger messenger = c5751a.f22885c;
                    Message a = c5753c.m19701a(21);
                    a.getData().putParcelable("state", bpVar);
                    messenger.send(a);
                } catch (RemoteException e) {
                    iALocationService.m19755a(c5751a.f22883a);
                }
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m19742b(IALocationService iALocationService, Bundle bundle) {
        synchronized (iALocationService.f22895c) {
            for (C5751a c5751a : iALocationService.f22895c.values()) {
                try {
                    c5751a.f22885c.send(iALocationService.f22897e.m19702a(22, (Object) bundle));
                } catch (RemoteException e) {
                    iALocationService.m19755a(c5751a.f22883a);
                }
            }
        }
    }
}
