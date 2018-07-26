package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

public final class PoiResult$Contents$Show extends MessageMicro {
    public static final int ADDRESS_FIELD_NUMBER = 1;
    public static final int BOOK_INFO_FIELD_NUMBER = 11;
    public static final int DISTANCE_FIELD_NUMBER = 5;
    public static final int EC_REASON_FIELD_NUMBER = 9;
    public static final int EP_CHAR_FIELD_NUMBER = 8;
    public static final int ICON_FIELD_NUMBER = 4;
    public static final int IMAGE_FIELD_NUMBER = 2;
    public static final int MAP_BUTTON_FIELD_NUMBER = 12;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int OVERALL_RATING_FIELD_NUMBER = 6;
    public static final int PHONE_BUTTON_FIELD_NUMBER = 10;
    public static final int PRICE_FIELD_NUMBER = 7;
    /* renamed from: a */
    private boolean f13982a;
    /* renamed from: b */
    private int f13983b = 0;
    /* renamed from: c */
    private boolean f13984c;
    /* renamed from: d */
    private int f13985d = 0;
    /* renamed from: e */
    private boolean f13986e;
    /* renamed from: f */
    private int f13987f = 0;
    /* renamed from: g */
    private boolean f13988g;
    /* renamed from: h */
    private int f13989h = 0;
    /* renamed from: i */
    private boolean f13990i;
    /* renamed from: j */
    private int f13991j = 0;
    /* renamed from: k */
    private boolean f13992k;
    /* renamed from: l */
    private int f13993l = 0;
    /* renamed from: m */
    private boolean f13994m;
    /* renamed from: n */
    private int f13995n = 0;
    /* renamed from: o */
    private boolean f13996o;
    /* renamed from: p */
    private int f13997p = 0;
    /* renamed from: q */
    private boolean f13998q;
    /* renamed from: r */
    private int f13999r = 0;
    /* renamed from: s */
    private boolean f14000s;
    /* renamed from: t */
    private int f14001t = 0;
    /* renamed from: u */
    private boolean f14002u;
    /* renamed from: v */
    private int f14003v = 0;
    /* renamed from: w */
    private boolean f14004w;
    /* renamed from: x */
    private int f14005x = 0;
    /* renamed from: y */
    private int f14006y = -1;

    public static PoiResult$Contents$Show parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$Contents$Show().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$Contents$Show parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$Contents$Show) new PoiResult$Contents$Show().mergeFrom(bArr);
    }

    public final PoiResult$Contents$Show clear() {
        clearAddress();
        clearImage();
        clearName();
        clearIcon();
        clearDistance();
        clearOverallRating();
        clearPrice();
        clearEpChar();
        clearEcReason();
        clearPhoneButton();
        clearBookInfo();
        clearMapButton();
        this.f14006y = -1;
        return this;
    }

    public PoiResult$Contents$Show clearAddress() {
        this.f13982a = false;
        this.f13983b = 0;
        return this;
    }

    public PoiResult$Contents$Show clearBookInfo() {
        this.f14002u = false;
        this.f14003v = 0;
        return this;
    }

    public PoiResult$Contents$Show clearDistance() {
        this.f13990i = false;
        this.f13991j = 0;
        return this;
    }

    public PoiResult$Contents$Show clearEcReason() {
        this.f13998q = false;
        this.f13999r = 0;
        return this;
    }

    public PoiResult$Contents$Show clearEpChar() {
        this.f13996o = false;
        this.f13997p = 0;
        return this;
    }

    public PoiResult$Contents$Show clearIcon() {
        this.f13988g = false;
        this.f13989h = 0;
        return this;
    }

    public PoiResult$Contents$Show clearImage() {
        this.f13984c = false;
        this.f13985d = 0;
        return this;
    }

    public PoiResult$Contents$Show clearMapButton() {
        this.f14004w = false;
        this.f14005x = 0;
        return this;
    }

    public PoiResult$Contents$Show clearName() {
        this.f13986e = false;
        this.f13987f = 0;
        return this;
    }

    public PoiResult$Contents$Show clearOverallRating() {
        this.f13992k = false;
        this.f13993l = 0;
        return this;
    }

    public PoiResult$Contents$Show clearPhoneButton() {
        this.f14000s = false;
        this.f14001t = 0;
        return this;
    }

    public PoiResult$Contents$Show clearPrice() {
        this.f13994m = false;
        this.f13995n = 0;
        return this;
    }

    public int getAddress() {
        return this.f13983b;
    }

    public int getBookInfo() {
        return this.f14003v;
    }

    public int getCachedSize() {
        if (this.f14006y < 0) {
            getSerializedSize();
        }
        return this.f14006y;
    }

    public int getDistance() {
        return this.f13991j;
    }

    public int getEcReason() {
        return this.f13999r;
    }

    public int getEpChar() {
        return this.f13997p;
    }

    public int getIcon() {
        return this.f13989h;
    }

    public int getImage() {
        return this.f13985d;
    }

    public int getMapButton() {
        return this.f14005x;
    }

    public int getName() {
        return this.f13987f;
    }

    public int getOverallRating() {
        return this.f13993l;
    }

    public int getPhoneButton() {
        return this.f14001t;
    }

    public int getPrice() {
        return this.f13995n;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasAddress()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getAddress());
        }
        if (hasImage()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getImage());
        }
        if (hasName()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getName());
        }
        if (hasIcon()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getIcon());
        }
        if (hasDistance()) {
            i += CodedOutputStreamMicro.computeInt32Size(5, getDistance());
        }
        if (hasOverallRating()) {
            i += CodedOutputStreamMicro.computeInt32Size(6, getOverallRating());
        }
        if (hasPrice()) {
            i += CodedOutputStreamMicro.computeInt32Size(7, getPrice());
        }
        if (hasEpChar()) {
            i += CodedOutputStreamMicro.computeInt32Size(8, getEpChar());
        }
        if (hasEcReason()) {
            i += CodedOutputStreamMicro.computeInt32Size(9, getEcReason());
        }
        if (hasPhoneButton()) {
            i += CodedOutputStreamMicro.computeInt32Size(10, getPhoneButton());
        }
        if (hasBookInfo()) {
            i += CodedOutputStreamMicro.computeInt32Size(11, getBookInfo());
        }
        if (hasMapButton()) {
            i += CodedOutputStreamMicro.computeInt32Size(12, getMapButton());
        }
        this.f14006y = i;
        return i;
    }

    public boolean hasAddress() {
        return this.f13982a;
    }

    public boolean hasBookInfo() {
        return this.f14002u;
    }

    public boolean hasDistance() {
        return this.f13990i;
    }

    public boolean hasEcReason() {
        return this.f13998q;
    }

    public boolean hasEpChar() {
        return this.f13996o;
    }

    public boolean hasIcon() {
        return this.f13988g;
    }

    public boolean hasImage() {
        return this.f13984c;
    }

    public boolean hasMapButton() {
        return this.f14004w;
    }

    public boolean hasName() {
        return this.f13986e;
    }

    public boolean hasOverallRating() {
        return this.f13992k;
    }

    public boolean hasPhoneButton() {
        return this.f14000s;
    }

    public boolean hasPrice() {
        return this.f13994m;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$Contents$Show mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setAddress(codedInputStreamMicro.readInt32());
                    continue;
                case 16:
                    setImage(codedInputStreamMicro.readInt32());
                    continue;
                case 24:
                    setName(codedInputStreamMicro.readInt32());
                    continue;
                case 32:
                    setIcon(codedInputStreamMicro.readInt32());
                    continue;
                case 40:
                    setDistance(codedInputStreamMicro.readInt32());
                    continue;
                case 48:
                    setOverallRating(codedInputStreamMicro.readInt32());
                    continue;
                case 56:
                    setPrice(codedInputStreamMicro.readInt32());
                    continue;
                case 64:
                    setEpChar(codedInputStreamMicro.readInt32());
                    continue;
                case NavCarInfo.CarType_57L /*72*/:
                    setEcReason(codedInputStreamMicro.readInt32());
                    continue;
                case 80:
                    setPhoneButton(codedInputStreamMicro.readInt32());
                    continue;
                case 88:
                    setBookInfo(codedInputStreamMicro.readInt32());
                    continue;
                case 96:
                    setMapButton(codedInputStreamMicro.readInt32());
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

    public PoiResult$Contents$Show setAddress(int i) {
        this.f13982a = true;
        this.f13983b = i;
        return this;
    }

    public PoiResult$Contents$Show setBookInfo(int i) {
        this.f14002u = true;
        this.f14003v = i;
        return this;
    }

    public PoiResult$Contents$Show setDistance(int i) {
        this.f13990i = true;
        this.f13991j = i;
        return this;
    }

    public PoiResult$Contents$Show setEcReason(int i) {
        this.f13998q = true;
        this.f13999r = i;
        return this;
    }

    public PoiResult$Contents$Show setEpChar(int i) {
        this.f13996o = true;
        this.f13997p = i;
        return this;
    }

    public PoiResult$Contents$Show setIcon(int i) {
        this.f13988g = true;
        this.f13989h = i;
        return this;
    }

    public PoiResult$Contents$Show setImage(int i) {
        this.f13984c = true;
        this.f13985d = i;
        return this;
    }

    public PoiResult$Contents$Show setMapButton(int i) {
        this.f14004w = true;
        this.f14005x = i;
        return this;
    }

    public PoiResult$Contents$Show setName(int i) {
        this.f13986e = true;
        this.f13987f = i;
        return this;
    }

    public PoiResult$Contents$Show setOverallRating(int i) {
        this.f13992k = true;
        this.f13993l = i;
        return this;
    }

    public PoiResult$Contents$Show setPhoneButton(int i) {
        this.f14000s = true;
        this.f14001t = i;
        return this;
    }

    public PoiResult$Contents$Show setPrice(int i) {
        this.f13994m = true;
        this.f13995n = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasAddress()) {
            codedOutputStreamMicro.writeInt32(1, getAddress());
        }
        if (hasImage()) {
            codedOutputStreamMicro.writeInt32(2, getImage());
        }
        if (hasName()) {
            codedOutputStreamMicro.writeInt32(3, getName());
        }
        if (hasIcon()) {
            codedOutputStreamMicro.writeInt32(4, getIcon());
        }
        if (hasDistance()) {
            codedOutputStreamMicro.writeInt32(5, getDistance());
        }
        if (hasOverallRating()) {
            codedOutputStreamMicro.writeInt32(6, getOverallRating());
        }
        if (hasPrice()) {
            codedOutputStreamMicro.writeInt32(7, getPrice());
        }
        if (hasEpChar()) {
            codedOutputStreamMicro.writeInt32(8, getEpChar());
        }
        if (hasEcReason()) {
            codedOutputStreamMicro.writeInt32(9, getEcReason());
        }
        if (hasPhoneButton()) {
            codedOutputStreamMicro.writeInt32(10, getPhoneButton());
        }
        if (hasBookInfo()) {
            codedOutputStreamMicro.writeInt32(11, getBookInfo());
        }
        if (hasMapButton()) {
            codedOutputStreamMicro.writeInt32(12, getMapButton());
        }
    }
}
