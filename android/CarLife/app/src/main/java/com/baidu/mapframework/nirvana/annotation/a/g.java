package com.baidu.mapframework.nirvana.annotation.a;

import com.a.a.f.a;
import com.a.a.g.a;
import com.a.a.h;
import com.a.a.h.a;
import com.a.a.l;
import com.a.a.m;
import com.a.a.m.a;
import com.baidu.mapframework.nirvana.annotation.AppendPhoneInfo;
import com.baidu.mapframework.nirvana.annotation.CookieStore;
import com.baidu.mapframework.nirvana.annotation.DELETE;
import com.baidu.mapframework.nirvana.annotation.GET;
import com.baidu.mapframework.nirvana.annotation.GetMap;
import com.baidu.mapframework.nirvana.annotation.GetParam;
import com.baidu.mapframework.nirvana.annotation.Header;
import com.baidu.mapframework.nirvana.annotation.HeaderMap;
import com.baidu.mapframework.nirvana.annotation.InputStream;
import com.baidu.mapframework.nirvana.annotation.POST;
import com.baidu.mapframework.nirvana.annotation.PUT;
import com.baidu.mapframework.nirvana.annotation.PostMap;
import com.baidu.mapframework.nirvana.annotation.PostParam;
import com.baidu.mapframework.nirvana.annotation.RegisterRequest;
import com.baidu.mapframework.nirvana.annotation.RequestBody;
import com.baidu.mapframework.nirvana.annotation.SignToken;
import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.mapframework.nirvana.annotation.Sync;
import com.baidu.mapframework.nirvana.annotation.Url;
import com.baidu.mapframework.nirvana.annotation.UrlEncode;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

class g
  extends a
{
  private Element c;
  private com.a.a.c d = com.a.a.c.c("android.support.annotation.Keep");
  private com.a.a.c e = com.a.a.c.c("com.baidu.mapframework.nirvana.runtime.http.BMRetrofit");
  
  public g(Element paramElement, Messager paramMessager, Filer paramFiler)
  {
    super(paramMessager, paramFiler);
    this.c = paramElement;
  }
  
  private void a(m.a parama)
  {
    com.a.a.c localc = this.e;
    parama.a(com.a.a.f.a(localc, "mRetrofit", new Modifier[0]).a(new Modifier[] { Modifier.PRIVATE }).a());
    Object localObject = (RegisterRequest)this.c.getAnnotation(RegisterRequest.class);
    h.a locala = h.b().a(new Modifier[] { Modifier.PRIVATE });
    String str;
    if (((RegisterRequest)localObject).timeOut() == 10000)
    {
      str = "";
      if ((((RegisterRequest)localObject).cookiePolicy() != null) && (!((RegisterRequest)localObject).cookiePolicy().isEmpty())) {
        break label176;
      }
    }
    label176:
    for (localObject = "";; localObject = ".setCookiePolicy(\"" + ((RegisterRequest)localObject).cookiePolicy() + "\")")
    {
      parama.a(locala.g("mRetrofit = new $T()$L$L", new Object[] { localc, str, localObject }).c());
      return;
      str = ".setTimeout(" + ((RegisterRequest)localObject).timeOut() + ")";
      break;
    }
  }
  
  private void a(m.a parama, l paraml, String paramString)
  {
    paramString = com.a.a.f.a(paraml, "INSTANCE", new Modifier[0]).a(new Modifier[] { Modifier.STATIC, Modifier.FINAL }).b("new " + paramString + "()", new Object[0]).a();
    parama.a(m.a("HOLDER").a(new Modifier[] { Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL }).a(paramString).a());
    parama.a(h.a("getInstance").a(new Modifier[] { Modifier.PUBLIC, Modifier.STATIC }).a(paraml).g("return HOLDER.INSTANCE", new Object[0]).c());
  }
  
  private void a(m.a parama, Element paramElement)
  {
    h.a locala = h.a(paramElement.getSimpleName().toString()).a(new Modifier[] { Modifier.PUBLIC }).a(Void.TYPE);
    ExecutableElement localExecutableElement = (ExecutableElement)paramElement;
    Object localObject3 = localExecutableElement.getParameters();
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str1 = null;
    Object localObject1 = new f(this);
    e locale = new e(this);
    Object localObject2 = new i(this);
    d locald = new d(this);
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      VariableElement localVariableElement = (VariableElement)((Iterator)localObject3).next();
      locala.a("@param $L\n", new Object[] { localVariableElement.getSimpleName().toString() });
      locala.a(com.a.a.c.a(localVariableElement.asType()), localVariableElement.getSimpleName().toString(), new Modifier[0]);
      a(c.h, localExecutableElement, localVariableElement);
      GetParam localGetParam = (GetParam)localVariableElement.getAnnotation(GetParam.class);
      PostParam localPostParam = (PostParam)localVariableElement.getAnnotation(PostParam.class);
      GetMap localGetMap = (GetMap)localVariableElement.getAnnotation(GetMap.class);
      PostMap localPostMap = (PostMap)localVariableElement.getAnnotation(PostMap.class);
      Sync localSync = (Sync)localVariableElement.getAnnotation(Sync.class);
      Url localUrl = (Url)localVariableElement.getAnnotation(Url.class);
      Header localHeader = (Header)localVariableElement.getAnnotation(Header.class);
      RequestBody localRequestBody = (RequestBody)localVariableElement.getAnnotation(RequestBody.class);
      HeaderMap localHeaderMap = (HeaderMap)localVariableElement.getAnnotation(HeaderMap.class);
      InputStream localInputStream = (InputStream)localVariableElement.getAnnotation(InputStream.class);
      CookieStore localCookieStore = (CookieStore)localVariableElement.getAnnotation(CookieStore.class);
      if (localSync != null)
      {
        if ((!localVariableElement.asType().toString().equals("boolean")) || (str4 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be boolean", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str4 = localVariableElement.getSimpleName().toString();
      }
      else if (localUrl != null)
      {
        if ((!localVariableElement.asType().toString().equals(String.class.getCanonicalName())) || (str2 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be String", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str2 = localVariableElement.getSimpleName().toString();
      }
      else if ((localHeader != null) || (localHeaderMap != null))
      {
        ((f)localObject1).a(locala, localHeader, localHeaderMap, localExecutableElement, localVariableElement);
      }
      else if ((localGetParam != null) || (localGetMap != null))
      {
        locale.a(locala, localGetParam, localGetMap, null, null, localExecutableElement, localVariableElement);
      }
      else if ((localPostMap != null) || (localPostParam != null) || (localInputStream != null))
      {
        ((i)localObject2).a(locala, localPostParam, localPostMap, localInputStream, null, null, localExecutableElement, localVariableElement);
      }
      else if (localRequestBody != null)
      {
        ((i)localObject2).d = true;
        if (localVariableElement.asType().toString().equals("org.apache.http.HttpEntity")) {
          str1 = localVariableElement.getSimpleName().toString();
        } else {
          a(localExecutableElement, "@RequestBody param's type is not org.apache.http.HttpEntity !", new Object[0]);
        }
      }
      else if (localCookieStore != null)
      {
        if (!localVariableElement.asType().toString().equals("org.apache.http.client.CookieStore")) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be org.apache.http.client.CookieStore", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        locald.a(locala, localCookieStore, localExecutableElement, localVariableElement);
      }
      else if (!com.a.a.c.a(localVariableElement.asType()).h())
      {
        if (!b(localVariableElement.asType().toString())) {
          a(localVariableElement, "%s parameter type is not support _____ %s", new Object[] { localVariableElement.getSimpleName(), localVariableElement.asType().toString() });
        }
        if (str3 == null) {
          str3 = localVariableElement.getSimpleName().toString();
        } else {
          a(localVariableElement, "you can have only one CallBack int the @%s method", new Object[] { paramElement.getSimpleName() });
        }
      }
    }
    if (str2 == null) {
      a(localExecutableElement, "@Url not find, please annotation url with @Url", new Object[0]);
    }
    if (((i)localObject2).d)
    {
      if (str4 == null)
      {
        paramElement = "false,";
        if (!((f)localObject1).a) {
          break label1014;
        }
        str4 = "_headerParams";
        label927:
        if (!((i)localObject2).d) {
          break label1022;
        }
      }
      for (;;)
      {
        locala.g("mRetrofit.build().$L($L$L, $L, $L, $L)", new Object[] { "putRequest", paramElement, str2, str4, str1, str3 });
        parama.a(locala.c());
        return;
        paramElement = str4 + ", ";
        break;
        label1014:
        str4 = "null";
        break label927;
        label1022:
        str1 = "null";
      }
    }
    if (str4 == null)
    {
      paramElement = "false,";
      label1038:
      if (!((f)localObject1).a) {
        break label1172;
      }
      str1 = "_headerParams";
      label1050:
      if (!((i)localObject2).a) {
        break label1179;
      }
      str4 = "_postParams";
      label1063:
      if (!((i)localObject2).b) {
        break label1187;
      }
      localObject1 = "_fileParams";
      label1076:
      if (!((i)localObject2).c) {
        break label1195;
      }
    }
    label1172:
    label1179:
    label1187:
    label1195:
    for (localObject2 = "_inputStreams";; localObject2 = "null")
    {
      locala.g("mRetrofit.build().$L($L$L, $L, $L, $L, $L, $L)", new Object[] { "putRequest", paramElement, str2, str1, str4, localObject1, localObject2, str3 });
      break;
      paramElement = str4 + ", ";
      break label1038;
      str1 = "null";
      break label1050;
      str4 = "null";
      break label1063;
      localObject1 = "null";
      break label1076;
    }
  }
  
  private void a(m.a parama, Element paramElement, boolean paramBoolean, UrlEncode.UrlEncodeType paramUrlEncodeType, SignToken.SignTokenType paramSignTokenType)
  {
    h.a locala = h.a(paramElement.getSimpleName().toString()).a(new Modifier[] { Modifier.PUBLIC }).a(Void.TYPE);
    locala.a("$L\n", new Object[] { paramElement.getSimpleName() });
    ExecutableElement localExecutableElement = (ExecutableElement)paramElement;
    Object localObject = localExecutableElement.getParameters();
    String str2 = null;
    String str3 = null;
    String str1 = null;
    com.a.a.c localc1 = com.a.a.c.c("com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils");
    com.a.a.c localc2 = com.a.a.c.c("com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType");
    com.a.a.c localc3 = com.a.a.c.c("com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType");
    f localf = new f(this);
    e locale = new e(this);
    d locald = new d(this);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      VariableElement localVariableElement = (VariableElement)((Iterator)localObject).next();
      locala.a("@param $L\n", new Object[] { localVariableElement.getSimpleName().toString() });
      locala.a(com.a.a.c.a(localVariableElement.asType()), localVariableElement.getSimpleName().toString(), new Modifier[0]);
      a(c.h, localExecutableElement, localVariableElement);
      a(localExecutableElement, localVariableElement);
      GetMap localGetMap = (GetMap)localVariableElement.getAnnotation(GetMap.class);
      GetParam localGetParam = (GetParam)localVariableElement.getAnnotation(GetParam.class);
      Sync localSync = (Sync)localVariableElement.getAnnotation(Sync.class);
      Url localUrl = (Url)localVariableElement.getAnnotation(Url.class);
      Header localHeader = (Header)localVariableElement.getAnnotation(Header.class);
      HeaderMap localHeaderMap = (HeaderMap)localVariableElement.getAnnotation(HeaderMap.class);
      CookieStore localCookieStore = (CookieStore)localVariableElement.getAnnotation(CookieStore.class);
      if (localSync != null)
      {
        if ((!localVariableElement.asType().toString().equals("boolean")) || (str3 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be boolean", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str3 = localVariableElement.getSimpleName().toString();
      }
      else if (localUrl != null)
      {
        if ((!localVariableElement.asType().toString().equals(String.class.getCanonicalName())) || (str1 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be String", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str1 = localVariableElement.getSimpleName().toString();
      }
      else if ((localHeader != null) || (localHeaderMap != null))
      {
        localf.a(locala, localHeader, localHeaderMap, localExecutableElement, localVariableElement);
      }
      else if ((localGetParam != null) || (localGetMap != null))
      {
        locale.a(locala, localGetParam, localGetMap, paramUrlEncodeType, paramSignTokenType, localExecutableElement, localVariableElement);
      }
      else if (localCookieStore != null)
      {
        if (!localVariableElement.asType().toString().equals("org.apache.http.client.CookieStore")) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be org.apache.http.client.CookieStore", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        locald.a(locala, localCookieStore, localExecutableElement, localVariableElement);
      }
      else if (!com.a.a.c.a(localVariableElement.asType()).h())
      {
        if (!b(localVariableElement.asType().toString())) {
          a(localVariableElement, "%s parameter type is not support _____ %s", new Object[] { localVariableElement.getSimpleName(), localVariableElement.asType().toString() });
        }
        if (str2 == null) {
          str2 = localVariableElement.getSimpleName().toString();
        } else {
          a(localVariableElement, "you can have only one CallBack int the @%s method", new Object[] { paramElement.getSimpleName() });
        }
      }
    }
    if (str1 == null) {
      a(localExecutableElement, "@Url not find, please annotation url with @Url", new Object[0]);
    }
    if (paramBoolean)
    {
      if (!locale.a)
      {
        locale.a = true;
        locala.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_urlParams", HashMap.class });
      }
      locala.g("android.os.Bundle $L = $T.getInstance().getNativePhoneInfoBundle(false)", new Object[] { "phoneInfoBundle", com.a.a.c.c("com.baidu.platform.comapi.util.SysOSAPIv2") });
      locala.g("$T<$T> $L = $L.keySet()", new Object[] { Set.class, String.class, "phoneInfoKeys", "phoneInfoBundle" });
      locala.d("for($T $L : $L)", new Object[] { String.class, "_phoneInfoKey", "phoneInfoKeys" });
      locala.g("$L.put(_phoneInfoKey, $T.valueOf(phoneInfoBundle.get(_phoneInfoKey)))", new Object[] { "_urlParams", String.class });
      locala.b();
    }
    if (locale.a)
    {
      locala.d("if($L != null)", new Object[] { "_urlParams" });
      locala.g("StringBuilder $L = new StringBuilder($L)", new Object[] { "_urlBuilder", str1 });
      locala.d("if(!$L.contains($S))", new Object[] { str1, "?" });
      locala.g("_urlBuilder.append($S)", new Object[] { "?" });
      locala.e("else", new Object[0]);
      locala.g("$T query = android.net.Uri.parse($L).getQuery()", new Object[] { String.class, str1 });
      locala.d("if(!android.text.TextUtils.isEmpty($L))", new Object[] { "query" });
      locala.g("_urlBuilder.append(\"&\")", new Object[0]);
      locala.b();
      locala.b();
      if (paramSignTokenType.equals(SignToken.SignTokenType.MAP_PHPUI))
      {
        locala.g("_urlBuilder.append($T.getUrlQueryString(_urlParams, $T.ENGINE))", new Object[] { localc1, localc2 });
        locala.g("$L = _urlBuilder.toString()", new Object[] { str1 });
        locala.b();
      }
    }
    else
    {
      if ((paramSignTokenType != null) && (!paramSignTokenType.equals(SignToken.SignTokenType.NONE)))
      {
        locala.d("if(!android.text.TextUtils.isEmpty($L))", new Object[] { str1 });
        locala.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "signParams", HashMap.class });
        if (locale.a)
        {
          locala.d("if($L != null)", new Object[] { "_urlParams" });
          locala.g("$L.putAll($L)", new Object[] { "signParams", "_urlParams" });
          locala.b();
        }
        if (!paramSignTokenType.equals(SignToken.SignTokenType.MAP_UGC)) {
          break label1553;
        }
        paramSignTokenType = "true";
        paramElement = paramSignTokenType;
        if (paramUrlEncodeType != null)
        {
          paramElement = paramSignTokenType;
          if (paramUrlEncodeType.equals(UrlEncode.UrlEncodeType.JAVA)) {
            paramElement = "false";
          }
        }
        locala.g("$T signString = com.baidu.components.uploadpic.util.ShenBIanSig.getSig(signParams, " + paramElement + ")", new Object[] { String.class });
        label1412:
        locala.g("$L.put(\"sign\", signString)", new Object[] { "_urlParams" });
        locala.b();
      }
      if (str3 != null) {
        break label1589;
      }
      paramElement = "false,";
      label1446:
      if (!localf.a) {
        break label1614;
      }
      paramUrlEncodeType = "_headerParams";
      label1459:
      if (!locale.a) {
        break label1622;
      }
    }
    label1553:
    label1589:
    label1614:
    label1622:
    for (paramSignTokenType = "_urlParams";; paramSignTokenType = "null")
    {
      locala.g("mRetrofit.build().$L($L$L,$L, $L, $L)", new Object[] { "getRequest", paramElement, str1, paramUrlEncodeType, paramSignTokenType, str2 });
      parama.a(locala.c());
      return;
      locala.g("_urlBuilder.append($T.getUrlQueryString(_urlParams, $T.JAVA))", new Object[] { localc1, localc2 });
      break;
      locala.g("$T signString = $T.signString(signParams, $T.$L)", new Object[] { String.class, localc1, localc3, paramSignTokenType });
      break label1412;
      paramElement = str3 + ", ";
      break label1446;
      paramUrlEncodeType = "null";
      break label1459;
    }
  }
  
  private void a(Element paramElement)
  {
    if (paramElement.getKind().equals(ElementKind.METHOD))
    {
      int j = 0;
      Class[] arrayOfClass = c.i;
      int m = arrayOfClass.length;
      int i = 0;
      while (i < m)
      {
        int k = j;
        if (paramElement.getAnnotation(arrayOfClass[i]) != null) {
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      if (j > 1) {
        a(paramElement, "@%s method @%s parameter annotation error.", new Object[] { paramElement.getSimpleName(), paramElement.getSimpleName().toString() });
      }
    }
  }
  
  private void a(ExecutableElement paramExecutableElement, Element paramElement)
  {
    if ((PostParam)paramElement.getAnnotation(PostParam.class) != null) {
      a(paramExecutableElement, "@PostParam annotation can't be used in @GET Request!", new Object[0]);
    }
    if ((PostMap)paramElement.getAnnotation(PostMap.class) != null) {
      a(paramExecutableElement, "@PostMap annotation can't be used in @GET Request!", new Object[0]);
    }
  }
  
  private void a(Class<?>[] paramArrayOfClass, ExecutableElement paramExecutableElement, VariableElement paramVariableElement)
  {
    if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0)) {
      throw new RuntimeException("check class size is empty!");
    }
    int j = 0;
    int m = paramArrayOfClass.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (paramVariableElement.getAnnotation(paramArrayOfClass[i]) != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    if (j > 1) {
      a(paramExecutableElement, "@%s method @%s parameter annotation error", new Object[] { paramExecutableElement.getSimpleName(), paramVariableElement.getSimpleName().toString() });
    }
  }
  
  private void b(m.a parama, Element paramElement)
  {
    h.a locala = h.a(paramElement.getSimpleName().toString()).a(new Modifier[] { Modifier.PUBLIC }).a(Void.TYPE);
    ExecutableElement localExecutableElement = (ExecutableElement)paramElement;
    Object localObject = localExecutableElement.getParameters();
    String str2 = null;
    String str3 = null;
    String str1 = null;
    f localf = new f(this);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      VariableElement localVariableElement = (VariableElement)((Iterator)localObject).next();
      locala.a("@param $L\n", new Object[] { localVariableElement.getSimpleName().toString() });
      locala.a(com.a.a.c.a(localVariableElement.asType()), localVariableElement.getSimpleName().toString(), new Modifier[0]);
      a(c.j, localExecutableElement, localVariableElement);
      Sync localSync = (Sync)localVariableElement.getAnnotation(Sync.class);
      Url localUrl = (Url)localVariableElement.getAnnotation(Url.class);
      Header localHeader = (Header)localVariableElement.getAnnotation(Header.class);
      HeaderMap localHeaderMap = (HeaderMap)localVariableElement.getAnnotation(HeaderMap.class);
      if (localSync != null)
      {
        if ((!localVariableElement.asType().toString().equals("boolean")) || (str3 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be boolean", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str3 = localVariableElement.getSimpleName().toString();
      }
      else if (localUrl != null)
      {
        if ((!localVariableElement.asType().toString().equals(String.class.getCanonicalName())) || (str1 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be String", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str1 = localVariableElement.getSimpleName().toString();
      }
      else if ((localHeader != null) || (localHeaderMap != null))
      {
        localf.a(locala, localHeader, localHeaderMap, localExecutableElement, localVariableElement);
      }
      else if (!com.a.a.c.a(localVariableElement.asType()).h())
      {
        if (!b(localVariableElement.asType().toString())) {
          a(localVariableElement, "%s parameter type is not support _____ %s", new Object[] { localVariableElement.getSimpleName(), localVariableElement.asType().toString() });
        }
        if (str2 == null) {
          str2 = localVariableElement.getSimpleName().toString();
        } else {
          a(localVariableElement, "you can have only one CallBack int the @%s method", new Object[] { paramElement.getSimpleName() });
        }
      }
    }
    if (str1 == null) {
      a(localExecutableElement, "@Url not find, please annotation url with @Url", new Object[0]);
    }
    if (str3 == null)
    {
      paramElement = "false,";
      if (!localf.a) {
        break label652;
      }
    }
    label652:
    for (str3 = "_headerParams";; str3 = "null")
    {
      locala.g("mRetrofit.build().$L($L$L, $L, $L, $L)", new Object[] { "deleteRequest", paramElement, str1, str3, "null", str2 });
      parama.a(locala.c());
      return;
      paramElement = str3 + ", ";
      break;
    }
  }
  
  private void b(m.a parama, Element paramElement, boolean paramBoolean, UrlEncode.UrlEncodeType paramUrlEncodeType, SignToken.SignTokenType paramSignTokenType)
  {
    h.a locala = h.a(paramElement.getSimpleName().toString()).a(new Modifier[] { Modifier.PUBLIC }).a(Void.TYPE);
    ExecutableElement localExecutableElement = (ExecutableElement)paramElement;
    Object localObject = localExecutableElement.getParameters();
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str1 = null;
    com.a.a.c localc1 = com.a.a.c.c("com.baidu.mapframework.nirvana.runtime.http.URLEncodeUtils");
    com.a.a.c localc2 = com.a.a.c.c("com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType");
    com.a.a.c localc3 = com.a.a.c.c("com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType");
    f localf = new f(this);
    e locale = new e(this);
    i locali = new i(this);
    d locald = new d(this);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      VariableElement localVariableElement = (VariableElement)((Iterator)localObject).next();
      locala.a("@param $L\n", new Object[] { localVariableElement.getSimpleName().toString() });
      locala.a(com.a.a.c.a(localVariableElement.asType()), localVariableElement.getSimpleName().toString(), new Modifier[0]);
      a(c.h, localExecutableElement, localVariableElement);
      GetParam localGetParam = (GetParam)localVariableElement.getAnnotation(GetParam.class);
      PostParam localPostParam = (PostParam)localVariableElement.getAnnotation(PostParam.class);
      GetMap localGetMap = (GetMap)localVariableElement.getAnnotation(GetMap.class);
      PostMap localPostMap = (PostMap)localVariableElement.getAnnotation(PostMap.class);
      Sync localSync = (Sync)localVariableElement.getAnnotation(Sync.class);
      Url localUrl = (Url)localVariableElement.getAnnotation(Url.class);
      Header localHeader = (Header)localVariableElement.getAnnotation(Header.class);
      RequestBody localRequestBody = (RequestBody)localVariableElement.getAnnotation(RequestBody.class);
      HeaderMap localHeaderMap = (HeaderMap)localVariableElement.getAnnotation(HeaderMap.class);
      InputStream localInputStream = (InputStream)localVariableElement.getAnnotation(InputStream.class);
      CookieStore localCookieStore = (CookieStore)localVariableElement.getAnnotation(CookieStore.class);
      if (localSync != null)
      {
        if ((!localVariableElement.asType().toString().equals("boolean")) || (str4 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be boolean", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str4 = localVariableElement.getSimpleName().toString();
      }
      else if (localUrl != null)
      {
        if ((!localVariableElement.asType().toString().equals(String.class.getCanonicalName())) || (str2 != null)) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be String", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        str2 = localVariableElement.getSimpleName().toString();
      }
      else if ((localHeader != null) || (localHeaderMap != null))
      {
        localf.a(locala, localHeader, localHeaderMap, localExecutableElement, localVariableElement);
      }
      else if ((localGetParam != null) || (localGetMap != null))
      {
        if (localRequestBody != null) {
          a(localExecutableElement, "@RequestBody is not Compatible with @GetMap and @GetParam !", new Object[0]);
        }
        locale.a(locala, localGetParam, localGetMap, paramUrlEncodeType, paramSignTokenType, localExecutableElement, localVariableElement);
      }
      else if ((localPostMap != null) || (localPostParam != null) || (localInputStream != null))
      {
        if (localRequestBody != null) {
          a(localExecutableElement, "@RequestBody is not Compatible with @PostMap and @PostParam !", new Object[0]);
        }
        locali.a(locala, localPostParam, localPostMap, localInputStream, paramUrlEncodeType, paramSignTokenType, localExecutableElement, localVariableElement);
      }
      else if (localRequestBody != null)
      {
        locali.d = true;
        if (localVariableElement.asType().toString().equals("org.apache.http.HttpEntity")) {
          str1 = localVariableElement.getSimpleName().toString();
        } else {
          a(localExecutableElement, "@RequestBody param's type is not org.apache.http.HttpEntity !", new Object[0]);
        }
      }
      else if (localCookieStore != null)
      {
        if (!localVariableElement.asType().toString().equals("org.apache.http.client.CookieStore")) {
          a(localExecutableElement, "@%s parameter @%s annotation error, parameter should be org.apache.http.client.CookieStore", new Object[] { localExecutableElement.getSimpleName(), localVariableElement.getSimpleName().toString() });
        }
        locald.a(locala, localCookieStore, localExecutableElement, localVariableElement);
      }
      else if (!com.a.a.c.a(localVariableElement.asType()).h())
      {
        if (!b(localVariableElement.asType().toString())) {
          a(localVariableElement, "%s parameter type is not support _____ %s", new Object[] { localVariableElement.getSimpleName(), localVariableElement.asType().toString() });
        }
        if (str3 == null) {
          str3 = localVariableElement.getSimpleName().toString();
        } else {
          a(localVariableElement, "you can have only one CallBack int the @%s method", new Object[] { paramElement.getSimpleName() });
        }
      }
    }
    if (str2 == null) {
      a(localExecutableElement, "@Url not find, please annotation url with @Url", new Object[0]);
    }
    if (paramBoolean)
    {
      if (!locale.a)
      {
        locale.a = true;
        locala.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_urlParams", HashMap.class });
      }
      locala.g("android.os.Bundle $L = $T.getInstance().getNativePhoneInfoBundle(false)", new Object[] { "phoneInfoBundle", com.a.a.c.c("com.baidu.platform.comapi.util.SysOSAPIv2") });
      locala.g("$T<$T> $L = $L.keySet()", new Object[] { Set.class, String.class, "phoneInfoKeys", "phoneInfoBundle" });
      locala.d("for($T $L : $L)", new Object[] { String.class, "_phoneInfoKey", "phoneInfoKeys" });
      locala.g("$L.put(_phoneInfoKey, $T.valueOf(phoneInfoBundle.get(_phoneInfoKey)))", new Object[] { "_urlParams", String.class });
      locala.b();
    }
    if (locale.a)
    {
      locala.d("if($L != null)", new Object[] { "_urlParams" });
      locala.g("StringBuilder $L = new StringBuilder($L)", new Object[] { "_urlBuilder", str2 });
      locala.d("if(!$L.contains($S))", new Object[] { str2, "?" });
      locala.g("_urlBuilder.append($S)", new Object[] { "?" });
      locala.e("else", new Object[0]);
      locala.g("$T query = android.net.Uri.parse($L).getQuery()", new Object[] { String.class, str2 });
      locala.d("if(!android.text.TextUtils.isEmpty($L))", new Object[] { "query" });
      locala.g("_urlBuilder.append(\"&\")", new Object[0]);
      locala.b();
      locala.b();
      if (paramSignTokenType.equals(SignToken.SignTokenType.MAP_PHPUI))
      {
        locala.g("_urlBuilder.append($T.getUrlQueryString(_urlParams, $T.ENGINE))", new Object[] { localc1, localc2 });
        locala.g("$L = _urlBuilder.toString()", new Object[] { str2 });
        locala.b();
      }
    }
    else
    {
      if ((paramSignTokenType != null) && (!paramSignTokenType.equals(SignToken.SignTokenType.NONE)))
      {
        locala.d("if(!android.text.TextUtils.isEmpty($L))", new Object[] { str2 });
        locala.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "signParams", HashMap.class });
        if (locale.a)
        {
          locala.d("if($L != null)", new Object[] { "_urlParams" });
          locala.g("$L.putAll($L)", new Object[] { "signParams", "_urlParams" });
          locala.b();
        }
        if (!locali.a)
        {
          locali.a = true;
          locala.g("$T<$T, $T> $L = new $T<>()", new Object[] { HashMap.class, String.class, String.class, "_postParams", HashMap.class });
        }
        if (locali.a)
        {
          locala.d("if($L != null)", new Object[] { "_postParams" });
          locala.g("$L.putAll($L)", new Object[] { "signParams", "_postParams" });
          locala.b();
        }
        if (!paramSignTokenType.equals(SignToken.SignTokenType.MAP_UGC)) {
          break label1941;
        }
        paramSignTokenType = "true";
        paramElement = paramSignTokenType;
        if (paramUrlEncodeType != null)
        {
          paramElement = paramSignTokenType;
          if (paramUrlEncodeType.equals(UrlEncode.UrlEncodeType.JAVA)) {
            paramElement = "false";
          }
        }
        locala.g("$T signString = com.baidu.components.uploadpic.util.ShenBIanSig.getSig(signParams, " + paramElement + ")", new Object[] { String.class });
        locala.g("StringBuilder $L = new StringBuilder($L)", new Object[] { "_urlBuilder", str2 });
        locala.d("if(!$L.contains($S))", new Object[] { str2, "?" });
        locala.g("_urlBuilder.append($S)", new Object[] { "?" });
        locala.b();
        locala.g("_urlBuilder.append(\"sign=\" + $L)", new Object[] { "signString" });
        locala.g("$L = _urlBuilder.toString()", new Object[] { str2 });
        label1816:
        locala.b();
      }
      if (!locali.d) {
        break label2031;
      }
      if (str4 != null) {
        break label1990;
      }
      paramElement = "false,";
      label1839:
      if (!localf.a) {
        break label2015;
      }
      paramUrlEncodeType = "_headerParams";
      label1852:
      if (!locali.d) {
        break label2023;
      }
    }
    for (;;)
    {
      locala.g("mRetrofit.build().$L($L$L, $L, $L, $L)", new Object[] { "postRequest", paramElement, str2, paramUrlEncodeType, str1, str3 });
      parama.a(locala.c());
      return;
      locala.g("_urlBuilder.append($T.getUrlQueryString(_urlParams, $T.JAVA))", new Object[] { localc1, localc2 });
      break;
      label1941:
      locala.g("$T signString = $T.signString(signParams, $T.$L)", new Object[] { String.class, localc1, localc3, paramSignTokenType });
      locala.g("_postParams.put(\"sign\", signString)", new Object[0]);
      break label1816;
      label1990:
      paramElement = str4 + ", ";
      break label1839;
      label2015:
      paramUrlEncodeType = "null";
      break label1852;
      label2023:
      str1 = "null";
    }
    label2031:
    if (str4 == null)
    {
      paramElement = "false,";
      label2040:
      if (!localf.a) {
        break label2176;
      }
      paramUrlEncodeType = "_headerParams";
      label2053:
      if (!locali.a) {
        break label2184;
      }
      paramSignTokenType = "_postParams";
      label2066:
      if (!locali.b) {
        break label2192;
      }
      str1 = "_fileParams";
      label2079:
      if (!locali.c) {
        break label2200;
      }
    }
    label2176:
    label2184:
    label2192:
    label2200:
    for (str4 = "_inputStreams";; str4 = "null")
    {
      locala.g("mRetrofit.build().$L($L$L, $L, $L, $L, $L, $L)", new Object[] { "postRequest", paramElement, str2, paramUrlEncodeType, paramSignTokenType, str1, str4, str3 });
      break;
      paramElement = str4 + ", ";
      break label2040;
      paramUrlEncodeType = "null";
      break label2053;
      paramSignTokenType = "null";
      break label2066;
      str1 = "null";
      break label2079;
    }
  }
  
  private boolean b(String paramString)
  {
    Iterator localIterator = c.a.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(Element paramElement)
  {
    paramElement = paramElement.getAnnotationMirrors().iterator();
    while (paramElement.hasNext()) {
      if ("android.support.annotation.Keep".equals(((AnnotationMirror)paramElement.next()).getAnnotationType().toString())) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    if (this.c.getKind() != ElementKind.INTERFACE) {
      a(this.c, "Only interface can be annotated with @%s", new Object[] { RegisterRequest.class.getSimpleName() });
    }
    if (!b(this.c)) {
      a(this.c, "%s should be annotated by @Keep", new Object[] { this.c.getSimpleName() });
    }
    String str = this.c.asType().toString();
    Object localObject1 = com.a.a.c.c(str);
    Object localObject2 = this.c.getSimpleName().toString();
    str = str.replace("." + (String)localObject2, ".generate");
    localObject2 = (String)localObject2 + "Impl";
    m.a locala = m.a((String)localObject2).a(new Modifier[] { Modifier.PUBLIC, Modifier.FINAL }).a(this.d).a("This file is automatically generated. \nDO NOT MODIFY!\n", new Object[0]).b((l)localObject1);
    a(locala);
    a(locala, (l)localObject1, (String)localObject2);
    Iterator localIterator = ((TypeElement)this.c).getEnclosedElements().iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localElement.getKind() == ElementKind.METHOD)
      {
        GET localGET = (GET)localElement.getAnnotation(GET.class);
        POST localPOST = (POST)localElement.getAnnotation(POST.class);
        PUT localPUT = (PUT)localElement.getAnnotation(PUT.class);
        DELETE localDELETE = (DELETE)localElement.getAnnotation(DELETE.class);
        a(localElement);
        localObject1 = (AppendPhoneInfo)localElement.getAnnotation(AppendPhoneInfo.class);
        SignToken localSignToken = (SignToken)localElement.getAnnotation(SignToken.class);
        UrlEncode localUrlEncode = (UrlEncode)localElement.getAnnotation(UrlEncode.class);
        if (localObject1 != null) {}
        for (boolean bool = true;; bool = false)
        {
          localObject2 = SignToken.SignTokenType.NONE;
          localObject1 = UrlEncode.UrlEncodeType.NONE;
          if (localUrlEncode != null) {
            localObject1 = localUrlEncode.value();
          }
          if (localSignToken != null) {
            localObject2 = localSignToken.value();
          }
          if (localUrlEncode != null) {
            localObject1 = localUrlEncode.value();
          }
          if (localPOST == null) {
            break label463;
          }
          b(locala, localElement, bool, (UrlEncode.UrlEncodeType)localObject1, (SignToken.SignTokenType)localObject2);
          break;
        }
        label463:
        if (localGET != null) {
          a(locala, localElement, bool, (UrlEncode.UrlEncodeType)localObject1, (SignToken.SignTokenType)localObject2);
        } else if (localPUT != null) {
          a(locala, localElement);
        } else if (localDELETE != null) {
          b(locala, localElement);
        } else {
          a(localElement, "@%s should be annotated", new Object[] { localElement.getSimpleName() });
        }
      }
    }
    localObject1 = com.a.a.g.a(str, locala.a()).a();
    try
    {
      ((com.a.a.g)localObject1).a(this.b);
      return;
    }
    catch (IOException localIOException)
    {
      a(this.c, localIOException.getMessage(), new Object[0]);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/annotation/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */