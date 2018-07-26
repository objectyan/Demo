package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Violationlimit extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f16707a;
    /* renamed from: b */
    private int f16708b = 0;
    /* renamed from: c */
    private boolean f16709c;
    /* renamed from: d */
    private String f16710d = "";
    /* renamed from: e */
    private boolean f16711e;
    /* renamed from: f */
    private Data f16712f = null;
    /* renamed from: g */
    private int f16713g = -1;

    public static final class Data extends MessageMicro {
        public static final int LISTS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Lists> f16705a = Collections.emptyList();
        /* renamed from: b */
        private int f16706b = -1;

        public static final class Lists extends MessageMicro {
            public static final int CITYID_FIELD_NUMBER = 1;
            public static final int EXT_FIELD_NUMBER = 3;
            public static final int LIMITNUM_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16698a;
            /* renamed from: b */
            private int f16699b = 0;
            /* renamed from: c */
            private boolean f16700c;
            /* renamed from: d */
            private String f16701d = "";
            /* renamed from: e */
            private boolean f16702e;
            /* renamed from: f */
            private String f16703f = "";
            /* renamed from: g */
            private int f16704g = -1;

            public static Lists parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Lists().mergeFrom(codedInputStreamMicro);
            }

            public static Lists parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Lists) new Lists().mergeFrom(bArr);
            }

            public final Lists clear() {
                clearCityId();
                clearLimitNum();
                clearExt();
                this.f16704g = -1;
                return this;
            }

            public Lists clearCityId() {
                this.f16698a = false;
                this.f16699b = 0;
                return this;
            }

            public Lists clearExt() {
                this.f16702e = false;
                this.f16703f = "";
                return this;
            }

            public Lists clearLimitNum() {
                this.f16700c = false;
                this.f16701d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f16704g < 0) {
                    getSerializedSize();
                }
                return this.f16704g;
            }

            public int getCityId() {
                return this.f16699b;
            }

            public String getExt() {
                return this.f16703f;
            }

            public String getLimitNum() {
                return this.f16701d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasCityId()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityId());
                }
                if (hasLimitNum()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getLimitNum());
                }
                if (hasExt()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getExt());
                }
                this.f16704g = i;
                return i;
            }

            public boolean hasCityId() {
                return this.f16698a;
            }

            public boolean hasExt() {
                return this.f16702e;
            }

            public boolean hasLimitNum() {
                return this.f16700c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Lists mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setCityId(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setLimitNum(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setExt(codedInputStreamMicro.readString());
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

            public Lists setCityId(int i) {
                this.f16698a = true;
                this.f16699b = i;
                return this;
            }

            public Lists setExt(String str) {
                this.f16702e = true;
                this.f16703f = str;
                return this;
            }

            public Lists setLimitNum(String str) {
                this.f16700c = true;
                this.f16701d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasCityId()) {
                    codedOutputStreamMicro.writeInt32(1, getCityId());
                }
                if (hasLimitNum()) {
                    codedOutputStreamMicro.writeString(2, getLimitNum());
                }
                if (hasExt()) {
                    codedOutputStreamMicro.writeString(3, getExt());
                }
            }
        }

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addLists(Lists lists) {
            if (lists != null) {
                if (this.f16705a.isEmpty()) {
                    this.f16705a = new ArrayList();
                }
                this.f16705a.add(lists);
            }
            return this;
        }

        public final Data clear() {
            clearLists();
            this.f16706b = -1;
            return this;
        }

        public Data clearLists() {
            this.f16705a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f16706b < 0) {
                getSerializedSize();
            }
            return this.f16706b;
        }

        public Lists getLists(int i) {
            return (Lists) this.f16705a.get(i);
        }

        public int getListsCount() {
            return this.f16705a.size();
        }

        public List<Lists> getListsList() {
            return this.f16705a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Lists computeMessageSize : getListsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f16706b = i;
            return i;
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
                        MessageMicro lists = new Lists();
                        codedInputStreamMicro.readMessage(lists);
                        addLists(lists);
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

        public Data setLists(int i, Lists lists) {
            if (lists != null) {
                this.f16705a.set(i, lists);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Lists writeMessage : getListsList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static Violationlimit parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Violationlimit().mergeFrom(codedInputStreamMicro);
    }

    public static Violationlimit parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Violationlimit) new Violationlimit().mergeFrom(bArr);
    }

    public final Violationlimit clear() {
        clearError();
        clearMsg();
        clearData();
        this.f16713g = -1;
        return this;
    }

    public Violationlimit clearData() {
        this.f16711e = false;
        this.f16712f = null;
        return this;
    }

    public Violationlimit clearError() {
        this.f16707a = false;
        this.f16708b = 0;
        return this;
    }

    public Violationlimit clearMsg() {
        this.f16709c = false;
        this.f16710d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f16713g < 0) {
            getSerializedSize();
        }
        return this.f16713g;
    }

    public Data getData() {
        return this.f16712f;
    }

    public int getError() {
        return this.f16708b;
    }

    public String getMsg() {
        return this.f16710d;
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
        this.f16713g = i;
        return i;
    }

    public boolean hasData() {
        return this.f16711e;
    }

    public boolean hasError() {
        return this.f16707a;
    }

    public boolean hasMsg() {
        return this.f16709c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Violationlimit mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public Violationlimit setData(Data data) {
        if (data == null) {
            return clearData();
        }
        this.f16711e = true;
        this.f16712f = data;
        return this;
    }

    public Violationlimit setError(int i) {
        this.f16707a = true;
        this.f16708b = i;
        return this;
    }

    public Violationlimit setMsg(String str) {
        this.f16709c = true;
        this.f16710d = str;
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
