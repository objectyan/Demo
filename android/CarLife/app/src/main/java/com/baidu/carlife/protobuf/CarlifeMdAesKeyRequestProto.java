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

public final class CarlifeMdAesKeyRequestProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_descriptor */
    private static Descriptor f6625xe475cc42;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_fieldAccessorTable */
    private static FieldAccessorTable f6626x84fd90c0;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto$1 */
    static class C20671 implements InternalDescriptorAssigner {
        C20671() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeMdAesKeyRequestProto.descriptor = root;
            CarlifeMdAesKeyRequestProto.f6625xe475cc42 = (Descriptor) CarlifeMdAesKeyRequestProto.getDescriptor().getMessageTypes().get(0);
            CarlifeMdAesKeyRequestProto.f6626x84fd90c0 = new FieldAccessorTable(CarlifeMdAesKeyRequestProto.f6625xe475cc42, new String[]{"AesKey"}, CarlifeMdAesKeyRequest.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeMdAesKeyRequest extends GeneratedMessage {
        public static final int AESKEY_FIELD_NUMBER = 1;
        private static final CarlifeMdAesKeyRequest defaultInstance = new CarlifeMdAesKeyRequest();
        private String aesKey_;
        private boolean hasAesKey;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeMdAesKeyRequest result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeMdAesKeyRequest();
                return builder;
            }

            protected CarlifeMdAesKeyRequest internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeMdAesKeyRequest();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeMdAesKeyRequest.getDescriptor();
            }

            public CarlifeMdAesKeyRequest getDefaultInstanceForType() {
                return CarlifeMdAesKeyRequest.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeMdAesKeyRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeMdAesKeyRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeMdAesKeyRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeMdAesKeyRequest returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeMdAesKeyRequest) {
                    return mergeFrom((CarlifeMdAesKeyRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeMdAesKeyRequest other) {
                if (other != CarlifeMdAesKeyRequest.getDefaultInstance()) {
                    if (other.hasAesKey()) {
                        setAesKey(other.getAesKey());
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
                        case 10:
                            setAesKey(input.readString());
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

            public boolean hasAesKey() {
                return this.result.hasAesKey();
            }

            public String getAesKey() {
                return this.result.getAesKey();
            }

            public Builder setAesKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasAesKey = true;
                this.result.aesKey_ = value;
                return this;
            }

            public Builder clearAesKey() {
                this.result.hasAesKey = false;
                this.result.aesKey_ = CarlifeMdAesKeyRequest.getDefaultInstance().getAesKey();
                return this;
            }
        }

        private CarlifeMdAesKeyRequest() {
            this.aesKey_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeMdAesKeyRequestProto.getDescriptor();
            CarlifeMdAesKeyRequestProto.internalForceInit();
        }

        public static CarlifeMdAesKeyRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeMdAesKeyRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeMdAesKeyRequestProto.f6625xe475cc42;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeMdAesKeyRequestProto.f6626x84fd90c0;
        }

        public boolean hasAesKey() {
            return this.hasAesKey;
        }

        public String getAesKey() {
            return this.aesKey_;
        }

        public final boolean isInitialized() {
            if (this.hasAesKey) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAesKey()) {
                output.writeString(1, getAesKey());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAesKey()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getAesKey());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeMdAesKeyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMdAesKeyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeMdAesKeyRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeMdAesKeyRequestProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeMdAesKeyRequestProto.proto\u0012\u001acom.baidu.carlife.protobuf\"(\n\u0016CarlifeMdAesKeyRequest\u0012\u000e\n\u0006aesKey\u0018\u0001 \u0002(\t"}, new FileDescriptor[0], new C20671());
    }

    public static void internalForceInit() {
    }
}
