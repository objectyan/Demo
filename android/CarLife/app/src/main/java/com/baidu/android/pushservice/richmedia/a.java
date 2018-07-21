package com.baidu.android.pushservice.richmedia;

import android.content.Context;
import com.baidu.android.pushservice.d.a.g;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;

public class a
  extends Thread
  implements Comparable<a>
{
  public static int e = 1;
  public static int f = 2;
  private static HashSet<c> g = new HashSet();
  protected f a;
  public WeakReference<Context> b;
  protected long c;
  public c d;
  private boolean h = false;
  
  public a(Context paramContext, f paramf, c paramc)
  {
    this.a = paramf;
    this.b = new WeakReference(paramContext);
    this.c = System.currentTimeMillis();
    this.d = paramc;
  }
  
  private int a(String paramString)
  {
    try
    {
      int i = ((HttpURLConnection)new URL(paramString).openConnection()).getContentLength();
      return i;
    }
    catch (IOException paramString)
    {
      return 0;
    }
    catch (MalformedURLException paramString)
    {
      for (;;) {}
    }
  }
  
  private a.g a(Context paramContext, String paramString)
  {
    paramContext = com.baidu.android.pushservice.d.a.b(paramContext);
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.size())
      {
        if (((a.g)paramContext.get(i)).b.equalsIgnoreCase(paramString)) {
          return (a.g)paramContext.get(i);
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(e parame)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.a;
        if ((localObject1 == null) || (parame == null)) {
          return;
        }
        if (parame.c == 0)
        {
          Object localObject2 = parame.e;
          if ((parame.a == c.a.a) && (localObject2 != null))
          {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("."));
            localObject2 = new File((String)localObject2);
            a((File)localObject2, (String)localObject1);
            ((File)localObject2).delete();
            parame.e = ((String)localObject1);
          }
          this.a.a(this, parame);
          return;
        }
        if (parame.c == 1)
        {
          this.a.a(this, new Throwable("error: response http error errorCode=" + parame.b));
          continue;
        }
        if (parame.c != 3) {
          break label195;
        }
      }
      finally
      {
        b(this.d);
      }
      this.a.a(this, new Throwable("error: request error,request is null or fileName is null."));
      continue;
      label195:
      if (parame.c == 2) {
        this.a.b(this);
      } else if (parame.c == -1) {
        this.a.a(this, new Throwable("IOException"));
      }
    }
  }
  
  /* Error */
  private static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore_3
    //   14: new 182	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 4
    //   24: new 187	java/io/BufferedInputStream
    //   27: dup
    //   28: aload 4
    //   30: invokespecial 190	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore 6
    //   35: new 192	java/util/zip/ZipInputStream
    //   38: dup
    //   39: aload 6
    //   41: invokespecial 193	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore 7
    //   46: aconst_null
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_3
    //   50: aload 7
    //   52: invokevirtual 197	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   55: astore 9
    //   57: aload 9
    //   59: ifnull +190 -> 249
    //   62: sipush 4096
    //   65: newarray <illegal type>
    //   67: astore 8
    //   69: aload 9
    //   71: invokevirtual 202	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   74: astore 10
    //   76: aconst_null
    //   77: astore 5
    //   79: aload 10
    //   81: invokevirtual 205	java/lang/String:length	()I
    //   84: ifle +12 -> 96
    //   87: aload 10
    //   89: ldc -49
    //   91: invokevirtual 211	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   94: astore 5
    //   96: new 134	java/io/File
    //   99: dup
    //   100: new 151	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc -49
    //   113: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 5
    //   118: aload 5
    //   120: arraylength
    //   121: iconst_1
    //   122: isub
    //   123: aaload
    //   124: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 5
    //   135: aload 9
    //   137: invokevirtual 214	java/util/zip/ZipEntry:isDirectory	()Z
    //   140: ifne -90 -> 50
    //   143: new 134	java/io/File
    //   146: dup
    //   147: aload 5
    //   149: invokevirtual 217	java/io/File:getParent	()Ljava/lang/String;
    //   152: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore 9
    //   157: aload 9
    //   159: invokevirtual 220	java/io/File:exists	()Z
    //   162: ifne +9 -> 171
    //   165: aload 9
    //   167: invokevirtual 223	java/io/File:mkdirs	()Z
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 220	java/io/File:exists	()Z
    //   176: ifne +9 -> 185
    //   179: aload 5
    //   181: invokevirtual 226	java/io/File:createNewFile	()Z
    //   184: pop
    //   185: new 228	java/io/FileOutputStream
    //   188: dup
    //   189: aload 5
    //   191: invokespecial 229	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: astore 5
    //   196: new 231	java/io/BufferedOutputStream
    //   199: dup
    //   200: aload 5
    //   202: sipush 4096
    //   205: invokespecial 234	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   208: astore_3
    //   209: aload 7
    //   211: aload 8
    //   213: iconst_0
    //   214: sipush 4096
    //   217: invokevirtual 238	java/util/zip/ZipInputStream:read	([BII)I
    //   220: istore_2
    //   221: iload_2
    //   222: iconst_m1
    //   223: if_icmpeq +14 -> 237
    //   226: aload_3
    //   227: aload 8
    //   229: iconst_0
    //   230: iload_2
    //   231: invokevirtual 242	java/io/BufferedOutputStream:write	([BII)V
    //   234: goto -25 -> 209
    //   237: aload_3
    //   238: invokevirtual 245	java/io/BufferedOutputStream:flush	()V
    //   241: aload_3
    //   242: astore_0
    //   243: aload 5
    //   245: astore_3
    //   246: goto -196 -> 50
    //   249: iconst_5
    //   250: anewarray 247	java/io/Closeable
    //   253: dup
    //   254: iconst_0
    //   255: aload 4
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload 7
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: aload_3
    //   266: aastore
    //   267: dup
    //   268: iconst_3
    //   269: aload_0
    //   270: aastore
    //   271: dup
    //   272: iconst_4
    //   273: aload 6
    //   275: aastore
    //   276: invokestatic 252	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   279: return
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_0
    //   285: aload 9
    //   287: astore 5
    //   289: aload 10
    //   291: astore 4
    //   293: iconst_5
    //   294: anewarray 247	java/io/Closeable
    //   297: dup
    //   298: iconst_0
    //   299: aload_1
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aload_0
    //   304: aastore
    //   305: dup
    //   306: iconst_2
    //   307: aload 5
    //   309: aastore
    //   310: dup
    //   311: iconst_3
    //   312: aload 4
    //   314: aastore
    //   315: dup
    //   316: iconst_4
    //   317: aload_3
    //   318: aastore
    //   319: invokestatic 252	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   322: return
    //   323: astore_0
    //   324: aconst_null
    //   325: astore 4
    //   327: aconst_null
    //   328: astore 6
    //   330: aconst_null
    //   331: astore_3
    //   332: aload 8
    //   334: astore_1
    //   335: iconst_5
    //   336: anewarray 247	java/io/Closeable
    //   339: dup
    //   340: iconst_0
    //   341: aload 4
    //   343: aastore
    //   344: dup
    //   345: iconst_1
    //   346: aload_3
    //   347: aastore
    //   348: dup
    //   349: iconst_2
    //   350: aload 5
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: aload_1
    //   356: aastore
    //   357: dup
    //   358: iconst_4
    //   359: aload 6
    //   361: aastore
    //   362: invokestatic 252	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   365: aload_0
    //   366: athrow
    //   367: astore_0
    //   368: aconst_null
    //   369: astore_3
    //   370: aconst_null
    //   371: astore 6
    //   373: aload 8
    //   375: astore_1
    //   376: goto -41 -> 335
    //   379: astore_0
    //   380: aconst_null
    //   381: astore_3
    //   382: aload 8
    //   384: astore_1
    //   385: goto -50 -> 335
    //   388: astore_0
    //   389: aload_3
    //   390: astore_1
    //   391: aload 7
    //   393: astore_3
    //   394: goto -59 -> 335
    //   397: astore 5
    //   399: aload_0
    //   400: astore_1
    //   401: aload 5
    //   403: astore_0
    //   404: aload_3
    //   405: astore 5
    //   407: aload 7
    //   409: astore_3
    //   410: goto -75 -> 335
    //   413: astore_3
    //   414: aload_0
    //   415: astore_1
    //   416: aload_3
    //   417: astore_0
    //   418: aload 7
    //   420: astore_3
    //   421: goto -86 -> 335
    //   424: astore_0
    //   425: aconst_null
    //   426: astore_0
    //   427: aload 4
    //   429: astore_1
    //   430: aload 10
    //   432: astore 4
    //   434: aload 9
    //   436: astore 5
    //   438: goto -145 -> 293
    //   441: astore_0
    //   442: aload 6
    //   444: astore_3
    //   445: aload 4
    //   447: astore_1
    //   448: aconst_null
    //   449: astore_0
    //   450: aload 10
    //   452: astore 4
    //   454: aload 9
    //   456: astore 5
    //   458: goto -165 -> 293
    //   461: astore_1
    //   462: aload_3
    //   463: astore 5
    //   465: aload 6
    //   467: astore_3
    //   468: aload 4
    //   470: astore_1
    //   471: aload_0
    //   472: astore 4
    //   474: aload 7
    //   476: astore_0
    //   477: goto -184 -> 293
    //   480: astore 5
    //   482: goto -432 -> 50
    //   485: astore_3
    //   486: aload 5
    //   488: astore_3
    //   489: goto -439 -> 50
    //   492: astore_0
    //   493: aload_3
    //   494: astore_0
    //   495: aload 5
    //   497: astore_3
    //   498: goto -448 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramFile	File
    //   0	501	1	paramString	String
    //   220	11	2	i	int
    //   13	397	3	localObject1	Object
    //   413	4	3	localObject2	Object
    //   420	48	3	localObject3	Object
    //   485	1	3	localException1	Exception
    //   488	10	3	localException2	Exception
    //   22	451	4	localObject4	Object
    //   1	350	5	localObject5	Object
    //   397	5	5	localObject6	Object
    //   405	59	5	localObject7	Object
    //   480	16	5	localException3	Exception
    //   33	433	6	localBufferedInputStream	java.io.BufferedInputStream
    //   44	431	7	localZipInputStream	java.util.zip.ZipInputStream
    //   7	376	8	arrayOfByte	byte[]
    //   4	451	9	localObject8	Object
    //   10	441	10	str	String
    // Exception table:
    //   from	to	target	type
    //   14	24	280	java/lang/Exception
    //   14	24	323	finally
    //   24	35	367	finally
    //   35	46	379	finally
    //   209	221	388	finally
    //   226	234	388	finally
    //   237	241	388	finally
    //   50	57	397	finally
    //   62	76	397	finally
    //   79	96	397	finally
    //   96	171	397	finally
    //   171	185	397	finally
    //   185	196	397	finally
    //   196	209	413	finally
    //   24	35	424	java/lang/Exception
    //   35	46	441	java/lang/Exception
    //   50	57	461	java/lang/Exception
    //   62	76	480	java/lang/Exception
    //   79	96	480	java/lang/Exception
    //   96	171	480	java/lang/Exception
    //   171	185	480	java/lang/Exception
    //   185	196	480	java/lang/Exception
    //   196	209	485	java/lang/Exception
    //   209	221	492	java/lang/Exception
    //   226	234	492	java/lang/Exception
    //   237	241	492	java/lang/Exception
  }
  
  private static boolean a(c paramc)
  {
    try
    {
      boolean bool = g.add(paramc);
      return bool;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  /* Error */
  private e b()
  {
    // Byte code:
    //   0: new 113	com/baidu/android/pushservice/richmedia/e
    //   3: dup
    //   4: invokespecial 258	com/baidu/android/pushservice/richmedia/e:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_0
    //   12: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   15: putfield 259	com/baidu/android/pushservice/richmedia/e:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   18: aload_0
    //   19: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   22: ifnull +614 -> 636
    //   25: aload 6
    //   27: aload_0
    //   28: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   31: invokevirtual 264	com/baidu/android/pushservice/richmedia/c:a	()Lcom/baidu/android/pushservice/richmedia/c$a;
    //   34: putfield 120	com/baidu/android/pushservice/richmedia/e:a	Lcom/baidu/android/pushservice/richmedia/c$a;
    //   37: aload_0
    //   38: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   41: getfield 265	com/baidu/android/pushservice/richmedia/c:b	Ljava/lang/String;
    //   44: ifnull +779 -> 823
    //   47: aload_0
    //   48: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   51: invokestatic 267	com/baidu/android/pushservice/richmedia/a:a	(Lcom/baidu/android/pushservice/richmedia/c;)Z
    //   54: ifne +15 -> 69
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 44	com/baidu/android/pushservice/richmedia/a:a	Lcom/baidu/android/pushservice/richmedia/f;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   67: aconst_null
    //   68: areturn
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 51	com/baidu/android/pushservice/richmedia/a:b	Ljava/lang/ref/WeakReference;
    //   74: invokevirtual 270	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   77: checkcast 272	android/content/Context
    //   80: aload_0
    //   81: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   84: invokevirtual 274	com/baidu/android/pushservice/richmedia/c:c	()Ljava/lang/String;
    //   87: invokespecial 276	com/baidu/android/pushservice/richmedia/a:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/baidu/android/pushservice/d/a$g;
    //   90: astore 5
    //   92: aload 5
    //   94: ifnonnull +206 -> 300
    //   97: new 98	com/baidu/android/pushservice/d/a$g
    //   100: dup
    //   101: invokespecial 277	com/baidu/android/pushservice/d/a$g:<init>	()V
    //   104: astore 5
    //   106: aload 5
    //   108: aload_0
    //   109: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   112: invokevirtual 274	com/baidu/android/pushservice/richmedia/c:c	()Ljava/lang/String;
    //   115: putfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   118: aload 5
    //   120: aload_0
    //   121: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   124: getfield 279	com/baidu/android/pushservice/richmedia/c:a	Ljava/lang/String;
    //   127: putfield 280	com/baidu/android/pushservice/d/a$g:a	Ljava/lang/String;
    //   130: aload 5
    //   132: aload_0
    //   133: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   136: getfield 282	com/baidu/android/pushservice/richmedia/c:c	Ljava/lang/String;
    //   139: putfield 283	com/baidu/android/pushservice/d/a$g:c	Ljava/lang/String;
    //   142: aload 5
    //   144: aload_0
    //   145: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   148: getfield 285	com/baidu/android/pushservice/richmedia/c:d	Ljava/lang/String;
    //   151: putfield 286	com/baidu/android/pushservice/d/a$g:d	Ljava/lang/String;
    //   154: aload 5
    //   156: iconst_0
    //   157: putfield 288	com/baidu/android/pushservice/d/a$g:g	I
    //   160: aload 5
    //   162: aload_0
    //   163: aload 5
    //   165: getfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   168: invokespecial 290	com/baidu/android/pushservice/richmedia/a:a	(Ljava/lang/String;)I
    //   171: putfield 292	com/baidu/android/pushservice/d/a$g:h	I
    //   174: aload 5
    //   176: getstatic 35	com/baidu/android/pushservice/richmedia/a:e	I
    //   179: putfield 295	com/baidu/android/pushservice/d/a$g:i	I
    //   182: aload 5
    //   184: aload 5
    //   186: getfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   189: aload 5
    //   191: getfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   194: bipush 47
    //   196: invokevirtual 298	java/lang/String:lastIndexOf	(I)I
    //   199: iconst_1
    //   200: iadd
    //   201: invokevirtual 301	java/lang/String:substring	(I)Ljava/lang/String;
    //   204: putfield 303	com/baidu/android/pushservice/d/a$g:f	Ljava/lang/String;
    //   207: aload 5
    //   209: aload_0
    //   210: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   213: getfield 265	com/baidu/android/pushservice/richmedia/c:b	Ljava/lang/String;
    //   216: putfield 304	com/baidu/android/pushservice/d/a$g:e	Ljava/lang/String;
    //   219: aload_0
    //   220: getfield 51	com/baidu/android/pushservice/richmedia/a:b	Ljava/lang/ref/WeakReference;
    //   223: invokevirtual 270	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   226: checkcast 272	android/content/Context
    //   229: aload 5
    //   231: invokestatic 307	com/baidu/android/pushservice/d/a:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/a$g;)J
    //   234: pop2
    //   235: aload 5
    //   237: getfield 295	com/baidu/android/pushservice/d/a$g:i	I
    //   240: getstatic 37	com/baidu/android/pushservice/richmedia/a:f	I
    //   243: if_icmpne +74 -> 317
    //   246: aload 6
    //   248: iconst_0
    //   249: putfield 115	com/baidu/android/pushservice/richmedia/e:c	I
    //   252: aload 6
    //   254: aload_0
    //   255: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   258: putfield 259	com/baidu/android/pushservice/richmedia/e:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   261: aload 6
    //   263: new 151	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   270: aload 5
    //   272: getfield 304	com/baidu/android/pushservice/d/a$g:e	Ljava/lang/String;
    //   275: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc -49
    //   280: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 5
    //   285: getfield 303	com/baidu/android/pushservice/d/a$g:f	Ljava/lang/String;
    //   288: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: putfield 117	com/baidu/android/pushservice/richmedia/e:e	Ljava/lang/String;
    //   297: aload 6
    //   299: areturn
    //   300: aload 5
    //   302: aload_0
    //   303: aload 5
    //   305: getfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   308: invokespecial 290	com/baidu/android/pushservice/richmedia/a:a	(Ljava/lang/String;)I
    //   311: putfield 292	com/baidu/android/pushservice/d/a$g:h	I
    //   314: goto -79 -> 235
    //   317: aload_0
    //   318: getfield 44	com/baidu/android/pushservice/richmedia/a:a	Lcom/baidu/android/pushservice/richmedia/f;
    //   321: ifnull +13 -> 334
    //   324: aload_0
    //   325: getfield 44	com/baidu/android/pushservice/richmedia/a:a	Lcom/baidu/android/pushservice/richmedia/f;
    //   328: aload_0
    //   329: invokeinterface 309 2 0
    //   334: aload_0
    //   335: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   338: invokevirtual 274	com/baidu/android/pushservice/richmedia/c:c	()Ljava/lang/String;
    //   341: aload_0
    //   342: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   345: invokevirtual 311	com/baidu/android/pushservice/richmedia/c:b	()Ljava/lang/String;
    //   348: aload_0
    //   349: getfield 61	com/baidu/android/pushservice/richmedia/a:d	Lcom/baidu/android/pushservice/richmedia/c;
    //   352: getfield 314	com/baidu/android/pushservice/richmedia/c:f	Ljava/util/HashMap;
    //   355: invokestatic 317	com/baidu/android/pushservice/f/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)Lcom/baidu/android/pushservice/f/a;
    //   358: astore 7
    //   360: aload 7
    //   362: invokevirtual 321	com/baidu/android/pushservice/f/a:b	()I
    //   365: sipush 200
    //   368: if_icmpne +436 -> 804
    //   371: aload 7
    //   373: invokevirtual 324	com/baidu/android/pushservice/f/a:a	()Ljava/io/InputStream;
    //   376: astore 7
    //   378: new 134	java/io/File
    //   381: dup
    //   382: aload 5
    //   384: getfield 304	com/baidu/android/pushservice/d/a$g:e	Ljava/lang/String;
    //   387: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   390: astore 8
    //   392: aload 8
    //   394: invokevirtual 220	java/io/File:exists	()Z
    //   397: ifne +9 -> 406
    //   400: aload 8
    //   402: invokevirtual 223	java/io/File:mkdirs	()Z
    //   405: pop
    //   406: new 134	java/io/File
    //   409: dup
    //   410: new 151	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   417: aload 5
    //   419: getfield 304	com/baidu/android/pushservice/d/a$g:e	Ljava/lang/String;
    //   422: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc -49
    //   427: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 5
    //   432: getfield 303	com/baidu/android/pushservice/d/a$g:f	Ljava/lang/String;
    //   435: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   444: astore 9
    //   446: aload 9
    //   448: invokevirtual 220	java/io/File:exists	()Z
    //   451: ifne +9 -> 460
    //   454: aload 9
    //   456: invokevirtual 226	java/io/File:createNewFile	()Z
    //   459: pop
    //   460: new 326	java/io/RandomAccessFile
    //   463: dup
    //   464: aload 9
    //   466: ldc_w 328
    //   469: invokespecial 330	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   472: astore 8
    //   474: aload 8
    //   476: aload 5
    //   478: getfield 288	com/baidu/android/pushservice/d/a$g:g	I
    //   481: i2l
    //   482: invokevirtual 334	java/io/RandomAccessFile:seek	(J)V
    //   485: ldc_w 335
    //   488: newarray <illegal type>
    //   490: astore 10
    //   492: aload 5
    //   494: getfield 288	com/baidu/android/pushservice/d/a$g:g	I
    //   497: istore_1
    //   498: new 337	com/baidu/android/pushservice/richmedia/b
    //   501: dup
    //   502: invokespecial 338	com/baidu/android/pushservice/richmedia/b:<init>	()V
    //   505: astore 11
    //   507: aload 11
    //   509: aload 5
    //   511: getfield 292	com/baidu/android/pushservice/d/a$g:h	I
    //   514: i2l
    //   515: putfield 340	com/baidu/android/pushservice/richmedia/b:b	J
    //   518: aload 11
    //   520: iload_1
    //   521: i2l
    //   522: putfield 342	com/baidu/android/pushservice/richmedia/b:a	J
    //   525: aload_0
    //   526: aload 11
    //   528: invokevirtual 345	com/baidu/android/pushservice/richmedia/a:a	(Lcom/baidu/android/pushservice/richmedia/b;)V
    //   531: iload_1
    //   532: istore_3
    //   533: iload_1
    //   534: istore_2
    //   535: aload_0
    //   536: getfield 42	com/baidu/android/pushservice/richmedia/a:h	Z
    //   539: ifne +20 -> 559
    //   542: iload_1
    //   543: istore_2
    //   544: aload 7
    //   546: aload 10
    //   548: invokevirtual 350	java/io/InputStream:read	([B)I
    //   551: istore_3
    //   552: iload_3
    //   553: iconst_m1
    //   554: if_icmpne +85 -> 639
    //   557: iload_1
    //   558: istore_3
    //   559: iconst_2
    //   560: anewarray 247	java/io/Closeable
    //   563: dup
    //   564: iconst_0
    //   565: aload 7
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: aload 8
    //   572: aastore
    //   573: invokestatic 252	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   576: iload_3
    //   577: istore_2
    //   578: aload_0
    //   579: getfield 42	com/baidu/android/pushservice/richmedia/a:h	Z
    //   582: ifne +188 -> 770
    //   585: aload 5
    //   587: iload_2
    //   588: putfield 288	com/baidu/android/pushservice/d/a$g:g	I
    //   591: aload 5
    //   593: getstatic 37	com/baidu/android/pushservice/richmedia/a:f	I
    //   596: putfield 295	com/baidu/android/pushservice/d/a$g:i	I
    //   599: aload_0
    //   600: getfield 51	com/baidu/android/pushservice/richmedia/a:b	Ljava/lang/ref/WeakReference;
    //   603: invokevirtual 270	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   606: checkcast 272	android/content/Context
    //   609: aload 5
    //   611: getfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   614: aload 5
    //   616: invokestatic 353	com/baidu/android/pushservice/d/a:a	(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/android/pushservice/d/a$g;)I
    //   619: pop
    //   620: aload 6
    //   622: iconst_0
    //   623: putfield 115	com/baidu/android/pushservice/richmedia/e:c	I
    //   626: aload 6
    //   628: aload 9
    //   630: invokevirtual 356	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   633: putfield 117	com/baidu/android/pushservice/richmedia/e:e	Ljava/lang/String;
    //   636: aload 6
    //   638: areturn
    //   639: iload_1
    //   640: istore_2
    //   641: aload 8
    //   643: aload 10
    //   645: iconst_0
    //   646: iload_3
    //   647: invokevirtual 357	java/io/RandomAccessFile:write	([BII)V
    //   650: iload_1
    //   651: iload_3
    //   652: iadd
    //   653: istore_3
    //   654: iload_3
    //   655: istore_2
    //   656: new 337	com/baidu/android/pushservice/richmedia/b
    //   659: dup
    //   660: invokespecial 338	com/baidu/android/pushservice/richmedia/b:<init>	()V
    //   663: astore 11
    //   665: iload_3
    //   666: istore_2
    //   667: aload 11
    //   669: aload 5
    //   671: getfield 292	com/baidu/android/pushservice/d/a$g:h	I
    //   674: i2l
    //   675: putfield 340	com/baidu/android/pushservice/richmedia/b:b	J
    //   678: iload_3
    //   679: istore_2
    //   680: aload 11
    //   682: iload_3
    //   683: i2l
    //   684: putfield 342	com/baidu/android/pushservice/richmedia/b:a	J
    //   687: iload_3
    //   688: istore_2
    //   689: aload_0
    //   690: aload 11
    //   692: invokevirtual 345	com/baidu/android/pushservice/richmedia/a:a	(Lcom/baidu/android/pushservice/richmedia/b;)V
    //   695: iload_3
    //   696: istore_2
    //   697: aload 5
    //   699: getfield 292	com/baidu/android/pushservice/d/a$g:h	I
    //   702: istore 4
    //   704: iload_3
    //   705: istore_1
    //   706: iload_3
    //   707: iload 4
    //   709: if_icmpne -178 -> 531
    //   712: goto -153 -> 559
    //   715: astore 10
    //   717: iconst_2
    //   718: anewarray 247	java/io/Closeable
    //   721: dup
    //   722: iconst_0
    //   723: aload 7
    //   725: aastore
    //   726: dup
    //   727: iconst_1
    //   728: aload 8
    //   730: aastore
    //   731: invokestatic 252	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   734: goto -156 -> 578
    //   737: astore 5
    //   739: aload 6
    //   741: iconst_m1
    //   742: putfield 115	com/baidu/android/pushservice/richmedia/e:c	I
    //   745: goto -109 -> 636
    //   748: astore 5
    //   750: iconst_2
    //   751: anewarray 247	java/io/Closeable
    //   754: dup
    //   755: iconst_0
    //   756: aload 7
    //   758: aastore
    //   759: dup
    //   760: iconst_1
    //   761: aload 8
    //   763: aastore
    //   764: invokestatic 252	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   767: aload 5
    //   769: athrow
    //   770: aload_0
    //   771: getfield 51	com/baidu/android/pushservice/richmedia/a:b	Ljava/lang/ref/WeakReference;
    //   774: invokevirtual 270	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   777: checkcast 272	android/content/Context
    //   780: aload 5
    //   782: getfield 101	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   785: invokestatic 360	com/baidu/android/pushservice/d/a:b	(Landroid/content/Context;Ljava/lang/String;)I
    //   788: pop
    //   789: aload 6
    //   791: iconst_2
    //   792: putfield 115	com/baidu/android/pushservice/richmedia/e:c	I
    //   795: aload 9
    //   797: invokevirtual 142	java/io/File:delete	()Z
    //   800: pop
    //   801: goto -165 -> 636
    //   804: aload 6
    //   806: iconst_1
    //   807: putfield 115	com/baidu/android/pushservice/richmedia/e:c	I
    //   810: aload 6
    //   812: aload 7
    //   814: invokevirtual 321	com/baidu/android/pushservice/f/a:b	()I
    //   817: putfield 160	com/baidu/android/pushservice/richmedia/e:b	I
    //   820: goto -184 -> 636
    //   823: aload 6
    //   825: iconst_3
    //   826: putfield 115	com/baidu/android/pushservice/richmedia/e:c	I
    //   829: goto -193 -> 636
    //   832: astore 7
    //   834: goto -599 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	a
    //   497	209	1	i	int
    //   534	163	2	j	int
    //   532	178	3	k	int
    //   702	8	4	m	int
    //   90	608	5	localg	a.g
    //   737	1	5	localException1	Exception
    //   748	33	5	localObject1	Object
    //   7	817	6	locale	e
    //   358	455	7	localObject2	Object
    //   832	1	7	localException2	Exception
    //   390	372	8	localObject3	Object
    //   444	352	9	localFile	File
    //   490	154	10	arrayOfByte	byte[]
    //   715	1	10	localIOException	IOException
    //   505	186	11	localb	b
    // Exception table:
    //   from	to	target	type
    //   535	542	715	java/io/IOException
    //   544	552	715	java/io/IOException
    //   641	650	715	java/io/IOException
    //   656	665	715	java/io/IOException
    //   667	678	715	java/io/IOException
    //   680	687	715	java/io/IOException
    //   689	695	715	java/io/IOException
    //   697	704	715	java/io/IOException
    //   334	406	737	java/lang/Exception
    //   406	460	737	java/lang/Exception
    //   460	531	737	java/lang/Exception
    //   559	576	737	java/lang/Exception
    //   578	636	737	java/lang/Exception
    //   717	734	737	java/lang/Exception
    //   750	770	737	java/lang/Exception
    //   770	801	737	java/lang/Exception
    //   804	820	737	java/lang/Exception
    //   535	542	748	finally
    //   544	552	748	finally
    //   641	650	748	finally
    //   656	665	748	finally
    //   667	678	748	finally
    //   680	687	748	finally
    //   689	695	748	finally
    //   697	704	748	finally
    //   219	235	832	java/lang/Exception
  }
  
  private static boolean b(c paramc)
  {
    try
    {
      boolean bool = g.remove(paramc);
      return bool;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public int a(a parama)
  {
    if (parama == null) {}
    long l;
    do
    {
      return -1;
      l = parama.a();
    } while (this.c > l);
    if (this.c < l) {
      return 1;
    }
    return 0;
  }
  
  public long a()
  {
    return this.c;
  }
  
  protected void a(b paramb)
  {
    if (this.a != null) {
      this.a.a(this, paramb);
    }
  }
  
  public void run()
  {
    a(b());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/richmedia/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */