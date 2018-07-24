package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IRemoteCallback */
/* renamed from: com.baidu.carlife.platform.service.h */
public interface C2016h extends IInterface {

    /* compiled from: IRemoteCallback */
    /* renamed from: com.baidu.carlife.platform.service.h$a */
    public static abstract class C2025a extends Binder implements C2016h {
        /* renamed from: a */
        static final int f6552a = 1;
        /* renamed from: b */
        private static final String f6553b = "com.baidu.carlife.platform.service.IRemoteCallback";

        /* compiled from: IRemoteCallback */
        /* renamed from: com.baidu.carlife.platform.service.h$a$a */
        private static class C2024a implements C2016h {
            /* renamed from: a */
            private IBinder f6551a;

            C2024a(IBinder remote) {
                this.f6551a = remote;
            }

            public IBinder asBinder() {
                return this.f6551a;
            }

            /* renamed from: a */
            public String m7760a() {
                return C2025a.f6553b;
            }

            /* renamed from: a */
            public void mo1755a(int errorNo, String errorMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2025a.f6553b);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    this.f6551a.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public C2025a() {
            attachInterface(this, f6553b);
        }

        /* renamed from: a */
        public static C2016h m7762a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f6553b);
            if (iin == null || !(iin instanceof C2016h)) {
                return new C2024a(obj);
            }
            return (C2016h) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(f6553b);
                    mo1755a(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(f6553b);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1755a(int i, String str) throws RemoteException;
}
