package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.kd.C5997a;
import java.net.InetSocketAddress;

public abstract class jk implements jm {
    /* renamed from: g */
    public final kn mo4783g() throws ju {
        return new kj();
    }

    /* renamed from: a */
    public void mo4780a(jj jjVar, kf kfVar) throws ju {
    }

    /* renamed from: c */
    public void mo4782c(kd kdVar) {
    }

    /* renamed from: a */
    public void mo4779a(jj jjVar, kd kdVar) {
        kd keVar = new ke(kdVar);
        keVar.mo4808a(C5997a.PONG);
        jjVar.mo4784b(keVar);
    }

    /* renamed from: b */
    public void mo4781b(jj jjVar, kd kdVar) {
    }

    /* renamed from: a */
    public final String mo4778a(jj jjVar) throws ju {
        InetSocketAddress c = jjVar.mo4785c();
        if (c == null) {
            throw new jw("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(c.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
