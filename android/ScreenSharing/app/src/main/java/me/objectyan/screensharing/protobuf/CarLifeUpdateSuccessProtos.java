package me.objectyan.screensharing.protobuf;

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

public final class CarLifeUpdateSuccessProtos {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_carlife_protobuf_CarLifeUpdateSuccess_descriptor;
    /* _static_carlife_protobuf_CarLifeUpdateSuccess_fieldAccessorTable */
    private static FieldAccessorTable f6574xddd45f4c;

    /* $1 */
    static class C20381 implements InternalDescriptorAssigner {
        C20381() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarLifeUpdateSuccessProtos.descriptor = root;
            CarLifeUpdateSuccessProtos.internal_static_carlife_protobuf_CarLifeUpdateSuccess_descriptor = (Descriptor) CarLifeUpdateSuccessProtos.getDescriptor().getMessageTypes().get(0);
            CarLifeUpdateSuccessProtos.f6574xddd45f4c = new FieldAccessorTable(CarLifeUpdateSuccessProtos.internal_static_carlife_protobuf_CarLifeUpdateSuccess_descriptor, new String[]{"VersionCode", "SupportFlag"}, CarLifeUpdateSuccess.class, CarLifeUpdateSuccess.Builder.class);
            return null;
        }
    }

    public static final class CarLifeUpdateSuccess extends GeneratedMessage {
        public static final int SUPPORTFLAG_FIELD_NUMBER = 2;
        public static final int VERSIONCODE_FIELD_NUMBER = 1;
        private static final CarLifeUpdateSuccess defaultInstance = new CarLifeUpdateSuccess();
        private boolean hasSupportFlag;
        private boolean hasVersionCode;
        private int memoizedSerializedSize;
        private boolean supportFlag_;
        private int versionCode_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarLifeUpdateSuccess result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarLifeUpdateSuccess();
                return builder;
            }

            protected CarLifeUpdateSuccess internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarLifeUpdateSuccess();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarLifeUpdateSuccess.getDescriptor();
            }

            public CarLifeUpdateSuccess getDefaultInstanceForType() {
                return CarLifeUpdateSuccess.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarLifeUpdateSuccess build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarLifeUpdateSuccess buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarLifeUpdateSuccess buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarLifeUpdateSuccess returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarLifeUpdateSuccess) {
                    return mergeFrom((CarLifeUpdateSuccess) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarLifeUpdateSuccess other) {
                if (other != CarLifeUpdateSuccess.getDefaultInstance()) {
                    if (other.hasVersionCode()) {
                        setVersionCode(other.getVersionCode());
                    }
                    if (other.hasSupportFlag()) {
                        setSupportFlag(other.getSupportFlag());
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
                            setVersionCode(input.readInt32());
                            continue;
                        case 16:
                            setSupportFlag(input.readBool());
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

            public boolean hasVersionCode() {
                return this.result.hasVersionCode();
            }

            public int getVersionCode() {
                return this.result.getVersionCode();
            }

            public Builder setVersionCode(int value) {
                this.result.hasVersionCode = true;
                this.result.versionCode_ = value;
                return this;
            }

            public Builder clearVersionCode() {
                this.result.hasVersionCode = false;
                this.result.versionCode_ = 0;
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
        }

        private CarLifeUpdateSuccess() {
            this.versionCode_ = 0;
            this.supportFlag_ = false;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarLifeUpdateSuccessProtos.getDescriptor();
            CarLifeUpdateSuccessProtos.internalForceInit();
        }

        public static CarLifeUpdateSuccess getDefaultInstance() {
            return defaultInstance;
        }

        public CarLifeUpdateSuccess getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarLifeUpdateSuccessProtos.internal_static_carlife_protobuf_CarLifeUpdateSuccess_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarLifeUpdateSuccessProtos.f6574xddd45f4c;
        }

        public boolean hasVersionCode() {
            return this.hasVersionCode;
        }

        public int getVersionCode() {
            return this.versionCode_;
        }

        public boolean hasSupportFlag() {
            return this.hasSupportFlag;
        }

        public boolean getSupportFlag() {
            return this.supportFlag_;
        }

        public final boolean isInitialized() {
            if (this.hasVersionCode && this.hasSupportFlag) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasVersionCode()) {
                output.writeInt32(1, getVersionCode());
            }
            if (hasSupportFlag()) {
                output.writeBool(2, getSupportFlag());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasVersionCode()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getVersionCode());
            }
            if (hasSupportFlag()) {
                size += CodedOutputStream.computeBoolSize(2, getSupportFlag());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarLifeUpdateSuccess parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarLifeUpdateSuccess parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarLifeUpdateSuccess prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarLifeUpdateSuccessProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eusuccess.proto\u0012\u0010carlife.protobuf\"@\n\u0014CarLifeUpdateSuccess\u0012\u0013\n\u000bversionCode\u0018\u0001 \u0002(\u0005\u0012\u0013\n\u000bsupportFlag\u0018\u0002 \u0002(\bB8\n\u001ame.objectyan.screensharing.protobufB\u001aCarLifeUpdateSuccessProtos"}, new FileDescriptor[0], new C20381());
    }

    public static void internalForceInit() {
    }
}
