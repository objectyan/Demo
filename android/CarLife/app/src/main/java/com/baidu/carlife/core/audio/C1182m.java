package com.baidu.carlife.core.audio;

import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.connect.C1218e;
import com.baidu.carlife.core.connect.p070a.C1200b;
import com.baidu.carlife.core.connect.p070a.C1208e;
import com.baidu.platform.comapi.UIMsg.m_AppUI;

/* compiled from: NaviAudioManager */
/* renamed from: com.baidu.carlife.core.audio.m */
public class C1182m extends C1172f {
    /* renamed from: a */
    private static final String f3114a = (C1163a.f3010n + C1182m.class.getSimpleName());
    /* renamed from: b */
    private C1186o f3115b = new C1186o();
    /* renamed from: c */
    private byte[] f3116c = new byte[120];
    /* renamed from: d */
    private int f3117d;
    /* renamed from: e */
    private int f3118e;
    /* renamed from: f */
    private C1187p f3119f = new C1187p();
    /* renamed from: g */
    private C1167c f3120g = new C1167c();
    /* renamed from: h */
    private C1200b f3121h = new C1200b();

    public C1182m() {
        C1163a.m3882a();
        this.f3118e = 12;
    }

    /* renamed from: a */
    public synchronized void mo1448a(int sampleRate, int channelConfig, int sampleFormat) {
        if (C1163a.m3883h()) {
            int revisedSampleRate;
            int revisedChannelConfig;
            int revisedFormat;
            C1260i.m4435b(f3114a, "sampleRate: " + sampleRate + " channelConfig: " + channelConfig + " sampleFormat: " + sampleFormat);
            if (sampleRate < m_AppUI.MSG_APP_SAVESCREEN || sampleRate > 48000) {
                revisedSampleRate = 16000;
            } else {
                revisedSampleRate = sampleRate;
            }
            if (channelConfig == 1 && channelConfig == 2) {
                revisedChannelConfig = channelConfig;
            } else {
                revisedChannelConfig = 1;
            }
            if (sampleFormat == 8 && sampleFormat == 16) {
                revisedFormat = sampleFormat;
            } else {
                revisedFormat = 16;
            }
            this.f3115b.m4053c(C1253f.bv);
            this.f3117d = this.f3115b.m4050b(revisedSampleRate, revisedChannelConfig, revisedFormat, this.f3116c);
            this.f3115b.m4047a(this.f3117d);
            System.arraycopy(this.f3115b.m4048a(), 0, this.f3116c, 0, this.f3118e);
            m4034b(this.f3116c, this.f3118e + this.f3117d);
        }
    }

    /* renamed from: a */
    public synchronized void mo1434a() {
        if (C1163a.m3883h()) {
            this.f3115b.m4053c(C1253f.bw);
            this.f3115b.m4047a(0);
            m4034b(this.f3115b.m4048a(), this.f3115b.m4049b());
        }
    }

    /* renamed from: a */
    public synchronized void mo1449a(byte[] ttsPCMData, int dataLen) {
        byte[] sendData = ttsPCMData;
        int sendLen = dataLen;
        if (C1208e.m4120a().m4135c() && dataLen > 0) {
            sendData = this.f3121h.m4112a(ttsPCMData, dataLen);
            if (sendData == null) {
                C1260i.m4445e(f3114a, "encrypt failed!");
            } else {
                sendLen = sendData.length;
            }
        }
        if (C1163a.m3883h()) {
            this.f3115b.m4053c(C1253f.bx);
            this.f3115b.m4047a(sendLen);
            this.f3115b.m4052c();
            this.f3120g.m3909a(this.f3115b.m4048a(), this.f3118e, sendData, sendLen, this.f3119f);
            m4034b(this.f3119f.m4057a(), this.f3119f.m4058b());
        }
    }

    /* renamed from: b */
    private int m4034b(byte[] data, int size) {
        if (C1163a.m3882a().m3895g()) {
            return -1;
        }
        return C1218e.m4228a().m4247e(data, size);
    }
}
