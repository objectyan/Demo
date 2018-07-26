package com.baidu.carlife.model;

import com.baidu.carlife.platform.model.CLAlbum;

/* compiled from: MusicAlbumModel */
/* renamed from: com.baidu.carlife.model.i */
public class C1929i {
    /* renamed from: a */
    public String f6053a = null;
    /* renamed from: b */
    public String f6054b = null;
    /* renamed from: c */
    public String f6055c = null;
    /* renamed from: d */
    public int f6056d = -1;

    public C1929i(CLAlbum album) {
        this.f6055c = album.albumId;
        this.f6054b = album.coverUrl;
        this.f6053a = album.albumName;
    }
}
