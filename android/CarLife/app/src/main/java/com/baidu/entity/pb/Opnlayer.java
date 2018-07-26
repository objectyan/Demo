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

public final class Opnlayer extends MessageMicro {
    public static final int BORDERLB_FIELD_NUMBER = 10;
    public static final int BORDERRT_FIELD_NUMBER = 11;
    public static final int BOTTOMICON_FIELD_NUMBER = 15;
    public static final int CENTER_FIELD_NUMBER = 4;
    public static final int EVENTTITLE_FIELD_NUMBER = 1;
    public static final int EVENTTYPE_FIELD_NUMBER = 2;
    public static final int FIRSTSHOW_FIELD_NUMBER = 18;
    public static final int ICON_FIELD_NUMBER = 6;
    public static final int IMAGEBOTTOM_FIELD_NUMBER = 7;
    public static final int IMAGEBUTTON_FIELD_NUMBER = 12;
    public static final int IMAGETOP_FIELD_NUMBER = 8;
    public static final int JUMPTO_FIELD_NUMBER = 16;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int NEEDLOGIN_FIELD_NUMBER = 19;
    public static final int NOTICE_FIELD_NUMBER = 17;
    public static final int POINTINFO_FIELD_NUMBER = 9;
    public static final int REFERSHMETERS_FIELD_NUMBER = 14;
    public static final int REFRESHSEC_FIELD_NUMBER = 13;
    public static final int SHARE_FIELD_NUMBER = 5;
    /* renamed from: A */
    private int f12326A = 0;
    /* renamed from: B */
    private boolean f12327B;
    /* renamed from: C */
    private String f12328C = "";
    /* renamed from: D */
    private boolean f12329D;
    /* renamed from: E */
    private String f12330E = "";
    /* renamed from: F */
    private boolean f12331F;
    /* renamed from: G */
    private String f12332G = "";
    /* renamed from: H */
    private boolean f12333H;
    /* renamed from: I */
    private String f12334I = "";
    /* renamed from: J */
    private boolean f12335J;
    /* renamed from: K */
    private String f12336K = "";
    /* renamed from: L */
    private int f12337L = -1;
    /* renamed from: a */
    private boolean f12338a;
    /* renamed from: b */
    private String f12339b = "";
    /* renamed from: c */
    private boolean f12340c;
    /* renamed from: d */
    private int f12341d = 0;
    /* renamed from: e */
    private boolean f12342e;
    /* renamed from: f */
    private int f12343f = 0;
    /* renamed from: g */
    private boolean f12344g;
    /* renamed from: h */
    private String f12345h = "";
    /* renamed from: i */
    private boolean f12346i;
    /* renamed from: j */
    private Share f12347j = null;
    /* renamed from: k */
    private boolean f12348k;
    /* renamed from: l */
    private String f12349l = "";
    /* renamed from: m */
    private boolean f12350m;
    /* renamed from: n */
    private String f12351n = "";
    /* renamed from: o */
    private boolean f12352o;
    /* renamed from: p */
    private String f12353p = "";
    /* renamed from: q */
    private List<Poi> f12354q = Collections.emptyList();
    /* renamed from: r */
    private boolean f12355r;
    /* renamed from: s */
    private String f12356s = "";
    /* renamed from: t */
    private boolean f12357t;
    /* renamed from: u */
    private String f12358u = "";
    /* renamed from: v */
    private boolean f12359v;
    /* renamed from: w */
    private String f12360w = "";
    /* renamed from: x */
    private boolean f12361x;
    /* renamed from: y */
    private int f12362y = 0;
    /* renamed from: z */
    private boolean f12363z;

    public static final class Poi extends MessageMicro {
        public static final int ADDRESSCOLOR_FIELD_NUMBER = 15;
        public static final int ADDRESS_FIELD_NUMBER = 8;
        public static final int BUTTONS_FIELD_NUMBER = 17;
        public static final int DESBRIEF_FIELD_NUMBER = 10;
        public static final int DESTITLE_FIELD_NUMBER = 9;
        public static final int ICON_FIELD_NUMBER = 2;
        public static final int IMAGEBOTTOM_FIELD_NUMBER = 4;
        public static final int IMAGETOP_FIELD_NUMBER = 3;
        public static final int LINECOLOR_FIELD_NUMBER = 16;
        public static final int LOCATION_FIELD_NUMBER = 5;
        public static final int SHOWTYPE_FIELD_NUMBER = 6;
        public static final int TITLECOLOR_FIELD_NUMBER = 14;
        public static final int TITLE_FIELD_NUMBER = 7;
        public static final int TOPCOLOR_FIELD_NUMBER = 12;
        public static final int TOPICONTYPE_FIELD_NUMBER = 13;
        public static final int UID_FIELD_NUMBER = 1;
        public static final int URL_FIELD_NUMBER = 11;
        /* renamed from: A */
        private boolean f12279A;
        /* renamed from: B */
        private String f12280B = "";
        /* renamed from: C */
        private boolean f12281C;
        /* renamed from: D */
        private String f12282D = "";
        /* renamed from: E */
        private boolean f12283E;
        /* renamed from: F */
        private String f12284F = "";
        /* renamed from: G */
        private List<Button> f12285G = Collections.emptyList();
        /* renamed from: H */
        private int f12286H = -1;
        /* renamed from: a */
        private boolean f12287a;
        /* renamed from: b */
        private String f12288b = "";
        /* renamed from: c */
        private boolean f12289c;
        /* renamed from: d */
        private String f12290d = "";
        /* renamed from: e */
        private boolean f12291e;
        /* renamed from: f */
        private String f12292f = "";
        /* renamed from: g */
        private boolean f12293g;
        /* renamed from: h */
        private String f12294h = "";
        /* renamed from: i */
        private boolean f12295i;
        /* renamed from: j */
        private String f12296j = "";
        /* renamed from: k */
        private boolean f12297k;
        /* renamed from: l */
        private int f12298l = 0;
        /* renamed from: m */
        private boolean f12299m;
        /* renamed from: n */
        private String f12300n = "";
        /* renamed from: o */
        private boolean f12301o;
        /* renamed from: p */
        private String f12302p = "";
        /* renamed from: q */
        private boolean f12303q;
        /* renamed from: r */
        private String f12304r = "";
        /* renamed from: s */
        private boolean f12305s;
        /* renamed from: t */
        private String f12306t = "";
        /* renamed from: u */
        private boolean f12307u;
        /* renamed from: v */
        private String f12308v = "";
        /* renamed from: w */
        private boolean f12309w;
        /* renamed from: x */
        private String f12310x = "";
        /* renamed from: y */
        private boolean f12311y;
        /* renamed from: z */
        private int f12312z = 0;

        public static final class Button extends MessageMicro {
            public static final int BUTTONICON_FIELD_NUMBER = 4;
            public static final int TITLE_FIELD_NUMBER = 1;
            public static final int TYPE_FIELD_NUMBER = 2;
            public static final int URL_FIELD_NUMBER = 3;
            /* renamed from: a */
            private boolean f12270a;
            /* renamed from: b */
            private String f12271b = "";
            /* renamed from: c */
            private boolean f12272c;
            /* renamed from: d */
            private int f12273d = 0;
            /* renamed from: e */
            private boolean f12274e;
            /* renamed from: f */
            private String f12275f = "";
            /* renamed from: g */
            private boolean f12276g;
            /* renamed from: h */
            private String f12277h = "";
            /* renamed from: i */
            private int f12278i = -1;

            public static Button parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new Button().mergeFrom(codedInputStreamMicro);
            }

            public static Button parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (Button) new Button().mergeFrom(bArr);
            }

            public final Button clear() {
                clearTitle();
                clearType();
                clearUrl();
                clearButtonicon();
                this.f12278i = -1;
                return this;
            }

            public Button clearButtonicon() {
                this.f12276g = false;
                this.f12277h = "";
                return this;
            }

            public Button clearTitle() {
                this.f12270a = false;
                this.f12271b = "";
                return this;
            }

            public Button clearType() {
                this.f12272c = false;
                this.f12273d = 0;
                return this;
            }

            public Button clearUrl() {
                this.f12274e = false;
                this.f12275f = "";
                return this;
            }

            public String getButtonicon() {
                return this.f12277h;
            }

            public int getCachedSize() {
                if (this.f12278i < 0) {
                    getSerializedSize();
                }
                return this.f12278i;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasTitle()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
                }
                if (hasType()) {
                    i += CodedOutputStreamMicro.computeInt32Size(2, getType());
                }
                if (hasUrl()) {
                    i += CodedOutputStreamMicro.computeStringSize(3, getUrl());
                }
                if (hasButtonicon()) {
                    i += CodedOutputStreamMicro.computeStringSize(4, getButtonicon());
                }
                this.f12278i = i;
                return i;
            }

            public String getTitle() {
                return this.f12271b;
            }

            public int getType() {
                return this.f12273d;
            }

            public String getUrl() {
                return this.f12275f;
            }

            public boolean hasButtonicon() {
                return this.f12276g;
            }

            public boolean hasTitle() {
                return this.f12270a;
            }

            public boolean hasType() {
                return this.f12272c;
            }

            public boolean hasUrl() {
                return this.f12274e;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Button mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setTitle(codedInputStreamMicro.readString());
                            continue;
                        case 16:
                            setType(codedInputStreamMicro.readInt32());
                            continue;
                        case 26:
                            setUrl(codedInputStreamMicro.readString());
                            continue;
                        case 34:
                            setButtonicon(codedInputStreamMicro.readString());
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

            public Button setButtonicon(String str) {
                this.f12276g = true;
                this.f12277h = str;
                return this;
            }

            public Button setTitle(String str) {
                this.f12270a = true;
                this.f12271b = str;
                return this;
            }

            public Button setType(int i) {
                this.f12272c = true;
                this.f12273d = i;
                return this;
            }

            public Button setUrl(String str) {
                this.f12274e = true;
                this.f12275f = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasTitle()) {
                    codedOutputStreamMicro.writeString(1, getTitle());
                }
                if (hasType()) {
                    codedOutputStreamMicro.writeInt32(2, getType());
                }
                if (hasUrl()) {
                    codedOutputStreamMicro.writeString(3, getUrl());
                }
                if (hasButtonicon()) {
                    codedOutputStreamMicro.writeString(4, getButtonicon());
                }
            }
        }

        public static Poi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Poi().mergeFrom(codedInputStreamMicro);
        }

        public static Poi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Poi) new Poi().mergeFrom(bArr);
        }

        public Poi addButtons(Button button) {
            if (button != null) {
                if (this.f12285G.isEmpty()) {
                    this.f12285G = new ArrayList();
                }
                this.f12285G.add(button);
            }
            return this;
        }

        public final Poi clear() {
            clearUid();
            clearIcon();
            clearImagetop();
            clearImagebottom();
            clearLocation();
            clearShowtype();
            clearTitle();
            clearAddress();
            clearDestitle();
            clearDesbrief();
            clearUrl();
            clearTopcolor();
            clearTopicontype();
            clearTitlecolor();
            clearAddresscolor();
            clearLinecolor();
            clearButtons();
            this.f12286H = -1;
            return this;
        }

        public Poi clearAddress() {
            this.f12301o = false;
            this.f12302p = "";
            return this;
        }

        public Poi clearAddresscolor() {
            this.f12281C = false;
            this.f12282D = "";
            return this;
        }

        public Poi clearButtons() {
            this.f12285G = Collections.emptyList();
            return this;
        }

        public Poi clearDesbrief() {
            this.f12305s = false;
            this.f12306t = "";
            return this;
        }

        public Poi clearDestitle() {
            this.f12303q = false;
            this.f12304r = "";
            return this;
        }

        public Poi clearIcon() {
            this.f12289c = false;
            this.f12290d = "";
            return this;
        }

        public Poi clearImagebottom() {
            this.f12293g = false;
            this.f12294h = "";
            return this;
        }

        public Poi clearImagetop() {
            this.f12291e = false;
            this.f12292f = "";
            return this;
        }

        public Poi clearLinecolor() {
            this.f12283E = false;
            this.f12284F = "";
            return this;
        }

        public Poi clearLocation() {
            this.f12295i = false;
            this.f12296j = "";
            return this;
        }

        public Poi clearShowtype() {
            this.f12297k = false;
            this.f12298l = 0;
            return this;
        }

        public Poi clearTitle() {
            this.f12299m = false;
            this.f12300n = "";
            return this;
        }

        public Poi clearTitlecolor() {
            this.f12279A = false;
            this.f12280B = "";
            return this;
        }

        public Poi clearTopcolor() {
            this.f12309w = false;
            this.f12310x = "";
            return this;
        }

        public Poi clearTopicontype() {
            this.f12311y = false;
            this.f12312z = 0;
            return this;
        }

        public Poi clearUid() {
            this.f12287a = false;
            this.f12288b = "";
            return this;
        }

        public Poi clearUrl() {
            this.f12307u = false;
            this.f12308v = "";
            return this;
        }

        public String getAddress() {
            return this.f12302p;
        }

        public String getAddresscolor() {
            return this.f12282D;
        }

        public Button getButtons(int i) {
            return (Button) this.f12285G.get(i);
        }

        public int getButtonsCount() {
            return this.f12285G.size();
        }

        public List<Button> getButtonsList() {
            return this.f12285G;
        }

        public int getCachedSize() {
            if (this.f12286H < 0) {
                getSerializedSize();
            }
            return this.f12286H;
        }

        public String getDesbrief() {
            return this.f12306t;
        }

        public String getDestitle() {
            return this.f12304r;
        }

        public String getIcon() {
            return this.f12290d;
        }

        public String getImagebottom() {
            return this.f12294h;
        }

        public String getImagetop() {
            return this.f12292f;
        }

        public String getLinecolor() {
            return this.f12284F;
        }

        public String getLocation() {
            return this.f12296j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
            }
            if (hasIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getIcon());
            }
            if (hasImagetop()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getImagetop());
            }
            if (hasImagebottom()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getImagebottom());
            }
            if (hasLocation()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getLocation());
            }
            if (hasShowtype()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getShowtype());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getTitle());
            }
            if (hasAddress()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getAddress());
            }
            if (hasDestitle()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getDestitle());
            }
            if (hasDesbrief()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getDesbrief());
            }
            if (hasUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getUrl());
            }
            if (hasTopcolor()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getTopcolor());
            }
            if (hasTopicontype()) {
                i += CodedOutputStreamMicro.computeInt32Size(13, getTopicontype());
            }
            if (hasTitlecolor()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getTitlecolor());
            }
            if (hasAddresscolor()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getAddresscolor());
            }
            if (hasLinecolor()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getLinecolor());
            }
            int i2 = i;
            for (Button computeMessageSize : getButtonsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(17, computeMessageSize) + i2;
            }
            this.f12286H = i2;
            return i2;
        }

        public int getShowtype() {
            return this.f12298l;
        }

        public String getTitle() {
            return this.f12300n;
        }

        public String getTitlecolor() {
            return this.f12280B;
        }

        public String getTopcolor() {
            return this.f12310x;
        }

        public int getTopicontype() {
            return this.f12312z;
        }

        public String getUid() {
            return this.f12288b;
        }

        public String getUrl() {
            return this.f12308v;
        }

        public boolean hasAddress() {
            return this.f12301o;
        }

        public boolean hasAddresscolor() {
            return this.f12281C;
        }

        public boolean hasDesbrief() {
            return this.f12305s;
        }

        public boolean hasDestitle() {
            return this.f12303q;
        }

        public boolean hasIcon() {
            return this.f12289c;
        }

        public boolean hasImagebottom() {
            return this.f12293g;
        }

        public boolean hasImagetop() {
            return this.f12291e;
        }

        public boolean hasLinecolor() {
            return this.f12283E;
        }

        public boolean hasLocation() {
            return this.f12295i;
        }

        public boolean hasShowtype() {
            return this.f12297k;
        }

        public boolean hasTitle() {
            return this.f12299m;
        }

        public boolean hasTitlecolor() {
            return this.f12279A;
        }

        public boolean hasTopcolor() {
            return this.f12309w;
        }

        public boolean hasTopicontype() {
            return this.f12311y;
        }

        public boolean hasUid() {
            return this.f12287a;
        }

        public boolean hasUrl() {
            return this.f12307u;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Poi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setImagetop(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setImagebottom(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setLocation(codedInputStreamMicro.readString());
                        continue;
                    case 48:
                        setShowtype(codedInputStreamMicro.readInt32());
                        continue;
                    case 58:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setAddress(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setDestitle(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setDesbrief(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setUrl(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setTopcolor(codedInputStreamMicro.readString());
                        continue;
                    case 104:
                        setTopicontype(codedInputStreamMicro.readInt32());
                        continue;
                    case 114:
                        setTitlecolor(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setAddresscolor(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setLinecolor(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        MessageMicro button = new Button();
                        codedInputStreamMicro.readMessage(button);
                        addButtons(button);
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

        public Poi setAddress(String str) {
            this.f12301o = true;
            this.f12302p = str;
            return this;
        }

        public Poi setAddresscolor(String str) {
            this.f12281C = true;
            this.f12282D = str;
            return this;
        }

        public Poi setButtons(int i, Button button) {
            if (button != null) {
                this.f12285G.set(i, button);
            }
            return this;
        }

        public Poi setDesbrief(String str) {
            this.f12305s = true;
            this.f12306t = str;
            return this;
        }

        public Poi setDestitle(String str) {
            this.f12303q = true;
            this.f12304r = str;
            return this;
        }

        public Poi setIcon(String str) {
            this.f12289c = true;
            this.f12290d = str;
            return this;
        }

        public Poi setImagebottom(String str) {
            this.f12293g = true;
            this.f12294h = str;
            return this;
        }

        public Poi setImagetop(String str) {
            this.f12291e = true;
            this.f12292f = str;
            return this;
        }

        public Poi setLinecolor(String str) {
            this.f12283E = true;
            this.f12284F = str;
            return this;
        }

        public Poi setLocation(String str) {
            this.f12295i = true;
            this.f12296j = str;
            return this;
        }

        public Poi setShowtype(int i) {
            this.f12297k = true;
            this.f12298l = i;
            return this;
        }

        public Poi setTitle(String str) {
            this.f12299m = true;
            this.f12300n = str;
            return this;
        }

        public Poi setTitlecolor(String str) {
            this.f12279A = true;
            this.f12280B = str;
            return this;
        }

        public Poi setTopcolor(String str) {
            this.f12309w = true;
            this.f12310x = str;
            return this;
        }

        public Poi setTopicontype(int i) {
            this.f12311y = true;
            this.f12312z = i;
            return this;
        }

        public Poi setUid(String str) {
            this.f12287a = true;
            this.f12288b = str;
            return this;
        }

        public Poi setUrl(String str) {
            this.f12307u = true;
            this.f12308v = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUid()) {
                codedOutputStreamMicro.writeString(1, getUid());
            }
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(2, getIcon());
            }
            if (hasImagetop()) {
                codedOutputStreamMicro.writeString(3, getImagetop());
            }
            if (hasImagebottom()) {
                codedOutputStreamMicro.writeString(4, getImagebottom());
            }
            if (hasLocation()) {
                codedOutputStreamMicro.writeString(5, getLocation());
            }
            if (hasShowtype()) {
                codedOutputStreamMicro.writeInt32(6, getShowtype());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(7, getTitle());
            }
            if (hasAddress()) {
                codedOutputStreamMicro.writeString(8, getAddress());
            }
            if (hasDestitle()) {
                codedOutputStreamMicro.writeString(9, getDestitle());
            }
            if (hasDesbrief()) {
                codedOutputStreamMicro.writeString(10, getDesbrief());
            }
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(11, getUrl());
            }
            if (hasTopcolor()) {
                codedOutputStreamMicro.writeString(12, getTopcolor());
            }
            if (hasTopicontype()) {
                codedOutputStreamMicro.writeInt32(13, getTopicontype());
            }
            if (hasTitlecolor()) {
                codedOutputStreamMicro.writeString(14, getTitlecolor());
            }
            if (hasAddresscolor()) {
                codedOutputStreamMicro.writeString(15, getAddresscolor());
            }
            if (hasLinecolor()) {
                codedOutputStreamMicro.writeString(16, getLinecolor());
            }
            for (Button writeMessage : getButtonsList()) {
                codedOutputStreamMicro.writeMessage(17, writeMessage);
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
        private boolean f12313a;
        /* renamed from: b */
        private String f12314b = "";
        /* renamed from: c */
        private boolean f12315c;
        /* renamed from: d */
        private String f12316d = "";
        /* renamed from: e */
        private boolean f12317e;
        /* renamed from: f */
        private String f12318f = "";
        /* renamed from: g */
        private boolean f12319g;
        /* renamed from: h */
        private String f12320h = "";
        /* renamed from: i */
        private boolean f12321i;
        /* renamed from: j */
        private String f12322j = "";
        /* renamed from: k */
        private boolean f12323k;
        /* renamed from: l */
        private String f12324l = "";
        /* renamed from: m */
        private int f12325m = -1;

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
            this.f12325m = -1;
            return this;
        }

        public Share clearBigicon() {
            this.f12323k = false;
            this.f12324l = "";
            return this;
        }

        public Share clearLongcontent() {
            this.f12319g = false;
            this.f12320h = "";
            return this;
        }

        public Share clearShortcontent() {
            this.f12317e = false;
            this.f12318f = "";
            return this;
        }

        public Share clearSmallicon() {
            this.f12321i = false;
            this.f12322j = "";
            return this;
        }

        public Share clearTitle() {
            this.f12315c = false;
            this.f12316d = "";
            return this;
        }

        public Share clearUrl() {
            this.f12313a = false;
            this.f12314b = "";
            return this;
        }

        public String getBigicon() {
            return this.f12324l;
        }

        public int getCachedSize() {
            if (this.f12325m < 0) {
                getSerializedSize();
            }
            return this.f12325m;
        }

        public String getLongcontent() {
            return this.f12320h;
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
            this.f12325m = i;
            return i;
        }

        public String getShortcontent() {
            return this.f12318f;
        }

        public String getSmallicon() {
            return this.f12322j;
        }

        public String getTitle() {
            return this.f12316d;
        }

        public String getUrl() {
            return this.f12314b;
        }

        public boolean hasBigicon() {
            return this.f12323k;
        }

        public boolean hasLongcontent() {
            return this.f12319g;
        }

        public boolean hasShortcontent() {
            return this.f12317e;
        }

        public boolean hasSmallicon() {
            return this.f12321i;
        }

        public boolean hasTitle() {
            return this.f12315c;
        }

        public boolean hasUrl() {
            return this.f12313a;
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
            this.f12323k = true;
            this.f12324l = str;
            return this;
        }

        public Share setLongcontent(String str) {
            this.f12319g = true;
            this.f12320h = str;
            return this;
        }

        public Share setShortcontent(String str) {
            this.f12317e = true;
            this.f12318f = str;
            return this;
        }

        public Share setSmallicon(String str) {
            this.f12321i = true;
            this.f12322j = str;
            return this;
        }

        public Share setTitle(String str) {
            this.f12315c = true;
            this.f12316d = str;
            return this;
        }

        public Share setUrl(String str) {
            this.f12313a = true;
            this.f12314b = str;
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

    public static Opnlayer parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new Opnlayer().mergeFrom(codedInputStreamMicro);
    }

    public static Opnlayer parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (Opnlayer) new Opnlayer().mergeFrom(bArr);
    }

    public Opnlayer addPointinfo(Poi poi) {
        if (poi != null) {
            if (this.f12354q.isEmpty()) {
                this.f12354q = new ArrayList();
            }
            this.f12354q.add(poi);
        }
        return this;
    }

    public final Opnlayer clear() {
        clearEventtitle();
        clearEventtype();
        clearLevel();
        clearCenter();
        clearShare();
        clearIcon();
        clearImagebottom();
        clearImagetop();
        clearPointinfo();
        clearBorderlb();
        clearBorderrt();
        clearImagebutton();
        clearRefreshsec();
        clearRefershmeters();
        clearBottomicon();
        clearJumpto();
        clearNotice();
        clearFirstshow();
        clearNeedlogin();
        this.f12337L = -1;
        return this;
    }

    public Opnlayer clearBorderlb() {
        this.f12355r = false;
        this.f12356s = "";
        return this;
    }

    public Opnlayer clearBorderrt() {
        this.f12357t = false;
        this.f12358u = "";
        return this;
    }

    public Opnlayer clearBottomicon() {
        this.f12327B = false;
        this.f12328C = "";
        return this;
    }

    public Opnlayer clearCenter() {
        this.f12344g = false;
        this.f12345h = "";
        return this;
    }

    public Opnlayer clearEventtitle() {
        this.f12338a = false;
        this.f12339b = "";
        return this;
    }

    public Opnlayer clearEventtype() {
        this.f12340c = false;
        this.f12341d = 0;
        return this;
    }

    public Opnlayer clearFirstshow() {
        this.f12333H = false;
        this.f12334I = "";
        return this;
    }

    public Opnlayer clearIcon() {
        this.f12348k = false;
        this.f12349l = "";
        return this;
    }

    public Opnlayer clearImagebottom() {
        this.f12350m = false;
        this.f12351n = "";
        return this;
    }

    public Opnlayer clearImagebutton() {
        this.f12359v = false;
        this.f12360w = "";
        return this;
    }

    public Opnlayer clearImagetop() {
        this.f12352o = false;
        this.f12353p = "";
        return this;
    }

    public Opnlayer clearJumpto() {
        this.f12329D = false;
        this.f12330E = "";
        return this;
    }

    public Opnlayer clearLevel() {
        this.f12342e = false;
        this.f12343f = 0;
        return this;
    }

    public Opnlayer clearNeedlogin() {
        this.f12335J = false;
        this.f12336K = "";
        return this;
    }

    public Opnlayer clearNotice() {
        this.f12331F = false;
        this.f12332G = "";
        return this;
    }

    public Opnlayer clearPointinfo() {
        this.f12354q = Collections.emptyList();
        return this;
    }

    public Opnlayer clearRefershmeters() {
        this.f12363z = false;
        this.f12326A = 0;
        return this;
    }

    public Opnlayer clearRefreshsec() {
        this.f12361x = false;
        this.f12362y = 0;
        return this;
    }

    public Opnlayer clearShare() {
        this.f12346i = false;
        this.f12347j = null;
        return this;
    }

    public String getBorderlb() {
        return this.f12356s;
    }

    public String getBorderrt() {
        return this.f12358u;
    }

    public String getBottomicon() {
        return this.f12328C;
    }

    public int getCachedSize() {
        if (this.f12337L < 0) {
            getSerializedSize();
        }
        return this.f12337L;
    }

    public String getCenter() {
        return this.f12345h;
    }

    public String getEventtitle() {
        return this.f12339b;
    }

    public int getEventtype() {
        return this.f12341d;
    }

    public String getFirstshow() {
        return this.f12334I;
    }

    public String getIcon() {
        return this.f12349l;
    }

    public String getImagebottom() {
        return this.f12351n;
    }

    public String getImagebutton() {
        return this.f12360w;
    }

    public String getImagetop() {
        return this.f12353p;
    }

    public String getJumpto() {
        return this.f12330E;
    }

    public int getLevel() {
        return this.f12343f;
    }

    public String getNeedlogin() {
        return this.f12336K;
    }

    public String getNotice() {
        return this.f12332G;
    }

    public Poi getPointinfo(int i) {
        return (Poi) this.f12354q.get(i);
    }

    public int getPointinfoCount() {
        return this.f12354q.size();
    }

    public List<Poi> getPointinfoList() {
        return this.f12354q;
    }

    public int getRefershmeters() {
        return this.f12326A;
    }

    public int getRefreshsec() {
        return this.f12362y;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasEventtitle()) {
            i = 0 + CodedOutputStreamMicro.computeStringSize(1, getEventtitle());
        }
        if (hasEventtype()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getEventtype());
        }
        if (hasLevel()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getLevel());
        }
        if (hasCenter()) {
            i += CodedOutputStreamMicro.computeStringSize(4, getCenter());
        }
        if (hasShare()) {
            i += CodedOutputStreamMicro.computeMessageSize(5, getShare());
        }
        if (hasIcon()) {
            i += CodedOutputStreamMicro.computeStringSize(6, getIcon());
        }
        if (hasImagebottom()) {
            i += CodedOutputStreamMicro.computeStringSize(7, getImagebottom());
        }
        if (hasImagetop()) {
            i += CodedOutputStreamMicro.computeStringSize(8, getImagetop());
        }
        int i2 = i;
        for (Poi computeMessageSize : getPointinfoList()) {
            i2 = CodedOutputStreamMicro.computeMessageSize(9, computeMessageSize) + i2;
        }
        if (hasBorderlb()) {
            i2 += CodedOutputStreamMicro.computeStringSize(10, getBorderlb());
        }
        if (hasBorderrt()) {
            i2 += CodedOutputStreamMicro.computeStringSize(11, getBorderrt());
        }
        if (hasImagebutton()) {
            i2 += CodedOutputStreamMicro.computeStringSize(12, getImagebutton());
        }
        if (hasRefreshsec()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(13, getRefreshsec());
        }
        if (hasRefershmeters()) {
            i2 += CodedOutputStreamMicro.computeInt32Size(14, getRefershmeters());
        }
        if (hasBottomicon()) {
            i2 += CodedOutputStreamMicro.computeStringSize(15, getBottomicon());
        }
        if (hasJumpto()) {
            i2 += CodedOutputStreamMicro.computeStringSize(16, getJumpto());
        }
        if (hasNotice()) {
            i2 += CodedOutputStreamMicro.computeStringSize(17, getNotice());
        }
        if (hasFirstshow()) {
            i2 += CodedOutputStreamMicro.computeStringSize(18, getFirstshow());
        }
        if (hasNeedlogin()) {
            i2 += CodedOutputStreamMicro.computeStringSize(19, getNeedlogin());
        }
        this.f12337L = i2;
        return i2;
    }

    public Share getShare() {
        return this.f12347j;
    }

    public boolean hasBorderlb() {
        return this.f12355r;
    }

    public boolean hasBorderrt() {
        return this.f12357t;
    }

    public boolean hasBottomicon() {
        return this.f12327B;
    }

    public boolean hasCenter() {
        return this.f12344g;
    }

    public boolean hasEventtitle() {
        return this.f12338a;
    }

    public boolean hasEventtype() {
        return this.f12340c;
    }

    public boolean hasFirstshow() {
        return this.f12333H;
    }

    public boolean hasIcon() {
        return this.f12348k;
    }

    public boolean hasImagebottom() {
        return this.f12350m;
    }

    public boolean hasImagebutton() {
        return this.f12359v;
    }

    public boolean hasImagetop() {
        return this.f12352o;
    }

    public boolean hasJumpto() {
        return this.f12329D;
    }

    public boolean hasLevel() {
        return this.f12342e;
    }

    public boolean hasNeedlogin() {
        return this.f12335J;
    }

    public boolean hasNotice() {
        return this.f12331F;
    }

    public boolean hasRefershmeters() {
        return this.f12363z;
    }

    public boolean hasRefreshsec() {
        return this.f12361x;
    }

    public boolean hasShare() {
        return this.f12346i;
    }

    public final boolean isInitialized() {
        return true;
    }

    public Opnlayer mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro share;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    setEventtitle(codedInputStreamMicro.readString());
                    continue;
                case 16:
                    setEventtype(codedInputStreamMicro.readInt32());
                    continue;
                case 24:
                    setLevel(codedInputStreamMicro.readInt32());
                    continue;
                case 34:
                    setCenter(codedInputStreamMicro.readString());
                    continue;
                case 42:
                    share = new Share();
                    codedInputStreamMicro.readMessage(share);
                    setShare(share);
                    continue;
                case 50:
                    setIcon(codedInputStreamMicro.readString());
                    continue;
                case 58:
                    setImagebottom(codedInputStreamMicro.readString());
                    continue;
                case 66:
                    setImagetop(codedInputStreamMicro.readString());
                    continue;
                case 74:
                    share = new Poi();
                    codedInputStreamMicro.readMessage(share);
                    addPointinfo(share);
                    continue;
                case 82:
                    setBorderlb(codedInputStreamMicro.readString());
                    continue;
                case 90:
                    setBorderrt(codedInputStreamMicro.readString());
                    continue;
                case 98:
                    setImagebutton(codedInputStreamMicro.readString());
                    continue;
                case 104:
                    setRefreshsec(codedInputStreamMicro.readInt32());
                    continue;
                case 112:
                    setRefershmeters(codedInputStreamMicro.readInt32());
                    continue;
                case C1253f.df /*122*/:
                    setBottomicon(codedInputStreamMicro.readString());
                    continue;
                case 130:
                    setJumpto(codedInputStreamMicro.readString());
                    continue;
                case 138:
                    setNotice(codedInputStreamMicro.readString());
                    continue;
                case 146:
                    setFirstshow(codedInputStreamMicro.readString());
                    continue;
                case 154:
                    setNeedlogin(codedInputStreamMicro.readString());
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

    public Opnlayer setBorderlb(String str) {
        this.f12355r = true;
        this.f12356s = str;
        return this;
    }

    public Opnlayer setBorderrt(String str) {
        this.f12357t = true;
        this.f12358u = str;
        return this;
    }

    public Opnlayer setBottomicon(String str) {
        this.f12327B = true;
        this.f12328C = str;
        return this;
    }

    public Opnlayer setCenter(String str) {
        this.f12344g = true;
        this.f12345h = str;
        return this;
    }

    public Opnlayer setEventtitle(String str) {
        this.f12338a = true;
        this.f12339b = str;
        return this;
    }

    public Opnlayer setEventtype(int i) {
        this.f12340c = true;
        this.f12341d = i;
        return this;
    }

    public Opnlayer setFirstshow(String str) {
        this.f12333H = true;
        this.f12334I = str;
        return this;
    }

    public Opnlayer setIcon(String str) {
        this.f12348k = true;
        this.f12349l = str;
        return this;
    }

    public Opnlayer setImagebottom(String str) {
        this.f12350m = true;
        this.f12351n = str;
        return this;
    }

    public Opnlayer setImagebutton(String str) {
        this.f12359v = true;
        this.f12360w = str;
        return this;
    }

    public Opnlayer setImagetop(String str) {
        this.f12352o = true;
        this.f12353p = str;
        return this;
    }

    public Opnlayer setJumpto(String str) {
        this.f12329D = true;
        this.f12330E = str;
        return this;
    }

    public Opnlayer setLevel(int i) {
        this.f12342e = true;
        this.f12343f = i;
        return this;
    }

    public Opnlayer setNeedlogin(String str) {
        this.f12335J = true;
        this.f12336K = str;
        return this;
    }

    public Opnlayer setNotice(String str) {
        this.f12331F = true;
        this.f12332G = str;
        return this;
    }

    public Opnlayer setPointinfo(int i, Poi poi) {
        if (poi != null) {
            this.f12354q.set(i, poi);
        }
        return this;
    }

    public Opnlayer setRefershmeters(int i) {
        this.f12363z = true;
        this.f12326A = i;
        return this;
    }

    public Opnlayer setRefreshsec(int i) {
        this.f12361x = true;
        this.f12362y = i;
        return this;
    }

    public Opnlayer setShare(Share share) {
        if (share == null) {
            return clearShare();
        }
        this.f12346i = true;
        this.f12347j = share;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasEventtitle()) {
            codedOutputStreamMicro.writeString(1, getEventtitle());
        }
        if (hasEventtype()) {
            codedOutputStreamMicro.writeInt32(2, getEventtype());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeInt32(3, getLevel());
        }
        if (hasCenter()) {
            codedOutputStreamMicro.writeString(4, getCenter());
        }
        if (hasShare()) {
            codedOutputStreamMicro.writeMessage(5, getShare());
        }
        if (hasIcon()) {
            codedOutputStreamMicro.writeString(6, getIcon());
        }
        if (hasImagebottom()) {
            codedOutputStreamMicro.writeString(7, getImagebottom());
        }
        if (hasImagetop()) {
            codedOutputStreamMicro.writeString(8, getImagetop());
        }
        for (Poi writeMessage : getPointinfoList()) {
            codedOutputStreamMicro.writeMessage(9, writeMessage);
        }
        if (hasBorderlb()) {
            codedOutputStreamMicro.writeString(10, getBorderlb());
        }
        if (hasBorderrt()) {
            codedOutputStreamMicro.writeString(11, getBorderrt());
        }
        if (hasImagebutton()) {
            codedOutputStreamMicro.writeString(12, getImagebutton());
        }
        if (hasRefreshsec()) {
            codedOutputStreamMicro.writeInt32(13, getRefreshsec());
        }
        if (hasRefershmeters()) {
            codedOutputStreamMicro.writeInt32(14, getRefershmeters());
        }
        if (hasBottomicon()) {
            codedOutputStreamMicro.writeString(15, getBottomicon());
        }
        if (hasJumpto()) {
            codedOutputStreamMicro.writeString(16, getJumpto());
        }
        if (hasNotice()) {
            codedOutputStreamMicro.writeString(17, getNotice());
        }
        if (hasFirstshow()) {
            codedOutputStreamMicro.writeString(18, getFirstshow());
        }
        if (hasNeedlogin()) {
            codedOutputStreamMicro.writeString(19, getNeedlogin());
        }
    }
}
