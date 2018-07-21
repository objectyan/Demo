package com.baidu.mapframework.nirvana.assets;

import android.content.Context;
import com.baidu.mapframework.nirvana.g;
import java.io.InputStream;

public class AssetsTask
  extends g
{
  private final String a;
  private final Context b;
  private int c = 2;
  private InputStream d;
  
  public AssetsTask(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.a = paramString;
  }
  
  String a()
  {
    return this.a;
  }
  
  protected void a(InputStream paramInputStream)
  {
    this.d = paramInputStream;
  }
  
  int b()
  {
    return this.c;
  }
  
  Context c()
  {
    return this.b;
  }
  
  public InputStream getInputStream()
  {
    return this.d;
  }
  
  public void setAccessMode(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/assets/AssetsTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */