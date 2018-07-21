package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils
{
  private static final String DATA_UPDATE_LOG_FILE_NAME = "DataUpdateLog.txt";
  
  public static boolean copyAssetsFile(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    try
    {
      paramAssetManager = paramAssetManager.open(paramString1);
      paramString1 = new File(paramString2);
      long l = paramString1.length();
      int i = paramAssetManager.available();
      if ((paramString1.exists()) && (l == i))
      {
        paramAssetManager.close();
        return true;
      }
      paramString1 = new FileOutputStream(new File(paramString2));
      paramString2 = new byte['Ѐ'];
      for (;;)
      {
        i = paramAssetManager.read(paramString2);
        if (i <= 0) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
      paramAssetManager.close();
    }
    catch (Exception paramAssetManager)
    {
      LogUtil.e("", paramAssetManager.toString());
      return false;
    }
    paramString1.close();
    return true;
  }
  
  public static boolean copyAssetsFile(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramAssetManager = paramAssetManager.open(paramString1);
      paramString1 = new File(paramString2 + "/" + paramString3);
      int i = paramAssetManager.available();
      if ((paramString1.exists()) && (paramString1.length() == i) && (paramString1.lastModified() > PackageUtil.getApkUpdateTime()))
      {
        paramAssetManager.close();
        return true;
      }
      paramString2 = new File(paramString2);
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      paramString1 = new FileOutputStream(paramString1);
      paramString2 = new byte['Ѐ'];
      for (;;)
      {
        i = paramAssetManager.read(paramString2);
        if (i <= 0) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
      paramAssetManager.close();
    }
    catch (Exception paramAssetManager)
    {
      LogUtil.e("", paramAssetManager.toString());
      return false;
    }
    paramString1.close();
    return true;
  }
  
  public static boolean copyDirectiory(String paramString1, String paramString2)
    throws IOException
  {
    if (!new File(paramString1).exists()) {
      return false;
    }
    boolean bool2 = true;
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new File(paramString1).listFiles();
    int i = 0;
    if (i < localObject1.length)
    {
      boolean bool1 = bool2;
      Object localObject2;
      Object localObject3;
      if (localObject1[i].isFile())
      {
        localObject2 = localObject1[i];
        localObject3 = new File(new File(paramString2).getAbsolutePath() + File.separator + localObject1[i].getName());
        if ((bool2) && (copyFile((File)localObject2, (File)localObject3))) {
          bool1 = true;
        }
      }
      else
      {
        label150:
        bool2 = bool1;
        if (localObject1[i].isDirectory())
        {
          localObject2 = paramString1 + "/" + localObject1[i].getName();
          localObject3 = paramString2 + "/" + localObject1[i].getName();
          if ((!bool1) || (!copyDirectiory((String)localObject2, (String)localObject3))) {
            break label254;
          }
        }
      }
      label254:
      for (bool2 = true;; bool2 = false)
      {
        i += 1;
        break;
        bool1 = false;
        break label150;
      }
    }
    return bool2;
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 42	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: new 127	java/io/BufferedInputStream
    //   23: dup
    //   24: new 129	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: invokespecial 133	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_0
    //   36: new 135	java/io/BufferedOutputStream
    //   39: dup
    //   40: new 47	java/io/FileOutputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 138	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: astore_1
    //   52: sipush 1024
    //   55: newarray <illegal type>
    //   57: astore_3
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 139	java/io/BufferedInputStream:read	([B)I
    //   63: istore_2
    //   64: iload_2
    //   65: iconst_m1
    //   66: if_icmpeq +39 -> 105
    //   69: aload_1
    //   70: aload_3
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 140	java/io/BufferedOutputStream:write	([BII)V
    //   76: goto -18 -> 58
    //   79: astore_3
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   88: aload_1
    //   89: ifnull -82 -> 7
    //   92: aload_1
    //   93: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   103: iconst_0
    //   104: ireturn
    //   105: aload_1
    //   106: invokevirtual 148	java/io/BufferedOutputStream:flush	()V
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   132: goto -15 -> 117
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   140: goto -15 -> 125
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   148: goto -60 -> 88
    //   151: astore_1
    //   152: aload 5
    //   154: astore_0
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   178: goto -15 -> 163
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   186: goto -15 -> 171
    //   189: astore_1
    //   190: goto -35 -> 155
    //   193: astore 4
    //   195: aload_1
    //   196: astore_3
    //   197: aload 4
    //   199: astore_1
    //   200: goto -45 -> 155
    //   203: astore_0
    //   204: aload 6
    //   206: astore_0
    //   207: aload 4
    //   209: astore_1
    //   210: goto -130 -> 80
    //   213: astore_1
    //   214: aload 4
    //   216: astore_1
    //   217: goto -137 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramFile1	File
    //   0	220	1	paramFile2	File
    //   63	10	2	i	int
    //   16	55	3	arrayOfByte	byte[]
    //   79	89	3	localIOException	IOException
    //   196	1	3	localFile	File
    //   18	1	4	localObject1	Object
    //   193	22	4	localObject2	Object
    //   10	143	5	localObject3	Object
    //   13	192	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	79	java/io/IOException
    //   58	64	79	java/io/IOException
    //   69	76	79	java/io/IOException
    //   105	109	79	java/io/IOException
    //   92	96	98	java/io/IOException
    //   113	117	127	java/io/IOException
    //   121	125	135	java/io/IOException
    //   84	88	143	java/io/IOException
    //   20	36	151	finally
    //   159	163	173	java/io/IOException
    //   167	171	181	java/io/IOException
    //   36	52	189	finally
    //   52	58	193	finally
    //   58	64	193	finally
    //   69	76	193	finally
    //   105	109	193	finally
    //   20	36	203	java/io/IOException
    //   36	52	213	java/io/IOException
  }
  
  /* Error */
  public static boolean copyFileSmart(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 42	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 4
    //   20: new 127	java/io/BufferedInputStream
    //   23: dup
    //   24: new 129	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: invokespecial 133	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 150	java/io/BufferedInputStream:available	()I
    //   40: i2l
    //   41: aload_1
    //   42: invokevirtual 32	java/io/File:length	()J
    //   45: lcmp
    //   46: ifne +45 -> 91
    //   49: aload_0
    //   50: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   61: iconst_0
    //   62: ifeq +11 -> 73
    //   65: new 152	java/lang/NullPointerException
    //   68: dup
    //   69: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   72: athrow
    //   73: iconst_1
    //   74: ireturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   80: goto -19 -> 61
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   88: goto -15 -> 73
    //   91: new 135	java/io/BufferedOutputStream
    //   94: dup
    //   95: new 47	java/io/FileOutputStream
    //   98: dup
    //   99: aload_1
    //   100: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: invokespecial 138	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   106: astore_1
    //   107: sipush 1024
    //   110: newarray <illegal type>
    //   112: astore_3
    //   113: aload_0
    //   114: aload_3
    //   115: invokevirtual 139	java/io/BufferedInputStream:read	([B)I
    //   118: istore_2
    //   119: iload_2
    //   120: iconst_m1
    //   121: if_icmpeq +39 -> 160
    //   124: aload_1
    //   125: aload_3
    //   126: iconst_0
    //   127: iload_2
    //   128: invokevirtual 140	java/io/BufferedOutputStream:write	([BII)V
    //   131: goto -18 -> 113
    //   134: astore_3
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   143: aload_1
    //   144: ifnull -137 -> 7
    //   147: aload_1
    //   148: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: aload_1
    //   161: invokevirtual 148	java/io/BufferedOutputStream:flush	()V
    //   164: aload_0
    //   165: ifnull +7 -> 172
    //   168: aload_0
    //   169: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   172: aload_1
    //   173: ifnull +7 -> 180
    //   176: aload_1
    //   177: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   187: goto -15 -> 172
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   195: goto -15 -> 180
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   203: goto -60 -> 143
    //   206: astore_0
    //   207: aload 5
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 141	java/io/BufferedInputStream:close	()V
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 142	java/io/BufferedOutputStream:close	()V
    //   226: aload_0
    //   227: athrow
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   233: goto -15 -> 218
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   241: goto -15 -> 226
    //   244: astore 4
    //   246: aload_0
    //   247: astore_1
    //   248: aload 4
    //   250: astore_0
    //   251: goto -41 -> 210
    //   254: astore 4
    //   256: aload_1
    //   257: astore_3
    //   258: aload_0
    //   259: astore_1
    //   260: aload 4
    //   262: astore_0
    //   263: goto -53 -> 210
    //   266: astore_0
    //   267: aload 6
    //   269: astore_0
    //   270: aload 4
    //   272: astore_1
    //   273: goto -138 -> 135
    //   276: astore_1
    //   277: aload 4
    //   279: astore_1
    //   280: goto -145 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramFile1	File
    //   0	283	1	paramFile2	File
    //   118	10	2	i	int
    //   16	110	3	arrayOfByte	byte[]
    //   134	89	3	localIOException	IOException
    //   257	1	3	localFile	File
    //   18	1	4	localObject1	Object
    //   244	5	4	localObject2	Object
    //   254	24	4	localObject3	Object
    //   10	198	5	localObject4	Object
    //   13	255	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   57	61	75	java/io/IOException
    //   65	73	83	java/io/IOException
    //   107	113	134	java/io/IOException
    //   113	119	134	java/io/IOException
    //   124	131	134	java/io/IOException
    //   160	164	134	java/io/IOException
    //   147	151	153	java/io/IOException
    //   168	172	182	java/io/IOException
    //   176	180	190	java/io/IOException
    //   139	143	198	java/io/IOException
    //   20	36	206	finally
    //   214	218	228	java/io/IOException
    //   222	226	236	java/io/IOException
    //   36	53	244	finally
    //   91	107	244	finally
    //   107	113	254	finally
    //   113	119	254	finally
    //   124	131	254	finally
    //   160	164	254	finally
    //   20	36	266	java/io/IOException
    //   36	53	276	java/io/IOException
    //   91	107	276	java/io/IOException
  }
  
  public static boolean del(String paramString)
    throws IOException
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      if (paramString.isDirectory())
      {
        if (paramString.listFiles().length == 0) {
          bool2 = paramString.delete();
        }
        File[] arrayOfFile;
        int j;
        int i;
        do
        {
          return bool2;
          bool1 = true;
          arrayOfFile = paramString.listFiles();
          j = paramString.listFiles().length;
          i = 0;
          bool2 = bool1;
        } while (i >= j);
        boolean bool2 = bool1;
        if (arrayOfFile[i].isDirectory())
        {
          if ((bool1) && (del(arrayOfFile[i].getAbsolutePath()))) {
            bool2 = true;
          }
        }
        else {
          label97:
          if ((!bool2) || (!arrayOfFile[i].delete())) {
            break label127;
          }
        }
        label127:
        for (boolean bool1 = true;; bool1 = false)
        {
          i += 1;
          break;
          bool2 = false;
          break label97;
        }
      }
      if (paramString.isFile()) {
        return paramString.delete();
      }
    }
    return false;
  }
  
  public static File getDataUpdateLogFile()
  {
    return new File(SysOSAPI.getInstance().GetSDCardPath() + "/" + "DataUpdateLog.txt");
  }
  
  /* Error */
  public static String getMd5ByFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 4
    //   14: new 129	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 180	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: sipush 1024
    //   26: newarray <illegal type>
    //   28: astore_2
    //   29: ldc -74
    //   31: invokestatic 187	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   34: astore_3
    //   35: aload_0
    //   36: aload_2
    //   37: invokevirtual 188	java/io/FileInputStream:read	([B)I
    //   40: istore_1
    //   41: iload_1
    //   42: ifle +41 -> 83
    //   45: aload_3
    //   46: aload_2
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 191	java/security/MessageDigest:update	([BII)V
    //   52: goto -17 -> 35
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +9 -> 66
    //   60: aload_0
    //   61: astore_2
    //   62: aload_3
    //   63: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   66: aload_0
    //   67: ifnull -60 -> 7
    //   70: aload_0
    //   71: invokevirtual 193	java/io/FileInputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   81: aconst_null
    //   82: areturn
    //   83: new 195	java/math/BigInteger
    //   86: dup
    //   87: iconst_1
    //   88: aload_3
    //   89: invokevirtual 199	java/security/MessageDigest:digest	()[B
    //   92: invokespecial 202	java/math/BigInteger:<init>	(I[B)V
    //   95: bipush 16
    //   97: invokevirtual 205	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   100: astore_2
    //   101: aload_0
    //   102: ifnull +50 -> 152
    //   105: aload_0
    //   106: invokevirtual 193	java/io/FileInputStream:close	()V
    //   109: aload_2
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   116: aload_2
    //   117: areturn
    //   118: astore_0
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 193	java/io/FileInputStream:close	()V
    //   127: aload_0
    //   128: athrow
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   134: goto -7 -> 127
    //   137: astore_3
    //   138: aload_0
    //   139: astore_2
    //   140: aload_3
    //   141: astore_0
    //   142: goto -23 -> 119
    //   145: astore_3
    //   146: aload 4
    //   148: astore_0
    //   149: goto -93 -> 56
    //   152: aload_2
    //   153: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   40	9	1	i	int
    //   10	114	2	localObject1	Object
    //   129	2	2	localIOException	IOException
    //   139	14	2	str	String
    //   34	12	3	localMessageDigest	java.security.MessageDigest
    //   55	34	3	localException1	Exception
    //   137	4	3	localObject2	Object
    //   145	1	3	localException2	Exception
    //   12	135	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   23	35	55	java/lang/Exception
    //   35	41	55	java/lang/Exception
    //   45	52	55	java/lang/Exception
    //   83	101	55	java/lang/Exception
    //   70	74	76	java/io/IOException
    //   105	109	111	java/io/IOException
    //   14	23	118	finally
    //   62	66	118	finally
    //   123	127	129	java/io/IOException
    //   23	35	137	finally
    //   35	41	137	finally
    //   45	52	137	finally
    //   83	101	137	finally
    //   14	23	145	java/lang/Exception
  }
  
  public static boolean isExistUpdateLogFile()
  {
    return getDataUpdateLogFile().exists();
  }
  
  public static boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean isValidFilenameChar(char paramChar)
  {
    if (!Character.isLetterOrDigit(paramChar)) {}
    switch (paramChar)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static byte[] readAssetsFile(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramContext.getResources().getAssets().open(paramString);
      localObject1 = localObject2;
      paramContext = new byte[paramString.available()];
      localObject1 = paramContext;
      paramString.read(paramContext);
      localObject1 = paramContext;
      paramString.close();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return (byte[])localObject1;
  }
  
  public static String sanitizeFilename(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  /* Error */
  public static void writeDataUpdateLogToFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 208	com/baidu/navisdk/util/common/FileUtils:getDataUpdateLogFile	()Ljava/io/File;
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_1
    //   6: aconst_null
    //   7: astore_3
    //   8: new 47	java/io/FileOutputStream
    //   11: dup
    //   12: aload_2
    //   13: iconst_1
    //   14: invokespecial 240	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   17: astore_2
    //   18: aload_2
    //   19: aload_0
    //   20: ldc -14
    //   22: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   25: invokevirtual 251	java/io/FileOutputStream:write	([B)V
    //   28: aload_2
    //   29: ldc -3
    //   31: invokestatic 258	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokevirtual 260	java/lang/String:getBytes	()[B
    //   37: invokevirtual 251	java/io/FileOutputStream:write	([B)V
    //   40: aload_2
    //   41: invokevirtual 261	java/io/FileOutputStream:flush	()V
    //   44: aload_2
    //   45: ifnull +75 -> 120
    //   48: aload_2
    //   49: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   58: goto -6 -> 52
    //   61: astore_2
    //   62: aload_3
    //   63: astore_0
    //   64: aload_0
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 192	java/lang/Exception:printStackTrace	()V
    //   70: aload_0
    //   71: ifnull -19 -> 52
    //   74: aload_0
    //   75: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   78: return
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   84: goto -6 -> 78
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 262	java/io/FileOutputStream:close	()V
    //   96: aload_0
    //   97: athrow
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   103: goto -7 -> 96
    //   106: astore_0
    //   107: aload_2
    //   108: astore_1
    //   109: goto -21 -> 88
    //   112: astore_1
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: astore_2
    //   117: goto -53 -> 64
    //   120: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString	String
    //   5	88	1	str	String
    //   98	2	1	localIOException	IOException
    //   108	1	1	localException1	Exception
    //   112	4	1	localException2	Exception
    //   3	46	2	localObject1	Object
    //   61	53	2	localException3	Exception
    //   116	1	2	localObject2	Object
    //   7	56	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   8	18	61	java/lang/Exception
    //   74	78	79	java/io/IOException
    //   8	18	87	finally
    //   66	70	87	finally
    //   92	96	98	java/io/IOException
    //   18	44	106	finally
    //   18	44	112	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */