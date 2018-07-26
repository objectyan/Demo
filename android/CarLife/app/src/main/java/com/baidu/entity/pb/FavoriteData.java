package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FavoriteData extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11130a;
    /* renamed from: b */
    private int f11131b = 0;
    /* renamed from: c */
    private boolean f11132c;
    /* renamed from: d */
    private String f11133d = "";
    /* renamed from: e */
    private List<Data> f11134e = Collections.emptyList();
    /* renamed from: f */
    private int f11135f = -1;

    public static final class Data extends MessageMicro {
        public static final int DETAILS_FIELD_NUMBER = 2;
        public static final int SUBKEY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11126a;
        /* renamed from: b */
        private String f11127b = "";
        /* renamed from: c */
        private List<Details> f11128c = Collections.emptyList();
        /* renamed from: d */
        private int f11129d = -1;

        public static final class Details extends MessageMicro {
            public static final int CTIME_FIELD_NUMBER = 4;
            public static final int DO_COUNT_FIELD_NUMBER = 3;
            public static final int IF_DO_FIELD_NUMBER = 2;
            public static final int THEME_ID_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f11117a;
            /* renamed from: b */
            private String f11118b = "";
            /* renamed from: c */
            private boolean f11119c;
            /* renamed from: d */
            private String f11120d = "";
            /* renamed from: e */
            private boolean f11121e;
            /* renamed from: f */
            private String f11122f = "";
            /* renamed from: g */
            private boolean f11123g;
            /* renamed from: h */
            private String f11124h = "";
            /* renamed from: i */
            private int f11125i = -1;

            public static Details parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Details().mergeFrom(codedInputStreamMicro);
            }

            public static Details parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Details) new Details().mergeFrom(bArr);
            }

            public final Details clear() {
                clearThemeId();
                clearIfDo();
                clearDoCount();
                clearCtime();
                this.f11125i = -1;
                return this;
            }

            public Details clearCtime() {
                this.f11123g = false;
                this.f11124h = "";
                return this;
            }

            public Details clearDoCount() {
                this.f11121e = false;
                this.f11122f = "";
                return this;
            }

            public Details clearIfDo() {
                this.f11119c = false;
                this.f11120d = "";
                return this;
            }

            public Details clearThemeId() {
                this.f11117a = false;
                this.f11118b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f11125i < 0) {
                    getSerializedSize();
                }
                return this.f11125i;
            }

            public String getCtime() {
                return this.f11124h;
            }

            public String getDoCount() {
                return this.f11122f;
            }

            public String getIfDo() {
                return this.f11120d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasThemeId()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThemeId());
                }
                if (hasIfDo()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getIfDo());
                }
                if (hasDoCount()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getDoCount());
                }
                if (hasCtime()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getCtime());
                }
                this.f11125i = i;
                return i;
            }

            public String getThemeId() {
                return this.f11118b;
            }

            public boolean hasCtime() {
                return this.f11123g;
            }

            public boolean hasDoCount() {
                return this.f11121e;
            }

            public boolean hasIfDo() {
                return this.f11119c;
            }

            public boolean hasThemeId() {
                return this.f11117a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Details mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setThemeId(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setIfDo(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setDoCount(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setCtime(codedInputStreamMicro.readString());
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

            public Details setCtime(String str) {
                this.f11123g = true;
                this.f11124h = str;
                return this;
            }

            public Details setDoCount(String str) {
                this.f11121e = true;
                this.f11122f = str;
                return this;
            }

            public Details setIfDo(String str) {
                this.f11119c = true;
                this.f11120d = str;
                return this;
            }

            public Details setThemeId(String str) {
                this.f11117a = true;
                this.f11118b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasThemeId()) {
                    codedOutputStreamMicro.writeString(1, getThemeId());
                }
                if (hasIfDo()) {
                    codedOutputStreamMicro.writeString(2, getIfDo());
                }
                if (hasDoCount()) {
                    codedOutputStreamMicro.writeString(3, getDoCount());
                }
                if (hasCtime()) {
                    codedOutputStreamMicro.writeString(4, getCtime());
                }
            }
        }

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addDetails(Details details) {
            if (details != null) {
                if (this.f11128c.isEmpty()) {
                    this.f11128c = new ArrayList();
                }
                this.f11128c.add(details);
            }
            return this;
        }

        public final Data clear() {
            clearSubkey();
            clearDetails();
            this.f11129d = -1;
            return this;
        }

        public Data clearDetails() {
            this.f11128c = Collections.emptyList();
            return this;
        }

        public Data clearSubkey() {
            this.f11126a = false;
            this.f11127b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11129d < 0) {
                getSerializedSize();
            }
            return this.f11129d;
        }

        public Details getDetails(int i) {
            return (Details) this.f11128c.get(i);
        }

        public int getDetailsCount() {
            return this.f11128c.size();
        }

        public List<Details> getDetailsList() {
            return this.f11128c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSubkey()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSubkey());
            }
            int i2 = i;
            for (Details computeMessageSize : getDetailsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f11129d = i2;
            return i2;
        }

        public String getSubkey() {
            return this.f11127b;
        }

        public boolean hasSubkey() {
            return this.f11126a;
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
                        setSubkey(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro details = new Details();
                        codedInputStreamMicro.readMessage(details);
                        addDetails(details);
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

        public Data setDetails(int i, Details details) {
            if (details != null) {
                this.f11128c.set(i, details);
            }
            return this;
        }

        public Data setSubkey(String str) {
            this.f11126a = true;
            this.f11127b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSubkey()) {
                codedOutputStreamMicro.writeString(1, getSubkey());
            }
            for (Details writeMessage : getDetailsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static FavoriteData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new FavoriteData().mergeFrom(codedInputStreamMicro);
    }

    public static FavoriteData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (FavoriteData) new FavoriteData().mergeFrom(bArr);
    }

    public FavoriteData addData(Data data) {
        if (data != null) {
            if (this.f11134e.isEmpty()) {
                this.f11134e = new ArrayList();
            }
            this.f11134e.add(data);
        }
        return this;
    }

    public final FavoriteData clear() {
        clearError();
        clearMsg();
        clearData();
        this.f11135f = -1;
        return this;
    }

    public FavoriteData clearData() {
        this.f11134e = Collections.emptyList();
        return this;
    }

    public FavoriteData clearError() {
        this.f11130a = false;
        this.f11131b = 0;
        return this;
    }

    public FavoriteData clearMsg() {
        this.f11132c = false;
        this.f11133d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11135f < 0) {
            getSerializedSize();
        }
        return this.f11135f;
    }

    public Data getData(int i) {
        return (Data) this.f11134e.get(i);
    }

    public int getDataCount() {
        return this.f11134e.size();
    }

    public List<Data> getDataList() {
        return this.f11134e;
    }

    public int getError() {
        return this.f11131b;
    }

    public String getMsg() {
        return this.f11133d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        int i2 = i;
        for (Data computeMessageSize : getDataList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        this.f11135f = i2;
        return i2;
    }

    public boolean hasError() {
        return this.f11130a;
    }

    public boolean hasMsg() {
        return this.f11132c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public FavoriteData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    addData(data);
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

    public FavoriteData setData(int i, Data data) {
        if (data != null) {
            this.f11134e.set(i, data);
        }
        return this;
    }

    public FavoriteData setError(int i) {
        this.f11130a = true;
        this.f11131b = i;
        return this;
    }

    public FavoriteData setMsg(String str) {
        this.f11132c = true;
        this.f11133d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
        for (Data writeMessage : getDataList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
    }
}
