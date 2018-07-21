package com.baidu.mapframework.nirvana.annotation.a;

import com.a.a.c;
import com.a.a.h.a;
import com.a.a.l;
import com.baidu.mapframework.nirvana.annotation.GetMap;
import com.baidu.mapframework.nirvana.annotation.GetParam;
import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import java.util.HashMap;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

class e
  extends h
{
  static final String e = "_urlParams";
  boolean a = false;
  c b = c.c("com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils");
  c c = c.c("com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType");
  c d = c.c("com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType");
  
  public e(a parama)
  {
    super(parama);
  }
  
  void a(h.a parama, GetParam paramGetParam, GetMap paramGetMap, UrlEncode.UrlEncodeType paramUrlEncodeType, SignToken.SignTokenType paramSignTokenType, ExecutableElement paramExecutableElement, VariableElement paramVariableElement)
  {
    if (paramGetMap != null) {
      if (paramVariableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.lang.String>"))
      {
        if (!this.a)
        {
          this.a = true;
          parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_urlParams", HashMap.class });
        }
        parama.d("if($L != null)", new Object[] { paramVariableElement.getSimpleName().toString() });
        if ((paramUrlEncodeType != null) && (paramUrlEncodeType != UrlEncode.UrlEncodeType.NONE))
        {
          parama.g("$T<$T> $L = $L.keySet()", new Object[] { Set.class, String.class, "keys", paramVariableElement.getSimpleName().toString() });
          parama.d("for($T $L : $L)", new Object[] { String.class, "key", "keys" });
          parama.g("$L.put(key, $T.urlEncode($T.$L, $L.get(key)))", new Object[] { "_urlParams", this.b, this.c, paramUrlEncodeType, paramVariableElement.getSimpleName().toString() });
          parama.b();
          parama.b();
        }
      }
    }
    for (;;)
    {
      return;
      parama.g("$L.putAll($L)", new Object[] { "_urlParams", paramVariableElement.getSimpleName().toString() });
      break;
      this.f.a(paramExecutableElement, "@%s parameter @%s annotation error, parameter should be java.util.HashMap<java.lang.String,java.lang.String>", new Object[] { paramExecutableElement.getSimpleName(), paramVariableElement.getSimpleName().toString() });
      return;
      if (paramGetParam != null)
      {
        k.a(paramGetParam.value(), paramSignTokenType);
        if (!this.a)
        {
          this.a = true;
          parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_urlParams", HashMap.class });
        }
        if (c.a(paramVariableElement.asType()).h())
        {
          paramGetMap = paramGetParam.optional();
          if ((paramGetMap == null) || (paramGetMap.trim().isEmpty()))
          {
            parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + "+$S)", new Object[] { "_urlParams", paramGetParam.value(), "" });
            return;
          }
          parama.d(paramGetMap, new Object[0]);
          parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + "+$S)", new Object[] { "_urlParams", paramGetParam.value(), "" });
          parama.b();
          return;
        }
        if (!paramVariableElement.asType().toString().equals(String.class.getCanonicalName())) {
          break label752;
        }
        paramGetMap = paramGetParam.optional();
        if ((paramGetMap != null) && (!paramGetMap.trim().isEmpty())) {
          parama.d(paramGetMap, new Object[0]);
        }
        if ((paramUrlEncodeType != null) && (paramUrlEncodeType != UrlEncode.UrlEncodeType.NONE)) {
          parama.g("$L.put($S, $T.urlEncode($T.$L, $L))", new Object[] { "_urlParams", paramGetParam.value(), this.b, this.c, paramUrlEncodeType, paramVariableElement.getSimpleName().toString() });
        }
        while ((paramGetMap != null) && (!paramGetMap.trim().isEmpty()))
        {
          parama.f(paramGetMap, new Object[0]);
          return;
          parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + ")", new Object[] { "_urlParams", paramGetParam.value() });
        }
      }
    }
    label752:
    this.f.a(paramVariableElement, "@%s parameter type must be java.lang.String or primitive", new Object[] { paramVariableElement.getSimpleName() });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */