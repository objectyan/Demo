package com.baidu.mapframework.nirvana.annotation.p204a;

import com.baidu.mapframework.nirvana.annotation.GetParam;
import com.baidu.mapframework.nirvana.annotation.POST;
import com.baidu.mapframework.nirvana.annotation.PostParam;
import com.baidu.mapframework.nirvana.annotation.RegisterRequest;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/* compiled from: RequestProcessor */
/* renamed from: com.baidu.mapframework.nirvana.annotation.a.j */
public class C3526j extends AbstractProcessor {
    /* renamed from: a */
    private Filer f19106a;
    /* renamed from: b */
    private Messager f19107b;

    /* renamed from: a */
    public synchronized void m15120a(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.f19106a = processingEnv.getFiler();
        this.f19107b = processingEnv.getMessager();
    }

    /* renamed from: a */
    public boolean m15121a(Set<? extends TypeElement> set, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(RegisterRequest.class)) {
            new C3524g(element, this.f19107b, this.f19106a).m15117a();
        }
        return true;
    }

    /* renamed from: a */
    public Set<String> m15119a() {
        Set<String> annotations = new LinkedHashSet();
        annotations.add(POST.class.getCanonicalName());
        annotations.add(RegisterRequest.class.getCanonicalName());
        annotations.add(GetParam.class.getCanonicalName());
        annotations.add(PostParam.class.getCanonicalName());
        return annotations;
    }

    /* renamed from: b */
    public SourceVersion m15122b() {
        return SourceVersion.RELEASE_7;
    }
}
