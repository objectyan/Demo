package com.baidu.mapframework.nirvana.annotation.a;

import com.a.a.c;
import com.a.a.h.a;
import com.a.a.l;
import com.baidu.mapframework.nirvana.annotation.Header;
import com.baidu.mapframework.nirvana.annotation.HeaderMap;
import java.util.HashMap;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

class f
  extends h
{
  static final String b = "_headerParams";
  boolean a = false;
  
  f(a parama)
  {
    super(parama);
  }
  
  void a(h.a parama, Header paramHeader, HeaderMap paramHeaderMap, ExecutableElement paramExecutableElement, VariableElement paramVariableElement)
  {
    if (paramHeader != null)
    {
      this.f.a("Process @Header param ...");
      if (!this.a)
      {
        this.a = true;
        parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_headerParams", HashMap.class });
      }
      if (c.a(paramVariableElement.asType()).h())
      {
        paramHeaderMap = paramHeader.optional();
        if ((paramHeaderMap == null) || (paramHeaderMap.trim().isEmpty())) {
          parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + "+$S)", new Object[] { "_headerParams", paramHeader.value(), "" });
        }
      }
    }
    while (paramHeaderMap == null)
    {
      do
      {
        return;
        parama.d(paramHeaderMap, new Object[0]);
        parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + "+$S)", new Object[] { "_headerParams", paramHeader.value(), "" });
        parama.b();
        return;
        if (!paramVariableElement.asType().toString().equals(String.class.getCanonicalName())) {
          break;
        }
        paramHeaderMap = paramHeader.optional();
        if ((paramHeaderMap != null) && (!paramHeaderMap.trim().isEmpty())) {
          parama.d(paramHeaderMap, new Object[0]);
        }
        parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + ")", new Object[] { "_headerParams", paramHeader.value() });
      } while ((paramHeaderMap == null) || (paramHeaderMap.trim().isEmpty()));
      parama.b();
      return;
      this.f.a(paramVariableElement, "@%s parameter type must be java.lang.String or primitive", new Object[] { paramVariableElement.getSimpleName() });
      return;
    }
    if (paramVariableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.lang.String>"))
    {
      if (!this.a)
      {
        this.a = true;
        parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_headerParams", HashMap.class });
      }
      parama.d("if($L != null)", new Object[] { paramVariableElement.getSimpleName().toString() });
      parama.g("$L.putAll($L)", new Object[] { "_headerParams", paramVariableElement.getSimpleName().toString() });
      parama.b();
      return;
    }
    this.f.a(paramExecutableElement, "@%s parameter @%s annotation error, parameter should be java.util.HashMap<java.lang.String,java.lang.String>", new Object[] { paramExecutableElement.getSimpleName(), paramVariableElement.getSimpleName().toString() });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */