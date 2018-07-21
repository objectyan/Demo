package com.baidu.che.codriver.sdk.a;

import android.text.TextUtils;
import com.baidu.che.codriver.f.a;
import com.baidu.che.codriver.f.a.a;
import com.baidu.che.codriver.protocol.d.a;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.util.h;
import com.google.gson.Gson;

public class g
{
  public static final String a = "CdNLPManager";
  
  public static g a()
  {
    return b.a();
  }
  
  public void a(String paramString)
  {
    new a(new a.a()
    {
      public void a(String paramAnonymousString)
      {
        h.b("CdNLPManager", "errMsg：" + paramAnonymousString);
        g.this.a("nlp_error", paramAnonymousString);
      }
      
      public void b(String paramAnonymousString)
      {
        h.b("CdNLPManager", "response：" + paramAnonymousString);
        paramAnonymousString = com.baidu.che.codriver.ui.d.g.b((NLPResponseData)new Gson().fromJson(paramAnonymousString, NLPResponseData.class));
        g.this.a("nlp_result", "{\"card_type\":\"" + paramAnonymousString.f + "\",\"tts\":\"" + paramAnonymousString.g + "\"}");
      }
    }).a(paramString);
  }
  
  public void a(String paramString, final a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (parama == null)) {
      return;
    }
    new a(new a.a()
    {
      public void a(String paramAnonymousString)
      {
        if (paramAnonymousString != null)
        {
          h.b("CdNLPManager", "errMsg：" + paramAnonymousString);
          parama.a(d.a.e);
        }
      }
      
      public void b(String paramAnonymousString)
      {
        h.b("CdNLPManager", "nlp_response：" + paramAnonymousString);
        paramAnonymousString = (NLPResponseData)new Gson().fromJson(paramAnonymousString, NLPResponseData.class);
        if (paramAnonymousString != null)
        {
          h.b("CdNLPManager", "nlp_resultcode：" + paramAnonymousString.errno);
          parama.a(paramAnonymousString);
        }
      }
    }).a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    h.e("CdNLPManager", "type:" + paramString1 + ";data:" + paramString2);
    l.a().a("nlp.tool", paramString1, paramString2);
  }
  
  public static abstract interface a
  {
    public abstract void a(d.a parama);
    
    public abstract void a(NLPResponseData paramNLPResponseData);
  }
  
  private static class b
  {
    private static g a = new g();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/sdk/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */