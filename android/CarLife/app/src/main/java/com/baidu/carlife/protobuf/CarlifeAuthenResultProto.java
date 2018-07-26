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

public final class CarlifeAuthenResultProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_descriptor */
    private static Descriptor f6581xc438b8c4;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResult_fieldAccessorTable */
    private static FieldAccessorTable f6582xe3d4db42;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeAuthenResultProto$1 */
    static class C20431 implements InternalDescriptorAssigner {
        C20431() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeAuthenResultProto.descriptor = root;
            CarlifeAuthenResultProto.f6581xc438b8c4 = (Descriptor) CarlifeAuthenResultProto.getDescriptor().getMessageTypes().get(0);
            CarlifeAuthenResultProto.f6582xe3d4db42 = new FieldAccessorTable(CarlifeAuthenResultProto.f6581xc438b8c4, new String[]{"AuthenResult"}, CarlifeAuthenResult.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeAuthenResult extends GeneratedMessage {
        public static final int AUTHENRESULT_FIELD_NUMBER = 1;
        private static final CarlifeAuthenResult defaultInstance = new CarlifeAuthenResult();
        private boolean authenResult_;
        private boolean hasAuthenResult;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeAuthenResult result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeAuthenResult();
                return builder;
            }

            protected CarlifeAuthenResult internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeAuthenResult();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeAuthenResult.getDescriptor();
            }

            public CarlifeAuthenResult getDefaultInstanceForType() {
                return CarlifeAuthenResult.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeAuthenResult build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeAuthenResult buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeAuthenResult buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeAuthenResult returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeAuthenResult) {
                    return mergeFrom((CarlifeAuthenResult) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeAuthenResult other) {
                if (other != CarlifeAuthenResult.getDefaultInstance()) {
                    if (other.hasAuthenResult()) {
                        setAuthenResult(other.getAuthenResult());
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
                            setAuthenResult(input.readBool());
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

            public boolean hasAuthenResult() {
                return this.result.hasAuthenResult();
            }

            public boolean getAuthenResult() {
                return this.result.getAuthenResult();
            }

            public Builder setAuthenResult(boolean value) {
                this.result.hasAuthenResult = true;
                this.result.authenResult_ = value;
                return this;
            }

            public Builder clearAuthenResult() {
                this.result.hasAuthenResult = false;
                this.result.authenResult_ = false;
                return this;
            }
        }

        private CarlifeAuthenResult() {
            this.authenResult_ = false;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeAuthenResultProto.getDescriptor();
            CarlifeAuthenResultProto.internalForceInit();
        }

        public static CarlifeAuthenResult getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeAuthenResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeAuthenResultProto.f6581xc438b8c4;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeAuthenResultProto.f6582xe3d4db42;
        }

        public boolean hasAuthenResult() {
            return this.hasAuthenResult;
        }

        public boolean getAuthenResult() {
            return this.authenResult_;
        }

        public final boolean isInitialized() {
            if (this.hasAuthenResult) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAuthenResult()) {
                output.writeBool(1, getAuthenResult());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAuthenResult()) {
                size = 0 + CodedOutputStream.computeBoolSize(1, getAuthenResult());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeAuthenResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResult parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeAuthenResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAuthenResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeAuthenResult prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeAuthenResultProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eCarlifeAuthenResultProto.proto\u0012\u001acom.baidu.carlife.protobuf\"+\n\u0013CarlifeAuthenResult\u0012\u0014\n\fauthenResult\u0018\u0001 \u0002(\b"}, new FileDescriptor[0], new C20431());
    }

    public static void internalForceInit() {
    }
}
