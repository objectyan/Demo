package com.baidu.android.pushservice.d;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;

public class c
{
  private static c a = null;
  private static b b = null;
  private static final Object c = new Object();
  private static int d = 100;
  
  /* Error */
  public static long a(Context paramContext, b paramb)
  {
    // Byte code:
    //   0: ldc2_w 46
    //   3: lstore 4
    //   5: aconst_null
    //   6: astore 8
    //   8: ldc 2
    //   10: monitorenter
    //   11: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   14: astore 10
    //   16: aload 10
    //   18: monitorenter
    //   19: aload_0
    //   20: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 11
    //   25: aload 11
    //   27: ifnonnull +15 -> 42
    //   30: aload 10
    //   32: monitorexit
    //   33: ldc2_w 46
    //   36: lstore_2
    //   37: ldc 2
    //   39: monitorexit
    //   40: lload_2
    //   41: lreturn
    //   42: new 52	android/content/ContentValues
    //   45: dup
    //   46: invokespecial 53	android/content/ContentValues:<init>	()V
    //   49: astore 12
    //   51: aload 12
    //   53: getstatic 56	com/baidu/android/pushservice/d/c$e:b	Lcom/baidu/android/pushservice/d/c$e;
    //   56: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   59: aload_1
    //   60: getfield 65	com/baidu/android/pushservice/d/b:a	J
    //   63: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: invokevirtual 75	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   69: aload 12
    //   71: getstatic 77	com/baidu/android/pushservice/d/c$e:c	Lcom/baidu/android/pushservice/d/c$e;
    //   74: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   77: aload_1
    //   78: getfield 79	com/baidu/android/pushservice/d/b:b	J
    //   81: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: invokevirtual 75	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   87: aload 12
    //   89: getstatic 81	com/baidu/android/pushservice/d/c$e:d	Lcom/baidu/android/pushservice/d/c$e;
    //   92: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   95: aload_1
    //   96: getfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   99: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 12
    //   104: getstatic 89	com/baidu/android/pushservice/d/c$e:e	Lcom/baidu/android/pushservice/d/c$e;
    //   107: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   110: aload_1
    //   111: getfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   114: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 12
    //   119: getstatic 94	com/baidu/android/pushservice/d/c$e:g	Lcom/baidu/android/pushservice/d/c$e;
    //   122: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   125: aload_1
    //   126: getfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   129: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload 12
    //   134: getstatic 98	com/baidu/android/pushservice/d/c$e:f	Lcom/baidu/android/pushservice/d/c$e;
    //   137: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   140: aload_1
    //   141: getfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   144: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 12
    //   149: getstatic 103	com/baidu/android/pushservice/d/c$e:h	Lcom/baidu/android/pushservice/d/c$e;
    //   152: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   155: aload_1
    //   156: getfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   159: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 12
    //   164: getstatic 108	com/baidu/android/pushservice/d/c$e:i	Lcom/baidu/android/pushservice/d/c$e;
    //   167: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   170: aload_1
    //   171: getfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   174: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 12
    //   179: getstatic 113	com/baidu/android/pushservice/d/c$e:j	Lcom/baidu/android/pushservice/d/c$e;
    //   182: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   185: aload_1
    //   186: getfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   189: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload 11
    //   194: ldc 117
    //   196: aconst_null
    //   197: aconst_null
    //   198: aconst_null
    //   199: aconst_null
    //   200: aconst_null
    //   201: aconst_null
    //   202: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   205: astore 9
    //   207: aload 9
    //   209: astore 8
    //   211: aload 8
    //   213: ifnull +154 -> 367
    //   216: lload 4
    //   218: lstore_2
    //   219: aload 8
    //   221: invokeinterface 129 1 0
    //   226: ifeq +141 -> 367
    //   229: lload 4
    //   231: lstore_2
    //   232: aload 11
    //   234: ldc 117
    //   236: aload 12
    //   238: new 131	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   245: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   248: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   251: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc -116
    //   256: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aconst_null
    //   263: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   266: i2l
    //   267: lstore 4
    //   269: lload 4
    //   271: lstore_2
    //   272: ldc -107
    //   274: aload_0
    //   275: invokestatic 154	com/baidu/android/pushservice/j/p:b	(Ljava/lang/String;Landroid/content/Context;)V
    //   278: lload 4
    //   280: lstore_2
    //   281: new 131	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   288: ldc -100
    //   290: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokevirtual 159	com/baidu/android/pushservice/d/b:a	()Lorg/json/JSONObject;
    //   297: invokevirtual 162	org/json/JSONObject:toString	()Ljava/lang/String;
    //   300: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_0
    //   307: invokestatic 154	com/baidu/android/pushservice/j/p:b	(Ljava/lang/String;Landroid/content/Context;)V
    //   310: aload 8
    //   312: ifnull +20 -> 332
    //   315: aload 8
    //   317: invokeinterface 166 1 0
    //   322: ifne +10 -> 332
    //   325: aload 8
    //   327: invokeinterface 169 1 0
    //   332: lload 4
    //   334: lstore 6
    //   336: aload 11
    //   338: ifnull +143 -> 481
    //   341: aload 11
    //   343: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   346: lload 4
    //   348: lstore_2
    //   349: aload 10
    //   351: monitorexit
    //   352: goto -315 -> 37
    //   355: astore_0
    //   356: aload 10
    //   358: monitorexit
    //   359: aload_0
    //   360: athrow
    //   361: astore_0
    //   362: ldc 2
    //   364: monitorexit
    //   365: aload_0
    //   366: athrow
    //   367: lload 4
    //   369: lstore_2
    //   370: aload 11
    //   372: ldc 117
    //   374: aconst_null
    //   375: aload 12
    //   377: invokevirtual 174	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   380: lstore 4
    //   382: lload 4
    //   384: lstore_2
    //   385: ldc -80
    //   387: aload_0
    //   388: invokestatic 154	com/baidu/android/pushservice/j/p:b	(Ljava/lang/String;Landroid/content/Context;)V
    //   391: goto -113 -> 278
    //   394: astore_0
    //   395: aload 8
    //   397: ifnull +20 -> 417
    //   400: aload 8
    //   402: invokeinterface 166 1 0
    //   407: ifne +10 -> 417
    //   410: aload 8
    //   412: invokeinterface 169 1 0
    //   417: lload_2
    //   418: lstore 6
    //   420: aload 11
    //   422: ifnull +59 -> 481
    //   425: aload 11
    //   427: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   430: goto -81 -> 349
    //   433: aload 8
    //   435: ifnull +20 -> 455
    //   438: aload 8
    //   440: invokeinterface 166 1 0
    //   445: ifne +10 -> 455
    //   448: aload 8
    //   450: invokeinterface 169 1 0
    //   455: aload 11
    //   457: ifnull +8 -> 465
    //   460: aload 11
    //   462: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   465: aload_0
    //   466: athrow
    //   467: astore_0
    //   468: goto -35 -> 433
    //   471: astore_0
    //   472: aconst_null
    //   473: astore 8
    //   475: lload 4
    //   477: lstore_2
    //   478: goto -83 -> 395
    //   481: lload 6
    //   483: lstore_2
    //   484: goto -135 -> 349
    //   487: astore_0
    //   488: goto -55 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	paramContext	Context
    //   0	491	1	paramb	b
    //   36	448	2	l1	long
    //   3	473	4	l2	long
    //   334	148	6	l3	long
    //   6	468	8	localObject1	Object
    //   205	3	9	localCursor	android.database.Cursor
    //   14	343	10	localObject2	Object
    //   23	438	11	localSQLiteDatabase	SQLiteDatabase
    //   49	327	12	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   19	25	355	finally
    //   30	33	355	finally
    //   42	192	355	finally
    //   315	332	355	finally
    //   341	346	355	finally
    //   349	352	355	finally
    //   356	359	355	finally
    //   400	417	355	finally
    //   425	430	355	finally
    //   438	455	355	finally
    //   460	465	355	finally
    //   465	467	355	finally
    //   11	19	361	finally
    //   359	361	361	finally
    //   219	229	394	java/lang/Exception
    //   232	269	394	java/lang/Exception
    //   272	278	394	java/lang/Exception
    //   281	310	394	java/lang/Exception
    //   370	382	394	java/lang/Exception
    //   385	391	394	java/lang/Exception
    //   219	229	467	finally
    //   232	269	467	finally
    //   272	278	467	finally
    //   281	310	467	finally
    //   370	382	467	finally
    //   385	391	467	finally
    //   192	207	471	java/lang/Exception
    //   192	207	487	finally
  }
  
  public static SQLiteDatabase a(Context paramContext)
  {
    Object localObject = i(paramContext);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((c)localObject).getWritableDatabase();
      return (SQLiteDatabase)localObject;
    }
    catch (Throwable localThrowable)
    {
      q.a(paramContext, localThrowable);
    }
    return null;
  }
  
  public static Object a()
  {
    return c;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 196	com/baidu/android/pushservice/j/p:m	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: bipush 52
    //   12: if_icmplt +206 -> 218
    //   15: aload_0
    //   16: invokevirtual 202	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +197 -> 218
    //   24: new 131	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   31: ldc -52
    //   33: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc -50
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc -48
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc -46
    //   52: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 216	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   61: astore_1
    //   62: getstatic 219	com/baidu/android/pushservice/d/c$f:c	Lcom/baidu/android/pushservice/d/c$f;
    //   65: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   68: astore 4
    //   70: new 131	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   77: getstatic 222	com/baidu/android/pushservice/d/c$f:b	Lcom/baidu/android/pushservice/d/c$f;
    //   80: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   83: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc -32
    //   88: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 5
    //   96: aload_0
    //   97: aload_1
    //   98: iconst_1
    //   99: anewarray 226	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: aload 4
    //   106: aastore
    //   107: aload 5
    //   109: iconst_1
    //   110: anewarray 226	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 231	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +88 -> 211
    //   126: aload_0
    //   127: invokeinterface 234 1 0
    //   132: ifeq +79 -> 211
    //   135: aload_0
    //   136: iconst_0
    //   137: invokeinterface 238 2 0
    //   142: astore_2
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: astore_0
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 169 1 0
    //   157: aload_0
    //   158: areturn
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +9 -> 172
    //   166: aload_0
    //   167: invokeinterface 169 1 0
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aload_3
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +9 -> 190
    //   184: aload_1
    //   185: invokeinterface 169 1 0
    //   190: aload_0
    //   191: athrow
    //   192: astore_1
    //   193: aload_0
    //   194: areturn
    //   195: astore_1
    //   196: goto -6 -> 190
    //   199: astore_2
    //   200: aload_0
    //   201: astore_1
    //   202: aload_2
    //   203: astore_0
    //   204: goto -24 -> 180
    //   207: astore_1
    //   208: goto -46 -> 162
    //   211: aload_0
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: goto -68 -> 147
    //   218: aconst_null
    //   219: astore_0
    //   220: aload 4
    //   222: astore_1
    //   223: goto -76 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramContext	Context
    //   0	226	1	paramString1	String
    //   0	226	2	paramString2	String
    //   1	178	3	localObject	Object
    //   3	218	4	str1	String
    //   94	14	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	20	159	java/lang/Throwable
    //   24	122	159	java/lang/Throwable
    //   166	172	174	java/lang/Exception
    //   5	20	177	finally
    //   24	122	177	finally
    //   151	157	192	java/lang/Exception
    //   184	190	195	java/lang/Exception
    //   126	143	199	finally
    //   126	143	207	java/lang/Throwable
  }
  
  /* Error */
  public static void a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 5
    //   10: aload 5
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +10 -> 31
    //   24: aload 5
    //   26: monitorexit
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload 6
    //   33: ldc 117
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +115 -> 165
    //   53: aload_3
    //   54: invokeinterface 129 1 0
    //   59: ifeq +106 -> 165
    //   62: new 52	android/content/ContentValues
    //   65: dup
    //   66: invokespecial 53	android/content/ContentValues:<init>	()V
    //   69: astore_0
    //   70: aload_0
    //   71: getstatic 56	com/baidu/android/pushservice/d/c$e:b	Lcom/baidu/android/pushservice/d/c$e;
    //   74: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   77: lload_1
    //   78: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: invokevirtual 75	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   84: aload 6
    //   86: ldc 117
    //   88: aload_0
    //   89: new 131	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   96: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   99: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   102: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc -116
    //   107: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: aconst_null
    //   114: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload_3
    //   119: ifnull +18 -> 137
    //   122: aload_3
    //   123: invokeinterface 166 1 0
    //   128: ifne +9 -> 137
    //   131: aload_3
    //   132: invokeinterface 169 1 0
    //   137: aload 6
    //   139: ifnull +8 -> 147
    //   142: aload 6
    //   144: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   147: aload 5
    //   149: monitorexit
    //   150: goto -123 -> 27
    //   153: astore_0
    //   154: aload 5
    //   156: monitorexit
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    //   165: new 62	com/baidu/android/pushservice/d/b
    //   168: dup
    //   169: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   172: astore 4
    //   174: aload 4
    //   176: lload_1
    //   177: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   180: aload 4
    //   182: lconst_0
    //   183: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   186: aload 4
    //   188: aconst_null
    //   189: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   192: aload 4
    //   194: aconst_null
    //   195: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   198: aload 4
    //   200: aconst_null
    //   201: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   204: aload 4
    //   206: aconst_null
    //   207: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   210: aload 4
    //   212: aconst_null
    //   213: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   216: aload 4
    //   218: aconst_null
    //   219: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   222: aload 4
    //   224: aconst_null
    //   225: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   228: aload_0
    //   229: aload 4
    //   231: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   234: pop2
    //   235: goto -117 -> 118
    //   238: astore_0
    //   239: aload_3
    //   240: ifnull +18 -> 258
    //   243: aload_3
    //   244: invokeinterface 166 1 0
    //   249: ifne +9 -> 258
    //   252: aload_3
    //   253: invokeinterface 169 1 0
    //   258: aload 6
    //   260: ifnull -113 -> 147
    //   263: aload 6
    //   265: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   268: goto -121 -> 147
    //   271: aload_3
    //   272: ifnull +18 -> 290
    //   275: aload_3
    //   276: invokeinterface 166 1 0
    //   281: ifne +9 -> 290
    //   284: aload_3
    //   285: invokeinterface 169 1 0
    //   290: aload 6
    //   292: ifnull +8 -> 300
    //   295: aload 6
    //   297: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: astore_0
    //   303: goto -32 -> 271
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_3
    //   309: goto -70 -> 239
    //   312: astore_0
    //   313: goto -42 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramContext	Context
    //   0	316	1	paramLong	long
    //   1	308	3	localObject1	Object
    //   44	186	4	localObject2	Object
    //   8	147	5	localObject3	Object
    //   17	279	6	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	153	finally
    //   24	27	153	finally
    //   122	137	153	finally
    //   142	147	153	finally
    //   147	150	153	finally
    //   154	157	153	finally
    //   243	258	153	finally
    //   263	268	153	finally
    //   275	290	153	finally
    //   295	300	153	finally
    //   300	302	153	finally
    //   5	13	159	finally
    //   157	159	159	finally
    //   53	118	238	java/lang/Exception
    //   165	235	238	java/lang/Exception
    //   53	118	302	finally
    //   165	235	302	finally
    //   31	46	306	java/lang/Exception
    //   31	46	312	finally
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +10 -> 31
    //   24: aload 4
    //   26: monitorexit
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload 5
    //   33: ldc 117
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +112 -> 160
    //   51: aload_2
    //   52: invokeinterface 129 1 0
    //   57: ifeq +103 -> 160
    //   60: new 52	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 53	android/content/ContentValues:<init>	()V
    //   67: astore_0
    //   68: aload_0
    //   69: getstatic 81	com/baidu/android/pushservice/d/c$e:d	Lcom/baidu/android/pushservice/d/c$e;
    //   72: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   75: aload_1
    //   76: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 5
    //   81: ldc 117
    //   83: aload_0
    //   84: new 131	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   91: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   94: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   97: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc -116
    //   102: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aconst_null
    //   109: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   112: pop
    //   113: aload_2
    //   114: ifnull +18 -> 132
    //   117: aload_2
    //   118: invokeinterface 166 1 0
    //   123: ifne +9 -> 132
    //   126: aload_2
    //   127: invokeinterface 169 1 0
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   142: aload 4
    //   144: monitorexit
    //   145: goto -118 -> 27
    //   148: astore_0
    //   149: aload 4
    //   151: monitorexit
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: ldc 2
    //   157: monitorexit
    //   158: aload_0
    //   159: athrow
    //   160: new 62	com/baidu/android/pushservice/d/b
    //   163: dup
    //   164: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   167: astore_3
    //   168: aload_3
    //   169: lconst_0
    //   170: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   173: aload_3
    //   174: lconst_0
    //   175: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   178: aload_3
    //   179: aload_1
    //   180: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   183: aload_3
    //   184: aconst_null
    //   185: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   188: aload_3
    //   189: aconst_null
    //   190: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   193: aload_3
    //   194: aconst_null
    //   195: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   198: aload_3
    //   199: aconst_null
    //   200: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   203: aload_3
    //   204: aconst_null
    //   205: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   208: aload_3
    //   209: aconst_null
    //   210: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   213: aload_0
    //   214: aload_3
    //   215: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   218: pop2
    //   219: goto -106 -> 113
    //   222: astore_0
    //   223: aload_2
    //   224: ifnull +18 -> 242
    //   227: aload_2
    //   228: invokeinterface 166 1 0
    //   233: ifne +9 -> 242
    //   236: aload_2
    //   237: invokeinterface 169 1 0
    //   242: aload 5
    //   244: ifnull -102 -> 142
    //   247: aload 5
    //   249: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   252: goto -110 -> 142
    //   255: aload_2
    //   256: ifnull +18 -> 274
    //   259: aload_2
    //   260: invokeinterface 166 1 0
    //   265: ifne +9 -> 274
    //   268: aload_2
    //   269: invokeinterface 169 1 0
    //   274: aload 5
    //   276: ifnull +8 -> 284
    //   279: aload 5
    //   281: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: goto -32 -> 255
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_2
    //   293: goto -70 -> 223
    //   296: astore_0
    //   297: goto -42 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramContext	Context
    //   0	300	1	paramString	String
    //   1	292	2	localObject1	Object
    //   44	171	3	localObject2	Object
    //   8	142	4	localObject3	Object
    //   17	263	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	148	finally
    //   24	27	148	finally
    //   117	132	148	finally
    //   137	142	148	finally
    //   142	145	148	finally
    //   149	152	148	finally
    //   227	242	148	finally
    //   247	252	148	finally
    //   259	274	148	finally
    //   279	284	148	finally
    //   284	286	148	finally
    //   5	13	154	finally
    //   152	154	154	finally
    //   51	113	222	java/lang/Exception
    //   160	219	222	java/lang/Exception
    //   51	113	286	finally
    //   160	219	286	finally
    //   31	45	290	java/lang/Exception
    //   31	45	296	finally
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, long paramLong1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong2, int paramInt2)
  {
    synchronized (c)
    {
      localSQLiteDatabase = a(paramContext);
      if (localSQLiteDatabase == null) {
        return;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put(d.b.name(), paramString);
        localContentValues.put(d.d.name(), Long.valueOf(paramLong1));
        localContentValues.put(d.c.name(), Integer.valueOf(paramInt1));
        if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
        {
          paramContext = BaiduAppSSOJni.getEncrypted(paramContext, paramString, paramArrayOfByte1);
          localContentValues.put(d.g.name(), paramContext);
          localContentValues.put(d.f.name(), paramArrayOfByte2);
          localContentValues.put(d.h.name(), Long.valueOf(paramLong2));
        }
        localContentValues.put(d.e.name(), Long.valueOf(System.currentTimeMillis()));
        localContentValues.put(d.i.name(), Integer.valueOf(paramInt2));
        localSQLiteDatabase.insert("PushMsgInfos", null, localContentValues);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          localSQLiteDatabase.close();
        }
      }
      finally
      {
        localSQLiteDatabase.close();
      }
      return;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, java.util.List<com.baidu.android.pushservice.h.h> paramList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +9 -> 24
    //   18: aload_2
    //   19: monitorexit
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: invokevirtual 291	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   28: aload_0
    //   29: ldc_w 293
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 297	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   37: pop
    //   38: aload_1
    //   39: invokeinterface 303 1 0
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 308 1 0
    //   51: ifeq +160 -> 211
    //   54: aload_1
    //   55: invokeinterface 311 1 0
    //   60: checkcast 313	com/baidu/android/pushservice/h/h
    //   63: astore_3
    //   64: new 52	android/content/ContentValues
    //   67: dup
    //   68: invokespecial 53	android/content/ContentValues:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: getstatic 316	com/baidu/android/pushservice/d/c$a:b	Lcom/baidu/android/pushservice/d/c$a;
    //   78: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   81: aload_3
    //   82: getfield 318	com/baidu/android/pushservice/h/h:d	Ljava/lang/String;
    //   85: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 4
    //   90: getstatic 320	com/baidu/android/pushservice/d/c$a:e	Lcom/baidu/android/pushservice/d/c$a;
    //   93: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   96: aload_3
    //   97: getfield 322	com/baidu/android/pushservice/h/h:j	Ljava/lang/String;
    //   100: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 4
    //   105: getstatic 324	com/baidu/android/pushservice/d/c$a:c	Lcom/baidu/android/pushservice/d/c$a;
    //   108: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   111: aload_3
    //   112: getfield 326	com/baidu/android/pushservice/h/h:e	J
    //   115: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: invokevirtual 75	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   121: aload 4
    //   123: getstatic 328	com/baidu/android/pushservice/d/c$a:f	Lcom/baidu/android/pushservice/d/c$a;
    //   126: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   129: aload_3
    //   130: getfield 330	com/baidu/android/pushservice/h/h:b	I
    //   133: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: invokevirtual 260	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   139: aload 4
    //   141: getstatic 332	com/baidu/android/pushservice/d/c$a:g	Lcom/baidu/android/pushservice/d/c$a;
    //   144: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   147: aload_3
    //   148: getfield 334	com/baidu/android/pushservice/h/h:a	Ljava/lang/String;
    //   151: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload 4
    //   156: getstatic 336	com/baidu/android/pushservice/d/c$a:h	Lcom/baidu/android/pushservice/d/c$a;
    //   159: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   162: aload_3
    //   163: getfield 338	com/baidu/android/pushservice/h/h:c	I
    //   166: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: invokevirtual 260	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   172: aload_0
    //   173: ldc_w 293
    //   176: aconst_null
    //   177: aload 4
    //   179: invokevirtual 174	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   182: pop2
    //   183: goto -138 -> 45
    //   186: astore_1
    //   187: aload_0
    //   188: invokevirtual 341	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   191: aload_0
    //   192: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   195: aload_2
    //   196: monitorexit
    //   197: goto -177 -> 20
    //   200: astore_0
    //   201: aload_2
    //   202: monitorexit
    //   203: aload_0
    //   204: athrow
    //   205: astore_0
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload_0
    //   210: athrow
    //   211: aload_0
    //   212: invokevirtual 344	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   215: aload_0
    //   216: invokevirtual 341	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   219: aload_0
    //   220: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   223: goto -28 -> 195
    //   226: astore_1
    //   227: aload_0
    //   228: invokevirtual 341	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   231: aload_0
    //   232: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramContext	Context
    //   0	237	1	paramList	java.util.List<com.baidu.android.pushservice.h.h>
    //   63	100	3	localh	com.baidu.android.pushservice.h.h
    //   71	107	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   24	45	186	java/lang/Exception
    //   45	183	186	java/lang/Exception
    //   211	215	186	java/lang/Exception
    //   9	14	200	finally
    //   18	20	200	finally
    //   187	195	200	finally
    //   195	197	200	finally
    //   201	203	200	finally
    //   215	223	200	finally
    //   227	237	200	finally
    //   3	9	205	finally
    //   203	205	205	finally
    //   24	45	226	finally
    //   45	183	226	finally
    //   211	215	226	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   6: astore 8
    //   8: aload 8
    //   10: monitorenter
    //   11: aload_0
    //   12: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 9
    //   17: aload 9
    //   19: ifnonnull +13 -> 32
    //   22: iconst_0
    //   23: istore_2
    //   24: aload 8
    //   26: monitorexit
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: new 52	android/content/ContentValues
    //   35: dup
    //   36: invokespecial 53	android/content/ContentValues:<init>	()V
    //   39: astore 10
    //   41: aload 10
    //   43: getstatic 222	com/baidu/android/pushservice/d/c$f:b	Lcom/baidu/android/pushservice/d/c$f;
    //   46: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   49: aload_1
    //   50: getfield 350	com/baidu/android/pushservice/d/e:a	Ljava/lang/String;
    //   53: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 10
    //   58: getstatic 219	com/baidu/android/pushservice/d/c$f:c	Lcom/baidu/android/pushservice/d/c$f;
    //   61: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   64: aload_1
    //   65: getfield 352	com/baidu/android/pushservice/d/e:b	Ljava/lang/String;
    //   68: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 10
    //   73: getstatic 354	com/baidu/android/pushservice/d/c$f:d	Lcom/baidu/android/pushservice/d/c$f;
    //   76: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   79: aload_1
    //   80: getfield 355	com/baidu/android/pushservice/d/e:d	Ljava/lang/String;
    //   83: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 10
    //   88: getstatic 357	com/baidu/android/pushservice/d/c$f:e	Lcom/baidu/android/pushservice/d/c$f;
    //   91: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   94: new 131	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   101: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   104: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: ldc_w 362
    //   110: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc2_w 46
    //   122: lstore_3
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: astore 7
    //   128: aload 9
    //   130: ldc_w 364
    //   133: aconst_null
    //   134: aload 10
    //   136: invokevirtual 174	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   139: lstore 5
    //   141: aload_0
    //   142: astore 7
    //   144: lload 5
    //   146: lstore_3
    //   147: aload 9
    //   149: ldc_w 366
    //   152: aconst_null
    //   153: invokevirtual 370	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   156: astore_0
    //   157: aload_0
    //   158: astore 7
    //   160: lload 5
    //   162: lstore_3
    //   163: aload_0
    //   164: invokeinterface 234 1 0
    //   169: pop
    //   170: aload_0
    //   171: astore 7
    //   173: lload 5
    //   175: lstore_3
    //   176: aload_0
    //   177: iconst_0
    //   178: invokeinterface 374 2 0
    //   183: getstatic 41	com/baidu/android/pushservice/d/c:d	I
    //   186: if_icmple +32 -> 218
    //   189: aload_0
    //   190: astore 7
    //   192: lload 5
    //   194: lstore_3
    //   195: aload 9
    //   197: ldc_w 364
    //   200: ldc_w 376
    //   203: iconst_1
    //   204: anewarray 226	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: aload_1
    //   210: getfield 350	com/baidu/android/pushservice/d/e:a	Ljava/lang/String;
    //   213: aastore
    //   214: invokevirtual 297	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   217: pop
    //   218: aload_0
    //   219: ifnull +18 -> 237
    //   222: aload_0
    //   223: invokeinterface 166 1 0
    //   228: ifne +9 -> 237
    //   231: aload_0
    //   232: invokeinterface 169 1 0
    //   237: aload 9
    //   239: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   242: lload 5
    //   244: lstore_3
    //   245: goto +93 -> 338
    //   248: aload 8
    //   250: monitorexit
    //   251: goto -224 -> 27
    //   254: astore_0
    //   255: aload 8
    //   257: monitorexit
    //   258: aload_0
    //   259: athrow
    //   260: astore_0
    //   261: ldc 2
    //   263: monitorexit
    //   264: aload_0
    //   265: athrow
    //   266: astore_0
    //   267: aload 7
    //   269: ifnull +20 -> 289
    //   272: aload 7
    //   274: invokeinterface 166 1 0
    //   279: ifne +10 -> 289
    //   282: aload 7
    //   284: invokeinterface 169 1 0
    //   289: aload 9
    //   291: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   294: goto +44 -> 338
    //   297: aload_1
    //   298: ifnull +18 -> 316
    //   301: aload_1
    //   302: invokeinterface 166 1 0
    //   307: ifne +9 -> 316
    //   310: aload_1
    //   311: invokeinterface 169 1 0
    //   316: aload 9
    //   318: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   321: aload_0
    //   322: athrow
    //   323: iconst_0
    //   324: istore_2
    //   325: goto -77 -> 248
    //   328: astore 7
    //   330: aload_0
    //   331: astore_1
    //   332: aload 7
    //   334: astore_0
    //   335: goto -38 -> 297
    //   338: lload_3
    //   339: ldc2_w 46
    //   342: lcmp
    //   343: ifeq -20 -> 323
    //   346: iconst_1
    //   347: istore_2
    //   348: goto -100 -> 248
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_1
    //   354: goto -57 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramContext	Context
    //   0	357	1	parame	e
    //   23	325	2	bool	boolean
    //   122	217	3	l1	long
    //   139	104	5	l2	long
    //   126	157	7	localContext	Context
    //   328	5	7	localObject1	Object
    //   6	250	8	localObject2	Object
    //   15	302	9	localSQLiteDatabase	SQLiteDatabase
    //   39	96	10	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	17	254	finally
    //   24	27	254	finally
    //   32	119	254	finally
    //   222	237	254	finally
    //   237	242	254	finally
    //   248	251	254	finally
    //   255	258	254	finally
    //   272	289	254	finally
    //   289	294	254	finally
    //   301	316	254	finally
    //   316	323	254	finally
    //   3	11	260	finally
    //   258	260	260	finally
    //   128	141	266	java/lang/Exception
    //   147	157	266	java/lang/Exception
    //   163	170	266	java/lang/Exception
    //   176	189	266	java/lang/Exception
    //   195	218	266	java/lang/Exception
    //   163	170	328	finally
    //   176	189	328	finally
    //   195	218	328	finally
    //   128	141	351	finally
    //   147	157	351	finally
  }
  
  /* Error */
  public static int b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aconst_null
    //   5: astore_3
    //   6: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnonnull +8 -> 30
    //   25: aload 5
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: aload 6
    //   32: ldc 117
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_0
    //   44: aload_0
    //   45: invokeinterface 234 1 0
    //   50: ifeq +22 -> 72
    //   53: aload_0
    //   54: aload_0
    //   55: getstatic 56	com/baidu/android/pushservice/d/c$e:b	Lcom/baidu/android/pushservice/d/c$e;
    //   58: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   61: invokeinterface 381 2 0
    //   66: invokeinterface 374 2 0
    //   71: istore_1
    //   72: aload_0
    //   73: ifnull +18 -> 91
    //   76: aload_0
    //   77: invokeinterface 166 1 0
    //   82: ifne +9 -> 91
    //   85: aload_0
    //   86: invokeinterface 169 1 0
    //   91: iload_1
    //   92: istore_2
    //   93: aload 6
    //   95: ifnull +101 -> 196
    //   98: aload 6
    //   100: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   103: aload 5
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: astore_0
    //   109: aload 5
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +18 -> 136
    //   121: aload_0
    //   122: invokeinterface 166 1 0
    //   127: ifne +9 -> 136
    //   130: aload_0
    //   131: invokeinterface 169 1 0
    //   136: aload 6
    //   138: ifnull +58 -> 196
    //   141: aload 6
    //   143: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: iconst_0
    //   147: istore_1
    //   148: goto -45 -> 103
    //   151: aload_3
    //   152: ifnull +18 -> 170
    //   155: aload_3
    //   156: invokeinterface 166 1 0
    //   161: ifne +9 -> 170
    //   164: aload_3
    //   165: invokeinterface 169 1 0
    //   170: aload 6
    //   172: ifnull +8 -> 180
    //   175: aload 6
    //   177: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   180: aload_0
    //   181: athrow
    //   182: astore 4
    //   184: aload_0
    //   185: astore_3
    //   186: aload 4
    //   188: astore_0
    //   189: goto -38 -> 151
    //   192: astore_3
    //   193: goto -76 -> 117
    //   196: iload_2
    //   197: istore_1
    //   198: goto -95 -> 103
    //   201: astore_0
    //   202: goto -51 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramContext	Context
    //   3	195	1	i	int
    //   1	196	2	j	int
    //   5	181	3	localContext	Context
    //   192	1	3	localException	Exception
    //   182	5	4	localObject1	Object
    //   9	101	5	localObject2	Object
    //   18	158	6	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	20	108	finally
    //   25	28	108	finally
    //   76	91	108	finally
    //   98	103	108	finally
    //   103	106	108	finally
    //   109	112	108	finally
    //   121	136	108	finally
    //   141	146	108	finally
    //   155	170	108	finally
    //   175	180	108	finally
    //   180	182	108	finally
    //   30	44	114	java/lang/Exception
    //   44	72	182	finally
    //   44	72	192	java/lang/Exception
    //   30	44	201	finally
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 196	com/baidu/android/pushservice/j/p:m	(Landroid/content/Context;Ljava/lang/String;)I
    //   10: bipush 52
    //   12: if_icmplt +206 -> 218
    //   15: aload_0
    //   16: invokevirtual 202	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnull +197 -> 218
    //   24: new 131	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   31: ldc -52
    //   33: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc -50
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc -48
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc -46
    //   52: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 216	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   61: astore_1
    //   62: getstatic 219	com/baidu/android/pushservice/d/c$f:c	Lcom/baidu/android/pushservice/d/c$f;
    //   65: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   68: astore 4
    //   70: new 131	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   77: getstatic 219	com/baidu/android/pushservice/d/c$f:c	Lcom/baidu/android/pushservice/d/c$f;
    //   80: invokevirtual 220	com/baidu/android/pushservice/d/c$f:name	()Ljava/lang/String;
    //   83: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc -32
    //   88: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 5
    //   96: aload_0
    //   97: aload_1
    //   98: iconst_1
    //   99: anewarray 226	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: aload 4
    //   106: aastore
    //   107: aload 5
    //   109: iconst_1
    //   110: anewarray 226	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 231	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +88 -> 211
    //   126: aload_0
    //   127: invokeinterface 234 1 0
    //   132: ifeq +79 -> 211
    //   135: aload_0
    //   136: iconst_0
    //   137: invokeinterface 238 2 0
    //   142: astore_2
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: astore_0
    //   147: aload_1
    //   148: ifnull +9 -> 157
    //   151: aload_1
    //   152: invokeinterface 169 1 0
    //   157: aload_0
    //   158: areturn
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +9 -> 172
    //   166: aload_0
    //   167: invokeinterface 169 1 0
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aload_3
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +9 -> 190
    //   184: aload_1
    //   185: invokeinterface 169 1 0
    //   190: aload_0
    //   191: athrow
    //   192: astore_1
    //   193: aload_0
    //   194: areturn
    //   195: astore_1
    //   196: goto -6 -> 190
    //   199: astore_2
    //   200: aload_0
    //   201: astore_1
    //   202: aload_2
    //   203: astore_0
    //   204: goto -24 -> 180
    //   207: astore_1
    //   208: goto -46 -> 162
    //   211: aload_0
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: goto -68 -> 147
    //   218: aconst_null
    //   219: astore_0
    //   220: aload 4
    //   222: astore_1
    //   223: goto -76 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramContext	Context
    //   0	226	1	paramString1	String
    //   0	226	2	paramString2	String
    //   1	178	3	localObject	Object
    //   3	218	4	str1	String
    //   94	14	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	20	159	java/lang/Throwable
    //   24	122	159	java/lang/Throwable
    //   166	172	174	java/lang/Exception
    //   5	20	177	finally
    //   24	122	177	finally
    //   151	157	192	java/lang/Exception
    //   184	190	195	java/lang/Exception
    //   126	143	199	finally
    //   126	143	207	java/lang/Throwable
  }
  
  /* Error */
  public static void b(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 5
    //   10: aload 5
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 6
    //   19: aload 6
    //   21: ifnonnull +10 -> 31
    //   24: aload 5
    //   26: monitorexit
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload 6
    //   33: ldc 117
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +115 -> 165
    //   53: aload_3
    //   54: invokeinterface 129 1 0
    //   59: ifeq +106 -> 165
    //   62: new 52	android/content/ContentValues
    //   65: dup
    //   66: invokespecial 53	android/content/ContentValues:<init>	()V
    //   69: astore_0
    //   70: aload_0
    //   71: getstatic 77	com/baidu/android/pushservice/d/c$e:c	Lcom/baidu/android/pushservice/d/c$e;
    //   74: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   77: lload_1
    //   78: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: invokevirtual 75	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   84: aload 6
    //   86: ldc 117
    //   88: aload_0
    //   89: new 131	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   96: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   99: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   102: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc -116
    //   107: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: aconst_null
    //   114: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload_3
    //   119: ifnull +18 -> 137
    //   122: aload_3
    //   123: invokeinterface 166 1 0
    //   128: ifne +9 -> 137
    //   131: aload_3
    //   132: invokeinterface 169 1 0
    //   137: aload 6
    //   139: ifnull +8 -> 147
    //   142: aload 6
    //   144: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   147: aload 5
    //   149: monitorexit
    //   150: goto -123 -> 27
    //   153: astore_0
    //   154: aload 5
    //   156: monitorexit
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    //   165: new 62	com/baidu/android/pushservice/d/b
    //   168: dup
    //   169: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   172: astore 4
    //   174: aload 4
    //   176: lconst_0
    //   177: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   180: aload 4
    //   182: lload_1
    //   183: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   186: aload 4
    //   188: aconst_null
    //   189: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   192: aload 4
    //   194: aconst_null
    //   195: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   198: aload 4
    //   200: aconst_null
    //   201: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   204: aload 4
    //   206: aconst_null
    //   207: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   210: aload 4
    //   212: aconst_null
    //   213: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   216: aload 4
    //   218: aconst_null
    //   219: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   222: aload 4
    //   224: aconst_null
    //   225: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   228: aload_0
    //   229: aload 4
    //   231: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   234: pop2
    //   235: goto -117 -> 118
    //   238: astore_0
    //   239: aload_3
    //   240: ifnull +18 -> 258
    //   243: aload_3
    //   244: invokeinterface 166 1 0
    //   249: ifne +9 -> 258
    //   252: aload_3
    //   253: invokeinterface 169 1 0
    //   258: aload 6
    //   260: ifnull -113 -> 147
    //   263: aload 6
    //   265: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   268: goto -121 -> 147
    //   271: aload_3
    //   272: ifnull +18 -> 290
    //   275: aload_3
    //   276: invokeinterface 166 1 0
    //   281: ifne +9 -> 290
    //   284: aload_3
    //   285: invokeinterface 169 1 0
    //   290: aload 6
    //   292: ifnull +8 -> 300
    //   295: aload 6
    //   297: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: astore_0
    //   303: goto -32 -> 271
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_3
    //   309: goto -70 -> 239
    //   312: astore_0
    //   313: goto -42 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramContext	Context
    //   0	316	1	paramLong	long
    //   1	308	3	localObject1	Object
    //   44	186	4	localObject2	Object
    //   8	147	5	localObject3	Object
    //   17	279	6	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	153	finally
    //   24	27	153	finally
    //   122	137	153	finally
    //   142	147	153	finally
    //   147	150	153	finally
    //   154	157	153	finally
    //   243	258	153	finally
    //   263	268	153	finally
    //   275	290	153	finally
    //   295	300	153	finally
    //   300	302	153	finally
    //   5	13	159	finally
    //   157	159	159	finally
    //   53	118	238	java/lang/Exception
    //   165	235	238	java/lang/Exception
    //   53	118	302	finally
    //   165	235	302	finally
    //   31	46	306	java/lang/Exception
    //   31	46	312	finally
  }
  
  /* Error */
  public static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +10 -> 31
    //   24: aload 4
    //   26: monitorexit
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload 5
    //   33: ldc 117
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +112 -> 160
    //   51: aload_2
    //   52: invokeinterface 129 1 0
    //   57: ifeq +103 -> 160
    //   60: new 52	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 53	android/content/ContentValues:<init>	()V
    //   67: astore_0
    //   68: aload_0
    //   69: getstatic 89	com/baidu/android/pushservice/d/c$e:e	Lcom/baidu/android/pushservice/d/c$e;
    //   72: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   75: aload_1
    //   76: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 5
    //   81: ldc 117
    //   83: aload_0
    //   84: new 131	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   91: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   94: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   97: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc -116
    //   102: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aconst_null
    //   109: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   112: pop
    //   113: aload_2
    //   114: ifnull +18 -> 132
    //   117: aload_2
    //   118: invokeinterface 166 1 0
    //   123: ifne +9 -> 132
    //   126: aload_2
    //   127: invokeinterface 169 1 0
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   142: aload 4
    //   144: monitorexit
    //   145: goto -118 -> 27
    //   148: astore_0
    //   149: aload 4
    //   151: monitorexit
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: ldc 2
    //   157: monitorexit
    //   158: aload_0
    //   159: athrow
    //   160: new 62	com/baidu/android/pushservice/d/b
    //   163: dup
    //   164: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   167: astore_3
    //   168: aload_3
    //   169: lconst_0
    //   170: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   173: aload_3
    //   174: lconst_0
    //   175: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   178: aload_3
    //   179: aconst_null
    //   180: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   183: aload_3
    //   184: aload_1
    //   185: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   188: aload_3
    //   189: aconst_null
    //   190: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   193: aload_3
    //   194: aconst_null
    //   195: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   198: aload_3
    //   199: aconst_null
    //   200: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   203: aload_3
    //   204: aconst_null
    //   205: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   208: aload_3
    //   209: aconst_null
    //   210: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   213: aload_0
    //   214: aload_3
    //   215: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   218: pop2
    //   219: goto -106 -> 113
    //   222: astore_0
    //   223: aload_2
    //   224: ifnull +18 -> 242
    //   227: aload_2
    //   228: invokeinterface 166 1 0
    //   233: ifne +9 -> 242
    //   236: aload_2
    //   237: invokeinterface 169 1 0
    //   242: aload 5
    //   244: ifnull -102 -> 142
    //   247: aload 5
    //   249: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   252: goto -110 -> 142
    //   255: aload_2
    //   256: ifnull +18 -> 274
    //   259: aload_2
    //   260: invokeinterface 166 1 0
    //   265: ifne +9 -> 274
    //   268: aload_2
    //   269: invokeinterface 169 1 0
    //   274: aload 5
    //   276: ifnull +8 -> 284
    //   279: aload 5
    //   281: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_0
    //   287: goto -32 -> 255
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_2
    //   293: goto -70 -> 223
    //   296: astore_0
    //   297: goto -42 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramContext	Context
    //   0	300	1	paramString	String
    //   1	292	2	localObject1	Object
    //   44	171	3	localObject2	Object
    //   8	142	4	localObject3	Object
    //   17	263	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	148	finally
    //   24	27	148	finally
    //   117	132	148	finally
    //   137	142	148	finally
    //   142	145	148	finally
    //   149	152	148	finally
    //   227	242	148	finally
    //   247	252	148	finally
    //   259	274	148	finally
    //   279	284	148	finally
    //   284	286	148	finally
    //   5	13	154	finally
    //   152	154	154	finally
    //   51	113	222	java/lang/Exception
    //   160	219	222	java/lang/Exception
    //   51	113	286	finally
    //   160	219	286	finally
    //   31	45	290	java/lang/Exception
    //   31	45	296	finally
  }
  
  /* Error */
  public static int c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aconst_null
    //   5: astore_3
    //   6: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: monitorenter
    //   14: aload_0
    //   15: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnonnull +8 -> 30
    //   25: aload 5
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: aload 6
    //   32: ldc 117
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_0
    //   44: aload_0
    //   45: invokeinterface 234 1 0
    //   50: ifeq +22 -> 72
    //   53: aload_0
    //   54: aload_0
    //   55: getstatic 77	com/baidu/android/pushservice/d/c$e:c	Lcom/baidu/android/pushservice/d/c$e;
    //   58: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   61: invokeinterface 381 2 0
    //   66: invokeinterface 374 2 0
    //   71: istore_1
    //   72: aload_0
    //   73: ifnull +18 -> 91
    //   76: aload_0
    //   77: invokeinterface 166 1 0
    //   82: ifne +9 -> 91
    //   85: aload_0
    //   86: invokeinterface 169 1 0
    //   91: iload_1
    //   92: istore_2
    //   93: aload 6
    //   95: ifnull +101 -> 196
    //   98: aload 6
    //   100: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   103: aload 5
    //   105: monitorexit
    //   106: iload_1
    //   107: ireturn
    //   108: astore_0
    //   109: aload 5
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +18 -> 136
    //   121: aload_0
    //   122: invokeinterface 166 1 0
    //   127: ifne +9 -> 136
    //   130: aload_0
    //   131: invokeinterface 169 1 0
    //   136: aload 6
    //   138: ifnull +58 -> 196
    //   141: aload 6
    //   143: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: iconst_0
    //   147: istore_1
    //   148: goto -45 -> 103
    //   151: aload_3
    //   152: ifnull +18 -> 170
    //   155: aload_3
    //   156: invokeinterface 166 1 0
    //   161: ifne +9 -> 170
    //   164: aload_3
    //   165: invokeinterface 169 1 0
    //   170: aload 6
    //   172: ifnull +8 -> 180
    //   175: aload 6
    //   177: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   180: aload_0
    //   181: athrow
    //   182: astore 4
    //   184: aload_0
    //   185: astore_3
    //   186: aload 4
    //   188: astore_0
    //   189: goto -38 -> 151
    //   192: astore_3
    //   193: goto -76 -> 117
    //   196: iload_2
    //   197: istore_1
    //   198: goto -95 -> 103
    //   201: astore_0
    //   202: goto -51 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramContext	Context
    //   3	195	1	i	int
    //   1	196	2	j	int
    //   5	181	3	localContext	Context
    //   192	1	3	localException	Exception
    //   182	5	4	localObject1	Object
    //   9	101	5	localObject2	Object
    //   18	158	6	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	20	108	finally
    //   25	28	108	finally
    //   76	91	108	finally
    //   98	103	108	finally
    //   103	106	108	finally
    //   109	112	108	finally
    //   121	136	108	finally
    //   141	146	108	finally
    //   155	170	108	finally
    //   175	180	108	finally
    //   180	182	108	finally
    //   30	44	114	java/lang/Exception
    //   44	72	182	finally
    //   44	72	192	java/lang/Exception
    //   30	44	201	finally
  }
  
  /* Error */
  public static void c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +7 -> 28
    //   24: aload_1
    //   25: ifnonnull +10 -> 35
    //   28: aload 4
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: return
    //   35: aload 5
    //   37: ldc 117
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +112 -> 164
    //   55: aload_2
    //   56: invokeinterface 129 1 0
    //   61: ifeq +103 -> 164
    //   64: new 52	android/content/ContentValues
    //   67: dup
    //   68: invokespecial 53	android/content/ContentValues:<init>	()V
    //   71: astore_0
    //   72: aload_0
    //   73: getstatic 103	com/baidu/android/pushservice/d/c$e:h	Lcom/baidu/android/pushservice/d/c$e;
    //   76: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   79: aload_1
    //   80: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload 5
    //   85: ldc 117
    //   87: aload_0
    //   88: new 131	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   95: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   98: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc -116
    //   106: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aconst_null
    //   113: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   116: pop
    //   117: aload_2
    //   118: ifnull +18 -> 136
    //   121: aload_2
    //   122: invokeinterface 166 1 0
    //   127: ifne +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 169 1 0
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: aload 4
    //   148: monitorexit
    //   149: goto -118 -> 31
    //   152: astore_0
    //   153: aload 4
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_0
    //   163: athrow
    //   164: new 62	com/baidu/android/pushservice/d/b
    //   167: dup
    //   168: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: lconst_0
    //   174: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   177: aload_3
    //   178: lconst_0
    //   179: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   182: aload_3
    //   183: aconst_null
    //   184: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   187: aload_3
    //   188: aconst_null
    //   189: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   192: aload_3
    //   193: aconst_null
    //   194: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   197: aload_3
    //   198: aconst_null
    //   199: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   202: aload_3
    //   203: aload_1
    //   204: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   207: aload_3
    //   208: aconst_null
    //   209: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   212: aload_3
    //   213: aconst_null
    //   214: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   217: aload_0
    //   218: aload_3
    //   219: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   222: pop2
    //   223: goto -106 -> 117
    //   226: astore_0
    //   227: aload_2
    //   228: ifnull +18 -> 246
    //   231: aload_2
    //   232: invokeinterface 166 1 0
    //   237: ifne +9 -> 246
    //   240: aload_2
    //   241: invokeinterface 169 1 0
    //   246: aload 5
    //   248: ifnull -102 -> 146
    //   251: aload 5
    //   253: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   256: goto -110 -> 146
    //   259: aload_2
    //   260: ifnull +18 -> 278
    //   263: aload_2
    //   264: invokeinterface 166 1 0
    //   269: ifne +9 -> 278
    //   272: aload_2
    //   273: invokeinterface 169 1 0
    //   278: aload 5
    //   280: ifnull +8 -> 288
    //   283: aload 5
    //   285: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   288: aload_0
    //   289: athrow
    //   290: astore_0
    //   291: goto -32 -> 259
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -70 -> 227
    //   300: astore_0
    //   301: goto -42 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramString	String
    //   1	296	2	localObject1	Object
    //   48	171	3	localObject2	Object
    //   8	146	4	localObject3	Object
    //   17	267	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	152	finally
    //   28	31	152	finally
    //   121	136	152	finally
    //   141	146	152	finally
    //   146	149	152	finally
    //   153	156	152	finally
    //   231	246	152	finally
    //   251	256	152	finally
    //   263	278	152	finally
    //   283	288	152	finally
    //   288	290	152	finally
    //   5	13	158	finally
    //   156	158	158	finally
    //   55	117	226	java/lang/Exception
    //   164	223	226	java/lang/Exception
    //   55	117	290	finally
    //   164	223	290	finally
    //   35	49	294	java/lang/Exception
    //   35	49	300	finally
  }
  
  /* Error */
  public static boolean c(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   6: astore 6
    //   8: aload 6
    //   10: monitorenter
    //   11: aload_0
    //   12: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnonnull +8 -> 27
    //   22: aload 6
    //   24: monitorexit
    //   25: iconst_0
    //   26: ireturn
    //   27: aload 7
    //   29: ldc_w 287
    //   32: aconst_null
    //   33: new 131	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   40: getstatic 250	com/baidu/android/pushservice/d/c$d:d	Lcom/baidu/android/pushservice/d/c$d;
    //   43: invokevirtual 248	com/baidu/android/pushservice/d/c$d:name	()Ljava/lang/String;
    //   46: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 384
    //   52: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: iconst_1
    //   59: anewarray 226	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: lload_1
    //   65: invokestatic 387	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +43 -> 120
    //   80: aload_0
    //   81: invokeinterface 129 1 0
    //   86: istore_3
    //   87: iload_3
    //   88: ifle +32 -> 120
    //   91: aload_0
    //   92: ifnull +18 -> 110
    //   95: aload_0
    //   96: invokeinterface 166 1 0
    //   101: ifne +9 -> 110
    //   104: aload_0
    //   105: invokeinterface 169 1 0
    //   110: aload 7
    //   112: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   115: aload 6
    //   117: monitorexit
    //   118: iconst_1
    //   119: ireturn
    //   120: aload_0
    //   121: ifnull +18 -> 139
    //   124: aload_0
    //   125: invokeinterface 166 1 0
    //   130: ifne +9 -> 139
    //   133: aload_0
    //   134: invokeinterface 169 1 0
    //   139: aload 7
    //   141: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   144: aload 6
    //   146: monitorexit
    //   147: iconst_0
    //   148: ireturn
    //   149: aload_0
    //   150: ifnull +18 -> 168
    //   153: aload_0
    //   154: invokeinterface 166 1 0
    //   159: ifne +9 -> 168
    //   162: aload_0
    //   163: invokeinterface 169 1 0
    //   168: aload 7
    //   170: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   173: aload 6
    //   175: monitorexit
    //   176: iconst_0
    //   177: ireturn
    //   178: aload 4
    //   180: ifnull +20 -> 200
    //   183: aload 4
    //   185: invokeinterface 166 1 0
    //   190: ifne +10 -> 200
    //   193: aload 4
    //   195: invokeinterface 169 1 0
    //   200: aload 7
    //   202: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: aload 6
    //   210: monitorexit
    //   211: aload_0
    //   212: athrow
    //   213: astore 5
    //   215: aload_0
    //   216: astore 4
    //   218: aload 5
    //   220: astore_0
    //   221: goto -43 -> 178
    //   224: astore 4
    //   226: goto -77 -> 149
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -83 -> 149
    //   235: astore_0
    //   236: goto -58 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramContext	Context
    //   0	239	1	paramLong	long
    //   86	2	3	i	int
    //   1	216	4	localContext	Context
    //   224	1	4	localException	Exception
    //   213	6	5	localObject1	Object
    //   6	203	6	localObject2	Object
    //   15	186	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	17	207	finally
    //   22	25	207	finally
    //   95	110	207	finally
    //   110	118	207	finally
    //   124	139	207	finally
    //   139	147	207	finally
    //   153	168	207	finally
    //   168	176	207	finally
    //   183	200	207	finally
    //   200	207	207	finally
    //   208	211	207	finally
    //   80	87	213	finally
    //   80	87	224	java/lang/Exception
    //   27	76	229	java/lang/Exception
    //   27	76	235	finally
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: aload_0
    //   11: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +7 -> 25
    //   21: aload_3
    //   22: monitorexit
    //   23: aconst_null
    //   24: areturn
    //   25: aload 4
    //   27: ldc 117
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_0
    //   39: aload_2
    //   40: astore_1
    //   41: aload_0
    //   42: invokeinterface 234 1 0
    //   47: ifeq +22 -> 69
    //   50: aload_0
    //   51: aload_0
    //   52: getstatic 81	com/baidu/android/pushservice/d/c$e:d	Lcom/baidu/android/pushservice/d/c$e;
    //   55: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   58: invokeinterface 381 2 0
    //   63: invokeinterface 238 2 0
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull +18 -> 88
    //   73: aload_0
    //   74: invokeinterface 166 1 0
    //   79: ifne +9 -> 88
    //   82: aload_0
    //   83: invokeinterface 169 1 0
    //   88: aload 4
    //   90: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: aload_3
    //   94: monitorexit
    //   95: aload_1
    //   96: areturn
    //   97: astore_0
    //   98: aload_3
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +18 -> 124
    //   109: aload_0
    //   110: invokeinterface 166 1 0
    //   115: ifne +9 -> 124
    //   118: aload_0
    //   119: invokeinterface 169 1 0
    //   124: aload 4
    //   126: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -38 -> 93
    //   134: aload_1
    //   135: ifnull +18 -> 153
    //   138: aload_1
    //   139: invokeinterface 166 1 0
    //   144: ifne +9 -> 153
    //   147: aload_1
    //   148: invokeinterface 169 1 0
    //   153: aload 4
    //   155: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   158: aload_0
    //   159: athrow
    //   160: astore_2
    //   161: aload_0
    //   162: astore_1
    //   163: aload_2
    //   164: astore_0
    //   165: goto -31 -> 134
    //   168: astore_1
    //   169: goto -64 -> 105
    //   172: astore_0
    //   173: goto -39 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramContext	Context
    //   1	162	1	localObject1	Object
    //   168	1	1	localException	Exception
    //   3	37	2	localObject2	Object
    //   160	4	2	localObject3	Object
    //   7	92	3	localObject4	Object
    //   14	140	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	16	97	finally
    //   21	23	97	finally
    //   73	88	97	finally
    //   88	93	97	finally
    //   93	95	97	finally
    //   98	100	97	finally
    //   109	124	97	finally
    //   124	129	97	finally
    //   138	153	97	finally
    //   153	160	97	finally
    //   25	39	102	java/lang/Exception
    //   41	69	160	finally
    //   41	69	168	java/lang/Exception
    //   25	39	172	finally
  }
  
  /* Error */
  public static void d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +7 -> 28
    //   24: aload_1
    //   25: ifnonnull +10 -> 35
    //   28: aload 4
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: return
    //   35: aload 5
    //   37: ldc 117
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +112 -> 164
    //   55: aload_2
    //   56: invokeinterface 129 1 0
    //   61: ifeq +103 -> 164
    //   64: new 52	android/content/ContentValues
    //   67: dup
    //   68: invokespecial 53	android/content/ContentValues:<init>	()V
    //   71: astore_0
    //   72: aload_0
    //   73: getstatic 108	com/baidu/android/pushservice/d/c$e:i	Lcom/baidu/android/pushservice/d/c$e;
    //   76: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   79: aload_1
    //   80: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload 5
    //   85: ldc 117
    //   87: aload_0
    //   88: new 131	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   95: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   98: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc -116
    //   106: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aconst_null
    //   113: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   116: pop
    //   117: aload_2
    //   118: ifnull +18 -> 136
    //   121: aload_2
    //   122: invokeinterface 166 1 0
    //   127: ifne +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 169 1 0
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: aload 4
    //   148: monitorexit
    //   149: goto -118 -> 31
    //   152: astore_0
    //   153: aload 4
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_0
    //   163: athrow
    //   164: new 62	com/baidu/android/pushservice/d/b
    //   167: dup
    //   168: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: lconst_0
    //   174: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   177: aload_3
    //   178: lconst_0
    //   179: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   182: aload_3
    //   183: aconst_null
    //   184: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   187: aload_3
    //   188: aconst_null
    //   189: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   192: aload_3
    //   193: aconst_null
    //   194: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   197: aload_3
    //   198: aconst_null
    //   199: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   202: aload_3
    //   203: aconst_null
    //   204: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   207: aload_3
    //   208: aload_1
    //   209: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   212: aload_3
    //   213: aconst_null
    //   214: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   217: aload_0
    //   218: aload_3
    //   219: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   222: pop2
    //   223: goto -106 -> 117
    //   226: astore_0
    //   227: aload_2
    //   228: ifnull +18 -> 246
    //   231: aload_2
    //   232: invokeinterface 166 1 0
    //   237: ifne +9 -> 246
    //   240: aload_2
    //   241: invokeinterface 169 1 0
    //   246: aload 5
    //   248: ifnull -102 -> 146
    //   251: aload 5
    //   253: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   256: goto -110 -> 146
    //   259: aload_2
    //   260: ifnull +18 -> 278
    //   263: aload_2
    //   264: invokeinterface 166 1 0
    //   269: ifne +9 -> 278
    //   272: aload_2
    //   273: invokeinterface 169 1 0
    //   278: aload 5
    //   280: ifnull +8 -> 288
    //   283: aload 5
    //   285: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   288: aload_0
    //   289: athrow
    //   290: astore_0
    //   291: goto -32 -> 259
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -70 -> 227
    //   300: astore_0
    //   301: goto -42 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramString	String
    //   1	296	2	localObject1	Object
    //   48	171	3	localObject2	Object
    //   8	146	4	localObject3	Object
    //   17	267	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	152	finally
    //   28	31	152	finally
    //   121	136	152	finally
    //   141	146	152	finally
    //   146	149	152	finally
    //   153	156	152	finally
    //   231	246	152	finally
    //   251	256	152	finally
    //   263	278	152	finally
    //   283	288	152	finally
    //   288	290	152	finally
    //   5	13	158	finally
    //   156	158	158	finally
    //   55	117	226	java/lang/Exception
    //   164	223	226	java/lang/Exception
    //   55	117	290	finally
    //   164	223	290	finally
    //   35	49	294	java/lang/Exception
    //   35	49	300	finally
  }
  
  /* Error */
  public static String e(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: aload_0
    //   11: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +7 -> 25
    //   21: aload_3
    //   22: monitorexit
    //   23: aconst_null
    //   24: areturn
    //   25: aload 4
    //   27: ldc 117
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_0
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: aload_1
    //   44: invokeinterface 234 1 0
    //   49: ifeq +22 -> 71
    //   52: aload_1
    //   53: aload_1
    //   54: getstatic 103	com/baidu/android/pushservice/d/c$e:h	Lcom/baidu/android/pushservice/d/c$e;
    //   57: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   60: invokeinterface 381 2 0
    //   65: invokeinterface 238 2 0
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +18 -> 90
    //   75: aload_1
    //   76: invokeinterface 166 1 0
    //   81: ifne +9 -> 90
    //   84: aload_1
    //   85: invokeinterface 169 1 0
    //   90: aload 4
    //   92: ifnull +98 -> 190
    //   95: aload 4
    //   97: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   100: aload_3
    //   101: monitorexit
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +18 -> 131
    //   116: aload_1
    //   117: invokeinterface 166 1 0
    //   122: ifne +9 -> 131
    //   125: aload_1
    //   126: invokeinterface 169 1 0
    //   131: aload 4
    //   133: ifnull +52 -> 185
    //   136: aload 4
    //   138: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -43 -> 100
    //   146: aload_1
    //   147: ifnull +18 -> 165
    //   150: aload_1
    //   151: invokeinterface 166 1 0
    //   156: ifne +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 169 1 0
    //   165: aload 4
    //   167: ifnull +8 -> 175
    //   170: aload 4
    //   172: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_0
    //   178: goto -32 -> 146
    //   181: astore_0
    //   182: goto -70 -> 112
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -87 -> 100
    //   190: goto -90 -> 100
    //   193: astore_0
    //   194: goto -48 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   1	159	1	localContext	Context
    //   3	39	2	localObject1	Object
    //   7	99	3	localObject2	Object
    //   14	157	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	16	104	finally
    //   21	23	104	finally
    //   75	90	104	finally
    //   95	100	104	finally
    //   100	102	104	finally
    //   105	107	104	finally
    //   116	131	104	finally
    //   136	141	104	finally
    //   150	165	104	finally
    //   170	175	104	finally
    //   175	177	104	finally
    //   25	39	109	java/lang/Exception
    //   43	71	177	finally
    //   43	71	181	java/lang/Exception
    //   25	39	193	finally
  }
  
  /* Error */
  public static void e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: aload_0
    //   14: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +7 -> 28
    //   24: aload_1
    //   25: ifnonnull +10 -> 35
    //   28: aload 4
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: return
    //   35: aload 5
    //   37: ldc 117
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +112 -> 164
    //   55: aload_2
    //   56: invokeinterface 129 1 0
    //   61: ifeq +103 -> 164
    //   64: new 52	android/content/ContentValues
    //   67: dup
    //   68: invokespecial 53	android/content/ContentValues:<init>	()V
    //   71: astore_0
    //   72: aload_0
    //   73: getstatic 113	com/baidu/android/pushservice/d/c$e:j	Lcom/baidu/android/pushservice/d/c$e;
    //   76: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   79: aload_1
    //   80: invokevirtual 87	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload 5
    //   85: ldc 117
    //   87: aload_0
    //   88: new 131	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   95: getstatic 134	com/baidu/android/pushservice/d/c$e:a	Lcom/baidu/android/pushservice/d/c$e;
    //   98: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc -116
    //   106: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aconst_null
    //   113: invokevirtual 147	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   116: pop
    //   117: aload_2
    //   118: ifnull +18 -> 136
    //   121: aload_2
    //   122: invokeinterface 166 1 0
    //   127: ifne +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 169 1 0
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   146: aload 4
    //   148: monitorexit
    //   149: goto -118 -> 31
    //   152: astore_0
    //   153: aload 4
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_0
    //   163: athrow
    //   164: new 62	com/baidu/android/pushservice/d/b
    //   167: dup
    //   168: invokespecial 240	com/baidu/android/pushservice/d/b:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: lconst_0
    //   174: putfield 65	com/baidu/android/pushservice/d/b:a	J
    //   177: aload_3
    //   178: lconst_0
    //   179: putfield 79	com/baidu/android/pushservice/d/b:b	J
    //   182: aload_3
    //   183: aconst_null
    //   184: putfield 84	com/baidu/android/pushservice/d/b:c	Ljava/lang/String;
    //   187: aload_3
    //   188: aconst_null
    //   189: putfield 91	com/baidu/android/pushservice/d/b:d	Ljava/lang/String;
    //   192: aload_3
    //   193: aconst_null
    //   194: putfield 96	com/baidu/android/pushservice/d/b:f	Ljava/lang/String;
    //   197: aload_3
    //   198: aconst_null
    //   199: putfield 100	com/baidu/android/pushservice/d/b:e	Ljava/lang/String;
    //   202: aload_3
    //   203: aconst_null
    //   204: putfield 105	com/baidu/android/pushservice/d/b:g	Ljava/lang/String;
    //   207: aload_3
    //   208: aconst_null
    //   209: putfield 110	com/baidu/android/pushservice/d/b:h	Ljava/lang/String;
    //   212: aload_3
    //   213: aload_1
    //   214: putfield 115	com/baidu/android/pushservice/d/b:i	Ljava/lang/String;
    //   217: aload_0
    //   218: aload_3
    //   219: invokestatic 242	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;Lcom/baidu/android/pushservice/d/b;)J
    //   222: pop2
    //   223: goto -106 -> 117
    //   226: astore_0
    //   227: aload_2
    //   228: ifnull +18 -> 246
    //   231: aload_2
    //   232: invokeinterface 166 1 0
    //   237: ifne +9 -> 246
    //   240: aload_2
    //   241: invokeinterface 169 1 0
    //   246: aload 5
    //   248: ifnull -102 -> 146
    //   251: aload 5
    //   253: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   256: goto -110 -> 146
    //   259: aload_2
    //   260: ifnull +18 -> 278
    //   263: aload_2
    //   264: invokeinterface 166 1 0
    //   269: ifne +9 -> 278
    //   272: aload_2
    //   273: invokeinterface 169 1 0
    //   278: aload 5
    //   280: ifnull +8 -> 288
    //   283: aload 5
    //   285: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   288: aload_0
    //   289: athrow
    //   290: astore_0
    //   291: goto -32 -> 259
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -70 -> 227
    //   300: astore_0
    //   301: goto -42 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramString	String
    //   1	296	2	localObject1	Object
    //   48	171	3	localObject2	Object
    //   8	146	4	localObject3	Object
    //   17	267	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	19	152	finally
    //   28	31	152	finally
    //   121	136	152	finally
    //   141	146	152	finally
    //   146	149	152	finally
    //   153	156	152	finally
    //   231	246	152	finally
    //   251	256	152	finally
    //   263	278	152	finally
    //   283	288	152	finally
    //   288	290	152	finally
    //   5	13	158	finally
    //   156	158	158	finally
    //   55	117	226	java/lang/Exception
    //   164	223	226	java/lang/Exception
    //   55	117	290	finally
    //   164	223	290	finally
    //   35	49	294	java/lang/Exception
    //   35	49	300	finally
  }
  
  /* Error */
  public static String f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   5: astore 4
    //   7: aload 4
    //   9: monitorenter
    //   10: aload_0
    //   11: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +8 -> 26
    //   21: aload 4
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload 5
    //   28: ldc 117
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_2
    //   40: aload_2
    //   41: astore_3
    //   42: aload_2
    //   43: invokeinterface 234 1 0
    //   48: ifeq +24 -> 72
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: aload_2
    //   55: getstatic 108	com/baidu/android/pushservice/d/c$e:i	Lcom/baidu/android/pushservice/d/c$e;
    //   58: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   61: invokeinterface 381 2 0
    //   66: invokeinterface 238 2 0
    //   71: astore_1
    //   72: aload_2
    //   73: ifnull +18 -> 91
    //   76: aload_2
    //   77: invokeinterface 166 1 0
    //   82: ifne +9 -> 91
    //   85: aload_2
    //   86: invokeinterface 169 1 0
    //   91: aload 5
    //   93: ifnull +131 -> 224
    //   96: aload 5
    //   98: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   101: aload_1
    //   102: astore_0
    //   103: aload 4
    //   105: monitorexit
    //   106: aload_0
    //   107: areturn
    //   108: astore_0
    //   109: aload 4
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: astore_3
    //   119: new 131	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 390
    //   129: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_1
    //   133: invokestatic 395	com/baidu/android/pushservice/g/a:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   136: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aload_0
    //   143: invokestatic 154	com/baidu/android/pushservice/j/p:b	(Ljava/lang/String;Landroid/content/Context;)V
    //   146: aload_2
    //   147: ifnull +18 -> 165
    //   150: aload_2
    //   151: invokeinterface 166 1 0
    //   156: ifne +9 -> 165
    //   159: aload_2
    //   160: invokeinterface 169 1 0
    //   165: aload 5
    //   167: ifnull +52 -> 219
    //   170: aload 5
    //   172: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: aconst_null
    //   176: astore_0
    //   177: goto -74 -> 103
    //   180: aload_3
    //   181: ifnull +18 -> 199
    //   184: aload_3
    //   185: invokeinterface 166 1 0
    //   190: ifne +9 -> 199
    //   193: aload_3
    //   194: invokeinterface 169 1 0
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: goto -32 -> 180
    //   215: astore_1
    //   216: goto -99 -> 117
    //   219: aconst_null
    //   220: astore_0
    //   221: goto -118 -> 103
    //   224: aload_1
    //   225: astore_0
    //   226: goto -123 -> 103
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_3
    //   232: goto -52 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramContext	Context
    //   1	101	1	str	String
    //   114	19	1	localException1	Exception
    //   215	10	1	localException2	Exception
    //   39	121	2	localCursor1	android.database.Cursor
    //   41	191	3	localCursor2	android.database.Cursor
    //   5	105	4	localObject	Object
    //   14	191	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	16	108	finally
    //   21	24	108	finally
    //   76	91	108	finally
    //   96	101	108	finally
    //   103	106	108	finally
    //   109	112	108	finally
    //   150	165	108	finally
    //   170	175	108	finally
    //   184	199	108	finally
    //   204	209	108	finally
    //   209	211	108	finally
    //   26	40	114	java/lang/Exception
    //   42	51	211	finally
    //   53	72	211	finally
    //   119	146	211	finally
    //   42	51	215	java/lang/Exception
    //   53	72	215	java/lang/Exception
    //   26	40	229	finally
  }
  
  /* Error */
  public static String g(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: aload_0
    //   11: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +7 -> 25
    //   21: aload_3
    //   22: monitorexit
    //   23: aconst_null
    //   24: areturn
    //   25: aload 4
    //   27: ldc 117
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_0
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: aload_1
    //   44: invokeinterface 234 1 0
    //   49: ifeq +22 -> 71
    //   52: aload_1
    //   53: aload_1
    //   54: getstatic 113	com/baidu/android/pushservice/d/c$e:j	Lcom/baidu/android/pushservice/d/c$e;
    //   57: invokevirtual 60	com/baidu/android/pushservice/d/c$e:name	()Ljava/lang/String;
    //   60: invokeinterface 381 2 0
    //   65: invokeinterface 238 2 0
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +18 -> 90
    //   75: aload_1
    //   76: invokeinterface 166 1 0
    //   81: ifne +9 -> 90
    //   84: aload_1
    //   85: invokeinterface 169 1 0
    //   90: aload 4
    //   92: ifnull +98 -> 190
    //   95: aload 4
    //   97: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   100: aload_3
    //   101: monitorexit
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +18 -> 131
    //   116: aload_1
    //   117: invokeinterface 166 1 0
    //   122: ifne +9 -> 131
    //   125: aload_1
    //   126: invokeinterface 169 1 0
    //   131: aload 4
    //   133: ifnull +52 -> 185
    //   136: aload 4
    //   138: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -43 -> 100
    //   146: aload_1
    //   147: ifnull +18 -> 165
    //   150: aload_1
    //   151: invokeinterface 166 1 0
    //   156: ifne +9 -> 165
    //   159: aload_1
    //   160: invokeinterface 169 1 0
    //   165: aload 4
    //   167: ifnull +8 -> 175
    //   170: aload 4
    //   172: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_0
    //   178: goto -32 -> 146
    //   181: astore_0
    //   182: goto -70 -> 112
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -87 -> 100
    //   190: goto -90 -> 100
    //   193: astore_0
    //   194: goto -48 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramContext	Context
    //   1	159	1	localContext	Context
    //   3	39	2	localObject1	Object
    //   7	99	3	localObject2	Object
    //   14	157	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	16	104	finally
    //   21	23	104	finally
    //   75	90	104	finally
    //   95	100	104	finally
    //   100	102	104	finally
    //   105	107	104	finally
    //   116	131	104	finally
    //   136	141	104	finally
    //   150	165	104	finally
    //   170	175	104	finally
    //   175	177	104	finally
    //   25	39	109	java/lang/Exception
    //   43	71	177	finally
    //   43	71	181	java/lang/Exception
    //   25	39	193	finally
  }
  
  /* Error */
  public static java.util.List<com.baidu.android.pushservice.h.e> h(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   12: astore 11
    //   14: aload 11
    //   16: monitorenter
    //   17: aload_0
    //   18: invokestatic 50	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 12
    //   23: aload 12
    //   25: ifnonnull +13 -> 38
    //   28: aload 11
    //   30: monitorexit
    //   31: aconst_null
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: new 398	java/util/ArrayList
    //   41: dup
    //   42: invokespecial 399	java/util/ArrayList:<init>	()V
    //   45: astore 9
    //   47: aload 8
    //   49: astore_0
    //   50: aload 10
    //   52: astore 7
    //   54: getstatic 324	com/baidu/android/pushservice/d/c$a:c	Lcom/baidu/android/pushservice/d/c$a;
    //   57: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   60: astore 13
    //   62: aload 8
    //   64: astore_0
    //   65: aload 10
    //   67: astore 7
    //   69: aload 12
    //   71: ldc_w 293
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: new 131	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   86: aload 13
    //   88: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 401
    //   94: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 123	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +356 -> 463
    //   110: aload 8
    //   112: astore_0
    //   113: aload 8
    //   115: astore 7
    //   117: aload 8
    //   119: invokeinterface 129 1 0
    //   124: ifle +339 -> 463
    //   127: aload 8
    //   129: astore_0
    //   130: aload 8
    //   132: astore 7
    //   134: aload 8
    //   136: getstatic 316	com/baidu/android/pushservice/d/c$a:b	Lcom/baidu/android/pushservice/d/c$a;
    //   139: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   142: invokeinterface 381 2 0
    //   147: istore_1
    //   148: aload 8
    //   150: astore_0
    //   151: aload 8
    //   153: astore 7
    //   155: aload 8
    //   157: getstatic 320	com/baidu/android/pushservice/d/c$a:e	Lcom/baidu/android/pushservice/d/c$a;
    //   160: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   163: invokeinterface 381 2 0
    //   168: istore_2
    //   169: aload 8
    //   171: astore_0
    //   172: aload 8
    //   174: astore 7
    //   176: aload 8
    //   178: aload 13
    //   180: invokeinterface 381 2 0
    //   185: istore_3
    //   186: aload 8
    //   188: astore_0
    //   189: aload 8
    //   191: astore 7
    //   193: aload 8
    //   195: getstatic 328	com/baidu/android/pushservice/d/c$a:f	Lcom/baidu/android/pushservice/d/c$a;
    //   198: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   201: invokeinterface 381 2 0
    //   206: istore 4
    //   208: aload 8
    //   210: astore_0
    //   211: aload 8
    //   213: astore 7
    //   215: aload 8
    //   217: getstatic 332	com/baidu/android/pushservice/d/c$a:g	Lcom/baidu/android/pushservice/d/c$a;
    //   220: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   223: invokeinterface 381 2 0
    //   228: istore 5
    //   230: aload 8
    //   232: astore_0
    //   233: aload 8
    //   235: astore 7
    //   237: aload 8
    //   239: getstatic 336	com/baidu/android/pushservice/d/c$a:h	Lcom/baidu/android/pushservice/d/c$a;
    //   242: invokevirtual 317	com/baidu/android/pushservice/d/c$a:name	()Ljava/lang/String;
    //   245: invokeinterface 381 2 0
    //   250: istore 6
    //   252: aload 8
    //   254: astore_0
    //   255: aload 8
    //   257: astore 7
    //   259: aload 8
    //   261: invokeinterface 404 1 0
    //   266: ifeq +197 -> 463
    //   269: aload 8
    //   271: astore_0
    //   272: aload 8
    //   274: astore 7
    //   276: new 406	com/baidu/android/pushservice/h/e
    //   279: dup
    //   280: invokespecial 407	com/baidu/android/pushservice/h/e:<init>	()V
    //   283: astore 10
    //   285: aload 8
    //   287: astore_0
    //   288: aload 8
    //   290: astore 7
    //   292: aload 10
    //   294: aload 8
    //   296: iload_1
    //   297: invokeinterface 238 2 0
    //   302: invokevirtual 410	com/baidu/android/pushservice/h/e:a	(Ljava/lang/String;)V
    //   305: aload 8
    //   307: astore_0
    //   308: aload 8
    //   310: astore 7
    //   312: aload 10
    //   314: aload 8
    //   316: iload_2
    //   317: invokeinterface 238 2 0
    //   322: invokevirtual 412	com/baidu/android/pushservice/h/e:h	(Ljava/lang/String;)V
    //   325: aload 8
    //   327: astore_0
    //   328: aload 8
    //   330: astore 7
    //   332: aload 10
    //   334: aload 8
    //   336: iload_3
    //   337: invokeinterface 416 2 0
    //   342: invokevirtual 419	com/baidu/android/pushservice/h/e:a	(J)V
    //   345: aload 8
    //   347: astore_0
    //   348: aload 8
    //   350: astore 7
    //   352: aload 10
    //   354: aload 8
    //   356: iload 4
    //   358: invokeinterface 374 2 0
    //   363: invokevirtual 422	com/baidu/android/pushservice/h/e:f	(I)V
    //   366: aload 8
    //   368: astore_0
    //   369: aload 8
    //   371: astore 7
    //   373: aload 10
    //   375: aload 8
    //   377: iload 5
    //   379: invokeinterface 238 2 0
    //   384: invokevirtual 424	com/baidu/android/pushservice/h/e:j	(Ljava/lang/String;)V
    //   387: aload 8
    //   389: astore_0
    //   390: aload 8
    //   392: astore 7
    //   394: aload 10
    //   396: aload 8
    //   398: iload 6
    //   400: invokeinterface 374 2 0
    //   405: invokevirtual 426	com/baidu/android/pushservice/h/e:g	(I)V
    //   408: aload 8
    //   410: astore_0
    //   411: aload 8
    //   413: astore 7
    //   415: aload 9
    //   417: aload 10
    //   419: invokeinterface 430 2 0
    //   424: pop
    //   425: goto -173 -> 252
    //   428: astore 7
    //   430: aload_0
    //   431: ifnull +18 -> 449
    //   434: aload_0
    //   435: invokeinterface 166 1 0
    //   440: ifne +9 -> 449
    //   443: aload_0
    //   444: invokeinterface 169 1 0
    //   449: aload 12
    //   451: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   454: aload 11
    //   456: monitorexit
    //   457: aload 9
    //   459: astore_0
    //   460: goto -427 -> 33
    //   463: aload 8
    //   465: ifnull +20 -> 485
    //   468: aload 8
    //   470: invokeinterface 166 1 0
    //   475: ifne +10 -> 485
    //   478: aload 8
    //   480: invokeinterface 169 1 0
    //   485: aload 12
    //   487: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   490: goto -36 -> 454
    //   493: astore_0
    //   494: aload 11
    //   496: monitorexit
    //   497: aload_0
    //   498: athrow
    //   499: astore_0
    //   500: ldc 2
    //   502: monitorexit
    //   503: aload_0
    //   504: athrow
    //   505: astore_0
    //   506: aload 7
    //   508: ifnull +20 -> 528
    //   511: aload 7
    //   513: invokeinterface 166 1 0
    //   518: ifne +10 -> 528
    //   521: aload 7
    //   523: invokeinterface 169 1 0
    //   528: aload 12
    //   530: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   533: aload_0
    //   534: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	paramContext	Context
    //   147	150	1	i	int
    //   168	149	2	j	int
    //   185	152	3	k	int
    //   206	151	4	m	int
    //   228	150	5	n	int
    //   250	149	6	i1	int
    //   52	362	7	localObject1	Object
    //   428	94	7	localException	Exception
    //   4	475	8	localCursor	android.database.Cursor
    //   45	413	9	localArrayList	java.util.ArrayList
    //   1	417	10	locale	com.baidu.android.pushservice.h.e
    //   21	508	12	localSQLiteDatabase	SQLiteDatabase
    //   60	119	13	str	String
    // Exception table:
    //   from	to	target	type
    //   54	62	428	java/lang/Exception
    //   69	105	428	java/lang/Exception
    //   117	127	428	java/lang/Exception
    //   134	148	428	java/lang/Exception
    //   155	169	428	java/lang/Exception
    //   176	186	428	java/lang/Exception
    //   193	208	428	java/lang/Exception
    //   215	230	428	java/lang/Exception
    //   237	252	428	java/lang/Exception
    //   259	269	428	java/lang/Exception
    //   276	285	428	java/lang/Exception
    //   292	305	428	java/lang/Exception
    //   312	325	428	java/lang/Exception
    //   332	345	428	java/lang/Exception
    //   352	366	428	java/lang/Exception
    //   373	387	428	java/lang/Exception
    //   394	408	428	java/lang/Exception
    //   415	425	428	java/lang/Exception
    //   17	23	493	finally
    //   28	31	493	finally
    //   38	47	493	finally
    //   434	449	493	finally
    //   449	454	493	finally
    //   454	457	493	finally
    //   468	485	493	finally
    //   485	490	493	finally
    //   494	497	493	finally
    //   511	528	493	finally
    //   528	535	493	finally
    //   9	17	499	finally
    //   497	499	499	finally
    //   54	62	505	finally
    //   69	105	505	finally
    //   117	127	505	finally
    //   134	148	505	finally
    //   155	169	505	finally
    //   176	186	505	finally
    //   193	208	505	finally
    //   215	230	505	finally
    //   237	252	505	finally
    //   259	269	505	finally
    //   276	285	505	finally
    //   292	305	505	finally
    //   312	325	505	finally
    //   332	345	505	finally
    //   352	366	505	finally
    //   373	387	505	finally
    //   394	408	505	finally
    //   415	425	505	finally
  }
  
  /* Error */
  private static c i(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 39	com/baidu/android/pushservice/d/c:c	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: getstatic 32	com/baidu/android/pushservice/d/c:a	Lcom/baidu/android/pushservice/d/c$c;
    //   11: ifnonnull +193 -> 204
    //   14: new 433	java/io/File
    //   17: dup
    //   18: new 131	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   25: invokestatic 439	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   28: invokevirtual 442	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   31: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 444
    //   37: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 447	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: invokevirtual 450	android/content/Context:getPackageName	()Ljava/lang/String;
    //   50: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 452
    //   56: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 454	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 457	java/io/File:exists	()Z
    //   70: ifne +8 -> 78
    //   73: aload_2
    //   74: invokevirtual 460	java/io/File:mkdirs	()Z
    //   77: pop
    //   78: new 131	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   85: aload_2
    //   86: invokevirtual 442	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   89: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: getstatic 447	java/io/File:separator	Ljava/lang/String;
    //   95: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 462
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: getstatic 467	android/os/Build$VERSION:SDK_INT	I
    //   111: bipush 11
    //   113: if_icmplt +97 -> 210
    //   116: new 11	com/baidu/android/pushservice/d/c$b
    //   119: dup
    //   120: aconst_null
    //   121: invokespecial 470	com/baidu/android/pushservice/d/c$b:<init>	(Lcom/baidu/android/pushservice/d/c$1;)V
    //   124: putstatic 34	com/baidu/android/pushservice/d/c:b	Lcom/baidu/android/pushservice/d/c$b;
    //   127: new 14	com/baidu/android/pushservice/d/c$c
    //   130: dup
    //   131: aload_0
    //   132: aload_2
    //   133: iconst_4
    //   134: getstatic 34	com/baidu/android/pushservice/d/c:b	Lcom/baidu/android/pushservice/d/c$b;
    //   137: invokespecial 473	com/baidu/android/pushservice/d/c$c:<init>	(Landroid/content/Context;Ljava/lang/String;ILandroid/database/DatabaseErrorHandler;)V
    //   140: putstatic 32	com/baidu/android/pushservice/d/c:a	Lcom/baidu/android/pushservice/d/c$c;
    //   143: getstatic 32	com/baidu/android/pushservice/d/c:a	Lcom/baidu/android/pushservice/d/c$c;
    //   146: invokevirtual 185	com/baidu/android/pushservice/d/c$c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   149: astore_0
    //   150: aload_0
    //   151: astore_1
    //   152: aload_0
    //   153: ldc_w 287
    //   156: new 131	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   163: getstatic 277	com/baidu/android/pushservice/d/c$d:e	Lcom/baidu/android/pushservice/d/c$d;
    //   166: invokevirtual 248	com/baidu/android/pushservice/d/c$d:name	()Ljava/lang/String;
    //   169: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 475
    //   175: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   181: ldc2_w 476
    //   184: lsub
    //   185: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: aconst_null
    //   192: invokevirtual 297	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   195: pop
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   204: aload_3
    //   205: monitorexit
    //   206: getstatic 32	com/baidu/android/pushservice/d/c:a	Lcom/baidu/android/pushservice/d/c$c;
    //   209: areturn
    //   210: new 14	com/baidu/android/pushservice/d/c$c
    //   213: dup
    //   214: aload_0
    //   215: aload_2
    //   216: aconst_null
    //   217: iconst_4
    //   218: invokespecial 480	com/baidu/android/pushservice/d/c$c:<init>	(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    //   221: putstatic 32	com/baidu/android/pushservice/d/c:a	Lcom/baidu/android/pushservice/d/c$c;
    //   224: goto -81 -> 143
    //   227: astore_0
    //   228: aload_3
    //   229: monitorexit
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: aload_1
    //   234: ifnull -30 -> 204
    //   237: aload_1
    //   238: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   241: goto -37 -> 204
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 170	android/database/sqlite/SQLiteDatabase:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_2
    //   255: aload_0
    //   256: astore_1
    //   257: aload_2
    //   258: astore_0
    //   259: goto -15 -> 244
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_1
    //   265: goto -21 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramContext	Context
    //   1	264	1	localContext	Context
    //   65	151	2	localObject1	Object
    //   254	4	2	localObject2	Object
    //   5	224	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	78	227	finally
    //   78	143	227	finally
    //   200	204	227	finally
    //   204	206	227	finally
    //   210	224	227	finally
    //   228	230	227	finally
    //   237	241	227	finally
    //   248	252	227	finally
    //   252	254	227	finally
    //   143	150	232	java/lang/Exception
    //   152	196	232	java/lang/Exception
    //   152	196	254	finally
    //   143	150	262	finally
  }
  
  public static enum a
  {
    private a() {}
  }
  
  private static class b
    implements DatabaseErrorHandler
  {
    @TargetApi(16)
    private void a(String paramString)
    {
      if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0)) {
        return;
      }
      try
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          SQLiteDatabase.deleteDatabase(new File(paramString));
          return;
        }
        new File(paramString).delete();
        return;
      }
      catch (Exception paramString) {}
    }
    
    /* Error */
    public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 67	android/database/sqlite/SQLiteDatabase:isOpen	()Z
      //   4: ifne +12 -> 16
      //   7: aload_0
      //   8: aload_1
      //   9: invokevirtual 70	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   12: invokespecial 72	com/baidu/android/pushservice/d/c$b:a	(Ljava/lang/String;)V
      //   15: return
      //   16: aconst_null
      //   17: astore_2
      //   18: aload_1
      //   19: invokevirtual 76	android/database/sqlite/SQLiteDatabase:getAttachedDbs	()Ljava/util/List;
      //   22: astore_3
      //   23: aload_3
      //   24: astore_2
      //   25: aload_1
      //   26: invokevirtual 79	android/database/sqlite/SQLiteDatabase:close	()V
      //   29: aload_2
      //   30: ifnull +41 -> 71
      //   33: aload_2
      //   34: invokeinterface 85 1 0
      //   39: astore_1
      //   40: aload_1
      //   41: invokeinterface 90 1 0
      //   46: ifeq -31 -> 15
      //   49: aload_0
      //   50: aload_1
      //   51: invokeinterface 94 1 0
      //   56: checkcast 96	android/util/Pair
      //   59: getfield 100	android/util/Pair:second	Ljava/lang/Object;
      //   62: checkcast 27	java/lang/String
      //   65: invokespecial 72	com/baidu/android/pushservice/d/c$b:a	(Ljava/lang/String;)V
      //   68: goto -28 -> 40
      //   71: aload_0
      //   72: aload_1
      //   73: invokevirtual 70	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   76: invokespecial 72	com/baidu/android/pushservice/d/c$b:a	(Ljava/lang/String;)V
      //   79: return
      //   80: astore_2
      //   81: aconst_null
      //   82: astore_3
      //   83: aload_3
      //   84: ifnull +41 -> 125
      //   87: aload_3
      //   88: invokeinterface 85 1 0
      //   93: astore_1
      //   94: aload_1
      //   95: invokeinterface 90 1 0
      //   100: ifeq +33 -> 133
      //   103: aload_0
      //   104: aload_1
      //   105: invokeinterface 94 1 0
      //   110: checkcast 96	android/util/Pair
      //   113: getfield 100	android/util/Pair:second	Ljava/lang/Object;
      //   116: checkcast 27	java/lang/String
      //   119: invokespecial 72	com/baidu/android/pushservice/d/c$b:a	(Ljava/lang/String;)V
      //   122: goto -28 -> 94
      //   125: aload_0
      //   126: aload_1
      //   127: invokevirtual 70	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   130: invokespecial 72	com/baidu/android/pushservice/d/c$b:a	(Ljava/lang/String;)V
      //   133: aload_2
      //   134: athrow
      //   135: astore_3
      //   136: goto -111 -> 25
      //   139: astore_3
      //   140: goto -111 -> 29
      //   143: astore 4
      //   145: aload_2
      //   146: astore_3
      //   147: aload 4
      //   149: astore_2
      //   150: goto -67 -> 83
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	b
      //   0	153	1	paramSQLiteDatabase	SQLiteDatabase
      //   17	17	2	localObject1	Object
      //   80	66	2	localObject2	Object
      //   149	1	2	localObject3	Object
      //   22	66	3	localList	java.util.List
      //   135	1	3	localSQLiteException1	android.database.sqlite.SQLiteException
      //   139	1	3	localSQLiteException2	android.database.sqlite.SQLiteException
      //   146	1	3	localObject4	Object
      //   143	5	4	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   18	23	80	finally
      //   18	23	135	android/database/sqlite/SQLiteException
      //   25	29	139	android/database/sqlite/SQLiteException
      //   25	29	143	finally
    }
  }
  
  private static class c
    extends SQLiteOpenHelper
  {
    private static final String a = "CREATE TABLE PushShareInfo (" + c.e.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.e.b.name() + " LONG NOT NULL DEFAULT ((0)), " + c.e.c.name() + " INTEGER DEFAULT ((0)), " + c.e.d.name() + " TEXT, " + c.e.e.name() + " TEXT, " + c.e.f.name() + " TEXT, " + c.e.g.name() + " TEXT, " + c.e.h.name() + " TEXT, " + c.e.i.name() + " TEXT, " + c.e.j.name() + " TEXT" + ");";
    private static final String b = "CREATE TABLE PushVerifInfo (" + c.f.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.f.b.name() + " TEXT NOT NULL, " + c.f.c.name() + " TEXT NOT NULL, " + c.f.d.name() + " TEXT, " + c.f.e.name() + " TEXT" + ");";
    private static final String c = "CREATE TABLE PushMsgInfos (" + c.d.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.d.b.name() + "  TEXT, " + c.d.c.name() + "  INTEGER NOT NULL, " + c.d.d.name() + " LONG NOT NULL, " + c.d.f.name() + " TEXT, " + c.d.g.name() + "  TEXT, " + c.d.h.name() + "  LONG, " + c.d.i.name() + "  INTEGER, " + c.d.e.name() + " LONG NOT NULL" + ");";
    private static final String d = "CREATE TABLE PushAppStatus (" + c.a.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.a.b.name() + " TEXT NOT NULL, " + c.a.c.name() + " LONG NOT NULL, " + c.a.e.name() + " TEXT, " + c.a.f.name() + " INTEGER, " + c.a.g.name() + " TEXT, " + c.a.h.name() + " INTEGER" + ");";
    
    public c(Context paramContext, String paramString, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
    {
      super(paramString, null, paramInt, paramDatabaseErrorHandler);
    }
    
    public c(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
      super(paramString, paramCursorFactory, paramInt);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL(a);
        paramSQLiteDatabase.execSQL(b);
        paramSQLiteDatabase.execSQL(c);
        paramSQLiteDatabase.execSQL(d);
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (paramInt1 <= 1)
      {
        a(paramSQLiteDatabase);
        onCreate(paramSQLiteDatabase);
      }
      do
      {
        return;
        if (paramInt1 == 2)
        {
          paramSQLiteDatabase.execSQL(c);
          paramSQLiteDatabase.execSQL(d);
          return;
        }
      } while (paramInt1 != 3);
      paramSQLiteDatabase.execSQL(d);
    }
  }
  
  public static enum d
  {
    private d() {}
  }
  
  public static enum e
  {
    private e() {}
  }
  
  public static enum f
  {
    private f() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */