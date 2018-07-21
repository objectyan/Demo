package com.baidu.ufosdk.util;

public final class t
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnonnull +9 -> 15
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 5
    //   14: areturn
    //   15: new 18	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 22	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore 6
    //   24: aload 6
    //   26: iconst_1
    //   27: putfield 26	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: iconst_0
    //   32: aload_0
    //   33: arraylength
    //   34: aload 6
    //   36: invokestatic 32	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: pop
    //   40: aload 6
    //   42: getfield 36	android/graphics/BitmapFactory$Options:outHeight	I
    //   45: istore 4
    //   47: aload 6
    //   49: getfield 39	android/graphics/BitmapFactory$Options:outWidth	I
    //   52: istore_3
    //   53: iload 4
    //   55: sipush 800
    //   58: if_icmpgt +10 -> 68
    //   61: iload_3
    //   62: sipush 480
    //   65: if_icmple +27 -> 92
    //   68: iload 4
    //   70: i2f
    //   71: ldc 40
    //   73: fdiv
    //   74: invokestatic 46	java/lang/Math:round	(F)I
    //   77: istore_2
    //   78: iload_3
    //   79: i2f
    //   80: ldc 47
    //   82: fdiv
    //   83: invokestatic 46	java/lang/Math:round	(F)I
    //   86: istore_3
    //   87: iload_2
    //   88: iload_3
    //   89: if_icmpge +163 -> 252
    //   92: aload 6
    //   94: iload_2
    //   95: putfield 50	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   98: aload 6
    //   100: getstatic 56	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   103: putfield 59	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   106: aload 6
    //   108: iconst_1
    //   109: putfield 62	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   112: aload 6
    //   114: iconst_1
    //   115: putfield 65	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   118: aload 6
    //   120: iconst_0
    //   121: putfield 26	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   124: aload_0
    //   125: iconst_0
    //   126: aload_0
    //   127: arraylength
    //   128: aload 6
    //   130: invokestatic 32	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   133: astore_0
    //   134: new 67	android/graphics/Matrix
    //   137: dup
    //   138: invokespecial 68	android/graphics/Matrix:<init>	()V
    //   141: astore 5
    //   143: aload 5
    //   145: iload_1
    //   146: i2f
    //   147: invokevirtual 72	android/graphics/Matrix:postRotate	(F)Z
    //   150: pop
    //   151: aload_0
    //   152: iconst_0
    //   153: iconst_0
    //   154: aload_0
    //   155: invokevirtual 78	android/graphics/Bitmap:getWidth	()I
    //   158: aload_0
    //   159: invokevirtual 81	android/graphics/Bitmap:getHeight	()I
    //   162: aload 5
    //   164: iconst_1
    //   165: invokestatic 85	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   168: astore 5
    //   170: aload 5
    //   172: astore_0
    //   173: aload_0
    //   174: astore 5
    //   176: new 87	java/io/ByteArrayOutputStream
    //   179: dup
    //   180: invokespecial 88	java/io/ByteArrayOutputStream:<init>	()V
    //   183: astore 6
    //   185: aload_0
    //   186: astore 5
    //   188: aload_0
    //   189: getstatic 94	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   192: bipush 30
    //   194: aload 6
    //   196: invokevirtual 98	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   199: pop
    //   200: aload_0
    //   201: astore 5
    //   203: aload 6
    //   205: invokevirtual 101	java/io/ByteArrayOutputStream:flush	()V
    //   208: aload_0
    //   209: astore 5
    //   211: aload 6
    //   213: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   216: aload_0
    //   217: astore 5
    //   219: aload 6
    //   221: invokevirtual 108	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   224: astore 6
    //   226: aload 6
    //   228: astore 5
    //   230: aload_0
    //   231: ifnull -219 -> 12
    //   234: aload 6
    //   236: astore 5
    //   238: aload_0
    //   239: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   242: ifne -230 -> 12
    //   245: aload_0
    //   246: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   249: aload 6
    //   251: areturn
    //   252: iload_3
    //   253: istore_2
    //   254: goto -162 -> 92
    //   257: astore_0
    //   258: aconst_null
    //   259: astore_0
    //   260: aload_0
    //   261: ifnull +14 -> 275
    //   264: aload_0
    //   265: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   268: ifne +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   275: aconst_null
    //   276: areturn
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_0
    //   280: aload_0
    //   281: ifnull +14 -> 295
    //   284: aload_0
    //   285: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   288: ifne +7 -> 295
    //   291: aload_0
    //   292: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_0
    //   300: aload_0
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   308: ifne +7 -> 315
    //   311: aload_0
    //   312: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   315: aconst_null
    //   316: areturn
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: aload_0
    //   321: astore 5
    //   323: invokestatic 120	java/lang/System:gc	()V
    //   326: aload_0
    //   327: ifnull +14 -> 341
    //   330: aload_0
    //   331: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   334: ifne +7 -> 341
    //   337: aload_0
    //   338: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   341: aconst_null
    //   342: areturn
    //   343: astore_0
    //   344: aconst_null
    //   345: astore_0
    //   346: aload_0
    //   347: ifnull +14 -> 361
    //   350: aload_0
    //   351: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   354: ifne +7 -> 361
    //   357: aload_0
    //   358: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   361: aconst_null
    //   362: areturn
    //   363: astore_0
    //   364: aload 5
    //   366: ifnull +16 -> 382
    //   369: aload 5
    //   371: invokevirtual 112	android/graphics/Bitmap:isRecycled	()Z
    //   374: ifne +8 -> 382
    //   377: aload 5
    //   379: invokevirtual 115	android/graphics/Bitmap:recycle	()V
    //   382: aload_0
    //   383: athrow
    //   384: astore 6
    //   386: aload_0
    //   387: astore 5
    //   389: aload 6
    //   391: astore_0
    //   392: goto -28 -> 364
    //   395: astore_0
    //   396: goto -32 -> 364
    //   399: astore 5
    //   401: goto -55 -> 346
    //   404: astore 5
    //   406: goto -60 -> 346
    //   409: astore 5
    //   411: goto -91 -> 320
    //   414: astore 5
    //   416: goto -96 -> 320
    //   419: astore 5
    //   421: goto -121 -> 300
    //   424: astore 5
    //   426: goto -126 -> 300
    //   429: astore 5
    //   431: goto -151 -> 280
    //   434: astore 5
    //   436: goto -156 -> 280
    //   439: astore 5
    //   441: goto -181 -> 260
    //   444: astore 5
    //   446: goto -186 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	paramArrayOfByte	byte[]
    //   0	449	1	paramInt	int
    //   1	253	2	i	int
    //   52	201	3	j	int
    //   45	24	4	k	int
    //   3	385	5	localObject1	Object
    //   399	1	5	localException1	Exception
    //   404	1	5	localException2	Exception
    //   409	1	5	localOutOfMemoryError1	OutOfMemoryError
    //   414	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   419	1	5	localRuntimeException1	RuntimeException
    //   424	1	5	localRuntimeException2	RuntimeException
    //   429	1	5	localNullPointerException1	NullPointerException
    //   434	1	5	localNullPointerException2	NullPointerException
    //   439	1	5	localIllegalArgumentException1	IllegalArgumentException
    //   444	1	5	localIllegalArgumentException2	IllegalArgumentException
    //   22	228	6	localObject2	Object
    //   384	6	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	53	257	java/lang/IllegalArgumentException
    //   68	87	257	java/lang/IllegalArgumentException
    //   92	134	257	java/lang/IllegalArgumentException
    //   15	53	277	java/lang/NullPointerException
    //   68	87	277	java/lang/NullPointerException
    //   92	134	277	java/lang/NullPointerException
    //   15	53	297	java/lang/RuntimeException
    //   68	87	297	java/lang/RuntimeException
    //   92	134	297	java/lang/RuntimeException
    //   15	53	317	java/lang/OutOfMemoryError
    //   68	87	317	java/lang/OutOfMemoryError
    //   92	134	317	java/lang/OutOfMemoryError
    //   15	53	343	java/lang/Exception
    //   68	87	343	java/lang/Exception
    //   92	134	343	java/lang/Exception
    //   15	53	363	finally
    //   68	87	363	finally
    //   92	134	363	finally
    //   134	170	384	finally
    //   176	185	395	finally
    //   188	200	395	finally
    //   203	208	395	finally
    //   211	216	395	finally
    //   219	226	395	finally
    //   323	326	395	finally
    //   134	170	399	java/lang/Exception
    //   176	185	404	java/lang/Exception
    //   188	200	404	java/lang/Exception
    //   203	208	404	java/lang/Exception
    //   211	216	404	java/lang/Exception
    //   219	226	404	java/lang/Exception
    //   134	170	409	java/lang/OutOfMemoryError
    //   176	185	414	java/lang/OutOfMemoryError
    //   188	200	414	java/lang/OutOfMemoryError
    //   203	208	414	java/lang/OutOfMemoryError
    //   211	216	414	java/lang/OutOfMemoryError
    //   219	226	414	java/lang/OutOfMemoryError
    //   134	170	419	java/lang/RuntimeException
    //   176	185	424	java/lang/RuntimeException
    //   188	200	424	java/lang/RuntimeException
    //   203	208	424	java/lang/RuntimeException
    //   211	216	424	java/lang/RuntimeException
    //   219	226	424	java/lang/RuntimeException
    //   134	170	429	java/lang/NullPointerException
    //   176	185	434	java/lang/NullPointerException
    //   188	200	434	java/lang/NullPointerException
    //   203	208	434	java/lang/NullPointerException
    //   211	216	434	java/lang/NullPointerException
    //   219	226	434	java/lang/NullPointerException
    //   134	170	439	java/lang/IllegalArgumentException
    //   176	185	444	java/lang/IllegalArgumentException
    //   188	200	444	java/lang/IllegalArgumentException
    //   203	208	444	java/lang/IllegalArgumentException
    //   211	216	444	java/lang/IllegalArgumentException
    //   219	226	444	java/lang/IllegalArgumentException
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/util/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */