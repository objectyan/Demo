package com.baidu.mapframework.nirvana.annotation.p204a;

import com.baidu.mapframework.nirvana.annotation.CookieStore;
import com.p015a.p016a.C0373h.C0372a;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

/* compiled from: CookieStoreProcessor */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.d */
public class C3521d extends C3520h {
    /* renamed from: a */
    String f19085a = null;

    C3521d(C3517a parser) {
        super(parser);
    }

    /* renamed from: a */
    void m15103a(C0372a methodBuilder, CookieStore cookieStore, ExecutableElement executableElement, VariableElement variableElement) {
        if (cookieStore != null) {
            this.f19085a = variableElement.getSimpleName().toString();
        }
        if (this.f19085a != null && !this.f19085a.isEmpty()) {
            methodBuilder.g("mRetrofit.build().$L($L)", new Object[]{"setCookieStore", this.f19085a});
        }
    }
}
