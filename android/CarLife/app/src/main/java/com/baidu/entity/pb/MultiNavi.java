package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MultiNavi extends MessageMicro {
    public static final int MULTIANVISTREAM_FIELD_NUMBER = 3;
    public static final int POS_INFO_FIELD_NUMBER = 4;
    public static final int RETURNED_VERSION_FIELD_NUMBER = 7;
    public static final int TRAFFICPOISSTREAM_FIELD_NUMBER = 2;
    public static final int TRAFFIC_FC_POIS_FIELD_NUMBER = 5;
    public static final int UIIRETURNTYPE_FIELD_NUMBER = 1;
    public static final int WALKINF_FIELD_NUMBER = 6;
    /* renamed from: a */
    private boolean f12130a;
    /* renamed from: b */
    private int f12131b = 0;
    /* renamed from: c */
    private boolean f12132c;
    /* renamed from: d */
    private ByteStringMicro f12133d = ByteStringMicro.EMPTY;
    /* renamed from: e */
    private boolean f12134e;
    /* renamed from: f */
    private ByteStringMicro f12135f = ByteStringMicro.EMPTY;
    /* renamed from: g */
    private List<Position_Info> f12136g = Collections.emptyList();
    /* renamed from: h */
    private boolean f12137h;
    /* renamed from: i */
    private TrafficFCPois f12138i = null;
    /* renamed from: j */
    private boolean f12139j;
    /* renamed from: k */
    private walk_info_t f12140k = null;
    /* renamed from: l */
    private boolean f12141l;
    /* renamed from: m */
    private int f12142m = 0;
    /* renamed from: n */
    private int f12143n = -1;

    public static MultiNavi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new MultiNavi().mergeFrom(codedInputStreamMicro);
    }

    public static MultiNavi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (MultiNavi) new MultiNavi().mergeFrom(bArr);
    }

    public MultiNavi addPosInfo(Position_Info position_Info) {
        if (position_Info != null) {
            if (this.f12136g.isEmpty()) {
                this.f12136g = new ArrayList();
            }
            this.f12136g.add(position_Info);
        }
        return this;
    }

    public final MultiNavi clear() {
        clearUiiReturnType();
        clearTrafficPoisStream();
        clearMultianviStream();
        clearPosInfo();
        clearTrafficFcPois();
        clearWalkinf();
        clearReturnedVersion();
        this.f12143n = -1;
        return this;
    }

    public MultiNavi clearMultianviStream() {
        this.f12134e = false;
        this.f12135f = ByteStringMicro.EMPTY;
        return this;
    }

    public MultiNavi clearPosInfo() {
        this.f12136g = Collections.emptyList();
        return this;
    }

    public MultiNavi clearReturnedVersion() {
        this.f12141l = false;
        this.f12142m = 0;
        return this;
    }

    public MultiNavi clearTrafficFcPois() {
        this.f12137h = false;
        this.f12138i = null;
        return this;
    }

    public MultiNavi clearTrafficPoisStream() {
        this.f12132c = false;
        this.f12133d = ByteStringMicro.EMPTY;
        return this;
    }

    public MultiNavi clearUiiReturnType() {
        this.f12130a = false;
        this.f12131b = 0;
        return this;
    }

    public MultiNavi clearWalkinf() {
        this.f12139j = false;
        this.f12140k = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f12143n < 0) {
            getSerializedSize();
        }
        return this.f12143n;
    }

    public ByteStringMicro getMultianviStream() {
        return this.f12135f;
    }

    public Position_Info getPosInfo(int i) {
        return (Position_Info) this.f12136g.get(i);
    }

    public int getPosInfoCount() {
        return this.f12136g.size();
    }

    public List<Position_Info> getPosInfoList() {
        return this.f12136g;
    }

    public int getReturnedVersion() {
        return this.f12142m;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasUiiReturnType()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getUiiReturnType());
        }
        if (hasTrafficPoisStream()) {
            i += CodedOutputStreamMicro.computeBytesSize(2, getTrafficPoisStream());
        }
        if (hasMultianviStream()) {
            i += CodedOutputStreamMicro.computeBytesSize(3, getMultianviStream());
        }
        int i2 = i;
        for (Position_Info computeMessageSize : getPosInfoList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
        }
        if (hasTrafficFcPois()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(5, getTrafficFcPois());
        }
        if (hasWalkinf()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(6, getWalkinf());
        }
        if (hasReturnedVersion()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(7, getReturnedVersion());
        }
        this.f12143n = i2;
        return i2;
    }

    public TrafficFCPois getTrafficFcPois() {
        return this.f12138i;
    }

    public ByteStringMicro getTrafficPoisStream() {
        return this.f12133d;
    }

    public int getUiiReturnType() {
        return this.f12131b;
    }

    public walk_info_t getWalkinf() {
        return this.f12140k;
    }

    public boolean hasMultianviStream() {
        return this.f12134e;
    }

    public boolean hasReturnedVersion() {
        return this.f12141l;
    }

    public boolean hasTrafficFcPois() {
        return this.f12137h;
    }

    public boolean hasTrafficPoisStream() {
        return this.f12132c;
    }

    public boolean hasUiiReturnType() {
        return this.f12130a;
    }

    public boolean hasWalkinf() {
        return this.f12139j;
    }

    public final boolean isInitialized() {
        return !hasWalkinf() || getWalkinf().isInitialized();
    }

    public MultiNavi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro position_Info;
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setUiiReturnType(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setTrafficPoisStream(codedInputStreamMicro.readBytes());
                    continue;
                case 26:
                    setMultianviStream(codedInputStreamMicro.readBytes());
                    continue;
                case 34:
                    position_Info = new Position_Info();
                    codedInputStreamMicro.readMessage(position_Info);
                    addPosInfo(position_Info);
                    continue;
                case 42:
                    position_Info = new TrafficFCPois();
                    codedInputStreamMicro.readMessage(position_Info);
                    setTrafficFcPois(position_Info);
                    continue;
                case 50:
                    position_Info = new walk_info_t();
                    codedInputStreamMicro.readMessage(position_Info);
                    setWalkinf(position_Info);
                    continue;
                case 56:
                    setReturnedVersion(codedInputStreamMicro.readInt32());
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

    public MultiNavi setMultianviStream(ByteStringMicro byteStringMicro) {
        this.f12134e = true;
        this.f12135f = byteStringMicro;
        return this;
    }

    public MultiNavi setPosInfo(int i, Position_Info position_Info) {
        if (position_Info != null) {
            this.f12136g.set(i, position_Info);
        }
        return this;
    }

    public MultiNavi setReturnedVersion(int i) {
        this.f12141l = true;
        this.f12142m = i;
        return this;
    }

    public MultiNavi setTrafficFcPois(TrafficFCPois trafficFCPois) {
        if (trafficFCPois == null) {
            return clearTrafficFcPois();
        }
        this.f12137h = true;
        this.f12138i = trafficFCPois;
        return this;
    }

    public MultiNavi setTrafficPoisStream(ByteStringMicro byteStringMicro) {
        this.f12132c = true;
        this.f12133d = byteStringMicro;
        return this;
    }

    public MultiNavi setUiiReturnType(int i) {
        this.f12130a = true;
        this.f12131b = i;
        return this;
    }

    public MultiNavi setWalkinf(walk_info_t walk_info_t) {
        if (walk_info_t == null) {
            return clearWalkinf();
        }
        this.f12139j = true;
        this.f12140k = walk_info_t;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasUiiReturnType()) {
            codedOutputStreamMicro.writeInt32(1, getUiiReturnType());
        }
        if (hasTrafficPoisStream()) {
            codedOutputStreamMicro.writeBytes(2, getTrafficPoisStream());
        }
        if (hasMultianviStream()) {
            codedOutputStreamMicro.writeBytes(3, getMultianviStream());
        }
        for (Position_Info writeMessage : getPosInfoList()) {
            codedOutputStreamMicro.writeMessage(4, writeMessage);
        }
        if (hasTrafficFcPois()) {
            codedOutputStreamMicro.writeMessage(5, getTrafficFcPois());
        }
        if (hasWalkinf()) {
            codedOutputStreamMicro.writeMessage(6, getWalkinf());
        }
        if (hasReturnedVersion()) {
            codedOutputStreamMicro.writeInt32(7, getReturnedVersion());
        }
    }
}
