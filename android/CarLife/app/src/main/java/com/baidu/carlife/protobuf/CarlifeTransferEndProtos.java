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

public final class CarlifeTransferEndProtos {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor;
    /* renamed from: internal_static_carlife_protobuf_CarlifeTransferEnd_fieldAccessorTable */
    private static FieldAccessorTable f6662xff1fc7f6;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTransferEndProtos$1 */
    static class C20941 implements InternalDescriptorAssigner {
        C20941() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTransferEndProtos.descriptor = root;
            CarlifeTransferEndProtos.internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor = (Descriptor) CarlifeTransferEndProtos.getDescriptor().getMessageTypes().get(0);
            CarlifeTransferEndProtos.f6662xff1fc7f6 = new FieldAccessorTable(CarlifeTransferEndProtos.internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor, new String[]{"NewFirmwareVersionCode"}, CarlifeTransferEnd.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTransferEnd extends GeneratedMessage {
        public static final int NEWFIRMWAREVERSIONCODE_FIELD_NUMBER = 1;
        private static final CarlifeTransferEnd defaultInstance = new CarlifeTransferEnd();
        private boolean hasNewFirmwareVersionCode;
        private int memoizedSerializedSize;
        private int newFirmwareVersionCode_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTransferEnd result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTransferEnd();
                return builder;
            }

            protected CarlifeTransferEnd internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTransferEnd();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTransferEnd.getDescriptor();
            }

            public CarlifeTransferEnd getDefaultInstanceForType() {
                return CarlifeTransferEnd.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTransferEnd build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTransferEnd buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTransferEnd buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTransferEnd returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTransferEnd) {
                    return mergeFrom((CarlifeTransferEnd) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTransferEnd other) {
                if (other != CarlifeTransferEnd.getDefaultInstance()) {
                    if (other.hasNewFirmwareVersionCode()) {
                        setNewFirmwareVersionCode(other.getNewFirmwareVersionCode());
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
                            setNewFirmwareVersionCode(input.readInt32());
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

            public boolean hasNewFirmwareVersionCode() {
                return this.result.hasNewFirmwareVersionCode();
            }

            public int getNewFirmwareVersionCode() {
                return this.result.getNewFirmwareVersionCode();
            }

            public Builder setNewFirmwareVersionCode(int value) {
                this.result.hasNewFirmwareVersionCode = true;
                this.result.newFirmwareVersionCode_ = value;
                return this;
            }

            public Builder clearNewFirmwareVersionCode() {
                this.result.hasNewFirmwareVersionCode = false;
                this.result.newFirmwareVersionCode_ = 0;
                return this;
            }
        }

        private CarlifeTransferEnd() {
            this.newFirmwareVersionCode_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTransferEndProtos.getDescriptor();
            CarlifeTransferEndProtos.internalForceInit();
        }

        public static CarlifeTransferEnd getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTransferEnd getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTransferEndProtos.internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTransferEndProtos.f6662xff1fc7f6;
        }

        public boolean hasNewFirmwareVersionCode() {
            return this.hasNewFirmwareVersionCode;
        }

        public int getNewFirmwareVersionCode() {
            return this.newFirmwareVersionCode_;
        }

        public final boolean isInitialized() {
            if (this.hasNewFirmwareVersionCode) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasNewFirmwareVersionCode()) {
                output.writeInt32(1, getNewFirmwareVersionCode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasNewFirmwareVersionCode()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getNewFirmwareVersionCode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTransferEnd parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferEnd parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTransferEnd parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferEnd parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTransferEnd prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTransferEndProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\tend.proto\u0012\u0010carlife.protobuf\"4\n\u0012CarlifeTransferEnd\u0012\u001e\n\u0016newFirmwareVersionCode\u0018\u0001 \u0002(\u0005B6\n\u001acom.baidu.carlife.protobufB\u0018CarlifeTransferEndProtos"}, new FileDescriptor[0], new C20941());
    }

    public static void internalForceInit() {
    }
}
