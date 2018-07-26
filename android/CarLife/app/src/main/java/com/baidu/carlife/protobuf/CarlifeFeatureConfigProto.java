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

public final class CarlifeFeatureConfigProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_descriptor */
    private static Descriptor f6619x6a95d072;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfig_fieldAccessorTable */
    private static FieldAccessorTable f6620xc9ae64f0;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeFeatureConfigProto$1 */
    static class C20641 implements InternalDescriptorAssigner {
        C20641() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeFeatureConfigProto.descriptor = root;
            CarlifeFeatureConfigProto.f6619x6a95d072 = (Descriptor) CarlifeFeatureConfigProto.getDescriptor().getMessageTypes().get(0);
            CarlifeFeatureConfigProto.f6620xc9ae64f0 = new FieldAccessorTable(CarlifeFeatureConfigProto.f6619x6a95d072, new String[]{"Key", "Value"}, CarlifeFeatureConfig.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeFeatureConfig extends GeneratedMessage {
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final CarlifeFeatureConfig defaultInstance = new CarlifeFeatureConfig();
        private boolean hasKey;
        private boolean hasValue;
        private String key_;
        private int memoizedSerializedSize;
        private int value_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeFeatureConfig result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeFeatureConfig();
                return builder;
            }

            protected CarlifeFeatureConfig internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeFeatureConfig();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeFeatureConfig.getDescriptor();
            }

            public CarlifeFeatureConfig getDefaultInstanceForType() {
                return CarlifeFeatureConfig.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeFeatureConfig build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeFeatureConfig buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeFeatureConfig buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeFeatureConfig returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeFeatureConfig) {
                    return mergeFrom((CarlifeFeatureConfig) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeFeatureConfig other) {
                if (other != CarlifeFeatureConfig.getDefaultInstance()) {
                    if (other.hasKey()) {
                        setKey(other.getKey());
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
                        case 10:
                            setKey(input.readString());
                            continue;
                        case 16:
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

            public boolean hasKey() {
                return this.result.hasKey();
            }

            public String getKey() {
                return this.result.getKey();
            }

            public Builder setKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasKey = true;
                this.result.key_ = value;
                return this;
            }

            public Builder clearKey() {
                this.result.hasKey = false;
                this.result.key_ = CarlifeFeatureConfig.getDefaultInstance().getKey();
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

        private CarlifeFeatureConfig() {
            this.key_ = "";
            this.value_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeFeatureConfigProto.getDescriptor();
            CarlifeFeatureConfigProto.internalForceInit();
        }

        public static CarlifeFeatureConfig getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeFeatureConfig getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeFeatureConfigProto.f6619x6a95d072;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeFeatureConfigProto.f6620xc9ae64f0;
        }

        public boolean hasKey() {
            return this.hasKey;
        }

        public String getKey() {
            return this.key_;
        }

        public boolean hasValue() {
            return this.hasValue;
        }

        public int getValue() {
            return this.value_;
        }

        public final boolean isInitialized() {
            if (this.hasKey && this.hasValue) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasKey()) {
                output.writeString(1, getKey());
            }
            if (hasValue()) {
                output.writeInt32(2, getValue());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasKey()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getKey());
            }
            if (hasValue()) {
                size += CodedOutputStream.computeInt32Size(2, getValue());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeFeatureConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfig parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeFeatureConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeFeatureConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeFeatureConfig prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeFeatureConfigProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fCarlifeFeatureConfigProto.proto\u0012\u001acom.baidu.carlife.protobuf\"2\n\u0014CarlifeFeatureConfig\u0012\u000b\n\u0003key\u0018\u0001 \u0002(\t\u0012\r\n\u0005value\u0018\u0002 \u0002(\u0005"}, new FileDescriptor[0], new C20641());
    }

    public static void internalForceInit() {
    }
}
