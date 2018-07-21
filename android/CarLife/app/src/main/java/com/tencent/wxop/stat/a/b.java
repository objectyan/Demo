package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.j;
import com.tencent.wxop.stat.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends e
{
  protected c a = new c();
  private long m = -1L;
  
  public b(Context paramContext, int paramInt, String paramString, k paramk)
  {
    super(paramContext, paramInt, paramk);
    this.a.a = paramString;
  }
  
  private void h()
  {
    Object localObject;
    if (this.a.a != null)
    {
      localObject = j.b(this.a.a);
      if ((localObject != null) && (((Properties)localObject).size() > 0))
      {
        if ((this.a.c != null) && (this.a.c.length() != 0)) {
          break label71;
        }
        this.a.c = new JSONObject((Map)localObject);
      }
    }
    for (;;)
    {
      return;
      label71:
      localObject = ((Properties)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        try
        {
          this.a.c.put(localEntry.getKey().toString(), localEntry.getValue());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public f a()
  {
    return f.d;
  }
  
  public void a(long paramLong)
  {
    this.m = paramLong;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ei", this.a.a);
    if (this.m > 0L) {
      paramJSONObject.put("du", this.m);
    }
    if (this.a.b == null)
    {
      h();
      paramJSONObject.put("kv", this.a.c);
    }
    for (;;)
    {
      return true;
      paramJSONObject.put("ar", this.a.b);
    }
  }
  
  public c b()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */