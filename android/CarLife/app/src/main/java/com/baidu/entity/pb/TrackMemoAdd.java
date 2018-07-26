package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class TrackMemoAdd extends MessageMicro {
    public static final int CONTENT_TEXT_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f16295a;
    /* renamed from: b */
    private String f16296b = "";
    /* renamed from: c */
    private boolean f16297c;
    /* renamed from: d */
    private String f16298d = "";
    /* renamed from: e */
    private boolean f16299e;
    /* renamed from: f */
    private String f16300f = "";
    /* renamed from: g */
    private int f16301g = -1;

    public static TrackMemoAdd parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackMemoAdd().mergeFrom(codedInputStreamMicro);
    }

    public static TrackMemoAdd parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackMemoAdd) new TrackMemoAdd().mergeFrom(bArr);
    }

    public final TrackMemoAdd clear() {
        clearStatus();
        clearDate();
        clearContentText();
        this.f16301g = -1;
        return this;
    }

    public TrackMemoAdd clearContentText() {
        this.f16299e = false;
        this.f16300f = "";
        return this;
    }

    public TrackMemoAdd clearDate() {
        this.f16297c = false;
        this.f16298d = "";
        return this;
    }

    public TrackMemoAdd clearStatus() {
        this.f16295a = false;
        this.f16296b = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f16301g < 0) {
            getSerializedSize();
        }
        return this.f16301g;
    }

    public String getContentText() {
        return this.f16300f;
    }

    public String getDate() {
        return this.f16298d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasStatus()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStatus());
        }
        if (hasDate()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getDate());
        }
        if (hasContentText()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getContentText());
        }
        this.f16301g = i;
        return i;
    }

    public String getStatus() {
        return this.f16296b;
    }

    public boolean hasContentText() {
        return this.f16299e;
    }

    public boolean hasDate() {
        return this.f16297c;
    }

    public boolean hasStatus() {
        return this.f16295a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackMemoAdd mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setStatus(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setDate(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    setContentText(codedInputStreamMicro.readString());
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

    public TrackMemoAdd setContentText(String str) {
        this.f16299e = true;
        this.f16300f = str;
        return this;
    }

    public TrackMemoAdd setDate(String str) {
        this.f16297c = true;
        this.f16298d = str;
        return this;
    }

    public TrackMemoAdd setStatus(String str) {
        this.f16295a = true;
        this.f16296b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasStatus()) {
            codedOutputStreamMicro.writeString(1, getStatus());
        }
        if (hasDate()) {
            codedOutputStreamMicro.writeString(2, getDate());
        }
        if (hasContentText()) {
            codedOutputStreamMicro.writeString(3, getContentText());
        }
    }
}
