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

public final class CarlifeVoiceControlRequestProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_descriptor */
    private static Descriptor f6674x7fef9186;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVoiceControlRequest_fieldAccessorTable */
    private static FieldAccessorTable f6675xa30fd204;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeVoiceControlRequestProto$1 */
    static class C21021 implements InternalDescriptorAssigner {
        C21021() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeVoiceControlRequestProto.descriptor = root;
            CarlifeVoiceControlRequestProto.f6674x7fef9186 = (Descriptor) CarlifeVoiceControlRequestProto.getDescriptor().getMessageTypes().get(0);
            CarlifeVoiceControlRequestProto.f6675xa30fd204 = new FieldAccessorTable(CarlifeVoiceControlRequestProto.f6674x7fef9186, new String[]{"Command", "Opt"}, CarlifeVoiceControlRequest.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeVoiceControlRequest extends GeneratedMessage {
        public static final int COMMAND_FIELD_NUMBER = 1;
        public static final int OPT_FIELD_NUMBER = 2;
        private static final CarlifeVoiceControlRequest defaultInstance = new CarlifeVoiceControlRequest();
        private int command_;
        private boolean hasCommand;
        private boolean hasOpt;
        private int memoizedSerializedSize;
        private int opt_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeVoiceControlRequest result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeVoiceControlRequest();
                return builder;
            }

            protected CarlifeVoiceControlRequest internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeVoiceControlRequest();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeVoiceControlRequest.getDescriptor();
            }

            public CarlifeVoiceControlRequest getDefaultInstanceForType() {
                return CarlifeVoiceControlRequest.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeVoiceControlRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeVoiceControlRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeVoiceControlRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeVoiceControlRequest returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeVoiceControlRequest) {
                    return mergeFrom((CarlifeVoiceControlRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeVoiceControlRequest other) {
                if (other != CarlifeVoiceControlRequest.getDefaultInstance()) {
                    if (other.hasCommand()) {
                        setCommand(other.getCommand());
                    }
                    if (other.hasOpt()) {
                        setOpt(other.getOpt());
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
                            setCommand(input.readInt32());
                            continue;
                        case 16:
                            setOpt(input.readInt32());
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

            public boolean hasCommand() {
                return this.result.hasCommand();
            }

            public int getCommand() {
                return this.result.getCommand();
            }

            public Builder setCommand(int value) {
                this.result.hasCommand = true;
                this.result.command_ = value;
                return this;
            }

            public Builder clearCommand() {
                this.result.hasCommand = false;
                this.result.command_ = 0;
                return this;
            }

            public boolean hasOpt() {
                return this.result.hasOpt();
            }

            public int getOpt() {
                return this.result.getOpt();
            }

            public Builder setOpt(int value) {
                this.result.hasOpt = true;
                this.result.opt_ = value;
                return this;
            }

            public Builder clearOpt() {
                this.result.hasOpt = false;
                this.result.opt_ = 0;
                return this;
            }
        }

        private CarlifeVoiceControlRequest() {
            this.command_ = 0;
            this.opt_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeVoiceControlRequestProto.getDescriptor();
            CarlifeVoiceControlRequestProto.internalForceInit();
        }

        public static CarlifeVoiceControlRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeVoiceControlRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeVoiceControlRequestProto.f6674x7fef9186;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeVoiceControlRequestProto.f6675xa30fd204;
        }

        public boolean hasCommand() {
            return this.hasCommand;
        }

        public int getCommand() {
            return this.command_;
        }

        public boolean hasOpt() {
            return this.hasOpt;
        }

        public int getOpt() {
            return this.opt_;
        }

        public final boolean isInitialized() {
            if (this.hasCommand) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasCommand()) {
                output.writeInt32(1, getCommand());
            }
            if (hasOpt()) {
                output.writeInt32(2, getOpt());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasCommand()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getCommand());
            }
            if (hasOpt()) {
                size += CodedOutputStream.computeInt32Size(2, getOpt());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeVoiceControlRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVoiceControlRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeVoiceControlRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeVoiceControlRequestProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%CarlifeVoiceControlRequestProto.proto\u0012\u001acom.baidu.carlife.protobuf\":\n\u001aCarlifeVoiceControlRequest\u0012\u000f\n\u0007command\u0018\u0001 \u0002(\u0005\u0012\u000b\n\u0003opt\u0018\u0002 \u0001(\u0005"}, new FileDescriptor[0], new C21021());
    }

    public static void internalForceInit() {
    }
}
