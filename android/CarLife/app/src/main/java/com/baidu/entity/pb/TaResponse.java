package com.baidu.entity.pb;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.carlife.core.C1253f;
import com.baidu.che.codriver.platform.NaviCmdConstants;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.MessageType;
import com.baidu.navisdk.ui.routeguide.model.RGHUDDataModel;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TaResponse extends MessageMicro {
    public static final int DATA_CONTENT_FIELD_NUMBER = 2;
    public static final int DATA_RESULT_FIELD_NUMBER = 1;
    /* renamed from: a */
    private boolean f15925a;
    /* renamed from: b */
    private TaResult f15926b = null;
    /* renamed from: c */
    private boolean f15927c;
    /* renamed from: d */
    private TaContent f15928d = null;
    /* renamed from: e */
    private int f15929e = -1;

    public static final class AddPagePointSug extends MessageMicro {
        public static final int CITY_NAME_FIELD_NUMBER = 5;
        public static final int LOC_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int POINT_TYPE_FIELD_NUMBER = 1;
        public static final int SRC_FROM_FIELD_NUMBER = 6;
        public static final int UID_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f14838a;
        /* renamed from: b */
        private String f14839b = "";
        /* renamed from: c */
        private boolean f14840c;
        /* renamed from: d */
        private String f14841d = "";
        /* renamed from: e */
        private boolean f14842e;
        /* renamed from: f */
        private String f14843f = "";
        /* renamed from: g */
        private boolean f14844g;
        /* renamed from: h */
        private String f14845h = "";
        /* renamed from: i */
        private boolean f14846i;
        /* renamed from: j */
        private String f14847j = "";
        /* renamed from: k */
        private boolean f14848k;
        /* renamed from: l */
        private String f14849l = "";
        /* renamed from: m */
        private int f14850m = -1;

        public static AddPagePointSug parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AddPagePointSug().mergeFrom(codedInputStreamMicro);
        }

        public static AddPagePointSug parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AddPagePointSug) new AddPagePointSug().mergeFrom(bArr);
        }

        public final AddPagePointSug clear() {
            clearPointType();
            clearName();
            clearLoc();
            clearUid();
            clearCityName();
            clearSrcFrom();
            this.f14850m = -1;
            return this;
        }

        public AddPagePointSug clearCityName() {
            this.f14846i = false;
            this.f14847j = "";
            return this;
        }

        public AddPagePointSug clearLoc() {
            this.f14842e = false;
            this.f14843f = "";
            return this;
        }

        public AddPagePointSug clearName() {
            this.f14840c = false;
            this.f14841d = "";
            return this;
        }

        public AddPagePointSug clearPointType() {
            this.f14838a = false;
            this.f14839b = "";
            return this;
        }

        public AddPagePointSug clearSrcFrom() {
            this.f14848k = false;
            this.f14849l = "";
            return this;
        }

        public AddPagePointSug clearUid() {
            this.f14844g = false;
            this.f14845h = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14850m < 0) {
                getSerializedSize();
            }
            return this.f14850m;
        }

        public String getCityName() {
            return this.f14847j;
        }

        public String getLoc() {
            return this.f14843f;
        }

        public String getName() {
            return this.f14841d;
        }

        public String getPointType() {
            return this.f14839b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPointType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPointType());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getLoc());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getUid());
            }
            if (hasCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getCityName());
            }
            if (hasSrcFrom()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getSrcFrom());
            }
            this.f14850m = i;
            return i;
        }

        public String getSrcFrom() {
            return this.f14849l;
        }

        public String getUid() {
            return this.f14845h;
        }

        public boolean hasCityName() {
            return this.f14846i;
        }

        public boolean hasLoc() {
            return this.f14842e;
        }

        public boolean hasName() {
            return this.f14840c;
        }

        public boolean hasPointType() {
            return this.f14838a;
        }

        public boolean hasSrcFrom() {
            return this.f14848k;
        }

        public boolean hasUid() {
            return this.f14844g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AddPagePointSug mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setPointType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setLoc(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setCityName(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setSrcFrom(codedInputStreamMicro.readString());
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

        public AddPagePointSug setCityName(String str) {
            this.f14846i = true;
            this.f14847j = str;
            return this;
        }

        public AddPagePointSug setLoc(String str) {
            this.f14842e = true;
            this.f14843f = str;
            return this;
        }

        public AddPagePointSug setName(String str) {
            this.f14840c = true;
            this.f14841d = str;
            return this;
        }

        public AddPagePointSug setPointType(String str) {
            this.f14838a = true;
            this.f14839b = str;
            return this;
        }

        public AddPagePointSug setSrcFrom(String str) {
            this.f14848k = true;
            this.f14849l = str;
            return this;
        }

        public AddPagePointSug setUid(String str) {
            this.f14844g = true;
            this.f14845h = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPointType()) {
                codedOutputStreamMicro.writeString(1, getPointType());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasLoc()) {
                codedOutputStreamMicro.writeString(3, getLoc());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(4, getUid());
            }
            if (hasCityName()) {
                codedOutputStreamMicro.writeString(5, getCityName());
            }
            if (hasSrcFrom()) {
                codedOutputStreamMicro.writeString(6, getSrcFrom());
            }
        }
    }

    public static final class AddPageTravelModSug extends MessageMicro {
        public static final int CARD_ICON_URL_FIELD_NUMBER = 2;
        public static final int CARD_TYPE_FIELD_NUMBER = 1;
        public static final int CONTENT_FIELD_NUMBER = 4;
        public static final int IS_CLOSE_FIELD_NUMBER = 6;
        public static final int IS_SUG_FIELD_NUMBER = 5;
        public static final int LABEL_FIELD_NUMBER = 8;
        public static final int SUB_TITLE_FIELD_NUMBER = 7;
        public static final int TITLE_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f14851a;
        /* renamed from: b */
        private String f14852b = "";
        /* renamed from: c */
        private boolean f14853c;
        /* renamed from: d */
        private String f14854d = "";
        /* renamed from: e */
        private boolean f14855e;
        /* renamed from: f */
        private String f14856f = "";
        /* renamed from: g */
        private boolean f14857g;
        /* renamed from: h */
        private String f14858h = "";
        /* renamed from: i */
        private boolean f14859i;
        /* renamed from: j */
        private int f14860j = 0;
        /* renamed from: k */
        private boolean f14861k;
        /* renamed from: l */
        private int f14862l = 0;
        /* renamed from: m */
        private boolean f14863m;
        /* renamed from: n */
        private String f14864n = "";
        /* renamed from: o */
        private boolean f14865o;
        /* renamed from: p */
        private String f14866p = "";
        /* renamed from: q */
        private int f14867q = -1;

        public static AddPageTravelModSug parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AddPageTravelModSug().mergeFrom(codedInputStreamMicro);
        }

        public static AddPageTravelModSug parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AddPageTravelModSug) new AddPageTravelModSug().mergeFrom(bArr);
        }

        public final AddPageTravelModSug clear() {
            clearCardType();
            clearCardIconUrl();
            clearTitle();
            clearContent();
            clearIsSug();
            clearIsClose();
            clearSubTitle();
            clearLabel();
            this.f14867q = -1;
            return this;
        }

        public AddPageTravelModSug clearCardIconUrl() {
            this.f14853c = false;
            this.f14854d = "";
            return this;
        }

        public AddPageTravelModSug clearCardType() {
            this.f14851a = false;
            this.f14852b = "";
            return this;
        }

        public AddPageTravelModSug clearContent() {
            this.f14857g = false;
            this.f14858h = "";
            return this;
        }

        public AddPageTravelModSug clearIsClose() {
            this.f14861k = false;
            this.f14862l = 0;
            return this;
        }

        public AddPageTravelModSug clearIsSug() {
            this.f14859i = false;
            this.f14860j = 0;
            return this;
        }

        public AddPageTravelModSug clearLabel() {
            this.f14865o = false;
            this.f14866p = "";
            return this;
        }

        public AddPageTravelModSug clearSubTitle() {
            this.f14863m = false;
            this.f14864n = "";
            return this;
        }

        public AddPageTravelModSug clearTitle() {
            this.f14855e = false;
            this.f14856f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14867q < 0) {
                getSerializedSize();
            }
            return this.f14867q;
        }

        public String getCardIconUrl() {
            return this.f14854d;
        }

        public String getCardType() {
            return this.f14852b;
        }

        public String getContent() {
            return this.f14858h;
        }

        public int getIsClose() {
            return this.f14862l;
        }

        public int getIsSug() {
            return this.f14860j;
        }

        public String getLabel() {
            return this.f14866p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCardType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCardType());
            }
            if (hasCardIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getCardIconUrl());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTitle());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getContent());
            }
            if (hasIsSug()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getIsSug());
            }
            if (hasIsClose()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getIsClose());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getSubTitle());
            }
            if (hasLabel()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getLabel());
            }
            this.f14867q = i;
            return i;
        }

        public String getSubTitle() {
            return this.f14864n;
        }

        public String getTitle() {
            return this.f14856f;
        }

        public boolean hasCardIconUrl() {
            return this.f14853c;
        }

        public boolean hasCardType() {
            return this.f14851a;
        }

        public boolean hasContent() {
            return this.f14857g;
        }

        public boolean hasIsClose() {
            return this.f14861k;
        }

        public boolean hasIsSug() {
            return this.f14859i;
        }

        public boolean hasLabel() {
            return this.f14865o;
        }

        public boolean hasSubTitle() {
            return this.f14863m;
        }

        public boolean hasTitle() {
            return this.f14855e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AddPageTravelModSug mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCardType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setCardIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setContent(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setIsSug(codedInputStreamMicro.readInt32());
                        continue;
                    case 48:
                        setIsClose(codedInputStreamMicro.readInt32());
                        continue;
                    case 58:
                        setSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setLabel(codedInputStreamMicro.readString());
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

        public AddPageTravelModSug setCardIconUrl(String str) {
            this.f14853c = true;
            this.f14854d = str;
            return this;
        }

        public AddPageTravelModSug setCardType(String str) {
            this.f14851a = true;
            this.f14852b = str;
            return this;
        }

        public AddPageTravelModSug setContent(String str) {
            this.f14857g = true;
            this.f14858h = str;
            return this;
        }

        public AddPageTravelModSug setIsClose(int i) {
            this.f14861k = true;
            this.f14862l = i;
            return this;
        }

        public AddPageTravelModSug setIsSug(int i) {
            this.f14859i = true;
            this.f14860j = i;
            return this;
        }

        public AddPageTravelModSug setLabel(String str) {
            this.f14865o = true;
            this.f14866p = str;
            return this;
        }

        public AddPageTravelModSug setSubTitle(String str) {
            this.f14863m = true;
            this.f14864n = str;
            return this;
        }

        public AddPageTravelModSug setTitle(String str) {
            this.f14855e = true;
            this.f14856f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCardType()) {
                codedOutputStreamMicro.writeString(1, getCardType());
            }
            if (hasCardIconUrl()) {
                codedOutputStreamMicro.writeString(2, getCardIconUrl());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(3, getTitle());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(4, getContent());
            }
            if (hasIsSug()) {
                codedOutputStreamMicro.writeInt32(5, getIsSug());
            }
            if (hasIsClose()) {
                codedOutputStreamMicro.writeInt32(6, getIsClose());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(7, getSubTitle());
            }
            if (hasLabel()) {
                codedOutputStreamMicro.writeString(8, getLabel());
            }
        }
    }

    public static final class AddPageTripTitleSug extends MessageMicro {
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14868a;
        /* renamed from: b */
        private String f14869b = "";
        /* renamed from: c */
        private int f14870c = -1;

        public static AddPageTripTitleSug parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new AddPageTripTitleSug().mergeFrom(codedInputStreamMicro);
        }

        public static AddPageTripTitleSug parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (AddPageTripTitleSug) new AddPageTripTitleSug().mergeFrom(bArr);
        }

        public final AddPageTripTitleSug clear() {
            clearTitle();
            this.f14870c = -1;
            return this;
        }

        public AddPageTripTitleSug clearTitle() {
            this.f14868a = false;
            this.f14869b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14870c < 0) {
                getSerializedSize();
            }
            return this.f14870c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            this.f14870c = i;
            return i;
        }

        public String getTitle() {
            return this.f14869b;
        }

        public boolean hasTitle() {
            return this.f14868a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public AddPageTripTitleSug mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
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

        public AddPageTripTitleSug setTitle(String str) {
            this.f14868a = true;
            this.f14869b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
        }
    }

    public static final class BMTrip extends MessageMicro {
        public static final int ARRIVAL_TIME_FIELD_NUMBER = 3;
        public static final int END_POINT_FIELD_NUMBER = 5;
        public static final int FLIGHT_INFO_FIELD_NUMBER = 9;
        public static final int START_POINT_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 2;
        public static final int TIME_TYPE_FIELD_NUMBER = 7;
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int TRAIN_INFO_FIELD_NUMBER = 8;
        public static final int TRIP_TYPE_FIELD_NUMBER = 6;
        /* renamed from: a */
        private boolean f14871a;
        /* renamed from: b */
        private String f14872b = "";
        /* renamed from: c */
        private boolean f14873c;
        /* renamed from: d */
        private long f14874d = 0;
        /* renamed from: e */
        private boolean f14875e;
        /* renamed from: f */
        private long f14876f = 0;
        /* renamed from: g */
        private boolean f14877g;
        /* renamed from: h */
        private MLTripPoint f14878h = null;
        /* renamed from: i */
        private boolean f14879i;
        /* renamed from: j */
        private MLTripPoint f14880j = null;
        /* renamed from: k */
        private boolean f14881k;
        /* renamed from: l */
        private long f14882l = 0;
        /* renamed from: m */
        private boolean f14883m;
        /* renamed from: n */
        private long f14884n = 0;
        /* renamed from: o */
        private boolean f14885o;
        /* renamed from: p */
        private MLTripTrainInfo f14886p = null;
        /* renamed from: q */
        private boolean f14887q;
        /* renamed from: r */
        private MLTripFlightInfo f14888r = null;
        /* renamed from: s */
        private int f14889s = -1;

        public static BMTrip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BMTrip().mergeFrom(codedInputStreamMicro);
        }

        public static BMTrip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BMTrip) new BMTrip().mergeFrom(bArr);
        }

        public final BMTrip clear() {
            clearTitle();
            clearStartTime();
            clearArrivalTime();
            clearStartPoint();
            clearEndPoint();
            clearTripType();
            clearTimeType();
            clearTrainInfo();
            clearFlightInfo();
            this.f14889s = -1;
            return this;
        }

        public BMTrip clearArrivalTime() {
            this.f14875e = false;
            this.f14876f = 0;
            return this;
        }

        public BMTrip clearEndPoint() {
            this.f14879i = false;
            this.f14880j = null;
            return this;
        }

        public BMTrip clearFlightInfo() {
            this.f14887q = false;
            this.f14888r = null;
            return this;
        }

        public BMTrip clearStartPoint() {
            this.f14877g = false;
            this.f14878h = null;
            return this;
        }

        public BMTrip clearStartTime() {
            this.f14873c = false;
            this.f14874d = 0;
            return this;
        }

        public BMTrip clearTimeType() {
            this.f14883m = false;
            this.f14884n = 0;
            return this;
        }

        public BMTrip clearTitle() {
            this.f14871a = false;
            this.f14872b = "";
            return this;
        }

        public BMTrip clearTrainInfo() {
            this.f14885o = false;
            this.f14886p = null;
            return this;
        }

        public BMTrip clearTripType() {
            this.f14881k = false;
            this.f14882l = 0;
            return this;
        }

        public long getArrivalTime() {
            return this.f14876f;
        }

        public int getCachedSize() {
            if (this.f14889s < 0) {
                getSerializedSize();
            }
            return this.f14889s;
        }

        public MLTripPoint getEndPoint() {
            return this.f14880j;
        }

        public MLTripFlightInfo getFlightInfo() {
            return this.f14888r;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(2, getStartTime());
            }
            if (hasArrivalTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(3, getArrivalTime());
            }
            if (hasStartPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getStartPoint());
            }
            if (hasEndPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getEndPoint());
            }
            if (hasTripType()) {
                i += CodedOutputStreamMicro.computeInt64Size(6, getTripType());
            }
            if (hasTimeType()) {
                i += CodedOutputStreamMicro.computeInt64Size(7, getTimeType());
            }
            if (hasTrainInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, getTrainInfo());
            }
            if (hasFlightInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(9, getFlightInfo());
            }
            this.f14889s = i;
            return i;
        }

        public MLTripPoint getStartPoint() {
            return this.f14878h;
        }

        public long getStartTime() {
            return this.f14874d;
        }

        public long getTimeType() {
            return this.f14884n;
        }

        public String getTitle() {
            return this.f14872b;
        }

        public MLTripTrainInfo getTrainInfo() {
            return this.f14886p;
        }

        public long getTripType() {
            return this.f14882l;
        }

        public boolean hasArrivalTime() {
            return this.f14875e;
        }

        public boolean hasEndPoint() {
            return this.f14879i;
        }

        public boolean hasFlightInfo() {
            return this.f14887q;
        }

        public boolean hasStartPoint() {
            return this.f14877g;
        }

        public boolean hasStartTime() {
            return this.f14873c;
        }

        public boolean hasTimeType() {
            return this.f14883m;
        }

        public boolean hasTitle() {
            return this.f14871a;
        }

        public boolean hasTrainInfo() {
            return this.f14885o;
        }

        public boolean hasTripType() {
            return this.f14881k;
        }

        public final boolean isInitialized() {
            return this.f14871a && this.f14873c && this.f14875e && this.f14877g && this.f14879i && getStartPoint().isInitialized() && getEndPoint().isInitialized();
        }

        public BMTrip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro mLTripPoint;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setStartTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 24:
                        setArrivalTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 34:
                        mLTripPoint = new MLTripPoint();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setStartPoint(mLTripPoint);
                        continue;
                    case 42:
                        mLTripPoint = new MLTripPoint();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setEndPoint(mLTripPoint);
                        continue;
                    case 48:
                        setTripType(codedInputStreamMicro.readInt64());
                        continue;
                    case 56:
                        setTimeType(codedInputStreamMicro.readInt64());
                        continue;
                    case 66:
                        mLTripPoint = new MLTripTrainInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setTrainInfo(mLTripPoint);
                        continue;
                    case 74:
                        mLTripPoint = new MLTripFlightInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setFlightInfo(mLTripPoint);
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

        public BMTrip setArrivalTime(long j) {
            this.f14875e = true;
            this.f14876f = j;
            return this;
        }

        public BMTrip setEndPoint(MLTripPoint mLTripPoint) {
            if (mLTripPoint == null) {
                return clearEndPoint();
            }
            this.f14879i = true;
            this.f14880j = mLTripPoint;
            return this;
        }

        public BMTrip setFlightInfo(MLTripFlightInfo mLTripFlightInfo) {
            if (mLTripFlightInfo == null) {
                return clearFlightInfo();
            }
            this.f14887q = true;
            this.f14888r = mLTripFlightInfo;
            return this;
        }

        public BMTrip setStartPoint(MLTripPoint mLTripPoint) {
            if (mLTripPoint == null) {
                return clearStartPoint();
            }
            this.f14877g = true;
            this.f14878h = mLTripPoint;
            return this;
        }

        public BMTrip setStartTime(long j) {
            this.f14873c = true;
            this.f14874d = j;
            return this;
        }

        public BMTrip setTimeType(long j) {
            this.f14883m = true;
            this.f14884n = j;
            return this;
        }

        public BMTrip setTitle(String str) {
            this.f14871a = true;
            this.f14872b = str;
            return this;
        }

        public BMTrip setTrainInfo(MLTripTrainInfo mLTripTrainInfo) {
            if (mLTripTrainInfo == null) {
                return clearTrainInfo();
            }
            this.f14885o = true;
            this.f14886p = mLTripTrainInfo;
            return this;
        }

        public BMTrip setTripType(long j) {
            this.f14881k = true;
            this.f14882l = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeInt64(2, getStartTime());
            }
            if (hasArrivalTime()) {
                codedOutputStreamMicro.writeInt64(3, getArrivalTime());
            }
            if (hasStartPoint()) {
                codedOutputStreamMicro.writeMessage(4, getStartPoint());
            }
            if (hasEndPoint()) {
                codedOutputStreamMicro.writeMessage(5, getEndPoint());
            }
            if (hasTripType()) {
                codedOutputStreamMicro.writeInt64(6, getTripType());
            }
            if (hasTimeType()) {
                codedOutputStreamMicro.writeInt64(7, getTimeType());
            }
            if (hasTrainInfo()) {
                codedOutputStreamMicro.writeMessage(8, getTrainInfo());
            }
            if (hasFlightInfo()) {
                codedOutputStreamMicro.writeMessage(9, getFlightInfo());
            }
        }
    }

    public static final class BaseMapList extends MessageMicro {
        public static final int TRIP_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<BMTrip> f14890a = Collections.emptyList();
        /* renamed from: b */
        private int f14891b = -1;

        public static BaseMapList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BaseMapList().mergeFrom(codedInputStreamMicro);
        }

        public static BaseMapList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BaseMapList) new BaseMapList().mergeFrom(bArr);
        }

        public BaseMapList addTrip(BMTrip bMTrip) {
            if (bMTrip != null) {
                if (this.f14890a.isEmpty()) {
                    this.f14890a = new ArrayList();
                }
                this.f14890a.add(bMTrip);
            }
            return this;
        }

        public final BaseMapList clear() {
            clearTrip();
            this.f14891b = -1;
            return this;
        }

        public BaseMapList clearTrip() {
            this.f14890a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f14891b < 0) {
                getSerializedSize();
            }
            return this.f14891b;
        }

        public int getSerializedSize() {
            int i = 0;
            for (BMTrip computeMessageSize : getTripList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f14891b = i;
            return i;
        }

        public BMTrip getTrip(int i) {
            return (BMTrip) this.f14890a.get(i);
        }

        public int getTripCount() {
            return this.f14890a.size();
        }

        public List<BMTrip> getTripList() {
            return this.f14890a;
        }

        public final boolean isInitialized() {
            for (BMTrip isInitialized : getTripList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public BaseMapList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro bMTrip = new BMTrip();
                        codedInputStreamMicro.readMessage(bMTrip);
                        addTrip(bMTrip);
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

        public BaseMapList setTrip(int i, BMTrip bMTrip) {
            if (bMTrip != null) {
                this.f14890a.set(i, bMTrip);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (BMTrip writeMessage : getTripList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class BaseTitleContent extends MessageMicro {
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 4;
        public static final int URL_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f14892a;
        /* renamed from: b */
        private String f14893b = "";
        /* renamed from: c */
        private boolean f14894c;
        /* renamed from: d */
        private String f14895d = "";
        /* renamed from: e */
        private boolean f14896e;
        /* renamed from: f */
        private String f14897f = "";
        /* renamed from: g */
        private boolean f14898g;
        /* renamed from: h */
        private String f14899h = "";
        /* renamed from: i */
        private int f14900i = -1;

        public static BaseTitleContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new BaseTitleContent().mergeFrom(codedInputStreamMicro);
        }

        public static BaseTitleContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (BaseTitleContent) new BaseTitleContent().mergeFrom(bArr);
        }

        public final BaseTitleContent clear() {
            clearTitle();
            clearContent();
            clearUrl();
            clearType();
            this.f14900i = -1;
            return this;
        }

        public BaseTitleContent clearContent() {
            this.f14894c = false;
            this.f14895d = "";
            return this;
        }

        public BaseTitleContent clearTitle() {
            this.f14892a = false;
            this.f14893b = "";
            return this;
        }

        public BaseTitleContent clearType() {
            this.f14898g = false;
            this.f14899h = "";
            return this;
        }

        public BaseTitleContent clearUrl() {
            this.f14896e = false;
            this.f14897f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14900i < 0) {
                getSerializedSize();
            }
            return this.f14900i;
        }

        public String getContent() {
            return this.f14895d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
            }
            if (hasUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getUrl());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getType());
            }
            this.f14900i = i;
            return i;
        }

        public String getTitle() {
            return this.f14893b;
        }

        public String getType() {
            return this.f14899h;
        }

        public String getUrl() {
            return this.f14897f;
        }

        public boolean hasContent() {
            return this.f14894c;
        }

        public boolean hasTitle() {
            return this.f14892a;
        }

        public boolean hasType() {
            return this.f14898g;
        }

        public boolean hasUrl() {
            return this.f14896e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public BaseTitleContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setContent(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setUrl(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setType(codedInputStreamMicro.readString());
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

        public BaseTitleContent setContent(String str) {
            this.f14894c = true;
            this.f14895d = str;
            return this;
        }

        public BaseTitleContent setTitle(String str) {
            this.f14892a = true;
            this.f14893b = str;
            return this;
        }

        public BaseTitleContent setType(String str) {
            this.f14898g = true;
            this.f14899h = str;
            return this;
        }

        public BaseTitleContent setUrl(String str) {
            this.f14896e = true;
            this.f14897f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(2, getContent());
            }
            if (hasUrl()) {
                codedOutputStreamMicro.writeString(3, getUrl());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeString(4, getType());
            }
        }
    }

    public static final class CalendarUploadInfo extends MessageMicro {
        public static final int CALENDAR_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f14901a;
        /* renamed from: b */
        private String f14902b = "";
        /* renamed from: c */
        private int f14903c = -1;

        public static CalendarUploadInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CalendarUploadInfo().mergeFrom(codedInputStreamMicro);
        }

        public static CalendarUploadInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CalendarUploadInfo) new CalendarUploadInfo().mergeFrom(bArr);
        }

        public final CalendarUploadInfo clear() {
            clearCalendarId();
            this.f14903c = -1;
            return this;
        }

        public CalendarUploadInfo clearCalendarId() {
            this.f14901a = false;
            this.f14902b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14903c < 0) {
                getSerializedSize();
            }
            return this.f14903c;
        }

        public String getCalendarId() {
            return this.f14902b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCalendarId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCalendarId());
            }
            this.f14903c = i;
            return i;
        }

        public boolean hasCalendarId() {
            return this.f14901a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CalendarUploadInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCalendarId(codedInputStreamMicro.readString());
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

        public CalendarUploadInfo setCalendarId(String str) {
            this.f14901a = true;
            this.f14902b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCalendarId()) {
                codedOutputStreamMicro.writeString(1, getCalendarId());
            }
        }
    }

    public static final class CardInfo extends MessageMicro {
        public static final int CARD_ICON_FIELD_NUMBER = 1;
        public static final int CARD_TITLE_FIELD_NUMBER = 3;
        public static final int CARD_TYPE_FIELD_NUMBER = 9;
        public static final int COLOR_DESC_FIELD_NUMBER = 13;
        public static final int DETAIL_TITLE_FIELD_NUMBER = 6;
        public static final int JUMP_URL_FIELD_NUMBER = 7;
        public static final int MARK_TYPE_FIELD_NUMBER = 10;
        public static final int MARK_TYPE_SUM_FIELD_NUMBER = 14;
        public static final int PRIORITY_FIELD_NUMBER = 12;
        public static final int REMARK_FIELD_NUMBER = 4;
        public static final int SMALL_CARD_ICON_FIELD_NUMBER = 2;
        public static final int TIME_INFO_FIELD_NUMBER = 5;
        public static final int TITLE_FIELD_NUMBER = 11;
        public static final int TRIP_ID_FIELD_NUMBER = 8;
        /* renamed from: A */
        private boolean f14904A;
        /* renamed from: B */
        private String f14905B = "";
        /* renamed from: C */
        private int f14906C = -1;
        /* renamed from: a */
        private boolean f14907a;
        /* renamed from: b */
        private String f14908b = "";
        /* renamed from: c */
        private boolean f14909c;
        /* renamed from: d */
        private String f14910d = "";
        /* renamed from: e */
        private boolean f14911e;
        /* renamed from: f */
        private String f14912f = "";
        /* renamed from: g */
        private boolean f14913g;
        /* renamed from: h */
        private String f14914h = "";
        /* renamed from: i */
        private boolean f14915i;
        /* renamed from: j */
        private String f14916j = "";
        /* renamed from: k */
        private boolean f14917k;
        /* renamed from: l */
        private String f14918l = "";
        /* renamed from: m */
        private boolean f14919m;
        /* renamed from: n */
        private String f14920n = "";
        /* renamed from: o */
        private boolean f14921o;
        /* renamed from: p */
        private String f14922p = "";
        /* renamed from: q */
        private boolean f14923q;
        /* renamed from: r */
        private String f14924r = "";
        /* renamed from: s */
        private boolean f14925s;
        /* renamed from: t */
        private String f14926t = "";
        /* renamed from: u */
        private boolean f14927u;
        /* renamed from: v */
        private String f14928v = "";
        /* renamed from: w */
        private boolean f14929w;
        /* renamed from: x */
        private int f14930x = 0;
        /* renamed from: y */
        private boolean f14931y;
        /* renamed from: z */
        private String f14932z = "";

        public static CardInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CardInfo().mergeFrom(codedInputStreamMicro);
        }

        public static CardInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CardInfo) new CardInfo().mergeFrom(bArr);
        }

        public final CardInfo clear() {
            clearCardIcon();
            clearSmallCardIcon();
            clearCardTitle();
            clearRemark();
            clearTimeInfo();
            clearDetailTitle();
            clearJumpUrl();
            clearTripId();
            clearCardType();
            clearMarkType();
            clearTitle();
            clearPriority();
            clearColorDesc();
            clearMarkTypeSum();
            this.f14906C = -1;
            return this;
        }

        public CardInfo clearCardIcon() {
            this.f14907a = false;
            this.f14908b = "";
            return this;
        }

        public CardInfo clearCardTitle() {
            this.f14911e = false;
            this.f14912f = "";
            return this;
        }

        public CardInfo clearCardType() {
            this.f14923q = false;
            this.f14924r = "";
            return this;
        }

        public CardInfo clearColorDesc() {
            this.f14931y = false;
            this.f14932z = "";
            return this;
        }

        public CardInfo clearDetailTitle() {
            this.f14917k = false;
            this.f14918l = "";
            return this;
        }

        public CardInfo clearJumpUrl() {
            this.f14919m = false;
            this.f14920n = "";
            return this;
        }

        public CardInfo clearMarkType() {
            this.f14925s = false;
            this.f14926t = "";
            return this;
        }

        public CardInfo clearMarkTypeSum() {
            this.f14904A = false;
            this.f14905B = "";
            return this;
        }

        public CardInfo clearPriority() {
            this.f14929w = false;
            this.f14930x = 0;
            return this;
        }

        public CardInfo clearRemark() {
            this.f14913g = false;
            this.f14914h = "";
            return this;
        }

        public CardInfo clearSmallCardIcon() {
            this.f14909c = false;
            this.f14910d = "";
            return this;
        }

        public CardInfo clearTimeInfo() {
            this.f14915i = false;
            this.f14916j = "";
            return this;
        }

        public CardInfo clearTitle() {
            this.f14927u = false;
            this.f14928v = "";
            return this;
        }

        public CardInfo clearTripId() {
            this.f14921o = false;
            this.f14922p = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14906C < 0) {
                getSerializedSize();
            }
            return this.f14906C;
        }

        public String getCardIcon() {
            return this.f14908b;
        }

        public String getCardTitle() {
            return this.f14912f;
        }

        public String getCardType() {
            return this.f14924r;
        }

        public String getColorDesc() {
            return this.f14932z;
        }

        public String getDetailTitle() {
            return this.f14918l;
        }

        public String getJumpUrl() {
            return this.f14920n;
        }

        public String getMarkType() {
            return this.f14926t;
        }

        public String getMarkTypeSum() {
            return this.f14905B;
        }

        public int getPriority() {
            return this.f14930x;
        }

        public String getRemark() {
            return this.f14914h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCardIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCardIcon());
            }
            if (hasSmallCardIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSmallCardIcon());
            }
            if (hasCardTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getCardTitle());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getRemark());
            }
            if (hasTimeInfo()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getTimeInfo());
            }
            if (hasDetailTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDetailTitle());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getJumpUrl());
            }
            if (hasTripId()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getTripId());
            }
            if (hasCardType()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getCardType());
            }
            if (hasMarkType()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getMarkType());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getTitle());
            }
            if (hasPriority()) {
                i += CodedOutputStreamMicro.computeInt32Size(12, getPriority());
            }
            if (hasColorDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getColorDesc());
            }
            if (hasMarkTypeSum()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getMarkTypeSum());
            }
            this.f14906C = i;
            return i;
        }

        public String getSmallCardIcon() {
            return this.f14910d;
        }

        public String getTimeInfo() {
            return this.f14916j;
        }

        public String getTitle() {
            return this.f14928v;
        }

        public String getTripId() {
            return this.f14922p;
        }

        public boolean hasCardIcon() {
            return this.f14907a;
        }

        public boolean hasCardTitle() {
            return this.f14911e;
        }

        public boolean hasCardType() {
            return this.f14923q;
        }

        public boolean hasColorDesc() {
            return this.f14931y;
        }

        public boolean hasDetailTitle() {
            return this.f14917k;
        }

        public boolean hasJumpUrl() {
            return this.f14919m;
        }

        public boolean hasMarkType() {
            return this.f14925s;
        }

        public boolean hasMarkTypeSum() {
            return this.f14904A;
        }

        public boolean hasPriority() {
            return this.f14929w;
        }

        public boolean hasRemark() {
            return this.f14913g;
        }

        public boolean hasSmallCardIcon() {
            return this.f14909c;
        }

        public boolean hasTimeInfo() {
            return this.f14915i;
        }

        public boolean hasTitle() {
            return this.f14927u;
        }

        public boolean hasTripId() {
            return this.f14921o;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CardInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCardIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSmallCardIcon(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setCardTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setRemark(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setTimeInfo(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setDetailTitle(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setTripId(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setCardType(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setMarkType(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 96:
                        setPriority(codedInputStreamMicro.readInt32());
                        continue;
                    case 106:
                        setColorDesc(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setMarkTypeSum(codedInputStreamMicro.readString());
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

        public CardInfo setCardIcon(String str) {
            this.f14907a = true;
            this.f14908b = str;
            return this;
        }

        public CardInfo setCardTitle(String str) {
            this.f14911e = true;
            this.f14912f = str;
            return this;
        }

        public CardInfo setCardType(String str) {
            this.f14923q = true;
            this.f14924r = str;
            return this;
        }

        public CardInfo setColorDesc(String str) {
            this.f14931y = true;
            this.f14932z = str;
            return this;
        }

        public CardInfo setDetailTitle(String str) {
            this.f14917k = true;
            this.f14918l = str;
            return this;
        }

        public CardInfo setJumpUrl(String str) {
            this.f14919m = true;
            this.f14920n = str;
            return this;
        }

        public CardInfo setMarkType(String str) {
            this.f14925s = true;
            this.f14926t = str;
            return this;
        }

        public CardInfo setMarkTypeSum(String str) {
            this.f14904A = true;
            this.f14905B = str;
            return this;
        }

        public CardInfo setPriority(int i) {
            this.f14929w = true;
            this.f14930x = i;
            return this;
        }

        public CardInfo setRemark(String str) {
            this.f14913g = true;
            this.f14914h = str;
            return this;
        }

        public CardInfo setSmallCardIcon(String str) {
            this.f14909c = true;
            this.f14910d = str;
            return this;
        }

        public CardInfo setTimeInfo(String str) {
            this.f14915i = true;
            this.f14916j = str;
            return this;
        }

        public CardInfo setTitle(String str) {
            this.f14927u = true;
            this.f14928v = str;
            return this;
        }

        public CardInfo setTripId(String str) {
            this.f14921o = true;
            this.f14922p = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCardIcon()) {
                codedOutputStreamMicro.writeString(1, getCardIcon());
            }
            if (hasSmallCardIcon()) {
                codedOutputStreamMicro.writeString(2, getSmallCardIcon());
            }
            if (hasCardTitle()) {
                codedOutputStreamMicro.writeString(3, getCardTitle());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(4, getRemark());
            }
            if (hasTimeInfo()) {
                codedOutputStreamMicro.writeString(5, getTimeInfo());
            }
            if (hasDetailTitle()) {
                codedOutputStreamMicro.writeString(6, getDetailTitle());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(7, getJumpUrl());
            }
            if (hasTripId()) {
                codedOutputStreamMicro.writeString(8, getTripId());
            }
            if (hasCardType()) {
                codedOutputStreamMicro.writeString(9, getCardType());
            }
            if (hasMarkType()) {
                codedOutputStreamMicro.writeString(10, getMarkType());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(11, getTitle());
            }
            if (hasPriority()) {
                codedOutputStreamMicro.writeInt32(12, getPriority());
            }
            if (hasColorDesc()) {
                codedOutputStreamMicro.writeString(13, getColorDesc());
            }
            if (hasMarkTypeSum()) {
                codedOutputStreamMicro.writeString(14, getMarkTypeSum());
            }
        }
    }

    public static final class CardResource extends MessageMicro {
        public static final int AIDE_ICON_FIELD_NUMBER = 6;
        public static final int ARRIVE_TIME_FIELD_NUMBER = 3;
        public static final int DELAY_ICON_FIELD_NUMBER = 12;
        public static final int DELAY_TITLE_FIELD_NUMBER = 13;
        public static final int END_STATION_FIELD_NUMBER = 5;
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int IS_DELAY_FIELD_NUMBER = 14;
        public static final int IS_EXPIRE_FIELD_NUMBER = 17;
        public static final int ORDER_TYPE_FIELD_NUMBER = 15;
        public static final int REMARK_FIELD_NUMBER = 16;
        public static final int ROUTE_INFO_FIELD_NUMBER = 9;
        public static final int SHOW_TYPE_FIELD_NUMBER = 10;
        public static final int START_STATION_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 2;
        public static final int TRANSPORT_FIELD_NUMBER = 8;
        public static final int TRIP_EXT_FIELD_NUMBER = 7;
        public static final int TRIP_TYPE_FIELD_NUMBER = 11;
        /* renamed from: A */
        private boolean f14933A;
        /* renamed from: B */
        private int f14934B = 0;
        /* renamed from: C */
        private boolean f14935C;
        /* renamed from: D */
        private String f14936D = "";
        /* renamed from: E */
        private boolean f14937E;
        /* renamed from: F */
        private String f14938F = "";
        /* renamed from: G */
        private boolean f14939G;
        /* renamed from: H */
        private boolean f14940H = false;
        /* renamed from: I */
        private int f14941I = -1;
        /* renamed from: a */
        private boolean f14942a;
        /* renamed from: b */
        private String f14943b = "";
        /* renamed from: c */
        private boolean f14944c;
        /* renamed from: d */
        private String f14945d = "";
        /* renamed from: e */
        private boolean f14946e;
        /* renamed from: f */
        private String f14947f = "";
        /* renamed from: g */
        private boolean f14948g;
        /* renamed from: h */
        private Station f14949h = null;
        /* renamed from: i */
        private boolean f14950i;
        /* renamed from: j */
        private Station f14951j = null;
        /* renamed from: k */
        private boolean f14952k;
        /* renamed from: l */
        private String f14953l = "";
        /* renamed from: m */
        private boolean f14954m;
        /* renamed from: n */
        private TripExt f14955n = null;
        /* renamed from: o */
        private boolean f14956o;
        /* renamed from: p */
        private Transport f14957p = null;
        /* renamed from: q */
        private boolean f14958q;
        /* renamed from: r */
        private String f14959r = "";
        /* renamed from: s */
        private boolean f14960s;
        /* renamed from: t */
        private int f14961t = 0;
        /* renamed from: u */
        private boolean f14962u;
        /* renamed from: v */
        private int f14963v = 0;
        /* renamed from: w */
        private boolean f14964w;
        /* renamed from: x */
        private String f14965x = "";
        /* renamed from: y */
        private boolean f14966y;
        /* renamed from: z */
        private String f14967z = "";

        public static CardResource parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CardResource().mergeFrom(codedInputStreamMicro);
        }

        public static CardResource parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CardResource) new CardResource().mergeFrom(bArr);
        }

        public final CardResource clear() {
            clearIcon();
            clearStartTime();
            clearArriveTime();
            clearStartStation();
            clearEndStation();
            clearAideIcon();
            clearTripExt();
            clearTransport();
            clearRouteInfo();
            clearShowType();
            clearTripType();
            clearDelayIcon();
            clearDelayTitle();
            clearIsDelay();
            clearOrderType();
            clearRemark();
            clearIsExpire();
            this.f14941I = -1;
            return this;
        }

        public CardResource clearAideIcon() {
            this.f14952k = false;
            this.f14953l = "";
            return this;
        }

        public CardResource clearArriveTime() {
            this.f14946e = false;
            this.f14947f = "";
            return this;
        }

        public CardResource clearDelayIcon() {
            this.f14964w = false;
            this.f14965x = "";
            return this;
        }

        public CardResource clearDelayTitle() {
            this.f14966y = false;
            this.f14967z = "";
            return this;
        }

        public CardResource clearEndStation() {
            this.f14950i = false;
            this.f14951j = null;
            return this;
        }

        public CardResource clearIcon() {
            this.f14942a = false;
            this.f14943b = "";
            return this;
        }

        public CardResource clearIsDelay() {
            this.f14933A = false;
            this.f14934B = 0;
            return this;
        }

        public CardResource clearIsExpire() {
            this.f14939G = false;
            this.f14940H = false;
            return this;
        }

        public CardResource clearOrderType() {
            this.f14935C = false;
            this.f14936D = "";
            return this;
        }

        public CardResource clearRemark() {
            this.f14937E = false;
            this.f14938F = "";
            return this;
        }

        public CardResource clearRouteInfo() {
            this.f14958q = false;
            this.f14959r = "";
            return this;
        }

        public CardResource clearShowType() {
            this.f14960s = false;
            this.f14961t = 0;
            return this;
        }

        public CardResource clearStartStation() {
            this.f14948g = false;
            this.f14949h = null;
            return this;
        }

        public CardResource clearStartTime() {
            this.f14944c = false;
            this.f14945d = "";
            return this;
        }

        public CardResource clearTransport() {
            this.f14956o = false;
            this.f14957p = null;
            return this;
        }

        public CardResource clearTripExt() {
            this.f14954m = false;
            this.f14955n = null;
            return this;
        }

        public CardResource clearTripType() {
            this.f14962u = false;
            this.f14963v = 0;
            return this;
        }

        public String getAideIcon() {
            return this.f14953l;
        }

        public String getArriveTime() {
            return this.f14947f;
        }

        public int getCachedSize() {
            if (this.f14941I < 0) {
                getSerializedSize();
            }
            return this.f14941I;
        }

        public String getDelayIcon() {
            return this.f14965x;
        }

        public String getDelayTitle() {
            return this.f14967z;
        }

        public Station getEndStation() {
            return this.f14951j;
        }

        public String getIcon() {
            return this.f14943b;
        }

        public int getIsDelay() {
            return this.f14934B;
        }

        public boolean getIsExpire() {
            return this.f14940H;
        }

        public String getOrderType() {
            return this.f14936D;
        }

        public String getRemark() {
            return this.f14938F;
        }

        public String getRouteInfo() {
            return this.f14959r;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getStartTime());
            }
            if (hasArriveTime()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getArriveTime());
            }
            if (hasStartStation()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getStartStation());
            }
            if (hasEndStation()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getEndStation());
            }
            if (hasAideIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getAideIcon());
            }
            if (hasTripExt()) {
                i += CodedOutputStreamMicro.computeMessageSize(7, getTripExt());
            }
            if (hasTransport()) {
                i += CodedOutputStreamMicro.computeMessageSize(8, getTransport());
            }
            if (hasRouteInfo()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getRouteInfo());
            }
            if (hasShowType()) {
                i += CodedOutputStreamMicro.computeInt32Size(10, getShowType());
            }
            if (hasTripType()) {
                i += CodedOutputStreamMicro.computeInt32Size(11, getTripType());
            }
            if (hasDelayIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getDelayIcon());
            }
            if (hasDelayTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getDelayTitle());
            }
            if (hasIsDelay()) {
                i += CodedOutputStreamMicro.computeInt32Size(14, getIsDelay());
            }
            if (hasOrderType()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getOrderType());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getRemark());
            }
            if (hasIsExpire()) {
                i += CodedOutputStreamMicro.computeBoolSize(17, getIsExpire());
            }
            this.f14941I = i;
            return i;
        }

        public int getShowType() {
            return this.f14961t;
        }

        public Station getStartStation() {
            return this.f14949h;
        }

        public String getStartTime() {
            return this.f14945d;
        }

        public Transport getTransport() {
            return this.f14957p;
        }

        public TripExt getTripExt() {
            return this.f14955n;
        }

        public int getTripType() {
            return this.f14963v;
        }

        public boolean hasAideIcon() {
            return this.f14952k;
        }

        public boolean hasArriveTime() {
            return this.f14946e;
        }

        public boolean hasDelayIcon() {
            return this.f14964w;
        }

        public boolean hasDelayTitle() {
            return this.f14966y;
        }

        public boolean hasEndStation() {
            return this.f14950i;
        }

        public boolean hasIcon() {
            return this.f14942a;
        }

        public boolean hasIsDelay() {
            return this.f14933A;
        }

        public boolean hasIsExpire() {
            return this.f14939G;
        }

        public boolean hasOrderType() {
            return this.f14935C;
        }

        public boolean hasRemark() {
            return this.f14937E;
        }

        public boolean hasRouteInfo() {
            return this.f14958q;
        }

        public boolean hasShowType() {
            return this.f14960s;
        }

        public boolean hasStartStation() {
            return this.f14948g;
        }

        public boolean hasStartTime() {
            return this.f14944c;
        }

        public boolean hasTransport() {
            return this.f14956o;
        }

        public boolean hasTripExt() {
            return this.f14954m;
        }

        public boolean hasTripType() {
            return this.f14962u;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CardResource mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro station;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setArriveTime(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        station = new Station();
                        codedInputStreamMicro.readMessage(station);
                        setStartStation(station);
                        continue;
                    case 42:
                        station = new Station();
                        codedInputStreamMicro.readMessage(station);
                        setEndStation(station);
                        continue;
                    case 50:
                        setAideIcon(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        station = new TripExt();
                        codedInputStreamMicro.readMessage(station);
                        setTripExt(station);
                        continue;
                    case 66:
                        station = new Transport();
                        codedInputStreamMicro.readMessage(station);
                        setTransport(station);
                        continue;
                    case 74:
                        setRouteInfo(codedInputStreamMicro.readString());
                        continue;
                    case 80:
                        setShowType(codedInputStreamMicro.readInt32());
                        continue;
                    case 88:
                        setTripType(codedInputStreamMicro.readInt32());
                        continue;
                    case 98:
                        setDelayIcon(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setDelayTitle(codedInputStreamMicro.readString());
                        continue;
                    case 112:
                        setIsDelay(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.df /*122*/:
                        setOrderType(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setRemark(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                        setIsExpire(codedInputStreamMicro.readBool());
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

        public CardResource setAideIcon(String str) {
            this.f14952k = true;
            this.f14953l = str;
            return this;
        }

        public CardResource setArriveTime(String str) {
            this.f14946e = true;
            this.f14947f = str;
            return this;
        }

        public CardResource setDelayIcon(String str) {
            this.f14964w = true;
            this.f14965x = str;
            return this;
        }

        public CardResource setDelayTitle(String str) {
            this.f14966y = true;
            this.f14967z = str;
            return this;
        }

        public CardResource setEndStation(Station station) {
            if (station == null) {
                return clearEndStation();
            }
            this.f14950i = true;
            this.f14951j = station;
            return this;
        }

        public CardResource setIcon(String str) {
            this.f14942a = true;
            this.f14943b = str;
            return this;
        }

        public CardResource setIsDelay(int i) {
            this.f14933A = true;
            this.f14934B = i;
            return this;
        }

        public CardResource setIsExpire(boolean z) {
            this.f14939G = true;
            this.f14940H = z;
            return this;
        }

        public CardResource setOrderType(String str) {
            this.f14935C = true;
            this.f14936D = str;
            return this;
        }

        public CardResource setRemark(String str) {
            this.f14937E = true;
            this.f14938F = str;
            return this;
        }

        public CardResource setRouteInfo(String str) {
            this.f14958q = true;
            this.f14959r = str;
            return this;
        }

        public CardResource setShowType(int i) {
            this.f14960s = true;
            this.f14961t = i;
            return this;
        }

        public CardResource setStartStation(Station station) {
            if (station == null) {
                return clearStartStation();
            }
            this.f14948g = true;
            this.f14949h = station;
            return this;
        }

        public CardResource setStartTime(String str) {
            this.f14944c = true;
            this.f14945d = str;
            return this;
        }

        public CardResource setTransport(Transport transport) {
            if (transport == null) {
                return clearTransport();
            }
            this.f14956o = true;
            this.f14957p = transport;
            return this;
        }

        public CardResource setTripExt(TripExt tripExt) {
            if (tripExt == null) {
                return clearTripExt();
            }
            this.f14954m = true;
            this.f14955n = tripExt;
            return this;
        }

        public CardResource setTripType(int i) {
            this.f14962u = true;
            this.f14963v = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(2, getStartTime());
            }
            if (hasArriveTime()) {
                codedOutputStreamMicro.writeString(3, getArriveTime());
            }
            if (hasStartStation()) {
                codedOutputStreamMicro.writeMessage(4, getStartStation());
            }
            if (hasEndStation()) {
                codedOutputStreamMicro.writeMessage(5, getEndStation());
            }
            if (hasAideIcon()) {
                codedOutputStreamMicro.writeString(6, getAideIcon());
            }
            if (hasTripExt()) {
                codedOutputStreamMicro.writeMessage(7, getTripExt());
            }
            if (hasTransport()) {
                codedOutputStreamMicro.writeMessage(8, getTransport());
            }
            if (hasRouteInfo()) {
                codedOutputStreamMicro.writeString(9, getRouteInfo());
            }
            if (hasShowType()) {
                codedOutputStreamMicro.writeInt32(10, getShowType());
            }
            if (hasTripType()) {
                codedOutputStreamMicro.writeInt32(11, getTripType());
            }
            if (hasDelayIcon()) {
                codedOutputStreamMicro.writeString(12, getDelayIcon());
            }
            if (hasDelayTitle()) {
                codedOutputStreamMicro.writeString(13, getDelayTitle());
            }
            if (hasIsDelay()) {
                codedOutputStreamMicro.writeInt32(14, getIsDelay());
            }
            if (hasOrderType()) {
                codedOutputStreamMicro.writeString(15, getOrderType());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(16, getRemark());
            }
            if (hasIsExpire()) {
                codedOutputStreamMicro.writeBool(17, getIsExpire());
            }
        }
    }

    public static final class CityInfo extends MessageMicro {
        public static final int CITY_FIELD_NUMBER = 1;
        public static final int PINYIN_FIELD_NUMBER = 3;
        public static final int STA_NAME_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f14968a;
        /* renamed from: b */
        private String f14969b = "";
        /* renamed from: c */
        private boolean f14970c;
        /* renamed from: d */
        private String f14971d = "";
        /* renamed from: e */
        private boolean f14972e;
        /* renamed from: f */
        private String f14973f = "";
        /* renamed from: g */
        private int f14974g = -1;

        public static CityInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CityInfo().mergeFrom(codedInputStreamMicro);
        }

        public static CityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CityInfo) new CityInfo().mergeFrom(bArr);
        }

        public final CityInfo clear() {
            clearCity();
            clearStaName();
            clearPinyin();
            this.f14974g = -1;
            return this;
        }

        public CityInfo clearCity() {
            this.f14968a = false;
            this.f14969b = "";
            return this;
        }

        public CityInfo clearPinyin() {
            this.f14972e = false;
            this.f14973f = "";
            return this;
        }

        public CityInfo clearStaName() {
            this.f14970c = false;
            this.f14971d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f14974g < 0) {
                getSerializedSize();
            }
            return this.f14974g;
        }

        public String getCity() {
            return this.f14969b;
        }

        public String getPinyin() {
            return this.f14973f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCity()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCity());
            }
            if (hasStaName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getStaName());
            }
            if (hasPinyin()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getPinyin());
            }
            this.f14974g = i;
            return i;
        }

        public String getStaName() {
            return this.f14971d;
        }

        public boolean hasCity() {
            return this.f14968a;
        }

        public boolean hasPinyin() {
            return this.f14972e;
        }

        public boolean hasStaName() {
            return this.f14970c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CityInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCity(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setStaName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setPinyin(codedInputStreamMicro.readString());
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

        public CityInfo setCity(String str) {
            this.f14968a = true;
            this.f14969b = str;
            return this;
        }

        public CityInfo setPinyin(String str) {
            this.f14972e = true;
            this.f14973f = str;
            return this;
        }

        public CityInfo setStaName(String str) {
            this.f14970c = true;
            this.f14971d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCity()) {
                codedOutputStreamMicro.writeString(1, getCity());
            }
            if (hasStaName()) {
                codedOutputStreamMicro.writeString(2, getStaName());
            }
            if (hasPinyin()) {
                codedOutputStreamMicro.writeString(3, getPinyin());
            }
        }
    }

    public static final class CloudConf extends MessageMicro {
        public static final int CALENDAR_UPLOAD_FIELD_NUMBER = 1;
        public static final int HAS_CUR_TRIP_FIELD_NUMBER = 8;
        public static final int PAGE_SIZE_FIELD_NUMBER = 7;
        public static final int SMS_MAX_NUM_FIELD_NUMBER = 2;
        public static final int TOTAL_CNT_FIELD_NUMBER = 5;
        public static final int TOTAL_PAGE_FIELD_NUMBER = 6;
        public static final int UPLOAD_FIELD_NUMBER = 3;
        public static final int VERSION_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f14975a;
        /* renamed from: b */
        private boolean f14976b = false;
        /* renamed from: c */
        private boolean f14977c;
        /* renamed from: d */
        private int f14978d = 0;
        /* renamed from: e */
        private boolean f14979e;
        /* renamed from: f */
        private boolean f14980f = false;
        /* renamed from: g */
        private boolean f14981g;
        /* renamed from: h */
        private long f14982h = 0;
        /* renamed from: i */
        private boolean f14983i;
        /* renamed from: j */
        private int f14984j = 0;
        /* renamed from: k */
        private boolean f14985k;
        /* renamed from: l */
        private int f14986l = 0;
        /* renamed from: m */
        private boolean f14987m;
        /* renamed from: n */
        private int f14988n = 0;
        /* renamed from: o */
        private boolean f14989o;
        /* renamed from: p */
        private int f14990p = 0;
        /* renamed from: q */
        private int f14991q = -1;

        public static CloudConf parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new CloudConf().mergeFrom(codedInputStreamMicro);
        }

        public static CloudConf parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (CloudConf) new CloudConf().mergeFrom(bArr);
        }

        public final CloudConf clear() {
            clearCalendarUpload();
            clearSmsMaxNum();
            clearUpload();
            clearVersion();
            clearTotalCnt();
            clearTotalPage();
            clearPageSize();
            clearHasCurTrip();
            this.f14991q = -1;
            return this;
        }

        public CloudConf clearCalendarUpload() {
            this.f14975a = false;
            this.f14976b = false;
            return this;
        }

        public CloudConf clearHasCurTrip() {
            this.f14989o = false;
            this.f14990p = 0;
            return this;
        }

        public CloudConf clearPageSize() {
            this.f14987m = false;
            this.f14988n = 0;
            return this;
        }

        public CloudConf clearSmsMaxNum() {
            this.f14977c = false;
            this.f14978d = 0;
            return this;
        }

        public CloudConf clearTotalCnt() {
            this.f14983i = false;
            this.f14984j = 0;
            return this;
        }

        public CloudConf clearTotalPage() {
            this.f14985k = false;
            this.f14986l = 0;
            return this;
        }

        public CloudConf clearUpload() {
            this.f14979e = false;
            this.f14980f = false;
            return this;
        }

        public CloudConf clearVersion() {
            this.f14981g = false;
            this.f14982h = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f14991q < 0) {
                getSerializedSize();
            }
            return this.f14991q;
        }

        public boolean getCalendarUpload() {
            return this.f14976b;
        }

        public int getHasCurTrip() {
            return this.f14990p;
        }

        public int getPageSize() {
            return this.f14988n;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCalendarUpload()) {
                i = 0 + CodedOutputStreamMicro.computeBoolSize(1, getCalendarUpload());
            }
            if (hasSmsMaxNum()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getSmsMaxNum());
            }
            if (hasUpload()) {
                i += CodedOutputStreamMicro.computeBoolSize(3, getUpload());
            }
            if (hasVersion()) {
                i += CodedOutputStreamMicro.computeInt64Size(4, getVersion());
            }
            if (hasTotalCnt()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getTotalCnt());
            }
            if (hasTotalPage()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getTotalPage());
            }
            if (hasPageSize()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getPageSize());
            }
            if (hasHasCurTrip()) {
                i += CodedOutputStreamMicro.computeInt32Size(8, getHasCurTrip());
            }
            this.f14991q = i;
            return i;
        }

        public int getSmsMaxNum() {
            return this.f14978d;
        }

        public int getTotalCnt() {
            return this.f14984j;
        }

        public int getTotalPage() {
            return this.f14986l;
        }

        public boolean getUpload() {
            return this.f14980f;
        }

        public long getVersion() {
            return this.f14982h;
        }

        public boolean hasCalendarUpload() {
            return this.f14975a;
        }

        public boolean hasHasCurTrip() {
            return this.f14989o;
        }

        public boolean hasPageSize() {
            return this.f14987m;
        }

        public boolean hasSmsMaxNum() {
            return this.f14977c;
        }

        public boolean hasTotalCnt() {
            return this.f14983i;
        }

        public boolean hasTotalPage() {
            return this.f14985k;
        }

        public boolean hasUpload() {
            return this.f14979e;
        }

        public boolean hasVersion() {
            return this.f14981g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CloudConf mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setCalendarUpload(codedInputStreamMicro.readBool());
                        continue;
                    case 16:
                        setSmsMaxNum(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setUpload(codedInputStreamMicro.readBool());
                        continue;
                    case 32:
                        setVersion(codedInputStreamMicro.readInt64());
                        continue;
                    case 40:
                        setTotalCnt(codedInputStreamMicro.readInt32());
                        continue;
                    case 48:
                        setTotalPage(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setPageSize(codedInputStreamMicro.readInt32());
                        continue;
                    case 64:
                        setHasCurTrip(codedInputStreamMicro.readInt32());
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

        public CloudConf setCalendarUpload(boolean z) {
            this.f14975a = true;
            this.f14976b = z;
            return this;
        }

        public CloudConf setHasCurTrip(int i) {
            this.f14989o = true;
            this.f14990p = i;
            return this;
        }

        public CloudConf setPageSize(int i) {
            this.f14987m = true;
            this.f14988n = i;
            return this;
        }

        public CloudConf setSmsMaxNum(int i) {
            this.f14977c = true;
            this.f14978d = i;
            return this;
        }

        public CloudConf setTotalCnt(int i) {
            this.f14983i = true;
            this.f14984j = i;
            return this;
        }

        public CloudConf setTotalPage(int i) {
            this.f14985k = true;
            this.f14986l = i;
            return this;
        }

        public CloudConf setUpload(boolean z) {
            this.f14979e = true;
            this.f14980f = z;
            return this;
        }

        public CloudConf setVersion(long j) {
            this.f14981g = true;
            this.f14982h = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCalendarUpload()) {
                codedOutputStreamMicro.writeBool(1, getCalendarUpload());
            }
            if (hasSmsMaxNum()) {
                codedOutputStreamMicro.writeInt32(2, getSmsMaxNum());
            }
            if (hasUpload()) {
                codedOutputStreamMicro.writeBool(3, getUpload());
            }
            if (hasVersion()) {
                codedOutputStreamMicro.writeInt64(4, getVersion());
            }
            if (hasTotalCnt()) {
                codedOutputStreamMicro.writeInt32(5, getTotalCnt());
            }
            if (hasTotalPage()) {
                codedOutputStreamMicro.writeInt32(6, getTotalPage());
            }
            if (hasPageSize()) {
                codedOutputStreamMicro.writeInt32(7, getPageSize());
            }
            if (hasHasCurTrip()) {
                codedOutputStreamMicro.writeInt32(8, getHasCurTrip());
            }
        }
    }

    public static final class ControlData extends MessageMicro {
        public static final int CLOUD_CONF_FIELD_NUMBER = 4;
        public static final int CONFIG_VERSION_FIELD_NUMBER = 2;
        public static final int DYNAMIC_MAP_DATA_FIELD_NUMBER = 3;
        public static final int SCENE_ENTRY_FIELD_NUMBER = 1;
        public static final int SMS_CONF_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f14992a;
        /* renamed from: b */
        private SceneEntry f14993b = null;
        /* renamed from: c */
        private boolean f14994c;
        /* renamed from: d */
        private VersionInfo f14995d = null;
        /* renamed from: e */
        private boolean f14996e;
        /* renamed from: f */
        private ByteStringMicro f14997f = ByteStringMicro.EMPTY;
        /* renamed from: g */
        private boolean f14998g;
        /* renamed from: h */
        private CloudConf f14999h = null;
        /* renamed from: i */
        private boolean f15000i;
        /* renamed from: j */
        private CloudConf f15001j = null;
        /* renamed from: k */
        private int f15002k = -1;

        public static ControlData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ControlData().mergeFrom(codedInputStreamMicro);
        }

        public static ControlData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ControlData) new ControlData().mergeFrom(bArr);
        }

        public final ControlData clear() {
            clearSceneEntry();
            clearConfigVersion();
            clearDynamicMapData();
            clearCloudConf();
            clearSmsConf();
            this.f15002k = -1;
            return this;
        }

        public ControlData clearCloudConf() {
            this.f14998g = false;
            this.f14999h = null;
            return this;
        }

        public ControlData clearConfigVersion() {
            this.f14994c = false;
            this.f14995d = null;
            return this;
        }

        public ControlData clearDynamicMapData() {
            this.f14996e = false;
            this.f14997f = ByteStringMicro.EMPTY;
            return this;
        }

        public ControlData clearSceneEntry() {
            this.f14992a = false;
            this.f14993b = null;
            return this;
        }

        public ControlData clearSmsConf() {
            this.f15000i = false;
            this.f15001j = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15002k < 0) {
                getSerializedSize();
            }
            return this.f15002k;
        }

        public CloudConf getCloudConf() {
            return this.f14999h;
        }

        public VersionInfo getConfigVersion() {
            return this.f14995d;
        }

        public ByteStringMicro getDynamicMapData() {
            return this.f14997f;
        }

        public SceneEntry getSceneEntry() {
            return this.f14993b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSceneEntry()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getSceneEntry());
            }
            if (hasConfigVersion()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getConfigVersion());
            }
            if (hasDynamicMapData()) {
                i += CodedOutputStreamMicro.computeBytesSize(3, getDynamicMapData());
            }
            if (hasCloudConf()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getCloudConf());
            }
            if (hasSmsConf()) {
                i += CodedOutputStreamMicro.computeMessageSize(5, getSmsConf());
            }
            this.f15002k = i;
            return i;
        }

        public CloudConf getSmsConf() {
            return this.f15001j;
        }

        public boolean hasCloudConf() {
            return this.f14998g;
        }

        public boolean hasConfigVersion() {
            return this.f14994c;
        }

        public boolean hasDynamicMapData() {
            return this.f14996e;
        }

        public boolean hasSceneEntry() {
            return this.f14992a;
        }

        public boolean hasSmsConf() {
            return this.f15000i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ControlData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro sceneEntry;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        sceneEntry = new SceneEntry();
                        codedInputStreamMicro.readMessage(sceneEntry);
                        setSceneEntry(sceneEntry);
                        continue;
                    case 18:
                        sceneEntry = new VersionInfo();
                        codedInputStreamMicro.readMessage(sceneEntry);
                        setConfigVersion(sceneEntry);
                        continue;
                    case 26:
                        setDynamicMapData(codedInputStreamMicro.readBytes());
                        continue;
                    case 34:
                        sceneEntry = new CloudConf();
                        codedInputStreamMicro.readMessage(sceneEntry);
                        setCloudConf(sceneEntry);
                        continue;
                    case 42:
                        sceneEntry = new CloudConf();
                        codedInputStreamMicro.readMessage(sceneEntry);
                        setSmsConf(sceneEntry);
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

        public ControlData setCloudConf(CloudConf cloudConf) {
            if (cloudConf == null) {
                return clearCloudConf();
            }
            this.f14998g = true;
            this.f14999h = cloudConf;
            return this;
        }

        public ControlData setConfigVersion(VersionInfo versionInfo) {
            if (versionInfo == null) {
                return clearConfigVersion();
            }
            this.f14994c = true;
            this.f14995d = versionInfo;
            return this;
        }

        public ControlData setDynamicMapData(ByteStringMicro byteStringMicro) {
            this.f14996e = true;
            this.f14997f = byteStringMicro;
            return this;
        }

        public ControlData setSceneEntry(SceneEntry sceneEntry) {
            if (sceneEntry == null) {
                return clearSceneEntry();
            }
            this.f14992a = true;
            this.f14993b = sceneEntry;
            return this;
        }

        public ControlData setSmsConf(CloudConf cloudConf) {
            if (cloudConf == null) {
                return clearSmsConf();
            }
            this.f15000i = true;
            this.f15001j = cloudConf;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSceneEntry()) {
                codedOutputStreamMicro.writeMessage(1, getSceneEntry());
            }
            if (hasConfigVersion()) {
                codedOutputStreamMicro.writeMessage(2, getConfigVersion());
            }
            if (hasDynamicMapData()) {
                codedOutputStreamMicro.writeBytes(3, getDynamicMapData());
            }
            if (hasCloudConf()) {
                codedOutputStreamMicro.writeMessage(4, getCloudConf());
            }
            if (hasSmsConf()) {
                codedOutputStreamMicro.writeMessage(5, getSmsConf());
            }
        }
    }

    public static final class ControlInfo extends MessageMicro {
        public static final int DEADLINE_TIME_FIELD_NUMBER = 2;
        public static final int NEXT_REQUEST_TIME_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15003a;
        /* renamed from: b */
        private long f15004b = 0;
        /* renamed from: c */
        private boolean f15005c;
        /* renamed from: d */
        private long f15006d = 0;
        /* renamed from: e */
        private int f15007e = -1;

        public static ControlInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ControlInfo().mergeFrom(codedInputStreamMicro);
        }

        public static ControlInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ControlInfo) new ControlInfo().mergeFrom(bArr);
        }

        public final ControlInfo clear() {
            clearNextRequestTime();
            clearDeadlineTime();
            this.f15007e = -1;
            return this;
        }

        public ControlInfo clearDeadlineTime() {
            this.f15005c = false;
            this.f15006d = 0;
            return this;
        }

        public ControlInfo clearNextRequestTime() {
            this.f15003a = false;
            this.f15004b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15007e < 0) {
                getSerializedSize();
            }
            return this.f15007e;
        }

        public long getDeadlineTime() {
            return this.f15006d;
        }

        public long getNextRequestTime() {
            return this.f15004b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasNextRequestTime()) {
                i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getNextRequestTime());
            }
            if (hasDeadlineTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(2, getDeadlineTime());
            }
            this.f15007e = i;
            return i;
        }

        public boolean hasDeadlineTime() {
            return this.f15005c;
        }

        public boolean hasNextRequestTime() {
            return this.f15003a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ControlInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setNextRequestTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 16:
                        setDeadlineTime(codedInputStreamMicro.readInt64());
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

        public ControlInfo setDeadlineTime(long j) {
            this.f15005c = true;
            this.f15006d = j;
            return this;
        }

        public ControlInfo setNextRequestTime(long j) {
            this.f15003a = true;
            this.f15004b = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasNextRequestTime()) {
                codedOutputStreamMicro.writeInt64(1, getNextRequestTime());
            }
            if (hasDeadlineTime()) {
                codedOutputStreamMicro.writeInt64(2, getDeadlineTime());
            }
        }
    }

    public static final class DriverPageCardInfo extends MessageMicro {
        public static final int CONTROL_INFO_FIELD_NUMBER = 1;
        public static final int DRIVER_PAGE_FIELD_NUMBER = 2;
        public static final int NOTIFY_CONTENT_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15008a;
        /* renamed from: b */
        private ControlInfo f15009b = null;
        /* renamed from: c */
        private List<DriverPageInfo> f15010c = Collections.emptyList();
        /* renamed from: d */
        private List<NotifyContent> f15011d = Collections.emptyList();
        /* renamed from: e */
        private int f15012e = -1;

        public static DriverPageCardInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new DriverPageCardInfo().mergeFrom(codedInputStreamMicro);
        }

        public static DriverPageCardInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (DriverPageCardInfo) new DriverPageCardInfo().mergeFrom(bArr);
        }

        public DriverPageCardInfo addDriverPage(DriverPageInfo driverPageInfo) {
            if (driverPageInfo != null) {
                if (this.f15010c.isEmpty()) {
                    this.f15010c = new ArrayList();
                }
                this.f15010c.add(driverPageInfo);
            }
            return this;
        }

        public DriverPageCardInfo addNotifyContent(NotifyContent notifyContent) {
            if (notifyContent != null) {
                if (this.f15011d.isEmpty()) {
                    this.f15011d = new ArrayList();
                }
                this.f15011d.add(notifyContent);
            }
            return this;
        }

        public final DriverPageCardInfo clear() {
            clearControlInfo();
            clearDriverPage();
            clearNotifyContent();
            this.f15012e = -1;
            return this;
        }

        public DriverPageCardInfo clearControlInfo() {
            this.f15008a = false;
            this.f15009b = null;
            return this;
        }

        public DriverPageCardInfo clearDriverPage() {
            this.f15010c = Collections.emptyList();
            return this;
        }

        public DriverPageCardInfo clearNotifyContent() {
            this.f15011d = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15012e < 0) {
                getSerializedSize();
            }
            return this.f15012e;
        }

        public ControlInfo getControlInfo() {
            return this.f15009b;
        }

        public DriverPageInfo getDriverPage(int i) {
            return (DriverPageInfo) this.f15010c.get(i);
        }

        public int getDriverPageCount() {
            return this.f15010c.size();
        }

        public List<DriverPageInfo> getDriverPageList() {
            return this.f15010c;
        }

        public NotifyContent getNotifyContent(int i) {
            return (NotifyContent) this.f15011d.get(i);
        }

        public int getNotifyContentCount() {
            return this.f15011d.size();
        }

        public List<NotifyContent> getNotifyContentList() {
            return this.f15011d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasControlInfo()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getControlInfo());
            }
            int i2 = i;
            for (DriverPageInfo computeMessageSize : getDriverPageList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            for (NotifyContent computeMessageSize2 : getNotifyContentList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize2);
            }
            this.f15012e = i2;
            return i2;
        }

        public boolean hasControlInfo() {
            return this.f15008a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public DriverPageCardInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro controlInfo;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        controlInfo = new ControlInfo();
                        codedInputStreamMicro.readMessage(controlInfo);
                        setControlInfo(controlInfo);
                        continue;
                    case 18:
                        controlInfo = new DriverPageInfo();
                        codedInputStreamMicro.readMessage(controlInfo);
                        addDriverPage(controlInfo);
                        continue;
                    case 26:
                        controlInfo = new NotifyContent();
                        codedInputStreamMicro.readMessage(controlInfo);
                        addNotifyContent(controlInfo);
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

        public DriverPageCardInfo setControlInfo(ControlInfo controlInfo) {
            if (controlInfo == null) {
                return clearControlInfo();
            }
            this.f15008a = true;
            this.f15009b = controlInfo;
            return this;
        }

        public DriverPageCardInfo setDriverPage(int i, DriverPageInfo driverPageInfo) {
            if (driverPageInfo != null) {
                this.f15010c.set(i, driverPageInfo);
            }
            return this;
        }

        public DriverPageCardInfo setNotifyContent(int i, NotifyContent notifyContent) {
            if (notifyContent != null) {
                this.f15011d.set(i, notifyContent);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasControlInfo()) {
                codedOutputStreamMicro.writeMessage(1, getControlInfo());
            }
            for (DriverPageInfo writeMessage : getDriverPageList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            for (NotifyContent writeMessage2 : getNotifyContentList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage2);
            }
        }
    }

    public static final class DriverPageContent extends MessageMicro {
        public static final int NOTIFY_CONTENT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<NotifyContent> f15013a = Collections.emptyList();
        /* renamed from: b */
        private int f15014b = -1;

        public static DriverPageContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new DriverPageContent().mergeFrom(codedInputStreamMicro);
        }

        public static DriverPageContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (DriverPageContent) new DriverPageContent().mergeFrom(bArr);
        }

        public DriverPageContent addNotifyContent(NotifyContent notifyContent) {
            if (notifyContent != null) {
                if (this.f15013a.isEmpty()) {
                    this.f15013a = new ArrayList();
                }
                this.f15013a.add(notifyContent);
            }
            return this;
        }

        public final DriverPageContent clear() {
            clearNotifyContent();
            this.f15014b = -1;
            return this;
        }

        public DriverPageContent clearNotifyContent() {
            this.f15013a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15014b < 0) {
                getSerializedSize();
            }
            return this.f15014b;
        }

        public NotifyContent getNotifyContent(int i) {
            return (NotifyContent) this.f15013a.get(i);
        }

        public int getNotifyContentCount() {
            return this.f15013a.size();
        }

        public List<NotifyContent> getNotifyContentList() {
            return this.f15013a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (NotifyContent computeMessageSize : getNotifyContentList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f15014b = i;
            return i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public DriverPageContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro notifyContent = new NotifyContent();
                        codedInputStreamMicro.readMessage(notifyContent);
                        addNotifyContent(notifyContent);
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

        public DriverPageContent setNotifyContent(int i, NotifyContent notifyContent) {
            if (notifyContent != null) {
                this.f15013a.set(i, notifyContent);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (NotifyContent writeMessage : getNotifyContentList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class DriverPageInfo extends MessageMicro {
        public static final int BUTTON_TITLE_FIELD_NUMBER = 3;
        public static final int CARD_ICON_URL_FIELD_NUMBER = 9;
        public static final int CARD_TYPE_FIELD_NUMBER = 11;
        public static final int DETAIL_URL_FIELD_NUMBER = 6;
        public static final int END_LOC_FIELD_NUMBER = 13;
        public static final int ICON_URL_FIELD_NUMBER = 5;
        public static final int IS_ROUTE_FIELD_NUMBER = 15;
        public static final int JUMP_URL_FIELD_NUMBER = 4;
        public static final int LABEL_FIELD_NUMBER = 17;
        public static final int NOTIFY_CONTENT_FIELD_NUMBER = 16;
        public static final int POI_UID_FIELD_NUMBER = 8;
        public static final int START_LOC_FIELD_NUMBER = 12;
        public static final int STATUS_TITLE_FIELD_NUMBER = 14;
        public static final int SUB_TITLE_FIELD_NUMBER = 2;
        public static final int SUG_FLAG_FIELD_NUMBER = 10;
        public static final int TITLE_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 7;
        /* renamed from: A */
        private boolean f15015A;
        /* renamed from: B */
        private String f15016B = "";
        /* renamed from: C */
        private boolean f15017C;
        /* renamed from: D */
        private boolean f15018D = false;
        /* renamed from: E */
        private List<NotifyContent> f15019E = Collections.emptyList();
        /* renamed from: F */
        private boolean f15020F;
        /* renamed from: G */
        private String f15021G = "";
        /* renamed from: H */
        private int f15022H = -1;
        /* renamed from: a */
        private boolean f15023a;
        /* renamed from: b */
        private String f15024b = "";
        /* renamed from: c */
        private boolean f15025c;
        /* renamed from: d */
        private String f15026d = "";
        /* renamed from: e */
        private boolean f15027e;
        /* renamed from: f */
        private String f15028f = "";
        /* renamed from: g */
        private boolean f15029g;
        /* renamed from: h */
        private String f15030h = "";
        /* renamed from: i */
        private boolean f15031i;
        /* renamed from: j */
        private String f15032j = "";
        /* renamed from: k */
        private boolean f15033k;
        /* renamed from: l */
        private String f15034l = "";
        /* renamed from: m */
        private boolean f15035m;
        /* renamed from: n */
        private String f15036n = "";
        /* renamed from: o */
        private boolean f15037o;
        /* renamed from: p */
        private String f15038p = "";
        /* renamed from: q */
        private boolean f15039q;
        /* renamed from: r */
        private String f15040r = "";
        /* renamed from: s */
        private boolean f15041s;
        /* renamed from: t */
        private String f15042t = "";
        /* renamed from: u */
        private boolean f15043u;
        /* renamed from: v */
        private String f15044v = "";
        /* renamed from: w */
        private boolean f15045w;
        /* renamed from: x */
        private String f15046x = "";
        /* renamed from: y */
        private boolean f15047y;
        /* renamed from: z */
        private String f15048z = "";

        public static DriverPageInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new DriverPageInfo().mergeFrom(codedInputStreamMicro);
        }

        public static DriverPageInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (DriverPageInfo) new DriverPageInfo().mergeFrom(bArr);
        }

        public DriverPageInfo addNotifyContent(NotifyContent notifyContent) {
            if (notifyContent != null) {
                if (this.f15019E.isEmpty()) {
                    this.f15019E = new ArrayList();
                }
                this.f15019E.add(notifyContent);
            }
            return this;
        }

        public final DriverPageInfo clear() {
            clearTitle();
            clearSubTitle();
            clearButtonTitle();
            clearJumpUrl();
            clearIconUrl();
            clearDetailUrl();
            clearType();
            clearPoiUid();
            clearCardIconUrl();
            clearSugFlag();
            clearCardType();
            clearStartLoc();
            clearEndLoc();
            clearStatusTitle();
            clearIsRoute();
            clearNotifyContent();
            clearLabel();
            this.f15022H = -1;
            return this;
        }

        public DriverPageInfo clearButtonTitle() {
            this.f15027e = false;
            this.f15028f = "";
            return this;
        }

        public DriverPageInfo clearCardIconUrl() {
            this.f15039q = false;
            this.f15040r = "";
            return this;
        }

        public DriverPageInfo clearCardType() {
            this.f15043u = false;
            this.f15044v = "";
            return this;
        }

        public DriverPageInfo clearDetailUrl() {
            this.f15033k = false;
            this.f15034l = "";
            return this;
        }

        public DriverPageInfo clearEndLoc() {
            this.f15047y = false;
            this.f15048z = "";
            return this;
        }

        public DriverPageInfo clearIconUrl() {
            this.f15031i = false;
            this.f15032j = "";
            return this;
        }

        public DriverPageInfo clearIsRoute() {
            this.f15017C = false;
            this.f15018D = false;
            return this;
        }

        public DriverPageInfo clearJumpUrl() {
            this.f15029g = false;
            this.f15030h = "";
            return this;
        }

        public DriverPageInfo clearLabel() {
            this.f15020F = false;
            this.f15021G = "";
            return this;
        }

        public DriverPageInfo clearNotifyContent() {
            this.f15019E = Collections.emptyList();
            return this;
        }

        public DriverPageInfo clearPoiUid() {
            this.f15037o = false;
            this.f15038p = "";
            return this;
        }

        public DriverPageInfo clearStartLoc() {
            this.f15045w = false;
            this.f15046x = "";
            return this;
        }

        public DriverPageInfo clearStatusTitle() {
            this.f15015A = false;
            this.f15016B = "";
            return this;
        }

        public DriverPageInfo clearSubTitle() {
            this.f15025c = false;
            this.f15026d = "";
            return this;
        }

        public DriverPageInfo clearSugFlag() {
            this.f15041s = false;
            this.f15042t = "";
            return this;
        }

        public DriverPageInfo clearTitle() {
            this.f15023a = false;
            this.f15024b = "";
            return this;
        }

        public DriverPageInfo clearType() {
            this.f15035m = false;
            this.f15036n = "";
            return this;
        }

        public String getButtonTitle() {
            return this.f15028f;
        }

        public int getCachedSize() {
            if (this.f15022H < 0) {
                getSerializedSize();
            }
            return this.f15022H;
        }

        public String getCardIconUrl() {
            return this.f15040r;
        }

        public String getCardType() {
            return this.f15044v;
        }

        public String getDetailUrl() {
            return this.f15034l;
        }

        public String getEndLoc() {
            return this.f15048z;
        }

        public String getIconUrl() {
            return this.f15032j;
        }

        public boolean getIsRoute() {
            return this.f15018D;
        }

        public String getJumpUrl() {
            return this.f15030h;
        }

        public String getLabel() {
            return this.f15021G;
        }

        public NotifyContent getNotifyContent(int i) {
            return (NotifyContent) this.f15019E.get(i);
        }

        public int getNotifyContentCount() {
            return this.f15019E.size();
        }

        public List<NotifyContent> getNotifyContentList() {
            return this.f15019E;
        }

        public String getPoiUid() {
            return this.f15038p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSubTitle());
            }
            if (hasButtonTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getButtonTitle());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
            }
            if (hasIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getIconUrl());
            }
            if (hasDetailUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDetailUrl());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getType());
            }
            if (hasPoiUid()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getPoiUid());
            }
            if (hasCardIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getCardIconUrl());
            }
            if (hasSugFlag()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getSugFlag());
            }
            if (hasCardType()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getCardType());
            }
            if (hasStartLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getStartLoc());
            }
            if (hasEndLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getEndLoc());
            }
            if (hasStatusTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getStatusTitle());
            }
            if (hasIsRoute()) {
                i += CodedOutputStreamMicro.computeBoolSize(15, getIsRoute());
            }
            int i2 = i;
            for (NotifyContent computeMessageSize : getNotifyContentList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(16, computeMessageSize) + i2;
            }
            if (hasLabel()) {
                i2 += CodedOutputStreamMicro.computeStringSize(17, getLabel());
            }
            this.f15022H = i2;
            return i2;
        }

        public String getStartLoc() {
            return this.f15046x;
        }

        public String getStatusTitle() {
            return this.f15016B;
        }

        public String getSubTitle() {
            return this.f15026d;
        }

        public String getSugFlag() {
            return this.f15042t;
        }

        public String getTitle() {
            return this.f15024b;
        }

        public String getType() {
            return this.f15036n;
        }

        public boolean hasButtonTitle() {
            return this.f15027e;
        }

        public boolean hasCardIconUrl() {
            return this.f15039q;
        }

        public boolean hasCardType() {
            return this.f15043u;
        }

        public boolean hasDetailUrl() {
            return this.f15033k;
        }

        public boolean hasEndLoc() {
            return this.f15047y;
        }

        public boolean hasIconUrl() {
            return this.f15031i;
        }

        public boolean hasIsRoute() {
            return this.f15017C;
        }

        public boolean hasJumpUrl() {
            return this.f15029g;
        }

        public boolean hasLabel() {
            return this.f15020F;
        }

        public boolean hasPoiUid() {
            return this.f15037o;
        }

        public boolean hasStartLoc() {
            return this.f15045w;
        }

        public boolean hasStatusTitle() {
            return this.f15015A;
        }

        public boolean hasSubTitle() {
            return this.f15025c;
        }

        public boolean hasSugFlag() {
            return this.f15041s;
        }

        public boolean hasTitle() {
            return this.f15023a;
        }

        public boolean hasType() {
            return this.f15035m;
        }

        public final boolean isInitialized() {
            return true;
        }

        public DriverPageInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setButtonTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setDetailUrl(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setType(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setPoiUid(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setCardIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setSugFlag(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setCardType(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setStartLoc(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setEndLoc(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setStatusTitle(codedInputStreamMicro.readString());
                        continue;
                    case 120:
                        setIsRoute(codedInputStreamMicro.readBool());
                        continue;
                    case 130:
                        MessageMicro notifyContent = new NotifyContent();
                        codedInputStreamMicro.readMessage(notifyContent);
                        addNotifyContent(notifyContent);
                        continue;
                    case 138:
                        setLabel(codedInputStreamMicro.readString());
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

        public DriverPageInfo setButtonTitle(String str) {
            this.f15027e = true;
            this.f15028f = str;
            return this;
        }

        public DriverPageInfo setCardIconUrl(String str) {
            this.f15039q = true;
            this.f15040r = str;
            return this;
        }

        public DriverPageInfo setCardType(String str) {
            this.f15043u = true;
            this.f15044v = str;
            return this;
        }

        public DriverPageInfo setDetailUrl(String str) {
            this.f15033k = true;
            this.f15034l = str;
            return this;
        }

        public DriverPageInfo setEndLoc(String str) {
            this.f15047y = true;
            this.f15048z = str;
            return this;
        }

        public DriverPageInfo setIconUrl(String str) {
            this.f15031i = true;
            this.f15032j = str;
            return this;
        }

        public DriverPageInfo setIsRoute(boolean z) {
            this.f15017C = true;
            this.f15018D = z;
            return this;
        }

        public DriverPageInfo setJumpUrl(String str) {
            this.f15029g = true;
            this.f15030h = str;
            return this;
        }

        public DriverPageInfo setLabel(String str) {
            this.f15020F = true;
            this.f15021G = str;
            return this;
        }

        public DriverPageInfo setNotifyContent(int i, NotifyContent notifyContent) {
            if (notifyContent != null) {
                this.f15019E.set(i, notifyContent);
            }
            return this;
        }

        public DriverPageInfo setPoiUid(String str) {
            this.f15037o = true;
            this.f15038p = str;
            return this;
        }

        public DriverPageInfo setStartLoc(String str) {
            this.f15045w = true;
            this.f15046x = str;
            return this;
        }

        public DriverPageInfo setStatusTitle(String str) {
            this.f15015A = true;
            this.f15016B = str;
            return this;
        }

        public DriverPageInfo setSubTitle(String str) {
            this.f15025c = true;
            this.f15026d = str;
            return this;
        }

        public DriverPageInfo setSugFlag(String str) {
            this.f15041s = true;
            this.f15042t = str;
            return this;
        }

        public DriverPageInfo setTitle(String str) {
            this.f15023a = true;
            this.f15024b = str;
            return this;
        }

        public DriverPageInfo setType(String str) {
            this.f15035m = true;
            this.f15036n = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(2, getSubTitle());
            }
            if (hasButtonTitle()) {
                codedOutputStreamMicro.writeString(3, getButtonTitle());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(4, getJumpUrl());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(5, getIconUrl());
            }
            if (hasDetailUrl()) {
                codedOutputStreamMicro.writeString(6, getDetailUrl());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeString(7, getType());
            }
            if (hasPoiUid()) {
                codedOutputStreamMicro.writeString(8, getPoiUid());
            }
            if (hasCardIconUrl()) {
                codedOutputStreamMicro.writeString(9, getCardIconUrl());
            }
            if (hasSugFlag()) {
                codedOutputStreamMicro.writeString(10, getSugFlag());
            }
            if (hasCardType()) {
                codedOutputStreamMicro.writeString(11, getCardType());
            }
            if (hasStartLoc()) {
                codedOutputStreamMicro.writeString(12, getStartLoc());
            }
            if (hasEndLoc()) {
                codedOutputStreamMicro.writeString(13, getEndLoc());
            }
            if (hasStatusTitle()) {
                codedOutputStreamMicro.writeString(14, getStatusTitle());
            }
            if (hasIsRoute()) {
                codedOutputStreamMicro.writeBool(15, getIsRoute());
            }
            for (NotifyContent writeMessage : getNotifyContentList()) {
                codedOutputStreamMicro.writeMessage(16, writeMessage);
            }
            if (hasLabel()) {
                codedOutputStreamMicro.writeString(17, getLabel());
            }
        }
    }

    public static final class FlightCheckData extends MessageMicro {
        public static final int FLIGHT_COUNT_FIELD_NUMBER = 1;
        public static final int FLIGHT_LIST_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15049a;
        /* renamed from: b */
        private int f15050b = 0;
        /* renamed from: c */
        private List<FlightNoDetailData> f15051c = Collections.emptyList();
        /* renamed from: d */
        private int f15052d = -1;

        public static FlightCheckData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightCheckData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightCheckData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightCheckData) new FlightCheckData().mergeFrom(bArr);
        }

        public FlightCheckData addFlightList(FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                if (this.f15051c.isEmpty()) {
                    this.f15051c = new ArrayList();
                }
                this.f15051c.add(flightNoDetailData);
            }
            return this;
        }

        public final FlightCheckData clear() {
            clearFlightCount();
            clearFlightList();
            this.f15052d = -1;
            return this;
        }

        public FlightCheckData clearFlightCount() {
            this.f15049a = false;
            this.f15050b = 0;
            return this;
        }

        public FlightCheckData clearFlightList() {
            this.f15051c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15052d < 0) {
                getSerializedSize();
            }
            return this.f15052d;
        }

        public int getFlightCount() {
            return this.f15050b;
        }

        public FlightNoDetailData getFlightList(int i) {
            return (FlightNoDetailData) this.f15051c.get(i);
        }

        public int getFlightListCount() {
            return this.f15051c.size();
        }

        public List<FlightNoDetailData> getFlightListList() {
            return this.f15051c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFlightCount()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getFlightCount());
            }
            int i2 = i;
            for (FlightNoDetailData computeMessageSize : getFlightListList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f15052d = i2;
            return i2;
        }

        public boolean hasFlightCount() {
            return this.f15049a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightCheckData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setFlightCount(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        MessageMicro flightNoDetailData = new FlightNoDetailData();
                        codedInputStreamMicro.readMessage(flightNoDetailData);
                        addFlightList(flightNoDetailData);
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

        public FlightCheckData setFlightCount(int i) {
            this.f15049a = true;
            this.f15050b = i;
            return this;
        }

        public FlightCheckData setFlightList(int i, FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                this.f15051c.set(i, flightNoDetailData);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFlightCount()) {
                codedOutputStreamMicro.writeInt32(1, getFlightCount());
            }
            for (FlightNoDetailData writeMessage : getFlightListList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class FlightConfigData extends MessageMicro {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int SHORT_TITLE_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15053a;
        /* renamed from: b */
        private String f15054b = "";
        /* renamed from: c */
        private List<FlightListData> f15055c = Collections.emptyList();
        /* renamed from: d */
        private boolean f15056d;
        /* renamed from: e */
        private String f15057e = "";
        /* renamed from: f */
        private int f15058f = -1;

        public static FlightConfigData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightConfigData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightConfigData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightConfigData) new FlightConfigData().mergeFrom(bArr);
        }

        public FlightConfigData addData(FlightListData flightListData) {
            if (flightListData != null) {
                if (this.f15055c.isEmpty()) {
                    this.f15055c = new ArrayList();
                }
                this.f15055c.add(flightListData);
            }
            return this;
        }

        public final FlightConfigData clear() {
            clearTitle();
            clearData();
            clearShortTitle();
            this.f15058f = -1;
            return this;
        }

        public FlightConfigData clearData() {
            this.f15055c = Collections.emptyList();
            return this;
        }

        public FlightConfigData clearShortTitle() {
            this.f15056d = false;
            this.f15057e = "";
            return this;
        }

        public FlightConfigData clearTitle() {
            this.f15053a = false;
            this.f15054b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15058f < 0) {
                getSerializedSize();
            }
            return this.f15058f;
        }

        public FlightListData getData(int i) {
            return (FlightListData) this.f15055c.get(i);
        }

        public int getDataCount() {
            return this.f15055c.size();
        }

        public List<FlightListData> getDataList() {
            return this.f15055c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            int i2 = i;
            for (FlightListData computeMessageSize : getDataList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasShortTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getShortTitle());
            }
            this.f15058f = i2;
            return i2;
        }

        public String getShortTitle() {
            return this.f15057e;
        }

        public String getTitle() {
            return this.f15054b;
        }

        public boolean hasShortTitle() {
            return this.f15056d;
        }

        public boolean hasTitle() {
            return this.f15053a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightConfigData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro flightListData = new FlightListData();
                        codedInputStreamMicro.readMessage(flightListData);
                        addData(flightListData);
                        continue;
                    case 26:
                        setShortTitle(codedInputStreamMicro.readString());
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

        public FlightConfigData setData(int i, FlightListData flightListData) {
            if (flightListData != null) {
                this.f15055c.set(i, flightListData);
            }
            return this;
        }

        public FlightConfigData setShortTitle(String str) {
            this.f15056d = true;
            this.f15057e = str;
            return this;
        }

        public FlightConfigData setTitle(String str) {
            this.f15053a = true;
            this.f15054b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            for (FlightListData writeMessage : getDataList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasShortTitle()) {
                codedOutputStreamMicro.writeString(3, getShortTitle());
            }
        }
    }

    public static final class FlightConfigDataDetail extends MessageMicro {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int SHORT_TITLE_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15059a;
        /* renamed from: b */
        private String f15060b = "";
        /* renamed from: c */
        private List<FlightListData> f15061c = Collections.emptyList();
        /* renamed from: d */
        private boolean f15062d;
        /* renamed from: e */
        private String f15063e = "";
        /* renamed from: f */
        private int f15064f = -1;

        public static FlightConfigDataDetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightConfigDataDetail().mergeFrom(codedInputStreamMicro);
        }

        public static FlightConfigDataDetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightConfigDataDetail) new FlightConfigDataDetail().mergeFrom(bArr);
        }

        public FlightConfigDataDetail addData(FlightListData flightListData) {
            if (flightListData != null) {
                if (this.f15061c.isEmpty()) {
                    this.f15061c = new ArrayList();
                }
                this.f15061c.add(flightListData);
            }
            return this;
        }

        public final FlightConfigDataDetail clear() {
            clearTitle();
            clearData();
            clearShortTitle();
            this.f15064f = -1;
            return this;
        }

        public FlightConfigDataDetail clearData() {
            this.f15061c = Collections.emptyList();
            return this;
        }

        public FlightConfigDataDetail clearShortTitle() {
            this.f15062d = false;
            this.f15063e = "";
            return this;
        }

        public FlightConfigDataDetail clearTitle() {
            this.f15059a = false;
            this.f15060b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15064f < 0) {
                getSerializedSize();
            }
            return this.f15064f;
        }

        public FlightListData getData(int i) {
            return (FlightListData) this.f15061c.get(i);
        }

        public int getDataCount() {
            return this.f15061c.size();
        }

        public List<FlightListData> getDataList() {
            return this.f15061c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            int i2 = i;
            for (FlightListData computeMessageSize : getDataList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasShortTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getShortTitle());
            }
            this.f15064f = i2;
            return i2;
        }

        public String getShortTitle() {
            return this.f15063e;
        }

        public String getTitle() {
            return this.f15060b;
        }

        public boolean hasShortTitle() {
            return this.f15062d;
        }

        public boolean hasTitle() {
            return this.f15059a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightConfigDataDetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro flightListData = new FlightListData();
                        codedInputStreamMicro.readMessage(flightListData);
                        addData(flightListData);
                        continue;
                    case 26:
                        setShortTitle(codedInputStreamMicro.readString());
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

        public FlightConfigDataDetail setData(int i, FlightListData flightListData) {
            if (flightListData != null) {
                this.f15061c.set(i, flightListData);
            }
            return this;
        }

        public FlightConfigDataDetail setShortTitle(String str) {
            this.f15062d = true;
            this.f15063e = str;
            return this;
        }

        public FlightConfigDataDetail setTitle(String str) {
            this.f15059a = true;
            this.f15060b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            for (FlightListData writeMessage : getDataList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasShortTitle()) {
                codedOutputStreamMicro.writeString(3, getShortTitle());
            }
        }
    }

    public static final class FlightDetailData extends MessageMicro {
        public static final int AIRLINE_ABBREV_FIELD_NUMBER = 4;
        public static final int AIRLINE_CODE_FIELD_NUMBER = 2;
        public static final int AIRLINE_FIELD_NUMBER = 3;
        public static final int ARRIVAL_AIRPORT_FIELD_NUMBER = 13;
        public static final int ARRIVAL_AIRPORT_NAME_FIELD_NUMBER = 25;
        public static final int ARRIVAL_CITY_NAME_FIELD_NUMBER = 23;
        public static final int ARRIVAL_TERMINAL_FIELD_NUMBER = 14;
        public static final int ARRIVAL_TIME_FIELD_NUMBER = 12;
        public static final int ARRIVAL_TIME_STR_FIELD_NUMBER = 21;
        public static final int DEPART_AIRPORT_FIELD_NUMBER = 10;
        public static final int DEPART_AIRPORT_NAME_FIELD_NUMBER = 24;
        public static final int DEPART_CITY_NAME_FIELD_NUMBER = 22;
        public static final int DEPART_TERMINAL_FIELD_NUMBER = 11;
        public static final int DEPART_TIME_FIELD_NUMBER = 9;
        public static final int DEPART_TIME_STR_FIELD_NUMBER = 20;
        public static final int ECONOMY_CABIN_DISCOUNT_FIELD_NUMBER = 6;
        public static final int ECONOMY_CABIN_PRICE_FIELD_NUMBER = 5;
        public static final int FIRST_CABIN_DISCOUNT_FIELD_NUMBER = 8;
        public static final int FIRST_CABIN_PRICE_FIELD_NUMBER = 7;
        public static final int FLIGHT_NO_FIELD_NUMBER = 1;
        public static final int FLIGHT_SIZE_FIELD_NUMBER = 16;
        public static final int FLIGHT_TYPE_FIELD_NUMBER = 15;
        public static final int IS_SHARE_FIELD_NUMBER = 17;
        public static final int PARTNER_FIELD_NUMBER = 19;
        public static final int TICKET_COUNT_FIELD_NUMBER = 18;
        /* renamed from: A */
        private boolean f15065A;
        /* renamed from: B */
        private String f15066B = "";
        /* renamed from: C */
        private boolean f15067C;
        /* renamed from: D */
        private String f15068D = "";
        /* renamed from: E */
        private boolean f15069E;
        /* renamed from: F */
        private String f15070F = "";
        /* renamed from: G */
        private boolean f15071G;
        /* renamed from: H */
        private boolean f15072H = false;
        /* renamed from: I */
        private boolean f15073I;
        /* renamed from: J */
        private int f15074J = 0;
        /* renamed from: K */
        private boolean f15075K;
        /* renamed from: L */
        private int f15076L = 0;
        /* renamed from: M */
        private boolean f15077M;
        /* renamed from: N */
        private String f15078N = "";
        /* renamed from: O */
        private boolean f15079O;
        /* renamed from: P */
        private String f15080P = "";
        /* renamed from: Q */
        private boolean f15081Q;
        /* renamed from: R */
        private String f15082R = "";
        /* renamed from: S */
        private boolean f15083S;
        /* renamed from: T */
        private String f15084T = "";
        /* renamed from: U */
        private boolean f15085U;
        /* renamed from: V */
        private String f15086V = "";
        /* renamed from: W */
        private boolean f15087W;
        /* renamed from: X */
        private String f15088X = "";
        /* renamed from: Y */
        private int f15089Y = -1;
        /* renamed from: a */
        private boolean f15090a;
        /* renamed from: b */
        private String f15091b = "";
        /* renamed from: c */
        private boolean f15092c;
        /* renamed from: d */
        private String f15093d = "";
        /* renamed from: e */
        private boolean f15094e;
        /* renamed from: f */
        private String f15095f = "";
        /* renamed from: g */
        private boolean f15096g;
        /* renamed from: h */
        private String f15097h = "";
        /* renamed from: i */
        private boolean f15098i;
        /* renamed from: j */
        private long f15099j = 0;
        /* renamed from: k */
        private boolean f15100k;
        /* renamed from: l */
        private float f15101l = 0.0f;
        /* renamed from: m */
        private boolean f15102m;
        /* renamed from: n */
        private float f15103n = 0.0f;
        /* renamed from: o */
        private boolean f15104o;
        /* renamed from: p */
        private float f15105p = 0.0f;
        /* renamed from: q */
        private boolean f15106q;
        /* renamed from: r */
        private long f15107r = 0;
        /* renamed from: s */
        private boolean f15108s;
        /* renamed from: t */
        private String f15109t = "";
        /* renamed from: u */
        private boolean f15110u;
        /* renamed from: v */
        private String f15111v = "";
        /* renamed from: w */
        private boolean f15112w;
        /* renamed from: x */
        private long f15113x = 0;
        /* renamed from: y */
        private boolean f15114y;
        /* renamed from: z */
        private String f15115z = "";

        public static FlightDetailData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightDetailData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightDetailData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightDetailData) new FlightDetailData().mergeFrom(bArr);
        }

        public final FlightDetailData clear() {
            clearFlightNo();
            clearAirlineCode();
            clearAirline();
            clearAirlineAbbrev();
            clearEconomyCabinPrice();
            clearEconomyCabinDiscount();
            clearFirstCabinPrice();
            clearFirstCabinDiscount();
            clearDepartTime();
            clearDepartAirport();
            clearDepartTerminal();
            clearArrivalTime();
            clearArrivalAirport();
            clearArrivalTerminal();
            clearFlightType();
            clearFlightSize();
            clearIsShare();
            clearTicketCount();
            clearPartner();
            clearDepartTimeStr();
            clearArrivalTimeStr();
            clearDepartCityName();
            clearArrivalCityName();
            clearDepartAirportName();
            clearArrivalAirportName();
            this.f15089Y = -1;
            return this;
        }

        public FlightDetailData clearAirline() {
            this.f15094e = false;
            this.f15095f = "";
            return this;
        }

        public FlightDetailData clearAirlineAbbrev() {
            this.f15096g = false;
            this.f15097h = "";
            return this;
        }

        public FlightDetailData clearAirlineCode() {
            this.f15092c = false;
            this.f15093d = "";
            return this;
        }

        public FlightDetailData clearArrivalAirport() {
            this.f15114y = false;
            this.f15115z = "";
            return this;
        }

        public FlightDetailData clearArrivalAirportName() {
            this.f15087W = false;
            this.f15088X = "";
            return this;
        }

        public FlightDetailData clearArrivalCityName() {
            this.f15083S = false;
            this.f15084T = "";
            return this;
        }

        public FlightDetailData clearArrivalTerminal() {
            this.f15065A = false;
            this.f15066B = "";
            return this;
        }

        public FlightDetailData clearArrivalTime() {
            this.f15112w = false;
            this.f15113x = 0;
            return this;
        }

        public FlightDetailData clearArrivalTimeStr() {
            this.f15079O = false;
            this.f15080P = "";
            return this;
        }

        public FlightDetailData clearDepartAirport() {
            this.f15108s = false;
            this.f15109t = "";
            return this;
        }

        public FlightDetailData clearDepartAirportName() {
            this.f15085U = false;
            this.f15086V = "";
            return this;
        }

        public FlightDetailData clearDepartCityName() {
            this.f15081Q = false;
            this.f15082R = "";
            return this;
        }

        public FlightDetailData clearDepartTerminal() {
            this.f15110u = false;
            this.f15111v = "";
            return this;
        }

        public FlightDetailData clearDepartTime() {
            this.f15106q = false;
            this.f15107r = 0;
            return this;
        }

        public FlightDetailData clearDepartTimeStr() {
            this.f15077M = false;
            this.f15078N = "";
            return this;
        }

        public FlightDetailData clearEconomyCabinDiscount() {
            this.f15100k = false;
            this.f15101l = 0.0f;
            return this;
        }

        public FlightDetailData clearEconomyCabinPrice() {
            this.f15098i = false;
            this.f15099j = 0;
            return this;
        }

        public FlightDetailData clearFirstCabinDiscount() {
            this.f15104o = false;
            this.f15105p = 0.0f;
            return this;
        }

        public FlightDetailData clearFirstCabinPrice() {
            this.f15102m = false;
            this.f15103n = 0.0f;
            return this;
        }

        public FlightDetailData clearFlightNo() {
            this.f15090a = false;
            this.f15091b = "";
            return this;
        }

        public FlightDetailData clearFlightSize() {
            this.f15069E = false;
            this.f15070F = "";
            return this;
        }

        public FlightDetailData clearFlightType() {
            this.f15067C = false;
            this.f15068D = "";
            return this;
        }

        public FlightDetailData clearIsShare() {
            this.f15071G = false;
            this.f15072H = false;
            return this;
        }

        public FlightDetailData clearPartner() {
            this.f15075K = false;
            this.f15076L = 0;
            return this;
        }

        public FlightDetailData clearTicketCount() {
            this.f15073I = false;
            this.f15074J = 0;
            return this;
        }

        public String getAirline() {
            return this.f15095f;
        }

        public String getAirlineAbbrev() {
            return this.f15097h;
        }

        public String getAirlineCode() {
            return this.f15093d;
        }

        public String getArrivalAirport() {
            return this.f15115z;
        }

        public String getArrivalAirportName() {
            return this.f15088X;
        }

        public String getArrivalCityName() {
            return this.f15084T;
        }

        public String getArrivalTerminal() {
            return this.f15066B;
        }

        public long getArrivalTime() {
            return this.f15113x;
        }

        public String getArrivalTimeStr() {
            return this.f15080P;
        }

        public int getCachedSize() {
            if (this.f15089Y < 0) {
                getSerializedSize();
            }
            return this.f15089Y;
        }

        public String getDepartAirport() {
            return this.f15109t;
        }

        public String getDepartAirportName() {
            return this.f15086V;
        }

        public String getDepartCityName() {
            return this.f15082R;
        }

        public String getDepartTerminal() {
            return this.f15111v;
        }

        public long getDepartTime() {
            return this.f15107r;
        }

        public String getDepartTimeStr() {
            return this.f15078N;
        }

        public float getEconomyCabinDiscount() {
            return this.f15101l;
        }

        public long getEconomyCabinPrice() {
            return this.f15099j;
        }

        public float getFirstCabinDiscount() {
            return this.f15105p;
        }

        public float getFirstCabinPrice() {
            return this.f15103n;
        }

        public String getFlightNo() {
            return this.f15091b;
        }

        public String getFlightSize() {
            return this.f15070F;
        }

        public String getFlightType() {
            return this.f15068D;
        }

        public boolean getIsShare() {
            return this.f15072H;
        }

        public int getPartner() {
            return this.f15076L;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFlightNo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
            }
            if (hasAirlineCode()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getAirlineCode());
            }
            if (hasAirline()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getAirline());
            }
            if (hasAirlineAbbrev()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getAirlineAbbrev());
            }
            if (hasEconomyCabinPrice()) {
                i += CodedOutputStreamMicro.computeInt64Size(5, getEconomyCabinPrice());
            }
            if (hasEconomyCabinDiscount()) {
                i += CodedOutputStreamMicro.computeFloatSize(6, getEconomyCabinDiscount());
            }
            if (hasFirstCabinPrice()) {
                i += CodedOutputStreamMicro.computeFloatSize(7, getFirstCabinPrice());
            }
            if (hasFirstCabinDiscount()) {
                i += CodedOutputStreamMicro.computeFloatSize(8, getFirstCabinDiscount());
            }
            if (hasDepartTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(9, getDepartTime());
            }
            if (hasDepartAirport()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getDepartAirport());
            }
            if (hasDepartTerminal()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getDepartTerminal());
            }
            if (hasArrivalTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(12, getArrivalTime());
            }
            if (hasArrivalAirport()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getArrivalAirport());
            }
            if (hasArrivalTerminal()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getArrivalTerminal());
            }
            if (hasFlightType()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getFlightType());
            }
            if (hasFlightSize()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getFlightSize());
            }
            if (hasIsShare()) {
                i += CodedOutputStreamMicro.computeBoolSize(17, getIsShare());
            }
            if (hasTicketCount()) {
                i += CodedOutputStreamMicro.computeInt32Size(18, getTicketCount());
            }
            if (hasPartner()) {
                i += CodedOutputStreamMicro.computeInt32Size(19, getPartner());
            }
            if (hasDepartTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getDepartTimeStr());
            }
            if (hasArrivalTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(21, getArrivalTimeStr());
            }
            if (hasDepartCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(22, getDepartCityName());
            }
            if (hasArrivalCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(23, getArrivalCityName());
            }
            if (hasDepartAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(24, getDepartAirportName());
            }
            if (hasArrivalAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(25, getArrivalAirportName());
            }
            this.f15089Y = i;
            return i;
        }

        public int getTicketCount() {
            return this.f15074J;
        }

        public boolean hasAirline() {
            return this.f15094e;
        }

        public boolean hasAirlineAbbrev() {
            return this.f15096g;
        }

        public boolean hasAirlineCode() {
            return this.f15092c;
        }

        public boolean hasArrivalAirport() {
            return this.f15114y;
        }

        public boolean hasArrivalAirportName() {
            return this.f15087W;
        }

        public boolean hasArrivalCityName() {
            return this.f15083S;
        }

        public boolean hasArrivalTerminal() {
            return this.f15065A;
        }

        public boolean hasArrivalTime() {
            return this.f15112w;
        }

        public boolean hasArrivalTimeStr() {
            return this.f15079O;
        }

        public boolean hasDepartAirport() {
            return this.f15108s;
        }

        public boolean hasDepartAirportName() {
            return this.f15085U;
        }

        public boolean hasDepartCityName() {
            return this.f15081Q;
        }

        public boolean hasDepartTerminal() {
            return this.f15110u;
        }

        public boolean hasDepartTime() {
            return this.f15106q;
        }

        public boolean hasDepartTimeStr() {
            return this.f15077M;
        }

        public boolean hasEconomyCabinDiscount() {
            return this.f15100k;
        }

        public boolean hasEconomyCabinPrice() {
            return this.f15098i;
        }

        public boolean hasFirstCabinDiscount() {
            return this.f15104o;
        }

        public boolean hasFirstCabinPrice() {
            return this.f15102m;
        }

        public boolean hasFlightNo() {
            return this.f15090a;
        }

        public boolean hasFlightSize() {
            return this.f15069E;
        }

        public boolean hasFlightType() {
            return this.f15067C;
        }

        public boolean hasIsShare() {
            return this.f15071G;
        }

        public boolean hasPartner() {
            return this.f15075K;
        }

        public boolean hasTicketCount() {
            return this.f15073I;
        }

        public final boolean isInitialized() {
            return this.f15090a && this.f15092c && this.f15094e && this.f15096g && this.f15098i && this.f15100k && this.f15102m && this.f15104o && this.f15106q && this.f15108s && this.f15110u && this.f15112w && this.f15114y && this.f15065A && this.f15067C && this.f15069E && this.f15071G && this.f15073I && this.f15075K && this.f15077M && this.f15079O && this.f15081Q && this.f15083S && this.f15085U && this.f15087W;
        }

        public FlightDetailData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFlightNo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setAirlineCode(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setAirline(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setAirlineAbbrev(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setEconomyCabinPrice(codedInputStreamMicro.readInt64());
                        continue;
                    case 53:
                        setEconomyCabinDiscount(codedInputStreamMicro.readFloat());
                        continue;
                    case 61:
                        setFirstCabinPrice(codedInputStreamMicro.readFloat());
                        continue;
                    case 69:
                        setFirstCabinDiscount(codedInputStreamMicro.readFloat());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setDepartTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 82:
                        setDepartAirport(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setDepartTerminal(codedInputStreamMicro.readString());
                        continue;
                    case 96:
                        setArrivalTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 106:
                        setArrivalAirport(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setArrivalTerminal(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setFlightType(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setFlightSize(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                        setIsShare(codedInputStreamMicro.readBool());
                        continue;
                    case 144:
                        setTicketCount(codedInputStreamMicro.readInt32());
                        continue;
                    case 152:
                        setPartner(codedInputStreamMicro.readInt32());
                        continue;
                    case 162:
                        setDepartTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 170:
                        setArrivalTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 178:
                        setDepartCityName(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        setArrivalCityName(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        setDepartAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 202:
                        setArrivalAirportName(codedInputStreamMicro.readString());
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

        public FlightDetailData setAirline(String str) {
            this.f15094e = true;
            this.f15095f = str;
            return this;
        }

        public FlightDetailData setAirlineAbbrev(String str) {
            this.f15096g = true;
            this.f15097h = str;
            return this;
        }

        public FlightDetailData setAirlineCode(String str) {
            this.f15092c = true;
            this.f15093d = str;
            return this;
        }

        public FlightDetailData setArrivalAirport(String str) {
            this.f15114y = true;
            this.f15115z = str;
            return this;
        }

        public FlightDetailData setArrivalAirportName(String str) {
            this.f15087W = true;
            this.f15088X = str;
            return this;
        }

        public FlightDetailData setArrivalCityName(String str) {
            this.f15083S = true;
            this.f15084T = str;
            return this;
        }

        public FlightDetailData setArrivalTerminal(String str) {
            this.f15065A = true;
            this.f15066B = str;
            return this;
        }

        public FlightDetailData setArrivalTime(long j) {
            this.f15112w = true;
            this.f15113x = j;
            return this;
        }

        public FlightDetailData setArrivalTimeStr(String str) {
            this.f15079O = true;
            this.f15080P = str;
            return this;
        }

        public FlightDetailData setDepartAirport(String str) {
            this.f15108s = true;
            this.f15109t = str;
            return this;
        }

        public FlightDetailData setDepartAirportName(String str) {
            this.f15085U = true;
            this.f15086V = str;
            return this;
        }

        public FlightDetailData setDepartCityName(String str) {
            this.f15081Q = true;
            this.f15082R = str;
            return this;
        }

        public FlightDetailData setDepartTerminal(String str) {
            this.f15110u = true;
            this.f15111v = str;
            return this;
        }

        public FlightDetailData setDepartTime(long j) {
            this.f15106q = true;
            this.f15107r = j;
            return this;
        }

        public FlightDetailData setDepartTimeStr(String str) {
            this.f15077M = true;
            this.f15078N = str;
            return this;
        }

        public FlightDetailData setEconomyCabinDiscount(float f) {
            this.f15100k = true;
            this.f15101l = f;
            return this;
        }

        public FlightDetailData setEconomyCabinPrice(long j) {
            this.f15098i = true;
            this.f15099j = j;
            return this;
        }

        public FlightDetailData setFirstCabinDiscount(float f) {
            this.f15104o = true;
            this.f15105p = f;
            return this;
        }

        public FlightDetailData setFirstCabinPrice(float f) {
            this.f15102m = true;
            this.f15103n = f;
            return this;
        }

        public FlightDetailData setFlightNo(String str) {
            this.f15090a = true;
            this.f15091b = str;
            return this;
        }

        public FlightDetailData setFlightSize(String str) {
            this.f15069E = true;
            this.f15070F = str;
            return this;
        }

        public FlightDetailData setFlightType(String str) {
            this.f15067C = true;
            this.f15068D = str;
            return this;
        }

        public FlightDetailData setIsShare(boolean z) {
            this.f15071G = true;
            this.f15072H = z;
            return this;
        }

        public FlightDetailData setPartner(int i) {
            this.f15075K = true;
            this.f15076L = i;
            return this;
        }

        public FlightDetailData setTicketCount(int i) {
            this.f15073I = true;
            this.f15074J = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFlightNo()) {
                codedOutputStreamMicro.writeString(1, getFlightNo());
            }
            if (hasAirlineCode()) {
                codedOutputStreamMicro.writeString(2, getAirlineCode());
            }
            if (hasAirline()) {
                codedOutputStreamMicro.writeString(3, getAirline());
            }
            if (hasAirlineAbbrev()) {
                codedOutputStreamMicro.writeString(4, getAirlineAbbrev());
            }
            if (hasEconomyCabinPrice()) {
                codedOutputStreamMicro.writeInt64(5, getEconomyCabinPrice());
            }
            if (hasEconomyCabinDiscount()) {
                codedOutputStreamMicro.writeFloat(6, getEconomyCabinDiscount());
            }
            if (hasFirstCabinPrice()) {
                codedOutputStreamMicro.writeFloat(7, getFirstCabinPrice());
            }
            if (hasFirstCabinDiscount()) {
                codedOutputStreamMicro.writeFloat(8, getFirstCabinDiscount());
            }
            if (hasDepartTime()) {
                codedOutputStreamMicro.writeInt64(9, getDepartTime());
            }
            if (hasDepartAirport()) {
                codedOutputStreamMicro.writeString(10, getDepartAirport());
            }
            if (hasDepartTerminal()) {
                codedOutputStreamMicro.writeString(11, getDepartTerminal());
            }
            if (hasArrivalTime()) {
                codedOutputStreamMicro.writeInt64(12, getArrivalTime());
            }
            if (hasArrivalAirport()) {
                codedOutputStreamMicro.writeString(13, getArrivalAirport());
            }
            if (hasArrivalTerminal()) {
                codedOutputStreamMicro.writeString(14, getArrivalTerminal());
            }
            if (hasFlightType()) {
                codedOutputStreamMicro.writeString(15, getFlightType());
            }
            if (hasFlightSize()) {
                codedOutputStreamMicro.writeString(16, getFlightSize());
            }
            if (hasIsShare()) {
                codedOutputStreamMicro.writeBool(17, getIsShare());
            }
            if (hasTicketCount()) {
                codedOutputStreamMicro.writeInt32(18, getTicketCount());
            }
            if (hasPartner()) {
                codedOutputStreamMicro.writeInt32(19, getPartner());
            }
            if (hasDepartTimeStr()) {
                codedOutputStreamMicro.writeString(20, getDepartTimeStr());
            }
            if (hasArrivalTimeStr()) {
                codedOutputStreamMicro.writeString(21, getArrivalTimeStr());
            }
            if (hasDepartCityName()) {
                codedOutputStreamMicro.writeString(22, getDepartCityName());
            }
            if (hasArrivalCityName()) {
                codedOutputStreamMicro.writeString(23, getArrivalCityName());
            }
            if (hasDepartAirportName()) {
                codedOutputStreamMicro.writeString(24, getDepartAirportName());
            }
            if (hasArrivalAirportName()) {
                codedOutputStreamMicro.writeString(25, getArrivalAirportName());
            }
        }
    }

    public static final class FlightListData extends MessageMicro {
        public static final int APS_NAME_FIELD_NUMBER = 1;
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int COUNTRY_ID_FIELD_NUMBER = 20;
        public static final int COUNTRY_NAME_FIELD_NUMBER = 4;
        public static final int DATA_VER_FIELD_NUMBER = 19;
        public static final int ENAME_FIELD_NUMBER = 6;
        public static final int ERROR_NO_FIELD_NUMBER = 22;
        public static final int FLAG_FIELD_NUMBER = 18;
        public static final int HOT_FLAG1_FIELD_NUMBER = 24;
        public static final int HOT_FLAG_FIELD_NUMBER = 12;
        public static final int ID_FIELD_NUMBER = 16;
        public static final int INITIAL_FIELD_NUMBER = 10;
        public static final int IS_ANCHOR_FIELD_NUMBER = 11;
        public static final int IS_DOMESTIC_FIELD_NUMBER = 25;
        public static final int IS_INTERNATIONAL_FIELD_NUMBER = 26;
        public static final int JP_FIELD_NUMBER = 9;
        public static final int KEY_FIELD_NUMBER = 15;
        public static final int LAT_FIELD_NUMBER = 14;
        public static final int LON_FIELD_NUMBER = 13;
        public static final int NAME_FIELD_NUMBER = 8;
        public static final int OPR_FIELD_NUMBER = 17;
        public static final int PORT_CODE_FIELD_NUMBER = 7;
        public static final int PORT_NAME_FIELD_NUMBER = 5;
        public static final int PY_FIELD_NUMBER = 3;
        public static final int TOTAL_NAME_FIELD_NUMBER = 23;
        public static final int WEIGHT_FIELD_NUMBER = 21;
        /* renamed from: A */
        private boolean f15116A;
        /* renamed from: B */
        private float f15117B = 0.0f;
        /* renamed from: C */
        private boolean f15118C;
        /* renamed from: D */
        private int f15119D = 0;
        /* renamed from: E */
        private boolean f15120E;
        /* renamed from: F */
        private int f15121F = 0;
        /* renamed from: G */
        private boolean f15122G;
        /* renamed from: H */
        private int f15123H = 0;
        /* renamed from: I */
        private boolean f15124I;
        /* renamed from: J */
        private int f15125J = 0;
        /* renamed from: K */
        private boolean f15126K;
        /* renamed from: L */
        private int f15127L = 0;
        /* renamed from: M */
        private boolean f15128M;
        /* renamed from: N */
        private int f15129N = 0;
        /* renamed from: O */
        private boolean f15130O;
        /* renamed from: P */
        private int f15131P = 0;
        /* renamed from: Q */
        private boolean f15132Q;
        /* renamed from: R */
        private int f15133R = 0;
        /* renamed from: S */
        private boolean f15134S;
        /* renamed from: T */
        private String f15135T = "";
        /* renamed from: U */
        private boolean f15136U;
        /* renamed from: V */
        private float f15137V = 0.0f;
        /* renamed from: W */
        private boolean f15138W;
        /* renamed from: X */
        private int f15139X = 0;
        /* renamed from: Y */
        private boolean f15140Y;
        /* renamed from: Z */
        private int f15141Z = 0;
        /* renamed from: a */
        private boolean f15142a;
        private int aa = -1;
        /* renamed from: b */
        private String f15143b = "";
        /* renamed from: c */
        private boolean f15144c;
        /* renamed from: d */
        private String f15145d = "";
        /* renamed from: e */
        private boolean f15146e;
        /* renamed from: f */
        private String f15147f = "";
        /* renamed from: g */
        private boolean f15148g;
        /* renamed from: h */
        private String f15149h = "";
        /* renamed from: i */
        private boolean f15150i;
        /* renamed from: j */
        private String f15151j = "";
        /* renamed from: k */
        private boolean f15152k;
        /* renamed from: l */
        private String f15153l = "";
        /* renamed from: m */
        private boolean f15154m;
        /* renamed from: n */
        private String f15155n = "";
        /* renamed from: o */
        private boolean f15156o;
        /* renamed from: p */
        private String f15157p = "";
        /* renamed from: q */
        private boolean f15158q;
        /* renamed from: r */
        private String f15159r = "";
        /* renamed from: s */
        private boolean f15160s;
        /* renamed from: t */
        private String f15161t = "";
        /* renamed from: u */
        private boolean f15162u;
        /* renamed from: v */
        private boolean f15163v = false;
        /* renamed from: w */
        private boolean f15164w;
        /* renamed from: x */
        private float f15165x = 0.0f;
        /* renamed from: y */
        private boolean f15166y;
        /* renamed from: z */
        private float f15167z = 0.0f;

        public static FlightListData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightListData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightListData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightListData) new FlightListData().mergeFrom(bArr);
        }

        public final FlightListData clear() {
            clearApsName();
            clearCode();
            clearPy();
            clearCountryName();
            clearPortName();
            clearEname();
            clearPortCode();
            clearName();
            clearJp();
            clearInitial();
            clearIsAnchor();
            clearHotFlag();
            clearLon();
            clearLat();
            clearKey();
            clearId();
            clearOpr();
            clearFlag();
            clearDataVer();
            clearCountryId();
            clearWeight();
            clearErrorNo();
            clearTotalName();
            clearHotFlag1();
            clearIsDomestic();
            clearIsInternational();
            this.aa = -1;
            return this;
        }

        public FlightListData clearApsName() {
            this.f15142a = false;
            this.f15143b = "";
            return this;
        }

        public FlightListData clearCode() {
            this.f15144c = false;
            this.f15145d = "";
            return this;
        }

        public FlightListData clearCountryId() {
            this.f15128M = false;
            this.f15129N = 0;
            return this;
        }

        public FlightListData clearCountryName() {
            this.f15148g = false;
            this.f15149h = "";
            return this;
        }

        public FlightListData clearDataVer() {
            this.f15126K = false;
            this.f15127L = 0;
            return this;
        }

        public FlightListData clearEname() {
            this.f15152k = false;
            this.f15153l = "";
            return this;
        }

        public FlightListData clearErrorNo() {
            this.f15132Q = false;
            this.f15133R = 0;
            return this;
        }

        public FlightListData clearFlag() {
            this.f15124I = false;
            this.f15125J = 0;
            return this;
        }

        public FlightListData clearHotFlag() {
            this.f15164w = false;
            this.f15165x = 0.0f;
            return this;
        }

        public FlightListData clearHotFlag1() {
            this.f15136U = false;
            this.f15137V = 0.0f;
            return this;
        }

        public FlightListData clearId() {
            this.f15120E = false;
            this.f15121F = 0;
            return this;
        }

        public FlightListData clearInitial() {
            this.f15160s = false;
            this.f15161t = "";
            return this;
        }

        public FlightListData clearIsAnchor() {
            this.f15162u = false;
            this.f15163v = false;
            return this;
        }

        public FlightListData clearIsDomestic() {
            this.f15138W = false;
            this.f15139X = 0;
            return this;
        }

        public FlightListData clearIsInternational() {
            this.f15140Y = false;
            this.f15141Z = 0;
            return this;
        }

        public FlightListData clearJp() {
            this.f15158q = false;
            this.f15159r = "";
            return this;
        }

        public FlightListData clearKey() {
            this.f15118C = false;
            this.f15119D = 0;
            return this;
        }

        public FlightListData clearLat() {
            this.f15116A = false;
            this.f15117B = 0.0f;
            return this;
        }

        public FlightListData clearLon() {
            this.f15166y = false;
            this.f15167z = 0.0f;
            return this;
        }

        public FlightListData clearName() {
            this.f15156o = false;
            this.f15157p = "";
            return this;
        }

        public FlightListData clearOpr() {
            this.f15122G = false;
            this.f15123H = 0;
            return this;
        }

        public FlightListData clearPortCode() {
            this.f15154m = false;
            this.f15155n = "";
            return this;
        }

        public FlightListData clearPortName() {
            this.f15150i = false;
            this.f15151j = "";
            return this;
        }

        public FlightListData clearPy() {
            this.f15146e = false;
            this.f15147f = "";
            return this;
        }

        public FlightListData clearTotalName() {
            this.f15134S = false;
            this.f15135T = "";
            return this;
        }

        public FlightListData clearWeight() {
            this.f15130O = false;
            this.f15131P = 0;
            return this;
        }

        public String getApsName() {
            return this.f15143b;
        }

        public int getCachedSize() {
            if (this.aa < 0) {
                getSerializedSize();
            }
            return this.aa;
        }

        public String getCode() {
            return this.f15145d;
        }

        public int getCountryId() {
            return this.f15129N;
        }

        public String getCountryName() {
            return this.f15149h;
        }

        public int getDataVer() {
            return this.f15127L;
        }

        public String getEname() {
            return this.f15153l;
        }

        public int getErrorNo() {
            return this.f15133R;
        }

        public int getFlag() {
            return this.f15125J;
        }

        public float getHotFlag() {
            return this.f15165x;
        }

        public float getHotFlag1() {
            return this.f15137V;
        }

        public int getId() {
            return this.f15121F;
        }

        public String getInitial() {
            return this.f15161t;
        }

        public boolean getIsAnchor() {
            return this.f15163v;
        }

        public int getIsDomestic() {
            return this.f15139X;
        }

        public int getIsInternational() {
            return this.f15141Z;
        }

        public String getJp() {
            return this.f15159r;
        }

        public int getKey() {
            return this.f15119D;
        }

        public float getLat() {
            return this.f15117B;
        }

        public float getLon() {
            return this.f15167z;
        }

        public String getName() {
            return this.f15157p;
        }

        public int getOpr() {
            return this.f15123H;
        }

        public String getPortCode() {
            return this.f15155n;
        }

        public String getPortName() {
            return this.f15151j;
        }

        public String getPy() {
            return this.f15147f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasApsName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getApsName());
            }
            if (hasCode()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getCode());
            }
            if (hasPy()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getPy());
            }
            if (hasCountryName()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getCountryName());
            }
            if (hasPortName()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getPortName());
            }
            if (hasEname()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getEname());
            }
            if (hasPortCode()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getPortCode());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getName());
            }
            if (hasJp()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getJp());
            }
            if (hasInitial()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getInitial());
            }
            if (hasIsAnchor()) {
                i += CodedOutputStreamMicro.computeBoolSize(11, getIsAnchor());
            }
            if (hasHotFlag()) {
                i += CodedOutputStreamMicro.computeFloatSize(12, getHotFlag());
            }
            if (hasLon()) {
                i += CodedOutputStreamMicro.computeFloatSize(13, getLon());
            }
            if (hasLat()) {
                i += CodedOutputStreamMicro.computeFloatSize(14, getLat());
            }
            if (hasKey()) {
                i += CodedOutputStreamMicro.computeInt32Size(15, getKey());
            }
            if (hasId()) {
                i += CodedOutputStreamMicro.computeInt32Size(16, getId());
            }
            if (hasOpr()) {
                i += CodedOutputStreamMicro.computeInt32Size(17, getOpr());
            }
            if (hasFlag()) {
                i += CodedOutputStreamMicro.computeInt32Size(18, getFlag());
            }
            if (hasDataVer()) {
                i += CodedOutputStreamMicro.computeInt32Size(19, getDataVer());
            }
            if (hasCountryId()) {
                i += CodedOutputStreamMicro.computeInt32Size(20, getCountryId());
            }
            if (hasWeight()) {
                i += CodedOutputStreamMicro.computeInt32Size(21, getWeight());
            }
            if (hasErrorNo()) {
                i += CodedOutputStreamMicro.computeInt32Size(22, getErrorNo());
            }
            if (hasTotalName()) {
                i += CodedOutputStreamMicro.computeStringSize(23, getTotalName());
            }
            if (hasHotFlag1()) {
                i += CodedOutputStreamMicro.computeFloatSize(24, getHotFlag1());
            }
            if (hasIsDomestic()) {
                i += CodedOutputStreamMicro.computeInt32Size(25, getIsDomestic());
            }
            if (hasIsInternational()) {
                i += CodedOutputStreamMicro.computeInt32Size(26, getIsInternational());
            }
            this.aa = i;
            return i;
        }

        public String getTotalName() {
            return this.f15135T;
        }

        public int getWeight() {
            return this.f15131P;
        }

        public boolean hasApsName() {
            return this.f15142a;
        }

        public boolean hasCode() {
            return this.f15144c;
        }

        public boolean hasCountryId() {
            return this.f15128M;
        }

        public boolean hasCountryName() {
            return this.f15148g;
        }

        public boolean hasDataVer() {
            return this.f15126K;
        }

        public boolean hasEname() {
            return this.f15152k;
        }

        public boolean hasErrorNo() {
            return this.f15132Q;
        }

        public boolean hasFlag() {
            return this.f15124I;
        }

        public boolean hasHotFlag() {
            return this.f15164w;
        }

        public boolean hasHotFlag1() {
            return this.f15136U;
        }

        public boolean hasId() {
            return this.f15120E;
        }

        public boolean hasInitial() {
            return this.f15160s;
        }

        public boolean hasIsAnchor() {
            return this.f15162u;
        }

        public boolean hasIsDomestic() {
            return this.f15138W;
        }

        public boolean hasIsInternational() {
            return this.f15140Y;
        }

        public boolean hasJp() {
            return this.f15158q;
        }

        public boolean hasKey() {
            return this.f15118C;
        }

        public boolean hasLat() {
            return this.f15116A;
        }

        public boolean hasLon() {
            return this.f15166y;
        }

        public boolean hasName() {
            return this.f15156o;
        }

        public boolean hasOpr() {
            return this.f15122G;
        }

        public boolean hasPortCode() {
            return this.f15154m;
        }

        public boolean hasPortName() {
            return this.f15150i;
        }

        public boolean hasPy() {
            return this.f15146e;
        }

        public boolean hasTotalName() {
            return this.f15134S;
        }

        public boolean hasWeight() {
            return this.f15130O;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightListData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setApsName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setCode(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setPy(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setCountryName(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setPortName(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setEname(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setPortCode(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setJp(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setInitial(codedInputStreamMicro.readString());
                        continue;
                    case 88:
                        setIsAnchor(codedInputStreamMicro.readBool());
                        continue;
                    case 101:
                        setHotFlag(codedInputStreamMicro.readFloat());
                        continue;
                    case 109:
                        setLon(codedInputStreamMicro.readFloat());
                        continue;
                    case MessageType.BNMessageTypeCarFreeStatus /*117*/:
                        setLat(codedInputStreamMicro.readFloat());
                        continue;
                    case 120:
                        setKey(codedInputStreamMicro.readInt32());
                        continue;
                    case 128:
                        setId(codedInputStreamMicro.readInt32());
                        continue;
                    case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                        setOpr(codedInputStreamMicro.readInt32());
                        continue;
                    case 144:
                        setFlag(codedInputStreamMicro.readInt32());
                        continue;
                    case 152:
                        setDataVer(codedInputStreamMicro.readInt32());
                        continue;
                    case 160:
                        setCountryId(codedInputStreamMicro.readInt32());
                        continue;
                    case 168:
                        setWeight(codedInputStreamMicro.readInt32());
                        continue;
                    case 176:
                        setErrorNo(codedInputStreamMicro.readInt32());
                        continue;
                    case 186:
                        setTotalName(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_GREY /*197*/:
                        setHotFlag1(codedInputStreamMicro.readFloat());
                        continue;
                    case 200:
                        setIsDomestic(codedInputStreamMicro.readInt32());
                        continue;
                    case 208:
                        setIsInternational(codedInputStreamMicro.readInt32());
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

        public FlightListData setApsName(String str) {
            this.f15142a = true;
            this.f15143b = str;
            return this;
        }

        public FlightListData setCode(String str) {
            this.f15144c = true;
            this.f15145d = str;
            return this;
        }

        public FlightListData setCountryId(int i) {
            this.f15128M = true;
            this.f15129N = i;
            return this;
        }

        public FlightListData setCountryName(String str) {
            this.f15148g = true;
            this.f15149h = str;
            return this;
        }

        public FlightListData setDataVer(int i) {
            this.f15126K = true;
            this.f15127L = i;
            return this;
        }

        public FlightListData setEname(String str) {
            this.f15152k = true;
            this.f15153l = str;
            return this;
        }

        public FlightListData setErrorNo(int i) {
            this.f15132Q = true;
            this.f15133R = i;
            return this;
        }

        public FlightListData setFlag(int i) {
            this.f15124I = true;
            this.f15125J = i;
            return this;
        }

        public FlightListData setHotFlag(float f) {
            this.f15164w = true;
            this.f15165x = f;
            return this;
        }

        public FlightListData setHotFlag1(float f) {
            this.f15136U = true;
            this.f15137V = f;
            return this;
        }

        public FlightListData setId(int i) {
            this.f15120E = true;
            this.f15121F = i;
            return this;
        }

        public FlightListData setInitial(String str) {
            this.f15160s = true;
            this.f15161t = str;
            return this;
        }

        public FlightListData setIsAnchor(boolean z) {
            this.f15162u = true;
            this.f15163v = z;
            return this;
        }

        public FlightListData setIsDomestic(int i) {
            this.f15138W = true;
            this.f15139X = i;
            return this;
        }

        public FlightListData setIsInternational(int i) {
            this.f15140Y = true;
            this.f15141Z = i;
            return this;
        }

        public FlightListData setJp(String str) {
            this.f15158q = true;
            this.f15159r = str;
            return this;
        }

        public FlightListData setKey(int i) {
            this.f15118C = true;
            this.f15119D = i;
            return this;
        }

        public FlightListData setLat(float f) {
            this.f15116A = true;
            this.f15117B = f;
            return this;
        }

        public FlightListData setLon(float f) {
            this.f15166y = true;
            this.f15167z = f;
            return this;
        }

        public FlightListData setName(String str) {
            this.f15156o = true;
            this.f15157p = str;
            return this;
        }

        public FlightListData setOpr(int i) {
            this.f15122G = true;
            this.f15123H = i;
            return this;
        }

        public FlightListData setPortCode(String str) {
            this.f15154m = true;
            this.f15155n = str;
            return this;
        }

        public FlightListData setPortName(String str) {
            this.f15150i = true;
            this.f15151j = str;
            return this;
        }

        public FlightListData setPy(String str) {
            this.f15146e = true;
            this.f15147f = str;
            return this;
        }

        public FlightListData setTotalName(String str) {
            this.f15134S = true;
            this.f15135T = str;
            return this;
        }

        public FlightListData setWeight(int i) {
            this.f15130O = true;
            this.f15131P = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasApsName()) {
                codedOutputStreamMicro.writeString(1, getApsName());
            }
            if (hasCode()) {
                codedOutputStreamMicro.writeString(2, getCode());
            }
            if (hasPy()) {
                codedOutputStreamMicro.writeString(3, getPy());
            }
            if (hasCountryName()) {
                codedOutputStreamMicro.writeString(4, getCountryName());
            }
            if (hasPortName()) {
                codedOutputStreamMicro.writeString(5, getPortName());
            }
            if (hasEname()) {
                codedOutputStreamMicro.writeString(6, getEname());
            }
            if (hasPortCode()) {
                codedOutputStreamMicro.writeString(7, getPortCode());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(8, getName());
            }
            if (hasJp()) {
                codedOutputStreamMicro.writeString(9, getJp());
            }
            if (hasInitial()) {
                codedOutputStreamMicro.writeString(10, getInitial());
            }
            if (hasIsAnchor()) {
                codedOutputStreamMicro.writeBool(11, getIsAnchor());
            }
            if (hasHotFlag()) {
                codedOutputStreamMicro.writeFloat(12, getHotFlag());
            }
            if (hasLon()) {
                codedOutputStreamMicro.writeFloat(13, getLon());
            }
            if (hasLat()) {
                codedOutputStreamMicro.writeFloat(14, getLat());
            }
            if (hasKey()) {
                codedOutputStreamMicro.writeInt32(15, getKey());
            }
            if (hasId()) {
                codedOutputStreamMicro.writeInt32(16, getId());
            }
            if (hasOpr()) {
                codedOutputStreamMicro.writeInt32(17, getOpr());
            }
            if (hasFlag()) {
                codedOutputStreamMicro.writeInt32(18, getFlag());
            }
            if (hasDataVer()) {
                codedOutputStreamMicro.writeInt32(19, getDataVer());
            }
            if (hasCountryId()) {
                codedOutputStreamMicro.writeInt32(20, getCountryId());
            }
            if (hasWeight()) {
                codedOutputStreamMicro.writeInt32(21, getWeight());
            }
            if (hasErrorNo()) {
                codedOutputStreamMicro.writeInt32(22, getErrorNo());
            }
            if (hasTotalName()) {
                codedOutputStreamMicro.writeString(23, getTotalName());
            }
            if (hasHotFlag1()) {
                codedOutputStreamMicro.writeFloat(24, getHotFlag1());
            }
            if (hasIsDomestic()) {
                codedOutputStreamMicro.writeInt32(25, getIsDomestic());
            }
            if (hasIsInternational()) {
                codedOutputStreamMicro.writeInt32(26, getIsInternational());
            }
        }
    }

    public static final class FlightNoDetailData extends MessageMicro {
        public static final int AIRLINE_CODE_FIELD_NUMBER = 2;
        public static final int AIRLINE_FIELD_NUMBER = 3;
        public static final int ARRIVAL_AIRPORT_FIELD_NUMBER = 11;
        public static final int ARRIVAL_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 19;
        public static final int ARRIVAL_AIRPORT_NAME_FIELD_NUMBER = 12;
        public static final int ARRIVAL_CITY_CODE_FIELD_NUMBER = 13;
        public static final int ARRIVAL_CITY_NAME_FIELD_NUMBER = 14;
        public static final int ARRIVAL_TERMINAL_FIELD_NUMBER = 15;
        public static final int ARRIVAL_TIME_FIELD_NUMBER = 10;
        public static final int ARRIVAL_TIME_STR_FIELD_NUMBER = 17;
        public static final int BAGGAGE_ID_FIELD_NUMBER = 24;
        public static final int BOARD_GATE_FIELD_NUMBER = 23;
        public static final int CHECKIN_TABLE_FIELD_NUMBER = 21;
        public static final int DEPART_AIRPORT_FIELD_NUMBER = 5;
        public static final int DEPART_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 18;
        public static final int DEPART_AIRPORT_NAME_FIELD_NUMBER = 6;
        public static final int DEPART_CITY_CODE_FIELD_NUMBER = 7;
        public static final int DEPART_CITY_NAME_FIELD_NUMBER = 8;
        public static final int DEPART_TERMINAL_FIELD_NUMBER = 9;
        public static final int DEPART_TIME_FIELD_NUMBER = 4;
        public static final int DEPART_TIME_STR_FIELD_NUMBER = 16;
        public static final int EMTIMATE_ARR_TIME_TITLE_FIELD_NUMBER = 31;
        public static final int ESTIMATE_DEP_TIME_TITLE_FIELD_NUMBER = 30;
        public static final int FCATEGORY_FIELD_NUMBER = 20;
        public static final int FLIGHT_NO_FIELD_NUMBER = 1;
        public static final int FLIGHT_STATE_FIELD_NUMBER = 22;
        public static final int FLIGHT_TIME_CONTENT_FIELD_NUMBER = 33;
        public static final int IS_DELAY_FIELD_NUMBER = 29;
        public static final int PLAN_TIME_CONTENT_FIELD_NUMBER = 32;
        public static final int SHARE_FLIGHTNO_FIELD_NUMBER = 25;
        public static final int SUPPLIED_BY_FIELD_NUMBER = 28;
        public static final int VERY_ZHUN_READY_ARRTIME_DATE_FIELD_NUMBER = 27;
        public static final int VERY_ZHUN_READY_DEPTIME_DATE_FIELD_NUMBER = 26;
        /* renamed from: A */
        private boolean f15168A;
        /* renamed from: B */
        private String f15169B = "";
        /* renamed from: C */
        private boolean f15170C;
        /* renamed from: D */
        private String f15171D = "";
        /* renamed from: E */
        private boolean f15172E;
        /* renamed from: F */
        private String f15173F = "";
        /* renamed from: G */
        private boolean f15174G;
        /* renamed from: H */
        private String f15175H = "";
        /* renamed from: I */
        private boolean f15176I;
        /* renamed from: J */
        private String f15177J = "";
        /* renamed from: K */
        private boolean f15178K;
        /* renamed from: L */
        private String f15179L = "";
        /* renamed from: M */
        private boolean f15180M;
        /* renamed from: N */
        private String f15181N = "";
        /* renamed from: O */
        private boolean f15182O;
        /* renamed from: P */
        private String f15183P = "";
        /* renamed from: Q */
        private boolean f15184Q;
        /* renamed from: R */
        private String f15185R = "";
        /* renamed from: S */
        private boolean f15186S;
        /* renamed from: T */
        private String f15187T = "";
        /* renamed from: U */
        private boolean f15188U;
        /* renamed from: V */
        private String f15189V = "";
        /* renamed from: W */
        private boolean f15190W;
        /* renamed from: X */
        private String f15191X = "";
        /* renamed from: Y */
        private boolean f15192Y;
        /* renamed from: Z */
        private String f15193Z = "";
        /* renamed from: a */
        private boolean f15194a;
        private boolean aa;
        private String ab = "";
        private boolean ac;
        private String ad = "";
        private boolean ae;
        private int af = 0;
        private boolean ag;
        private String ah = "";
        private boolean ai;
        private String aj = "";
        private boolean ak;
        private String al = "";
        private List<FlightTimeContent> am = Collections.emptyList();
        private int an = -1;
        /* renamed from: b */
        private String f15195b = "";
        /* renamed from: c */
        private boolean f15196c;
        /* renamed from: d */
        private String f15197d = "";
        /* renamed from: e */
        private boolean f15198e;
        /* renamed from: f */
        private String f15199f = "";
        /* renamed from: g */
        private boolean f15200g;
        /* renamed from: h */
        private long f15201h = 0;
        /* renamed from: i */
        private boolean f15202i;
        /* renamed from: j */
        private String f15203j = "";
        /* renamed from: k */
        private boolean f15204k;
        /* renamed from: l */
        private String f15205l = "";
        /* renamed from: m */
        private boolean f15206m;
        /* renamed from: n */
        private String f15207n = "";
        /* renamed from: o */
        private boolean f15208o;
        /* renamed from: p */
        private String f15209p = "";
        /* renamed from: q */
        private boolean f15210q;
        /* renamed from: r */
        private String f15211r = "";
        /* renamed from: s */
        private boolean f15212s;
        /* renamed from: t */
        private long f15213t = 0;
        /* renamed from: u */
        private boolean f15214u;
        /* renamed from: v */
        private String f15215v = "";
        /* renamed from: w */
        private boolean f15216w;
        /* renamed from: x */
        private String f15217x = "";
        /* renamed from: y */
        private boolean f15218y;
        /* renamed from: z */
        private String f15219z = "";

        public static FlightNoDetailData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightNoDetailData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightNoDetailData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightNoDetailData) new FlightNoDetailData().mergeFrom(bArr);
        }

        public FlightNoDetailData addFlightTimeContent(FlightTimeContent flightTimeContent) {
            if (flightTimeContent != null) {
                if (this.am.isEmpty()) {
                    this.am = new ArrayList();
                }
                this.am.add(flightTimeContent);
            }
            return this;
        }

        public final FlightNoDetailData clear() {
            clearFlightNo();
            clearAirlineCode();
            clearAirline();
            clearDepartTime();
            clearDepartAirport();
            clearDepartAirportName();
            clearDepartCityCode();
            clearDepartCityName();
            clearDepartTerminal();
            clearArrivalTime();
            clearArrivalAirport();
            clearArrivalAirportName();
            clearArrivalCityCode();
            clearArrivalCityName();
            clearArrivalTerminal();
            clearDepartTimeStr();
            clearArrivalTimeStr();
            clearDepartAirportNameAbbrev();
            clearArrivalAirportNameAbbrev();
            clearFcategory();
            clearCheckinTable();
            clearFlightState();
            clearBoardGate();
            clearBaggageId();
            clearShareFlightNo();
            clearVeryZhunReadyDeptimeDate();
            clearVeryZhunReadyArrtimeDate();
            clearSuppliedBy();
            clearIsDelay();
            clearEstimateDepTimeTitle();
            clearEmtimateArrTimeTitle();
            clearPlanTimeContent();
            clearFlightTimeContent();
            this.an = -1;
            return this;
        }

        public FlightNoDetailData clearAirline() {
            this.f15198e = false;
            this.f15199f = "";
            return this;
        }

        public FlightNoDetailData clearAirlineCode() {
            this.f15196c = false;
            this.f15197d = "";
            return this;
        }

        public FlightNoDetailData clearArrivalAirport() {
            this.f15214u = false;
            this.f15215v = "";
            return this;
        }

        public FlightNoDetailData clearArrivalAirportName() {
            this.f15216w = false;
            this.f15217x = "";
            return this;
        }

        public FlightNoDetailData clearArrivalAirportNameAbbrev() {
            this.f15178K = false;
            this.f15179L = "";
            return this;
        }

        public FlightNoDetailData clearArrivalCityCode() {
            this.f15218y = false;
            this.f15219z = "";
            return this;
        }

        public FlightNoDetailData clearArrivalCityName() {
            this.f15168A = false;
            this.f15169B = "";
            return this;
        }

        public FlightNoDetailData clearArrivalTerminal() {
            this.f15170C = false;
            this.f15171D = "";
            return this;
        }

        public FlightNoDetailData clearArrivalTime() {
            this.f15212s = false;
            this.f15213t = 0;
            return this;
        }

        public FlightNoDetailData clearArrivalTimeStr() {
            this.f15174G = false;
            this.f15175H = "";
            return this;
        }

        public FlightNoDetailData clearBaggageId() {
            this.f15188U = false;
            this.f15189V = "";
            return this;
        }

        public FlightNoDetailData clearBoardGate() {
            this.f15186S = false;
            this.f15187T = "";
            return this;
        }

        public FlightNoDetailData clearCheckinTable() {
            this.f15182O = false;
            this.f15183P = "";
            return this;
        }

        public FlightNoDetailData clearDepartAirport() {
            this.f15202i = false;
            this.f15203j = "";
            return this;
        }

        public FlightNoDetailData clearDepartAirportName() {
            this.f15204k = false;
            this.f15205l = "";
            return this;
        }

        public FlightNoDetailData clearDepartAirportNameAbbrev() {
            this.f15176I = false;
            this.f15177J = "";
            return this;
        }

        public FlightNoDetailData clearDepartCityCode() {
            this.f15206m = false;
            this.f15207n = "";
            return this;
        }

        public FlightNoDetailData clearDepartCityName() {
            this.f15208o = false;
            this.f15209p = "";
            return this;
        }

        public FlightNoDetailData clearDepartTerminal() {
            this.f15210q = false;
            this.f15211r = "";
            return this;
        }

        public FlightNoDetailData clearDepartTime() {
            this.f15200g = false;
            this.f15201h = 0;
            return this;
        }

        public FlightNoDetailData clearDepartTimeStr() {
            this.f15172E = false;
            this.f15173F = "";
            return this;
        }

        public FlightNoDetailData clearEmtimateArrTimeTitle() {
            this.ai = false;
            this.aj = "";
            return this;
        }

        public FlightNoDetailData clearEstimateDepTimeTitle() {
            this.ag = false;
            this.ah = "";
            return this;
        }

        public FlightNoDetailData clearFcategory() {
            this.f15180M = false;
            this.f15181N = "";
            return this;
        }

        public FlightNoDetailData clearFlightNo() {
            this.f15194a = false;
            this.f15195b = "";
            return this;
        }

        public FlightNoDetailData clearFlightState() {
            this.f15184Q = false;
            this.f15185R = "";
            return this;
        }

        public FlightNoDetailData clearFlightTimeContent() {
            this.am = Collections.emptyList();
            return this;
        }

        public FlightNoDetailData clearIsDelay() {
            this.ae = false;
            this.af = 0;
            return this;
        }

        public FlightNoDetailData clearPlanTimeContent() {
            this.ak = false;
            this.al = "";
            return this;
        }

        public FlightNoDetailData clearShareFlightNo() {
            this.f15190W = false;
            this.f15191X = "";
            return this;
        }

        public FlightNoDetailData clearSuppliedBy() {
            this.ac = false;
            this.ad = "";
            return this;
        }

        public FlightNoDetailData clearVeryZhunReadyArrtimeDate() {
            this.aa = false;
            this.ab = "";
            return this;
        }

        public FlightNoDetailData clearVeryZhunReadyDeptimeDate() {
            this.f15192Y = false;
            this.f15193Z = "";
            return this;
        }

        public String getAirline() {
            return this.f15199f;
        }

        public String getAirlineCode() {
            return this.f15197d;
        }

        public String getArrivalAirport() {
            return this.f15215v;
        }

        public String getArrivalAirportName() {
            return this.f15217x;
        }

        public String getArrivalAirportNameAbbrev() {
            return this.f15179L;
        }

        public String getArrivalCityCode() {
            return this.f15219z;
        }

        public String getArrivalCityName() {
            return this.f15169B;
        }

        public String getArrivalTerminal() {
            return this.f15171D;
        }

        public long getArrivalTime() {
            return this.f15213t;
        }

        public String getArrivalTimeStr() {
            return this.f15175H;
        }

        public String getBaggageId() {
            return this.f15189V;
        }

        public String getBoardGate() {
            return this.f15187T;
        }

        public int getCachedSize() {
            if (this.an < 0) {
                getSerializedSize();
            }
            return this.an;
        }

        public String getCheckinTable() {
            return this.f15183P;
        }

        public String getDepartAirport() {
            return this.f15203j;
        }

        public String getDepartAirportName() {
            return this.f15205l;
        }

        public String getDepartAirportNameAbbrev() {
            return this.f15177J;
        }

        public String getDepartCityCode() {
            return this.f15207n;
        }

        public String getDepartCityName() {
            return this.f15209p;
        }

        public String getDepartTerminal() {
            return this.f15211r;
        }

        public long getDepartTime() {
            return this.f15201h;
        }

        public String getDepartTimeStr() {
            return this.f15173F;
        }

        public String getEmtimateArrTimeTitle() {
            return this.aj;
        }

        public String getEstimateDepTimeTitle() {
            return this.ah;
        }

        public String getFcategory() {
            return this.f15181N;
        }

        public String getFlightNo() {
            return this.f15195b;
        }

        public String getFlightState() {
            return this.f15185R;
        }

        public FlightTimeContent getFlightTimeContent(int i) {
            return (FlightTimeContent) this.am.get(i);
        }

        public int getFlightTimeContentCount() {
            return this.am.size();
        }

        public List<FlightTimeContent> getFlightTimeContentList() {
            return this.am;
        }

        public int getIsDelay() {
            return this.af;
        }

        public String getPlanTimeContent() {
            return this.al;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFlightNo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
            }
            if (hasAirlineCode()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getAirlineCode());
            }
            if (hasAirline()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getAirline());
            }
            if (hasDepartTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(4, getDepartTime());
            }
            if (hasDepartAirport()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getDepartAirport());
            }
            if (hasDepartAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDepartAirportName());
            }
            if (hasDepartCityCode()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getDepartCityCode());
            }
            if (hasDepartCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getDepartCityName());
            }
            if (hasDepartTerminal()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getDepartTerminal());
            }
            if (hasArrivalTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(10, getArrivalTime());
            }
            if (hasArrivalAirport()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getArrivalAirport());
            }
            if (hasArrivalAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getArrivalAirportName());
            }
            if (hasArrivalCityCode()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getArrivalCityCode());
            }
            if (hasArrivalCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getArrivalCityName());
            }
            if (hasArrivalTerminal()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getArrivalTerminal());
            }
            if (hasDepartTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getDepartTimeStr());
            }
            if (hasArrivalTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(17, getArrivalTimeStr());
            }
            if (hasDepartAirportNameAbbrev()) {
                i += CodedOutputStreamMicro.computeStringSize(18, getDepartAirportNameAbbrev());
            }
            if (hasArrivalAirportNameAbbrev()) {
                i += CodedOutputStreamMicro.computeStringSize(19, getArrivalAirportNameAbbrev());
            }
            if (hasFcategory()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getFcategory());
            }
            if (hasCheckinTable()) {
                i += CodedOutputStreamMicro.computeStringSize(21, getCheckinTable());
            }
            if (hasFlightState()) {
                i += CodedOutputStreamMicro.computeStringSize(22, getFlightState());
            }
            if (hasBoardGate()) {
                i += CodedOutputStreamMicro.computeStringSize(23, getBoardGate());
            }
            if (hasBaggageId()) {
                i += CodedOutputStreamMicro.computeStringSize(24, getBaggageId());
            }
            if (hasShareFlightNo()) {
                i += CodedOutputStreamMicro.computeStringSize(25, getShareFlightNo());
            }
            if (hasVeryZhunReadyDeptimeDate()) {
                i += CodedOutputStreamMicro.computeStringSize(26, getVeryZhunReadyDeptimeDate());
            }
            if (hasVeryZhunReadyArrtimeDate()) {
                i += CodedOutputStreamMicro.computeStringSize(27, getVeryZhunReadyArrtimeDate());
            }
            if (hasSuppliedBy()) {
                i += CodedOutputStreamMicro.computeStringSize(28, getSuppliedBy());
            }
            if (hasIsDelay()) {
                i += CodedOutputStreamMicro.computeInt32Size(29, getIsDelay());
            }
            if (hasEstimateDepTimeTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(30, getEstimateDepTimeTitle());
            }
            if (hasEmtimateArrTimeTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(31, getEmtimateArrTimeTitle());
            }
            if (hasPlanTimeContent()) {
                i += CodedOutputStreamMicro.computeStringSize(32, getPlanTimeContent());
            }
            int i2 = i;
            for (FlightTimeContent computeMessageSize : getFlightTimeContentList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(33, computeMessageSize) + i2;
            }
            this.an = i2;
            return i2;
        }

        public String getShareFlightNo() {
            return this.f15191X;
        }

        public String getSuppliedBy() {
            return this.ad;
        }

        public String getVeryZhunReadyArrtimeDate() {
            return this.ab;
        }

        public String getVeryZhunReadyDeptimeDate() {
            return this.f15193Z;
        }

        public boolean hasAirline() {
            return this.f15198e;
        }

        public boolean hasAirlineCode() {
            return this.f15196c;
        }

        public boolean hasArrivalAirport() {
            return this.f15214u;
        }

        public boolean hasArrivalAirportName() {
            return this.f15216w;
        }

        public boolean hasArrivalAirportNameAbbrev() {
            return this.f15178K;
        }

        public boolean hasArrivalCityCode() {
            return this.f15218y;
        }

        public boolean hasArrivalCityName() {
            return this.f15168A;
        }

        public boolean hasArrivalTerminal() {
            return this.f15170C;
        }

        public boolean hasArrivalTime() {
            return this.f15212s;
        }

        public boolean hasArrivalTimeStr() {
            return this.f15174G;
        }

        public boolean hasBaggageId() {
            return this.f15188U;
        }

        public boolean hasBoardGate() {
            return this.f15186S;
        }

        public boolean hasCheckinTable() {
            return this.f15182O;
        }

        public boolean hasDepartAirport() {
            return this.f15202i;
        }

        public boolean hasDepartAirportName() {
            return this.f15204k;
        }

        public boolean hasDepartAirportNameAbbrev() {
            return this.f15176I;
        }

        public boolean hasDepartCityCode() {
            return this.f15206m;
        }

        public boolean hasDepartCityName() {
            return this.f15208o;
        }

        public boolean hasDepartTerminal() {
            return this.f15210q;
        }

        public boolean hasDepartTime() {
            return this.f15200g;
        }

        public boolean hasDepartTimeStr() {
            return this.f15172E;
        }

        public boolean hasEmtimateArrTimeTitle() {
            return this.ai;
        }

        public boolean hasEstimateDepTimeTitle() {
            return this.ag;
        }

        public boolean hasFcategory() {
            return this.f15180M;
        }

        public boolean hasFlightNo() {
            return this.f15194a;
        }

        public boolean hasFlightState() {
            return this.f15184Q;
        }

        public boolean hasIsDelay() {
            return this.ae;
        }

        public boolean hasPlanTimeContent() {
            return this.ak;
        }

        public boolean hasShareFlightNo() {
            return this.f15190W;
        }

        public boolean hasSuppliedBy() {
            return this.ac;
        }

        public boolean hasVeryZhunReadyArrtimeDate() {
            return this.aa;
        }

        public boolean hasVeryZhunReadyDeptimeDate() {
            return this.f15192Y;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightNoDetailData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFlightNo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setAirlineCode(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setAirline(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setDepartTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 42:
                        setDepartAirport(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setDepartAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setDepartCityCode(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setDepartCityName(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setDepartTerminal(codedInputStreamMicro.readString());
                        continue;
                    case 80:
                        setArrivalTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 90:
                        setArrivalAirport(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setArrivalAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setArrivalCityCode(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setArrivalCityName(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setArrivalTerminal(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setDepartTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setArrivalTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        setDepartAirportNameAbbrev(codedInputStreamMicro.readString());
                        continue;
                    case 154:
                        setArrivalAirportNameAbbrev(codedInputStreamMicro.readString());
                        continue;
                    case 162:
                        setFcategory(codedInputStreamMicro.readString());
                        continue;
                    case 170:
                        setCheckinTable(codedInputStreamMicro.readString());
                        continue;
                    case 178:
                        setFlightState(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        setBoardGate(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        setBaggageId(codedInputStreamMicro.readString());
                        continue;
                    case 202:
                        setShareFlightNo(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ds /*210*/:
                        setVeryZhunReadyDeptimeDate(codedInputStreamMicro.readString());
                        continue;
                    case 218:
                        setVeryZhunReadyArrtimeDate(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.dG /*226*/:
                        setSuppliedBy(codedInputStreamMicro.readString());
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                        setIsDelay(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.dM /*242*/:
                        setEstimateDepTimeTitle(codedInputStreamMicro.readString());
                        continue;
                    case 250:
                        setEmtimateArrTimeTitle(codedInputStreamMicro.readString());
                        continue;
                    case 258:
                        setPlanTimeContent(codedInputStreamMicro.readString());
                        continue;
                    case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                        MessageMicro flightTimeContent = new FlightTimeContent();
                        codedInputStreamMicro.readMessage(flightTimeContent);
                        addFlightTimeContent(flightTimeContent);
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

        public FlightNoDetailData setAirline(String str) {
            this.f15198e = true;
            this.f15199f = str;
            return this;
        }

        public FlightNoDetailData setAirlineCode(String str) {
            this.f15196c = true;
            this.f15197d = str;
            return this;
        }

        public FlightNoDetailData setArrivalAirport(String str) {
            this.f15214u = true;
            this.f15215v = str;
            return this;
        }

        public FlightNoDetailData setArrivalAirportName(String str) {
            this.f15216w = true;
            this.f15217x = str;
            return this;
        }

        public FlightNoDetailData setArrivalAirportNameAbbrev(String str) {
            this.f15178K = true;
            this.f15179L = str;
            return this;
        }

        public FlightNoDetailData setArrivalCityCode(String str) {
            this.f15218y = true;
            this.f15219z = str;
            return this;
        }

        public FlightNoDetailData setArrivalCityName(String str) {
            this.f15168A = true;
            this.f15169B = str;
            return this;
        }

        public FlightNoDetailData setArrivalTerminal(String str) {
            this.f15170C = true;
            this.f15171D = str;
            return this;
        }

        public FlightNoDetailData setArrivalTime(long j) {
            this.f15212s = true;
            this.f15213t = j;
            return this;
        }

        public FlightNoDetailData setArrivalTimeStr(String str) {
            this.f15174G = true;
            this.f15175H = str;
            return this;
        }

        public FlightNoDetailData setBaggageId(String str) {
            this.f15188U = true;
            this.f15189V = str;
            return this;
        }

        public FlightNoDetailData setBoardGate(String str) {
            this.f15186S = true;
            this.f15187T = str;
            return this;
        }

        public FlightNoDetailData setCheckinTable(String str) {
            this.f15182O = true;
            this.f15183P = str;
            return this;
        }

        public FlightNoDetailData setDepartAirport(String str) {
            this.f15202i = true;
            this.f15203j = str;
            return this;
        }

        public FlightNoDetailData setDepartAirportName(String str) {
            this.f15204k = true;
            this.f15205l = str;
            return this;
        }

        public FlightNoDetailData setDepartAirportNameAbbrev(String str) {
            this.f15176I = true;
            this.f15177J = str;
            return this;
        }

        public FlightNoDetailData setDepartCityCode(String str) {
            this.f15206m = true;
            this.f15207n = str;
            return this;
        }

        public FlightNoDetailData setDepartCityName(String str) {
            this.f15208o = true;
            this.f15209p = str;
            return this;
        }

        public FlightNoDetailData setDepartTerminal(String str) {
            this.f15210q = true;
            this.f15211r = str;
            return this;
        }

        public FlightNoDetailData setDepartTime(long j) {
            this.f15200g = true;
            this.f15201h = j;
            return this;
        }

        public FlightNoDetailData setDepartTimeStr(String str) {
            this.f15172E = true;
            this.f15173F = str;
            return this;
        }

        public FlightNoDetailData setEmtimateArrTimeTitle(String str) {
            this.ai = true;
            this.aj = str;
            return this;
        }

        public FlightNoDetailData setEstimateDepTimeTitle(String str) {
            this.ag = true;
            this.ah = str;
            return this;
        }

        public FlightNoDetailData setFcategory(String str) {
            this.f15180M = true;
            this.f15181N = str;
            return this;
        }

        public FlightNoDetailData setFlightNo(String str) {
            this.f15194a = true;
            this.f15195b = str;
            return this;
        }

        public FlightNoDetailData setFlightState(String str) {
            this.f15184Q = true;
            this.f15185R = str;
            return this;
        }

        public FlightNoDetailData setFlightTimeContent(int i, FlightTimeContent flightTimeContent) {
            if (flightTimeContent != null) {
                this.am.set(i, flightTimeContent);
            }
            return this;
        }

        public FlightNoDetailData setIsDelay(int i) {
            this.ae = true;
            this.af = i;
            return this;
        }

        public FlightNoDetailData setPlanTimeContent(String str) {
            this.ak = true;
            this.al = str;
            return this;
        }

        public FlightNoDetailData setShareFlightNo(String str) {
            this.f15190W = true;
            this.f15191X = str;
            return this;
        }

        public FlightNoDetailData setSuppliedBy(String str) {
            this.ac = true;
            this.ad = str;
            return this;
        }

        public FlightNoDetailData setVeryZhunReadyArrtimeDate(String str) {
            this.aa = true;
            this.ab = str;
            return this;
        }

        public FlightNoDetailData setVeryZhunReadyDeptimeDate(String str) {
            this.f15192Y = true;
            this.f15193Z = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFlightNo()) {
                codedOutputStreamMicro.writeString(1, getFlightNo());
            }
            if (hasAirlineCode()) {
                codedOutputStreamMicro.writeString(2, getAirlineCode());
            }
            if (hasAirline()) {
                codedOutputStreamMicro.writeString(3, getAirline());
            }
            if (hasDepartTime()) {
                codedOutputStreamMicro.writeInt64(4, getDepartTime());
            }
            if (hasDepartAirport()) {
                codedOutputStreamMicro.writeString(5, getDepartAirport());
            }
            if (hasDepartAirportName()) {
                codedOutputStreamMicro.writeString(6, getDepartAirportName());
            }
            if (hasDepartCityCode()) {
                codedOutputStreamMicro.writeString(7, getDepartCityCode());
            }
            if (hasDepartCityName()) {
                codedOutputStreamMicro.writeString(8, getDepartCityName());
            }
            if (hasDepartTerminal()) {
                codedOutputStreamMicro.writeString(9, getDepartTerminal());
            }
            if (hasArrivalTime()) {
                codedOutputStreamMicro.writeInt64(10, getArrivalTime());
            }
            if (hasArrivalAirport()) {
                codedOutputStreamMicro.writeString(11, getArrivalAirport());
            }
            if (hasArrivalAirportName()) {
                codedOutputStreamMicro.writeString(12, getArrivalAirportName());
            }
            if (hasArrivalCityCode()) {
                codedOutputStreamMicro.writeString(13, getArrivalCityCode());
            }
            if (hasArrivalCityName()) {
                codedOutputStreamMicro.writeString(14, getArrivalCityName());
            }
            if (hasArrivalTerminal()) {
                codedOutputStreamMicro.writeString(15, getArrivalTerminal());
            }
            if (hasDepartTimeStr()) {
                codedOutputStreamMicro.writeString(16, getDepartTimeStr());
            }
            if (hasArrivalTimeStr()) {
                codedOutputStreamMicro.writeString(17, getArrivalTimeStr());
            }
            if (hasDepartAirportNameAbbrev()) {
                codedOutputStreamMicro.writeString(18, getDepartAirportNameAbbrev());
            }
            if (hasArrivalAirportNameAbbrev()) {
                codedOutputStreamMicro.writeString(19, getArrivalAirportNameAbbrev());
            }
            if (hasFcategory()) {
                codedOutputStreamMicro.writeString(20, getFcategory());
            }
            if (hasCheckinTable()) {
                codedOutputStreamMicro.writeString(21, getCheckinTable());
            }
            if (hasFlightState()) {
                codedOutputStreamMicro.writeString(22, getFlightState());
            }
            if (hasBoardGate()) {
                codedOutputStreamMicro.writeString(23, getBoardGate());
            }
            if (hasBaggageId()) {
                codedOutputStreamMicro.writeString(24, getBaggageId());
            }
            if (hasShareFlightNo()) {
                codedOutputStreamMicro.writeString(25, getShareFlightNo());
            }
            if (hasVeryZhunReadyDeptimeDate()) {
                codedOutputStreamMicro.writeString(26, getVeryZhunReadyDeptimeDate());
            }
            if (hasVeryZhunReadyArrtimeDate()) {
                codedOutputStreamMicro.writeString(27, getVeryZhunReadyArrtimeDate());
            }
            if (hasSuppliedBy()) {
                codedOutputStreamMicro.writeString(28, getSuppliedBy());
            }
            if (hasIsDelay()) {
                codedOutputStreamMicro.writeInt32(29, getIsDelay());
            }
            if (hasEstimateDepTimeTitle()) {
                codedOutputStreamMicro.writeString(30, getEstimateDepTimeTitle());
            }
            if (hasEmtimateArrTimeTitle()) {
                codedOutputStreamMicro.writeString(31, getEmtimateArrTimeTitle());
            }
            if (hasPlanTimeContent()) {
                codedOutputStreamMicro.writeString(32, getPlanTimeContent());
            }
            for (FlightTimeContent writeMessage : getFlightTimeContentList()) {
                codedOutputStreamMicro.writeMessage(33, writeMessage);
            }
        }
    }

    public static final class FlightNoGroup extends MessageMicro {
        public static final int FLIGHT_NO_DETAIL_FIELD_NUMBER = 2;
        public static final int FLIGHT_NO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15220a;
        /* renamed from: b */
        private String f15221b = "";
        /* renamed from: c */
        private List<FlightNoDetailData> f15222c = Collections.emptyList();
        /* renamed from: d */
        private int f15223d = -1;

        public static FlightNoGroup parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightNoGroup().mergeFrom(codedInputStreamMicro);
        }

        public static FlightNoGroup parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightNoGroup) new FlightNoGroup().mergeFrom(bArr);
        }

        public FlightNoGroup addFlightNoDetail(FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                if (this.f15222c.isEmpty()) {
                    this.f15222c = new ArrayList();
                }
                this.f15222c.add(flightNoDetailData);
            }
            return this;
        }

        public final FlightNoGroup clear() {
            clearFlightNo();
            clearFlightNoDetail();
            this.f15223d = -1;
            return this;
        }

        public FlightNoGroup clearFlightNo() {
            this.f15220a = false;
            this.f15221b = "";
            return this;
        }

        public FlightNoGroup clearFlightNoDetail() {
            this.f15222c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15223d < 0) {
                getSerializedSize();
            }
            return this.f15223d;
        }

        public String getFlightNo() {
            return this.f15221b;
        }

        public FlightNoDetailData getFlightNoDetail(int i) {
            return (FlightNoDetailData) this.f15222c.get(i);
        }

        public int getFlightNoDetailCount() {
            return this.f15222c.size();
        }

        public List<FlightNoDetailData> getFlightNoDetailList() {
            return this.f15222c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFlightNo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
            }
            int i2 = i;
            for (FlightNoDetailData computeMessageSize : getFlightNoDetailList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f15223d = i2;
            return i2;
        }

        public boolean hasFlightNo() {
            return this.f15220a;
        }

        public final boolean isInitialized() {
            return this.f15220a;
        }

        public FlightNoGroup mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFlightNo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro flightNoDetailData = new FlightNoDetailData();
                        codedInputStreamMicro.readMessage(flightNoDetailData);
                        addFlightNoDetail(flightNoDetailData);
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

        public FlightNoGroup setFlightNo(String str) {
            this.f15220a = true;
            this.f15221b = str;
            return this;
        }

        public FlightNoGroup setFlightNoDetail(int i, FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                this.f15222c.set(i, flightNoDetailData);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFlightNo()) {
                codedOutputStreamMicro.writeString(1, getFlightNo());
            }
            for (FlightNoDetailData writeMessage : getFlightNoDetailList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class FlightNoSugData extends MessageMicro {
        public static final int FLIGHT_NO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15224a;
        /* renamed from: b */
        private String f15225b = "";
        /* renamed from: c */
        private int f15226c = -1;

        public static FlightNoSugData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightNoSugData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightNoSugData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightNoSugData) new FlightNoSugData().mergeFrom(bArr);
        }

        public final FlightNoSugData clear() {
            clearFlightNo();
            this.f15226c = -1;
            return this;
        }

        public FlightNoSugData clearFlightNo() {
            this.f15224a = false;
            this.f15225b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15226c < 0) {
                getSerializedSize();
            }
            return this.f15226c;
        }

        public String getFlightNo() {
            return this.f15225b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFlightNo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFlightNo());
            }
            this.f15226c = i;
            return i;
        }

        public boolean hasFlightNo() {
            return this.f15224a;
        }

        public final boolean isInitialized() {
            return this.f15224a;
        }

        public FlightNoSugData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFlightNo(codedInputStreamMicro.readString());
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

        public FlightNoSugData setFlightNo(String str) {
            this.f15224a = true;
            this.f15225b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFlightNo()) {
                codedOutputStreamMicro.writeString(1, getFlightNo());
            }
        }
    }

    public static final class FlightSugData extends MessageMicro {
        public static final int FLIGHTNO_COUNT_FIELD_NUMBER = 1;
        public static final int FLIGHTNO_LIST_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15227a;
        /* renamed from: b */
        private int f15228b = 0;
        /* renamed from: c */
        private List<FlightNoDetailData> f15229c = Collections.emptyList();
        /* renamed from: d */
        private int f15230d = -1;

        public static FlightSugData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightSugData().mergeFrom(codedInputStreamMicro);
        }

        public static FlightSugData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightSugData) new FlightSugData().mergeFrom(bArr);
        }

        public FlightSugData addFlightnoList(FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                if (this.f15229c.isEmpty()) {
                    this.f15229c = new ArrayList();
                }
                this.f15229c.add(flightNoDetailData);
            }
            return this;
        }

        public final FlightSugData clear() {
            clearFlightnoCount();
            clearFlightnoList();
            this.f15230d = -1;
            return this;
        }

        public FlightSugData clearFlightnoCount() {
            this.f15227a = false;
            this.f15228b = 0;
            return this;
        }

        public FlightSugData clearFlightnoList() {
            this.f15229c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15230d < 0) {
                getSerializedSize();
            }
            return this.f15230d;
        }

        public int getFlightnoCount() {
            return this.f15228b;
        }

        public FlightNoDetailData getFlightnoList(int i) {
            return (FlightNoDetailData) this.f15229c.get(i);
        }

        public int getFlightnoListCount() {
            return this.f15229c.size();
        }

        public List<FlightNoDetailData> getFlightnoListList() {
            return this.f15229c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFlightnoCount()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getFlightnoCount());
            }
            int i2 = i;
            for (FlightNoDetailData computeMessageSize : getFlightnoListList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f15230d = i2;
            return i2;
        }

        public boolean hasFlightnoCount() {
            return this.f15227a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightSugData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setFlightnoCount(codedInputStreamMicro.readInt32());
                        continue;
                    case 18:
                        MessageMicro flightNoDetailData = new FlightNoDetailData();
                        codedInputStreamMicro.readMessage(flightNoDetailData);
                        addFlightnoList(flightNoDetailData);
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

        public FlightSugData setFlightnoCount(int i) {
            this.f15227a = true;
            this.f15228b = i;
            return this;
        }

        public FlightSugData setFlightnoList(int i, FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                this.f15229c.set(i, flightNoDetailData);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFlightnoCount()) {
                codedOutputStreamMicro.writeInt32(1, getFlightnoCount());
            }
            for (FlightNoDetailData writeMessage : getFlightnoListList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class FlightTimeContent extends MessageMicro {
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15231a;
        /* renamed from: b */
        private String f15232b = "";
        /* renamed from: c */
        private boolean f15233c;
        /* renamed from: d */
        private String f15234d = "";
        /* renamed from: e */
        private int f15235e = -1;

        public static FlightTimeContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new FlightTimeContent().mergeFrom(codedInputStreamMicro);
        }

        public static FlightTimeContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (FlightTimeContent) new FlightTimeContent().mergeFrom(bArr);
        }

        public final FlightTimeContent clear() {
            clearTitle();
            clearContent();
            this.f15235e = -1;
            return this;
        }

        public FlightTimeContent clearContent() {
            this.f15233c = false;
            this.f15234d = "";
            return this;
        }

        public FlightTimeContent clearTitle() {
            this.f15231a = false;
            this.f15232b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15235e < 0) {
                getSerializedSize();
            }
            return this.f15235e;
        }

        public String getContent() {
            return this.f15234d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
            }
            this.f15235e = i;
            return i;
        }

        public String getTitle() {
            return this.f15232b;
        }

        public boolean hasContent() {
            return this.f15233c;
        }

        public boolean hasTitle() {
            return this.f15231a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public FlightTimeContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setContent(codedInputStreamMicro.readString());
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

        public FlightTimeContent setContent(String str) {
            this.f15233c = true;
            this.f15234d = str;
            return this;
        }

        public FlightTimeContent setTitle(String str) {
            this.f15231a = true;
            this.f15232b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(2, getContent());
            }
        }
    }

    public static final class IsTripUpdate extends MessageMicro {
        public static final int IS_UPDATE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15236a;
        /* renamed from: b */
        private int f15237b = 0;
        /* renamed from: c */
        private int f15238c = -1;

        public static IsTripUpdate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new IsTripUpdate().mergeFrom(codedInputStreamMicro);
        }

        public static IsTripUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (IsTripUpdate) new IsTripUpdate().mergeFrom(bArr);
        }

        public final IsTripUpdate clear() {
            clearIsUpdate();
            this.f15238c = -1;
            return this;
        }

        public IsTripUpdate clearIsUpdate() {
            this.f15236a = false;
            this.f15237b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15238c < 0) {
                getSerializedSize();
            }
            return this.f15238c;
        }

        public int getIsUpdate() {
            return this.f15237b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsUpdate()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsUpdate());
            }
            this.f15238c = i;
            return i;
        }

        public boolean hasIsUpdate() {
            return this.f15236a;
        }

        public final boolean isInitialized() {
            return this.f15236a;
        }

        public IsTripUpdate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsUpdate(codedInputStreamMicro.readInt32());
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

        public IsTripUpdate setIsUpdate(int i) {
            this.f15236a = true;
            this.f15237b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsUpdate()) {
                codedOutputStreamMicro.writeInt32(1, getIsUpdate());
            }
        }
    }

    public static final class ML extends MessageMicro {
        public static final int CLOUD_CONF_FIELD_NUMBER = 7;
        public static final int CONFIG_VERSION_FIELD_NUMBER = 5;
        public static final int DYNAMIC_MAP_DATA_FIELD_NUMBER = 6;
        public static final int ML_DESC_FIELD_NUMBER = 9;
        public static final int ML_HEADER_FIELD_NUMBER = 1;
        public static final int ML_SUGLIST_FIELD_NUMBER = 8;
        public static final int ML_SUG_FIELD_NUMBER = 3;
        public static final int ML_TRIP_GROUP_FIELD_NUMBER = 2;
        public static final int SCENE_ENTRY_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15239a;
        /* renamed from: b */
        private MLHeader f15240b = null;
        /* renamed from: c */
        private List<MLTripGroup> f15241c = Collections.emptyList();
        /* renamed from: d */
        private List<MLSug> f15242d = Collections.emptyList();
        /* renamed from: e */
        private boolean f15243e;
        /* renamed from: f */
        private SceneEntry f15244f = null;
        /* renamed from: g */
        private boolean f15245g;
        /* renamed from: h */
        private VersionInfo f15246h = null;
        /* renamed from: i */
        private boolean f15247i;
        /* renamed from: j */
        private ByteStringMicro f15248j = ByteStringMicro.EMPTY;
        /* renamed from: k */
        private boolean f15249k;
        /* renamed from: l */
        private CloudConf f15250l = null;
        /* renamed from: m */
        private List<DriverPageInfo> f15251m = Collections.emptyList();
        /* renamed from: n */
        private boolean f15252n;
        /* renamed from: o */
        private MLDesc f15253o = null;
        /* renamed from: p */
        private int f15254p = -1;

        public static ML parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ML().mergeFrom(codedInputStreamMicro);
        }

        public static ML parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ML) new ML().mergeFrom(bArr);
        }

        public ML addMlSug(MLSug mLSug) {
            if (mLSug != null) {
                if (this.f15242d.isEmpty()) {
                    this.f15242d = new ArrayList();
                }
                this.f15242d.add(mLSug);
            }
            return this;
        }

        public ML addMlSuglist(DriverPageInfo driverPageInfo) {
            if (driverPageInfo != null) {
                if (this.f15251m.isEmpty()) {
                    this.f15251m = new ArrayList();
                }
                this.f15251m.add(driverPageInfo);
            }
            return this;
        }

        public ML addMlTripGroup(MLTripGroup mLTripGroup) {
            if (mLTripGroup != null) {
                if (this.f15241c.isEmpty()) {
                    this.f15241c = new ArrayList();
                }
                this.f15241c.add(mLTripGroup);
            }
            return this;
        }

        public final ML clear() {
            clearMlHeader();
            clearMlTripGroup();
            clearMlSug();
            clearSceneEntry();
            clearConfigVersion();
            clearDynamicMapData();
            clearCloudConf();
            clearMlSuglist();
            clearMlDesc();
            this.f15254p = -1;
            return this;
        }

        public ML clearCloudConf() {
            this.f15249k = false;
            this.f15250l = null;
            return this;
        }

        public ML clearConfigVersion() {
            this.f15245g = false;
            this.f15246h = null;
            return this;
        }

        public ML clearDynamicMapData() {
            this.f15247i = false;
            this.f15248j = ByteStringMicro.EMPTY;
            return this;
        }

        public ML clearMlDesc() {
            this.f15252n = false;
            this.f15253o = null;
            return this;
        }

        public ML clearMlHeader() {
            this.f15239a = false;
            this.f15240b = null;
            return this;
        }

        public ML clearMlSug() {
            this.f15242d = Collections.emptyList();
            return this;
        }

        public ML clearMlSuglist() {
            this.f15251m = Collections.emptyList();
            return this;
        }

        public ML clearMlTripGroup() {
            this.f15241c = Collections.emptyList();
            return this;
        }

        public ML clearSceneEntry() {
            this.f15243e = false;
            this.f15244f = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15254p < 0) {
                getSerializedSize();
            }
            return this.f15254p;
        }

        public CloudConf getCloudConf() {
            return this.f15250l;
        }

        public VersionInfo getConfigVersion() {
            return this.f15246h;
        }

        public ByteStringMicro getDynamicMapData() {
            return this.f15248j;
        }

        public MLDesc getMlDesc() {
            return this.f15253o;
        }

        public MLHeader getMlHeader() {
            return this.f15240b;
        }

        public MLSug getMlSug(int i) {
            return (MLSug) this.f15242d.get(i);
        }

        public int getMlSugCount() {
            return this.f15242d.size();
        }

        public List<MLSug> getMlSugList() {
            return this.f15242d;
        }

        public DriverPageInfo getMlSuglist(int i) {
            return (DriverPageInfo) this.f15251m.get(i);
        }

        public int getMlSuglistCount() {
            return this.f15251m.size();
        }

        public List<DriverPageInfo> getMlSuglistList() {
            return this.f15251m;
        }

        public MLTripGroup getMlTripGroup(int i) {
            return (MLTripGroup) this.f15241c.get(i);
        }

        public int getMlTripGroupCount() {
            return this.f15241c.size();
        }

        public List<MLTripGroup> getMlTripGroupList() {
            return this.f15241c;
        }

        public SceneEntry getSceneEntry() {
            return this.f15244f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMlHeader()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMlHeader());
            }
            int i2 = i;
            for (MLTripGroup computeMessageSize : getMlTripGroupList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            for (MLSug computeMessageSize2 : getMlSugList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize2);
            }
            if (hasSceneEntry()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, getSceneEntry());
            }
            if (hasConfigVersion()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getConfigVersion());
            }
            if (hasDynamicMapData()) {
                i2 += CodedOutputStreamMicro.computeBytesSize(6, getDynamicMapData());
            }
            if (hasCloudConf()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getCloudConf());
            }
            for (DriverPageInfo computeMessageSize3 : getMlSuglistList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize3);
            }
            if (hasMlDesc()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, getMlDesc());
            }
            this.f15254p = i2;
            return i2;
        }

        public boolean hasCloudConf() {
            return this.f15249k;
        }

        public boolean hasConfigVersion() {
            return this.f15245g;
        }

        public boolean hasDynamicMapData() {
            return this.f15247i;
        }

        public boolean hasMlDesc() {
            return this.f15252n;
        }

        public boolean hasMlHeader() {
            return this.f15239a;
        }

        public boolean hasSceneEntry() {
            return this.f15243e;
        }

        public final boolean isInitialized() {
            if (hasMlHeader() && !getMlHeader().isInitialized()) {
                return false;
            }
            for (MLTripGroup isInitialized : getMlTripGroupList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            for (MLSug isInitialized2 : getMlSugList()) {
                if (!isInitialized2.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public ML mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro mLHeader;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        mLHeader = new MLHeader();
                        codedInputStreamMicro.readMessage(mLHeader);
                        setMlHeader(mLHeader);
                        continue;
                    case 18:
                        mLHeader = new MLTripGroup();
                        codedInputStreamMicro.readMessage(mLHeader);
                        addMlTripGroup(mLHeader);
                        continue;
                    case 26:
                        mLHeader = new MLSug();
                        codedInputStreamMicro.readMessage(mLHeader);
                        addMlSug(mLHeader);
                        continue;
                    case 34:
                        mLHeader = new SceneEntry();
                        codedInputStreamMicro.readMessage(mLHeader);
                        setSceneEntry(mLHeader);
                        continue;
                    case 42:
                        mLHeader = new VersionInfo();
                        codedInputStreamMicro.readMessage(mLHeader);
                        setConfigVersion(mLHeader);
                        continue;
                    case 50:
                        setDynamicMapData(codedInputStreamMicro.readBytes());
                        continue;
                    case 58:
                        mLHeader = new CloudConf();
                        codedInputStreamMicro.readMessage(mLHeader);
                        setCloudConf(mLHeader);
                        continue;
                    case 66:
                        mLHeader = new DriverPageInfo();
                        codedInputStreamMicro.readMessage(mLHeader);
                        addMlSuglist(mLHeader);
                        continue;
                    case 74:
                        mLHeader = new MLDesc();
                        codedInputStreamMicro.readMessage(mLHeader);
                        setMlDesc(mLHeader);
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

        public ML setCloudConf(CloudConf cloudConf) {
            if (cloudConf == null) {
                return clearCloudConf();
            }
            this.f15249k = true;
            this.f15250l = cloudConf;
            return this;
        }

        public ML setConfigVersion(VersionInfo versionInfo) {
            if (versionInfo == null) {
                return clearConfigVersion();
            }
            this.f15245g = true;
            this.f15246h = versionInfo;
            return this;
        }

        public ML setDynamicMapData(ByteStringMicro byteStringMicro) {
            this.f15247i = true;
            this.f15248j = byteStringMicro;
            return this;
        }

        public ML setMlDesc(MLDesc mLDesc) {
            if (mLDesc == null) {
                return clearMlDesc();
            }
            this.f15252n = true;
            this.f15253o = mLDesc;
            return this;
        }

        public ML setMlHeader(MLHeader mLHeader) {
            if (mLHeader == null) {
                return clearMlHeader();
            }
            this.f15239a = true;
            this.f15240b = mLHeader;
            return this;
        }

        public ML setMlSug(int i, MLSug mLSug) {
            if (mLSug != null) {
                this.f15242d.set(i, mLSug);
            }
            return this;
        }

        public ML setMlSuglist(int i, DriverPageInfo driverPageInfo) {
            if (driverPageInfo != null) {
                this.f15251m.set(i, driverPageInfo);
            }
            return this;
        }

        public ML setMlTripGroup(int i, MLTripGroup mLTripGroup) {
            if (mLTripGroup != null) {
                this.f15241c.set(i, mLTripGroup);
            }
            return this;
        }

        public ML setSceneEntry(SceneEntry sceneEntry) {
            if (sceneEntry == null) {
                return clearSceneEntry();
            }
            this.f15243e = true;
            this.f15244f = sceneEntry;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMlHeader()) {
                codedOutputStreamMicro.writeMessage(1, getMlHeader());
            }
            for (MLTripGroup writeMessage : getMlTripGroupList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            for (MLSug writeMessage2 : getMlSugList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage2);
            }
            if (hasSceneEntry()) {
                codedOutputStreamMicro.writeMessage(4, getSceneEntry());
            }
            if (hasConfigVersion()) {
                codedOutputStreamMicro.writeMessage(5, getConfigVersion());
            }
            if (hasDynamicMapData()) {
                codedOutputStreamMicro.writeBytes(6, getDynamicMapData());
            }
            if (hasCloudConf()) {
                codedOutputStreamMicro.writeMessage(7, getCloudConf());
            }
            for (DriverPageInfo writeMessage3 : getMlSuglistList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage3);
            }
            if (hasMlDesc()) {
                codedOutputStreamMicro.writeMessage(9, getMlDesc());
            }
        }
    }

    public static final class MLDesc extends MessageMicro {
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int JUMP_URL_FIELD_NUMBER = 2;
        public static final int SUB_TITLE_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15255a;
        /* renamed from: b */
        private String f15256b = "";
        /* renamed from: c */
        private boolean f15257c;
        /* renamed from: d */
        private String f15258d = "";
        /* renamed from: e */
        private boolean f15259e;
        /* renamed from: f */
        private String f15260f = "";
        /* renamed from: g */
        private boolean f15261g;
        /* renamed from: h */
        private String f15262h = "";
        /* renamed from: i */
        private int f15263i = -1;

        public static MLDesc parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLDesc().mergeFrom(codedInputStreamMicro);
        }

        public static MLDesc parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLDesc) new MLDesc().mergeFrom(bArr);
        }

        public final MLDesc clear() {
            clearIcon();
            clearJumpUrl();
            clearTitle();
            clearSubTitle();
            this.f15263i = -1;
            return this;
        }

        public MLDesc clearIcon() {
            this.f15255a = false;
            this.f15256b = "";
            return this;
        }

        public MLDesc clearJumpUrl() {
            this.f15257c = false;
            this.f15258d = "";
            return this;
        }

        public MLDesc clearSubTitle() {
            this.f15261g = false;
            this.f15262h = "";
            return this;
        }

        public MLDesc clearTitle() {
            this.f15259e = false;
            this.f15260f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15263i < 0) {
                getSerializedSize();
            }
            return this.f15263i;
        }

        public String getIcon() {
            return this.f15256b;
        }

        public String getJumpUrl() {
            return this.f15258d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getJumpUrl());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTitle());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getSubTitle());
            }
            this.f15263i = i;
            return i;
        }

        public String getSubTitle() {
            return this.f15262h;
        }

        public String getTitle() {
            return this.f15260f;
        }

        public boolean hasIcon() {
            return this.f15255a;
        }

        public boolean hasJumpUrl() {
            return this.f15257c;
        }

        public boolean hasSubTitle() {
            return this.f15261g;
        }

        public boolean hasTitle() {
            return this.f15259e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MLDesc mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setSubTitle(codedInputStreamMicro.readString());
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

        public MLDesc setIcon(String str) {
            this.f15255a = true;
            this.f15256b = str;
            return this;
        }

        public MLDesc setJumpUrl(String str) {
            this.f15257c = true;
            this.f15258d = str;
            return this;
        }

        public MLDesc setSubTitle(String str) {
            this.f15261g = true;
            this.f15262h = str;
            return this;
        }

        public MLDesc setTitle(String str) {
            this.f15259e = true;
            this.f15260f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(2, getJumpUrl());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(3, getTitle());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(4, getSubTitle());
            }
        }
    }

    public static final class MLHeader extends MessageMicro {
        public static final int LOC_FIELD_NUMBER = 2;
        public static final int ML_HEADER_WEATHER_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15264a;
        /* renamed from: b */
        private MLHeaderWeather f15265b = null;
        /* renamed from: c */
        private boolean f15266c;
        /* renamed from: d */
        private String f15267d = "";
        /* renamed from: e */
        private int f15268e = -1;

        public static MLHeader parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLHeader().mergeFrom(codedInputStreamMicro);
        }

        public static MLHeader parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLHeader) new MLHeader().mergeFrom(bArr);
        }

        public final MLHeader clear() {
            clearMlHeaderWeather();
            clearLoc();
            this.f15268e = -1;
            return this;
        }

        public MLHeader clearLoc() {
            this.f15266c = false;
            this.f15267d = "";
            return this;
        }

        public MLHeader clearMlHeaderWeather() {
            this.f15264a = false;
            this.f15265b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15268e < 0) {
                getSerializedSize();
            }
            return this.f15268e;
        }

        public String getLoc() {
            return this.f15267d;
        }

        public MLHeaderWeather getMlHeaderWeather() {
            return this.f15265b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMlHeaderWeather()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMlHeaderWeather());
            }
            if (hasLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getLoc());
            }
            this.f15268e = i;
            return i;
        }

        public boolean hasLoc() {
            return this.f15266c;
        }

        public boolean hasMlHeaderWeather() {
            return this.f15264a;
        }

        public final boolean isInitialized() {
            return this.f15264a && this.f15266c && getMlHeaderWeather().isInitialized();
        }

        public MLHeader mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro mLHeaderWeather = new MLHeaderWeather();
                        codedInputStreamMicro.readMessage(mLHeaderWeather);
                        setMlHeaderWeather(mLHeaderWeather);
                        continue;
                    case 18:
                        setLoc(codedInputStreamMicro.readString());
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

        public MLHeader setLoc(String str) {
            this.f15266c = true;
            this.f15267d = str;
            return this;
        }

        public MLHeader setMlHeaderWeather(MLHeaderWeather mLHeaderWeather) {
            if (mLHeaderWeather == null) {
                return clearMlHeaderWeather();
            }
            this.f15264a = true;
            this.f15265b = mLHeaderWeather;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMlHeaderWeather()) {
                codedOutputStreamMicro.writeMessage(1, getMlHeaderWeather());
            }
            if (hasLoc()) {
                codedOutputStreamMicro.writeString(2, getLoc());
            }
        }
    }

    public static final class MLHeaderWeather extends MessageMicro {
        public static final int CARLIMIT_INFO_FIELD_NUMBER = 10;
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int JUMP_URL_FIELD_NUMBER = 5;
        public static final int NEW_ICON_FIELD_NUMBER = 8;
        public static final int PM25_FIELD_NUMBER = 4;
        public static final int SCHEME_FIELD_NUMBER = 3;
        public static final int TEMP_RANGE_FIELD_NUMBER = 7;
        public static final int TEXT_FIELD_NUMBER = 2;
        public static final int WEATHER_FIELD_NUMBER = 6;
        public static final int WEATHER_WARNING_FIELD_NUMBER = 9;
        /* renamed from: a */
        private boolean f15269a;
        /* renamed from: b */
        private String f15270b = "";
        /* renamed from: c */
        private boolean f15271c;
        /* renamed from: d */
        private String f15272d = "";
        /* renamed from: e */
        private boolean f15273e;
        /* renamed from: f */
        private String f15274f = "";
        /* renamed from: g */
        private boolean f15275g;
        /* renamed from: h */
        private String f15276h = "";
        /* renamed from: i */
        private boolean f15277i;
        /* renamed from: j */
        private String f15278j = "";
        /* renamed from: k */
        private boolean f15279k;
        /* renamed from: l */
        private String f15280l = "";
        /* renamed from: m */
        private boolean f15281m;
        /* renamed from: n */
        private String f15282n = "";
        /* renamed from: o */
        private boolean f15283o;
        /* renamed from: p */
        private String f15284p = "";
        /* renamed from: q */
        private boolean f15285q;
        /* renamed from: r */
        private BaseTitleContent f15286r = null;
        /* renamed from: s */
        private boolean f15287s;
        /* renamed from: t */
        private BaseTitleContent f15288t = null;
        /* renamed from: u */
        private int f15289u = -1;

        public static MLHeaderWeather parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLHeaderWeather().mergeFrom(codedInputStreamMicro);
        }

        public static MLHeaderWeather parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLHeaderWeather) new MLHeaderWeather().mergeFrom(bArr);
        }

        public final MLHeaderWeather clear() {
            clearIcon();
            clearText();
            clearScheme();
            clearPm25();
            clearJumpUrl();
            clearWeather();
            clearTempRange();
            clearNewIcon();
            clearWeatherWarning();
            clearCarlimitInfo();
            this.f15289u = -1;
            return this;
        }

        public MLHeaderWeather clearCarlimitInfo() {
            this.f15287s = false;
            this.f15288t = null;
            return this;
        }

        public MLHeaderWeather clearIcon() {
            this.f15269a = false;
            this.f15270b = "";
            return this;
        }

        public MLHeaderWeather clearJumpUrl() {
            this.f15277i = false;
            this.f15278j = "";
            return this;
        }

        public MLHeaderWeather clearNewIcon() {
            this.f15283o = false;
            this.f15284p = "";
            return this;
        }

        public MLHeaderWeather clearPm25() {
            this.f15275g = false;
            this.f15276h = "";
            return this;
        }

        public MLHeaderWeather clearScheme() {
            this.f15273e = false;
            this.f15274f = "";
            return this;
        }

        public MLHeaderWeather clearTempRange() {
            this.f15281m = false;
            this.f15282n = "";
            return this;
        }

        public MLHeaderWeather clearText() {
            this.f15271c = false;
            this.f15272d = "";
            return this;
        }

        public MLHeaderWeather clearWeather() {
            this.f15279k = false;
            this.f15280l = "";
            return this;
        }

        public MLHeaderWeather clearWeatherWarning() {
            this.f15285q = false;
            this.f15286r = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15289u < 0) {
                getSerializedSize();
            }
            return this.f15289u;
        }

        public BaseTitleContent getCarlimitInfo() {
            return this.f15288t;
        }

        public String getIcon() {
            return this.f15270b;
        }

        public String getJumpUrl() {
            return this.f15278j;
        }

        public String getNewIcon() {
            return this.f15284p;
        }

        public String getPm25() {
            return this.f15276h;
        }

        public String getScheme() {
            return this.f15274f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getText());
            }
            if (hasScheme()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getScheme());
            }
            if (hasPm25()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getPm25());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getJumpUrl());
            }
            if (hasWeather()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getWeather());
            }
            if (hasTempRange()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getTempRange());
            }
            if (hasNewIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getNewIcon());
            }
            if (hasWeatherWarning()) {
                i += CodedOutputStreamMicro.computeMessageSize(9, getWeatherWarning());
            }
            if (hasCarlimitInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(10, getCarlimitInfo());
            }
            this.f15289u = i;
            return i;
        }

        public String getTempRange() {
            return this.f15282n;
        }

        public String getText() {
            return this.f15272d;
        }

        public String getWeather() {
            return this.f15280l;
        }

        public BaseTitleContent getWeatherWarning() {
            return this.f15286r;
        }

        public boolean hasCarlimitInfo() {
            return this.f15287s;
        }

        public boolean hasIcon() {
            return this.f15269a;
        }

        public boolean hasJumpUrl() {
            return this.f15277i;
        }

        public boolean hasNewIcon() {
            return this.f15283o;
        }

        public boolean hasPm25() {
            return this.f15275g;
        }

        public boolean hasScheme() {
            return this.f15273e;
        }

        public boolean hasTempRange() {
            return this.f15281m;
        }

        public boolean hasText() {
            return this.f15271c;
        }

        public boolean hasWeather() {
            return this.f15279k;
        }

        public boolean hasWeatherWarning() {
            return this.f15285q;
        }

        public final boolean isInitialized() {
            return this.f15269a && this.f15271c;
        }

        public MLHeaderWeather mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro baseTitleContent;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setText(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setScheme(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setPm25(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setWeather(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setTempRange(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setNewIcon(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        baseTitleContent = new BaseTitleContent();
                        codedInputStreamMicro.readMessage(baseTitleContent);
                        setWeatherWarning(baseTitleContent);
                        continue;
                    case 82:
                        baseTitleContent = new BaseTitleContent();
                        codedInputStreamMicro.readMessage(baseTitleContent);
                        setCarlimitInfo(baseTitleContent);
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

        public MLHeaderWeather setCarlimitInfo(BaseTitleContent baseTitleContent) {
            if (baseTitleContent == null) {
                return clearCarlimitInfo();
            }
            this.f15287s = true;
            this.f15288t = baseTitleContent;
            return this;
        }

        public MLHeaderWeather setIcon(String str) {
            this.f15269a = true;
            this.f15270b = str;
            return this;
        }

        public MLHeaderWeather setJumpUrl(String str) {
            this.f15277i = true;
            this.f15278j = str;
            return this;
        }

        public MLHeaderWeather setNewIcon(String str) {
            this.f15283o = true;
            this.f15284p = str;
            return this;
        }

        public MLHeaderWeather setPm25(String str) {
            this.f15275g = true;
            this.f15276h = str;
            return this;
        }

        public MLHeaderWeather setScheme(String str) {
            this.f15273e = true;
            this.f15274f = str;
            return this;
        }

        public MLHeaderWeather setTempRange(String str) {
            this.f15281m = true;
            this.f15282n = str;
            return this;
        }

        public MLHeaderWeather setText(String str) {
            this.f15271c = true;
            this.f15272d = str;
            return this;
        }

        public MLHeaderWeather setWeather(String str) {
            this.f15279k = true;
            this.f15280l = str;
            return this;
        }

        public MLHeaderWeather setWeatherWarning(BaseTitleContent baseTitleContent) {
            if (baseTitleContent == null) {
                return clearWeatherWarning();
            }
            this.f15285q = true;
            this.f15286r = baseTitleContent;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeString(2, getText());
            }
            if (hasScheme()) {
                codedOutputStreamMicro.writeString(3, getScheme());
            }
            if (hasPm25()) {
                codedOutputStreamMicro.writeString(4, getPm25());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(5, getJumpUrl());
            }
            if (hasWeather()) {
                codedOutputStreamMicro.writeString(6, getWeather());
            }
            if (hasTempRange()) {
                codedOutputStreamMicro.writeString(7, getTempRange());
            }
            if (hasNewIcon()) {
                codedOutputStreamMicro.writeString(8, getNewIcon());
            }
            if (hasWeatherWarning()) {
                codedOutputStreamMicro.writeMessage(9, getWeatherWarning());
            }
            if (hasCarlimitInfo()) {
                codedOutputStreamMicro.writeMessage(10, getCarlimitInfo());
            }
        }
    }

    public static final class MLSug extends MessageMicro {
        public static final int DESC_FIELD_NUMBER = 4;
        public static final int ICON_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15290a;
        /* renamed from: b */
        private String f15291b = "";
        /* renamed from: c */
        private boolean f15292c;
        /* renamed from: d */
        private String f15293d = "";
        /* renamed from: e */
        private boolean f15294e;
        /* renamed from: f */
        private String f15295f = "";
        /* renamed from: g */
        private boolean f15296g;
        /* renamed from: h */
        private String f15297h = "";
        /* renamed from: i */
        private int f15298i = -1;

        public static MLSug parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLSug().mergeFrom(codedInputStreamMicro);
        }

        public static MLSug parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLSug) new MLSug().mergeFrom(bArr);
        }

        public final MLSug clear() {
            clearUid();
            clearName();
            clearIcon();
            clearDesc();
            this.f15298i = -1;
            return this;
        }

        public MLSug clearDesc() {
            this.f15296g = false;
            this.f15297h = "";
            return this;
        }

        public MLSug clearIcon() {
            this.f15294e = false;
            this.f15295f = "";
            return this;
        }

        public MLSug clearName() {
            this.f15292c = false;
            this.f15293d = "";
            return this;
        }

        public MLSug clearUid() {
            this.f15290a = false;
            this.f15291b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15298i < 0) {
                getSerializedSize();
            }
            return this.f15298i;
        }

        public String getDesc() {
            return this.f15297h;
        }

        public String getIcon() {
            return this.f15295f;
        }

        public String getName() {
            return this.f15293d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getIcon());
            }
            if (hasDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getDesc());
            }
            this.f15298i = i;
            return i;
        }

        public String getUid() {
            return this.f15291b;
        }

        public boolean hasDesc() {
            return this.f15296g;
        }

        public boolean hasIcon() {
            return this.f15294e;
        }

        public boolean hasName() {
            return this.f15292c;
        }

        public boolean hasUid() {
            return this.f15290a;
        }

        public final boolean isInitialized() {
            return this.f15290a && this.f15292c && this.f15294e && this.f15296g;
        }

        public MLSug mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setIcon(codedInputStreamMicro.readString());
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

        public MLSug setDesc(String str) {
            this.f15296g = true;
            this.f15297h = str;
            return this;
        }

        public MLSug setIcon(String str) {
            this.f15294e = true;
            this.f15295f = str;
            return this;
        }

        public MLSug setName(String str) {
            this.f15292c = true;
            this.f15293d = str;
            return this;
        }

        public MLSug setUid(String str) {
            this.f15290a = true;
            this.f15291b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUid()) {
                codedOutputStreamMicro.writeString(1, getUid());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(3, getIcon());
            }
            if (hasDesc()) {
                codedOutputStreamMicro.writeString(4, getDesc());
            }
        }
    }

    public static final class MLTrip extends MessageMicro {
        public static final int ARRIVAL_TIME_FIELD_NUMBER = 7;
        public static final int CARD_RESOURCE_FIELD_NUMBER = 11;
        public static final int COST_TIME_FIELD_NUMBER = 40;
        public static final int CREATE_INFO_FIELD_NUMBER = 12;
        public static final int DETAIL_URL_FIELD_NUMBER = 20;
        public static final int END_POINT_FIELD_NUMBER = 10;
        public static final int END_POINT_SUB_TITLE_FIELD_NUMBER = 46;
        public static final int END_POINT_TITLE_FIELD_NUMBER = 39;
        public static final int EVENT_TRIP_TITLE_FIELD_NUMBER = 41;
        public static final int FLIGHT_INFO_FIELD_NUMBER = 19;
        public static final int GUIDE_REMARK_FIELD_NUMBER = 17;
        public static final int ICON_INFO_FIELD_NUMBER = 21;
        public static final int IS_CROSS_FIELD_NUMBER = 16;
        public static final int IS_OLD_FIELD_NUMBER = 44;
        public static final int IS_REMIND_FIELD_NUMBER = 6;
        public static final int IS_REPEAT_FIELD_NUMBER = 29;
        public static final int IS_SHOW_ROUTE_MAP_FIELD_NUMBER = 27;
        public static final int IS_WHOLEDAY_FIELD_NUMBER = 51;
        public static final int JUMP_CONTENT_FIELD_NUMBER = 36;
        public static final int JUMP_URL_FIELD_NUMBER = 37;
        public static final int REMARK_FIELD_NUMBER = 3;
        public static final int REPEAT_DEADLINE_FIELD_NUMBER = 49;
        public static final int REPEAT_TIMESTAMP_FIELD_NUMBER = 31;
        public static final int REPEAT_TYPE_FIELD_NUMBER = 48;
        public static final int ROUTE_INFO_FIELD_NUMBER = 8;
        public static final int SRC_FROM_FIELD_NUMBER = 50;
        public static final int START_POINT_FIELD_NUMBER = 9;
        public static final int START_POINT_SUB_TITLE_FIELD_NUMBER = 45;
        public static final int START_POINT_TITLE_FIELD_NUMBER = 38;
        public static final int START_TIME_FIELD_NUMBER = 14;
        public static final int STATUS_FIELD_NUMBER = 4;
        public static final int SUB_TRIP_TYPE_FIELD_NUMBER = 30;
        public static final int SUG_CARD_FIELD_NUMBER = 28;
        public static final int SUG_TIME_FIELD_NUMBER = 5;
        public static final int TIME_TYPE_FIELD_NUMBER = 15;
        public static final int TITLE_FIELD_NUMBER = 2;
        public static final int TITLE_TYPE_FIELD_NUMBER = 43;
        public static final int TITLE_URL_FIELD_NUMBER = 32;
        public static final int TRAIN_INFO_FIELD_NUMBER = 18;
        public static final int TRIP_ADDR_TITLE_FIELD_NUMBER = 23;
        public static final int TRIP_CARD_TITLE_FIELD_NUMBER = 22;
        public static final int TRIP_DESC_FIELD_NUMBER = 47;
        public static final int TRIP_ENDTIME_CONTENT_FIELD_NUMBER = 35;
        public static final int TRIP_ICON_URL_FIELD_NUMBER = 26;
        public static final int TRIP_ID_FIELD_NUMBER = 1;
        public static final int TRIP_NEW_ICON_URL_FIELD_NUMBER = 42;
        public static final int TRIP_ROUTE_TITLE_FIELD_NUMBER = 25;
        public static final int TRIP_STARTTIME_CONTENT_FIELD_NUMBER = 34;
        public static final int TRIP_TIME_CONTENT_FIELD_NUMBER = 33;
        public static final int TRIP_TIME_TITLE_FIELD_NUMBER = 24;
        public static final int TRIP_TYPE_FIELD_NUMBER = 13;
        /* renamed from: A */
        private boolean f15299A;
        /* renamed from: B */
        private long f15300B = 0;
        /* renamed from: C */
        private boolean f15301C;
        /* renamed from: D */
        private long f15302D = 0;
        /* renamed from: E */
        private boolean f15303E;
        /* renamed from: F */
        private int f15304F = 0;
        /* renamed from: G */
        private boolean f15305G;
        /* renamed from: H */
        private String f15306H = "";
        /* renamed from: I */
        private boolean f15307I;
        /* renamed from: J */
        private MLTripTrainInfo f15308J = null;
        /* renamed from: K */
        private boolean f15309K;
        /* renamed from: L */
        private MLTripFlightInfo f15310L = null;
        /* renamed from: M */
        private boolean f15311M;
        /* renamed from: N */
        private String f15312N = "";
        /* renamed from: O */
        private boolean f15313O;
        /* renamed from: P */
        private MLTripCardIconInfo f15314P = null;
        /* renamed from: Q */
        private boolean f15315Q;
        /* renamed from: R */
        private String f15316R = "";
        /* renamed from: S */
        private boolean f15317S;
        /* renamed from: T */
        private String f15318T = "";
        /* renamed from: U */
        private boolean f15319U;
        /* renamed from: V */
        private String f15320V = "";
        /* renamed from: W */
        private boolean f15321W;
        /* renamed from: X */
        private String f15322X = "";
        /* renamed from: Y */
        private boolean f15323Y;
        /* renamed from: Z */
        private String f15324Z = "";
        /* renamed from: a */
        private boolean f15325a;
        private String aA = "";
        private boolean aB;
        private String aC = "";
        private boolean aD;
        private String aE = "";
        private boolean aF;
        private String aG = "";
        private boolean aH;
        private int aI = 0;
        private boolean aJ;
        private String aK = "";
        private boolean aL;
        private String aM = "";
        private boolean aN;
        private String aO = "";
        private boolean aP;
        private String aQ = "";
        private boolean aR;
        private long aS = 0;
        private boolean aT;
        private String aU = "";
        private boolean aV;
        private int aW = 0;
        private int aX = -1;
        private boolean aa;
        private int ab = 0;
        private List<MLTripSugInfo> ac = Collections.emptyList();
        private boolean ad;
        private int ae = 0;
        private boolean af;
        private long ag = 0;
        private boolean ah;
        private long ai = 0;
        private boolean aj;
        private String ak = "";
        private boolean al;
        private String am = "";
        private boolean an;
        private String ao = "";
        private boolean ap;
        private String aq = "";
        private boolean ar;
        private String as = "";
        private boolean at;
        private String au = "";
        private boolean av;
        private String aw = "";
        private boolean ax;
        private String ay = "";
        private boolean az;
        /* renamed from: b */
        private String f15326b = "";
        /* renamed from: c */
        private boolean f15327c;
        /* renamed from: d */
        private String f15328d = "";
        /* renamed from: e */
        private boolean f15329e;
        /* renamed from: f */
        private String f15330f = "";
        /* renamed from: g */
        private boolean f15331g;
        /* renamed from: h */
        private int f15332h = 0;
        /* renamed from: i */
        private boolean f15333i;
        /* renamed from: j */
        private long f15334j = 0;
        /* renamed from: k */
        private boolean f15335k;
        /* renamed from: l */
        private int f15336l = 0;
        /* renamed from: m */
        private boolean f15337m;
        /* renamed from: n */
        private long f15338n = 0;
        /* renamed from: o */
        private boolean f15339o;
        /* renamed from: p */
        private String f15340p = "";
        /* renamed from: q */
        private boolean f15341q;
        /* renamed from: r */
        private MLTripPoint f15342r = null;
        /* renamed from: s */
        private boolean f15343s;
        /* renamed from: t */
        private MLTripPoint f15344t = null;
        /* renamed from: u */
        private boolean f15345u;
        /* renamed from: v */
        private MLTripCardResource f15346v = null;
        /* renamed from: w */
        private boolean f15347w;
        /* renamed from: x */
        private MLTripCreateInfo f15348x = null;
        /* renamed from: y */
        private boolean f15349y;
        /* renamed from: z */
        private long f15350z = 0;

        public static MLTrip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTrip().mergeFrom(codedInputStreamMicro);
        }

        public static MLTrip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTrip) new MLTrip().mergeFrom(bArr);
        }

        public MLTrip addSugCard(MLTripSugInfo mLTripSugInfo) {
            if (mLTripSugInfo != null) {
                if (this.ac.isEmpty()) {
                    this.ac = new ArrayList();
                }
                this.ac.add(mLTripSugInfo);
            }
            return this;
        }

        public final MLTrip clear() {
            clearTripId();
            clearTitle();
            clearRemark();
            clearStatus();
            clearSugTime();
            clearIsRemind();
            clearArrivalTime();
            clearRouteInfo();
            clearStartPoint();
            clearEndPoint();
            clearCardResource();
            clearCreateInfo();
            clearTripType();
            clearStartTime();
            clearTimeType();
            clearIsCross();
            clearGuideRemark();
            clearTrainInfo();
            clearFlightInfo();
            clearDetailUrl();
            clearIconInfo();
            clearTripCardTitle();
            clearTripAddrTitle();
            clearTripTimeTitle();
            clearTripRouteTitle();
            clearTripIconUrl();
            clearIsShowRouteMap();
            clearSugCard();
            clearIsRepeat();
            clearSubTripType();
            clearRepeatTimestamp();
            clearTitleUrl();
            clearTripTimeContent();
            clearTripStarttimeContent();
            clearTripEndtimeContent();
            clearJumpContent();
            clearJumpUrl();
            clearStartPointTitle();
            clearEndPointTitle();
            clearCostTime();
            clearEventTripTitle();
            clearTripNewIconUrl();
            clearTitleType();
            clearIsOld();
            clearStartPointSubTitle();
            clearEndPointSubTitle();
            clearTripDesc();
            clearRepeatType();
            clearRepeatDeadline();
            clearSrcFrom();
            clearIsWholeday();
            this.aX = -1;
            return this;
        }

        public MLTrip clearArrivalTime() {
            this.f15337m = false;
            this.f15338n = 0;
            return this;
        }

        public MLTrip clearCardResource() {
            this.f15345u = false;
            this.f15346v = null;
            return this;
        }

        public MLTrip clearCostTime() {
            this.az = false;
            this.aA = "";
            return this;
        }

        public MLTrip clearCreateInfo() {
            this.f15347w = false;
            this.f15348x = null;
            return this;
        }

        public MLTrip clearDetailUrl() {
            this.f15311M = false;
            this.f15312N = "";
            return this;
        }

        public MLTrip clearEndPoint() {
            this.f15343s = false;
            this.f15344t = null;
            return this;
        }

        public MLTrip clearEndPointSubTitle() {
            this.aL = false;
            this.aM = "";
            return this;
        }

        public MLTrip clearEndPointTitle() {
            this.ax = false;
            this.ay = "";
            return this;
        }

        public MLTrip clearEventTripTitle() {
            this.aB = false;
            this.aC = "";
            return this;
        }

        public MLTrip clearFlightInfo() {
            this.f15309K = false;
            this.f15310L = null;
            return this;
        }

        public MLTrip clearGuideRemark() {
            this.f15305G = false;
            this.f15306H = "";
            return this;
        }

        public MLTrip clearIconInfo() {
            this.f15313O = false;
            this.f15314P = null;
            return this;
        }

        public MLTrip clearIsCross() {
            this.f15303E = false;
            this.f15304F = 0;
            return this;
        }

        public MLTrip clearIsOld() {
            this.aH = false;
            this.aI = 0;
            return this;
        }

        public MLTrip clearIsRemind() {
            this.f15335k = false;
            this.f15336l = 0;
            return this;
        }

        public MLTrip clearIsRepeat() {
            this.ad = false;
            this.ae = 0;
            return this;
        }

        public MLTrip clearIsShowRouteMap() {
            this.aa = false;
            this.ab = 0;
            return this;
        }

        public MLTrip clearIsWholeday() {
            this.aV = false;
            this.aW = 0;
            return this;
        }

        public MLTrip clearJumpContent() {
            this.ar = false;
            this.as = "";
            return this;
        }

        public MLTrip clearJumpUrl() {
            this.at = false;
            this.au = "";
            return this;
        }

        public MLTrip clearRemark() {
            this.f15329e = false;
            this.f15330f = "";
            return this;
        }

        public MLTrip clearRepeatDeadline() {
            this.aR = false;
            this.aS = 0;
            return this;
        }

        public MLTrip clearRepeatTimestamp() {
            this.ah = false;
            this.ai = 0;
            return this;
        }

        public MLTrip clearRepeatType() {
            this.aP = false;
            this.aQ = "";
            return this;
        }

        public MLTrip clearRouteInfo() {
            this.f15339o = false;
            this.f15340p = "";
            return this;
        }

        public MLTrip clearSrcFrom() {
            this.aT = false;
            this.aU = "";
            return this;
        }

        public MLTrip clearStartPoint() {
            this.f15341q = false;
            this.f15342r = null;
            return this;
        }

        public MLTrip clearStartPointSubTitle() {
            this.aJ = false;
            this.aK = "";
            return this;
        }

        public MLTrip clearStartPointTitle() {
            this.av = false;
            this.aw = "";
            return this;
        }

        public MLTrip clearStartTime() {
            this.f15299A = false;
            this.f15300B = 0;
            return this;
        }

        public MLTrip clearStatus() {
            this.f15331g = false;
            this.f15332h = 0;
            return this;
        }

        public MLTrip clearSubTripType() {
            this.af = false;
            this.ag = 0;
            return this;
        }

        public MLTrip clearSugCard() {
            this.ac = Collections.emptyList();
            return this;
        }

        public MLTrip clearSugTime() {
            this.f15333i = false;
            this.f15334j = 0;
            return this;
        }

        public MLTrip clearTimeType() {
            this.f15301C = false;
            this.f15302D = 0;
            return this;
        }

        public MLTrip clearTitle() {
            this.f15327c = false;
            this.f15328d = "";
            return this;
        }

        public MLTrip clearTitleType() {
            this.aF = false;
            this.aG = "";
            return this;
        }

        public MLTrip clearTitleUrl() {
            this.aj = false;
            this.ak = "";
            return this;
        }

        public MLTrip clearTrainInfo() {
            this.f15307I = false;
            this.f15308J = null;
            return this;
        }

        public MLTrip clearTripAddrTitle() {
            this.f15317S = false;
            this.f15318T = "";
            return this;
        }

        public MLTrip clearTripCardTitle() {
            this.f15315Q = false;
            this.f15316R = "";
            return this;
        }

        public MLTrip clearTripDesc() {
            this.aN = false;
            this.aO = "";
            return this;
        }

        public MLTrip clearTripEndtimeContent() {
            this.ap = false;
            this.aq = "";
            return this;
        }

        public MLTrip clearTripIconUrl() {
            this.f15323Y = false;
            this.f15324Z = "";
            return this;
        }

        public MLTrip clearTripId() {
            this.f15325a = false;
            this.f15326b = "";
            return this;
        }

        public MLTrip clearTripNewIconUrl() {
            this.aD = false;
            this.aE = "";
            return this;
        }

        public MLTrip clearTripRouteTitle() {
            this.f15321W = false;
            this.f15322X = "";
            return this;
        }

        public MLTrip clearTripStarttimeContent() {
            this.an = false;
            this.ao = "";
            return this;
        }

        public MLTrip clearTripTimeContent() {
            this.al = false;
            this.am = "";
            return this;
        }

        public MLTrip clearTripTimeTitle() {
            this.f15319U = false;
            this.f15320V = "";
            return this;
        }

        public MLTrip clearTripType() {
            this.f15349y = false;
            this.f15350z = 0;
            return this;
        }

        public long getArrivalTime() {
            return this.f15338n;
        }

        public int getCachedSize() {
            if (this.aX < 0) {
                getSerializedSize();
            }
            return this.aX;
        }

        public MLTripCardResource getCardResource() {
            return this.f15346v;
        }

        public String getCostTime() {
            return this.aA;
        }

        public MLTripCreateInfo getCreateInfo() {
            return this.f15348x;
        }

        public String getDetailUrl() {
            return this.f15312N;
        }

        public MLTripPoint getEndPoint() {
            return this.f15344t;
        }

        public String getEndPointSubTitle() {
            return this.aM;
        }

        public String getEndPointTitle() {
            return this.ay;
        }

        public String getEventTripTitle() {
            return this.aC;
        }

        public MLTripFlightInfo getFlightInfo() {
            return this.f15310L;
        }

        public String getGuideRemark() {
            return this.f15306H;
        }

        public MLTripCardIconInfo getIconInfo() {
            return this.f15314P;
        }

        public int getIsCross() {
            return this.f15304F;
        }

        public int getIsOld() {
            return this.aI;
        }

        public int getIsRemind() {
            return this.f15336l;
        }

        public int getIsRepeat() {
            return this.ae;
        }

        public int getIsShowRouteMap() {
            return this.ab;
        }

        public int getIsWholeday() {
            return this.aW;
        }

        public String getJumpContent() {
            return this.as;
        }

        public String getJumpUrl() {
            return this.au;
        }

        public String getRemark() {
            return this.f15330f;
        }

        public long getRepeatDeadline() {
            return this.aS;
        }

        public long getRepeatTimestamp() {
            return this.ai;
        }

        public String getRepeatType() {
            return this.aQ;
        }

        public String getRouteInfo() {
            return this.f15340p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTripId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getRemark());
            }
            if (hasStatus()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getStatus());
            }
            if (hasSugTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(5, getSugTime());
            }
            if (hasIsRemind()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getIsRemind());
            }
            if (hasArrivalTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(7, getArrivalTime());
            }
            if (hasRouteInfo()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getRouteInfo());
            }
            if (hasStartPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(9, getStartPoint());
            }
            if (hasEndPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(10, getEndPoint());
            }
            if (hasCardResource()) {
                i += CodedOutputStreamMicro.computeMessageSize(11, getCardResource());
            }
            if (hasCreateInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(12, getCreateInfo());
            }
            if (hasTripType()) {
                i += CodedOutputStreamMicro.computeInt64Size(13, getTripType());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(14, getStartTime());
            }
            if (hasTimeType()) {
                i += CodedOutputStreamMicro.computeInt64Size(15, getTimeType());
            }
            if (hasIsCross()) {
                i += CodedOutputStreamMicro.computeInt32Size(16, getIsCross());
            }
            if (hasGuideRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(17, getGuideRemark());
            }
            if (hasTrainInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(18, getTrainInfo());
            }
            if (hasFlightInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(19, getFlightInfo());
            }
            if (hasDetailUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getDetailUrl());
            }
            if (hasIconInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(21, getIconInfo());
            }
            if (hasTripCardTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(22, getTripCardTitle());
            }
            if (hasTripAddrTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(23, getTripAddrTitle());
            }
            if (hasTripTimeTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(24, getTripTimeTitle());
            }
            if (hasTripRouteTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(25, getTripRouteTitle());
            }
            if (hasTripIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(26, getTripIconUrl());
            }
            if (hasIsShowRouteMap()) {
                i += CodedOutputStreamMicro.computeInt32Size(27, getIsShowRouteMap());
            }
            int i2 = i;
            for (MLTripSugInfo computeMessageSize : getSugCardList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(28, computeMessageSize) + i2;
            }
            if (hasIsRepeat()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(29, getIsRepeat());
            }
            if (hasSubTripType()) {
                i2 += CodedOutputStreamMicro.computeInt64Size(30, getSubTripType());
            }
            if (hasRepeatTimestamp()) {
                i2 += CodedOutputStreamMicro.computeInt64Size(31, getRepeatTimestamp());
            }
            if (hasTitleUrl()) {
                i2 += CodedOutputStreamMicro.computeStringSize(32, getTitleUrl());
            }
            if (hasTripTimeContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(33, getTripTimeContent());
            }
            if (hasTripStarttimeContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(34, getTripStarttimeContent());
            }
            if (hasTripEndtimeContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(35, getTripEndtimeContent());
            }
            if (hasJumpContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(36, getJumpContent());
            }
            if (hasJumpUrl()) {
                i2 += CodedOutputStreamMicro.computeStringSize(37, getJumpUrl());
            }
            if (hasStartPointTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(38, getStartPointTitle());
            }
            if (hasEndPointTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(39, getEndPointTitle());
            }
            if (hasCostTime()) {
                i2 += CodedOutputStreamMicro.computeStringSize(40, getCostTime());
            }
            if (hasEventTripTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(41, getEventTripTitle());
            }
            if (hasTripNewIconUrl()) {
                i2 += CodedOutputStreamMicro.computeStringSize(42, getTripNewIconUrl());
            }
            if (hasTitleType()) {
                i2 += CodedOutputStreamMicro.computeStringSize(43, getTitleType());
            }
            if (hasIsOld()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(44, getIsOld());
            }
            if (hasStartPointSubTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(45, getStartPointSubTitle());
            }
            if (hasEndPointSubTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(46, getEndPointSubTitle());
            }
            if (hasTripDesc()) {
                i2 += CodedOutputStreamMicro.computeStringSize(47, getTripDesc());
            }
            if (hasRepeatType()) {
                i2 += CodedOutputStreamMicro.computeStringSize(48, getRepeatType());
            }
            if (hasRepeatDeadline()) {
                i2 += CodedOutputStreamMicro.computeInt64Size(49, getRepeatDeadline());
            }
            if (hasSrcFrom()) {
                i2 += CodedOutputStreamMicro.computeStringSize(50, getSrcFrom());
            }
            if (hasIsWholeday()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(51, getIsWholeday());
            }
            this.aX = i2;
            return i2;
        }

        public String getSrcFrom() {
            return this.aU;
        }

        public MLTripPoint getStartPoint() {
            return this.f15342r;
        }

        public String getStartPointSubTitle() {
            return this.aK;
        }

        public String getStartPointTitle() {
            return this.aw;
        }

        public long getStartTime() {
            return this.f15300B;
        }

        public int getStatus() {
            return this.f15332h;
        }

        public long getSubTripType() {
            return this.ag;
        }

        public MLTripSugInfo getSugCard(int i) {
            return (MLTripSugInfo) this.ac.get(i);
        }

        public int getSugCardCount() {
            return this.ac.size();
        }

        public List<MLTripSugInfo> getSugCardList() {
            return this.ac;
        }

        public long getSugTime() {
            return this.f15334j;
        }

        public long getTimeType() {
            return this.f15302D;
        }

        public String getTitle() {
            return this.f15328d;
        }

        public String getTitleType() {
            return this.aG;
        }

        public String getTitleUrl() {
            return this.ak;
        }

        public MLTripTrainInfo getTrainInfo() {
            return this.f15308J;
        }

        public String getTripAddrTitle() {
            return this.f15318T;
        }

        public String getTripCardTitle() {
            return this.f15316R;
        }

        public String getTripDesc() {
            return this.aO;
        }

        public String getTripEndtimeContent() {
            return this.aq;
        }

        public String getTripIconUrl() {
            return this.f15324Z;
        }

        public String getTripId() {
            return this.f15326b;
        }

        public String getTripNewIconUrl() {
            return this.aE;
        }

        public String getTripRouteTitle() {
            return this.f15322X;
        }

        public String getTripStarttimeContent() {
            return this.ao;
        }

        public String getTripTimeContent() {
            return this.am;
        }

        public String getTripTimeTitle() {
            return this.f15320V;
        }

        public long getTripType() {
            return this.f15350z;
        }

        public boolean hasArrivalTime() {
            return this.f15337m;
        }

        public boolean hasCardResource() {
            return this.f15345u;
        }

        public boolean hasCostTime() {
            return this.az;
        }

        public boolean hasCreateInfo() {
            return this.f15347w;
        }

        public boolean hasDetailUrl() {
            return this.f15311M;
        }

        public boolean hasEndPoint() {
            return this.f15343s;
        }

        public boolean hasEndPointSubTitle() {
            return this.aL;
        }

        public boolean hasEndPointTitle() {
            return this.ax;
        }

        public boolean hasEventTripTitle() {
            return this.aB;
        }

        public boolean hasFlightInfo() {
            return this.f15309K;
        }

        public boolean hasGuideRemark() {
            return this.f15305G;
        }

        public boolean hasIconInfo() {
            return this.f15313O;
        }

        public boolean hasIsCross() {
            return this.f15303E;
        }

        public boolean hasIsOld() {
            return this.aH;
        }

        public boolean hasIsRemind() {
            return this.f15335k;
        }

        public boolean hasIsRepeat() {
            return this.ad;
        }

        public boolean hasIsShowRouteMap() {
            return this.aa;
        }

        public boolean hasIsWholeday() {
            return this.aV;
        }

        public boolean hasJumpContent() {
            return this.ar;
        }

        public boolean hasJumpUrl() {
            return this.at;
        }

        public boolean hasRemark() {
            return this.f15329e;
        }

        public boolean hasRepeatDeadline() {
            return this.aR;
        }

        public boolean hasRepeatTimestamp() {
            return this.ah;
        }

        public boolean hasRepeatType() {
            return this.aP;
        }

        public boolean hasRouteInfo() {
            return this.f15339o;
        }

        public boolean hasSrcFrom() {
            return this.aT;
        }

        public boolean hasStartPoint() {
            return this.f15341q;
        }

        public boolean hasStartPointSubTitle() {
            return this.aJ;
        }

        public boolean hasStartPointTitle() {
            return this.av;
        }

        public boolean hasStartTime() {
            return this.f15299A;
        }

        public boolean hasStatus() {
            return this.f15331g;
        }

        public boolean hasSubTripType() {
            return this.af;
        }

        public boolean hasSugTime() {
            return this.f15333i;
        }

        public boolean hasTimeType() {
            return this.f15301C;
        }

        public boolean hasTitle() {
            return this.f15327c;
        }

        public boolean hasTitleType() {
            return this.aF;
        }

        public boolean hasTitleUrl() {
            return this.aj;
        }

        public boolean hasTrainInfo() {
            return this.f15307I;
        }

        public boolean hasTripAddrTitle() {
            return this.f15317S;
        }

        public boolean hasTripCardTitle() {
            return this.f15315Q;
        }

        public boolean hasTripDesc() {
            return this.aN;
        }

        public boolean hasTripEndtimeContent() {
            return this.ap;
        }

        public boolean hasTripIconUrl() {
            return this.f15323Y;
        }

        public boolean hasTripId() {
            return this.f15325a;
        }

        public boolean hasTripNewIconUrl() {
            return this.aD;
        }

        public boolean hasTripRouteTitle() {
            return this.f15321W;
        }

        public boolean hasTripStarttimeContent() {
            return this.an;
        }

        public boolean hasTripTimeContent() {
            return this.al;
        }

        public boolean hasTripTimeTitle() {
            return this.f15319U;
        }

        public boolean hasTripType() {
            return this.f15349y;
        }

        public final boolean isInitialized() {
            if (!this.f15325a) {
                return false;
            }
            if (!this.f15327c) {
                return false;
            }
            if (!this.f15329e) {
                return false;
            }
            if (!this.f15331g) {
                return false;
            }
            if (!this.f15333i) {
                return false;
            }
            if (!this.f15335k) {
                return false;
            }
            if (!this.f15337m) {
                return false;
            }
            if (!this.f15339o) {
                return false;
            }
            if (!this.f15341q) {
                return false;
            }
            if (!this.f15343s) {
                return false;
            }
            if (!this.f15345u) {
                return false;
            }
            if (!this.f15347w) {
                return false;
            }
            if (!getStartPoint().isInitialized()) {
                return false;
            }
            if (!getEndPoint().isInitialized()) {
                return false;
            }
            if (!getCardResource().isInitialized()) {
                return false;
            }
            if (!getCreateInfo().isInitialized()) {
                return false;
            }
            for (MLTripSugInfo isInitialized : getSugCardList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public MLTrip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro mLTripPoint;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTripId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setRemark(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setStatus(codedInputStreamMicro.readInt32());
                        continue;
                    case 40:
                        setSugTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 48:
                        setIsRemind(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setArrivalTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 66:
                        setRouteInfo(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        mLTripPoint = new MLTripPoint();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setStartPoint(mLTripPoint);
                        continue;
                    case 82:
                        mLTripPoint = new MLTripPoint();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setEndPoint(mLTripPoint);
                        continue;
                    case 90:
                        mLTripPoint = new MLTripCardResource();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setCardResource(mLTripPoint);
                        continue;
                    case 98:
                        mLTripPoint = new MLTripCreateInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setCreateInfo(mLTripPoint);
                        continue;
                    case 104:
                        setTripType(codedInputStreamMicro.readInt64());
                        continue;
                    case 112:
                        setStartTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 120:
                        setTimeType(codedInputStreamMicro.readInt64());
                        continue;
                    case 128:
                        setIsCross(codedInputStreamMicro.readInt32());
                        continue;
                    case 138:
                        setGuideRemark(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        mLTripPoint = new MLTripTrainInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setTrainInfo(mLTripPoint);
                        continue;
                    case 154:
                        mLTripPoint = new MLTripFlightInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setFlightInfo(mLTripPoint);
                        continue;
                    case 162:
                        setDetailUrl(codedInputStreamMicro.readString());
                        continue;
                    case 170:
                        mLTripPoint = new MLTripCardIconInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setIconInfo(mLTripPoint);
                        continue;
                    case 178:
                        setTripCardTitle(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        setTripAddrTitle(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        setTripTimeTitle(codedInputStreamMicro.readString());
                        continue;
                    case 202:
                        setTripRouteTitle(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ds /*210*/:
                        setTripIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 216:
                        setIsShowRouteMap(codedInputStreamMicro.readInt32());
                        continue;
                    case C1253f.dG /*226*/:
                        mLTripPoint = new MLTripSugInfo();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        addSugCard(mLTripPoint);
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_MODE_DAY /*232*/:
                        setIsRepeat(codedInputStreamMicro.readInt32());
                        continue;
                    case RGHUDDataModel.MAX_CAR_SPEED /*240*/:
                        setSubTripType(codedInputStreamMicro.readInt64());
                        continue;
                    case C1253f.dQ /*248*/:
                        setRepeatTimestamp(codedInputStreamMicro.readInt64());
                        continue;
                    case 258:
                        setTitleUrl(codedInputStreamMicro.readString());
                        continue;
                    case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                        setTripTimeContent(codedInputStreamMicro.readString());
                        continue;
                    case 274:
                        setTripStarttimeContent(codedInputStreamMicro.readString());
                        continue;
                    case 282:
                        setTripEndtimeContent(codedInputStreamMicro.readString());
                        continue;
                    case 290:
                        setJumpContent(codedInputStreamMicro.readString());
                        continue;
                    case 298:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 306:
                        setStartPointTitle(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.eb /*314*/:
                        setEndPointTitle(codedInputStreamMicro.readString());
                        continue;
                    case NaviFragmentManager.TYPE_VOICE_SQUARE /*322*/:
                        setCostTime(codedInputStreamMicro.readString());
                        continue;
                    case 330:
                        setEventTripTitle(codedInputStreamMicro.readString());
                        continue;
                    case 338:
                        setTripNewIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 346:
                        setTitleType(codedInputStreamMicro.readString());
                        continue;
                    case 352:
                        setIsOld(codedInputStreamMicro.readInt32());
                        continue;
                    case 362:
                        setStartPointSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 370:
                        setEndPointSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 378:
                        setTripDesc(codedInputStreamMicro.readString());
                        continue;
                    case 386:
                        setRepeatType(codedInputStreamMicro.readString());
                        continue;
                    case 392:
                        setRepeatDeadline(codedInputStreamMicro.readInt64());
                        continue;
                    case 402:
                        setSrcFrom(codedInputStreamMicro.readString());
                        continue;
                    case 408:
                        setIsWholeday(codedInputStreamMicro.readInt32());
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

        public MLTrip setArrivalTime(long j) {
            this.f15337m = true;
            this.f15338n = j;
            return this;
        }

        public MLTrip setCardResource(MLTripCardResource mLTripCardResource) {
            if (mLTripCardResource == null) {
                return clearCardResource();
            }
            this.f15345u = true;
            this.f15346v = mLTripCardResource;
            return this;
        }

        public MLTrip setCostTime(String str) {
            this.az = true;
            this.aA = str;
            return this;
        }

        public MLTrip setCreateInfo(MLTripCreateInfo mLTripCreateInfo) {
            if (mLTripCreateInfo == null) {
                return clearCreateInfo();
            }
            this.f15347w = true;
            this.f15348x = mLTripCreateInfo;
            return this;
        }

        public MLTrip setDetailUrl(String str) {
            this.f15311M = true;
            this.f15312N = str;
            return this;
        }

        public MLTrip setEndPoint(MLTripPoint mLTripPoint) {
            if (mLTripPoint == null) {
                return clearEndPoint();
            }
            this.f15343s = true;
            this.f15344t = mLTripPoint;
            return this;
        }

        public MLTrip setEndPointSubTitle(String str) {
            this.aL = true;
            this.aM = str;
            return this;
        }

        public MLTrip setEndPointTitle(String str) {
            this.ax = true;
            this.ay = str;
            return this;
        }

        public MLTrip setEventTripTitle(String str) {
            this.aB = true;
            this.aC = str;
            return this;
        }

        public MLTrip setFlightInfo(MLTripFlightInfo mLTripFlightInfo) {
            if (mLTripFlightInfo == null) {
                return clearFlightInfo();
            }
            this.f15309K = true;
            this.f15310L = mLTripFlightInfo;
            return this;
        }

        public MLTrip setGuideRemark(String str) {
            this.f15305G = true;
            this.f15306H = str;
            return this;
        }

        public MLTrip setIconInfo(MLTripCardIconInfo mLTripCardIconInfo) {
            if (mLTripCardIconInfo == null) {
                return clearIconInfo();
            }
            this.f15313O = true;
            this.f15314P = mLTripCardIconInfo;
            return this;
        }

        public MLTrip setIsCross(int i) {
            this.f15303E = true;
            this.f15304F = i;
            return this;
        }

        public MLTrip setIsOld(int i) {
            this.aH = true;
            this.aI = i;
            return this;
        }

        public MLTrip setIsRemind(int i) {
            this.f15335k = true;
            this.f15336l = i;
            return this;
        }

        public MLTrip setIsRepeat(int i) {
            this.ad = true;
            this.ae = i;
            return this;
        }

        public MLTrip setIsShowRouteMap(int i) {
            this.aa = true;
            this.ab = i;
            return this;
        }

        public MLTrip setIsWholeday(int i) {
            this.aV = true;
            this.aW = i;
            return this;
        }

        public MLTrip setJumpContent(String str) {
            this.ar = true;
            this.as = str;
            return this;
        }

        public MLTrip setJumpUrl(String str) {
            this.at = true;
            this.au = str;
            return this;
        }

        public MLTrip setRemark(String str) {
            this.f15329e = true;
            this.f15330f = str;
            return this;
        }

        public MLTrip setRepeatDeadline(long j) {
            this.aR = true;
            this.aS = j;
            return this;
        }

        public MLTrip setRepeatTimestamp(long j) {
            this.ah = true;
            this.ai = j;
            return this;
        }

        public MLTrip setRepeatType(String str) {
            this.aP = true;
            this.aQ = str;
            return this;
        }

        public MLTrip setRouteInfo(String str) {
            this.f15339o = true;
            this.f15340p = str;
            return this;
        }

        public MLTrip setSrcFrom(String str) {
            this.aT = true;
            this.aU = str;
            return this;
        }

        public MLTrip setStartPoint(MLTripPoint mLTripPoint) {
            if (mLTripPoint == null) {
                return clearStartPoint();
            }
            this.f15341q = true;
            this.f15342r = mLTripPoint;
            return this;
        }

        public MLTrip setStartPointSubTitle(String str) {
            this.aJ = true;
            this.aK = str;
            return this;
        }

        public MLTrip setStartPointTitle(String str) {
            this.av = true;
            this.aw = str;
            return this;
        }

        public MLTrip setStartTime(long j) {
            this.f15299A = true;
            this.f15300B = j;
            return this;
        }

        public MLTrip setStatus(int i) {
            this.f15331g = true;
            this.f15332h = i;
            return this;
        }

        public MLTrip setSubTripType(long j) {
            this.af = true;
            this.ag = j;
            return this;
        }

        public MLTrip setSugCard(int i, MLTripSugInfo mLTripSugInfo) {
            if (mLTripSugInfo != null) {
                this.ac.set(i, mLTripSugInfo);
            }
            return this;
        }

        public MLTrip setSugTime(long j) {
            this.f15333i = true;
            this.f15334j = j;
            return this;
        }

        public MLTrip setTimeType(long j) {
            this.f15301C = true;
            this.f15302D = j;
            return this;
        }

        public MLTrip setTitle(String str) {
            this.f15327c = true;
            this.f15328d = str;
            return this;
        }

        public MLTrip setTitleType(String str) {
            this.aF = true;
            this.aG = str;
            return this;
        }

        public MLTrip setTitleUrl(String str) {
            this.aj = true;
            this.ak = str;
            return this;
        }

        public MLTrip setTrainInfo(MLTripTrainInfo mLTripTrainInfo) {
            if (mLTripTrainInfo == null) {
                return clearTrainInfo();
            }
            this.f15307I = true;
            this.f15308J = mLTripTrainInfo;
            return this;
        }

        public MLTrip setTripAddrTitle(String str) {
            this.f15317S = true;
            this.f15318T = str;
            return this;
        }

        public MLTrip setTripCardTitle(String str) {
            this.f15315Q = true;
            this.f15316R = str;
            return this;
        }

        public MLTrip setTripDesc(String str) {
            this.aN = true;
            this.aO = str;
            return this;
        }

        public MLTrip setTripEndtimeContent(String str) {
            this.ap = true;
            this.aq = str;
            return this;
        }

        public MLTrip setTripIconUrl(String str) {
            this.f15323Y = true;
            this.f15324Z = str;
            return this;
        }

        public MLTrip setTripId(String str) {
            this.f15325a = true;
            this.f15326b = str;
            return this;
        }

        public MLTrip setTripNewIconUrl(String str) {
            this.aD = true;
            this.aE = str;
            return this;
        }

        public MLTrip setTripRouteTitle(String str) {
            this.f15321W = true;
            this.f15322X = str;
            return this;
        }

        public MLTrip setTripStarttimeContent(String str) {
            this.an = true;
            this.ao = str;
            return this;
        }

        public MLTrip setTripTimeContent(String str) {
            this.al = true;
            this.am = str;
            return this;
        }

        public MLTrip setTripTimeTitle(String str) {
            this.f15319U = true;
            this.f15320V = str;
            return this;
        }

        public MLTrip setTripType(long j) {
            this.f15349y = true;
            this.f15350z = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTripId()) {
                codedOutputStreamMicro.writeString(1, getTripId());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(3, getRemark());
            }
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(4, getStatus());
            }
            if (hasSugTime()) {
                codedOutputStreamMicro.writeInt64(5, getSugTime());
            }
            if (hasIsRemind()) {
                codedOutputStreamMicro.writeInt32(6, getIsRemind());
            }
            if (hasArrivalTime()) {
                codedOutputStreamMicro.writeInt64(7, getArrivalTime());
            }
            if (hasRouteInfo()) {
                codedOutputStreamMicro.writeString(8, getRouteInfo());
            }
            if (hasStartPoint()) {
                codedOutputStreamMicro.writeMessage(9, getStartPoint());
            }
            if (hasEndPoint()) {
                codedOutputStreamMicro.writeMessage(10, getEndPoint());
            }
            if (hasCardResource()) {
                codedOutputStreamMicro.writeMessage(11, getCardResource());
            }
            if (hasCreateInfo()) {
                codedOutputStreamMicro.writeMessage(12, getCreateInfo());
            }
            if (hasTripType()) {
                codedOutputStreamMicro.writeInt64(13, getTripType());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeInt64(14, getStartTime());
            }
            if (hasTimeType()) {
                codedOutputStreamMicro.writeInt64(15, getTimeType());
            }
            if (hasIsCross()) {
                codedOutputStreamMicro.writeInt32(16, getIsCross());
            }
            if (hasGuideRemark()) {
                codedOutputStreamMicro.writeString(17, getGuideRemark());
            }
            if (hasTrainInfo()) {
                codedOutputStreamMicro.writeMessage(18, getTrainInfo());
            }
            if (hasFlightInfo()) {
                codedOutputStreamMicro.writeMessage(19, getFlightInfo());
            }
            if (hasDetailUrl()) {
                codedOutputStreamMicro.writeString(20, getDetailUrl());
            }
            if (hasIconInfo()) {
                codedOutputStreamMicro.writeMessage(21, getIconInfo());
            }
            if (hasTripCardTitle()) {
                codedOutputStreamMicro.writeString(22, getTripCardTitle());
            }
            if (hasTripAddrTitle()) {
                codedOutputStreamMicro.writeString(23, getTripAddrTitle());
            }
            if (hasTripTimeTitle()) {
                codedOutputStreamMicro.writeString(24, getTripTimeTitle());
            }
            if (hasTripRouteTitle()) {
                codedOutputStreamMicro.writeString(25, getTripRouteTitle());
            }
            if (hasTripIconUrl()) {
                codedOutputStreamMicro.writeString(26, getTripIconUrl());
            }
            if (hasIsShowRouteMap()) {
                codedOutputStreamMicro.writeInt32(27, getIsShowRouteMap());
            }
            for (MLTripSugInfo writeMessage : getSugCardList()) {
                codedOutputStreamMicro.writeMessage(28, writeMessage);
            }
            if (hasIsRepeat()) {
                codedOutputStreamMicro.writeInt32(29, getIsRepeat());
            }
            if (hasSubTripType()) {
                codedOutputStreamMicro.writeInt64(30, getSubTripType());
            }
            if (hasRepeatTimestamp()) {
                codedOutputStreamMicro.writeInt64(31, getRepeatTimestamp());
            }
            if (hasTitleUrl()) {
                codedOutputStreamMicro.writeString(32, getTitleUrl());
            }
            if (hasTripTimeContent()) {
                codedOutputStreamMicro.writeString(33, getTripTimeContent());
            }
            if (hasTripStarttimeContent()) {
                codedOutputStreamMicro.writeString(34, getTripStarttimeContent());
            }
            if (hasTripEndtimeContent()) {
                codedOutputStreamMicro.writeString(35, getTripEndtimeContent());
            }
            if (hasJumpContent()) {
                codedOutputStreamMicro.writeString(36, getJumpContent());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(37, getJumpUrl());
            }
            if (hasStartPointTitle()) {
                codedOutputStreamMicro.writeString(38, getStartPointTitle());
            }
            if (hasEndPointTitle()) {
                codedOutputStreamMicro.writeString(39, getEndPointTitle());
            }
            if (hasCostTime()) {
                codedOutputStreamMicro.writeString(40, getCostTime());
            }
            if (hasEventTripTitle()) {
                codedOutputStreamMicro.writeString(41, getEventTripTitle());
            }
            if (hasTripNewIconUrl()) {
                codedOutputStreamMicro.writeString(42, getTripNewIconUrl());
            }
            if (hasTitleType()) {
                codedOutputStreamMicro.writeString(43, getTitleType());
            }
            if (hasIsOld()) {
                codedOutputStreamMicro.writeInt32(44, getIsOld());
            }
            if (hasStartPointSubTitle()) {
                codedOutputStreamMicro.writeString(45, getStartPointSubTitle());
            }
            if (hasEndPointSubTitle()) {
                codedOutputStreamMicro.writeString(46, getEndPointSubTitle());
            }
            if (hasTripDesc()) {
                codedOutputStreamMicro.writeString(47, getTripDesc());
            }
            if (hasRepeatType()) {
                codedOutputStreamMicro.writeString(48, getRepeatType());
            }
            if (hasRepeatDeadline()) {
                codedOutputStreamMicro.writeInt64(49, getRepeatDeadline());
            }
            if (hasSrcFrom()) {
                codedOutputStreamMicro.writeString(50, getSrcFrom());
            }
            if (hasIsWholeday()) {
                codedOutputStreamMicro.writeInt32(51, getIsWholeday());
            }
        }
    }

    public static final class MLTripCardIconInfo extends MessageMicro {
        public static final int JUMP_URL_FIELD_NUMBER = 1;
        public static final int PHONE_FIELD_NUMBER = 4;
        public static final int SHOW_BUTTON_TITLE_FIELD_NUMBER = 3;
        public static final int SHOW_TYPE_FIELD_NUMBER = 5;
        public static final int SHOW_URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15351a;
        /* renamed from: b */
        private String f15352b = "";
        /* renamed from: c */
        private boolean f15353c;
        /* renamed from: d */
        private String f15354d = "";
        /* renamed from: e */
        private boolean f15355e;
        /* renamed from: f */
        private String f15356f = "";
        /* renamed from: g */
        private boolean f15357g;
        /* renamed from: h */
        private String f15358h = "";
        /* renamed from: i */
        private boolean f15359i;
        /* renamed from: j */
        private int f15360j = 0;
        /* renamed from: k */
        private int f15361k = -1;

        public static MLTripCardIconInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripCardIconInfo().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripCardIconInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripCardIconInfo) new MLTripCardIconInfo().mergeFrom(bArr);
        }

        public final MLTripCardIconInfo clear() {
            clearJumpUrl();
            clearShowUrl();
            clearShowButtonTitle();
            clearPhone();
            clearShowType();
            this.f15361k = -1;
            return this;
        }

        public MLTripCardIconInfo clearJumpUrl() {
            this.f15351a = false;
            this.f15352b = "";
            return this;
        }

        public MLTripCardIconInfo clearPhone() {
            this.f15357g = false;
            this.f15358h = "";
            return this;
        }

        public MLTripCardIconInfo clearShowButtonTitle() {
            this.f15355e = false;
            this.f15356f = "";
            return this;
        }

        public MLTripCardIconInfo clearShowType() {
            this.f15359i = false;
            this.f15360j = 0;
            return this;
        }

        public MLTripCardIconInfo clearShowUrl() {
            this.f15353c = false;
            this.f15354d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15361k < 0) {
                getSerializedSize();
            }
            return this.f15361k;
        }

        public String getJumpUrl() {
            return this.f15352b;
        }

        public String getPhone() {
            return this.f15358h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasJumpUrl()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getJumpUrl());
            }
            if (hasShowUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getShowUrl());
            }
            if (hasShowButtonTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getShowButtonTitle());
            }
            if (hasPhone()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getPhone());
            }
            if (hasShowType()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getShowType());
            }
            this.f15361k = i;
            return i;
        }

        public String getShowButtonTitle() {
            return this.f15356f;
        }

        public int getShowType() {
            return this.f15360j;
        }

        public String getShowUrl() {
            return this.f15354d;
        }

        public boolean hasJumpUrl() {
            return this.f15351a;
        }

        public boolean hasPhone() {
            return this.f15357g;
        }

        public boolean hasShowButtonTitle() {
            return this.f15355e;
        }

        public boolean hasShowType() {
            return this.f15359i;
        }

        public boolean hasShowUrl() {
            return this.f15353c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MLTripCardIconInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setShowUrl(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setShowButtonTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setPhone(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setShowType(codedInputStreamMicro.readInt32());
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

        public MLTripCardIconInfo setJumpUrl(String str) {
            this.f15351a = true;
            this.f15352b = str;
            return this;
        }

        public MLTripCardIconInfo setPhone(String str) {
            this.f15357g = true;
            this.f15358h = str;
            return this;
        }

        public MLTripCardIconInfo setShowButtonTitle(String str) {
            this.f15355e = true;
            this.f15356f = str;
            return this;
        }

        public MLTripCardIconInfo setShowType(int i) {
            this.f15359i = true;
            this.f15360j = i;
            return this;
        }

        public MLTripCardIconInfo setShowUrl(String str) {
            this.f15353c = true;
            this.f15354d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(1, getJumpUrl());
            }
            if (hasShowUrl()) {
                codedOutputStreamMicro.writeString(2, getShowUrl());
            }
            if (hasShowButtonTitle()) {
                codedOutputStreamMicro.writeString(3, getShowButtonTitle());
            }
            if (hasPhone()) {
                codedOutputStreamMicro.writeString(4, getPhone());
            }
            if (hasShowType()) {
                codedOutputStreamMicro.writeInt32(5, getShowType());
            }
        }
    }

    public static final class MLTripCardResource extends MessageMicro {
        public static final int ICON_DESC_FIELD_NUMBER = 2;
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int SUB_TITLE_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15362a;
        /* renamed from: b */
        private String f15363b = "";
        /* renamed from: c */
        private boolean f15364c;
        /* renamed from: d */
        private String f15365d = "";
        /* renamed from: e */
        private boolean f15366e;
        /* renamed from: f */
        private String f15367f = "";
        /* renamed from: g */
        private boolean f15368g;
        /* renamed from: h */
        private String f15369h = "";
        /* renamed from: i */
        private int f15370i = -1;

        public static MLTripCardResource parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripCardResource().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripCardResource parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripCardResource) new MLTripCardResource().mergeFrom(bArr);
        }

        public final MLTripCardResource clear() {
            clearIcon();
            clearIconDesc();
            clearTitle();
            clearSubTitle();
            this.f15370i = -1;
            return this;
        }

        public MLTripCardResource clearIcon() {
            this.f15362a = false;
            this.f15363b = "";
            return this;
        }

        public MLTripCardResource clearIconDesc() {
            this.f15364c = false;
            this.f15365d = "";
            return this;
        }

        public MLTripCardResource clearSubTitle() {
            this.f15368g = false;
            this.f15369h = "";
            return this;
        }

        public MLTripCardResource clearTitle() {
            this.f15366e = false;
            this.f15367f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15370i < 0) {
                getSerializedSize();
            }
            return this.f15370i;
        }

        public String getIcon() {
            return this.f15363b;
        }

        public String getIconDesc() {
            return this.f15365d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasIconDesc()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getIconDesc());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTitle());
            }
            if (hasSubTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getSubTitle());
            }
            this.f15370i = i;
            return i;
        }

        public String getSubTitle() {
            return this.f15369h;
        }

        public String getTitle() {
            return this.f15367f;
        }

        public boolean hasIcon() {
            return this.f15362a;
        }

        public boolean hasIconDesc() {
            return this.f15364c;
        }

        public boolean hasSubTitle() {
            return this.f15368g;
        }

        public boolean hasTitle() {
            return this.f15366e;
        }

        public final boolean isInitialized() {
            return this.f15362a && this.f15364c && this.f15366e && this.f15368g;
        }

        public MLTripCardResource mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setIconDesc(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setSubTitle(codedInputStreamMicro.readString());
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

        public MLTripCardResource setIcon(String str) {
            this.f15362a = true;
            this.f15363b = str;
            return this;
        }

        public MLTripCardResource setIconDesc(String str) {
            this.f15364c = true;
            this.f15365d = str;
            return this;
        }

        public MLTripCardResource setSubTitle(String str) {
            this.f15368g = true;
            this.f15369h = str;
            return this;
        }

        public MLTripCardResource setTitle(String str) {
            this.f15366e = true;
            this.f15367f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasIconDesc()) {
                codedOutputStreamMicro.writeString(2, getIconDesc());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(3, getTitle());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(4, getSubTitle());
            }
        }
    }

    public static final class MLTripCitySep extends MessageMicro {
        public static final int REMOTE_WEATHER_FIELD_NUMBER = 2;
        public static final int TEXT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15371a;
        /* renamed from: b */
        private String f15372b = "";
        /* renamed from: c */
        private boolean f15373c;
        /* renamed from: d */
        private MLWeahterSep f15374d = null;
        /* renamed from: e */
        private int f15375e = -1;

        public static MLTripCitySep parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripCitySep().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripCitySep parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripCitySep) new MLTripCitySep().mergeFrom(bArr);
        }

        public final MLTripCitySep clear() {
            clearText();
            clearRemoteWeather();
            this.f15375e = -1;
            return this;
        }

        public MLTripCitySep clearRemoteWeather() {
            this.f15373c = false;
            this.f15374d = null;
            return this;
        }

        public MLTripCitySep clearText() {
            this.f15371a = false;
            this.f15372b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15375e < 0) {
                getSerializedSize();
            }
            return this.f15375e;
        }

        public MLWeahterSep getRemoteWeather() {
            return this.f15374d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasText()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getText());
            }
            if (hasRemoteWeather()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getRemoteWeather());
            }
            this.f15375e = i;
            return i;
        }

        public String getText() {
            return this.f15372b;
        }

        public boolean hasRemoteWeather() {
            return this.f15373c;
        }

        public boolean hasText() {
            return this.f15371a;
        }

        public final boolean isInitialized() {
            return this.f15371a;
        }

        public MLTripCitySep mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setText(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro mLWeahterSep = new MLWeahterSep();
                        codedInputStreamMicro.readMessage(mLWeahterSep);
                        setRemoteWeather(mLWeahterSep);
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

        public MLTripCitySep setRemoteWeather(MLWeahterSep mLWeahterSep) {
            if (mLWeahterSep == null) {
                return clearRemoteWeather();
            }
            this.f15373c = true;
            this.f15374d = mLWeahterSep;
            return this;
        }

        public MLTripCitySep setText(String str) {
            this.f15371a = true;
            this.f15372b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasText()) {
                codedOutputStreamMicro.writeString(1, getText());
            }
            if (hasRemoteWeather()) {
                codedOutputStreamMicro.writeMessage(2, getRemoteWeather());
            }
        }
    }

    public static final class MLTripCitySepWeather extends MessageMicro {
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int JUMP_URL_FIELD_NUMBER = 5;
        public static final int PM25_FIELD_NUMBER = 4;
        public static final int SCHEME_FIELD_NUMBER = 3;
        public static final int TEXT_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15376a;
        /* renamed from: b */
        private String f15377b = "";
        /* renamed from: c */
        private boolean f15378c;
        /* renamed from: d */
        private String f15379d = "";
        /* renamed from: e */
        private boolean f15380e;
        /* renamed from: f */
        private String f15381f = "";
        /* renamed from: g */
        private boolean f15382g;
        /* renamed from: h */
        private String f15383h = "";
        /* renamed from: i */
        private boolean f15384i;
        /* renamed from: j */
        private String f15385j = "";
        /* renamed from: k */
        private int f15386k = -1;

        public static MLTripCitySepWeather parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripCitySepWeather().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripCitySepWeather parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripCitySepWeather) new MLTripCitySepWeather().mergeFrom(bArr);
        }

        public final MLTripCitySepWeather clear() {
            clearIcon();
            clearText();
            clearScheme();
            clearPm25();
            clearJumpUrl();
            this.f15386k = -1;
            return this;
        }

        public MLTripCitySepWeather clearIcon() {
            this.f15376a = false;
            this.f15377b = "";
            return this;
        }

        public MLTripCitySepWeather clearJumpUrl() {
            this.f15384i = false;
            this.f15385j = "";
            return this;
        }

        public MLTripCitySepWeather clearPm25() {
            this.f15382g = false;
            this.f15383h = "";
            return this;
        }

        public MLTripCitySepWeather clearScheme() {
            this.f15380e = false;
            this.f15381f = "";
            return this;
        }

        public MLTripCitySepWeather clearText() {
            this.f15378c = false;
            this.f15379d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15386k < 0) {
                getSerializedSize();
            }
            return this.f15386k;
        }

        public String getIcon() {
            return this.f15377b;
        }

        public String getJumpUrl() {
            return this.f15385j;
        }

        public String getPm25() {
            return this.f15383h;
        }

        public String getScheme() {
            return this.f15381f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getText());
            }
            if (hasScheme()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getScheme());
            }
            if (hasPm25()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getPm25());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getJumpUrl());
            }
            this.f15386k = i;
            return i;
        }

        public String getText() {
            return this.f15379d;
        }

        public boolean hasIcon() {
            return this.f15376a;
        }

        public boolean hasJumpUrl() {
            return this.f15384i;
        }

        public boolean hasPm25() {
            return this.f15382g;
        }

        public boolean hasScheme() {
            return this.f15380e;
        }

        public boolean hasText() {
            return this.f15378c;
        }

        public final boolean isInitialized() {
            return this.f15376a && this.f15378c;
        }

        public MLTripCitySepWeather mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setText(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setScheme(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setPm25(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setJumpUrl(codedInputStreamMicro.readString());
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

        public MLTripCitySepWeather setIcon(String str) {
            this.f15376a = true;
            this.f15377b = str;
            return this;
        }

        public MLTripCitySepWeather setJumpUrl(String str) {
            this.f15384i = true;
            this.f15385j = str;
            return this;
        }

        public MLTripCitySepWeather setPm25(String str) {
            this.f15382g = true;
            this.f15383h = str;
            return this;
        }

        public MLTripCitySepWeather setScheme(String str) {
            this.f15380e = true;
            this.f15381f = str;
            return this;
        }

        public MLTripCitySepWeather setText(String str) {
            this.f15378c = true;
            this.f15379d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeString(2, getText());
            }
            if (hasScheme()) {
                codedOutputStreamMicro.writeString(3, getScheme());
            }
            if (hasPm25()) {
                codedOutputStreamMicro.writeString(4, getPm25());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(5, getJumpUrl());
            }
        }
    }

    public static final class MLTripCreateInfo extends MessageMicro {
        public static final int CREATE_TYPE_FIELD_NUMBER = 1;
        public static final int ORDER_ID_FIELD_NUMBER = 2;
        public static final int ORDER_TYPE_FIELD_NUMBER = 4;
        public static final int ORDER_URL_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15387a;
        /* renamed from: b */
        private String f15388b = "";
        /* renamed from: c */
        private boolean f15389c;
        /* renamed from: d */
        private String f15390d = "";
        /* renamed from: e */
        private boolean f15391e;
        /* renamed from: f */
        private String f15392f = "";
        /* renamed from: g */
        private boolean f15393g;
        /* renamed from: h */
        private String f15394h = "";
        /* renamed from: i */
        private int f15395i = -1;

        public static MLTripCreateInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripCreateInfo().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripCreateInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripCreateInfo) new MLTripCreateInfo().mergeFrom(bArr);
        }

        public final MLTripCreateInfo clear() {
            clearCreateType();
            clearOrderId();
            clearOrderUrl();
            clearOrderType();
            this.f15395i = -1;
            return this;
        }

        public MLTripCreateInfo clearCreateType() {
            this.f15387a = false;
            this.f15388b = "";
            return this;
        }

        public MLTripCreateInfo clearOrderId() {
            this.f15389c = false;
            this.f15390d = "";
            return this;
        }

        public MLTripCreateInfo clearOrderType() {
            this.f15393g = false;
            this.f15394h = "";
            return this;
        }

        public MLTripCreateInfo clearOrderUrl() {
            this.f15391e = false;
            this.f15392f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15395i < 0) {
                getSerializedSize();
            }
            return this.f15395i;
        }

        public String getCreateType() {
            return this.f15388b;
        }

        public String getOrderId() {
            return this.f15390d;
        }

        public String getOrderType() {
            return this.f15394h;
        }

        public String getOrderUrl() {
            return this.f15392f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCreateType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCreateType());
            }
            if (hasOrderId()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getOrderId());
            }
            if (hasOrderUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getOrderUrl());
            }
            if (hasOrderType()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getOrderType());
            }
            this.f15395i = i;
            return i;
        }

        public boolean hasCreateType() {
            return this.f15387a;
        }

        public boolean hasOrderId() {
            return this.f15389c;
        }

        public boolean hasOrderType() {
            return this.f15393g;
        }

        public boolean hasOrderUrl() {
            return this.f15391e;
        }

        public final boolean isInitialized() {
            return this.f15387a;
        }

        public MLTripCreateInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCreateType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setOrderId(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setOrderUrl(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setOrderType(codedInputStreamMicro.readString());
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

        public MLTripCreateInfo setCreateType(String str) {
            this.f15387a = true;
            this.f15388b = str;
            return this;
        }

        public MLTripCreateInfo setOrderId(String str) {
            this.f15389c = true;
            this.f15390d = str;
            return this;
        }

        public MLTripCreateInfo setOrderType(String str) {
            this.f15393g = true;
            this.f15394h = str;
            return this;
        }

        public MLTripCreateInfo setOrderUrl(String str) {
            this.f15391e = true;
            this.f15392f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCreateType()) {
                codedOutputStreamMicro.writeString(1, getCreateType());
            }
            if (hasOrderId()) {
                codedOutputStreamMicro.writeString(2, getOrderId());
            }
            if (hasOrderUrl()) {
                codedOutputStreamMicro.writeString(3, getOrderUrl());
            }
            if (hasOrderType()) {
                codedOutputStreamMicro.writeString(4, getOrderType());
            }
        }
    }

    public static final class MLTripFlightInfo extends MessageMicro {
        public static final int ADD_FLIGHT_TYPE_FIELD_NUMBER = 1;
        public static final int AIRLINE_FIELD_NUMBER = 29;
        public static final int AIRLINE_URL_FIELD_NUMBER = 31;
        public static final int ARRIVAL_AIRPORT_CODE_FIELD_NUMBER = 7;
        public static final int ARRIVAL_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 18;
        public static final int ARRIVAL_AIRPORT_NAME_FIELD_NUMBER = 17;
        public static final int ARRIVAL_CITY_CODE_FIELD_NUMBER = 19;
        public static final int ARRIVAL_CITY_NAME_FIELD_NUMBER = 20;
        public static final int ARRIVAL_TERMINAL_NAME_FIELD_NUMBER = 10;
        public static final int ARRIVAL_TIME_FIELD_NUMBER = 6;
        public static final int ARRIVAL_TIME_STR_FIELD_NUMBER = 12;
        public static final int BAGGAGE_ID_FIELD_NUMBER = 24;
        public static final int BOARD_GATE_FIELD_NUMBER = 23;
        public static final int CHECKIN_TABLE_FIELD_NUMBER = 21;
        public static final int DEPART_AIRPORT_CODE_FIELD_NUMBER = 8;
        public static final int DEPART_AIRPORT_NAME_ABBREV_FIELD_NUMBER = 13;
        public static final int DEPART_AIRPORT_NAME_FIELD_NUMBER = 16;
        public static final int DEPART_CITY_CODE_FIELD_NUMBER = 14;
        public static final int DEPART_CITY_NAME_FIELD_NUMBER = 15;
        public static final int DEPART_TERMINAL_NAME_FIELD_NUMBER = 9;
        public static final int DEPART_TIME_FIELD_NUMBER = 5;
        public static final int DEPART_TIME_STR_FIELD_NUMBER = 11;
        public static final int END_AIRPORT_NAME_FIELD_NUMBER = 4;
        public static final int FLIGHT_NO_FIELD_NUMBER = 2;
        public static final int FLIGHT_STATE_FIELD_NUMBER = 22;
        public static final int IS_DELAY_FIELD_NUMBER = 30;
        public static final int SHARE_FLIGHTNO_FIELD_NUMBER = 25;
        public static final int START_AIRPORT_NAME_FIELD_NUMBER = 3;
        public static final int SUPPLIED_BY_FIELD_NUMBER = 28;
        public static final int VERY_ZHUN_READY_ARRTIME_DATE_FIELD_NUMBER = 27;
        public static final int VERY_ZHUN_READY_DEPTIME_DATE_FIELD_NUMBER = 26;
        /* renamed from: A */
        private boolean f15396A;
        /* renamed from: B */
        private String f15397B = "";
        /* renamed from: C */
        private boolean f15398C;
        /* renamed from: D */
        private String f15399D = "";
        /* renamed from: E */
        private boolean f15400E;
        /* renamed from: F */
        private String f15401F = "";
        /* renamed from: G */
        private boolean f15402G;
        /* renamed from: H */
        private String f15403H = "";
        /* renamed from: I */
        private boolean f15404I;
        /* renamed from: J */
        private String f15405J = "";
        /* renamed from: K */
        private boolean f15406K;
        /* renamed from: L */
        private String f15407L = "";
        /* renamed from: M */
        private boolean f15408M;
        /* renamed from: N */
        private String f15409N = "";
        /* renamed from: O */
        private boolean f15410O;
        /* renamed from: P */
        private String f15411P = "";
        /* renamed from: Q */
        private boolean f15412Q;
        /* renamed from: R */
        private String f15413R = "";
        /* renamed from: S */
        private boolean f15414S;
        /* renamed from: T */
        private String f15415T = "";
        /* renamed from: U */
        private boolean f15416U;
        /* renamed from: V */
        private String f15417V = "";
        /* renamed from: W */
        private boolean f15418W;
        /* renamed from: X */
        private String f15419X = "";
        /* renamed from: Y */
        private boolean f15420Y;
        /* renamed from: Z */
        private String f15421Z = "";
        /* renamed from: a */
        private boolean f15422a;
        private boolean aa;
        private String ab = "";
        private boolean ac;
        private String ad = "";
        private boolean ae;
        private String af = "";
        private boolean ag;
        private int ah = 0;
        private boolean ai;
        private String aj = "";
        private int ak = -1;
        /* renamed from: b */
        private long f15423b = 0;
        /* renamed from: c */
        private boolean f15424c;
        /* renamed from: d */
        private String f15425d = "";
        /* renamed from: e */
        private boolean f15426e;
        /* renamed from: f */
        private String f15427f = "";
        /* renamed from: g */
        private boolean f15428g;
        /* renamed from: h */
        private String f15429h = "";
        /* renamed from: i */
        private boolean f15430i;
        /* renamed from: j */
        private long f15431j = 0;
        /* renamed from: k */
        private boolean f15432k;
        /* renamed from: l */
        private long f15433l = 0;
        /* renamed from: m */
        private boolean f15434m;
        /* renamed from: n */
        private String f15435n = "";
        /* renamed from: o */
        private boolean f15436o;
        /* renamed from: p */
        private String f15437p = "";
        /* renamed from: q */
        private boolean f15438q;
        /* renamed from: r */
        private String f15439r = "";
        /* renamed from: s */
        private boolean f15440s;
        /* renamed from: t */
        private String f15441t = "";
        /* renamed from: u */
        private boolean f15442u;
        /* renamed from: v */
        private String f15443v = "";
        /* renamed from: w */
        private boolean f15444w;
        /* renamed from: x */
        private String f15445x = "";
        /* renamed from: y */
        private boolean f15446y;
        /* renamed from: z */
        private String f15447z = "";

        public static MLTripFlightInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripFlightInfo().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripFlightInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripFlightInfo) new MLTripFlightInfo().mergeFrom(bArr);
        }

        public final MLTripFlightInfo clear() {
            clearAddFlightType();
            clearFlightNo();
            clearStartAirportName();
            clearEndAirportName();
            clearDepartTime();
            clearArrivalTime();
            clearArrivalAirportCode();
            clearDepartAirportCode();
            clearDepartTerminalName();
            clearArrivalTerminalName();
            clearDepartTimeStr();
            clearArrivalTimeStr();
            clearDepartAirportNameAbbrev();
            clearDepartCityCode();
            clearDepartCityName();
            clearDepartAirportName();
            clearArrivalAirportName();
            clearArrivalAirportNameAbbrev();
            clearArrivalCityCode();
            clearArrivalCityName();
            clearCheckinTable();
            clearFlightState();
            clearBoardGate();
            clearBaggageId();
            clearShareFlightNo();
            clearVeryZhunReadyDeptimeDate();
            clearVeryZhunReadyArrtimeDate();
            clearSuppliedBy();
            clearAirline();
            clearIsDelay();
            clearAirlineUrl();
            this.ak = -1;
            return this;
        }

        public MLTripFlightInfo clearAddFlightType() {
            this.f15422a = false;
            this.f15423b = 0;
            return this;
        }

        public MLTripFlightInfo clearAirline() {
            this.ae = false;
            this.af = "";
            return this;
        }

        public MLTripFlightInfo clearAirlineUrl() {
            this.ai = false;
            this.aj = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalAirportCode() {
            this.f15434m = false;
            this.f15435n = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalAirportName() {
            this.f15402G = false;
            this.f15403H = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalAirportNameAbbrev() {
            this.f15404I = false;
            this.f15405J = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalCityCode() {
            this.f15406K = false;
            this.f15407L = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalCityName() {
            this.f15408M = false;
            this.f15409N = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalTerminalName() {
            this.f15440s = false;
            this.f15441t = "";
            return this;
        }

        public MLTripFlightInfo clearArrivalTime() {
            this.f15432k = false;
            this.f15433l = 0;
            return this;
        }

        public MLTripFlightInfo clearArrivalTimeStr() {
            this.f15444w = false;
            this.f15445x = "";
            return this;
        }

        public MLTripFlightInfo clearBaggageId() {
            this.f15416U = false;
            this.f15417V = "";
            return this;
        }

        public MLTripFlightInfo clearBoardGate() {
            this.f15414S = false;
            this.f15415T = "";
            return this;
        }

        public MLTripFlightInfo clearCheckinTable() {
            this.f15410O = false;
            this.f15411P = "";
            return this;
        }

        public MLTripFlightInfo clearDepartAirportCode() {
            this.f15436o = false;
            this.f15437p = "";
            return this;
        }

        public MLTripFlightInfo clearDepartAirportName() {
            this.f15400E = false;
            this.f15401F = "";
            return this;
        }

        public MLTripFlightInfo clearDepartAirportNameAbbrev() {
            this.f15446y = false;
            this.f15447z = "";
            return this;
        }

        public MLTripFlightInfo clearDepartCityCode() {
            this.f15396A = false;
            this.f15397B = "";
            return this;
        }

        public MLTripFlightInfo clearDepartCityName() {
            this.f15398C = false;
            this.f15399D = "";
            return this;
        }

        public MLTripFlightInfo clearDepartTerminalName() {
            this.f15438q = false;
            this.f15439r = "";
            return this;
        }

        public MLTripFlightInfo clearDepartTime() {
            this.f15430i = false;
            this.f15431j = 0;
            return this;
        }

        public MLTripFlightInfo clearDepartTimeStr() {
            this.f15442u = false;
            this.f15443v = "";
            return this;
        }

        public MLTripFlightInfo clearEndAirportName() {
            this.f15428g = false;
            this.f15429h = "";
            return this;
        }

        public MLTripFlightInfo clearFlightNo() {
            this.f15424c = false;
            this.f15425d = "";
            return this;
        }

        public MLTripFlightInfo clearFlightState() {
            this.f15412Q = false;
            this.f15413R = "";
            return this;
        }

        public MLTripFlightInfo clearIsDelay() {
            this.ag = false;
            this.ah = 0;
            return this;
        }

        public MLTripFlightInfo clearShareFlightNo() {
            this.f15418W = false;
            this.f15419X = "";
            return this;
        }

        public MLTripFlightInfo clearStartAirportName() {
            this.f15426e = false;
            this.f15427f = "";
            return this;
        }

        public MLTripFlightInfo clearSuppliedBy() {
            this.ac = false;
            this.ad = "";
            return this;
        }

        public MLTripFlightInfo clearVeryZhunReadyArrtimeDate() {
            this.aa = false;
            this.ab = "";
            return this;
        }

        public MLTripFlightInfo clearVeryZhunReadyDeptimeDate() {
            this.f15420Y = false;
            this.f15421Z = "";
            return this;
        }

        public long getAddFlightType() {
            return this.f15423b;
        }

        public String getAirline() {
            return this.af;
        }

        public String getAirlineUrl() {
            return this.aj;
        }

        public String getArrivalAirportCode() {
            return this.f15435n;
        }

        public String getArrivalAirportName() {
            return this.f15403H;
        }

        public String getArrivalAirportNameAbbrev() {
            return this.f15405J;
        }

        public String getArrivalCityCode() {
            return this.f15407L;
        }

        public String getArrivalCityName() {
            return this.f15409N;
        }

        public String getArrivalTerminalName() {
            return this.f15441t;
        }

        public long getArrivalTime() {
            return this.f15433l;
        }

        public String getArrivalTimeStr() {
            return this.f15445x;
        }

        public String getBaggageId() {
            return this.f15417V;
        }

        public String getBoardGate() {
            return this.f15415T;
        }

        public int getCachedSize() {
            if (this.ak < 0) {
                getSerializedSize();
            }
            return this.ak;
        }

        public String getCheckinTable() {
            return this.f15411P;
        }

        public String getDepartAirportCode() {
            return this.f15437p;
        }

        public String getDepartAirportName() {
            return this.f15401F;
        }

        public String getDepartAirportNameAbbrev() {
            return this.f15447z;
        }

        public String getDepartCityCode() {
            return this.f15397B;
        }

        public String getDepartCityName() {
            return this.f15399D;
        }

        public String getDepartTerminalName() {
            return this.f15439r;
        }

        public long getDepartTime() {
            return this.f15431j;
        }

        public String getDepartTimeStr() {
            return this.f15443v;
        }

        public String getEndAirportName() {
            return this.f15429h;
        }

        public String getFlightNo() {
            return this.f15425d;
        }

        public String getFlightState() {
            return this.f15413R;
        }

        public int getIsDelay() {
            return this.ah;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasAddFlightType()) {
                i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getAddFlightType());
            }
            if (hasFlightNo()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getFlightNo());
            }
            if (hasStartAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getStartAirportName());
            }
            if (hasEndAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getEndAirportName());
            }
            if (hasDepartTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(5, getDepartTime());
            }
            if (hasArrivalTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(6, getArrivalTime());
            }
            if (hasArrivalAirportCode()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getArrivalAirportCode());
            }
            if (hasDepartAirportCode()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getDepartAirportCode());
            }
            if (hasDepartTerminalName()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getDepartTerminalName());
            }
            if (hasArrivalTerminalName()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getArrivalTerminalName());
            }
            if (hasDepartTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getDepartTimeStr());
            }
            if (hasArrivalTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getArrivalTimeStr());
            }
            if (hasDepartAirportNameAbbrev()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getDepartAirportNameAbbrev());
            }
            if (hasDepartCityCode()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getDepartCityCode());
            }
            if (hasDepartCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(15, getDepartCityName());
            }
            if (hasDepartAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(16, getDepartAirportName());
            }
            if (hasArrivalAirportName()) {
                i += CodedOutputStreamMicro.computeStringSize(17, getArrivalAirportName());
            }
            if (hasArrivalAirportNameAbbrev()) {
                i += CodedOutputStreamMicro.computeStringSize(18, getArrivalAirportNameAbbrev());
            }
            if (hasArrivalCityCode()) {
                i += CodedOutputStreamMicro.computeStringSize(19, getArrivalCityCode());
            }
            if (hasArrivalCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(20, getArrivalCityName());
            }
            if (hasCheckinTable()) {
                i += CodedOutputStreamMicro.computeStringSize(21, getCheckinTable());
            }
            if (hasFlightState()) {
                i += CodedOutputStreamMicro.computeStringSize(22, getFlightState());
            }
            if (hasBoardGate()) {
                i += CodedOutputStreamMicro.computeStringSize(23, getBoardGate());
            }
            if (hasBaggageId()) {
                i += CodedOutputStreamMicro.computeStringSize(24, getBaggageId());
            }
            if (hasShareFlightNo()) {
                i += CodedOutputStreamMicro.computeStringSize(25, getShareFlightNo());
            }
            if (hasVeryZhunReadyDeptimeDate()) {
                i += CodedOutputStreamMicro.computeStringSize(26, getVeryZhunReadyDeptimeDate());
            }
            if (hasVeryZhunReadyArrtimeDate()) {
                i += CodedOutputStreamMicro.computeStringSize(27, getVeryZhunReadyArrtimeDate());
            }
            if (hasSuppliedBy()) {
                i += CodedOutputStreamMicro.computeStringSize(28, getSuppliedBy());
            }
            if (hasAirline()) {
                i += CodedOutputStreamMicro.computeStringSize(29, getAirline());
            }
            if (hasIsDelay()) {
                i += CodedOutputStreamMicro.computeInt32Size(30, getIsDelay());
            }
            if (hasAirlineUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(31, getAirlineUrl());
            }
            this.ak = i;
            return i;
        }

        public String getShareFlightNo() {
            return this.f15419X;
        }

        public String getStartAirportName() {
            return this.f15427f;
        }

        public String getSuppliedBy() {
            return this.ad;
        }

        public String getVeryZhunReadyArrtimeDate() {
            return this.ab;
        }

        public String getVeryZhunReadyDeptimeDate() {
            return this.f15421Z;
        }

        public boolean hasAddFlightType() {
            return this.f15422a;
        }

        public boolean hasAirline() {
            return this.ae;
        }

        public boolean hasAirlineUrl() {
            return this.ai;
        }

        public boolean hasArrivalAirportCode() {
            return this.f15434m;
        }

        public boolean hasArrivalAirportName() {
            return this.f15402G;
        }

        public boolean hasArrivalAirportNameAbbrev() {
            return this.f15404I;
        }

        public boolean hasArrivalCityCode() {
            return this.f15406K;
        }

        public boolean hasArrivalCityName() {
            return this.f15408M;
        }

        public boolean hasArrivalTerminalName() {
            return this.f15440s;
        }

        public boolean hasArrivalTime() {
            return this.f15432k;
        }

        public boolean hasArrivalTimeStr() {
            return this.f15444w;
        }

        public boolean hasBaggageId() {
            return this.f15416U;
        }

        public boolean hasBoardGate() {
            return this.f15414S;
        }

        public boolean hasCheckinTable() {
            return this.f15410O;
        }

        public boolean hasDepartAirportCode() {
            return this.f15436o;
        }

        public boolean hasDepartAirportName() {
            return this.f15400E;
        }

        public boolean hasDepartAirportNameAbbrev() {
            return this.f15446y;
        }

        public boolean hasDepartCityCode() {
            return this.f15396A;
        }

        public boolean hasDepartCityName() {
            return this.f15398C;
        }

        public boolean hasDepartTerminalName() {
            return this.f15438q;
        }

        public boolean hasDepartTime() {
            return this.f15430i;
        }

        public boolean hasDepartTimeStr() {
            return this.f15442u;
        }

        public boolean hasEndAirportName() {
            return this.f15428g;
        }

        public boolean hasFlightNo() {
            return this.f15424c;
        }

        public boolean hasFlightState() {
            return this.f15412Q;
        }

        public boolean hasIsDelay() {
            return this.ag;
        }

        public boolean hasShareFlightNo() {
            return this.f15418W;
        }

        public boolean hasStartAirportName() {
            return this.f15426e;
        }

        public boolean hasSuppliedBy() {
            return this.ac;
        }

        public boolean hasVeryZhunReadyArrtimeDate() {
            return this.aa;
        }

        public boolean hasVeryZhunReadyDeptimeDate() {
            return this.f15420Y;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MLTripFlightInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setAddFlightType(codedInputStreamMicro.readInt64());
                        continue;
                    case 18:
                        setFlightNo(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setStartAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setEndAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setDepartTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 48:
                        setArrivalTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 58:
                        setArrivalAirportCode(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setDepartAirportCode(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setDepartTerminalName(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setArrivalTerminalName(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setDepartTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setArrivalTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setDepartAirportNameAbbrev(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setDepartCityCode(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setDepartCityName(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        setDepartAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        setArrivalAirportName(codedInputStreamMicro.readString());
                        continue;
                    case 146:
                        setArrivalAirportNameAbbrev(codedInputStreamMicro.readString());
                        continue;
                    case 154:
                        setArrivalCityCode(codedInputStreamMicro.readString());
                        continue;
                    case 162:
                        setArrivalCityName(codedInputStreamMicro.readString());
                        continue;
                    case 170:
                        setCheckinTable(codedInputStreamMicro.readString());
                        continue;
                    case 178:
                        setFlightState(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        setBoardGate(codedInputStreamMicro.readString());
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        setBaggageId(codedInputStreamMicro.readString());
                        continue;
                    case 202:
                        setShareFlightNo(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ds /*210*/:
                        setVeryZhunReadyDeptimeDate(codedInputStreamMicro.readString());
                        continue;
                    case 218:
                        setVeryZhunReadyArrtimeDate(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.dG /*226*/:
                        setSuppliedBy(codedInputStreamMicro.readString());
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                        setAirline(codedInputStreamMicro.readString());
                        continue;
                    case RGHUDDataModel.MAX_CAR_SPEED /*240*/:
                        setIsDelay(codedInputStreamMicro.readInt32());
                        continue;
                    case 250:
                        setAirlineUrl(codedInputStreamMicro.readString());
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

        public MLTripFlightInfo setAddFlightType(long j) {
            this.f15422a = true;
            this.f15423b = j;
            return this;
        }

        public MLTripFlightInfo setAirline(String str) {
            this.ae = true;
            this.af = str;
            return this;
        }

        public MLTripFlightInfo setAirlineUrl(String str) {
            this.ai = true;
            this.aj = str;
            return this;
        }

        public MLTripFlightInfo setArrivalAirportCode(String str) {
            this.f15434m = true;
            this.f15435n = str;
            return this;
        }

        public MLTripFlightInfo setArrivalAirportName(String str) {
            this.f15402G = true;
            this.f15403H = str;
            return this;
        }

        public MLTripFlightInfo setArrivalAirportNameAbbrev(String str) {
            this.f15404I = true;
            this.f15405J = str;
            return this;
        }

        public MLTripFlightInfo setArrivalCityCode(String str) {
            this.f15406K = true;
            this.f15407L = str;
            return this;
        }

        public MLTripFlightInfo setArrivalCityName(String str) {
            this.f15408M = true;
            this.f15409N = str;
            return this;
        }

        public MLTripFlightInfo setArrivalTerminalName(String str) {
            this.f15440s = true;
            this.f15441t = str;
            return this;
        }

        public MLTripFlightInfo setArrivalTime(long j) {
            this.f15432k = true;
            this.f15433l = j;
            return this;
        }

        public MLTripFlightInfo setArrivalTimeStr(String str) {
            this.f15444w = true;
            this.f15445x = str;
            return this;
        }

        public MLTripFlightInfo setBaggageId(String str) {
            this.f15416U = true;
            this.f15417V = str;
            return this;
        }

        public MLTripFlightInfo setBoardGate(String str) {
            this.f15414S = true;
            this.f15415T = str;
            return this;
        }

        public MLTripFlightInfo setCheckinTable(String str) {
            this.f15410O = true;
            this.f15411P = str;
            return this;
        }

        public MLTripFlightInfo setDepartAirportCode(String str) {
            this.f15436o = true;
            this.f15437p = str;
            return this;
        }

        public MLTripFlightInfo setDepartAirportName(String str) {
            this.f15400E = true;
            this.f15401F = str;
            return this;
        }

        public MLTripFlightInfo setDepartAirportNameAbbrev(String str) {
            this.f15446y = true;
            this.f15447z = str;
            return this;
        }

        public MLTripFlightInfo setDepartCityCode(String str) {
            this.f15396A = true;
            this.f15397B = str;
            return this;
        }

        public MLTripFlightInfo setDepartCityName(String str) {
            this.f15398C = true;
            this.f15399D = str;
            return this;
        }

        public MLTripFlightInfo setDepartTerminalName(String str) {
            this.f15438q = true;
            this.f15439r = str;
            return this;
        }

        public MLTripFlightInfo setDepartTime(long j) {
            this.f15430i = true;
            this.f15431j = j;
            return this;
        }

        public MLTripFlightInfo setDepartTimeStr(String str) {
            this.f15442u = true;
            this.f15443v = str;
            return this;
        }

        public MLTripFlightInfo setEndAirportName(String str) {
            this.f15428g = true;
            this.f15429h = str;
            return this;
        }

        public MLTripFlightInfo setFlightNo(String str) {
            this.f15424c = true;
            this.f15425d = str;
            return this;
        }

        public MLTripFlightInfo setFlightState(String str) {
            this.f15412Q = true;
            this.f15413R = str;
            return this;
        }

        public MLTripFlightInfo setIsDelay(int i) {
            this.ag = true;
            this.ah = i;
            return this;
        }

        public MLTripFlightInfo setShareFlightNo(String str) {
            this.f15418W = true;
            this.f15419X = str;
            return this;
        }

        public MLTripFlightInfo setStartAirportName(String str) {
            this.f15426e = true;
            this.f15427f = str;
            return this;
        }

        public MLTripFlightInfo setSuppliedBy(String str) {
            this.ac = true;
            this.ad = str;
            return this;
        }

        public MLTripFlightInfo setVeryZhunReadyArrtimeDate(String str) {
            this.aa = true;
            this.ab = str;
            return this;
        }

        public MLTripFlightInfo setVeryZhunReadyDeptimeDate(String str) {
            this.f15420Y = true;
            this.f15421Z = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasAddFlightType()) {
                codedOutputStreamMicro.writeInt64(1, getAddFlightType());
            }
            if (hasFlightNo()) {
                codedOutputStreamMicro.writeString(2, getFlightNo());
            }
            if (hasStartAirportName()) {
                codedOutputStreamMicro.writeString(3, getStartAirportName());
            }
            if (hasEndAirportName()) {
                codedOutputStreamMicro.writeString(4, getEndAirportName());
            }
            if (hasDepartTime()) {
                codedOutputStreamMicro.writeInt64(5, getDepartTime());
            }
            if (hasArrivalTime()) {
                codedOutputStreamMicro.writeInt64(6, getArrivalTime());
            }
            if (hasArrivalAirportCode()) {
                codedOutputStreamMicro.writeString(7, getArrivalAirportCode());
            }
            if (hasDepartAirportCode()) {
                codedOutputStreamMicro.writeString(8, getDepartAirportCode());
            }
            if (hasDepartTerminalName()) {
                codedOutputStreamMicro.writeString(9, getDepartTerminalName());
            }
            if (hasArrivalTerminalName()) {
                codedOutputStreamMicro.writeString(10, getArrivalTerminalName());
            }
            if (hasDepartTimeStr()) {
                codedOutputStreamMicro.writeString(11, getDepartTimeStr());
            }
            if (hasArrivalTimeStr()) {
                codedOutputStreamMicro.writeString(12, getArrivalTimeStr());
            }
            if (hasDepartAirportNameAbbrev()) {
                codedOutputStreamMicro.writeString(13, getDepartAirportNameAbbrev());
            }
            if (hasDepartCityCode()) {
                codedOutputStreamMicro.writeString(14, getDepartCityCode());
            }
            if (hasDepartCityName()) {
                codedOutputStreamMicro.writeString(15, getDepartCityName());
            }
            if (hasDepartAirportName()) {
                codedOutputStreamMicro.writeString(16, getDepartAirportName());
            }
            if (hasArrivalAirportName()) {
                codedOutputStreamMicro.writeString(17, getArrivalAirportName());
            }
            if (hasArrivalAirportNameAbbrev()) {
                codedOutputStreamMicro.writeString(18, getArrivalAirportNameAbbrev());
            }
            if (hasArrivalCityCode()) {
                codedOutputStreamMicro.writeString(19, getArrivalCityCode());
            }
            if (hasArrivalCityName()) {
                codedOutputStreamMicro.writeString(20, getArrivalCityName());
            }
            if (hasCheckinTable()) {
                codedOutputStreamMicro.writeString(21, getCheckinTable());
            }
            if (hasFlightState()) {
                codedOutputStreamMicro.writeString(22, getFlightState());
            }
            if (hasBoardGate()) {
                codedOutputStreamMicro.writeString(23, getBoardGate());
            }
            if (hasBaggageId()) {
                codedOutputStreamMicro.writeString(24, getBaggageId());
            }
            if (hasShareFlightNo()) {
                codedOutputStreamMicro.writeString(25, getShareFlightNo());
            }
            if (hasVeryZhunReadyDeptimeDate()) {
                codedOutputStreamMicro.writeString(26, getVeryZhunReadyDeptimeDate());
            }
            if (hasVeryZhunReadyArrtimeDate()) {
                codedOutputStreamMicro.writeString(27, getVeryZhunReadyArrtimeDate());
            }
            if (hasSuppliedBy()) {
                codedOutputStreamMicro.writeString(28, getSuppliedBy());
            }
            if (hasAirline()) {
                codedOutputStreamMicro.writeString(29, getAirline());
            }
            if (hasIsDelay()) {
                codedOutputStreamMicro.writeInt32(30, getIsDelay());
            }
            if (hasAirlineUrl()) {
                codedOutputStreamMicro.writeString(31, getAirlineUrl());
            }
        }
    }

    public static final class MLTripGroup extends MessageMicro {
        public static final int DATA_FIELD_NUMBER = 2;
        public static final int DAY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15448a;
        /* renamed from: b */
        private long f15449b = 0;
        /* renamed from: c */
        private List<MLTripGroupData> f15450c = Collections.emptyList();
        /* renamed from: d */
        private int f15451d = -1;

        public static MLTripGroup parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripGroup().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripGroup parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripGroup) new MLTripGroup().mergeFrom(bArr);
        }

        public MLTripGroup addData(MLTripGroupData mLTripGroupData) {
            if (mLTripGroupData != null) {
                if (this.f15450c.isEmpty()) {
                    this.f15450c = new ArrayList();
                }
                this.f15450c.add(mLTripGroupData);
            }
            return this;
        }

        public final MLTripGroup clear() {
            clearDay();
            clearData();
            this.f15451d = -1;
            return this;
        }

        public MLTripGroup clearData() {
            this.f15450c = Collections.emptyList();
            return this;
        }

        public MLTripGroup clearDay() {
            this.f15448a = false;
            this.f15449b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15451d < 0) {
                getSerializedSize();
            }
            return this.f15451d;
        }

        public MLTripGroupData getData(int i) {
            return (MLTripGroupData) this.f15450c.get(i);
        }

        public int getDataCount() {
            return this.f15450c.size();
        }

        public List<MLTripGroupData> getDataList() {
            return this.f15450c;
        }

        public long getDay() {
            return this.f15449b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDay()) {
                i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getDay());
            }
            int i2 = i;
            for (MLTripGroupData computeMessageSize : getDataList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f15451d = i2;
            return i2;
        }

        public boolean hasDay() {
            return this.f15448a;
        }

        public final boolean isInitialized() {
            if (!this.f15448a) {
                return false;
            }
            for (MLTripGroupData isInitialized : getDataList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public MLTripGroup mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setDay(codedInputStreamMicro.readInt64());
                        continue;
                    case 18:
                        MessageMicro mLTripGroupData = new MLTripGroupData();
                        codedInputStreamMicro.readMessage(mLTripGroupData);
                        addData(mLTripGroupData);
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

        public MLTripGroup setData(int i, MLTripGroupData mLTripGroupData) {
            if (mLTripGroupData != null) {
                this.f15450c.set(i, mLTripGroupData);
            }
            return this;
        }

        public MLTripGroup setDay(long j) {
            this.f15448a = true;
            this.f15449b = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDay()) {
                codedOutputStreamMicro.writeInt64(1, getDay());
            }
            for (MLTripGroupData writeMessage : getDataList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class MLTripGroupData extends MessageMicro {
        public static final int GTYPE_FIELD_NUMBER = 1;
        public static final int SEP_FIELD_NUMBER = 2;
        public static final int TRIP_FIELD_NUMBER = 3;
        public static final int WEATHER_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15452a;
        /* renamed from: b */
        private String f15453b = "";
        /* renamed from: c */
        private boolean f15454c;
        /* renamed from: d */
        private MLTripCitySep f15455d = null;
        /* renamed from: e */
        private boolean f15456e;
        /* renamed from: f */
        private MLTrip f15457f = null;
        /* renamed from: g */
        private boolean f15458g;
        /* renamed from: h */
        private MLWeahterSep f15459h = null;
        /* renamed from: i */
        private int f15460i = -1;

        public static MLTripGroupData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripGroupData().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripGroupData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripGroupData) new MLTripGroupData().mergeFrom(bArr);
        }

        public final MLTripGroupData clear() {
            clearGtype();
            clearSep();
            clearTrip();
            clearWeather();
            this.f15460i = -1;
            return this;
        }

        public MLTripGroupData clearGtype() {
            this.f15452a = false;
            this.f15453b = "";
            return this;
        }

        public MLTripGroupData clearSep() {
            this.f15454c = false;
            this.f15455d = null;
            return this;
        }

        public MLTripGroupData clearTrip() {
            this.f15456e = false;
            this.f15457f = null;
            return this;
        }

        public MLTripGroupData clearWeather() {
            this.f15458g = false;
            this.f15459h = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15460i < 0) {
                getSerializedSize();
            }
            return this.f15460i;
        }

        public String getGtype() {
            return this.f15453b;
        }

        public MLTripCitySep getSep() {
            return this.f15455d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasGtype()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getGtype());
            }
            if (hasSep()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getSep());
            }
            if (hasTrip()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getTrip());
            }
            if (hasWeather()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getWeather());
            }
            this.f15460i = i;
            return i;
        }

        public MLTrip getTrip() {
            return this.f15457f;
        }

        public MLWeahterSep getWeather() {
            return this.f15459h;
        }

        public boolean hasGtype() {
            return this.f15452a;
        }

        public boolean hasSep() {
            return this.f15454c;
        }

        public boolean hasTrip() {
            return this.f15456e;
        }

        public boolean hasWeather() {
            return this.f15458g;
        }

        public final boolean isInitialized() {
            return !this.f15452a ? false : (!hasSep() || getSep().isInitialized()) ? !hasTrip() || getTrip().isInitialized() : false;
        }

        public MLTripGroupData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro mLTripCitySep;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setGtype(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        mLTripCitySep = new MLTripCitySep();
                        codedInputStreamMicro.readMessage(mLTripCitySep);
                        setSep(mLTripCitySep);
                        continue;
                    case 26:
                        mLTripCitySep = new MLTrip();
                        codedInputStreamMicro.readMessage(mLTripCitySep);
                        setTrip(mLTripCitySep);
                        continue;
                    case 34:
                        mLTripCitySep = new MLWeahterSep();
                        codedInputStreamMicro.readMessage(mLTripCitySep);
                        setWeather(mLTripCitySep);
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

        public MLTripGroupData setGtype(String str) {
            this.f15452a = true;
            this.f15453b = str;
            return this;
        }

        public MLTripGroupData setSep(MLTripCitySep mLTripCitySep) {
            if (mLTripCitySep == null) {
                return clearSep();
            }
            this.f15454c = true;
            this.f15455d = mLTripCitySep;
            return this;
        }

        public MLTripGroupData setTrip(MLTrip mLTrip) {
            if (mLTrip == null) {
                return clearTrip();
            }
            this.f15456e = true;
            this.f15457f = mLTrip;
            return this;
        }

        public MLTripGroupData setWeather(MLWeahterSep mLWeahterSep) {
            if (mLWeahterSep == null) {
                return clearWeather();
            }
            this.f15458g = true;
            this.f15459h = mLWeahterSep;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasGtype()) {
                codedOutputStreamMicro.writeString(1, getGtype());
            }
            if (hasSep()) {
                codedOutputStreamMicro.writeMessage(2, getSep());
            }
            if (hasTrip()) {
                codedOutputStreamMicro.writeMessage(3, getTrip());
            }
            if (hasWeather()) {
                codedOutputStreamMicro.writeMessage(4, getWeather());
            }
        }
    }

    public static final class MLTripPoint extends MessageMicro {
        public static final int ADDRESS_FIELD_NUMBER = 7;
        public static final int CITY_ID_FIELD_NUMBER = 8;
        public static final int CITY_NAME_FIELD_NUMBER = 6;
        public static final int DETAIL_URL_FIELD_NUMBER = 9;
        public static final int ICON_FIELD_NUMBER = 10;
        public static final int LOC_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int POINT_TYPE_FIELD_NUMBER = 1;
        public static final int PUID_FIELD_NUMBER = 5;
        public static final int UID_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15461a;
        /* renamed from: b */
        private String f15462b = "";
        /* renamed from: c */
        private boolean f15463c;
        /* renamed from: d */
        private String f15464d = "";
        /* renamed from: e */
        private boolean f15465e;
        /* renamed from: f */
        private String f15466f = "";
        /* renamed from: g */
        private boolean f15467g;
        /* renamed from: h */
        private String f15468h = "";
        /* renamed from: i */
        private boolean f15469i;
        /* renamed from: j */
        private String f15470j = "";
        /* renamed from: k */
        private boolean f15471k;
        /* renamed from: l */
        private String f15472l = "";
        /* renamed from: m */
        private boolean f15473m;
        /* renamed from: n */
        private String f15474n = "";
        /* renamed from: o */
        private boolean f15475o;
        /* renamed from: p */
        private String f15476p = "";
        /* renamed from: q */
        private boolean f15477q;
        /* renamed from: r */
        private String f15478r = "";
        /* renamed from: s */
        private List<MLTripCardIconInfo> f15479s = Collections.emptyList();
        /* renamed from: t */
        private int f15480t = -1;

        public static MLTripPoint parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripPoint().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripPoint) new MLTripPoint().mergeFrom(bArr);
        }

        public MLTripPoint addIcon(MLTripCardIconInfo mLTripCardIconInfo) {
            if (mLTripCardIconInfo != null) {
                if (this.f15479s.isEmpty()) {
                    this.f15479s = new ArrayList();
                }
                this.f15479s.add(mLTripCardIconInfo);
            }
            return this;
        }

        public final MLTripPoint clear() {
            clearPointType();
            clearName();
            clearLoc();
            clearUid();
            clearPuid();
            clearCityName();
            clearAddress();
            clearCityId();
            clearDetailUrl();
            clearIcon();
            this.f15480t = -1;
            return this;
        }

        public MLTripPoint clearAddress() {
            this.f15473m = false;
            this.f15474n = "";
            return this;
        }

        public MLTripPoint clearCityId() {
            this.f15475o = false;
            this.f15476p = "";
            return this;
        }

        public MLTripPoint clearCityName() {
            this.f15471k = false;
            this.f15472l = "";
            return this;
        }

        public MLTripPoint clearDetailUrl() {
            this.f15477q = false;
            this.f15478r = "";
            return this;
        }

        public MLTripPoint clearIcon() {
            this.f15479s = Collections.emptyList();
            return this;
        }

        public MLTripPoint clearLoc() {
            this.f15465e = false;
            this.f15466f = "";
            return this;
        }

        public MLTripPoint clearName() {
            this.f15463c = false;
            this.f15464d = "";
            return this;
        }

        public MLTripPoint clearPointType() {
            this.f15461a = false;
            this.f15462b = "";
            return this;
        }

        public MLTripPoint clearPuid() {
            this.f15469i = false;
            this.f15470j = "";
            return this;
        }

        public MLTripPoint clearUid() {
            this.f15467g = false;
            this.f15468h = "";
            return this;
        }

        public String getAddress() {
            return this.f15474n;
        }

        public int getCachedSize() {
            if (this.f15480t < 0) {
                getSerializedSize();
            }
            return this.f15480t;
        }

        public String getCityId() {
            return this.f15476p;
        }

        public String getCityName() {
            return this.f15472l;
        }

        public String getDetailUrl() {
            return this.f15478r;
        }

        public MLTripCardIconInfo getIcon(int i) {
            return (MLTripCardIconInfo) this.f15479s.get(i);
        }

        public int getIconCount() {
            return this.f15479s.size();
        }

        public List<MLTripCardIconInfo> getIconList() {
            return this.f15479s;
        }

        public String getLoc() {
            return this.f15466f;
        }

        public String getName() {
            return this.f15464d;
        }

        public String getPointType() {
            return this.f15462b;
        }

        public String getPuid() {
            return this.f15470j;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasPointType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getPointType());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getLoc());
            }
            if (hasUid()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getUid());
            }
            if (hasPuid()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getPuid());
            }
            if (hasCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getCityName());
            }
            if (hasAddress()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getAddress());
            }
            if (hasCityId()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getCityId());
            }
            if (hasDetailUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getDetailUrl());
            }
            int i2 = i;
            for (MLTripCardIconInfo computeMessageSize : getIconList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(10, computeMessageSize) + i2;
            }
            this.f15480t = i2;
            return i2;
        }

        public String getUid() {
            return this.f15468h;
        }

        public boolean hasAddress() {
            return this.f15473m;
        }

        public boolean hasCityId() {
            return this.f15475o;
        }

        public boolean hasCityName() {
            return this.f15471k;
        }

        public boolean hasDetailUrl() {
            return this.f15477q;
        }

        public boolean hasLoc() {
            return this.f15465e;
        }

        public boolean hasName() {
            return this.f15463c;
        }

        public boolean hasPointType() {
            return this.f15461a;
        }

        public boolean hasPuid() {
            return this.f15469i;
        }

        public boolean hasUid() {
            return this.f15467g;
        }

        public final boolean isInitialized() {
            return this.f15461a && this.f15463c && this.f15465e && this.f15467g;
        }

        public MLTripPoint mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setPointType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setLoc(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setPuid(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setCityName(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setAddress(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setCityId(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setDetailUrl(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        MessageMicro mLTripCardIconInfo = new MLTripCardIconInfo();
                        codedInputStreamMicro.readMessage(mLTripCardIconInfo);
                        addIcon(mLTripCardIconInfo);
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

        public MLTripPoint setAddress(String str) {
            this.f15473m = true;
            this.f15474n = str;
            return this;
        }

        public MLTripPoint setCityId(String str) {
            this.f15475o = true;
            this.f15476p = str;
            return this;
        }

        public MLTripPoint setCityName(String str) {
            this.f15471k = true;
            this.f15472l = str;
            return this;
        }

        public MLTripPoint setDetailUrl(String str) {
            this.f15477q = true;
            this.f15478r = str;
            return this;
        }

        public MLTripPoint setIcon(int i, MLTripCardIconInfo mLTripCardIconInfo) {
            if (mLTripCardIconInfo != null) {
                this.f15479s.set(i, mLTripCardIconInfo);
            }
            return this;
        }

        public MLTripPoint setLoc(String str) {
            this.f15465e = true;
            this.f15466f = str;
            return this;
        }

        public MLTripPoint setName(String str) {
            this.f15463c = true;
            this.f15464d = str;
            return this;
        }

        public MLTripPoint setPointType(String str) {
            this.f15461a = true;
            this.f15462b = str;
            return this;
        }

        public MLTripPoint setPuid(String str) {
            this.f15469i = true;
            this.f15470j = str;
            return this;
        }

        public MLTripPoint setUid(String str) {
            this.f15467g = true;
            this.f15468h = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasPointType()) {
                codedOutputStreamMicro.writeString(1, getPointType());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasLoc()) {
                codedOutputStreamMicro.writeString(3, getLoc());
            }
            if (hasUid()) {
                codedOutputStreamMicro.writeString(4, getUid());
            }
            if (hasPuid()) {
                codedOutputStreamMicro.writeString(5, getPuid());
            }
            if (hasCityName()) {
                codedOutputStreamMicro.writeString(6, getCityName());
            }
            if (hasAddress()) {
                codedOutputStreamMicro.writeString(7, getAddress());
            }
            if (hasCityId()) {
                codedOutputStreamMicro.writeString(8, getCityId());
            }
            if (hasDetailUrl()) {
                codedOutputStreamMicro.writeString(9, getDetailUrl());
            }
            for (MLTripCardIconInfo writeMessage : getIconList()) {
                codedOutputStreamMicro.writeMessage(10, writeMessage);
            }
        }
    }

    public static final class MLTripSugInfo extends MessageMicro {
        public static final int DISTANCE_FIELD_NUMBER = 2;
        public static final int ICON_URL_FIELD_NUMBER = 5;
        public static final int JUMP_URL_FIELD_NUMBER = 6;
        public static final int LEAD_TITLE_FIELD_NUMBER = 1;
        public static final int MORE_URL_FIELD_NUMBER = 8;
        public static final int POINT_FIELD_NUMBER = 4;
        public static final int SUG_FLAG_FIELD_NUMBER = 9;
        public static final int TAG_FIELD_NUMBER = 7;
        public static final int TAKE_TIME_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15481a;
        /* renamed from: b */
        private String f15482b = "";
        /* renamed from: c */
        private boolean f15483c;
        /* renamed from: d */
        private String f15484d = "";
        /* renamed from: e */
        private boolean f15485e;
        /* renamed from: f */
        private String f15486f = "";
        /* renamed from: g */
        private boolean f15487g;
        /* renamed from: h */
        private MLTripPoint f15488h = null;
        /* renamed from: i */
        private boolean f15489i;
        /* renamed from: j */
        private String f15490j = "";
        /* renamed from: k */
        private boolean f15491k;
        /* renamed from: l */
        private String f15492l = "";
        /* renamed from: m */
        private boolean f15493m;
        /* renamed from: n */
        private String f15494n = "";
        /* renamed from: o */
        private boolean f15495o;
        /* renamed from: p */
        private String f15496p = "";
        /* renamed from: q */
        private boolean f15497q;
        /* renamed from: r */
        private String f15498r = "";
        /* renamed from: s */
        private int f15499s = -1;

        public static MLTripSugInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripSugInfo().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripSugInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripSugInfo) new MLTripSugInfo().mergeFrom(bArr);
        }

        public final MLTripSugInfo clear() {
            clearLeadTitle();
            clearDistance();
            clearTakeTime();
            clearPoint();
            clearIconUrl();
            clearJumpUrl();
            clearTag();
            clearMoreUrl();
            clearSugFlag();
            this.f15499s = -1;
            return this;
        }

        public MLTripSugInfo clearDistance() {
            this.f15483c = false;
            this.f15484d = "";
            return this;
        }

        public MLTripSugInfo clearIconUrl() {
            this.f15489i = false;
            this.f15490j = "";
            return this;
        }

        public MLTripSugInfo clearJumpUrl() {
            this.f15491k = false;
            this.f15492l = "";
            return this;
        }

        public MLTripSugInfo clearLeadTitle() {
            this.f15481a = false;
            this.f15482b = "";
            return this;
        }

        public MLTripSugInfo clearMoreUrl() {
            this.f15495o = false;
            this.f15496p = "";
            return this;
        }

        public MLTripSugInfo clearPoint() {
            this.f15487g = false;
            this.f15488h = null;
            return this;
        }

        public MLTripSugInfo clearSugFlag() {
            this.f15497q = false;
            this.f15498r = "";
            return this;
        }

        public MLTripSugInfo clearTag() {
            this.f15493m = false;
            this.f15494n = "";
            return this;
        }

        public MLTripSugInfo clearTakeTime() {
            this.f15485e = false;
            this.f15486f = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15499s < 0) {
                getSerializedSize();
            }
            return this.f15499s;
        }

        public String getDistance() {
            return this.f15484d;
        }

        public String getIconUrl() {
            return this.f15490j;
        }

        public String getJumpUrl() {
            return this.f15492l;
        }

        public String getLeadTitle() {
            return this.f15482b;
        }

        public String getMoreUrl() {
            return this.f15496p;
        }

        public MLTripPoint getPoint() {
            return this.f15488h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasLeadTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getLeadTitle());
            }
            if (hasDistance()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getDistance());
            }
            if (hasTakeTime()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTakeTime());
            }
            if (hasPoint()) {
                i += CodedOutputStreamMicro.computeMessageSize(4, getPoint());
            }
            if (hasIconUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getIconUrl());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getJumpUrl());
            }
            if (hasTag()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getTag());
            }
            if (hasMoreUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getMoreUrl());
            }
            if (hasSugFlag()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getSugFlag());
            }
            this.f15499s = i;
            return i;
        }

        public String getSugFlag() {
            return this.f15498r;
        }

        public String getTag() {
            return this.f15494n;
        }

        public String getTakeTime() {
            return this.f15486f;
        }

        public boolean hasDistance() {
            return this.f15483c;
        }

        public boolean hasIconUrl() {
            return this.f15489i;
        }

        public boolean hasJumpUrl() {
            return this.f15491k;
        }

        public boolean hasLeadTitle() {
            return this.f15481a;
        }

        public boolean hasMoreUrl() {
            return this.f15495o;
        }

        public boolean hasPoint() {
            return this.f15487g;
        }

        public boolean hasSugFlag() {
            return this.f15497q;
        }

        public boolean hasTag() {
            return this.f15493m;
        }

        public boolean hasTakeTime() {
            return this.f15485e;
        }

        public final boolean isInitialized() {
            return !hasPoint() || getPoint().isInitialized();
        }

        public MLTripSugInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setLeadTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setDistance(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTakeTime(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        MessageMicro mLTripPoint = new MLTripPoint();
                        codedInputStreamMicro.readMessage(mLTripPoint);
                        setPoint(mLTripPoint);
                        continue;
                    case 42:
                        setIconUrl(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setTag(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setMoreUrl(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setSugFlag(codedInputStreamMicro.readString());
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

        public MLTripSugInfo setDistance(String str) {
            this.f15483c = true;
            this.f15484d = str;
            return this;
        }

        public MLTripSugInfo setIconUrl(String str) {
            this.f15489i = true;
            this.f15490j = str;
            return this;
        }

        public MLTripSugInfo setJumpUrl(String str) {
            this.f15491k = true;
            this.f15492l = str;
            return this;
        }

        public MLTripSugInfo setLeadTitle(String str) {
            this.f15481a = true;
            this.f15482b = str;
            return this;
        }

        public MLTripSugInfo setMoreUrl(String str) {
            this.f15495o = true;
            this.f15496p = str;
            return this;
        }

        public MLTripSugInfo setPoint(MLTripPoint mLTripPoint) {
            if (mLTripPoint == null) {
                return clearPoint();
            }
            this.f15487g = true;
            this.f15488h = mLTripPoint;
            return this;
        }

        public MLTripSugInfo setSugFlag(String str) {
            this.f15497q = true;
            this.f15498r = str;
            return this;
        }

        public MLTripSugInfo setTag(String str) {
            this.f15493m = true;
            this.f15494n = str;
            return this;
        }

        public MLTripSugInfo setTakeTime(String str) {
            this.f15485e = true;
            this.f15486f = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasLeadTitle()) {
                codedOutputStreamMicro.writeString(1, getLeadTitle());
            }
            if (hasDistance()) {
                codedOutputStreamMicro.writeString(2, getDistance());
            }
            if (hasTakeTime()) {
                codedOutputStreamMicro.writeString(3, getTakeTime());
            }
            if (hasPoint()) {
                codedOutputStreamMicro.writeMessage(4, getPoint());
            }
            if (hasIconUrl()) {
                codedOutputStreamMicro.writeString(5, getIconUrl());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(6, getJumpUrl());
            }
            if (hasTag()) {
                codedOutputStreamMicro.writeString(7, getTag());
            }
            if (hasMoreUrl()) {
                codedOutputStreamMicro.writeString(8, getMoreUrl());
            }
            if (hasSugFlag()) {
                codedOutputStreamMicro.writeString(9, getSugFlag());
            }
        }
    }

    public static final class MLTripTrainInfo extends MessageMicro {
        public static final int ARR_TIME_STR_FIELD_NUMBER = 7;
        public static final int DAY_DIFF_FIELD_NUMBER = 4;
        public static final int DEP_TIME_STR_FIELD_NUMBER = 6;
        public static final int RAILWAY_CARRIAGE_FIELD_NUMBER = 2;
        public static final int TRAIN_NO_FIELD_NUMBER = 1;
        public static final int TRAIN_SEAT_NO_FIELD_NUMBER = 3;
        public static final int TRAIN_TYPE_FIELD_NUMBER = 8;
        public static final int USE_TIME_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f15500a;
        /* renamed from: b */
        private String f15501b = "";
        /* renamed from: c */
        private boolean f15502c;
        /* renamed from: d */
        private String f15503d = "";
        /* renamed from: e */
        private boolean f15504e;
        /* renamed from: f */
        private String f15505f = "";
        /* renamed from: g */
        private boolean f15506g;
        /* renamed from: h */
        private boolean f15507h = false;
        /* renamed from: i */
        private boolean f15508i;
        /* renamed from: j */
        private int f15509j = 0;
        /* renamed from: k */
        private boolean f15510k;
        /* renamed from: l */
        private String f15511l = "";
        /* renamed from: m */
        private boolean f15512m;
        /* renamed from: n */
        private String f15513n = "";
        /* renamed from: o */
        private boolean f15514o;
        /* renamed from: p */
        private String f15515p = "";
        /* renamed from: q */
        private int f15516q = -1;

        public static MLTripTrainInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLTripTrainInfo().mergeFrom(codedInputStreamMicro);
        }

        public static MLTripTrainInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLTripTrainInfo) new MLTripTrainInfo().mergeFrom(bArr);
        }

        public final MLTripTrainInfo clear() {
            clearTrainNo();
            clearRailwayCarriage();
            clearTrainSeatNo();
            clearDayDiff();
            clearUseTime();
            clearDepTimeStr();
            clearArrTimeStr();
            clearTrainType();
            this.f15516q = -1;
            return this;
        }

        public MLTripTrainInfo clearArrTimeStr() {
            this.f15512m = false;
            this.f15513n = "";
            return this;
        }

        public MLTripTrainInfo clearDayDiff() {
            this.f15506g = false;
            this.f15507h = false;
            return this;
        }

        public MLTripTrainInfo clearDepTimeStr() {
            this.f15510k = false;
            this.f15511l = "";
            return this;
        }

        public MLTripTrainInfo clearRailwayCarriage() {
            this.f15502c = false;
            this.f15503d = "";
            return this;
        }

        public MLTripTrainInfo clearTrainNo() {
            this.f15500a = false;
            this.f15501b = "";
            return this;
        }

        public MLTripTrainInfo clearTrainSeatNo() {
            this.f15504e = false;
            this.f15505f = "";
            return this;
        }

        public MLTripTrainInfo clearTrainType() {
            this.f15514o = false;
            this.f15515p = "";
            return this;
        }

        public MLTripTrainInfo clearUseTime() {
            this.f15508i = false;
            this.f15509j = 0;
            return this;
        }

        public String getArrTimeStr() {
            return this.f15513n;
        }

        public int getCachedSize() {
            if (this.f15516q < 0) {
                getSerializedSize();
            }
            return this.f15516q;
        }

        public boolean getDayDiff() {
            return this.f15507h;
        }

        public String getDepTimeStr() {
            return this.f15511l;
        }

        public String getRailwayCarriage() {
            return this.f15503d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTrainNo()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTrainNo());
            }
            if (hasRailwayCarriage()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getRailwayCarriage());
            }
            if (hasTrainSeatNo()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTrainSeatNo());
            }
            if (hasDayDiff()) {
                i += CodedOutputStreamMicro.computeBoolSize(4, getDayDiff());
            }
            if (hasUseTime()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getUseTime());
            }
            if (hasDepTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getDepTimeStr());
            }
            if (hasArrTimeStr()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getArrTimeStr());
            }
            if (hasTrainType()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getTrainType());
            }
            this.f15516q = i;
            return i;
        }

        public String getTrainNo() {
            return this.f15501b;
        }

        public String getTrainSeatNo() {
            return this.f15505f;
        }

        public String getTrainType() {
            return this.f15515p;
        }

        public int getUseTime() {
            return this.f15509j;
        }

        public boolean hasArrTimeStr() {
            return this.f15512m;
        }

        public boolean hasDayDiff() {
            return this.f15506g;
        }

        public boolean hasDepTimeStr() {
            return this.f15510k;
        }

        public boolean hasRailwayCarriage() {
            return this.f15502c;
        }

        public boolean hasTrainNo() {
            return this.f15500a;
        }

        public boolean hasTrainSeatNo() {
            return this.f15504e;
        }

        public boolean hasTrainType() {
            return this.f15514o;
        }

        public boolean hasUseTime() {
            return this.f15508i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MLTripTrainInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTrainNo(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setRailwayCarriage(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTrainSeatNo(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setDayDiff(codedInputStreamMicro.readBool());
                        continue;
                    case 40:
                        setUseTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 50:
                        setDepTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setArrTimeStr(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setTrainType(codedInputStreamMicro.readString());
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

        public MLTripTrainInfo setArrTimeStr(String str) {
            this.f15512m = true;
            this.f15513n = str;
            return this;
        }

        public MLTripTrainInfo setDayDiff(boolean z) {
            this.f15506g = true;
            this.f15507h = z;
            return this;
        }

        public MLTripTrainInfo setDepTimeStr(String str) {
            this.f15510k = true;
            this.f15511l = str;
            return this;
        }

        public MLTripTrainInfo setRailwayCarriage(String str) {
            this.f15502c = true;
            this.f15503d = str;
            return this;
        }

        public MLTripTrainInfo setTrainNo(String str) {
            this.f15500a = true;
            this.f15501b = str;
            return this;
        }

        public MLTripTrainInfo setTrainSeatNo(String str) {
            this.f15504e = true;
            this.f15505f = str;
            return this;
        }

        public MLTripTrainInfo setTrainType(String str) {
            this.f15514o = true;
            this.f15515p = str;
            return this;
        }

        public MLTripTrainInfo setUseTime(int i) {
            this.f15508i = true;
            this.f15509j = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTrainNo()) {
                codedOutputStreamMicro.writeString(1, getTrainNo());
            }
            if (hasRailwayCarriage()) {
                codedOutputStreamMicro.writeString(2, getRailwayCarriage());
            }
            if (hasTrainSeatNo()) {
                codedOutputStreamMicro.writeString(3, getTrainSeatNo());
            }
            if (hasDayDiff()) {
                codedOutputStreamMicro.writeBool(4, getDayDiff());
            }
            if (hasUseTime()) {
                codedOutputStreamMicro.writeInt32(5, getUseTime());
            }
            if (hasDepTimeStr()) {
                codedOutputStreamMicro.writeString(6, getDepTimeStr());
            }
            if (hasArrTimeStr()) {
                codedOutputStreamMicro.writeString(7, getArrTimeStr());
            }
            if (hasTrainType()) {
                codedOutputStreamMicro.writeString(8, getTrainType());
            }
        }
    }

    public static final class MLWeahterSep extends MessageMicro {
        public static final int CITY_FIELD_NUMBER = 6;
        public static final int CITY_ICON_FIELD_NUMBER = 10;
        public static final int CITY_ID_FIELD_NUMBER = 9;
        public static final int EXT_CARD_FIELD_NUMBER = 11;
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int JUMP_URL_FIELD_NUMBER = 4;
        public static final int LOC_FIELD_NUMBER = 5;
        public static final int PM25_FIELD_NUMBER = 3;
        public static final int TEMP_RANGE_FIELD_NUMBER = 8;
        public static final int TEXT_FIELD_NUMBER = 2;
        public static final int WEATHER_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f15517a;
        /* renamed from: b */
        private String f15518b = "";
        /* renamed from: c */
        private boolean f15519c;
        /* renamed from: d */
        private String f15520d = "";
        /* renamed from: e */
        private boolean f15521e;
        /* renamed from: f */
        private String f15522f = "";
        /* renamed from: g */
        private boolean f15523g;
        /* renamed from: h */
        private String f15524h = "";
        /* renamed from: i */
        private boolean f15525i;
        /* renamed from: j */
        private String f15526j = "";
        /* renamed from: k */
        private boolean f15527k;
        /* renamed from: l */
        private String f15528l = "";
        /* renamed from: m */
        private boolean f15529m;
        /* renamed from: n */
        private String f15530n = "";
        /* renamed from: o */
        private boolean f15531o;
        /* renamed from: p */
        private String f15532p = "";
        /* renamed from: q */
        private boolean f15533q;
        /* renamed from: r */
        private String f15534r = "";
        /* renamed from: s */
        private boolean f15535s;
        /* renamed from: t */
        private String f15536t = "";
        /* renamed from: u */
        private List<BaseTitleContent> f15537u = Collections.emptyList();
        /* renamed from: v */
        private int f15538v = -1;

        public static MLWeahterSep parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MLWeahterSep().mergeFrom(codedInputStreamMicro);
        }

        public static MLWeahterSep parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MLWeahterSep) new MLWeahterSep().mergeFrom(bArr);
        }

        public MLWeahterSep addExtCard(BaseTitleContent baseTitleContent) {
            if (baseTitleContent != null) {
                if (this.f15537u.isEmpty()) {
                    this.f15537u = new ArrayList();
                }
                this.f15537u.add(baseTitleContent);
            }
            return this;
        }

        public final MLWeahterSep clear() {
            clearIcon();
            clearText();
            clearPm25();
            clearJumpUrl();
            clearLoc();
            clearCity();
            clearWeather();
            clearTempRange();
            clearCityId();
            clearCityIcon();
            clearExtCard();
            this.f15538v = -1;
            return this;
        }

        public MLWeahterSep clearCity() {
            this.f15527k = false;
            this.f15528l = "";
            return this;
        }

        public MLWeahterSep clearCityIcon() {
            this.f15535s = false;
            this.f15536t = "";
            return this;
        }

        public MLWeahterSep clearCityId() {
            this.f15533q = false;
            this.f15534r = "";
            return this;
        }

        public MLWeahterSep clearExtCard() {
            this.f15537u = Collections.emptyList();
            return this;
        }

        public MLWeahterSep clearIcon() {
            this.f15517a = false;
            this.f15518b = "";
            return this;
        }

        public MLWeahterSep clearJumpUrl() {
            this.f15523g = false;
            this.f15524h = "";
            return this;
        }

        public MLWeahterSep clearLoc() {
            this.f15525i = false;
            this.f15526j = "";
            return this;
        }

        public MLWeahterSep clearPm25() {
            this.f15521e = false;
            this.f15522f = "";
            return this;
        }

        public MLWeahterSep clearTempRange() {
            this.f15531o = false;
            this.f15532p = "";
            return this;
        }

        public MLWeahterSep clearText() {
            this.f15519c = false;
            this.f15520d = "";
            return this;
        }

        public MLWeahterSep clearWeather() {
            this.f15529m = false;
            this.f15530n = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15538v < 0) {
                getSerializedSize();
            }
            return this.f15538v;
        }

        public String getCity() {
            return this.f15528l;
        }

        public String getCityIcon() {
            return this.f15536t;
        }

        public String getCityId() {
            return this.f15534r;
        }

        public BaseTitleContent getExtCard(int i) {
            return (BaseTitleContent) this.f15537u.get(i);
        }

        public int getExtCardCount() {
            return this.f15537u.size();
        }

        public List<BaseTitleContent> getExtCardList() {
            return this.f15537u;
        }

        public String getIcon() {
            return this.f15518b;
        }

        public String getJumpUrl() {
            return this.f15524h;
        }

        public String getLoc() {
            return this.f15526j;
        }

        public String getPm25() {
            return this.f15522f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasText()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getText());
            }
            if (hasPm25()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getPm25());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getJumpUrl());
            }
            if (hasLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getLoc());
            }
            if (hasCity()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getCity());
            }
            if (hasWeather()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getWeather());
            }
            if (hasTempRange()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getTempRange());
            }
            if (hasCityId()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getCityId());
            }
            if (hasCityIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getCityIcon());
            }
            int i2 = i;
            for (BaseTitleContent computeMessageSize : getExtCardList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(11, computeMessageSize) + i2;
            }
            this.f15538v = i2;
            return i2;
        }

        public String getTempRange() {
            return this.f15532p;
        }

        public String getText() {
            return this.f15520d;
        }

        public String getWeather() {
            return this.f15530n;
        }

        public boolean hasCity() {
            return this.f15527k;
        }

        public boolean hasCityIcon() {
            return this.f15535s;
        }

        public boolean hasCityId() {
            return this.f15533q;
        }

        public boolean hasIcon() {
            return this.f15517a;
        }

        public boolean hasJumpUrl() {
            return this.f15523g;
        }

        public boolean hasLoc() {
            return this.f15525i;
        }

        public boolean hasPm25() {
            return this.f15521e;
        }

        public boolean hasTempRange() {
            return this.f15531o;
        }

        public boolean hasText() {
            return this.f15519c;
        }

        public boolean hasWeather() {
            return this.f15529m;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MLWeahterSep mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setText(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setPm25(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setLoc(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setCity(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setWeather(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setTempRange(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setCityId(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setCityIcon(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        MessageMicro baseTitleContent = new BaseTitleContent();
                        codedInputStreamMicro.readMessage(baseTitleContent);
                        addExtCard(baseTitleContent);
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

        public MLWeahterSep setCity(String str) {
            this.f15527k = true;
            this.f15528l = str;
            return this;
        }

        public MLWeahterSep setCityIcon(String str) {
            this.f15535s = true;
            this.f15536t = str;
            return this;
        }

        public MLWeahterSep setCityId(String str) {
            this.f15533q = true;
            this.f15534r = str;
            return this;
        }

        public MLWeahterSep setExtCard(int i, BaseTitleContent baseTitleContent) {
            if (baseTitleContent != null) {
                this.f15537u.set(i, baseTitleContent);
            }
            return this;
        }

        public MLWeahterSep setIcon(String str) {
            this.f15517a = true;
            this.f15518b = str;
            return this;
        }

        public MLWeahterSep setJumpUrl(String str) {
            this.f15523g = true;
            this.f15524h = str;
            return this;
        }

        public MLWeahterSep setLoc(String str) {
            this.f15525i = true;
            this.f15526j = str;
            return this;
        }

        public MLWeahterSep setPm25(String str) {
            this.f15521e = true;
            this.f15522f = str;
            return this;
        }

        public MLWeahterSep setTempRange(String str) {
            this.f15531o = true;
            this.f15532p = str;
            return this;
        }

        public MLWeahterSep setText(String str) {
            this.f15519c = true;
            this.f15520d = str;
            return this;
        }

        public MLWeahterSep setWeather(String str) {
            this.f15529m = true;
            this.f15530n = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasText()) {
                codedOutputStreamMicro.writeString(2, getText());
            }
            if (hasPm25()) {
                codedOutputStreamMicro.writeString(3, getPm25());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(4, getJumpUrl());
            }
            if (hasLoc()) {
                codedOutputStreamMicro.writeString(5, getLoc());
            }
            if (hasCity()) {
                codedOutputStreamMicro.writeString(6, getCity());
            }
            if (hasWeather()) {
                codedOutputStreamMicro.writeString(7, getWeather());
            }
            if (hasTempRange()) {
                codedOutputStreamMicro.writeString(8, getTempRange());
            }
            if (hasCityId()) {
                codedOutputStreamMicro.writeString(9, getCityId());
            }
            if (hasCityIcon()) {
                codedOutputStreamMicro.writeString(10, getCityIcon());
            }
            for (BaseTitleContent writeMessage : getExtCardList()) {
                codedOutputStreamMicro.writeMessage(11, writeMessage);
            }
        }
    }

    public static final class MapShowButton extends MessageMicro {
        public static final int IS_SHOW_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15539a;
        /* renamed from: b */
        private int f15540b = 0;
        /* renamed from: c */
        private int f15541c = -1;

        public static MapShowButton parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new MapShowButton().mergeFrom(codedInputStreamMicro);
        }

        public static MapShowButton parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (MapShowButton) new MapShowButton().mergeFrom(bArr);
        }

        public final MapShowButton clear() {
            clearIsShow();
            this.f15541c = -1;
            return this;
        }

        public MapShowButton clearIsShow() {
            this.f15539a = false;
            this.f15540b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15541c < 0) {
                getSerializedSize();
            }
            return this.f15541c;
        }

        public int getIsShow() {
            return this.f15540b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIsShow()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getIsShow());
            }
            this.f15541c = i;
            return i;
        }

        public boolean hasIsShow() {
            return this.f15539a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MapShowButton mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsShow(codedInputStreamMicro.readInt32());
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

        public MapShowButton setIsShow(int i) {
            this.f15539a = true;
            this.f15540b = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsShow()) {
                codedOutputStreamMicro.writeInt32(1, getIsShow());
            }
        }
    }

    public static final class NMLCardResource extends MessageMicro {
        public static final int ARRIVE_CITY_NAME_FIELD_NUMBER = 6;
        public static final int ARRIVE_TIME_FIELD_NUMBER = 12;
        public static final int CARD_LINK_FIELD_NUMBER = 22;
        public static final int CARD_STATISTIC_TYPE_FIELD_NUMBER = 23;
        public static final int DEADLINE_TIME_FIELD_NUMBER = 10;
        public static final int DETAIL_TITLE_FIELD_NUMBER = 16;
        public static final int ICON_DELAY_FIELD_NUMBER = 2;
        public static final int ICON_DESC_FIELD_NUMBER = 3;
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int IS_CARLIMIT_FIELD_NUMBER = 18;
        public static final int IS_DELAY_FIELD_NUMBER = 4;
        public static final int IS_REQUEST_FIELD_NUMBER = 24;
        public static final int LEFT_TITLE1_FIELD_NUMBER = 14;
        public static final int LEFT_TITLE2_FIELD_NUMBER = 15;
        public static final int ORDER_TYPE_FIELD_NUMBER = 21;
        public static final int SHOW_TYPE_FIELD_NUMBER = 13;
        public static final int START_CITY_NAME_FIELD_NUMBER = 5;
        public static final int START_TIME_FIELD_NUMBER = 11;
        public static final int SUB_TITLE_FIELD_NUMBER = 8;
        public static final int TITLE_FIELD_NUMBER = 7;
        public static final int TRANSPORT_FIELD_NUMBER = 9;
        public static final int TRIP_EXT_FIELD_NUMBER = 17;
        public static final int TRIP_ID_FIELD_NUMBER = 19;
        public static final int TRIP_TYPE_FIELD_NUMBER = 20;
        /* renamed from: A */
        private String f15542A = "";
        /* renamed from: B */
        private boolean f15543B;
        /* renamed from: C */
        private String f15544C = "";
        /* renamed from: D */
        private List<String> f15545D = Collections.emptyList();
        /* renamed from: E */
        private boolean f15546E;
        /* renamed from: F */
        private TripExt f15547F = null;
        /* renamed from: G */
        private boolean f15548G;
        /* renamed from: H */
        private boolean f15549H = false;
        /* renamed from: I */
        private boolean f15550I;
        /* renamed from: J */
        private String f15551J = "";
        /* renamed from: K */
        private boolean f15552K;
        /* renamed from: L */
        private int f15553L = 0;
        /* renamed from: M */
        private boolean f15554M;
        /* renamed from: N */
        private String f15555N = "";
        /* renamed from: O */
        private boolean f15556O;
        /* renamed from: P */
        private String f15557P = "";
        /* renamed from: Q */
        private boolean f15558Q;
        /* renamed from: R */
        private int f15559R = 0;
        /* renamed from: S */
        private boolean f15560S;
        /* renamed from: T */
        private boolean f15561T = false;
        /* renamed from: U */
        private int f15562U = -1;
        /* renamed from: a */
        private boolean f15563a;
        /* renamed from: b */
        private String f15564b = "";
        /* renamed from: c */
        private boolean f15565c;
        /* renamed from: d */
        private String f15566d = "";
        /* renamed from: e */
        private boolean f15567e;
        /* renamed from: f */
        private String f15568f = "";
        /* renamed from: g */
        private boolean f15569g;
        /* renamed from: h */
        private int f15570h = 0;
        /* renamed from: i */
        private boolean f15571i;
        /* renamed from: j */
        private String f15572j = "";
        /* renamed from: k */
        private boolean f15573k;
        /* renamed from: l */
        private String f15574l = "";
        /* renamed from: m */
        private boolean f15575m;
        /* renamed from: n */
        private String f15576n = "";
        /* renamed from: o */
        private boolean f15577o;
        /* renamed from: p */
        private String f15578p = "";
        /* renamed from: q */
        private List<Transport> f15579q = Collections.emptyList();
        /* renamed from: r */
        private boolean f15580r;
        /* renamed from: s */
        private long f15581s = 0;
        /* renamed from: t */
        private boolean f15582t;
        /* renamed from: u */
        private String f15583u = "";
        /* renamed from: v */
        private boolean f15584v;
        /* renamed from: w */
        private String f15585w = "";
        /* renamed from: x */
        private boolean f15586x;
        /* renamed from: y */
        private int f15587y = 0;
        /* renamed from: z */
        private boolean f15588z;

        public static NMLCardResource parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new NMLCardResource().mergeFrom(codedInputStreamMicro);
        }

        public static NMLCardResource parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (NMLCardResource) new NMLCardResource().mergeFrom(bArr);
        }

        public NMLCardResource addDetailTitle(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f15545D.isEmpty()) {
                this.f15545D = new ArrayList();
            }
            this.f15545D.add(str);
            return this;
        }

        public NMLCardResource addTransport(Transport transport) {
            if (transport != null) {
                if (this.f15579q.isEmpty()) {
                    this.f15579q = new ArrayList();
                }
                this.f15579q.add(transport);
            }
            return this;
        }

        public final NMLCardResource clear() {
            clearIcon();
            clearIconDelay();
            clearIconDesc();
            clearIsDelay();
            clearStartCityName();
            clearArriveCityName();
            clearTitle();
            clearSubTitle();
            clearTransport();
            clearDeadlineTime();
            clearStartTime();
            clearArriveTime();
            clearShowType();
            clearLeftTitle1();
            clearLeftTitle2();
            clearDetailTitle();
            clearTripExt();
            clearIsCarlimit();
            clearTripId();
            clearTripType();
            clearOrderType();
            clearCardLink();
            clearCardStatisticType();
            clearIsRequest();
            this.f15562U = -1;
            return this;
        }

        public NMLCardResource clearArriveCityName() {
            this.f15573k = false;
            this.f15574l = "";
            return this;
        }

        public NMLCardResource clearArriveTime() {
            this.f15584v = false;
            this.f15585w = "";
            return this;
        }

        public NMLCardResource clearCardLink() {
            this.f15556O = false;
            this.f15557P = "";
            return this;
        }

        public NMLCardResource clearCardStatisticType() {
            this.f15558Q = false;
            this.f15559R = 0;
            return this;
        }

        public NMLCardResource clearDeadlineTime() {
            this.f15580r = false;
            this.f15581s = 0;
            return this;
        }

        public NMLCardResource clearDetailTitle() {
            this.f15545D = Collections.emptyList();
            return this;
        }

        public NMLCardResource clearIcon() {
            this.f15563a = false;
            this.f15564b = "";
            return this;
        }

        public NMLCardResource clearIconDelay() {
            this.f15565c = false;
            this.f15566d = "";
            return this;
        }

        public NMLCardResource clearIconDesc() {
            this.f15567e = false;
            this.f15568f = "";
            return this;
        }

        public NMLCardResource clearIsCarlimit() {
            this.f15548G = false;
            this.f15549H = false;
            return this;
        }

        public NMLCardResource clearIsDelay() {
            this.f15569g = false;
            this.f15570h = 0;
            return this;
        }

        public NMLCardResource clearIsRequest() {
            this.f15560S = false;
            this.f15561T = false;
            return this;
        }

        public NMLCardResource clearLeftTitle1() {
            this.f15588z = false;
            this.f15542A = "";
            return this;
        }

        public NMLCardResource clearLeftTitle2() {
            this.f15543B = false;
            this.f15544C = "";
            return this;
        }

        public NMLCardResource clearOrderType() {
            this.f15554M = false;
            this.f15555N = "";
            return this;
        }

        public NMLCardResource clearShowType() {
            this.f15586x = false;
            this.f15587y = 0;
            return this;
        }

        public NMLCardResource clearStartCityName() {
            this.f15571i = false;
            this.f15572j = "";
            return this;
        }

        public NMLCardResource clearStartTime() {
            this.f15582t = false;
            this.f15583u = "";
            return this;
        }

        public NMLCardResource clearSubTitle() {
            this.f15577o = false;
            this.f15578p = "";
            return this;
        }

        public NMLCardResource clearTitle() {
            this.f15575m = false;
            this.f15576n = "";
            return this;
        }

        public NMLCardResource clearTransport() {
            this.f15579q = Collections.emptyList();
            return this;
        }

        public NMLCardResource clearTripExt() {
            this.f15546E = false;
            this.f15547F = null;
            return this;
        }

        public NMLCardResource clearTripId() {
            this.f15550I = false;
            this.f15551J = "";
            return this;
        }

        public NMLCardResource clearTripType() {
            this.f15552K = false;
            this.f15553L = 0;
            return this;
        }

        public String getArriveCityName() {
            return this.f15574l;
        }

        public String getArriveTime() {
            return this.f15585w;
        }

        public int getCachedSize() {
            if (this.f15562U < 0) {
                getSerializedSize();
            }
            return this.f15562U;
        }

        public String getCardLink() {
            return this.f15557P;
        }

        public int getCardStatisticType() {
            return this.f15559R;
        }

        public long getDeadlineTime() {
            return this.f15581s;
        }

        public String getDetailTitle(int i) {
            return (String) this.f15545D.get(i);
        }

        public int getDetailTitleCount() {
            return this.f15545D.size();
        }

        public List<String> getDetailTitleList() {
            return this.f15545D;
        }

        public String getIcon() {
            return this.f15564b;
        }

        public String getIconDelay() {
            return this.f15566d;
        }

        public String getIconDesc() {
            return this.f15568f;
        }

        public boolean getIsCarlimit() {
            return this.f15549H;
        }

        public int getIsDelay() {
            return this.f15570h;
        }

        public boolean getIsRequest() {
            return this.f15561T;
        }

        public String getLeftTitle1() {
            return this.f15542A;
        }

        public String getLeftTitle2() {
            return this.f15544C;
        }

        public String getOrderType() {
            return this.f15555N;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasIcon() ? CodedOutputStreamMicro.computeStringSize(1, getIcon()) + 0 : 0;
            if (hasIconDelay()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(2, getIconDelay());
            }
            if (hasIconDesc()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(3, getIconDesc());
            }
            if (hasIsDelay()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(4, getIsDelay());
            }
            if (hasStartCityName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(5, getStartCityName());
            }
            if (hasArriveCityName()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(6, getArriveCityName());
            }
            if (hasTitle()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(7, getTitle());
            }
            if (hasSubTitle()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(8, getSubTitle());
            }
            int i2 = computeStringSize;
            for (Transport computeMessageSize : getTransportList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(9, computeMessageSize) + i2;
            }
            if (hasDeadlineTime()) {
                i2 += CodedOutputStreamMicro.computeInt64Size(10, getDeadlineTime());
            }
            if (hasStartTime()) {
                i2 += CodedOutputStreamMicro.computeStringSize(11, getStartTime());
            }
            if (hasArriveTime()) {
                i2 += CodedOutputStreamMicro.computeStringSize(12, getArriveTime());
            }
            if (hasShowType()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(13, getShowType());
            }
            if (hasLeftTitle1()) {
                i2 += CodedOutputStreamMicro.computeStringSize(14, getLeftTitle1());
            }
            if (hasLeftTitle2()) {
                i2 += CodedOutputStreamMicro.computeStringSize(15, getLeftTitle2());
            }
            for (String computeStringSizeNoTag : getDetailTitleList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeStringSize = (i2 + i) + (getDetailTitleList().size() * 2);
            if (hasTripExt()) {
                computeStringSize += CodedOutputStreamMicro.computeMessageSize(17, getTripExt());
            }
            if (hasIsCarlimit()) {
                computeStringSize += CodedOutputStreamMicro.computeBoolSize(18, getIsCarlimit());
            }
            if (hasTripId()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(19, getTripId());
            }
            if (hasTripType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(20, getTripType());
            }
            if (hasOrderType()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(21, getOrderType());
            }
            if (hasCardLink()) {
                computeStringSize += CodedOutputStreamMicro.computeStringSize(22, getCardLink());
            }
            if (hasCardStatisticType()) {
                computeStringSize += CodedOutputStreamMicro.computeInt32Size(23, getCardStatisticType());
            }
            if (hasIsRequest()) {
                computeStringSize += CodedOutputStreamMicro.computeBoolSize(24, getIsRequest());
            }
            this.f15562U = computeStringSize;
            return computeStringSize;
        }

        public int getShowType() {
            return this.f15587y;
        }

        public String getStartCityName() {
            return this.f15572j;
        }

        public String getStartTime() {
            return this.f15583u;
        }

        public String getSubTitle() {
            return this.f15578p;
        }

        public String getTitle() {
            return this.f15576n;
        }

        public Transport getTransport(int i) {
            return (Transport) this.f15579q.get(i);
        }

        public int getTransportCount() {
            return this.f15579q.size();
        }

        public List<Transport> getTransportList() {
            return this.f15579q;
        }

        public TripExt getTripExt() {
            return this.f15547F;
        }

        public String getTripId() {
            return this.f15551J;
        }

        public int getTripType() {
            return this.f15553L;
        }

        public boolean hasArriveCityName() {
            return this.f15573k;
        }

        public boolean hasArriveTime() {
            return this.f15584v;
        }

        public boolean hasCardLink() {
            return this.f15556O;
        }

        public boolean hasCardStatisticType() {
            return this.f15558Q;
        }

        public boolean hasDeadlineTime() {
            return this.f15580r;
        }

        public boolean hasIcon() {
            return this.f15563a;
        }

        public boolean hasIconDelay() {
            return this.f15565c;
        }

        public boolean hasIconDesc() {
            return this.f15567e;
        }

        public boolean hasIsCarlimit() {
            return this.f15548G;
        }

        public boolean hasIsDelay() {
            return this.f15569g;
        }

        public boolean hasIsRequest() {
            return this.f15560S;
        }

        public boolean hasLeftTitle1() {
            return this.f15588z;
        }

        public boolean hasLeftTitle2() {
            return this.f15543B;
        }

        public boolean hasOrderType() {
            return this.f15554M;
        }

        public boolean hasShowType() {
            return this.f15586x;
        }

        public boolean hasStartCityName() {
            return this.f15571i;
        }

        public boolean hasStartTime() {
            return this.f15582t;
        }

        public boolean hasSubTitle() {
            return this.f15577o;
        }

        public boolean hasTitle() {
            return this.f15575m;
        }

        public boolean hasTripExt() {
            return this.f15546E;
        }

        public boolean hasTripId() {
            return this.f15550I;
        }

        public boolean hasTripType() {
            return this.f15552K;
        }

        public final boolean isInitialized() {
            return true;
        }

        public NMLCardResource mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro transport;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setIconDelay(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setIconDesc(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setIsDelay(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setStartCityName(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setArriveCityName(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setSubTitle(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        transport = new Transport();
                        codedInputStreamMicro.readMessage(transport);
                        addTransport(transport);
                        continue;
                    case 80:
                        setDeadlineTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 90:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setArriveTime(codedInputStreamMicro.readString());
                        continue;
                    case 104:
                        setShowType(codedInputStreamMicro.readInt32());
                        continue;
                    case 114:
                        setLeftTitle1(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.df /*122*/:
                        setLeftTitle2(codedInputStreamMicro.readString());
                        continue;
                    case 130:
                        addDetailTitle(codedInputStreamMicro.readString());
                        continue;
                    case 138:
                        transport = new TripExt();
                        codedInputStreamMicro.readMessage(transport);
                        setTripExt(transport);
                        continue;
                    case 144:
                        setIsCarlimit(codedInputStreamMicro.readBool());
                        continue;
                    case 154:
                        setTripId(codedInputStreamMicro.readString());
                        continue;
                    case 160:
                        setTripType(codedInputStreamMicro.readInt32());
                        continue;
                    case 170:
                        setOrderType(codedInputStreamMicro.readString());
                        continue;
                    case 178:
                        setCardLink(codedInputStreamMicro.readString());
                        continue;
                    case 184:
                        setCardStatisticType(codedInputStreamMicro.readInt32());
                        continue;
                    case 192:
                        setIsRequest(codedInputStreamMicro.readBool());
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

        public NMLCardResource setArriveCityName(String str) {
            this.f15573k = true;
            this.f15574l = str;
            return this;
        }

        public NMLCardResource setArriveTime(String str) {
            this.f15584v = true;
            this.f15585w = str;
            return this;
        }

        public NMLCardResource setCardLink(String str) {
            this.f15556O = true;
            this.f15557P = str;
            return this;
        }

        public NMLCardResource setCardStatisticType(int i) {
            this.f15558Q = true;
            this.f15559R = i;
            return this;
        }

        public NMLCardResource setDeadlineTime(long j) {
            this.f15580r = true;
            this.f15581s = j;
            return this;
        }

        public NMLCardResource setDetailTitle(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f15545D.set(i, str);
            return this;
        }

        public NMLCardResource setIcon(String str) {
            this.f15563a = true;
            this.f15564b = str;
            return this;
        }

        public NMLCardResource setIconDelay(String str) {
            this.f15565c = true;
            this.f15566d = str;
            return this;
        }

        public NMLCardResource setIconDesc(String str) {
            this.f15567e = true;
            this.f15568f = str;
            return this;
        }

        public NMLCardResource setIsCarlimit(boolean z) {
            this.f15548G = true;
            this.f15549H = z;
            return this;
        }

        public NMLCardResource setIsDelay(int i) {
            this.f15569g = true;
            this.f15570h = i;
            return this;
        }

        public NMLCardResource setIsRequest(boolean z) {
            this.f15560S = true;
            this.f15561T = z;
            return this;
        }

        public NMLCardResource setLeftTitle1(String str) {
            this.f15588z = true;
            this.f15542A = str;
            return this;
        }

        public NMLCardResource setLeftTitle2(String str) {
            this.f15543B = true;
            this.f15544C = str;
            return this;
        }

        public NMLCardResource setOrderType(String str) {
            this.f15554M = true;
            this.f15555N = str;
            return this;
        }

        public NMLCardResource setShowType(int i) {
            this.f15586x = true;
            this.f15587y = i;
            return this;
        }

        public NMLCardResource setStartCityName(String str) {
            this.f15571i = true;
            this.f15572j = str;
            return this;
        }

        public NMLCardResource setStartTime(String str) {
            this.f15582t = true;
            this.f15583u = str;
            return this;
        }

        public NMLCardResource setSubTitle(String str) {
            this.f15577o = true;
            this.f15578p = str;
            return this;
        }

        public NMLCardResource setTitle(String str) {
            this.f15575m = true;
            this.f15576n = str;
            return this;
        }

        public NMLCardResource setTransport(int i, Transport transport) {
            if (transport != null) {
                this.f15579q.set(i, transport);
            }
            return this;
        }

        public NMLCardResource setTripExt(TripExt tripExt) {
            if (tripExt == null) {
                return clearTripExt();
            }
            this.f15546E = true;
            this.f15547F = tripExt;
            return this;
        }

        public NMLCardResource setTripId(String str) {
            this.f15550I = true;
            this.f15551J = str;
            return this;
        }

        public NMLCardResource setTripType(int i) {
            this.f15552K = true;
            this.f15553L = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasIconDelay()) {
                codedOutputStreamMicro.writeString(2, getIconDelay());
            }
            if (hasIconDesc()) {
                codedOutputStreamMicro.writeString(3, getIconDesc());
            }
            if (hasIsDelay()) {
                codedOutputStreamMicro.writeInt32(4, getIsDelay());
            }
            if (hasStartCityName()) {
                codedOutputStreamMicro.writeString(5, getStartCityName());
            }
            if (hasArriveCityName()) {
                codedOutputStreamMicro.writeString(6, getArriveCityName());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(7, getTitle());
            }
            if (hasSubTitle()) {
                codedOutputStreamMicro.writeString(8, getSubTitle());
            }
            for (Transport writeMessage : getTransportList()) {
                codedOutputStreamMicro.writeMessage(9, writeMessage);
            }
            if (hasDeadlineTime()) {
                codedOutputStreamMicro.writeInt64(10, getDeadlineTime());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(11, getStartTime());
            }
            if (hasArriveTime()) {
                codedOutputStreamMicro.writeString(12, getArriveTime());
            }
            if (hasShowType()) {
                codedOutputStreamMicro.writeInt32(13, getShowType());
            }
            if (hasLeftTitle1()) {
                codedOutputStreamMicro.writeString(14, getLeftTitle1());
            }
            if (hasLeftTitle2()) {
                codedOutputStreamMicro.writeString(15, getLeftTitle2());
            }
            for (String writeString : getDetailTitleList()) {
                codedOutputStreamMicro.writeString(16, writeString);
            }
            if (hasTripExt()) {
                codedOutputStreamMicro.writeMessage(17, getTripExt());
            }
            if (hasIsCarlimit()) {
                codedOutputStreamMicro.writeBool(18, getIsCarlimit());
            }
            if (hasTripId()) {
                codedOutputStreamMicro.writeString(19, getTripId());
            }
            if (hasTripType()) {
                codedOutputStreamMicro.writeInt32(20, getTripType());
            }
            if (hasOrderType()) {
                codedOutputStreamMicro.writeString(21, getOrderType());
            }
            if (hasCardLink()) {
                codedOutputStreamMicro.writeString(22, getCardLink());
            }
            if (hasCardStatisticType()) {
                codedOutputStreamMicro.writeInt32(23, getCardStatisticType());
            }
            if (hasIsRequest()) {
                codedOutputStreamMicro.writeBool(24, getIsRequest());
            }
        }
    }

    public static final class NMLHeader extends MessageMicro {
        public static final int ELEM_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<NMLHeaderElem> f15589a = Collections.emptyList();
        /* renamed from: b */
        private int f15590b = -1;

        public static NMLHeader parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new NMLHeader().mergeFrom(codedInputStreamMicro);
        }

        public static NMLHeader parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (NMLHeader) new NMLHeader().mergeFrom(bArr);
        }

        public NMLHeader addElem(NMLHeaderElem nMLHeaderElem) {
            if (nMLHeaderElem != null) {
                if (this.f15589a.isEmpty()) {
                    this.f15589a = new ArrayList();
                }
                this.f15589a.add(nMLHeaderElem);
            }
            return this;
        }

        public final NMLHeader clear() {
            clearElem();
            this.f15590b = -1;
            return this;
        }

        public NMLHeader clearElem() {
            this.f15589a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15590b < 0) {
                getSerializedSize();
            }
            return this.f15590b;
        }

        public NMLHeaderElem getElem(int i) {
            return (NMLHeaderElem) this.f15589a.get(i);
        }

        public int getElemCount() {
            return this.f15589a.size();
        }

        public List<NMLHeaderElem> getElemList() {
            return this.f15589a;
        }

        public int getSerializedSize() {
            int i = 0;
            for (NMLHeaderElem computeMessageSize : getElemList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f15590b = i;
            return i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public NMLHeader mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro nMLHeaderElem = new NMLHeaderElem();
                        codedInputStreamMicro.readMessage(nMLHeaderElem);
                        addElem(nMLHeaderElem);
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

        public NMLHeader setElem(int i, NMLHeaderElem nMLHeaderElem) {
            if (nMLHeaderElem != null) {
                this.f15589a.set(i, nMLHeaderElem);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (NMLHeaderElem writeMessage : getElemList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class NMLHeaderElem extends MessageMicro {
        public static final int ELEMS_FIELD_NUMBER = 2;
        public static final int ICON_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15591a;
        /* renamed from: b */
        private String f15592b = "";
        /* renamed from: c */
        private List<String> f15593c = Collections.emptyList();
        /* renamed from: d */
        private int f15594d = -1;

        public static NMLHeaderElem parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new NMLHeaderElem().mergeFrom(codedInputStreamMicro);
        }

        public static NMLHeaderElem parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (NMLHeaderElem) new NMLHeaderElem().mergeFrom(bArr);
        }

        public NMLHeaderElem addElems(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f15593c.isEmpty()) {
                this.f15593c = new ArrayList();
            }
            this.f15593c.add(str);
            return this;
        }

        public final NMLHeaderElem clear() {
            clearIcon();
            clearElems();
            this.f15594d = -1;
            return this;
        }

        public NMLHeaderElem clearElems() {
            this.f15593c = Collections.emptyList();
            return this;
        }

        public NMLHeaderElem clearIcon() {
            this.f15591a = false;
            this.f15592b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15594d < 0) {
                getSerializedSize();
            }
            return this.f15594d;
        }

        public String getElems(int i) {
            return (String) this.f15593c.get(i);
        }

        public int getElemsCount() {
            return this.f15593c.size();
        }

        public List<String> getElemsList() {
            return this.f15593c;
        }

        public String getIcon() {
            return this.f15592b;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeStringSize = hasIcon() ? CodedOutputStreamMicro.computeStringSize(1, getIcon()) + 0 : 0;
            for (String computeStringSizeNoTag : getElemsList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            int size = (computeStringSize + i) + (getElemsList().size() * 1);
            this.f15594d = size;
            return size;
        }

        public boolean hasIcon() {
            return this.f15591a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public NMLHeaderElem mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        addElems(codedInputStreamMicro.readString());
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

        public NMLHeaderElem setElems(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f15593c.set(i, str);
            return this;
        }

        public NMLHeaderElem setIcon(String str) {
            this.f15591a = true;
            this.f15592b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            for (String writeString : getElemsList()) {
                codedOutputStreamMicro.writeString(2, writeString);
            }
        }
    }

    public static final class NearMainList extends MessageMicro {
        public static final int AIDE_URL_FIELD_NUMBER = 3;
        public static final int CARDRESOURCE_FIELD_NUMBER = 2;
        public static final int HEADER_FIELD_NUMBER = 1;
        public static final int IS_SHOW_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15595a;
        /* renamed from: b */
        private NMLHeader f15596b = null;
        /* renamed from: c */
        private List<NMLCardResource> f15597c = Collections.emptyList();
        /* renamed from: d */
        private boolean f15598d;
        /* renamed from: e */
        private String f15599e = "";
        /* renamed from: f */
        private boolean f15600f;
        /* renamed from: g */
        private boolean f15601g = false;
        /* renamed from: h */
        private int f15602h = -1;

        public static NearMainList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new NearMainList().mergeFrom(codedInputStreamMicro);
        }

        public static NearMainList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (NearMainList) new NearMainList().mergeFrom(bArr);
        }

        public NearMainList addCardresource(NMLCardResource nMLCardResource) {
            if (nMLCardResource != null) {
                if (this.f15597c.isEmpty()) {
                    this.f15597c = new ArrayList();
                }
                this.f15597c.add(nMLCardResource);
            }
            return this;
        }

        public final NearMainList clear() {
            clearHeader();
            clearCardresource();
            clearAideUrl();
            clearIsShow();
            this.f15602h = -1;
            return this;
        }

        public NearMainList clearAideUrl() {
            this.f15598d = false;
            this.f15599e = "";
            return this;
        }

        public NearMainList clearCardresource() {
            this.f15597c = Collections.emptyList();
            return this;
        }

        public NearMainList clearHeader() {
            this.f15595a = false;
            this.f15596b = null;
            return this;
        }

        public NearMainList clearIsShow() {
            this.f15600f = false;
            this.f15601g = false;
            return this;
        }

        public String getAideUrl() {
            return this.f15599e;
        }

        public int getCachedSize() {
            if (this.f15602h < 0) {
                getSerializedSize();
            }
            return this.f15602h;
        }

        public NMLCardResource getCardresource(int i) {
            return (NMLCardResource) this.f15597c.get(i);
        }

        public int getCardresourceCount() {
            return this.f15597c.size();
        }

        public List<NMLCardResource> getCardresourceList() {
            return this.f15597c;
        }

        public NMLHeader getHeader() {
            return this.f15596b;
        }

        public boolean getIsShow() {
            return this.f15601g;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasHeader()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getHeader());
            }
            int i2 = i;
            for (NMLCardResource computeMessageSize : getCardresourceList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasAideUrl()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getAideUrl());
            }
            if (hasIsShow()) {
                i2 += CodedOutputStreamMicro.computeBoolSize(4, getIsShow());
            }
            this.f15602h = i2;
            return i2;
        }

        public boolean hasAideUrl() {
            return this.f15598d;
        }

        public boolean hasHeader() {
            return this.f15595a;
        }

        public boolean hasIsShow() {
            return this.f15600f;
        }

        public final boolean isInitialized() {
            return true;
        }

        public NearMainList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro nMLHeader;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        nMLHeader = new NMLHeader();
                        codedInputStreamMicro.readMessage(nMLHeader);
                        setHeader(nMLHeader);
                        continue;
                    case 18:
                        nMLHeader = new NMLCardResource();
                        codedInputStreamMicro.readMessage(nMLHeader);
                        addCardresource(nMLHeader);
                        continue;
                    case 26:
                        setAideUrl(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setIsShow(codedInputStreamMicro.readBool());
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

        public NearMainList setAideUrl(String str) {
            this.f15598d = true;
            this.f15599e = str;
            return this;
        }

        public NearMainList setCardresource(int i, NMLCardResource nMLCardResource) {
            if (nMLCardResource != null) {
                this.f15597c.set(i, nMLCardResource);
            }
            return this;
        }

        public NearMainList setHeader(NMLHeader nMLHeader) {
            if (nMLHeader == null) {
                return clearHeader();
            }
            this.f15595a = true;
            this.f15596b = nMLHeader;
            return this;
        }

        public NearMainList setIsShow(boolean z) {
            this.f15600f = true;
            this.f15601g = z;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasHeader()) {
                codedOutputStreamMicro.writeMessage(1, getHeader());
            }
            for (NMLCardResource writeMessage : getCardresourceList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasAideUrl()) {
                codedOutputStreamMicro.writeString(3, getAideUrl());
            }
            if (hasIsShow()) {
                codedOutputStreamMicro.writeBool(4, getIsShow());
            }
        }
    }

    public static final class NotifyContent extends MessageMicro {
        public static final int JUMP_URL_FIELD_NUMBER = 2;
        public static final int NOTIFY_TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15603a;
        /* renamed from: b */
        private String f15604b = "";
        /* renamed from: c */
        private boolean f15605c;
        /* renamed from: d */
        private String f15606d = "";
        /* renamed from: e */
        private int f15607e = -1;

        public static NotifyContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new NotifyContent().mergeFrom(codedInputStreamMicro);
        }

        public static NotifyContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (NotifyContent) new NotifyContent().mergeFrom(bArr);
        }

        public final NotifyContent clear() {
            clearNotifyTitle();
            clearJumpUrl();
            this.f15607e = -1;
            return this;
        }

        public NotifyContent clearJumpUrl() {
            this.f15605c = false;
            this.f15606d = "";
            return this;
        }

        public NotifyContent clearNotifyTitle() {
            this.f15603a = false;
            this.f15604b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15607e < 0) {
                getSerializedSize();
            }
            return this.f15607e;
        }

        public String getJumpUrl() {
            return this.f15606d;
        }

        public String getNotifyTitle() {
            return this.f15604b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasNotifyTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getNotifyTitle());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getJumpUrl());
            }
            this.f15607e = i;
            return i;
        }

        public boolean hasJumpUrl() {
            return this.f15605c;
        }

        public boolean hasNotifyTitle() {
            return this.f15603a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public NotifyContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setNotifyTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setJumpUrl(codedInputStreamMicro.readString());
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

        public NotifyContent setJumpUrl(String str) {
            this.f15605c = true;
            this.f15606d = str;
            return this;
        }

        public NotifyContent setNotifyTitle(String str) {
            this.f15603a = true;
            this.f15604b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasNotifyTitle()) {
                codedOutputStreamMicro.writeString(1, getNotifyTitle());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(2, getJumpUrl());
            }
        }
    }

    public static final class OrderSet extends MessageMicro {
        public static final int ORDER_NAME_FIELD_NUMBER = 2;
        public static final int ORDER_TYPE_FIELD_NUMBER = 1;
        public static final int STATUS_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15608a;
        /* renamed from: b */
        private String f15609b = "";
        /* renamed from: c */
        private boolean f15610c;
        /* renamed from: d */
        private String f15611d = "";
        /* renamed from: e */
        private boolean f15612e;
        /* renamed from: f */
        private int f15613f = 0;
        /* renamed from: g */
        private int f15614g = -1;

        public static OrderSet parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new OrderSet().mergeFrom(codedInputStreamMicro);
        }

        public static OrderSet parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (OrderSet) new OrderSet().mergeFrom(bArr);
        }

        public final OrderSet clear() {
            clearOrderType();
            clearOrderName();
            clearStatus();
            this.f15614g = -1;
            return this;
        }

        public OrderSet clearOrderName() {
            this.f15610c = false;
            this.f15611d = "";
            return this;
        }

        public OrderSet clearOrderType() {
            this.f15608a = false;
            this.f15609b = "";
            return this;
        }

        public OrderSet clearStatus() {
            this.f15612e = false;
            this.f15613f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15614g < 0) {
                getSerializedSize();
            }
            return this.f15614g;
        }

        public String getOrderName() {
            return this.f15611d;
        }

        public String getOrderType() {
            return this.f15609b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasOrderType()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getOrderType());
            }
            if (hasOrderName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getOrderName());
            }
            if (hasStatus()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getStatus());
            }
            this.f15614g = i;
            return i;
        }

        public int getStatus() {
            return this.f15613f;
        }

        public boolean hasOrderName() {
            return this.f15610c;
        }

        public boolean hasOrderType() {
            return this.f15608a;
        }

        public boolean hasStatus() {
            return this.f15612e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public OrderSet mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setOrderType(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setOrderName(codedInputStreamMicro.readString());
                        continue;
                    case 24:
                        setStatus(codedInputStreamMicro.readInt32());
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

        public OrderSet setOrderName(String str) {
            this.f15610c = true;
            this.f15611d = str;
            return this;
        }

        public OrderSet setOrderType(String str) {
            this.f15608a = true;
            this.f15609b = str;
            return this;
        }

        public OrderSet setStatus(int i) {
            this.f15612e = true;
            this.f15613f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasOrderType()) {
                codedOutputStreamMicro.writeString(1, getOrderType());
            }
            if (hasOrderName()) {
                codedOutputStreamMicro.writeString(2, getOrderName());
            }
            if (hasStatus()) {
                codedOutputStreamMicro.writeInt32(3, getStatus());
            }
        }
    }

    public static final class PageContent extends MessageMicro {
        public static final int DRIVER_PAGE_CONTENT_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15615a;
        /* renamed from: b */
        private DriverPageContent f15616b = null;
        /* renamed from: c */
        private int f15617c = -1;

        public static PageContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new PageContent().mergeFrom(codedInputStreamMicro);
        }

        public static PageContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (PageContent) new PageContent().mergeFrom(bArr);
        }

        public final PageContent clear() {
            clearDriverPageContent();
            this.f15617c = -1;
            return this;
        }

        public PageContent clearDriverPageContent() {
            this.f15615a = false;
            this.f15616b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15617c < 0) {
                getSerializedSize();
            }
            return this.f15617c;
        }

        public DriverPageContent getDriverPageContent() {
            return this.f15616b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDriverPageContent()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDriverPageContent());
            }
            this.f15617c = i;
            return i;
        }

        public boolean hasDriverPageContent() {
            return this.f15615a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public PageContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro driverPageContent = new DriverPageContent();
                        codedInputStreamMicro.readMessage(driverPageContent);
                        setDriverPageContent(driverPageContent);
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

        public PageContent setDriverPageContent(DriverPageContent driverPageContent) {
            if (driverPageContent == null) {
                return clearDriverPageContent();
            }
            this.f15615a = true;
            this.f15616b = driverPageContent;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDriverPageContent()) {
                codedOutputStreamMicro.writeMessage(1, getDriverPageContent());
            }
        }
    }

    public static final class RecPOI extends MessageMicro {
        public static final int DIS_FIELD_NUMBER = 4;
        public static final int ICON_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15618a;
        /* renamed from: b */
        private String f15619b = "";
        /* renamed from: c */
        private boolean f15620c;
        /* renamed from: d */
        private String f15621d = "";
        /* renamed from: e */
        private boolean f15622e;
        /* renamed from: f */
        private String f15623f = "";
        /* renamed from: g */
        private boolean f15624g;
        /* renamed from: h */
        private int f15625h = 0;
        /* renamed from: i */
        private int f15626i = -1;

        public static RecPOI parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new RecPOI().mergeFrom(codedInputStreamMicro);
        }

        public static RecPOI parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (RecPOI) new RecPOI().mergeFrom(bArr);
        }

        public final RecPOI clear() {
            clearUid();
            clearName();
            clearIcon();
            clearDis();
            this.f15626i = -1;
            return this;
        }

        public RecPOI clearDis() {
            this.f15624g = false;
            this.f15625h = 0;
            return this;
        }

        public RecPOI clearIcon() {
            this.f15622e = false;
            this.f15623f = "";
            return this;
        }

        public RecPOI clearName() {
            this.f15620c = false;
            this.f15621d = "";
            return this;
        }

        public RecPOI clearUid() {
            this.f15618a = false;
            this.f15619b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15626i < 0) {
                getSerializedSize();
            }
            return this.f15626i;
        }

        public int getDis() {
            return this.f15625h;
        }

        public String getIcon() {
            return this.f15623f;
        }

        public String getName() {
            return this.f15621d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasUid()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getUid());
            }
            if (hasName()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getName());
            }
            if (hasIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getIcon());
            }
            if (hasDis()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getDis());
            }
            this.f15626i = i;
            return i;
        }

        public String getUid() {
            return this.f15619b;
        }

        public boolean hasDis() {
            return this.f15624g;
        }

        public boolean hasIcon() {
            return this.f15622e;
        }

        public boolean hasName() {
            return this.f15620c;
        }

        public boolean hasUid() {
            return this.f15618a;
        }

        public final boolean isInitialized() {
            return this.f15618a && this.f15620c && this.f15622e && this.f15624g;
        }

        public RecPOI mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setUid(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setIcon(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setDis(codedInputStreamMicro.readInt32());
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

        public RecPOI setDis(int i) {
            this.f15624g = true;
            this.f15625h = i;
            return this;
        }

        public RecPOI setIcon(String str) {
            this.f15622e = true;
            this.f15623f = str;
            return this;
        }

        public RecPOI setName(String str) {
            this.f15620c = true;
            this.f15621d = str;
            return this;
        }

        public RecPOI setUid(String str) {
            this.f15618a = true;
            this.f15619b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasUid()) {
                codedOutputStreamMicro.writeString(1, getUid());
            }
            if (hasName()) {
                codedOutputStreamMicro.writeString(2, getName());
            }
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(3, getIcon());
            }
            if (hasDis()) {
                codedOutputStreamMicro.writeInt32(4, getDis());
            }
        }
    }

    public static final class SceneEntry extends MessageMicro {
        public static final int CHECKIMAGEAREA_FIELD_NUMBER = 3;
        public static final int CHECKRESIDENTCITY_FIELD_NUMBER = 2;
        public static final int ISREDPOINTSHOW_FIELD_NUMBER = 5;
        public static final int ISSHOW_FIELD_NUMBER = 1;
        public static final int NO_TRIP_CONTENT_FIELD_NUMBER = 6;
        public static final int NO_TRIP_URL_FIELD_NUMBER = 7;
        public static final int RESIDENTCITYS_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15627a;
        /* renamed from: b */
        private boolean f15628b = false;
        /* renamed from: c */
        private boolean f15629c;
        /* renamed from: d */
        private boolean f15630d = false;
        /* renamed from: e */
        private boolean f15631e;
        /* renamed from: f */
        private boolean f15632f = false;
        /* renamed from: g */
        private List<String> f15633g = Collections.emptyList();
        /* renamed from: h */
        private boolean f15634h;
        /* renamed from: i */
        private boolean f15635i = false;
        /* renamed from: j */
        private boolean f15636j;
        /* renamed from: k */
        private String f15637k = "";
        /* renamed from: l */
        private boolean f15638l;
        /* renamed from: m */
        private String f15639m = "";
        /* renamed from: n */
        private int f15640n = -1;

        public static SceneEntry parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SceneEntry().mergeFrom(codedInputStreamMicro);
        }

        public static SceneEntry parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SceneEntry) new SceneEntry().mergeFrom(bArr);
        }

        public SceneEntry addResidentCitys(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            if (this.f15633g.isEmpty()) {
                this.f15633g = new ArrayList();
            }
            this.f15633g.add(str);
            return this;
        }

        public final SceneEntry clear() {
            clearIsShow();
            clearCheckResidentCity();
            clearCheckImageArea();
            clearResidentCitys();
            clearIsRedPointShow();
            clearNoTripContent();
            clearNoTripUrl();
            this.f15640n = -1;
            return this;
        }

        public SceneEntry clearCheckImageArea() {
            this.f15631e = false;
            this.f15632f = false;
            return this;
        }

        public SceneEntry clearCheckResidentCity() {
            this.f15629c = false;
            this.f15630d = false;
            return this;
        }

        public SceneEntry clearIsRedPointShow() {
            this.f15634h = false;
            this.f15635i = false;
            return this;
        }

        public SceneEntry clearIsShow() {
            this.f15627a = false;
            this.f15628b = false;
            return this;
        }

        public SceneEntry clearNoTripContent() {
            this.f15636j = false;
            this.f15637k = "";
            return this;
        }

        public SceneEntry clearNoTripUrl() {
            this.f15638l = false;
            this.f15639m = "";
            return this;
        }

        public SceneEntry clearResidentCitys() {
            this.f15633g = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15640n < 0) {
                getSerializedSize();
            }
            return this.f15640n;
        }

        public boolean getCheckImageArea() {
            return this.f15632f;
        }

        public boolean getCheckResidentCity() {
            return this.f15630d;
        }

        public boolean getIsRedPointShow() {
            return this.f15635i;
        }

        public boolean getIsShow() {
            return this.f15628b;
        }

        public String getNoTripContent() {
            return this.f15637k;
        }

        public String getNoTripUrl() {
            return this.f15639m;
        }

        public String getResidentCitys(int i) {
            return (String) this.f15633g.get(i);
        }

        public int getResidentCitysCount() {
            return this.f15633g.size();
        }

        public List<String> getResidentCitysList() {
            return this.f15633g;
        }

        public int getSerializedSize() {
            int i = 0;
            int computeBoolSize = hasIsShow() ? CodedOutputStreamMicro.computeBoolSize(1, getIsShow()) + 0 : 0;
            if (hasCheckResidentCity()) {
                computeBoolSize += CodedOutputStreamMicro.computeBoolSize(2, getCheckResidentCity());
            }
            int computeBoolSize2 = hasCheckImageArea() ? computeBoolSize + CodedOutputStreamMicro.computeBoolSize(3, getCheckImageArea()) : computeBoolSize;
            for (String computeStringSizeNoTag : getResidentCitysList()) {
                i += CodedOutputStreamMicro.computeStringSizeNoTag(computeStringSizeNoTag);
            }
            computeBoolSize = (computeBoolSize2 + i) + (getResidentCitysList().size() * 1);
            if (hasIsRedPointShow()) {
                computeBoolSize += CodedOutputStreamMicro.computeBoolSize(5, getIsRedPointShow());
            }
            if (hasNoTripContent()) {
                computeBoolSize += CodedOutputStreamMicro.computeStringSize(6, getNoTripContent());
            }
            if (hasNoTripUrl()) {
                computeBoolSize += CodedOutputStreamMicro.computeStringSize(7, getNoTripUrl());
            }
            this.f15640n = computeBoolSize;
            return computeBoolSize;
        }

        public boolean hasCheckImageArea() {
            return this.f15631e;
        }

        public boolean hasCheckResidentCity() {
            return this.f15629c;
        }

        public boolean hasIsRedPointShow() {
            return this.f15634h;
        }

        public boolean hasIsShow() {
            return this.f15627a;
        }

        public boolean hasNoTripContent() {
            return this.f15636j;
        }

        public boolean hasNoTripUrl() {
            return this.f15638l;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SceneEntry mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setIsShow(codedInputStreamMicro.readBool());
                        continue;
                    case 16:
                        setCheckResidentCity(codedInputStreamMicro.readBool());
                        continue;
                    case 24:
                        setCheckImageArea(codedInputStreamMicro.readBool());
                        continue;
                    case 34:
                        addResidentCitys(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setIsRedPointShow(codedInputStreamMicro.readBool());
                        continue;
                    case 50:
                        setNoTripContent(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setNoTripUrl(codedInputStreamMicro.readString());
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

        public SceneEntry setCheckImageArea(boolean z) {
            this.f15631e = true;
            this.f15632f = z;
            return this;
        }

        public SceneEntry setCheckResidentCity(boolean z) {
            this.f15629c = true;
            this.f15630d = z;
            return this;
        }

        public SceneEntry setIsRedPointShow(boolean z) {
            this.f15634h = true;
            this.f15635i = z;
            return this;
        }

        public SceneEntry setIsShow(boolean z) {
            this.f15627a = true;
            this.f15628b = z;
            return this;
        }

        public SceneEntry setNoTripContent(String str) {
            this.f15636j = true;
            this.f15637k = str;
            return this;
        }

        public SceneEntry setNoTripUrl(String str) {
            this.f15638l = true;
            this.f15639m = str;
            return this;
        }

        public SceneEntry setResidentCitys(int i, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f15633g.set(i, str);
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIsShow()) {
                codedOutputStreamMicro.writeBool(1, getIsShow());
            }
            if (hasCheckResidentCity()) {
                codedOutputStreamMicro.writeBool(2, getCheckResidentCity());
            }
            if (hasCheckImageArea()) {
                codedOutputStreamMicro.writeBool(3, getCheckImageArea());
            }
            for (String writeString : getResidentCitysList()) {
                codedOutputStreamMicro.writeString(4, writeString);
            }
            if (hasIsRedPointShow()) {
                codedOutputStreamMicro.writeBool(5, getIsRedPointShow());
            }
            if (hasNoTripContent()) {
                codedOutputStreamMicro.writeString(6, getNoTripContent());
            }
            if (hasNoTripUrl()) {
                codedOutputStreamMicro.writeString(7, getNoTripUrl());
            }
        }
    }

    public static final class ShareLinkInfo extends MessageMicro {
        public static final int SHARE_ICON_FIELD_NUMBER = 2;
        public static final int SHARE_SUBTITLE_FIELD_NUMBER = 4;
        public static final int SHARE_TITLE_FIELD_NUMBER = 3;
        public static final int SHARE_URL_FIELD_NUMBER = 1;
        public static final int SHARE_WEIBO_ICON_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f15641a;
        /* renamed from: b */
        private String f15642b = "";
        /* renamed from: c */
        private boolean f15643c;
        /* renamed from: d */
        private String f15644d = "";
        /* renamed from: e */
        private boolean f15645e;
        /* renamed from: f */
        private String f15646f = "";
        /* renamed from: g */
        private boolean f15647g;
        /* renamed from: h */
        private String f15648h = "";
        /* renamed from: i */
        private boolean f15649i;
        /* renamed from: j */
        private String f15650j = "";
        /* renamed from: k */
        private int f15651k = -1;

        public static ShareLinkInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ShareLinkInfo().mergeFrom(codedInputStreamMicro);
        }

        public static ShareLinkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ShareLinkInfo) new ShareLinkInfo().mergeFrom(bArr);
        }

        public final ShareLinkInfo clear() {
            clearShareUrl();
            clearShareIcon();
            clearShareTitle();
            clearShareSubtitle();
            clearShareWeiboIcon();
            this.f15651k = -1;
            return this;
        }

        public ShareLinkInfo clearShareIcon() {
            this.f15643c = false;
            this.f15644d = "";
            return this;
        }

        public ShareLinkInfo clearShareSubtitle() {
            this.f15647g = false;
            this.f15648h = "";
            return this;
        }

        public ShareLinkInfo clearShareTitle() {
            this.f15645e = false;
            this.f15646f = "";
            return this;
        }

        public ShareLinkInfo clearShareUrl() {
            this.f15641a = false;
            this.f15642b = "";
            return this;
        }

        public ShareLinkInfo clearShareWeiboIcon() {
            this.f15649i = false;
            this.f15650j = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15651k < 0) {
                getSerializedSize();
            }
            return this.f15651k;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasShareUrl()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getShareUrl());
            }
            if (hasShareIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getShareIcon());
            }
            if (hasShareTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getShareTitle());
            }
            if (hasShareSubtitle()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getShareSubtitle());
            }
            if (hasShareWeiboIcon()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getShareWeiboIcon());
            }
            this.f15651k = i;
            return i;
        }

        public String getShareIcon() {
            return this.f15644d;
        }

        public String getShareSubtitle() {
            return this.f15648h;
        }

        public String getShareTitle() {
            return this.f15646f;
        }

        public String getShareUrl() {
            return this.f15642b;
        }

        public String getShareWeiboIcon() {
            return this.f15650j;
        }

        public boolean hasShareIcon() {
            return this.f15643c;
        }

        public boolean hasShareSubtitle() {
            return this.f15647g;
        }

        public boolean hasShareTitle() {
            return this.f15645e;
        }

        public boolean hasShareUrl() {
            return this.f15641a;
        }

        public boolean hasShareWeiboIcon() {
            return this.f15649i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ShareLinkInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setShareUrl(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setShareIcon(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setShareTitle(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setShareSubtitle(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setShareWeiboIcon(codedInputStreamMicro.readString());
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

        public ShareLinkInfo setShareIcon(String str) {
            this.f15643c = true;
            this.f15644d = str;
            return this;
        }

        public ShareLinkInfo setShareSubtitle(String str) {
            this.f15647g = true;
            this.f15648h = str;
            return this;
        }

        public ShareLinkInfo setShareTitle(String str) {
            this.f15645e = true;
            this.f15646f = str;
            return this;
        }

        public ShareLinkInfo setShareUrl(String str) {
            this.f15641a = true;
            this.f15642b = str;
            return this;
        }

        public ShareLinkInfo setShareWeiboIcon(String str) {
            this.f15649i = true;
            this.f15650j = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasShareUrl()) {
                codedOutputStreamMicro.writeString(1, getShareUrl());
            }
            if (hasShareIcon()) {
                codedOutputStreamMicro.writeString(2, getShareIcon());
            }
            if (hasShareTitle()) {
                codedOutputStreamMicro.writeString(3, getShareTitle());
            }
            if (hasShareSubtitle()) {
                codedOutputStreamMicro.writeString(4, getShareSubtitle());
            }
            if (hasShareWeiboIcon()) {
                codedOutputStreamMicro.writeString(5, getShareWeiboIcon());
            }
        }
    }

    public static final class ShareTrip extends MessageMicro {
        public static final int CARDS_FIELD_NUMBER = 2;
        public static final int DAY_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15652a;
        /* renamed from: b */
        private long f15653b = 0;
        /* renamed from: c */
        private List<CardResource> f15654c = Collections.emptyList();
        /* renamed from: d */
        private int f15655d = -1;

        public static ShareTrip parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ShareTrip().mergeFrom(codedInputStreamMicro);
        }

        public static ShareTrip parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ShareTrip) new ShareTrip().mergeFrom(bArr);
        }

        public ShareTrip addCards(CardResource cardResource) {
            if (cardResource != null) {
                if (this.f15654c.isEmpty()) {
                    this.f15654c = new ArrayList();
                }
                this.f15654c.add(cardResource);
            }
            return this;
        }

        public final ShareTrip clear() {
            clearDay();
            clearCards();
            this.f15655d = -1;
            return this;
        }

        public ShareTrip clearCards() {
            this.f15654c = Collections.emptyList();
            return this;
        }

        public ShareTrip clearDay() {
            this.f15652a = false;
            this.f15653b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15655d < 0) {
                getSerializedSize();
            }
            return this.f15655d;
        }

        public CardResource getCards(int i) {
            return (CardResource) this.f15654c.get(i);
        }

        public int getCardsCount() {
            return this.f15654c.size();
        }

        public List<CardResource> getCardsList() {
            return this.f15654c;
        }

        public long getDay() {
            return this.f15653b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasDay()) {
                i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getDay());
            }
            int i2 = i;
            for (CardResource computeMessageSize : getCardsList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f15655d = i2;
            return i2;
        }

        public boolean hasDay() {
            return this.f15652a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ShareTrip mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setDay(codedInputStreamMicro.readInt64());
                        continue;
                    case 18:
                        MessageMicro cardResource = new CardResource();
                        codedInputStreamMicro.readMessage(cardResource);
                        addCards(cardResource);
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

        public ShareTrip setCards(int i, CardResource cardResource) {
            if (cardResource != null) {
                this.f15654c.set(i, cardResource);
            }
            return this;
        }

        public ShareTrip setDay(long j) {
            this.f15652a = true;
            this.f15653b = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasDay()) {
                codedOutputStreamMicro.writeInt64(1, getDay());
            }
            for (CardResource writeMessage : getCardsList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class ShareTripGroup extends MessageMicro {
        public static final int SHARE_TRIP_FIELD_NUMBER = 1;
        public static final int SHARE_URL_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<ShareTrip> f15656a = Collections.emptyList();
        /* renamed from: b */
        private boolean f15657b;
        /* renamed from: c */
        private String f15658c = "";
        /* renamed from: d */
        private int f15659d = -1;

        public static ShareTripGroup parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ShareTripGroup().mergeFrom(codedInputStreamMicro);
        }

        public static ShareTripGroup parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ShareTripGroup) new ShareTripGroup().mergeFrom(bArr);
        }

        public ShareTripGroup addShareTrip(ShareTrip shareTrip) {
            if (shareTrip != null) {
                if (this.f15656a.isEmpty()) {
                    this.f15656a = new ArrayList();
                }
                this.f15656a.add(shareTrip);
            }
            return this;
        }

        public final ShareTripGroup clear() {
            clearShareTrip();
            clearShareUrl();
            this.f15659d = -1;
            return this;
        }

        public ShareTripGroup clearShareTrip() {
            this.f15656a = Collections.emptyList();
            return this;
        }

        public ShareTripGroup clearShareUrl() {
            this.f15657b = false;
            this.f15658c = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15659d < 0) {
                getSerializedSize();
            }
            return this.f15659d;
        }

        public int getSerializedSize() {
            int i = 0;
            for (ShareTrip computeMessageSize : getShareTripList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasShareUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getShareUrl());
            }
            this.f15659d = i;
            return i;
        }

        public ShareTrip getShareTrip(int i) {
            return (ShareTrip) this.f15656a.get(i);
        }

        public int getShareTripCount() {
            return this.f15656a.size();
        }

        public List<ShareTrip> getShareTripList() {
            return this.f15656a;
        }

        public String getShareUrl() {
            return this.f15658c;
        }

        public boolean hasShareUrl() {
            return this.f15657b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ShareTripGroup mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro shareTrip = new ShareTrip();
                        codedInputStreamMicro.readMessage(shareTrip);
                        addShareTrip(shareTrip);
                        continue;
                    case 18:
                        setShareUrl(codedInputStreamMicro.readString());
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

        public ShareTripGroup setShareTrip(int i, ShareTrip shareTrip) {
            if (shareTrip != null) {
                this.f15656a.set(i, shareTrip);
            }
            return this;
        }

        public ShareTripGroup setShareUrl(String str) {
            this.f15657b = true;
            this.f15658c = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (ShareTrip writeMessage : getShareTripList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasShareUrl()) {
                codedOutputStreamMicro.writeString(2, getShareUrl());
            }
        }
    }

    public static final class ShareTripInfo extends MessageMicro {
        public static final int SHARE_TRIP_GROUP_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15660a;
        /* renamed from: b */
        private ShareTripGroup f15661b = null;
        /* renamed from: c */
        private int f15662c = -1;

        public static ShareTripInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new ShareTripInfo().mergeFrom(codedInputStreamMicro);
        }

        public static ShareTripInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (ShareTripInfo) new ShareTripInfo().mergeFrom(bArr);
        }

        public final ShareTripInfo clear() {
            clearShareTripGroup();
            this.f15662c = -1;
            return this;
        }

        public ShareTripInfo clearShareTripGroup() {
            this.f15660a = false;
            this.f15661b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15662c < 0) {
                getSerializedSize();
            }
            return this.f15662c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasShareTripGroup()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getShareTripGroup());
            }
            this.f15662c = i;
            return i;
        }

        public ShareTripGroup getShareTripGroup() {
            return this.f15661b;
        }

        public boolean hasShareTripGroup() {
            return this.f15660a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ShareTripInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro shareTripGroup = new ShareTripGroup();
                        codedInputStreamMicro.readMessage(shareTripGroup);
                        setShareTripGroup(shareTripGroup);
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

        public ShareTripInfo setShareTripGroup(ShareTripGroup shareTripGroup) {
            if (shareTripGroup == null) {
                return clearShareTripGroup();
            }
            this.f15660a = true;
            this.f15661b = shareTripGroup;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasShareTripGroup()) {
                codedOutputStreamMicro.writeMessage(1, getShareTripGroup());
            }
        }
    }

    public static final class SmsOrder extends MessageMicro {
        public static final int DSTR_FIELD_NUMBER = 2;
        public static final int LSTR_FIELD_NUMBER = 4;
        public static final int MSTR_FIELD_NUMBER = 1;
        public static final int TSTR_FIELD_NUMBER = 3;
        /* renamed from: a */
        private boolean f15663a;
        /* renamed from: b */
        private int f15664b = 0;
        /* renamed from: c */
        private boolean f15665c;
        /* renamed from: d */
        private int f15666d = 0;
        /* renamed from: e */
        private boolean f15667e;
        /* renamed from: f */
        private int f15668f = 0;
        /* renamed from: g */
        private boolean f15669g;
        /* renamed from: h */
        private int f15670h = 0;
        /* renamed from: i */
        private int f15671i = -1;

        public static SmsOrder parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SmsOrder().mergeFrom(codedInputStreamMicro);
        }

        public static SmsOrder parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SmsOrder) new SmsOrder().mergeFrom(bArr);
        }

        public final SmsOrder clear() {
            clearMstr();
            clearDstr();
            clearTstr();
            clearLstr();
            this.f15671i = -1;
            return this;
        }

        public SmsOrder clearDstr() {
            this.f15665c = false;
            this.f15666d = 0;
            return this;
        }

        public SmsOrder clearLstr() {
            this.f15669g = false;
            this.f15670h = 0;
            return this;
        }

        public SmsOrder clearMstr() {
            this.f15663a = false;
            this.f15664b = 0;
            return this;
        }

        public SmsOrder clearTstr() {
            this.f15667e = false;
            this.f15668f = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15671i < 0) {
                getSerializedSize();
            }
            return this.f15671i;
        }

        public int getDstr() {
            return this.f15666d;
        }

        public int getLstr() {
            return this.f15670h;
        }

        public int getMstr() {
            return this.f15664b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMstr()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getMstr());
            }
            if (hasDstr()) {
                i += CodedOutputStreamMicro.computeInt32Size(2, getDstr());
            }
            if (hasTstr()) {
                i += CodedOutputStreamMicro.computeInt32Size(3, getTstr());
            }
            if (hasLstr()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getLstr());
            }
            this.f15671i = i;
            return i;
        }

        public int getTstr() {
            return this.f15668f;
        }

        public boolean hasDstr() {
            return this.f15665c;
        }

        public boolean hasLstr() {
            return this.f15669g;
        }

        public boolean hasMstr() {
            return this.f15663a;
        }

        public boolean hasTstr() {
            return this.f15667e;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SmsOrder mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setMstr(codedInputStreamMicro.readInt32());
                        continue;
                    case 16:
                        setDstr(codedInputStreamMicro.readInt32());
                        continue;
                    case 24:
                        setTstr(codedInputStreamMicro.readInt32());
                        continue;
                    case 32:
                        setLstr(codedInputStreamMicro.readInt32());
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

        public SmsOrder setDstr(int i) {
            this.f15665c = true;
            this.f15666d = i;
            return this;
        }

        public SmsOrder setLstr(int i) {
            this.f15669g = true;
            this.f15670h = i;
            return this;
        }

        public SmsOrder setMstr(int i) {
            this.f15663a = true;
            this.f15664b = i;
            return this;
        }

        public SmsOrder setTstr(int i) {
            this.f15667e = true;
            this.f15668f = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMstr()) {
                codedOutputStreamMicro.writeInt32(1, getMstr());
            }
            if (hasDstr()) {
                codedOutputStreamMicro.writeInt32(2, getDstr());
            }
            if (hasTstr()) {
                codedOutputStreamMicro.writeInt32(3, getTstr());
            }
            if (hasLstr()) {
                codedOutputStreamMicro.writeInt32(4, getLstr());
            }
        }
    }

    public static final class SmsSubTermDate extends MessageMicro {
        public static final int BUFFER_FIELD_NUMBER = 5;
        public static final int EXPRESSION_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        public static final int SAMPLE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 4;
        /* renamed from: a */
        private boolean f15672a;
        /* renamed from: b */
        private String f15673b = "";
        /* renamed from: c */
        private boolean f15674c;
        /* renamed from: d */
        private SmsOrder f15675d = null;
        /* renamed from: e */
        private boolean f15676e;
        /* renamed from: f */
        private String f15677f = "";
        /* renamed from: g */
        private boolean f15678g;
        /* renamed from: h */
        private String f15679h = "";
        /* renamed from: i */
        private boolean f15680i;
        /* renamed from: j */
        private int f15681j = 0;
        /* renamed from: k */
        private int f15682k = -1;

        public static SmsSubTermDate parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SmsSubTermDate().mergeFrom(codedInputStreamMicro);
        }

        public static SmsSubTermDate parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SmsSubTermDate) new SmsSubTermDate().mergeFrom(bArr);
        }

        public final SmsSubTermDate clear() {
            clearExpression();
            clearOrder();
            clearSample();
            clearType();
            clearBuffer();
            this.f15682k = -1;
            return this;
        }

        public SmsSubTermDate clearBuffer() {
            this.f15680i = false;
            this.f15681j = 0;
            return this;
        }

        public SmsSubTermDate clearExpression() {
            this.f15672a = false;
            this.f15673b = "";
            return this;
        }

        public SmsSubTermDate clearOrder() {
            this.f15674c = false;
            this.f15675d = null;
            return this;
        }

        public SmsSubTermDate clearSample() {
            this.f15676e = false;
            this.f15677f = "";
            return this;
        }

        public SmsSubTermDate clearType() {
            this.f15678g = false;
            this.f15679h = "";
            return this;
        }

        public int getBuffer() {
            return this.f15681j;
        }

        public int getCachedSize() {
            if (this.f15682k < 0) {
                getSerializedSize();
            }
            return this.f15682k;
        }

        public String getExpression() {
            return this.f15673b;
        }

        public SmsOrder getOrder() {
            return this.f15675d;
        }

        public String getSample() {
            return this.f15677f;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasExpression()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getExpression());
            }
            if (hasOrder()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getOrder());
            }
            if (hasSample()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getSample());
            }
            if (hasType()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getType());
            }
            if (hasBuffer()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getBuffer());
            }
            this.f15682k = i;
            return i;
        }

        public String getType() {
            return this.f15679h;
        }

        public boolean hasBuffer() {
            return this.f15680i;
        }

        public boolean hasExpression() {
            return this.f15672a;
        }

        public boolean hasOrder() {
            return this.f15674c;
        }

        public boolean hasSample() {
            return this.f15676e;
        }

        public boolean hasType() {
            return this.f15678g;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SmsSubTermDate mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setExpression(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro smsOrder = new SmsOrder();
                        codedInputStreamMicro.readMessage(smsOrder);
                        setOrder(smsOrder);
                        continue;
                    case 26:
                        setSample(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setType(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setBuffer(codedInputStreamMicro.readInt32());
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

        public SmsSubTermDate setBuffer(int i) {
            this.f15680i = true;
            this.f15681j = i;
            return this;
        }

        public SmsSubTermDate setExpression(String str) {
            this.f15672a = true;
            this.f15673b = str;
            return this;
        }

        public SmsSubTermDate setOrder(SmsOrder smsOrder) {
            if (smsOrder == null) {
                return clearOrder();
            }
            this.f15674c = true;
            this.f15675d = smsOrder;
            return this;
        }

        public SmsSubTermDate setSample(String str) {
            this.f15676e = true;
            this.f15677f = str;
            return this;
        }

        public SmsSubTermDate setType(String str) {
            this.f15678g = true;
            this.f15679h = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasExpression()) {
                codedOutputStreamMicro.writeString(1, getExpression());
            }
            if (hasOrder()) {
                codedOutputStreamMicro.writeMessage(2, getOrder());
            }
            if (hasSample()) {
                codedOutputStreamMicro.writeString(3, getSample());
            }
            if (hasType()) {
                codedOutputStreamMicro.writeString(4, getType());
            }
            if (hasBuffer()) {
                codedOutputStreamMicro.writeInt32(5, getBuffer());
            }
        }
    }

    public static final class SmsTermData extends MessageMicro {
        public static final int COMPANY_FIELD_NUMBER = 1;
        public static final int PATTERN_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15683a;
        /* renamed from: b */
        private String f15684b = "";
        /* renamed from: c */
        private List<SmsSubTermDate> f15685c = Collections.emptyList();
        /* renamed from: d */
        private int f15686d = -1;

        public static SmsTermData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SmsTermData().mergeFrom(codedInputStreamMicro);
        }

        public static SmsTermData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SmsTermData) new SmsTermData().mergeFrom(bArr);
        }

        public SmsTermData addPattern(SmsSubTermDate smsSubTermDate) {
            if (smsSubTermDate != null) {
                if (this.f15685c.isEmpty()) {
                    this.f15685c = new ArrayList();
                }
                this.f15685c.add(smsSubTermDate);
            }
            return this;
        }

        public final SmsTermData clear() {
            clearCompany();
            clearPattern();
            this.f15686d = -1;
            return this;
        }

        public SmsTermData clearCompany() {
            this.f15683a = false;
            this.f15684b = "";
            return this;
        }

        public SmsTermData clearPattern() {
            this.f15685c = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15686d < 0) {
                getSerializedSize();
            }
            return this.f15686d;
        }

        public String getCompany() {
            return this.f15684b;
        }

        public SmsSubTermDate getPattern(int i) {
            return (SmsSubTermDate) this.f15685c.get(i);
        }

        public int getPatternCount() {
            return this.f15685c.size();
        }

        public List<SmsSubTermDate> getPatternList() {
            return this.f15685c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasCompany()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getCompany());
            }
            int i2 = i;
            for (SmsSubTermDate computeMessageSize : getPatternList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            this.f15686d = i2;
            return i2;
        }

        public boolean hasCompany() {
            return this.f15683a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SmsTermData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setCompany(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro smsSubTermDate = new SmsSubTermDate();
                        codedInputStreamMicro.readMessage(smsSubTermDate);
                        addPattern(smsSubTermDate);
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

        public SmsTermData setCompany(String str) {
            this.f15683a = true;
            this.f15684b = str;
            return this;
        }

        public SmsTermData setPattern(int i, SmsSubTermDate smsSubTermDate) {
            if (smsSubTermDate != null) {
                this.f15685c.set(i, smsSubTermDate);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasCompany()) {
                codedOutputStreamMicro.writeString(1, getCompany());
            }
            for (SmsSubTermDate writeMessage : getPatternList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
        }
    }

    public static final class SmsUploadInfo extends MessageMicro {
        public static final int SMS_ID_FIELD_NUMBER = 1;
        public static final int SMS_UPLOAD_CNT_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15687a;
        /* renamed from: b */
        private String f15688b = "";
        /* renamed from: c */
        private boolean f15689c;
        /* renamed from: d */
        private long f15690d = 0;
        /* renamed from: e */
        private int f15691e = -1;

        public static SmsUploadInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new SmsUploadInfo().mergeFrom(codedInputStreamMicro);
        }

        public static SmsUploadInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (SmsUploadInfo) new SmsUploadInfo().mergeFrom(bArr);
        }

        public final SmsUploadInfo clear() {
            clearSmsId();
            clearSmsUploadCnt();
            this.f15691e = -1;
            return this;
        }

        public SmsUploadInfo clearSmsId() {
            this.f15687a = false;
            this.f15688b = "";
            return this;
        }

        public SmsUploadInfo clearSmsUploadCnt() {
            this.f15689c = false;
            this.f15690d = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15691e < 0) {
                getSerializedSize();
            }
            return this.f15691e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSmsId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getSmsId());
            }
            if (hasSmsUploadCnt()) {
                i += CodedOutputStreamMicro.computeInt64Size(2, getSmsUploadCnt());
            }
            this.f15691e = i;
            return i;
        }

        public String getSmsId() {
            return this.f15688b;
        }

        public long getSmsUploadCnt() {
            return this.f15690d;
        }

        public boolean hasSmsId() {
            return this.f15687a;
        }

        public boolean hasSmsUploadCnt() {
            return this.f15689c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public SmsUploadInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setSmsId(codedInputStreamMicro.readString());
                        continue;
                    case 16:
                        setSmsUploadCnt(codedInputStreamMicro.readInt64());
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

        public SmsUploadInfo setSmsId(String str) {
            this.f15687a = true;
            this.f15688b = str;
            return this;
        }

        public SmsUploadInfo setSmsUploadCnt(long j) {
            this.f15689c = true;
            this.f15690d = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSmsId()) {
                codedOutputStreamMicro.writeString(1, getSmsId());
            }
            if (hasSmsUploadCnt()) {
                codedOutputStreamMicro.writeInt64(2, getSmsUploadCnt());
            }
        }
    }

    public static final class Station extends MessageMicro {
        public static final int EXT_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15692a;
        /* renamed from: b */
        private String f15693b = "";
        /* renamed from: c */
        private boolean f15694c;
        /* renamed from: d */
        private String f15695d = "";
        /* renamed from: e */
        private int f15696e = -1;

        public static Station parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Station().mergeFrom(codedInputStreamMicro);
        }

        public static Station parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Station) new Station().mergeFrom(bArr);
        }

        public final Station clear() {
            clearName();
            clearExt();
            this.f15696e = -1;
            return this;
        }

        public Station clearExt() {
            this.f15694c = false;
            this.f15695d = "";
            return this;
        }

        public Station clearName() {
            this.f15692a = false;
            this.f15693b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15696e < 0) {
                getSerializedSize();
            }
            return this.f15696e;
        }

        public String getExt() {
            return this.f15695d;
        }

        public String getName() {
            return this.f15693b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasName()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getName());
            }
            if (hasExt()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getExt());
            }
            this.f15696e = i;
            return i;
        }

        public boolean hasExt() {
            return this.f15694c;
        }

        public boolean hasName() {
            return this.f15692a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Station mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setName(codedInputStreamMicro.readString());
                        continue;
                    case 18:
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

        public Station setExt(String str) {
            this.f15694c = true;
            this.f15695d = str;
            return this;
        }

        public Station setName(String str) {
            this.f15692a = true;
            this.f15693b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasName()) {
                codedOutputStreamMicro.writeString(1, getName());
            }
            if (hasExt()) {
                codedOutputStreamMicro.writeString(2, getExt());
            }
        }
    }

    public static final class TaContent extends MessageMicro {
        public static final int BASE_MAP_LIST_FIELD_NUMBER = 21;
        public static final int CALENDAR_UPLOAD_INFO_FIELD_NUMBER = 23;
        public static final int CONTROL_DATA_FIELD_NUMBER = 30;
        public static final int DRIVER_PAGE_INFO_FIELD_NUMBER = 24;
        public static final int EDIT_INFO_FIELD_NUMBER = 2;
        public static final int FLIGHT_DATA_FIELD_NUMBER = 10;
        public static final int FLIGHT_DETAIL_FIELD_NUMBER = 12;
        public static final int FLIGHT_LIST_FIELD_NUMBER = 9;
        public static final int FLIGHT_SUG_DATA_FIELD_NUMBER = 11;
        public static final int JUMP_URL_FIELD_NUMBER = 27;
        public static final int MAIN_LIST_FIELD_NUMBER = 1;
        public static final int MAP_SHOW_FIELD_NUMBER = 16;
        public static final int NEAR_LIST_FIELD_NUMBER = 15;
        public static final int ORDER_SETS_FIELD_NUMBER = 8;
        public static final int PAGE_CONTENT_FIELD_NUMBER = 28;
        public static final int POINT_SUG_FIELD_NUMBER = 31;
        public static final int POI_FIELD_NUMBER = 3;
        public static final int REC_POI_FIELD_NUMBER = 4;
        public static final int REMIND_CONTENT_FIELD_NUMBER = 25;
        public static final int REMIND_SUB_CONTENT_FIELD_NUMBER = 26;
        public static final int SHARE_LINK_INFO_FIELD_NUMBER = 20;
        public static final int SHARE_TRIP_INFO_FIELD_NUMBER = 18;
        public static final int SMS_CONFIG_DATA_FIELD_NUMBER = 22;
        public static final int SMS_UPLOAD_INFO_FIELD_NUMBER = 37;
        public static final int SUG_TRIP_TYPE_FIELD_NUMBER = 39;
        public static final int TRAIN_CITY_INFO_FIELD_NUMBER = 13;
        public static final int TRAIN_DETAIL_CONTENT_FIELD_NUMBER = 34;
        public static final int TRAIN_DETAIL_INFO_FIELD_NUMBER = 35;
        public static final int TRAIN_LIST_FIELD_NUMBER = 14;
        public static final int TRAIN_NO_FIELD_NUMBER = 36;
        public static final int TRAIN_STOP_INFO_FIELD_NUMBER = 17;
        public static final int TRAVEL_MOD_SUG_FIELD_NUMBER = 32;
        public static final int TRIP_FIELD_NUMBER = 38;
        public static final int TRIP_TITLE_SUG_FIELD_NUMBER = 33;
        public static final int TRIP_UPDATE_INFO_FIELD_NUMBER = 7;
        public static final int UI_DATA_FIELD_NUMBER = 29;
        public static final int UPDATE_RC_INFO_FIELD_NUMBER = 6;
        public static final int UPDATE_REMIND_INFO_FIELD_NUMBER = 5;
        public static final int VERSION_FIELD_NUMBER = 19;
        /* renamed from: A */
        private List<TrainStopData> f15697A = Collections.emptyList();
        /* renamed from: B */
        private boolean f15698B;
        /* renamed from: C */
        private ShareTripInfo f15699C = null;
        /* renamed from: D */
        private boolean f15700D;
        /* renamed from: E */
        private long f15701E = 0;
        /* renamed from: F */
        private boolean f15702F;
        /* renamed from: G */
        private ShareLinkInfo f15703G = null;
        /* renamed from: H */
        private boolean f15704H;
        /* renamed from: I */
        private BaseMapList f15705I = null;
        /* renamed from: J */
        private boolean f15706J;
        /* renamed from: K */
        private String f15707K = "";
        /* renamed from: L */
        private boolean f15708L;
        /* renamed from: M */
        private CalendarUploadInfo f15709M = null;
        /* renamed from: N */
        private List<DriverPageInfo> f15710N = Collections.emptyList();
        /* renamed from: O */
        private boolean f15711O;
        /* renamed from: P */
        private String f15712P = "";
        /* renamed from: Q */
        private boolean f15713Q;
        /* renamed from: R */
        private String f15714R = "";
        /* renamed from: S */
        private boolean f15715S;
        /* renamed from: T */
        private String f15716T = "";
        /* renamed from: U */
        private boolean f15717U;
        /* renamed from: V */
        private PageContent f15718V = null;
        /* renamed from: W */
        private boolean f15719W;
        /* renamed from: X */
        private UiData f15720X = null;
        /* renamed from: Y */
        private boolean f15721Y;
        /* renamed from: Z */
        private ControlData f15722Z = null;
        /* renamed from: a */
        private boolean f15723a;
        private List<AddPagePointSug> aa = Collections.emptyList();
        private List<AddPageTravelModSug> ab = Collections.emptyList();
        private List<AddPageTripTitleSug> ac = Collections.emptyList();
        private boolean ad;
        private String ae = "";
        private List<TrainDetailInfo> af = Collections.emptyList();
        private boolean ag;
        private String ah = "";
        private boolean ai;
        private SmsUploadInfo aj = null;
        private boolean ak;
        private MLTrip al = null;
        private boolean am;
        private int an = 0;
        private int ao = -1;
        /* renamed from: b */
        private ML f15724b = null;
        /* renamed from: c */
        private boolean f15725c;
        /* renamed from: d */
        private UpdateInfo f15726d = null;
        /* renamed from: e */
        private List<TaPOI> f15727e = Collections.emptyList();
        /* renamed from: f */
        private List<RecPOI> f15728f = Collections.emptyList();
        /* renamed from: g */
        private boolean f15729g;
        /* renamed from: h */
        private UpdateRemindInfo f15730h = null;
        /* renamed from: i */
        private boolean f15731i;
        /* renamed from: j */
        private UpdateRCInfo f15732j = null;
        /* renamed from: k */
        private boolean f15733k;
        /* renamed from: l */
        private IsTripUpdate f15734l = null;
        /* renamed from: m */
        private List<OrderSet> f15735m = Collections.emptyList();
        /* renamed from: n */
        private List<FlightConfigData> f15736n = Collections.emptyList();
        /* renamed from: o */
        private boolean f15737o;
        /* renamed from: p */
        private FlightCheckData f15738p = null;
        /* renamed from: q */
        private boolean f15739q;
        /* renamed from: r */
        private FlightSugData f15740r = null;
        /* renamed from: s */
        private List<FlightNoDetailData> f15741s = Collections.emptyList();
        /* renamed from: t */
        private boolean f15742t;
        /* renamed from: u */
        private TrainCityInfo f15743u = null;
        /* renamed from: v */
        private List<TrainList> f15744v = Collections.emptyList();
        /* renamed from: w */
        private boolean f15745w;
        /* renamed from: x */
        private NearMainList f15746x = null;
        /* renamed from: y */
        private boolean f15747y;
        /* renamed from: z */
        private MapShowButton f15748z = null;

        public static TaContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TaContent().mergeFrom(codedInputStreamMicro);
        }

        public static TaContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TaContent) new TaContent().mergeFrom(bArr);
        }

        public TaContent addDriverPageInfo(DriverPageInfo driverPageInfo) {
            if (driverPageInfo != null) {
                if (this.f15710N.isEmpty()) {
                    this.f15710N = new ArrayList();
                }
                this.f15710N.add(driverPageInfo);
            }
            return this;
        }

        public TaContent addFlightDetail(FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                if (this.f15741s.isEmpty()) {
                    this.f15741s = new ArrayList();
                }
                this.f15741s.add(flightNoDetailData);
            }
            return this;
        }

        public TaContent addFlightList(FlightConfigData flightConfigData) {
            if (flightConfigData != null) {
                if (this.f15736n.isEmpty()) {
                    this.f15736n = new ArrayList();
                }
                this.f15736n.add(flightConfigData);
            }
            return this;
        }

        public TaContent addOrderSets(OrderSet orderSet) {
            if (orderSet != null) {
                if (this.f15735m.isEmpty()) {
                    this.f15735m = new ArrayList();
                }
                this.f15735m.add(orderSet);
            }
            return this;
        }

        public TaContent addPoi(TaPOI taPOI) {
            if (taPOI != null) {
                if (this.f15727e.isEmpty()) {
                    this.f15727e = new ArrayList();
                }
                this.f15727e.add(taPOI);
            }
            return this;
        }

        public TaContent addPointSug(AddPagePointSug addPagePointSug) {
            if (addPagePointSug != null) {
                if (this.aa.isEmpty()) {
                    this.aa = new ArrayList();
                }
                this.aa.add(addPagePointSug);
            }
            return this;
        }

        public TaContent addRecPoi(RecPOI recPOI) {
            if (recPOI != null) {
                if (this.f15728f.isEmpty()) {
                    this.f15728f = new ArrayList();
                }
                this.f15728f.add(recPOI);
            }
            return this;
        }

        public TaContent addTrainDetailInfo(TrainDetailInfo trainDetailInfo) {
            if (trainDetailInfo != null) {
                if (this.af.isEmpty()) {
                    this.af = new ArrayList();
                }
                this.af.add(trainDetailInfo);
            }
            return this;
        }

        public TaContent addTrainList(TrainList trainList) {
            if (trainList != null) {
                if (this.f15744v.isEmpty()) {
                    this.f15744v = new ArrayList();
                }
                this.f15744v.add(trainList);
            }
            return this;
        }

        public TaContent addTrainStopInfo(TrainStopData trainStopData) {
            if (trainStopData != null) {
                if (this.f15697A.isEmpty()) {
                    this.f15697A = new ArrayList();
                }
                this.f15697A.add(trainStopData);
            }
            return this;
        }

        public TaContent addTravelModSug(AddPageTravelModSug addPageTravelModSug) {
            if (addPageTravelModSug != null) {
                if (this.ab.isEmpty()) {
                    this.ab = new ArrayList();
                }
                this.ab.add(addPageTravelModSug);
            }
            return this;
        }

        public TaContent addTripTitleSug(AddPageTripTitleSug addPageTripTitleSug) {
            if (addPageTripTitleSug != null) {
                if (this.ac.isEmpty()) {
                    this.ac = new ArrayList();
                }
                this.ac.add(addPageTripTitleSug);
            }
            return this;
        }

        public final TaContent clear() {
            clearMainList();
            clearEditInfo();
            clearPoi();
            clearRecPoi();
            clearUpdateRemindInfo();
            clearUpdateRcInfo();
            clearTripUpdateInfo();
            clearOrderSets();
            clearFlightList();
            clearFlightData();
            clearFlightSugData();
            clearFlightDetail();
            clearTrainCityInfo();
            clearTrainList();
            clearNearList();
            clearMapShow();
            clearTrainStopInfo();
            clearShareTripInfo();
            clearVersion();
            clearShareLinkInfo();
            clearBaseMapList();
            clearSmsConfigData();
            clearCalendarUploadInfo();
            clearDriverPageInfo();
            clearRemindContent();
            clearRemindSubContent();
            clearJumpUrl();
            clearPageContent();
            clearUiData();
            clearControlData();
            clearPointSug();
            clearTravelModSug();
            clearTripTitleSug();
            clearTrainDetailContent();
            clearTrainDetailInfo();
            clearTrainNo();
            clearSmsUploadInfo();
            clearTrip();
            clearSugTripType();
            this.ao = -1;
            return this;
        }

        public TaContent clearBaseMapList() {
            this.f15704H = false;
            this.f15705I = null;
            return this;
        }

        public TaContent clearCalendarUploadInfo() {
            this.f15708L = false;
            this.f15709M = null;
            return this;
        }

        public TaContent clearControlData() {
            this.f15721Y = false;
            this.f15722Z = null;
            return this;
        }

        public TaContent clearDriverPageInfo() {
            this.f15710N = Collections.emptyList();
            return this;
        }

        public TaContent clearEditInfo() {
            this.f15725c = false;
            this.f15726d = null;
            return this;
        }

        public TaContent clearFlightData() {
            this.f15737o = false;
            this.f15738p = null;
            return this;
        }

        public TaContent clearFlightDetail() {
            this.f15741s = Collections.emptyList();
            return this;
        }

        public TaContent clearFlightList() {
            this.f15736n = Collections.emptyList();
            return this;
        }

        public TaContent clearFlightSugData() {
            this.f15739q = false;
            this.f15740r = null;
            return this;
        }

        public TaContent clearJumpUrl() {
            this.f15715S = false;
            this.f15716T = "";
            return this;
        }

        public TaContent clearMainList() {
            this.f15723a = false;
            this.f15724b = null;
            return this;
        }

        public TaContent clearMapShow() {
            this.f15747y = false;
            this.f15748z = null;
            return this;
        }

        public TaContent clearNearList() {
            this.f15745w = false;
            this.f15746x = null;
            return this;
        }

        public TaContent clearOrderSets() {
            this.f15735m = Collections.emptyList();
            return this;
        }

        public TaContent clearPageContent() {
            this.f15717U = false;
            this.f15718V = null;
            return this;
        }

        public TaContent clearPoi() {
            this.f15727e = Collections.emptyList();
            return this;
        }

        public TaContent clearPointSug() {
            this.aa = Collections.emptyList();
            return this;
        }

        public TaContent clearRecPoi() {
            this.f15728f = Collections.emptyList();
            return this;
        }

        public TaContent clearRemindContent() {
            this.f15711O = false;
            this.f15712P = "";
            return this;
        }

        public TaContent clearRemindSubContent() {
            this.f15713Q = false;
            this.f15714R = "";
            return this;
        }

        public TaContent clearShareLinkInfo() {
            this.f15702F = false;
            this.f15703G = null;
            return this;
        }

        public TaContent clearShareTripInfo() {
            this.f15698B = false;
            this.f15699C = null;
            return this;
        }

        public TaContent clearSmsConfigData() {
            this.f15706J = false;
            this.f15707K = "";
            return this;
        }

        public TaContent clearSmsUploadInfo() {
            this.ai = false;
            this.aj = null;
            return this;
        }

        public TaContent clearSugTripType() {
            this.am = false;
            this.an = 0;
            return this;
        }

        public TaContent clearTrainCityInfo() {
            this.f15742t = false;
            this.f15743u = null;
            return this;
        }

        public TaContent clearTrainDetailContent() {
            this.ad = false;
            this.ae = "";
            return this;
        }

        public TaContent clearTrainDetailInfo() {
            this.af = Collections.emptyList();
            return this;
        }

        public TaContent clearTrainList() {
            this.f15744v = Collections.emptyList();
            return this;
        }

        public TaContent clearTrainNo() {
            this.ag = false;
            this.ah = "";
            return this;
        }

        public TaContent clearTrainStopInfo() {
            this.f15697A = Collections.emptyList();
            return this;
        }

        public TaContent clearTravelModSug() {
            this.ab = Collections.emptyList();
            return this;
        }

        public TaContent clearTrip() {
            this.ak = false;
            this.al = null;
            return this;
        }

        public TaContent clearTripTitleSug() {
            this.ac = Collections.emptyList();
            return this;
        }

        public TaContent clearTripUpdateInfo() {
            this.f15733k = false;
            this.f15734l = null;
            return this;
        }

        public TaContent clearUiData() {
            this.f15719W = false;
            this.f15720X = null;
            return this;
        }

        public TaContent clearUpdateRcInfo() {
            this.f15731i = false;
            this.f15732j = null;
            return this;
        }

        public TaContent clearUpdateRemindInfo() {
            this.f15729g = false;
            this.f15730h = null;
            return this;
        }

        public TaContent clearVersion() {
            this.f15700D = false;
            this.f15701E = 0;
            return this;
        }

        public BaseMapList getBaseMapList() {
            return this.f15705I;
        }

        public int getCachedSize() {
            if (this.ao < 0) {
                getSerializedSize();
            }
            return this.ao;
        }

        public CalendarUploadInfo getCalendarUploadInfo() {
            return this.f15709M;
        }

        public ControlData getControlData() {
            return this.f15722Z;
        }

        public DriverPageInfo getDriverPageInfo(int i) {
            return (DriverPageInfo) this.f15710N.get(i);
        }

        public int getDriverPageInfoCount() {
            return this.f15710N.size();
        }

        public List<DriverPageInfo> getDriverPageInfoList() {
            return this.f15710N;
        }

        public UpdateInfo getEditInfo() {
            return this.f15726d;
        }

        public FlightCheckData getFlightData() {
            return this.f15738p;
        }

        public FlightNoDetailData getFlightDetail(int i) {
            return (FlightNoDetailData) this.f15741s.get(i);
        }

        public int getFlightDetailCount() {
            return this.f15741s.size();
        }

        public List<FlightNoDetailData> getFlightDetailList() {
            return this.f15741s;
        }

        public FlightConfigData getFlightList(int i) {
            return (FlightConfigData) this.f15736n.get(i);
        }

        public int getFlightListCount() {
            return this.f15736n.size();
        }

        public List<FlightConfigData> getFlightListList() {
            return this.f15736n;
        }

        public FlightSugData getFlightSugData() {
            return this.f15740r;
        }

        public String getJumpUrl() {
            return this.f15716T;
        }

        public ML getMainList() {
            return this.f15724b;
        }

        public MapShowButton getMapShow() {
            return this.f15748z;
        }

        public NearMainList getNearList() {
            return this.f15746x;
        }

        public OrderSet getOrderSets(int i) {
            return (OrderSet) this.f15735m.get(i);
        }

        public int getOrderSetsCount() {
            return this.f15735m.size();
        }

        public List<OrderSet> getOrderSetsList() {
            return this.f15735m;
        }

        public PageContent getPageContent() {
            return this.f15718V;
        }

        public TaPOI getPoi(int i) {
            return (TaPOI) this.f15727e.get(i);
        }

        public int getPoiCount() {
            return this.f15727e.size();
        }

        public List<TaPOI> getPoiList() {
            return this.f15727e;
        }

        public AddPagePointSug getPointSug(int i) {
            return (AddPagePointSug) this.aa.get(i);
        }

        public int getPointSugCount() {
            return this.aa.size();
        }

        public List<AddPagePointSug> getPointSugList() {
            return this.aa;
        }

        public RecPOI getRecPoi(int i) {
            return (RecPOI) this.f15728f.get(i);
        }

        public int getRecPoiCount() {
            return this.f15728f.size();
        }

        public List<RecPOI> getRecPoiList() {
            return this.f15728f;
        }

        public String getRemindContent() {
            return this.f15712P;
        }

        public String getRemindSubContent() {
            return this.f15714R;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMainList()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMainList());
            }
            if (hasEditInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getEditInfo());
            }
            int i2 = i;
            for (TaPOI computeMessageSize : getPoiList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            for (RecPOI computeMessageSize2 : getRecPoiList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(4, computeMessageSize2);
            }
            if (hasUpdateRemindInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(5, getUpdateRemindInfo());
            }
            if (hasUpdateRcInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(6, getUpdateRcInfo());
            }
            if (hasTripUpdateInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(7, getTripUpdateInfo());
            }
            for (OrderSet computeMessageSize3 : getOrderSetsList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(8, computeMessageSize3);
            }
            for (FlightConfigData computeMessageSize4 : getFlightListList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(9, computeMessageSize4);
            }
            if (hasFlightData()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(10, getFlightData());
            }
            if (hasFlightSugData()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(11, getFlightSugData());
            }
            for (FlightNoDetailData computeMessageSize5 : getFlightDetailList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(12, computeMessageSize5);
            }
            if (hasTrainCityInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(13, getTrainCityInfo());
            }
            for (TrainList computeMessageSize6 : getTrainListList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(14, computeMessageSize6);
            }
            if (hasNearList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(15, getNearList());
            }
            if (hasMapShow()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(16, getMapShow());
            }
            for (TrainStopData computeMessageSize7 : getTrainStopInfoList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(17, computeMessageSize7);
            }
            if (hasShareTripInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(18, getShareTripInfo());
            }
            if (hasVersion()) {
                i2 += CodedOutputStreamMicro.computeInt64Size(19, getVersion());
            }
            if (hasShareLinkInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(20, getShareLinkInfo());
            }
            if (hasBaseMapList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(21, getBaseMapList());
            }
            if (hasSmsConfigData()) {
                i2 += CodedOutputStreamMicro.computeStringSize(22, getSmsConfigData());
            }
            if (hasCalendarUploadInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(23, getCalendarUploadInfo());
            }
            for (DriverPageInfo computeMessageSize8 : getDriverPageInfoList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(24, computeMessageSize8);
            }
            if (hasRemindContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(25, getRemindContent());
            }
            if (hasRemindSubContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(26, getRemindSubContent());
            }
            if (hasJumpUrl()) {
                i2 += CodedOutputStreamMicro.computeStringSize(27, getJumpUrl());
            }
            if (hasPageContent()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(28, getPageContent());
            }
            if (hasUiData()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(29, getUiData());
            }
            if (hasControlData()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(30, getControlData());
            }
            for (AddPagePointSug computeMessageSize9 : getPointSugList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(31, computeMessageSize9);
            }
            for (AddPageTravelModSug computeMessageSize10 : getTravelModSugList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(32, computeMessageSize10);
            }
            for (AddPageTripTitleSug computeMessageSize11 : getTripTitleSugList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(33, computeMessageSize11);
            }
            if (hasTrainDetailContent()) {
                i2 += CodedOutputStreamMicro.computeStringSize(34, getTrainDetailContent());
            }
            for (TrainDetailInfo computeMessageSize12 : getTrainDetailInfoList()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(35, computeMessageSize12);
            }
            if (hasTrainNo()) {
                i2 += CodedOutputStreamMicro.computeStringSize(36, getTrainNo());
            }
            if (hasSmsUploadInfo()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(37, getSmsUploadInfo());
            }
            if (hasTrip()) {
                i2 += CodedOutputStreamMicro.computeMessageSize(38, getTrip());
            }
            if (hasSugTripType()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(39, getSugTripType());
            }
            this.ao = i2;
            return i2;
        }

        public ShareLinkInfo getShareLinkInfo() {
            return this.f15703G;
        }

        public ShareTripInfo getShareTripInfo() {
            return this.f15699C;
        }

        public String getSmsConfigData() {
            return this.f15707K;
        }

        public SmsUploadInfo getSmsUploadInfo() {
            return this.aj;
        }

        public int getSugTripType() {
            return this.an;
        }

        public TrainCityInfo getTrainCityInfo() {
            return this.f15743u;
        }

        public String getTrainDetailContent() {
            return this.ae;
        }

        public TrainDetailInfo getTrainDetailInfo(int i) {
            return (TrainDetailInfo) this.af.get(i);
        }

        public int getTrainDetailInfoCount() {
            return this.af.size();
        }

        public List<TrainDetailInfo> getTrainDetailInfoList() {
            return this.af;
        }

        public TrainList getTrainList(int i) {
            return (TrainList) this.f15744v.get(i);
        }

        public int getTrainListCount() {
            return this.f15744v.size();
        }

        public List<TrainList> getTrainListList() {
            return this.f15744v;
        }

        public String getTrainNo() {
            return this.ah;
        }

        public TrainStopData getTrainStopInfo(int i) {
            return (TrainStopData) this.f15697A.get(i);
        }

        public int getTrainStopInfoCount() {
            return this.f15697A.size();
        }

        public List<TrainStopData> getTrainStopInfoList() {
            return this.f15697A;
        }

        public AddPageTravelModSug getTravelModSug(int i) {
            return (AddPageTravelModSug) this.ab.get(i);
        }

        public int getTravelModSugCount() {
            return this.ab.size();
        }

        public List<AddPageTravelModSug> getTravelModSugList() {
            return this.ab;
        }

        public MLTrip getTrip() {
            return this.al;
        }

        public AddPageTripTitleSug getTripTitleSug(int i) {
            return (AddPageTripTitleSug) this.ac.get(i);
        }

        public int getTripTitleSugCount() {
            return this.ac.size();
        }

        public List<AddPageTripTitleSug> getTripTitleSugList() {
            return this.ac;
        }

        public IsTripUpdate getTripUpdateInfo() {
            return this.f15734l;
        }

        public UiData getUiData() {
            return this.f15720X;
        }

        public UpdateRCInfo getUpdateRcInfo() {
            return this.f15732j;
        }

        public UpdateRemindInfo getUpdateRemindInfo() {
            return this.f15730h;
        }

        public long getVersion() {
            return this.f15701E;
        }

        public boolean hasBaseMapList() {
            return this.f15704H;
        }

        public boolean hasCalendarUploadInfo() {
            return this.f15708L;
        }

        public boolean hasControlData() {
            return this.f15721Y;
        }

        public boolean hasEditInfo() {
            return this.f15725c;
        }

        public boolean hasFlightData() {
            return this.f15737o;
        }

        public boolean hasFlightSugData() {
            return this.f15739q;
        }

        public boolean hasJumpUrl() {
            return this.f15715S;
        }

        public boolean hasMainList() {
            return this.f15723a;
        }

        public boolean hasMapShow() {
            return this.f15747y;
        }

        public boolean hasNearList() {
            return this.f15745w;
        }

        public boolean hasPageContent() {
            return this.f15717U;
        }

        public boolean hasRemindContent() {
            return this.f15711O;
        }

        public boolean hasRemindSubContent() {
            return this.f15713Q;
        }

        public boolean hasShareLinkInfo() {
            return this.f15702F;
        }

        public boolean hasShareTripInfo() {
            return this.f15698B;
        }

        public boolean hasSmsConfigData() {
            return this.f15706J;
        }

        public boolean hasSmsUploadInfo() {
            return this.ai;
        }

        public boolean hasSugTripType() {
            return this.am;
        }

        public boolean hasTrainCityInfo() {
            return this.f15742t;
        }

        public boolean hasTrainDetailContent() {
            return this.ad;
        }

        public boolean hasTrainNo() {
            return this.ag;
        }

        public boolean hasTrip() {
            return this.ak;
        }

        public boolean hasTripUpdateInfo() {
            return this.f15733k;
        }

        public boolean hasUiData() {
            return this.f15719W;
        }

        public boolean hasUpdateRcInfo() {
            return this.f15731i;
        }

        public boolean hasUpdateRemindInfo() {
            return this.f15729g;
        }

        public boolean hasVersion() {
            return this.f15700D;
        }

        public final boolean isInitialized() {
            if (hasMainList() && !getMainList().isInitialized()) {
                return false;
            }
            if (hasEditInfo() && !getEditInfo().isInitialized()) {
                return false;
            }
            for (TaPOI isInitialized : getPoiList()) {
                if (!isInitialized.isInitialized()) {
                    return false;
                }
            }
            for (RecPOI isInitialized2 : getRecPoiList()) {
                if (!isInitialized2.isInitialized()) {
                    return false;
                }
            }
            return (!hasUpdateRemindInfo() || getUpdateRemindInfo().isInitialized()) ? (!hasUpdateRcInfo() || getUpdateRcInfo().isInitialized()) ? (!hasTripUpdateInfo() || getTripUpdateInfo().isInitialized()) ? (!hasBaseMapList() || getBaseMapList().isInitialized()) ? !hasTrip() || getTrip().isInitialized() : false : false : false : false;
        }

        public TaContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro ml;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        ml = new ML();
                        codedInputStreamMicro.readMessage(ml);
                        setMainList(ml);
                        continue;
                    case 18:
                        ml = new UpdateInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setEditInfo(ml);
                        continue;
                    case 26:
                        ml = new TaPOI();
                        codedInputStreamMicro.readMessage(ml);
                        addPoi(ml);
                        continue;
                    case 34:
                        ml = new RecPOI();
                        codedInputStreamMicro.readMessage(ml);
                        addRecPoi(ml);
                        continue;
                    case 42:
                        ml = new UpdateRemindInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setUpdateRemindInfo(ml);
                        continue;
                    case 50:
                        ml = new UpdateRCInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setUpdateRcInfo(ml);
                        continue;
                    case 58:
                        ml = new IsTripUpdate();
                        codedInputStreamMicro.readMessage(ml);
                        setTripUpdateInfo(ml);
                        continue;
                    case 66:
                        ml = new OrderSet();
                        codedInputStreamMicro.readMessage(ml);
                        addOrderSets(ml);
                        continue;
                    case 74:
                        ml = new FlightConfigData();
                        codedInputStreamMicro.readMessage(ml);
                        addFlightList(ml);
                        continue;
                    case 82:
                        ml = new FlightCheckData();
                        codedInputStreamMicro.readMessage(ml);
                        setFlightData(ml);
                        continue;
                    case 90:
                        ml = new FlightSugData();
                        codedInputStreamMicro.readMessage(ml);
                        setFlightSugData(ml);
                        continue;
                    case 98:
                        ml = new FlightNoDetailData();
                        codedInputStreamMicro.readMessage(ml);
                        addFlightDetail(ml);
                        continue;
                    case 106:
                        ml = new TrainCityInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setTrainCityInfo(ml);
                        continue;
                    case 114:
                        ml = new TrainList();
                        codedInputStreamMicro.readMessage(ml);
                        addTrainList(ml);
                        continue;
                    case C1253f.df /*122*/:
                        ml = new NearMainList();
                        codedInputStreamMicro.readMessage(ml);
                        setNearList(ml);
                        continue;
                    case 130:
                        ml = new MapShowButton();
                        codedInputStreamMicro.readMessage(ml);
                        setMapShow(ml);
                        continue;
                    case 138:
                        ml = new TrainStopData();
                        codedInputStreamMicro.readMessage(ml);
                        addTrainStopInfo(ml);
                        continue;
                    case 146:
                        ml = new ShareTripInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setShareTripInfo(ml);
                        continue;
                    case 152:
                        setVersion(codedInputStreamMicro.readInt64());
                        continue;
                    case 162:
                        ml = new ShareLinkInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setShareLinkInfo(ml);
                        continue;
                    case 170:
                        ml = new BaseMapList();
                        codedInputStreamMicro.readMessage(ml);
                        setBaseMapList(ml);
                        continue;
                    case 178:
                        setSmsConfigData(codedInputStreamMicro.readString());
                        continue;
                    case 186:
                        ml = new CalendarUploadInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setCalendarUploadInfo(ml);
                        continue;
                    case RouteLineResConst.LINE_INTERNAL_NORMAL /*194*/:
                        ml = new DriverPageInfo();
                        codedInputStreamMicro.readMessage(ml);
                        addDriverPageInfo(ml);
                        continue;
                    case 202:
                        setRemindContent(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.ds /*210*/:
                        setRemindSubContent(codedInputStreamMicro.readString());
                        continue;
                    case 218:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case C1253f.dG /*226*/:
                        ml = new PageContent();
                        codedInputStreamMicro.readMessage(ml);
                        setPageContent(ml);
                        continue;
                    case NaviCmdConstants.ACTION_TYPE_NAVI_TTS_MODE_EXPERT /*234*/:
                        ml = new UiData();
                        codedInputStreamMicro.readMessage(ml);
                        setUiData(ml);
                        continue;
                    case C1253f.dM /*242*/:
                        ml = new ControlData();
                        codedInputStreamMicro.readMessage(ml);
                        setControlData(ml);
                        continue;
                    case 250:
                        ml = new AddPagePointSug();
                        codedInputStreamMicro.readMessage(ml);
                        addPointSug(ml);
                        continue;
                    case 258:
                        ml = new AddPageTravelModSug();
                        codedInputStreamMicro.readMessage(ml);
                        addTravelModSug(ml);
                        continue;
                    case BNOfflineDataObserver.EVENT_UPDATE_PROGRESS /*266*/:
                        ml = new AddPageTripTitleSug();
                        codedInputStreamMicro.readMessage(ml);
                        addTripTitleSug(ml);
                        continue;
                    case 274:
                        setTrainDetailContent(codedInputStreamMicro.readString());
                        continue;
                    case 282:
                        ml = new TrainDetailInfo();
                        codedInputStreamMicro.readMessage(ml);
                        addTrainDetailInfo(ml);
                        continue;
                    case 290:
                        setTrainNo(codedInputStreamMicro.readString());
                        continue;
                    case 298:
                        ml = new SmsUploadInfo();
                        codedInputStreamMicro.readMessage(ml);
                        setSmsUploadInfo(ml);
                        continue;
                    case 306:
                        ml = new MLTrip();
                        codedInputStreamMicro.readMessage(ml);
                        setTrip(ml);
                        continue;
                    case 312:
                        setSugTripType(codedInputStreamMicro.readInt32());
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

        public TaContent setBaseMapList(BaseMapList baseMapList) {
            if (baseMapList == null) {
                return clearBaseMapList();
            }
            this.f15704H = true;
            this.f15705I = baseMapList;
            return this;
        }

        public TaContent setCalendarUploadInfo(CalendarUploadInfo calendarUploadInfo) {
            if (calendarUploadInfo == null) {
                return clearCalendarUploadInfo();
            }
            this.f15708L = true;
            this.f15709M = calendarUploadInfo;
            return this;
        }

        public TaContent setControlData(ControlData controlData) {
            if (controlData == null) {
                return clearControlData();
            }
            this.f15721Y = true;
            this.f15722Z = controlData;
            return this;
        }

        public TaContent setDriverPageInfo(int i, DriverPageInfo driverPageInfo) {
            if (driverPageInfo != null) {
                this.f15710N.set(i, driverPageInfo);
            }
            return this;
        }

        public TaContent setEditInfo(UpdateInfo updateInfo) {
            if (updateInfo == null) {
                return clearEditInfo();
            }
            this.f15725c = true;
            this.f15726d = updateInfo;
            return this;
        }

        public TaContent setFlightData(FlightCheckData flightCheckData) {
            if (flightCheckData == null) {
                return clearFlightData();
            }
            this.f15737o = true;
            this.f15738p = flightCheckData;
            return this;
        }

        public TaContent setFlightDetail(int i, FlightNoDetailData flightNoDetailData) {
            if (flightNoDetailData != null) {
                this.f15741s.set(i, flightNoDetailData);
            }
            return this;
        }

        public TaContent setFlightList(int i, FlightConfigData flightConfigData) {
            if (flightConfigData != null) {
                this.f15736n.set(i, flightConfigData);
            }
            return this;
        }

        public TaContent setFlightSugData(FlightSugData flightSugData) {
            if (flightSugData == null) {
                return clearFlightSugData();
            }
            this.f15739q = true;
            this.f15740r = flightSugData;
            return this;
        }

        public TaContent setJumpUrl(String str) {
            this.f15715S = true;
            this.f15716T = str;
            return this;
        }

        public TaContent setMainList(ML ml) {
            if (ml == null) {
                return clearMainList();
            }
            this.f15723a = true;
            this.f15724b = ml;
            return this;
        }

        public TaContent setMapShow(MapShowButton mapShowButton) {
            if (mapShowButton == null) {
                return clearMapShow();
            }
            this.f15747y = true;
            this.f15748z = mapShowButton;
            return this;
        }

        public TaContent setNearList(NearMainList nearMainList) {
            if (nearMainList == null) {
                return clearNearList();
            }
            this.f15745w = true;
            this.f15746x = nearMainList;
            return this;
        }

        public TaContent setOrderSets(int i, OrderSet orderSet) {
            if (orderSet != null) {
                this.f15735m.set(i, orderSet);
            }
            return this;
        }

        public TaContent setPageContent(PageContent pageContent) {
            if (pageContent == null) {
                return clearPageContent();
            }
            this.f15717U = true;
            this.f15718V = pageContent;
            return this;
        }

        public TaContent setPoi(int i, TaPOI taPOI) {
            if (taPOI != null) {
                this.f15727e.set(i, taPOI);
            }
            return this;
        }

        public TaContent setPointSug(int i, AddPagePointSug addPagePointSug) {
            if (addPagePointSug != null) {
                this.aa.set(i, addPagePointSug);
            }
            return this;
        }

        public TaContent setRecPoi(int i, RecPOI recPOI) {
            if (recPOI != null) {
                this.f15728f.set(i, recPOI);
            }
            return this;
        }

        public TaContent setRemindContent(String str) {
            this.f15711O = true;
            this.f15712P = str;
            return this;
        }

        public TaContent setRemindSubContent(String str) {
            this.f15713Q = true;
            this.f15714R = str;
            return this;
        }

        public TaContent setShareLinkInfo(ShareLinkInfo shareLinkInfo) {
            if (shareLinkInfo == null) {
                return clearShareLinkInfo();
            }
            this.f15702F = true;
            this.f15703G = shareLinkInfo;
            return this;
        }

        public TaContent setShareTripInfo(ShareTripInfo shareTripInfo) {
            if (shareTripInfo == null) {
                return clearShareTripInfo();
            }
            this.f15698B = true;
            this.f15699C = shareTripInfo;
            return this;
        }

        public TaContent setSmsConfigData(String str) {
            this.f15706J = true;
            this.f15707K = str;
            return this;
        }

        public TaContent setSmsUploadInfo(SmsUploadInfo smsUploadInfo) {
            if (smsUploadInfo == null) {
                return clearSmsUploadInfo();
            }
            this.ai = true;
            this.aj = smsUploadInfo;
            return this;
        }

        public TaContent setSugTripType(int i) {
            this.am = true;
            this.an = i;
            return this;
        }

        public TaContent setTrainCityInfo(TrainCityInfo trainCityInfo) {
            if (trainCityInfo == null) {
                return clearTrainCityInfo();
            }
            this.f15742t = true;
            this.f15743u = trainCityInfo;
            return this;
        }

        public TaContent setTrainDetailContent(String str) {
            this.ad = true;
            this.ae = str;
            return this;
        }

        public TaContent setTrainDetailInfo(int i, TrainDetailInfo trainDetailInfo) {
            if (trainDetailInfo != null) {
                this.af.set(i, trainDetailInfo);
            }
            return this;
        }

        public TaContent setTrainList(int i, TrainList trainList) {
            if (trainList != null) {
                this.f15744v.set(i, trainList);
            }
            return this;
        }

        public TaContent setTrainNo(String str) {
            this.ag = true;
            this.ah = str;
            return this;
        }

        public TaContent setTrainStopInfo(int i, TrainStopData trainStopData) {
            if (trainStopData != null) {
                this.f15697A.set(i, trainStopData);
            }
            return this;
        }

        public TaContent setTravelModSug(int i, AddPageTravelModSug addPageTravelModSug) {
            if (addPageTravelModSug != null) {
                this.ab.set(i, addPageTravelModSug);
            }
            return this;
        }

        public TaContent setTrip(MLTrip mLTrip) {
            if (mLTrip == null) {
                return clearTrip();
            }
            this.ak = true;
            this.al = mLTrip;
            return this;
        }

        public TaContent setTripTitleSug(int i, AddPageTripTitleSug addPageTripTitleSug) {
            if (addPageTripTitleSug != null) {
                this.ac.set(i, addPageTripTitleSug);
            }
            return this;
        }

        public TaContent setTripUpdateInfo(IsTripUpdate isTripUpdate) {
            if (isTripUpdate == null) {
                return clearTripUpdateInfo();
            }
            this.f15733k = true;
            this.f15734l = isTripUpdate;
            return this;
        }

        public TaContent setUiData(UiData uiData) {
            if (uiData == null) {
                return clearUiData();
            }
            this.f15719W = true;
            this.f15720X = uiData;
            return this;
        }

        public TaContent setUpdateRcInfo(UpdateRCInfo updateRCInfo) {
            if (updateRCInfo == null) {
                return clearUpdateRcInfo();
            }
            this.f15731i = true;
            this.f15732j = updateRCInfo;
            return this;
        }

        public TaContent setUpdateRemindInfo(UpdateRemindInfo updateRemindInfo) {
            if (updateRemindInfo == null) {
                return clearUpdateRemindInfo();
            }
            this.f15729g = true;
            this.f15730h = updateRemindInfo;
            return this;
        }

        public TaContent setVersion(long j) {
            this.f15700D = true;
            this.f15701E = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMainList()) {
                codedOutputStreamMicro.writeMessage(1, getMainList());
            }
            if (hasEditInfo()) {
                codedOutputStreamMicro.writeMessage(2, getEditInfo());
            }
            for (TaPOI writeMessage : getPoiList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
            for (RecPOI writeMessage2 : getRecPoiList()) {
                codedOutputStreamMicro.writeMessage(4, writeMessage2);
            }
            if (hasUpdateRemindInfo()) {
                codedOutputStreamMicro.writeMessage(5, getUpdateRemindInfo());
            }
            if (hasUpdateRcInfo()) {
                codedOutputStreamMicro.writeMessage(6, getUpdateRcInfo());
            }
            if (hasTripUpdateInfo()) {
                codedOutputStreamMicro.writeMessage(7, getTripUpdateInfo());
            }
            for (OrderSet writeMessage3 : getOrderSetsList()) {
                codedOutputStreamMicro.writeMessage(8, writeMessage3);
            }
            for (FlightConfigData writeMessage4 : getFlightListList()) {
                codedOutputStreamMicro.writeMessage(9, writeMessage4);
            }
            if (hasFlightData()) {
                codedOutputStreamMicro.writeMessage(10, getFlightData());
            }
            if (hasFlightSugData()) {
                codedOutputStreamMicro.writeMessage(11, getFlightSugData());
            }
            for (FlightNoDetailData writeMessage5 : getFlightDetailList()) {
                codedOutputStreamMicro.writeMessage(12, writeMessage5);
            }
            if (hasTrainCityInfo()) {
                codedOutputStreamMicro.writeMessage(13, getTrainCityInfo());
            }
            for (TrainList writeMessage6 : getTrainListList()) {
                codedOutputStreamMicro.writeMessage(14, writeMessage6);
            }
            if (hasNearList()) {
                codedOutputStreamMicro.writeMessage(15, getNearList());
            }
            if (hasMapShow()) {
                codedOutputStreamMicro.writeMessage(16, getMapShow());
            }
            for (TrainStopData writeMessage7 : getTrainStopInfoList()) {
                codedOutputStreamMicro.writeMessage(17, writeMessage7);
            }
            if (hasShareTripInfo()) {
                codedOutputStreamMicro.writeMessage(18, getShareTripInfo());
            }
            if (hasVersion()) {
                codedOutputStreamMicro.writeInt64(19, getVersion());
            }
            if (hasShareLinkInfo()) {
                codedOutputStreamMicro.writeMessage(20, getShareLinkInfo());
            }
            if (hasBaseMapList()) {
                codedOutputStreamMicro.writeMessage(21, getBaseMapList());
            }
            if (hasSmsConfigData()) {
                codedOutputStreamMicro.writeString(22, getSmsConfigData());
            }
            if (hasCalendarUploadInfo()) {
                codedOutputStreamMicro.writeMessage(23, getCalendarUploadInfo());
            }
            for (DriverPageInfo writeMessage8 : getDriverPageInfoList()) {
                codedOutputStreamMicro.writeMessage(24, writeMessage8);
            }
            if (hasRemindContent()) {
                codedOutputStreamMicro.writeString(25, getRemindContent());
            }
            if (hasRemindSubContent()) {
                codedOutputStreamMicro.writeString(26, getRemindSubContent());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(27, getJumpUrl());
            }
            if (hasPageContent()) {
                codedOutputStreamMicro.writeMessage(28, getPageContent());
            }
            if (hasUiData()) {
                codedOutputStreamMicro.writeMessage(29, getUiData());
            }
            if (hasControlData()) {
                codedOutputStreamMicro.writeMessage(30, getControlData());
            }
            for (AddPagePointSug writeMessage9 : getPointSugList()) {
                codedOutputStreamMicro.writeMessage(31, writeMessage9);
            }
            for (AddPageTravelModSug writeMessage10 : getTravelModSugList()) {
                codedOutputStreamMicro.writeMessage(32, writeMessage10);
            }
            for (AddPageTripTitleSug writeMessage11 : getTripTitleSugList()) {
                codedOutputStreamMicro.writeMessage(33, writeMessage11);
            }
            if (hasTrainDetailContent()) {
                codedOutputStreamMicro.writeString(34, getTrainDetailContent());
            }
            for (TrainDetailInfo writeMessage12 : getTrainDetailInfoList()) {
                codedOutputStreamMicro.writeMessage(35, writeMessage12);
            }
            if (hasTrainNo()) {
                codedOutputStreamMicro.writeString(36, getTrainNo());
            }
            if (hasSmsUploadInfo()) {
                codedOutputStreamMicro.writeMessage(37, getSmsUploadInfo());
            }
            if (hasTrip()) {
                codedOutputStreamMicro.writeMessage(38, getTrip());
            }
            if (hasSugTripType()) {
                codedOutputStreamMicro.writeInt32(39, getSugTripType());
            }
        }
    }

    public static final class TaPOI extends MessageMicro {
        public static final int DETAIL_URL_FIELD_NUMBER = 10;
        public static final int END_CONTENT_FIELD_NUMBER = 8;
        public static final int END_TIME_FIELD_NUMBER = 6;
        public static final int EXT_INFO_FIELD_NUMBER = 13;
        public static final int EXT_TITLE_FIELD_NUMBER = 12;
        public static final int INFO_FIELD_NUMBER = 2;
        public static final int JUMP_URL_FIELD_NUMBER = 9;
        public static final int REMARK_FIELD_NUMBER = 11;
        public static final int START_CONTENT_FIELD_NUMBER = 7;
        public static final int START_TIME_FIELD_NUMBER = 5;
        public static final int SUG_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 4;
        public static final int TRIP_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15749a;
        /* renamed from: b */
        private String f15750b = "";
        /* renamed from: c */
        private boolean f15751c;
        /* renamed from: d */
        private String f15752d = "";
        /* renamed from: e */
        private boolean f15753e;
        /* renamed from: f */
        private String f15754f = "";
        /* renamed from: g */
        private boolean f15755g;
        /* renamed from: h */
        private String f15756h = "";
        /* renamed from: i */
        private boolean f15757i;
        /* renamed from: j */
        private String f15758j = "";
        /* renamed from: k */
        private boolean f15759k;
        /* renamed from: l */
        private String f15760l = "";
        /* renamed from: m */
        private boolean f15761m;
        /* renamed from: n */
        private String f15762n = "";
        /* renamed from: o */
        private boolean f15763o;
        /* renamed from: p */
        private String f15764p = "";
        /* renamed from: q */
        private boolean f15765q;
        /* renamed from: r */
        private String f15766r = "";
        /* renamed from: s */
        private boolean f15767s;
        /* renamed from: t */
        private String f15768t = "";
        /* renamed from: u */
        private boolean f15769u;
        /* renamed from: v */
        private String f15770v = "";
        /* renamed from: w */
        private boolean f15771w;
        /* renamed from: x */
        private String f15772x = "";
        /* renamed from: y */
        private List<TaPOITemp> f15773y = Collections.emptyList();
        /* renamed from: z */
        private int f15774z = -1;

        public static TaPOI parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TaPOI().mergeFrom(codedInputStreamMicro);
        }

        public static TaPOI parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TaPOI) new TaPOI().mergeFrom(bArr);
        }

        public TaPOI addExtInfo(TaPOITemp taPOITemp) {
            if (taPOITemp != null) {
                if (this.f15773y.isEmpty()) {
                    this.f15773y = new ArrayList();
                }
                this.f15773y.add(taPOITemp);
            }
            return this;
        }

        public final TaPOI clear() {
            clearTripId();
            clearInfo();
            clearSug();
            clearTitle();
            clearStartTime();
            clearEndTime();
            clearStartContent();
            clearEndContent();
            clearJumpUrl();
            clearDetailUrl();
            clearRemark();
            clearExtTitle();
            clearExtInfo();
            this.f15774z = -1;
            return this;
        }

        public TaPOI clearDetailUrl() {
            this.f15767s = false;
            this.f15768t = "";
            return this;
        }

        public TaPOI clearEndContent() {
            this.f15763o = false;
            this.f15764p = "";
            return this;
        }

        public TaPOI clearEndTime() {
            this.f15759k = false;
            this.f15760l = "";
            return this;
        }

        public TaPOI clearExtInfo() {
            this.f15773y = Collections.emptyList();
            return this;
        }

        public TaPOI clearExtTitle() {
            this.f15771w = false;
            this.f15772x = "";
            return this;
        }

        public TaPOI clearInfo() {
            this.f15751c = false;
            this.f15752d = "";
            return this;
        }

        public TaPOI clearJumpUrl() {
            this.f15765q = false;
            this.f15766r = "";
            return this;
        }

        public TaPOI clearRemark() {
            this.f15769u = false;
            this.f15770v = "";
            return this;
        }

        public TaPOI clearStartContent() {
            this.f15761m = false;
            this.f15762n = "";
            return this;
        }

        public TaPOI clearStartTime() {
            this.f15757i = false;
            this.f15758j = "";
            return this;
        }

        public TaPOI clearSug() {
            this.f15753e = false;
            this.f15754f = "";
            return this;
        }

        public TaPOI clearTitle() {
            this.f15755g = false;
            this.f15756h = "";
            return this;
        }

        public TaPOI clearTripId() {
            this.f15749a = false;
            this.f15750b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15774z < 0) {
                getSerializedSize();
            }
            return this.f15774z;
        }

        public String getDetailUrl() {
            return this.f15768t;
        }

        public String getEndContent() {
            return this.f15764p;
        }

        public String getEndTime() {
            return this.f15760l;
        }

        public TaPOITemp getExtInfo(int i) {
            return (TaPOITemp) this.f15773y.get(i);
        }

        public int getExtInfoCount() {
            return this.f15773y.size();
        }

        public List<TaPOITemp> getExtInfoList() {
            return this.f15773y;
        }

        public String getExtTitle() {
            return this.f15772x;
        }

        public String getInfo() {
            return this.f15752d;
        }

        public String getJumpUrl() {
            return this.f15766r;
        }

        public String getRemark() {
            return this.f15770v;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTripId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
            }
            if (hasInfo()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getInfo());
            }
            if (hasSug()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getSug());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getTitle());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getStartTime());
            }
            if (hasEndTime()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getEndTime());
            }
            if (hasStartContent()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getStartContent());
            }
            if (hasEndContent()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getEndContent());
            }
            if (hasJumpUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getJumpUrl());
            }
            if (hasDetailUrl()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getDetailUrl());
            }
            if (hasRemark()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getRemark());
            }
            if (hasExtTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getExtTitle());
            }
            int i2 = i;
            for (TaPOITemp computeMessageSize : getExtInfoList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(13, computeMessageSize) + i2;
            }
            this.f15774z = i2;
            return i2;
        }

        public String getStartContent() {
            return this.f15762n;
        }

        public String getStartTime() {
            return this.f15758j;
        }

        public String getSug() {
            return this.f15754f;
        }

        public String getTitle() {
            return this.f15756h;
        }

        public String getTripId() {
            return this.f15750b;
        }

        public boolean hasDetailUrl() {
            return this.f15767s;
        }

        public boolean hasEndContent() {
            return this.f15763o;
        }

        public boolean hasEndTime() {
            return this.f15759k;
        }

        public boolean hasExtTitle() {
            return this.f15771w;
        }

        public boolean hasInfo() {
            return this.f15751c;
        }

        public boolean hasJumpUrl() {
            return this.f15765q;
        }

        public boolean hasRemark() {
            return this.f15769u;
        }

        public boolean hasStartContent() {
            return this.f15761m;
        }

        public boolean hasStartTime() {
            return this.f15757i;
        }

        public boolean hasSug() {
            return this.f15753e;
        }

        public boolean hasTitle() {
            return this.f15755g;
        }

        public boolean hasTripId() {
            return this.f15749a;
        }

        public final boolean isInitialized() {
            return this.f15749a && this.f15751c && this.f15753e;
        }

        public TaPOI mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTripId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setInfo(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setSug(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setEndTime(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setStartContent(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setEndContent(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setJumpUrl(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setDetailUrl(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setRemark(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setExtTitle(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        MessageMicro taPOITemp = new TaPOITemp();
                        codedInputStreamMicro.readMessage(taPOITemp);
                        addExtInfo(taPOITemp);
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

        public TaPOI setDetailUrl(String str) {
            this.f15767s = true;
            this.f15768t = str;
            return this;
        }

        public TaPOI setEndContent(String str) {
            this.f15763o = true;
            this.f15764p = str;
            return this;
        }

        public TaPOI setEndTime(String str) {
            this.f15759k = true;
            this.f15760l = str;
            return this;
        }

        public TaPOI setExtInfo(int i, TaPOITemp taPOITemp) {
            if (taPOITemp != null) {
                this.f15773y.set(i, taPOITemp);
            }
            return this;
        }

        public TaPOI setExtTitle(String str) {
            this.f15771w = true;
            this.f15772x = str;
            return this;
        }

        public TaPOI setInfo(String str) {
            this.f15751c = true;
            this.f15752d = str;
            return this;
        }

        public TaPOI setJumpUrl(String str) {
            this.f15765q = true;
            this.f15766r = str;
            return this;
        }

        public TaPOI setRemark(String str) {
            this.f15769u = true;
            this.f15770v = str;
            return this;
        }

        public TaPOI setStartContent(String str) {
            this.f15761m = true;
            this.f15762n = str;
            return this;
        }

        public TaPOI setStartTime(String str) {
            this.f15757i = true;
            this.f15758j = str;
            return this;
        }

        public TaPOI setSug(String str) {
            this.f15753e = true;
            this.f15754f = str;
            return this;
        }

        public TaPOI setTitle(String str) {
            this.f15755g = true;
            this.f15756h = str;
            return this;
        }

        public TaPOI setTripId(String str) {
            this.f15749a = true;
            this.f15750b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTripId()) {
                codedOutputStreamMicro.writeString(1, getTripId());
            }
            if (hasInfo()) {
                codedOutputStreamMicro.writeString(2, getInfo());
            }
            if (hasSug()) {
                codedOutputStreamMicro.writeString(3, getSug());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(4, getTitle());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(5, getStartTime());
            }
            if (hasEndTime()) {
                codedOutputStreamMicro.writeString(6, getEndTime());
            }
            if (hasStartContent()) {
                codedOutputStreamMicro.writeString(7, getStartContent());
            }
            if (hasEndContent()) {
                codedOutputStreamMicro.writeString(8, getEndContent());
            }
            if (hasJumpUrl()) {
                codedOutputStreamMicro.writeString(9, getJumpUrl());
            }
            if (hasDetailUrl()) {
                codedOutputStreamMicro.writeString(10, getDetailUrl());
            }
            if (hasRemark()) {
                codedOutputStreamMicro.writeString(11, getRemark());
            }
            if (hasExtTitle()) {
                codedOutputStreamMicro.writeString(12, getExtTitle());
            }
            for (TaPOITemp writeMessage : getExtInfoList()) {
                codedOutputStreamMicro.writeMessage(13, writeMessage);
            }
        }
    }

    public static final class TaPOITemp extends MessageMicro {
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15775a;
        /* renamed from: b */
        private String f15776b = "";
        /* renamed from: c */
        private boolean f15777c;
        /* renamed from: d */
        private String f15778d = "";
        /* renamed from: e */
        private int f15779e = -1;

        public static TaPOITemp parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TaPOITemp().mergeFrom(codedInputStreamMicro);
        }

        public static TaPOITemp parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TaPOITemp) new TaPOITemp().mergeFrom(bArr);
        }

        public final TaPOITemp clear() {
            clearTitle();
            clearContent();
            this.f15779e = -1;
            return this;
        }

        public TaPOITemp clearContent() {
            this.f15777c = false;
            this.f15778d = "";
            return this;
        }

        public TaPOITemp clearTitle() {
            this.f15775a = false;
            this.f15776b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15779e < 0) {
                getSerializedSize();
            }
            return this.f15779e;
        }

        public String getContent() {
            return this.f15778d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
            }
            this.f15779e = i;
            return i;
        }

        public String getTitle() {
            return this.f15776b;
        }

        public boolean hasContent() {
            return this.f15777c;
        }

        public boolean hasTitle() {
            return this.f15775a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TaPOITemp mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setContent(codedInputStreamMicro.readString());
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

        public TaPOITemp setContent(String str) {
            this.f15777c = true;
            this.f15778d = str;
            return this;
        }

        public TaPOITemp setTitle(String str) {
            this.f15775a = true;
            this.f15776b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(2, getContent());
            }
        }
    }

    public static final class TaResult extends MessageMicro {
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int MSG_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15780a;
        /* renamed from: b */
        private int f15781b = 0;
        /* renamed from: c */
        private boolean f15782c;
        /* renamed from: d */
        private String f15783d = "";
        /* renamed from: e */
        private int f15784e = -1;

        public static TaResult parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TaResult().mergeFrom(codedInputStreamMicro);
        }

        public static TaResult parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TaResult) new TaResult().mergeFrom(bArr);
        }

        public final TaResult clear() {
            clearError();
            clearMsg();
            this.f15784e = -1;
            return this;
        }

        public TaResult clearError() {
            this.f15780a = false;
            this.f15781b = 0;
            return this;
        }

        public TaResult clearMsg() {
            this.f15782c = false;
            this.f15783d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15784e < 0) {
                getSerializedSize();
            }
            return this.f15784e;
        }

        public int getError() {
            return this.f15781b;
        }

        public String getMsg() {
            return this.f15783d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasError()) {
                i = 0 + CodedOutputStreamMicro.computeInt32Size(1, getError());
            }
            if (hasMsg()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getMsg());
            }
            this.f15784e = i;
            return i;
        }

        public boolean hasError() {
            return this.f15780a;
        }

        public boolean hasMsg() {
            return this.f15782c;
        }

        public final boolean isInitialized() {
            return this.f15780a && this.f15782c;
        }

        public TaResult mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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

        public TaResult setError(int i) {
            this.f15780a = true;
            this.f15781b = i;
            return this;
        }

        public TaResult setMsg(String str) {
            this.f15782c = true;
            this.f15783d = str;
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

    public static final class TrainCityInfo extends MessageMicro {
        public static final int TRAIN_INFO_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 2;
        /* renamed from: a */
        private List<TrainDetail> f15785a = Collections.emptyList();
        /* renamed from: b */
        private boolean f15786b;
        /* renamed from: c */
        private long f15787c = 0;
        /* renamed from: d */
        private int f15788d = -1;

        public static TrainCityInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TrainCityInfo().mergeFrom(codedInputStreamMicro);
        }

        public static TrainCityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TrainCityInfo) new TrainCityInfo().mergeFrom(bArr);
        }

        public TrainCityInfo addTrainInfo(TrainDetail trainDetail) {
            if (trainDetail != null) {
                if (this.f15785a.isEmpty()) {
                    this.f15785a = new ArrayList();
                }
                this.f15785a.add(trainDetail);
            }
            return this;
        }

        public final TrainCityInfo clear() {
            clearTrainInfo();
            clearVersion();
            this.f15788d = -1;
            return this;
        }

        public TrainCityInfo clearTrainInfo() {
            this.f15785a = Collections.emptyList();
            return this;
        }

        public TrainCityInfo clearVersion() {
            this.f15786b = false;
            this.f15787c = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15788d < 0) {
                getSerializedSize();
            }
            return this.f15788d;
        }

        public int getSerializedSize() {
            int i = 0;
            for (TrainDetail computeMessageSize : getTrainInfoList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            if (hasVersion()) {
                i += CodedOutputStreamMicro.computeInt64Size(2, getVersion());
            }
            this.f15788d = i;
            return i;
        }

        public TrainDetail getTrainInfo(int i) {
            return (TrainDetail) this.f15785a.get(i);
        }

        public int getTrainInfoCount() {
            return this.f15785a.size();
        }

        public List<TrainDetail> getTrainInfoList() {
            return this.f15785a;
        }

        public long getVersion() {
            return this.f15787c;
        }

        public boolean hasVersion() {
            return this.f15786b;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TrainCityInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro trainDetail = new TrainDetail();
                        codedInputStreamMicro.readMessage(trainDetail);
                        addTrainInfo(trainDetail);
                        continue;
                    case 16:
                        setVersion(codedInputStreamMicro.readInt64());
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

        public TrainCityInfo setTrainInfo(int i, TrainDetail trainDetail) {
            if (trainDetail != null) {
                this.f15785a.set(i, trainDetail);
            }
            return this;
        }

        public TrainCityInfo setVersion(long j) {
            this.f15786b = true;
            this.f15787c = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (TrainDetail writeMessage : getTrainInfoList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
            if (hasVersion()) {
                codedOutputStreamMicro.writeInt64(2, getVersion());
            }
        }
    }

    public static final class TrainDetail extends MessageMicro {
        public static final int CITY_INFO_FIELD_NUMBER = 2;
        public static final int SHORT_TITLE_FIELD_NUMBER = 3;
        public static final int SHOW_TYPE_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15789a;
        /* renamed from: b */
        private String f15790b = "";
        /* renamed from: c */
        private List<CityInfo> f15791c = Collections.emptyList();
        /* renamed from: d */
        private boolean f15792d;
        /* renamed from: e */
        private String f15793e = "";
        /* renamed from: f */
        private boolean f15794f;
        /* renamed from: g */
        private int f15795g = 0;
        /* renamed from: h */
        private int f15796h = -1;

        public static TrainDetail parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TrainDetail().mergeFrom(codedInputStreamMicro);
        }

        public static TrainDetail parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TrainDetail) new TrainDetail().mergeFrom(bArr);
        }

        public TrainDetail addCityInfo(CityInfo cityInfo) {
            if (cityInfo != null) {
                if (this.f15791c.isEmpty()) {
                    this.f15791c = new ArrayList();
                }
                this.f15791c.add(cityInfo);
            }
            return this;
        }

        public final TrainDetail clear() {
            clearTitle();
            clearCityInfo();
            clearShortTitle();
            clearShowType();
            this.f15796h = -1;
            return this;
        }

        public TrainDetail clearCityInfo() {
            this.f15791c = Collections.emptyList();
            return this;
        }

        public TrainDetail clearShortTitle() {
            this.f15792d = false;
            this.f15793e = "";
            return this;
        }

        public TrainDetail clearShowType() {
            this.f15794f = false;
            this.f15795g = 0;
            return this;
        }

        public TrainDetail clearTitle() {
            this.f15789a = false;
            this.f15790b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15796h < 0) {
                getSerializedSize();
            }
            return this.f15796h;
        }

        public CityInfo getCityInfo(int i) {
            return (CityInfo) this.f15791c.get(i);
        }

        public int getCityInfoCount() {
            return this.f15791c.size();
        }

        public List<CityInfo> getCityInfoList() {
            return this.f15791c;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            int i2 = i;
            for (CityInfo computeMessageSize : getCityInfoList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(2, computeMessageSize) + i2;
            }
            if (hasShortTitle()) {
                i2 += CodedOutputStreamMicro.computeStringSize(3, getShortTitle());
            }
            if (hasShowType()) {
                i2 += CodedOutputStreamMicro.computeInt32Size(4, getShowType());
            }
            this.f15796h = i2;
            return i2;
        }

        public String getShortTitle() {
            return this.f15793e;
        }

        public int getShowType() {
            return this.f15795g;
        }

        public String getTitle() {
            return this.f15790b;
        }

        public boolean hasShortTitle() {
            return this.f15792d;
        }

        public boolean hasShowType() {
            return this.f15794f;
        }

        public boolean hasTitle() {
            return this.f15789a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TrainDetail mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        MessageMicro cityInfo = new CityInfo();
                        codedInputStreamMicro.readMessage(cityInfo);
                        addCityInfo(cityInfo);
                        continue;
                    case 26:
                        setShortTitle(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setShowType(codedInputStreamMicro.readInt32());
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

        public TrainDetail setCityInfo(int i, CityInfo cityInfo) {
            if (cityInfo != null) {
                this.f15791c.set(i, cityInfo);
            }
            return this;
        }

        public TrainDetail setShortTitle(String str) {
            this.f15792d = true;
            this.f15793e = str;
            return this;
        }

        public TrainDetail setShowType(int i) {
            this.f15794f = true;
            this.f15795g = i;
            return this;
        }

        public TrainDetail setTitle(String str) {
            this.f15789a = true;
            this.f15790b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            for (CityInfo writeMessage : getCityInfoList()) {
                codedOutputStreamMicro.writeMessage(2, writeMessage);
            }
            if (hasShortTitle()) {
                codedOutputStreamMicro.writeString(3, getShortTitle());
            }
            if (hasShowType()) {
                codedOutputStreamMicro.writeInt32(4, getShowType());
            }
        }
    }

    public static final class TrainDetailInfo extends MessageMicro {
        public static final int CONTENT_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15797a;
        /* renamed from: b */
        private String f15798b = "";
        /* renamed from: c */
        private boolean f15799c;
        /* renamed from: d */
        private String f15800d = "";
        /* renamed from: e */
        private int f15801e = -1;

        public static TrainDetailInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TrainDetailInfo().mergeFrom(codedInputStreamMicro);
        }

        public static TrainDetailInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TrainDetailInfo) new TrainDetailInfo().mergeFrom(bArr);
        }

        public final TrainDetailInfo clear() {
            clearTitle();
            clearContent();
            this.f15801e = -1;
            return this;
        }

        public TrainDetailInfo clearContent() {
            this.f15799c = false;
            this.f15800d = "";
            return this;
        }

        public TrainDetailInfo clearTitle() {
            this.f15797a = false;
            this.f15798b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15801e < 0) {
                getSerializedSize();
            }
            return this.f15801e;
        }

        public String getContent() {
            return this.f15800d;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTitle()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTitle());
            }
            if (hasContent()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getContent());
            }
            this.f15801e = i;
            return i;
        }

        public String getTitle() {
            return this.f15798b;
        }

        public boolean hasContent() {
            return this.f15799c;
        }

        public boolean hasTitle() {
            return this.f15797a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TrainDetailInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTitle(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setContent(codedInputStreamMicro.readString());
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

        public TrainDetailInfo setContent(String str) {
            this.f15799c = true;
            this.f15800d = str;
            return this;
        }

        public TrainDetailInfo setTitle(String str) {
            this.f15797a = true;
            this.f15798b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(1, getTitle());
            }
            if (hasContent()) {
                codedOutputStreamMicro.writeString(2, getContent());
            }
        }
    }

    public static final class TrainList extends MessageMicro {
        public static final int DAY_FIELD_NUMBER = 6;
        public static final int FROM_CITY_ID_FIELD_NUMBER = 9;
        public static final int FROM_CITY_NAME_FIELD_NUMBER = 8;
        public static final int FROM_STATION_FIELD_NUMBER = 1;
        public static final int FROM_TIME_FIELD_NUMBER = 4;
        public static final int TO_CITY_ID_FIELD_NUMBER = 11;
        public static final int TO_CITY_NAME_FIELD_NUMBER = 10;
        public static final int TO_STATION_FIELD_NUMBER = 2;
        public static final int TO_TIME_FIELD_NUMBER = 5;
        public static final int TRAIN_NUMBER_FIELD_NUMBER = 3;
        public static final int USE_TIME_FIELD_NUMBER = 7;
        /* renamed from: a */
        private boolean f15802a;
        /* renamed from: b */
        private String f15803b = "";
        /* renamed from: c */
        private boolean f15804c;
        /* renamed from: d */
        private String f15805d = "";
        /* renamed from: e */
        private boolean f15806e;
        /* renamed from: f */
        private String f15807f = "";
        /* renamed from: g */
        private boolean f15808g;
        /* renamed from: h */
        private long f15809h = 0;
        /* renamed from: i */
        private boolean f15810i;
        /* renamed from: j */
        private long f15811j = 0;
        /* renamed from: k */
        private boolean f15812k;
        /* renamed from: l */
        private int f15813l = 0;
        /* renamed from: m */
        private boolean f15814m;
        /* renamed from: n */
        private int f15815n = 0;
        /* renamed from: o */
        private boolean f15816o;
        /* renamed from: p */
        private String f15817p = "";
        /* renamed from: q */
        private boolean f15818q;
        /* renamed from: r */
        private String f15819r = "";
        /* renamed from: s */
        private boolean f15820s;
        /* renamed from: t */
        private String f15821t = "";
        /* renamed from: u */
        private boolean f15822u;
        /* renamed from: v */
        private String f15823v = "";
        /* renamed from: w */
        private int f15824w = -1;

        public static TrainList parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TrainList().mergeFrom(codedInputStreamMicro);
        }

        public static TrainList parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TrainList) new TrainList().mergeFrom(bArr);
        }

        public final TrainList clear() {
            clearFromStation();
            clearToStation();
            clearTrainNumber();
            clearFromTime();
            clearToTime();
            clearDay();
            clearUseTime();
            clearFromCityName();
            clearFromCityId();
            clearToCityName();
            clearToCityId();
            this.f15824w = -1;
            return this;
        }

        public TrainList clearDay() {
            this.f15812k = false;
            this.f15813l = 0;
            return this;
        }

        public TrainList clearFromCityId() {
            this.f15818q = false;
            this.f15819r = "";
            return this;
        }

        public TrainList clearFromCityName() {
            this.f15816o = false;
            this.f15817p = "";
            return this;
        }

        public TrainList clearFromStation() {
            this.f15802a = false;
            this.f15803b = "";
            return this;
        }

        public TrainList clearFromTime() {
            this.f15808g = false;
            this.f15809h = 0;
            return this;
        }

        public TrainList clearToCityId() {
            this.f15822u = false;
            this.f15823v = "";
            return this;
        }

        public TrainList clearToCityName() {
            this.f15820s = false;
            this.f15821t = "";
            return this;
        }

        public TrainList clearToStation() {
            this.f15804c = false;
            this.f15805d = "";
            return this;
        }

        public TrainList clearToTime() {
            this.f15810i = false;
            this.f15811j = 0;
            return this;
        }

        public TrainList clearTrainNumber() {
            this.f15806e = false;
            this.f15807f = "";
            return this;
        }

        public TrainList clearUseTime() {
            this.f15814m = false;
            this.f15815n = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15824w < 0) {
                getSerializedSize();
            }
            return this.f15824w;
        }

        public int getDay() {
            return this.f15813l;
        }

        public String getFromCityId() {
            return this.f15819r;
        }

        public String getFromCityName() {
            return this.f15817p;
        }

        public String getFromStation() {
            return this.f15803b;
        }

        public long getFromTime() {
            return this.f15809h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasFromStation()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getFromStation());
            }
            if (hasToStation()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getToStation());
            }
            if (hasTrainNumber()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTrainNumber());
            }
            if (hasFromTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(4, getFromTime());
            }
            if (hasToTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(5, getToTime());
            }
            if (hasDay()) {
                i += CodedOutputStreamMicro.computeInt32Size(6, getDay());
            }
            if (hasUseTime()) {
                i += CodedOutputStreamMicro.computeInt32Size(7, getUseTime());
            }
            if (hasFromCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getFromCityName());
            }
            if (hasFromCityId()) {
                i += CodedOutputStreamMicro.computeStringSize(9, getFromCityId());
            }
            if (hasToCityName()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getToCityName());
            }
            if (hasToCityId()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getToCityId());
            }
            this.f15824w = i;
            return i;
        }

        public String getToCityId() {
            return this.f15823v;
        }

        public String getToCityName() {
            return this.f15821t;
        }

        public String getToStation() {
            return this.f15805d;
        }

        public long getToTime() {
            return this.f15811j;
        }

        public String getTrainNumber() {
            return this.f15807f;
        }

        public int getUseTime() {
            return this.f15815n;
        }

        public boolean hasDay() {
            return this.f15812k;
        }

        public boolean hasFromCityId() {
            return this.f15818q;
        }

        public boolean hasFromCityName() {
            return this.f15816o;
        }

        public boolean hasFromStation() {
            return this.f15802a;
        }

        public boolean hasFromTime() {
            return this.f15808g;
        }

        public boolean hasToCityId() {
            return this.f15822u;
        }

        public boolean hasToCityName() {
            return this.f15820s;
        }

        public boolean hasToStation() {
            return this.f15804c;
        }

        public boolean hasToTime() {
            return this.f15810i;
        }

        public boolean hasTrainNumber() {
            return this.f15806e;
        }

        public boolean hasUseTime() {
            return this.f15814m;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TrainList mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setFromStation(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setToStation(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTrainNumber(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setFromTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 40:
                        setToTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 48:
                        setDay(codedInputStreamMicro.readInt32());
                        continue;
                    case 56:
                        setUseTime(codedInputStreamMicro.readInt32());
                        continue;
                    case 66:
                        setFromCityName(codedInputStreamMicro.readString());
                        continue;
                    case 74:
                        setFromCityId(codedInputStreamMicro.readString());
                        continue;
                    case 82:
                        setToCityName(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setToCityId(codedInputStreamMicro.readString());
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

        public TrainList setDay(int i) {
            this.f15812k = true;
            this.f15813l = i;
            return this;
        }

        public TrainList setFromCityId(String str) {
            this.f15818q = true;
            this.f15819r = str;
            return this;
        }

        public TrainList setFromCityName(String str) {
            this.f15816o = true;
            this.f15817p = str;
            return this;
        }

        public TrainList setFromStation(String str) {
            this.f15802a = true;
            this.f15803b = str;
            return this;
        }

        public TrainList setFromTime(long j) {
            this.f15808g = true;
            this.f15809h = j;
            return this;
        }

        public TrainList setToCityId(String str) {
            this.f15822u = true;
            this.f15823v = str;
            return this;
        }

        public TrainList setToCityName(String str) {
            this.f15820s = true;
            this.f15821t = str;
            return this;
        }

        public TrainList setToStation(String str) {
            this.f15804c = true;
            this.f15805d = str;
            return this;
        }

        public TrainList setToTime(long j) {
            this.f15810i = true;
            this.f15811j = j;
            return this;
        }

        public TrainList setTrainNumber(String str) {
            this.f15806e = true;
            this.f15807f = str;
            return this;
        }

        public TrainList setUseTime(int i) {
            this.f15814m = true;
            this.f15815n = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasFromStation()) {
                codedOutputStreamMicro.writeString(1, getFromStation());
            }
            if (hasToStation()) {
                codedOutputStreamMicro.writeString(2, getToStation());
            }
            if (hasTrainNumber()) {
                codedOutputStreamMicro.writeString(3, getTrainNumber());
            }
            if (hasFromTime()) {
                codedOutputStreamMicro.writeInt64(4, getFromTime());
            }
            if (hasToTime()) {
                codedOutputStreamMicro.writeInt64(5, getToTime());
            }
            if (hasDay()) {
                codedOutputStreamMicro.writeInt32(6, getDay());
            }
            if (hasUseTime()) {
                codedOutputStreamMicro.writeInt32(7, getUseTime());
            }
            if (hasFromCityName()) {
                codedOutputStreamMicro.writeString(8, getFromCityName());
            }
            if (hasFromCityId()) {
                codedOutputStreamMicro.writeString(9, getFromCityId());
            }
            if (hasToCityName()) {
                codedOutputStreamMicro.writeString(10, getToCityName());
            }
            if (hasToCityId()) {
                codedOutputStreamMicro.writeString(11, getToCityId());
            }
        }
    }

    public static final class TrainStopData extends MessageMicro {
        public static final int ARRIVE_TIME_FIELD_NUMBER = 5;
        public static final int ARR_CONTENT_FIELD_NUMBER = 13;
        public static final int DEP_CONTENT_FIELD_NUMBER = 14;
        public static final int IS_ARR_LOC_FIELD_NUMBER = 12;
        public static final int IS_CUR_LOC_FIELD_NUMBER = 10;
        public static final int IS_DEP_LOC_FIELD_NUMBER = 11;
        public static final int IS_SHOW_FIELD_NUMBER = 9;
        public static final int KM_FIELD_NUMBER = 8;
        public static final int START_TIME_FIELD_NUMBER = 4;
        public static final int STATION_ID_FIELD_NUMBER = 1;
        public static final int STATION_NAME_FIELD_NUMBER = 3;
        public static final int STATION_NO_FIELD_NUMBER = 2;
        public static final int STOP_TIME_FIELD_NUMBER = 6;
        public static final int SUB_TRAIN_NUM_FIELD_NUMBER = 7;
        /* renamed from: A */
        private boolean f15825A;
        /* renamed from: B */
        private String f15826B = "";
        /* renamed from: C */
        private int f15827C = -1;
        /* renamed from: a */
        private boolean f15828a;
        /* renamed from: b */
        private String f15829b = "";
        /* renamed from: c */
        private boolean f15830c;
        /* renamed from: d */
        private String f15831d = "";
        /* renamed from: e */
        private boolean f15832e;
        /* renamed from: f */
        private String f15833f = "";
        /* renamed from: g */
        private boolean f15834g;
        /* renamed from: h */
        private String f15835h = "";
        /* renamed from: i */
        private boolean f15836i;
        /* renamed from: j */
        private String f15837j = "";
        /* renamed from: k */
        private boolean f15838k;
        /* renamed from: l */
        private String f15839l = "";
        /* renamed from: m */
        private boolean f15840m;
        /* renamed from: n */
        private String f15841n = "";
        /* renamed from: o */
        private boolean f15842o;
        /* renamed from: p */
        private String f15843p = "";
        /* renamed from: q */
        private boolean f15844q;
        /* renamed from: r */
        private int f15845r = 0;
        /* renamed from: s */
        private boolean f15846s;
        /* renamed from: t */
        private String f15847t = "";
        /* renamed from: u */
        private boolean f15848u;
        /* renamed from: v */
        private String f15849v = "";
        /* renamed from: w */
        private boolean f15850w;
        /* renamed from: x */
        private String f15851x = "";
        /* renamed from: y */
        private boolean f15852y;
        /* renamed from: z */
        private String f15853z = "";

        public static TrainStopData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TrainStopData().mergeFrom(codedInputStreamMicro);
        }

        public static TrainStopData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TrainStopData) new TrainStopData().mergeFrom(bArr);
        }

        public final TrainStopData clear() {
            clearStationId();
            clearStationNo();
            clearStationName();
            clearStartTime();
            clearArriveTime();
            clearStopTime();
            clearSubTrainNum();
            clearKm();
            clearIsShow();
            clearIsCurLoc();
            clearIsDepLoc();
            clearIsArrLoc();
            clearArrContent();
            clearDepContent();
            this.f15827C = -1;
            return this;
        }

        public TrainStopData clearArrContent() {
            this.f15852y = false;
            this.f15853z = "";
            return this;
        }

        public TrainStopData clearArriveTime() {
            this.f15836i = false;
            this.f15837j = "";
            return this;
        }

        public TrainStopData clearDepContent() {
            this.f15825A = false;
            this.f15826B = "";
            return this;
        }

        public TrainStopData clearIsArrLoc() {
            this.f15850w = false;
            this.f15851x = "";
            return this;
        }

        public TrainStopData clearIsCurLoc() {
            this.f15846s = false;
            this.f15847t = "";
            return this;
        }

        public TrainStopData clearIsDepLoc() {
            this.f15848u = false;
            this.f15849v = "";
            return this;
        }

        public TrainStopData clearIsShow() {
            this.f15844q = false;
            this.f15845r = 0;
            return this;
        }

        public TrainStopData clearKm() {
            this.f15842o = false;
            this.f15843p = "";
            return this;
        }

        public TrainStopData clearStartTime() {
            this.f15834g = false;
            this.f15835h = "";
            return this;
        }

        public TrainStopData clearStationId() {
            this.f15828a = false;
            this.f15829b = "";
            return this;
        }

        public TrainStopData clearStationName() {
            this.f15832e = false;
            this.f15833f = "";
            return this;
        }

        public TrainStopData clearStationNo() {
            this.f15830c = false;
            this.f15831d = "";
            return this;
        }

        public TrainStopData clearStopTime() {
            this.f15838k = false;
            this.f15839l = "";
            return this;
        }

        public TrainStopData clearSubTrainNum() {
            this.f15840m = false;
            this.f15841n = "";
            return this;
        }

        public String getArrContent() {
            return this.f15853z;
        }

        public String getArriveTime() {
            return this.f15837j;
        }

        public int getCachedSize() {
            if (this.f15827C < 0) {
                getSerializedSize();
            }
            return this.f15827C;
        }

        public String getDepContent() {
            return this.f15826B;
        }

        public String getIsArrLoc() {
            return this.f15851x;
        }

        public String getIsCurLoc() {
            return this.f15847t;
        }

        public String getIsDepLoc() {
            return this.f15849v;
        }

        public int getIsShow() {
            return this.f15845r;
        }

        public String getKm() {
            return this.f15843p;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasStationId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getStationId());
            }
            if (hasStationNo()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getStationNo());
            }
            if (hasStationName()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getStationName());
            }
            if (hasStartTime()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getStartTime());
            }
            if (hasArriveTime()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getArriveTime());
            }
            if (hasStopTime()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getStopTime());
            }
            if (hasSubTrainNum()) {
                i += CodedOutputStreamMicro.computeStringSize(7, getSubTrainNum());
            }
            if (hasKm()) {
                i += CodedOutputStreamMicro.computeStringSize(8, getKm());
            }
            if (hasIsShow()) {
                i += CodedOutputStreamMicro.computeInt32Size(9, getIsShow());
            }
            if (hasIsCurLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(10, getIsCurLoc());
            }
            if (hasIsDepLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(11, getIsDepLoc());
            }
            if (hasIsArrLoc()) {
                i += CodedOutputStreamMicro.computeStringSize(12, getIsArrLoc());
            }
            if (hasArrContent()) {
                i += CodedOutputStreamMicro.computeStringSize(13, getArrContent());
            }
            if (hasDepContent()) {
                i += CodedOutputStreamMicro.computeStringSize(14, getDepContent());
            }
            this.f15827C = i;
            return i;
        }

        public String getStartTime() {
            return this.f15835h;
        }

        public String getStationId() {
            return this.f15829b;
        }

        public String getStationName() {
            return this.f15833f;
        }

        public String getStationNo() {
            return this.f15831d;
        }

        public String getStopTime() {
            return this.f15839l;
        }

        public String getSubTrainNum() {
            return this.f15841n;
        }

        public boolean hasArrContent() {
            return this.f15852y;
        }

        public boolean hasArriveTime() {
            return this.f15836i;
        }

        public boolean hasDepContent() {
            return this.f15825A;
        }

        public boolean hasIsArrLoc() {
            return this.f15850w;
        }

        public boolean hasIsCurLoc() {
            return this.f15846s;
        }

        public boolean hasIsDepLoc() {
            return this.f15848u;
        }

        public boolean hasIsShow() {
            return this.f15844q;
        }

        public boolean hasKm() {
            return this.f15842o;
        }

        public boolean hasStartTime() {
            return this.f15834g;
        }

        public boolean hasStationId() {
            return this.f15828a;
        }

        public boolean hasStationName() {
            return this.f15832e;
        }

        public boolean hasStationNo() {
            return this.f15830c;
        }

        public boolean hasStopTime() {
            return this.f15838k;
        }

        public boolean hasSubTrainNum() {
            return this.f15840m;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TrainStopData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setStationId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setStationNo(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setStationName(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setStartTime(codedInputStreamMicro.readString());
                        continue;
                    case 42:
                        setArriveTime(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setStopTime(codedInputStreamMicro.readString());
                        continue;
                    case 58:
                        setSubTrainNum(codedInputStreamMicro.readString());
                        continue;
                    case 66:
                        setKm(codedInputStreamMicro.readString());
                        continue;
                    case NavCarInfo.CarType_57L /*72*/:
                        setIsShow(codedInputStreamMicro.readInt32());
                        continue;
                    case 82:
                        setIsCurLoc(codedInputStreamMicro.readString());
                        continue;
                    case 90:
                        setIsDepLoc(codedInputStreamMicro.readString());
                        continue;
                    case 98:
                        setIsArrLoc(codedInputStreamMicro.readString());
                        continue;
                    case 106:
                        setArrContent(codedInputStreamMicro.readString());
                        continue;
                    case 114:
                        setDepContent(codedInputStreamMicro.readString());
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

        public TrainStopData setArrContent(String str) {
            this.f15852y = true;
            this.f15853z = str;
            return this;
        }

        public TrainStopData setArriveTime(String str) {
            this.f15836i = true;
            this.f15837j = str;
            return this;
        }

        public TrainStopData setDepContent(String str) {
            this.f15825A = true;
            this.f15826B = str;
            return this;
        }

        public TrainStopData setIsArrLoc(String str) {
            this.f15850w = true;
            this.f15851x = str;
            return this;
        }

        public TrainStopData setIsCurLoc(String str) {
            this.f15846s = true;
            this.f15847t = str;
            return this;
        }

        public TrainStopData setIsDepLoc(String str) {
            this.f15848u = true;
            this.f15849v = str;
            return this;
        }

        public TrainStopData setIsShow(int i) {
            this.f15844q = true;
            this.f15845r = i;
            return this;
        }

        public TrainStopData setKm(String str) {
            this.f15842o = true;
            this.f15843p = str;
            return this;
        }

        public TrainStopData setStartTime(String str) {
            this.f15834g = true;
            this.f15835h = str;
            return this;
        }

        public TrainStopData setStationId(String str) {
            this.f15828a = true;
            this.f15829b = str;
            return this;
        }

        public TrainStopData setStationName(String str) {
            this.f15832e = true;
            this.f15833f = str;
            return this;
        }

        public TrainStopData setStationNo(String str) {
            this.f15830c = true;
            this.f15831d = str;
            return this;
        }

        public TrainStopData setStopTime(String str) {
            this.f15838k = true;
            this.f15839l = str;
            return this;
        }

        public TrainStopData setSubTrainNum(String str) {
            this.f15840m = true;
            this.f15841n = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasStationId()) {
                codedOutputStreamMicro.writeString(1, getStationId());
            }
            if (hasStationNo()) {
                codedOutputStreamMicro.writeString(2, getStationNo());
            }
            if (hasStationName()) {
                codedOutputStreamMicro.writeString(3, getStationName());
            }
            if (hasStartTime()) {
                codedOutputStreamMicro.writeString(4, getStartTime());
            }
            if (hasArriveTime()) {
                codedOutputStreamMicro.writeString(5, getArriveTime());
            }
            if (hasStopTime()) {
                codedOutputStreamMicro.writeString(6, getStopTime());
            }
            if (hasSubTrainNum()) {
                codedOutputStreamMicro.writeString(7, getSubTrainNum());
            }
            if (hasKm()) {
                codedOutputStreamMicro.writeString(8, getKm());
            }
            if (hasIsShow()) {
                codedOutputStreamMicro.writeInt32(9, getIsShow());
            }
            if (hasIsCurLoc()) {
                codedOutputStreamMicro.writeString(10, getIsCurLoc());
            }
            if (hasIsDepLoc()) {
                codedOutputStreamMicro.writeString(11, getIsDepLoc());
            }
            if (hasIsArrLoc()) {
                codedOutputStreamMicro.writeString(12, getIsArrLoc());
            }
            if (hasArrContent()) {
                codedOutputStreamMicro.writeString(13, getArrContent());
            }
            if (hasDepContent()) {
                codedOutputStreamMicro.writeString(14, getDepContent());
            }
        }
    }

    public static final class Transport extends MessageMicro {
        public static final int SMS_PHONE_FIELD_NUMBER = 6;
        public static final int TRANSPORT_ICON_FIELD_NUMBER = 1;
        public static final int TRANSPORT_LINK_FIELD_NUMBER = 4;
        public static final int TRANSPORT_TEXT_FIELD_NUMBER = 2;
        public static final int TRANSPORT_TIME_FIELD_NUMBER = 3;
        public static final int TRANSPORT_TYPE_FIELD_NUMBER = 5;
        /* renamed from: a */
        private boolean f15854a;
        /* renamed from: b */
        private String f15855b = "";
        /* renamed from: c */
        private boolean f15856c;
        /* renamed from: d */
        private String f15857d = "";
        /* renamed from: e */
        private boolean f15858e;
        /* renamed from: f */
        private String f15859f = "";
        /* renamed from: g */
        private boolean f15860g;
        /* renamed from: h */
        private String f15861h = "";
        /* renamed from: i */
        private boolean f15862i;
        /* renamed from: j */
        private int f15863j = 0;
        /* renamed from: k */
        private boolean f15864k;
        /* renamed from: l */
        private String f15865l = "";
        /* renamed from: m */
        private int f15866m = -1;

        public static Transport parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new Transport().mergeFrom(codedInputStreamMicro);
        }

        public static Transport parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (Transport) new Transport().mergeFrom(bArr);
        }

        public final Transport clear() {
            clearTransportIcon();
            clearTransportText();
            clearTransportTime();
            clearTransportLink();
            clearTransportType();
            clearSmsPhone();
            this.f15866m = -1;
            return this;
        }

        public Transport clearSmsPhone() {
            this.f15864k = false;
            this.f15865l = "";
            return this;
        }

        public Transport clearTransportIcon() {
            this.f15854a = false;
            this.f15855b = "";
            return this;
        }

        public Transport clearTransportLink() {
            this.f15860g = false;
            this.f15861h = "";
            return this;
        }

        public Transport clearTransportText() {
            this.f15856c = false;
            this.f15857d = "";
            return this;
        }

        public Transport clearTransportTime() {
            this.f15858e = false;
            this.f15859f = "";
            return this;
        }

        public Transport clearTransportType() {
            this.f15862i = false;
            this.f15863j = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15866m < 0) {
                getSerializedSize();
            }
            return this.f15866m;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTransportIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTransportIcon());
            }
            if (hasTransportText()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTransportText());
            }
            if (hasTransportTime()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTransportTime());
            }
            if (hasTransportLink()) {
                i += CodedOutputStreamMicro.computeStringSize(4, getTransportLink());
            }
            if (hasTransportType()) {
                i += CodedOutputStreamMicro.computeInt32Size(5, getTransportType());
            }
            if (hasSmsPhone()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getSmsPhone());
            }
            this.f15866m = i;
            return i;
        }

        public String getSmsPhone() {
            return this.f15865l;
        }

        public String getTransportIcon() {
            return this.f15855b;
        }

        public String getTransportLink() {
            return this.f15861h;
        }

        public String getTransportText() {
            return this.f15857d;
        }

        public String getTransportTime() {
            return this.f15859f;
        }

        public int getTransportType() {
            return this.f15863j;
        }

        public boolean hasSmsPhone() {
            return this.f15864k;
        }

        public boolean hasTransportIcon() {
            return this.f15854a;
        }

        public boolean hasTransportLink() {
            return this.f15860g;
        }

        public boolean hasTransportText() {
            return this.f15856c;
        }

        public boolean hasTransportTime() {
            return this.f15858e;
        }

        public boolean hasTransportType() {
            return this.f15862i;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Transport mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTransportIcon(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setTransportText(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTransportTime(codedInputStreamMicro.readString());
                        continue;
                    case 34:
                        setTransportLink(codedInputStreamMicro.readString());
                        continue;
                    case 40:
                        setTransportType(codedInputStreamMicro.readInt32());
                        continue;
                    case 50:
                        setSmsPhone(codedInputStreamMicro.readString());
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

        public Transport setSmsPhone(String str) {
            this.f15864k = true;
            this.f15865l = str;
            return this;
        }

        public Transport setTransportIcon(String str) {
            this.f15854a = true;
            this.f15855b = str;
            return this;
        }

        public Transport setTransportLink(String str) {
            this.f15860g = true;
            this.f15861h = str;
            return this;
        }

        public Transport setTransportText(String str) {
            this.f15856c = true;
            this.f15857d = str;
            return this;
        }

        public Transport setTransportTime(String str) {
            this.f15858e = true;
            this.f15859f = str;
            return this;
        }

        public Transport setTransportType(int i) {
            this.f15862i = true;
            this.f15863j = i;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTransportIcon()) {
                codedOutputStreamMicro.writeString(1, getTransportIcon());
            }
            if (hasTransportText()) {
                codedOutputStreamMicro.writeString(2, getTransportText());
            }
            if (hasTransportTime()) {
                codedOutputStreamMicro.writeString(3, getTransportTime());
            }
            if (hasTransportLink()) {
                codedOutputStreamMicro.writeString(4, getTransportLink());
            }
            if (hasTransportType()) {
                codedOutputStreamMicro.writeInt32(5, getTransportType());
            }
            if (hasSmsPhone()) {
                codedOutputStreamMicro.writeString(6, getSmsPhone());
            }
        }
    }

    public static final class TripCardInfo extends MessageMicro {
        public static final int CARD_ARRAY_FIELD_NUMBER = 3;
        public static final int CARD_INFO_FIELD_NUMBER = 2;
        public static final int CONTROL_INFO_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15867a;
        /* renamed from: b */
        private ControlInfo f15868b = null;
        /* renamed from: c */
        private boolean f15869c;
        /* renamed from: d */
        private CardInfo f15870d = null;
        /* renamed from: e */
        private List<CardInfo> f15871e = Collections.emptyList();
        /* renamed from: f */
        private int f15872f = -1;

        public static TripCardInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TripCardInfo().mergeFrom(codedInputStreamMicro);
        }

        public static TripCardInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TripCardInfo) new TripCardInfo().mergeFrom(bArr);
        }

        public TripCardInfo addCardArray(CardInfo cardInfo) {
            if (cardInfo != null) {
                if (this.f15871e.isEmpty()) {
                    this.f15871e = new ArrayList();
                }
                this.f15871e.add(cardInfo);
            }
            return this;
        }

        public final TripCardInfo clear() {
            clearControlInfo();
            clearCardInfo();
            clearCardArray();
            this.f15872f = -1;
            return this;
        }

        public TripCardInfo clearCardArray() {
            this.f15871e = Collections.emptyList();
            return this;
        }

        public TripCardInfo clearCardInfo() {
            this.f15869c = false;
            this.f15870d = null;
            return this;
        }

        public TripCardInfo clearControlInfo() {
            this.f15867a = false;
            this.f15868b = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15872f < 0) {
                getSerializedSize();
            }
            return this.f15872f;
        }

        public CardInfo getCardArray(int i) {
            return (CardInfo) this.f15871e.get(i);
        }

        public int getCardArrayCount() {
            return this.f15871e.size();
        }

        public List<CardInfo> getCardArrayList() {
            return this.f15871e;
        }

        public CardInfo getCardInfo() {
            return this.f15870d;
        }

        public ControlInfo getControlInfo() {
            return this.f15868b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasControlInfo()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getControlInfo());
            }
            if (hasCardInfo()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getCardInfo());
            }
            int i2 = i;
            for (CardInfo computeMessageSize : getCardArrayList()) {
                i2 = CodedOutputStreamMicro.computeMessageSize(3, computeMessageSize) + i2;
            }
            this.f15872f = i2;
            return i2;
        }

        public boolean hasCardInfo() {
            return this.f15869c;
        }

        public boolean hasControlInfo() {
            return this.f15867a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TripCardInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro controlInfo;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        controlInfo = new ControlInfo();
                        codedInputStreamMicro.readMessage(controlInfo);
                        setControlInfo(controlInfo);
                        continue;
                    case 18:
                        controlInfo = new CardInfo();
                        codedInputStreamMicro.readMessage(controlInfo);
                        setCardInfo(controlInfo);
                        continue;
                    case 26:
                        controlInfo = new CardInfo();
                        codedInputStreamMicro.readMessage(controlInfo);
                        addCardArray(controlInfo);
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

        public TripCardInfo setCardArray(int i, CardInfo cardInfo) {
            if (cardInfo != null) {
                this.f15871e.set(i, cardInfo);
            }
            return this;
        }

        public TripCardInfo setCardInfo(CardInfo cardInfo) {
            if (cardInfo == null) {
                return clearCardInfo();
            }
            this.f15869c = true;
            this.f15870d = cardInfo;
            return this;
        }

        public TripCardInfo setControlInfo(ControlInfo controlInfo) {
            if (controlInfo == null) {
                return clearControlInfo();
            }
            this.f15867a = true;
            this.f15868b = controlInfo;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasControlInfo()) {
                codedOutputStreamMicro.writeMessage(1, getControlInfo());
            }
            if (hasCardInfo()) {
                codedOutputStreamMicro.writeMessage(2, getCardInfo());
            }
            for (CardInfo writeMessage : getCardArrayList()) {
                codedOutputStreamMicro.writeMessage(3, writeMessage);
            }
        }
    }

    public static final class TripExt extends MessageMicro {
        public static final int TRIP_EXT_ELEMS_FIELD_NUMBER = 1;
        /* renamed from: a */
        private List<TripExtElem> f15873a = Collections.emptyList();
        /* renamed from: b */
        private int f15874b = -1;

        public static TripExt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TripExt().mergeFrom(codedInputStreamMicro);
        }

        public static TripExt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TripExt) new TripExt().mergeFrom(bArr);
        }

        public TripExt addTripExtElems(TripExtElem tripExtElem) {
            if (tripExtElem != null) {
                if (this.f15873a.isEmpty()) {
                    this.f15873a = new ArrayList();
                }
                this.f15873a.add(tripExtElem);
            }
            return this;
        }

        public final TripExt clear() {
            clearTripExtElems();
            this.f15874b = -1;
            return this;
        }

        public TripExt clearTripExtElems() {
            this.f15873a = Collections.emptyList();
            return this;
        }

        public int getCachedSize() {
            if (this.f15874b < 0) {
                getSerializedSize();
            }
            return this.f15874b;
        }

        public int getSerializedSize() {
            int i = 0;
            for (TripExtElem computeMessageSize : getTripExtElemsList()) {
                i = CodedOutputStreamMicro.computeMessageSize(1, computeMessageSize) + i;
            }
            this.f15874b = i;
            return i;
        }

        public TripExtElem getTripExtElems(int i) {
            return (TripExtElem) this.f15873a.get(i);
        }

        public int getTripExtElemsCount() {
            return this.f15873a.size();
        }

        public List<TripExtElem> getTripExtElemsList() {
            return this.f15873a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TripExt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        MessageMicro tripExtElem = new TripExtElem();
                        codedInputStreamMicro.readMessage(tripExtElem);
                        addTripExtElems(tripExtElem);
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

        public TripExt setTripExtElems(int i, TripExtElem tripExtElem) {
            if (tripExtElem != null) {
                this.f15873a.set(i, tripExtElem);
            }
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            for (TripExtElem writeMessage : getTripExtElemsList()) {
                codedOutputStreamMicro.writeMessage(1, writeMessage);
            }
        }
    }

    public static final class TripExtElem extends MessageMicro {
        public static final int ICON_FIELD_NUMBER = 1;
        public static final int SUBTITLE_FIELD_NUMBER = 3;
        public static final int TITLE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15875a;
        /* renamed from: b */
        private String f15876b = "";
        /* renamed from: c */
        private boolean f15877c;
        /* renamed from: d */
        private String f15878d = "";
        /* renamed from: e */
        private boolean f15879e;
        /* renamed from: f */
        private String f15880f = "";
        /* renamed from: g */
        private int f15881g = -1;

        public static TripExtElem parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new TripExtElem().mergeFrom(codedInputStreamMicro);
        }

        public static TripExtElem parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (TripExtElem) new TripExtElem().mergeFrom(bArr);
        }

        public final TripExtElem clear() {
            clearIcon();
            clearTitle();
            clearSubtitle();
            this.f15881g = -1;
            return this;
        }

        public TripExtElem clearIcon() {
            this.f15875a = false;
            this.f15876b = "";
            return this;
        }

        public TripExtElem clearSubtitle() {
            this.f15879e = false;
            this.f15880f = "";
            return this;
        }

        public TripExtElem clearTitle() {
            this.f15877c = false;
            this.f15878d = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15881g < 0) {
                getSerializedSize();
            }
            return this.f15881g;
        }

        public String getIcon() {
            return this.f15876b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasIcon()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getIcon());
            }
            if (hasTitle()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getTitle());
            }
            if (hasSubtitle()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getSubtitle());
            }
            this.f15881g = i;
            return i;
        }

        public String getSubtitle() {
            return this.f15880f;
        }

        public String getTitle() {
            return this.f15878d;
        }

        public boolean hasIcon() {
            return this.f15875a;
        }

        public boolean hasSubtitle() {
            return this.f15879e;
        }

        public boolean hasTitle() {
            return this.f15877c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public TripExtElem mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
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
                        setSubtitle(codedInputStreamMicro.readString());
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

        public TripExtElem setIcon(String str) {
            this.f15875a = true;
            this.f15876b = str;
            return this;
        }

        public TripExtElem setSubtitle(String str) {
            this.f15879e = true;
            this.f15880f = str;
            return this;
        }

        public TripExtElem setTitle(String str) {
            this.f15877c = true;
            this.f15878d = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasIcon()) {
                codedOutputStreamMicro.writeString(1, getIcon());
            }
            if (hasTitle()) {
                codedOutputStreamMicro.writeString(2, getTitle());
            }
            if (hasSubtitle()) {
                codedOutputStreamMicro.writeString(3, getSubtitle());
            }
        }
    }

    public static final class UiData extends MessageMicro {
        public static final int DRIVER_PAGE_CARD_FIELD_NUMBER = 3;
        public static final int MAP_PAGE_BUBBLE_FIELD_NUMBER = 1;
        public static final int TRIP_PAGE_FIELD_NUMBER = 2;
        /* renamed from: a */
        private boolean f15882a;
        /* renamed from: b */
        private TripCardInfo f15883b = null;
        /* renamed from: c */
        private boolean f15884c;
        /* renamed from: d */
        private TripCardInfo f15885d = null;
        /* renamed from: e */
        private boolean f15886e;
        /* renamed from: f */
        private DriverPageCardInfo f15887f = null;
        /* renamed from: g */
        private int f15888g = -1;

        public static UiData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new UiData().mergeFrom(codedInputStreamMicro);
        }

        public static UiData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (UiData) new UiData().mergeFrom(bArr);
        }

        public final UiData clear() {
            clearMapPageBubble();
            clearTripPage();
            clearDriverPageCard();
            this.f15888g = -1;
            return this;
        }

        public UiData clearDriverPageCard() {
            this.f15886e = false;
            this.f15887f = null;
            return this;
        }

        public UiData clearMapPageBubble() {
            this.f15882a = false;
            this.f15883b = null;
            return this;
        }

        public UiData clearTripPage() {
            this.f15884c = false;
            this.f15885d = null;
            return this;
        }

        public int getCachedSize() {
            if (this.f15888g < 0) {
                getSerializedSize();
            }
            return this.f15888g;
        }

        public DriverPageCardInfo getDriverPageCard() {
            return this.f15887f;
        }

        public TripCardInfo getMapPageBubble() {
            return this.f15883b;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasMapPageBubble()) {
                i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getMapPageBubble());
            }
            if (hasTripPage()) {
                i += CodedOutputStreamMicro.computeMessageSize(2, getTripPage());
            }
            if (hasDriverPageCard()) {
                i += CodedOutputStreamMicro.computeMessageSize(3, getDriverPageCard());
            }
            this.f15888g = i;
            return i;
        }

        public TripCardInfo getTripPage() {
            return this.f15885d;
        }

        public boolean hasDriverPageCard() {
            return this.f15886e;
        }

        public boolean hasMapPageBubble() {
            return this.f15882a;
        }

        public boolean hasTripPage() {
            return this.f15884c;
        }

        public final boolean isInitialized() {
            return true;
        }

        public UiData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                MessageMicro tripCardInfo;
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        tripCardInfo = new TripCardInfo();
                        codedInputStreamMicro.readMessage(tripCardInfo);
                        setMapPageBubble(tripCardInfo);
                        continue;
                    case 18:
                        tripCardInfo = new TripCardInfo();
                        codedInputStreamMicro.readMessage(tripCardInfo);
                        setTripPage(tripCardInfo);
                        continue;
                    case 26:
                        tripCardInfo = new DriverPageCardInfo();
                        codedInputStreamMicro.readMessage(tripCardInfo);
                        setDriverPageCard(tripCardInfo);
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

        public UiData setDriverPageCard(DriverPageCardInfo driverPageCardInfo) {
            if (driverPageCardInfo == null) {
                return clearDriverPageCard();
            }
            this.f15886e = true;
            this.f15887f = driverPageCardInfo;
            return this;
        }

        public UiData setMapPageBubble(TripCardInfo tripCardInfo) {
            if (tripCardInfo == null) {
                return clearMapPageBubble();
            }
            this.f15882a = true;
            this.f15883b = tripCardInfo;
            return this;
        }

        public UiData setTripPage(TripCardInfo tripCardInfo) {
            if (tripCardInfo == null) {
                return clearTripPage();
            }
            this.f15884c = true;
            this.f15885d = tripCardInfo;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasMapPageBubble()) {
                codedOutputStreamMicro.writeMessage(1, getMapPageBubble());
            }
            if (hasTripPage()) {
                codedOutputStreamMicro.writeMessage(2, getTripPage());
            }
            if (hasDriverPageCard()) {
                codedOutputStreamMicro.writeMessage(3, getDriverPageCard());
            }
        }
    }

    public static final class UpdateInfo extends MessageMicro {
        public static final int SUB_TRIP_ID_FIELD_NUMBER = 2;
        public static final int SUG_BLACK_ID_FIELD_NUMBER = 6;
        public static final int SUG_POINT_UID_FIELD_NUMBER = 5;
        public static final int TIPS_CONTENT_FIELD_NUMBER = 3;
        public static final int TIPS_TYPE_FIELD_NUMBER = 4;
        public static final int TRIP_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15889a;
        /* renamed from: b */
        private String f15890b = "";
        /* renamed from: c */
        private boolean f15891c;
        /* renamed from: d */
        private String f15892d = "";
        /* renamed from: e */
        private boolean f15893e;
        /* renamed from: f */
        private String f15894f = "";
        /* renamed from: g */
        private boolean f15895g;
        /* renamed from: h */
        private int f15896h = 0;
        /* renamed from: i */
        private boolean f15897i;
        /* renamed from: j */
        private String f15898j = "";
        /* renamed from: k */
        private boolean f15899k;
        /* renamed from: l */
        private String f15900l = "";
        /* renamed from: m */
        private int f15901m = -1;

        public static UpdateInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new UpdateInfo().mergeFrom(codedInputStreamMicro);
        }

        public static UpdateInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (UpdateInfo) new UpdateInfo().mergeFrom(bArr);
        }

        public final UpdateInfo clear() {
            clearTripId();
            clearSubTripId();
            clearTipsContent();
            clearTipsType();
            clearSugPointUid();
            clearSugBlackId();
            this.f15901m = -1;
            return this;
        }

        public UpdateInfo clearSubTripId() {
            this.f15891c = false;
            this.f15892d = "";
            return this;
        }

        public UpdateInfo clearSugBlackId() {
            this.f15899k = false;
            this.f15900l = "";
            return this;
        }

        public UpdateInfo clearSugPointUid() {
            this.f15897i = false;
            this.f15898j = "";
            return this;
        }

        public UpdateInfo clearTipsContent() {
            this.f15893e = false;
            this.f15894f = "";
            return this;
        }

        public UpdateInfo clearTipsType() {
            this.f15895g = false;
            this.f15896h = 0;
            return this;
        }

        public UpdateInfo clearTripId() {
            this.f15889a = false;
            this.f15890b = "";
            return this;
        }

        public int getCachedSize() {
            if (this.f15901m < 0) {
                getSerializedSize();
            }
            return this.f15901m;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTripId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
            }
            if (hasSubTripId()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getSubTripId());
            }
            if (hasTipsContent()) {
                i += CodedOutputStreamMicro.computeStringSize(3, getTipsContent());
            }
            if (hasTipsType()) {
                i += CodedOutputStreamMicro.computeInt32Size(4, getTipsType());
            }
            if (hasSugPointUid()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getSugPointUid());
            }
            if (hasSugBlackId()) {
                i += CodedOutputStreamMicro.computeStringSize(6, getSugBlackId());
            }
            this.f15901m = i;
            return i;
        }

        public String getSubTripId() {
            return this.f15892d;
        }

        public String getSugBlackId() {
            return this.f15900l;
        }

        public String getSugPointUid() {
            return this.f15898j;
        }

        public String getTipsContent() {
            return this.f15894f;
        }

        public int getTipsType() {
            return this.f15896h;
        }

        public String getTripId() {
            return this.f15890b;
        }

        public boolean hasSubTripId() {
            return this.f15891c;
        }

        public boolean hasSugBlackId() {
            return this.f15899k;
        }

        public boolean hasSugPointUid() {
            return this.f15897i;
        }

        public boolean hasTipsContent() {
            return this.f15893e;
        }

        public boolean hasTipsType() {
            return this.f15895g;
        }

        public boolean hasTripId() {
            return this.f15889a;
        }

        public final boolean isInitialized() {
            return this.f15889a;
        }

        public UpdateInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTripId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setSubTripId(codedInputStreamMicro.readString());
                        continue;
                    case 26:
                        setTipsContent(codedInputStreamMicro.readString());
                        continue;
                    case 32:
                        setTipsType(codedInputStreamMicro.readInt32());
                        continue;
                    case 42:
                        setSugPointUid(codedInputStreamMicro.readString());
                        continue;
                    case 50:
                        setSugBlackId(codedInputStreamMicro.readString());
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

        public UpdateInfo setSubTripId(String str) {
            this.f15891c = true;
            this.f15892d = str;
            return this;
        }

        public UpdateInfo setSugBlackId(String str) {
            this.f15899k = true;
            this.f15900l = str;
            return this;
        }

        public UpdateInfo setSugPointUid(String str) {
            this.f15897i = true;
            this.f15898j = str;
            return this;
        }

        public UpdateInfo setTipsContent(String str) {
            this.f15893e = true;
            this.f15894f = str;
            return this;
        }

        public UpdateInfo setTipsType(int i) {
            this.f15895g = true;
            this.f15896h = i;
            return this;
        }

        public UpdateInfo setTripId(String str) {
            this.f15889a = true;
            this.f15890b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTripId()) {
                codedOutputStreamMicro.writeString(1, getTripId());
            }
            if (hasSubTripId()) {
                codedOutputStreamMicro.writeString(2, getSubTripId());
            }
            if (hasTipsContent()) {
                codedOutputStreamMicro.writeString(3, getTipsContent());
            }
            if (hasTipsType()) {
                codedOutputStreamMicro.writeInt32(4, getTipsType());
            }
            if (hasSugPointUid()) {
                codedOutputStreamMicro.writeString(5, getSugPointUid());
            }
            if (hasSugBlackId()) {
                codedOutputStreamMicro.writeString(6, getSugBlackId());
            }
        }
    }

    public static final class UpdateRCInfo extends MessageMicro {
        public static final int ORDER_AUTO_REMIND_FIELD_NUMBER = 3;
        public static final int PUSH_REMIND_FIELD_NUMBER = 2;
        public static final int REMIND_TIME_FIELD_NUMBER = 4;
        public static final int SMS_PHONE_FIELD_NUMBER = 5;
        public static final int SMS_REMIND_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15902a;
        /* renamed from: b */
        private long f15903b = 0;
        /* renamed from: c */
        private boolean f15904c;
        /* renamed from: d */
        private long f15905d = 0;
        /* renamed from: e */
        private boolean f15906e;
        /* renamed from: f */
        private long f15907f = 0;
        /* renamed from: g */
        private boolean f15908g;
        /* renamed from: h */
        private long f15909h = 0;
        /* renamed from: i */
        private boolean f15910i;
        /* renamed from: j */
        private String f15911j = "";
        /* renamed from: k */
        private int f15912k = -1;

        public static UpdateRCInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new UpdateRCInfo().mergeFrom(codedInputStreamMicro);
        }

        public static UpdateRCInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (UpdateRCInfo) new UpdateRCInfo().mergeFrom(bArr);
        }

        public final UpdateRCInfo clear() {
            clearSmsRemind();
            clearPushRemind();
            clearOrderAutoRemind();
            clearRemindTime();
            clearSmsPhone();
            this.f15912k = -1;
            return this;
        }

        public UpdateRCInfo clearOrderAutoRemind() {
            this.f15906e = false;
            this.f15907f = 0;
            return this;
        }

        public UpdateRCInfo clearPushRemind() {
            this.f15904c = false;
            this.f15905d = 0;
            return this;
        }

        public UpdateRCInfo clearRemindTime() {
            this.f15908g = false;
            this.f15909h = 0;
            return this;
        }

        public UpdateRCInfo clearSmsPhone() {
            this.f15910i = false;
            this.f15911j = "";
            return this;
        }

        public UpdateRCInfo clearSmsRemind() {
            this.f15902a = false;
            this.f15903b = 0;
            return this;
        }

        public int getCachedSize() {
            if (this.f15912k < 0) {
                getSerializedSize();
            }
            return this.f15912k;
        }

        public long getOrderAutoRemind() {
            return this.f15907f;
        }

        public long getPushRemind() {
            return this.f15905d;
        }

        public long getRemindTime() {
            return this.f15909h;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasSmsRemind()) {
                i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getSmsRemind());
            }
            if (hasPushRemind()) {
                i += CodedOutputStreamMicro.computeInt64Size(2, getPushRemind());
            }
            if (hasOrderAutoRemind()) {
                i += CodedOutputStreamMicro.computeInt64Size(3, getOrderAutoRemind());
            }
            if (hasRemindTime()) {
                i += CodedOutputStreamMicro.computeInt64Size(4, getRemindTime());
            }
            if (hasSmsPhone()) {
                i += CodedOutputStreamMicro.computeStringSize(5, getSmsPhone());
            }
            this.f15912k = i;
            return i;
        }

        public String getSmsPhone() {
            return this.f15911j;
        }

        public long getSmsRemind() {
            return this.f15903b;
        }

        public boolean hasOrderAutoRemind() {
            return this.f15906e;
        }

        public boolean hasPushRemind() {
            return this.f15904c;
        }

        public boolean hasRemindTime() {
            return this.f15908g;
        }

        public boolean hasSmsPhone() {
            return this.f15910i;
        }

        public boolean hasSmsRemind() {
            return this.f15902a;
        }

        public final boolean isInitialized() {
            return this.f15902a && this.f15904c && this.f15906e && this.f15908g && this.f15910i;
        }

        public UpdateRCInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setSmsRemind(codedInputStreamMicro.readInt64());
                        continue;
                    case 16:
                        setPushRemind(codedInputStreamMicro.readInt64());
                        continue;
                    case 24:
                        setOrderAutoRemind(codedInputStreamMicro.readInt64());
                        continue;
                    case 32:
                        setRemindTime(codedInputStreamMicro.readInt64());
                        continue;
                    case 42:
                        setSmsPhone(codedInputStreamMicro.readString());
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

        public UpdateRCInfo setOrderAutoRemind(long j) {
            this.f15906e = true;
            this.f15907f = j;
            return this;
        }

        public UpdateRCInfo setPushRemind(long j) {
            this.f15904c = true;
            this.f15905d = j;
            return this;
        }

        public UpdateRCInfo setRemindTime(long j) {
            this.f15908g = true;
            this.f15909h = j;
            return this;
        }

        public UpdateRCInfo setSmsPhone(String str) {
            this.f15910i = true;
            this.f15911j = str;
            return this;
        }

        public UpdateRCInfo setSmsRemind(long j) {
            this.f15902a = true;
            this.f15903b = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasSmsRemind()) {
                codedOutputStreamMicro.writeInt64(1, getSmsRemind());
            }
            if (hasPushRemind()) {
                codedOutputStreamMicro.writeInt64(2, getPushRemind());
            }
            if (hasOrderAutoRemind()) {
                codedOutputStreamMicro.writeInt64(3, getOrderAutoRemind());
            }
            if (hasRemindTime()) {
                codedOutputStreamMicro.writeInt64(4, getRemindTime());
            }
            if (hasSmsPhone()) {
                codedOutputStreamMicro.writeString(5, getSmsPhone());
            }
        }
    }

    public static final class UpdateRemindInfo extends MessageMicro {
        public static final int BDUID_FIELD_NUMBER = 2;
        public static final int TRIP_ID_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15913a;
        /* renamed from: b */
        private String f15914b = "";
        /* renamed from: c */
        private boolean f15915c;
        /* renamed from: d */
        private String f15916d = "";
        /* renamed from: e */
        private int f15917e = -1;

        public static UpdateRemindInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new UpdateRemindInfo().mergeFrom(codedInputStreamMicro);
        }

        public static UpdateRemindInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (UpdateRemindInfo) new UpdateRemindInfo().mergeFrom(bArr);
        }

        public final UpdateRemindInfo clear() {
            clearTripId();
            clearBduid();
            this.f15917e = -1;
            return this;
        }

        public UpdateRemindInfo clearBduid() {
            this.f15915c = false;
            this.f15916d = "";
            return this;
        }

        public UpdateRemindInfo clearTripId() {
            this.f15913a = false;
            this.f15914b = "";
            return this;
        }

        public String getBduid() {
            return this.f15916d;
        }

        public int getCachedSize() {
            if (this.f15917e < 0) {
                getSerializedSize();
            }
            return this.f15917e;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTripId()) {
                i = 0 + CodedOutputStreamMicro.computeStringSize(1, getTripId());
            }
            if (hasBduid()) {
                i += CodedOutputStreamMicro.computeStringSize(2, getBduid());
            }
            this.f15917e = i;
            return i;
        }

        public String getTripId() {
            return this.f15914b;
        }

        public boolean hasBduid() {
            return this.f15915c;
        }

        public boolean hasTripId() {
            return this.f15913a;
        }

        public final boolean isInitialized() {
            return this.f15913a && this.f15915c;
        }

        public UpdateRemindInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 10:
                        setTripId(codedInputStreamMicro.readString());
                        continue;
                    case 18:
                        setBduid(codedInputStreamMicro.readString());
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

        public UpdateRemindInfo setBduid(String str) {
            this.f15915c = true;
            this.f15916d = str;
            return this;
        }

        public UpdateRemindInfo setTripId(String str) {
            this.f15913a = true;
            this.f15914b = str;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTripId()) {
                codedOutputStreamMicro.writeString(1, getTripId());
            }
            if (hasBduid()) {
                codedOutputStreamMicro.writeString(2, getBduid());
            }
        }
    }

    public static final class VersionInfo extends MessageMicro {
        public static final int AIRPORT_DATA_VERSION_FIELD_NUMBER = 2;
        public static final int SMS_DATA_VERSION_FIELD_NUMBER = 3;
        public static final int TRAIN_CITYINFO_VERSION_FIELD_NUMBER = 1;
        /* renamed from: a */
        private boolean f15918a;
        /* renamed from: b */
        private long f15919b = 0;
        /* renamed from: c */
        private boolean f15920c;
        /* renamed from: d */
        private long f15921d = 0;
        /* renamed from: e */
        private boolean f15922e;
        /* renamed from: f */
        private long f15923f = 0;
        /* renamed from: g */
        private int f15924g = -1;

        public static VersionInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            return new VersionInfo().mergeFrom(codedInputStreamMicro);
        }

        public static VersionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
            return (VersionInfo) new VersionInfo().mergeFrom(bArr);
        }

        public final VersionInfo clear() {
            clearTrainCityinfoVersion();
            clearAirportDataVersion();
            clearSmsDataVersion();
            this.f15924g = -1;
            return this;
        }

        public VersionInfo clearAirportDataVersion() {
            this.f15920c = false;
            this.f15921d = 0;
            return this;
        }

        public VersionInfo clearSmsDataVersion() {
            this.f15922e = false;
            this.f15923f = 0;
            return this;
        }

        public VersionInfo clearTrainCityinfoVersion() {
            this.f15918a = false;
            this.f15919b = 0;
            return this;
        }

        public long getAirportDataVersion() {
            return this.f15921d;
        }

        public int getCachedSize() {
            if (this.f15924g < 0) {
                getSerializedSize();
            }
            return this.f15924g;
        }

        public int getSerializedSize() {
            int i = 0;
            if (hasTrainCityinfoVersion()) {
                i = 0 + CodedOutputStreamMicro.computeInt64Size(1, getTrainCityinfoVersion());
            }
            if (hasAirportDataVersion()) {
                i += CodedOutputStreamMicro.computeInt64Size(2, getAirportDataVersion());
            }
            if (hasSmsDataVersion()) {
                i += CodedOutputStreamMicro.computeInt64Size(3, getSmsDataVersion());
            }
            this.f15924g = i;
            return i;
        }

        public long getSmsDataVersion() {
            return this.f15923f;
        }

        public long getTrainCityinfoVersion() {
            return this.f15919b;
        }

        public boolean hasAirportDataVersion() {
            return this.f15920c;
        }

        public boolean hasSmsDataVersion() {
            return this.f15922e;
        }

        public boolean hasTrainCityinfoVersion() {
            return this.f15918a;
        }

        public final boolean isInitialized() {
            return true;
        }

        public VersionInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
            while (true) {
                int readTag = codedInputStreamMicro.readTag();
                switch (readTag) {
                    case 0:
                        break;
                    case 8:
                        setTrainCityinfoVersion(codedInputStreamMicro.readInt64());
                        continue;
                    case 16:
                        setAirportDataVersion(codedInputStreamMicro.readInt64());
                        continue;
                    case 24:
                        setSmsDataVersion(codedInputStreamMicro.readInt64());
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

        public VersionInfo setAirportDataVersion(long j) {
            this.f15920c = true;
            this.f15921d = j;
            return this;
        }

        public VersionInfo setSmsDataVersion(long j) {
            this.f15922e = true;
            this.f15923f = j;
            return this;
        }

        public VersionInfo setTrainCityinfoVersion(long j) {
            this.f15918a = true;
            this.f15919b = j;
            return this;
        }

        public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
            if (hasTrainCityinfoVersion()) {
                codedOutputStreamMicro.writeInt64(1, getTrainCityinfoVersion());
            }
            if (hasAirportDataVersion()) {
                codedOutputStreamMicro.writeInt64(2, getAirportDataVersion());
            }
            if (hasSmsDataVersion()) {
                codedOutputStreamMicro.writeInt64(3, getSmsDataVersion());
            }
        }
    }

    public static TaResponse parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TaResponse().mergeFrom(codedInputStreamMicro);
    }

    public static TaResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TaResponse) new TaResponse().mergeFrom(bArr);
    }

    public final TaResponse clear() {
        clearDataResult();
        clearDataContent();
        this.f15929e = -1;
        return this;
    }

    public TaResponse clearDataContent() {
        this.f15927c = false;
        this.f15928d = null;
        return this;
    }

    public TaResponse clearDataResult() {
        this.f15925a = false;
        this.f15926b = null;
        return this;
    }

    public int getCachedSize() {
        if (this.f15929e < 0) {
            getSerializedSize();
        }
        return this.f15929e;
    }

    public TaContent getDataContent() {
        return this.f15928d;
    }

    public TaResult getDataResult() {
        return this.f15926b;
    }

    public int getSerializedSize() {
        int i = 0;
        if (hasDataResult()) {
            i = 0 + CodedOutputStreamMicro.computeMessageSize(1, getDataResult());
        }
        if (hasDataContent()) {
            i += CodedOutputStreamMicro.computeMessageSize(2, getDataContent());
        }
        this.f15929e = i;
        return i;
    }

    public boolean hasDataContent() {
        return this.f15927c;
    }

    public boolean hasDataResult() {
        return this.f15925a;
    }

    public final boolean isInitialized() {
        return (this.f15925a && getDataResult().isInitialized()) ? !hasDataContent() || getDataContent().isInitialized() : false;
    }

    public TaResponse mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            MessageMicro taResult;
            switch (readTag) {
                case 0:
                    break;
                case 10:
                    taResult = new TaResult();
                    codedInputStreamMicro.readMessage(taResult);
                    setDataResult(taResult);
                    continue;
                case 18:
                    taResult = new TaContent();
                    codedInputStreamMicro.readMessage(taResult);
                    setDataContent(taResult);
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

    public TaResponse setDataContent(TaContent taContent) {
        if (taContent == null) {
            return clearDataContent();
        }
        this.f15927c = true;
        this.f15928d = taContent;
        return this;
    }

    public TaResponse setDataResult(TaResult taResult) {
        if (taResult == null) {
            return clearDataResult();
        }
        this.f15925a = true;
        this.f15926b = taResult;
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
