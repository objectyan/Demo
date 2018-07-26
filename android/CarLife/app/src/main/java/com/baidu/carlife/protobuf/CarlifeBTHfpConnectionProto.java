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

public final class CarlifeBTHfpConnectionProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_descriptor */
    private static Descriptor f6583x685e96ec;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpConnection_fieldAccessorTable */
    private static FieldAccessorTable f6584x15ee116a;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto$1 */
    static class C20441 implements InternalDescriptorAssigner {
        C20441() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTHfpConnectionProto.descriptor = root;
            CarlifeBTHfpConnectionProto.f6583x685e96ec = (Descriptor) CarlifeBTHfpConnectionProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTHfpConnectionProto.f6584x15ee116a = new FieldAccessorTable(CarlifeBTHfpConnectionProto.f6583x685e96ec, new String[]{"State", JNISearchConst.JNI_ADDRESS, "Name"}, CarlifeBTHfpConnection.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTHfpConnection extends GeneratedMessage {
        public static final int ADDRESS_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int STATE_FIELD_NUMBER = 1;
        private static final CarlifeBTHfpConnection defaultInstance = new CarlifeBTHfpConnection();
        private String address_;
        private boolean hasAddress;
        private boolean hasName;
        private boolean hasState;
        private int memoizedSerializedSize;
        private String name_;
        private int state_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTHfpConnection result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTHfpConnection();
                return builder;
            }

            protected CarlifeBTHfpConnection internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTHfpConnection();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTHfpConnection.getDescriptor();
            }

            public CarlifeBTHfpConnection getDefaultInstanceForType() {
                return CarlifeBTHfpConnection.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTHfpConnection build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTHfpConnection buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTHfpConnection buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTHfpConnection returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTHfpConnection) {
                    return mergeFrom((CarlifeBTHfpConnection) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTHfpConnection other) {
                if (other != CarlifeBTHfpConnection.getDefaultInstance()) {
                    if (other.hasState()) {
                        setState(other.getState());
                    }
                    if (other.hasAddress()) {
                        setAddress(other.getAddress());
                    }
                    if (other.hasName()) {
                        setName(other.getName());
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
                            setState(input.readInt32());
                            continue;
                        case 18:
                            setAddress(input.readString());
                            continue;
                        case 26:
                            setName(input.readString());
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

            public boolean hasState() {
                return this.result.hasState();
            }

            public int getState() {
                return this.result.getState();
            }

            public Builder setState(int value) {
                this.result.hasState = true;
                this.result.state_ = value;
                return this;
            }

            public Builder clearState() {
                this.result.hasState = false;
                this.result.state_ = 0;
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
                this.result.address_ = CarlifeBTHfpConnection.getDefaultInstance().getAddress();
                return this;
            }

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = CarlifeBTHfpConnection.getDefaultInstance().getName();
                return this;
            }
        }

        private CarlifeBTHfpConnection() {
            this.state_ = 0;
            this.address_ = "";
            this.name_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTHfpConnectionProto.getDescriptor();
            CarlifeBTHfpConnectionProto.internalForceInit();
        }

        public static CarlifeBTHfpConnection getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTHfpConnection getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTHfpConnectionProto.f6583x685e96ec;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTHfpConnectionProto.f6584x15ee116a;
        }

        public boolean hasState() {
            return this.hasState;
        }

        public int getState() {
            return this.state_;
        }

        public boolean hasAddress() {
            return this.hasAddress;
        }

        public String getAddress() {
            return this.address_;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public final boolean isInitialized() {
            if (this.hasState) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasState()) {
                output.writeInt32(1, getState());
            }
            if (hasAddress()) {
                output.writeString(2, getAddress());
            }
            if (hasName()) {
                output.writeString(3, getName());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasState()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getState());
            }
            if (hasAddress()) {
                size += CodedOutputStream.computeStringSize(2, getAddress());
            }
            if (hasName()) {
                size += CodedOutputStream.computeStringSize(3, getName());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTHfpConnection parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpConnection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTHfpConnection prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTHfpConnectionProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeBTHfpConnectionProto.proto\u0012\u001acom.baidu.carlife.protobuf\"F\n\u0016CarlifeBTHfpConnection\u0012\r\n\u0005state\u0018\u0001 \u0002(\u0005\u0012\u000f\n\u0007address\u0018\u0002 \u0001(\t\u0012\f\n\u0004name\u0018\u0003 \u0001(\t"}, new FileDescriptor[0], new C20441());
    }

    public static void internalForceInit() {
    }
}
