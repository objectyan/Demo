package com.baidu.navisdk.logic;

import android.os.Message;
import org.apache.http.entity.mime.MultipartEntity;
import org.json.JSONObject;

public abstract class HttpPostDataBase extends CommandBase {
    private static final int K_TIMEOUT_CONNECTION = 3000;
    private static final int K_TIMEOUT_SOCKET = 5000;
    private static final String TAG = "HttpPostFileBase";
    protected JSONObject mJson;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.baidu.navisdk.logic.CommandResult exec() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0016 in list [B:19:0x0094]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r13 = this;
        r11 = com.baidu.navisdk.BNaviModuleManager.getContext();
        r11 = com.baidu.navisdk.util.common.NetworkUtils.isNetworkAvailable(r11);
        if (r11 != 0) goto L_0x0017;
    L_0x000a:
        r11 = r13.mRet;
        r12 = 1;
        r12 = com.baidu.navisdk.logic.NaviErrCode.getSDKError(r12);
        r11.set(r12);
        r11 = r13.mRet;
    L_0x0016:
        return r11;
    L_0x0017:
        r3 = com.baidu.navisdk.util.common.HttpsClient.getHttpClient();
        r10 = r13.getUrl();
        r7 = r13.getMultipartEntity();
        r11 = com.baidu.navisdk.util.http.HttpRequestManager.getInstance();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r4 = r11.getHttpPost(r10);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r4.setEntity(r7);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r5 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r13.mReqData;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r0 = r11.mCookieStore;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r0 == 0) goto L_0x009e;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x0035:
        r11 = r0.getCookies();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r11 == 0) goto L_0x009e;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x003b:
        r6 = new org.apache.http.protocol.BasicHttpContext;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r6.<init>();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r0.getCookies();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r11 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x004b:
        r11 = r0.getCookies();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r11 instanceof org.apache.http.impl.cookie.BasicClientCookie;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r11 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x0058:
        r11 = r0.getCookies();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = (org.apache.http.impl.cookie.BasicClientCookie) r11;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = (org.apache.http.impl.cookie.BasicClientCookie) r11;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = r4.getURI();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = r12.getHost();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11.setDomain(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x0070:
        r11 = "http.cookie-store";	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r6.setAttribute(r11, r0);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r5 = r3.execute(r4, r6);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x007a:
        r11 = r5.getStatusLine();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r11.getStatusCode();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r11 == r12) goto L_0x00a3;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x0086:
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 5;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11.set(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r3 == 0) goto L_0x0016;
    L_0x0094:
        r12 = r3.getConnectionManager();
        r12.shutdown();
        r3 = 0;
        goto L_0x0016;
    L_0x009e:
        r5 = r3.execute(r4);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        goto L_0x007a;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x00a3:
        r2 = r5.getEntity();	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r2 == 0) goto L_0x00bd;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x00a9:
        r9 = org.apache.http.util.EntityUtils.toString(r2);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r11 == 0) goto L_0x00d9;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x00b3:
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 4;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11.set(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
    L_0x00bd:
        if (r3 == 0) goto L_0x00c7;
    L_0x00bf:
        r11 = r3.getConnectionManager();
        r11.shutdown();
        r3 = 0;
    L_0x00c7:
        r13.parseJson();
        r11 = r13.mRet;
        r11 = r11.isSuccess();
        if (r11 == 0) goto L_0x012d;
    L_0x00d2:
        r13.handleSuccess();
    L_0x00d5:
        r11 = r13.mRet;
        goto L_0x0016;
    L_0x00d9:
        r8 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00e6 }
        r8.<init>(r9);	 Catch:{ JSONException -> 0x00e6 }
        r13.mJson = r8;	 Catch:{ JSONException -> 0x00e6 }
        r11 = r13.mRet;	 Catch:{ JSONException -> 0x00e6 }
        r11.setSuccess();	 Catch:{ JSONException -> 0x00e6 }
        goto L_0x00bd;
    L_0x00e6:
        r1 = move-exception;
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 3;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11.set(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r3 == 0) goto L_0x0016;
    L_0x00f5:
        r12 = r3.getConnectionManager();
        r12.shutdown();
        r3 = 0;
        goto L_0x0016;
    L_0x00ff:
        r1 = move-exception;
        r11 = "HttpPostFileBase";	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = "HttpPostDataBase exec exception";	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        com.baidu.navisdk.util.common.LogUtil.m15791e(r11, r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = 0;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r12 = com.baidu.navisdk.logic.NaviErrCode.getAppError(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11.set(r12);	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        r11 = r13.mRet;	 Catch:{ Exception -> 0x00ff, all -> 0x0121 }
        if (r3 == 0) goto L_0x0016;
    L_0x0117:
        r12 = r3.getConnectionManager();
        r12.shutdown();
        r3 = 0;
        goto L_0x0016;
    L_0x0121:
        r11 = move-exception;
        if (r3 == 0) goto L_0x012c;
    L_0x0124:
        r12 = r3.getConnectionManager();
        r12.shutdown();
        r3 = 0;
    L_0x012c:
        throw r11;
    L_0x012d:
        r13.handleError();
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.logic.HttpPostDataBase.exec():com.baidu.navisdk.logic.CommandResult");
    }

    protected abstract MultipartEntity getMultipartEntity();

    protected abstract String getUrl();

    protected void parseJson() {
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent && this.mReqData.mRetryTimes == 1) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mJson);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }
}
