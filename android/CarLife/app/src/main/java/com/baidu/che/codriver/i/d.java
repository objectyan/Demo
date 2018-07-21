package com.baidu.che.codriver.i;

import android.text.TextUtils;
import java.io.File;

public class d
{
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 8
    //   18: aload 10
    //   20: astore 5
    //   22: aload_0
    //   23: invokevirtual 21	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   26: invokevirtual 27	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   29: aload_1
    //   30: invokevirtual 33	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore_0
    //   34: aload_0
    //   35: astore 6
    //   37: aload 10
    //   39: astore 5
    //   41: aload_0
    //   42: astore 4
    //   44: aload_0
    //   45: astore 7
    //   47: new 35	java/io/FileOutputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 38	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   55: astore_1
    //   56: sipush 10240
    //   59: newarray <illegal type>
    //   61: astore_2
    //   62: aload_0
    //   63: aload_2
    //   64: iconst_0
    //   65: sipush 10240
    //   68: invokevirtual 44	java/io/InputStream:read	([BII)I
    //   71: istore_3
    //   72: iload_3
    //   73: iflt +41 -> 114
    //   76: aload_1
    //   77: aload_2
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 48	java/io/FileOutputStream:write	([BII)V
    //   83: goto -21 -> 62
    //   86: astore_2
    //   87: aload_1
    //   88: astore 5
    //   90: aload_0
    //   91: astore 4
    //   93: aload_2
    //   94: invokevirtual 51	java/io/FileNotFoundException:printStackTrace	()V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 54	java/io/FileOutputStream:close	()V
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 55	java/io/InputStream:close	()V
    //   113: return
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 54	java/io/FileOutputStream:close	()V
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 55	java/io/InputStream:close	()V
    //   130: return
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   136: goto -14 -> 122
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   144: return
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   150: goto -45 -> 105
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   158: return
    //   159: astore_2
    //   160: aload 6
    //   162: astore_0
    //   163: aload 9
    //   165: astore_1
    //   166: aload_1
    //   167: astore 5
    //   169: aload_0
    //   170: astore 4
    //   172: aload_2
    //   173: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 54	java/io/FileOutputStream:close	()V
    //   184: aload_0
    //   185: ifnull -72 -> 113
    //   188: aload_0
    //   189: invokevirtual 55	java/io/InputStream:close	()V
    //   192: return
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   198: return
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   204: goto -20 -> 184
    //   207: astore_0
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 54	java/io/FileOutputStream:close	()V
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 55	java/io/InputStream:close	()V
    //   228: aload_0
    //   229: athrow
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   235: goto -17 -> 218
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   243: goto -15 -> 228
    //   246: astore_2
    //   247: aload_1
    //   248: astore 5
    //   250: aload_0
    //   251: astore 4
    //   253: aload_2
    //   254: astore_0
    //   255: goto -47 -> 208
    //   258: astore_2
    //   259: goto -93 -> 166
    //   262: astore_2
    //   263: aload 8
    //   265: astore_1
    //   266: aload 7
    //   268: astore_0
    //   269: goto -182 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramContext	android.content.Context
    //   0	272	1	paramString1	String
    //   0	272	2	paramString2	String
    //   71	9	3	i	int
    //   1	251	4	localContext1	android.content.Context
    //   20	229	5	localObject1	Object
    //   7	154	6	localContext2	android.content.Context
    //   4	263	7	localContext3	android.content.Context
    //   16	248	8	localObject2	Object
    //   10	154	9	localObject3	Object
    //   13	25	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   56	62	86	java/io/FileNotFoundException
    //   62	72	86	java/io/FileNotFoundException
    //   76	83	86	java/io/FileNotFoundException
    //   118	122	131	java/io/IOException
    //   126	130	139	java/io/IOException
    //   101	105	145	java/io/IOException
    //   109	113	153	java/io/IOException
    //   22	34	159	java/io/IOException
    //   47	56	159	java/io/IOException
    //   188	192	193	java/io/IOException
    //   180	184	199	java/io/IOException
    //   22	34	207	finally
    //   47	56	207	finally
    //   93	97	207	finally
    //   172	176	207	finally
    //   213	218	230	java/io/IOException
    //   223	228	238	java/io/IOException
    //   56	62	246	finally
    //   62	72	246	finally
    //   76	83	246	finally
    //   56	62	258	java/io/IOException
    //   62	72	258	java/io/IOException
    //   76	83	258	java/io/IOException
    //   22	34	262	java/io/FileNotFoundException
    //   47	56	262	java/io/FileNotFoundException
  }
  
  private static void a(File paramFile)
    throws Exception
  {
    paramFile = paramFile.listFiles();
    int i = 0;
    if (i < paramFile.length)
    {
      if (paramFile[i].isDirectory()) {
        a(paramFile[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        paramFile[i].delete();
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while (!paramString.exists());
    paramString.delete();
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return false;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {}
    for (;;)
    {
      try
      {
        a(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        return false;
      }
      paramString.mkdirs();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */