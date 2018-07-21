package com.baidu.mapframework.nirvana.annotation.a;

import com.a.a.c;
import com.a.a.h.a;
import com.a.a.l;
import com.baidu.mapframework.nirvana.annotation.PostMap;
import com.baidu.mapframework.nirvana.annotation.PostParam;
import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

class i
  extends h
{
  static final String i = "_postParams";
  static final String j = "_fileParams";
  static final String k = "_inputStreams";
  boolean a = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  c e = c.c("com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils");
  c g = c.c("com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType");
  c h = c.c("com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType");
  
  public i(a parama)
  {
    super(parama);
  }
  
  void a(h.a parama, PostParam paramPostParam, PostMap paramPostMap, com.baidu.mapframework.nirvana.annotation.InputStream paramInputStream, UrlEncode.UrlEncodeType paramUrlEncodeType, SignToken.SignTokenType paramSignTokenType, ExecutableElement paramExecutableElement, VariableElement paramVariableElement)
  {
    if (paramPostMap != null) {
      if (paramVariableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.lang.String>"))
      {
        if (!this.a)
        {
          this.a = true;
          parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_postParams", HashMap.class });
        }
        parama.d("if($L != null)", new Object[] { paramVariableElement.getSimpleName().toString() });
        if ((paramUrlEncodeType != null) && (paramUrlEncodeType != UrlEncode.UrlEncodeType.NONE))
        {
          parama.g("$T<$T> $L = $L.keySet()", new Object[] { Set.class, String.class, "keys", paramVariableElement.getSimpleName().toString() });
          parama.d("for($T $L : $L)", new Object[] { String.class, "_key", "keys" });
          parama.g("$L.put(_key, $T.urlEncode($T.$L, $L.get(_key)))", new Object[] { "_postParams", this.e, this.g, paramUrlEncodeType, paramVariableElement.getSimpleName().toString() });
          parama.b();
          parama.b();
        }
      }
    }
    label874:
    label1052:
    label1078:
    do
    {
      do
      {
        for (;;)
        {
          return;
          parama.g("$L.putAll($L)", new Object[] { "_postParams", paramVariableElement.getSimpleName().toString() });
          break;
          if (paramVariableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.io.File>"))
          {
            if (!this.b)
            {
              this.b = true;
              parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, File.class, "_fileParams", HashMap.class });
            }
            parama.d("if($L != null)", new Object[] { paramVariableElement.getSimpleName().toString() });
            parama.g("$L.putAll($L)", new Object[] { "_fileParams", paramVariableElement.getSimpleName().toString() });
            parama.b();
            return;
          }
          this.f.a(paramExecutableElement, "@%s parameter @%s annotation error, parameter should be java.util.HashMap<java.lang.String,java.lang.String> or java.util.HashMap<java.lang.String,java.io.File>", new Object[] { paramExecutableElement.getSimpleName(), paramVariableElement.getSimpleName().toString() });
          return;
          if (paramPostParam == null) {
            break label1078;
          }
          k.b(paramPostParam.value(), paramSignTokenType);
          if (c.a(paramVariableElement.asType()).h())
          {
            if (!this.a)
            {
              this.a = true;
              parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_postParams", HashMap.class });
            }
            paramPostMap = paramPostParam.optional();
            if ((paramPostMap != null) && (paramPostMap.trim().isEmpty())) {
              parama.d(paramPostMap, new Object[0]);
            }
            parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + "+$S)", new Object[] { "_postParams", paramPostParam.value(), "" });
            if ((paramPostMap != null) && (!paramPostMap.trim().isEmpty())) {
              parama.b();
            }
          }
          else
          {
            if (!paramVariableElement.asType().toString().equals(String.class.getCanonicalName())) {
              break label874;
            }
            if (!this.a)
            {
              this.a = true;
              parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_postParams", HashMap.class });
            }
            paramPostMap = paramPostParam.optional();
            if ((paramPostMap != null) && (!paramPostMap.trim().isEmpty())) {
              parama.d(paramPostMap, new Object[0]);
            }
            if ((paramUrlEncodeType != null) && (paramUrlEncodeType != UrlEncode.UrlEncodeType.NONE)) {
              parama.g("$L.put($S, $T.urlEncode($T.$L, $L))", new Object[] { "_postParams", paramPostParam.value(), this.e, this.g, paramUrlEncodeType, paramVariableElement.getSimpleName().toString() });
            }
            while ((paramPostMap != null) && (!paramPostMap.trim().isEmpty()))
            {
              parama.b();
              return;
              parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + ")", new Object[] { "_postParams", paramPostParam.value() });
            }
          }
        }
        if (!paramVariableElement.asType().toString().equals(File.class.getCanonicalName())) {
          break label1052;
        }
        if (!this.b)
        {
          this.b = true;
          parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, File.class, "_fileParams", HashMap.class });
        }
        paramPostMap = paramPostParam.optional();
        if ((paramPostMap != null) && (!paramPostMap.trim().isEmpty())) {
          parama.d(paramPostMap, new Object[0]);
        }
        parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + ")", new Object[] { "_fileParams", paramPostParam.value() });
      } while ((paramPostMap == null) || (paramPostMap.trim().isEmpty()));
      parama.b();
      return;
      this.f.a(paramVariableElement, "@%s parameter type must be java.lang.String or primitive", new Object[] { paramVariableElement.getSimpleName() });
      return;
    } while ((paramInputStream == null) || (!paramVariableElement.asType().toString().equals(java.io.InputStream.class.getCanonicalName())));
    if (!this.c)
    {
      this.c = true;
      parama.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, java.io.InputStream.class, "_inputStreams", HashMap.class });
    }
    parama.g("$L.put($S, " + paramVariableElement.getSimpleName().toString() + ")", new Object[] { "_inputStreams", paramInputStream.value() });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */