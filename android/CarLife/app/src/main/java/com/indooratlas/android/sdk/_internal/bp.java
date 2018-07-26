package com.indooratlas.android.sdk._internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bp implements Parcelable {
    public static final Creator<bp> CREATOR = new C58231();
    /* renamed from: a */
    public final int f23220a;
    /* renamed from: b */
    public final int f23221b;
    /* renamed from: c */
    public final Bundle f23222c;

    /* renamed from: com.indooratlas.android.sdk._internal.bp$1 */
    static class C58231 implements Creator<bp> {
        C58231() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new bp[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new bp(parcel);
        }
    }

    private bp(Parcel parcel) {
        this.f23220a = parcel.readInt();
        this.f23221b = parcel.readInt();
        this.f23222c = parcel.readBundle();
    }

    public bp(int i) {
        this.f23220a = 1;
        this.f23221b = i;
        this.f23222c = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel dest, int i) {
        dest.writeInt(this.f23220a);
        dest.writeInt(this.f23221b);
        dest.writeBundle(this.f23222c);
    }

    public final String toString() {
        return "IAServiceState{category=" + this.f23220a + ", status=" + this.f23221b + ", extras=" + this.f23222c + '}';
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        bp bpVar = (bp) o;
        if (this.f23220a != bpVar.f23220a) {
            return false;
        }
        if (this.f23221b != bpVar.f23221b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f23220a * 31) + this.f23221b;
    }
}
