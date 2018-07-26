package com.baidu.navisdk.hudsdk.socket;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.hudsdk.HudSwitchReq;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.sapi2.SapiWebView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public class SocketClientInfo {
    private final int BUFFER_SIZE = 1024;
    private SocketClientEnvetCallback mClientCallback;
    private Handler mClientHandle;
    private ReadThread mClientReadThread;
    private Context mContext;
    private byte[] mData;
    private InputStream mInputStream;
    private boolean mIsAuth = false;
    private Looper mLooper;
    private int mMsgId;
    private OutputStream mOutputStream;
    private Socket mSocket;
    private BNWorkerNormalTask<String, String> mheartAliveTask = new BNWorkerNormalTask<String, String>("mheartAliveTask-" + getClass().getSimpleName(), null) {
        protected String execute() {
            Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........mheartAliveRunnable...RUNNN!!!  not receive PING PACKET");
            SocketClientInfo.this.close();
            return null;
        }
    };

    public interface SocketClientEnvetCallback {
        void onRemoveClient(SocketClientInfo socketClientInfo);
    }

    public class ReadThread extends Thread {
        ByteBuffer mBuffer = ByteBuffer.allocateDirect(262);
        boolean mIsStopped = false;

        public void quit() {
            this.mIsStopped = true;
        }

        public void run() {
            this.mBuffer.clear();
            while (!this.mIsStopped) {
                try {
                    if (SocketClientInfo.this.read(this.mBuffer) >= 0) {
                        consumeData();
                    } else {
                        Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........READ THREAD....read error, len < 0");
                        this.mIsStopped = true;
                        SocketClientInfo.this.close();
                    }
                } catch (SocketTimeoutException e) {
                    Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........READ THREAD....SocketTimeoutException, e= " + e.toString());
                    this.mIsStopped = true;
                    SocketClientInfo.this.close();
                } catch (IOException e2) {
                    Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........READ THREAD....IOException, e= " + e2.toString());
                    this.mIsStopped = true;
                    SocketClientInfo.this.close();
                } catch (JSONException e3) {
                    Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........READ THREAD....JSONException, e= " + e3.toString());
                    this.mIsStopped = true;
                    SocketClientInfo.this.close();
                }
            }
        }

        private void consumeData() throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException {
            while (this.mBuffer.hasRemaining()) {
                int position = this.mBuffer.position();
                this.mBuffer.flip();
                if (this.mBuffer.remaining() >= 4) {
                    int dataLen = ((((this.mBuffer.get() << 24) & -16777216) | ((this.mBuffer.get() << 16) & 16711680)) | ((this.mBuffer.get() << 8) & 65280)) | (this.mBuffer.get() & 255);
                    if (this.mBuffer.remaining() >= dataLen + 2) {
                        this.mBuffer.position(4);
                        byte[] msgData = new byte[dataLen];
                        this.mBuffer.get(msgData, 0, dataLen);
                        if (this.mBuffer.get() == (byte) 13 && this.mBuffer.get() == (byte) 10) {
                            unPackedData(new JSONObject(new String(msgData, "utf-8")));
                            if (this.mBuffer.hasRemaining()) {
                                byte[] tempData = new byte[(this.mBuffer.limit() - this.mBuffer.position())];
                                this.mBuffer.get(tempData, 0, tempData.length);
                                this.mBuffer.clear();
                                this.mBuffer.put(tempData, 0, tempData.length);
                            } else {
                                this.mBuffer.clear();
                                return;
                            }
                        }
                        throw new JSONException("protocol error");
                    }
                    this.mBuffer.clear();
                    this.mBuffer.position(position);
                    return;
                }
                this.mBuffer.clear();
                this.mBuffer.position(position);
                return;
            }
        }

        private void unPackedData(JSONObject json) throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException {
            JSONObject jsonData = json.getJSONObject("data");
            int type = jsonData.getInt(ParamKey.KEY_MSG_TYPE);
            JSONObject jsonObj = jsonData.getJSONObject(ParamKey.KEY_MSG_OBJ);
            switch (type) {
                case 10:
                    processPingMsg();
                    return;
                case 11:
                    processAuthReqMsg(jsonObj);
                    return;
                default:
                    return;
            }
        }

        private void processAuthReqMsg(JSONObject json) throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException {
            LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........processAuthReqMsg()....Recevie AUTH REQ MSG");
            String appVersion = json.getString(ParamKey.KEY_AUTH_APP_VERSION);
            String hudsdkVersion = json.getString(ParamKey.KEY_AUTH_HUD_SDK_VERSION);
            String appName = json.getString(ParamKey.KEY_AUTH_APP_NAME);
            Bundle paramBundle = new Bundle();
            paramBundle.putString("hudAppPkg", appName);
            paramBundle.putString("hudVer", hudsdkVersion);
            NaviStatItem.getInstance().mHudSDKClientPkgName = appName;
            HudSwitchReq.asyncHudAuth(CommandConst.K_MSG_GENERAL_HTTP_TYPE_HUSDK_CLIENT_ENTH, paramBundle, SocketClientInfo.this.mClientHandle);
        }

        private void processPingMsg() throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException {
            Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........processPingMsg()..........Receive PING MSG");
            SocketClientInfo.this.sendMsgToClient(PacketJSONData.packetPong());
        }
    }

    public SocketClientInfo(Socket socket, Context context, SocketClientEnvetCallback callback, Looper looper) {
        this.mContext = context;
        this.mLooper = looper;
        this.mClientCallback = callback;
        this.mSocket = socket;
        this.mMsgId = 0;
        try {
            this.mInputStream = this.mSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.mOutputStream = this.mSocket.getOutputStream();
        } catch (IOException e2) {
            e2.printStackTrace();
            this.mInputStream = null;
        }
        this.mData = new byte[1024];
        this.mClientReadThread = new ReadThread();
        this.mClientReadThread.start();
        this.mClientHandle = new Handler(this.mLooper) {
            public void handleMessage(Message msg) {
                if (msg != null && msg.what == CommandConst.K_MSG_GENERAL_HTTP_TYPE_HUSDK_CLIENT_ENTH) {
                    SocketClientInfo.this.processAuthResMsg(msg);
                }
            }
        };
    }

    public int read(ByteBuffer buffer) throws IOException, SocketTimeoutException {
        int maxReadNum = 1024;
        if (this.mInputStream == null) {
            throw new IOException();
        }
        int bufferSize = buffer.capacity() - buffer.position();
        if (bufferSize <= 1024) {
            maxReadNum = bufferSize;
        }
        int len = this.mInputStream.read(this.mData, 0, maxReadNum);
        if (len > 0) {
            buffer.put(this.mData, 0, len);
            updateHeartAlive();
        }
        return len;
    }

    public void write(byte[] data) throws IOException, SocketTimeoutException {
        if (this.mOutputStream == null) {
            throw new IOException();
        }
        this.mOutputStream.write(data, 0, data.length);
    }

    public boolean checkIsAuthSuccess() {
        return this.mIsAuth;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(java.lang.String r5) {
        /*
        r4 = this;
        r3 = 0;
        r0 = r4.mClientReadThread;
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = r4.mClientReadThread;
        r0.quit();
        r4.mClientReadThread = r3;
    L_0x000c:
        r4.mData = r3;
        r0 = r4.mInputStream;	 Catch:{ IOException -> 0x0044, all -> 0x004c }
        if (r0 == 0) goto L_0x0017;
    L_0x0012:
        r0 = r4.mInputStream;	 Catch:{ IOException -> 0x0044, all -> 0x004c }
        r0.close();	 Catch:{ IOException -> 0x0044, all -> 0x004c }
    L_0x0017:
        r0 = r4.mOutputStream;	 Catch:{ IOException -> 0x0044, all -> 0x004c }
        if (r0 == 0) goto L_0x0020;
    L_0x001b:
        r0 = r4.mOutputStream;	 Catch:{ IOException -> 0x0044, all -> 0x004c }
        r0.close();	 Catch:{ IOException -> 0x0044, all -> 0x004c }
    L_0x0020:
        r0 = r4.mSocket;	 Catch:{ IOException -> 0x0044, all -> 0x004c }
        if (r0 == 0) goto L_0x0029;
    L_0x0024:
        r0 = r4.mSocket;	 Catch:{ IOException -> 0x0044, all -> 0x004c }
        r0.close();	 Catch:{ IOException -> 0x0044, all -> 0x004c }
    L_0x0029:
        r4.mInputStream = r3;
        r4.mOutputStream = r3;
        r4.mSocket = r3;
    L_0x002f:
        r0 = r4.mClientHandle;
        if (r0 == 0) goto L_0x0035;
    L_0x0033:
        r4.mClientHandle = r3;
    L_0x0035:
        r0 = com.baidu.navisdk.util.worker.BNWorkerCenter.getInstance();
        r1 = r4.mheartAliveTask;
        r2 = 0;
        r0.cancelTask(r1, r2);
        r4.mLooper = r3;
        r4.mheartAliveTask = r3;
        return;
    L_0x0044:
        r0 = move-exception;
        r4.mInputStream = r3;
        r4.mOutputStream = r3;
        r4.mSocket = r3;
        goto L_0x002f;
    L_0x004c:
        r0 = move-exception;
        r4.mInputStream = r3;
        r4.mOutputStream = r3;
        r4.mSocket = r3;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.hudsdk.socket.SocketClientInfo.close(java.lang.String):void");
    }

    private void close() {
        close("read error");
        if (this.mClientCallback != null) {
            this.mClientCallback.onRemoveClient(this);
        }
    }

    private void updateHeartAlive() {
        BNWorkerCenter.getInstance().cancelTask(this.mheartAliveTask, false);
        BNWorkerCenter.getInstance().submitNormalTaskDelay(this.mheartAliveTask, new BNWorkerConfig(100, 0), SapiWebView.DEFAULT_TIMEOUT_MILLIS);
    }

    public void heartAliveCheck() {
        BNWorkerCenter.getInstance().submitNormalTaskDelay(this.mheartAliveTask, new BNWorkerConfig(100, 0), SapiWebView.DEFAULT_TIMEOUT_MILLIS);
    }

    public void sendMsgToClient(JSONObject json) throws SocketTimeoutException, IOException, UnsupportedEncodingException {
        if (json != null) {
            this.mMsgId++;
            try {
                json.put("msgId", this.mMsgId);
                json.put("sendTime", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            byte[] data = new byte[((msgLen + 4) + 2)];
            data[3] = (byte) (msgLen & 255);
            data[2] = (byte) ((msgLen >> 8) & 255);
            data[1] = (byte) ((msgLen >> 16) & 255);
            data[0] = (byte) ((msgLen >> 24) & 255);
            int index = 4;
            for (byte b : json.toString().getBytes("utf-8")) {
                data[index] = b;
                index++;
            }
            data[index] = (byte) 13;
            data[index + 1] = (byte) 10;
            write(data);
        }
    }

    private void processAuthResMsg(Message msg) {
        if (msg.arg1 == 0) {
            int isOpen = 1;
            JSONObject json = msg.obj.mData;
            try {
                if (json.getInt(C2125n.f6745M) == 0) {
                    JSONObject dataJson = json.getJSONObject("data");
                    if (dataJson != null) {
                        isOpen = dataJson.getInt("open");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (isOpen == 1) {
                LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "this client Auth SUCCESS");
                try {
                    sendMsgToClient(PacketJSONData.packetAuthRes(true));
                    this.mIsAuth = true;
                    preProcessRGInfo(BNSysLocationManager.getInstance().isGpsEnabled(), BNSysLocationManager.getInstance().isGpsAvailable());
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.mIsAuth = false;
                    close();
                    e2.printStackTrace();
                    return;
                }
            }
            LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "this client:" + this.mSocket.getInetAddress() + " Auth FAILED");
            try {
                sendMsgToClient(PacketJSONData.packetAuthRes(false));
                this.mIsAuth = false;
                return;
            } catch (Exception e22) {
                e22.printStackTrace();
                this.mIsAuth = false;
                close();
                return;
            }
        }
        try {
            sendMsgToClient(PacketJSONData.packetAuthRes(true));
            this.mIsAuth = true;
            preProcessRGInfo(BNSysLocationManager.getInstance().isGpsEnabled(), BNSysLocationManager.getInstance().isGpsAvailable());
        } catch (Exception e222) {
            e222.printStackTrace();
            this.mIsAuth = false;
            close();
        }
    }

    private void preProcessRGInfo(boolean enabled, boolean available) throws JSONException, SocketTimeoutException, IOException, UnsupportedEncodingException {
        if (BNavigator.getInstance().isNaviBegin()) {
            Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........already start Naviing");
            sendMsgToClient(PacketJSONData.packetJSONData(100, null));
            sendMsgToClient(PacketJSONData.packetJSONData(103, null));
            sendMsgToClient(PacketJSONData.packetJSONData(104, null));
        }
        if (BNavigator.getInstance().isARRouteBuildSuccess()) {
            int routeId = BNRGEventHUDCollection.getInstance().updateRouteID();
            Bundle bundle = new Bundle();
            bundle.putInt("routeId", routeId);
            sendMsgToClient(PacketJSONData.packetJSONData(120, bundle));
        }
        if (enabled && available) {
            Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........GPSNormal");
            sendMsgToClient(PacketJSONData.packetJSONData(107, null));
            return;
        }
        Log.e(BNRemoteConstants.MODULE_TAG, "SocketClientInfo...........GPSLost");
        sendMsgToClient(PacketJSONData.packetJSONData(106, null));
    }
}
