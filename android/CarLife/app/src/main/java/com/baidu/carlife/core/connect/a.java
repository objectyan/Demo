package com.baidu.carlife.core.connect;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class a
  implements h
{
  private static final int L = 100;
  public static final int a = 500;
  private static final String b = "AOAConnectManager";
  private static a c = null;
  private static final String k = "AOAReadThread";
  private static final String l = "SocketReadThread";
  private static final String m = "127.0.0.1";
  private static final int n = 100;
  private static final int o = 8;
  private static final int p = 4096;
  private static final int q = 327680;
  private static final int r = 327680;
  private static int s = 0;
  private static int t = 10240;
  private static final int u = 163840;
  private static final int x = 16384;
  private static final int y = 67108864;
  private b A = null;
  private b B = null;
  private b C = null;
  private b D = null;
  private b E = null;
  private b F = null;
  private b G = null;
  private Timer H = null;
  private TimerTask I = null;
  private int J = 0;
  private int K = -1;
  private Context d = null;
  private UsbManager e = null;
  private UsbAccessory f = null;
  private ParcelFileDescriptor g = null;
  private FileDescriptor h = null;
  private FileOutputStream i = null;
  private FileInputStream j = null;
  private Thread v = null;
  private Thread w = null;
  private a z = null;
  
  public static a a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new a();
      }
      return c;
    }
    finally {}
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt)
  {
    int i1;
    do
    {
      try
      {
        if (this.j == null)
        {
          i.e("AOAConnectManager", "mFin is null");
          throw new IOException();
        }
      }
      catch (Exception paramArrayOfByte)
      {
        i.e("AOAConnectManager", "bulkTransferIn catch exception");
        d.a().a(false);
        paramArrayOfByte.printStackTrace();
        i2 = -1;
        return i2;
      }
      int i2 = paramInt;
      i1 = 0;
      while (i2 > 0)
      {
        int i3 = this.j.read(paramArrayOfByte, i1, 16384);
        if (i3 > 0)
        {
          i2 -= i3;
          i1 += i3;
        }
        else
        {
          i.e("AOAConnectManager", "bulkTransferIn error 1: ret = " + i3);
          throw new IOException();
        }
      }
      i2 = i1;
    } while (i1 == paramInt);
    i.e("AOAConnectManager", "bulkTransferIn error 3: dataLen = " + i1 + ", len = " + paramInt);
    throw new IOException();
  }
  
  private String j()
  {
    if (s >= t) {
      return null;
    }
    char c1 = (char)(s % 26 + 97);
    Object localObject = "Msg Num:" + Integer.toString(s);
    int i2 = ((String)localObject).length();
    localObject = new StringBuffer((String)localObject);
    int i1 = 0;
    while (i1 < 163840 - i2)
    {
      ((StringBuffer)localObject).append(c1);
      i1 += 1;
    }
    s += 1;
    return ((StringBuffer)localObject).substring(0);
  }
  
  private void k()
  {
    this.w = new Thread()
    {
      public void run()
      {
        i = -1;
        long l1 = SystemClock.elapsedRealtime();
        try
        {
          for (;;)
          {
            Object localObject = a.k(a.this);
            if (localObject == null) {}
            for (;;)
            {
              label20:
              long l2 = SystemClock.elapsedRealtime();
              i.e("AOAConnectManager", "Cnt = " + i);
              i.e("AOAConnectManager", "Write Time = " + (l2 - l1));
              return;
              i.b("AOAConnectManager", "write data: " + ((String)localObject).substring(0, 20));
              localObject = ((String)localObject).getBytes();
              int j = a.this.a((byte[])localObject, 163840);
              if (j >= 0) {
                break;
              }
              i.e("AOAConnectManager", "write data error, ret = " + j);
            }
            try
            {
              a.l(a.this).close();
              i.e("AOAConnectManager", "get exception when write");
              i.e("AOAConnectManager", localException.toString());
              localException.printStackTrace();
              break label20;
              i += 1;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                localIOException.printStackTrace();
              }
            }
          }
        }
        catch (Exception localException) {}
      }
    };
    this.w.setName("WriteThread");
    this.w.start();
  }
  
  private void l()
  {
    this.v = new Thread()
    {
      public void run()
      {
        try
        {
          i.e("AOAConnectManager", "sleep 1s before read...");
          sleep(1000L);
          arrayOfByte = new byte[163840];
          i = -1;
          l1 = SystemClock.elapsedRealtime();
          Object localObject = null;
        }
        catch (InterruptedException localInterruptedException)
        {
          try
          {
            byte[] arrayOfByte;
            long l1;
            for (;;)
            {
              j = a.a(a.this, arrayOfByte, 163840);
              if (j == 163840) {
                break;
              }
              i.e("AOAConnectManager", "read data error, ret = " + j);
              return;
              localInterruptedException = localInterruptedException;
              localInterruptedException.printStackTrace();
            }
            i += 1;
            if (i >= a.i())
            {
              long l2 = SystemClock.elapsedRealtime();
              i.e("AOAConnectManager", "Read Time = " + (l2 - l1));
            }
            str = new String(arrayOfByte);
          }
          catch (Exception localException1)
          {
            try
            {
              int i;
              int j;
              String str;
              i.b("AOAConnectManager", "read data:" + i + ":" + j + ":" + str.substring(0, 20));
            }
            catch (Exception localException2)
            {
              for (;;) {}
            }
            localException1 = localException1;
          }
        }
        i.e("AOAConnectManager", "get exception when read");
        i.e("AOAConnectManager", localException1.toString());
        localException1.printStackTrace();
      }
    };
    this.v.setName("ReadThread");
    this.v.start();
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.i == null)
      {
        i.e("AOAConnectManager", "mFin is null");
        throw new IOException();
      }
    }
    catch (Exception paramArrayOfByte)
    {
      i.e("AOAConnectManager", "bulkTransferOut catch exception");
      d.a().a(false);
      paramArrayOfByte.printStackTrace();
      return -1;
    }
    this.i.write(paramArrayOfByte, 0, paramInt);
    return paramInt;
  }
  
  public int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i1 = -1;
    for (;;)
    {
      try
      {
        this.J += 1;
        this.J %= 65536;
        if (a(paramArrayOfByte1, paramInt1) < 0)
        {
          i.e("AOAConnectManager", "bulkTransferOut fail 1");
          paramInt1 = i1;
          return paramInt1;
        }
        if (a(paramArrayOfByte2, paramInt2) < 0)
        {
          i.e("AOAConnectManager", "bulkTransferOut fail 2");
          paramInt1 = i1;
        }
        else
        {
          paramInt1 += paramInt2;
        }
      }
      finally {}
    }
  }
  
  public void a(Context paramContext, UsbAccessory paramUsbAccessory)
  {
    i.e("AOAConnectManager", "init");
    this.d = paramContext;
    this.e = ((UsbManager)this.d.getSystemService("usb"));
    this.f = paramUsbAccessory;
    if (this.f == null)
    {
      i.e("AOAConnectManager", "mUsbAccessory is null");
      return;
    }
    if (!d.a().d())
    {
      i.e("AOAConnectManager", "usb is not connected");
      return;
    }
    try
    {
      this.g = this.e.openAccessory(this.f);
      this.h = this.g.getFileDescriptor();
      this.i = new FileOutputStream(this.h);
      this.j = new FileInputStream(this.h);
      e.a().a(2);
      e();
      c();
      return;
    }
    catch (Exception paramContext)
    {
      i.e("AOAConnectManager", "get fd fail");
      paramContext.printStackTrace();
    }
  }
  
  public void b()
  {
    i.e("AOAConnectManager", "uninit");
    try
    {
      if (this.i != null)
      {
        this.i.close();
        this.i = null;
      }
      if (this.j != null)
      {
        this.j.close();
        this.j = null;
      }
      if (this.g != null)
      {
        this.g.close();
        this.g = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i.e("AOAConnectManager", "uninit fail");
      }
    }
    this.f = null;
    this.h = null;
    e.a().a(1);
    f();
    d();
  }
  
  public void c()
  {
    try
    {
      this.z = new a();
      this.z.start();
      return;
    }
    catch (Exception localException)
    {
      i.e("AOAConnectManager", "Start AOAReadThread Fail");
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    try
    {
      if (this.z != null)
      {
        this.z.a();
        this.z = null;
      }
      return;
    }
    catch (Exception localException)
    {
      i.e("AOAConnectManager", "Stop AOAReadThread Fail");
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    try
    {
      this.A = new b(7240, "Cmd");
      this.A.start();
      this.B = new b(8240, "Video");
      this.B.start();
      this.C = new b(9240, "Media");
      this.C.start();
      this.D = new b(9241, "TTS");
      this.D.start();
      this.E = new b(9242, "VR");
      this.E.start();
      this.F = new b(9340, "Touch");
      this.F.start();
      this.G = new b(9440, "Data");
      this.G.start();
      return;
    }
    catch (Exception localException)
    {
      i.e("AOAConnectManager", "Start Read Thread Fail");
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    try
    {
      if (this.A != null)
      {
        this.A.a();
        this.A = null;
      }
      if (this.B != null)
      {
        this.B.a();
        this.B = null;
      }
      if (this.C != null)
      {
        this.C.a();
        this.C = null;
      }
      if (this.D != null)
      {
        this.D.a();
        this.D = null;
      }
      if (this.E != null)
      {
        this.E.a();
        this.E = null;
      }
      if (this.F != null)
      {
        this.F.a();
        this.F = null;
      }
      if (this.G != null)
      {
        this.G.a();
        this.G = null;
      }
      return;
    }
    catch (Exception localException)
    {
      i.e("AOAConnectManager", "Stop Read Thread Fail");
      localException.printStackTrace();
    }
  }
  
  public void g()
  {
    try
    {
      i.e("AOAConnectManager", "start timer");
      this.J = 0;
      this.K = -1;
      this.H = new Timer();
      this.I = new TimerTask()
      {
        public void run()
        {
          i.e("AOAConnectManager", "timeout 1");
          if (a.h(a.this) != null)
          {
            i.e("AOAConnectManager", "timeout 2");
            i.c("AOAConnectManager", "numOfHeartBeat = " + a.i(a.this) + ", oldNumOfHeartBeat = " + a.j(a.this));
            if (a.j(a.this) == a.i(a.this))
            {
              d.a().a(false);
              a.this.h();
            }
            a.a(a.this, a.i(a.this));
          }
        }
      };
      this.H.schedule(this.I, 1500L, 500L);
      return;
    }
    catch (Exception localException)
    {
      i.e("AOAConnectManager", "start timer get exception");
      localException.printStackTrace();
    }
  }
  
  public void h()
  {
    i.e("AOAConnectManager", "timer Stop");
    if (this.H != null)
    {
      this.H.cancel();
      this.H = null;
    }
    if (this.I != null)
    {
      this.I.cancel();
      this.I = null;
    }
    this.J = 0;
    this.K = -1;
  }
  
  private class a
    extends Thread
  {
    private boolean b = false;
    private byte[] c = new byte['䀀'];
    private byte[] d = new byte['䀀'];
    private int e = -1;
    private int f = -1;
    private int g = 0;
    private int h = -1;
    
    public a()
    {
      i.b("AOAConnectManager", "ReadThread Created");
      setName("AOAReadThread");
    }
    
    public void a()
    {
      this.b = false;
    }
    
    public void run()
    {
      this.b = true;
      i.b("AOAConnectManager", "Begin to read data by AOA");
      for (;;)
      {
        try
        {
          sleep(100L);
          if (this.b)
          {
            if (!this.b) {
              i.e("AOAConnectManager", "read data cancled");
            }
          }
          else
          {
            a.this.b();
            return;
          }
          if (a.a(a.this, this.d, 8) < 0)
          {
            i.e("AOAConnectManager", "bulkTransferIn fail 1");
            continue;
          }
        }
        catch (Exception localException)
        {
          i.e("AOAConnectManager", "Exception when read data by AOA");
          localException.printStackTrace();
          return;
        }
        tmp90_88[0] = this.d[0];
        byte[] tmp99_90 = tmp90_88;
        tmp99_90[1] = this.d[1];
        byte[] tmp108_99 = tmp99_90;
        tmp108_99[2] = this.d[2];
        byte[] tmp117_108 = tmp108_99;
        tmp117_108[3] = this.d[3];
        this.e = b.b(tmp117_108);
        this.f = b.b(new byte[] { this.d[4], this.d[5], this.d[6], this.d[7] });
        i.b("AOAConnectManager", "typeMsg = " + this.e + ", lenMsg = " + this.f);
        int i = 6;
        if (f.jw) {
          i = 7;
        }
        if ((this.e < 1) || (this.e > i) || (this.f < 0) || (this.f > 67108864))
        {
          i.e("AOAConnectManager", "typeMsg or lenMsg is error");
          d.a().a(false);
        }
        else
        {
          if (this.c.length < this.f) {
            this.c = new byte[this.f];
          }
          if (a.a(a.this, this.c, this.f) < 0)
          {
            i.e("AOAConnectManager", "bulkTransferIn fail 2");
          }
          else
          {
            this.h = -1;
            if (this.b)
            {
              this.g += 1;
              if (this.g < 100) {
                break;
              }
              i.e("AOAConnectManager", "write data to socket fail...retry");
              this.g = 0;
              this.b = false;
            }
          }
        }
      }
      switch (this.e)
      {
      }
      for (;;)
      {
        i.e("AOAConnectManager", "AOAReadThread typeMsg error");
        this.b = false;
        for (;;)
        {
          if (this.h >= 0) {
            break label638;
          }
          sleep(100L);
          break;
          this.h = a.a(a.this).b(this.c, 0, this.f);
          continue;
          this.h = a.b(a.this).b(this.c, 0, this.f);
          continue;
          this.h = a.c(a.this).b(this.c, 0, this.f);
          continue;
          this.h = a.d(a.this).b(this.c, 0, this.f);
          continue;
          this.h = a.e(a.this).b(this.c, 0, this.f);
          continue;
          this.h = a.f(a.this).b(this.c, 0, this.f);
          continue;
          this.h = a.g(a.this).b(this.c, 0, this.f);
        }
        label638:
        this.g = 0;
        break;
      }
    }
  }
  
  private class b
    extends Thread
  {
    InetAddress a = null;
    private boolean c = false;
    private int d = -1;
    private String e = null;
    private String f = null;
    private Socket g = null;
    private BufferedInputStream h = null;
    private BufferedOutputStream i = null;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private byte[] m = new byte[12];
    private byte[] n = new byte[8];
    private int o = 0;
    
    public b(int paramInt, String paramString)
    {
      try
      {
        this.f = (paramString + "SocketReadThread");
        setName(this.f);
        i.b("AOAConnectManager", "Create " + this.f);
        this.d = paramInt;
        this.e = paramString;
        this.c = true;
        if (this.e.equals("Cmd"))
        {
          System.arraycopy(b.a(1), 0, this.n, 0, 4);
          return;
        }
        if (this.e.equals("Video"))
        {
          System.arraycopy(b.a(2), 0, this.n, 0, 4);
          return;
        }
      }
      catch (Exception this$1)
      {
        i.e("AOAConnectManager", "Create " + this.f + " fail");
        a.this.printStackTrace();
        return;
      }
      if (this.e.equals("Media"))
      {
        System.arraycopy(b.a(3), 0, this.n, 0, 4);
        return;
      }
      if (this.e.equals("TTS"))
      {
        System.arraycopy(b.a(4), 0, this.n, 0, 4);
        return;
      }
      if (this.e.equals("VR"))
      {
        System.arraycopy(b.a(5), 0, this.n, 0, 4);
        return;
      }
      if (this.e.equals("Touch"))
      {
        System.arraycopy(b.a(6), 0, this.n, 0, 4);
        return;
      }
      if (this.e.equals("Data")) {
        System.arraycopy(b.a(7), 0, this.n, 0, 4);
      }
    }
    
    public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i3 = -1;
      int i1 = i3;
      int i2;
      do
      {
        try
        {
          if (this.h == null) {
            break;
          }
          int i4 = paramInt2;
          i2 = 0;
          while (i4 > 0)
          {
            i1 = i3;
            i3 = this.h.read(paramArrayOfByte, paramInt1 + i2, i4);
            if (i3 > 0)
            {
              i4 -= i3;
              i2 += i3;
            }
            else
            {
              i1 = i3;
              i.e("AOAConnectManager", this.e + " Receive Data Error: ret = " + i3);
              i1 = i3;
              throw new IOException();
            }
          }
        }
        catch (Exception paramArrayOfByte)
        {
          i.e("AOAConnectManager", this.e + " IOException, Receive Data Fail");
          d.a().a(false);
          paramArrayOfByte.printStackTrace();
          paramInt1 = i1;
          return paramInt1;
        }
        paramInt1 = i2;
      } while (i2 == paramInt2);
      i1 = i3;
      i.e("AOAConnectManager", this.e + " Receive Data Error: dataLen = " + i2);
      i1 = i3;
      throw new IOException();
      i1 = i3;
      i.e("AOAConnectManager", this.e + " Receive Data Fail, mInputStream is null");
      i1 = i3;
      throw new IOException();
    }
    
    public void a()
    {
      try
      {
        if (this.g != null)
        {
          this.g.close();
          this.g = null;
        }
        if (this.h != null)
        {
          this.h.close();
          this.h = null;
        }
        if (this.i != null)
        {
          this.i.close();
          this.i = null;
        }
        this.c = false;
        return;
      }
      catch (Exception localException)
      {
        i.e("AOAConnectManager", "Close " + this.f + " fail");
        localException.printStackTrace();
      }
    }
    
    public int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        if (this.i != null)
        {
          this.i.write(paramArrayOfByte, paramInt1, paramInt2);
          this.i.flush();
          return paramInt2;
        }
        i.e("AOAConnectManager", this.e + " Send Data Fail, mOutputStream is null");
        throw new IOException();
      }
      catch (Exception paramArrayOfByte)
      {
        i.e("AOAConnectManager", this.e + " IOException, Send Data Fail");
        paramArrayOfByte.printStackTrace();
      }
      return -1;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 43	com/baidu/carlife/core/connect/a$b:c	Z
      //   4: ifeq +72 -> 76
      //   7: ldc2_w 184
      //   10: invokestatic 189	com/baidu/carlife/core/connect/a$b:sleep	(J)V
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 67	com/baidu/carlife/core/connect/a$b:o	I
      //   18: iconst_1
      //   19: iadd
      //   20: putfield 67	com/baidu/carlife/core/connect/a$b:o	I
      //   23: ldc 86
      //   25: new 69	java/lang/StringBuilder
      //   28: dup
      //   29: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   32: ldc -65
      //   34: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: aload_0
      //   38: getfield 67	com/baidu/carlife/core/connect/a$b:o	I
      //   41: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   44: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   47: invokestatic 93	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   50: aload_0
      //   51: getfield 67	com/baidu/carlife/core/connect/a$b:o	I
      //   54: bipush 100
      //   56: if_icmplt +59 -> 115
      //   59: ldc 86
      //   61: ldc -63
      //   63: invokestatic 93	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   66: aload_0
      //   67: iconst_0
      //   68: putfield 67	com/baidu/carlife/core/connect/a$b:o	I
      //   71: aload_0
      //   72: iconst_0
      //   73: putfield 43	com/baidu/carlife/core/connect/a$b:c	Z
      //   76: aload_0
      //   77: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   80: ifnull +27 -> 107
      //   83: aload_0
      //   84: getfield 43	com/baidu/carlife/core/connect/a$b:c	Z
      //   87: ifeq +20 -> 107
      //   90: aload_0
      //   91: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   94: invokevirtual 197	java/net/Socket:isConnected	()Z
      //   97: ifne +188 -> 285
      //   100: ldc 86
      //   102: ldc -57
      //   104: invokestatic 118	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   107: aload_0
      //   108: getfield 36	com/baidu/carlife/core/connect/a$b:b	Lcom/baidu/carlife/core/connect/a;
      //   111: invokevirtual 201	com/baidu/carlife/core/connect/a:b	()V
      //   114: return
      //   115: aload_0
      //   116: ldc -53
      //   118: invokestatic 209	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   121: putfield 41	com/baidu/carlife/core/connect/a$b:a	Ljava/net/InetAddress;
      //   124: aload_0
      //   125: new 162	java/net/Socket
      //   128: dup
      //   129: aload_0
      //   130: getfield 41	com/baidu/carlife/core/connect/a$b:a	Ljava/net/InetAddress;
      //   133: aload_0
      //   134: getfield 45	com/baidu/carlife/core/connect/a$b:d	I
      //   137: invokespecial 212	java/net/Socket:<init>	(Ljava/net/InetAddress;I)V
      //   140: putfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   143: aload_0
      //   144: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   147: ifnull +33 -> 180
      //   150: ldc 86
      //   152: new 69	java/lang/StringBuilder
      //   155: dup
      //   156: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   159: ldc -42
      //   161: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: aload_0
      //   165: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   168: invokevirtual 215	java/net/Socket:toString	()Ljava/lang/String;
      //   171: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: invokestatic 93	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   180: aload_0
      //   181: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   184: iconst_1
      //   185: invokevirtual 218	java/net/Socket:setTcpNoDelay	(Z)V
      //   188: aload_0
      //   189: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   192: ldc -37
      //   194: invokevirtual 223	java/net/Socket:setSendBufferSize	(I)V
      //   197: aload_0
      //   198: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   201: ldc -37
      //   203: invokevirtual 226	java/net/Socket:setReceiveBufferSize	(I)V
      //   206: aload_0
      //   207: new 135	java/io/BufferedInputStream
      //   210: dup
      //   211: aload_0
      //   212: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   215: invokevirtual 230	java/net/Socket:getInputStream	()Ljava/io/InputStream;
      //   218: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   221: putfield 53	com/baidu/carlife/core/connect/a$b:h	Ljava/io/BufferedInputStream;
      //   224: aload_0
      //   225: new 168	java/io/BufferedOutputStream
      //   228: dup
      //   229: aload_0
      //   230: getfield 51	com/baidu/carlife/core/connect/a$b:g	Ljava/net/Socket;
      //   233: invokevirtual 237	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   236: invokespecial 240	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   239: putfield 55	com/baidu/carlife/core/connect/a$b:i	Ljava/io/BufferedOutputStream;
      //   242: goto -166 -> 76
      //   245: astore_1
      //   246: ldc 86
      //   248: new 69	java/lang/StringBuilder
      //   251: dup
      //   252: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   255: ldc 88
      //   257: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   260: aload_0
      //   261: getfield 49	com/baidu/carlife/core/connect/a$b:f	Ljava/lang/String;
      //   264: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   267: ldc -14
      //   269: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   272: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   275: invokestatic 118	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   278: aload_1
      //   279: invokevirtual 121	java/lang/Exception:printStackTrace	()V
      //   282: goto -282 -> 0
      //   285: aload_0
      //   286: getfield 47	com/baidu/carlife/core/connect/a$b:e	Ljava/lang/String;
      //   289: ldc 95
      //   291: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   294: ifne +27 -> 321
      //   297: aload_0
      //   298: getfield 47	com/baidu/carlife/core/connect/a$b:e	Ljava/lang/String;
      //   301: ldc -127
      //   303: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   306: ifne +15 -> 321
      //   309: aload_0
      //   310: getfield 47	com/baidu/carlife/core/connect/a$b:e	Ljava/lang/String;
      //   313: ldc -125
      //   315: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   318: ifeq +266 -> 584
      //   321: aload_0
      //   322: aload_0
      //   323: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   326: iconst_0
      //   327: bipush 8
      //   329: invokevirtual 244	com/baidu/carlife/core/connect/a$b:a	([BII)I
      //   332: iflt -225 -> 107
      //   335: aload_0
      //   336: bipush 8
      //   338: putfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   341: aload_0
      //   342: iconst_2
      //   343: newarray <illegal type>
      //   345: dup
      //   346: iconst_0
      //   347: aload_0
      //   348: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   351: iconst_0
      //   352: baload
      //   353: bastore
      //   354: dup
      //   355: iconst_1
      //   356: aload_0
      //   357: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   360: iconst_1
      //   361: baload
      //   362: bastore
      //   363: invokestatic 247	com/baidu/carlife/core/connect/b:d	([B)S
      //   366: putfield 59	com/baidu/carlife/core/connect/a$b:k	I
      //   369: ldc 86
      //   371: new 69	java/lang/StringBuilder
      //   374: dup
      //   375: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   378: ldc -7
      //   380: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: aload_0
      //   384: getfield 47	com/baidu/carlife/core/connect/a$b:e	Ljava/lang/String;
      //   387: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   390: ldc -5
      //   392: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   395: aload_0
      //   396: getfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   399: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   402: ldc -3
      //   404: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: aload_0
      //   408: getfield 59	com/baidu/carlife/core/connect/a$b:k	I
      //   411: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   414: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   417: invokestatic 93	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   420: aload_0
      //   421: getfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   424: aload_0
      //   425: getfield 59	com/baidu/carlife/core/connect/a$b:k	I
      //   428: iadd
      //   429: invokestatic 106	com/baidu/carlife/core/connect/b:a	(I)[B
      //   432: iconst_0
      //   433: aload_0
      //   434: getfield 65	com/baidu/carlife/core/connect/a$b:n	[B
      //   437: iconst_4
      //   438: iconst_4
      //   439: invokestatic 112	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   442: aload_0
      //   443: aload_0
      //   444: getfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   447: aload_0
      //   448: getfield 59	com/baidu/carlife/core/connect/a$b:k	I
      //   451: iadd
      //   452: putfield 61	com/baidu/carlife/core/connect/a$b:l	I
      //   455: aload_0
      //   456: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   459: arraylength
      //   460: aload_0
      //   461: getfield 61	com/baidu/carlife/core/connect/a$b:l	I
      //   464: if_icmpge +32 -> 496
      //   467: aload_0
      //   468: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   471: astore_1
      //   472: aload_0
      //   473: aload_0
      //   474: getfield 61	com/baidu/carlife/core/connect/a$b:l	I
      //   477: newarray <illegal type>
      //   479: putfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   482: aload_1
      //   483: iconst_0
      //   484: aload_0
      //   485: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   488: iconst_0
      //   489: aload_0
      //   490: getfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   493: invokestatic 112	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   496: aload_0
      //   497: aload_0
      //   498: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   501: aload_0
      //   502: getfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   505: aload_0
      //   506: getfield 59	com/baidu/carlife/core/connect/a$b:k	I
      //   509: invokevirtual 244	com/baidu/carlife/core/connect/a$b:a	([BII)I
      //   512: iflt -405 -> 107
      //   515: aload_0
      //   516: getfield 36	com/baidu/carlife/core/connect/a$b:b	Lcom/baidu/carlife/core/connect/a;
      //   519: aload_0
      //   520: getfield 65	com/baidu/carlife/core/connect/a$b:n	[B
      //   523: bipush 8
      //   525: aload_0
      //   526: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   529: aload_0
      //   530: getfield 61	com/baidu/carlife/core/connect/a$b:l	I
      //   533: invokevirtual 256	com/baidu/carlife/core/connect/a:a	([BI[BI)I
      //   536: ifge -460 -> 76
      //   539: ldc 86
      //   541: ldc_w 258
      //   544: invokestatic 118	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   547: goto -440 -> 107
      //   550: astore_1
      //   551: ldc 86
      //   553: new 69	java/lang/StringBuilder
      //   556: dup
      //   557: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   560: ldc_w 260
      //   563: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   566: aload_0
      //   567: getfield 49	com/baidu/carlife/core/connect/a$b:f	Ljava/lang/String;
      //   570: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   573: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   576: invokestatic 118	com/baidu/carlife/core/i:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   579: aload_1
      //   580: invokevirtual 121	java/lang/Exception:printStackTrace	()V
      //   583: return
      //   584: aload_0
      //   585: aload_0
      //   586: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   589: iconst_0
      //   590: bipush 12
      //   592: invokevirtual 244	com/baidu/carlife/core/connect/a$b:a	([BII)I
      //   595: iflt -488 -> 107
      //   598: aload_0
      //   599: bipush 12
      //   601: putfield 57	com/baidu/carlife/core/connect/a$b:j	I
      //   604: aload_0
      //   605: iconst_4
      //   606: newarray <illegal type>
      //   608: dup
      //   609: iconst_0
      //   610: aload_0
      //   611: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   614: iconst_0
      //   615: baload
      //   616: bastore
      //   617: dup
      //   618: iconst_1
      //   619: aload_0
      //   620: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   623: iconst_1
      //   624: baload
      //   625: bastore
      //   626: dup
      //   627: iconst_2
      //   628: aload_0
      //   629: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   632: iconst_2
      //   633: baload
      //   634: bastore
      //   635: dup
      //   636: iconst_3
      //   637: aload_0
      //   638: getfield 63	com/baidu/carlife/core/connect/a$b:m	[B
      //   641: iconst_3
      //   642: baload
      //   643: bastore
      //   644: invokestatic 263	com/baidu/carlife/core/connect/b:b	([B)I
      //   647: putfield 59	com/baidu/carlife/core/connect/a$b:k	I
      //   650: goto -281 -> 369
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	653	0	this	b
      //   245	34	1	localException1	Exception
      //   471	12	1	arrayOfByte	byte[]
      //   550	30	1	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   7	76	245	java/lang/Exception
      //   115	180	245	java/lang/Exception
      //   180	242	245	java/lang/Exception
      //   76	107	550	java/lang/Exception
      //   107	114	550	java/lang/Exception
      //   285	321	550	java/lang/Exception
      //   321	369	550	java/lang/Exception
      //   369	496	550	java/lang/Exception
      //   496	547	550	java/lang/Exception
      //   584	650	550	java/lang/Exception
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */