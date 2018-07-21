package com.baidu.carlife.l;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.audio.f;
import com.baidu.carlife.core.audio.h;
import com.baidu.carlife.core.audio.m;
import com.baidu.carlife.core.audio.n;
import com.baidu.carlife.core.audio.o;
import com.baidu.carlife.core.audio.q;
import com.baidu.carlife.core.i;
import java.util.ArrayList;

public class b
{
  private static final String a = "Audio-" + b.class.getSimpleName();
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 7;
  private static b i;
  private static final String q = "AUDIO_CALL_HANDLER_THREAD_NAME";
  private f j = new h();
  private f k = new n();
  private f l = new m();
  private f m = new q();
  private com.baidu.carlife.core.audio.b n = com.baidu.carlife.core.audio.b.a();
  private a o = null;
  private HandlerThread p = null;
  private boolean r = false;
  private boolean s = false;
  private Context t = com.baidu.carlife.core.a.a().getApplicationContext();
  
  private b()
  {
    this.n.a(this.t);
  }
  
  public static b a()
  {
    if (i == null) {
      i = new b();
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    com.baidu.carlife.core.audio.a.a().b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext)
  {
    if (!Build.MODEL.equals("MI 3")) {
      return;
    }
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    int i1 = paramContext.getStreamVolume(3);
    i.b(a, "current media volume: " + i1);
    if (i1 <= 2) {
      paramContext.setStreamVolume(3, 2, 0);
    }
    i1 = paramContext.getStreamVolume(3);
    i.b(a, "set media volume: " + i1);
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", paramString);
    localBundle.putStringArrayList("fileList", paramArrayList);
    localMessage.setData(localBundle);
    this.o.removeMessages(1);
    this.o.sendMessage(localMessage);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.k.a(paramArrayOfByte, paramInt);
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    o localo = new o();
    localo.c(paramInt1);
    localo.a(paramInt2);
    return localo.a();
  }
  
  public void b(int paramInt)
  {
    com.baidu.carlife.core.audio.a.a().a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.r = true;
    if (com.baidu.carlife.core.audio.a.h()) {
      this.l.a(paramInt1, paramInt2, paramInt3);
    }
    i.b(a, "receive TTS init command sampleRate:" + paramInt1 + " channelConfig:" + paramInt2 + " sampleFormat:" + paramInt3);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    this.l.a(paramArrayOfByte, paramInt);
  }
  
  public boolean b()
  {
    if (this.p == null)
    {
      this.p = new HandlerThread("AUDIO_CALL_HANDLER_THREAD_NAME");
      this.p.start();
    }
    this.o = new a(this.p.getLooper());
    return true;
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = true;
    if (com.baidu.carlife.core.audio.a.h()) {
      this.m.a(paramInt1, paramInt2, paramInt3);
    }
    i.b(a, "receive VR init command sampleRate:" + paramInt1 + " channelConfig:" + paramInt2 + " sampleFormat:" + paramInt3);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt)
  {
    this.m.a(paramArrayOfByte, paramInt);
  }
  
  public boolean c()
  {
    f();
    if (this.p != null)
    {
      this.p.quit();
      this.p = null;
    }
    return true;
  }
  
  public void d()
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    this.o.sendMessage(localMessage);
  }
  
  public void e()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    this.o.sendMessage(localMessage);
  }
  
  public void f()
  {
    Message localMessage = new Message();
    localMessage.what = 4;
    this.o.sendMessage(localMessage);
  }
  
  public void g()
  {
    this.k.a();
  }
  
  public void h()
  {
    this.k.c();
  }
  
  public void i()
  {
    this.k.b();
  }
  
  public void j()
  {
    this.r = false;
    if (com.baidu.carlife.core.audio.a.h()) {
      this.l.a();
    }
    i.b(a, "receive TTS stop command");
  }
  
  public boolean k()
  {
    return this.r;
  }
  
  public void l()
  {
    this.s = false;
    if (com.baidu.carlife.core.audio.a.h()) {
      this.m.a();
    }
    i.b(a, "receive VR stop command");
  }
  
  public boolean m()
  {
    return this.s;
  }
  
  public void n()
  {
    i.b(a, "send command: MSG_CMD_GET_AUDIO_FOCUS");
  }
  
  public void o()
  {
    Message localMessage = new Message();
    localMessage.what = 5;
    this.o.sendMessage(localMessage);
  }
  
  public void p() {}
  
  public void q()
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    this.o.sendMessage(localMessage);
  }
  
  public void r()
  {
    this.n.a(true);
  }
  
  public boolean s()
  {
    return com.baidu.carlife.core.audio.a.a().g();
  }
  
  public boolean t()
  {
    return com.baidu.carlife.core.audio.a.a().d();
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
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        String str = paramMessage.getData().getString("filePath");
        paramMessage = paramMessage.getData().getStringArrayList("fileList");
        b.a(b.this).a(str, paramMessage);
        return;
      case 2: 
        b.a(b.this).b();
        return;
      case 3: 
        b.a(b.this).c();
        return;
      case 4: 
        b.a(b.this).a();
        return;
      case 5: 
        b.a(b.this).e();
        return;
      case 6: 
        b.a(b.this).f();
        return;
      }
      b.a(b.this).g();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */