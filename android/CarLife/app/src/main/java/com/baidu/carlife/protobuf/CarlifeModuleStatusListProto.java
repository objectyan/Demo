package com.baidu.carlife.protobuf;

import com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus;
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

public final class CarlifeModuleStatusListProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_descriptor */
    private static Descriptor f6633x70aea296;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeModuleStatusList_fieldAccessorTable */
    private static FieldAccessorTable f6634x3474d314;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeModuleStatusListProto$1 */
    static class C20711 implements InternalDescriptorAssigner {
        C20711() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeModuleStatusListProto.descriptor = root;
            CarlifeModuleStatusListProto.f6633x70aea296 = (Descriptor) CarlifeModuleStatusListProto.getDescriptor().getMessageTypes().get(0);
            CarlifeModuleStatusListProto.f6634x3474d314 = new FieldAccessorTable(CarlifeModuleStatusListProto.f6633x70aea296, new String[]{"Cnt", "ModuleStatus"}, CarlifeModuleStatusList.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeModuleStatusList extends GeneratedMessage {
        public static final int CNT_FIELD_NUMBER = 1;
        public static final int MODULESTATUS_FIELD_NUMBER = 2;
        private static final CarlifeModuleStatusList defaultInstance = new CarlifeModuleStatusList();
        private int cnt_;
        private boolean hasCnt;
        private int memoizedSerializedSize;
        private List<CarlifeModuleStatus> moduleStatus_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeModuleStatusList result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeModuleStatusList();
                return builder;
            }

            protected CarlifeModuleStatusList internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeModuleStatusList();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeModuleStatusList.getDescriptor();
            }

            public CarlifeModuleStatusList getDefaultInstanceForType() {
                return CarlifeModuleStatusList.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeModuleStatusList build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeModuleStatusList buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeModuleStatusList buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.moduleStatus_ != Collections.EMPTY_LIST) {
                    this.result.moduleStatus_ = Collections.unmodifiableList(this.result.moduleStatus_);
                }
                CarlifeModuleStatusList returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeModuleStatusList) {
                    return mergeFrom((CarlifeModuleStatusList) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeModuleStatusList other) {
                if (other != CarlifeModuleStatusList.getDefaultInstance()) {
                    if (other.hasCnt()) {
                        setCnt(other.getCnt());
                    }
                    if (!other.moduleStatus_.isEmpty()) {
                        if (this.result.moduleStatus_.isEmpty()) {
                            this.result.moduleStatus_ = new ArrayList();
                        }
                        this.result.moduleStatus_.addAll(other.moduleStatus_);
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
                            com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus.Builder subBuilder = CarlifeModuleStatus.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addModuleStatus(subBuilder.buildPartial());
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

            public List<CarlifeModuleStatus> getModuleStatusList() {
                return Collections.unmodifiableList(this.result.moduleStatus_);
            }

            public int getModuleStatusCount() {
                return this.result.getModuleStatusCount();
            }

            public CarlifeModuleStatus getModuleStatus(int index) {
                return this.result.getModuleStatus(index);
            }

            public Builder setModuleStatus(int index, CarlifeModuleStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.moduleStatus_.set(index, value);
                return this;
            }

            public Builder setModuleStatus(int index, com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus.Builder builderForValue) {
                this.result.moduleStatus_.set(index, builderForValue.build());
                return this;
            }

            public Builder addModuleStatus(CarlifeModuleStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.moduleStatus_.isEmpty()) {
                    this.result.moduleStatus_ = new ArrayList();
                }
                this.result.moduleStatus_.add(value);
                return this;
            }

            public Builder addModuleStatus(com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus.Builder builderForValue) {
                if (this.result.moduleStatus_.isEmpty()) {
                    this.result.moduleStatus_ = new ArrayList();
                }
                this.result.moduleStatus_.add(builderForValue.build());
                return this;
            }

            public Builder addAllModuleStatus(Iterable<? extends CarlifeModuleStatus> values) {
                if (this.result.moduleStatus_.isEmpty()) {
                    this.result.moduleStatus_ = new ArrayList();
                }
                com.google.protobuf.GeneratedMessage.Builder.addAll(values, this.result.moduleStatus_);
                return this;
            }

            public Builder clearModuleStatus() {
                this.result.moduleStatus_ = Collections.emptyList();
                return this;
            }
        }

        private CarlifeModuleStatusList() {
            this.cnt_ = 0;
            this.moduleStatus_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeModuleStatusListProto.getDescriptor();
            CarlifeModuleStatusListProto.internalForceInit();
        }

        public static CarlifeModuleStatusList getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeModuleStatusList getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeModuleStatusListProto.f6633x70aea296;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeModuleStatusListProto.f6634x3474d314;
        }

        public boolean hasCnt() {
            return this.hasCnt;
        }

        public int getCnt() {
            return this.cnt_;
        }

        public List<CarlifeModuleStatus> getModuleStatusList() {
            return this.moduleStatus_;
        }

        public int getModuleStatusCount() {
            return this.moduleStatus_.size();
        }

        public CarlifeModuleStatus getModuleStatus(int index) {
            return (CarlifeModuleStatus) this.moduleStatus_.get(index);
        }

        public final boolean isInitialized() {
            if (!this.hasCnt) {
                return false;
            }
            for (CarlifeModuleStatus element : getModuleStatusList()) {
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
            for (CarlifeModuleStatus element : getModuleStatusList()) {
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
            for (CarlifeModuleStatus element : getModuleStatusList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeModuleStatusList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatusList parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeModuleStatusList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeModuleStatusList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeModuleStatusList prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeModuleStatusListProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor[] fileDescriptorArr = new FileDescriptor[]{CarlifeModuleStatusProto.getDescriptor()};
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeModuleStatusListProto.proto\u0012\u001acom.baidu.carlife.protobuf\u001a\u001eCarlifeModuleStatusProto.proto\"m\n\u0017CarlifeModuleStatusList\u0012\u000b\n\u0003cnt\u0018\u0001 \u0002(\u0005\u0012E\n\fmoduleStatus\u0018\u0002 \u0003(\u000b2/.com.baidu.carlife.protobuf.CarlifeModuleStatus"}, fileDescriptorArr, new C20711());
    }

    public static void internalForceInit() {
    }
}
