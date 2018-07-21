package com.baidu.navi.common.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.util.EncodingUtils;

public class FileUtils
{
  public static byte[] InputStreamToByte(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(i);
    }
    paramInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  public static String ReadTxtFile(String paramString)
  {
    String str1 = "";
    Object localObject = new File(paramString);
    paramString = str1;
    String str2;
    String str3;
    if (!((File)localObject).isDirectory())
    {
      str2 = str1;
      str3 = str1;
    }
    try
    {
      localObject = new FileInputStream((File)localObject);
      paramString = str1;
      if (localObject != null)
      {
        str2 = str1;
        str3 = str1;
        InputStreamReader localInputStreamReader = new InputStreamReader((InputStream)localObject);
        str2 = str1;
        str3 = str1;
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        for (paramString = str1;; paramString = paramString + str1 + "\n")
        {
          str2 = paramString;
          str3 = paramString;
          str1 = localBufferedReader.readLine();
          if (str1 == null) {
            break;
          }
          str2 = paramString;
          str3 = paramString;
        }
        str2 = paramString;
        str3 = paramString;
        ((InputStream)localObject).close();
        str2 = paramString;
        str3 = paramString;
        localInputStreamReader.close();
      }
      return paramString;
    }
    catch (IOException paramString)
    {
      return str2;
    }
    catch (FileNotFoundException paramString) {}
    return str3;
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  private static boolean copyAssetsFile(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 11
    //   12: aload 12
    //   14: astore 9
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 102	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_0
    //   22: aload_0
    //   23: astore 8
    //   25: aload 12
    //   27: astore 9
    //   29: aload_0
    //   30: astore 10
    //   32: new 48	java/io/File
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_0
    //   42: astore 8
    //   44: aload 12
    //   46: astore 9
    //   48: aload_0
    //   49: astore 10
    //   51: aload_1
    //   52: invokevirtual 106	java/io/File:length	()J
    //   55: lstore 5
    //   57: aload_0
    //   58: astore 8
    //   60: aload 12
    //   62: astore 9
    //   64: aload_0
    //   65: astore 10
    //   67: aload_0
    //   68: invokevirtual 109	java/io/InputStream:available	()I
    //   71: istore 4
    //   73: aload_0
    //   74: astore 8
    //   76: aload 12
    //   78: astore 9
    //   80: aload_0
    //   81: astore 10
    //   83: aload_1
    //   84: invokevirtual 112	java/io/File:exists	()Z
    //   87: istore 7
    //   89: iload 7
    //   91: ifeq +22 -> 113
    //   94: lload 5
    //   96: iload 4
    //   98: i2l
    //   99: lcmp
    //   100: ifne +13 -> 113
    //   103: aload_0
    //   104: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   107: aconst_null
    //   108: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   111: iconst_1
    //   112: ireturn
    //   113: aload_0
    //   114: astore 8
    //   116: aload 12
    //   118: astore 9
    //   120: aload_0
    //   121: astore 10
    //   123: new 48	java/io/File
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore_1
    //   132: aload_0
    //   133: astore 8
    //   135: aload 12
    //   137: astore 9
    //   139: aload_0
    //   140: astore 10
    //   142: aload_1
    //   143: invokevirtual 112	java/io/File:exists	()Z
    //   146: ifne +18 -> 164
    //   149: aload_0
    //   150: astore 8
    //   152: aload 12
    //   154: astore 9
    //   156: aload_0
    //   157: astore 10
    //   159: aload_1
    //   160: invokevirtual 117	java/io/File:mkdirs	()Z
    //   163: pop
    //   164: aload_0
    //   165: astore 8
    //   167: aload 12
    //   169: astore 9
    //   171: aload_0
    //   172: astore 10
    //   174: new 48	java/io/File
    //   177: dup
    //   178: new 76	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   185: aload_2
    //   186: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 119
    //   191: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_3
    //   195: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   204: astore_1
    //   205: aload_0
    //   206: astore 8
    //   208: aload 12
    //   210: astore 9
    //   212: aload_0
    //   213: astore 10
    //   215: ldc 121
    //   217: new 76	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   224: ldc 123
    //   226: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_2
    //   230: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 119
    //   235: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 129	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_1
    //   249: ifnull +52 -> 301
    //   252: aload_0
    //   253: astore 8
    //   255: aload 12
    //   257: astore 9
    //   259: aload_0
    //   260: astore 10
    //   262: aload_1
    //   263: invokevirtual 112	java/io/File:exists	()Z
    //   266: ifeq +35 -> 301
    //   269: aload_0
    //   270: astore 8
    //   272: aload 12
    //   274: astore 9
    //   276: aload_0
    //   277: astore 10
    //   279: aload_1
    //   280: invokevirtual 132	java/io/File:delete	()Z
    //   283: pop
    //   284: aload_0
    //   285: astore 8
    //   287: aload 12
    //   289: astore 9
    //   291: aload_0
    //   292: astore 10
    //   294: ldc 121
    //   296: ldc -122
    //   298: invokestatic 129	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload_0
    //   302: astore 8
    //   304: aload 12
    //   306: astore 9
    //   308: aload_0
    //   309: astore 10
    //   311: new 136	java/io/FileOutputStream
    //   314: dup
    //   315: aload_1
    //   316: invokespecial 137	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   319: astore_1
    //   320: sipush 1024
    //   323: newarray <illegal type>
    //   325: astore_2
    //   326: aload_0
    //   327: aload_2
    //   328: invokevirtual 140	java/io/InputStream:read	([B)I
    //   331: istore 4
    //   333: iload 4
    //   335: ifle +35 -> 370
    //   338: aload_1
    //   339: aload_2
    //   340: iconst_0
    //   341: iload 4
    //   343: invokevirtual 145	java/io/OutputStream:write	([BII)V
    //   346: goto -20 -> 326
    //   349: astore_2
    //   350: aload_0
    //   351: astore 8
    //   353: aload_1
    //   354: astore 9
    //   356: aload_2
    //   357: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   360: aload_0
    //   361: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   364: aload_1
    //   365: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   368: iconst_0
    //   369: ireturn
    //   370: aload_0
    //   371: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   374: aload_1
    //   375: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   378: iconst_1
    //   379: ireturn
    //   380: astore_1
    //   381: aload 8
    //   383: astore_0
    //   384: aload_0
    //   385: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   388: aload 9
    //   390: invokestatic 114	com/baidu/navi/common/util/FileUtils:close	(Ljava/io/Closeable;)V
    //   393: aload_1
    //   394: athrow
    //   395: astore_2
    //   396: aload_1
    //   397: astore 9
    //   399: aload_2
    //   400: astore_1
    //   401: goto -17 -> 384
    //   404: astore_2
    //   405: aload 10
    //   407: astore_0
    //   408: aload 11
    //   410: astore_1
    //   411: goto -61 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	paramAssetManager	AssetManager
    //   0	414	1	paramString1	String
    //   0	414	2	paramString2	String
    //   0	414	3	paramString3	String
    //   71	271	4	i	int
    //   55	40	5	l	long
    //   87	3	7	bool	boolean
    //   4	378	8	localAssetManager1	AssetManager
    //   14	384	9	localObject1	Object
    //   1	405	10	localAssetManager2	AssetManager
    //   10	399	11	localObject2	Object
    //   7	298	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   320	326	349	java/lang/Exception
    //   326	333	349	java/lang/Exception
    //   338	346	349	java/lang/Exception
    //   16	22	380	finally
    //   32	41	380	finally
    //   51	57	380	finally
    //   67	73	380	finally
    //   83	89	380	finally
    //   123	132	380	finally
    //   142	149	380	finally
    //   159	164	380	finally
    //   174	205	380	finally
    //   215	248	380	finally
    //   262	269	380	finally
    //   279	284	380	finally
    //   294	301	380	finally
    //   311	320	380	finally
    //   356	360	380	finally
    //   320	326	395	finally
    //   326	333	395	finally
    //   338	346	395	finally
    //   16	22	404	java/lang/Exception
    //   32	41	404	java/lang/Exception
    //   51	57	404	java/lang/Exception
    //   67	73	404	java/lang/Exception
    //   83	89	404	java/lang/Exception
    //   123	132	404	java/lang/Exception
    //   142	149	404	java/lang/Exception
    //   159	164	404	java/lang/Exception
    //   174	205	404	java/lang/Exception
    //   215	248	404	java/lang/Exception
    //   262	269	404	java/lang/Exception
    //   279	284	404	java/lang/Exception
    //   294	301	404	java/lang/Exception
    //   311	320	404	java/lang/Exception
  }
  
  public static File createFileIfNotExists(String paramString)
  {
    paramString = new File(paramString);
    File localFile = paramString.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    try
    {
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      return paramString;
    }
    catch (IOException localIOException) {}
    return paramString;
  }
  
  public static File createFileWhetherExists(String paramString)
  {
    paramString = new File(paramString);
    File localFile = paramString.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException) {}
    return paramString;
  }
  
