package com.baidu.che.codriver.ui.p124d;

import com.baidu.che.codriver.protocol.data.Place.Result;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.vr.p130a.C2784s;
import java.util.List;

/* compiled from: RouteConversationModel */
/* renamed from: com.baidu.che.codriver.ui.d.j */
public class C2708j extends C2549b {
    /* renamed from: a */
    public List<Result> f8878a;
    /* renamed from: l */
    public int f8879l;
    /* renamed from: m */
    private C2784s f8880m;

    public C2708j(List<Result> results, C2784s itemClickListener) {
        this.f8878a = results;
        this.f = C2695a.TYPE_ROUTE;
        this.f8880m = itemClickListener;
    }

    /* renamed from: a */
    public List<Result> m10131a() {
        return this.f8878a;
    }

    /* renamed from: b */
    public C2784s m10132b() {
        return this.f8880m;
    }
}
