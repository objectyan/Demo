package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrackMoments extends MessageMicro {
    public static final int LAST_SID_FIELD_NUMBER = 4;
    public static final int LISTS_FIELD_NUMBER = 2;
    public static final int PERSONAL_FIELD_NUMBER = 1;
    public static final int TS_FIELD_NUMBER = 3;
    /* renamed from: a */
    private List<Pic> f16333a = Collections.emptyList();
    /* renamed from: b */
    private List<Pic> f16334b = Collections.emptyList();
    /* renamed from: c */
    private boolean f16335c;
    /* renamed from: d */
    private int f16336d = 0;
    /* renamed from: e */
    private boolean f16337e;
    /* renamed from: f */
    private String f16338f = "";
    /* renamed from: g */
    private int f16339g = -1;

    public static final class Imgs extends MessageMicro {
        public static final int RAW_FIELD_NUMBER = 2;
        public static final int THUMB_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f16309a;
        /* renamed from: b */
        private String f16310b = "";
        /* renamed from: c */
        private boolean f16311c;
        /* renamed from: d */
        private String f16312d = "";
        /* renamed from: e */
        private int f16313e = -1;

        public static Imgs parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Imgs().mergeFrom(codedInputStreamMicro);
        }

        public static Imgs parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Imgs) new Imgs().mergeFrom(bArr);
        }

        public final Imgs clear() {
            clearThumb();
            clearRaw();
            this.f16313e = -1;
            return this;
        }

        public Imgs clearRaw() {
            this.f16311c = false;
            this.f16312d = "";
            return this;
        }

        public Imgs clearThumb() {
            this.f16309a = false;
            this.f16310b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f16313e < 0) {
                getSerializedSize();
            }
            return this.f16313e;
        }

        public String getRaw() {
            return this.f16312d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasThumb()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getThumb());
            }
            if (hasRaw()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getRaw());
            }
            this.f16313e = i;
            return i;
        }

        public String getThumb() {
            return this.f16310b;
        }

        public boolean hasRaw() {
            return this.f16311c;
        }

        public boolean hasThumb() {
            return this.f16309a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Imgs mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public Imgs setRaw(String str) {
            this.f16311c = true;
            this.f16312d = str;
            return this;
        }

        public Imgs setThumb(String str) {
            this.f16309a = true;
            this.f16310b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasThumb()) {
                codedOutputStreamMicro.writeString(1, getThumb());
            }
            if (hasRaw()) {
                codedOutputStreamMicro.writeString(2, getRaw());
            }
        }
    }

    public static final class Pic extends MessageMicro {
        public static final int CITY_NUM_FIELD_NUMBER = 7;
        public static final int DATE_FIELD_NUMBER = 3;
        public static final int DISTANCE_FIELD_NUMBER = 6;
        public static final int IMGS_FIELD_NUMBER = 5;
        public static final int LOGO_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int POINT_NUM_FIELD_NUMBER = 9;
        public static final int PROVINCE_NUM_FIELD_NUMBER = 8;
        public static final int VIEWS_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f16314a;
        /* renamed from: b */
        private String f16315b = "";
        /* renamed from: c */
        private boolean f16316c;
        /* renamed from: d */
        private String f16317d = "";
        /* renamed from: e */
        private boolean f16318e;
        /* renamed from: f */
        private String f16319f = "";
        /* renamed from: g */
        private boolean f16320g;
        /* renamed from: h */
        private int f16321h = 0;
        /* renamed from: i */
        private boolean f16322i;
        /* renamed from: j */
        private Imgs f16323j = null;
        /* renamed from: k */
        private boolean f16324k;
        /* renamed from: l */
        private int f16325l = 0;
        /* renamed from: m */
        private boolean f16326m;
        /* renamed from: n */
        private int f16327n = 0;
        /* renamed from: o */
        private boolean f16328o;
        /* renamed from: p */
        private int f16329p = 0;
        /* renamed from: q */
        private boolean f16330q;
        /* renamed from: r */
        private int f16331r = 0;
        /* renamed from: s */
        private int f16332s = -1;

        public static Pic parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Pic().mergeFrom(codedInputStreamMicro);
        }

        public static Pic parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Pic) new Pic().mergeFrom(bArr);
        }

        public final Pic clear() {
            clearLogo();
            clearName();
            clearDate();
            clearViews();
            clearImgs();
            clearDistance();
            clearCityNum();
            clearProvinceNum();
            clearPointNum();
            this.f16332s = -1;
            return this;
        }

        public Pic clearCityNum() {
            this.f16326m = false;
            this.f16327n = 0;
            return this;
        }

        public Pic clearDate() {
            this.f16318e = false;
            this.f16319f = "";
            return this;
        }

        public Pic clearDistance() {
            this.f16324k = false;
            this.f16325l = 0;
            return this;
        }

        public Pic clearImgs() {
            this.f16322i = false;
            this.f16323j = null;
            return this;
        }

        public Pic clearLogo() {
            this.f16314a = false;
            this.f16315b = "";
            return this;
        }

        public Pic clearName() {
            this.f16316c = false;
            this.f16317d = "";
            return this;
        }

        public Pic clearPointNum() {
            this.f16330q = false;
            this.f16331r = 0;
            return this;
        }

        public Pic clearProvinceNum() {
            this.f16328o = false;
            this.f16329p = 0;
            return this;
        }

        public Pic clearViews() {
            this.f16320g = false;
            this.f16321h = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f16332s < 0) {
                getSerializedSize();
            }
            return this.f16332s;
        }

        public int getCityNum() {
            return this.f16327n;
        }

        public String getDate() {
            return this.f16319f;
        }

        public int getDistance() {
            return this.f16325l;
        }

        public Imgs getImgs() {
            return this.f16323j;
        }

        public String getLogo() {
            return this.f16315b;
        }

        public String getName() {
            return this.f16317d;
        }

        public int getPointNum() {
            return this.f16331r;
        }

        public int getProvinceNum() {
            return this.f16329p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLogo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLogo());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasDate()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getDate());
            }
            if (hasViews()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getViews());
            }
            if (hasImgs()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getImgs());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getDistance());
            }
            if (hasCityNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getCityNum());
            }
            if (hasProvinceNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(8, getProvinceNum());
            }
            if (hasPointNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, getPointNum());
            }
            this.f16332s = i;
            return i;
        }

        public int getViews() {
            return this.f16321h;
        }

        public boolean hasCityNum() {
            return this.f16326m;
        }

        public boolean hasDate() {
            return this.f16318e;
        }

        public boolean hasDistance() {
            return this.f16324k;
        }

        public boolean hasImgs() {
            return this.f16322i;
        }

        public boolean hasLogo() {
            return this.f16314a;
        }

        public boolean hasName() {
            return this.f16316c;
        }

        public boolean hasPointNum() {
            return this.f16330q;
        }

        public boolean hasProvinceNum() {
            return this.f16328o;
        }

        public boolean hasViews() {
            return this.f16320g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Pic mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLogo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setDate(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setViews(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        MessageMicro imgs = new Imgs();
                        codedInputStreamMicro.readMessage(imgs);
                        setImgs(imgs);
                        continue;
                    case 48:
                        setDistance(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setCityNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 64:
                        setProvinceNum(codedInputStreamMicro.readInt32());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setPointNum(codedInputStreamMicro.readInt32());
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

        public Pic setCityNum(int i) {
            this.f16326m = true;
            this.f16327n = i;
            return this;
        }

        public Pic setDate(String str) {
            this.f16318e = true;
            this.f16319f = str;
            return this;
        }

        public Pic setDistance(int i) {
            this.f16324k = true;
            this.f16325l = i;
            return this;
        }

        public Pic setImgs(Imgs imgs) {
            if (imgs == null) {
                return clearImgs();
            }
            this.f16322i = true;
            this.f16323j = imgs;
            return this;
        }

        public Pic setLogo(String str) {
            this.f16314a = true;
            this.f16315b = str;
            return this;
        }

        public Pic setName(String str) {
            this.f16316c = true;
            this.f16317d = str;
            return this;
        }

        public Pic setPointNum(int i) {
            this.f16330q = true;
            this.f16331r = i;
            return this;
        }

        public Pic setProvinceNum(int i) {
            this.f16328o = true;
            this.f16329p = i;
            return this;
        }

        public Pic setViews(int i) {
            this.f16320g = true;
            this.f16321h = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLogo()) {
                codedOutputStreamMicro.writeString(1, getLogo());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasDate()) {
                codedOutputStreamMicro.writeString(3, getDate());
            }
            if (hasViews()) {
                codedOutputStreamMicro.writeInt32(4, getViews());
            }
            if (hasImgs()) {
                codedOutputStreamMicro.writeMessage(5, getImgs());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeInt32(6, getDistance());
            }
            if (hasCityNum()) {
                codedOutputStreamMicro.writeInt32(7, getCityNum());
            }
            if (hasProvinceNum()) {
                codedOutputStreamMicro.writeInt32(8, getProvinceNum());
            }
            if (hasPointNum()) {
                codedOutputStreamMicro.writeInt32(9, getPointNum());
            }
        }
    }

    public static TrackMoments parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TrackMoments().mergeFrom(codedInputStreamMicro);
    }

    public static TrackMoments parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TrackMoments) new TrackMoments().mergeFrom(bArr);
    }

    public TrackMoments addLists(Pic pic) {
        if (pic != null) {
            if (this.f16334b.isEmpty()) {
                this.f16334b = new ArrayList();
            }
            this.f16334b.add(pic);
        }
        return this;
    }

    public TrackMoments addPersonal(Pic pic) {
        if (pic != null) {
            if (this.f16333a.isEmpty()) {
                this.f16333a = new ArrayList();
            }
            this.f16333a.add(pic);
        }
        return this;
    }

    public final TrackMoments clear() {
        clearPersonal();
        clearLists();
        clearTs();
        clearLastSid();
        this.f16339g = -1;
        return this;
    }

    public TrackMoments clearLastSid() {
        this.f16337e = false;
        this.f16338f = "";
        return this;
    }

    public TrackMoments clearLists() {
        this.f16334b = Collections.emptyList();
        return this;
    }

    public TrackMoments clearPersonal() {
        this.f16333a = Collections.emptyList();
        return this;
    }

    public TrackMoments clearTs() {
        this.f16335c = false;
        this.f16336d = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f16339g < 0) {
            getSerializedSize();
        }
        return this.f16339g;
    }

    public String getLastSid() {
        return this.f16338f;
    }

    public Pic getLists(int i) {
        return (Pic) this.f16334b.get(i);
    }

    public int getListsCount() {
        return this.f16334b.size();
    }

    public List<Pic> getListsList() {
        return this.f16334b;
    }

    public Pic getPersonal(int i) {
        return (Pic) this.f16333a.get(i);
    }

    public int getPersonalCount() {
        return this.f16333a.size();
    }

    public List<Pic> getPersonalList() {
        return this.f16333a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Pic computeMessageSize : getPersonalList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        for (Pic computeMessageSize2 : getListsList()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
        }
        if (hasTs()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getTs());
        }
        if (hasLastSid()) {
            i += CodedOutputStreamMicro.computeStringSize(4, getLastSid());
        }
        this.f16339g = i;
        return i;
    }

    public int getTs() {
        return this.f16336d;
    }

    public boolean hasLastSid() {
        return this.f16337e;
    }

    public boolean hasTs() {
        return this.f16335c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TrackMoments mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro pic;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    pic = new Pic();
                    codedInputStreamMicro.readMessage(pic);
                    addPersonal(pic);
                    continue;
                case 18:
                    pic = new Pic();
                    codedInputStreamMicro.readMessage(pic);
                    addLists(pic);
                    continue;
                case 24:
                    setTs(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    setLastSid(codedInputStreamMicro.readString());
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

    public TrackMoments setLastSid(String str) {
        this.f16337e = true;
        this.f16338f = str;
        return this;
    }

    public TrackMoments setLists(int i, Pic pic) {
        if (pic != null) {
            this.f16334b.set(i, pic);
        }
        return this;
    }

    public TrackMoments setPersonal(int i, Pic pic) {
        if (pic != null) {
            this.f16333a.set(i, pic);
        }
        return this;
    }

    public TrackMoments setTs(int i) {
        this.f16335c = true;
        this.f16336d = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Pic writeMessage : getPersonalList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        for (Pic writeMessage2 : getListsList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage2);
        }
        if (hasTs()) {
            codedOutputStreamMicro.writeInt32(3, getTs());
        }
        if (hasLastSid()) {
            codedOutputStreamMicro.writeString(4, getLastSid());
        }
    }
}
