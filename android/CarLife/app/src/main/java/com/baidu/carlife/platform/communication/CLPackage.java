package com.baidu.carlife.platform.communication;

import android.text.TextUtils;
import com.baidu.carlife.core.connect.b;
import com.baidu.carlife.core.i;
import java.io.Serializable;

public class CLPackage
  implements Serializable
{
  public static final int CLPACKAGE_HEADER_LENGTH = 16;
  public static final int CLPACKAGE_MAX_DATA_LENGTH = 32767;
  private static final String TAG = CLPackage.class.getSimpleName();
  private static final long serialVersionUID = 2746065370039824232L;
  public byte[] data;
  public long dataId = 0L;
  public int dataType = 0;
  public int length = 0;
  public int reserved = 0;
  public int service = 0;
  public int type = 0;
  
  public static CLPackage getLargestPackage()
  {
    CLPackage localCLPackage = new CLPackage();
    localCLPackage.data = new byte['翿'];
    return localCLPackage;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public String getDataInString()
  {
    if (this.data == null) {
      return null;
    }
    return new String(this.data, 0, this.length);
  }
  
  public int getDataLength()
  {
    return this.length;
  }
  
  public int getDataType()
  {
    return this.dataType;
  }
  
  public byte[] getHeader()
  {
    byte[] arrayOfByte = new byte[16];
    try
    {
      arrayOfByte[0] = ((byte)(this.reserved >> 8 & 0xFF));
      arrayOfByte[1] = ((byte)(this.reserved & 0xFF));
      arrayOfByte[2] = ((byte)(this.type & 0xFF));
      arrayOfByte[3] = ((byte)(this.dataType & 0xFF));
      arrayOfByte[4] = ((byte)(this.length >> 8 & 0xFF));
      arrayOfByte[5] = ((byte)(this.length & 0xFF));
      arrayOfByte[6] = ((byte)(this.service >> 8 & 0xFF));
      arrayOfByte[7] = ((byte)(this.service & 0xFF));
      b.a(this.dataId, arrayOfByte, 8);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      i.b(TAG, localException);
    }
    return null;
  }
  
  public boolean setData(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.data = null;
      this.length = 0;
    }
    for (;;)
    {
      this.dataType = 0;
      return true;
      paramString = paramString.getBytes();
      setData(paramString, paramString.length);
    }
  }
  
  public boolean setData(byte[] paramArrayOfByte, int paramInt)
    throws IllegalArgumentException
  {
    if ((paramArrayOfByte == null) || (paramInt == 0))
    {
      this.data = null;
      this.dataType = 1;
      this.length = 0;
      return true;
    }
    if (paramInt > 32767) {
      throw new IllegalArgumentException("data exceed package largest length");
    }
    if (paramArrayOfByte.length < paramInt) {
      throw new IllegalArgumentException("data length is less than len");
    }
    if ((this.data == null) || (this.data.length < paramInt)) {
      this.data = new byte[paramInt];
    }
    System.arraycopy(paramArrayOfByte, 0, this.data, 0, paramInt);
    this.dataType = 1;
    this.length = paramInt;
    return true;
  }
  
  public boolean setHeader(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 16) {
      return false;
    }
    try
    {
      this.reserved = b.d(paramArrayOfByte, 0);
      this.type = (paramArrayOfByte[2] & 0xFF);
      this.dataType = (paramArrayOfByte[3] & 0xFF);
      this.length = b.d(paramArrayOfByte, 4);
      this.service = b.d(paramArrayOfByte, 6);
      this.dataId = b.a(paramArrayOfByte, 8);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      i.b(TAG, paramArrayOfByte);
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/platform/communication/CLPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */