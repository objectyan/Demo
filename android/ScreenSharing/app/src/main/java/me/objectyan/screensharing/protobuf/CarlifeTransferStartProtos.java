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

public final class CarlifeTransferStartProtos {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_carlife_protobuf_CarlifeTransferStart_descriptor;
    /* _static_carlife_protobuf_CarlifeTransferStart_fieldAccessorTable */
    private static FieldAccessorTable f6664xe9c083cf;

    /* $1 */
    static class C20961 implements InternalDescriptorAssigner {
        C20961() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTransferStartProtos.descriptor = root;
            CarlifeTransferStartProtos.internal_static_carlife_protobuf_CarlifeTransferStart_descriptor = (Descriptor) CarlifeTransferStartProtos.getDescriptor().getMessageTypes().get(0);
            CarlifeTransferStartProtos.f6664xe9c083cf = new FieldAccessorTable(CarlifeTransferStartProtos.internal_static_carlife_protobuf_CarlifeTransferStart_descriptor, new String[]{"UpdateSize"}, CarlifeTransferStart.class, CarlifeTransferStart.Builder.class);
            return null;
        }
    }

    public static final class CarlifeTransferStart extends GeneratedMessage {
        public static final int UPDATESIZE_FIELD_NUMBER = 1;
        private static final CarlifeTransferStart defaultInstance = new CarlifeTransferStart();
        private boolean hasUpdateSize;
        private int memoizedSerializedSize;
        private int updateSize_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTransferStart result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTransferStart();
                return builder;
            }

            protected CarlifeTransferStart internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTransferStart();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTransferStart.getDescriptor();
            }

            public CarlifeTransferStart getDefaultInstanceForType() {
                return CarlifeTransferStart.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTransferStart build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTransferStart buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTransferStart buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTransferStart returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTransferStart) {
                    return mergeFrom((CarlifeTransferStart) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTransferStart other) {
                if (other != CarlifeTransferStart.getDefaultInstance()) {
                    if (other.hasUpdateSize()) {
                        setUpdateSize(other.getUpdateSize());
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
                            setUpdateSize(input.readInt32());
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

            public boolean hasUpdateSize() {
                return this.result.hasUpdateSize();
            }

            public int getUpdateSize() {
                return this.result.getUpdateSize();
            }

            public Builder setUpdateSize(int value) {
                this.result.hasUpdateSize = true;
                this.result.updateSize_ = value;
                return this;
            }

            public Builder clearUpdateSize() {
                this.result.hasUpdateSize = false;
                this.result.updateSize_ = 0;
                return this;
            }
        }

        private CarlifeTransferStart() {
            this.updateSize_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTransferStartProtos.getDescriptor();
            CarlifeTransferStartProtos.internalForceInit();
        }

        public static CarlifeTransferStart getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTransferStart getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTransferStartProtos.internal_static_carlife_protobuf_CarlifeTransferStart_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTransferStartProtos.f6664xe9c083cf;
        }

        public boolean hasUpdateSize() {
            return this.hasUpdateSize;
        }

        public int getUpdateSize() {
            return this.updateSize_;
        }

        public final boolean isInitialized() {
            if (this.hasUpdateSize) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasUpdateSize()) {
                output.writeInt32(1, getUpdateSize());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasUpdateSize()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getUpdateSize());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTransferStart parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferStart parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTransferStart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferStart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTransferStart prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTransferStartProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000bstart.proto\u0012\u0010carlife.protobuf\"*\n\u0014CarlifeTransferStart\u0012\u0012\n\nupdateSize\u0018\u0001 \u0002(\u0005B8\n\u001ame.objectyan.screensharing.protobufB\u001aCarlifeTransferStartProtos"}, new FileDescriptor[0], new C20961());
    }

    public static void internalForceInit() {
    }
}
