package com.baidu.mapframework.nirvana.annotation.p204a;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic.Kind;

/* compiled from: AnnotationParser */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.a */
class C3517a {
    /* renamed from: a */
    protected Messager f19060a;
    /* renamed from: b */
    protected Filer f19061b;

    protected C3517a(Messager messager, Filer filer) {
        this.f19060a = messager;
        this.f19061b = filer;
    }

    /* renamed from: a */
    protected void m15102a(Element e, String msg, Object... args) {
        this.f19060a.printMessage(Kind.ERROR, String.format(msg, args), e);
        throw new RuntimeException(String.format(msg, args));
    }

    /* renamed from: a */
    protected void m15101a(String msg) {
        this.f19060a.printMessage(Kind.NOTE, msg);
    }
}
