package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.WireFormat.FieldType;
import com.google.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite extends AbstractMessageLite {

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends com.google.protobuf.AbstractMessageLite.Builder<BuilderType> {
        public abstract MessageType getDefaultInstanceForType();

        protected abstract MessageType internalGetResult();

        public abstract BuilderType mergeFrom(MessageType messageType);

        protected Builder() {
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return input.skipField(tag);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> {
        protected abstract MessageType internalGetResult();

        protected ExtendableBuilder() {
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final boolean hasExtension(GeneratedExtension<MessageType, ?> extension) {
            return internalGetResult().hasExtension(extension);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            return internalGetResult().getExtensionCount(extension);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> extension) {
            return internalGetResult().getExtension(extension);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> extension, int index) {
            return internalGetResult().getExtension(extension, index);
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> extension, Type value) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.setField(extension.descriptor, value);
            return this;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.setRepeatedField(extension.descriptor, index, value);
            return this;
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> extension, Type value) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.addRepeatedField(extension.descriptor, value);
            return this;
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> extension) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.clearField(extension.descriptor);
            return this;
        }

        protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            FieldSet<ExtensionDescriptor> extensions = internalGetResult().extensions;
            int wireType = WireFormat.getTagWireType(tag);
            GeneratedExtension<MessageType, ?> extension = extensionRegistry.findLiteExtensionByNumber(getDefaultInstanceForType(), WireFormat.getTagFieldNumber(tag));
            if (extension == null || wireType != FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), extension.descriptor.isPacked())) {
                return input.skipField(tag);
            }
            if (extension.descriptor.isPacked()) {
                int limit = input.pushLimit(input.readRawVarint32());
                if (extension.descriptor.getLiteType() == FieldType.ENUM) {
                    while (input.getBytesUntilLimit() > 0) {
                        EnumLite value = extension.descriptor.getEnumType().findValueByNumber(input.readEnum());
                        if (value == null) {
                            return true;
                        }
                        extensions.addRepeatedField(extension.descriptor, value);
                    }
                } else {
                    while (input.getBytesUntilLimit() > 0) {
                        extensions.addRepeatedField(extension.descriptor, FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType()));
                    }
                }
                input.popLimit(limit);
            } else {
                Object value2;
                switch (extension.descriptor.getLiteJavaType()) {
                    case MESSAGE:
                        com.google.protobuf.MessageLite.Builder subBuilder = null;
                        if (!extension.descriptor.isRepeated()) {
                            MessageLite existingValue = (MessageLite) extensions.getField(extension.descriptor);
                            if (existingValue != null) {
                                subBuilder = existingValue.toBuilder();
                            }
                        }
                        if (subBuilder == null) {
                            subBuilder = extension.messageDefaultInstance.newBuilderForType();
                        }
                        if (extension.descriptor.getLiteType() == FieldType.GROUP) {
                            input.readGroup(extension.getNumber(), subBuilder, extensionRegistry);
                        } else {
                            input.readMessage(subBuilder, extensionRegistry);
                        }
                        value2 = subBuilder.build();
                        break;
                    case ENUM:
                        value2 = extension.descriptor.getEnumType().findValueByNumber(input.readEnum());
                        if (value2 == null) {
                            return true;
                        }
                        break;
                    default:
                        value2 = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType());
                        break;
                }
                if (extension.descriptor.isRepeated()) {
                    extensions.addRepeatedField(extension.descriptor, value2);
                } else {
                    extensions.setField(extension.descriptor, value2);
                }
            }
            return true;
        }

        protected final void mergeExtensionFields(MessageType other) {
            internalGetResult().extensions.mergeFrom(other.extensions);
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite {
        private final FieldSet<ExtensionDescriptor> extensions = FieldSet.newFieldSet();

        protected class ExtensionWriter {
            private final Iterator<Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Entry<ExtensionDescriptor, Object> next;

            private ExtensionWriter(boolean messageSetWireFormat) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = (Entry) this.iter.next();
                }
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(int end, CodedOutputStream output) throws IOException {
                while (this.next != null && ((ExtensionDescriptor) this.next.getKey()).getNumber() < end) {
                    ExtensionDescriptor extension = (ExtensionDescriptor) this.next.getKey();
                    if (this.messageSetWireFormat && extension.getLiteJavaType() == JavaType.MESSAGE && !extension.isRepeated()) {
                        output.writeMessageSetExtension(extension.getNumber(), (MessageLite) this.next.getValue());
                    } else {
                        FieldSet.writeField(extension, this.next.getValue(), output);
                    }
                    if (this.iter.hasNext()) {
                        this.next = (Entry) this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtendableMessage() {
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final boolean hasExtension(GeneratedExtension<MessageType, ?> extension) {
            verifyExtensionContainingType(extension);
            return this.extensions.hasField(extension.descriptor);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedFieldCount(extension.descriptor);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> extension) {
            verifyExtensionContainingType(extension);
            Object value = this.extensions.getField(extension.descriptor);
            if (value == null) {
                return extension.defaultValue;
            }
            return value;
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> extension, int index) {
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedField(extension.descriptor, index);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        protected ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    private static final class ExtensionDescriptor implements FieldDescriptorLite<ExtensionDescriptor> {
        private final EnumLiteMap<?> enumTypeMap;
        private final boolean isPacked;
        private final boolean isRepeated;
        private final int number;
        private final FieldType type;

        private ExtensionDescriptor(EnumLiteMap<?> enumTypeMap, int number, FieldType type, boolean isRepeated, boolean isPacked) {
            this.enumTypeMap = enumTypeMap;
            this.number = number;
            this.type = type;
            this.isRepeated = isRepeated;
            this.isPacked = isPacked;
        }

        public int getNumber() {
            return this.number;
        }

        public FieldType getLiteType() {
            return this.type;
        }

        public JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public boolean isRepeated() {
            return this.isRepeated;
        }

        public boolean isPacked() {
            return this.isPacked;
        }

        public EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        public com.google.protobuf.MessageLite.Builder internalMergeFrom(com.google.protobuf.MessageLite.Builder to, MessageLite from) {
            return ((Builder) to).mergeFrom((GeneratedMessageLite) from);
        }

        public int compareTo(ExtensionDescriptor other) {
            return this.number - other.number;
        }
    }

    public static final class GeneratedExtension<ContainingType extends MessageLite, Type> {
        private final ContainingType containingTypeDefaultInstance;
        private final Type defaultValue;
        private final ExtensionDescriptor descriptor;
        private final MessageLite messageDefaultInstance;

        private GeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, ExtensionDescriptor descriptor) {
            this.containingTypeDefaultInstance = containingTypeDefaultInstance;
            this.defaultValue = defaultValue;
            this.messageDefaultInstance = messageDefaultInstance;
            this.descriptor = descriptor;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }
    }

    protected GeneratedMessageLite() {
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newGeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, EnumLiteMap<?> enumTypeMap, int number, FieldType type) {
        return new GeneratedExtension(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, false, false));
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, List<Type>> newRepeatedGeneratedExtension(ContainingType containingTypeDefaultInstance, MessageLite messageDefaultInstance, EnumLiteMap<?> enumTypeMap, int number, FieldType type, boolean isPacked) {
        return new GeneratedExtension(containingTypeDefaultInstance, Collections.emptyList(), messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, true, isPacked));
    }
}
