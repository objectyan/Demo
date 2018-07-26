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

public final class CarlifeAuthenRequestProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_descriptor */
    private static Descriptor f6577xc7398c;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_fieldAccessorTable */
    private static FieldAccessorTable f6578xbf5a140a;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeAuthenRequestProto$1 */
    static class C20411 implements InternalDescriptorAssigner {
        C20411() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeAuthenRequestProto.descriptor = root;
            CarlifeAuthenRequestProto.f6577xc7398c = (Descriptor) CarlifeAuthenRequestProto.getDescriptor().getMessageTypes().get(0);
            CarlifeAuthenRequestProto.f6578xbf5a140a = new FieldAccessorTable(CarlifeAuthenRequestProto.f6577xc7398c, new String[]{"RandomValue"}, CarlifeAuthenRequest.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeAuthenRequest extends GeneratedMessage {
        public static final int RANDOMVALUE_FIELD_NUMBER = 1;
        private static final CarlifeAuthenRequest defaultInstance = new CarlifeAuthenRequest();
        private boolean hasRandomValue;
        private int memoizedSerializedSize;
        private String randomValue_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeAuthenRequest result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeAuthenRequest();
                return builder;
            }

            protected CarlifeAuthenRequest internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeAuthenRequest();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeAuthenRequest.getDescriptor();
            }

            public CarlifeAuthenRequest getDefaultInstanceForType() {
                return CarlifeAuthenRequest.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeAuthenRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeAuthenRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeAuthenRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeAuthenRequest returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeAuthenRequest) {
                    return mergeFrom((CarlifeAuthenRequest) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeAuthenRequest other) {
                if (other != CarlifeAuthenRequest.getDefaultInstance()) {
                    if (other.hasRandomValue()) {
                        setRandomValue(other.getRandomValue());
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
                            setRandomValue(input.readString());
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

            public boolean hasRandomValue() {
                return this.result.hasRandomValue();
            }

            public String getRandomValue() {
                return this.result.getRandomValue();
            }

            public Builder setRandomValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasRandomValue = true;
                this.result.randomValue_ = value;
                return this;
            }

            public Builder clearRandomValue() {
                this.result.hasRandomValue = false;
                this.result.randomValue_ = CarlifeAuthenRequest.getDefaultInstance().getRandomValue();
                return this;
            }
        }

        private CarlifeAuthenRequest() {
            this.randomValue_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeAuthenRequestProto.getDescriptor();
            CarlifeAuthenRequestProto.internalForceInit();
        }

        public static CarlifeAuthenRequest getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeAuthenRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeAuthenRequestProto.f6577xc7398c;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeAuthenRequestProto.f6578xbf5a140a;
        }

        public boolean hasRandomValue() {
            return this.hasRandomValue;
        }

        public String getRandomValue() {
            return this.randomValue_;
        }

        public final boolean isInitialized() {
            if (this.hasRandomValue) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasRandomValue()) {
                output.writeString(1, getRandomValue());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasRandomValue()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getRandomValue());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeAuthenRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenRequest parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeAuthenRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeAuthenRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeAuthenRequest prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeAuthenRequestProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fCarlifeAuthenRequestProto.proto\u0012\u001acom.baidu.carlife.protobuf\"+\n\u0014CarlifeAuthenRequest\u0012\u0013\n\u000brandomValue\u0018\u0001 \u0002(\t"}, new FileDescriptor[0], new C20411());
    }

    public static void internalForceInit() {
    }
}
