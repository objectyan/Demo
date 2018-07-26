package com.baidu.entity.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CkResponse extends MessageMicro {
    public static final int DATA_CONTENT_FIELD_NUMBER = 2;
    public static final int DATA_RESULT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f11047a;
    /* renamed from: b */
    private CKResult f11048b = null;
    /* renamed from: c */
    private boolean f11049c;
    /* renamed from: d */
    private CKContent f11050d = null;
    /* renamed from: e */
    private int f11051e = -1;

    public static final class ADData extends MessageMicro {
        public static final int AD_ID_FIELD_NUMBER = 1;
        public static final int MATERIALS_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f10979a;
        /* renamed from: b */
        private String f10980b = "";
        /* renamed from: c */
        private List<MaterialData> f10981c = Collections.emptyList();
        /* renamed from: d */
        private int f10982d = -1;

        public static ADData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ADData().mergeFrom(codedInputStreamMicro);
        }

        public static ADData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ADData) new ADData().mergeFrom(bArr);
        }

        public ADData addMaterials(MaterialData materialData) {
            if (materialData != null) {
                if (this.f10981c.isEmpty()) {
                    this.f10981c = new ArrayList();
                }
                this.f10981c.add(materialData);
            }
            return this;
        }

        public final ADData clear() {
            clearAdId();
            clearMaterials();
            this.f10982d = -1;
            return this;
        }

        public ADData clearAdId() {
            this.f10979a = false;
            this.f10980b = "";
            return this;
        }

        public ADData clearMaterials() {
            this.f10981c = Collections.emptyList();
            return this;
        }

        public String getAdId() {
            return this.f10980b;
        }

        public int getCachedSize() {
            if (this.f10982d < 0) {
                getSerializedSize();
            }
            return this.f10982d;
        }

        public MaterialData getMaterials(int i) {
            return (MaterialData) this.f10981c.get(i);
        }

        public int getMaterialsCount() {
            return this.f10981c.size();
        }

        public List<MaterialData> getMaterialsList() {
            return this.f10981c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAdId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getAdId());
            }
            int i2 = i;
            for (MaterialData computeMessageSize : getMaterialsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f10982d = i2;
            return i2;
        }

        public boolean hasAdId() {
            return this.f10979a;
        }

        public final boolean isInitialized() {
            if (!this.f10979a) {
                return false;
            }
            for (MaterialData isInitialized : getMaterialsList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public ADData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setAdId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro materialData = new MaterialData();
                        codedInputStreamMicro.readMessage(materialData);
                        addMaterials(materialData);
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

        public ADData setAdId(String str) {
            this.f10979a = true;
            this.f10980b = str;
            return this;
        }

        public ADData setMaterials(int i, MaterialData materialData) {
            if (materialData != null) {
                this.f10981c.set(i, materialData);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAdId()) {
                codedOutputStreamMicro.writeString(1, getAdId());
            }
            for (MaterialData writeMessage : getMaterialsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class ActionData extends MessageMicro {
        public static final int ACTION_BACKUP_FIELD_NUMBER = 1;
        public static final int ACTION_NONET_FIELD_NUMBER = 2;
        public static final int ACTION_SCHEME_FIELD_NUMBER = 3;
        public static final int ACTION_TYPE_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f10983a;
        /* renamed from: b */
        private String f10984b = "";
        /* renamed from: c */
        private boolean f10985c;
        /* renamed from: d */
        private String f10986d = "";
        /* renamed from: e */
        private boolean f10987e;
        /* renamed from: f */
        private String f10988f = "";
        /* renamed from: g */
        private boolean f10989g;
        /* renamed from: h */
        private String f10990h = "";
        /* renamed from: i */
        private int f10991i = -1;

        public static ActionData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ActionData().mergeFrom(codedInputStreamMicro);
        }

        public static ActionData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ActionData) new ActionData().mergeFrom(bArr);
        }

        public final ActionData clear() {
            clearActionBackup();
            clearActionNonet();
            clearActionScheme();
            clearActionType();
            this.f10991i = -1;
            return this;
        }

        public ActionData clearActionBackup() {
            this.f10983a = false;
            this.f10984b = "";
            return this;
        }

        public ActionData clearActionNonet() {
            this.f10985c = false;
            this.f10986d = "";
            return this;
        }

        public ActionData clearActionScheme() {
            this.f10987e = false;
            this.f10988f = "";
            return this;
        }

        public ActionData clearActionType() {
            this.f10989g = false;
            this.f10990h = "";
            return this;
        }

        public String getActionBackup() {
            return this.f10984b;
        }

        public String getActionNonet() {
            return this.f10986d;
        }

        public String getActionScheme() {
            return this.f10988f;
        }

        public String getActionType() {
            return this.f10990h;
        }

        public int getCachedSize() {
            if (this.f10991i < 0) {
                getSerializedSize();
            }
            return this.f10991i;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasActionBackup()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getActionBackup());
            }
            if (hasActionNonet()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getActionNonet());
            }
            if (hasActionScheme()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getActionScheme());
            }
            if (hasActionType()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getActionType());
            }
            this.f10991i = i;
            return i;
        }

        public boolean hasActionBackup() {
            return this.f10983a;
        }

        public boolean hasActionNonet() {
            return this.f10985c;
        }

        public boolean hasActionScheme() {
            return this.f10987e;
        }

        public boolean hasActionType() {
            return this.f10989g;
        }

        public final boolean isInitialized() {
            return this.f10983a && this.f10985c && this.f10987e && this.f10989g;
        }

        public ActionData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setActionBackup(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setActionNonet(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setActionScheme(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setActionType(codedInputStreamMicro.readString());
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

        public ActionData setActionBackup(String str) {
            this.f10983a = true;
            this.f10984b = str;
            return this;
        }

        public ActionData setActionNonet(String str) {
            this.f10985c = true;
            this.f10986d = str;
            return this;
        }

        public ActionData setActionScheme(String str) {
            this.f10987e = true;
            this.f10988f = str;
            return this;
        }

        public ActionData setActionType(String str) {
            this.f10989g = true;
            this.f10990h = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasActionBackup()) {
                codedOutputStreamMicro.writeString(1, getActionBackup());
            }
            if (hasActionNonet()) {
                codedOutputStreamMicro.writeString(2, getActionNonet());
            }
            if (hasActionScheme()) {
                codedOutputStreamMicro.writeString(3, getActionScheme());
            }
            if (hasActionType()) {
                codedOutputStreamMicro.writeString(4, getActionType());
            }
        }
    }

    public static final class CKContent extends MessageMicro {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f10992a;
        /* renamed from: b */
        private int f10993b = 0;
        /* renamed from: c */
        private boolean f10994c;
        /* renamed from: d */
        private CKContentData f10995d = null;
        /* renamed from: e */
        private int f10996e = -1;

        public static CKContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CKContent().mergeFrom(codedInputStreamMicro);
        }

        public static CKContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CKContent) new CKContent().mergeFrom(bArr);
        }

        public final CKContent clear() {
            clearDataType();
            clearData();
            this.f10996e = -1;
            return this;
        }

        public CKContent clearData() {
            this.f10994c = false;
            this.f10995d = null;
            return this;
        }

        public CKContent clearDataType() {
            this.f10992a = false;
            this.f10993b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f10996e < 0) {
                getSerializedSize();
            }
            return this.f10996e;
        }

        public CKContentData getData() {
            return this.f10995d;
        }

        public int getDataType() {
            return this.f10993b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDataType()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getDataType());
            }
            if (hasData()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getData());
            }
            this.f10996e = i;
            return i;
        }

        public boolean hasData() {
            return this.f10994c;
        }

        public boolean hasDataType() {
            return this.f10992a;
        }

        public final boolean isInitialized() {
            return this.f10992a && this.f10994c && getData().isInitialized();
        }

        public CKContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setDataType(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        MessageMicro cKContentData = new CKContentData();
                        codedInputStreamMicro.readMessage(cKContentData);
                        setData(cKContentData);
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

        public CKContent setData(CKContentData cKContentData) {
            if (cKContentData == null) {
                return clearData();
            }
            this.f10994c = true;
            this.f10995d = cKContentData;
            return this;
        }

        public CKContent setDataType(int i) {
            this.f10992a = true;
            this.f10993b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDataType()) {
                codedOutputStreamMicro.writeInt32(1, getDataType());
            }
            if (hasData()) {
                codedOutputStreamMicro.writeMessage(2, getData());
            }
        }
    }

    public static final class CKContentData extends MessageMicro {
        public static final int ADS_FIELD_NUMBER = 2;
        public static final int VER_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f10997a;
        /* renamed from: b */
        private String f10998b = "";
        /* renamed from: c */
        private List<ADData> f10999c = Collections.emptyList();
        /* renamed from: d */
        private int f11000d = -1;

        public static CKContentData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CKContentData().mergeFrom(codedInputStreamMicro);
        }

        public static CKContentData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CKContentData) new CKContentData().mergeFrom(bArr);
        }

        public CKContentData addAds(ADData aDData) {
            if (aDData != null) {
                if (this.f10999c.isEmpty()) {
                    this.f10999c = new ArrayList();
                }
                this.f10999c.add(aDData);
            }
            return this;
        }

        public final CKContentData clear() {
            clearVer();
            clearAds();
            this.f11000d = -1;
            return this;
        }

        public CKContentData clearAds() {
            this.f10999c = Collections.emptyList();
            return this;
        }

        public CKContentData clearVer() {
            this.f10997a = false;
            this.f10998b = "";
            return this;
        }

        public ADData getAds(int i) {
            return (ADData) this.f10999c.get(i);
        }

        public int getAdsCount() {
            return this.f10999c.size();
        }

        public List<ADData> getAdsList() {
            return this.f10999c;
        }

        public int getCachedSize() {
            if (this.f11000d < 0) {
                getSerializedSize();
            }
            return this.f11000d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasVer()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getVer());
            }
            int i2 = i;
            for (ADData computeMessageSize : getAdsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f11000d = i2;
            return i2;
        }

        public String getVer() {
            return this.f10998b;
        }

        public boolean hasVer() {
            return this.f10997a;
        }

        public final boolean isInitialized() {
            if (!this.f10997a) {
                return false;
            }
            for (ADData isInitialized : getAdsList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public CKContentData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setVer(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro aDData = new ADData();
                        codedInputStreamMicro.readMessage(aDData);
                        addAds(aDData);
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

        public CKContentData setAds(int i, ADData aDData) {
            if (aDData != null) {
                this.f10999c.set(i, aDData);
            }
            return this;
        }

        public CKContentData setVer(String str) {
            this.f10997a = true;
            this.f10998b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasVer()) {
                codedOutputStreamMicro.writeString(1, getVer());
            }
            for (ADData writeMessage : getAdsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class CKResult extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int MSG_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f11001a;
        /* renamed from: b */
        private int f11002b = 0;
        /* renamed from: c */
        private boolean f11003c;
        /* renamed from: d */
        private String f11004d = "";
        /* renamed from: e */
        private int f11005e = -1;

        public static CKResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CKResult().mergeFrom(codedInputStreamMicro);
        }

        public static CKResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CKResult) new CKResult().mergeFrom(bArr);
        }

        public final CKResult clear() {
            clearError();
            clearMsg();
            this.f11005e = -1;
            return this;
        }

        public CKResult clearError() {
            this.f11001a = false;
            this.f11002b = 0;
            return this;
        }

        public CKResult clearMsg() {
            this.f11003c = false;
            this.f11004d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11005e < 0) {
                getSerializedSize();
            }
            return this.f11005e;
        }

        public int getError() {
            return this.f11002b;
        }

        public String getMsg() {
            return this.f11004d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasMsg()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
            }
            this.f11005e = i;
            return i;
        }

        public boolean hasError() {
            return this.f11001a;
        }

        public boolean hasMsg() {
            return this.f11003c;
        }

        public final boolean isInitialized() {
            return this.f11001a && this.f11003c;
        }

        public CKResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

        public CKResult setError(int i) {
            this.f11001a = true;
            this.f11002b = i;
            return this;
        }

        public CKResult setMsg(String str) {
            this.f11003c = true;
            this.f11004d = str;
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

    public static final class MaterialData extends MessageMicro {
        public static final int ACTION_FIELD_NUMBER = 3;
        public static final int MATERIAL_ID_FIELD_NUMBER = 1;
        public static final int PRIORITY_FIELD_NUMBER = 2;
        public static final int RULE_FIELD_NUMBER = 5;
        public static final int SHOW_RES_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f11006a;
        /* renamed from: b */
        private int f11007b = 0;
        /* renamed from: c */
        private boolean f11008c;
        /* renamed from: d */
        private int f11009d = 0;
        /* renamed from: e */
        private boolean f11010e;
        /* renamed from: f */
        private ActionData f11011f = null;
        /* renamed from: g */
        private boolean f11012g;
        /* renamed from: h */
        private ResData f11013h = null;
        /* renamed from: i */
        private boolean f11014i;
        /* renamed from: j */
        private RuleData f11015j = null;
        /* renamed from: k */
        private int f11016k = -1;

        public static MaterialData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MaterialData().mergeFrom(codedInputStreamMicro);
        }

        public static MaterialData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MaterialData) new MaterialData().mergeFrom(bArr);
        }

        public final MaterialData clear() {
            clearMaterialId();
            clearPriority();
            clearAction();
            clearShowRes();
            clearRule();
            this.f11016k = -1;
            return this;
        }

        public MaterialData clearAction() {
            this.f11010e = false;
            this.f11011f = null;
            return this;
        }

        public MaterialData clearMaterialId() {
            this.f11006a = false;
            this.f11007b = 0;
            return this;
        }

        public MaterialData clearPriority() {
            this.f11008c = false;
            this.f11009d = 0;
            return this;
        }

        public MaterialData clearRule() {
            this.f11014i = false;
            this.f11015j = null;
            return this;
        }

        public MaterialData clearShowRes() {
            this.f11012g = false;
            this.f11013h = null;
            return this;
        }

        public ActionData getAction() {
            return this.f11011f;
        }

        public int getCachedSize() {
            if (this.f11016k < 0) {
                getSerializedSize();
            }
            return this.f11016k;
        }

        public int getMaterialId() {
            return this.f11007b;
        }

        public int getPriority() {
            return this.f11009d;
        }

        public RuleData getRule() {
            return this.f11015j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMaterialId()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getMaterialId());
            }
            if (hasPriority()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getPriority());
            }
            if (hasAction()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getAction());
            }
            if (hasShowRes()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getShowRes());
            }
            if (hasRule()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getRule());
            }
            this.f11016k = i;
            return i;
        }

        public ResData getShowRes() {
            return this.f11013h;
        }

        public boolean hasAction() {
            return this.f11010e;
        }

        public boolean hasMaterialId() {
            return this.f11006a;
        }

        public boolean hasPriority() {
            return this.f11008c;
        }

        public boolean hasRule() {
            return this.f11014i;
        }

        public boolean hasShowRes() {
            return this.f11012g;
        }

        public final boolean isInitialized() {
            return this.f11006a && this.f11008c && this.f11010e && this.f11012g && this.f11014i && getAction().isInitialized() && getRule().isInitialized();
        }

        public MaterialData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro actionData;
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setMaterialId(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setPriority(codedInputStreamMicro.readInt32());
                        continue;
                    case 26:
                        actionData = new ActionData();
                        codedInputStreamMicro.readMessage(actionData);
                        setAction(actionData);
                        continue;
                    case 34:
                        actionData = new ResData();
                        codedInputStreamMicro.readMessage(actionData);
                        setShowRes(actionData);
                        continue;
                    case 42:
                        actionData = new RuleData();
                        codedInputStreamMicro.readMessage(actionData);
                        setRule(actionData);
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

        public MaterialData setAction(ActionData actionData) {
            if (actionData == null) {
                return clearAction();
            }
            this.f11010e = true;
            this.f11011f = actionData;
            return this;
        }

        public MaterialData setMaterialId(int i) {
            this.f11006a = true;
            this.f11007b = i;
            return this;
        }

        public MaterialData setPriority(int i) {
            this.f11008c = true;
            this.f11009d = i;
            return this;
        }

        public MaterialData setRule(RuleData ruleData) {
            if (ruleData == null) {
                return clearRule();
            }
            this.f11014i = true;
            this.f11015j = ruleData;
            return this;
        }

        public MaterialData setShowRes(ResData resData) {
            if (resData == null) {
                return clearShowRes();
            }
            this.f11012g = true;
            this.f11013h = resData;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMaterialId()) {
                codedOutputStreamMicro.writeInt32(1, getMaterialId());
            }
            if (hasPriority()) {
                codedOutputStreamMicro.writeInt32(2, getPriority());
            }
            if (hasAction()) {
                codedOutputStreamMicro.writeMessage(3, getAction());
            }
            if (hasShowRes()) {
                codedOutputStreamMicro.writeMessage(4, getShowRes());
            }
            if (hasRule()) {
                codedOutputStreamMicro.writeMessage(5, getRule());
            }
        }
    }

    public static final class ResData extends MessageMicro {
        public static final int ACTIVITY_CONTENT_FIELD_NUMBER = 4;
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int IMG_FIELD_NUMBER = 5;
        public static final int SHOW_TIME_FIELD_NUMBER = 6;
        public static final int SUB_TITLE_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f11017a;
        /* renamed from: b */
        private String f11018b = "";
        /* renamed from: c */
        private boolean f11019c;
        /* renamed from: d */
        private String f11020d = "";
        /* renamed from: e */
        private boolean f11021e;
        /* renamed from: f */
        private String f11022f = "";
        /* renamed from: g */
        private boolean f11023g;
        /* renamed from: h */
        private String f11024h = "";
        /* renamed from: i */
        private boolean f11025i;
        /* renamed from: j */
        private String f11026j = "";
        /* renamed from: k */
        private boolean f11027k;
        /* renamed from: l */
        private String f11028l = "";
        /* renamed from: m */
        private int f11029m = -1;

        public static ResData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ResData().mergeFrom(codedInputStreamMicro);
        }

        public static ResData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ResData) new ResData().mergeFrom(bArr);
        }

        public final ResData clear() {
            clearIcon();
            clearTitle();
            clearSubTitle();
            clearActivityContent();
            clearImg();
            clearShowTime();
            this.f11029m = -1;
            return this;
        }

        public ResData clearActivityContent() {
            this.f11023g = false;
            this.f11024h = "";
            return this;
        }

        public ResData clearIcon() {
            this.f11017a = false;
            this.f11018b = "";
            return this;
        }

        public ResData clearImg() {
            this.f11025i = false;
            this.f11026j = "";
            return this;
        }

        public ResData clearShowTime() {
            this.f11027k = false;
            this.f11028l = "";
            return this;
        }

        public ResData clearSubTitle() {
            this.f11021e = false;
            this.f11022f = "";
            return this;
        }

        public ResData clearTitle() {
            this.f11019c = false;
            this.f11020d = "";
            return this;
        }

        public String getActivityContent() {
            return this.f11024h;
        }

        public int getCachedSize() {
            if (this.f11029m < 0) {
                getSerializedSize();
            }
            return this.f11029m;
        }

        public String getIcon() {
            return this.f11018b;
        }

        public String getImg() {
            return this.f11026j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getSubTitle());
            }
            if (hasActivityContent()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getActivityContent());
            }
            if (hasImg()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getImg());
            }
            if (hasShowTime()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getShowTime());
            }
            this.f11029m = i;
            return i;
        }

        public String getShowTime() {
            return this.f11028l;
        }

        public String getSubTitle() {
            return this.f11022f;
        }

        public String getTitle() {
            return this.f11020d;
        }

        public boolean hasActivityContent() {
            return this.f11023g;
        }

        public boolean hasIcon() {
            return this.f11017a;
        }

        public boolean hasImg() {
            return this.f11025i;
        }

        public boolean hasShowTime() {
            return this.f11027k;
        }

        public boolean hasSubTitle() {
            return this.f11021e;
        }

        public boolean hasTitle() {
            return this.f11019c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ResData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setActivityContent(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setImg(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setShowTime(codedInputStreamMicro.readString());
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

        public ResData setActivityContent(String str) {
            this.f11023g = true;
            this.f11024h = str;
            return this;
        }

        public ResData setIcon(String str) {
            this.f11017a = true;
            this.f11018b = str;
            return this;
        }

        public ResData setImg(String str) {
            this.f11025i = true;
            this.f11026j = str;
            return this;
        }

        public ResData setShowTime(String str) {
            this.f11027k = true;
            this.f11028l = str;
            return this;
        }

        public ResData setSubTitle(String str) {
            this.f11021e = true;
            this.f11022f = str;
            return this;
        }

        public ResData setTitle(String str) {
            this.f11019c = true;
            this.f11020d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(3, getSubTitle());
            }
            if (hasActivityContent()) {
                codedOutputStreamMicro.writeString(4, getActivityContent());
            }
            if (hasImg()) {
                codedOutputStreamMicro.writeString(5, getImg());
            }
            if (hasShowTime()) {
                codedOutputStreamMicro.writeString(6, getShowTime());
            }
        }
    }

    public static final class RuleData extends MessageMicro {
        public static final int DISAPPEAR_FIELD_NUMBER = 1;
        public static final int EXPIRE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f11030a;
        /* renamed from: b */
        private RuleDisappear f11031b = null;
        /* renamed from: c */
        private boolean f11032c;
        /* renamed from: d */
        private RuleExpire f11033d = null;
        /* renamed from: e */
        private int f11034e = -1;

        public static RuleData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RuleData().mergeFrom(codedInputStreamMicro);
        }

        public static RuleData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RuleData) new RuleData().mergeFrom(bArr);
        }

        public final RuleData clear() {
            clearDisappear();
            clearExpire();
            this.f11034e = -1;
            return this;
        }

        public RuleData clearDisappear() {
            this.f11030a = false;
            this.f11031b = null;
            return this;
        }

        public RuleData clearExpire() {
            this.f11032c = false;
            this.f11033d = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f11034e < 0) {
                getSerializedSize();
            }
            return this.f11034e;
        }

        public RuleDisappear getDisappear() {
            return this.f11031b;
        }

        public RuleExpire getExpire() {
            return this.f11033d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDisappear()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDisappear());
            }
            if (hasExpire()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getExpire());
            }
            this.f11034e = i;
            return i;
        }

        public boolean hasDisappear() {
            return this.f11030a;
        }

        public boolean hasExpire() {
            return this.f11032c;
        }

        public final boolean isInitialized() {
            return (!hasDisappear() || getDisappear().isInitialized()) ? !hasExpire() || getExpire().isInitialized() : false;
        }

        public RuleData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro ruleDisappear;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        ruleDisappear = new RuleDisappear();
                        codedInputStreamMicro.readMessage(ruleDisappear);
                        setDisappear(ruleDisappear);
                        continue;
                    case 18:
                        ruleDisappear = new RuleExpire();
                        codedInputStreamMicro.readMessage(ruleDisappear);
                        setExpire(ruleDisappear);
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

        public RuleData setDisappear(RuleDisappear ruleDisappear) {
            if (ruleDisappear == null) {
                return clearDisappear();
            }
            this.f11030a = true;
            this.f11031b = ruleDisappear;
            return this;
        }

        public RuleData setExpire(RuleExpire ruleExpire) {
            if (ruleExpire == null) {
                return clearExpire();
            }
            this.f11032c = true;
            this.f11033d = ruleExpire;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDisappear()) {
                codedOutputStreamMicro.writeMessage(1, getDisappear());
            }
            if (hasExpire()) {
                codedOutputStreamMicro.writeMessage(2, getExpire());
            }
        }
    }

    public static final class RuleDisappear extends MessageMicro {
        public static final int CLICK_NUM_FIELD_NUMBER = 2;
        public static final int PERIOD_FIELD_NUMBER = 1;
        public static final int SHOW_NUM_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f11035a;
        /* renamed from: b */
        private int f11036b = 0;
        /* renamed from: c */
        private boolean f11037c;
        /* renamed from: d */
        private int f11038d = 0;
        /* renamed from: e */
        private boolean f11039e;
        /* renamed from: f */
        private int f11040f = 0;
        /* renamed from: g */
        private int f11041g = -1;

        public static RuleDisappear parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RuleDisappear().mergeFrom(codedInputStreamMicro);
        }

        public static RuleDisappear parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RuleDisappear) new RuleDisappear().mergeFrom(bArr);
        }

        public final RuleDisappear clear() {
            clearPeriod();
            clearClickNum();
            clearShowNum();
            this.f11041g = -1;
            return this;
        }

        public RuleDisappear clearClickNum() {
            this.f11037c = false;
            this.f11038d = 0;
            return this;
        }

        public RuleDisappear clearPeriod() {
            this.f11035a = false;
            this.f11036b = 0;
            return this;
        }

        public RuleDisappear clearShowNum() {
            this.f11039e = false;
            this.f11040f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f11041g < 0) {
                getSerializedSize();
            }
            return this.f11041g;
        }

        public int getClickNum() {
            return this.f11038d;
        }

        public int getPeriod() {
            return this.f11036b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPeriod()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getPeriod());
            }
            if (hasClickNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getClickNum());
            }
            if (hasShowNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getShowNum());
            }
            this.f11041g = i;
            return i;
        }

        public int getShowNum() {
            return this.f11040f;
        }

        public boolean hasClickNum() {
            return this.f11037c;
        }

        public boolean hasPeriod() {
            return this.f11035a;
        }

        public boolean hasShowNum() {
            return this.f11039e;
        }

        public final boolean isInitialized() {
            return this.f11035a && this.f11037c && this.f11039e;
        }

        public RuleDisappear mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setPeriod(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setClickNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setShowNum(codedInputStreamMicro.readInt32());
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

        public RuleDisappear setClickNum(int i) {
            this.f11037c = true;
            this.f11038d = i;
            return this;
        }

        public RuleDisappear setPeriod(int i) {
            this.f11035a = true;
            this.f11036b = i;
            return this;
        }

        public RuleDisappear setShowNum(int i) {
            this.f11039e = true;
            this.f11040f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPeriod()) {
                codedOutputStreamMicro.writeInt32(1, getPeriod());
            }
            if (hasClickNum()) {
                codedOutputStreamMicro.writeInt32(2, getClickNum());
            }
            if (hasShowNum()) {
                codedOutputStreamMicro.writeInt32(3, getShowNum());
            }
        }
    }

    public static final class RuleExpire extends MessageMicro {
        public static final int END_TIME_FIELD_NUMBER = 2;
        public static final int START_TIME_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f11042a;
        /* renamed from: b */
        private String f11043b = "";
        /* renamed from: c */
        private boolean f11044c;
        /* renamed from: d */
        private String f11045d = "";
        /* renamed from: e */
        private int f11046e = -1;

        public static RuleExpire parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RuleExpire().mergeFrom(codedInputStreamMicro);
        }

        public static RuleExpire parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RuleExpire) new RuleExpire().mergeFrom(bArr);
        }

        public final RuleExpire clear() {
            clearStartTime();
            clearEndTime();
            this.f11046e = -1;
            return this;
        }

        public RuleExpire clearEndTime() {
            this.f11044c = false;
            this.f11045d = "";
            return this;
        }

        public RuleExpire clearStartTime() {
            this.f11042a = false;
            this.f11043b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f11046e < 0) {
                getSerializedSize();
            }
            return this.f11046e;
        }

        public String getEndTime() {
            return this.f11045d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasStartTime()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStartTime());
            }
            if (hasEndTime()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getEndTime());
            }
            this.f11046e = i;
            return i;
        }

        public String getStartTime() {
            return this.f11043b;
        }

        public boolean hasEndTime() {
            return this.f11044c;
        }

        public boolean hasStartTime() {
            return this.f11042a;
        }

        public final boolean isInitialized() {
            return this.f11042a && this.f11044c;
        }

        public RuleExpire mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

        public RuleExpire setEndTime(String str) {
            this.f11044c = true;
            this.f11045d = str;
            return this;
        }

        public RuleExpire setStartTime(String str) {
            this.f11042a = true;
            this.f11043b = str;
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

    public static CkResponse parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new CkResponse().mergeFrom(codedInputStreamMicro);
    }

    public static CkResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (CkResponse) new CkResponse().mergeFrom(bArr);
    }

    public final CkResponse clear() {
        clearDataResult();
        clearDataContent();
        this.f11051e = -1;
        return this;
    }

    public CkResponse clearDataContent() {
        this.f11049c = false;
        this.f11050d = null;
        return this;
    }

    public CkResponse clearDataResult() {
        this.f11047a = false;
        this.f11048b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f11051e < 0) {
            getSerializedSize();
        }
        return this.f11051e;
    }

    public CKContent getDataContent() {
        return this.f11050d;
    }

    public CKResult getDataResult() {
        return this.f11048b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasDataResult()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDataResult());
        }
        if (hasDataContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getDataContent());
        }
        this.f11051e = i;
        return i;
    }

    public boolean hasDataContent() {
        return this.f11049c;
    }

    public boolean hasDataResult() {
        return this.f11047a;
    }

    public final boolean isInitialized() {
        return (this.f11047a && getDataResult().isInitialized()) ? !hasDataContent() || getDataContent().isInitialized() : false;
    }

    public CkResponse mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro cKResult;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    cKResult = new CKResult();
                    codedInputStreamMicro.readMessage(cKResult);
                    setDataResult(cKResult);
                    continue;
                case 18:
                    cKResult = new CKContent();
                    codedInputStreamMicro.readMessage(cKResult);
                    setDataContent(cKResult);
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

    public CkResponse setDataContent(CKContent cKContent) {
        if (cKContent == null) {
            return clearDataContent();
        }
        this.f11049c = true;
        this.f11050d = cKContent;
        return this;
    }

    public CkResponse setDataResult(CKResult cKResult) {
        if (cKResult == null) {
            return clearDataResult();
        }
        this.f11047a = true;
        this.f11048b = cKResult;
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
