package com.baidu.carlife.platform.communication;

import android.text.TextUtils;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.ByteConvert;
import java.io.Serializable;

public class CLPackage implements Serializable {
    public static final int CLPACKAGE_HEADER_LENGTH = 16;
    public static final int CLPACKAGE_MAX_DATA_LENGTH = 32767;
    private static final String TAG = CLPackage.class.getSimpleName();
    private static final long serialVersionUID = 2746065370039824232L;
    public byte[] data;
    public long dataId = 0;
    public int dataType = 0;
    public int length = 0;
    public int reserved = 0;
    public int service = 0;
    public int type = 0;

    public static CLPackage getLargestPackage() {
        CLPackage pack = new CLPackage();
        pack.data = new byte[CLPACKAGE_MAX_DATA_LENGTH];
        return pack;
    }

    public boolean setData(String json) throws IllegalArgumentException {
        if (TextUtils.isEmpty(json)) {
            this.data = null;
            this.length = 0;
        } else {
            byte[] bytes = json.getBytes();
            setData(bytes, bytes.length);
        }
        this.dataType = 0;
        return true;
    }

    public boolean setData(byte[] src, int len) throws IllegalArgumentException {
        if (src == null || len == 0) {
            this.data = null;
            this.dataType = 1;
            this.length = 0;
        } else if (len > CLPACKAGE_MAX_DATA_LENGTH) {
            throw new IllegalArgumentException("data exceed package largest length");
        } else if (src.length < len) {
            throw new IllegalArgumentException("data length is less than len");
        } else {
            if (this.data == null || this.data.length < len) {
                this.data = new byte[len];
            }
            System.arraycopy(src, 0, this.data, 0, len);
            this.dataType = 1;
            this.length = len;
        }
        return true;
    }

    public String getDataInString() {
        if (this.data == null) {
            return null;
        }
        return new String(this.data, 0, this.length);
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDataLength() {
        return this.length;
    }

    public int getDataType() {
        return this.dataType;
    }

    public boolean setHeader(byte[] header) {
        if (header.length != 16) {
            return false;
        }
        try {
            this.reserved = ByteConvert.m4189d(header, 0);
            this.type = header[2] & 255;
            this.dataType = header[3] & 255;
            this.length = ByteConvert.m4189d(header, 4);
            this.service = ByteConvert.m4189d(header, 6);
            this.dataId = ByteConvert.m4171a(header, 8);
            return true;
        } catch (Throwable e) {
            LogUtil.m4438b(TAG, e);
            return false;
        }
    }

    public byte[] getHeader() {
        byte[] bytes = new byte[16];
        try {
            bytes[0] = (byte) ((this.reserved >> 8) & 255);
            bytes[1] = (byte) (this.reserved & 255);
            bytes[2] = (byte) (this.type & 255);
            bytes[3] = (byte) (this.dataType & 255);
            bytes[4] = (byte) ((this.length >> 8) & 255);
            bytes[5] = (byte) (this.length & 255);
            bytes[6] = (byte) ((this.service >> 8) & 255);
            bytes[7] = (byte) (this.service & 255);
            ByteConvert.m4173a(this.dataId, bytes, 8);
            return bytes;
        } catch (Throwable e) {
            LogUtil.m4438b(TAG, e);
            return null;
        }
    }
}
