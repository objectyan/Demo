package com.baidu.carlife.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.carlife.platform.model.CLSong;

public class MusicSongModel implements Parcelable {
    public static final Creator<MusicSongModel> CREATOR = new C19181();
    /* renamed from: a */
    public String f5909a;
    /* renamed from: b */
    public String f5910b;
    /* renamed from: c */
    public String f5911c;
    /* renamed from: d */
    public String f5912d;
    /* renamed from: e */
    public String f5913e;
    /* renamed from: f */
    public String f5914f;
    /* renamed from: g */
    public String f5915g;
    /* renamed from: h */
    public Bitmap f5916h;
    /* renamed from: i */
    public String f5917i;
    /* renamed from: j */
    public int f5918j = 0;
    /* renamed from: k */
    public boolean f5919k;
    /* renamed from: l */
    public boolean f5920l;
    /* renamed from: m */
    public String f5921m;
    /* renamed from: n */
    public long f5922n;
    /* renamed from: o */
    public long f5923o;
    /* renamed from: p */
    public String f5924p;
    /* renamed from: q */
    public int f5925q = -1;
    /* renamed from: r */
    public int f5926r;
    /* renamed from: s */
    public int f5927s;

    /* renamed from: com.baidu.carlife.model.MusicSongModel$1 */
    static class C19181 implements Creator<MusicSongModel> {
        C19181() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7340a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7341a(i);
        }

        /* renamed from: a */
        public MusicSongModel m7340a(Parcel source) {
            return new MusicSongModel(source);
        }

        /* renamed from: a */
        public MusicSongModel[] m7341a(int size) {
            return new MusicSongModel[size];
        }
    }

    public MusicSongModel(CLSong song) {
        if (song != null) {
            this.f5913e = song.albumArtistId;
            this.f5914f = song.albumArtistName;
            this.f5912d = song.albumId;
            this.f5911c = song.albumName;
            this.f5915g = song.coverUrl;
            this.f5917i = song.duration;
            this.f5909a = song.id;
            this.f5921m = song.mediaUrl;
            this.f5910b = song.name;
            this.f5923o = song.totalSize;
            if (TextUtils.isEmpty(this.f5911c)) {
                this.f5911c = "unknow";
            }
            if (TextUtils.isEmpty(this.f5914f)) {
                this.f5914f = "unknow";
            }
            if (TextUtils.isEmpty(this.f5910b)) {
                this.f5910b = "unknow";
            }
        }
    }

    public MusicSongModel(Parcel pl) {
        this.f5909a = pl.readString();
        this.f5910b = pl.readString();
        this.f5911c = pl.readString();
        this.f5912d = pl.readString();
        this.f5913e = pl.readString();
        this.f5914f = pl.readString();
        this.f5915g = pl.readString();
        this.f5917i = pl.readString();
        this.f5918j = pl.readInt();
        if (pl.readInt() == 1) {
            this.f5919k = true;
        } else {
            this.f5919k = false;
        }
        if (pl.readInt() == 1) {
            this.f5920l = true;
        } else {
            this.f5920l = false;
        }
        this.f5921m = pl.readString();
        this.f5922n = pl.readLong();
        this.f5923o = pl.readLong();
        this.f5924p = pl.readString();
    }

    /* renamed from: a */
    public String m7342a() {
        return this.f5909a;
    }

    /* renamed from: a */
    public void m7345a(String id) {
        this.f5909a = id;
    }

    /* renamed from: b */
    public String m7347b() {
        return this.f5910b;
    }

    /* renamed from: b */
    public void m7350b(String name) {
        this.f5910b = name;
    }

    /* renamed from: c */
    public String m7352c() {
        return this.f5911c;
    }

    /* renamed from: c */
    public void m7354c(String albumName) {
        this.f5911c = albumName;
    }

    /* renamed from: d */
    public String m7355d() {
        return this.f5912d;
    }

    /* renamed from: d */
    public void m7357d(String albumId) {
        this.f5912d = albumId;
    }

    /* renamed from: e */
    public String m7358e() {
        return this.f5913e;
    }

    /* renamed from: e */
    public void m7359e(String albumArtistId) {
        this.f5913e = albumArtistId;
    }

    /* renamed from: f */
    public String m7360f() {
        return this.f5914f;
    }

    /* renamed from: f */
    public void m7361f(String albumArtistName) {
        this.f5914f = albumArtistName;
    }

    /* renamed from: g */
    public String m7362g() {
        return this.f5915g;
    }

    /* renamed from: g */
    public void m7363g(String coverUrl) {
        this.f5915g = coverUrl;
    }

    /* renamed from: h */
    public String m7364h() {
        return this.f5917i;
    }

    /* renamed from: h */
    public void m7365h(String duration) {
        this.f5917i = duration;
    }

    /* renamed from: i */
    public int m7366i() {
        return this.f5918j;
    }

    /* renamed from: a */
    public void m7343a(int curTime) {
        this.f5918j = curTime;
    }

    /* renamed from: j */
    public boolean m7369j() {
        return this.f5919k;
    }

    /* renamed from: a */
    public void m7346a(boolean isPlaying) {
        this.f5919k = isPlaying;
    }

    /* renamed from: k */
    public boolean m7370k() {
        return this.f5920l;
    }

    /* renamed from: b */
    public void m7351b(boolean isBuffering) {
        this.f5920l = isBuffering;
    }

    /* renamed from: l */
    public String m7371l() {
        return this.f5921m;
    }

    /* renamed from: i */
    public void m7367i(String mediaUrl) {
        this.f5921m = mediaUrl;
    }

    /* renamed from: m */
    public long m7372m() {
        return this.f5922n;
    }

    /* renamed from: a */
    public void m7344a(long downloadedSize) {
        this.f5922n = downloadedSize;
    }

    /* renamed from: n */
    public long m7373n() {
        return this.f5923o;
    }

    /* renamed from: b */
    public void m7349b(long totalSize) {
        this.f5923o = totalSize;
    }

    /* renamed from: o */
    public String m7374o() {
        return this.f5924p;
    }

    /* renamed from: j */
    public void m7368j(String initial) {
        this.f5924p = initial;
    }

    /* renamed from: b */
    public void m7348b(int type) {
        this.f5925q = type;
    }

    /* renamed from: p */
    public int m7375p() {
        return this.f5926r;
    }

    /* renamed from: c */
    public void m7353c(int format) {
        this.f5926r = format;
    }

    /* renamed from: q */
    public int m7376q() {
        return this.f5927s;
    }

    /* renamed from: d */
    public void m7356d(int favorite) {
        this.f5927s = favorite;
    }

    /* renamed from: r */
    public int m7377r() {
        return this.f5925q;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f5909a);
        dest.writeString(this.f5910b);
        dest.writeString(this.f5911c);
        dest.writeString(this.f5912d);
        dest.writeString(this.f5913e);
        dest.writeString(this.f5914f);
        dest.writeString(this.f5915g);
        dest.writeString(this.f5917i);
        dest.writeInt(this.f5918j);
        if (this.f5919k) {
            dest.writeInt(1);
        } else {
            dest.writeInt(0);
        }
        if (this.f5920l) {
            dest.writeInt(1);
        } else {
            dest.writeInt(0);
        }
        dest.writeString(this.f5921m);
        dest.writeLong(this.f5922n);
        dest.writeLong(this.f5923o);
        dest.writeString(this.f5924p);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof MusicSongModel) {
            MusicSongModel song = (MusicSongModel) o;
            if (!TextUtils.isEmpty(song.f5909a) && song.f5909a.equals(this.f5909a)) {
                return true;
            }
        }
        return false;
    }
}
