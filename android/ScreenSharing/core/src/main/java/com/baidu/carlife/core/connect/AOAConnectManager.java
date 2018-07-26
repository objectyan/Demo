package com.baidu.carlife.core.connect;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.mobstat.Config;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: AOAConnectManager */
/* renamed from: com.baidu.carlife.core.connect.a */
public class AOAConnectManager implements KeepClass {
    /* renamed from: L */
    private static final int f3261L = 100;
    /* renamed from: a */
    public static final int f3262a = 500;
    /* renamed from: b */
    private static final String Tag = "AOAConnectManager";
    /* renamed from: c */
    private static AOAConnectManager sAOAConnectManager = null;
    /* renamed from: k */
    private static final String AOAReadThreadTag = "AOAReadThread";
    /* renamed from: l */
    private static final String SocketReadThreadTag = "SocketReadThread";
    /* renamed from: m */
    private static final String LOCALHOST = "127.0.0.1";
    /* renamed from: n */
    private static final int f3268n = 100;
    /* renamed from: o */
    private static final int f3269o = 8;
    /* renamed from: p */
    private static final int f3270p = 4096;
    /* renamed from: q */
    private static final int f3271q = 327680;
    /* renamed from: r */
    private static final int f3272r = 327680;
    /* renamed from: s */
    private static int f3273s = 0;
    /* renamed from: t */
    private static int f3274t = 10240;
    /* renamed from: u */
    private static final int f3275u = 163840;
    /* renamed from: x */
    private static final int f3276x = 16384;
    /* renamed from: y */
    private static final int f3277y = 67108864;
    /* renamed from: A */
    private SocketReadThread mWifiReadThread = null;
    /* renamed from: B */
    private SocketReadThread mVideoReadThread = null;
    /* renamed from: C */
    private SocketReadThread mAudioReadThread = null;
    /* renamed from: D */
    private SocketReadThread mTTSReadThread = null;
    /* renamed from: E */
    private SocketReadThread mVRReadThread = null;
    /* renamed from: F */
    private SocketReadThread mTouchReadThread = null;
    /* renamed from: G */
    private SocketReadThread mDataReadThread = null;
    /* renamed from: H */
    private Timer mTimer = null;
    /* renamed from: I */
    private TimerTask mTimerTask = null;
    /* renamed from: J */
    private int mNumOfHeartBeat = 0;
    /* renamed from: K */
    private int mOldNumOfHeartBeat = -1;
    /* renamed from: d */
    private Context mContext = null;
    /* renamed from: e */
    private UsbManager mUsbManager = null;
    /* renamed from: f */
    private UsbAccessory mUsbAccessory = null;
    /* renamed from: g */
    private ParcelFileDescriptor mParcelFileDescriptor = null;
    /* renamed from: h */
    private FileDescriptor mFileDescriptor = null;
    /* renamed from: i */
    private FileOutputStream mFileOutputStream = null;
    /* renamed from: j */
    private FileInputStream mFileInputStream = null;
    /* renamed from: v */
    private Thread f3296v = null;
    /* renamed from: w */
    private Thread mWriteThread = null;
    /* renamed from: z */
    private AOAReadThread f3298z = null;

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$1 */
    class AOAConnectManagerTask extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager mAOAConnectManager;

        AOAConnectManagerTask(AOAConnectManager this$0) {
            this.mAOAConnectManager = this$0;
        }

        public void run() {
            LogUtil.e(AOAConnectManager.Tag, "timeout 1");
            if (this.mAOAConnectManager.mTimer != null) {
                LogUtil.e(AOAConnectManager.Tag, "timeout 2");
                LogUtil.m4440c(AOAConnectManager.Tag, "numOfHeartBeat = " + this.mAOAConnectManager.mNumOfHeartBeat + ", oldNumOfHeartBeat = " + this.mAOAConnectManager.mOldNumOfHeartBeat);
                if (this.mAOAConnectManager.mOldNumOfHeartBeat == this.mAOAConnectManager.mNumOfHeartBeat) {
                    ConnectClient.newInstance().setIS(false);
                    this.mAOAConnectManager.stopTimer();
                }
                this.mAOAConnectManager.mOldNumOfHeartBeat = this.mAOAConnectManager.mNumOfHeartBeat;
            }
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$2 */
    class WriteThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager mAOAConnectManager;

        WriteThread(AOAConnectManager this$0) {
            this.mAOAConnectManager = this$0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r14 = this;
            r9 = 0;
            r1 = 0;
            r0 = -1;
            r8 = -1;
            r6 = android.os.SystemClock.elapsedRealtime();
        L_0x0008:
            r10 = r14.mAOAConnectManager;	 Catch:{ Exception -> 0x0097 }
            r9 = r10.m4155j();	 Catch:{ Exception -> 0x0097 }
            if (r9 != 0) goto L_0x004b;
        L_0x0010:
            r4 = android.os.SystemClock.elapsedRealtime();
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;
            r11.<init>();
            r12 = "Cnt = ";
            r11 = r11.append(r12);
            r11 = r11.append(r0);
            r11 = r11.toString();
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;
            r11.<init>();
            r12 = "Write Time = ";
            r11 = r11.append(r12);
            r12 = r4 - r6;
            r11 = r11.append(r12);
            r11 = r11.toString();
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            return;
        L_0x004b:
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0097 }
            r11.<init>();	 Catch:{ Exception -> 0x0097 }
            r12 = "write data: ";
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x0097 }
            r12 = 0;
            r13 = 20;
            r12 = r9.substring(r12, r13);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.toString();	 Catch:{ Exception -> 0x0097 }
            com.baidu.carlife.core.LogUtil.d(r10, r11);	 Catch:{ Exception -> 0x0097 }
            r1 = r9.getBytes();	 Catch:{ Exception -> 0x0097 }
            r10 = r14.mAOAConnectManager;	 Catch:{ Exception -> 0x0097 }
            r11 = 163840; // 0x28000 float:2.29589E-40 double:8.09477E-319;
            r8 = r10.bulkTransferOut(r1, r11);	 Catch:{ Exception -> 0x0097 }
            if (r8 >= 0) goto L_0x00b9;
        L_0x007b:
            r10 = "AOAConnectManager";
            r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0097 }
            r11.<init>();	 Catch:{ Exception -> 0x0097 }
            r12 = "write data error, ret = ";
            r11 = r11.append(r12);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.append(r8);	 Catch:{ Exception -> 0x0097 }
            r11 = r11.toString();	 Catch:{ Exception -> 0x0097 }
            com.baidu.carlife.core.LogUtil.e(r10, r11);	 Catch:{ Exception -> 0x0097 }
            goto L_0x0010;
        L_0x0097:
            r2 = move-exception;
            r10 = r14.mAOAConnectManager;	 Catch:{ IOException -> 0x00bd }
            r10 = r10.mFileOutputStream;	 Catch:{ IOException -> 0x00bd }
            r10.close();	 Catch:{ IOException -> 0x00bd }
        L_0x00a1:
            r10 = "AOAConnectManager";
            r11 = "get exception when write";
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            r10 = "AOAConnectManager";
            r11 = r2.toString();
            com.baidu.carlife.core.LogUtil.e(r10, r11);
            r2.printStackTrace();
            goto L_0x0010;
        L_0x00b9:
            r0 = r0 + 1;
            goto L_0x0008;
        L_0x00bd:
            r3 = move-exception;
            r3.printStackTrace();
            goto L_0x00a1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.carlife.core.connect.a.2.run():void");
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$3 */
    class ReadThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager mAOAConnectManager;

        ReadThread(AOAConnectManager this$0) {
            this.mAOAConnectManager = this$0;
        }

        public void run() {
            try {
                LogUtil.e(AOAConnectManager.Tag, "sleep 1s before read...");
                ReadThread.sleep(1000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            byte[] data = new byte[AOAConnectManager.f3275u];
            int cnt = -1;
            long mStartTime = SystemClock.elapsedRealtime();
            String str = null;
            while (true) {
                int ret = this.mAOAConnectManager.bulkTransferIn(data, AOAConnectManager.f3275u);
                if (ret != AOAConnectManager.f3275u) {
                    LogUtil.e(AOAConnectManager.Tag, "read data error, ret = " + ret);
                    return;
                }
                cnt++;
                try {
                    if (cnt >= AOAConnectManager.f3274t) {
                        LogUtil.e(AOAConnectManager.Tag, "Read Time = " + (SystemClock.elapsedRealtime() - mStartTime));
                    }
                    str = new String(data);
                    try {
                        LogUtil.d(AOAConnectManager.Tag, "read data:" + cnt + Config.TRACE_TODAY_VISIT_SPLIT + ret + Config.TRACE_TODAY_VISIT_SPLIT + str.substring(0, 20));
                    } catch (Exception e3) {
                        LogUtil.e(AOAConnectManager.Tag, "get exception when read");
                    }
                } catch (Exception e4) {
                    LogUtil.e(AOAConnectManager.Tag, e4.toString());
                }
            }
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$a */
    private class AOAReadThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ AOAConnectManager mAOAConnectManager;
        /* renamed from: b */
        private boolean f3210b = false;
        /* renamed from: c */
        private byte[] f3211c = new byte[16384];
        /* renamed from: d */
        private byte[] f3212d = new byte[16384];
        /* renamed from: e */
        private int f3213e = -1;
        /* renamed from: f */
        private int f3214f = -1;
        /* renamed from: g */
        private int f3215g = 0;
        /* renamed from: h */
        private int f3216h = -1;

        public AOAReadThread(AOAConnectManager AOAConnectManager) {
            this.mAOAConnectManager = AOAConnectManager;
            LogUtil.d(AOAConnectManager.Tag, "ReadThread Created");
            setName(AOAConnectManager.AOAReadThreadTag);
        }

        /* renamed from: a */
        public void m4106a() {
            this.f3210b = false;
        }

        public void run() {
            this.f3210b = true;
            LogUtil.d(AOAConnectManager.Tag, "Begin to read data by AOA");
            try {
                AOAReadThread.sleep(100);
                while (this.f3210b) {
                    if (!this.f3210b) {
                        LogUtil.e(AOAConnectManager.Tag, "read data cancled");
                    } else if (this.mAOAConnectManager.bulkTransferIn(this.f3212d, 8) < 0) {
                        LogUtil.e(AOAConnectManager.Tag, "bulkTransferIn fail 1");
                    } else {
                        this.f3213e = ByteConvert.m4178b(new byte[]{this.f3212d[0], this.f3212d[1], this.f3212d[2], this.f3212d[3]});
                        this.f3214f = ByteConvert.m4178b(new byte[]{this.f3212d[4], this.f3212d[5], this.f3212d[6], this.f3212d[7]});
                        LogUtil.d(AOAConnectManager.Tag, "typeMsg = " + this.f3213e + ", lenMsg = " + this.f3214f);
                        int tatalChannel = 6;
                        if (CommonParams.jw) {
                            tatalChannel = 7;
                        }
                        if (this.f3213e < 1 || this.f3213e > tatalChannel || this.f3214f < 0 || this.f3214f > AOAConnectManager.f3277y) {
                            LogUtil.e(AOAConnectManager.Tag, "typeMsg or lenMsg is error");
                            ConnectClient.newInstance().setIS(false);
                        } else {
                            if (this.f3211c.length < this.f3214f) {
                                this.f3211c = new byte[this.f3214f];
                            }
                            if (this.mAOAConnectManager.bulkTransferIn(this.f3211c, this.f3214f) < 0) {
                                LogUtil.e(AOAConnectManager.Tag, "bulkTransferIn fail 2");
                            } else {
                                this.f3216h = -1;
                                while (this.f3210b) {
                                    this.f3215g++;
                                    if (this.f3215g >= 100) {
                                        LogUtil.e(AOAConnectManager.Tag, "write data to socket fail...retry");
                                        this.f3215g = 0;
                                        this.f3210b = false;
                                    } else {
                                        switch (this.f3213e) {
                                            case 1:
                                                this.f3216h = this.mAOAConnectManager.mWifiReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 2:
                                                this.f3216h = this.mAOAConnectManager.mVideoReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 3:
                                                this.f3216h = this.mAOAConnectManager.mAudioReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 4:
                                                this.f3216h = this.mAOAConnectManager.mTTSReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 5:
                                                this.f3216h = this.mAOAConnectManager.mVRReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 6:
                                                this.f3216h = this.mAOAConnectManager.mTouchReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            case 7:
                                                this.f3216h = this.mAOAConnectManager.mDataReadThread.send(this.f3211c, 0, this.f3214f);
                                                break;
                                            default:
                                                LogUtil.e(AOAConnectManager.Tag, "AOAReadThread typeMsg error");
                                                this.f3210b = false;
                                                break;
                                        }
                                        if (this.f3216h < 0) {
                                            AOAReadThread.sleep(100);
                                        } else {
                                            this.f3215g = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.mAOAConnectManager.unInit();
                }
                this.mAOAConnectManager.unInit();
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.Tag, "Exception when read data by AOA");
                e.printStackTrace();
            }
        }
    }

    /* compiled from: AOAConnectManager */
    /* renamed from: com.baidu.carlife.core.connect.a$b */
    private class SocketReadThread extends Thread {
        /* renamed from: a */
        InetAddress mInetAddress = null;
        /* renamed from: b */
        final /* synthetic */ AOAConnectManager mAOAConnectManager;
        /* renamed from: c */
        private boolean mIsOpen = false;
        /* renamed from: d */
        private int mPort = -1;
        /* renamed from: e */
        private String mName = null;
        /* renamed from: f */
        private String Tag = null;
        /* renamed from: g */
        private Socket mSocket = null;
        /* renamed from: h */
        private BufferedInputStream mBufferedInputStream = null;
        /* renamed from: i */
        private BufferedOutputStream mBufferedOutputStream = null;
        /* renamed from: j */
        private int f3226j = -1;
        /* renamed from: k */
        private int f3227k = -1;
        /* renamed from: l */
        private int f3228l = -1;
        /* renamed from: m */
        private byte[] mReceiveData = new byte[12];
        /* renamed from: n */
        private byte[] mSocketByteData = new byte[8];
        /* renamed from: o */
        private int mRetryNum = 0;

        public SocketReadThread(AOAConnectManager AOAConnectManager, int port, String name) {
            this.mAOAConnectManager = AOAConnectManager;
            try {
                this.Tag = name + AOAConnectManager.SocketReadThreadTag;
                setName(this.Tag);
                LogUtil.d(AOAConnectManager.Tag, "Create " + this.Tag);
                this.mPort = port;
                this.mName = name;
                this.mIsOpen = true;
                if (this.mName.equals(CommonParams.SERVER_SOCKET_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(1), 0, this.mSocketByteData, 0, 4);
                } else if (this.mName.equals(CommonParams.SERVER_SOCKET_VIDEO_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(2), 0, this.mSocketByteData, 0, 4);
                } else if (this.mName.equals(CommonParams.SERVER_SOCKET_AUDIO_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(3), 0, this.mSocketByteData, 0, 4);
                } else if (this.mName.equals(CommonParams.SERVER_SOCKET_AUDIO_TTS_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(4), 0, this.mSocketByteData, 0, 4);
                } else if (this.mName.equals(CommonParams.SERVER_SOCKET_AUDIO_VR_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(5), 0, this.mSocketByteData, 0, 4);
                } else if (this.mName.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(6), 0, this.mSocketByteData, 0, 4);
                } else if (this.mName.equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
                    System.arraycopy(ByteConvert.m4175a(7), 0, this.mSocketByteData, 0, 4);
                }
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.Tag, "Create " + this.Tag + " fail");
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public void close() {
            try {
                if (this.mSocket != null) {
                    this.mSocket.close();
                    this.mSocket = null;
                }
                if (this.mBufferedInputStream != null) {
                    this.mBufferedInputStream.close();
                    this.mBufferedInputStream = null;
                }
                if (this.mBufferedOutputStream != null) {
                    this.mBufferedOutputStream.close();
                    this.mBufferedOutputStream = null;
                }
                this.mIsOpen = false;
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.Tag, "Close " + this.Tag + " fail");
                e.printStackTrace();
            }
        }

        /* renamed from: a */
        public int receive(byte[] buffer, int offset, int len) {
            int r = -1;
            try {
                if (this.mBufferedInputStream != null) {
                    int cnt = len;
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = this.mBufferedInputStream.read(buffer, offset + dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            LogUtil.e(AOAConnectManager.Tag, this.mName + " Receive Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        return dataLen;
                    }
                    LogUtil.e(AOAConnectManager.Tag, this.mName + " Receive Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                LogUtil.e(AOAConnectManager.Tag, this.mName + " Receive Data Fail, mInputStream is null");
                throw new IOException();
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.Tag, this.mName + " IOException, Receive Data Fail");
                ConnectClient.newInstance().setIS(false);
                e.printStackTrace();
                return r;
            }
        }

        /* renamed from: b */
        public int send(byte[] buffer, int offset, int len) {
            try {
                if (this.mBufferedOutputStream != null) {
                    this.mBufferedOutputStream.write(buffer, offset, len);
                    this.mBufferedOutputStream.flush();
                    return len;
                }
                LogUtil.e(AOAConnectManager.Tag, this.mName + " Send Data Fail, mOutputStream is null");
                throw new IOException();
            } catch (Exception e) {
                LogUtil.e(AOAConnectManager.Tag, this.mName + " IOException, Send Data Fail");
                e.printStackTrace();
                return -1;
            }
        }

        public void run() {
            while (this.mIsOpen) {
                try {
                    SocketReadThread.sleep(100);
                    this.mRetryNum++;
                    LogUtil.d(AOAConnectManager.Tag, "Try to connect to socket...retry = " + this.mRetryNum);
                    if (this.mRetryNum >= 100) {
                        LogUtil.d(AOAConnectManager.Tag, "connect to socket fail");
                        this.mRetryNum = 0;
                        this.mIsOpen = false;
                        break;
                    }
                    this.mInetAddress = InetAddress.getByName(AOAConnectManager.LOCALHOST);
                    this.mSocket = new Socket(this.mInetAddress, this.mPort);
                    if (this.mSocket != null) {
                        LogUtil.d(AOAConnectManager.Tag, "Connected to: " + this.mSocket.toString());
                    }
                    this.mSocket.setTcpNoDelay(true);
                    this.mSocket.setSendBufferSize(327680);
                    this.mSocket.setReceiveBufferSize(327680);
                    this.mBufferedInputStream = new BufferedInputStream(this.mSocket.getInputStream());
                    this.mBufferedOutputStream = new BufferedOutputStream(this.mSocket.getOutputStream());
                } catch (Exception e) {
                    LogUtil.e(AOAConnectManager.Tag, "Create " + this.Tag + " fail 1");
                    e.printStackTrace();
                }
            }
            do {
                try {
                    if (this.mSocket != null && this.mIsOpen) {
                        if (!this.mSocket.isConnected()) {
                            LogUtil.e(AOAConnectManager.Tag, "socket is disconnected when read data");
                            break;
                        }
                        if (!this.mName.equals(CommonParams.SERVER_SOCKET_NAME) && !this.mName.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME) && !this.mName.equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
                            if (receive(this.mReceiveData, 0, 12) < 0) {
                                break;
                            }
                            this.f3226j = 12;
                            this.f3227k = ByteConvert.m4178b(new byte[]{this.mReceiveData[0], this.mReceiveData[1], this.mReceiveData[2], this.mReceiveData[3]});
                        } else if (receive(this.mReceiveData, 0, 8) < 0) {
                            break;
                        } else {
                            this.f3226j = 8;
                            this.f3227k = ByteConvert.m4188d(new byte[]{this.mReceiveData[0], this.mReceiveData[1]});
                        }
                        LogUtil.d(AOAConnectManager.Tag, "Channel = " + this.mName + ", lenMsgHead = " + this.f3226j + ", lenMsgData = " + this.f3227k);
                        System.arraycopy(ByteConvert.m4175a(this.f3226j + this.f3227k), 0, this.mSocketByteData, 4, 4);
                        this.f3228l = this.f3226j + this.f3227k;
                        if (this.mReceiveData.length < this.f3228l) {
                            byte[] tmpMsg = this.mReceiveData;
                            this.mReceiveData = new byte[this.f3228l];
                            System.arraycopy(tmpMsg, 0, this.mReceiveData, 0, this.f3226j);
                        }
                        if (receive(this.mReceiveData, this.f3226j, this.f3227k) < 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception ex) {
                    LogUtil.e(AOAConnectManager.Tag, "get Exception in " + this.Tag);
                    ex.printStackTrace();
                    return;
                }
            }
            while (this.mAOAConnectManager.bulkTransferOut(this.mSocketByteData, 8, this.mReceiveData, this.f3228l) >= 0);
            LogUtil.e(AOAConnectManager.Tag, "bulkTransferOut fail");
            this.mAOAConnectManager.unInit();
        }
    }

    /* renamed from: a */
    public static AOAConnectManager newInstance() {
        if (sAOAConnectManager == null) {
            synchronized (AOAConnectManager.class) {
                if (sAOAConnectManager == null) {
                    sAOAConnectManager = new AOAConnectManager();
                }
            }
        }
        return sAOAConnectManager;
    }

    private AOAConnectManager() {
    }

    /* renamed from: a */
    public void init(Context context, UsbAccessory accessory) {
        LogUtil.e(Tag, "init");
        this.mContext = context;
        this.mUsbManager = (UsbManager) this.mContext.getSystemService(Context.USB_SERVICE);
        this.mUsbAccessory = accessory;
        if (this.mUsbAccessory == null) {
            LogUtil.e(Tag, "mUsbAccessory is null");
        } else if (ConnectClient.newInstance().getUSBCableIsConn()) {
            try {
                this.mParcelFileDescriptor = this.mUsbManager.openAccessory(this.mUsbAccessory);
                this.mFileDescriptor = this.mParcelFileDescriptor.getFileDescriptor();
                this.mFileOutputStream = new FileOutputStream(this.mFileDescriptor);
                this.mFileInputStream = new FileInputStream(this.mFileDescriptor);
                ConnectManager.newInstance().setType(2);
                startSocketReadThread();
                startAOAReadThread();
            } catch (Exception ex) {
                LogUtil.e(Tag, "get fd fail");
                ex.printStackTrace();
            }
        } else {
            LogUtil.e(Tag, "usb is not connected");
        }
    }

    /* renamed from: b */
    public void unInit() {
        LogUtil.e(Tag, "uninit");
        try {
            if (this.mFileOutputStream != null) {
                this.mFileOutputStream.close();
                this.mFileOutputStream = null;
            }
            if (this.mFileInputStream != null) {
                this.mFileInputStream.close();
                this.mFileInputStream = null;
            }
            if (this.mParcelFileDescriptor != null) {
                this.mParcelFileDescriptor.close();
                this.mParcelFileDescriptor = null;
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "uninit fail");
        }
        this.mUsbAccessory = null;
        this.mFileDescriptor = null;
        ConnectManager.newInstance().setType(1);
        stopReadThread();
        stopAOAReadThread();
    }

    /* renamed from: b */
    private int bulkTransferIn(byte[] data, int len) {
        try {
            if (this.mFileInputStream == null) {
                LogUtil.e(Tag, "mFin is null");
                throw new IOException();
            }
            int cnt = len;
            int dataLen = 0;
            while (cnt > 0) {
                int ret = this.mFileInputStream.read(data, dataLen, 16384);
                if (ret > 0) {
                    cnt -= ret;
                    dataLen += ret;
                } else {
                    LogUtil.e(Tag, "bulkTransferIn error 1: ret = " + ret);
                    throw new IOException();
                }
            }
            if (dataLen == len) {
                return dataLen;
            }
            LogUtil.e(Tag, "bulkTransferIn error 3: dataLen = " + dataLen + ", len = " + len);
            throw new IOException();
        } catch (Exception e) {
            LogUtil.e(Tag, "bulkTransferIn catch exception");
            ConnectClient.newInstance().setIS(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public int bulkTransferOut(byte[] data, int len) {
        try {
            if (this.mFileOutputStream == null) {
                LogUtil.e(Tag, "mFin is null");
                throw new IOException();
            }
            this.mFileOutputStream.write(data, 0, len);
            return len;
        } catch (Exception e) {
            LogUtil.e(Tag, "bulkTransferOut catch exception");
            ConnectClient.newInstance().setIS(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public synchronized int bulkTransferOut(byte[] head, int lenHead, byte[] msg, int lenMsg) {
        int i = -1;
        synchronized (this) {
            this.mNumOfHeartBeat++;
            this.mNumOfHeartBeat %= 65536;
            if (bulkTransferOut(head, lenHead) < 0) {
                LogUtil.e(Tag, "bulkTransferOut fail 1");
            } else if (bulkTransferOut(msg, lenMsg) < 0) {
                LogUtil.e(Tag, "bulkTransferOut fail 2");
            } else {
                i = lenHead + lenMsg;
            }
        }
        return i;
    }

    /* renamed from: c */
    public void startAOAReadThread() {
        try {
            this.f3298z = new AOAReadThread(this);
            this.f3298z.start();
        } catch (Exception e) {
            LogUtil.e(Tag, "Start AOAReadThread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void stopAOAReadThread() {
        try {
            if (this.f3298z != null) {
                this.f3298z.m4106a();
                this.f3298z = null;
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "Stop AOAReadThread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void startSocketReadThread() {
        try {
            this.mWifiReadThread = new SocketReadThread(this, CommonParams.SOCKET_WIFI_PORT, CommonParams.SERVER_SOCKET_NAME);
            this.mWifiReadThread.start();
            this.mVideoReadThread = new SocketReadThread(this, CommonParams.SOCKET_VIDEO_WIFI_PORT, CommonParams.SERVER_SOCKET_VIDEO_NAME);
            this.mVideoReadThread.start();
            this.mAudioReadThread = new SocketReadThread(this, CommonParams.SOCKET_AUDIO_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_NAME);
            this.mAudioReadThread.start();
            this.mTTSReadThread = new SocketReadThread(this, CommonParams.SOCKET_AUDIO_TTS_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_TTS_NAME);
            this.mTTSReadThread.start();
            this.mVRReadThread = new SocketReadThread(this, CommonParams.SOCKET_AUDIO_VR_WIFI_PORT, CommonParams.SERVER_SOCKET_AUDIO_VR_NAME);
            this.mVRReadThread.start();
            this.mTouchReadThread = new SocketReadThread(this, CommonParams.SOCKET_TOUCH_WIFI_PORT, CommonParams.SERVER_SOCKET_TOUCH_NAME);
            this.mTouchReadThread.start();
            this.mDataReadThread = new SocketReadThread(this, CommonParams.SOCKET_DATA_WIFI_PORT, CommonParams.SERVER_SOCKET_DATA_NAME);
            this.mDataReadThread.start();
        } catch (Exception e) {
            LogUtil.e(Tag, "Start Read Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void stopReadThread() {
        try {
            if (this.mWifiReadThread != null) {
                this.mWifiReadThread.close();
                this.mWifiReadThread = null;
            }
            if (this.mVideoReadThread != null) {
                this.mVideoReadThread.close();
                this.mVideoReadThread = null;
            }
            if (this.mAudioReadThread != null) {
                this.mAudioReadThread.close();
                this.mAudioReadThread = null;
            }
            if (this.mTTSReadThread != null) {
                this.mTTSReadThread.close();
                this.mTTSReadThread = null;
            }
            if (this.mVRReadThread != null) {
                this.mVRReadThread.close();
                this.mVRReadThread = null;
            }
            if (this.mTouchReadThread != null) {
                this.mTouchReadThread.close();
                this.mTouchReadThread = null;
            }
            if (this.mDataReadThread != null) {
                this.mDataReadThread.close();
                this.mDataReadThread = null;
            }
        } catch (Exception e) {
            LogUtil.e(Tag, "Stop Read Thread Fail");
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public void startTimer() {
        try {
            LogUtil.e(Tag, "start timer");
            this.mNumOfHeartBeat = 0;
            this.mOldNumOfHeartBeat = -1;
            this.mTimer = new Timer();
            this.mTimerTask = new AOAConnectManagerTask(this);
            this.mTimer.schedule(this.mTimerTask, 1500, 500);
        } catch (Exception ex) {
            LogUtil.e(Tag, "start timer get exception");
            ex.printStackTrace();
        }
    }

    /* renamed from: h */
    public void stopTimer() {
        LogUtil.e(Tag, "timer Stop");
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
            this.mTimerTask = null;
        }
        this.mNumOfHeartBeat = 0;
        this.mOldNumOfHeartBeat = -1;
    }

    /* renamed from: j */
    private String m4155j() {
        if (f3273s >= f3274t) {
            return null;
        }
        char c = (char) ((f3273s % 26) + 97);
        String ts = "Msg Num:" + Integer.toString(f3273s);
        int len = f3275u - ts.length();
        StringBuffer sb = new StringBuffer(ts);
        for (int j = 0; j < len; j++) {
            sb.append(c);
        }
        f3273s++;
        return sb.substring(0);
    }

    /* renamed from: k */
    private void startWriteThread() {
        this.mWriteThread = new WriteThread(this);
        this.mWriteThread.setName("WriteThread");
        this.mWriteThread.start();
    }

    /* renamed from: l */
    private void startReadThread() {
        this.f3296v = new ReadThread(this);
        this.f3296v.setName("ReadThread");
        this.f3296v.start();
    }
}
