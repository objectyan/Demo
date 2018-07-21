package com.baidu.navi.driveanalysis.util;

public class CSVUtils
{
  private static final String SEPARATOR = ",";
  private static final String TAILED = "\r\n";
  
  /* Error */
  public static boolean exportCsv(java.io.File paramFile, java.util.List<com.baidu.navi.driveanalysis.model.TrackModel> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 7
    //   18: new 24	java/io/FileOutputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 27	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: new 29	java/io/OutputStreamWriter
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 32	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   35: astore 4
    //   37: new 34	java/io/BufferedWriter
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 37	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   46: astore 5
    //   48: aload_1
    //   49: ifnull +574 -> 623
    //   52: aload_1
    //   53: invokeinterface 43 1 0
    //   58: ifne +565 -> 623
    //   61: aload 5
    //   63: ldc 45
    //   65: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   68: pop
    //   69: aload 5
    //   71: ldc 8
    //   73: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   76: pop
    //   77: aload 5
    //   79: ldc 51
    //   81: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   84: pop
    //   85: aload 5
    //   87: ldc 8
    //   89: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   92: pop
    //   93: aload 5
    //   95: ldc 53
    //   97: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   100: pop
    //   101: aload 5
    //   103: ldc 8
    //   105: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   108: pop
    //   109: aload 5
    //   111: ldc 55
    //   113: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   116: pop
    //   117: aload 5
    //   119: ldc 8
    //   121: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   124: pop
    //   125: aload 5
    //   127: ldc 57
    //   129: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   132: pop
    //   133: aload 5
    //   135: ldc 8
    //   137: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   140: pop
    //   141: aload 5
    //   143: ldc 59
    //   145: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   148: pop
    //   149: aload 5
    //   151: ldc 8
    //   153: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   156: pop
    //   157: aload 5
    //   159: ldc 61
    //   161: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   164: pop
    //   165: aload 5
    //   167: ldc 8
    //   169: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   172: pop
    //   173: aload 5
    //   175: ldc 63
    //   177: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   180: pop
    //   181: aload 5
    //   183: ldc 8
    //   185: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   188: pop
    //   189: aload 5
    //   191: ldc 65
    //   193: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   196: pop
    //   197: aload 5
    //   199: ldc 11
    //   201: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   204: pop
    //   205: aload_1
    //   206: invokeinterface 69 1 0
    //   211: istore_2
    //   212: aload_1
    //   213: invokeinterface 73 1 0
    //   218: astore_1
    //   219: aload_1
    //   220: invokeinterface 78 1 0
    //   225: ifeq +398 -> 623
    //   228: aload_1
    //   229: invokeinterface 82 1 0
    //   234: checkcast 84	com/baidu/navi/driveanalysis/model/TrackModel
    //   237: astore 6
    //   239: aload 5
    //   241: new 86	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   248: ldc 89
    //   250: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 6
    //   255: getfield 95	com/baidu/navi/driveanalysis/model/TrackModel:latitude	D
    //   258: invokevirtual 98	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   261: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   267: pop
    //   268: aload 5
    //   270: ldc 8
    //   272: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   275: pop
    //   276: aload 5
    //   278: new 86	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   285: ldc 89
    //   287: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 6
    //   292: getfield 104	com/baidu/navi/driveanalysis/model/TrackModel:longitude	D
    //   295: invokevirtual 98	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   298: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   304: pop
    //   305: aload 5
    //   307: ldc 8
    //   309: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   312: pop
    //   313: aload 5
    //   315: new 86	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   322: ldc 89
    //   324: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 6
    //   329: getfield 108	com/baidu/navi/driveanalysis/model/TrackModel:coordType	I
    //   332: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   341: pop
    //   342: aload 5
    //   344: ldc 8
    //   346: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   349: pop
    //   350: aload 5
    //   352: new 86	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   359: ldc 89
    //   361: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload 6
    //   366: getfield 113	com/baidu/navi/driveanalysis/model/TrackModel:speed	D
    //   369: invokevirtual 98	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   372: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   378: pop
    //   379: aload 5
    //   381: ldc 8
    //   383: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   386: pop
    //   387: aload 5
    //   389: new 86	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   396: ldc 89
    //   398: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 6
    //   403: getfield 115	com/baidu/navi/driveanalysis/model/TrackModel:direction	I
    //   406: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   415: pop
    //   416: aload 5
    //   418: ldc 8
    //   420: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   423: pop
    //   424: aload 5
    //   426: new 86	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   433: ldc 89
    //   435: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 6
    //   440: getfield 117	com/baidu/navi/driveanalysis/model/TrackModel:height	D
    //   443: invokevirtual 98	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   446: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   452: pop
    //   453: aload 5
    //   455: ldc 8
    //   457: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   460: pop
    //   461: aload 5
    //   463: new 86	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   470: ldc 89
    //   472: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 6
    //   477: getfield 119	com/baidu/navi/driveanalysis/model/TrackModel:radius	D
    //   480: invokevirtual 98	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   483: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   489: pop
    //   490: aload 5
    //   492: ldc 8
    //   494: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   497: pop
    //   498: aload 5
    //   500: new 86	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   507: ldc 89
    //   509: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 6
    //   514: getfield 123	com/baidu/navi/driveanalysis/model/TrackModel:localTime	J
    //   517: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   520: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   526: pop
    //   527: aload 5
    //   529: ldc 8
    //   531: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   534: pop
    //   535: aload 5
    //   537: new 86	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   544: ldc 89
    //   546: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 6
    //   551: getfield 130	com/baidu/navi/driveanalysis/model/TrackModel:isConnectWithVehicle	Z
    //   554: invokevirtual 133	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   563: pop
    //   564: iload_2
    //   565: iconst_1
    //   566: isub
    //   567: istore_3
    //   568: iload_3
    //   569: istore_2
    //   570: iload_3
    //   571: ifle -352 -> 219
    //   574: aload 5
    //   576: ldc 11
    //   578: invokevirtual 49	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   581: pop
    //   582: iload_3
    //   583: istore_2
    //   584: goto -365 -> 219
    //   587: astore_1
    //   588: aload 4
    //   590: astore_1
    //   591: aload 5
    //   593: astore 4
    //   595: aload 4
    //   597: ifnull +8 -> 605
    //   600: aload 4
    //   602: invokevirtual 136	java/io/BufferedWriter:close	()V
    //   605: aload_1
    //   606: ifnull +7 -> 613
    //   609: aload_1
    //   610: invokevirtual 137	java/io/OutputStreamWriter:close	()V
    //   613: aload_0
    //   614: ifnull +7 -> 621
    //   617: aload_0
    //   618: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   621: iconst_0
    //   622: ireturn
    //   623: aload 5
    //   625: ifnull +33 -> 658
    //   628: aload 5
    //   630: invokevirtual 136	java/io/BufferedWriter:close	()V
    //   633: aload 4
    //   635: ifnull +31 -> 666
    //   638: aload 4
    //   640: invokevirtual 137	java/io/OutputStreamWriter:close	()V
    //   643: aload_0
    //   644: ifnull +187 -> 831
    //   647: aload_0
    //   648: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   651: iconst_1
    //   652: ireturn
    //   653: astore_1
    //   654: aload_1
    //   655: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   658: goto -25 -> 633
    //   661: astore_1
    //   662: aload_1
    //   663: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   666: goto -23 -> 643
    //   669: astore_0
    //   670: aload_0
    //   671: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   674: iconst_1
    //   675: ireturn
    //   676: astore 4
    //   678: aload 4
    //   680: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   683: goto -78 -> 605
    //   686: astore_1
    //   687: aload_1
    //   688: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   691: goto -78 -> 613
    //   694: astore_0
    //   695: aload_0
    //   696: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   699: iconst_0
    //   700: ireturn
    //   701: astore_1
    //   702: aload 4
    //   704: astore_0
    //   705: aload 8
    //   707: astore 4
    //   709: aload 6
    //   711: astore 5
    //   713: aload 5
    //   715: ifnull +8 -> 723
    //   718: aload 5
    //   720: invokevirtual 136	java/io/BufferedWriter:close	()V
    //   723: aload 4
    //   725: ifnull +8 -> 733
    //   728: aload 4
    //   730: invokevirtual 137	java/io/OutputStreamWriter:close	()V
    //   733: aload_0
    //   734: ifnull +7 -> 741
    //   737: aload_0
    //   738: invokevirtual 138	java/io/FileOutputStream:close	()V
    //   741: aload_1
    //   742: athrow
    //   743: astore 5
    //   745: aload 5
    //   747: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   750: goto -27 -> 723
    //   753: astore 4
    //   755: aload 4
    //   757: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   760: goto -27 -> 733
    //   763: astore_0
    //   764: aload_0
    //   765: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   768: goto -27 -> 741
    //   771: astore_1
    //   772: aload 6
    //   774: astore 5
    //   776: aload 8
    //   778: astore 4
    //   780: goto -67 -> 713
    //   783: astore_1
    //   784: aload 6
    //   786: astore 5
    //   788: goto -75 -> 713
    //   791: astore_1
    //   792: goto -79 -> 713
    //   795: astore_0
    //   796: aload 7
    //   798: astore 4
    //   800: aload 5
    //   802: astore_1
    //   803: aload 9
    //   805: astore_0
    //   806: goto -211 -> 595
    //   809: astore_1
    //   810: aload 7
    //   812: astore 4
    //   814: aload 5
    //   816: astore_1
    //   817: goto -222 -> 595
    //   820: astore_1
    //   821: aload 4
    //   823: astore_1
    //   824: aload 7
    //   826: astore 4
    //   828: goto -233 -> 595
    //   831: iconst_1
    //   832: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	paramFile	java.io.File
    //   0	833	1	paramList	java.util.List<com.baidu.navi.driveanalysis.model.TrackModel>
    //   211	373	2	i	int
    //   567	16	3	j	int
    //   1	638	4	localObject1	Object
    //   676	27	4	localIOException1	java.io.IOException
    //   707	22	4	localObject2	Object
    //   753	3	4	localIOException2	java.io.IOException
    //   778	49	4	localObject3	Object
    //   10	709	5	localObject4	Object
    //   743	3	5	localIOException3	java.io.IOException
    //   774	41	5	localObject5	Object
    //   13	772	6	localTrackModel	com.baidu.navi.driveanalysis.model.TrackModel
    //   16	809	7	localObject6	Object
    //   7	770	8	localObject7	Object
    //   4	800	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   52	219	587	java/lang/Exception
    //   219	564	587	java/lang/Exception
    //   574	582	587	java/lang/Exception
    //   628	633	653	java/io/IOException
    //   638	643	661	java/io/IOException
    //   647	651	669	java/io/IOException
    //   600	605	676	java/io/IOException
    //   609	613	686	java/io/IOException
    //   617	621	694	java/io/IOException
    //   18	27	701	finally
    //   718	723	743	java/io/IOException
    //   728	733	753	java/io/IOException
    //   737	741	763	java/io/IOException
    //   27	37	771	finally
    //   37	48	783	finally
    //   52	219	791	finally
    //   219	564	791	finally
    //   574	582	791	finally
    //   18	27	795	java/lang/Exception
    //   27	37	809	java/lang/Exception
    //   37	48	820	java/lang/Exception
  }
  
  /* Error */
  public static java.util.List<String> importCsv(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 147	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 148	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_2
    //   12: new 150	java/io/BufferedReader
    //   15: dup
    //   16: new 152	java/io/FileReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 153	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   24: invokespecial 156	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_0
    //   28: aload_0
    //   29: invokevirtual 159	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +25 -> 59
    //   37: aload_3
    //   38: aload_1
    //   39: invokeinterface 163 2 0
    //   44: pop
    //   45: goto -17 -> 28
    //   48: astore_1
    //   49: aload_0
    //   50: ifnull +7 -> 57
    //   53: aload_0
    //   54: invokevirtual 164	java/io/BufferedReader:close	()V
    //   57: aload_3
    //   58: areturn
    //   59: aload_0
    //   60: ifnull +56 -> 116
    //   63: aload_0
    //   64: invokevirtual 164	java/io/BufferedReader:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   74: aload_3
    //   75: areturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   81: aload_3
    //   82: areturn
    //   83: astore_0
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 164	java/io/BufferedReader:close	()V
    //   92: aload_0
    //   93: athrow
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   99: goto -7 -> 92
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: goto -23 -> 84
    //   110: astore_0
    //   111: aload_2
    //   112: astore_0
    //   113: goto -64 -> 49
    //   116: aload_3
    //   117: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramFile	java.io.File
    //   9	30	1	str	String
    //   48	41	1	localException	Exception
    //   94	2	1	localIOException	java.io.IOException
    //   104	1	1	localFile	java.io.File
    //   11	1	2	localObject1	Object
    //   102	10	2	localObject2	Object
    //   7	110	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   28	33	48	java/lang/Exception
    //   37	45	48	java/lang/Exception
    //   63	67	69	java/io/IOException
    //   53	57	76	java/io/IOException
    //   12	28	83	finally
    //   88	92	94	java/io/IOException
    //   28	33	102	finally
    //   37	45	102	finally
    //   12	28	110	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/util/CSVUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */