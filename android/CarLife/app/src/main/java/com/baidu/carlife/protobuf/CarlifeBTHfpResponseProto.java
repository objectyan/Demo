package com.baidu.carlife.protobuf;

import com.baidu.carlife.core.C1253f;
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

public final class CarlifeBTHfpResponseProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_descriptor */
    private static Descriptor f6589x2a5284a9;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpResponse_fieldAccessorTable */
    private static FieldAccessorTable f6590x62af227;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeBTHfpResponseProto$1 */
    static class C20471 implements InternalDescriptorAssigner {
        C20471() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeBTHfpResponseProto.descriptor = root;
            CarlifeBTHfpResponseProto.f6589x2a5284a9 = (Descriptor) CarlifeBTHfpResponseProto.getDescriptor().getMessageTypes().get(0);
            CarlifeBTHfpResponseProto.f6590x62af227 = new FieldAccessorTable(CarlifeBTHfpResponseProto.f6589x2a5284a9, new String[]{"Status", C1253f.iN, "DtmfCode"}, CarlifeBTHfpResponse.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeBTHfpResponse extends GeneratedMessage {
        public static final int CMD_FIELD_NUMBER = 2;
        public static final int DTMFCODE_FIELD_NUMBER = 3;
        public static final int STATUS_FIELD_NUMBER = 1;
        private static final CarlifeBTHfpResponse defaultInstance = new CarlifeBTHfpResponse();
        private int cmd_;
        private int dtmfCode_;
        private boolean hasCmd;
        private boolean hasDtmfCode;
        private boolean hasStatus;
        private int memoizedSerializedSize;
        private int status_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeBTHfpResponse result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeBTHfpResponse();
                return builder;
            }

            protected CarlifeBTHfpResponse internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeBTHfpResponse();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeBTHfpResponse.getDescriptor();
            }

            public CarlifeBTHfpResponse getDefaultInstanceForType() {
                return CarlifeBTHfpResponse.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeBTHfpResponse build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeBTHfpResponse buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeBTHfpResponse buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeBTHfpResponse returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeBTHfpResponse) {
                    return mergeFrom((CarlifeBTHfpResponse) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeBTHfpResponse other) {
                if (other != CarlifeBTHfpResponse.getDefaultInstance()) {
                    if (other.hasStatus()) {
                        setStatus(other.getStatus());
                    }
                    if (other.hasCmd()) {
                        setCmd(other.getCmd());
                    }
                    if (other.hasDtmfCode()) {
                        setDtmfCode(other.getDtmfCode());
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
                            setStatus(input.readInt32());
                            continue;
                        case 16:
                            setCmd(input.readInt32());
                            continue;
                        case 24:
                            setDtmfCode(input.readInt32());
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

            public boolean hasStatus() {
                return this.result.hasStatus();
            }

            public int getStatus() {
                return this.result.getStatus();
            }

            public Builder setStatus(int value) {
                this.result.hasStatus = true;
                this.result.status_ = value;
                return this;
            }

            public Builder clearStatus() {
                this.result.hasStatus = false;
                this.result.status_ = 0;
                return this;
            }

            public boolean hasCmd() {
                return this.result.hasCmd();
            }

            public int getCmd() {
                return this.result.getCmd();
            }

            public Builder setCmd(int value) {
                this.result.hasCmd = true;
                this.result.cmd_ = value;
                return this;
            }

            public Builder clearCmd() {
                this.result.hasCmd = false;
                this.result.cmd_ = 0;
                return this;
            }

            public boolean hasDtmfCode() {
                return this.result.hasDtmfCode();
            }

            public int getDtmfCode() {
                return this.result.getDtmfCode();
            }

            public Builder setDtmfCode(int value) {
                this.result.hasDtmfCode = true;
                this.result.dtmfCode_ = value;
                return this;
            }

            public Builder clearDtmfCode() {
                this.result.hasDtmfCode = false;
                this.result.dtmfCode_ = 0;
                return this;
            }
        }

        private CarlifeBTHfpResponse() {
            this.status_ = 0;
            this.cmd_ = 0;
            this.dtmfCode_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeBTHfpResponseProto.getDescriptor();
            CarlifeBTHfpResponseProto.internalForceInit();
        }

        public static CarlifeBTHfpResponse getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeBTHfpResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeBTHfpResponseProto.f6589x2a5284a9;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeBTHfpResponseProto.f6590x62af227;
        }

        public boolean hasStatus() {
            return this.hasStatus;
        }

        public int getStatus() {
            return this.status_;
        }

        public boolean hasCmd() {
            return this.hasCmd;
        }

        public int getCmd() {
            return this.cmd_;
        }

        public boolean hasDtmfCode() {
            return this.hasDtmfCode;
        }

        public int getDtmfCode() {
            return this.dtmfCode_;
        }

        public final boolean isInitialized() {
            if (this.hasStatus && this.hasCmd) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasStatus()) {
                output.writeInt32(1, getStatus());
            }
            if (hasCmd()) {
                output.writeInt32(2, getCmd());
            }
            if (hasDtmfCode()) {
                output.writeInt32(3, getDtmfCode());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasStatus()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getStatus());
            }
            if (hasCmd()) {
                size += CodedOutputStream.computeInt32Size(2, getCmd());
            }
            if (hasDtmfCode()) {
                size += CodedOutputStream.computeInt32Size(3, getDtmfCode());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeBTHfpResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeBTHfpResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeBTHfpResponse prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeBTHfpResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fCarlifeBTHfpResponseProto.proto\u0012\u001acom.baidu.carlife.protobuf\"E\n\u0014CarlifeBTHfpResponse\u0012\u000e\n\u0006status\u0018\u0001 \u0002(\u0005\u0012\u000b\n\u0003cmd\u0018\u0002 \u0002(\u0005\u0012\u0010\n\bdtmfCode\u0018\u0003 \u0001(\u0005"}, new FileDescriptor[0], new C20471());
    }

    public static void internalForceInit() {
    }
}
