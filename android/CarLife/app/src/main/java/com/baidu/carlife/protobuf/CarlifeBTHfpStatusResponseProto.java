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

public final class CarlifeBTHfpStatusResponseProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_descriptor */
    private static Descriptor f6593x98b3f657;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_fieldAccessorTable */
    private static FieldAccessorTable f6594x7f0ed5d5;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTHfpStatusResponseProto$1 */
    static class C20491 implements InternalDescriptorAssigner {
        C20491() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTHfpStatusResponseProto.descriptor = root;
            CarlifeBTHfpStatusResponseProto.f6593x98b3f657 = (Descriptor) CarlifeBTHfpStatusResponseProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTHfpStatusResponseProto.f6594x7f0ed5d5 = new FieldAccessorTable(CarlifeBTHfpStatusResponseProto.f6593x98b3f657, new String[]{"Status", "Type"}, CarlifeBTHfpStatusResponse.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTHfpStatusResponse extends GeneratedMessage {
        public static final int STATUS_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final CarlifeBTHfpStatusResponse defaultInstance = new CarlifeBTHfpStatusResponse();
        private boolean hasStatus;
        private boolean hasType;
        private int memoizedSerializedSize;
        private int status_;
        private int type_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTHfpStatusResponse result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTHfpStatusResponse();
                return builder;
            }

            protected CarlifeBTHfpStatusResponse internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTHfpStatusResponse();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTHfpStatusResponse.getDescriptor();
            }

            public CarlifeBTHfpStatusResponse getDefaultInstanceForType() {
                return CarlifeBTHfpStatusResponse.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTHfpStatusResponse build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTHfpStatusResponse buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTHfpStatusResponse buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTHfpStatusResponse returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTHfpStatusResponse) {
                    return mergeFrom((CarlifeBTHfpStatusResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTHfpStatusResponse other) {
                if (other != CarlifeBTHfpStatusResponse.getDefaultInstance()) {
                    if (other.hasStatus()) {
                        setStatus(other.getStatus());
                    }
                    if (other.hasType()) {
                        setType(other.getType());
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
                            setStatus(input.readInt32());
                            continue;
                        case 16:
                            setType(input.readInt32());
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

            public boolean hasStatus() {
                return this.result.hasStatus();
            }

            public int getStatus() {
                return this.result.getStatus();
            }

            public Builder setStatus(int value) {
                this.result.hasStatus = true;
                this.result.status_ = value;
                return this;
            }

            public Builder clearStatus() {
                this.result.hasStatus = false;
                this.result.status_ = 0;
                return this;
            }

            public boolean hasType() {
                return this.result.hasType();
            }

            public int getType() {
                return this.result.getType();
            }

            public Builder setType(int value) {
                this.result.hasType = true;
                this.result.type_ = value;
                return this;
            }

            public Builder clearType() {
                this.result.hasType = false;
                this.result.type_ = 0;
                return this;
            }
        }

        private CarlifeBTHfpStatusResponse() {
            this.status_ = 0;
            this.type_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTHfpStatusResponseProto.getDescriptor();
            CarlifeBTHfpStatusResponseProto.internalForceInit();
        }

        public static CarlifeBTHfpStatusResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTHfpStatusResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTHfpStatusResponseProto.f6593x98b3f657;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTHfpStatusResponseProto.f6594x7f0ed5d5;
        }

        public boolean hasStatus() {
            return this.hasStatus;
        }

        public int getStatus() {
            return this.status_;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public int getType() {
            return this.type_;
        }

        public final boolean isInitialized() {
            if (this.hasStatus && this.hasType) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasStatus()) {
                output.writeInt32(1, getStatus());
            }
            if (hasType()) {
                output.writeInt32(2, getType());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasStatus()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getStatus());
            }
            if (hasType()) {
                size += CodedOutputStream.computeInt32Size(2, getType());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTHfpStatusResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpStatusResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTHfpStatusResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTHfpStatusResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%CarlifeBTHfpStatusResponseProto.proto\u0012\u001acom.baidu.carlife.protobuf\":\n\u001aCarlifeBTHfpStatusResponse\u0012\u000e\n\u0006status\u0018\u0001 \u0002(\u0005\u0012\f\n\u0004type\u0018\u0002 \u0002(\u0005"}, new FileDescriptor[0], new C20491());
    }

    public static void internalForceInit() {
    }
}
