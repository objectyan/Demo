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

public final class CarlifeTTSInitProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTTSInit_descriptor */
    private static Descriptor f6654x2586e4c7;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeTTSInit_fieldAccessorTable */
    private static FieldAccessorTable f6655x97045445;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeTTSInitProto$1 */
    static class C20841 implements InternalDescriptorAssigner {
        C20841() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeTTSInitProto.descriptor = root;
            CarlifeTTSInitProto.f6654x2586e4c7 = (Descriptor) CarlifeTTSInitProto.getDescriptor().getMessageTypes().get(0);
            CarlifeTTSInitProto.f6655x97045445 = new FieldAccessorTable(CarlifeTTSInitProto.f6654x2586e4c7, new String[]{"SampleRate", "ChannelConfig", "SampleFormat"}, CarlifeTTSInit.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeTTSInit extends GeneratedMessage {
        public static final int CHANNELCONFIG_FIELD_NUMBER = 2;
        public static final int SAMPLEFORMAT_FIELD_NUMBER = 3;
        public static final int SAMPLERATE_FIELD_NUMBER = 1;
        private static final CarlifeTTSInit defaultInstance = new CarlifeTTSInit();
        private int channelConfig_;
        private boolean hasChannelConfig;
        private boolean hasSampleFormat;
        private boolean hasSampleRate;
        private int memoizedSerializedSize;
        private int sampleFormat_;
        private int sampleRate_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeTTSInit result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeTTSInit();
                return builder;
            }

            protected CarlifeTTSInit internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeTTSInit();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeTTSInit.getDescriptor();
            }

            public CarlifeTTSInit getDefaultInstanceForType() {
                return CarlifeTTSInit.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeTTSInit build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeTTSInit buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeTTSInit buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeTTSInit returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeTTSInit) {
                    return mergeFrom((CarlifeTTSInit) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeTTSInit other) {
                if (other != CarlifeTTSInit.getDefaultInstance()) {
                    if (other.hasSampleRate()) {
                        setSampleRate(other.getSampleRate());
                    }
                    if (other.hasChannelConfig()) {
                        setChannelConfig(other.getChannelConfig());
                    }
                    if (other.hasSampleFormat()) {
                        setSampleFormat(other.getSampleFormat());
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
                            setSampleRate(input.readInt32());
                            continue;
                        case 16:
                            setChannelConfig(input.readInt32());
                            continue;
                        case 24:
                            setSampleFormat(input.readInt32());
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

            public boolean hasSampleRate() {
                return this.result.hasSampleRate();
            }

            public int getSampleRate() {
                return this.result.getSampleRate();
            }

            public Builder setSampleRate(int value) {
                this.result.hasSampleRate = true;
                this.result.sampleRate_ = value;
                return this;
            }

            public Builder clearSampleRate() {
                this.result.hasSampleRate = false;
                this.result.sampleRate_ = 0;
                return this;
            }

            public boolean hasChannelConfig() {
                return this.result.hasChannelConfig();
            }

            public int getChannelConfig() {
                return this.result.getChannelConfig();
            }

            public Builder setChannelConfig(int value) {
                this.result.hasChannelConfig = true;
                this.result.channelConfig_ = value;
                return this;
            }

            public Builder clearChannelConfig() {
                this.result.hasChannelConfig = false;
                this.result.channelConfig_ = 0;
                return this;
            }

            public boolean hasSampleFormat() {
                return this.result.hasSampleFormat();
            }

            public int getSampleFormat() {
                return this.result.getSampleFormat();
            }

            public Builder setSampleFormat(int value) {
                this.result.hasSampleFormat = true;
                this.result.sampleFormat_ = value;
                return this;
            }

            public Builder clearSampleFormat() {
                this.result.hasSampleFormat = false;
                this.result.sampleFormat_ = 0;
                return this;
            }
        }

        private CarlifeTTSInit() {
            this.sampleRate_ = 0;
            this.channelConfig_ = 0;
            this.sampleFormat_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeTTSInitProto.getDescriptor();
            CarlifeTTSInitProto.internalForceInit();
        }

        public static CarlifeTTSInit getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeTTSInit getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeTTSInitProto.f6654x2586e4c7;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeTTSInitProto.f6655x97045445;
        }

        public boolean hasSampleRate() {
            return this.hasSampleRate;
        }

        public int getSampleRate() {
            return this.sampleRate_;
        }

        public boolean hasChannelConfig() {
            return this.hasChannelConfig;
        }

        public int getChannelConfig() {
            return this.channelConfig_;
        }

        public boolean hasSampleFormat() {
            return this.hasSampleFormat;
        }

        public int getSampleFormat() {
            return this.sampleFormat_;
        }

        public final boolean isInitialized() {
            if (this.hasSampleRate && this.hasChannelConfig && this.hasSampleFormat) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasSampleRate()) {
                output.writeInt32(1, getSampleRate());
            }
            if (hasChannelConfig()) {
                output.writeInt32(2, getChannelConfig());
            }
            if (hasSampleFormat()) {
                output.writeInt32(3, getSampleFormat());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasSampleRate()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getSampleRate());
            }
            if (hasChannelConfig()) {
                size += CodedOutputStream.computeInt32Size(2, getChannelConfig());
            }
            if (hasSampleFormat()) {
                size += CodedOutputStream.computeInt32Size(3, getSampleFormat());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeTTSInit parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTTSInit parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeTTSInit parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeTTSInit parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeTTSInit prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeTTSInitProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CarlifeTTSInitProto.proto\u0012\u001acom.baidu.carlife.protobuf\"Q\n\u000eCarlifeTTSInit\u0012\u0012\n\nsampleRate\u0018\u0001 \u0002(\u0005\u0012\u0015\n\rchannelConfig\u0018\u0002 \u0002(\u0005\u0012\u0014\n\fsampleFormat\u0018\u0003 \u0002(\u0005"}, new FileDescriptor[0], new C20841());
    }

    public static void internalForceInit() {
    }
}
