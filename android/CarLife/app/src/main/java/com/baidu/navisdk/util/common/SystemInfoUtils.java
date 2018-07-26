package com.baidu.navisdk.util.common;

import android.content.Context;
import android.os.Build;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.json.JSONObject;

public class SystemInfoUtils {
    public static final String K_CPU_FEATURE_NEON = "neon";
    public static final String K_CPU_FEATURE_UNKNOWN = "unknown";
    public static final String K_CPU_FEATURE_VFP = "vfp";
    public static final String K_CPU_FEATURE_VFPV3 = "vfpv3";
    public static final String K_CPU_MODEL_UNKNOWN = "unknown";
    public static final String K_CPU_MODEL_V5 = "armv5";
    public static final String K_CPU_MODEL_V6 = "armv6";
    public static final String K_CPU_MODEL_V7 = "armv7";
    public static final String K_CPU_MODEL_X86 = "x86";
    private static final String kCpuInfoMaxFreqFilePath = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";

    public static class CPUInfo {
        public static final int CPU_FEATURE_NEON = 256;
        public static final int CPU_FEATURE_UNKNOWS = 0;
        public static final int CPU_FEATURE_VFP = 1;
        public static final int CPU_FEATURE_VFPV3 = 16;
        public static final int CPU_TYPE_ARMV5TE = 1;
        public static final int CPU_TYPE_ARMV6 = 16;
        public static final int CPU_TYPE_ARMV7 = 256;
        public static final int CPU_TYPE_UNKNOWN = 0;
        public double mBogoMips;
        public int mCPUCount;
        public int mCPUFeature;
        public long mCPUMaxFreq;
        public int mCPUType;
    }

