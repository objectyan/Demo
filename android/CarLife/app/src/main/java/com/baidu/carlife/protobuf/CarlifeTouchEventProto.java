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

public final class CarlifeTouchEventProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_descriptor */
    private static Descriptor f6658xf7de8d7;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTouchEvent_fieldAccessorTable */
    private static FieldAccessorTable f6659xeffe4855;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTouchEventProto$1 */
    static class C20861 implements InternalDescriptorAssigner {
        C20861() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTouchEventProto.descriptor = root;
            CarlifeTouchEventProto.f6658xf7de8d7 = (Descriptor) CarlifeTouchEventProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTouchEventProto.f6659xeffe4855 = new FieldAccessorTable(CarlifeTouchEventProto.f6658xf7de8d7, new String[]{"Type", "Code", "Value"}, CarlifeTouchEvent.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTouchEvent extends GeneratedMessage {
        public static final int CODE_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 3;
        private static final CarlifeTouchEvent defaultInstance = new CarlifeTouchEvent();
        private int code_;
        private boolean hasCode;
        private boolean hasType;
        private boolean hasValue;
        private int memoizedSerializedSize;
        private int type_;
        private int value_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTouchEvent result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTouchEvent();
                return builder;
            }

            protected CarlifeTouchEvent internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTouchEvent();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTouchEvent.getDescriptor();
            }

            public CarlifeTouchEvent getDefaultInstanceForType() {
                return CarlifeTouchEvent.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTouchEvent build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTouchEvent buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTouchEvent buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTouchEvent returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTouchEvent) {
                    return mergeFrom((CarlifeTouchEvent) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTouchEvent other) {
                if (other != CarlifeTouchEvent.getDefaultInstance()) {
                    if (other.hasType()) {
                        setType(other.getType());
                    }
                    if (other.hasCode()) {
                        setCode(other.getCode());
                    }
                    if (other.hasValue()) {
                        setValue(other.getValue());
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
                            setType(input.readInt32());
                            continue;
                        case 16:
                            setCode(input.readInt32());
                            continue;
                        case 24:
                            setValue(input.readInt32());
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

            public boolean hasType() {
                return this.result.hasType();
            }

            public int getType() {
                return this.result.getType();
            }

            public Builder setType(int value) {
                this.result.hasType = true;
                this.result.type_ = value;
                return this;
            }

            public Builder clearType() {
                this.result.hasType = false;
                this.result.type_ = 0;
                return this;
            }

            public boolean hasCode() {
                return this.result.hasCode();
            }

            public int getCode() {
                return this.result.getCode();
            }

            public Builder setCode(int value) {
                this.result.hasCode = true;
                this.result.code_ = value;
                return this;
            }

            public Builder clearCode() {
                this.result.hasCode = false;
                this.result.code_ = 0;
                return this;
            }

            public boolean hasValue() {
                return this.result.hasValue();
            }

            public int getValue() {
                return this.result.getValue();
            }

            public Builder setValue(int value) {
                this.result.hasValue = true;
                this.result.value_ = value;
                return this;
            }

            public Builder clearValue() {
                this.result.hasValue = false;
                this.result.value_ = 0;
                return this;
            }
        }

        private CarlifeTouchEvent() {
            this.type_ = 0;
            this.code_ = 0;
            this.value_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTouchEventProto.getDescriptor();
            CarlifeTouchEventProto.internalForceInit();
        }

        public static CarlifeTouchEvent getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTouchEvent getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTouchEventProto.f6658xf7de8d7;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTouchEventProto.f6659xeffe4855;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasCode() {
            return this.hasCode;
        }

        public int getCode() {
            return this.code_;
        }

        public boolean hasValue() {
            return this.hasValue;
        }

        public int getValue() {
            return this.value_;
        }

        public final boolean isInitialized() {
            if (this.hasType && this.hasCode && this.hasValue) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasType()) {
                output.writeInt32(1, getType());
            }
            if (hasCode()) {
                output.writeInt32(2, getCode());
            }
            if (hasValue()) {
                output.writeInt32(3, getValue());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasType()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getType());
            }
            if (hasCode()) {
                size += CodedOutputStream.computeInt32Size(2, getCode());
            }
            if (hasValue()) {
                size += CodedOutputStream.computeInt32Size(3, getValue());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTouchEvent parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchEvent parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTouchEvent parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTouchEvent parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTouchEvent prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTouchEventProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cCarlifeTouchEventProto.proto\u0012\u001acom.baidu.carlife.protobuf\">\n\u0011CarlifeTouchEvent\u0012\f\n\u0004type\u0018\u0001 \u0002(\u0005\u0012\f\n\u0004code\u0018\u0002 \u0002(\u0005\u0012\r\n\u0005value\u0018\u0003 \u0002(\u0005"}, new FileDescriptor[0], new C20861());
    }

    public static void internalForceInit() {
    }
}
