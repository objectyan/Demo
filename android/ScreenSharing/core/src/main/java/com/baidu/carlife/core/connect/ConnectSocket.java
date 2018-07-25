package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/* compiled from: ConnectSocket */
/* renamed from: com.baidu.carlife.core.connect.g */
public class ConnectSocket implements KeepClass {
    /* renamed from: a */
    public static final int f3368a = 100;
    /* renamed from: b */
    private static final String TAG = "ConnectSocket";
    /* renamed from: c */
    private static final String ReadThreadTAG = "ReadThread";
    /* renamed from: d */
    private static final String WriteThreadTAG = "WriteThread";
    /* renamed from: e */
    private static final String TouchThreadTAG = "TouchThread";
    /* renamed from: f */
    private static final int f3373f = 4096;
    /* renamed from: g */
    private static final int f3374g = 327680;
    /* renamed from: h */
    private static final int f3375h = 327680;
    /* renamed from: i */
    private static final String CHARSET_Name = "utf-8";
    /* renamed from: r */
    private static int f3377r = 0;
    /* renamed from: s */
    private static int f3378s = 1;
    /* renamed from: j */
    private String mSocketName = TAG;
    /* renamed from: k */
    private CarlifeThread mCarlifeThread = null;
    /* renamed from: l */
    private WriteThread f3381l = null;
    /* renamed from: m */
    private TouchThread f3382m = null;
    /* renamed from: n */
    private Socket mSocket = null;
    /* renamed from: o */
    private BufferedInputStream mInputStream = null;
    /* renamed from: p */
    private BufferedOutputStream mOutputStream = null;
    /* renamed from: q */
    private boolean mStatus = false;
    /* renamed from: t */
    private boolean mIS = false;
    /* renamed from: u */
    private AESManager f3388u = new AESManager();
    /* renamed from: v */
    private AESManager mEncryptData = new AESManager();

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$a */
    private class CarlifeThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectSocket mConnectSocket;

        public CarlifeThread(ConnectSocket connectSocket) {
            this.mConnectSocket = connectSocket;
            setName(ConnectSocket.ReadThreadTAG);
        }

        public void run() {
            try {
                CarlifeThread.sleep(100);
                while (this.mConnectSocket.mStatus) {
                    if (this.mConnectSocket.mSocket.isConnected()) {
                        CarlifeCmdMessage carlifeMsg = this.mConnectSocket.receive();
                        if (carlifeMsg != null) {
                            MsgHandlerCenter.dispatchMessageDelay(carlifeMsg.getServiceType(), 0, 0, carlifeMsg);
                        } else {
                            LogUtil.e(ConnectSocket.TAG, "read carlife msg fail");
                            return;
                        }
                    }
                    LogUtil.e(ConnectSocket.TAG, "socket is disconnected when read data");
                    return;
                }
            } catch (InterruptedException e) {
                LogUtil.e(ConnectSocket.TAG, "get InterruptedException in ReadThread");
                e.printStackTrace();
            } catch (Exception ex) {
                LogUtil.e(ConnectSocket.TAG, "get Exception in ReadThread");
                ex.printStackTrace();
            }
        }
    }

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$b */
    private class TouchThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectSocket mConnectSocket;

        public TouchThread(ConnectSocket connectSocket) {
            this.mConnectSocket = connectSocket;
            setName(ConnectSocket.TouchThreadTAG);
        }

        public void run() {
            try {
                TouchThread.sleep(100);
                while (this.mConnectSocket.mStatus) {
                    if (this.mConnectSocket.mSocket.isConnected()) {
                        CarlifeCmdMessage carlifeMsg = this.mConnectSocket.receive();
                        if (carlifeMsg != null) {
                            int serviceType = carlifeMsg.getServiceType();
                            if (serviceType == CommonParams.bH) {
                                this.mConnectSocket.setIS(true);
                            } else {
                                if (this.mConnectSocket.getIS()) {
                                    MsgHandlerCenter.removeMessages((int) CommonParams.bH);
                                }
                                this.mConnectSocket.setIS(false);
                            }
                            MsgHandlerCenter.dispatchMessageDelay(serviceType, 0, 0, carlifeMsg);
                        } else {
                            LogUtil.e(ConnectSocket.TAG, "read touch carlife msg fail");
                            return;
                        }
                    }
                    LogUtil.e(ConnectSocket.TAG, "socket is disconnected when read touch data");
                    return;
                }
            } catch (InterruptedException e) {
                LogUtil.e(ConnectSocket.TAG, "get InterruptedException in TouchThread");
                e.printStackTrace();
            } catch (Exception ex) {
                LogUtil.e(ConnectSocket.TAG, "get Exception in TouchThread");
                ex.printStackTrace();
            }
        }
    }

    /* compiled from: ConnectSocket */
    /* renamed from: com.baidu.carlife.core.connect.g$c */
    private class WriteThread extends Thread {
        /* renamed from: a */
        final /* synthetic */ ConnectSocket mConnectSocket;

        public WriteThread(ConnectSocket connectSocket) {
            this.mConnectSocket = connectSocket;
            setName(ConnectSocket.WriteThreadTAG);
        }

        public void run() {
            while (this.mConnectSocket.mStatus) {
                try {
                    if (this.mConnectSocket.mSocket.isConnected()) {
                        CarlifeCmdMessage carlifeMsg = this.mConnectSocket.initCMD();
                        if (carlifeMsg != null) {
                            this.mConnectSocket.send(carlifeMsg);
                        } else {
                            LogUtil.e(ConnectSocket.TAG, "write carlife msg fail");
                            return;
                        }
                    }
                    LogUtil.e(ConnectSocket.TAG, "socket is disconnected when write data");
                    return;
                } catch (Exception ex) {
                    LogUtil.e(ConnectSocket.TAG, "get Exception in WriteThread");
                    ex.printStackTrace();
                    return;
                }
            }
        }
    }

    public ConnectSocket(String socketName, Socket socket) {
        this.mSocketName = socketName;
        this.mSocket = socket;
    }

    /* renamed from: a */
    public String getSocketName() {
        return this.mSocketName;
    }

    /* renamed from: a */
    public void setIS(boolean is) {
        this.mIS = is;
    }

    /* renamed from: b */
    public boolean getIS() {
        return this.mIS;
    }

    /* renamed from: c */
    public void startConmunication() {
        LogUtil.d(TAG, "Start Conmunication");
        if (!this.mStatus) {
            try {
                this.mSocket.setTcpNoDelay(true);
                this.mSocket.setSendBufferSize(327680);
                this.mSocket.setReceiveBufferSize(327680);
                this.mInputStream = new BufferedInputStream(this.mSocket.getInputStream());
                this.mOutputStream = new BufferedOutputStream(this.mSocket.getOutputStream());
                doHand();
                afterHand();
                this.mStatus = true;
            } catch (Exception e) {
                LogUtil.e(TAG, "Start Conmunication Fail");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public void stopConmunication() {
        LogUtil.d(TAG, "Stop Conmunication");
        if (this.mStatus) {
            try {
                if (this.mSocket != null) {
                    this.mSocket.close();
                    this.mSocket = null;
                }
                if (this.mInputStream != null) {
                    this.mInputStream.close();
                    this.mInputStream = null;
                }
                if (this.mOutputStream != null) {
                    this.mOutputStream.close();
                    this.mOutputStream = null;
                }
                this.mStatus = false;
            } catch (Exception e) {
                LogUtil.e(TAG, "Stop Conmunication Fail");
            }
        }
    }

    /* renamed from: g */
    private void doHand() {
        LogUtil.d(TAG, "ConnectSocket do shake hands");
        ConnectManager.newInstance().initSocket(this);
    }

    /* renamed from: h */
    private void afterHand() {
        LogUtil.d(TAG, "ConnectSocket after shake hands");
        if (this.mSocketName.equals(CommonParams.SERVER_SOCKET_NAME) || this.mSocketName.equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
            this.mCarlifeThread = new CarlifeThread(this);
            this.mCarlifeThread.start();
        }
        if (this.mSocketName.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
            this.f3382m = new TouchThread(this);
            this.f3382m.start();
        }
    }

    /* renamed from: a */
    public int send(CarlifeCmdMessage msg) {
        try {
            if (this.mOutputStream != null) {
                ConnectSocket.dump("SEND CarlifeMsg CMD", msg);
                if (!EncryptSetupManager.newInstance().getFlag() || msg.getLength() <= 0) {
                    this.mOutputStream.write(msg.toByteArray());
                    this.mOutputStream.flush();
                    if (msg.getLength() > 0) {
                        this.mOutputStream.write(msg.getData());
                        this.mOutputStream.flush();
                    }
                } else {
                    byte[] encryptData = this.mEncryptData.m4112a(msg.getData(), msg.getData().length);
                    if (encryptData == null) {
                        LogUtil.e(TAG, "encrypt failed!");
                        return -1;
                    }
                    msg.setLength(encryptData.length);
                    this.mOutputStream.write(msg.toByteArray());
                    this.mOutputStream.flush();
                    if (msg.getLength() > 0) {
                        this.mOutputStream.write(encryptData);
                        this.mOutputStream.flush();
                    }
                }
                return msg.getLength() + 8;
            }
            LogUtil.e(TAG, this.mSocketName + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.e(TAG, this.mSocketName + " IOException, Send Data Fail");
            ConnectClient.newInstance().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public int send(byte[] buffer, int len) {
        try {
            if (this.mOutputStream != null) {
                if (!CommonParams.SERVER_SOCKET_VIDEO_NAME.equals(this.mSocketName)) {
                    ConnectSocket.dump("SEND CarlifeMsg " + this.mSocketName, buffer, len);
                }
                this.mOutputStream.write(buffer, 0, len);
                this.mOutputStream.flush();
                return len;
            }
            LogUtil.e(TAG, this.mSocketName + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.e(TAG, this.mSocketName + " IOException, Send Data Fail");
            ConnectClient.newInstance().m4222a(false);
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: i */
    private CarlifeCmdMessage receive() {
        CarlifeCmdMessage carlifeMsg = new CarlifeCmdMessage(false);
        try {
            if (this.mInputStream != null) {
                int r;
                int cnt = 8;
                byte[] headBuf = new byte[8];
                int headLen = 0;
                while (cnt > 0) {
                    r = this.mInputStream.read(headBuf, headLen, cnt);
                    if (r > 0) {
                        cnt -= r;
                        headLen += r;
                    } else {
                        LogUtil.e(TAG, this.mSocketName + " Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.m4195a(headBuf);
                    int len = carlifeMsg.getLength();
                    cnt = len;
                    byte[] dataBuf = new byte[len];
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = this.mInputStream.read(dataBuf, dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            LogUtil.e(TAG, this.mSocketName + " Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        if (!EncryptSetupManager.newInstance().getFlag() || dataLen <= 0) {
                            carlifeMsg.setData(dataBuf);
                        } else {
                            byte[] decryptData = this.f3388u.m4113b(dataBuf, dataLen);
                            if (decryptData == null) {
                                LogUtil.e(TAG, "decrypt failed!");
                                return null;
                            }
                            carlifeMsg.setLength(decryptData.length);
                            carlifeMsg.setData(decryptData);
                        }
                        ConnectSocket.dump("RECV CarlifeMsg " + this.mSocketName, carlifeMsg);
                        return carlifeMsg;
                    }
                    LogUtil.e(TAG, this.mSocketName + " Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                LogUtil.e(TAG, this.mSocketName + " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            }
            LogUtil.e(TAG, this.mSocketName + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.e(TAG, this.mSocketName + " IOException, Receive Data Fail");
            ConnectClient.newInstance().m4222a(false);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static CarlifeCmdMessage receive(BufferedInputStream tmpInputStream) throws IOException {
        CarlifeCmdMessage carlifeMsg = new CarlifeCmdMessage(false);
        if (tmpInputStream != null) {
            int cnt = 8;
            try {
                int r;
                byte[] headBuf = new byte[8];
                int headLen = 0;
                while (cnt > 0) {
                    r = tmpInputStream.read(headBuf, headLen, cnt);
                    if (r > 0) {
                        cnt -= r;
                        headLen += r;
                    } else {
                        LogUtil.e(TAG, "Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.m4195a(headBuf);
                    int len = carlifeMsg.getLength();
                    cnt = len;
                    byte[] dataBuf = new byte[len];
                    int dataLen = 0;
                    while (cnt > 0) {
                        r = tmpInputStream.read(dataBuf, dataLen, cnt);
                        if (r > 0) {
                            cnt -= r;
                            dataLen += r;
                        } else {
                            LogUtil.e(TAG, "Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        carlifeMsg.setData(dataBuf);
                        ConnectSocket.dump("RECV CarlifeMsg CMD", carlifeMsg);
                        return carlifeMsg;
                    }
                    LogUtil.e(TAG, "Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                LogUtil.e(TAG, " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            } catch (Exception e) {
                LogUtil.e(TAG, "IOException, Receive Data Fail");
                ConnectClient.newInstance().m4222a(false);
                e.printStackTrace();
                return null;
            }
        }
        LogUtil.e(TAG, "Receive Data Fail, mInputStream is null");
        throw new IOException();
    }

    /* renamed from: b */
    public int receive(byte[] buffer, int len) {
        int r = -1;
        try {
            if (this.mInputStream != null) {
                int cnt = len;
                int dataLen = 0;
                while (cnt > 0) {
                    r = this.mInputStream.read(buffer, dataLen, cnt);
                    if (r > 0) {
                        cnt -= r;
                        dataLen += r;
                    } else {
                        LogUtil.e(TAG, this.mSocketName + " Receive Data Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (dataLen == len) {
                    return dataLen;
                }
                LogUtil.e(TAG, this.mSocketName + " Receive Data Error: dataLen = " + dataLen);
                throw new IOException();
            }
            LogUtil.e(TAG, this.mSocketName + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            LogUtil.e(TAG, this.mSocketName + " IOException, Receive Data Fail");
            ConnectClient.newInstance().m4222a(false);
            e.printStackTrace();
            return r;
        }
    }

    /* renamed from: a */
    private static void dump(String tag, CarlifeCmdMessage carlifeMsg) {
        if (CarlifeUtil.m4382t()) {
            try {
                LogUtil.d(TAG, "[" + tag + "]" + (((("" + "index = " + Integer.toString(carlifeMsg.getIndex())) + ", length = " + Integer.toString(carlifeMsg.getLength())) + ", service_type = 0x" + DigitalTrans.m4317a(carlifeMsg.getServiceType(), 8)) + ", name = " + CommonParams.getMsgName(carlifeMsg.getServiceType())));
            } catch (Exception e) {
                LogUtil.e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void dump(String tag, byte[] data, int len) {
        if (CarlifeUtil.m4382t() && len >= 4) {
            String msg = "";
            try {
                msg = msg + "length = " + Integer.toString(ByteConvert.m4178b(new byte[]{data[0], data[1], data[2], data[3]}));
                if (len >= 12) {
                    int serviceType = ByteConvert.m4178b(new byte[]{data[8], data[9], data[10], data[11]});
                    String name = CommonParams.getMsgName(serviceType);
                    if (name != null) {
                        msg = (msg + ", service_type = 0x" + DigitalTrans.m4317a(serviceType, 8)) + ", name = " + name;
                    } else {
                        return;
                    }
                }
                LogUtil.d(TAG, "[" + tag + "]" + msg);
            } catch (Exception e) {
                LogUtil.e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public BufferedInputStream getInputStream() {
        return this.mInputStream;
    }

    /* renamed from: f */
    public BufferedOutputStream getOutputStream() {
        return this.mOutputStream;
    }

    /* renamed from: j */
    private CarlifeCmdMessage initCMD() {
        if (f3377r >= f3378s) {
            return null;
        }
        char c = (char) ((f3377r % 26) + 97);
        CarlifeCmdMessage tcarlifeMsg = new CarlifeCmdMessage(true);
        String ts = "Msg Num:" + Integer.toString(f3377r);
        int len = 4096 - ts.length();
        StringBuffer sb = new StringBuffer(ts);
        for (int j = 0; j < len; j++) {
            sb.append(c);
        }
        try {
            tcarlifeMsg.setData(sb.toString().getBytes(CHARSET_Name));
            tcarlifeMsg.setLength(4096);
            f3377r++;
            return tcarlifeMsg;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
