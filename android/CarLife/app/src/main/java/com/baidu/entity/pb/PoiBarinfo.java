package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PoiBarinfo extends MessageMicro {
    public static final int BARINFO_FETTER_FIELD_NUMBER = 2;
    public static final int BARINFO_FREE_FIELD_NUMBER = 1;
    public static final int BARINFO_OTHER_FIELD_NUMBER = 3;
    public static final int EXT_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 4;
    /* renamed from: a */
    private List<Barinfo> f12463a = Collections.emptyList();
    /* renamed from: b */
    private List<Barinfo> f12464b = Collections.emptyList();
    /* renamed from: c */
    private List<Barinfo> f12465c = Collections.emptyList();
    /* renamed from: d */
    private boolean f12466d;
    /* renamed from: e */
    private String f12467e = "";
    /* renamed from: f */
    private boolean f12468f;
    /* renamed from: g */
    private String f12469g = "";
    /* renamed from: h */
    private int f12470h = -1;

    public static final class Barinfo extends MessageMicro {
        public static final int ACTION_FIELD_NUMBER = 6;
        public static final int ACTION_TYPE_FIELD_NUMBER = 5;
        public static final int DEFAULT_SELECT_FIELD_NUMBER = 7;
        public static final int FROMSV_FIELD_NUMBER = 8;
        public static final int ICON_ID_FIELD_NUMBER = 1;
        public static final int ICON_URL_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int OPERATION_ICON_URL_FIELD_NUMBER = 3;
        public static final int TOSV_FIELD_NUMBER = 9;
        /* renamed from: a */
        private boolean f12444a;
        /* renamed from: b */
        private String f12445b = "";
        /* renamed from: c */
        private boolean f12446c;
        /* renamed from: d */
        private String f12447d = "";
        /* renamed from: e */
        private boolean f12448e;
        /* renamed from: f */
        private String f12449f = "";
        /* renamed from: g */
        private boolean f12450g;
        /* renamed from: h */
        private String f12451h = "";
        /* renamed from: i */
        private boolean f12452i;
        /* renamed from: j */
        private String f12453j = "";
        /* renamed from: k */
        private boolean f12454k;
        /* renamed from: l */
        private String f12455l = "";
        /* renamed from: m */
        private boolean f12456m;
        /* renamed from: n */
        private int f12457n = 0;
        /* renamed from: o */
        private boolean f12458o;
        /* renamed from: p */
        private String f12459p = "";
        /* renamed from: q */
        private boolean f12460q;
        /* renamed from: r */
        private String f12461r = "";
        /* renamed from: s */
        private int f12462s = -1;

        public static Barinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Barinfo().mergeFrom(codedInputStreamMicro);
        }

        public static Barinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Barinfo) new Barinfo().mergeFrom(bArr);
        }

        public final Barinfo clear() {
            clearIconId();
            clearIconUrl();
            clearOperationIconUrl();
            clearName();
            clearActionType();
            clearAction();
            clearDefaultSelect();
            clearFromsv();
            clearTosv();
            this.f12462s = -1;
            return this;
        }

        public Barinfo clearAction() {
            this.f12454k = false;
            this.f12455l = "";
            return this;
        }

        public Barinfo clearActionType() {
            this.f12452i = false;
            this.f12453j = "";
            return this;
        }

        public Barinfo clearDefaultSelect() {
            this.f12456m = false;
            this.f12457n = 0;
            return this;
        }

        public Barinfo clearFromsv() {
            this.f12458o = false;
            this.f12459p = "";
            return this;
        }

        public Barinfo clearIconId() {
            this.f12444a = false;
            this.f12445b = "";
            return this;
        }

        public Barinfo clearIconUrl() {
            this.f12446c = false;
            this.f12447d = "";
            return this;
        }

        public Barinfo clearName() {
            this.f12450g = false;
            this.f12451h = "";
            return this;
        }

        public Barinfo clearOperationIconUrl() {
            this.f12448e = false;
            this.f12449f = "";
            return this;
        }

        public Barinfo clearTosv() {
            this.f12460q = false;
            this.f12461r = "";
            return this;
        }

        public String getAction() {
            return this.f12455l;
        }

        public String getActionType() {
            return this.f12453j;
        }

        public int getCachedSize() {
            if (this.f12462s < 0) {
                getSerializedSize();
            }
            return this.f12462s;
        }

        public int getDefaultSelect() {
            return this.f12457n;
        }

        public String getFromsv() {
            return this.f12459p;
        }

        public String getIconId() {
            return this.f12445b;
        }

        public String getIconUrl() {
            return this.f12447d;
        }

        public String getName() {
            return this.f12451h;
        }

        public String getOperationIconUrl() {
            return this.f12449f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIconId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIconId());
            }
            if (hasIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getIconUrl());
            }
            if (hasOperationIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getOperationIconUrl());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getName());
            }
            if (hasActionType()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getActionType());
            }
            if (hasAction()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getAction());
            }
            if (hasDefaultSelect()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getDefaultSelect());
            }
            if (hasFromsv()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getFromsv());
            }
            if (hasTosv()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getTosv());
            }
            this.f12462s = i;
            return i;
        }

        public String getTosv() {
            return this.f12461r;
        }

        public boolean hasAction() {
            return this.f12454k;
        }

        public boolean hasActionType() {
            return this.f12452i;
        }

        public boolean hasDefaultSelect() {
            return this.f12456m;
        }

        public boolean hasFromsv() {
            return this.f12458o;
        }

        public boolean hasIconId() {
            return this.f12444a;
        }

        public boolean hasIconUrl() {
            return this.f12446c;
        }

        public boolean hasName() {
            return this.f12450g;
        }

        public boolean hasOperationIconUrl() {
            return this.f12448e;
        }

        public boolean hasTosv() {
            return this.f12460q;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Barinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIconId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setOperationIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setActionType(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setAction(codedInputStreamMicro.readString());
                        continue;
                    case 56:
                        setDefaultSelect(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setFromsv(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setTosv(codedInputStreamMicro.readString());
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

        public Barinfo setAction(String str) {
            this.f12454k = true;
            this.f12455l = str;
            return this;
        }

        public Barinfo setActionType(String str) {
            this.f12452i = true;
            this.f12453j = str;
            return this;
        }

        public Barinfo setDefaultSelect(int i) {
            this.f12456m = true;
            this.f12457n = i;
            return this;
        }

        public Barinfo setFromsv(String str) {
            this.f12458o = true;
            this.f12459p = str;
            return this;
        }

        public Barinfo setIconId(String str) {
            this.f12444a = true;
            this.f12445b = str;
            return this;
        }

        public Barinfo setIconUrl(String str) {
            this.f12446c = true;
            this.f12447d = str;
            return this;
        }

        public Barinfo setName(String str) {
            this.f12450g = true;
            this.f12451h = str;
            return this;
        }

        public Barinfo setOperationIconUrl(String str) {
            this.f12448e = true;
            this.f12449f = str;
            return this;
        }

        public Barinfo setTosv(String str) {
            this.f12460q = true;
            this.f12461r = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIconId()) {
                codedOutputStreamMicro.writeString(1, getIconId());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(2, getIconUrl());
            }
            if (hasOperationIconUrl()) {
                codedOutputStreamMicro.writeString(3, getOperationIconUrl());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(4, getName());
            }
            if (hasActionType()) {
                codedOutputStreamMicro.writeString(5, getActionType());
            }
            if (hasAction()) {
                codedOutputStreamMicro.writeString(6, getAction());
            }
            if (hasDefaultSelect()) {
                codedOutputStreamMicro.writeInt32(7, getDefaultSelect());
            }
            if (hasFromsv()) {
                codedOutputStreamMicro.writeString(8, getFromsv());
            }
            if (hasTosv()) {
                codedOutputStreamMicro.writeString(9, getTosv());
            }
        }
    }

    public static PoiBarinfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new PoiBarinfo().mergeFrom(codedInputStreamMicro);
    }

    public static PoiBarinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (PoiBarinfo) new PoiBarinfo().mergeFrom(bArr);
    }

    public PoiBarinfo addBarinfoFetter(Barinfo barinfo) {
        if (barinfo != null) {
            if (this.f12464b.isEmpty()) {
                this.f12464b = new ArrayList();
            }
            this.f12464b.add(barinfo);
        }
        return this;
    }

    public PoiBarinfo addBarinfoFree(Barinfo barinfo) {
        if (barinfo != null) {
            if (this.f12463a.isEmpty()) {
                this.f12463a = new ArrayList();
            }
            this.f12463a.add(barinfo);
        }
        return this;
    }

    public PoiBarinfo addBarinfoOther(Barinfo barinfo) {
        if (barinfo != null) {
            if (this.f12465c.isEmpty()) {
                this.f12465c = new ArrayList();
            }
            this.f12465c.add(barinfo);
        }
        return this;
    }

    public final PoiBarinfo clear() {
        clearBarinfoFree();
        clearBarinfoFetter();
        clearBarinfoOther();
        clearType();
        clearExt();
        this.f12470h = -1;
        return this;
    }

    public PoiBarinfo clearBarinfoFetter() {
        this.f12464b = Collections.emptyList();
        return this;
    }

    public PoiBarinfo clearBarinfoFree() {
        this.f12463a = Collections.emptyList();
        return this;
    }

    public PoiBarinfo clearBarinfoOther() {
        this.f12465c = Collections.emptyList();
        return this;
    }

    public PoiBarinfo clearExt() {
        this.f12468f = false;
        this.f12469g = "";
        return this;
    }

    public PoiBarinfo clearType() {
        this.f12466d = false;
        this.f12467e = "";
        return this;
    }

    public Barinfo getBarinfoFetter(int i) {
        return (Barinfo) this.f12464b.get(i);
    }

    public int getBarinfoFetterCount() {
        return this.f12464b.size();
    }

    public List<Barinfo> getBarinfoFetterList() {
        return this.f12464b;
    }

    public Barinfo getBarinfoFree(int i) {
        return (Barinfo) this.f12463a.get(i);
    }

    public int getBarinfoFreeCount() {
        return this.f12463a.size();
    }

    public List<Barinfo> getBarinfoFreeList() {
        return this.f12463a;
    }

    public Barinfo getBarinfoOther(int i) {
        return (Barinfo) this.f12465c.get(i);
    }

    public int getBarinfoOtherCount() {
        return this.f12465c.size();
    }

    public List<Barinfo> getBarinfoOtherList() {
        return this.f12465c;
    }

    public int getCachedSize() {
        if (this.f12470h < 0) {
            getSerializedSize();
        }
        return this.f12470h;
    }

    public String getExt() {
        return this.f12469g;
    }

    public int getSerializedSize() {
        int i = 0;
        for (Barinfo computeMessageSize : getBarinfoFreeList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        for (Barinfo computeMessageSize2 : getBarinfoFetterList()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize2);
        }
        for (Barinfo computeMessageSize22 : getBarinfoOtherList()) {
            i += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize22);
        }
        if (hasType()) {
            i += CodedOutputStreamMicro.computeStringSize(4, getType());
        }
        if (hasExt()) {
            i += CodedOutputStreamMicro.computeStringSize(5, getExt());
        }
        this.f12470h = i;
        return i;
    }

    public String getType() {
        return this.f12467e;
    }

    public boolean hasExt() {
        return this.f12468f;
    }

    public boolean hasType() {
        return this.f12466d;
    }

    public final boolean isInitialized() {
        return true;
    }

    public PoiBarinfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro barinfo;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    barinfo = new Barinfo();
                    codedInputStreamMicro.readMessage(barinfo);
                    addBarinfoFree(barinfo);
                    continue;
                case 18:
                    barinfo = new Barinfo();
                    codedInputStreamMicro.readMessage(barinfo);
                    addBarinfoFetter(barinfo);
                    continue;
                case 26:
                    barinfo = new Barinfo();
                    codedInputStreamMicro.readMessage(barinfo);
                    addBarinfoOther(barinfo);
                    continue;
                case 34:
                    setType(codedInputStreamMicro.readString());
                    continue;
                case 42:
                    setExt(codedInputStreamMicro.readString());
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

    public PoiBarinfo setBarinfoFetter(int i, Barinfo barinfo) {
        if (barinfo != null) {
            this.f12464b.set(i, barinfo);
        }
        return this;
    }

    public PoiBarinfo setBarinfoFree(int i, Barinfo barinfo) {
        if (barinfo != null) {
            this.f12463a.set(i, barinfo);
        }
        return this;
    }

    public PoiBarinfo setBarinfoOther(int i, Barinfo barinfo) {
        if (barinfo != null) {
            this.f12465c.set(i, barinfo);
        }
        return this;
    }

    public PoiBarinfo setExt(String str) {
        this.f12468f = true;
        this.f12469g = str;
        return this;
    }

    public PoiBarinfo setType(String str) {
        this.f12466d = true;
        this.f12467e = str;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (Barinfo writeMessage : getBarinfoFreeList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        for (Barinfo writeMessage2 : getBarinfoFetterList()) {
            codedOutputStreamMicro.writeMessage(2, writeMessage2);
        }
        for (Barinfo writeMessage22 : getBarinfoOtherList()) {
            codedOutputStreamMicro.writeMessage(3, writeMessage22);
        }
        if (hasType()) {
            codedOutputStreamMicro.writeString(4, getType());
        }
        if (hasExt()) {
            codedOutputStreamMicro.writeString(5, getExt());
        }
    }
}
