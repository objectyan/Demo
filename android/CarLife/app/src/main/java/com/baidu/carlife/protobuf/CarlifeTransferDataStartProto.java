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

public final class CarlifeTransferDataStartProto {
    private static FileDescriptor descriptor;
    private static Descriptor internal_static_CarlifeTransferDataStart_descriptor;
    private static FieldAccessorTable internal_static_CarlifeTransferDataStart_fieldAccessorTable;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTransferDataStartProto$1 */
    static class C20901 implements InternalDescriptorAssigner {
        C20901() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTransferDataStartProto.descriptor = root;
            CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_descriptor = (Descriptor) CarlifeTransferDataStartProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_fieldAccessorTable = new FieldAccessorTable(CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_descriptor, new String[]{"FileId", "DataType", "DataLen", "DataName"}, CarlifeTransferDataStart.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTransferDataStart extends GeneratedMessage {
        public static final int DATALEN_FIELD_NUMBER = 3;
        public static final int DATANAME_FIELD_NUMBER = 4;
        public static final int DATATYPE_FIELD_NUMBER = 2;
        public static final int FILEID_FIELD_NUMBER = 1;
        private static final CarlifeTransferDataStart defaultInstance = new CarlifeTransferDataStart();
        private int dataLen_;
        private String dataName_;
        private DataType dataType_;
        private int fileId_;
        private boolean hasDataLen;
        private boolean hasDataName;
        private boolean hasDataType;
        private boolean hasFileId;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTransferDataStart result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTransferDataStart();
                return builder;
            }

            protected CarlifeTransferDataStart internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTransferDataStart();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTransferDataStart.getDescriptor();
            }

