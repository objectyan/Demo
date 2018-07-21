package com.baidu.che.codriver.vr.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.che.codriver.ui.d.b;
import com.baidu.che.codriver.util.h;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.m.b;
import com.baidu.che.codriver.vr.p;
import org.json.JSONException;
import org.json.JSONObject;

public class ae
  extends a
{
  private String e;
  private boolean f = false;
  
  public ae(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  private void a()
  {
    if (this.f)
    {
      if ((TextUtils.isEmpty(this.e)) || (this.e.length() < 2))
      {
        localObject = new b();
        ((b)localObject).g = "这个名字太短啦，换个长一点的吧！";
        this.c.a((b)localObject);
        return;
      }
      if (this.e.length() > 6)
      {
        localObject = new b();
        ((b)localObject).g = "这个名字太长啦，换个短一点的吧！";
        this.c.a((b)localObject);
        return;
      }
      h.b("WakeUpCommand", "mWakeupWord=" + this.e + " length=" + this.e.length());
      localObject = this.e + "你好,你好" + this.e;
      b localb = new b();
      String str = this.e + "你好，你好" + this.e;
      localb.g = ("您可以说" + str + "，来唤醒我啦！");
      this.c.a(localb, null, new m.b()
      {
        public void a()
        {
          com.baidu.che.codriver.sdk.a.a.a().a(localObject, true);
        }
      });
      return;
    }
    final Object localObject = new b();
    ((b)localObject).g = this.d.getString(2131298679);
    this.c.a((b)localObject);
  }
  
  public void h()
  {
    if (e().equals("addWakeUpWord")) {
      a();
    }
    while (!e().equals("wakeup")) {
      return;
    }
  }
  
  protected void j()
  {
    try
    {
      this.e = new JSONObject(g()).optString("name");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */