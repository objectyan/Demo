package com.baidu.android.pushservice.p021a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.pushservice.p021a.C0427b.C0429a;

/* renamed from: com.baidu.android.pushservice.a.a */
public interface C0417a extends IInterface {

    /* renamed from: com.baidu.android.pushservice.a.a$a */
    public static abstract class C0418a extends Binder implements C0417a {
        public C0418a() {
            attachInterface(this, "com.baidu.android.pushservice.aidl.IPushService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = 0;
            String a;
            boolean a2;
            switch (i) {
                case 1:
                    boolean z;
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo1255a(readString, readString2, z, C0429a.m1853a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    mo1254a(parcel.readString(), parcel.readString(), C0429a.m1853a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    mo1264b(parcel.readString(), parcel.readString(), C0429a.m1853a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a = mo1251a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 5:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a = mo1263b();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 6:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a = mo1252a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 7:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a = mo1253a(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 8:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1250a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1261b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1262b(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1267c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 12:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1268c(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 13:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a2 = mo1257a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a2 = mo1259a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a2 = mo1258a(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 16:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a2 = mo1265b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 17:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1269d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 18:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a2 = mo1270e(parcel.readString());
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 19:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a2 = mo1260a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (a2) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    i3 = mo1266c();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 21:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    mo1256a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), C0429a.m1853a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a = mo1271f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.android.pushservice.aidl.IPushService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    int mo1250a(String str, int i) throws RemoteException;

    /* renamed from: a */
    String mo1251a() throws RemoteException;

    /* renamed from: a */
    String mo1252a(String str) throws RemoteException;

    /* renamed from: a */
    String mo1253a(String str, int i, boolean z, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo1254a(String str, String str2, C0427b c0427b) throws RemoteException;

    /* renamed from: a */
    void mo1255a(String str, String str2, boolean z, C0427b c0427b) throws RemoteException;

    /* renamed from: a */
    void mo1256a(String str, String str2, boolean z, String str3, C0427b c0427b) throws RemoteException;

    /* renamed from: a */
    boolean mo1257a(String str, String str2) throws RemoteException;

    /* renamed from: a */
    boolean mo1258a(String str, String str2, int i) throws RemoteException;

    /* renamed from: a */
    boolean mo1259a(String str, String str2, String str3, String str4) throws RemoteException;

    /* renamed from: a */
    boolean mo1260a(String str, boolean z) throws RemoteException;

    /* renamed from: b */
    int mo1261b(String str) throws RemoteException;

    /* renamed from: b */
    int mo1262b(String str, int i) throws RemoteException;

    /* renamed from: b */
    String mo1263b() throws RemoteException;

    /* renamed from: b */
    void mo1264b(String str, String str2, C0427b c0427b) throws RemoteException;

    /* renamed from: b */
    boolean mo1265b(String str, String str2) throws RemoteException;

    /* renamed from: c */
    int mo1266c() throws RemoteException;

    /* renamed from: c */
    int mo1267c(String str) throws RemoteException;

    /* renamed from: c */
    int mo1268c(String str, int i) throws RemoteException;

    /* renamed from: d */
    int mo1269d(String str) throws RemoteException;

    /* renamed from: e */
    boolean mo1270e(String str) throws RemoteException;

    /* renamed from: f */
    String mo1271f(String str) throws RemoteException;
}
