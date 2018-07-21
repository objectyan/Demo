package com.baidu.carlife.platform.service;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.model.CLAlbum;
import java.util.List;

public class b
  implements f
{
  private RemoteCallbackList<f> a = new RemoteCallbackList();
  
  public void a(int paramInt, String paramString)
    throws RemoteException
  {
    try
    {
      int j = this.a.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((f)this.a.getBroadcastItem(i)).a(paramInt, paramString);
        i += 1;
      }
      this.a.finishBroadcast();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, boolean paramBoolean)
    throws RemoteException
  {
    try
    {
      i.b("CarLifePlatform", "onGetSong() songId=" + paramString3 + " downloadSize=" + paramLong1 + " totalSize=" + paramLong2 + " stop=" + paramBoolean);
      int j = this.a.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((f)this.a.getBroadcastItem(i)).a(paramInt, paramString1, paramString2, paramString3, paramLong1, paramLong2, paramBoolean);
        i += 1;
      }
      this.a.finishBroadcast();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, List<MusicSongModel> paramList, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException
  {
    try
    {
      i.b("CarLifePlatform", "onGetSongList name=" + paramString2);
      int j = this.a.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((f)this.a.getBroadcastItem(i)).a(paramInt1, paramString1, paramString2, paramString3, paramList, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      this.a.finishBroadcast();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString1, String paramString2, List<CLAlbum> paramList)
    throws RemoteException
  {
    i.b("CarLifePlatform", "onGetAlbumList name=" + paramString2);
    int j = this.a.beginBroadcast();
    int i = 0;
    while (i < j)
    {
      ((f)this.a.getBroadcastItem(i)).a(paramInt, paramString1, paramString2, paramList);
      i += 1;
    }
    this.a.finishBroadcast();
  }
  
  public void a(String paramString)
    throws RemoteException
  {
    try
    {
      i.b("CarLifePlatform", "onRemoteClinetConnected name=" + paramString);
      int j = this.a.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((f)this.a.getBroadcastItem(i)).a(paramString);
        i += 1;
      }
      this.a.finishBroadcast();
      return;
    }
    finally {}
  }
  
  public boolean a(f paramf)
  {
    return this.a.register(paramf);
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void b(String paramString)
    throws RemoteException
  {
    try
    {
      i.b("CarLifePlatform", "onRemoteClientDisconnected name=" + paramString);
      int j = this.a.beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((f)this.a.getBroadcastItem(i)).b(paramString);
        i += 1;
      }
      this.a.finishBroadcast();
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */