package me.objectyan.screensharing.core.connect;

import android.util.Log;

import me.objectyan.screensharing.core.CarlifeUtil;
import me.objectyan.screensharing.core.CommonParams;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.connect.config.AESManager;
import me.objectyan.screensharing.core.connect.config.EncryptSetupManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;


public class ConnectSocket  {

    public static final int f3368a = 100;

    private static final String TAG = "ConnectSocket";

    private static final String ReadThreadTAG = "ReadThread";

    private static final String WriteThreadTAG = "WriteThread";

    private static final String TouchThreadTAG = "TouchThread";

    private static final int f3373f = 4096;

    private static final int f3374g = 327680;

    private static final int f3375h = 327680;

    private static final String CHARSET_Name = "utf-8";

    private static int f3377r = 0;

    private static int f3378s = 1;

    private String mSocketName = TAG;

    private CarlifeThread mCarlifeThread = null;

    private WriteThread f3381l = null;

    private TouchThread f3382m = null;

    private Socket mSocket = null;

    private BufferedInputStream mInputStream = null;

    private BufferedOutputStream mOutputStream = null;

    private boolean mStatus = false;

    private boolean mIS = false;

    private AESManager f3388u = new AESManager();

    private AESManager mEncryptData = new AESManager();


    private class CarlifeThread extends Thread {

        final  ConnectSocket mConnectSocket;

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
                            Log.e(ConnectSocket.TAG, "read carlife msg fail");
                            return;
                        }
                    }
                    Log.e(ConnectSocket.TAG, "socket is disconnected when read data");
                    return;
                }
            } catch (InterruptedException e) {
                Log.e(ConnectSocket.TAG, "get InterruptedException in ReadThread");
                e.printStackTrace();
            } catch (Exception ex) {
                Log.e(ConnectSocket.TAG, "get Exception in ReadThread");
                ex.printStackTrace();
            }
        }
    }


    private class TouchThread extends Thread {

        final  ConnectSocket mConnectSocket;

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
                            Log.e(ConnectSocket.TAG, "read touch carlife msg fail");
                            return;
                        }
                    }
                    Log.e(ConnectSocket.TAG, "socket is disconnected when read touch data");
                    return;
                }
            } catch (InterruptedException e) {
                Log.e(ConnectSocket.TAG, "get InterruptedException in TouchThread");
                e.printStackTrace();
            } catch (Exception ex) {
                Log.e(ConnectSocket.TAG, "get Exception in TouchThread");
                ex.printStackTrace();
            }
        }
    }


    private class WriteThread extends Thread {

        final  ConnectSocket mConnectSocket;

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
                            Log.e(ConnectSocket.TAG, "write carlife msg fail");
                            return;
                        }
                    }
                    Log.e(ConnectSocket.TAG, "socket is disconnected when write data");
                    return;
                } catch (Exception ex) {
                    Log.e(ConnectSocket.TAG, "get Exception in WriteThread");
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


    public String getSocketName() {
        return this.mSocketName;
    }


    public void setIS(boolean is) {
        this.mIS = is;
    }


    public boolean getIS() {
        return this.mIS;
    }


    public void startConmunication() {
        Log.d(TAG, "Start Conmunication");
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
                Log.e(TAG, "Start Conmunication Fail");
                e.printStackTrace();
            }
        }
    }


    public void stopConmunication() {
        Log.d(TAG, "Stop Conmunication");
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
                Log.e(TAG, "Stop Conmunication Fail");
            }
        }
    }


    private void doHand() {
        Log.d(TAG, "ConnectSocket do shake hands");
        ConnectManager.newInstance().initSocket(this);
    }


    private void afterHand() {
        Log.d(TAG, "ConnectSocket after shake hands");
        if (this.mSocketName.equals(CommonParams.SERVER_SOCKET_NAME) || this.mSocketName.equals(CommonParams.SERVER_SOCKET_DATA_NAME)) {
            this.mCarlifeThread = new CarlifeThread(this);
            this.mCarlifeThread.start();
        }
        if (this.mSocketName.equals(CommonParams.SERVER_SOCKET_TOUCH_NAME)) {
            this.f3382m = new TouchThread(this);
            this.f3382m.start();
        }
    }


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
                    byte[] encryptData = this.mEncryptData.encrypt(msg.getData(), msg.getData().length);
                    if (encryptData == null) {
                        Log.e(TAG, "encrypt failed!");
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
            Log.e(TAG, this.mSocketName + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            Log.e(TAG, this.mSocketName + " IOException, Send Data Fail");
            ConnectClient.newInstance().setIS(false);
            e.printStackTrace();
            return -1;
        }
    }


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
            Log.e(TAG, this.mSocketName + " Send Data Fail, mOutputStream is null");
            throw new IOException();
        } catch (Exception e) {
            Log.e(TAG, this.mSocketName + " IOException, Send Data Fail");
            ConnectClient.newInstance().setIS(false);
            e.printStackTrace();
            return -1;
        }
    }


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
                        Log.e(TAG, this.mSocketName + " Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.fromByteArray(headBuf);
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
                            Log.e(TAG, this.mSocketName + " Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        if (!EncryptSetupManager.newInstance().getFlag() || dataLen <= 0) {
                            carlifeMsg.setData(dataBuf);
                        } else {
                            byte[] decryptData = this.f3388u.decrypt(dataBuf, dataLen);
                            if (decryptData == null) {
                                Log.e(TAG, "decrypt failed!");
                                return null;
                            }
                            carlifeMsg.setLength(decryptData.length);
                            carlifeMsg.setData(decryptData);
                        }
                        ConnectSocket.dump("RECV CarlifeMsg " + this.mSocketName, carlifeMsg);
                        return carlifeMsg;
                    }
                    Log.e(TAG, this.mSocketName + " Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                Log.e(TAG, this.mSocketName + " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            }
            Log.e(TAG, this.mSocketName + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            Log.e(TAG, this.mSocketName + " IOException, Receive Data Fail");
            ConnectClient.newInstance().setIS(false);
            e.printStackTrace();
            return null;
        }
    }


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
                        Log.e(TAG, "Receive Carlife Msg Head Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (headLen == 8) {
                    carlifeMsg.fromByteArray(headBuf);
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
                            Log.e(TAG, "Receive Carlife Msg Data Error: ret = " + r);
                            throw new IOException();
                        }
                    }
                    if (dataLen == len) {
                        carlifeMsg.setData(dataBuf);
                        ConnectSocket.dump("RECV CarlifeMsg CMD", carlifeMsg);
                        return carlifeMsg;
                    }
                    Log.e(TAG, "Receive Carlife Msg Data Error: dataLen = " + dataLen);
                    throw new IOException();
                }
                Log.e(TAG, " Receive Carlife Msg Head Error: headLen = " + headLen);
                throw new IOException();
            } catch (Exception e) {
                Log.e(TAG, "IOException, Receive Data Fail");
                ConnectClient.newInstance().setIS(false);
                e.printStackTrace();
                return null;
            }
        }
        Log.e(TAG, "Receive Data Fail, mInputStream is null");
        throw new IOException();
    }


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
                        Log.e(TAG, this.mSocketName + " Receive Data Error: ret = " + r);
                        throw new IOException();
                    }
                }
                if (dataLen == len) {
                    return dataLen;
                }
                Log.e(TAG, this.mSocketName + " Receive Data Error: dataLen = " + dataLen);
                throw new IOException();
            }
            Log.e(TAG, this.mSocketName + " Receive Data Fail, mInputStream is null");
            throw new IOException();
        } catch (Exception e) {
            Log.e(TAG, this.mSocketName + " IOException, Receive Data Fail");
            ConnectClient.newInstance().setIS(false);
            e.printStackTrace();
            return r;
        }
    }


    private static void dump(String tag, CarlifeCmdMessage carlifeMsg) {
        if (CarlifeUtil.m4382t()) {
            try {
                Log.d(TAG, "[" + tag + "]" + (((("" + "index = " + Integer.toString(carlifeMsg.getIndex())) + ", length = " + Integer.toString(carlifeMsg.getLength())) + ", service_type = 0x" + DigitalTrans.m4317a(carlifeMsg.getServiceType(), 8)) + ", name = " + CommonParams.getMsgName(carlifeMsg.getServiceType())));
            } catch (Exception e) {
                Log.e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }


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
                Log.d(TAG, "[" + tag + "]" + msg);
            } catch (Exception e) {
                Log.e("TAG", "dumpData get Exception");
                e.printStackTrace();
            }
        }
    }


    public BufferedInputStream getInputStream() {
        return this.mInputStream;
    }


    public BufferedOutputStream getOutputStream() {
        return this.mOutputStream;
    }


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
