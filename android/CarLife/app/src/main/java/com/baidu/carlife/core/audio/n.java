package com.baidu.carlife.core.audio;

import android.media.AudioTrack;
import android.os.Message;
import com.baidu.carlife.core.connect.a.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;

public class n
  extends f
{
  private static final String a = "Audio-" + n.class.getSimpleName();
  private o b = new o();
  private byte[] c = new byte[120];
  private int d;
  private boolean e = true;
  private AudioTrack f;
  private int g;
  private int h;
  private int i;
  private a j = new a(null);
  private int k;
  private p l = new p();
  private c m = new c();
  private byte[] n;
  private com.baidu.carlife.core.connect.a.b o = new com.baidu.carlife.core.connect.a.b();
  
  public n()
  {
    a.a();
    this.k = 12;
    com.baidu.carlife.core.k.a(this.j);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 4000) || (paramInt1 > 48000))
    {
      paramInt1 = 44100;
      if ((paramInt2 == 1) && (paramInt2 == 2)) {
        break label128;
      }
      paramInt2 = 2;
      label28:
      if ((paramInt3 == 8) && (paramInt3 == 16)) {
        break label131;
      }
      paramInt3 = 16;
    }
    label128:
    label131:
    for (;;)
    {
      this.b.c(196609);
      this.d = this.b.a(paramInt1, paramInt2, paramInt3, this.c);
      this.b.a(this.d);
      System.arraycopy(this.b.a(), 0, this.c, 0, this.k);
      k.a().a(this.c, this.k + this.d, a.d.a);
      return;
      break;
      break label28;
    }
  }
  
  private void h()
  {
    if (this.f != null)
    {
      this.f.stop();
      this.f.release();
      this.f = null;
    }
  }
  
  public void a()
  {
    try
    {
      i.b(a, "stop() is called");
      this.b.c(196610);
      this.b.a(0);
      k.a().a(this.b.a(), this.b.b(), a.d.b);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 164	com/baidu/carlife/core/audio/n:h	()V
    //   6: aload_0
    //   7: iload_1
    //   8: putfield 166	com/baidu/carlife/core/audio/n:g	I
    //   11: iload_2
    //   12: iconst_1
    //   13: if_icmpne +81 -> 94
    //   16: aload_0
    //   17: iconst_4
    //   18: putfield 168	com/baidu/carlife/core/audio/n:h	I
    //   21: iload_3
    //   22: bipush 8
    //   24: if_icmpne +86 -> 110
    //   27: aload_0
    //   28: iconst_3
    //   29: putfield 170	com/baidu/carlife/core/audio/n:i	I
    //   32: aload_0
    //   33: getfield 166	com/baidu/carlife/core/audio/n:g	I
    //   36: aload_0
    //   37: getfield 168	com/baidu/carlife/core/audio/n:h	I
    //   40: aload_0
    //   41: getfield 170	com/baidu/carlife/core/audio/n:i	I
    //   44: invokestatic 174	android/media/AudioTrack:getMinBufferSize	(III)I
    //   47: istore 4
    //   49: aload_0
    //   50: new 141	android/media/AudioTrack
    //   53: dup
    //   54: iconst_3
    //   55: aload_0
    //   56: getfield 166	com/baidu/carlife/core/audio/n:g	I
    //   59: iload_2
    //   60: iconst_2
    //   61: iload 4
    //   63: iconst_1
    //   64: invokespecial 177	android/media/AudioTrack:<init>	(IIIIII)V
    //   67: putfield 139	com/baidu/carlife/core/audio/n:f	Landroid/media/AudioTrack;
    //   70: aload_0
    //   71: getfield 139	com/baidu/carlife/core/audio/n:f	Landroid/media/AudioTrack;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 139	com/baidu/carlife/core/audio/n:f	Landroid/media/AudioTrack;
    //   81: invokevirtual 180	android/media/AudioTrack:play	()V
    //   84: aload_0
    //   85: iload_1
    //   86: iload_2
    //   87: iload_3
    //   88: invokespecial 182	com/baidu/carlife/core/audio/n:b	(III)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: aload_0
    //   95: bipush 12
    //   97: putfield 168	com/baidu/carlife/core/audio/n:h	I
    //   100: goto -79 -> 21
    //   103: astore 5
    //   105: aload_0
    //   106: monitorexit
    //   107: aload 5
    //   109: athrow
    //   110: aload_0
    //   111: iconst_2
    //   112: putfield 170	com/baidu/carlife/core/audio/n:i	I
    //   115: goto -83 -> 32
    //   118: astore 5
    //   120: aload 5
    //   122: invokevirtual 185	java/lang/Exception:printStackTrace	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 139	com/baidu/carlife/core/audio/n:f	Landroid/media/AudioTrack;
    //   130: goto -46 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	n
    //   0	133	1	paramInt1	int
    //   0	133	2	paramInt2	int
    //   0	133	3	paramInt3	int
    //   47	15	4	i1	int
    //   103	5	5	localObject	Object
    //   118	3	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	103	finally
    //   16	21	103	finally
    //   27	32	103	finally
    //   32	49	103	finally
    //   49	84	103	finally
    //   84	91	103	finally
    //   94	100	103	finally
    //   110	115	103	finally
    //   120	130	103	finally
    //   49	84	118	java/lang/Exception
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    label270:
    for (;;)
    {
      try
      {
        if (this.n == null) {
          this.n = new byte[paramInt];
        }
        if (this.n.length < paramInt) {
          this.n = new byte[paramInt];
        }
        if (!a.a().g())
        {
          byte[] arrayOfByte2;
          if (!a.h())
          {
            break label270;
            if ((this.f != null) && (this.f.getPlayState() == 3)) {
              this.f.write(arrayOfByte1, 0, paramInt);
            }
            if ((a.h()) && (this.e))
            {
              b(this.g, this.h, this.i);
              this.e = false;
            }
            arrayOfByte1 = paramArrayOfByte;
            int i1 = paramInt;
            arrayOfByte2 = arrayOfByte1;
            i2 = i1;
            if (!e.a().c()) {
              continue;
            }
            arrayOfByte2 = arrayOfByte1;
            i2 = i1;
            if (paramInt <= 0) {
              continue;
            }
            arrayOfByte2 = this.o.a(paramArrayOfByte, paramInt);
            if (arrayOfByte2 == null) {
              i.e(a, "encrypt failed!");
            }
          }
          else
          {
            arrayOfByte1 = this.n;
            continue;
          }
          int i2 = arrayOfByte2.length;
          this.b.c(196614);
          this.b.a(i2);
          this.b.c();
          this.m.a(this.b.a(), this.k, arrayOfByte2, i2, this.l);
          k.a().a(this.l.a(), this.l.b(), a.d.f);
          continue;
        }
        byte[] arrayOfByte1 = paramArrayOfByte;
      }
      finally {}
    }
  }
  
  public void b()
  {
    try
    {
      i.b(a, "pause() is called");
      this.b.c(196611);
      this.b.a(0);
      k.a().a(this.b.a(), this.b.b(), a.d.c);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void c()
  {
    try
    {
      b.a().b();
      i.b(a, "PCMMedia play() is called");
      this.b.c(196612);
      this.b.a(0);
      k.a().a(this.b.a(), this.b.b(), a.d.d);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(1002);
      addMsg(1004);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 1003: 
      case 1004: 
      default: 
        return;
      }
      a.a().b();
      a.a().e();
      n.a(n.this, true);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */