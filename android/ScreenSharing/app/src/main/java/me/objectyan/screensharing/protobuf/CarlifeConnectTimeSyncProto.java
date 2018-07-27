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

public final class CarlifeConnectTimeSyncProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeConnectTimeSync_descriptor;
    private static FieldAccessorTable internal_static_CarlifeConnectTimeSync_fieldAccessorTable;

    /* $1 */
    static class C20591 implements InternalDescriptorAssigner {
        C20591() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeConnectTimeSyncProto.descriptor = root;
            CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_descriptor = (Descriptor) CarlifeConnectTimeSyncProto.getDescriptor().getMessageTypes().get(0);
            CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_fieldAccessorTable = new FieldAccessorTable(CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_descriptor, new String[]{"TimeStamp"}, CarlifeConnectTimeSync.class, CarlifeConnectTimeSync.Builder.class);
            return null;
        }
    }

    public static final class CarlifeConnectTimeSync extends GeneratedMessage {
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        private static final CarlifeConnectTimeSync defaultInstance = new CarlifeConnectTimeSync();
        private boolean hasTimeStamp;
        private int memoizedSerializedSize;
        private int timeStamp_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeConnectTimeSync result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeConnectTimeSync();
                return builder;
            }

            protected CarlifeConnectTimeSync internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeConnectTimeSync();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeConnectTimeSync.getDescriptor();
            }

            public CarlifeConnectTimeSync getDefaultInstanceForType() {
                return CarlifeConnectTimeSync.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeConnectTimeSync build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeConnectTimeSync buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeConnectTimeSync buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeConnectTimeSync returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeConnectTimeSync) {
                    return mergeFrom((CarlifeConnectTimeSync) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeConnectTimeSync other) {
                if (other != CarlifeConnectTimeSync.getDefaultInstance()) {
                    if (other.hasTimeStamp()) {
                        setTimeStamp(other.getTimeStamp());
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
                            setTimeStamp(input.readInt32());
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

            public boolean hasTimeStamp() {
                return this.result.hasTimeStamp();
            }

            public int getTimeStamp() {
                return this.result.getTimeStamp();
            }

            public Builder setTimeStamp(int value) {
                this.result.hasTimeStamp = true;
                this.result.timeStamp_ = value;
                return this;
            }

            public Builder clearTimeStamp() {
                this.result.hasTimeStamp = false;
                this.result.timeStamp_ = 0;
                return this;
            }
        }

        private CarlifeConnectTimeSync() {
            this.timeStamp_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeConnectTimeSyncProto.getDescriptor();
            CarlifeConnectTimeSyncProto.internalForceInit();
        }

        public static CarlifeConnectTimeSync getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeConnectTimeSync getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_fieldAccessorTable;
        }

        public boolean hasTimeStamp() {
            return this.hasTimeStamp;
        }

        public int getTimeStamp() {
            return this.timeStamp_;
        }

        public final boolean isInitialized() {
            if (this.hasTimeStamp) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasTimeStamp()) {
                output.writeInt32(1, getTimeStamp());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasTimeStamp()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getTimeStamp());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeConnectTimeSync parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeConnectTimeSync parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeConnectTimeSync prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeConnectTimeSyncProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeConnectTimeSyncProto.proto\"+\n\u0016CarlifeConnectTimeSync\u0012\u0011\n\ttimeStamp\u0018\u0001 \u0002(\u0005B\u001c\n\u001ame.objectyan.screensharing.protobuf"}, new FileDescriptor[0], new C20591());
    }

    public static void internalForceInit() {
    }
}
