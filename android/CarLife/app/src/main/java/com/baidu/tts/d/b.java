package com.baidu.tts.d;

import com.baidu.tts.client.model.OnDownloadListener;
import com.baidu.tts.tools.StringTool;

public class b
{
  private String a;
  private OnDownloadListener b;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(OnDownloadListener paramOnDownloadListener)
  {
    this.b = paramOnDownloadListener;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean b()
  {
    return !StringTool.isEmpty(this.a);
  }
  
  public OnDownloadListener c()
  {
    return this.b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */