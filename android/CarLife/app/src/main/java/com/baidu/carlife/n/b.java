package com.baidu.carlife.n;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.protobuf.CarLifeUpdateSuccessProtos.CarLifeUpdateSuccess;
import com.baidu.carlife.protobuf.CarlifeTransferEndProtos.CarlifeTransferEnd;
import com.baidu.carlife.protobuf.CarlifeTransferEndProtos.CarlifeTransferEnd.Builder;
import com.baidu.carlife.protobuf.CarlifeTransferSendProtos.CarlifeTransferSend;
import com.baidu.carlife.protobuf.CarlifeTransferSendProtos.CarlifeTransferSend.Builder;
import com.baidu.carlife.protobuf.CarlifeTransferStartProtos.CarlifeTransferStart;
import com.baidu.carlife.protobuf.CarlifeTransferStartProtos.CarlifeTransferStart.Builder;
import com.baidu.carlife.util.w;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class b
{
  public static final int a = 8192;
  private static final String b = "FirmwareUpdateTool";
  private e c;
  private a d;
  private int e = 3719354;
  private byte[] f;
  private int g;
  private FileOutputStream h;
  private File i;
  private Context j;
  private HandlerThread k;
  private int l = 0;
  private String m = null;
  private int n = -1;
  private d o;
  
  public static long a(File paramFile)
    throws Exception
  {
    if (paramFile == null) {}
    while (!paramFile.exists()) {
      return 0L;
    }
    paramFile = new FileInputStream(paramFile);
    long l1 = paramFile.available();
    paramFile.close();
    return l1;
  }
  
  public static b a()
  {
    return b.a();
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (this.d != null) {
      this.d.a(paramLong, paramInt);
    }
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = CarlifeTransferSendProtos.CarlifeTransferSend.newBuilder();
    ((CarlifeTransferSendProtos.CarlifeTransferSend.Builder)localObject).setBodyData(ByteString.copyFrom(paramArrayOfByte, 0, paramInt));
    ((CarlifeTransferSendProtos.CarlifeTransferSend.Builder)localObject).setPacketSize(paramInt);
    paramArrayOfByte = ((CarlifeTransferSendProtos.CarlifeTransferSend.Builder)localObject).build();
    localObject = new c(true);
    ((c)localObject).c(458760);
    ((c)localObject).b(paramArrayOfByte.toByteArray());
    ((c)localObject).d(paramArrayOfByte.getSerializedSize());
    return com.baidu.carlife.core.connect.e.a().b((c)localObject) != -1;
  }
  
  private void b(c paramc)
  {
    try
    {
      int i1 = CarLifeUpdateSuccessProtos.CarLifeUpdateSuccess.parseFrom(paramc.f()).getVersionCode();
      paramc = "车机端安装完成! 版本号：" + i1;
      w.a();
      w.a(paramc, 3500);
      return;
    }
    catch (InvalidProtocolBufferException paramc)
    {
      paramc.printStackTrace();
    }
  }
  
  private CarlifeTransferSendProtos.CarlifeTransferSend c(c paramc)
  {
    try
    {
      paramc = CarlifeTransferSendProtos.CarlifeTransferSend.parseFrom(paramc.f());
      return paramc;
    }
    catch (InvalidProtocolBufferException paramc)
    {
      paramc.printStackTrace();
    }
    return null;
  }
  
  private void c()
  {
    if ((this.i != null) && (this.i.exists())) {
      this.i.delete();
    }
  }
  
  private boolean d()
  {
    boolean bool4 = true;
    boolean bool3 = true;
    Object localObject = d.f();
    bool2 = bool4;
    try
    {
      localObject = new File((String)localObject);
      bool2 = bool4;
      long l1 = ((File)localObject).length();
      if (l1 > 2147483647L)
      {
        bool2 = bool4;
        i.e("FirmwareUpdateTool", "file too big...");
        return false;
      }
      bool2 = bool4;
      i.b("FirmwareUpdateTool", "transfer data start: " + l1);
      bool2 = bool4;
      localObject = new FileInputStream((File)localObject);
      bool2 = bool4;
      byte[] arrayOfByte = new byte[' '];
      int i1 = 0;
      int i2 = 0;
      for (;;)
      {
        boolean bool1 = bool3;
        int i3;
        if (i2 < l1)
        {
          bool2 = bool4;
          i3 = ((FileInputStream)localObject).read(arrayOfByte);
          bool2 = bool4;
          if (!a(arrayOfByte, i3)) {
            bool1 = false;
          }
        }
        else
        {
          bool2 = bool1;
          b(this.n);
          bool3 = bool1;
          if (i2 < l1)
          {
            bool2 = bool1;
            i.e("FirmwareUpdateTool", "Could not completely read file: " + i2);
            bool3 = false;
          }
          bool2 = bool3;
          ((FileInputStream)localObject).close();
          bool2 = bool3;
          i.b("FirmwareUpdateTool", "transfer end: " + i2);
          bool2 = bool3;
          break;
        }
        i2 += i3;
        i1 += 1;
        bool2 = bool4;
        a(l1, (int)((i2 + 0.0D) / l1 * 100.0D));
        bool2 = bool4;
        i.e("FirmwareUpdateTool", "transferData : [" + i1 + " : " + i2);
      }
      return bool2;
    }
    catch (IOException localIOException)
    {
      i.e("FirmwareUpdateTool", "transfer data error!!!");
      localIOException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = CarlifeTransferStartProtos.CarlifeTransferStart.newBuilder();
    ((CarlifeTransferStartProtos.CarlifeTransferStart.Builder)localObject).setUpdateSize(paramInt);
    localObject = ((CarlifeTransferStartProtos.CarlifeTransferStart.Builder)localObject).build();
    c localc = new c(true);
    localc.c(458759);
    localc.b(((CarlifeTransferStartProtos.CarlifeTransferStart)localObject).toByteArray());
    localc.d(((CarlifeTransferStartProtos.CarlifeTransferStart)localObject).getSerializedSize());
    i.b("FirmwareUpdateTool", "Start transfer data");
    com.baidu.carlife.core.connect.e.a().b(localc);
  }
  
  public void a(Context paramContext, a parama)
  {
    this.j = paramContext;
    this.d = parama;
  }
  
  public void a(c paramc)
  {
    w.a();
    w.a("传输完成，车机端开始安装更新!", 3500);
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.o.a(paramString1, paramString2);
  }
  
  public void b(int paramInt)
  {
    Object localObject = CarlifeTransferEndProtos.CarlifeTransferEnd.newBuilder();
    ((CarlifeTransferEndProtos.CarlifeTransferEnd.Builder)localObject).setNewFirmwareVersionCode(paramInt);
    localObject = ((CarlifeTransferEndProtos.CarlifeTransferEnd.Builder)localObject).build();
    c localc = new c(true);
    localc.c(458761);
    localc.b(((CarlifeTransferEndProtos.CarlifeTransferEnd)localObject).toByteArray());
    localc.d(((CarlifeTransferEndProtos.CarlifeTransferEnd)localObject).getSerializedSize());
    i.b("FirmwareUpdateTool", "Start transfer data");
    com.baidu.carlife.core.connect.e.a().b(localc);
  }
  
  public boolean b()
  {
    if (!com.baidu.carlife.core.e.a().r())
    {
      i.b("FirmwareUpdateTool", "NetworkAvailable Error");
      return false;
    }
    a(null, null);
    return true;
  }
  
  public void c(int paramInt)
  {
    this.n = paramInt;
    Object localObject = d.f();
    i.b("FirmwareUpdateTool", "startTransferData: " + (String)localObject);
    localObject = new File((String)localObject);
    try
    {
      long l1 = a((File)localObject);
      i.b("FirmwareUpdateTool", "### size: " + l1);
      a(this.l);
      this.c = new e(null);
      this.c.execute(new Void[0]);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt);
    
    public abstract void a(b.d paramd, b.c paramc);
  }
  
  private static final class b
  {
    private static final b a = new b(null);
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static enum d
  {
    private d() {}
  }
  
  private class e
    extends AsyncTask<Void, Void, Boolean>
  {
    private e() {}
    
    protected Boolean a(Void... paramVarArgs)
    {
      return Boolean.valueOf(b.a(b.this));
    }
    
    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      i.b("FirmwareUpdateTool", "OnPostExecute: " + paramBoolean);
      if (paramBoolean.booleanValue())
      {
        paramBoolean = b.b(b.this);
        b.d locald = b.d.e;
        paramBoolean.a(b.d.e, b.c.a);
        return;
      }
      b.b(b.this).a(b.d.f, b.c.b);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/n/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */