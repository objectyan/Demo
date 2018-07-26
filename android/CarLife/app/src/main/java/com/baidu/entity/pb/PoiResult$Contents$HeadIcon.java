package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class PoiResult$Contents$HeadIcon extends MessageMicro {
    public static final int LINKS_FIELD_NUMBER = 3;
    public static final int PID_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f13947a;
    /* renamed from: b */
    private String f13948b = "";
    /* renamed from: c */
    private boolean f13949c;
    /* renamed from: d */
    private int f13950d = 0;
    /* renamed from: e */
    private boolean f13951e;
    /* renamed from: f */
    private String f13952f = "";
    /* renamed from: g */
    private boolean f13953g;
    /* renamed from: h */
    private String f13954h = "";
    /* renamed from: i */
    private int f13955i = -1;

    public static PoiResult$Contents$HeadIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Contents$HeadIcon().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Contents$HeadIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Contents$HeadIcon) new PoiResult$Contents$HeadIcon().mergeFrom(bArr);
    }

    public final PoiResult$Contents$HeadIcon clear() {
        clearUrl();
        clearType();
        clearLinks();
        clearPid();
        this.f13955i = -1;
        return this;
    }

    public PoiResult$Contents$HeadIcon clearLinks() {
        this.f13951e = false;
        this.f13952f = "";
        return this;
    }

    public PoiResult$Contents$HeadIcon clearPid() {
        this.f13953g = false;
        this.f13954h = "";
        return this;
    }

    public PoiResult$Contents$HeadIcon clearType() {
        this.f13949c = false;
        this.f13950d = 0;
        return this;
    }

    public PoiResult$Contents$HeadIcon clearUrl() {
        this.f13947a = false;
        this.f13948b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f13955i < 0) {
            getSerializedSize();
        }
        return this.f13955i;
    }

    public String getLinks() {
        return this.f13952f;
    }

    public String getPid() {
        return this.f13954h;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasUrl()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
        }
        if (hasType()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getType());
        }
        if (hasLinks()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getLinks());
        }
        if (hasPid()) {
            i += CodedOutputStreamMicro.computeStringSize(4, getPid());
        }
        this.f13955i = i;
        return i;
    }

    public int getType() {
        return this.f13950d;
    }

    public String getUrl() {
        return this.f13948b;
    }

    public boolean hasLinks() {
        return this.f13951e;
    }

    public boolean hasPid() {
        return this.f13953g;
    }

    public boolean hasType() {
        return this.f13949c;
    }

    public boolean hasUrl() {
        return this.f13947a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Contents$HeadIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setUrl(codedInputStreamMicro.readString());
                    continue;
                case 16:
                    setType(codedInputStreamMicro.readInt32());
                    continue;
                case 26:
                    setLinks(codedInputStreamMicro.readString());
                    continue;
                case 34:
                    setPid(codedInputStreamMicro.readString());
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

    public PoiResult$Contents$HeadIcon setLinks(String str) {
        this.f13951e = true;
        this.f13952f = str;
        return this;
    }

    public PoiResult$Contents$HeadIcon setPid(String str) {
        this.f13953g = true;
        this.f13954h = str;
        return this;
    }

    public PoiResult$Contents$HeadIcon setType(int i) {
        this.f13949c = true;
        this.f13950d = i;
        return this;
    }

    public PoiResult$Contents$HeadIcon setUrl(String str) {
        this.f13947a = true;
        this.f13948b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasUrl()) {
            codedOutputStreamMicro.writeString(1, getUrl());
        }
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(2, getType());
        }
        if (hasLinks()) {
            codedOutputStreamMicro.writeString(3, getLinks());
        }
        if (hasPid()) {
            codedOutputStreamMicro.writeString(4, getPid());
        }
    }
}
