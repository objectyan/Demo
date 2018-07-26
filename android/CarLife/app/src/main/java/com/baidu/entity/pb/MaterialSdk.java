package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MaterialSdk extends MessageMicro {
    public static final int DATA_CONTENT_FIELD_NUMBER = 2;
    public static final int DATA_RESULT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f12103a;
    /* renamed from: b */
    private MaterialResult f12104b = null;
    /* renamed from: c */
    private boolean f12105c;
    /* renamed from: d */
    private MaterialContent f12106d = null;
    /* renamed from: e */
    private int f12107e = -1;

    public static final class Basic extends MessageMicro {
        public static final int DATA_TYPE_FIELD_NUMBER = 2;
        public static final int VER_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f12066a;
        /* renamed from: b */
        private int f12067b = 0;
        /* renamed from: c */
        private boolean f12068c;
        /* renamed from: d */
        private int f12069d = 0;
        /* renamed from: e */
        private int f12070e = -1;

        public static Basic parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Basic().mergeFrom(codedInputStreamMicro);
        }

        public static Basic parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Basic) new Basic().mergeFrom(bArr);
        }

        public final Basic clear() {
            clearVer();
            clearDataType();
            this.f12070e = -1;
            return this;
        }

        public Basic clearDataType() {
            this.f12068c = false;
            this.f12069d = 0;
            return this;
        }

        public Basic clearVer() {
            this.f12066a = false;
            this.f12067b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f12070e < 0) {
                getSerializedSize();
            }
            return this.f12070e;
        }

        public int getDataType() {
            return this.f12069d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasVer()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getVer());
            }
            if (hasDataType()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getDataType());
            }
            this.f12070e = i;
            return i;
        }

        public int getVer() {
            return this.f12067b;
        }

        public boolean hasDataType() {
            return this.f12068c;
        }

        public boolean hasVer() {
            return this.f12066a;
        }

        public final boolean isInitialized() {
            return this.f12066a && this.f12068c;
        }

        public Basic mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setVer(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setDataType(codedInputStreamMicro.readInt32());
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

        public Basic setDataType(int i) {
            this.f12068c = true;
            this.f12069d = i;
            return this;
        }

        public Basic setVer(int i) {
            this.f12066a = true;
            this.f12067b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasVer()) {
                codedOutputStreamMicro.writeInt32(1, getVer());
            }
            if (hasDataType()) {
                codedOutputStreamMicro.writeInt32(2, getDataType());
            }
        }
    }

    public static final class Material extends MessageMicro {
        public static final int ACTION_FIELD_NUMBER = 8;
        public static final int CONTAINER_ID_FIELD_NUMBER = 1;
        public static final int CONTENT_FIELD_NUMBER = 7;
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int GF_LATITUDE_FIELD_NUMBER = 10;
        public static final int GF_LONGITUDE_FIELD_NUMBER = 9;
        public static final int GF_RADIUS_FIELD_NUMBER = 11;
        public static final int MATERIAL_ID_FIELD_NUMBER = 3;
        public static final int PKG_ID_FIELD_NUMBER = 2;
        public static final int PRIORITY_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f12071a;
        /* renamed from: b */
        private String f12072b = "";
        /* renamed from: c */
        private boolean f12073c;
        /* renamed from: d */
        private String f12074d = "";
        /* renamed from: e */
        private boolean f12075e;
        /* renamed from: f */
        private String f12076f = "";
        /* renamed from: g */
        private boolean f12077g;
        /* renamed from: h */
        private int f12078h = 0;
        /* renamed from: i */
        private boolean f12079i;
        /* renamed from: j */
        private long f12080j = 0;
        /* renamed from: k */
        private boolean f12081k;
        /* renamed from: l */
        private long f12082l = 0;
        /* renamed from: m */
        private boolean f12083m;
        /* renamed from: n */
        private String f12084n = "";
        /* renamed from: o */
        private boolean f12085o;
        /* renamed from: p */
        private int f12086p = 0;
        /* renamed from: q */
        private boolean f12087q;
        /* renamed from: r */
        private double f12088r = 0.0d;
        /* renamed from: s */
        private boolean f12089s;
        /* renamed from: t */
        private double f12090t = 0.0d;
        /* renamed from: u */
        private boolean f12091u;
        /* renamed from: v */
        private int f12092v = 0;
        /* renamed from: w */
        private int f12093w = -1;

        public static Material parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Material().mergeFrom(codedInputStreamMicro);
        }

        public static Material parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Material) new Material().mergeFrom(bArr);
        }

        public final Material clear() {
            clearContainerId();
            clearPkgId();
            clearMaterialId();
            clearPriority();
            clearStartTime();
            clearEndTime();
            clearContent();
            clearAction();
            clearGfLongitude();
            clearGfLatitude();
            clearGfRadius();
            this.f12093w = -1;
            return this;
        }

        public Material clearAction() {
            this.f12085o = false;
            this.f12086p = 0;
            return this;
        }

        public Material clearContainerId() {
            this.f12071a = false;
            this.f12072b = "";
            return this;
        }

        public Material clearContent() {
            this.f12083m = false;
            this.f12084n = "";
            return this;
        }

        public Material clearEndTime() {
            this.f12081k = false;
            this.f12082l = 0;
            return this;
        }

        public Material clearGfLatitude() {
            this.f12089s = false;
            this.f12090t = 0.0d;
            return this;
        }

        public Material clearGfLongitude() {
            this.f12087q = false;
            this.f12088r = 0.0d;
            return this;
        }

        public Material clearGfRadius() {
            this.f12091u = false;
            this.f12092v = 0;
            return this;
        }

        public Material clearMaterialId() {
            this.f12075e = false;
            this.f12076f = "";
            return this;
        }

        public Material clearPkgId() {
            this.f12073c = false;
            this.f12074d = "";
            return this;
        }

        public Material clearPriority() {
            this.f12077g = false;
            this.f12078h = 0;
            return this;
        }

        public Material clearStartTime() {
            this.f12079i = false;
            this.f12080j = 0;
            return this;
        }

        public int getAction() {
            return this.f12086p;
        }

        public int getCachedSize() {
            if (this.f12093w < 0) {
                getSerializedSize();
            }
            return this.f12093w;
        }

        public String getContainerId() {
            return this.f12072b;
        }

        public String getContent() {
            return this.f12084n;
        }

        public long getEndTime() {
            return this.f12082l;
        }

        public double getGfLatitude() {
            return this.f12090t;
        }

        public double getGfLongitude() {
            return this.f12088r;
        }

        public int getGfRadius() {
            return this.f12092v;
        }

        public String getMaterialId() {
            return this.f12076f;
        }

        public String getPkgId() {
            return this.f12074d;
        }

        public int getPriority() {
            return this.f12078h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasContainerId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getContainerId());
            }
            if (hasPkgId()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getPkgId());
            }
            if (hasMaterialId()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getMaterialId());
            }
            if (hasPriority()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getPriority());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(5, getStartTime());
            }
            if (hasEndTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(6, getEndTime());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getContent());
            }
            if (hasAction()) {
                i += CodedOutputStreamMicro.computeInt32Size(8, getAction());
            }
            if (hasGfLongitude()) {
                i += CodedOutputStreamMicro.computeDoubleSize(9, getGfLongitude());
            }
            if (hasGfLatitude()) {
                i += CodedOutputStreamMicro.computeDoubleSize(10, getGfLatitude());
            }
            if (hasGfRadius()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, getGfRadius());
            }
            this.f12093w = i;
            return i;
        }

        public long getStartTime() {
            return this.f12080j;
        }

        public boolean hasAction() {
            return this.f12085o;
        }

        public boolean hasContainerId() {
            return this.f12071a;
        }

        public boolean hasContent() {
            return this.f12083m;
        }

        public boolean hasEndTime() {
            return this.f12081k;
        }

        public boolean hasGfLatitude() {
            return this.f12089s;
        }

        public boolean hasGfLongitude() {
            return this.f12087q;
        }

        public boolean hasGfRadius() {
            return this.f12091u;
        }

        public boolean hasMaterialId() {
            return this.f12075e;
        }

        public boolean hasPkgId() {
            return this.f12073c;
        }

        public boolean hasPriority() {
            return this.f12077g;
        }

        public boolean hasStartTime() {
            return this.f12079i;
        }

        public final boolean isInitialized() {
            return this.f12071a && this.f12073c && this.f12075e && this.f12077g && this.f12079i && this.f12081k && this.f12083m;
        }

        public Material mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setContainerId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setPkgId(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setMaterialId(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setPriority(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setStartTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 48:
                        setEndTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 58:
                        setContent(codedInputStreamMicro.readString());
                        continue;
                    case 64:
                        setAction(codedInputStreamMicro.readInt32());
                        continue;
                    case 73:
                        setGfLongitude(codedInputStreamMicro.readDouble());
                        continue;
                    case 81:
                        setGfLatitude(codedInputStreamMicro.readDouble());
                        continue;
                    case 88:
                        setGfRadius(codedInputStreamMicro.readInt32());
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

        public Material setAction(int i) {
            this.f12085o = true;
            this.f12086p = i;
            return this;
        }

        public Material setContainerId(String str) {
            this.f12071a = true;
            this.f12072b = str;
            return this;
        }

        public Material setContent(String str) {
            this.f12083m = true;
            this.f12084n = str;
            return this;
        }

        public Material setEndTime(long j) {
            this.f12081k = true;
            this.f12082l = j;
            return this;
        }

        public Material setGfLatitude(double d) {
            this.f12089s = true;
            this.f12090t = d;
            return this;
        }

        public Material setGfLongitude(double d) {
            this.f12087q = true;
            this.f12088r = d;
            return this;
        }

        public Material setGfRadius(int i) {
            this.f12091u = true;
            this.f12092v = i;
            return this;
        }

        public Material setMaterialId(String str) {
            this.f12075e = true;
            this.f12076f = str;
            return this;
        }

        public Material setPkgId(String str) {
            this.f12073c = true;
            this.f12074d = str;
            return this;
        }

        public Material setPriority(int i) {
            this.f12077g = true;
            this.f12078h = i;
            return this;
        }

        public Material setStartTime(long j) {
            this.f12079i = true;
            this.f12080j = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasContainerId()) {
                codedOutputStreamMicro.writeString(1, getContainerId());
            }
            if (hasPkgId()) {
                codedOutputStreamMicro.writeString(2, getPkgId());
            }
            if (hasMaterialId()) {
                codedOutputStreamMicro.writeString(3, getMaterialId());
            }
            if (hasPriority()) {
                codedOutputStreamMicro.writeInt32(4, getPriority());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeInt64(5, getStartTime());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeInt64(6, getEndTime());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(7, getContent());
            }
            if (hasAction()) {
                codedOutputStreamMicro.writeInt32(8, getAction());
            }
            if (hasGfLongitude()) {
                codedOutputStreamMicro.writeDouble(9, getGfLongitude());
            }
            if (hasGfLatitude()) {
                codedOutputStreamMicro.writeDouble(10, getGfLatitude());
            }
            if (hasGfRadius()) {
                codedOutputStreamMicro.writeInt32(11, getGfRadius());
            }
        }
    }

    public static final class MaterialContent extends MessageMicro {
        public static final int BASIC_FIELD_NUMBER = 1;
        public static final int LIST_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12094a;
        /* renamed from: b */
        private Basic f12095b = null;
        /* renamed from: c */
        private List<Material> f12096c = Collections.emptyList();
        /* renamed from: d */
        private int f12097d = -1;

        public static MaterialContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MaterialContent().mergeFrom(codedInputStreamMicro);
        }

        public static MaterialContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MaterialContent) new MaterialContent().mergeFrom(bArr);
        }

        public MaterialContent addList(Material material) {
            if (material != null) {
                if (this.f12096c.isEmpty()) {
                    this.f12096c = new ArrayList();
                }
                this.f12096c.add(material);
            }
            return this;
        }

        public final MaterialContent clear() {
            clearBasic();
            clearList();
            this.f12097d = -1;
            return this;
        }

        public MaterialContent clearBasic() {
            this.f12094a = false;
            this.f12095b = null;
            return this;
        }

        public MaterialContent clearList() {
            this.f12096c = Collections.emptyList();
            return this;
        }

        public Basic getBasic() {
            return this.f12095b;
        }

        public int getCachedSize() {
            if (this.f12097d < 0) {
                getSerializedSize();
            }
            return this.f12097d;
        }

        public Material getList(int i) {
            return (Material) this.f12096c.get(i);
        }

        public int getListCount() {
            return this.f12096c.size();
        }

        public List<Material> getListList() {
            return this.f12096c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasBasic()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getBasic());
            }
            int i2 = i;
            for (Material computeMessageSize : getListList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f12097d = i2;
            return i2;
        }

        public boolean hasBasic() {
            return this.f12094a;
        }

        public final boolean isInitialized() {
            if (!this.f12094a) {
                return false;
            }
            if (!getBasic().isInitialized()) {
                return false;
            }
            for (Material isInitialized : getListList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public MaterialContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro basic;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        basic = new Basic();
                        codedInputStreamMicro.readMessage(basic);
                        setBasic(basic);
                        continue;
                    case 18:
                        basic = new Material();
                        codedInputStreamMicro.readMessage(basic);
                        addList(basic);
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

        public MaterialContent setBasic(Basic basic) {
            if (basic == null) {
                return clearBasic();
            }
            this.f12094a = true;
            this.f12095b = basic;
            return this;
        }

        public MaterialContent setList(int i, Material material) {
            if (material != null) {
                this.f12096c.set(i, material);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasBasic()) {
                codedOutputStreamMicro.writeMessage(1, getBasic());
            }
            for (Material writeMessage : getListList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class MaterialResult extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int MSG_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f12098a;
        /* renamed from: b */
        private int f12099b = 0;
        /* renamed from: c */
        private boolean f12100c;
        /* renamed from: d */
        private String f12101d = "";
        /* renamed from: e */
        private int f12102e = -1;

        public static MaterialResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MaterialResult().mergeFrom(codedInputStreamMicro);
        }

        public static MaterialResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MaterialResult) new MaterialResult().mergeFrom(bArr);
        }

        public final MaterialResult clear() {
            clearError();
            clearMsg();
            this.f12102e = -1;
            return this;
        }

        public MaterialResult clearError() {
            this.f12098a = false;
            this.f12099b = 0;
            return this;
        }

        public MaterialResult clearMsg() {
            this.f12100c = false;
            this.f12101d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f12102e < 0) {
                getSerializedSize();
            }
            return this.f12102e;
        }

        public int getError() {
            return this.f12099b;
        }

        public String getMsg() {
            return this.f12101d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasMsg()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
            }
            this.f12102e = i;
            return i;
        }

        public boolean hasError() {
            return this.f12098a;
        }

        public boolean hasMsg() {
            return this.f12100c;
        }

        public final boolean isInitialized() {
            return this.f12098a && this.f12100c;
        }

        public MaterialResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                    default:
                        if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public MaterialResult setError(int i) {
            this.f12098a = true;
            this.f12099b = i;
            return this;
        }

        public MaterialResult setMsg(String str) {
            this.f12100c = true;
            this.f12101d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasError()) {
                codedOutputStreamMicro.writeInt32(1, getError());
            }
            if (hasMsg()) {
                codedOutputStreamMicro.writeString(2, getMsg());
            }
        }
    }

    public static MaterialSdk parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new MaterialSdk().mergeFrom(codedInputStreamMicro);
    }

    public static MaterialSdk parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (MaterialSdk) new MaterialSdk().mergeFrom(bArr);
    }

    public final MaterialSdk clear() {
        clearDataResult();
        clearDataContent();
        this.f12107e = -1;
        return this;
    }

    public MaterialSdk clearDataContent() {
        this.f12105c = false;
        this.f12106d = null;
        return this;
    }

    public MaterialSdk clearDataResult() {
        this.f12103a = false;
        this.f12104b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f12107e < 0) {
            getSerializedSize();
        }
        return this.f12107e;
    }

    public MaterialContent getDataContent() {
        return this.f12106d;
    }

    public MaterialResult getDataResult() {
        return this.f12104b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasDataResult()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDataResult());
        }
        if (hasDataContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getDataContent());
        }
        this.f12107e = i;
        return i;
    }

    public boolean hasDataContent() {
        return this.f12105c;
    }

    public boolean hasDataResult() {
        return this.f12103a;
    }

    public final boolean isInitialized() {
        return (this.f12103a && getDataResult().isInitialized()) ? !hasDataContent() || getDataContent().isInitialized() : false;
    }

    public MaterialSdk mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro materialResult;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    materialResult = new MaterialResult();
                    codedInputStreamMicro.readMessage(materialResult);
                    setDataResult(materialResult);
                    continue;
                case 18:
                    materialResult = new MaterialContent();
                    codedInputStreamMicro.readMessage(materialResult);
                    setDataContent(materialResult);
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

    public MaterialSdk setDataContent(MaterialContent materialContent) {
        if (materialContent == null) {
            return clearDataContent();
        }
        this.f12105c = true;
        this.f12106d = materialContent;
        return this;
    }

    public MaterialSdk setDataResult(MaterialResult materialResult) {
        if (materialResult == null) {
            return clearDataResult();
        }
        this.f12103a = true;
        this.f12104b = materialResult;
        return this;
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasDataResult()) {
            codedOutputStreamMicro.writeMessage(1, getDataResult());
        }
        if (hasDataContent()) {
            codedOutputStreamMicro.writeMessage(2, getDataContent());
        }
    }
}
