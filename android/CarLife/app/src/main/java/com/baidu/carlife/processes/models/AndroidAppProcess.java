package com.baidu.carlife.processes.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.baidu.mobstat.Config;
import java.io.File;
import java.io.IOException;

public class AndroidAppProcess extends AndroidProcess {
    public static final Creator<AndroidAppProcess> CREATOR = new C20291();
    /* renamed from: e */
    private static final boolean f6564e = new File("/dev/cpuctl/tasks").exists();
    /* renamed from: a */
    public final boolean f6565a;
    /* renamed from: b */
    public final int f6566b;

    /* renamed from: com.baidu.carlife.processes.models.AndroidAppProcess$1 */
    static class C20291 implements Creator<AndroidAppProcess> {
        C20291() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7787a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7788a(i);
        }

        /* renamed from: a */
        public AndroidAppProcess m7787a(Parcel source) {
            return new AndroidAppProcess(source);
        }

        /* renamed from: a */
        public AndroidAppProcess[] m7788a(int size) {
            return new AndroidAppProcess[size];
        }
    }

    /* renamed from: com.baidu.carlife.processes.models.AndroidAppProcess$a */
    public static final class C2030a extends Exception {
        public C2030a(int pid) {
            super(String.format("The process %d does not belong to any application", new Object[]{Integer.valueOf(pid)}));
        }
    }

    public AndroidAppProcess(int pid) throws IOException, C2030a {
        int uid;
        boolean foreground = true;
        super(pid);
        if (f6564e) {
            Cgroup cgroup = m7793d();
            ControlGroup cpuacct = cgroup.m7809a("cpuacct");
            ControlGroup cpu = cgroup.m7809a("cpu");
            if (VERSION.SDK_INT >= 21) {
                if (cpu == null || cpuacct == null || !cpuacct.f6571c.contains("pid_")) {
                    throw new C2030a(pid);
                }
                if (cpu.f6571c.contains("bg_non_interactive")) {
                    foreground = false;
                }
                try {
                    uid = Integer.parseInt(cpuacct.f6571c.split("/")[1].replace("uid_", ""));
                } catch (Exception e) {
                    uid = m7799j().m7877a();
                }
            } else if (cpu == null || cpuacct == null || !cpu.f6571c.contains("apps")) {
                throw new C2030a(pid);
            } else {
                if (cpu.f6571c.contains("bg_non_interactive")) {
                    foreground = false;
                }
                try {
                    uid = Integer.parseInt(cpuacct.f6571c.substring(cpuacct.f6571c.lastIndexOf("/") + 1));
                } catch (Exception e2) {
                    uid = m7799j().m7877a();
                }
            }
        } else if (this.c.startsWith("/") || !new File("/data/data", m7802a()).exists()) {
            throw new C2030a(pid);
        } else {
            Stat stat = m7797h();
            Status status = m7799j();
            if (stat.m7831O() != 0) {
                foreground = false;
            }
            uid = status.m7877a();
        }
        this.f6565a = foreground;
        this.f6566b = uid;
    }

    protected AndroidAppProcess(Parcel in) {
        super(in);
        this.f6565a = in.readByte() != (byte) 0;
        this.f6566b = in.readInt();
    }

    /* renamed from: a */
    public String m7802a() {
        return this.c.split(Config.TRACE_TODAY_VISIT_SPLIT)[0];
    }

    /* renamed from: a */
    public PackageInfo m7801a(Context context, int flags) throws NameNotFoundException {
        return context.getPackageManager().getPackageInfo(m7802a(), flags);
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeByte((byte) (this.f6565a ? 1 : 0));
        dest.writeInt(this.f6566b);
    }

    public String toString() {
        return "AndroidAppProcess{foreground=" + this.f6565a + ", uid=" + this.f6566b + ", name=" + this.c + ", pid=" + this.d + '}';
    }
}
