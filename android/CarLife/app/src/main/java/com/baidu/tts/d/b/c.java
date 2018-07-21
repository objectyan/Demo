package com.baidu.tts.d.b;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.a;
import com.baidu.tts.f.g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import java.util.Map;

public class c
{
  private String a;
  private Map<String, String> b;
  
  public c(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public String a()
  {
    return DataTool.getMapValue(this.b, g.h.b());
  }
  
  public void a(ModelFileBags paramModelFileBags, a parama)
  {
    parama.a(paramModelFileBags);
    a(parama);
  }
  
  public boolean a(a parama)
  {
    this.b = parama.d(this.a);
    if (DataTool.isMapEmpty(this.b)) {
      return false;
    }
    String str = (String)this.b.get(g.h.b());
    if (StringTool.isEmpty(str))
    {
      parama.b(this.a);
      return false;
    }
    e.a().c(str).c(this.a);
    return true;
  }
  
  public String b()
  {
    return DataTool.getMapValue(this.b, g.g.b());
  }
  
  public String c()
  {
    return DataTool.getMapValue(this.b, g.f.b());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */