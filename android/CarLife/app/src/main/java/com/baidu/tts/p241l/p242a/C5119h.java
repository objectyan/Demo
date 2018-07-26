package com.baidu.tts.p241l.p242a;

import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.p241l.C5120a;
import java.util.Set;
import java.util.concurrent.FutureTask;

/* compiled from: ModelInfoManager */
/* renamed from: com.baidu.tts.l.a.h */
public class C5119h {
    /* renamed from: a */
    private C5120a f21241a;

    public C5119h(C5120a c5120a) {
        this.f21241a = c5120a;
    }

    /* renamed from: a */
    public BasicHandler<ModelBags> m17350a(Conditions conditions) {
        BasicHandler<ModelBags> basicHandler = new BasicHandler(new FutureTask(new C5118g(conditions)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: a */
    public BasicHandler<ModelBags> m17351a(Conditions conditions, boolean z) {
        BasicHandler<ModelBags> basicHandler = new BasicHandler(new FutureTask(new C5114c(this.f21241a.m17372e(), conditions, this.f21241a, z)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: a */
    public LibEngineParams m17353a() {
        return new LibEngineParams(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
    }

    /* renamed from: a */
    public BasicHandler<ModelFileBags> m17352a(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler(new FutureTask(new C5117f(set)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: b */
    public BasicHandler<ModelFileBags> m17355b(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler(new FutureTask(new C5113b(this.f21241a.m17372e(), set)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: b */
    public BasicHandler<ModelBags> m17354b() {
        BasicHandler<ModelBags> basicHandler = new BasicHandler(new FutureTask(new C5116e()));
        basicHandler.start();
        return basicHandler;
    }
}
