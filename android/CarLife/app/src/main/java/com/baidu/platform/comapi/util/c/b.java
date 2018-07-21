package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.baidu.platform.comapi.util.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class b
{
  private static final String a = "AssetManagerCompat";
  private String b;
  
  public b(Context paramContext)
  {
    this.b = a(paramContext);
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 8) {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).sourceDir;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        f.c("AssetManagerCompat", "", paramContext);
        return "";
      }
    }
    return paramContext.getPackageCodePath();
  }
  
  public void a(String paramString, a parama)
    throws IOException
  {
    Object localObject = new StringBuilder().append("assets/");
    String str = paramString;
    if (paramString.startsWith("/")) {
      str = paramString.substring(1);
    }
    str = str;
    paramString = new ZipFile(this.b);
    localObject = paramString.entries();
    try
    {
      while (((Enumeration)localObject).hasMoreElements())
      {
        ZipEntry localZipEntry = (ZipEntry)((Enumeration)localObject).nextElement();
        if (localZipEntry.getName().startsWith(str)) {
          parama.a(paramString, localZipEntry);
        }
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  /* Error */
  public void a(String paramString, b paramb)
    throws IOException
  {
    // Byte code:
    //   0: new 93	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: getfield 23	com/baidu/platform/comapi/util/c/b:b	Ljava/lang/String;
    //   8: invokespecial 96	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: new 69	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   20: ldc 72
    //   22: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: astore 5
    //   27: aload_1
    //   28: astore_3
    //   29: aload_1
    //   30: ldc 78
    //   32: invokevirtual 84	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   35: ifeq +9 -> 44
    //   38: aload_1
    //   39: iconst_1
    //   40: invokevirtual 88	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: astore_3
    //   44: aload 4
    //   46: aload 5
    //   48: aload_3
    //   49: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 127	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +21 -> 81
    //   63: aload 4
    //   65: aload_1
    //   66: invokevirtual 131	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   69: astore_1
    //   70: aload_2
    //   71: aload_1
    //   72: invokeinterface 134 2 0
    //   77: aload_1
    //   78: invokevirtual 137	java/io/InputStream:close	()V
    //   81: aload 4
    //   83: invokevirtual 121	java/util/zip/ZipFile:close	()V
    //   86: return
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 137	java/io/InputStream:close	()V
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: aload 4
    //   97: invokevirtual 121	java/util/zip/ZipFile:close	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	b
    //   0	102	1	paramString	String
    //   0	102	2	paramb	b
    //   28	21	3	str	String
    //   11	85	4	localZipFile	ZipFile
    //   25	22	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	77	87	finally
    //   13	27	94	finally
    //   29	44	94	finally
    //   44	59	94	finally
    //   63	70	94	finally
    //   77	81	94	finally
    //   88	94	94	finally
  }
  
  public static abstract interface a
  {
    public abstract void a(ZipFile paramZipFile, ZipEntry paramZipEntry)
      throws IOException;
  }
  
  public static abstract interface b
  {
    public abstract void a(InputStream paramInputStream)
      throws IOException;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */