package com.baidu.carlife.logic;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.util.p;
import com.baidu.carlife.util.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class t
{
  public static final String a = t.class.getSimpleName();
  public static final String b = "DefaultSkin";
  public static final int c = -1;
  public static final String d = "com.baidu.carlife.skin";
  public static final String e = ".cls";
  private static final String f = "CurrentSkinName";
  private static t g;
  private List<b> h = new ArrayList();
  private CarlifeActivity i;
  private String j;
  private boolean k;
  
  public static t a()
  {
    if (g == null) {
      g = new t();
    }
    return g;
  }
  
  private void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    paramFile.delete();
  }
  
  private void a(InputStream paramInputStream, String paramString, int paramInt, boolean paramBoolean)
  {
    this.k = paramBoolean;
    new a(paramInputStream, paramString, paramInt).execute(new Void[0]);
  }
  
  private void a(boolean paramBoolean)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b(paramBoolean);
    }
  }
  
  /* Error */
  private boolean a(InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 117	java/io/FileOutputStream
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   14: astore 4
    //   16: sipush 1024
    //   19: newarray <illegal type>
    //   21: astore 5
    //   23: aload_1
    //   24: aload 5
    //   26: invokevirtual 125	java/io/InputStream:read	([B)I
    //   29: istore_3
    //   30: iload_3
    //   31: iconst_m1
    //   32: if_icmpeq +28 -> 60
    //   35: aload 4
    //   37: aload 5
    //   39: iconst_0
    //   40: iload_3
    //   41: invokevirtual 129	java/io/FileOutputStream:write	([BII)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload 4
    //   50: ifnull +8 -> 58
    //   53: aload 4
    //   55: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   58: iconst_0
    //   59: ireturn
    //   60: aload 4
    //   62: invokevirtual 135	java/io/FileOutputStream:flush	()V
    //   65: aload 4
    //   67: ifnull +8 -> 75
    //   70: aload 4
    //   72: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   75: getstatic 45	com/baidu/carlife/logic/t:a	Ljava/lang/String;
    //   78: new 137	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   85: ldc -116
    //   87: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: invokevirtual 147	java/io/File:getName	()Ljava/lang/String;
    //   94: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 155	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: iconst_1
    //   104: ireturn
    //   105: astore_1
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_2
    //   112: aload 5
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   123: aload_2
    //   124: athrow
    //   125: astore_1
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_2
    //   129: aload 4
    //   131: astore_1
    //   132: goto -17 -> 115
    //   135: astore_1
    //   136: aload 6
    //   138: astore 4
    //   140: goto -92 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	t
    //   0	143	1	paramInputStream	InputStream
    //   0	143	2	paramFile	File
    //   29	12	3	m	int
    //   14	125	4	localObject1	Object
    //   1	112	5	arrayOfByte	byte[]
    //   4	133	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	23	47	java/io/IOException
    //   23	30	47	java/io/IOException
    //   35	44	47	java/io/IOException
    //   60	65	47	java/io/IOException
    //   70	75	105	java/io/IOException
    //   53	58	108	java/io/IOException
    //   6	16	111	finally
    //   119	123	125	java/io/IOException
    //   16	23	128	finally
    //   23	30	128	finally
    //   35	44	128	finally
    //   60	65	128	finally
    //   6	16	135	java/io/IOException
  }
  
  private File b(InputStream paramInputStream, String paramString, int paramInt)
  {
    if ((paramInputStream == null) || (TextUtils.isEmpty(paramString))) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      File localFile = new File(this.j + File.separator + paramString);
      int m = b(paramString);
      i.b(a, "data皮肤包:" + paramString + ",版本号:" + m);
      if (paramInt > m)
      {
        i.b(a, "data皮肤包:" + paramString + ",升级为版本:" + paramInt);
        a(localFile);
      }
      if (!localFile.exists()) {}
      try
      {
        localFile.createNewFile();
        paramString = localFile;
        if (localFile.length() < 1L)
        {
          paramString = localFile;
          if (!a(paramInputStream, localFile))
          {
            a(localFile);
            return null;
          }
        }
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    return null;
  }
  
  private boolean d(String paramString)
  {
    return "CLS_Blue.cls".equals(paramString);
  }
  
  private boolean e(String paramString)
  {
    return "CLS_Black.cls".equals(paramString);
  }
  
  private int f(String paramString)
  {
    if ("CLS_Blue.cls".equals(paramString)) {
      return 3;
    }
    return -1;
  }
  
  private void g(String paramString)
  {
    if (paramString != null) {
      p.a().b("CurrentSkinName", paramString);
    }
  }
  
  public void a(CarlifeActivity paramCarlifeActivity)
  {
    this.i = paramCarlifeActivity;
    this.j = (BaiduNaviApplication.getInstance().getFilesDir().getAbsolutePath() + File.separator + "skin");
    Object localObject = new File(this.j);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = c();
    if (e((String)localObject))
    {
      g("DefaultSkin");
      localObject = new File(this.j + File.separator + (String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    String str = c();
    localObject = null;
    if (d(str)) {}
    try
    {
      paramCarlifeActivity = paramCarlifeActivity.getResources().getAssets().open(str);
      for (;;)
      {
        a(paramCarlifeActivity, str, f(str), true);
        return;
        File localFile = new File(this.j + File.separator + str);
        paramCarlifeActivity = (CarlifeActivity)localObject;
        if (localFile.isFile()) {
          try
          {
            paramCarlifeActivity = new FileInputStream(localFile);
          }
          catch (FileNotFoundException paramCarlifeActivity)
          {
            paramCarlifeActivity = (CarlifeActivity)localObject;
          }
        }
      }
    }
    catch (IOException paramCarlifeActivity)
    {
      for (;;)
      {
        paramCarlifeActivity = (CarlifeActivity)localObject;
      }
    }
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {}
    while (this.h.contains(paramb)) {
      return;
    }
    this.h.add(paramb);
  }
  
  public void a(File paramFile, int paramInt)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      try
      {
        b(localFileInputStream, paramFile.getName(), paramInt);
        if (localFileInputStream != null) {}
        try
        {
          localFileInputStream.close();
          return;
        }
        catch (IOException paramFile)
        {
          for (;;)
          {
            paramFile.printStackTrace();
          }
        }
        paramFile.printStackTrace();
      }
      catch (FileNotFoundException paramFile) {}
    }
    catch (FileNotFoundException paramFile)
    {
      for (;;) {}
    }
  }
  
  public void a(InputStream paramInputStream, String paramString, int paramInt)
  {
    a(paramInputStream, paramString, paramInt, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2 = new File(this.j + File.separator + paramString);
    Object localObject1 = null;
    try
    {
      localObject2 = new FileInputStream((File)localObject2);
      localObject1 = localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
    a((InputStream)localObject1, paramString, paramInt, false);
  }
  
  public boolean a(String paramString)
  {
    File[] arrayOfFile = new File(this.j).listFiles();
    if (arrayOfFile != null)
    {
      int n = arrayOfFile.length;
      int m = 0;
      while (m < n)
      {
        if (arrayOfFile[m].getName().equals(paramString)) {
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  public int b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"DefaultSkin".equals(paramString)))
    {
      paramString = new File(this.j + File.separator + paramString);
      if (paramString.exists())
      {
        paramString = this.i.getPackageManager().getPackageArchiveInfo(paramString.getAbsolutePath(), 1);
        if ((paramString != null) && ("com.baidu.carlife.skin".equals(paramString.packageName))) {
          return paramString.versionCode;
        }
      }
    }
    return -1;
  }
  
  public String b()
  {
    return this.j;
  }
  
  public void b(b paramb)
  {
    if (this.h.contains(paramb)) {
      this.h.remove(paramb);
    }
  }
  
  public String c()
  {
    return p.a().a("CurrentSkinName", "DefaultSkin");
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(this.j + File.separator + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
    }
  }
  
  public void d()
  {
    g("DefaultSkin");
    r.b();
    a(true);
  }
  
  private class a
    extends AsyncTask<Void, Void, Resources>
  {
    private File b;
    private String c;
    private InputStream d;
    private int e;
    
    a(InputStream paramInputStream, String paramString, int paramInt)
    {
      this.d = paramInputStream;
      this.c = paramString;
      this.e = paramInt;
    }
    
    protected Resources a(Void... paramVarArgs)
    {
      this.c = null;
      if ((t.a(t.this) == null) || (this.d == null) || (this.c == null)) {}
      do
      {
        do
        {
          return null;
        } while (!this.c.contains(".cls"));
        this.b = t.a(t.this, this.d, this.c, this.e);
      } while (this.b == null);
      try
      {
        paramVarArgs = (AssetManager)AssetManager.class.newInstance();
        paramVarArgs.getClass().getMethod("addAssetPath", new Class[] { String.class }).invoke(paramVarArgs, new Object[] { this.b.getAbsolutePath() });
        Resources localResources = t.a(t.this).getResources();
        paramVarArgs = new Resources(paramVarArgs, localResources.getDisplayMetrics(), localResources.getConfiguration());
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
    
    protected void a(Resources paramResources)
    {
      super.onPostExecute(paramResources);
      if (this.d != null) {}
      try
      {
        this.d.close();
        if (paramResources == null) {
          if (t.b(t.this))
          {
            t.a(t.this, "DefaultSkin");
            t.a(t.this, true);
          }
        }
        for (;;)
        {
          i.b(t.a);
          return;
          t.a(t.this, false);
          continue;
          r.a().clear();
          r.a(paramResources);
          t.a(t.this, this.b.getName());
          t.a(t.this, true);
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */