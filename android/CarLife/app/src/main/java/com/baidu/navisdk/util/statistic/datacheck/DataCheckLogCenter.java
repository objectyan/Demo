package com.baidu.navisdk.util.statistic.datacheck;

import com.baidu.mapframework.common.p202a.C3473h;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCheckLogCenter {
    public static final String CHECKDATA_FOLDER = "/log/dc";
    private static DataCheckLogCenter sInstance = null;
    private static Object sSyncObj = new Object();
    private boolean mIsInitOK = false;
    private FileWriter mLogFileWriter = null;

    public static DataCheckLogCenter getInstance() {
        if (sInstance == null) {
            synchronized (sSyncObj) {
                if (sInstance == null) {
                    sInstance = new DataCheckLogCenter();
                }
            }
        }
        return sInstance;
    }

    private DataCheckLogCenter() {
        if (LogUtil.LOGGABLE) {
            init();
        }
    }

    private void init() {
        initDirs();
        initLogFile();
    }

    public void uninit() {
        if (this.mLogFileWriter != null) {
            try {
                this.mLogFileWriter.flush();
                this.mLogFileWriter.close();
            } catch (IOException e) {
            }
        }
    }

    private static void initDirs() {
        File f = new File(SysOSAPI.getInstance().GetSDCardPath() + CHECKDATA_FOLDER);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    private void initLogFile() {
        if (new File(SysOSAPI.getInstance().GetSDCardPath() + CHECKDATA_FOLDER).exists()) {
            try {
                this.mLogFileWriter = new FileWriter(SysOSAPI.getInstance().GetSDCardPath() + CHECKDATA_FOLDER + "/dc" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + C3473h.f18755a, true);
            } catch (IOException e) {
                DataCheckCenter.log("failed to init log file writer.");
                this.mIsInitOK = false;
            }
            this.mIsInitOK = true;
            return;
        }
        this.mIsInitOK = false;
    }

    public void appendLog(String info) {
        if (this.mIsInitOK && this.mLogFileWriter != null) {
            try {
                this.mLogFileWriter.append(info);
                this.mLogFileWriter.flush();
            } catch (IOException e) {
                DataCheckCenter.log("failed to append log to file.");
            }
        }
    }

    public String getCurTimeString() {
        return new SimpleDateFormat("[yyyy-MM-dd_HH:mm:ss]").format(new Date());
    }
}
