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

public final class CarlifeErrorCodeProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_descriptor */
    private static Descriptor f6615x2c89a015;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_fieldAccessorTable */
    private static FieldAccessorTable f6616xa5f5e193;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeErrorCodeProto$1 */
    static class C20621 implements InternalDescriptorAssigner {
        C20621() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeErrorCodeProto.descriptor = root;
            CarlifeErrorCodeProto.f6615x2c89a015 = (Descriptor) CarlifeErrorCodeProto.getDescriptor().getMessageTypes().get(0);
            CarlifeErrorCodeProto.f6616xa5f5e193 = new FieldAccessorTable(CarlifeErrorCodeProto.f6615x2c89a015, new String[]{"ErrorCode"}, CarlifeErrorCode.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeErrorCode extends GeneratedMessage {
        public static final int ERRORCODE_FIELD_NUMBER = 1;
        private static final CarlifeErrorCode defaultInstance = new CarlifeErrorCode();
        private String errorCode_;
        private boolean hasErrorCode;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeErrorCode result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeErrorCode();
                return builder;
            }

            protected CarlifeErrorCode internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeErrorCode();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeErrorCode.getDescriptor();
            }

            public CarlifeErrorCode getDefaultInstanceForType() {
                return CarlifeErrorCode.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeErrorCode build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeErrorCode buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeErrorCode buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeErrorCode returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeErrorCode) {
                    return mergeFrom((CarlifeErrorCode) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeErrorCode other) {
                if (other != CarlifeErrorCode.getDefaultInstance()) {
                    if (other.hasErrorCode()) {
                        setErrorCode(other.getErrorCode());
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
                            setErrorCode(input.readString());
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

            public boolean hasErrorCode() {
                return this.result.hasErrorCode();
            }

            public String getErrorCode() {
                return this.result.getErrorCode();
            }

            public Builder setErrorCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasErrorCode = true;
                this.result.errorCode_ = value;
                return this;
            }

            public Builder clearErrorCode() {
                this.result.hasErrorCode = false;
                this.result.errorCode_ = CarlifeErrorCode.getDefaultInstance().getErrorCode();
                return this;
            }
        }

        private CarlifeErrorCode() {
            this.errorCode_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeErrorCodeProto.getDescriptor();
            CarlifeErrorCodeProto.internalForceInit();
        }

        public static CarlifeErrorCode getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeErrorCode getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeErrorCodeProto.f6615x2c89a015;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeErrorCodeProto.f6616xa5f5e193;
        }

        public boolean hasErrorCode() {
            return this.hasErrorCode;
        }

        public String getErrorCode() {
            return this.errorCode_;
        }

        public final boolean isInitialized() {
            if (this.hasErrorCode) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasErrorCode()) {
                output.writeString(1, getErrorCode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasErrorCode()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getErrorCode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeErrorCode parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeErrorCode parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeErrorCode parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeErrorCode parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeErrorCode prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeErrorCodeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bCarlifeErrorCodeProto.proto\u0012\u001acom.baidu.carlife.protobuf\"%\n\u0010CarlifeErrorCode\u0012\u0011\n\terrorCode\u0018\u0001 \u0002(\t"}, new FileDescriptor[0], new C20621());
    }

    public static void internalForceInit() {
    }
}
