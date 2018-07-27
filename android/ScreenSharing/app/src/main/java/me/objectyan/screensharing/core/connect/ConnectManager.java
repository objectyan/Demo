package me.objectyan.screensharing.core.connect;

import android.util.Log;

import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgHandlerCenter;


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


public class ConnectManager {

    public static final String Tag = "ConnectManager";

    public static final String TagAcceptThread = "AcceptThread";

    public static int sType = 1;

    private static ConnectManager sConnectManager = null;

    private static int mTotalSocket = 6;

    private Timer mTimer = null;

    private TimerTask mTimerTask = null;

    private DatagramSocket mDatagramSocket = null;

    private DatagramPacket mDatagramPacket = null;

    private boolean f3342E = false;

    private ConnectManagerThread mCmdManagerThread = null;

    private ConnectManagerThread mVideoManagerThread = null;

    private ConnectManagerThread mAudioManagerThread = null;

    private ConnectManagerThread mTTSManagerThread = null;

    private ConnectManagerThread mAudioVRManagerThread = null;

    private ConnectManagerThread mTouchManagerThread = null;

    private ConnectManagerThread mDataManagerThread = null;

    private ConnectSocket mCMDConnectSocket = null;

    private ConnectSocket mVideoConnectSocket = null;

    private ConnectSocket mAudioConnectSocket = null;

    private ConnectSocket mTTSConnectSocket = null;

    private ConnectSocket mAudioVRConnectSocket = null;

    private ConnectSocket mTouchConnectSocket = null;

    private ConnectSocket mDataConnectSocket = null;

    private int mCurrentSocketNum = 0;

    private boolean is = false;


    class ConnectManagerTask extends TimerTask {

        final ConnectManager mConnectManager;

        ConnectManagerTask(ConnectManager this$0) {
            this.mConnectManager = this$0;
        }

