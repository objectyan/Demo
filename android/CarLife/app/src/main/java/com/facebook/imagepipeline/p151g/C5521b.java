package com.facebook.imagepipeline.p151g;

import android.graphics.Bitmap;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p152i.C5535a;
import com.facebook.p138c.C2918d;
import com.facebook.p138c.C5289c;
import javax.annotation.Nullable;

/* compiled from: BaseBitmapDataSubscriber */
/* renamed from: com.facebook.imagepipeline.g.b */
public abstract class C5521b extends C5289c<C2921a<C5534b>> {
    /* renamed from: a */
    protected abstract void m19015a(@Nullable Bitmap bitmap);

    /* renamed from: e */
    public void mo4022e(C2918d<C2921a<C5534b>> dataSource) {
        if (dataSource.b()) {
            C2921a<C5534b> closeableImageRef = (C2921a) dataSource.d();
            Bitmap bitmap = null;
            if (closeableImageRef != null && (closeableImageRef.a() instanceof C5535a)) {
                bitmap = ((C5535a) closeableImageRef.a()).mo4098a();
            }
            try {
                m19015a(bitmap);
            } finally {
                C2921a.c(closeableImageRef);
            }
        }
    }
}
