package com.baidu.tts.p245p;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* compiled from: StatisticsClient */
/* renamed from: com.baidu.tts.p.b */
public class C5155b {
    /* renamed from: a */
    private C5158c f21285a;
    /* renamed from: b */
    private Context f21286b;
    /* renamed from: c */
    private FutureTask<Integer> f21287c;

    public C5155b(Context context) {
        this.f21286b = context;
        this.f21285a = new C5158c(context);
    }

    /* renamed from: a */
    public void m17500a() {
        int intValue;
        this.f21287c = this.f21285a.m17510a();
        try {
            intValue = ((Integer) this.f21287c.get()).intValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            intValue = -1;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            intValue = -1;
        }
        LoggerProxy.m17001d("StatisticsClient", "Statistics uploade result=" + intValue);
    }

    /* renamed from: b */
    public void m17501b() {
        if (this.f21287c != null) {
            this.f21285a.m17511b();
        }
    }
}
