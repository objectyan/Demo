package com.baidu.android.pushservice.p021a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.baidu.android.pushservice.a.b */
public interface C0427b extends IInterface {

    /* renamed from: com.baidu.android.pushservice.a.b$a */
    public static abstract class C0429a extends Binder implements C0427b {

        /* renamed from: com.baidu.android.pushservice.a.b$a$a */
        private static class C0428a implements C0427b {
            /* renamed from: a */
            private IBinder f1352a;

            C0428a(IBinder iBinder) {
                this.f1352a = iBinder;
            }

            /* renamed from: a */
            public void mo1278a(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1352a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1352a;
            }

            /* renamed from: b */
            public void mo1279b(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1352a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1280c(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1352a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static C0427b m1853a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.android.pushservice.aidl.IPushServiceListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0427b)) ? new C0428a(iBinder) : (C0427b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    mo1278a(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    mo1279b(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    mo1280c(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.android.pushservice.aidl.IPushServiceListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo1278a(int i, String str) throws RemoteException;

    /* renamed from: b */
    void mo1279b(int i, String str) throws RemoteException;

    /* renamed from: c */
    void mo1280c(int i, String str) throws RemoteException;
}