            public CarlifeTransferDataStart getDefaultInstanceForType() {
                return CarlifeTransferDataStart.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTransferDataStart build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTransferDataStart buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTransferDataStart buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTransferDataStart returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTransferDataStart) {
                    return mergeFrom((CarlifeTransferDataStart) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTransferDataStart other) {
                if (other != CarlifeTransferDataStart.getDefaultInstance()) {
                    if (other.hasFileId()) {
                        setFileId(other.getFileId());
                    }
                    if (other.hasDataType()) {
                        setDataType(other.getDataType());
                    }
                    if (other.hasDataLen()) {
                        setDataLen(other.getDataLen());
                    }
                    if (other.hasDataName()) {
                        setDataName(other.getDataName());
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
                            DataType value = DataType.valueOf(rawValue);
                            if (value != null) {
                                setDataType(value);
                                break;
                            }
                            unknownFields.mergeVarintField(2, rawValue);
                            continue;
                        case 24:
                            setDataLen(input.readInt32());
                            continue;
                        case 34:
                            setDataName(input.readString());
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

            public boolean hasDataType() {
                return this.result.hasDataType();
            }

            public DataType getDataType() {
                return this.result.getDataType();
            }

            public Builder setDataType(DataType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasDataType = true;
                this.result.dataType_ = value;
                return this;
            }

            public Builder clearDataType() {
                this.result.hasDataType = false;
                this.result.dataType_ = DataType.Firmware;
                return this;
            }

            public boolean hasDataLen() {
                return this.result.hasDataLen();
            }

            public int getDataLen() {
                return this.result.getDataLen();
            }

            public Builder setDataLen(int value) {
                this.result.hasDataLen = true;
                this.result.dataLen_ = value;
                return this;
            }

            public Builder clearDataLen() {
                this.result.hasDataLen = false;
                this.result.dataLen_ = 0;
                return this;
            }

            public boolean hasDataName() {
                return this.result.hasDataName();
            }

            public String getDataName() {
                return this.result.getDataName();
            }

            public Builder setDataName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasDataName = true;
                this.result.dataName_ = value;
                return this;
            }

            public Builder clearDataName() {
                this.result.hasDataName = false;
                this.result.dataName_ = CarlifeTransferDataStart.getDefaultInstance().getDataName();
                return this;
            }
        }

        public enum DataType implements ProtocolMessageEnum {
            Firmware(0, 0),
            Photo(1, 1),
            Video(2, 2),
            QRcode(3, 3);
            
            private static final DataType[] VALUES = null;
            private static EnumLiteMap<DataType> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.baidu.carlife.protobuf.CarlifeTransferDataStartProto$CarlifeTransferDataStart$DataType$1 */
            static class C20911 implements EnumLiteMap<DataType> {
                C20911() {
                }

                public DataType findValueByNumber(int number) {
                    return DataType.valueOf(number);
                }
            }

            static {
                internalValueMap = new C20911();
                VALUES = new DataType[]{Firmware, Photo, Video, QRcode};
                CarlifeTransferDataStartProto.getDescriptor();
            }

            public final int getNumber() {
                return this.value;
            }

            public static DataType valueOf(int value) {
                switch (value) {
                    case 0:
                        return Firmware;
                    case 1:
                        return Photo;
                    case 2:
                        return Video;
                    case 3:
                        return QRcode;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<DataType> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) CarlifeTransferDataStart.getDescriptor().getEnumTypes().get(0);
            }

            public static DataType valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private DataType(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private CarlifeTransferDataStart() {
            this.fileId_ = 0;
            this.dataType_ = DataType.Firmware;
            this.dataLen_ = 0;
            this.dataName_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTransferDataStartProto.getDescriptor();
            CarlifeTransferDataStartProto.internalForceInit();
        }

        public static CarlifeTransferDataStart getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTransferDataStart getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTransferDataStartProto.internal_static_CarlifeTransferDataStart_fieldAccessorTable;
        }

        public boolean hasFileId() {
            return this.hasFileId;
        }

        public int getFileId() {
            return this.fileId_;
        }

        public boolean hasDataType() {
            return this.hasDataType;
        }

        public DataType getDataType() {
            return this.dataType_;
        }

        public boolean hasDataLen() {
            return this.hasDataLen;
        }

        public int getDataLen() {
            return this.dataLen_;
        }

        public boolean hasDataName() {
            return this.hasDataName;
        }

        public String getDataName() {
            return this.dataName_;
        }

        public final boolean isInitialized() {
            if (this.hasFileId && this.hasDataType && this.hasDataLen && this.hasDataName) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasFileId()) {
                output.writeInt32(1, getFileId());
            }
            if (hasDataType()) {
                output.writeEnum(2, getDataType().getNumber());
            }
            if (hasDataLen()) {
                output.writeInt32(3, getDataLen());
            }
            if (hasDataName()) {
                output.writeString(4, getDataName());
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
            if (hasDataType()) {
                size += CodedOutputStream.computeEnumSize(2, getDataType().getNumber());
            }
            if (hasDataLen()) {
                size += CodedOutputStream.computeInt32Size(3, getDataLen());
            }
            if (hasDataName()) {
                size += CodedOutputStream.computeStringSize(4, getDataName());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTransferDataStart parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataStart parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataStart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTransferDataStart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTransferDataStart prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTransferDataStartProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#CarlifeTransferDataStartProto.proto\"¿\u0001\n\u0018CarlifeTransferDataStart\u0012\u000e\n\u0006fileId\u0018\u0001 \u0002(\u0005\u00124\n\bdataType\u0018\u0002 \u0002(\u000e2\".CarlifeTransferDataStart.DataType\u0012\u000f\n\u0007dataLen\u0018\u0003 \u0002(\u0005\u0012\u0010\n\bdataName\u0018\u0004 \u0002(\t\":\n\bDataType\u0012\f\n\bFirmware\u0010\u0000\u0012\t\n\u0005Photo\u0010\u0001\u0012\t\n\u0005Video\u0010\u0002\u0012\n\n\u0006QRcode\u0010\u0003B\u001c\n\u001acom.baidu.carlife.protobuf"}, new FileDescriptor[0], new C20901());
    }

    public static void internalForceInit() {
    }
}
