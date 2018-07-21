package com.baidu.carlife.radio.b;

import com.baidu.carlife.core.i;
import com.baidu.carlife.radio.b.a.a;
import com.baidu.carlife.radio.b.a.c;
import java.util.Map;
import org.json.JSONObject;

public class aa
  extends a
{
  private a c;
  
  public String a()
  {
    return c.l();
  }
  
  public void a(int paramInt, String paramString)
  {
    i.c("radio_request", "statusCode = " + paramInt + "; response=" + paramString);
    if (paramInt != 200) {
      if (this.c != null) {
        this.c.a("statusCode=" + paramInt);
      }
    }
    label175:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramString = new JSONObject(paramString);
            if (paramString.getInt("errno") == 0) {
              break label175;
            }
            if (this.c != null)
            {
              this.c.a("errmsg=" + paramString.getString("errmsg"));
              return;
            }
          }
          catch (Exception paramString) {}
        }
      } while (this.c == null);
      this.c.a("exception=" + paramString.toString());
      return;
    } while (this.c == null);
    this.c.a(paramString.getInt("count"));
  }
  
  public void a(a parama)
  {
    this.c = parama;
    c();
  }
  
  public void a(String paramString1, String paramString2)
  {
    i.e("radio_request", "error = " + paramString2);
    if (this.c != null) {
      this.c.a(paramString2);
    }
  }
  
  public void a(Map<String, String> paramMap) {}
  
  public Map<String, String> b()
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/radio/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */