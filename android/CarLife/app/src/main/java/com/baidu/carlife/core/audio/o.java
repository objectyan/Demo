package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.connect.a.b;
import com.baidu.carlife.core.connect.a.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.Builder;
import com.baidu.carlife.protobuf.CarlifeTTSInitProto.CarlifeTTSInit;
import com.baidu.carlife.protobuf.CarlifeTTSInitProto.CarlifeTTSInit.Builder;
import java.util.Arrays;

public class o
{
  private static final String a = "Audio-" + o.class.getSimpleName();
  private byte[] b;
  private int c;
  private int d;
  private b e = new b();
  
  public o()
  {
    a.a();
    this.c = 12;
    a.a();
    this.d = 12;
    this.b = new byte[this.c];
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject = CarlifeMusicInitProto.CarlifeMusicInit.newBuilder();
    ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).setSampleRate(paramInt1);
    ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).setChannelConfig(paramInt2);
    ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).setSampleFormat(paramInt3);
    byte[] arrayOfByte2 = ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).build().toByteArray();
    byte[] arrayOfByte1 = arrayOfByte2;
    localObject = arrayOfByte1;
    if (e.a().c())
    {
      localObject = arrayOfByte1;
      if (arrayOfByte2.length > 0)
      {
        arrayOfByte1 = this.e.a(arrayOfByte2, arrayOfByte2.length);
        localObject = arrayOfByte1;
        if (arrayOfByte1 == null)
        {
          i.e(a, "encrypt failed!");
          return -1;
        }
      }
    }
    paramInt2 = this.c;
    if (paramArrayOfByte.length > localObject.length) {}
    for (paramInt1 = localObject.length;; paramInt1 = paramArrayOfByte.length)
    {
      System.arraycopy(localObject, 0, paramArrayOfByte, paramInt2, paramInt1);
      if (localObject.length > paramArrayOfByte.length) {
        i.b(a, "initParameter.length>byteData.length!!");
      }
      i.b(a, "byteData:" + Arrays.toString(paramArrayOfByte));
      return localObject.length;
    }
  }
  
  public void a(int paramInt)
  {
    this.b[0] = ((byte)(paramInt >> 24 & 0xFF));
    this.b[1] = ((byte)(paramInt >> 16 & 0xFF));
    this.b[2] = ((byte)(paramInt >> 8 & 0xFF));
    this.b[3] = ((byte)(paramInt & 0xFF));
  }
  
  public byte[] a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject = CarlifeTTSInitProto.CarlifeTTSInit.newBuilder();
    ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).setSampleRate(paramInt1);
    ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).setChannelConfig(paramInt2);
    ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).setSampleFormat(paramInt3);
    byte[] arrayOfByte2 = ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).build().toByteArray();
    byte[] arrayOfByte1 = arrayOfByte2;
    localObject = arrayOfByte1;
    if (e.a().c())
    {
      localObject = arrayOfByte1;
      if (arrayOfByte2.length > 0)
      {
        arrayOfByte1 = this.e.a(arrayOfByte2, arrayOfByte2.length);
        localObject = arrayOfByte1;
        if (arrayOfByte1 == null)
        {
          i.e(a, "encrypt failed!");
          return -1;
        }
      }
    }
    System.arraycopy(localObject, 0, paramArrayOfByte, this.d, localObject.length);
    return localObject.length;
  }
  
  public void b(int paramInt)
  {
    this.b[4] = ((byte)(paramInt >> 24 & 0xFF));
    this.b[5] = ((byte)(paramInt >> 16 & 0xFF));
    this.b[6] = ((byte)(paramInt >> 8 & 0xFF));
    this.b[7] = ((byte)(paramInt & 0xFF));
  }
  
  public void c()
  {
    int i = (int)(0xFFFFFFFFFFFFFFFF & System.currentTimeMillis());
    this.b[4] = ((byte)(i >> 24 & 0xFF));
    this.b[5] = ((byte)(i >> 16 & 0xFF));
    this.b[6] = ((byte)(i >> 8 & 0xFF));
    this.b[7] = ((byte)(i & 0xFF));
  }
  
  public void c(int paramInt)
  {
    this.b[8] = ((byte)(paramInt >> 24 & 0xFF));
    this.b[9] = ((byte)(paramInt >> 16 & 0xFF));
    this.b[10] = ((byte)(paramInt >> 8 & 0xFF));
    this.b[11] = ((byte)(paramInt & 0xFF));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/audio/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */