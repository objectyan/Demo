package com.baidu.navisdk.debug;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.HttpsClient;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
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

public class SDKDebugFileUtil {
    private static final String CoreLog_Key_Info = "CoreLog_Key_Info";
    private static final String CoreLog_Key_Module = "CoreLog_Key_Module";
    public static final String END_GUIDE_FILENAME = "end_guide";
    public static final String KEY_LOG_OFFLINE = "http://cp01-rdqa-dev137.cp01.baidu.com:8080/hunter/log/collect";
    public static final String KEY_LOG_ONLINE = (HttpURLManager.getInstance().getScheme() + "navimon.baidu.com/hunter/log/collect");
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
    private long TIME_INTERVAL = HttpsClient.CONN_MGR_TIMEOUT;
    private boolean mAddFileNameTime = true;
    private BufferedWriter mBW = null;
    private Callback mChildThreadCallback = new C40851();
    private BufferedWriter mCoreLogBW = null;
    private BufferedWriter mCoreLogBWForAllLog = null;
    private File mCoreLogDir = null;
    private SimpleDateFormat mCoreLogSDF = null;
    private File mFile = null;
    private String mFileName = null;
    private String mFilePath = null;
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == 8) {
                Bundle bd = msg.obj;
                boolean isSilence = bd.getBoolean("isSilence");
                int module = bd.getInt("module");
                if (module == 4) {
                    File CoreLogFile = new File(SDKDebugFileUtil.this.getCoreLogDir() + File.separator + "naviAllLog");
                    if (CoreLogFile != null && CoreLogFile.exists()) {
                        SDKDebugFileUtil.this.asynUploadLogFile(CoreLogFile.getAbsolutePath(), module, isSilence);
                        return;
                    }
                    return;
                }
                File cfile = SDKDebugFileUtil.this.hasKeyLogFile();
                if (cfile != null && cfile.exists()) {
                    SDKDebugFileUtil.this.asynUploadLogFile(cfile.getAbsolutePath(), module, isSilence);
                }
            }
        }
    };
    private boolean mHasTime = true;
    private SimpleDateFormat mSDF = null;
    private long noNormalLastTimeGPS1 = 0;
    private long noNormalLastTimeGPS2 = 0;
    private long normalLastTimeGPS1 = 0;
    private long normalLastTimeGPS2 = 0;

    /* renamed from: com.baidu.navisdk.debug.SDKDebugFileUtil$1 */
    class C40851 extends Callback {
        C40851() {
        }

        public void execute(Message message) {
            switch (message.what) {
                case 300:
                    Bundle bundle = (Bundle) message.obj;
                    SDKDebugFileUtil.this.doAddCoreLog(bundle.getString(SDKDebugFileUtil.CoreLog_Key_Module), bundle.getString(SDKDebugFileUtil.CoreLog_Key_Info));
                    return;
                case 301:
                    SDKDebugFileUtil.this.writeAndUploadSystemLog();
                    return;
                default:
                    return;
            }
        }

        public void careAbouts() {
            careAbout(300);
            careAbout(301);
        }
    }

    public class CoreLogModule {
        public static final String CoreLog_ALL = "CoreLog_ALL: ";
        public static final String CoreLog_Common = "CoreLog_Common: ";
        public static final String CoreLog_GPS = "CoreLog_GPS: ";
        public static final String CoreLog_TTS = "CoreLog_TTS: ";
    }

    public class CoreLogModule_GPS_TYPE {
        public static final int CoreLogModule_GPS_MSG_NAVI_Star_State = 1;
        public static final int CoreLogModule_GPS_onWGS = 0;
    }

    public class CoreLogModule_Int {
        public static final int CoreLog_ALL = 4;
        public static final int CoreLog_Common = 1;
        public static final int CoreLog_GPS = 2;
        public static final int CoreLog_TTS = 3;
    }

    public class CoreLogModule_TTS_TYPE {
        public static final int CoreLogModule_TTS_SPEAK = 1;
        public static final int CoreLogModule_TTS_STATE = 0;
    }

    public static SDKDebugFileUtil getInstance() {
        if (sInstance == null) {
            synchronized (SDKDebugUtil.class) {
                if (sInstance == null) {
                    sInstance = new SDKDebugFileUtil();
                }
            }
        }
        return sInstance;
    }

    private SDKDebugFileUtil() {
        CommonHandlerThread.getInstance().registerCallback(this.mChildThreadCallback);
    }

    public void addCoreLog(String module, String info) {
        if (CloudlConfigDataModel.getInstance().mCommonConfig.coreLogRecord) {
            Bundle bundle = new Bundle();
            bundle.putString(CoreLog_Key_Module, module);
            bundle.putString(CoreLog_Key_Info, info);
            CommonHandlerThread.getInstance().sendMessage(300, 0, 0, bundle, 0);
        }
    }

    public String getCoreLogDir() {
        try {
            if (!(this.mCoreLogDir != null && this.mCoreLogDir.exists() && this.mCoreLogDir.isDirectory())) {
                this.mCoreLogDir = new File(SysOSAPI.getInstance().GetModuleFileName() + File.separator + "NaviCoreLog");
                if (!(this.mCoreLogDir == null || this.mCoreLogDir.exists())) {
                    this.mCoreLogDir.mkdirs();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mCoreLogDir != null) {
            return this.mCoreLogDir.getAbsolutePath();
        }
        return null;
    }

    public void uploadSystemLog() {
        if (!sIsWritingSystemLog) {
            sIsWritingSystemLog = true;
            CommonHandlerThread.getInstance().sendMessage(301, 0, 0, null, 0);
        }
    }

    private void writeAndUploadSystemLog() {
        LogUtil.m15791e("SDKDebugFileUtil", "writeAndUploadSystemLog: --> start");
        try {
            File logFile;
            File file = new File(getCoreLogDir() + File.separator + "naviCoreLog_system_" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
            if (!(file == null || file.exists())) {
                try {
                    ensureFileNum();
                    if (!file.createNewFile()) {
                        logFile = null;
                    }
                } catch (Exception e) {
                    logFile = null;
                }
            }
            if (logFile != null) {
                if (logFile.exists()) {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logFile));
                    if (bufferedWriter != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -v time").getInputStream()));
                        int count = 0;
                        do {
                            String buf = bufferedReader.readLine();
                            if (buf == null) {
                                break;
                            }
                            bufferedWriter.append(buf + "\n");
                            count += buf.length();
                        } while (count <= 1048576);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        bufferedReader.close();
                    }
                }
            }
            uploadLogFile(1, false, false, 0);
            sIsWritingSystemLog = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void doAddCoreLog(String module, String str) {
        if (getCoreLogDir() != null) {
            File CoreLogFile;
            if (CoreLogModule.CoreLog_ALL.equals(module)) {
                CoreLogFile = new File(getCoreLogDir() + File.separator + "naviAllLog");
            } else {
                CoreLogFile = new File(getCoreLogDir() + File.separator + "naviCoreLog_" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
            }
            boolean hasCreateFile = false;
            if (!(CoreLogFile == null || CoreLogFile.exists())) {
                try {
                    ensureFileNum();
                    if (!CoreLogFile.createNewFile()) {
                        CoreLogFile = null;
                    }
                    hasCreateFile = true;
                } catch (Exception e) {
                    CoreLogFile = null;
                }
            }
            if (CoreLogFile != null && CoreLogFile.exists()) {
                if (this.mCoreLogSDF == null) {
                    this.mCoreLogSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                }
                if (CoreLogModule.CoreLog_ALL.equals(module)) {
                    if (this.mCoreLogBWForAllLog == null) {
                        try {
                            this.mCoreLogBWForAllLog = new BufferedWriter(new FileWriter(CoreLogFile));
                        } catch (IOException e2) {
                            this.mCoreLogBWForAllLog = null;
                        }
                    }
                    if (this.mCoreLogSDF != null && this.mCoreLogBWForAllLog != null) {
                        try {
                            this.mCoreLogBWForAllLog.append(this.mCoreLogSDF.format(new Date()) + " ### " + module + str + "\n");
                            this.mCoreLogBWForAllLog.flush();
                            return;
                        } catch (IOException e3) {
                            return;
                        }
                    }
                    return;
                }
                if (this.mCoreLogBW == null || hasCreateFile) {
                    try {
                        this.mCoreLogBW = new BufferedWriter(new FileWriter(CoreLogFile));
                    } catch (IOException e4) {
                        this.mCoreLogBW = null;
                    }
                }
                if (this.mCoreLogSDF != null && this.mCoreLogBW != null) {
                    try {
                        this.mCoreLogBW.append(this.mCoreLogSDF.format(new Date()) + " ### " + module + str + "\n");
                        this.mCoreLogBW.flush();
                    } catch (IOException e5) {
                    }
                }
            }
        }
    }

    public boolean isShowCoreLog(int module, int arg1, int arg2, String info, Object obj) {
        if (!CloudlConfigDataModel.getInstance().mCommonConfig.coreLogRecord) {
            return false;
        }
        switch (module) {
            case 1:
                return false;
            case 2:
                switch (arg1) {
                    case 0:
                        if (arg2 >= 3) {
                            if (System.currentTimeMillis() - this.normalLastTimeGPS1 <= this.TIME_INTERVAL) {
                                return false;
                            }
                            this.normalLastTimeGPS1 = System.currentTimeMillis();
                            this.noNormalLastTimeGPS1 = 0;
                            return true;
                        } else if (System.currentTimeMillis() - this.noNormalLastTimeGPS1 <= this.TIME_INTERVAL) {
                            return false;
                        } else {
                            this.noNormalLastTimeGPS1 = System.currentTimeMillis();
                            this.normalLastTimeGPS1 = 0;
                            return true;
                        }
                    case 1:
                        if (arg2 >= 3) {
                            if (System.currentTimeMillis() - this.normalLastTimeGPS2 <= this.TIME_INTERVAL) {
                                return false;
                            }
                            this.normalLastTimeGPS2 = System.currentTimeMillis();
                            this.noNormalLastTimeGPS2 = 0;
                            return true;
                        } else if (System.currentTimeMillis() - this.noNormalLastTimeGPS2 <= this.TIME_INTERVAL) {
                            return false;
                        } else {
                            this.noNormalLastTimeGPS2 = System.currentTimeMillis();
                            this.normalLastTimeGPS2 = 0;
                            return true;
                        }
                    default:
                        return false;
                }
            case 3:
                switch (arg1) {
                    case 0:
                        if (arg2 != 1) {
                            return true;
                        }
                        return false;
                    case 1:
                        return false;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private SDKDebugFileUtil(String filePath, String fileName, boolean addFileNameTime, boolean hasTime) {
        this.mFilePath = filePath;
        this.mFileName = fileName;
        this.mAddFileNameTime = addFileNameTime;
        this.mHasTime = hasTime;
        if (this.mFilePath == null) {
            this.mFilePath = SysOSAPI.getInstance().GetSDCardPath() + File.separator + "log";
        }
        if (this.mFilePath == null || this.mFileName == null) {
            this.mFile = null;
        } else {
            this.mSDF = new SimpleDateFormat("yyyyMMdd_HH");
            this.mFile = new File(this.mFilePath + File.separator + this.mFileName + (this.mAddFileNameTime ? JNISearchConst.LAYER_ID_DIVIDER + this.mSDF.format(new Date()) : "") + ".txt");
            if (!this.mFile.exists()) {
                try {
                    if (!this.mFile.createNewFile()) {
                        this.mFile = null;
                    }
                } catch (IOException e) {
                    this.mFile = null;
                }
            }
        }
        if (this.mFile != null) {
            this.mSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                this.mBW = new BufferedWriter(new FileWriter(this.mFile));
                sFiles.put(fileName, this);
            } catch (IOException e2) {
                this.mSDF = null;
                this.mFile = null;
                this.mBW = null;
            }
        }
    }

    public static SDKDebugFileUtil get(String fileName) {
        return get(null, fileName, true, true);
    }

    public static SDKDebugFileUtil get(String fileName, boolean addFileNameTime, boolean hasTime) {
        return get(null, fileName, addFileNameTime, hasTime);
    }

    public static SDKDebugFileUtil get(String filePath, String fileName, boolean hasTime) {
        return get(filePath, fileName, true, hasTime);
    }

    public static SDKDebugFileUtil get(String filePath, String fileName, boolean addFileNameTime, boolean hasTime) {
        if (sFiles.containsKey(fileName)) {
            return (SDKDebugFileUtil) sFiles.get(fileName);
        }
        return new SDKDebugFileUtil(filePath, fileName, addFileNameTime, hasTime);
    }

    public void add(String info) {
        if (this.mBW != null && LogUtil.LOGGABLE) {
            try {
                BufferedWriter bufferedWriter = this.mBW;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.mHasTime) {
                    info = this.mSDF.format(new Date()) + " ### " + info;
                }
                bufferedWriter.append(stringBuilder.append(info).append("\n").toString());
                this.mBW.flush();
            } catch (IOException e) {
            }
        }
    }

    public void forceAdd(String info) {
        if (this.mBW != null) {
            try {
                BufferedWriter bufferedWriter = this.mBW;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.mHasTime) {
                    info = this.mSDF.format(new Date()) + " ### " + info;
                }
                bufferedWriter.append(stringBuilder.append(info).append("\n").toString());
                this.mBW.flush();
            } catch (IOException e) {
            }
        }
    }

    public static void end(String fileName) {
        if (sFiles.containsKey(fileName)) {
            SDKDebugFileUtil dFile = (SDKDebugFileUtil) sFiles.get(fileName);
            if (dFile != null && dFile.mBW != null) {
                try {
                    dFile.mBW.flush();
                    dFile.mBW.close();
                } catch (IOException e) {
                } finally {
                    sFiles.remove(fileName);
                }
            }
        }
    }

    private void ensureFileNum() {
        try {
            File[] files = new File(getCoreLogDir()).listFiles();
            if (files != null && files.length > 3) {
                for (int k = 0; k < files.length - 3; k++) {
                    File oldFile = findOldestFile(getCoreLogDir());
                    if (oldFile != null) {
                        oldFile.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File findOldestFile(String corrDir) {
        File[] files = new File(corrDir).listFiles();
        if (files == null) {
            return null;
        }
        File oldestfile = null;
        try {
            SimpleDateFormat coreLogSDF = new SimpleDateFormat("yyyyMMdd");
            int i = 0;
            Date lastDate = coreLogSDF.parse("99999999");
            for (File file : files) {
                if (file.getName().contains("naviCoreLog")) {
                    Date date = coreLogSDF.parse(file.getName().substring("naviCoreLog_".length()));
                    if (date.compareTo(lastDate) < 0) {
                        lastDate = date;
                        oldestfile = file;
                    }
                    i++;
                }
            }
            return oldestfile;
        } catch (Exception e) {
            return null;
        }
    }

    public void uploadLogFile(int module, boolean isSilence, boolean onlyWifi, long delaytime) {
        if (!CloudlConfigDataModel.getInstance().mCommonConfig.coreLogRecord) {
            return;
        }
        if ((!onlyWifi || NetworkUtils.isTypeNetworkAvailable(BNaviModuleManager.getContext(), 1)) && getCoreLogDir() != null && this.mHandler != null) {
            Message msg = new Message();
            Bundle bd = new Bundle();
            bd.putBoolean("isSilence", isSilence);
            bd.putInt("module", module);
            msg.what = 8;
            msg.obj = bd;
            this.mHandler.sendMessageDelayed(msg, delaytime);
        }
    }

    private void asynUploadLogFile(final String dataPath, final int module, final boolean isSilence) {
        LogUtil.m15791e("SDKDebugFileUtil", "asynUploadLogFile dataPath= " + dataPath);
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = true;
        httpParams.fileKey = "datafile";
        httpParams.file = new File(dataPath);
        HashMap<String, String> normapParams = new HashMap();
        String sid = "4";
        normapParams.put("os", "0");
        normapParams.put("sv", PackageUtil.getVersionName());
        normapParams.put("sid", sid);
        normapParams.put("cuid", PackageUtil.getCuid());
        normapParams.put("type", module == 4 ? "81" : "80");
        normapParams.put("extInfo", dataPath);
        normapParams.put("sign", MD5.toMD5("bdnavi|sv:" + PackageUtil.getVersionName() + "|sid:" + sid + "|os:0|cuid:" + PackageUtil.getCuid()));
        BNHttpCenter.getInstance().post(KEY_LOG_ONLINE, normapParams, new BNHttpTextResponseHandler() {
            public void onSuccess(int statusCode, String responseString) {
                try {
                    File file = new File(dataPath);
                    if (file == null || !file.exists() || !file.delete()) {
                        return;
                    }
                    if (module != 4) {
                        File cfile = SDKDebugFileUtil.this.hasKeyLogFile();
                        if (cfile != null && cfile.exists()) {
                            SDKDebugFileUtil.this.asynUploadLogFile(cfile.getAbsolutePath(), module, isSilence);
                        } else if (!isSilence) {
                            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上传日志成功");
                        }
                    } else if (!isSilence) {
                        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上传日志成功");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(int statusCode, String responseString, Throwable throwable) {
                if (!isSilence) {
                    TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上传日志失败");
                }
            }
        }, httpParams);
    }

    private File hasKeyLogFile() {
        if (getCoreLogDir() == null) {
            return null;
        }
        File[] files = new File(getCoreLogDir()).listFiles();
        if (files == null || files.length <= 0) {
            return null;
        }
        for (File file : files) {
            if (file.getName().contains("naviCoreLog")) {
                return file;
            }
        }
        return null;
    }
}
