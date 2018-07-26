package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiResult$IndusInfo extends MessageMicro {
    public static final int AD_POS_FIELD_NUMBER = 4;
    public static final int INDUS_NAME_FIELD_NUMBER = 1;
    public static final int PRIORITY_FIELD_NUMBER = 6;
    public static final int SHOW_NUM_FIELD_NUMBER = 2;
    public static final int USER_COUPON_FIELD_NUMBER = 3;
    /* renamed from: a */
    private boolean f14054a;
    /* renamed from: b */
    private String f14055b = "";
    /* renamed from: c */
    private boolean f14056c;
    /* renamed from: d */
    private int f14057d = 0;
    /* renamed from: e */
    private boolean f14058e;
    /* renamed from: f */
    private UserCoupon f14059f = null;
    /* renamed from: g */
    private boolean f14060g;
    /* renamed from: h */
    private AdPos f14061h = null;
    /* renamed from: i */
    private List<String> f14062i = Collections.emptyList();
    /* renamed from: j */
    private int f14063j = -1;

    /* renamed from: com.baidu.entity.pb.PoiResult$IndusInfo$AdPos */
    public static final class AdPos extends MessageMicro {
        public static final int POSITION_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14042a;
        /* renamed from: b */
        private String f14043b = "";
        /* renamed from: c */
        private int f14044c = -1;

        public static AdPos parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AdPos().mergeFrom(codedInputStreamMicro);
        }

        public static AdPos parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AdPos) new AdPos().mergeFrom(bArr);
        }

        public final AdPos clear() {
            clearPosition();
            this.f14044c = -1;
            return this;
        }

        public AdPos clearPosition() {
            this.f14042a = false;
            this.f14043b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14044c < 0) {
                getSerializedSize();
            }
            return this.f14044c;
        }

        public String getPosition() {
            return this.f14043b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPosition()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPosition());
            }
            this.f14044c = i;
            return i;
        }

        public boolean hasPosition() {
            return this.f14042a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AdPos mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setPosition(codedInputStreamMicro.readString());
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

        public AdPos setPosition(String str) {
            this.f14042a = true;
            this.f14043b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPosition()) {
                codedOutputStreamMicro.writeString(1, getPosition());
            }
        }
    }

    /* renamed from: com.baidu.entity.pb.PoiResult$IndusInfo$UserCoupon */
    public static final class UserCoupon extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 4;
        public static final int POSITION_FIELD_NUMBER = 3;
        public static final int PRICE_FIELD_NUMBER = 2;
        public static final int TEXT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14045a;
        /* renamed from: b */
        private String f14046b = "";
        /* renamed from: c */
        private boolean f14047c;
        /* renamed from: d */
        private String f14048d = "";
        /* renamed from: e */
        private boolean f14049e;
        /* renamed from: f */
        private String f14050f = "";
        /* renamed from: g */
        private boolean f14051g;
        /* renamed from: h */
        private String f14052h = "";
        /* renamed from: i */
        private int f14053i = -1;

        public static UserCoupon parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new UserCoupon().mergeFrom(codedInputStreamMicro);
        }

        public static UserCoupon parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (UserCoupon) new UserCoupon().mergeFrom(bArr);
        }

        public final UserCoupon clear() {
            clearText();
            clearPrice();
            clearPosition();
            clearDesc();
            this.f14053i = -1;
            return this;
        }

        public UserCoupon clearDesc() {
            this.f14051g = false;
            this.f14052h = "";
            return this;
        }

        public UserCoupon clearPosition() {
            this.f14049e = false;
            this.f14050f = "";
            return this;
        }

        public UserCoupon clearPrice() {
            this.f14047c = false;
            this.f14048d = "";
            return this;
        }

        public UserCoupon clearText() {
            this.f14045a = false;
            this.f14046b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14053i < 0) {
                getSerializedSize();
            }
            return this.f14053i;
        }

        public String getDesc() {
            return this.f14052h;
        }

        public String getPosition() {
            return this.f14050f;
        }

        public String getPrice() {
            return this.f14048d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasText()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getText());
            }
            if (hasPrice()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getPrice());
            }
            if (hasPosition()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getPosition());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getDesc());
            }
            this.f14053i = i;
            return i;
        }

        public String getText() {
            return this.f14046b;
        }

        public boolean hasDesc() {
            return this.f14051g;
        }

        public boolean hasPosition() {
            return this.f14049e;
        }

        public boolean hasPrice() {
            return this.f14047c;
        }

        public boolean hasText() {
            return this.f14045a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public UserCoupon mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setText(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setPrice(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setPosition(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setDesc(codedInputStreamMicro.readString());
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

        public UserCoupon setDesc(String str) {
            this.f14051g = true;
            this.f14052h = str;
            return this;
        }

        public UserCoupon setPosition(String str) {
            this.f14049e = true;
            this.f14050f = str;
            return this;
        }

        public UserCoupon setPrice(String str) {
            this.f14047c = true;
            this.f14048d = str;
            return this;
        }

        public UserCoupon setText(String str) {
            this.f14045a = true;
            this.f14046b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasText()) {
                codedOutputStreamMicro.writeString(1, getText());
            }
            if (hasPrice()) {
                codedOutputStreamMicro.writeString(2, getPrice());
            }
            if (hasPosition()) {
                codedOutputStreamMicro.writeString(3, getPosition());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(4, getDesc());
            }
        }
    }

    public static PoiResult$IndusInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiResult$IndusInfo().mergeFrom(codedInputStreamMicro);
    }

    public static PoiResult$IndusInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiResult$IndusInfo) new PoiResult$IndusInfo().mergeFrom(bArr);
    }

    public PoiResult$IndusInfo addPriority(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (this.f14062i.isEmpty()) {
            this.f14062i = new ArrayList();
        }
        this.f14062i.add(str);
        return this;
    }

    public final PoiResult$IndusInfo clear() {
        clearIndusName();
        clearShowNum();
        clearUserCoupon();
        clearAdPos();
        clearPriority();
        this.f14063j = -1;
        return this;
    }

    public PoiResult$IndusInfo clearAdPos() {
        this.f14060g = false;
        this.f14061h = null;
        return this;
    }

    public PoiResult$IndusInfo clearIndusName() {
        this.f14054a = false;
        this.f14055b = "";
        return this;
    }

    public PoiResult$IndusInfo clearPriority() {
        this.f14062i = Collections.emptyList();
        return this;
    }

    public PoiResult$IndusInfo clearShowNum() {
        this.f14056c = false;
        this.f14057d = 0;
        return this;
    }

    public PoiResult$IndusInfo clearUserCoupon() {
        this.f14058e = false;
        this.f14059f = null;
        return this;
    }

    public AdPos getAdPos() {
        return this.f14061h;
    }

    public int getCachedSize() {
        if (this.f14063j < 0) {
            getSerializedSize();
        }
        return this.f14063j;
    }

    public String getIndusName() {
        return this.f14055b;
    }

    public String getPriority(int i) {
        return (String) this.f14062i.get(i);
    }

    public int getPriorityCount() {
        return this.f14062i.size();
    }

    public List<String> getPriorityList() {
        return this.f14062i;
    }

    public int getSerializedSize() {
        int i = 0;
        int computeStringSize = hasIndusName() ? CodedOutputStreamMicro.computeStringSize(1, getIndusName()) + 0 : 0;
        if (hasShowNum()) {
            computeStringSize += CodedOutputStreamMicro.computeInt32Size(2, getShowNum());
        }
        if (hasUserCoupon()) {
            computeStringSize += CodedOutputStreamMicro.computeMessageSize(3, getUserCoupon());
        }
        int computeMessageSize = hasAdPos() ? computeStringSize + CodedOutputStreamMicro.computeMessageSize(4, getAdPos()) : computeStringSize;
        for (String computeStringSizeNoTag : getPriorityList()) {
            i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
        }
        computeStringSize = (computeMessageSize + i) + (getPriorityList().size() * 1);
        this.f14063j = computeStringSize;
        return computeStringSize;
    }

    public int getShowNum() {
        return this.f14057d;
    }

    public UserCoupon getUserCoupon() {
        return this.f14059f;
    }

    public boolean hasAdPos() {
        return this.f14060g;
    }

    public boolean hasIndusName() {
        return this.f14054a;
    }

    public boolean hasShowNum() {
        return this.f14056c;
    }

    public boolean hasUserCoupon() {
        return this.f14058e;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiResult$IndusInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro userCoupon;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setIndusName(codedInputStreamMicro.readString());
                    continue;
                case 16:
                    setShowNum(codedInputStreamMicro.readInt32());
                    continue;
                case 26:
                    userCoupon = new UserCoupon();
                    codedInputStreamMicro.readMessage(userCoupon);
                    setUserCoupon(userCoupon);
                    continue;
                case 34:
                    userCoupon = new AdPos();
                    codedInputStreamMicro.readMessage(userCoupon);
                    setAdPos(userCoupon);
                    continue;
                case 50:
                    addPriority(codedInputStreamMicro.readString());
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

    public PoiResult$IndusInfo setAdPos(AdPos adPos) {
        if (adPos == null) {
            return clearAdPos();
        }
        this.f14060g = true;
        this.f14061h = adPos;
        return this;
    }

    public PoiResult$IndusInfo setIndusName(String str) {
        this.f14054a = true;
        this.f14055b = str;
        return this;
    }

    public PoiResult$IndusInfo setPriority(int i, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f14062i.set(i, str);
        return this;
    }

    public PoiResult$IndusInfo setShowNum(int i) {
        this.f14056c = true;
        this.f14057d = i;
        return this;
    }

    public PoiResult$IndusInfo setUserCoupon(UserCoupon userCoupon) {
        if (userCoupon == null) {
            return clearUserCoupon();
        }
        this.f14058e = true;
        this.f14059f = userCoupon;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasIndusName()) {
            codedOutputStreamMicro.writeString(1, getIndusName());
        }
        if (hasShowNum()) {
            codedOutputStreamMicro.writeInt32(2, getShowNum());
        }
        if (hasUserCoupon()) {
            codedOutputStreamMicro.writeMessage(3, getUserCoupon());
        }
        if (hasAdPos()) {
            codedOutputStreamMicro.writeMessage(4, getAdPos());
        }
        for (String writeString : getPriorityList()) {
            codedOutputStreamMicro.writeString(6, writeString);
        }
    }
}
