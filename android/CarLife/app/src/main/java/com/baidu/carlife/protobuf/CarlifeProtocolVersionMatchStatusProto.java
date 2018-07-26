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

public final class CarlifeProtocolVersionMatchStatusProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_descriptor */
    private static Descriptor f6643x857f9f1b;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersionMatchStatus_fieldAccessorTable */
    private static FieldAccessorTable f6644xde177a99;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeProtocolVersionMatchStatusProto$1 */
    static class C20761 implements InternalDescriptorAssigner {
        C20761() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeProtocolVersionMatchStatusProto.descriptor = root;
            CarlifeProtocolVersionMatchStatusProto.f6643x857f9f1b = (Descriptor) CarlifeProtocolVersionMatchStatusProto.getDescriptor().getMessageTypes().get(0);
            CarlifeProtocolVersionMatchStatusProto.f6644xde177a99 = new FieldAccessorTable(CarlifeProtocolVersionMatchStatusProto.f6643x857f9f1b, new String[]{"MatchStatus"}, CarlifeProtocolVersionMatchStatus.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeProtocolVersionMatchStatus extends GeneratedMessage {
        public static final int MATCHSTATUS_FIELD_NUMBER = 1;
        private static final CarlifeProtocolVersionMatchStatus defaultInstance = new CarlifeProtocolVersionMatchStatus();
        private boolean hasMatchStatus;
        private int matchStatus_;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeProtocolVersionMatchStatus result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeProtocolVersionMatchStatus();
                return builder;
            }

            protected CarlifeProtocolVersionMatchStatus internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeProtocolVersionMatchStatus();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeProtocolVersionMatchStatus.getDescriptor();
            }

            public CarlifeProtocolVersionMatchStatus getDefaultInstanceForType() {
                return CarlifeProtocolVersionMatchStatus.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeProtocolVersionMatchStatus build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeProtocolVersionMatchStatus buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeProtocolVersionMatchStatus buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeProtocolVersionMatchStatus returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeProtocolVersionMatchStatus) {
                    return mergeFrom((CarlifeProtocolVersionMatchStatus) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeProtocolVersionMatchStatus other) {
                if (other != CarlifeProtocolVersionMatchStatus.getDefaultInstance()) {
                    if (other.hasMatchStatus()) {
                        setMatchStatus(other.getMatchStatus());
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
                            setMatchStatus(input.readInt32());
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

            public boolean hasMatchStatus() {
                return this.result.hasMatchStatus();
            }

            public int getMatchStatus() {
                return this.result.getMatchStatus();
            }

            public Builder setMatchStatus(int value) {
                this.result.hasMatchStatus = true;
                this.result.matchStatus_ = value;
                return this;
            }

            public Builder clearMatchStatus() {
                this.result.hasMatchStatus = false;
                this.result.matchStatus_ = 0;
                return this;
            }
        }

        private CarlifeProtocolVersionMatchStatus() {
            this.matchStatus_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeProtocolVersionMatchStatusProto.getDescriptor();
            CarlifeProtocolVersionMatchStatusProto.internalForceInit();
        }

        public static CarlifeProtocolVersionMatchStatus getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeProtocolVersionMatchStatus getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeProtocolVersionMatchStatusProto.f6643x857f9f1b;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeProtocolVersionMatchStatusProto.f6644xde177a99;
        }

        public boolean hasMatchStatus() {
            return this.hasMatchStatus;
        }

        public int getMatchStatus() {
            return this.matchStatus_;
        }

        public final boolean isInitialized() {
            if (this.hasMatchStatus) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasMatchStatus()) {
                output.writeInt32(1, getMatchStatus());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasMatchStatus()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getMatchStatus());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeProtocolVersionMatchStatus parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeProtocolVersionMatchStatus prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeProtocolVersionMatchStatusProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n,CarlifeProtocolVersionMatchStatusProto.proto\u0012\u001acom.baidu.carlife.protobuf\"8\n!CarlifeProtocolVersionMatchStatus\u0012\u0013\n\u000bmatchStatus\u0018\u0001 \u0002(\u0005"}, new FileDescriptor[0], new C20761());
    }

    public static void internalForceInit() {
    }
}
