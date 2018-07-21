package com.baidu.carlife.core.connect.a;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  private Cipher a;
  private Cipher b;
  
  public b()
  {
    a();
  }
  
  private void a()
  {
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(d.a().b().getBytes(), "AES");
    try
    {
      this.a = Cipher.getInstance("AES");
      this.b = Cipher.getInstance("AES");
      this.a.init(1, localSecretKeySpec);
      this.b.init(2, localSecretKeySpec);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = this.a.doFinal(paramArrayOfByte, 0, paramInt);
      return paramArrayOfByte;
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = this.b.doFinal(paramArrayOfByte, 0, paramInt);
      return paramArrayOfByte;
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */