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

public final class CarlifeProtocolVersionProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor */
    private static Descriptor f6645x5424e32a;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_fieldAccessorTable */
    private static FieldAccessorTable f6646x153b3fa8;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeProtocolVersionProto$1 */
    static class C20771 implements InternalDescriptorAssigner {
        C20771() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeProtocolVersionProto.descriptor = root;
            CarlifeProtocolVersionProto.f6645x5424e32a = (Descriptor) CarlifeProtocolVersionProto.getDescriptor().getMessageTypes().get(0);
            CarlifeProtocolVersionProto.f6646x153b3fa8 = new FieldAccessorTable(CarlifeProtocolVersionProto.f6645x5424e32a, new String[]{"MajorVersion", "MinorVersion"}, CarlifeProtocolVersion.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeProtocolVersion extends GeneratedMessage {
        public static final int MAJORVERSION_FIELD_NUMBER = 1;
        public static final int MINORVERSION_FIELD_NUMBER = 2;
        private static final CarlifeProtocolVersion defaultInstance = new CarlifeProtocolVersion();
        private boolean hasMajorVersion;
        private boolean hasMinorVersion;
        private int majorVersion_;
        private int memoizedSerializedSize;
        private int minorVersion_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeProtocolVersion result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeProtocolVersion();
                return builder;
            }

            protected CarlifeProtocolVersion internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeProtocolVersion();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeProtocolVersion.getDescriptor();
            }

            public CarlifeProtocolVersion getDefaultInstanceForType() {
                return CarlifeProtocolVersion.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeProtocolVersion build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeProtocolVersion buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeProtocolVersion buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeProtocolVersion returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeProtocolVersion) {
                    return mergeFrom((CarlifeProtocolVersion) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeProtocolVersion other) {
                if (other != CarlifeProtocolVersion.getDefaultInstance()) {
                    if (other.hasMajorVersion()) {
                        setMajorVersion(other.getMajorVersion());
                    }
                    if (other.hasMinorVersion()) {
                        setMinorVersion(other.getMinorVersion());
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
                            setMajorVersion(input.readInt32());
                            continue;
                        case 16:
                            setMinorVersion(input.readInt32());
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

            public boolean hasMajorVersion() {
                return this.result.hasMajorVersion();
            }

            public int getMajorVersion() {
                return this.result.getMajorVersion();
            }

            public Builder setMajorVersion(int value) {
                this.result.hasMajorVersion = true;
                this.result.majorVersion_ = value;
                return this;
            }

            public Builder clearMajorVersion() {
                this.result.hasMajorVersion = false;
                this.result.majorVersion_ = 0;
                return this;
            }

            public boolean hasMinorVersion() {
                return this.result.hasMinorVersion();
            }

            public int getMinorVersion() {
                return this.result.getMinorVersion();
            }

            public Builder setMinorVersion(int value) {
                this.result.hasMinorVersion = true;
                this.result.minorVersion_ = value;
                return this;
            }

            public Builder clearMinorVersion() {
                this.result.hasMinorVersion = false;
                this.result.minorVersion_ = 0;
                return this;
            }
        }

        private CarlifeProtocolVersion() {
            this.majorVersion_ = 0;
            this.minorVersion_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeProtocolVersionProto.getDescriptor();
            CarlifeProtocolVersionProto.internalForceInit();
        }

        public static CarlifeProtocolVersion getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeProtocolVersion getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeProtocolVersionProto.f6645x5424e32a;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeProtocolVersionProto.f6646x153b3fa8;
        }

        public boolean hasMajorVersion() {
            return this.hasMajorVersion;
        }

        public int getMajorVersion() {
            return this.majorVersion_;
        }

        public boolean hasMinorVersion() {
            return this.hasMinorVersion;
        }

        public int getMinorVersion() {
            return this.minorVersion_;
        }

        public final boolean isInitialized() {
            if (this.hasMajorVersion && this.hasMinorVersion) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasMajorVersion()) {
                output.writeInt32(1, getMajorVersion());
            }
            if (hasMinorVersion()) {
                output.writeInt32(2, getMinorVersion());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasMajorVersion()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getMajorVersion());
            }
            if (hasMinorVersion()) {
                size += CodedOutputStream.computeInt32Size(2, getMinorVersion());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeProtocolVersion parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersion parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeProtocolVersion parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeProtocolVersion parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeProtocolVersion prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeProtocolVersionProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeProtocolVersionProto.proto\u0012\u001acom.baidu.carlife.protobuf\"D\n\u0016CarlifeProtocolVersion\u0012\u0014\n\fmajorVersion\u0018\u0001 \u0002(\u0005\u0012\u0014\n\fminorVersion\u0018\u0002 \u0002(\u0005"}, new FileDescriptor[0], new C20771());
    }

    public static void internalForceInit() {
    }
}
