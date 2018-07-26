package com.baidu.speech.core;

import android.net.http.Headers;
import android.os.Build.VERSION;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey.OfflineMapKey;
import com.baidu.speech.utils.AsrError;
import com.baidu.speech.utils.CommonParam;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public class BDSHttpRequestMaker {
    private static final String BACKUP_URL_NORTH = "119.75.222.172";
    private static final String BACKUP_URL_SOUTH = "182.61.62.25";
    private static final int CONNECTION_TIMEOUT = 3;
    private static final Boolean DEBUG = Boolean.valueOf(true);
    static final HostnameVerifier DO_NOT_VERIFY = new C49461();
    private static final String TAG = "BDSHttpRequestMaker";
    private static final int TIMEOUT_DURATION = 10;
    private static final int TYPE_DOWNLOAD_FINAL = 241;
    private static final int TYPE_DOWNLOAD_FINISH = 243;
    private static final int TYPE_DOWNLOAD_HEART_BEAT = 244;
    private static final int TYPE_DOWNLOAD_PARTIAL = 240;
    private static final int TYPE_DOWNLOAD_THIRD_DATA = 242;
    private static final int TYPE_UPLOAD_AUDIO = 1;
    private static final int TYPE_UPLOAD_CANCEL = 4;
    private static final int TYPE_UPLOAD_FINISH = 3;
    private static final int TYPE_UPLOAD_HEART_BEAT = 9;
    private static final int TYPE_UPLOAD_PARAM = 0;
    private static final int TYPE_UPLOAD_THIRD_DATA = 2;
    private static SSLSocketFactory defaultSslFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
    private static HostnameVerifier defaulthostVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    private static String mHostIp = "";
    private static SSLContext sSSLContext = null;
    private final int CONNECTION_STATUS_CLOSE = 2;
    private final int CONNECTION_STATUS_INIT = 0;
    private final int CONNECTION_STATUS_WORKING = 1;
    private boolean mAgentDownload = false;
    private boolean mAgentUpload = false;
    private HttpURLConnection mDownloadConnection = null;
    private int mDownloadConnectionStatus = 0;
    private DataInputStream mDownloadInputStream = null;
    private ArrayList<BDSHTTPResponse> mErrorArray = new ArrayList();
    private String mNorthDownUrl;
    private String mNorthUpUrl;
    private boolean mRetriedNorth = true;
    private boolean mRetriedSouth = true;
    private String mSouthDownUrl;
    private String mSouthUpUrl;
    private int mUploadConnctionStatus = 0;
    private HttpURLConnection mUploadConnection = null;
    private OutputStream mUploadOutputStream = null;
    private MyUploadThread mUploadThread = new MyUploadThread();
    private ScheduledExecutorService mUploadThreadService = Executors.newSingleThreadScheduledExecutor();
    private boolean mUploadedData = false;

    /* renamed from: com.baidu.speech.core.BDSHttpRequestMaker$1 */
    static class C49461 implements HostnameVerifier {
        C49461() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            String access$100 = BDSHttpRequestMaker.convertHostname(str);
            if (Log.isLoggable(BDSHttpRequestMaker.TAG, 3) || BDSHttpRequestMaker.DEBUG.booleanValue()) {
                Log.d(BDSHttpRequestMaker.TAG, "hostname : " + str + " verifyUrl : " + access$100);
            }
            return access$100.equals("vse.baidu.com") || access$100.equals("vop.baidu.com") || access$100.equals("openapi.baidu.com") || access$100.equals("audiotest.baidu.com") || access$100.equals(BDSHttpRequestMaker.BACKUP_URL_NORTH) || access$100.equals(BDSHttpRequestMaker.BACKUP_URL_SOUTH) || access$100.equals("httpsdns.baidu.com") || access$100.contains(".baidu.");
        }
    }

    private class AudioData {
        public byte[] mData;
        public boolean mIsLast;
        public int mType;

        public AudioData(int i, byte[] bArr, boolean z) {
            this.mType = i;
            this.mIsLast = z;
            Object obj = new byte[]{(byte) (r0 & 255), (byte) ((r0 >> 8) & 255), (byte) ((r0 >> 16) & 255), (byte) ((bArr.length + 1) >> 24)};
            Object obj2 = new byte[]{(byte) i};
            this.mData = new byte[((bArr.length + 1) + 4)];
            System.arraycopy(obj, 0, this.mData, 0, 4);
            System.arraycopy(obj2, 0, this.mData, 4, 1);
            System.arraycopy(bArr, 0, this.mData, 5, bArr.length);
            if (Log.isLoggable(BDSHttpRequestMaker.TAG, 3) || BDSHttpRequestMaker.DEBUG.booleanValue()) {
                Log.i(BDSHttpRequestMaker.TAG, "AudioData : mType = " + this.mType + " | mIsLast = " + this.mIsLast + " | mData = " + this.mData.length);
            }
        }
    }

    private class MyDownloadThread extends Thread {
        private MyDownloadThread() {
        }

        public void run() {
        }
    }

    private class MyUploadThread extends Thread {
        AudioData ad;

        private MyUploadThread() {
            this.ad = new AudioData(9, new byte[0], true);
        }

        public void run() {
            BDSHttpRequestMaker.this.sendData(this.ad.mData, false);
        }
    }

    private static String convertHostname(String str) {
        return (str.equals("vse.baidu.com") || str.equals("vop.baidu.com") || str.equals("openapi.baidu.com") || !str.equals(mHostIp)) ? str : CommonParam.REQUEST_URL;
    }

    private void generateBackupUrls(String str, int i) {
        if (1 == i) {
            this.mNorthUpUrl = str.replace(mHostIp, BACKUP_URL_NORTH);
            this.mSouthUpUrl = str.replace(mHostIp, BACKUP_URL_SOUTH);
        } else if (2 == i) {
            this.mNorthDownUrl = str.replace(mHostIp, BACKUP_URL_NORTH);
            this.mSouthDownUrl = str.replace(mHostIp, BACKUP_URL_SOUTH);
        }
    }

    public static BDSHttpRequestMaker newRequestMaker() {
        if (sSSLContext == null) {
            try {
                sSSLContext = SSLContext.getInstance("TLS");
                sSSLContext.init(null, null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new BDSHttpRequestMaker();
    }

    private Proxy setAgent() {
        String str = CommonParam.AGENT_URL;
        if (str != "") {
            try {
                URL url = new URL(str);
                Log.e(TAG, "ip: " + InetAddress.getByName(url.getHost()).getHostAddress() + " port: " + url.getPort());
                return new Proxy(Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void cancelRequest() {
        Log.i(TAG, "cancelRequest");
        try {
            this.mAgentDownload = false;
            this.mAgentUpload = false;
            if (this.mUploadConnection != null) {
                this.mUploadConnection.disconnect();
                this.mUploadConnection = null;
            }
            if (this.mDownloadConnection != null) {
                this.mDownloadConnection.disconnect();
                this.mDownloadConnection = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "BDSHttpRequestMaker cancelRequest exception");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.speech.core.BDSHTTPResponse makeRequest(java.lang.String r20, byte[] r21, java.lang.String[] r22, float r23, int r24) {
        /*
        r19 = this;
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x0078 }
        r0 = r20;
        r2.<init>(r0);	 Catch:{ Exception -> 0x0078 }
        r2 = r2.getHost();	 Catch:{ Exception -> 0x0078 }
        mHostIp = r2;	 Catch:{ Exception -> 0x0078 }
    L_0x000d:
        r2 = 0;
        r9 = new com.baidu.speech.core.BDSHTTPResponse;
        r9.<init>();
        r10 = java.lang.System.currentTimeMillis();
        r5 = r2;
    L_0x0018:
        r2 = "BDSHttpRequestMaker";
        r3 = 3;
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 != 0) goto L_0x002a;
    L_0x0022:
        r2 = DEBUG;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x0046;
    L_0x002a:
        r2 = "BDSHttpRequestMaker";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Begin request, url is ";
        r3 = r3.append(r4);
        r0 = r20;
        r3 = r3.append(r0);
        r3 = r3.toString();
        android.util.Log.d(r2, r3);
    L_0x0046:
        r3 = 0;
        r6 = 0;
        r4 = 0;
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r12 = r12 - r10;
        r14 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r2 <= 0) goto L_0x007d;
    L_0x0054:
        r2 = new java.net.SocketTimeoutException;	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        throw r2;	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
    L_0x005a:
        r2 = move-exception;
        r5 = r3;
        r3 = r4;
        r4 = r6;
    L_0x005e:
        r2.printStackTrace();	 Catch:{ all -> 0x0397 }
        r2 = 2005; // 0x7d5 float:2.81E-42 double:9.906E-321;
        r9.m_http_status = r2;	 Catch:{ all -> 0x0397 }
        r2 = 0;
        r9.m_request_status = r2;	 Catch:{ all -> 0x0397 }
        if (r5 == 0) goto L_0x006d;
    L_0x006a:
        r5.disconnect();
    L_0x006d:
        if (r4 == 0) goto L_0x0072;
    L_0x006f:
        r4.close();	 Catch:{ IOException -> 0x0347 }
    L_0x0072:
        if (r3 == 0) goto L_0x0077;
    L_0x0074:
        r3.close();	 Catch:{ IOException -> 0x034d }
    L_0x0077:
        return r9;
    L_0x0078:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x000d;
    L_0x007d:
        r2 = new java.net.URL;	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r0 = r20;
        r2.<init>(r0);	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r2 = r2.openConnection();	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ SocketTimeoutException -> 0x005a, IOException -> 0x03b6, Exception -> 0x039e, all -> 0x032a }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = r2 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        if (r3 == 0) goto L_0x009f;
    L_0x0096:
        r0 = r2;
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = r0;
        r7 = DO_NOT_VERIFY;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3.setHostnameVerifier(r7);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
    L_0x009f:
        r3 = 0;
    L_0x00a0:
        if (r22 == 0) goto L_0x00b5;
    L_0x00a2:
        r0 = r22;
        r7 = r0.length;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r7 = r7 + -1;
        if (r3 >= r7) goto L_0x00b5;
    L_0x00a9:
        r7 = r22[r3];	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r8 = r3 + 1;
        r8 = r22[r8];	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r2.setRequestProperty(r7, r8);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = r3 + 2;
        goto L_0x00a0;
    L_0x00b5:
        r3 = 1;
        r2.setDoInput(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = 1;
        r0 = r24;
        if (r0 != r3) goto L_0x012a;
    L_0x00be:
        if (r21 == 0) goto L_0x012a;
    L_0x00c0:
        r3 = 1;
        r2.setDoOutput(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r0 = r21;
        r3 = r0.length;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r2.setFixedLengthStreamingMode(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2.setReadTimeout(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r2.setConnectTimeout(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = 1;
        r3 = new java.net.URLConnection[r3];	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r7 = 0;
        r3[r7] = r2;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r7 = java.util.concurrent.Executors.newSingleThreadExecutor();	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r8 = new com.baidu.speech.core.BDSHttpRequestMaker$2;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r0 = r19;
        r8.<init>(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = r7.submit(r8);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r16 = 10;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r0 = r16;
        r3.get(r0, r7);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = new java.io.BufferedOutputStream;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r7 = r2.getOutputStream();	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3.<init>(r7);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r0 = r21;
        r3.write(r0);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3.close();	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
    L_0x0103:
        r3 = r2.getInputStream();	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r7 = new java.io.BufferedInputStream;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r7.<init>(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r6 = new java.io.ByteArrayOutputStream;	 Catch:{ SocketTimeoutException -> 0x03ce, IOException -> 0x03c5, Exception -> 0x03ad, all -> 0x0388 }
        r6.<init>();	 Catch:{ SocketTimeoutException -> 0x03ce, IOException -> 0x03c5, Exception -> 0x03ad, all -> 0x0388 }
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r3 = new byte[r3];	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
    L_0x0115:
        r4 = 0;
        r8 = r3.length;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = r7.read(r3, r4, r8);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = -1;
        if (r4 == r8) goto L_0x0142;
    L_0x011e:
        r8 = 0;
        r6.write(r3, r8, r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        goto L_0x0115;
    L_0x0123:
        r3 = move-exception;
        r4 = r7;
        r5 = r2;
        r2 = r3;
        r3 = r6;
        goto L_0x005e;
    L_0x012a:
        r3 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r3 = r3 * r23;
        r3 = (int) r3;
        r2.setConnectTimeout(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r3 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r3 = r3 * r23;
        r3 = (int) r3;	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        r2.setReadTimeout(r3);	 Catch:{ SocketTimeoutException -> 0x013b, IOException -> 0x03bb, Exception -> 0x03a3, all -> 0x037f }
        goto L_0x0103;
    L_0x013b:
        r3 = move-exception;
        r5 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r6;
        goto L_0x005e;
    L_0x0142:
        r6.flush();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3.<init>();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = "End request from java: url: ";
        r3 = r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3.toString();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        com.baidu.speech.core.LogUtil.log_d(r3);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3.<init>();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = "http url: ";
        r3 = r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r0 = r20;
        r3 = r3.append(r0);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3.toString();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        com.baidu.speech.core.LogUtil.log_d(r3);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r6.toByteArray();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r9.m_response_data = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r2.getResponseCode();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r9.m_http_status = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = 0;
        r9.m_request_status = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3.<init>();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = "connect_time=";
        r3 = r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r12 = r14 - r12;
        r3 = r3.append(r12);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = "&request-response_time=";
        r3 = r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r12 = r16 - r14;
        r3 = r3.append(r12);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3.toString();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r9.m_log = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = "BDSHttpRequestMaker";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        if (r3 != 0) goto L_0x01c1;
    L_0x01b9:
        r3 = DEBUG;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3.booleanValue();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        if (r3 == 0) goto L_0x01ef;
    L_0x01c1:
        r3 = "BDSHttpRequestMaker";
        r4 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4.<init>();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = "Receive response, data: ";
        r4 = r4.append(r8);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = new java.lang.String;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r12 = r9.m_response_data;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8.<init>(r12);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = r4.append(r8);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = " httpStatus: ";
        r4 = r4.append(r8);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = r9.m_http_status;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = r4.append(r8);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = r4.toString();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        android.util.Log.d(r3, r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
    L_0x01ef:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x0295, SocketTimeoutException -> 0x0123, IOException -> 0x0269, all -> 0x0390 }
        r4 = r9.m_response_data;	 Catch:{ Exception -> 0x0295, SocketTimeoutException -> 0x0123, IOException -> 0x0269, all -> 0x0390 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0295, SocketTimeoutException -> 0x0123, IOException -> 0x0269, all -> 0x0390 }
        r4 = "license_begin";
        r4 = r3.startsWith(r4);	 Catch:{ Exception -> 0x0295, SocketTimeoutException -> 0x0123, IOException -> 0x0269, all -> 0x0390 }
        if (r4 != 0) goto L_0x0204;
    L_0x01ff:
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0295, SocketTimeoutException -> 0x0123, IOException -> 0x0269, all -> 0x0390 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0295, SocketTimeoutException -> 0x0123, IOException -> 0x0269, all -> 0x0390 }
    L_0x0204:
        r4 = r2.getHeaderFields();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r4.entrySet();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3.size();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        if (r3 <= 0) goto L_0x0366;
    L_0x0212:
        r3 = r4.entrySet();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3.size();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = r3 * 2;
        r3 = new java.lang.String[r3];	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r9.m_response_headers = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = 0;
        r4 = r4.entrySet();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r12 = r4.iterator();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = r3;
    L_0x022a:
        r3 = r12.hasNext();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        if (r3 == 0) goto L_0x0366;
    L_0x0230:
        r3 = r12.next();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r13 = r9.m_response_headers;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r14 = r8 + 1;
        r4 = r3.getKey();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        if (r4 == 0) goto L_0x02e6;
    L_0x0240:
        r4 = r3.getKey();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = (java.lang.String) r4;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
    L_0x0246:
        r13[r8] = r4;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r13 = r9.m_response_headers;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r8 = r14 + 1;
        r4 = r3.getValue();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = (java.util.List) r4;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r15 = 0;
        r4 = r4.get(r15);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        if (r4 == 0) goto L_0x02eb;
    L_0x0259:
        r3 = r3.getValue();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = (java.util.List) r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r4 = 0;
        r3 = r3.get(r4);	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = (java.lang.String) r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
    L_0x0266:
        r13[r14] = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        goto L_0x022a;
    L_0x0269:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
    L_0x026f:
        r2.printStackTrace();	 Catch:{ all -> 0x039c }
        r4 = 30;
        if (r5 >= r4) goto L_0x02f0;
    L_0x0276:
        r2 = "EOF Exception from http connection, trying again...";
        com.baidu.speech.core.LogUtil.log_d(r2);	 Catch:{ all -> 0x039c }
        r2 = r5 + 1;
        if (r3 == 0) goto L_0x0283;
    L_0x0280:
        r3.disconnect();	 Catch:{ all -> 0x039c }
    L_0x0283:
        if (r3 == 0) goto L_0x0288;
    L_0x0285:
        r3.disconnect();
    L_0x0288:
        if (r7 == 0) goto L_0x028d;
    L_0x028a:
        r7.close();	 Catch:{ IOException -> 0x034f }
    L_0x028d:
        if (r6 == 0) goto L_0x0292;
    L_0x028f:
        r6.close();	 Catch:{ IOException -> 0x0355 }
    L_0x0292:
        r5 = r2;
        goto L_0x0018;
    L_0x0295:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = 2006; // 0x7d6 float:2.811E-42 double:9.91E-321;
        r9.m_http_status = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = 0;
        r9.m_response_data = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        r3 = 0;
        r9.m_request_status = r3;	 Catch:{ SocketTimeoutException -> 0x0123, IOException -> 0x0269, Exception -> 0x02a5, all -> 0x0390 }
        goto L_0x0204;
    L_0x02a5:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
    L_0x02ab:
        r2.printStackTrace();	 Catch:{ all -> 0x039c }
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r9.m_http_status = r4;	 Catch:{ all -> 0x039c }
        r4 = 2;
        r9.m_request_status = r4;	 Catch:{ all -> 0x039c }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x039c }
        r4.<init>();	 Catch:{ all -> 0x039c }
        r5 = "error_msg=";
        r4 = r4.append(r5);	 Catch:{ all -> 0x039c }
        r2 = r2.getMessage();	 Catch:{ all -> 0x039c }
        r2 = r4.append(r2);	 Catch:{ all -> 0x039c }
        r2 = r2.toString();	 Catch:{ all -> 0x039c }
        r9.m_log = r2;	 Catch:{ all -> 0x039c }
        if (r3 == 0) goto L_0x02d4;
    L_0x02d1:
        r3.disconnect();
    L_0x02d4:
        if (r7 == 0) goto L_0x02d9;
    L_0x02d6:
        r7.close();	 Catch:{ IOException -> 0x0360 }
    L_0x02d9:
        if (r6 == 0) goto L_0x0077;
    L_0x02db:
        r6.close();	 Catch:{ IOException -> 0x02e0 }
        goto L_0x0077;
    L_0x02e0:
        r2 = move-exception;
    L_0x02e1:
        r2.printStackTrace();
        goto L_0x0077;
    L_0x02e6:
        r4 = "";
        goto L_0x0246;
    L_0x02eb:
        r3 = "";
        goto L_0x0266;
    L_0x02f0:
        r4 = "EOF Exception from http connection giving up...";
        com.baidu.speech.core.LogUtil.log_d(r4);	 Catch:{ all -> 0x039c }
        r4 = 2;
        r9.m_request_status = r4;	 Catch:{ all -> 0x039c }
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r9.m_http_status = r4;	 Catch:{ all -> 0x039c }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x039c }
        r4.<init>();	 Catch:{ all -> 0x039c }
        r5 = "error_msg=";
        r4 = r4.append(r5);	 Catch:{ all -> 0x039c }
        r2 = r2.getMessage();	 Catch:{ all -> 0x039c }
        r2 = r4.append(r2);	 Catch:{ all -> 0x039c }
        r2 = r2.toString();	 Catch:{ all -> 0x039c }
        r9.m_log = r2;	 Catch:{ all -> 0x039c }
        if (r3 == 0) goto L_0x031c;
    L_0x0319:
        r3.disconnect();
    L_0x031c:
        if (r7 == 0) goto L_0x0321;
    L_0x031e:
        r7.close();	 Catch:{ IOException -> 0x035b }
    L_0x0321:
        if (r6 == 0) goto L_0x0077;
    L_0x0323:
        r6.close();	 Catch:{ IOException -> 0x0328 }
        goto L_0x0077;
    L_0x0328:
        r2 = move-exception;
        goto L_0x02e1;
    L_0x032a:
        r2 = move-exception;
        r7 = r6;
        r6 = r4;
    L_0x032d:
        if (r3 == 0) goto L_0x0332;
    L_0x032f:
        r3.disconnect();
    L_0x0332:
        if (r7 == 0) goto L_0x0337;
    L_0x0334:
        r7.close();	 Catch:{ IOException -> 0x033d }
    L_0x0337:
        if (r6 == 0) goto L_0x033c;
    L_0x0339:
        r6.close();	 Catch:{ IOException -> 0x0342 }
    L_0x033c:
        throw r2;
    L_0x033d:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0337;
    L_0x0342:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x033c;
    L_0x0347:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0072;
    L_0x034d:
        r2 = move-exception;
        goto L_0x02e1;
    L_0x034f:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x028d;
    L_0x0355:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0292;
    L_0x035b:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0321;
    L_0x0360:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x02d9;
    L_0x0366:
        if (r2 == 0) goto L_0x036b;
    L_0x0368:
        r2.disconnect();
    L_0x036b:
        if (r7 == 0) goto L_0x0370;
    L_0x036d:
        r7.close();	 Catch:{ IOException -> 0x037a }
    L_0x0370:
        if (r6 == 0) goto L_0x0077;
    L_0x0372:
        r6.close();	 Catch:{ IOException -> 0x0377 }
        goto L_0x0077;
    L_0x0377:
        r2 = move-exception;
        goto L_0x02e1;
    L_0x037a:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0370;
    L_0x037f:
        r3 = move-exception;
        r7 = r6;
        r6 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x032d;
    L_0x0388:
        r3 = move-exception;
        r6 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x032d;
    L_0x0390:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x032d;
    L_0x0397:
        r2 = move-exception;
        r6 = r3;
        r7 = r4;
        r3 = r5;
        goto L_0x032d;
    L_0x039c:
        r2 = move-exception;
        goto L_0x032d;
    L_0x039e:
        r2 = move-exception;
        r7 = r6;
        r6 = r4;
        goto L_0x02ab;
    L_0x03a3:
        r3 = move-exception;
        r7 = r6;
        r6 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x02ab;
    L_0x03ad:
        r3 = move-exception;
        r6 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x02ab;
    L_0x03b6:
        r2 = move-exception;
        r7 = r6;
        r6 = r4;
        goto L_0x026f;
    L_0x03bb:
        r3 = move-exception;
        r7 = r6;
        r6 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x026f;
    L_0x03c5:
        r3 = move-exception;
        r6 = r4;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x026f;
    L_0x03ce:
        r3 = move-exception;
        r5 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r7;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.speech.core.BDSHttpRequestMaker.makeRequest(java.lang.String, byte[], java.lang.String[], float, int):com.baidu.speech.core.BDSHTTPResponse");
    }

    public BDSHTTPResponse readData() {
        BDSHTTPResponse bDSHTTPResponse;
        Exception e;
        if (this.mDownloadConnectionStatus == 2) {
            Log.w(TAG, "Download connection stauts has already been closed.");
            return null;
        } else if (this.mErrorArray.size() > 0) {
            r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
            this.mErrorArray.clear();
            return r0;
        } else {
            try {
                if (this.mDownloadInputStream == null) {
                    this.mDownloadInputStream = new DataInputStream(this.mDownloadConnection.getInputStream());
                }
                Object obj = new byte[4];
                this.mDownloadInputStream.readFully(obj, 0, 4);
                int i = (obj[3] << 24) | (((obj[0] & 255) | ((obj[1] << 8) & 65280)) | ((obj[2] << 24) >>> 8));
                byte readByte = this.mDownloadInputStream.readByte();
                int i2 = readByte & 255;
                if (TYPE_DOWNLOAD_FINISH == i2) {
                    this.mUploadConnctionStatus = 2;
                    this.mDownloadConnectionStatus = 2;
                }
                if (Log.isLoggable(TAG, 3) || DEBUG.booleanValue()) {
                    Log.i(TAG, "readData dataType : " + i2);
                }
                if (i <= 1) {
                    Object obj2 = new byte[5];
                    System.arraycopy(obj, 0, obj2, 0, 4);
                    obj2[4] = readByte;
                    r0 = new BDSHTTPResponse();
                    r0.m_http_status = 200;
                    r0.m_response_data = obj2;
                    r0.m_request_status = 0;
                    if (this.mErrorArray.size() <= 0) {
                        return r0;
                    }
                    r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                    this.mErrorArray.clear();
                    return r0;
                } else if (i > 67584) {
                    r0 = new BDSHTTPResponse();
                    r0.m_http_status = 2006;
                    r0.m_response_data = null;
                    r0.m_request_status = 0;
                    this.mErrorArray.add(r0);
                    return r0;
                } else {
                    Object obj3 = new byte[(i - 1)];
                    i2 = 0;
                    while (i2 < i - 1) {
                        i2 += this.mDownloadInputStream.read(obj3, i2, (i - 1) - i2);
                    }
                    String str = new String(obj3);
                    if (Log.isLoggable(TAG, 3) || DEBUG.booleanValue()) {
                        Log.i(TAG, "response : " + str);
                    }
                    Object obj4 = new byte[(i + 4)];
                    System.arraycopy(obj, 0, obj4, 0, 4);
                    obj4[4] = readByte;
                    if (i - 1 > 0) {
                        System.arraycopy(obj3, 0, obj4, 5, i - 1);
                    }
                    r0 = new BDSHTTPResponse();
                    try {
                        r0.m_http_status = 200;
                        r0.m_response_data = obj4;
                        r0.m_request_status = 0;
                    } catch (SocketTimeoutException e2) {
                        bDSHTTPResponse = new BDSHTTPResponse();
                        if (this.mAgentDownload) {
                            bDSHTTPResponse.m_http_status = AsrError.ERROR_NETWORK_FAIL_AGENT_READ_DOWN;
                        } else {
                            bDSHTTPResponse.m_http_status = 2005;
                        }
                        bDSHTTPResponse.m_response_data = null;
                        bDSHTTPResponse.m_request_status = 0;
                        this.mAgentDownload = false;
                        this.mErrorArray.add(bDSHTTPResponse);
                        if (this.mErrorArray.size() <= 0) {
                            return r0;
                        }
                        r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                        this.mErrorArray.clear();
                        return r0;
                    } catch (SSLException e3) {
                        bDSHTTPResponse = new BDSHTTPResponse();
                        Log.i(TAG, "SSLException");
                        bDSHTTPResponse.m_http_status = 2100;
                        bDSHTTPResponse.m_response_data = null;
                        bDSHTTPResponse.m_request_status = 0;
                        this.mErrorArray.add(bDSHTTPResponse);
                        if (this.mErrorArray.size() <= 0) {
                            return r0;
                        }
                        r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                        this.mErrorArray.clear();
                        return r0;
                    } catch (Exception e4) {
                        e = e4;
                        Log.i(TAG, "Exception");
                        e.printStackTrace();
                        bDSHTTPResponse = new BDSHTTPResponse();
                        bDSHTTPResponse.m_http_status = 2100;
                        bDSHTTPResponse.m_response_data = null;
                        bDSHTTPResponse.m_request_status = 0;
                        this.mErrorArray.add(bDSHTTPResponse);
                        if (this.mErrorArray.size() <= 0) {
                            return r0;
                        }
                        r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                        this.mErrorArray.clear();
                        return r0;
                    }
                    if (this.mErrorArray.size() <= 0) {
                        return r0;
                    }
                    r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                    this.mErrorArray.clear();
                    return r0;
                }
            } catch (SocketTimeoutException e5) {
                r0 = null;
                bDSHTTPResponse = new BDSHTTPResponse();
                if (this.mAgentDownload) {
                    bDSHTTPResponse.m_http_status = AsrError.ERROR_NETWORK_FAIL_AGENT_READ_DOWN;
                } else {
                    bDSHTTPResponse.m_http_status = 2005;
                }
                bDSHTTPResponse.m_response_data = null;
                bDSHTTPResponse.m_request_status = 0;
                this.mAgentDownload = false;
                this.mErrorArray.add(bDSHTTPResponse);
                if (this.mErrorArray.size() <= 0) {
                    return r0;
                }
                r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                this.mErrorArray.clear();
                return r0;
            } catch (SSLException e6) {
                r0 = null;
                bDSHTTPResponse = new BDSHTTPResponse();
                Log.i(TAG, "SSLException");
                bDSHTTPResponse.m_http_status = 2100;
                bDSHTTPResponse.m_response_data = null;
                bDSHTTPResponse.m_request_status = 0;
                this.mErrorArray.add(bDSHTTPResponse);
                if (this.mErrorArray.size() <= 0) {
                    return r0;
                }
                r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                this.mErrorArray.clear();
                return r0;
            } catch (Exception e7) {
                e = e7;
                r0 = null;
                Log.i(TAG, "Exception");
                e.printStackTrace();
                bDSHTTPResponse = new BDSHTTPResponse();
                bDSHTTPResponse.m_http_status = 2100;
                bDSHTTPResponse.m_response_data = null;
                bDSHTTPResponse.m_request_status = 0;
                this.mErrorArray.add(bDSHTTPResponse);
                if (this.mErrorArray.size() <= 0) {
                    return r0;
                }
                r0 = (BDSHTTPResponse) this.mErrorArray.get(0);
                this.mErrorArray.clear();
                return r0;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int sendData(byte[] r7, boolean r8) {
        /*
        r6 = this;
        r1 = -1;
        r0 = 0;
        monitor-enter(r6);
        r2 = r6.mUploadConnctionStatus;	 Catch:{ all -> 0x0081 }
        r3 = 2;
        if (r2 != r3) goto L_0x0013;
    L_0x0008:
        r1 = "BDSHttpRequestMaker";
        r2 = "Upload connection stauts has already been closed.";
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x0081 }
        monitor-exit(r6);	 Catch:{ all -> 0x0081 }
    L_0x0012:
        return r0;
    L_0x0013:
        r2 = 4;
        r2 = r7[r2];	 Catch:{ all -> 0x0081 }
        r2 = r2 & 255;
        r3 = "BDSHttpRequestMaker";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ all -> 0x0081 }
        if (r3 != 0) goto L_0x002a;
    L_0x0022:
        r3 = DEBUG;	 Catch:{ all -> 0x0081 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0081 }
        if (r3 == 0) goto L_0x0044;
    L_0x002a:
        r3 = "BDSHttpRequestMaker";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r4.<init>();	 Catch:{ all -> 0x0081 }
        r5 = "sendData  dataType : ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0081 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0081 }
        r2 = r2.toString();	 Catch:{ all -> 0x0081 }
        android.util.Log.i(r3, r2);	 Catch:{ all -> 0x0081 }
    L_0x0044:
        r2 = r6.mUploadConnection;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        if (r2 != 0) goto L_0x0054;
    L_0x0048:
        r2 = "BDSHttpRequestMaker";
        r3 = "Upload conncetion not exist";
        android.util.Log.e(r2, r3);	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        monitor-exit(r6);	 Catch:{ all -> 0x0081 }
        r0 = r1;
        goto L_0x0012;
    L_0x0054:
        r2 = r6.mUploadOutputStream;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        if (r2 != 0) goto L_0x0060;
    L_0x0058:
        r2 = r6.mUploadConnection;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2 = r2.getOutputStream();	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r6.mUploadOutputStream = r2;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
    L_0x0060:
        r2 = r6.mUploadOutputStream;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2.write(r7);	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2 = r6.mUploadOutputStream;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2.flush();	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        if (r8 == 0) goto L_0x007f;
    L_0x006c:
        r2 = r6.mUploadOutputStream;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2.close();	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2 = r6.mUploadConnection;	 Catch:{ EOFException -> 0x0084, Exception -> 0x00ab }
        r2 = r2.getInputStream();	 Catch:{ EOFException -> 0x0084, Exception -> 0x00ab }
        r2.close();	 Catch:{ EOFException -> 0x0084, Exception -> 0x00ab }
    L_0x007a:
        r2 = r6.mUploadConnection;	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        r2.disconnect();	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
    L_0x007f:
        monitor-exit(r6);	 Catch:{ all -> 0x0081 }
        goto L_0x0012;
    L_0x0081:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0081 }
        throw r0;
    L_0x0084:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ EOFException -> 0x0089, Exception -> 0x00ab }
        goto L_0x007a;
    L_0x0089:
        r0 = move-exception;
        r0 = "BDSHttpRequestMaker";
        r2 = "send data EOFException";
        android.util.Log.w(r0, r2);	 Catch:{ all -> 0x0081 }
        r0 = new com.baidu.speech.core.BDSHTTPResponse;	 Catch:{ all -> 0x0081 }
        r0.<init>();	 Catch:{ all -> 0x0081 }
        r2 = 2100; // 0x834 float:2.943E-42 double:1.0375E-320;
        r0.m_http_status = r2;	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r0.m_response_data = r2;	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r0.m_request_status = r2;	 Catch:{ all -> 0x0081 }
        r2 = r6.mErrorArray;	 Catch:{ all -> 0x0081 }
        r2.add(r0);	 Catch:{ all -> 0x0081 }
        monitor-exit(r6);	 Catch:{ all -> 0x0081 }
        r0 = r1;
        goto L_0x0012;
    L_0x00ab:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0081 }
        r1 = new com.baidu.speech.core.BDSHTTPResponse;	 Catch:{ all -> 0x0081 }
        r1.<init>();	 Catch:{ all -> 0x0081 }
        r2 = r6.mAgentUpload;	 Catch:{ all -> 0x0081 }
        if (r2 == 0) goto L_0x00cb;
    L_0x00b8:
        r2 = 2102; // 0x836 float:2.946E-42 double:1.0385E-320;
        r1.m_http_status = r2;	 Catch:{ all -> 0x0081 }
    L_0x00bc:
        r2 = 0;
        r1.m_response_data = r2;	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r1.m_request_status = r2;	 Catch:{ all -> 0x0081 }
        r2 = r6.mErrorArray;	 Catch:{ all -> 0x0081 }
        r2.add(r1);	 Catch:{ all -> 0x0081 }
        r1 = 0;
        r6.mAgentUpload = r1;	 Catch:{ all -> 0x0081 }
        goto L_0x007f;
    L_0x00cb:
        r2 = 2003; // 0x7d3 float:2.807E-42 double:9.896E-321;
        r1.m_http_status = r2;	 Catch:{ all -> 0x0081 }
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.speech.core.BDSHttpRequestMaker.sendData(byte[], boolean):int");
    }

    public int setupConnection(String str, String[] strArr, float f, int i) {
        if (Log.isLoggable(TAG, 3) || DEBUG.booleanValue()) {
            Log.i(TAG, "url = " + str);
        }
        this.mErrorArray.clear();
        try {
            mHostIp = new URL(str).getHost();
            if (Log.isLoggable(TAG, 3) || DEBUG.booleanValue()) {
                Log.d(TAG, "url: " + str + " mHostIp: " + mHostIp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str.contains(OfflineMapKey.OFFLINE_UPDATE)) {
            generateBackupUrls(str, 1);
            return setupUploadConnection(str, strArr, f, i);
        } else if (str.contains("down")) {
            generateBackupUrls(str, 2);
            return setupDownloadConnection(str, strArr, f, i);
        } else {
            Log.e(TAG, "Error url : " + str);
            return -1;
        }
    }

    public int setupDownloadConnection(String str, String[] strArr, float f, int i) {
        try {
            Proxy agent = setAgent();
            if (agent != null) {
                this.mDownloadConnection = (HttpURLConnection) new URL(str).openConnection(agent);
                this.mAgentDownload = true;
            } else {
                this.mDownloadConnection = (HttpURLConnection) new URL(str).openConnection();
            }
            if (this.mDownloadConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) this.mDownloadConnection).setHostnameVerifier(DO_NOT_VERIFY);
            }
            this.mDownloadConnection.setConnectTimeout(3000);
            this.mDownloadConnection.setReadTimeout(10000);
            this.mDownloadConnection.setRequestMethod("POST");
            int i2 = 0;
            while (strArr != null && i2 < strArr.length - 1) {
                this.mDownloadConnection.setRequestProperty(strArr[i2], strArr[i2 + 1]);
                i2 += 2;
            }
            if (Integer.parseInt(VERSION.SDK) < 21) {
                this.mDownloadConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "close");
            }
            this.mDownloadConnection.setChunkedStreamingMode(0);
            this.mDownloadConnection.connect();
            this.mDownloadConnectionStatus = 1;
            AudioData audioData = new AudioData(3, new byte[0], true);
            OutputStream outputStream = this.mDownloadConnection.getOutputStream();
            outputStream.write(audioData.mData);
            outputStream.flush();
            outputStream.close();
            if (Log.isLoggable(TAG, 3) || DEBUG.booleanValue()) {
                for (i2 = 0; i2 < audioData.mData.length; i2++) {
                    Log.i(TAG, "DownloadThread mData[" + i2 + "] = " + Integer.toHexString(audioData.mData[i2] & 255));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!this.mRetriedNorth) {
                this.mRetriedNorth = true;
                setupDownloadConnection(this.mNorthDownUrl, strArr, f, i);
            } else if (!this.mRetriedSouth) {
                this.mRetriedSouth = true;
                setupDownloadConnection(this.mSouthDownUrl, strArr, f, i);
            }
            BDSHTTPResponse bDSHTTPResponse = new BDSHTTPResponse();
            if (e instanceof SocketTimeoutException) {
                bDSHTTPResponse.m_http_status = 1005;
            } else if (this.mAgentDownload) {
                bDSHTTPResponse.m_http_status = AsrError.ERROR_NETWORK_FAIL_AGENT_CONNECT_DOWN;
            } else {
                bDSHTTPResponse.m_http_status = 2004;
            }
            bDSHTTPResponse.m_response_data = null;
            bDSHTTPResponse.m_request_status = 0;
            this.mErrorArray.add(bDSHTTPResponse);
            this.mAgentDownload = false;
        } catch (AssertionError e2) {
            e2.printStackTrace();
            if (!this.mRetriedNorth) {
                this.mRetriedNorth = true;
                setupDownloadConnection(this.mNorthDownUrl, strArr, f, i);
            } else if (!this.mRetriedSouth) {
                this.mRetriedSouth = true;
                setupDownloadConnection(this.mSouthDownUrl, strArr, f, i);
            }
            BDSHTTPResponse bDSHTTPResponse2 = new BDSHTTPResponse();
            if (this.mAgentDownload) {
                bDSHTTPResponse2.m_http_status = AsrError.ERROR_NETWORK_FAIL_AGENT_CONNECT_DOWN;
            } else {
                bDSHTTPResponse2.m_http_status = 2004;
            }
            bDSHTTPResponse2.m_response_data = null;
            bDSHTTPResponse2.m_request_status = 0;
            this.mErrorArray.add(bDSHTTPResponse2);
            this.mAgentDownload = false;
        }
        return 0;
    }

    public int setupUploadConnection(String str, String[] strArr, float f, int i) {
        try {
            Proxy agent = setAgent();
            if (agent != null) {
                this.mUploadConnection = (HttpURLConnection) new URL(str).openConnection(agent);
                this.mAgentUpload = true;
            } else {
                this.mUploadConnection = (HttpURLConnection) new URL(str).openConnection();
            }
            if (this.mUploadConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) this.mUploadConnection).setHostnameVerifier(DO_NOT_VERIFY);
            }
            this.mUploadConnection.setConnectTimeout(3000);
            this.mUploadConnection.setReadTimeout(10000);
            this.mUploadConnection.setRequestMethod("POST");
            int i2 = 0;
            while (strArr != null && i2 < strArr.length - 1) {
                this.mUploadConnection.setRequestProperty(strArr[i2], strArr[i2 + 1]);
                i2 += 2;
            }
            if (Integer.parseInt(VERSION.SDK) < 21) {
                this.mUploadConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "close");
            }
            this.mUploadConnection.setChunkedStreamingMode(0);
            this.mUploadConnection.connect();
            this.mUploadConnctionStatus = 1;
        } catch (Exception e) {
            e.printStackTrace();
            if (!this.mRetriedNorth) {
                this.mRetriedNorth = true;
                setupUploadConnection(this.mNorthUpUrl, strArr, f, i);
            } else if (!this.mRetriedSouth) {
                this.mRetriedSouth = true;
                setupUploadConnection(this.mSouthUpUrl, strArr, f, i);
            }
            BDSHTTPResponse bDSHTTPResponse = new BDSHTTPResponse();
            if (e instanceof SocketTimeoutException) {
                bDSHTTPResponse.m_http_status = 1003;
            } else if (this.mAgentUpload) {
                bDSHTTPResponse.m_http_status = 2002;
            } else {
                bDSHTTPResponse.m_request_status = AsrError.ERROR_NETWORK_FAIL_AGENT_CONNECT_UP;
            }
            this.mAgentUpload = false;
            bDSHTTPResponse.m_response_data = null;
            bDSHTTPResponse.m_request_status = 0;
            this.mErrorArray.add(bDSHTTPResponse);
        } catch (AssertionError e2) {
            e2.printStackTrace();
            if (!this.mRetriedNorth) {
                this.mRetriedNorth = true;
                setupUploadConnection(this.mNorthUpUrl, strArr, f, i);
            } else if (!this.mRetriedSouth) {
                this.mRetriedSouth = true;
                setupUploadConnection(this.mSouthUpUrl, strArr, f, i);
            }
            BDSHTTPResponse bDSHTTPResponse2 = new BDSHTTPResponse();
            if (this.mAgentUpload) {
                bDSHTTPResponse2.m_http_status = 2002;
            } else {
                bDSHTTPResponse2.m_request_status = AsrError.ERROR_NETWORK_FAIL_AGENT_CONNECT_UP;
            }
            this.mAgentUpload = false;
            bDSHTTPResponse2.m_response_data = null;
            bDSHTTPResponse2.m_request_status = 0;
            this.mErrorArray.add(bDSHTTPResponse2);
        }
        return 0;
    }
}
