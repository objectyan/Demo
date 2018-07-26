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

public final class CarlifeCarHardKeyCodeProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_descriptor */
    private static Descriptor f6605xff512125;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeCarHardKeyCode_fieldAccessorTable */
    private static FieldAccessorTable f6606x81f352a3;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto$1 */
    static class C20551 implements InternalDescriptorAssigner {
        C20551() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeCarHardKeyCodeProto.descriptor = root;
            CarlifeCarHardKeyCodeProto.f6605xff512125 = (Descriptor) CarlifeCarHardKeyCodeProto.getDescriptor().getMessageTypes().get(0);
            CarlifeCarHardKeyCodeProto.f6606x81f352a3 = new FieldAccessorTable(CarlifeCarHardKeyCodeProto.f6605xff512125, new String[]{"Keycode"}, CarlifeCarHardKeyCode.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeCarHardKeyCode extends GeneratedMessage {
        public static final int KEYCODE_FIELD_NUMBER = 1;
        private static final CarlifeCarHardKeyCode defaultInstance = new CarlifeCarHardKeyCode();
        private boolean hasKeycode;
        private int keycode_;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeCarHardKeyCode result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeCarHardKeyCode();
                return builder;
            }

            protected CarlifeCarHardKeyCode internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeCarHardKeyCode();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeCarHardKeyCode.getDescriptor();
            }

            public CarlifeCarHardKeyCode getDefaultInstanceForType() {
                return CarlifeCarHardKeyCode.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeCarHardKeyCode build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeCarHardKeyCode buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeCarHardKeyCode buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeCarHardKeyCode returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeCarHardKeyCode) {
                    return mergeFrom((CarlifeCarHardKeyCode) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeCarHardKeyCode other) {
                if (other != CarlifeCarHardKeyCode.getDefaultInstance()) {
                    if (other.hasKeycode()) {
                        setKeycode(other.getKeycode());
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
                            setKeycode(input.readInt32());
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

            public boolean hasKeycode() {
                return this.result.hasKeycode();
            }

            public int getKeycode() {
                return this.result.getKeycode();
            }

            public Builder setKeycode(int value) {
                this.result.hasKeycode = true;
                this.result.keycode_ = value;
                return this;
            }

            public Builder clearKeycode() {
                this.result.hasKeycode = false;
                this.result.keycode_ = 0;
                return this;
            }
        }

        private CarlifeCarHardKeyCode() {
            this.keycode_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeCarHardKeyCodeProto.getDescriptor();
            CarlifeCarHardKeyCodeProto.internalForceInit();
        }

        public static CarlifeCarHardKeyCode getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeCarHardKeyCode getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeCarHardKeyCodeProto.f6605xff512125;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeCarHardKeyCodeProto.f6606x81f352a3;
        }

        public boolean hasKeycode() {
            return this.hasKeycode;
        }

        public int getKeycode() {
            return this.keycode_;
        }

        public final boolean isInitialized() {
            if (this.hasKeycode) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasKeycode()) {
                output.writeInt32(1, getKeycode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasKeycode()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getKeycode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeCarHardKeyCode parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeCarHardKeyCode parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeCarHardKeyCode prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeCarHardKeyCodeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n CarlifeCarHardKeyCodeProto.proto\u0012\u001acom.baidu.carlife.protobuf\"(\n\u0015CarlifeCarHardKeyCode\u0012\u000f\n\u0007keycode\u0018\u0001 \u0002(\u0005"}, new FileDescriptor[0], new C20551());
    }

    public static void internalForceInit() {
    }
}
