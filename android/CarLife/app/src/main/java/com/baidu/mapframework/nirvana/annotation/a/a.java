package com.baidu.mapframework.nirvana.annotation.a;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic.Kind;

class a
{
  protected Messager a;
  protected Filer b;
  
  protected a(Messager paramMessager, Filer paramFiler)
  {
    this.a = paramMessager;
    this.b = paramFiler;
  }
  
  protected void a(String paramString)
  {
    this.a.printMessage(Diagnostic.Kind.NOTE, paramString);
  }
  
  protected void a(Element paramElement, String paramString, Object... paramVarArgs)
  {
    this.a.printMessage(Diagnostic.Kind.ERROR, String.format(paramString, paramVarArgs), paramElement);
    throw new RuntimeException(String.format(paramString, paramVarArgs));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */