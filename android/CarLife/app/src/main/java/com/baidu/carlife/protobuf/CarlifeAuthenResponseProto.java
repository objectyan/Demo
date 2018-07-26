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

public final class CarlifeAuthenResponseProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_descriptor */
    private static Descriptor f6579x258bfd60;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_fieldAccessorTable */
    private static FieldAccessorTable f6580xc957c3de;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeAuthenResponseProto$1 */
    static class C20421 implements InternalDescriptorAssigner {
        C20421() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeAuthenResponseProto.descriptor = root;
            CarlifeAuthenResponseProto.f6579x258bfd60 = (Descriptor) CarlifeAuthenResponseProto.getDescriptor().getMessageTypes().get(0);
            CarlifeAuthenResponseProto.f6580xc957c3de = new FieldAccessorTable(CarlifeAuthenResponseProto.f6579x258bfd60, new String[]{"EncryptValue"}, CarlifeAuthenResponse.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeAuthenResponse extends GeneratedMessage {
        public static final int ENCRYPTVALUE_FIELD_NUMBER = 1;
        private static final CarlifeAuthenResponse defaultInstance = new CarlifeAuthenResponse();
        private String encryptValue_;
        private boolean hasEncryptValue;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeAuthenResponse result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeAuthenResponse();
                return builder;
            }

            protected CarlifeAuthenResponse internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeAuthenResponse();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeAuthenResponse.getDescriptor();
            }

            public CarlifeAuthenResponse getDefaultInstanceForType() {
                return CarlifeAuthenResponse.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeAuthenResponse build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeAuthenResponse buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeAuthenResponse buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeAuthenResponse returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeAuthenResponse) {
                    return mergeFrom((CarlifeAuthenResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeAuthenResponse other) {
                if (other != CarlifeAuthenResponse.getDefaultInstance()) {
                    if (other.hasEncryptValue()) {
                        setEncryptValue(other.getEncryptValue());
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
                            setEncryptValue(input.readString());
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

            public boolean hasEncryptValue() {
                return this.result.hasEncryptValue();
            }

            public String getEncryptValue() {
                return this.result.getEncryptValue();
            }

            public Builder setEncryptValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasEncryptValue = true;
                this.result.encryptValue_ = value;
                return this;
            }

            public Builder clearEncryptValue() {
                this.result.hasEncryptValue = false;
                this.result.encryptValue_ = CarlifeAuthenResponse.getDefaultInstance().getEncryptValue();
                return this;
            }
        }

        private CarlifeAuthenResponse() {
            this.encryptValue_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeAuthenResponseProto.getDescriptor();
            CarlifeAuthenResponseProto.internalForceInit();
        }

        public static CarlifeAuthenResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeAuthenResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeAuthenResponseProto.f6579x258bfd60;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeAuthenResponseProto.f6580xc957c3de;
        }

        public boolean hasEncryptValue() {
            return this.hasEncryptValue;
        }

        public String getEncryptValue() {
            return this.encryptValue_;
        }

        public final boolean isInitialized() {
            if (this.hasEncryptValue) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasEncryptValue()) {
                output.writeString(1, getEncryptValue());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasEncryptValue()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getEncryptValue());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeAuthenResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResponse parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeAuthenResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAuthenResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeAuthenResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeAuthenResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n CarlifeAuthenResponseProto.proto\u0012\u001acom.baidu.carlife.protobuf\"-\n\u0015CarlifeAuthenResponse\u0012\u0014\n\fencryptValue\u0018\u0001 \u0002(\t"}, new FileDescriptor[0], new C20421());
    }

    public static void internalForceInit() {
    }
}
