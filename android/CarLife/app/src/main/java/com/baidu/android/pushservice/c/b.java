package com.baidu.android.pushservice.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;

public class b
{
  protected Context a;
  protected String b;
  protected String c;
  
  protected b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    if (new File(this.c).exists()) {}
    for (Object localObject = a.a(this.c);; localObject = a.a())
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        localObject = com.baidu.android.pushservice.k.b.a(((String)localObject).getBytes());
        if ((localObject != null) && (localObject.length > 0)) {
          this.b = new String(BaiduAppSSOJni.decryptAES((byte[])localObject, localObject.length, 0));
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;) {}
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      if (!TextUtils.isEmpty(this.b)) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    return a.a(this.c, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */