package com.baidu.carlife.platform.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.model.CLAlbum;
import java.util.List;

/* compiled from: ILocalCallback */
/* renamed from: com.baidu.carlife.platform.service.f */
public interface C1991f extends IInterface {

    /* compiled from: ILocalCallback */
    /* renamed from: com.baidu.carlife.platform.service.f$a */
    public static abstract class C1992a extends Binder implements C1991f {
        /* renamed from: a */
        private static final String f6420a = "com.baidu.carlife.platform.service.ILocalCallback";
        /* renamed from: b */
        static final int f6421b = 1;
        /* renamed from: c */
        static final int f6422c = 2;
        /* renamed from: d */
        static final int f6423d = 3;
        /* renamed from: e */
        static final int f6424e = 4;
        /* renamed from: f */
        static final int f6425f = 5;
        /* renamed from: g */
        static final int f6426g = 6;

        /* compiled from: ILocalCallback */
        /* renamed from: com.baidu.carlife.platform.service.f$a$a */
        private static class C2021a implements C1991f {
            /* renamed from: a */
            private IBinder f6545a;

            C2021a(IBinder remote) {
                this.f6545a = remote;
            }

            public IBinder asBinder() {
                return this.f6545a;
            }

            /* renamed from: a */
            public String m7748a() {
                return C1992a.f6420a;
            }

            /* renamed from: a */
            public void mo1738a(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C1992a.f6420a);
                    _data.writeString(name);
                    this.f6545a.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: b */
            public void mo1739b(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C1992a.f6420a);
                    _data.writeString(name);
                    this.f6545a.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1734a(int errorNo, String errorMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C1992a.f6420a);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    this.f6545a.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1736a(int errorNo, String errorMsg, String name, String songListId, List<MusicSongModel> songList, int pn, int rn, int total) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C1992a.f6420a);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    _data.writeString(name);
                    _data.writeString(songListId);
                    _data.writeTypedList(songList);
                    _data.writeInt(pn);
                    _data.writeInt(rn);
                    _data.writeInt(total);
                    this.f6545a.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1735a(int errorNo, String errorMsg, String name, String songId, long downloadSize, long totalSize, boolean stop) throws RemoteException {
                int i = 0;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C1992a.f6420a);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    _data.writeString(name);
                    _data.writeString(songId);
                    _data.writeLong(downloadSize);
                    _data.writeLong(totalSize);
                    if (stop) {
                        i = 1;
                    }
                    _data.writeInt(i);
                    this.f6545a.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            /* renamed from: a */
            public void mo1737a(int errorNo, String errorMsg, String name, List<CLAlbum> albumList) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(C1992a.f6420a);
                    _data.writeInt(errorNo);
                    _data.writeString(errorMsg);
                    _data.writeString(name);
                    _data.writeTypedList(albumList);
                    this.f6545a.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public C1992a() {
            attachInterface(this, f6420a);
        }

        /* renamed from: a */
        public static C1991f m7595a(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(f6420a);
            if (iin == null || !(iin instanceof C1991f)) {
                return new C2021a(obj);
            }
            return (C1991f) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(f6420a);
                    mo1738a(data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(f6420a);
                    mo1739b(data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(f6420a);
                    mo1734a(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(f6420a);
                    mo1736a(data.readInt(), data.readString(), data.readString(), data.readString(), data.createTypedArrayList(MusicSongModel.CREATOR), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(f6420a);
                    mo1735a(data.readInt(), data.readString(), data.readString(), data.readString(), data.readLong(), data.readLong(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(f6420a);
                    mo1737a(data.readInt(), data.readString(), data.readString(), data.createTypedArrayList(CLAlbum.CREATOR));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(f6420a);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1734a(int i, String str) throws RemoteException;

    /* renamed from: a */
    void mo1735a(int i, String str, String str2, String str3, long j, long j2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1736a(int i, String str, String str2, String str3, List<MusicSongModel> list, int i2, int i3, int i4) throws RemoteException;

    /* renamed from: a */
    void mo1737a(int i, String str, String str2, List<CLAlbum> list) throws RemoteException;

    /* renamed from: a */
    void mo1738a(String str) throws RemoteException;

    /* renamed from: b */
    void mo1739b(String str) throws RemoteException;
}
