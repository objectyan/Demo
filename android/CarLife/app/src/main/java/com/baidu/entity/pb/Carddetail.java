package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carddetail extends MessageMicro {
    public static final int MEISHI_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f10633a;
    /* renamed from: b */
    private Meishi f10634b = null;
    /* renamed from: c */
    private int f10635c = -1;

    public static final class Meishi extends MessageMicro {
        public static final int BUSINESS_SCOPE_FIELD_NUMBER = 2;
        public static final int BUSINESS_SCOPE_TYPE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<BusinessScope> f10629a = Collections.emptyList();
        /* renamed from: b */
        private boolean f10630b;
        /* renamed from: c */
        private String f10631c = "";
        /* renamed from: d */
        private int f10632d = -1;

        public static final class BusinessScope extends MessageMicro {
            public static final int NAME_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f10626a;
            /* renamed from: b */
            private String f10627b = "";
            /* renamed from: c */
            private int f10628c = -1;

            public static BusinessScope parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new BusinessScope().mergeFrom(codedInputStreamMicro);
            }

            public static BusinessScope parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (BusinessScope) new BusinessScope().mergeFrom(bArr);
            }

            public final BusinessScope clear() {
                clearName();
                this.f10628c = -1;
                return this;
            }

            public BusinessScope clearName() {
                this.f10626a = false;
                this.f10627b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10628c < 0) {
                    getSerializedSize();
                }
                return this.f10628c;
            }

            public String getName() {
                return this.f10627b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
                }
                this.f10628c = i;
                return i;
            }

            public boolean hasName() {
                return this.f10626a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public BusinessScope mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
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

            public BusinessScope setName(String str) {
                this.f10626a = true;
                this.f10627b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasName()) {
                    codedOutputStreamMicro.writeString(1, getName());
                }
            }
        }

        public static Meishi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Meishi().mergeFrom(codedInputStreamMicro);
        }

        public static Meishi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Meishi) new Meishi().mergeFrom(bArr);
        }

        public Meishi addBusinessScope(BusinessScope businessScope) {
            if (businessScope != null) {
                if (this.f10629a.isEmpty()) {
                    this.f10629a = new ArrayList();
                }
                this.f10629a.add(businessScope);
            }
            return this;
        }

        public final Meishi clear() {
            clearBusinessScope();
            clearBusinessScopeType();
            this.f10632d = -1;
            return this;
        }

        public Meishi clearBusinessScope() {
            this.f10629a = Collections.emptyList();
            return this;
        }

        public Meishi clearBusinessScopeType() {
            this.f10630b = false;
            this.f10631c = "";
            return this;
        }

        public BusinessScope getBusinessScope(int i) {
            return (BusinessScope) this.f10629a.get(i);
        }

        public int getBusinessScopeCount() {
            return this.f10629a.size();
        }

        public List<BusinessScope> getBusinessScopeList() {
            return this.f10629a;
        }

        public String getBusinessScopeType() {
            return this.f10631c;
        }

        public int getCachedSize() {
            if (this.f10632d < 0) {
                getSerializedSize();
            }
            return this.f10632d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasBusinessScopeType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getBusinessScopeType());
            }
            int i2 = i;
            for (BusinessScope computeMessageSize : getBusinessScopeList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f10632d = i2;
            return i2;
        }

        public boolean hasBusinessScopeType() {
            return this.f10630b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Meishi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setBusinessScopeType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro businessScope = new BusinessScope();
                        codedInputStreamMicro.readMessage(businessScope);
                        addBusinessScope(businessScope);
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

        public Meishi setBusinessScope(int i, BusinessScope businessScope) {
            if (businessScope != null) {
                this.f10629a.set(i, businessScope);
            }
            return this;
        }

        public Meishi setBusinessScopeType(String str) {
            this.f10630b = true;
            this.f10631c = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasBusinessScopeType()) {
                codedOutputStreamMicro.writeString(1, getBusinessScopeType());
            }
            for (BusinessScope writeMessage : getBusinessScopeList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static Carddetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Carddetail().mergeFrom(codedInputStreamMicro);
    }

    public static Carddetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Carddetail) new Carddetail().mergeFrom(bArr);
    }

    public final Carddetail clear() {
        clearMeishi();
        this.f10635c = -1;
        return this;
    }

    public Carddetail clearMeishi() {
        this.f10633a = false;
        this.f10634b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f10635c < 0) {
            getSerializedSize();
        }
        return this.f10635c;
    }

    public Meishi getMeishi() {
        return this.f10634b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasMeishi()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMeishi());
        }
        this.f10635c = i;
        return i;
    }

    public boolean hasMeishi() {
        return this.f10633a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Carddetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro meishi = new Meishi();
                    codedInputStreamMicro.readMessage(meishi);
                    setMeishi(meishi);
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

    public Carddetail setMeishi(Meishi meishi) {
        if (meishi == null) {
            return clearMeishi();
        }
        this.f10633a = true;
        this.f10634b = meishi;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasMeishi()) {
            codedOutputStreamMicro.writeMessage(1, getMeishi());
        }
    }
}
