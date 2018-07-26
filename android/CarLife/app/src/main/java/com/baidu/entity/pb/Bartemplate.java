package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Bartemplate extends MessageMicro {
    public static final int HEAD_FIELD_NUMBER = 1;
    public static final int MIDDLE_FIELD_NUMBER = 2;
    public static final int TAIL_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f9597a;
    /* renamed from: b */
    private Head f9598b = null;
    /* renamed from: c */
    private boolean f9599c;
    /* renamed from: d */
    private Middle f9600d = null;
    /* renamed from: e */
    private boolean f9601e;
    /* renamed from: f */
    private Tail f9602f = null;
    /* renamed from: g */
    private int f9603g = -1;

    public static final class Head extends MessageMicro {
        public static final int LABEL_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f9581a;
        /* renamed from: b */
        private String f9582b = "";
        /* renamed from: c */
        private boolean f9583c;
        /* renamed from: d */
        private String f9584d = "";
        /* renamed from: e */
        private int f9585e = -1;

        public static Head parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Head().mergeFrom(codedInputStreamMicro);
        }

        public static Head parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Head) new Head().mergeFrom(bArr);
        }

        public final Head clear() {
            clearTitle();
            clearLabel();
            this.f9585e = -1;
            return this;
        }

        public Head clearLabel() {
            this.f9583c = false;
            this.f9584d = "";
            return this;
        }

        public Head clearTitle() {
            this.f9581a = false;
            this.f9582b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f9585e < 0) {
                getSerializedSize();
            }
            return this.f9585e;
        }

        public String getLabel() {
            return this.f9584d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasLabel()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLabel());
            }
            this.f9585e = i;
            return i;
        }

        public String getTitle() {
            return this.f9582b;
        }

        public boolean hasLabel() {
            return this.f9583c;
        }

        public boolean hasTitle() {
            return this.f9581a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Head mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setLabel(codedInputStreamMicro.readString());
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

        public Head setLabel(String str) {
            this.f9583c = true;
            this.f9584d = str;
            return this;
        }

        public Head setTitle(String str) {
            this.f9581a = true;
            this.f9582b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasLabel()) {
                codedOutputStreamMicro.writeString(2, getLabel());
            }
        }
    }

    public static final class Middle extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 2;
        public static final int RATE_FIELD_NUMBER = 1;
        public static final int TEXT_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f9586a;
        /* renamed from: b */
        private String f9587b = "";
        /* renamed from: c */
        private boolean f9588c;
        /* renamed from: d */
        private String f9589d = "";
        /* renamed from: e */
        private boolean f9590e;
        /* renamed from: f */
        private String f9591f = "";
        /* renamed from: g */
        private int f9592g = -1;

        public static Middle parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Middle().mergeFrom(codedInputStreamMicro);
        }

        public static Middle parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Middle) new Middle().mergeFrom(bArr);
        }

        public final Middle clear() {
            clearRate();
            clearDesc();
            clearText();
            this.f9592g = -1;
            return this;
        }

        public Middle clearDesc() {
            this.f9588c = false;
            this.f9589d = "";
            return this;
        }

        public Middle clearRate() {
            this.f9586a = false;
            this.f9587b = "";
            return this;
        }

        public Middle clearText() {
            this.f9590e = false;
            this.f9591f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f9592g < 0) {
                getSerializedSize();
            }
            return this.f9592g;
        }

        public String getDesc() {
            return this.f9589d;
        }

        public String getRate() {
            return this.f9587b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasRate()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getRate());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getDesc());
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getText());
            }
            this.f9592g = i;
            return i;
        }

        public String getText() {
            return this.f9591f;
        }

        public boolean hasDesc() {
            return this.f9588c;
        }

        public boolean hasRate() {
            return this.f9586a;
        }

        public boolean hasText() {
            return this.f9590e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Middle mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setRate(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setDesc(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setText(codedInputStreamMicro.readString());
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

        public Middle setDesc(String str) {
            this.f9588c = true;
            this.f9589d = str;
            return this;
        }

        public Middle setRate(String str) {
            this.f9586a = true;
            this.f9587b = str;
            return this;
        }

        public Middle setText(String str) {
            this.f9590e = true;
            this.f9591f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasRate()) {
                codedOutputStreamMicro.writeString(1, getRate());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(2, getDesc());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeString(3, getText());
            }
        }
    }

    public static final class Tail extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 2;
        public static final int ICON_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<Integer> f9593a = Collections.emptyList();
        /* renamed from: b */
        private boolean f9594b;
        /* renamed from: c */
        private String f9595c = "";
        /* renamed from: d */
        private int f9596d = -1;

        public static Tail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Tail().mergeFrom(codedInputStreamMicro);
        }

        public static Tail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Tail) new Tail().mergeFrom(bArr);
        }

        public Tail addIconId(int i) {
            if (this.f9593a.isEmpty()) {
                this.f9593a = new ArrayList();
            }
            this.f9593a.add(Integer.valueOf(i));
            return this;
        }

        public final Tail clear() {
            clearIconId();
            clearDesc();
            this.f9596d = -1;
            return this;
        }

        public Tail clearDesc() {
            this.f9594b = false;
            this.f9595c = "";
            return this;
        }

        public Tail clearIconId() {
            this.f9593a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f9596d < 0) {
                getSerializedSize();
            }
            return this.f9596d;
        }

        public String getDesc() {
            return this.f9595c;
        }

        public int getIconId(int i) {
            return ((Integer) this.f9593a.get(i)).intValue();
        }

        public int getIconIdCount() {
            return this.f9593a.size();
        }

        public List<Integer> getIconIdList() {
            return this.f9593a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Integer intValue : getIconIdList()) {
                i = CodedOutputStreamMicro.computeInt32SizeNoTag(intValue.intValue()) + i;
            }
            int size = (0 + i) + (getIconIdList().size() * 1);
            if (hasDesc()) {
                size += CodedOutputStreamMicro.computeStringSize(2, getDesc());
            }
            this.f9596d = size;
            return size;
        }

        public boolean hasDesc() {
            return this.f9594b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Tail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        addIconId(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setDesc(codedInputStreamMicro.readString());
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

        public Tail setDesc(String str) {
            this.f9594b = true;
            this.f9595c = str;
            return this;
        }

        public Tail setIconId(int i, int i2) {
            this.f9593a.set(i, Integer.valueOf(i2));
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Integer intValue : getIconIdList()) {
                codedOutputStreamMicro.writeInt32(1, intValue.intValue());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(2, getDesc());
            }
        }
    }

    public static Bartemplate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Bartemplate().mergeFrom(codedInputStreamMicro);
    }

    public static Bartemplate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Bartemplate) new Bartemplate().mergeFrom(bArr);
    }

    public final Bartemplate clear() {
        clearHead();
        clearMiddle();
        clearTail();
        this.f9603g = -1;
        return this;
    }

    public Bartemplate clearHead() {
        this.f9597a = false;
        this.f9598b = null;
        return this;
    }

    public Bartemplate clearMiddle() {
        this.f9599c = false;
        this.f9600d = null;
        return this;
    }

    public Bartemplate clearTail() {
        this.f9601e = false;
        this.f9602f = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f9603g < 0) {
            getSerializedSize();
        }
        return this.f9603g;
    }

    public Head getHead() {
        return this.f9598b;
    }

    public Middle getMiddle() {
        return this.f9600d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasHead()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHead());
        }
        if (hasMiddle()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getMiddle());
        }
        if (hasTail()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getTail());
        }
        this.f9603g = i;
        return i;
    }

    public Tail getTail() {
        return this.f9602f;
    }

    public boolean hasHead() {
        return this.f9597a;
    }

    public boolean hasMiddle() {
        return this.f9599c;
    }

    public boolean hasTail() {
        return this.f9601e;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Bartemplate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro head;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    head = new Head();
                    codedInputStreamMicro.readMessage(head);
                    setHead(head);
                    continue;
                case 18:
                    head = new Middle();
                    codedInputStreamMicro.readMessage(head);
                    setMiddle(head);
                    continue;
                case 26:
                    head = new Tail();
                    codedInputStreamMicro.readMessage(head);
                    setTail(head);
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

    public Bartemplate setHead(Head head) {
        if (head == null) {
            return clearHead();
        }
        this.f9597a = true;
        this.f9598b = head;
        return this;
    }

    public Bartemplate setMiddle(Middle middle) {
        if (middle == null) {
            return clearMiddle();
        }
        this.f9599c = true;
        this.f9600d = middle;
        return this;
    }

    public Bartemplate setTail(Tail tail) {
        if (tail == null) {
            return clearTail();
        }
        this.f9601e = true;
        this.f9602f = tail;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasHead()) {
            codedOutputStreamMicro.writeMessage(1, getHead());
        }
        if (hasMiddle()) {
            codedOutputStreamMicro.writeMessage(2, getMiddle());
        }
        if (hasTail()) {
            codedOutputStreamMicro.writeMessage(3, getTail());
        }
    }
}
