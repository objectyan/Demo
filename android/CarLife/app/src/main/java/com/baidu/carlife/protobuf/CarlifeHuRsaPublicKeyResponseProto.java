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

public final class CarlifeHuRsaPublicKeyResponseProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_descriptor */
    private static Descriptor f6623xbf8725ee;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_fieldAccessorTable */
    private static FieldAccessorTable f6624x27a07e6c;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeHuRsaPublicKeyResponseProto$1 */
    static class C20661 implements InternalDescriptorAssigner {
        C20661() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeHuRsaPublicKeyResponseProto.descriptor = root;
            CarlifeHuRsaPublicKeyResponseProto.f6623xbf8725ee = (Descriptor) CarlifeHuRsaPublicKeyResponseProto.getDescriptor().getMessageTypes().get(0);
            CarlifeHuRsaPublicKeyResponseProto.f6624x27a07e6c = new FieldAccessorTable(CarlifeHuRsaPublicKeyResponseProto.f6623xbf8725ee, new String[]{"RsaPublicKey"}, CarlifeHuRsaPublicKeyResponse.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeHuRsaPublicKeyResponse extends GeneratedMessage {
        public static final int RSAPUBLICKEY_FIELD_NUMBER = 1;
        private static final CarlifeHuRsaPublicKeyResponse defaultInstance = new CarlifeHuRsaPublicKeyResponse();
        private boolean hasRsaPublicKey;
        private int memoizedSerializedSize;
        private String rsaPublicKey_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeHuRsaPublicKeyResponse result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeHuRsaPublicKeyResponse();
                return builder;
            }

            protected CarlifeHuRsaPublicKeyResponse internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeHuRsaPublicKeyResponse();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeHuRsaPublicKeyResponse.getDescriptor();
            }

            public CarlifeHuRsaPublicKeyResponse getDefaultInstanceForType() {
                return CarlifeHuRsaPublicKeyResponse.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeHuRsaPublicKeyResponse build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeHuRsaPublicKeyResponse buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeHuRsaPublicKeyResponse buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeHuRsaPublicKeyResponse returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeHuRsaPublicKeyResponse) {
                    return mergeFrom((CarlifeHuRsaPublicKeyResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeHuRsaPublicKeyResponse other) {
                if (other != CarlifeHuRsaPublicKeyResponse.getDefaultInstance()) {
                    if (other.hasRsaPublicKey()) {
                        setRsaPublicKey(other.getRsaPublicKey());
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
                            setRsaPublicKey(input.readString());
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

            public boolean hasRsaPublicKey() {
                return this.result.hasRsaPublicKey();
            }

            public String getRsaPublicKey() {
                return this.result.getRsaPublicKey();
            }

            public Builder setRsaPublicKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasRsaPublicKey = true;
                this.result.rsaPublicKey_ = value;
                return this;
            }

            public Builder clearRsaPublicKey() {
                this.result.hasRsaPublicKey = false;
                this.result.rsaPublicKey_ = CarlifeHuRsaPublicKeyResponse.getDefaultInstance().getRsaPublicKey();
                return this;
            }
        }

        private CarlifeHuRsaPublicKeyResponse() {
            this.rsaPublicKey_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeHuRsaPublicKeyResponseProto.getDescriptor();
            CarlifeHuRsaPublicKeyResponseProto.internalForceInit();
        }

        public static CarlifeHuRsaPublicKeyResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeHuRsaPublicKeyResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeHuRsaPublicKeyResponseProto.f6623xbf8725ee;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeHuRsaPublicKeyResponseProto.f6624x27a07e6c;
        }

        public boolean hasRsaPublicKey() {
            return this.hasRsaPublicKey;
        }

        public String getRsaPublicKey() {
            return this.rsaPublicKey_;
        }

        public final boolean isInitialized() {
            if (this.hasRsaPublicKey) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasRsaPublicKey()) {
                output.writeString(1, getRsaPublicKey());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasRsaPublicKey()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getRsaPublicKey());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeHuRsaPublicKeyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeHuRsaPublicKeyResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeHuRsaPublicKeyResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(CarlifeHuRsaPublicKeyResponseProto.proto\u0012\u001acom.baidu.carlife.protobuf\"5\n\u001dCarlifeHuRsaPublicKeyResponse\u0012\u0014\n\frsaPublicKey\u0018\u0001 \u0002(\t"}, new FileDescriptor[0], new C20661());
    }

    public static void internalForceInit() {
    }
}
