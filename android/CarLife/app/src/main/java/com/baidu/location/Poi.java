package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Poi implements Parcelable {
    public static final Creator<Poi> CREATOR = new C31781();
    private final String mId;
    private final String mName;
    private final double mRank;

    /* renamed from: com.baidu.location.Poi$1 */
    static class C31781 implements Creator<Poi> {
        C31781() {
        }

        public Poi createFromParcel(Parcel parcel) {
            return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble());
        }

        public Poi[] newArray(int i) {
            return new Poi[i];
        }
    }

    public Poi(String str, String str2, double d) {
        this.mId = str;
        this.mName = str2;
        this.mRank = d;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public double getRank() {
        return this.mRank;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeDouble(this.mRank);
    }
}
