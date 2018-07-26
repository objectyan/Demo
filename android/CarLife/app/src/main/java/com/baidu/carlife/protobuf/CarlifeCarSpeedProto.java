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

public final class CarlifeCarSpeedProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_descriptor */
    private static Descriptor f6607x46ca549f;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_fieldAccessorTable */
    private static FieldAccessorTable f6608x8b266c1d;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeCarSpeedProto$1 */
    static class C20561 implements InternalDescriptorAssigner {
        C20561() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeCarSpeedProto.descriptor = root;
            CarlifeCarSpeedProto.f6607x46ca549f = (Descriptor) CarlifeCarSpeedProto.getDescriptor().getMessageTypes().get(0);
            CarlifeCarSpeedProto.f6608x8b266c1d = new FieldAccessorTable(CarlifeCarSpeedProto.f6607x46ca549f, new String[]{"Speed", "TimeStamp"}, CarlifeCarSpeed.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeCarSpeed extends GeneratedMessage {
        public static final int SPEED_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        private static final CarlifeCarSpeed defaultInstance = new CarlifeCarSpeed();
        private boolean hasSpeed;
        private boolean hasTimeStamp;
        private int memoizedSerializedSize;
        private int speed_;
        private long timeStamp_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeCarSpeed result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeCarSpeed();
                return builder;
            }

            protected CarlifeCarSpeed internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeCarSpeed();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeCarSpeed.getDescriptor();
            }

            public CarlifeCarSpeed getDefaultInstanceForType() {
                return CarlifeCarSpeed.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeCarSpeed build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeCarSpeed buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeCarSpeed buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeCarSpeed returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeCarSpeed) {
                    return mergeFrom((CarlifeCarSpeed) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeCarSpeed other) {
                if (other != CarlifeCarSpeed.getDefaultInstance()) {
                    if (other.hasSpeed()) {
                        setSpeed(other.getSpeed());
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
                            setSpeed(input.readInt32());
                            continue;
                        case 16:
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

        private CarlifeCarSpeed() {
            this.speed_ = 0;
            this.timeStamp_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeCarSpeedProto.getDescriptor();
            CarlifeCarSpeedProto.internalForceInit();
        }

        public static CarlifeCarSpeed getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeCarSpeed getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeCarSpeedProto.f6607x46ca549f;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeCarSpeedProto.f6608x8b266c1d;
        }

        public boolean hasSpeed() {
            return this.hasSpeed;
        }

        public int getSpeed() {
            return this.speed_;
        }

        public boolean hasTimeStamp() {
            return this.hasTimeStamp;
        }

        public long getTimeStamp() {
            return this.timeStamp_;
        }

        public final boolean isInitialized() {
            if (this.hasSpeed) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasSpeed()) {
                output.writeInt32(1, getSpeed());
            }
            if (hasTimeStamp()) {
                output.writeUInt64(2, getTimeStamp());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasSpeed()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getSpeed());
            }
            if (hasTimeStamp()) {
                size += CodedOutputStream.computeUInt64Size(2, getTimeStamp());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeCarSpeed parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarSpeed parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeCarSpeed parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeCarSpeed parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeCarSpeed prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeCarSpeedProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCarlifeCarSpeedProto.proto\u0012\u001acom.baidu.carlife.protobuf\"3\n\u000fCarlifeCarSpeed\u0012\r\n\u0005speed\u0018\u0001 \u0002(\u0005\u0012\u0011\n\ttimeStamp\u0018\u0002 \u0001(\u0004"}, new FileDescriptor[0], new C20561());
    }

    public static void internalForceInit() {
    }
}
