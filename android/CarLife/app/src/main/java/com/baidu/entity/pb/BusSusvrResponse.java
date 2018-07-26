package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BusSusvrResponse extends MessageMicro {
    public static final int POI_ARRAY_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 2;
    /* renamed from: a */
    private List<PoiElement> f10427a = Collections.emptyList();
    /* renamed from: b */
    private boolean f10428b;
    /* renamed from: c */
    private int f10429c = 0;
    /* renamed from: d */
    private int f10430d = -1;

    public static final class PoiElement extends MessageMicro {
        public static final int CITYID_FIELD_NUMBER = 3;
        public static final int DISTANCE_FIELD_NUMBER = 4;
        public static final int POI_NAME_FIELD_NUMBER = 1;
        public static final int SUB_POI_ARRAY_FIELD_NUMBER = 6;
        public static final int SUB_POI_TYPE_FIELD_NUMBER = 5;
        public static final int SUB_TITLE_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 8;
        public static final int UID_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f10411a;
        /* renamed from: b */
        private String f10412b = "";
        /* renamed from: c */
        private boolean f10413c;
        /* renamed from: d */
        private String f10414d = "";
        /* renamed from: e */
        private boolean f10415e;
        /* renamed from: f */
        private int f10416f = 0;
        /* renamed from: g */
        private boolean f10417g;
        /* renamed from: h */
        private String f10418h = "";
        /* renamed from: i */
        private boolean f10419i;
        /* renamed from: j */
        private int f10420j = 0;
        /* renamed from: k */
        private List<SubPoi> f10421k = Collections.emptyList();
        /* renamed from: l */
        private boolean f10422l;
        /* renamed from: m */
        private String f10423m = "";
        /* renamed from: n */
        private boolean f10424n;
        /* renamed from: o */
        private int f10425o = 0;
        /* renamed from: p */
        private int f10426p = -1;

        public static final class SubPoi extends MessageMicro {
            public static final int POI_NAME_FIELD_NUMBER = 1;
            /* renamed from: a */
            private boolean f10408a;
            /* renamed from: b */
            private String f10409b = "";
            /* renamed from: c */
            private int f10410c = -1;

            public static SubPoi parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                return new SubPoi().mergeFrom(codedInputStreamMicro);
            }

            public static SubPoi parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
                return (SubPoi) new SubPoi().mergeFrom(bArr);
            }

            public final SubPoi clear() {
                clearPoiName();
                this.f10410c = -1;
                return this;
            }

            public SubPoi clearPoiName() {
                this.f10408a = false;
                this.f10409b = "";
                return this;
            }

            public int getCachedSize() {
                if (this.f10410c < 0) {
                    getSerializedSize();
                }
                return this.f10410c;
            }

            public String getPoiName() {
                return this.f10409b;
            }

            public int getSerializedSize() {
                int i = 0;
                if (hasPoiName()) {
                    i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
                }
                this.f10410c = i;
                return i;
            }

            public boolean hasPoiName() {
                return this.f10408a;
            }

            public final boolean isInitialized() {
                return true;
            }

            public SubPoi mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
                while (true) {
                    int readTag = codedInputStreamMicro.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            setPoiName(codedInputStreamMicro.readString());
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

            public SubPoi setPoiName(String str) {
                this.f10408a = true;
                this.f10409b = str;
                return this;
            }

            public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
                if (hasPoiName()) {
                    codedOutputStreamMicro.writeString(1, getPoiName());
                }
            }
        }

        public static PoiElement parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PoiElement().mergeFrom(codedInputStreamMicro);
        }

        public static PoiElement parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PoiElement) new PoiElement().mergeFrom(bArr);
        }

        public PoiElement addSubPoiArray(SubPoi subPoi) {
            if (subPoi != null) {
                if (this.f10421k.isEmpty()) {
                    this.f10421k = new ArrayList();
                }
                this.f10421k.add(subPoi);
            }
            return this;
        }

        public final PoiElement clear() {
            clearPoiName();
            clearSubTitle();
            clearCityid();
            clearDistance();
            clearSubPoiType();
            clearSubPoiArray();
            clearUid();
            clearType();
            this.f10426p = -1;
            return this;
        }

        public PoiElement clearCityid() {
            this.f10415e = false;
            this.f10416f = 0;
            return this;
        }

        public PoiElement clearDistance() {
            this.f10417g = false;
            this.f10418h = "";
            return this;
        }

        public PoiElement clearPoiName() {
            this.f10411a = false;
            this.f10412b = "";
            return this;
        }

        public PoiElement clearSubPoiArray() {
            this.f10421k = Collections.emptyList();
            return this;
        }

        public PoiElement clearSubPoiType() {
            this.f10419i = false;
            this.f10420j = 0;
            return this;
        }

        public PoiElement clearSubTitle() {
            this.f10413c = false;
            this.f10414d = "";
            return this;
        }

        public PoiElement clearType() {
            this.f10424n = false;
            this.f10425o = 0;
            return this;
        }

        public PoiElement clearUid() {
            this.f10422l = false;
            this.f10423m = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f10426p < 0) {
                getSerializedSize();
            }
            return this.f10426p;
        }

        public int getCityid() {
            return this.f10416f;
        }

        public String getDistance() {
            return this.f10418h;
        }

        public String getPoiName() {
            return this.f10412b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPoiName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPoiName());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
            }
            if (hasCityid()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getCityid());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getDistance());
            }
            if (hasSubPoiType()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getSubPoiType());
            }
            int i2 = i;
            for (SubPoi computeMessageSize : getSubPoiArrayList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(6, computeMessageSize) + i2;
            }
            if (hasUid()) {
                i2 += CodedOutputStreamMicro.computeStringSize(7, getUid());
            }
            if (hasType()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(8, getType());
            }
            this.f10426p = i2;
            return i2;
        }

        public SubPoi getSubPoiArray(int i) {
            return (SubPoi) this.f10421k.get(i);
        }

        public int getSubPoiArrayCount() {
            return this.f10421k.size();
        }

        public List<SubPoi> getSubPoiArrayList() {
            return this.f10421k;
        }

        public int getSubPoiType() {
            return this.f10420j;
        }

        public String getSubTitle() {
            return this.f10414d;
        }

        public int getType() {
            return this.f10425o;
        }

        public String getUid() {
            return this.f10423m;
        }

        public boolean hasCityid() {
            return this.f10415e;
        }

        public boolean hasDistance() {
            return this.f10417g;
        }

        public boolean hasPoiName() {
            return this.f10411a;
        }

        public boolean hasSubPoiType() {
            return this.f10419i;
        }

        public boolean hasSubTitle() {
            return this.f10413c;
        }

        public boolean hasType() {
            return this.f10424n;
        }

        public boolean hasUid() {
            return this.f10422l;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PoiElement mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setPoiName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setCityid(codedInputStreamMicro.readInt32());
                        continue;
                    case 34:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setSubPoiType(codedInputStreamMicro.readInt32());
                        continue;
                    case 50:
                        MessageMicro subPoi = new SubPoi();
                        codedInputStreamMicro.readMessage(subPoi);
                        addSubPoiArray(subPoi);
                        continue;
                    case 58:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 64:
                        setType(codedInputStreamMicro.readInt32());
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

        public PoiElement setCityid(int i) {
            this.f10415e = true;
            this.f10416f = i;
            return this;
        }

        public PoiElement setDistance(String str) {
            this.f10417g = true;
            this.f10418h = str;
            return this;
        }

        public PoiElement setPoiName(String str) {
            this.f10411a = true;
            this.f10412b = str;
            return this;
        }

        public PoiElement setSubPoiArray(int i, SubPoi subPoi) {
            if (subPoi != null) {
                this.f10421k.set(i, subPoi);
            }
            return this;
        }

        public PoiElement setSubPoiType(int i) {
            this.f10419i = true;
            this.f10420j = i;
            return this;
        }

        public PoiElement setSubTitle(String str) {
            this.f10413c = true;
            this.f10414d = str;
            return this;
        }

        public PoiElement setType(int i) {
            this.f10424n = true;
            this.f10425o = i;
            return this;
        }

        public PoiElement setUid(String str) {
            this.f10422l = true;
            this.f10423m = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPoiName()) {
                codedOutputStreamMicro.writeString(1, getPoiName());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(2, getSubTitle());
            }
            if (hasCityid()) {
                codedOutputStreamMicro.writeInt32(3, getCityid());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(4, getDistance());
            }
            if (hasSubPoiType()) {
                codedOutputStreamMicro.writeInt32(5, getSubPoiType());
            }
            for (SubPoi writeMessage : getSubPoiArrayList()) {
                codedOutputStreamMicro.writeMessage(6, writeMessage);
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(7, getUid());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeInt32(8, getType());
            }
        }
    }

    public static BusSusvrResponse parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new BusSusvrResponse().mergeFrom(codedInputStreamMicro);
    }

    public static BusSusvrResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (BusSusvrResponse) new BusSusvrResponse().mergeFrom(bArr);
    }

    public BusSusvrResponse addPoiArray(PoiElement poiElement) {
        if (poiElement != null) {
            if (this.f10427a.isEmpty()) {
                this.f10427a = new ArrayList();
            }
            this.f10427a.add(poiElement);
        }
        return this;
    }

    public final BusSusvrResponse clear() {
        clearPoiArray();
        clearType();
        this.f10430d = -1;
        return this;
    }

    public BusSusvrResponse clearPoiArray() {
        this.f10427a = Collections.emptyList();
        return this;
    }

    public BusSusvrResponse clearType() {
        this.f10428b = false;
        this.f10429c = 0;
        return this;
    }

    public int getCachedSize() {
        if (this.f10430d < 0) {
            getSerializedSize();
        }
        return this.f10430d;
    }

    public PoiElement getPoiArray(int i) {
        return (PoiElement) this.f10427a.get(i);
    }

    public int getPoiArrayCount() {
        return this.f10427a.size();
    }

    public List<PoiElement> getPoiArrayList() {
        return this.f10427a;
    }

    public int getSerializedSize() {
        int i = 0;
        for (PoiElement computeMessageSize : getPoiArrayList()) {
            i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
        }
        if (hasType()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getType());
        }
        this.f10430d = i;
        return i;
    }

    public int getType() {
        return this.f10429c;
    }

    public boolean hasType() {
        return this.f10428b;
    }

    public final boolean isInitialized() {
        return true;
    }

    public BusSusvrResponse mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    MessageMicro poiElement = new PoiElement();
                    codedInputStreamMicro.readMessage(poiElement);
                    addPoiArray(poiElement);
                    continue;
                case 16:
                    setType(codedInputStreamMicro.readInt32());
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

    public BusSusvrResponse setPoiArray(int i, PoiElement poiElement) {
        if (poiElement != null) {
            this.f10427a.set(i, poiElement);
        }
        return this;
    }

    public BusSusvrResponse setType(int i) {
        this.f10428b = true;
        this.f10429c = i;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        for (PoiElement writeMessage : getPoiArrayList()) {
            codedOutputStreamMicro.writeMessage(1, writeMessage);
        }
        if (hasType()) {
            codedOutputStreamMicro.writeInt32(2, getType());
        }
    }
}
