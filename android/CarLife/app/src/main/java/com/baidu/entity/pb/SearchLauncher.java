package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SearchLauncher extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14454a;
    /* renamed from: b */
    private Option f14455b = null;
    /* renamed from: c */
    private List<Content> f14456c = Collections.emptyList();
    /* renamed from: d */
    private int f14457d = -1;

    public static final class Content extends MessageMicro {
        public static final int ACTION_FIELD_NUMBER = 1;
        public static final int EXT_PARAM_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14444a;
        /* renamed from: b */
        private ExtParam f14445b = null;
        /* renamed from: c */
        private boolean f14446c;
        /* renamed from: d */
        private String f14447d = "";
        /* renamed from: e */
        private int f14448e = -1;

        public static final class ExtParam extends MessageMicro {
            public static final int BROWSER_FIELD_NUMBER = 2;
            public static final int JUMPTO_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14439a;
            /* renamed from: b */
            private Jumpto f14440b = null;
            /* renamed from: c */
            private boolean f14441c;
            /* renamed from: d */
            private Browser f14442d = null;
            /* renamed from: e */
            private int f14443e = -1;

            public static final class Browser extends MessageMicro {
                public static final int URL_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f14431a;
                /* renamed from: b */
                private String f14432b = "";
                /* renamed from: c */
                private int f14433c = -1;

                public static Browser parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Browser().mergeFrom(codedInputStreamMicro);
                }

                public static Browser parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Browser) new Browser().mergeFrom(bArr);
                }

                public final Browser clear() {
                    clearUrl();
                    this.f14433c = -1;
                    return this;
                }

                public Browser clearUrl() {
                    this.f14431a = false;
                    this.f14432b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f14433c < 0) {
                        getSerializedSize();
                    }
                    return this.f14433c;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasUrl()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
                    }
                    this.f14433c = i;
                    return i;
                }

                public String getUrl() {
                    return this.f14432b;
                }

                public boolean hasUrl() {
                    return this.f14431a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Browser mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setUrl(codedInputStreamMicro.readString());
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

                public Browser setUrl(String str) {
                    this.f14431a = true;
                    this.f14432b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasUrl()) {
                        codedOutputStreamMicro.writeString(1, getUrl());
                    }
                }
            }

            public static final class Jumpto extends MessageMicro {
                public static final int CF_TAG_FIELD_NUMBER = 1;
                public static final int PARAMS_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f14434a;
                /* renamed from: b */
                private String f14435b = "";
                /* renamed from: c */
                private boolean f14436c;
                /* renamed from: d */
                private String f14437d = "";
                /* renamed from: e */
                private int f14438e = -1;

                public static Jumpto parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Jumpto().mergeFrom(codedInputStreamMicro);
                }

                public static Jumpto parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Jumpto) new Jumpto().mergeFrom(bArr);
                }

                public final Jumpto clear() {
                    clearCfTag();
                    clearParams();
                    this.f14438e = -1;
                    return this;
                }

                public Jumpto clearCfTag() {
                    this.f14434a = false;
                    this.f14435b = "";
                    return this;
                }

                public Jumpto clearParams() {
                    this.f14436c = false;
                    this.f14437d = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f14438e < 0) {
                        getSerializedSize();
                    }
                    return this.f14438e;
                }

                public String getCfTag() {
                    return this.f14435b;
                }

                public String getParams() {
                    return this.f14437d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasCfTag()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCfTag());
                    }
                    if (hasParams()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getParams());
                    }
                    this.f14438e = i;
                    return i;
                }

                public boolean hasCfTag() {
                    return this.f14434a;
                }

                public boolean hasParams() {
                    return this.f14436c;
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
                            case 18:
                                setParams(codedInputStreamMicro.readString());
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
                    this.f14434a = true;
                    this.f14435b = str;
                    return this;
                }

                public Jumpto setParams(String str) {
                    this.f14436c = true;
                    this.f14437d = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasCfTag()) {
                        codedOutputStreamMicro.writeString(1, getCfTag());
                    }
                    if (hasParams()) {
                        codedOutputStreamMicro.writeString(2, getParams());
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
                clearBrowser();
                this.f14443e = -1;
                return this;
            }

            public ExtParam clearBrowser() {
                this.f14441c = false;
                this.f14442d = null;
                return this;
            }

            public ExtParam clearJumpto() {
                this.f14439a = false;
                this.f14440b = null;
                return this;
            }

            public Browser getBrowser() {
                return this.f14442d;
            }

            public int getCachedSize() {
                if (this.f14443e < 0) {
                    getSerializedSize();
                }
                return this.f14443e;
            }

            public Jumpto getJumpto() {
                return this.f14440b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasJumpto()) {
                    i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getJumpto());
                }
                if (hasBrowser()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, getBrowser());
                }
                this.f14443e = i;
                return i;
            }

            public boolean hasBrowser() {
                return this.f14441c;
            }

            public boolean hasJumpto() {
                return this.f14439a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public ExtParam mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro jumpto;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            jumpto = new Jumpto();
                            codedInputStreamMicro.readMessage(jumpto);
                            setJumpto(jumpto);
                            continue;
                        case 18:
                            jumpto = new Browser();
                            codedInputStreamMicro.readMessage(jumpto);
                            setBrowser(jumpto);
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

            public ExtParam setBrowser(Browser browser) {
                if (browser == null) {
                    return clearBrowser();
                }
                this.f14441c = true;
                this.f14442d = browser;
                return this;
            }

            public ExtParam setJumpto(Jumpto jumpto) {
                if (jumpto == null) {
                    return clearJumpto();
                }
                this.f14439a = true;
                this.f14440b = jumpto;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasJumpto()) {
                    codedOutputStreamMicro.writeMessage(1, getJumpto());
                }
                if (hasBrowser()) {
                    codedOutputStreamMicro.writeMessage(2, getBrowser());
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
            clearExtParam();
            clearAction();
            this.f14448e = -1;
            return this;
        }

        public Content clearAction() {
            this.f14446c = false;
            this.f14447d = "";
            return this;
        }

        public Content clearExtParam() {
            this.f14444a = false;
            this.f14445b = null;
            return this;
        }

        public String getAction() {
            return this.f14447d;
        }

        public int getCachedSize() {
            if (this.f14448e < 0) {
                getSerializedSize();
            }
            return this.f14448e;
        }

        public ExtParam getExtParam() {
            return this.f14445b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAction()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAction());
            }
            if (hasExtParam()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getExtParam());
            }
            this.f14448e = i;
            return i;
        }

        public boolean hasAction() {
            return this.f14446c;
        }

        public boolean hasExtParam() {
            return this.f14444a;
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
            this.f14446c = true;
            this.f14447d = str;
            return this;
        }

        public Content setExtParam(ExtParam extParam) {
            if (extParam == null) {
                return clearExtParam();
            }
            this.f14444a = true;
            this.f14445b = extParam;
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
        private boolean f14449a;
        /* renamed from: b */
        private int f14450b = 0;
        /* renamed from: c */
        private boolean f14451c;
        /* renamed from: d */
        private int f14452d = 0;
        /* renamed from: e */
        private int f14453e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearError();
            clearVersion();
            this.f14453e = -1;
            return this;
        }

        public Option clearError() {
            this.f14449a = false;
            this.f14450b = 0;
            return this;
        }

        public Option clearVersion() {
            this.f14451c = false;
            this.f14452d = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14453e < 0) {
                getSerializedSize();
            }
            return this.f14453e;
        }

        public int getError() {
            return this.f14450b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasVersion()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getVersion());
            }
            this.f14453e = i;
            return i;
        }

        public int getVersion() {
            return this.f14452d;
        }

        public boolean hasError() {
            return this.f14449a;
        }

        public boolean hasVersion() {
            return this.f14451c;
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
            this.f14449a = true;
            this.f14450b = i;
            return this;
        }

        public Option setVersion(int i) {
            this.f14451c = true;
            this.f14452d = i;
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

    public static SearchLauncher parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new SearchLauncher().mergeFrom(codedInputStreamMicro);
    }

    public static SearchLauncher parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (SearchLauncher) new SearchLauncher().mergeFrom(bArr);
    }

    public SearchLauncher addContent(Content content) {
        if (content != null) {
            if (this.f14456c.isEmpty()) {
                this.f14456c = new ArrayList();
            }
            this.f14456c.add(content);
        }
        return this;
    }

    public final SearchLauncher clear() {
        clearOption();
        clearContent();
        this.f14457d = -1;
        return this;
    }

    public SearchLauncher clearContent() {
        this.f14456c = Collections.emptyList();
        return this;
    }

    public SearchLauncher clearOption() {
        this.f14454a = false;
        this.f14455b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14457d < 0) {
            getSerializedSize();
        }
        return this.f14457d;
    }

    public Content getContent(int i) {
        return (Content) this.f14456c.get(i);
    }

    public int getContentCount() {
        return this.f14456c.size();
    }

    public List<Content> getContentList() {
        return this.f14456c;
    }

    public Option getOption() {
        return this.f14455b;
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
        this.f14457d = i2;
        return i2;
    }

    public boolean hasOption() {
        return this.f14454a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public SearchLauncher mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public SearchLauncher setContent(int i, Content content) {
        if (content != null) {
            this.f14456c.set(i, content);
        }
        return this;
    }

    public SearchLauncher setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f14454a = true;
        this.f14455b = option;
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
