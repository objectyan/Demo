package com.indooratlas.android.sdk._internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class iq
  implements Serializable, Comparable<iq>
{
  static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final iq b = a(new byte[0]);
  private static final long serialVersionUID = 1L;
  public final byte[] c;
  transient int d;
  transient String e;
  
  iq(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
  
  public static iq a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    iq localiq = new iq(paramString.getBytes(jf.a));
    localiq.e = paramString;
    return localiq;
  }
  
  public static iq a(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new iq((byte[])paramVarArgs.clone());
  }
  
  private iq b(String paramString)
  {
    try
    {
      paramString = a(MessageDigest.getInstance(paramString).digest(this.c));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    int j = paramObjectInputStream.readInt();
    if (paramObjectInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (j < 0) {
      throw new IllegalArgumentException("byteCount < 0: " + j);
    }
    Object localObject = new byte[j];
    int i = 0;
    while (i < j)
    {
      int k = paramObjectInputStream.read((byte[])localObject, i, j - i);
      if (k == -1) {
        throw new EOFException();
      }
      i += k;
    }
    paramObjectInputStream = new iq((byte[])localObject);
    try
    {
      localObject = iq.class.getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(this, paramObjectInputStream.c);
      return;
    }
    catch (NoSuchFieldException paramObjectInputStream)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException paramObjectInputStream)
    {
      throw new AssertionError();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.c.length);
    paramObjectOutputStream.write(this.c);
  }
  
  public final String a()
  {
    String str = this.e;
    if (str != null) {
      return str;
    }
    str = new String(this.c, jf.a);
    this.e = str;
    return str;
  }
  
  public final String b()
  {
    int i = 0;
    char[] arrayOfChar = new char[this.c.length * 2];
    byte[] arrayOfByte = this.c;
    int k = arrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = a[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = a[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public final iq c()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this;
      if (i < this.c.length)
      {
        int j = this.c[i];
        if ((j >= 65) && (j <= 90))
        {
          localObject = (byte[])this.c.clone();
          localObject[i] = ((byte)(j + 32));
          i += 1;
          while (i < localObject.length)
          {
            j = localObject[i];
            if ((j >= 65) && (j <= 90)) {
              localObject[i] = ((byte)(j + 32));
            }
            i += 1;
          }
          localObject = new iq((byte[])localObject);
        }
      }
      else
      {
        return (iq)localObject;
      }
      i += 1;
    }
  }
  
  public final byte[] d()
  {
    return (byte[])this.c.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof iq)) && (((iq)paramObject).c.length == this.c.length))
    {
      paramObject = (iq)paramObject;
      byte[] arrayOfByte = this.c;
      int i = this.c.length;
      if ((((iq)paramObject).c.length - i >= 0) && (arrayOfByte.length - i >= 0) && (jf.a(((iq)paramObject).c, arrayOfByte, i))) {}
      for (i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.d;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(this.c);
    this.d = i;
    return i;
  }
  
  public String toString()
  {
    if (this.c.length == 0) {
      return "ByteString[size=0]";
    }
    if (this.c.length <= 16) {
      return String.format("ByteString[size=%s data=%s]", new Object[] { Integer.valueOf(this.c.length), b() });
    }
    return String.format("ByteString[size=%s md5=%s]", new Object[] { Integer.valueOf(this.c.length), b("MD5").b() });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */