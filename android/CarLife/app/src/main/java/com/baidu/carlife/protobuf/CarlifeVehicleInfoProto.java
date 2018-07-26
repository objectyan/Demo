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

public final class CarlifeVehicleInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_descriptor */
    private static Descriptor f6668xd6d0e10;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_fieldAccessorTable */
    private static FieldAccessorTable f6669x7635248e;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeVehicleInfoProto$1 */
    static class C20991 implements InternalDescriptorAssigner {
        C20991() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeVehicleInfoProto.descriptor = root;
            CarlifeVehicleInfoProto.f6668xd6d0e10 = (Descriptor) CarlifeVehicleInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeVehicleInfoProto.f6669x7635248e = new FieldAccessorTable(CarlifeVehicleInfoProto.f6668xd6d0e10, new String[]{"ModuleID", "Flag", "Frequency"}, CarlifeVehicleInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeVehicleInfo extends GeneratedMessage {
        public static final int FLAG_FIELD_NUMBER = 2;
        public static final int FREQUENCY_FIELD_NUMBER = 3;
        public static final int MODULEID_FIELD_NUMBER = 1;
        private static final CarlifeVehicleInfo defaultInstance = new CarlifeVehicleInfo();
        private int flag_;
        private int frequency_;
        private boolean hasFlag;
        private boolean hasFrequency;
        private boolean hasModuleID;
        private int memoizedSerializedSize;
        private int moduleID_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeVehicleInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeVehicleInfo();
                return builder;
            }

            protected CarlifeVehicleInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeVehicleInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeVehicleInfo.getDescriptor();
            }

            public CarlifeVehicleInfo getDefaultInstanceForType() {
                return CarlifeVehicleInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeVehicleInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeVehicleInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeVehicleInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeVehicleInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeVehicleInfo) {
                    return mergeFrom((CarlifeVehicleInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeVehicleInfo other) {
                if (other != CarlifeVehicleInfo.getDefaultInstance()) {
                    if (other.hasModuleID()) {
                        setModuleID(other.getModuleID());
                    }
                    if (other.hasFlag()) {
                        setFlag(other.getFlag());
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
                            setFlag(input.readInt32());
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

            public boolean hasFlag() {
                return this.result.hasFlag();
            }

            public int getFlag() {
                return this.result.getFlag();
            }

            public Builder setFlag(int value) {
                this.result.hasFlag = true;
                this.result.flag_ = value;
                return this;
            }

            public Builder clearFlag() {
                this.result.hasFlag = false;
                this.result.flag_ = 0;
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

        private CarlifeVehicleInfo() {
            this.moduleID_ = 0;
            this.flag_ = 0;
            this.frequency_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeVehicleInfoProto.getDescriptor();
            CarlifeVehicleInfoProto.internalForceInit();
        }

        public static CarlifeVehicleInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeVehicleInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeVehicleInfoProto.f6668xd6d0e10;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeVehicleInfoProto.f6669x7635248e;
        }

        public boolean hasModuleID() {
            return this.hasModuleID;
        }

        public int getModuleID() {
            return this.moduleID_;
        }

        public boolean hasFlag() {
            return this.hasFlag;
        }

        public int getFlag() {
            return this.flag_;
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
            if (hasFlag()) {
                output.writeInt32(2, getFlag());
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
            if (hasFlag()) {
                size += CodedOutputStream.computeInt32Size(2, getFlag());
            }
            if (hasFrequency()) {
                size += CodedOutputStream.computeInt32Size(3, getFrequency());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeVehicleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeVehicleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVehicleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeVehicleInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeVehicleInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCarlifeVehicleInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"G\n\u0012CarlifeVehicleInfo\u0012\u0010\n\bmoduleID\u0018\u0001 \u0002(\u0005\u0012\f\n\u0004flag\u0018\u0002 \u0001(\u0005\u0012\u0011\n\tfrequency\u0018\u0003 \u0001(\u0005"}, new FileDescriptor[0], new C20991());
    }

    public static void internalForceInit() {
    }
}
