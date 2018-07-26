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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CarlifeConStatisticProto {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_descriptor */
    private static Descriptor f6609x989e7b7d;
    /* renamed from: internal_static_com_baidu_carlife_protobuf_CarlifeConnectStatistics_fieldAccessorTable */
    private static FieldAccessorTable f6610x84ccd4fb;

    /* renamed from: com.baidu.carlife.protobuf.CarlifeConStatisticProto$1 */
    static class C20571 implements InternalDescriptorAssigner {
        C20571() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            CarlifeConStatisticProto.descriptor = root;
            CarlifeConStatisticProto.f6609x989e7b7d = (Descriptor) CarlifeConStatisticProto.getDescriptor().getMessageTypes().get(0);
            CarlifeConStatisticProto.f6610x84ccd4fb = new FieldAccessorTable(CarlifeConStatisticProto.f6609x989e7b7d, new String[]{"Contotal", "Consuccess", "Confailed", "Contime", "Nerrorcount", "ErrorType"}, CarlifeConnectStatistics.class, Builder.class);
            return null;
        }
    }

    public static final class CarlifeConnectStatistics extends GeneratedMessage {
        public static final int CONFAILED_FIELD_NUMBER = 3;
        public static final int CONSUCCESS_FIELD_NUMBER = 2;
        public static final int CONTIME_FIELD_NUMBER = 4;
        public static final int CONTOTAL_FIELD_NUMBER = 1;
        public static final int ERROR_TYPE_FIELD_NUMBER = 6;
        public static final int NERRORCOUNT_FIELD_NUMBER = 5;
        private static final CarlifeConnectStatistics defaultInstance = new CarlifeConnectStatistics();
        private int confailed_;
        private int consuccess_;
        private int contime_;
        private int contotal_;
        private List<String> errorType_;
        private boolean hasConfailed;
        private boolean hasConsuccess;
        private boolean hasContime;
        private boolean hasContotal;
        private boolean hasNerrorcount;
        private int memoizedSerializedSize;
        private int nerrorcount_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private CarlifeConnectStatistics result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new CarlifeConnectStatistics();
                return builder;
            }

            protected CarlifeConnectStatistics internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new CarlifeConnectStatistics();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return CarlifeConnectStatistics.getDescriptor();
            }

            public CarlifeConnectStatistics getDefaultInstanceForType() {
                return CarlifeConnectStatistics.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public CarlifeConnectStatistics build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            private CarlifeConnectStatistics buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public CarlifeConnectStatistics buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.errorType_ != Collections.EMPTY_LIST) {
                    this.result.errorType_ = Collections.unmodifiableList(this.result.errorType_);
                }
                CarlifeConnectStatistics returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof CarlifeConnectStatistics) {
                    return mergeFrom((CarlifeConnectStatistics) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CarlifeConnectStatistics other) {
                if (other != CarlifeConnectStatistics.getDefaultInstance()) {
                    if (other.hasContotal()) {
                        setContotal(other.getContotal());
                    }
                    if (other.hasConsuccess()) {
                        setConsuccess(other.getConsuccess());
                    }
                    if (other.hasConfailed()) {
                        setConfailed(other.getConfailed());
                    }
                    if (other.hasContime()) {
                        setContime(other.getContime());
                    }
                    if (other.hasNerrorcount()) {
                        setNerrorcount(other.getNerrorcount());
                    }
                    if (!other.errorType_.isEmpty()) {
                        if (this.result.errorType_.isEmpty()) {
                            this.result.errorType_ = new ArrayList();
                        }
                        this.result.errorType_.addAll(other.errorType_);
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
                            setContotal(input.readInt32());
                            continue;
                        case 16:
                            setConsuccess(input.readInt32());
                            continue;
                        case 24:
                            setConfailed(input.readInt32());
                            continue;
                        case 32:
                            setContime(input.readInt32());
                            continue;
                        case 40:
                            setNerrorcount(input.readInt32());
                            continue;
                        case 50:
                            addErrorType(input.readString());
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

            public boolean hasContotal() {
                return this.result.hasContotal();
            }

            public int getContotal() {
                return this.result.getContotal();
            }

            public Builder setContotal(int value) {
                this.result.hasContotal = true;
                this.result.contotal_ = value;
                return this;
            }

            public Builder clearContotal() {
                this.result.hasContotal = false;
                this.result.contotal_ = 0;
                return this;
            }

            public boolean hasConsuccess() {
                return this.result.hasConsuccess();
            }

            public int getConsuccess() {
                return this.result.getConsuccess();
            }

            public Builder setConsuccess(int value) {
                this.result.hasConsuccess = true;
                this.result.consuccess_ = value;
                return this;
            }

            public Builder clearConsuccess() {
                this.result.hasConsuccess = false;
                this.result.consuccess_ = 0;
                return this;
            }

            public boolean hasConfailed() {
                return this.result.hasConfailed();
            }

            public int getConfailed() {
                return this.result.getConfailed();
            }

            public Builder setConfailed(int value) {
                this.result.hasConfailed = true;
                this.result.confailed_ = value;
                return this;
            }

            public Builder clearConfailed() {
                this.result.hasConfailed = false;
                this.result.confailed_ = 0;
                return this;
            }

            public boolean hasContime() {
                return this.result.hasContime();
            }

            public int getContime() {
                return this.result.getContime();
            }

            public Builder setContime(int value) {
                this.result.hasContime = true;
                this.result.contime_ = value;
                return this;
            }

            public Builder clearContime() {
                this.result.hasContime = false;
                this.result.contime_ = 0;
                return this;
            }

            public boolean hasNerrorcount() {
                return this.result.hasNerrorcount();
            }

            public int getNerrorcount() {
                return this.result.getNerrorcount();
            }

            public Builder setNerrorcount(int value) {
                this.result.hasNerrorcount = true;
                this.result.nerrorcount_ = value;
                return this;
            }

            public Builder clearNerrorcount() {
                this.result.hasNerrorcount = false;
                this.result.nerrorcount_ = 0;
                return this;
            }

            public List<String> getErrorTypeList() {
                return Collections.unmodifiableList(this.result.errorType_);
            }

            public int getErrorTypeCount() {
                return this.result.getErrorTypeCount();
            }

            public String getErrorType(int index) {
                return this.result.getErrorType(index);
            }

            public Builder setErrorType(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.errorType_.set(index, value);
                return this;
            }

            public Builder addErrorType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.errorType_.isEmpty()) {
                    this.result.errorType_ = new ArrayList();
                }
                this.result.errorType_.add(value);
                return this;
            }

            public Builder addAllErrorType(Iterable<? extends String> values) {
                if (this.result.errorType_.isEmpty()) {
                    this.result.errorType_ = new ArrayList();
                }
                com.google.protobuf.GeneratedMessage.Builder.addAll(values, this.result.errorType_);
                return this;
            }

            public Builder clearErrorType() {
                this.result.errorType_ = Collections.emptyList();
                return this;
            }
        }

        private CarlifeConnectStatistics() {
            this.contotal_ = 0;
            this.consuccess_ = 0;
            this.confailed_ = 0;
            this.contime_ = 0;
            this.nerrorcount_ = 0;
            this.errorType_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            CarlifeConStatisticProto.getDescriptor();
            CarlifeConStatisticProto.internalForceInit();
        }

        public static CarlifeConnectStatistics getDefaultInstance() {
            return defaultInstance;
        }

        public CarlifeConnectStatistics getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return CarlifeConStatisticProto.f6609x989e7b7d;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return CarlifeConStatisticProto.f6610x84ccd4fb;
        }

        public boolean hasContotal() {
            return this.hasContotal;
        }

        public int getContotal() {
            return this.contotal_;
        }

        public boolean hasConsuccess() {
            return this.hasConsuccess;
        }

        public int getConsuccess() {
            return this.consuccess_;
        }

        public boolean hasConfailed() {
            return this.hasConfailed;
        }

        public int getConfailed() {
            return this.confailed_;
        }

        public boolean hasContime() {
            return this.hasContime;
        }

        public int getContime() {
            return this.contime_;
        }

        public boolean hasNerrorcount() {
            return this.hasNerrorcount;
        }

        public int getNerrorcount() {
            return this.nerrorcount_;
        }

        public List<String> getErrorTypeList() {
            return this.errorType_;
        }

        public int getErrorTypeCount() {
            return this.errorType_.size();
        }

        public String getErrorType(int index) {
            return (String) this.errorType_.get(index);
        }

        public final boolean isInitialized() {
            if (this.hasContotal && this.hasConsuccess && this.hasConfailed && this.hasContime && this.hasNerrorcount) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasContotal()) {
                output.writeInt32(1, getContotal());
            }
            if (hasConsuccess()) {
                output.writeInt32(2, getConsuccess());
            }
            if (hasConfailed()) {
                output.writeInt32(3, getConfailed());
            }
            if (hasContime()) {
                output.writeInt32(4, getContime());
            }
            if (hasNerrorcount()) {
                output.writeInt32(5, getNerrorcount());
            }
            for (String element : getErrorTypeList()) {
                output.writeString(6, element);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasContotal()) {
                size = 0 + CodedOutputStream.computeInt32Size(1, getContotal());
            }
            if (hasConsuccess()) {
                size += CodedOutputStream.computeInt32Size(2, getConsuccess());
            }
            if (hasConfailed()) {
                size += CodedOutputStream.computeInt32Size(3, getConfailed());
            }
            if (hasContime()) {
                size += CodedOutputStream.computeInt32Size(4, getContime());
            }
            if (hasNerrorcount()) {
                size += CodedOutputStream.computeInt32Size(5, getNerrorcount());
            }
            int dataSize = 0;
            for (String element : getErrorTypeList()) {
                dataSize += CodedOutputStream.computeStringSizeNoTag(element);
            }
            size = ((size + dataSize) + (getErrorTypeList().size() * 1)) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static CarlifeConnectStatistics parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectStatistics parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static CarlifeConnectStatistics parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static CarlifeConnectStatistics parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(CarlifeConnectStatistics prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private CarlifeConStatisticProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$proto/CarlifeConStatisticProto.proto\u0012\u001acom.baidu.carlife.protobuf\"\u0001\n\u0018CarlifeConnectStatistics\u0012\u0010\n\bcontotal\u0018\u0001 \u0002(\u0005\u0012\u0012\n\nconsuccess\u0018\u0002 \u0002(\u0005\u0012\u0011\n\tconfailed\u0018\u0003 \u0002(\u0005\u0012\u000f\n\u0007contime\u0018\u0004 \u0002(\u0005\u0012\u0013\n\u000bnerrorcount\u0018\u0005 \u0002(\u0005\u0012\u0012\n\nerror_type\u0018\u0006 \u0003(\t"}, new FileDescriptor[0], new C20571());
    }

    public static void internalForceInit() {
    }
}
