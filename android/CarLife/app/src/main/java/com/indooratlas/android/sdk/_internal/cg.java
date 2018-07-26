package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;

public class cg extends ds {
    /* renamed from: b */
    cr f23101b;

    public cg(cr crVar) {
        this.f23101b = crVar;
    }

    /* renamed from: a */
    public final void mo4616a(cx cxVar, dd ddVar) {
        if (cxVar.m20277b()) {
            dq dqVar;
            if (cxVar.m20277b()) {
                dqVar = (dq) cxVar.f23360c;
            } else {
                dqVar = null;
            }
            if (dqVar != null) {
                IALocation a = ct.m20252a(cxVar);
                if (a != null) {
                    Builder newBuilder = a.newBuilder();
                    newBuilder.withLongExtra("com.indooratlas.android.sdk.intent.extras.clientTime", this.f23101b.mo4654a());
                    if (dqVar.f23441j != null) {
                        newBuilder.withIntExtra("com.indooratlas.android.sdk.intent.extras.satelliteCount", dqVar.f23441j.intValue());
                    }
                    mo4620a(newBuilder.build());
                }
            }
        }
        super.mo4616a(cxVar, ddVar);
    }

    /* renamed from: a */
    public void mo4620a(IALocation... iALocationArr) {
    }
}
