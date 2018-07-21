package com.baidu.carlife.platform.service;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.communication.CLPackage;
import com.baidu.carlife.platform.communication.b.c;
import com.baidu.carlife.platform.model.CLSong;
import com.baidu.carlife.platform.model.CLSongData;
import com.baidu.carlife.platform.request.CLGetAlbumListReq;
import com.baidu.carlife.platform.request.CLGetSongDataReq;
import com.baidu.carlife.platform.request.CLGetSongListReq;
import com.baidu.carlife.platform.response.CLGetAlbumListResp;
import com.baidu.carlife.platform.response.CLGetSongDataResp;
import com.baidu.carlife.platform.response.CLGetSongListResp;
import java.util.ArrayList;
import java.util.List;

public class c
  implements b.c, d.a, h
{
  private static final Object e = new Object();
  private RemoteCallbackList<h> a = new RemoteCallbackList();
  private String b;
  private com.baidu.carlife.platform.communication.b c;
  private boolean d = true;
  private d f;
  
  public c(String paramString)
  {
    this.b = paramString;
    this.f = d.a();
  }
  
  private void a(CLGetSongDataResp paramCLGetSongDataResp)
  {
    Object localObject = e;
    if (paramCLGetSongDataResp != null) {}
    for (;;)
    {
      try
      {
        if ((this.f != null) && (paramCLGetSongDataResp.songData != null) && (this.f.b(paramCLGetSongDataResp.requestId))) {
          if (paramCLGetSongDataResp.errorNo != 0) {
            return;
          }
        }
        switch (paramCLGetSongDataResp.songData.tag)
        {
        case 1: 
          i.e("CarLifePlatform", "songData.tag == " + paramCLGetSongDataResp.songData.tag);
          return;
        }
      }
      finally {}
      i.b("CarLifePlatform", "songData.tag == CLSongData.TAG_START");
      if (paramCLGetSongDataResp.songData.totalSize > 0L)
      {
        this.f.a(paramCLGetSongDataResp.songData.totalSize);
        continue;
        i.b("CarLifePlatform", "songData.tag == CLSongData.TAG_END");
        this.f.a(this.b);
      }
    }
  }
  
  private CLPackage b(CLPackage paramCLPackage)
  {
    synchronized (e)
    {
      if (this.f != null)
      {
        paramCLPackage = this.f.a(paramCLPackage);
        return paramCLPackage;
      }
      return paramCLPackage;
    }
  }
  
  public CLPackage a(CLPackage paramCLPackage)
  {
    if ((paramCLPackage == null) || (paramCLPackage.service <= 1) || (paramCLPackage.service > 5)) {}
    while (paramCLPackage.type != 2) {
      return paramCLPackage;
    }
    b localb = a.a().b();
    CLGetSongListResp localCLGetSongListResp;
    ArrayList localArrayList;
    int k;
    CLGetAlbumListResp localCLGetAlbumListResp1;
    switch (paramCLPackage.service)
    {
    default: 
      return paramCLPackage;
    case 2: 
      localCLGetSongListResp = CLGetSongListResp.fromJson(paramCLPackage.getDataInString());
      localArrayList = new ArrayList();
      k = 0;
      localCLGetAlbumListResp2 = null;
      if (localCLGetSongListResp == null)
      {
        i = 3;
        localCLGetAlbumListResp1 = localCLGetAlbumListResp2;
      }
    case 3: 
    case 4: 
      for (;;)
      {
        try
        {
          localb.a(i, localCLGetAlbumListResp1, this.b, localCLGetSongListResp.songListId, localArrayList, localCLGetSongListResp.pn, localCLGetSongListResp.rn, localCLGetSongListResp.total);
          return paramCLPackage;
        }
        catch (RemoteException localRemoteException1)
        {
          i.a("PlatformManager", localRemoteException1);
          return paramCLPackage;
        }
        a(CLGetSongDataResp.fromJson(paramCLPackage.getDataInString()));
        return paramCLPackage;
        if ((paramCLPackage.getData() == null) || (paramCLPackage.getDataLength() <= 0)) {
          break;
        }
        return b(paramCLPackage);
        if (localCLGetSongListResp.errorNo == 0)
        {
          i = k;
          localObject = localCLGetAlbumListResp2;
          if (localCLGetSongListResp.songList != null)
          {
            int j = 0;
            for (;;)
            {
              i = k;
              localObject = localCLGetAlbumListResp2;
              if (j >= localCLGetSongListResp.songList.size()) {
                break;
              }
              localObject = (CLSong)localCLGetSongListResp.songList.get(j);
              if (localObject != null) {
                localArrayList.add(new MusicSongModel((CLSong)localObject));
              }
              j += 1;
            }
          }
        }
        else
        {
          i = localCLGetSongListResp.errorNo;
          localObject = localCLGetSongListResp.errorMsg;
        }
      }
    }
    CLGetAlbumListResp localCLGetAlbumListResp2 = CLGetAlbumListResp.fromJson(paramCLPackage.getDataInString());
    int i = 0;
    Object localObject = null;
    if (localCLGetAlbumListResp2 == null) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        localb.a(i, (String)localObject, this.b, localCLGetAlbumListResp2.albumList);
        return paramCLPackage;
      }
      catch (RemoteException localRemoteException2)
      {
        i.a("PlatformManager", localRemoteException2);
        return paramCLPackage;
      }
      if (localCLGetAlbumListResp2.errorNo != 0)
      {
        i = localCLGetAlbumListResp2.errorNo;
        String str = localCLGetAlbumListResp2.errorMsg;
      }
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt, String paramString)
    throws RemoteException
  {
    if (this.a == null) {
      return;
    }
    int j = this.a.beginBroadcast();
    int i = 0;
    while (i < j)
    {
      ((h)this.a.getBroadcastItem(i)).a(paramInt, paramString);
      i += 1;
    }
    this.a.finishBroadcast();
  }
  
  public void a(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      a.a().b().a(paramInt, paramString1, this.b, paramString2, paramLong1, paramLong2, paramBoolean);
      return;
    }
    catch (RemoteException paramString1)
    {
      i.a("PlatformManager", paramString1);
    }
  }
  
  public void a(com.baidu.carlife.platform.communication.b paramb)
  {
    this.c = paramb;
    this.c.a(this);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    i.b("CarLifePlatform", "getSongList songListId=" + paramString);
    CLGetSongListReq localCLGetSongListReq = new CLGetSongListReq();
    localCLGetSongListReq.songListId = paramString;
    localCLGetSongListReq.pn = paramInt1;
    localCLGetSongListReq.rn = paramInt2;
    paramString = new CLPackage();
    paramString.type = 1;
    paramString.service = 2;
    paramString.setData(localCLGetSongListReq.toJson());
    if (this.c != null) {
      this.c.a(paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
    throws IllegalArgumentException
  {
    i.b("CarLifePlatform", "getSong songId=" + paramString);
    CLGetSongDataReq localCLGetSongDataReq = new CLGetSongDataReq();
    localCLGetSongDataReq.songId = paramString;
    CLPackage localCLPackage = new CLPackage();
    localCLPackage.type = 1;
    localCLPackage.service = 3;
    localCLPackage.setData(localCLGetSongDataReq.toJson());
    synchronized (e)
    {
      if (this.f != null)
      {
        this.f.b();
        this.f.a(this.b, this, paramString, paramLong, localCLGetSongDataReq.requestId);
      }
      if (this.c != null) {
        this.c.a(localCLPackage);
      }
      return;
    }
  }
  
  public void a(Thread paramThread, Exception paramException)
  {
    if (paramThread != null) {
      i.b("CarLifePlatform", "onThreadQuit() " + paramThread.getName());
    }
    d();
  }
  
  public boolean a(h paramh)
  {
    return this.a.register(paramh);
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void b()
    throws IllegalArgumentException
  {
    i.b("CarLifePlatform", "getAlbumList");
    CLGetAlbumListReq localCLGetAlbumListReq = new CLGetAlbumListReq();
    CLPackage localCLPackage = new CLPackage();
    localCLPackage.type = 1;
    localCLPackage.service = 5;
    localCLPackage.setData(localCLGetAlbumListReq.toJson());
    if (this.c != null) {
      this.c.a(localCLPackage);
    }
  }
  
  public void c()
  {
    i.b("CarLifePlatform", "stopDownloadSong appName=" + this.b);
    synchronized (e)
    {
      if (this.f != null) {
        this.f.a(this.b);
      }
      return;
    }
  }
  
  public void d()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    i.b("CarLifePlatform", "destroy appName=" + this.b);
    this.a = null;
    synchronized (e)
    {
      if (this.f != null)
      {
        this.f.a(this.b);
        this.f = null;
      }
      if (this.c != null)
      {
        this.c.a();
        this.c = null;
      }
      a.a().d(this.b);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */