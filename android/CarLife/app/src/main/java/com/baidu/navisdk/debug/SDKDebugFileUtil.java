package com.baidu.navisdk.debug;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SDKDebugFileUtil
{
  private static final String CoreLog_Key_Info = "CoreLog_Key_Info";
  private static final String CoreLog_Key_Module = "CoreLog_Key_Module";
  public static final String END_GUIDE_FILENAME = "end_guide";
  public static final String KEY_LOG_OFFLINE = "http://cp01-rdqa-dev137.cp01.baidu.com:8080/hunter/log/collect";
  public static final String KEY_LOG_ONLINE = HttpURLManager.getInstance().getScheme() + "navimon.baidu.com/hunter/log/collect";
  public static final String NAVING_SYSLOC_FILENAME = "naving_sysloc_debug";
  public static final String NORMAL_ALL_LOG = "normal_all_log";
  public static final String PERFORMANCE_LOG_FILENAME = "navi_perf_log";
  public static final String RoutePlan_FILENAME = "RoutePlan_debug";
  public static final String SYSLOC_FILENAME = "sysloc_debug";
  public static final String TTS_FILENAME = "TTS_debug";
  public static final int UPLOAD_FILE_MSG = 8;
  public static final String USEROP_FILENAME = "userop_debug";
  public static final String USER_ALL_LOG = "USER_ALL_LOG";
  public static final String VECTOR_ENLARGE_FILENAME = "vector_enlarge_debug";
  private static Map<String, SDKDebugFileUtil> sFiles = new HashMap();
  private static SDKDebugFileUtil sInstance = null;
  public static boolean sIsWritingSystemLog = false;
  private long TIME_INTERVAL = 30000L;
  private boolean mAddFileNameTime = true;
  private BufferedWriter mBW = null;
  private CommonHandlerThread.Callback mChildThreadCallback = new CommonHandlerThread.Callback()
  {
    public void careAbouts()
    {
      careAbout(300);
      careAbout(301);
    }
    
    public void execute(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 300: 
        paramAnonymousMessage = (Bundle)paramAnonymousMessage.obj;
        SDKDebugFileUtil.this.doAddCoreLog(paramAnonymousMessage.getString("CoreLog_Key_Module"), paramAnonymousMessage.getString("CoreLog_Key_Info"));
        return;
      }
      SDKDebugFileUtil.this.writeAndUploadSystemLog();
    }
  };
  private BufferedWriter mCoreLogBW = null;
  private BufferedWriter mCoreLogBWForAllLog = null;
  private File mCoreLogDir = null;
  private SimpleDateFormat mCoreLogSDF = null;
  private File mFile = null;
  private String mFileName = null;
  private String mFilePath = null;
  public Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool;
      int i;
      if (paramAnonymousMessage.what == 8)
      {
        paramAnonymousMessage = (Bundle)paramAnonymousMessage.obj;
        bool = paramAnonymousMessage.getBoolean("isSilence");
        i = paramAnonymousMessage.getInt("module");
        if (i != 4) {
          break label100;
        }
        paramAnonymousMessage = new File(SDKDebugFileUtil.this.getCoreLogDir() + File.separator + "naviAllLog");
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.exists())) {
          SDKDebugFileUtil.this.asynUploadLogFile(paramAnonymousMessage.getAbsolutePath(), i, bool);
        }
      }
      label100:
      do
      {
        return;
        paramAnonymousMessage = SDKDebugFileUtil.this.hasKeyLogFile();
      } while ((paramAnonymousMessage == null) || (!paramAnonymousMessage.exists()));
      SDKDebugFileUtil.this.asynUploadLogFile(paramAnonymousMessage.getAbsolutePath(), i, bool);
    }
  };
  private boolean mHasTime = true;
  private SimpleDateFormat mSDF = null;
  private long noNormalLastTimeGPS1 = 0L;
  private long noNormalLastTimeGPS2 = 0L;
  private long normalLastTimeGPS1 = 0L;
  private long normalLastTimeGPS2 = 0L;
  
  private SDKDebugFileUtil()
  {
    CommonHandlerThread.getInstance().registerCallback(this.mChildThreadCallback);
  }
  
  private SDKDebugFileUtil(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mFilePath = paramString1;
    this.mFileName = paramString2;
    this.mAddFileNameTime = paramBoolean1;
    this.mHasTime = paramBoolean2;
    if (this.mFilePath == null) {
      this.mFilePath = (SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log");
    }
    if ((this.mFilePath != null) && (this.mFileName != null))
    {
      this.mSDF = new SimpleDateFormat("yyyyMMdd_HH");
      paramString1 = this.mSDF.format(new Date());
      StringBuilder localStringBuilder = new StringBuilder().append(this.mFilePath).append(File.separator).append(this.mFileName);
      if (this.mAddFileNameTime)
      {
        paramString1 = "_" + paramString1;
        this.mFile = new File(paramString1 + ".txt");
        if (this.mFile.exists()) {}
      }
    }
    for (;;)
    {
      try
      {
        if (!this.mFile.createNewFile()) {
          this.mFile = null;
        }
        if (this.mFile != null) {
          this.mSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try
        {
          this.mBW = new BufferedWriter(new FileWriter(this.mFile));
          sFiles.put(paramString2, this);
          return;
        }
        catch (IOException paramString1)
        {
          this.mSDF = null;
          this.mFile = null;
          this.mBW = null;
        }
        paramString1 = "";
      }
      catch (IOException paramString1)
      {
        this.mFile = null;
        continue;
      }
      this.mFile = null;
    }
  }
  
  private void asynUploadLogFile(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    LogUtil.e("SDKDebugFileUtil", "asynUploadLogFile dataPath= " + paramString);
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = true;
    localBNHttpParams.fileKey = "datafile";
    localBNHttpParams.file = new File(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("os", "0");
    localHashMap.put("sv", PackageUtil.getVersionName());
    localHashMap.put("sid", "4");
    localHashMap.put("cuid", PackageUtil.getCuid());
    if (paramInt == 4) {}
    for (String str = "81";; str = "80")
    {
      localHashMap.put("type", str);
      localHashMap.put("extInfo", paramString);
      localHashMap.put("sign", MD5.toMD5("bdnavi|sv:" + PackageUtil.getVersionName() + "|sid:" + "4" + "|os:0|cuid:" + PackageUtil.getCuid()));
      BNHttpCenter.getInstance().post(KEY_LOG_ONLINE, localHashMap, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          if (!paramBoolean) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上传日志失败");
          }
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          try
          {
            paramAnonymousString = new File(paramString);
            if ((paramAnonymousString == null) || (!paramAnonymousString.exists()) || (!paramAnonymousString.delete())) {
              return;
            }
            if (paramInt == 4)
            {
              if (paramBoolean) {
                return;
              }
              TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上传日志成功");
              return;
            }
            paramAnonymousString = SDKDebugFileUtil.this.hasKeyLogFile();
            if ((paramAnonymousString != null) && (paramAnonymousString.exists()))
            {
              SDKDebugFileUtil.this.asynUploadLogFile(paramAnonymousString.getAbsolutePath(), paramInt, paramBoolean);
              return;
            }
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
            return;
          }
          if (!paramBoolean) {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上传日志成功");
          }
        }
      }, localBNHttpParams);
      return;
    }
  }
  
  private void doAddCoreLog(String paramString1, String paramString2)
  {
    Object localObject1;
    if (getCoreLogDir() != null)
    {
      if (!"CoreLog_ALL: ".equals(paramString1)) {
        break label257;
      }
      localObject1 = new File(getCoreLogDir() + File.separator + "naviAllLog");
    }
    for (;;)
    {
      int j = 0;
      Object localObject2 = localObject1;
      int i = j;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        i = j;
        if (((File)localObject1).exists()) {}
      }
      try
      {
        ensureFileNum();
        boolean bool = ((File)localObject1).createNewFile();
        if (!bool) {
          localObject1 = null;
        }
        i = 1;
        localObject2 = localObject1;
        if ((localObject2 != null) && (((File)localObject2).exists()))
        {
          if (this.mCoreLogSDF == null) {
            this.mCoreLogSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          }
          if (!"CoreLog_ALL: ".equals(paramString1)) {
            break label346;
          }
          if (this.mCoreLogBWForAllLog != null) {}
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            this.mCoreLogBWForAllLog = new BufferedWriter(new FileWriter((File)localObject2));
            if ((this.mCoreLogSDF != null) && (this.mCoreLogBWForAllLog != null)) {}
            label257:
            try
            {
              this.mCoreLogBWForAllLog.append(this.mCoreLogSDF.format(new Date()) + " ### " + paramString1 + paramString2 + "\n");
              this.mCoreLogBWForAllLog.flush();
              return;
            }
            catch (IOException paramString1) {}
            localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
            localObject1 = new File(getCoreLogDir() + File.separator + "naviCoreLog_" + (String)localObject1);
            break;
            localException = localException;
            localObject2 = null;
            i = j;
          }
          catch (IOException localIOException1)
          {
            this.mCoreLogBWForAllLog = null;
            continue;
          }
          label346:
          if ((this.mCoreLogBW == null) || (i != 0)) {}
          try
          {
            this.mCoreLogBW = new BufferedWriter(new FileWriter((File)localObject2));
            if ((this.mCoreLogSDF != null) && (this.mCoreLogBW != null)) {
              try
              {
                this.mCoreLogBW.append(this.mCoreLogSDF.format(new Date()) + " ### " + paramString1 + paramString2 + "\n");
                this.mCoreLogBW.flush();
                return;
              }
              catch (IOException paramString1) {}
            }
          }
          catch (IOException localIOException2)
          {
            for (;;)
            {
              this.mCoreLogBW = null;
            }
          }
        }
      }
    }
  }
  
  public static void end(String paramString)
  {
    if (!sFiles.containsKey(paramString)) {}
    SDKDebugFileUtil localSDKDebugFileUtil;
    do
    {
      return;
      localSDKDebugFileUtil = (SDKDebugFileUtil)sFiles.get(paramString);
    } while ((localSDKDebugFileUtil == null) || (localSDKDebugFileUtil.mBW == null));
    try
    {
      localSDKDebugFileUtil.mBW.flush();
      localSDKDebugFileUtil.mBW.close();
      sFiles.remove(paramString);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      sFiles.remove(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      sFiles.remove(paramString);
      throw ((Throwable)localObject);
    }
  }
  
  private void ensureFileNum()
  {
    try
    {
      File[] arrayOfFile = new File(getCoreLogDir()).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 3))
      {
        int i = 0;
        while (i < arrayOfFile.length - 3)
        {
          File localFile = findOldestFile(getCoreLogDir());
          if (localFile != null) {
            localFile.delete();
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private File findOldestFile(String paramString)
  {
    File[] arrayOfFile = new File(paramString).listFiles();
    if (arrayOfFile == null) {
      localObject2 = null;
    }
    for (;;)
    {
      return (File)localObject2;
      Object localObject3 = null;
      paramString = null;
      localObject2 = localObject3;
      try
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        int j = 0;
        localObject2 = localObject3;
        Object localObject1 = localSimpleDateFormat.parse("99999999");
        localObject2 = localObject3;
        int m = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          localObject2 = paramString;
          if (i >= m) {
            break;
          }
          File localFile = arrayOfFile[i];
          int k = j;
          Object localObject4 = localObject1;
          localObject3 = paramString;
          localObject2 = paramString;
          if (localFile.getName().contains("naviCoreLog"))
          {
            localObject2 = paramString;
            localObject3 = localSimpleDateFormat.parse(localFile.getName().substring("naviCoreLog_".length()));
            localObject2 = paramString;
            k = ((Date)localObject3).compareTo((Date)localObject1);
            if (k < 0)
            {
              localObject1 = localObject3;
              paramString = localFile;
            }
            k = j + 1;
            localObject3 = paramString;
            localObject4 = localObject1;
          }
          i += 1;
          j = k;
          localObject1 = localObject4;
          paramString = (String)localObject3;
        }
        return (File)localObject2;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static SDKDebugFileUtil get(String paramString)
  {
    return get(null, paramString, true, true);
  }
  
  public static SDKDebugFileUtil get(String paramString1, String paramString2, boolean paramBoolean)
  {
    return get(paramString1, paramString2, true, paramBoolean);
  }
  
  public static SDKDebugFileUtil get(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (sFiles.containsKey(paramString2)) {
      return (SDKDebugFileUtil)sFiles.get(paramString2);
    }
    return new SDKDebugFileUtil(paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static SDKDebugFileUtil get(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return get(null, paramString, paramBoolean1, paramBoolean2);
  }
  
  public static SDKDebugFileUtil getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new SDKDebugFileUtil();
      }
      return sInstance;
    }
    finally {}
  }
  
  private File hasKeyLogFile()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    File[] arrayOfFile;
    int j;
    int i;
    if (getCoreLogDir() != null)
    {
      arrayOfFile = new File(getCoreLogDir()).listFiles();
      localObject1 = localObject2;
      if (arrayOfFile != null)
      {
        localObject1 = localObject2;
        if (arrayOfFile.length > 0)
        {
          j = arrayOfFile.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfFile[i];
        if (!((File)localObject1).getName().contains("naviCoreLog")) {}
      }
      else
      {
        return (File)localObject1;
      }
      i += 1;
    }
  }
  
  private void writeAndUploadSystemLog()
  {
    LogUtil.e("SDKDebugFileUtil", "writeAndUploadSystemLog: --> start");
    try
    {
      Object localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
      Object localObject3 = new File(getCoreLogDir() + File.separator + "naviCoreLog_system_" + (String)localObject1);
      localObject1 = localObject3;
      boolean bool;
      if (localObject3 != null)
      {
        bool = ((File)localObject3).exists();
        localObject1 = localObject3;
        if (bool) {}
      }
      try
      {
        ensureFileNum();
        bool = ((File)localObject3).createNewFile();
        localObject1 = localObject3;
        if (!bool) {
          localObject1 = null;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int i;
          int j;
          Object localObject2 = null;
        }
      }
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = new BufferedWriter(new FileWriter((File)localObject1));
        if (localObject1 != null)
        {
          localObject3 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time").getInputStream()));
          i = 0;
          do
          {
            String str = ((BufferedReader)localObject3).readLine();
            if (str == null) {
              break;
            }
            ((BufferedWriter)localObject1).append(str + "\n");
            j = i + str.length();
            i = j;
          } while (j <= 1048576);
          ((BufferedWriter)localObject1).flush();
          ((BufferedWriter)localObject1).close();
          ((BufferedReader)localObject3).close();
        }
      }
      uploadLogFile(1, false, false, 0L);
      sIsWritingSystemLog = false;
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public void add(String paramString)
  {
    if ((this.mBW == null) || (!LogUtil.LOGGABLE)) {
      return;
    }
    try
    {
      BufferedWriter localBufferedWriter = this.mBW;
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString;
      if (this.mHasTime) {
        str = this.mSDF.format(new Date()) + " ### " + paramString;
      }
      localBufferedWriter.append(str + "\n");
      this.mBW.flush();
      return;
    }
    catch (IOException paramString) {}
  }
  
  public void addCoreLog(String paramString1, String paramString2)
  {
    if (CloudlConfigDataModel.getInstance().mCommonConfig.coreLogRecord)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("CoreLog_Key_Module", paramString1);
      localBundle.putString("CoreLog_Key_Info", paramString2);
      CommonHandlerThread.getInstance().sendMessage(300, 0, 0, localBundle, 0L);
    }
  }
  
  public void forceAdd(String paramString)
  {
    if (this.mBW == null) {
      return;
    }
    try
    {
      BufferedWriter localBufferedWriter = this.mBW;
      StringBuilder localStringBuilder = new StringBuilder();
      String str = paramString;
      if (this.mHasTime) {
        str = this.mSDF.format(new Date()) + " ### " + paramString;
      }
      localBufferedWriter.append(str + "\n");
      this.mBW.flush();
      return;
    }
    catch (IOException paramString) {}
  }
  
  public String getCoreLogDir()
  {
    for (;;)
    {
      try
      {
        if ((this.mCoreLogDir == null) || (!this.mCoreLogDir.exists())) {
          continue;
        }
        boolean bool = this.mCoreLogDir.isDirectory();
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (this.mCoreLogDir == null) {
        break;
      }
      return this.mCoreLogDir.getAbsolutePath();
      this.mCoreLogDir = new File(SysOSAPI.getInstance().GetModuleFileName() + File.separator + "NaviCoreLog");
      if ((this.mCoreLogDir != null) && (!this.mCoreLogDir.exists())) {
        this.mCoreLogDir.mkdirs();
      }
    }
    return null;
  }
  
  public boolean isShowCoreLog(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (!CloudlConfigDataModel.getInstance().mCommonConfig.coreLogRecord) {}
    label101:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              switch (paramInt1)
              {
              case 1: 
              default: 
                return false;
              case 2: 
                switch (paramInt2)
                {
                default: 
                  return false;
                case 0: 
                  if (paramInt3 < 3) {
                    break label101;
                  }
                }
                break;
              }
            } while (System.currentTimeMillis() - this.normalLastTimeGPS1 <= this.TIME_INTERVAL);
            this.normalLastTimeGPS1 = System.currentTimeMillis();
            this.noNormalLastTimeGPS1 = 0L;
            return true;
          } while (System.currentTimeMillis() - this.noNormalLastTimeGPS1 <= this.TIME_INTERVAL);
          this.noNormalLastTimeGPS1 = System.currentTimeMillis();
          this.normalLastTimeGPS1 = 0L;
          return true;
          if (paramInt3 < 3) {
            break;
          }
        } while (System.currentTimeMillis() - this.normalLastTimeGPS2 <= this.TIME_INTERVAL);
        this.normalLastTimeGPS2 = System.currentTimeMillis();
        this.noNormalLastTimeGPS2 = 0L;
        return true;
      } while (System.currentTimeMillis() - this.noNormalLastTimeGPS2 <= this.TIME_INTERVAL);
      this.noNormalLastTimeGPS2 = System.currentTimeMillis();
      this.normalLastTimeGPS2 = 0L;
      return true;
      switch (paramInt2)
      {
      case 1: 
      default: 
        return false;
      }
    } while (paramInt3 == 1);
    return true;
  }
  
  public void uploadLogFile(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (!CloudlConfigDataModel.getInstance().mCommonConfig.coreLogRecord) {}
    while (((paramBoolean2) && (!NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1))) || (getCoreLogDir() == null) || (this.mHandler == null)) {
      return;
    }
    Message localMessage = new Message();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSilence", paramBoolean1);
    localBundle.putInt("module", paramInt);
    localMessage.what = 8;
    localMessage.obj = localBundle;
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void uploadSystemLog()
  {
    if (!sIsWritingSystemLog)
    {
      sIsWritingSystemLog = true;
      CommonHandlerThread.getInstance().sendMessage(301, 0, 0, null, 0L);
    }
  }
  
  public class CoreLogModule
  {
    public static final String CoreLog_ALL = "CoreLog_ALL: ";
    public static final String CoreLog_Common = "CoreLog_Common: ";
    public static final String CoreLog_GPS = "CoreLog_GPS: ";
    public static final String CoreLog_TTS = "CoreLog_TTS: ";
    
    public CoreLogModule() {}
  }
  
  public class CoreLogModule_GPS_TYPE
  {
    public static final int CoreLogModule_GPS_MSG_NAVI_Star_State = 1;
    public static final int CoreLogModule_GPS_onWGS = 0;
    
    public CoreLogModule_GPS_TYPE() {}
  }
  
  public class CoreLogModule_Int
  {
    public static final int CoreLog_ALL = 4;
    public static final int CoreLog_Common = 1;
    public static final int CoreLog_GPS = 2;
    public static final int CoreLog_TTS = 3;
    
    public CoreLogModule_Int() {}
  }
  
  public class CoreLogModule_TTS_TYPE
  {
    public static final int CoreLogModule_TTS_SPEAK = 1;
    public static final int CoreLogModule_TTS_STATE = 0;
    
    public CoreLogModule_TTS_TYPE() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/debug/SDKDebugFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */