package com.baidu.carlife.protobuf;

import com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CarlifeVehicleInfoListProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_descriptor */
    private static Descriptor f6666xde84d592;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfoList_fieldAccessorTable */
    private static FieldAccessorTable f6667xbd564a10;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeVehicleInfoListProto$1 */
    static class C20981 implements InternalDescriptorAssigner {
        C20981() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeVehicleInfoListProto.descriptor = root;
            CarlifeVehicleInfoListProto.f6666xde84d592 = (Descriptor) CarlifeVehicleInfoListProto.getDescriptor().getMessageTypes().get(0);
            CarlifeVehicleInfoListProto.f6667xbd564a10 = new FieldAccessorTable(CarlifeVehicleInfoListProto.f6666xde84d592, new String[]{"Cnt", "VehicleInfo"}, CarlifeVehicleInfoList.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeVehicleInfoList extends GeneratedMessage {
        public static final int CNT_FIELD_NUMBER = 1;
        public static final int VEHICLEINFO_FIELD_NUMBER = 2;
        private static final CarlifeVehicleInfoList defaultInstance = new CarlifeVehicleInfoList();
        private int cnt_;
        private boolean hasCnt;
        private int memoizedSerializedSize;
        private List<CarlifeVehicleInfo> vehicleInfo_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeVehicleInfoList result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeVehicleInfoList();
                return builder;
            }

            protected CarlifeVehicleInfoList internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeVehicleInfoList();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeVehicleInfoList.getDescriptor();
            }

            public CarlifeVehicleInfoList getDefaultInstanceForType() {
                return CarlifeVehicleInfoList.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeVehicleInfoList build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeVehicleInfoList buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeVehicleInfoList buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.vehicleInfo_ != Collections.EMPTY_LIST) {
                    this.result.vehicleInfo_ = Collections.unmodifiableList(this.result.vehicleInfo_);
                }
                CarlifeVehicleInfoList returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeVehicleInfoList) {
                    return mergeFrom((CarlifeVehicleInfoList) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeVehicleInfoList other) {
                if (other != CarlifeVehicleInfoList.getDefaultInstance()) {
                    if (other.hasCnt()) {
                        setCnt(other.getCnt());
                    }
                    if (!other.vehicleInfo_.isEmpty()) {
                        if (this.result.vehicleInfo_.isEmpty()) {
                            this.result.vehicleInfo_ = new ArrayList();
                        }
                        this.result.vehicleInfo_.addAll(other.vehicleInfo_);
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
                            setCnt(input.readInt32());
                            continue;
                        case 18:
                            com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder subBuilder = CarlifeVehicleInfo.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addVehicleInfo(subBuilder.buildPartial());
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

            public boolean hasCnt() {
                return this.result.hasCnt();
            }

            public int getCnt() {
                return this.result.getCnt();
            }

            public Builder setCnt(int value) {
                this.result.hasCnt = true;
                this.result.cnt_ = value;
                return this;
            }

            public Builder clearCnt() {
                this.result.hasCnt = false;
                this.result.cnt_ = 0;
                return this;
            }

            public List<CarlifeVehicleInfo> getVehicleInfoList() {
                return Collections.unmodifiableList(this.result.vehicleInfo_);
            }

            public int getVehicleInfoCount() {
                return this.result.getVehicleInfoCount();
            }

            public CarlifeVehicleInfo getVehicleInfo(int index) {
                return this.result.getVehicleInfo(index);
            }

            public Builder setVehicleInfo(int index, CarlifeVehicleInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.vehicleInfo_.set(index, value);
                return this;
            }

            public Builder setVehicleInfo(int index, com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder builderForValue) {
                this.result.vehicleInfo_.set(index, builderForValue.build());
                return this;
            }

            public Builder addVehicleInfo(CarlifeVehicleInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.vehicleInfo_.isEmpty()) {
                    this.result.vehicleInfo_ = new ArrayList();
                }
                this.result.vehicleInfo_.add(value);
                return this;
            }

            public Builder addVehicleInfo(com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder builderForValue) {
                if (this.result.vehicleInfo_.isEmpty()) {
                    this.result.vehicleInfo_ = new ArrayList();
                }
                this.result.vehicleInfo_.add(builderForValue.build());
                return this;
            }

            public Builder addAllVehicleInfo(Iterable<? extends CarlifeVehicleInfo> values) {
                if (this.result.vehicleInfo_.isEmpty()) {
                    this.result.vehicleInfo_ = new ArrayList();
                }
                com.google.protobuf.GeneratedMessage.Builder.addAll(values, this.result.vehicleInfo_);
                return this;
            }

            public Builder clearVehicleInfo() {
                this.result.vehicleInfo_ = Collections.emptyList();
                return this;
            }
        }

        private CarlifeVehicleInfoList() {
            this.cnt_ = 0;
            this.vehicleInfo_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeVehicleInfoListProto.getDescriptor();
            CarlifeVehicleInfoListProto.internalForceInit();
        }

        public static CarlifeVehicleInfoList getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeVehicleInfoList getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeVehicleInfoListProto.f6666xde84d592;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeVehicleInfoListProto.f6667xbd564a10;
        }

        public boolean hasCnt() {
            return this.hasCnt;
        }

        public int getCnt() {
            return this.cnt_;
        }

        public List<CarlifeVehicleInfo> getVehicleInfoList() {
            return this.vehicleInfo_;
        }

        public int getVehicleInfoCount() {
            return this.vehicleInfo_.size();
        }

        public CarlifeVehicleInfo getVehicleInfo(int index) {
            return (CarlifeVehicleInfo) this.vehicleInfo_.get(index);
        }

        public final boolean isInitialized() {
            if (!this.hasCnt) {
                return false;
            }
            for (CarlifeVehicleInfo element : getVehicleInfoList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasCnt()) {
                output.writeInt32(1, getCnt());
            }
            for (CarlifeVehicleInfo element : getVehicleInfoList()) {
                output.writeMessage(2, element);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasCnt()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getCnt());
            }
            for (CarlifeVehicleInfo element : getVehicleInfoList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeVehicleInfoList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeVehicleInfoList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeVehicleInfoList prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeVehicleInfoListProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor[] fileDescriptorArr = new FileDescriptor[]{CarlifeVehicleInfoProto.getDescriptor()};
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CarlifeVehicleInfoListProto.proto\u0012\u001acom.baidu.carlife.protobuf\u001a\u001dCarlifeVehicleInfoProto.proto\"j\n\u0016CarlifeVehicleInfoList\u0012\u000b\n\u0003cnt\u0018\u0001 \u0002(\u0005\u0012C\n\u000bvehicleInfo\u0018\u0002 \u0003(\u000b2..com.baidu.carlife.protobuf.CarlifeVehicleInfo"}, fileDescriptorArr, new C20981());
    }

    public static void internalForceInit() {
    }
}
