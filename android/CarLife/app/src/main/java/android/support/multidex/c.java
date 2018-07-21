package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class c
{
  private static final String a = "MultiDex";
  private static final String b = "classes";
  private static final String c = ".dex";
  private static final String d = ".classes";
  private static final String e = ".zip";
  private static final int f = 3;
  private static final String g = "multidex.version";
  private static final String h = "timestamp";
  private static final String i = "crc";
  private static final String j = "dex.number";
  private static final int k = 16384;
  private static final long l = -1L;
  private static Method m;
  
  static
  {
    try
    {
      m = SharedPreferences.Editor.class.getMethod("apply", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      m = null;
    }
  }
  
  private static SharedPreferences a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    for (int n = 0;; n = 4) {
      return paramContext.getSharedPreferences("multidex.version", n);
    }
  }
  
  static List<File> a(Context paramContext, ApplicationInfo paramApplicationInfo, File paramFile, boolean paramBoolean)
    throws IOException
  {
    Log.i("MultiDex", "MultiDexExtractor.load(" + paramApplicationInfo.sourceDir + ", " + paramBoolean + ")");
    File localFile = new File(paramApplicationInfo.sourceDir);
    long l1 = c(localFile);
    if ((!paramBoolean) && (!a(paramContext, localFile, l1))) {}
    for (;;)
    {
      try
      {
        paramApplicationInfo = a(paramContext, localFile, paramFile);
        paramContext = paramApplicationInfo;
      }
      catch (IOException paramApplicationInfo)
      {
        Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", paramApplicationInfo);
        paramApplicationInfo = a(localFile, paramFile);
        a(paramContext, b(localFile), l1, paramApplicationInfo.size() + 1);
        paramContext = paramApplicationInfo;
        continue;
      }
      Log.i("MultiDex", "load found " + paramContext.size() + " secondary dex files");
      return paramContext;
      Log.i("MultiDex", "Detected that extraction must be performed.");
      paramApplicationInfo = a(localFile, paramFile);
      a(paramContext, b(localFile), l1, paramApplicationInfo.size() + 1);
      paramContext = paramApplicationInfo;
    }
  }
  
  private static List<File> a(Context paramContext, File paramFile1, File paramFile2)
    throws IOException
  {
    Log.i("MultiDex", "loading existing secondary dex files");
    paramFile1 = paramFile1.getName() + ".classes";
    int i1 = a(paramContext).getInt("dex.number", 1);
    paramContext = new ArrayList(i1);
    int n = 2;
    while (n <= i1)
    {
      File localFile = new File(paramFile2, paramFile1 + n + ".zip");
      if (localFile.isFile())
      {
        paramContext.add(localFile);
        if (!a(localFile))
        {
          Log.i("MultiDex", "Invalid zip file: " + localFile);
          throw new IOException("Invalid ZIP file.");
        }
      }
      else
      {
        throw new IOException("Missing extracted secondary dex file '" + localFile.getPath() + "'");
      }
      n += 1;
    }
    return paramContext;
  }
  
  private static List<File> a(File paramFile1, File paramFile2)
    throws IOException
  {
    String str2 = paramFile1.getName() + ".classes";
    a(paramFile2, str2);
    localArrayList = new ArrayList();
    localZipFile = new ZipFile(paramFile1);
    n = 2;
    try
    {
      paramFile1 = localZipFile.getEntry("classes" + 2 + ".dex");
      for (;;)
      {
        File localFile;
        int i3;
        String str1;
        if (paramFile1 != null)
        {
          localFile = new File(paramFile2, str2 + n + ".zip");
          localArrayList.add(localFile);
          Log.i("MultiDex", "Extraction is needed for file " + localFile);
          int i1 = 0;
          i3 = 0;
          for (;;)
          {
            if ((i1 >= 3) || (i3 != 0)) {
              break label349;
            }
            int i2 = i1 + 1;
            a(localZipFile, paramFile1, localFile, str2);
            boolean bool = a(localFile);
            StringBuilder localStringBuilder = new StringBuilder().append("Extraction ");
            if (!bool) {
              break;
            }
            str1 = "success";
            label215:
            Log.i("MultiDex", str1 + " - length " + localFile.getAbsolutePath() + ": " + localFile.length());
            i3 = bool;
            i1 = i2;
            if (!bool)
            {
              localFile.delete();
              i3 = bool;
              i1 = i2;
              if (localFile.exists())
              {
                Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + localFile.getPath() + "'");
                i3 = bool;
                i1 = i2;
              }
            }
          }
        }
        try
        {
          localZipFile.close();
          throw paramFile1;
          str1 = "failed";
          break label215;
          if (i3 == 0) {
            throw new IOException("Could not create zip file " + localFile.getAbsolutePath() + " for secondary dex (" + n + ")");
          }
          n += 1;
          paramFile1 = localZipFile.getEntry("classes" + n + ".dex");
          continue;
          try
          {
            localZipFile.close();
            return localArrayList;
          }
          catch (IOException paramFile1)
          {
            Log.w("MultiDex", "Failed to close resource", paramFile1);
            return localArrayList;
          }
        }
        catch (IOException paramFile2)
        {
          for (;;)
          {
            Log.w("MultiDex", "Failed to close resource", paramFile2);
          }
        }
      }
    }
    finally {}
  }
  
  private static void a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    paramContext = a(paramContext).edit();
    paramContext.putLong("timestamp", paramLong1);
    paramContext.putLong("crc", paramLong2);
    paramContext.putInt("dex.number", paramInt);
    a(paramContext);
  }
  
  private static void a(SharedPreferences.Editor paramEditor)
  {
    if (m != null) {}
    try
    {
      m.invoke(paramEditor, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramEditor.commit();
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("MultiDex", "Failed to close resource", paramCloseable);
    }
  }
  
  private static void a(File paramFile, String paramString)
    throws IOException
  {
    d(paramFile.getParentFile());
    d(paramFile);
    paramString = paramFile.listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return !paramAnonymousFile.getName().startsWith(this.a);
      }
    });
    if (paramString == null)
    {
      Log.w("MultiDex", "Failed to list secondary dex dir content (" + paramFile.getPath() + ").");
      return;
    }
    int i1 = paramString.length;
    int n = 0;
    label69:
    if (n < i1)
    {
      paramFile = paramString[n];
      Log.i("MultiDex", "Trying to delete old file " + paramFile.getPath() + " of size " + paramFile.length());
      if (paramFile.delete()) {
        break label163;
      }
      Log.w("MultiDex", "Failed to delete old file " + paramFile.getPath());
    }
    for (;;)
    {
      n += 1;
      break label69;
      break;
      label163:
      Log.i("MultiDex", "Deleted old file " + paramFile.getPath());
    }
  }
  
  private static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
    throws IOException, FileNotFoundException
  {
    InputStream localInputStream = paramZipFile.getInputStream(paramZipEntry);
    paramString = File.createTempFile(paramString, ".zip", paramFile.getParentFile());
    Log.i("MultiDex", "Extracting " + paramString.getPath());
    for (;;)
    {
      try
      {
        paramZipFile = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString)));
      }
      finally
      {
        ZipEntry localZipEntry;
        int n;
        continue;
      }
      try
      {
        localZipEntry = new ZipEntry("classes.dex");
        localZipEntry.setTime(paramZipEntry.getTime());
        paramZipFile.putNextEntry(localZipEntry);
        paramZipEntry = new byte['䀀'];
        n = localInputStream.read(paramZipEntry);
        if (n != -1)
        {
          paramZipFile.write(paramZipEntry, 0, n);
          n = localInputStream.read(paramZipEntry);
        }
        else
        {
          paramZipFile.closeEntry();
          try
          {
            paramZipFile.close();
            Log.i("MultiDex", "Renaming to " + paramFile.getPath());
            if (paramString.renameTo(paramFile)) {
              continue;
            }
            throw new IOException("Failed to rename \"" + paramString.getAbsolutePath() + "\" to \"" + paramFile.getAbsolutePath() + "\"");
          }
          finally {}
          a(localInputStream);
          paramString.delete();
          throw paramZipFile;
        }
      }
      finally
      {
        paramZipFile.close();
      }
    }
    a(localInputStream);
    paramString.delete();
  }
  
  private static boolean a(Context paramContext, File paramFile, long paramLong)
  {
    paramContext = a(paramContext);
    return (paramContext.getLong("timestamp", -1L) != b(paramFile)) || (paramContext.getLong("crc", -1L) != paramLong);
  }
  
  static boolean a(File paramFile)
  {
    try
    {
      ZipFile localZipFile = new ZipFile(paramFile);
      try
      {
        localZipFile.close();
        return true;
      }
      catch (IOException localIOException1)
      {
        Log.w("MultiDex", "Failed to close zip file: " + paramFile.getAbsolutePath());
      }
    }
    catch (ZipException localZipException)
    {
      for (;;)
      {
        Log.w("MultiDex", "File " + paramFile.getAbsolutePath() + " is not a valid zip file.", localZipException);
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.w("MultiDex", "Got an IOException trying to open zip file: " + paramFile.getAbsolutePath(), localIOException2);
      }
    }
    return false;
  }
  
  private static long b(File paramFile)
  {
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static long c(File paramFile)
    throws IOException
  {
    long l2 = d.a(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static void d(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null) {
        Log.e("MultiDex", "Failed to create dir " + paramFile.getPath() + ". Parent file is null.");
      }
      for (;;)
      {
        throw new IOException("Failed to create cache directory " + paramFile.getPath());
        Log.e("MultiDex", "Failed to create dir " + paramFile.getPath() + ". parent file is a dir " + localFile.isDirectory() + ", a file " + localFile.isFile() + ", exists " + localFile.exists() + ", readable " + localFile.canRead() + ", writable " + localFile.canWrite());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/android/support/multidex/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */