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

public final class CarlifeTouchActionProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_descriptor */
    private static Descriptor f6656x31aad5;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTouchAction_fieldAccessorTable */
    private static FieldAccessorTable f6657x31472c53;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTouchActionProto$1 */
    static class C20851 implements InternalDescriptorAssigner {
        C20851() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTouchActionProto.descriptor = root;
            CarlifeTouchActionProto.f6656x31aad5 = (Descriptor) CarlifeTouchActionProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTouchActionProto.f6657x31472c53 = new FieldAccessorTable(CarlifeTouchActionProto.f6656x31aad5, new String[]{"Action", RoutePlanDataStruct.KEY_X, RoutePlanDataStruct.KEY_Y}, CarlifeTouchAction.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTouchAction extends GeneratedMessage {
        public static final int ACTION_FIELD_NUMBER = 1;
        public static final int X_FIELD_NUMBER = 2;
        public static final int Y_FIELD_NUMBER = 3;
        private static final CarlifeTouchAction defaultInstance = new CarlifeTouchAction();
        private int action_;
        private boolean hasAction;
        private boolean hasX;
        private boolean hasY;
        private int memoizedSerializedSize;
        private int x_;
        private int y_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTouchAction result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTouchAction();
                return builder;
            }

            protected CarlifeTouchAction internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTouchAction();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTouchAction.getDescriptor();
            }

            public CarlifeTouchAction getDefaultInstanceForType() {
                return CarlifeTouchAction.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTouchAction build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTouchAction buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTouchAction buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTouchAction returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTouchAction) {
                    return mergeFrom((CarlifeTouchAction) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTouchAction other) {
                if (other != CarlifeTouchAction.getDefaultInstance()) {
                    if (other.hasAction()) {
                        setAction(other.getAction());
                    }
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
                            setAction(input.readInt32());
                            continue;
                        case 16:
                            setX(input.readInt32());
                            continue;
                        case 24:
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

            public boolean hasAction() {
                return this.result.hasAction();
            }

            public int getAction() {
                return this.result.getAction();
            }

            public Builder setAction(int value) {
                this.result.hasAction = true;
                this.result.action_ = value;
                return this;
            }

            public Builder clearAction() {
                this.result.hasAction = false;
                this.result.action_ = 0;
                return this;
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

        private CarlifeTouchAction() {
            this.action_ = 0;
            this.x_ = 0;
            this.y_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTouchActionProto.getDescriptor();
            CarlifeTouchActionProto.internalForceInit();
        }

        public static CarlifeTouchAction getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTouchAction getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTouchActionProto.f6656x31aad5;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTouchActionProto.f6657x31472c53;
        }

        public boolean hasAction() {
            return this.hasAction;
        }

        public int getAction() {
            return this.action_;
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
            if (this.hasAction && this.hasX && this.hasY) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasAction()) {
                output.writeInt32(1, getAction());
            }
            if (hasX()) {
                output.writeInt32(2, getX());
            }
            if (hasY()) {
                output.writeInt32(3, getY());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasAction()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getAction());
            }
            if (hasX()) {
                size += CodedOutputStream.computeInt32Size(2, getX());
            }
            if (hasY()) {
                size += CodedOutputStream.computeInt32Size(3, getY());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTouchAction parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchAction parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTouchAction parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTouchAction parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTouchAction prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTouchActionProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCarlifeTouchActionProto.proto\u0012\u001acom.baidu.carlife.protobuf\":\n\u0012CarlifeTouchAction\u0012\u000e\n\u0006action\u0018\u0001 \u0002(\u0005\u0012\t\n\u0001x\u0018\u0002 \u0002(\u0005\u0012\t\n\u0001y\u0018\u0003 \u0002(\u0005"}, new FileDescriptor[0], new C20851());
    }

    public static void internalForceInit() {
    }
}
