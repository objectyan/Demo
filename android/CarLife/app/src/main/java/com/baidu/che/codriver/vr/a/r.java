package com.baidu.che.codriver.vr.a;

import android.content.Context;
import com.baidu.che.codriver.vr.m;
import com.baidu.che.codriver.vr.o;
import com.baidu.che.codriver.vr.p;
import org.json.JSONException;
import org.json.JSONObject;

public class r
  extends a
{
  private String e;
  
  public r(p paramp, m paramm, Context paramContext)
  {
    super(paramp, paramm, paramContext);
  }
  
  public void h()
  {
    o.a().a(this.e);
  }
  
  protected void j()
  {
    try
    {
      this.e = new JSONObject(g()).optString("words");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/vr/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */