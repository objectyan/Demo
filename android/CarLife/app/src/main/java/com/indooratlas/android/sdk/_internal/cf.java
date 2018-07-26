package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import com.indooratlas.algorithm.ClientProcessingManager;

public final class cf extends ds {
    /* renamed from: a */
    private ClientProcessingManager f23304a;
    /* renamed from: b */
    private long f23305b;
    /* renamed from: d */
    private long f23306d;
    /* renamed from: e */
    private long f23307e;
    /* renamed from: f */
    private cr f23308f;
    /* renamed from: g */
    private long f23309g = -1;

    public cf(ClientProcessingManager clientProcessingManager, cr crVar) {
        this.f23304a = clientProcessingManager;
        this.f23308f = crVar;
    }

    @TargetApi(22)
    /* renamed from: a */
    public final void mo4616a(cx cxVar, dd ddVar) {
        int i;
        int a = cxVar.f23358a.mo4658a();
        switch (a) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 4:
                i = 1;
                break;
            case 6:
                i = 5;
                break;
            case 14:
                i = 0;
                break;
            default:
                String str = cz.f23362a;
                new Object[1][0] = Integer.valueOf(a);
                i = -1;
                break;
        }
        if (i != -1) {
            C5852do c5852do = (C5852do) cxVar.f23360c;
            float[] fArr = c5852do.f23426d;
            long nanoTime = System.nanoTime();
            if (cxVar.f23358a.mo4658a() == 1) {
                long a2 = this.f23308f.mo4654a();
                if (this.f23309g < 0 || a2 - this.f23309g > 1000 || a2 < this.f23309g) {
                    this.f23304a.setTime(this.f23308f.mo4654a(), c5852do.f23425c);
                    this.f23309g = a2;
                }
            }
            switch (i) {
                case 5:
                    this.f23304a.addSampleIMU(i, cxVar.f23359b, (double) fArr[0], 0.0d, 0.0d);
                    break;
                default:
                    this.f23304a.addSampleIMU(i, cxVar.f23359b, (double) fArr[0], (double) fArr[1], (double) fArr[2]);
                    break;
            }
            if (cxVar.f23358a.mo4658a() == 14) {
                this.f23305b++;
                if (this.f23305b % 5 == 0 && fArr.length == 6) {
                    Object[] objArr = new Object[]{Double.valueOf((double) fArr[3]), Double.valueOf((double) fArr[4]), Double.valueOf((double) fArr[5]), Integer.valueOf(c5852do.f23423a)};
                    int i2 = c5852do.f23423a;
                    if (!(i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3)) {
                        i2 = 0;
                    }
                    this.f23304a.setDeviceBias(r2, r4, r6, i2);
                }
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (nanoTime2 > this.f23306d) {
                this.f23306d = nanoTime2;
                if (cs.f23352a) {
                    new Object[1][0] = Double.valueOf(((double) nanoTime2) / 1000000.0d);
                }
            }
            this.f23307e = cxVar.f23359b;
        }
        super.mo4616a(cxVar, ddVar);
    }
}
