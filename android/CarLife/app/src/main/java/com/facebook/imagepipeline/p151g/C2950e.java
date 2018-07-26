package com.facebook.imagepipeline.p151g;

import com.facebook.common.internal.C5350k;
import com.facebook.common.p140h.C2921a;
import com.facebook.common.p256c.C5303a;
import com.facebook.p138c.C2918d;
import com.facebook.p138c.C2919a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: ListDataSource */
/* renamed from: com.facebook.imagepipeline.g.e */
public class C2950e<T> extends C2919a<List<C2921a<T>>> {
    /* renamed from: a */
    private final C2918d<C2921a<T>>[] f13125a;
    @GuardedBy("this")
    /* renamed from: b */
    private int f13126b = 0;

    @Nullable
    /* renamed from: d */
    public /* synthetic */ Object mo2015d() {
        return mo2042j();
    }

    protected C2950e(C2918d<C2921a<T>>[] dataSources) {
        this.f13125a = dataSources;
    }

    /* renamed from: a */
    public static <T> C2950e<T> m11757a(C2918d<C2921a<T>>... dataSources) {
        boolean z;
        int i = 0;
        C5350k.a(dataSources);
        if (dataSources.length > 0) {
            z = true;
        } else {
            z = false;
        }
        C5350k.b(z);
        C2950e<T> listDataSource = new C2950e(dataSources);
        int length = dataSources.length;
        while (i < length) {
            C2918d<C2921a<T>> dataSource = dataSources[i];
            if (dataSource != null) {
                listDataSource.getClass();
                dataSource.mo2011a(new e$a(listDataSource, null), C5303a.a());
            }
            i++;
        }
        return listDataSource;
    }

    @Nullable
    /* renamed from: j */
    public synchronized List<C2921a<T>> mo2042j() {
        List<C2921a<T>> results;
        if (mo2014c()) {
            results = new ArrayList(this.f13125a.length);
            for (C2918d<C2921a<T>> dataSource : this.f13125a) {
                results.add(dataSource.mo2015d());
            }
        } else {
            results = null;
        }
        return results;
    }

    /* renamed from: c */
    public synchronized boolean mo2014c() {
        boolean z;
        z = !mo2012a() && this.f13126b == this.f13125a.length;
        return z;
    }

    /* renamed from: h */
    public boolean mo2019h() {
        int i = 0;
        if (!super.mo2019h()) {
            return false;
        }
        C2918d[] c2918dArr = this.f13125a;
        int length = c2918dArr.length;
        while (i < length) {
            c2918dArr[i].mo2019h();
            i++;
        }
        return true;
    }

    /* renamed from: k */
    private void m11763k() {
        if (m11764l()) {
            m11211a(null, true);
        }
    }

    /* renamed from: l */
    private synchronized boolean m11764l() {
        int i;
        i = this.f13126b + 1;
        this.f13126b = i;
        return i == this.f13125a.length;
    }

    /* renamed from: a */
    private void m11758a(C2918d<C2921a<T>> dataSource) {
        m11212a(dataSource.mo2017f());
    }

    /* renamed from: m */
    private void m11765m() {
        m11212a(new CancellationException());
    }

    /* renamed from: n */
    private void m11766n() {
        float progress = 0.0f;
        for (C2918d<?> dataSource : this.f13125a) {
            progress += dataSource.mo2018g();
        }
        mo2044a(progress / ((float) this.f13125a.length));
    }
}
