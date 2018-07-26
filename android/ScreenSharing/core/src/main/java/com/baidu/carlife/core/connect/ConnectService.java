package com.baidu.carlife.core.connect;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

import com.baidu.carlife.core.LogUtil;

import java.util.LinkedList;
import java.util.List;

public class ConnectService extends Service {
    /* renamed from: a */
    public static final int f3180a = -1;
    /* renamed from: b */
    private static final String Tag = "ConnectService";
    /* renamed from: c */
    private static final int f3182c = 100;
    /* renamed from: d */
    private HandlerThread mMsgHandlerThread = new HandlerThread("MsgHandlerThread");
    /* renamed from: e */
    private ConnectServiceHandler mConnectServiceHandler;
    /* renamed from: f */
    private Messenger mMessenger;
    /* renamed from: g */
    private ConnectServiceProxy mConnectServiceProxy = null;
    /* renamed from: h */
    private Handler mHandler = null;
    /* renamed from: i */
    private List<Message> mMessageList = new LinkedList();
    /* renamed from: j */
    private ConnectManager mConnectManager = null;

    /* renamed from: com.baidu.carlife.core.connect.ConnectService$a */
    private class ConnectServiceHandler extends Handler {
        /* renamed from: a */
        final /* synthetic */ ConnectService mConnectService;

        public ConnectServiceHandler(ConnectService connectService, Looper looper) {
            super(looper);
            this.mConnectService = connectService;
        }

        public void handleMessage(Message msg) {
            if (this.mConnectService.mHandler != null) {
                this.mConnectService.mHandler.handleMessage(msg);
                if (this.mConnectService.mMessageList.size() > 0) {
                    this.mConnectService.mConnectServiceHandler.sendMessage((Message) this.mConnectService.mMessageList.remove(0));
                    return;
                }
                return;
            }
            if (this.mConnectService.mMessageList.size() >= 100) {
                Message oldMsg = (Message) this.mConnectService.mMessageList.remove(0);
                Message replayMsg = Message.obtain(null, -1, oldMsg);
                try {
                    LogUtil.e(ConnectService.Tag, "Send MSG_SEND_DISCARD, oldMsg what = " + Integer.toString(oldMsg.what));
                    oldMsg.replyTo.send(replayMsg);
                } catch (Throwable t) {
                    LogUtil.e(ConnectService.Tag, "Send MSG_SEND_DISCARD Error");
                    t.printStackTrace();
                }
            }
            this.mConnectService.mMessageList.add(Message.obtain(msg));
            this.mConnectService.onBind();
        }
    }

    /* renamed from: a */
    private void onBind() {
        try {
            if (this.mConnectServiceProxy == null || this.mHandler == null) {
                this.mConnectServiceProxy = new ConnectServiceProxy(this);
                this.mHandler = this.mConnectServiceProxy.getConnectServiceProxyHandler();
            }
            if (this.mMessageList.size() > 0) {
                this.mConnectServiceHandler.sendMessage((Message) this.mMessageList.remove(0));
            }
            this.mConnectManager = ConnectManager.newInstance();
            this.mConnectManager.startAcceptThread();
            this.mConnectManager.startUDP();
        } catch (Throwable t) {
            this.mConnectServiceProxy = null;
            this.mHandler = null;
            t.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        LogUtil.d(Tag, "ConnectService onBind()");
        return this.mMessenger.getBinder();
    }

    public boolean onUnbind(Intent intent) {
        LogUtil.d(Tag, "ConnectService onUnbind()");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        LogUtil.d(Tag, "ConnectService onRebind()");
        super.onRebind(intent);
    }

    public void onCreate() {
        LogUtil.d(Tag, "ConnectService onCreate()");
        super.onCreate();
        this.mMsgHandlerThread.start();
        this.mConnectServiceHandler = new ConnectServiceHandler(this, this.mMsgHandlerThread.getLooper());
        this.mMessenger = new Messenger(this.mConnectServiceHandler);
        onBind();
    }

    public void onStart(Intent intent, int startId) {
        LogUtil.d(Tag, "ConnectService onStart(), startId = " + startId);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d(Tag, "ConnectService onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        LogUtil.d(Tag, "ConnectService onDestroy()");
        if (this.mConnectManager != null) {
            this.mConnectManager.stopAcceptThread();
            this.mConnectManager = null;
        }
        super.onDestroy();
    }
}
