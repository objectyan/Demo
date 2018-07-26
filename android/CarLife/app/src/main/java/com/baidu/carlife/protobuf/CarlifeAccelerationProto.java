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

public final class CarlifeAccelerationProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_descriptor */
    private static Descriptor f6575x6814f4d2;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_fieldAccessorTable */
    private static FieldAccessorTable f6576x11732950;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeAccelerationProto$1 */
    static class C20401 implements InternalDescriptorAssigner {
        C20401() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeAccelerationProto.descriptor = root;
            CarlifeAccelerationProto.f6575x6814f4d2 = (Descriptor) CarlifeAccelerationProto.getDescriptor().getMessageTypes().get(0);
            CarlifeAccelerationProto.f6576x11732950 = new FieldAccessorTable(CarlifeAccelerationProto.f6575x6814f4d2, new String[]{"AccX", "AccY", "AccZ", "TimeStamp"}, CarlifeAcceleration.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeAcceleration extends GeneratedMessage {
        public static final int ACCX_FIELD_NUMBER = 1;
        public static final int ACCY_FIELD_NUMBER = 2;
        public static final int ACCZ_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        private static final CarlifeAcceleration defaultInstance = new CarlifeAcceleration();
        private double accX_;
        private double accY_;
        private double accZ_;
        private boolean hasAccX;
        private boolean hasAccY;
        private boolean hasAccZ;
        private boolean hasTimeStamp;
        private int memoizedSerializedSize;
        private long timeStamp_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeAcceleration result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeAcceleration();
                return builder;
            }

            protected CarlifeAcceleration internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeAcceleration();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeAcceleration.getDescriptor();
            }

            public CarlifeAcceleration getDefaultInstanceForType() {
                return CarlifeAcceleration.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeAcceleration build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeAcceleration buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeAcceleration buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeAcceleration returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeAcceleration) {
                    return mergeFrom((CarlifeAcceleration) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeAcceleration other) {
                if (other != CarlifeAcceleration.getDefaultInstance()) {
                    if (other.hasAccX()) {
                        setAccX(other.getAccX());
                    }
                    if (other.hasAccY()) {
                        setAccY(other.getAccY());
                    }
                    if (other.hasAccZ()) {
                        setAccZ(other.getAccZ());
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
                        case 9:
                            setAccX(input.readDouble());
                            continue;
                        case 17:
                            setAccY(input.readDouble());
                            continue;
                        case 25:
                            setAccZ(input.readDouble());
                            continue;
                        case 32:
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

            public boolean hasAccX() {
                return this.result.hasAccX();
            }

            public double getAccX() {
                return this.result.getAccX();
            }

            public Builder setAccX(double value) {
                this.result.hasAccX = true;
                this.result.accX_ = value;
                return this;
            }

            public Builder clearAccX() {
                this.result.hasAccX = false;
                this.result.accX_ = 0.0d;
                return this;
            }

            public boolean hasAccY() {
                return this.result.hasAccY();
            }

            public double getAccY() {
                return this.result.getAccY();
            }

            public Builder setAccY(double value) {
                this.result.hasAccY = true;
                this.result.accY_ = value;
                return this;
            }

            public Builder clearAccY() {
                this.result.hasAccY = false;
                this.result.accY_ = 0.0d;
                return this;
            }

            public boolean hasAccZ() {
                return this.result.hasAccZ();
            }

            public double getAccZ() {
                return this.result.getAccZ();
            }

            public Builder setAccZ(double value) {
                this.result.hasAccZ = true;
                this.result.accZ_ = value;
                return this;
            }

            public Builder clearAccZ() {
                this.result.hasAccZ = false;
                this.result.accZ_ = 0.0d;
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

        private CarlifeAcceleration() {
            this.accX_ = 0.0d;
            this.accY_ = 0.0d;
            this.accZ_ = 0.0d;
            this.timeStamp_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeAccelerationProto.getDescriptor();
            CarlifeAccelerationProto.internalForceInit();
        }

        public static CarlifeAcceleration getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeAcceleration getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeAccelerationProto.f6575x6814f4d2;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeAccelerationProto.f6576x11732950;
        }

        public boolean hasAccX() {
            return this.hasAccX;
        }

        public double getAccX() {
            return this.accX_;
        }

        public boolean hasAccY() {
            return this.hasAccY;
        }

        public double getAccY() {
            return this.accY_;
        }

        public boolean hasAccZ() {
            return this.hasAccZ;
        }

        public double getAccZ() {
            return this.accZ_;
        }

        public boolean hasTimeStamp() {
            return this.hasTimeStamp;
        }

        public long getTimeStamp() {
            return this.timeStamp_;
        }

        public final boolean isInitialized() {
            if (this.hasAccX && this.hasAccY && this.hasAccZ) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAccX()) {
                output.writeDouble(1, getAccX());
            }
            if (hasAccY()) {
                output.writeDouble(2, getAccY());
            }
            if (hasAccZ()) {
                output.writeDouble(3, getAccZ());
            }
            if (hasTimeStamp()) {
                output.writeUInt64(4, getTimeStamp());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAccX()) {
                size = 0 + CodedOutputStream.computeDoubleSize(1, getAccX());
            }
            if (hasAccY()) {
                size += CodedOutputStream.computeDoubleSize(2, getAccY());
            }
            if (hasAccZ()) {
                size += CodedOutputStream.computeDoubleSize(3, getAccZ());
            }
            if (hasTimeStamp()) {
                size += CodedOutputStream.computeUInt64Size(4, getTimeStamp());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeAcceleration parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAcceleration parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeAcceleration parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAcceleration parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeAcceleration prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeAccelerationProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eCarlifeAccelerationProto.proto\u0012\u001acom.baidu.carlife.protobuf\"R\n\u0013CarlifeAcceleration\u0012\f\n\u0004accX\u0018\u0001 \u0002(\u0001\u0012\f\n\u0004accY\u0018\u0002 \u0002(\u0001\u0012\f\n\u0004accZ\u0018\u0003 \u0002(\u0001\u0012\u0011\n\ttimeStamp\u0018\u0004 \u0001(\u0004"}, new FileDescriptor[0], new C20401());
    }

    public static void internalForceInit() {
    }
}