        public void run() {
            String ipv4Address = this.mConnectManager.getLocalHostIp();
            if (ipv4Address != null) {
                Log.d(ConnectManager.Tag, "send udp address : " + ipv4Address);
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


    private class ConnectManagerThread extends Thread {

        final ConnectManager mConnectManager;

        private ServerSocket mServerSocket = null;

        private boolean mStatus = false;

        private int mPort = -1;

        private String mName = null;

        private String sThreadName = null;

        public ConnectManagerThread(ConnectManager connectManager, int port, String name) {
            this.mConnectManager = connectManager;
            try {
                this.sThreadName = name + ConnectManager.TagAcceptThread;
                setName(this.sThreadName);
                Log.d(ConnectManager.Tag, "Create " + this.sThreadName);
                this.mPort = port;
                this.mName = name;
                this.mServerSocket = new ServerSocket(this.mPort);
                this.mStatus = true;
            } catch (Exception e) {
                Log.e(ConnectManager.Tag, "Create " + this.sThreadName + " fail");
                e.printStackTrace();
            }
        }


        public void closeThread() {
            try {
                if (this.mServerSocket != null) {
                    this.mServerSocket.close();
                }
                this.mStatus = false;
            } catch (Exception e) {
                Log.e(ConnectManager.Tag, "Close " + this.sThreadName + " fail");
                e.printStackTrace();
            }
        }

        public void run() {
            Log.d(ConnectManager.Tag, "Begin to listen in " + this.sThreadName);
            while (this.mServerSocket != null && this.mStatus) {
                try {
                    Socket localSocket = this.mServerSocket.accept();
                    if (localSocket != null) {
                        Log.d(ConnectManager.Tag, "One client connected in " + this.sThreadName);
                        if (this.mName.equals(CommonParams.SERVER_SOCKET_NAME)) {
                            MsgHandlerCenter.dispatchMessage(1003);
                        }
                        new ConnectSocket(this.mName, localSocket).startConmunication();
                    }
                } catch (Exception e) {
                    Log.e(ConnectManager.Tag, "Get Exception in " + this.sThreadName);
                    e.printStackTrace();
                }
            }
        }
    }


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


    public void setType(int type) {
        sType = type;
    }


    public int getType() {
        return sType;
    }


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
            Log.e(Tag, "Start Accept Thread Fail");
            e.printStackTrace();
        }
    }


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
            Log.e(Tag, "Stop Accept Thread Fail");
            e.printStackTrace();
        }
    }


    public void m4248e() {
        this.mCurrentSocketNum = 0;
        this.is = false;
        m4250f();
    }


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
            Log.e(Tag, "Stop Connect Socket Fail");
            e.printStackTrace();
        }
    }


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
            Log.e(Tag, "Add ConnectSocket Fail");
            e.printStackTrace();
        }
    }


    public boolean getIS() {
        return this.is;
    }


    public void setIS(boolean is) {
        this.is = is;
    }


    public int write(CarlifeCmdMessage msg) {
        if (this.mCMDConnectSocket != null) {
            return this.mCMDConnectSocket.send(msg);
        }
        Log.e(Tag, "write error: connectSocket is null");
        return -1;
    }


    public int writeVideo(byte[] buffer, int len) {
        if (this.mVideoConnectSocket != null) {
            return this.mVideoConnectSocket.send(buffer, len);
        }
        Log.e(Tag, "write error: video connectSocket is null");
        return -1;
    }


    public int readVideo(byte[] buffer, int len) {
        if (this.mVideoConnectSocket != null) {
            return this.mVideoConnectSocket.receive(buffer, len);
        }
        Log.e(Tag, "read error: video connectSocket is null");
        return -1;
    }


    public int writeAudio(byte[] buffer, int len) {
        if (this.mAudioConnectSocket != null) {
            return this.mAudioConnectSocket.send(buffer, len);
        }
        Log.e(Tag, "write error: audio connectSocket is null");
        return -1;
    }


    public int readAudio(byte[] buffer, int len) {
        if (this.mAudioConnectSocket != null) {
            return this.mAudioConnectSocket.receive(buffer, len);
        }
        Log.e(Tag, "read error: audio connectSocket is null");
        return -1;
    }


    public int writeTTS(byte[] buffer, int len) {
        if (this.mTTSConnectSocket != null) {
            return this.mTTSConnectSocket.send(buffer, len);
        }
        Log.e(Tag, "write error: tts connectSocket is null");
        return -1;
    }


    public int readTTS(byte[] buffer, int len) {
        if (this.mTTSConnectSocket != null) {
            return this.mTTSConnectSocket.receive(buffer, len);
        }
        Log.e(Tag, "read error: tts connectSocket is null");
        return -1;
    }


    public int writeVR(byte[] buffer, int len) {
        if (this.mAudioVRConnectSocket != null) {
            return this.mAudioVRConnectSocket.send(buffer, len);
        }
        Log.e(Tag, "write error: VR connectSocket is null");
        return -1;
    }


    public int readVR(byte[] buffer, int len) {
        if (this.mAudioVRConnectSocket != null) {
            return this.mAudioVRConnectSocket.receive(buffer, len);
        }
        Log.e(Tag, "read error: VR connectSocket is null");
        return -1;
    }


    public int writeDate(CarlifeCmdMessage msg) {
        if (this.mDataConnectSocket != null) {
            return this.mDataConnectSocket.send(msg);
        }
        Log.e(Tag, "write error: Date connectSocket is null");
        return -1;
    }


    private boolean isBroadcastAddress(String ipAddr) {
        if (ipAddr.contains(":")) {
            return true;
        }
        return false;
    }


    private String getLocalHostIp() {
        Log.d(Tag, "getLocalHostIp ");
        String broadcastAddress = null;
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface networkCard = (NetworkInterface) en.nextElement();
                Log.d(Tag, "name  : " + networkCard.getName());
                if (networkCard.getName().equals("wlan0") || networkCard.getName().equals("ap0")) {
                    for (InterfaceAddress networkCardAddress : networkCard.getInterfaceAddresses()) {
                        InetAddress address = networkCardAddress.getAddress();
                        if (!address.isLoopbackAddress()) {
                            String hostAddress = address.getHostAddress();
                            Log.d(Tag, "hostAddress : " + hostAddress);
                            if (!isBroadcastAddress(hostAddress)) {
                                broadcastAddress = networkCardAddress.getBroadcast().getHostAddress();
                                Log.d(Tag, "broadcastAddress : " + broadcastAddress);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            Log.e(Tag, "获取本地ip地址失败");
            e.printStackTrace();
        }
        return broadcastAddress;
    }


    public void startUDP() {
        if (this.f3342E) {
            try {
                Log.d(Tag, "start udp send timer");
                this.mDatagramSocket = new DatagramSocket();
                this.mTimer = new Timer();
                this.mTimerTask = new ConnectManagerTask(this);
                this.mTimer.schedule(this.mTimerTask, 5000L, 1000);
            } catch (Exception ex) {
                Log.d(Tag, "startUdpSendTimer get exception");
                ex.printStackTrace();
            }
        }
    }


    public void stopUDP() {
        if (this.f3342E) {
            Log.d(Tag, "stop udp send timer");
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
