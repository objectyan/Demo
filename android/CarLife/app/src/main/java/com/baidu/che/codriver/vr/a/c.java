package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.che.codriver.platform.PlatformManager;
import com.baidu.che.codriver.platform.PlatformUtils;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData.Result;
import com.baidu.che.codriver.ui.d.g;
import com.baidu.che.codriver.vr.e;
import com.baidu.che.codriver.vr.j.a;
import com.baidu.che.codriver.vr.m.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final String a = "CoDriverVoice-CommandManager";
  private static final Object b = new Object();
  private static c c;
  private a d;
  private a e;
  private boolean f;
  
  public static c a()
  {
    if (c == null) {}
    synchronized (b)
    {
      if (c == null) {
        c = new c();
      }
      return c;
    }
  }
  
  private e b(String paramString1, String paramString2, Pair<String, String>... paramVarArgs)
  {
    final com.baidu.che.codriver.vr.p localp = new com.baidu.che.codriver.vr.p();
    localp.a(paramString1);
    localp.b(paramString2);
    localp.a(0);
    localp.a(1.0F);
    JSONObject localJSONObject = new JSONObject();
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Pair<String, String> localPair = paramVarArgs[i];
        try
        {
          localJSONObject.putOpt((String)localPair.first, localPair.second);
          i += 1;
        }
        catch (JSONException paramString1)
        {
          return null;
        }
      }
    }
    localp.c(localJSONObject.toString());
    paramVarArgs = new JSONObject();
    try
    {
      paramVarArgs.put("domain", paramString1);
      paramVarArgs.put("intent", paramString2);
      paramVarArgs.putOpt("object", localJSONObject);
      localp.e(paramVarArgs.toString());
      new e()
      {
        public String c()
        {
          return localp.g();
        }
        
        public String d()
        {
          return localp.b();
        }
        
        public String e()
        {
          return localp.c();
        }
        
        public String f()
        {
          return localp.e();
        }
        
        public String g()
        {
          return localp.d();
        }
      };
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "---createJsonResult--ERROR---");
        paramString1.printStackTrace();
      }
    }
  }
  
  public a a(NLPResponseData paramNLPResponseData, com.baidu.che.codriver.vr.m paramm, Context paramContext)
  {
    NLPResponseData.Result localResult = g.a(paramNLPResponseData);
    if (localResult == null) {
      return new q(null, paramm, paramContext);
    }
    com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "----createNLPCommand-cardType:" + localResult.cardType);
    if ((e()) && ("listen".equals(this.d.e()))) {
      return new h(paramNLPResponseData, paramm, paramContext);
    }
    if (localResult.cardType.equals("travel")) {
      return new ac(paramNLPResponseData, paramm, paramContext);
    }
    if (localResult.cardType.equals("image_search")) {
      return new f(paramNLPResponseData, paramm, paramContext);
    }
    if (localResult.cardType.equals("violation")) {
      return new l(paramNLPResponseData, paramm, paramContext);
    }
    if (localResult.cardType.equals("flight")) {
      return new l(paramNLPResponseData, paramm, paramContext);
    }
    if (localResult.cardType.equals("train_ticket")) {
      return new aa(paramNLPResponseData, paramm, paramContext);
    }
    if (localResult.cardType.equals("parking")) {
      return new l(paramNLPResponseData, paramm, paramContext);
    }
    return new l(paramNLPResponseData, paramm, paramContext);
  }
  
  public a a(com.baidu.che.codriver.vr.p paramp, com.baidu.che.codriver.vr.m paramm, Context paramContext)
  {
    if (paramp == null) {
      return new q(paramp, paramm, paramContext);
    }
    com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "----createCommand-domain:" + paramp.b());
    com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "----createCommand-intent:" + paramp.c());
    if (paramp.a() != 0) {
      return new d(paramp, paramm, paramContext);
    }
    if ((e()) && ("listen".equals(this.d.e()))) {
      return new h(paramp, paramm, paramContext);
    }
    if (f())
    {
      if (("codriver".equals(paramp.b())) && (("select".equals(paramp.c())) || ("back".equals(paramp.c())) || ("next".equals(paramp.c())) || ("no".equals(paramp.c())) || ("yes".equals(paramp.c())) || ("quit".equals(paramp.c())))) {
        return new h(paramp, paramm, paramContext);
      }
      g();
    }
    if (((paramm.s() == m.c.c) || (paramm.s() == m.c.d)) && (!"poi".equals(paramp.c())) && (!"select".equals(paramp.c())) && (!"other".equals(paramp.c())) && (!"back".equals(paramp.c())) && (!"next".equals(paramp.c())))
    {
      a().d();
      paramm.a(m.c.a);
    }
    if ("telephone".equals(paramp.b())) {
      return new v(paramp, paramm, paramContext);
    }
    if ("other".equals(paramp.b())) {
      return new l(paramp, paramm, paramContext);
    }
    if ("music".equals(paramp.b())) {
      return new k(paramp, paramm, paramContext);
    }
    if ("player".equals(paramp.b()))
    {
      int i = 0;
      try
      {
        boolean bool = new JSONObject(paramp.d()).has("device");
        i = bool;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      if (("set".equals(paramp.c())) && (i != 0)) {
        return new q(paramp, paramm, paramContext);
      }
      return new w(paramp, paramm, paramContext);
    }
    if (("map".equals(paramp.b())) && ("nearby".equals(paramp.c()))) {
      return new p(paramp, paramm, paramContext);
    }
    if (("map".equals(paramp.b())) && (("route".equals(paramp.c())) || ("poi".equals(paramp.c())))) {
      return new y(paramp, paramm, paramContext);
    }
    if ("navigate_instruction".equals(paramp.b()))
    {
      if (("set_home".equals(paramp.c())) || ("set_work".equals(paramp.c())) || ("route_home".equals(paramp.c())) || ("route_work".equals(paramp.c()))) {
        return new m(paramp, paramm, paramContext);
      }
      return new n(paramp, paramm, paramContext);
    }
    if ("codriver".equals(paramp.b()))
    {
      if (("select".equals(paramp.c())) || ("back".equals(paramp.c())) || ("next".equals(paramp.c())) || ("no".equals(paramp.c())) || ("yes".equals(paramp.c())) || ("quit".equals(paramp.c()))) {
        return new h(paramp, paramm, paramContext);
      }
      if (("addWakeUpWord".equals(paramp.c())) || ("wakeup".equals(paramp.c()))) {
        return new ae(paramp, paramm, paramContext);
      }
      if ("customCmd".equals(paramp.c())) {
        return new r(paramp, paramm, paramContext);
      }
      if ("login".equals(paramp.c())) {
        return new t(paramp, paramm, paramContext);
      }
      if ("logout".equals(paramp.c())) {
        return new i(paramp, paramm, paramContext, false);
      }
      if (("download".equals(paramp.c())) || ("sync".equals(paramp.c()))) {
        return new t(paramp, paramm, paramContext);
      }
      String str = paramp.c();
      if ((!TextUtils.isEmpty(str)) && (!str.startsWith("dr_"))) {}
    }
    while (TextUtils.isEmpty(paramp.b()))
    {
      return new q(paramp, paramm, paramContext);
      return new z(paramp, paramm, paramContext);
      if ("app".equals(paramp.b()))
      {
        if (paramp.d().contains("导航")) {
          return new o(paramp, paramm, paramContext);
        }
        return new z(paramp, paramm, paramContext);
      }
      if ("app".equals(paramp.b())) {
        return new z(paramp, paramm, paramContext);
      }
      if ("calendar".equals(paramp.b())) {
        return new b(paramp, paramm, paramContext);
      }
      if ("train".equals(paramp.b())) {
        return new l(paramp, paramm, paramContext);
      }
      if ("flight".equals(paramp.b())) {
        return new l(paramp, paramm, paramContext);
      }
      if ("hotel".equals(paramp.b())) {
        return new l(paramp, paramm, paramContext);
      }
      if ("wechat".equals(paramp.b())) {
        return new af(paramp, paramm, paramContext);
      }
      if ("sound_program".equals(paramp.b())) {
        return new x(paramp, paramm, paramContext);
      }
      if ("radio".equals(paramp.b())) {
        return new x(paramp, paramm, paramContext);
      }
      if ("carlife".equals(paramp.b())) {
        return new t(paramp, paramm, paramContext);
      }
    }
    return new z(paramp, paramm, paramContext);
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  public void a(String paramString, com.baidu.che.codriver.vr.m paramm, Context paramContext)
  {
    a(paramString, paramm, paramContext, null);
  }
  
  public void a(String paramString, final com.baidu.che.codriver.vr.m paramm, final Context paramContext, Map<String, Map> paramMap)
  {
    com.baidu.che.codriver.vr.o.a().a(paramMap, paramString, new j.a()
    {
      public void a(NLPResponseData paramAnonymousNLPResponseData)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Nlp onParseComplexResult: ");
        if (paramAnonymousNLPResponseData != null) {}
        for (String str = paramAnonymousNLPResponseData.toString();; str = "null")
        {
          com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", str);
          c.this.a(paramAnonymousNLPResponseData, paramm, paramContext).h();
          return;
        }
      }
      
      public void a(com.baidu.che.codriver.vr.p paramAnonymousp)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Nlp onParseNormalResult: ");
        if (paramAnonymousp != null) {}
        for (String str = paramAnonymousp.toString();; str = "null")
        {
          com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", str);
          c.this.a(paramAnonymousp, paramm, paramContext).h();
          return;
        }
      }
      
      public void a(String paramAnonymousString)
      {
        com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "Nlp onParseRawText: rawText=" + paramAnonymousString);
      }
    });
  }
  
  public boolean a(int paramInt, String paramString, Boolean paramBoolean)
  {
    return PlatformManager.getInstance().handleCommand(paramInt, paramString, paramBoolean);
  }
  
  public boolean a(e parame)
  {
    if (parame == null) {
      return false;
    }
    PlatformUtils.getCommandType(parame);
    com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "####### handlePlatformCommand cmdType: " + parame.c());
    return a(parame, Boolean.valueOf(true));
  }
  
  public boolean a(e parame, Boolean paramBoolean)
  {
    com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "####### handlePlatformCommand ICommand cmdResult: " + parame.c());
    return PlatformManager.getInstance().handleCommand(parame, paramBoolean);
  }
  
  public boolean a(String paramString1, String paramString2, Pair<String, String>... paramVarArgs)
  {
    return a(b(paramString1, paramString2, paramVarArgs));
  }
  
  public a b()
  {
    return this.e;
  }
  
  public void b(a parama)
  {
    this.d = parama;
  }
  
  public a c()
  {
    return this.d;
  }
  
  public void c(a parama)
  {
    this.d.a(parama);
  }
  
  public void d()
  {
    b(null);
    com.baidu.che.codriver.util.h.b("CoDriverVoice-CommandManager", "-----quitMultiInteraction---");
  }
  
  public void d(a parama)
  {
    b(parama);
    this.f = true;
  }
  
  public boolean e()
  {
    return this.d != null;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public void g()
  {
    d();
    this.f = false;
  }
  
  public void h()
  {
    g();
    this.e = null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */