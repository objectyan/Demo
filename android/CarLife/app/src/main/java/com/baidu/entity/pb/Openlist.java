package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Openlist extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int STYLE_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f12244a;
    /* renamed from: b */
    private Style f12245b = null;
    /* renamed from: c */
    private boolean f12246c;
    /* renamed from: d */
    private Data f12247d = null;
    /* renamed from: e */
    private int f12248e = -1;

    public static final class Data extends MessageMicro {
        public static final int CONTENTS_FIELD_NUMBER = 4;
        public static final int SIZE_FIELD_NUMBER = 3;
        public static final int STATUS_FIELD_NUMBER = 1;
        public static final int TOTAL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12223a;
        /* renamed from: b */
        private int f12224b = 0;
        /* renamed from: c */
        private boolean f12225c;
        /* renamed from: d */
        private int f12226d = 0;
        /* renamed from: e */
        private boolean f12227e;
        /* renamed from: f */
        private int f12228f = 0;
        /* renamed from: g */
        private List<String> f12229g = Collections.emptyList();
        /* renamed from: h */
        private int f12230h = -1;

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addContents(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f12229g.isEmpty()) {
                this.f12229g = new ArrayList();
            }
            this.f12229g.add(str);
            return this;
        }

        public final Data clear() {
            clearStatus();
            clearTotal();
            clearSize();
            clearContents();
            this.f12230h = -1;
            return this;
        }

        public Data clearContents() {
            this.f12229g = Collections.emptyList();
            return this;
        }

        public Data clearSize() {
            this.f12227e = false;
            this.f12228f = 0;
            return this;
        }

        public Data clearStatus() {
            this.f12223a = false;
            this.f12224b = 0;
            return this;
        }

        public Data clearTotal() {
            this.f12225c = false;
            this.f12226d = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f12230h < 0) {
                getSerializedSize();
            }
            return this.f12230h;
        }

        public String getContents(int i) {
            return (String) this.f12229g.get(i);
        }

        public int getContentsCount() {
            return this.f12229g.size();
        }

        public List<String> getContentsList() {
            return this.f12229g;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeInt32Size = hasStatus() ? CodedOutputStreamMicro.computeInt32Size(1, getStatus()) + 0 : 0;
            if (hasTotal()) {
                computeInt32Size += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
            }
            int computeInt32Size2 = hasSize() ? computeInt32Size + CodedOutputStreamMicro.computeInt32Size(3, getSize()) : computeInt32Size;
            for (String computeStringSizeNoTag : getContentsList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeInt32Size = (computeInt32Size2 + i) + (getContentsList().size() * 1);
            this.f12230h = computeInt32Size;
            return computeInt32Size;
        }

        public int getSize() {
            return this.f12228f;
        }

        public int getStatus() {
            return this.f12224b;
        }

        public int getTotal() {
            return this.f12226d;
        }

        public boolean hasSize() {
            return this.f12227e;
        }

        public boolean hasStatus() {
            return this.f12223a;
        }

        public boolean hasTotal() {
            return this.f12225c;
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
                    case 8:
                        setStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setTotal(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setSize(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        addContents(codedInputStreamMicro.readString());
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

        public Data setContents(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f12229g.set(i, str);
            return this;
        }

        public Data setSize(int i) {
            this.f12227e = true;
            this.f12228f = i;
            return this;
        }

        public Data setStatus(int i) {
            this.f12223a = true;
            this.f12224b = i;
            return this;
        }

        public Data setTotal(int i) {
            this.f12225c = true;
            this.f12226d = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(1, getStatus());
            }
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(2, getTotal());
            }
            if (hasSize()) {
                codedOutputStreamMicro.writeInt32(3, getSize());
            }
            for (String writeString : getContentsList()) {
                codedOutputStreamMicro.writeString(4, writeString);
            }
        }
    }

    public static final class Style extends MessageMicro {
        public static final int CATEGORY_FIELD_NUMBER = 3;
        public static final int DEFAULT_GEOTABLE_ID_FIELD_NUMBER = 6;
        public static final int ID_FIELD_NUMBER = 5;
        public static final int INFOWINDOW_STYLE_FIELD_NUMBER = 4;
        public static final int LOGO_FIELD_NUMBER = 1;
        public static final int URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12231a;
        /* renamed from: b */
        private String f12232b = "";
        /* renamed from: c */
        private boolean f12233c;
        /* renamed from: d */
        private String f12234d = "";
        /* renamed from: e */
        private boolean f12235e;
        /* renamed from: f */
        private String f12236f = "";
        /* renamed from: g */
        private boolean f12237g;
        /* renamed from: h */
        private String f12238h = "";
        /* renamed from: i */
        private boolean f12239i;
        /* renamed from: j */
        private String f12240j = "";
        /* renamed from: k */
        private boolean f12241k;
        /* renamed from: l */
        private String f12242l = "";
        /* renamed from: m */
        private int f12243m = -1;

        public static Style parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Style().mergeFrom(codedInputStreamMicro);
        }

        public static Style parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Style) new Style().mergeFrom(bArr);
        }

        public final Style clear() {
            clearLogo();
            clearUrl();
            clearCategory();
            clearInfowindowStyle();
            clearId();
            clearDefaultGeotableId();
            this.f12243m = -1;
            return this;
        }

        public Style clearCategory() {
            this.f12235e = false;
            this.f12236f = "";
            return this;
        }

        public Style clearDefaultGeotableId() {
            this.f12241k = false;
            this.f12242l = "";
            return this;
        }

        public Style clearId() {
            this.f12239i = false;
            this.f12240j = "";
            return this;
        }

        public Style clearInfowindowStyle() {
            this.f12237g = false;
            this.f12238h = "";
            return this;
        }

        public Style clearLogo() {
            this.f12231a = false;
            this.f12232b = "";
            return this;
        }

        public Style clearUrl() {
            this.f12233c = false;
            this.f12234d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12243m < 0) {
                getSerializedSize();
            }
            return this.f12243m;
        }

        public String getCategory() {
            return this.f12236f;
        }

        public String getDefaultGeotableId() {
            return this.f12242l;
        }

        public String getId() {
            return this.f12240j;
        }

        public String getInfowindowStyle() {
            return this.f12238h;
        }

        public String getLogo() {
            return this.f12232b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLogo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLogo());
            }
            if (hasUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getUrl());
            }
            if (hasCategory()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getCategory());
            }
            if (hasInfowindowStyle()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getInfowindowStyle());
            }
            if (hasId()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getId());
            }
            if (hasDefaultGeotableId()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDefaultGeotableId());
            }
            this.f12243m = i;
            return i;
        }

        public String getUrl() {
            return this.f12234d;
        }

        public boolean hasCategory() {
            return this.f12235e;
        }

        public boolean hasDefaultGeotableId() {
            return this.f12241k;
        }

        public boolean hasId() {
            return this.f12239i;
        }

        public boolean hasInfowindowStyle() {
            return this.f12237g;
        }

        public boolean hasLogo() {
            return this.f12231a;
        }

        public boolean hasUrl() {
            return this.f12233c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Style mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLogo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setCategory(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setInfowindowStyle(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setId(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setDefaultGeotableId(codedInputStreamMicro.readString());
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

        public Style setCategory(String str) {
            this.f12235e = true;
            this.f12236f = str;
            return this;
        }

        public Style setDefaultGeotableId(String str) {
            this.f12241k = true;
            this.f12242l = str;
            return this;
        }

        public Style setId(String str) {
            this.f12239i = true;
            this.f12240j = str;
            return this;
        }

        public Style setInfowindowStyle(String str) {
            this.f12237g = true;
            this.f12238h = str;
            return this;
        }

        public Style setLogo(String str) {
            this.f12231a = true;
            this.f12232b = str;
            return this;
        }

        public Style setUrl(String str) {
            this.f12233c = true;
            this.f12234d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLogo()) {
                codedOutputStreamMicro.writeString(1, getLogo());
            }
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(2, getUrl());
            }
            if (hasCategory()) {
                codedOutputStreamMicro.writeString(3, getCategory());
            }
            if (hasInfowindowStyle()) {
                codedOutputStreamMicro.writeString(4, getInfowindowStyle());
            }
            if (hasId()) {
                codedOutputStreamMicro.writeString(5, getId());
            }
            if (hasDefaultGeotableId()) {
                codedOutputStreamMicro.writeString(6, getDefaultGeotableId());
            }
        }
    }

    public static Openlist parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Openlist().mergeFrom(codedInputStreamMicro);
    }

    public static Openlist parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Openlist) new Openlist().mergeFrom(bArr);
    }

    public final Openlist clear() {
        clearStyle();
        clearData();
        this.f12248e = -1;
        return this;
    }

    public Openlist clearData() {
        this.f12246c = false;
        this.f12247d = null;
        return this;
    }

    public Openlist clearStyle() {
        this.f12244a = false;
        this.f12245b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f12248e < 0) {
            getSerializedSize();
        }
        return this.f12248e;
    }

    public Data getData() {
        return this.f12247d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasStyle()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getStyle());
        }
        if (hasData()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getData());
        }
        this.f12248e = i;
        return i;
    }

    public Style getStyle() {
        return this.f12245b;
    }

    public boolean hasData() {
        return this.f12246c;
    }

    public boolean hasStyle() {
        return this.f12244a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Openlist mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro style;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    style = new Style();
                    codedInputStreamMicro.readMessage(style);
                    setStyle(style);
                    continue;
                case 18:
                    style = new Data();
                    codedInputStreamMicro.readMessage(style);
                    setData(style);
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

    public Openlist setData(Data data) {
        if (data == null) {
            return clearData();
        }
        this.f12246c = true;
        this.f12247d = data;
        return this;
    }

    public Openlist setStyle(Style style) {
        if (style == null) {
            return clearStyle();
        }
        this.f12244a = true;
        this.f12245b = style;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasStyle()) {
            codedOutputStreamMicro.writeMessage(1, getStyle());
        }
        if (hasData()) {
            codedOutputStreamMicro.writeMessage(2, getData());
        }
    }
}
