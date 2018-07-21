package com.baidu.che.codriver.util;

import com.baidu.che.codriver.vr.o;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class m
{
  private static final String a = "SwitcherManager";
  private static final String b = "nlpswitch";
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private Map<String, Integer> f = new HashMap();
  
  public static m a()
  {
    return a.a();
  }
  
  private void a(JsonObject paramJsonObject)
  {
    try
    {
      paramJsonObject = paramJsonObject.getAsJsonArray("switch");
      int i = 0;
      while (i < paramJsonObject.size())
      {
        JsonObject localJsonObject = paramJsonObject.get(i).getAsJsonObject();
        this.f.put(localJsonObject.get("func").getAsString(), Integer.valueOf(localJsonObject.get("status").getAsInt()));
        i += 1;
      }
      return;
    }
    catch (Exception paramJsonObject)
    {
      paramJsonObject.printStackTrace();
    }
  }
  
  private void d()
  {
    if ((this.f.get("nlpswitch") != null) && (((Integer)this.f.get("nlpswitch")).intValue() == 0))
    {
      a(false);
      return;
    }
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    h.b("SwitcherManager", "setUseNlu useNlu=" + paramBoolean);
    if (paramBoolean != this.e)
    {
      this.e = paramBoolean;
      o.a().b(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c() {}
  
  private static class a
  {
    private static m a = new m();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */