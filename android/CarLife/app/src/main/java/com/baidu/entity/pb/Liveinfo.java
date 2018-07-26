package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Liveinfo extends MessageMicro {
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f12054a;
    /* renamed from: b */
    private int f12055b = 0;
    /* renamed from: c */
    private boolean f12056c;
    /* renamed from: d */
    private String f12057d = "";
    /* renamed from: e */
    private boolean f12058e;
    /* renamed from: f */
    private Data f12059f = null;
    /* renamed from: g */
    private int f12060g = -1;

    public static final class Data extends MessageMicro {
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int HEADER_FIELD_NUMBER = 1;
        public static final int INTERVAL_FIELD_NUMBER = 5;
        public static final int NUM_FIELD_NUMBER = 4;
        public static final int STAMP_FIELD_NUMBER = 3;
        public static final int STICK_FIELD_NUMBER = 6;
        /* renamed from: a */
        private boolean f12043a;
        /* renamed from: b */
        private Header f12044b = null;
        /* renamed from: c */
        private List<Content> f12045c = Collections.emptyList();
        /* renamed from: d */
        private boolean f12046d;
        /* renamed from: e */
        private String f12047e = "";
        /* renamed from: f */
        private boolean f12048f;
        /* renamed from: g */
        private String f12049g = "";
        /* renamed from: h */
        private boolean f12050h;
        /* renamed from: i */
        private String f12051i = "";
        /* renamed from: j */
        private List<Content> f12052j = Collections.emptyList();
        /* renamed from: k */
        private int f12053k = -1;

        public static final class Content extends MessageMicro {
            public static final int AUDIO_FIELD_NUMBER = 12;
            public static final int AUTHEN_FIELD_NUMBER = 14;
            public static final int DESC_FIELD_NUMBER = 7;
            public static final int ID_FIELD_NUMBER = 1;
            public static final int IMGS_FIELD_NUMBER = 8;
            public static final int LINK_FIELD_NUMBER = 9;
            public static final int LOC_FIELD_NUMBER = 10;
            public static final int LOGO_FIELD_NUMBER = 3;
            public static final int NAME_FIELD_NUMBER = 5;
            public static final int QUOTE_FIELD_NUMBER = 13;
            public static final int ROLE_FIELD_NUMBER = 4;
            public static final int TAG_FIELD_NUMBER = 11;
            public static final int TIME_FIELD_NUMBER = 6;
            public static final int UID_FIELD_NUMBER = 2;
            public static final int VIDEO_FIELD_NUMBER = 15;
            /* renamed from: A */
            private boolean f11995A;
            /* renamed from: B */
            private Video f11996B = null;
            /* renamed from: C */
            private int f11997C = -1;
            /* renamed from: a */
            private boolean f11998a;
            /* renamed from: b */
            private String f11999b = "";
            /* renamed from: c */
            private boolean f12000c;
            /* renamed from: d */
            private String f12001d = "";
            /* renamed from: e */
            private boolean f12002e;
            /* renamed from: f */
            private String f12003f = "";
            /* renamed from: g */
            private boolean f12004g;
            /* renamed from: h */
            private String f12005h = "";
            /* renamed from: i */
            private boolean f12006i;
            /* renamed from: j */
            private String f12007j = "";
            /* renamed from: k */
            private boolean f12008k;
            /* renamed from: l */
            private String f12009l = "";
            /* renamed from: m */
            private boolean f12010m;
            /* renamed from: n */
            private String f12011n = "";
            /* renamed from: o */
            private List<Img> f12012o = Collections.emptyList();
            /* renamed from: p */
            private boolean f12013p;
            /* renamed from: q */
            private String f12014q = "";
            /* renamed from: r */
            private boolean f12015r;
            /* renamed from: s */
            private Location f12016s = null;
            /* renamed from: t */
            private boolean f12017t;
            /* renamed from: u */
            private String f12018u = "";
            /* renamed from: v */
            private boolean f12019v;
            /* renamed from: w */
            private Audio f12020w = null;
            /* renamed from: x */
            private List<Quote> f12021x = Collections.emptyList();
            /* renamed from: y */
            private boolean f12022y;
            /* renamed from: z */
            private String f12023z = "";

            public static final class Audio extends MessageMicro {
                public static final int LENGTH_FIELD_NUMBER = 2;
                public static final int SRC_FIELD_NUMBER = 1;
                /* renamed from: a */
                private boolean f11933a;
                /* renamed from: b */
                private String f11934b = "";
                /* renamed from: c */
                private boolean f11935c;
                /* renamed from: d */
                private int f11936d = 0;
                /* renamed from: e */
                private int f11937e = -1;

                public static Audio parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Audio().mergeFrom(codedInputStreamMicro);
                }

                public static Audio parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Audio) new Audio().mergeFrom(bArr);
                }

                public final Audio clear() {
                    clearSrc();
                    clearLength();
                    this.f11937e = -1;
                    return this;
                }

                public Audio clearLength() {
                    this.f11935c = false;
                    this.f11936d = 0;
                    return this;
                }

                public Audio clearSrc() {
                    this.f11933a = false;
                    this.f11934b = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11937e < 0) {
                        getSerializedSize();
                    }
                    return this.f11937e;
                }

                public int getLength() {
                    return this.f11936d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasSrc()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSrc());
                    }
                    if (hasLength()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getLength());
                    }
                    this.f11937e = i;
                    return i;
                }

                public String getSrc() {
                    return this.f11934b;
                }

                public boolean hasLength() {
                    return this.f11935c;
                }

                public boolean hasSrc() {
                    return this.f11933a;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Audio mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setSrc(codedInputStreamMicro.readString());
                                continue;
                            case 16:
                                setLength(codedInputStreamMicro.readInt32());
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

                public Audio setLength(int i) {
                    this.f11935c = true;
                    this.f11936d = i;
                    return this;
                }

                public Audio setSrc(String str) {
                    this.f11933a = true;
                    this.f11934b = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasSrc()) {
                        codedOutputStreamMicro.writeString(1, getSrc());
                    }
                    if (hasLength()) {
                        codedOutputStreamMicro.writeInt32(2, getLength());
                    }
                }
            }

            public static final class Img extends MessageMicro {
                public static final int RAW_FIELD_NUMBER = 2;
                public static final int RAW_HEIGHT_FIELD_NUMBER = 6;
                public static final int RAW_WIDTH_FIELD_NUMBER = 5;
                public static final int THUMB_FIELD_NUMBER = 1;
                public static final int THUMB_HEIGHT_FIELD_NUMBER = 4;
                public static final int THUMB_WIDTH_FIELD_NUMBER = 3;
                /* renamed from: a */
                private boolean f11938a;
                /* renamed from: b */
                private String f11939b = "";
                /* renamed from: c */
                private boolean f11940c;
                /* renamed from: d */
                private String f11941d = "";
                /* renamed from: e */
                private boolean f11942e;
                /* renamed from: f */
                private int f11943f = 0;
                /* renamed from: g */
                private boolean f11944g;
                /* renamed from: h */
                private int f11945h = 0;
                /* renamed from: i */
                private boolean f11946i;
                /* renamed from: j */
                private int f11947j = 0;
                /* renamed from: k */
                private boolean f11948k;
                /* renamed from: l */
                private int f11949l = 0;
                /* renamed from: m */
                private int f11950m = -1;

                public static Img parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Img().mergeFrom(codedInputStreamMicro);
                }

                public static Img parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Img) new Img().mergeFrom(bArr);
                }

                public final Img clear() {
                    clearThumb();
                    clearRaw();
                    clearThumbWidth();
                    clearThumbHeight();
                    clearRawWidth();
                    clearRawHeight();
                    this.f11950m = -1;
                    return this;
                }

                public Img clearRaw() {
                    this.f11940c = false;
                    this.f11941d = "";
                    return this;
                }

                public Img clearRawHeight() {
                    this.f11948k = false;
                    this.f11949l = 0;
                    return this;
                }

                public Img clearRawWidth() {
                    this.f11946i = false;
                    this.f11947j = 0;
                    return this;
                }

                public Img clearThumb() {
                    this.f11938a = false;
                    this.f11939b = "";
                    return this;
                }

                public Img clearThumbHeight() {
                    this.f11944g = false;
                    this.f11945h = 0;
                    return this;
                }

                public Img clearThumbWidth() {
                    this.f11942e = false;
                    this.f11943f = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11950m < 0) {
                        getSerializedSize();
                    }
                    return this.f11950m;
                }

                public String getRaw() {
                    return this.f11941d;
                }

                public int getRawHeight() {
                    return this.f11949l;
                }

                public int getRawWidth() {
                    return this.f11947j;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasThumb()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThumb());
                    }
                    if (hasRaw()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getRaw());
                    }
                    if (hasThumbWidth()) {
                        i += CodedOutputStreamMicro.computeInt32Size(3, getThumbWidth());
                    }
                    if (hasThumbHeight()) {
                        i += CodedOutputStreamMicro.computeInt32Size(4, getThumbHeight());
                    }
                    if (hasRawWidth()) {
                        i += CodedOutputStreamMicro.computeInt32Size(5, getRawWidth());
                    }
                    if (hasRawHeight()) {
                        i += CodedOutputStreamMicro.computeInt32Size(6, getRawHeight());
                    }
                    this.f11950m = i;
                    return i;
                }

                public String getThumb() {
                    return this.f11939b;
                }

                public int getThumbHeight() {
                    return this.f11945h;
                }

                public int getThumbWidth() {
                    return this.f11943f;
                }

                public boolean hasRaw() {
                    return this.f11940c;
                }

                public boolean hasRawHeight() {
                    return this.f11948k;
                }

                public boolean hasRawWidth() {
                    return this.f11946i;
                }

                public boolean hasThumb() {
                    return this.f11938a;
                }

                public boolean hasThumbHeight() {
                    return this.f11944g;
                }

                public boolean hasThumbWidth() {
                    return this.f11942e;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Img mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setThumb(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setRaw(codedInputStreamMicro.readString());
                                continue;
                            case 24:
                                setThumbWidth(codedInputStreamMicro.readInt32());
                                continue;
                            case 32:
                                setThumbHeight(codedInputStreamMicro.readInt32());
                                continue;
                            case 40:
                                setRawWidth(codedInputStreamMicro.readInt32());
                                continue;
                            case 48:
                                setRawHeight(codedInputStreamMicro.readInt32());
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

                public Img setRaw(String str) {
                    this.f11940c = true;
                    this.f11941d = str;
                    return this;
                }

                public Img setRawHeight(int i) {
                    this.f11948k = true;
                    this.f11949l = i;
                    return this;
                }

                public Img setRawWidth(int i) {
                    this.f11946i = true;
                    this.f11947j = i;
                    return this;
                }

                public Img setThumb(String str) {
                    this.f11938a = true;
                    this.f11939b = str;
                    return this;
                }

                public Img setThumbHeight(int i) {
                    this.f11944g = true;
                    this.f11945h = i;
                    return this;
                }

                public Img setThumbWidth(int i) {
                    this.f11942e = true;
                    this.f11943f = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasThumb()) {
                        codedOutputStreamMicro.writeString(1, getThumb());
                    }
                    if (hasRaw()) {
                        codedOutputStreamMicro.writeString(2, getRaw());
                    }
                    if (hasThumbWidth()) {
                        codedOutputStreamMicro.writeInt32(3, getThumbWidth());
                    }
                    if (hasThumbHeight()) {
                        codedOutputStreamMicro.writeInt32(4, getThumbHeight());
                    }
                    if (hasRawWidth()) {
                        codedOutputStreamMicro.writeInt32(5, getRawWidth());
                    }
                    if (hasRawHeight()) {
                        codedOutputStreamMicro.writeInt32(6, getRawHeight());
                    }
                }
            }

            public static final class Location extends MessageMicro {
                public static final int LAT_FIELD_NUMBER = 2;
                public static final int LNG_FIELD_NUMBER = 1;
                public static final int NAME_FIELD_NUMBER = 3;
                /* renamed from: a */
                private boolean f11951a;
                /* renamed from: b */
                private String f11952b = "";
                /* renamed from: c */
                private boolean f11953c;
                /* renamed from: d */
                private String f11954d = "";
                /* renamed from: e */
                private boolean f11955e;
                /* renamed from: f */
                private String f11956f = "";
                /* renamed from: g */
                private int f11957g = -1;

                public static Location parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Location().mergeFrom(codedInputStreamMicro);
                }

                public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Location) new Location().mergeFrom(bArr);
                }

                public final Location clear() {
                    clearLng();
                    clearLat();
                    clearName();
                    this.f11957g = -1;
                    return this;
                }

                public Location clearLat() {
                    this.f11953c = false;
                    this.f11954d = "";
                    return this;
                }

                public Location clearLng() {
                    this.f11951a = false;
                    this.f11952b = "";
                    return this;
                }

                public Location clearName() {
                    this.f11955e = false;
                    this.f11956f = "";
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11957g < 0) {
                        getSerializedSize();
                    }
                    return this.f11957g;
                }

                public String getLat() {
                    return this.f11954d;
                }

                public String getLng() {
                    return this.f11952b;
                }

                public String getName() {
                    return this.f11956f;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasLng()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLng());
                    }
                    if (hasLat()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getLat());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getName());
                    }
                    this.f11957g = i;
                    return i;
                }

                public boolean hasLat() {
                    return this.f11953c;
                }

                public boolean hasLng() {
                    return this.f11951a;
                }

                public boolean hasName() {
                    return this.f11955e;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Location mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setLng(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setLat(codedInputStreamMicro.readString());
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

                public Location setLat(String str) {
                    this.f11953c = true;
                    this.f11954d = str;
                    return this;
                }

                public Location setLng(String str) {
                    this.f11951a = true;
                    this.f11952b = str;
                    return this;
                }

                public Location setName(String str) {
                    this.f11955e = true;
                    this.f11956f = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasLng()) {
                        codedOutputStreamMicro.writeString(1, getLng());
                    }
                    if (hasLat()) {
                        codedOutputStreamMicro.writeString(2, getLat());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(3, getName());
                    }
                }
            }

            public static final class Quote extends MessageMicro {
                public static final int AUDIO_FIELD_NUMBER = 10;
                public static final int DESC_FIELD_NUMBER = 5;
                public static final int ID_FIELD_NUMBER = 1;
                public static final int IMGS_FIELD_NUMBER = 6;
                public static final int LINK_FIELD_NUMBER = 7;
                public static final int LOC_FIELD_NUMBER = 8;
                public static final int NAME_FIELD_NUMBER = 3;
                public static final int ROLE_FIELD_NUMBER = 2;
                public static final int TAG_FIELD_NUMBER = 9;
                public static final int TIME_FIELD_NUMBER = 4;
                public static final int UID_FIELD_NUMBER = 11;
                public static final int VIDEO_FIELD_NUMBER = 12;
                /* renamed from: a */
                private boolean f11958a;
                /* renamed from: b */
                private String f11959b = "";
                /* renamed from: c */
                private boolean f11960c;
                /* renamed from: d */
                private String f11961d = "";
                /* renamed from: e */
                private boolean f11962e;
                /* renamed from: f */
                private String f11963f = "";
                /* renamed from: g */
                private boolean f11964g;
                /* renamed from: h */
                private String f11965h = "";
                /* renamed from: i */
                private boolean f11966i;
                /* renamed from: j */
                private String f11967j = "";
                /* renamed from: k */
                private List<Img> f11968k = Collections.emptyList();
                /* renamed from: l */
                private boolean f11969l;
                /* renamed from: m */
                private String f11970m = "";
                /* renamed from: n */
                private boolean f11971n;
                /* renamed from: o */
                private Location f11972o = null;
                /* renamed from: p */
                private boolean f11973p;
                /* renamed from: q */
                private String f11974q = "";
                /* renamed from: r */
                private boolean f11975r;
                /* renamed from: s */
                private Audio f11976s = null;
                /* renamed from: t */
                private boolean f11977t;
                /* renamed from: u */
                private String f11978u = "";
                /* renamed from: v */
                private boolean f11979v;
                /* renamed from: w */
                private Video f11980w = null;
                /* renamed from: x */
                private int f11981x = -1;

                public static Quote parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Quote().mergeFrom(codedInputStreamMicro);
                }

                public static Quote parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Quote) new Quote().mergeFrom(bArr);
                }

                public Quote addImgs(Img img) {
                    if (img != null) {
                        if (this.f11968k.isEmpty()) {
                            this.f11968k = new ArrayList();
                        }
                        this.f11968k.add(img);
                    }
                    return this;
                }

                public final Quote clear() {
                    clearId();
                    clearRole();
                    clearName();
                    clearTime();
                    clearDesc();
                    clearImgs();
                    clearLink();
                    clearLoc();
                    clearTag();
                    clearAudio();
                    clearUid();
                    clearVideo();
                    this.f11981x = -1;
                    return this;
                }

                public Quote clearAudio() {
                    this.f11975r = false;
                    this.f11976s = null;
                    return this;
                }

                public Quote clearDesc() {
                    this.f11966i = false;
                    this.f11967j = "";
                    return this;
                }

                public Quote clearId() {
                    this.f11958a = false;
                    this.f11959b = "";
                    return this;
                }

                public Quote clearImgs() {
                    this.f11968k = Collections.emptyList();
                    return this;
                }

                public Quote clearLink() {
                    this.f11969l = false;
                    this.f11970m = "";
                    return this;
                }

                public Quote clearLoc() {
                    this.f11971n = false;
                    this.f11972o = null;
                    return this;
                }

                public Quote clearName() {
                    this.f11962e = false;
                    this.f11963f = "";
                    return this;
                }

                public Quote clearRole() {
                    this.f11960c = false;
                    this.f11961d = "";
                    return this;
                }

                public Quote clearTag() {
                    this.f11973p = false;
                    this.f11974q = "";
                    return this;
                }

                public Quote clearTime() {
                    this.f11964g = false;
                    this.f11965h = "";
                    return this;
                }

                public Quote clearUid() {
                    this.f11977t = false;
                    this.f11978u = "";
                    return this;
                }

                public Quote clearVideo() {
                    this.f11979v = false;
                    this.f11980w = null;
                    return this;
                }

                public Audio getAudio() {
                    return this.f11976s;
                }

                public int getCachedSize() {
                    if (this.f11981x < 0) {
                        getSerializedSize();
                    }
                    return this.f11981x;
                }

                public String getDesc() {
                    return this.f11967j;
                }

                public String getId() {
                    return this.f11959b;
                }

                public Img getImgs(int i) {
                    return (Img) this.f11968k.get(i);
                }

                public int getImgsCount() {
                    return this.f11968k.size();
                }

                public List<Img> getImgsList() {
                    return this.f11968k;
                }

                public String getLink() {
                    return this.f11970m;
                }

                public Location getLoc() {
                    return this.f11972o;
                }

                public String getName() {
                    return this.f11963f;
                }

                public String getRole() {
                    return this.f11961d;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasId()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
                    }
                    if (hasRole()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getRole());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getName());
                    }
                    if (hasTime()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getTime());
                    }
                    if (hasDesc()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getDesc());
                    }
                    int i2 = i;
                    for (Img computeMessageSize : getImgsList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i2;
                    }
                    if (hasLink()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(7, getLink());
                    }
                    if (hasLoc()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(8, getLoc());
                    }
                    if (hasTag()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(9, getTag());
                    }
                    if (hasAudio()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(10, getAudio());
                    }
                    if (hasUid()) {
                        i2 += CodedOutputStreamMicro.computeStringSize(11, getUid());
                    }
                    if (hasVideo()) {
                        i2 += CodedOutputStreamMicro.computeMessageSize(12, getVideo());
                    }
                    this.f11981x = i2;
                    return i2;
                }

                public String getTag() {
                    return this.f11974q;
                }

                public String getTime() {
                    return this.f11965h;
                }

                public String getUid() {
                    return this.f11978u;
                }

                public Video getVideo() {
                    return this.f11980w;
                }

                public boolean hasAudio() {
                    return this.f11975r;
                }

                public boolean hasDesc() {
                    return this.f11966i;
                }

                public boolean hasId() {
                    return this.f11958a;
                }

                public boolean hasLink() {
                    return this.f11969l;
                }

                public boolean hasLoc() {
                    return this.f11971n;
                }

                public boolean hasName() {
                    return this.f11962e;
                }

                public boolean hasRole() {
                    return this.f11960c;
                }

                public boolean hasTag() {
                    return this.f11973p;
                }

                public boolean hasTime() {
                    return this.f11964g;
                }

                public boolean hasUid() {
                    return this.f11977t;
                }

                public boolean hasVideo() {
                    return this.f11979v;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Quote mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro img;
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setId(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setRole(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setTime(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setDesc(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                img = new Img();
                                codedInputStreamMicro.readMessage(img);
                                addImgs(img);
                                continue;
                            case 58:
                                setLink(codedInputStreamMicro.readString());
                                continue;
                            case 66:
                                img = new Location();
                                codedInputStreamMicro.readMessage(img);
                                setLoc(img);
                                continue;
                            case 74:
                                setTag(codedInputStreamMicro.readString());
                                continue;
                            case 82:
                                img = new Audio();
                                codedInputStreamMicro.readMessage(img);
                                setAudio(img);
                                continue;
                            case 90:
                                setUid(codedInputStreamMicro.readString());
                                continue;
                            case 98:
                                img = new Video();
                                codedInputStreamMicro.readMessage(img);
                                setVideo(img);
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

                public Quote setAudio(Audio audio) {
                    if (audio == null) {
                        return clearAudio();
                    }
                    this.f11975r = true;
                    this.f11976s = audio;
                    return this;
                }

                public Quote setDesc(String str) {
                    this.f11966i = true;
                    this.f11967j = str;
                    return this;
                }

                public Quote setId(String str) {
                    this.f11958a = true;
                    this.f11959b = str;
                    return this;
                }

                public Quote setImgs(int i, Img img) {
                    if (img != null) {
                        this.f11968k.set(i, img);
                    }
                    return this;
                }

                public Quote setLink(String str) {
                    this.f11969l = true;
                    this.f11970m = str;
                    return this;
                }

                public Quote setLoc(Location location) {
                    if (location == null) {
                        return clearLoc();
                    }
                    this.f11971n = true;
                    this.f11972o = location;
                    return this;
                }

                public Quote setName(String str) {
                    this.f11962e = true;
                    this.f11963f = str;
                    return this;
                }

                public Quote setRole(String str) {
                    this.f11960c = true;
                    this.f11961d = str;
                    return this;
                }

                public Quote setTag(String str) {
                    this.f11973p = true;
                    this.f11974q = str;
                    return this;
                }

                public Quote setTime(String str) {
                    this.f11964g = true;
                    this.f11965h = str;
                    return this;
                }

                public Quote setUid(String str) {
                    this.f11977t = true;
                    this.f11978u = str;
                    return this;
                }

                public Quote setVideo(Video video) {
                    if (video == null) {
                        return clearVideo();
                    }
                    this.f11979v = true;
                    this.f11980w = video;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasId()) {
                        codedOutputStreamMicro.writeString(1, getId());
                    }
                    if (hasRole()) {
                        codedOutputStreamMicro.writeString(2, getRole());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(3, getName());
                    }
                    if (hasTime()) {
                        codedOutputStreamMicro.writeString(4, getTime());
                    }
                    if (hasDesc()) {
                        codedOutputStreamMicro.writeString(5, getDesc());
                    }
                    for (Img writeMessage : getImgsList()) {
                        codedOutputStreamMicro.writeMessage(6, writeMessage);
                    }
                    if (hasLink()) {
                        codedOutputStreamMicro.writeString(7, getLink());
                    }
                    if (hasLoc()) {
                        codedOutputStreamMicro.writeMessage(8, getLoc());
                    }
                    if (hasTag()) {
                        codedOutputStreamMicro.writeString(9, getTag());
                    }
                    if (hasAudio()) {
                        codedOutputStreamMicro.writeMessage(10, getAudio());
                    }
                    if (hasUid()) {
                        codedOutputStreamMicro.writeString(11, getUid());
                    }
                    if (hasVideo()) {
                        codedOutputStreamMicro.writeMessage(12, getVideo());
                    }
                }
            }

            public static final class Video extends MessageMicro {
                public static final int LENGTH_FIELD_NUMBER = 6;
                public static final int RAW_FIELD_NUMBER = 4;
                public static final int SIZE_FIELD_NUMBER = 5;
                public static final int THUMB_FIELD_NUMBER = 1;
                public static final int THUMB_HEIGHT_FIELD_NUMBER = 3;
                public static final int THUMB_WIDTH_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f11982a;
                /* renamed from: b */
                private String f11983b = "";
                /* renamed from: c */
                private boolean f11984c;
                /* renamed from: d */
                private int f11985d = 0;
                /* renamed from: e */
                private boolean f11986e;
                /* renamed from: f */
                private int f11987f = 0;
                /* renamed from: g */
                private boolean f11988g;
                /* renamed from: h */
                private String f11989h = "";
                /* renamed from: i */
                private boolean f11990i;
                /* renamed from: j */
                private int f11991j = 0;
                /* renamed from: k */
                private boolean f11992k;
                /* renamed from: l */
                private int f11993l = 0;
                /* renamed from: m */
                private int f11994m = -1;

                public static Video parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Video().mergeFrom(codedInputStreamMicro);
                }

                public static Video parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Video) new Video().mergeFrom(bArr);
                }

                public final Video clear() {
                    clearThumb();
                    clearThumbWidth();
                    clearThumbHeight();
                    clearRaw();
                    clearSize();
                    clearLength();
                    this.f11994m = -1;
                    return this;
                }

                public Video clearLength() {
                    this.f11992k = false;
                    this.f11993l = 0;
                    return this;
                }

                public Video clearRaw() {
                    this.f11988g = false;
                    this.f11989h = "";
                    return this;
                }

                public Video clearSize() {
                    this.f11990i = false;
                    this.f11991j = 0;
                    return this;
                }

                public Video clearThumb() {
                    this.f11982a = false;
                    this.f11983b = "";
                    return this;
                }

                public Video clearThumbHeight() {
                    this.f11986e = false;
                    this.f11987f = 0;
                    return this;
                }

                public Video clearThumbWidth() {
                    this.f11984c = false;
                    this.f11985d = 0;
                    return this;
                }

                public int getCachedSize() {
                    if (this.f11994m < 0) {
                        getSerializedSize();
                    }
                    return this.f11994m;
                }

                public int getLength() {
                    return this.f11993l;
                }

                public String getRaw() {
                    return this.f11989h;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasThumb()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThumb());
                    }
                    if (hasThumbWidth()) {
                        i += CodedOutputStreamMicro.computeInt32Size(2, getThumbWidth());
                    }
                    if (hasThumbHeight()) {
                        i += CodedOutputStreamMicro.computeInt32Size(3, getThumbHeight());
                    }
                    if (hasRaw()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getRaw());
                    }
                    if (hasSize()) {
                        i += CodedOutputStreamMicro.computeInt32Size(5, getSize());
                    }
                    if (hasLength()) {
                        i += CodedOutputStreamMicro.computeInt32Size(6, getLength());
                    }
                    this.f11994m = i;
                    return i;
                }

                public int getSize() {
                    return this.f11991j;
                }

                public String getThumb() {
                    return this.f11983b;
                }

                public int getThumbHeight() {
                    return this.f11987f;
                }

                public int getThumbWidth() {
                    return this.f11985d;
                }

                public boolean hasLength() {
                    return this.f11992k;
                }

                public boolean hasRaw() {
                    return this.f11988g;
                }

                public boolean hasSize() {
                    return this.f11990i;
                }

                public boolean hasThumb() {
                    return this.f11982a;
                }

                public boolean hasThumbHeight() {
                    return this.f11986e;
                }

                public boolean hasThumbWidth() {
                    return this.f11984c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Video mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setThumb(codedInputStreamMicro.readString());
                                continue;
                            case 16:
                                setThumbWidth(codedInputStreamMicro.readInt32());
                                continue;
                            case 24:
                                setThumbHeight(codedInputStreamMicro.readInt32());
                                continue;
                            case 34:
                                setRaw(codedInputStreamMicro.readString());
                                continue;
                            case 40:
                                setSize(codedInputStreamMicro.readInt32());
                                continue;
                            case 48:
                                setLength(codedInputStreamMicro.readInt32());
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

                public Video setLength(int i) {
                    this.f11992k = true;
                    this.f11993l = i;
                    return this;
                }

                public Video setRaw(String str) {
                    this.f11988g = true;
                    this.f11989h = str;
                    return this;
                }

                public Video setSize(int i) {
                    this.f11990i = true;
                    this.f11991j = i;
                    return this;
                }

                public Video setThumb(String str) {
                    this.f11982a = true;
                    this.f11983b = str;
                    return this;
                }

                public Video setThumbHeight(int i) {
                    this.f11986e = true;
                    this.f11987f = i;
                    return this;
                }

                public Video setThumbWidth(int i) {
                    this.f11984c = true;
                    this.f11985d = i;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasThumb()) {
                        codedOutputStreamMicro.writeString(1, getThumb());
                    }
                    if (hasThumbWidth()) {
                        codedOutputStreamMicro.writeInt32(2, getThumbWidth());
                    }
                    if (hasThumbHeight()) {
                        codedOutputStreamMicro.writeInt32(3, getThumbHeight());
                    }
                    if (hasRaw()) {
                        codedOutputStreamMicro.writeString(4, getRaw());
                    }
                    if (hasSize()) {
                        codedOutputStreamMicro.writeInt32(5, getSize());
                    }
                    if (hasLength()) {
                        codedOutputStreamMicro.writeInt32(6, getLength());
                    }
                }
            }

            public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Content().mergeFrom(codedInputStreamMicro);
            }

            public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Content) new Content().mergeFrom(bArr);
            }

            public Content addImgs(Img img) {
                if (img != null) {
                    if (this.f12012o.isEmpty()) {
                        this.f12012o = new ArrayList();
                    }
                    this.f12012o.add(img);
                }
                return this;
            }

            public Content addQuote(Quote quote) {
                if (quote != null) {
                    if (this.f12021x.isEmpty()) {
                        this.f12021x = new ArrayList();
                    }
                    this.f12021x.add(quote);
                }
                return this;
            }

            public final Content clear() {
                clearId();
                clearUid();
                clearLogo();
                clearRole();
                clearName();
                clearTime();
                clearDesc();
                clearImgs();
                clearLink();
                clearLoc();
                clearTag();
                clearAudio();
                clearQuote();
                clearAuthen();
                clearVideo();
                this.f11997C = -1;
                return this;
            }

            public Content clearAudio() {
                this.f12019v = false;
                this.f12020w = null;
                return this;
            }

            public Content clearAuthen() {
                this.f12022y = false;
                this.f12023z = "";
                return this;
            }

            public Content clearDesc() {
                this.f12010m = false;
                this.f12011n = "";
                return this;
            }

            public Content clearId() {
                this.f11998a = false;
                this.f11999b = "";
                return this;
            }

            public Content clearImgs() {
                this.f12012o = Collections.emptyList();
                return this;
            }

            public Content clearLink() {
                this.f12013p = false;
                this.f12014q = "";
                return this;
            }

            public Content clearLoc() {
                this.f12015r = false;
                this.f12016s = null;
                return this;
            }

            public Content clearLogo() {
                this.f12002e = false;
                this.f12003f = "";
                return this;
            }

            public Content clearName() {
                this.f12006i = false;
                this.f12007j = "";
                return this;
            }

            public Content clearQuote() {
                this.f12021x = Collections.emptyList();
                return this;
            }

            public Content clearRole() {
                this.f12004g = false;
                this.f12005h = "";
                return this;
            }

            public Content clearTag() {
                this.f12017t = false;
                this.f12018u = "";
                return this;
            }

            public Content clearTime() {
                this.f12008k = false;
                this.f12009l = "";
                return this;
            }

            public Content clearUid() {
                this.f12000c = false;
                this.f12001d = "";
                return this;
            }

            public Content clearVideo() {
                this.f11995A = false;
                this.f11996B = null;
                return this;
            }

            public Audio getAudio() {
                return this.f12020w;
            }

            public String getAuthen() {
                return this.f12023z;
            }

            public int getCachedSize() {
                if (this.f11997C < 0) {
                    getSerializedSize();
                }
                return this.f11997C;
            }

            public String getDesc() {
                return this.f12011n;
            }

            public String getId() {
                return this.f11999b;
            }

            public Img getImgs(int i) {
                return (Img) this.f12012o.get(i);
            }

            public int getImgsCount() {
                return this.f12012o.size();
            }

            public List<Img> getImgsList() {
                return this.f12012o;
            }

            public String getLink() {
                return this.f12014q;
            }

            public Location getLoc() {
                return this.f12016s;
            }

            public String getLogo() {
                return this.f12003f;
            }

            public String getName() {
                return this.f12007j;
            }

            public Quote getQuote(int i) {
                return (Quote) this.f12021x.get(i);
            }

            public int getQuoteCount() {
                return this.f12021x.size();
            }

            public List<Quote> getQuoteList() {
                return this.f12021x;
            }

            public String getRole() {
                return this.f12005h;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasId()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getId());
                }
                if (hasUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getUid());
                }
                if (hasLogo()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getLogo());
                }
                if (hasRole()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getRole());
                }
                if (hasName()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getName());
                }
                if (hasTime()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getTime());
                }
                if (hasDesc()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getDesc());
                }
                int i2 = i;
                for (Img computeMessageSize : getImgsList()) {
                    i2 = CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize) + i2;
                }
                if (hasLink()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(9, getLink());
                }
                if (hasLoc()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(10, getLoc());
                }
                if (hasTag()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(11, getTag());
                }
                if (hasAudio()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(12, getAudio());
                }
                for (Quote computeMessageSize2 : getQuoteList()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize2);
                }
                if (hasAuthen()) {
                    i2 += CodedOutputStreamMicro.computeStringSize(14, getAuthen());
                }
                if (hasVideo()) {
                    i2 += CodedOutputStreamMicro.computeMessageSize(15, getVideo());
                }
                this.f11997C = i2;
                return i2;
            }

            public String getTag() {
                return this.f12018u;
            }

            public String getTime() {
                return this.f12009l;
            }

            public String getUid() {
                return this.f12001d;
            }

            public Video getVideo() {
                return this.f11996B;
            }

            public boolean hasAudio() {
                return this.f12019v;
            }

            public boolean hasAuthen() {
                return this.f12022y;
            }

            public boolean hasDesc() {
                return this.f12010m;
            }

            public boolean hasId() {
                return this.f11998a;
            }

            public boolean hasLink() {
                return this.f12013p;
            }

            public boolean hasLoc() {
                return this.f12015r;
            }

            public boolean hasLogo() {
                return this.f12002e;
            }

            public boolean hasName() {
                return this.f12006i;
            }

            public boolean hasRole() {
                return this.f12004g;
            }

            public boolean hasTag() {
                return this.f12017t;
            }

            public boolean hasTime() {
                return this.f12008k;
            }

            public boolean hasUid() {
                return this.f12000c;
            }

            public boolean hasVideo() {
                return this.f11995A;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro img;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setId(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setUid(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setLogo(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setRole(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setName(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setTime(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setDesc(codedInputStreamMicro.readString());
                            continue;
                        case 66:
                            img = new Img();
                            codedInputStreamMicro.readMessage(img);
                            addImgs(img);
                            continue;
                        case 74:
                            setLink(codedInputStreamMicro.readString());
                            continue;
                        case 82:
                            img = new Location();
                            codedInputStreamMicro.readMessage(img);
                            setLoc(img);
                            continue;
                        case 90:
                            setTag(codedInputStreamMicro.readString());
                            continue;
                        case 98:
                            img = new Audio();
                            codedInputStreamMicro.readMessage(img);
                            setAudio(img);
                            continue;
                        case 106:
                            img = new Quote();
                            codedInputStreamMicro.readMessage(img);
                            addQuote(img);
                            continue;
                        case 114:
                            setAuthen(codedInputStreamMicro.readString());
                            continue;
                        case C1253f.df /*122*/:
                            img = new Video();
                            codedInputStreamMicro.readMessage(img);
                            setVideo(img);
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

            public Content setAudio(Audio audio) {
                if (audio == null) {
                    return clearAudio();
                }
                this.f12019v = true;
                this.f12020w = audio;
                return this;
            }

            public Content setAuthen(String str) {
                this.f12022y = true;
                this.f12023z = str;
                return this;
            }

            public Content setDesc(String str) {
                this.f12010m = true;
                this.f12011n = str;
                return this;
            }

            public Content setId(String str) {
                this.f11998a = true;
                this.f11999b = str;
                return this;
            }

            public Content setImgs(int i, Img img) {
                if (img != null) {
                    this.f12012o.set(i, img);
                }
                return this;
            }

            public Content setLink(String str) {
                this.f12013p = true;
                this.f12014q = str;
                return this;
            }

            public Content setLoc(Location location) {
                if (location == null) {
                    return clearLoc();
                }
                this.f12015r = true;
                this.f12016s = location;
                return this;
            }

            public Content setLogo(String str) {
                this.f12002e = true;
                this.f12003f = str;
                return this;
            }

            public Content setName(String str) {
                this.f12006i = true;
                this.f12007j = str;
                return this;
            }

            public Content setQuote(int i, Quote quote) {
                if (quote != null) {
                    this.f12021x.set(i, quote);
                }
                return this;
            }

            public Content setRole(String str) {
                this.f12004g = true;
                this.f12005h = str;
                return this;
            }

            public Content setTag(String str) {
                this.f12017t = true;
                this.f12018u = str;
                return this;
            }

            public Content setTime(String str) {
                this.f12008k = true;
                this.f12009l = str;
                return this;
            }

            public Content setUid(String str) {
                this.f12000c = true;
                this.f12001d = str;
                return this;
            }

            public Content setVideo(Video video) {
                if (video == null) {
                    return clearVideo();
                }
                this.f11995A = true;
                this.f11996B = video;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasId()) {
                    codedOutputStreamMicro.writeString(1, getId());
                }
                if (hasUid()) {
                    codedOutputStreamMicro.writeString(2, getUid());
                }
                if (hasLogo()) {
                    codedOutputStreamMicro.writeString(3, getLogo());
                }
                if (hasRole()) {
                    codedOutputStreamMicro.writeString(4, getRole());
                }
                if (hasName()) {
                    codedOutputStreamMicro.writeString(5, getName());
                }
                if (hasTime()) {
                    codedOutputStreamMicro.writeString(6, getTime());
                }
                if (hasDesc()) {
                    codedOutputStreamMicro.writeString(7, getDesc());
                }
                for (Img writeMessage : getImgsList()) {
                    codedOutputStreamMicro.writeMessage(8, writeMessage);
                }
                if (hasLink()) {
                    codedOutputStreamMicro.writeString(9, getLink());
                }
                if (hasLoc()) {
                    codedOutputStreamMicro.writeMessage(10, getLoc());
                }
                if (hasTag()) {
                    codedOutputStreamMicro.writeString(11, getTag());
                }
                if (hasAudio()) {
                    codedOutputStreamMicro.writeMessage(12, getAudio());
                }
                for (Quote writeMessage2 : getQuoteList()) {
                    codedOutputStreamMicro.writeMessage(13, writeMessage2);
                }
                if (hasAuthen()) {
                    codedOutputStreamMicro.writeString(14, getAuthen());
                }
                if (hasVideo()) {
                    codedOutputStreamMicro.writeMessage(15, getVideo());
                }
            }
        }

        public static final class Header extends MessageMicro {
            public static final int ANONYMOUS_FIELD_NUMBER = 7;
            public static final int DEADLINE_FIELD_NUMBER = 4;
            public static final int EDITMODE_FIELD_NUMBER = 8;
            public static final int FORCAST_FIELD_NUMBER = 6;
            public static final int ISOPENVIDEO_FIELD_NUMBER = 9;
            public static final int PLANID_FIELD_NUMBER = 3;
            public static final int PRESENT_FIELD_NUMBER = 5;
            public static final int STATUS_FIELD_NUMBER = 1;
            public static final int TITLE_FIELD_NUMBER = 2;
            /* renamed from: a */
            private boolean f12024a;
            /* renamed from: b */
            private int f12025b = 0;
            /* renamed from: c */
            private boolean f12026c;
            /* renamed from: d */
            private String f12027d = "";
            /* renamed from: e */
            private boolean f12028e;
            /* renamed from: f */
            private int f12029f = 0;
            /* renamed from: g */
            private boolean f12030g;
            /* renamed from: h */
            private int f12031h = 0;
            /* renamed from: i */
            private boolean f12032i;
            /* renamed from: j */
            private String f12033j = "";
            /* renamed from: k */
            private boolean f12034k;
            /* renamed from: l */
            private String f12035l = "";
            /* renamed from: m */
            private boolean f12036m;
            /* renamed from: n */
            private int f12037n = 0;
            /* renamed from: o */
            private boolean f12038o;
            /* renamed from: p */
            private int f12039p = 0;
            /* renamed from: q */
            private boolean f12040q;
            /* renamed from: r */
            private int f12041r = 0;
            /* renamed from: s */
            private int f12042s = -1;

            public static Header parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Header().mergeFrom(codedInputStreamMicro);
            }

            public static Header parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Header) new Header().mergeFrom(bArr);
            }

            public final Header clear() {
                clearStatus();
                clearTitle();
                clearPlanid();
                clearDeadline();
                clearPresent();
                clearForcast();
                clearAnonymous();
                clearEditmode();
                clearIsopenvideo();
                this.f12042s = -1;
                return this;
            }

            public Header clearAnonymous() {
                this.f12036m = false;
                this.f12037n = 0;
                return this;
            }

            public Header clearDeadline() {
                this.f12030g = false;
                this.f12031h = 0;
                return this;
            }

            public Header clearEditmode() {
                this.f12038o = false;
                this.f12039p = 0;
                return this;
            }

            public Header clearForcast() {
                this.f12034k = false;
                this.f12035l = "";
                return this;
            }

            public Header clearIsopenvideo() {
                this.f12040q = false;
                this.f12041r = 0;
                return this;
            }

            public Header clearPlanid() {
                this.f12028e = false;
                this.f12029f = 0;
                return this;
            }

            public Header clearPresent() {
                this.f12032i = false;
                this.f12033j = "";
                return this;
            }

            public Header clearStatus() {
                this.f12024a = false;
                this.f12025b = 0;
                return this;
            }

            public Header clearTitle() {
                this.f12026c = false;
                this.f12027d = "";
                return this;
            }

            public int getAnonymous() {
                return this.f12037n;
            }

            public int getCachedSize() {
                if (this.f12042s < 0) {
                    getSerializedSize();
                }
                return this.f12042s;
            }

            public int getDeadline() {
                return this.f12031h;
            }

            public int getEditmode() {
                return this.f12039p;
            }

            public String getForcast() {
                return this.f12035l;
            }

            public int getIsopenvideo() {
                return this.f12041r;
            }

            public int getPlanid() {
                return this.f12029f;
            }

            public String getPresent() {
                return this.f12033j;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasStatus()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getStatus());
                }
                if (hasTitle()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                }
                if (hasPlanid()) {
                    i += CodedOutputStreamMicro.computeInt32Size(3, getPlanid());
                }
                if (hasDeadline()) {
                    i += CodedOutputStreamMicro.computeInt32Size(4, getDeadline());
                }
                if (hasPresent()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getPresent());
                }
                if (hasForcast()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getForcast());
                }
                if (hasAnonymous()) {
                    i += CodedOutputStreamMicro.computeInt32Size(7, getAnonymous());
                }
                if (hasEditmode()) {
                    i += CodedOutputStreamMicro.computeInt32Size(8, getEditmode());
                }
                if (hasIsopenvideo()) {
                    i += CodedOutputStreamMicro.computeInt32Size(9, getIsopenvideo());
                }
                this.f12042s = i;
                return i;
            }

            public int getStatus() {
                return this.f12025b;
            }

            public String getTitle() {
                return this.f12027d;
            }

            public boolean hasAnonymous() {
                return this.f12036m;
            }

            public boolean hasDeadline() {
                return this.f12030g;
            }

            public boolean hasEditmode() {
                return this.f12038o;
            }

            public boolean hasForcast() {
                return this.f12034k;
            }

            public boolean hasIsopenvideo() {
                return this.f12040q;
            }

            public boolean hasPlanid() {
                return this.f12028e;
            }

            public boolean hasPresent() {
                return this.f12032i;
            }

            public boolean hasStatus() {
                return this.f12024a;
            }

            public boolean hasTitle() {
                return this.f12026c;
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
                        case 8:
                            setStatus(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 24:
                            setPlanid(codedInputStreamMicro.readInt32());
                            continue;
                        case 32:
                            setDeadline(codedInputStreamMicro.readInt32());
                            continue;
                        case 42:
                            setPresent(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setForcast(codedInputStreamMicro.readString());
                            continue;
                        case 56:
                            setAnonymous(codedInputStreamMicro.readInt32());
                            continue;
                        case 64:
                            setEditmode(codedInputStreamMicro.readInt32());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setIsopenvideo(codedInputStreamMicro.readInt32());
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

            public Header setAnonymous(int i) {
                this.f12036m = true;
                this.f12037n = i;
                return this;
            }

            public Header setDeadline(int i) {
                this.f12030g = true;
                this.f12031h = i;
                return this;
            }

            public Header setEditmode(int i) {
                this.f12038o = true;
                this.f12039p = i;
                return this;
            }

            public Header setForcast(String str) {
                this.f12034k = true;
                this.f12035l = str;
                return this;
            }

            public Header setIsopenvideo(int i) {
                this.f12040q = true;
                this.f12041r = i;
                return this;
            }

            public Header setPlanid(int i) {
                this.f12028e = true;
                this.f12029f = i;
                return this;
            }

            public Header setPresent(String str) {
                this.f12032i = true;
                this.f12033j = str;
                return this;
            }

            public Header setStatus(int i) {
                this.f12024a = true;
                this.f12025b = i;
                return this;
            }

            public Header setTitle(String str) {
                this.f12026c = true;
                this.f12027d = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasStatus()) {
                    codedOutputStreamMicro.writeInt32(1, getStatus());
                }
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(2, getTitle());
                }
                if (hasPlanid()) {
                    codedOutputStreamMicro.writeInt32(3, getPlanid());
                }
                if (hasDeadline()) {
                    codedOutputStreamMicro.writeInt32(4, getDeadline());
                }
                if (hasPresent()) {
                    codedOutputStreamMicro.writeString(5, getPresent());
                }
                if (hasForcast()) {
                    codedOutputStreamMicro.writeString(6, getForcast());
                }
                if (hasAnonymous()) {
                    codedOutputStreamMicro.writeInt32(7, getAnonymous());
                }
                if (hasEditmode()) {
                    codedOutputStreamMicro.writeInt32(8, getEditmode());
                }
                if (hasIsopenvideo()) {
                    codedOutputStreamMicro.writeInt32(9, getIsopenvideo());
                }
            }
        }

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addContent(Content content) {
            if (content != null) {
                if (this.f12045c.isEmpty()) {
                    this.f12045c = new ArrayList();
                }
                this.f12045c.add(content);
            }
            return this;
        }

        public Data addStick(Content content) {
            if (content != null) {
                if (this.f12052j.isEmpty()) {
                    this.f12052j = new ArrayList();
                }
                this.f12052j.add(content);
            }
            return this;
        }

        public final Data clear() {
            clearHeader();
            clearContent();
            clearStamp();
            clearNum();
            clearInterval();
            clearStick();
            this.f12053k = -1;
            return this;
        }

        public Data clearContent() {
            this.f12045c = Collections.emptyList();
            return this;
        }

        public Data clearHeader() {
            this.f12043a = false;
            this.f12044b = null;
            return this;
        }

        public Data clearInterval() {
            this.f12050h = false;
            this.f12051i = "";
            return this;
        }

        public Data clearNum() {
            this.f12048f = false;
            this.f12049g = "";
            return this;
        }

        public Data clearStamp() {
            this.f12046d = false;
            this.f12047e = "";
            return this;
        }

        public Data clearStick() {
            this.f12052j = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f12053k < 0) {
                getSerializedSize();
            }
            return this.f12053k;
        }

        public Content getContent(int i) {
            return (Content) this.f12045c.get(i);
        }

        public int getContentCount() {
            return this.f12045c.size();
        }

        public List<Content> getContentList() {
            return this.f12045c;
        }

        public Header getHeader() {
            return this.f12044b;
        }

        public String getInterval() {
            return this.f12051i;
        }

        public String getNum() {
            return this.f12049g;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasHeader()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHeader());
            }
            int i2 = i;
            for (Content computeMessageSize : getContentList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasStamp()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getStamp());
            }
            if (hasNum()) {
                i2 += CodedOutputStreamMicro.computeStringSize(4, getNum());
            }
            if (hasInterval()) {
                i2 += CodedOutputStreamMicro.computeStringSize(5, getInterval());
            }
            for (Content computeMessageSize2 : getStickList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize2);
            }
            this.f12053k = i2;
            return i2;
        }

        public String getStamp() {
            return this.f12047e;
        }

        public Content getStick(int i) {
            return (Content) this.f12052j.get(i);
        }

        public int getStickCount() {
            return this.f12052j.size();
        }

        public List<Content> getStickList() {
            return this.f12052j;
        }

        public boolean hasHeader() {
            return this.f12043a;
        }

        public boolean hasInterval() {
            return this.f12050h;
        }

        public boolean hasNum() {
            return this.f12048f;
        }

        public boolean hasStamp() {
            return this.f12046d;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Data mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                        header = new Content();
                        codedInputStreamMicro.readMessage(header);
                        addContent(header);
                        continue;
                    case 26:
                        setStamp(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setNum(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setInterval(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        header = new Content();
                        codedInputStreamMicro.readMessage(header);
                        addStick(header);
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

        public Data setContent(int i, Content content) {
            if (content != null) {
                this.f12045c.set(i, content);
            }
            return this;
        }

        public Data setHeader(Header header) {
            if (header == null) {
                return clearHeader();
            }
            this.f12043a = true;
            this.f12044b = header;
            return this;
        }

        public Data setInterval(String str) {
            this.f12050h = true;
            this.f12051i = str;
            return this;
        }

        public Data setNum(String str) {
            this.f12048f = true;
            this.f12049g = str;
            return this;
        }

        public Data setStamp(String str) {
            this.f12046d = true;
            this.f12047e = str;
            return this;
        }

        public Data setStick(int i, Content content) {
            if (content != null) {
                this.f12052j.set(i, content);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasHeader()) {
                codedOutputStreamMicro.writeMessage(1, getHeader());
            }
            for (Content writeMessage : getContentList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasStamp()) {
                codedOutputStreamMicro.writeString(3, getStamp());
            }
            if (hasNum()) {
                codedOutputStreamMicro.writeString(4, getNum());
            }
            if (hasInterval()) {
                codedOutputStreamMicro.writeString(5, getInterval());
            }
            for (Content writeMessage2 : getStickList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage2);
            }
        }
    }

    public static Liveinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Liveinfo().mergeFrom(codedInputStreamMicro);
    }

    public static Liveinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Liveinfo) new Liveinfo().mergeFrom(bArr);
    }

    public final Liveinfo clear() {
        clearError();
        clearMsg();
        clearData();
        this.f12060g = -1;
        return this;
    }

    public Liveinfo clearData() {
        this.f12058e = false;
        this.f12059f = null;
        return this;
    }

    public Liveinfo clearError() {
        this.f12054a = false;
        this.f12055b = 0;
        return this;
    }

    public Liveinfo clearMsg() {
        this.f12056c = false;
        this.f12057d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f12060g < 0) {
            getSerializedSize();
        }
        return this.f12060g;
    }

    public Data getData() {
        return this.f12059f;
    }

    public int getError() {
        return this.f12055b;
    }

    public String getMsg() {
        return this.f12057d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasError()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        if (hasData()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, getData());
        }
        this.f12060g = i;
        return i;
    }

    public boolean hasData() {
        return this.f12058e;
    }

    public boolean hasError() {
        return this.f12054a;
    }

    public boolean hasMsg() {
        return this.f12056c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Liveinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setError(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setMsg(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    MessageMicro data = new Data();
                    codedInputStreamMicro.readMessage(data);
                    setData(data);
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

    public Liveinfo setData(Data data) {
        if (data == null) {
            return clearData();
        }
        this.f12058e = true;
        this.f12059f = data;
        return this;
    }

    public Liveinfo setError(int i) {
        this.f12054a = true;
        this.f12055b = i;
        return this;
    }

    public Liveinfo setMsg(String str) {
        this.f12056c = true;
        this.f12057d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasError()) {
            codedOutputStreamMicro.writeInt32(1, getError());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
        if (hasData()) {
            codedOutputStreamMicro.writeMessage(3, getData());
        }
    }
}
