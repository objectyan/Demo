package com.baidu.carlife.protobuf;

import com.baidu.navi.protocol.model.RoutePlanDataStruct;
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

public final class CarlifeTouchSinglePointProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_descriptor */
    private static Descriptor f6660x867c2249;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_fieldAccessorTable */
    private static FieldAccessorTable f6661xcc2cefc7;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTouchSinglePointProto$1 */
    static class C20871 implements InternalDescriptorAssigner {
        C20871() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTouchSinglePointProto.descriptor = root;
            CarlifeTouchSinglePointProto.f6660x867c2249 = (Descriptor) CarlifeTouchSinglePointProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTouchSinglePointProto.f6661xcc2cefc7 = new FieldAccessorTable(CarlifeTouchSinglePointProto.f6660x867c2249, new String[]{RoutePlanDataStruct.KEY_X, RoutePlanDataStruct.KEY_Y}, CarlifeTouchSinglePoint.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTouchSinglePoint extends GeneratedMessage {
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private static final CarlifeTouchSinglePoint defaultInstance = new CarlifeTouchSinglePoint();
        private boolean hasX;
        private boolean hasY;
        private int memoizedSerializedSize;
        private int x_;
        private int y_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTouchSinglePoint result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTouchSinglePoint();
                return builder;
            }

            protected CarlifeTouchSinglePoint internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTouchSinglePoint();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTouchSinglePoint.getDescriptor();
            }

            public CarlifeTouchSinglePoint getDefaultInstanceForType() {
                return CarlifeTouchSinglePoint.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTouchSinglePoint build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTouchSinglePoint buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTouchSinglePoint buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTouchSinglePoint returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTouchSinglePoint) {
                    return mergeFrom((CarlifeTouchSinglePoint) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTouchSinglePoint other) {
                if (other != CarlifeTouchSinglePoint.getDefaultInstance()) {
                    if (other.hasX()) {
                        setX(other.getX());
                    }
                    if (other.hasY()) {
                        setY(other.getY());
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
                            setX(input.readInt32());
                            continue;
                        case 16:
                            setY(input.readInt32());
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

            public boolean hasX() {
                return this.result.hasX();
            }

            public int getX() {
                return this.result.getX();
            }

            public Builder setX(int value) {
                this.result.hasX = true;
                this.result.x_ = value;
                return this;
            }

            public Builder clearX() {
                this.result.hasX = false;
                this.result.x_ = 0;
                return this;
            }

            public boolean hasY() {
                return this.result.hasY();
            }

            public int getY() {
                return this.result.getY();
            }

            public Builder setY(int value) {
                this.result.hasY = true;
                this.result.y_ = value;
                return this;
            }

            public Builder clearY() {
                this.result.hasY = false;
                this.result.y_ = 0;
                return this;
            }
        }

        private CarlifeTouchSinglePoint() {
            this.x_ = 0;
            this.y_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTouchSinglePointProto.getDescriptor();
            CarlifeTouchSinglePointProto.internalForceInit();
        }

        public static CarlifeTouchSinglePoint getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTouchSinglePoint getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTouchSinglePointProto.f6660x867c2249;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTouchSinglePointProto.f6661xcc2cefc7;
        }

        public boolean hasX() {
            return this.hasX;
        }

        public int getX() {
            return this.x_;
        }

        public boolean hasY() {
            return this.hasY;
        }

        public int getY() {
            return this.y_;
        }

        public final boolean isInitialized() {
            if (this.hasX && this.hasY) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasX()) {
                output.writeInt32(1, getX());
            }
            if (hasY()) {
                output.writeInt32(2, getY());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasX()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getX());
            }
            if (hasY()) {
                size += CodedOutputStream.computeInt32Size(2, getY());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTouchSinglePoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTouchSinglePoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTouchSinglePoint prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTouchSinglePointProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeTouchSinglePointProto.proto\u0012\u001acom.baidu.carlife.protobuf\"/\n\u0017CarlifeTouchSinglePoint\u0012\t\n\u0001x\u0018\u0001 \u0002(\u0005\u0012\t\n\u0001y\u0018\u0002 \u0002(\u0005"}, new FileDescriptor[0], new C20871());
    }

    public static void internalForceInit() {
    }
}
