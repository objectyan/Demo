package com.baidu.che.codriver.ui.p124d;

import com.baidu.che.codriver.p120e.C2529a;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.ui.p127a.C2657f.C2656a;
import java.util.List;

/* compiled from: PhoneConversationModel */
/* renamed from: com.baidu.che.codriver.ui.d.i */
public class C2707i extends C2549b {
    /* renamed from: a */
    private C2656a f8874a;
    /* renamed from: l */
    private C2706a f8875l;
    /* renamed from: m */
    private List<C2529a> f8876m;
    /* renamed from: n */
    private int f8877n;

    /* compiled from: PhoneConversationModel */
    /* renamed from: com.baidu.che.codriver.ui.d.i$a */
    public enum C2706a {
        TYPE_CONTACT_NAME,
        TYPE_CONTACT_NUM,
        TYPE_NUM_CONFIRM
    }

    public C2707i(String content, int autoState) {
        this.f = C2695a.TYPE_PHONE;
        this.g = content;
        this.j = autoState;
        this.k = true;
    }

    public C2707i(String content, int autoState, C2695a type) {
        this.f = type;
        this.g = content;
        this.j = autoState;
        this.k = true;
    }

    public C2707i(String content, List<C2529a> dataSource, C2706a type, int autoState) {
        this(content, autoState);
        this.f8875l = type;
        this.f8876m = dataSource;
        this.k = true;
    }

    public C2707i(String content, String record, int autoState, C2695a type) {
        this(content, autoState, type);
        this.h = record;
        this.k = true;
    }

    /* renamed from: a */
    public C2706a m10125a() {
        return this.f8875l;
    }

    /* renamed from: b */
    public List<C2529a> m10128b() {
        return this.f8876m;
    }

    /* renamed from: c */
    public int m10129c() {
        return this.f8877n;
    }

    /* renamed from: a */
    public void m10126a(int currentPage) {
        this.f8877n = currentPage;
    }

    /* renamed from: d */
    public C2656a m10130d() {
        return this.f8874a;
    }

    /* renamed from: a */
    public void m10127a(C2656a listener) {
        this.f8874a = listener;
    }
}
