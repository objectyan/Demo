package com.baidu.carlife.util;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioTrack;
import com.baidu.carlife.l.a;
import java.io.InputStream;

public class n
{
  private static n d = null;
  private static final int e = 16000;
  private static final int f = 1;
  private static final int g = 16;
  private Context a = null;
  private byte[] b = new byte['⠀'];
  private InputStream c = null;
  
  public static n a()
  {
    if (d == null) {
      d = new n();
    }
    return d;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.c = this.a.getResources().openRawResource(paramInt);
      if ((a.a().N()) && (!a.a().J()))
      {
        if (a.a().C()) {
          a.a().B();
        }
        a.a().c(16000, 1, 16);
        for (;;)
        {
          paramInt = this.c.read(this.b);
          if (paramInt == -1) {
            break;
          }
          a.a().c(this.b, paramInt);
        }
        a.a().E();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    for (;;)
    {
      this.c.close();
      return;
      AudioTrack localAudioTrack = new AudioTrack(3, 16000, 4, 2, AudioTrack.getMinBufferSize(16000, 4, 2), 1);
      for (;;)
      {
        paramInt = this.c.read(this.b);
        if (paramInt == -1) {
          break;
        }
        if (localAudioTrack.getPlayState() != 3) {
          localAudioTrack.play();
        }
        localAudioTrack.write(this.b, 0, paramInt);
        localAudioTrack.flush();
      }
      localAudioTrack.release();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */