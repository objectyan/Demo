package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.f.g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.SqlTool;
import com.baidu.tts.tools.StringTool;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a
{
  private com.baidu.tts.l.a a;
  private b b;
  private ReadWriteLock c = new ReentrantReadWriteLock();
  private Lock d = this.c.writeLock();
  private Lock e = this.c.readLock();
  
  public a(com.baidu.tts.l.a parama)
  {
    this.a = parama;
    this.b = new b(this.a.d());
  }
  
  private SQLiteDatabase a()
  {
    return this.b.getWritableDatabase();
  }
  
  private SQLiteDatabase b()
  {
    return this.b.getReadableDatabase();
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 66 1 0
    //   9: aload_0
    //   10: invokespecial 68	com/baidu/tts/database/a:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokestatic 73	com/baidu/tts/database/SpeechModelTable:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   19: istore_2
    //   20: aload_3
    //   21: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   24: aload_0
    //   25: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   28: invokeinterface 81 1 0
    //   33: iload_2
    //   34: ireturn
    //   35: astore_1
    //   36: aload_3
    //   37: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   40: aload_0
    //   41: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 81 1 0
    //   49: iconst_m1
    //   50: ireturn
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 81 1 0
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	a
    //   0	70	1	paramString	String
    //   19	15	2	i	int
    //   13	40	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	20	35	java/lang/Exception
    //   14	20	51	finally
    //   9	14	58	finally
    //   20	24	58	finally
    //   36	40	58	finally
    //   52	58	58	finally
  }
  
  public String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("select b.absPath from speechModel a left join modelFile b on a.");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=b.id where a.id=?");
    paramString2 = a(localStringBuilder.toString(), new String[] { paramString2 });
    paramString1 = null;
    if (paramString2 != null) {
      paramString1 = (String)paramString2.get(g.h.b());
    }
    return paramString1;
  }
  
  public List<Map<String, String>> a(Conditions paramConditions)
  {
    Object localObject = paramConditions.getVersion();
    String str = null;
    String[] arrayOfString1 = null;
    if (!StringTool.isEmpty((String)localObject))
    {
      str = "version_min <= ? and version_max >= ?";
      arrayOfString1 = new String[2];
      arrayOfString1[0] = localObject;
      arrayOfString1[1] = localObject;
    }
    localObject = paramConditions.getDomainArray();
    String[] arrayOfString2 = paramConditions.getLanguageArray();
    String[] arrayOfString3 = paramConditions.getQualityArray();
    String[] arrayOfString4 = paramConditions.getGenderArray();
    String[] arrayOfString5 = paramConditions.getSpeakerArray();
    paramConditions = paramConditions.getModelIdsArray();
    str = SqlTool.buildConditions("and", new String[] { str, SqlTool.buildInCondition("domain", (String[])localObject), SqlTool.buildInCondition("language", arrayOfString2), SqlTool.buildInCondition("quality", arrayOfString3), SqlTool.buildInCondition("gender", arrayOfString4), SqlTool.buildInCondition("speaker", arrayOfString5), SqlTool.buildInCondition("id", paramConditions) });
    if (StringTool.isEmpty(str)) {
      return null;
    }
    return b("select * from speechModel where " + str, DataTool.connect(arrayOfString1, new String[][] { localObject, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, paramConditions }));
  }
  
  public List<Map<String, String>> a(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return null;
    }
    paramSet = DataTool.fromSetToArray(paramSet);
    String str = SqlTool.buildInCondition("id", paramSet);
    return b("select * from modelFile where " + str, paramSet);
  }
  
  /* Error */
  public Map<String, String> a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/baidu/tts/database/a:e	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 66 1 0
    //   9: aload_0
    //   10: invokespecial 205	com/baidu/tts/database/a:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore 6
    //   15: aload 6
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 209	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 7
    //   24: aload 7
    //   26: ifnull +191 -> 217
    //   29: aload 7
    //   31: invokeinterface 214 1 0
    //   36: ifeq +186 -> 222
    //   39: new 216	java/util/HashMap
    //   42: dup
    //   43: invokespecial 217	java/util/HashMap:<init>	()V
    //   46: astore 5
    //   48: aload 5
    //   50: astore_2
    //   51: aload 7
    //   53: invokeinterface 220 1 0
    //   58: astore 8
    //   60: aload 5
    //   62: astore_2
    //   63: aload 8
    //   65: arraylength
    //   66: istore 4
    //   68: iconst_0
    //   69: istore_3
    //   70: aload 5
    //   72: astore_1
    //   73: iload_3
    //   74: iload 4
    //   76: if_icmpge +43 -> 119
    //   79: aload 5
    //   81: astore_2
    //   82: aload 5
    //   84: aload 8
    //   86: iload_3
    //   87: aaload
    //   88: aload 7
    //   90: aload 7
    //   92: aload 8
    //   94: iload_3
    //   95: aaload
    //   96: invokeinterface 223 2 0
    //   101: invokeinterface 227 2 0
    //   106: invokeinterface 231 3 0
    //   111: pop
    //   112: iload_3
    //   113: iconst_1
    //   114: iadd
    //   115: istore_3
    //   116: goto -46 -> 70
    //   119: aload 7
    //   121: ifnull +12 -> 133
    //   124: aload_1
    //   125: astore_2
    //   126: aload 7
    //   128: invokeinterface 232 1 0
    //   133: aload_1
    //   134: astore_2
    //   135: aload 6
    //   137: ifnull +10 -> 147
    //   140: aload 6
    //   142: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   145: aload_1
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 36	com/baidu/tts/database/a:e	Ljava/util/concurrent/locks/Lock;
    //   151: invokeinterface 81 1 0
    //   156: aload_2
    //   157: areturn
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_2
    //   162: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   165: aload_1
    //   166: astore_2
    //   167: aload 6
    //   169: ifnull -22 -> 147
    //   172: aload 6
    //   174: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   177: aload_1
    //   178: astore_2
    //   179: goto -32 -> 147
    //   182: astore_1
    //   183: aload_0
    //   184: getfield 36	com/baidu/tts/database/a:e	Ljava/util/concurrent/locks/Lock;
    //   187: invokeinterface 81 1 0
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload 6
    //   197: ifnull +8 -> 205
    //   200: aload 6
    //   202: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore 5
    //   209: aload_2
    //   210: astore_1
    //   211: aload 5
    //   213: astore_2
    //   214: goto -53 -> 161
    //   217: aconst_null
    //   218: astore_1
    //   219: goto -86 -> 133
    //   222: aconst_null
    //   223: astore_1
    //   224: goto -105 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	a
    //   0	227	1	paramString	String
    //   0	227	2	paramArrayOfString	String[]
    //   69	47	3	i	int
    //   66	11	4	j	int
    //   46	37	5	localHashMap	java.util.HashMap
    //   207	5	5	localException	Exception
    //   13	188	6	localSQLiteDatabase	SQLiteDatabase
    //   22	105	7	localCursor	android.database.Cursor
    //   58	35	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   15	24	158	java/lang/Exception
    //   29	48	158	java/lang/Exception
    //   9	15	182	finally
    //   140	145	182	finally
    //   172	177	182	finally
    //   200	205	182	finally
    //   205	207	182	finally
    //   15	24	194	finally
    //   29	48	194	finally
    //   51	60	194	finally
    //   63	68	194	finally
    //   82	112	194	finally
    //   126	133	194	finally
    //   161	165	194	finally
    //   51	60	207	java/lang/Exception
    //   63	68	207	java/lang/Exception
    //   82	112	207	java/lang/Exception
    //   126	133	207	java/lang/Exception
  }
  
  public void a(ModelBags paramModelBags)
  {
    this.d.lock();
    try
    {
      SpeechModelTable.a(a(), paramModelBags);
      return;
    }
    finally
    {
      this.d.unlock();
    }
  }
  
  public void a(ModelFileBags paramModelFileBags)
  {
    this.d.lock();
    try
    {
      ModelFileTable.a(a(), paramModelFileBags);
      return;
    }
    finally
    {
      this.d.unlock();
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 66 1 0
    //   9: aload_0
    //   10: invokespecial 68	com/baidu/tts/database/a:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_3
    //   14: aload_3
    //   15: ldc -7
    //   17: iconst_2
    //   18: anewarray 101	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload_2
    //   28: invokestatic 252	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   31: aastore
    //   32: invokevirtual 256	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_3
    //   36: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   39: aload_0
    //   40: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   43: invokeinterface 81 1 0
    //   48: return
    //   49: astore_1
    //   50: aload_3
    //   51: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 81 1 0
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	a
    //   0	68	1	paramString	String
    //   0	68	2	paramInt	int
    //   13	38	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	35	49	finally
    //   9	14	56	finally
    //   35	39	56	finally
    //   50	56	56	finally
  }
  
  /* Error */
  public int b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 66 1 0
    //   9: aload_0
    //   10: invokespecial 68	com/baidu/tts/database/a:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokestatic 257	com/baidu/tts/database/ModelFileTable:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   19: istore_2
    //   20: aload_3
    //   21: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   24: aload_0
    //   25: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   28: invokeinterface 81 1 0
    //   33: iload_2
    //   34: ireturn
    //   35: astore_1
    //   36: aload_3
    //   37: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   40: aload_0
    //   41: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 81 1 0
    //   49: iconst_m1
    //   50: ireturn
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 31	com/baidu/tts/database/a:d	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 81 1 0
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	a
    //   0	70	1	paramString	String
    //   19	15	2	i	int
    //   13	40	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	20	35	java/lang/Exception
    //   14	20	51	finally
    //   9	14	58	finally
    //   20	24	58	finally
    //   36	40	58	finally
    //   52	58	58	finally
  }
  
  /* Error */
  public List<Map<String, String>> b(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 36	com/baidu/tts/database/a:e	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 66 1 0
    //   18: aload 8
    //   20: astore 5
    //   22: new 259	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 260	java/util/ArrayList:<init>	()V
    //   29: astore 7
    //   31: aload 8
    //   33: astore 5
    //   35: aload 9
    //   37: astore 6
    //   39: aload_0
    //   40: invokespecial 205	com/baidu/tts/database/a:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: astore 8
    //   45: aload 8
    //   47: astore 5
    //   49: aload 8
    //   51: astore 6
    //   53: aload 8
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual 209	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +166 -> 228
    //   65: aload 8
    //   67: astore 5
    //   69: aload 8
    //   71: astore 6
    //   73: aload_1
    //   74: invokeinterface 214 1 0
    //   79: ifeq +131 -> 210
    //   82: aload 8
    //   84: astore 5
    //   86: aload 8
    //   88: astore 6
    //   90: aload_1
    //   91: invokeinterface 220 1 0
    //   96: astore_2
    //   97: aload 8
    //   99: astore 5
    //   101: aload 8
    //   103: astore 6
    //   105: new 216	java/util/HashMap
    //   108: dup
    //   109: invokespecial 217	java/util/HashMap:<init>	()V
    //   112: astore 9
    //   114: aload 8
    //   116: astore 5
    //   118: aload 8
    //   120: astore 6
    //   122: aload_2
    //   123: arraylength
    //   124: istore 4
    //   126: iconst_0
    //   127: istore_3
    //   128: iload_3
    //   129: iload 4
    //   131: if_icmpge +44 -> 175
    //   134: aload 8
    //   136: astore 5
    //   138: aload 8
    //   140: astore 6
    //   142: aload 9
    //   144: aload_2
    //   145: iload_3
    //   146: aaload
    //   147: aload_1
    //   148: aload_1
    //   149: aload_2
    //   150: iload_3
    //   151: aaload
    //   152: invokeinterface 223 2 0
    //   157: invokeinterface 227 2 0
    //   162: invokeinterface 231 3 0
    //   167: pop
    //   168: iload_3
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: goto -44 -> 128
    //   175: aload 8
    //   177: astore 5
    //   179: aload 8
    //   181: astore 6
    //   183: aload 7
    //   185: aload 9
    //   187: invokeinterface 266 2 0
    //   192: pop
    //   193: aload 8
    //   195: astore 5
    //   197: aload 8
    //   199: astore 6
    //   201: aload_1
    //   202: invokeinterface 269 1 0
    //   207: ifne -110 -> 97
    //   210: aload_1
    //   211: ifnull +17 -> 228
    //   214: aload 8
    //   216: astore 5
    //   218: aload 8
    //   220: astore 6
    //   222: aload_1
    //   223: invokeinterface 232 1 0
    //   228: aload 7
    //   230: astore_2
    //   231: aload 8
    //   233: ifnull +11 -> 244
    //   236: aload 8
    //   238: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   241: aload 7
    //   243: astore_2
    //   244: aload_0
    //   245: getfield 36	com/baidu/tts/database/a:e	Ljava/util/concurrent/locks/Lock;
    //   248: invokeinterface 81 1 0
    //   253: aload_2
    //   254: areturn
    //   255: astore_2
    //   256: aconst_null
    //   257: astore_1
    //   258: aload 6
    //   260: astore 5
    //   262: aload_2
    //   263: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   266: aload_1
    //   267: astore_2
    //   268: aload 6
    //   270: ifnull -26 -> 244
    //   273: aload 6
    //   275: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   278: aload_1
    //   279: astore_2
    //   280: goto -36 -> 244
    //   283: astore_1
    //   284: aload_0
    //   285: getfield 36	com/baidu/tts/database/a:e	Ljava/util/concurrent/locks/Lock;
    //   288: invokeinterface 81 1 0
    //   293: aload_1
    //   294: athrow
    //   295: astore_1
    //   296: aload 5
    //   298: ifnull +8 -> 306
    //   301: aload 5
    //   303: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   306: aload_1
    //   307: athrow
    //   308: astore_2
    //   309: aload 7
    //   311: astore_1
    //   312: goto -54 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	a
    //   0	315	1	paramString	String
    //   0	315	2	paramArrayOfString	String[]
    //   127	45	3	i	int
    //   124	8	4	j	int
    //   20	282	5	localObject1	Object
    //   7	267	6	localObject2	Object
    //   29	281	7	localArrayList	java.util.ArrayList
    //   1	236	8	localSQLiteDatabase	SQLiteDatabase
    //   4	182	9	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   22	31	255	java/lang/Exception
    //   236	241	283	finally
    //   273	278	283	finally
    //   301	306	283	finally
    //   306	308	283	finally
    //   22	31	295	finally
    //   39	45	295	finally
    //   53	61	295	finally
    //   73	82	295	finally
    //   90	97	295	finally
    //   105	114	295	finally
    //   122	126	295	finally
    //   142	168	295	finally
    //   183	193	295	finally
    //   201	210	295	finally
    //   222	228	295	finally
    //   262	266	295	finally
    //   39	45	308	java/lang/Exception
    //   53	61	308	java/lang/Exception
    //   73	82	308	java/lang/Exception
    //   90	97	308	java/lang/Exception
    //   105	114	308	java/lang/Exception
    //   122	126	308	java/lang/Exception
    //   142	168	308	java/lang/Exception
    //   183	193	308	java/lang/Exception
    //   201	210	308	java/lang/Exception
    //   222	228	308	java/lang/Exception
  }
  
  public Map<String, String> c(String paramString)
  {
    return a("select * from fsFileInfo where absPath=?", new String[] { paramString });
  }
  
  public Map<String, String> d(String paramString)
  {
    return a("select * from modelFile where id=?", new String[] { paramString });
  }
  
  public Map<String, String> e(String paramString)
  {
    return a("select * from speechModel where id=?", new String[] { paramString });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/database/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */