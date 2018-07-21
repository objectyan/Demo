package com.baidu.navi.driveanalysis;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.logic.g;
import com.baidu.carlife.util.c;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataService
  extends Service
{
  public static String ABS_FILE_NAME = null;
  public static final String FILE_NAME = "trackdata.csv";
  private long MIN_UPLOAD_TIME = 15000L;
  private final int MSG_TRACK_DATA_UPDOAD = 1;
  private final int NETWORK_DETECT_CYCLE = 1000;
  private final String TAG = DataService.class.getSimpleName();
  private Cache mCache;
  private String mCuid = c.b();
  private EachMinuteRequest mEachMinuteRequest;
  private FileUploadRequest mFileUploadRequest;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private LocationChangeListener mLocationListener = new LocationChangeListener()
  {
    public LocationChangeListener.CoordType onGetCoordType()
    {
      return LocationChangeListener.CoordType.CoordType_GCJ02;
    }
    
    public void onLocationChange(LocationManager.LocData paramAnonymousLocData)
    {
      long l;
      if (paramAnonymousLocData != null)
      {
        l = System.currentTimeMillis();
        if (DataService.this.isAvailableUploadTime(l)) {}
      }
      else
      {
        return;
      }
      TrackModel localTrackModel = new TrackModel();
      localTrackModel.entityName = DataService.this.mCuid;
      localTrackModel.latitude = paramAnonymousLocData.latitude;
      localTrackModel.longitude = paramAnonymousLocData.longitude;
      localTrackModel.coordType = 2;
      localTrackModel.speed = (paramAnonymousLocData.speed * 3600.0F / 1000.0F);
      localTrackModel.direction = ((int)paramAnonymousLocData.direction);
      if (Math.abs(paramAnonymousLocData.altitude) < 1.0D) {}
      for (localTrackModel.height = 1.0D;; localTrackModel.height = paramAnonymousLocData.altitude)
      {
        localTrackModel.radius = paramAnonymousLocData.accuracy;
        localTrackModel.localTime = (l / 1000L);
        localTrackModel.isConnectWithVehicle = g.a().f();
        if (!DataService.this.isAvailuableGPSData(localTrackModel)) {
          break;
        }
        DataService.this.updatTrackData(localTrackModel);
        return;
      }
    }
  };
  private LocationManager mLocationManager;
  private INotify mNotify;
  private boolean mUpLoadThreadFlag = true;
  private Object mUploadLock = new Object();
  private UploadThread mUploadThread;
  private long preUploadTime = 0L;
  
  private void init()
  {
    String str = getFilesDir().getAbsolutePath();
    ABS_FILE_NAME = str + File.separator + "trackdata.csv";
    this.mCache = new Cache();
    this.mNotify = new INotify()
    {
      public void dataChangeNotify()
      {
        synchronized (DataService.this.mUploadLock)
        {
          DataService.this.mUploadLock.notifyAll();
          return;
        }
      }
    };
    this.mCache.initNotify(this.mNotify);
    this.mHandlerThread = new HandlerThread(DataService.class.getSimpleName());
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        DataService.this.preserveData((TrackModel)paramAnonymousMessage.obj);
      }
    };
    this.mEachMinuteRequest = new EachMinuteRequest();
    this.mUploadThread = new UploadThread();
    this.mUploadThread.start();
  }
  
  private boolean isAvailableUploadTime(long paramLong)
  {
    if (this.preUploadTime == 0L)
    {
      this.preUploadTime = paramLong;
      return true;
    }
    if (paramLong - this.preUploadTime >= this.MIN_UPLOAD_TIME)
    {
      this.preUploadTime = paramLong;
      return true;
    }
    return false;
  }
  
  private boolean isAvailuableGPSData(TrackModel paramTrackModel)
  {
    boolean bool = true;
    if ((paramTrackModel.latitude < -90.0D) || (paramTrackModel.latitude > 90.0D)) {
      bool = false;
    }
    do
    {
      return bool;
      if ((paramTrackModel.longitude < -180.0D) || (paramTrackModel.longitude > 180.0D)) {
        return false;
      }
      if ((paramTrackModel.coordType < 1) || (paramTrackModel.coordType > 3)) {
        return false;
      }
    } while ((paramTrackModel.direction >= 0) && (paramTrackModel.direction <= 359));
    return false;
  }
  
  private void preserveData(TrackModel paramTrackModel)
  {
    writeCache(paramTrackModel);
  }
  
  private void startGPSListen()
  {
    this.mLocationManager = LocationManager.getInstance();
    this.mLocationManager.addLocationChangeLister(this.mLocationListener);
  }
  
  private void stopGSPListen()
  {
    if (this.mLocationManager != null) {
      this.mLocationManager.removeLocationChangeLister(this.mLocationListener);
    }
  }
  
  private void updatTrackData(TrackModel paramTrackModel)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramTrackModel;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void uploadData()
  {
    if (this.mCache.getSize() == 4)
    {
      localObject = this.mCache.take(4);
      this.mEachMinuteRequest.setParamsModel((List)localObject);
      this.mEachMinuteRequest.toPostRequest();
      return;
    }
    CSVFileOperator.write(this.mCache.takeAll(), ABS_FILE_NAME);
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = getBaseContext().openFileInput("trackdata.csv");
      localObject = localFileInputStream;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    this.mFileUploadRequest = new FileUploadRequest(c.b(), "trackdata.csv", (InputStream)localObject);
    fileCopy("trackdata.csv", "/sdcard/data/");
    this.mFileUploadRequest.toPostRequest();
  }
  
  private void writeCache(TrackModel paramTrackModel)
  {
    this.mCache.insert(paramTrackModel);
  }
  
  public boolean fileCopy(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      i.e(this.TAG, "from or to is null");
      return false;
    }
    int i = 0;
    try
    {
      new File(paramString1);
      FileInputStream localFileInputStream = getBaseContext().openFileInput(paramString1);
      Object localObject2 = new File(paramString2);
      Object localObject1 = localObject2;
      if (((File)localObject2).isDirectory()) {
        localObject1 = new File(paramString2 + "/" + paramString1);
      }
      if (!((File)localObject1).exists()) {
        ((File)localObject1).createNewFile();
      }
      localObject1 = new BufferedOutputStream(new FileOutputStream((File)localObject1));
      localObject2 = new byte['Ѐ'];
      for (;;)
      {
        int j = localFileInputStream.read((byte[])localObject2);
        if (j == -1) {
          break;
        }
        i += j;
        ((BufferedOutputStream)localObject1).write((byte[])localObject2, 0, j);
      }
      localFileInputStream.close();
    }
    catch (Exception localException)
    {
      i.e(this.TAG, "Dump [" + paramString1 + "] to [" + paramString2 + "] Failed");
      localException.printStackTrace();
      return false;
    }
    localException.close();
    i.b(this.TAG, "Dump [" + paramString1 + "] to [" + paramString2 + "] Success");
    return true;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new DataUploadBinder();
  }
  
  public void onCreate()
  {
    init();
  }
  
  public void onDestroy()
  {
    this.mUpLoadThreadFlag = false;
  }
  
  public class DataUploadBinder
    extends Binder
  {
    public DataUploadBinder() {}
    
    public void startUpload()
    {
      DataService.this.startGPSListen();
    }
    
    public void stopUpload()
    {
      DataService.this.stopGSPListen();
    }
  }
  
  class UploadThread
    extends Thread
  {
    UploadThread() {}
    
    public void run()
    {
      while (DataService.this.mUpLoadThreadFlag) {
        if (DataService.this.mCache.getSize() < 4) {
          try
          {
            synchronized (DataService.this.mUploadLock)
            {
              DataService.this.mUploadLock.wait();
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        } else if (!e.a().r()) {
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        } else {
          DataService.this.uploadData();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/driveanalysis/DataService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */