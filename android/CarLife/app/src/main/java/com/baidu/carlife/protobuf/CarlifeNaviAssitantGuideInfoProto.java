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

public final class CarlifeNaviAssitantGuideInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_descriptor */
    private static Descriptor f6639xe1fb57a1;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeNaviAssitantGuideInfo_fieldAccessorTable */
    private static FieldAccessorTable f6640x5b2d4d1f;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeNaviAssitantGuideInfoProto$1 */
    static class C20741 implements InternalDescriptorAssigner {
        C20741() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeNaviAssitantGuideInfoProto.descriptor = root;
            CarlifeNaviAssitantGuideInfoProto.f6639xe1fb57a1 = (Descriptor) CarlifeNaviAssitantGuideInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeNaviAssitantGuideInfoProto.f6640x5b2d4d1f = new FieldAccessorTable(CarlifeNaviAssitantGuideInfoProto.f6639xe1fb57a1, new String[]{"Action", "AssistantType", "TrafficSignType", "TotalDistance", "RemainDistance", "CameraSpeed"}, CarlifeNaviAssitantGuideInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeNaviAssitantGuideInfo extends GeneratedMessage {
        public static final int ACTION_FIELD_NUMBER = 1;
        public static final int ASSISTANTTYPE_FIELD_NUMBER = 2;
        public static final int CAMERASPEED_FIELD_NUMBER = 6;
        public static final int REMAINDISTANCE_FIELD_NUMBER = 5;
        public static final int TOTALDISTANCE_FIELD_NUMBER = 4;
        public static final int TRAFFICSIGNTYPE_FIELD_NUMBER = 3;
        private static final CarlifeNaviAssitantGuideInfo defaultInstance = new CarlifeNaviAssitantGuideInfo();
        private int action_;
        private int assistantType_;
        private int cameraSpeed_;
        private boolean hasAction;
        private boolean hasAssistantType;
        private boolean hasCameraSpeed;
        private boolean hasRemainDistance;
        private boolean hasTotalDistance;
        private boolean hasTrafficSignType;
        private int memoizedSerializedSize;
        private int remainDistance_;
        private int totalDistance_;
        private int trafficSignType_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeNaviAssitantGuideInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeNaviAssitantGuideInfo();
                return builder;
            }

            protected CarlifeNaviAssitantGuideInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeNaviAssitantGuideInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeNaviAssitantGuideInfo.getDescriptor();
            }

            public CarlifeNaviAssitantGuideInfo getDefaultInstanceForType() {
                return CarlifeNaviAssitantGuideInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeNaviAssitantGuideInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeNaviAssitantGuideInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeNaviAssitantGuideInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeNaviAssitantGuideInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeNaviAssitantGuideInfo) {
                    return mergeFrom((CarlifeNaviAssitantGuideInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeNaviAssitantGuideInfo other) {
                if (other != CarlifeNaviAssitantGuideInfo.getDefaultInstance()) {
                    if (other.hasAction()) {
                        setAction(other.getAction());
                    }
                    if (other.hasAssistantType()) {
                        setAssistantType(other.getAssistantType());
                    }
                    if (other.hasTrafficSignType()) {
                        setTrafficSignType(other.getTrafficSignType());
                    }
                    if (other.hasTotalDistance()) {
                        setTotalDistance(other.getTotalDistance());
                    }
                    if (other.hasRemainDistance()) {
                        setRemainDistance(other.getRemainDistance());
                    }
                    if (other.hasCameraSpeed()) {
                        setCameraSpeed(other.getCameraSpeed());
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
                            setAssistantType(input.readInt32());
                            continue;
                        case 24:
                            setTrafficSignType(input.readInt32());
                            continue;
                        case 32:
                            setTotalDistance(input.readInt32());
                            continue;
                        case 40:
                            setRemainDistance(input.readInt32());
                            continue;
                        case 48:
                            setCameraSpeed(input.readInt32());
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

            public boolean hasAssistantType() {
                return this.result.hasAssistantType();
            }

            public int getAssistantType() {
                return this.result.getAssistantType();
            }

            public Builder setAssistantType(int value) {
                this.result.hasAssistantType = true;
                this.result.assistantType_ = value;
                return this;
            }

            public Builder clearAssistantType() {
                this.result.hasAssistantType = false;
                this.result.assistantType_ = 0;
                return this;
            }

            public boolean hasTrafficSignType() {
                return this.result.hasTrafficSignType();
            }

            public int getTrafficSignType() {
                return this.result.getTrafficSignType();
            }

            public Builder setTrafficSignType(int value) {
                this.result.hasTrafficSignType = true;
                this.result.trafficSignType_ = value;
                return this;
            }

            public Builder clearTrafficSignType() {
                this.result.hasTrafficSignType = false;
                this.result.trafficSignType_ = 0;
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

            public boolean hasCameraSpeed() {
                return this.result.hasCameraSpeed();
            }

            public int getCameraSpeed() {
                return this.result.getCameraSpeed();
            }

            public Builder setCameraSpeed(int value) {
                this.result.hasCameraSpeed = true;
                this.result.cameraSpeed_ = value;
                return this;
            }

            public Builder clearCameraSpeed() {
                this.result.hasCameraSpeed = false;
                this.result.cameraSpeed_ = 0;
                return this;
            }
        }

        private CarlifeNaviAssitantGuideInfo() {
            this.action_ = 0;
            this.assistantType_ = 0;
            this.trafficSignType_ = 0;
            this.totalDistance_ = 0;
            this.remainDistance_ = 0;
            this.cameraSpeed_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeNaviAssitantGuideInfoProto.getDescriptor();
            CarlifeNaviAssitantGuideInfoProto.internalForceInit();
        }

        public static CarlifeNaviAssitantGuideInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeNaviAssitantGuideInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeNaviAssitantGuideInfoProto.f6639xe1fb57a1;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeNaviAssitantGuideInfoProto.f6640x5b2d4d1f;
        }

        public boolean hasAction() {
            return this.hasAction;
        }

        public int getAction() {
            return this.action_;
        }

        public boolean hasAssistantType() {
            return this.hasAssistantType;
        }

        public int getAssistantType() {
            return this.assistantType_;
        }

        public boolean hasTrafficSignType() {
            return this.hasTrafficSignType;
        }

        public int getTrafficSignType() {
            return this.trafficSignType_;
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

        public boolean hasCameraSpeed() {
            return this.hasCameraSpeed;
        }

        public int getCameraSpeed() {
            return this.cameraSpeed_;
        }

        public final boolean isInitialized() {
            if (this.hasAction && this.hasAssistantType && this.hasTrafficSignType && this.hasTotalDistance && this.hasRemainDistance && this.hasCameraSpeed) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAction()) {
                output.writeInt32(1, getAction());
            }
            if (hasAssistantType()) {
                output.writeInt32(2, getAssistantType());
            }
            if (hasTrafficSignType()) {
                output.writeInt32(3, getTrafficSignType());
            }
            if (hasTotalDistance()) {
                output.writeInt32(4, getTotalDistance());
            }
            if (hasRemainDistance()) {
                output.writeInt32(5, getRemainDistance());
            }
            if (hasCameraSpeed()) {
                output.writeInt32(6, getCameraSpeed());
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
            if (hasAssistantType()) {
                size += CodedOutputStream.computeInt32Size(2, getAssistantType());
            }
            if (hasTrafficSignType()) {
                size += CodedOutputStream.computeInt32Size(3, getTrafficSignType());
            }
            if (hasTotalDistance()) {
                size += CodedOutputStream.computeInt32Size(4, getTotalDistance());
            }
            if (hasRemainDistance()) {
                size += CodedOutputStream.computeInt32Size(5, getRemainDistance());
            }
            if (hasCameraSpeed()) {
                size += CodedOutputStream.computeInt32Size(6, getCameraSpeed());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeNaviAssitantGuideInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeNaviAssitantGuideInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeNaviAssitantGuideInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'CarlifeNaviAssitantGuideInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"¢\u0001\n\u001cCarlifeNaviAssitantGuideInfo\u0012\u000e\n\u0006action\u0018\u0001 \u0002(\u0005\u0012\u0015\n\rassistantType\u0018\u0002 \u0002(\u0005\u0012\u0017\n\u000ftrafficSignType\u0018\u0003 \u0002(\u0005\u0012\u0015\n\rtotalDistance\u0018\u0004 \u0002(\u0005\u0012\u0016\n\u000eremainDistance\u0018\u0005 \u0002(\u0005\u0012\u0013\n\u000bcameraSpeed\u0018\u0006 \u0002(\u0005"}, new FileDescriptor[0], new C20741());
    }

    public static void internalForceInit() {
    }
}