    public static String getMobileInfo() {
        JSONObject mbInfo = new JSONObject();
        try {
            for (Field field : Build.class.getDeclaredFields()) {
                field.setAccessible(true);
                mbInfo.put(field.getName(), field.get(null).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mbInfo.toString();
    }

    public static String getCpuString() {
        if (Build.CPU_ABI.equalsIgnoreCase(K_CPU_MODEL_X86)) {
            return "Intel";
        }
        String strInfo = "";
        try {
            byte[] bs = new byte[1024];
            new RandomAccessFile("/proc/cpuinfo", "r").read(bs);
            String ret = new String(bs);
            int index = ret.indexOf(0);
            if (index != -1) {
                return ret.substring(0, index);
            }
            return ret;
        } catch (IOException ex) {
            ex.printStackTrace();
            return strInfo;
        }
    }

    public static String getCpuType() {
        String strType;
        String strInfo = getCpuString();
        if (strInfo.contains("ARMv5")) {
            strType = K_CPU_MODEL_V5;
        } else if (strInfo.contains("ARMv6")) {
            strType = K_CPU_MODEL_V6;
        } else if (strInfo.contains("ARMv7")) {
            strType = K_CPU_MODEL_V7;
        } else if (!strInfo.contains("Intel")) {
            return "unknown";
        } else {
            strType = K_CPU_MODEL_X86;
        }
        if (strInfo.contains(K_CPU_FEATURE_NEON)) {
            strType = strType + "_neon";
        } else if (strInfo.contains(K_CPU_FEATURE_VFPV3)) {
            strType = strType + "_vfpv3";
        } else if (strInfo.contains(" vfp")) {
            strType = strType + "_vfp";
        } else {
            strType = strType + "_none";
        }
        return strType;
    }

    public static CPUInfo getCPUInfo() {
        String strInfo;
        try {
            byte[] bs = new byte[1024];
            new RandomAccessFile("/proc/cpuinfo", "r").read(bs);
            String ret = new String(bs);
            int index = ret.indexOf(0);
            if (index != -1) {
                strInfo = ret.substring(0, index);
            } else {
                strInfo = ret;
            }
        } catch (IOException ex) {
            strInfo = "";
            ex.printStackTrace();
        }
        CPUInfo info = parseCPUInfo(strInfo);
        info.mCPUMaxFreq = (long) getMaxCpuFreq();
        return info;
    }

    private static int getMaxCpuFreq() {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        int result = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            BufferedReader br2;
            FileReader fr2 = new FileReader(kCpuInfoMaxFreqFilePath);
            try {
                br2 = new BufferedReader(fr2);
            } catch (FileNotFoundException e3) {
                e = e3;
                fr = fr2;
                try {
                    e.printStackTrace();
                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    return result;
                } catch (Throwable th2) {
                    th = th2;
                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e22222) {
                            e22222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e22222 = e4;
                fr = fr2;
                e22222.printStackTrace();
                if (fr != null) {
                    try {
                        fr.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                }
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e2222222) {
                        e2222222.printStackTrace();
                    }
                }
                return result;
            } catch (Throwable th3) {
                th = th3;
                fr = fr2;
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                throw th;
            }
            try {
                String text = br2.readLine();
                if (text != null) {
                    result = Integer.parseInt(text.trim());
                }
                if (fr2 != null) {
                    try {
                        fr2.close();
                    } catch (IOException e22222222) {
                        e22222222.printStackTrace();
                    }
                }
                if (br2 != null) {
                    try {
                        br2.close();
                        br = br2;
                        fr = fr2;
                    } catch (IOException e222222222) {
                        e222222222.printStackTrace();
                        br = br2;
                        fr = fr2;
                    }
                } else {
                    fr = fr2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                br = br2;
                fr = fr2;
                e.printStackTrace();
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                return result;
            } catch (IOException e6) {
                e222222222 = e6;
                br = br2;
                fr = fr2;
                e222222222.printStackTrace();
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                return result;
            } catch (Throwable th4) {
                th = th4;
                br = br2;
                fr = fr2;
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            e.printStackTrace();
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
            return result;
        } catch (IOException e8) {
            e222222222 = e8;
            e222222222.printStackTrace();
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
            return result;
        }
        return result;
    }

    private static CPUInfo parseCPUInfo(String cpuInfo) {
        if (cpuInfo == null || "".equals(cpuInfo)) {
            return null;
        }
        CPUInfo ci = new CPUInfo();
        ci.mCPUType = 0;
        ci.mCPUFeature = 0;
        ci.mCPUCount = 1;
        ci.mBogoMips = 0.0d;
        if (cpuInfo.contains("ARMv5")) {
            ci.mCPUType = 1;
        } else if (cpuInfo.contains("ARMv6")) {
            ci.mCPUType = 16;
        } else if (cpuInfo.contains("ARMv7")) {
            ci.mCPUType = 256;
        }
        if (cpuInfo.contains(K_CPU_FEATURE_NEON)) {
            ci.mCPUFeature |= 256;
        }
        if (cpuInfo.contains(K_CPU_FEATURE_VFPV3)) {
            ci.mCPUFeature |= 16;
        }
        if (cpuInfo.contains(" vfp")) {
            ci.mCPUFeature |= 1;
        }
        for (String item : cpuInfo.split("\n")) {
            int index;
            if (item.contains("CPU variant")) {
                index = item.indexOf(": ");
                if (index >= 0) {
                    try {
                        int i;
                        ci.mCPUCount = Integer.decode(item.substring(index + 2)).intValue();
                        if (ci.mCPUCount == 0) {
                            i = 1;
                        } else {
                            i = ci.mCPUCount;
                        }
                        ci.mCPUCount = i;
                    } catch (NumberFormatException e) {
                        ci.mCPUCount = 1;
                    }
                }
            } else if (item.contains("BogoMIPS")) {
                index = item.indexOf(": ");
                if (index >= 0) {
                    item.substring(index + 2);
                }
            }
        }
        return ci;
    }

    public static long getTotalMemory() {
        long initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader("/proc/meminfo");
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            String str2 = localBufferedReader.readLine();
            if (str2 != null) {
                initial_memory = (long) (Integer.valueOf(str2.split("\\s+")[1]).intValue() / 1024);
            }
            localBufferedReader.close();
            localFileReader.close();
            return initial_memory;
        } catch (IOException e) {
            return -1;
        }
    }

    public static String getCpuModel() {
        String cpu_model = "";
        CPUInfo in = getCPUInfo();
        if ((in.mCPUType & 1) == 1) {
            return K_CPU_MODEL_V5;
        }
        if ((in.mCPUType & 16) == 16) {
            return K_CPU_MODEL_V6;
        }
        if ((in.mCPUType & 256) == 256) {
            return K_CPU_MODEL_V7;
        }
        return "unknown";
    }

    public static String getCpuFeature() {
        String cpu_feature = "";
        CPUInfo in = getCPUInfo();
        if ((in.mCPUFeature & 256) == 256) {
            return K_CPU_FEATURE_NEON;
        }
        if ((in.mCPUFeature & 1) == 1) {
            return K_CPU_FEATURE_VFP;
        }
        if ((in.mCPUFeature & 16) == 16) {
            return K_CPU_FEATURE_VFPV3;
        }
        return "unknown";
    }

    public static String getIpAddress(Context mContext) {
        String ipAddress = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                Enumeration<InetAddress> enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        ipAddress = inetAddress.getHostAddress().toString();
                    }
                }
            }
            return ipAddress;
        } catch (SocketException e) {
            return null;
        }
    }
}
