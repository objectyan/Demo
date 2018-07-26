package com.facebook.imagepipeline.p150f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.p140h.C2921a;
import com.facebook.imagepipeline.memory.C5630f;
import com.facebook.imagepipeline.memory.C5640y;
import com.facebook.imagepipeline.memory.C5642z;
import com.facebook.imagepipeline.p149d.C2944p;
import com.facebook.imagepipeline.p149d.C5476e;
import com.facebook.imagepipeline.p149d.C5477f;
import com.facebook.imagepipeline.p152i.C2952d;
import com.facebook.imagepipeline.p152i.C5534b;
import com.facebook.imagepipeline.p153l.C2955v;
import com.facebook.imagepipeline.p153l.C2956w;
import com.facebook.imagepipeline.p153l.C5551a;
import com.facebook.imagepipeline.p153l.C5575h;
import com.facebook.imagepipeline.p153l.C5576f;
import com.facebook.imagepipeline.p153l.C5577g;
import com.facebook.imagepipeline.p153l.C5581i;
import com.facebook.imagepipeline.p153l.C5582k;
import com.facebook.imagepipeline.p153l.C5588l;
import com.facebook.imagepipeline.p153l.C5593n;
import com.facebook.imagepipeline.p153l.C5595p;
import com.facebook.imagepipeline.p153l.C5597q;
import com.facebook.imagepipeline.p153l.C5607u;
import com.facebook.imagepipeline.p153l.C5610x;
import com.facebook.imagepipeline.p153l.C5614z;
import com.facebook.imagepipeline.p153l.aa;
import com.facebook.imagepipeline.p153l.ab;
import com.facebook.imagepipeline.p153l.ad;
import com.facebook.imagepipeline.p153l.ae;
import com.facebook.imagepipeline.p153l.af;
import com.facebook.imagepipeline.p153l.ag;
import com.facebook.imagepipeline.p153l.ah;
import com.facebook.imagepipeline.p153l.ai;
import com.facebook.imagepipeline.p153l.an;
import com.facebook.imagepipeline.p153l.aq;
import com.facebook.imagepipeline.p153l.ar;
import com.facebook.imagepipeline.p153l.as;
import com.facebook.imagepipeline.p153l.at;
import com.facebook.imagepipeline.p153l.au;
import com.facebook.imagepipeline.p153l.av;
import com.facebook.imagepipeline.p153l.ax;
import com.facebook.imagepipeline.p275c.C5456e;
import com.facebook.imagepipeline.p277h.C5526b;
import com.facebook.imagepipeline.p277h.C5527c;
import com.facebook.p135b.p136a.C5247d;

/* compiled from: ProducerFactory */
/* renamed from: com.facebook.imagepipeline.f.l */
public class C5515l {
    /* renamed from: a */
    private ContentResolver f22388a;
    /* renamed from: b */
    private Resources f22389b;
    /* renamed from: c */
    private AssetManager f22390c;
    /* renamed from: d */
    private final C5630f f22391d;
    /* renamed from: e */
    private final C5526b f22392e;
    /* renamed from: f */
    private final C5527c f22393f;
    /* renamed from: g */
    private final boolean f22394g;
    /* renamed from: h */
    private final boolean f22395h;
    /* renamed from: i */
    private final boolean f22396i;
    /* renamed from: j */
    private final C5497e f22397j;
    /* renamed from: k */
    private final C5642z f22398k;
    /* renamed from: l */
    private final C5476e f22399l;
    /* renamed from: m */
    private final C5476e f22400m;
    /* renamed from: n */
    private final C2944p<C5247d, C5640y> f22401n;
    /* renamed from: o */
    private final C2944p<C5247d, C5534b> f22402o;
    /* renamed from: p */
    private final C5477f f22403p;
    /* renamed from: q */
    private final int f22404q;
    /* renamed from: r */
    private final C5456e f22405r;

    public C5515l(Context context, C5630f byteArrayPool, C5526b imageDecoder, C5527c progressiveJpegConfig, boolean downsampleEnabled, boolean resizeAndRotateEnabledForNetwork, C5497e executorSupplier, C5642z pooledByteBufferFactory, C2944p<C5247d, C5534b> bitmapMemoryCache, C2944p<C5247d, C5640y> encodedMemoryCache, C5476e defaultBufferedDiskCache, C5476e smallImageBufferedDiskCache, C5477f cacheKeyFactory, C5456e platformBitmapFactory, boolean decodeFileDescriptorEnabled, int forceSmallCacheThresholdBytes) {
        this.f22404q = forceSmallCacheThresholdBytes;
        this.f22388a = context.getApplicationContext().getContentResolver();
        this.f22389b = context.getApplicationContext().getResources();
        this.f22390c = context.getApplicationContext().getAssets();
        this.f22391d = byteArrayPool;
        this.f22392e = imageDecoder;
        this.f22393f = progressiveJpegConfig;
        this.f22394g = downsampleEnabled;
        this.f22395h = resizeAndRotateEnabledForNetwork;
        this.f22397j = executorSupplier;
        this.f22398k = pooledByteBufferFactory;
        this.f22402o = bitmapMemoryCache;
        this.f22401n = encodedMemoryCache;
        this.f22399l = defaultBufferedDiskCache;
        this.f22400m = smallImageBufferedDiskCache;
        this.f22403p = cacheKeyFactory;
        this.f22405r = platformBitmapFactory;
        this.f22396i = decodeFileDescriptorEnabled;
    }

    /* renamed from: a */
    public static C5551a m18938a(ai<C2952d> inputProducer) {
        return new C5551a(inputProducer);
    }

    /* renamed from: b */
    public C5576f m18947b(ai<C2921a<C5534b>> inputProducer) {
        return new C5576f(this.f22402o, this.f22403p, inputProducer);
    }

    /* renamed from: c */
    public C5577g m18949c(ai<C2921a<C5534b>> inputProducer) {
        return new C5577g(this.f22403p, inputProducer);
    }

    /* renamed from: d */
    public C5575h m18951d(ai<C2921a<C5534b>> inputProducer) {
        return new C5575h(this.f22402o, this.f22403p, inputProducer);
    }

    /* renamed from: a */
    public static C5581i m18939a(ai<C2952d> inputProducer1, ai<C2952d> inputProducer2) {
        return new C5581i(inputProducer1, inputProducer2);
    }

    /* renamed from: a */
    public C5582k m18946a() {
        return new C5582k(this.f22398k, this.f22396i);
    }

    /* renamed from: e */
    public C5588l m18953e(ai<C2952d> inputProducer) {
        return new C5588l(this.f22391d, this.f22397j.mo4080c(), this.f22392e, this.f22393f, this.f22394g, this.f22395h, inputProducer);
    }

    /* renamed from: f */
    public C5593n m18955f(ai<C2952d> inputProducer) {
        return new C5593n(this.f22399l, this.f22400m, this.f22403p, inputProducer, this.f22404q);
    }

    /* renamed from: g */
    public C5595p m18958g(ai<C2952d> inputProducer) {
        return new C5595p(this.f22403p, inputProducer);
    }

    /* renamed from: h */
    public C5597q m18960h(ai<C2952d> inputProducer) {
        return new C5597q(this.f22401n, this.f22403p, inputProducer);
    }

    /* renamed from: b */
    public C5607u m18948b() {
        return new C5607u(this.f22397j.mo4078a(), this.f22398k, this.f22390c, this.f22396i);
    }

    /* renamed from: c */
    public C2955v m18950c() {
        return new C2955v(this.f22397j.mo4078a(), this.f22398k, this.f22388a, this.f22396i);
    }

    /* renamed from: d */
    public C2956w m18952d() {
        return new C2956w(this.f22397j.mo4078a(), this.f22398k, this.f22388a, this.f22396i);
    }

    /* renamed from: e */
    public C5610x m18954e() {
        return new C5610x(this.f22397j.mo4078a(), this.f22398k, this.f22388a);
    }

    /* renamed from: a */
    public au m18945a(av<C2952d>[] thumbnailProducers) {
        return new au(thumbnailProducers);
    }

    /* renamed from: f */
    public C5614z m18956f() {
        return new C5614z(this.f22397j.mo4078a(), this.f22398k, this.f22396i);
    }

    /* renamed from: g */
    public aa m18957g() {
        return new aa(this.f22397j.mo4078a(), this.f22398k, this.f22389b, this.f22396i);
    }

    /* renamed from: h */
    public ab m18959h() {
        return new ab(this.f22397j.mo4078a());
    }

    /* renamed from: a */
    public ad m18942a(ae networkFetcher) {
        return new ad(this.f22398k, this.f22391d, networkFetcher);
    }

    /* renamed from: i */
    public static <T> af<T> m18940i() {
        return new af();
    }

    /* renamed from: i */
    public ag m18961i(ai<C2921a<C5534b>> inputProducer) {
        return new ag(this.f22402o, this.f22403p, inputProducer);
    }

    /* renamed from: j */
    public ah m18962j(ai<C2921a<C5534b>> inputProducer) {
        return new ah(inputProducer, this.f22405r, this.f22397j.mo4081d());
    }

    /* renamed from: k */
    public an m18963k(ai<C2952d> inputProducer) {
        return new an(this.f22397j.mo4081d(), this.f22398k, inputProducer);
    }

    /* renamed from: l */
    public static <T> aq<T> m18941l(ai<T> inputProducer) {
        return new aq(inputProducer);
    }

    /* renamed from: a */
    public <T> ar<T> m18943a(ai<T> inputProducer, as inputThreadHandoffProducerQueue) {
        return new ar(inputProducer, inputThreadHandoffProducerQueue);
    }

    /* renamed from: a */
    public <T> at<T> m18944a(int maxSimultaneousRequests, ai<T> inputProducer) {
        return new at(maxSimultaneousRequests, this.f22397j.mo4082e(), inputProducer);
    }

    /* renamed from: m */
    public ax m18964m(ai<C2952d> inputProducer) {
        return new ax(this.f22397j.mo4081d(), this.f22398k, inputProducer);
    }
}
