package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShopMenu extends MessageMicro {
    public static final int CONTENT_FIELD_NUMBER = 2;
    public static final int OPTION_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f14637a;
    /* renamed from: b */
    private Option f14638b = null;
    /* renamed from: c */
    private boolean f14639c;
    /* renamed from: d */
    private Content f14640d = null;
    /* renamed from: e */
    private int f14641e = -1;

    public static final class Content extends MessageMicro {
        public static final int AVERAGE_TIME_FIELD_NUMBER = 7;
        public static final int BUSSINESS_HOURS_FIELD_NUMBER = 4;
        public static final int BUSSINESS_STATUS_FIELD_NUMBER = 3;
        public static final int COUPON_INFO_FIELD_NUMBER = 9;
        public static final int RELEASE_ID_FIELD_NUMBER = 1;
        public static final int SHOP_NAME_FIELD_NUMBER = 2;
        public static final int SOURCE_INFO_FIELD_NUMBER = 10;
        public static final int TAKEOUT_COST_FIELD_NUMBER = 6;
        public static final int TAKEOUT_MENU_FIELD_NUMBER = 8;
        public static final int TAKEOUT_PRICE_FIELD_NUMBER = 5;
        /* renamed from: a */
        private List<BussinessHours> f14613a = Collections.emptyList();
        /* renamed from: b */
        private List<TakeoutMenu> f14614b = Collections.emptyList();
        /* renamed from: c */
        private boolean f14615c;
        /* renamed from: d */
        private CouponInfo f14616d = null;
        /* renamed from: e */
        private boolean f14617e;
        /* renamed from: f */
        private String f14618f = "";
        /* renamed from: g */
        private boolean f14619g;
        /* renamed from: h */
        private String f14620h = "";
        /* renamed from: i */
        private boolean f14621i;
        /* renamed from: j */
        private int f14622j = 0;
        /* renamed from: k */
        private boolean f14623k;
        /* renamed from: l */
        private String f14624l = "";
        /* renamed from: m */
        private boolean f14625m;
        /* renamed from: n */
        private String f14626n = "";
        /* renamed from: o */
        private boolean f14627o;
        /* renamed from: p */
        private String f14628p = "";
        /* renamed from: q */
        private boolean f14629q;
        /* renamed from: r */
        private SourceInfo f14630r = null;
        /* renamed from: s */
        private int f14631s = -1;

        public static final class BussinessHours extends MessageMicro {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14557a;
            /* renamed from: b */
            private String f14558b = "";
            /* renamed from: c */
            private boolean f14559c;
            /* renamed from: d */
            private String f14560d = "";
            /* renamed from: e */
            private int f14561e = -1;

            public static BussinessHours parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new BussinessHours().mergeFrom(codedInputStreamMicro);
            }

            public static BussinessHours parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (BussinessHours) new BussinessHours().mergeFrom(bArr);
            }

            public final BussinessHours clear() {
                clearStart();
                clearEnd();
                this.f14561e = -1;
                return this;
            }

            public BussinessHours clearEnd() {
                this.f14559c = false;
                this.f14560d = "";
                return this;
            }

            public BussinessHours clearStart() {
                this.f14557a = false;
                this.f14558b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14561e < 0) {
                    getSerializedSize();
                }
                return this.f14561e;
            }

            public String getEnd() {
                return this.f14560d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasStart()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStart());
                }
                if (hasEnd()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getEnd());
                }
                this.f14561e = i;
                return i;
            }

            public String getStart() {
                return this.f14558b;
            }

            public boolean hasEnd() {
                return this.f14559c;
            }

            public boolean hasStart() {
                return this.f14557a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public BussinessHours mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setStart(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setEnd(codedInputStreamMicro.readString());
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

            public BussinessHours setEnd(String str) {
                this.f14559c = true;
                this.f14560d = str;
                return this;
            }

            public BussinessHours setStart(String str) {
                this.f14557a = true;
                this.f14558b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasStart()) {
                    codedOutputStreamMicro.writeString(1, getStart());
                }
                if (hasEnd()) {
                    codedOutputStreamMicro.writeString(2, getEnd());
                }
            }
        }

        public static final class CouponInfo extends MessageMicro {
            public static final int COUPON_MSG_FIELD_NUMBER = 2;
            public static final int SUPPORT_COUPON_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f14562a;
            /* renamed from: b */
            private int f14563b = 0;
            /* renamed from: c */
            private boolean f14564c;
            /* renamed from: d */
            private String f14565d = "";
            /* renamed from: e */
            private int f14566e = -1;

            public static CouponInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new CouponInfo().mergeFrom(codedInputStreamMicro);
            }

            public static CouponInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (CouponInfo) new CouponInfo().mergeFrom(bArr);
            }

            public final CouponInfo clear() {
                clearSupportCoupon();
                clearCouponMsg();
                this.f14566e = -1;
                return this;
            }

            public CouponInfo clearCouponMsg() {
                this.f14564c = false;
                this.f14565d = "";
                return this;
            }

            public CouponInfo clearSupportCoupon() {
                this.f14562a = false;
                this.f14563b = 0;
                return this;
            }

            public int getCachedSize() {
                if (this.f14566e < 0) {
                    getSerializedSize();
                }
                return this.f14566e;
            }

            public String getCouponMsg() {
                return this.f14565d;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasSupportCoupon()) {
                    i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getSupportCoupon());
                }
                if (hasCouponMsg()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCouponMsg());
                }
                this.f14566e = i;
                return i;
            }

            public int getSupportCoupon() {
                return this.f14563b;
            }

            public boolean hasCouponMsg() {
                return this.f14564c;
            }

            public boolean hasSupportCoupon() {
                return this.f14562a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public CouponInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            setSupportCoupon(codedInputStreamMicro.readInt32());
                            continue;
                        case 18:
                            setCouponMsg(codedInputStreamMicro.readString());
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

            public CouponInfo setCouponMsg(String str) {
                this.f14564c = true;
                this.f14565d = str;
                return this;
            }

            public CouponInfo setSupportCoupon(int i) {
                this.f14562a = true;
                this.f14563b = i;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasSupportCoupon()) {
                    codedOutputStreamMicro.writeInt32(1, getSupportCoupon());
                }
                if (hasCouponMsg()) {
                    codedOutputStreamMicro.writeString(2, getCouponMsg());
                }
            }
        }

        public static final class SourceInfo extends MessageMicro {
            public static final int SOURCE_LOGO_URL_FIELD_NUMBER = 2;
            public static final int SOURCE_NAME_FIELD_NUMBER = 1;
            public static final int SOURCE_URL_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f14567a;
            /* renamed from: b */
            private String f14568b = "";
            /* renamed from: c */
            private boolean f14569c;
            /* renamed from: d */
            private String f14570d = "";
            /* renamed from: e */
            private boolean f14571e;
            /* renamed from: f */
            private String f14572f = "";
            /* renamed from: g */
            private int f14573g = -1;

            public static SourceInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new SourceInfo().mergeFrom(codedInputStreamMicro);
            }

            public static SourceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (SourceInfo) new SourceInfo().mergeFrom(bArr);
            }

            public final SourceInfo clear() {
                clearSourceName();
                clearSourceLogoUrl();
                clearSourceUrl();
                this.f14573g = -1;
                return this;
            }

            public SourceInfo clearSourceLogoUrl() {
                this.f14569c = false;
                this.f14570d = "";
                return this;
            }

            public SourceInfo clearSourceName() {
                this.f14567a = false;
                this.f14568b = "";
                return this;
            }

            public SourceInfo clearSourceUrl() {
                this.f14571e = false;
                this.f14572f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f14573g < 0) {
                    getSerializedSize();
                }
                return this.f14573g;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasSourceName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSourceName());
                }
                if (hasSourceLogoUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getSourceLogoUrl());
                }
                if (hasSourceUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getSourceUrl());
                }
                this.f14573g = i;
                return i;
            }

            public String getSourceLogoUrl() {
                return this.f14570d;
            }

            public String getSourceName() {
                return this.f14568b;
            }

            public String getSourceUrl() {
                return this.f14572f;
            }

            public boolean hasSourceLogoUrl() {
                return this.f14569c;
            }

            public boolean hasSourceName() {
                return this.f14567a;
            }

            public boolean hasSourceUrl() {
                return this.f14571e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public SourceInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setSourceName(codedInputStreamMicro.readString());
                            continue;
                        case 18:
                            setSourceLogoUrl(codedInputStreamMicro.readString());
                            continue;
                        case 26:
                            setSourceUrl(codedInputStreamMicro.readString());
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

            public SourceInfo setSourceLogoUrl(String str) {
                this.f14569c = true;
                this.f14570d = str;
                return this;
            }

            public SourceInfo setSourceName(String str) {
                this.f14567a = true;
                this.f14568b = str;
                return this;
            }

            public SourceInfo setSourceUrl(String str) {
                this.f14571e = true;
                this.f14572f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasSourceName()) {
                    codedOutputStreamMicro.writeString(1, getSourceName());
                }
                if (hasSourceLogoUrl()) {
                    codedOutputStreamMicro.writeString(2, getSourceLogoUrl());
                }
                if (hasSourceUrl()) {
                    codedOutputStreamMicro.writeString(3, getSourceUrl());
                }
            }
        }

        public static final class TakeoutMenu extends MessageMicro {
            public static final int CATALOG_FIELD_NUMBER = 2;
            public static final int DATA_FIELD_NUMBER = 1;
            /* renamed from: a */
            private List<Data> f14609a = Collections.emptyList();
            /* renamed from: b */
            private boolean f14610b;
            /* renamed from: c */
            private String f14611c = "";
            /* renamed from: d */
            private int f14612d = -1;

            public static final class Data extends MessageMicro {
                public static final int AVAILABLE_TIMES_FIELD_NUMBER = 13;
                public static final int CURRENT_PRICE_FIELD_NUMBER = 3;
                public static final int DESCRIPTION_FIELD_NUMBER = 10;
                public static final int ITEM_ID_FIELD_NUMBER = 1;
                public static final int LEFT_NUM_FIELD_NUMBER = 11;
                public static final int MIN_ORDER_NUMBER_FIELD_NUMBER = 4;
                public static final int NAME_FIELD_NUMBER = 2;
                public static final int ON_SALE_FIELD_NUMBER = 12;
                public static final int PACKGE_BOX_NUM_FIELD_NUMBER = 6;
                public static final int PACKGE_BOX_PRICE_FIELD_NUMBER = 5;
                public static final int SALED_FIELD_NUMBER = 8;
                public static final int SALED_OUT_FIELD_NUMBER = 7;
                public static final int URL_FIELD_NUMBER = 9;
                /* renamed from: a */
                private boolean f14583a;
                /* renamed from: b */
                private String f14584b = "";
                /* renamed from: c */
                private boolean f14585c;
                /* renamed from: d */
                private String f14586d = "";
                /* renamed from: e */
                private boolean f14587e;
                /* renamed from: f */
                private String f14588f = "";
                /* renamed from: g */
                private boolean f14589g;
                /* renamed from: h */
                private String f14590h = "";
                /* renamed from: i */
                private boolean f14591i;
                /* renamed from: j */
                private String f14592j = "";
                /* renamed from: k */
                private boolean f14593k;
                /* renamed from: l */
                private String f14594l = "";
                /* renamed from: m */
                private boolean f14595m;
                /* renamed from: n */
                private String f14596n = "";
                /* renamed from: o */
                private boolean f14597o;
                /* renamed from: p */
                private int f14598p = 0;
                /* renamed from: q */
                private boolean f14599q;
                /* renamed from: r */
                private String f14600r = "";
                /* renamed from: s */
                private boolean f14601s;
                /* renamed from: t */
                private String f14602t = "";
                /* renamed from: u */
                private boolean f14603u;
                /* renamed from: v */
                private int f14604v = 0;
                /* renamed from: w */
                private boolean f14605w;
                /* renamed from: x */
                private int f14606x = 0;
                /* renamed from: y */
                private List<AvailableTimes> f14607y = Collections.emptyList();
                /* renamed from: z */
                private int f14608z = -1;

                public static final class AvailableTimes extends MessageMicro {
                    public static final int INDEX_FIELD_NUMBER = 1;
                    public static final int TIMES_FIELD_NUMBER = 2;
                    /* renamed from: a */
                    private boolean f14579a;
                    /* renamed from: b */
                    private String f14580b = "";
                    /* renamed from: c */
                    private List<Times> f14581c = Collections.emptyList();
                    /* renamed from: d */
                    private int f14582d = -1;

                    public static final class Times extends MessageMicro {
                        public static final int END_TIME_FIELD_NUMBER = 2;
                        public static final int START_TIME_FIELD_NUMBER = 1;
                        /* renamed from: a */
                        private boolean f14574a;
                        /* renamed from: b */
                        private String f14575b = "";
                        /* renamed from: c */
                        private boolean f14576c;
                        /* renamed from: d */
                        private String f14577d = "";
                        /* renamed from: e */
                        private int f14578e = -1;

                        public static Times parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            return new Times().mergeFrom(codedInputStreamMicro);
                        }

                        public static Times parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                            return (Times) new Times().mergeFrom(bArr);
                        }

                        public final Times clear() {
                            clearStartTime();
                            clearEndTime();
                            this.f14578e = -1;
                            return this;
                        }

                        public Times clearEndTime() {
                            this.f14576c = false;
                            this.f14577d = "";
                            return this;
                        }

                        public Times clearStartTime() {
                            this.f14574a = false;
                            this.f14575b = "";
                            return this;
                        }

                        public int getCachedSize() {
                            if (this.f14578e < 0) {
                                getSerializedSize();
                            }
                            return this.f14578e;
                        }

                        public String getEndTime() {
                            return this.f14577d;
                        }

                        public int getSerializedSize() {
                            int i = 0;
                            if (hasStartTime()) {
                                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartTime());
                            }
                            if (hasEndTime()) {
                                i += CodedOutputStreamMicro.computeStringSize(2, getEndTime());
                            }
                            this.f14578e = i;
                            return i;
                        }

                        public String getStartTime() {
                            return this.f14575b;
                        }

                        public boolean hasEndTime() {
                            return this.f14576c;
                        }

                        public boolean hasStartTime() {
                            return this.f14574a;
                        }

                        public final boolean isInitialized() {
                            return true;
                        }

                        public Times mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                            while (true) {
                                int readTag = codedInputStreamMicro.readTag();
                                switch (readTag) {
                                    case 0:
                                        break;
                                    case 10:
                                        setStartTime(codedInputStreamMicro.readString());
                                        continue;
                                    case 18:
                                        setEndTime(codedInputStreamMicro.readString());
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

                        public Times setEndTime(String str) {
                            this.f14576c = true;
                            this.f14577d = str;
                            return this;
                        }

                        public Times setStartTime(String str) {
                            this.f14574a = true;
                            this.f14575b = str;
                            return this;
                        }

                        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                            if (hasStartTime()) {
                                codedOutputStreamMicro.writeString(1, getStartTime());
                            }
                            if (hasEndTime()) {
                                codedOutputStreamMicro.writeString(2, getEndTime());
                            }
                        }
                    }

                    public static AvailableTimes parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new AvailableTimes().mergeFrom(codedInputStreamMicro);
                    }

                    public static AvailableTimes parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (AvailableTimes) new AvailableTimes().mergeFrom(bArr);
                    }

                    public AvailableTimes addTimes(Times times) {
                        if (times != null) {
                            if (this.f14581c.isEmpty()) {
                                this.f14581c = new ArrayList();
                            }
                            this.f14581c.add(times);
                        }
                        return this;
                    }

                    public final AvailableTimes clear() {
                        clearIndex();
                        clearTimes();
                        this.f14582d = -1;
                        return this;
                    }

                    public AvailableTimes clearIndex() {
                        this.f14579a = false;
                        this.f14580b = "";
                        return this;
                    }

                    public AvailableTimes clearTimes() {
                        this.f14581c = Collections.emptyList();
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f14582d < 0) {
                            getSerializedSize();
                        }
                        return this.f14582d;
                    }

                    public String getIndex() {
                        return this.f14580b;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasIndex()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIndex());
                        }
                        int i2 = i;
                        for (Times computeMessageSize : getTimesList()) {
                            i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
                        }
                        this.f14582d = i2;
                        return i2;
                    }

                    public Times getTimes(int i) {
                        return (Times) this.f14581c.get(i);
                    }

                    public int getTimesCount() {
                        return this.f14581c.size();
                    }

                    public List<Times> getTimesList() {
                        return this.f14581c;
                    }

                    public boolean hasIndex() {
                        return this.f14579a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public AvailableTimes mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        while (true) {
                            int readTag = codedInputStreamMicro.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    setIndex(codedInputStreamMicro.readString());
                                    continue;
                                case 18:
                                    MessageMicro times = new Times();
                                    codedInputStreamMicro.readMessage(times);
                                    addTimes(times);
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

                    public AvailableTimes setIndex(String str) {
                        this.f14579a = true;
                        this.f14580b = str;
                        return this;
                    }

                    public AvailableTimes setTimes(int i, Times times) {
                        if (times != null) {
                            this.f14581c.set(i, times);
                        }
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasIndex()) {
                            codedOutputStreamMicro.writeString(1, getIndex());
                        }
                        for (Times writeMessage : getTimesList()) {
                            codedOutputStreamMicro.writeMessage(2, writeMessage);
                        }
                    }
                }

                public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Data().mergeFrom(codedInputStreamMicro);
                }

                public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Data) new Data().mergeFrom(bArr);
                }

                public Data addAvailableTimes(AvailableTimes availableTimes) {
                    if (availableTimes != null) {
                        if (this.f14607y.isEmpty()) {
                            this.f14607y = new ArrayList();
                        }
                        this.f14607y.add(availableTimes);
                    }
                    return this;
                }

                public final Data clear() {
                    clearItemId();
                    clearName();
                    clearCurrentPrice();
                    clearMinOrderNumber();
                    clearPackgeBoxPrice();
                    clearPackgeBoxNum();
                    clearSaledOut();
                    clearSaled();
                    clearUrl();
                    clearDescription();
                    clearLeftNum();
                    clearOnSale();
                    clearAvailableTimes();
                    this.f14608z = -1;
                    return this;
                }

                public Data clearAvailableTimes() {
                    this.f14607y = Collections.emptyList();
                    return this;
                }

                public Data clearCurrentPrice() {
                    this.f14587e = false;
                    this.f14588f = "";
                    return this;
                }

                public Data clearDescription() {
                    this.f14601s = false;
                    this.f14602t = "";
                    return this;
                }

                public Data clearItemId() {
                    this.f14583a = false;
                    this.f14584b = "";
                    return this;
                }

                public Data clearLeftNum() {
                    this.f14603u = false;
                    this.f14604v = 0;
                    return this;
                }

                public Data clearMinOrderNumber() {
                    this.f14589g = false;
                    this.f14590h = "";
                    return this;
                }

                public Data clearName() {
                    this.f14585c = false;
                    this.f14586d = "";
                    return this;
                }

                public Data clearOnSale() {
                    this.f14605w = false;
                    this.f14606x = 0;
                    return this;
                }

                public Data clearPackgeBoxNum() {
                    this.f14593k = false;
                    this.f14594l = "";
                    return this;
                }

                public Data clearPackgeBoxPrice() {
                    this.f14591i = false;
                    this.f14592j = "";
                    return this;
                }

                public Data clearSaled() {
                    this.f14597o = false;
                    this.f14598p = 0;
                    return this;
                }

                public Data clearSaledOut() {
                    this.f14595m = false;
                    this.f14596n = "";
                    return this;
                }

                public Data clearUrl() {
                    this.f14599q = false;
                    this.f14600r = "";
                    return this;
                }

                public AvailableTimes getAvailableTimes(int i) {
                    return (AvailableTimes) this.f14607y.get(i);
                }

                public int getAvailableTimesCount() {
                    return this.f14607y.size();
                }

                public List<AvailableTimes> getAvailableTimesList() {
                    return this.f14607y;
                }

                public int getCachedSize() {
                    if (this.f14608z < 0) {
                        getSerializedSize();
                    }
                    return this.f14608z;
                }

                public String getCurrentPrice() {
                    return this.f14588f;
                }

                public String getDescription() {
                    return this.f14602t;
                }

                public String getItemId() {
                    return this.f14584b;
                }

                public int getLeftNum() {
                    return this.f14604v;
                }

                public String getMinOrderNumber() {
                    return this.f14590h;
                }

                public String getName() {
                    return this.f14586d;
                }

                public int getOnSale() {
                    return this.f14606x;
                }

                public String getPackgeBoxNum() {
                    return this.f14594l;
                }

                public String getPackgeBoxPrice() {
                    return this.f14592j;
                }

                public int getSaled() {
                    return this.f14598p;
                }

                public String getSaledOut() {
                    return this.f14596n;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasItemId()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getItemId());
                    }
                    if (hasName()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getName());
                    }
                    if (hasCurrentPrice()) {
                        i += CodedOutputStreamMicro.computeStringSize(3, getCurrentPrice());
                    }
                    if (hasMinOrderNumber()) {
                        i += CodedOutputStreamMicro.computeStringSize(4, getMinOrderNumber());
                    }
                    if (hasPackgeBoxPrice()) {
                        i += CodedOutputStreamMicro.computeStringSize(5, getPackgeBoxPrice());
                    }
                    if (hasPackgeBoxNum()) {
                        i += CodedOutputStreamMicro.computeStringSize(6, getPackgeBoxNum());
                    }
                    if (hasSaledOut()) {
                        i += CodedOutputStreamMicro.computeStringSize(7, getSaledOut());
                    }
                    if (hasSaled()) {
                        i += CodedOutputStreamMicro.computeInt32Size(8, getSaled());
                    }
                    if (hasUrl()) {
                        i += CodedOutputStreamMicro.computeStringSize(9, getUrl());
                    }
                    if (hasDescription()) {
                        i += CodedOutputStreamMicro.computeStringSize(10, getDescription());
                    }
                    if (hasLeftNum()) {
                        i += CodedOutputStreamMicro.computeInt32Size(11, getLeftNum());
                    }
                    if (hasOnSale()) {
                        i += CodedOutputStreamMicro.computeInt32Size(12, getOnSale());
                    }
                    int i2 = i;
                    for (AvailableTimes computeMessageSize : getAvailableTimesList()) {
                        i2 = CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize) + i2;
                    }
                    this.f14608z = i2;
                    return i2;
                }

                public String getUrl() {
                    return this.f14600r;
                }

                public boolean hasCurrentPrice() {
                    return this.f14587e;
                }

                public boolean hasDescription() {
                    return this.f14601s;
                }

                public boolean hasItemId() {
                    return this.f14583a;
                }

                public boolean hasLeftNum() {
                    return this.f14603u;
                }

                public boolean hasMinOrderNumber() {
                    return this.f14589g;
                }

                public boolean hasName() {
                    return this.f14585c;
                }

                public boolean hasOnSale() {
                    return this.f14605w;
                }

                public boolean hasPackgeBoxNum() {
                    return this.f14593k;
                }

                public boolean hasPackgeBoxPrice() {
                    return this.f14591i;
                }

                public boolean hasSaled() {
                    return this.f14597o;
                }

                public boolean hasSaledOut() {
                    return this.f14595m;
                }

                public boolean hasUrl() {
                    return this.f14599q;
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
                            case 10:
                                setItemId(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setName(codedInputStreamMicro.readString());
                                continue;
                            case 26:
                                setCurrentPrice(codedInputStreamMicro.readString());
                                continue;
                            case 34:
                                setMinOrderNumber(codedInputStreamMicro.readString());
                                continue;
                            case 42:
                                setPackgeBoxPrice(codedInputStreamMicro.readString());
                                continue;
                            case 50:
                                setPackgeBoxNum(codedInputStreamMicro.readString());
                                continue;
                            case 58:
                                setSaledOut(codedInputStreamMicro.readString());
                                continue;
                            case 64:
                                setSaled(codedInputStreamMicro.readInt32());
                                continue;
                            case 74:
                                setUrl(codedInputStreamMicro.readString());
                                continue;
                            case 82:
                                setDescription(codedInputStreamMicro.readString());
                                continue;
                            case 88:
                                setLeftNum(codedInputStreamMicro.readInt32());
                                continue;
                            case 96:
                                setOnSale(codedInputStreamMicro.readInt32());
                                continue;
                            case 106:
                                MessageMicro availableTimes = new AvailableTimes();
                                codedInputStreamMicro.readMessage(availableTimes);
                                addAvailableTimes(availableTimes);
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

                public Data setAvailableTimes(int i, AvailableTimes availableTimes) {
                    if (availableTimes != null) {
                        this.f14607y.set(i, availableTimes);
                    }
                    return this;
                }

                public Data setCurrentPrice(String str) {
                    this.f14587e = true;
                    this.f14588f = str;
                    return this;
                }

                public Data setDescription(String str) {
                    this.f14601s = true;
                    this.f14602t = str;
                    return this;
                }

                public Data setItemId(String str) {
                    this.f14583a = true;
                    this.f14584b = str;
                    return this;
                }

                public Data setLeftNum(int i) {
                    this.f14603u = true;
                    this.f14604v = i;
                    return this;
                }

                public Data setMinOrderNumber(String str) {
                    this.f14589g = true;
                    this.f14590h = str;
                    return this;
                }

                public Data setName(String str) {
                    this.f14585c = true;
                    this.f14586d = str;
                    return this;
                }

                public Data setOnSale(int i) {
                    this.f14605w = true;
                    this.f14606x = i;
                    return this;
                }

                public Data setPackgeBoxNum(String str) {
                    this.f14593k = true;
                    this.f14594l = str;
                    return this;
                }

                public Data setPackgeBoxPrice(String str) {
                    this.f14591i = true;
                    this.f14592j = str;
                    return this;
                }

                public Data setSaled(int i) {
                    this.f14597o = true;
                    this.f14598p = i;
                    return this;
                }

                public Data setSaledOut(String str) {
                    this.f14595m = true;
                    this.f14596n = str;
                    return this;
                }

                public Data setUrl(String str) {
                    this.f14599q = true;
                    this.f14600r = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasItemId()) {
                        codedOutputStreamMicro.writeString(1, getItemId());
                    }
                    if (hasName()) {
                        codedOutputStreamMicro.writeString(2, getName());
                    }
                    if (hasCurrentPrice()) {
                        codedOutputStreamMicro.writeString(3, getCurrentPrice());
                    }
                    if (hasMinOrderNumber()) {
                        codedOutputStreamMicro.writeString(4, getMinOrderNumber());
                    }
                    if (hasPackgeBoxPrice()) {
                        codedOutputStreamMicro.writeString(5, getPackgeBoxPrice());
                    }
                    if (hasPackgeBoxNum()) {
                        codedOutputStreamMicro.writeString(6, getPackgeBoxNum());
                    }
                    if (hasSaledOut()) {
                        codedOutputStreamMicro.writeString(7, getSaledOut());
                    }
                    if (hasSaled()) {
                        codedOutputStreamMicro.writeInt32(8, getSaled());
                    }
                    if (hasUrl()) {
                        codedOutputStreamMicro.writeString(9, getUrl());
                    }
                    if (hasDescription()) {
                        codedOutputStreamMicro.writeString(10, getDescription());
                    }
                    if (hasLeftNum()) {
                        codedOutputStreamMicro.writeInt32(11, getLeftNum());
                    }
                    if (hasOnSale()) {
                        codedOutputStreamMicro.writeInt32(12, getOnSale());
                    }
                    for (AvailableTimes writeMessage : getAvailableTimesList()) {
                        codedOutputStreamMicro.writeMessage(13, writeMessage);
                    }
                }
            }

            public static TakeoutMenu parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new TakeoutMenu().mergeFrom(codedInputStreamMicro);
            }

            public static TakeoutMenu parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (TakeoutMenu) new TakeoutMenu().mergeFrom(bArr);
            }

            public TakeoutMenu addData(Data data) {
                if (data != null) {
                    if (this.f14609a.isEmpty()) {
                        this.f14609a = new ArrayList();
                    }
                    this.f14609a.add(data);
                }
                return this;
            }

            public final TakeoutMenu clear() {
                clearData();
                clearCatalog();
                this.f14612d = -1;
                return this;
            }

            public TakeoutMenu clearCatalog() {
                this.f14610b = false;
                this.f14611c = "";
                return this;
            }

            public TakeoutMenu clearData() {
                this.f14609a = Collections.emptyList();
                return this;
            }

            public int getCachedSize() {
                if (this.f14612d < 0) {
                    getSerializedSize();
                }
                return this.f14612d;
            }

            public String getCatalog() {
                return this.f14611c;
            }

            public Data getData(int i) {
                return (Data) this.f14609a.get(i);
            }

            public int getDataCount() {
                return this.f14609a.size();
            }

            public List<Data> getDataList() {
                return this.f14609a;
            }

            public int getSerializedSize() {
                int i = 0;
                for (Data computeMessageSize : getDataList()) {
                    i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
                }
                if (hasCatalog()) {
                    i += CodedOutputStreamMicro.computeStringSize(2, getCatalog());
                }
                this.f14612d = i;
                return i;
            }

            public boolean hasCatalog() {
                return this.f14610b;
            }

            public final boolean isInitialized() {
                return true;
            }

            public TakeoutMenu mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            MessageMicro data = new Data();
                            codedInputStreamMicro.readMessage(data);
                            addData(data);
                            continue;
                        case 18:
                            setCatalog(codedInputStreamMicro.readString());
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

            public TakeoutMenu setCatalog(String str) {
                this.f14610b = true;
                this.f14611c = str;
                return this;
            }

            public TakeoutMenu setData(int i, Data data) {
                if (data != null) {
                    this.f14609a.set(i, data);
                }
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                for (Data writeMessage : getDataList()) {
                    codedOutputStreamMicro.writeMessage(1, writeMessage);
                }
                if (hasCatalog()) {
                    codedOutputStreamMicro.writeString(2, getCatalog());
                }
            }
        }

        public static Content parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Content().mergeFrom(codedInputStreamMicro);
        }

        public static Content parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Content) new Content().mergeFrom(bArr);
        }

        public Content addBussinessHours(BussinessHours bussinessHours) {
            if (bussinessHours != null) {
                if (this.f14613a.isEmpty()) {
                    this.f14613a = new ArrayList();
                }
                this.f14613a.add(bussinessHours);
            }
            return this;
        }

        public Content addTakeoutMenu(TakeoutMenu takeoutMenu) {
            if (takeoutMenu != null) {
                if (this.f14614b.isEmpty()) {
                    this.f14614b = new ArrayList();
                }
                this.f14614b.add(takeoutMenu);
            }
            return this;
        }

        public final Content clear() {
            clearBussinessHours();
            clearTakeoutMenu();
            clearCouponInfo();
            clearReleaseId();
            clearShopName();
            clearBussinessStatus();
            clearTakeoutPrice();
            clearTakeoutCost();
            clearAverageTime();
            clearSourceInfo();
            this.f14631s = -1;
            return this;
        }

        public Content clearAverageTime() {
            this.f14627o = false;
            this.f14628p = "";
            return this;
        }

        public Content clearBussinessHours() {
            this.f14613a = Collections.emptyList();
            return this;
        }

        public Content clearBussinessStatus() {
            this.f14621i = false;
            this.f14622j = 0;
            return this;
        }

        public Content clearCouponInfo() {
            this.f14615c = false;
            this.f14616d = null;
            return this;
        }

        public Content clearReleaseId() {
            this.f14617e = false;
            this.f14618f = "";
            return this;
        }

        public Content clearShopName() {
            this.f14619g = false;
            this.f14620h = "";
            return this;
        }

        public Content clearSourceInfo() {
            this.f14629q = false;
            this.f14630r = null;
            return this;
        }

        public Content clearTakeoutCost() {
            this.f14625m = false;
            this.f14626n = "";
            return this;
        }

        public Content clearTakeoutMenu() {
            this.f14614b = Collections.emptyList();
            return this;
        }

        public Content clearTakeoutPrice() {
            this.f14623k = false;
            this.f14624l = "";
            return this;
        }

        public String getAverageTime() {
            return this.f14628p;
        }

        public BussinessHours getBussinessHours(int i) {
            return (BussinessHours) this.f14613a.get(i);
        }

        public int getBussinessHoursCount() {
            return this.f14613a.size();
        }

        public List<BussinessHours> getBussinessHoursList() {
            return this.f14613a;
        }

        public int getBussinessStatus() {
            return this.f14622j;
        }

        public int getCachedSize() {
            if (this.f14631s < 0) {
                getSerializedSize();
            }
            return this.f14631s;
        }

        public CouponInfo getCouponInfo() {
            return this.f14616d;
        }

        public String getReleaseId() {
            return this.f14618f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasReleaseId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getReleaseId());
            }
            if (hasShopName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getShopName());
            }
            if (hasBussinessStatus()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getBussinessStatus());
            }
            int i2 = i;
            for (BussinessHours computeMessageSize : getBussinessHoursList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize) + i2;
            }
            if (hasTakeoutPrice()) {
                i2 += CodedOutputStreamMicro.computeStringSize(5, getTakeoutPrice());
            }
            if (hasTakeoutCost()) {
                i2 += CodedOutputStreamMicro.computeStringSize(6, getTakeoutCost());
            }
            if (hasAverageTime()) {
                i2 += CodedOutputStreamMicro.computeStringSize(7, getAverageTime());
            }
            for (TakeoutMenu computeMessageSize2 : getTakeoutMenuList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize2);
            }
            if (hasCouponInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getCouponInfo());
            }
            if (hasSourceInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getSourceInfo());
            }
            this.f14631s = i2;
            return i2;
        }

        public String getShopName() {
            return this.f14620h;
        }

        public SourceInfo getSourceInfo() {
            return this.f14630r;
        }

        public String getTakeoutCost() {
            return this.f14626n;
        }

        public TakeoutMenu getTakeoutMenu(int i) {
            return (TakeoutMenu) this.f14614b.get(i);
        }

        public int getTakeoutMenuCount() {
            return this.f14614b.size();
        }

        public List<TakeoutMenu> getTakeoutMenuList() {
            return this.f14614b;
        }

        public String getTakeoutPrice() {
            return this.f14624l;
        }

        public boolean hasAverageTime() {
            return this.f14627o;
        }

        public boolean hasBussinessStatus() {
            return this.f14621i;
        }

        public boolean hasCouponInfo() {
            return this.f14615c;
        }

        public boolean hasReleaseId() {
            return this.f14617e;
        }

        public boolean hasShopName() {
            return this.f14619g;
        }

        public boolean hasSourceInfo() {
            return this.f14629q;
        }

        public boolean hasTakeoutCost() {
            return this.f14625m;
        }

        public boolean hasTakeoutPrice() {
            return this.f14623k;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Content mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro bussinessHours;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setReleaseId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setShopName(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setBussinessStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        bussinessHours = new BussinessHours();
                        codedInputStreamMicro.readMessage(bussinessHours);
                        addBussinessHours(bussinessHours);
                        continue;
                    case 42:
                        setTakeoutPrice(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setTakeoutCost(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setAverageTime(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        bussinessHours = new TakeoutMenu();
                        codedInputStreamMicro.readMessage(bussinessHours);
                        addTakeoutMenu(bussinessHours);
                        continue;
                    case 74:
                        bussinessHours = new CouponInfo();
                        codedInputStreamMicro.readMessage(bussinessHours);
                        setCouponInfo(bussinessHours);
                        continue;
                    case 82:
                        bussinessHours = new SourceInfo();
                        codedInputStreamMicro.readMessage(bussinessHours);
                        setSourceInfo(bussinessHours);
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

        public Content setAverageTime(String str) {
            this.f14627o = true;
            this.f14628p = str;
            return this;
        }

        public Content setBussinessHours(int i, BussinessHours bussinessHours) {
            if (bussinessHours != null) {
                this.f14613a.set(i, bussinessHours);
            }
            return this;
        }

        public Content setBussinessStatus(int i) {
            this.f14621i = true;
            this.f14622j = i;
            return this;
        }

        public Content setCouponInfo(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return clearCouponInfo();
            }
            this.f14615c = true;
            this.f14616d = couponInfo;
            return this;
        }

        public Content setReleaseId(String str) {
            this.f14617e = true;
            this.f14618f = str;
            return this;
        }

        public Content setShopName(String str) {
            this.f14619g = true;
            this.f14620h = str;
            return this;
        }

        public Content setSourceInfo(SourceInfo sourceInfo) {
            if (sourceInfo == null) {
                return clearSourceInfo();
            }
            this.f14629q = true;
            this.f14630r = sourceInfo;
            return this;
        }

        public Content setTakeoutCost(String str) {
            this.f14625m = true;
            this.f14626n = str;
            return this;
        }

        public Content setTakeoutMenu(int i, TakeoutMenu takeoutMenu) {
            if (takeoutMenu != null) {
                this.f14614b.set(i, takeoutMenu);
            }
            return this;
        }

        public Content setTakeoutPrice(String str) {
            this.f14623k = true;
            this.f14624l = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasReleaseId()) {
                codedOutputStreamMicro.writeString(1, getReleaseId());
            }
            if (hasShopName()) {
                codedOutputStreamMicro.writeString(2, getShopName());
            }
            if (hasBussinessStatus()) {
                codedOutputStreamMicro.writeInt32(3, getBussinessStatus());
            }
            for (BussinessHours writeMessage : getBussinessHoursList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage);
            }
            if (hasTakeoutPrice()) {
                codedOutputStreamMicro.writeString(5, getTakeoutPrice());
            }
            if (hasTakeoutCost()) {
                codedOutputStreamMicro.writeString(6, getTakeoutCost());
            }
            if (hasAverageTime()) {
                codedOutputStreamMicro.writeString(7, getAverageTime());
            }
            for (TakeoutMenu writeMessage2 : getTakeoutMenuList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage2);
            }
            if (hasCouponInfo()) {
                codedOutputStreamMicro.writeMessage(9, getCouponInfo());
            }
            if (hasSourceInfo()) {
                codedOutputStreamMicro.writeMessage(10, getSourceInfo());
            }
        }
    }

    public static final class Option extends MessageMicro {
        public static final int ERROR_MSG_FIELD_NUMBER = 2;
        public static final int ERROR_NO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14632a;
        /* renamed from: b */
        private int f14633b = 0;
        /* renamed from: c */
        private boolean f14634c;
        /* renamed from: d */
        private String f14635d = "";
        /* renamed from: e */
        private int f14636e = -1;

        public static Option parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Option().mergeFrom(codedInputStreamMicro);
        }

        public static Option parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Option) new Option().mergeFrom(bArr);
        }

        public final Option clear() {
            clearErrorNo();
            clearErrorMsg();
            this.f14636e = -1;
            return this;
        }

        public Option clearErrorMsg() {
            this.f14634c = false;
            this.f14635d = "";
            return this;
        }

        public Option clearErrorNo() {
            this.f14632a = false;
            this.f14633b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14636e < 0) {
                getSerializedSize();
            }
            return this.f14636e;
        }

        public String getErrorMsg() {
            return this.f14635d;
        }

        public int getErrorNo() {
            return this.f14633b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasErrorNo()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getErrorNo());
            }
            if (hasErrorMsg()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getErrorMsg());
            }
            this.f14636e = i;
            return i;
        }

        public boolean hasErrorMsg() {
            return this.f14634c;
        }

        public boolean hasErrorNo() {
            return this.f14632a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Option mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setErrorNo(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        setErrorMsg(codedInputStreamMicro.readString());
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

        public Option setErrorMsg(String str) {
            this.f14634c = true;
            this.f14635d = str;
            return this;
        }

        public Option setErrorNo(int i) {
            this.f14632a = true;
            this.f14633b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasErrorNo()) {
                codedOutputStreamMicro.writeInt32(1, getErrorNo());
            }
            if (hasErrorMsg()) {
                codedOutputStreamMicro.writeString(2, getErrorMsg());
            }
        }
    }

    public static ShopMenu parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new ShopMenu().mergeFrom(codedInputStreamMicro);
    }

    public static ShopMenu parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (ShopMenu) new ShopMenu().mergeFrom(bArr);
    }

    public final ShopMenu clear() {
        clearOption();
        clearContent();
        this.f14641e = -1;
        return this;
    }

    public ShopMenu clearContent() {
        this.f14639c = false;
        this.f14640d = null;
        return this;
    }

    public ShopMenu clearOption() {
        this.f14637a = false;
        this.f14638b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f14641e < 0) {
            getSerializedSize();
        }
        return this.f14641e;
    }

    public Content getContent() {
        return this.f14640d;
    }

    public Option getOption() {
        return this.f14638b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasOption()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getOption());
        }
        if (hasContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getContent());
        }
        this.f14641e = i;
        return i;
    }

    public boolean hasContent() {
        return this.f14639c;
    }

    public boolean hasOption() {
        return this.f14637a;
    }

    public final boolean isInitialized() {
        return true;
    }

    public ShopMenu mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro option;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    option = new Option();
                    codedInputStreamMicro.readMessage(option);
                    setOption(option);
                    continue;
                case 18:
                    option = new Content();
                    codedInputStreamMicro.readMessage(option);
                    setContent(option);
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

    public ShopMenu setContent(Content content) {
        if (content == null) {
            return clearContent();
        }
        this.f14639c = true;
        this.f14640d = content;
        return this;
    }

    public ShopMenu setOption(Option option) {
        if (option == null) {
            return clearOption();
        }
        this.f14637a = true;
        this.f14638b = option;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOption()) {
            codedOutputStreamMicro.writeMessage(1, getOption());
        }
        if (hasContent()) {
            codedOutputStreamMicro.writeMessage(2, getContent());
        }
    }
}
