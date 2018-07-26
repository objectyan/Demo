package com.baidu.carlife.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;

public final class CarlifeStopReceiveDataProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeStopReceiveData_descriptor;
    private static FieldAccessorTable internal_static_CarlifeStopReceiveData_fieldAccessorTable;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeStopReceiveDataProto$1 */
    static class C20791 implements InternalDescriptorAssigner {
        C20791() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeStopReceiveDataProto.descriptor = root;
            CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_descriptor = (Descriptor) CarlifeStopReceiveDataProto.getDescriptor().getMessageTypes().get(0);
            CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_fieldAccessorTable = new FieldAccessorTable(CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_descriptor, new String[]{"FileId", "Reason"}, CarlifeStopReceiveData.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeStopReceiveData extends GeneratedMessage {
        public static final int FILEID_FIELD_NUMBER = 1;
        public static final int REASON_FIELD_NUMBER = 2;
        private static final CarlifeStopReceiveData defaultInstance = new CarlifeStopReceiveData();
        private int fileId_;
        private boolean hasFileId;
        private boolean hasReason;
        private int memoizedSerializedSize;
        private Reason reason_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeStopReceiveData result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeStopReceiveData();
                return builder;
            }

            protected CarlifeStopReceiveData internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeStopReceiveData();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeStopReceiveData.getDescriptor();
            }

            public CarlifeStopReceiveData getDefaultInstanceForType() {
                return CarlifeStopReceiveData.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeStopReceiveData build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeStopReceiveData buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeStopReceiveData buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeStopReceiveData returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeStopReceiveData) {
                    return mergeFrom((CarlifeStopReceiveData) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeStopReceiveData other) {
                if (other != CarlifeStopReceiveData.getDefaultInstance()) {
                    if (other.hasFileId()) {
                        setFileId(other.getFileId());
                    }
                    if (other.hasReason()) {
                        setReason(other.getReason());
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
                            setFileId(input.readInt32());
                            continue;
                        case 16:
                            int rawValue = input.readEnum();
                            Reason value = Reason.valueOf(rawValue);
                            if (value != null) {
                                setReason(value);
                                break;
                            }
                            unknownFields.mergeVarintField(2, rawValue);
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

            public boolean hasFileId() {
                return this.result.hasFileId();
            }

            public int getFileId() {
                return this.result.getFileId();
            }

            public Builder setFileId(int value) {
                this.result.hasFileId = true;
                this.result.fileId_ = value;
                return this;
            }

            public Builder clearFileId() {
                this.result.hasFileId = false;
                this.result.fileId_ = 0;
                return this;
            }

            public boolean hasReason() {
                return this.result.hasReason();
            }

            public Reason getReason() {
                return this.result.getReason();
            }

            public Builder setReason(Reason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasReason = true;
                this.result.reason_ = value;
                return this;
            }

            public Builder clearReason() {
                this.result.hasReason = false;
                this.result.reason_ = Reason.None;
                return this;
            }
        }

        public enum Reason implements ProtocolMessageEnum {
            None(0, 0),
            FileExisted(1, 1),
            NoSpace(2, 2);
            
            private static final Reason[] VALUES = null;
            private static EnumLiteMap<Reason> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.baidu.carlife.protobuf.CarlifeStopReceiveDataProto$CarlifeStopReceiveData$Reason$1 */
            static class C20801 implements EnumLiteMap<Reason> {
                C20801() {
                }

                public Reason findValueByNumber(int number) {
                    return Reason.valueOf(number);
                }
            }

            static {
                internalValueMap = new C20801();
                VALUES = new Reason[]{None, FileExisted, NoSpace};
                CarlifeStopReceiveDataProto.getDescriptor();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Reason valueOf(int value) {
                switch (value) {
                    case 0:
                        return None;
                    case 1:
                        return FileExisted;
                    case 2:
                        return NoSpace;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Reason> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) CarlifeStopReceiveData.getDescriptor().getEnumTypes().get(0);
            }

            public static Reason valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private Reason(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private CarlifeStopReceiveData() {
            this.fileId_ = 0;
            this.reason_ = Reason.None;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeStopReceiveDataProto.getDescriptor();
            CarlifeStopReceiveDataProto.internalForceInit();
        }

        public static CarlifeStopReceiveData getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeStopReceiveData getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeStopReceiveDataProto.internal_static_CarlifeStopReceiveData_fieldAccessorTable;
        }

        public boolean hasFileId() {
            return this.hasFileId;
        }

        public int getFileId() {
            return this.fileId_;
        }

        public boolean hasReason() {
            return this.hasReason;
        }

        public Reason getReason() {
            return this.reason_;
        }

        public final boolean isInitialized() {
            if (this.hasFileId) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasFileId()) {
                output.writeInt32(1, getFileId());
            }
            if (hasReason()) {
                output.writeEnum(2, getReason().getNumber());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasFileId()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getFileId());
            }
            if (hasReason()) {
                size += CodedOutputStream.computeEnumSize(2, getReason().getNumber());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeStopReceiveData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeStopReceiveData parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeStopReceiveData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeStopReceiveData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeStopReceiveData prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeStopReceiveDataProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeStopReceiveDataProto.proto\"\u0001\n\u0016CarlifeStopReceiveData\u0012\u000e\n\u0006fileId\u0018\u0001 \u0002(\u0005\u00124\n\u0006reason\u0018\u0002 \u0001(\u000e2\u001e.CarlifeStopReceiveData.Reason:\u0004None\"0\n\u0006Reason\u0012\b\n\u0004None\u0010\u0000\u0012\u000f\n\u000bFileExisted\u0010\u0001\u0012\u000b\n\u0007NoSpace\u0010\u0002B\u001c\n\u001acom.baidu.carlife.protobuf"}, new FileDescriptor[0], new C20791());
    }

    public static void internalForceInit() {
    }
}
