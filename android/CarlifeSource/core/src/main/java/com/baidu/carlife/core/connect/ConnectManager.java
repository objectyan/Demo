package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.mobstat.Config;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ConnectManager */
/* renamed from: com.baidu.carlife.core.connect.e */
public class ConnectManager implements KeepClass {
    /* renamed from: a */
    public static final String Tag = "ConnectManager";
    /* renamed from: b */
    public static final String TagAcceptThread = "AcceptThread";
    /* renamed from: h */
    public static int sType = 1;
    /* renamed from: w */
    private static ConnectManager sConnectManager = null;
    /* renamed from: y */
    private static int mTotalSocket = 6;
    /* renamed from: A */
    private Timer mTimer = null;
    /* renamed from: B */
    private TimerTask mTimerTask = null;
    /* renamed from: C */
    private DatagramSocket mDatagramSocket = null;
    /* renamed from: D */
    private DatagramPacket mDatagramPacket = null;
    /* renamed from: E */
    private boolean f3342E = false;
    /* renamed from: i */
    private ConnectManagerThread mCmdManagerThread = null;
    /* renamed from: j */
    private ConnectManagerThread mVideoManagerThread = null;
    /* renamed from: k */
    private ConnectManagerThread mAudioManagerThread = null;
    /* renamed from: l */
    private ConnectManagerThread mTTSManagerThread = null;
    /* renamed from: m */
    private ConnectManagerThread mAudioVRManagerThread = null;
    /* renamed from: n */
    private ConnectManagerThread mTouchManagerThread = null;
    /* renamed from: o */
    private ConnectManagerThread mDataManagerThread = null;
    /* renamed from: p */
    private ConnectSocket mCMDConnectSocket = null;
    /* renamed from: q */
    private ConnectSocket mVideoConnectSocket = null;
    /* renamed from: r */
    private ConnectSocket mAudioConnectSocket = null;
    /* renamed from: s */
    private ConnectSocket mTTSConnectSocket = null;
    /* renamed from: t */
    private ConnectSocket mAudioVRConnectSocket = null;
    /* renamed from: u */
    private ConnectSocket mTouchConnectSocket = null;
    /* renamed from: v */
    private ConnectSocket mDataConnectSocket = null;
    /* renamed from: x */
    private int mCurrentSocketNum = 0;
    /* renamed from: z */
    private boolean is = false;

    /* compiled from: ConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.e$1 */
    class ConnectManagerTask extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ ConnectManager mConnectManager;

        ConnectManagerTask(ConnectManager this$0) {
            this.mConnectManager = this$0;
        }

        public void run() {
            String ipv4Address = this.mConnectManager.getLocalHostIp();
            if (ipv4Address != null) {
                LogUtil.d(ConnectManager.Tag, "send udp address : " + ipv4Address);
                byte[] buf = "CarlifeHost".getBytes();
                try {
                    this.mConnectManager.mDatagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(ipv4Address), 7999);
                    this.mConnectManager.mDatagramSocket.setBroadcast(true);
                    this.mConnectManager.mDatagramSocket.send(this.mConnectManager.mDatagramPacket);
                    this.mConnectManager.mDatagramSocket.close();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* compiled from: ConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.e$a */
    private class ConnectManagerThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectManager mConnectManager;
        /* renamed from: b */
        private ServerSocket mServerSocket = null;
        /* renamed from: c */
        private boolean mStatus = false;
        /* renamed from: d */
        private int mPort = -1;
        /* renamed from: e */
        private String mName = null;
        /* renamed from: f */
        private String sThreadName = null;

        public ConnectManagerThread(ConnectManager connectManager, int port, String name) {
            this.mConnectManager = connectManager;
            try {
                this.sThreadName = name + ConnectManager.TagAcceptThread;
                setName(this.sThreadName);
                LogUtil.d(ConnectManager.Tag, "Create " + this.sThreadName);
                this.mPort = port;
                this.mName = name;
                this.mServerSocket = new ServerSocket(this.mPort);
                this.mStatus = true;
            } catch (Exception e) {
                LogUtil.e(ConnectManager.Tag, "Create " + this.sThreadName + " fail");
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public void closeThread() {
            try {
                if (this.mServerSocket != null) {
                    this.mServerSocket.close();
                }
                this.mStatus = false;
            } catch (Exception e) {
                LogUtil.e(ConnectManager.Tag, "Close " + this.sThreadName + " fail");
                e.printStackTrace();
            }
        }

        public void run() {
            LogUtil.d(ConnectManager.Tag, "Begin to listen in " + this.sThreadName);
            while (this.mServerSocket != null && this.mStatus) {
                try {
                    Socket localSocket = this.mServerSocket.accept();
                    if (localSocket != null) {
                        LogUtil.d(ConnectManager.Tag, "One client connected in " + this.sThreadName);
                        if (this.mName.equals(CommonParams.SERVER_SOCKET_NAME)) {
                            MsgHandlerCenter.dispatchMessage(1003);
                        }
                        new ConnectSocket(this.mName, localSocket).startConmunication();
                    }
                } catch (Exception e) {
                    LogUtil.e(ConnectManager.Tag, "Get Exception in " + this.sThreadName);
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static ConnectManager newInstance() {
        if (sConnectManager == null) {
            synchronized (ConnectManager.class) {
                if (sConnectManager == null) {
                    sConnectManager = new ConnectManager();
                }
            }
        }
        return sConnectManager;
    }

    private ConnectManager() {
    }

    /* renamed from: a */
    public void setType(int type) {
        sType = type;
    }

    /* renamed from: b */
    public int getType() {
        return sType;
    }

    /* renamed from: c */
    public void startAcceptThread() {
        try {
            this.mCmdManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_WIFI_PORT, CommonParams.SERVER_SOCKET_NAME);
            this.mCmdManagerThread.start();
            this.mVideoManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_VIDEO_WIFI_PORT, CommonParams.SERVER_SOCKET_VIDEO_NAME);
            this.mVideoManagerThread.start();
            this.mAudioManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_AUDIO_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_NAME);
            this.mAudioManagerThread.start();
            this.mTTSManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_AUDIO_TTS_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_TTS_NAME);
            this.mTTSManagerThread.start();
            this.mAudioVRManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_AUDIO_VR_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_VR_NAME);
            this.mAudioVRManagerThread.start();
            this.mTouchManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_TOUCH_WIFI_PORT, CommonParams.SERVER_SOCKET_TOUCH_NAME);
            this.mTouchManagerThread.start();
            this.mDataManagerThread = new ConnectManagerThread(this, CommonParams.SOCKET_DATA_WIFI_PORT, CommonParams.SERVER_SOCKET_DATA_NAME);
            this.mDataManagerThread.start();
        } catch (Exception e) {
            LogUtil.e(Tag, "Start Accept Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void stopAcceptThread() {
        try {
            if (this.mCmdManagerThread != null) {
                this.mCmdManagerThread.closeThread();
                this.mCmdManagerThread = null;
            }
            if (this.mVideoManagerThread != null) {
                this.mVideoManagerThread.closeThread();
                this.mVideoManagerThread = null;
            }
            if (this.mAudioManagerThread != null) {
                this.mAudioManagerThread.closeThread();
                this.mAudioManagerThread = null;
            }
            if (this.mTTSManagerThread != null) {
                this.mTTSManagerThread.closeThread();
                this.mTTSManagerThread = null;
            }
            if (this.mAudioVRManagerThread != null) {
                this.mAudioVRManagerThread.closeThread();
                this.mAudioVRManagerThread = null;
            }
            if (this.mTouchManagerThread != null) {
                this.mTouchManagerThread.closeThread();
                this.mTouchManagerThread = null;
            }
            if (this.mDataManagerThread != null) {
                this.mDataManagerThread.closeThread();
                this.mDataManagerThread = null;
            }
            m4248e();
        } catch (Exception e) {
            LogUtil.e(Tag, "Stop Accept Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m4248e() {
        this.mCurrentSocketNum = 0;
        this.is = false;
        m4250f();
    }

    /* renamed from: f */
    public void m4250f() {
        try {
            if (this.mCMDConnectSocket != null) {
                this.mCMDConnectSocket.stopConmunication();
                this.mCMDConnectSocket = null;
            }
            if (this.mVideoConnectSocket != null) {
                this.mVideoConnectSocket.stopConmunication();
                this.mVideoConnectSocket = null;
            }
            if (this.mAudioConnectSocket != null) {
                this.mAudioConnectSocket.stopConmunication();
                this.mAudioConnectSocket = null;
            }
            if (this.mTTSConnectSocket != null) {
                this.mTTSConnectSocket.stopConmunication();
                this.mTTSConnectSocket = null;
            }
            if (this.mAudioVRConnectSocket != null) {
                this.mAudioVRConnectSocket.stopConmunication();
                this.mAudioVRConnectSocket = null;
            }
            if (this.mTouchConnectSocket != null) {
                this.mTouchConnectSocket.stopConmunication();
                this.mTouchConnectSocket = null;
            }
            if (this.mDataConnectSocket != null) {
                this.mDataConnectSocket.stopConmunication();
                this.mDataConnectSocket = null;
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "Stop Connect Socket Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public synchronized void initSocket(ConnectSocket connectSocket) {
        if (!connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
            this.mCurrentSocketNum++;
        }
        if (this.mCurrentSocketNum >= mTotalSocket) {
            ConnectClient.newInstance().setIS(true);
        }
        try {
            if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_NAME)) {
                this.mCMDConnectSocket = connectSocket;
            } else if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_VIDEO_NAME)) {
                this.mVideoConnectSocket = connectSocket;
            } else if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_AUDIO_NAME)) {
                this.mAudioConnectSocket = connectSocket;
            } else if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_AUDIO_TTS_NAME)) {
                this.mTTSConnectSocket = connectSocket;
            } else if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_AUDIO_VR_NAME)) {
                this.mAudioVRConnectSocket = connectSocket;
            } else if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
                this.mTouchConnectSocket = connectSocket;
            } else if (connectSocket.getSocketName().equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
                this.mDataConnectSocket = connectSocket;
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "Add ConnectSocket Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public boolean getIS() {
        return this.is;
    }

    /* renamed from: a */
    public void setIS(boolean is) {
        this.is = is;
    }

    /* renamed from: a */
    public int write(CarlifeCmdMessage msg) {
        if (this.mCMDConnectSocket != null) {
            return this.mCMDConnectSocket.send(msg);
        }
        LogUtil.e(Tag, "write error: connectSocket is null");
        return -1;
    }

    /* renamed from: a */
    public int m4236a(byte[] buffer, int len) {
        if (this.mVideoConnectSocket != null) {
            return this.mVideoConnectSocket.send(buffer, len);
        }
        LogUtil.e(Tag, "write error: video connectSocket is null");
        return -1;
    }

    /* renamed from: b */
    public int m4242b(byte[] buffer, int len) {
        if (this.mVideoConnectSocket != null) {
            return this.mVideoConnectSocket.receive(buffer, len);
        }
        LogUtil.e(Tag, "read error: video connectSocket is null");
        return -1;
    }

    /* renamed from: c */
    public int writeAudio(byte[] buffer, int len) {
        if (this.mAudioConnectSocket != null) {
            return this.mAudioConnectSocket.send(buffer, len);
        }
        LogUtil.e(Tag, "write error: audio connectSocket is null");
        return -1;
    }

    /* renamed from: d */
    public int readAudio(byte[] buffer, int len) {
        if (this.mAudioConnectSocket != null) {
            return this.mAudioConnectSocket.receive(buffer, len);
        }
        LogUtil.e(Tag, "read error: audio connectSocket is null");
        return -1;
    }

    /* renamed from: e */
    public int writeTTS(byte[] buffer, int len) {
        if (this.mTTSConnectSocket != null) {
            return this.mTTSConnectSocket.send(buffer, len);
        }
        LogUtil.e(Tag, "write error: tts connectSocket is null");
        return -1;
    }

    /* renamed from: f */
    public int readTTS(byte[] buffer, int len) {
        if (this.mTTSConnectSocket != null) {
            return this.mTTSConnectSocket.receive(buffer, len);
        }
        LogUtil.e(Tag, "read error: tts connectSocket is null");
        return -1;
    }

    /* renamed from: g */
    public int writeVR(byte[] buffer, int len) {
        if (this.mAudioVRConnectSocket != null) {
            return this.mAudioVRConnectSocket.send(buffer, len);
        }
        LogUtil.e(Tag, "write error: VR connectSocket is null");
        return -1;
    }

    /* renamed from: h */
    public int readVR(byte[] buffer, int len) {
        if (this.mAudioVRConnectSocket != null) {
            return this.mAudioVRConnectSocket.receive(buffer, len);
        }
        LogUtil.e(Tag, "read error: VR connectSocket is null");
        return -1;
    }

    /* renamed from: b */
    public int writeDate(CarlifeCmdMessage msg) {
        if (this.mDataConnectSocket != null) {
            return this.mDataConnectSocket.send(msg);
        }
        LogUtil.e(Tag, "write error: Date connectSocket is null");
        return -1;
    }

    /* renamed from: a */
    private boolean isBroadcastAddress(String ipAddr) {
        if (ipAddr.contains(Config.TRACE_TODAY_VISIT_SPLIT)) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private String getLocalHostIp() {
        LogUtil.d(Tag, "getLocalHostIp ");
        String broadcastAddress = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkCard = (NetworkInterface) en.nextElement();
                LogUtil.d(Tag, "name  : " + networkCard.getName());
                if (networkCard.getName().equals("wlan0") || networkCard.getName().equals("ap0")) {
                    for (InterfaceAddress networkCardAddress : networkCard.getInterfaceAddresses()) {
                        InetAddress address = networkCardAddress.getAddress();
                        if (!address.isLoopbackAddress()) {
                            String hostAddress = address.getHostAddress();
                            LogUtil.d(Tag, "hostAddress : " + hostAddress);
                            if (!isBroadcastAddress(hostAddress)) {
                                broadcastAddress = networkCardAddress.getBroadcast().getHostAddress();
                                LogUtil.d(Tag, "broadcastAddress : " + broadcastAddress);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            LogUtil.e(Tag, "获取本地ip地址失败");
            e.printStackTrace();
        }
        return broadcastAddress;
    }

    /* renamed from: h */
    public void startUDP() {
        if (this.f3342E) {
            try {
                LogUtil.d(Tag, "start udp send timer");
                this.mDatagramSocket = new DatagramSocket();
                this.mTimer = new Timer();
                this.mTimerTask = new ConnectManagerTask(this);
                this.mTimer.schedule(this.mTimerTask, Config.BPLUS_DELAY_TIME, 1000);
            } catch (Exception ex) {
                LogUtil.d(Tag, "startUdpSendTimer get exception");
                ex.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    public void stopUDP() {
        if (this.f3342E) {
            LogUtil.d(Tag, "stop udp send timer");
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
            if (this.mTimerTask != null) {
                this.mTimerTask.cancel();
                this.mTimerTask = null;
            }
        }
    }
}
