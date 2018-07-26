package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Ads extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f9547a;
    /* renamed from: b */
    private Option f9548b = null;
    /* renamed from: c */
    private List<Content> f9549c = Collections.emptyList();
    /* renamed from: d */
    private int f9550d = -1;

    public static final class Content extends MessageMicro {
        public static final int CTRL_MODE_FIELD_NUMBER = 9;
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int DAY_TIMES_FIELD_NUMBER = 10;
        public static final int END_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 6;
        public static final int INTVAL_FIELD_NUMBER = 3;
        public static final int ORDER_FIELD_NUMBER = 8;
        public static final int START_FIELD_NUMBER = 4;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int UPDATETIME_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f9521a;
        /* renamed from: b */
        private String f9522b = "";
        /* renamed from: c */
        private boolean f9523c;
        /* renamed from: d */
        private String f9524d = "";
        /* renamed from: e */
        private boolean f9525e;
        /* renamed from: f */
        private int f9526f = 0;
        /* renamed from: g */
        private boolean f9527g;
        /* renamed from: h */
        private int f9528h = 0;
        /* renamed from: i */
        private boolean f9529i;
        /* renamed from: j */
        private int f9530j = 0;
        /* renamed from: k */
        private boolean f9531k;
        /* renamed from: l */
        private int f9532l = 0;
        /* renamed from: m */
        private boolean f9533m;
        /* renamed from: n */
        private int f9534n = 0;
        /* renamed from: o */
        private boolean f9535o;
        /* renamed from: p */
        private int f9536p = 0;
        /* renamed from: q */
        private boolean f9537q;
        /* renamed from: r */
        private String f9538r = "";
        /* renamed from: s */
        private boolean f9539s;
        /* renamed from: t */
        private int f9540t = 0;
        /* renamed from: u */
        private int f9541u = -1;

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public final Content clear() {
            clearType();
            clearData();
            clearIntval();
            clearStart();
            clearEnd();
            clearId();
            clearUpdatetime();
            clearOrder();
            clearCtrlMode();
            clearDayTimes();
            this.f9541u = -1;
            return this;
        }

        public Content clearCtrlMode() {
            this.f9537q = false;
            this.f9538r = "";
            return this;
        }

        public Content clearData() {
            this.f9523c = false;
            this.f9524d = "";
            return this;
        }

        public Content clearDayTimes() {
            this.f9539s = false;
            this.f9540t = 0;
            return this;
        }

        public Content clearEnd() {
            this.f9529i = false;
            this.f9530j = 0;
            return this;
        }

        public Content clearId() {
            this.f9531k = false;
            this.f9532l = 0;
            return this;
        }

        public Content clearIntval() {
            this.f9525e = false;
            this.f9526f = 0;
            return this;
        }

        public Content clearOrder() {
            this.f9535o = false;
            this.f9536p = 0;
            return this;
        }

        public Content clearStart() {
            this.f9527g = false;
            this.f9528h = 0;
            return this;
        }

        public Content clearType() {
            this.f9521a = false;
            this.f9522b = "";
            return this;
        }

        public Content clearUpdatetime() {
            this.f9533m = false;
            this.f9534n = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f9541u < 0) {
                getSerializedSize();
            }
            return this.f9541u;
        }

        public String getCtrlMode() {
            return this.f9538r;
        }

        public String getData() {
            return this.f9524d;
        }

        public int getDayTimes() {
            return this.f9540t;
        }

        public int getEnd() {
            return this.f9530j;
        }

        public int getId() {
            return this.f9532l;
        }

        public int getIntval() {
            return this.f9526f;
        }

        public int getOrder() {
            return this.f9536p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getType());
            }
            if (hasData()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getData());
            }
            if (hasIntval()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getIntval());
            }
            if (hasStart()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getStart());
            }
            if (hasEnd()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getEnd());
            }
            if (hasId()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getId());
            }
            if (hasUpdatetime()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getUpdatetime());
            }
            if (hasOrder()) {
                i += CodedOutputStreamMicro.computeInt32Size(8, getOrder());
            }
            if (hasCtrlMode()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getCtrlMode());
            }
            if (hasDayTimes()) {
                i += CodedOutputStreamMicro.computeInt32Size(10, getDayTimes());
            }
            this.f9541u = i;
            return i;
        }

        public int getStart() {
            return this.f9528h;
        }

        public String getType() {
            return this.f9522b;
        }

        public int getUpdatetime() {
            return this.f9534n;
        }

        public boolean hasCtrlMode() {
            return this.f9537q;
        }

        public boolean hasData() {
            return this.f9523c;
        }

        public boolean hasDayTimes() {
            return this.f9539s;
        }

        public boolean hasEnd() {
            return this.f9529i;
        }

        public boolean hasId() {
            return this.f9531k;
        }

        public boolean hasIntval() {
            return this.f9525e;
        }

        public boolean hasOrder() {
            return this.f9535o;
        }

        public boolean hasStart() {
            return this.f9527g;
        }

        public boolean hasType() {
            return this.f9521a;
        }

        public boolean hasUpdatetime() {
            return this.f9533m;
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
                        setType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setData(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setIntval(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setStart(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setEnd(codedInputStreamMicro.readInt32());
                        continue;
                    case 48:
                        setId(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setUpdatetime(codedInputStreamMicro.readInt32());
                        continue;
                    case 64:
                        setOrder(codedInputStreamMicro.readInt32());
                        continue;
                    case 74:
                        setCtrlMode(codedInputStreamMicro.readString());
                        continue;
                    case 80:
                        setDayTimes(codedInputStreamMicro.readInt32());
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

        public Content setCtrlMode(String str) {
            this.f9537q = true;
            this.f9538r = str;
            return this;
        }

        public Content setData(String str) {
            this.f9523c = true;
            this.f9524d = str;
            return this;
        }

        public Content setDayTimes(int i) {
            this.f9539s = true;
            this.f9540t = i;
            return this;
        }

        public Content setEnd(int i) {
            this.f9529i = true;
            this.f9530j = i;
            return this;
        }

        public Content setId(int i) {
            this.f9531k = true;
            this.f9532l = i;
            return this;
        }

        public Content setIntval(int i) {
            this.f9525e = true;
            this.f9526f = i;
            return this;
        }

        public Content setOrder(int i) {
            this.f9535o = true;
            this.f9536p = i;
            return this;
        }

        public Content setStart(int i) {
            this.f9527g = true;
            this.f9528h = i;
            return this;
        }

        public Content setType(String str) {
            this.f9521a = true;
            this.f9522b = str;
            return this;
        }

        public Content setUpdatetime(int i) {
            this.f9533m = true;
            this.f9534n = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasType()) {
                codedOutputStreamMicro.writeString(1, getType());
            }
            if (hasData()) {
                codedOutputStreamMicro.writeString(2, getData());
            }
            if (hasIntval()) {
                codedOutputStreamMicro.writeInt32(3, getIntval());
            }
            if (hasStart()) {
                codedOutputStreamMicro.writeInt32(4, getStart());
            }
            if (hasEnd()) {
                codedOutputStreamMicro.writeInt32(5, getEnd());
            }
            if (hasId()) {
                codedOutputStreamMicro.writeInt32(6, getId());
            }
            if (hasUpdatetime()) {
                codedOutputStreamMicro.writeInt32(7, getUpdatetime());
            }
            if (hasOrder()) {
                codedOutputStreamMicro.writeInt32(8, getOrder());
            }
            if (hasCtrlMode()) {
                codedOutputStreamMicro.writeString(9, getCtrlMode());
            }
            if (hasDayTimes()) {
                codedOutputStreamMicro.writeInt32(10, getDayTimes());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int CHECKCODE_FIELD_NUMBER = 2;
        public static final int LASTTIME_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f9542a;
        /* renamed from: b */
        private int f9543b = 0;
        /* renamed from: c */
        private boolean f9544c;
        /* renamed from: d */
        private String f9545d = "";
        /* renamed from: e */
        private int f9546e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearLasttime();
            clearCheckcode();
            this.f9546e = -1;
            return this;
        }

        public Option clearCheckcode() {
            this.f9544c = false;
            this.f9545d = "";
            return this;
        }

        public Option clearLasttime() {
            this.f9542a = false;
            this.f9543b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f9546e < 0) {
                getSerializedSize();
            }
            return this.f9546e;
        }

        public String getCheckcode() {
            return this.f9545d;
        }

        public int getLasttime() {
            return this.f9543b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLasttime()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getLasttime());
            }
            if (hasCheckcode()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getCheckcode());
            }
            this.f9546e = i;
            return i;
        }

        public boolean hasCheckcode() {
            return this.f9544c;
        }

        public boolean hasLasttime() {
            return this.f9542a;
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
                        setLasttime(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setCheckcode(codedInputStreamMicro.readString());
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

        public Option setCheckcode(String str) {
            this.f9544c = true;
            this.f9545d = str;
            return this;
        }

        public Option setLasttime(int i) {
            this.f9542a = true;
            this.f9543b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLasttime()) {
                codedOutputStreamMicro.writeInt32(1, getLasttime());
            }
            if (hasCheckcode()) {
                codedOutputStreamMicro.writeString(2, getCheckcode());
            }
        }
    }

    public static Ads parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Ads().mergeFrom(codedInputStreamMicro);
    }

    public static Ads parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Ads) new Ads().mergeFrom(bArr);
    }

    public Ads addContent(Content content) {
        if (content != null) {
            if (this.f9549c.isEmpty()) {
                this.f9549c = new ArrayList();
            }
            this.f9549c.add(content);
        }
        return this;
    }

    public final Ads clear() {
        clearOption();
        clearContent();
        this.f9550d = -1;
        return this;
    }

    public Ads clearContent() {
        this.f9549c = Collections.emptyList();
        return this;
    }

    public Ads clearOption() {
        this.f9547a = false;
        this.f9548b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f9550d < 0) {
            getSerializedSize();
        }
        return this.f9550d;
    }

    public Content getContent(int i) {
        return (Content) this.f9549c.get(i);
    }

    public int getContentCount() {
        return this.f9549c.size();
    }

    public List<Content> getContentList() {
        return this.f9549c;
    }

    public Option getOption() {
        return this.f9548b;
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
        this.f9550d = i2;
        return i2;
    }

    public boolean hasOption() {
        return this.f9547a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Ads mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

    public Ads setContent(int i, Content content) {
        if (content != null) {
            this.f9549c.set(i, content);
        }
        return this;
    }

    public Ads setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f9547a = true;
        this.f9548b = option;
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
