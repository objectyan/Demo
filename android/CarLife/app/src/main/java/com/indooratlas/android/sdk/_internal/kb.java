package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.kd.C5997a;
import java.nio.ByteBuffer;

public final class kb extends ke implements ka {
    /* renamed from: a */
    static final ByteBuffer f24544a = ByteBuffer.allocate(0);
    /* renamed from: f */
    private int f24545f;
    /* renamed from: g */
    private String f24546g;

    public kb() {
        super(C5997a.CLOSING);
        mo4810a(true);
    }

    public kb(byte b) throws ju {
        super(C5997a.CLOSING);
        mo4810a(true);
        m21467a(1000, "");
    }

    public kb(int i, String str) throws ju {
        super(C5997a.CLOSING);
        mo4810a(true);
        m21467a(i, str);
    }

    /* renamed from: a */
    private void m21467a(int i, String str) throws ju {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = 1005;
        }
        if (i != 1005) {
            byte[] a = kp.m21499a(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(a.length + 2);
            allocate2.put(allocate);
            allocate2.put(a);
            allocate2.rewind();
            mo4809a(allocate2);
        } else if (str2.length() > 0) {
            throw new ju(1002, "A close frame must have a closecode if it has a reason");
        }
    }

    /* renamed from: a */
    public final int mo4816a() {
        return this.f24545f;
    }

    /* renamed from: b */
    public final String mo4817b() {
        return this.f24546g;
    }

    public final String toString() {
        return super.toString() + "code: " + this.f24545f;
    }

    /* renamed from: a */
    public final void mo4809a(ByteBuffer byteBuffer) throws ju {
        super.mo4809a(byteBuffer);
        this.f24545f = 1005;
        ByteBuffer c = super.mo4812c();
        c.mark();
        if (c.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(c.getShort());
            allocate.position(0);
            this.f24545f = allocate.getInt();
            if (this.f24545f == 1006 || this.f24545f == 1015 || this.f24545f == 1005 || this.f24545f > 4999 || this.f24545f < 1000 || this.f24545f == 1004) {
                throw new jv("closecode must not be sent over the wire: " + this.f24545f);
            }
        }
        c.reset();
        if (this.f24545f == 1005) {
            this.f24546g = kp.m21497a(super.mo4812c());
            return;
        }
        allocate = super.mo4812c();
        int position = allocate.position();
        try {
            allocate.position(allocate.position() + 2);
            this.f24546g = kp.m21497a(allocate);
            allocate.position(position);
        } catch (Throwable e) {
            throw new jv(e);
        } catch (Throwable th) {
            allocate.position(position);
        }
    }

    /* renamed from: c */
    public final ByteBuffer mo4812c() {
        if (this.f24545f == 1005) {
            return f24544a;
        }
        return super.mo4812c();
    }
}
