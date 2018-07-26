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

public final class CarlifeModuleStatusProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_descriptor */
    private static Descriptor f6635x776dfd14;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatus_fieldAccessorTable */
    private static FieldAccessorTable f6636x14e8cf92;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeModuleStatusProto$1 */
    static class C20721 implements InternalDescriptorAssigner {
        C20721() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeModuleStatusProto.descriptor = root;
            CarlifeModuleStatusProto.f6635x776dfd14 = (Descriptor) CarlifeModuleStatusProto.getDescriptor().getMessageTypes().get(0);
            CarlifeModuleStatusProto.f6636x14e8cf92 = new FieldAccessorTable(CarlifeModuleStatusProto.f6635x776dfd14, new String[]{"ModuleID", "StatusID"}, CarlifeModuleStatus.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeModuleStatus extends GeneratedMessage {
        public static final int MODULEID_FIELD_NUMBER = 1;
        public static final int STATUSID_FIELD_NUMBER = 2;
        private static final CarlifeModuleStatus defaultInstance = new CarlifeModuleStatus();
        private boolean hasModuleID;
        private boolean hasStatusID;
        private int memoizedSerializedSize;
        private int moduleID_;
        private int statusID_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeModuleStatus result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeModuleStatus();
                return builder;
            }

            protected CarlifeModuleStatus internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeModuleStatus();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeModuleStatus.getDescriptor();
            }

            public CarlifeModuleStatus getDefaultInstanceForType() {
                return CarlifeModuleStatus.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeModuleStatus build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeModuleStatus buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeModuleStatus buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeModuleStatus returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeModuleStatus) {
                    return mergeFrom((CarlifeModuleStatus) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeModuleStatus other) {
                if (other != CarlifeModuleStatus.getDefaultInstance()) {
                    if (other.hasModuleID()) {
                        setModuleID(other.getModuleID());
                    }
                    if (other.hasStatusID()) {
                        setStatusID(other.getStatusID());
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
                            setStatusID(input.readInt32());
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

            public boolean hasStatusID() {
                return this.result.hasStatusID();
            }

            public int getStatusID() {
                return this.result.getStatusID();
            }

            public Builder setStatusID(int value) {
                this.result.hasStatusID = true;
                this.result.statusID_ = value;
                return this;
            }

            public Builder clearStatusID() {
                this.result.hasStatusID = false;
                this.result.statusID_ = 0;
                return this;
            }
        }

        private CarlifeModuleStatus() {
            this.moduleID_ = 0;
            this.statusID_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeModuleStatusProto.getDescriptor();
            CarlifeModuleStatusProto.internalForceInit();
        }

        public static CarlifeModuleStatus getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeModuleStatus getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeModuleStatusProto.f6635x776dfd14;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeModuleStatusProto.f6636x14e8cf92;
        }

        public boolean hasModuleID() {
            return this.hasModuleID;
        }

        public int getModuleID() {
            return this.moduleID_;
        }

        public boolean hasStatusID() {
            return this.hasStatusID;
        }

        public int getStatusID() {
            return this.statusID_;
        }

        public final boolean isInitialized() {
            if (this.hasModuleID && this.hasStatusID) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasModuleID()) {
                output.writeInt32(1, getModuleID());
            }
            if (hasStatusID()) {
                output.writeInt32(2, getStatusID());
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
            if (hasStatusID()) {
                size += CodedOutputStream.computeInt32Size(2, getStatusID());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeModuleStatus parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatus parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeModuleStatus parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeModuleStatus parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeModuleStatus prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeModuleStatusProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eCarlifeModuleStatusProto.proto\u0012\u001acom.baidu.carlife.protobuf\"9\n\u0013CarlifeModuleStatus\u0012\u0010\n\bmoduleID\u0018\u0001 \u0002(\u0005\u0012\u0010\n\bstatusID\u0018\u0002 \u0002(\u0005"}, new FileDescriptor[0], new C20721());
    }

    public static void internalForceInit() {
    }
}
