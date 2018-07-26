package com.indooratlas.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.indooratlas.android.sdk._internal.eh;
import com.indooratlas.android.sdk._internal.ei;

public class IARegion implements Parcelable {
    public static final Creator<IARegion> CREATOR = new C57561();
    public static final int TYPE_FLOOR_PLAN = 1;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_VENUE = 2;
    /* renamed from: a */
    private final int f22905a;
    /* renamed from: b */
    private final String f22906b;
    /* renamed from: c */
    private final long f22907c;
    /* renamed from: d */
    private final String f22908d;

    public interface Listener {
        void onEnterRegion(IARegion iARegion);

        void onExitRegion(IARegion iARegion);
    }

    /* renamed from: com.indooratlas.android.sdk.IARegion$1 */
    static class C57561 implements Creator<IARegion> {
        C57561() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IARegion[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IARegion(parcel);
        }
    }

    public IARegion(int regionType, long timestamp, String regionId, String regionName) {
        if (regionType != 1 && regionType != 2 && regionType != -1) {
            throw new IllegalArgumentException("unsupported region type: " + regionType);
        } else if (regionType == -1 || !ei.m20418a(regionId)) {
            this.f22907c = timestamp;
            this.f22905a = regionType;
            this.f22906b = regionId;
            this.f22908d = regionName;
        } else {
            throw new IllegalArgumentException("regionId cannot be empty for region type: " + eh.m20416a(IARegion.class, regionId));
        }
    }

    protected IARegion(Parcel in) {
        this.f22905a = in.readInt();
        this.f22906b = in.readString();
        this.f22907c = in.readLong();
        this.f22908d = in.readString();
    }

    public static IARegion unknown() {
        return new IARegion(-1, System.currentTimeMillis(), null, null);
    }

    public static IARegion floorPlan(String floorPlanId) {
        return new IARegion(1, System.currentTimeMillis(), floorPlanId, null);
    }

    public static IARegion venue(String venueId) {
        return new IARegion(2, System.currentTimeMillis(), venueId, null);
    }

    public int getType() {
        return this.f22905a;
    }

    public String getId() {
        return this.f22906b;
    }

    public String getName() {
        return this.f22908d;
    }

    public long getTimestamp() {
        return this.f22907c;
    }

    public String toString() {
        return "IARegion{mRegionType=" + this.f22905a + ", mTimestamp='" + this.f22907c + "', mRegionId='" + this.f22906b + '\'' + ", mRegionName='" + this.f22908d + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IARegion iARegion = (IARegion) o;
        if (this.f22905a != iARegion.f22905a) {
            return false;
        }
        if (this.f22906b == null) {
            if (iARegion.f22906b != null) {
                return false;
            }
        } else if (!this.f22906b.equals(iARegion.f22906b)) {
            return false;
        }
        if (this.f22908d == null) {
            if (iARegion.f22908d != null) {
                return false;
            }
            return true;
        } else if (this.f22908d.equals(iARegion.f22908d)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int i = this.f22905a;
        if (this.f22906b != null) {
            return (((i * 31) + this.f22906b.hashCode()) * 31) + this.f22908d.hashCode();
        }
        return i;
    }

    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(this.f22905a);
        dest.writeString(this.f22906b);
        dest.writeLong(this.f22907c);
        dest.writeString(this.f22908d);
    }

    public int describeContents() {
        return 0;
    }
}
