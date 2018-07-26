package com.baidu.carlife.protobuf;

import com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo;
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

public final class CarlifeMediaInfoListProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_descriptor */
    private static Descriptor f6627xaaa428da;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMediaInfoList_fieldAccessorTable */
    private static FieldAccessorTable f6628xddb1d558;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeMediaInfoListProto$1 */
    static class C20681 implements InternalDescriptorAssigner {
        C20681() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeMediaInfoListProto.descriptor = root;
            CarlifeMediaInfoListProto.f6627xaaa428da = (Descriptor) CarlifeMediaInfoListProto.getDescriptor().getMessageTypes().get(0);
            CarlifeMediaInfoListProto.f6628xddb1d558 = new FieldAccessorTable(CarlifeMediaInfoListProto.f6627xaaa428da, new String[]{"Cnt", "MediaInfo"}, CarlifeMediaInfoList.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeMediaInfoList extends GeneratedMessage {
        public static final int CNT_FIELD_NUMBER = 1;
        public static final int MEDIAINFO_FIELD_NUMBER = 2;
        private static final CarlifeMediaInfoList defaultInstance = new CarlifeMediaInfoList();
        private int cnt_;
        private boolean hasCnt;
        private List<CarlifeMediaInfo> mediaInfo_;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeMediaInfoList result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeMediaInfoList();
                return builder;
            }

            protected CarlifeMediaInfoList internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeMediaInfoList();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeMediaInfoList.getDescriptor();
            }

            public CarlifeMediaInfoList getDefaultInstanceForType() {
                return CarlifeMediaInfoList.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeMediaInfoList build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeMediaInfoList buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeMediaInfoList buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.mediaInfo_ != Collections.EMPTY_LIST) {
                    this.result.mediaInfo_ = Collections.unmodifiableList(this.result.mediaInfo_);
                }
                CarlifeMediaInfoList returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeMediaInfoList) {
                    return mergeFrom((CarlifeMediaInfoList) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeMediaInfoList other) {
                if (other != CarlifeMediaInfoList.getDefaultInstance()) {
                    if (other.hasCnt()) {
                        setCnt(other.getCnt());
                    }
                    if (!other.mediaInfo_.isEmpty()) {
                        if (this.result.mediaInfo_.isEmpty()) {
                            this.result.mediaInfo_ = new ArrayList();
                        }
                        this.result.mediaInfo_.addAll(other.mediaInfo_);
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
                            com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo.Builder subBuilder = CarlifeMediaInfo.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMediaInfo(subBuilder.buildPartial());
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

            public List<CarlifeMediaInfo> getMediaInfoList() {
                return Collections.unmodifiableList(this.result.mediaInfo_);
            }

            public int getMediaInfoCount() {
                return this.result.getMediaInfoCount();
            }

            public CarlifeMediaInfo getMediaInfo(int index) {
                return this.result.getMediaInfo(index);
            }

            public Builder setMediaInfo(int index, CarlifeMediaInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.mediaInfo_.set(index, value);
                return this;
            }

            public Builder setMediaInfo(int index, com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo.Builder builderForValue) {
                this.result.mediaInfo_.set(index, builderForValue.build());
                return this;
            }

            public Builder addMediaInfo(CarlifeMediaInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.mediaInfo_.isEmpty()) {
                    this.result.mediaInfo_ = new ArrayList();
                }
                this.result.mediaInfo_.add(value);
                return this;
            }

            public Builder addMediaInfo(com.baidu.carlife.protobuf.CarlifeMediaInfoProto.CarlifeMediaInfo.Builder builderForValue) {
                if (this.result.mediaInfo_.isEmpty()) {
                    this.result.mediaInfo_ = new ArrayList();
                }
                this.result.mediaInfo_.add(builderForValue.build());
                return this;
            }

            public Builder addAllMediaInfo(Iterable<? extends CarlifeMediaInfo> values) {
                if (this.result.mediaInfo_.isEmpty()) {
                    this.result.mediaInfo_ = new ArrayList();
                }
                com.google.protobuf.GeneratedMessage.Builder.addAll(values, this.result.mediaInfo_);
                return this;
            }

            public Builder clearMediaInfo() {
                this.result.mediaInfo_ = Collections.emptyList();
                return this;
            }
        }

        private CarlifeMediaInfoList() {
            this.cnt_ = 0;
            this.mediaInfo_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeMediaInfoListProto.getDescriptor();
            CarlifeMediaInfoListProto.internalForceInit();
        }

        public static CarlifeMediaInfoList getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeMediaInfoList getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeMediaInfoListProto.f6627xaaa428da;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeMediaInfoListProto.f6628xddb1d558;
        }

        public boolean hasCnt() {
            return this.hasCnt;
        }

        public int getCnt() {
            return this.cnt_;
        }

        public List<CarlifeMediaInfo> getMediaInfoList() {
            return this.mediaInfo_;
        }

        public int getMediaInfoCount() {
            return this.mediaInfo_.size();
        }

        public CarlifeMediaInfo getMediaInfo(int index) {
            return (CarlifeMediaInfo) this.mediaInfo_.get(index);
        }

        public final boolean isInitialized() {
            if (!this.hasCnt) {
                return false;
            }
            for (CarlifeMediaInfo element : getMediaInfoList()) {
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
            for (CarlifeMediaInfo element : getMediaInfoList()) {
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
            for (CarlifeMediaInfo element : getMediaInfoList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeMediaInfoList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfoList parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeMediaInfoList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMediaInfoList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeMediaInfoList prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeMediaInfoListProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor[] fileDescriptorArr = new FileDescriptor[]{CarlifeMediaInfoProto.getDescriptor()};
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fCarlifeMediaInfoListProto.proto\u0012\u001acom.baidu.carlife.protobuf\u001a\u001bCarlifeMediaInfoProto.proto\"d\n\u0014CarlifeMediaInfoList\u0012\u000b\n\u0003cnt\u0018\u0001 \u0002(\u0005\u0012?\n\tmediaInfo\u0018\u0002 \u0003(\u000b2,.com.baidu.carlife.protobuf.CarlifeMediaInfo"}, fileDescriptorArr, new C20681());
    }

    public static void internalForceInit() {
    }
}
