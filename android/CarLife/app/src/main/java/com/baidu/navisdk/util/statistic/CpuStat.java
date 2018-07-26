package com.baidu.navisdk.util.statistic;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CpuStat {
    long mEndTime;
    long mEndValue;
    long mStartTime;
    long mStartValue;
    String mStatPath;

    private static class LazyHolder {
        private static CpuStat sInstance = new CpuStat();

        private LazyHolder() {
        }
    }

    public static CpuStat getInstance() {
        return LazyHolder.sInstance;
    }

    private CpuStat() {
        this.mStatPath = "/proc/" + Process.myPid() + "/stat";
    }

    public void startProfile() {
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartValue = getStat(this.mStatPath);
        LogUtil.m15791e("CpuStat", "start jiffies=" + this.mStartValue);
    }

    public void endProfile() {
        this.mEndTime = SystemClock.elapsedRealtime();
        LogUtil.m15791e("CpuStat", "end jiffies=" + this.mEndValue);
        this.mEndValue = getStat(this.mStatPath);
    }

    public long getProfileVal() {
        long timeDelta = this.mEndTime - this.mStartTime;
        if (timeDelta <= 0) {
            return 0;
        }
        return (((this.mEndValue - this.mStartValue) * 3600) * 1000) / timeDelta;
    }

    private long getStat(String path) {
        long value = 0;
        try {
            RandomAccessFile processCpuInfo = new RandomAccessFile(path, "r");
            String line = "";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.setLength(0);
            while (true) {
                line = processCpuInfo.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line + "\n");
            }
            String[] tok = stringBuffer.toString().split(" ");
            if (tok.length > 0) {
                value = Long.parseLong(tok[13]) + Long.parseLong(tok[14]);
            }
            processCpuInfo.close();
        } catch (FileNotFoundException e) {
            Log.e("", "FileNotFoundException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return value;
    }
}
