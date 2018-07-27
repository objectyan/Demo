package me.objectyan.screensharing.core.connect;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;

import java.util.LinkedList;
import java.util.List;

public class ConnectService extends Service {

    public static final int f3180a = -1;

    private static final String Tag = "ConnectService";

    private static final int f3182c = 100;

    private HandlerThread mMsgHandlerThread = new HandlerThread("MsgHandlerThread");

    private ConnectServiceHandler mConnectServiceHandler;

    private Messenger mMessenger;

    private ConnectServiceProxy mConnectServiceProxy = null;

    private Handler mHandler = null;

    private List<Message> mMessageList = new LinkedList();

    private ConnectManager mConnectManager = null;

    //
    private class ConnectServiceHandler extends Handler {

        final  ConnectService mConnectService;

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
                    Log.e(ConnectService.Tag, "Send MSG_SEND_DISCARD, oldMsg what = " + Integer.toString(oldMsg.what));
                    oldMsg.replyTo.send(replayMsg);
                } catch (Throwable t) {
                    Log.e(ConnectService.Tag, "Send MSG_SEND_DISCARD Error");
                    t.printStackTrace();
                }
            }
            this.mConnectService.mMessageList.add(Message.obtain(msg));
            this.mConnectService.onBind();
        }
    }


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
        Log.d(Tag, "ConnectService onBind()");
        return this.mMessenger.getBinder();
    }

    public boolean onUnbind(Intent intent) {
        Log.d(Tag, "ConnectService onUnbind()");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        Log.d(Tag, "ConnectService onRebind()");
        super.onRebind(intent);
    }

    public void onCreate() {
        Log.d(Tag, "ConnectService onCreate()");
        super.onCreate();
        this.mMsgHandlerThread.start();
        this.mConnectServiceHandler = new ConnectServiceHandler(this, this.mMsgHandlerThread.getLooper());
        this.mMessenger = new Messenger(this.mConnectServiceHandler);
        onBind();
    }

    public void onStart(Intent intent, int startId) {
        Log.d(Tag, "ConnectService onStart(), startId = " + startId);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Tag, "ConnectService onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        Log.d(Tag, "ConnectService onDestroy()");
        if (this.mConnectManager != null) {
            this.mConnectManager.stopAcceptThread();
            this.mConnectManager = null;
        }
        super.onDestroy();
    }
}
