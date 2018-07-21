package com.baidu.navisdk.util.statistic.datacheck;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataCheckLogCenter
{
  public static final String CHECKDATA_FOLDER = "/log/dc";
  private static DataCheckLogCenter sInstance = null;
  private static Object sSyncObj = new Object();
  private boolean mIsInitOK = false;
  private FileWriter mLogFileWriter = null;
  
  private DataCheckLogCenter()
  {
    if (LogUtil.LOGGABLE) {
      init();
    }
  }
  
  public static DataCheckLogCenter getInstance()
  {
    if (sInstance == null) {}
    synchronized (sSyncObj)
    {
      if (sInstance == null) {
        sInstance = new DataCheckLogCenter();
      }
      return sInstance;
    }
  }
  
  private void init()
  {
    initDirs();
    initLogFile();
  }
  
  private static void initDirs()
  {
    File localFile = new File(SysOSAPI.getInstance().GetSDCardPath() + "/log/dc");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void initLogFile()
  {
    if (!new File(SysOSAPI.getInstance().GetSDCardPath() + "/log/dc").exists())
    {
      this.mIsInitOK = false;
      return;
    }
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    str = SysOSAPI.getInstance().GetSDCardPath() + "/log/dc" + "/dc" + str + ".log";
    try
    {
      this.mLogFileWriter = new FileWriter(str, true);
      this.mIsInitOK = true;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        DataCheckCenter.log("failed to init log file writer.");
        this.mIsInitOK = false;
      }
    }
  }
  
  public void appendLog(String paramString)
  {
    if ((this.mIsInitOK) && (this.mLogFileWriter != null)) {}
    try
    {
      this.mLogFileWriter.append(paramString);
      this.mLogFileWriter.flush();
      return;
    }
    catch (IOException paramString)
    {
      DataCheckCenter.log("failed to append log to file.");
    }
  }
  
  public String getCurTimeString()
  {
    return new SimpleDateFormat("[yyyy-MM-dd_HH:mm:ss]").format(new Date());
  }
  
  public void uninit()
  {
    if (this.mLogFileWriter != null) {}
    try
    {
      this.mLogFileWriter.flush();
      this.mLogFileWriter.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/datacheck/DataCheckLogCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */