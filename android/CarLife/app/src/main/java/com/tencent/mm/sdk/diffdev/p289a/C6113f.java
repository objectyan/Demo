package com.tencent.mm.sdk.diffdev.p289a;

import android.os.AsyncTask;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.OAuthErrCode;
import com.tencent.mm.sdk.diffdev.OAuthListener;

/* renamed from: com.tencent.mm.sdk.diffdev.a.f */
final class C6113f extends AsyncTask<Void, Void, C6112a> {
    private OAuthListener an;
    private String aq;
    private int aw;
    private String url;

    /* renamed from: com.tencent.mm.sdk.diffdev.a.f$a */
    static class C6112a {
        public OAuthErrCode ap;
        public String ax;
        public int ay;

        C6112a() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: e */
        public static com.tencent.mm.sdk.diffdev.p289a.C6113f.C6112a m21709e(byte[] r9) {
            /*
            r8 = 1;
            r7 = 0;
            r0 = new com.tencent.mm.sdk.diffdev.a.f$a;
            r0.<init>();
            if (r9 == 0) goto L_0x000c;
        L_0x0009:
            r1 = r9.length;
            if (r1 != 0) goto L_0x001a;
        L_0x000c:
            r1 = "MicroMsg.SDK.NoopingResult";
            r2 = "parse fail, buf is null";
            android.util.Log.e(r1, r2);
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            r0.ap = r1;
        L_0x0019:
            return r0;
        L_0x001a:
            r1 = new java.lang.String;	 Catch:{ Exception -> 0x006e }
            r2 = "utf-8";
            r1.<init>(r9, r2);	 Catch:{ Exception -> 0x006e }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0053 }
            r2.<init>(r1);	 Catch:{ Exception -> 0x0053 }
            r1 = "wx_errcode";
            r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0053 }
            r0.ay = r1;	 Catch:{ Exception -> 0x0053 }
            r1 = "MicroMsg.SDK.NoopingResult";
            r3 = "nooping uuidStatusCode = %d";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0053 }
            r5 = 0;
            r6 = r0.ay;	 Catch:{ Exception -> 0x0053 }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0053 }
            r4[r5] = r6;	 Catch:{ Exception -> 0x0053 }
            r3 = java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x0053 }
            android.util.Log.d(r1, r3);	 Catch:{ Exception -> 0x0053 }
            r1 = r0.ay;	 Catch:{ Exception -> 0x0053 }
            switch(r1) {
                case 402: goto L_0x00a3;
                case 403: goto L_0x00a9;
                case 404: goto L_0x0097;
                case 405: goto L_0x0089;
                case 408: goto L_0x009d;
                case 500: goto L_0x00af;
                default: goto L_0x004e;
            };	 Catch:{ Exception -> 0x0053 }
        L_0x004e:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x0053:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse json fail, ex = %s";
            r4 = new java.lang.Object[r8];
            r1 = r1.getMessage();
            r4[r7] = r1;
            r1 = java.lang.String.format(r3, r4);
            android.util.Log.e(r2, r1);
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.ap = r1;
            goto L_0x0019;
        L_0x006e:
            r1 = move-exception;
            r2 = "MicroMsg.SDK.NoopingResult";
            r3 = "parse fail, build String fail, ex = %s";
            r4 = new java.lang.Object[r8];
            r1 = r1.getMessage();
            r4[r7] = r1;
            r1 = java.lang.String.format(r3, r4);
            android.util.Log.e(r2, r1);
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
            r0.ap = r1;
            goto L_0x0019;
        L_0x0089:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            r1 = "wx_code";
            r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0053 }
            r0.ax = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x0097:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x009d:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x00a3:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x00a9:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
        L_0x00af:
            r1 = com.tencent.mm.sdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0053 }
            r0.ap = r1;	 Catch:{ Exception -> 0x0053 }
            goto L_0x0019;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.diffdev.a.f.a.e(byte[]):com.tencent.mm.sdk.diffdev.a.f$a");
        }
    }

    public C6113f(String str, OAuthListener oAuthListener) {
        this.aq = str;
        this.an = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (this.aq == null || this.aq.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            C6112a c6112a = new C6112a();
            c6112a.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
            return c6112a;
        }
        while (!isCancelled()) {
            String str = this.url + (this.aw == 0 ? "" : "&last=" + this.aw);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] b = C6111e.m21708b(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            c6112a = C6112a.m21709e(b);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{str, c6112a.ap.toString(), Integer.valueOf(c6112a.ay), Long.valueOf(currentTimeMillis2 - currentTimeMillis)}));
            if (c6112a.ap == OAuthErrCode.WechatAuth_Err_OK) {
                this.aw = c6112a.ay;
                if (c6112a.ay == C6114g.UUID_SCANED.getCode()) {
                    this.an.onQrcodeScanned();
                } else if (c6112a.ay != C6114g.UUID_KEEP_CONNECT.getCode() && c6112a.ay == C6114g.UUID_CONFIRM.getCode()) {
                    if (c6112a.ax != null && c6112a.ax.length() != 0) {
                        return c6112a;
                    }
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    c6112a.ap = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return c6112a;
                }
            }
            Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{c6112a.ap.toString(), Integer.valueOf(c6112a.ay)}));
            return c6112a;
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        c6112a = new C6112a();
        c6112a.ap = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return c6112a;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        C6112a c6112a = (C6112a) obj;
        this.an.onAuthFinish(c6112a.ap, c6112a.ax);
    }
}
