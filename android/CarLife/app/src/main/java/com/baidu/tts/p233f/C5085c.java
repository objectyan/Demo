package com.baidu.tts.p233f;

import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.che.codriver.sdk.p081a.C2578b;

/* compiled from: Bitrate */
/* renamed from: com.baidu.tts.f.c */
public enum C5085c {
    BV_16K("BV_16K", "0", 8.0d),
    AMR_6K6("AMR_6K6", "0", 15.6d),
    AMR_8K85("AMR_8K85", "1", 15.6d),
    AMR_12K65("AMR_12K65", "2", 15.6d),
    AMR_14K25("AMR_14K25", "3", 15.6d),
    AMR_15K85("AMR_15K85", "4", 15.6d),
    AMR_18K25("AMR_18K25", "5", 15.6d),
    AMR_19K85("AMR_19K85", C2578b.f8568g, 15.6d),
    AMR_23K05("AMR_23K05", "7", 15.6d),
    AMR_23K85("AMR_23K85", NaviCmdConstants.ACTION_TYPE_PREFER_MODE_MIN_TOLL, 15.6d),
    OPUS_8K("OPUS_8K", "0", 15.0d),
    OPUS_16K("OPUS_16K", "1", 15.0d),
    OPUS_18K("OPUS_18K", "2", 15.0d),
    OPUS_20K("OPUS_20K", "3", 15.0d),
    OPUS_24K("OPUS_24K", "4", 15.0d),
    OPUS_32K("OPUS_32K", "5", 15.0d),
    MP3_8K("MP3_8K", "0", 10.0d),
    MP3_11K("MP3_11K", "1", 10.0d),
    MP3_16K("MP3_16K", "2", 10.0d),
    MP3_24K("MP3_24K", "3", 10.0d),
    MP3_32K("MP3_32K", "4", 10.0d);
    
    /* renamed from: v */
    private final String f21028v;
    /* renamed from: w */
    private final String f21029w;
    /* renamed from: x */
    private final double f21030x;

    private C5085c(String str, String str2, double d) {
        this.f21028v = str;
        this.f21029w = str2;
        this.f21030x = d;
    }

    /* renamed from: a */
    public String m17266a() {
        return this.f21029w;
    }

    /* renamed from: b */
    public double m17267b() {
        return this.f21030x;
    }

    /* renamed from: a */
    public static C5085c m17262a(String str) {
        for (C5085c c5085c : C5085c.values()) {
            if (c5085c.m17266a().equals(str)) {
                return c5085c;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static C5085c[] m17263c() {
        return new C5085c[]{BV_16K};
    }

    /* renamed from: d */
    public static C5085c[] m17264d() {
        return new C5085c[]{AMR_6K6, AMR_8K85, AMR_12K65, AMR_14K25, AMR_15K85, AMR_18K25, AMR_19K85, AMR_23K05, AMR_23K85};
    }

    /* renamed from: e */
    public static C5085c[] m17265e() {
        return new C5085c[]{OPUS_8K, OPUS_16K, OPUS_18K, OPUS_20K, OPUS_24K, OPUS_32K};
    }
}
