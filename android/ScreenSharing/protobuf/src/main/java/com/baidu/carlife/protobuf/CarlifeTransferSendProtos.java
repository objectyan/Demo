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

public final class CarlifeTransferSendProtos {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_carlife_protobuf_CarlifeTransferSend_descriptor;
    /* renamed from: internal_static_carlife_protobuf_CarlifeTransferSend_fieldAccessorTable */
    private static FieldAccessorTable f6663x178fee7f;

    /* renamed from: CarlifeTransferSendProtos$1 */
    static class C20951 implements InternalDescriptorAssigner {
        C20951() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTransferSendProtos.descriptor = root;
            CarlifeTransferSendProtos.internal_static_carlife_protobuf_CarlifeTransferSend_descriptor = (Descriptor) CarlifeTransferSendProtos.getDescriptor().getMessageTypes().get(0);
            CarlifeTransferSendProtos.f6663x178fee7f = new FieldAccessorTable(CarlifeTransferSendProtos.internal_static_carlife_protobuf_CarlifeTransferSend_descriptor, new String[]{"PacketSize", "BodyData"}, CarlifeTransferSend.class, CarlifeTransferSend.Builder.class);
            return null;
        }
    }

    public static final class CarlifeTransferSend extends GeneratedMessage {
        public static final int BODYDATA_FIELD_NUMBER = 2;
        public static final int PACKETSIZE_FIELD_NUMBER = 1;
        private static final CarlifeTransferSend defaultInstance = new CarlifeTransferSend();
        private ByteString bodyData_;
        private boolean hasBodyData;
        private boolean hasPacketSize;
        private int memoizedSerializedSize;
        private int packetSize_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTransferSend result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTransferSend();
                return builder;
            }

            protected CarlifeTransferSend internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTransferSend();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTransferSend.getDescriptor();
            }

            public CarlifeTransferSend getDefaultInstanceForType() {
                return CarlifeTransferSend.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTransferSend build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTransferSend buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTransferSend buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTransferSend returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTransferSend) {
                    return mergeFrom((CarlifeTransferSend) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTransferSend other) {
                if (other != CarlifeTransferSend.getDefaultInstance()) {
                    if (other.hasPacketSize()) {
                        setPacketSize(other.getPacketSize());
                    }
                    if (other.hasBodyData()) {
                        setBodyData(other.getBodyData());
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
                            setPacketSize(input.readInt32());
                            continue;
                        case 18:
                            setBodyData(input.readBytes());
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

            public boolean hasPacketSize() {
                return this.result.hasPacketSize();
            }

            public int getPacketSize() {
                return this.result.getPacketSize();
            }

            public Builder setPacketSize(int value) {
                this.result.hasPacketSize = true;
                this.result.packetSize_ = value;
                return this;
            }

            public Builder clearPacketSize() {
                this.result.hasPacketSize = false;
                this.result.packetSize_ = 0;
                return this;
            }

            public boolean hasBodyData() {
                return this.result.hasBodyData();
            }

            public ByteString getBodyData() {
                return this.result.getBodyData();
            }

            public Builder setBodyData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasBodyData = true;
                this.result.bodyData_ = value;
                return this;
            }

            public Builder clearBodyData() {
                this.result.hasBodyData = false;
                this.result.bodyData_ = CarlifeTransferSend.getDefaultInstance().getBodyData();
                return this;
            }
        }

        private CarlifeTransferSend() {
            this.packetSize_ = 0;
            this.bodyData_ = ByteString.EMPTY;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTransferSendProtos.getDescriptor();
            CarlifeTransferSendProtos.internalForceInit();
        }

        public static CarlifeTransferSend getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTransferSend getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTransferSendProtos.internal_static_carlife_protobuf_CarlifeTransferSend_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTransferSendProtos.f6663x178fee7f;
        }

        public boolean hasPacketSize() {
            return this.hasPacketSize;
        }

        public int getPacketSize() {
            return this.packetSize_;
        }

        public boolean hasBodyData() {
            return this.hasBodyData;
        }

        public ByteString getBodyData() {
            return this.bodyData_;
        }

        public final boolean isInitialized() {
            if (this.hasPacketSize && this.hasBodyData) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasPacketSize()) {
                output.writeInt32(1, getPacketSize());
            }
            if (hasBodyData()) {
                output.writeBytes(2, getBodyData());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasPacketSize()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getPacketSize());
            }
            if (hasBodyData()) {
                size += CodedOutputStream.computeBytesSize(2, getBodyData());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTransferSend parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferSend parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTransferSend parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferSend parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTransferSend prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTransferSendProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\nsend.proto\u0012\u0010carlife.protobuf\";\n\u0013CarlifeTransferSend\u0012\u0012\n\npacketSize\u0018\u0001 \u0002(\u0005\u0012\u0010\n\bbodyData\u0018\u0002 \u0002(\fB7\n\u001acom.baidu.carlife.protobufB\u0019CarlifeTransferSendProtos"}, new FileDescriptor[0], new C20951());
    }

    public static void internalForceInit() {
    }
}
