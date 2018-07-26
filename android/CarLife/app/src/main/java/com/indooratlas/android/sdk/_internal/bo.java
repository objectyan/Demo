package com.indooratlas.android.sdk._internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationRequest;
import com.indooratlas.android.sdk.IAOrientationRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public abstract class bo {
    /* renamed from: c */
    protected Messenger f22889c = new Messenger(this.f22890d);
    /* renamed from: d */
    protected Handler f22890d = new C5822b(this);
    /* renamed from: e */
    protected String f22891e = UUID.randomUUID().toString();

    /* renamed from: com.indooratlas.android.sdk._internal.bo$c */
    public static abstract class C5753c extends bo {
        /* renamed from: a */
        public abstract void mo4573a(PendingIntent pendingIntent);

        /* renamed from: a */
        public abstract void mo4574a(Message message);

        /* renamed from: a */
        public abstract void mo4575a(Message message, Messenger messenger);

        /* renamed from: a */
        public abstract void mo4576a(Message message, IALocationRequest iALocationRequest);

        /* renamed from: a */
        public abstract void mo4577a(IALocation iALocation);

        /* renamed from: a */
        public abstract void mo4578a(IALocationRequest iALocationRequest, PendingIntent pendingIntent);

        /* renamed from: a */
        public abstract void mo4579a(IAOrientationRequest iAOrientationRequest);

        /* renamed from: a */
        public abstract void mo4580a(ay ayVar);

        /* renamed from: a */
        public abstract void mo4581a(ArrayList<String> arrayList);

        /* renamed from: b */
        public abstract void mo4582b(PendingIntent pendingIntent);

        /* renamed from: b */
        public abstract void mo4583b(Message message);

        /* renamed from: c */
        public abstract void mo4584c(PendingIntent pendingIntent);

        /* renamed from: d */
        protected final void mo4572d(Message message) {
            switch (message.what) {
                case 1:
                    mo4575a(message, message.replyTo);
                    return;
                case 2:
                    mo4574a(message);
                    return;
                case 3:
                    mo4576a(message, (IALocationRequest) bo.m19698a(message, "request"));
                    return;
                case 4:
                    mo4583b(message);
                    return;
                case 5:
                    mo4577a((IALocation) bo.m19698a(message, "location"));
                    return;
                case 6:
                    mo4579a((IAOrientationRequest) bo.m19698a(message, "request"));
                    return;
                case 7:
                    mo4578a((IALocationRequest) bo.m19698a(message, "request"), (PendingIntent) bo.m19698a(message, "pendingIntent"));
                    return;
                case 8:
                    mo4573a((PendingIntent) bo.m19698a(message, "pendingIntent"));
                    return;
                case 14:
                    mo4580a((ay) bo.m19698a(message, "request"));
                    return;
                case 15:
                    mo4581a(message.getData().getStringArrayList("requestIds"));
                    return;
                case 16:
                    mo4582b((PendingIntent) bo.m19698a(message, "pendingIntent"));
                    return;
                case 17:
                    mo4584c((PendingIntent) bo.m19698a(message, "pendingIntent"));
                    return;
                default:
                    mo4585c(message);
                    return;
            }
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bo$a */
    public static abstract class C5778a extends bo {
        /* renamed from: a */
        private Messenger f23033a;
        /* renamed from: b */
        private final Queue<Message> f23034b = new LinkedList();

        /* renamed from: c */
        public final void m19904c() {
            this.f23034b.clear();
            this.f23033a = null;
        }

        /* renamed from: a */
        public final void m19898a(@NonNull Messenger messenger, @Nullable Bundle bundle) throws RemoteException {
            if (this.f23033a != null) {
                throw new AssertionError("register called when mService already set");
            }
            this.f23033a = messenger;
            Message a = m19701a(1);
            a.replyTo = this.c;
            if (bundle != null) {
                a.getData().putParcelable("_extras", bundle);
            }
            messenger.send(a);
            while (!this.f23034b.isEmpty()) {
                Object[] objArr = new Object[]{Integer.valueOf(a.what), ((Message) this.f23034b.poll()).obj};
                messenger.send((Message) this.f23034b.poll());
            }
        }

        /* renamed from: a */
        public final void m19900a(IAOrientationRequest iAOrientationRequest) throws RemoteException {
            Message a = m19701a(6);
            a.getData().putParcelable("request", iAOrientationRequest);
            m19897a(a);
        }

        /* renamed from: d */
        protected final void mo4572d(Message message) {
            Object[] objArr = new Object[]{Integer.valueOf(message.what), message.obj};
            switch (message.what) {
                case 21:
                    mo4605a((bp) bo.m19698a(message, "state"));
                    return;
                case 22:
                    mo4602a((Bundle) message.obj);
                    return;
                case 25:
                    mo4606b((Bundle) message.obj);
                    return;
                case 101:
                    int i = message.arg1;
                    return;
                case 103:
                    mo4603a((IALocation) message.obj);
                    return;
                case 106:
                    mo4604a((ax) message.obj);
                    return;
                default:
                    mo4585c(message);
                    return;
            }
        }

        /* renamed from: a */
        protected void mo4603a(IALocation iALocation) {
        }

        /* renamed from: a */
        protected void mo4605a(bp bpVar) {
        }

        /* renamed from: b */
        protected void mo4606b(Bundle bundle) {
        }

        /* renamed from: a */
        protected void mo4602a(Bundle bundle) {
        }

        /* renamed from: a */
        protected void mo4604a(ax axVar) {
        }

        /* renamed from: a */
        public final void m19897a(Message message) throws RemoteException {
            if (this.f23033a == null) {
                Object[] objArr = new Object[]{Integer.valueOf(message.what), message.obj};
                this.f23034b.offer(message);
                return;
            }
            objArr = new Object[]{Integer.valueOf(message.what), message.obj};
            this.f23033a.send(message);
        }
    }

    /* renamed from: com.indooratlas.android.sdk._internal.bo$b */
    static class C5822b extends ek<bo> {
        /* renamed from: a */
        protected final /* synthetic */ void mo4629a(Object obj, Message message) {
            ((bo) obj).mo4572d(message);
        }

        C5822b(bo boVar) {
            super(boVar);
        }
    }

    /* renamed from: d */
    protected abstract void mo4572d(Message message);

    protected bo() {
    }

    /* renamed from: a */
    public final IBinder m19700a() {
        return this.f22889c.getBinder();
    }

    /* renamed from: b */
    public final Handler m19703b() {
        return this.f22890d;
    }

    /* renamed from: c */
    public void mo4585c(Message message) {
        new Object[1][0] = Integer.valueOf(message.what);
    }

    /* renamed from: a */
    static <T> T m19698a(Message message, String str) {
        Bundle data = message.getData();
        data.setClassLoader(bo.class.getClassLoader());
        return data.getParcelable(str);
    }

    /* renamed from: a */
    public final Message m19701a(int i) {
        Message obtain = Message.obtain(null, i);
        obtain.getData().putString("_uuid", this.f22891e);
        return obtain;
    }

    /* renamed from: a */
    public final Message m19702a(int i, Object obj) {
        Message a = m19701a(i);
        a.obj = obj;
        return a;
    }

    /* renamed from: e */
    public static String m19699e(Message message) {
        return message.getData().getString("_uuid");
    }
}
