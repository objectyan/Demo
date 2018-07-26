package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Taxi extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f15946a;
    /* renamed from: b */
    private Option f15947b = null;
    /* renamed from: c */
    private List<Content> f15948c = Collections.emptyList();
    /* renamed from: d */
    private int f15949d = -1;

    public static final class Content extends MessageMicro {
        public static final int ACTION_FIELD_NUMBER = 1;
        public static final int EXT_PARAM_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15936a;
        /* renamed from: b */
        private String f15937b = "";
        /* renamed from: c */
        private boolean f15938c;
        /* renamed from: d */
        private ExtParam f15939d = null;
        /* renamed from: e */
        private int f15940e = -1;

        public static final class ExtParam extends MessageMicro {
            public static final int JUMPTO_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f15933a;
            /* renamed from: b */
            private Jumpto f15934b = null;
            /* renamed from: c */
            private int f15935c = -1;

            public static final class Jumpto extends MessageMicro {
                public static final int CF_TAG_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f15930a;
                /* renamed from: b */
                private String f15931b = "";
                /* renamed from: c */
                private int f15932c = -1;

                public static Jumpto parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Jumpto().mergeFrom(codedInputStreamMicro);
                }

                public static Jumpto parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Jumpto) new Jumpto().mergeFrom(bArr);
                }

                public final Jumpto clear() {
                    clearCfTag();
                    this.f15932c = -1;
                    return this;
                }

                public Jumpto clearCfTag() {
                    this.f15930a = false;
                    this.f15931b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f15932c < 0) {
                        getSerializedSize();
                    }
                    return this.f15932c;
                }

                public String getCfTag() {
                    return this.f15931b;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCfTag()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCfTag());
                    }
                    this.f15932c = i;
                    return i;
                }

                public boolean hasCfTag() {
                    return this.f15930a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Jumpto mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setCfTag(codedInputStreamMicro.readString());
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

                public Jumpto setCfTag(String str) {
                    this.f15930a = true;
                    this.f15931b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCfTag()) {
                        codedOutputStreamMicro.writeString(1, getCfTag());
                    }
                }
            }

            public static ExtParam parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new ExtParam().mergeFrom(codedInputStreamMicro);
            }

            public static ExtParam parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (ExtParam) new ExtParam().mergeFrom(bArr);
            }

            public final ExtParam clear() {
                clearJumpto();
                this.f15935c = -1;
                return this;
            }

            public ExtParam clearJumpto() {
                this.f15933a = false;
                this.f15934b = null;
                return this;
            }

            public int getCachedSize() {
                if (this.f15935c < 0) {
                    getSerializedSize();
                }
                return this.f15935c;
            }

            public Jumpto getJumpto() {
                return this.f15934b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasJumpto()) {
                    i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getJumpto());
                }
                this.f15935c = i;
                return i;
            }

            public boolean hasJumpto() {
                return this.f15933a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public ExtParam mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro jumpto = new Jumpto();
                            codedInputStreamMicro.readMessage(jumpto);
                            setJumpto(jumpto);
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

            public ExtParam setJumpto(Jumpto jumpto) {
                if (jumpto == null) {
                    return clearJumpto();
                }
                this.f15933a = true;
                this.f15934b = jumpto;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasJumpto()) {
                    codedOutputStreamMicro.writeMessage(1, getJumpto());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearAction();
            clearExtParam();
            this.f15940e = -1;
            return this;
        }

        public Content clearAction() {
            this.f15936a = false;
            this.f15937b = "";
            return this;
        }

        public Content clearExtParam() {
            this.f15938c = false;
            this.f15939d = null;
            return this;
        }

        public String getAction() {
            return this.f15937b;
        }

        public int getCachedSize() {
            if (this.f15940e < 0) {
                getSerializedSize();
            }
            return this.f15940e;
        }

        public ExtParam getExtParam() {
            return this.f15939d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAction()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAction());
            }
            if (hasExtParam()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getExtParam());
            }
            this.f15940e = i;
            return i;
        }

        public boolean hasAction() {
            return this.f15936a;
        }

        public boolean hasExtParam() {
            return this.f15938c;
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
                        setAction(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro extParam = new ExtParam();
                        codedInputStreamMicro.readMessage(extParam);
                        setExtParam(extParam);
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

        public Content setAction(String str) {
            this.f15936a = true;
            this.f15937b = str;
            return this;
        }

        public Content setExtParam(ExtParam extParam) {
            if (extParam == null) {
                return clearExtParam();
            }
            this.f15938c = true;
            this.f15939d = extParam;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAction()) {
                codedOutputStreamMicro.writeString(1, getAction());
            }
            if (hasExtParam()) {
                codedOutputStreamMicro.writeMessage(2, getExtParam());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15941a;
        /* renamed from: b */
        private int f15942b = 0;
        /* renamed from: c */
        private boolean f15943c;
        /* renamed from: d */
        private int f15944d = 0;
        /* renamed from: e */
        private int f15945e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearError();
            clearVersion();
            this.f15945e = -1;
            return this;
        }

        public Option clearError() {
            this.f15941a = false;
            this.f15942b = 0;
            return this;
        }

        public Option clearVersion() {
            this.f15943c = false;
            this.f15944d = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15945e < 0) {
                getSerializedSize();
            }
            return this.f15945e;
        }

        public int getError() {
            return this.f15942b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasVersion()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getVersion());
            }
            this.f15945e = i;
            return i;
        }

        public int getVersion() {
            return this.f15944d;
        }

        public boolean hasError() {
            return this.f15941a;
        }

        public boolean hasVersion() {
            return this.f15943c;
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
                        setError(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setVersion(codedInputStreamMicro.readInt32());
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

        public Option setError(int i) {
            this.f15941a = true;
            this.f15942b = i;
            return this;
        }

        public Option setVersion(int i) {
            this.f15943c = true;
            this.f15944d = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (hasVersion()) {
                codedOutputStreamMicro.writeInt32(2, getVersion());
            }
        }
    }

    public static Taxi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Taxi().mergeFrom(codedInputStreamMicro);
    }

    public static Taxi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Taxi) new Taxi().mergeFrom(bArr);
    }

    public Taxi addContent(Content content) {
        if (content != null) {
            if (this.f15948c.isEmpty()) {
                this.f15948c = new ArrayList();
            }
            this.f15948c.add(content);
        }
        return this;
    }

    public final Taxi clear() {
        clearOption();
        clearContent();
        this.f15949d = -1;
        return this;
    }

    public Taxi clearContent() {
        this.f15948c = Collections.emptyList();
        return this;
    }

    public Taxi clearOption() {
        this.f15946a = false;
        this.f15947b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f15949d < 0) {
            getSerializedSize();
        }
        return this.f15949d;
    }

    public Content getContent(int i) {
        return (Content) this.f15948c.get(i);
    }

    public int getContentCount() {
        return this.f15948c.size();
    }

    public List<Content> getContentList() {
        return this.f15948c;
    }

    public Option getOption() {
        return this.f15947b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        int i2 = i;
        for (Content computeMessageSize : getContentList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        this.f15949d = i2;
        return i2;
    }

    public boolean hasOption() {
        return this.f15946a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Taxi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    addContent(option);
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

    public Taxi setContent(int i, Content content) {
        if (content != null) {
            this.f15948c.set(i, content);
        }
        return this;
    }

    public Taxi setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f15946a = true;
        this.f15947b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
    }
}
