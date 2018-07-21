package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.sdk.a.i.b;
import com.baidu.che.codriver.ui.a.f.a;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.ui.d.i.a;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class v
  extends a
{
  private static int i = 0;
  private String e;
  private String f;
  private List<com.baidu.che.codriver.e.a> g;
  private List<com.baidu.che.codriver.e.a> h;
  private i.b j = com.baidu.che.codriver.sdk.a.i.b().c();
  private f.a k = new f.a()
  {
    public void a(int paramAnonymousInt, com.baidu.che.codriver.e.a paramAnonymousa, i.a paramAnonymousa1)
    {
      v.this.c.d();
      if (paramAnonymousa1 == i.a.a)
      {
        paramAnonymousa1 = com.baidu.che.codriver.e.b.a().b(paramAnonymousa.a());
        if ((paramAnonymousa1 == null) || (paramAnonymousa1.isEmpty()))
        {
          paramAnonymousa = "无法根据" + paramAnonymousa.a() + "找到相应号码";
          com.baidu.che.codriver.ui.b.b.b().a(paramAnonymousa, 0);
          return;
        }
        if (paramAnonymousa1.size() == 1)
        {
          v.a(v.this, paramAnonymousa.b());
          v.a(v.this);
          return;
        }
        v.a(v.this, paramAnonymousa1);
        paramAnonymousa = new com.baidu.che.codriver.ui.d.i(String.format(v.this.d.getString(2131298391), new Object[] { paramAnonymousa.a(), Integer.valueOf(paramAnonymousa1.size()) }), paramAnonymousa1, i.a.b, 1);
        paramAnonymousa.a(v.b(v.this));
        com.baidu.che.codriver.ui.b.b.b().b(paramAnonymousa);
        return;
      }
      v.a(v.this, paramAnonymousa.b());
      v.a(v.this);
    }
  };
  
  public v(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
    com.baidu.che.codriver.util.c.a(this.d, "10003");
  }
  
  private void a()
  {
    String str = this.d.getString(2131298388, new Object[] { this.f });
    ArrayList localArrayList = new ArrayList();
    com.baidu.che.codriver.e.a locala = new com.baidu.che.codriver.e.a();
    locala.b(this.f);
    localArrayList.add(locala);
    this.c.a(new com.baidu.che.codriver.ui.d.i(str, localArrayList, i.a.c, 1));
    c.a().d(this);
  }
  
  private void a(String paramString)
  {
    paramString = com.baidu.che.codriver.e.b.a().a(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      int m = i + 1;
      i = m;
      if (m >= 2)
      {
        i = 0;
        this.c.a(new com.baidu.che.codriver.ui.d.i(this.d.getString(2131298394), "tts_record_not_find_anyone_close", 2, b.a.c));
        return;
      }
      this.c.a(new com.baidu.che.codriver.ui.d.i(this.d.getString(2131298395), "tts_record_not_find_anyone_retry", 1, b.a.c));
      return;
    }
    i = 0;
    this.g = paramString;
    if (paramString.size() == 1)
    {
      b(((com.baidu.che.codriver.e.a)paramString.get(0)).a());
      return;
    }
    c.a().b(this);
    paramString = new com.baidu.che.codriver.ui.d.i(this.d.getString(2131298390), this.g, i.a.a, 1);
    paramString.a(this.k);
    this.c.a(paramString);
    com.baidu.che.codriver.util.c.a(this.d, "10004", "进入多轮");
  }
  
  private void b()
  {
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.g = "您可以说打电话给10086或者打电话给小度";
    localb.j = 1;
    this.c.a(localb);
  }
  
  private void b(String paramString)
  {
    this.e = paramString;
    List localList = com.baidu.che.codriver.e.b.a().b(paramString);
    if ((localList == null) || (localList.isEmpty()))
    {
      Toast.makeText(this.d, "无法根据" + paramString + "找到相应号码", 0).show();
      this.c.a(null);
    }
    do
    {
      return;
      if (c.a().e()) {
        com.baidu.che.codriver.util.c.a(this.d, "10004", "澄清成功");
      }
      this.h = localList;
      if (localList.size() == 1)
      {
        this.f = ((com.baidu.che.codriver.e.a)localList.get(0)).b();
        a();
        return;
      }
    } while (localList.size() <= 1);
    com.baidu.che.codriver.util.c.a(this.d, "10004", "进入多轮");
    c.a().b(this);
    paramString = new com.baidu.che.codriver.ui.d.i(String.format(this.d.getString(2131298391), new Object[] { this.e, Integer.valueOf(localList.size()) }), this.h, i.a.b, 1);
    paramString.a(this.k);
    this.c.a(paramString);
  }
  
  private void r()
  {
    q();
    if (!com.baidu.che.codriver.sdk.a.i.b().a(1, this.c))
    {
      com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
      localb.j = 2;
      this.c.a(localb, new m.a()
      {
        public void a()
        {
          v.d(v.this).a(v.c(v.this));
        }
      }, null);
    }
  }
  
  public void a(a parama)
  {
    if ((parama == null) || (!"codriver".equals(parama.d())))
    {
      h.b("CoDriverVoice", "---不是电话需要的多轮命令，提示用户选择------");
      this.c.a(null);
      return;
    }
    if ("yes".equals(parama.e()))
    {
      if (!TextUtils.isEmpty(this.f))
      {
        r();
        return;
      }
      this.c.a(null);
      return;
    }
    if ("no".equals(parama.e()))
    {
      i();
      return;
    }
    try
    {
      parama = new JSONObject(parama.g());
      if ((this.h == null) || (this.h.isEmpty()))
      {
        b(((com.baidu.che.codriver.e.a)this.g.get(a(parama.optString("option"), this.g.size()))).a());
        return;
      }
    }
    catch (JSONException parama)
    {
      parama = new com.baidu.che.codriver.ui.d.b();
      parama.f = b.a.c;
      parama.i = 5;
      this.c.a(parama);
      return;
      this.f = ((com.baidu.che.codriver.e.a)this.h.get(a(parama.optString("option"), this.h.size()))).b();
      r();
      return;
    }
    catch (IndexOutOfBoundsException parama)
    {
      this.c.a(new com.baidu.che.codriver.ui.d.i(this.d.getString(2131298396), "tts_record_say_right_index", 1, b.a.c));
    }
  }
  
  public void h()
  {
    if (this.j == null)
    {
      localb = new com.baidu.che.codriver.ui.d.b();
      localb.g = "无法连接拨号工具";
      localb.j = 2;
      this.c.a(localb);
    }
    while (com.baidu.che.codriver.sdk.a.i.b().a(0, this.c))
    {
      com.baidu.che.codriver.ui.d.b localb;
      return;
    }
    if (!TextUtils.isEmpty(this.f))
    {
      a();
      return;
    }
    if (!TextUtils.isEmpty(this.e))
    {
      a(this.e);
      return;
    }
    b();
  }
  
  protected void i()
  {
    com.baidu.che.codriver.ui.d.b localb = new com.baidu.che.codriver.ui.d.b();
    localb.g = this.d.getString(2131297356);
    localb.j = 1;
    this.c.a(localb);
    q();
  }
  
  public void j()
  {
    if (this.b == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(g());
      this.e = localJSONObject.optString("name");
      this.f = localJSONObject.optString("number");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  protected JSONObject k()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("name", this.e);
      localJSONObject.putOpt("number", this.f);
      localJSONObject.putOpt("num", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */