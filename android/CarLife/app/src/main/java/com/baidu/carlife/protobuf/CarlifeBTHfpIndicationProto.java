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

public final class CarlifeBTHfpIndicationProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_descriptor */
    private static Descriptor f6585x8859cdae;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpIndication_fieldAccessorTable */
    private static FieldAccessorTable f6586xd62f662c;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTHfpIndicationProto$1 */
    static class C20451 implements InternalDescriptorAssigner {
        C20451() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTHfpIndicationProto.descriptor = root;
            CarlifeBTHfpIndicationProto.f6585x8859cdae = (Descriptor) CarlifeBTHfpIndicationProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTHfpIndicationProto.f6586xd62f662c = new FieldAccessorTable(CarlifeBTHfpIndicationProto.f6585x8859cdae, new String[]{"State", "PhoneNum", "PhoneName", JNISearchConst.JNI_ADDRESS}, CarlifeBTHfpIndication.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTHfpIndication extends GeneratedMessage {
        public static final int ADDRESS_FIELD_NUMBER = 4;
        public static final int PHONENAME_FIELD_NUMBER = 3;
        public static final int PHONENUM_FIELD_NUMBER = 2;
        public static final int STATE_FIELD_NUMBER = 1;
        private static final CarlifeBTHfpIndication defaultInstance = new CarlifeBTHfpIndication();
        private String address_;
        private boolean hasAddress;
        private boolean hasPhoneName;
        private boolean hasPhoneNum;
        private boolean hasState;
        private int memoizedSerializedSize;
        private String phoneName_;
        private String phoneNum_;
        private int state_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTHfpIndication result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTHfpIndication();
                return builder;
            }

            protected CarlifeBTHfpIndication internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTHfpIndication();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTHfpIndication.getDescriptor();
            }

            public CarlifeBTHfpIndication getDefaultInstanceForType() {
                return CarlifeBTHfpIndication.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTHfpIndication build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTHfpIndication buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTHfpIndication buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTHfpIndication returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTHfpIndication) {
                    return mergeFrom((CarlifeBTHfpIndication) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTHfpIndication other) {
                if (other != CarlifeBTHfpIndication.getDefaultInstance()) {
                    if (other.hasState()) {
                        setState(other.getState());
                    }
                    if (other.hasPhoneNum()) {
                        setPhoneNum(other.getPhoneNum());
                    }
                    if (other.hasPhoneName()) {
                        setPhoneName(other.getPhoneName());
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
                            setState(input.readInt32());
                            continue;
                        case 18:
                            setPhoneNum(input.readString());
                            continue;
                        case 26:
                            setPhoneName(input.readString());
                            continue;
                        case 34:
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
                this.result.phoneNum_ = CarlifeBTHfpIndication.getDefaultInstance().getPhoneNum();
                return this;
            }

            public boolean hasPhoneName() {
                return this.result.hasPhoneName();
            }

            public String getPhoneName() {
                return this.result.getPhoneName();
            }

            public Builder setPhoneName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasPhoneName = true;
                this.result.phoneName_ = value;
                return this;
            }

            public Builder clearPhoneName() {
                this.result.hasPhoneName = false;
                this.result.phoneName_ = CarlifeBTHfpIndication.getDefaultInstance().getPhoneName();
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
                this.result.address_ = CarlifeBTHfpIndication.getDefaultInstance().getAddress();
                return this;
            }
        }

        private CarlifeBTHfpIndication() {
            this.state_ = 0;
            this.phoneNum_ = "";
            this.phoneName_ = "";
            this.address_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTHfpIndicationProto.getDescriptor();
            CarlifeBTHfpIndicationProto.internalForceInit();
        }

        public static CarlifeBTHfpIndication getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTHfpIndication getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTHfpIndicationProto.f6585x8859cdae;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTHfpIndicationProto.f6586xd62f662c;
        }

        public boolean hasState() {
            return this.hasState;
        }

        public int getState() {
            return this.state_;
        }

        public boolean hasPhoneNum() {
            return this.hasPhoneNum;
        }

        public String getPhoneNum() {
            return this.phoneNum_;
        }

        public boolean hasPhoneName() {
            return this.hasPhoneName;
        }

        public String getPhoneName() {
            return this.phoneName_;
        }

        public boolean hasAddress() {
            return this.hasAddress;
        }

        public String getAddress() {
            return this.address_;
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
            if (hasPhoneNum()) {
                output.writeString(2, getPhoneNum());
            }
            if (hasPhoneName()) {
                output.writeString(3, getPhoneName());
            }
            if (hasAddress()) {
                output.writeString(4, getAddress());
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
            if (hasPhoneNum()) {
                size += CodedOutputStream.computeStringSize(2, getPhoneNum());
            }
            if (hasPhoneName()) {
                size += CodedOutputStream.computeStringSize(3, getPhoneName());
            }
            if (hasAddress()) {
                size += CodedOutputStream.computeStringSize(4, getAddress());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTHfpIndication parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpIndication parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTHfpIndication prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTHfpIndicationProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeBTHfpIndicationProto.proto\u0012\u001acom.baidu.carlife.protobuf\"]\n\u0016CarlifeBTHfpIndication\u0012\r\n\u0005state\u0018\u0001 \u0002(\u0005\u0012\u0010\n\bphoneNum\u0018\u0002 \u0001(\t\u0012\u0011\n\tphoneName\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007address\u0018\u0004 \u0001(\t"}, new FileDescriptor[0], new C20451());
    }

    public static void internalForceInit() {
    }
}
