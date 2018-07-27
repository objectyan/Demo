package com.baidu.carlife.model;

import android.graphics.Bitmap;

/* compiled from: MusicAppModel */
/* renamed from: com.baidu.carlife.model.j */
public class C1931j extends C1930o {
    /* renamed from: a */
    public boolean f6066a;
    /* renamed from: b */
    public int f6067b;
    /* renamed from: c */
    public int f6068c;
    /* renamed from: d */
    public Bitmap f6069d;
    /* renamed from: e */
    public int f6070e;

    public C1931j(String name, int imageId, int type, String packageName) {
        this.f6067b = -1;
        this.f6068c = -1;
        this.f6069d = null;
        this.f6070e = 0;
        this.l = name;
        this.m = packageName;
        this.f6067b = imageId;
        this.f6066a = false;
        this.f6068c = type;
        this.g = 0;
    }

    public C1931j(C1930o app, int type) {
        this.f6067b = -1;
        this.f6068c = -1;
        this.f6069d = null;
        this.f6070e = 0;
        this.i = app.f6060i;
        this.k = app.f6062k;
        this.j = app.f6061j;
        this.h = app.f6059h;
        this.l = app.f6063l;
        this.m = app.f6064m;
        this.n = app.f6065n;
        this.f6068c = type;
        this.g = 0;
    }

    public C1931j() {
        this.f6067b = -1;
        this.f6068c = -1;
        this.f6069d = null;
        this.f6070e = 0;
        this.g = 0;
    }
}
