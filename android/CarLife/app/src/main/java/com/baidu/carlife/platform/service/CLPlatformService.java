package com.baidu.carlife.platform.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.carlife.core.i;
import java.util.List;

public class CLPlatformService
  extends Service
{
  private i.a a = new i.a()
  {
    public int a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, h paramAnonymoush)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.register appName=" + paramAnonymousString1 + " sdkVersion=" + paramAnonymousString2 + " secretKey=" + paramAnonymousString3);
      try
      {
        int i = Integer.parseInt(paramAnonymousString2);
        if (i < 1) {
          return 8;
        }
      }
      catch (Exception paramAnonymousString1)
      {
        i.a("PlatformManager", paramAnonymousString1);
        return 8;
      }
      if (a.a().b(paramAnonymousString1).a(paramAnonymoush)) {
        return 0;
      }
      return 4;
    }
    
    public String a(String paramAnonymousString)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.startServer appName=" + paramAnonymousString);
      a.a().d();
      return "CARLIFE_PLATFORM_SOCKET_SERVER";
    }
    
    public List<String> a()
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.getRemoteClients");
      return a.a().c();
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString)
      throws RemoteException
    {}
    
    public void a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.onSDKClientError appName=" + paramAnonymousString1 + " errorNo=" + paramAnonymousInt + " errorMsg=" + paramAnonymousString2);
      paramAnonymousString1 = a.a().c(paramAnonymousString1);
      if (paramAnonymousString1 == null) {}
      while (paramAnonymousInt != 7) {
        return;
      }
      paramAnonymousString1.d();
    }
    
    public void a(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.getSongList appName=" + paramAnonymousString1 + " songListId=" + paramAnonymousString2);
      paramAnonymousString1 = a.a().c(paramAnonymousString1);
      if (paramAnonymousString1 != null) {}
      try
      {
        paramAnonymousString1.a(paramAnonymousString2, paramAnonymousInt1, paramAnonymousInt2);
        return;
      }
      catch (IllegalArgumentException paramAnonymousString1)
      {
        i.a("PlatformManager", paramAnonymousString1);
      }
    }
    
    public void a(String paramAnonymousString1, String paramAnonymousString2, long paramAnonymousLong)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.getSong appName=" + paramAnonymousString1 + " songId=" + paramAnonymousString2);
      paramAnonymousString1 = a.a().c(paramAnonymousString1);
      if (paramAnonymousString1 != null) {}
      try
      {
        paramAnonymousString1.a(paramAnonymousString2, paramAnonymousLong);
        return;
      }
      catch (IllegalArgumentException paramAnonymousString1)
      {
        i.a("PlatformManager", paramAnonymousString1);
      }
    }
    
    public boolean a(f paramAnonymousf)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.registerLocalCallback");
      return a.a().b().a(paramAnonymousf);
    }
    
    public void b(String paramAnonymousString)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.stopDownloadSong appName=" + paramAnonymousString);
      paramAnonymousString = a.a().c(paramAnonymousString);
      if (paramAnonymousString != null) {
        paramAnonymousString.c();
      }
    }
    
    public void c(String paramAnonymousString)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.getAlbumList");
      paramAnonymousString = a.a().c(paramAnonymousString);
      if (paramAnonymousString != null) {}
      try
      {
        paramAnonymousString.b();
        return;
      }
      catch (IllegalArgumentException paramAnonymousString)
      {
        i.a("PlatformManager", paramAnonymousString);
      }
    }
    
    public void d(String paramAnonymousString)
      throws RemoteException
    {
      i.b("CarLifePlatform", "CLPlatformService.disconnectApp");
      paramAnonymousString = a.a().c(paramAnonymousString);
      if (paramAnonymousString != null) {
        paramAnonymousString.d();
      }
    }
  };
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/service/CLPlatformService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */