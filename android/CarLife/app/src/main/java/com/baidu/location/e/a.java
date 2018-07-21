package com.baidu.location.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.a.h;
import com.baidu.location.f.e;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public final class a
{
  private static a b = null;
  private static final String l = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/";
  private static final String m = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata" + "/ls.db";
  public boolean a = false;
  private String c = null;
  private boolean d = false;
  private boolean e = false;
  private double f = 0.0D;
  private double g = 0.0D;
  private double h = 0.0D;
  private double i = 0.0D;
  private double j = 0.0D;
  private volatile boolean k = false;
  private Handler n = null;
  
  private a()
  {
    d();
  }
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  private void a(e parame, BDLocation paramBDLocation, SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F))) {
      break label36;
    }
    label36:
    label669:
    label675:
    for (;;)
    {
      return;
      if (parame.a != null)
      {
        int i5 = (int)(System.currentTimeMillis() >> 28);
        System.currentTimeMillis();
        parame = parame.a.iterator();
        int i1 = 0;
        for (;;)
        {
          if (!parame.hasNext()) {
            break label675;
          }
          Object localObject1 = (ScanResult)parame.next();
          if (((ScanResult)localObject1).level != 0)
          {
            i1 += 1;
            if (i1 > 6) {
              break;
            }
            ContentValues localContentValues = new ContentValues();
            localObject1 = Jni.encode2(((ScanResult)localObject1).BSSID.replace(":", ""));
            do
            {
              try
              {
                Object localObject2 = paramSQLiteDatabase.rawQuery("select * from wof where id = \"" + (String)localObject1 + "\";", null);
                double d2;
                double d1;
                int i2;
                int i3;
                if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
                {
                  d2 = ((Cursor)localObject2).getDouble(1);
                  d1 = ((Cursor)localObject2).getDouble(2);
                  i2 = ((Cursor)localObject2).getInt(4);
                  i4 = ((Cursor)localObject2).getInt(5);
                  d2 -= 113.2349D;
                  i3 = 1;
                }
                for (d1 -= 432.1238D;; d1 = 0.0D)
                {
                  if (localObject2 != null) {
                    ((Cursor)localObject2).close();
                  }
                  if (i3 != 0) {
                    break label669;
                  }
                  localContentValues.put("mktime", Double.valueOf(paramBDLocation.getLongitude() + 113.2349D));
                  localContentValues.put("time", Double.valueOf(paramBDLocation.getLatitude() + 432.1238D));
                  localContentValues.put("bc", Integer.valueOf(1));
                  localContentValues.put("cc", Integer.valueOf(1));
                  localContentValues.put("ac", Integer.valueOf(i5));
                  localContentValues.put("id", (String)localObject1);
                  paramSQLiteDatabase.insert("wof", null, localContentValues);
                  break;
                  localObject2 = new float[1];
                  Location.distanceBetween(d1, d2, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), (float[])localObject2);
                  if (localObject2[0] > 1500.0F)
                  {
                    i3 = i4 + 1;
                    if ((i3 > 10) && (i3 > i2 * 3))
                    {
                      localContentValues.put("mktime", Double.valueOf(paramBDLocation.getLongitude() + 113.2349D));
                      localContentValues.put("time", Double.valueOf(paramBDLocation.getLatitude() + 432.1238D));
                      localContentValues.put("bc", Integer.valueOf(1));
                      localContentValues.put("cc", Integer.valueOf(1));
                      localContentValues.put("ac", Integer.valueOf(i5));
                    }
                  }
                  try
                  {
                    for (;;)
                    {
                      i2 = paramSQLiteDatabase.update("wof", localContentValues, "id = \"" + (String)localObject1 + "\"", null);
                      if (i2 > 0) {
                        break;
                      }
                      break;
                      localContentValues.put("cc", Integer.valueOf(i3));
                      continue;
                      d2 = (d2 * i2 + paramBDLocation.getLongitude()) / (i2 + 1);
                      d1 = (d1 * i2 + paramBDLocation.getLatitude()) / (i2 + 1);
                      localContentValues.put("mktime", Double.valueOf(d2 + 113.2349D));
                      localContentValues.put("time", Double.valueOf(d1 + 432.1238D));
                      localContentValues.put("bc", Integer.valueOf(i2 + 1));
                      localContentValues.put("ac", Integer.valueOf(i5));
                    }
                    i4 = 0;
                  }
                  catch (Exception localException1) {}
                  i2 = 0;
                  d2 = 0.0D;
                  i3 = 0;
                }
              }
              catch (Exception localException2)
              {
                int i4;
                for (;;) {}
              }
            } while (i4 != 0);
          }
        }
      }
    }
  }
  
  /* Error */
  private void a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: aload_0
    //   8: getfield 73	com/baidu/location/e/a:c	Ljava/lang/String;
    //   11: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 75	com/baidu/location/e/a:d	Z
    //   23: aload_2
    //   24: new 37	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 285
    //   34: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc -61
    //   43: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: aconst_null
    //   50: invokevirtual 201	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_2
    //   54: aload_2
    //   55: astore_3
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 73	com/baidu/location/e/a:c	Ljava/lang/String;
    //   61: aload_2
    //   62: astore_3
    //   63: aload_2
    //   64: invokeinterface 206 1 0
    //   69: ifeq +61 -> 130
    //   72: aload_2
    //   73: astore_3
    //   74: aload_0
    //   75: aload_2
    //   76: iconst_1
    //   77: invokeinterface 210 2 0
    //   82: ldc2_w 286
    //   85: dsub
    //   86: putfield 81	com/baidu/location/e/a:g	D
    //   89: aload_2
    //   90: astore_3
    //   91: aload_0
    //   92: aload_2
    //   93: iconst_2
    //   94: invokeinterface 210 2 0
    //   99: ldc2_w 288
    //   102: dsub
    //   103: putfield 79	com/baidu/location/e/a:f	D
    //   106: aload_2
    //   107: astore_3
    //   108: aload_0
    //   109: aload_2
    //   110: iconst_3
    //   111: invokeinterface 210 2 0
    //   116: ldc2_w 290
    //   119: dsub
    //   120: putfield 83	com/baidu/location/e/a:h	D
    //   123: aload_2
    //   124: astore_3
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 75	com/baidu/location/e/a:d	Z
    //   130: aload_2
    //   131: ifnull -114 -> 17
    //   134: aload_2
    //   135: invokeinterface 221 1 0
    //   140: return
    //   141: astore_1
    //   142: return
    //   143: astore_1
    //   144: aload_3
    //   145: ifnull -128 -> 17
    //   148: aload_3
    //   149: invokeinterface 221 1 0
    //   154: return
    //   155: astore_1
    //   156: return
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_2
    //   160: aload_2
    //   161: ifnull +9 -> 170
    //   164: aload_2
    //   165: invokeinterface 221 1 0
    //   170: aload_1
    //   171: athrow
    //   172: astore_2
    //   173: goto -3 -> 170
    //   176: astore_1
    //   177: goto -17 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	a
    //   0	180	1	paramString	String
    //   0	180	2	paramSQLiteDatabase	SQLiteDatabase
    //   1	148	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   134	140	141	java/lang/Exception
    //   23	54	143	java/lang/Exception
    //   56	61	143	java/lang/Exception
    //   63	72	143	java/lang/Exception
    //   74	89	143	java/lang/Exception
    //   91	106	143	java/lang/Exception
    //   108	123	143	java/lang/Exception
    //   125	130	143	java/lang/Exception
    //   148	154	155	java/lang/Exception
    //   23	54	157	finally
    //   164	170	172	java/lang/Exception
    //   56	61	176	finally
    //   63	72	176	finally
    //   74	89	176	finally
    //   91	106	176	finally
    //   108	123	176	finally
    //   125	130	176	finally
  }
  
  private void a(String paramString, com.baidu.location.f.a parama, SQLiteDatabase paramSQLiteDatabase)
  {
    int i1 = 0;
    double d2 = 0.0D;
    if ((!parama.b()) || (!h.c().i())) {
      return;
    }
    System.currentTimeMillis();
    int i2 = (int)(System.currentTimeMillis() >> 28);
    parama = parama.g();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i3 = Integer.parseInt(paramString.getJSONObject("result").getString("error"));
        if (i3 == 161)
        {
          paramString = paramString.getJSONObject("content");
          if (!paramString.has("clf")) {
            break label374;
          }
          Object localObject = paramString.getString("clf");
          if (((String)localObject).equals("0"))
          {
            localObject = paramString.getJSONObject("point");
            d2 = Double.parseDouble(((JSONObject)localObject).getString("x"));
            d1 = Double.parseDouble(((JSONObject)localObject).getString("y"));
            f1 = Float.parseFloat(paramString.getString("radius"));
            if (i1 != 0) {
              break;
            }
            paramString = new ContentValues();
            paramString.put("time", Double.valueOf(d2 + 1235.4323D));
            paramString.put("tag", Float.valueOf(4326.0F + f1));
            paramString.put("type", Double.valueOf(d1 + 2367.3217D));
            paramString.put("ac", Integer.valueOf(i2));
            try
            {
              if (paramSQLiteDatabase.update("bdcltb09", paramString, "id = \"" + parama + "\"", null) > 0) {
                break;
              }
              paramString.put("id", parama);
              paramSQLiteDatabase.insert("bdcltb09", null, paramString);
              return;
            }
            catch (Exception paramString)
            {
              return;
            }
          }
          paramString = ((String)localObject).split("\\|");
          d2 = Double.parseDouble(paramString[0]);
          d1 = Double.parseDouble(paramString[1]);
          f1 = Float.parseFloat(paramString[2]);
          continue;
        }
        if (i3 == 167)
        {
          paramSQLiteDatabase.delete("bdcltb09", "id = \"" + parama + "\"", null);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      label374:
      i1 = 1;
      float f1 = 0.0F;
      double d1 = 0.0D;
    }
  }
  
  private void a(String paramString, List<ScanResult> paramList)
  {
    Object localObject;
    if ((paramString != null) && (!paramString.equals(this.c)))
    {
      localObject = SQLiteDatabase.openOrCreateDatabase(m, null);
      a(paramString, (SQLiteDatabase)localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = paramString;
      if (paramList != null)
      {
        localObject = paramString;
        if (paramString == null) {
          localObject = SQLiteDatabase.openOrCreateDatabase(m, null);
        }
        a(paramList, (SQLiteDatabase)localObject);
      }
      if ((localObject != null) && (((SQLiteDatabase)localObject).isOpen())) {
        ((SQLiteDatabase)localObject).close();
      }
      return;
    }
  }
  
  /* Error */
  private void a(List<ScanResult> paramList, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 77	com/baidu/location/e/a:e	Z
    //   9: aload_1
    //   10: ifnull +12 -> 22
    //   13: aload_1
    //   14: invokeinterface 393 1 0
    //   19: ifne +4 -> 23
    //   22: return
    //   23: aload_2
    //   24: ifnull -2 -> 22
    //   27: aload_1
    //   28: ifnull -6 -> 22
    //   31: dconst_0
    //   32: dstore 5
    //   34: dconst_0
    //   35: dstore_3
    //   36: iconst_0
    //   37: istore 17
    //   39: iconst_0
    //   40: istore 18
    //   42: bipush 8
    //   44: newarray <illegal type>
    //   46: astore 21
    //   48: iconst_0
    //   49: istore 19
    //   51: iconst_0
    //   52: istore 16
    //   54: new 395	java/lang/StringBuffer
    //   57: dup
    //   58: invokespecial 396	java/lang/StringBuffer:<init>	()V
    //   61: astore 22
    //   63: aload_1
    //   64: invokeinterface 155 1 0
    //   69: astore_1
    //   70: iconst_0
    //   71: istore 15
    //   73: aload_1
    //   74: invokeinterface 161 1 0
    //   79: ifeq +21 -> 100
    //   82: aload_1
    //   83: invokeinterface 165 1 0
    //   88: checkcast 167	android/net/wifi/ScanResult
    //   91: astore 23
    //   93: iload 15
    //   95: bipush 10
    //   97: if_icmple +158 -> 255
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_2
    //   103: new 37	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 398
    //   113: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 22
    //   118: invokevirtual 399	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   121: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 401
    //   127: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: aconst_null
    //   134: invokevirtual 201	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: aload_1
    //   141: invokeinterface 206 1 0
    //   146: ifeq +321 -> 467
    //   149: iload 19
    //   151: istore 15
    //   153: iload 17
    //   155: istore 19
    //   157: dload_3
    //   158: dstore 9
    //   160: dload 5
    //   162: dstore 7
    //   164: aload_1
    //   165: invokeinterface 404 1 0
    //   170: ifne +267 -> 437
    //   173: aload_1
    //   174: iconst_1
    //   175: invokeinterface 210 2 0
    //   180: ldc2_w 215
    //   183: dsub
    //   184: dstore 13
    //   186: aload_1
    //   187: iconst_2
    //   188: invokeinterface 210 2 0
    //   193: ldc2_w 217
    //   196: dsub
    //   197: dstore 11
    //   199: aload_1
    //   200: iconst_4
    //   201: invokeinterface 214 2 0
    //   206: istore 19
    //   208: aload_1
    //   209: iconst_5
    //   210: invokeinterface 214 2 0
    //   215: istore 20
    //   217: iload 20
    //   219: bipush 8
    //   221: if_icmple +94 -> 315
    //   224: iload 20
    //   226: iload 19
    //   228: if_icmple +87 -> 315
    //   231: aload_1
    //   232: invokeinterface 407 1 0
    //   237: pop
    //   238: goto -85 -> 153
    //   241: astore_2
    //   242: aload_1
    //   243: ifnull -221 -> 22
    //   246: aload_1
    //   247: invokeinterface 221 1 0
    //   252: return
    //   253: astore_1
    //   254: return
    //   255: iload 15
    //   257: ifle +12 -> 269
    //   260: aload 22
    //   262: ldc_w 409
    //   265: invokevirtual 412	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   268: pop
    //   269: iload 15
    //   271: iconst_1
    //   272: iadd
    //   273: istore 15
    //   275: aload 23
    //   277: getfield 177	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   280: ldc -77
    //   282: ldc -75
    //   284: invokevirtual 185	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   287: invokestatic 191	com/baidu/location/Jni:encode2	(Ljava/lang/String;)Ljava/lang/String;
    //   290: astore 23
    //   292: aload 22
    //   294: ldc_w 278
    //   297: invokevirtual 412	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   300: aload 23
    //   302: invokevirtual 412	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   305: ldc_w 278
    //   308: invokevirtual 412	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   311: pop
    //   312: goto -239 -> 73
    //   315: aload_0
    //   316: getfield 75	com/baidu/location/e/a:d	Z
    //   319: ifeq +161 -> 480
    //   322: iconst_1
    //   323: newarray <illegal type>
    //   325: astore_2
    //   326: dload 11
    //   328: dload 13
    //   330: aload_0
    //   331: getfield 83	com/baidu/location/e/a:h	D
    //   334: aload_0
    //   335: getfield 81	com/baidu/location/e/a:g	D
    //   338: aload_2
    //   339: invokestatic 273	android/location/Location:distanceBetween	(DDDD[F)V
    //   342: aload_2
    //   343: iconst_0
    //   344: faload
    //   345: f2d
    //   346: aload_0
    //   347: getfield 79	com/baidu/location/e/a:f	D
    //   350: ldc2_w 413
    //   353: dadd
    //   354: dcmpl
    //   355: ifle +32 -> 387
    //   358: aload_1
    //   359: invokeinterface 407 1 0
    //   364: pop
    //   365: goto -212 -> 153
    //   368: astore 21
    //   370: aload_1
    //   371: astore_2
    //   372: aload 21
    //   374: astore_1
    //   375: aload_2
    //   376: ifnull +9 -> 385
    //   379: aload_2
    //   380: invokeinterface 221 1 0
    //   385: aload_1
    //   386: athrow
    //   387: iconst_1
    //   388: istore 18
    //   390: dload 5
    //   392: dload 13
    //   394: dadd
    //   395: dstore 5
    //   397: dload_3
    //   398: dload 11
    //   400: dadd
    //   401: dstore_3
    //   402: iload 17
    //   404: iconst_1
    //   405: iadd
    //   406: istore 17
    //   408: iload 16
    //   410: istore 19
    //   412: iload 15
    //   414: istore 16
    //   416: iload 19
    //   418: istore 15
    //   420: iload 17
    //   422: iconst_4
    //   423: if_icmple +186 -> 609
    //   426: dload 5
    //   428: dstore 7
    //   430: dload_3
    //   431: dstore 9
    //   433: iload 17
    //   435: istore 19
    //   437: iload 19
    //   439: ifle +28 -> 467
    //   442: aload_0
    //   443: iconst_1
    //   444: putfield 77	com/baidu/location/e/a:e	Z
    //   447: aload_0
    //   448: dload 7
    //   450: iload 19
    //   452: i2d
    //   453: ddiv
    //   454: putfield 85	com/baidu/location/e/a:i	D
    //   457: aload_0
    //   458: dload 9
    //   460: iload 19
    //   462: i2d
    //   463: ddiv
    //   464: putfield 87	com/baidu/location/e/a:j	D
    //   467: aload_1
    //   468: ifnull -446 -> 22
    //   471: aload_1
    //   472: invokeinterface 221 1 0
    //   477: return
    //   478: astore_1
    //   479: return
    //   480: iload 18
    //   482: ifeq +193 -> 675
    //   485: iconst_1
    //   486: newarray <illegal type>
    //   488: astore_2
    //   489: dload 11
    //   491: dload 13
    //   493: dload_3
    //   494: iload 17
    //   496: i2d
    //   497: ddiv
    //   498: dload 5
    //   500: iload 17
    //   502: i2d
    //   503: ddiv
    //   504: aload_2
    //   505: invokestatic 273	android/location/Location:distanceBetween	(DDDD[F)V
    //   508: aload_2
    //   509: iconst_0
    //   510: faload
    //   511: ldc_w 415
    //   514: fcmpl
    //   515: ifle +145 -> 660
    //   518: aload_1
    //   519: invokeinterface 407 1 0
    //   524: pop
    //   525: goto -372 -> 153
    //   528: iload 19
    //   530: iload 16
    //   532: if_icmpge +211 -> 743
    //   535: iconst_1
    //   536: newarray <illegal type>
    //   538: astore_2
    //   539: dload 11
    //   541: dload 13
    //   543: aload 21
    //   545: iload 19
    //   547: iconst_1
    //   548: iadd
    //   549: daload
    //   550: aload 21
    //   552: iload 19
    //   554: daload
    //   555: aload_2
    //   556: invokestatic 273	android/location/Location:distanceBetween	(DDDD[F)V
    //   559: aload_2
    //   560: iconst_0
    //   561: faload
    //   562: ldc_w 415
    //   565: fcmpg
    //   566: ifge +79 -> 645
    //   569: iconst_1
    //   570: istore 18
    //   572: dload 5
    //   574: aload 21
    //   576: iload 19
    //   578: daload
    //   579: dadd
    //   580: dstore 5
    //   582: aload 21
    //   584: iload 19
    //   586: iconst_1
    //   587: iadd
    //   588: daload
    //   589: dload_3
    //   590: dadd
    //   591: dstore_3
    //   592: iload 17
    //   594: iconst_1
    //   595: iadd
    //   596: istore 20
    //   598: iload 18
    //   600: istore 17
    //   602: iload 20
    //   604: istore 18
    //   606: goto +112 -> 718
    //   609: aload_1
    //   610: invokeinterface 407 1 0
    //   615: pop
    //   616: iload 16
    //   618: istore 19
    //   620: iload 15
    //   622: istore 16
    //   624: iload 19
    //   626: istore 15
    //   628: goto -475 -> 153
    //   631: astore_2
    //   632: goto -247 -> 385
    //   635: astore_1
    //   636: aconst_null
    //   637: astore_2
    //   638: goto -263 -> 375
    //   641: astore_2
    //   642: goto -400 -> 242
    //   645: iload 17
    //   647: istore 20
    //   649: iload 18
    //   651: istore 17
    //   653: iload 20
    //   655: istore 18
    //   657: goto +61 -> 718
    //   660: iload 15
    //   662: istore 19
    //   664: iload 16
    //   666: istore 15
    //   668: iload 19
    //   670: istore 16
    //   672: goto -252 -> 420
    //   675: iload 15
    //   677: ifne +35 -> 712
    //   680: iload 16
    //   682: iconst_1
    //   683: iadd
    //   684: istore 15
    //   686: aload 21
    //   688: iload 16
    //   690: dload 13
    //   692: dastore
    //   693: aload 21
    //   695: iload 15
    //   697: dload 11
    //   699: dastore
    //   700: iconst_1
    //   701: istore 16
    //   703: iload 15
    //   705: iconst_1
    //   706: iadd
    //   707: istore 15
    //   709: goto -289 -> 420
    //   712: iconst_0
    //   713: istore 19
    //   715: goto -187 -> 528
    //   718: iload 19
    //   720: iconst_2
    //   721: iadd
    //   722: istore 20
    //   724: iload 18
    //   726: istore 19
    //   728: iload 17
    //   730: istore 18
    //   732: iload 19
    //   734: istore 17
    //   736: iload 20
    //   738: istore 19
    //   740: goto -212 -> 528
    //   743: iload 18
    //   745: ifeq +40 -> 785
    //   748: dload 5
    //   750: dload 13
    //   752: dadd
    //   753: dstore 5
    //   755: dload_3
    //   756: dload 11
    //   758: dadd
    //   759: dstore_3
    //   760: iload 17
    //   762: iconst_1
    //   763: iadd
    //   764: istore 19
    //   766: iload 15
    //   768: istore 17
    //   770: iload 16
    //   772: istore 15
    //   774: iload 17
    //   776: istore 16
    //   778: iload 19
    //   780: istore 17
    //   782: goto -362 -> 420
    //   785: iload 17
    //   787: istore 19
    //   789: dload_3
    //   790: dstore 9
    //   792: dload 5
    //   794: dstore 7
    //   796: iload 16
    //   798: bipush 8
    //   800: if_icmpge -363 -> 437
    //   803: iload 16
    //   805: iconst_1
    //   806: iadd
    //   807: istore 19
    //   809: aload 21
    //   811: iload 16
    //   813: dload 13
    //   815: dastore
    //   816: aload 21
    //   818: iload 19
    //   820: dload 11
    //   822: dastore
    //   823: iload 19
    //   825: iconst_1
    //   826: iadd
    //   827: istore 19
    //   829: iload 15
    //   831: istore 16
    //   833: iload 19
    //   835: istore 15
    //   837: goto -417 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	840	0	this	a
    //   0	840	1	paramList	List<ScanResult>
    //   0	840	2	paramSQLiteDatabase	SQLiteDatabase
    //   35	755	3	d1	double
    //   32	761	5	d2	double
    //   162	633	7	d3	double
    //   158	633	9	d4	double
    //   197	624	11	d5	double
    //   184	630	13	d6	double
    //   71	765	15	i1	int
    //   52	780	16	i2	int
    //   37	749	17	i3	int
    //   40	704	18	i4	int
    //   49	785	19	i5	int
    //   215	522	20	i6	int
    //   46	1	21	arrayOfDouble	double[]
    //   368	449	21	localObject1	Object
    //   61	232	22	localStringBuffer	StringBuffer
    //   91	210	23	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   140	149	241	java/lang/Exception
    //   164	217	241	java/lang/Exception
    //   231	238	241	java/lang/Exception
    //   315	365	241	java/lang/Exception
    //   442	467	241	java/lang/Exception
    //   485	508	241	java/lang/Exception
    //   518	525	241	java/lang/Exception
    //   535	559	241	java/lang/Exception
    //   609	616	241	java/lang/Exception
    //   246	252	253	java/lang/Exception
    //   140	149	368	finally
    //   164	217	368	finally
    //   231	238	368	finally
    //   315	365	368	finally
    //   442	467	368	finally
    //   485	508	368	finally
    //   518	525	368	finally
    //   535	559	368	finally
    //   609	616	368	finally
    //   471	477	478	java/lang/Exception
    //   379	385	631	java/lang/Exception
    //   102	138	635	finally
    //   102	138	641	java/lang/Exception
  }
  
  private String b(boolean paramBoolean)
  {
    double d1 = 0.0D;
    double d3;
    double d2;
    boolean bool;
    int i1;
    if (this.e)
    {
      d3 = this.i;
      d2 = this.j;
      d1 = 246.4D;
      bool = true;
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        String str;
        if (paramBoolean)
        {
          str = "{\"result\":{\"time\":\"" + com.baidu.location.h.g.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          return String.format(Locale.CHINA, str, new Object[] { Double.valueOf(d3), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(true) });
          if (this.d)
          {
            d3 = this.g;
            d2 = this.h;
            d1 = this.f;
            bool = h.c().i();
            i1 = 1;
          }
        }
        else
        {
          str = "{\"result\":{\"time\":\"" + com.baidu.location.h.g.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          return String.format(Locale.CHINA, str, new Object[] { Double.valueOf(d3), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(bool) });
        }
      }
      else
      {
        if (paramBoolean) {
          return "{\"result\":{\"time\":\"" + com.baidu.location.h.g.a() + "\",\"error\":\"67\"}}";
        }
        return "{\"result\":{\"time\":\"" + com.baidu.location.h.g.a() + "\",\"error\":\"63\"}}";
      }
      bool = false;
      i1 = 0;
      d2 = 0.0D;
      d3 = 0.0D;
    }
  }
  
  private void d()
  {
    try
    {
      Object localObject = new File(l);
      File localFile = new File(m);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      if (localFile.exists())
      {
        localObject = SQLiteDatabase.openOrCreateDatabase(localFile, null);
        ((SQLiteDatabase)localObject).execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        ((SQLiteDatabase)localObject).execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
        ((SQLiteDatabase)localObject).setVersion(1);
        ((SQLiteDatabase)localObject).close();
      }
      this.a = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void e()
  {
    boolean bool2 = true;
    SQLiteDatabase localSQLiteDatabase2;
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = SQLiteDatabase.openOrCreateDatabase(m, null);
      if (localSQLiteDatabase1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localSQLiteDatabase2 = null;
      }
    }
    for (;;)
    {
      long l2;
      try
      {
        long l1 = DatabaseUtils.queryNumEntries(localSQLiteDatabase2, "wof");
        l2 = DatabaseUtils.queryNumEntries(localSQLiteDatabase2, "bdcltb09");
        if (l1 <= 10000L) {
          break label105;
        }
        bool1 = true;
      }
      catch (Exception localException2)
      {
        return;
      }
      localSQLiteDatabase2.close();
      if ((!bool1) && (!bool2)) {
        break;
      }
      new a(null).execute(new Boolean[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      return;
      label105:
      boolean bool1 = false;
      while (l2 <= 10000L)
      {
        bool2 = false;
        break;
      }
    }
  }
  
  public BDLocation a(final String paramString, final List<ScanResult> paramList, boolean paramBoolean)
  {
    if (!this.a) {
      d();
    }
    localExecutorService = Executors.newSingleThreadExecutor();
    paramList = (FutureTask)localExecutorService.submit(new Callable()
    {
      public String a()
      {
        a.a(a.this, paramString, paramList);
        return a.a(a.this, true);
      }
    });
    try
    {
      paramString = (String)paramList.get(2000L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        paramList.cancel(true);
        localExecutorService.shutdown();
        paramString = "{\"result\":\"null\"}";
      }
    }
    catch (ExecutionException paramString)
    {
      for (;;)
      {
        paramList.cancel(true);
        localExecutorService.shutdown();
        paramString = "{\"result\":\"null\"}";
      }
    }
    catch (TimeoutException paramString)
    {
      for (;;)
      {
        if (paramBoolean) {
          com.baidu.location.d.g.a().a("old offlineLocation Timeout Exception!");
        }
        paramList.cancel(true);
        localExecutorService.shutdown();
        paramString = "{\"result\":\"null\"}";
      }
    }
    finally
    {
      localExecutorService.shutdown();
    }
    return new BDLocation(paramString);
  }
  
  public BDLocation a(boolean paramBoolean)
  {
    BDLocation localBDLocation = null;
    if (!this.a) {
      d();
    }
    com.baidu.location.f.a locala = com.baidu.location.f.b.a().f();
    if ((locala != null) && (locala.e())) {}
    for (Object localObject = locala.g();; localObject = null)
    {
      e locale = com.baidu.location.f.f.a().p();
      if (locale != null) {
        localBDLocation = a((String)localObject, locale.a, true);
      }
      if ((localBDLocation != null) && (localBDLocation.getLocType() == 66))
      {
        localObject = new StringBuffer(1024);
        ((StringBuffer)localObject).append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", new Object[] { Double.valueOf(localBDLocation.getLatitude()), Double.valueOf(localBDLocation.getLongitude()), Float.valueOf(localBDLocation.getRadius()) }));
        if ((locale != null) && (locale.a() > 0))
        {
          ((StringBuffer)localObject).append("&wf=");
          ((StringBuffer)localObject).append(locale.c(15));
        }
        if (locala != null) {
          ((StringBuffer)localObject).append(locala.i());
        }
        ((StringBuffer)localObject).append("&uptype=oldoff");
        ((StringBuffer)localObject).append(com.baidu.location.h.g.e(com.baidu.location.f.getServiceContext()));
        ((StringBuffer)localObject).append(com.baidu.location.h.b.a().a(false));
        ((StringBuffer)localObject).append(com.baidu.location.a.a.a().f());
        localObject = ((StringBuffer)localObject).toString();
        com.baidu.location.d.g.a(com.baidu.location.d.g.a, Jni.encode((String)localObject));
      }
      return localBDLocation;
    }
  }
  
  public void a(String paramString, com.baidu.location.f.a parama, e parame, BDLocation paramBDLocation)
  {
    if (!this.a) {
      d();
    }
    if ((!parama.b()) || (!h.c().i())) {}
    for (int i2 = 1;; i2 = 0)
    {
      if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F))) {}
      for (int i1 = 1;; i1 = 0)
      {
        if (parame.a == null) {
          i1 = 1;
        }
        if ((i2 != 0) && (i1 != 0)) {}
        while (this.k) {
          return;
        }
        this.k = true;
        new b(null).execute(new Object[] { paramString, parama, parame, paramBDLocation });
        return;
      }
    }
  }
  
  public void b()
  {
    if (this.n == null) {
      this.n = new Handler();
    }
    this.n.postDelayed(new Runnable()
    {
      public void run()
      {
        if (com.baidu.location.f.isServing)
        {
          if (!a.this.a) {
            a.a(a.this);
          }
          a.b(a.this);
        }
      }
    }, 3000L);
  }
  
  private class a
    extends AsyncTask<Boolean, Void, Boolean>
  {
    private a() {}
    
    protected Boolean a(Boolean... paramVarArgs)
    {
      Object localObject1 = null;
      if (paramVarArgs.length != 4) {
        return Boolean.valueOf(false);
      }
      try
      {
        localObject2 = SQLiteDatabase.openOrCreateDatabase(a.c(), null);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        int i;
        for (;;) {}
      }
      if (localObject1 == null) {
        return Boolean.valueOf(false);
      }
      i = (int)(System.currentTimeMillis() >> 28);
      for (;;)
      {
        try
        {
          ((SQLiteDatabase)localObject1).beginTransaction();
          if (paramVarArgs[0].booleanValue()) {
            localObject2 = "delete from wof where ac < " + (i - 35);
          }
        }
        catch (Exception paramVarArgs)
        {
          continue;
        }
        try
        {
          ((SQLiteDatabase)localObject1).execSQL((String)localObject2);
          if (paramVarArgs[1].booleanValue()) {
            paramVarArgs = "delete from bdcltb09 where ac is NULL or ac < " + (i - 130);
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((SQLiteDatabase)localObject1).execSQL(paramVarArgs);
            ((SQLiteDatabase)localObject1).setTransactionSuccessful();
            ((SQLiteDatabase)localObject1).endTransaction();
            ((SQLiteDatabase)localObject1).close();
            return Boolean.valueOf(true);
            localException1 = localException1;
          }
          catch (Exception paramVarArgs) {}
        }
      }
    }
  }
  
  private class b
    extends AsyncTask<Object, Void, Boolean>
  {
    private b() {}
    
    protected Boolean a(Object... paramVarArgs)
    {
      if (paramVarArgs.length != 4)
      {
        a.b(a.this, false);
        return Boolean.valueOf(false);
      }
      SQLiteDatabase localSQLiteDatabase2;
      try
      {
        SQLiteDatabase localSQLiteDatabase1 = SQLiteDatabase.openOrCreateDatabase(a.c(), null);
        if (localSQLiteDatabase1 == null)
        {
          a.b(a.this, false);
          return Boolean.valueOf(false);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localSQLiteDatabase2 = null;
        }
      }
      try
      {
        localSQLiteDatabase2.beginTransaction();
        a.a(a.this, (String)paramVarArgs[0], (com.baidu.location.f.a)paramVarArgs[1], localSQLiteDatabase2);
        a.a(a.this, (e)paramVarArgs[2], (BDLocation)paramVarArgs[3], localSQLiteDatabase2);
        localSQLiteDatabase2.setTransactionSuccessful();
        localSQLiteDatabase2.endTransaction();
        localSQLiteDatabase2.close();
        a.b(a.this, false);
        return Boolean.valueOf(true);
      }
      catch (Exception paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */