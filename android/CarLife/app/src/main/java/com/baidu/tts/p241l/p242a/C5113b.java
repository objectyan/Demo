package com.baidu.tts.p241l.p242a;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C5068a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: GetLocalModelFileInfosWork */
/* renamed from: com.baidu.tts.l.a.b */
public class C5113b implements Callable<ModelFileBags> {
    /* renamed from: a */
    private Set<String> f21228a;
    /* renamed from: b */
    private C5068a f21229b;

    public /* synthetic */ Object call() throws Exception {
        return m17341a();
    }

    public C5113b(C5068a c5068a, Set<String> set) {
        this.f21228a = set;
        this.f21229b = c5068a;
    }

    /* renamed from: a */
    public ModelFileBags m17341a() throws Exception {
        List a = this.f21229b.m17208a(this.f21228a);
        ModelFileBags modelFileBags = new ModelFileBags();
        modelFileBags.setList(a);
        return modelFileBags;
    }
}
