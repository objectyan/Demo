package com.baidu.tts.p241l.p242a;

import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.database.C5068a;
import com.baidu.tts.p241l.C5120a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: GetLocalModelsWork */
/* renamed from: com.baidu.tts.l.a.c */
public class C5114c implements Callable<ModelBags> {
    /* renamed from: a */
    private Conditions f21230a;
    /* renamed from: b */
    private C5068a f21231b;
    /* renamed from: c */
    private C5120a f21232c;
    /* renamed from: d */
    private boolean f21233d;

    public /* synthetic */ Object call() throws Exception {
        return m17342a();
    }

    public C5114c(C5068a c5068a, Conditions conditions, C5120a c5120a, boolean z) {
        this.f21230a = conditions;
        this.f21231b = c5068a;
        this.f21232c = c5120a;
        this.f21233d = z;
    }

    /* renamed from: a */
    public ModelBags m17342a() throws Exception {
        List a = this.f21231b.m17207a(this.f21230a);
        ModelBags modelBags = new ModelBags();
        modelBags.setList(a);
        if (modelBags != null && this.f21233d) {
            Iterator it = modelBags.getModelInfos().iterator();
            while (it.hasNext()) {
                if (!this.f21232c.m17368b(((ModelInfo) it.next()).getServerId())) {
                    it.remove();
                }
            }
        }
        return modelBags;
    }
}
