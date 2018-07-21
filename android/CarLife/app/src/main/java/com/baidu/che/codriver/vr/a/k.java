package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.che.codriver.sdk.a.f.a;
import com.baidu.che.codriver.sdk.a.f.a.a;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.p;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends a
  implements f.a.a
{
  private static final String e = "[MusicModule] MusicCommand";
  private String f;
  private String g;
  private String h;
  private String i;
  private List<com.baidu.che.codriver.c.a> j;
  private f.a k = com.baidu.che.codriver.sdk.a.f.a().b();
  
  public k(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  private void a(final List<com.baidu.che.codriver.c.a> paramList, final int paramInt)
  {
    c.a().d();
    b localb = new b();
    localb.j = 2;
    this.c.a(localb, new m.a()
    {
      public void a()
      {
        k.a(k.this).a(paramList, paramInt);
      }
    }, null);
  }
  
  private void b(String paramString)
  {
    b localb = new b();
    localb.j = 1;
    localb.g = paramString;
    localb.f = b.a.c;
    this.c.a(localb);
  }
  
  private void b(List<com.baidu.che.codriver.c.a> paramList)
  {
    if (c(paramList))
    {
      a(paramList, 0);
      return;
    }
    c.a().b(this);
    com.baidu.che.codriver.ui.d.f localf = new com.baidu.che.codriver.ui.d.f(paramList);
    localf.g = this.d.getString(2131297664, new Object[] { Integer.valueOf(paramList.size()) });
    localf.j = 1;
    this.c.a(localf);
  }
  
  private boolean c(List<com.baidu.che.codriver.c.a> paramList)
  {
    return (paramList.size() == 1) || (f().contains(this.d.getString(2131296597)));
  }
  
  public void a(a parama)
  {
    if ((parama == null) || (!b(parama)))
    {
      h.b("[MusicModule] MusicCommand", "---不是多轮命令，提示用户选择------");
      this.c.a(null);
      return;
    }
    int m;
    try
    {
      parama = new JSONObject(parama.g());
      h.b("[MusicModule] MusicCommand", "---多轮命令---" + parama.toString());
      m = a(parama.optString("option"), this.j.size());
      h.b("MusicCommand", "---多轮命令---selectIndex:" + m);
      if ((this.j == null) || (m >= this.j.size()) || (m < 0))
      {
        parama = new b();
        parama.f = b.a.c;
        parama.j = 1;
        parama.g = this.d.getString(2131298396);
        parama.h = "tts_record_say_right_index";
        this.c.a(parama);
        return;
      }
    }
    catch (JSONException parama)
    {
      parama = new b();
      parama.f = b.a.c;
      parama.i = 5;
      this.c.a(parama);
      return;
    }
    a(this.j, m);
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(List<com.baidu.che.codriver.c.a> paramList)
  {
    this.j = paramList;
    b(this.j);
  }
  
  public void h()
  {
    h.b("[MusicModule] MusicCommand", "------excute()------------");
    if (this.k == null) {
      b(this.d.getString(2131297665));
    }
    if ((this.j != null) && (this.j.size() > 0))
    {
      b(this.j);
      return;
    }
    this.k.a(this.g, this.f, this.h, this.i, this);
  }
  
  protected void i() {}
  
  protected void j()
  {
    com.baidu.che.codriver.util.c.a(this.d, "10009");
    try
    {
      JSONObject localJSONObject = new JSONObject(g());
      this.f = localJSONObject.optString("name");
      this.i = localJSONObject.optString("type");
      Object localObject = localJSONObject.optJSONArray("byartist");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        this.g = ((JSONArray)localObject).getString(0);
      }
      localObject = localJSONObject.optJSONArray("tag");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        this.h = ((JSONArray)localObject).getString(0);
      }
      localObject = localJSONObject.optString("music");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.j = Arrays.asList((com.baidu.che.codriver.c.a[])new Gson().fromJson((String)localObject, com.baidu.che.codriver.c.a[].class));
        if (this.j != null)
        {
          localObject = this.j.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((com.baidu.che.codriver.c.a)((Iterator)localObject).next()).l = 2;
          }
        }
      }
      h.b("[MusicModule] MusicCommand", "---语音指令：-----" + localJSONException.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
  }
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */