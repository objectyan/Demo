package com.baidu.mapframework.nirvana.annotation.p204a;

import com.baidu.mapframework.nirvana.annotation.Header;
import com.baidu.mapframework.nirvana.annotation.HeaderMap;
import com.p015a.p016a.C0359c;
import com.p015a.p016a.C0373h.C0372a;
import java.util.HashMap;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

/* compiled from: HeaderProcessor */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.f */
class C3523f extends C3520h {
    /* renamed from: b */
    static final String f19091b = "_headerParams";
    /* renamed from: a */
    boolean f19092a = false;

    C3523f(C3517a parser) {
        super(parser);
    }

    /* renamed from: a */
    void m15105a(C0372a methodBuilder, Header headerAnno, HeaderMap headerMapAnno, ExecutableElement executableElement, VariableElement variableElement) {
        if (headerAnno != null) {
            this.f.m15101a("Process @Header param ...");
            if (!this.f19092a) {
                this.f19092a = true;
                methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19091b, HashMap.class});
            }
            String controlFlow;
            if (C0359c.a(variableElement.asType()).h()) {
                controlFlow = headerAnno.optional();
                if (controlFlow == null || controlFlow.trim().isEmpty()) {
                    methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + "+$S)", new Object[]{f19091b, headerAnno.value(), ""});
                    return;
                }
                methodBuilder.d(controlFlow, new Object[0]);
                methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + "+$S)", new Object[]{f19091b, headerAnno.value(), ""});
                methodBuilder.b();
            } else if (variableElement.asType().toString().equals(String.class.getCanonicalName())) {
                controlFlow = headerAnno.optional();
                if (!(controlFlow == null || controlFlow.trim().isEmpty())) {
                    methodBuilder.d(controlFlow, new Object[0]);
                }
                methodBuilder.g("$L.put($S, " + variableElement.getSimpleName().toString() + ")", new Object[]{f19091b, headerAnno.value()});
                if (controlFlow != null && !controlFlow.trim().isEmpty()) {
                    methodBuilder.b();
                }
            } else {
                this.f.m15102a(variableElement, "@%s parameter type must be java.lang.String or primitive", variableElement.getSimpleName());
            }
        } else if (headerMapAnno == null) {
        } else {
            if (variableElement.asType().toString().equals("java.util.HashMap<java.lang.String,java.lang.String>")) {
                if (!this.f19092a) {
                    this.f19092a = true;
                    methodBuilder.g("$T<$T, $T> $L = new $T<>()", new Object[]{HashMap.class, String.class, String.class, f19091b, HashMap.class});
                }
                methodBuilder.d("if($L != null)", new Object[]{variableElement.getSimpleName().toString()});
                methodBuilder.g("$L.putAll($L)", new Object[]{f19091b, variableElement.getSimpleName().toString()});
                methodBuilder.b();
                return;
            }
            this.f.m15102a(executableElement, "@%s parameter @%s annotation error, parameter should be java.util.HashMap<java.lang.String,java.lang.String>", executableElement.getSimpleName(), variableElement.getSimpleName().toString());
        }
    }
}
