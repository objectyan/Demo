package com.baidu.che.codriver.p117c;

import com.netease.cloudmusic.utils.NeteaseMusicUtils;

/* compiled from: MusicModel */
/* renamed from: com.baidu.che.codriver.c.a */
public class C2523a {
    /* renamed from: a */
    public static final int f8251a = 0;
    /* renamed from: b */
    public static final int f8252b = 1;
    /* renamed from: c */
    public static final int f8253c = 2;
    /* renamed from: d */
    public String f8254d;
    /* renamed from: e */
    public String f8255e;
    /* renamed from: f */
    public String f8256f;
    /* renamed from: g */
    public long f8257g;
    /* renamed from: h */
    public long f8258h;
    /* renamed from: i */
    public String f8259i;
    /* renamed from: j */
    public String f8260j;
    /* renamed from: k */
    public boolean f8261k;
    /* renamed from: l */
    public int f8262l;
    /* renamed from: m */
    private String f8263m;

    /* renamed from: a */
    public String m9575a() {
        if (this.f8262l == 1) {
            return NeteaseMusicUtils.getMusicUrlById(this.f8254d);
        }
        return this.f8263m;
    }

    public String toString() {
        return "MusicModel{albumName='" + this.f8256f + '\'' + ", name='" + this.f8255e + '\'' + ", id='" + this.f8254d + '\'' + ", albumArtistName='" + this.f8259i + '\'' + ", albumArtistId=" + this.f8258h + ", albumId=" + this.f8257g + ", coverUrl='" + this.f8260j + '\'' + ", musicProvider=" + this.f8262l + '}';
    }
}
