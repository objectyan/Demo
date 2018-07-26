package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BdIcon extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private List<Content> f9626a = Collections.emptyList();
    /* renamed from: b */
    private int f9627b = -1;

    public static final class Content extends MessageMicro {
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        public static final int FLAG_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f9621a;
        /* renamed from: b */
        private String f9622b = "";
        /* renamed from: c */
        private boolean f9623c;
        /* renamed from: d */
        private String f9624d = "";
        /* renamed from: e */
        private int f9625e = -1;

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearDataType();
            clearFlag();
            this.f9625e = -1;
            return this;
        }

        public Content clearDataType() {
            this.f9621a = false;
            this.f9622b = "";
            return this;
        }

        public Content clearFlag() {
            this.f9623c = false;
            this.f9624d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f9625e < 0) {
                getSerializedSize();
            }
            return this.f9625e;
        }

        public String getDataType() {
            return this.f9622b;
        }

        public String getFlag() {
            return this.f9624d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDataType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDataType());
            }
            if (hasFlag()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getFlag());
            }
            this.f9625e = i;
            return i;
        }

        public boolean hasDataType() {
            return this.f9621a;
        }

        public boolean hasFlag() {
            return this.f9623c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setDataType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setFlag(codedInputStreamMicro.readString());
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

        public Content setDataType(String str) {
            this.f9621a = true;
            this.f9622b = str;
            return this;
        }

        public Content setFlag(String str) {
            this.f9623c = true;
            this.f9624d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDataType()) {
                codedOutputStreamMicro.writeString(1, getDataType());
            }
            if (hasFlag()) {
                codedOutputStreamMicro.writeString(2, getFlag());
            }
        }
    }

    public static BdIcon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BdIcon().mergeFrom(codedInputStreamMicro);
    }

    public static BdIcon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BdIcon) new BdIcon().mergeFrom(bArr);
    }

    public BdIcon addContent(Content content) {
        if (content != null) {
            if (this.f9626a.isEmpty()) {
                this.f9626a = new ArrayList();
            }
            this.f9626a.add(content);
        }
        return this;
    }

    public final BdIcon clear() {
        clearContent();
        this.f9627b = -1;
        return this;
    }

    public BdIcon clearContent() {
        this.f9626a = Collections.emptyList();
        return this;
    }

    public int getCachedSize() {
        if (this.f9627b < 0) {
            getSerializedSize();
        }
        return this.f9627b;
    }

    public Content getContent(int i) {
        return (Content) this.f9626a.get(i);
    }

    public int getContentCount() {
        return this.f9626a.size();
    }

    public List<Content> getContentList() {
        return this.f9626a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Content computeMessageSize : getContentList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        this.f9627b = i;
        return i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public BdIcon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro content = new Content();
                    codedInputStreamMicro.readMessage(content);
                    addContent(content);
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

    public BdIcon setContent(int i, Content content) {
        if (content != null) {
            this.f9626a.set(i, content);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
    }
}
