package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.f;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class g
  implements h
{
  public static final int a = 100;
  private static final String b = "ConnectSocket";
  private static final String c = "ReadThread";
  private static final String d = "WriteThread";
  private static final String e = "TouchThread";
  private static final int f = 4096;
  private static final int g = 327680;
  private static final int h = 327680;
  private static final String i = "utf-8";
  private static int r = 0;
  private static int s = 1;
  private String j = "ConnectSocket";
  private a k = null;
  private c l = null;
  private b m = null;
  private Socket n = null;
  private BufferedInputStream o = null;
  private BufferedOutputStream p = null;
  private boolean q = false;
  private boolean t = false;
  private com.baidu.carlife.core.connect.a.b u = new com.baidu.carlife.core.connect.a.b();
  private com.baidu.carlife.core.connect.a.b v = new com.baidu.carlife.core.connect.a.b();
  
  public g(String paramString, Socket paramSocket)
  {
    this.j = paramString;
    this.n = paramSocket;
  }
  
  public static c a(BufferedInputStream paramBufferedInputStream)
  {
    c localc = new c(false);
    if (paramBufferedInputStream != null)
    {
      int i2 = 8;
      byte[] arrayOfByte;
      int i1;
      int i3;
      try
      {
        arrayOfByte = new byte[8];
        i1 = 0;
        while (i2 > 0)
        {
          i3 = paramBufferedInputStream.read(arrayOfByte, i1, i2);
          if (i3 > 0)
          {
            i2 -= i3;
            i1 += i3;
          }
          else
          {
            i.e("ConnectSocket", "Receive Carlife Msg Head Error: ret = " + i3);
            throw new IOException();
          }
        }
      }
      catch (Exception paramBufferedInputStream)
      {
        i.e("ConnectSocket", "IOException, Receive Data Fail");
        d.a().a(false);
        paramBufferedInputStream.printStackTrace();
        return null;
      }
      int i4;
      if (i1 == 8)
      {
        localc.a(arrayOfByte);
        i3 = localc.e();
        i2 = i3;
        arrayOfByte = new byte[i3];
        i1 = 0;
        for (;;)
        {
          if (i2 <= 0) {
            break label232;
          }
          i4 = paramBufferedInputStream.read(arrayOfByte, i1, i2);
          if (i4 <= 0) {
            break;
          }
          i2 -= i4;
          i1 += i4;
        }
      }
      i.e("ConnectSocket", " Receive Carlife Msg Head Error: headLen = " + i1);
      throw new IOException();
      i.e("ConnectSocket", "Receive Carlife Msg Data Error: ret = " + i4);
      throw new IOException();
      label232:
      if (i1 == i3)
      {
        localc.b(arrayOfByte);
        a("RECV CarlifeMsg CMD", localc);
        return localc;
      }
      i.e("ConnectSocket", "Receive Carlife Msg Data Error: dataLen = " + i1);
      throw new IOException();
    }
    i.e("ConnectSocket", "Receive Data Fail, mInputStream is null");
    throw new IOException();
  }
  
  private static void a(String paramString, c paramc)
  {
    if (!com.baidu.carlife.core.e.t()) {
      return;
    }
    try
    {
      String str = "" + "index = " + Integer.toString(paramc.b());
      str = str + ", length = " + Integer.toString(paramc.e());
      str = str + ", service_type = 0x" + j.a(paramc.d(), 8);
      paramc = str + ", name = " + f.a(paramc.d());
      i.b("ConnectSocket", "[" + paramString + "]" + paramc);
      return;
    }
    catch (Exception paramString)
    {
      i.e("TAG", "dumpData get Exception");
      paramString.printStackTrace();
    }
  }
  
  private static void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (!com.baidu.carlife.core.e.t()) {}
    for (;;)
    {
      return;
      if (paramInt >= 4) {
        try
        {
          int i1 = b.b(new byte[] { paramArrayOfByte[0], paramArrayOfByte[1], paramArrayOfByte[2], paramArrayOfByte[3] });
          String str2 = "" + "length = " + Integer.toString(i1);
          String str1 = str2;
          if (paramInt >= 12)
          {
            paramInt = b.b(new byte[] { paramArrayOfByte[8], paramArrayOfByte[9], paramArrayOfByte[10], paramArrayOfByte[11] });
            paramArrayOfByte = f.a(paramInt);
            if (paramArrayOfByte != null)
            {
              str1 = str2 + ", service_type = 0x" + j.a(paramInt, 8);
              str1 = str1 + ", name = " + paramArrayOfByte;
            }
          }
          else
          {
            i.b("ConnectSocket", "[" + paramString + "]" + str1);
            return;
          }
        }
        catch (Exception paramString)
        {
          i.e("TAG", "dumpData get Exception");
          paramString.printStackTrace();
        }
      }
    }
  }
  
  private void g()
  {
    i.b("ConnectSocket", "ConnectSocket do shake hands");
    e.a().a(this);
  }
  
  private void h()
  {
    i.b("ConnectSocket", "ConnectSocket after shake hands");
    if ((this.j.equals("Cmd")) || (this.j.equals("Data")))
    {
      this.k = new a();
      this.k.start();
    }
    if (this.j.equals("Touch"))
    {
      this.m = new b();
      this.m.start();
    }
  }
  
  private c i()
  {
    c localc = new c(false);
    int i2;
    byte[] arrayOfByte;
    int i1;
    int i3;
    try
    {
      if (this.o == null) {
        break label428;
      }
      i2 = 8;
      arrayOfByte = new byte[8];
      i1 = 0;
      while (i2 > 0)
      {
        i3 = this.o.read(arrayOfByte, i1, i2);
        if (i3 > 0)
        {
          i2 -= i3;
          i1 += i3;
        }
        else
        {
          i.e("ConnectSocket", this.j + " Receive Carlife Msg Head Error: ret = " + i3);
          throw new IOException();
        }
      }
    }
    catch (Exception localException)
    {
      i.e("ConnectSocket", this.j + " IOException, Receive Data Fail");
      d.a().a(false);
      localException.printStackTrace();
      return null;
    }
    int i4;
    if (i1 == 8)
    {
      localException.a(arrayOfByte);
      i3 = localException.e();
      i2 = i3;
      arrayOfByte = new byte[i3];
      i1 = 0;
      for (;;)
      {
        if (i2 <= 0) {
          break label287;
        }
        i4 = this.o.read(arrayOfByte, i1, i2);
        if (i4 <= 0) {
          break;
        }
        i2 -= i4;
        i1 += i4;
      }
    }
    i.e("ConnectSocket", this.j + " Receive Carlife Msg Head Error: headLen = " + i1);
    throw new IOException();
    i.e("ConnectSocket", this.j + " Receive Carlife Msg Data Error: ret = " + i4);
    throw new IOException();
    label287:
    if (i1 == i3)
    {
      if ((com.baidu.carlife.core.connect.a.e.a().c()) && (i1 > 0))
      {
        arrayOfByte = this.u.b(arrayOfByte, i1);
        if (arrayOfByte == null)
        {
          i.e("ConnectSocket", "decrypt failed!");
          return null;
        }
        localException.d(arrayOfByte.length);
        localException.b(arrayOfByte);
      }
      for (;;)
      {
        a("RECV CarlifeMsg " + this.j, localException);
        return localException;
        localException.b(arrayOfByte);
      }
    }
    i.e("ConnectSocket", this.j + " Receive Carlife Msg Data Error: dataLen = " + i1);
    throw new IOException();
    label428:
    i.e("ConnectSocket", this.j + " Receive Data Fail, mInputStream is null");
    throw new IOException();
  }
  
  private c j()
  {
    if (r >= s) {
      return null;
    }
    char c1 = (char)(r % 26 + 97);
    c localc = new c(true);
    Object localObject = "Msg Num:" + Integer.toString(r);
    int i2 = ((String)localObject).length();
    localObject = new StringBuffer((String)localObject);
    int i1 = 0;
    while (i1 < 4096 - i2)
    {
      ((StringBuffer)localObject).append(c1);
      i1 += 1;
    }
    try
    {
      localc.b(((StringBuffer)localObject).toString().getBytes("utf-8"));
      localc.d(4096);
      r += 1;
      return localc;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
  
  public int a(c paramc)
  {
    try
    {
      if (this.p != null)
      {
        a("SEND CarlifeMsg CMD", paramc);
        if ((com.baidu.carlife.core.connect.a.e.a().c()) && (paramc.e() > 0))
        {
          byte[] arrayOfByte = this.v.a(paramc.f(), paramc.f().length);
          if (arrayOfByte == null)
          {
            i.e("ConnectSocket", "encrypt failed!");
            return -1;
          }
          paramc.d(arrayOfByte.length);
          this.p.write(paramc.a());
          this.p.flush();
          if (paramc.e() > 0)
          {
            this.p.write(arrayOfByte);
            this.p.flush();
          }
        }
        for (;;)
        {
          return paramc.e() + 8;
          this.p.write(paramc.a());
          this.p.flush();
          if (paramc.e() > 0)
          {
            this.p.write(paramc.f());
            this.p.flush();
          }
        }
      }
      i.e("ConnectSocket", this.j + " Send Data Fail, mOutputStream is null");
    }
    catch (Exception paramc)
    {
      i.e("ConnectSocket", this.j + " IOException, Send Data Fail");
      d.a().a(false);
      paramc.printStackTrace();
      return -1;
    }
    throw new IOException();
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      if (this.p != null)
      {
        if (!"Video".equals(this.j)) {
          a("SEND CarlifeMsg " + this.j, paramArrayOfByte, paramInt);
        }
        this.p.write(paramArrayOfByte, 0, paramInt);
        this.p.flush();
        return paramInt;
      }
      i.e("ConnectSocket", this.j + " Send Data Fail, mOutputStream is null");
      throw new IOException();
    }
    catch (Exception paramArrayOfByte)
    {
      i.e("ConnectSocket", this.j + " IOException, Send Data Fail");
      d.a().a(false);
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public String a()
  {
    return this.j;
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt)
  {
    int i3 = -1;
    int i1 = i3;
    int i2;
    do
    {
      try
      {
        if (this.o == null) {
          break;
        }
        int i4 = paramInt;
        i2 = 0;
        while (i4 > 0)
        {
          i1 = i3;
          i3 = this.o.read(paramArrayOfByte, i2, i4);
          if (i3 > 0)
          {
            i4 -= i3;
            i2 += i3;
          }
          else
          {
            i1 = i3;
            i.e("ConnectSocket", this.j + " Receive Data Error: ret = " + i3);
            i1 = i3;
            throw new IOException();
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        i.e("ConnectSocket", this.j + " IOException, Receive Data Fail");
        d.a().a(false);
        paramArrayOfByte.printStackTrace();
        return i1;
      }
      i1 = i2;
    } while (i2 == paramInt);
    i1 = i3;
    i.e("ConnectSocket", this.j + " Receive Data Error: dataLen = " + i2);
    i1 = i3;
    throw new IOException();
    i1 = i3;
    i.e("ConnectSocket", this.j + " Receive Data Fail, mInputStream is null");
    i1 = i3;
    throw new IOException();
  }
  
  public boolean b()
  {
    return this.t;
  }
  
  public void c()
  {
    i.b("ConnectSocket", "Start Conmunication");
    if (!this.q) {}
    try
    {
      this.n.setTcpNoDelay(true);
      this.n.setSendBufferSize(327680);
      this.n.setReceiveBufferSize(327680);
      this.o = new BufferedInputStream(this.n.getInputStream());
      this.p = new BufferedOutputStream(this.n.getOutputStream());
      g();
      h();
      this.q = true;
      return;
    }
    catch (Exception localException)
    {
      i.e("ConnectSocket", "Start Conmunication Fail");
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    i.b("ConnectSocket", "Stop Conmunication");
    if (this.q) {}
    try
    {
      if (this.n != null)
      {
        this.n.close();
        this.n = null;
      }
      if (this.o != null)
      {
        this.o.close();
        this.o = null;
      }
      if (this.p != null)
      {
        this.p.close();
        this.p = null;
      }
      this.q = false;
      return;
    }
    catch (Exception localException)
    {
      i.e("ConnectSocket", "Stop Conmunication Fail");
    }
  }
  
  public BufferedInputStream e()
  {
    return this.o;
  }
  
  public BufferedOutputStream f()
  {
    return this.p;
  }
  
  private class a
    extends Thread
  {
    public a()
    {
      setName("ReadThread");
    }
    
    public void run()
    {
      try
      {
        sleep(100L);
        for (;;)
        {
          if (!g.a(g.this)) {
            return;
          }
          if (!g.b(g.this).isConnected())
          {
            i.e("ConnectSocket", "socket is disconnected when read data");
            return;
          }
          c localc = g.c(g.this);
          if (localc == null) {
            break;
          }
          k.a(localc.d(), 0, 0, localc);
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i.e("ConnectSocket", "get InterruptedException in ReadThread");
        localInterruptedException.printStackTrace();
        return;
        i.e("ConnectSocket", "read carlife msg fail");
        return;
      }
      catch (Exception localException)
      {
        i.e("ConnectSocket", "get Exception in ReadThread");
        localException.printStackTrace();
      }
    }
  }
  
  private class b
    extends Thread
  {
    public b()
    {
      setName("TouchThread");
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          sleep(100L);
          if (!g.a(g.this)) {
            return;
          }
          if (!g.b(g.this).isConnected())
          {
            i.e("ConnectSocket", "socket is disconnected when read touch data");
            return;
          }
          localc = g.c(g.this);
          if (localc == null) {
            break label130;
          }
          i = localc.d();
          if (i != 425988) {
            continue;
          }
          g.this.a(true);
        }
        catch (InterruptedException localInterruptedException)
        {
          c localc;
          int i;
          i.e("ConnectSocket", "get InterruptedException in TouchThread");
          localInterruptedException.printStackTrace();
          return;
          if (!g.this.b()) {
            continue;
          }
          k.a(425988);
          g.this.a(false);
          continue;
        }
        catch (Exception localException)
        {
          i.e("ConnectSocket", "get Exception in TouchThread");
          localException.printStackTrace();
          return;
        }
        k.a(i, 0, 0, localc);
      }
      label130:
      i.e("ConnectSocket", "read touch carlife msg fail");
    }
  }
  
  private class c
    extends Thread
  {
    public c()
    {
      setName("WriteThread");
    }
    
    public void run()
    {
      try
      {
        while (g.a(g.this))
        {
          if (!g.b(g.this).isConnected())
          {
            i.e("ConnectSocket", "socket is disconnected when write data");
            return;
          }
          c localc = g.d(g.this);
          if (localc != null) {
            g.this.a(localc);
          } else {
            i.e("ConnectSocket", "write carlife msg fail");
          }
        }
      }
      catch (Exception localException)
      {
        i.e("ConnectSocket", "get Exception in WriteThread");
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */