package com.baidu.entity.pb;

import com.baidu.carlife.core.C1253f;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Orderlists extends MessageMicro {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 4;
    public static final int LOGID_FIELD_NUMBER = 3;
    public static final int MSG_FIELD_NUMBER = 2;
    /* renamed from: a */
    private boolean f12435a;
    /* renamed from: b */
    private int f12436b = 0;
    /* renamed from: c */
    private boolean f12437c;
    /* renamed from: d */
    private String f12438d = "";
    /* renamed from: e */
    private boolean f12439e;
    /* renamed from: f */
    private String f12440f = "";
    /* renamed from: g */
    private boolean f12441g;
    /* renamed from: h */
    private Data f12442h = null;
    /* renamed from: i */
    private int f12443i = -1;

    public static final class Data extends MessageMicro {
        public static final int LISTS_FIELD_NUMBER = 2;
        public static final int TOTAL_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f12431a;
        /* renamed from: b */
        private int f12432b = 0;
        /* renamed from: c */
        private List<Lists> f12433c = Collections.emptyList();
        /* renamed from: d */
        private int f12434d = -1;

        public static final class Lists extends MessageMicro {
            public static final int CAT_ID_FIELD_NUMBER = 17;
            public static final int COMPOSETEXT_FIELD_NUMBER = 25;
            public static final int CO_DETAIL_AMOUNT_FIELD_NUMBER = 15;
            public static final int CO_DETAIL_TYPE_FIELD_NUMBER = 16;
            public static final int CREATE_TIME_FIELD_NUMBER = 10;
            public static final int CUID_FIELD_NUMBER = 6;
            public static final int DEL_DESC_FIELD_NUMBER = 24;
            public static final int DEL_URL_FIELD_NUMBER = 23;
            public static final int DISCOUNT_AMOUNT_FIELD_NUMBER = 12;
            public static final int MERCHANT_URL_FIELD_NUMBER = 26;
            public static final int OPERATE_FIELD_NUMBER = 22;
            public static final int OP_ADDRESS_FIELD_NUMBER = 21;
            public static final int OP_MOBILE_FIELD_NUMBER = 8;
            public static final int OP_UID_FIELD_NUMBER = 7;
            public static final int ORDER_ADD_FIELD_NUMBER = 19;
            public static final int ORDER_NO_FIELD_NUMBER = 1;
            public static final int ORDER_SOURCE_URL_FIELD_NUMBER = 20;
            public static final int ORDER_TITLE_FIELD_NUMBER = 5;
            public static final int PAY_AMOUNT_FIELD_NUMBER = 13;
            public static final int PHOTO_URL_FIELD_NUMBER = 18;
            public static final int RETURN_AMOUNT_FIELD_NUMBER = 14;
            public static final int TOTAL_AMOUNT_FIELD_NUMBER = 11;
            public static final int TPL_FIELD_NUMBER = 2;
            public static final int TPL_ICON_FIELD_NUMBER = 4;
            public static final int TPL_STATUS_FIELD_NUMBER = 9;
            public static final int TPL_TITLE_FIELD_NUMBER = 3;
            /* renamed from: A */
            private boolean f12379A;
            /* renamed from: B */
            private int f12380B = 0;
            /* renamed from: C */
            private boolean f12381C;
            /* renamed from: D */
            private int f12382D = 0;
            /* renamed from: E */
            private boolean f12383E;
            /* renamed from: F */
            private String f12384F = "";
            /* renamed from: G */
            private boolean f12385G;
            /* renamed from: H */
            private int f12386H = 0;
            /* renamed from: I */
            private boolean f12387I;
            /* renamed from: J */
            private String f12388J = "";
            /* renamed from: K */
            private boolean f12389K;
            /* renamed from: L */
            private Order_add f12390L = null;
            /* renamed from: M */
            private boolean f12391M;
            /* renamed from: N */
            private String f12392N = "";
            /* renamed from: O */
            private boolean f12393O;
            /* renamed from: P */
            private String f12394P = "";
            /* renamed from: Q */
            private boolean f12395Q;
            /* renamed from: R */
            private Operate f12396R = null;
            /* renamed from: S */
            private boolean f12397S;
            /* renamed from: T */
            private String f12398T = "";
            /* renamed from: U */
            private boolean f12399U;
            /* renamed from: V */
            private String f12400V = "";
            /* renamed from: W */
            private boolean f12401W;
            /* renamed from: X */
            private String f12402X = "";
            /* renamed from: Y */
            private boolean f12403Y;
            /* renamed from: Z */
            private String f12404Z = "";
            /* renamed from: a */
            private boolean f12405a;
            private int aa = -1;
            /* renamed from: b */
            private String f12406b = "";
            /* renamed from: c */
            private boolean f12407c;
            /* renamed from: d */
            private int f12408d = 0;
            /* renamed from: e */
            private boolean f12409e;
            /* renamed from: f */
            private String f12410f = "";
            /* renamed from: g */
            private boolean f12411g;
            /* renamed from: h */
            private String f12412h = "";
            /* renamed from: i */
            private boolean f12413i;
            /* renamed from: j */
            private String f12414j = "";
            /* renamed from: k */
            private boolean f12415k;
            /* renamed from: l */
            private String f12416l = "";
            /* renamed from: m */
            private boolean f12417m;
            /* renamed from: n */
            private String f12418n = "";
            /* renamed from: o */
            private boolean f12419o;
            /* renamed from: p */
            private int f12420p = 0;
            /* renamed from: q */
            private boolean f12421q;
            /* renamed from: r */
            private String f12422r = "";
            /* renamed from: s */
            private boolean f12423s;
            /* renamed from: t */
            private int f12424t = 0;
            /* renamed from: u */
            private boolean f12425u;
            /* renamed from: v */
            private int f12426v = 0;
            /* renamed from: w */
            private boolean f12427w;
            /* renamed from: x */
            private int f12428x = 0;
            /* renamed from: y */
            private boolean f12429y;
            /* renamed from: z */
            private int f12430z = 0;

            public static final class Operate extends MessageMicro {
                public static final int A_FIELD_NUMBER = 1;
                public static final int B_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f12369a;
                /* renamed from: b */
                private Action f12370b = null;
                /* renamed from: c */
                private boolean f12371c;
                /* renamed from: d */
                private Action f12372d = null;
                /* renamed from: e */
                private int f12373e = -1;

                public static final class Action extends MessageMicro {
                    public static final int TITLE_FIELD_NUMBER = 2;
                    public static final int URL_FIELD_NUMBER = 1;
                    /* renamed from: a */
                    private boolean f12364a;
                    /* renamed from: b */
                    private String f12365b = "";
                    /* renamed from: c */
                    private boolean f12366c;
                    /* renamed from: d */
                    private String f12367d = "";
                    /* renamed from: e */
                    private int f12368e = -1;

                    public static Action parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                        return new Action().mergeFrom(codedInputStreamMicro);
                    }

                    public static Action parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                        return (Action) new Action().mergeFrom(bArr);
                    }

                    public final Action clear() {
                        clearUrl();
                        clearTitle();
                        this.f12368e = -1;
                        return this;
                    }

                    public Action clearTitle() {
                        this.f12366c = false;
                        this.f12367d = "";
                        return this;
                    }

                    public Action clearUrl() {
                        this.f12364a = false;
                        this.f12365b = "";
                        return this;
                    }

                    public int getCachedSize() {
                        if (this.f12368e < 0) {
                            getSerializedSize();
                        }
                        return this.f12368e;
                    }

                    public int getSerializedSize() {
                        int i = 0;
                        if (hasUrl()) {
                            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUrl());
                        }
                        if (hasTitle()) {
                            i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
                        }
                        this.f12368e = i;
                        return i;
                    }

                    public String getTitle() {
                        return this.f12367d;
                    }

                    public String getUrl() {
                        return this.f12365b;
                    }

                    public boolean hasTitle() {
                        return this.f12366c;
                    }

                    public boolean hasUrl() {
                        return this.f12364a;
                    }

                    public final boolean isInitialized() {
                        return true;
                    }

                    public Action mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                                default:
                                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                                        break;
                                    }
                                    continue;
                            }
                            return this;
                        }
                    }

                    public Action setTitle(String str) {
                        this.f12366c = true;
                        this.f12367d = str;
                        return this;
                    }

                    public Action setUrl(String str) {
                        this.f12364a = true;
                        this.f12365b = str;
                        return this;
                    }

                    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                        if (hasUrl()) {
                            codedOutputStreamMicro.writeString(1, getUrl());
                        }
                        if (hasTitle()) {
                            codedOutputStreamMicro.writeString(2, getTitle());
                        }
                    }
                }

                public static Operate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Operate().mergeFrom(codedInputStreamMicro);
                }

                public static Operate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Operate) new Operate().mergeFrom(bArr);
                }

                public final Operate clear() {
                    clearA();
                    clearB();
                    this.f12373e = -1;
                    return this;
                }

                public Operate clearA() {
                    this.f12369a = false;
                    this.f12370b = null;
                    return this;
                }

                public Operate clearB() {
                    this.f12371c = false;
                    this.f12372d = null;
                    return this;
                }

                public Action getA() {
                    return this.f12370b;
                }

                public Action getB() {
                    return this.f12372d;
                }

                public int getCachedSize() {
                    if (this.f12373e < 0) {
                        getSerializedSize();
                    }
                    return this.f12373e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasA()) {
                        i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getA());
                    }
                    if (hasB()) {
                        i += CodedOutputStreamMicro.computeMessageSize(2, getB());
                    }
                    this.f12373e = i;
                    return i;
                }

                public boolean hasA() {
                    return this.f12369a;
                }

                public boolean hasB() {
                    return this.f12371c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Operate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        MessageMicro action;
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                action = new Action();
                                codedInputStreamMicro.readMessage(action);
                                setA(action);
                                continue;
                            case 18:
                                action = new Action();
                                codedInputStreamMicro.readMessage(action);
                                setB(action);
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

                public Operate setA(Action action) {
                    if (action == null) {
                        return clearA();
                    }
                    this.f12369a = true;
                    this.f12370b = action;
                    return this;
                }

                public Operate setB(Action action) {
                    if (action == null) {
                        return clearB();
                    }
                    this.f12371c = true;
                    this.f12372d = action;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasA()) {
                        codedOutputStreamMicro.writeMessage(1, getA());
                    }
                    if (hasB()) {
                        codedOutputStreamMicro.writeMessage(2, getB());
                    }
                }
            }

            public static final class Order_add extends MessageMicro {
                public static final int A_FIELD_NUMBER = 1;
                public static final int B_FIELD_NUMBER = 2;
                /* renamed from: a */
                private boolean f12374a;
                /* renamed from: b */
                private String f12375b = "";
                /* renamed from: c */
                private boolean f12376c;
                /* renamed from: d */
                private String f12377d = "";
                /* renamed from: e */
                private int f12378e = -1;

                public static Order_add parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    return new Order_add().mergeFrom(codedInputStreamMicro);
                }

                public static Order_add parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                    return (Order_add) new Order_add().mergeFrom(bArr);
                }

                public final Order_add clear() {
                    clearA();
                    clearB();
                    this.f12378e = -1;
                    return this;
                }

                public Order_add clearA() {
                    this.f12374a = false;
                    this.f12375b = "";
                    return this;
                }

                public Order_add clearB() {
                    this.f12376c = false;
                    this.f12377d = "";
                    return this;
                }

                public String getA() {
                    return this.f12375b;
                }

                public String getB() {
                    return this.f12377d;
                }

                public int getCachedSize() {
                    if (this.f12378e < 0) {
                        getSerializedSize();
                    }
                    return this.f12378e;
                }

                public int getSerializedSize() {
                    int i = 0;
                    if (hasA()) {
                        i = 0 + CodedOutputStreamMicro.computeStringSize(1, getA());
                    }
                    if (hasB()) {
                        i += CodedOutputStreamMicro.computeStringSize(2, getB());
                    }
                    this.f12378e = i;
                    return i;
                }

                public boolean hasA() {
                    return this.f12374a;
                }

                public boolean hasB() {
                    return this.f12376c;
                }

                public final boolean isInitialized() {
                    return true;
                }

                public Order_add mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                    while (true) {
                        int readTag = codedInputStreamMicro.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                setA(codedInputStreamMicro.readString());
                                continue;
                            case 18:
                                setB(codedInputStreamMicro.readString());
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

                public Order_add setA(String str) {
                    this.f12374a = true;
                    this.f12375b = str;
                    return this;
                }

                public Order_add setB(String str) {
                    this.f12376c = true;
                    this.f12377d = str;
                    return this;
                }

                public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                    if (hasA()) {
                        codedOutputStreamMicro.writeString(1, getA());
                    }
                    if (hasB()) {
                        codedOutputStreamMicro.writeString(2, getB());
                    }
                }
            }

            public static Lists parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Lists().mergeFrom(codedInputStreamMicro);
            }

            public static Lists parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Lists) new Lists().mergeFrom(bArr);
            }

            public final Lists clear() {
                clearOrderNo();
                clearTpl();
                clearTplTitle();
                clearTplIcon();
                clearOrderTitle();
                clearCuid();
                clearOpUid();
                clearOpMobile();
                clearTplStatus();
                clearCreateTime();
                clearTotalAmount();
                clearDiscountAmount();
                clearPayAmount();
                clearReturnAmount();
                clearCoDetailAmount();
                clearCoDetailType();
                clearCatId();
                clearPhotoUrl();
                clearOrderAdd();
                clearOrderSourceUrl();
                clearOpAddress();
                clearOperate();
                clearDelUrl();
                clearDelDesc();
                clearComposeText();
                clearMerchantUrl();
                this.aa = -1;
                return this;
            }

            public Lists clearCatId() {
                this.f12385G = false;
                this.f12386H = 0;
                return this;
            }

            public Lists clearCoDetailAmount() {
                this.f12381C = false;
                this.f12382D = 0;
                return this;
            }

            public Lists clearCoDetailType() {
                this.f12383E = false;
                this.f12384F = "";
                return this;
            }

            public Lists clearComposeText() {
                this.f12401W = false;
                this.f12402X = "";
                return this;
            }

            public Lists clearCreateTime() {
                this.f12423s = false;
                this.f12424t = 0;
                return this;
            }

            public Lists clearCuid() {
                this.f12415k = false;
                this.f12416l = "";
                return this;
            }

            public Lists clearDelDesc() {
                this.f12399U = false;
                this.f12400V = "";
                return this;
            }

            public Lists clearDelUrl() {
                this.f12397S = false;
                this.f12398T = "";
                return this;
            }

            public Lists clearDiscountAmount() {
                this.f12427w = false;
                this.f12428x = 0;
                return this;
            }

            public Lists clearMerchantUrl() {
                this.f12403Y = false;
                this.f12404Z = "";
                return this;
            }

            public Lists clearOpAddress() {
                this.f12393O = false;
                this.f12394P = "";
                return this;
            }

            public Lists clearOpMobile() {
                this.f12419o = false;
                this.f12420p = 0;
                return this;
            }

            public Lists clearOpUid() {
                this.f12417m = false;
                this.f12418n = "";
                return this;
            }

            public Lists clearOperate() {
                this.f12395Q = false;
                this.f12396R = null;
                return this;
            }

            public Lists clearOrderAdd() {
                this.f12389K = false;
                this.f12390L = null;
                return this;
            }

            public Lists clearOrderNo() {
                this.f12405a = false;
                this.f12406b = "";
                return this;
            }

            public Lists clearOrderSourceUrl() {
                this.f12391M = false;
                this.f12392N = "";
                return this;
            }

            public Lists clearOrderTitle() {
                this.f12413i = false;
                this.f12414j = "";
                return this;
            }

            public Lists clearPayAmount() {
                this.f12429y = false;
                this.f12430z = 0;
                return this;
            }

            public Lists clearPhotoUrl() {
                this.f12387I = false;
                this.f12388J = "";
                return this;
            }

            public Lists clearReturnAmount() {
                this.f12379A = false;
                this.f12380B = 0;
                return this;
            }

            public Lists clearTotalAmount() {
                this.f12425u = false;
                this.f12426v = 0;
                return this;
            }

            public Lists clearTpl() {
                this.f12407c = false;
                this.f12408d = 0;
                return this;
            }

            public Lists clearTplIcon() {
                this.f12411g = false;
                this.f12412h = "";
                return this;
            }

            public Lists clearTplStatus() {
                this.f12421q = false;
                this.f12422r = "";
                return this;
            }

            public Lists clearTplTitle() {
                this.f12409e = false;
                this.f12410f = "";
                return this;
            }

            public int getCachedSize() {
                if (this.aa < 0) {
                    getSerializedSize();
                }
                return this.aa;
            }

            public int getCatId() {
                return this.f12386H;
            }

            public int getCoDetailAmount() {
                return this.f12382D;
            }

            public String getCoDetailType() {
                return this.f12384F;
            }

            public String getComposeText() {
                return this.f12402X;
            }

            public int getCreateTime() {
                return this.f12424t;
            }

            public String getCuid() {
                return this.f12416l;
            }

            public String getDelDesc() {
                return this.f12400V;
            }

            public String getDelUrl() {
                return this.f12398T;
            }

            public int getDiscountAmount() {
                return this.f12428x;
            }

            public String getMerchantUrl() {
                return this.f12404Z;
            }

            public String getOpAddress() {
                return this.f12394P;
            }

            public int getOpMobile() {
                return this.f12420p;
            }

            public String getOpUid() {
                return this.f12418n;
            }

            public Operate getOperate() {
                return this.f12396R;
            }

            public Order_add getOrderAdd() {
                return this.f12390L;
            }

            public String getOrderNo() {
                return this.f12406b;
            }

            public String getOrderSourceUrl() {
                return this.f12392N;
            }

            public String getOrderTitle() {
                return this.f12414j;
            }

            public int getPayAmount() {
                return this.f12430z;
            }

            public String getPhotoUrl() {
                return this.f12388J;
            }

            public int getReturnAmount() {
                return this.f12380B;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasOrderNo()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getOrderNo());
                }
                if (hasTpl()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getTpl());
                }
                if (hasTplTitle()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getTplTitle());
                }
                if (hasTplIcon()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getTplIcon());
                }
                if (hasOrderTitle()) {
                    i += CodedOutputStreamMicro.computeStringSize(5, getOrderTitle());
                }
                if (hasCuid()) {
                    i += CodedOutputStreamMicro.computeStringSize(6, getCuid());
                }
                if (hasOpUid()) {
                    i += CodedOutputStreamMicro.computeStringSize(7, getOpUid());
                }
                if (hasOpMobile()) {
                    i += CodedOutputStreamMicro.computeInt32Size(8, getOpMobile());
                }
                if (hasTplStatus()) {
                    i += CodedOutputStreamMicro.computeStringSize(9, getTplStatus());
                }
                if (hasCreateTime()) {
                    i += CodedOutputStreamMicro.computeInt32Size(10, getCreateTime());
                }
                if (hasTotalAmount()) {
                    i += CodedOutputStreamMicro.computeInt32Size(11, getTotalAmount());
                }
                if (hasDiscountAmount()) {
                    i += CodedOutputStreamMicro.computeInt32Size(12, getDiscountAmount());
                }
                if (hasPayAmount()) {
                    i += CodedOutputStreamMicro.computeInt32Size(13, getPayAmount());
                }
                if (hasReturnAmount()) {
                    i += CodedOutputStreamMicro.computeInt32Size(14, getReturnAmount());
                }
                if (hasCoDetailAmount()) {
                    i += CodedOutputStreamMicro.computeInt32Size(15, getCoDetailAmount());
                }
                if (hasCoDetailType()) {
                    i += CodedOutputStreamMicro.computeStringSize(16, getCoDetailType());
                }
                if (hasCatId()) {
                    i += CodedOutputStreamMicro.computeInt32Size(17, getCatId());
                }
                if (hasPhotoUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(18, getPhotoUrl());
                }
                if (hasOrderAdd()) {
                    i += CodedOutputStreamMicro.computeMessageSize(19, getOrderAdd());
                }
                if (hasOrderSourceUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(20, getOrderSourceUrl());
                }
                if (hasOpAddress()) {
                    i += CodedOutputStreamMicro.computeStringSize(21, getOpAddress());
                }
                if (hasOperate()) {
                    i += CodedOutputStreamMicro.computeMessageSize(22, getOperate());
                }
                if (hasDelUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(23, getDelUrl());
                }
                if (hasDelDesc()) {
                    i += CodedOutputStreamMicro.computeStringSize(24, getDelDesc());
                }
                if (hasComposeText()) {
                    i += CodedOutputStreamMicro.computeStringSize(25, getComposeText());
                }
                if (hasMerchantUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(26, getMerchantUrl());
                }
                this.aa = i;
                return i;
            }

            public int getTotalAmount() {
                return this.f12426v;
            }

            public int getTpl() {
                return this.f12408d;
            }

            public String getTplIcon() {
                return this.f12412h;
            }

            public String getTplStatus() {
                return this.f12422r;
            }

            public String getTplTitle() {
                return this.f12410f;
            }

            public boolean hasCatId() {
                return this.f12385G;
            }

            public boolean hasCoDetailAmount() {
                return this.f12381C;
            }

            public boolean hasCoDetailType() {
                return this.f12383E;
            }

            public boolean hasComposeText() {
                return this.f12401W;
            }

            public boolean hasCreateTime() {
                return this.f12423s;
            }

            public boolean hasCuid() {
                return this.f12415k;
            }

            public boolean hasDelDesc() {
                return this.f12399U;
            }

            public boolean hasDelUrl() {
                return this.f12397S;
            }

            public boolean hasDiscountAmount() {
                return this.f12427w;
            }

            public boolean hasMerchantUrl() {
                return this.f12403Y;
            }

            public boolean hasOpAddress() {
                return this.f12393O;
            }

            public boolean hasOpMobile() {
                return this.f12419o;
            }

            public boolean hasOpUid() {
                return this.f12417m;
            }

            public boolean hasOperate() {
                return this.f12395Q;
            }

            public boolean hasOrderAdd() {
                return this.f12389K;
            }

            public boolean hasOrderNo() {
                return this.f12405a;
            }

            public boolean hasOrderSourceUrl() {
                return this.f12391M;
            }

            public boolean hasOrderTitle() {
                return this.f12413i;
            }

            public boolean hasPayAmount() {
                return this.f12429y;
            }

            public boolean hasPhotoUrl() {
                return this.f12387I;
            }

            public boolean hasReturnAmount() {
                return this.f12379A;
            }

            public boolean hasTotalAmount() {
                return this.f12425u;
            }

            public boolean hasTpl() {
                return this.f12407c;
            }

            public boolean hasTplIcon() {
                return this.f12411g;
            }

            public boolean hasTplStatus() {
                return this.f12421q;
            }

            public boolean hasTplTitle() {
                return this.f12409e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Lists mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    MessageMicro order_add;
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setOrderNo(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setTpl(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setTplTitle(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setTplIcon(codedInputStreamMicro.readString());
                            continue;
                        case 42:
                            setOrderTitle(codedInputStreamMicro.readString());
                            continue;
                        case 50:
                            setCuid(codedInputStreamMicro.readString());
                            continue;
                        case 58:
                            setOpUid(codedInputStreamMicro.readString());
                            continue;
                        case 64:
                            setOpMobile(codedInputStreamMicro.readInt32());
                            continue;
                        case 74:
                            setTplStatus(codedInputStreamMicro.readString());
                            continue;
                        case 80:
                            setCreateTime(codedInputStreamMicro.readInt32());
                            continue;
                        case 88:
                            setTotalAmount(codedInputStreamMicro.readInt32());
                            continue;
                        case 96:
                            setDiscountAmount(codedInputStreamMicro.readInt32());
                            continue;
                        case 104:
                            setPayAmount(codedInputStreamMicro.readInt32());
                            continue;
                        case 112:
                            setReturnAmount(codedInputStreamMicro.readInt32());
                            continue;
                        case 120:
                            setCoDetailAmount(codedInputStreamMicro.readInt32());
                            continue;
                        case 130:
                            setCoDetailType(codedInputStreamMicro.readString());
                            continue;
                        case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                            setCatId(codedInputStreamMicro.readInt32());
                            continue;
                        case 146:
                            setPhotoUrl(codedInputStreamMicro.readString());
                            continue;
                        case 154:
                            order_add = new Order_add();
                            codedInputStreamMicro.readMessage(order_add);
                            setOrderAdd(order_add);
                            continue;
                        case 162:
                            setOrderSourceUrl(codedInputStreamMicro.readString());
                            continue;
                        case 170:
                            setOpAddress(codedInputStreamMicro.readString());
                            continue;
                        case 178:
                            order_add = new Operate();
                            codedInputStreamMicro.readMessage(order_add);
                            setOperate(order_add);
                            continue;
                        case 186:
                            setDelUrl(codedInputStreamMicro.readString());
                            continue;
                        case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                            setDelDesc(codedInputStreamMicro.readString());
                            continue;
                        case 202:
                            setComposeText(codedInputStreamMicro.readString());
                            continue;
                        case C1253f.ds /*210*/:
                            setMerchantUrl(codedInputStreamMicro.readString());
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

            public Lists setCatId(int i) {
                this.f12385G = true;
                this.f12386H = i;
                return this;
            }

            public Lists setCoDetailAmount(int i) {
                this.f12381C = true;
                this.f12382D = i;
                return this;
            }

            public Lists setCoDetailType(String str) {
                this.f12383E = true;
                this.f12384F = str;
                return this;
            }

            public Lists setComposeText(String str) {
                this.f12401W = true;
                this.f12402X = str;
                return this;
            }

            public Lists setCreateTime(int i) {
                this.f12423s = true;
                this.f12424t = i;
                return this;
            }

            public Lists setCuid(String str) {
                this.f12415k = true;
                this.f12416l = str;
                return this;
            }

            public Lists setDelDesc(String str) {
                this.f12399U = true;
                this.f12400V = str;
                return this;
            }

            public Lists setDelUrl(String str) {
                this.f12397S = true;
                this.f12398T = str;
                return this;
            }

            public Lists setDiscountAmount(int i) {
                this.f12427w = true;
                this.f12428x = i;
                return this;
            }

            public Lists setMerchantUrl(String str) {
                this.f12403Y = true;
                this.f12404Z = str;
                return this;
            }

            public Lists setOpAddress(String str) {
                this.f12393O = true;
                this.f12394P = str;
                return this;
            }

            public Lists setOpMobile(int i) {
                this.f12419o = true;
                this.f12420p = i;
                return this;
            }

            public Lists setOpUid(String str) {
                this.f12417m = true;
                this.f12418n = str;
                return this;
            }

            public Lists setOperate(Operate operate) {
                if (operate == null) {
                    return clearOperate();
                }
                this.f12395Q = true;
                this.f12396R = operate;
                return this;
            }

            public Lists setOrderAdd(Order_add order_add) {
                if (order_add == null) {
                    return clearOrderAdd();
                }
                this.f12389K = true;
                this.f12390L = order_add;
                return this;
            }

            public Lists setOrderNo(String str) {
                this.f12405a = true;
                this.f12406b = str;
                return this;
            }

            public Lists setOrderSourceUrl(String str) {
                this.f12391M = true;
                this.f12392N = str;
                return this;
            }

            public Lists setOrderTitle(String str) {
                this.f12413i = true;
                this.f12414j = str;
                return this;
            }

            public Lists setPayAmount(int i) {
                this.f12429y = true;
                this.f12430z = i;
                return this;
            }

            public Lists setPhotoUrl(String str) {
                this.f12387I = true;
                this.f12388J = str;
                return this;
            }

            public Lists setReturnAmount(int i) {
                this.f12379A = true;
                this.f12380B = i;
                return this;
            }

            public Lists setTotalAmount(int i) {
                this.f12425u = true;
                this.f12426v = i;
                return this;
            }

            public Lists setTpl(int i) {
                this.f12407c = true;
                this.f12408d = i;
                return this;
            }

            public Lists setTplIcon(String str) {
                this.f12411g = true;
                this.f12412h = str;
                return this;
            }

            public Lists setTplStatus(String str) {
                this.f12421q = true;
                this.f12422r = str;
                return this;
            }

            public Lists setTplTitle(String str) {
                this.f12409e = true;
                this.f12410f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasOrderNo()) {
                    codedOutputStreamMicro.writeString(1, getOrderNo());
                }
                if (hasTpl()) {
                    codedOutputStreamMicro.writeInt32(2, getTpl());
                }
                if (hasTplTitle()) {
                    codedOutputStreamMicro.writeString(3, getTplTitle());
                }
                if (hasTplIcon()) {
                    codedOutputStreamMicro.writeString(4, getTplIcon());
                }
                if (hasOrderTitle()) {
                    codedOutputStreamMicro.writeString(5, getOrderTitle());
                }
                if (hasCuid()) {
                    codedOutputStreamMicro.writeString(6, getCuid());
                }
                if (hasOpUid()) {
                    codedOutputStreamMicro.writeString(7, getOpUid());
                }
                if (hasOpMobile()) {
                    codedOutputStreamMicro.writeInt32(8, getOpMobile());
                }
                if (hasTplStatus()) {
                    codedOutputStreamMicro.writeString(9, getTplStatus());
                }
                if (hasCreateTime()) {
                    codedOutputStreamMicro.writeInt32(10, getCreateTime());
                }
                if (hasTotalAmount()) {
                    codedOutputStreamMicro.writeInt32(11, getTotalAmount());
                }
                if (hasDiscountAmount()) {
                    codedOutputStreamMicro.writeInt32(12, getDiscountAmount());
                }
                if (hasPayAmount()) {
                    codedOutputStreamMicro.writeInt32(13, getPayAmount());
                }
                if (hasReturnAmount()) {
                    codedOutputStreamMicro.writeInt32(14, getReturnAmount());
                }
                if (hasCoDetailAmount()) {
                    codedOutputStreamMicro.writeInt32(15, getCoDetailAmount());
                }
                if (hasCoDetailType()) {
                    codedOutputStreamMicro.writeString(16, getCoDetailType());
                }
                if (hasCatId()) {
                    codedOutputStreamMicro.writeInt32(17, getCatId());
                }
                if (hasPhotoUrl()) {
                    codedOutputStreamMicro.writeString(18, getPhotoUrl());
                }
                if (hasOrderAdd()) {
                    codedOutputStreamMicro.writeMessage(19, getOrderAdd());
                }
                if (hasOrderSourceUrl()) {
                    codedOutputStreamMicro.writeString(20, getOrderSourceUrl());
                }
                if (hasOpAddress()) {
                    codedOutputStreamMicro.writeString(21, getOpAddress());
                }
                if (hasOperate()) {
                    codedOutputStreamMicro.writeMessage(22, getOperate());
                }
                if (hasDelUrl()) {
                    codedOutputStreamMicro.writeString(23, getDelUrl());
                }
                if (hasDelDesc()) {
                    codedOutputStreamMicro.writeString(24, getDelDesc());
                }
                if (hasComposeText()) {
                    codedOutputStreamMicro.writeString(25, getComposeText());
                }
                if (hasMerchantUrl()) {
                    codedOutputStreamMicro.writeString(26, getMerchantUrl());
                }
            }
        }

        public static Data parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Data().mergeFrom(codedInputStreamMicro);
        }

        public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Data) new Data().mergeFrom(bArr);
        }

        public Data addLists(Lists lists) {
            if (lists != null) {
                if (this.f12433c.isEmpty()) {
                    this.f12433c = new ArrayList();
                }
                this.f12433c.add(lists);
            }
            return this;
        }

        public final Data clear() {
            clearTotal();
            clearLists();
            this.f12434d = -1;
            return this;
        }

        public Data clearLists() {
            this.f12433c = Collections.emptyList();
            return this;
        }

        public Data clearTotal() {
            this.f12431a = false;
            this.f12432b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f12434d < 0) {
                getSerializedSize();
            }
            return this.f12434d;
        }

        public Lists getLists(int i) {
            return (Lists) this.f12433c.get(i);
        }

        public int getListsCount() {
            return this.f12433c.size();
        }

        public List<Lists> getListsList() {
            return this.f12433c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTotal()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getTotal());
            }
            int i2 = i;
            for (Lists computeMessageSize : getListsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f12434d = i2;
            return i2;
        }

        public int getTotal() {
            return this.f12432b;
        }

        public boolean hasTotal() {
            return this.f12431a;
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
                        setTotal(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        MessageMicro lists = new Lists();
                        codedInputStreamMicro.readMessage(lists);
                        addLists(lists);
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

        public Data setLists(int i, Lists lists) {
            if (lists != null) {
                this.f12433c.set(i, lists);
            }
            return this;
        }

        public Data setTotal(int i) {
            this.f12431a = true;
            this.f12432b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTotal()) {
                codedOutputStreamMicro.writeInt32(1, getTotal());
            }
            for (Lists writeMessage : getListsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static Orderlists parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Orderlists().mergeFrom(codedInputStreamMicro);
    }

    public static Orderlists parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Orderlists) new Orderlists().mergeFrom(bArr);
    }

    public final Orderlists clear() {
        clearCode();
        clearMsg();
        clearLogid();
        clearData();
        this.f12443i = -1;
        return this;
    }

    public Orderlists clearCode() {
        this.f12435a = false;
        this.f12436b = 0;
        return this;
    }

    public Orderlists clearData() {
        this.f12441g = false;
        this.f12442h = null;
        return this;
    }

    public Orderlists clearLogid() {
        this.f12439e = false;
        this.f12440f = "";
        return this;
    }

    public Orderlists clearMsg() {
        this.f12437c = false;
        this.f12438d = "";
        return this;
    }

    public int getCachedSize() {
        if (this.f12443i < 0) {
            getSerializedSize();
        }
        return this.f12443i;
    }

    public int getCode() {
        return this.f12436b;
    }

    public Data getData() {
        return this.f12442h;
    }

    public String getLogid() {
        return this.f12440f;
    }

    public String getMsg() {
        return this.f12438d;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasCode()) {
            i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getCode());
        }
        if (hasMsg()) {
            i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
        }
        if (hasLogid()) {
            i += CodedOutputStreamMicro.computeStringSize(3, getLogid());
        }
        if (hasData()) {
            i += CodedOutputStreamMicro.computeMessageSize(4, getData());
        }
        this.f12443i = i;
        return i;
    }

    public boolean hasCode() {
        return this.f12435a;
    }

    public boolean hasData() {
        return this.f12441g;
    }

    public boolean hasLogid() {
        return this.f12439e;
    }

    public boolean hasMsg() {
        return this.f12437c;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Orderlists mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 8:
                    setCode(codedInputStreamMicro.readInt32());
                    continue;
                case 18:
                    setMsg(codedInputStreamMicro.readString());
                    continue;
                case 26:
                    setLogid(codedInputStreamMicro.readString());
                    continue;
                case 34:
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

    public Orderlists setCode(int i) {
        this.f12435a = true;
        this.f12436b = i;
        return this;
    }

    public Orderlists setData(Data data) {
        if (data == null) {
            return clearData();
        }
        this.f12441g = true;
        this.f12442h = data;
        return this;
    }

    public Orderlists setLogid(String str) {
        this.f12439e = true;
        this.f12440f = str;
        return this;
    }

    public Orderlists setMsg(String str) {
        this.f12437c = true;
        this.f12438d = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCode()) {
            codedOutputStreamMicro.writeInt32(1, getCode());
        }
        if (hasMsg()) {
            codedOutputStreamMicro.writeString(2, getMsg());
        }
        if (hasLogid()) {
            codedOutputStreamMicro.writeString(3, getLogid());
        }
        if (hasData()) {
            codedOutputStreamMicro.writeMessage(4, getData());
        }
    }
}
