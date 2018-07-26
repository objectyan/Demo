package com.baidu.navisdk.util.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProcessManagerUtils {
    private static final String APP_ID_PATTERN;
    private static final String OPEN_API_DEFAULT_FLAG = "1";
    private static final String[] OPEN_API_OS_SRC = new String[]{"com.sdu.didi", "com.ubercab.driver", "com.szzc.ucar.pilot", "com.ehaidriver.activity", "com.yongche"};
    private static final String TAG = "ProcessManager";

    public static class Process implements Parcelable {
        public static final Creator<Process> CREATOR = new C47291();
        public final int cpu;
        public final String name;
        public final int niceness;
        public final String pc;
        public final int pid;
        public final String policy;
        public final int ppid;
        public final int priority;
        public final int realTimePriority;
        public final long rss;
        public final int schedulingPolicy;
        public final String state;
        public final long systemTime;
        public final int uid;
        public final String user;
        public final long userTime;
        public final long vsize;
        public final String wchan;

        /* renamed from: com.baidu.navisdk.util.statistic.ProcessManagerUtils$Process$1 */
        static class C47291 implements Creator<Process> {
            C47291() {
            }

            public Process createFromParcel(Parcel source) {
                return new Process(source);
            }

            public Process[] newArray(int size) {
                return new Process[size];
            }
        }

        private Process(String line) throws Exception {
            String[] fields = line.split("\\s+");
            this.user = fields[0];
            this.uid = android.os.Process.getUidForName(this.user);
            this.pid = Integer.parseInt(fields[1]);
            this.ppid = Integer.parseInt(fields[2]);
            this.vsize = (long) (Integer.parseInt(fields[3]) * 1024);
            this.rss = (long) (Integer.parseInt(fields[4]) * 1024);
            this.cpu = Integer.parseInt(fields[5]);
            this.priority = Integer.parseInt(fields[6]);
            this.niceness = Integer.parseInt(fields[7]);
            this.realTimePriority = Integer.parseInt(fields[8]);
            this.schedulingPolicy = Integer.parseInt(fields[9]);
            if (fields.length == 16) {
                this.policy = "";
                this.wchan = fields[10];
                this.pc = fields[11];
                this.state = fields[12];
                this.name = fields[13];
                this.userTime = (long) (Integer.parseInt(fields[14].split(Config.TRACE_TODAY_VISIT_SPLIT)[1].replace(",", "")) * 1000);
                this.systemTime = (long) (Integer.parseInt(fields[15].split(Config.TRACE_TODAY_VISIT_SPLIT)[1].replace(")", "")) * 1000);
                return;
            }
            this.policy = fields[10];
            this.wchan = fields[11];
            this.pc = fields[12];
            this.state = fields[13];
            this.name = fields[14];
            this.userTime = (long) (Integer.parseInt(fields[15].split(Config.TRACE_TODAY_VISIT_SPLIT)[1].replace(",", "")) * 1000);
            this.systemTime = (long) (Integer.parseInt(fields[16].split(Config.TRACE_TODAY_VISIT_SPLIT)[1].replace(")", "")) * 1000);
        }

        private Process(Parcel in) {
            this.user = in.readString();
            this.uid = in.readInt();
            this.pid = in.readInt();
            this.ppid = in.readInt();
            this.vsize = in.readLong();
            this.rss = in.readLong();
            this.cpu = in.readInt();
            this.priority = in.readInt();
            this.niceness = in.readInt();
            this.realTimePriority = in.readInt();
            this.schedulingPolicy = in.readInt();
            this.policy = in.readString();
            this.wchan = in.readString();
            this.pc = in.readString();
            this.state = in.readString();
            this.name = in.readString();
            this.userTime = in.readLong();
            this.systemTime = in.readLong();
        }

        public String getPackageName() {
            if (!this.user.matches(ProcessManagerUtils.APP_ID_PATTERN)) {
                return null;
            }
            if (this.name.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
                return this.name.split(Config.TRACE_TODAY_VISIT_SPLIT)[0];
            }
            return this.name;
        }

        public PackageInfo getPackageInfo(Context context, int flags) throws NameNotFoundException {
            String packageName = getPackageName();
            if (packageName != null) {
                return context.getPackageManager().getPackageInfo(packageName, flags);
            }
            throw new NameNotFoundException(this.name + " is not an application process");
        }

        public ApplicationInfo getApplicationInfo(Context context, int flags) throws NameNotFoundException {
            String packageName = getPackageName();
            if (packageName != null) {
                return context.getPackageManager().getApplicationInfo(packageName, flags);
            }
            throw new NameNotFoundException(this.name + " is not an application process");
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.user);
            dest.writeInt(this.uid);
            dest.writeInt(this.pid);
            dest.writeInt(this.ppid);
            dest.writeLong(this.vsize);
            dest.writeLong(this.rss);
            dest.writeInt(this.cpu);
            dest.writeInt(this.priority);
            dest.writeInt(this.niceness);
            dest.writeInt(this.realTimePriority);
            dest.writeInt(this.schedulingPolicy);
            dest.writeString(this.policy);
            dest.writeString(this.wchan);
            dest.writeString(this.pc);
            dest.writeString(this.state);
            dest.writeString(this.name);
            dest.writeLong(this.userTime);
            dest.writeLong(this.systemTime);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            APP_ID_PATTERN = "u\\d+_a\\d+";
        } else {
            APP_ID_PATTERN = "app_\\d+";
        }
    }

    public static List<Process> getRunningProcesses() {
        List<Process> processes = new ArrayList();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("toolbox ps -p -P -x -c").getInputStream()));
            in.readLine();
            int myPid = android.os.Process.myPid();
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }
                processes.add(new Process(line));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return processes;
    }

    public static String getOpenApiStatFlag() {
        try {
            List<Process> mProcessList = getRunningApps();
            if (mProcessList == null) {
                return "1";
            }
            StringBuffer sb = new StringBuffer();
            ArrayList<Integer> arrList = new ArrayList();
            int index;
            Process mProcess;
            if (VERSION.SDK_INT >= 17) {
                for (Process mProcess2 : mProcessList) {
                    index = 0;
                    while (index < OPEN_API_OS_SRC.length) {
                        if (mProcess2.getPackageName() != null && mProcess2.getPackageName().startsWith(OPEN_API_OS_SRC[index])) {
                            if (!arrList.contains(Integer.valueOf(index + 2))) {
                                arrList.add(Integer.valueOf(index + 2));
                            }
                            LogUtil.m15791e("ProcessManagerUtils is osSrc:", mProcess2.getPackageName());
                        }
                        index++;
                    }
                    LogUtil.m15791e("ProcessManagerUtils:", mProcess2.getPackageName());
                }
                Collections.sort(arrList);
                Iterator it = arrList.iterator();
                while (it.hasNext()) {
                    Integer i = (Integer) it.next();
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append("-");
                    }
                    sb.append(i);
                }
            } else if (mProcessList.size() <= 1) {
                return "1";
            } else {
                mProcess2 = (Process) mProcessList.get(mProcessList.size() - 1);
                index = 0;
                while (index < OPEN_API_OS_SRC.length) {
                    if (mProcess2.getPackageName() != null && mProcess2.getPackageName().equals(OPEN_API_OS_SRC[index])) {
                        sb.append(index + 2);
                    }
                    index++;
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                return "1";
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
    }

    public static List<Process> getRunningApps() {
        List<Process> processes = new ArrayList();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("toolbox ps -p -P -x -c").getInputStream()));
            in.readLine();
            int myPid = android.os.Process.myPid();
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }
                Process process = new Process(line);
                if (!(!process.user.matches(APP_ID_PATTERN) || process.ppid == myPid || process.name.equals("toolbox"))) {
                    processes.add(process);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return processes;
    }
}
