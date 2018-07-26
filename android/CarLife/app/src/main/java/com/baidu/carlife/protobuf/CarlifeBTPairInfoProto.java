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

public final class CarlifeBTPairInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_descriptor */
    private static Descriptor f6597xfddefd18;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTPairInfo_fieldAccessorTable */
    private static FieldAccessorTable f6598xeb6b8b96;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTPairInfoProto$1 */
    static class C20511 implements InternalDescriptorAssigner {
        C20511() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTPairInfoProto.descriptor = root;
            CarlifeBTPairInfoProto.f6597xfddefd18 = (Descriptor) CarlifeBTPairInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTPairInfoProto.f6598xeb6b8b96 = new FieldAccessorTable(CarlifeBTPairInfoProto.f6597xfddefd18, new String[]{JNISearchConst.JNI_ADDRESS, "PassKey", "Hash", "Randomizer", "Uuid", "Name", "Status"}, CarlifeBTPairInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTPairInfo extends GeneratedMessage {
        public static final int ADDRESS_FIELD_NUMBER = 1;
        public static final int HASH_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 6;
        public static final int PASSKEY_FIELD_NUMBER = 2;
        public static final int RANDOMIZER_FIELD_NUMBER = 4;
        public static final int STATUS_FIELD_NUMBER = 7;
        public static final int UUID_FIELD_NUMBER = 5;
        private static final CarlifeBTPairInfo defaultInstance = new CarlifeBTPairInfo();
        private String address_;
        private boolean hasAddress;
        private boolean hasHash;
        private boolean hasName;
        private boolean hasPassKey;
        private boolean hasRandomizer;
        private boolean hasStatus;
        private boolean hasUuid;
        private String hash_;
        private int memoizedSerializedSize;
        private String name_;
        private String passKey_;
        private String randomizer_;
        private int status_;
        private String uuid_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTPairInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTPairInfo();
                return builder;
            }

            protected CarlifeBTPairInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTPairInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTPairInfo.getDescriptor();
            }

            public CarlifeBTPairInfo getDefaultInstanceForType() {
                return CarlifeBTPairInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTPairInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTPairInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTPairInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTPairInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTPairInfo) {
                    return mergeFrom((CarlifeBTPairInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTPairInfo other) {
                if (other != CarlifeBTPairInfo.getDefaultInstance()) {
                    if (other.hasAddress()) {
                        setAddress(other.getAddress());
                    }
                    if (other.hasPassKey()) {
                        setPassKey(other.getPassKey());
                    }
                    if (other.hasHash()) {
                        setHash(other.getHash());
                    }
                    if (other.hasRandomizer()) {
                        setRandomizer(other.getRandomizer());
                    }
                    if (other.hasUuid()) {
                        setUuid(other.getUuid());
                    }
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasStatus()) {
                        setStatus(other.getStatus());
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
                        case 18:
                            setPassKey(input.readString());
                            continue;
                        case 26:
                            setHash(input.readString());
                            continue;
                        case 34:
                            setRandomizer(input.readString());
                            continue;
                        case 42:
                            setUuid(input.readString());
                            continue;
                        case 50:
                            setName(input.readString());
                            continue;
                        case 56:
                            setStatus(input.readInt32());
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
                this.result.address_ = CarlifeBTPairInfo.getDefaultInstance().getAddress();
                return this;
            }

            public boolean hasPassKey() {
                return this.result.hasPassKey();
            }

            public String getPassKey() {
                return this.result.getPassKey();
            }

            public Builder setPassKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasPassKey = true;
                this.result.passKey_ = value;
                return this;
            }

            public Builder clearPassKey() {
                this.result.hasPassKey = false;
                this.result.passKey_ = CarlifeBTPairInfo.getDefaultInstance().getPassKey();
                return this;
            }

            public boolean hasHash() {
                return this.result.hasHash();
            }

            public String getHash() {
                return this.result.getHash();
            }

            public Builder setHash(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasHash = true;
                this.result.hash_ = value;
                return this;
            }

            public Builder clearHash() {
                this.result.hasHash = false;
                this.result.hash_ = CarlifeBTPairInfo.getDefaultInstance().getHash();
                return this;
            }

            public boolean hasRandomizer() {
                return this.result.hasRandomizer();
            }

            public String getRandomizer() {
                return this.result.getRandomizer();
            }

            public Builder setRandomizer(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasRandomizer = true;
                this.result.randomizer_ = value;
                return this;
            }

            public Builder clearRandomizer() {
                this.result.hasRandomizer = false;
                this.result.randomizer_ = CarlifeBTPairInfo.getDefaultInstance().getRandomizer();
                return this;
            }

            public boolean hasUuid() {
                return this.result.hasUuid();
            }

            public String getUuid() {
                return this.result.getUuid();
            }

            public Builder setUuid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasUuid = true;
                this.result.uuid_ = value;
                return this;
            }

            public Builder clearUuid() {
                this.result.hasUuid = false;
                this.result.uuid_ = CarlifeBTPairInfo.getDefaultInstance().getUuid();
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
                this.result.name_ = CarlifeBTPairInfo.getDefaultInstance().getName();
                return this;
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
        }

        private CarlifeBTPairInfo() {
            this.address_ = "";
            this.passKey_ = "";
            this.hash_ = "";
            this.randomizer_ = "";
            this.uuid_ = "";
            this.name_ = "";
            this.status_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTPairInfoProto.getDescriptor();
            CarlifeBTPairInfoProto.internalForceInit();
        }

        public static CarlifeBTPairInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTPairInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTPairInfoProto.f6597xfddefd18;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTPairInfoProto.f6598xeb6b8b96;
        }

        public boolean hasAddress() {
            return this.hasAddress;
        }

        public String getAddress() {
            return this.address_;
        }

        public boolean hasPassKey() {
            return this.hasPassKey;
        }

        public String getPassKey() {
            return this.passKey_;
        }

        public boolean hasHash() {
            return this.hasHash;
        }

        public String getHash() {
            return this.hash_;
        }

        public boolean hasRandomizer() {
            return this.hasRandomizer;
        }

        public String getRandomizer() {
            return this.randomizer_;
        }

        public boolean hasUuid() {
            return this.hasUuid;
        }

        public String getUuid() {
            return this.uuid_;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public boolean hasStatus() {
            return this.hasStatus;
        }

        public int getStatus() {
            return this.status_;
        }

        public final boolean isInitialized() {
            if (this.hasAddress && this.hasUuid && this.hasName && this.hasStatus) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAddress()) {
                output.writeString(1, getAddress());
            }
            if (hasPassKey()) {
                output.writeString(2, getPassKey());
            }
            if (hasHash()) {
                output.writeString(3, getHash());
            }
            if (hasRandomizer()) {
                output.writeString(4, getRandomizer());
            }
            if (hasUuid()) {
                output.writeString(5, getUuid());
            }
            if (hasName()) {
                output.writeString(6, getName());
            }
            if (hasStatus()) {
                output.writeInt32(7, getStatus());
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
            if (hasPassKey()) {
                size += CodedOutputStream.computeStringSize(2, getPassKey());
            }
            if (hasHash()) {
                size += CodedOutputStream.computeStringSize(3, getHash());
            }
            if (hasRandomizer()) {
                size += CodedOutputStream.computeStringSize(4, getRandomizer());
            }
            if (hasUuid()) {
                size += CodedOutputStream.computeStringSize(5, getUuid());
            }
            if (hasName()) {
                size += CodedOutputStream.computeStringSize(6, getName());
            }
            if (hasStatus()) {
                size += CodedOutputStream.computeInt32Size(7, getStatus());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTPairInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTPairInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTPairInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTPairInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTPairInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTPairInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cCarlifeBTPairInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"\u0001\n\u0011CarlifeBTPairInfo\u0012\u000f\n\u0007address\u0018\u0001 \u0002(\t\u0012\u000f\n\u0007passKey\u0018\u0002 \u0001(\t\u0012\f\n\u0004hash\u0018\u0003 \u0001(\t\u0012\u0012\n\nrandomizer\u0018\u0004 \u0001(\t\u0012\f\n\u0004uuid\u0018\u0005 \u0002(\t\u0012\f\n\u0004name\u0018\u0006 \u0002(\t\u0012\u000e\n\u0006status\u0018\u0007 \u0002(\u0005"}, new FileDescriptor[0], new C20511());
    }

    public static void internalForceInit() {
    }
}
