package com.baidu.carlife.protobuf;

import com.baidu.carlife.protobuf.CarlifeFeatureConfigProto.CarlifeFeatureConfig;
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

public final class CarlifeFeatureConfigListProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_descriptor */
    private static Descriptor f6617x1ae196f4;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeFeatureConfigList_fieldAccessorTable */
    private static FieldAccessorTable f6618x37948972;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeFeatureConfigListProto$1 */
    static class C20631 implements InternalDescriptorAssigner {
        C20631() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeFeatureConfigListProto.descriptor = root;
            CarlifeFeatureConfigListProto.f6617x1ae196f4 = (Descriptor) CarlifeFeatureConfigListProto.getDescriptor().getMessageTypes().get(0);
            CarlifeFeatureConfigListProto.f6618x37948972 = new FieldAccessorTable(CarlifeFeatureConfigListProto.f6617x1ae196f4, new String[]{"Cnt", "FeatureConfig"}, CarlifeFeatureConfigList.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeFeatureConfigList extends GeneratedMessage {
        public static final int CNT_FIELD_NUMBER = 1;
        public static final int FEATURECONFIG_FIELD_NUMBER = 2;
        private static final CarlifeFeatureConfigList defaultInstance = new CarlifeFeatureConfigList();
        private int cnt_;
        private List<CarlifeFeatureConfig> featureConfig_;
        private boolean hasCnt;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeFeatureConfigList result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeFeatureConfigList();
                return builder;
            }

            protected CarlifeFeatureConfigList internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeFeatureConfigList();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeFeatureConfigList.getDescriptor();
            }

            public CarlifeFeatureConfigList getDefaultInstanceForType() {
                return CarlifeFeatureConfigList.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeFeatureConfigList build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeFeatureConfigList buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeFeatureConfigList buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.featureConfig_ != Collections.EMPTY_LIST) {
                    this.result.featureConfig_ = Collections.unmodifiableList(this.result.featureConfig_);
                }
                CarlifeFeatureConfigList returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeFeatureConfigList) {
                    return mergeFrom((CarlifeFeatureConfigList) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeFeatureConfigList other) {
                if (other != CarlifeFeatureConfigList.getDefaultInstance()) {
                    if (other.hasCnt()) {
                        setCnt(other.getCnt());
                    }
                    if (!other.featureConfig_.isEmpty()) {
                        if (this.result.featureConfig_.isEmpty()) {
                            this.result.featureConfig_ = new ArrayList();
                        }
                        this.result.featureConfig_.addAll(other.featureConfig_);
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
                            com.baidu.carlife.protobuf.CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder subBuilder = CarlifeFeatureConfig.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addFeatureConfig(subBuilder.buildPartial());
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

            public List<CarlifeFeatureConfig> getFeatureConfigList() {
                return Collections.unmodifiableList(this.result.featureConfig_);
            }

            public int getFeatureConfigCount() {
                return this.result.getFeatureConfigCount();
            }

            public CarlifeFeatureConfig getFeatureConfig(int index) {
                return this.result.getFeatureConfig(index);
            }

            public Builder setFeatureConfig(int index, CarlifeFeatureConfig value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.featureConfig_.set(index, value);
                return this;
            }

            public Builder setFeatureConfig(int index, com.baidu.carlife.protobuf.CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder builderForValue) {
                this.result.featureConfig_.set(index, builderForValue.build());
                return this;
            }

            public Builder addFeatureConfig(CarlifeFeatureConfig value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.featureConfig_.isEmpty()) {
                    this.result.featureConfig_ = new ArrayList();
                }
                this.result.featureConfig_.add(value);
                return this;
            }

            public Builder addFeatureConfig(com.baidu.carlife.protobuf.CarlifeFeatureConfigProto.CarlifeFeatureConfig.Builder builderForValue) {
                if (this.result.featureConfig_.isEmpty()) {
                    this.result.featureConfig_ = new ArrayList();
                }
                this.result.featureConfig_.add(builderForValue.build());
                return this;
            }

            public Builder addAllFeatureConfig(Iterable<? extends CarlifeFeatureConfig> values) {
                if (this.result.featureConfig_.isEmpty()) {
                    this.result.featureConfig_ = new ArrayList();
                }
                com.google.protobuf.GeneratedMessage.Builder.addAll(values, this.result.featureConfig_);
                return this;
            }

            public Builder clearFeatureConfig() {
                this.result.featureConfig_ = Collections.emptyList();
                return this;
            }
        }

        private CarlifeFeatureConfigList() {
            this.cnt_ = 0;
            this.featureConfig_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeFeatureConfigListProto.getDescriptor();
            CarlifeFeatureConfigListProto.internalForceInit();
        }

        public static CarlifeFeatureConfigList getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeFeatureConfigList getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeFeatureConfigListProto.f6617x1ae196f4;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeFeatureConfigListProto.f6618x37948972;
        }

        public boolean hasCnt() {
            return this.hasCnt;
        }

        public int getCnt() {
            return this.cnt_;
        }

        public List<CarlifeFeatureConfig> getFeatureConfigList() {
            return this.featureConfig_;
        }

        public int getFeatureConfigCount() {
            return this.featureConfig_.size();
        }

        public CarlifeFeatureConfig getFeatureConfig(int index) {
            return (CarlifeFeatureConfig) this.featureConfig_.get(index);
        }

        public final boolean isInitialized() {
            if (!this.hasCnt) {
                return false;
            }
            for (CarlifeFeatureConfig element : getFeatureConfigList()) {
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
            for (CarlifeFeatureConfig element : getFeatureConfigList()) {
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
            for (CarlifeFeatureConfig element : getFeatureConfigList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeFeatureConfigList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeFeatureConfigList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeFeatureConfigList prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeFeatureConfigListProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor[] fileDescriptorArr = new FileDescriptor[]{CarlifeFeatureConfigProto.getDescriptor()};
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#CarlifeFeatureConfigListProto.proto\u0012\u001acom.baidu.carlife.protobuf\u001a\u001fCarlifeFeatureConfigProto.proto\"p\n\u0018CarlifeFeatureConfigList\u0012\u000b\n\u0003cnt\u0018\u0001 \u0002(\u0005\u0012G\n\rfeatureConfig\u0018\u0002 \u0003(\u000b20.com.baidu.carlife.protobuf.CarlifeFeatureConfig"}, fileDescriptorArr, new C20631());
    }

    public static void internalForceInit() {
    }
}
