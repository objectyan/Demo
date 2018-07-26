package com.indooratlas.android.sdk._internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class ay implements Parcelable {
    public static final Creator<ay> CREATOR = new C57761();
    /* renamed from: a */
    final int f23028a;
    /* renamed from: b */
    private final List<aw> f23029b;

    /* renamed from: com.indooratlas.android.sdk._internal.ay$1 */
    static class C57761 implements Creator<ay> {
        C57761() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ay[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ay(parcel);
        }
    }

    protected ay(Parcel parcel) {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            arrayList.add((aw) parcel.readParcelable(cd.class.getClassLoader()));
        }
        this.f23029b = arrayList;
        this.f23028a = parcel.readInt();
    }

    /* renamed from: a */
    public final List<aw> m19894a() {
        List<aw> arrayList = new ArrayList();
        arrayList.addAll(this.f23029b);
        return arrayList;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f23029b.size());
        for (aw awVar : this.f23029b) {
            dest.writeParcelable((cd) awVar, flags);
        }
        dest.writeInt(this.f23028a);
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ay ayVar = (ay) o;
        if (this.f23028a != ayVar.f23028a) {
            return false;
        }
        if (this.f23029b.size() != ayVar.f23029b.size()) {
            return false;
        }
        int size = this.f23029b.size();
        for (int i = 0; i < size; i++) {
            if (!((aw) this.f23029b.get(i)).equals(ayVar.f23029b.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (aw hashCode : this.f23029b) {
            i = hashCode.hashCode() + (i * 37);
        }
        return (i * 37) + this.f23028a;
    }
}
