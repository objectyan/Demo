package com.baidu.location.wifihistory;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISManager extends IInterface {

    public static abstract class Stub extends Binder implements ISManager {
        private static final String DESCRIPTOR = "com.baidu.location.wifihistory.ISManager";
        static final int TRANSACTION_getInfo2 = 3;
        static final int TRANSACTION_getShareString01 = 2;
        static final int TRANSACTION_setShareString01 = 1;

        /* renamed from: com.baidu.location.wifihistory.ISManager$Stub$a */
        private static class C3458a implements ISManager {
            /* renamed from: a */
            private IBinder f18730a;

            C3458a(IBinder iBinder) {
                this.f18730a = iBinder;
            }

            public IBinder asBinder() {
                return this.f18730a;
            }

            public WifiHistory getInfo2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f18730a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    WifiHistory wifiHistory = obtain2.readInt() != 0 ? (WifiHistory) WifiHistory.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return wifiHistory;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getShareString01() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.f18730a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setShareString01(String str) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f18730a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISManager)) ? new C3458a(iBinder) : (ISManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean shareString01 = setShareString01(parcel.readString());
                    parcel2.writeNoException();
                    if (shareString01) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String shareString012 = getShareString01();
                    parcel2.writeNoException();
                    parcel2.writeString(shareString012);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    WifiHistory info2 = getInfo2();
                    parcel2.writeNoException();
                    if (info2 != null) {
                        parcel2.writeInt(1);
                        info2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    WifiHistory getInfo2() throws RemoteException;

    String getShareString01() throws RemoteException;

    boolean setShareString01(String str) throws RemoteException;
}
