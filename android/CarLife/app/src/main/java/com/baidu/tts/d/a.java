package com.baidu.tts.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a
{
  private boolean a = false;
  private Map<String, Integer> b = new HashMap();
  
  public void a(String paramString, int paramInt)
  {
    this.b.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() != 7) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */