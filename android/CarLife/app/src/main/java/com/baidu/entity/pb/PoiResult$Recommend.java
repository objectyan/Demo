package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$Recommend extends MessageMicro {
    public static final int REC_CONTENTS_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private List<RecContents> f14164a = Collections.emptyList();
    /* renamed from: b */
    private boolean f14165b;
    /* renamed from: c */
    private String f14166c = "";
    /* renamed from: d */
    private int f14167d = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$Recommend$RecContents */
    public static final class RecContents extends MessageMicro {
        public static final int CLOUD_TEMPLATE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14157a;
        /* renamed from: b */
        private String f14158b = "";
        /* renamed from: c */
        private boolean f14159c;
        /* renamed from: d */
        private String f14160d = "";
        /* renamed from: e */
        private boolean f14161e;
        /* renamed from: f */
        private ByteStringMicro f14162f = ByteStringMicro.EMPTY;
        /* renamed from: g */
        private int f14163g = -1;

        public static RecContents parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RecContents().mergeFrom(codedInputStreamMicro);
        }

        public static RecContents parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RecContents) new RecContents().mergeFrom(bArr);
        }

        public final RecContents clear() {
            clearUid();
            clearName();
            clearCloudTemplate();
            this.f14163g = -1;
            return this;
        }

        public RecContents clearCloudTemplate() {
            this.f14161e = false;
            this.f14162f = ByteStringMicro.EMPTY;
            return this;
        }

        public RecContents clearName() {
            this.f14159c = false;
            this.f14160d = "";
            return this;
        }

        public RecContents clearUid() {
            this.f14157a = false;
            this.f14158b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14163g < 0) {
                getSerializedSize();
            }
            return this.f14163g;
        }

        public ByteStringMicro getCloudTemplate() {
            return this.f14162f;
        }

        public String getName() {
            return this.f14160d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasCloudTemplate()) {
                i += CodedOutputStreamMicro.computeBytesSize(3, getCloudTemplate());
            }
            this.f14163g = i;
            return i;
        }

        public String getUid() {
            return this.f14158b;
        }

        public boolean hasCloudTemplate() {
            return this.f14161e;
        }

        public boolean hasName() {
            return this.f14159c;
        }

        public boolean hasUid() {
            return this.f14157a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public RecContents mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setCloudTemplate(codedInputStreamMicro.readBytes());
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

        public RecContents setCloudTemplate(ByteStringMicro byteStringMicro) {
            this.f14161e = true;
            this.f14162f = byteStringMicro;
            return this;
        }

        public RecContents setName(String str) {
            this.f14159c = true;
            this.f14160d = str;
            return this;
        }

        public RecContents setUid(String str) {
            this.f14157a = true;
            this.f14158b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUid()) {
                codedOutputStreamMicro.writeString(1, getUid());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasCloudTemplate()) {
                codedOutputStreamMicro.writeBytes(3, getCloudTemplate());
            }
        }
    }

    public static PoiResult$Recommend parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Recommend().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Recommend parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Recommend) new PoiResult$Recommend().mergeFrom(bArr);
    }

    public PoiResult$Recommend addRecContents(RecContents recContents) {
        if (recContents != null) {
            if (this.f14164a.isEmpty()) {
                this.f14164a = new ArrayList();
            }
            this.f14164a.add(recContents);
        }
        return this;
    }

    public final PoiResult$Recommend clear() {
        clearRecContents();
        clearTitle();
        this.f14167d = -1;
        return this;
    }

    public PoiResult$Recommend clearRecContents() {
        this.f14164a = Collections.emptyList();
        return this;
    }

    public PoiResult$Recommend clearTitle() {
        this.f14165b = false;
        this.f14166c = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f14167d < 0) {
            getSerializedSize();
        }
        return this.f14167d;
    }

    public RecContents getRecContents(int i) {
        return (RecContents) this.f14164a.get(i);
    }

    public int getRecContentsCount() {
        return this.f14164a.size();
    }

    public List<RecContents> getRecContentsList() {
        return this.f14164a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (RecContents computeMessageSize : getRecContentsList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasTitle()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
        }
        this.f14167d = i;
        return i;
    }

    public String getTitle() {
        return this.f14166c;
    }

    public boolean hasTitle() {
        return this.f14165b;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Recommend mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro recContents = new RecContents();
                    codedInputStreamMicro.readMessage(recContents);
                    addRecContents(recContents);
                    continue;
                case 18:
                    setTitle(codedInputStreamMicro.readString());
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

    public PoiResult$Recommend setRecContents(int i, RecContents recContents) {
        if (recContents != null) {
            this.f14164a.set(i, recContents);
        }
        return this;
    }

    public PoiResult$Recommend setTitle(String str) {
        this.f14165b = true;
        this.f14166c = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (RecContents writeMessage : getRecContentsList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasTitle()) {
            codedOutputStreamMicro.writeString(2, getTitle());
        }
    }
}
