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

public final class CarlifeTransferDataFinishProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeTransferDataFinish_descriptor;
    private static FieldAccessorTable internal_static_CarlifeTransferDataFinish_fieldAccessorTable;

    /* $1 */
    static class C20881 implements InternalDescriptorAssigner {
        C20881() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTransferDataFinishProto.descriptor = root;
            CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_descriptor = (Descriptor) CarlifeTransferDataFinishProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_fieldAccessorTable = new FieldAccessorTable(CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_descriptor, new String[]{"FileId"}, CarlifeTransferDataFinish.class, CarlifeTransferDataFinish.Builder.class);
            return null;
        }
    }

    public static final class CarlifeTransferDataFinish extends GeneratedMessage {
        public static final int FILEID_FIELD_NUMBER = 1;
        private static final CarlifeTransferDataFinish defaultInstance = new CarlifeTransferDataFinish();
        private int fileId_;
        private boolean hasFileId;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTransferDataFinish result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTransferDataFinish();
                return builder;
            }

            protected CarlifeTransferDataFinish internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTransferDataFinish();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTransferDataFinish.getDescriptor();
            }

            public CarlifeTransferDataFinish getDefaultInstanceForType() {
                return CarlifeTransferDataFinish.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTransferDataFinish build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTransferDataFinish buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTransferDataFinish buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTransferDataFinish returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTransferDataFinish) {
                    return mergeFrom((CarlifeTransferDataFinish) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTransferDataFinish other) {
                if (other != CarlifeTransferDataFinish.getDefaultInstance()) {
                    if (other.hasFileId()) {
                        setFileId(other.getFileId());
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
                            setFileId(input.readInt32());
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

            public boolean hasFileId() {
                return this.result.hasFileId();
            }

            public int getFileId() {
                return this.result.getFileId();
            }

            public Builder setFileId(int value) {
                this.result.hasFileId = true;
                this.result.fileId_ = value;
                return this;
            }

            public Builder clearFileId() {
                this.result.hasFileId = false;
                this.result.fileId_ = 0;
                return this;
            }
        }

        private CarlifeTransferDataFinish() {
            this.fileId_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTransferDataFinishProto.getDescriptor();
            CarlifeTransferDataFinishProto.internalForceInit();
        }

        public static CarlifeTransferDataFinish getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTransferDataFinish getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_fieldAccessorTable;
        }

        public boolean hasFileId() {
            return this.hasFileId;
        }

        public int getFileId() {
            return this.fileId_;
        }

        public final boolean isInitialized() {
            if (this.hasFileId) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasFileId()) {
                output.writeInt32(1, getFileId());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasFileId()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getFileId());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTransferDataFinish parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataFinish parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTransferDataFinish prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTransferDataFinishProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$CarlifeTransferDataFinishProto.proto\"+\n\u0019CarlifeTransferDataFinish\u0012\u000e\n\u0006fileId\u0018\u0001 \u0002(\u0005B\u001c\n\u001ame.objectyan.screensharing.protobuf"}, new FileDescriptor[0], new C20881());
    }

    public static void internalForceInit() {
    }
}
