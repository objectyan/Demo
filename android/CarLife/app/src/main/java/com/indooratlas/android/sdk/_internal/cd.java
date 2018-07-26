package com.indooratlas.android.sdk._internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class cd implements aw {
    public static final Creator<cd> CREATOR = new C58351();
    @NonNull
    /* renamed from: a */
    public final em f23298a;
    /* renamed from: b */
    private final String f23299b;
    /* renamed from: c */
    private final int f23300c;
    /* renamed from: d */
    private final JSONObject f23301d;
    @Nullable
    /* renamed from: e */
    private final Long f23302e;
    @Nullable
    /* renamed from: f */
    private final Long f23303f;

    /* renamed from: com.indooratlas.android.sdk._internal.cd$1 */
    static class C58351 implements Creator<cd> {
        C58351() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new cd[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new cd(parcel);
        }
    }

    protected cd(Parcel parcel) throws IllegalArgumentException {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            Object obj = new double[2];
            parcel.readDoubleArray(obj);
            arrayList.add(obj);
        }
        this.f23299b = parcel.readString();
        try {
            this.f23301d = new JSONObject(parcel.readString());
            Integer num = (Integer) parcel.readValue(Integer.class.getClassLoader());
            this.f23302e = (Long) parcel.readValue(Long.class.getClassLoader());
            this.f23303f = (Long) parcel.readValue(Long.class.getClassLoader());
            this.f23300c = parcel.readInt();
            this.f23298a = new em(arrayList, num);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public final boolean mo4648a(double d, double d2, Integer num) {
        return this.f23298a.m20423a(new ep(d, d2, num));
    }

    /* renamed from: a */
    public final String mo4647a() {
        return this.f23299b;
    }

    /* renamed from: b */
    public final int mo4649b() {
        return this.f23300c;
    }

    /* renamed from: c */
    public final Long mo4650c() {
        return this.f23302e;
    }

    /* renamed from: d */
    public final boolean mo4651d() {
        return this.f23302e != null;
    }

    /* renamed from: e */
    public final boolean mo4652e() {
        return this.f23303f != null;
    }

    /* renamed from: f */
    public final Long mo4653f() {
        return this.f23303f;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        cd cdVar = (cd) o;
        if (!this.f23298a.equals(cdVar.f23298a)) {
            return false;
        }
        if (!this.f23299b.equals(cdVar.f23299b)) {
            return false;
        }
        if (!this.f23301d.toString().equals(cdVar.f23301d.toString())) {
            return false;
        }
        if (this.f23302e != null && cdVar.f23302e != null && !this.f23302e.equals(cdVar.f23302e)) {
            return false;
        }
        if (this.f23302e != null && cdVar.f23302e == null) {
            return false;
        }
        if (this.f23302e == null && cdVar.f23302e != null) {
            return false;
        }
        if (this.f23303f != null && cdVar.f23303f != null && !this.f23303f.equals(cdVar.f23303f)) {
            return false;
        }
        if (this.f23303f != null && cdVar.f23303f == null) {
            return false;
        }
        if (this.f23303f == null && cdVar.f23303f != null) {
            return false;
        }
        if (this.f23300c != cdVar.f23300c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.f23298a.hashCode() + 37;
        char[] toCharArray = this.f23299b.toCharArray();
        int i2 = 0;
        while (i2 < toCharArray.length) {
            int i3 = toCharArray[i2] + (hashCode * 37);
            i2++;
            hashCode = i3;
        }
        i2 = hashCode;
        for (char c : this.f23301d.toString().toCharArray()) {
            i2 = (i2 * 37) + c;
        }
        hashCode = (this.f23302e == null ? 0 : (int) (this.f23302e.longValue() ^ (this.f23302e.longValue() >>> 32))) + (i2 * 37);
        if (this.f23303f != null) {
            i = (int) (this.f23303f.longValue() ^ (this.f23303f.longValue() >>> 32));
        }
        return (((hashCode * 37) + i) * 37) + this.f23300c;
    }

    public final String toString() {
        return "IAGeofence{id=" + this.f23299b + ",edges=" + this.f23298a.f23518a.toString() + ",transitionTypes=" + ((this.f23300c & 1) > 0 ? "ENTER " : "") + ((this.f23300c & 16) > 0 ? "EXIT " : "") + ((this.f23300c & 256) > 0 ? "DWELL" : "") + ",payload=" + this.f23301d.toString() + ",floor=" + (this.f23298a.f23519b != null ? this.f23298a.f23519b.toString() : "null") + ",loiteringDelay=" + (this.f23302e != null ? this.f23302e.toString() : "null") + ",expirationTime=" + (this.f23303f != null ? this.f23303f.toString() : "null") + '}';
    }

    public final void writeToParcel(Parcel dest, int i) {
        eq eqVar = this.f23298a.f23518a;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < eqVar.f23528a.size() - 1; i2++) {
            arrayList.add(eqVar.f23528a.get(i2));
        }
        dest.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            dest.writeDoubleArray((double[]) it.next());
        }
        dest.writeString(this.f23299b);
        dest.writeString(this.f23301d.toString());
        dest.writeValue(this.f23298a.f23519b);
        dest.writeValue(this.f23302e);
        dest.writeValue(this.f23303f);
        dest.writeInt(this.f23300c);
    }
}
