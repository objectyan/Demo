package com.baidu.android.pushservice.j;

import java.io.IOException;
import java.util.Properties;

public class a
{
  private final Properties a;
  
  /* Error */
  private a()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 14	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 16	java/util/Properties
    //   8: dup
    //   9: invokespecial 17	java/util/Properties:<init>	()V
    //   12: putfield 19	com/baidu/android/pushservice/j/a:a	Ljava/util/Properties;
    //   15: aconst_null
    //   16: astore_2
    //   17: new 21	java/io/FileInputStream
    //   20: dup
    //   21: new 23	java/io/File
    //   24: dup
    //   25: invokestatic 29	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   28: ldc 31
    //   30: invokespecial 34	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: invokespecial 37	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 19	com/baidu/android/pushservice/j/a:a	Ljava/util/Properties;
    //   41: aload_1
    //   42: invokevirtual 41	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   45: aload_1
    //   46: ifnull +7 -> 53
    //   49: aload_1
    //   50: invokevirtual 44	java/io/FileInputStream:close	()V
    //   53: return
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull -5 -> 53
    //   61: aload_1
    //   62: invokevirtual 44	java/io/FileInputStream:close	()V
    //   65: return
    //   66: astore_1
    //   67: return
    //   68: astore_1
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 44	java/io/FileInputStream:close	()V
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: return
    //   81: astore_2
    //   82: goto -5 -> 77
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: aload_3
    //   89: astore_1
    //   90: goto -21 -> 69
    //   93: astore_2
    //   94: goto -37 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   36	14	1	localFileInputStream	java.io.FileInputStream
    //   54	1	1	localException1	Exception
    //   56	6	1	localObject1	Object
    //   66	1	1	localException2	Exception
    //   68	10	1	localObject2	Object
    //   79	8	1	localException3	Exception
    //   89	1	1	localObject3	Object
    //   16	58	2	localObject4	Object
    //   81	1	2	localException4	Exception
    //   87	1	2	localObject5	Object
    //   93	1	2	localException5	Exception
    //   85	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   17	37	54	java/lang/Exception
    //   61	65	66	java/lang/Exception
    //   17	37	68	finally
    //   49	53	79	java/lang/Exception
    //   73	77	81	java/lang/Exception
    //   37	45	85	finally
    //   37	45	93	java/lang/Exception
  }
  
  public static a a()
    throws IOException
  {
    return new a();
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.a.getProperty(paramString1, paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */