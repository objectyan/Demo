package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.kd.C5997a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class ke implements kc {
    /* renamed from: b */
    protected static byte[] f24539b = new byte[0];
    /* renamed from: a */
    private ByteBuffer f24540a;
    /* renamed from: c */
    protected boolean f24541c;
    /* renamed from: d */
    protected C5997a f24542d;
    /* renamed from: e */
    protected boolean f24543e;

    public ke(C5997a c5997a) {
        this.f24542d = c5997a;
        this.f24540a = ByteBuffer.wrap(f24539b);
    }

    public ke(kd kdVar) {
        this.f24541c = kdVar.mo4813d();
        this.f24542d = kdVar.mo4815f();
        this.f24540a = kdVar.mo4812c();
        this.f24543e = kdVar.mo4814e();
    }

    /* renamed from: d */
    public final boolean mo4813d() {
        return this.f24541c;
    }

    /* renamed from: f */
    public final C5997a mo4815f() {
        return this.f24542d;
    }

    /* renamed from: e */
    public final boolean mo4814e() {
        return this.f24543e;
    }

    /* renamed from: c */
    public ByteBuffer mo4812c() {
        return this.f24540a;
    }

    /* renamed from: a */
    public final void mo4810a(boolean z) {
        this.f24541c = z;
    }

    /* renamed from: a */
    public final void mo4808a(C5997a c5997a) {
        this.f24542d = c5997a;
    }

    /* renamed from: a */
    public void mo4809a(ByteBuffer byteBuffer) throws ju {
        this.f24540a = byteBuffer;
    }

    /* renamed from: b */
    public final void mo4811b(boolean z) {
        this.f24543e = z;
    }

    public String toString() {
        return "Framedata{ optcode:" + this.f24542d + ", fin:" + this.f24541c + ", payloadlength:[pos:" + this.f24540a.position() + ", len:" + this.f24540a.remaining() + "], payload:" + Arrays.toString(kp.m21499a(new String(this.f24540a.array()))) + "}";
    }
}
