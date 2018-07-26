package com.baidu.che.codriver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.che.codriver.C2511b.C2513a;

/* compiled from: ICoDriverService */
/* renamed from: com.baidu.che.codriver.c */
public interface C2520c extends IInterface {

    /* compiled from: ICoDriverService */
    /* renamed from: com.baidu.che.codriver.c$a */
    public static abstract class C2522a extends Binder implements C2520c {
        /* renamed from: a */
        static final int f8247a = 1;
        /* renamed from: b */
        static final int f8248b = 2;
        /* renamed from: c */
        static final int f8249c = 3;
        /* renamed from: d */
        private static final String f8250d = "com.baidu.che.codriver.ICoDriverService";

        /* compiled from: ICoDriverService */
        /* renamed from: com.baidu.che.codriver.c$a$a */
        private static class C2521a implements C2520c {
            /* renamed from: a */
            private IBinder f8246a;

            C2521a(IBinder remote) {
                this.f8246a = remote;
            }

            public IBinder asBinder() {
                return this.f8246a;
            }

            /* renamed from: a */
            public String m9570a() {
                return C2522a.f8250d;
            }

            /* renamed from: a */
            public String mo1873a(String pkg, String cmd, String param, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2522a.f8250d);
                    _data.writeString(pkg);
                    _data.writeString(cmd);
                    _data.writeString(param);
                    _data.writeString(data);
                    this.f8246a.transact(1, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1875a(String pkg, C2511b listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2522a.f8250d);
                    _data.writeString(pkg);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.f8246a.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1874a(C2511b listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2522a.f8250d);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.f8246a.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public C2522a() {
            attachInterface(this, f8250d);
        }

        /* renamed from: a */
        public static C2520c m9574a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f8250d);
            if (iin == null || !(iin instanceof C2520c)) {
                return new C2521a(obj);
            }
            return (C2520c) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(f8250d);
                    String _result = mo1873a(data.readString(), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 2:
                    data.enforceInterface(f8250d);
                    mo1875a(data.readString(), C2513a.m9529a(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(f8250d);
                    mo1874a(C2513a.m9529a(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(f8250d);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    String mo1873a(String str, String str2, String str3, String str4) throws RemoteException;

    /* renamed from: a */
    void mo1874a(C2511b c2511b) throws RemoteException;

    /* renamed from: a */
    void mo1875a(String str, C2511b c2511b) throws RemoteException;
}
