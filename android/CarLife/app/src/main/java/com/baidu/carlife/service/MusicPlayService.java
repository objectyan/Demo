package com.baidu.carlife.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.a.j;
import com.baidu.carlife.logic.music.c;
import com.baidu.carlife.logic.music.h;
import com.baidu.carlife.logic.music.m;
import com.baidu.carlife.logic.music.n;
import com.baidu.carlife.logic.music.o;
import com.baidu.carlife.model.MusicSongModel;
import java.io.IOException;
import java.util.ArrayList;

public class MusicPlayService
  extends Service
{
  private static final String b = "MusicPlayService";
  public o a = new o()
  {
    public void a()
    {
      MusicPlayService.e(MusicPlayService.this).b();
    }
    
    public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      MusicPlayService.g(MusicPlayService.this).a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
    }
    
    public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
    {
      MusicPlayService.e(MusicPlayService.this).a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousObject);
    }
    
    public void a(String paramAnonymousString)
    {
      MusicPlayService.f(MusicPlayService.this).i = paramAnonymousString;
      MusicPlayService.e(MusicPlayService.this).a();
    }
    
    public void a(boolean paramAnonymousBoolean)
    {
      MusicPlayService.e(MusicPlayService.this).a(paramAnonymousBoolean);
    }
    
    public void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
    {
      MusicPlayService.g(MusicPlayService.this).a(paramAnonymousArrayOfByte, paramAnonymousInt);
    }
    
    public void b()
    {
      MusicPlayService.g(MusicPlayService.this).z();
    }
    
    public void c()
    {
      MusicPlayService.g(MusicPlayService.this).A();
    }
    
    public void d()
    {
      MusicPlayService.g(MusicPlayService.this).y();
    }
  };
  private a c;
  private int d = -1;
  private MusicSongModel e;
  private m f;
  private n g;
  
  private void a()
  {
    if (this.d == 1)
    {
      if (this.e.m != null)
      {
        this.c.u();
        return;
      }
      this.g.c();
      return;
    }
    this.c.u();
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2) || (paramInt >= 3)) {
      this.c.v();
    }
    while (paramInt != 1) {
      return;
    }
    if (this.e.m != null)
    {
      this.c.v();
      return;
    }
    this.g.d();
  }
  
  private void a(int paramInt, MusicSongModel paramMusicSongModel, ArrayList<String> paramArrayList)
  {
    if ((paramMusicSongModel == null) || (!h.i(paramInt))) {}
    label320:
    label563:
    for (;;)
    {
      return;
      this.d = paramInt;
      this.e = paramMusicSongModel;
      if ((paramInt == 1) && (this.e.m == null))
      {
        this.g.a(this.e.a);
        return;
      }
      paramMusicSongModel = this.e.m;
      int n;
      int i1;
      int i2;
      int i;
      int j;
      int k;
      int m;
      if (paramArrayList != null)
      {
        paramMusicSongModel = (String)paramArrayList.get(0);
        this.c.a(paramMusicSongModel, paramArrayList);
        i.b("MusicPlayService", "---startPlay----path:" + paramMusicSongModel);
        if (this.d != 0) {
          break label320;
        }
        if (this.e.i == null)
        {
          paramArrayList = new MediaPlayer();
          n = 0;
          i1 = 0;
          i2 = 0;
          paramInt = 0;
          i = paramInt;
          j = n;
          k = i1;
          m = i2;
        }
      }
      try
      {
        paramArrayList.setDataSource(paramMusicSongModel);
        i = paramInt;
        j = n;
        k = i1;
        m = i2;
        paramArrayList.setAudioStreamType(3);
        i = paramInt;
        j = n;
        k = i1;
        m = i2;
        paramArrayList.prepare();
        i = paramInt;
        j = n;
        k = i1;
        m = i2;
        paramInt = paramArrayList.getDuration();
        i = paramInt;
        j = paramInt;
        k = paramInt;
        m = paramInt;
        paramArrayList.release();
      }
      catch (IllegalArgumentException paramMusicSongModel)
      {
        for (;;)
        {
          paramMusicSongModel.printStackTrace();
          paramInt = i;
        }
      }
      catch (SecurityException paramMusicSongModel)
      {
        for (;;)
        {
          paramMusicSongModel.printStackTrace();
          paramInt = j;
        }
      }
      catch (IllegalStateException paramMusicSongModel)
      {
        for (;;)
        {
          paramMusicSongModel.printStackTrace();
          paramInt = k;
        }
      }
      catch (IOException paramMusicSongModel)
      {
        for (;;)
        {
          paramMusicSongModel.printStackTrace();
          paramInt = m;
        }
      }
      this.e.i = String.valueOf(paramInt);
      for (;;)
      {
        if (this.f == null) {
          break label563;
        }
        this.f.a();
        return;
        this.c.a(paramMusicSongModel);
        break;
        if (this.d == 101)
        {
          c.a().a(1, j.a().c());
          if (j.a().g())
          {
            this.e.h("7200000");
          }
          else
          {
            if (this.e.n >= this.e.o)
            {
              paramArrayList = new MediaPlayer();
              n = 0;
              i1 = 0;
              i2 = 0;
              paramInt = 0;
              i = paramInt;
              j = n;
              k = i1;
              m = i2;
              try
              {
                paramArrayList.setDataSource(paramMusicSongModel);
                i = paramInt;
                j = n;
                k = i1;
                m = i2;
                paramArrayList.setAudioStreamType(3);
                i = paramInt;
                j = n;
                k = i1;
                m = i2;
                paramArrayList.prepare();
                i = paramInt;
                j = n;
                k = i1;
                m = i2;
                paramInt = paramArrayList.getDuration();
                i = paramInt;
                j = paramInt;
                k = paramInt;
                m = paramInt;
                paramArrayList.release();
              }
              catch (IllegalArgumentException paramMusicSongModel)
              {
                for (;;)
                {
                  paramMusicSongModel.printStackTrace();
                  paramInt = i;
                }
              }
              catch (SecurityException paramMusicSongModel)
              {
                for (;;)
                {
                  paramMusicSongModel.printStackTrace();
                  paramInt = j;
                }
              }
              catch (IllegalStateException paramMusicSongModel)
              {
                for (;;)
                {
                  paramMusicSongModel.printStackTrace();
                  paramInt = k;
                }
              }
              catch (IOException paramMusicSongModel)
              {
                for (;;)
                {
                  paramMusicSongModel.printStackTrace();
                  paramInt = m;
                }
              }
              this.e.i = String.valueOf(paramInt);
              continue;
            }
            this.e.i = "600000";
          }
        }
      }
    }
  }
  
  private void b()
  {
    this.c.x();
  }
  
  private void c()
  {
    this.c.G();
  }
  
  private void d()
  {
    this.c.H();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new a();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.c = a.a();
    this.g = new n(this.a);
  }
  
  public void onDestroy()
  {
    i.b("MusicPlayService", "-----MusicPlayService--onDestroy----");
    this.c.w();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  public class a
    extends Binder
  {
    public a() {}
    
    public void a()
    {
      MusicPlayService.a(MusicPlayService.this);
    }
    
    public void a(int paramInt)
    {
      MusicPlayService.a(MusicPlayService.this, paramInt);
    }
    
    public void a(int paramInt, MusicSongModel paramMusicSongModel)
    {
      a(paramInt, paramMusicSongModel, null);
    }
    
    public void a(int paramInt, MusicSongModel paramMusicSongModel, ArrayList<String> paramArrayList)
    {
      MusicPlayService.a(MusicPlayService.this, paramInt, paramMusicSongModel, paramArrayList);
    }
    
    public void a(m paramm)
    {
      MusicPlayService.a(MusicPlayService.this, paramm);
    }
    
    public void b()
    {
      MusicPlayService.b(MusicPlayService.this);
    }
    
    public void c()
    {
      MusicPlayService.c(MusicPlayService.this);
    }
    
    public void d()
    {
      MusicPlayService.d(MusicPlayService.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/service/MusicPlayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */