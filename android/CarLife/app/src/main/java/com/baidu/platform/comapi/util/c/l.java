package com.baidu.platform.comapi.util.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.platform.comapi.c;
import java.io.File;

public class l
  implements g
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public String a()
  {
    if (TextUtils.isEmpty(this.a)) {
      a(c.f());
    }
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext.getFilesDir().getAbsolutePath();
    this.d = paramContext.getCacheDir().getAbsolutePath();
    this.e = this.d;
    this.b = Environment.getExternalStorageDirectory().getPath();
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/util/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */