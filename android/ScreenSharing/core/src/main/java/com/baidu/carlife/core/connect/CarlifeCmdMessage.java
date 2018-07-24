package com.baidu.carlife.core.connect;

import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.LogUtil;

/* compiled from: CarlifeCmdMessage */
/* renamed from: com.baidu.carlife.core.connect.c */
public class CarlifeCmdMessage implements KeepClass {
    /* renamed from: b */
    private static final String TAG = "CarlifeCmdMessage";
    /* renamed from: c */
    private static int f3300c = 0;
    /* renamed from: a */
    byte[] data = null;
    /* renamed from: d */
    private int index = 0;
    /* renamed from: e */
    private int length = 0;
    /* renamed from: f */
    private int reserved = 0;
    /* renamed from: g */
    private int serviceType = 0;

    public CarlifeCmdMessage(boolean isSend) {
        if (isSend) {
            int i = f3300c + 1;
            f3300c = i;
            this.index = i;
        }
    }

    /* renamed from: a */
    public boolean m4195a(byte[] msg) {
        if (msg.length != 8) {
            LogUtil.m4445e(TAG, "fromByteArray fail: length not equal");
            return false;
        }
        try {
            setLength(ByteConvert.m4188d(new byte[]{msg[0], msg[1]}));
            setReserved(ByteConvert.m4188d(new byte[]{msg[2], msg[3]}));
            setServiceType(ByteConvert.m4178b(new byte[]{msg[4], msg[5], msg[6], msg[7]}));
            return true;
        } catch (Exception e) {
            LogUtil.m4445e(TAG, "fromByteArray fail: get exception");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public byte[] toByteArray() {
        Exception e;
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
                e = e2;
                i2 = i;
                LogUtil.m4445e(TAG, "toByteArray fail: get exception");
                e.printStackTrace();
                return null;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int ind) {
        if (ind < 0 || ind > Integer.MAX_VALUE) {
            LogUtil.e(TAG, "set index fail: %d", Integer.valueOf(ind));
            return;
        }
        this.index = ind;
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int ty) {
        if (ty < 0 || ty > Integer.MAX_VALUE) {
            LogUtil.e(TAG, "set reserved fail: %d", Integer.valueOf(ty));
            return;
        }
        this.reserved = ty;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(int ty) {
        if (ty < 0 || ty > Integer.MAX_VALUE) {
            LogUtil.e(TAG, "set service type fail: %d", Integer.valueOf(ty));
            return;
        }
        this.serviceType = ty;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int len) {
        if (len < 0 || len > 32768) {
            LogUtil.e(TAG, "set data len fail: %d", Integer.valueOf(len));
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
