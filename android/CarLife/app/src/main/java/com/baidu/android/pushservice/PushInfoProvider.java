package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.android.pushservice.d.c;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.p;

public class PushInfoProvider
  extends ContentProvider
{
  private static final UriMatcher c = new UriMatcher(-1);
  SQLiteDatabase a;
  private Context b;
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    this.b = getContext();
    if (p.F(this.b)) {}
    for (String str = "pushinfo_v3";; str = "pushinfo")
    {
      c.addURI(this.b.getPackageName() + ".bdpush", str, 1);
      c.addURI(this.b.getPackageName() + ".bdpush", "verif", 2);
      c.addURI(this.b.getPackageName() + ".bdpush", "msgInfo", 3);
      c.addURI(this.b.getPackageName() + ".bdpush", "appstatus", 4);
      return true;
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    for (;;)
    {
      synchronized ()
      {
        try
        {
          int i = c.match(paramUri);
          switch (i)
          {
          }
        }
        catch (Exception paramUri)
        {
          q.a(this.b, paramUri);
          continue;
        }
        paramUri = null;
        return paramUri;
        this.a = c.a(this.b);
        if (this.a == null) {
          break label250;
        }
        paramArrayOfString1 = this.a.query("PushShareInfo", null, null, null, null, null, null);
        break label252;
        this.a = c.a(this.b);
        if (this.a == null) {
          break label245;
        }
        paramArrayOfString1 = this.a.query("PushVerifInfo", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break label263;
        this.a = c.a(this.b);
        if (this.a == null) {
          break label240;
        }
        paramArrayOfString1 = this.a.query("PushMsgInfos", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break label274;
        this.a = c.a(this.b);
        if (this.a != null)
        {
          paramArrayOfString1 = this.a.query("PushAppStatus", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
          paramUri = paramArrayOfString1;
          if (paramArrayOfString1 == null) {
            continue;
          }
          paramUri = paramArrayOfString1;
        }
      }
      paramArrayOfString1 = null;
      continue;
      label240:
      paramArrayOfString1 = null;
      break label274;
      label245:
      paramArrayOfString1 = null;
      break label263;
      label250:
      paramArrayOfString1 = null;
      label252:
      paramUri = paramArrayOfString1;
      if (paramArrayOfString1 != null)
      {
        paramUri = paramArrayOfString1;
        continue;
        label263:
        paramUri = paramArrayOfString1;
        if (paramArrayOfString1 != null)
        {
          paramUri = paramArrayOfString1;
          continue;
          label274:
          paramUri = paramArrayOfString1;
          if (paramArrayOfString1 != null) {
            paramUri = paramArrayOfString1;
          }
        }
      }
    }
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: invokestatic 84	com/baidu/android/pushservice/d/c:a	()Ljava/lang/Object;
    //   6: astore 11
    //   8: aload 11
    //   10: monitorenter
    //   11: aconst_null
    //   12: astore 4
    //   14: getstatic 20	com/baidu/android/pushservice/PushInfoProvider:c	Landroid/content/UriMatcher;
    //   17: aload_1
    //   18: invokevirtual 88	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   21: istore 5
    //   23: iload 5
    //   25: tableswitch	default:+19->44, 1:+64->89
    //   44: aconst_null
    //   45: astore 4
    //   47: aconst_null
    //   48: astore_1
    //   49: ldc2_w 114
    //   52: lstore 6
    //   54: aload 4
    //   56: ifnull +10 -> 66
    //   59: aload 4
    //   61: invokeinterface 120 1 0
    //   66: lload 6
    //   68: lstore 8
    //   70: aload_1
    //   71: ifnull +11 -> 82
    //   74: aload_1
    //   75: invokevirtual 121	android/database/sqlite/SQLiteDatabase:close	()V
    //   78: lload 6
    //   80: lstore 8
    //   82: aload 11
    //   84: monitorexit
    //   85: lload 8
    //   87: l2i
    //   88: ireturn
    //   89: aload_0
    //   90: getfield 37	com/baidu/android/pushservice/PushInfoProvider:b	Landroid/content/Context;
    //   93: invokestatic 91	com/baidu/android/pushservice/d/c:a	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +188 -> 286
    //   101: aload_1
    //   102: ldc 95
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: aconst_null
    //   110: invokevirtual 100	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore 10
    //   115: aload 10
    //   117: astore 4
    //   119: aload 4
    //   121: ifnull +28 -> 149
    //   124: aload 4
    //   126: invokeinterface 125 1 0
    //   131: ifeq +18 -> 149
    //   134: aload_1
    //   135: ldc 95
    //   137: aload_2
    //   138: aload_3
    //   139: aconst_null
    //   140: invokevirtual 128	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   143: i2l
    //   144: lstore 6
    //   146: goto -92 -> 54
    //   149: aload_1
    //   150: ldc 95
    //   152: aconst_null
    //   153: aload_2
    //   154: invokevirtual 131	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   157: lstore 6
    //   159: goto -105 -> 54
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 37	com/baidu/android/pushservice/PushInfoProvider:b	Landroid/content/Context;
    //   171: aload_3
    //   172: invokestatic 111	com/baidu/android/pushservice/h/q:a	(Landroid/content/Context;Ljava/lang/Throwable;)V
    //   175: aload_1
    //   176: ifnull +9 -> 185
    //   179: aload_1
    //   180: invokeinterface 120 1 0
    //   185: aload_2
    //   186: ifnull +92 -> 278
    //   189: aload_2
    //   190: invokevirtual 121	android/database/sqlite/SQLiteDatabase:close	()V
    //   193: ldc2_w 114
    //   196: lstore 8
    //   198: goto -116 -> 82
    //   201: aload_3
    //   202: ifnull +9 -> 211
    //   205: aload_3
    //   206: invokeinterface 120 1 0
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 121	android/database/sqlite/SQLiteDatabase:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_1
    //   222: aload 11
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    //   227: astore_3
    //   228: aload_1
    //   229: astore_2
    //   230: aload_3
    //   231: astore_1
    //   232: aload 4
    //   234: astore_3
    //   235: goto -34 -> 201
    //   238: astore 10
    //   240: aload 4
    //   242: astore_3
    //   243: aload_1
    //   244: astore_2
    //   245: aload 10
    //   247: astore_1
    //   248: goto -47 -> 201
    //   251: astore 4
    //   253: aload_1
    //   254: astore_3
    //   255: aload 4
    //   257: astore_1
    //   258: goto -57 -> 201
    //   261: astore_3
    //   262: aload_1
    //   263: astore_2
    //   264: aconst_null
    //   265: astore_1
    //   266: goto -99 -> 167
    //   269: astore_3
    //   270: aload_1
    //   271: astore_2
    //   272: aload 4
    //   274: astore_1
    //   275: goto -108 -> 167
    //   278: ldc2_w 114
    //   281: lstore 8
    //   283: goto -201 -> 82
    //   286: aconst_null
    //   287: astore 4
    //   289: ldc2_w 114
    //   292: lstore 6
    //   294: goto -240 -> 54
    //   297: astore_1
    //   298: aload 10
    //   300: astore_2
    //   301: aload 4
    //   303: astore_3
    //   304: goto -103 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	PushInfoProvider
    //   0	307	1	paramUri	Uri
    //   0	307	2	paramContentValues	ContentValues
    //   0	307	3	paramString	String
    //   0	307	4	paramArrayOfString	String[]
    //   21	3	5	i	int
    //   52	241	6	l1	long
    //   68	214	8	l2	long
    //   1	115	10	localCursor	Cursor
    //   238	61	10	localObject1	Object
    //   6	217	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	23	162	java/lang/Exception
    //   89	97	162	java/lang/Exception
    //   59	66	221	finally
    //   74	78	221	finally
    //   82	85	221	finally
    //   179	185	221	finally
    //   189	193	221	finally
    //   205	211	221	finally
    //   215	219	221	finally
    //   219	221	221	finally
    //   222	225	221	finally
    //   101	115	227	finally
    //   124	146	238	finally
    //   149	159	238	finally
    //   167	175	251	finally
    //   101	115	261	java/lang/Exception
    //   124	146	269	java/lang/Exception
    //   149	159	269	java/lang/Exception
    //   14	23	297	finally
    //   89	97	297	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/PushInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */