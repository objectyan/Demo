package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Travel extends MessageMicro {
    public static final int CARD_FIELD_NUMBER = 2;
    public static final int FEEDLIST_FIELD_NUMBER = 8;
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int IMGURL_FIELD_NUMBER = 6;
    public static final int INFO_FIELD_NUMBER = 4;
    public static final int NONLOCAL_FIELD_NUMBER = 5;
    public static final int ROUTE_FIELD_NUMBER = 3;
    public static final int SHARE_FIELD_NUMBER = 7;
    /* renamed from: a */
    private boolean f16682a;
    /* renamed from: b */
    private Header f16683b = null;
    /* renamed from: c */
    private List<Card> f16684c = Collections.emptyList();
    /* renamed from: d */
    private boolean f16685d;
    /* renamed from: e */
    private Route f16686e = null;
    /* renamed from: f */
    private boolean f16687f;
    /* renamed from: g */
    private Infomation f16688g = null;
    /* renamed from: h */
    private boolean f16689h;
    /* renamed from: i */
    private Nonlocal f16690i = null;
    /* renamed from: j */
    private boolean f16691j;
    /* renamed from: k */
    private String f16692k = "";
    /* renamed from: l */
    private boolean f16693l;
    /* renamed from: m */
    private Share f16694m = null;
    /* renamed from: n */
    private boolean f16695n;
    /* renamed from: o */
    private Feedlist f16696o = null;
    /* renamed from: p */
    private int f16697p = -1;

    public static final class Card extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 3;
        public static final int ICONURL_FIELD_NUMBER = 5;
        public static final int LINK_FIELD_NUMBER = 4;
        public static final int SUMMARY_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16575a;
        /* renamed from: b */
        private String f16576b = "";
        /* renamed from: c */
        private boolean f16577c;
        /* renamed from: d */
        private String f16578d = "";
        /* renamed from: e */
        private boolean f16579e;
        /* renamed from: f */
        private String f16580f = "";
        /* renamed from: g */
        private boolean f16581g;
        /* renamed from: h */
        private String f16582h = "";
        /* renamed from: i */
        private boolean f16583i;
        /* renamed from: j */
        private String f16584j = "";
        /* renamed from: k */
        private int f16585k = -1;

        public static Card parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Card().mergeFrom(codedInputStreamMicro);
        }

        public static Card parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Card) new Card().mergeFrom(bArr);
        }

        public final Card clear() {
            clearTitle();
            clearSummary();
            clearDesc();
            clearLink();
            clearIconurl();
            this.f16585k = -1;
            return this;
        }

        public Card clearDesc() {
            this.f16579e = false;
            this.f16580f = "";
            return this;
        }

        public Card clearIconurl() {
            this.f16583i = false;
            this.f16584j = "";
            return this;
        }

        public Card clearLink() {
            this.f16581g = false;
            this.f16582h = "";
            return this;
        }

        public Card clearSummary() {
            this.f16577c = false;
            this.f16578d = "";
            return this;
        }

        public Card clearTitle() {
            this.f16575a = false;
            this.f16576b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16585k < 0) {
                getSerializedSize();
            }
            return this.f16585k;
        }

        public String getDesc() {
            return this.f16580f;
        }

        public String getIconurl() {
            return this.f16584j;
        }

        public String getLink() {
            return this.f16582h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasSummary()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSummary());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDesc());
            }
            if (hasLink()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getLink());
            }
            if (hasIconurl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getIconurl());
            }
            this.f16585k = i;
            return i;
        }

        public String getSummary() {
            return this.f16578d;
        }

        public String getTitle() {
            return this.f16576b;
        }

        public boolean hasDesc() {
            return this.f16579e;
        }

        public boolean hasIconurl() {
            return this.f16583i;
        }

        public boolean hasLink() {
            return this.f16581g;
        }

        public boolean hasSummary() {
            return this.f16577c;
        }

        public boolean hasTitle() {
            return this.f16575a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Card mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSummary(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDesc(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setLink(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setIconurl(codedInputStreamMicro.readString());
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

        public Card setDesc(String str) {
            this.f16579e = true;
            this.f16580f = str;
            return this;
        }

        public Card setIconurl(String str) {
            this.f16583i = true;
            this.f16584j = str;
            return this;
        }

        public Card setLink(String str) {
            this.f16581g = true;
            this.f16582h = str;
            return this;
        }

        public Card setSummary(String str) {
            this.f16577c = true;
            this.f16578d = str;
            return this;
        }

        public Card setTitle(String str) {
            this.f16575a = true;
            this.f16576b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasSummary()) {
                codedOutputStreamMicro.writeString(2, getSummary());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(3, getDesc());
            }
            if (hasLink()) {
                codedOutputStreamMicro.writeString(4, getLink());
            }
            if (hasIconurl()) {
                codedOutputStreamMicro.writeString(5, getIconurl());
            }
        }
    }

    public static final class Feedlist extends MessageMicro {
        public static final int FEED_FIELD_NUMBER = 1;
        public static final int LOGID_FIELD_NUMBER = 2;
        public static final int MAXNUM_FIELD_NUMBER = 4;
        public static final int SSID_FIELD_NUMBER = 3;
        public static final int TITLEURL_FIELD_NUMBER = 5;
        /* renamed from: a */
        private List<Feed> f16613a = Collections.emptyList();
        /* renamed from: b */
        private boolean f16614b;
        /* renamed from: c */
        private String f16615c = "";
        /* renamed from: d */
        private boolean f16616d;
        /* renamed from: e */
        private String f16617e = "";
        /* renamed from: f */
        private boolean f16618f;
        /* renamed from: g */
        private int f16619g = 0;
        /* renamed from: h */
        private boolean f16620h;
        /* renamed from: i */
        private String f16621i = "";
        /* renamed from: j */
        private int f16622j = -1;

        public static final class Feed extends MessageMicro {
            public static final int CATE_FIELD_NUMBER = 6;
            public static final int EXT_FIELD_NUMBER = 12;
            public static final int FRM_FIELD_NUMBER = 10;
            public static final int IMGS_FIELD_NUMBER = 2;
            public static final int JURL_FIELD_NUMBER = 5;
            public static final int LOGEXTRA_FIELD_NUMBER = 9;
            public static final int MARK_FIELD_NUMBER = 13;
            public static final int NEWSATTENTION_FIELD_NUMBER = 14;
            public static final int NID_FIELD_NUMBER = 1;
            public static final int OPER_FIELD_NUMBER = 11;
            public static final int SRC_FIELD_NUMBER = 4;
            public static final int STYPE_FIELD_NUMBER = 8;
            public static final int TITLE_FIELD_NUMBER = 3;
            public static final int TS_FIELD_NUMBER = 7;
            /* renamed from: A */
            private int f16586A = -1;
            /* renamed from: a */
            private boolean f16587a;
            /* renamed from: b */
            private String f16588b = "";
            /* renamed from: c */
            private List<String> f16589c = Collections.emptyList();
            /* renamed from: d */
            private boolean f16590d;
            /* renamed from: e */
            private String f16591e = "";
            /* renamed from: f */
            private boolean f16592f;
            /* renamed from: g */
            private String f16593g = "";
            /* renamed from: h */
            private boolean f16594h;
            /* renamed from: i */
            private String f16595i = "";
            /* renamed from: j */
            private boolean f16596j;
            /* renamed from: k */
            private String f16597k = "";
            /* renamed from: l */
            private boolean f16598l;
            /* renamed from: m */
            private String f16599m = "";
            /* renamed from: n */
            private boolean f16600n;
            /* renamed from: o */
            private int f16601o = 0;
            /* renamed from: p */
            private boolean f16602p;
            /* renamed from: q */
            private String f16603q = "";
            /* renamed from: r */
            private boolean f16604r;
            /* renamed from: s */
            private int f16605s = 0;
            /* renamed from: t */
            private boolean f16606t;
            /* renamed from: u */
            private int f16607u = 0;
            /* renamed from: v */
            private boolean f16608v;
            /* renamed from: w */
            private String f16609w = "";
            /* renamed from: x */
            private boolean f16610x;
            /* renamed from: y */
            private String f16611y = "";
            /* renamed from: z */
            private List<String> f16612z = Collections.emptyList();

            public static Feed parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Feed().mergeFrom(codedInputStreamMicro);
            }

            public static Feed parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Feed) new Feed().mergeFrom(bArr);
            }

            public Feed addImgs(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f16589c.isEmpty()) {
                    this.f16589c = new ArrayList();
                }
                this.f16589c.add(str);
                return this;
            }

            public Feed addNewsAttention(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f16612z.isEmpty()) {
                    this.f16612z = new ArrayList();
                }
                this.f16612z.add(str);
                return this;
            }

            public final Feed clear() {
                clearNid();
                clearImgs();
                clearTitle();
                clearSrc();
                clearJurl();
                clearCate();
                clearTs();
                clearStype();
                clearLogextra();
                clearFrm();
                clearOper();
                clearExt();
                clearMark();
                clearNewsAttention();
                this.f16586A = -1;
                return this;
            }

            public Feed clearCate() {
                this.f16596j = false;
                this.f16597k = "";
                return this;
            }

            public Feed clearExt() {
                this.f16608v = false;
                this.f16609w = "";
                return this;
            }

            public Feed clearFrm() {
                this.f16604r = false;
                this.f16605s = 0;
                return this;
            }

            public Feed clearImgs() {
                this.f16589c = Collections.emptyList();
                return this;
            }

            public Feed clearJurl() {
                this.f16594h = false;
                this.f16595i = "";
                return this;
            }

            public Feed clearLogextra() {
                this.f16602p = false;
                this.f16603q = "";
                return this;
            }

            public Feed clearMark() {
                this.f16610x = false;
                this.f16611y = "";
                return this;
            }

            public Feed clearNewsAttention() {
                this.f16612z = Collections.emptyList();
                return this;
            }

            public Feed clearNid() {
                this.f16587a = false;
                this.f16588b = "";
                return this;
            }

            public Feed clearOper() {
                this.f16606t = false;
                this.f16607u = 0;
                return this;
            }

            public Feed clearSrc() {
                this.f16592f = false;
                this.f16593g = "";
                return this;
            }

            public Feed clearStype() {
                this.f16600n = false;
                this.f16601o = 0;
                return this;
            }

            public Feed clearTitle() {
                this.f16590d = false;
                this.f16591e = "";
                return this;
            }

            public Feed clearTs() {
                this.f16598l = false;
                this.f16599m = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f16586A < 0) {
                    getSerializedSize();
                }
                return this.f16586A;
            }

            public String getCate() {
                return this.f16597k;
            }

            public String getExt() {
                return this.f16609w;
            }

            public int getFrm() {
                return this.f16605s;
            }

            public String getImgs(int i) {
                return (String) this.f16589c.get(i);
            }

            public int getImgsCount() {
                return this.f16589c.size();
            }

            public List<String> getImgsList() {
                return this.f16589c;
            }

            public String getJurl() {
                return this.f16595i;
            }

            public String getLogextra() {
                return this.f16603q;
            }

            public String getMark() {
                return this.f16611y;
            }

            public String getNewsAttention(int i) {
                return (String) this.f16612z.get(i);
            }

            public int getNewsAttentionCount() {
                return this.f16612z.size();
            }

            public List<String> getNewsAttentionList() {
                return this.f16612z;
            }

            public String getNid() {
                return this.f16588b;
            }

            public int getOper() {
                return this.f16607u;
            }

            public int getSerializedSize() {
                int i = 0;
                int computeStringSize = hasNid() ? CodedOutputStreamMicro.computeStringSize(1, getNid()) + 0 : 0;
                int i2 = 0;
                for (String computeStringSizeNoTag : getImgsList()) {
                    i2 = CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag) + i2;
                }
                int size = (computeStringSize + i2) + (getImgsList().size() * 1);
                if (hasTitle()) {
                    size += CodedOutputStreamMicro.computeStringSize(3, getTitle());
                }
                if (hasSrc()) {
                    size += CodedOutputStreamMicro.computeStringSize(4, getSrc());
                }
                if (hasJurl()) {
                    size += CodedOutputStreamMicro.computeStringSize(5, getJurl());
                }
                if (hasCate()) {
                    size += CodedOutputStreamMicro.computeStringSize(6, getCate());
                }
                if (hasTs()) {
                    size += CodedOutputStreamMicro.computeStringSize(7, getTs());
                }
                if (hasStype()) {
                    size += CodedOutputStreamMicro.computeInt32Size(8, getStype());
                }
                if (hasLogextra()) {
                    size += CodedOutputStreamMicro.computeStringSize(9, getLogextra());
                }
                if (hasFrm()) {
                    size += CodedOutputStreamMicro.computeInt32Size(10, getFrm());
                }
                if (hasOper()) {
                    size += CodedOutputStreamMicro.computeInt32Size(11, getOper());
                }
                if (hasExt()) {
                    size += CodedOutputStreamMicro.computeStringSize(12, getExt());
                }
                computeStringSize = hasMark() ? size + CodedOutputStreamMicro.computeStringSize(13, getMark()) : size;
                for (String computeStringSizeNoTag2 : getNewsAttentionList()) {
                    i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag2);
                }
                size = (computeStringSize + i) + (getNewsAttentionList().size() * 1);
                this.f16586A = size;
                return size;
            }

            public String getSrc() {
                return this.f16593g;
            }

            public int getStype() {
                return this.f16601o;
            }

            public String getTitle() {
                return this.f16591e;
            }

            public String getTs() {
                return this.f16599m;
            }

            public boolean hasCate() {
                return this.f16596j;
            }

            public boolean hasExt() {
                return this.f16608v;
            }

            public boolean hasFrm() {
                return this.f16604r;
            }

            public boolean hasJurl() {
                return this.f16594h;
            }

            public boolean hasLogextra() {
                return this.f16602p;
            }

            public boolean hasMark() {
                return this.f16610x;
            }

            public boolean hasNid() {
                return this.f16587a;
            }

            public boolean hasOper() {
                return this.f16606t;
            }

            public boolean hasSrc() {
                return this.f16592f;
            }

            public boolean hasStype() {
                return this.f16600n;
            }

            public boolean hasTitle() {
                return this.f16590d;
            }

            public boolean hasTs() {
                return this.f16598l;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Feed mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setNid(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            addImgs(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setSrc(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setJurl(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setCate(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setTs(codedInputStreamMicro.readString());
                            continue;
                        case 64:
                            setStype(codedInputStreamMicro.readInt32());
                            continue;
                        case 74:
                            setLogextra(codedInputStreamMicro.readString());
                            continue;
                        case 80:
                            setFrm(codedInputStreamMicro.readInt32());
                            continue;
                        case 88:
                            setOper(codedInputStreamMicro.readInt32());
                            continue;
                        case 98:
                            setExt(codedInputStreamMicro.readString());
                            continue;
                        case 106:
                            setMark(codedInputStreamMicro.readString());
                            continue;
                        case 114:
                            addNewsAttention(codedInputStreamMicro.readString());
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

            public Feed setCate(String str) {
                this.f16596j = true;
                this.f16597k = str;
                return this;
            }

            public Feed setExt(String str) {
                this.f16608v = true;
                this.f16609w = str;
                return this;
            }

            public Feed setFrm(int i) {
                this.f16604r = true;
                this.f16605s = i;
                return this;
            }

            public Feed setImgs(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f16589c.set(i, str);
                return this;
            }

            public Feed setJurl(String str) {
                this.f16594h = true;
                this.f16595i = str;
                return this;
            }

            public Feed setLogextra(String str) {
                this.f16602p = true;
                this.f16603q = str;
                return this;
            }

            public Feed setMark(String str) {
                this.f16610x = true;
                this.f16611y = str;
                return this;
            }

            public Feed setNewsAttention(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f16612z.set(i, str);
                return this;
            }

            public Feed setNid(String str) {
                this.f16587a = true;
                this.f16588b = str;
                return this;
            }

            public Feed setOper(int i) {
                this.f16606t = true;
                this.f16607u = i;
                return this;
            }

            public Feed setSrc(String str) {
                this.f16592f = true;
                this.f16593g = str;
                return this;
            }

            public Feed setStype(int i) {
                this.f16600n = true;
                this.f16601o = i;
                return this;
            }

            public Feed setTitle(String str) {
                this.f16590d = true;
                this.f16591e = str;
                return this;
            }

            public Feed setTs(String str) {
                this.f16598l = true;
                this.f16599m = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasNid()) {
                    codedOutputStreamMicro.writeString(1, getNid());
                }
                for (String writeString : getImgsList()) {
                    codedOutputStreamMicro.writeString(2, writeString);
                }
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(3, getTitle());
                }
                if (hasSrc()) {
                    codedOutputStreamMicro.writeString(4, getSrc());
                }
                if (hasJurl()) {
                    codedOutputStreamMicro.writeString(5, getJurl());
                }
                if (hasCate()) {
                    codedOutputStreamMicro.writeString(6, getCate());
                }
                if (hasTs()) {
                    codedOutputStreamMicro.writeString(7, getTs());
                }
                if (hasStype()) {
                    codedOutputStreamMicro.writeInt32(8, getStype());
                }
                if (hasLogextra()) {
                    codedOutputStreamMicro.writeString(9, getLogextra());
                }
                if (hasFrm()) {
                    codedOutputStreamMicro.writeInt32(10, getFrm());
                }
                if (hasOper()) {
                    codedOutputStreamMicro.writeInt32(11, getOper());
                }
                if (hasExt()) {
                    codedOutputStreamMicro.writeString(12, getExt());
                }
                if (hasMark()) {
                    codedOutputStreamMicro.writeString(13, getMark());
                }
                for (String writeString2 : getNewsAttentionList()) {
                    codedOutputStreamMicro.writeString(14, writeString2);
                }
            }
        }

        public static Feedlist parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Feedlist().mergeFrom(codedInputStreamMicro);
        }

        public static Feedlist parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Feedlist) new Feedlist().mergeFrom(bArr);
        }

        public Feedlist addFeed(Feed feed) {
            if (feed != null) {
                if (this.f16613a.isEmpty()) {
                    this.f16613a = new ArrayList();
                }
                this.f16613a.add(feed);
            }
            return this;
        }

        public final Feedlist clear() {
            clearFeed();
            clearLogid();
            clearSsid();
            clearMaxnum();
            clearTitleurl();
            this.f16622j = -1;
            return this;
        }

        public Feedlist clearFeed() {
            this.f16613a = Collections.emptyList();
            return this;
        }

        public Feedlist clearLogid() {
            this.f16614b = false;
            this.f16615c = "";
            return this;
        }

        public Feedlist clearMaxnum() {
            this.f16618f = false;
            this.f16619g = 0;
            return this;
        }

        public Feedlist clearSsid() {
            this.f16616d = false;
            this.f16617e = "";
            return this;
        }

        public Feedlist clearTitleurl() {
            this.f16620h = false;
            this.f16621i = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16622j < 0) {
                getSerializedSize();
            }
            return this.f16622j;
        }

        public Feed getFeed(int i) {
            return (Feed) this.f16613a.get(i);
        }

        public int getFeedCount() {
            return this.f16613a.size();
        }

        public List<Feed> getFeedList() {
            return this.f16613a;
        }

        public String getLogid() {
            return this.f16615c;
        }

        public int getMaxnum() {
            return this.f16619g;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Feed computeMessageSize : getFeedList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasLogid()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLogid());
            }
            if (hasSsid()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getSsid());
            }
            if (hasMaxnum()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getMaxnum());
            }
            if (hasTitleurl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getTitleurl());
            }
            this.f16622j = i;
            return i;
        }

        public String getSsid() {
            return this.f16617e;
        }

        public String getTitleurl() {
            return this.f16621i;
        }

        public boolean hasLogid() {
            return this.f16614b;
        }

        public boolean hasMaxnum() {
            return this.f16618f;
        }

        public boolean hasSsid() {
            return this.f16616d;
        }

        public boolean hasTitleurl() {
            return this.f16620h;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Feedlist mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro feed = new Feed();
                        codedInputStreamMicro.readMessage(feed);
                        addFeed(feed);
                        continue;
                    case 18:
                        setLogid(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setSsid(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setMaxnum(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setTitleurl(codedInputStreamMicro.readString());
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

        public Feedlist setFeed(int i, Feed feed) {
            if (feed != null) {
                this.f16613a.set(i, feed);
            }
            return this;
        }

        public Feedlist setLogid(String str) {
            this.f16614b = true;
            this.f16615c = str;
            return this;
        }

        public Feedlist setMaxnum(int i) {
            this.f16618f = true;
            this.f16619g = i;
            return this;
        }

        public Feedlist setSsid(String str) {
            this.f16616d = true;
            this.f16617e = str;
            return this;
        }

        public Feedlist setTitleurl(String str) {
            this.f16620h = true;
            this.f16621i = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Feed writeMessage : getFeedList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasLogid()) {
                codedOutputStreamMicro.writeString(2, getLogid());
            }
            if (hasSsid()) {
                codedOutputStreamMicro.writeString(3, getSsid());
            }
            if (hasMaxnum()) {
                codedOutputStreamMicro.writeInt32(4, getMaxnum());
            }
            if (hasTitleurl()) {
                codedOutputStreamMicro.writeString(5, getTitleurl());
            }
        }
    }

    public static final class Header extends MessageMicro {
        public static final int TIME_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16623a;
        /* renamed from: b */
        private String f16624b = "";
        /* renamed from: c */
        private boolean f16625c;
        /* renamed from: d */
        private String f16626d = "";
        /* renamed from: e */
        private int f16627e = -1;

        public static Header parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Header().mergeFrom(codedInputStreamMicro);
        }

        public static Header parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Header) new Header().mergeFrom(bArr);
        }

        public final Header clear() {
            clearTitle();
            clearTime();
            this.f16627e = -1;
            return this;
        }

        public Header clearTime() {
            this.f16625c = false;
            this.f16626d = "";
            return this;
        }

        public Header clearTitle() {
            this.f16623a = false;
            this.f16624b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16627e < 0) {
                getSerializedSize();
            }
            return this.f16627e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasTime()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTime());
            }
            this.f16627e = i;
            return i;
        }

        public String getTime() {
            return this.f16626d;
        }

        public String getTitle() {
            return this.f16624b;
        }

        public boolean hasTime() {
            return this.f16625c;
        }

        public boolean hasTitle() {
            return this.f16623a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Header mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTime(codedInputStreamMicro.readString());
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

        public Header setTime(String str) {
            this.f16625c = true;
            this.f16626d = str;
            return this;
        }

        public Header setTitle(String str) {
            this.f16623a = true;
            this.f16624b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasTime()) {
                codedOutputStreamMicro.writeString(2, getTime());
            }
        }
    }

    public static final class Infomation extends MessageMicro {
        public static final int INFOS_FIELD_NUMBER = 1;
        public static final int TITLEURL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<Info> f16635a = Collections.emptyList();
        /* renamed from: b */
        private boolean f16636b;
        /* renamed from: c */
        private String f16637c = "";
        /* renamed from: d */
        private int f16638d = -1;

        public static final class Info extends MessageMicro {
            public static final int DETAIL_FIELD_NUMBER = 3;
            public static final int TITLE_FIELD_NUMBER = 1;
            public static final int UPDATE_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f16628a;
            /* renamed from: b */
            private String f16629b = "";
            /* renamed from: c */
            private boolean f16630c;
            /* renamed from: d */
            private String f16631d = "";
            /* renamed from: e */
            private boolean f16632e;
            /* renamed from: f */
            private String f16633f = "";
            /* renamed from: g */
            private int f16634g = -1;

            public static Info parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Info().mergeFrom(codedInputStreamMicro);
            }

            public static Info parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Info) new Info().mergeFrom(bArr);
            }

            public final Info clear() {
                clearTitle();
                clearUpdate();
                clearDetail();
                this.f16634g = -1;
                return this;
            }

            public Info clearDetail() {
                this.f16632e = false;
                this.f16633f = "";
                return this;
            }

            public Info clearTitle() {
                this.f16628a = false;
                this.f16629b = "";
                return this;
            }

            public Info clearUpdate() {
                this.f16630c = false;
                this.f16631d = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f16634g < 0) {
                    getSerializedSize();
                }
                return this.f16634g;
            }

            public String getDetail() {
                return this.f16633f;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTitle()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                }
                if (hasUpdate()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getUpdate());
                }
                if (hasDetail()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getDetail());
                }
                this.f16634g = i;
                return i;
            }

            public String getTitle() {
                return this.f16629b;
            }

            public String getUpdate() {
                return this.f16631d;
            }

            public boolean hasDetail() {
                return this.f16632e;
            }

            public boolean hasTitle() {
                return this.f16628a;
            }

            public boolean hasUpdate() {
                return this.f16630c;
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
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setUpdate(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setDetail(codedInputStreamMicro.readString());
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

            public Info setDetail(String str) {
                this.f16632e = true;
                this.f16633f = str;
                return this;
            }

            public Info setTitle(String str) {
                this.f16628a = true;
                this.f16629b = str;
                return this;
            }

            public Info setUpdate(String str) {
                this.f16630c = true;
                this.f16631d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasUpdate()) {
                    codedOutputStreamMicro.writeString(2, getUpdate());
                }
                if (hasDetail()) {
                    codedOutputStreamMicro.writeString(3, getDetail());
                }
            }
        }

        public static Infomation parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Infomation().mergeFrom(codedInputStreamMicro);
        }

        public static Infomation parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Infomation) new Infomation().mergeFrom(bArr);
        }

        public Infomation addInfos(Info info) {
            if (info != null) {
                if (this.f16635a.isEmpty()) {
                    this.f16635a = new ArrayList();
                }
                this.f16635a.add(info);
            }
            return this;
        }

        public final Infomation clear() {
            clearInfos();
            clearTitleurl();
            this.f16638d = -1;
            return this;
        }

        public Infomation clearInfos() {
            this.f16635a = Collections.emptyList();
            return this;
        }

        public Infomation clearTitleurl() {
            this.f16636b = false;
            this.f16637c = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16638d < 0) {
                getSerializedSize();
            }
            return this.f16638d;
        }

        public Info getInfos(int i) {
            return (Info) this.f16635a.get(i);
        }

        public int getInfosCount() {
            return this.f16635a.size();
        }

        public List<Info> getInfosList() {
            return this.f16635a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (Info computeMessageSize : getInfosList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasTitleurl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitleurl());
            }
            this.f16638d = i;
            return i;
        }

        public String getTitleurl() {
            return this.f16637c;
        }

        public boolean hasTitleurl() {
            return this.f16636b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Infomation mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro info = new Info();
                        codedInputStreamMicro.readMessage(info);
                        addInfos(info);
                        continue;
                    case 18:
                        setTitleurl(codedInputStreamMicro.readString());
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

        public Infomation setInfos(int i, Info info) {
            if (info != null) {
                this.f16635a.set(i, info);
            }
            return this;
        }

        public Infomation setTitleurl(String str) {
            this.f16636b = true;
            this.f16637c = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (Info writeMessage : getInfosList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasTitleurl()) {
                codedOutputStreamMicro.writeString(2, getTitleurl());
            }
        }
    }

    public static final class Nonlocal extends MessageMicro {
        public static final int CITYID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f16639a;
        /* renamed from: b */
        private int f16640b = 0;
        /* renamed from: c */
        private boolean f16641c;
        /* renamed from: d */
        private String f16642d = "";
        /* renamed from: e */
        private int f16643e = -1;

        public static Nonlocal parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Nonlocal().mergeFrom(codedInputStreamMicro);
        }

        public static Nonlocal parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Nonlocal) new Nonlocal().mergeFrom(bArr);
        }

        public final Nonlocal clear() {
            clearCityid();
            clearName();
            this.f16643e = -1;
            return this;
        }

        public Nonlocal clearCityid() {
            this.f16639a = false;
            this.f16640b = 0;
            return this;
        }

        public Nonlocal clearName() {
            this.f16641c = false;
            this.f16642d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16643e < 0) {
                getSerializedSize();
            }
            return this.f16643e;
        }

        public int getCityid() {
            return this.f16640b;
        }

        public String getName() {
            return this.f16642d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCityid()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCityid());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            this.f16643e = i;
            return i;
        }

        public boolean hasCityid() {
            return this.f16639a;
        }

        public boolean hasName() {
            return this.f16641c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Nonlocal mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setCityid(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
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

        public Nonlocal setCityid(int i) {
            this.f16639a = true;
            this.f16640b = i;
            return this;
        }

        public Nonlocal setName(String str) {
            this.f16641c = true;
            this.f16642d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCityid()) {
                codedOutputStreamMicro.writeInt32(1, getCityid());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
        }
    }

    public static final class Route extends MessageMicro {
        public static final int LINK_FIELD_NUMBER = 4;
        public static final int LOCATION_FIELD_NUMBER = 2;
        public static final int LOCTEXT_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int OBODETEXT_FIELD_NUMBER = 5;
        public static final int TAG_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16656a;
        /* renamed from: b */
        private int f16657b = 0;
        /* renamed from: c */
        private boolean f16658c;
        /* renamed from: d */
        private Location f16659d = null;
        /* renamed from: e */
        private boolean f16660e;
        /* renamed from: f */
        private String f16661f = "";
        /* renamed from: g */
        private boolean f16662g;
        /* renamed from: h */
        private String f16663h = "";
        /* renamed from: i */
        private boolean f16664i;
        /* renamed from: j */
        private String f16665j = "";
        /* renamed from: k */
        private boolean f16666k;
        /* renamed from: l */
        private String f16667l = "";
        /* renamed from: m */
        private int f16668m = -1;

        public static final class Location extends MessageMicro {
            public static final int COMPANY_FIELD_NUMBER = 2;
            public static final int HOME_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f16651a;
            /* renamed from: b */
            private Point f16652b = null;
            /* renamed from: c */
            private boolean f16653c;
            /* renamed from: d */
            private Point f16654d = null;
            /* renamed from: e */
            private int f16655e = -1;

            public static final class Point extends MessageMicro {
                public static final int LAT_FIELD_NUMBER = 1;
                public static final int LNG_FIELD_NUMBER = 2;
                public static final int NAME_FIELD_NUMBER = 3;
                /* renamed from: a */
                private boolean f16644a;
                /* renamed from: b */
                private int f16645b = 0;
                /* renamed from: c */
                private boolean f16646c;
                /* renamed from: d */
                private int f16647d = 0;
                /* renamed from: e */
                private boolean f16648e;
                /* renamed from: f */
                private String f16649f = "";
                /* renamed from: g */
                private int f16650g = -1;

                public static Point parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Point().mergeFrom(codedInputStreamMicro);
                }

                public static Point parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Point) new Point().mergeFrom(bArr);
                }

                public final Point clear() {
                    clearLat();
                    clearLng();
                    clearName();
                    this.f16650g = -1;
                    return this;
                }

                public Point clearLat() {
                    this.f16644a = false;
                    this.f16645b = 0;
                    return this;
                }

                public Point clearLng() {
                    this.f16646c = false;
                    this.f16647d = 0;
                    return this;
                }

                public Point clearName() {
                    this.f16648e = false;
                    this.f16649f = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f16650g < 0) {
                        getSerializedSize();
                    }
                    return this.f16650g;
                }

                public int getLat() {
                    return this.f16645b;
                }

                public int getLng() {
                    return this.f16647d;
                }

                public String getName() {
                    return this.f16649f;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasLat()) {
                        i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getLat());
                    }
                    if (hasLng()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getLng());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getName());
                    }
                    this.f16650g = i;
                    return i;
                }

                public boolean hasLat() {
                    return this.f16644a;
                }

                public boolean hasLng() {
                    return this.f16646c;
                }

                public boolean hasName() {
                    return this.f16648e;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Point mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                setLat(codedInputStreamMicro.readInt32());
                                continue;
                            case 16:
                                setLng(codedInputStreamMicro.readInt32());
                                continue;
                            case 26:
                                setName(codedInputStreamMicro.readString());
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

                public Point setLat(int i) {
                    this.f16644a = true;
                    this.f16645b = i;
                    return this;
                }

                public Point setLng(int i) {
                    this.f16646c = true;
                    this.f16647d = i;
                    return this;
                }

                public Point setName(String str) {
                    this.f16648e = true;
                    this.f16649f = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasLat()) {
                        codedOutputStreamMicro.writeInt32(1, getLat());
                    }
                    if (hasLng()) {
                        codedOutputStreamMicro.writeInt32(2, getLng());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(3, getName());
                    }
                }
            }

            public static Location parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Location().mergeFrom(codedInputStreamMicro);
            }

            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Location) new Location().mergeFrom(bArr);
            }

            public final Location clear() {
                clearHome();
                clearCompany();
                this.f16655e = -1;
                return this;
            }

            public Location clearCompany() {
                this.f16653c = false;
                this.f16654d = null;
                return this;
            }

            public Location clearHome() {
                this.f16651a = false;
                this.f16652b = null;
                return this;
            }

            public int getCachedSize() {
                if (this.f16655e < 0) {
                    getSerializedSize();
                }
                return this.f16655e;
            }

            public Point getCompany() {
                return this.f16654d;
            }

            public Point getHome() {
                return this.f16652b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasHome()) {
                    i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHome());
                }
                if (hasCompany()) {
                    i += CodedOutputStreamMicro.computeMessageSize(2, getCompany());
                }
                this.f16655e = i;
                return i;
            }

            public boolean hasCompany() {
                return this.f16653c;
            }

            public boolean hasHome() {
                return this.f16651a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Location mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro point;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setHome(point);
                            continue;
                        case 18:
                            point = new Point();
                            codedInputStreamMicro.readMessage(point);
                            setCompany(point);
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

            public Location setCompany(Point point) {
                if (point == null) {
                    return clearCompany();
                }
                this.f16653c = true;
                this.f16654d = point;
                return this;
            }

            public Location setHome(Point point) {
                if (point == null) {
                    return clearHome();
                }
                this.f16651a = true;
                this.f16652b = point;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasHome()) {
                    codedOutputStreamMicro.writeMessage(1, getHome());
                }
                if (hasCompany()) {
                    codedOutputStreamMicro.writeMessage(2, getCompany());
                }
            }
        }

        public static Route parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Route().mergeFrom(codedInputStreamMicro);
        }

        public static Route parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Route) new Route().mergeFrom(bArr);
        }

        public final Route clear() {
            clearTag();
            clearLocation();
            clearName();
            clearLink();
            clearObodetext();
            clearLoctext();
            this.f16668m = -1;
            return this;
        }

        public Route clearLink() {
            this.f16662g = false;
            this.f16663h = "";
            return this;
        }

        public Route clearLocation() {
            this.f16658c = false;
            this.f16659d = null;
            return this;
        }

        public Route clearLoctext() {
            this.f16666k = false;
            this.f16667l = "";
            return this;
        }

        public Route clearName() {
            this.f16660e = false;
            this.f16661f = "";
            return this;
        }

        public Route clearObodetext() {
            this.f16664i = false;
            this.f16665j = "";
            return this;
        }

        public Route clearTag() {
            this.f16656a = false;
            this.f16657b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f16668m < 0) {
                getSerializedSize();
            }
            return this.f16668m;
        }

        public String getLink() {
            return this.f16663h;
        }

        public Location getLocation() {
            return this.f16659d;
        }

        public String getLoctext() {
            return this.f16667l;
        }

        public String getName() {
            return this.f16661f;
        }

        public String getObodetext() {
            return this.f16665j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTag()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTag());
            }
            if (hasLocation()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getLocation());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getName());
            }
            if (hasLink()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getLink());
            }
            if (hasObodetext()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getObodetext());
            }
            if (hasLoctext()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getLoctext());
            }
            this.f16668m = i;
            return i;
        }

        public int getTag() {
            return this.f16657b;
        }

        public boolean hasLink() {
            return this.f16662g;
        }

        public boolean hasLocation() {
            return this.f16658c;
        }

        public boolean hasLoctext() {
            return this.f16666k;
        }

        public boolean hasName() {
            return this.f16660e;
        }

        public boolean hasObodetext() {
            return this.f16664i;
        }

        public boolean hasTag() {
            return this.f16656a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Route mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setTag(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        MessageMicro location = new Location();
                        codedInputStreamMicro.readMessage(location);
                        setLocation(location);
                        continue;
                    case 26:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setLink(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setObodetext(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setLoctext(codedInputStreamMicro.readString());
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

        public Route setLink(String str) {
            this.f16662g = true;
            this.f16663h = str;
            return this;
        }

        public Route setLocation(Location location) {
            if (location == null) {
                return clearLocation();
            }
            this.f16658c = true;
            this.f16659d = location;
            return this;
        }

        public Route setLoctext(String str) {
            this.f16666k = true;
            this.f16667l = str;
            return this;
        }

        public Route setName(String str) {
            this.f16660e = true;
            this.f16661f = str;
            return this;
        }

        public Route setObodetext(String str) {
            this.f16664i = true;
            this.f16665j = str;
            return this;
        }

        public Route setTag(int i) {
            this.f16656a = true;
            this.f16657b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTag()) {
                codedOutputStreamMicro.writeInt32(1, getTag());
            }
            if (hasLocation()) {
                codedOutputStreamMicro.writeMessage(2, getLocation());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(3, getName());
            }
            if (hasLink()) {
                codedOutputStreamMicro.writeString(4, getLink());
            }
            if (hasObodetext()) {
                codedOutputStreamMicro.writeString(5, getObodetext());
            }
            if (hasLoctext()) {
                codedOutputStreamMicro.writeString(6, getLoctext());
            }
        }
    }

    public static final class Share extends MessageMicro {
        public static final int BIGICON_FIELD_NUMBER = 6;
        public static final int LONGCONTENT_FIELD_NUMBER = 4;
        public static final int SHORTCONTENT_FIELD_NUMBER = 3;
        public static final int SMALLICON_FIELD_NUMBER = 5;
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16669a;
        /* renamed from: b */
        private String f16670b = "";
        /* renamed from: c */
        private boolean f16671c;
        /* renamed from: d */
        private String f16672d = "";
        /* renamed from: e */
        private boolean f16673e;
        /* renamed from: f */
        private String f16674f = "";
        /* renamed from: g */
        private boolean f16675g;
        /* renamed from: h */
        private String f16676h = "";
        /* renamed from: i */
        private boolean f16677i;
        /* renamed from: j */
        private String f16678j = "";
        /* renamed from: k */
        private boolean f16679k;
        /* renamed from: l */
        private String f16680l = "";
        /* renamed from: m */
        private int f16681m = -1;

        public static Share parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Share().mergeFrom(codedInputStreamMicro);
        }

        public static Share parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Share) new Share().mergeFrom(bArr);
        }

        public final Share clear() {
            clearUrl();
            clearTitle();
            clearShortcontent();
            clearLongcontent();
            clearSmallicon();
            clearBigicon();
            this.f16681m = -1;
            return this;
        }

        public Share clearBigicon() {
            this.f16679k = false;
            this.f16680l = "";
            return this;
        }

        public Share clearLongcontent() {
            this.f16675g = false;
            this.f16676h = "";
            return this;
        }

        public Share clearShortcontent() {
            this.f16673e = false;
            this.f16674f = "";
            return this;
        }

        public Share clearSmallicon() {
            this.f16677i = false;
            this.f16678j = "";
            return this;
        }

        public Share clearTitle() {
            this.f16671c = false;
            this.f16672d = "";
            return this;
        }

        public Share clearUrl() {
            this.f16669a = false;
            this.f16670b = "";
            return this;
        }

        public String getBigicon() {
            return this.f16680l;
        }

        public int getCachedSize() {
            if (this.f16681m < 0) {
                getSerializedSize();
            }
            return this.f16681m;
        }

        public String getLongcontent() {
            return this.f16676h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUrl()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasShortcontent()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getShortcontent());
            }
            if (hasLongcontent()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getLongcontent());
            }
            if (hasSmallicon()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getSmallicon());
            }
            if (hasBigicon()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getBigicon());
            }
            this.f16681m = i;
            return i;
        }

        public String getShortcontent() {
            return this.f16674f;
        }

        public String getSmallicon() {
            return this.f16678j;
        }

        public String getTitle() {
            return this.f16672d;
        }

        public String getUrl() {
            return this.f16670b;
        }

        public boolean hasBigicon() {
            return this.f16679k;
        }

        public boolean hasLongcontent() {
            return this.f16675g;
        }

        public boolean hasShortcontent() {
            return this.f16673e;
        }

        public boolean hasSmallicon() {
            return this.f16677i;
        }

        public boolean hasTitle() {
            return this.f16671c;
        }

        public boolean hasUrl() {
            return this.f16669a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Share mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUrl(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setShortcontent(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setLongcontent(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setSmallicon(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setBigicon(codedInputStreamMicro.readString());
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

        public Share setBigicon(String str) {
            this.f16679k = true;
            this.f16680l = str;
            return this;
        }

        public Share setLongcontent(String str) {
            this.f16675g = true;
            this.f16676h = str;
            return this;
        }

        public Share setShortcontent(String str) {
            this.f16673e = true;
            this.f16674f = str;
            return this;
        }

        public Share setSmallicon(String str) {
            this.f16677i = true;
            this.f16678j = str;
            return this;
        }

        public Share setTitle(String str) {
            this.f16671c = true;
            this.f16672d = str;
            return this;
        }

        public Share setUrl(String str) {
            this.f16669a = true;
            this.f16670b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(1, getUrl());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasShortcontent()) {
                codedOutputStreamMicro.writeString(3, getShortcontent());
            }
            if (hasLongcontent()) {
                codedOutputStreamMicro.writeString(4, getLongcontent());
            }
            if (hasSmallicon()) {
                codedOutputStreamMicro.writeString(5, getSmallicon());
            }
            if (hasBigicon()) {
                codedOutputStreamMicro.writeString(6, getBigicon());
            }
        }
    }

    public static Travel parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Travel().mergeFrom(codedInputStreamMicro);
    }

    public static Travel parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Travel) new Travel().mergeFrom(bArr);
    }

    public Travel addCard(Card card) {
        if (card != null) {
            if (this.f16684c.isEmpty()) {
                this.f16684c = new ArrayList();
            }
            this.f16684c.add(card);
        }
        return this;
    }

    public final Travel clear() {
        clearHeader();
        clearCard();
        clearRoute();
        clearInfo();
        clearNonlocal();
        clearImgurl();
        clearShare();
        clearFeedlist();
        this.f16697p = -1;
        return this;
    }

    public Travel clearCard() {
        this.f16684c = Collections.emptyList();
        return this;
    }

    public Travel clearFeedlist() {
        this.f16695n = false;
        this.f16696o = null;
        return this;
    }

    public Travel clearHeader() {
        this.f16682a = false;
        this.f16683b = null;
        return this;
    }

    public Travel clearImgurl() {
        this.f16691j = false;
        this.f16692k = "";
        return this;
    }

    public Travel clearInfo() {
        this.f16687f = false;
        this.f16688g = null;
        return this;
    }

    public Travel clearNonlocal() {
        this.f16689h = false;
        this.f16690i = null;
        return this;
    }

    public Travel clearRoute() {
        this.f16685d = false;
        this.f16686e = null;
        return this;
    }

    public Travel clearShare() {
        this.f16693l = false;
        this.f16694m = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f16697p < 0) {
            getSerializedSize();
        }
        return this.f16697p;
    }

    public Card getCard(int i) {
        return (Card) this.f16684c.get(i);
    }

    public int getCardCount() {
        return this.f16684c.size();
    }

    public List<Card> getCardList() {
        return this.f16684c;
    }

    public Feedlist getFeedlist() {
        return this.f16696o;
    }

    public Header getHeader() {
        return this.f16683b;
    }

    public String getImgurl() {
        return this.f16692k;
    }

    public Infomation getInfo() {
        return this.f16688g;
    }

    public Nonlocal getNonlocal() {
        return this.f16690i;
    }

    public Route getRoute() {
        return this.f16686e;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasHeader()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHeader());
        }
        int i2 = i;
        for (Card computeMessageSize : getCardList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
        }
        if (hasRoute()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(3, getRoute());
        }
        if (hasInfo()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(4, getInfo());
        }
        if (hasNonlocal()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(5, getNonlocal());
        }
        if (hasImgurl()) {
            i2 += CodedOutputStreamMicro.computeStringSize(6, getImgurl());
        }
        if (hasShare()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(7, getShare());
        }
        if (hasFeedlist()) {
            i2 += CodedOutputStreamMicro.computeMessageSize(8, getFeedlist());
        }
        this.f16697p = i2;
        return i2;
    }

    public Share getShare() {
        return this.f16694m;
    }

    public boolean hasFeedlist() {
        return this.f16695n;
    }

    public boolean hasHeader() {
        return this.f16682a;
    }

    public boolean hasImgurl() {
        return this.f16691j;
    }

    public boolean hasInfo() {
        return this.f16687f;
    }

    public boolean hasNonlocal() {
        return this.f16689h;
    }

    public boolean hasRoute() {
        return this.f16685d;
    }

    public boolean hasShare() {
        return this.f16693l;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Travel mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro header;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    header = new Header();
                    codedInputStreamMicro.readMessage(header);
                    setHeader(header);
                    continue;
                case 18:
                    header = new Card();
                    codedInputStreamMicro.readMessage(header);
                    addCard(header);
                    continue;
                case 26:
                    header = new Route();
                    codedInputStreamMicro.readMessage(header);
                    setRoute(header);
                    continue;
                case 34:
                    header = new Infomation();
                    codedInputStreamMicro.readMessage(header);
                    setInfo(header);
                    continue;
                case 42:
                    header = new Nonlocal();
                    codedInputStreamMicro.readMessage(header);
                    setNonlocal(header);
                    continue;
                case 50:
                    setImgurl(codedInputStreamMicro.readString());
                    continue;
                case 58:
                    header = new Share();
                    codedInputStreamMicro.readMessage(header);
                    setShare(header);
                    continue;
                case 66:
                    header = new Feedlist();
                    codedInputStreamMicro.readMessage(header);
                    setFeedlist(header);
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

    public Travel setCard(int i, Card card) {
        if (card != null) {
            this.f16684c.set(i, card);
        }
        return this;
    }

    public Travel setFeedlist(Feedlist feedlist) {
        if (feedlist == null) {
            return clearFeedlist();
        }
        this.f16695n = true;
        this.f16696o = feedlist;
        return this;
    }

    public Travel setHeader(Header header) {
        if (header == null) {
            return clearHeader();
        }
        this.f16682a = true;
        this.f16683b = header;
        return this;
    }

    public Travel setImgurl(String str) {
        this.f16691j = true;
        this.f16692k = str;
        return this;
    }

    public Travel setInfo(Infomation infomation) {
        if (infomation == null) {
            return clearInfo();
        }
        this.f16687f = true;
        this.f16688g = infomation;
        return this;
    }

    public Travel setNonlocal(Nonlocal nonlocal) {
        if (nonlocal == null) {
            return clearNonlocal();
        }
        this.f16689h = true;
        this.f16690i = nonlocal;
        return this;
    }

    public Travel setRoute(Route route) {
        if (route == null) {
            return clearRoute();
        }
        this.f16685d = true;
        this.f16686e = route;
        return this;
    }

    public Travel setShare(Share share) {
        if (share == null) {
            return clearShare();
        }
        this.f16693l = true;
        this.f16694m = share;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasHeader()) {
            codedOutputStreamMicro.writeMessage(1, getHeader());
        }
        for (Card writeMessage : getCardList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage);
        }
        if (hasRoute()) {
            codedOutputStreamMicro.writeMessage(3, getRoute());
        }
        if (hasInfo()) {
            codedOutputStreamMicro.writeMessage(4, getInfo());
        }
        if (hasNonlocal()) {
            codedOutputStreamMicro.writeMessage(5, getNonlocal());
        }
        if (hasImgurl()) {
            codedOutputStreamMicro.writeString(6, getImgurl());
        }
        if (hasShare()) {
            codedOutputStreamMicro.writeMessage(7, getShare());
        }
        if (hasFeedlist()) {
            codedOutputStreamMicro.writeMessage(8, getFeedlist());
        }
    }
}
