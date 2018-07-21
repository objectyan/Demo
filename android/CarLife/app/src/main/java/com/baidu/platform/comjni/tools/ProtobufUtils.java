package com.baidu.platform.comjni.tools;

import android.text.TextUtils;
import com.baidu.entity.pb.RepHead;
import com.baidu.entity.pb.RepHead.MessageHead;
import com.google.protobuf.micro.MessageMicro;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtobufUtils
{
  static final String a = ProtobufUtils.class.getSimpleName();
  private static final boolean b = false;
  private static Map<String, Method> c = new HashMap();
  
  private static Method a(ClassLoader paramClassLoader, String paramString)
    throws ClassNotFoundException, NoSuchMethodException
  {
    String str = paramString + "@" + paramClassLoader.hashCode();
    Method localMethod = (Method)c.get(str);
    if (localMethod != null) {
      return localMethod;
    }
    paramClassLoader = Class.forName(paramString, true, paramClassLoader).getDeclaredMethod("parseFrom", new Class[] { byte[].class });
    if (paramClassLoader != null)
    {
      paramClassLoader.setAccessible(true);
      c.put(str, paramClassLoader);
    }
    return paramClassLoader;
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    Object localObject = paramInputStream;
    if (!(paramInputStream instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream);
    }
    paramInputStream = paramOutputStream;
    if (!(paramOutputStream instanceof BufferedOutputStream)) {
      paramInputStream = new BufferedOutputStream(paramOutputStream);
    }
    paramOutputStream = new byte['Ȁ'];
    try
    {
      for (;;)
      {
        int i = ((InputStream)localObject).read(paramOutputStream);
        if (i == -1) {
          break;
        }
        paramInputStream.write(paramOutputStream, 0, i);
      }
      paramInputStream.flush();
    }
    finally
    {
      ((InputStream)localObject).close();
      paramInputStream.close();
    }
    ((InputStream)localObject).close();
    paramInputStream.close();
  }
  
  public static a fromMessageLite(MessageMicro paramMessageMicro)
  {
    return new a(paramMessageMicro);
  }
  
  public static MessageMicro getMessageLite(ClassLoader paramClassLoader, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1 + "." + paramString2.replace("\\.", "\\$");
      try
      {
        paramClassLoader = (MessageMicro)a(paramClassLoader, paramString1).invoke(null, new Object[] { paramArrayOfByte });
        return paramClassLoader;
      }
      catch (Exception paramClassLoader) {}
    }
    return null;
  }
  
  public static MessageMicro getMessageLite(ClassLoader paramClassLoader, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1 + "." + paramString2.replace("\\.", "\\$");
      try
      {
        paramClassLoader = (MessageMicro)a(paramClassLoader, paramString1).invoke(null, new Object[] { readStream(new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2)) });
        return paramClassLoader;
      }
      catch (Exception paramClassLoader) {}
    }
    return null;
  }
  
  public static MessageMicro getMessageLite(ClassLoader paramClassLoader, String paramString, byte[] paramArrayOfByte)
  {
    return getMessageLite(paramClassLoader, "com.baidu.entity.pb", paramString, paramArrayOfByte);
  }
  
  public static MessageMicro getMessageLite(ClassLoader paramClassLoader, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return getMessageLite(paramClassLoader, "com.baidu.entity.pb", paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static MessageMicro getMessageLite(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1 + "." + paramString2.replace("\\.", "\\$");
      try
      {
        paramString1 = (MessageMicro)a(ProtobufUtils.class.getClassLoader(), paramString1).invoke(null, new Object[] { paramArrayOfByte });
        return paramString1;
      }
      catch (Exception paramString1) {}
    }
    return null;
  }
  
  public static MessageMicro getMessageLite(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = paramString1 + "." + paramString2.replace("\\.", "\\$");
      try
      {
        paramString1 = (MessageMicro)a(ProtobufUtils.class.getClassLoader(), paramString1).invoke(null, new Object[] { readStream(new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2)) });
        return paramString1;
      }
      catch (Exception paramString1) {}
    }
    return null;
  }
  
  public static MessageMicro getMessageLite(String paramString, byte[] paramArrayOfByte)
  {
    return getMessageLite("com.baidu.entity.pb", paramString, paramArrayOfByte);
  }
  
  public static MessageMicro getMessageLite(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return getMessageLite("com.baidu.entity.pb", paramString, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static List<MessageMicro> getMessageLiteList(ClassLoader paramClassLoader, byte[] paramArrayOfByte)
    throws IOException
  {
    return getMessageLiteList(paramClassLoader, paramArrayOfByte, "com.baidu.entity.pb");
  }
  
  public static List<MessageMicro> getMessageLiteList(ClassLoader paramClassLoader, byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return localArrayList;
      int j = ByteBuffer.wrap(paramArrayOfByte, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
      RepHead localRepHead = RepHead.parseFrom(readStream(new ByteArrayInputStream(paramArrayOfByte, 4, j)));
      int k = localRepHead.getMessageHeadCount();
      int i = 0;
      while (i < k)
      {
        Object localObject = localRepHead.getMessageHead(i);
        String str = ((RepHead.MessageHead)localObject).getName();
        int m = ((RepHead.MessageHead)localObject).getLength();
        localObject = getMessageLite(paramClassLoader, paramString, str, paramArrayOfByte, j + 4 + ((RepHead.MessageHead)localObject).getOffset(), m);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  public static List<MessageMicro> getMessageLiteList(byte[] paramArrayOfByte)
    throws IOException
  {
    return getMessageLiteList(paramArrayOfByte, "com.baidu.entity.pb");
  }
  
  public static List<MessageMicro> getMessageLiteList(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return localArrayList;
    }
    int j = ByteBuffer.wrap(paramArrayOfByte, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
    RepHead localRepHead = RepHead.parseFrom(readStream(new ByteArrayInputStream(paramArrayOfByte, 4, j)));
    int k = localRepHead.getMessageHeadCount();
    int i = 0;
    label64:
    Object localObject;
    String str;
    int m;
    int n;
    if (i < k)
    {
      localObject = localRepHead.getMessageHead(i);
      str = ((RepHead.MessageHead)localObject).getName();
      m = ((RepHead.MessageHead)localObject).getLength();
      n = j + 4 + ((RepHead.MessageHead)localObject).getOffset();
      if (!str.equals("M")) {
        break label157;
      }
      localObject = new MagicMsg();
      ((MagicMsg)localObject).buffer = readStream(new ByteArrayInputStream(paramArrayOfByte, n, m));
      localArrayList.add(localObject);
    }
    for (;;)
    {
      i += 1;
      break label64;
      break;
      label157:
      localObject = getMessageLite(paramString, str, paramArrayOfByte, n, m);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
  }
  
  public static byte[] readStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static class a
  {
    private MessageMicro a;
    private String b;
    private byte[] c;
    
    a(MessageMicro paramMessageMicro)
    {
      if (paramMessageMicro == null) {
        throw new NullPointerException();
      }
      this.a = paramMessageMicro;
    }
    
    public MessageMicro a()
    {
      return this.a;
    }
    
    public String b()
    {
      if (this.b == null)
      {
        String str = this.a.getClass().getCanonicalName();
        if (str.startsWith("com.baidu.entity.pb.")) {
          this.b = str.substring(20);
        }
      }
      return this.b;
    }
    
    public byte[] c()
    {
      if (this.c == null) {
        this.c = this.a.toByteArray();
      }
      return this.c;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comjni/tools/ProtobufUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */