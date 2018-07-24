package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mobstat.Config;

public class ControlGroup implements Parcelable {
    public static final Creator<ControlGroup> CREATOR = new C20331();
    /* renamed from: a */
    public final int f6569a;
    /* renamed from: b */
    public final String f6570b;
    /* renamed from: c */
    public final String f6571c;

    /* renamed from: com.baidu.carlife.processes.models.ControlGroup$1 */
    static class C20331 implements Creator<ControlGroup> {
        C20331() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7810a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7811a(i);
        }

        /* renamed from: a */
        public ControlGroup m7810a(Parcel source) {
            return new ControlGroup(source);
        }

        /* renamed from: a */
        public ControlGroup[] m7811a(int size) {
            return new ControlGroup[size];
        }
    }

    protected ControlGroup(String line) throws NumberFormatException, IndexOutOfBoundsException {
        String[] fields = line.split(Config.TRACE_TODAY_VISIT_SPLIT);
        this.f6569a = Integer.parseInt(fields[0]);
        this.f6570b = fields[1];
        this.f6571c = fields[2];
    }

    protected ControlGroup(Parcel in) {
        this.f6569a = in.readInt();
        this.f6570b = in.readString();
        this.f6571c = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f6569a);
        dest.writeString(this.f6570b);
        dest.writeString(this.f6571c);
    }

    public String toString() {
        return String.format("%d:%s:%s", new Object[]{Integer.valueOf(this.f6569a), this.f6570b, this.f6571c});
    }
}
