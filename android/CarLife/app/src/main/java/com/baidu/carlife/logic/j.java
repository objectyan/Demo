package com.baidu.carlife.logic;

import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.navi.util.StatisticManager;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.List;

public class j
  extends e
{
  public static final int b = -1000;
  private static final String c = "MP3DownLoadThread";
  private List<MusicSongModel> d = null;
  private MusicSongModel e;
  private f f;
  
  public j(List<MusicSongModel> paramList)
  {
    this.d = paramList;
    this.f = new a(this);
  }
  
  private void g()
  {
    a(true);
    try
    {
      String str = this.e.m;
      this.f.a(str, this.e.b);
      return;
    }
    catch (IOException localIOException)
    {
      i.b("MP3DownLoadThread", "downloadSimpleSong fail");
      localIOException.printStackTrace();
      this.e.n = -1000L;
    }
  }
  
  private void h()
  {
    long l = this.e.m();
    if ((l > 0L) && (this.e.q > 0))
    {
      while (l > 17999999L)
      {
        StatisticManager.onEventDuration(a.a(), "FM_FLOW_0001", "FM_FLOW_0001", 17999999);
        if (com.baidu.carlife.core.e.s() == 1) {
          StatisticManager.onEventDuration(a.a(), "FM_FLOW_0002", "FM_FLOW_0002", 17999999);
        }
        l -= 17999999L;
      }
      if (l > 0L)
      {
        StatisticManager.onEventDuration(a.a(), "FM_FLOW_0001", "FM_FLOW_0001", (int)l);
        if (com.baidu.carlife.core.e.s() == 1) {
          StatisticManager.onEventDuration(a.a(), "FM_FLOW_0002", "FM_FLOW_0002", (int)l);
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    this.e.o = paramInt;
  }
  
  void a(RandomAccessFile paramRandomAccessFile)
  {
    if (this.e.n > 0L) {}
    try
    {
      paramRandomAccessFile.seek(this.e.n);
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      i.b("MP3DownLoadThread", "seek fail");
      paramRandomAccessFile.printStackTrace();
    }
  }
  
  void a(HttpURLConnection paramHttpURLConnection)
  {
    if (this.e.n > 0L) {
      paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.e.n + "-");
    }
  }
  
  void b(int paramInt)
  {
    MusicSongModel localMusicSongModel = this.e;
    localMusicSongModel.n += paramInt;
  }
  
  protected boolean e()
  {
    return (this.d == null) || (this.d.isEmpty());
  }
  
  protected boolean f()
  {
    return (this.e == null) || (this.e.m == null) || (this.e.m.isEmpty());
  }
  
  public void run()
  {
    for (;;)
    {
      if (d())
      {
        if (!e())
        {
          b(false);
          this.e = ((MusicSongModel)this.d.get(this.d.size() - 1));
          if (f()) {
            this.d.remove(this.d.size() - 1);
          } else {
            g();
          }
        }
      }
      else {
        c(300);
      }
    }
  }
  
  private class a
    extends f
  {
    public a(w paramw)
    {
      super();
    }
    
    void a(String paramString)
      throws IOException
    {
      if (j.a(j.this).n >= j.a(j.this).o)
      {
        i.b("MP3DownLoadThread", "download complete");
        k.a(217, 2, j.a(j.this));
      }
      j.b(j.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */