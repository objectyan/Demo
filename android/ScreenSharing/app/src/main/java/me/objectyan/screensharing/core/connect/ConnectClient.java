package me.objectyan.screensharing.core.connect;

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
import android.util.Log;

import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgHandlerCenter;


public class ConnectClient  {

    private static final String Tag = "ConnectClient";

    private static final String ConnectClientHandlerThreadTag = "ConnectClientHandlerThread";

    private static ConnectClient sConnectClient = null;

    private Context mContext = null;

    private ConnectServiceReceiver mServiceReceiver = null;

    private UsbConnectStateReceiver mStateReceiver = null;

    private ConnectClientHandler mClientHandler = null;

    private Messenger mServiceMessenger = null;

    private Messenger mClientMessenger = null;

    private boolean mUSBCableIsConn = true;

    private boolean mIS = false;

    private boolean mServiceIsConn = false;

    private ServiceConnection mClientService = new ConnectClientService(this);


    class ConnectClientService implements ServiceConnection {

        final  ConnectClient mConnectClient;

        ConnectClientService(ConnectClient this$0) {
            this.mConnectClient = this$0;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(ConnectClient.Tag, "onServiceConnected");
            this.mConnectClient.mServiceIsConn = true;
            this.mConnectClient.mServiceMessenger = new Messenger(service);
            this.mConnectClient.sendMsgToService(Message.obtain(null, CommonParams.eL));
        }

        public void onServiceDisconnected(ComponentName name) {
            Log.d(ConnectClient.Tag, "onServiceDisconnected");
            this.mConnectClient.mServiceIsConn = false;
            this.mConnectClient.mServiceMessenger = null;
        }
    }


    private class ConnectClientHandler extends Handler {

        final  ConnectClient mConnectClient;

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
                            Log.e(ConnectClient.Tag, "USB Cable is connected!");
                            return;
                        } else if (msg.arg1 == CommonParams.ff) {
                            this.mConnectClient.mUSBCableIsConn = false;
                            Log.e(ConnectClient.Tag, "USB Cable is disconnected!");
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


    public void init(Context context) {
        Log.d(Tag, "init");
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
            Log.e(Tag, "UsbConnectStateManager init fail");
            e.printStackTrace();
        }
    }


    public void uninit() {
        Log.d(Tag, "uninit");
        try {
            unConnectServiceReceiver();
            unUsbConnectStateReceiver();
            unConnectService();
        } catch (Exception e) {
            Log.e(Tag, "UsbConnectStateManager uninit fail");
            e.printStackTrace();
        }
    }


    private void startConnectService() {
        Log.d(Tag, "start ConnectService");
        this.mContext.startService(new Intent(this.mContext, ConnectService.class));
    }


    private void stopConnectService() {
        Log.d(Tag, "stop ConnectService");
        this.mContext.stopService(new Intent(this.mContext, ConnectService.class));
    }


    private void bindConnectService() {
        Log.d(Tag, "bind ConnectService");
        this.mContext.bindService(new Intent(this.mContext, ConnectService.class), this.mClientService, Context.BIND_AUTO_CREATE);
    }


    private void unConnectService() {
        Log.d(Tag, "unbind ConnectService");
        this.mContext.unbindService(this.mClientService);
        sendMsgToService(Message.obtain(null, CommonParams.eM));
    }


    private void regConnectServiceReceiver() {
        if (this.mServiceReceiver != null) {
            this.mServiceReceiver.registerReceiver();
            Log.d(Tag, "register ConnectServiceReceiver");
        }
    }


    private void regUsbConnectStateReceiver() {
        if (this.mStateReceiver != null) {
            this.mStateReceiver.registerReceiver();
            Log.d(Tag, "register UsbConnectStateReceiver");
        }
    }


    private void unConnectServiceReceiver() {
        if (this.mServiceReceiver != null) {
            this.mServiceReceiver.unregisterReceiver();
            Log.d(Tag, "unregister ConnectServiceReceiver");
        }
    }


    private void unUsbConnectStateReceiver() {
        if (this.mStateReceiver != null) {
            this.mStateReceiver.unregisterReceiver();
            Log.d(Tag, "unregister UsbConnectStateReceiver");
        }
    }


    public boolean sendMsgToService(Message msg) {
        Log.d(Tag, "Send Msg to Service, what = 0x" + DigitalTrans.m4317a(msg.what, 8));
        if (this.mServiceMessenger == null) {
            Log.e(Tag, "mConnectService is null");
            return false;
        } else if (this.mClientMessenger == null) {
            Log.e(Tag, "mConnectClient is null");
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


    public synchronized void setIS(boolean is) {
        if (getIS() && !is) {
            this.mIS = is;
            MsgHandlerCenter.dispatchMessage(1002);
        } else if (!getIS() && is) {
            this.mIS = is;
            MsgHandlerCenter.dispatchMessage(1004);
        }
    }


    public boolean getIS() {
        return this.mIS;
    }


    public boolean getUSBCableIsConn() {
        return this.mUSBCableIsConn;
    }
}
