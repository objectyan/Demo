package com.baidu.navisdk.util.common;

import android.net.http.Headers;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.navirecover.NaviRecoveryManager;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.navi.protocol.model.GetPluginInfoDataStruct;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.speech.asr.SpeechConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeCrashUtils {
    private static final String BACKUP_DMP_FILENAME = "backupdmp.backupdmp";
    public static final String BP_FOLDER = "/log/bp";
    public static final boolean DEBUG = false;
    public static final int HEAD_INFO_LENGTH = 1024;
    public static final String TAG = "NativeCrashUtils";
    public static final String UPLOAD_LOG_NAVI_URL = (HttpURLManager.getInstance().getScheme() + "navimon.baidu.com/hunter/log/post");
    public static final String UPLOAD_LOG_URL = (HttpURLManager.getInstance().getScheme() + "client.map.baidu.com/imap/ulog/upc");
    public static final boolean UPLOAD_ONLY_WIFI = false;
    public static final String UPLOAD_PROTOCOL_URL = (HttpURLManager.getInstance().getScheme() + "client.map.baidu.com/imap/ulog/open");
    private static Handler mHandler = null;

    /* renamed from: com.baidu.navisdk.util.common.NativeCrashUtils$2 */
    static class C46262 extends Handler {
        C46262() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == NetworkListener.MSG_TYPE_NET_WORK_CHANGE && NativeCrashUtils.isNetworkStateOK(msg.arg1, msg.arg2)) {
                NetworkListener.unRegisterMessageHandler(NativeCrashUtils.mHandler);
                BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("NativeCrashUtils2", null) {
                    protected String execute() {
                        NativeCrashUtils.checkNativeCrash();
                        return null;
                    }
                }, new BNWorkerConfig(102, 0));
            }
        }
    }

    /* renamed from: com.baidu.navisdk.util.common.NativeCrashUtils$3 */
    static class C46273 implements FilenameFilter {
        C46273() {
        }

        public boolean accept(File arg0, String fname) {
            if (fname == null || !fname.toLowerCase().endsWith(NaviRecoveryManager.DUMP_FILE_SUFFIX)) {
                return false;
            }
            return true;
        }
    }

    public static class HttpPostUtil {
        String boundary = UUID.randomUUID().toString();
        HttpURLConnection conn;
        DataOutputStream ds;
        String fileKey = null;
        Map<String, byte[]> fileparams = new TreeMap();
        int resCode = -1;
        Map<String, String> textParams = new TreeMap();
        URL url;

        public HttpPostUtil(String url, String fk) throws Exception {
            this.url = new URL(url);
            this.fileKey = fk;
        }

        public void addTextParameter(String name, String value) {
            this.textParams.put(name, value);
        }

        public void addFileParameter(String name, byte[] value) {
            this.fileparams.put(name, value);
        }

        public void clearAllParameters() {
            this.textParams.clear();
            this.fileparams.clear();
        }

        public int getResCode() {
            return this.resCode;
        }

        public byte[] send() throws Exception {
            initConnection();
            try {
                this.conn.connect();
                this.ds = new DataOutputStream(this.conn.getOutputStream());
                writeFileParams();
                writeStringParams();
                paramsEnd();
                this.resCode = this.conn.getResponseCode();
                String resMsg = this.conn.getResponseMessage();
                NativeCrashUtils.loge("resCode=" + this.resCode);
                NativeCrashUtils.loge("resMsg=" + resMsg);
                InputStream in = this.conn.getInputStream();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                while (true) {
                    int b = in.read();
                    if (b != -1) {
                        out.write(b);
                    } else {
                        out.flush();
                        this.conn.disconnect();
                        in.close();
                        byte[] ret = out.toByteArray();
                        out.close();
                        return ret;
                    }
                }
            } catch (SocketTimeoutException e) {
                throw new RuntimeException();
            }
        }

        private void initConnection() throws Exception {
            this.conn = (HttpURLConnection) this.url.openConnection();
            this.conn.setDoOutput(true);
            this.conn.setDoInput(true);
            this.conn.setUseCaches(false);
            this.conn.setConnectTimeout(10000);
            this.conn.setRequestMethod("POST");
            this.conn.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
            this.conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.boundary);
        }

        private void writeStringParams() throws Exception {
            if (this.ds != null) {
                for (String name : this.textParams.keySet()) {
                    String value = (String) this.textParams.get(name);
                    this.ds.writeBytes("--" + this.boundary + "\r\n");
                    this.ds.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                    this.ds.writeBytes("\r\n");
                    this.ds.writeBytes(value + "\r\n");
                }
            }
        }

        private void writeFileParams() throws Exception {
            if (this.ds != null) {
                for (String name : this.fileparams.keySet()) {
                    byte[] value = (byte[]) this.fileparams.get(name);
                    if (!(value == null || value.length == 0)) {
                        this.ds.writeBytes("--" + this.boundary + "\r\n");
                        this.ds.writeBytes("Content-Disposition: form-data; name=\"" + this.fileKey + "\"; filename=\"" + name + "\"\r\n");
                        this.ds.writeBytes("Content-Type: " + getContentType(null) + "\r\n");
                        this.ds.writeBytes("\r\n");
                        this.ds.write(value);
                        this.ds.writeBytes("\r\n");
                    }
                }
            }
        }

        private String getContentType(File f) throws Exception {
            return "application/octet-stream";
        }

        private byte[] getBytes(File f) throws Exception {
            FileInputStream in = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            while (true) {
                int n = in.read(b);
                if (n != -1) {
                    out.write(b, 0, n);
                } else {
                    in.close();
                    byte[] ret = out.toByteArray();
                    out.close();
                    return ret;
                }
            }
        }

        private void paramsEnd() throws Exception {
            this.ds.writeBytes("--" + this.boundary + "--\r\n");
            this.ds.writeBytes("\r\n");
        }

        private String encode(String value) throws Exception {
            return URLEncoder.encode(value, "UTF-8");
        }
    }

    public static void startCheckNativeCrash() {
        initDirs();
        if (isNetworkStateOK(NetworkUtils.mConnectState, NetworkUtils.mWifiState)) {
            BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("NativeCrashUtils1", null) {
                protected String execute() {
                    NativeCrashUtils.checkNativeCrash();
                    return null;
                }
            }, new BNWorkerConfig(102, 0));
            return;
        }
        if (mHandler == null) {
            mHandler = new C46262();
        }
        NetworkListener.registerMessageHandler(mHandler);
    }

    private static boolean isNetworkStateOK(int connectState, int wifiState) {
        if (connectState == 1) {
            return true;
        }
        return false;
    }

    private static void checkNativeCrash() {
        ByteArrayOutputStream bos;
        GZIPOutputStream zos;
        FileInputStream fis;
        FileOutputStream backupDmpFos;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        loge("NativeCrashUtils.checkNativeCrash()");
        String crashDir = getBPDirPath();
        if (crashDir != null && crashDir.length() != 0) {
            File dir = new File(crashDir);
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles(new C46273());
                if (files != null && files.length != 0) {
                    int length = files.length;
                    int i = 0;
                    while (i < length) {
                        File f = files[i];
                        loge("NativeCrashUtils.checkNativeCrash() fpath=" + f.getAbsolutePath());
                        bos = null;
                        zos = null;
                        fis = null;
                        backupDmpFos = null;
                        try {
                            ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
                            try {
                                gZIPOutputStream = new GZIPOutputStream(bos2);
                            } catch (Exception e) {
                                bos = bos2;
                                if (fis != null) {
                                    try {
                                        fis.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                if (zos != null) {
                                    zos.close();
                                }
                                if (bos != null) {
                                    bos.close();
                                }
                                if (backupDmpFos == null) {
                                    backupDmpFos.close();
                                }
                                i++;
                            } catch (Throwable th2) {
                                th = th2;
                                bos = bos2;
                            }
                            try {
                                byte[] buf = new byte[1024];
                                byte[] addInfoBs = new String(generateCrashLogHead().getBytes(), "utf-8").getBytes("utf-8");
                                if (addInfoBs.length > 1024) {
                                    loge("head info is too large !!!!!!!!!!!");
                                    if (fis != null) {
                                        try {
                                            fis.close();
                                        } catch (IOException e3) {
                                            return;
                                        }
                                    }
                                    if (gZIPOutputStream != null) {
                                        gZIPOutputStream.close();
                                    }
                                    if (bos2 != null) {
                                        bos2.close();
                                    }
                                    if (backupDmpFos != null) {
                                        backupDmpFos.close();
                                        return;
                                    }
                                    return;
                                }
                                loge("addInfolen:" + addInfoBs.length + ", restoreAddInfo=" + new String(addInfoBs, "utf-8"));
                                gZIPOutputStream.write(addInfoBs, 0, addInfoBs.length);
                                byte[] tb = new byte[]{(byte) 32};
                                for (int i2 = 0; i2 < 1024 - addInfoBs.length; i2++) {
                                    gZIPOutputStream.write(tb);
                                }
                                File backupDmpFile = new File(crashDir + File.separator + BACKUP_DMP_FILENAME);
                                if (backupDmpFile.exists()) {
                                    backupDmpFile.delete();
                                }
                                FileOutputStream backupDmpFos2 = new FileOutputStream(backupDmpFile);
                                try {
                                    FileInputStream fileInputStream = new FileInputStream(f);
                                    while (true) {
                                        int count = fileInputStream.read(buf, 0, buf.length);
                                        if (count != -1) {
                                            gZIPOutputStream.write(buf, 0, count);
                                            gZIPOutputStream.flush();
                                            backupDmpFos2.write(buf, 0, count);
                                            backupDmpFos2.flush();
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e4) {
                                                backupDmpFos = backupDmpFos2;
                                                fis = fileInputStream;
                                                zos = gZIPOutputStream;
                                                bos = bos2;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                backupDmpFos = backupDmpFos2;
                                                fis = fileInputStream;
                                                zos = gZIPOutputStream;
                                                bos = bos2;
                                            }
                                        }
                                    }
                                    gZIPOutputStream.finish();
                                    byte[] zipBuf = bos2.toByteArray();
                                    loge("NativeCrashUtils.checkNativeCrash() crashGzipBuf.length=" + zipBuf.length);
                                    if (uploadCrashLog(f.getName(), zipBuf)) {
                                        loge("success to upload crash log.");
                                        JSONObject joAll = getBackProtocolJSON();
                                        if (joAll != null) {
                                            byte[] gzipBuf = gzipBytes(joAll.toString().getBytes());
                                            loge("NativeCrashUtils.checkNativeCrash() backprotocolgzipBufLen=" + gzipBuf.length);
                                            if (gzipBuf == null || gzipBuf.length <= 0) {
                                                loge("failed to gzip back protocol.");
                                            } else if (uploadBackProtocolToServer("androidCrashStats.dat", gzipBuf)) {
                                                loge("success to upload back protocol.");
                                                deleteFiles(files);
                                            } else {
                                                loge("failed to upload back protocol.");
                                            }
                                        } else {
                                            loge("failed to get back protocol json.");
                                        }
                                    } else {
                                        loge("failed to upload crash log");
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (gZIPOutputStream != null) {
                                        gZIPOutputStream.close();
                                    }
                                    if (bos2 != null) {
                                        bos2.close();
                                    }
                                    if (backupDmpFos2 != null) {
                                        backupDmpFos2.close();
                                    }
                                    backupDmpFos = backupDmpFos2;
                                    fis = fileInputStream;
                                    zos = gZIPOutputStream;
                                    bos = bos2;
                                } catch (Exception e6) {
                                    backupDmpFos = backupDmpFos2;
                                    zos = gZIPOutputStream;
                                    bos = bos2;
                                    if (fis != null) {
                                        fis.close();
                                    }
                                    if (zos != null) {
                                        zos.close();
                                    }
                                    if (bos != null) {
                                        bos.close();
                                    }
                                    if (backupDmpFos == null) {
                                        backupDmpFos.close();
                                    }
                                    i++;
                                } catch (Throwable th4) {
                                    th = th4;
                                    backupDmpFos = backupDmpFos2;
                                    zos = gZIPOutputStream;
                                    bos = bos2;
                                }
                                i++;
                            } catch (Exception e7) {
                                zos = gZIPOutputStream;
                                bos = bos2;
                                if (fis != null) {
                                    fis.close();
                                }
                                if (zos != null) {
                                    zos.close();
                                }
                                if (bos != null) {
                                    bos.close();
                                }
                                if (backupDmpFos == null) {
                                    backupDmpFos.close();
                                }
                                i++;
                            } catch (Throwable th5) {
                                th = th5;
                                zos = gZIPOutputStream;
                                bos = bos2;
                            }
                        } catch (Exception e8) {
                            if (fis != null) {
                                fis.close();
                            }
                            if (zos != null) {
                                zos.close();
                            }
                            if (bos != null) {
                                bos.close();
                            }
                            if (backupDmpFos == null) {
                                backupDmpFos.close();
                            }
                            i++;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        return;
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e9) {
                throw th;
            }
        }
        if (zos != null) {
            zos.close();
        }
        if (bos != null) {
            bos.close();
        }
        if (backupDmpFos != null) {
            backupDmpFos.close();
        }
        throw th;
    }

    private static void deleteFiles(File[] files) {
        for (int i = files.length - 1; i >= 0; i--) {
            File f = files[i];
            if (f != null && f.exists()) {
                f.delete();
            }
        }
    }

    private static String generateCrashLogHead() {
        String crashHeadInfo = "sv:" + PackageUtil.strSoftWareVer + ";os:android;sw:" + ScreenUtil.getInstance().getWidthPixels() + ";cuid:" + PackageUtil.getCuid() + ";pd:carlife;ch:" + PackageUtil.getChannel() + ";mb:" + PackageUtil.strPhoneType + ";sh:" + ScreenUtil.getInstance().getHeightPixels() + ";ov:Android" + VERSION.SDK_INT + ";";
        loge("crashHeadInfo=" + crashHeadInfo);
        return crashHeadInfo;
    }

    private static JSONObject getBackProtocolJSON() {
        JSONObject joAll = generateAllAndHeadJSON();
        JSONArray jaLogs = new JSONArray();
        if (joAll == null) {
            return null;
        }
        JSONObject jo = generateLogItem();
        if (jo == null) {
            return null;
        }
        jaLogs.put(jo);
        try {
            joAll.put("log", jaLogs);
            return joAll;
        } catch (JSONException e) {
            return null;
        }
    }

    private static JSONObject generateAllAndHeadJSON() {
        JSONObject joAll = new JSONObject();
        JSONObject joHead = new JSONObject();
        try {
            joHead.put("sv", PackageUtil.strSoftWareVer);
            joHead.put("os", "android");
            joHead.put("sw", ScreenUtil.getInstance().getWidthPixels());
            joHead.put("cuid", PackageUtil.getCuid());
            joHead.put("pd", C2848p.f9316q);
            joHead.put("ch", PackageUtil.getChannel());
            joHead.put("mb", PackageUtil.strPhoneType);
            joHead.put("sh", ScreenUtil.getInstance().getHeightPixels());
            joHead.put("ov", C1253f.jb + VERSION.SDK_INT);
            joHead.put("ver", "2");
            if (BNaviModuleManager.getContext() != null) {
                joHead.put("deviceid", PackageUtil.getImeiNum());
            } else {
                joHead.put("deviceid", "");
            }
            joAll.put("head", joHead);
            return joAll;
        } catch (JSONException e) {
            return null;
        }
    }

    private static JSONObject generateLogItem() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("net", BNaviModuleManager.getContext() == null ? "0" : NetworkUtils.getCurrentNetMode(BNaviModuleManager.getContext()));
            jo.put("lt", "3000");
            jo.put("tm", "" + new Date().getTime());
            jo.put(NaviStatConstants.STAT_ACT_PARAM, "crashlog");
            JSONObject jo2 = new JSONObject();
            jo2.put(GetPluginInfoDataStruct.KEY_DETAIL, "unknown");
            jo2.put("reason", "unknown");
            jo.put("ActParam", jo2);
            return jo;
        } catch (Exception e) {
            return null;
        }
    }

    private static void printJSONObjectToFile(JSONObject jo, String path) {
        Throwable th;
        if (jo != null && path != null && path.length() != 0) {
            File f = new File(path);
            if (f.exists()) {
                f.delete();
            }
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(path);
                try {
                    fos2.write(jo.toString().getBytes());
                    fos2.flush();
                    if (fos2 != null) {
                        try {
                            fos2.close();
                            fos = fos2;
                            return;
                        } catch (IOException e) {
                            fos = fos2;
                            return;
                        }
                    }
                } catch (Exception e2) {
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (fos != null) {
                    fos.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        }
    }

    private static void printStringToFile(String msg, String path) {
        Throwable th;
        if (msg != null && path != null && path.length() != 0) {
            File f = new File(path);
            if (f.exists()) {
                f.delete();
            }
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(path);
                try {
                    fos2.write(msg.getBytes());
                    fos2.flush();
                    if (fos2 != null) {
                        try {
                            fos2.close();
                            fos = fos2;
                            return;
                        } catch (IOException e) {
                            fos = fos2;
                            return;
                        }
                    }
                } catch (Exception e2) {
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (fos != null) {
                    fos.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        }
    }

    private static void printBytesToGZIPFile(byte[] gzipData, String destPath) {
        Throwable th;
        if (gzipData != null && destPath != null) {
            FileOutputStream fos = null;
            try {
                FileOutputStream fos2 = new FileOutputStream(destPath);
                try {
                    fos2.write(gzipData);
                    fos2.flush();
                    if (fos2 != null) {
                        try {
                            fos2.close();
                        } catch (Exception e) {
                            fos = fos2;
                            return;
                        }
                    }
                    fos = fos2;
                } catch (Exception e2) {
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e3) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fos = fos2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (fos != null) {
                    fos.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fos != null) {
                    fos.close();
                }
                throw th;
            }
        }
    }

    private static byte[] gzipBytes(byte[] originBuf) {
        Throwable th;
        if (originBuf == null || originBuf.length == 0) {
            return null;
        }
        loge("gzipBytes.originBuf.len=" + originBuf.length);
        ByteArrayOutputStream bos = null;
        GZIPOutputStream gzipos = null;
        try {
            GZIPOutputStream gzipos2;
            ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
            try {
                gzipos2 = new GZIPOutputStream(bos2);
            } catch (Exception e) {
                bos = bos2;
                if (gzipos != null) {
                    try {
                        gzipos.close();
                    } catch (Exception e2) {
                        return null;
                    }
                }
                if (bos != null) {
                    return null;
                }
                bos.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                bos = bos2;
                if (gzipos != null) {
                    try {
                        gzipos.close();
                    } catch (Exception e3) {
                        throw th;
                    }
                }
                if (bos != null) {
                    bos.close();
                }
                throw th;
            }
            try {
                gzipos2.write(originBuf, 0, originBuf.length);
                gzipos2.flush();
                gzipos2.finish();
                byte[] newBuf = bos2.toByteArray();
                loge("gzipBytes.gzipBuf.len=" + newBuf.length);
                if (gzipos2 != null) {
                    try {
                        gzipos2.close();
                    } catch (Exception e4) {
                        gzipos = gzipos2;
                        bos = bos2;
                        return newBuf;
                    }
                }
                if (bos2 != null) {
                    bos2.close();
                }
                gzipos = gzipos2;
                bos = bos2;
                return newBuf;
            } catch (Exception e5) {
                gzipos = gzipos2;
                bos = bos2;
                if (gzipos != null) {
                    gzipos.close();
                }
                if (bos != null) {
                    return null;
                }
                bos.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                gzipos = gzipos2;
                bos = bos2;
                if (gzipos != null) {
                    gzipos.close();
                }
                if (bos != null) {
                    bos.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            if (gzipos != null) {
                gzipos.close();
            }
            if (bos != null) {
                return null;
            }
            bos.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (gzipos != null) {
                gzipos.close();
            }
            if (bos != null) {
                bos.close();
            }
            throw th;
        }
    }

    private static void ungzipFile(String srcPath, String destPath) {
        Throwable th;
        if (srcPath != null && destPath != null) {
            FileInputStream fis = null;
            GZIPInputStream gis = null;
            FileOutputStream fos = null;
            try {
                GZIPInputStream gis2;
                FileInputStream fis2 = new FileInputStream(srcPath);
                try {
                    gis2 = new GZIPInputStream(fis2);
                } catch (Exception e) {
                    fis = fis2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    if (gis != null) {
                        gis.close();
                    }
                    if (fis == null) {
                        fis.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fis = fis2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (gis != null) {
                        gis.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                    throw th;
                }
                try {
                    FileOutputStream fos2 = new FileOutputStream(destPath);
                    try {
                        byte[] buf = new byte[1024];
                        while (true) {
                            int count = gis2.read(buf, 0, buf.length);
                            if (count == -1) {
                                break;
                            }
                            fos2.write(buf, 0, count);
                            fos2.flush();
                        }
                        if (fos2 != null) {
                            try {
                                fos2.close();
                            } catch (Exception e4) {
                                fos = fos2;
                                gis = gis2;
                                fis = fis2;
                                return;
                            }
                        }
                        if (gis2 != null) {
                            gis2.close();
                        }
                        if (fis2 != null) {
                            fis2.close();
                        }
                        fos = fos2;
                        gis = gis2;
                        fis = fis2;
                    } catch (Exception e5) {
                        fos = fos2;
                        gis = gis2;
                        fis = fis2;
                        if (fos != null) {
                            fos.close();
                        }
                        if (gis != null) {
                            gis.close();
                        }
                        if (fis == null) {
                            fis.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fos = fos2;
                        gis = gis2;
                        fis = fis2;
                        if (fos != null) {
                            fos.close();
                        }
                        if (gis != null) {
                            gis.close();
                        }
                        if (fis != null) {
                            fis.close();
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    gis = gis2;
                    fis = fis2;
                    if (fos != null) {
                        fos.close();
                    }
                    if (gis != null) {
                        gis.close();
                    }
                    if (fis == null) {
                        fis.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gis = gis2;
                    fis = fis2;
                    if (fos != null) {
                        fos.close();
                    }
                    if (gis != null) {
                        gis.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                if (fos != null) {
                    fos.close();
                }
                if (gis != null) {
                    gis.close();
                }
                if (fis == null) {
                    fis.close();
                }
            } catch (Throwable th5) {
                th = th5;
                if (fos != null) {
                    fos.close();
                }
                if (gis != null) {
                    gis.close();
                }
                if (fis != null) {
                    fis.close();
                }
                throw th;
            }
        }
    }

    private static void ungzipFile(byte[] gzipData, String destPath) {
        GZIPInputStream gis;
        Throwable th;
        if (gzipData != null && destPath != null) {
            ByteArrayInputStream bis = null;
            GZIPInputStream gis2 = null;
            FileOutputStream fos = null;
            try {
                ByteArrayInputStream bis2 = new ByteArrayInputStream(gzipData);
                try {
                    gis = new GZIPInputStream(bis2);
                } catch (Exception e) {
                    bis = bis2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    if (gis2 != null) {
                        gis2.close();
                    }
                    if (bis == null) {
                        bis.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bis = bis2;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (gis2 != null) {
                        gis2.close();
                    }
                    if (bis != null) {
                        bis.close();
                    }
                    throw th;
                }
                try {
                    FileOutputStream fos2 = new FileOutputStream(destPath);
                    try {
                        byte[] buf = new byte[1024];
                        while (true) {
                            int count = gis.read(buf, 0, buf.length);
                            if (count == -1) {
                                break;
                            }
                            fos2.write(buf, 0, count);
                            fos2.flush();
                        }
                        if (fos2 != null) {
                            try {
                                fos2.close();
                            } catch (Exception e4) {
                                fos = fos2;
                                gis2 = gis;
                                bis = bis2;
                                return;
                            }
                        }
                        if (gis != null) {
                            gis.close();
                        }
                        if (bis2 != null) {
                            bis2.close();
                        }
                        fos = fos2;
                        gis2 = gis;
                        bis = bis2;
                    } catch (Exception e5) {
                        fos = fos2;
                        gis2 = gis;
                        bis = bis2;
                        if (fos != null) {
                            fos.close();
                        }
                        if (gis2 != null) {
                            gis2.close();
                        }
                        if (bis == null) {
                            bis.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fos = fos2;
                        gis2 = gis;
                        bis = bis2;
                        if (fos != null) {
                            fos.close();
                        }
                        if (gis2 != null) {
                            gis2.close();
                        }
                        if (bis != null) {
                            bis.close();
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    gis2 = gis;
                    bis = bis2;
                    if (fos != null) {
                        fos.close();
                    }
                    if (gis2 != null) {
                        gis2.close();
                    }
                    if (bis == null) {
                        bis.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    gis2 = gis;
                    bis = bis2;
                    if (fos != null) {
                        fos.close();
                    }
                    if (gis2 != null) {
                        gis2.close();
                    }
                    if (bis != null) {
                        bis.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                if (fos != null) {
                    fos.close();
                }
                if (gis2 != null) {
                    gis2.close();
                }
                if (bis == null) {
                    bis.close();
                }
            } catch (Throwable th5) {
                th = th5;
                if (fos != null) {
                    fos.close();
                }
                if (gis2 != null) {
                    gis2.close();
                }
                if (bis != null) {
                    bis.close();
                }
                throw th;
            }
        }
    }

    private static void parseDmpWithHead(String dmpPath, String destDirPath) {
        Throwable th;
        if (dmpPath != null && dmpPath.length() != 0 && new File(dmpPath).exists()) {
            FileInputStream fis = null;
            FileOutputStream fosHead = null;
            FileOutputStream fosDmp = null;
            try {
                FileOutputStream fosHead2;
                FileOutputStream fosDmp2;
                FileInputStream fis2 = new FileInputStream(dmpPath);
                try {
                    fosHead2 = new FileOutputStream(destDirPath + "/headInfo.txt");
                } catch (Exception e) {
                    fis = fis2;
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    if (fosHead != null) {
                        fosHead.close();
                    }
                    if (fosDmp == null) {
                        fosDmp.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fis = fis2;
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (fosHead != null) {
                        fosHead.close();
                    }
                    if (fosDmp != null) {
                        fosDmp.close();
                    }
                    throw th;
                }
                try {
                    fosDmp2 = new FileOutputStream(destDirPath + "/finalCrashLog.dmp");
                } catch (Exception e4) {
                    fosHead = fosHead2;
                    fis = fis2;
                    if (fis != null) {
                        fis.close();
                    }
                    if (fosHead != null) {
                        fosHead.close();
                    }
                    if (fosDmp == null) {
                        fosDmp.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fosHead = fosHead2;
                    fis = fis2;
                    if (fis != null) {
                        fis.close();
                    }
                    if (fosHead != null) {
                        fosHead.close();
                    }
                    if (fosDmp != null) {
                        fosDmp.close();
                    }
                    throw th;
                }
                try {
                    byte[] buf = new byte[1024];
                    if (fis2.read(buf) == 1024) {
                        fosHead2.write(buf, 0, 1024);
                        fosHead2.flush();
                        while (true) {
                            int count = fis2.read(buf);
                            if (count == -1) {
                                break;
                            }
                            fosDmp2.write(buf, 0, count);
                            fosDmp2.flush();
                        }
                    }
                    if (fis2 != null) {
                        try {
                            fis2.close();
                        } catch (Exception e5) {
                            fosDmp = fosDmp2;
                            fosHead = fosHead2;
                            fis = fis2;
                            return;
                        }
                    }
                    if (fosHead2 != null) {
                        fosHead2.close();
                    }
                    if (fosDmp2 != null) {
                        fosDmp2.close();
                    }
                    fosDmp = fosDmp2;
                    fosHead = fosHead2;
                    fis = fis2;
                } catch (Exception e6) {
                    fosDmp = fosDmp2;
                    fosHead = fosHead2;
                    fis = fis2;
                    if (fis != null) {
                        fis.close();
                    }
                    if (fosHead != null) {
                        fosHead.close();
                    }
                    if (fosDmp == null) {
                        fosDmp.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fosDmp = fosDmp2;
                    fosHead = fosHead2;
                    fis = fis2;
                    if (fis != null) {
                        fis.close();
                    }
                    if (fosHead != null) {
                        fosHead.close();
                    }
                    if (fosDmp != null) {
                        fosDmp.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                if (fis != null) {
                    fis.close();
                }
                if (fosHead != null) {
                    fosHead.close();
                }
                if (fosDmp == null) {
                    fosDmp.close();
                }
            } catch (Throwable th5) {
                th = th5;
                if (fis != null) {
                    fis.close();
                }
                if (fosHead != null) {
                    fosHead.close();
                }
                if (fosDmp != null) {
                    fosDmp.close();
                }
                throw th;
            }
        }
    }

    private static boolean uploadCrashLog(String filename, byte[] data) {
        return uploadCrashLogToNaviServer(filename, data);
    }

    private static boolean uploadCrashLogToMapServer(String filename, byte[] data) {
        boolean ret;
        loge("uploadCrashLogToMapServer() begin");
        try {
            HttpPostUtil u = new HttpPostUtil(UPLOAD_LOG_URL, "datafile");
            u.addTextParameter("ver", "2");
            u.addTextParameter("pd", "navi");
            u.addTextParameter("cuid", PackageUtil.getCuid());
            u.addTextParameter("os", "android");
            u.addFileParameter(filename, data);
            String result = new String(u.send());
            if (u.getResCode() == 200) {
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret = false;
        }
        loge("uploadCrashLogToMapServer() ret=" + ret);
        return ret;
    }

    private static boolean uploadCrashLogToNaviServer(String filename, byte[] data) {
        boolean ret;
        loge("uploadCrashLogToNaviServer() begin");
        try {
            HttpPostUtil u = new HttpPostUtil(UPLOAD_LOG_NAVI_URL, "datafile");
            u.addTextParameter(SpeechConstant.APP_ID, "1");
            u.addTextParameter("app_ver", PackageUtil.getVersionName());
            u.addTextParameter("os", "0");
            List<NameValuePair> list = new ArrayList();
            list.add(new BasicNameValuePair("app_ver", PackageUtil.getVersionName()));
            list.add(new BasicNameValuePair(SpeechConstant.APP_ID, "1"));
            list.add(new BasicNameValuePair("os", "0"));
            String sign = HttpUtils.calcUrlSign(list);
            loge("uploadCrashLogToNaviServer() sign=" + sign);
            u.addTextParameter("sign", sign);
            u.addFileParameter(filename, data);
            String result = new String(u.send());
            if (u.getResCode() == 200) {
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret = false;
        }
        loge("uploadCrashLogToNaviServer() ret=" + ret);
        return ret;
    }

    private static boolean uploadBackProtocolToServer(String filename, byte[] data) {
        try {
            HttpPostUtil u = new HttpPostUtil(UPLOAD_PROTOCOL_URL, "datafile");
            u.addTextParameter("ver", "2");
            u.addTextParameter("pd", "navi");
            u.addTextParameter("cuid", PackageUtil.getCuid());
            u.addTextParameter("os", "android");
            u.addFileParameter(filename, data);
            String result = new String(u.send());
            if (u.getResCode() == 200) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void loge(String msg) {
    }

    private static void initDirs() {
        File f = new File(SysOSAPI.getInstance().GetSDCardPath() + BP_FOLDER);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    private static String getBPDirPath() {
        return SysOSAPI.getInstance().GetSDCardPath() + BP_FOLDER;
    }
}
