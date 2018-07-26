package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LiveList extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f11887a;
    /* renamed from: b */
    private int f11888b = 0;
    /* renamed from: c */
    private boolean f11889c;
    /* renamed from: d */
    private String f11890d = "";
    /* renamed from: e */
    private boolean f11891e;
    /* renamed from: f */
    private Data f11892f = null;
    /* renamed from: g */
    private int f11893g = -1;

    public static final class Data extends MessageMicro {
        public static final int PLAINS_FIELD_NUMBER = 2;
        public static final int SPECIALS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Content> f11884a = Collections.emptyList();
        /* renamed from: b */
        private List<Content> f11885b = Collections.emptyList();
        /* renamed from: c */
        private int f11886c = -1;

        public static final class Content extends MessageMicro {
            public static final int BIMG_FIELD_NUMBER = 7;
            public static final int DEADLINE_FIELD_NUMBER = 9;
            public static final int DESP_FIELD_NUMBER = 2;
            public static final int IFTHIRD_FIELD_NUMBER = 10;
            public static final int PLANID_FIELD_NUMBER = 4;
            public static final int PRESENT_FIELD_NUMBER = 3;
            public static final int SIMG_FIELD_NUMBER = 8;
            public static final int STATE_FIELD_NUMBER = 6;
            public static final int STATUS_FIELD_NUMBER = 5;
            public static final int THIRDNAME_FIELD_NUMBER = 12;
            public static final int THIRDURL_FIELD_NUMBER = 11;
            public static final int TITLE_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f11859a;
            /* renamed from: b */
            private String f11860b = "";
            /* renamed from: c */
            private boolean f11861c;
            /* renamed from: d */
            private String f11862d = "";
            /* renamed from: e */
            private boolean f11863e;
            /* renamed from: f */
            private String f11864f = "";
            /* renamed from: g */
            private boolean f11865g;
            /* renamed from: h */
            private String f11866h = "";
            /* renamed from: i */
            private boolean f11867i;
            /* renamed from: j */
            private int f11868j = 0;
            /* renamed from: k */
            private boolean f11869k;
            /* renamed from: l */
            private String f11870l = "";
            /* renamed from: m */
            private boolean f11871m;
            /* renamed from: n */
            private String f11872n = "";
            /* renamed from: o */
            private boolean f11873o;
            /* renamed from: p */
            private String f11874p = "";
            /* renamed from: q */
            private boolean f11875q;
            /* renamed from: r */
            private int f11876r = 0;
            /* renamed from: s */
            private boolean f11877s;
            /* renamed from: t */
            private int f11878t = 0;
            /* renamed from: u */
            private boolean f11879u;
            /* renamed from: v */
            private String f11880v = "";
            /* renamed from: w */
            private boolean f11881w;
            /* renamed from: x */
            private String f11882x = "";
            /* renamed from: y */
            private int f11883y = -1;

            public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Content().mergeFrom(codedInputStreamMicro);
            }

            public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Content) new Content().mergeFrom(bArr);
            }

            public final Content clear() {
                clearTitle();
                clearDesp();
                clearPresent();
                clearPlanid();
                clearStatus();
                clearState();
                clearBimg();
                clearSimg();
                clearDeadline();
                clearIfthird();
                clearThirdurl();
                clearThirdname();
                this.f11883y = -1;
                return this;
            }

            public Content clearBimg() {
                this.f11871m = false;
                this.f11872n = "";
                return this;
            }

            public Content clearDeadline() {
                this.f11875q = false;
                this.f11876r = 0;
                return this;
            }

            public Content clearDesp() {
                this.f11861c = false;
                this.f11862d = "";
                return this;
            }

            public Content clearIfthird() {
                this.f11877s = false;
                this.f11878t = 0;
                return this;
            }

            public Content clearPlanid() {
                this.f11865g = false;
                this.f11866h = "";
                return this;
            }

            public Content clearPresent() {
                this.f11863e = false;
                this.f11864f = "";
                return this;
            }

            public Content clearSimg() {
                this.f11873o = false;
                this.f11874p = "";
                return this;
            }

            public Content clearState() {
                this.f11869k = false;
                this.f11870l = "";
                return this;
            }

            public Content clearStatus() {
                this.f11867i = false;
                this.f11868j = 0;
                return this;
            }

            public Content clearThirdname() {
                this.f11881w = false;
                this.f11882x = "";
                return this;
            }

            public Content clearThirdurl() {
                this.f11879u = false;
                this.f11880v = "";
                return this;
            }

            public Content clearTitle() {
                this.f11859a = false;
                this.f11860b = "";
                return this;
            }

            public String getBimg() {
                return this.f11872n;
            }

            public int getCachedSize() {
                if (this.f11883y < 0) {
                    getSerializedSize();
                }
                return this.f11883y;
            }

            public int getDeadline() {
                return this.f11876r;
            }

            public String getDesp() {
                return this.f11862d;
            }

            public int getIfthird() {
                return this.f11878t;
            }

            public String getPlanid() {
                return this.f11866h;
            }

            public String getPresent() {
                return this.f11864f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTitle()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                }
                if (hasDesp()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getDesp());
                }
                if (hasPresent()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getPresent());
                }
                if (hasPlanid()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getPlanid());
                }
                if (hasStatus()) {
                    i += CodedOutputStreamMicro.computeInt32Size(5, getStatus());
                }
                if (hasState()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getState());
                }
                if (hasBimg()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getBimg());
                }
                if (hasSimg()) {
                    i += CodedOutputStreamMicro.computeStringSize(8, getSimg());
                }
                if (hasDeadline()) {
                    i += CodedOutputStreamMicro.computeInt32Size(9, getDeadline());
                }
                if (hasIfthird()) {
                    i += CodedOutputStreamMicro.computeInt32Size(10, getIfthird());
                }
                if (hasThirdurl()) {
                    i += CodedOutputStreamMicro.computeStringSize(11, getThirdurl());
                }
                if (hasThirdname()) {
                    i += CodedOutputStreamMicro.computeStringSize(12, getThirdname());
                }
                this.f11883y = i;
                return i;
            }

            public String getSimg() {
                return this.f11874p;
            }

            public String getState() {
                return this.f11870l;
            }

            public int getStatus() {
                return this.f11868j;
            }

            public String getThirdname() {
                return this.f11882x;
            }

            public String getThirdurl() {
                return this.f11880v;
            }

            public String getTitle() {
                return this.f11860b;
            }

            public boolean hasBimg() {
                return this.f11871m;
            }

            public boolean hasDeadline() {
                return this.f11875q;
            }

            public boolean hasDesp() {
                return this.f11861c;
            }

            public boolean hasIfthird() {
                return this.f11877s;
            }

            public boolean hasPlanid() {
                return this.f11865g;
            }

            public boolean hasPresent() {
                return this.f11863e;
            }

            public boolean hasSimg() {
                return this.f11873o;
            }

            public boolean hasState() {
                return this.f11869k;
            }

            public boolean hasStatus() {
                return this.f11867i;
            }

            public boolean hasThirdname() {
                return this.f11881w;
            }

            public boolean hasThirdurl() {
                return this.f11879u;
            }

            public boolean hasTitle() {
                return this.f11859a;
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
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setDesp(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setPresent(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setPlanid(codedInputStreamMicro.readString());
                            continue;
                        case 40:
                            setStatus(codedInputStreamMicro.readInt32());
                            continue;
                        case 50:
                            setState(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setBimg(codedInputStreamMicro.readString());
                            continue;
                        case 66:
                            setSimg(codedInputStreamMicro.readString());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setDeadline(codedInputStreamMicro.readInt32());
                            continue;
                        case 80:
                            setIfthird(codedInputStreamMicro.readInt32());
                            continue;
                        case 90:
                            setThirdurl(codedInputStreamMicro.readString());
                            continue;
                        case 98:
                            setThirdname(codedInputStreamMicro.readString());
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

            public Content setBimg(String str) {
                this.f11871m = true;
                this.f11872n = str;
                return this;
            }

            public Content setDeadline(int i) {
                this.f11875q = true;
                this.f11876r = i;
                return this;
            }

            public Content setDesp(String str) {
                this.f11861c = true;
                this.f11862d = str;
                return this;
            }

            public Content setIfthird(int i) {
                this.f11877s = true;
                this.f11878t = i;
                return this;
            }

            public Content setPlanid(String str) {
                this.f11865g = true;
                this.f11866h = str;
                return this;
            }

            public Content setPresent(String str) {
                this.f11863e = true;
                this.f11864f = str;
                return this;
            }

            public Content setSimg(String str) {
                this.f11873o = true;
                this.f11874p = str;
                return this;
            }

            public Content setState(String str) {
                this.f11869k = true;
                this.f11870l = str;
                return this;
            }

            public Content setStatus(int i) {
                this.f11867i = true;
                this.f11868j = i;
                return this;
            }

            public Content setThirdname(String str) {
                this.f11881w = true;
                this.f11882x = str;
                return this;
            }

            public Content setThirdurl(String str) {
                this.f11879u = true;
                this.f11880v = str;
                return this;
            }

            public Content setTitle(String str) {
                this.f11859a = true;
                this.f11860b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasDesp()) {
                    codedOutputStreamMicro.writeString(2, getDesp());
                }
                if (hasPresent()) {
                    codedOutputStreamMicro.writeString(3, getPresent());
                }
                if (hasPlanid()) {
                    codedOutputStreamMicro.writeString(4, getPlanid());
                }
                if (hasStatus()) {
                    codedOutputStreamMicro.writeInt32(5, getStatus());
                }
                if (hasState()) {
                    codedOutputStreamMicro.writeString(6, getState());
                }
                if (hasBimg()) {
                    codedOutputStreamMicro.writeString(7, getBimg());
                }
                if (hasSimg()) {
                    codedOutputStreamMicro.writeString(8, getSimg());
                }
                if (hasDeadline()) {
                    codedOutputStreamMicro.writeInt32(9, getDeadline());
                }
                if (hasIfthird()) {
                    codedOutputStreamMicro.writeInt32(10, getIfthird());
                }
                if (hasThirdurl()) {
                    codedOutputStreamMicro.writeString(11, getThirdurl());
                }
                if (hasThirdname()) {
                    codedOutputStreamMicro.writeString(12, getThirdname());
                }
            }
        }

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addPlains(Content content) {
            if (content != null) {
                if (this.f11885b.isEmpty()) {
                    this.f11885b = new ArrayList();
                }
                this.f11885b.add(content);
            }
            return this;
        }

        public Data addSpecials(Content content) {
            if (content != null) {
                if (this.f11884a.isEmpty()) {
                    this.f11884a = new ArrayList();
                }
                this.f11884a.add(content);
            }
            return this;
        }

        public final Data clear() {
            clearSpecials();
            clearPlains();
            this.f11886c = -1;
            return this;
        }

        public Data clearPlains() {
            this.f11885b = Collections.emptyList();
            return this;
        }

        public Data clearSpecials() {
            this.f11884a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f11886c < 0) {
                getSerializedSize();
            }
            return this.f11886c;
        }

        public Content getPlains(int i) {
            return (Content) this.f11885b.get(i);
        }

        public int getPlainsCount() {
            return this.f11885b.size();
        }

        public List<Content> getPlainsList() {
            return this.f11885b;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Content computeMessageSize : getSpecialsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            for (Content computeMessageSize2 : getPlainsList()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
            }
            this.f11886c = i;
            return i;
        }

        public Content getSpecials(int i) {
            return (Content) this.f11884a.get(i);
        }

        public int getSpecialsCount() {
            return this.f11884a.size();
        }

        public List<Content> getSpecialsList() {
            return this.f11884a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Data mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro content;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        content = new Content();
                        codedInputStreamMicro.readMessage(content);
                        addSpecials(content);
                        continue;
                    case 18:
                        content = new Content();
                        codedInputStreamMicro.readMessage(content);
                        addPlains(content);
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

        public Data setPlains(int i, Content content) {
            if (content != null) {
                this.f11885b.set(i, content);
            }
            return this;
        }

        public Data setSpecials(int i, Content content) {
            if (content != null) {
                this.f11884a.set(i, content);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Content writeMessage : getSpecialsList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            for (Content writeMessage2 : getPlainsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage2);
            }
        }
    }

    public static LiveList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new LiveList().mergeFrom(codedInputStreamMicro);
    }

    public static LiveList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (LiveList) new LiveList().mergeFrom(bArr);
    }

    public final LiveList clear() {
        clearError();
        clearMsg();
        clearData();
        this.f11893g = -1;
        return this;
    }

    public LiveList clearData() {
        this.f11891e = false;
        this.f11892f = null;
        return this;
    }

    public LiveList clearError() {
        this.f11887a = false;
        this.f11888b = 0;
        return this;
    }

    public LiveList clearMsg() {
        this.f11889c = false;
        this.f11890d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f11893g < 0) {
            getSerializedSize();
        }
        return this.f11893g;
    }

    public Data getData() {
        return this.f11892f;
    }

    public int getError() {
        return this.f11888b;
    }

    public String getMsg() {
        return this.f11890d;
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
        this.f11893g = i;
        return i;
    }

    public boolean hasData() {
        return this.f11891e;
    }

    public boolean hasError() {
        return this.f11887a;
    }

    public boolean hasMsg() {
        return this.f11889c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public LiveList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public LiveList setData(Data data) {
        if (data == null) {
            return clearData();
        }
        this.f11891e = true;
        this.f11892f = data;
        return this;
    }

    public LiveList setError(int i) {
        this.f11887a = true;
        this.f11888b = i;
        return this;
    }

    public LiveList setMsg(String str) {
        this.f11889c = true;
        this.f11890d = str;
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
