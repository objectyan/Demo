package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.che.codriver.sdk.a.j;
import com.baidu.che.codriver.sdk.a.j.a;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.ui.d.b.a;
import com.baidu.che.codriver.util.c;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.a;
import com.baidu.che.codriver.vr.m.b;
import com.baidu.che.codriver.vr.p;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends a
{
  private static final String e = "[MusicModule] PlayerCommand";
  private String f;
  private String g;
  private j.a h = j.a().b();
  
  public w(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  private void a(String paramString)
  {
    h.b("CoDriverVoice", "setErrorFinish() " + paramString);
    b localb = new b();
    localb.j = 1;
    localb.g = paramString;
    localb.f = b.a.c;
    this.c.a(localb);
  }
  
  public void a(a parama) {}
  
  public void h()
  {
    h.b("[MusicModule] PlayerCommand", "------excute()------------");
    if (this.h == null)
    {
      a(this.d.getString(2131297665));
      return;
    }
    b localb = new b();
    localb.j = 2;
    if ("change".equals(e()))
    {
      this.c.a(localb, new m.a()
      {
        public void a()
        {
          w.a(w.this).g();
        }
      }, null);
      return;
    }
    if (!TextUtils.isEmpty(this.f))
    {
      h.b("[MusicModule] PlayerCommand", "handlePlayerDomain mActionType=" + this.f);
      if (this.f.equals("play"))
      {
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            w.a(w.this).b();
          }
        }, null);
        return;
      }
      if (this.f.equals("pause"))
      {
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            w.a(w.this).c();
          }
        }, null);
        return;
      }
      if (this.f.equals("exitplayer"))
      {
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            w.a(w.this).d();
          }
        }, null);
        return;
      }
      if (this.f.equals("previous"))
      {
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            w.a(w.this).e();
          }
        }, null);
        return;
      }
      if (this.f.equals("next"))
      {
        this.c.a(localb, new m.a()
        {
          public void a()
          {
            w.a(w.this).f();
          }
        }, null);
        return;
      }
      a(this.d.getString(2131297665));
      return;
    }
    if (!TextUtils.isEmpty(this.g))
    {
      h.b("[MusicModule] PlayerCommand", "handlePlayerDomain mMode=" + this.g);
      if (this.g.equals("single_loop"))
      {
        this.c.a(localb, null, new m.b()
        {
          public void a()
          {
            w.a(w.this).a(0);
          }
        });
        return;
      }
      if (this.g.equals("random"))
      {
        this.c.a(localb, null, new m.b()
        {
          public void a()
          {
            w.a(w.this).a(1);
          }
        });
        return;
      }
      if (this.g.equals("full_loop"))
      {
        this.c.a(localb, null, new m.b()
        {
          public void a()
          {
            w.a(w.this).a(2);
          }
        });
        return;
      }
      a(this.d.getString(2131297665));
      return;
    }
    a(this.d.getString(2131297665));
  }
  
  protected void i() {}
  
  protected void j()
  {
    c.a(this.d, "10010");
    try
    {
      JSONObject localJSONObject = new JSONObject(g());
      this.f = localJSONObject.optString("action_type");
      this.g = localJSONObject.optString("mode");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  protected JSONObject k()
  {
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */