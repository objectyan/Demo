package com.baidu.ufosdk.e;

public final class b
{
  private static String a;
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: new 11	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 13
    //   15: invokespecial 17	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 25	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 31	com/baidu/ufosdk/util/c:b	(Ljava/lang/String;)I
    //   28: pop
    //   29: new 33	java/net/URL
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 34	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: invokevirtual 38	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   40: checkcast 40	java/net/HttpURLConnection
    //   43: astore_0
    //   44: aload_0
    //   45: ldc 42
    //   47: invokevirtual 45	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual 49	java/net/HttpURLConnection:setDoInput	(Z)V
    //   55: aload_0
    //   56: iconst_1
    //   57: invokevirtual 52	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 55	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   65: aload_0
    //   66: iconst_1
    //   67: invokevirtual 58	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   70: getstatic 60	com/baidu/ufosdk/e/b:a	Ljava/lang/String;
    //   73: ifnonnull +40 -> 113
    //   76: new 11	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 62
    //   82: invokespecial 17	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: invokestatic 66	com/baidu/ufosdk/b/d:a	()Ljava/lang/String;
    //   88: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 68
    //   93: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokestatic 71	com/baidu/ufosdk/b/d:c	()Ljava/lang/String;
    //   99: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 73
    //   104: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 25	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: putstatic 60	com/baidu/ufosdk/e/b:a	Ljava/lang/String;
    //   113: aload_0
    //   114: ldc 75
    //   116: getstatic 60	com/baidu/ufosdk/e/b:a	Ljava/lang/String;
    //   119: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: sipush 3000
    //   126: invokevirtual 83	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   129: aload_0
    //   130: sipush 3000
    //   133: invokevirtual 86	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   136: aload_0
    //   137: ldc 88
    //   139: ldc 90
    //   141: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: ldc 92
    //   147: ldc 90
    //   149: invokevirtual 79	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: new 94	java/io/DataOutputStream
    //   155: dup
    //   156: aload_0
    //   157: invokevirtual 98	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   160: invokespecial 101	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: astore_3
    //   164: aload_3
    //   165: aload_1
    //   166: invokevirtual 104	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   169: aload_3
    //   170: invokevirtual 108	java/io/DataOutputStream:flush	()V
    //   173: aload_3
    //   174: invokevirtual 111	java/io/DataOutputStream:close	()V
    //   177: new 113	java/lang/StringBuffer
    //   180: dup
    //   181: invokespecial 115	java/lang/StringBuffer:<init>	()V
    //   184: astore_2
    //   185: aload_0
    //   186: invokevirtual 119	java/net/HttpURLConnection:getResponseCode	()I
    //   189: sipush 200
    //   192: if_icmpne +497 -> 689
    //   195: new 121	java/io/InputStreamReader
    //   198: dup
    //   199: aload_0
    //   200: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   203: invokespecial 128	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   206: astore_1
    //   207: new 130	java/io/BufferedReader
    //   210: dup
    //   211: aload_1
    //   212: invokespecial 133	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   215: astore 4
    //   217: aload 4
    //   219: invokevirtual 136	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   222: astore 5
    //   224: aload 5
    //   226: ifnonnull +86 -> 312
    //   229: new 11	java/lang/StringBuilder
    //   232: dup
    //   233: ldc -118
    //   235: invokespecial 17	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload_2
    //   239: invokevirtual 139	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   242: invokevirtual 21	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 25	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 141	com/baidu/ufosdk/util/c:a	(Ljava/lang/String;)I
    //   251: pop
    //   252: aload_1
    //   253: invokevirtual 142	java/io/InputStreamReader:close	()V
    //   256: aload 4
    //   258: invokevirtual 143	java/io/BufferedReader:close	()V
    //   261: aload_1
    //   262: astore 5
    //   264: aload 4
    //   266: astore_1
    //   267: aload_0
    //   268: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   271: aload_2
    //   272: invokevirtual 139	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   275: astore 4
    //   277: aload_3
    //   278: invokevirtual 111	java/io/DataOutputStream:close	()V
    //   281: aload_0
    //   282: ifnull +7 -> 289
    //   285: aload_0
    //   286: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   289: aload_1
    //   290: ifnull +7 -> 297
    //   293: aload_1
    //   294: invokevirtual 143	java/io/BufferedReader:close	()V
    //   297: aload 5
    //   299: ifnull +8 -> 307
    //   302: aload 5
    //   304: invokevirtual 142	java/io/InputStreamReader:close	()V
    //   307: aload 4
    //   309: astore_0
    //   310: aload_0
    //   311: areturn
    //   312: aload_2
    //   313: aload 5
    //   315: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   318: ldc -105
    //   320: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   323: pop
    //   324: goto -107 -> 217
    //   327: astore 6
    //   329: aload_1
    //   330: astore 5
    //   332: aload_2
    //   333: astore 7
    //   335: aload_3
    //   336: astore_2
    //   337: aload_0
    //   338: astore_1
    //   339: aload 4
    //   341: astore_0
    //   342: aload 7
    //   344: astore 4
    //   346: aload 6
    //   348: astore_3
    //   349: aload_3
    //   350: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   353: aload 4
    //   355: invokevirtual 139	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   358: astore_3
    //   359: aload_2
    //   360: ifnull +7 -> 367
    //   363: aload_2
    //   364: invokevirtual 111	java/io/DataOutputStream:close	()V
    //   367: aload_1
    //   368: ifnull +7 -> 375
    //   371: aload_1
    //   372: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   375: aload_0
    //   376: ifnull +7 -> 383
    //   379: aload_0
    //   380: invokevirtual 143	java/io/BufferedReader:close	()V
    //   383: aload_3
    //   384: astore_0
    //   385: aload 5
    //   387: ifnull -77 -> 310
    //   390: aload 5
    //   392: invokevirtual 142	java/io/InputStreamReader:close	()V
    //   395: aload_3
    //   396: areturn
    //   397: astore_0
    //   398: aload_0
    //   399: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   402: aload_3
    //   403: areturn
    //   404: astore_0
    //   405: aload_0
    //   406: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   409: goto -102 -> 307
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_2
    //   415: aconst_null
    //   416: astore_1
    //   417: aconst_null
    //   418: astore_3
    //   419: aload 4
    //   421: astore 5
    //   423: aload_3
    //   424: ifnull +7 -> 431
    //   427: aload_3
    //   428: invokevirtual 111	java/io/DataOutputStream:close	()V
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   439: aload_2
    //   440: ifnull +7 -> 447
    //   443: aload_2
    //   444: invokevirtual 143	java/io/BufferedReader:close	()V
    //   447: aload 5
    //   449: ifnull +8 -> 457
    //   452: aload 5
    //   454: invokevirtual 142	java/io/InputStreamReader:close	()V
    //   457: aload_0
    //   458: athrow
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 154	java/lang/Exception:printStackTrace	()V
    //   464: goto -7 -> 457
    //   467: astore 5
    //   469: aconst_null
    //   470: astore_2
    //   471: aload_0
    //   472: astore_1
    //   473: aconst_null
    //   474: astore_3
    //   475: aload 5
    //   477: astore_0
    //   478: aload 4
    //   480: astore 5
    //   482: goto -59 -> 423
    //   485: astore 5
    //   487: aconst_null
    //   488: astore_2
    //   489: aload_0
    //   490: astore_1
    //   491: aload 5
    //   493: astore_0
    //   494: aload 4
    //   496: astore 5
    //   498: goto -75 -> 423
    //   501: astore 5
    //   503: aconst_null
    //   504: astore 4
    //   506: aload_0
    //   507: astore_2
    //   508: aload 5
    //   510: astore_0
    //   511: aload_1
    //   512: astore 5
    //   514: aload_2
    //   515: astore_1
    //   516: aload 4
    //   518: astore_2
    //   519: goto -96 -> 423
    //   522: astore 5
    //   524: aload_0
    //   525: astore_2
    //   526: aload 5
    //   528: astore_0
    //   529: aload_1
    //   530: astore 5
    //   532: aload_2
    //   533: astore_1
    //   534: aload 4
    //   536: astore_2
    //   537: goto -114 -> 423
    //   540: astore 4
    //   542: aload_1
    //   543: astore_2
    //   544: aload_0
    //   545: astore_1
    //   546: aload 4
    //   548: astore_0
    //   549: goto -126 -> 423
    //   552: astore 4
    //   554: aload_2
    //   555: astore_3
    //   556: aload_0
    //   557: astore_2
    //   558: aload 4
    //   560: astore_0
    //   561: goto -138 -> 423
    //   564: astore_3
    //   565: aconst_null
    //   566: astore 4
    //   568: aconst_null
    //   569: astore_0
    //   570: aconst_null
    //   571: astore_1
    //   572: aconst_null
    //   573: astore_2
    //   574: goto -225 -> 349
    //   577: astore_3
    //   578: aconst_null
    //   579: astore 6
    //   581: aload_0
    //   582: astore_1
    //   583: aconst_null
    //   584: astore_2
    //   585: aconst_null
    //   586: astore 4
    //   588: aload 6
    //   590: astore_0
    //   591: goto -242 -> 349
    //   594: astore 4
    //   596: aconst_null
    //   597: astore 6
    //   599: aload_0
    //   600: astore_1
    //   601: aload_3
    //   602: astore_2
    //   603: aload 4
    //   605: astore_3
    //   606: aconst_null
    //   607: astore 4
    //   609: aload 6
    //   611: astore_0
    //   612: goto -263 -> 349
    //   615: astore 4
    //   617: aload_0
    //   618: astore_1
    //   619: aload_3
    //   620: astore 6
    //   622: aload 4
    //   624: astore_3
    //   625: aconst_null
    //   626: astore_0
    //   627: aload_2
    //   628: astore 4
    //   630: aload 6
    //   632: astore_2
    //   633: goto -284 -> 349
    //   636: astore 4
    //   638: aload_3
    //   639: astore 6
    //   641: aconst_null
    //   642: astore 7
    //   644: aload_1
    //   645: astore 5
    //   647: aload_0
    //   648: astore_1
    //   649: aload 4
    //   651: astore_3
    //   652: aload_2
    //   653: astore 4
    //   655: aload 7
    //   657: astore_0
    //   658: aload 6
    //   660: astore_2
    //   661: goto -312 -> 349
    //   664: astore 4
    //   666: aload_3
    //   667: astore 6
    //   669: aload_0
    //   670: astore 7
    //   672: aload 4
    //   674: astore_3
    //   675: aload_2
    //   676: astore 4
    //   678: aload_1
    //   679: astore_0
    //   680: aload 7
    //   682: astore_1
    //   683: aload 6
    //   685: astore_2
    //   686: goto -337 -> 349
    //   689: aconst_null
    //   690: astore_1
    //   691: aload 6
    //   693: astore 5
    //   695: goto -428 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	paramString1	String
    //   0	698	1	paramString2	String
    //   184	502	2	localObject1	Object
    //   163	393	3	localObject2	Object
    //   564	1	3	localException1	Exception
    //   577	25	3	localException2	Exception
    //   605	70	3	localException3	Exception
    //   4	531	4	localObject3	Object
    //   540	7	4	localObject4	Object
    //   552	7	4	localObject5	Object
    //   566	21	4	localObject6	Object
    //   594	10	4	localException4	Exception
    //   607	1	4	localObject7	Object
    //   615	8	4	localException5	Exception
    //   628	1	4	localObject8	Object
    //   636	14	4	localException6	Exception
    //   653	1	4	localObject9	Object
    //   664	9	4	localException7	Exception
    //   676	1	4	localObject10	Object
    //   1	452	5	localObject11	Object
    //   467	9	5	localObject12	Object
    //   480	1	5	localObject13	Object
    //   485	7	5	localObject14	Object
    //   496	1	5	localObject15	Object
    //   501	8	5	localObject16	Object
    //   512	1	5	str	String
    //   522	5	5	localObject17	Object
    //   530	164	5	localObject18	Object
    //   7	1	6	localObject19	Object
    //   327	20	6	localException8	Exception
    //   579	113	6	localObject20	Object
    //   333	348	7	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   217	224	327	java/lang/Exception
    //   229	261	327	java/lang/Exception
    //   312	324	327	java/lang/Exception
    //   363	367	397	java/lang/Exception
    //   371	375	397	java/lang/Exception
    //   379	383	397	java/lang/Exception
    //   390	395	397	java/lang/Exception
    //   277	281	404	java/lang/Exception
    //   285	289	404	java/lang/Exception
    //   293	297	404	java/lang/Exception
    //   302	307	404	java/lang/Exception
    //   9	44	412	finally
    //   427	431	459	java/lang/Exception
    //   435	439	459	java/lang/Exception
    //   443	447	459	java/lang/Exception
    //   452	457	459	java/lang/Exception
    //   44	113	467	finally
    //   113	164	467	finally
    //   164	185	485	finally
    //   185	207	485	finally
    //   207	217	501	finally
    //   217	224	522	finally
    //   229	261	522	finally
    //   312	324	522	finally
    //   267	277	540	finally
    //   349	359	552	finally
    //   9	44	564	java/lang/Exception
    //   44	113	577	java/lang/Exception
    //   113	164	577	java/lang/Exception
    //   164	185	594	java/lang/Exception
    //   185	207	615	java/lang/Exception
    //   207	217	636	java/lang/Exception
    //   267	277	664	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */