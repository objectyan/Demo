package com.baidu.android.pushservice.d;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.b;
import com.baidu.android.pushservice.h.f;
import com.baidu.android.pushservice.h.i;
import com.baidu.android.pushservice.h.j;
import com.baidu.android.pushservice.h.k;
import com.baidu.android.pushservice.h.n;
import com.baidu.android.pushservice.j.p;
import java.io.File;
import java.io.FileFilter;

public class a
{
  private static e a = null;
  private static d b = null;
  private static final Object c = new Object();
  private static int d = 100;
  
  public static int a(Context paramContext, long paramLong1, long paramLong2)
  {
    Object localObject1 = null;
    Cursor localCursor = null;
    int i = 0;
    synchronized (c)
    {
      localSQLiteDatabase = e(paramContext);
      if (localSQLiteDatabase == null) {
        return 0;
      }
      String str = "SELECT COUNT(*) FROM PushBehavior WHERE " + c.c.name() + " < " + paramLong1 + " AND " + c.c.name() + " >= " + paramLong2 + " ;";
      paramContext = localCursor;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery(str, null);
        paramContext = localCursor;
        localObject1 = localCursor;
        localCursor.moveToFirst();
        paramContext = localCursor;
        localObject1 = localCursor;
        int j = localCursor.getInt(0);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (paramContext != null) {
            paramContext.close();
          }
          localSQLiteDatabase.close();
        }
      }
      finally
      {
        if (localException == null) {
          break label207;
        }
        localException.close();
        localSQLiteDatabase.close();
      }
      return i;
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: aload_0
    //   7: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +7 -> 21
    //   17: aload_3
    //   18: monitorexit
    //   19: iconst_m1
    //   20: ireturn
    //   21: aload 4
    //   23: ldc 113
    //   25: aconst_null
    //   26: new 62	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   33: getstatic 116	com/baidu/android/pushservice/d/a$a:b	Lcom/baidu/android/pushservice/d/a$a;
    //   36: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   39: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 119
    //   44: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 121
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore_0
    //   67: aload_0
    //   68: ifnonnull +28 -> 96
    //   71: aload_0
    //   72: ifnull +9 -> 81
    //   75: aload_0
    //   76: invokeinterface 109 1 0
    //   81: aload 4
    //   83: ifnull +8 -> 91
    //   86: aload 4
    //   88: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   91: aload_3
    //   92: monitorexit
    //   93: bipush -2
    //   95: ireturn
    //   96: aload_0
    //   97: invokeinterface 129 1 0
    //   102: ifle +61 -> 163
    //   105: aload 4
    //   107: new 62	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   114: ldc -125
    //   116: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 133	com/baidu/android/pushservice/d/a$a:f	Lcom/baidu/android/pushservice/d/a$a;
    //   122: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   125: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 119
    //   130: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload_2
    //   134: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc -118
    //   139: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: getstatic 116	com/baidu/android/pushservice/d/a$a:b	Lcom/baidu/android/pushservice/d/a$a;
    //   145: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: ldc 119
    //   150: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokevirtual 145	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: ifnull +9 -> 173
    //   167: aload_0
    //   168: invokeinterface 109 1 0
    //   173: aload 4
    //   175: ifnull +84 -> 259
    //   178: aload 4
    //   180: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   183: iconst_0
    //   184: istore_2
    //   185: aload_3
    //   186: monitorexit
    //   187: iload_2
    //   188: ireturn
    //   189: astore_0
    //   190: aload_3
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +9 -> 207
    //   201: aload_0
    //   202: invokeinterface 109 1 0
    //   207: aload 4
    //   209: ifnull +44 -> 253
    //   212: aload 4
    //   214: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   217: bipush -3
    //   219: istore_2
    //   220: goto -35 -> 185
    //   223: aload_0
    //   224: ifnull +9 -> 233
    //   227: aload_0
    //   228: invokeinterface 109 1 0
    //   233: aload 4
    //   235: ifnull +8 -> 243
    //   238: aload 4
    //   240: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: goto -23 -> 223
    //   249: astore_1
    //   250: goto -53 -> 197
    //   253: bipush -3
    //   255: istore_2
    //   256: goto -71 -> 185
    //   259: iconst_0
    //   260: istore_2
    //   261: goto -76 -> 185
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_0
    //   267: goto -44 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramContext	Context
    //   0	270	1	paramString	String
    //   0	270	2	paramInt	int
    //   3	188	3	localObject	Object
    //   10	229	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   6	12	189	finally
    //   17	19	189	finally
    //   75	81	189	finally
    //   86	91	189	finally
    //   91	93	189	finally
    //   167	173	189	finally
    //   178	183	189	finally
    //   185	187	189	finally
    //   190	192	189	finally
    //   201	207	189	finally
    //   212	217	189	finally
    //   227	233	189	finally
    //   238	243	189	finally
    //   243	245	189	finally
    //   21	67	194	java/lang/Exception
    //   96	163	245	finally
    //   96	163	249	java/lang/Exception
    //   21	67	264	finally
  }
  
  public static int a(Context paramContext, String paramString, g paramg)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return 0;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(f.a.name(), paramg.a);
      localContentValues.put(f.b.name(), paramg.b);
      localContentValues.put(f.c.name(), paramg.c);
      localContentValues.put(f.d.name(), paramg.d);
      localContentValues.put(f.e.name(), paramg.e);
      localContentValues.put(f.f.name(), paramg.f);
      localContentValues.put(f.g.name(), Integer.valueOf(paramg.g));
      localContentValues.put(f.h.name(), Integer.valueOf(paramg.h));
      localContentValues.put(f.i.name(), Integer.valueOf(paramg.i));
      localContentValues.put(f.j.name(), Long.valueOf(System.currentTimeMillis()));
      int i = -1;
      try
      {
        int j = paramContext.update("FileDownloadingInfo", localContentValues, f.b.name() + "=?", new String[] { paramString });
        i = j;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
      paramContext.close();
      return i;
    }
  }
  
  private static int a(SQLiteDatabase paramSQLiteDatabase, j paramj)
  {
    if (paramSQLiteDatabase == null) {
      return 0;
    }
    String str = paramj.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(b.d.name(), paramj.b());
    if (!TextUtils.isEmpty(paramj.a())) {
      localContentValues.put(b.b.name(), paramj.a());
    }
    localContentValues.put(b.c.name(), Integer.valueOf(paramj.h()));
    localContentValues.put(b.e.name(), paramj.c());
    if (!TextUtils.isEmpty(paramj.d())) {
      localContentValues.put(b.f.name(), paramj.d());
    }
    localContentValues.put(b.g.name(), Integer.valueOf(paramj.e()));
    localContentValues.put(b.h.name(), paramj.f());
    localContentValues.put(b.i.name(), Integer.valueOf(paramj.g()));
    try
    {
      int i = paramSQLiteDatabase.update("AppInfo", localContentValues, b.d.name() + " =?", new String[] { str });
      return i;
    }
    catch (Exception paramSQLiteDatabase) {}
    return -1;
  }
  
  public static long a(Context paramContext, g paramg)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(f.a.name(), paramg.a);
      localContentValues.put(f.b.name(), paramg.b);
      localContentValues.put(f.c.name(), paramg.c);
      localContentValues.put(f.d.name(), paramg.d);
      localContentValues.put(f.e.name(), paramg.e);
      localContentValues.put(f.f.name(), paramg.f);
      localContentValues.put(f.g.name(), Integer.valueOf(paramg.g));
      localContentValues.put(f.h.name(), Integer.valueOf(paramg.h));
      localContentValues.put(f.i.name(), Integer.valueOf(paramg.i));
      localContentValues.put(f.j.name(), Long.valueOf(System.currentTimeMillis()));
      long l1 = 0L;
      try
      {
        long l2 = paramContext.insert("FileDownloadingInfo", null, localContentValues);
        l1 = l2;
      }
      catch (Exception paramg)
      {
        for (;;) {}
      }
      paramContext.close();
      return l1;
    }
  }
  
  public static long a(Context paramContext, com.baidu.android.pushservice.h.a parama)
  {
    long l1 = -1L;
    synchronized (c)
    {
      SQLiteDatabase localSQLiteDatabase = e(paramContext);
      if (localSQLiteDatabase == null) {
        return -1L;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(a.b.name(), parama.a);
      localContentValues.put(a.c.name(), Long.valueOf(parama.b));
      localContentValues.put(a.d.name(), Long.valueOf(parama.c));
      localContentValues.put(a.e.name(), Long.valueOf(parama.d));
      localContentValues.put(a.g.name(), Integer.valueOf(parama.e));
      localContentValues.put(a.f.name(), Integer.valueOf(parama.f));
      try
      {
        long l2 = localSQLiteDatabase.insert("AlarmMsgInfo", null, localContentValues);
        l1 = l2;
        p.b("AlarmMsgInfoEnum:  insert into database", paramContext);
        l1 = l2;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      localSQLiteDatabase.close();
      return l1;
    }
  }
  
  public static long a(Context paramContext, b paramb)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(c.b.name(), paramb.d);
      localContentValues.put(c.c.name(), Long.valueOf(paramb.e));
      localContentValues.put(c.d.name(), paramb.f);
      localContentValues.put(c.l.name(), paramb.h);
      localContentValues.put(c.h.name(), paramb.a);
      localContentValues.put(c.i.name(), paramb.b);
      localContentValues.put(c.k.name(), Integer.valueOf(paramb.g));
      localContentValues.put(c.o.name(), paramb.j);
      if (paramb.c != null) {
        localContentValues.put(c.m.name(), paramb.c);
      }
      long l1 = 0L;
      try
      {
        long l2 = paramContext.insert("PushBehavior", null, localContentValues);
        l1 = l2;
      }
      catch (Exception paramb)
      {
        for (;;) {}
      }
      paramContext.close();
      return l1;
    }
  }
  
  public static long a(Context paramContext, f paramf)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(c.b.name(), paramf.d);
      localContentValues.put(c.c.name(), Long.valueOf(paramf.e));
      localContentValues.put(c.d.name(), paramf.f);
      localContentValues.put(c.h.name(), paramf.a);
      localContentValues.put(c.l.name(), paramf.h);
      long l1 = 0L;
      try
      {
        long l2 = paramContext.insert("PushBehavior", null, localContentValues);
        l1 = l2;
      }
      catch (Exception paramf)
      {
        for (;;) {}
      }
      paramContext.close();
      return l1;
    }
  }
  
  public static long a(Context paramContext, i parami)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(c.b.name(), parami.d);
      localContentValues.put(c.c.name(), Long.valueOf(parami.e));
      localContentValues.put(c.d.name(), parami.f);
      localContentValues.put(c.h.name(), parami.i);
      localContentValues.put(c.j.name(), Integer.valueOf(parami.a));
      localContentValues.put(c.k.name(), Integer.valueOf(parami.g));
      localContentValues.put(c.l.name(), parami.h);
      localContentValues.put(c.f.name(), parami.b);
      localContentValues.put(c.n.name(), parami.c);
      long l1 = 0L;
      try
      {
        long l2 = paramContext.insert("PushBehavior", null, localContentValues);
        l1 = l2;
      }
      catch (Exception parami)
      {
        for (;;) {}
      }
      paramContext.close();
      return l1;
    }
  }
  
  public static long a(Context paramContext, j paramj)
  {
    long l1 = 0L;
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      if (b(paramContext, paramj))
      {
        paramContext.close();
        return 0L;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(b.b.name(), paramj.a());
    localContentValues.put(b.c.name(), Integer.valueOf(paramj.h()));
    localContentValues.put(b.d.name(), paramj.b());
    localContentValues.put(b.e.name(), paramj.c());
    localContentValues.put(b.f.name(), paramj.d());
    localContentValues.put(b.g.name(), Integer.valueOf(paramj.e()));
    localContentValues.put(b.h.name(), paramj.f());
    localContentValues.put(b.i.name(), Integer.valueOf(paramj.g()));
    try
    {
      long l2 = paramContext.insert("AppInfo", null, localContentValues);
      l1 = l2;
    }
    catch (Exception paramj)
    {
      for (;;) {}
    }
    paramContext.close();
    return l1;
  }
  
  public static long a(Context paramContext, k paramk)
  {
    long l1 = -1L;
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(c.b.name(), paramk.d);
      localContentValues.put(c.c.name(), Long.valueOf(paramk.e));
      localContentValues.put(c.d.name(), paramk.f);
      if (paramk.h != null) {
        localContentValues.put(c.l.name(), paramk.h);
      }
      localContentValues.put(c.e.name(), Integer.valueOf(paramk.c));
      localContentValues.put(c.f.name(), paramk.a);
      localContentValues.put(c.g.name(), Integer.valueOf(paramk.b));
      localContentValues.put(c.k.name(), Integer.valueOf(paramk.g));
      if (paramk.k != null) {
        localContentValues.put(c.n.name(), paramk.k);
      }
      if (!TextUtils.isEmpty(paramk.j)) {
        localContentValues.put(c.o.name(), paramk.j);
      }
      try
      {
        long l2 = paramContext.insert("PushBehavior", null, localContentValues);
        l1 = l2;
      }
      catch (Exception paramk)
      {
        for (;;) {}
      }
      paramContext.close();
      return l1;
    }
    paramContext.close();
    return -1L;
  }
  
  /* Error */
  public static long a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   3: astore 11
    //   5: aload 11
    //   7: monitorenter
    //   8: ldc2_w 276
    //   11: lstore 6
    //   13: aload_0
    //   14: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 12
    //   19: aload 12
    //   21: ifnonnull +10 -> 31
    //   24: aload 11
    //   26: monitorexit
    //   27: ldc2_w 276
    //   30: lreturn
    //   31: aconst_null
    //   32: astore 10
    //   34: getstatic 405	com/baidu/android/pushservice/d/a$i:a	Lcom/baidu/android/pushservice/d/a$i;
    //   37: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   40: astore_0
    //   41: new 62	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   48: getstatic 405	com/baidu/android/pushservice/d/a$i:a	Lcom/baidu/android/pushservice/d/a$i;
    //   51: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   54: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 408
    //   60: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 13
    //   68: aload 12
    //   70: ldc_w 410
    //   73: iconst_1
    //   74: anewarray 223	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: aload 13
    //   83: iconst_1
    //   84: anewarray 223	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: aastore
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore_0
    //   98: lload 6
    //   100: lstore 8
    //   102: new 148	android/content/ContentValues
    //   105: dup
    //   106: invokespecial 149	android/content/ContentValues:<init>	()V
    //   109: astore 10
    //   111: lload 6
    //   113: lstore 8
    //   115: aload 10
    //   117: getstatic 405	com/baidu/android/pushservice/d/a$i:a	Lcom/baidu/android/pushservice/d/a$i;
    //   120: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   123: aload_1
    //   124: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: lload 6
    //   129: lstore 8
    //   131: aload 10
    //   133: getstatic 412	com/baidu/android/pushservice/d/a$i:b	Lcom/baidu/android/pushservice/d/a$i;
    //   136: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   139: iload_2
    //   140: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   146: lload 6
    //   148: lstore 8
    //   150: aload 10
    //   152: getstatic 414	com/baidu/android/pushservice/d/a$i:c	Lcom/baidu/android/pushservice/d/a$i;
    //   155: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   158: iload_3
    //   159: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   165: lload 6
    //   167: lstore 8
    //   169: aload 10
    //   171: getstatic 416	com/baidu/android/pushservice/d/a$i:d	Lcom/baidu/android/pushservice/d/a$i;
    //   174: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   177: iload 4
    //   179: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   185: lload 6
    //   187: lstore 8
    //   189: aload 10
    //   191: getstatic 418	com/baidu/android/pushservice/d/a$i:e	Lcom/baidu/android/pushservice/d/a$i;
    //   194: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   197: iload 5
    //   199: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokevirtual 193	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   205: aload_0
    //   206: ifnull +185 -> 391
    //   209: lload 6
    //   211: lstore 8
    //   213: aload_0
    //   214: invokeinterface 421 1 0
    //   219: ifeq +172 -> 391
    //   222: iload_2
    //   223: ifne +115 -> 338
    //   226: iload_3
    //   227: ifne +111 -> 338
    //   230: iload 4
    //   232: ifne +106 -> 338
    //   235: iload 5
    //   237: ifne +101 -> 338
    //   240: lload 6
    //   242: lstore 8
    //   244: aload 12
    //   246: ldc_w 410
    //   249: new 62	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   256: getstatic 405	com/baidu/android/pushservice/d/a$i:a	Lcom/baidu/android/pushservice/d/a$i;
    //   259: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   262: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 408
    //   268: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: iconst_1
    //   275: anewarray 223	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: aload_1
    //   281: aastore
    //   282: invokevirtual 425	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   285: i2l
    //   286: lstore 6
    //   288: aload_0
    //   289: ifnull +13 -> 302
    //   292: lload 6
    //   294: lstore 8
    //   296: aload_0
    //   297: invokeinterface 109 1 0
    //   302: aload_0
    //   303: ifnull +9 -> 312
    //   306: aload_0
    //   307: invokeinterface 109 1 0
    //   312: lload 6
    //   314: lstore 8
    //   316: aload 12
    //   318: ifnull +163 -> 481
    //   321: aload 12
    //   323: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   326: aload 11
    //   328: monitorexit
    //   329: lload 6
    //   331: lreturn
    //   332: astore_0
    //   333: aload 11
    //   335: monitorexit
    //   336: aload_0
    //   337: athrow
    //   338: lload 6
    //   340: lstore 8
    //   342: aload 12
    //   344: ldc_w 410
    //   347: aload 10
    //   349: new 62	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   356: getstatic 405	com/baidu/android/pushservice/d/a$i:a	Lcom/baidu/android/pushservice/d/a$i;
    //   359: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   362: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 408
    //   368: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: iconst_1
    //   375: anewarray 223	java/lang/String
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: aastore
    //   382: invokevirtual 227	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   385: i2l
    //   386: lstore 6
    //   388: goto -100 -> 288
    //   391: lload 6
    //   393: lstore 8
    //   395: aload 12
    //   397: ldc_w 410
    //   400: aconst_null
    //   401: aload 10
    //   403: invokevirtual 281	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   406: lstore 6
    //   408: goto -120 -> 288
    //   411: astore_0
    //   412: aconst_null
    //   413: astore_0
    //   414: aload_0
    //   415: ifnull +9 -> 424
    //   418: aload_0
    //   419: invokeinterface 109 1 0
    //   424: lload 6
    //   426: lstore 8
    //   428: aload 12
    //   430: ifnull +51 -> 481
    //   433: aload 12
    //   435: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   438: goto -112 -> 326
    //   441: aload_1
    //   442: ifnull +9 -> 451
    //   445: aload_1
    //   446: invokeinterface 109 1 0
    //   451: aload 12
    //   453: ifnull +8 -> 461
    //   456: aload 12
    //   458: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   461: aload_0
    //   462: athrow
    //   463: astore 10
    //   465: aload_0
    //   466: astore_1
    //   467: aload 10
    //   469: astore_0
    //   470: goto -29 -> 441
    //   473: astore_1
    //   474: lload 8
    //   476: lstore 6
    //   478: goto -64 -> 414
    //   481: lload 8
    //   483: lstore 6
    //   485: goto -159 -> 326
    //   488: astore_0
    //   489: aload 10
    //   491: astore_1
    //   492: goto -51 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	paramContext	Context
    //   0	495	1	paramString	String
    //   0	495	2	paramInt1	int
    //   0	495	3	paramInt2	int
    //   0	495	4	paramInt3	int
    //   0	495	5	paramInt4	int
    //   11	473	6	l1	long
    //   100	382	8	l2	long
    //   32	370	10	localContentValues	ContentValues
    //   463	27	10	localObject1	Object
    //   3	331	11	localObject2	Object
    //   17	440	12	localSQLiteDatabase	SQLiteDatabase
    //   66	16	13	str	String
    // Exception table:
    //   from	to	target	type
    //   13	19	332	finally
    //   24	27	332	finally
    //   306	312	332	finally
    //   321	326	332	finally
    //   326	329	332	finally
    //   333	336	332	finally
    //   418	424	332	finally
    //   433	438	332	finally
    //   445	451	332	finally
    //   456	461	332	finally
    //   461	463	332	finally
    //   34	98	411	java/lang/Exception
    //   102	111	463	finally
    //   115	127	463	finally
    //   131	146	463	finally
    //   150	165	463	finally
    //   169	185	463	finally
    //   189	205	463	finally
    //   213	222	463	finally
    //   244	288	463	finally
    //   296	302	463	finally
    //   342	388	463	finally
    //   395	408	463	finally
    //   102	111	473	java/lang/Exception
    //   115	127	473	java/lang/Exception
    //   131	146	473	java/lang/Exception
    //   150	165	473	java/lang/Exception
    //   169	185	473	java/lang/Exception
    //   189	205	473	java/lang/Exception
    //   213	222	473	java/lang/Exception
    //   244	288	473	java/lang/Exception
    //   296	302	473	java/lang/Exception
    //   342	388	473	java/lang/Exception
    //   395	408	473	java/lang/Exception
    //   34	98	488	finally
  }
  
  /* Error */
  public static g a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   7: astore 4
    //   9: aload 4
    //   11: monitorenter
    //   12: aload_0
    //   13: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnonnull +8 -> 28
    //   23: aload 4
    //   25: monitorexit
    //   26: aconst_null
    //   27: areturn
    //   28: new 62	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 428
    //   38: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: getstatic 162	com/baidu/android/pushservice/d/a$f:b	Lcom/baidu/android/pushservice/d/a$f;
    //   44: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   47: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 430
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 432
    //   59: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_0
    //   66: aload 5
    //   68: ldc -37
    //   70: aconst_null
    //   71: aload_0
    //   72: iconst_1
    //   73: anewarray 223	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore_0
    //   87: aload_0
    //   88: invokeinterface 102 1 0
    //   93: ifeq +327 -> 420
    //   96: new 26	com/baidu/android/pushservice/d/a$g
    //   99: dup
    //   100: invokespecial 433	com/baidu/android/pushservice/d/a$g:<init>	()V
    //   103: astore_1
    //   104: aload_1
    //   105: aload_0
    //   106: aload_0
    //   107: getstatic 152	com/baidu/android/pushservice/d/a$f:a	Lcom/baidu/android/pushservice/d/a$f;
    //   110: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   113: invokeinterface 437 2 0
    //   118: invokeinterface 441 2 0
    //   123: putfield 156	com/baidu/android/pushservice/d/a$g:a	Ljava/lang/String;
    //   126: aload_1
    //   127: aload_0
    //   128: aload_0
    //   129: getstatic 162	com/baidu/android/pushservice/d/a$f:b	Lcom/baidu/android/pushservice/d/a$f;
    //   132: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   135: invokeinterface 437 2 0
    //   140: invokeinterface 441 2 0
    //   145: putfield 164	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   148: aload_1
    //   149: aload_0
    //   150: aload_0
    //   151: getstatic 166	com/baidu/android/pushservice/d/a$f:c	Lcom/baidu/android/pushservice/d/a$f;
    //   154: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   157: invokeinterface 437 2 0
    //   162: invokeinterface 441 2 0
    //   167: putfield 168	com/baidu/android/pushservice/d/a$g:c	Ljava/lang/String;
    //   170: aload_1
    //   171: aload_0
    //   172: aload_0
    //   173: getstatic 170	com/baidu/android/pushservice/d/a$f:d	Lcom/baidu/android/pushservice/d/a$f;
    //   176: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   179: invokeinterface 437 2 0
    //   184: invokeinterface 441 2 0
    //   189: putfield 172	com/baidu/android/pushservice/d/a$g:d	Ljava/lang/String;
    //   192: aload_1
    //   193: aload_0
    //   194: aload_0
    //   195: getstatic 174	com/baidu/android/pushservice/d/a$f:e	Lcom/baidu/android/pushservice/d/a$f;
    //   198: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   201: invokeinterface 437 2 0
    //   206: invokeinterface 441 2 0
    //   211: putfield 176	com/baidu/android/pushservice/d/a$g:e	Ljava/lang/String;
    //   214: aload_1
    //   215: aload_0
    //   216: aload_0
    //   217: getstatic 178	com/baidu/android/pushservice/d/a$f:f	Lcom/baidu/android/pushservice/d/a$f;
    //   220: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   223: invokeinterface 437 2 0
    //   228: invokeinterface 441 2 0
    //   233: putfield 180	com/baidu/android/pushservice/d/a$g:f	Ljava/lang/String;
    //   236: aload_1
    //   237: aload_0
    //   238: aload_0
    //   239: getstatic 182	com/baidu/android/pushservice/d/a$f:g	Lcom/baidu/android/pushservice/d/a$f;
    //   242: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   245: invokeinterface 437 2 0
    //   250: invokeinterface 106 2 0
    //   255: putfield 184	com/baidu/android/pushservice/d/a$g:g	I
    //   258: aload_1
    //   259: aload_0
    //   260: aload_0
    //   261: getstatic 195	com/baidu/android/pushservice/d/a$f:h	Lcom/baidu/android/pushservice/d/a$f;
    //   264: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   267: invokeinterface 437 2 0
    //   272: invokeinterface 106 2 0
    //   277: putfield 197	com/baidu/android/pushservice/d/a$g:h	I
    //   280: aload_1
    //   281: aload_0
    //   282: aload_0
    //   283: getstatic 199	com/baidu/android/pushservice/d/a$f:i	Lcom/baidu/android/pushservice/d/a$f;
    //   286: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   289: invokeinterface 437 2 0
    //   294: invokeinterface 106 2 0
    //   299: putfield 201	com/baidu/android/pushservice/d/a$g:i	I
    //   302: aload_1
    //   303: aload_0
    //   304: aload_0
    //   305: getstatic 203	com/baidu/android/pushservice/d/a$f:j	Lcom/baidu/android/pushservice/d/a$f;
    //   308: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   311: invokeinterface 437 2 0
    //   316: invokeinterface 445 2 0
    //   321: putfield 447	com/baidu/android/pushservice/d/a$g:j	J
    //   324: aload_0
    //   325: ifnull +9 -> 334
    //   328: aload_0
    //   329: invokeinterface 109 1 0
    //   334: aload 5
    //   336: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   339: aload 4
    //   341: monitorexit
    //   342: aload_1
    //   343: areturn
    //   344: astore_0
    //   345: aload 4
    //   347: monitorexit
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: aconst_null
    //   352: astore_0
    //   353: aload_2
    //   354: astore_1
    //   355: aload_1
    //   356: ifnull +9 -> 365
    //   359: aload_1
    //   360: invokeinterface 109 1 0
    //   365: aload 5
    //   367: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   370: aload_0
    //   371: astore_1
    //   372: goto -33 -> 339
    //   375: aload_1
    //   376: ifnull +9 -> 385
    //   379: aload_1
    //   380: invokeinterface 109 1 0
    //   385: aload 5
    //   387: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   390: aload_0
    //   391: athrow
    //   392: astore_2
    //   393: aload_0
    //   394: astore_1
    //   395: aload_2
    //   396: astore_0
    //   397: goto -22 -> 375
    //   400: astore_1
    //   401: aconst_null
    //   402: astore_2
    //   403: aload_0
    //   404: astore_1
    //   405: aload_2
    //   406: astore_0
    //   407: goto -52 -> 355
    //   410: astore_2
    //   411: aload_0
    //   412: astore_2
    //   413: aload_1
    //   414: astore_0
    //   415: aload_2
    //   416: astore_1
    //   417: goto -62 -> 355
    //   420: aconst_null
    //   421: astore_1
    //   422: goto -98 -> 324
    //   425: astore_0
    //   426: aload_3
    //   427: astore_1
    //   428: goto -53 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramContext	Context
    //   0	431	1	paramString	String
    //   3	351	2	localObject1	Object
    //   392	4	2	localObject2	Object
    //   402	4	2	localObject3	Object
    //   410	1	2	localException	Exception
    //   412	4	2	localContext	Context
    //   1	426	3	localObject4	Object
    //   7	339	4	localObject5	Object
    //   16	370	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   12	18	344	finally
    //   23	26	344	finally
    //   28	66	344	finally
    //   328	334	344	finally
    //   334	339	344	finally
    //   339	342	344	finally
    //   345	348	344	finally
    //   359	365	344	finally
    //   365	370	344	finally
    //   379	385	344	finally
    //   385	392	344	finally
    //   66	87	350	java/lang/Exception
    //   87	104	392	finally
    //   104	324	392	finally
    //   87	104	400	java/lang/Exception
    //   104	324	410	java/lang/Exception
    //   66	87	425	finally
  }
  
  /* Error */
  public static java.util.List<j> a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: aload_0
    //   9: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnonnull +7 -> 23
    //   19: aload_3
    //   20: monitorexit
    //   21: aconst_null
    //   22: areturn
    //   23: new 450	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 451	java/util/ArrayList:<init>	()V
    //   30: astore_2
    //   31: aload 4
    //   33: ldc_w 453
    //   36: aconst_null
    //   37: invokevirtual 96	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_0
    //   41: aload_0
    //   42: astore_1
    //   43: aload_0
    //   44: invokeinterface 421 1 0
    //   49: ifeq +248 -> 297
    //   52: aload_0
    //   53: astore_1
    //   54: new 230	com/baidu/android/pushservice/h/j
    //   57: dup
    //   58: invokespecial 454	com/baidu/android/pushservice/h/j:<init>	()V
    //   61: astore 5
    //   63: aload_0
    //   64: astore_1
    //   65: aload 5
    //   67: aload_0
    //   68: aload_0
    //   69: getstatic 246	com/baidu/android/pushservice/d/a$b:b	Lcom/baidu/android/pushservice/d/a$b;
    //   72: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   75: invokeinterface 437 2 0
    //   80: invokeinterface 441 2 0
    //   85: invokevirtual 456	com/baidu/android/pushservice/h/j:a	(Ljava/lang/String;)V
    //   88: aload_0
    //   89: astore_1
    //   90: aload 5
    //   92: aload_0
    //   93: aload_0
    //   94: getstatic 248	com/baidu/android/pushservice/d/a$b:c	Lcom/baidu/android/pushservice/d/a$b;
    //   97: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   100: invokeinterface 437 2 0
    //   105: invokeinterface 106 2 0
    //   110: invokevirtual 459	com/baidu/android/pushservice/h/j:c	(I)V
    //   113: aload_0
    //   114: astore_1
    //   115: aload 5
    //   117: aload_0
    //   118: aload_0
    //   119: getstatic 235	com/baidu/android/pushservice/d/a$b:d	Lcom/baidu/android/pushservice/d/a$b;
    //   122: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   125: invokeinterface 437 2 0
    //   130: invokeinterface 441 2 0
    //   135: invokevirtual 461	com/baidu/android/pushservice/h/j:b	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: astore_1
    //   140: aload 5
    //   142: aload_0
    //   143: aload_0
    //   144: getstatic 252	com/baidu/android/pushservice/d/a$b:e	Lcom/baidu/android/pushservice/d/a$b;
    //   147: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   150: invokeinterface 437 2 0
    //   155: invokeinterface 441 2 0
    //   160: invokevirtual 463	com/baidu/android/pushservice/h/j:c	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: astore_1
    //   165: aload 5
    //   167: aload_0
    //   168: aload_0
    //   169: getstatic 258	com/baidu/android/pushservice/d/a$b:f	Lcom/baidu/android/pushservice/d/a$b;
    //   172: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   175: invokeinterface 437 2 0
    //   180: invokeinterface 441 2 0
    //   185: invokevirtual 465	com/baidu/android/pushservice/h/j:d	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: astore_1
    //   190: aload 5
    //   192: aload_0
    //   193: aload_0
    //   194: getstatic 260	com/baidu/android/pushservice/d/a$b:g	Lcom/baidu/android/pushservice/d/a$b;
    //   197: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   200: invokeinterface 437 2 0
    //   205: invokeinterface 106 2 0
    //   210: invokevirtual 467	com/baidu/android/pushservice/h/j:a	(I)V
    //   213: aload_0
    //   214: astore_1
    //   215: aload 5
    //   217: aload_0
    //   218: aload_0
    //   219: getstatic 264	com/baidu/android/pushservice/d/a$b:h	Lcom/baidu/android/pushservice/d/a$b;
    //   222: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   225: invokeinterface 437 2 0
    //   230: invokeinterface 441 2 0
    //   235: invokevirtual 469	com/baidu/android/pushservice/h/j:e	(Ljava/lang/String;)V
    //   238: aload_0
    //   239: astore_1
    //   240: aload 5
    //   242: aload_0
    //   243: aload_0
    //   244: getstatic 268	com/baidu/android/pushservice/d/a$b:i	Lcom/baidu/android/pushservice/d/a$b;
    //   247: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   250: invokeinterface 437 2 0
    //   255: invokeinterface 106 2 0
    //   260: invokevirtual 471	com/baidu/android/pushservice/h/j:b	(I)V
    //   263: aload_0
    //   264: astore_1
    //   265: aload_2
    //   266: aload 5
    //   268: invokeinterface 477 2 0
    //   273: pop
    //   274: goto -233 -> 41
    //   277: astore_0
    //   278: aload_1
    //   279: ifnull +9 -> 288
    //   282: aload_1
    //   283: invokeinterface 109 1 0
    //   288: aload 4
    //   290: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   293: aload_3
    //   294: monitorexit
    //   295: aload_2
    //   296: areturn
    //   297: aload_0
    //   298: ifnull +9 -> 307
    //   301: aload_0
    //   302: invokeinterface 109 1 0
    //   307: aload 4
    //   309: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   312: goto -19 -> 293
    //   315: astore_0
    //   316: aload_3
    //   317: monitorexit
    //   318: aload_0
    //   319: athrow
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_2
    //   323: aload_0
    //   324: astore_1
    //   325: aload_2
    //   326: ifnull +9 -> 335
    //   329: aload_2
    //   330: invokeinterface 109 1 0
    //   335: aload 4
    //   337: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   340: aload_1
    //   341: athrow
    //   342: astore_1
    //   343: aload_0
    //   344: astore_2
    //   345: goto -20 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	Context
    //   1	340	1	localContext	Context
    //   342	1	1	localObject1	Object
    //   30	315	2	localObject2	Object
    //   5	312	3	localObject3	Object
    //   12	324	4	localSQLiteDatabase	SQLiteDatabase
    //   61	206	5	localj	j
    // Exception table:
    //   from	to	target	type
    //   31	41	277	java/lang/Exception
    //   43	52	277	java/lang/Exception
    //   54	63	277	java/lang/Exception
    //   65	88	277	java/lang/Exception
    //   90	113	277	java/lang/Exception
    //   115	138	277	java/lang/Exception
    //   140	163	277	java/lang/Exception
    //   165	188	277	java/lang/Exception
    //   190	213	277	java/lang/Exception
    //   215	238	277	java/lang/Exception
    //   240	263	277	java/lang/Exception
    //   265	274	277	java/lang/Exception
    //   8	14	315	finally
    //   19	21	315	finally
    //   23	31	315	finally
    //   282	288	315	finally
    //   288	293	315	finally
    //   293	295	315	finally
    //   301	307	315	finally
    //   307	312	315	finally
    //   316	318	315	finally
    //   329	335	315	finally
    //   335	342	315	finally
    //   31	41	320	finally
    //   43	52	342	finally
    //   54	63	342	finally
    //   65	88	342	finally
    //   90	113	342	finally
    //   115	138	342	finally
    //   140	163	342	finally
    //   165	188	342	finally
    //   190	213	342	finally
    //   215	238	342	finally
    //   240	263	342	finally
    //   265	274	342	finally
  }
  
  /* Error */
  public static java.util.List<com.baidu.android.pushservice.h.e> a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   6: astore 8
    //   8: aload 8
    //   10: monitorenter
    //   11: aload_0
    //   12: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 9
    //   17: aload 9
    //   19: ifnonnull +8 -> 27
    //   22: aload 8
    //   24: monitorexit
    //   25: aconst_null
    //   26: areturn
    //   27: new 450	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 451	java/util/ArrayList:<init>	()V
    //   34: astore 7
    //   36: new 62	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 482
    //   46: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 72	com/baidu/android/pushservice/d/a$c:c	Lcom/baidu/android/pushservice/d/a$c;
    //   52: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 78
    //   60: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: lload_1
    //   64: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc 83
    //   69: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: getstatic 72	com/baidu/android/pushservice/d/a$c:c	Lcom/baidu/android/pushservice/d/a$c;
    //   75: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   78: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 85
    //   83: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: ldc_w 484
    //   93: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload 5
    //   98: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 121
    //   103: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: aload 9
    //   112: aload_0
    //   113: aconst_null
    //   114: invokevirtual 96	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   117: astore_0
    //   118: aload_0
    //   119: astore 6
    //   121: aload_0
    //   122: invokeinterface 421 1 0
    //   127: ifeq +445 -> 572
    //   130: aload_0
    //   131: astore 6
    //   133: new 486	com/baidu/android/pushservice/h/e
    //   136: dup
    //   137: invokespecial 487	com/baidu/android/pushservice/h/e:<init>	()V
    //   140: astore 10
    //   142: aload_0
    //   143: astore 6
    //   145: aload 10
    //   147: aload_0
    //   148: aload_0
    //   149: getstatic 489	com/baidu/android/pushservice/d/a$c:a	Lcom/baidu/android/pushservice/d/a$c;
    //   152: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   155: invokeinterface 437 2 0
    //   160: invokeinterface 106 2 0
    //   165: invokevirtual 490	com/baidu/android/pushservice/h/e:a	(I)V
    //   168: aload_0
    //   169: astore 6
    //   171: aload 10
    //   173: aload_0
    //   174: aload_0
    //   175: getstatic 314	com/baidu/android/pushservice/d/a$c:b	Lcom/baidu/android/pushservice/d/a$c;
    //   178: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   181: invokeinterface 437 2 0
    //   186: invokeinterface 441 2 0
    //   191: invokevirtual 491	com/baidu/android/pushservice/h/e:a	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: astore 6
    //   197: aload 10
    //   199: aload_0
    //   200: aload_0
    //   201: getstatic 325	com/baidu/android/pushservice/d/a$c:l	Lcom/baidu/android/pushservice/d/a$c;
    //   204: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   207: invokeinterface 437 2 0
    //   212: invokeinterface 441 2 0
    //   217: invokevirtual 493	com/baidu/android/pushservice/h/e:f	(Ljava/lang/String;)V
    //   220: aload_0
    //   221: astore 6
    //   223: aload 10
    //   225: aload_0
    //   226: aload_0
    //   227: getstatic 346	com/baidu/android/pushservice/d/a$c:m	Lcom/baidu/android/pushservice/d/a$c;
    //   230: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   233: invokeinterface 437 2 0
    //   238: invokeinterface 441 2 0
    //   243: invokevirtual 495	com/baidu/android/pushservice/h/e:g	(Ljava/lang/String;)V
    //   246: aload_0
    //   247: astore 6
    //   249: aload 10
    //   251: aload_0
    //   252: aload_0
    //   253: getstatic 336	com/baidu/android/pushservice/d/a$c:k	Lcom/baidu/android/pushservice/d/a$c;
    //   256: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   259: invokeinterface 437 2 0
    //   264: invokeinterface 106 2 0
    //   269: invokevirtual 497	com/baidu/android/pushservice/h/e:e	(I)V
    //   272: aload_0
    //   273: astore 6
    //   275: aload 10
    //   277: aload_0
    //   278: aload_0
    //   279: getstatic 329	com/baidu/android/pushservice/d/a$c:h	Lcom/baidu/android/pushservice/d/a$c;
    //   282: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   285: invokeinterface 437 2 0
    //   290: invokeinterface 441 2 0
    //   295: invokevirtual 498	com/baidu/android/pushservice/h/e:d	(Ljava/lang/String;)V
    //   298: aload_0
    //   299: astore 6
    //   301: aload 10
    //   303: aload_0
    //   304: aload_0
    //   305: getstatic 372	com/baidu/android/pushservice/d/a$c:f	Lcom/baidu/android/pushservice/d/a$c;
    //   308: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   311: invokeinterface 437 2 0
    //   316: invokeinterface 441 2 0
    //   321: invokevirtual 499	com/baidu/android/pushservice/h/e:c	(Ljava/lang/String;)V
    //   324: aload_0
    //   325: astore 6
    //   327: aload 10
    //   329: aload_0
    //   330: aload_0
    //   331: getstatic 395	com/baidu/android/pushservice/d/a$c:g	Lcom/baidu/android/pushservice/d/a$c;
    //   334: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   337: invokeinterface 437 2 0
    //   342: invokeinterface 106 2 0
    //   347: invokevirtual 500	com/baidu/android/pushservice/h/e:c	(I)V
    //   350: aload_0
    //   351: astore 6
    //   353: aload 10
    //   355: aload_0
    //   356: aload_0
    //   357: getstatic 390	com/baidu/android/pushservice/d/a$c:e	Lcom/baidu/android/pushservice/d/a$c;
    //   360: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   363: invokeinterface 437 2 0
    //   368: invokeinterface 106 2 0
    //   373: invokevirtual 501	com/baidu/android/pushservice/h/e:b	(I)V
    //   376: aload_0
    //   377: astore 6
    //   379: aload 10
    //   381: aload_0
    //   382: aload_0
    //   383: getstatic 321	com/baidu/android/pushservice/d/a$c:d	Lcom/baidu/android/pushservice/d/a$c;
    //   386: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   389: invokeinterface 437 2 0
    //   394: invokeinterface 441 2 0
    //   399: invokevirtual 502	com/baidu/android/pushservice/h/e:b	(Ljava/lang/String;)V
    //   402: aload_0
    //   403: astore 6
    //   405: aload 10
    //   407: aload_0
    //   408: aload_0
    //   409: getstatic 376	com/baidu/android/pushservice/d/a$c:n	Lcom/baidu/android/pushservice/d/a$c;
    //   412: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   415: invokeinterface 437 2 0
    //   420: invokeinterface 441 2 0
    //   425: invokevirtual 504	com/baidu/android/pushservice/h/e:i	(Ljava/lang/String;)V
    //   428: aload_0
    //   429: astore 6
    //   431: aload 10
    //   433: aload_0
    //   434: aload_0
    //   435: getstatic 332	com/baidu/android/pushservice/d/a$c:i	Lcom/baidu/android/pushservice/d/a$c;
    //   438: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   441: invokeinterface 437 2 0
    //   446: invokeinterface 441 2 0
    //   451: invokevirtual 505	com/baidu/android/pushservice/h/e:e	(Ljava/lang/String;)V
    //   454: aload_0
    //   455: astore 6
    //   457: aload 10
    //   459: aload_0
    //   460: aload_0
    //   461: getstatic 366	com/baidu/android/pushservice/d/a$c:j	Lcom/baidu/android/pushservice/d/a$c;
    //   464: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   467: invokeinterface 437 2 0
    //   472: invokeinterface 106 2 0
    //   477: invokevirtual 507	com/baidu/android/pushservice/h/e:d	(I)V
    //   480: aload_0
    //   481: astore 6
    //   483: aload 10
    //   485: aload_0
    //   486: aload_0
    //   487: getstatic 72	com/baidu/android/pushservice/d/a$c:c	Lcom/baidu/android/pushservice/d/a$c;
    //   490: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   493: invokeinterface 437 2 0
    //   498: invokeinterface 445 2 0
    //   503: invokevirtual 510	com/baidu/android/pushservice/h/e:a	(J)V
    //   506: aload_0
    //   507: astore 6
    //   509: aload 10
    //   511: aload_0
    //   512: aload_0
    //   513: getstatic 340	com/baidu/android/pushservice/d/a$c:o	Lcom/baidu/android/pushservice/d/a$c;
    //   516: invokevirtual 76	com/baidu/android/pushservice/d/a$c:name	()Ljava/lang/String;
    //   519: invokeinterface 437 2 0
    //   524: invokeinterface 441 2 0
    //   529: invokevirtual 512	com/baidu/android/pushservice/h/e:h	(Ljava/lang/String;)V
    //   532: aload_0
    //   533: astore 6
    //   535: aload 7
    //   537: aload 10
    //   539: invokeinterface 477 2 0
    //   544: pop
    //   545: goto -427 -> 118
    //   548: astore_0
    //   549: aload 6
    //   551: ifnull +10 -> 561
    //   554: aload 6
    //   556: invokeinterface 109 1 0
    //   561: aload 9
    //   563: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   566: aload 8
    //   568: monitorexit
    //   569: aload 7
    //   571: areturn
    //   572: aload_0
    //   573: ifnull +9 -> 582
    //   576: aload_0
    //   577: invokeinterface 109 1 0
    //   582: aload 9
    //   584: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   587: goto -21 -> 566
    //   590: astore_0
    //   591: aload 8
    //   593: monitorexit
    //   594: aload_0
    //   595: athrow
    //   596: astore_0
    //   597: aconst_null
    //   598: astore 7
    //   600: aload_0
    //   601: astore 6
    //   603: aload 7
    //   605: ifnull +10 -> 615
    //   608: aload 7
    //   610: invokeinterface 109 1 0
    //   615: aload 9
    //   617: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   620: aload 6
    //   622: athrow
    //   623: astore 6
    //   625: aload_0
    //   626: astore 7
    //   628: goto -25 -> 603
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	paramContext	Context
    //   0	631	1	paramLong1	long
    //   0	631	3	paramLong2	long
    //   0	631	5	paramInt	int
    //   1	620	6	localContext	Context
    //   623	1	6	localObject1	Object
    //   34	593	7	localObject2	Object
    //   6	586	8	localObject3	Object
    //   15	601	9	localSQLiteDatabase	SQLiteDatabase
    //   140	398	10	locale	com.baidu.android.pushservice.h.e
    // Exception table:
    //   from	to	target	type
    //   110	118	548	java/lang/Exception
    //   121	130	548	java/lang/Exception
    //   133	142	548	java/lang/Exception
    //   145	168	548	java/lang/Exception
    //   171	194	548	java/lang/Exception
    //   197	220	548	java/lang/Exception
    //   223	246	548	java/lang/Exception
    //   249	272	548	java/lang/Exception
    //   275	298	548	java/lang/Exception
    //   301	324	548	java/lang/Exception
    //   327	350	548	java/lang/Exception
    //   353	376	548	java/lang/Exception
    //   379	402	548	java/lang/Exception
    //   405	428	548	java/lang/Exception
    //   431	454	548	java/lang/Exception
    //   457	480	548	java/lang/Exception
    //   483	506	548	java/lang/Exception
    //   509	532	548	java/lang/Exception
    //   535	545	548	java/lang/Exception
    //   11	17	590	finally
    //   22	25	590	finally
    //   27	110	590	finally
    //   554	561	590	finally
    //   561	566	590	finally
    //   566	569	590	finally
    //   576	582	590	finally
    //   582	587	590	finally
    //   591	594	590	finally
    //   608	615	590	finally
    //   615	623	590	finally
    //   110	118	596	finally
    //   121	130	623	finally
    //   133	142	623	finally
    //   145	168	623	finally
    //   171	194	623	finally
    //   197	220	623	finally
    //   223	246	623	finally
    //   249	272	623	finally
    //   275	298	623	finally
    //   301	324	623	finally
    //   327	350	623	finally
    //   353	376	623	finally
    //   379	402	623	finally
    //   405	428	623	finally
    //   431	454	623	finally
    //   457	480	623	finally
    //   483	506	623	finally
    //   509	532	623	finally
    //   535	545	623	finally
  }
  
  public static void a()
  {
    synchronized (c)
    {
      try
      {
        if (a != null)
        {
          a.close();
          a = null;
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          a = null;
        }
      }
    }
  }
  
  private static void a(String paramString, Context paramContext)
  {
    paramContext = paramContext.getDatabasePath("pushstat_6.0.0.db").getParentFile();
    if ((paramContext == null) || (!paramContext.isDirectory())) {}
    for (;;)
    {
      return;
      paramString = paramContext.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          if (paramAnonymousFile == null) {}
          do
          {
            return false;
            paramAnonymousFile = paramAnonymousFile.getName();
          } while ((!paramAnonymousFile.contains("pushstat")) || (paramAnonymousFile.contains(this.a)));
          return true;
        }
      });
      if (paramString != null)
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          paramContext = paramString[i];
          if (!paramContext.isDirectory()) {
            paramContext.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, i parami)
  {
    localObject2 = null;
    if (paramSQLiteDatabase == null) {}
    label135:
    do
    {
      return true;
      localObject1 = "SELECT * FROM PushBehavior WHERE " + c.b.name() + " = '" + parami.d + "' AND " + c.k.name() + " = " + parami.g + ";";
      try
      {
        localObject1 = paramSQLiteDatabase.rawQuery((String)localObject1, null);
        localObject2 = localObject1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase = null;
          if (paramSQLiteDatabase != null) {
            paramSQLiteDatabase.close();
          }
        }
      }
      finally
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
      }
      try
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label200;
        }
        localObject2 = localObject1;
        parami.a = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex(c.j.name()));
        localObject2 = localObject1;
        b(paramSQLiteDatabase, parami);
        i = 1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase = (SQLiteDatabase)localObject1;
        break label166;
        i = 0;
        break label135;
      }
      if (i == 0) {
        break;
      }
    } while (localObject1 == null);
    ((Cursor)localObject1).close();
    return true;
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    return false;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return 0;
      }
      int i = -1;
      try
      {
        int j = paramContext.delete("FileDownloadingInfo", f.b.name() + "=?", new String[] { paramString });
        i = j;
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
      paramContext.close();
      return i;
    }
  }
  
  private static int b(SQLiteDatabase paramSQLiteDatabase, i parami)
  {
    if (paramSQLiteDatabase == null) {
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(c.b.name(), parami.d);
    localContentValues.put(c.c.name(), Long.valueOf(parami.e));
    localContentValues.put(c.d.name(), parami.f);
    localContentValues.put(c.j.name(), Integer.valueOf(parami.a + 1));
    localContentValues.put(c.k.name(), Integer.valueOf(parami.g));
    localContentValues.put(c.l.name(), parami.h);
    try
    {
      paramSQLiteDatabase.update("PushBehavior", localContentValues, c.b.name() + " = " + "'" + parami.d + "' AND " + c.k.name() + " = " + parami.g + ";", null);
      return -1;
    }
    catch (Exception paramSQLiteDatabase) {}
    return -1;
  }
  
  public static long b(Context paramContext, i parami)
  {
    long l1 = 0L;
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return -1L;
      }
      if (a(paramContext, parami))
      {
        if (paramContext != null) {
          paramContext.close();
        }
        return 0L;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(c.b.name(), parami.d);
    localContentValues.put(c.c.name(), Long.valueOf(parami.e));
    localContentValues.put(c.d.name(), parami.f);
    localContentValues.put(c.j.name(), Integer.valueOf(1));
    localContentValues.put(c.k.name(), Integer.valueOf(parami.g));
    localContentValues.put(c.l.name(), parami.h);
    try
    {
      long l2 = paramContext.insert("PushBehavior", null, localContentValues);
      l1 = l2;
    }
    catch (Exception parami)
    {
      for (;;) {}
    }
    paramContext.close();
    return l1;
  }
  
  /* Error */
  public static java.util.List<g> b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: new 450	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 451	java/util/ArrayList:<init>	()V
    //   15: astore_2
    //   16: aload_0
    //   17: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnonnull +7 -> 31
    //   27: aload_3
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: aload 4
    //   33: ldc -37
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: new 62	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   47: getstatic 203	com/baidu/android/pushservice/d/a$f:j	Lcom/baidu/android/pushservice/d/a$f;
    //   50: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 554
    //   59: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_0
    //   69: aload_0
    //   70: invokeinterface 421 1 0
    //   75: ifeq +262 -> 337
    //   78: new 26	com/baidu/android/pushservice/d/a$g
    //   81: dup
    //   82: invokespecial 433	com/baidu/android/pushservice/d/a$g:<init>	()V
    //   85: astore_1
    //   86: aload_1
    //   87: aload_0
    //   88: aload_0
    //   89: getstatic 152	com/baidu/android/pushservice/d/a$f:a	Lcom/baidu/android/pushservice/d/a$f;
    //   92: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   95: invokeinterface 437 2 0
    //   100: invokeinterface 441 2 0
    //   105: putfield 156	com/baidu/android/pushservice/d/a$g:a	Ljava/lang/String;
    //   108: aload_1
    //   109: aload_0
    //   110: aload_0
    //   111: getstatic 162	com/baidu/android/pushservice/d/a$f:b	Lcom/baidu/android/pushservice/d/a$f;
    //   114: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   117: invokeinterface 437 2 0
    //   122: invokeinterface 441 2 0
    //   127: putfield 164	com/baidu/android/pushservice/d/a$g:b	Ljava/lang/String;
    //   130: aload_1
    //   131: aload_0
    //   132: aload_0
    //   133: getstatic 166	com/baidu/android/pushservice/d/a$f:c	Lcom/baidu/android/pushservice/d/a$f;
    //   136: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   139: invokeinterface 437 2 0
    //   144: invokeinterface 441 2 0
    //   149: putfield 168	com/baidu/android/pushservice/d/a$g:c	Ljava/lang/String;
    //   152: aload_1
    //   153: aload_0
    //   154: aload_0
    //   155: getstatic 170	com/baidu/android/pushservice/d/a$f:d	Lcom/baidu/android/pushservice/d/a$f;
    //   158: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   161: invokeinterface 437 2 0
    //   166: invokeinterface 441 2 0
    //   171: putfield 172	com/baidu/android/pushservice/d/a$g:d	Ljava/lang/String;
    //   174: aload_1
    //   175: aload_0
    //   176: aload_0
    //   177: getstatic 174	com/baidu/android/pushservice/d/a$f:e	Lcom/baidu/android/pushservice/d/a$f;
    //   180: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   183: invokeinterface 437 2 0
    //   188: invokeinterface 441 2 0
    //   193: putfield 176	com/baidu/android/pushservice/d/a$g:e	Ljava/lang/String;
    //   196: aload_1
    //   197: aload_0
    //   198: aload_0
    //   199: getstatic 178	com/baidu/android/pushservice/d/a$f:f	Lcom/baidu/android/pushservice/d/a$f;
    //   202: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   205: invokeinterface 437 2 0
    //   210: invokeinterface 441 2 0
    //   215: putfield 180	com/baidu/android/pushservice/d/a$g:f	Ljava/lang/String;
    //   218: aload_1
    //   219: aload_0
    //   220: aload_0
    //   221: getstatic 182	com/baidu/android/pushservice/d/a$f:g	Lcom/baidu/android/pushservice/d/a$f;
    //   224: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   227: invokeinterface 437 2 0
    //   232: invokeinterface 106 2 0
    //   237: putfield 184	com/baidu/android/pushservice/d/a$g:g	I
    //   240: aload_1
    //   241: aload_0
    //   242: aload_0
    //   243: getstatic 195	com/baidu/android/pushservice/d/a$f:h	Lcom/baidu/android/pushservice/d/a$f;
    //   246: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   249: invokeinterface 437 2 0
    //   254: invokeinterface 106 2 0
    //   259: putfield 197	com/baidu/android/pushservice/d/a$g:h	I
    //   262: aload_1
    //   263: aload_0
    //   264: aload_0
    //   265: getstatic 199	com/baidu/android/pushservice/d/a$f:i	Lcom/baidu/android/pushservice/d/a$f;
    //   268: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   271: invokeinterface 437 2 0
    //   276: invokeinterface 106 2 0
    //   281: putfield 201	com/baidu/android/pushservice/d/a$g:i	I
    //   284: aload_1
    //   285: aload_0
    //   286: aload_0
    //   287: getstatic 203	com/baidu/android/pushservice/d/a$f:j	Lcom/baidu/android/pushservice/d/a$f;
    //   290: invokevirtual 153	com/baidu/android/pushservice/d/a$f:name	()Ljava/lang/String;
    //   293: invokeinterface 437 2 0
    //   298: invokeinterface 445 2 0
    //   303: putfield 447	com/baidu/android/pushservice/d/a$g:j	J
    //   306: aload_2
    //   307: aload_1
    //   308: invokeinterface 477 2 0
    //   313: pop
    //   314: goto -245 -> 69
    //   317: astore_1
    //   318: aload_0
    //   319: ifnull +9 -> 328
    //   322: aload_0
    //   323: invokeinterface 109 1 0
    //   328: aload 4
    //   330: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   333: aload_3
    //   334: monitorexit
    //   335: aload_2
    //   336: areturn
    //   337: aload_0
    //   338: ifnull +9 -> 347
    //   341: aload_0
    //   342: invokeinterface 109 1 0
    //   347: aload 4
    //   349: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   352: goto -19 -> 333
    //   355: astore_0
    //   356: aload_3
    //   357: monitorexit
    //   358: aload_0
    //   359: athrow
    //   360: astore_2
    //   361: aload_1
    //   362: astore_0
    //   363: aload_2
    //   364: astore_1
    //   365: aload_0
    //   366: ifnull +9 -> 375
    //   369: aload_0
    //   370: invokeinterface 109 1 0
    //   375: aload 4
    //   377: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   380: aload_1
    //   381: athrow
    //   382: astore_1
    //   383: goto -18 -> 365
    //   386: astore_0
    //   387: aconst_null
    //   388: astore_0
    //   389: goto -71 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramContext	Context
    //   1	307	1	localg	g
    //   317	45	1	localException	Exception
    //   364	17	1	localObject1	Object
    //   382	1	1	localObject2	Object
    //   15	321	2	localArrayList	java.util.ArrayList
    //   360	4	2	localObject3	Object
    //   5	352	3	localObject4	Object
    //   20	356	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   69	314	317	java/lang/Exception
    //   8	22	355	finally
    //   27	29	355	finally
    //   322	328	355	finally
    //   328	333	355	finally
    //   333	335	355	finally
    //   341	347	355	finally
    //   347	352	355	finally
    //   356	358	355	finally
    //   369	375	355	finally
    //   375	382	355	finally
    //   31	69	360	finally
    //   69	314	382	finally
    //   31	69	386	java/lang/Exception
  }
  
  public static boolean b(Context paramContext, long paramLong1, long paramLong2)
  {
    localContext = null;
    bool2 = false;
    bool1 = false;
    synchronized (c)
    {
      localSQLiteDatabase = e(paramContext);
      if (localSQLiteDatabase == null) {
        return false;
      }
      paramContext = "SELECT " + c.b.name() + " FROM " + "PushBehavior" + " WHERE " + c.c.name() + " < " + paramLong1 + " AND " + c.c.name() + " >= " + paramLong2 + " ;";
      for (;;)
      {
        try
        {
          paramContext = localSQLiteDatabase.rawQuery(paramContext, null);
          bool2 = bool1;
          localContext = paramContext;
        }
        catch (Exception paramContext)
        {
          bool1 = false;
          paramContext = null;
          if (paramContext != null) {
            paramContext.close();
          }
          if (bool1)
          {
            localSQLiteDatabase.close();
            bool2 = bool1;
            continue;
          }
        }
        finally
        {
          if (localContext != null) {
            localContext.close();
          }
          if (bool2) {
            localSQLiteDatabase.close();
          }
        }
        try
        {
          if (paramContext.moveToNext())
          {
            bool2 = bool1;
            localContext = paramContext;
            String str = paramContext.getString(0);
            bool2 = bool1;
            localContext = paramContext;
            if (!TextUtils.isEmpty(str))
            {
              bool2 = bool1;
              localContext = paramContext;
              boolean bool3 = str.startsWith(n.t);
              if (!bool3) {
                bool1 = true;
              }
            }
          }
          else
          {
            if (paramContext != null) {
              paramContext.close();
            }
            bool2 = bool1;
            if (bool1)
            {
              localSQLiteDatabase.close();
              bool2 = bool1;
            }
          }
        }
        catch (Exception localException)
        {
          continue;
          bool2 = bool1;
        }
      }
      return bool2;
    }
  }
  
  /* Error */
  private static boolean b(SQLiteDatabase paramSQLiteDatabase, j paramj)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: ldc_w 272
    //   12: aconst_null
    //   13: new 62	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   20: getstatic 235	com/baidu/android/pushservice/d/a$b:d	Lcom/baidu/android/pushservice/d/a$b;
    //   23: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   26: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 274
    //   32: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: iconst_1
    //   39: anewarray 223	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: invokevirtual 232	com/baidu/android/pushservice/h/j:b	()Ljava/lang/String;
    //   48: aastore
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_2
    //   59: invokeinterface 421 1 0
    //   64: ifeq +162 -> 226
    //   67: aload_1
    //   68: invokevirtual 256	com/baidu/android/pushservice/h/j:d	()Ljava/lang/String;
    //   71: aload_2
    //   72: aload_2
    //   73: getstatic 258	com/baidu/android/pushservice/d/a$b:f	Lcom/baidu/android/pushservice/d/a$b;
    //   76: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   79: invokeinterface 437 2 0
    //   84: invokeinterface 441 2 0
    //   89: invokestatic 573	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   92: ifeq +116 -> 208
    //   95: new 62	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   102: aload_1
    //   103: invokevirtual 262	com/baidu/android/pushservice/h/j:e	()I
    //   106: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc_w 575
    //   112: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: new 62	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   125: aload_2
    //   126: aload_2
    //   127: getstatic 260	com/baidu/android/pushservice/d/a$b:g	Lcom/baidu/android/pushservice/d/a$b;
    //   130: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   133: invokeinterface 437 2 0
    //   138: invokeinterface 106 2 0
    //   143: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: ldc_w 575
    //   149: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 573	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   158: ifeq +50 -> 208
    //   161: new 62	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   168: aload_1
    //   169: invokevirtual 270	com/baidu/android/pushservice/h/j:g	()I
    //   172: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc_w 575
    //   178: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_2
    //   185: aload_2
    //   186: getstatic 268	com/baidu/android/pushservice/d/a$b:i	Lcom/baidu/android/pushservice/d/a$b;
    //   189: invokevirtual 236	com/baidu/android/pushservice/d/a$b:name	()Ljava/lang/String;
    //   192: invokeinterface 437 2 0
    //   197: invokeinterface 441 2 0
    //   202: invokestatic 573	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   205: ifne +9 -> 214
    //   208: aload_0
    //   209: aload_1
    //   210: invokestatic 577	com/baidu/android/pushservice/d/a:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/baidu/android/pushservice/h/j;)I
    //   213: pop
    //   214: aload_2
    //   215: ifnull +9 -> 224
    //   218: aload_2
    //   219: invokeinterface 109 1 0
    //   224: iconst_1
    //   225: ireturn
    //   226: aload_2
    //   227: ifnull +9 -> 236
    //   230: aload_2
    //   231: invokeinterface 109 1 0
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_2
    //   241: aload_2
    //   242: ifnull -6 -> 236
    //   245: aload_2
    //   246: invokeinterface 109 1 0
    //   251: goto -15 -> 236
    //   254: astore_0
    //   255: aload_2
    //   256: ifnull +9 -> 265
    //   259: aload_2
    //   260: invokeinterface 109 1 0
    //   265: aload_0
    //   266: athrow
    //   267: astore_0
    //   268: goto -13 -> 255
    //   271: astore_0
    //   272: goto -31 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	275	1	paramj	j
    //   1	259	2	localObject	Object
    //   55	2	3	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   8	56	238	java/lang/Exception
    //   8	56	254	finally
    //   58	208	267	finally
    //   208	214	267	finally
    //   58	208	271	java/lang/Exception
    //   208	214	271	java/lang/Exception
  }
  
  /* Error */
  public static com.baidu.android.pushservice.h.a c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   7: astore 4
    //   9: aload 4
    //   11: monitorenter
    //   12: aload_0
    //   13: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnonnull +8 -> 28
    //   23: aload 4
    //   25: monitorexit
    //   26: aconst_null
    //   27: areturn
    //   28: new 284	com/baidu/android/pushservice/h/a
    //   31: dup
    //   32: invokespecial 579	com/baidu/android/pushservice/h/a:<init>	()V
    //   35: astore 6
    //   37: aload 5
    //   39: ldc 113
    //   41: aconst_null
    //   42: new 62	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   49: getstatic 116	com/baidu/android/pushservice/d/a$a:b	Lcom/baidu/android/pushservice/d/a$a;
    //   52: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 119
    //   60: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 121
    //   69: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore_0
    //   83: aload_0
    //   84: ifnonnull +23 -> 107
    //   87: aload_0
    //   88: ifnull +9 -> 97
    //   91: aload_0
    //   92: invokeinterface 109 1 0
    //   97: aload 5
    //   99: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   102: aload 4
    //   104: monitorexit
    //   105: aconst_null
    //   106: areturn
    //   107: aload_0
    //   108: invokeinterface 129 1 0
    //   113: ifle +125 -> 238
    //   116: aload_0
    //   117: invokeinterface 102 1 0
    //   122: pop
    //   123: aload 6
    //   125: aload_0
    //   126: aload_0
    //   127: getstatic 287	com/baidu/android/pushservice/d/a$a:c	Lcom/baidu/android/pushservice/d/a$a;
    //   130: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   133: invokeinterface 437 2 0
    //   138: invokeinterface 445 2 0
    //   143: putfield 290	com/baidu/android/pushservice/h/a:b	J
    //   146: aload 6
    //   148: aload_0
    //   149: aload_0
    //   150: getstatic 292	com/baidu/android/pushservice/d/a$a:d	Lcom/baidu/android/pushservice/d/a$a;
    //   153: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   156: invokeinterface 437 2 0
    //   161: invokeinterface 445 2 0
    //   166: putfield 294	com/baidu/android/pushservice/h/a:c	J
    //   169: aload 6
    //   171: aload_0
    //   172: aload_0
    //   173: getstatic 296	com/baidu/android/pushservice/d/a$a:e	Lcom/baidu/android/pushservice/d/a$a;
    //   176: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   179: invokeinterface 437 2 0
    //   184: invokeinterface 445 2 0
    //   189: putfield 298	com/baidu/android/pushservice/h/a:d	J
    //   192: aload 6
    //   194: aload_0
    //   195: aload_0
    //   196: getstatic 300	com/baidu/android/pushservice/d/a$a:g	Lcom/baidu/android/pushservice/d/a$a;
    //   199: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   202: invokeinterface 437 2 0
    //   207: invokeinterface 106 2 0
    //   212: putfield 302	com/baidu/android/pushservice/h/a:e	I
    //   215: aload 6
    //   217: aload_0
    //   218: aload_0
    //   219: getstatic 133	com/baidu/android/pushservice/d/a$a:f	Lcom/baidu/android/pushservice/d/a$a;
    //   222: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   225: invokeinterface 437 2 0
    //   230: invokeinterface 106 2 0
    //   235: putfield 304	com/baidu/android/pushservice/h/a:f	I
    //   238: aload_0
    //   239: ifnull +9 -> 248
    //   242: aload_0
    //   243: invokeinterface 109 1 0
    //   248: aload 5
    //   250: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   253: aload 4
    //   255: monitorexit
    //   256: aload 6
    //   258: areturn
    //   259: aload_0
    //   260: ifnull +9 -> 269
    //   263: aload_0
    //   264: invokeinterface 109 1 0
    //   269: aload 5
    //   271: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   274: goto -21 -> 253
    //   277: astore_0
    //   278: aload 4
    //   280: monitorexit
    //   281: aload_0
    //   282: athrow
    //   283: astore_1
    //   284: aload_3
    //   285: astore_0
    //   286: aload_0
    //   287: ifnull +9 -> 296
    //   290: aload_0
    //   291: invokeinterface 109 1 0
    //   296: aload 5
    //   298: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   301: aload_1
    //   302: athrow
    //   303: astore_1
    //   304: goto -18 -> 286
    //   307: astore_1
    //   308: goto -49 -> 259
    //   311: astore_0
    //   312: aload_2
    //   313: astore_0
    //   314: goto -55 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramContext	Context
    //   0	317	1	paramString	String
    //   3	310	2	localObject1	Object
    //   1	284	3	localObject2	Object
    //   7	272	4	localObject3	Object
    //   16	281	5	localSQLiteDatabase	SQLiteDatabase
    //   35	222	6	locala	com.baidu.android.pushservice.h.a
    // Exception table:
    //   from	to	target	type
    //   12	18	277	finally
    //   23	26	277	finally
    //   28	37	277	finally
    //   91	97	277	finally
    //   97	105	277	finally
    //   242	248	277	finally
    //   248	253	277	finally
    //   253	256	277	finally
    //   263	269	277	finally
    //   269	274	277	finally
    //   278	281	277	finally
    //   290	296	277	finally
    //   296	303	277	finally
    //   37	83	283	finally
    //   107	238	303	finally
    //   107	238	307	java/lang/Exception
    //   37	83	311	java/lang/Exception
  }
  
  /* Error */
  public static void c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: aload_0
    //   9: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnonnull +6 -> 22
    //   19: aload_3
    //   20: monitorexit
    //   21: return
    //   22: aload 4
    //   24: ldc_w 582
    //   27: aconst_null
    //   28: invokevirtual 96	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: astore_2
    //   34: aload_1
    //   35: invokeinterface 421 1 0
    //   40: ifeq +231 -> 271
    //   43: aload_1
    //   44: astore_2
    //   45: new 284	com/baidu/android/pushservice/h/a
    //   48: dup
    //   49: invokespecial 579	com/baidu/android/pushservice/h/a:<init>	()V
    //   52: astore 5
    //   54: aload_1
    //   55: astore_2
    //   56: aload 5
    //   58: aload_1
    //   59: aload_1
    //   60: getstatic 116	com/baidu/android/pushservice/d/a$a:b	Lcom/baidu/android/pushservice/d/a$a;
    //   63: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   66: invokeinterface 437 2 0
    //   71: invokeinterface 441 2 0
    //   76: putfield 285	com/baidu/android/pushservice/h/a:a	Ljava/lang/String;
    //   79: aload_1
    //   80: astore_2
    //   81: aload 5
    //   83: aload_1
    //   84: aload_1
    //   85: getstatic 287	com/baidu/android/pushservice/d/a$a:c	Lcom/baidu/android/pushservice/d/a$a;
    //   88: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   91: invokeinterface 437 2 0
    //   96: invokeinterface 445 2 0
    //   101: putfield 290	com/baidu/android/pushservice/h/a:b	J
    //   104: aload_1
    //   105: astore_2
    //   106: aload 5
    //   108: aload_1
    //   109: aload_1
    //   110: getstatic 292	com/baidu/android/pushservice/d/a$a:d	Lcom/baidu/android/pushservice/d/a$a;
    //   113: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   116: invokeinterface 437 2 0
    //   121: invokeinterface 445 2 0
    //   126: putfield 294	com/baidu/android/pushservice/h/a:c	J
    //   129: aload_1
    //   130: astore_2
    //   131: aload 5
    //   133: aload_1
    //   134: aload_1
    //   135: getstatic 296	com/baidu/android/pushservice/d/a$a:e	Lcom/baidu/android/pushservice/d/a$a;
    //   138: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   141: invokeinterface 437 2 0
    //   146: invokeinterface 445 2 0
    //   151: putfield 298	com/baidu/android/pushservice/h/a:d	J
    //   154: aload_1
    //   155: astore_2
    //   156: aload 5
    //   158: aload_1
    //   159: aload_1
    //   160: getstatic 300	com/baidu/android/pushservice/d/a$a:g	Lcom/baidu/android/pushservice/d/a$a;
    //   163: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   166: invokeinterface 437 2 0
    //   171: invokeinterface 106 2 0
    //   176: putfield 302	com/baidu/android/pushservice/h/a:e	I
    //   179: aload_1
    //   180: astore_2
    //   181: aload 5
    //   183: aload_1
    //   184: aload_1
    //   185: getstatic 133	com/baidu/android/pushservice/d/a$a:f	Lcom/baidu/android/pushservice/d/a$a;
    //   188: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   191: invokeinterface 437 2 0
    //   196: invokeinterface 106 2 0
    //   201: putfield 304	com/baidu/android/pushservice/h/a:f	I
    //   204: aload_1
    //   205: astore_2
    //   206: aload 5
    //   208: getfield 304	com/baidu/android/pushservice/h/a:f	I
    //   211: ifeq +17 -> 228
    //   214: aload_1
    //   215: astore_2
    //   216: aload 5
    //   218: getfield 298	com/baidu/android/pushservice/h/a:d	J
    //   221: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   224: lcmp
    //   225: ifge -193 -> 32
    //   228: aload_1
    //   229: astore_2
    //   230: aload_0
    //   231: aload 5
    //   233: getfield 285	com/baidu/android/pushservice/h/a:a	Ljava/lang/String;
    //   236: invokestatic 585	com/baidu/android/pushservice/d/a:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   239: goto -207 -> 32
    //   242: astore_0
    //   243: aload_2
    //   244: ifnull +9 -> 253
    //   247: aload_2
    //   248: invokeinterface 109 1 0
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   263: aload_3
    //   264: monitorexit
    //   265: return
    //   266: astore_0
    //   267: aload_3
    //   268: monitorexit
    //   269: aload_0
    //   270: athrow
    //   271: aload_1
    //   272: ifnull +9 -> 281
    //   275: aload_1
    //   276: invokeinterface 109 1 0
    //   281: aload 4
    //   283: ifnull -20 -> 263
    //   286: aload 4
    //   288: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   291: goto -28 -> 263
    //   294: aload_1
    //   295: ifnull +9 -> 304
    //   298: aload_1
    //   299: invokeinterface 109 1 0
    //   304: aload 4
    //   306: ifnull +8 -> 314
    //   309: aload 4
    //   311: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   314: aload_0
    //   315: athrow
    //   316: astore_0
    //   317: goto -23 -> 294
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -29 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	Context
    //   31	292	1	localCursor	Cursor
    //   1	247	2	localObject1	Object
    //   5	263	3	localObject2	Object
    //   12	298	4	localSQLiteDatabase	SQLiteDatabase
    //   52	180	5	locala	com.baidu.android.pushservice.h.a
    // Exception table:
    //   from	to	target	type
    //   22	32	242	java/lang/Exception
    //   34	43	242	java/lang/Exception
    //   45	54	242	java/lang/Exception
    //   56	79	242	java/lang/Exception
    //   81	104	242	java/lang/Exception
    //   106	129	242	java/lang/Exception
    //   131	154	242	java/lang/Exception
    //   156	179	242	java/lang/Exception
    //   181	204	242	java/lang/Exception
    //   206	214	242	java/lang/Exception
    //   216	228	242	java/lang/Exception
    //   230	239	242	java/lang/Exception
    //   8	14	266	finally
    //   19	21	266	finally
    //   247	253	266	finally
    //   258	263	266	finally
    //   263	265	266	finally
    //   267	269	266	finally
    //   275	281	266	finally
    //   286	291	266	finally
    //   298	304	266	finally
    //   309	314	266	finally
    //   314	316	266	finally
    //   34	43	316	finally
    //   45	54	316	finally
    //   56	79	316	finally
    //   81	104	316	finally
    //   106	129	316	finally
    //   131	154	316	finally
    //   156	179	316	finally
    //   181	204	316	finally
    //   206	214	316	finally
    //   216	228	316	finally
    //   230	239	316	finally
    //   22	32	320	finally
  }
  
  public static long d(Context paramContext)
  {
    synchronized (c)
    {
      paramContext = e(paramContext);
      if (paramContext == null) {
        return 0L;
      }
    }
    try
    {
      paramContext.delete("PushBehavior", null, null);
      paramContext.delete("AppInfo", null, null);
      paramContext.close();
      long l = -1;
      return l;
      paramContext = finally;
      throw paramContext;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static void d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: aload_0
    //   9: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnonnull +6 -> 22
    //   19: aload_3
    //   20: monitorexit
    //   21: return
    //   22: aload 4
    //   24: ldc 113
    //   26: aconst_null
    //   27: new 62	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   34: getstatic 116	com/baidu/android/pushservice/d/a$a:b	Lcom/baidu/android/pushservice/d/a$a;
    //   37: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   40: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 119
    //   45: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 121
    //   54: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_0
    //   68: aload_0
    //   69: ifnonnull +31 -> 100
    //   72: aload_0
    //   73: ifnull +9 -> 82
    //   76: aload_0
    //   77: invokeinterface 109 1 0
    //   82: aload 4
    //   84: ifnull +8 -> 92
    //   87: aload 4
    //   89: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   92: aload_3
    //   93: monitorexit
    //   94: return
    //   95: astore_0
    //   96: aload_3
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    //   100: aload 4
    //   102: ldc 113
    //   104: new 62	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   111: getstatic 116	com/baidu/android/pushservice/d/a$a:b	Lcom/baidu/android/pushservice/d/a$a;
    //   114: invokevirtual 117	com/baidu/android/pushservice/d/a$a:name	()Ljava/lang/String;
    //   117: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 408
    //   123: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: iconst_1
    //   130: anewarray 223	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: invokevirtual 425	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   140: pop
    //   141: aload_0
    //   142: ifnull +9 -> 151
    //   145: aload_0
    //   146: invokeinterface 109 1 0
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   161: aload_3
    //   162: monitorexit
    //   163: return
    //   164: aload_0
    //   165: ifnull +9 -> 174
    //   168: aload_0
    //   169: invokeinterface 109 1 0
    //   174: aload 4
    //   176: ifnull -15 -> 161
    //   179: aload 4
    //   181: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   184: goto -23 -> 161
    //   187: aload_1
    //   188: ifnull +9 -> 197
    //   191: aload_1
    //   192: invokeinterface 109 1 0
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_2
    //   210: aload_0
    //   211: astore_1
    //   212: aload_2
    //   213: astore_0
    //   214: goto -27 -> 187
    //   217: astore_1
    //   218: goto -54 -> 164
    //   221: astore_0
    //   222: aconst_null
    //   223: astore_0
    //   224: goto -60 -> 164
    //   227: astore_0
    //   228: aload_2
    //   229: astore_1
    //   230: goto -43 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramContext	Context
    //   0	233	1	paramString	String
    //   1	1	2	localObject1	Object
    //   209	20	2	localObject2	Object
    //   5	157	3	localObject3	Object
    //   12	191	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   8	14	95	finally
    //   19	21	95	finally
    //   76	82	95	finally
    //   87	92	95	finally
    //   92	94	95	finally
    //   96	98	95	finally
    //   145	151	95	finally
    //   156	161	95	finally
    //   161	163	95	finally
    //   168	174	95	finally
    //   179	184	95	finally
    //   191	197	95	finally
    //   202	207	95	finally
    //   207	209	95	finally
    //   100	141	209	finally
    //   100	141	217	java/lang/Exception
    //   22	68	221	java/lang/Exception
    //   22	68	227	finally
  }
  
  private static SQLiteDatabase e(Context paramContext)
  {
    paramContext = f(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getWritableDatabase();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  /* Error */
  public static boolean e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   5: astore 4
    //   7: aload 4
    //   9: monitorenter
    //   10: aload_0
    //   11: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +8 -> 26
    //   21: aload 4
    //   23: monitorexit
    //   24: iconst_1
    //   25: ireturn
    //   26: new 148	android/content/ContentValues
    //   29: dup
    //   30: invokespecial 149	android/content/ContentValues:<init>	()V
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 599	android/content/ContentValues:clear	()V
    //   40: aload 6
    //   42: getstatic 602	com/baidu/android/pushservice/d/a$h:b	Lcom/baidu/android/pushservice/d/a$h;
    //   45: invokevirtual 603	com/baidu/android/pushservice/d/a$h:name	()Ljava/lang/String;
    //   48: aload_1
    //   49: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload 6
    //   54: getstatic 605	com/baidu/android/pushservice/d/a$h:c	Lcom/baidu/android/pushservice/d/a$h;
    //   57: invokevirtual 603	com/baidu/android/pushservice/d/a$h:name	()Ljava/lang/String;
    //   60: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   63: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: invokevirtual 217	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   69: new 62	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   76: getstatic 602	com/baidu/android/pushservice/d/a$h:b	Lcom/baidu/android/pushservice/d/a$h;
    //   79: invokevirtual 603	com/baidu/android/pushservice/d/a$h:name	()Ljava/lang/String;
    //   82: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 607
    //   88: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 7
    //   96: aload 5
    //   98: ldc_w 609
    //   101: aconst_null
    //   102: aload 7
    //   104: iconst_1
    //   105: anewarray 223	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_1
    //   111: aastore
    //   112: aconst_null
    //   113: aconst_null
    //   114: aconst_null
    //   115: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull +131 -> 251
    //   123: aload_3
    //   124: astore_0
    //   125: aload_3
    //   126: astore_2
    //   127: aload_3
    //   128: invokeinterface 129 1 0
    //   133: ifle +118 -> 251
    //   136: aload_3
    //   137: astore_0
    //   138: aload_3
    //   139: astore_2
    //   140: new 62	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 611
    //   150: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 605	com/baidu/android/pushservice/d/a$h:c	Lcom/baidu/android/pushservice/d/a$h;
    //   156: invokevirtual 603	com/baidu/android/pushservice/d/a$h:name	()Ljava/lang/String;
    //   159: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 119
    //   164: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokestatic 209	java/lang/System:currentTimeMillis	()J
    //   170: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   173: ldc -118
    //   175: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: getstatic 602	com/baidu/android/pushservice/d/a$h:b	Lcom/baidu/android/pushservice/d/a$h;
    //   181: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: ldc 119
    //   186: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: pop
    //   197: aload_3
    //   198: astore_0
    //   199: aload_3
    //   200: astore_2
    //   201: aload 5
    //   203: ldc_w 609
    //   206: aload 6
    //   208: aload 7
    //   210: iconst_1
    //   211: anewarray 223	java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: aastore
    //   218: invokevirtual 227	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   221: pop
    //   222: aload_3
    //   223: ifnull +18 -> 241
    //   226: aload_3
    //   227: invokeinterface 614 1 0
    //   232: ifne +9 -> 241
    //   235: aload_3
    //   236: invokeinterface 109 1 0
    //   241: aload 5
    //   243: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   246: aload 4
    //   248: monitorexit
    //   249: iconst_0
    //   250: ireturn
    //   251: aload_3
    //   252: astore_0
    //   253: aload_3
    //   254: astore_2
    //   255: aload 5
    //   257: ldc_w 616
    //   260: aconst_null
    //   261: invokevirtual 96	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   264: astore_1
    //   265: aload_1
    //   266: astore_0
    //   267: aload_1
    //   268: astore_2
    //   269: aload_1
    //   270: invokeinterface 102 1 0
    //   275: pop
    //   276: aload_1
    //   277: astore_0
    //   278: aload_1
    //   279: astore_2
    //   280: aload_1
    //   281: iconst_0
    //   282: invokeinterface 106 2 0
    //   287: getstatic 53	com/baidu/android/pushservice/d/a:d	I
    //   290: if_icmple +18 -> 308
    //   293: aload_1
    //   294: astore_0
    //   295: aload_1
    //   296: astore_2
    //   297: aload 5
    //   299: ldc_w 609
    //   302: aconst_null
    //   303: aconst_null
    //   304: invokevirtual 425	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   307: pop
    //   308: aload_1
    //   309: astore_0
    //   310: aload_1
    //   311: astore_2
    //   312: aload 5
    //   314: ldc_w 609
    //   317: aconst_null
    //   318: aload 6
    //   320: invokevirtual 281	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   323: pop2
    //   324: aload_1
    //   325: ifnull +18 -> 343
    //   328: aload_1
    //   329: invokeinterface 614 1 0
    //   334: ifne +9 -> 343
    //   337: aload_1
    //   338: invokeinterface 109 1 0
    //   343: aload 5
    //   345: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   348: aload 4
    //   350: monitorexit
    //   351: iconst_1
    //   352: ireturn
    //   353: aload_2
    //   354: ifnull +18 -> 372
    //   357: aload_2
    //   358: invokeinterface 614 1 0
    //   363: ifne +9 -> 372
    //   366: aload_2
    //   367: invokeinterface 109 1 0
    //   372: aload 5
    //   374: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   377: aload 4
    //   379: monitorexit
    //   380: iconst_1
    //   381: ireturn
    //   382: aload_1
    //   383: ifnull +18 -> 401
    //   386: aload_1
    //   387: invokeinterface 614 1 0
    //   392: ifne +9 -> 401
    //   395: aload_1
    //   396: invokeinterface 109 1 0
    //   401: aload 5
    //   403: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   406: aload_0
    //   407: athrow
    //   408: astore_0
    //   409: aload 4
    //   411: monitorexit
    //   412: aload_0
    //   413: athrow
    //   414: astore_2
    //   415: aload_0
    //   416: astore_1
    //   417: aload_2
    //   418: astore_0
    //   419: goto -37 -> 382
    //   422: astore_0
    //   423: goto -70 -> 353
    //   426: astore_0
    //   427: aconst_null
    //   428: astore_2
    //   429: goto -76 -> 353
    //   432: astore_0
    //   433: aload_2
    //   434: astore_1
    //   435: goto -53 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramContext	Context
    //   0	438	1	paramString	String
    //   1	366	2	localObject1	Object
    //   414	4	2	localObject2	Object
    //   428	6	2	localObject3	Object
    //   118	136	3	localCursor	Cursor
    //   5	405	4	localObject4	Object
    //   14	388	5	localSQLiteDatabase	SQLiteDatabase
    //   33	286	6	localContentValues	ContentValues
    //   94	115	7	str	String
    // Exception table:
    //   from	to	target	type
    //   10	16	408	finally
    //   21	24	408	finally
    //   226	241	408	finally
    //   241	249	408	finally
    //   328	343	408	finally
    //   343	351	408	finally
    //   357	372	408	finally
    //   372	380	408	finally
    //   386	401	408	finally
    //   401	408	408	finally
    //   409	412	408	finally
    //   127	136	414	finally
    //   140	197	414	finally
    //   201	222	414	finally
    //   255	265	414	finally
    //   269	276	414	finally
    //   280	293	414	finally
    //   297	308	414	finally
    //   312	324	414	finally
    //   127	136	422	java/lang/Exception
    //   140	197	422	java/lang/Exception
    //   201	222	422	java/lang/Exception
    //   255	265	422	java/lang/Exception
    //   269	276	422	java/lang/Exception
    //   280	293	422	java/lang/Exception
    //   297	308	422	java/lang/Exception
    //   312	324	422	java/lang/Exception
    //   26	119	426	java/lang/Exception
    //   26	119	432	finally
  }
  
  private static e f(Context paramContext)
  {
    synchronized (c)
    {
      String str;
      if (a == null)
      {
        str = paramContext.getDatabasePath("pushstat_6.0.0.db").getPath();
        a("pushstat_6.0.0.db", paramContext);
        if (Build.VERSION.SDK_INT >= 11)
        {
          b = new d(null);
          a = new e(paramContext, str, 2, b);
        }
      }
      else
      {
        return a;
      }
      a = new e(paramContext, str, 2);
    }
  }
  
  /* Error */
  public static int[] f(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 51	com/baidu/android/pushservice/d/a:c	Ljava/lang/Object;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: aload_0
    //   9: invokestatic 60	com/baidu/android/pushservice/d/a:e	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 7
    //   14: aload 7
    //   16: ifnonnull +8 -> 24
    //   19: aload 6
    //   21: monitorexit
    //   22: aconst_null
    //   23: areturn
    //   24: aload 7
    //   26: ldc_w 410
    //   29: aconst_null
    //   30: new 62	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   37: getstatic 405	com/baidu/android/pushservice/d/a$i:a	Lcom/baidu/android/pushservice/d/a$i;
    //   40: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   43: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 408
    //   49: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: iconst_1
    //   56: anewarray 223	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload_1
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: invokevirtual 125	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +170 -> 241
    //   74: aload_0
    //   75: invokeinterface 421 1 0
    //   80: ifeq +161 -> 241
    //   83: aload_0
    //   84: aload_0
    //   85: getstatic 412	com/baidu/android/pushservice/d/a$i:b	Lcom/baidu/android/pushservice/d/a$i;
    //   88: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   91: invokeinterface 437 2 0
    //   96: invokeinterface 106 2 0
    //   101: istore_2
    //   102: aload_0
    //   103: aload_0
    //   104: getstatic 414	com/baidu/android/pushservice/d/a$i:c	Lcom/baidu/android/pushservice/d/a$i;
    //   107: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   110: invokeinterface 437 2 0
    //   115: invokeinterface 106 2 0
    //   120: istore_3
    //   121: aload_0
    //   122: aload_0
    //   123: getstatic 416	com/baidu/android/pushservice/d/a$i:d	Lcom/baidu/android/pushservice/d/a$i;
    //   126: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   129: invokeinterface 437 2 0
    //   134: invokeinterface 106 2 0
    //   139: istore 4
    //   141: aload_0
    //   142: aload_0
    //   143: getstatic 418	com/baidu/android/pushservice/d/a$i:e	Lcom/baidu/android/pushservice/d/a$i;
    //   146: invokevirtual 406	com/baidu/android/pushservice/d/a$i:name	()Ljava/lang/String;
    //   149: invokeinterface 437 2 0
    //   154: invokeinterface 106 2 0
    //   159: istore 5
    //   161: iload_2
    //   162: ifne +39 -> 201
    //   165: iload_3
    //   166: ifne +35 -> 201
    //   169: iload 4
    //   171: ifne +30 -> 201
    //   174: iload 5
    //   176: ifne +25 -> 201
    //   179: aload_0
    //   180: ifnull +9 -> 189
    //   183: aload_0
    //   184: invokeinterface 109 1 0
    //   189: aload 7
    //   191: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   194: aload 6
    //   196: monitorexit
    //   197: iconst_0
    //   198: newarray <illegal type>
    //   200: areturn
    //   201: aload_0
    //   202: ifnull +9 -> 211
    //   205: aload_0
    //   206: invokeinterface 109 1 0
    //   211: aload 7
    //   213: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   216: aload 6
    //   218: monitorexit
    //   219: iconst_4
    //   220: newarray <illegal type>
    //   222: dup
    //   223: iconst_0
    //   224: iload_2
    //   225: iastore
    //   226: dup
    //   227: iconst_1
    //   228: iload_3
    //   229: iastore
    //   230: dup
    //   231: iconst_2
    //   232: iload 4
    //   234: iastore
    //   235: dup
    //   236: iconst_3
    //   237: iload 5
    //   239: iastore
    //   240: areturn
    //   241: aload_0
    //   242: ifnull +9 -> 251
    //   245: aload_0
    //   246: invokeinterface 109 1 0
    //   251: aload 7
    //   253: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   256: aload 6
    //   258: monitorexit
    //   259: aconst_null
    //   260: areturn
    //   261: aload_0
    //   262: ifnull +9 -> 271
    //   265: aload_0
    //   266: invokeinterface 109 1 0
    //   271: aload 7
    //   273: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   276: goto -20 -> 256
    //   279: astore_0
    //   280: aload 6
    //   282: monitorexit
    //   283: aload_0
    //   284: athrow
    //   285: astore_1
    //   286: aconst_null
    //   287: astore_0
    //   288: aload_0
    //   289: ifnull +9 -> 298
    //   292: aload_0
    //   293: invokeinterface 109 1 0
    //   298: aload 7
    //   300: invokevirtual 110	android/database/sqlite/SQLiteDatabase:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: goto -18 -> 288
    //   309: astore_1
    //   310: goto -49 -> 261
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -55 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramContext	Context
    //   0	319	1	paramString	String
    //   101	124	2	i	int
    //   120	109	3	j	int
    //   139	94	4	k	int
    //   159	79	5	m	int
    //   3	278	6	localObject	Object
    //   12	287	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   8	14	279	finally
    //   19	22	279	finally
    //   183	189	279	finally
    //   189	197	279	finally
    //   205	211	279	finally
    //   211	241	279	finally
    //   245	251	279	finally
    //   251	256	279	finally
    //   256	259	279	finally
    //   265	271	279	finally
    //   271	276	279	finally
    //   280	283	279	finally
    //   292	298	279	finally
    //   298	305	279	finally
    //   24	70	285	finally
    //   74	161	305	finally
    //   74	161	309	java/lang/Exception
    //   24	70	313	java/lang/Exception
  }
  
  static enum a
  {
    private a() {}
  }
  
  static enum b
  {
    private b() {}
  }
  
  static enum c
  {
    private c() {}
  }
  
  private static class d
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
      //   12: invokespecial 72	com/baidu/android/pushservice/d/a$d:a	(Ljava/lang/String;)V
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
      //   65: invokespecial 72	com/baidu/android/pushservice/d/a$d:a	(Ljava/lang/String;)V
      //   68: goto -28 -> 40
      //   71: aload_0
      //   72: aload_1
      //   73: invokevirtual 70	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   76: invokespecial 72	com/baidu/android/pushservice/d/a$d:a	(Ljava/lang/String;)V
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
      //   119: invokespecial 72	com/baidu/android/pushservice/d/a$d:a	(Ljava/lang/String;)V
      //   122: goto -28 -> 94
      //   125: aload_0
      //   126: aload_1
      //   127: invokevirtual 70	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
      //   130: invokespecial 72	com/baidu/android/pushservice/d/a$d:a	(Ljava/lang/String;)V
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
      //   0	153	0	this	d
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
  
  private static class e
    extends SQLiteOpenHelper
  {
    private static final String a = "CREATE TABLE StatisticsInfo (" + a.j.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.j.b.name() + " TEXT NOT NULL, " + a.j.c.name() + " TEXT NOT NULL, " + a.j.d.name() + " TEXT, " + a.j.e.name() + " TEXT NOT NULL, " + a.j.f.name() + " TEXT NOT NULL, " + a.j.g.name() + " TEXT NOT NULL, " + a.j.h.name() + " TEXT" + ");";
    private static final String b = "CREATE TABLE PushBehavior (" + a.c.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.c.b.name() + " TEXT NOT NULL, " + a.c.c.name() + " LONG NOT NULL, " + a.c.d.name() + " TEXT, " + a.c.e.name() + " INTEGER, " + a.c.f.name() + " TEXT, " + a.c.g.name() + " INTEGER, " + a.c.h.name() + " TEXT, " + a.c.i.name() + " TEXT, " + a.c.j.name() + " INTEGER, " + a.c.k.name() + " INTEGER, " + a.c.l.name() + " TEXT, " + a.c.m.name() + " TEXT, " + a.c.o.name() + " TEXT, " + a.c.n.name() + " TEXT" + ");";
    private static final String c = "CREATE TABLE MsgArriveApp (" + a.h.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.h.b.name() + " TEXT NOT NULL, " + a.h.c.name() + " LONG NOT NULL" + ");";
    private static final String d = "CREATE TABLE AlarmMsgInfo (" + a.a.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.a.b.name() + " TEXT NOT NULL, " + a.a.c.name() + " LONG NOT NULL, " + a.a.d.name() + " LONG NOT NULL, " + a.a.e.name() + " LONG NOT NULL, " + a.a.f.name() + " INTEGER, " + a.a.g.name() + " INTEGER" + ");";
    private static final String e = "CREATE TABLE AppInfo (" + a.b.a.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.b.b.name() + " TEXT, " + a.b.c.name() + " INTEGER, " + a.b.d.name() + " TEXT UNIQUE, " + a.b.e.name() + " TEXT, " + a.b.f.name() + " TEXT, " + a.b.g.name() + " TEXT, " + a.b.h.name() + " TEXT, " + a.b.i.name() + " TEXT" + ");";
    private static final String f = "CREATE TABLE FileDownloadingInfo (" + a.f.a.name() + " TEXT, " + a.f.b.name() + " TEXT PRIMARY KEY, " + a.f.e.name() + " TEXT NOT NULL, " + a.f.c.name() + " TEXT, " + a.f.d.name() + " TEXT, " + a.f.f.name() + " TEXT NOT NULL, " + a.f.g.name() + " INTEGER NOT NULL, " + a.f.h.name() + " INTEGER NOT NULL, " + a.f.i.name() + " INTEGER NOT NULL," + a.f.j.name() + " INTEGER NOT NULL" + ");";
    private static final String g = "CREATE TABLE NoDisturb (" + a.i.a.name() + " TEXT NOT NULL, " + a.i.b.name() + " INTEGER, " + a.i.c.name() + " INTEGER, " + a.i.d.name() + " INTEGER, " + a.i.e.name() + " INTEGER" + ");";
    
    public e(Context paramContext, String paramString, int paramInt)
    {
      super(paramString, null, paramInt);
    }
    
    public e(Context paramContext, String paramString, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
    {
      super(paramString, null, paramInt, paramDatabaseErrorHandler);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS StatisticsInfo");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS FileDownloadingInfo");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushBehavior");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS AlarmMsgInfo");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS NoDisturb");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgArriveApp");
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
        paramSQLiteDatabase.execSQL(e);
        paramSQLiteDatabase.execSQL(f);
        paramSQLiteDatabase.execSQL(g);
        return;
      }
      catch (Exception paramSQLiteDatabase) {}
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      a(paramSQLiteDatabase);
      onCreate(paramSQLiteDatabase);
    }
  }
  
  static enum f
  {
    private f() {}
  }
  
  public static class g
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public long j;
  }
  
  static enum h
  {
    private h() {}
  }
  
  static enum i
  {
    private i() {}
  }
  
  static enum j
  {
    private j() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */