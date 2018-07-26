package com.baidu.tts.p229d.p231b;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C5068a;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ModelFileFlyweight */
/* renamed from: com.baidu.tts.d.b.c */
public class C5058c {
    /* renamed from: a */
    private String f20922a;
    /* renamed from: b */
    private Map<String, String> f20923b = new HashMap();

    public C5058c(String str) {
        this.f20922a = str;
    }

    /* renamed from: a */
    public boolean m17133a(C5068a c5068a) {
        this.f20923b = c5068a.m17216d(this.f20922a);
        if (DataTool.isMapEmpty(this.f20923b)) {
            return false;
        }
        String str = (String) this.f20923b.get(C5089g.ABS_PATH.m17274b());
        if (StringTool.isEmpty(str)) {
            c5068a.m17213b(this.f20922a);
            return false;
        }
        C5060e.m17155a().m17161c(str).m17124c(this.f20922a);
        return true;
    }

    /* renamed from: a */
    public void m17132a(ModelFileBags modelFileBags, C5068a c5068a) {
        c5068a.m17211a(modelFileBags);
        m17133a(c5068a);
    }

    /* renamed from: a */
    public String m17131a() {
        return DataTool.getMapValue(this.f20923b, C5089g.ABS_PATH.m17274b());
    }

    /* renamed from: b */
    public String m17134b() {
        return DataTool.getMapValue(this.f20923b, C5089g.LENGTH.m17274b());
    }

    /* renamed from: c */
    public String m17135c() {
        return DataTool.getMapValue(this.f20923b, C5089g.MD5.m17274b());
    }
}
