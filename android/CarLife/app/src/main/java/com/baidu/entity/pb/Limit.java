package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Limit extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f11854a;
    /* renamed from: b */
    private Option f11855b = null;
    /* renamed from: c */
    private boolean f11856c;
    /* renamed from: d */
    private Content f11857d = null;
    /* renamed from: e */
    private int f11858e = -1;

    public static final class Content extends MessageMicro {
        public static final int IS_LIMIT_FIELD_NUMBER = 1;
        public static final int NUM_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f11845a;
        /* renamed from: b */
        private boolean f11846b = false;
        /* renamed from: c */
        private List<Integer> f11847c = Collections.emptyList();
        /* renamed from: d */
        private int f11848d = -1;

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addNum(int i) {
            if (this.f11847c.isEmpty()) {
                this.f11847c = new ArrayList();
            }
            this.f11847c.add(Integer.valueOf(i));
            return this;
        }

        public final Content clear() {
            clearIsLimit();
            clearNum();
            this.f11848d = -1;
            return this;
        }

        public Content clearIsLimit() {
            this.f11845a = false;
            this.f11846b = false;
            return this;
        }

        public Content clearNum() {
            this.f11847c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f11848d < 0) {
                getSerializedSize();
            }
            return this.f11848d;
        }

        public boolean getIsLimit() {
            return this.f11846b;
        }

        public int getNum(int i) {
            return ((Integer) this.f11847c.get(i)).intValue();
        }

        public int getNumCount() {
            return this.f11847c.size();
        }

        public List<Integer> getNumList() {
            return this.f11847c;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeBoolSize = hasIsLimit() ? CodedOutputStreamMicro.computeBoolSize(1, getIsLimit()) + 0 : 0;
            for (Integer intValue : getNumList()) {
                i += CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue());
            }
            int size = (computeBoolSize + i) + (getNumList().size() * 1);
            this.f11848d = size;
            return size;
        }

        public boolean hasIsLimit() {
            return this.f11845a;
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
                    case 8:
                        setIsLimit(codedInputStreamMicro.readBool());
                        continue;
                    case 16:
                        addNum(codedInputStreamMicro.readInt32());
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

        public Content setIsLimit(boolean z) {
            this.f11845a = true;
            this.f11846b = z;
            return this;
        }

        public Content setNum(int i, int i2) {
            this.f11847c.set(i, Integer.valueOf(i2));
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsLimit()) {
                codedOutputStreamMicro.writeBool(1, getIsLimit());
            }
            for (Integer intValue : getNumList()) {
                codedOutputStreamMicro.writeInt32(2, intValue.intValue());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERR_MSG_FIELD_NUMBER = 2;
        public static final int ERR_NO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11849a;
        /* renamed from: b */
        private int f11850b = 0;
        /* renamed from: c */
        private boolean f11851c;
        /* renamed from: d */
        private String f11852d = "";
        /* renamed from: e */
        private int f11853e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearErrNo();
            clearErrMsg();
            this.f11853e = -1;
            return this;
        }

        public Option clearErrMsg() {
            this.f11851c = false;
            this.f11852d = "";
            return this;
        }

        public Option clearErrNo() {
            this.f11849a = false;
            this.f11850b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f11853e < 0) {
                getSerializedSize();
            }
            return this.f11853e;
        }

        public String getErrMsg() {
            return this.f11852d;
        }

        public int getErrNo() {
            return this.f11850b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasErrNo()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getErrNo());
            }
            if (hasErrMsg()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getErrMsg());
            }
            this.f11853e = i;
            return i;
        }

        public boolean hasErrMsg() {
            return this.f11851c;
        }

        public boolean hasErrNo() {
            return this.f11849a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setErrNo(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setErrMsg(codedInputStreamMicro.readString());
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

        public Option setErrMsg(String str) {
            this.f11851c = true;
            this.f11852d = str;
            return this;
        }

        public Option setErrNo(int i) {
            this.f11849a = true;
            this.f11850b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasErrNo()) {
                codedOutputStreamMicro.writeInt32(1, getErrNo());
            }
            if (hasErrMsg()) {
                codedOutputStreamMicro.writeString(2, getErrMsg());
            }
        }
    }

    public static Limit parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Limit().mergeFrom(codedInputStreamMicro);
    }

    public static Limit parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Limit) new Limit().mergeFrom(bArr);
    }

    public final Limit clear() {
        clearOption();
        clearContent();
        this.f11858e = -1;
        return this;
    }

    public Limit clearContent() {
        this.f11856c = false;
        this.f11857d = null;
        return this;
    }

    public Limit clearOption() {
        this.f11854a = false;
        this.f11855b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f11858e < 0) {
            getSerializedSize();
        }
        return this.f11858e;
    }

    public Content getContent() {
        return this.f11857d;
    }

    public Option getOption() {
        return this.f11855b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        this.f11858e = i;
        return i;
    }

    public boolean hasContent() {
        return this.f11856c;
    }

    public boolean hasOption() {
        return this.f11854a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Limit mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro option;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
                    continue;
                case 18:
                    option = new Content();
                    codedInputStreamMicro.readMessage(option);
                    setContent(option);
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

    public Limit setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f11856c = true;
        this.f11857d = content;
        return this;
    }

    public Limit setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f11854a = true;
        this.f11855b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
    }
}
