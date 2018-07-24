package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.carlife.platform.service.C1991f.C1992a;
import com.baidu.carlife.platform.service.C2016h.C2025a;
import java.util.List;

/* compiled from: IServiceBinder */
/* renamed from: com.baidu.carlife.platform.service.i */
public interface C2010i extends IInterface, C2008e, C2009g {

    /* compiled from: IServiceBinder */
    /* renamed from: com.baidu.carlife.platform.service.i$a */
    public static abstract class C2011a extends Binder implements C2010i {
        /* renamed from: a */
        private static final String f6499a = "com.baidu.carlife.platform.service.IServiceBinder";
        /* renamed from: b */
        static final int f6500b = 1;
        /* renamed from: c */
        static final int f6501c = 2;
        /* renamed from: d */
        static final int f6502d = 3;
        /* renamed from: e */
        static final int f6503e = 4;
        /* renamed from: f */
        static final int f6504f = 5;
        /* renamed from: g */
        static final int f6505g = 6;
        /* renamed from: h */
        static final int f6506h = 7;
        /* renamed from: i */
        static final int f6507i = 8;
        /* renamed from: j */
        static final int f6508j = 9;
        /* renamed from: k */
        static final int f6509k = 10;
        /* renamed from: l */
        static final int f6510l = 11;

        /* compiled from: IServiceBinder */
        /* renamed from: com.baidu.carlife.platform.service.i$a$a */
        private static class C2026a implements C2010i {
            /* renamed from: a */
            private IBinder f6554a;

            C2026a(IBinder remote) {
                this.f6554a = remote;
            }

            public IBinder asBinder() {
                return this.f6554a;
            }

            /* renamed from: b */
            public String m7771b() {
                return C2011a.f6499a;
            }

            /* renamed from: a */
            public int mo1742a(String appName, String sdkVersion, String secretKey, C2016h callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(appName);
                    _data.writeString(sdkVersion);
                    _data.writeString(secretKey);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.f6554a.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public String mo1743a(String appName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(appName);
                    this.f6554a.transact(2, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1746a(String appName, int errorNo, String errorMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(appName);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    this.f6554a.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo1749a(C1991f callback) throws RemoteException {
                boolean _result = false;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.f6554a.transact(4, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2011a.f6499a);
                    this.f6554a.transact(5, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    this.f6554a.transact(6, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(name);
                    _data.writeString(songListId);
                    _data.writeInt(pn);
                    _data.writeInt(rn);
                    this.f6554a.transact(7, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(name);
                    _data.writeString(songId);
                    _data.writeLong(totalSize);
                    this.f6554a.transact(8, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(name);
                    this.f6554a.transact(9, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2011a.f6499a);
                    _data.writeString(name);
                    this.f6554a.transact(10, _data, _reply, 0);
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
                    data.writeInterfaceToken(C2011a.f6499a);
                    data.writeString(name);
                    this.f6554a.transact(11, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }

        public C2011a() {
            attachInterface(this, f6499a);
        }

        /* renamed from: a */
        public static C2010i m7683a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f6499a);
            if (iin == null || !(iin instanceof C2010i)) {
                return new C2026a(obj);
            }
            return (C2010i) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(f6499a);
                    int _result = mo1742a(data.readString(), data.readString(), data.readString(), C2025a.m7762a(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(f6499a);
                    String _result2 = mo1743a(data.readString());
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case 3:
                    data.enforceInterface(f6499a);
                    mo1746a(data.readString(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(f6499a);
                    boolean _result3 = mo1749a(C1992a.m7595a(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(_result3 ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(f6499a);
                    List<String> _result4 = mo1744a();
                    reply.writeNoException();
                    reply.writeStringList(_result4);
                    return true;
                case 6:
                    data.enforceInterface(f6499a);
                    mo1745a(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(f6499a);
                    mo1747a(data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(f6499a);
                    mo1748a(data.readString(), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(f6499a);
                    mo1750b(data.readString());
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(f6499a);
                    mo1751c(data.readString());
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(f6499a);
                    mo1752d(data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(f6499a);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    int mo1742a(String str, String str2, String str3, C2016h c2016h) throws RemoteException;

    /* renamed from: a */
    String mo1743a(String str) throws RemoteException;

    /* renamed from: a */
    List<String> mo1744a() throws RemoteException;

    /* renamed from: a */
    void mo1745a(int i, String str) throws RemoteException;

    /* renamed from: a */
    void mo1746a(String str, int i, String str2) throws RemoteException;

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
