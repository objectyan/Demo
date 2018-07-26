package com.google.protobuf;

import com.baidu.che.codriver.vr.C2848p;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class GeneratedMessage extends AbstractMessage {
    private UnknownFieldSet unknownFields = UnknownFieldSet.getDefaultInstance();

    public static abstract class Builder<BuilderType extends Builder> extends com.google.protobuf.AbstractMessage.Builder<BuilderType> {
        protected abstract GeneratedMessage internalGetResult();

        protected Builder() {
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        private FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetResult().internalGetFieldAccessorTable();
        }

        public Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        public Map<FieldDescriptor, Object> getAllFields() {
            return internalGetResult().getAllFields();
        }

        public com.google.protobuf.Message.Builder newBuilderForField(FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).newBuilder();
        }

        public boolean hasField(FieldDescriptor field) {
            return internalGetResult().hasField(field);
        }

        public Object getField(FieldDescriptor field) {
            if (field.isRepeated()) {
                return Collections.unmodifiableList((List) internalGetResult().getField(field));
            }
            return internalGetResult().getField(field);
        }

        public BuilderType setField(FieldDescriptor field, Object value) {
            internalGetFieldAccessorTable().getField(field).set(this, value);
            return this;
        }

        public BuilderType clearField(FieldDescriptor field) {
            internalGetFieldAccessorTable().getField(field).clear(this);
            return this;
        }

        public int getRepeatedFieldCount(FieldDescriptor field) {
            return internalGetResult().getRepeatedFieldCount(field);
        }

        public Object getRepeatedField(FieldDescriptor field, int index) {
            return internalGetResult().getRepeatedField(field, index);
        }

        public BuilderType setRepeatedField(FieldDescriptor field, int index, Object value) {
            internalGetFieldAccessorTable().getField(field).setRepeated(this, index, value);
            return this;
        }

        public BuilderType addRepeatedField(FieldDescriptor field, Object value) {
            internalGetFieldAccessorTable().getField(field).addRepeated(this, value);
            return this;
        }

        public final UnknownFieldSet getUnknownFields() {
            return internalGetResult().unknownFields;
        }

        public final BuilderType setUnknownFields(UnknownFieldSet unknownFields) {
            internalGetResult().unknownFields = unknownFields;
            return this;
        }

        public final BuilderType mergeUnknownFields(UnknownFieldSet unknownFields) {
            GeneratedMessage result = internalGetResult();
            result.unknownFields = UnknownFieldSet.newBuilder(result.unknownFields).mergeFrom(unknownFields).build();
            return this;
        }

        public boolean isInitialized() {
            return internalGetResult().isInitialized();
        }

        protected boolean parseUnknownField(CodedInputStream input, com.google.protobuf.UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return unknownFields.mergeFieldFrom(tag, input);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder> extends Builder<BuilderType> {
        protected abstract ExtendableMessage<MessageType> internalGetResult();

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
            message.extensions.setField(extension.getDescriptor(), extension.toReflectionType(value));
            return this;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.setRepeatedField(extension.getDescriptor(), index, extension.singularToReflectionType(value));
            return this;
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> extension, Type value) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.addRepeatedField(extension.getDescriptor(), extension.singularToReflectionType(value));
            return this;
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> extension) {
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyExtensionContainingType(extension);
            message.extensions.clearField(extension.getDescriptor());
            return this;
        }

        protected boolean parseUnknownField(CodedInputStream input, com.google.protobuf.UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            ExtendableMessage<MessageType> message = internalGetResult();
            return com.google.protobuf.AbstractMessage.Builder.mergeFieldFrom(input, unknownFields, extensionRegistry, this, tag);
        }

        public BuilderType setField(FieldDescriptor field, Object value) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.setField(field, value);
            }
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyContainingType(field);
            message.extensions.setField(field, value);
            return this;
        }

        public BuilderType clearField(FieldDescriptor field) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.clearField(field);
            }
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyContainingType(field);
            message.extensions.clearField(field);
            return this;
        }

        public BuilderType setRepeatedField(FieldDescriptor field, int index, Object value) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.setRepeatedField(field, index, value);
            }
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyContainingType(field);
            message.extensions.setRepeatedField(field, index, value);
            return this;
        }

        public BuilderType addRepeatedField(FieldDescriptor field, Object value) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.addRepeatedField(field, value);
            }
            ExtendableMessage<MessageType> message = internalGetResult();
            message.verifyContainingType(field);
            message.extensions.addRepeatedField(field, value);
            return this;
        }

        protected final void mergeExtensionFields(ExtendableMessage other) {
            internalGetResult().extensions.mergeFrom(other.extensions);
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage {
        private final FieldSet<FieldDescriptor> extensions = FieldSet.newFieldSet();

        protected class ExtensionWriter {
            private final Iterator<Entry<FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Entry<FieldDescriptor, Object> next;

            private ExtensionWriter(boolean messageSetWireFormat) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = (Entry) this.iter.next();
                }
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(int end, CodedOutputStream output) throws IOException {
                while (this.next != null && ((FieldDescriptor) this.next.getKey()).getNumber() < end) {
                    FieldDescriptor descriptor = (FieldDescriptor) this.next.getKey();
                    if (this.messageSetWireFormat && descriptor.getLiteJavaType() == JavaType.MESSAGE && !descriptor.isRepeated()) {
                        output.writeMessageSetExtension(descriptor.getNumber(), (Message) this.next.getValue());
                    } else {
                        FieldSet.writeField(descriptor, this.next.getValue(), output);
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
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        public final boolean hasExtension(GeneratedExtension<MessageType, ?> extension) {
            verifyExtensionContainingType(extension);
            return this.extensions.hasField(extension.getDescriptor());
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedFieldCount(extension.getDescriptor());
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> extension) {
            verifyExtensionContainingType(extension);
            FieldDescriptor descriptor = extension.getDescriptor();
            Object value = this.extensions.getField(descriptor);
            if (value != null) {
                return extension.fromReflectionType(value);
            }
            if (descriptor.getJavaType() == FieldDescriptor.JavaType.MESSAGE) {
                return extension.getMessageDefaultInstance();
            }
            return extension.fromReflectionType(descriptor.getDefaultValue());
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> extension, int index) {
            verifyExtensionContainingType(extension);
            return extension.singularFromReflectionType(this.extensions.getRepeatedField(extension.getDescriptor(), index));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
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

        public Map<FieldDescriptor, Object> getAllFields() {
            Map<FieldDescriptor, Object> result = getAllFieldsMutable();
            result.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(result);
        }

        public boolean hasField(FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.hasField(field);
            }
            verifyContainingType(field);
            return this.extensions.hasField(field);
        }

        public Object getField(FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.getField(field);
            }
            verifyContainingType(field);
            Object value = this.extensions.getField(field);
            if (value != null) {
                return value;
            }
            if (field.getJavaType() == FieldDescriptor.JavaType.MESSAGE) {
                return DynamicMessage.getDefaultInstance(field.getMessageType());
            }
            return field.getDefaultValue();
        }

        public int getRepeatedFieldCount(FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.getRepeatedFieldCount(field);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedFieldCount(field);
        }

        public Object getRepeatedField(FieldDescriptor field, int index) {
            if (!field.isExtension()) {
                return super.getRepeatedField(field, index);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedField(field, index);
        }

        private void verifyContainingType(FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static final class FieldAccessorTable {
        private final Descriptor descriptor;
        private final FieldAccessor[] fields;

        private interface FieldAccessor {
            void addRepeated(Builder builder, Object obj);

            void clear(Builder builder);

            Object get(GeneratedMessage generatedMessage);

            Object getRepeated(GeneratedMessage generatedMessage, int i);

            int getRepeatedCount(GeneratedMessage generatedMessage);

            boolean has(GeneratedMessage generatedMessage);

            com.google.protobuf.Message.Builder newBuilder();

            void set(Builder builder, Object obj);

            void setRepeated(Builder builder, int i, Object obj);
        }

        private static class RepeatedFieldAccessor implements FieldAccessor {
            protected final Method addRepeatedMethod;
            protected final Method clearMethod;
            protected final Method getCountMethod;
            protected final Method getMethod;
            protected final Method getRepeatedMethod;
            protected final Method setRepeatedMethod;
            protected final Class type = this.getRepeatedMethod.getReturnType();

            RepeatedFieldAccessor(FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "List", new Class[0]);
                this.getRepeatedMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, Integer.TYPE);
                this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, C2848p.af + camelCaseName, Integer.TYPE, this.type);
                this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "add" + camelCaseName, this.type);
                this.getCountMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Count", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
            }

            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
            }

            public void set(Builder builder, Object value) {
                clear(builder);
                for (Object element : (List) value) {
                    addRepeated(builder, element);
                }
            }

            public Object getRepeated(GeneratedMessage message, int index) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, message, Integer.valueOf(index));
            }

            public void setRepeated(Builder builder, int index, Object value) {
                GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(index), value);
            }

            public void addRepeated(Builder builder, Object value) {
                GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, value);
            }

            public boolean has(GeneratedMessage message) {
                throw new UnsupportedOperationException("hasField() called on a singular field.");
            }

            public int getRepeatedCount(GeneratedMessage message) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, message, new Object[0])).intValue();
            }

            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            public com.google.protobuf.Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        private static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private final Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private final Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", EnumValueDescriptor.class);

            RepeatedEnumFieldAccessor(FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
            }

            public Object get(GeneratedMessage message) {
                List newList = new ArrayList();
                for (Object element : (List) super.get(message)) {
                    newList.add(GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, element, new Object[0]));
                }
                return Collections.unmodifiableList(newList);
            }

            public Object getRepeated(GeneratedMessage message, int index) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(message, index), new Object[0]);
            }

            public void setRepeated(Builder builder, int index, Object value) {
                super.setRepeated(builder, index, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
            }

            public void addRepeated(Builder builder, Object value) {
                super.addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
            }
        }

        private static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);

            RepeatedMessageFieldAccessor(FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
            }

            private Object coerceType(Object value) {
                return this.type.isInstance(value) ? value : ((com.google.protobuf.Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).build();
            }

            public void setRepeated(Builder builder, int index, Object value) {
                super.setRepeated(builder, index, coerceType(value));
            }

            public void addRepeated(Builder builder, Object value) {
                super.addRepeated(builder, coerceType(value));
            }

            public com.google.protobuf.Message.Builder newBuilder() {
                return (com.google.protobuf.Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }
        }

        private static class SingularFieldAccessor implements FieldAccessor {
            protected final Method clearMethod;
            protected final Method getMethod;
            protected final Method hasMethod;
            protected final Method setMethod;
            protected final Class type = this.getMethod.getReturnType();

            SingularFieldAccessor(FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, new Class[0]);
                this.setMethod = GeneratedMessage.getMethodOrDie(builderClass, C2848p.af + camelCaseName, this.type);
                this.hasMethod = GeneratedMessage.getMethodOrDie(messageClass, "has" + camelCaseName, new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
            }

            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
            }

            public void set(Builder builder, Object value) {
                GeneratedMessage.invokeOrDie(this.setMethod, builder, value);
            }

            public Object getRepeated(GeneratedMessage message, int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            public void setRepeated(Builder builder, int index, Object value) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            public void addRepeated(Builder builder, Object value) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            public boolean has(GeneratedMessage message) {
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, message, new Object[0])).booleanValue();
            }

            public int getRepeatedCount(GeneratedMessage message) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            public com.google.protobuf.Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        private static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", EnumValueDescriptor.class);

            SingularEnumFieldAccessor(FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
            }

            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(message), new Object[0]);
            }

            public void set(Builder builder, Object value) {
                super.set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
            }
        }

        private static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);

            SingularMessageFieldAccessor(FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
            }

            private Object coerceType(Object value) {
                return this.type.isInstance(value) ? value : ((com.google.protobuf.Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).build();
            }

            public void set(Builder builder, Object value) {
                super.set(builder, coerceType(value));
            }

            public com.google.protobuf.Message.Builder newBuilder() {
                return (com.google.protobuf.Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }
        }

        public FieldAccessorTable(Descriptor descriptor, String[] camelCaseNames, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
            this.descriptor = descriptor;
            this.fields = new FieldAccessor[descriptor.getFields().size()];
            for (int i = 0; i < this.fields.length; i++) {
                FieldDescriptor field = (FieldDescriptor) descriptor.getFields().get(i);
                if (field.isRepeated()) {
                    if (field.getJavaType() == FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i] = new RepeatedMessageFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                    } else if (field.getJavaType() == FieldDescriptor.JavaType.ENUM) {
                        this.fields[i] = new RepeatedEnumFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                    } else {
                        this.fields[i] = new RepeatedFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                    }
                } else if (field.getJavaType() == FieldDescriptor.JavaType.MESSAGE) {
                    this.fields[i] = new SingularMessageFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                } else if (field.getJavaType() == FieldDescriptor.JavaType.ENUM) {
                    this.fields[i] = new SingularEnumFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                } else {
                    this.fields[i] = new SingularFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                }
            }
        }

        private FieldAccessor getField(FieldDescriptor field) {
            if (field.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!field.isExtension()) {
                return this.fields[field.getIndex()];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }
    }

    public static final class GeneratedExtension<ContainingType extends Message, Type> {
        private final FieldDescriptor descriptor;
        private final Method enumGetValueDescriptor;
        private final Method enumValueOf;
        private final Message messageDefaultInstance;
        private final Class type;

        private GeneratedExtension(FieldDescriptor descriptor, Class type) {
            if (descriptor.isExtension()) {
                this.descriptor = descriptor;
                this.type = type;
                switch (descriptor.getJavaType()) {
                    case MESSAGE:
                        this.enumValueOf = null;
                        this.enumGetValueDescriptor = null;
                        this.messageDefaultInstance = (Message) GeneratedMessage.invokeOrDie(GeneratedMessage.getMethodOrDie(type, "getDefaultInstance", new Class[0]), null, new Object[0]);
                        return;
                    case ENUM:
                        this.enumValueOf = GeneratedMessage.getMethodOrDie(type, "valueOf", EnumValueDescriptor.class);
                        this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(type, "getValueDescriptor", new Class[0]);
                        this.messageDefaultInstance = null;
                        return;
                    default:
                        this.enumValueOf = null;
                        this.enumGetValueDescriptor = null;
                        this.messageDefaultInstance = null;
                        return;
                }
            }
            throw new IllegalArgumentException("GeneratedExtension given a regular (non-extension) field.");
        }

        public FieldDescriptor getDescriptor() {
            return this.descriptor;
        }

        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        private Object fromReflectionType(Object value) {
            if (!this.descriptor.isRepeated()) {
                return singularFromReflectionType(value);
            }
            if (this.descriptor.getJavaType() != FieldDescriptor.JavaType.MESSAGE && this.descriptor.getJavaType() != FieldDescriptor.JavaType.ENUM) {
                return value;
            }
            List result = new ArrayList();
            for (Object element : (List) value) {
                result.add(singularFromReflectionType(element));
            }
            return result;
        }

        private Object singularFromReflectionType(Object value) {
            switch (this.descriptor.getJavaType()) {
                case MESSAGE:
                    if (this.type.isInstance(value)) {
                        return value;
                    }
                    return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) value).build();
                case ENUM:
                    return GeneratedMessage.invokeOrDie(this.enumValueOf, null, (EnumValueDescriptor) value);
                default:
                    return value;
            }
        }

        private Object toReflectionType(Object value) {
            if (!this.descriptor.isRepeated()) {
                return singularToReflectionType(value);
            }
            if (this.descriptor.getJavaType() != FieldDescriptor.JavaType.ENUM) {
                return value;
            }
            Object arrayList = new ArrayList();
            for (Object element : (List) value) {
                arrayList.add(singularToReflectionType(element));
            }
            return arrayList;
        }

        private Object singularToReflectionType(Object value) {
            switch (this.descriptor.getJavaType()) {
                case ENUM:
                    return GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, value, new Object[0]);
                default:
                    return value;
            }
        }
    }

    protected abstract FieldAccessorTable internalGetFieldAccessorTable();

    protected GeneratedMessage() {
    }

    public Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    private Map<FieldDescriptor, Object> getAllFieldsMutable() {
        TreeMap<FieldDescriptor, Object> result = new TreeMap();
        for (FieldDescriptor field : internalGetFieldAccessorTable().descriptor.getFields()) {
            if (field.isRepeated()) {
                List value = (List) getField(field);
                if (!value.isEmpty()) {
                    result.put(field, value);
                }
            } else if (hasField(field)) {
                result.put(field, getField(field));
            }
        }
        return result;
    }

    public boolean isInitialized() {
        for (FieldDescriptor field : getDescriptorForType().getFields()) {
            if (field.isRequired() && !hasField(field)) {
                return false;
            }
            if (field.getJavaType() == FieldDescriptor.JavaType.MESSAGE) {
                if (field.isRepeated()) {
                    for (Message element : (List) getField(field)) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(field) && !((Message) getField(field)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Map<FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable());
    }

    public boolean hasField(FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).has(this);
    }

    public Object getField(FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).get(this);
    }

    public int getRepeatedFieldCount(FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
    }

    public Object getRepeatedField(FieldDescriptor field, int index) {
        return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newGeneratedExtension(FieldDescriptor descriptor, Class<Type> type) {
        if (!descriptor.isRepeated()) {
            return new GeneratedExtension(descriptor, type);
        }
        throw new IllegalArgumentException("Must call newRepeatedGeneratedExtension() for repeated types.");
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, List<Type>> newRepeatedGeneratedExtension(FieldDescriptor descriptor, Class<Type> type) {
        if (descriptor.isRepeated()) {
            return new GeneratedExtension(descriptor, type);
        }
        throw new IllegalArgumentException("Must call newGeneratedExtension() for non-repeated types.");
    }

    private static Method getMethodOrDie(Class clazz, String name, Class... params) {
        try {
            return clazz.getMethod(name, params);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
        }
    }

    private static Object invokeOrDie(Method method, Object object, Object... params) {
        try {
            return method.invoke(object, params);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }
}
