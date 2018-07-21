package com.baidu.che.codriver.ui.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.che.codriver.h.d;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.BaseActivity;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.j;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.m.b;
import com.baidu.che.codriver.vr.m.c;
import com.baidu.che.codriver.vr.o;
import com.baidu.che.codriver.vr.p;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
  implements a, com.baidu.che.codriver.vr.h, m
{
  public static final int a = 100;
  public static final int b = 101;
  public static final int c = 102;
  public static final int d = 103;
  public static final int e = 105;
  public static final int f = 106;
  public static final int g = 107;
  public static final int h = 1;
  public static final int i = 4;
  public static final int j = 3;
  private static final String k = "VoiceMainController";
  private static b l;
  private static final int m = 60000;
  private static final int n = 1001;
  private static final int o = 1002;
  private static final int p = 1003;
  private static final int q = 1004;
  private boolean A = false;
  private boolean B = false;
  private m.a C;
  private m.b D;
  private Handler E = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 1001: 
      case 1002: 
        do
        {
          do
          {
            return;
          } while ((b.u() == null) || (!b.a(b.this).l()));
          d.a().d();
          return;
          if (b.a(b.this).l())
          {
            com.baidu.che.codriver.util.c.a(b.b(b.this), "10001", "二次交互");
            b.c(b.this);
            return;
          }
        } while (!b.d(b.this));
        b.c(b.this);
        return;
      case 1003: 
        if (b.e(b.this) == 3) {
          com.baidu.che.codriver.util.c.a(b.b(b.this), "10001", "手动唤醒");
        }
        for (;;)
        {
          b.c(b.this);
          return;
          com.baidu.che.codriver.util.c.a(b.b(b.this), "10001", "语音唤醒");
        }
      }
      com.baidu.che.codriver.util.h.b("VoiceMainController", "ADD_CHAT_MODEL");
      b.this.a((com.baidu.che.codriver.ui.d.b)paramAnonymousMessage.obj);
    }
  };
  private com.baidu.che.codriver.h.b F = new com.baidu.che.codriver.h.b()
  {
    public void onSpeechFinish(String paramAnonymousString)
    {
      int i;
      if ((f.a(f.a.ac)) && (com.baidu.carlife.l.a.a().N()))
      {
        i = 700;
        b.a(b.this, false);
        if (b.g(b.this) != null)
        {
          b.g(b.this).a();
          b.a(b.this, null);
        }
        com.baidu.che.codriver.util.h.b("VoiceMainController", "SpeechFinish VoiceMainController: " + this.b.j);
        if ((this.b.j != 1) && (this.b.j != 0)) {
          break label137;
        }
        b.f(b.this).sendEmptyMessageDelayed(1002, i);
      }
      label137:
      while (this.b.j != 2)
      {
        return;
        i = 500;
        break;
      }
      b.f(b.this).post(new Runnable()
      {
        public void run()
        {
          b.this.a();
        }
      });
    }
    
    public void onSpeechStart(String paramAnonymousString)
    {
      b.a(b.this, true);
    }
  };
  private com.baidu.carlife.logic.voice.c G;
  private m.c H = m.c.a;
  private com.baidu.che.codriver.ui.b r = new com.baidu.che.codriver.ui.b(this.t, this);
  private com.baidu.che.codriver.ui.a s = new com.baidu.che.codriver.ui.a(this.t);
  private Context t = com.baidu.che.codriver.util.c.a();
  private int u = 100;
  private boolean v = false;
  private boolean w = false;
  private long x = 0L;
  private boolean y = false;
  private int z = 0;
  
  public static b b()
  {
    if (l == null) {}
    try
    {
      if (l == null) {
        l = new b();
      }
      return l;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "showVrDialog: " + this.r.l());
    if (paramBoolean)
    {
      com.baidu.che.codriver.util.h.b("VoiceMainController", "wakeUp show: " + this.r.l());
      if (this.r.l())
      {
        this.z = 4;
        m();
        com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
        localb.g = paramString1;
        localb.f = b.a.b;
        b(localb);
        if (this.G == null) {
          break label206;
        }
        if (this.G.b()) {
          this.r.a(paramBoolean, paramString1);
        }
      }
    }
    for (;;)
    {
      if (!"weather".equals(paramString2)) {
        break label218;
      }
      com.baidu.che.codriver.vr.a.c.a().a(this.t.getString(2131296721), this, this.t);
      return;
      this.z = 1;
      if (this.G == null) {
        break;
      }
      this.G.a(paramString1);
      break;
      if (!this.r.l()) {
        break;
      }
      return;
      label206:
      this.r.a(paramBoolean, paramString1);
    }
    label218:
    if ("music".equals(paramString2))
    {
      com.baidu.che.codriver.vr.a.c.a().a("来首音乐", this, this.t);
      return;
    }
    if (s() == m.c.b)
    {
      a(this.t.getString(2131298673), 1);
      return;
    }
    if (s() == m.c.d)
    {
      a(this.t.getString(2131297735), 1);
      return;
    }
    if (s() == m.c.c)
    {
      a(this.t.getString(2131297736), 1);
      return;
    }
    if (s() == m.c.e)
    {
      a(this.t.getString(2131297737), 1);
      return;
    }
    if ((paramBoolean) || (TextUtils.isEmpty(paramString1)))
    {
      d.a().e();
      return;
    }
    a(paramString1, 1);
  }
  
  private boolean c(com.baidu.che.codriver.ui.d.b paramb)
  {
    if (paramb == null)
    {
      com.baidu.che.codriver.util.h.b("VoiceMainController", "####### onWakeUp Finish null ");
      return true;
    }
    if (paramb.k) {
      return false;
    }
    com.baidu.che.codriver.util.h.b("VoiceMainController", "onWakeUp Finish: " + paramb.f);
    switch (6.a[paramb.f.ordinal()])
    {
    default: 
      a(101);
      o.a().l();
      if (paramb == null)
      {
        n();
        return true;
      }
      break;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return false;
    }
    if (paramb.i != 0) {
      d(paramb);
    }
    for (;;)
    {
      e(paramb);
      return true;
      this.v = false;
    }
  }
  
  private void d(com.baidu.che.codriver.ui.d.b paramb)
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "processError: " + paramb.i + ";mHasTryAgain:" + this.v);
    switch (paramb.i)
    {
    default: 
      paramb.h = "tts_record_dont_understand_try_again";
      paramb.g = com.baidu.carlife.logic.voice.b.a();
    case 3: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 2000: 
    case 2001: 
    case 2002: 
    case 2003: 
    case 2004: 
    case 2005: 
    case 2006: 
    case 2100: 
    case 2101: 
    case 3000: 
    case 3001: 
    case 3002: 
    case 3003: 
    case 3006: 
    case 3007: 
    case 3008: 
    case 3009: 
    case 3010: 
    case 3011: 
    case 3100: 
    case 4001: 
    case 4002: 
    case 4004: 
    case 1: 
    case 2: 
    case 5001: 
    case 5002: 
    case 5003: 
    case 5004: 
    case 5005: 
    case 4: 
    case 6: 
    case 3101: 
    case 6001: 
    case 7: 
    case 8001: 
    case 9001: 
    case 21: 
      for (;;)
      {
        if ((paramb.i != 4) && (paramb.i != 7)) {
          this.v = false;
        }
        return;
        paramb.h = "tts_record_network_unavailble";
        paramb.g = this.t.getString(2131296717);
        com.baidu.che.codriver.util.c.a(this.t, "10020", "网络错误");
        if (this.G != null)
        {
          this.G.a(2);
          continue;
          paramb.h = "tts_record_microphone_busy";
          paramb.g = this.t.getString(2131296595);
          paramb.j = 2;
          com.baidu.che.codriver.util.c.a(this.t, "10020", "麦克风错误");
          if (this.G != null) {
            this.G.a(3);
          }
          this.v = false;
          continue;
          if (!this.v)
          {
            paramb.h = "tts_record_dont_understand_try_again";
            paramb.g = com.baidu.carlife.logic.voice.b.a();
            paramb.j = 2;
          }
          for (this.v = false;; this.v = false)
          {
            com.baidu.che.codriver.util.c.a(this.t, "10020", "服务端错误");
            if (this.G == null) {
              break;
            }
            this.G.a(4);
            break;
            paramb.h = "tts_record_dont_understand_quit";
            paramb.g = this.t.getString(2131296728);
            paramb.j = 2;
          }
          paramb.h = "tts_record_xiaodu_is_uncomfortable";
          paramb.g = this.t.getString(2131297239);
          com.baidu.che.codriver.util.c.a(this.t, "10020", "客户端错误");
          if (this.G != null)
          {
            this.G.a(5);
            continue;
            if (com.baidu.che.codriver.vr.a.c.a().f())
            {
              paramb.j = 0;
            }
            else
            {
              paramb.h = "tts_record_end_hint_3";
              paramb.g = this.t.getString(2131296723);
              com.baidu.che.codriver.util.c.a(this.t, "10020", "超时错误");
              if (this.G != null)
              {
                this.G.a(6);
                continue;
                paramb.g = "";
                paramb.j = 1;
                com.baidu.che.codriver.util.h.b("VoiceMainController", "--error 7---");
                com.baidu.che.codriver.util.c.a(this.t, "10020", "无匹配错误");
                if (this.G != null)
                {
                  this.G.a(7);
                  continue;
                  paramb.h = "tts_record_server_busy";
                  paramb.g = this.t.getString(2131297237);
                  com.baidu.che.codriver.util.c.a(this.t, "10020", "引擎忙错误");
                  continue;
                  paramb.h = "tts_record_microphone_unavailble";
                  paramb.g = this.t.getString(2131296594);
                  com.baidu.che.codriver.util.c.a(this.t, "10020", "无权限错误");
                  if (this.G != null)
                  {
                    this.G.a(9);
                    continue;
                    paramb.h = "tts_record_error_no_position";
                    paramb.g = this.t.getString(2131296456);
                    com.baidu.che.codriver.util.c.a(this.t, "10020", "定位错误");
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!this.v)
    {
      paramb.h = "tts_record_dont_understand_try_again";
      if (!j.a(this.t))
      {
        paramb.g = this.t.getString(2131296717);
        paramb.j = 2;
        if (this.G != null) {
          this.G.a(2);
        }
      }
    }
    for (this.v = false;; this.v = false)
    {
      com.baidu.che.codriver.util.c.a(this.t, "10020", "服务端错误");
      break;
      paramb.g = com.baidu.carlife.logic.voice.b.a();
      paramb.j = 1;
      this.v = true;
      return;
      paramb.g = this.t.getString(2131296728);
      paramb.h = "tts_record_dont_understand_quit";
      paramb.j = 2;
    }
  }
  
  private void e(com.baidu.che.codriver.ui.d.b paramb)
  {
    if (paramb.f == b.a.b) {
      return;
    }
    this.F.a(paramb);
    if (TextUtils.isEmpty(paramb.h))
    {
      d.a().a(paramb.g, this.F);
      return;
    }
    d.a().a(paramb, this.F);
  }
  
  private void f(String paramString)
  {
    Intent localIntent = new Intent("com.baidu.codriver.action.START");
    localIntent.setData(Uri.parse("codriver://lanuch"));
    Bundle localBundle = new Bundle();
    localBundle.putString("mode", paramString);
    localIntent.putExtras(localBundle);
    localIntent.setFlags(268435456);
    this.t.startActivity(localIntent);
  }
  
  private void v()
  {
    if (this.G != null) {
      this.G.e();
    }
    o.a().m();
    o();
  }
  
  private void w()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.x <= 500L) {
      return;
    }
    this.x = l1;
    switch (this.u)
    {
    case 102: 
    case 104: 
    default: 
      return;
    case 101: 
      a(102);
      com.baidu.che.codriver.util.c.a(this.t, "10001", "手动唤醒");
      m();
      v();
      return;
    case 103: 
    case 107: 
      c();
      a(105);
      return;
    }
    a(101);
    o.a().l();
    this.r.b("");
    n();
  }
  
  private void x()
  {
    if (this.G != null)
    {
      o.a().o();
      this.G.a();
    }
    if ((this.r != null) && (this.r.l()))
    {
      this.r.d();
      o();
    }
    if (this.G != null) {
      this.G.c();
    }
    for (;;)
    {
      if ((s() == m.c.b) && (this.G != null)) {
        this.G.d();
      }
      a(m.c.a);
      this.z = 0;
      a(101);
      if (this.C != null)
      {
        this.C.a();
        this.C = null;
      }
      if (this.y) {
        com.baidu.che.codriver.util.c.a(this.t, "10002");
      }
      return;
      o.a().o();
    }
  }
  
  private void y()
  {
    BaseActivity.a(BaseActivity.b());
  }
  
  public void a()
  {
    y();
    x();
    if ((com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().getCurrentFragment() != null) && ((com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().getCurrentFragment() instanceof CarModeQuickRoutePlanFragment))) {
      ((CarModeQuickRoutePlanFragment)com.baidu.carlife.core.screen.presentation.h.a().getNaviFragmentManager().getCurrentFragment()).updateListView();
    }
    if (this.A)
    {
      if (this.G != null)
      {
        o.a().o();
        this.G.a();
      }
      com.baidu.che.codriver.h.a.a().c();
    }
    this.A = false;
    this.B = false;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
    switch (paramInt)
    {
    case 104: 
    default: 
      return;
    case 100: 
      com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_INITING");
      this.r.setStateIniting(this.t.getString(2131297160));
      return;
    case 101: 
      com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_IDLE");
      this.r.setStatePrepared();
      return;
    case 103: 
      com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_LISTENING");
      this.r.setStateRecording();
      return;
    case 105: 
      com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_RECOGNIZING");
      this.r.setStatePrecessing();
      return;
    case 106: 
      com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_SEARCHING");
      return;
    case 102: 
      com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_BEFORE_READY");
      return;
    }
    com.baidu.che.codriver.util.h.b("VoiceMainController", "state = STATE_READY");
    this.r.setStateListening();
  }
  
  public void a(View paramView)
  {
    if (this.r != null) {}
  }
  
  public void a(com.baidu.carlife.logic.voice.c paramc)
  {
    this.G = paramc;
  }
  
  public void a(NLPResponseData paramNLPResponseData)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Vr onParseComplexResult: ");
    if (paramNLPResponseData != null) {}
    for (String str = paramNLPResponseData.toString();; str = "null")
    {
      com.baidu.che.codriver.util.h.b("VoiceMainController", str);
      com.baidu.che.codriver.vr.a.c.a().a(paramNLPResponseData, this, this.t).h();
      return;
    }
  }
  
  public void a(com.baidu.che.codriver.sdk.b.a parama)
  {
    if (parama == null) {
      return;
    }
    parama = String.format("{\"wechat_name\": \"%s\",\"wechat_id\": \"%s\"}", new Object[] { parama.a(), parama.c() });
    p localp = new p();
    localp.a("wechat");
    localp.b("listen");
    localp.c(parama);
    parama = com.baidu.che.codriver.vr.a.c.a().a(localp, this, this.t);
    com.baidu.che.codriver.vr.a.c.a().b(parama);
    a(m.c.b);
    t();
  }
  
  public void a(BaseActivity paramBaseActivity) {}
  
  public void a(com.baidu.che.codriver.ui.d.b paramb)
  {
    if (this.G != null) {
      this.G.h();
    }
    com.baidu.che.codriver.util.h.b("VoiceMainController", "####### onFinish: ");
    if ((paramb != null) && (this.G != null) && (paramb.i == 0)) {
      this.G.a(0);
    }
    if (!this.r.l())
    {
      if (!this.A) {
        return;
      }
      if (this.A)
      {
        if (c(paramb))
        {
          this.F.b.j = 2;
          return;
        }
        com.baidu.che.codriver.util.h.b("VoiceMainController", "WakeUp need show dialog !");
        if (this.G == null) {
          break label155;
        }
        if (this.G.b()) {
          this.r.a(false, null);
        }
      }
    }
    for (;;)
    {
      a(101);
      o.a().o();
      if (paramb != null) {
        break;
      }
      n();
      return;
      label155:
      this.r.a(false, null);
    }
    com.baidu.che.codriver.util.h.b("VoiceMainController", "onFinish type=" + paramb.f.name());
    if (paramb.i != 0) {
      d(paramb);
    }
    for (;;)
    {
      this.r.a(paramb);
      e(paramb);
      return;
      this.v = false;
    }
  }
  
  public void a(com.baidu.che.codriver.ui.d.b paramb, m.a parama, m.b paramb1)
  {
    this.C = parama;
    this.D = paramb1;
    a(paramb);
  }
  
  public void a(m.c paramc)
  {
    this.H = paramc;
  }
  
  public void a(p paramp)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Vr onParseNormalResult: ");
    if (paramp != null) {}
    for (String str = paramp.toString();; str = "null")
    {
      com.baidu.che.codriver.util.h.b("VoiceMainController", str);
      paramp = com.baidu.che.codriver.vr.a.c.a().a(paramp, this, this.t);
      paramp.h();
      com.baidu.che.codriver.vr.a.c.a().a(paramp);
      return;
    }
  }
  
  public void a(String paramString)
  {
    a(true, paramString);
    this.y = true;
  }
  
  public void a(String paramString, int paramInt)
  {
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.j = paramInt;
    localb.g = paramString;
    b(localb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    a(paramBoolean, paramString, null);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.B = true;
    if ((paramBoolean) && (!this.r.l()))
    {
      this.A = true;
      com.baidu.che.codriver.util.h.b("VoiceMainController", "wake up no show dialog !");
      this.G.a(paramString1);
      com.baidu.che.codriver.h.a.a().b();
      if (this.G.b()) {
        d.a().e();
      }
      return;
    }
    b(paramBoolean, paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {
      return false;
    }
    return Pattern.compile(paramString2).matcher(paramString1).find();
  }
  
  public void b(int paramInt) {}
  
  public void b(com.baidu.che.codriver.ui.d.b paramb)
  {
    if ((this.r != null) && (this.r.l()))
    {
      this.r.a(paramb);
      e(paramb);
    }
    while (!this.A) {
      return;
    }
    e(paramb);
  }
  
  public void b(m.c paramc)
  {
    if ((paramc != m.c.d) && (paramc != m.c.c) && (paramc != m.c.e)) {
      return;
    }
    a(paramc);
    t();
  }
  
  public void b(String paramString)
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "onUpdateRawText rawText = " + paramString);
    if (com.baidu.che.codriver.vr.a.c.a().e())
    {
      if ((paramString.equals("上一页")) || (paramString.equals("下一页")) || (paramString.equals("上页")) || (paramString.equals("下页"))) {}
      while (a(paramString, "[一|二|三|四|五|六|七|八|九|十][个|项|张|页]")) {
        return;
      }
    }
    d(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.baidu.che.codriver.a.j = 3;
      return;
    }
    com.baidu.che.codriver.a.j = 6;
  }
  
  public void c()
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "stopVrEngine");
    if (this.G != null) {
      this.G.g();
    }
    o.a().a(false);
  }
  
  public void c(String paramString)
  {
    if (!this.r.l()) {}
    while ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    paramString = new StringBuilder("\"").append(paramString).append("\"");
    this.r.b(paramString.toString());
  }
  
  public void d()
  {
    m();
    a(101);
    o.a().l();
  }
  
  public void d(String paramString)
  {
    if (!this.r.l()) {}
    while ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    this.y = false;
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.f = b.a.b;
    localb.g = ("\"" + paramString + "\"");
    this.r.a(localb);
  }
  
  public void e()
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "switchToPrevPage()");
    a(null);
    String str;
    if (this.r.n()) {
      if (this.r.o()) {
        str = "上一页";
      }
    }
    for (;;)
    {
      d.a().a(str, new com.baidu.che.codriver.h.b()
      {
        public void onSpeechFinish(String paramAnonymousString)
        {
          b.f(b.this).obtainMessage(1002).sendToTarget();
        }
      });
      return;
      str = "已经是最前一页";
      continue;
      str = "当前不支持翻页";
    }
  }
  
  public void e(String paramString)
  {
    b(false, null, paramString);
  }
  
  public void f()
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "switchToNextPage()");
    a(null);
    String str;
    if (this.r.n()) {
      if (this.r.p()) {
        str = "下一页";
      }
    }
    for (;;)
    {
      d.a().a(str, new com.baidu.che.codriver.h.b()
      {
        public void onSpeechFinish(String paramAnonymousString)
        {
          b.f(b.this).obtainMessage(1002).sendToTarget();
        }
      });
      return;
      str = "已经是最后一页";
      continue;
      str = "当前不支持翻页";
    }
  }
  
  public boolean g()
  {
    return this.u != 101;
  }
  
  public boolean h()
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "Current state: " + this.u);
    return this.u == 107;
  }
  
  public void i() {}
  
  public void j()
  {
    if (this.G != null) {
      this.G.f();
    }
    if (!this.r.l()) {
      return;
    }
    a(107);
  }
  
  public void k()
  {
    if (!this.r.l()) {
      return;
    }
    a(103);
  }
  
  public void l()
  {
    if (this.G != null) {
      this.G.g();
    }
    if (!this.r.l()) {
      return;
    }
    a(105);
  }
  
  public void m()
  {
    d.a().c();
    this.w = false;
  }
  
  public void n()
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "sendTimeOutMsg");
    if ((!this.w) && (this.u == 101))
    {
      this.E.removeMessages(1001);
      this.E.sendEmptyMessageDelayed(1001, 60000L);
    }
  }
  
  public void o()
  {
    com.baidu.che.codriver.util.h.b("VoiceMainController", "removeTimeOutMsg");
    this.E.removeMessages(1001);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131625510: 
      w();
      return;
    case 2131625504: 
      com.baidu.che.codriver.util.h.e("VoiceMainController", "####### show help dialog");
      this.E.postDelayed(new Runnable()
      {
        public void run()
        {
          b.this.a();
        }
      }, 100L);
      o.a().o();
      this.s.a(true);
      return;
    }
    com.baidu.che.codriver.util.h.b("VoiceMainController", "click voice recognition close button !");
    a();
    m();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      o();
      continue;
      n();
    }
  }
  
  public void p()
  {
    if (this.r != null) {}
  }
  
  public boolean q()
  {
    return this.r.l();
  }
  
  public boolean r()
  {
    if (!this.B) {
      return false;
    }
    return this.w;
  }
  
  public m.c s()
  {
    return this.H;
  }
  
  public void t()
  {
    a(false, null, null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/ui/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */