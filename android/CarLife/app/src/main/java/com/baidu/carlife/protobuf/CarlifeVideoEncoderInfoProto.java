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

public final class CarlifeVideoEncoderInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_descriptor */
    private static Descriptor f6670xcc3e1383;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVideoEncoderInfo_fieldAccessorTable */
    private static FieldAccessorTable f6671xc4ef0701;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto$1 */
    static class C21001 implements InternalDescriptorAssigner {
        C21001() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeVideoEncoderInfoProto.descriptor = root;
            CarlifeVideoEncoderInfoProto.f6670xcc3e1383 = (Descriptor) CarlifeVideoEncoderInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeVideoEncoderInfoProto.f6671xc4ef0701 = new FieldAccessorTable(CarlifeVideoEncoderInfoProto.f6670xcc3e1383, new String[]{"Width", "Height", "FrameRate"}, CarlifeVideoEncoderInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeVideoEncoderInfo extends GeneratedMessage {
        public static final int FRAMERATE_FIELD_NUMBER = 3;
        public static final int HEIGHT_FIELD_NUMBER = 2;
        public static final int WIDTH_FIELD_NUMBER = 1;
        private static final CarlifeVideoEncoderInfo defaultInstance = new CarlifeVideoEncoderInfo();
        private int frameRate_;
        private boolean hasFrameRate;
        private boolean hasHeight;
        private boolean hasWidth;
        private int height_;
        private int memoizedSerializedSize;
        private int width_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeVideoEncoderInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeVideoEncoderInfo();
                return builder;
            }

            protected CarlifeVideoEncoderInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeVideoEncoderInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeVideoEncoderInfo.getDescriptor();
            }

            public CarlifeVideoEncoderInfo getDefaultInstanceForType() {
                return CarlifeVideoEncoderInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeVideoEncoderInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeVideoEncoderInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeVideoEncoderInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeVideoEncoderInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeVideoEncoderInfo) {
                    return mergeFrom((CarlifeVideoEncoderInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeVideoEncoderInfo other) {
                if (other != CarlifeVideoEncoderInfo.getDefaultInstance()) {
                    if (other.hasWidth()) {
                        setWidth(other.getWidth());
                    }
                    if (other.hasHeight()) {
                        setHeight(other.getHeight());
                    }
                    if (other.hasFrameRate()) {
                        setFrameRate(other.getFrameRate());
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
                            setWidth(input.readInt32());
                            continue;
                        case 16:
                            setHeight(input.readInt32());
                            continue;
                        case 24:
                            setFrameRate(input.readInt32());
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

            public boolean hasWidth() {
                return this.result.hasWidth();
            }

            public int getWidth() {
                return this.result.getWidth();
            }

            public Builder setWidth(int value) {
                this.result.hasWidth = true;
                this.result.width_ = value;
                return this;
            }

            public Builder clearWidth() {
                this.result.hasWidth = false;
                this.result.width_ = 0;
                return this;
            }

            public boolean hasHeight() {
                return this.result.hasHeight();
            }

            public int getHeight() {
                return this.result.getHeight();
            }

            public Builder setHeight(int value) {
                this.result.hasHeight = true;
                this.result.height_ = value;
                return this;
            }

            public Builder clearHeight() {
                this.result.hasHeight = false;
                this.result.height_ = 0;
                return this;
            }

            public boolean hasFrameRate() {
                return this.result.hasFrameRate();
            }

            public int getFrameRate() {
                return this.result.getFrameRate();
            }

            public Builder setFrameRate(int value) {
                this.result.hasFrameRate = true;
                this.result.frameRate_ = value;
                return this;
            }

            public Builder clearFrameRate() {
                this.result.hasFrameRate = false;
                this.result.frameRate_ = 0;
                return this;
            }
        }

        private CarlifeVideoEncoderInfo() {
            this.width_ = 0;
            this.height_ = 0;
            this.frameRate_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeVideoEncoderInfoProto.getDescriptor();
            CarlifeVideoEncoderInfoProto.internalForceInit();
        }

        public static CarlifeVideoEncoderInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeVideoEncoderInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeVideoEncoderInfoProto.f6670xcc3e1383;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeVideoEncoderInfoProto.f6671xc4ef0701;
        }

        public boolean hasWidth() {
            return this.hasWidth;
        }

        public int getWidth() {
            return this.width_;
        }

        public boolean hasHeight() {
            return this.hasHeight;
        }

        public int getHeight() {
            return this.height_;
        }

        public boolean hasFrameRate() {
            return this.hasFrameRate;
        }

        public int getFrameRate() {
            return this.frameRate_;
        }

        public final boolean isInitialized() {
            if (this.hasWidth && this.hasHeight && this.hasFrameRate) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasWidth()) {
                output.writeInt32(1, getWidth());
            }
            if (hasHeight()) {
                output.writeInt32(2, getHeight());
            }
            if (hasFrameRate()) {
                output.writeInt32(3, getFrameRate());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasWidth()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getWidth());
            }
            if (hasHeight()) {
                size += CodedOutputStream.computeInt32Size(2, getHeight());
            }
            if (hasFrameRate()) {
                size += CodedOutputStream.computeInt32Size(3, getFrameRate());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeVideoEncoderInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVideoEncoderInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeVideoEncoderInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeVideoEncoderInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeVideoEncoderInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"K\n\u0017CarlifeVideoEncoderInfo\u0012\r\n\u0005width\u0018\u0001 \u0002(\u0005\u0012\u000e\n\u0006height\u0018\u0002 \u0002(\u0005\u0012\u0011\n\tframeRate\u0018\u0003 \u0002(\u0005"}, new FileDescriptor[0], new C21001());
    }

    public static void internalForceInit() {
    }
}
