package com.baidu.carlife.protobuf;

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

public final class CarlifeStatisticsInfoProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_descriptor */
    private static Descriptor f6647xd0cad741;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeStatisticsInfo_fieldAccessorTable */
    private static FieldAccessorTable f6648xa8d32cbf;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeStatisticsInfoProto$1 */
    static class C20781 implements InternalDescriptorAssigner {
        C20781() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeStatisticsInfoProto.descriptor = root;
            CarlifeStatisticsInfoProto.f6647xd0cad741 = (Descriptor) CarlifeStatisticsInfoProto.getDescriptor().getMessageTypes().get(0);
            CarlifeStatisticsInfoProto.f6648xa8d32cbf = new FieldAccessorTable(CarlifeStatisticsInfoProto.f6647xd0cad741, new String[]{"Cuid", "VersionName", "VersionCode", "Channel", "ConnectCount", "ConnectSuccessCount", "ConnectTime", "CrashLog"}, CarlifeStatisticsInfo.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeStatisticsInfo extends GeneratedMessage {
        public static final int CHANNEL_FIELD_NUMBER = 4;
        public static final int CONNECTCOUNT_FIELD_NUMBER = 5;
        public static final int CONNECTSUCCESSCOUNT_FIELD_NUMBER = 6;
        public static final int CONNECTTIME_FIELD_NUMBER = 7;
        public static final int CRASHLOG_FIELD_NUMBER = 8;
        public static final int CUID_FIELD_NUMBER = 1;
        public static final int VERSIONCODE_FIELD_NUMBER = 3;
        public static final int VERSIONNAME_FIELD_NUMBER = 2;
        private static final CarlifeStatisticsInfo defaultInstance = new CarlifeStatisticsInfo();
        private String channel_;
        private int connectCount_;
        private int connectSuccessCount_;
        private int connectTime_;
        private String crashLog_;
        private String cuid_;
        private boolean hasChannel;
        private boolean hasConnectCount;
        private boolean hasConnectSuccessCount;
        private boolean hasConnectTime;
        private boolean hasCrashLog;
        private boolean hasCuid;
        private boolean hasVersionCode;
        private boolean hasVersionName;
        private int memoizedSerializedSize;
        private int versionCode_;
        private String versionName_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeStatisticsInfo result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeStatisticsInfo();
                return builder;
            }

            protected CarlifeStatisticsInfo internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeStatisticsInfo();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeStatisticsInfo.getDescriptor();
            }

            public CarlifeStatisticsInfo getDefaultInstanceForType() {
                return CarlifeStatisticsInfo.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeStatisticsInfo build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeStatisticsInfo buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeStatisticsInfo buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeStatisticsInfo returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeStatisticsInfo) {
                    return mergeFrom((CarlifeStatisticsInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeStatisticsInfo other) {
                if (other != CarlifeStatisticsInfo.getDefaultInstance()) {
                    if (other.hasCuid()) {
                        setCuid(other.getCuid());
                    }
                    if (other.hasVersionName()) {
                        setVersionName(other.getVersionName());
                    }
                    if (other.hasVersionCode()) {
                        setVersionCode(other.getVersionCode());
                    }
                    if (other.hasChannel()) {
                        setChannel(other.getChannel());
                    }
                    if (other.hasConnectCount()) {
                        setConnectCount(other.getConnectCount());
                    }
                    if (other.hasConnectSuccessCount()) {
                        setConnectSuccessCount(other.getConnectSuccessCount());
                    }
                    if (other.hasConnectTime()) {
                        setConnectTime(other.getConnectTime());
                    }
                    if (other.hasCrashLog()) {
                        setCrashLog(other.getCrashLog());
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
                        case 10:
                            setCuid(input.readString());
                            continue;
                        case 18:
                            setVersionName(input.readString());
                            continue;
                        case 24:
                            setVersionCode(input.readInt32());
                            continue;
                        case 34:
                            setChannel(input.readString());
                            continue;
                        case 40:
                            setConnectCount(input.readInt32());
                            continue;
                        case 48:
                            setConnectSuccessCount(input.readInt32());
                            continue;
                        case 56:
                            setConnectTime(input.readInt32());
                            continue;
                        case 66:
                            setCrashLog(input.readString());
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

            public boolean hasCuid() {
                return this.result.hasCuid();
            }

            public String getCuid() {
                return this.result.getCuid();
            }

            public Builder setCuid(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCuid = true;
                this.result.cuid_ = value;
                return this;
            }

            public Builder clearCuid() {
                this.result.hasCuid = false;
                this.result.cuid_ = CarlifeStatisticsInfo.getDefaultInstance().getCuid();
                return this;
            }

            public boolean hasVersionName() {
                return this.result.hasVersionName();
            }

            public String getVersionName() {
                return this.result.getVersionName();
            }

            public Builder setVersionName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasVersionName = true;
                this.result.versionName_ = value;
                return this;
            }

            public Builder clearVersionName() {
                this.result.hasVersionName = false;
                this.result.versionName_ = CarlifeStatisticsInfo.getDefaultInstance().getVersionName();
                return this;
            }

            public boolean hasVersionCode() {
                return this.result.hasVersionCode();
            }

            public int getVersionCode() {
                return this.result.getVersionCode();
            }

            public Builder setVersionCode(int value) {
                this.result.hasVersionCode = true;
                this.result.versionCode_ = value;
                return this;
            }

            public Builder clearVersionCode() {
                this.result.hasVersionCode = false;
                this.result.versionCode_ = 0;
                return this;
            }

            public boolean hasChannel() {
                return this.result.hasChannel();
            }

            public String getChannel() {
                return this.result.getChannel();
            }

            public Builder setChannel(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasChannel = true;
                this.result.channel_ = value;
                return this;
            }

            public Builder clearChannel() {
                this.result.hasChannel = false;
                this.result.channel_ = CarlifeStatisticsInfo.getDefaultInstance().getChannel();
                return this;
            }

            public boolean hasConnectCount() {
                return this.result.hasConnectCount();
            }

            public int getConnectCount() {
                return this.result.getConnectCount();
            }

            public Builder setConnectCount(int value) {
                this.result.hasConnectCount = true;
                this.result.connectCount_ = value;
                return this;
            }

            public Builder clearConnectCount() {
                this.result.hasConnectCount = false;
                this.result.connectCount_ = 0;
                return this;
            }

            public boolean hasConnectSuccessCount() {
                return this.result.hasConnectSuccessCount();
            }

            public int getConnectSuccessCount() {
                return this.result.getConnectSuccessCount();
            }

            public Builder setConnectSuccessCount(int value) {
                this.result.hasConnectSuccessCount = true;
                this.result.connectSuccessCount_ = value;
                return this;
            }

            public Builder clearConnectSuccessCount() {
                this.result.hasConnectSuccessCount = false;
                this.result.connectSuccessCount_ = 0;
                return this;
            }

            public boolean hasConnectTime() {
                return this.result.hasConnectTime();
            }

            public int getConnectTime() {
                return this.result.getConnectTime();
            }

            public Builder setConnectTime(int value) {
                this.result.hasConnectTime = true;
                this.result.connectTime_ = value;
                return this;
            }

            public Builder clearConnectTime() {
                this.result.hasConnectTime = false;
                this.result.connectTime_ = 0;
                return this;
            }

            public boolean hasCrashLog() {
                return this.result.hasCrashLog();
            }

            public String getCrashLog() {
                return this.result.getCrashLog();
            }

            public Builder setCrashLog(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCrashLog = true;
                this.result.crashLog_ = value;
                return this;
            }

            public Builder clearCrashLog() {
                this.result.hasCrashLog = false;
                this.result.crashLog_ = CarlifeStatisticsInfo.getDefaultInstance().getCrashLog();
                return this;
            }
        }

        private CarlifeStatisticsInfo() {
            this.cuid_ = "";
            this.versionName_ = "";
            this.versionCode_ = 0;
            this.channel_ = "";
            this.connectCount_ = 0;
            this.connectSuccessCount_ = 0;
            this.connectTime_ = 0;
            this.crashLog_ = "";
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeStatisticsInfoProto.getDescriptor();
            CarlifeStatisticsInfoProto.internalForceInit();
        }

        public static CarlifeStatisticsInfo getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeStatisticsInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeStatisticsInfoProto.f6647xd0cad741;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeStatisticsInfoProto.f6648xa8d32cbf;
        }

        public boolean hasCuid() {
            return this.hasCuid;
        }

        public String getCuid() {
            return this.cuid_;
        }

        public boolean hasVersionName() {
            return this.hasVersionName;
        }

        public String getVersionName() {
            return this.versionName_;
        }

        public boolean hasVersionCode() {
            return this.hasVersionCode;
        }

        public int getVersionCode() {
            return this.versionCode_;
        }

        public boolean hasChannel() {
            return this.hasChannel;
        }

        public String getChannel() {
            return this.channel_;
        }

        public boolean hasConnectCount() {
            return this.hasConnectCount;
        }

        public int getConnectCount() {
            return this.connectCount_;
        }

        public boolean hasConnectSuccessCount() {
            return this.hasConnectSuccessCount;
        }

        public int getConnectSuccessCount() {
            return this.connectSuccessCount_;
        }

        public boolean hasConnectTime() {
            return this.hasConnectTime;
        }

        public int getConnectTime() {
            return this.connectTime_;
        }

        public boolean hasCrashLog() {
            return this.hasCrashLog;
        }

        public String getCrashLog() {
            return this.crashLog_;
        }

        public final boolean isInitialized() {
            if (this.hasCuid && this.hasVersionName && this.hasVersionCode && this.hasChannel && this.hasConnectCount && this.hasConnectSuccessCount && this.hasConnectTime) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasCuid()) {
                output.writeString(1, getCuid());
            }
            if (hasVersionName()) {
                output.writeString(2, getVersionName());
            }
            if (hasVersionCode()) {
                output.writeInt32(3, getVersionCode());
            }
            if (hasChannel()) {
                output.writeString(4, getChannel());
            }
            if (hasConnectCount()) {
                output.writeInt32(5, getConnectCount());
            }
            if (hasConnectSuccessCount()) {
                output.writeInt32(6, getConnectSuccessCount());
            }
            if (hasConnectTime()) {
                output.writeInt32(7, getConnectTime());
            }
            if (hasCrashLog()) {
                output.writeString(8, getCrashLog());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasCuid()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getCuid());
            }
            if (hasVersionName()) {
                size += CodedOutputStream.computeStringSize(2, getVersionName());
            }
            if (hasVersionCode()) {
                size += CodedOutputStream.computeInt32Size(3, getVersionCode());
            }
            if (hasChannel()) {
                size += CodedOutputStream.computeStringSize(4, getChannel());
            }
            if (hasConnectCount()) {
                size += CodedOutputStream.computeInt32Size(5, getConnectCount());
            }
            if (hasConnectSuccessCount()) {
                size += CodedOutputStream.computeInt32Size(6, getConnectSuccessCount());
            }
            if (hasConnectTime()) {
                size += CodedOutputStream.computeInt32Size(7, getConnectTime());
            }
            if (hasCrashLog()) {
                size += CodedOutputStream.computeStringSize(8, getCrashLog());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeStatisticsInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeStatisticsInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeStatisticsInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeStatisticsInfoProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n CarlifeStatisticsInfoProto.proto\u0012\u001acom.baidu.carlife.protobuf\"º\u0001\n\u0015CarlifeStatisticsInfo\u0012\f\n\u0004cuid\u0018\u0001 \u0002(\t\u0012\u0013\n\u000bversionName\u0018\u0002 \u0002(\t\u0012\u0013\n\u000bversionCode\u0018\u0003 \u0002(\u0005\u0012\u000f\n\u0007channel\u0018\u0004 \u0002(\t\u0012\u0014\n\fconnectCount\u0018\u0005 \u0002(\u0005\u0012\u001b\n\u0013connectSuccessCount\u0018\u0006 \u0002(\u0005\u0012\u0013\n\u000bconnectTime\u0018\u0007 \u0002(\u0005\u0012\u0010\n\bcrashLog\u0018\b \u0001(\t"}, new FileDescriptor[0], new C20781());
    }

    public static void internalForceInit() {
    }
}
