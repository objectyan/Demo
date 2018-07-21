package com.baidu.che.codriver.vr;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.che.codriver.i.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.util.l;
import com.baidu.che.codriver.vr.record.aec.RecordHelper;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.a;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.b;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.c;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.utils.LogUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceService
  extends Service
{
  private static final String a = "CoDriverVoice-Service";
  private static String b;
  private EventListener c = null;
  private EventManager d = null;
  private EventManager e = null;
  private EventManager f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private HashMap<String, Object> j = null;
  private HashMap<String, Object> k = null;
  private RecordHelper l = null;
  private boolean m = false;
  private boolean n = false;
  private boolean o = true;
  private boolean p = false;
  private boolean q = false;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private String[] u = null;
  private String v;
  private int w = 811;
  private String x = "com.baidu.carlife";
  private b y = new b();
  
  private int a(int paramInt)
  {
    if (m() == -1) {
      return -1;
    }
    return b(paramInt);
  }
  
  private int a(String paramString, int paramInt)
  {
    paramString = this.j.get(paramString);
    if (paramString == null) {}
    while (!(paramString instanceof Integer)) {
      return paramInt;
    }
    return ((Integer)paramString).intValue();
  }
  
  private void a()
  {
    this.f = EventManagerFactory.create(getApplicationContext(), "slot");
    this.f.registerListener(new EventListener()
    {
      public void onEvent(String paramAnonymousString1, String paramAnonymousString2, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        h.b("CoDriverVoice-Service", "event:" + paramAnonymousString1 + ", param:" + paramAnonymousString2);
      }
    });
  }
  
  @Deprecated
  private void a(String paramString)
  {
    if (this.j == null) {
      return;
    }
    for (;;)
    {
      int i6;
      int i2;
      int i5;
      Object localObject2;
      try
      {
        localObject1 = (JSONObject)this.j.get("slot-data");
        if (((JSONObject)localObject1).isNull("words")) {
          ((JSONObject)localObject1).put("words", new JSONArray());
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("words");
        i1 = 0;
        paramString = paramString.split(",");
        i6 = paramString.length;
        i2 = 0;
      }
      catch (JSONException paramString)
      {
        Object localObject1;
        int i1;
        int i3;
        paramString.printStackTrace();
        return;
      }
      i3 = i5;
      int i4;
      if (i4 < ((JSONArray)localObject1).length())
      {
        if (((String)localObject2).equals(((JSONArray)localObject1).getString(i4))) {
          i3 = 0;
        }
      }
      else
      {
        if (i3 != 0)
        {
          ((JSONArray)localObject1).put(localObject2);
          i1 = 1;
          break label193;
          if (i1 != 0)
          {
            t();
            s();
          }
          h.b("CoDriverVoice-Service", "------------regCustomCmd:" + this.j.toString());
          return;
        }
        for (;;)
        {
          if (i2 >= i6) {
            break label198;
          }
          localObject2 = paramString[i2];
          i5 = 1;
          i4 = 0;
          break;
          label193:
          i2 += 1;
        }
        label198:
        continue;
      }
      i4 += 1;
    }
  }
  
  @Deprecated
  private void a(String paramString1, String paramString2)
  {
    this.h = paramString1;
    this.i = paramString2;
    paramString1 = new HashMap();
    paramString1.put("name", "songs");
    paramString1.put("words", this.i);
    this.f.send("slot.start", new JSONObject(paramString1).toString(), null, 0, 0);
    q();
  }
  
  private void a(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", "contacts");
    localHashMap.put("pid", "809");
    localHashMap.put("url", "http://upl.baidu.com/words/add");
    localHashMap.put("words", paramJSONArray);
    h.b("CoDriverVoice-Service", "upload contacts : contact = " + paramJSONArray.toString());
    this.f.send("uploader.start", new JSONObject(localHashMap).toString(), null, 0, 0);
  }
  
  private int b(int paramInt)
  {
    h.b("CoDriverVoice-Service", "command:openSceneCmdInWaking type = " + paramInt);
    if (this.e == null)
    {
      h.b("CoDriverVoice-Service", "command:openSceneCmdInWaking wakeupManager is null");
      return -1;
    }
    if (!this.r)
    {
      h.b("CoDriverVoice-Service", "command:openSceneCmdInWaking sceneCmdFlag is false");
      return -1;
    }
    if ((paramInt & 0x3) == 0)
    {
      h.b("CoDriverVoice-Service", "command:openSceneCmdInWaking. unknown type " + paramInt);
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("kwd.enable-all-keywords", Integer.valueOf(0));
    JSONArray localJSONArray = new JSONArray();
    b(localJSONArray);
    String[] arrayOfString;
    int i2;
    int i1;
    if ((paramInt & 0x1) != 0)
    {
      arrayOfString = c.bn;
      i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        localJSONArray.put(arrayOfString[i1]);
        i1 += 1;
      }
    }
    if ((paramInt & 0x2) != 0)
    {
      arrayOfString = c.bo;
      i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        localJSONArray.put(arrayOfString[i1]);
        i1 += 1;
      }
    }
    Log.i("CoDriverVoice-Service", "command:openSceneCmdInWaking type = " + paramInt + " , kwd array : " + localJSONArray.toString());
    localHashMap.put("kwd.enable-keyword", localJSONArray);
    this.e.send("kwd.config", new JSONObject(localHashMap).toString(), null, 0, 0);
    return 0;
  }
  
  private void b()
  {
    if (this.l != null) {
      return;
    }
    this.l = new RecordHelper();
    this.l.init(this, new RecordHelper.c()
    {
      public void a(int paramAnonymousInt)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("kwd.volume", Integer.valueOf(paramAnonymousInt));
        VoiceService.h(VoiceService.this).send("kwd.config", new JSONObject(localHashMap).toString(), null, 0, 0);
        h.b("CoDriverVoice-Service", "---kwd.config----");
      }
    });
  }
  
  private void b(JSONArray paramJSONArray)
  {
    paramJSONArray.put("小度小度");
    if (this.u != null)
    {
      int i1 = 0;
      while (i1 < this.u.length)
      {
        paramJSONArray.put(this.u[i1]);
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    h.b("CoDriverVoice-Service", "---RESOURCES---START COPY-----");
    com.baidu.che.codriver.i.d.a(b + "libbaidu_asr_licence_carlife.dat.so");
    com.baidu.che.codriver.i.d.a(getApplicationContext(), "libbaidu_asr_licence_carlife.dat.so", b + "libbaidu_asr_licence_carlife.dat.so");
    com.baidu.che.codriver.i.d.a(b + "libbaidu_offline_cmd_grammar.bsg.so");
    com.baidu.che.codriver.i.d.a(getApplicationContext(), "libbaidu_offline_cmd_grammar.bsg.so", b + "libbaidu_offline_cmd_grammar.bsg.so");
    com.baidu.che.codriver.i.d.a(b + "libbd_easr_s1_kws_codriver_20170913.dat.so");
    com.baidu.che.codriver.i.d.a(getApplicationContext(), "libbd_easr_s1_kws_codriver_20170913.dat.so", b + "libbd_easr_s1_kws_codriver_20170913.dat.so");
    com.baidu.che.codriver.i.d.a(b + "esis_codriver_20180119.pkg");
    com.baidu.che.codriver.i.d.a(getApplicationContext(), "esis_codriver_20180119.pkg", b + "esis_codriver_20180119.pkg");
    com.baidu.che.codriver.i.d.a(b + "WakeUp_Xiaodu.bin");
    com.baidu.che.codriver.i.d.a(getApplicationContext(), "WakeUp_Xiaodu.bin", b + "WakeUp_Xiaodu.bin");
    com.baidu.che.codriver.i.d.a(b + "libvad.dnn.so");
    com.baidu.che.codriver.i.d.a(getApplicationContext(), "libvad.dnn.so", b + "libvad.dnn.so");
    h.b("CoDriverVoice-Service", "---RESOURCES---END COPY-----");
  }
  
  private void d()
  {
    this.v = l.a(getApplicationContext(), "save_pcm_data_key", r());
    if (TextUtils.isEmpty(this.v)) {
      this.v = r();
    }
    h.b("CoDriverVoice-Service", "initSaveDataParams mSavePcmDataPath = " + this.v);
  }
  
  private void e()
  {
    if (this.e == null) {
      this.e = EventManagerFactory.create(getApplicationContext(), "wp");
    }
    if (this.k == null) {
      this.k = new HashMap();
    }
    this.n = l.a(getApplication(), "save_wake_up_rdata", false);
    this.r = l.a(getApplication(), "scene_command_key", true);
    this.k.put("sample", Integer.valueOf(16000));
    this.k.put("license", b + "libbaidu_asr_licence_carlife.dat.so");
    this.k.put("res-file", b + "esis_codriver_20180119.pkg");
    this.k.put("kws-file", b + "WakeUp_Xiaodu.bin");
    this.k.put("accept-audio-volume", Boolean.valueOf(false));
    this.k.put("wp.mode", Integer.valueOf(3));
    this.k.put("wp.kwd_enable", Boolean.valueOf(true));
    this.k.put("vad.res-file", b + "libvad.dnn.so");
    this.o = l.a(getApplication(), "wake_up", true);
    h.b("CoDriverVoice-Service", "initWakeUpConfig mIsWakeUpEnable = " + this.o);
  }
  
  private void f()
  {
    if (this.d == null) {
      this.d = EventManagerFactory.create(getApplicationContext(), "asr");
    }
    HashMap localHashMap;
    if (this.j == null)
    {
      this.j = new HashMap();
      this.j.put("slot-data", new JSONObject());
      this.m = l.a(getApplication(), "save_asr_rdata", false);
      this.q = l.a(getApplicationContext(), "support_full_bargin", false);
      this.s = l.a(getApplicationContext(), "decoder-server.ptc", false);
      this.j.put("pid", Integer.valueOf(this.w));
      this.j.put("key", this.x);
      this.j.put("url", "http://vse.baidu.com/v2");
      this.j.put("decoder-server.fix-app", "com.baidu.che.codriver");
      this.j.put("nlu", "enable");
      localHashMap = this.j;
      if (!this.s) {
        break label494;
      }
    }
    label494:
    for (int i1 = 306;; i1 = 0)
    {
      localHashMap.put("decoder-server.ptc", Integer.valueOf(i1));
      this.j.put("vad", "dnn");
      this.j.put("license", b + "libbaidu_asr_licence_carlife.dat.so");
      this.j.put("sound_success", Integer.valueOf(k.k.bdspeech_recognition_success));
      this.j.put("accept-audio-volume", Boolean.valueOf(false));
      this.j.put("vad.speech-threshold", Float.valueOf(0.25F));
      this.j.put("vad.min-speech-duration", Integer.valueOf(40));
      g();
      this.j.put("decoder", Integer.valueOf(2));
      this.j.put("vad.sil-threshold", Float.valueOf(0.15F));
      this.j.put("vad.head-sil-duration", Integer.valueOf(400));
      this.j.put("enable-early-return", Boolean.valueOf(true));
      this.j.put("vad.res-file", b + "libvad.dnn.so");
      this.j.put("dec-type", Integer.valueOf(1));
      this.j.put("decoder-server-fun.contact", Boolean.valueOf(true));
      this.j.put("sample", Integer.valueOf(16000));
      this.j.put("auth", Boolean.valueOf(false));
      h();
      return;
      this.j.clear();
      break;
    }
  }
  
  private void g()
  {
    if (this.q)
    {
      this.j.put("vad.endpoint-timeout", Integer.valueOf(0));
      this.j.put("decoder", Integer.valueOf(0));
      return;
    }
    this.j.put("vad.endpoint-timeout", Integer.valueOf(490));
    this.j.put("vad.max-wait-duration", Integer.valueOf(50));
    this.j.put("decoder", Integer.valueOf(2));
  }
  
  private void h()
  {
    this.j.put("asr-base-file-path", b + "libbd_easr_s1_kws_codriver_20170913.dat.so");
    this.j.put("grammar", b + "libbaidu_offline_cmd_grammar.bsg.so");
    this.j.put("decoder-server.auth", Boolean.valueOf(false));
  }
  
  private void i()
  {
    if (this.j == null) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = (JSONObject)this.j.get("slot-data");
        if (localJSONObject != null)
        {
          localJSONObject.put("words", new JSONArray());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private int j()
  {
    h.b("CoDriverVoice-Service", "----startVrEngine-------mIsOneshotEnable = " + this.p);
    if (!this.t) {
      return -1;
    }
    if ((this.l == null) || (TextUtils.isEmpty(this.l.getInfile())))
    {
      this.j.remove("infile");
      if (!this.m) {
        break label352;
      }
      h.b("CoDriverVoice-Service", "startAsr mSavePcmDataPath = " + this.v);
      if (!TextUtils.isEmpty(this.v)) {
        break label284;
      }
      Toast.makeText(getApplicationContext(), "无法生成保存路径", 0).show();
    }
    for (;;)
    {
      this.j.put("accept-audio-data", Boolean.valueOf(this.m));
      long l1 = SystemClock.elapsedRealtime();
      this.d.send("asr.start", new JSONObject(this.j).toString(), null, 0, 0);
      h.b("CoDriverVoice-Service", "command:asr.start-The Time of loading VR DB :" + (SystemClock.elapsedRealtime() - l1) + "ms");
      h.b("CoDriverVoice-Service", "asr.start--config:" + this.j.toString());
      return 0;
      this.j.put("infile", this.l.getInfile());
      this.l.reset();
      this.l.setState(RecordHelper.b.c);
      break;
      label284:
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
      this.j.put("outfile", this.v + "/" + localSimpleDateFormat.format(new Date()) + "#recog.pcm");
      continue;
      label352:
      this.j.remove("outfile");
    }
  }
  
  private int k()
  {
    if (this.d == null) {
      return -1;
    }
    this.d.send("asr.stop", null, null, 0, 0);
    h.b("CoDriverVoice-Service", "command:asr.stop");
    return 0;
  }
  
  private int l()
  {
    if (this.d == null) {
      return -1;
    }
    this.d.send("asr.cancel", null, null, 0, 0);
    h.b("CoDriverVoice-Service", "command:asr.cancel");
    return 0;
  }
  
  private int m()
  {
    if ((!this.o) || (!this.t))
    {
      h.e("CoDriverVoice-Service", "startWp wakeUpFlag = " + this.o + " , initFlag = " + this.t);
      return -1;
    }
    if ((this.l == null) || (TextUtils.isEmpty(this.l.getInfile())))
    {
      this.k.remove("infile");
      if (!this.n) {
        break label340;
      }
      h.b("CoDriverVoice-Service", "startWp mSavePcmDataPath = " + this.v);
      if (!TextUtils.isEmpty(this.v)) {
        break label272;
      }
      Toast.makeText(getApplicationContext(), "无法生成保存路径", 0).show();
    }
    for (;;)
    {
      this.k.put("accept-audio-data", Boolean.valueOf(this.n));
      this.e.send("wp.start", new JSONObject(this.k).toString(), null, 0, 0);
      h.b("CoDriverVoice-Service", "command:wp.start--config:" + this.k.toString());
      return 0;
      this.k.put("infile", this.l.getInfile());
      this.l.reset();
      this.l.setState(RecordHelper.b.a);
      this.l.startRecord();
      break;
      label272:
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
      this.k.put("outfile", this.v + "/" + localSimpleDateFormat.format(new Date()) + "#wakeup.pcm");
      continue;
      label340:
      this.k.remove("outfile");
    }
  }
  
  private int n()
  {
    if (this.e == null) {
      return -1;
    }
    this.e.send("wp.stop", null, null, 0, 0);
    h.b("CoDriverVoice-Service", "command:wp.stop");
    return 0;
  }
  
  private int o()
  {
    h.b("CoDriverVoice-Service", "command:closeSceneCmd");
    if (this.e == null)
    {
      h.b("CoDriverVoice-Service", "command:closeSceneCmd wakeupManager is null");
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("kwd.enable-all-keywords", Integer.valueOf(0));
    JSONArray localJSONArray = new JSONArray();
    b(localJSONArray);
    localHashMap.put("kwd.enable-keyword", localJSONArray);
    this.e.send("kwd.config", new JSONObject(localHashMap).toString(), null, 0, 0);
    return 1;
  }
  
  private void p()
  {
    if (this.l != null)
    {
      this.l.release();
      this.l = null;
    }
    this.t = false;
  }
  
  private void q()
  {
    int i2 = 0;
    if (this.j == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.g + " ";
      Object localObject1 = this.h + " ";
      Object localObject3 = this.h + " ";
      JSONArray localJSONArray = new JSONArray();
      localObject2 = ((String)localObject2).split(",");
      int i3 = localObject2.length;
      int i1 = 0;
      while (i1 < i3)
      {
        localJSONArray.put(localObject2[i1].trim());
        i1 += 1;
      }
      localObject2 = new JSONArray();
      localObject3 = ((String)localObject3).split(",");
      i3 = localObject3.length;
      i1 = 0;
      while (i1 < i3)
      {
        ((JSONArray)localObject2).put(localObject3[i1].trim());
        i1 += 1;
      }
      localObject3 = new JSONArray();
      localObject1 = ((String)localObject1).split(",");
      i3 = localObject1.length;
      i1 = i2;
      while (i1 < i3)
      {
        ((JSONArray)localObject3).put(localObject1[i1].trim());
        i1 += 1;
      }
      try
      {
        localObject1 = (JSONObject)this.j.get("slot-data");
        if (localObject1 != null)
        {
          ((JSONObject)localObject1).put("name", localJSONArray).put("song", localObject3).put("singer", localObject2);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private String r()
  {
    File localFile = getExternalFilesDir("RecordData");
    if (localFile == null) {
      return null;
    }
    return localFile.getPath();
  }
  
  private void s()
  {
    if (u() > 0)
    {
      h.b("CoDriverVoice-Service", "--asr.kws.load-----start");
      this.d.send("asr.kws.load", new JSONObject(this.j).toString(), null, 0, 0);
      h.b("CoDriverVoice-Service", "--asr.kws.load-----end");
      h.b("CoDriverVoice-Service", "--asr.kws.load-----config:" + this.j.toString());
    }
  }
  
  private void t()
  {
    if (u() > 0)
    {
      h.b("CoDriverVoice-Service", "--asr.kws.unload-----start");
      this.d.send("asr.kws.unload", null, null, 0, 0);
      h.b("CoDriverVoice-Service", "--asr.kws.unload-----end");
    }
  }
  
  private int u()
  {
    return a("basic.decoder", a("decoder", -1));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    h.e("CoDriverVoice-Service", "-----onBind------");
    return this.y;
  }
  
  public void onCreate()
  {
    super.onCreate();
    h.b("CoDriverVoice-Service", "-----onCreate-----");
    startForeground(8888, new Notification());
    b = getApplicationContext().getFilesDir().getAbsolutePath() + "/";
    h.b("CoDriverVoice-Service", "mResDir : " + b);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h.b("CoDriverVoice-Service", "-----onDestroy------");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    h.b("CoDriverVoice-Service", "-----onStartCommand-----");
    return 2;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  public class b
    extends Binder
  {
    public b() {}
    
    public int a()
    {
      return VoiceService.i(VoiceService.this);
    }
    
    public int a(RecordHelper.a parama, com.baidu.che.codriver.vr.record.d paramd)
    {
      switch (VoiceService.3.a[parama.ordinal()])
      {
      default: 
        return -1;
      }
      VoiceService.w(VoiceService.this);
      VoiceService.x(VoiceService.this).setRecordType(parama, paramd);
      return 0;
    }
    
    public int a(EventListener paramEventListener)
    {
      if ((VoiceService.g(VoiceService.this) == null) || (VoiceService.h(VoiceService.this) == null)) {
        return -1;
      }
      VoiceService.g(VoiceService.this).registerListener(paramEventListener);
      VoiceService.h(VoiceService.this).registerListener(paramEventListener);
      VoiceService.a(VoiceService.this, paramEventListener);
      return 0;
    }
    
    public int a(String paramString)
    {
      if ((paramString == null) || ((!paramString.equals("你好现代")) && (!paramString.equals("你好起亚")) && (!paramString.equals("你好北京现代")))) {
        return -1;
      }
      VoiceService.a(VoiceService.this, new String[1]);
      VoiceService.o(VoiceService.this)[0] = paramString;
      return 0;
    }
    
    @Deprecated
    public int a(String paramString1, String paramString2)
    {
      return -1;
    }
    
    public int a(String[] paramArrayOfString)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfString.length > 3)) {
        return -1;
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfString.length) {
          break label65;
        }
        if ((!paramArrayOfString[i].equals("你好现代")) && (!paramArrayOfString[i].equals("你好起亚")) && (!paramArrayOfString[i].equals("你好北京现代"))) {
          break;
        }
        i += 1;
      }
      label65:
      VoiceService.a(VoiceService.this, paramArrayOfString);
      return 0;
    }
    
    public void a(int paramInt)
    {
      VoiceService.a(VoiceService.this, paramInt);
    }
    
    public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
    {
      h.c("CoDriverVoice-Service", "isOneShot = " + paramInt1 + ", wpBacktrackFrameLen=" + paramInt2);
      if (paramInt1 == 1)
      {
        VoiceService.r(VoiceService.this).put("wakeup-status", Integer.valueOf(1));
        VoiceService.r(VoiceService.this).put("wakeup-words", paramString);
        VoiceService.r(VoiceService.this).put("isoneshot", Integer.valueOf(paramInt1));
        VoiceService.r(VoiceService.this).put("backtrack-time", Integer.valueOf(paramInt2));
        paramLong = paramLong - paramInt2 * 10 - 300L - 150L - 100L - 100L;
        if (paramLong > 0L) {
          VoiceService.r(VoiceService.this).put("audio.mills", Long.valueOf(paramLong));
        }
      }
      while (paramInt1 != 0) {
        return;
      }
      VoiceService.r(VoiceService.this).remove("audio.mills");
      VoiceService.r(VoiceService.this).put("isoneshot", Integer.valueOf(0));
      VoiceService.r(VoiceService.this).put("wakeup-status", Integer.valueOf(0));
    }
    
    public void a(final VoiceService.a parama)
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          VoiceService.a(VoiceService.this);
          VoiceService.b(VoiceService.this);
          VoiceService.c(VoiceService.this);
          VoiceService.d(VoiceService.this);
          VoiceService.e(VoiceService.this);
          VoiceService.f(VoiceService.this);
          VoiceService.a(VoiceService.this, true);
          parama.a();
        }
      }).start();
    }
    
    public void a(JSONArray paramJSONArray)
    {
      VoiceService.a(VoiceService.this, paramJSONArray);
    }
    
    public void a(boolean paramBoolean)
    {
      VoiceService.b(VoiceService.this, paramBoolean);
      l.b(VoiceService.this, "decoder-server.ptc", paramBoolean);
      if (VoiceService.p(VoiceService.this))
      {
        HashMap localHashMap = VoiceService.r(VoiceService.this);
        if (VoiceService.q(VoiceService.this)) {}
        for (int i = 306;; i = 0)
        {
          localHashMap.put("decoder-server.ptc", Integer.valueOf(i));
          return;
        }
      }
      VoiceService.c(VoiceService.this);
    }
    
    public void a(byte[] paramArrayOfByte)
    {
      if (VoiceService.x(VoiceService.this) != null) {
        VoiceService.x(VoiceService.this).feedAudioBuffer(paramArrayOfByte);
      }
    }
    
    public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      if (VoiceService.x(VoiceService.this) != null) {
        VoiceService.x(VoiceService.this).feedAudioBuffer(paramArrayOfByte1, paramArrayOfByte2);
      }
    }
    
    public int b()
    {
      return VoiceService.j(VoiceService.this);
    }
    
    public int b(int paramInt)
    {
      return VoiceService.b(VoiceService.this, paramInt);
    }
    
    public int b(EventListener paramEventListener)
    {
      VoiceService.g(VoiceService.this).unregisterListener(paramEventListener);
      return 0;
    }
    
    public void b(String paramString)
    {
      VoiceService.a(VoiceService.this, paramString);
      h.b("CoDriverVoice-Service", "setPcmDataPath mSavePcmDataPath = " + VoiceService.t(VoiceService.this));
      l.b(VoiceService.this, "save_pcm_data_key", VoiceService.u(VoiceService.this));
    }
    
    public void b(String paramString1, String paramString2)
    {
      VoiceService.a(VoiceService.this, paramString1, paramString2);
    }
    
    public void b(boolean paramBoolean)
    {
      if (VoiceService.s(VoiceService.this) == paramBoolean) {
        return;
      }
      VoiceService.c(VoiceService.this, paramBoolean);
      l.b(VoiceService.this, "wake_up", paramBoolean);
      h.b("CoDriverVoice-Service", "command:setWakeUpFlag-isOpen:" + paramBoolean);
    }
    
    public int c()
    {
      return VoiceService.k(VoiceService.this);
    }
    
    public void c(int paramInt)
    {
      if (!VoiceService.p(VoiceService.this)) {
        VoiceService.c(VoiceService.this);
      }
      VoiceService.r(VoiceService.this).put("audio.stream-type", Integer.valueOf(paramInt));
    }
    
    @Deprecated
    public void c(String paramString) {}
    
    public void c(boolean paramBoolean)
    {
      d(paramBoolean);
      e(paramBoolean);
    }
    
    public int d()
    {
      return VoiceService.l(VoiceService.this);
    }
    
    public void d(int paramInt)
    {
      if (VoiceService.x(VoiceService.this) != null) {
        VoiceService.x(VoiceService.this).setDspEchoEnergy(paramInt);
      }
    }
    
    public void d(String paramString)
    {
      VoiceService.b(VoiceService.this, paramString);
      VoiceService.r(VoiceService.this).put("key", VoiceService.F(VoiceService.this));
    }
    
    public void d(boolean paramBoolean)
    {
      VoiceService.d(VoiceService.this, paramBoolean);
      l.b(VoiceService.this, "save_wake_up_rdata", paramBoolean);
    }
    
    public int e()
    {
      return VoiceService.m(VoiceService.this);
    }
    
    public void e(int paramInt)
    {
      VoiceService.c(VoiceService.this, paramInt);
      VoiceService.r(VoiceService.this).put("pid", Integer.valueOf(VoiceService.E(VoiceService.this)));
    }
    
    public void e(boolean paramBoolean)
    {
      VoiceService.e(VoiceService.this, paramBoolean);
      l.b(VoiceService.this, "save_asr_rdata", paramBoolean);
    }
    
    public void f()
    {
      VoiceService.n(VoiceService.this);
    }
    
    public void f(boolean paramBoolean)
    {
      h.b("CoDriverVoice-Service", "setSupportFullBargin : " + paramBoolean);
      VoiceService.f(VoiceService.this, paramBoolean);
      l.b(VoiceService.this, "support_full_bargin", paramBoolean);
      if (VoiceService.p(VoiceService.this))
      {
        VoiceService.y(VoiceService.this);
        return;
      }
      VoiceService.c(VoiceService.this);
    }
    
    public String g()
    {
      String str1 = "" + "小度小度";
      String str2 = str1;
      if (VoiceService.o(VoiceService.this) != null)
      {
        int i = 0;
        for (;;)
        {
          str2 = str1;
          if (i >= VoiceService.o(VoiceService.this).length) {
            break;
          }
          str1 = str1 + "," + VoiceService.o(VoiceService.this)[i];
          i += 1;
        }
      }
      return str2;
    }
    
    public void g(boolean paramBoolean)
    {
      VoiceService.g(VoiceService.this, paramBoolean);
      HashMap localHashMap = new HashMap();
      localHashMap.put("wp.enable-oneshot", Boolean.valueOf(paramBoolean));
      h.b("CoDriverVoice-Service", "new setOneshotEnable mIsOneshotEnable = " + VoiceService.z(VoiceService.this));
      VoiceService.h(VoiceService.this).send("kwd.config", new JSONObject(localHashMap).toString(), null, 0, 0);
    }
    
    @Deprecated
    public void h() {}
    
    public void h(boolean paramBoolean)
    {
      VoiceService.h(VoiceService.this, paramBoolean);
      l.b(VoiceService.this, "scene_command_key", paramBoolean);
      h.b("CoDriverVoice-Service", "setSceneCmdEnable sceneCmdFlag = " + VoiceService.A(VoiceService.this));
    }
    
    public void i()
    {
      VoiceService.v(VoiceService.this);
    }
    
    public void i(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        VoiceService.r(VoiceService.this).put("log_level", Integer.valueOf(6));
        LogUtil.setLogLevel(0);
        return;
      }
      VoiceService.r(VoiceService.this).put("log_level", Integer.valueOf(0));
      LogUtil.setLogLevel(7);
    }
    
    public void j()
    {
      if (VoiceService.x(VoiceService.this) != null) {
        VoiceService.x(VoiceService.this).startRecord();
      }
    }
    
    public void k()
    {
      VoiceService.r(VoiceService.this).remove("audio.mills");
      VoiceService.r(VoiceService.this).put("isoneshot", Integer.valueOf(0));
      VoiceService.r(VoiceService.this).put("wakeup-status", Integer.valueOf(0));
    }
    
    public boolean l()
    {
      return VoiceService.s(VoiceService.this);
    }
    
    public boolean m()
    {
      return VoiceService.z(VoiceService.this);
    }
    
    public boolean n()
    {
      return VoiceService.B(VoiceService.this);
    }
    
    public boolean o()
    {
      return VoiceService.C(VoiceService.this);
    }
    
    public boolean p()
    {
      return VoiceService.D(VoiceService.this);
    }
    
    public boolean q()
    {
      return VoiceService.p(VoiceService.this);
    }
    
    public boolean r()
    {
      return VoiceService.A(VoiceService.this);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/VoiceService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */