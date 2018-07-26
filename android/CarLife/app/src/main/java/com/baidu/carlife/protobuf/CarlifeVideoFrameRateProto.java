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

public final class CarlifeVideoFrameRateProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_descriptor */
    private static Descriptor f6672x999ea360;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_fieldAccessorTable */
    private static FieldAccessorTable f6673x6b6469de;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeVideoFrameRateProto$1 */
    static class C21011 implements InternalDescriptorAssigner {
        C21011() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeVideoFrameRateProto.descriptor = root;
            CarlifeVideoFrameRateProto.f6672x999ea360 = (Descriptor) CarlifeVideoFrameRateProto.getDescriptor().getMessageTypes().get(0);
            CarlifeVideoFrameRateProto.f6673x6b6469de = new FieldAccessorTable(CarlifeVideoFrameRateProto.f6672x999ea360, new String[]{"FrameRate"}, CarlifeVideoFrameRate.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeVideoFrameRate extends GeneratedMessage {
        public static final int FRAMERATE_FIELD_NUMBER = 1;
        private static final CarlifeVideoFrameRate defaultInstance = new CarlifeVideoFrameRate();
        private int frameRate_;
        private boolean hasFrameRate;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeVideoFrameRate result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeVideoFrameRate();
                return builder;
            }

            protected CarlifeVideoFrameRate internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeVideoFrameRate();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeVideoFrameRate.getDescriptor();
            }

            public CarlifeVideoFrameRate getDefaultInstanceForType() {
                return CarlifeVideoFrameRate.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeVideoFrameRate build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeVideoFrameRate buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeVideoFrameRate buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeVideoFrameRate returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeVideoFrameRate) {
                    return mergeFrom((CarlifeVideoFrameRate) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeVideoFrameRate other) {
                if (other != CarlifeVideoFrameRate.getDefaultInstance()) {
                    if (other.hasFrameRate()) {
                        setFrameRate(other.getFrameRate());
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
                            setFrameRate(input.readInt32());
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

            public boolean hasFrameRate() {
                return this.result.hasFrameRate();
            }

            public int getFrameRate() {
                return this.result.getFrameRate();
            }

            public Builder setFrameRate(int value) {
                this.result.hasFrameRate = true;
                this.result.frameRate_ = value;
                return this;
            }

            public Builder clearFrameRate() {
                this.result.hasFrameRate = false;
                this.result.frameRate_ = 0;
                return this;
            }
        }

        private CarlifeVideoFrameRate() {
            this.frameRate_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeVideoFrameRateProto.getDescriptor();
            CarlifeVideoFrameRateProto.internalForceInit();
        }

        public static CarlifeVideoFrameRate getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeVideoFrameRate getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeVideoFrameRateProto.f6672x999ea360;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeVideoFrameRateProto.f6673x6b6469de;
        }

        public boolean hasFrameRate() {
            return this.hasFrameRate;
        }

        public int getFrameRate() {
            return this.frameRate_;
        }

        public final boolean isInitialized() {
            if (this.hasFrameRate) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasFrameRate()) {
                output.writeInt32(1, getFrameRate());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasFrameRate()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getFrameRate());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeVideoFrameRate parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVideoFrameRate parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeVideoFrameRate prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeVideoFrameRateProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n CarlifeVideoFrameRateProto.proto\u0012\u001acom.baidu.carlife.protobuf\"*\n\u0015CarlifeVideoFrameRate\u0012\u0011\n\tframeRate\u0018\u0001 \u0002(\u0005"}, new FileDescriptor[0], new C21011());
    }

    public static void internalForceInit() {
    }
}
