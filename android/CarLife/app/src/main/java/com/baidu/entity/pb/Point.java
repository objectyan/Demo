package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Point extends MessageMicro {
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f14171a;
    /* renamed from: b */
    private int f14172b = 0;
    /* renamed from: c */
    private boolean f14173c;
    /* renamed from: d */
    private int f14174d = 0;
    /* renamed from: e */
    private int f14175e = -1;

    public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Point().mergeFrom(codedInputStreamMicro);
    }

    public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Point) new Point().mergeFrom(bArr);
    }

    public final Point clear() {
        clearX();
        clearY();
        this.f14175e = -1;
        return this;
    }

    public Point clearX() {
        this.f14171a = false;
        this.f14172b = 0;
        return this;
    }

    public Point clearY() {
        this.f14173c = false;
        this.f14174d = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f14175e < 0) {
            getSerializedSize();
        }
        return this.f14175e;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasX()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getX());
        }
        if (hasY()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getY());
        }
        this.f14175e = i;
        return i;
    }

    public int getX() {
        return this.f14172b;
    }

    public int getY() {
        return this.f14174d;
    }

    public boolean hasX() {
        return this.f14171a;
    }

    public boolean hasY() {
        return this.f14173c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Point mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setX(codedInputStreamMicro.readInt32());
                    continue;
                case 16:
                    setY(codedInputStreamMicro.readInt32());
                    continue;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public Point setX(int i) {
        this.f14171a = true;
        this.f14172b = i;
        return this;
    }

    public Point setY(int i) {
        this.f14173c = true;
        this.f14174d = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasX()) {
            codedOutputStreamMicro.writeInt32(1, getX());
        }
        if (hasY()) {
            codedOutputStreamMicro.writeInt32(2, getY());
        }
    }
}
