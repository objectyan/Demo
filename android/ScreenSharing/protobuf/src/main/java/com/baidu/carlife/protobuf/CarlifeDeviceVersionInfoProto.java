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

public final class CarlifeDeviceVersionInfoProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeDeviceVersionInfo_descriptor;
    private static FieldAccessorTable internal_static_CarlifeDeviceVersionInfo_fieldAccessorTable;

    /* renamed from: CarlifeDeviceVersionInfoProto$1 */
    static class C20611 implements InternalDescriptorAssigner {
        C20611() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeDeviceVersionInfoProto.descriptor = root;
            CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_descriptor = (Descriptor) CarlifeDeviceVersionInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_fieldAccessorTable = new FieldAccessorTable(CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_descriptor, new String[]{"DeviceName", "VersionCode"}, CarlifeDeviceVersionInfo.class, CarlifeDeviceVersionInfo.Builder.class);
            return null;
        }
    }

    public static final class CarlifeDeviceVersionInfo extends GeneratedMessage {
        public static final int DEVICENAME_FIELD_NUMBER = 1;
        public static final int VERSIONCODE_FIELD_NUMBER = 2;
        private static final CarlifeDeviceVersionInfo defaultInstance = new CarlifeDeviceVersionInfo();
        private String deviceName_;
        private boolean hasDeviceName;
        private boolean hasVersionCode;
        private int memoizedSerializedSize;
        private String versionCode_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeDeviceVersionInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeDeviceVersionInfo();
                return builder;
            }

            protected CarlifeDeviceVersionInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeDeviceVersionInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeDeviceVersionInfo.getDescriptor();
            }

            public CarlifeDeviceVersionInfo getDefaultInstanceForType() {
                return CarlifeDeviceVersionInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeDeviceVersionInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeDeviceVersionInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeDeviceVersionInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeDeviceVersionInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeDeviceVersionInfo) {
                    return mergeFrom((CarlifeDeviceVersionInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeDeviceVersionInfo other) {
                if (other != CarlifeDeviceVersionInfo.getDefaultInstance()) {
                    if (other.hasDeviceName()) {
                        setDeviceName(other.getDeviceName());
                    }
                    if (other.hasVersionCode()) {
                        setVersionCode(other.getVersionCode());
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
                            setDeviceName(input.readString());
                            continue;
                        case 18:
                            setVersionCode(input.readString());
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

            public boolean hasDeviceName() {
                return this.result.hasDeviceName();
            }

            public String getDeviceName() {
                return this.result.getDeviceName();
            }

            public Builder setDeviceName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceName = true;
                this.result.deviceName_ = value;
                return this;
            }

            public Builder clearDeviceName() {
                this.result.hasDeviceName = false;
                this.result.deviceName_ = CarlifeDeviceVersionInfo.getDefaultInstance().getDeviceName();
                return this;
            }

            public boolean hasVersionCode() {
                return this.result.hasVersionCode();
            }

            public String getVersionCode() {
                return this.result.getVersionCode();
            }

            public Builder setVersionCode(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasVersionCode = true;
                this.result.versionCode_ = value;
                return this;
            }

            public Builder clearVersionCode() {
                this.result.hasVersionCode = false;
                this.result.versionCode_ = CarlifeDeviceVersionInfo.getDefaultInstance().getVersionCode();
                return this;
            }
        }

        private CarlifeDeviceVersionInfo() {
            this.deviceName_ = "";
            this.versionCode_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeDeviceVersionInfoProto.getDescriptor();
            CarlifeDeviceVersionInfoProto.internalForceInit();
        }

        public static CarlifeDeviceVersionInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeDeviceVersionInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_fieldAccessorTable;
        }

        public boolean hasDeviceName() {
            return this.hasDeviceName;
        }

        public String getDeviceName() {
            return this.deviceName_;
        }

        public boolean hasVersionCode() {
            return this.hasVersionCode;
        }

        public String getVersionCode() {
            return this.versionCode_;
        }

        public final boolean isInitialized() {
            if (this.hasDeviceName && this.hasVersionCode) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasDeviceName()) {
                output.writeString(1, getDeviceName());
            }
            if (hasVersionCode()) {
                output.writeString(2, getVersionCode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasDeviceName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getDeviceName());
            }
            if (hasVersionCode()) {
                size += CodedOutputStream.computeStringSize(2, getVersionCode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeDeviceVersionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeDeviceVersionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeDeviceVersionInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeDeviceVersionInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#CarlifeDeviceVersionInfoProto.proto\"C\n\u0018CarlifeDeviceVersionInfo\u0012\u0012\n\ndeviceName\u0018\u0001 \u0002(\t\u0012\u0013\n\u000bversionCode\u0018\u0002 \u0002(\tB\u001c\n\u001acom.baidu.carlife.protobuf"}, new FileDescriptor[0], new C20611());
    }

    public static void internalForceInit() {
    }
}
