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

public final class CarlifeBTHfpRequestProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_descriptor */
    private static Descriptor f6587xbede2523;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpRequest_fieldAccessorTable */
    private static FieldAccessorTable f6588x4db378a1;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTHfpRequestProto$1 */
    static class C20461 implements InternalDescriptorAssigner {
        C20461() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTHfpRequestProto.descriptor = root;
            CarlifeBTHfpRequestProto.f6587xbede2523 = (Descriptor) CarlifeBTHfpRequestProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTHfpRequestProto.f6588x4db378a1 = new FieldAccessorTable(CarlifeBTHfpRequestProto.f6587xbede2523, new String[]{"Command", "PhoneNum", "DtmfCode"}, CarlifeBTHfpRequest.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTHfpRequest extends GeneratedMessage {
        public static final int COMMAND_FIELD_NUMBER = 1;
        public static final int DTMFCODE_FIELD_NUMBER = 3;
        public static final int PHONENUM_FIELD_NUMBER = 2;
        private static final CarlifeBTHfpRequest defaultInstance = new CarlifeBTHfpRequest();
        private int command_;
        private int dtmfCode_;
        private boolean hasCommand;
        private boolean hasDtmfCode;
        private boolean hasPhoneNum;
        private int memoizedSerializedSize;
        private String phoneNum_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTHfpRequest result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTHfpRequest();
                return builder;
            }

            protected CarlifeBTHfpRequest internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTHfpRequest();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTHfpRequest.getDescriptor();
            }

            public CarlifeBTHfpRequest getDefaultInstanceForType() {
                return CarlifeBTHfpRequest.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTHfpRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTHfpRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTHfpRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTHfpRequest returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTHfpRequest) {
                    return mergeFrom((CarlifeBTHfpRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTHfpRequest other) {
                if (other != CarlifeBTHfpRequest.getDefaultInstance()) {
                    if (other.hasCommand()) {
                        setCommand(other.getCommand());
                    }
                    if (other.hasPhoneNum()) {
                        setPhoneNum(other.getPhoneNum());
                    }
                    if (other.hasDtmfCode()) {
                        setDtmfCode(other.getDtmfCode());
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
                            setCommand(input.readInt32());
                            continue;
                        case 18:
                            setPhoneNum(input.readString());
                            continue;
                        case 24:
                            setDtmfCode(input.readInt32());
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

            public boolean hasCommand() {
                return this.result.hasCommand();
            }

            public int getCommand() {
                return this.result.getCommand();
            }

            public Builder setCommand(int value) {
                this.result.hasCommand = true;
                this.result.command_ = value;
                return this;
            }

            public Builder clearCommand() {
                this.result.hasCommand = false;
                this.result.command_ = 0;
                return this;
            }

            public boolean hasPhoneNum() {
                return this.result.hasPhoneNum();
            }

            public String getPhoneNum() {
                return this.result.getPhoneNum();
            }

            public Builder setPhoneNum(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasPhoneNum = true;
                this.result.phoneNum_ = value;
                return this;
            }

            public Builder clearPhoneNum() {
                this.result.hasPhoneNum = false;
                this.result.phoneNum_ = CarlifeBTHfpRequest.getDefaultInstance().getPhoneNum();
                return this;
            }

            public boolean hasDtmfCode() {
                return this.result.hasDtmfCode();
            }

            public int getDtmfCode() {
                return this.result.getDtmfCode();
            }

            public Builder setDtmfCode(int value) {
                this.result.hasDtmfCode = true;
                this.result.dtmfCode_ = value;
                return this;
            }

            public Builder clearDtmfCode() {
                this.result.hasDtmfCode = false;
                this.result.dtmfCode_ = 0;
                return this;
            }
        }

        private CarlifeBTHfpRequest() {
            this.command_ = 0;
            this.phoneNum_ = "";
            this.dtmfCode_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTHfpRequestProto.getDescriptor();
            CarlifeBTHfpRequestProto.internalForceInit();
        }

        public static CarlifeBTHfpRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTHfpRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTHfpRequestProto.f6587xbede2523;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTHfpRequestProto.f6588x4db378a1;
        }

        public boolean hasCommand() {
            return this.hasCommand;
        }

        public int getCommand() {
            return this.command_;
        }

        public boolean hasPhoneNum() {
            return this.hasPhoneNum;
        }

        public String getPhoneNum() {
            return this.phoneNum_;
        }

        public boolean hasDtmfCode() {
            return this.hasDtmfCode;
        }

        public int getDtmfCode() {
            return this.dtmfCode_;
        }

        public final boolean isInitialized() {
            if (this.hasCommand) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasCommand()) {
                output.writeInt32(1, getCommand());
            }
            if (hasPhoneNum()) {
                output.writeString(2, getPhoneNum());
            }
            if (hasDtmfCode()) {
                output.writeInt32(3, getDtmfCode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasCommand()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getCommand());
            }
            if (hasPhoneNum()) {
                size += CodedOutputStream.computeStringSize(2, getPhoneNum());
            }
            if (hasDtmfCode()) {
                size += CodedOutputStream.computeInt32Size(3, getDtmfCode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTHfpRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTHfpRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTHfpRequestProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eCarlifeBTHfpRequestProto.proto\u0012\u001acom.baidu.carlife.protobuf\"J\n\u0013CarlifeBTHfpRequest\u0012\u000f\n\u0007command\u0018\u0001 \u0002(\u0005\u0012\u0010\n\bphoneNum\u0018\u0002 \u0001(\t\u0012\u0010\n\bdtmfCode\u0018\u0003 \u0001(\u0005"}, new FileDescriptor[0], new C20461());
    }

    public static void internalForceInit() {
    }
}
