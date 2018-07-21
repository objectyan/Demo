package com.baidu.tts.b.b.b;

import android.media.AudioTrack;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.e;
import com.baidu.tts.f.k;
import com.baidu.tts.m.c;
import com.baidu.tts.m.h;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b
  extends a
{
  protected final Lock b = new ReentrantLock();
  protected final Condition c = this.b.newCondition();
  private volatile AudioTrack d;
  private a e;
  private com.baidu.tts.i.a.b f = new com.baidu.tts.i.a.b();
  private boolean g = false;
  private int h;
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    int j = AudioTrack.getMinBufferSize(paramInt1, paramInt2, paramInt3) * 2;
    switch (paramInt2)
    {
    default: 
      paramInt1 = Integer.bitCount(paramInt2);
    }
    for (;;)
    {
      paramInt2 = i;
      if (paramInt3 == 3) {
        paramInt2 = 1;
      }
      if ((j % (paramInt2 * paramInt1) == 0) && (j >= 1)) {
        break;
      }
      return 5120;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
    }
    return j;
  }
  
  private int b(int paramInt)
  {
    if (paramInt > this.h) {
      this.h = paramInt;
    }
    return this.h;
  }
  
  private void b(h paramh)
  {
    this.f.a(h());
    this.f.a();
    this.h = 0;
    d(paramh);
  }
  
  private void c(h paramh)
  {
    this.f.b();
    f(paramh);
  }
  
  private void d(h paramh)
  {
    if (this.a != null) {
      this.a.a(paramh);
    }
  }
  
  private void e(h paramh)
  {
    if (this.a != null) {
      this.a.b(paramh);
    }
  }
  
  private void f(h paramh)
  {
    if (this.a != null) {
      this.a.c(paramh);
    }
  }
  
  private void g()
  {
    try
    {
      this.b.lock();
      this.c.signalAll();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  private int h()
  {
    int i = this.e.h();
    return this.e.a() * 2 / i;
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    int i = this.d.setStereoVolume(paramFloat1, paramFloat2);
    this.e.a(paramFloat1);
    this.e.b(paramFloat2);
    return i;
  }
  
  public int a(int paramInt)
  {
    if (paramInt != this.e.g())
    {
      int i = this.e.a();
      int j = this.e.b();
      int k = this.e.c();
      int m = this.e.d();
      this.d = new AudioTrack(paramInt, i, j, k, a(i, j, k), m);
      this.e.a(paramInt);
      float f1 = this.e.e();
      float f2 = this.e.f();
      this.d.setStereoVolume(f1, f2);
      this.d.play();
    }
    return 0;
  }
  
  public TtsError a()
  {
    int i = this.e.a();
    int j = this.e.b();
    int k = this.e.c();
    int m = this.e.g();
    int n = this.e.d();
    this.d = new AudioTrack(m, i, j, k, a(i, j, k), n);
    float f1 = this.e.e();
    float f2 = this.e.f();
    this.d.setStereoVolume(f1, f2);
    return null;
  }
  
  public TtsError a(h paramh)
  {
    LoggerProxy.d("AudioTrackPlayer", "enter put");
    if (paramh != null)
    {
      Object localObject1 = paramh.g();
      if (localObject1 == e.a) {
        b(paramh);
      }
      if (localObject1 == e.c) {
        this.f.c(paramh.c());
      }
      byte[] arrayOfByte = paramh.d();
      if (arrayOfByte != null) {
        this.f.b(arrayOfByte.length);
      }
      int i;
      while (this.f.hasNext())
      {
        Object localObject2 = this.f.c();
        i = 0;
        int k = ((com.baidu.tts.i.a.a)localObject2).a();
        int m = ((com.baidu.tts.i.a.a)localObject2).b();
        int j;
        if ((i < m) && (this.d.getPlayState() != 1))
        {
          LoggerProxy.d("AudioTrackPlayer", "before write");
          int n = this.d.write(arrayOfByte, i + k, m - i);
          LoggerProxy.d("AudioTrackPlayer", "writtenbytes=" + n + "--offset=" + i + "--dataLength=" + m);
          j = i;
          if (n >= 0) {
            j = i + n;
          }
          for (;;)
          {
            i = j;
            if (!this.g) {
              break;
            }
            try
            {
              this.b.lock();
              LoggerProxy.d("AudioTrackPlayer", "await before" + System.currentTimeMillis());
              this.c.await();
              LoggerProxy.d("AudioTrackPlayer", "await after" + System.currentTimeMillis());
              this.b.unlock();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              this.b.unlock();
            }
            finally
            {
              this.b.unlock();
            }
          }
        }
        if (this.d.getPlayState() == 1) {
          return null;
        }
        if (((com.baidu.tts.i.a.a)localObject2).c())
        {
          i = paramh.c();
          float f1 = ((com.baidu.tts.i.a.a)localObject2).d();
          i = Math.round(i * f1);
          j = b(i);
          LoggerProxy.d("AudioTrackPlayer", "percent=" + f1 + "--currentProgress=" + i + "--progress=" + j);
          localObject2 = (h)paramh.B();
          ((h)localObject2).d(j);
          e((h)localObject2);
        }
      }
      if (localObject1 == e.b)
      {
        i = this.f.d();
        localObject1 = (h)paramh.B();
        ((h)localObject1).d(i);
        e((h)localObject1);
        c(paramh);
      }
    }
    for (;;)
    {
      LoggerProxy.d("AudioTrackPlayer", "end put");
      return null;
      LoggerProxy.d("AudioTrackPlayer", "put responseBag=null");
    }
  }
  
  public void a(com.baidu.tts.b.b.a parama)
  {
    this.a = parama;
  }
  
  public <AudioTrackPlayerParams> void a(AudioTrackPlayerParams paramAudioTrackPlayerParams)
  {
    this.e = ((a)paramAudioTrackPlayerParams);
  }
  
  public void b()
  {
    if (this.d != null) {
      this.d.play();
    }
  }
  
  public void c()
  {
    this.g = true;
    if (this.d != null) {
      this.d.pause();
    }
  }
  
  public void d()
  {
    this.g = false;
    if (this.d != null) {
      this.d.play();
    }
    g();
  }
  
  public void e()
  {
    if (this.g)
    {
      this.g = false;
      g();
    }
    if (this.d != null)
    {
      this.d.pause();
      this.d.flush();
      this.d.stop();
    }
  }
  
  public TtsError f()
  {
    e();
    if (this.d != null) {
      this.d.release();
    }
    this.d = null;
    return null;
  }
  
  public static class a
    extends c<a>
  {
    private k a = k.b;
    private int b = 4;
    private int c = 2;
    private int d = 1;
    private float e = 1.0F;
    private float f = 1.0F;
    
    public int a()
    {
      return this.a.a();
    }
    
    public void a(float paramFloat)
    {
      this.e = paramFloat;
    }
    
    public int b()
    {
      return this.b;
    }
    
    public void b(float paramFloat)
    {
      this.f = paramFloat;
    }
    
    public int c()
    {
      return this.c;
    }
    
    public int d()
    {
      return this.d;
    }
    
    public float e()
    {
      return this.e;
    }
    
    public float f()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/b/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */