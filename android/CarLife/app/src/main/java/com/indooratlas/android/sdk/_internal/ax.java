package com.indooratlas.android.sdk._internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.indooratlas.android.sdk.IALocation;
import java.util.ArrayList;
import java.util.Iterator;

public final class ax implements Parcelable {
    public static final Creator<ax> CREATOR = new C57751();
    /* renamed from: a */
    final int f23025a;
    /* renamed from: b */
    final ArrayList<aw> f23026b;
    /* renamed from: c */
    private final IALocation f23027c;

    /* renamed from: com.indooratlas.android.sdk._internal.ax$1 */
    static class C57751 implements Creator<ax> {
        C57751() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ax[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ax(parcel);
        }
    }

    public ax(ArrayList<aw> arrayList, int i, IALocation iALocation) {
        this.f23026b = new ArrayList(arrayList);
        this.f23027c = iALocation;
        this.f23025a = i;
    }

    public ax(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            arrayList.add((aw) parcel.readParcelable(cd.class.getClassLoader()));
        }
        this.f23026b = arrayList;
        this.f23025a = parcel.readInt();
        this.f23027c = (IALocation) parcel.readParcelable(IALocation.class.getClassLoader());
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(68);
        stringBuilder.append("IAGeofenceEvent{transitionType=");
        switch (this.f23025a) {
            case 1:
                stringBuilder.append("ENTER");
                break;
            case 16:
                stringBuilder.append("EXIT");
                break;
            case 256:
                stringBuilder.append("DWELL");
                break;
        }
        stringBuilder.append(",geofences=");
        Iterator it = this.f23026b.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((aw) it.next()).toString());
        }
        stringBuilder.append(",triggeringLocation=").append(this.f23027c).append('}');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f23026b.size());
        Iterator it = this.f23026b.iterator();
        while (it.hasNext()) {
            dest.writeParcelable((cd) ((aw) it.next()), flags);
        }
        dest.writeInt(this.f23025a);
        dest.writeParcelable(this.f23027c, flags);
    }

    public final int describeContents() {
        return 0;
    }
}
