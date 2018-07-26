package com.baidu.navisdk.util.logic;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SDCardUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BNLocateTrackManager {
    private static final int GPS_RECORD_FORMAT_LEN_DEFAULT = 9;
    private static final int GPS_RECORD_FORMAT_LEN_V1 = 7;
    private static final int GPS_RECORD_FORMAT_LEN_V2 = 8;
    private static final Long GPS_RECORD_INTERNAL_INVALID = Long.valueOf(-1);
    private static final int MSG_GPS_TRACK_SUCC = 1;
    private static final int MSG_SENSOR_TRACK_SUCC = 2;
    private static final String TAG = BNLocateTrackManager.class.getSimpleName();
    public static final int TIME_INTERNAL_HIGH = 800;
    public static final int TIME_INTERNAL_LOW = 300;
    public static final int TIME_INTERNAL_MIDDLE = 500;
    private static final String TRACK_PATH = "/BaiduNavi/track/";
    private static String mGPSTrackFilePath;
    private static volatile BNLocateTrackManager mInstance = null;
    private boolean isFileInstalled = false;
    private Object lock = new Object();
    private BufferedReader mBR;
    private File mFile;
    private int mFileIndex = 0;
    private Handler mHandler = new C47101();
    private boolean mIsFileTimeInternalUsed = true;
    private Long mLastStampTime = Long.valueOf(0);
    private ILocationListener mLocationListener = null;
    private Long mRecordInternalTime = Long.valueOf(600);
    private int mTimeInternal;
    private TrackThread mTrackThread = null;

    /* renamed from: com.baidu.navisdk.util.logic.BNLocateTrackManager$1 */
    class C47101 extends Handler {
        C47101() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    LocData loc = msg.obj;
                    if (BNLocateTrackManager.this.mLocationListener != null) {
                        BNLocateTrackManager.this.mLocationListener.onLocationChange(loc);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private class TrackThread extends Thread {
        private volatile boolean isRunning;

        private TrackThread() {
            this.isRunning = true;
        }

        public void run() {
            LocData location = BNLocateTrackManager.this.readOneRecord();
            while (this.isRunning && location != null) {
                try {
                    if (BNLocateTrackManager.this.mIsFileTimeInternalUsed) {
                        LogUtil.m15791e(BNLocateTrackManager.TAG, "[文件时间戳]读取轨迹记录点成功，延时" + BNLocateTrackManager.this.mRecordInternalTime + "ms执行");
                        sleep(800);
                    } else {
                        LogUtil.m15791e(BNLocateTrackManager.TAG, "[用户设定]读取轨迹记录点成功，延时" + BNLocateTrackManager.this.mTimeInternal + "ms执行");
                        sleep(800);
                    }
                } catch (InterruptedException e) {
                    LogUtil.m15791e(BNLocateTrackManager.TAG, "TrackThread sleep InterruptedException IN");
                }
                Message msg = BNLocateTrackManager.this.mHandler.obtainMessage(1);
                msg.obj = location;
                BNLocateTrackManager.this.mHandler.sendMessage(msg);
                location = BNLocateTrackManager.this.readOneRecord();
                if (location == null) {
                    LogUtil.m15791e(BNLocateTrackManager.TAG, "轨迹点为空，轨迹导航停止");
                    BNLocateTrackManager.this.mBR = null;
                    BNLocateTrackManager.this.mFileIndex = BNLocateTrackManager.this.mFileIndex + 1;
                    location = BNLocateTrackManager.this.readOneRecord();
                }
            }
        }

        public void stopTracking() {
            this.isRunning = false;
            interrupt();
        }
    }

    private BNLocateTrackManager() {
        mGPSTrackFilePath = SDCardUtils.getExternalStorageFile() + TRACK_PATH;
    }

    public static BNLocateTrackManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNLocateTrackManager();
        }
        return mInstance;
    }

    public boolean isGpsTrackFileInstalled() {
        return this.isFileInstalled;
    }

    public void startTrackGuide() {
        initTrackLocation();
        if (this.isFileInstalled) {
            this.mTrackThread = new TrackThread();
            if (this.mTrackThread.isAlive()) {
                LogUtil.m15791e(TAG, "startTrackGuide mTrackThread already started");
            } else {
                this.mTrackThread.start();
            }
        }
    }

    public void stopTrackGuide() {
        if (this.isFileInstalled) {
            if (this.mTrackThread != null && this.mTrackThread.isAlive()) {
                LogUtil.m15791e(TAG, "用户中断轨迹复现");
                this.mTrackThread.stopTracking();
                this.mLastStampTime = Long.valueOf(0);
                this.mTrackThread = null;
            }
            diposeTrackLocation();
        }
    }

    public void guideSingleStep() {
        LocData location = readOneRecord();
        if (location != null && this.mLocationListener != null) {
            this.mLocationListener.onLocationChange(location);
        }
    }

    private synchronized LocData readOneRecord() {
        LocData parseRecord;
        try {
            if (this.mBR == null && this.mFile != null && this.mFile.exists()) {
                File[] files = this.mFile.listFiles();
                if (files != null && files.length > 0) {
                    if (this.mFileIndex < files.length) {
                        File file = files[this.mFileIndex];
                        if (file.isFile()) {
                            String casePath = file.getName();
                            LogUtil.m15791e(TAG, "GPS Data fileName = " + casePath);
                            if (!TextUtils.isEmpty(casePath) && casePath.endsWith(".txt")) {
                                this.mBR = new BufferedReader(new FileReader(file));
                            }
                        }
                    } else {
                        this.mFileIndex = 0;
                    }
                }
            }
            String strLine = this.mBR.readLine();
            LogUtil.m15791e(TAG, "line = " + strLine);
            parseRecord = parseRecord(strLine, true);
        } catch (Exception e) {
            parseRecord = null;
        }
        return parseRecord;
    }

    private LocData parseRecord(String line, boolean isRecordInternalTime) {
        LocData loc = new LocData();
        int status = 0;
        double Longitude = 0.0d;
        double Latitude = 0.0d;
        float Speed = 0.0f;
        float Angle = 0.0f;
        float Accuracy = 0.0f;
        try {
            if (!TextUtils.isEmpty(line)) {
                String[] locationString = line.split(",");
                if (locationString != null && locationString.length > 0) {
                    status = Integer.parseInt(locationString[0]);
                }
                if (status == 2) {
                    if (locationString.length == 7) {
                        Longitude = Double.parseDouble(locationString[1]);
                        Latitude = Double.parseDouble(locationString[2]);
                        Speed = Float.parseFloat(locationString[3]);
                        Angle = Float.parseFloat(locationString[4]);
                        Accuracy = Float.parseFloat(locationString[5]);
                        this.mRecordInternalTime = GPS_RECORD_INTERNAL_INVALID;
                    } else if (locationString.length == 8) {
                        status = Integer.parseInt(locationString[0]);
                        Longitude = Double.parseDouble(locationString[1]);
                        Latitude = Double.parseDouble(locationString[2]);
                        Speed = Float.parseFloat(locationString[3]);
                        Angle = Float.parseFloat(locationString[4]);
                        Accuracy = Float.parseFloat(locationString[5]);
                        this.mRecordInternalTime = Long.valueOf(Long.parseLong(locationString[7]));
                    } else if (locationString.length == 9) {
                        status = Integer.parseInt(locationString[0]);
                        Longitude = Double.parseDouble(locationString[1]);
                        Latitude = Double.parseDouble(locationString[2]);
                        Speed = Float.parseFloat(locationString[3]);
                        Angle = Float.parseFloat(locationString[4]);
                        Accuracy = Float.parseFloat(locationString[5]);
                        if (isRecordInternalTime) {
                            long stampTime = Long.parseLong(locationString[8]);
                            this.mRecordInternalTime = Long.valueOf(Math.abs(stampTime - this.mLastStampTime.longValue()));
                            this.mLastStampTime = Long.valueOf(stampTime);
                            LogUtil.m15791e(TAG, "[文件时间戳] stampTime：" + stampTime + "mRecordInternalTime:" + this.mRecordInternalTime);
                        }
                    }
                } else if (2 == status || status == 0) {
                    if (locationString.length == 2) {
                        this.mRecordInternalTime = GPS_RECORD_INTERNAL_INVALID;
                    } else if (locationString.length == 3) {
                        this.mRecordInternalTime = Long.valueOf(Long.parseLong(locationString[2]));
                    }
                }
                loc.accuracy = Accuracy;
                GeoPoint point = CoordinateTransformUtil.transferWGS84ToGCJ02(Longitude, Latitude);
                loc.longitude = ((double) point.getLongitudeE6()) / 100000.0d;
                loc.latitude = ((double) point.getLatitudeE6()) / 100000.0d;
                loc.speed = Speed;
                loc.direction = Angle;
                LogUtil.m15791e(TAG, loc.toString());
                return loc;
            }
        } catch (Exception e) {
        }
        return null;
    }

    private String readLastLine() {
        Throwable th;
        RandomAccessFile raf = null;
        String lastLine = "";
        try {
            RandomAccessFile raf2 = new RandomAccessFile(SDCardUtils.getExternalStorageFile() + TRACK_PATH, "r");
            try {
                long len = raf2.length();
                if (len != 0) {
                    long pos = len - 1;
                    while (pos > 0) {
                        pos--;
                        raf2.seek(pos);
                        if (raf2.readByte() == (byte) 10) {
                            lastLine = raf2.readLine();
                            break;
                        }
                    }
                }
                if (raf2 != null) {
                    try {
                        raf2.close();
                        raf = raf2;
                    } catch (IOException e) {
                        LogUtil.m15791e(TAG, "RandomAccessFile close error!");
                        raf = raf2;
                    }
                }
            } catch (FileNotFoundException e2) {
                raf = raf2;
                try {
                    LogUtil.m15791e(TAG, "Track file not found!");
                    if (raf != null) {
                        try {
                            raf.close();
                        } catch (IOException e3) {
                            LogUtil.m15791e(TAG, "RandomAccessFile close error!");
                        }
                    }
                    LogUtil.m15791e(TAG, "LastLine : " + lastLine);
                    return lastLine;
                } catch (Throwable th2) {
                    th = th2;
                    if (raf != null) {
                        try {
                            raf.close();
                        } catch (IOException e4) {
                            LogUtil.m15791e(TAG, "RandomAccessFile close error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                raf = raf2;
                LogUtil.m15791e(TAG, "RandomAccessFile io error!");
                if (raf != null) {
                    try {
                        raf.close();
                    } catch (IOException e6) {
                        LogUtil.m15791e(TAG, "RandomAccessFile close error!");
                    }
                }
                LogUtil.m15791e(TAG, "LastLine : " + lastLine);
                return lastLine;
            } catch (Throwable th3) {
                th = th3;
                raf = raf2;
                if (raf != null) {
                    raf.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            LogUtil.m15791e(TAG, "Track file not found!");
            if (raf != null) {
                raf.close();
            }
            LogUtil.m15791e(TAG, "LastLine : " + lastLine);
            return lastLine;
        } catch (IOException e8) {
            LogUtil.m15791e(TAG, "RandomAccessFile io error!");
            if (raf != null) {
                raf.close();
            }
            LogUtil.m15791e(TAG, "LastLine : " + lastLine);
            return lastLine;
        }
        LogUtil.m15791e(TAG, "LastLine : " + lastLine);
        return lastLine;
    }

    public void setTrackLocationListener(ILocationListener l) {
        this.mLocationListener = l;
    }

    public void setTimeInternalEnable(boolean b) {
        this.mIsFileTimeInternalUsed = b;
        if (this.mTrackThread != null && this.mTrackThread.isAlive() && !this.mIsFileTimeInternalUsed) {
            LogUtil.m15791e(TAG, "setTimeInternalEnable, mTrackThread.interrupt()");
            this.mTrackThread.interrupt();
        }
    }

    public boolean getTimeInternalEnable() {
        return this.mIsFileTimeInternalUsed;
    }

    public void setTimeInternal(int internal) {
        if (!this.mIsFileTimeInternalUsed) {
            LogUtil.m15791e(TAG, "setTimeInternal, mIsTimeInternalUsed = false, internal = " + internal);
            this.mTimeInternal = internal;
        }
    }

    public int getTimeInternal() {
        return this.mTimeInternal;
    }

    private void initTrackLocation() {
        this.mFile = new File(mGPSTrackFilePath);
        if (this.mFile.exists()) {
            this.isFileInstalled = true;
            this.mTimeInternal = 800;
            LogUtil.m15791e(TAG, "initTrackLocation, mTimeInternal = " + this.mTimeInternal);
            return;
        }
        this.isFileInstalled = false;
    }

    private void diposeTrackLocation() {
        synchronized (this.lock) {
            this.mFile = null;
            this.mBR = null;
            this.mFileIndex = 0;
        }
    }
}
