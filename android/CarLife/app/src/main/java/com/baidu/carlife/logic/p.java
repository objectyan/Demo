package com.baidu.carlife.logic;

import com.baidu.carlife.core.i;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit;
import com.baidu.carlife.protobuf.CarlifeMusicInitProto.CarlifeMusicInit.Builder;
import com.baidu.carlife.protobuf.CarlifeTTSInitProto.CarlifeTTSInit;
import com.baidu.carlife.protobuf.CarlifeTTSInitProto.CarlifeTTSInit.Builder;
import java.util.Arrays;

public class p
{
  public static final int a = 12;
  public static final int b = 12;
  private static final String c = "Audio-" + p.class.getSimpleName();
  private byte[] d = new byte[this.e];
  private int e = 12;
  private int f = 12;
  
  public int a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject = CarlifeMusicInitProto.CarlifeMusicInit.newBuilder();
    ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).setSampleRate(paramInt1);
    ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).setChannelConfig(paramInt2);
    ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).setSampleFormat(paramInt3);
    localObject = ((CarlifeMusicInitProto.CarlifeMusicInit.Builder)localObject).build();
    byte[] arrayOfByte = ((CarlifeMusicInitProto.CarlifeMusicInit)localObject).toByteArray();
    paramInt2 = this.e;
    if (paramArrayOfByte.length > arrayOfByte.length) {}
    for (paramInt1 = arrayOfByte.length;; paramInt1 = paramArrayOfByte.length)
    {
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt2, paramInt1);
      if (arrayOfByte.length > paramArrayOfByte.length) {
        i.b(c, "initParameter.length>byteData.length!!");
      }
      i.b(c, "byteData:" + Arrays.toString(paramArrayOfByte));
      return ((CarlifeMusicInitProto.CarlifeMusicInit)localObject).getSerializedSize();
    }
  }
  
  public void a(int paramInt)
  {
    this.d[0] = ((byte)(paramInt >> 24 & 0xFF));
    this.d[1] = ((byte)(paramInt >> 16 & 0xFF));
    this.d[2] = ((byte)(paramInt >> 8 & 0xFF));
    this.d[3] = ((byte)(paramInt & 0xFF));
  }
  
  public byte[] a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Object localObject = CarlifeTTSInitProto.CarlifeTTSInit.newBuilder();
    ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).setSampleRate(paramInt1);
    ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).setChannelConfig(paramInt2);
    ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).setSampleFormat(paramInt3);
    localObject = ((CarlifeTTSInitProto.CarlifeTTSInit.Builder)localObject).build();
    System.arraycopy(((CarlifeTTSInitProto.CarlifeTTSInit)localObject).toByteArray(), 0, paramArrayOfByte, this.f, ((CarlifeTTSInitProto.CarlifeTTSInit)localObject).toByteArray().length);
    return ((CarlifeTTSInitProto.CarlifeTTSInit)localObject).getSerializedSize();
  }
  
  public void b(int paramInt)
  {
    this.d[4] = ((byte)(paramInt >> 24 & 0xFF));
    this.d[5] = ((byte)(paramInt >> 16 & 0xFF));
    this.d[6] = ((byte)(paramInt >> 8 & 0xFF));
    this.d[7] = ((byte)(paramInt & 0xFF));
  }
  
  public void c()
  {
    int i = (int)(0xFFFFFFFFFFFFFFFF & System.currentTimeMillis());
    this.d[4] = ((byte)(i >> 24 & 0xFF));
    this.d[5] = ((byte)(i >> 16 & 0xFF));
    this.d[6] = ((byte)(i >> 8 & 0xFF));
    this.d[7] = ((byte)(i & 0xFF));
  }
  
  public void c(int paramInt)
  {
    this.d[8] = ((byte)(paramInt >> 24 & 0xFF));
    this.d[9] = ((byte)(paramInt >> 16 & 0xFF));
    this.d[10] = ((byte)(paramInt >> 8 & 0xFF));
    this.d[11] = ((byte)(paramInt & 0xFF));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */