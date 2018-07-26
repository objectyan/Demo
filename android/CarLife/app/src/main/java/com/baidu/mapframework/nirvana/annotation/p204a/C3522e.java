package com.baidu.mapframework.nirvana.annotation.p204a;

import com.baidu.mapframework.nirvana.annotation.GetMap;
import com.baidu.mapframework.nirvana.annotation.GetParam;
import com.baidu.mapframework.nirvana.annotation.SignToken.SignTokenType;
import com.baidu.mapframework.nirvana.annotation.UrlEncode.UrlEncodeType;
import com.baidu.navi.track.database.DataService;
import com.p015a.p016a.C0359c;
import com.p015a.p016a.C0373h.C0372a;
import java.util.HashMap;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

/* compiled from: GetParamProcessor */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.e */
class C3522e extends C3520h {
    /* renamed from: e */
    static final String f19086e = "_urlParams";
    /* renamed from: a */
    boolean f19087a = false;
    /* renamed from: b */
    C0359c f19088b = C0359c.c(C3519c.f19078e);
    /* renamed from: c */
    C0359c f19089c = C0359c.c(C3519c.f19079f);
    /* renamed from: d */
    C0359c f19090d = C0359c.c(C3519c.f19080g);

    public C3522e(C3517a parser) {
        super(parser);
    }

    /* renamed from: a */
    void m15104a(C0372a methodBuilder, GetParam getParamAnno, GetMap getMapParamAnno, UrlEncodeType urlEncodeType, SignTokenType signTokenType, ExecutableElement executableElement, VariableElement variableElement) {
        if (getMapParamAnno != null) {
            if (variableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.lang.String>")) {
                if (!this.f19087a) {
                    this.f19087a = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19086e, HashMap.class});
                }
                methodBuilder.d("if($L != null)", new Object[]{variableElement.getSimpleName().toString()});
                if (urlEncodeType == null || urlEncodeType == UrlEncodeType.NONE) {
                    methodBuilder.g("$L.putAll($L)", new Object[]{f19086e, variableElement.getSimpleName().toString()});
                } else {
                    methodBuilder.g("$T<$T> $L = $L.keySet()", new Object[]{Set.class, String.class, DataService.EXTRA_FRAGMENT_KEYS, variableElement.getSimpleName().toString()});
                    methodBuilder.d("for($T $L : $L)", new Object[]{String.class, "key", DataService.EXTRA_FRAGMENT_KEYS});
                    methodBuilder.g("$L.put(key, $T.urlEncode($T.$L, $L.get(key)))", new Object[]{f19086e, this.f19088b, this.f19089c, urlEncodeType, variableElement.getSimpleName().toString()});
                    methodBuilder.b();
                }
                methodBuilder.b();
                return;
            }
            this.f.m15102a(executableElement, "@%s parameter @%s annotation error, parameter should be java.util.HashMap<java.lang.String,java.lang.String>", executableElement.getSimpleName(), variableElement.getSimpleName().toString());
        } else if (getParamAnno != null) {
            C3527k.m15124a(getParamAnno.value(), signTokenType);
            if (!this.f19087a) {
                this.f19087a = true;
                methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19086e, HashMap.class});
            }
            String controlFlow;
            if (C0359c.a(variableElement.asType()).h()) {
                controlFlow = getParamAnno.optional();
                if (controlFlow == null || controlFlow.trim().isEmpty()) {
                    methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + "+$S)", new Object[]{f19086e, getParamAnno.value(), ""});
                    return;
                }
                methodBuilder.d(controlFlow, new Object[0]);
                methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + "+$S)", new Object[]{f19086e, getParamAnno.value(), ""});
                methodBuilder.b();
            } else if (variableElement.asType().toString().equals(String.class.getCanonicalName())) {
                controlFlow = getParamAnno.optional();
                if (!(controlFlow == null || controlFlow.trim().isEmpty())) {
                    methodBuilder.d(controlFlow, new Object[0]);
                }
                if (urlEncodeType == null || urlEncodeType == UrlEncodeType.NONE) {
                    methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + ")", new Object[]{f19086e, getParamAnno.value()});
                } else {
                    methodBuilder.g("$L.put($S, $T.urlEncode($T.$L, $L))", new Object[]{f19086e, getParamAnno.value(), this.f19088b, this.f19089c, urlEncodeType, variableElement.getSimpleName().toString()});
                }
                if (controlFlow != null && !controlFlow.trim().isEmpty()) {
                    methodBuilder.f(controlFlow, new Object[0]);
                }
            } else {
                this.f.m15102a(variableElement, "@%s parameter type must be java.lang.String or primitive", variableElement.getSimpleName());
            }
        }
    }
}
