package com.baidu.mapframework.nirvana.annotation.a;

import com.a.a.h.a;
import com.baidu.mapframework.nirvana.annotation.CookieStore;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

public class d
  extends h
{
  String a = null;
  
  d(a parama)
  {
    super(parama);
  }
  
  void a(h.a parama, CookieStore paramCookieStore, ExecutableElement paramExecutableElement, VariableElement paramVariableElement)
  {
    if (paramCookieStore != null) {
      this.a = paramVariableElement.getSimpleName().toString();
    }
    if ((this.a != null) && (!this.a.isEmpty())) {
      parama.g("mRetrofit.build().$L($L)", new Object[] { "setCookieStore", this.a });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */