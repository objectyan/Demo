package com.baidu.che.codriver.vr.record.outside;

import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.vr.record.C1749d;
import com.baidu.che.codriver.vr.record.C2852a;

/* compiled from: OutsideDataReceiver */
/* renamed from: com.baidu.che.codriver.vr.record.outside.a */
public class C2865a extends Thread {
    /* renamed from: a */
    private static final int f9381a = 5000;
    /* renamed from: b */
    private static final String f9382b = "OutsideData";
    /* renamed from: c */
    private C2852a f9383c;
    /* renamed from: d */
    private C1749d f9384d;

    public C2865a(C2852a pcmWritor, C1749d tool) {
        this.f9383c = pcmWritor;
        this.f9384d = tool;
        C2725h.m10207b(f9382b, "--OutsideDataReceiver()----");
    }

    public void run() {
        byte[] inputData = new byte[5000];
        int dataLength = 0;
        while (dataLength != -1) {
            if (this.f9384d == null) {
                this.f9383c.mo1979a(null, 0, -1);
                break;
            } else {
                dataLength = this.f9384d.mo1631a(inputData);
                this.f9383c.mo1979a(inputData, 0, dataLength);
            }
        }
    }
}
