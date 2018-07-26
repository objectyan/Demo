package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Livehome extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11927a;
    /* renamed from: b */
    private int f11928b = 0;
    /* renamed from: c */
    private boolean f11929c;
    /* renamed from: d */
    private String f11930d = "";
    /* renamed from: e */
    private List<Data> f11931e = Collections.emptyList();
    /* renamed from: f */
    private int f11932f = -1;

    public static final class Data extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 2;
        public static final int LATEST_FIELD_NUMBER = 3;
        public static final int PLANID_FIELD_NUMBER = 6;
        public static final int PRESENT_FIELD_NUMBER = 4;
        public static final int STAMP_FIELD_NUMBER = 5;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11914a;
        /* renamed from: b */
        private String f11915b = "";
        /* renamed from: c */
        private boolean f11916c;
        /* renamed from: d */
        private String f11917d = "";
        /* renamed from: e */
        private boolean f11918e;
        /* renamed from: f */
        private String f11919f = "";
        /* renamed from: g */
        private boolean f11920g;
        /* renamed from: h */
        private String f11921h = "";
        /* renamed from: i */
        private boolean f11922i;
        /* renamed from: j */
        private String f11923j = "";
        /* renamed from: k */
        private boolean f11924k;
        /* renamed from: l */
        private String f11925l = "";
        /* renamed from: m */
        private int f11926m = -1;

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public final Data clear() {
            clearTitle();
            clearDesc();
            clearLatest();
            clearPresent();
            clearStamp();
            clearPlanid();
            this.f11926m = -1;
            return this;
        }

        public Data clearDesc() {
            this.f11916c = false;
            this.f11917d = "";
            return this;
        }

        public Data clearLatest() {
            this.f11918e = false;
            this.f11919f = "";
            return this;
        }

        public Data clearPlanid() {
            this.f11924k = false;
            this.f11925l = "";
            return this;
        }

        public Data clearPresent() {
            this.f11920g = false;
            this.f11921h = "";
            return this;
        }

        public Data clearStamp() {
            this.f11922i = false;
            this.f11923j = "";
            return this;
        }

        public Data clearTitle() {
            this.f11914a = false;
            this.f11915b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11926m < 0) {
                getSerializedSize();
            }
            return this.f11926m;
        }

        public String getDesc() {
            return this.f11917d;
        }

        public String getLatest() {
            return this.f11919f;
        }

        public String getPlanid() {
            return this.f11925l;
        }

        public String getPresent() {
            return this.f11921h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getDesc());
            }
            if (hasLatest()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getLatest());
            }
            if (hasPresent()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getPresent());
            }
            if (hasStamp()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getStamp());
            }
            if (hasPlanid()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getPlanid());
            }
            this.f11926m = i;
            return i;
        }

        public String getStamp() {
            return this.f11923j;
        }

        public String getTitle() {
            return this.f11915b;
        }

        public boolean hasDesc() {
            return this.f11916c;
        }

        public boolean hasLatest() {
            return this.f11918e;
        }

        public boolean hasPlanid() {
            return this.f11924k;
        }

        public boolean hasPresent() {
            return this.f11920g;
        }

        public boolean hasStamp() {
            return this.f11922i;
        }

        public boolean hasTitle() {
            return this.f11914a;
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
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setDesc(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setLatest(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setPresent(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setStamp(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setPlanid(codedInputStreamMicro.readString());
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

        public Data setDesc(String str) {
            this.f11916c = true;
            this.f11917d = str;
            return this;
        }

        public Data setLatest(String str) {
            this.f11918e = true;
            this.f11919f = str;
            return this;
        }

        public Data setPlanid(String str) {
            this.f11924k = true;
            this.f11925l = str;
            return this;
        }

        public Data setPresent(String str) {
            this.f11920g = true;
            this.f11921h = str;
            return this;
        }

        public Data setStamp(String str) {
            this.f11922i = true;
            this.f11923j = str;
            return this;
        }

        public Data setTitle(String str) {
            this.f11914a = true;
            this.f11915b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(2, getDesc());
            }
            if (hasLatest()) {
                codedOutputStreamMicro.writeString(3, getLatest());
            }
            if (hasPresent()) {
                codedOutputStreamMicro.writeString(4, getPresent());
            }
            if (hasStamp()) {
                codedOutputStreamMicro.writeString(5, getStamp());
            }
            if (hasPlanid()) {
                codedOutputStreamMicro.writeString(6, getPlanid());
            }
        }
    }

    public static Livehome parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Livehome().mergeFrom(codedInputStreamMicro);
    }

    public static Livehome parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Livehome) new Livehome().mergeFrom(bArr);
    }

    public Livehome addData(Data data) {
        if (data != null) {
            if (this.f11931e.isEmpty()) {
                this.f11931e = new ArrayList();
            }
            this.f11931e.add(data);
        }
        return this;
    }

    public final Livehome clear() {
        clearError();
        clearMsg();
        clearData();
        this.f11932f = -1;
        return this;
    }

    public Livehome clearData() {
        this.f11931e = Collections.emptyList();
        return this;
    }

    public Livehome clearError() {
        this.f11927a = false;
        this.f11928b = 0;
        return this;
    }

    public Livehome clearMsg() {
        this.f11929c = false;
        this.f11930d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11932f < 0) {
            getSerializedSize();
        }
        return this.f11932f;
    }

    public Data getData(int i) {
        return (Data) this.f11931e.get(i);
    }

    public int getDataCount() {
        return this.f11931e.size();
    }

    public List<Data> getDataList() {
        return this.f11931e;
    }

    public int getError() {
        return this.f11928b;
    }

    public String getMsg() {
        return this.f11930d;
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
        this.f11932f = i2;
        return i2;
    }

    public boolean hasError() {
        return this.f11927a;
    }

    public boolean hasMsg() {
        return this.f11929c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Livehome mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public Livehome setData(int i, Data data) {
        if (data != null) {
            this.f11931e.set(i, data);
        }
        return this;
    }

    public Livehome setError(int i) {
        this.f11927a = true;
        this.f11928b = i;
        return this;
    }

    public Livehome setMsg(String str) {
        this.f11929c = true;
        this.f11930d = str;
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
