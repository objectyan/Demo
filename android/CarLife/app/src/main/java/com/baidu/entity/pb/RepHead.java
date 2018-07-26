package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RepHead extends MessageMicro {
    public static final int MD5_FIELD_NUMBER = 1;
    public static final int MESSAGE_HEAD_FIELD_NUMBER = 3;
    public static final int RANGE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f14198a;
    /* renamed from: b */
    private String f14199b = "";
    /* renamed from: c */
    private boolean f14200c;
    /* renamed from: d */
    private String f14201d = "";
    /* renamed from: e */
    private List<MessageHead> f14202e = Collections.emptyList();
    /* renamed from: f */
    private int f14203f = -1;

    public static final class MessageHead extends MessageMicro {
        public static final int LENGTH_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int OFFSET_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14191a;
        /* renamed from: b */
        private int f14192b = 0;
        /* renamed from: c */
        private boolean f14193c;
        /* renamed from: d */
        private int f14194d = 0;
        /* renamed from: e */
        private boolean f14195e;
        /* renamed from: f */
        private String f14196f = "";
        /* renamed from: g */
        private int f14197g = -1;

        public static MessageHead parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MessageHead().mergeFrom(codedInputStreamMicro);
        }

        public static MessageHead parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MessageHead) new MessageHead().mergeFrom(bArr);
        }

        public final MessageHead clear() {
            clearOffset();
            clearLength();
            clearName();
            this.f14197g = -1;
            return this;
        }

        public MessageHead clearLength() {
            this.f14193c = false;
            this.f14194d = 0;
            return this;
        }

        public MessageHead clearName() {
            this.f14195e = false;
            this.f14196f = "";
            return this;
        }

        public MessageHead clearOffset() {
            this.f14191a = false;
            this.f14192b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14197g < 0) {
                getSerializedSize();
            }
            return this.f14197g;
        }

        public int getLength() {
            return this.f14194d;
        }

        public String getName() {
            return this.f14196f;
        }

        public int getOffset() {
            return this.f14192b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasOffset()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getOffset());
            }
            if (hasLength()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getLength());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            this.f14197g = i;
            return i;
        }

        public boolean hasLength() {
            return this.f14193c;
        }

        public boolean hasName() {
            return this.f14195e;
        }

        public boolean hasOffset() {
            return this.f14191a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MessageHead mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setOffset(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setLength(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        setName(codedInputStreamMicro.readString());
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

        public MessageHead setLength(int i) {
            this.f14193c = true;
            this.f14194d = i;
            return this;
        }

        public MessageHead setName(String str) {
            this.f14195e = true;
            this.f14196f = str;
            return this;
        }

        public MessageHead setOffset(int i) {
            this.f14191a = true;
            this.f14192b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasOffset()) {
                codedOutputStreamMicro.writeInt32(1, getOffset());
            }
            if (hasLength()) {
                codedOutputStreamMicro.writeInt32(2, getLength());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
        }
    }

    public static RepHead parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new RepHead().mergeFrom(codedInputStreamMicro);
    }

    public static RepHead parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (RepHead) new RepHead().mergeFrom(bArr);
    }

    public RepHead addMessageHead(MessageHead messageHead) {
        if (messageHead != null) {
            if (this.f14202e.isEmpty()) {
                this.f14202e = new ArrayList();
            }
            this.f14202e.add(messageHead);
        }
        return this;
    }

    public final RepHead clear() {
        clearMd5();
        clearRange();
        clearMessageHead();
        this.f14203f = -1;
        return this;
    }

    public RepHead clearMd5() {
        this.f14198a = false;
        this.f14199b = "";
        return this;
    }

    public RepHead clearMessageHead() {
        this.f14202e = Collections.emptyList();
        return this;
    }

    public RepHead clearRange() {
        this.f14200c = false;
        this.f14201d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f14203f < 0) {
            getSerializedSize();
        }
        return this.f14203f;
    }

    public String getMd5() {
        return this.f14199b;
    }

    public MessageHead getMessageHead(int i) {
        return (MessageHead) this.f14202e.get(i);
    }

    public int getMessageHeadCount() {
        return this.f14202e.size();
    }

    public List<MessageHead> getMessageHeadList() {
        return this.f14202e;
    }

    public String getRange() {
        return this.f14201d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasMd5()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getMd5());
        }
        if (hasRange()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getRange());
        }
        int i2 = i;
        for (MessageHead computeMessageSize : getMessageHeadList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        this.f14203f = i2;
        return i2;
    }

    public boolean hasMd5() {
        return this.f14198a;
    }

    public boolean hasRange() {
        return this.f14200c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public RepHead mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setMd5(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setRange(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    MessageMicro messageHead = new MessageHead();
                    codedInputStreamMicro.readMessage(messageHead);
                    addMessageHead(messageHead);
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

    public RepHead setMd5(String str) {
        this.f14198a = true;
        this.f14199b = str;
        return this;
    }

    public RepHead setMessageHead(int i, MessageHead messageHead) {
        if (messageHead != null) {
            this.f14202e.set(i, messageHead);
        }
        return this;
    }

    public RepHead setRange(String str) {
        this.f14200c = true;
        this.f14201d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasMd5()) {
            codedOutputStreamMicro.writeString(1, getMd5());
        }
        if (hasRange()) {
            codedOutputStreamMicro.writeString(2, getRange());
        }
        for (MessageHead writeMessage : getMessageHeadList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
    }
}
