package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class SpecialResult extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14649a;
    /* renamed from: b */
    private Content f14650b = null;
    /* renamed from: c */
    private int f14651c = -1;

    public static final class Content extends MessageMicro {
        public static final int LEVEL_FIELD_NUMBER = 3;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14642a;
        /* renamed from: b */
        private String f14643b = "";
        /* renamed from: c */
        private boolean f14644c;
        /* renamed from: d */
        private String f14645d = "";
        /* renamed from: e */
        private boolean f14646e;
        /* renamed from: f */
        private int f14647f = 0;
        /* renamed from: g */
        private int f14648g = -1;

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearX();
            clearY();
            clearLevel();
            this.f14648g = -1;
            return this;
        }

        public Content clearLevel() {
            this.f14646e = false;
            this.f14647f = 0;
            return this;
        }

        public Content clearX() {
            this.f14642a = false;
            this.f14643b = "";
            return this;
        }

        public Content clearY() {
            this.f14644c = false;
            this.f14645d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14648g < 0) {
                getSerializedSize();
            }
            return this.f14648g;
        }

        public int getLevel() {
            return this.f14647f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasX()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getX());
            }
            if (hasY()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getY());
            }
            if (hasLevel()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
            }
            this.f14648g = i;
            return i;
        }

        public String getX() {
            return this.f14643b;
        }

        public String getY() {
            return this.f14645d;
        }

        public boolean hasLevel() {
            return this.f14646e;
        }

        public boolean hasX() {
            return this.f14642a;
        }

        public boolean hasY() {
            return this.f14644c;
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
                        setX(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setY(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setLevel(codedInputStreamMicro.readInt32());
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

        public Content setLevel(int i) {
            this.f14646e = true;
            this.f14647f = i;
            return this;
        }

        public Content setX(String str) {
            this.f14642a = true;
            this.f14643b = str;
            return this;
        }

        public Content setY(String str) {
            this.f14644c = true;
            this.f14645d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasX()) {
                codedOutputStreamMicro.writeString(1, getX());
            }
            if (hasY()) {
                codedOutputStreamMicro.writeString(2, getY());
            }
            if (hasLevel()) {
                codedOutputStreamMicro.writeInt32(3, getLevel());
            }
        }
    }

    public static SpecialResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new SpecialResult().mergeFrom(codedInputStreamMicro);
    }

    public static SpecialResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (SpecialResult) new SpecialResult().mergeFrom(bArr);
    }

    public final SpecialResult clear() {
        clearContent();
        this.f14651c = -1;
        return this;
    }

    public SpecialResult clearContent() {
        this.f14649a = false;
        this.f14650b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14651c < 0) {
            getSerializedSize();
        }
        return this.f14651c;
    }

    public Content getContent() {
        return this.f14650b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasContent()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getContent());
        }
        this.f14651c = i;
        return i;
    }

    public boolean hasContent() {
        return this.f14649a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public SpecialResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro content = new Content();
                    codedInputStreamMicro.readMessage(content);
                    setContent(content);
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

    public SpecialResult setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f14649a = true;
        this.f14650b = content;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(1, getContent());
        }
    }
}
