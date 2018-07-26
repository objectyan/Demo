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

public final class PoiResult$PlaceInfo extends MessageMicro {
    public static final int BANNER_INFO_FIELD_NUMBER = 8;
    public static final int D_ACT_CARD_FIELD_NUMBER = 9;
    public static final int D_BUSINESS_ID_FIELD_NUMBER = 5;
    public static final int D_BUSINESS_TYPE_FIELD_NUMBER = 6;
    public static final int D_DATA_TYPE_FIELD_NUMBER = 1;
    public static final int D_FILTERS_SHOW_FLAG_FIELD_NUMBER = 4;
    public static final int D_SORT_RULE_FIELD_NUMBER = 3;
    public static final int D_SORT_TYPE_FIELD_NUMBER = 2;
    public static final int D_SUB_TYPE_FIELD_NUMBER = 10;
    public static final int FILTERS_FIELD_NUMBER = 11;
    public static final int SEARCH_EXT_FIELD_NUMBER = 7;
    /* renamed from: a */
    private List<SearchExt> f14126a = Collections.emptyList();
    /* renamed from: b */
    private boolean f14127b;
    /* renamed from: c */
    private DActCard f14128c = null;
    /* renamed from: d */
    private boolean f14129d;
    /* renamed from: e */
    private BannerInfo f14130e = null;
    /* renamed from: f */
    private boolean f14131f;
    /* renamed from: g */
    private String f14132g = "";
    /* renamed from: h */
    private boolean f14133h;
    /* renamed from: i */
    private String f14134i = "";
    /* renamed from: j */
    private boolean f14135j;
    /* renamed from: k */
    private int f14136k = 0;
    /* renamed from: l */
    private boolean f14137l;
    /* renamed from: m */
    private int f14138m = 0;
    /* renamed from: n */
    private boolean f14139n;
    /* renamed from: o */
    private String f14140o = "";
    /* renamed from: p */
    private boolean f14141p;
    /* renamed from: q */
    private String f14142q = "";
    /* renamed from: r */
    private boolean f14143r;
    /* renamed from: s */
    private String f14144s = "";
    /* renamed from: t */
    private boolean f14145t;
    /* renamed from: u */
    private ByteStringMicro f14146u = ByteStringMicro.EMPTY;
    /* renamed from: v */
    private int f14147v = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$PlaceInfo$BannerInfo */
    public static final class BannerInfo extends MessageMicro {
        public static final int ACT_FIELD_NUMBER = 4;
        public static final int ACT_URL_FIELD_NUMBER = 5;
        public static final int DESCRIPTION_FIELD_NUMBER = 6;
        public static final int IMAGE_FIELD_NUMBER = 3;
        public static final int SCORE_FIELD_NUMBER = 2;
        public static final int STAR_FIELD_NUMBER = 7;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14101a;
        /* renamed from: b */
        private String f14102b = "";
        /* renamed from: c */
        private boolean f14103c;
        /* renamed from: d */
        private String f14104d = "";
        /* renamed from: e */
        private boolean f14105e;
        /* renamed from: f */
        private String f14106f = "";
        /* renamed from: g */
        private boolean f14107g;
        /* renamed from: h */
        private String f14108h = "";
        /* renamed from: i */
        private boolean f14109i;
        /* renamed from: j */
        private String f14110j = "";
        /* renamed from: k */
        private boolean f14111k;
        /* renamed from: l */
        private String f14112l = "";
        /* renamed from: m */
        private boolean f14113m;
        /* renamed from: n */
        private String f14114n = "";
        /* renamed from: o */
        private int f14115o = -1;

        public static BannerInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BannerInfo().mergeFrom(codedInputStreamMicro);
        }

        public static BannerInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BannerInfo) new BannerInfo().mergeFrom(bArr);
        }

        public final BannerInfo clear() {
            clearTitle();
            clearScore();
            clearImage();
            clearAct();
            clearActUrl();
            clearDescription();
            clearStar();
            this.f14115o = -1;
            return this;
        }

        public BannerInfo clearAct() {
            this.f14107g = false;
            this.f14108h = "";
            return this;
        }

        public BannerInfo clearActUrl() {
            this.f14109i = false;
            this.f14110j = "";
            return this;
        }

        public BannerInfo clearDescription() {
            this.f14111k = false;
            this.f14112l = "";
            return this;
        }

        public BannerInfo clearImage() {
            this.f14105e = false;
            this.f14106f = "";
            return this;
        }

        public BannerInfo clearScore() {
            this.f14103c = false;
            this.f14104d = "";
            return this;
        }

        public BannerInfo clearStar() {
            this.f14113m = false;
            this.f14114n = "";
            return this;
        }

        public BannerInfo clearTitle() {
            this.f14101a = false;
            this.f14102b = "";
            return this;
        }

        public String getAct() {
            return this.f14108h;
        }

        public String getActUrl() {
            return this.f14110j;
        }

        public int getCachedSize() {
            if (this.f14115o < 0) {
                getSerializedSize();
            }
            return this.f14115o;
        }

        public String getDescription() {
            return this.f14112l;
        }

        public String getImage() {
            return this.f14106f;
        }

        public String getScore() {
            return this.f14104d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasScore()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getScore());
            }
            if (hasImage()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getImage());
            }
            if (hasAct()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getAct());
            }
            if (hasActUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getActUrl());
            }
            if (hasDescription()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDescription());
            }
            if (hasStar()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getStar());
            }
            this.f14115o = i;
            return i;
        }

        public String getStar() {
            return this.f14114n;
        }

        public String getTitle() {
            return this.f14102b;
        }

        public boolean hasAct() {
            return this.f14107g;
        }

        public boolean hasActUrl() {
            return this.f14109i;
        }

        public boolean hasDescription() {
            return this.f14111k;
        }

        public boolean hasImage() {
            return this.f14105e;
        }

        public boolean hasScore() {
            return this.f14103c;
        }

        public boolean hasStar() {
            return this.f14113m;
        }

        public boolean hasTitle() {
            return this.f14101a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BannerInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setScore(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setImage(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setAct(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setActUrl(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setDescription(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setStar(codedInputStreamMicro.readString());
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

        public BannerInfo setAct(String str) {
            this.f14107g = true;
            this.f14108h = str;
            return this;
        }

        public BannerInfo setActUrl(String str) {
            this.f14109i = true;
            this.f14110j = str;
            return this;
        }

        public BannerInfo setDescription(String str) {
            this.f14111k = true;
            this.f14112l = str;
            return this;
        }

        public BannerInfo setImage(String str) {
            this.f14105e = true;
            this.f14106f = str;
            return this;
        }

        public BannerInfo setScore(String str) {
            this.f14103c = true;
            this.f14104d = str;
            return this;
        }

        public BannerInfo setStar(String str) {
            this.f14113m = true;
            this.f14114n = str;
            return this;
        }

        public BannerInfo setTitle(String str) {
            this.f14101a = true;
            this.f14102b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasScore()) {
                codedOutputStreamMicro.writeString(2, getScore());
            }
            if (hasImage()) {
                codedOutputStreamMicro.writeString(3, getImage());
            }
            if (hasAct()) {
                codedOutputStreamMicro.writeString(4, getAct());
            }
            if (hasActUrl()) {
                codedOutputStreamMicro.writeString(5, getActUrl());
            }
            if (hasDescription()) {
                codedOutputStreamMicro.writeString(6, getDescription());
            }
            if (hasStar()) {
                codedOutputStreamMicro.writeString(7, getStar());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$PlaceInfo$DActCard */
    public static final class DActCard extends MessageMicro {
        public static final int IMG_URL_FIELD_NUMBER = 2;
        public static final int LINK_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14116a;
        /* renamed from: b */
        private String f14117b = "";
        /* renamed from: c */
        private boolean f14118c;
        /* renamed from: d */
        private String f14119d = "";
        /* renamed from: e */
        private int f14120e = -1;

        public static DActCard parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new DActCard().mergeFrom(codedInputStreamMicro);
        }

        public static DActCard parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (DActCard) new DActCard().mergeFrom(bArr);
        }

        public final DActCard clear() {
            clearLink();
            clearImgUrl();
            this.f14120e = -1;
            return this;
        }

        public DActCard clearImgUrl() {
            this.f14118c = false;
            this.f14119d = "";
            return this;
        }

        public DActCard clearLink() {
            this.f14116a = false;
            this.f14117b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14120e < 0) {
                getSerializedSize();
            }
            return this.f14120e;
        }

        public String getImgUrl() {
            return this.f14119d;
        }

        public String getLink() {
            return this.f14117b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLink()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLink());
            }
            if (hasImgUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getImgUrl());
            }
            this.f14120e = i;
            return i;
        }

        public boolean hasImgUrl() {
            return this.f14118c;
        }

        public boolean hasLink() {
            return this.f14116a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public DActCard mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLink(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setImgUrl(codedInputStreamMicro.readString());
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

        public DActCard setImgUrl(String str) {
            this.f14118c = true;
            this.f14119d = str;
            return this;
        }

        public DActCard setLink(String str) {
            this.f14116a = true;
            this.f14117b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLink()) {
                codedOutputStreamMicro.writeString(1, getLink());
            }
            if (hasImgUrl()) {
                codedOutputStreamMicro.writeString(2, getImgUrl());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$PlaceInfo$SearchExt */
    public static final class SearchExt extends MessageMicro {
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int WD_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14121a;
        /* renamed from: b */
        private String f14122b = "";
        /* renamed from: c */
        private boolean f14123c;
        /* renamed from: d */
        private String f14124d = "";
        /* renamed from: e */
        private int f14125e = -1;

        public static SearchExt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SearchExt().mergeFrom(codedInputStreamMicro);
        }

        public static SearchExt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SearchExt) new SearchExt().mergeFrom(bArr);
        }

        public final SearchExt clear() {
            clearTitle();
            clearWd();
            this.f14125e = -1;
            return this;
        }

        public SearchExt clearTitle() {
            this.f14121a = false;
            this.f14122b = "";
            return this;
        }

        public SearchExt clearWd() {
            this.f14123c = false;
            this.f14124d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14125e < 0) {
                getSerializedSize();
            }
            return this.f14125e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasWd()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getWd());
            }
            this.f14125e = i;
            return i;
        }

        public String getTitle() {
            return this.f14122b;
        }

        public String getWd() {
            return this.f14124d;
        }

        public boolean hasTitle() {
            return this.f14121a;
        }

        public boolean hasWd() {
            return this.f14123c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SearchExt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setWd(codedInputStreamMicro.readString());
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

        public SearchExt setTitle(String str) {
            this.f14121a = true;
            this.f14122b = str;
            return this;
        }

        public SearchExt setWd(String str) {
            this.f14123c = true;
            this.f14124d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasWd()) {
                codedOutputStreamMicro.writeString(2, getWd());
            }
        }
    }

    public static PoiResult$PlaceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$PlaceInfo().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$PlaceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$PlaceInfo) new PoiResult$PlaceInfo().mergeFrom(bArr);
    }

    public PoiResult$PlaceInfo addSearchExt(SearchExt searchExt) {
        if (searchExt != null) {
            if (this.f14126a.isEmpty()) {
                this.f14126a = new ArrayList();
            }
            this.f14126a.add(searchExt);
        }
        return this;
    }

    public final PoiResult$PlaceInfo clear() {
        clearSearchExt();
        clearDActCard();
        clearBannerInfo();
        clearDDataType();
        clearDSortType();
        clearDSortRule();
        clearDFiltersShowFlag();
        clearDBusinessId();
        clearDBusinessType();
        clearDSubType();
        clearFilters();
        this.f14147v = -1;
        return this;
    }

    public PoiResult$PlaceInfo clearBannerInfo() {
        this.f14129d = false;
        this.f14130e = null;
        return this;
    }

    public PoiResult$PlaceInfo clearDActCard() {
        this.f14127b = false;
        this.f14128c = null;
        return this;
    }

    public PoiResult$PlaceInfo clearDBusinessId() {
        this.f14139n = false;
        this.f14140o = "";
        return this;
    }

    public PoiResult$PlaceInfo clearDBusinessType() {
        this.f14141p = false;
        this.f14142q = "";
        return this;
    }

    public PoiResult$PlaceInfo clearDDataType() {
        this.f14131f = false;
        this.f14132g = "";
        return this;
    }

    public PoiResult$PlaceInfo clearDFiltersShowFlag() {
        this.f14137l = false;
        this.f14138m = 0;
        return this;
    }

    public PoiResult$PlaceInfo clearDSortRule() {
        this.f14135j = false;
        this.f14136k = 0;
        return this;
    }

    public PoiResult$PlaceInfo clearDSortType() {
        this.f14133h = false;
        this.f14134i = "";
        return this;
    }

    public PoiResult$PlaceInfo clearDSubType() {
        this.f14143r = false;
        this.f14144s = "";
        return this;
    }

    public PoiResult$PlaceInfo clearFilters() {
        this.f14145t = false;
        this.f14146u = ByteStringMicro.EMPTY;
        return this;
    }

    public PoiResult$PlaceInfo clearSearchExt() {
        this.f14126a = Collections.emptyList();
        return this;
    }

    public BannerInfo getBannerInfo() {
        return this.f14130e;
    }

    public int getCachedSize() {
        if (this.f14147v < 0) {
            getSerializedSize();
        }
        return this.f14147v;
    }

    public DActCard getDActCard() {
        return this.f14128c;
    }

    public String getDBusinessId() {
        return this.f14140o;
    }

    public String getDBusinessType() {
        return this.f14142q;
    }

    public String getDDataType() {
        return this.f14132g;
    }

    public int getDFiltersShowFlag() {
        return this.f14138m;
    }

    public int getDSortRule() {
        return this.f14136k;
    }

    public String getDSortType() {
        return this.f14134i;
    }

    public String getDSubType() {
        return this.f14144s;
    }

    public ByteStringMicro getFilters() {
        return this.f14146u;
    }

    public SearchExt getSearchExt(int i) {
        return (SearchExt) this.f14126a.get(i);
    }

    public int getSearchExtCount() {
        return this.f14126a.size();
    }

    public List<SearchExt> getSearchExtList() {
        return this.f14126a;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasDDataType()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getDDataType());
        }
        if (hasDSortType()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getDSortType());
        }
        if (hasDSortRule()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getDSortRule());
        }
        if (hasDFiltersShowFlag()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getDFiltersShowFlag());
        }
        if (hasDBusinessId()) {
            i += CodedOutputStreamMicro.computeStringSize(5, getDBusinessId());
        }
        if (hasDBusinessType()) {
            i += CodedOutputStreamMicro.computeStringSize(6, getDBusinessType());
        }
        int i2 = i;
        for (SearchExt computeMessageSize : getSearchExtList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(7, computeMessageSize) + i2;
        }
        if (hasBannerInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(8, getBannerInfo());
        }
        if (hasDActCard()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(9, getDActCard());
        }
        if (hasDSubType()) {
            i2 += CodedOutputStreamMicro.computeStringSize(10, getDSubType());
        }
        if (hasFilters()) {
            i2 += CodedOutputStreamMicro.computeBytesSize(11, getFilters());
        }
        this.f14147v = i2;
        return i2;
    }

    public boolean hasBannerInfo() {
        return this.f14129d;
    }

    public boolean hasDActCard() {
        return this.f14127b;
    }

    public boolean hasDBusinessId() {
        return this.f14139n;
    }

    public boolean hasDBusinessType() {
        return this.f14141p;
    }

    public boolean hasDDataType() {
        return this.f14131f;
    }

    public boolean hasDFiltersShowFlag() {
        return this.f14137l;
    }

    public boolean hasDSortRule() {
        return this.f14135j;
    }

    public boolean hasDSortType() {
        return this.f14133h;
    }

    public boolean hasDSubType() {
        return this.f14143r;
    }

    public boolean hasFilters() {
        return this.f14145t;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$PlaceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro searchExt;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setDDataType(codedInputStreamMicro.readString());
                    continue;
                case 18:
                    setDSortType(codedInputStreamMicro.readString());
                    continue;
                case 24:
                    setDSortRule(codedInputStreamMicro.readInt32());
                    continue;
                case 32:
                    setDFiltersShowFlag(codedInputStreamMicro.readInt32());
                    continue;
                case 42:
                    setDBusinessId(codedInputStreamMicro.readString());
                    continue;
                case 50:
                    setDBusinessType(codedInputStreamMicro.readString());
                    continue;
                case 58:
                    searchExt = new SearchExt();
                    codedInputStreamMicro.readMessage(searchExt);
                    addSearchExt(searchExt);
                    continue;
                case 66:
                    searchExt = new BannerInfo();
                    codedInputStreamMicro.readMessage(searchExt);
                    setBannerInfo(searchExt);
                    continue;
                case 74:
                    searchExt = new DActCard();
                    codedInputStreamMicro.readMessage(searchExt);
                    setDActCard(searchExt);
                    continue;
                case 82:
                    setDSubType(codedInputStreamMicro.readString());
                    continue;
                case 90:
                    setFilters(codedInputStreamMicro.readBytes());
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

    public PoiResult$PlaceInfo setBannerInfo(BannerInfo bannerInfo) {
        if (bannerInfo == null) {
            return clearBannerInfo();
        }
        this.f14129d = true;
        this.f14130e = bannerInfo;
        return this;
    }

    public PoiResult$PlaceInfo setDActCard(DActCard dActCard) {
        if (dActCard == null) {
            return clearDActCard();
        }
        this.f14127b = true;
        this.f14128c = dActCard;
        return this;
    }

    public PoiResult$PlaceInfo setDBusinessId(String str) {
        this.f14139n = true;
        this.f14140o = str;
        return this;
    }

    public PoiResult$PlaceInfo setDBusinessType(String str) {
        this.f14141p = true;
        this.f14142q = str;
        return this;
    }

    public PoiResult$PlaceInfo setDDataType(String str) {
        this.f14131f = true;
        this.f14132g = str;
        return this;
    }

    public PoiResult$PlaceInfo setDFiltersShowFlag(int i) {
        this.f14137l = true;
        this.f14138m = i;
        return this;
    }

    public PoiResult$PlaceInfo setDSortRule(int i) {
        this.f14135j = true;
        this.f14136k = i;
        return this;
    }

    public PoiResult$PlaceInfo setDSortType(String str) {
        this.f14133h = true;
        this.f14134i = str;
        return this;
    }

    public PoiResult$PlaceInfo setDSubType(String str) {
        this.f14143r = true;
        this.f14144s = str;
        return this;
    }

    public PoiResult$PlaceInfo setFilters(ByteStringMicro byteStringMicro) {
        this.f14145t = true;
        this.f14146u = byteStringMicro;
        return this;
    }

    public PoiResult$PlaceInfo setSearchExt(int i, SearchExt searchExt) {
        if (searchExt != null) {
            this.f14126a.set(i, searchExt);
        }
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasDDataType()) {
            codedOutputStreamMicro.writeString(1, getDDataType());
        }
        if (hasDSortType()) {
            codedOutputStreamMicro.writeString(2, getDSortType());
        }
        if (hasDSortRule()) {
            codedOutputStreamMicro.writeInt32(3, getDSortRule());
        }
        if (hasDFiltersShowFlag()) {
            codedOutputStreamMicro.writeInt32(4, getDFiltersShowFlag());
        }
        if (hasDBusinessId()) {
            codedOutputStreamMicro.writeString(5, getDBusinessId());
        }
        if (hasDBusinessType()) {
            codedOutputStreamMicro.writeString(6, getDBusinessType());
        }
        for (SearchExt writeMessage : getSearchExtList()) {
            codedOutputStreamMicro.writeMessage(7, writeMessage);
        }
        if (hasBannerInfo()) {
            codedOutputStreamMicro.writeMessage(8, getBannerInfo());
        }
        if (hasDActCard()) {
            codedOutputStreamMicro.writeMessage(9, getDActCard());
        }
        if (hasDSubType()) {
            codedOutputStreamMicro.writeString(10, getDSubType());
        }
        if (hasFilters()) {
            codedOutputStreamMicro.writeBytes(11, getFilters());
        }
    }
}
