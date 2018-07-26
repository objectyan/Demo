package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.carlife.platform.service.C1991f.C1992a;
import java.util.List;

/* compiled from: ILocalBinder */
/* renamed from: com.baidu.carlife.platform.service.e */
public interface C2008e extends IInterface {

    /* compiled from: ILocalBinder */
    /* renamed from: com.baidu.carlife.platform.service.e$a */
    public static abstract class C2020a extends Binder implements C2008e {
        /* renamed from: a */
        static final int f6536a = 4;
        /* renamed from: b */
        static final int f6537b = 5;
        /* renamed from: c */
        static final int f6538c = 6;
        /* renamed from: d */
        static final int f6539d = 7;
        /* renamed from: e */
        static final int f6540e = 8;
        /* renamed from: f */
        static final int f6541f = 9;
        /* renamed from: g */
        static final int f6542g = 10;
        /* renamed from: h */
        static final int f6543h = 11;
        /* renamed from: i */
        private static final String f6544i = "com.baidu.carlife.platform.service.IServiceBinder";

        /* compiled from: ILocalBinder */
        /* renamed from: com.baidu.carlife.platform.service.e$a$a */
        private static class C2019a implements C2008e {
            /* renamed from: a */
            private IBinder f6535a;

            C2019a(IBinder remote) {
                this.f6535a = remote;
            }

            public IBinder asBinder() {
                return this.f6535a;
            }

            /* renamed from: b */
            public String m7743b() {
                return C2020a.f6544i;
            }

            /* renamed from: a */
            public boolean mo1749a(C1991f callback) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.f6535a.transact(4, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public List<String> mo1744a() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    this.f6535a.transact(5, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1745a(int errorNo, String errorMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    this.f6535a.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1747a(String name, String songListId, int pn, int rn) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    _data.writeString(name);
                    _data.writeString(songListId);
                    _data.writeInt(pn);
                    _data.writeInt(rn);
                    this.f6535a.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1748a(String name, String songId, long totalSize) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    _data.writeString(name);
                    _data.writeString(songId);
                    _data.writeLong(totalSize);
                    this.f6535a.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: b */
            public void mo1750b(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    _data.writeString(name);
                    this.f6535a.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: c */
            public void mo1751c(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2020a.f6544i);
                    _data.writeString(name);
                    this.f6535a.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: d */
            public void mo1752d(String name) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(C2020a.f6544i);
                    data.writeString(name);
                    this.f6535a.transact(11, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }

        public C2020a() {
            attachInterface(this, f6544i);
        }

        /* renamed from: a */
        public static C2008e m7747a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f6544i);
            if (iin == null || !(iin instanceof C2008e)) {
                return new C2019a(obj);
            }
            return (C2008e) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 4:
                    data.enforceInterface(f6544i);
                    boolean _result = mo1749a(C1992a.m7595a(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(f6544i);
                    List<String> _result2 = mo1744a();
                    reply.writeNoException();
                    reply.writeStringList(_result2);
                    return true;
                case 6:
                    data.enforceInterface(f6544i);
                    mo1745a(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(f6544i);
                    mo1747a(data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(f6544i);
                    mo1748a(data.readString(), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(f6544i);
                    mo1750b(data.readString());
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(f6544i);
                    mo1751c(data.readString());
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(f6544i);
                    mo1752d(data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(f6544i);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    List<String> mo1744a() throws RemoteException;

    /* renamed from: a */
    void mo1745a(int i, String str) throws RemoteException;

    /* renamed from: a */
    void mo1747a(String str, String str2, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo1748a(String str, String str2, long j) throws RemoteException;

    /* renamed from: a */
    boolean mo1749a(C1991f c1991f) throws RemoteException;

    /* renamed from: b */
    void mo1750b(String str) throws RemoteException;

    /* renamed from: c */
    void mo1751c(String str) throws RemoteException;

    /* renamed from: d */
    void mo1752d(String str) throws RemoteException;
}
