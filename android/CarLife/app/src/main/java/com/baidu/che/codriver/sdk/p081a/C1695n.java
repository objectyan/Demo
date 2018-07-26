package com.baidu.che.codriver.sdk.p081a;

import java.util.List;

/* compiled from: PrivateRadioTool */
/* renamed from: com.baidu.che.codriver.sdk.a.n */
public interface C1695n {

    /* compiled from: PrivateRadioTool */
    /* renamed from: com.baidu.che.codriver.sdk.a.n$a */
    public interface C2608a {
        /* renamed from: a */
        void mo1973a();

        /* renamed from: b */
        void mo1974b();
    }

    /* compiled from: PrivateRadioTool */
    /* renamed from: com.baidu.che.codriver.sdk.a.n$b */
    public static class C2609b {
        /* renamed from: a */
        public String f8628a;
        /* renamed from: b */
        public String f8629b;
        /* renamed from: c */
        public String f8630c;
        /* renamed from: d */
        public List<String> f8631d;
        /* renamed from: e */
        public String f8632e;

        public C2609b(String type, String person, String programName, List<String> keywords, String rawJsonResult) {
            this.f8628a = type;
            this.f8629b = person;
            this.f8630c = programName;
            this.f8631d = keywords;
            this.f8632e = rawJsonResult;
        }
    }

    /* renamed from: a */
    void mo1618a();

    /* renamed from: a */
    void mo1619a(C2609b c2609b, C2608a c2608a);
}
