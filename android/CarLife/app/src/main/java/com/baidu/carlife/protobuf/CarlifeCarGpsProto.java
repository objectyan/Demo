package com.baidu.carlife.protobuf;

import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.platform.comapi.map.provider.RouteLineResConst;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class CarlifeCarGpsProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_descriptor */
    private static Descriptor f6603x6978e65c;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeCarGps_fieldAccessorTable */
    private static FieldAccessorTable f6604x5939f0da;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeCarGpsProto$1 */
    static class C20541 implements InternalDescriptorAssigner {
        C20541() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeCarGpsProto.descriptor = root;
            CarlifeCarGpsProto.f6603x6978e65c = (Descriptor) CarlifeCarGpsProto.getDescriptor().getMessageTypes().get(0);
            CarlifeCarGpsProto.f6604x5939f0da = new FieldAccessorTable(CarlifeCarGpsProto.f6603x6978e65c, new String[]{"AntennaState", "SignalQuality", "Latitude", JNISearchConst.JNI_LONGITUDE, "Height", "Speed", "Heading", "Year", "Month", "Day", "Hrs", "Min", "Sec", "Fix", "Hdop", "Pdop", "Vdop", "SatsUsed", "SatsVisible", "HorPosError", "VertPosError", "NorthSpeed", "EastSpeed", "VertSpeed", "TimeStamp"}, CarlifeCarGps.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeCarGps extends GeneratedMessage {
        public static final int ANTENNASTATE_FIELD_NUMBER = 1;
        public static final int DAY_FIELD_NUMBER = 10;
        public static final int EASTSPEED_FIELD_NUMBER = 23;
        public static final int FIX_FIELD_NUMBER = 14;
        public static final int HDOP_FIELD_NUMBER = 15;
        public static final int HEADING_FIELD_NUMBER = 7;
        public static final int HEIGHT_FIELD_NUMBER = 5;
        public static final int HORPOSERROR_FIELD_NUMBER = 20;
        public static final int HRS_FIELD_NUMBER = 11;
        public static final int LATITUDE_FIELD_NUMBER = 3;
        public static final int LONGITUDE_FIELD_NUMBER = 4;
        public static final int MIN_FIELD_NUMBER = 12;
        public static final int MONTH_FIELD_NUMBER = 9;
        public static final int NORTHSPEED_FIELD_NUMBER = 22;
        public static final int PDOP_FIELD_NUMBER = 16;
        public static final int SATSUSED_FIELD_NUMBER = 18;
        public static final int SATSVISIBLE_FIELD_NUMBER = 19;
        public static final int SEC_FIELD_NUMBER = 13;
        public static final int SIGNALQUALITY_FIELD_NUMBER = 2;
        public static final int SPEED_FIELD_NUMBER = 6;
        public static final int TIMESTAMP_FIELD_NUMBER = 25;
        public static final int VDOP_FIELD_NUMBER = 17;
        public static final int VERTPOSERROR_FIELD_NUMBER = 21;
        public static final int VERTSPEED_FIELD_NUMBER = 24;
        public static final int YEAR_FIELD_NUMBER = 8;
        private static final CarlifeCarGps defaultInstance = new CarlifeCarGps();
        private int antennaState_;
        private int day_;
        private int eastSpeed_;
        private int fix_;
        private boolean hasAntennaState;
        private boolean hasDay;
        private boolean hasEastSpeed;
        private boolean hasFix;
        private boolean hasHdop;
        private boolean hasHeading;
        private boolean hasHeight;
        private boolean hasHorPosError;
        private boolean hasHrs;
        private boolean hasLatitude;
        private boolean hasLongitude;
        private boolean hasMin;
        private boolean hasMonth;
        private boolean hasNorthSpeed;
        private boolean hasPdop;
        private boolean hasSatsUsed;
        private boolean hasSatsVisible;
        private boolean hasSec;
        private boolean hasSignalQuality;
        private boolean hasSpeed;
        private boolean hasTimeStamp;
        private boolean hasVdop;
        private boolean hasVertPosError;
        private boolean hasVertSpeed;
        private boolean hasYear;
        private int hdop_;
        private int heading_;
        private int height_;
        private int horPosError_;
        private int hrs_;
        private int latitude_;
        private int longitude_;
        private int memoizedSerializedSize;
        private int min_;
        private int month_;
        private int northSpeed_;
        private int pdop_;
        private int satsUsed_;
        private int satsVisible_;
        private int sec_;
        private int signalQuality_;
        private int speed_;
        private long timeStamp_;
        private int vdop_;
        private int vertPosError_;
        private int vertSpeed_;
        private int year_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeCarGps result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeCarGps();
                return builder;
            }

            protected CarlifeCarGps internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeCarGps();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeCarGps.getDescriptor();
            }

            public CarlifeCarGps getDefaultInstanceForType() {
                return CarlifeCarGps.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeCarGps build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeCarGps buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeCarGps buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeCarGps returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeCarGps) {
                    return mergeFrom((CarlifeCarGps) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeCarGps other) {
                if (other != CarlifeCarGps.getDefaultInstance()) {
                    if (other.hasAntennaState()) {
                        setAntennaState(other.getAntennaState());
                    }
                    if (other.hasSignalQuality()) {
                        setSignalQuality(other.getSignalQuality());
                    }
                    if (other.hasLatitude()) {
                        setLatitude(other.getLatitude());
                    }
                    if (other.hasLongitude()) {
                        setLongitude(other.getLongitude());
                    }
                    if (other.hasHeight()) {
                        setHeight(other.getHeight());
                    }
                    if (other.hasSpeed()) {
                        setSpeed(other.getSpeed());
                    }
                    if (other.hasHeading()) {
                        setHeading(other.getHeading());
                    }
                    if (other.hasYear()) {
                        setYear(other.getYear());
                    }
                    if (other.hasMonth()) {
                        setMonth(other.getMonth());
                    }
                    if (other.hasDay()) {
                        setDay(other.getDay());
                    }
                    if (other.hasHrs()) {
                        setHrs(other.getHrs());
                    }
                    if (other.hasMin()) {
                        setMin(other.getMin());
                    }
                    if (other.hasSec()) {
                        setSec(other.getSec());
                    }
                    if (other.hasFix()) {
                        setFix(other.getFix());
                    }
                    if (other.hasHdop()) {
                        setHdop(other.getHdop());
                    }
                    if (other.hasPdop()) {
                        setPdop(other.getPdop());
                    }
                    if (other.hasVdop()) {
                        setVdop(other.getVdop());
                    }
                    if (other.hasSatsUsed()) {
                        setSatsUsed(other.getSatsUsed());
                    }
                    if (other.hasSatsVisible()) {
                        setSatsVisible(other.getSatsVisible());
                    }
                    if (other.hasHorPosError()) {
                        setHorPosError(other.getHorPosError());
                    }
                    if (other.hasVertPosError()) {
                        setVertPosError(other.getVertPosError());
                    }
                    if (other.hasNorthSpeed()) {
                        setNorthSpeed(other.getNorthSpeed());
                    }
                    if (other.hasEastSpeed()) {
                        setEastSpeed(other.getEastSpeed());
                    }
                    if (other.hasVertSpeed()) {
                        setVertSpeed(other.getVertSpeed());
                    }
                    if (other.hasTimeStamp()) {
                        setTimeStamp(other.getTimeStamp());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            break;
                        case 8:
                            setAntennaState(input.readUInt32());
                            continue;
                        case 16:
                            setSignalQuality(input.readUInt32());
                            continue;
                        case 24:
                            setLatitude(input.readInt32());
                            continue;
                        case 32:
                            setLongitude(input.readInt32());
                            continue;
                        case 40:
                            setHeight(input.readInt32());
                            continue;
                        case 48:
                            setSpeed(input.readUInt32());
                            continue;
                        case 56:
                            setHeading(input.readUInt32());
                            continue;
                        case 64:
                            setYear(input.readUInt32());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            setMonth(input.readUInt32());
                            continue;
                        case 80:
                            setDay(input.readUInt32());
                            continue;
                        case 88:
                            setHrs(input.readUInt32());
                            continue;
                        case 96:
                            setMin(input.readUInt32());
                            continue;
                        case 104:
                            setSec(input.readUInt32());
                            continue;
                        case 112:
                            setFix(input.readUInt32());
                            continue;
                        case 120:
                            setHdop(input.readUInt32());
                            continue;
                        case 128:
                            setPdop(input.readUInt32());
                            continue;
                        case RouteLineResConst.LINE_DARK_RED_NORMAL /*136*/:
                            setVdop(input.readUInt32());
                            continue;
                        case 144:
                            setSatsUsed(input.readUInt32());
                            continue;
                        case 152:
                            setSatsVisible(input.readUInt32());
                            continue;
                        case 160:
                            setHorPosError(input.readUInt32());
                            continue;
                        case 168:
                            setVertPosError(input.readUInt32());
                            continue;
                        case 176:
                            setNorthSpeed(input.readInt32());
                            continue;
                        case 184:
                            setEastSpeed(input.readInt32());
                            continue;
                        case 192:
                            setVertSpeed(input.readInt32());
                            continue;
                        case 200:
                            setTimeStamp(input.readUInt64());
                            continue;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public boolean hasAntennaState() {
                return this.result.hasAntennaState();
            }

            public int getAntennaState() {
                return this.result.getAntennaState();
            }

            public Builder setAntennaState(int value) {
                this.result.hasAntennaState = true;
                this.result.antennaState_ = value;
                return this;
            }

            public Builder clearAntennaState() {
                this.result.hasAntennaState = false;
                this.result.antennaState_ = 0;
                return this;
            }

            public boolean hasSignalQuality() {
                return this.result.hasSignalQuality();
            }

            public int getSignalQuality() {
                return this.result.getSignalQuality();
            }

            public Builder setSignalQuality(int value) {
                this.result.hasSignalQuality = true;
                this.result.signalQuality_ = value;
                return this;
            }

            public Builder clearSignalQuality() {
                this.result.hasSignalQuality = false;
                this.result.signalQuality_ = 0;
                return this;
            }

            public boolean hasLatitude() {
                return this.result.hasLatitude();
            }

            public int getLatitude() {
                return this.result.getLatitude();
            }

            public Builder setLatitude(int value) {
                this.result.hasLatitude = true;
                this.result.latitude_ = value;
                return this;
            }

            public Builder clearLatitude() {
                this.result.hasLatitude = false;
                this.result.latitude_ = 0;
                return this;
            }

            public boolean hasLongitude() {
                return this.result.hasLongitude();
            }

            public int getLongitude() {
                return this.result.getLongitude();
            }

            public Builder setLongitude(int value) {
                this.result.hasLongitude = true;
                this.result.longitude_ = value;
                return this;
            }

            public Builder clearLongitude() {
                this.result.hasLongitude = false;
                this.result.longitude_ = 0;
                return this;
            }

            public boolean hasHeight() {
                return this.result.hasHeight();
            }

            public int getHeight() {
                return this.result.getHeight();
            }

            public Builder setHeight(int value) {
                this.result.hasHeight = true;
                this.result.height_ = value;
                return this;
            }

            public Builder clearHeight() {
                this.result.hasHeight = false;
                this.result.height_ = 0;
                return this;
            }

            public boolean hasSpeed() {
                return this.result.hasSpeed();
            }

            public int getSpeed() {
                return this.result.getSpeed();
            }

            public Builder setSpeed(int value) {
                this.result.hasSpeed = true;
                this.result.speed_ = value;
                return this;
            }

            public Builder clearSpeed() {
                this.result.hasSpeed = false;
                this.result.speed_ = 0;
                return this;
            }

            public boolean hasHeading() {
                return this.result.hasHeading();
            }

            public int getHeading() {
                return this.result.getHeading();
            }

            public Builder setHeading(int value) {
                this.result.hasHeading = true;
                this.result.heading_ = value;
                return this;
            }

            public Builder clearHeading() {
                this.result.hasHeading = false;
                this.result.heading_ = 0;
                return this;
            }

            public boolean hasYear() {
                return this.result.hasYear();
            }

            public int getYear() {
                return this.result.getYear();
            }

            public Builder setYear(int value) {
                this.result.hasYear = true;
                this.result.year_ = value;
                return this;
            }

            public Builder clearYear() {
                this.result.hasYear = false;
                this.result.year_ = 0;
                return this;
            }

            public boolean hasMonth() {
                return this.result.hasMonth();
            }

            public int getMonth() {
                return this.result.getMonth();
            }

            public Builder setMonth(int value) {
                this.result.hasMonth = true;
                this.result.month_ = value;
                return this;
            }

            public Builder clearMonth() {
                this.result.hasMonth = false;
                this.result.month_ = 0;
                return this;
            }

            public boolean hasDay() {
                return this.result.hasDay();
            }

            public int getDay() {
                return this.result.getDay();
            }

            public Builder setDay(int value) {
                this.result.hasDay = true;
                this.result.day_ = value;
                return this;
            }

            public Builder clearDay() {
                this.result.hasDay = false;
                this.result.day_ = 0;
                return this;
            }

            public boolean hasHrs() {
                return this.result.hasHrs();
            }

            public int getHrs() {
                return this.result.getHrs();
            }

            public Builder setHrs(int value) {
                this.result.hasHrs = true;
                this.result.hrs_ = value;
                return this;
            }

            public Builder clearHrs() {
                this.result.hasHrs = false;
                this.result.hrs_ = 0;
                return this;
            }

            public boolean hasMin() {
                return this.result.hasMin();
            }

            public int getMin() {
                return this.result.getMin();
            }

            public Builder setMin(int value) {
                this.result.hasMin = true;
                this.result.min_ = value;
                return this;
            }

            public Builder clearMin() {
                this.result.hasMin = false;
                this.result.min_ = 0;
                return this;
            }

            public boolean hasSec() {
                return this.result.hasSec();
            }

            public int getSec() {
                return this.result.getSec();
            }

            public Builder setSec(int value) {
                this.result.hasSec = true;
                this.result.sec_ = value;
                return this;
            }

            public Builder clearSec() {
                this.result.hasSec = false;
                this.result.sec_ = 0;
                return this;
            }

            public boolean hasFix() {
                return this.result.hasFix();
            }

            public int getFix() {
                return this.result.getFix();
            }

            public Builder setFix(int value) {
                this.result.hasFix = true;
                this.result.fix_ = value;
                return this;
            }

            public Builder clearFix() {
                this.result.hasFix = false;
                this.result.fix_ = 0;
                return this;
            }

            public boolean hasHdop() {
                return this.result.hasHdop();
            }

            public int getHdop() {
                return this.result.getHdop();
            }

            public Builder setHdop(int value) {
                this.result.hasHdop = true;
                this.result.hdop_ = value;
                return this;
            }

            public Builder clearHdop() {
                this.result.hasHdop = false;
                this.result.hdop_ = 0;
                return this;
            }

            public boolean hasPdop() {
                return this.result.hasPdop();
            }

            public int getPdop() {
                return this.result.getPdop();
            }

            public Builder setPdop(int value) {
                this.result.hasPdop = true;
                this.result.pdop_ = value;
                return this;
            }

            public Builder clearPdop() {
                this.result.hasPdop = false;
                this.result.pdop_ = 0;
                return this;
            }

            public boolean hasVdop() {
                return this.result.hasVdop();
            }

            public int getVdop() {
                return this.result.getVdop();
            }

            public Builder setVdop(int value) {
                this.result.hasVdop = true;
                this.result.vdop_ = value;
                return this;
            }

            public Builder clearVdop() {
                this.result.hasVdop = false;
                this.result.vdop_ = 0;
                return this;
            }

            public boolean hasSatsUsed() {
                return this.result.hasSatsUsed();
            }

            public int getSatsUsed() {
                return this.result.getSatsUsed();
            }

            public Builder setSatsUsed(int value) {
                this.result.hasSatsUsed = true;
                this.result.satsUsed_ = value;
                return this;
            }

            public Builder clearSatsUsed() {
                this.result.hasSatsUsed = false;
                this.result.satsUsed_ = 0;
                return this;
            }

            public boolean hasSatsVisible() {
                return this.result.hasSatsVisible();
            }

            public int getSatsVisible() {
                return this.result.getSatsVisible();
            }

            public Builder setSatsVisible(int value) {
                this.result.hasSatsVisible = true;
                this.result.satsVisible_ = value;
                return this;
            }

            public Builder clearSatsVisible() {
                this.result.hasSatsVisible = false;
                this.result.satsVisible_ = 0;
                return this;
            }

            public boolean hasHorPosError() {
                return this.result.hasHorPosError();
            }

            public int getHorPosError() {
                return this.result.getHorPosError();
            }

            public Builder setHorPosError(int value) {
                this.result.hasHorPosError = true;
                this.result.horPosError_ = value;
                return this;
            }

            public Builder clearHorPosError() {
                this.result.hasHorPosError = false;
                this.result.horPosError_ = 0;
                return this;
            }

            public boolean hasVertPosError() {
                return this.result.hasVertPosError();
            }

            public int getVertPosError() {
                return this.result.getVertPosError();
            }

            public Builder setVertPosError(int value) {
                this.result.hasVertPosError = true;
                this.result.vertPosError_ = value;
                return this;
            }

            public Builder clearVertPosError() {
                this.result.hasVertPosError = false;
                this.result.vertPosError_ = 0;
                return this;
            }

            public boolean hasNorthSpeed() {
                return this.result.hasNorthSpeed();
            }

            public int getNorthSpeed() {
                return this.result.getNorthSpeed();
            }

            public Builder setNorthSpeed(int value) {
                this.result.hasNorthSpeed = true;
                this.result.northSpeed_ = value;
                return this;
            }

            public Builder clearNorthSpeed() {
                this.result.hasNorthSpeed = false;
                this.result.northSpeed_ = 0;
                return this;
            }

            public boolean hasEastSpeed() {
                return this.result.hasEastSpeed();
            }

            public int getEastSpeed() {
                return this.result.getEastSpeed();
            }

            public Builder setEastSpeed(int value) {
                this.result.hasEastSpeed = true;
                this.result.eastSpeed_ = value;
                return this;
            }

            public Builder clearEastSpeed() {
                this.result.hasEastSpeed = false;
                this.result.eastSpeed_ = 0;
                return this;
            }

            public boolean hasVertSpeed() {
                return this.result.hasVertSpeed();
            }

            public int getVertSpeed() {
                return this.result.getVertSpeed();
            }

            public Builder setVertSpeed(int value) {
                this.result.hasVertSpeed = true;
                this.result.vertSpeed_ = value;
                return this;
            }

            public Builder clearVertSpeed() {
                this.result.hasVertSpeed = false;
                this.result.vertSpeed_ = 0;
                return this;
            }

            public boolean hasTimeStamp() {
                return this.result.hasTimeStamp();
            }

            public long getTimeStamp() {
                return this.result.getTimeStamp();
            }

            public Builder setTimeStamp(long value) {
                this.result.hasTimeStamp = true;
                this.result.timeStamp_ = value;
                return this;
            }

            public Builder clearTimeStamp() {
                this.result.hasTimeStamp = false;
                this.result.timeStamp_ = 0;
                return this;
            }
        }

        private CarlifeCarGps() {
            this.antennaState_ = 0;
            this.signalQuality_ = 0;
            this.latitude_ = 0;
            this.longitude_ = 0;
            this.height_ = 0;
            this.speed_ = 0;
            this.heading_ = 0;
            this.year_ = 0;
            this.month_ = 0;
            this.day_ = 0;
            this.hrs_ = 0;
            this.min_ = 0;
            this.sec_ = 0;
            this.fix_ = 0;
            this.hdop_ = 0;
            this.pdop_ = 0;
            this.vdop_ = 0;
            this.satsUsed_ = 0;
            this.satsVisible_ = 0;
            this.horPosError_ = 0;
            this.vertPosError_ = 0;
            this.northSpeed_ = 0;
            this.eastSpeed_ = 0;
            this.vertSpeed_ = 0;
            this.timeStamp_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeCarGpsProto.getDescriptor();
            CarlifeCarGpsProto.internalForceInit();
        }

        public static CarlifeCarGps getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeCarGps getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeCarGpsProto.f6603x6978e65c;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeCarGpsProto.f6604x5939f0da;
        }

        public boolean hasAntennaState() {
            return this.hasAntennaState;
        }

        public int getAntennaState() {
            return this.antennaState_;
        }

        public boolean hasSignalQuality() {
            return this.hasSignalQuality;
        }

        public int getSignalQuality() {
            return this.signalQuality_;
        }

        public boolean hasLatitude() {
            return this.hasLatitude;
        }

        public int getLatitude() {
            return this.latitude_;
        }

        public boolean hasLongitude() {
            return this.hasLongitude;
        }

        public int getLongitude() {
            return this.longitude_;
        }

        public boolean hasHeight() {
            return this.hasHeight;
        }

        public int getHeight() {
            return this.height_;
        }

        public boolean hasSpeed() {
            return this.hasSpeed;
        }

        public int getSpeed() {
            return this.speed_;
        }

        public boolean hasHeading() {
            return this.hasHeading;
        }

        public int getHeading() {
            return this.heading_;
        }

        public boolean hasYear() {
            return this.hasYear;
        }

        public int getYear() {
            return this.year_;
        }

        public boolean hasMonth() {
            return this.hasMonth;
        }

        public int getMonth() {
            return this.month_;
        }

        public boolean hasDay() {
            return this.hasDay;
        }

        public int getDay() {
            return this.day_;
        }

        public boolean hasHrs() {
            return this.hasHrs;
        }

        public int getHrs() {
            return this.hrs_;
        }

        public boolean hasMin() {
            return this.hasMin;
        }

        public int getMin() {
            return this.min_;
        }

        public boolean hasSec() {
            return this.hasSec;
        }

        public int getSec() {
            return this.sec_;
        }

        public boolean hasFix() {
            return this.hasFix;
        }

        public int getFix() {
            return this.fix_;
        }

        public boolean hasHdop() {
            return this.hasHdop;
        }

        public int getHdop() {
            return this.hdop_;
        }

        public boolean hasPdop() {
            return this.hasPdop;
        }

        public int getPdop() {
            return this.pdop_;
        }

        public boolean hasVdop() {
            return this.hasVdop;
        }

        public int getVdop() {
            return this.vdop_;
        }

        public boolean hasSatsUsed() {
            return this.hasSatsUsed;
        }

        public int getSatsUsed() {
            return this.satsUsed_;
        }

        public boolean hasSatsVisible() {
            return this.hasSatsVisible;
        }

        public int getSatsVisible() {
            return this.satsVisible_;
        }

        public boolean hasHorPosError() {
            return this.hasHorPosError;
        }

        public int getHorPosError() {
            return this.horPosError_;
        }

        public boolean hasVertPosError() {
            return this.hasVertPosError;
        }

        public int getVertPosError() {
            return this.vertPosError_;
        }

        public boolean hasNorthSpeed() {
            return this.hasNorthSpeed;
        }

        public int getNorthSpeed() {
            return this.northSpeed_;
        }

        public boolean hasEastSpeed() {
            return this.hasEastSpeed;
        }

        public int getEastSpeed() {
            return this.eastSpeed_;
        }

        public boolean hasVertSpeed() {
            return this.hasVertSpeed;
        }

        public int getVertSpeed() {
            return this.vertSpeed_;
        }

        public boolean hasTimeStamp() {
            return this.hasTimeStamp;
        }

        public long getTimeStamp() {
            return this.timeStamp_;
        }

        public final boolean isInitialized() {
            if (this.hasAntennaState && this.hasSignalQuality && this.hasLatitude && this.hasLongitude && this.hasHeight && this.hasSpeed && this.hasHeading && this.hasYear && this.hasMonth && this.hasDay && this.hasHrs && this.hasMin && this.hasSec && this.hasFix && this.hasHdop && this.hasPdop && this.hasVdop && this.hasSatsUsed && this.hasSatsVisible && this.hasHorPosError && this.hasVertPosError && this.hasNorthSpeed && this.hasEastSpeed && this.hasVertSpeed) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAntennaState()) {
                output.writeUInt32(1, getAntennaState());
            }
            if (hasSignalQuality()) {
                output.writeUInt32(2, getSignalQuality());
            }
            if (hasLatitude()) {
                output.writeInt32(3, getLatitude());
            }
            if (hasLongitude()) {
                output.writeInt32(4, getLongitude());
            }
            if (hasHeight()) {
                output.writeInt32(5, getHeight());
            }
            if (hasSpeed()) {
                output.writeUInt32(6, getSpeed());
            }
            if (hasHeading()) {
                output.writeUInt32(7, getHeading());
            }
            if (hasYear()) {
                output.writeUInt32(8, getYear());
            }
            if (hasMonth()) {
                output.writeUInt32(9, getMonth());
            }
            if (hasDay()) {
                output.writeUInt32(10, getDay());
            }
            if (hasHrs()) {
                output.writeUInt32(11, getHrs());
            }
            if (hasMin()) {
                output.writeUInt32(12, getMin());
            }
            if (hasSec()) {
                output.writeUInt32(13, getSec());
            }
            if (hasFix()) {
                output.writeUInt32(14, getFix());
            }
            if (hasHdop()) {
                output.writeUInt32(15, getHdop());
            }
            if (hasPdop()) {
                output.writeUInt32(16, getPdop());
            }
            if (hasVdop()) {
                output.writeUInt32(17, getVdop());
            }
            if (hasSatsUsed()) {
                output.writeUInt32(18, getSatsUsed());
            }
            if (hasSatsVisible()) {
                output.writeUInt32(19, getSatsVisible());
            }
            if (hasHorPosError()) {
                output.writeUInt32(20, getHorPosError());
            }
            if (hasVertPosError()) {
                output.writeUInt32(21, getVertPosError());
            }
            if (hasNorthSpeed()) {
                output.writeInt32(22, getNorthSpeed());
            }
            if (hasEastSpeed()) {
                output.writeInt32(23, getEastSpeed());
            }
            if (hasVertSpeed()) {
                output.writeInt32(24, getVertSpeed());
            }
            if (hasTimeStamp()) {
                output.writeUInt64(25, getTimeStamp());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAntennaState()) {
                size = 0 + CodedOutputStream.computeUInt32Size(1, getAntennaState());
            }
            if (hasSignalQuality()) {
                size += CodedOutputStream.computeUInt32Size(2, getSignalQuality());
            }
            if (hasLatitude()) {
                size += CodedOutputStream.computeInt32Size(3, getLatitude());
            }
            if (hasLongitude()) {
                size += CodedOutputStream.computeInt32Size(4, getLongitude());
            }
            if (hasHeight()) {
                size += CodedOutputStream.computeInt32Size(5, getHeight());
            }
            if (hasSpeed()) {
                size += CodedOutputStream.computeUInt32Size(6, getSpeed());
            }
            if (hasHeading()) {
                size += CodedOutputStream.computeUInt32Size(7, getHeading());
            }
            if (hasYear()) {
                size += CodedOutputStream.computeUInt32Size(8, getYear());
            }
            if (hasMonth()) {
                size += CodedOutputStream.computeUInt32Size(9, getMonth());
            }
            if (hasDay()) {
                size += CodedOutputStream.computeUInt32Size(10, getDay());
            }
            if (hasHrs()) {
                size += CodedOutputStream.computeUInt32Size(11, getHrs());
            }
            if (hasMin()) {
                size += CodedOutputStream.computeUInt32Size(12, getMin());
            }
            if (hasSec()) {
                size += CodedOutputStream.computeUInt32Size(13, getSec());
            }
            if (hasFix()) {
                size += CodedOutputStream.computeUInt32Size(14, getFix());
            }
            if (hasHdop()) {
                size += CodedOutputStream.computeUInt32Size(15, getHdop());
            }
            if (hasPdop()) {
                size += CodedOutputStream.computeUInt32Size(16, getPdop());
            }
            if (hasVdop()) {
                size += CodedOutputStream.computeUInt32Size(17, getVdop());
            }
            if (hasSatsUsed()) {
                size += CodedOutputStream.computeUInt32Size(18, getSatsUsed());
            }
            if (hasSatsVisible()) {
                size += CodedOutputStream.computeUInt32Size(19, getSatsVisible());
            }
            if (hasHorPosError()) {
                size += CodedOutputStream.computeUInt32Size(20, getHorPosError());
            }
            if (hasVertPosError()) {
                size += CodedOutputStream.computeUInt32Size(21, getVertPosError());
            }
            if (hasNorthSpeed()) {
                size += CodedOutputStream.computeInt32Size(22, getNorthSpeed());
            }
            if (hasEastSpeed()) {
                size += CodedOutputStream.computeInt32Size(23, getEastSpeed());
            }
            if (hasVertSpeed()) {
                size += CodedOutputStream.computeInt32Size(24, getVertSpeed());
            }
            if (hasTimeStamp()) {
                size += CodedOutputStream.computeUInt64Size(25, getTimeStamp());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeCarGps parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarGps parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeCarGps parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeCarGps parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeCarGps prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeCarGpsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018CarlifeCarGpsProto.proto\u0012\u001acom.baidu.carlife.protobuf\"¸\u0003\n\rCarlifeCarGps\u0012\u0014\n\fantennaState\u0018\u0001 \u0002(\r\u0012\u0015\n\rsignalQuality\u0018\u0002 \u0002(\r\u0012\u0010\n\blatitude\u0018\u0003 \u0002(\u0005\u0012\u0011\n\tlongitude\u0018\u0004 \u0002(\u0005\u0012\u000e\n\u0006height\u0018\u0005 \u0002(\u0005\u0012\r\n\u0005speed\u0018\u0006 \u0002(\r\u0012\u000f\n\u0007heading\u0018\u0007 \u0002(\r\u0012\f\n\u0004year\u0018\b \u0002(\r\u0012\r\n\u0005month\u0018\t \u0002(\r\u0012\u000b\n\u0003day\u0018\n \u0002(\r\u0012\u000b\n\u0003hrs\u0018\u000b \u0002(\r\u0012\u000b\n\u0003min\u0018\f \u0002(\r\u0012\u000b\n\u0003sec\u0018\r \u0002(\r\u0012\u000b\n\u0003fix\u0018\u000e \u0002(\r\u0012\f\n\u0004hdop\u0018\u000f \u0002(\r\u0012\f\n\u0004pdop\u0018\u0010 \u0002(\r\u0012\f\n\u0004vdop\u0018\u0011 \u0002(\r\u0012\u0010\n\bsatsUsed\u0018\u0012 \u0002(\r\u0012\u0013\n\u000bsatsVisible\u0018\u0013 \u0002(\r\u0012\u0013\n\u000bhorPosError\u0018\u0014 \u0002(\r\u0012\u0014", "\n\fvertPosError\u0018\u0015 \u0002(\r\u0012\u0012\n\nnorthSpeed\u0018\u0016 \u0002(\u0005\u0012\u0011\n\teastSpeed\u0018\u0017 \u0002(\u0005\u0012\u0011\n\tvertSpeed\u0018\u0018 \u0002(\u0005\u0012\u0011\n\ttimeStamp\u0018\u0019 \u0001(\u0004"}, new FileDescriptor[0], new C20541());
    }

    public static void internalForceInit() {
    }
}
