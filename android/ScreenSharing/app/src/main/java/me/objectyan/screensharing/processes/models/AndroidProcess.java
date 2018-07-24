package com.baidu.carlife.processes.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.IOException;

public class AndroidProcess implements Parcelable {
    public static final Creator<AndroidProcess> CREATOR = new C20311();
    /* renamed from: c */
    public final String f6562c;
    /* renamed from: d */
    public final int f6563d;

    /* renamed from: com.baidu.carlife.processes.models.AndroidProcess$1 */
    static class C20311 implements Creator<AndroidProcess> {
        C20311() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7803a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7804a(i);
        }

        /* renamed from: a */
        public AndroidProcess m7803a(Parcel source) {
            return new AndroidProcess(source);
        }

        /* renamed from: a */
        public AndroidProcess[] m7804a(int size) {
            return new AndroidProcess[size];
        }
    }

    /* renamed from: a */
    static String m7789a(int pid) throws IOException {
        String cmdline = null;
        try {
            cmdline = ProcFile.m7807b(String.format("/proc/%d/cmdline", new Object[]{Integer.valueOf(pid)})).trim();
        } catch (IOException e) {
        }
        if (TextUtils.isEmpty(cmdline)) {
            return Stat.m7816a(pid).m7844b();
        }
        return cmdline;
    }

    public AndroidProcess(int pid) throws IOException {
        this.f6563d = pid;
        this.f6562c = m7789a(pid);
    }

    /* renamed from: a */
    public String m7790a(String filename) throws IOException {
        return ProcFile.m7807b(String.format("/proc/%d/%s", new Object[]{Integer.valueOf(this.f6563d), filename}));
    }

    /* renamed from: b */
    public String m7791b() throws IOException {
        return m7790a("attr/current");
    }

    /* renamed from: c */
    public String m7792c() throws IOException {
        return m7790a("cmdline");
    }

    /* renamed from: d */
    public Cgroup m7793d() throws IOException {
        return Cgroup.m7808a(this.f6563d);
    }

    /* renamed from: e */
    public int m7794e() throws IOException {
        return Integer.parseInt(m7790a("oom_score"));
    }

    /* renamed from: f */
    public int m7795f() throws IOException {
        return Integer.parseInt(m7790a("oom_adj"));
    }

    /* renamed from: g */
    public int m7796g() throws IOException {
        return Integer.parseInt(m7790a("oom_score_adj"));
    }

    /* renamed from: h */
    public Stat m7797h() throws IOException {
        return Stat.m7816a(this.f6563d);
    }

    /* renamed from: i */
    public Statm m7798i() throws IOException {
        return Statm.m7871a(this.f6563d);
    }

    /* renamed from: j */
    public Status m7799j() throws IOException {
        return Status.m7876a(this.f6563d);
    }

    /* renamed from: k */
    public String m7800k() throws IOException {
        return m7790a("wchan");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f6562c);
        dest.writeInt(this.f6563d);
    }

    protected AndroidProcess(Parcel in) {
        this.f6562c = in.readString();
        this.f6563d = in.readInt();
    }
}
