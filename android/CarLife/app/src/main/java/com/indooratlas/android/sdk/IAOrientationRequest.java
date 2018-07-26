package com.indooratlas.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class IAOrientationRequest implements Parcelable {
    public static final Creator<IAOrientationRequest> CREATOR = new C57551();
    /* renamed from: a */
    private final double f22903a;
    /* renamed from: b */
    private final double f22904b;

    /* renamed from: com.indooratlas.android.sdk.IAOrientationRequest$1 */
    static class C57551 implements Creator<IAOrientationRequest> {
        C57551() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IAOrientationRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IAOrientationRequest(parcel);
        }
    }

    public IAOrientationRequest(double heading, double orientation) {
        this.f22903a = heading;
        this.f22904b = orientation;
    }

    public final double getHeadingSensitivity() {
        return this.f22903a;
    }

    public final double getOrientationSensitivity() {
        return this.f22904b;
    }

    protected IAOrientationRequest(Parcel in) {
        this.f22903a = in.readDouble();
        this.f22904b = in.readDouble();
    }

    public final void writeToParcel(Parcel dest, int i) {
        dest.writeDouble(this.f22903a);
        dest.writeDouble(this.f22904b);
    }

    public final int describeContents() {
        return 0;
    }
}
