package com.baidu.carlife.core.screen.video;

class JniMethod
{
  static
  {
    System.loadLibrary("bdpc");
  }
  
  static native void convert(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  static native void prepare(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/JniMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */