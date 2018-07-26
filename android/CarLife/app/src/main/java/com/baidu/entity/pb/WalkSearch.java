package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WalkSearch extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int OPTION_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f17077a;
    /* renamed from: b */
    private int f17078b = 0;
    /* renamed from: c */
    private boolean f17079c;
    /* renamed from: d */
    private Option f17080d = null;
    /* renamed from: e */
    private List<Content> f17081e = Collections.emptyList();
    /* renamed from: f */
    private int f17082f = -1;

    public static final class Content extends MessageMicro {
        public static final int ADDR_FIELD_NUMBER = 4;
        public static final int DIST2ROUTE_FIELD_NUMBER = 9;
        public static final int DIST2START_FIELD_NUMBER = 8;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int STREET_ID_FIELD_NUMBER = 5;
        public static final int TEL_FIELD_NUMBER = 6;
        public static final int UID_FIELD_NUMBER = 7;
        public static final int X_FIELD_NUMBER = 2;
        public static final int Y_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f17055a;
        /* renamed from: b */
        private String f17056b = "";
        /* renamed from: c */
        private boolean f17057c;
        /* renamed from: d */
        private int f17058d = 0;
        /* renamed from: e */
        private boolean f17059e;
        /* renamed from: f */
        private int f17060f = 0;
        /* renamed from: g */
        private boolean f17061g;
        /* renamed from: h */
        private String f17062h = "";
        /* renamed from: i */
        private boolean f17063i;
        /* renamed from: j */
        private String f17064j = "";
        /* renamed from: k */
        private boolean f17065k;
        /* renamed from: l */
        private String f17066l = "";
        /* renamed from: m */
        private boolean f17067m;
        /* renamed from: n */
        private String f17068n = "";
        /* renamed from: o */
        private boolean f17069o;
        /* renamed from: p */
        private String f17070p = "";
        /* renamed from: q */
        private boolean f17071q;
        /* renamed from: r */
        private String f17072r = "";
        /* renamed from: s */
        private int f17073s = -1;

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearName();
            clearX();
            clearY();
            clearAddr();
            clearStreetId();
            clearTel();
            clearUid();
            clearDist2Start();
            clearDist2Route();
            this.f17073s = -1;
            return this;
        }

        public Content clearAddr() {
            this.f17061g = false;
            this.f17062h = "";
            return this;
        }

        public Content clearDist2Route() {
            this.f17071q = false;
            this.f17072r = "";
            return this;
        }

        public Content clearDist2Start() {
            this.f17069o = false;
            this.f17070p = "";
            return this;
        }

        public Content clearName() {
            this.f17055a = false;
            this.f17056b = "";
            return this;
        }

        public Content clearStreetId() {
            this.f17063i = false;
            this.f17064j = "";
            return this;
        }

        public Content clearTel() {
            this.f17065k = false;
            this.f17066l = "";
            return this;
        }

        public Content clearUid() {
            this.f17067m = false;
            this.f17068n = "";
            return this;
        }

        public Content clearX() {
            this.f17057c = false;
            this.f17058d = 0;
            return this;
        }

        public Content clearY() {
            this.f17059e = false;
            this.f17060f = 0;
            return this;
        }

        public String getAddr() {
            return this.f17062h;
        }

        public int getCachedSize() {
            if (this.f17073s < 0) {
                getSerializedSize();
            }
            return this.f17073s;
        }

        public String getDist2Route() {
            return this.f17072r;
        }

        public String getDist2Start() {
            return this.f17070p;
        }

        public String getName() {
            return this.f17056b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
            }
            if (hasX()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getX());
            }
            if (hasY()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getY());
            }
            if (hasAddr()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getAddr());
            }
            if (hasStreetId()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getStreetId());
            }
            if (hasTel()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getTel());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getUid());
            }
            if (hasDist2Start()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getDist2Start());
            }
            if (hasDist2Route()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getDist2Route());
            }
            this.f17073s = i;
            return i;
        }

        public String getStreetId() {
            return this.f17064j;
        }

        public String getTel() {
            return this.f17066l;
        }

        public String getUid() {
            return this.f17068n;
        }

        public int getX() {
            return this.f17058d;
        }

        public int getY() {
            return this.f17060f;
        }

        public boolean hasAddr() {
            return this.f17061g;
        }

        public boolean hasDist2Route() {
            return this.f17071q;
        }

        public boolean hasDist2Start() {
            return this.f17069o;
        }

        public boolean hasName() {
            return this.f17055a;
        }

        public boolean hasStreetId() {
            return this.f17063i;
        }

        public boolean hasTel() {
            return this.f17065k;
        }

        public boolean hasUid() {
            return this.f17067m;
        }

        public boolean hasX() {
            return this.f17057c;
        }

        public boolean hasY() {
            return this.f17059e;
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
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setX(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setY(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        setAddr(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setStreetId(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setTel(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setDist2Start(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setDist2Route(codedInputStreamMicro.readString());
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

        public Content setAddr(String str) {
            this.f17061g = true;
            this.f17062h = str;
            return this;
        }

        public Content setDist2Route(String str) {
            this.f17071q = true;
            this.f17072r = str;
            return this;
        }

        public Content setDist2Start(String str) {
            this.f17069o = true;
            this.f17070p = str;
            return this;
        }

        public Content setName(String str) {
            this.f17055a = true;
            this.f17056b = str;
            return this;
        }

        public Content setStreetId(String str) {
            this.f17063i = true;
            this.f17064j = str;
            return this;
        }

        public Content setTel(String str) {
            this.f17065k = true;
            this.f17066l = str;
            return this;
        }

        public Content setUid(String str) {
            this.f17067m = true;
            this.f17068n = str;
            return this;
        }

        public Content setX(int i) {
            this.f17057c = true;
            this.f17058d = i;
            return this;
        }

        public Content setY(int i) {
            this.f17059e = true;
            this.f17060f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasName()) {
                codedOutputStreamMicro.writeString(1, getName());
            }
            if (hasX()) {
                codedOutputStreamMicro.writeInt32(2, getX());
            }
            if (hasY()) {
                codedOutputStreamMicro.writeInt32(3, getY());
            }
            if (hasAddr()) {
                codedOutputStreamMicro.writeString(4, getAddr());
            }
            if (hasStreetId()) {
                codedOutputStreamMicro.writeString(5, getStreetId());
            }
            if (hasTel()) {
                codedOutputStreamMicro.writeString(6, getTel());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(7, getUid());
            }
            if (hasDist2Start()) {
                codedOutputStreamMicro.writeString(8, getDist2Start());
            }
            if (hasDist2Route()) {
                codedOutputStreamMicro.writeString(9, getDist2Route());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f17074a;
        /* renamed from: b */
        private int f17075b = 0;
        /* renamed from: c */
        private int f17076c = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearTotal();
            this.f17076c = -1;
            return this;
        }

        public Option clearTotal() {
            this.f17074a = false;
            this.f17075b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f17076c < 0) {
                getSerializedSize();
            }
            return this.f17076c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTotal()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
            }
            this.f17076c = i;
            return i;
        }

        public int getTotal() {
            return this.f17075b;
        }

        public boolean hasTotal() {
            return this.f17074a;
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
                        setTotal(codedInputStreamMicro.readInt32());
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

        public Option setTotal(int i) {
            this.f17074a = true;
            this.f17075b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
        }
    }

    public static WalkSearch parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new WalkSearch().mergeFrom(codedInputStreamMicro);
    }

    public static WalkSearch parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (WalkSearch) new WalkSearch().mergeFrom(bArr);
    }

    public WalkSearch addContent(Content content) {
        if (content != null) {
            if (this.f17081e.isEmpty()) {
                this.f17081e = new ArrayList();
            }
            this.f17081e.add(content);
        }
        return this;
    }

    public final WalkSearch clear() {
        clearError();
        clearOption();
        clearContent();
        this.f17082f = -1;
        return this;
    }

    public WalkSearch clearContent() {
        this.f17081e = Collections.emptyList();
        return this;
    }

    public WalkSearch clearError() {
        this.f17077a = false;
        this.f17078b = 0;
        return this;
    }

    public WalkSearch clearOption() {
        this.f17079c = false;
        this.f17080d = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f17082f < 0) {
            getSerializedSize();
        }
        return this.f17082f;
    }

    public Content getContent(int i) {
        return (Content) this.f17081e.get(i);
    }

    public int getContentCount() {
        return this.f17081e.size();
    }

    public List<Content> getContentList() {
        return this.f17081e;
    }

    public int getError() {
        return this.f17078b;
    }

    public Option getOption() {
        return this.f17080d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasOption()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getOption());
        }
        int i2 = i;
        for (Content computeMessageSize : getContentList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
        }
        this.f17082f = i2;
        return i2;
    }

    public boolean hasError() {
        return this.f17077a;
    }

    public boolean hasOption() {
        return this.f17079c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public WalkSearch mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro option;
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
                    continue;
                case 26:
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

    public WalkSearch setContent(int i, Content content) {
        if (content != null) {
            this.f17081e.set(i, content);
        }
        return this;
    }

    public WalkSearch setError(int i) {
        this.f17077a = true;
        this.f17078b = i;
        return this;
    }

    public WalkSearch setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f17079c = true;
        this.f17080d = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(2, getOption());
        }
        for (Content writeMessage : getContentList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage);
        }
    }
}
