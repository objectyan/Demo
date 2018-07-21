package com.baidu.che.codriver.sdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.util.q;
import com.baidu.che.codriver.vr.n;
import com.baidu.che.codriver.vr.n.a;
import com.baidu.che.codriver.vr.o;
import com.baidu.che.codriver.vr.o.a;
import com.baidu.navi.util.StatisticManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  public static final String a = "CdAsrManager";
  public static final String b = ",";
  private List<b> c = new CopyOnWriteArrayList();
  private Context d;
  private String e;
  private String f = "小度小度";
  private String g = "";
  private boolean h = false;
  private HashMap<String, String> i = new HashMap(32);
  private a j;
  
  public static a a()
  {
    return c.a();
  }
  
  private void a(String paramString)
  {
    String str = (String)this.i.get(paramString);
    if (str != null)
    {
      StatisticManager.onEvent(str);
      Log.d("#######", "####### Statistic [" + str + " : " + paramString + "]");
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 112	java/io/File
    //   3: dup
    //   4: aload_3
    //   5: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 11
    //   10: iload_1
    //   11: ifne +15 -> 26
    //   14: iload_1
    //   15: ifne +141 -> 156
    //   18: aload 11
    //   20: invokevirtual 118	java/io/File:exists	()Z
    //   23: ifne +133 -> 156
    //   26: aconst_null
    //   27: astore_3
    //   28: aconst_null
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 6
    //   34: aconst_null
    //   35: astore 10
    //   37: aconst_null
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 9
    //   43: aload 8
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 120	com/baidu/che/codriver/sdk/a/a:d	Landroid/content/Context;
    //   51: invokevirtual 126	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   54: invokevirtual 132	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   57: aload_2
    //   58: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: astore_2
    //   62: aload_2
    //   63: astore 6
    //   65: aload 8
    //   67: astore 5
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: astore 7
    //   74: new 140	java/io/FileOutputStream
    //   77: dup
    //   78: aload 11
    //   80: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore 8
    //   85: sipush 1024
    //   88: newarray <illegal type>
    //   90: astore_3
    //   91: aload_2
    //   92: aload_3
    //   93: iconst_0
    //   94: sipush 1024
    //   97: invokevirtual 149	java/io/InputStream:read	([BII)I
    //   100: istore 4
    //   102: iload 4
    //   104: iflt +53 -> 157
    //   107: aload 8
    //   109: aload_3
    //   110: iconst_0
    //   111: iload 4
    //   113: invokevirtual 153	java/io/FileOutputStream:write	([BII)V
    //   116: goto -25 -> 91
    //   119: astore_3
    //   120: aload 8
    //   122: astore 6
    //   124: aload_3
    //   125: astore 8
    //   127: aload 6
    //   129: astore 5
    //   131: aload_2
    //   132: astore_3
    //   133: aload 8
    //   135: invokevirtual 156	java/io/FileNotFoundException:printStackTrace	()V
    //   138: aload 6
    //   140: ifnull +8 -> 148
    //   143: aload 6
    //   145: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 160	java/io/InputStream:close	()V
    //   156: return
    //   157: aload 8
    //   159: ifnull +8 -> 167
    //   162: aload 8
    //   164: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   167: aload_2
    //   168: ifnull -12 -> 156
    //   171: aload_2
    //   172: invokevirtual 160	java/io/InputStream:close	()V
    //   175: return
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   181: return
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   187: goto -20 -> 167
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   195: goto -47 -> 148
    //   198: astore_2
    //   199: aload_2
    //   200: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   203: return
    //   204: astore 7
    //   206: aload 6
    //   208: astore_2
    //   209: aload 10
    //   211: astore 6
    //   213: aload 6
    //   215: astore 5
    //   217: aload_2
    //   218: astore_3
    //   219: aload 7
    //   221: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   224: aload 6
    //   226: ifnull +8 -> 234
    //   229: aload 6
    //   231: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   234: aload_2
    //   235: ifnull -79 -> 156
    //   238: aload_2
    //   239: invokevirtual 160	java/io/InputStream:close	()V
    //   242: return
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   248: return
    //   249: astore_3
    //   250: aload_3
    //   251: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   254: goto -20 -> 234
    //   257: astore_2
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   268: aload_3
    //   269: ifnull +7 -> 276
    //   272: aload_3
    //   273: invokevirtual 160	java/io/InputStream:close	()V
    //   276: aload_2
    //   277: athrow
    //   278: astore 5
    //   280: aload 5
    //   282: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   285: goto -17 -> 268
    //   288: astore_3
    //   289: aload_3
    //   290: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   293: goto -17 -> 276
    //   296: astore 6
    //   298: aload 8
    //   300: astore 5
    //   302: aload_2
    //   303: astore_3
    //   304: aload 6
    //   306: astore_2
    //   307: goto -49 -> 258
    //   310: astore 7
    //   312: aload 8
    //   314: astore 6
    //   316: goto -103 -> 213
    //   319: astore 8
    //   321: aload 9
    //   323: astore 6
    //   325: aload 7
    //   327: astore_2
    //   328: goto -201 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	a
    //   0	331	1	paramBoolean	boolean
    //   0	331	2	paramString1	String
    //   0	331	3	paramString2	String
    //   100	12	4	k	int
    //   45	219	5	localObject1	Object
    //   278	3	5	localIOException1	IOException
    //   300	1	5	localObject2	Object
    //   32	198	6	localObject3	Object
    //   296	9	6	localObject4	Object
    //   314	10	6	localObject5	Object
    //   29	44	7	str	String
    //   204	16	7	localIOException2	IOException
    //   310	16	7	localIOException3	IOException
    //   38	275	8	localObject6	Object
    //   319	1	8	localFileNotFoundException	FileNotFoundException
    //   41	281	9	localObject7	Object
    //   35	175	10	localObject8	Object
    //   8	71	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   85	91	119	java/io/FileNotFoundException
    //   91	102	119	java/io/FileNotFoundException
    //   107	116	119	java/io/FileNotFoundException
    //   171	175	176	java/io/IOException
    //   162	167	182	java/io/IOException
    //   143	148	190	java/io/IOException
    //   152	156	198	java/io/IOException
    //   47	62	204	java/io/IOException
    //   74	85	204	java/io/IOException
    //   238	242	243	java/io/IOException
    //   229	234	249	java/io/IOException
    //   47	62	257	finally
    //   74	85	257	finally
    //   133	138	257	finally
    //   219	224	257	finally
    //   263	268	278	java/io/IOException
    //   272	276	288	java/io/IOException
    //   85	91	296	finally
    //   91	102	296	finally
    //   107	116	296	finally
    //   85	91	310	java/io/IOException
    //   91	102	310	java/io/IOException
    //   107	116	310	java/io/IOException
    //   47	62	319	java/io/FileNotFoundException
    //   74	85	319	java/io/FileNotFoundException
  }
  
  private void b(String paramString)
  {
    this.e = paramString;
    c(paramString);
    o.a().b(k(), l());
  }
  
  private void c(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = this.d.openFileOutput("WakeUp.bin", 0);
        localObject2 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localObject1 = localFileOutputStream;
        localFileOutputStream.write(q.a(paramString));
      }
      catch (FileNotFoundException paramString)
      {
        FileOutputStream localFileOutputStream;
        localObject1 = localObject2;
        paramString.printStackTrace();
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject2).close();
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = localObject3;
        paramString.printStackTrace();
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject3).close();
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject1 == null) {
          break label111;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label111:
      throw paramString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void i()
  {
    System.currentTimeMillis();
    this.i.put("白天模式", "VOICE_SCENE_0001");
    this.i.put("黑夜模式", "VOICE_SCENE_0002");
    this.i.put("关闭电子狗", "VOICE_SCENE_0003");
    this.i.put("打开电子狗", "VOICE_SCENE_0004");
    this.i.put("打开路况", "VOICE_SCENE_0005");
    this.i.put("关闭路况", "VOICE_SCENE_0006");
    this.i.put("放大地图", "VOICE_SCENE_0007");
    this.i.put("缩小地图", "VOICE_SCENE_0008");
    this.i.put("取消", "VOICE_SCENE_0009");
    this.i.put("确定", "VOICE_SCENE_0010");
    this.i.put("跟随模式", "VOICE_SCENE_0011");
    this.i.put("车头朝上", "VOICE_SCENE_0012");
    this.i.put("正北模式", "VOICE_SCENE_0013");
    this.i.put("查看全程", "VOICE_SCENE_0014");
    this.i.put("继续导航", "VOICE_SCENE_0015");
    this.i.put("关闭导航", "VOICE_SCENE_0016");
    this.i.put("结束导航", "VOICE_SCENE_0017");
    this.i.put("开始导航", "VOICE_SCENE_0018");
    this.i.put("第一个", "VOICE_SCENE_0019");
    this.i.put("第二个", "VOICE_SCENE_0020");
    this.i.put("第三个", "VOICE_SCENE_0021");
    this.i.put("播放音乐", "VOICE_SCENE_0022");
    this.i.put("暂停播放", "VOICE_SCENE_0023");
    this.i.put("上一首", "VOICE_SCENE_0024");
    this.i.put("上一曲", "VOICE_SCENE_0025");
    this.i.put("下一首", "VOICE_SCENE_0026");
    this.i.put("下一曲", "VOICE_SCENE_0027");
    this.i.put("继续播放", "VOICE_SCENE_0028");
    System.currentTimeMillis();
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((b)localIterator.next()).getQuery());
    }
    return localStringBuilder.toString();
  }
  
  private String k()
  {
    return this.d.getFilesDir().getPath() + "/" + "WakeUp.bin";
  }
  
  private String l()
  {
    if (this.e.equals("小度小度")) {
      return this.d.getApplicationInfo().nativeLibraryDir + "/libbd_easr_s1_wakeup_20170524.dat.so";
    }
    return this.d.getApplicationInfo().nativeLibraryDir + "/libbd_easr_s1_merge_normal_20151216.dat.so";
  }
  
  private String m()
  {
    try
    {
      String str = q.a(new File(this.d.getFilesDir().getPath() + "/" + "WakeUp.bin"));
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void n()
  {
    n.c(com.baidu.che.codriver.a.a.d());
    n.b(com.baidu.che.codriver.a.a.c());
    n.a(n.a.b);
    c.b("5");
    n.a(true);
    n.a("https://vehicle.baidu.com/codriverapi");
    h.b("CdAsrManager", "Url:" + n.d());
  }
  
  private void o()
  {
    n.c(com.baidu.che.codriver.a.a.d());
    n.b(com.baidu.che.codriver.a.a.c());
    n.a(n.a.b);
    c.b("5");
    c.c("test");
    n.a(true);
    n.a("http://sandbox.codriverapi.baidu.com/codriverapi");
    h.b("CdAsrManager", "SandboxNlp Url:" + n.d());
  }
  
  public void a(Context paramContext, final o.a parama)
  {
    this.d = paramContext;
    i();
    a(true, "WakeUp_Xiaodu.bin", this.d.getFilesDir().getPath() + "/" + "WakeUp.bin");
    this.e = m();
    h.b("CdAsrManager", "wake up words: " + this.e);
    n();
    com.baidu.che.codriver.h.a.a().a(this.d);
    o.a().a(this.d, com.baidu.che.codriver.ui.b.b.b(), new o.a()
    {
      public void a()
      {
        a.a(a.this, true);
        h.b("CdAsrManager", "onInitSuccess: " + a.a(a.this));
        o.a().b(a.b(a.this), a.c(a.this));
        if (parama != null) {
          parama.a();
        }
      }
    });
  }
  
  public void a(a parama)
  {
    this.j = parama;
  }
  
  public void a(b paramb)
  {
    if ((!this.h) || (this.c.contains(paramb)))
    {
      h.b("CdAsrManager", "registerSceneCommand error: " + this.h);
      return;
    }
    this.c.add(paramb);
    o.a().a(new com.baidu.che.codriver.vr.l(j(), new com.baidu.che.codriver.vr.b()
    {
      public void a(String paramAnonymousString)
      {
        h.b("CdAsrManager", "handleSceneCmd: " + paramAnonymousString);
        Iterator localIterator = a.d(a.this).iterator();
        while (localIterator.hasNext()) {
          a.b.access$500((a.b)localIterator.next(), paramAnonymousString);
        }
        a.a(a.this, paramAnonymousString);
      }
    }));
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.b("CdAsrManager", "param:" + paramString1 + ";data:" + paramString2);
    l.a().a("asr.tool", paramString1, paramString2);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if ((this.e != null) && (this.e.contains(paramString)))
    {
      h.b("CdAsrManager", paramString + " already exists");
      return false;
    }
    h.b("CdAsrManager", "addWakeUpWrd: " + paramString);
    if (paramBoolean)
    {
      this.g = paramString;
      b(this.f + "," + this.g);
    }
    for (;;)
    {
      h.b("CdAsrManager", "wake up words: " + this.e);
      return true;
      this.f = (this.f + "," + paramString);
      b(this.f);
    }
  }
  
  public void b(b paramb)
  {
    this.c.remove(paramb);
    if (this.c.isEmpty()) {
      o.a().b();
    }
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public void c()
  {
    com.baidu.che.codriver.ui.b.b.b().t();
  }
  
  public void d()
  {
    com.baidu.che.codriver.ui.b.b.b().a();
  }
  
  public void e()
  {
    this.g = "";
    b(this.f);
  }
  
  public boolean f()
  {
    return !TextUtils.isEmpty(this.g);
  }
  
  public String g()
  {
    return this.g;
  }
  
  public a h()
  {
    return this.j;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract class b
  {
    private Map<String, String> mCmdMap = new HashMap();
    
    private String getQuery()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.mCmdMap.values().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next());
      }
      return localStringBuilder.toString();
    }
    
    private void handleSceneCmd(String paramString)
    {
      String str1 = "," + paramString + ",";
      Iterator localIterator = this.mCmdMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (("," + (String)this.mCmdMap.get(str2)).contains(str1)) {
          onCommand(str2, paramString);
        }
      }
    }
    
    public b addCommand(String paramString, String... paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        localStringBuilder.append(",");
        i += 1;
      }
      this.mCmdMap.put(paramString, localStringBuilder.toString());
      return this;
    }
    
    public abstract void onCommand(String paramString1, String paramString2);
  }
  
  private static class c
  {
    private static a a = new a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */