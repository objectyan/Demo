package com.baidu.che.codriver.vr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.b.a;
import com.baidu.che.codriver.i.b;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.a;
import com.baidu.speech.EventListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o
{
  public static final String a = "CoDriverVoice-Manager";
  public static final int b = 0;
  public static final int c = -1;
  private static o d;
  private static final Object e = new Object();
  private Context f = null;
  private VoiceService.b g = null;
  private ServiceConnection h = null;
  private h i = null;
  private HashMap<String, d> j = new HashMap();
  private HashMap<String, Set<String>> k = new HashMap();
  private j l = new j(this.j);
  private j.a m = null;
  private EventListener n = null;
  private int o = 0;
  private q p = null;
  private long q = 0L;
  private long r = 0L;
  private long s = 0L;
  private long t = 0L;
  private int u = -1;
  private boolean v = false;
  private boolean w = false;
  private int x = 0;
  private l y;
  private Handler z = new Handler();
  
  public static o a()
  {
    if (d == null) {}
    synchronized (e)
    {
      if (d == null) {
        d = new o();
      }
      return d;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.optInt("errorCode") == 0)
      {
        String str = paramString.optString("word");
        if ((!TextUtils.isEmpty(str)) && (u().contains(str)))
        {
          com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--------wp.data---------word:" + str);
          this.x = 0;
          this.i.a(str);
          if ((t() == q.a.c) && (!this.v))
          {
            this.v = true;
            this.i.c("");
          }
        }
        for (;;)
        {
          this.o = paramString.optInt("frameLen", -1);
          return;
          if ((!TextUtils.isEmpty(str)) && ("白天模式,黑夜模式,跟随模式,车头朝上,正北模式,查看全程,关闭电子狗,打开电子狗,打开路况,关闭路况,放大地图,缩小地图,继续导航,关闭导航,结束导航,开始导航,第一个,第二个,第三个,取消,确定,播放音乐,暂停播放,上一首,上一曲,下一首,下一曲,继续播放".contains(str)))
          {
            com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--------wp.data---------scene word:" + str);
            if ((t() != q.a.h) && (t() != q.a.g) && (t() != q.a.f)) {
              break;
            }
            a(str);
          }
        }
      }
      Toast.makeText(this.f, "唤醒出错了！", 0).show();
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    com.baidu.che.codriver.util.h.e("CoDriverVoice-Manager", "----wp.data---errorCode:" + paramString.toString());
  }
  
  private void g(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "------wp.ready-------");
    this.t = 0L;
  }
  
  private void h(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "------wp.started-------");
    this.t = 0L;
  }
  
  private void i(final String paramString)
  {
    this.t += 1L;
    if (this.t > 3L)
    {
      Toast.makeText(this.f, "唤醒出错了！", 0).show();
      return;
    }
    this.z.postDelayed(new Runnable()
    {
      public void run()
      {
        if (paramString.contains("Recorder open failed"))
        {
          o.e(o.this).h();
          o.this.h();
          return;
        }
        o.this.h();
      }
    }, 1000L);
  }
  
  private void j(String paramString)
  {
    try
    {
      this.u = new JSONObject(paramString).optInt("oneshot", 0);
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "oneshotState=" + this.u);
      if (!d()) {
        return;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
        this.g.a(System.currentTimeMillis(), "小度小度", this.u, this.o);
        if (this.u == 1)
        {
          m();
          v();
          return;
        }
      } while (this.u != 0);
      this.i.b(this.u);
    }
  }
  
  private void k(String paramString)
  {
    this.p.b();
  }
  
  private void l(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--------asr.ready---------");
    this.i.j();
    a.b();
    w();
    this.v = false;
  }
  
  private void m(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "---------asr.begin--------");
    a.e();
    long l1 = SystemClock.elapsedRealtime();
    this.s = l1;
    this.q = l1;
    this.i.k();
  }
  
  private void n(String paramString)
  {
    a.c();
    this.i.l();
    this.s = SystemClock.elapsedRealtime();
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "----asr.end-time:" + (this.r - this.q) + "ms");
  }
  
  private void o(String paramString)
  {
    this.r = SystemClock.elapsedRealtime();
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "---asr.partial-time:" + (this.r - this.q) + "ms----result:" + paramString + "---asr.partial-time:  isAsrResultDealed = " + this.v);
    if (this.v)
    {
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "onAsrPartial - isAsrResultDealed is true, do nothing");
      return;
    }
    try
    {
      Object localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).getString("result_type").equals("final_result"))
      {
        Object localObject2 = new JSONObject(paramString).optJSONArray("results_recognition");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          this.x = 0;
          a.a(paramString);
          this.v = true;
          if (!p(((JSONObject)localObject1).optString("best_result")))
          {
            localObject1 = b.a(paramString, ((JSONArray)localObject2).getString(0));
            localObject2 = this.l;
            if (!this.w) {
              break label202;
            }
            paramString = j.b.a;
            ((j)localObject2).a((String)localObject1, paramString, this.m);
          }
        }
      }
      for (;;)
      {
        this.r = SystemClock.elapsedRealtime();
        return;
        label202:
        paramString = j.b.c;
        break;
        if (((JSONObject)localObject1).getString("result_type").equals("partial_result"))
        {
          paramString = new JSONObject(paramString).optJSONArray("results_recognition");
          localObject1 = paramString.getString(0);
          if ((paramString != null) && (paramString.length() > 0)) {
            this.i.c((String)localObject1);
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean p(String paramString)
  {
    if (this.p.a() != q.a.c) {}
    while (!"小度小度".equals(paramString)) {
      return false;
    }
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--recognization contains wakeup words--");
    return true;
  }
  
  private void q(String paramString)
  {
    this.r = SystemClock.elapsedRealtime();
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "----------asr.finish-time:" + (this.r - this.q) + "ms-----result:" + paramString + " , isSupportFullBargin = " + p() + " , isAsrResultDealed = " + this.v);
    if (t(paramString))
    {
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "------asr.finish , VRTestUtils.onVrFinish");
      a.a(paramString);
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "1Offline engine recognize fail restartAsr mRestartVrTime = " + this.x);
      if ((paramString.contains("Offline engine recognize fail")) && (com.baidu.che.codriver.util.j.a(this.f)))
      {
        int i1 = this.x;
        this.x = (i1 + 1);
        if (i1 < 1)
        {
          m();
          return;
        }
      }
      this.x = 0;
      n(null);
      j localj = this.l;
      if (this.w) {}
      for (j.b localb = j.b.a;; localb = j.b.c)
      {
        localj.a(paramString, localb, this.m);
        this.v = true;
        if (!paramString.contains("Recorder open failed")) {
          break;
        }
        this.p.i();
        return;
      }
    }
    if (!this.v)
    {
      this.x = 0;
      n(null);
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "---------asr.finish , full bargin start record animation.");
      m();
      return;
    }
    this.x = 0;
    n(null);
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "---------asr.finish , do nothing");
  }
  
  private void r(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "------asr.exit-------");
    this.p.c();
    this.v = false;
  }
  
  private void s(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "------asr.loaded-------");
  }
  
  private boolean t(String paramString)
  {
    if (this.v) {}
    while ((paramString.contains("\"error\":0,")) || ((p()) && ((paramString.contains("\"sub_error\":3101")) || (paramString.contains("\"error\":7,")) || (paramString.contains("\"error\":7}")) || (paramString.contains("\"error\":8,")) || ((paramString.contains("\"error\":10,")) && (com.baidu.che.codriver.util.j.a(this.f)))))) {
      return false;
    }
    return true;
  }
  
  private String u()
  {
    if (!s()) {
      return "小度小度";
    }
    return this.g.g();
  }
  
  private boolean u(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) || (paramString.mkdirs());
  }
  
  private int v()
  {
    if (!s()) {}
    while (!d()) {
      return -1;
    }
    this.g.k();
    return 0;
  }
  
  private int w()
  {
    if (!s()) {
      return -1;
    }
    this.g.j();
    return 0;
  }
  
  private int x()
  {
    return this.p.a(1);
  }
  
  private int y()
  {
    return this.p.a(2);
  }
  
  private void z()
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--readGrammarFile-START-----");
    BufferedReader localBufferedReader;
    String str1;
    String str2;
    int i1;
    try
    {
      InputStream localInputStream = c.a().getResources().getAssets().open("libgram_codriver");
      localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      for (;;)
      {
        str1 = localBufferedReader.readLine();
        if (str1 == null) {
          break label307;
        }
        str2 = str1.replace(" ", "");
        i1 = str2.indexOf(".");
        if (i1 >= 0) {
          break;
        }
        com.baidu.che.codriver.util.h.e("CoDriverVoice-Manager", "--readGrammarFile-not match grammar1-----");
      }
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--readGrammarFile-END-----");
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    for (;;)
    {
      return;
      str1 = str2.substring(0, i1);
      String[] arrayOfString = str2.substring(i1 + 1).split("=");
      if ((arrayOfString == null) || (arrayOfString.length != 2))
      {
        com.baidu.che.codriver.util.h.e("CoDriverVoice-Manager", "--readGrammarFile-not match grammar2-----");
        break;
      }
      Object localObject2 = arrayOfString[0].split("__");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        Object localObject1 = new JSONObject();
        str2 = localObject2[0];
        i1 = localObject2.length;
        if (i1 == 3) {}
        try
        {
          ((JSONObject)localObject1).put(localObject2[1], localObject2[2]);
          localObject1 = ((JSONObject)localObject1).toString();
          arrayOfString = arrayOfString[1].split(",");
          localObject2 = new d();
          ((d)localObject2).a = str1;
          ((d)localObject2).b = str2;
          ((d)localObject2).c = ((String)localObject1);
          int i2 = arrayOfString.length;
          i1 = 0;
          while (i1 < i2)
          {
            str1 = arrayOfString[i1];
            this.j.put(str1, localObject2);
            i1 += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        label307:
        localBufferedReader.close();
        localIOException.close();
      }
    }
  }
  
  protected int a(int paramInt)
  {
    if (!s()) {
      return -1;
    }
    return this.g.b(paramInt);
  }
  
  public int a(RecordHelper.a parama, com.baidu.che.codriver.vr.record.d paramd)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--setRecordType-" + parama.name());
    if ((this.g == null) || (!s())) {}
    while (this.g.a(parama, paramd) == -1) {
      return -1;
    }
    this.p.g();
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    if (!paramBoolean) {
      this.x = 1;
    }
    return this.g.b();
  }
  
  public int a(String[] paramArrayOfString)
  {
    if (!s()) {}
    do
    {
      return -1;
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "----openWakeupWord----" + paramArrayOfString.toString());
    } while (this.g.a(paramArrayOfString) == -1);
    this.p.g();
    return 0;
  }
  
  public void a(Context paramContext, h paramh, final a parama)
  {
    if (paramContext == null)
    {
      com.baidu.che.codriver.util.h.e("CoDriverVoice-Manager", "--VR init failed---");
      return;
    }
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "vr-sdk versionName = 1.1.1");
    this.f = paramContext;
    this.i = paramh;
    this.h = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "---onServiceConnected----name:" + paramAnonymousComponentName);
        o.a(o.this, (VoiceService.b)paramAnonymousIBinder);
        o.c(o.this).a(new VoiceService.a()
        {
          public void a()
          {
            o.c(o.this).a(o.b(o.this));
            o.3.this.a.a();
          }
        });
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    };
    this.f.bindService(new Intent(this.f, VoiceService.class), this.h, 1);
    new Thread(new Runnable()
    {
      public void run()
      {
        o.d(o.this);
      }
    }).start();
  }
  
  public void a(i parami)
  {
    this.l.a(parami);
  }
  
  /* Error */
  public void a(l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/baidu/che/codriver/vr/o:g	Lcom/baidu/che/codriver/vr/VoiceService$b;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 79	com/baidu/che/codriver/vr/o:g	Lcom/baidu/che/codriver/vr/VoiceService$b;
    //   18: aload_1
    //   19: invokevirtual 639	com/baidu/che/codriver/vr/l:a	()Ljava/lang/String;
    //   22: invokevirtual 640	com/baidu/che/codriver/vr/VoiceService$b:c	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 642	com/baidu/che/codriver/vr/o:y	Lcom/baidu/che/codriver/vr/l;
    //   30: ldc 22
    //   32: new 192	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 644
    //   42: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 639	com/baidu/che/codriver/vr/l:a	()Ljava/lang/String;
    //   49: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 207	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: goto -47 -> 11
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	o
    //   0	66	1	paraml	l
    //   6	2	2	localb	VoiceService.b
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	58	61	finally
  }
  
  public void a(String paramString, j.a parama)
  {
    a(null, paramString, parama);
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        paramString2 = paramString2.toLowerCase(Locale.ENGLISH).split(",");
        int i2 = paramString2.length;
        if (i1 < i2)
        {
          Object localObject1 = paramString2[i1];
          Object localObject2 = (d)this.j.get(localObject1);
          if (localObject2 == null) {
            break label164;
          }
          String str = ((d)localObject2).c;
          if ((str == null) || (!((d)localObject2).b.equals("customCmd"))) {
            break label164;
          }
          localObject2 = str.split("-");
          if ((localObject2 == null) || (localObject2.length <= 0) || (!paramString1.equals(localObject2[0]))) {
            break label164;
          }
          this.j.remove(localObject1);
          if (!this.k.containsKey(paramString1)) {
            break label164;
          }
          ((Set)this.k.get(paramString1)).remove(localObject1);
        }
      }
      finally {}
      return;
      label164:
      i1 += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = paramString3.toLowerCase(Locale.ENGLISH);
      paramString3 = new d();
      paramString3.a = "codriver";
      paramString3.b = "customCmd";
      if (paramString2 != null) {}
      for (paramString3.c = (paramString1 + "-" + paramString2);; paramString3.c = paramString1)
      {
        paramString2 = str.split(",");
        int i2 = paramString2.length;
        int i1 = 0;
        while (i1 < i2)
        {
          str = paramString2[i1];
          this.j.put(str, paramString3);
          i1 += 1;
        }
      }
      if (!this.k.containsKey(paramString1)) {
        break label162;
      }
    }
    finally {}
    ((Set)this.k.get(paramString1)).addAll(Arrays.asList(paramString2));
    for (;;)
    {
      return;
      label162:
      paramString3 = new HashSet();
      paramString3.addAll(Arrays.asList(paramString2));
      this.k.put(paramString1, paramString3);
    }
  }
  
  public void a(Map<String, Map> paramMap, String paramString, j.a parama)
  {
    this.l.a(paramMap, paramString, parama);
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (!s()) {
      return;
    }
    this.g.a(paramJSONArray);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.g != null) {
      this.g.a(paramArrayOfByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.g != null) {
      this.g.a(paramArrayOfByte1, paramArrayOfByte2);
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_3
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 642	com/baidu/che/codriver/vr/o:y	Lcom/baidu/che/codriver/vr/l;
    //   25: ifnull -12 -> 13
    //   28: iload_3
    //   29: istore_2
    //   30: aload_0
    //   31: getfield 642	com/baidu/che/codriver/vr/o:y	Lcom/baidu/che/codriver/vr/l;
    //   34: aload_1
    //   35: invokevirtual 705	com/baidu/che/codriver/vr/l:a	(Ljava/lang/String;)Z
    //   38: ifeq -25 -> 13
    //   41: aload_0
    //   42: getfield 642	com/baidu/che/codriver/vr/o:y	Lcom/baidu/che/codriver/vr/l;
    //   45: aload_1
    //   46: invokevirtual 707	com/baidu/che/codriver/vr/l:b	(Ljava/lang/String;)V
    //   49: iconst_1
    //   50: istore_2
    //   51: goto -38 -> 13
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	o
    //   0	59	1	paramString	String
    //   6	45	2	bool1	boolean
    //   18	11	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	54	finally
    //   21	28	54	finally
    //   30	49	54	finally
  }
  
  protected int b(int paramInt)
  {
    if (!s()) {
      return -1;
    }
    this.g.a(paramInt);
    return 0;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/baidu/che/codriver/vr/o:g	Lcom/baidu/che/codriver/vr/VoiceService$b;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 79	com/baidu/che/codriver/vr/o:g	Lcom/baidu/che/codriver/vr/VoiceService$b;
    //   18: invokevirtual 711	com/baidu/che/codriver/vr/VoiceService$b:h	()V
    //   21: ldc 22
    //   23: ldc_w 713
    //   26: invokestatic 207	com/baidu/che/codriver/util/h:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: goto -18 -> 11
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	o
    //   6	2	1	localb	VoiceService.b
    //   32	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   14	29	32	finally
  }
  
  public void b(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        boolean bool = this.k.containsKey(paramString);
        if (!bool) {
          return;
        }
        Set localSet = (Set)this.k.get(paramString);
        if (localSet == null) {
          continue;
        }
        String[] arrayOfString = (String[])localSet.toArray(new String[0]);
        int i2 = arrayOfString.length;
        if (i1 < i2)
        {
          String str1 = arrayOfString[i1];
          localSet.remove(str1);
          Object localObject = (d)this.j.get(str1);
          if (localObject == null) {
            break label191;
          }
          String str2 = ((d)localObject).c;
          if ((str2 == null) || (!((d)localObject).b.equals("customCmd"))) {
            break label191;
          }
          localObject = str2.split("-");
          if ((localObject == null) || (localObject.length <= 0) || (!paramString.equals(localObject[0]))) {
            break label191;
          }
          this.j.remove(str1);
        }
      }
      finally {}
      this.k.remove(paramString);
      continue;
      label191:
      i1 += 1;
    }
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean)
  {
    if (!s()) {
      return;
    }
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "--setUseNLU----" + paramBoolean);
    this.g.a(paramBoolean);
  }
  
  public int c(int paramInt)
  {
    if (!s()) {
      return -1;
    }
    this.g.c(paramInt);
    return 0;
  }
  
  public int c(String paramString)
  {
    if (!s()) {}
    do
    {
      return -1;
      com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "----openWakeupWord----" + paramString.toString());
    } while (this.g.a(paramString) == -1);
    this.p.g();
    return 0;
  }
  
  public int c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return o();
    }
    return k();
  }
  
  public void c()
  {
    if (this.g != null) {
      this.g.b(this.n);
    }
    if ((this.f != null) && (this.h != null)) {
      this.f.unbindService(this.h);
    }
    this.g = null;
    this.f = null;
    d = null;
  }
  
  public void c(String paramString1, String paramString2)
  {
    if (!s()) {
      return;
    }
    this.g.b(paramString1, paramString2);
  }
  
  public int d(String paramString)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-Manager", "setPcmDataPath path = " + paramString);
    if (!s()) {}
    while ((TextUtils.isEmpty(paramString)) || (!u(paramString))) {
      return -1;
    }
    this.g.b(paramString);
    return 0;
  }
  
  public int d(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.b(paramBoolean);
    if (paramBoolean) {
      o();
    }
    for (;;)
    {
      return 0;
      k();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.g != null) {
      this.g.d(paramInt);
    }
  }
  
  public boolean d()
  {
    if (this.g == null) {
      return false;
    }
    return this.g.m();
  }
  
  protected int e()
  {
    if (!s()) {
      return -1;
    }
    return this.g.a();
  }
  
  public void e(int paramInt)
  {
    if (this.g != null) {
      this.g.e(paramInt);
    }
  }
  
  public void e(String paramString)
  {
    if (this.g != null) {
      this.g.d(paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  protected int f()
  {
    if (!s()) {
      return -1;
    }
    return this.g.c();
  }
  
  public int f(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.c(paramBoolean);
    return 0;
  }
  
  protected int g()
  {
    if (!s()) {
      return -1;
    }
    this.g.i();
    return 0;
  }
  
  public int g(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.d(paramBoolean);
    return 0;
  }
  
  protected int h()
  {
    if (!s()) {
      return -1;
    }
    return this.g.d();
  }
  
  public int h(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.e(paramBoolean);
    return 0;
  }
  
  protected int i()
  {
    if (!s()) {
      return -1;
    }
    return this.g.e();
  }
  
  public int i(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.i(paramBoolean);
    return 0;
  }
  
  public int j(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.f(paramBoolean);
    return 0;
  }
  
  public boolean j()
  {
    return s();
  }
  
  public int k()
  {
    return this.p.d();
  }
  
  public int k(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.g(paramBoolean);
    return 0;
  }
  
  public int l()
  {
    return this.p.e();
  }
  
  public int l(boolean paramBoolean)
  {
    if (!s()) {
      return -1;
    }
    this.g.h(paramBoolean);
    return 0;
  }
  
  public int m()
  {
    return this.p.f();
  }
  
  public int n()
  {
    return this.p.a(3);
  }
  
  public int o()
  {
    if (!s()) {
      return -1;
    }
    if ((this.g.r()) && (this.g.l())) {
      return this.p.a(3);
    }
    if (this.g.l()) {
      return this.p.e();
    }
    return this.p.d();
  }
  
  public boolean p()
  {
    if (!s()) {
      return false;
    }
    return this.g.o();
  }
  
  public boolean q()
  {
    if (!s()) {
      return false;
    }
    return this.g.l();
  }
  
  public boolean r()
  {
    if (!s()) {
      return false;
    }
    return this.g.r();
  }
  
  public boolean s()
  {
    if (this.g == null)
    {
      com.baidu.che.codriver.util.h.e("CoDriverVoice-Manager", "isWakeUpEnable mBinder = null");
      return false;
    }
    if (!this.g.q())
    {
      com.baidu.che.codriver.util.h.e("CoDriverVoice-Manager", "vrEngine has not inited yet.");
      return false;
    }
    return true;
  }
  
  public q.a t()
  {
    return this.p.a();
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */