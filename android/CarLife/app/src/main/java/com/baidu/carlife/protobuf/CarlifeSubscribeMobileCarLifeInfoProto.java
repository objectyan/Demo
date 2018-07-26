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

public final class CarlifeSubscribeMobileCarLifeInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_descriptor */
    private static Descriptor f6651xe324ab80;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_fieldAccessorTable */
    private static FieldAccessorTable f6652x7af051fe;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto$1 */
    static class C20821 implements InternalDescriptorAssigner {
        C20821() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeSubscribeMobileCarLifeInfoProto.descriptor = root;
            CarlifeSubscribeMobileCarLifeInfoProto.f6651xe324ab80 = (Descriptor) CarlifeSubscribeMobileCarLifeInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeSubscribeMobileCarLifeInfoProto.f6652x7af051fe = new FieldAccessorTable(CarlifeSubscribeMobileCarLifeInfoProto.f6651xe324ab80, new String[]{"ModuleID", "SupportFlag", "Frequency"}, CarlifeSubscribeMobileCarLifeInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeSubscribeMobileCarLifeInfo extends GeneratedMessage {
        public static final int FREQUENCY_FIELD_NUMBER = 3;
        public static final int MODULEID_FIELD_NUMBER = 1;
        public static final int SUPPORTFLAG_FIELD_NUMBER = 2;
        private static final CarlifeSubscribeMobileCarLifeInfo defaultInstance = new CarlifeSubscribeMobileCarLifeInfo();
        private int frequency_;
        private boolean hasFrequency;
        private boolean hasModuleID;
        private boolean hasSupportFlag;
        private int memoizedSerializedSize;
        private int moduleID_;
        private boolean supportFlag_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeSubscribeMobileCarLifeInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeSubscribeMobileCarLifeInfo();
                return builder;
            }

            protected CarlifeSubscribeMobileCarLifeInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeSubscribeMobileCarLifeInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeSubscribeMobileCarLifeInfo.getDescriptor();
            }

            public CarlifeSubscribeMobileCarLifeInfo getDefaultInstanceForType() {
                return CarlifeSubscribeMobileCarLifeInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeSubscribeMobileCarLifeInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeSubscribeMobileCarLifeInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeSubscribeMobileCarLifeInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeSubscribeMobileCarLifeInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeSubscribeMobileCarLifeInfo) {
                    return mergeFrom((CarlifeSubscribeMobileCarLifeInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeSubscribeMobileCarLifeInfo other) {
                if (other != CarlifeSubscribeMobileCarLifeInfo.getDefaultInstance()) {
                    if (other.hasModuleID()) {
                        setModuleID(other.getModuleID());
                    }
                    if (other.hasSupportFlag()) {
                        setSupportFlag(other.getSupportFlag());
                    }
                    if (other.hasFrequency()) {
                        setFrequency(other.getFrequency());
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
                            setModuleID(input.readInt32());
                            continue;
                        case 16:
                            setSupportFlag(input.readBool());
                            continue;
                        case 24:
                            setFrequency(input.readInt32());
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

            public boolean hasModuleID() {
                return this.result.hasModuleID();
            }

            public int getModuleID() {
                return this.result.getModuleID();
            }

            public Builder setModuleID(int value) {
                this.result.hasModuleID = true;
                this.result.moduleID_ = value;
                return this;
            }

            public Builder clearModuleID() {
                this.result.hasModuleID = false;
                this.result.moduleID_ = 0;
                return this;
            }

            public boolean hasSupportFlag() {
                return this.result.hasSupportFlag();
            }

            public boolean getSupportFlag() {
                return this.result.getSupportFlag();
            }

            public Builder setSupportFlag(boolean value) {
                this.result.hasSupportFlag = true;
                this.result.supportFlag_ = value;
                return this;
            }

            public Builder clearSupportFlag() {
                this.result.hasSupportFlag = false;
                this.result.supportFlag_ = false;
                return this;
            }

            public boolean hasFrequency() {
                return this.result.hasFrequency();
            }

            public int getFrequency() {
                return this.result.getFrequency();
            }

            public Builder setFrequency(int value) {
                this.result.hasFrequency = true;
                this.result.frequency_ = value;
                return this;
            }

            public Builder clearFrequency() {
                this.result.hasFrequency = false;
                this.result.frequency_ = 0;
                return this;
            }
        }

        private CarlifeSubscribeMobileCarLifeInfo() {
            this.moduleID_ = 0;
            this.supportFlag_ = false;
            this.frequency_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeSubscribeMobileCarLifeInfoProto.getDescriptor();
            CarlifeSubscribeMobileCarLifeInfoProto.internalForceInit();
        }

        public static CarlifeSubscribeMobileCarLifeInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeSubscribeMobileCarLifeInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeSubscribeMobileCarLifeInfoProto.f6651xe324ab80;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeSubscribeMobileCarLifeInfoProto.f6652x7af051fe;
        }

        public boolean hasModuleID() {
            return this.hasModuleID;
        }

        public int getModuleID() {
            return this.moduleID_;
        }

        public boolean hasSupportFlag() {
            return this.hasSupportFlag;
        }

        public boolean getSupportFlag() {
            return this.supportFlag_;
        }

        public boolean hasFrequency() {
            return this.hasFrequency;
        }

        public int getFrequency() {
            return this.frequency_;
        }

        public final boolean isInitialized() {
            if (this.hasModuleID) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasModuleID()) {
                output.writeInt32(1, getModuleID());
            }
            if (hasSupportFlag()) {
                output.writeBool(2, getSupportFlag());
            }
            if (hasFrequency()) {
                output.writeInt32(3, getFrequency());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasModuleID()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getModuleID());
            }
            if (hasSupportFlag()) {
                size += CodedOutputStream.computeBoolSize(2, getSupportFlag());
            }
            if (hasFrequency()) {
                size += CodedOutputStream.computeInt32Size(3, getFrequency());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeSubscribeMobileCarLifeInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeSubscribeMobileCarLifeInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n,CarlifeSubscribeMobileCarLifeInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"]\n!CarlifeSubscribeMobileCarLifeInfo\u0012\u0010\n\bmoduleID\u0018\u0001 \u0002(\u0005\u0012\u0013\n\u000bsupportFlag\u0018\u0002 \u0001(\b\u0012\u0011\n\tfrequency\u0018\u0003 \u0001(\u0005"}, new FileDescriptor[0], new C20821());
    }

    public static void internalForceInit() {
    }
}
