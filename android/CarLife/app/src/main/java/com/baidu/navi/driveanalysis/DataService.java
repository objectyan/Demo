package com.baidu.navi.driveanalysis;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.util.C2172c;
import com.baidu.navi.driveanalysis.cache.Cache;
import com.baidu.navi.driveanalysis.cache.INotify;
import com.baidu.navi.driveanalysis.model.TrackModel;
import com.baidu.navi.driveanalysis.network.EachMinuteRequest;
import com.baidu.navi.driveanalysis.network.FileUploadRequest;
import com.baidu.navi.driveanalysis.util.CSVFileOperator;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataService extends Service {
    public static String ABS_FILE_NAME = null;
    public static final String FILE_NAME = "trackdata.csv";
    private long MIN_UPLOAD_TIME = 15000;
    private final int MSG_TRACK_DATA_UPDOAD = 1;
    private final int NETWORK_DETECT_CYCLE = 1000;
    private final String TAG = DataService.class.getSimpleName();
    private Cache mCache;
    private String mCuid = C2172c.b();
    private EachMinuteRequest mEachMinuteRequest;
    private FileUploadRequest mFileUploadRequest;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private LocationChangeListener mLocationListener = new C37733();
    private LocationManager mLocationManager;
    private INotify mNotify;
    private boolean mUpLoadThreadFlag = true;
    private Object mUploadLock = new Object();
    private UploadThread mUploadThread;
    private long preUploadTime = 0;

    /* renamed from: com.baidu.navi.driveanalysis.DataService$1 */
    class C37711 implements INotify {
        C37711() {
        }

        public void dataChangeNotify() {
            synchronized (DataService.this.mUploadLock) {
                DataService.this.mUploadLock.notifyAll();
            }
        }
    }

    /* renamed from: com.baidu.navi.driveanalysis.DataService$3 */
    class C37733 implements LocationChangeListener {
        C37733() {
        }

        public void onLocationChange(LocData locData) {
            if (locData != null) {
                long localTime = System.currentTimeMillis();
                if (DataService.this.isAvailableUploadTime(localTime)) {
                    TrackModel model = new TrackModel();
                    model.entityName = DataService.this.mCuid;
                    model.latitude = locData.latitude;
                    model.longitude = locData.longitude;
                    model.coordType = 2;
                    model.speed = (double) ((locData.speed * 3600.0f) / 1000.0f);
                    model.direction = (int) locData.direction;
                    if (Math.abs(locData.altitude) < 1.0d) {
                        model.height = 1.0d;
                    } else {
                        model.height = locData.altitude;
                    }
                    model.radius = (double) locData.accuracy;
                    model.localTime = localTime / 1000;
                    model.isConnectWithVehicle = C1765g.a().f();
                    if (DataService.this.isAvailuableGPSData(model)) {
                        DataService.this.updatTrackData(model);
                    }
                }
            }
        }

        public CoordType onGetCoordType() {
            return CoordType.CoordType_GCJ02;
        }
    }

    public class DataUploadBinder extends Binder {
        public void startUpload() {
            DataService.this.startGPSListen();
        }

        public void stopUpload() {
            DataService.this.stopGSPListen();
        }
    }

    class UploadThread extends Thread {
        UploadThread() {
        }

        public void run() {
            while (DataService.this.mUpLoadThreadFlag) {
                if (DataService.this.mCache.getSize() < 4) {
                    try {
                        synchronized (DataService.this.mUploadLock) {
                            DataService.this.mUploadLock.wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (C1251e.a().r()) {
                    DataService.this.uploadData();
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void onCreate() {
        init();
    }

    public void onDestroy() {
        this.mUpLoadThreadFlag = false;
    }

    public IBinder onBind(Intent intent) {
        return new DataUploadBinder();
    }

    private void init() {
        ABS_FILE_NAME = getFilesDir().getAbsolutePath() + File.separator + FILE_NAME;
        this.mCache = new Cache();
        this.mNotify = new C37711();
        this.mCache.initNotify(this.mNotify);
        this.mHandlerThread = new HandlerThread(DataService.class.getSimpleName());
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        DataService.this.preserveData((TrackModel) msg.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mEachMinuteRequest = new EachMinuteRequest();
        this.mUploadThread = new UploadThread();
        this.mUploadThread.start();
    }

    private void preserveData(TrackModel model) {
        writeCache(model);
    }

    private void writeCache(TrackModel model) {
        this.mCache.insert(model);
    }

    private void uploadData() {
        if (this.mCache.getSize() == 4) {
            this.mEachMinuteRequest.setParamsModel(this.mCache.take(4));
            this.mEachMinuteRequest.toPostRequest();
            return;
        }
        CSVFileOperator.write(this.mCache.takeAll(), ABS_FILE_NAME);
        InputStream in = null;
        try {
            in = getBaseContext().openFileInput(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mFileUploadRequest = new FileUploadRequest(C2172c.b(), FILE_NAME, in);
        fileCopy(FILE_NAME, "/sdcard/data/");
        this.mFileUploadRequest.toPostRequest();
    }

    private void updatTrackData(TrackModel model) {
        Message msg = new Message();
        msg.what = 1;
        msg.obj = model;
        this.mHandler.sendMessage(msg);
    }

    private void startGPSListen() {
        this.mLocationManager = LocationManager.getInstance();
        this.mLocationManager.addLocationChangeLister(this.mLocationListener);
    }

    private void stopGSPListen() {
        if (this.mLocationManager != null) {
            this.mLocationManager.removeLocationChangeLister(this.mLocationListener);
        }
    }

    private boolean isAvailableUploadTime(long time) {
        if (this.preUploadTime == 0) {
            this.preUploadTime = time;
            return true;
        } else if (time - this.preUploadTime < this.MIN_UPLOAD_TIME) {
            return false;
        } else {
            this.preUploadTime = time;
            return true;
        }
    }

    public boolean fileCopy(String from, String to) {
        if (from == null || to == null) {
            C1260i.e(this.TAG, "from or to is null");
            return false;
        }
        int bytesum = 0;
        try {
            File oldfile = new File(from);
            InputStream is = getBaseContext().openFileInput(from);
            File newfile = new File(to);
            if (newfile.isDirectory()) {
                newfile = new File(to + "/" + from);
            }
            if (!newfile.exists()) {
                newfile.createNewFile();
            }
            BufferedOutputStream bfs = new BufferedOutputStream(new FileOutputStream(newfile));
            byte[] buffer = new byte[1024];
            while (true) {
                int byteread = is.read(buffer);
                if (byteread != -1) {
                    bytesum += byteread;
                    bfs.write(buffer, 0, byteread);
                } else {
                    is.close();
                    bfs.close();
                    C1260i.b(this.TAG, "Dump [" + from + "] to [" + to + "] Success");
                    return true;
                }
            }
        } catch (Exception e) {
            C1260i.e(this.TAG, "Dump [" + from + "] to [" + to + "] Failed");
            e.printStackTrace();
            return false;
        }
    }

    private boolean isAvailuableGPSData(TrackModel model) {
        if (model.latitude < -90.0d || model.latitude > 90.0d) {
            return false;
        }
        if (model.longitude < -180.0d || model.longitude > 180.0d) {
            return false;
        }
        if (model.coordType < 1 || model.coordType > 3) {
            return false;
        }
        if (model.direction < 0 || model.direction > 359) {
            return false;
        }
        return true;
    }
}
