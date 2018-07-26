package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SubwaysCity extends MessageMicro {
    public static final int CITIES_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<Cities> f14760a = Collections.emptyList();
    /* renamed from: b */
    private int f14761b = -1;

    public static final class Cities extends MessageMicro {
        public static final int CN_NAME_FIELD_NUMBER = 1;
        public static final int CODE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14755a;
        /* renamed from: b */
        private String f14756b = "";
        /* renamed from: c */
        private boolean f14757c;
        /* renamed from: d */
        private String f14758d = "";
        /* renamed from: e */
        private int f14759e = -1;

        public static Cities parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Cities().mergeFrom(codedInputStreamMicro);
        }

        public static Cities parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Cities) new Cities().mergeFrom(bArr);
        }

        public final Cities clear() {
            clearCnName();
            clearCode();
            this.f14759e = -1;
            return this;
        }

        public Cities clearCnName() {
            this.f14755a = false;
            this.f14756b = "";
            return this;
        }

        public Cities clearCode() {
            this.f14757c = false;
            this.f14758d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14759e < 0) {
                getSerializedSize();
            }
            return this.f14759e;
        }

        public String getCnName() {
            return this.f14756b;
        }

        public String getCode() {
            return this.f14758d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCnName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCnName());
            }
            if (hasCode()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getCode());
            }
            this.f14759e = i;
            return i;
        }

        public boolean hasCnName() {
            return this.f14755a;
        }

        public boolean hasCode() {
            return this.f14757c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Cities mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCnName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setCode(codedInputStreamMicro.readString());
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

        public Cities setCnName(String str) {
            this.f14755a = true;
            this.f14756b = str;
            return this;
        }

        public Cities setCode(String str) {
            this.f14757c = true;
            this.f14758d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCnName()) {
                codedOutputStreamMicro.writeString(1, getCnName());
            }
            if (hasCode()) {
                codedOutputStreamMicro.writeString(2, getCode());
            }
        }
    }

    public static SubwaysCity parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new SubwaysCity().mergeFrom(codedInputStreamMicro);
    }

    public static SubwaysCity parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (SubwaysCity) new SubwaysCity().mergeFrom(bArr);
    }

    public SubwaysCity addCities(Cities cities) {
        if (cities != null) {
            if (this.f14760a.isEmpty()) {
                this.f14760a = new ArrayList();
            }
            this.f14760a.add(cities);
        }
        return this;
    }

    public final SubwaysCity clear() {
        clearCities();
        this.f14761b = -1;
        return this;
    }

    public SubwaysCity clearCities() {
        this.f14760a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f14761b < 0) {
            getSerializedSize();
        }
        return this.f14761b;
    }

    public Cities getCities(int i) {
        return (Cities) this.f14760a.get(i);
    }

    public int getCitiesCount() {
        return this.f14760a.size();
    }

    public List<Cities> getCitiesList() {
        return this.f14760a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Cities computeMessageSize : getCitiesList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f14761b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public SubwaysCity mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro cities = new Cities();
                    codedInputStreamMicro.readMessage(cities);
                    addCities(cities);
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

    public SubwaysCity setCities(int i, Cities cities) {
        if (cities != null) {
            this.f14760a.set(i, cities);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Cities writeMessage : getCitiesList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
