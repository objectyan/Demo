package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$CorrectionInfo extends MessageMicro {
    public static final int ASSIST_INFO_FIELD_NUMBER = 2;
    public static final int CORRECTION_QUERYS_FIELD_NUMBER = 4;
    public static final int CORRECTION_TYPE_FIELD_NUMBER = 3;
    public static final int TITLE_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14012a;
    /* renamed from: b */
    private String f14013b = "";
    /* renamed from: c */
    private boolean f14014c;
    /* renamed from: d */
    private String f14015d = "";
    /* renamed from: e */
    private boolean f14016e;
    /* renamed from: f */
    private int f14017f = 0;
    /* renamed from: g */
    private List<CorrectionQuerys> f14018g = Collections.emptyList();
    /* renamed from: h */
    private int f14019h = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$CorrectionInfo$CorrectionQuerys */
    public static final class CorrectionQuerys extends MessageMicro {
        public static final int QUERY_ASSIST_INFO_FIELD_NUMBER = 2;
        public static final int QUERY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14007a;
        /* renamed from: b */
        private String f14008b = "";
        /* renamed from: c */
        private boolean f14009c;
        /* renamed from: d */
        private String f14010d = "";
        /* renamed from: e */
        private int f14011e = -1;

        public static CorrectionQuerys parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CorrectionQuerys().mergeFrom(codedInputStreamMicro);
        }

        public static CorrectionQuerys parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CorrectionQuerys) new CorrectionQuerys().mergeFrom(bArr);
        }

        public final CorrectionQuerys clear() {
            clearQuery();
            clearQueryAssistInfo();
            this.f14011e = -1;
            return this;
        }

        public CorrectionQuerys clearQuery() {
            this.f14007a = false;
            this.f14008b = "";
            return this;
        }

        public CorrectionQuerys clearQueryAssistInfo() {
            this.f14009c = false;
            this.f14010d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14011e < 0) {
                getSerializedSize();
            }
            return this.f14011e;
        }

        public String getQuery() {
            return this.f14008b;
        }

        public String getQueryAssistInfo() {
            return this.f14010d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasQuery()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getQuery());
            }
            if (hasQueryAssistInfo()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getQueryAssistInfo());
            }
            this.f14011e = i;
            return i;
        }

        public boolean hasQuery() {
            return this.f14007a;
        }

        public boolean hasQueryAssistInfo() {
            return this.f14009c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CorrectionQuerys mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setQuery(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setQueryAssistInfo(codedInputStreamMicro.readString());
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

        public CorrectionQuerys setQuery(String str) {
            this.f14007a = true;
            this.f14008b = str;
            return this;
        }

        public CorrectionQuerys setQueryAssistInfo(String str) {
            this.f14009c = true;
            this.f14010d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasQuery()) {
                codedOutputStreamMicro.writeString(1, getQuery());
            }
            if (hasQueryAssistInfo()) {
                codedOutputStreamMicro.writeString(2, getQueryAssistInfo());
            }
        }
    }

    public static PoiResult$CorrectionInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$CorrectionInfo().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$CorrectionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$CorrectionInfo) new PoiResult$CorrectionInfo().mergeFrom(bArr);
    }

    public PoiResult$CorrectionInfo addCorrectionQuerys(CorrectionQuerys correctionQuerys) {
        if (correctionQuerys != null) {
            if (this.f14018g.isEmpty()) {
                this.f14018g = new ArrayList();
            }
            this.f14018g.add(correctionQuerys);
        }
        return this;
    }

    public final PoiResult$CorrectionInfo clear() {
        clearTitle();
        clearAssistInfo();
        clearCorrectionType();
        clearCorrectionQuerys();
        this.f14019h = -1;
        return this;
    }

    public PoiResult$CorrectionInfo clearAssistInfo() {
        this.f14014c = false;
        this.f14015d = "";
        return this;
    }

    public PoiResult$CorrectionInfo clearCorrectionQuerys() {
        this.f14018g = Collections.emptyList();
        return this;
    }

    public PoiResult$CorrectionInfo clearCorrectionType() {
        this.f14016e = false;
        this.f14017f = 0;
        return this;
    }

    public PoiResult$CorrectionInfo clearTitle() {
        this.f14012a = false;
        this.f14013b = "";
        return this;
    }

    public String getAssistInfo() {
        return this.f14015d;
    }

    public int getCachedSize() {
        if (this.f14019h < 0) {
            getSerializedSize();
        }
        return this.f14019h;
    }

    public CorrectionQuerys getCorrectionQuerys(int i) {
        return (CorrectionQuerys) this.f14018g.get(i);
    }

    public int getCorrectionQuerysCount() {
        return this.f14018g.size();
    }

    public List<CorrectionQuerys> getCorrectionQuerysList() {
        return this.f14018g;
    }

    public int getCorrectionType() {
        return this.f14017f;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasTitle()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
        }
        if (hasAssistInfo()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getAssistInfo());
        }
        if (hasCorrectionType()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getCorrectionType());
        }
        int i2 = i;
        for (CorrectionQuerys computeMessageSize : getCorrectionQuerysList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
        }
        this.f14019h = i2;
        return i2;
    }

    public String getTitle() {
        return this.f14013b;
    }

    public boolean hasAssistInfo() {
        return this.f14014c;
    }

    public boolean hasCorrectionType() {
        return this.f14016e;
    }

    public boolean hasTitle() {
        return this.f14012a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$CorrectionInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setTitle(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setAssistInfo(codedInputStreamMicro.readString());
                    continue;
                case 24:
                    setCorrectionType(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    MessageMicro correctionQuerys = new CorrectionQuerys();
                    codedInputStreamMicro.readMessage(correctionQuerys);
                    addCorrectionQuerys(correctionQuerys);
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

    public PoiResult$CorrectionInfo setAssistInfo(String str) {
        this.f14014c = true;
        this.f14015d = str;
        return this;
    }

    public PoiResult$CorrectionInfo setCorrectionQuerys(int i, CorrectionQuerys correctionQuerys) {
        if (correctionQuerys != null) {
            this.f14018g.set(i, correctionQuerys);
        }
        return this;
    }

    public PoiResult$CorrectionInfo setCorrectionType(int i) {
        this.f14016e = true;
        this.f14017f = i;
        return this;
    }

    public PoiResult$CorrectionInfo setTitle(String str) {
        this.f14012a = true;
        this.f14013b = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasTitle()) {
            codedOutputStreamMicro.writeString(1, getTitle());
        }
        if (hasAssistInfo()) {
            codedOutputStreamMicro.writeString(2, getAssistInfo());
        }
        if (hasCorrectionType()) {
            codedOutputStreamMicro.writeInt32(3, getCorrectionType());
        }
        for (CorrectionQuerys writeMessage : getCorrectionQuerysList()) {
            codedOutputStreamMicro.writeMessage(4, writeMessage);
        }
    }
}