  public static void deleteAll(File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return;
      if ((paramFile.isFile()) || ((paramFile.exists()) && (paramFile.list() != null) && (paramFile.list().length == 0)))
      {
        paramFile.delete();
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteAll(arrayOfFile[i]);
          arrayOfFile[i].delete();
          i += 1;
        }
      }
    } while (!paramFile.exists());
    paramFile.delete();
  }
  
  public static boolean fileExists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static String getStringFromAssertFile(Context paramContext, String paramString)
  {
    Context localContext2 = null;
    Context localContext1 = null;
    try
    {
      paramContext = paramContext.getResources().getAssets().open(paramString);
      localContext1 = paramContext;
      localContext2 = paramContext;
      paramString = new byte[paramContext.available()];
      localContext1 = paramContext;
      localContext2 = paramContext;
      paramContext.read(paramString);
      localContext1 = paramContext;
      localContext2 = paramContext;
      paramString = EncodingUtils.getString(paramString, "utf-8");
      return paramString;
    }
    catch (Exception paramContext)
    {
      return "";
    }
    finally
    {
      close(localContext2);
    }
  }
  
  public static void makeFileDirectories(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString).getParentFile();
    } while ((paramString == null) || (paramString.exists()));
    paramString.mkdirs();
  }
  
  public static boolean writeToFile(File paramFile, boolean paramBoolean, String paramString)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile, paramBoolean);
      paramString = paramString.getBytes();
      paramFile.write(paramString, 0, paramString.length);
      paramFile.close();
      return true;
    }
    catch (Exception paramFile) {}
    return false;
  }
  
  public static class UnzipLibraryRunnable
    implements Runnable
  {
    private static final int BUFFER_SIZE = 1024;
    private String onlyUnzipFile;
    private String outputDictory;
    private UnzipCallBack unzipCallBack;
    private String zipPath;
    
    public UnzipLibraryRunnable(String paramString1, String paramString2, UnzipCallBack paramUnzipCallBack)
    {
      this(paramString1, paramString2, null, paramUnzipCallBack);
    }
    
    public UnzipLibraryRunnable(String paramString1, String paramString2, String paramString3, UnzipCallBack paramUnzipCallBack)
    {
      this.zipPath = paramString1;
      this.outputDictory = paramString2;
      this.onlyUnzipFile = paramString3;
      this.unzipCallBack = paramUnzipCallBack;
    }
    
    private String getOutputFilePath(String paramString)
    {
      String str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.indexOf("\\") != -1) {
          str = paramString.replaceAll("\\\\", File.separator);
        }
      }
      return this.outputDictory + File.separator + str;
    }
    
    public void run()
    {
      do
      {
        try
        {
          ZipFile localZipFile = new ZipFile(this.zipPath);
          Enumeration localEnumeration = localZipFile.entries();
          byte[] arrayOfByte = new byte['Ѐ'];
          while (localEnumeration.hasMoreElements())
          {
            localObject1 = (ZipEntry)localEnumeration.nextElement();
            if (!((ZipEntry)localObject1).isDirectory())
            {
              localObject2 = getOutputFilePath(((ZipEntry)localObject1).getName());
              if ((TextUtils.isEmpty(this.onlyUnzipFile)) || (((String)localObject2).indexOf(this.onlyUnzipFile) != -1))
              {
                localObject2 = new BufferedOutputStream(new FileOutputStream(FileUtils.createFileIfNotExists((String)localObject2)));
                localObject1 = new BufferedInputStream(localZipFile.getInputStream((ZipEntry)localObject1));
                for (;;)
                {
                  int i = ((InputStream)localObject1).read(arrayOfByte, 0, 1024);
                  if (i == -1) {
                    break;
                  }
                  ((OutputStream)localObject2).write(arrayOfByte, 0, i);
                }
              }
            }
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            Object localObject1;
            Object localObject2;
            if (this.unzipCallBack != null) {
              this.unzipCallBack.onUnzipErr();
            }
            return;
            ((OutputStream)localObject2).flush();
            ((InputStream)localObject1).close();
            ((OutputStream)localObject2).close();
          }
        }
        catch (IOException localIOException)
        {
          while (this.unzipCallBack == null) {}
          this.unzipCallBack.onUnzipErr();
          return;
        }
        localIOException.close();
      } while (this.unzipCallBack == null);
      this.unzipCallBack.onSuccess();
    }
    
    public static abstract interface UnzipCallBack
    {
      public abstract void onSuccess();
      
      public abstract void onUnzipErr();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/common/util/FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */