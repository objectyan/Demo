package com.google.protobuf;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class DynamicMessage extends AbstractMessage {
    private final FieldSet<FieldDescriptor> fields;
    private int memoizedSize;
    private final Descriptor type;
    private final UnknownFieldSet unknownFields;

    public static final class Builder extends com.google.protobuf.AbstractMessage.Builder<Builder> {
        private FieldSet<FieldDescriptor> fields;
        private final Descriptor type;
        private UnknownFieldSet unknownFields;

        private Builder(Descriptor type) {
            this.type = type;
            this.fields = FieldSet.newFieldSet();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public Builder clear() {
            if (this.fields == null) {
                throw new IllegalStateException("Cannot call clear() after build().");
            }
            this.fields.clear();
            return this;
        }

        public Builder mergeFrom(Message other) {
            if (!(other instanceof DynamicMessage)) {
                return (Builder) super.mergeFrom(other);
            }
            DynamicMessage otherDynamicMessage = (DynamicMessage) other;
            if (otherDynamicMessage.type != this.type) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            this.fields.mergeFrom(otherDynamicMessage.fields);
            mergeUnknownFields(otherDynamicMessage.unknownFields);
            return this;
        }

        public DynamicMessage build() {
            if (this.fields == null || isInitialized()) {
                return buildPartial();
            }
            throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(this.type, this.fields, this.unknownFields));
        }

        private DynamicMessage buildParsed() throws InvalidProtocolBufferException {
            if (isInitialized()) {
                return buildPartial();
            }
            throw com.google.protobuf.AbstractMessage.Builder.newUninitializedMessageException(new DynamicMessage(this.type, this.fields, this.unknownFields)).asInvalidProtocolBufferException();
        }

        public DynamicMessage buildPartial() {
            if (this.fields == null) {
                throw new IllegalStateException("build() has already been called on this Builder.");
            }
            this.fields.makeImmutable();
            DynamicMessage result = new DynamicMessage(this.type, this.fields, this.unknownFields);
            this.fields = null;
            this.unknownFields = null;
            return result;
        }

        public Builder clone() {
            Builder result = new Builder(this.type);
            result.fields.mergeFrom(this.fields);
            return result;
        }

        public boolean isInitialized() {
            return DynamicMessage.isInitialized(this.type, this.fields);
        }

        public Descriptor getDescriptorForType() {
            return this.type;
        }

        public DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        public Map<FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        public Builder newBuilderForField(FieldDescriptor field) {
            verifyContainingType(field);
            if (field.getJavaType() == JavaType.MESSAGE) {
                return new Builder(field.getMessageType());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        public boolean hasField(FieldDescriptor field) {
            verifyContainingType(field);
            return this.fields.hasField(field);
        }

        public Object getField(FieldDescriptor field) {
            verifyContainingType(field);
            Object result = this.fields.getField(field);
            if (result != null) {
                return result;
            }
            if (field.getJavaType() == JavaType.MESSAGE) {
                return DynamicMessage.getDefaultInstance(field.getMessageType());
            }
            return field.getDefaultValue();
        }

        public Builder setField(FieldDescriptor field, Object value) {
            verifyContainingType(field);
            this.fields.setField(field, value);
            return this;
        }

        public Builder clearField(FieldDescriptor field) {
            verifyContainingType(field);
            this.fields.clearField(field);
            return this;
        }

        public int getRepeatedFieldCount(FieldDescriptor field) {
            verifyContainingType(field);
            return this.fields.getRepeatedFieldCount(field);
        }

        public Object getRepeatedField(FieldDescriptor field, int index) {
            verifyContainingType(field);
            return this.fields.getRepeatedField(field, index);
        }

        public Builder setRepeatedField(FieldDescriptor field, int index, Object value) {
            verifyContainingType(field);
            this.fields.setRepeatedField(field, index, value);
            return this;
        }

        public Builder addRepeatedField(FieldDescriptor field, Object value) {
            verifyContainingType(field);
            this.fields.addRepeatedField(field, value);
            return this;
        }

        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public Builder setUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = unknownFields;
            return this;
        }

        public Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
            return this;
        }

        private void verifyContainingType(FieldDescriptor field) {
            if (field.getContainingType() != this.type) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    private DynamicMessage(Descriptor type, FieldSet<FieldDescriptor> fields, UnknownFieldSet unknownFields) {
        this.memoizedSize = -1;
        this.type = type;
        this.fields = fields;
        this.unknownFields = unknownFields;
    }

    public static DynamicMessage getDefaultInstance(Descriptor type) {
        return new DynamicMessage(type, FieldSet.emptySet(), UnknownFieldSet.getDefaultInstance());
    }

    public static DynamicMessage parseFrom(Descriptor type, CodedInputStream input) throws IOException {
        return ((Builder) newBuilder(type).mergeFrom(input)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, CodedInputStream input, ExtensionRegistry extensionRegistry) throws IOException {
        return ((Builder) newBuilder(type).mergeFrom(input, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, ByteString data) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(type).mergeFrom(data)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, ByteString data, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(type).mergeFrom(data, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, byte[] data) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(type).mergeFrom(data)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, byte[] data, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return ((Builder) newBuilder(type).mergeFrom(data, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, InputStream input) throws IOException {
        return ((Builder) newBuilder(type).mergeFrom(input)).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptor type, InputStream input, ExtensionRegistry extensionRegistry) throws IOException {
        return ((Builder) newBuilder(type).mergeFrom(input, (ExtensionRegistryLite) extensionRegistry)).buildParsed();
    }

    public static Builder newBuilder(Descriptor type) {
        return new Builder(type);
    }

    public static Builder newBuilder(Message prototype) {
        return new Builder(prototype.getDescriptorForType()).mergeFrom(prototype);
    }

    public Descriptor getDescriptorForType() {
        return this.type;
    }

    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    public Map<FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    public boolean hasField(FieldDescriptor field) {
        verifyContainingType(field);
        return this.fields.hasField(field);
    }

    public Object getField(FieldDescriptor field) {
        verifyContainingType(field);
        Object result = this.fields.getField(field);
        if (result != null) {
            return result;
        }
        if (field.getJavaType() == JavaType.MESSAGE) {
            return getDefaultInstance(field.getMessageType());
        }
        return field.getDefaultValue();
    }

    public int getRepeatedFieldCount(FieldDescriptor field) {
        verifyContainingType(field);
        return this.fields.getRepeatedFieldCount(field);
    }

    public Object getRepeatedField(FieldDescriptor field, int index) {
        verifyContainingType(field);
        return this.fields.getRepeatedField(field, index);
    }

    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private static boolean isInitialized(Descriptor type, FieldSet<FieldDescriptor> fields) {
        for (FieldDescriptor field : type.getFields()) {
            if (field.isRequired() && !fields.hasField(field)) {
                return false;
            }
        }
        return fields.isInitialized();
    }

    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(output);
            this.unknownFields.writeAsMessageSetTo(output);
            return;
        }
        this.fields.writeTo(output);
        this.unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        if (this.type.getOptions().getMessageSetWireFormat()) {
            size = this.fields.getMessageSetSerializedSize() + this.unknownFields.getSerializedSizeAsMessageSet();
        } else {
            size = this.fields.getSerializedSize() + this.unknownFields.getSerializedSize();
        }
        this.memoizedSize = size;
        return size;
    }

    public Builder newBuilderForType() {
        return new Builder(this.type);
    }

    public Builder toBuilder() {
        return newBuilderForType().mergeFrom((Message) this);
    }

    private void verifyContainingType(FieldDescriptor field) {
        if (field.getContainingType() != this.type) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }
}
