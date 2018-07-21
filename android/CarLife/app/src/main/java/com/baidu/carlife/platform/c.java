package com.baidu.carlife.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.model.CLAlbum;
import com.baidu.carlife.platform.service.CLPlatformService;
import com.baidu.carlife.platform.service.e;
import com.baidu.carlife.platform.service.e.a;
import com.baidu.carlife.platform.service.f.a;
import java.util.ArrayList;
import java.util.List;

public class c
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private static c j = new c();
  private HandlerThread f = new HandlerThread("CarLifeThirdParty Thread");
  private Handler g;
  private Context h = null;
  private e i = null;
  private Handler k;
  private List<String> l;
  private b m;
  private ServiceConnection n = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      i.b("CarLifePlatform", "onServiceConnected()");
      c.a(c.this, e.a.a(paramAnonymousIBinder));
      if (c.a(c.this) != null) {}
      try
      {
        c.a(c.this).a(c.b(c.this));
        c.a(c.this, c.a(c.this).a());
        if (c.c(c.this) == null)
        {
          c.a(c.this, new ArrayList());
          return;
        }
      }
      catch (RemoteException paramAnonymousComponentName)
      {
        do
        {
          for (;;)
          {
            i.a("PlatformManager", paramAnonymousComponentName);
          }
        } while ((c.c(c.this).size() <= 0) || (c.c(c.this) == null) || (c.c(c.this).size() <= 0) || (TextUtils.isEmpty((CharSequence)c.c(c.this).get(0))) || (c.d(c.this) == null));
        c.d(c.this).b((String)c.c(c.this).get(0));
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
  };
  private f.a o = new f.a()
  {
    public void a(int paramAnonymousInt, String paramAnonymousString)
      throws RemoteException
    {}
    
    public void a(final int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final long paramAnonymousLong1, long paramAnonymousLong2, final boolean paramAnonymousBoolean)
      throws RemoteException
    {
      i.b("CarLifePlatform", "PlatformManager.onGetSong()");
      if (c.e(c.this) != null) {
        c.e(c.this).post(new Runnable()
        {
          public void run()
          {
            if (c.d(c.this) != null) {
              c.d(c.this).a(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousLong1, paramAnonymousBoolean, this.g);
            }
          }
        });
      }
    }
    
    public void a(final int paramAnonymousInt1, final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final List<MusicSongModel> paramAnonymousList, final int paramAnonymousInt2, final int paramAnonymousInt3, final int paramAnonymousInt4)
      throws RemoteException
    {
      i.b("CarLifePlatform", "PlatformManager.onGetSongList() error=" + paramAnonymousInt1 + " msg=" + paramAnonymousString1 + " package=" + paramAnonymousString2 + " songListId=" + paramAnonymousString3 + " pn=" + paramAnonymousInt2 + " rn=" + paramAnonymousInt3 + " total=" + paramAnonymousInt4);
      if (c.e(c.this) != null) {
        c.e(c.this).post(new Runnable()
        {
          public void run()
          {
            if (c.d(c.this) != null) {
              c.d(c.this).a(paramAnonymousInt1, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousList, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
            }
          }
        });
      }
    }
    
    public void a(final int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2, final List<CLAlbum> paramAnonymousList)
      throws RemoteException
    {
      i.b("CarLifePlatform", "PlatformManager.onGetAlbumList()");
      if (c.e(c.this) != null) {
        c.e(c.this).post(new Runnable()
        {
          public void run()
          {
            if (c.d(c.this) != null) {
              c.d(c.this).a(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2, paramAnonymousList);
            }
          }
        });
      }
    }
    
    public void a(final String paramAnonymousString)
      throws RemoteException
    {
      i.b("CarLifePlatform", "PlatformManager.onRemoteClinetConnected()");
      if (c.e(c.this) != null) {
        c.e(c.this).post(new Runnable()
        {
          public void run()
          {
            c.a(c.this, paramAnonymousString);
            if (c.d(c.this) != null) {
              c.d(c.this).b(paramAnonymousString);
            }
          }
        });
      }
    }
    
    public void b(final String paramAnonymousString)
      throws RemoteException
    {
      i.b("CarLifePlatform", "PlatformManager.onRemoteClientDisconnected()");
      if (c.e(c.this) != null) {
        c.e(c.this).post(new Runnable()
        {
          public void run()
          {
            c.b(c.this, paramAnonymousString);
            if (c.d(c.this) != null) {
              c.d(c.this).a(paramAnonymousString);
            }
          }
        });
      }
    }
  };
  
  private c()
  {
    this.f.start();
    this.g = new a(this.f.getLooper());
  }
  
  public static c a()
  {
    return j;
  }
  
  private boolean d(String paramString)
  {
    if ((this.l != null) && (!TextUtils.isEmpty(paramString))) {
      return this.l.contains(paramString);
    }
    return false;
  }
  
  private void e(String paramString)
  {
    if (this.l == null) {
      this.l = new ArrayList();
    }
    label76:
    for (;;)
    {
      this.l.add(paramString);
      return;
      int i1 = 0;
      for (;;)
      {
        if (i1 >= this.l.size()) {
          break label76;
        }
        String str = (String)this.l.get(i1);
        if ((str != null) && (str.equals(paramString))) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  private void f(String paramString)
  {
    if ((this.l == null) && (this.l.size() <= 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.l.size())
      {
        String str = (String)this.l.get(i1);
        if ((str != null) && (str.equals(paramString)))
        {
          this.l.remove(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(Context paramContext, b paramb)
  {
    this.h = paramContext;
    this.m = paramb;
    this.k = new Handler(paramContext.getMainLooper());
    paramContext = new Intent(this.h, CLPlatformService.class);
    this.h.bindService(paramContext, this.n, 1);
  }
  
  public void a(b paramb)
  {
    this.m = paramb;
  }
  
  public void a(String paramString, MusicSongModel paramMusicSongModel)
  {
    if (!d(paramString))
    {
      i.e("CarLifePlatform", "PlatformManager.getDataWithid() invalid appname " + paramString);
      return;
    }
    i.b("CarLifePlatform", "PlatformManager.getDataWithid()");
    paramString = new Pair(paramString, paramMusicSongModel);
    Message.obtain(this.g, 3, paramString).sendToTarget();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!d(paramString1))
    {
      i.e("CarLifePlatform", "PlatformManager.requestSongList() invalid appname " + paramString1);
      return;
    }
    i.b("CarLifePlatform", "PlatformManager.getSongList() app=" + paramString1 + " id=" + paramString2 + " pn=" + paramInt1 + " rn=" + paramInt2);
    if (TextUtils.isEmpty(paramString2))
    {
      i.e("CarLifePlatform", "PlatformManager.requestSongList() invalid songListId: " + paramString2);
      return;
    }
    Message.obtain(this.g, 2, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).sendToTarget();
  }
  
  public boolean a(String paramString)
  {
    if (!d(paramString))
    {
      i.e("CarLifePlatform", "PlatformManager.getAlbumList() invalid appname " + paramString);
      return false;
    }
    i.b("CarLifePlatform", "PlatformManager.getAlbumList()");
    Message.obtain(this.g, 1, paramString).sendToTarget();
    return true;
  }
  
  public List<String> b()
  {
    return this.l;
  }
  
  public void b(String paramString)
  {
    if (!d(paramString))
    {
      i.e("CarLifePlatform", "PlatformManager.stopDownload() invalid appname " + paramString);
      return;
    }
    i.b("CarLifePlatform", "PlatformManager.stopDownload()");
    Message.obtain(this.g, 4, paramString).sendToTarget();
  }
  
  public void c(String paramString)
  {
    if (!d(paramString))
    {
      i.e("CarLifePlatform", "PlatformManager.disconnectApp() invalid appname " + paramString);
      return;
    }
    i.b("CarLifePlatform", "PlatformManager.disconnectApp()");
    Message.obtain(this.g, 5, paramString).sendToTarget();
  }
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (c.a(c.this) == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (paramMessage.what)
                {
                default: 
                  return;
                case 1: 
                  paramMessage = (String)paramMessage.obj;
                }
              } while (TextUtils.isEmpty(paramMessage));
              try
              {
                c.a(c.this).c(paramMessage);
                return;
              }
              catch (RemoteException paramMessage)
              {
                i.a("PlatformManager", paramMessage);
                return;
              }
              paramMessage = (Object[])paramMessage.obj;
            } while ((paramMessage == null) || (paramMessage.length < 3));
            String str1 = (String)paramMessage[0];
            String str2 = (String)paramMessage[1];
            int i = ((Integer)paramMessage[2]).intValue();
            int j = ((Integer)paramMessage[3]).intValue();
            try
            {
              c.a(c.this).a(str1, str2, i, j);
              return;
            }
            catch (RemoteException paramMessage)
            {
              i.a("PlatformManager", paramMessage);
              return;
            }
          } while (paramMessage.obj == null);
          paramMessage = (Pair)paramMessage.obj;
          try
          {
            c.a(c.this).a((String)paramMessage.first, ((MusicSongModel)paramMessage.second).a, ((MusicSongModel)paramMessage.second).o);
            return;
          }
          catch (RemoteException paramMessage)
          {
            i.a("PlatformManager", paramMessage);
            return;
          }
        } while (TextUtils.isEmpty((String)paramMessage.obj));
        paramMessage = (String)paramMessage.obj;
        try
        {
          c.a(c.this).b(paramMessage);
          return;
        }
        catch (RemoteException paramMessage)
        {
          i.a("PlatformManager", paramMessage);
          return;
        }
      } while (TextUtils.isEmpty((String)paramMessage.obj));
      paramMessage = (String)paramMessage.obj;
      try
      {
        c.a(c.this).d(paramMessage);
        return;
      }
      catch (RemoteException paramMessage)
      {
        i.a("PlatformManager", paramMessage);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */