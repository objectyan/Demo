package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.io.IOException;

public final class Status extends ProcFile {
    public static final Creator<Status> CREATOR = new C20371();

    /* renamed from: com.baidu.carlife.processes.models.Status$1 */
    static class C20371 implements Creator<Status> {
        C20371() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7874a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7875a(i);
        }

        /* renamed from: a */
        public Status m7874a(Parcel source) {
            return new Status(source);
        }

        /* renamed from: a */
        public Status[] m7875a(int size) {
            return new Status[size];
        }
    }

    /* renamed from: a */
    public static Status m7876a(int pid) throws IOException {
        return new Status(String.format("/proc/%d/status", new Object[]{Integer.valueOf(pid)}));
    }

    private Status(String path) throws IOException {
        super(path);
    }

    private Status(Parcel in) {
        super(in);
    }

    /* renamed from: a */
    public String m7878a(String fieldName) {
        for (String line : this.b.split("\n")) {
            if (line.startsWith(fieldName + Config.TRACE_TODAY_VISIT_SPLIT)) {
                return line.split(fieldName + Config.TRACE_TODAY_VISIT_SPLIT)[1].trim();
            }
        }
        return null;
    }

    /* renamed from: a */
    public int m7877a() {
        int result = -1;
        try {
            String strUid = m7878a(JNISearchConst.KEY_UID);
            if (strUid != null) {
                result = Integer.parseInt(strUid.split("\\s+")[0]);
            }
        } catch (Exception e) {
        }
        return result;
    }

    /* renamed from: b */
    public int m7879b() {
        int result = -1;
        try {
            String strGid = m7878a("Gid");
            if (strGid != null) {
                result = Integer.parseInt(strGid.split("\\s+")[0]);
            }
        } catch (Exception e) {
        }
        return result;
    }
}
