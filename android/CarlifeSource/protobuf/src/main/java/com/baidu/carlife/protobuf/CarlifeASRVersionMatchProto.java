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

public final class CarlifeASRVersionMatchProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeASRVersionMatch_descriptor;
    private static FieldAccessorTable internal_static_CarlifeASRVersionMatch_fieldAccessorTable;

    /* renamed from: CarlifeASRVersionMatchProto$1 */
    static class C20391 implements InternalDescriptorAssigner {
        C20391() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeASRVersionMatchProto.descriptor = root;
            CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_descriptor = (Descriptor) CarlifeASRVersionMatchProto.getDescriptor().getMessageTypes().get(0);
            CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_fieldAccessorTable = new FieldAccessorTable(CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_descriptor, new String[]{"AsrName", "VersionCode"}, CarlifeASRVersionMatch.class, CarlifeASRVersionMatch.Builder.class);
            return null;
        }
    }

    public static final class CarlifeASRVersionMatch extends GeneratedMessage {
        public static final int ASRNAME_FIELD_NUMBER = 1;
        public static final int VERSIONCODE_FIELD_NUMBER = 2;
        private static final CarlifeASRVersionMatch defaultInstance = new CarlifeASRVersionMatch();
        private String asrName_;
        private boolean hasAsrName;
        private boolean hasVersionCode;
        private int memoizedSerializedSize;
        private int versionCode_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeASRVersionMatch result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeASRVersionMatch();
                return builder;
            }

            protected CarlifeASRVersionMatch internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeASRVersionMatch();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeASRVersionMatch.getDescriptor();
            }

            public CarlifeASRVersionMatch getDefaultInstanceForType() {
                return CarlifeASRVersionMatch.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeASRVersionMatch build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeASRVersionMatch buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeASRVersionMatch buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeASRVersionMatch returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeASRVersionMatch) {
                    return mergeFrom((CarlifeASRVersionMatch) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeASRVersionMatch other) {
                if (other != CarlifeASRVersionMatch.getDefaultInstance()) {
                    if (other.hasAsrName()) {
                        setAsrName(other.getAsrName());
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
                            setAsrName(input.readString());
                            continue;
                        case 16:
                            setVersionCode(input.readInt32());
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

            public boolean hasAsrName() {
                return this.result.hasAsrName();
            }

            public String getAsrName() {
                return this.result.getAsrName();
            }

            public Builder setAsrName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasAsrName = true;
                this.result.asrName_ = value;
                return this;
            }

            public Builder clearAsrName() {
                this.result.hasAsrName = false;
                this.result.asrName_ = CarlifeASRVersionMatch.getDefaultInstance().getAsrName();
                return this;
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
        }

        private CarlifeASRVersionMatch() {
            this.asrName_ = "";
            this.versionCode_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeASRVersionMatchProto.getDescriptor();
            CarlifeASRVersionMatchProto.internalForceInit();
        }

        public static CarlifeASRVersionMatch getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeASRVersionMatch getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_fieldAccessorTable;
        }

        public boolean hasAsrName() {
            return this.hasAsrName;
        }

        public String getAsrName() {
            return this.asrName_;
        }

        public boolean hasVersionCode() {
            return this.hasVersionCode;
        }

        public int getVersionCode() {
            return this.versionCode_;
        }

        public final boolean isInitialized() {
            if (this.hasAsrName && this.hasVersionCode) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAsrName()) {
                output.writeString(1, getAsrName());
            }
            if (hasVersionCode()) {
                output.writeInt32(2, getVersionCode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAsrName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getAsrName());
            }
            if (hasVersionCode()) {
                size += CodedOutputStream.computeInt32Size(2, getVersionCode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeASRVersionMatch parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeASRVersionMatch parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeASRVersionMatch prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeASRVersionMatchProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeASRVersionMatchProto.proto\">\n\u0016CarlifeASRVersionMatch\u0012\u000f\n\u0007asrName\u0018\u0001 \u0002(\t\u0012\u0013\n\u000bversionCode\u0018\u0002 \u0002(\u0005B\u001c\n\u001acom.baidu.carlife.protobuf"}, new FileDescriptor[0], new C20391());
    }

    public static void internalForceInit() {
    }
}
