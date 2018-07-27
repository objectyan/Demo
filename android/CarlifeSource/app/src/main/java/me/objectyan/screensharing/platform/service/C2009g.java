package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.carlife.platform.service.C2016h.C2025a;

/* compiled from: IRemoteBinder */
/* renamed from: com.baidu.carlife.platform.service.g */
public interface C2009g extends IInterface {

    /* compiled from: IRemoteBinder */
    /* renamed from: com.baidu.carlife.platform.service.g$a */
    public static abstract class C2023a extends Binder implements C2009g {
        /* renamed from: a */
        static final int f6547a = 1;
        /* renamed from: b */
        static final int f6548b = 2;
        /* renamed from: c */
        static final int f6549c = 3;
        /* renamed from: d */
        private static final String f6550d = "com.baidu.carlife.platform.service.IServiceBinder";

        /* compiled from: IRemoteBinder */
        /* renamed from: com.baidu.carlife.platform.service.g$a$a */
        private static class C2022a implements C2009g {
            /* renamed from: a */
            private IBinder f6546a;

            C2022a(IBinder remote) {
                this.f6546a = remote;
            }

            public IBinder asBinder() {
                return this.f6546a;
            }

            /* renamed from: a */
            public String m7756a() {
                return C2023a.f6550d;
            }

            /* renamed from: a */
            public int mo1742a(String appName, String sdkVersion, String secretKey, C2016h callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2023a.f6550d);
                    _data.writeString(appName);
                    _data.writeString(sdkVersion);
                    _data.writeString(secretKey);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.f6546a.transact(1, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2023a.f6550d);
                    _data.writeString(appName);
                    this.f6546a.transact(2, _data, _reply, 0);
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
                    _data.writeInterfaceToken(C2023a.f6550d);
                    _data.writeString(appName);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    this.f6546a.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public C2023a() {
            attachInterface(this, f6550d);
        }

        /* renamed from: a */
        public static C2009g m7759a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f6550d);
            if (iin == null || !(iin instanceof C2009g)) {
                return new C2022a(obj);
            }
            return (C2009g) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(f6550d);
                    int _result = mo1742a(data.readString(), data.readString(), data.readString(), C2025a.m7762a(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(f6550d);
                    String _result2 = mo1743a(data.readString());
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case 3:
                    data.enforceInterface(f6550d);
                    mo1746a(data.readString(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(f6550d);
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
    void mo1746a(String str, int i, String str2) throws RemoteException;
}
