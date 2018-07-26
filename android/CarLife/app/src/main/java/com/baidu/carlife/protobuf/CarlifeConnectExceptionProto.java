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

public final class CarlifeConnectExceptionProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_descriptor */
    private static Descriptor f6611x5d54a3ad;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_fieldAccessorTable */
    private static FieldAccessorTable f6612xb1afcd2b;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeConnectExceptionProto$1 */
    static class C20581 implements InternalDescriptorAssigner {
        C20581() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeConnectExceptionProto.descriptor = root;
            CarlifeConnectExceptionProto.f6611x5d54a3ad = (Descriptor) CarlifeConnectExceptionProto.getDescriptor().getMessageTypes().get(0);
            CarlifeConnectExceptionProto.f6612xb1afcd2b = new FieldAccessorTable(CarlifeConnectExceptionProto.f6611x5d54a3ad, new String[]{"ExceptionType"}, CarlifeConnectException.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeConnectException extends GeneratedMessage {
        public static final int EXCEPTIONTYPE_FIELD_NUMBER = 1;
        private static final CarlifeConnectException defaultInstance = new CarlifeConnectException();
        private int exceptionType_;
        private boolean hasExceptionType;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeConnectException result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeConnectException();
                return builder;
            }

            protected CarlifeConnectException internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeConnectException();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeConnectException.getDescriptor();
            }

            public CarlifeConnectException getDefaultInstanceForType() {
                return CarlifeConnectException.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeConnectException build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeConnectException buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeConnectException buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeConnectException returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeConnectException) {
                    return mergeFrom((CarlifeConnectException) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeConnectException other) {
                if (other != CarlifeConnectException.getDefaultInstance()) {
                    if (other.hasExceptionType()) {
                        setExceptionType(other.getExceptionType());
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
                            setExceptionType(input.readInt32());
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

            public boolean hasExceptionType() {
                return this.result.hasExceptionType();
            }

            public int getExceptionType() {
                return this.result.getExceptionType();
            }

            public Builder setExceptionType(int value) {
                this.result.hasExceptionType = true;
                this.result.exceptionType_ = value;
                return this;
            }

            public Builder clearExceptionType() {
                this.result.hasExceptionType = false;
                this.result.exceptionType_ = 0;
                return this;
            }
        }

        private CarlifeConnectException() {
            this.exceptionType_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeConnectExceptionProto.getDescriptor();
            CarlifeConnectExceptionProto.internalForceInit();
        }

        public static CarlifeConnectException getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeConnectException getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeConnectExceptionProto.f6611x5d54a3ad;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeConnectExceptionProto.f6612xb1afcd2b;
        }

        public boolean hasExceptionType() {
            return this.hasExceptionType;
        }

        public int getExceptionType() {
            return this.exceptionType_;
        }

        public final boolean isInitialized() {
            if (this.hasExceptionType) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasExceptionType()) {
                output.writeInt32(1, getExceptionType());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasExceptionType()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getExceptionType());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeConnectException parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectException parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeConnectException parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeConnectException parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeConnectException prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeConnectExceptionProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeConnectExceptionProto.proto\u0012\u001acom.baidu.carlife.protobuf\"0\n\u0017CarlifeConnectException\u0012\u0015\n\rexceptionType\u0018\u0001 \u0002(\u0005"}, new FileDescriptor[0], new C20581());
    }

    public static void internalForceInit() {
    }
}
