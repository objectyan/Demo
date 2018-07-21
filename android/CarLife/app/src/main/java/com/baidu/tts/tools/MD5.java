package com.baidu.tts.tools;

import java.io.File;
import java.security.MessageDigest;

public class MD5
{
  private static volatile MD5 a = null;
  private char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = this.b[((paramByte & 0xF0) >> 4)];
    char c2 = this.b[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static MD5 getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new MD5();
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  public String getBigFileMd5(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_1
    //   7: ifnull +63 -> 70
    //   10: ldc 65
    //   12: invokestatic 70	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   15: astore_3
    //   16: new 72	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_1
    //   25: sipush 8192
    //   28: newarray <illegal type>
    //   30: astore 5
    //   32: aload_1
    //   33: aload 5
    //   35: invokevirtual 79	java/io/FileInputStream:read	([B)I
    //   38: istore_2
    //   39: iload_2
    //   40: iconst_m1
    //   41: if_icmpeq +31 -> 72
    //   44: aload_3
    //   45: aload 5
    //   47: iconst_0
    //   48: iload_2
    //   49: invokevirtual 83	java/security/MessageDigest:update	([BII)V
    //   52: goto -20 -> 32
    //   55: astore_3
    //   56: aload 4
    //   58: astore_3
    //   59: aload_1
    //   60: ifnull +10 -> 70
    //   63: aload_1
    //   64: invokevirtual 86	java/io/FileInputStream:close	()V
    //   67: aload 4
    //   69: astore_3
    //   70: aload_3
    //   71: areturn
    //   72: aload_0
    //   73: aload_3
    //   74: invokevirtual 90	java/security/MessageDigest:digest	()[B
    //   77: invokespecial 92	com/baidu/tts/tools/MD5:a	([B)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_3
    //   82: astore 4
    //   84: aload 4
    //   86: astore_3
    //   87: aload_1
    //   88: ifnull -18 -> 70
    //   91: aload_1
    //   92: invokevirtual 86	java/io/FileInputStream:close	()V
    //   95: aload 4
    //   97: areturn
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   103: aload 4
    //   105: areturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 86	java/io/FileInputStream:close	()V
    //   124: aload_3
    //   125: athrow
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_3
    //   135: goto -19 -> 116
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -85 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	MD5
    //   0	144	1	paramFile	File
    //   38	11	2	i	int
    //   5	40	3	localObject1	Object
    //   55	1	3	localException	Exception
    //   58	29	3	localObject2	Object
    //   113	12	3	localObject3	Object
    //   134	1	3	localObject4	Object
    //   1	103	4	localObject5	Object
    //   30	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	32	55	java/lang/Exception
    //   32	39	55	java/lang/Exception
    //   44	52	55	java/lang/Exception
    //   72	81	55	java/lang/Exception
    //   91	95	98	java/io/IOException
    //   63	67	106	java/io/IOException
    //   10	25	113	finally
    //   120	124	126	java/io/IOException
    //   25	32	134	finally
    //   32	39	134	finally
    //   44	52	134	finally
    //   72	81	134	finally
    //   10	25	138	java/lang/Exception
  }
  
  public String getBigFileMd5(String paramString)
  {
    return getBigFileMd5(new File(paramString));
  }
  
  /* Error */
  public String getFileMd5(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 65
    //   4: invokestatic 70	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   7: astore 4
    //   9: new 98	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: new 72	java/io/FileInputStream
    //   22: dup
    //   23: aload 5
    //   25: invokespecial 75	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 108	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore_2
    //   34: aload 4
    //   36: aload_2
    //   37: getstatic 114	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   40: lconst_0
    //   41: aload 5
    //   43: invokevirtual 118	java/io/File:length	()J
    //   46: invokevirtual 124	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   49: invokevirtual 127	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   52: aload_0
    //   53: aload 4
    //   55: invokevirtual 90	java/security/MessageDigest:digest	()[B
    //   58: invokespecial 92	com/baidu/tts/tools/MD5:a	([B)Ljava/lang/String;
    //   61: astore_3
    //   62: aload_2
    //   63: ifnull +7 -> 70
    //   66: aload_2
    //   67: invokevirtual 128	java/nio/channels/FileChannel:close	()V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 86	java/io/FileInputStream:close	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   85: goto -7 -> 78
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 128	java/nio/channels/FileChannel:close	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 86	java/io/FileInputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   116: goto -7 -> 109
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 128	java/nio/channels/FileChannel:close	()V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 86	java/io/FileInputStream:close	()V
    //   138: aload_2
    //   139: athrow
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   145: goto -7 -> 138
    //   148: astore_2
    //   149: goto -27 -> 122
    //   152: astore 4
    //   154: aload_2
    //   155: astore_3
    //   156: aload 4
    //   158: astore_2
    //   159: goto -37 -> 122
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_2
    //   165: goto -72 -> 93
    //   168: astore_3
    //   169: goto -76 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	MD5
    //   0	172	1	paramString	String
    //   33	65	2	localFileChannel	java.nio.channels.FileChannel
    //   119	20	2	localObject1	Object
    //   148	7	2	localObject2	Object
    //   158	1	2	localObject3	Object
    //   162	1	2	localException1	Exception
    //   164	1	2	localObject4	Object
    //   1	155	3	localObject5	Object
    //   168	1	3	localException2	Exception
    //   7	47	4	localMessageDigest	MessageDigest
    //   152	5	4	localObject6	Object
    //   17	25	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   66	70	80	java/io/IOException
    //   74	78	80	java/io/IOException
    //   2	29	88	java/lang/Exception
    //   97	101	111	java/io/IOException
    //   105	109	111	java/io/IOException
    //   2	29	119	finally
    //   126	130	140	java/io/IOException
    //   134	138	140	java/io/IOException
    //   29	34	148	finally
    //   34	62	152	finally
    //   29	34	162	java/lang/Exception
    //   34	62	168	java/lang/Exception
  }
  
  public String getMD5(byte[] paramArrayOfByte)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      int k = paramArrayOfByte.length;
      localObject = new char[k * 2];
      int j = 0;
      while (i < k)
      {
        int m = j + 1;
        localObject[j] = this.b[(paramArrayOfByte[i] >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = this.b[(paramArrayOfByte[i] & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */