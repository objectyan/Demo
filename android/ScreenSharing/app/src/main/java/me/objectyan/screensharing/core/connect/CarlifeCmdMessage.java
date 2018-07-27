package me.objectyan.screensharing.core.connect;


import android.util.Log;

import me.objectyan.screensharing.core.LogUtil;


public class CarlifeCmdMessage {

    private static final String TAG = "CarlifeCmdMessage";

    private static int f3300c = 0;

    byte[] data = null;

    private int index = 0;

    private int length = 0;

    private int reserved = 0;

    private int serviceType = 0;

    public CarlifeCmdMessage(boolean isSend) {
        if (isSend) {
            int i = f3300c + 1;
            f3300c = i;
            this.index = i;
        }
    }


    public boolean fromByteArray(byte[] msg) {
        if (msg.length != 8) {
            Log.e(TAG, "fromByteArray fail: length not equal");
            return false;
        }
        try {
            setLength(ByteConvert.m4188d(new byte[]{msg[0], msg[1]}));
            setReserved(ByteConvert.m4188d(new byte[]{msg[2], msg[3]}));
            setServiceType(ByteConvert.m4178b(new byte[]{msg[4], msg[5], msg[6], msg[7]}));
            return true;
        } catch (Exception e) {
            Log.e(TAG, "fromByteArray fail: get exception");
            e.printStackTrace();
            return false;
        }
    }


    public byte[] toByteArray() {
        byte[] bytes = new byte[8];
        try {
            byte[] tmpBytes = ByteConvert.m4175a(this.length);
            int i = 0 + 1;
            int i2;
            try {
                bytes[0] = tmpBytes[2];
                i2 = i + 1;
                bytes[i] = tmpBytes[3];
                tmpBytes = ByteConvert.m4175a(this.reserved);
                i = i2 + 1;
                bytes[i2] = tmpBytes[2];
                i2 = i + 1;
                bytes[i] = tmpBytes[3];
                tmpBytes = ByteConvert.m4175a(this.serviceType);
                i = i2 + 1;
                bytes[i2] = tmpBytes[0];
                i2 = i + 1;
                bytes[i] = tmpBytes[1];
                i = i2 + 1;
                bytes[i2] = tmpBytes[2];
                i2 = i + 1;
                bytes[i] = tmpBytes[3];
                return bytes;
            } catch (Exception e2) {
                i2 = i;
                Log.e(TAG, "toByteArray fail: get exception");
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int ind) {
        if (ind < 0 || ind > Integer.MAX_VALUE) {
            Log.e(TAG, "set index fail: " + Integer.valueOf(ind));
            return;
        }
        this.index = ind;
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int ty) {
        if (ty < 0 || ty > Integer.MAX_VALUE) {
            Log.e(TAG, "set reserved fail: " + Integer.valueOf(ty));
            return;
        }
        this.reserved = ty;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(int ty) {
        if (ty < 0 || ty > Integer.MAX_VALUE) {
            Log.e(TAG, "set service type fail: " + Integer.valueOf(ty));
            return;
        }
        this.serviceType = ty;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int len) {
        if (len < 0 || len > 32768) {
            Log.e(TAG, "set data len fail: " + Integer.valueOf(len));
            return;
        }
        this.length = len;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] obj) {
        this.data = obj;
    }
}
