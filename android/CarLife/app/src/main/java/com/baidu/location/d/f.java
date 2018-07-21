package com.baidu.location.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.h.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class f
{
  private static final Object b = new Object();
  private static f e;
  SharedPreferences a = null;
  private HandlerThread c;
  private Handler d;
  private String f = null;
  private String g = null;
  private StringBuffer h = new StringBuffer();
  private int i = 0;
  private boolean j = false;
  private long k = 0L;
  
  private f()
  {
    e();
    if (this.a == null) {
      this.a = com.baidu.location.f.getServiceContext().getSharedPreferences("map_loctype_statics", 0);
    }
  }
  
  public static f a()
  {
    synchronized (b)
    {
      if (e == null) {
        e = new f();
      }
      f localf = e;
      return localf;
    }
  }
  
  private void a(String paramString, File paramFile)
    throws Exception
  {
    try
    {
      Object localObject = new File(paramString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramString = new ZipOutputStream(new FileOutputStream(paramString));
      localObject = new BufferedOutputStream(paramString);
      a(paramString, paramFile, paramFile.getName(), (BufferedOutputStream)localObject);
      ((BufferedOutputStream)localObject).close();
      paramString.close();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists()) {
        paramString1.createNewFile();
      }
      if (paramString2 != null)
      {
        paramString1 = new BufferedWriter(new FileWriter(paramString1, true));
        paramString1.write(paramString2);
        paramString1.flush();
        paramString1.close();
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, BufferedOutputStream paramBufferedOutputStream)
    throws Exception
  {
    int m;
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        if (paramFile.length == 0) {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramString + File.separator));
        }
        m = 0;
      }
    }
    else
    {
      while (m < paramFile.length)
      {
        a(paramZipOutputStream, paramFile[m], paramString + File.separator + paramFile[m].getName(), paramBufferedOutputStream);
        m += 1;
        continue;
        paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
        paramZipOutputStream = new FileInputStream(paramFile);
        paramString = new BufferedInputStream(paramZipOutputStream);
        for (;;)
        {
          m = paramString.read();
          if (m == -1) {
            break;
          }
          paramBufferedOutputStream.write(m);
        }
        paramString.close();
        paramZipOutputStream.close();
        paramFile.delete();
      }
    }
  }
  
  private String d(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      paramString = paramString.getAbsolutePath();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: new 75	java/io/File
    //   3: dup
    //   4: new 56	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 63	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   14: invokevirtual 69	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: getstatic 78	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 83
    //   28: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 6
    //   39: aload 6
    //   41: invokevirtual 126	java/io/File:exists	()Z
    //   44: ifne +9 -> 53
    //   47: aload 6
    //   49: invokevirtual 212	java/io/File:mkdirs	()Z
    //   52: pop
    //   53: aload 6
    //   55: invokevirtual 173	java/io/File:isDirectory	()Z
    //   58: ifeq +84 -> 142
    //   61: aload 6
    //   63: invokevirtual 219	java/io/File:list	()[Ljava/lang/String;
    //   66: ifnull +76 -> 142
    //   69: aload 6
    //   71: invokevirtual 219	java/io/File:list	()[Ljava/lang/String;
    //   74: arraylength
    //   75: iconst_1
    //   76: if_icmple +66 -> 142
    //   79: aload 6
    //   81: invokevirtual 177	java/io/File:listFiles	()[Ljava/io/File;
    //   84: astore 6
    //   86: iconst_0
    //   87: istore_1
    //   88: iload_1
    //   89: aload 6
    //   91: arraylength
    //   92: if_icmpge +50 -> 142
    //   95: aload 6
    //   97: iload_1
    //   98: aaload
    //   99: invokevirtual 223	java/io/File:lastModified	()J
    //   102: lstore_2
    //   103: lload_2
    //   104: lconst_0
    //   105: lcmp
    //   106: ifle +27 -> 133
    //   109: invokestatic 228	java/lang/System:currentTimeMillis	()J
    //   112: lstore 4
    //   114: lload 4
    //   116: lload_2
    //   117: lsub
    //   118: ldc2_w 229
    //   121: lcmp
    //   122: ifle +11 -> 133
    //   125: aload 6
    //   127: iload_1
    //   128: aaload
    //   129: invokevirtual 129	java/io/File:delete	()Z
    //   132: pop
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -49 -> 88
    //   140: astore 6
    //   142: return
    //   143: astore 7
    //   145: goto -12 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	f
    //   87	50	1	m	int
    //   102	15	2	l1	long
    //   112	3	4	l2	long
    //   37	89	6	localObject	Object
    //   140	1	6	localException1	Exception
    //   143	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	53	140	java/lang/Exception
    //   53	86	140	java/lang/Exception
    //   88	103	140	java/lang/Exception
    //   109	114	140	java/lang/Exception
    //   125	133	143	java/lang/Exception
  }
  
  private void e(String paramString)
  {
    g.a().a("locType&result=" + paramString);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Message localMessage = this.d.obtainMessage(1);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("log", paramString.getBytes());
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void b()
  {
    this.c = new HandlerThread("map-loc-log");
    this.c.start();
    this.d = new Handler(this.c.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        long l1 = 0L;
        Object localObject1 = null;
        Object localObject3 = null;
        Object localObject2 = null;
        int i = 0;
        int j = 0;
        switch (paramAnonymousMessage.what)
        {
        default: 
        case 1: 
        case 2: 
          for (;;)
          {
            return;
            paramAnonymousMessage = paramAnonymousMessage.getData();
            try
            {
              localObject1 = paramAnonymousMessage.getByteArray("log");
              paramAnonymousMessage = (Message)localObject2;
              if (localObject1 != null) {
                paramAnonymousMessage = new String((byte[])localObject1);
              }
              if (TextUtils.isEmpty(paramAnonymousMessage)) {
                continue;
              }
              localObject1 = new StringBuffer();
              ((StringBuffer)localObject1).append(com.baidu.location.h.g.b());
              ((StringBuffer)localObject1).append(" ");
              ((StringBuffer)localObject1).append(paramAnonymousMessage);
              paramAnonymousMessage = Jni.encodeOfflineLocationUpdateRequest(((StringBuffer)localObject1).toString()) + "\r\n";
              if (f.a(f.this) == null) {
                f.a(f.this, new StringBuffer());
              }
              f.a(f.this).append(paramAnonymousMessage);
              f.b(f.this);
              if ((f.a(f.this).length() <= 2048) && (f.c(f.this) <= 3)) {
                continue;
              }
              paramAnonymousMessage = f.a(f.this, f.d(f.this)) + File.separator + com.baidu.location.h.g.c() + ".log";
              f.a(f.this, paramAnonymousMessage, f.a(f.this).toString());
              f.a(f.this, null);
              f.a(f.this, 0);
              return;
            }
            catch (Exception paramAnonymousMessage)
            {
              return;
            }
            try
            {
              localObject2 = paramAnonymousMessage.getData();
              paramAnonymousMessage = (Message)localObject1;
              if (localObject2 != null)
              {
                localObject2 = ((Bundle)localObject2).getByteArray("errorid");
                paramAnonymousMessage = (Message)localObject1;
                if (localObject2 != null) {
                  paramAnonymousMessage = new String((byte[])localObject2);
                }
              }
              if (!TextUtils.isEmpty(paramAnonymousMessage))
              {
                paramAnonymousMessage = f.a(f.this, f.e(f.this)) + File.separator + paramAnonymousMessage + ".zip";
                f.f(f.this);
                f.a(f.this, paramAnonymousMessage, new File(f.a(f.this, f.d(f.this))));
                localObject1 = new File(paramAnonymousMessage);
                if ((((File)localObject1).exists()) && (((File)localObject1).getTotalSpace() > 100L) && (!f.g(f.this)))
                {
                  com.baidu.location.f.f.a();
                  if ((com.baidu.location.f.f.j()) || (((File)localObject1).getTotalSpace() < 204800L))
                  {
                    new f.a(f.this, null).a(paramAnonymousMessage);
                    return;
                  }
                }
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              return;
            }
          }
        }
        for (;;)
        {
          long l2;
          try
          {
            paramAnonymousMessage = paramAnonymousMessage.getData();
            if (paramAnonymousMessage != null)
            {
              paramAnonymousMessage = paramAnonymousMessage.getByteArray("loctype");
              if (paramAnonymousMessage != null)
              {
                paramAnonymousMessage = new String(paramAnonymousMessage);
                if ((TextUtils.isEmpty(paramAnonymousMessage)) || (f.this.a == null)) {
                  break;
                }
                l1 = f.this.a.getLong("lastUpTime", 0L);
                localObject1 = f.this.a.edit();
                if (l1 == 0L) {
                  ((SharedPreferences.Editor)localObject1).putLong("lastUpTime", System.currentTimeMillis());
                }
                localObject2 = new HashSet();
                localObject3 = f.this.a.getString("loctypestr", "");
                if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).contains("|")))
                {
                  i = ((String)localObject3).split("\\|").length;
                  if (i > 0)
                  {
                    localObject3 = ((String)localObject3).split("\\|");
                    int k = localObject3.length;
                    i = 0;
                    if (i >= k) {
                      continue;
                    }
                    if (!localObject3[i].contains(";")) {
                      continue;
                    }
                    String[] arrayOfString = localObject3[i].split(";", 2);
                    if (!arrayOfString[0].equals(paramAnonymousMessage)) {
                      continue;
                    }
                    localObject3[i] = (arrayOfString[0] + ";" + (Integer.valueOf(arrayOfString[1]).intValue() + 1));
                    i = 1;
                    continue;
                    if (i < k)
                    {
                      ((Set)localObject2).add(localObject3[i]);
                      i += 1;
                      continue;
                    }
                    ((Set)localObject2).add(paramAnonymousMessage + ";1");
                    paramAnonymousMessage = new StringBuffer();
                    if (((Set)localObject2).size() <= 0) {
                      continue;
                    }
                    localObject3 = (String[])((Set)localObject2).toArray(new String[((Set)localObject2).size()]);
                    i = j;
                    if (i < ((Set)localObject2).size())
                    {
                      paramAnonymousMessage.append(localObject3[i] + "|");
                      i += 1;
                      continue;
                      if (i >= k) {
                        continue;
                      }
                      ((Set)localObject2).add(localObject3[i]);
                      i += 1;
                      continue;
                    }
                  }
                  else
                  {
                    ((Set)localObject2).add(paramAnonymousMessage + ";1");
                    continue;
                  }
                  ((SharedPreferences.Editor)localObject1).putString("loctypestr", paramAnonymousMessage.toString());
                  ((SharedPreferences.Editor)localObject1).commit();
                  l1 = f.this.a.getLong("lastUpTime", 0L);
                  if ((((Set)localObject2).size() <= 0) || (System.currentTimeMillis() - l1 <= 86400000L)) {
                    break;
                  }
                  f.b(f.this, paramAnonymousMessage.toString());
                  ((SharedPreferences.Editor)localObject1).putLong("lastUpTime", System.currentTimeMillis());
                  ((SharedPreferences.Editor)localObject1).putString("loctypestr", "");
                  ((SharedPreferences.Editor)localObject1).commit();
                  return;
                  try
                  {
                    paramAnonymousMessage = new File(f.a(f.this, f.e(f.this)));
                    if ((!paramAnonymousMessage.isDirectory()) || (paramAnonymousMessage.listFiles() == null) || (paramAnonymousMessage.listFiles().length <= 0)) {
                      break;
                    }
                    localObject2 = paramAnonymousMessage.listFiles();
                    paramAnonymousMessage = (Message)localObject3;
                    if (i < localObject2.length)
                    {
                      long l3 = localObject2[i].lastModified();
                      localObject1 = paramAnonymousMessage;
                      l2 = l1;
                      if (l3 <= l1) {
                        break label1390;
                      }
                      if (System.currentTimeMillis() - l3 > 604800000L)
                      {
                        localObject2[i].delete();
                        localObject1 = paramAnonymousMessage;
                        l2 = l1;
                        break label1390;
                      }
                      localObject1 = localObject2[i].getAbsolutePath();
                      l2 = l3;
                      break label1390;
                    }
                    if (paramAnonymousMessage == null) {
                      break;
                    }
                    com.baidu.location.f.f.a();
                    if (!com.baidu.location.f.f.j()) {
                      break;
                    }
                    new f.a(f.this, null).a(paramAnonymousMessage);
                    return;
                  }
                  catch (Exception paramAnonymousMessage)
                  {
                    return;
                  }
                  try
                  {
                    if ((f.a(f.this) == null) || (f.a(f.this).length() <= 0)) {
                      break;
                    }
                    paramAnonymousMessage = f.a(f.this, f.d(f.this)) + File.separator + com.baidu.location.h.g.c() + ".log";
                    f.a(f.this, paramAnonymousMessage, f.a(f.this).toString());
                    f.a(f.this, null);
                    f.a(f.this, 0);
                    return;
                  }
                  catch (Exception paramAnonymousMessage)
                  {
                    return;
                  }
                  i = 0;
                  continue;
                }
                i = 0;
                continue;
              }
            }
            paramAnonymousMessage = null;
            continue;
            if (i == 0)
            {
              i = 0;
              continue;
              i += 1;
              continue;
            }
            i = 0;
            continue;
            continue;
            i += 1;
          }
          catch (Exception paramAnonymousMessage)
          {
            return;
          }
          label1390:
          paramAnonymousMessage = (Message)localObject1;
          l1 = l2;
        }
      }
    };
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (System.currentTimeMillis() - this.k < 3000L) {
      return;
    }
    this.k = System.currentTimeMillis();
    Message localMessage = this.d.obtainMessage(3);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("loctype", paramString.getBytes());
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void c()
  {
    try
    {
      if (this.d != null) {
        this.d.removeCallbacksAndMessages(null);
      }
      this.d = null;
      try
      {
        if (this.c != null)
        {
          this.c.quit();
          this.c.interrupt();
        }
        this.c = null;
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    d();
    Message localMessage = this.d.obtainMessage(2);
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("errorid", paramString.getBytes());
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void d()
  {
    this.d.sendEmptyMessage(5);
  }
  
  private class a
    extends e
  {
    String a = null;
    
    private a() {}
    
    public void a()
    {
      this.l = this.a;
      File localFile = new File(this.l);
      try
      {
        String str = com.baidu.location.h.g.a(localFile, "MD5");
        this.h = "http://loc.map.baidu.com/opre.php";
        this.h = (this.h + "?qt=operations&trtm=" + System.currentTimeMillis());
        if (str != null) {
          this.h = (this.h + "&md5=" + str + "&fn=" + localFile.getName().replace(".zip", ""));
        }
        this.i = 1;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
    
    public void a(String paramString)
    {
      if ((f.g(f.this)) || (TextUtils.isEmpty(paramString))) {
        return;
      }
      this.a = paramString;
      f.a(f.this, true);
      j();
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        File localFile = new File(this.a);
        if (localFile.exists()) {
          localFile.delete();
        }
        f.a(f.this, false);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */