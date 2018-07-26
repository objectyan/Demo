package com.baidu.mapframework.nirvana.annotation.p204a;

import com.baidu.mapframework.nirvana.annotation.InputStream;
import com.baidu.mapframework.nirvana.annotation.PostMap;
import com.baidu.mapframework.nirvana.annotation.PostParam;
import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import com.baidu.navi.track.database.DataService;
import com.p015a.p016a.C0359c;
import com.p015a.p016a.C0373h.C0372a;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

/* compiled from: PostParamProcessor */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.i */
class C3525i extends C3520h {
    /* renamed from: i */
    static final String f19096i = "_postParams";
    /* renamed from: j */
    static final String f19097j = "_fileParams";
    /* renamed from: k */
    static final String f19098k = "_inputStreams";
    /* renamed from: a */
    boolean f19099a = false;
    /* renamed from: b */
    boolean f19100b = false;
    /* renamed from: c */
    boolean f19101c = false;
    /* renamed from: d */
    boolean f19102d = false;
    /* renamed from: e */
    C0359c f19103e = C0359c.c(C3519c.f19078e);
    /* renamed from: g */
    C0359c f19104g = C0359c.c(C3519c.f19079f);
    /* renamed from: h */
    C0359c f19105h = C0359c.c(C3519c.f19080g);

    public C3525i(C3517a parser) {
        super(parser);
    }

    /* renamed from: a */
    void m15118a(C0372a methodBuilder, PostParam postParamAnno, PostMap postMapParamAnno, InputStream inputStreamAnno, UrlEncodeType urlEncodeType, SignTokenType signTokenType, ExecutableElement executableElement, VariableElement variableElement) {
        if (postMapParamAnno != null) {
            if (variableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.lang.String>")) {
                if (!this.f19099a) {
                    this.f19099a = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19096i, HashMap.class});
                }
                methodBuilder.d("if($L != null)", new Object[]{variableElement.getSimpleName().toString()});
                if (urlEncodeType == null || urlEncodeType == UrlEncodeType.NONE) {
                    methodBuilder.g("$L.putAll($L)", new Object[]{f19096i, variableElement.getSimpleName().toString()});
                } else {
                    methodBuilder.g("$T<$T> $L = $L.keySet()", new Object[]{Set.class, String.class, DataService.EXTRA_FRAGMENT_KEYS, variableElement.getSimpleName().toString()});
                    methodBuilder.d("for($T $L : $L)", new Object[]{String.class, "_key", DataService.EXTRA_FRAGMENT_KEYS});
                    methodBuilder.g("$L.put(_key, $T.urlEncode($T.$L, $L.get(_key)))", new Object[]{f19096i, this.f19103e, this.f19104g, urlEncodeType, variableElement.getSimpleName().toString()});
                    methodBuilder.b();
                }
                methodBuilder.b();
            } else if (variableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.io.File>")) {
                if (!this.f19100b) {
                    this.f19100b = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, File.class, f19097j, HashMap.class});
                }
                methodBuilder.d("if($L != null)", new Object[]{variableElement.getSimpleName().toString()});
                methodBuilder.g("$L.putAll($L)", new Object[]{f19097j, variableElement.getSimpleName().toString()});
                methodBuilder.b();
            } else {
                this.f.m15102a(executableElement, "@%s parameter @%s annotation error, parameter should be java.util.HashMap<java.lang.String,java.lang.String> or java.util.HashMap<java.lang.String,java.io.File>", executableElement.getSimpleName(), variableElement.getSimpleName().toString());
            }
        } else if (postParamAnno != null) {
            C3527k.m15126b(postParamAnno.value(), signTokenType);
            String controlFlow;
            if (C0359c.a(variableElement.asType()).h()) {
                if (!this.f19099a) {
                    this.f19099a = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19096i, HashMap.class});
                }
                controlFlow = postParamAnno.optional();
                if (controlFlow != null && controlFlow.trim().isEmpty()) {
                    methodBuilder.d(controlFlow, new Object[0]);
                }
                methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + "+$S)", new Object[]{f19096i, postParamAnno.value(), ""});
                if (controlFlow != null && !controlFlow.trim().isEmpty()) {
                    methodBuilder.b();
                }
            } else if (variableElement.asType().toString().equals(String.class.getCanonicalName())) {
                if (!this.f19099a) {
                    this.f19099a = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19096i, HashMap.class});
                }
                controlFlow = postParamAnno.optional();
                if (!(controlFlow == null || controlFlow.trim().isEmpty())) {
                    methodBuilder.d(controlFlow, new Object[0]);
                }
                if (urlEncodeType == null || urlEncodeType == UrlEncodeType.NONE) {
                    methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + ")", new Object[]{f19096i, postParamAnno.value()});
                } else {
                    methodBuilder.g("$L.put($S, $T.urlEncode($T.$L, $L))", new Object[]{f19096i, postParamAnno.value(), this.f19103e, this.f19104g, urlEncodeType, variableElement.getSimpleName().toString()});
                }
                if (controlFlow != null && !controlFlow.trim().isEmpty()) {
                    methodBuilder.b();
                }
            } else if (variableElement.asType().toString().equals(File.class.getCanonicalName())) {
                if (!this.f19100b) {
                    this.f19100b = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, File.class, f19097j, HashMap.class});
                }
                controlFlow = postParamAnno.optional();
                if (!(controlFlow == null || controlFlow.trim().isEmpty())) {
                    methodBuilder.d(controlFlow, new Object[0]);
                }
                methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + ")", new Object[]{f19097j, postParamAnno.value()});
                if (controlFlow != null && !controlFlow.trim().isEmpty()) {
                    methodBuilder.b();
                }
            } else {
                this.f.m15102a(variableElement, "@%s parameter type must be java.lang.String or primitive", variableElement.getSimpleName());
            }
        } else if (inputStreamAnno != null && variableElement.asType().toString().equals(java.io.InputStream.class.getCanonicalName())) {
            if (!this.f19101c) {
                this.f19101c = true;
                methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, java.io.InputStream.class, f19098k, HashMap.class});
            }
            methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + ")", new Object[]{f19098k, inputStreamAnno.value()});
        }
    }
}
