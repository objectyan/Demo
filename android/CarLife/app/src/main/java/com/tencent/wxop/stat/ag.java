package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.a.e;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.g;
import com.tencent.wxop.stat.b.m;
import com.tencent.wxop.stat.b.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ag
{
  private static b h = ;
  private static Context i = null;
  private static ag j = null;
  volatile int a = 0;
  c b = null;
  private ao c = null;
  private ao d = null;
  private g e = null;
  private String f = "";
  private String g = "";
  private int k = 0;
  private ConcurrentHashMap<e, String> l = null;
  private boolean m = false;
  private HashMap<String, String> n = new HashMap();
  
  private ag(Context paramContext)
  {
    try
    {
      this.e = new g();
      i = paramContext.getApplicationContext();
      this.l = new ConcurrentHashMap();
      this.f = m.r(paramContext);
      this.g = ("pri_" + m.r(paramContext));
      this.c = new ao(i, this.f);
      this.d = new ao(i, this.g);
      a(true);
      a(false);
      f();
      b(i);
      d();
      j();
      return;
    }
    catch (Throwable paramContext)
    {
      h.b(paramContext);
    }
  }
  
  public static ag a(Context paramContext)
  {
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new ag(paramContext);
      }
      return j;
    }
    finally {}
  }
  
  private String a(List<ap> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 3);
    localStringBuilder.append("event_id in (");
    int i2 = paramList.size();
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      localStringBuilder.append(((ap)paramList.next()).a);
      if (i1 != i2 - 1) {
        localStringBuilder.append(",");
      }
      i1 += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((this.a > 0) && (paramInt > 0))
        {
          boolean bool = j.a();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ArrayList localArrayList;
        h.b(localThrowable);
        continue;
      }
      finally {}
      return;
      if (f.b()) {
        h.b("Load " + this.a + " unsent events");
      }
      localArrayList = new ArrayList(paramInt);
      b(localArrayList, paramInt, paramBoolean);
      if (localArrayList.size() > 0)
      {
        if (f.b()) {
          h.b("Peek " + localArrayList.size() + " unsent events.");
        }
        a(localArrayList, 2, paramBoolean);
        aw.b(i).b(localArrayList, new am(this, localArrayList, paramBoolean));
      }
    }
  }
  
  private void a(e parame, av paramav, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      long l2;
      try
      {
        localSQLiteDatabase = c(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        if (!paramBoolean)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (this.a > f.j())
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            h.e("Too many events stored in db.");
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            this.a -= this.c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
          }
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        String str = parame.g();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (f.b())
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          h.b("insert 1 event, content:" + str);
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("content", s.b(str));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("send_count", "0");
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("status", Integer.toString(1));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("timestamp", Long.valueOf(parame.c()));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        l1 = localSQLiteDatabase.insert("events", null, localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
        l2 = l1;
        if (localSQLiteDatabase == null) {
          break label481;
        }
      }
      catch (Throwable localThrowable3)
      {
        SQLiteDatabase localSQLiteDatabase;
        l2 = -1L;
        localObject2 = localThrowable1;
        h.b(localThrowable3);
        if (localThrowable1 == null) {
          break label481;
        }
        try
        {
          localThrowable1.endTransaction();
          l1 = -1L;
        }
        catch (Throwable localThrowable2)
        {
          h.b(localThrowable2);
          l1 = -1L;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((SQLiteDatabase)localObject2).endTransaction();
          throw parame;
        }
        catch (Throwable paramav)
        {
          h.b(paramav);
          continue;
        }
        h.g("Failed to store event:" + parame.g());
        return;
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        if (l1 > 0L)
        {
          this.a += 1;
          if (f.b()) {
            h.j("directStoreEvent insert event to db, event:" + parame.g());
          }
          if (paramav != null) {
            paramav.a();
          }
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        h.b(localThrowable1);
        continue;
      }
      label481:
      long l1 = l2;
    }
  }
  
  /* Error */
  private void a(List<ap> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 141 1 0
    //   14: istore 4
    //   16: iload 4
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: iload_3
    //   26: invokespecial 335	com/tencent/wxop/stat/ag:b	(Z)I
    //   29: istore 4
    //   31: aload_0
    //   32: iload_3
    //   33: invokespecial 222	com/tencent/wxop/stat/ag:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 6
    //   38: iload_2
    //   39: iconst_2
    //   40: if_icmpne +192 -> 232
    //   43: aload 6
    //   45: astore 5
    //   47: new 96	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 337
    //   54: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_2
    //   58: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 339
    //   64: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 341	com/tencent/wxop/stat/ag:a	(Ljava/util/List;)Ljava/lang/String;
    //   72: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 8
    //   80: aload 7
    //   82: astore_1
    //   83: aload 8
    //   85: astore 7
    //   87: aload 6
    //   89: astore 5
    //   91: invokestatic 183	com/tencent/wxop/stat/f:b	()Z
    //   94: ifeq +31 -> 125
    //   97: aload 6
    //   99: astore 5
    //   101: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   104: new 96	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 343
    //   111: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload 7
    //   116: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: invokevirtual 227	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   134: aload 6
    //   136: astore 5
    //   138: aload 6
    //   140: aload 7
    //   142: invokevirtual 346	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   145: aload_1
    //   146: ifnull +48 -> 194
    //   149: aload 6
    //   151: astore 5
    //   153: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   156: new 96	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 348
    //   163: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_1
    //   167: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   176: aload 6
    //   178: astore 5
    //   180: aload 6
    //   182: aload_1
    //   183: invokevirtual 346	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   186: aload 6
    //   188: astore 5
    //   190: aload_0
    //   191: invokespecial 119	com/tencent/wxop/stat/ag:f	()V
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: invokevirtual 297	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   203: aload 6
    //   205: ifnull -184 -> 21
    //   208: aload 6
    //   210: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   213: goto -192 -> 21
    //   216: astore_1
    //   217: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   220: aload_1
    //   221: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   224: goto -203 -> 21
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    //   232: aload 6
    //   234: astore 5
    //   236: new 96	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 337
    //   243: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: iload_2
    //   247: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc_w 350
    //   253: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: aload_1
    //   258: invokespecial 341	com/tencent/wxop/stat/ag:a	(Ljava/util/List;)Ljava/lang/String;
    //   261: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: astore 7
    //   269: aload 8
    //   271: astore_1
    //   272: aload 6
    //   274: astore 5
    //   276: aload_0
    //   277: getfield 69	com/tencent/wxop/stat/ag:k	I
    //   280: iconst_3
    //   281: irem
    //   282: ifne +26 -> 308
    //   285: aload 6
    //   287: astore 5
    //   289: new 96	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 352
    //   296: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: iload 4
    //   301: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_1
    //   308: aload 6
    //   310: astore 5
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 69	com/tencent/wxop/stat/ag:k	I
    //   317: iconst_1
    //   318: iadd
    //   319: putfield 69	com/tencent/wxop/stat/ag:k	I
    //   322: goto -235 -> 87
    //   325: astore_1
    //   326: aload 6
    //   328: astore 5
    //   330: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   333: aload_1
    //   334: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   337: aload 6
    //   339: ifnull -318 -> 21
    //   342: aload 6
    //   344: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   347: goto -326 -> 21
    //   350: astore_1
    //   351: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   354: aload_1
    //   355: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   358: goto -337 -> 21
    //   361: astore_1
    //   362: aconst_null
    //   363: astore 5
    //   365: aload 5
    //   367: ifnull +8 -> 375
    //   370: aload 5
    //   372: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore 5
    //   379: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   382: aload 5
    //   384: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   387: goto -12 -> 375
    //   390: astore_1
    //   391: goto -26 -> 365
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 6
    //   398: goto -72 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	ag
    //   0	401	1	paramList	List<ap>
    //   0	401	2	paramInt	int
    //   0	401	3	paramBoolean	boolean
    //   14	286	4	i1	int
    //   45	326	5	localSQLiteDatabase1	SQLiteDatabase
    //   377	6	5	localThrowable	Throwable
    //   36	361	6	localSQLiteDatabase2	SQLiteDatabase
    //   4	264	7	str1	String
    //   1	269	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   208	213	216	java/lang/Throwable
    //   8	16	227	finally
    //   24	31	227	finally
    //   208	213	227	finally
    //   217	224	227	finally
    //   342	347	227	finally
    //   351	358	227	finally
    //   370	375	227	finally
    //   375	377	227	finally
    //   379	387	227	finally
    //   47	80	325	java/lang/Throwable
    //   91	97	325	java/lang/Throwable
    //   101	125	325	java/lang/Throwable
    //   129	134	325	java/lang/Throwable
    //   138	145	325	java/lang/Throwable
    //   153	176	325	java/lang/Throwable
    //   180	186	325	java/lang/Throwable
    //   190	194	325	java/lang/Throwable
    //   198	203	325	java/lang/Throwable
    //   236	269	325	java/lang/Throwable
    //   276	285	325	java/lang/Throwable
    //   289	308	325	java/lang/Throwable
    //   312	322	325	java/lang/Throwable
    //   342	347	350	java/lang/Throwable
    //   31	38	361	finally
    //   370	375	377	java/lang/Throwable
    //   47	80	390	finally
    //   91	97	390	finally
    //   101	125	390	finally
    //   129	134	390	finally
    //   138	145	390	finally
    //   153	176	390	finally
    //   180	186	390	finally
    //   190	194	390	finally
    //   198	203	390	finally
    //   236	269	390	finally
    //   276	285	390	finally
    //   289	308	390	finally
    //   312	322	390	finally
    //   330	337	390	finally
    //   31	38	394	java/lang/Throwable
  }
  
  /* Error */
  private void a(List<ap> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 141 1 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 183	com/tencent/wxop/stat/f:b	()Z
    //   25: ifeq +41 -> 66
    //   28: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   31: new 96	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 355
    //   38: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokeinterface 141 1 0
    //   47: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 357
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_2
    //   57: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   66: new 96	java/lang/StringBuilder
    //   69: dup
    //   70: aload_1
    //   71: invokeinterface 141 1 0
    //   76: iconst_3
    //   77: imul
    //   78: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   81: astore 7
    //   83: aload 7
    //   85: ldc -110
    //   87: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: invokeinterface 141 1 0
    //   97: istore 4
    //   99: aload_1
    //   100: invokeinterface 150 1 0
    //   105: astore_1
    //   106: iconst_0
    //   107: istore_3
    //   108: aload_1
    //   109: invokeinterface 156 1 0
    //   114: ifeq +40 -> 154
    //   117: aload 7
    //   119: aload_1
    //   120: invokeinterface 160 1 0
    //   125: checkcast 162	com/tencent/wxop/stat/ap
    //   128: getfield 165	com/tencent/wxop/stat/ap:a	J
    //   131: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: iload_3
    //   136: iload 4
    //   138: iconst_1
    //   139: isub
    //   140: if_icmpeq +263 -> 403
    //   143: aload 7
    //   145: ldc -86
    //   147: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: goto +252 -> 403
    //   154: aload 7
    //   156: ldc -84
    //   158: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: astore_1
    //   165: aload_0
    //   166: iload_2
    //   167: invokespecial 222	com/tencent/wxop/stat/ag:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   170: astore 6
    //   172: aload 6
    //   174: astore_1
    //   175: aload 6
    //   177: astore 5
    //   179: aload 6
    //   181: invokevirtual 227	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   184: aload 6
    //   186: astore_1
    //   187: aload 6
    //   189: astore 5
    //   191: aload 6
    //   193: ldc -17
    //   195: aload 7
    //   197: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aconst_null
    //   201: invokevirtual 245	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   204: istore_3
    //   205: aload 6
    //   207: astore_1
    //   208: aload 6
    //   210: astore 5
    //   212: invokestatic 183	com/tencent/wxop/stat/f:b	()Z
    //   215: ifeq +58 -> 273
    //   218: aload 6
    //   220: astore_1
    //   221: aload 6
    //   223: astore 5
    //   225: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   228: new 96	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 362
    //   235: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: iload 4
    //   240: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc_w 364
    //   246: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 7
    //   251: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 366
    //   260: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload_3
    //   264: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   273: aload 6
    //   275: astore_1
    //   276: aload 6
    //   278: astore 5
    //   280: aload_0
    //   281: aload_0
    //   282: getfield 65	com/tencent/wxop/stat/ag:a	I
    //   285: iload_3
    //   286: isub
    //   287: putfield 65	com/tencent/wxop/stat/ag:a	I
    //   290: aload 6
    //   292: astore_1
    //   293: aload 6
    //   295: astore 5
    //   297: aload 6
    //   299: invokevirtual 297	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   302: aload 6
    //   304: astore_1
    //   305: aload 6
    //   307: astore 5
    //   309: aload_0
    //   310: invokespecial 119	com/tencent/wxop/stat/ag:f	()V
    //   313: aload 6
    //   315: ifnull -296 -> 19
    //   318: aload 6
    //   320: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   323: goto -304 -> 19
    //   326: astore_1
    //   327: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   330: aload_1
    //   331: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   334: goto -315 -> 19
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: astore 6
    //   344: aload_1
    //   345: astore 5
    //   347: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   350: aload 6
    //   352: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   355: aload_1
    //   356: ifnull -337 -> 19
    //   359: aload_1
    //   360: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   363: goto -344 -> 19
    //   366: astore_1
    //   367: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   370: aload_1
    //   371: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   374: goto -355 -> 19
    //   377: astore_1
    //   378: aload 5
    //   380: ifnull +8 -> 388
    //   383: aload 5
    //   385: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   388: aload_1
    //   389: athrow
    //   390: astore 5
    //   392: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   395: aload 5
    //   397: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   400: goto -12 -> 388
    //   403: iload_3
    //   404: iconst_1
    //   405: iadd
    //   406: istore_3
    //   407: goto -299 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	ag
    //   0	410	1	paramList	List<ap>
    //   0	410	2	paramBoolean	boolean
    //   14	393	3	i1	int
    //   97	142	4	i2	int
    //   1	383	5	localObject	Object
    //   390	6	5	localThrowable1	Throwable
    //   4	315	6	localSQLiteDatabase	SQLiteDatabase
    //   342	9	6	localThrowable2	Throwable
    //   81	169	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   318	323	326	java/lang/Throwable
    //   8	15	337	finally
    //   22	66	337	finally
    //   66	106	337	finally
    //   108	135	337	finally
    //   143	151	337	finally
    //   154	162	337	finally
    //   318	323	337	finally
    //   327	334	337	finally
    //   359	363	337	finally
    //   367	374	337	finally
    //   383	388	337	finally
    //   388	390	337	finally
    //   392	400	337	finally
    //   165	172	342	java/lang/Throwable
    //   179	184	342	java/lang/Throwable
    //   191	205	342	java/lang/Throwable
    //   212	218	342	java/lang/Throwable
    //   225	273	342	java/lang/Throwable
    //   280	290	342	java/lang/Throwable
    //   297	302	342	java/lang/Throwable
    //   309	313	342	java/lang/Throwable
    //   359	363	366	java/lang/Throwable
    //   165	172	377	finally
    //   179	184	377	finally
    //   191	205	377	finally
    //   212	218	377	finally
    //   225	273	377	finally
    //   280	290	377	finally
    //   297	302	377	finally
    //   309	313	377	finally
    //   347	355	377	finally
    //   383	388	390	java/lang/Throwable
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localContentValues.put("status", Integer.valueOf(1));
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        int i1 = localSQLiteDatabase.update("events", localContentValues, "status=?", new String[] { Long.toString(2L) });
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        if (f.b())
        {
          localObject1 = localSQLiteDatabase;
          localObject3 = localSQLiteDatabase;
          h.b("update " + i1 + " unsent events.");
        }
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (Throwable localThrowable4)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject3 = localThrowable1;
        h.b(localThrowable4);
        if (localThrowable1 == null) {
          continue;
        }
        try
        {
          localThrowable1.endTransaction();
          return;
        }
        catch (Throwable localThrowable2)
        {
          h.b(localThrowable2);
          return;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label214;
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        return;
      }
      catch (Throwable localThrowable1)
      {
        h.b(localThrowable1);
        return;
      }
    }
    try
    {
      ((SQLiteDatabase)localObject3).endTransaction();
      label214:
      throw ((Throwable)localObject2);
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        h.b(localThrowable3);
      }
    }
  }
  
  private int b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return f.g();
    }
    return f.e();
  }
  
  public static ag b()
  {
    return j;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (!paramBoolean) {
        paramInt = g();
      }
    }
    for (;;)
    {
      if (paramInt > 0)
      {
        int i2 = f.m() * 60 * f.h();
        int i1 = paramInt;
        if (paramInt > i2)
        {
          i1 = paramInt;
          if (i2 > 0) {
            i1 = i2;
          }
        }
        int i3 = f.i();
        int i4 = i1 / i3;
        int i5 = i1 % i3;
        if (f.b()) {
          h.b("sentStoreEventsByDb sendNumbers=" + i1 + ",important=" + paramBoolean + ",maxSendNumPerFor1Period=" + i2 + ",maxCount=" + i4 + ",restNumbers=" + i5);
        }
        paramInt = 0;
        for (;;)
        {
          if (paramInt < i4)
          {
            a(i3, paramBoolean);
            paramInt += 1;
            continue;
            paramInt = h();
            break;
          }
        }
        if (i5 > 0) {
          a(i5, paramBoolean);
        }
      }
      return;
    }
  }
  
  /* Error */
  private void b(e parame, av paramav, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 229	com/tencent/wxop/stat/f:j	()I
    //   5: ifle +25 -> 30
    //   8: getstatic 415	com/tencent/wxop/stat/f:n	I
    //   11: ifle +12 -> 23
    //   14: iload_3
    //   15: ifne +8 -> 23
    //   18: iload 4
    //   20: ifeq +13 -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: iload_3
    //   27: invokespecial 417	com/tencent/wxop/stat/ag:a	(Lcom/tencent/wxop/stat/a/e;Lcom/tencent/wxop/stat/av;Z)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: getstatic 415	com/tencent/wxop/stat/f:n	I
    //   36: ifle -6 -> 30
    //   39: invokestatic 183	com/tencent/wxop/stat/f:b	()Z
    //   42: ifeq +83 -> 125
    //   45: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   48: new 96	java/lang/StringBuilder
    //   51: dup
    //   52: ldc_w 419
    //   55: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 71	com/tencent/wxop/stat/ag:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: invokevirtual 420	java/util/concurrent/ConcurrentHashMap:size	()I
    //   65: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc_w 422
    //   71: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: getstatic 415	com/tencent/wxop/stat/f:n	I
    //   77: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 424
    //   83: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 65	com/tencent/wxop/stat/ag:a	I
    //   90: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   99: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   102: new 96	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 426
    //   109: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 252	com/tencent/wxop/stat/a/e:g	()Ljava/lang/String;
    //   116: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   125: aload_0
    //   126: getfield 71	com/tencent/wxop/stat/ag:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   129: aload_1
    //   130: ldc 59
    //   132: invokevirtual 429	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload_0
    //   137: getfield 71	com/tencent/wxop/stat/ag:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   140: invokevirtual 420	java/util/concurrent/ConcurrentHashMap:size	()I
    //   143: getstatic 415	com/tencent/wxop/stat/f:n	I
    //   146: if_icmplt +7 -> 153
    //   149: aload_0
    //   150: invokespecial 317	com/tencent/wxop/stat/ag:i	()V
    //   153: aload_2
    //   154: ifnull -124 -> 30
    //   157: aload_0
    //   158: getfield 71	com/tencent/wxop/stat/ag:l	Ljava/util/concurrent/ConcurrentHashMap;
    //   161: invokevirtual 420	java/util/concurrent/ConcurrentHashMap:size	()I
    //   164: ifle +7 -> 171
    //   167: aload_0
    //   168: invokespecial 317	com/tencent/wxop/stat/ag:i	()V
    //   171: aload_2
    //   172: invokeinterface 308 1 0
    //   177: goto -147 -> 30
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ag
    //   0	185	1	parame	e
    //   0	185	2	paramav	av
    //   0	185	3	paramBoolean1	boolean
    //   0	185	4	paramBoolean2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	180	finally
    //   23	30	180	finally
    //   33	125	180	finally
    //   125	153	180	finally
    //   157	171	180	finally
    //   171	177	180	finally
  }
  
  /* Error */
  private void b(at paramat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 435	com/tencent/wxop/stat/at:a	()Ljava/lang/String;
    //   6: astore 7
    //   8: aload 7
    //   10: invokestatic 437	com/tencent/wxop/stat/b/m:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 5
    //   15: new 247	android/content/ContentValues
    //   18: dup
    //   19: invokespecial 248	android/content/ContentValues:<init>	()V
    //   22: astore 8
    //   24: aload 8
    //   26: ldc_w 256
    //   29: aload_1
    //   30: getfield 440	com/tencent/wxop/stat/at:b	Lorg/json/JSONObject;
    //   33: invokevirtual 443	org/json/JSONObject:toString	()Ljava/lang/String;
    //   36: invokevirtual 265	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload 8
    //   41: ldc_w 445
    //   44: aload 5
    //   46: invokevirtual 265	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: aload 5
    //   52: putfield 447	com/tencent/wxop/stat/at:c	Ljava/lang/String;
    //   55: aload 8
    //   57: ldc_w 449
    //   60: aload_1
    //   61: getfield 451	com/tencent/wxop/stat/at:d	I
    //   64: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   70: aload_0
    //   71: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   74: invokevirtual 454	com/tencent/wxop/stat/ao:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   77: ldc_w 456
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: invokevirtual 460	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: invokeinterface 465 1 0
    //   102: ifeq +324 -> 426
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: iconst_0
    //   112: invokeinterface 469 2 0
    //   117: aload_1
    //   118: getfield 470	com/tencent/wxop/stat/at:a	I
    //   121: if_icmpne -30 -> 91
    //   124: iconst_1
    //   125: istore_2
    //   126: aload 6
    //   128: astore 5
    //   130: aload_0
    //   131: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   134: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   137: invokevirtual 227	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   140: iconst_1
    //   141: iload_2
    //   142: if_icmpne +116 -> 258
    //   145: aload 6
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   153: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   156: ldc_w 456
    //   159: aload 8
    //   161: ldc_w 472
    //   164: iconst_1
    //   165: anewarray 377	java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: getfield 470	com/tencent/wxop/stat/at:a	I
    //   174: invokestatic 276	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   177: aastore
    //   178: invokevirtual 386	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   181: i2l
    //   182: lstore_3
    //   183: lload_3
    //   184: ldc2_w 309
    //   187: lcmp
    //   188: ifne +113 -> 301
    //   191: aload 6
    //   193: astore 5
    //   195: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   198: new 96	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 474
    //   205: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 7
    //   210: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 476	com/tencent/wxop/stat/b/b:h	(Ljava/lang/Object;)V
    //   219: aload 6
    //   221: astore 5
    //   223: aload_0
    //   224: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   227: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   230: invokevirtual 297	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   233: aload 6
    //   235: ifnull +10 -> 245
    //   238: aload 6
    //   240: invokeinterface 479 1 0
    //   245: aload_0
    //   246: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   249: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   252: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: aload_0
    //   256: monitorexit
    //   257: return
    //   258: aload 6
    //   260: astore 5
    //   262: aload 8
    //   264: ldc_w 481
    //   267: aload_1
    //   268: getfield 470	com/tencent/wxop/stat/at:a	I
    //   271: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   277: aload 6
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   285: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   288: ldc_w 456
    //   291: aconst_null
    //   292: aload 8
    //   294: invokevirtual 294	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   297: lstore_3
    //   298: goto -115 -> 183
    //   301: aload 6
    //   303: astore 5
    //   305: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   308: new 96	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 483
    //   315: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload 7
    //   320: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokevirtual 304	com/tencent/wxop/stat/b/b:j	(Ljava/lang/Object;)V
    //   329: goto -110 -> 219
    //   332: astore_1
    //   333: aload 6
    //   335: astore 5
    //   337: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   340: aload_1
    //   341: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   344: aload 6
    //   346: ifnull +10 -> 356
    //   349: aload 6
    //   351: invokeinterface 479 1 0
    //   356: aload_0
    //   357: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   360: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   363: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   366: goto -111 -> 255
    //   369: astore_1
    //   370: goto -115 -> 255
    //   373: astore_1
    //   374: aconst_null
    //   375: astore 5
    //   377: aload 5
    //   379: ifnull +10 -> 389
    //   382: aload 5
    //   384: invokeinterface 479 1 0
    //   389: aload_0
    //   390: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   393: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   396: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   399: aload_1
    //   400: athrow
    //   401: astore_1
    //   402: aload_0
    //   403: monitorexit
    //   404: aload_1
    //   405: athrow
    //   406: astore 5
    //   408: goto -9 -> 399
    //   411: astore_1
    //   412: goto -35 -> 377
    //   415: astore_1
    //   416: aconst_null
    //   417: astore 6
    //   419: goto -86 -> 333
    //   422: astore_1
    //   423: goto -168 -> 255
    //   426: iconst_0
    //   427: istore_2
    //   428: goto -302 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	ag
    //   0	431	1	paramat	at
    //   125	303	2	i1	int
    //   182	116	3	l1	long
    //   13	370	5	localObject	Object
    //   406	1	5	localException	Exception
    //   89	329	6	localCursor	android.database.Cursor
    //   6	313	7	str	String
    //   22	271	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   95	105	332	java/lang/Throwable
    //   109	124	332	java/lang/Throwable
    //   130	140	332	java/lang/Throwable
    //   149	183	332	java/lang/Throwable
    //   195	219	332	java/lang/Throwable
    //   223	233	332	java/lang/Throwable
    //   262	277	332	java/lang/Throwable
    //   281	298	332	java/lang/Throwable
    //   305	329	332	java/lang/Throwable
    //   356	366	369	java/lang/Exception
    //   2	91	373	finally
    //   238	245	401	finally
    //   245	255	401	finally
    //   349	356	401	finally
    //   356	366	401	finally
    //   382	389	401	finally
    //   389	399	401	finally
    //   399	401	401	finally
    //   389	399	406	java/lang/Exception
    //   95	105	411	finally
    //   109	124	411	finally
    //   130	140	411	finally
    //   149	183	411	finally
    //   195	219	411	finally
    //   223	233	411	finally
    //   262	277	411	finally
    //   281	298	411	finally
    //   305	329	411	finally
    //   337	344	411	finally
    //   2	91	415	java/lang/Throwable
    //   245	255	422	java/lang/Exception
  }
  
  /* Error */
  private void b(List<ap> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_3
    //   2: invokespecial 485	com/tencent/wxop/stat/ag:d	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   5: astore 7
    //   7: iconst_1
    //   8: invokestatic 276	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   11: astore 8
    //   13: iload_2
    //   14: invokestatic 276	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   17: astore 9
    //   19: aload 7
    //   21: ldc -17
    //   23: aconst_null
    //   24: ldc_w 375
    //   27: iconst_1
    //   28: anewarray 377	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload 8
    //   35: aastore
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aload 9
    //   41: invokevirtual 488	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 7
    //   46: aload 7
    //   48: invokeinterface 465 1 0
    //   53: ifeq +173 -> 226
    //   56: aload 7
    //   58: iconst_0
    //   59: invokeinterface 492 2 0
    //   64: lstore 5
    //   66: aload 7
    //   68: iconst_1
    //   69: invokeinterface 495 2 0
    //   74: astore 9
    //   76: aload 9
    //   78: astore 8
    //   80: getstatic 497	com/tencent/wxop/stat/f:g	Z
    //   83: ifne +10 -> 93
    //   86: aload 9
    //   88: invokestatic 498	com/tencent/wxop/stat/b/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 8
    //   93: aload 7
    //   95: iconst_2
    //   96: invokeinterface 469 2 0
    //   101: istore_2
    //   102: aload 7
    //   104: iconst_3
    //   105: invokeinterface 469 2 0
    //   110: istore 4
    //   112: new 162	com/tencent/wxop/stat/ap
    //   115: dup
    //   116: lload 5
    //   118: aload 8
    //   120: iload_2
    //   121: iload 4
    //   123: invokespecial 501	com/tencent/wxop/stat/ap:<init>	(JLjava/lang/String;II)V
    //   126: astore 8
    //   128: invokestatic 183	com/tencent/wxop/stat/f:b	()Z
    //   131: ifeq +55 -> 186
    //   134: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   137: new 96	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 503
    //   144: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: lload 5
    //   149: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   152: ldc_w 505
    //   155: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload 4
    //   160: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc_w 507
    //   166: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 7
    //   171: iconst_4
    //   172: invokeinterface 492 2 0
    //   177: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   186: aload_1
    //   187: aload 8
    //   189: invokeinterface 511 2 0
    //   194: pop
    //   195: goto -149 -> 46
    //   198: astore 8
    //   200: aload 7
    //   202: astore_1
    //   203: aload 8
    //   205: astore 7
    //   207: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   210: aload 7
    //   212: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   215: aload_1
    //   216: ifnull +9 -> 225
    //   219: aload_1
    //   220: invokeinterface 479 1 0
    //   225: return
    //   226: aload 7
    //   228: ifnull -3 -> 225
    //   231: aload 7
    //   233: invokeinterface 479 1 0
    //   238: return
    //   239: astore_1
    //   240: aconst_null
    //   241: astore 7
    //   243: aload 7
    //   245: ifnull +10 -> 255
    //   248: aload 7
    //   250: invokeinterface 479 1 0
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: goto -15 -> 243
    //   261: astore 8
    //   263: aload_1
    //   264: astore 7
    //   266: aload 8
    //   268: astore_1
    //   269: goto -26 -> 243
    //   272: astore 7
    //   274: aconst_null
    //   275: astore_1
    //   276: goto -69 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	ag
    //   0	279	1	paramList	List<ap>
    //   0	279	2	paramInt	int
    //   0	279	3	paramBoolean	boolean
    //   110	49	4	i1	int
    //   64	84	5	l1	long
    //   5	260	7	localObject1	Object
    //   272	1	7	localThrowable1	Throwable
    //   11	177	8	localObject2	Object
    //   198	6	8	localThrowable2	Throwable
    //   261	6	8	localObject3	Object
    //   17	70	9	str	String
    // Exception table:
    //   from	to	target	type
    //   46	76	198	java/lang/Throwable
    //   80	93	198	java/lang/Throwable
    //   93	186	198	java/lang/Throwable
    //   186	195	198	java/lang/Throwable
    //   0	46	239	finally
    //   46	76	257	finally
    //   80	93	257	finally
    //   93	186	257	finally
    //   186	195	257	finally
    //   207	215	261	finally
    //   0	46	272	java/lang/Throwable
  }
  
  private SQLiteDatabase c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getWritableDatabase();
    }
    return this.d.getWritableDatabase();
  }
  
  private SQLiteDatabase d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.getReadableDatabase();
    }
    return this.d.getReadableDatabase();
  }
  
  private void f()
  {
    this.a = (g() + h());
  }
  
  private int g()
  {
    return (int)DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
  }
  
  private int h()
  {
    return (int)DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
  }
  
  private void i()
  {
    localObject5 = null;
    Object localObject1 = null;
    if (this.m) {
      return;
    }
    synchronized (this.l)
    {
      if (this.l.size() == 0) {
        return;
      }
    }
    this.m = true;
    if (f.b()) {
      h.b("insert " + this.l.size() + " events ,numEventsCachedInMemory:" + f.n + ",numStoredEvents:" + this.a);
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
      Object localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject3 = localSQLiteDatabase;
      localObject5 = localSQLiteDatabase;
      Iterator localIterator = this.l.entrySet().iterator();
      for (;;)
      {
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        e locale = (e)((Map.Entry)localIterator.next()).getKey();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        String str = locale.g();
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        if (f.b())
        {
          localObject3 = localSQLiteDatabase;
          localObject5 = localSQLiteDatabase;
          h.b("insert content:" + str);
        }
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("content", s.b(str));
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("send_count", "0");
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("status", Integer.toString(1));
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localContentValues.put("timestamp", Long.valueOf(locale.c()));
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localSQLiteDatabase.insert("events", null, localContentValues);
        localObject3 = localSQLiteDatabase;
        localObject5 = localSQLiteDatabase;
        localIterator.remove();
      }
      try
      {
        ((SQLiteDatabase)localObject5).endTransaction();
        f();
        throw ((Throwable)localObject4);
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          h.b(localThrowable3);
        }
      }
    }
    catch (Throwable localThrowable4)
    {
      localObject5 = localObject3;
      h.b(localThrowable4);
      if (localObject3 != null) {}
      try
      {
        ((SQLiteDatabase)localObject3).endTransaction();
        f();
        for (;;)
        {
          this.m = false;
          if (f.b()) {
            h.b("after insert, cacheEventsInMemory.size():" + this.l.size() + ",numEventsCachedInMemory:" + f.n + ",numStoredEvents:" + this.a);
          }
          return;
          localObject3 = localThrowable4;
          localObject5 = localThrowable4;
          localThrowable4.setTransactionSuccessful();
          if (localThrowable4 != null) {
            try
            {
              localThrowable4.endTransaction();
              f();
            }
            catch (Throwable localThrowable1)
            {
              h.b(localThrowable1);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          h.b(localThrowable2);
        }
      }
    }
    finally
    {
      if (localObject5 == null) {}
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   4: invokevirtual 454	com/tencent/wxop/stat/ao:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 542
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 460	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokeinterface 465 1 0
    //   28: ifeq +51 -> 79
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 78	com/tencent/wxop/stat/ag:n	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 495 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 495 2 0
    //   51: invokevirtual 543	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -35 -> 20
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   64: aload_3
    //   65: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 479 1 0
    //   78: return
    //   79: aload_2
    //   80: ifnull -2 -> 78
    //   83: aload_2
    //   84: invokeinterface 479 1 0
    //   89: return
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +9 -> 103
    //   97: aload_1
    //   98: invokeinterface 479 1 0
    //   103: aload_2
    //   104: athrow
    //   105: astore_2
    //   106: goto -13 -> 93
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_2
    //   112: goto -53 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	ag
    //   21	77	1	localCursor1	android.database.Cursor
    //   19	65	2	localCursor2	android.database.Cursor
    //   90	14	2	localObject1	Object
    //   105	1	2	localObject2	Object
    //   111	1	2	localObject3	Object
    //   58	7	3	localThrowable1	Throwable
    //   109	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	31	58	java/lang/Throwable
    //   33	55	58	java/lang/Throwable
    //   0	20	90	finally
    //   22	31	105	finally
    //   33	55	105	finally
    //   61	68	105	finally
    //   0	20	109	java/lang/Throwable
  }
  
  public int a()
  {
    return this.a;
  }
  
  void a(int paramInt)
  {
    this.e.a(new an(this, paramInt));
  }
  
  void a(e parame, av paramav, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.a(new ak(this, parame, paramav, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(at paramat)
  {
    if (paramat == null) {
      return;
    }
    this.e.a(new al(this, paramat));
  }
  
  void a(List<ap> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.a(new ah(this, paramList, paramInt, paramBoolean1, paramBoolean2));
    }
  }
  
  void a(List<ap> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e != null) {
      this.e.a(new ai(this, paramList, paramBoolean1, paramBoolean2));
    }
  }
  
  /* Error */
  public c b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/wxop/stat/ag:b	Lcom/tencent/wxop/stat/b/c;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 67	com/tencent/wxop/stat/ag:b	Lcom/tencent/wxop/stat/b/c;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   22: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: invokevirtual 227	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   28: invokestatic 183	com/tencent/wxop/stat/f:b	()Z
    //   31: ifeq +12 -> 43
    //   34: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   37: ldc_w 575
    //   40: invokevirtual 193	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   47: invokevirtual 454	com/tencent/wxop/stat/ao:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc_w 577
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 488	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 11
    //   65: iconst_0
    //   66: istore_2
    //   67: aload 11
    //   69: invokeinterface 465 1 0
    //   74: ifeq +365 -> 439
    //   77: aload 11
    //   79: iconst_0
    //   80: invokeinterface 495 2 0
    //   85: astore 16
    //   87: aload 16
    //   89: invokestatic 498	com/tencent/wxop/stat/b/s:a	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 12
    //   94: aload 11
    //   96: iconst_1
    //   97: invokeinterface 469 2 0
    //   102: istore 5
    //   104: aload 11
    //   106: iconst_2
    //   107: invokeinterface 495 2 0
    //   112: astore 10
    //   114: aload 11
    //   116: iconst_3
    //   117: invokeinterface 492 2 0
    //   122: lstore 6
    //   124: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   127: ldc2_w 583
    //   130: ldiv
    //   131: lstore 8
    //   133: iload 5
    //   135: iconst_1
    //   136: if_icmpeq +754 -> 890
    //   139: lload 6
    //   141: ldc2_w 583
    //   144: lmul
    //   145: invokestatic 586	com/tencent/wxop/stat/b/m:a	(J)Ljava/lang/String;
    //   148: ldc2_w 583
    //   151: lload 8
    //   153: lmul
    //   154: invokestatic 586	com/tencent/wxop/stat/b/m:a	(J)Ljava/lang/String;
    //   157: invokevirtual 589	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifne +730 -> 890
    //   163: iconst_1
    //   164: istore_2
    //   165: aload 10
    //   167: aload_1
    //   168: invokestatic 591	com/tencent/wxop/stat/b/m:n	(Landroid/content/Context;)Ljava/lang/String;
    //   171: invokevirtual 589	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifne +711 -> 885
    //   177: iload_2
    //   178: iconst_2
    //   179: ior
    //   180: istore_3
    //   181: aload 12
    //   183: ldc -86
    //   185: invokevirtual 595	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   188: astore 14
    //   190: iconst_0
    //   191: istore 4
    //   193: iconst_0
    //   194: istore_2
    //   195: aload 14
    //   197: ifnull +441 -> 638
    //   200: aload 14
    //   202: arraylength
    //   203: ifle +435 -> 638
    //   206: aload 14
    //   208: iconst_0
    //   209: aaload
    //   210: astore 10
    //   212: aload 10
    //   214: ifnull +13 -> 227
    //   217: aload 10
    //   219: invokevirtual 598	java/lang/String:length	()I
    //   222: bipush 11
    //   224: if_icmpge +646 -> 870
    //   227: aload_1
    //   228: invokestatic 600	com/tencent/wxop/stat/b/s:a	(Landroid/content/Context;)Ljava/lang/String;
    //   231: astore 13
    //   233: aload 13
    //   235: ifnull +629 -> 864
    //   238: aload 13
    //   240: invokevirtual 598	java/lang/String:length	()I
    //   243: bipush 10
    //   245: if_icmple +619 -> 864
    //   248: iconst_1
    //   249: istore_2
    //   250: aload 13
    //   252: astore 10
    //   254: goto +642 -> 896
    //   257: aload 14
    //   259: ifnull +394 -> 653
    //   262: aload 14
    //   264: arraylength
    //   265: iconst_2
    //   266: if_icmplt +387 -> 653
    //   269: aload 14
    //   271: iconst_1
    //   272: aaload
    //   273: astore 14
    //   275: new 96	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 601	java/lang/StringBuilder:<init>	()V
    //   282: aload 12
    //   284: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc -86
    //   289: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 14
    //   294: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 13
    //   302: iload_2
    //   303: istore 4
    //   305: aload_0
    //   306: new 603	com/tencent/wxop/stat/b/c
    //   309: dup
    //   310: aload 12
    //   312: aload 14
    //   314: iload_3
    //   315: invokespecial 606	com/tencent/wxop/stat/b/c:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   318: putfield 67	com/tencent/wxop/stat/ag:b	Lcom/tencent/wxop/stat/b/c;
    //   321: new 247	android/content/ContentValues
    //   324: dup
    //   325: invokespecial 248	android/content/ContentValues:<init>	()V
    //   328: astore 10
    //   330: aload 10
    //   332: ldc_w 608
    //   335: aload 13
    //   337: invokestatic 261	com/tencent/wxop/stat/b/s:b	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokevirtual 265	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 10
    //   345: ldc_w 610
    //   348: iload_3
    //   349: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   355: aload 10
    //   357: ldc_w 612
    //   360: aload_1
    //   361: invokestatic 591	com/tencent/wxop/stat/b/m:n	(Landroid/content/Context;)Ljava/lang/String;
    //   364: invokevirtual 265	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload 10
    //   369: ldc_w 614
    //   372: lload 8
    //   374: invokestatic 287	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   377: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   380: iload 4
    //   382: ifeq +31 -> 413
    //   385: aload_0
    //   386: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   389: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   392: ldc_w 577
    //   395: aload 10
    //   397: ldc_w 616
    //   400: iconst_1
    //   401: anewarray 377	java/lang/String
    //   404: dup
    //   405: iconst_0
    //   406: aload 16
    //   408: aastore
    //   409: invokevirtual 386	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   412: pop
    //   413: iload_3
    //   414: iload 5
    //   416: if_icmpeq +495 -> 911
    //   419: aload_0
    //   420: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   423: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   426: ldc_w 577
    //   429: aconst_null
    //   430: aload 10
    //   432: invokevirtual 619	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   435: pop2
    //   436: goto +475 -> 911
    //   439: iload_2
    //   440: ifne +158 -> 598
    //   443: aload_1
    //   444: invokestatic 621	com/tencent/wxop/stat/b/m:b	(Landroid/content/Context;)Ljava/lang/String;
    //   447: astore 12
    //   449: aload_1
    //   450: invokestatic 623	com/tencent/wxop/stat/b/m:c	(Landroid/content/Context;)Ljava/lang/String;
    //   453: astore 13
    //   455: aload 13
    //   457: ifnull +400 -> 857
    //   460: aload 13
    //   462: invokevirtual 598	java/lang/String:length	()I
    //   465: ifle +392 -> 857
    //   468: new 96	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 601	java/lang/StringBuilder:<init>	()V
    //   475: aload 12
    //   477: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc -86
    //   482: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 13
    //   487: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: astore 10
    //   495: invokestatic 582	java/lang/System:currentTimeMillis	()J
    //   498: ldc2_w 583
    //   501: ldiv
    //   502: lstore 6
    //   504: aload_1
    //   505: invokestatic 591	com/tencent/wxop/stat/b/m:n	(Landroid/content/Context;)Ljava/lang/String;
    //   508: astore_1
    //   509: new 247	android/content/ContentValues
    //   512: dup
    //   513: invokespecial 248	android/content/ContentValues:<init>	()V
    //   516: astore 14
    //   518: aload 14
    //   520: ldc_w 608
    //   523: aload 10
    //   525: invokestatic 261	com/tencent/wxop/stat/b/s:b	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokevirtual 265	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload 14
    //   533: ldc_w 610
    //   536: iconst_0
    //   537: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   540: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   543: aload 14
    //   545: ldc_w 612
    //   548: aload_1
    //   549: invokevirtual 265	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload 14
    //   554: ldc_w 614
    //   557: lload 6
    //   559: invokestatic 287	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   562: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   565: aload_0
    //   566: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   569: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   572: ldc_w 577
    //   575: aconst_null
    //   576: aload 14
    //   578: invokevirtual 294	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   581: pop2
    //   582: aload_0
    //   583: new 603	com/tencent/wxop/stat/b/c
    //   586: dup
    //   587: aload 12
    //   589: aload 13
    //   591: iconst_0
    //   592: invokespecial 606	com/tencent/wxop/stat/b/c:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   595: putfield 67	com/tencent/wxop/stat/ag:b	Lcom/tencent/wxop/stat/b/c;
    //   598: aload_0
    //   599: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   602: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   605: invokevirtual 297	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   608: aload 11
    //   610: ifnull +10 -> 620
    //   613: aload 11
    //   615: invokeinterface 479 1 0
    //   620: aload_0
    //   621: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   624: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   627: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   630: aload_0
    //   631: getfield 67	com/tencent/wxop/stat/ag:b	Lcom/tencent/wxop/stat/b/c;
    //   634: astore_1
    //   635: goto -621 -> 14
    //   638: aload_1
    //   639: invokestatic 621	com/tencent/wxop/stat/b/m:b	(Landroid/content/Context;)Ljava/lang/String;
    //   642: astore 10
    //   644: iconst_1
    //   645: istore_2
    //   646: aload 10
    //   648: astore 12
    //   650: goto -393 -> 257
    //   653: aload_1
    //   654: invokestatic 623	com/tencent/wxop/stat/b/m:c	(Landroid/content/Context;)Ljava/lang/String;
    //   657: astore 15
    //   659: iload_2
    //   660: istore 4
    //   662: aload 15
    //   664: astore 14
    //   666: aload 10
    //   668: astore 13
    //   670: aload 15
    //   672: ifnull -367 -> 305
    //   675: iload_2
    //   676: istore 4
    //   678: aload 15
    //   680: astore 14
    //   682: aload 10
    //   684: astore 13
    //   686: aload 15
    //   688: invokevirtual 598	java/lang/String:length	()I
    //   691: ifle -386 -> 305
    //   694: new 96	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 601	java/lang/StringBuilder:<init>	()V
    //   701: aload 12
    //   703: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: ldc -86
    //   708: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 15
    //   713: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: astore 13
    //   721: iconst_1
    //   722: istore 4
    //   724: aload 15
    //   726: astore 14
    //   728: goto -423 -> 305
    //   731: astore_1
    //   732: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   735: aload_1
    //   736: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   739: goto -109 -> 630
    //   742: astore_1
    //   743: aload_0
    //   744: monitorexit
    //   745: aload_1
    //   746: athrow
    //   747: astore 10
    //   749: aconst_null
    //   750: astore_1
    //   751: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   754: aload 10
    //   756: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   759: aload_1
    //   760: ifnull +9 -> 769
    //   763: aload_1
    //   764: invokeinterface 479 1 0
    //   769: aload_0
    //   770: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   773: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   776: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   779: goto -149 -> 630
    //   782: astore_1
    //   783: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   786: aload_1
    //   787: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   790: goto -160 -> 630
    //   793: astore_1
    //   794: aconst_null
    //   795: astore 11
    //   797: aload 11
    //   799: ifnull +10 -> 809
    //   802: aload 11
    //   804: invokeinterface 479 1 0
    //   809: aload_0
    //   810: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   813: invokevirtual 237	com/tencent/wxop/stat/ao:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   816: invokevirtual 300	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   819: aload_1
    //   820: athrow
    //   821: astore 10
    //   823: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   826: aload 10
    //   828: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   831: goto -12 -> 819
    //   834: astore_1
    //   835: goto -38 -> 797
    //   838: astore 10
    //   840: aload_1
    //   841: astore 11
    //   843: aload 10
    //   845: astore_1
    //   846: goto -49 -> 797
    //   849: astore 10
    //   851: aload 11
    //   853: astore_1
    //   854: goto -103 -> 751
    //   857: aload 12
    //   859: astore 10
    //   861: goto -366 -> 495
    //   864: iload 4
    //   866: istore_2
    //   867: goto +29 -> 896
    //   870: aload 10
    //   872: astore 13
    //   874: aload 12
    //   876: astore 10
    //   878: aload 13
    //   880: astore 12
    //   882: goto -625 -> 257
    //   885: iload_2
    //   886: istore_3
    //   887: goto -706 -> 181
    //   890: iload 5
    //   892: istore_2
    //   893: goto -728 -> 165
    //   896: aload 10
    //   898: astore 13
    //   900: aload 12
    //   902: astore 10
    //   904: aload 13
    //   906: astore 12
    //   908: goto -651 -> 257
    //   911: iconst_1
    //   912: istore_2
    //   913: goto -474 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	916	0	this	ag
    //   0	916	1	paramContext	Context
    //   66	847	2	i1	int
    //   180	707	3	i2	int
    //   191	674	4	i3	int
    //   102	789	5	i4	int
    //   122	436	6	l1	long
    //   131	242	8	l2	long
    //   112	571	10	localObject1	Object
    //   747	8	10	localThrowable1	Throwable
    //   821	6	10	localThrowable2	Throwable
    //   838	6	10	localObject2	Object
    //   849	1	10	localThrowable3	Throwable
    //   859	44	10	localObject3	Object
    //   63	789	11	localObject4	Object
    //   92	815	12	localObject5	Object
    //   231	674	13	localObject6	Object
    //   188	539	14	localObject7	Object
    //   657	68	15	str1	String
    //   85	322	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   613	620	731	java/lang/Throwable
    //   620	630	731	java/lang/Throwable
    //   2	14	742	finally
    //   613	620	742	finally
    //   620	630	742	finally
    //   630	635	742	finally
    //   732	739	742	finally
    //   763	769	742	finally
    //   769	779	742	finally
    //   783	790	742	finally
    //   802	809	742	finally
    //   809	819	742	finally
    //   819	821	742	finally
    //   823	831	742	finally
    //   18	43	747	java/lang/Throwable
    //   43	65	747	java/lang/Throwable
    //   763	769	782	java/lang/Throwable
    //   769	779	782	java/lang/Throwable
    //   18	43	793	finally
    //   43	65	793	finally
    //   802	809	821	java/lang/Throwable
    //   809	819	821	java/lang/Throwable
    //   67	133	834	finally
    //   139	163	834	finally
    //   165	177	834	finally
    //   181	190	834	finally
    //   200	206	834	finally
    //   217	227	834	finally
    //   227	233	834	finally
    //   238	248	834	finally
    //   262	269	834	finally
    //   275	302	834	finally
    //   305	380	834	finally
    //   385	413	834	finally
    //   419	436	834	finally
    //   443	455	834	finally
    //   460	495	834	finally
    //   495	598	834	finally
    //   598	608	834	finally
    //   638	644	834	finally
    //   653	659	834	finally
    //   686	721	834	finally
    //   751	759	838	finally
    //   67	133	849	java/lang/Throwable
    //   139	163	849	java/lang/Throwable
    //   165	177	849	java/lang/Throwable
    //   181	190	849	java/lang/Throwable
    //   200	206	849	java/lang/Throwable
    //   217	227	849	java/lang/Throwable
    //   227	233	849	java/lang/Throwable
    //   238	248	849	java/lang/Throwable
    //   262	269	849	java/lang/Throwable
    //   275	302	849	java/lang/Throwable
    //   305	380	849	java/lang/Throwable
    //   385	413	849	java/lang/Throwable
    //   419	436	849	java/lang/Throwable
    //   443	455	849	java/lang/Throwable
    //   460	495	849	java/lang/Throwable
    //   495	598	849	java/lang/Throwable
    //   598	608	849	java/lang/Throwable
    //   638	644	849	java/lang/Throwable
    //   653	659	849	java/lang/Throwable
    //   686	721	849	java/lang/Throwable
  }
  
  void c()
  {
    if (!f.c()) {
      return;
    }
    try
    {
      this.e.a(new aj(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      h.b(localThrowable);
    }
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/wxop/stat/ag:c	Lcom/tencent/wxop/stat/ao;
    //   4: invokevirtual 454	com/tencent/wxop/stat/ao:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 456
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 460	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload 4
    //   26: invokeinterface 465 1 0
    //   31: ifeq +151 -> 182
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: iconst_0
    //   40: invokeinterface 469 2 0
    //   45: istore_1
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: iconst_1
    //   52: invokeinterface 495 2 0
    //   57: astore 5
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: iconst_2
    //   65: invokeinterface 495 2 0
    //   70: astore 6
    //   72: aload 4
    //   74: astore_3
    //   75: aload 4
    //   77: iconst_3
    //   78: invokeinterface 469 2 0
    //   83: istore_2
    //   84: aload 4
    //   86: astore_3
    //   87: new 433	com/tencent/wxop/stat/at
    //   90: dup
    //   91: iload_1
    //   92: invokespecial 630	com/tencent/wxop/stat/at:<init>	(I)V
    //   95: astore 7
    //   97: aload 4
    //   99: astore_3
    //   100: aload 7
    //   102: iload_1
    //   103: putfield 470	com/tencent/wxop/stat/at:a	I
    //   106: aload 4
    //   108: astore_3
    //   109: aload 7
    //   111: new 442	org/json/JSONObject
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 631	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: putfield 440	com/tencent/wxop/stat/at:b	Lorg/json/JSONObject;
    //   123: aload 4
    //   125: astore_3
    //   126: aload 7
    //   128: aload 6
    //   130: putfield 447	com/tencent/wxop/stat/at:c	Ljava/lang/String;
    //   133: aload 4
    //   135: astore_3
    //   136: aload 7
    //   138: iload_2
    //   139: putfield 451	com/tencent/wxop/stat/at:d	I
    //   142: aload 4
    //   144: astore_3
    //   145: getstatic 42	com/tencent/wxop/stat/ag:i	Landroid/content/Context;
    //   148: aload 7
    //   150: invokestatic 634	com/tencent/wxop/stat/f:a	(Landroid/content/Context;Lcom/tencent/wxop/stat/at;)V
    //   153: goto -132 -> 21
    //   156: astore 5
    //   158: aload 4
    //   160: astore_3
    //   161: getstatic 40	com/tencent/wxop/stat/ag:h	Lcom/tencent/wxop/stat/b/b;
    //   164: aload 5
    //   166: invokevirtual 131	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 479 1 0
    //   181: return
    //   182: aload 4
    //   184: ifnull -3 -> 181
    //   187: aload 4
    //   189: invokeinterface 479 1 0
    //   194: return
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_3
    //   199: aload_3
    //   200: ifnull +9 -> 209
    //   203: aload_3
    //   204: invokeinterface 479 1 0
    //   209: aload 4
    //   211: athrow
    //   212: astore 4
    //   214: goto -15 -> 199
    //   217: astore 5
    //   219: aconst_null
    //   220: astore 4
    //   222: goto -64 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	ag
    //   45	58	1	i1	int
    //   83	56	2	i2	int
    //   23	181	3	localCursor1	android.database.Cursor
    //   19	169	4	localCursor2	android.database.Cursor
    //   195	15	4	localObject1	Object
    //   212	1	4	localObject2	Object
    //   220	1	4	localObject3	Object
    //   57	59	5	str1	String
    //   156	9	5	localThrowable1	Throwable
    //   217	1	5	localThrowable2	Throwable
    //   70	59	6	str2	String
    //   95	54	7	localat	at
    // Exception table:
    //   from	to	target	type
    //   24	34	156	java/lang/Throwable
    //   37	46	156	java/lang/Throwable
    //   49	59	156	java/lang/Throwable
    //   62	72	156	java/lang/Throwable
    //   75	84	156	java/lang/Throwable
    //   87	97	156	java/lang/Throwable
    //   100	106	156	java/lang/Throwable
    //   109	123	156	java/lang/Throwable
    //   126	133	156	java/lang/Throwable
    //   136	142	156	java/lang/Throwable
    //   145	153	156	java/lang/Throwable
    //   0	21	195	finally
    //   24	34	212	finally
    //   37	46	212	finally
    //   49	59	212	finally
    //   62	72	212	finally
    //   75	84	212	finally
    //   87	97	212	finally
    //   100	106	212	finally
    //   109	123	212	finally
    //   126	133	212	finally
    //   136	142	212	finally
    //   145	153	212	finally
    //   161	169	212	finally
    //   0	21	217	java/lang/Throwable
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */