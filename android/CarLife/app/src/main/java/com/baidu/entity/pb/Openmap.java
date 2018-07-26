package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Openmap extends MessageMicro {
    public static final int INFO_FIELD_NUMBER = 1;
    public static final int TOTAL_FIELD_NUMBER = 2;
    /* renamed from: a */
    private List<Info> f12266a = Collections.emptyList();
    /* renamed from: b */
    private boolean f12267b;
    /* renamed from: c */
    private int f12268c = 0;
    /* renamed from: d */
    private int f12269d = -1;

    public static final class Info extends MessageMicro {
        public static final int BRAND_FIELD_NUMBER = 3;
        public static final int CATEGORY_ID_FIELD_NUMBER = 6;
        public static final int DEFAULT_GEOTABLE_ID_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int INFOWINDOW_STYLE_FIELD_NUMBER = 7;
        public static final int LOGO_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int SRC_FIELD_NUMBER = 8;
        /* renamed from: a */
        private boolean f12249a;
        /* renamed from: b */
        private String f12250b = "";
        /* renamed from: c */
        private boolean f12251c;
        /* renamed from: d */
        private String f12252d = "";
        /* renamed from: e */
        private boolean f12253e;
        /* renamed from: f */
        private String f12254f = "";
        /* renamed from: g */
        private boolean f12255g;
        /* renamed from: h */
        private String f12256h = "";
        /* renamed from: i */
        private boolean f12257i;
        /* renamed from: j */
        private String f12258j = "";
        /* renamed from: k */
        private boolean f12259k;
        /* renamed from: l */
        private String f12260l = "";
        /* renamed from: m */
        private boolean f12261m;
        /* renamed from: n */
        private String f12262n = "";
        /* renamed from: o */
        private boolean f12263o;
        /* renamed from: p */
        private String f12264p = "";
        /* renamed from: q */
        private int f12265q = -1;

        public static Info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Info().mergeFrom(codedInputStreamMicro);
        }

        public static Info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Info) new Info().mergeFrom(bArr);
        }

        public final Info clear() {
            clearId();
            clearName();
            clearBrand();
            clearLogo();
            clearDefaultGeotableId();
            clearCategoryId();
            clearInfowindowStyle();
            clearSrc();
            this.f12265q = -1;
            return this;
        }

        public Info clearBrand() {
            this.f12253e = false;
            this.f12254f = "";
            return this;
        }

        public Info clearCategoryId() {
            this.f12259k = false;
            this.f12260l = "";
            return this;
        }

        public Info clearDefaultGeotableId() {
            this.f12257i = false;
            this.f12258j = "";
            return this;
        }

        public Info clearId() {
            this.f12249a = false;
            this.f12250b = "";
            return this;
        }

        public Info clearInfowindowStyle() {
            this.f12261m = false;
            this.f12262n = "";
            return this;
        }

        public Info clearLogo() {
            this.f12255g = false;
            this.f12256h = "";
            return this;
        }

        public Info clearName() {
            this.f12251c = false;
            this.f12252d = "";
            return this;
        }

        public Info clearSrc() {
            this.f12263o = false;
            this.f12264p = "";
            return this;
        }

        public String getBrand() {
            return this.f12254f;
        }

        public int getCachedSize() {
            if (this.f12265q < 0) {
                getSerializedSize();
            }
            return this.f12265q;
        }

        public String getCategoryId() {
            return this.f12260l;
        }

        public String getDefaultGeotableId() {
            return this.f12258j;
        }

        public String getId() {
            return this.f12250b;
        }

        public String getInfowindowStyle() {
            return this.f12262n;
        }

        public String getLogo() {
            return this.f12256h;
        }

        public String getName() {
            return this.f12252d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasBrand()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getBrand());
            }
            if (hasLogo()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getLogo());
            }
            if (hasDefaultGeotableId()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getDefaultGeotableId());
            }
            if (hasCategoryId()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getCategoryId());
            }
            if (hasInfowindowStyle()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getInfowindowStyle());
            }
            if (hasSrc()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getSrc());
            }
            this.f12265q = i;
            return i;
        }

        public String getSrc() {
            return this.f12264p;
        }

        public boolean hasBrand() {
            return this.f12253e;
        }

        public boolean hasCategoryId() {
            return this.f12259k;
        }

        public boolean hasDefaultGeotableId() {
            return this.f12257i;
        }

        public boolean hasId() {
            return this.f12249a;
        }

        public boolean hasInfowindowStyle() {
            return this.f12261m;
        }

        public boolean hasLogo() {
            return this.f12255g;
        }

        public boolean hasName() {
            return this.f12251c;
        }

        public boolean hasSrc() {
            return this.f12263o;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Info mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setBrand(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setLogo(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setDefaultGeotableId(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setCategoryId(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setInfowindowStyle(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setSrc(codedInputStreamMicro.readString());
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

        public Info setBrand(String str) {
            this.f12253e = true;
            this.f12254f = str;
            return this;
        }

        public Info setCategoryId(String str) {
            this.f12259k = true;
            this.f12260l = str;
            return this;
        }

        public Info setDefaultGeotableId(String str) {
            this.f12257i = true;
            this.f12258j = str;
            return this;
        }

        public Info setId(String str) {
            this.f12249a = true;
            this.f12250b = str;
            return this;
        }

        public Info setInfowindowStyle(String str) {
            this.f12261m = true;
            this.f12262n = str;
            return this;
        }

        public Info setLogo(String str) {
            this.f12255g = true;
            this.f12256h = str;
            return this;
        }

        public Info setName(String str) {
            this.f12251c = true;
            this.f12252d = str;
            return this;
        }

        public Info setSrc(String str) {
            this.f12263o = true;
            this.f12264p = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasId()) {
                codedOutputStreamMicro.writeString(1, getId());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasBrand()) {
                codedOutputStreamMicro.writeString(3, getBrand());
            }
            if (hasLogo()) {
                codedOutputStreamMicro.writeString(4, getLogo());
            }
            if (hasDefaultGeotableId()) {
                codedOutputStreamMicro.writeString(5, getDefaultGeotableId());
            }
            if (hasCategoryId()) {
                codedOutputStreamMicro.writeString(6, getCategoryId());
            }
            if (hasInfowindowStyle()) {
                codedOutputStreamMicro.writeString(7, getInfowindowStyle());
            }
            if (hasSrc()) {
                codedOutputStreamMicro.writeString(8, getSrc());
            }
        }
    }

    public static Openmap parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Openmap().mergeFrom(codedInputStreamMicro);
    }

    public static Openmap parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Openmap) new Openmap().mergeFrom(bArr);
    }

    public Openmap addInfo(Info info) {
        if (info != null) {
            if (this.f12266a.isEmpty()) {
                this.f12266a = new ArrayList();
            }
            this.f12266a.add(info);
        }
        return this;
    }

    public final Openmap clear() {
        clearInfo();
        clearTotal();
        this.f12269d = -1;
        return this;
    }

    public Openmap clearInfo() {
        this.f12266a = Collections.emptyList();
        return this;
    }

    public Openmap clearTotal() {
        this.f12267b = false;
        this.f12268c = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f12269d < 0) {
            getSerializedSize();
        }
        return this.f12269d;
    }

    public Info getInfo(int i) {
        return (Info) this.f12266a.get(i);
    }

    public int getInfoCount() {
        return this.f12266a.size();
    }

    public List<Info> getInfoList() {
        return this.f12266a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Info computeMessageSize : getInfoList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasTotal()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getTotal());
        }
        this.f12269d = i;
        return i;
    }

    public int getTotal() {
        return this.f12268c;
    }

    public boolean hasTotal() {
        return this.f12267b;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Openmap mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro info = new Info();
                    codedInputStreamMicro.readMessage(info);
                    addInfo(info);
                    continue;
                case 16:
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

    public Openmap setInfo(int i, Info info) {
        if (info != null) {
            this.f12266a.set(i, info);
        }
        return this;
    }

    public Openmap setTotal(int i) {
        this.f12267b = true;
        this.f12268c = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Info writeMessage : getInfoList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasTotal()) {
            codedOutputStreamMicro.writeInt32(2, getTotal());
        }
    }
}
