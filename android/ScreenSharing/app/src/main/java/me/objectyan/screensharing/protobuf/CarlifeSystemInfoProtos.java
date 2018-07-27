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

public final class CarlifeSystemInfoProtos {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor;
    /* _static_carlife_protobuf_CarlifeSystemInfo_fieldAccessorTable */
    private static FieldAccessorTable f6653x22b44655;

    /* $1 */
    static class C20831 implements InternalDescriptorAssigner {
        C20831() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeSystemInfoProtos.descriptor = root;
            CarlifeSystemInfoProtos.internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor = (Descriptor) CarlifeSystemInfoProtos.getDescriptor().getMessageTypes().get(0);
            CarlifeSystemInfoProtos.f6653x22b44655 = new FieldAccessorTable(CarlifeSystemInfoProtos.internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor, new String[]{"FirmwareVersionCode", "UpdateUrl"}, CarlifeSystemInfo.class, CarlifeSystemInfo.Builder.class);
            return null;
        }
    }

    public static final class CarlifeSystemInfo extends GeneratedMessage {
        public static final int FIRMWAREVERSIONCODE_FIELD_NUMBER = 1;
        public static final int UPDATEURL_FIELD_NUMBER = 2;
        private static final CarlifeSystemInfo defaultInstance = new CarlifeSystemInfo();
        private int firmwareVersionCode_;
        private boolean hasFirmwareVersionCode;
        private boolean hasUpdateUrl;
        private int memoizedSerializedSize;
        private String updateUrl_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeSystemInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeSystemInfo();
                return builder;
            }

            protected CarlifeSystemInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeSystemInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeSystemInfo.getDescriptor();
            }

            public CarlifeSystemInfo getDefaultInstanceForType() {
                return CarlifeSystemInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeSystemInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeSystemInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeSystemInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeSystemInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeSystemInfo) {
                    return mergeFrom((CarlifeSystemInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeSystemInfo other) {
                if (other != CarlifeSystemInfo.getDefaultInstance()) {
                    if (other.hasFirmwareVersionCode()) {
                        setFirmwareVersionCode(other.getFirmwareVersionCode());
                    }
                    if (other.hasUpdateUrl()) {
                        setUpdateUrl(other.getUpdateUrl());
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
                            setFirmwareVersionCode(input.readInt32());
                            continue;
                        case 18:
                            setUpdateUrl(input.readString());
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

            public boolean hasFirmwareVersionCode() {
                return this.result.hasFirmwareVersionCode();
            }

            public int getFirmwareVersionCode() {
                return this.result.getFirmwareVersionCode();
            }

            public Builder setFirmwareVersionCode(int value) {
                this.result.hasFirmwareVersionCode = true;
                this.result.firmwareVersionCode_ = value;
                return this;
            }

            public Builder clearFirmwareVersionCode() {
                this.result.hasFirmwareVersionCode = false;
                this.result.firmwareVersionCode_ = 0;
                return this;
            }

            public boolean hasUpdateUrl() {
                return this.result.hasUpdateUrl();
            }

            public String getUpdateUrl() {
                return this.result.getUpdateUrl();
            }

            public Builder setUpdateUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasUpdateUrl = true;
                this.result.updateUrl_ = value;
                return this;
            }

            public Builder clearUpdateUrl() {
                this.result.hasUpdateUrl = false;
                this.result.updateUrl_ = CarlifeSystemInfo.getDefaultInstance().getUpdateUrl();
                return this;
            }
        }

        private CarlifeSystemInfo() {
            this.firmwareVersionCode_ = 0;
            this.updateUrl_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeSystemInfoProtos.getDescriptor();
            CarlifeSystemInfoProtos.internalForceInit();
        }

        public static CarlifeSystemInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeSystemInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeSystemInfoProtos.internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeSystemInfoProtos.f6653x22b44655;
        }

        public boolean hasFirmwareVersionCode() {
            return this.hasFirmwareVersionCode;
        }

        public int getFirmwareVersionCode() {
            return this.firmwareVersionCode_;
        }

        public boolean hasUpdateUrl() {
            return this.hasUpdateUrl;
        }

        public String getUpdateUrl() {
            return this.updateUrl_;
        }

        public final boolean isInitialized() {
            if (this.hasFirmwareVersionCode && this.hasUpdateUrl) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasFirmwareVersionCode()) {
                output.writeInt32(1, getFirmwareVersionCode());
            }
            if (hasUpdateUrl()) {
                output.writeString(2, getUpdateUrl());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasFirmwareVersionCode()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getFirmwareVersionCode());
            }
            if (hasUpdateUrl()) {
                size += CodedOutputStream.computeStringSize(2, getUpdateUrl());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeSystemInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeSystemInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeSystemInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeSystemInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeSystemInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeSystemInfoProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\tota.proto\u0012\u0010carlife.protobuf\"C\n\u0011CarlifeSystemInfo\u0012\u001b\n\u0013firmwareVersionCode\u0018\u0001 \u0002(\u0005\u0012\u0011\n\tupdateUrl\u0018\u0002 \u0002(\tB5\n\u001ame.objectyan.screensharing.protobufB\u0017CarlifeSystemInfoProtos"}, new FileDescriptor[0], new C20831());
    }

    public static void internalForceInit() {
    }
}
