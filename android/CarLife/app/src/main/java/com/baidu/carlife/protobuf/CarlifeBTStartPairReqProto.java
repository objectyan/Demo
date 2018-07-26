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

public final class CarlifeBTStartPairReqProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_descriptor */
    private static Descriptor f6601x5bc0b9de;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_fieldAccessorTable */
    private static FieldAccessorTable f6602xc6bf225c;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTStartPairReqProto$1 */
    static class C20531 implements InternalDescriptorAssigner {
        C20531() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTStartPairReqProto.descriptor = root;
            CarlifeBTStartPairReqProto.f6601x5bc0b9de = (Descriptor) CarlifeBTStartPairReqProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTStartPairReqProto.f6602xc6bf225c = new FieldAccessorTable(CarlifeBTStartPairReqProto.f6601x5bc0b9de, new String[]{"Ostype", JNISearchConst.JNI_ADDRESS}, CarlifeBTStartPairReq.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTStartPairReq extends GeneratedMessage {
        public static final int ADDRESS_FIELD_NUMBER = 2;
        public static final int OSTYPE_FIELD_NUMBER = 1;
        private static final CarlifeBTStartPairReq defaultInstance = new CarlifeBTStartPairReq();
        private String address_;
        private boolean hasAddress;
        private boolean hasOstype;
        private int memoizedSerializedSize;
        private int ostype_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTStartPairReq result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTStartPairReq();
                return builder;
            }

            protected CarlifeBTStartPairReq internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTStartPairReq();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTStartPairReq.getDescriptor();
            }

            public CarlifeBTStartPairReq getDefaultInstanceForType() {
                return CarlifeBTStartPairReq.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTStartPairReq build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTStartPairReq buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTStartPairReq buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTStartPairReq returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTStartPairReq) {
                    return mergeFrom((CarlifeBTStartPairReq) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTStartPairReq other) {
                if (other != CarlifeBTStartPairReq.getDefaultInstance()) {
                    if (other.hasOstype()) {
                        setOstype(other.getOstype());
                    }
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
                        case 8:
                            setOstype(input.readInt32());
                            continue;
                        case 18:
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

            public boolean hasOstype() {
                return this.result.hasOstype();
            }

            public int getOstype() {
                return this.result.getOstype();
            }

            public Builder setOstype(int value) {
                this.result.hasOstype = true;
                this.result.ostype_ = value;
                return this;
            }

            public Builder clearOstype() {
                this.result.hasOstype = false;
                this.result.ostype_ = 0;
                return this;
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
                this.result.address_ = CarlifeBTStartPairReq.getDefaultInstance().getAddress();
                return this;
            }
        }

        private CarlifeBTStartPairReq() {
            this.ostype_ = 0;
            this.address_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTStartPairReqProto.getDescriptor();
            CarlifeBTStartPairReqProto.internalForceInit();
        }

        public static CarlifeBTStartPairReq getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTStartPairReq getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTStartPairReqProto.f6601x5bc0b9de;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTStartPairReqProto.f6602xc6bf225c;
        }

        public boolean hasOstype() {
            return this.hasOstype;
        }

        public int getOstype() {
            return this.ostype_;
        }

        public boolean hasAddress() {
            return this.hasAddress;
        }

        public String getAddress() {
            return this.address_;
        }

        public final boolean isInitialized() {
            if (this.hasOstype) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasOstype()) {
                output.writeInt32(1, getOstype());
            }
            if (hasAddress()) {
                output.writeString(2, getAddress());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasOstype()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getOstype());
            }
            if (hasAddress()) {
                size += CodedOutputStream.computeStringSize(2, getAddress());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTStartPairReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTStartPairReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTStartPairReq prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTStartPairReqProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n CarlifeBTStartPairReqProto.proto\u0012\u001acom.baidu.carlife.protobuf\"8\n\u0015CarlifeBTStartPairReq\u0012\u000e\n\u0006ostype\u0018\u0001 \u0002(\u0005\u0012\u000f\n\u0007address\u0018\u0002 \u0001(\t"}, new FileDescriptor[0], new C20531());
    }

    public static void internalForceInit() {
    }
}
