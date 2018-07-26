package com.baidu.carlife.protobuf;

import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo;
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

public final class CarlifeSubscribeMobileCarLifeInfoListProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_descriptor */
    private static Descriptor f6649xab503b02;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfoList_fieldAccessorTable */
    private static FieldAccessorTable f6650x6cdd3f80;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoListProto$1 */
    static class C20811 implements InternalDescriptorAssigner {
        C20811() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeSubscribeMobileCarLifeInfoListProto.descriptor = root;
            CarlifeSubscribeMobileCarLifeInfoListProto.f6649xab503b02 = (Descriptor) CarlifeSubscribeMobileCarLifeInfoListProto.getDescriptor().getMessageTypes().get(0);
            CarlifeSubscribeMobileCarLifeInfoListProto.f6650x6cdd3f80 = new FieldAccessorTable(CarlifeSubscribeMobileCarLifeInfoListProto.f6649xab503b02, new String[]{"Cnt", "SubscribemobileCarLifeInfo"}, CarlifeSubscribeMobileCarLifeInfoList.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeSubscribeMobileCarLifeInfoList extends GeneratedMessage {
        public static final int CNT_FIELD_NUMBER = 1;
        public static final int SUBSCRIBEMOBILECARLIFEINFO_FIELD_NUMBER = 2;
        private static final CarlifeSubscribeMobileCarLifeInfoList defaultInstance = new CarlifeSubscribeMobileCarLifeInfoList();
        private int cnt_;
        private boolean hasCnt;
        private int memoizedSerializedSize;
        private List<CarlifeSubscribeMobileCarLifeInfo> subscribemobileCarLifeInfo_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeSubscribeMobileCarLifeInfoList result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeSubscribeMobileCarLifeInfoList();
                return builder;
            }

            protected CarlifeSubscribeMobileCarLifeInfoList internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeSubscribeMobileCarLifeInfoList();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeSubscribeMobileCarLifeInfoList.getDescriptor();
            }

            public CarlifeSubscribeMobileCarLifeInfoList getDefaultInstanceForType() {
                return CarlifeSubscribeMobileCarLifeInfoList.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeSubscribeMobileCarLifeInfoList build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeSubscribeMobileCarLifeInfoList buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeSubscribeMobileCarLifeInfoList buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.subscribemobileCarLifeInfo_ != Collections.EMPTY_LIST) {
                    this.result.subscribemobileCarLifeInfo_ = Collections.unmodifiableList(this.result.subscribemobileCarLifeInfo_);
                }
                CarlifeSubscribeMobileCarLifeInfoList returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeSubscribeMobileCarLifeInfoList) {
                    return mergeFrom((CarlifeSubscribeMobileCarLifeInfoList) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeSubscribeMobileCarLifeInfoList other) {
                if (other != CarlifeSubscribeMobileCarLifeInfoList.getDefaultInstance()) {
                    if (other.hasCnt()) {
                        setCnt(other.getCnt());
                    }
                    if (!other.subscribemobileCarLifeInfo_.isEmpty()) {
                        if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
                            this.result.subscribemobileCarLifeInfo_ = new ArrayList();
                        }
                        this.result.subscribemobileCarLifeInfo_.addAll(other.subscribemobileCarLifeInfo_);
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
                            com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder subBuilder = CarlifeSubscribeMobileCarLifeInfo.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addSubscribemobileCarLifeInfo(subBuilder.buildPartial());
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

            public List<CarlifeSubscribeMobileCarLifeInfo> getSubscribemobileCarLifeInfoList() {
                return Collections.unmodifiableList(this.result.subscribemobileCarLifeInfo_);
            }

            public int getSubscribemobileCarLifeInfoCount() {
                return this.result.getSubscribemobileCarLifeInfoCount();
            }

            public CarlifeSubscribeMobileCarLifeInfo getSubscribemobileCarLifeInfo(int index) {
                return this.result.getSubscribemobileCarLifeInfo(index);
            }

            public Builder setSubscribemobileCarLifeInfo(int index, CarlifeSubscribeMobileCarLifeInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.subscribemobileCarLifeInfo_.set(index, value);
                return this;
            }

            public Builder setSubscribemobileCarLifeInfo(int index, com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder builderForValue) {
                this.result.subscribemobileCarLifeInfo_.set(index, builderForValue.build());
                return this;
            }

            public Builder addSubscribemobileCarLifeInfo(CarlifeSubscribeMobileCarLifeInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
                    this.result.subscribemobileCarLifeInfo_ = new ArrayList();
                }
                this.result.subscribemobileCarLifeInfo_.add(value);
                return this;
            }

            public Builder addSubscribemobileCarLifeInfo(com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder builderForValue) {
                if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
                    this.result.subscribemobileCarLifeInfo_ = new ArrayList();
                }
                this.result.subscribemobileCarLifeInfo_.add(builderForValue.build());
                return this;
            }

            public Builder addAllSubscribemobileCarLifeInfo(Iterable<? extends CarlifeSubscribeMobileCarLifeInfo> values) {
                if (this.result.subscribemobileCarLifeInfo_.isEmpty()) {
                    this.result.subscribemobileCarLifeInfo_ = new ArrayList();
                }
                com.google.protobuf.GeneratedMessage.Builder.addAll(values, this.result.subscribemobileCarLifeInfo_);
                return this;
            }

            public Builder clearSubscribemobileCarLifeInfo() {
                this.result.subscribemobileCarLifeInfo_ = Collections.emptyList();
                return this;
            }
        }

        private CarlifeSubscribeMobileCarLifeInfoList() {
            this.cnt_ = 0;
            this.subscribemobileCarLifeInfo_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeSubscribeMobileCarLifeInfoListProto.getDescriptor();
            CarlifeSubscribeMobileCarLifeInfoListProto.internalForceInit();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeSubscribeMobileCarLifeInfoList getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeSubscribeMobileCarLifeInfoListProto.f6649xab503b02;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeSubscribeMobileCarLifeInfoListProto.f6650x6cdd3f80;
        }

        public boolean hasCnt() {
            return this.hasCnt;
        }

        public int getCnt() {
            return this.cnt_;
        }

        public List<CarlifeSubscribeMobileCarLifeInfo> getSubscribemobileCarLifeInfoList() {
            return this.subscribemobileCarLifeInfo_;
        }

        public int getSubscribemobileCarLifeInfoCount() {
            return this.subscribemobileCarLifeInfo_.size();
        }

        public CarlifeSubscribeMobileCarLifeInfo getSubscribemobileCarLifeInfo(int index) {
            return (CarlifeSubscribeMobileCarLifeInfo) this.subscribemobileCarLifeInfo_.get(index);
        }

        public final boolean isInitialized() {
            if (!this.hasCnt) {
                return false;
            }
            for (CarlifeSubscribeMobileCarLifeInfo element : getSubscribemobileCarLifeInfoList()) {
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
            for (CarlifeSubscribeMobileCarLifeInfo element : getSubscribemobileCarLifeInfoList()) {
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
            for (CarlifeSubscribeMobileCarLifeInfo element : getSubscribemobileCarLifeInfoList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeSubscribeMobileCarLifeInfoList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeSubscribeMobileCarLifeInfoList prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeSubscribeMobileCarLifeInfoListProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor[] fileDescriptorArr = new FileDescriptor[]{CarlifeSubscribeMobileCarLifeInfoProto.getDescriptor()};
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n0CarlifeSubscribeMobileCarLifeInfoListProto.proto\u0012\u001acom.baidu.carlife.protobuf\u001a,CarlifeSubscribeMobileCarLifeInfoProto.proto\"\u0001\n%CarlifeSubscribeMobileCarLifeInfoList\u0012\u000b\n\u0003cnt\u0018\u0001 \u0002(\u0005\u0012a\n\u001asubscribemobileCarLifeInfo\u0018\u0002 \u0003(\u000b2=.com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfo"}, fileDescriptorArr, new C20811());
    }

    public static void internalForceInit() {
    }
}
