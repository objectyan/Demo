package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class TrackMemoGet extends MessageMicro {
    public static final int CONTENT_TEXT_FIELD_NUMBER = 1;
    public static final int DATE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f16302a;
    /* renamed from: b */
    private String f16303b = "";
    /* renamed from: c */
    private boolean f16304c;
    /* renamed from: d */
    private String f16305d = "";
    /* renamed from: e */
    private int f16306e = -1;

    public static TrackMemoGet parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackMemoGet().mergeFrom(codedInputStreamMicro);
    }

    public static TrackMemoGet parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackMemoGet) new TrackMemoGet().mergeFrom(bArr);
    }

    public final TrackMemoGet clear() {
        clearContentText();
        clearDate();
        this.f16306e = -1;
        return this;
    }

    public TrackMemoGet clearContentText() {
        this.f16302a = false;
        this.f16303b = "";
        return this;
    }

    public TrackMemoGet clearDate() {
        this.f16304c = false;
        this.f16305d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f16306e < 0) {
            getSerializedSize();
        }
        return this.f16306e;
    }

    public String getContentText() {
        return this.f16303b;
    }

    public String getDate() {
        return this.f16305d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasContentText()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getContentText());
        }
        if (hasDate()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getDate());
        }
        this.f16306e = i;
        return i;
    }

    public boolean hasContentText() {
        return this.f16302a;
    }

    public boolean hasDate() {
        return this.f16304c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackMemoGet mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setContentText(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setDate(codedInputStreamMicro.readString());
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

    public TrackMemoGet setContentText(String str) {
        this.f16302a = true;
        this.f16303b = str;
        return this;
    }

    public TrackMemoGet setDate(String str) {
        this.f16304c = true;
        this.f16305d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasContentText()) {
            codedOutputStreamMicro.writeString(1, getContentText());
        }
        if (hasDate()) {
            codedOutputStreamMicro.writeString(2, getDate());
        }
    }
}
