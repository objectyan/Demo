package com.baidu.che.codriver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ICoDriverListener */
/* renamed from: com.baidu.che.codriver.b */
public interface C2511b extends IInterface {

    /* compiled from: ICoDriverListener */
    /* renamed from: com.baidu.che.codriver.b$a */
    public static abstract class C2513a extends Binder implements C2511b {
        /* renamed from: a */
        static final int f8211a = 1;
        /* renamed from: b */
        private static final String f8212b = "com.baidu.che.codriver.ICoDriverListener";

        /* compiled from: ICoDriverListener */
        /* renamed from: com.baidu.che.codriver.b$a$a */
        private static class C2512a implements C2511b {
            /* renamed from: a */
            private IBinder f8210a;

            C2512a(IBinder remote) {
                this.f8210a = remote;
            }

            public IBinder asBinder() {
                return this.f8210a;
            }

            /* renamed from: a */
            public String m9527a() {
                return C2513a.f8212b;
            }

            /* renamed from: a */
            public String mo1872a(String pkg, String cmd, String param, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C2513a.f8212b);
                    _data.writeString(pkg);
                    _data.writeString(cmd);
                    _data.writeString(param);
                    _data.writeString(data);
                    this.f8210a.transact(1, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public C2513a() {
            attachInterface(this, f8212b);
        }

        /* renamed from: a */
        public static C2511b m9529a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f8212b);
            if (iin == null || !(iin instanceof C2511b)) {
                return new C2512a(obj);
            }
            return (C2511b) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(f8212b);
                    String _result = mo1872a(data.readString(), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                case 1598968902:
                    reply.writeString(f8212b);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    String mo1872a(String str, String str2, String str3, String str4) throws RemoteException;
}
