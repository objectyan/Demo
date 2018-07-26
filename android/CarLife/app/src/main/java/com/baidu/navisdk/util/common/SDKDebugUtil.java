package com.baidu.navisdk.util.common;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDKDebugUtil {
    private static final int RECORD_RP_ERROR_CODE = 1;
    private static SDKDebugUtil sInstance = null;
    private static final String sRpErrorCodeFileName = "error_code.txt";
    private Handler mHandler = null;
    private HandlerThread mThread = new HandlerThread("sdkDebug");

    private SDKDebugUtil() {
        if (!(this.mThread == null || this.mThread.isAlive())) {
            this.mThread.start();
        }
        this.mHandler = new Handler(this.mThread.getLooper()) {
            public void handleMessage(Message msg) {
                IOException e;
                Throwable th;
                switch (msg.what) {
                    case 1:
                        int errorCode = msg.arg1;
                        BufferedWriter writer = null;
                        try {
                            BufferedWriter writer2 = new BufferedWriter(new FileWriter(SDKDebugUtil.this.getErrorCodeFile(SDKDebugUtil.sRpErrorCodeFileName), true));
                            try {
                                writer2.write(SDKDebugUtil.this.getErrorCodeStr(errorCode));
                                writer2.newLine();
                                writer2.flush();
                                if (writer2 != null) {
                                    try {
                                        writer2.close();
                                        writer = writer2;
                                        return;
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        writer = writer2;
                                        return;
                                    }
                                }
                                return;
                            } catch (IOException e3) {
                                e2 = e3;
                                writer = writer2;
                                try {
                                    LogUtil.m15791e("SDKDebugUtil", "e:" + e2.getMessage());
                                    if (writer != null) {
                                        try {
                                            writer.close();
                                            return;
                                        } catch (IOException e22) {
                                            e22.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (writer != null) {
                                        try {
                                            writer.close();
                                        } catch (IOException e222) {
                                            e222.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                writer = writer2;
                                if (writer != null) {
                                    writer.close();
                                }
                                throw th;
                            }
                        } catch (IOException e4) {
                            e222 = e4;
                            LogUtil.m15791e("SDKDebugUtil", "e:" + e222.getMessage());
                            if (writer != null) {
                                writer.close();
                                return;
                            }
                            return;
                        }
                    default:
                        return;
                }
            }
        };
    }

    private File getErrorCodeFile(String name) {
        File file = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + name);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private String getErrorCodeStr(int errorCode) {
        return new SimpleDateFormat("yyyyMMdd_HH:mm:ss_").format(new Date()) + String.valueOf(errorCode);
    }

    public static SDKDebugUtil getInstance() {
        if (sInstance == null) {
            synchronized (SDKDebugUtil.class) {
                if (sInstance == null) {
                    sInstance = new SDKDebugUtil();
                }
            }
        }
        return sInstance;
    }

    @SuppressLint({"NewApi"})
    public void destory() {
        if (this.mThread != null && this.mThread.isAlive()) {
            this.mThread.quit();
        }
    }

    public void recordRPErrorCode(int code) {
        if (this.mHandler != null) {
            Message msg = this.mHandler.obtainMessage(1);
            msg.arg1 = code;
            msg.sendToTarget();
        }
    }
}
