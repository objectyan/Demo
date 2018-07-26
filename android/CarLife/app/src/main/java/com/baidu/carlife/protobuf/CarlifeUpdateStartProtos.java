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

public final class CarlifeUpdateStartProtos {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor;
    /* renamed from: internal_static_carlife_protobuf_CarlifeUpdateStart_fieldAccessorTable */
    private static FieldAccessorTable f6665x5393b92d;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeUpdateStartProtos$1 */
    static class C20971 implements InternalDescriptorAssigner {
        C20971() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeUpdateStartProtos.descriptor = root;
            CarlifeUpdateStartProtos.internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor = (Descriptor) CarlifeUpdateStartProtos.getDescriptor().getMessageTypes().get(0);
            CarlifeUpdateStartProtos.f6665x5393b92d = new FieldAccessorTable(CarlifeUpdateStartProtos.internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor, new String[]{"SupportFlag"}, CarlifeUpdateStart.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeUpdateStart extends GeneratedMessage {
        public static final int SUPPORTFLAG_FIELD_NUMBER = 1;
        private static final CarlifeUpdateStart defaultInstance = new CarlifeUpdateStart();
        private boolean hasSupportFlag;
        private int memoizedSerializedSize;
        private boolean supportFlag_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeUpdateStart result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeUpdateStart();
                return builder;
            }

            protected CarlifeUpdateStart internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeUpdateStart();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeUpdateStart.getDescriptor();
            }

            public CarlifeUpdateStart getDefaultInstanceForType() {
                return CarlifeUpdateStart.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeUpdateStart build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeUpdateStart buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeUpdateStart buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeUpdateStart returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeUpdateStart) {
                    return mergeFrom((CarlifeUpdateStart) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeUpdateStart other) {
                if (other != CarlifeUpdateStart.getDefaultInstance()) {
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

        private CarlifeUpdateStart() {
            this.supportFlag_ = false;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeUpdateStartProtos.getDescriptor();
            CarlifeUpdateStartProtos.internalForceInit();
        }

        public static CarlifeUpdateStart getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeUpdateStart getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeUpdateStartProtos.internal_static_carlife_protobuf_CarlifeUpdateStart_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeUpdateStartProtos.f6665x5393b92d;
        }

        public boolean hasSupportFlag() {
            return this.hasSupportFlag;
        }

        public boolean getSupportFlag() {
            return this.supportFlag_;
        }

        public final boolean isInitialized() {
            if (this.hasSupportFlag) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasSupportFlag()) {
                output.writeBool(1, getSupportFlag());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasSupportFlag()) {
                size = 0 + CodedOutputStream.computeBoolSize(1, getSupportFlag());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeUpdateStart parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeUpdateStart parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeUpdateStart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeUpdateStart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeUpdateStart prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeUpdateStartProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\fustart.proto\u0012\u0010carlife.protobuf\")\n\u0012CarlifeUpdateStart\u0012\u0013\n\u000bsupportFlag\u0018\u0001 \u0002(\bB6\n\u001acom.baidu.carlife.protobufB\u0018CarlifeUpdateStartProtos"}, new FileDescriptor[0], new C20971());
    }

    public static void internalForceInit() {
    }
}
