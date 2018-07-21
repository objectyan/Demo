package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.IOException;

public class FellowStatItem
{
  private static final boolean FELLOW_DEBUG = BNSettingManager.isShowJavaLog();
  private static final String STAT_LOG_FILE = "fellowStatLog.txt";
  private static final String TAG = FellowStatItem.class.getSimpleName();
  private static FellowStatItem mInstance = null;
  private long mVoiceDataDownloadEndTime;
  private long mVoiceDataDownloadStartTime;
  private long mVoiceDataRecordId;
  private long mVoiceDataUploadEndTime;
  private long mVoiceDataUploadStartTime;
  private long mVoiceDescDownloadEndTime;
  private long mVoiceDescDownloadStartTime;
  private long mVoiceDescUploadEndTime;
  private long mVoiceDescUploadStartTime;
  private long mVoicePullEndTime;
  private long mVoicePullStartTime;
  
  private File getFellowStatLogFile()
  {
    File localFile = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + "fellowStatLog.txt");
    if (localFile.exists()) {
      return localFile;
    }
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localFile;
  }
  
  public static FellowStatItem getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new FellowStatItem();
      }
      FellowStatItem localFellowStatItem = mInstance;
      return localFellowStatItem;
    }
    finally {}
  }
  
  public long getmVoiceDataDownloadEndTime()
  {
    return this.mVoiceDataDownloadEndTime;
  }
  
  public long getmVoiceDataDownloadStartTime()
  {
    return this.mVoiceDataDownloadStartTime;
  }
  
  public long getmVoiceDataRecordId()
  {
    return this.mVoiceDataRecordId;
  }
  
  public long getmVoiceDataUploadEndTime()
  {
    return this.mVoiceDataUploadEndTime;
  }
  
  public long getmVoiceDataUploadStartTime()
  {
    return this.mVoiceDataUploadStartTime;
  }
  
  public long getmVoiceDescDownloadEndTime()
  {
    return this.mVoiceDescDownloadEndTime;
  }
  
  public long getmVoiceDescDownloadStartTime()
  {
    return this.mVoiceDescDownloadStartTime;
  }
  
  public long getmVoiceDescUploadEndTime()
  {
    return this.mVoiceDescUploadEndTime;
  }
  
  public long getmVoiceDescUploadStartTime()
  {
    return this.mVoiceDescUploadStartTime;
  }
  
  public long getmVoicePullEndTime()
  {
    return this.mVoicePullEndTime;
  }
  
  public long getmVoicePullStartTime()
  {
    return this.mVoicePullStartTime;
  }
  
  public void setmVoiceDataDownloadEndTime(long paramLong)
  {
    this.mVoiceDataDownloadEndTime = paramLong;
    writeStringToFile("语音id:" + String.valueOf(getmVoiceDataRecordId()) + ",数据下载时间：" + String.valueOf(this.mVoiceDataDownloadEndTime - getmVoiceDataDownloadStartTime()) + "ms");
  }
  
  public void setmVoiceDataDownloadStartTime(long paramLong)
  {
    this.mVoiceDataDownloadStartTime = paramLong;
  }
  
  public void setmVoiceDataRecordId(long paramLong)
  {
    this.mVoiceDataRecordId = paramLong;
  }
  
  public void setmVoiceDataUploadEndTime(long paramLong)
  {
    this.mVoiceDataUploadEndTime = paramLong;
    writeStringToFile("语音id:" + String.valueOf(getmVoiceDataRecordId()) + ",数据上传时间：" + String.valueOf(this.mVoiceDataUploadEndTime - getmVoiceDataUploadStartTime()) + "ms");
  }
  
  public void setmVoiceDataUploadStartTime(long paramLong)
  {
    this.mVoiceDataUploadStartTime = paramLong;
  }
  
  public void setmVoiceDescDownloadEndTime(long paramLong)
  {
    this.mVoiceDescDownloadEndTime = paramLong;
  }
  
  public void setmVoiceDescDownloadStartTime(long paramLong)
  {
    this.mVoiceDescDownloadStartTime = paramLong;
  }
  
  public void setmVoiceDescUploadEndTime(long paramLong)
  {
    this.mVoiceDescUploadEndTime = paramLong;
    writeStringToFile("语音id:" + String.valueOf(getmVoiceDataRecordId()) + ",描述上传时间：" + String.valueOf(this.mVoiceDescUploadEndTime - getmVoiceDescUploadStartTime()) + "ms");
  }
  
  public void setmVoiceDescUploadStartTime(long paramLong)
  {
    this.mVoiceDescUploadStartTime = paramLong;
  }
  
  public void setmVoicePullEndTime(long paramLong)
  {
    this.mVoicePullEndTime = paramLong;
    writeStringToFile("消息拉取时间：" + String.valueOf(this.mVoicePullEndTime - getmVoicePullStartTime()) + "ms");
  }
  
  public void setmVoicePullStartTime(long paramLong)
  {
    this.mVoicePullStartTime = paramLong;
  }
  
  /* Error */
  public void writeStringToFile(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: ldc -85
    //   6: aload_1
    //   7: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: getstatic 43	com/baidu/navisdk/util/statistic/FellowStatItem:FELLOW_DEBUG	Z
    //   17: ifeq -4 -> 13
    //   20: aconst_null
    //   21: astore_2
    //   22: aconst_null
    //   23: astore 4
    //   25: aload_0
    //   26: invokespecial 177	com/baidu/navisdk/util/statistic/FellowStatItem:getFellowStatLogFile	()Ljava/io/File;
    //   29: astore_3
    //   30: new 179	java/io/FileOutputStream
    //   33: dup
    //   34: aload_3
    //   35: iconst_1
    //   36: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   39: astore_3
    //   40: ldc -72
    //   42: invokestatic 190	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: aload_3
    //   47: aload_1
    //   48: ldc -64
    //   50: invokevirtual 196	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   53: invokevirtual 200	java/io/FileOutputStream:write	([B)V
    //   56: aload_3
    //   57: aload_2
    //   58: invokevirtual 203	java/lang/String:getBytes	()[B
    //   61: invokevirtual 200	java/io/FileOutputStream:write	([B)V
    //   64: aload_3
    //   65: invokevirtual 206	java/io/FileOutputStream:flush	()V
    //   68: getstatic 35	com/baidu/navisdk/util/statistic/FellowStatItem:TAG	Ljava/lang/String;
    //   71: ldc -49
    //   73: invokestatic 213	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_3
    //   77: ifnull +100 -> 177
    //   80: aload_3
    //   81: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   84: return
    //   85: astore_1
    //   86: getstatic 35	com/baidu/navisdk/util/statistic/FellowStatItem:TAG	Ljava/lang/String;
    //   89: aload_1
    //   90: invokevirtual 219	java/io/IOException:getMessage	()Ljava/lang/String;
    //   93: invokestatic 213	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: goto -12 -> 84
    //   99: astore_3
    //   100: aload 4
    //   102: astore_1
    //   103: aload_1
    //   104: astore_2
    //   105: getstatic 35	com/baidu/navisdk/util/statistic/FellowStatItem:TAG	Ljava/lang/String;
    //   108: aload_3
    //   109: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokestatic 213	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_1
    //   116: ifnull -103 -> 13
    //   119: aload_1
    //   120: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   123: return
    //   124: astore_1
    //   125: getstatic 35	com/baidu/navisdk/util/statistic/FellowStatItem:TAG	Ljava/lang/String;
    //   128: aload_1
    //   129: invokevirtual 219	java/io/IOException:getMessage	()Ljava/lang/String;
    //   132: invokestatic 213	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -12 -> 123
    //   138: astore_1
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   147: aload_1
    //   148: athrow
    //   149: astore_2
    //   150: getstatic 35	com/baidu/navisdk/util/statistic/FellowStatItem:TAG	Ljava/lang/String;
    //   153: aload_2
    //   154: invokevirtual 219	java/io/IOException:getMessage	()Ljava/lang/String;
    //   157: invokestatic 213	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -13 -> 147
    //   163: astore_1
    //   164: aload_3
    //   165: astore_2
    //   166: goto -27 -> 139
    //   169: astore_2
    //   170: aload_3
    //   171: astore_1
    //   172: aload_2
    //   173: astore_3
    //   174: goto -71 -> 103
    //   177: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	FellowStatItem
    //   0	178	1	paramString	String
    //   21	123	2	str	String
    //   149	5	2	localIOException	IOException
    //   165	1	2	localObject1	Object
    //   169	4	2	localException1	Exception
    //   29	52	3	localObject2	Object
    //   99	72	3	localException2	Exception
    //   173	1	3	localException3	Exception
    //   23	78	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   80	84	85	java/io/IOException
    //   30	40	99	java/lang/Exception
    //   119	123	124	java/io/IOException
    //   30	40	138	finally
    //   105	115	138	finally
    //   143	147	149	java/io/IOException
    //   40	76	163	finally
    //   40	76	169	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/FellowStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */