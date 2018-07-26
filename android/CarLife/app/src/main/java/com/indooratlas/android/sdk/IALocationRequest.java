package com.indooratlas.android.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class IALocationRequest implements Parcelable {
    public static final Creator<IALocationRequest> CREATOR = new C57491();
    /* renamed from: a */
    private Bundle f22879a;
    /* renamed from: b */
    private long f22880b;
    /* renamed from: c */
    private float f22881c;

    /* renamed from: com.indooratlas.android.sdk.IALocationRequest$1 */
    static class C57491 implements Creator<IALocationRequest> {
        C57491() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IALocationRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IALocationRequest(parcel);
        }
    }

    private IALocationRequest() {
        this.f22880b = -1;
        this.f22881c = -1.0f;
    }

    private IALocationRequest(Parcel in) {
        this.f22880b = -1;
        this.f22881c = -1.0f;
        this.f22879a = in.readBundle(getClass().getClassLoader());
        this.f22880b = in.readLong();
        this.f22881c = in.readFloat();
    }

    public static IALocationRequest create() {
        return new IALocationRequest();
    }

    public final IALocationRequest putExtra(String key, String value) {
        m19661a();
        this.f22879a.putString(key, value);
        return this;
    }

    public final IALocationRequest putExtra(String key, Parcelable value) {
        m19661a();
        this.f22879a.putParcelable(key, value);
        return this;
    }

    public final String getStringExtra(String key) {
        return this.f22879a != null ? this.f22879a.getString(key) : null;
    }

    public final IALocationRequest setFastestInterval(long millis) {
        this.f22880b = millis;
        return this;
    }

    public final long getFastestInterval() {
        return this.f22880b;
    }

    public final IALocationRequest setSmallestDisplacement(float meters) {
        this.f22881c = meters;
        return this;
    }

    public final float getSmallestDisplacement() {
        return this.f22881c;
    }

    public final <T extends Parcelable> T getParcelableExtra(String key) {
        T parcelable = this.f22879a != null ? this.f22879a.getParcelable(key) : null;
        return parcelable == null ? null : parcelable;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel dest, int i) {
        dest.writeBundle(this.f22879a);
        dest.writeLong(this.f22880b);
        dest.writeFloat(this.f22881c);
    }

    /* renamed from: a */
    private void m19661a() {
        if (this.f22879a == null) {
            this.f22879a = new Bundle();
        }
    }
}
