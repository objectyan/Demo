package com.baidu.carlife.protobuf;

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

public final class CarlifeNaviNextTurnInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_descriptor */
    private static Descriptor f6641x3d72832e;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeNaviNextTurnInfo_fieldAccessorTable */
    private static FieldAccessorTable f6642x77fa9bac;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeNaviNextTurnInfoProto$1 */
    static class C20751 implements InternalDescriptorAssigner {
        C20751() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeNaviNextTurnInfoProto.descriptor = root;
            CarlifeNaviNextTurnInfoProto.f6641x3d72832e = (Descriptor) CarlifeNaviNextTurnInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeNaviNextTurnInfoProto.f6642x77fa9bac = new FieldAccessorTable(CarlifeNaviNextTurnInfoProto.f6641x3d72832e, new String[]{"Action", "NextTurn", "RoadName", "TotalDistance", "RemainDistance", "TurnIconData"}, CarlifeNaviNextTurnInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeNaviNextTurnInfo extends GeneratedMessage {
        public static final int ACTION_FIELD_NUMBER = 1;
        public static final int NEXTTURN_FIELD_NUMBER = 2;
        public static final int REMAINDISTANCE_FIELD_NUMBER = 5;
        public static final int ROADNAME_FIELD_NUMBER = 3;
        public static final int TOTALDISTANCE_FIELD_NUMBER = 4;
        public static final int TURNICONDATA_FIELD_NUMBER = 6;
        private static final CarlifeNaviNextTurnInfo defaultInstance = new CarlifeNaviNextTurnInfo();
        private int action_;
        private boolean hasAction;
        private boolean hasNextTurn;
        private boolean hasRemainDistance;
        private boolean hasRoadName;
        private boolean hasTotalDistance;
        private boolean hasTurnIconData;
        private int memoizedSerializedSize;
        private int nextTurn_;
        private int remainDistance_;
        private String roadName_;
        private int totalDistance_;
        private ByteString turnIconData_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeNaviNextTurnInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeNaviNextTurnInfo();
                return builder;
            }

            protected CarlifeNaviNextTurnInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeNaviNextTurnInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeNaviNextTurnInfo.getDescriptor();
            }

            public CarlifeNaviNextTurnInfo getDefaultInstanceForType() {
                return CarlifeNaviNextTurnInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeNaviNextTurnInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeNaviNextTurnInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeNaviNextTurnInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeNaviNextTurnInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeNaviNextTurnInfo) {
                    return mergeFrom((CarlifeNaviNextTurnInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeNaviNextTurnInfo other) {
                if (other != CarlifeNaviNextTurnInfo.getDefaultInstance()) {
                    if (other.hasAction()) {
                        setAction(other.getAction());
                    }
                    if (other.hasNextTurn()) {
                        setNextTurn(other.getNextTurn());
                    }
                    if (other.hasRoadName()) {
                        setRoadName(other.getRoadName());
                    }
                    if (other.hasTotalDistance()) {
                        setTotalDistance(other.getTotalDistance());
                    }
                    if (other.hasRemainDistance()) {
                        setRemainDistance(other.getRemainDistance());
                    }
                    if (other.hasTurnIconData()) {
                        setTurnIconData(other.getTurnIconData());
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
                            setAction(input.readInt32());
                            continue;
                        case 16:
                            setNextTurn(input.readInt32());
                            continue;
                        case 26:
                            setRoadName(input.readString());
                            continue;
                        case 32:
                            setTotalDistance(input.readInt32());
                            continue;
                        case 40:
                            setRemainDistance(input.readInt32());
                            continue;
                        case 50:
                            setTurnIconData(input.readBytes());
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

            public boolean hasAction() {
                return this.result.hasAction();
            }

            public int getAction() {
                return this.result.getAction();
            }

            public Builder setAction(int value) {
                this.result.hasAction = true;
                this.result.action_ = value;
                return this;
            }

            public Builder clearAction() {
                this.result.hasAction = false;
                this.result.action_ = 0;
                return this;
            }

            public boolean hasNextTurn() {
                return this.result.hasNextTurn();
            }

            public int getNextTurn() {
                return this.result.getNextTurn();
            }

            public Builder setNextTurn(int value) {
                this.result.hasNextTurn = true;
                this.result.nextTurn_ = value;
                return this;
            }

            public Builder clearNextTurn() {
                this.result.hasNextTurn = false;
                this.result.nextTurn_ = 0;
                return this;
            }

            public boolean hasRoadName() {
                return this.result.hasRoadName();
            }

            public String getRoadName() {
                return this.result.getRoadName();
            }

            public Builder setRoadName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasRoadName = true;
                this.result.roadName_ = value;
                return this;
            }

            public Builder clearRoadName() {
                this.result.hasRoadName = false;
                this.result.roadName_ = CarlifeNaviNextTurnInfo.getDefaultInstance().getRoadName();
                return this;
            }

            public boolean hasTotalDistance() {
                return this.result.hasTotalDistance();
            }

            public int getTotalDistance() {
                return this.result.getTotalDistance();
            }

            public Builder setTotalDistance(int value) {
                this.result.hasTotalDistance = true;
                this.result.totalDistance_ = value;
                return this;
            }

            public Builder clearTotalDistance() {
                this.result.hasTotalDistance = false;
                this.result.totalDistance_ = 0;
                return this;
            }

            public boolean hasRemainDistance() {
                return this.result.hasRemainDistance();
            }

            public int getRemainDistance() {
                return this.result.getRemainDistance();
            }

            public Builder setRemainDistance(int value) {
                this.result.hasRemainDistance = true;
                this.result.remainDistance_ = value;
                return this;
            }

            public Builder clearRemainDistance() {
                this.result.hasRemainDistance = false;
                this.result.remainDistance_ = 0;
                return this;
            }

            public boolean hasTurnIconData() {
                return this.result.hasTurnIconData();
            }

            public ByteString getTurnIconData() {
                return this.result.getTurnIconData();
            }

            public Builder setTurnIconData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasTurnIconData = true;
                this.result.turnIconData_ = value;
                return this;
            }

            public Builder clearTurnIconData() {
                this.result.hasTurnIconData = false;
                this.result.turnIconData_ = CarlifeNaviNextTurnInfo.getDefaultInstance().getTurnIconData();
                return this;
            }
        }

        private CarlifeNaviNextTurnInfo() {
            this.action_ = 0;
            this.nextTurn_ = 0;
            this.roadName_ = "";
            this.totalDistance_ = 0;
            this.remainDistance_ = 0;
            this.turnIconData_ = ByteString.EMPTY;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeNaviNextTurnInfoProto.getDescriptor();
            CarlifeNaviNextTurnInfoProto.internalForceInit();
        }

        public static CarlifeNaviNextTurnInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeNaviNextTurnInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeNaviNextTurnInfoProto.f6641x3d72832e;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeNaviNextTurnInfoProto.f6642x77fa9bac;
        }

        public boolean hasAction() {
            return this.hasAction;
        }

        public int getAction() {
            return this.action_;
        }

        public boolean hasNextTurn() {
            return this.hasNextTurn;
        }

        public int getNextTurn() {
            return this.nextTurn_;
        }

        public boolean hasRoadName() {
            return this.hasRoadName;
        }

        public String getRoadName() {
            return this.roadName_;
        }

        public boolean hasTotalDistance() {
            return this.hasTotalDistance;
        }

        public int getTotalDistance() {
            return this.totalDistance_;
        }

        public boolean hasRemainDistance() {
            return this.hasRemainDistance;
        }

        public int getRemainDistance() {
            return this.remainDistance_;
        }

        public boolean hasTurnIconData() {
            return this.hasTurnIconData;
        }

        public ByteString getTurnIconData() {
            return this.turnIconData_;
        }

        public final boolean isInitialized() {
            if (this.hasAction && this.hasNextTurn && this.hasRoadName && this.hasTotalDistance && this.hasRemainDistance && this.hasTurnIconData) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAction()) {
                output.writeInt32(1, getAction());
            }
            if (hasNextTurn()) {
                output.writeInt32(2, getNextTurn());
            }
            if (hasRoadName()) {
                output.writeString(3, getRoadName());
            }
            if (hasTotalDistance()) {
                output.writeInt32(4, getTotalDistance());
            }
            if (hasRemainDistance()) {
                output.writeInt32(5, getRemainDistance());
            }
            if (hasTurnIconData()) {
                output.writeBytes(6, getTurnIconData());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAction()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getAction());
            }
            if (hasNextTurn()) {
                size += CodedOutputStream.computeInt32Size(2, getNextTurn());
            }
            if (hasRoadName()) {
                size += CodedOutputStream.computeStringSize(3, getRoadName());
            }
            if (hasTotalDistance()) {
                size += CodedOutputStream.computeInt32Size(4, getTotalDistance());
            }
            if (hasRemainDistance()) {
                size += CodedOutputStream.computeInt32Size(5, getRemainDistance());
            }
            if (hasTurnIconData()) {
                size += CodedOutputStream.computeBytesSize(6, getTurnIconData());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeNaviNextTurnInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeNaviNextTurnInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeNaviNextTurnInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeNaviNextTurnInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeNaviNextTurnInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"\u0001\n\u0017CarlifeNaviNextTurnInfo\u0012\u000e\n\u0006action\u0018\u0001 \u0002(\u0005\u0012\u0010\n\bnextTurn\u0018\u0002 \u0002(\u0005\u0012\u0010\n\broadName\u0018\u0003 \u0002(\t\u0012\u0015\n\rtotalDistance\u0018\u0004 \u0002(\u0005\u0012\u0016\n\u000eremainDistance\u0018\u0005 \u0002(\u0005\u0012\u0014\n\fturnIconData\u0018\u0006 \u0002(\f"}, new FileDescriptor[0], new C20751());
    }

    public static void internalForceInit() {
    }
}
