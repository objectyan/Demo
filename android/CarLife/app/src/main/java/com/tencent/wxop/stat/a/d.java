package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.s;
import com.tencent.wxop.stat.k;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public class d
  extends e
{
  private String a;
  private int m;
  private int n = 100;
  private Thread o = null;
  
  public d(Context paramContext, int paramInt1, int paramInt2, Throwable paramThrowable, k paramk)
  {
    super(paramContext, paramInt1, paramk);
    a(paramInt2, paramThrowable);
  }
  
  public d(Context paramContext, int paramInt1, int paramInt2, Throwable paramThrowable, Thread paramThread, k paramk)
  {
    super(paramContext, paramInt1, paramk);
    a(paramInt2, paramThrowable);
    this.o = paramThread;
  }
  
  public d(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Thread paramThread, k paramk)
  {
    super(paramContext, paramInt1, paramk);
    if (paramString != null)
    {
      paramInt1 = paramInt3;
      if (paramInt3 <= 0) {
        paramInt1 = com.tencent.wxop.stat.f.x();
      }
      if (paramString.length() > paramInt1) {
        break label61;
      }
    }
    label61:
    for (this.a = paramString;; this.a = paramString.substring(0, paramInt1))
    {
      this.o = paramThread;
      this.m = paramInt2;
      return;
    }
  }
  
  private void a(int paramInt, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      this.a = localStringWriter.toString();
      this.m = paramInt;
      localPrintWriter.close();
    }
  }
  
  public f a()
  {
    return f.c;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    s.a(paramJSONObject, "er", this.a);
    paramJSONObject.put("ea", this.m);
    if ((this.m == 2) || (this.m == 3)) {
      new com.tencent.wxop.stat.b.d(this.l).a(paramJSONObject, this.o);
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */