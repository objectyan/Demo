package com.baidu.navisdk.logic.commandparser;

import android.os.Message;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpGetBase;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class CmdGeneralHttpRequestDataFunc extends HttpGetBase {
    public static final int K_TIMEOUT = 500000;
    public static final String TAG = CmdGeneralHttpRequestDataFunc.class.getSimpleName();
    private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
    private Callback mCallback = null;

    public interface Callback {
        public static final int REQUEST_TYPE_FILE = 2;
        public static final int REQUEST_TYPE_JSON = 1;

        long getFileDownloadPos();

        String getFilePrefix();

        long getFileSize();

        List<NameValuePair> getRequestParams();

        int getRequestType();

        String getSDCardFilePath();

        String getUrl();

        boolean isCancelStatus();

        boolean isPauseStatus();

        boolean parseResponseJSON(JSONObject jSONObject);

        void responseAudioFilePath(String str);

        void responseFileDownloadPos(long j);
    }

    protected String getUrl() {
        if (this.mCallback != null) {
            return this.mCallback.getUrl();
        }
        return null;
    }

    protected String getSDCardFilePath() {
        if (this.mCallback != null) {
            return this.mCallback.getSDCardFilePath();
        }
        return null;
    }

    protected boolean isPauseStatus() {
        if (this.mCallback != null) {
            return this.mCallback.isPauseStatus();
        }
        return true;
    }

    protected boolean isCancelStatus() {
        if (this.mCallback != null) {
            return this.mCallback.isCancelStatus();
        }
        return true;
    }

    protected String getFilePrefix() {
        if (this.mCallback != null) {
            return this.mCallback.getFilePrefix();
        }
        return null;
    }

    protected long getFileDownloadPos() {
        if (this.mCallback != null) {
            return this.mCallback.getFileDownloadPos();
        }
        return 0;
    }

    protected long getFileSize() {
        if (this.mCallback != null) {
            return this.mCallback.getFileSize();
        }
        return 0;
    }

    protected void responseAudioFilePath(String fp) {
        if (this.mCallback != null) {
            this.mCallback.responseAudioFilePath(fp);
        }
    }

    protected void responseFileDownloadPos(long pos) {
        if (this.mCallback != null) {
            this.mCallback.responseFileDownloadPos(pos);
        }
    }

    public static void addFunc(ReqData reqdata, Callback cb) {
        sCallbackMaps.put(reqdata, cb);
    }

    protected CommandResult exec() {
        if (this.mCallback == null || this.mCallback.getRequestType() == 1) {
            return super.exec();
        }
        if (2 == this.mCallback.getRequestType()) {
            return requestFile();
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.navisdk.logic.CommandResult requestFile() {
        /*
        r31 = this;
        r28 = TAG;
        r29 = "requestFile";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);
        r28 = com.baidu.navisdk.BNaviModuleManager.getContext();
        r28 = com.baidu.navisdk.util.common.NetworkUtils.isNetworkAvailable(r28);
        if (r28 != 0) goto L_0x0028;
    L_0x0012:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 1;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getSDKError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
    L_0x0027:
        return r28;
    L_0x0028:
        r27 = r31.getUrl();
        if (r27 == 0) goto L_0x0034;
    L_0x002e:
        r28 = android.text.TextUtils.isEmpty(r27);
        if (r28 == 0) goto L_0x004a;
    L_0x0034:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 6;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x004a:
        r28 = 46;
        r18 = r27.lastIndexOf(r28);
        if (r18 < 0) goto L_0x005e;
    L_0x0052:
        r28 = r27.length();
        r28 = r28 + -1;
        r0 = r18;
        r1 = r28;
        if (r0 < r1) goto L_0x0074;
    L_0x005e:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 6;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x0074:
        r28 = r27.length();
        r0 = r27;
        r1 = r18;
        r2 = r28;
        r23 = r0.substring(r1, r2);
        r28 = android.text.TextUtils.isEmpty(r23);
        if (r28 == 0) goto L_0x009e;
    L_0x0088:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 6;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x009e:
        r19 = com.baidu.navisdk.util.common.MD5.toMD5(r27);
        r14 = r31.getSDCardFilePath();
        if (r14 == 0) goto L_0x00ae;
    L_0x00a8:
        r28 = android.text.TextUtils.isEmpty(r14);
        if (r28 == 0) goto L_0x00c5;
    L_0x00ae:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 21;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x00c5:
        r21 = r31.getFilePrefix();
        r28 = new java.lang.StringBuilder;
        r28.<init>();
        if (r21 == 0) goto L_0x00d6;
    L_0x00d0:
        r29 = android.text.TextUtils.isEmpty(r21);
        if (r29 == 0) goto L_0x00d9;
    L_0x00d6:
        r21 = "";
    L_0x00d9:
        r0 = r28;
        r1 = r21;
        r28 = r0.append(r1);
        r0 = r28;
        r1 = r19;
        r28 = r0.append(r1);
        r0 = r28;
        r1 = r23;
        r28 = r0.append(r1);
        r13 = r28.toString();
        r28 = new java.lang.StringBuilder;
        r28.<init>();
        r29 = r31.getSDCardFilePath();
        r28 = r28.append(r29);
        r29 = java.io.File.separator;
        r28 = r28.append(r29);
        r0 = r28;
        r28 = r0.append(r13);
        r15 = r28.toString();
        r28 = TAG;
        r29 = new java.lang.StringBuilder;
        r29.<init>();
        r30 = "filePathAll = ";
        r29 = r29.append(r30);
        r0 = r29;
        r29 = r0.append(r15);
        r29 = r29.toString();
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);
        r0 = r31;
        r0.responseAudioFilePath(r15);
        r24 = r31.getFileDownloadPos();
        r8 = r31.getFileSize();
        r28 = 0;
        r28 = (r24 > r28 ? 1 : (r24 == r28 ? 0 : -1));
        if (r28 >= 0) goto L_0x0157;
    L_0x0140:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 22;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x0157:
        r28 = 0;
        r28 = (r8 > r28 ? 1 : (r8 == r28 ? 0 : -1));
        if (r28 >= 0) goto L_0x0174;
    L_0x015d:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 22;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x0174:
        r28 = (r8 > r24 ? 1 : (r8 == r24 ? 0 : -1));
        if (r28 >= 0) goto L_0x018f;
    L_0x0178:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r29 = 22;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);
        r28.set(r29);
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x018f:
        r17 = 0;
        r11 = 0;
        r26 = new java.net.URL;	 Catch:{ Exception -> 0x0381 }
        r26.<init>(r27);	 Catch:{ Exception -> 0x0381 }
        r5 = r26.openConnection();	 Catch:{ Exception -> 0x0381 }
        r5 = (java.net.HttpURLConnection) r5;	 Catch:{ Exception -> 0x0381 }
        r28 = "GET";
        r0 = r28;
        r5.setRequestMethod(r0);	 Catch:{ Exception -> 0x0381 }
        r28 = 0;
        r28 = (r24 > r28 ? 1 : (r24 == r28 ? 0 : -1));
        if (r28 <= 0) goto L_0x01da;
    L_0x01ab:
        r28 = "Range";
        r29 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0381 }
        r29.<init>();	 Catch:{ Exception -> 0x0381 }
        r30 = "bytes=";
        r29 = r29.append(r30);	 Catch:{ Exception -> 0x0381 }
        r0 = r29;
        r1 = r24;
        r29 = r0.append(r1);	 Catch:{ Exception -> 0x0381 }
        r30 = "-";
        r29 = r29.append(r30);	 Catch:{ Exception -> 0x0381 }
        r0 = r29;
        r29 = r0.append(r8);	 Catch:{ Exception -> 0x0381 }
        r29 = r29.toString();	 Catch:{ Exception -> 0x0381 }
        r0 = r28;
        r1 = r29;
        r5.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x0381 }
    L_0x01da:
        r5.connect();	 Catch:{ Exception -> 0x0381 }
        r22 = r5.getResponseCode();	 Catch:{ Exception -> 0x0381 }
        r28 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r22;
        r1 = r28;
        if (r0 == r1) goto L_0x0215;
    L_0x01e9:
        r28 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r0 = r22;
        r1 = r28;
        if (r0 == r1) goto L_0x0215;
    L_0x01f1:
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0381 }
        r28 = r0;
        r29 = 5;
        r29 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r29);	 Catch:{ Exception -> 0x0381 }
        r28.set(r29);	 Catch:{ Exception -> 0x0381 }
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0381 }
        r28 = r0;
        if (r17 == 0) goto L_0x020d;
    L_0x0208:
        r17.close();	 Catch:{ Exception -> 0x0385 }
        r17 = 0;
    L_0x020d:
        if (r11 == 0) goto L_0x0027;
    L_0x020f:
        r11.close();	 Catch:{ Exception -> 0x0385 }
        r11 = 0;
        goto L_0x0027;
    L_0x0215:
        r16 = r5.getContentLength();	 Catch:{ Exception -> 0x0381 }
        if (r16 <= 0) goto L_0x0359;
    L_0x021b:
        r6 = new java.io.File;	 Catch:{ Exception -> 0x0381 }
        r6.<init>(r14);	 Catch:{ Exception -> 0x0381 }
        r28 = r6.exists();	 Catch:{ Exception -> 0x0381 }
        if (r28 != 0) goto L_0x0229;
    L_0x0226:
        r6.mkdirs();	 Catch:{ Exception -> 0x0381 }
    L_0x0229:
        r10 = new java.io.File;	 Catch:{ Exception -> 0x0381 }
        r10.<init>(r14, r13);	 Catch:{ Exception -> 0x0381 }
        r28 = TAG;	 Catch:{ Exception -> 0x0381 }
        r29 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0381 }
        r29.<init>();	 Catch:{ Exception -> 0x0381 }
        r30 = "filePath = ";
        r29 = r29.append(r30);	 Catch:{ Exception -> 0x0381 }
        r0 = r29;
        r29 = r0.append(r14);	 Catch:{ Exception -> 0x0381 }
        r30 = ", urlStr = ";
        r29 = r29.append(r30);	 Catch:{ Exception -> 0x0381 }
        r0 = r29;
        r1 = r27;
        r29 = r0.append(r1);	 Catch:{ Exception -> 0x0381 }
        r29 = r29.toString();	 Catch:{ Exception -> 0x0381 }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);	 Catch:{ Exception -> 0x0381 }
        r17 = r5.getInputStream();	 Catch:{ Exception -> 0x0381 }
        r28 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r28;
        r4 = new byte[r0];	 Catch:{ Exception -> 0x0381 }
        r20 = 0;
        r12 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0381 }
        r28 = "rwd";
        r0 = r28;
        r12.<init>(r10, r0);	 Catch:{ Exception -> 0x0381 }
        r0 = r24;
        r12.seek(r0);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
    L_0x0273:
        r28 = 0;
        r29 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r17;
        r1 = r28;
        r2 = r29;
        r20 = r0.read(r4, r1, r2);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = -1;
        r0 = r20;
        r1 = r28;
        if (r0 == r1) goto L_0x0343;
    L_0x0289:
        r28 = r31.isPauseStatus();	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        if (r28 == 0) goto L_0x02bb;
    L_0x028f:
        r28 = TAG;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r29 = "isPauseStatus";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = r0;
        r29 = -4;
        r28.set(r29);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = r0;
        if (r17 == 0) goto L_0x02af;
    L_0x02aa:
        r17.close();	 Catch:{ Exception -> 0x02b7 }
        r17 = 0;
    L_0x02af:
        if (r12 == 0) goto L_0x0388;
    L_0x02b1:
        r12.close();	 Catch:{ Exception -> 0x02b7 }
        r11 = 0;
        goto L_0x0027;
    L_0x02b7:
        r29 = move-exception;
        r11 = r12;
        goto L_0x0027;
    L_0x02bb:
        r28 = r31.isCancelStatus();	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        if (r28 == 0) goto L_0x02ed;
    L_0x02c1:
        r28 = TAG;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r29 = "isCancelStatus";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = r0;
        r29 = -3;
        r28.set(r29);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = r0;
        if (r17 == 0) goto L_0x02e1;
    L_0x02dc:
        r17.close();	 Catch:{ Exception -> 0x02e9 }
        r17 = 0;
    L_0x02e1:
        if (r12 == 0) goto L_0x0388;
    L_0x02e3:
        r12.close();	 Catch:{ Exception -> 0x02e9 }
        r11 = 0;
        goto L_0x0027;
    L_0x02e9:
        r29 = move-exception;
        r11 = r12;
        goto L_0x0027;
    L_0x02ed:
        r28 = 0;
        r0 = r28;
        r1 = r20;
        r12.write(r4, r0, r1);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r0 = r20;
        r0 = (long) r0;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = r0;
        r24 = r24 + r28;
        r0 = r31;
        r1 = r24;
        r0.responseFileDownloadPos(r1);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        goto L_0x0273;
    L_0x0306:
        r7 = move-exception;
        r11 = r12;
    L_0x0308:
        r28 = TAG;	 Catch:{ all -> 0x0367 }
        r29 = "requestFile catch start";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);	 Catch:{ all -> 0x0367 }
        r28 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE;	 Catch:{ all -> 0x0367 }
        if (r28 == 0) goto L_0x0317;
    L_0x0314:
        r7.printStackTrace();	 Catch:{ all -> 0x0367 }
    L_0x0317:
        r28 = TAG;	 Catch:{ all -> 0x0367 }
        r29 = "requestFile catch end";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);	 Catch:{ all -> 0x0367 }
        if (r17 == 0) goto L_0x0326;
    L_0x0321:
        r17.close();	 Catch:{ Exception -> 0x037f }
        r17 = 0;
    L_0x0326:
        if (r11 == 0) goto L_0x032c;
    L_0x0328:
        r11.close();	 Catch:{ Exception -> 0x037f }
        r11 = 0;
    L_0x032c:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        r28 = r28.isSuccess();
        if (r28 == 0) goto L_0x0376;
    L_0x0338:
        r31.handleSuccess();
    L_0x033b:
        r0 = r31;
        r0 = r0.mRet;
        r28 = r0;
        goto L_0x0027;
    L_0x0343:
        r28 = (r24 > r8 ? 1 : (r24 == r8 ? 0 : -1));
        if (r28 < 0) goto L_0x0358;
    L_0x0347:
        r28 = TAG;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r29 = "mRet.setSuccess()";
        com.baidu.navisdk.util.common.LogUtil.m15791e(r28, r29);	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r0 = r31;
        r0 = r0.mRet;	 Catch:{ Exception -> 0x0306, all -> 0x037c }
        r28 = r0;
        r28.setSuccess();	 Catch:{ Exception -> 0x0306, all -> 0x037c }
    L_0x0358:
        r11 = r12;
    L_0x0359:
        if (r17 == 0) goto L_0x0360;
    L_0x035b:
        r17.close();	 Catch:{ Exception -> 0x0383 }
        r17 = 0;
    L_0x0360:
        if (r11 == 0) goto L_0x032c;
    L_0x0362:
        r11.close();	 Catch:{ Exception -> 0x0383 }
        r11 = 0;
        goto L_0x032c;
    L_0x0367:
        r28 = move-exception;
    L_0x0368:
        if (r17 == 0) goto L_0x036f;
    L_0x036a:
        r17.close();	 Catch:{ Exception -> 0x037a }
        r17 = 0;
    L_0x036f:
        if (r11 == 0) goto L_0x0375;
    L_0x0371:
        r11.close();	 Catch:{ Exception -> 0x037a }
        r11 = 0;
    L_0x0375:
        throw r28;
    L_0x0376:
        r31.handleError();
        goto L_0x033b;
    L_0x037a:
        r29 = move-exception;
        goto L_0x0375;
    L_0x037c:
        r28 = move-exception;
        r11 = r12;
        goto L_0x0368;
    L_0x037f:
        r28 = move-exception;
        goto L_0x032c;
    L_0x0381:
        r7 = move-exception;
        goto L_0x0308;
    L_0x0383:
        r28 = move-exception;
        goto L_0x032c;
    L_0x0385:
        r29 = move-exception;
        goto L_0x0027;
    L_0x0388:
        r11 = r12;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestDataFunc.requestFile():com.baidu.navisdk.logic.CommandResult");
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent) {
            LogUtil.m15791e(TAG, "exec() handleSuccess");
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mJson);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void handleError() {
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = this.mRet.mErrCode;
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void parseJson() {
        if (this.mCallback != null) {
            this.mCallback.parseResponseJSON(this.mJson);
        }
    }

    protected String generateParams() {
        if (this.mCallback != null) {
            return formatNameValuePair(this.mCallback.getRequestParams());
        }
        return null;
    }

    protected List<NameValuePair> getRequestParams() {
        if (this.mCallback != null) {
            return this.mCallback.getRequestParams();
        }
        return null;
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mCallback = (Callback) sCallbackMaps.remove(reqdata);
    }
}
