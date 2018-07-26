package com.baidu.navisdk.hudsdk.socket;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.radio.p080b.C2125n;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.hudsdk.BNRemoteConstants;
import com.baidu.navisdk.hudsdk.socket.BNRGEventHUDCollection.SendAllClientCallback;
import com.baidu.navisdk.hudsdk.socket.SocketClientInfo.SocketClientEnvetCallback;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRemoteServer {
    public static final boolean ENABLE = false;
    private static final int MSG_BROADCAST_ALL_CLIENT = 3000;
    private static final int MSG_SEND_CLIENT = 3001;
    private static BNRemoteServer mInstance;
    private SendAllClientCallback mBroadcast = new C40971();
    private ArrayList<SocketClientInfo> mCliensList = new ArrayList();
    private SocketClientEnvetCallback mClientCallback = new C40982();
    private byte[] mClientsListLock = new byte[0];
    private Context mContext;
    private boolean mIsListened = false;
    private int mPortsPoolType;
    private ServerListenerThread mServerListenerThread;
    private ServerSendHandler mServerSendHandler;
    private Looper mServerSendLooper;
    private HandlerThread mServerSendThread;
    private ServerSocket mServerSocket = null;

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRemoteServer$1 */
    class C40971 implements SendAllClientCallback {
        C40971() {
        }

        public void onBroadcast(JSONObject obj) {
            BNRemoteServer.this.broadcast(obj);
        }
    }

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRemoteServer$2 */
    class C40982 implements SocketClientEnvetCallback {
        C40982() {
        }

        public void onRemoveClient(SocketClientInfo client) {
            BNRemoteServer.this.removeClient(client);
        }
    }

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRemoteServer$3 */
    class C40993 extends Handler {
        C40993(Looper x0) {
            super(x0);
        }

        public void handleMessage(Message msg) {
            if (msg != null && msg.what == CommandConst.K_MSG_GENERAL_HTTP_TYPE_HUDSDK_SWITCH) {
                int isOpen = 1;
                if (msg.arg1 == 0) {
                    JSONObject json = msg.obj.mData;
                    try {
                        if (json.getInt(C2125n.f6745M) == 0) {
                            JSONObject dataJson = json.getJSONObject("data");
                            if (dataJson != null) {
                                isOpen = dataJson.getInt("open");
                            }
                        } else if (BNSettingManager.getHUDSDKSwitch() == 0) {
                            isOpen = 0;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        if (BNSettingManager.getHUDSDKSwitch() == 0) {
                            isOpen = 0;
                        }
                    }
                } else if (BNSettingManager.getHUDSDKSwitch() == 0) {
                    isOpen = 0;
                }
                BNSettingManager.setHUDSDKSwitch(isOpen);
                if (isOpen == 1) {
                    BNRemoteServer.getInstance().listen();
                } else {
                    BNRemoteServer.getInstance().unInit();
                }
            }
        }
    }

    class ServerListenerThread extends Thread {
        private boolean mIsStoped = false;

        ServerListenerThread() {
        }

        public void run() {
            if (BNRemoteServer.this.createSocket() == 0) {
                LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "BNRemoteServer.............ServerListenerThread start RUNNNN!!");
                while (!this.mIsStoped) {
                    try {
                        Socket socket = BNRemoteServer.this.mServerSocket.accept();
                        if (socket != null) {
                            BNRemoteServer.this.addClient(new SocketClientInfo(socket, BNRemoteServer.this.mContext, BNRemoteServer.this.mClientCallback, BNRemoteServer.this.mServerSendLooper));
                        }
                    } catch (IOException e) {
                        if (LogUtil.LOGGABLE) {
                            e.printStackTrace();
                        }
                        BNRemoteServer.this.unInit();
                        this.mIsStoped = true;
                    }
                }
            }
        }

        public void quit() {
            this.mIsStoped = true;
        }
    }

    class ServerSendHandler extends Handler {
        public ServerSendHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case 3000:
                        BNRemoteServer.this.sendMsgToAllClient(msg.obj);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private BNRemoteServer() {
    }

    public static BNRemoteServer getInstance() {
        if (mInstance == null) {
            synchronized (BNRemoteServer.class) {
                if (mInstance == null) {
                    mInstance = new BNRemoteServer();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context, int serverType) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void listen() {
        /*
        r3 = this;
        r2 = 1;
        r1 = com.baidu.navisdk.hudsdk.socket.BNRemoteServer.class;
        monitor-enter(r1);
        r0 = r3.mIsListened;	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0041 }
    L_0x0009:
        return;
    L_0x000a:
        r0 = com.baidu.navisdk.comapi.setting.BNSettingManager.getHUDSDKSwitch();	 Catch:{ all -> 0x0041 }
        if (r0 != r2) goto L_0x003f;
    L_0x0010:
        r0 = 1;
        r3.mIsListened = r0;	 Catch:{ all -> 0x0041 }
        r0 = new android.os.HandlerThread;	 Catch:{ all -> 0x0041 }
        r2 = "send thread";
        r0.<init>(r2);	 Catch:{ all -> 0x0041 }
        r3.mServerSendThread = r0;	 Catch:{ all -> 0x0041 }
        r0 = r3.mServerSendThread;	 Catch:{ all -> 0x0041 }
        r0.start();	 Catch:{ all -> 0x0041 }
        r0 = r3.mServerSendThread;	 Catch:{ all -> 0x0041 }
        r0 = r0.getLooper();	 Catch:{ all -> 0x0041 }
        r3.mServerSendLooper = r0;	 Catch:{ all -> 0x0041 }
        r0 = new com.baidu.navisdk.hudsdk.socket.BNRemoteServer$ServerSendHandler;	 Catch:{ all -> 0x0041 }
        r2 = r3.mServerSendLooper;	 Catch:{ all -> 0x0041 }
        r0.<init>(r2);	 Catch:{ all -> 0x0041 }
        r3.mServerSendHandler = r0;	 Catch:{ all -> 0x0041 }
        r0 = new com.baidu.navisdk.hudsdk.socket.BNRemoteServer$ServerListenerThread;	 Catch:{ all -> 0x0041 }
        r0.<init>();	 Catch:{ all -> 0x0041 }
        r3.mServerListenerThread = r0;	 Catch:{ all -> 0x0041 }
        r0 = r3.mServerListenerThread;	 Catch:{ all -> 0x0041 }
        r0.start();	 Catch:{ all -> 0x0041 }
    L_0x003f:
        monitor-exit(r1);	 Catch:{ all -> 0x0041 }
        goto L_0x0009;
    L_0x0041:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0041 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.hudsdk.socket.BNRemoteServer.listen():void");
    }

    private int createSocket() {
        int[] portsPool;
        if (this.mPortsPoolType == 1) {
            portsPool = BNRemoteConstants.NAVI_PORTS_POOL;
        } else {
            portsPool = BNRemoteConstants.MAP_PORTS_POOL;
        }
        for (int inetSocketAddress : portsPool) {
            try {
                this.mServerSocket = new ServerSocket();
                this.mServerSocket.bind(new InetSocketAddress(inetSocketAddress));
            } catch (IOException e) {
                this.mServerSocket = null;
            }
            if (this.mServerSocket != null) {
                break;
            }
        }
        if (this.mServerSocket != null) {
            LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "BNRemoteServer.............createSocket() SUCCESS");
            return 0;
        }
        LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "BNRemoteServer.............createSocket() FAILED");
        return 1;
    }

    public void unInit() {
    }

    private void clearAllClient() {
        synchronized (this.mClientsListLock) {
            int index = 0;
            for (int count = this.mCliensList.size(); count > 0; count--) {
                ((SocketClientInfo) this.mCliensList.get(index)).close("");
                this.mCliensList.remove(index);
                index = 0;
            }
        }
        handleEventCollection();
    }

    private void handleEventCollection() {
        try {
            int curVistorCount = this.mCliensList.size();
            if (curVistorCount > 0 && this.mContext != null) {
                BNRGEventHUDCollection.getInstance().init(this.mContext, this.mBroadcast);
            }
            if (curVistorCount == 0) {
                BNRGEventHUDCollection.getInstance().unInit();
            }
        } catch (Throwable th) {
        }
    }

    private void addClient(SocketClientInfo client) {
        LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "BNRemoteServer.......addClient() new client connect success");
        synchronized (this.mClientsListLock) {
            this.mCliensList.add(client);
            handleEventCollection();
        }
        client.heartAliveCheck();
    }

    private void removeClient(SocketClientInfo client) {
        LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "BNRemoteServer.......removeClient() remove client");
        synchronized (this.mClientsListLock) {
            this.mCliensList.remove(client);
            handleEventCollection();
        }
    }

    private void sendMsgToAllClient(JSONObject msgJson) {
        if (msgJson != null) {
            synchronized (this.mClientsListLock) {
                for (int index = 0; index < this.mCliensList.size(); index++) {
                    SocketClientInfo client = (SocketClientInfo) this.mCliensList.get(index);
                    if (client.checkIsAuthSuccess()) {
                        try {
                            client.sendMsgToClient(msgJson);
                        } catch (Exception e) {
                            client.close("");
                            this.mCliensList.remove(client);
                            handleEventCollection();
                        }
                    } else {
                        LogUtil.m15791e(BNRemoteConstants.MODULE_TAG, "BNRemoteServer.............sendMsgToAllClient()...this client is not auth");
                    }
                }
            }
        }
    }

    private void broadcast(JSONObject msgJson) {
        if (this.mServerSendHandler != null) {
            this.mServerSendHandler.sendMessage(this.mServerSendHandler.obtainMessage(3000, msgJson));
        }
    }
}
