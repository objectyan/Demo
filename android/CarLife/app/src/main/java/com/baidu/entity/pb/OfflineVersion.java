package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class OfflineVersion extends MessageMicro {
    public static final int OFFLINE_MAP_FIELD_NUMBER = 1;
    public static final int OFFLINE_SEARCH_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f12218a;
    /* renamed from: b */
    private String f12219b = "";
    /* renamed from: c */
    private boolean f12220c;
    /* renamed from: d */
    private String f12221d = "";
    /* renamed from: e */
    private int f12222e = -1;

    public static OfflineVersion parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new OfflineVersion().mergeFrom(codedInputStreamMicro);
    }

    public static OfflineVersion parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (OfflineVersion) new OfflineVersion().mergeFrom(bArr);
    }

    public final OfflineVersion clear() {
        clearOfflineMap();
        clearOfflineSearch();
        this.f12222e = -1;
        return this;
    }

    public OfflineVersion clearOfflineMap() {
        this.f12218a = false;
        this.f12219b = "";
        return this;
    }

    public OfflineVersion clearOfflineSearch() {
        this.f12220c = false;
        this.f12221d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f12222e < 0) {
            getSerializedSize();
        }
        return this.f12222e;
    }

    public String getOfflineMap() {
        return this.f12219b;
    }

    public String getOfflineSearch() {
        return this.f12221d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOfflineMap()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getOfflineMap());
        }
        if (hasOfflineSearch()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getOfflineSearch());
        }
        this.f12222e = i;
        return i;
    }

    public boolean hasOfflineMap() {
        return this.f12218a;
    }

    public boolean hasOfflineSearch() {
        return this.f12220c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OfflineVersion mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setOfflineMap(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setOfflineSearch(codedInputStreamMicro.readString());
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

    public OfflineVersion setOfflineMap(String str) {
        this.f12218a = true;
        this.f12219b = str;
        return this;
    }

    public OfflineVersion setOfflineSearch(String str) {
        this.f12220c = true;
        this.f12221d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOfflineMap()) {
            codedOutputStreamMicro.writeString(1, getOfflineMap());
        }
        if (hasOfflineSearch()) {
            codedOutputStreamMicro.writeString(2, getOfflineSearch());
        }
    }
}
