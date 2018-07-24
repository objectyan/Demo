package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class Cgroup extends ProcFile {
    public static final Creator<Cgroup> CREATOR = new C20321();
    /* renamed from: a */
    public final ArrayList<ControlGroup> f6568a;

    /* renamed from: com.baidu.carlife.processes.models.Cgroup$1 */
    static class C20321 implements Creator<Cgroup> {
        C20321() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7805a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7806a(i);
        }

        /* renamed from: a */
        public Cgroup m7805a(Parcel source) {
            return new Cgroup(source);
        }

        /* renamed from: a */
        public Cgroup[] m7806a(int size) {
            return new Cgroup[size];
        }
    }

    /* renamed from: a */
    public static Cgroup m7808a(int pid) throws IOException {
        return new Cgroup(String.format("/proc/%d/cgroup", new Object[]{Integer.valueOf(pid)}));
    }

    private Cgroup(String path) throws IOException {
        super(path);
        String[] lines = this.b.split("\n");
        this.f6568a = new ArrayList();
        for (String line : lines) {
            try {
                this.f6568a.add(new ControlGroup(line));
            } catch (Exception e) {
            }
        }
    }

    private Cgroup(Parcel in) {
        super(in);
        this.f6568a = in.createTypedArrayList(ControlGroup.CREATOR);
    }

    /* renamed from: a */
    public ControlGroup m7809a(String subsystem) {
        Iterator it = this.f6568a.iterator();
        while (it.hasNext()) {
            ControlGroup group = (ControlGroup) it.next();
            for (String name : group.f6570b.split(",")) {
                if (name.equals(subsystem)) {
                    return group;
                }
            }
        }
        return null;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.f6568a);
    }
}
