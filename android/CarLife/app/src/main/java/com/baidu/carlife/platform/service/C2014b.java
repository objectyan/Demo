package com.baidu.carlife.platform.service;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.model.CLAlbum;
import java.util.List;

/* compiled from: CLLocalClient */
/* renamed from: com.baidu.carlife.platform.service.b */
public class C2014b implements C1991f {
    /* renamed from: a */
    private RemoteCallbackList<C1991f> f6517a = new RemoteCallbackList();

    /* renamed from: a */
    public boolean m7708a(C1991f callback) {
        return this.f6517a.register(callback);
    }

    public IBinder asBinder() {
        return null;
    }

    /* renamed from: a */
    public synchronized void mo1738a(String name) throws RemoteException {
        C1260i.m4435b("CarLifePlatform", "onRemoteClinetConnected name=" + name);
        int callbackCount = this.f6517a.beginBroadcast();
        for (int i = 0; i < callbackCount; i++) {
            ((C1991f) this.f6517a.getBroadcastItem(i)).mo1738a(name);
        }
        this.f6517a.finishBroadcast();
    }

    /* renamed from: b */
    public synchronized void mo1739b(String name) throws RemoteException {
        C1260i.m4435b("CarLifePlatform", "onRemoteClientDisconnected name=" + name);
        int callbackCount = this.f6517a.beginBroadcast();
        for (int i = 0; i < callbackCount; i++) {
            ((C1991f) this.f6517a.getBroadcastItem(i)).mo1739b(name);
        }
        this.f6517a.finishBroadcast();
    }

    /* renamed from: a */
    public synchronized void mo1734a(int errorNo, String errorMsg) throws RemoteException {
        int callbackCount = this.f6517a.beginBroadcast();
        for (int i = 0; i < callbackCount; i++) {
            ((C1991f) this.f6517a.getBroadcastItem(i)).mo1734a(errorNo, errorMsg);
        }
        this.f6517a.finishBroadcast();
    }

    /* renamed from: a */
    public synchronized void mo1736a(int errorNo, String errorMsg, String name, String songListId, List<MusicSongModel> songList, int pn, int rn, int total) throws RemoteException {
        C1260i.m4435b("CarLifePlatform", "onGetSongList name=" + name);
        int callbackCount = this.f6517a.beginBroadcast();
        for (int i = 0; i < callbackCount; i++) {
            ((C1991f) this.f6517a.getBroadcastItem(i)).mo1736a(errorNo, errorMsg, name, songListId, songList, pn, rn, total);
        }
        this.f6517a.finishBroadcast();
    }

    /* renamed from: a */
    public synchronized void mo1735a(int errorNo, String errorMsg, String name, String songId, long downloadSize, long totalSize, boolean stop) throws RemoteException {
        C1260i.m4435b("CarLifePlatform", "onGetSong() songId=" + songId + " downloadSize=" + downloadSize + " totalSize=" + totalSize + " stop=" + stop);
        int callbackCount = this.f6517a.beginBroadcast();
        for (int i = 0; i < callbackCount; i++) {
            ((C1991f) this.f6517a.getBroadcastItem(i)).mo1735a(errorNo, errorMsg, name, songId, downloadSize, totalSize, stop);
        }
        this.f6517a.finishBroadcast();
    }

    /* renamed from: a */
    public void mo1737a(int errorNo, String errorMsg, String name, List<CLAlbum> albumList) throws RemoteException {
        C1260i.m4435b("CarLifePlatform", "onGetAlbumList name=" + name);
        int callbackCount = this.f6517a.beginBroadcast();
        for (int i = 0; i < callbackCount; i++) {
            ((C1991f) this.f6517a.getBroadcastItem(i)).mo1737a(errorNo, errorMsg, name, albumList);
        }
        this.f6517a.finishBroadcast();
    }
}
