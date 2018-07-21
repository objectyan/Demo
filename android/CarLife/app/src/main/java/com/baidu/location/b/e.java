package com.baidu.location.b;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.h.b;
import com.baidu.location.h.c;
import com.baidu.location.h.g;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class e
  implements Thread.UncaughtExceptionHandler
{
  private static e a = null;
  private int b = 0;
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  private String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.close();
    return localStringWriter.toString();
  }
  
  private void a(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rw");
      paramFile.seek(280L);
      paramFile.writeInt(12346);
      paramFile.seek(300L);
      paramFile.writeLong(System.currentTimeMillis());
      byte[] arrayOfByte = paramString1.getBytes();
      paramFile.writeInt(arrayOfByte.length);
      paramFile.write(arrayOfByte, 0, arrayOfByte.length);
      paramFile.seek(600L);
      arrayOfByte = paramString2.getBytes();
      paramFile.writeInt(arrayOfByte.length);
      paramFile.write(arrayOfByte, 0, arrayOfByte.length);
      if (!a(paramString1, paramString2))
      {
        paramFile.seek(280L);
        paramFile.writeInt(1326);
      }
      paramFile.close();
      return;
    }
    catch (Exception paramFile) {}
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if (!com.baidu.location.f.f.j()) {
      return false;
    }
    try
    {
      URL localURL = new URL(g.e);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("e0");
      localStringBuffer.append("=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&");
      localStringBuffer.append("e1");
      localStringBuffer.append("=");
      localStringBuffer.append(paramString2);
      localStringBuffer.append("&");
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      paramString1 = (HttpURLConnection)localURL.openConnection();
      paramString1.setRequestMethod("POST");
      paramString1.setDoInput(true);
      paramString1.setDoOutput(true);
      paramString1.setUseCaches(false);
      paramString1.setConnectTimeout(com.baidu.location.h.a.b);
      paramString1.setReadTimeout(com.baidu.location.h.a.b);
      paramString1.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
      paramString1.setRequestProperty("Accept-Charset", "UTF-8");
      paramString2 = paramString1.getOutputStream();
      paramString2.write(localStringBuffer.toString().getBytes());
      paramString2.flush();
      paramString2.close();
      int i = paramString1.getResponseCode();
      return i == 200;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public void b()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        Object localObject1 = Environment.getExternalStorageDirectory().getPath() + "/traces";
        localObject1 = new File((String)localObject1 + "/error_fs2.dat");
        if (((File)localObject1).exists())
        {
          RandomAccessFile localRandomAccessFile = new RandomAccessFile((File)localObject1, "rw");
          localRandomAccessFile.seek(280L);
          if (1326 == localRandomAccessFile.readInt())
          {
            localRandomAccessFile.seek(308L);
            int i = localRandomAccessFile.readInt();
            if ((i <= 0) || (i >= 2048)) {
              break label230;
            }
            localObject1 = new byte[i];
            localRandomAccessFile.read((byte[])localObject1, 0, i);
            localObject1 = new String((byte[])localObject1, 0, i);
            localRandomAccessFile.seek(600L);
            i = localRandomAccessFile.readInt();
            Object localObject3 = localObject4;
            if (i > 0)
            {
              localObject3 = localObject4;
              if (i < 2048)
              {
                localObject3 = new byte[i];
                localRandomAccessFile.read((byte[])localObject3, 0, i);
                localObject3 = new String((byte[])localObject3, 0, i);
              }
            }
            if (a((String)localObject1, (String)localObject3))
            {
              localRandomAccessFile.seek(280L);
              localRandomAccessFile.writeInt(12346);
            }
          }
          localRandomAccessFile.close();
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label230:
      Object localObject2 = null;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    localObject1 = null;
    this.b += 1;
    if (this.b > 2)
    {
      Process.killProcess(Process.myPid());
      return;
    }
    if ((System.currentTimeMillis() - com.baidu.location.g.a.b() < 10000L) && (7.32F > com.baidu.location.f.getFrameVersion()))
    {
      l = c.a().c();
      if (System.currentTimeMillis() - l >= 40000L) {
        break label298;
      }
      paramThread = new File(g.l() + File.separator + com.baidu.location.f.getJarFileName());
      if (paramThread.exists()) {
        paramThread.delete();
      }
    }
    for (;;)
    {
      try
      {
        paramThread = a(paramThrowable);
        if (paramThread == null) {
          continue;
        }
      }
      catch (Exception paramThread)
      {
        File localFile;
        label298:
        paramThread = null;
        paramThrowable = null;
        int i = 0;
        continue;
        localObject1 = new RandomAccessFile(localFile, "rw");
        ((RandomAccessFile)localObject1).seek(300L);
        l = ((RandomAccessFile)localObject1).readLong();
        if (System.currentTimeMillis() - l > 86400000L) {
          a(localFile, paramThrowable, paramThread);
        }
        ((RandomAccessFile)localObject1).close();
        continue;
        i = 0;
        continue;
      }
      try
      {
        if (!paramThread.contains("com.baidu.location")) {
          continue;
        }
        i = 1;
        paramThrowable = b.a().a(false);
        paramThrowable = paramThrowable + com.baidu.location.a.a.a().f();
        if (paramThrowable == null) {
          continue;
        }
        paramThrowable = Jni.encode(paramThrowable);
      }
      catch (Exception paramThrowable)
      {
        continue;
        localObject1 = localFile;
        continue;
        paramThrowable = null;
        continue;
      }
      if (i != 0) {}
      try
      {
        Object localObject2 = Environment.getExternalStorageDirectory().getPath() + "/traces";
        localFile = new File((String)localObject2 + "/error_fs2.dat");
        if (localFile.exists()) {
          continue;
        }
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (localFile.createNewFile()) {
          continue;
        }
        a((File)localObject1, paramThrowable, paramThread);
      }
      catch (Exception paramThread)
      {
        continue;
      }
      Process.killProcess(Process.myPid());
      return;
      c.a().b(System.currentTimeMillis());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */