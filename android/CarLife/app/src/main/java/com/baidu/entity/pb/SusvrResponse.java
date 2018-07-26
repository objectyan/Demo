package com.baidu.entity.pb;

import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SusvrResponse extends MessageMicro {
    public static final int DISPLAY_STYLES_FIELD_NUMBER = 4;
    public static final int OFFLINE_FIELD_NUMBER = 3;
    public static final int POI_ARRAY_FIELD_NUMBER = 1;
    public static final int SE_ID_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private List<PoiElement> f14829a = Collections.emptyList();
    /* renamed from: b */
    private boolean f14830b;
    /* renamed from: c */
    private int f14831c = 0;
    /* renamed from: d */
    private boolean f14832d;
    /* renamed from: e */
    private int f14833e = 0;
    /* renamed from: f */
    private List<String> f14834f = Collections.emptyList();
    /* renamed from: g */
    private boolean f14835g;
    /* renamed from: h */
    private long f14836h = 0;
    /* renamed from: i */
    private int f14837i = -1;

    public static final class PoiElement extends MessageMicro {
        public static final int CATALOG_ID_FIELD_NUMBER = 19;
        public static final int CITYID_FIELD_NUMBER = 3;
        public static final int DISPLAY_QUERY_FIELD_NUMBER = 11;
        public static final int DISTANCE_FIELD_NUMBER = 4;
        public static final int JUMP_FIELD_NUMBER = 12;
        public static final int LINE1_COLUMN1_FIELD_NUMBER = 13;
        public static final int LINE1_COLUMN2_FIELD_NUMBER = 14;
        public static final int LINE1_COLUMN3_FIELD_NUMBER = 15;
        public static final int LINE2_COLUMN1_FIELD_NUMBER = 16;
        public static final int LINE2_COLUMN2_FIELD_NUMBER = 17;
        public static final int LINE2_COLUMN3_FIELD_NUMBER = 18;
        public static final int POI_NAME_FIELD_NUMBER = 1;
        public static final int POI_X_FIELD_NUMBER = 7;
        public static final int POI_Y_FIELD_NUMBER = 8;
        public static final int SUB_POI_ARRAY_FIELD_NUMBER = 6;
        public static final int SUB_POI_TYPE_FIELD_NUMBER = 5;
        public static final int SUB_TITLE_FIELD_NUMBER = 2;
        public static final int TAG_INFO_FIELD_NUMBER = 9;
        public static final int UID_FIELD_NUMBER = 10;
        /* renamed from: A */
        private String f14791A = "";
        /* renamed from: B */
        private boolean f14792B;
        /* renamed from: C */
        private String f14793C = "";
        /* renamed from: D */
        private boolean f14794D;
        /* renamed from: E */
        private String f14795E = "";
        /* renamed from: F */
        private boolean f14796F;
        /* renamed from: G */
        private String f14797G = "";
        /* renamed from: H */
        private boolean f14798H;
        /* renamed from: I */
        private String f14799I = "";
        /* renamed from: J */
        private boolean f14800J;
        /* renamed from: K */
        private int f14801K = 0;
        /* renamed from: L */
        private int f14802L = -1;
        /* renamed from: a */
        private boolean f14803a;
        /* renamed from: b */
        private String f14804b = "";
        /* renamed from: c */
        private boolean f14805c;
        /* renamed from: d */
        private String f14806d = "";
        /* renamed from: e */
        private boolean f14807e;
        /* renamed from: f */
        private int f14808f = 0;
        /* renamed from: g */
        private boolean f14809g;
        /* renamed from: h */
        private String f14810h = "";
        /* renamed from: i */
        private boolean f14811i;
        /* renamed from: j */
        private int f14812j = 0;
        /* renamed from: k */
        private List<SubPoi> f14813k = Collections.emptyList();
        /* renamed from: l */
        private boolean f14814l;
        /* renamed from: m */
        private double f14815m = 0.0d;
        /* renamed from: n */
        private boolean f14816n;
        /* renamed from: o */
        private double f14817o = 0.0d;
        /* renamed from: p */
        private boolean f14818p;
        /* renamed from: q */
        private TagInfo f14819q = null;
        /* renamed from: r */
        private boolean f14820r;
        /* renamed from: s */
        private String f14821s = "";
        /* renamed from: t */
        private boolean f14822t;
        /* renamed from: u */
        private String f14823u = "";
        /* renamed from: v */
        private boolean f14824v;
        /* renamed from: w */
        private Jump f14825w = null;
        /* renamed from: x */
        private boolean f14826x;
        /* renamed from: y */
        private String f14827y = "";
        /* renamed from: z */
        private boolean f14828z;

        public static final class Jump extends MessageMicro {
            public static final int JUMP_TYPE_FIELD_NUMBER = 1;
            public static final int URL_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f14762a;
            /* renamed from: b */
            private String f14763b = "";
            /* renamed from: c */
            private boolean f14764c;
            /* renamed from: d */
            private String f14765d = "";
            /* renamed from: e */
            private int f14766e = -1;

            public static Jump parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Jump().mergeFrom(codedInputStreamMicro);
            }

            public static Jump parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Jump) new Jump().mergeFrom(bArr);
            }

            public final Jump clear() {
                clearJumpType();
                clearUrl();
                this.f14766e = -1;
                return this;
            }

            public Jump clearJumpType() {
                this.f14762a = false;
                this.f14763b = "";
                return this;
            }

            public Jump clearUrl() {
                this.f14764c = false;
                this.f14765d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14766e < 0) {
                    getSerializedSize();
                }
                return this.f14766e;
            }

            public String getJumpType() {
                return this.f14763b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasJumpType()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getJumpType());
                }
                if (hasUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getUrl());
                }
                this.f14766e = i;
                return i;
            }

            public String getUrl() {
                return this.f14765d;
            }

            public boolean hasJumpType() {
                return this.f14762a;
            }

            public boolean hasUrl() {
                return this.f14764c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Jump mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setJumpType(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setUrl(codedInputStreamMicro.readString());
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

            public Jump setJumpType(String str) {
                this.f14762a = true;
                this.f14763b = str;
                return this;
            }

            public Jump setUrl(String str) {
                this.f14764c = true;
                this.f14765d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasJumpType()) {
                    codedOutputStreamMicro.writeString(1, getJumpType());
                }
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(2, getUrl());
                }
            }
        }

        public static final class SubPoi extends MessageMicro {
            public static final int GRID_FIELD_NUMBER = 3;
            public static final int JUMP_FIELD_NUMBER = 5;
            public static final int KNOWLEDGE_INFO_FIELD_NUMBER = 7;
            public static final int POI_NAME_FIELD_NUMBER = 1;
            public static final int SEARCH_QUERY_FIELD_NUMBER = 4;
            public static final int TAG_INFO_FIELD_NUMBER = 6;
            public static final int UID_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f14767a;
            /* renamed from: b */
            private String f14768b = "";
            /* renamed from: c */
            private boolean f14769c;
            /* renamed from: d */
            private String f14770d = "";
            /* renamed from: e */
            private boolean f14771e;
            /* renamed from: f */
            private int f14772f = 0;
            /* renamed from: g */
            private boolean f14773g;
            /* renamed from: h */
            private String f14774h = "";
            /* renamed from: i */
            private boolean f14775i;
            /* renamed from: j */
            private Jump f14776j = null;
            /* renamed from: k */
            private boolean f14777k;
            /* renamed from: l */
            private TagInfo f14778l = null;
            /* renamed from: m */
            private boolean f14779m;
            /* renamed from: n */
            private String f14780n = "";
            /* renamed from: o */
            private int f14781o = -1;

            public static SubPoi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new SubPoi().mergeFrom(codedInputStreamMicro);
            }

            public static SubPoi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (SubPoi) new SubPoi().mergeFrom(bArr);
            }

            public final SubPoi clear() {
                clearPoiName();
                clearUid();
                clearGrid();
                clearSearchQuery();
                clearJump();
                clearTagInfo();
                clearKnowledgeInfo();
                this.f14781o = -1;
                return this;
            }

            public SubPoi clearGrid() {
                this.f14771e = false;
                this.f14772f = 0;
                return this;
            }

            public SubPoi clearJump() {
                this.f14775i = false;
                this.f14776j = null;
                return this;
            }

            public SubPoi clearKnowledgeInfo() {
                this.f14779m = false;
                this.f14780n = "";
                return this;
            }

            public SubPoi clearPoiName() {
                this.f14767a = false;
                this.f14768b = "";
                return this;
            }

            public SubPoi clearSearchQuery() {
                this.f14773g = false;
                this.f14774h = "";
                return this;
            }

            public SubPoi clearTagInfo() {
                this.f14777k = false;
                this.f14778l = null;
                return this;
            }

            public SubPoi clearUid() {
                this.f14769c = false;
                this.f14770d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14781o < 0) {
                    getSerializedSize();
                }
                return this.f14781o;
            }

            public int getGrid() {
                return this.f14772f;
            }

            public Jump getJump() {
                return this.f14776j;
            }

            public String getKnowledgeInfo() {
                return this.f14780n;
            }

            public String getPoiName() {
                return this.f14768b;
            }

            public String getSearchQuery() {
                return this.f14774h;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasPoiName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasGrid()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getGrid());
                }
                if (hasSearchQuery()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getSearchQuery());
                }
                if (hasJump()) {
                    i += CodedOutputStreamMicro.computeMessageSize(5, getJump());
                }
                if (hasTagInfo()) {
                    i += CodedOutputStreamMicro.computeMessageSize(6, getTagInfo());
                }
                if (hasKnowledgeInfo()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getKnowledgeInfo());
                }
                this.f14781o = i;
                return i;
            }

            public TagInfo getTagInfo() {
                return this.f14778l;
            }

            public String getUid() {
                return this.f14770d;
            }

            public boolean hasGrid() {
                return this.f14771e;
            }

            public boolean hasJump() {
                return this.f14775i;
            }

            public boolean hasKnowledgeInfo() {
                return this.f14779m;
            }

            public boolean hasPoiName() {
                return this.f14767a;
            }

            public boolean hasSearchQuery() {
                return this.f14773g;
            }

            public boolean hasTagInfo() {
                return this.f14777k;
            }

            public boolean hasUid() {
                return this.f14769c;
            }

            public final boolean isInitialized() {
                return true;
            }

            public SubPoi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro jump;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setPoiName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 24:
                            setGrid(codedInputStreamMicro.readInt32());
                            continue;
                        case 34:
                            setSearchQuery(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            jump = new Jump();
                            codedInputStreamMicro.readMessage(jump);
                            setJump(jump);
                            continue;
                        case 50:
                            jump = new TagInfo();
                            codedInputStreamMicro.readMessage(jump);
                            setTagInfo(jump);
                            continue;
                        case 58:
                            setKnowledgeInfo(codedInputStreamMicro.readString());
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

            public SubPoi setGrid(int i) {
                this.f14771e = true;
                this.f14772f = i;
                return this;
            }

            public SubPoi setJump(Jump jump) {
                if (jump == null) {
                    return clearJump();
                }
                this.f14775i = true;
                this.f14776j = jump;
                return this;
            }

            public SubPoi setKnowledgeInfo(String str) {
                this.f14779m = true;
                this.f14780n = str;
                return this;
            }

            public SubPoi setPoiName(String str) {
                this.f14767a = true;
                this.f14768b = str;
                return this;
            }

            public SubPoi setSearchQuery(String str) {
                this.f14773g = true;
                this.f14774h = str;
                return this;
            }

            public SubPoi setTagInfo(TagInfo tagInfo) {
                if (tagInfo == null) {
                    return clearTagInfo();
                }
                this.f14777k = true;
                this.f14778l = tagInfo;
                return this;
            }

            public SubPoi setUid(String str) {
                this.f14769c = true;
                this.f14770d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPoiName()) {
                    codedOutputStreamMicro.writeString(1, getPoiName());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasGrid()) {
                    codedOutputStreamMicro.writeInt32(3, getGrid());
                }
                if (hasSearchQuery()) {
                    codedOutputStreamMicro.writeString(4, getSearchQuery());
                }
                if (hasJump()) {
                    codedOutputStreamMicro.writeMessage(5, getJump());
                }
                if (hasTagInfo()) {
                    codedOutputStreamMicro.writeMessage(6, getTagInfo());
                }
                if (hasKnowledgeInfo()) {
                    codedOutputStreamMicro.writeString(7, getKnowledgeInfo());
                }
            }
        }

        public static final class TagInfo extends MessageMicro {
            public static final int BKG_COLOR_FIELD_NUMBER = 4;
            public static final int FONT_SIZE_FIELD_NUMBER = 2;
            public static final int NAME_COLOR_FIELD_NUMBER = 3;
            public static final int SHOW_NAME_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14782a;
            /* renamed from: b */
            private String f14783b = "";
            /* renamed from: c */
            private boolean f14784c;
            /* renamed from: d */
            private int f14785d = 0;
            /* renamed from: e */
            private boolean f14786e;
            /* renamed from: f */
            private String f14787f = "";
            /* renamed from: g */
            private boolean f14788g;
            /* renamed from: h */
            private String f14789h = "";
            /* renamed from: i */
            private int f14790i = -1;

            public static TagInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new TagInfo().mergeFrom(codedInputStreamMicro);
            }

            public static TagInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (TagInfo) new TagInfo().mergeFrom(bArr);
            }

            public final TagInfo clear() {
                clearShowName();
                clearFontSize();
                clearNameColor();
                clearBkgColor();
                this.f14790i = -1;
                return this;
            }

            public TagInfo clearBkgColor() {
                this.f14788g = false;
                this.f14789h = "";
                return this;
            }

            public TagInfo clearFontSize() {
                this.f14784c = false;
                this.f14785d = 0;
                return this;
            }

            public TagInfo clearNameColor() {
                this.f14786e = false;
                this.f14787f = "";
                return this;
            }

            public TagInfo clearShowName() {
                this.f14782a = false;
                this.f14783b = "";
                return this;
            }

            public String getBkgColor() {
                return this.f14789h;
            }

            public int getCachedSize() {
                if (this.f14790i < 0) {
                    getSerializedSize();
                }
                return this.f14790i;
            }

            public int getFontSize() {
                return this.f14785d;
            }

            public String getNameColor() {
                return this.f14787f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasShowName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getShowName());
                }
                if (hasFontSize()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getFontSize());
                }
                if (hasNameColor()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getNameColor());
                }
                if (hasBkgColor()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getBkgColor());
                }
                this.f14790i = i;
                return i;
            }

            public String getShowName() {
                return this.f14783b;
            }

            public boolean hasBkgColor() {
                return this.f14788g;
            }

            public boolean hasFontSize() {
                return this.f14784c;
            }

            public boolean hasNameColor() {
                return this.f14786e;
            }

            public boolean hasShowName() {
                return this.f14782a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public TagInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setShowName(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setFontSize(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setNameColor(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setBkgColor(codedInputStreamMicro.readString());
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

            public TagInfo setBkgColor(String str) {
                this.f14788g = true;
                this.f14789h = str;
                return this;
            }

            public TagInfo setFontSize(int i) {
                this.f14784c = true;
                this.f14785d = i;
                return this;
            }

            public TagInfo setNameColor(String str) {
                this.f14786e = true;
                this.f14787f = str;
                return this;
            }

            public TagInfo setShowName(String str) {
                this.f14782a = true;
                this.f14783b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasShowName()) {
                    codedOutputStreamMicro.writeString(1, getShowName());
                }
                if (hasFontSize()) {
                    codedOutputStreamMicro.writeInt32(2, getFontSize());
                }
                if (hasNameColor()) {
                    codedOutputStreamMicro.writeString(3, getNameColor());
                }
                if (hasBkgColor()) {
                    codedOutputStreamMicro.writeString(4, getBkgColor());
                }
            }
        }

        public static PoiElement parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PoiElement().mergeFrom(codedInputStreamMicro);
        }

        public static PoiElement parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PoiElement) new PoiElement().mergeFrom(bArr);
        }

        public PoiElement addSubPoiArray(SubPoi subPoi) {
            if (subPoi != null) {
                if (this.f14813k.isEmpty()) {
                    this.f14813k = new ArrayList();
                }
                this.f14813k.add(subPoi);
            }
            return this;
        }

        public final PoiElement clear() {
            clearPoiName();
            clearSubTitle();
            clearCityid();
            clearDistance();
            clearSubPoiType();
            clearSubPoiArray();
            clearPoiX();
            clearPoiY();
            clearTagInfo();
            clearUid();
            clearDisplayQuery();
            clearJump();
            clearLine1Column1();
            clearLine1Column2();
            clearLine1Column3();
            clearLine2Column1();
            clearLine2Column2();
            clearLine2Column3();
            clearCatalogId();
            this.f14802L = -1;
            return this;
        }

        public PoiElement clearCatalogId() {
            this.f14800J = false;
            this.f14801K = 0;
            return this;
        }

        public PoiElement clearCityid() {
            this.f14807e = false;
            this.f14808f = 0;
            return this;
        }

        public PoiElement clearDisplayQuery() {
            this.f14822t = false;
            this.f14823u = "";
            return this;
        }

        public PoiElement clearDistance() {
            this.f14809g = false;
            this.f14810h = "";
            return this;
        }

        public PoiElement clearJump() {
            this.f14824v = false;
            this.f14825w = null;
            return this;
        }

        public PoiElement clearLine1Column1() {
            this.f14826x = false;
            this.f14827y = "";
            return this;
        }

        public PoiElement clearLine1Column2() {
            this.f14828z = false;
            this.f14791A = "";
            return this;
        }

        public PoiElement clearLine1Column3() {
            this.f14792B = false;
            this.f14793C = "";
            return this;
        }

        public PoiElement clearLine2Column1() {
            this.f14794D = false;
            this.f14795E = "";
            return this;
        }

        public PoiElement clearLine2Column2() {
            this.f14796F = false;
            this.f14797G = "";
            return this;
        }

        public PoiElement clearLine2Column3() {
            this.f14798H = false;
            this.f14799I = "";
            return this;
        }

        public PoiElement clearPoiName() {
            this.f14803a = false;
            this.f14804b = "";
            return this;
        }

        public PoiElement clearPoiX() {
            this.f14814l = false;
            this.f14815m = 0.0d;
            return this;
        }

        public PoiElement clearPoiY() {
            this.f14816n = false;
            this.f14817o = 0.0d;
            return this;
        }

        public PoiElement clearSubPoiArray() {
            this.f14813k = Collections.emptyList();
            return this;
        }

        public PoiElement clearSubPoiType() {
            this.f14811i = false;
            this.f14812j = 0;
            return this;
        }

        public PoiElement clearSubTitle() {
            this.f14805c = false;
            this.f14806d = "";
            return this;
        }

        public PoiElement clearTagInfo() {
            this.f14818p = false;
            this.f14819q = null;
            return this;
        }

        public PoiElement clearUid() {
            this.f14820r = false;
            this.f14821s = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14802L < 0) {
                getSerializedSize();
            }
            return this.f14802L;
        }

        public int getCatalogId() {
            return this.f14801K;
        }

        public int getCityid() {
            return this.f14808f;
        }

        public String getDisplayQuery() {
            return this.f14823u;
        }

        public String getDistance() {
            return this.f14810h;
        }

        public Jump getJump() {
            return this.f14825w;
        }

        public String getLine1Column1() {
            return this.f14827y;
        }

        public String getLine1Column2() {
            return this.f14791A;
        }

        public String getLine1Column3() {
            return this.f14793C;
        }

        public String getLine2Column1() {
            return this.f14795E;
        }

        public String getLine2Column2() {
            return this.f14797G;
        }

        public String getLine2Column3() {
            return this.f14799I;
        }

        public String getPoiName() {
            return this.f14804b;
        }

        public double getPoiX() {
            return this.f14815m;
        }

        public double getPoiY() {
            return this.f14817o;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPoiName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
            }
            if (hasCityid()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getCityid());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getDistance());
            }
            if (hasSubPoiType()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getSubPoiType());
            }
            int i2 = i;
            for (SubPoi computeMessageSize : getSubPoiArrayList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i2;
            }
            if (hasPoiX()) {
                i2 += CodedOutputStreamMicro.computeDoubleSize(7, getPoiX());
            }
            if (hasPoiY()) {
                i2 += CodedOutputStreamMicro.computeDoubleSize(8, getPoiY());
            }
            if (hasTagInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getTagInfo());
            }
            if (hasUid()) {
                i2 += CodedOutputStreamMicro.computeStringSize(10, getUid());
            }
            if (hasDisplayQuery()) {
                i2 += CodedOutputStreamMicro.computeStringSize(11, getDisplayQuery());
            }
            if (hasJump()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(12, getJump());
            }
            if (hasLine1Column1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(13, getLine1Column1());
            }
            if (hasLine1Column2()) {
                i2 += CodedOutputStreamMicro.computeStringSize(14, getLine1Column2());
            }
            if (hasLine1Column3()) {
                i2 += CodedOutputStreamMicro.computeStringSize(15, getLine1Column3());
            }
            if (hasLine2Column1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(16, getLine2Column1());
            }
            if (hasLine2Column2()) {
                i2 += CodedOutputStreamMicro.computeStringSize(17, getLine2Column2());
            }
            if (hasLine2Column3()) {
                i2 += CodedOutputStreamMicro.computeStringSize(18, getLine2Column3());
            }
            if (hasCatalogId()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(19, getCatalogId());
            }
            this.f14802L = i2;
            return i2;
        }

        public SubPoi getSubPoiArray(int i) {
            return (SubPoi) this.f14813k.get(i);
        }

        public int getSubPoiArrayCount() {
            return this.f14813k.size();
        }

        public List<SubPoi> getSubPoiArrayList() {
            return this.f14813k;
        }

        public int getSubPoiType() {
            return this.f14812j;
        }

        public String getSubTitle() {
            return this.f14806d;
        }

        public TagInfo getTagInfo() {
            return this.f14819q;
        }

        public String getUid() {
            return this.f14821s;
        }

        public boolean hasCatalogId() {
            return this.f14800J;
        }

        public boolean hasCityid() {
            return this.f14807e;
        }

        public boolean hasDisplayQuery() {
            return this.f14822t;
        }

        public boolean hasDistance() {
            return this.f14809g;
        }

        public boolean hasJump() {
            return this.f14824v;
        }

        public boolean hasLine1Column1() {
            return this.f14826x;
        }

        public boolean hasLine1Column2() {
            return this.f14828z;
        }

        public boolean hasLine1Column3() {
            return this.f14792B;
        }

        public boolean hasLine2Column1() {
            return this.f14794D;
        }

        public boolean hasLine2Column2() {
            return this.f14796F;
        }

        public boolean hasLine2Column3() {
            return this.f14798H;
        }

        public boolean hasPoiName() {
            return this.f14803a;
        }

        public boolean hasPoiX() {
            return this.f14814l;
        }

        public boolean hasPoiY() {
            return this.f14816n;
        }

        public boolean hasSubPoiType() {
            return this.f14811i;
        }

        public boolean hasSubTitle() {
            return this.f14805c;
        }

        public boolean hasTagInfo() {
            return this.f14818p;
        }

        public boolean hasUid() {
            return this.f14820r;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PoiElement mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro subPoi;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setPoiName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setCityid(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setSubPoiType(codedInputStreamMicro.readInt32());
                        continue;
                    case 50:
                        subPoi = new SubPoi();
                        codedInputStreamMicro.readMessage(subPoi);
                        addSubPoiArray(subPoi);
                        continue;
                    case 57:
                        setPoiX(codedInputStreamMicro.readDouble());
                        continue;
                    case 65:
                        setPoiY(codedInputStreamMicro.readDouble());
                        continue;
                    case 74:
                        subPoi = new TagInfo();
                        codedInputStreamMicro.readMessage(subPoi);
                        setTagInfo(subPoi);
                        continue;
                    case 82:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setDisplayQuery(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        subPoi = new Jump();
                        codedInputStreamMicro.readMessage(subPoi);
                        setJump(subPoi);
                        continue;
                    case 106:
                        setLine1Column1(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setLine1Column2(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setLine1Column3(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setLine2Column1(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setLine2Column2(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        setLine2Column3(codedInputStreamMicro.readString());
                        continue;
                    case 152:
                        setCatalogId(codedInputStreamMicro.readInt32());
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

        public PoiElement setCatalogId(int i) {
            this.f14800J = true;
            this.f14801K = i;
            return this;
        }

        public PoiElement setCityid(int i) {
            this.f14807e = true;
            this.f14808f = i;
            return this;
        }

        public PoiElement setDisplayQuery(String str) {
            this.f14822t = true;
            this.f14823u = str;
            return this;
        }

        public PoiElement setDistance(String str) {
            this.f14809g = true;
            this.f14810h = str;
            return this;
        }

        public PoiElement setJump(Jump jump) {
            if (jump == null) {
                return clearJump();
            }
            this.f14824v = true;
            this.f14825w = jump;
            return this;
        }

        public PoiElement setLine1Column1(String str) {
            this.f14826x = true;
            this.f14827y = str;
            return this;
        }

        public PoiElement setLine1Column2(String str) {
            this.f14828z = true;
            this.f14791A = str;
            return this;
        }

        public PoiElement setLine1Column3(String str) {
            this.f14792B = true;
            this.f14793C = str;
            return this;
        }

        public PoiElement setLine2Column1(String str) {
            this.f14794D = true;
            this.f14795E = str;
            return this;
        }

        public PoiElement setLine2Column2(String str) {
            this.f14796F = true;
            this.f14797G = str;
            return this;
        }

        public PoiElement setLine2Column3(String str) {
            this.f14798H = true;
            this.f14799I = str;
            return this;
        }

        public PoiElement setPoiName(String str) {
            this.f14803a = true;
            this.f14804b = str;
            return this;
        }

        public PoiElement setPoiX(double d) {
            this.f14814l = true;
            this.f14815m = d;
            return this;
        }

        public PoiElement setPoiY(double d) {
            this.f14816n = true;
            this.f14817o = d;
            return this;
        }

        public PoiElement setSubPoiArray(int i, SubPoi subPoi) {
            if (subPoi != null) {
                this.f14813k.set(i, subPoi);
            }
            return this;
        }

        public PoiElement setSubPoiType(int i) {
            this.f14811i = true;
            this.f14812j = i;
            return this;
        }

        public PoiElement setSubTitle(String str) {
            this.f14805c = true;
            this.f14806d = str;
            return this;
        }

        public PoiElement setTagInfo(TagInfo tagInfo) {
            if (tagInfo == null) {
                return clearTagInfo();
            }
            this.f14818p = true;
            this.f14819q = tagInfo;
            return this;
        }

        public PoiElement setUid(String str) {
            this.f14820r = true;
            this.f14821s = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPoiName()) {
                codedOutputStreamMicro.writeString(1, getPoiName());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(2, getSubTitle());
            }
            if (hasCityid()) {
                codedOutputStreamMicro.writeInt32(3, getCityid());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(4, getDistance());
            }
            if (hasSubPoiType()) {
                codedOutputStreamMicro.writeInt32(5, getSubPoiType());
            }
            for (SubPoi writeMessage : getSubPoiArrayList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage);
            }
            if (hasPoiX()) {
                codedOutputStreamMicro.writeDouble(7, getPoiX());
            }
            if (hasPoiY()) {
                codedOutputStreamMicro.writeDouble(8, getPoiY());
            }
            if (hasTagInfo()) {
                codedOutputStreamMicro.writeMessage(9, getTagInfo());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(10, getUid());
            }
            if (hasDisplayQuery()) {
                codedOutputStreamMicro.writeString(11, getDisplayQuery());
            }
            if (hasJump()) {
                codedOutputStreamMicro.writeMessage(12, getJump());
            }
            if (hasLine1Column1()) {
                codedOutputStreamMicro.writeString(13, getLine1Column1());
            }
            if (hasLine1Column2()) {
                codedOutputStreamMicro.writeString(14, getLine1Column2());
            }
            if (hasLine1Column3()) {
                codedOutputStreamMicro.writeString(15, getLine1Column3());
            }
            if (hasLine2Column1()) {
                codedOutputStreamMicro.writeString(16, getLine2Column1());
            }
            if (hasLine2Column2()) {
                codedOutputStreamMicro.writeString(17, getLine2Column2());
            }
            if (hasLine2Column3()) {
                codedOutputStreamMicro.writeString(18, getLine2Column3());
            }
            if (hasCatalogId()) {
                codedOutputStreamMicro.writeInt32(19, getCatalogId());
            }
        }
    }

    public static SusvrResponse parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new SusvrResponse().mergeFrom(codedInputStreamMicro);
    }

    public static SusvrResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (SusvrResponse) new SusvrResponse().mergeFrom(bArr);
    }

    public SusvrResponse addDisplayStyles(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (this.f14834f.isEmpty()) {
            this.f14834f = new ArrayList();
        }
        this.f14834f.add(str);
        return this;
    }

    public SusvrResponse addPoiArray(PoiElement poiElement) {
        if (poiElement != null) {
            if (this.f14829a.isEmpty()) {
                this.f14829a = new ArrayList();
            }
            this.f14829a.add(poiElement);
        }
        return this;
    }

    public final SusvrResponse clear() {
        clearPoiArray();
        clearType();
        clearOffline();
        clearDisplayStyles();
        clearSeId();
        this.f14837i = -1;
        return this;
    }

    public SusvrResponse clearDisplayStyles() {
        this.f14834f = Collections.emptyList();
        return this;
    }

    public SusvrResponse clearOffline() {
        this.f14832d = false;
        this.f14833e = 0;
        return this;
    }

    public SusvrResponse clearPoiArray() {
        this.f14829a = Collections.emptyList();
        return this;
    }

    public SusvrResponse clearSeId() {
        this.f14835g = false;
        this.f14836h = 0;
        return this;
    }

    public SusvrResponse clearType() {
        this.f14830b = false;
        this.f14831c = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f14837i < 0) {
            getSerializedSize();
        }
        return this.f14837i;
    }

    public String getDisplayStyles(int i) {
        return (String) this.f14834f.get(i);
    }

    public int getDisplayStylesCount() {
        return this.f14834f.size();
    }

    public List<String> getDisplayStylesList() {
        return this.f14834f;
    }

    public int getOffline() {
        return this.f14833e;
    }

    public PoiElement getPoiArray(int i) {
        return (PoiElement) this.f14829a.get(i);
    }

    public int getPoiArrayCount() {
        return this.f14829a.size();
    }

    public List<PoiElement> getPoiArrayList() {
        return this.f14829a;
    }

    public long getSeId() {
        return this.f14836h;
    }

    public int getSerializedSize() {
        int i = 0;
        int i2 = 0;
        for (PoiElement computeMessageSize : getPoiArrayList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i2;
        }
        if (hasType()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(2, getType());
        }
        if (hasOffline()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(3, getOffline());
        }
        for (String computeStringSizeNoTag : getDisplayStylesList()) {
            i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
        }
        int size = (i2 + i) + (getDisplayStylesList().size() * 1);
        if (hasSeId()) {
            size += CodedOutputStreamMicro.computeUInt64Size(5, getSeId());
        }
        this.f14837i = size;
        return size;
    }

    public int getType() {
        return this.f14831c;
    }

    public boolean hasOffline() {
        return this.f14832d;
    }

    public boolean hasSeId() {
        return this.f14835g;
    }

    public boolean hasType() {
        return this.f14830b;
    }

    public final boolean isInitialized() {
        return true;
    }

    public SusvrResponse mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro poiElement = new PoiElement();
                    codedInputStreamMicro.readMessage(poiElement);
                    addPoiArray(poiElement);
                    continue;
                case 16:
                    setType(codedInputStreamMicro.readInt32());
                    continue;
                case 24:
                    setOffline(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    addDisplayStyles(codedInputStreamMicro.readString());
                    continue;
                case 40:
                    setSeId(codedInputStreamMicro.readUInt64());
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

    public SusvrResponse setDisplayStyles(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f14834f.set(i, str);
        return this;
    }

    public SusvrResponse setOffline(int i) {
        this.f14832d = true;
        this.f14833e = i;
        return this;
    }

    public SusvrResponse setPoiArray(int i, PoiElement poiElement) {
        if (poiElement != null) {
            this.f14829a.set(i, poiElement);
        }
        return this;
    }

    public SusvrResponse setSeId(long j) {
        this.f14835g = true;
        this.f14836h = j;
        return this;
    }

    public SusvrResponse setType(int i) {
        this.f14830b = true;
        this.f14831c = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (PoiElement writeMessage : getPoiArrayList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(2, getType());
        }
        if (hasOffline()) {
            codedOutputStreamMicro.writeInt32(3, getOffline());
        }
        for (String writeString : getDisplayStylesList()) {
            codedOutputStreamMicro.writeString(4, writeString);
        }
        if (hasSeId()) {
            codedOutputStreamMicro.writeUInt64(5, getSeId());
        }
    }
}
