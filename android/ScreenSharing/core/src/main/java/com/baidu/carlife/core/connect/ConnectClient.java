package com.baidu.carlife.core.connect;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;

/* compiled from: ConnectClient */
/* renamed from: com.baidu.carlife.core.connect.d */
public class ConnectClient implements KeepClass {
    /* renamed from: a */
    private static final String Tag = "ConnectClient";
    /* renamed from: b */
    private static final String ConnectClientHandlerThreadTag = "ConnectClientHandlerThread";
    /* renamed from: l */
    private static ConnectClient sConnectClient = null;
    /* renamed from: c */
    private Context mContext = null;
    /* renamed from: d */
    private ConnectServiceReceiver mServiceReceiver = null;
    /* renamed from: e */
    private UsbConnectStateReceiver mStateReceiver = null;
    /* renamed from: f */
    private ConnectClientHandler mClientHandler = null;
    /* renamed from: g */
    private Messenger mServiceMessenger = null;
    /* renamed from: h */
    private Messenger mClientMessenger = null;
    /* renamed from: i */
    private boolean mUSBCableIsConn = true;
    /* renamed from: j */
    private boolean mIS = false;
    /* renamed from: k */
    private boolean mServiceIsConn = false;
    /* renamed from: m */
    private ServiceConnection mClientService = new ConnectClientService(this);

    /* compiled from: ConnectClient */
    /* renamed from: com.baidu.carlife.core.connect.d$1 */
    class ConnectClientService implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ ConnectClient mConnectClient;

        ConnectClientService(ConnectClient this$0) {
            this.mConnectClient = this$0;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtil.d(ConnectClient.Tag, "onServiceConnected");
            this.mConnectClient.mServiceIsConn = true;
            this.mConnectClient.mServiceMessenger = new Messenger(service);
            this.mConnectClient.sendMsgToService(Message.obtain(null, CommonParams.eL));
        }

        public void onServiceDisconnected(ComponentName name) {
            LogUtil.d(ConnectClient.Tag, "onServiceDisconnected");
            this.mConnectClient.mServiceIsConn = false;
            this.mConnectClient.mServiceMessenger = null;
        }
    }

    /* compiled from: ConnectClient */
    /* renamed from: com.baidu.carlife.core.connect.d$a */
    private class ConnectClientHandler extends Handler {
        /* renamed from: a */
        final /* synthetic */ ConnectClient mConnectClient;

        public ConnectClientHandler(ConnectClient connectClient, Looper looper) {
            super(looper);
            this.mConnectClient = connectClient;
        }

        public void handleMessage(Message msg) {
            if (msg != null) {
                switch (msg.what) {
                    case 1031:
                        if (msg.arg1 == CommonParams.fe) {
                            this.mConnectClient.mUSBCableIsConn = true;
                            LogUtil.e(ConnectClient.Tag, "USB Cable is connected!");
                            return;
                        } else if (msg.arg1 == CommonParams.ff) {
                            this.mConnectClient.mUSBCableIsConn = false;
                            LogUtil.e(ConnectClient.Tag, "USB Cable is disconnected!");
                            if (ConnectManager.newInstance().getType() == 2 && this.mConnectClient.mIS) {
                                this.mConnectClient.setIS(false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 1034:
                        if (msg.arg1 == CommonParams.fh) {
                            this.mConnectClient.bindConnectService();
                            return;
                        } else if (msg.arg1 == CommonParams.fi) {
                            this.mConnectClient.unConnectService();
                            return;
                        } else {
                            return;
                        }
                    default:
                        super.handleMessage(msg);
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public static ConnectClient newInstance() {
        if (sConnectClient == null) {
            synchronized (ConnectClient.class) {
                if (sConnectClient == null) {
                    sConnectClient = new ConnectClient();
                }
            }
        }
        return sConnectClient;
    }

    private ConnectClient() {
    }

    /* renamed from: a */
    public void init(Context context) {
        LogUtil.d(Tag, "init");
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread(ConnectClientHandlerThreadTag);
        handlerThread.start();
        this.mClientHandler = new ConnectClientHandler(this, handlerThread.getLooper());
        this.mClientMessenger = new Messenger(this.mClientHandler);
        this.mServiceReceiver = new ConnectServiceReceiver(context, this.mClientHandler);
        this.mStateReceiver = new UsbConnectStateReceiver(context, this.mClientHandler);
        try {
            regConnectServiceReceiver();
            regUsbConnectStateReceiver();
            bindConnectService();
        } catch (Exception e) {
            LogUtil.e(Tag, "UsbConnectStateManager init fail");
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void uninit() {
        LogUtil.d(Tag, "uninit");
        try {
            unConnectServiceReceiver();
            unUsbConnectStateReceiver();
            unConnectService();
        } catch (Exception e) {
            LogUtil.e(Tag, "UsbConnectStateManager uninit fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void startConnectService() {
        LogUtil.d(Tag, "start ConnectService");
        this.mContext.startService(new Intent(this.mContext, ConnectService.class));
    }

    /* renamed from: f */
    private void stopConnectService() {
        LogUtil.d(Tag, "stop ConnectService");
        this.mContext.stopService(new Intent(this.mContext, ConnectService.class));
    }

    /* renamed from: g */
    private void bindConnectService() {
        LogUtil.d(Tag, "bind ConnectService");
        this.mContext.bindService(new Intent(this.mContext, ConnectService.class), this.mClientService, Context.BIND_AUTO_CREATE);
    }

    /* renamed from: h */
    private void unConnectService() {
        LogUtil.d(Tag, "unbind ConnectService");
        this.mContext.unbindService(this.mClientService);
        sendMsgToService(Message.obtain(null, CommonParams.eM));
    }

    /* renamed from: i */
    private void regConnectServiceReceiver() {
        if (this.mServiceReceiver != null) {
            this.mServiceReceiver.registerReceiver();
            LogUtil.d(Tag, "register ConnectServiceReceiver");
        }
    }

    /* renamed from: j */
    private void regUsbConnectStateReceiver() {
        if (this.mStateReceiver != null) {
            this.mStateReceiver.registerReceiver();
            LogUtil.d(Tag, "register UsbConnectStateReceiver");
        }
    }

    /* renamed from: k */
    private void unConnectServiceReceiver() {
        if (this.mServiceReceiver != null) {
            this.mServiceReceiver.unregisterReceiver();
            LogUtil.d(Tag, "unregister ConnectServiceReceiver");
        }
    }

    /* renamed from: l */
    private void unUsbConnectStateReceiver() {
        if (this.mStateReceiver != null) {
            this.mStateReceiver.unregisterReceiver();
            LogUtil.d(Tag, "unregister UsbConnectStateReceiver");
        }
    }

    /* renamed from: a */
    public boolean sendMsgToService(Message msg) {
        LogUtil.d(Tag, "Send Msg to Service, what = 0x" + DigitalTrans.m4317a(msg.what, 8));
        if (this.mServiceMessenger == null) {
            LogUtil.e(Tag, "mConnectService is null");
            return false;
        } else if (this.mClientMessenger == null) {
            LogUtil.e(Tag, "mConnectClient is null");
            return false;
        } else {
            try {
                msg.replyTo = this.mClientMessenger;
                this.mServiceMessenger.send(msg);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: a */
    public synchronized void setIS(boolean is) {
        if (getIS() && !is) {
            this.mIS = is;
            MsgHandlerCenter.dispatchMessage(1002);
        } else if (!getIS() && is) {
            this.mIS = is;
            MsgHandlerCenter.dispatchMessage(1004);
        }
    }

    /* renamed from: c */
    public boolean getIS() {
        return this.mIS;
    }

    /* renamed from: d */
    public boolean getUSBCableIsConn() {
        return this.mUSBCableIsConn;
    }
}
