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

public final class CarlifeTransferDataSendProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeTransferDataSend_descriptor;
    private static FieldAccessorTable internal_static_CarlifeTransferDataSend_fieldAccessorTable;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTransferDataSendProto$1 */
    static class C20891 implements InternalDescriptorAssigner {
        C20891() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTransferDataSendProto.descriptor = root;
            CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_descriptor = (Descriptor) CarlifeTransferDataSendProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_fieldAccessorTable = new FieldAccessorTable(CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_descriptor, new String[]{"FileId", "BodyData", "Len"}, CarlifeTransferDataSend.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTransferDataSend extends GeneratedMessage {
        public static final int BODYDATA_FIELD_NUMBER = 2;
        public static final int FILEID_FIELD_NUMBER = 1;
        public static final int LEN_FIELD_NUMBER = 3;
        private static final CarlifeTransferDataSend defaultInstance = new CarlifeTransferDataSend();
        private ByteString bodyData_;
        private int fileId_;
        private boolean hasBodyData;
        private boolean hasFileId;
        private boolean hasLen;
        private int len_;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTransferDataSend result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTransferDataSend();
                return builder;
            }

            protected CarlifeTransferDataSend internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTransferDataSend();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTransferDataSend.getDescriptor();
            }

            public CarlifeTransferDataSend getDefaultInstanceForType() {
                return CarlifeTransferDataSend.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTransferDataSend build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTransferDataSend buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTransferDataSend buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTransferDataSend returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTransferDataSend) {
                    return mergeFrom((CarlifeTransferDataSend) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTransferDataSend other) {
                if (other != CarlifeTransferDataSend.getDefaultInstance()) {
                    if (other.hasFileId()) {
                        setFileId(other.getFileId());
                    }
                    if (other.hasBodyData()) {
                        setBodyData(other.getBodyData());
                    }
                    if (other.hasLen()) {
                        setLen(other.getLen());
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
                        case 18:
                            setBodyData(input.readBytes());
                            continue;
                        case 24:
                            setLen(input.readInt32());
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

            public boolean hasBodyData() {
                return this.result.hasBodyData();
            }

            public ByteString getBodyData() {
                return this.result.getBodyData();
            }

            public Builder setBodyData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasBodyData = true;
                this.result.bodyData_ = value;
                return this;
            }

            public Builder clearBodyData() {
                this.result.hasBodyData = false;
                this.result.bodyData_ = CarlifeTransferDataSend.getDefaultInstance().getBodyData();
                return this;
            }

            public boolean hasLen() {
                return this.result.hasLen();
            }

            public int getLen() {
                return this.result.getLen();
            }

            public Builder setLen(int value) {
                this.result.hasLen = true;
                this.result.len_ = value;
                return this;
            }

            public Builder clearLen() {
                this.result.hasLen = false;
                this.result.len_ = 0;
                return this;
            }
        }

        private CarlifeTransferDataSend() {
            this.fileId_ = 0;
            this.bodyData_ = ByteString.EMPTY;
            this.len_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTransferDataSendProto.getDescriptor();
            CarlifeTransferDataSendProto.internalForceInit();
        }

        public static CarlifeTransferDataSend getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTransferDataSend getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_fieldAccessorTable;
        }

        public boolean hasFileId() {
            return this.hasFileId;
        }

        public int getFileId() {
            return this.fileId_;
        }

        public boolean hasBodyData() {
            return this.hasBodyData;
        }

        public ByteString getBodyData() {
            return this.bodyData_;
        }

        public boolean hasLen() {
            return this.hasLen;
        }

        public int getLen() {
            return this.len_;
        }

        public final boolean isInitialized() {
            if (this.hasFileId && this.hasBodyData && this.hasLen) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasFileId()) {
                output.writeInt32(1, getFileId());
            }
            if (hasBodyData()) {
                output.writeBytes(2, getBodyData());
            }
            if (hasLen()) {
                output.writeInt32(3, getLen());
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
            if (hasBodyData()) {
                size += CodedOutputStream.computeBytesSize(2, getBodyData());
            }
            if (hasLen()) {
                size += CodedOutputStream.computeInt32Size(3, getLen());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTransferDataSend parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataSend parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataSend parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataSend parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTransferDataSend prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTransferDataSendProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeTransferDataSendProto.proto\"H\n\u0017CarlifeTransferDataSend\u0012\u000e\n\u0006fileId\u0018\u0001 \u0002(\u0005\u0012\u0010\n\bbodyData\u0018\u0002 \u0002(\f\u0012\u000b\n\u0003len\u0018\u0003 \u0002(\u0005B\u001c\n\u001acom.baidu.carlife.protobuf"}, new FileDescriptor[0], new C20891());
    }

    public static void internalForceInit() {
    }
}
