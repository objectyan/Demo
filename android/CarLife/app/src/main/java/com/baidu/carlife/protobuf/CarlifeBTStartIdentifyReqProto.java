package com.baidu.carlife.protobuf;

import com.baidu.navisdk.jni.nativeif.JNISearchConst;
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

public final class CarlifeBTStartIdentifyReqProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_descriptor */
    private static Descriptor f6599xee7c0c90;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_fieldAccessorTable */
    private static FieldAccessorTable f6600x719da30e;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTStartIdentifyReqProto$1 */
    static class C20521 implements InternalDescriptorAssigner {
        C20521() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTStartIdentifyReqProto.descriptor = root;
            CarlifeBTStartIdentifyReqProto.f6599xee7c0c90 = (Descriptor) CarlifeBTStartIdentifyReqProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTStartIdentifyReqProto.f6600x719da30e = new FieldAccessorTable(CarlifeBTStartIdentifyReqProto.f6599xee7c0c90, new String[]{JNISearchConst.JNI_ADDRESS}, CarlifeBTStartIdentifyReq.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTStartIdentifyReq extends GeneratedMessage {
        public static final int ADDRESS_FIELD_NUMBER = 1;
        private static final CarlifeBTStartIdentifyReq defaultInstance = new CarlifeBTStartIdentifyReq();
        private String address_;
        private boolean hasAddress;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTStartIdentifyReq result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTStartIdentifyReq();
                return builder;
            }

            protected CarlifeBTStartIdentifyReq internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTStartIdentifyReq();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTStartIdentifyReq.getDescriptor();
            }

            public CarlifeBTStartIdentifyReq getDefaultInstanceForType() {
                return CarlifeBTStartIdentifyReq.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTStartIdentifyReq build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTStartIdentifyReq buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTStartIdentifyReq buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTStartIdentifyReq returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTStartIdentifyReq) {
                    return mergeFrom((CarlifeBTStartIdentifyReq) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTStartIdentifyReq other) {
                if (other != CarlifeBTStartIdentifyReq.getDefaultInstance()) {
                    if (other.hasAddress()) {
                        setAddress(other.getAddress());
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
                            setAddress(input.readString());
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

            public boolean hasAddress() {
                return this.result.hasAddress();
            }

            public String getAddress() {
                return this.result.getAddress();
            }

            public Builder setAddress(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasAddress = true;
                this.result.address_ = value;
                return this;
            }

            public Builder clearAddress() {
                this.result.hasAddress = false;
                this.result.address_ = CarlifeBTStartIdentifyReq.getDefaultInstance().getAddress();
                return this;
            }
        }

        private CarlifeBTStartIdentifyReq() {
            this.address_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTStartIdentifyReqProto.getDescriptor();
            CarlifeBTStartIdentifyReqProto.internalForceInit();
        }

        public static CarlifeBTStartIdentifyReq getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTStartIdentifyReq getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTStartIdentifyReqProto.f6599xee7c0c90;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTStartIdentifyReqProto.f6600x719da30e;
        }

        public boolean hasAddress() {
            return this.hasAddress;
        }

        public String getAddress() {
            return this.address_;
        }

        public final boolean isInitialized() {
            if (this.hasAddress) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAddress()) {
                output.writeString(1, getAddress());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAddress()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getAddress());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTStartIdentifyReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTStartIdentifyReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTStartIdentifyReq prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTStartIdentifyReqProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$CarlifeBTStartIdentifyReqProto.proto\u0012\u001acom.baidu.carlife.protobuf\",\n\u0019CarlifeBTStartIdentifyReq\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\t"}, new FileDescriptor[0], new C20521());
    }

    public static void internalForceInit() {
    }
}
