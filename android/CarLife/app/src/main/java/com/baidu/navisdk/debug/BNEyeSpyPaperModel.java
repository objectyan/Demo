package com.baidu.navisdk.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class BNEyeSpyPaperModel {
    private static final String TAG = "BNEyeSpyPaperModel";
    private boolean hasPostSuccess = true;
    private boolean isInTestPlaner = false;
    public String mDespText = null;
    public String mProblemId = null;
    public int mUploadSource = 0;

    /* renamed from: com.baidu.navisdk.debug.BNEyeSpyPaperModel$1 */
    class C40831 extends BNHttpTextResponseHandler {
        C40831() {
        }

        public void onSuccess(int statusCode, String responseString) {
            LogUtil.m15791e(BNEyeSpyPaperModel.TAG, "postUserStatus().ok statusCode=" + statusCode + ", s=" + responseString);
            boolean result = false;
            if (statusCode == 200) {
                try {
                    if (new JSONObject(responseString).optInt(C2125n.f6745M, -1) == 0) {
                        result = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (result) {
                BNEyeSpyPaperModel.this.hasPostSuccess = true;
            } else {
                BNEyeSpyPaperModel.this.hasPostSuccess = false;
            }
        }

        public void onFailure(int statusCode, String responseString, Throwable throwable) {
            LogUtil.m15791e(BNEyeSpyPaperModel.TAG, "postUserStatus().err statusCode=" + statusCode + ", s=" + responseString);
            BNEyeSpyPaperModel.this.hasPostSuccess = false;
        }
    }

    public interface UploadSource {
        public static final int AUTO_INIT_FILA = 4;
        public static final int AUTO_TIMEOUT = 3;
        public static final int CAR_RESULT = 1;
        public static final int INVILATE = 0;
        public static final int NAVING = 2;
        public static final int ROUTE_PLAN_TIMEOUT = 5;
    }

    public void initParmsAfterCloud() {
        this.isInTestPlaner = CloudlConfigDataModel.getInstance().mCommonConfig.isEyespyPagerOpen;
    }

    public void addToTestPlaner() {
        if (!isInTestPlaner() || !this.hasPostSuccess) {
            this.isInTestPlaner = true;
            postUserStatus(this.isInTestPlaner);
        }
    }

    public void removeFormTestPlaner() {
        this.isInTestPlaner = false;
        postUserStatus(this.isInTestPlaner);
    }

    public String generateProblemId() {
        this.mProblemId = PackageUtil.getCuid() + JNISearchConst.LAYER_ID_DIVIDER + System.currentTimeMillis();
        LogUtil.m15791e(TAG, "mProblemId:" + this.mProblemId);
        return this.mProblemId;
    }

    private void postUserStatus(boolean add) {
        try {
            StringBuffer sb = new StringBuffer();
            HashMap<String, String> getMethodParams = new HashMap();
            getMethodParams.put("bduss", "");
            sb.append("bduss=");
            sb.append(URLEncoder.encode("", "utf-8"));
            getMethodParams.put("cuid", PackageUtil.getCuid());
            sb.append("&cuid=");
            sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
            getMethodParams.put("ignoreLogin", "1");
            sb.append("&ignoreLogin=");
            sb.append(URLEncoder.encode("1", "utf-8"));
            getMethodParams.put("option", add ? "1" : "2");
            sb.append("&option=");
            sb.append(URLEncoder.encode(add ? "1" : "2", "utf-8"));
            getMethodParams.put("os", "0");
            sb.append("&os=");
            sb.append(URLEncoder.encode("0", "utf-8"));
            getMethodParams.put("osv", VDeviceAPI.getOsVersion());
            sb.append("&osv=");
            sb.append(URLEncoder.encode(VDeviceAPI.getOsVersion(), "utf-8"));
            getMethodParams.put("sv", PackageUtil.getVersionName());
            sb.append("&sv=");
            sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
            String signStr = "skyeye" + sb.toString() + "b428c8dad16d0bc031b4d7ef4e7bec80";
            getMethodParams.put("sign", MD5.toMD5(signStr).toLowerCase());
            LogUtil.m15791e(TAG, "postUserStatus().ok signStr=" + signStr);
            BNHttpCenter.getInstance().get(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_SKYEYE_USER_STATUS), getMethodParams, new C40831(), null);
        } catch (Exception e) {
        }
    }

    public boolean isInTestPlaner() {
        return this.isInTestPlaner;
    }

    public boolean isKeyLogExist() {
        File coreLogFile = new File(SDKDebugFileUtil.getInstance().getCoreLogDir());
        File[] files = null;
        if (coreLogFile != null && coreLogFile.exists()) {
            files = coreLogFile.listFiles();
        }
        if (files == null || files.length <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadLogFile() {
        /*
        r17 = this;
        r12 = com.baidu.navisdk.debug.SDKDebugFileUtil.getInstance();
        r1 = r12.getCoreLogDir();
        r2 = new java.io.File;
        r2.<init>(r1);
        r6 = 0;
        if (r2 == 0) goto L_0x001a;
    L_0x0010:
        r12 = r2.exists();
        if (r12 == 0) goto L_0x001a;
    L_0x0016:
        r6 = r2.listFiles();
    L_0x001a:
        r10 = new java.io.File;
        r12 = "coreLog.zip";
        r10.<init>(r1, r12);
        r11 = 0;
        r11 = com.baidu.navisdk.util.common.ZipUtils.getZipOutputStream(r10);	 Catch:{ Exception -> 0x005f }
        if (r6 == 0) goto L_0x008e;
    L_0x0029:
        r12 = r6.length;	 Catch:{ Exception -> 0x005f }
        if (r12 <= 0) goto L_0x008e;
    L_0x002c:
        r13 = r6.length;	 Catch:{ Exception -> 0x005f }
        r12 = 0;
    L_0x002e:
        if (r12 >= r13) goto L_0x008e;
    L_0x0030:
        r9 = r6[r12];	 Catch:{ Exception -> 0x005f }
        r14 = r9.getName();	 Catch:{ Exception -> 0x003c }
        com.baidu.navisdk.util.common.ZipUtils.zip(r9, r11, r14);	 Catch:{ Exception -> 0x003c }
    L_0x0039:
        r12 = r12 + 1;
        goto L_0x002e;
    L_0x003c:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Exception -> 0x005f }
        r14 = "BNEyeSpyPaperModel";
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005f }
        r15.<init>();	 Catch:{ Exception -> 0x005f }
        r16 = "uploadLogFile Exception:";
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x005f }
        r16 = r3.getMessage();	 Catch:{ Exception -> 0x005f }
        r15 = r15.append(r16);	 Catch:{ Exception -> 0x005f }
        r15 = r15.toString();	 Catch:{ Exception -> 0x005f }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r14, r15);	 Catch:{ Exception -> 0x005f }
        goto L_0x0039;
    L_0x005f:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x00ef }
        r12 = "BNEyeSpyPaperModel";
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ef }
        r13.<init>();	 Catch:{ all -> 0x00ef }
        r14 = "uploadLogFile getZipOutputStream Exception :";
        r13 = r13.append(r14);	 Catch:{ all -> 0x00ef }
        r14 = r3.getMessage();	 Catch:{ all -> 0x00ef }
        r13 = r13.append(r14);	 Catch:{ all -> 0x00ef }
        r13 = r13.toString();	 Catch:{ all -> 0x00ef }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r12, r13);	 Catch:{ all -> 0x00ef }
        com.baidu.navisdk.util.common.LogUtil.printCallStatck();	 Catch:{ all -> 0x00ef }
        com.baidu.navisdk.util.common.ZipUtils.closeStrem(r11);
    L_0x0087:
        r12 = 0;
        r0 = r17;
        r0.uploadFile(r10, r12);	 Catch:{ Exception -> 0x012b }
    L_0x008d:
        return;
    L_0x008e:
        r12 = com.baidu.navisdk.jni.nativeif.JNINaviManager.sInstance;	 Catch:{ Exception -> 0x005f }
        r13 = 0;
        r5 = r12.getInitLogPath(r13);	 Catch:{ Exception -> 0x005f }
        if (r5 == 0) goto L_0x00ab;
    L_0x0097:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x005f }
        r4.<init>(r5);	 Catch:{ Exception -> 0x005f }
        if (r4 == 0) goto L_0x00f4;
    L_0x009e:
        r12 = r4.exists();	 Catch:{ Exception -> 0x005f }
        if (r12 == 0) goto L_0x00f4;
    L_0x00a4:
        r12 = r4.getName();	 Catch:{ Exception -> 0x00cc }
        com.baidu.navisdk.util.common.ZipUtils.zip(r4, r11, r12);	 Catch:{ Exception -> 0x00cc }
    L_0x00ab:
        r12 = com.baidu.navisdk.jni.nativeif.JNINaviManager.sInstance;	 Catch:{ Exception -> 0x005f }
        r13 = 1;
        r8 = r12.getInitLogPath(r13);	 Catch:{ Exception -> 0x005f }
        if (r8 == 0) goto L_0x00c8;
    L_0x00b4:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x005f }
        r7.<init>(r8);	 Catch:{ Exception -> 0x005f }
        if (r7 == 0) goto L_0x0121;
    L_0x00bb:
        r12 = r7.exists();	 Catch:{ Exception -> 0x005f }
        if (r12 == 0) goto L_0x0121;
    L_0x00c1:
        r12 = r7.getName();	 Catch:{ Exception -> 0x00fe }
        com.baidu.navisdk.util.common.ZipUtils.zip(r7, r11, r12);	 Catch:{ Exception -> 0x00fe }
    L_0x00c8:
        com.baidu.navisdk.util.common.ZipUtils.closeStrem(r11);
        goto L_0x0087;
    L_0x00cc:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Exception -> 0x005f }
        r12 = "BNEyeSpyPaperModel";
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005f }
        r13.<init>();	 Catch:{ Exception -> 0x005f }
        r14 = "uploadLogFile Exception:";
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x005f }
        r14 = r3.getMessage();	 Catch:{ Exception -> 0x005f }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x005f }
        r13 = r13.toString();	 Catch:{ Exception -> 0x005f }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r12, r13);	 Catch:{ Exception -> 0x005f }
        goto L_0x00ab;
    L_0x00ef:
        r12 = move-exception;
        com.baidu.navisdk.util.common.ZipUtils.closeStrem(r11);
        throw r12;
    L_0x00f4:
        r12 = "BNEyeSpyPaperModel";
        r13 = "engineeFile not exist";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r12, r13);	 Catch:{ Exception -> 0x005f }
        goto L_0x00ab;
    L_0x00fe:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Exception -> 0x005f }
        r12 = "BNEyeSpyPaperModel";
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005f }
        r13.<init>();	 Catch:{ Exception -> 0x005f }
        r14 = "uploadLogFile Exception:";
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x005f }
        r14 = r3.getMessage();	 Catch:{ Exception -> 0x005f }
        r13 = r13.append(r14);	 Catch:{ Exception -> 0x005f }
        r13 = r13.toString();	 Catch:{ Exception -> 0x005f }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r12, r13);	 Catch:{ Exception -> 0x005f }
        goto L_0x00c8;
    L_0x0121:
        r12 = "BNEyeSpyPaperModel";
        r13 = "rpLogPath not exist";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r12, r13);	 Catch:{ Exception -> 0x005f }
        goto L_0x00c8;
    L_0x012b:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.debug.BNEyeSpyPaperModel.uploadLogFile():void");
    }

    private void uploadFile(final File uploadFile, boolean isSilent) throws UnsupportedEncodingException {
        BNHttpParams httpParams = new BNHttpParams();
        httpParams.isAsync = true;
        httpParams.fileKey = "datafile";
        httpParams.file = uploadFile;
        StringBuffer sb = new StringBuffer();
        HashMap<String, String> normapParams = new HashMap();
        normapParams.put("buildtime", PackageUtil.getBuildNo());
        sb.append("buildtime=");
        sb.append(URLEncoder.encode(PackageUtil.getBuildNo(), "utf-8"));
        normapParams.put("content", TextUtils.isEmpty(this.mDespText) ? "" : this.mDespText);
        sb.append("&content=");
        sb.append(URLEncoder.encode(TextUtils.isEmpty(this.mDespText) ? "" : this.mDespText, "utf-8"));
        normapParams.put("cuid", PackageUtil.getCuid());
        sb.append("&cuid=");
        sb.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
        normapParams.put("file_type", "2");
        sb.append("&file_type=");
        sb.append(URLEncoder.encode("2", "utf-8"));
        normapParams.put("ignoreLogin", "1");
        sb.append("&ignoreLogin=");
        sb.append(URLEncoder.encode("1", "utf-8"));
        normapParams.put("mb", "" + VDeviceAPI.getPhoneType());
        sb.append("&mb=");
        sb.append(URLEncoder.encode(VDeviceAPI.getPhoneType(), "utf-8"));
        normapParams.put("os", "0");
        sb.append("&os=");
        sb.append(URLEncoder.encode("0", "utf-8"));
        normapParams.put("pic", "");
        sb.append("&pic=");
        sb.append(URLEncoder.encode("", "utf-8"));
        GeoPoint curPoint = RGEngineControl.getInstance().getCurrentGeoPoint();
        Bundle bundle = null;
        if (curPoint != null) {
            bundle = CoordinateTransformUtil.LLE62MC(curPoint.getLongitudeE6(), curPoint.getLatitudeE6());
        }
        if (bundle != null) {
            int ptx = bundle.getInt("MCx", 0);
            int pty = bundle.getInt("MCy", 0);
            normapParams.put("point", ptx + "," + pty);
            sb.append("&point=");
            sb.append(URLEncoder.encode(ptx + "," + pty, "utf-8"));
        }
        if (TextUtils.isEmpty(this.mProblemId)) {
            generateProblemId();
        }
        normapParams.put("problem_id", this.mProblemId);
        sb.append("&problem_id=");
        sb.append(URLEncoder.encode(this.mProblemId, "utf-8"));
        normapParams.put("screenshot", "");
        sb.append("&screenshot=");
        sb.append(URLEncoder.encode("", "utf-8"));
        normapParams.put("source", this.mUploadSource + "");
        sb.append("&source=");
        sb.append(URLEncoder.encode(this.mUploadSource + "", "utf-8"));
        normapParams.put("sv", PackageUtil.getVersionName());
        sb.append("&sv=");
        sb.append(URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
        normapParams.put("sign", MD5.toMD5("skyeye" + sb.toString() + "b428c8dad16d0bc031b4d7ef4e7bec80").toLowerCase());
        BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(ULRParam.URL_SKYEYE_POST_LOG), normapParams, new BNHttpTextResponseHandler() {
            public void onSuccess(int statusCode, String responseString) {
                if (statusCode == 200) {
                    try {
                        if (new JSONObject(responseString).optInt(C2125n.f6745M, -1) == 0) {
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (uploadFile != null && uploadFile.exists()) {
                        uploadFile.delete();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onFailure(int statusCode, String responseString, Throwable throwable) {
                try {
                    if (uploadFile != null && uploadFile.exists()) {
                        uploadFile.delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, httpParams);
    }
}
