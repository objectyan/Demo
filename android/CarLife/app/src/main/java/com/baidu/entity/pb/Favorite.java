package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class Favorite extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11110a;
    /* renamed from: b */
    private int f11111b = 0;
    /* renamed from: c */
    private boolean f11112c;
    /* renamed from: d */
    private String f11113d = "";
    /* renamed from: e */
    private boolean f11114e;
    /* renamed from: f */
    private Data f11115f = null;
    /* renamed from: g */
    private int f11116g = -1;

    public static final class Data extends MessageMicro {
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int THEME_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11105a;
        /* renamed from: b */
        private String f11106b = "";
        /* renamed from: c */
        private boolean f11107c;
        /* renamed from: d */
        private int f11108d = 0;
        /* renamed from: e */
        private int f11109e = -1;

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public final Data clear() {
            clearThemeId();
            clearStatus();
            this.f11109e = -1;
            return this;
        }

        public Data clearStatus() {
            this.f11107c = false;
            this.f11108d = 0;
            return this;
        }

        public Data clearThemeId() {
            this.f11105a = false;
            this.f11106b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11109e < 0) {
                getSerializedSize();
            }
            return this.f11109e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasThemeId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThemeId());
            }
            if (hasStatus()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getStatus());
            }
            this.f11109e = i;
            return i;
        }

        public int getStatus() {
            return this.f11108d;
        }

        public String getThemeId() {
            return this.f11106b;
        }

        public boolean hasStatus() {
            return this.f11107c;
        }

        public boolean hasThemeId() {
            return this.f11105a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Data mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setThemeId(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setStatus(codedInputStreamMicro.readInt32());
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

        public Data setStatus(int i) {
            this.f11107c = true;
            this.f11108d = i;
            return this;
        }

        public Data setThemeId(String str) {
            this.f11105a = true;
            this.f11106b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasThemeId()) {
                codedOutputStreamMicro.writeString(1, getThemeId());
            }
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(2, getStatus());
            }
        }
    }

    public static Favorite parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Favorite().mergeFrom(codedInputStreamMicro);
    }

    public static Favorite parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Favorite) new Favorite().mergeFrom(bArr);
    }

    public final Favorite clear() {
        clearError();
        clearMsg();
        clearData();
        this.f11116g = -1;
        return this;
    }

    public Favorite clearData() {
        this.f11114e = false;
        this.f11115f = null;
        return this;
    }

    public Favorite clearError() {
        this.f11110a = false;
        this.f11111b = 0;
        return this;
    }

    public Favorite clearMsg() {
        this.f11112c = false;
        this.f11113d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11116g < 0) {
            getSerializedSize();
        }
        return this.f11116g;
    }

    public Data getData() {
        return this.f11115f;
    }

    public int getError() {
        return this.f11111b;
    }

    public String getMsg() {
        return this.f11113d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        if (hasData()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getData());
        }
        this.f11116g = i;
        return i;
    }

    public boolean hasData() {
        return this.f11114e;
    }

    public boolean hasError() {
        return this.f11110a;
    }

    public boolean hasMsg() {
        return this.f11112c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Favorite mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setMsg(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    MessageMicro data = new Data();
                    codedInputStreamMicro.readMessage(data);
                    setData(data);
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

    public Favorite setData(Data data) {
        if (data == null) {
            return clearData();
        }
        this.f11114e = true;
        this.f11115f = data;
        return this;
    }

    public Favorite setError(int i) {
        this.f11110a = true;
        this.f11111b = i;
        return this;
    }

    public Favorite setMsg(String str) {
        this.f11112c = true;
        this.f11113d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
        if (hasData()) {
            codedOutputStreamMicro.writeMessage(3, getData());
        }
    }
}
