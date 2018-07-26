package com.indooratlas.android.sdk;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk._internal.ee;

public class IALocation implements Parcelable {
    public static final Creator<IALocation> CREATOR = new C57481();
    public static final String EXTRA_FLOOR_CERTAINTY = "com.indooratlas.android.sdk.extra.floorCertainty";
    public static final String EXTRA_FLOOR_LEVEL = "com.indooratlas.android.sdk.extra.floorLevel";
    public static final String EXTRA_REGION = "com.indooratlas.android.sdk.extra.region";
    @NonNull
    /* renamed from: a */
    private final Location f22877a;
    @Nullable
    /* renamed from: b */
    private IARegion f22878b;

    /* renamed from: com.indooratlas.android.sdk.IALocation$1 */
    static class C57481 implements Creator<IALocation> {
        C57481() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IALocation[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IALocation(parcel);
        }
    }

    public static class Builder {
        /* renamed from: a */
        private Location f22865a;
        /* renamed from: b */
        private Double f22866b;
        /* renamed from: c */
        private Double f22867c;
        /* renamed from: d */
        private Long f22868d;
        /* renamed from: e */
        private Float f22869e;
        /* renamed from: f */
        private Float f22870f;
        /* renamed from: g */
        private Integer f22871g;
        /* renamed from: h */
        private Float f22872h;
        /* renamed from: i */
        private IARegion f22873i;
        /* renamed from: j */
        private Double f22874j;
        /* renamed from: k */
        private Bundle f22875k;
        @Nullable
        /* renamed from: l */
        private final String f22876l;

        public Builder(String provider) {
            this.f22876l = provider;
        }

        Builder(IALocation location) {
            this.f22876l = location.f22877a.getProvider();
            this.f22865a = location.f22877a;
            this.f22873i = location.f22878b;
            if (location.hasFloorLevel()) {
                this.f22871g = Integer.valueOf(location.getFloorLevel());
            }
            if (location.hasFloorCertainty()) {
                this.f22872h = Float.valueOf(location.getFloorCertainty());
            }
        }

        public Builder() {
            this(null);
        }

        public Builder withLocation(Location location) {
            this.f22865a = location;
            return this;
        }

        public Builder withRegion(IARegion region) {
            this.f22873i = region;
            return this;
        }

        public Builder withLatitude(double latitude) {
            this.f22866b = Double.valueOf(latitude);
            return this;
        }

        public Builder withTime(long millis) {
            this.f22868d = Long.valueOf(millis);
            return this;
        }

        public Builder withLongitude(double longitude) {
            this.f22867c = Double.valueOf(longitude);
            return this;
        }

        public Builder withBearing(float bearing) {
            this.f22869e = Float.valueOf(bearing);
            return this;
        }

        public Builder withAccuracy(float accuracy) {
            this.f22870f = Float.valueOf(accuracy);
            return this;
        }

        public Builder withFloorLevel(int level) {
            this.f22871g = Integer.valueOf(level);
            return this;
        }

        public Builder withFloorCertainty(float certainty) {
            this.f22872h = Float.valueOf(certainty);
            return this;
        }

        public Builder withAltitude(double altitude) {
            this.f22874j = Double.valueOf(altitude);
            return this;
        }

        public Builder withExtras(Bundle extras) {
            this.f22875k = extras;
            return this;
        }

        public Builder withLongExtra(String key, long value) {
            if (this.f22875k == null) {
                this.f22875k = new Bundle(1);
            }
            this.f22875k.putLong(key, value);
            return this;
        }

        public Builder withIntExtra(String key, int value) {
            if (this.f22875k == null) {
                this.f22875k = new Bundle(1);
            }
            this.f22875k.putInt(key, value);
            return this;
        }

        public IALocation build() {
            return new IALocation();
        }
    }

    private IALocation(Builder builder) {
        this.f22877a = builder.f22865a != null ? new Location(builder.f22865a) : new Location(builder.f22876l != null ? builder.f22876l : null);
        Bundle bundle = builder.f22875k != null ? new Bundle(builder.f22875k) : new Bundle();
        if (this.f22877a.getExtras() != null) {
            bundle.putAll(this.f22877a.getExtras());
        }
        if (builder.f22866b != null) {
            this.f22877a.setLatitude(builder.f22866b.doubleValue());
        }
        if (builder.f22867c != null) {
            this.f22877a.setLongitude(builder.f22867c.doubleValue());
        }
        if (builder.f22870f != null) {
            this.f22877a.setAccuracy(builder.f22870f.floatValue());
        }
        if (builder.f22869e != null) {
            this.f22877a.setBearing(builder.f22869e.floatValue());
        }
        if (builder.f22868d != null) {
            this.f22877a.setTime(builder.f22868d.longValue());
        }
        if (builder.f22870f != null) {
            this.f22877a.setAccuracy(builder.f22870f.floatValue());
        }
        if (builder.f22874j != null) {
            this.f22877a.setAltitude(builder.f22874j.doubleValue());
        }
        if (builder.f22871g != null) {
            bundle.putInt(EXTRA_FLOOR_LEVEL, builder.f22871g.intValue());
        }
        if (builder.f22872h != null) {
            bundle.putFloat(EXTRA_FLOOR_CERTAINTY, builder.f22872h.floatValue());
        }
        if (builder.f22873i != null) {
            this.f22878b = builder.f22873i;
            bundle.setClassLoader(IARegion.class.getClassLoader());
            bundle.putParcelable(EXTRA_REGION, this.f22878b);
        }
        this.f22877a.setExtras(bundle);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    protected IALocation(Parcel in) {
        Location location = (Location) in.readParcelable(Location.class.getClassLoader());
        if (location != null) {
            this.f22877a = location;
        } else {
            this.f22877a = new Location(null);
        }
        this.f22878b = (IARegion) in.readParcelable(IARegion.class.getClassLoader());
    }

    public static IALocation from(Location location) {
        return new Builder().withLocation(location).build();
    }

    public static IALocation from(IARegion region) {
        return new Builder().withRegion(region).build();
    }

    public static IALocation from(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            byte[] byteArrayExtra = intent.getByteArrayExtra(IALocationManager.EXTRA_LOCATION);
            if (byteArrayExtra == null) {
                return null;
            }
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            obtain.setDataPosition(0);
            IALocation iALocation = (IALocation) CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return iALocation;
        } catch (Exception e) {
            Object[] objArr = new Object[]{e};
            ee.m20409a("IASDK", "IALocation in Intent corrupted", objArr);
            return null;
        }
    }

    public Location toLocation() {
        return new Location(this.f22877a);
    }

    public double getLatitude() {
        return this.f22877a.getLatitude();
    }

    public double getLongitude() {
        return this.f22877a.getLongitude();
    }

    public float getBearing() {
        return this.f22877a.getBearing();
    }

    public float getAccuracy() {
        return this.f22877a.getAccuracy();
    }

    public long getTime() {
        return this.f22877a.getTime();
    }

    public double getAltitude() {
        return this.f22877a.getAltitude();
    }

    public boolean hasFloorLevel() {
        return m19659a(EXTRA_FLOOR_LEVEL);
    }

    public int getFloorLevel() {
        Bundle extras = this.f22877a.getExtras();
        if (extras == null) {
            return 0;
        }
        extras.setClassLoader(IARegion.class.getClassLoader());
        return extras.getInt(EXTRA_FLOOR_LEVEL, 0);
    }

    public boolean hasFloorCertainty() {
        return m19659a(EXTRA_FLOOR_CERTAINTY);
    }

    public float getFloorCertainty() {
        Bundle extras = this.f22877a.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        extras.setClassLoader(IARegion.class.getClassLoader());
        return extras.getFloat(EXTRA_FLOOR_CERTAINTY, 0.0f);
    }

    public IARegion getRegion() {
        return this.f22878b;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IALocation iALocation = (IALocation) o;
        if (getLatitude() != iALocation.getLatitude()) {
            return false;
        }
        if (getLongitude() != iALocation.getLongitude()) {
            return false;
        }
        if (getAccuracy() != iALocation.getAccuracy()) {
            return false;
        }
        if (getBearing() != iALocation.getBearing()) {
            return false;
        }
        if (getTime() != iALocation.getTime()) {
            return false;
        }
        if (hasFloorLevel() != iALocation.hasFloorLevel() || getFloorLevel() != iALocation.getFloorLevel()) {
            return false;
        }
        if (hasFloorCertainty() != iALocation.hasFloorCertainty() || getFloorCertainty() != iALocation.getFloorCertainty()) {
            return false;
        }
        if (this.f22878b != null) {
            if (this.f22878b.equals(iALocation.f22878b)) {
                return true;
            }
        } else if (iALocation.f22878b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f22877a != null) {
            hashCode = this.f22877a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f22878b != null) {
            i = this.f22878b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "IALocation{latitude=" + getLatitude() + ",longitude=" + getLongitude() + ",accuracy=" + getAccuracy() + ",bearing=" + getBearing() + ",floorLevel=" + getFloorLevel() + ",floorCertainty=" + getFloorCertainty() + ",time=" + getTime() + ",region=" + this.f22878b + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.f22877a, flags);
        dest.writeParcelable(this.f22878b, flags);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    private boolean m19659a(String str) {
        Bundle extras = this.f22877a.getExtras();
        if (extras == null) {
            return false;
        }
        extras.setClassLoader(IARegion.class.getClassLoader());
        return extras.containsKey(str);
    }
}
