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

public final class CarlifeGearInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_descriptor */
    private static Descriptor f6621x8a18c55;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_fieldAccessorTable */
    private static FieldAccessorTable f6622xa27d8dd3;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeGearInfoProto$1 */
    static class C20651 implements InternalDescriptorAssigner {
        C20651() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeGearInfoProto.descriptor = root;
            CarlifeGearInfoProto.f6621x8a18c55 = (Descriptor) CarlifeGearInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeGearInfoProto.f6622xa27d8dd3 = new FieldAccessorTable(CarlifeGearInfoProto.f6621x8a18c55, new String[]{"Gear"}, CarlifeGearInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeGearInfo extends GeneratedMessage {
        public static final int GEAR_FIELD_NUMBER = 1;
        private static final CarlifeGearInfo defaultInstance = new CarlifeGearInfo();
        private int gear_;
        private boolean hasGear;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeGearInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeGearInfo();
                return builder;
            }

            protected CarlifeGearInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeGearInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeGearInfo.getDescriptor();
            }

            public CarlifeGearInfo getDefaultInstanceForType() {
                return CarlifeGearInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeGearInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeGearInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeGearInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeGearInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeGearInfo) {
                    return mergeFrom((CarlifeGearInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeGearInfo other) {
                if (other != CarlifeGearInfo.getDefaultInstance()) {
                    if (other.hasGear()) {
                        setGear(other.getGear());
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
                            setGear(input.readInt32());
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

            public boolean hasGear() {
                return this.result.hasGear();
            }

            public int getGear() {
                return this.result.getGear();
            }

            public Builder setGear(int value) {
                this.result.hasGear = true;
                this.result.gear_ = value;
                return this;
            }

            public Builder clearGear() {
                this.result.hasGear = false;
                this.result.gear_ = 0;
                return this;
            }
        }

        private CarlifeGearInfo() {
            this.gear_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeGearInfoProto.getDescriptor();
            CarlifeGearInfoProto.internalForceInit();
        }

        public static CarlifeGearInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeGearInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeGearInfoProto.f6621x8a18c55;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeGearInfoProto.f6622xa27d8dd3;
        }

        public boolean hasGear() {
            return this.hasGear;
        }

        public int getGear() {
            return this.gear_;
        }

        public final boolean isInitialized() {
            if (this.hasGear) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasGear()) {
                output.writeInt32(1, getGear());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasGear()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getGear());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeGearInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeGearInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeGearInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeGearInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeGearInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeGearInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCarlifeGearInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"\u001f\n\u000fCarlifeGearInfo\u0012\f\n\u0004gear\u0018\u0001 \u0002(\u0005"}, new FileDescriptor[0], new C20651());
    }

    public static void internalForceInit() {
    }
}
