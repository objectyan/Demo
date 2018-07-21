package com.baidu.mpcr.model;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mpcr.jni.MpcrAppJni;
import java.io.File;

public class OEMChannel
{
  private static final String TAG = OEMChannel.class.getSimpleName();
  private static OEMChannel oemChannel;
  private boolean hasChannelFile = false;
  private String oemChannelFile = "libBDoeminfo_baidu.so";
  private String path = null;
  
  static
  {
    System.loadLibrary("mpcr");
  }
  
  /* Error */
  public static OEMChannel getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 46	com/baidu/mpcr/model/OEMChannel:oemChannel	Lcom/baidu/mpcr/model/OEMChannel;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	com/baidu/mpcr/model/OEMChannel
    //   15: dup
    //   16: invokespecial 47	com/baidu/mpcr/model/OEMChannel:<init>	()V
    //   19: putstatic 46	com/baidu/mpcr/model/OEMChannel:oemChannel	Lcom/baidu/mpcr/model/OEMChannel;
    //   22: ldc 2
    //   24: monitorexit
    //   25: getstatic 46	com/baidu/mpcr/model/OEMChannel:oemChannel	Lcom/baidu/mpcr/model/OEMChannel;
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	5	0	localOEMChannel	OEMChannel
    //   34	5	0	localObject1	Object
    //   40	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	34	finally
    //   35	38	34	finally
    //   3	12	40	finally
    //   25	29	40	finally
    //   38	40	40	finally
  }
  
  public String buildInnerPath()
  {
    File localFile = new File(new StringBuilder(String.valueOf(Environment.getRootDirectory().getAbsolutePath())).append("/lib").toString() + File.separator + this.oemChannelFile);
    if (localFile.exists())
    {
      this.hasChannelFile = true;
      this.path = localFile.getAbsolutePath();
      return this.path;
    }
    return null;
  }
  
  public String buildInnerPath(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return null;
      paramString = new File(paramString, this.oemChannelFile);
    } while (!paramString.exists());
    this.hasChannelFile = true;
    this.path = paramString.getAbsolutePath();
    return this.path;
  }
  
  public String buildPath(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    this.hasChannelFile = true;
    this.path = paramString.getAbsolutePath();
    return this.path;
  }
  
  public String decryptStr(String paramString)
  {
    return new MpcrAppJni().decryptStr(paramString);
  }
  
  /* Error */
  public String getChannelInfo()
  {
    // Byte code:
    //   0: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aconst_null
    //   5: astore 6
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 11
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 7
    //   27: aload 10
    //   29: astore_3
    //   30: aload 11
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 42	com/baidu/mpcr/model/OEMChannel:path	Ljava/lang/String;
    //   38: ifnull +301 -> 339
    //   41: aload 10
    //   43: astore_3
    //   44: aload 11
    //   46: astore 4
    //   48: new 50	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: getfield 42	com/baidu/mpcr/model/OEMChannel:path	Ljava/lang/String;
    //   56: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 86	java/io/File:exists	()Z
    //   62: ifeq +277 -> 339
    //   65: aload 10
    //   67: astore_3
    //   68: aload 11
    //   70: astore 4
    //   72: new 114	java/io/FileInputStream
    //   75: dup
    //   76: new 50	java/io/File
    //   79: dup
    //   80: aload_0
    //   81: getfield 42	com/baidu/mpcr/model/OEMChannel:path	Ljava/lang/String;
    //   84: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore_2
    //   91: new 119	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: invokespecial 120	java/io/ByteArrayOutputStream:<init>	()V
    //   98: astore 4
    //   100: aload 5
    //   102: astore_3
    //   103: sipush 1024
    //   106: newarray <illegal type>
    //   108: astore 6
    //   110: aload 5
    //   112: astore_3
    //   113: aload_2
    //   114: aload 6
    //   116: invokevirtual 124	java/io/FileInputStream:read	([B)I
    //   119: istore_1
    //   120: iload_1
    //   121: iconst_m1
    //   122: if_icmpne +82 -> 204
    //   125: aload 5
    //   127: astore_3
    //   128: aload 4
    //   130: invokevirtual 128	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   133: invokestatic 134	com/baidu/mpcr/tools/ZipTools:decompress	([B)[B
    //   136: astore 7
    //   138: aload 5
    //   140: astore_3
    //   141: new 100	com/baidu/mpcr/jni/MpcrAppJni
    //   144: dup
    //   145: invokespecial 101	com/baidu/mpcr/jni/MpcrAppJni:<init>	()V
    //   148: astore 6
    //   150: aload 5
    //   152: astore_3
    //   153: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   156: pop2
    //   157: aload 5
    //   159: astore_3
    //   160: aload 6
    //   162: new 63	java/lang/String
    //   165: dup
    //   166: aload 7
    //   168: invokespecial 137	java/lang/String:<init>	([B)V
    //   171: invokevirtual 103	com/baidu/mpcr/jni/MpcrAppJni:decryptStr	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: astore_3
    //   179: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   182: pop2
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 140	java/io/ByteArrayOutputStream:close	()V
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 141	java/io/FileInputStream:close	()V
    //   201: aload 5
    //   203: areturn
    //   204: aload 5
    //   206: astore_3
    //   207: aload 4
    //   209: aload 6
    //   211: iconst_0
    //   212: iload_1
    //   213: invokevirtual 145	java/io/ByteArrayOutputStream:write	([BII)V
    //   216: goto -106 -> 110
    //   219: astore 6
    //   221: aload 4
    //   223: astore 7
    //   225: aload_3
    //   226: astore 5
    //   228: aload_2
    //   229: astore_3
    //   230: aload 7
    //   232: astore 4
    //   234: aload 6
    //   236: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   239: aload 7
    //   241: ifnull +8 -> 249
    //   244: aload 7
    //   246: invokevirtual 140	java/io/ByteArrayOutputStream:close	()V
    //   249: aload 5
    //   251: astore_3
    //   252: aload_2
    //   253: ifnull +10 -> 263
    //   256: aload_2
    //   257: invokevirtual 141	java/io/FileInputStream:close	()V
    //   260: aload 5
    //   262: astore_3
    //   263: aload_3
    //   264: areturn
    //   265: astore_3
    //   266: aload_3
    //   267: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   270: goto -77 -> 193
    //   273: astore_2
    //   274: aload_2
    //   275: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   278: goto -77 -> 201
    //   281: astore_3
    //   282: aload_3
    //   283: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   286: goto -37 -> 249
    //   289: astore_2
    //   290: aload_2
    //   291: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   294: aload 5
    //   296: astore_3
    //   297: goto -34 -> 263
    //   300: astore_2
    //   301: aload 4
    //   303: ifnull +8 -> 311
    //   306: aload 4
    //   308: invokevirtual 140	java/io/ByteArrayOutputStream:close	()V
    //   311: aload_3
    //   312: ifnull +7 -> 319
    //   315: aload_3
    //   316: invokevirtual 141	java/io/FileInputStream:close	()V
    //   319: aload_2
    //   320: athrow
    //   321: astore 4
    //   323: aload 4
    //   325: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   328: goto -17 -> 311
    //   331: astore_3
    //   332: aload_3
    //   333: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   336: goto -17 -> 319
    //   339: iconst_0
    //   340: ifeq +11 -> 351
    //   343: new 151	java/lang/NullPointerException
    //   346: dup
    //   347: invokespecial 152	java/lang/NullPointerException:<init>	()V
    //   350: athrow
    //   351: aload_2
    //   352: astore_3
    //   353: iconst_0
    //   354: ifeq -91 -> 263
    //   357: new 151	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 152	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: astore_3
    //   366: aload_3
    //   367: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   370: aload_2
    //   371: astore_3
    //   372: goto -109 -> 263
    //   375: astore_3
    //   376: aload_3
    //   377: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   380: goto -29 -> 351
    //   383: astore 5
    //   385: aload_2
    //   386: astore_3
    //   387: aload 8
    //   389: astore 4
    //   391: aload 5
    //   393: astore_2
    //   394: goto -93 -> 301
    //   397: astore 5
    //   399: aload_2
    //   400: astore_3
    //   401: aload 5
    //   403: astore_2
    //   404: goto -103 -> 301
    //   407: astore_2
    //   408: aload 6
    //   410: astore 5
    //   412: aload_2
    //   413: astore 6
    //   415: aload 9
    //   417: astore_2
    //   418: goto -190 -> 228
    //   421: astore_3
    //   422: aload 6
    //   424: astore 5
    //   426: aload_3
    //   427: astore 6
    //   429: goto -201 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	OEMChannel
    //   119	94	1	i	int
    //   8	249	2	localFileInputStream	java.io.FileInputStream
    //   273	2	2	localIOException1	java.io.IOException
    //   289	2	2	localIOException2	java.io.IOException
    //   300	86	2	localObject1	Object
    //   393	11	2	localObject2	Object
    //   407	6	2	localException1	Exception
    //   417	1	2	localObject3	Object
    //   29	235	3	localObject4	Object
    //   265	2	3	localIOException3	java.io.IOException
    //   281	2	3	localIOException4	java.io.IOException
    //   296	20	3	localObject5	Object
    //   331	2	3	localIOException5	java.io.IOException
    //   352	1	3	localObject6	Object
    //   365	2	3	localIOException6	java.io.IOException
    //   371	1	3	localObject7	Object
    //   375	2	3	localIOException7	java.io.IOException
    //   386	15	3	localObject8	Object
    //   421	6	3	localException2	Exception
    //   32	275	4	localObject9	Object
    //   321	3	4	localIOException8	java.io.IOException
    //   389	1	4	localObject10	Object
    //   10	285	5	localObject11	Object
    //   383	9	5	localObject12	Object
    //   397	5	5	localObject13	Object
    //   410	15	5	localObject14	Object
    //   5	205	6	localObject15	Object
    //   219	190	6	localException3	Exception
    //   413	15	6	localObject16	Object
    //   25	220	7	localObject17	Object
    //   22	366	8	localObject18	Object
    //   16	400	9	localObject19	Object
    //   13	53	10	localObject20	Object
    //   19	50	11	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   103	110	219	java/lang/Exception
    //   113	120	219	java/lang/Exception
    //   128	138	219	java/lang/Exception
    //   141	150	219	java/lang/Exception
    //   153	157	219	java/lang/Exception
    //   160	176	219	java/lang/Exception
    //   179	183	219	java/lang/Exception
    //   207	216	219	java/lang/Exception
    //   188	193	265	java/io/IOException
    //   197	201	273	java/io/IOException
    //   244	249	281	java/io/IOException
    //   256	260	289	java/io/IOException
    //   34	41	300	finally
    //   48	65	300	finally
    //   72	91	300	finally
    //   234	239	300	finally
    //   306	311	321	java/io/IOException
    //   315	319	331	java/io/IOException
    //   357	365	365	java/io/IOException
    //   343	351	375	java/io/IOException
    //   91	100	383	finally
    //   103	110	397	finally
    //   113	120	397	finally
    //   128	138	397	finally
    //   141	150	397	finally
    //   153	157	397	finally
    //   160	176	397	finally
    //   179	183	397	finally
    //   207	216	397	finally
    //   34	41	407	java/lang/Exception
    //   48	65	407	java/lang/Exception
    //   72	91	407	java/lang/Exception
    //   91	100	421	java/lang/Exception
  }
  
  public boolean hasChannel()
  {
    return this.hasChannelFile;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mpcr/model/OEMChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */