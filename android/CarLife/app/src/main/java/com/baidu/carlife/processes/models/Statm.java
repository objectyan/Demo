package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

public final class Statm extends ProcFile {
    public static final Creator<Statm> CREATOR = new C20361();
    /* renamed from: a */
    public final String[] f6573a;

    /* renamed from: com.baidu.carlife.processes.models.Statm$1 */
    static class C20361 implements Creator<Statm> {
        C20361() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7869a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7870a(i);
        }

        /* renamed from: a */
        public Statm m7869a(Parcel source) {
            return new Statm(source);
        }

        /* renamed from: a */
        public Statm[] m7870a(int size) {
            return new Statm[size];
        }
    }

    /* renamed from: a */
    public static Statm m7871a(int pid) throws IOException {
        return new Statm(String.format("/proc/%d/statm", new Object[]{Integer.valueOf(pid)}));
    }

    private Statm(String path) throws IOException {
        super(path);
        this.f6573a = this.b.split("\\s+");
    }

    private Statm(Parcel in) {
        super(in);
        this.f6573a = in.createStringArray();
    }

    /* renamed from: a */
    public long m7872a() {
        return Long.parseLong(this.f6573a[0]) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    /* renamed from: b */
    public long m7873b() {
        return Long.parseLong(this.f6573a[1]) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeStringArray(this.f6573a);
    }
}
