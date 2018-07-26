package com.google.protobuf;

import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.baidunavis.model.NavCarInfo;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner;
import com.google.protobuf.GeneratedMessage.ExtendableBuilder;
import com.google.protobuf.GeneratedMessage.ExtendableMessage;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.Internal.EnumLiteMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DescriptorProtos {
    private static FileDescriptor descriptor;
    /* renamed from: internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor */
    private static Descriptor f22839x1458f8d;
    /* renamed from: internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable */
    private static FieldAccessorTable f22840xf366d90b;
    private static Descriptor internal_static_google_protobuf_DescriptorProto_descriptor;
    /* renamed from: internal_static_google_protobuf_DescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22841x907d0bf0;
    private static Descriptor internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    /* renamed from: internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22842x9945f651;
    private static Descriptor internal_static_google_protobuf_EnumOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
    /* renamed from: internal_static_google_protobuf_EnumValueDescriptorProto_descriptor */
    private static Descriptor f22843xf18031a8;
    /* renamed from: internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22844xfb173026;
    private static Descriptor internal_static_google_protobuf_EnumValueOptions_descriptor;
    /* renamed from: internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable */
    private static FieldAccessorTable f22845xdf65a421;
    private static Descriptor internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    /* renamed from: internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22846x4734b330;
    private static Descriptor internal_static_google_protobuf_FieldOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
    private static Descriptor internal_static_google_protobuf_FileDescriptorProto_descriptor;
    /* renamed from: internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22847x4b52780c;
    private static Descriptor internal_static_google_protobuf_FileDescriptorSet_descriptor;
    /* renamed from: internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable */
    private static FieldAccessorTable f22848x15a6a952;
    private static Descriptor internal_static_google_protobuf_FileOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_FileOptions_fieldAccessorTable;
    private static Descriptor internal_static_google_protobuf_MessageOptions_descriptor;
    /* renamed from: internal_static_google_protobuf_MessageOptions_fieldAccessorTable */
    private static FieldAccessorTable f22849x9c0b3d38;
    private static Descriptor internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    /* renamed from: internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22850xc5331ef1;
    private static Descriptor internal_static_google_protobuf_MethodOptions_descriptor;
    private static FieldAccessorTable internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
    /* renamed from: internal_static_google_protobuf_ServiceDescriptorProto_descriptor */
    private static Descriptor f22851x158c73ed;
    /* renamed from: internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable */
    private static FieldAccessorTable f22852xee335d6b;
    private static Descriptor internal_static_google_protobuf_ServiceOptions_descriptor;
    /* renamed from: internal_static_google_protobuf_ServiceOptions_fieldAccessorTable */
    private static FieldAccessorTable f22853x371e666;
    /* renamed from: internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor */
    private static Descriptor f22854xb111d23c;
    /* renamed from: internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable */
    private static FieldAccessorTable f22855x1698fcba;
    private static Descriptor internal_static_google_protobuf_UninterpretedOption_descriptor;
    /* renamed from: internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable */
    private static FieldAccessorTable f22856x2101041;

    /* renamed from: com.google.protobuf.DescriptorProtos$1 */
    static class C57291 implements InternalDescriptorAssigner {
        C57291() {
        }

        public ExtensionRegistry assignDescriptors(FileDescriptor root) {
            DescriptorProtos.descriptor = root;
            DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(0);
            DescriptorProtos.f22848x15a6a952 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor, new String[]{"File"}, FileDescriptorSet.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(1);
            DescriptorProtos.f22847x4b52780c = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor, new String[]{"Name", "Package", "Dependency", "MessageType", "EnumType", "Service", "Extension", "Options"}, FileDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(2);
            DescriptorProtos.f22841x907d0bf0 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"}, DescriptorProto.class, Builder.class);
            DescriptorProtos.f22839x1458f8d = (Descriptor) DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor.getNestedTypes().get(0);
            DescriptorProtos.f22840xf366d90b = new FieldAccessorTable(DescriptorProtos.f22839x1458f8d, new String[]{"Start", "End"}, ExtensionRange.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(3);
            DescriptorProtos.f22846x4734b330 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"}, FieldDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(4);
            DescriptorProtos.f22842x9945f651 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor, new String[]{"Name", "Value", "Options"}, EnumDescriptorProto.class, Builder.class);
            DescriptorProtos.f22843xf18031a8 = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(5);
            DescriptorProtos.f22844xfb173026 = new FieldAccessorTable(DescriptorProtos.f22843xf18031a8, new String[]{"Name", "Number", "Options"}, EnumValueDescriptorProto.class, Builder.class);
            DescriptorProtos.f22851x158c73ed = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(6);
            DescriptorProtos.f22852xee335d6b = new FieldAccessorTable(DescriptorProtos.f22851x158c73ed, new String[]{"Name", "Method", "Options"}, ServiceDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(7);
            DescriptorProtos.f22850xc5331ef1 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor, new String[]{"Name", "InputType", "OutputType", "Options"}, MethodDescriptorProto.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(8);
            DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "OptimizeFor", "UninterpretedOption"}, FileOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(9);
            DescriptorProtos.f22849x9c0b3d38 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"}, MessageOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(10);
            DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor, new String[]{"Ctype", "Packed", "Deprecated", "ExperimentalMapKey", "UninterpretedOption"}, FieldOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(11);
            DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor, new String[]{"UninterpretedOption"}, EnumOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(12);
            DescriptorProtos.f22845xdf65a421 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor, new String[]{"UninterpretedOption"}, EnumValueOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(13);
            DescriptorProtos.f22853x371e666 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor, new String[]{"UninterpretedOption"}, ServiceOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(14);
            DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor, new String[]{"UninterpretedOption"}, MethodOptions.class, Builder.class);
            DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor = (Descriptor) DescriptorProtos.getDescriptor().getMessageTypes().get(15);
            DescriptorProtos.f22856x2101041 = new FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue"}, UninterpretedOption.class, Builder.class);
            DescriptorProtos.f22854xb111d23c = (Descriptor) DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor.getNestedTypes().get(0);
            DescriptorProtos.f22855x1698fcba = new FieldAccessorTable(DescriptorProtos.f22854xb111d23c, new String[]{"NamePart", "IsExtension"}, NamePart.class, Builder.class);
            return null;
        }
    }

    public static final class DescriptorProto extends GeneratedMessage {
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static final DescriptorProto defaultInstance = new DescriptorProto();
        private List<EnumDescriptorProto> enumType_;
        private List<ExtensionRange> extensionRange_;
        private List<FieldDescriptorProto> extension_;
        private List<FieldDescriptorProto> field_;
        private boolean hasName;
        private boolean hasOptions;
        private int memoizedSerializedSize;
        private String name_;
        private List<DescriptorProto> nestedType_;
        private MessageOptions options_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private DescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new DescriptorProto();
                return builder;
            }

            protected DescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new DescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return DescriptorProto.getDescriptor();
            }

            public DescriptorProto getDefaultInstanceForType() {
                return DescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public DescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private DescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public DescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.field_ != Collections.EMPTY_LIST) {
                    this.result.field_ = Collections.unmodifiableList(this.result.field_);
                }
                if (this.result.extension_ != Collections.EMPTY_LIST) {
                    this.result.extension_ = Collections.unmodifiableList(this.result.extension_);
                }
                if (this.result.nestedType_ != Collections.EMPTY_LIST) {
                    this.result.nestedType_ = Collections.unmodifiableList(this.result.nestedType_);
                }
                if (this.result.enumType_ != Collections.EMPTY_LIST) {
                    this.result.enumType_ = Collections.unmodifiableList(this.result.enumType_);
                }
                if (this.result.extensionRange_ != Collections.EMPTY_LIST) {
                    this.result.extensionRange_ = Collections.unmodifiableList(this.result.extensionRange_);
                }
                DescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof DescriptorProto) {
                    return mergeFrom((DescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DescriptorProto other) {
                if (other != DescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (!other.field_.isEmpty()) {
                        if (this.result.field_.isEmpty()) {
                            this.result.field_ = new ArrayList();
                        }
                        this.result.field_.addAll(other.field_);
                    }
                    if (!other.extension_.isEmpty()) {
                        if (this.result.extension_.isEmpty()) {
                            this.result.extension_ = new ArrayList();
                        }
                        this.result.extension_.addAll(other.extension_);
                    }
                    if (!other.nestedType_.isEmpty()) {
                        if (this.result.nestedType_.isEmpty()) {
                            this.result.nestedType_ = new ArrayList();
                        }
                        this.result.nestedType_.addAll(other.nestedType_);
                    }
                    if (!other.enumType_.isEmpty()) {
                        if (this.result.enumType_.isEmpty()) {
                            this.result.enumType_ = new ArrayList();
                        }
                        this.result.enumType_.addAll(other.enumType_);
                    }
                    if (!other.extensionRange_.isEmpty()) {
                        if (this.result.extensionRange_.isEmpty()) {
                            this.result.extensionRange_ = new ArrayList();
                        }
                        this.result.extensionRange_.addAll(other.extensionRange_);
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    Builder subBuilder;
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            break;
                        case 10:
                            setName(input.readString());
                            continue;
                        case 18:
                            subBuilder = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addField(subBuilder.buildPartial());
                            continue;
                        case 26:
                            Builder subBuilder2 = DescriptorProto.newBuilder();
                            input.readMessage(subBuilder2, extensionRegistry);
                            addNestedType(subBuilder2.buildPartial());
                            continue;
                        case 34:
                            Builder subBuilder3 = EnumDescriptorProto.newBuilder();
                            input.readMessage(subBuilder3, extensionRegistry);
                            addEnumType(subBuilder3.buildPartial());
                            continue;
                        case 42:
                            Builder subBuilder4 = ExtensionRange.newBuilder();
                            input.readMessage(subBuilder4, extensionRegistry);
                            addExtensionRange(subBuilder4.buildPartial());
                            continue;
                        case 50:
                            subBuilder = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addExtension(subBuilder.buildPartial());
                            continue;
                        case 58:
                            Builder subBuilder5 = MessageOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder5.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder5, extensionRegistry);
                            setOptions(subBuilder5.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = DescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public List<FieldDescriptorProto> getFieldList() {
                return Collections.unmodifiableList(this.result.field_);
            }

            public int getFieldCount() {
                return this.result.getFieldCount();
            }

            public FieldDescriptorProto getField(int index) {
                return this.result.getField(index);
            }

            public Builder setField(int index, FieldDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.field_.set(index, value);
                return this;
            }

            public Builder setField(int index, Builder builderForValue) {
                this.result.field_.set(index, builderForValue.build());
                return this;
            }

            public Builder addField(FieldDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.field_.isEmpty()) {
                    this.result.field_ = new ArrayList();
                }
                this.result.field_.add(value);
                return this;
            }

            public Builder addField(Builder builderForValue) {
                if (this.result.field_.isEmpty()) {
                    this.result.field_ = new ArrayList();
                }
                this.result.field_.add(builderForValue.build());
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> values) {
                if (this.result.field_.isEmpty()) {
                    this.result.field_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.field_);
                return this;
            }

            public Builder clearField() {
                this.result.field_ = Collections.emptyList();
                return this;
            }

            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(this.result.extension_);
            }

            public int getExtensionCount() {
                return this.result.getExtensionCount();
            }

            public FieldDescriptorProto getExtension(int index) {
                return this.result.getExtension(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.extension_.set(index, value);
                return this;
            }

            public Builder setExtension(int index, Builder builderForValue) {
                this.result.extension_.set(index, builderForValue.build());
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.extension_.isEmpty()) {
                    this.result.extension_ = new ArrayList();
                }
                this.result.extension_.add(value);
                return this;
            }

            public Builder addExtension(Builder builderForValue) {
                if (this.result.extension_.isEmpty()) {
                    this.result.extension_ = new ArrayList();
                }
                this.result.extension_.add(builderForValue.build());
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                if (this.result.extension_.isEmpty()) {
                    this.result.extension_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.extension_);
                return this;
            }

            public Builder clearExtension() {
                this.result.extension_ = Collections.emptyList();
                return this;
            }

            public List<DescriptorProto> getNestedTypeList() {
                return Collections.unmodifiableList(this.result.nestedType_);
            }

            public int getNestedTypeCount() {
                return this.result.getNestedTypeCount();
            }

            public DescriptorProto getNestedType(int index) {
                return this.result.getNestedType(index);
            }

            public Builder setNestedType(int index, DescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.nestedType_.set(index, value);
                return this;
            }

            public Builder setNestedType(int index, Builder builderForValue) {
                this.result.nestedType_.set(index, builderForValue.build());
                return this;
            }

            public Builder addNestedType(DescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.nestedType_.isEmpty()) {
                    this.result.nestedType_ = new ArrayList();
                }
                this.result.nestedType_.add(value);
                return this;
            }

            public Builder addNestedType(Builder builderForValue) {
                if (this.result.nestedType_.isEmpty()) {
                    this.result.nestedType_ = new ArrayList();
                }
                this.result.nestedType_.add(builderForValue.build());
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> values) {
                if (this.result.nestedType_.isEmpty()) {
                    this.result.nestedType_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.nestedType_);
                return this;
            }

            public Builder clearNestedType() {
                this.result.nestedType_ = Collections.emptyList();
                return this;
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(this.result.enumType_);
            }

            public int getEnumTypeCount() {
                return this.result.getEnumTypeCount();
            }

            public EnumDescriptorProto getEnumType(int index) {
                return this.result.getEnumType(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.enumType_.set(index, value);
                return this;
            }

            public Builder setEnumType(int index, Builder builderForValue) {
                this.result.enumType_.set(index, builderForValue.build());
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.enumType_.isEmpty()) {
                    this.result.enumType_ = new ArrayList();
                }
                this.result.enumType_.add(value);
                return this;
            }

            public Builder addEnumType(Builder builderForValue) {
                if (this.result.enumType_.isEmpty()) {
                    this.result.enumType_ = new ArrayList();
                }
                this.result.enumType_.add(builderForValue.build());
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                if (this.result.enumType_.isEmpty()) {
                    this.result.enumType_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.enumType_);
                return this;
            }

            public Builder clearEnumType() {
                this.result.enumType_ = Collections.emptyList();
                return this;
            }

            public List<ExtensionRange> getExtensionRangeList() {
                return Collections.unmodifiableList(this.result.extensionRange_);
            }

            public int getExtensionRangeCount() {
                return this.result.getExtensionRangeCount();
            }

            public ExtensionRange getExtensionRange(int index) {
                return this.result.getExtensionRange(index);
            }

            public Builder setExtensionRange(int index, ExtensionRange value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.extensionRange_.set(index, value);
                return this;
            }

            public Builder setExtensionRange(int index, Builder builderForValue) {
                this.result.extensionRange_.set(index, builderForValue.build());
                return this;
            }

            public Builder addExtensionRange(ExtensionRange value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.extensionRange_.isEmpty()) {
                    this.result.extensionRange_ = new ArrayList();
                }
                this.result.extensionRange_.add(value);
                return this;
            }

            public Builder addExtensionRange(Builder builderForValue) {
                if (this.result.extensionRange_.isEmpty()) {
                    this.result.extensionRange_ = new ArrayList();
                }
                this.result.extensionRange_.add(builderForValue.build());
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> values) {
                if (this.result.extensionRange_.isEmpty()) {
                    this.result.extensionRange_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.extensionRange_);
                return this;
            }

            public Builder clearExtensionRange() {
                this.result.extensionRange_ = Collections.emptyList();
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public MessageOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(MessageOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(MessageOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == MessageOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = MessageOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = MessageOptions.getDefaultInstance();
                return this;
            }
        }

        public static final class ExtensionRange extends GeneratedMessage {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final ExtensionRange defaultInstance = new ExtensionRange();
            private int end_;
            private boolean hasEnd;
            private boolean hasStart;
            private int memoizedSerializedSize;
            private int start_;

            public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
                private ExtensionRange result;

                private Builder() {
                }

                private static Builder create() {
                    Builder builder = new Builder();
                    builder.result = new ExtensionRange();
                    return builder;
                }

                protected ExtensionRange internalGetResult() {
                    return this.result;
                }

                public Builder clear() {
                    if (this.result == null) {
                        throw new IllegalStateException("Cannot call clear() after build().");
                    }
                    this.result = new ExtensionRange();
                    return this;
                }

                public Builder clone() {
                    return create().mergeFrom(this.result);
                }

                public Descriptor getDescriptorForType() {
                    return ExtensionRange.getDescriptor();
                }

                public ExtensionRange getDefaultInstanceForType() {
                    return ExtensionRange.getDefaultInstance();
                }

                public boolean isInitialized() {
                    return this.result.isInitialized();
                }

                public ExtensionRange build() {
                    if (this.result == null || isInitialized()) {
                        return buildPartial();
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
                }

                private ExtensionRange buildParsed() throws InvalidProtocolBufferException {
                    if (isInitialized()) {
                        return buildPartial();
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
                }

                public ExtensionRange buildPartial() {
                    if (this.result == null) {
                        throw new IllegalStateException("build() has already been called on this Builder.");
                    }
                    ExtensionRange returnMe = this.result;
                    this.result = null;
                    return returnMe;
                }

                public Builder mergeFrom(Message other) {
                    if (other instanceof ExtensionRange) {
                        return mergeFrom((ExtensionRange) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(ExtensionRange other) {
                    if (other != ExtensionRange.getDefaultInstance()) {
                        if (other.hasStart()) {
                            setStart(other.getStart());
                        }
                        if (other.hasEnd()) {
                            setEnd(other.getEnd());
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
                                setStart(input.readInt32());
                                continue;
                            case 16:
                                setEnd(input.readInt32());
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

                public boolean hasStart() {
                    return this.result.hasStart();
                }

                public int getStart() {
                    return this.result.getStart();
                }

                public Builder setStart(int value) {
                    this.result.hasStart = true;
                    this.result.start_ = value;
                    return this;
                }

                public Builder clearStart() {
                    this.result.hasStart = false;
                    this.result.start_ = 0;
                    return this;
                }

                public boolean hasEnd() {
                    return this.result.hasEnd();
                }

                public int getEnd() {
                    return this.result.getEnd();
                }

                public Builder setEnd(int value) {
                    this.result.hasEnd = true;
                    this.result.end_ = value;
                    return this;
                }

                public Builder clearEnd() {
                    this.result.hasEnd = false;
                    this.result.end_ = 0;
                    return this;
                }
            }

            private ExtensionRange() {
                this.start_ = 0;
                this.end_ = 0;
                this.memoizedSerializedSize = -1;
            }

            static {
                DescriptorProtos.getDescriptor();
                DescriptorProtos.internalForceInit();
            }

            public static ExtensionRange getDefaultInstance() {
                return defaultInstance;
            }

            public ExtensionRange getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f22839x1458f8d;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f22840xf366d90b;
            }

            public boolean hasStart() {
                return this.hasStart;
            }

            public int getStart() {
                return this.start_;
            }

            public boolean hasEnd() {
                return this.hasEnd;
            }

            public int getEnd() {
                return this.end_;
            }

            public final boolean isInitialized() {
                return true;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if (hasStart()) {
                    output.writeInt32(1, getStart());
                }
                if (hasEnd()) {
                    output.writeInt32(2, getEnd());
                }
                getUnknownFields().writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if (hasStart()) {
                    size = 0 + CodedOutputStream.computeInt32Size(1, getStart());
                }
                if (hasEnd()) {
                    size += CodedOutputStream.computeInt32Size(2, getEnd());
                }
                size += getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }

            public static ExtensionRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static ExtensionRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static ExtensionRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static ExtensionRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static ExtensionRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(ExtensionRange prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }
        }

        private DescriptorProto() {
            this.name_ = "";
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.options_ = MessageOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static DescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public DescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22841x907d0bf0;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public int getFieldCount() {
            return this.field_.size();
        }

        public FieldDescriptorProto getField(int index) {
            return (FieldDescriptorProto) this.field_.get(index);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int index) {
            return (FieldDescriptorProto) this.extension_.get(index);
        }

        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        public DescriptorProto getNestedType(int index) {
            return (DescriptorProto) this.nestedType_.get(index);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int index) {
            return (EnumDescriptorProto) this.enumType_.get(index);
        }

        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        public ExtensionRange getExtensionRange(int index) {
            return (ExtensionRange) this.extensionRange_.get(index);
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public MessageOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            for (FieldDescriptorProto element : getFieldList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            for (FieldDescriptorProto element2 : getExtensionList()) {
                if (!element2.isInitialized()) {
                    return false;
                }
            }
            for (DescriptorProto element3 : getNestedTypeList()) {
                if (!element3.isInitialized()) {
                    return false;
                }
            }
            for (EnumDescriptorProto element4 : getEnumTypeList()) {
                if (!element4.isInitialized()) {
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            for (FieldDescriptorProto element : getFieldList()) {
                output.writeMessage(2, element);
            }
            for (DescriptorProto element2 : getNestedTypeList()) {
                output.writeMessage(3, element2);
            }
            for (EnumDescriptorProto element3 : getEnumTypeList()) {
                output.writeMessage(4, element3);
            }
            for (ExtensionRange element4 : getExtensionRangeList()) {
                output.writeMessage(5, element4);
            }
            for (FieldDescriptorProto element5 : getExtensionList()) {
                output.writeMessage(6, element5);
            }
            if (hasOptions()) {
                output.writeMessage(7, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            for (FieldDescriptorProto element : getFieldList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            for (DescriptorProto element2 : getNestedTypeList()) {
                size += CodedOutputStream.computeMessageSize(3, element2);
            }
            for (EnumDescriptorProto element3 : getEnumTypeList()) {
                size += CodedOutputStream.computeMessageSize(4, element3);
            }
            for (ExtensionRange element4 : getExtensionRangeList()) {
                size += CodedOutputStream.computeMessageSize(5, element4);
            }
            for (FieldDescriptorProto element5 : getExtensionList()) {
                size += CodedOutputStream.computeMessageSize(6, element5);
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(7, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static DescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static DescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static DescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static DescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static DescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class EnumDescriptorProto extends GeneratedMessage {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final EnumDescriptorProto defaultInstance = new EnumDescriptorProto();
        private boolean hasName;
        private boolean hasOptions;
        private int memoizedSerializedSize;
        private String name_;
        private EnumOptions options_;
        private List<EnumValueDescriptorProto> value_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private EnumDescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new EnumDescriptorProto();
                return builder;
            }

            protected EnumDescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new EnumDescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return EnumDescriptorProto.getDescriptor();
            }

            public EnumDescriptorProto getDefaultInstanceForType() {
                return EnumDescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public EnumDescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private EnumDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public EnumDescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.value_ != Collections.EMPTY_LIST) {
                    this.result.value_ = Collections.unmodifiableList(this.result.value_);
                }
                EnumDescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumDescriptorProto) {
                    return mergeFrom((EnumDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumDescriptorProto other) {
                if (other != EnumDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (!other.value_.isEmpty()) {
                        if (this.result.value_.isEmpty()) {
                            this.result.value_ = new ArrayList();
                        }
                        this.result.value_.addAll(other.value_);
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
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
                            setName(input.readString());
                            continue;
                        case 18:
                            Builder subBuilder = EnumValueDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addValue(subBuilder.buildPartial());
                            continue;
                        case 26:
                            Builder subBuilder2 = EnumOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder2.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder2, extensionRegistry);
                            setOptions(subBuilder2.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = EnumDescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public List<EnumValueDescriptorProto> getValueList() {
                return Collections.unmodifiableList(this.result.value_);
            }

            public int getValueCount() {
                return this.result.getValueCount();
            }

            public EnumValueDescriptorProto getValue(int index) {
                return this.result.getValue(index);
            }

            public Builder setValue(int index, EnumValueDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.value_.set(index, value);
                return this;
            }

            public Builder setValue(int index, Builder builderForValue) {
                this.result.value_.set(index, builderForValue.build());
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.value_.isEmpty()) {
                    this.result.value_ = new ArrayList();
                }
                this.result.value_.add(value);
                return this;
            }

            public Builder addValue(Builder builderForValue) {
                if (this.result.value_.isEmpty()) {
                    this.result.value_ = new ArrayList();
                }
                this.result.value_.add(builderForValue.build());
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> values) {
                if (this.result.value_.isEmpty()) {
                    this.result.value_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.value_);
                return this;
            }

            public Builder clearValue() {
                this.result.value_ = Collections.emptyList();
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public EnumOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(EnumOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(EnumOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == EnumOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = EnumOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = EnumOptions.getDefaultInstance();
                return this;
            }
        }

        private EnumDescriptorProto() {
            this.name_ = "";
            this.value_ = Collections.emptyList();
            this.options_ = EnumOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public EnumDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22842x9945f651;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public EnumValueDescriptorProto getValue(int index) {
            return (EnumValueDescriptorProto) this.value_.get(index);
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public EnumOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            for (EnumValueDescriptorProto element : getValueList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            for (EnumValueDescriptorProto element : getValueList()) {
                output.writeMessage(2, element);
            }
            if (hasOptions()) {
                output.writeMessage(3, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            for (EnumValueDescriptorProto element : getValueList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static EnumDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class EnumOptions extends ExtendableMessage<EnumOptions> {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final EnumOptions defaultInstance = new EnumOptions();
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<EnumOptions, Builder> {
            private EnumOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new EnumOptions();
                return builder;
            }

            protected EnumOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new EnumOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return EnumOptions.getDescriptor();
            }

            public EnumOptions getDefaultInstanceForType() {
                return EnumOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public EnumOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private EnumOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public EnumOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                EnumOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumOptions) {
                    return mergeFrom((EnumOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumOptions other) {
                if (other != EnumOptions.getDefaultInstance()) {
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        private EnumOptions() {
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static EnumOptions getDefaultInstance() {
            return defaultInstance;
        }

        public EnumOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static EnumOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static EnumOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class EnumValueDescriptorProto extends GeneratedMessage {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final EnumValueDescriptorProto defaultInstance = new EnumValueDescriptorProto();
        private boolean hasName;
        private boolean hasNumber;
        private boolean hasOptions;
        private int memoizedSerializedSize;
        private String name_;
        private int number_;
        private EnumValueOptions options_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private EnumValueDescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new EnumValueDescriptorProto();
                return builder;
            }

            protected EnumValueDescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new EnumValueDescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return EnumValueDescriptorProto.getDescriptor();
            }

            public EnumValueDescriptorProto getDefaultInstanceForType() {
                return EnumValueDescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public EnumValueDescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private EnumValueDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public EnumValueDescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                EnumValueDescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumValueDescriptorProto) {
                    return mergeFrom((EnumValueDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumValueDescriptorProto other) {
                if (other != EnumValueDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasNumber()) {
                        setNumber(other.getNumber());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
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
                            setName(input.readString());
                            continue;
                        case 16:
                            setNumber(input.readInt32());
                            continue;
                        case 26:
                            Builder subBuilder = EnumValueOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = EnumValueDescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public boolean hasNumber() {
                return this.result.hasNumber();
            }

            public int getNumber() {
                return this.result.getNumber();
            }

            public Builder setNumber(int value) {
                this.result.hasNumber = true;
                this.result.number_ = value;
                return this;
            }

            public Builder clearNumber() {
                this.result.hasNumber = false;
                this.result.number_ = 0;
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public EnumValueOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(EnumValueOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(EnumValueOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == EnumValueOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = EnumValueOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = EnumValueOptions.getDefaultInstance();
                return this;
            }
        }

        private EnumValueDescriptorProto() {
            this.name_ = "";
            this.number_ = 0;
            this.options_ = EnumValueOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public EnumValueDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.f22843xf18031a8;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22844xfb173026;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public boolean hasNumber() {
            return this.hasNumber;
        }

        public int getNumber() {
            return this.number_;
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public EnumValueOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            if (hasNumber()) {
                output.writeInt32(2, getNumber());
            }
            if (hasOptions()) {
                output.writeMessage(3, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if (hasNumber()) {
                size += CodedOutputStream.computeInt32Size(2, getNumber());
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static EnumValueDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumValueDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class EnumValueOptions extends ExtendableMessage<EnumValueOptions> {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final EnumValueOptions defaultInstance = new EnumValueOptions();
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<EnumValueOptions, Builder> {
            private EnumValueOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new EnumValueOptions();
                return builder;
            }

            protected EnumValueOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new EnumValueOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return EnumValueOptions.getDescriptor();
            }

            public EnumValueOptions getDefaultInstanceForType() {
                return EnumValueOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public EnumValueOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private EnumValueOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public EnumValueOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                EnumValueOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof EnumValueOptions) {
                    return mergeFrom((EnumValueOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumValueOptions other) {
                if (other != EnumValueOptions.getDefaultInstance()) {
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        private EnumValueOptions() {
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static EnumValueOptions getDefaultInstance() {
            return defaultInstance;
        }

        public EnumValueOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22845xdf65a421;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static EnumValueOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static EnumValueOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumValueOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class FieldDescriptorProto extends GeneratedMessage {
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private static final FieldDescriptorProto defaultInstance = new FieldDescriptorProto();
        private String defaultValue_;
        private String extendee_;
        private boolean hasDefaultValue;
        private boolean hasExtendee;
        private boolean hasLabel;
        private boolean hasName;
        private boolean hasNumber;
        private boolean hasOptions;
        private boolean hasType;
        private boolean hasTypeName;
        private Label label_;
        private int memoizedSerializedSize;
        private String name_;
        private int number_;
        private FieldOptions options_;
        private String typeName_;
        private Type type_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private FieldDescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new FieldDescriptorProto();
                return builder;
            }

            protected FieldDescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new FieldDescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return FieldDescriptorProto.getDescriptor();
            }

            public FieldDescriptorProto getDefaultInstanceForType() {
                return FieldDescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public FieldDescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private FieldDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public FieldDescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                FieldDescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FieldDescriptorProto) {
                    return mergeFrom((FieldDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FieldDescriptorProto other) {
                if (other != FieldDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasNumber()) {
                        setNumber(other.getNumber());
                    }
                    if (other.hasLabel()) {
                        setLabel(other.getLabel());
                    }
                    if (other.hasType()) {
                        setType(other.getType());
                    }
                    if (other.hasTypeName()) {
                        setTypeName(other.getTypeName());
                    }
                    if (other.hasExtendee()) {
                        setExtendee(other.getExtendee());
                    }
                    if (other.hasDefaultValue()) {
                        setDefaultValue(other.getDefaultValue());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                com.google.protobuf.UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    int rawValue;
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            break;
                        case 10:
                            setName(input.readString());
                            continue;
                        case 18:
                            setExtendee(input.readString());
                            continue;
                        case 24:
                            setNumber(input.readInt32());
                            continue;
                        case 32:
                            rawValue = input.readEnum();
                            Label value = Label.valueOf(rawValue);
                            if (value != null) {
                                setLabel(value);
                                break;
                            }
                            unknownFields.mergeVarintField(4, rawValue);
                            continue;
                        case 40:
                            rawValue = input.readEnum();
                            Type value2 = Type.valueOf(rawValue);
                            if (value2 != null) {
                                setType(value2);
                                break;
                            }
                            unknownFields.mergeVarintField(5, rawValue);
                            continue;
                        case 50:
                            setTypeName(input.readString());
                            continue;
                        case 58:
                            setDefaultValue(input.readString());
                            continue;
                        case 66:
                            Builder subBuilder = FieldOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = FieldDescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public boolean hasNumber() {
                return this.result.hasNumber();
            }

            public int getNumber() {
                return this.result.getNumber();
            }

            public Builder setNumber(int value) {
                this.result.hasNumber = true;
                this.result.number_ = value;
                return this;
            }

            public Builder clearNumber() {
                this.result.hasNumber = false;
                this.result.number_ = 0;
                return this;
            }

            public boolean hasLabel() {
                return this.result.hasLabel();
            }

            public Label getLabel() {
                return this.result.getLabel();
            }

            public Builder setLabel(Label value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasLabel = true;
                this.result.label_ = value;
                return this;
            }

            public Builder clearLabel() {
                this.result.hasLabel = false;
                this.result.label_ = Label.LABEL_OPTIONAL;
                return this;
            }

            public boolean hasType() {
                return this.result.hasType();
            }

            public Type getType() {
                return this.result.getType();
            }

            public Builder setType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasType = true;
                this.result.type_ = value;
                return this;
            }

            public Builder clearType() {
                this.result.hasType = false;
                this.result.type_ = Type.TYPE_DOUBLE;
                return this;
            }

            public boolean hasTypeName() {
                return this.result.hasTypeName();
            }

            public String getTypeName() {
                return this.result.getTypeName();
            }

            public Builder setTypeName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasTypeName = true;
                this.result.typeName_ = value;
                return this;
            }

            public Builder clearTypeName() {
                this.result.hasTypeName = false;
                this.result.typeName_ = FieldDescriptorProto.getDefaultInstance().getTypeName();
                return this;
            }

            public boolean hasExtendee() {
                return this.result.hasExtendee();
            }

            public String getExtendee() {
                return this.result.getExtendee();
            }

            public Builder setExtendee(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasExtendee = true;
                this.result.extendee_ = value;
                return this;
            }

            public Builder clearExtendee() {
                this.result.hasExtendee = false;
                this.result.extendee_ = FieldDescriptorProto.getDefaultInstance().getExtendee();
                return this;
            }

            public boolean hasDefaultValue() {
                return this.result.hasDefaultValue();
            }

            public String getDefaultValue() {
                return this.result.getDefaultValue();
            }

            public Builder setDefaultValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasDefaultValue = true;
                this.result.defaultValue_ = value;
                return this;
            }

            public Builder clearDefaultValue() {
                this.result.hasDefaultValue = false;
                this.result.defaultValue_ = FieldDescriptorProto.getDefaultInstance().getDefaultValue();
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public FieldOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(FieldOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(FieldOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == FieldOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = FieldOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = FieldOptions.getDefaultInstance();
                return this;
            }
        }

        public enum Label implements ProtocolMessageEnum {
            LABEL_OPTIONAL(0, 1),
            LABEL_REQUIRED(1, 2),
            LABEL_REPEATED(2, 3);
            
            private static final Label[] VALUES = null;
            private static EnumLiteMap<Label> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label$1 */
            static class C57301 implements EnumLiteMap<Label> {
                C57301() {
                }

                public Label findValueByNumber(int number) {
                    return Label.valueOf(number);
                }
            }

            static {
                internalValueMap = new C57301();
                VALUES = new Label[]{LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED};
                DescriptorProtos.getDescriptor();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Label valueOf(int value) {
                switch (value) {
                    case 1:
                        return LABEL_OPTIONAL;
                    case 2:
                        return LABEL_REQUIRED;
                    case 3:
                        return LABEL_REPEATED;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
            }

            public static Label valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private Label(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        public enum Type implements ProtocolMessageEnum {
            TYPE_DOUBLE(0, 1),
            TYPE_FLOAT(1, 2),
            TYPE_INT64(2, 3),
            TYPE_UINT64(3, 4),
            TYPE_INT32(4, 5),
            TYPE_FIXED64(5, 6),
            TYPE_FIXED32(6, 7),
            TYPE_BOOL(7, 8),
            TYPE_STRING(8, 9),
            TYPE_GROUP(9, 10),
            TYPE_MESSAGE(10, 11),
            TYPE_BYTES(11, 12),
            TYPE_UINT32(12, 13),
            TYPE_ENUM(13, 14),
            TYPE_SFIXED32(14, 15),
            TYPE_SFIXED64(15, 16),
            TYPE_SINT32(16, 17),
            TYPE_SINT64(17, 18);
            
            private static final Type[] VALUES = null;
            private static EnumLiteMap<Type> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type$1 */
            static class C57311 implements EnumLiteMap<Type> {
                C57311() {
                }

                public Type findValueByNumber(int number) {
                    return Type.valueOf(number);
                }
            }

            static {
                internalValueMap = new C57311();
                VALUES = new Type[]{TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64};
                DescriptorProtos.getDescriptor();
            }

            public final int getNumber() {
                return this.value;
            }

            public static Type valueOf(int value) {
                switch (value) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Type valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private Type(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private FieldDescriptorProto() {
            this.name_ = "";
            this.number_ = 0;
            this.label_ = Label.LABEL_OPTIONAL;
            this.type_ = Type.TYPE_DOUBLE;
            this.typeName_ = "";
            this.extendee_ = "";
            this.defaultValue_ = "";
            this.options_ = FieldOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public FieldDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22846x4734b330;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public boolean hasNumber() {
            return this.hasNumber;
        }

        public int getNumber() {
            return this.number_;
        }

        public boolean hasLabel() {
            return this.hasLabel;
        }

        public Label getLabel() {
            return this.label_;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public Type getType() {
            return this.type_;
        }

        public boolean hasTypeName() {
            return this.hasTypeName;
        }

        public String getTypeName() {
            return this.typeName_;
        }

        public boolean hasExtendee() {
            return this.hasExtendee;
        }

        public String getExtendee() {
            return this.extendee_;
        }

        public boolean hasDefaultValue() {
            return this.hasDefaultValue;
        }

        public String getDefaultValue() {
            return this.defaultValue_;
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public FieldOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            if (hasExtendee()) {
                output.writeString(2, getExtendee());
            }
            if (hasNumber()) {
                output.writeInt32(3, getNumber());
            }
            if (hasLabel()) {
                output.writeEnum(4, getLabel().getNumber());
            }
            if (hasType()) {
                output.writeEnum(5, getType().getNumber());
            }
            if (hasTypeName()) {
                output.writeString(6, getTypeName());
            }
            if (hasDefaultValue()) {
                output.writeString(7, getDefaultValue());
            }
            if (hasOptions()) {
                output.writeMessage(8, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if (hasExtendee()) {
                size += CodedOutputStream.computeStringSize(2, getExtendee());
            }
            if (hasNumber()) {
                size += CodedOutputStream.computeInt32Size(3, getNumber());
            }
            if (hasLabel()) {
                size += CodedOutputStream.computeEnumSize(4, getLabel().getNumber());
            }
            if (hasType()) {
                size += CodedOutputStream.computeEnumSize(5, getType().getNumber());
            }
            if (hasTypeName()) {
                size += CodedOutputStream.computeStringSize(6, getTypeName());
            }
            if (hasDefaultValue()) {
                size += CodedOutputStream.computeStringSize(7, getDefaultValue());
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static FieldDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FieldDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class FieldOptions extends ExtendableMessage<FieldOptions> {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int EXPERIMENTAL_MAP_KEY_FIELD_NUMBER = 9;
        public static final int PACKED_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final FieldOptions defaultInstance = new FieldOptions();
        private CType ctype_;
        private boolean deprecated_;
        private String experimentalMapKey_;
        private boolean hasCtype;
        private boolean hasDeprecated;
        private boolean hasExperimentalMapKey;
        private boolean hasPacked;
        private int memoizedSerializedSize;
        private boolean packed_;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<FieldOptions, Builder> {
            private FieldOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new FieldOptions();
                return builder;
            }

            protected FieldOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new FieldOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return FieldOptions.getDescriptor();
            }

            public FieldOptions getDefaultInstanceForType() {
                return FieldOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public FieldOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private FieldOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public FieldOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                FieldOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FieldOptions) {
                    return mergeFrom((FieldOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FieldOptions other) {
                if (other != FieldOptions.getDefaultInstance()) {
                    if (other.hasCtype()) {
                        setCtype(other.getCtype());
                    }
                    if (other.hasPacked()) {
                        setPacked(other.getPacked());
                    }
                    if (other.hasDeprecated()) {
                        setDeprecated(other.getDeprecated());
                    }
                    if (other.hasExperimentalMapKey()) {
                        setExperimentalMapKey(other.getExperimentalMapKey());
                    }
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                            int rawValue = input.readEnum();
                            CType value = CType.valueOf(rawValue);
                            if (value != null) {
                                setCtype(value);
                                break;
                            }
                            unknownFields.mergeVarintField(1, rawValue);
                            continue;
                        case 16:
                            setPacked(input.readBool());
                            continue;
                        case 24:
                            setDeprecated(input.readBool());
                            continue;
                        case 74:
                            setExperimentalMapKey(input.readString());
                            continue;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public boolean hasCtype() {
                return this.result.hasCtype();
            }

            public CType getCtype() {
                return this.result.getCtype();
            }

            public Builder setCtype(CType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasCtype = true;
                this.result.ctype_ = value;
                return this;
            }

            public Builder clearCtype() {
                this.result.hasCtype = false;
                this.result.ctype_ = CType.CORD;
                return this;
            }

            public boolean hasPacked() {
                return this.result.hasPacked();
            }

            public boolean getPacked() {
                return this.result.getPacked();
            }

            public Builder setPacked(boolean value) {
                this.result.hasPacked = true;
                this.result.packed_ = value;
                return this;
            }

            public Builder clearPacked() {
                this.result.hasPacked = false;
                this.result.packed_ = false;
                return this;
            }

            public boolean hasDeprecated() {
                return this.result.hasDeprecated();
            }

            public boolean getDeprecated() {
                return this.result.getDeprecated();
            }

            public Builder setDeprecated(boolean value) {
                this.result.hasDeprecated = true;
                this.result.deprecated_ = value;
                return this;
            }

            public Builder clearDeprecated() {
                this.result.hasDeprecated = false;
                this.result.deprecated_ = false;
                return this;
            }

            public boolean hasExperimentalMapKey() {
                return this.result.hasExperimentalMapKey();
            }

            public String getExperimentalMapKey() {
                return this.result.getExperimentalMapKey();
            }

            public Builder setExperimentalMapKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasExperimentalMapKey = true;
                this.result.experimentalMapKey_ = value;
                return this;
            }

            public Builder clearExperimentalMapKey() {
                this.result.hasExperimentalMapKey = false;
                this.result.experimentalMapKey_ = FieldOptions.getDefaultInstance().getExperimentalMapKey();
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        public enum CType implements ProtocolMessageEnum {
            CORD(0, 1),
            STRING_PIECE(1, 2);
            
            private static final CType[] VALUES = null;
            private static EnumLiteMap<CType> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos$FieldOptions$CType$1 */
            static class C57321 implements EnumLiteMap<CType> {
                C57321() {
                }

                public CType findValueByNumber(int number) {
                    return CType.valueOf(number);
                }
            }

            static {
                internalValueMap = new C57321();
                VALUES = new CType[]{CORD, STRING_PIECE};
                DescriptorProtos.getDescriptor();
            }

            public final int getNumber() {
                return this.value;
            }

            public static CType valueOf(int value) {
                switch (value) {
                    case 1:
                        return CORD;
                    case 2:
                        return STRING_PIECE;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FieldOptions.getDescriptor().getEnumTypes().get(0);
            }

            public static CType valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private CType(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private FieldOptions() {
            this.ctype_ = CType.CORD;
            this.packed_ = false;
            this.deprecated_ = false;
            this.experimentalMapKey_ = "";
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static FieldOptions getDefaultInstance() {
            return defaultInstance;
        }

        public FieldOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
        }

        public boolean hasCtype() {
            return this.hasCtype;
        }

        public CType getCtype() {
            return this.ctype_;
        }

        public boolean hasPacked() {
            return this.hasPacked;
        }

        public boolean getPacked() {
            return this.packed_;
        }

        public boolean hasDeprecated() {
            return this.hasDeprecated;
        }

        public boolean getDeprecated() {
            return this.deprecated_;
        }

        public boolean hasExperimentalMapKey() {
            return this.hasExperimentalMapKey;
        }

        public String getExperimentalMapKey() {
            return this.experimentalMapKey_;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            if (hasCtype()) {
                output.writeEnum(1, getCtype().getNumber());
            }
            if (hasPacked()) {
                output.writeBool(2, getPacked());
            }
            if (hasDeprecated()) {
                output.writeBool(3, getDeprecated());
            }
            if (hasExperimentalMapKey()) {
                output.writeString(9, getExperimentalMapKey());
            }
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasCtype()) {
                size = 0 + CodedOutputStream.computeEnumSize(1, getCtype().getNumber());
            }
            if (hasPacked()) {
                size += CodedOutputStream.computeBoolSize(2, getPacked());
            }
            if (hasDeprecated()) {
                size += CodedOutputStream.computeBoolSize(3, getDeprecated());
            }
            if (hasExperimentalMapKey()) {
                size += CodedOutputStream.computeStringSize(9, getExperimentalMapKey());
            }
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static FieldOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FieldOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static FieldOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FieldOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class FileDescriptorProto extends GeneratedMessage {
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        public static final int SERVICE_FIELD_NUMBER = 6;
        private static final FileDescriptorProto defaultInstance = new FileDescriptorProto();
        private List<String> dependency_;
        private List<EnumDescriptorProto> enumType_;
        private List<FieldDescriptorProto> extension_;
        private boolean hasName;
        private boolean hasOptions;
        private boolean hasPackage;
        private int memoizedSerializedSize;
        private List<DescriptorProto> messageType_;
        private String name_;
        private FileOptions options_;
        private String package_;
        private List<ServiceDescriptorProto> service_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private FileDescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new FileDescriptorProto();
                return builder;
            }

            protected FileDescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new FileDescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return FileDescriptorProto.getDescriptor();
            }

            public FileDescriptorProto getDefaultInstanceForType() {
                return FileDescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public FileDescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private FileDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public FileDescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.dependency_ != Collections.EMPTY_LIST) {
                    this.result.dependency_ = Collections.unmodifiableList(this.result.dependency_);
                }
                if (this.result.messageType_ != Collections.EMPTY_LIST) {
                    this.result.messageType_ = Collections.unmodifiableList(this.result.messageType_);
                }
                if (this.result.enumType_ != Collections.EMPTY_LIST) {
                    this.result.enumType_ = Collections.unmodifiableList(this.result.enumType_);
                }
                if (this.result.service_ != Collections.EMPTY_LIST) {
                    this.result.service_ = Collections.unmodifiableList(this.result.service_);
                }
                if (this.result.extension_ != Collections.EMPTY_LIST) {
                    this.result.extension_ = Collections.unmodifiableList(this.result.extension_);
                }
                FileDescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FileDescriptorProto) {
                    return mergeFrom((FileDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileDescriptorProto other) {
                if (other != FileDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasPackage()) {
                        setPackage(other.getPackage());
                    }
                    if (!other.dependency_.isEmpty()) {
                        if (this.result.dependency_.isEmpty()) {
                            this.result.dependency_ = new ArrayList();
                        }
                        this.result.dependency_.addAll(other.dependency_);
                    }
                    if (!other.messageType_.isEmpty()) {
                        if (this.result.messageType_.isEmpty()) {
                            this.result.messageType_ = new ArrayList();
                        }
                        this.result.messageType_.addAll(other.messageType_);
                    }
                    if (!other.enumType_.isEmpty()) {
                        if (this.result.enumType_.isEmpty()) {
                            this.result.enumType_ = new ArrayList();
                        }
                        this.result.enumType_.addAll(other.enumType_);
                    }
                    if (!other.service_.isEmpty()) {
                        if (this.result.service_.isEmpty()) {
                            this.result.service_ = new ArrayList();
                        }
                        this.result.service_.addAll(other.service_);
                    }
                    if (!other.extension_.isEmpty()) {
                        if (this.result.extension_.isEmpty()) {
                            this.result.extension_ = new ArrayList();
                        }
                        this.result.extension_.addAll(other.extension_);
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
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
                            setName(input.readString());
                            continue;
                        case 18:
                            setPackage(input.readString());
                            continue;
                        case 26:
                            addDependency(input.readString());
                            continue;
                        case 34:
                            Builder subBuilder = DescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMessageType(subBuilder.buildPartial());
                            continue;
                        case 42:
                            Builder subBuilder2 = EnumDescriptorProto.newBuilder();
                            input.readMessage(subBuilder2, extensionRegistry);
                            addEnumType(subBuilder2.buildPartial());
                            continue;
                        case 50:
                            Builder subBuilder3 = ServiceDescriptorProto.newBuilder();
                            input.readMessage(subBuilder3, extensionRegistry);
                            addService(subBuilder3.buildPartial());
                            continue;
                        case 58:
                            Builder subBuilder4 = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder4, extensionRegistry);
                            addExtension(subBuilder4.buildPartial());
                            continue;
                        case 66:
                            Builder subBuilder5 = FileOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder5.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder5, extensionRegistry);
                            setOptions(subBuilder5.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = FileDescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public boolean hasPackage() {
                return this.result.hasPackage();
            }

            public String getPackage() {
                return this.result.getPackage();
            }

            public Builder setPackage(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasPackage = true;
                this.result.package_ = value;
                return this;
            }

            public Builder clearPackage() {
                this.result.hasPackage = false;
                this.result.package_ = FileDescriptorProto.getDefaultInstance().getPackage();
                return this;
            }

            public List<String> getDependencyList() {
                return Collections.unmodifiableList(this.result.dependency_);
            }

            public int getDependencyCount() {
                return this.result.getDependencyCount();
            }

            public String getDependency(int index) {
                return this.result.getDependency(index);
            }

            public Builder setDependency(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.dependency_.set(index, value);
                return this;
            }

            public Builder addDependency(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.dependency_.isEmpty()) {
                    this.result.dependency_ = new ArrayList();
                }
                this.result.dependency_.add(value);
                return this;
            }

            public Builder addAllDependency(Iterable<? extends String> values) {
                if (this.result.dependency_.isEmpty()) {
                    this.result.dependency_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.dependency_);
                return this;
            }

            public Builder clearDependency() {
                this.result.dependency_ = Collections.emptyList();
                return this;
            }

            public List<DescriptorProto> getMessageTypeList() {
                return Collections.unmodifiableList(this.result.messageType_);
            }

            public int getMessageTypeCount() {
                return this.result.getMessageTypeCount();
            }

            public DescriptorProto getMessageType(int index) {
                return this.result.getMessageType(index);
            }

            public Builder setMessageType(int index, DescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.messageType_.set(index, value);
                return this;
            }

            public Builder setMessageType(int index, Builder builderForValue) {
                this.result.messageType_.set(index, builderForValue.build());
                return this;
            }

            public Builder addMessageType(DescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.messageType_.isEmpty()) {
                    this.result.messageType_ = new ArrayList();
                }
                this.result.messageType_.add(value);
                return this;
            }

            public Builder addMessageType(Builder builderForValue) {
                if (this.result.messageType_.isEmpty()) {
                    this.result.messageType_ = new ArrayList();
                }
                this.result.messageType_.add(builderForValue.build());
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> values) {
                if (this.result.messageType_.isEmpty()) {
                    this.result.messageType_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.messageType_);
                return this;
            }

            public Builder clearMessageType() {
                this.result.messageType_ = Collections.emptyList();
                return this;
            }

            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(this.result.enumType_);
            }

            public int getEnumTypeCount() {
                return this.result.getEnumTypeCount();
            }

            public EnumDescriptorProto getEnumType(int index) {
                return this.result.getEnumType(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.enumType_.set(index, value);
                return this;
            }

            public Builder setEnumType(int index, Builder builderForValue) {
                this.result.enumType_.set(index, builderForValue.build());
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.enumType_.isEmpty()) {
                    this.result.enumType_ = new ArrayList();
                }
                this.result.enumType_.add(value);
                return this;
            }

            public Builder addEnumType(Builder builderForValue) {
                if (this.result.enumType_.isEmpty()) {
                    this.result.enumType_ = new ArrayList();
                }
                this.result.enumType_.add(builderForValue.build());
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                if (this.result.enumType_.isEmpty()) {
                    this.result.enumType_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.enumType_);
                return this;
            }

            public Builder clearEnumType() {
                this.result.enumType_ = Collections.emptyList();
                return this;
            }

            public List<ServiceDescriptorProto> getServiceList() {
                return Collections.unmodifiableList(this.result.service_);
            }

            public int getServiceCount() {
                return this.result.getServiceCount();
            }

            public ServiceDescriptorProto getService(int index) {
                return this.result.getService(index);
            }

            public Builder setService(int index, ServiceDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.service_.set(index, value);
                return this;
            }

            public Builder setService(int index, Builder builderForValue) {
                this.result.service_.set(index, builderForValue.build());
                return this;
            }

            public Builder addService(ServiceDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.service_.isEmpty()) {
                    this.result.service_ = new ArrayList();
                }
                this.result.service_.add(value);
                return this;
            }

            public Builder addService(Builder builderForValue) {
                if (this.result.service_.isEmpty()) {
                    this.result.service_ = new ArrayList();
                }
                this.result.service_.add(builderForValue.build());
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> values) {
                if (this.result.service_.isEmpty()) {
                    this.result.service_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.service_);
                return this;
            }

            public Builder clearService() {
                this.result.service_ = Collections.emptyList();
                return this;
            }

            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(this.result.extension_);
            }

            public int getExtensionCount() {
                return this.result.getExtensionCount();
            }

            public FieldDescriptorProto getExtension(int index) {
                return this.result.getExtension(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.extension_.set(index, value);
                return this;
            }

            public Builder setExtension(int index, Builder builderForValue) {
                this.result.extension_.set(index, builderForValue.build());
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.extension_.isEmpty()) {
                    this.result.extension_ = new ArrayList();
                }
                this.result.extension_.add(value);
                return this;
            }

            public Builder addExtension(Builder builderForValue) {
                if (this.result.extension_.isEmpty()) {
                    this.result.extension_ = new ArrayList();
                }
                this.result.extension_.add(builderForValue.build());
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                if (this.result.extension_.isEmpty()) {
                    this.result.extension_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.extension_);
                return this;
            }

            public Builder clearExtension() {
                this.result.extension_ = Collections.emptyList();
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public FileOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(FileOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(FileOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == FileOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = FileOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = FileOptions.getDefaultInstance();
                return this;
            }
        }

        private FileDescriptorProto() {
            this.name_ = "";
            this.package_ = "";
            this.dependency_ = Collections.emptyList();
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.options_ = FileOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static FileDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public FileDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22847x4b52780c;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public boolean hasPackage() {
            return this.hasPackage;
        }

        public String getPackage() {
            return this.package_;
        }

        public List<String> getDependencyList() {
            return this.dependency_;
        }

        public int getDependencyCount() {
            return this.dependency_.size();
        }

        public String getDependency(int index) {
            return (String) this.dependency_.get(index);
        }

        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        public DescriptorProto getMessageType(int index) {
            return (DescriptorProto) this.messageType_.get(index);
        }

        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        public EnumDescriptorProto getEnumType(int index) {
            return (EnumDescriptorProto) this.enumType_.get(index);
        }

        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public int getServiceCount() {
            return this.service_.size();
        }

        public ServiceDescriptorProto getService(int index) {
            return (ServiceDescriptorProto) this.service_.get(index);
        }

        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public int getExtensionCount() {
            return this.extension_.size();
        }

        public FieldDescriptorProto getExtension(int index) {
            return (FieldDescriptorProto) this.extension_.get(index);
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public FileOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            for (DescriptorProto element : getMessageTypeList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            for (EnumDescriptorProto element2 : getEnumTypeList()) {
                if (!element2.isInitialized()) {
                    return false;
                }
            }
            for (ServiceDescriptorProto element3 : getServiceList()) {
                if (!element3.isInitialized()) {
                    return false;
                }
            }
            for (FieldDescriptorProto element4 : getExtensionList()) {
                if (!element4.isInitialized()) {
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            if (hasPackage()) {
                output.writeString(2, getPackage());
            }
            for (String element : getDependencyList()) {
                output.writeString(3, element);
            }
            for (DescriptorProto element2 : getMessageTypeList()) {
                output.writeMessage(4, element2);
            }
            for (EnumDescriptorProto element3 : getEnumTypeList()) {
                output.writeMessage(5, element3);
            }
            for (ServiceDescriptorProto element4 : getServiceList()) {
                output.writeMessage(6, element4);
            }
            for (FieldDescriptorProto element5 : getExtensionList()) {
                output.writeMessage(7, element5);
            }
            if (hasOptions()) {
                output.writeMessage(8, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if (hasPackage()) {
                size += CodedOutputStream.computeStringSize(2, getPackage());
            }
            int dataSize = 0;
            for (String element : getDependencyList()) {
                dataSize += CodedOutputStream.computeStringSizeNoTag(element);
            }
            size = (size + dataSize) + (getDependencyList().size() * 1);
            for (DescriptorProto element2 : getMessageTypeList()) {
                size += CodedOutputStream.computeMessageSize(4, element2);
            }
            for (EnumDescriptorProto element3 : getEnumTypeList()) {
                size += CodedOutputStream.computeMessageSize(5, element3);
            }
            for (ServiceDescriptorProto element4 : getServiceList()) {
                size += CodedOutputStream.computeMessageSize(6, element4);
            }
            for (FieldDescriptorProto element5 : getExtensionList()) {
                size += CodedOutputStream.computeMessageSize(7, element5);
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(8, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static FileDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class FileDescriptorSet extends GeneratedMessage {
        public static final int FILE_FIELD_NUMBER = 1;
        private static final FileDescriptorSet defaultInstance = new FileDescriptorSet();
        private List<FileDescriptorProto> file_;
        private int memoizedSerializedSize;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private FileDescriptorSet result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new FileDescriptorSet();
                return builder;
            }

            protected FileDescriptorSet internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new FileDescriptorSet();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return FileDescriptorSet.getDescriptor();
            }

            public FileDescriptorSet getDefaultInstanceForType() {
                return FileDescriptorSet.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public FileDescriptorSet build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private FileDescriptorSet buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public FileDescriptorSet buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.file_ != Collections.EMPTY_LIST) {
                    this.result.file_ = Collections.unmodifiableList(this.result.file_);
                }
                FileDescriptorSet returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FileDescriptorSet) {
                    return mergeFrom((FileDescriptorSet) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileDescriptorSet other) {
                if (other != FileDescriptorSet.getDefaultInstance()) {
                    if (!other.file_.isEmpty()) {
                        if (this.result.file_.isEmpty()) {
                            this.result.file_ = new ArrayList();
                        }
                        this.result.file_.addAll(other.file_);
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
                            Builder subBuilder = FileDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addFile(subBuilder.buildPartial());
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

            public List<FileDescriptorProto> getFileList() {
                return Collections.unmodifiableList(this.result.file_);
            }

            public int getFileCount() {
                return this.result.getFileCount();
            }

            public FileDescriptorProto getFile(int index) {
                return this.result.getFile(index);
            }

            public Builder setFile(int index, FileDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.file_.set(index, value);
                return this;
            }

            public Builder setFile(int index, Builder builderForValue) {
                this.result.file_.set(index, builderForValue.build());
                return this;
            }

            public Builder addFile(FileDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.file_.isEmpty()) {
                    this.result.file_ = new ArrayList();
                }
                this.result.file_.add(value);
                return this;
            }

            public Builder addFile(Builder builderForValue) {
                if (this.result.file_.isEmpty()) {
                    this.result.file_ = new ArrayList();
                }
                this.result.file_.add(builderForValue.build());
                return this;
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> values) {
                if (this.result.file_.isEmpty()) {
                    this.result.file_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.file_);
                return this;
            }

            public Builder clearFile() {
                this.result.file_ = Collections.emptyList();
                return this;
            }
        }

        private FileDescriptorSet() {
            this.file_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static FileDescriptorSet getDefaultInstance() {
            return defaultInstance;
        }

        public FileDescriptorSet getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22848x15a6a952;
        }

        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public int getFileCount() {
            return this.file_.size();
        }

        public FileDescriptorProto getFile(int index) {
            return (FileDescriptorProto) this.file_.get(index);
        }

        public final boolean isInitialized() {
            for (FileDescriptorProto element : getFileList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (FileDescriptorProto element : getFileList()) {
                output.writeMessage(1, element);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (FileDescriptorProto element : getFileList()) {
                size += CodedOutputStream.computeMessageSize(1, element);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static FileDescriptorSet parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileDescriptorSet prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class FileOptions extends ExtendableMessage<FileOptions> {
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final FileOptions defaultInstance = new FileOptions();
        private boolean hasJavaMultipleFiles;
        private boolean hasJavaOuterClassname;
        private boolean hasJavaPackage;
        private boolean hasOptimizeFor;
        private boolean javaMultipleFiles_;
        private String javaOuterClassname_;
        private String javaPackage_;
        private int memoizedSerializedSize;
        private OptimizeMode optimizeFor_;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<FileOptions, Builder> {
            private FileOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new FileOptions();
                return builder;
            }

            protected FileOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new FileOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return FileOptions.getDescriptor();
            }

            public FileOptions getDefaultInstanceForType() {
                return FileOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public FileOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private FileOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public FileOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                FileOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof FileOptions) {
                    return mergeFrom((FileOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileOptions other) {
                if (other != FileOptions.getDefaultInstance()) {
                    if (other.hasJavaPackage()) {
                        setJavaPackage(other.getJavaPackage());
                    }
                    if (other.hasJavaOuterClassname()) {
                        setJavaOuterClassname(other.getJavaOuterClassname());
                    }
                    if (other.hasJavaMultipleFiles()) {
                        setJavaMultipleFiles(other.getJavaMultipleFiles());
                    }
                    if (other.hasOptimizeFor()) {
                        setOptimizeFor(other.getOptimizeFor());
                    }
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                            setJavaPackage(input.readString());
                            continue;
                        case 66:
                            setJavaOuterClassname(input.readString());
                            continue;
                        case NavCarInfo.CarType_57L /*72*/:
                            int rawValue = input.readEnum();
                            OptimizeMode value = OptimizeMode.valueOf(rawValue);
                            if (value != null) {
                                setOptimizeFor(value);
                                break;
                            }
                            unknownFields.mergeVarintField(9, rawValue);
                            continue;
                        case 80:
                            setJavaMultipleFiles(input.readBool());
                            continue;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public boolean hasJavaPackage() {
                return this.result.hasJavaPackage();
            }

            public String getJavaPackage() {
                return this.result.getJavaPackage();
            }

            public Builder setJavaPackage(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasJavaPackage = true;
                this.result.javaPackage_ = value;
                return this;
            }

            public Builder clearJavaPackage() {
                this.result.hasJavaPackage = false;
                this.result.javaPackage_ = FileOptions.getDefaultInstance().getJavaPackage();
                return this;
            }

            public boolean hasJavaOuterClassname() {
                return this.result.hasJavaOuterClassname();
            }

            public String getJavaOuterClassname() {
                return this.result.getJavaOuterClassname();
            }

            public Builder setJavaOuterClassname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasJavaOuterClassname = true;
                this.result.javaOuterClassname_ = value;
                return this;
            }

            public Builder clearJavaOuterClassname() {
                this.result.hasJavaOuterClassname = false;
                this.result.javaOuterClassname_ = FileOptions.getDefaultInstance().getJavaOuterClassname();
                return this;
            }

            public boolean hasJavaMultipleFiles() {
                return this.result.hasJavaMultipleFiles();
            }

            public boolean getJavaMultipleFiles() {
                return this.result.getJavaMultipleFiles();
            }

            public Builder setJavaMultipleFiles(boolean value) {
                this.result.hasJavaMultipleFiles = true;
                this.result.javaMultipleFiles_ = value;
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                this.result.hasJavaMultipleFiles = false;
                this.result.javaMultipleFiles_ = false;
                return this;
            }

            public boolean hasOptimizeFor() {
                return this.result.hasOptimizeFor();
            }

            public OptimizeMode getOptimizeFor() {
                return this.result.getOptimizeFor();
            }

            public Builder setOptimizeFor(OptimizeMode value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptimizeFor = true;
                this.result.optimizeFor_ = value;
                return this;
            }

            public Builder clearOptimizeFor() {
                this.result.hasOptimizeFor = false;
                this.result.optimizeFor_ = OptimizeMode.SPEED;
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        public enum OptimizeMode implements ProtocolMessageEnum {
            SPEED(0, 1),
            CODE_SIZE(1, 2),
            LITE_RUNTIME(2, 3);
            
            private static final OptimizeMode[] VALUES = null;
            private static EnumLiteMap<OptimizeMode> internalValueMap;
            private final int index;
            private final int value;

            /* renamed from: com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode$1 */
            static class C57331 implements EnumLiteMap<OptimizeMode> {
                C57331() {
                }

                public OptimizeMode findValueByNumber(int number) {
                    return OptimizeMode.valueOf(number);
                }
            }

            static {
                internalValueMap = new C57331();
                VALUES = new OptimizeMode[]{SPEED, CODE_SIZE, LITE_RUNTIME};
                DescriptorProtos.getDescriptor();
            }

            public final int getNumber() {
                return this.value;
            }

            public static OptimizeMode valueOf(int value) {
                switch (value) {
                    case 1:
                        return SPEED;
                    case 2:
                        return CODE_SIZE;
                    case 3:
                        return LITE_RUNTIME;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            public final EnumValueDescriptor getValueDescriptor() {
                return (EnumValueDescriptor) getDescriptor().getValues().get(this.index);
            }

            public final EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final EnumDescriptor getDescriptor() {
                return (EnumDescriptor) FileOptions.getDescriptor().getEnumTypes().get(0);
            }

            public static OptimizeMode valueOf(EnumValueDescriptor desc) {
                if (desc.getType() == getDescriptor()) {
                    return VALUES[desc.getIndex()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private OptimizeMode(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private FileOptions() {
            this.javaPackage_ = "";
            this.javaOuterClassname_ = "";
            this.javaMultipleFiles_ = false;
            this.optimizeFor_ = OptimizeMode.SPEED;
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static FileOptions getDefaultInstance() {
            return defaultInstance;
        }

        public FileOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
        }

        public boolean hasJavaPackage() {
            return this.hasJavaPackage;
        }

        public String getJavaPackage() {
            return this.javaPackage_;
        }

        public boolean hasJavaOuterClassname() {
            return this.hasJavaOuterClassname;
        }

        public String getJavaOuterClassname() {
            return this.javaOuterClassname_;
        }

        public boolean hasJavaMultipleFiles() {
            return this.hasJavaMultipleFiles;
        }

        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        public boolean hasOptimizeFor() {
            return this.hasOptimizeFor;
        }

        public OptimizeMode getOptimizeFor() {
            return this.optimizeFor_;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            if (hasJavaPackage()) {
                output.writeString(1, getJavaPackage());
            }
            if (hasJavaOuterClassname()) {
                output.writeString(8, getJavaOuterClassname());
            }
            if (hasOptimizeFor()) {
                output.writeEnum(9, getOptimizeFor().getNumber());
            }
            if (hasJavaMultipleFiles()) {
                output.writeBool(10, getJavaMultipleFiles());
            }
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasJavaPackage()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getJavaPackage());
            }
            if (hasJavaOuterClassname()) {
                size += CodedOutputStream.computeStringSize(8, getJavaOuterClassname());
            }
            if (hasOptimizeFor()) {
                size += CodedOutputStream.computeEnumSize(9, getOptimizeFor().getNumber());
            }
            if (hasJavaMultipleFiles()) {
                size += CodedOutputStream.computeBoolSize(10, getJavaMultipleFiles());
            }
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static FileOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static FileOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static FileOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class MessageOptions extends ExtendableMessage<MessageOptions> {
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final MessageOptions defaultInstance = new MessageOptions();
        private boolean hasMessageSetWireFormat;
        private boolean hasNoStandardDescriptorAccessor;
        private int memoizedSerializedSize;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<MessageOptions, Builder> {
            private MessageOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new MessageOptions();
                return builder;
            }

            protected MessageOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new MessageOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return MessageOptions.getDescriptor();
            }

            public MessageOptions getDefaultInstanceForType() {
                return MessageOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public MessageOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private MessageOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public MessageOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                MessageOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MessageOptions) {
                    return mergeFrom((MessageOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MessageOptions other) {
                if (other != MessageOptions.getDefaultInstance()) {
                    if (other.hasMessageSetWireFormat()) {
                        setMessageSetWireFormat(other.getMessageSetWireFormat());
                    }
                    if (other.hasNoStandardDescriptorAccessor()) {
                        setNoStandardDescriptorAccessor(other.getNoStandardDescriptorAccessor());
                    }
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                            setMessageSetWireFormat(input.readBool());
                            continue;
                        case 16:
                            setNoStandardDescriptorAccessor(input.readBool());
                            continue;
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public boolean hasMessageSetWireFormat() {
                return this.result.hasMessageSetWireFormat();
            }

            public boolean getMessageSetWireFormat() {
                return this.result.getMessageSetWireFormat();
            }

            public Builder setMessageSetWireFormat(boolean value) {
                this.result.hasMessageSetWireFormat = true;
                this.result.messageSetWireFormat_ = value;
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                this.result.hasMessageSetWireFormat = false;
                this.result.messageSetWireFormat_ = false;
                return this;
            }

            public boolean hasNoStandardDescriptorAccessor() {
                return this.result.hasNoStandardDescriptorAccessor();
            }

            public boolean getNoStandardDescriptorAccessor() {
                return this.result.getNoStandardDescriptorAccessor();
            }

            public Builder setNoStandardDescriptorAccessor(boolean value) {
                this.result.hasNoStandardDescriptorAccessor = true;
                this.result.noStandardDescriptorAccessor_ = value;
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                this.result.hasNoStandardDescriptorAccessor = false;
                this.result.noStandardDescriptorAccessor_ = false;
                return this;
            }

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        private MessageOptions() {
            this.messageSetWireFormat_ = false;
            this.noStandardDescriptorAccessor_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static MessageOptions getDefaultInstance() {
            return defaultInstance;
        }

        public MessageOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22849x9c0b3d38;
        }

        public boolean hasMessageSetWireFormat() {
            return this.hasMessageSetWireFormat;
        }

        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        public boolean hasNoStandardDescriptorAccessor() {
            return this.hasNoStandardDescriptorAccessor;
        }

        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            if (hasMessageSetWireFormat()) {
                output.writeBool(1, getMessageSetWireFormat());
            }
            if (hasNoStandardDescriptorAccessor()) {
                output.writeBool(2, getNoStandardDescriptorAccessor());
            }
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasMessageSetWireFormat()) {
                size = 0 + CodedOutputStream.computeBoolSize(1, getMessageSetWireFormat());
            }
            if (hasNoStandardDescriptorAccessor()) {
                size += CodedOutputStream.computeBoolSize(2, getNoStandardDescriptorAccessor());
            }
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static MessageOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MessageOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MessageOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MessageOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static MessageOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MessageOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MessageOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class MethodDescriptorProto extends GeneratedMessage {
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static final MethodDescriptorProto defaultInstance = new MethodDescriptorProto();
        private boolean hasInputType;
        private boolean hasName;
        private boolean hasOptions;
        private boolean hasOutputType;
        private String inputType_;
        private int memoizedSerializedSize;
        private String name_;
        private MethodOptions options_;
        private String outputType_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private MethodDescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new MethodDescriptorProto();
                return builder;
            }

            protected MethodDescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new MethodDescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return MethodDescriptorProto.getDescriptor();
            }

            public MethodDescriptorProto getDefaultInstanceForType() {
                return MethodDescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public MethodDescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private MethodDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public MethodDescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                MethodDescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MethodDescriptorProto) {
                    return mergeFrom((MethodDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MethodDescriptorProto other) {
                if (other != MethodDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasInputType()) {
                        setInputType(other.getInputType());
                    }
                    if (other.hasOutputType()) {
                        setOutputType(other.getOutputType());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
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
                            setName(input.readString());
                            continue;
                        case 18:
                            setInputType(input.readString());
                            continue;
                        case 26:
                            setOutputType(input.readString());
                            continue;
                        case 34:
                            Builder subBuilder = MethodOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = MethodDescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public boolean hasInputType() {
                return this.result.hasInputType();
            }

            public String getInputType() {
                return this.result.getInputType();
            }

            public Builder setInputType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasInputType = true;
                this.result.inputType_ = value;
                return this;
            }

            public Builder clearInputType() {
                this.result.hasInputType = false;
                this.result.inputType_ = MethodDescriptorProto.getDefaultInstance().getInputType();
                return this;
            }

            public boolean hasOutputType() {
                return this.result.hasOutputType();
            }

            public String getOutputType() {
                return this.result.getOutputType();
            }

            public Builder setOutputType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOutputType = true;
                this.result.outputType_ = value;
                return this;
            }

            public Builder clearOutputType() {
                this.result.hasOutputType = false;
                this.result.outputType_ = MethodDescriptorProto.getDefaultInstance().getOutputType();
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public MethodOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(MethodOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(MethodOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == MethodOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = MethodOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = MethodOptions.getDefaultInstance();
                return this;
            }
        }

        private MethodDescriptorProto() {
            this.name_ = "";
            this.inputType_ = "";
            this.outputType_ = "";
            this.options_ = MethodOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public MethodDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22850xc5331ef1;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public boolean hasInputType() {
            return this.hasInputType;
        }

        public String getInputType() {
            return this.inputType_;
        }

        public boolean hasOutputType() {
            return this.hasOutputType;
        }

        public String getOutputType() {
            return this.outputType_;
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public MethodOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            if (hasInputType()) {
                output.writeString(2, getInputType());
            }
            if (hasOutputType()) {
                output.writeString(3, getOutputType());
            }
            if (hasOptions()) {
                output.writeMessage(4, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            if (hasInputType()) {
                size += CodedOutputStream.computeStringSize(2, getInputType());
            }
            if (hasOutputType()) {
                size += CodedOutputStream.computeStringSize(3, getOutputType());
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(4, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static MethodDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MethodDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class MethodOptions extends ExtendableMessage<MethodOptions> {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final MethodOptions defaultInstance = new MethodOptions();
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<MethodOptions, Builder> {
            private MethodOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new MethodOptions();
                return builder;
            }

            protected MethodOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new MethodOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return MethodOptions.getDescriptor();
            }

            public MethodOptions getDefaultInstanceForType() {
                return MethodOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public MethodOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private MethodOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public MethodOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                MethodOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof MethodOptions) {
                    return mergeFrom((MethodOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MethodOptions other) {
                if (other != MethodOptions.getDefaultInstance()) {
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        private MethodOptions() {
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static MethodOptions getDefaultInstance() {
            return defaultInstance;
        }

        public MethodOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static MethodOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static MethodOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static MethodOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MethodOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class ServiceDescriptorProto extends GeneratedMessage {
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final ServiceDescriptorProto defaultInstance = new ServiceDescriptorProto();
        private boolean hasName;
        private boolean hasOptions;
        private int memoizedSerializedSize;
        private List<MethodDescriptorProto> method_;
        private String name_;
        private ServiceOptions options_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private ServiceDescriptorProto result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new ServiceDescriptorProto();
                return builder;
            }

            protected ServiceDescriptorProto internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new ServiceDescriptorProto();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return ServiceDescriptorProto.getDescriptor();
            }

            public ServiceDescriptorProto getDefaultInstanceForType() {
                return ServiceDescriptorProto.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public ServiceDescriptorProto build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private ServiceDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public ServiceDescriptorProto buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.method_ != Collections.EMPTY_LIST) {
                    this.result.method_ = Collections.unmodifiableList(this.result.method_);
                }
                ServiceDescriptorProto returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ServiceDescriptorProto) {
                    return mergeFrom((ServiceDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServiceDescriptorProto other) {
                if (other != ServiceDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (!other.method_.isEmpty()) {
                        if (this.result.method_.isEmpty()) {
                            this.result.method_ = new ArrayList();
                        }
                        this.result.method_.addAll(other.method_);
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
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
                            setName(input.readString());
                            continue;
                        case 18:
                            Builder subBuilder = MethodDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMethod(subBuilder.buildPartial());
                            continue;
                        case 26:
                            Builder subBuilder2 = ServiceOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder2.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder2, extensionRegistry);
                            setOptions(subBuilder2.buildPartial());
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

            public boolean hasName() {
                return this.result.hasName();
            }

            public String getName() {
                return this.result.getName();
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasName = true;
                this.result.name_ = value;
                return this;
            }

            public Builder clearName() {
                this.result.hasName = false;
                this.result.name_ = ServiceDescriptorProto.getDefaultInstance().getName();
                return this;
            }

            public List<MethodDescriptorProto> getMethodList() {
                return Collections.unmodifiableList(this.result.method_);
            }

            public int getMethodCount() {
                return this.result.getMethodCount();
            }

            public MethodDescriptorProto getMethod(int index) {
                return this.result.getMethod(index);
            }

            public Builder setMethod(int index, MethodDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.method_.set(index, value);
                return this;
            }

            public Builder setMethod(int index, Builder builderForValue) {
                this.result.method_.set(index, builderForValue.build());
                return this;
            }

            public Builder addMethod(MethodDescriptorProto value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.method_.isEmpty()) {
                    this.result.method_ = new ArrayList();
                }
                this.result.method_.add(value);
                return this;
            }

            public Builder addMethod(Builder builderForValue) {
                if (this.result.method_.isEmpty()) {
                    this.result.method_ = new ArrayList();
                }
                this.result.method_.add(builderForValue.build());
                return this;
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> values) {
                if (this.result.method_.isEmpty()) {
                    this.result.method_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.method_);
                return this;
            }

            public Builder clearMethod() {
                this.result.method_ = Collections.emptyList();
                return this;
            }

            public boolean hasOptions() {
                return this.result.hasOptions();
            }

            public ServiceOptions getOptions() {
                return this.result.getOptions();
            }

            public Builder setOptions(ServiceOptions value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasOptions = true;
                this.result.options_ = value;
                return this;
            }

            public Builder setOptions(Builder builderForValue) {
                this.result.hasOptions = true;
                this.result.options_ = builderForValue.build();
                return this;
            }

            public Builder mergeOptions(ServiceOptions value) {
                if (!this.result.hasOptions() || this.result.options_ == ServiceOptions.getDefaultInstance()) {
                    this.result.options_ = value;
                } else {
                    this.result.options_ = ServiceOptions.newBuilder(this.result.options_).mergeFrom(value).buildPartial();
                }
                this.result.hasOptions = true;
                return this;
            }

            public Builder clearOptions() {
                this.result.hasOptions = false;
                this.result.options_ = ServiceOptions.getDefaultInstance();
                return this;
            }
        }

        private ServiceDescriptorProto() {
            this.name_ = "";
            this.method_ = Collections.emptyList();
            this.options_ = ServiceOptions.getDefaultInstance();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        public ServiceDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.f22851x158c73ed;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22852xee335d6b;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public String getName() {
            return this.name_;
        }

        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public int getMethodCount() {
            return this.method_.size();
        }

        public MethodDescriptorProto getMethod(int index) {
            return (MethodDescriptorProto) this.method_.get(index);
        }

        public boolean hasOptions() {
            return this.hasOptions;
        }

        public ServiceOptions getOptions() {
            return this.options_;
        }

        public final boolean isInitialized() {
            for (MethodDescriptorProto element : getMethodList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (!hasOptions() || getOptions().isInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (hasName()) {
                output.writeString(1, getName());
            }
            for (MethodDescriptorProto element : getMethodList()) {
                output.writeMessage(2, element);
            }
            if (hasOptions()) {
                output.writeMessage(3, getOptions());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (hasName()) {
                size = 0 + CodedOutputStream.computeStringSize(1, getName());
            }
            for (MethodDescriptorProto element : getMethodList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            if (hasOptions()) {
                size += CodedOutputStream.computeMessageSize(3, getOptions());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static ServiceDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServiceDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class ServiceOptions extends ExtendableMessage<ServiceOptions> {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final ServiceOptions defaultInstance = new ServiceOptions();
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        public static final class Builder extends ExtendableBuilder<ServiceOptions, Builder> {
            private ServiceOptions result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new ServiceOptions();
                return builder;
            }

            protected ServiceOptions internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new ServiceOptions();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return ServiceOptions.getDescriptor();
            }

            public ServiceOptions getDefaultInstanceForType() {
                return ServiceOptions.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public ServiceOptions build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private ServiceOptions buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public ServiceOptions buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
                    this.result.uninterpretedOption_ = Collections.unmodifiableList(this.result.uninterpretedOption_);
                }
                ServiceOptions returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof ServiceOptions) {
                    return mergeFrom((ServiceOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServiceOptions other) {
                if (other != ServiceOptions.getDefaultInstance()) {
                    if (!other.uninterpretedOption_.isEmpty()) {
                        if (this.result.uninterpretedOption_.isEmpty()) {
                            this.result.uninterpretedOption_ = new ArrayList();
                        }
                        this.result.uninterpretedOption_.addAll(other.uninterpretedOption_);
                    }
                    mergeExtensionFields(other);
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
                        case 7994:
                            Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
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

            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(this.result.uninterpretedOption_);
            }

            public int getUninterpretedOptionCount() {
                return this.result.getUninterpretedOptionCount();
            }

            public UninterpretedOption getUninterpretedOption(int index) {
                return this.result.getUninterpretedOption(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.uninterpretedOption_.set(index, value);
                return this;
            }

            public Builder setUninterpretedOption(int index, Builder builderForValue) {
                this.result.uninterpretedOption_.set(index, builderForValue.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(value);
                return this;
            }

            public Builder addUninterpretedOption(Builder builderForValue) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                this.result.uninterpretedOption_.add(builderForValue.build());
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.result.uninterpretedOption_.isEmpty()) {
                    this.result.uninterpretedOption_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.uninterpretedOption_);
                return this;
            }

            public Builder clearUninterpretedOption() {
                this.result.uninterpretedOption_ = Collections.emptyList();
                return this;
            }
        }

        private ServiceOptions() {
            this.uninterpretedOption_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static ServiceOptions getDefaultInstance() {
            return defaultInstance;
        }

        public ServiceOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22853x371e666;
        }

        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        public UninterpretedOption getUninterpretedOption(int index) {
            return (UninterpretedOption) this.uninterpretedOption_.get(index);
        }

        public final boolean isInitialized() {
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                return true;
            }
            return false;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            ExtensionWriter extensionWriter = newExtensionWriter();
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                output.writeMessage(999, element);
            }
            extensionWriter.writeUntil(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_WAYPOINT_DUPLICATE, output);
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (UninterpretedOption element : getUninterpretedOptionList()) {
                size += CodedOutputStream.computeMessageSize(999, element);
            }
            size = (size + extensionsSerializedSize()) + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static ServiceOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static ServiceOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServiceOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    public static final class UninterpretedOption extends GeneratedMessage {
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private static final UninterpretedOption defaultInstance = new UninterpretedOption();
        private double doubleValue_;
        private boolean hasDoubleValue;
        private boolean hasIdentifierValue;
        private boolean hasNegativeIntValue;
        private boolean hasPositiveIntValue;
        private boolean hasStringValue;
        private String identifierValue_;
        private int memoizedSerializedSize;
        private List<NamePart> name_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_;

        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
            private UninterpretedOption result;

            private Builder() {
            }

            private static Builder create() {
                Builder builder = new Builder();
                builder.result = new UninterpretedOption();
                return builder;
            }

            protected UninterpretedOption internalGetResult() {
                return this.result;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new UninterpretedOption();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(this.result);
            }

            public Descriptor getDescriptorForType() {
                return UninterpretedOption.getDescriptor();
            }

            public UninterpretedOption getDefaultInstanceForType() {
                return UninterpretedOption.getDefaultInstance();
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            public UninterpretedOption build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
            }

            private UninterpretedOption buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
            }

            public UninterpretedOption buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.name_ != Collections.EMPTY_LIST) {
                    this.result.name_ = Collections.unmodifiableList(this.result.name_);
                }
                UninterpretedOption returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder mergeFrom(Message other) {
                if (other instanceof UninterpretedOption) {
                    return mergeFrom((UninterpretedOption) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UninterpretedOption other) {
                if (other != UninterpretedOption.getDefaultInstance()) {
                    if (!other.name_.isEmpty()) {
                        if (this.result.name_.isEmpty()) {
                            this.result.name_ = new ArrayList();
                        }
                        this.result.name_.addAll(other.name_);
                    }
                    if (other.hasIdentifierValue()) {
                        setIdentifierValue(other.getIdentifierValue());
                    }
                    if (other.hasPositiveIntValue()) {
                        setPositiveIntValue(other.getPositiveIntValue());
                    }
                    if (other.hasNegativeIntValue()) {
                        setNegativeIntValue(other.getNegativeIntValue());
                    }
                    if (other.hasDoubleValue()) {
                        setDoubleValue(other.getDoubleValue());
                    }
                    if (other.hasStringValue()) {
                        setStringValue(other.getStringValue());
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
                        case 18:
                            Builder subBuilder = NamePart.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addName(subBuilder.buildPartial());
                            continue;
                        case 26:
                            setIdentifierValue(input.readString());
                            continue;
                        case 32:
                            setPositiveIntValue(input.readUInt64());
                            continue;
                        case 40:
                            setNegativeIntValue(input.readInt64());
                            continue;
                        case 49:
                            setDoubleValue(input.readDouble());
                            continue;
                        case 58:
                            setStringValue(input.readBytes());
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

            public List<NamePart> getNameList() {
                return Collections.unmodifiableList(this.result.name_);
            }

            public int getNameCount() {
                return this.result.getNameCount();
            }

            public NamePart getName(int index) {
                return this.result.getName(index);
            }

            public Builder setName(int index, NamePart value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.name_.set(index, value);
                return this;
            }

            public Builder setName(int index, Builder builderForValue) {
                this.result.name_.set(index, builderForValue.build());
                return this;
            }

            public Builder addName(NamePart value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                if (this.result.name_.isEmpty()) {
                    this.result.name_ = new ArrayList();
                }
                this.result.name_.add(value);
                return this;
            }

            public Builder addName(Builder builderForValue) {
                if (this.result.name_.isEmpty()) {
                    this.result.name_ = new ArrayList();
                }
                this.result.name_.add(builderForValue.build());
                return this;
            }

            public Builder addAllName(Iterable<? extends NamePart> values) {
                if (this.result.name_.isEmpty()) {
                    this.result.name_ = new ArrayList();
                }
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, this.result.name_);
                return this;
            }

            public Builder clearName() {
                this.result.name_ = Collections.emptyList();
                return this;
            }

            public boolean hasIdentifierValue() {
                return this.result.hasIdentifierValue();
            }

            public String getIdentifierValue() {
                return this.result.getIdentifierValue();
            }

            public Builder setIdentifierValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasIdentifierValue = true;
                this.result.identifierValue_ = value;
                return this;
            }

            public Builder clearIdentifierValue() {
                this.result.hasIdentifierValue = false;
                this.result.identifierValue_ = UninterpretedOption.getDefaultInstance().getIdentifierValue();
                return this;
            }

            public boolean hasPositiveIntValue() {
                return this.result.hasPositiveIntValue();
            }

            public long getPositiveIntValue() {
                return this.result.getPositiveIntValue();
            }

            public Builder setPositiveIntValue(long value) {
                this.result.hasPositiveIntValue = true;
                this.result.positiveIntValue_ = value;
                return this;
            }

            public Builder clearPositiveIntValue() {
                this.result.hasPositiveIntValue = false;
                this.result.positiveIntValue_ = 0;
                return this;
            }

            public boolean hasNegativeIntValue() {
                return this.result.hasNegativeIntValue();
            }

            public long getNegativeIntValue() {
                return this.result.getNegativeIntValue();
            }

            public Builder setNegativeIntValue(long value) {
                this.result.hasNegativeIntValue = true;
                this.result.negativeIntValue_ = value;
                return this;
            }

            public Builder clearNegativeIntValue() {
                this.result.hasNegativeIntValue = false;
                this.result.negativeIntValue_ = 0;
                return this;
            }

            public boolean hasDoubleValue() {
                return this.result.hasDoubleValue();
            }

            public double getDoubleValue() {
                return this.result.getDoubleValue();
            }

            public Builder setDoubleValue(double value) {
                this.result.hasDoubleValue = true;
                this.result.doubleValue_ = value;
                return this;
            }

            public Builder clearDoubleValue() {
                this.result.hasDoubleValue = false;
                this.result.doubleValue_ = 0.0d;
                return this;
            }

            public boolean hasStringValue() {
                return this.result.hasStringValue();
            }

            public ByteString getStringValue() {
                return this.result.getStringValue();
            }

            public Builder setStringValue(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.result.hasStringValue = true;
                this.result.stringValue_ = value;
                return this;
            }

            public Builder clearStringValue() {
                this.result.hasStringValue = false;
                this.result.stringValue_ = UninterpretedOption.getDefaultInstance().getStringValue();
                return this;
            }
        }

        public static final class NamePart extends GeneratedMessage {
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static final NamePart defaultInstance = new NamePart();
            private boolean hasIsExtension;
            private boolean hasNamePart;
            private boolean isExtension_;
            private int memoizedSerializedSize;
            private String namePart_;

            public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> {
                private NamePart result;

                private Builder() {
                }

                private static Builder create() {
                    Builder builder = new Builder();
                    builder.result = new NamePart();
                    return builder;
                }

                protected NamePart internalGetResult() {
                    return this.result;
                }

                public Builder clear() {
                    if (this.result == null) {
                        throw new IllegalStateException("Cannot call clear() after build().");
                    }
                    this.result = new NamePart();
                    return this;
                }

                public Builder clone() {
                    return create().mergeFrom(this.result);
                }

                public Descriptor getDescriptorForType() {
                    return NamePart.getDescriptor();
                }

                public NamePart getDefaultInstanceForType() {
                    return NamePart.getDefaultInstance();
                }

                public boolean isInitialized() {
                    return this.result.isInitialized();
                }

                public NamePart build() {
                    if (this.result == null || isInitialized()) {
                        return buildPartial();
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result);
                }

                private NamePart buildParsed() throws InvalidProtocolBufferException {
                    if (isInitialized()) {
                        return buildPartial();
                    }
                    throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
                }

                public NamePart buildPartial() {
                    if (this.result == null) {
                        throw new IllegalStateException("build() has already been called on this Builder.");
                    }
                    NamePart returnMe = this.result;
                    this.result = null;
                    return returnMe;
                }

                public Builder mergeFrom(Message other) {
                    if (other instanceof NamePart) {
                        return mergeFrom((NamePart) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(NamePart other) {
                    if (other != NamePart.getDefaultInstance()) {
                        if (other.hasNamePart()) {
                            setNamePart(other.getNamePart());
                        }
                        if (other.hasIsExtension()) {
                            setIsExtension(other.getIsExtension());
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
                                setNamePart(input.readString());
                                continue;
                            case 16:
                                setIsExtension(input.readBool());
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

                public boolean hasNamePart() {
                    return this.result.hasNamePart();
                }

                public String getNamePart() {
                    return this.result.getNamePart();
                }

                public Builder setNamePart(String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.result.hasNamePart = true;
                    this.result.namePart_ = value;
                    return this;
                }

                public Builder clearNamePart() {
                    this.result.hasNamePart = false;
                    this.result.namePart_ = NamePart.getDefaultInstance().getNamePart();
                    return this;
                }

                public boolean hasIsExtension() {
                    return this.result.hasIsExtension();
                }

                public boolean getIsExtension() {
                    return this.result.getIsExtension();
                }

                public Builder setIsExtension(boolean value) {
                    this.result.hasIsExtension = true;
                    this.result.isExtension_ = value;
                    return this;
                }

                public Builder clearIsExtension() {
                    this.result.hasIsExtension = false;
                    this.result.isExtension_ = false;
                    return this;
                }
            }

            private NamePart() {
                this.namePart_ = "";
                this.isExtension_ = false;
                this.memoizedSerializedSize = -1;
            }

            static {
                DescriptorProtos.getDescriptor();
                DescriptorProtos.internalForceInit();
            }

            public static NamePart getDefaultInstance() {
                return defaultInstance;
            }

            public NamePart getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptor getDescriptor() {
                return DescriptorProtos.f22854xb111d23c;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f22855x1698fcba;
            }

            public boolean hasNamePart() {
                return this.hasNamePart;
            }

            public String getNamePart() {
                return this.namePart_;
            }

            public boolean hasIsExtension() {
                return this.hasIsExtension;
            }

            public boolean getIsExtension() {
                return this.isExtension_;
            }

            public final boolean isInitialized() {
                if (this.hasNamePart && this.hasIsExtension) {
                    return true;
                }
                return false;
            }

            public void writeTo(CodedOutputStream output) throws IOException {
                if (hasNamePart()) {
                    output.writeString(1, getNamePart());
                }
                if (hasIsExtension()) {
                    output.writeBool(2, getIsExtension());
                }
                getUnknownFields().writeTo(output);
            }

            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                size = 0;
                if (hasNamePart()) {
                    size = 0 + CodedOutputStream.computeStringSize(1, getNamePart());
                }
                if (hasIsExtension()) {
                    size += CodedOutputStream.computeBoolSize(2, getIsExtension());
                }
                size += getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }

            public static NamePart parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static NamePart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static NamePart parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            public static NamePart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            public static NamePart parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static NamePart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static NamePart parseDelimitedFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
            }

            public static NamePart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
            }

            public static NamePart parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static NamePart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(NamePart prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            public Builder toBuilder() {
                return newBuilder(this);
            }
        }

        private UninterpretedOption() {
            this.name_ = Collections.emptyList();
            this.identifierValue_ = "";
            this.positiveIntValue_ = 0;
            this.negativeIntValue_ = 0;
            this.doubleValue_ = 0.0d;
            this.stringValue_ = ByteString.EMPTY;
            this.memoizedSerializedSize = -1;
        }

        static {
            DescriptorProtos.getDescriptor();
            DescriptorProtos.internalForceInit();
        }

        public static UninterpretedOption getDefaultInstance() {
            return defaultInstance;
        }

        public UninterpretedOption getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f22856x2101041;
        }

        public List<NamePart> getNameList() {
            return this.name_;
        }

        public int getNameCount() {
            return this.name_.size();
        }

        public NamePart getName(int index) {
            return (NamePart) this.name_.get(index);
        }

        public boolean hasIdentifierValue() {
            return this.hasIdentifierValue;
        }

        public String getIdentifierValue() {
            return this.identifierValue_;
        }

        public boolean hasPositiveIntValue() {
            return this.hasPositiveIntValue;
        }

        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        public boolean hasNegativeIntValue() {
            return this.hasNegativeIntValue;
        }

        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        public boolean hasDoubleValue() {
            return this.hasDoubleValue;
        }

        public double getDoubleValue() {
            return this.doubleValue_;
        }

        public boolean hasStringValue() {
            return this.hasStringValue;
        }

        public ByteString getStringValue() {
            return this.stringValue_;
        }

        public final boolean isInitialized() {
            for (NamePart element : getNameList()) {
                if (!element.isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (NamePart element : getNameList()) {
                output.writeMessage(2, element);
            }
            if (hasIdentifierValue()) {
                output.writeString(3, getIdentifierValue());
            }
            if (hasPositiveIntValue()) {
                output.writeUInt64(4, getPositiveIntValue());
            }
            if (hasNegativeIntValue()) {
                output.writeInt64(5, getNegativeIntValue());
            }
            if (hasDoubleValue()) {
                output.writeDouble(6, getDoubleValue());
            }
            if (hasStringValue()) {
                output.writeBytes(7, getStringValue());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            for (NamePart element : getNameList()) {
                size += CodedOutputStream.computeMessageSize(2, element);
            }
            if (hasIdentifierValue()) {
                size += CodedOutputStream.computeStringSize(3, getIdentifierValue());
            }
            if (hasPositiveIntValue()) {
                size += CodedOutputStream.computeUInt64Size(4, getPositiveIntValue());
            }
            if (hasNegativeIntValue()) {
                size += CodedOutputStream.computeInt64Size(5, getNegativeIntValue());
            }
            if (hasDoubleValue()) {
                size += CodedOutputStream.computeDoubleSize(6, getDoubleValue());
            }
            if (hasStringValue()) {
                size += CodedOutputStream.computeBytesSize(7, getStringValue());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        public static UninterpretedOption parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static UninterpretedOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        public static UninterpretedOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static UninterpretedOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input)).buildParsed();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeDelimitedFrom(input, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static UninterpretedOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UninterpretedOption prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }
    }

    private DescriptorProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Ü\u0002\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.p", "rotobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\"©\u0003\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.Extensi", "onRange\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u001a,\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYP", "E_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"\u0001\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001", " \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018", "\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\"¹\u0002\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003", "*\t\bè\u0007\u0010\u0002\"¸\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0002\n\fFieldOptions\u00122\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u001c\n\u0014experimental_map_key\u0018\t \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.Uninterpre", "tedOption\"#\n\u0005CType\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002*\t\bè\u0007\u0010\u0002\"]\n\u000bEnumOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"b\n\u0010EnumValueOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"`\n\u000eServiceOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"_\n\rMethodOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$", ".google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\bB)\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001"}, new FileDescriptor[0], new C57291());
    }

    public static void internalForceInit() {
    }
}
