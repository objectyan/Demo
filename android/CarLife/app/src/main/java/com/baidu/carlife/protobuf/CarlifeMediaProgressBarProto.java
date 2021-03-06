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

public final class CarlifeMediaProgressBarProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_descriptor */
    private static Descriptor f6631x6a7b5f0;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeMediaProgressBar_fieldAccessorTable */
    private static FieldAccessorTable f6632xf5b9ec6e;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeMediaProgressBarProto$1 */
    static class C20701 implements InternalDescriptorAssigner {
        C20701() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeMediaProgressBarProto.descriptor = root;
            CarlifeMediaProgressBarProto.f6631x6a7b5f0 = (Descriptor) CarlifeMediaProgressBarProto.getDescriptor().getMessageTypes().get(0);
            CarlifeMediaProgressBarProto.f6632xf5b9ec6e = new FieldAccessorTable(CarlifeMediaProgressBarProto.f6631x6a7b5f0, new String[]{"ProgressBar"}, CarlifeMediaProgressBar.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeMediaProgressBar extends GeneratedMessage {
        public static final int PROGRESSBAR_FIELD_NUMBER = 1;
        private static final CarlifeMediaProgressBar defaultInstance = new CarlifeMediaProgressBar();
        private boolean hasProgressBar;
        private int memoizedSerializedSize;
        private int progressBar_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeMediaProgressBar result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeMediaProgressBar();
                return builder;
            }

            protected CarlifeMediaProgressBar internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeMediaProgressBar();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeMediaProgressBar.getDescriptor();
            }

            public CarlifeMediaProgressBar getDefaultInstanceForType() {
                return CarlifeMediaProgressBar.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeMediaProgressBar build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeMediaProgressBar buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeMediaProgressBar buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                CarlifeMediaProgressBar returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeMediaProgressBar) {
                    return mergeFrom((CarlifeMediaProgressBar) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeMediaProgressBar other) {
                if (other != CarlifeMediaProgressBar.getDefaultInstance()) {
                    if (other.hasProgressBar()) {
                        setProgressBar(other.getProgressBar());
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
                            setProgressBar(input.readInt32());
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

            public boolean hasProgressBar() {
                return this.result.hasProgressBar();
            }

            public int getProgressBar() {
                return this.result.getProgressBar();
            }

            public Builder setProgressBar(int value) {
                this.result.hasProgressBar = true;
                this.result.progressBar_ = value;
                return this;
            }

            public Builder clearProgressBar() {
                this.result.hasProgressBar = false;
                this.result.progressBar_ = 0;
                return this;
            }
        }

        private CarlifeMediaProgressBar() {
            this.progressBar_ = 0;
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeMediaProgressBarProto.getDescriptor();
            CarlifeMediaProgressBarProto.internalForceInit();
        }

        public static CarlifeMediaProgressBar getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeMediaProgressBar getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeMediaProgressBarProto.f6631x6a7b5f0;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeMediaProgressBarProto.f6632xf5b9ec6e;
        }

        public boolean hasProgressBar() {
            return this.hasProgressBar;
        }

        public int getProgressBar() {
            return this.progressBar_;
        }

        public final boolean isInitialized() {
            if (this.hasProgressBar) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasProgressBar()) {
                output.writeInt32(1, getProgressBar());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasProgressBar()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getProgressBar());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeMediaProgressBar parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeMediaProgressBar parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeMediaProgressBar prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeMediaProgressBarProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CarlifeMediaProgressBarProto.proto\u0012\u001acom.baidu.carlife.protobuf\".\n\u0017CarlifeMediaProgressBar\u0012\u0013\n\u000bprogressBar\u0018\u0001 \u0002(\u0005"}, new FileDescriptor[0], new C20701());
    }

    public static void internalForceInit() {
    }
}
