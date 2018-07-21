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
import java.io.FileReader;

public class BNLocateTrackManager
{
  private static final int GPS_RECORD_FORMAT_LEN_DEFAULT = 9;
  private static final int GPS_RECORD_FORMAT_LEN_V1 = 7;
  private static final int GPS_RECORD_FORMAT_LEN_V2 = 8;
  private static final Long GPS_RECORD_INTERNAL_INVALID = Long.valueOf(-1L);
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
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        paramAnonymousMessage = (LocData)paramAnonymousMessage.obj;
      } while (BNLocateTrackManager.this.mLocationListener == null);
      BNLocateTrackManager.this.mLocationListener.onLocationChange(paramAnonymousMessage);
    }
  };
  private boolean mIsFileTimeInternalUsed = true;
  private Long mLastStampTime = Long.valueOf(0L);
  private ILocationListener mLocationListener = null;
  private Long mRecordInternalTime = Long.valueOf(600L);
  private int mTimeInternal;
  private TrackThread mTrackThread = null;
  
  private BNLocateTrackManager()
  {
    mGPSTrackFilePath = SDCardUtils.getExternalStorageFile() + "/BaiduNavi/track/";
  }
  
  private void diposeTrackLocation()
  {
    synchronized (this.lock)
    {
      this.mFile = null;
      this.mBR = null;
      this.mFileIndex = 0;
      return;
    }
  }
  
  public static BNLocateTrackManager getInstance()
  {
    if (mInstance == null) {
      mInstance = new BNLocateTrackManager();
    }
    return mInstance;
  }
  
  private void initTrackLocation()
  {
    this.mFile = new File(mGPSTrackFilePath);
    if (!this.mFile.exists())
    {
      this.isFileInstalled = false;
      return;
    }
    this.isFileInstalled = true;
    this.mTimeInternal = 800;
    LogUtil.e(TAG, "initTrackLocation, mTimeInternal = " + this.mTimeInternal);
  }
  
  private LocData parseRecord(String paramString, boolean paramBoolean)
  {
    LocData localLocData = new LocData();
    int j = 0;
    double d3 = 0.0D;
    double d4 = 0.0D;
    float f4 = 0.0F;
    float f5 = 0.0F;
    float f6 = 0.0F;
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.split(",");
          i = j;
          if (paramString != null)
          {
            i = j;
            if (paramString.length > 0) {
              i = Integer.parseInt(paramString[0]);
            }
          }
          if (i == 2)
          {
            if (paramString.length == 7)
            {
              d2 = Double.parseDouble(paramString[1]);
              d1 = Double.parseDouble(paramString[2]);
              f3 = Float.parseFloat(paramString[3]);
              f2 = Float.parseFloat(paramString[4]);
              f1 = Float.parseFloat(paramString[5]);
              this.mRecordInternalTime = GPS_RECORD_INTERNAL_INVALID;
              localLocData.accuracy = f1;
              paramString = CoordinateTransformUtil.transferWGS84ToGCJ02(d2, d1);
              localLocData.longitude = (paramString.getLongitudeE6() / 100000.0D);
              localLocData.latitude = (paramString.getLatitudeE6() / 100000.0D);
              localLocData.speed = f3;
              localLocData.direction = f2;
              LogUtil.e(TAG, localLocData.toString());
              return localLocData;
            }
            if (paramString.length == 8)
            {
              Integer.parseInt(paramString[0]);
              d2 = Double.parseDouble(paramString[1]);
              d1 = Double.parseDouble(paramString[2]);
              f3 = Float.parseFloat(paramString[3]);
              f2 = Float.parseFloat(paramString[4]);
              f1 = Float.parseFloat(paramString[5]);
              this.mRecordInternalTime = Long.valueOf(Long.parseLong(paramString[7]));
              continue;
            }
            float f1 = f6;
            float f2 = f5;
            double d1 = d4;
            double d2 = d3;
            float f3 = f4;
            if (paramString.length != 9) {
              continue;
            }
            Integer.parseInt(paramString[0]);
            d3 = Double.parseDouble(paramString[1]);
            d4 = Double.parseDouble(paramString[2]);
            f4 = Float.parseFloat(paramString[3]);
            f5 = Float.parseFloat(paramString[4]);
            f6 = Float.parseFloat(paramString[5]);
            f1 = f6;
            f2 = f5;
            d1 = d4;
            d2 = d3;
            f3 = f4;
            if (!paramBoolean) {
              continue;
            }
            long l = Long.parseLong(paramString[8]);
            this.mRecordInternalTime = Long.valueOf(Math.abs(l - this.mLastStampTime.longValue()));
            this.mLastStampTime = Long.valueOf(l);
            LogUtil.e(TAG, "[文件时间戳] stampTime：" + l + "mRecordInternalTime:" + this.mRecordInternalTime);
            f1 = f6;
            f2 = f5;
            d1 = d4;
            d2 = d3;
            f3 = f4;
            continue;
            if (paramString.length == 2)
            {
              this.mRecordInternalTime = GPS_RECORD_INTERNAL_INVALID;
              f1 = f6;
              f2 = f5;
              d1 = d4;
              d2 = d3;
              f3 = f4;
              continue;
            }
            f1 = f6;
            f2 = f5;
            d1 = d4;
            d2 = d3;
            f3 = f4;
            if (paramString.length != 3) {
              continue;
            }
            this.mRecordInternalTime = Long.valueOf(Long.parseLong(paramString[2]));
            f1 = f6;
            f2 = f5;
            d1 = d4;
            d2 = d3;
            f3 = f4;
            continue;
            f1 = f6;
            f2 = f5;
            d1 = d4;
            d2 = d3;
            f3 = f4;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString) {}
      if (2 != i) {
        if (i != 0) {}
      }
    }
  }
  
  /* Error */
  private String readLastLine()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: ldc_w 278
    //   11: astore 5
    //   13: new 280	java/io/RandomAccessFile
    //   16: dup
    //   17: new 106	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   24: invokestatic 113	com/baidu/navisdk/util/common/SDCardUtils:getExternalStorageFile	()Ljava/io/File;
    //   27: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: ldc 33
    //   32: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: ldc_w 282
    //   41: invokespecial 284	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 4
    //   48: invokevirtual 287	java/io/RandomAccessFile:length	()J
    //   51: lstore_1
    //   52: aload 5
    //   54: astore_3
    //   55: lload_1
    //   56: lconst_0
    //   57: lcmp
    //   58: ifeq +42 -> 100
    //   61: lload_1
    //   62: lconst_1
    //   63: lsub
    //   64: lstore_1
    //   65: aload 5
    //   67: astore_3
    //   68: lload_1
    //   69: lconst_0
    //   70: lcmp
    //   71: ifle +29 -> 100
    //   74: lload_1
    //   75: lconst_1
    //   76: lsub
    //   77: lstore_1
    //   78: aload 4
    //   80: lload_1
    //   81: invokevirtual 291	java/io/RandomAccessFile:seek	(J)V
    //   84: aload 4
    //   86: invokevirtual 295	java/io/RandomAccessFile:readByte	()B
    //   89: bipush 10
    //   91: if_icmpne -26 -> 65
    //   94: aload 4
    //   96: invokevirtual 298	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   99: astore_3
    //   100: aload 4
    //   102: ifnull +200 -> 302
    //   105: aload 4
    //   107: invokevirtual 301	java/io/RandomAccessFile:close	()V
    //   110: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   113: new 106	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 303
    //   123: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_3
    //   127: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_3
    //   137: areturn
    //   138: astore 4
    //   140: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   143: ldc_w 305
    //   146: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -39 -> 110
    //   152: astore_3
    //   153: aload 6
    //   155: astore 4
    //   157: aload 4
    //   159: astore_3
    //   160: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   163: ldc_w 307
    //   166: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 5
    //   171: astore_3
    //   172: aload 4
    //   174: ifnull -64 -> 110
    //   177: aload 4
    //   179: invokevirtual 301	java/io/RandomAccessFile:close	()V
    //   182: aload 5
    //   184: astore_3
    //   185: goto -75 -> 110
    //   188: astore_3
    //   189: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   192: ldc_w 305
    //   195: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload 5
    //   200: astore_3
    //   201: goto -91 -> 110
    //   204: astore_3
    //   205: aload 7
    //   207: astore 4
    //   209: aload 4
    //   211: astore_3
    //   212: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   215: ldc_w 309
    //   218: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 5
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull -116 -> 110
    //   229: aload 4
    //   231: invokevirtual 301	java/io/RandomAccessFile:close	()V
    //   234: aload 5
    //   236: astore_3
    //   237: goto -127 -> 110
    //   240: astore_3
    //   241: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   244: ldc_w 305
    //   247: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 5
    //   252: astore_3
    //   253: goto -143 -> 110
    //   256: astore 4
    //   258: aload_3
    //   259: ifnull +7 -> 266
    //   262: aload_3
    //   263: invokevirtual 301	java/io/RandomAccessFile:close	()V
    //   266: aload 4
    //   268: athrow
    //   269: astore_3
    //   270: getstatic 65	com/baidu/navisdk/util/logic/BNLocateTrackManager:TAG	Ljava/lang/String;
    //   273: ldc_w 305
    //   276: invokestatic 176	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -13 -> 266
    //   282: astore 5
    //   284: aload 4
    //   286: astore_3
    //   287: aload 5
    //   289: astore 4
    //   291: goto -33 -> 258
    //   294: astore_3
    //   295: goto -86 -> 209
    //   298: astore_3
    //   299: goto -142 -> 157
    //   302: goto -192 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	BNLocateTrackManager
    //   51	30	1	l	long
    //   4	133	3	localObject1	Object
    //   152	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   159	26	3	localObject2	Object
    //   188	1	3	localIOException1	java.io.IOException
    //   200	1	3	localObject3	Object
    //   204	1	3	localIOException2	java.io.IOException
    //   211	26	3	localObject4	Object
    //   240	1	3	localIOException3	java.io.IOException
    //   252	11	3	localObject5	Object
    //   269	1	3	localIOException4	java.io.IOException
    //   286	1	3	localObject6	Object
    //   294	1	3	localIOException5	java.io.IOException
    //   298	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   44	62	4	localRandomAccessFile	java.io.RandomAccessFile
    //   138	1	4	localIOException6	java.io.IOException
    //   155	75	4	localObject7	Object
    //   256	29	4	localObject8	Object
    //   289	1	4	localObject9	Object
    //   11	240	5	str	String
    //   282	6	5	localObject10	Object
    //   6	148	6	localObject11	Object
    //   1	205	7	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   105	110	138	java/io/IOException
    //   13	46	152	java/io/FileNotFoundException
    //   177	182	188	java/io/IOException
    //   13	46	204	java/io/IOException
    //   229	234	240	java/io/IOException
    //   13	46	256	finally
    //   160	169	256	finally
    //   212	221	256	finally
    //   262	266	269	java/io/IOException
    //   46	52	282	finally
    //   78	84	282	finally
    //   84	100	282	finally
    //   46	52	294	java/io/IOException
    //   78	84	294	java/io/IOException
    //   84	100	294	java/io/IOException
    //   46	52	298	java/io/FileNotFoundException
    //   78	84	298	java/io/FileNotFoundException
    //   84	100	298	java/io/FileNotFoundException
  }
  
  private LocData readOneRecord()
  {
    for (;;)
    {
      try
      {
        if ((this.mBR == null) && (this.mFile != null) && (this.mFile.exists()))
        {
          localObject1 = this.mFile.listFiles();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int i = localObject1.length;
            if (this.mFileIndex >= i) {
              continue;
            }
            localObject1 = localObject1[this.mFileIndex];
            if (((File)localObject1).isFile())
            {
              String str = ((File)localObject1).getName();
              LogUtil.e(TAG, "GPS Data fileName = " + str);
              if ((!TextUtils.isEmpty(str)) && (str.endsWith(".txt"))) {
                this.mBR = new BufferedReader(new FileReader((File)localObject1));
              }
            }
          }
        }
        localObject1 = this.mBR.readLine();
        LogUtil.e(TAG, "line = " + (String)localObject1);
        localObject1 = parseRecord((String)localObject1, true);
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2 = null;
        continue;
      }
      finally {}
      return (LocData)localObject1;
      this.mFileIndex = 0;
    }
  }
  
  public int getTimeInternal()
  {
    return this.mTimeInternal;
  }
  
  public boolean getTimeInternalEnable()
  {
    return this.mIsFileTimeInternalUsed;
  }
  
  public void guideSingleStep()
  {
    LocData localLocData = readOneRecord();
    if ((localLocData != null) && (this.mLocationListener != null)) {
      this.mLocationListener.onLocationChange(localLocData);
    }
  }
  
  public boolean isGpsTrackFileInstalled()
  {
    return this.isFileInstalled;
  }
  
  public void setTimeInternal(int paramInt)
  {
    if (!this.mIsFileTimeInternalUsed)
    {
      LogUtil.e(TAG, "setTimeInternal, mIsTimeInternalUsed = false, internal = " + paramInt);
      this.mTimeInternal = paramInt;
    }
  }
  
  public void setTimeInternalEnable(boolean paramBoolean)
  {
    this.mIsFileTimeInternalUsed = paramBoolean;
    if ((this.mTrackThread != null) && (this.mTrackThread.isAlive()) && (!this.mIsFileTimeInternalUsed))
    {
      LogUtil.e(TAG, "setTimeInternalEnable, mTrackThread.interrupt()");
      this.mTrackThread.interrupt();
    }
  }
  
  public void setTrackLocationListener(ILocationListener paramILocationListener)
  {
    this.mLocationListener = paramILocationListener;
  }
  
  public void startTrackGuide()
  {
    initTrackLocation();
    if (this.isFileInstalled)
    {
      this.mTrackThread = new TrackThread(null);
      if (!this.mTrackThread.isAlive()) {
        this.mTrackThread.start();
      }
    }
    else
    {
      return;
    }
    LogUtil.e(TAG, "startTrackGuide mTrackThread already started");
  }
  
  public void stopTrackGuide()
  {
    if (!this.isFileInstalled) {
      return;
    }
    if ((this.mTrackThread != null) && (this.mTrackThread.isAlive()))
    {
      LogUtil.e(TAG, "用户中断轨迹复现");
      this.mTrackThread.stopTracking();
      this.mLastStampTime = Long.valueOf(0L);
      this.mTrackThread = null;
    }
    diposeTrackLocation();
  }
  
  private class TrackThread
    extends Thread
  {
    private volatile boolean isRunning = true;
    
    private TrackThread() {}
    
    public void run()
    {
      Object localObject1 = BNLocateTrackManager.this.readOneRecord();
      for (;;)
      {
        if ((this.isRunning) && (localObject1 != null)) {
          try
          {
            if (BNLocateTrackManager.this.mIsFileTimeInternalUsed)
            {
              LogUtil.e(BNLocateTrackManager.TAG, "[文件时间戳]读取轨迹记录点成功，延时" + BNLocateTrackManager.this.mRecordInternalTime + "ms执行");
              sleep(800L);
            }
            for (;;)
            {
              Object localObject2 = BNLocateTrackManager.this.mHandler.obtainMessage(1);
              ((Message)localObject2).obj = localObject1;
              BNLocateTrackManager.this.mHandler.sendMessage((Message)localObject2);
              localObject2 = BNLocateTrackManager.this.readOneRecord();
              localObject1 = localObject2;
              if (localObject2 != null) {
                break;
              }
              LogUtil.e(BNLocateTrackManager.TAG, "轨迹点为空，轨迹导航停止");
              BNLocateTrackManager.access$602(BNLocateTrackManager.this, null);
              BNLocateTrackManager.access$708(BNLocateTrackManager.this);
              localObject1 = BNLocateTrackManager.this.readOneRecord();
              break;
              LogUtil.e(BNLocateTrackManager.TAG, "[用户设定]读取轨迹记录点成功，延时" + BNLocateTrackManager.this.mTimeInternal + "ms执行");
              sleep(800L);
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              LogUtil.e(BNLocateTrackManager.TAG, "TrackThread sleep InterruptedException IN");
            }
          }
        }
      }
    }
    
    public void stopTracking()
    {
      this.isRunning = false;
      interrupt();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/logic/BNLocateTrackManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */