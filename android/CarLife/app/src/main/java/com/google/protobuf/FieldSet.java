package com.google.protobuf;

import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.WireFormat.FieldType;
import com.google.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private Map<FieldDescriptorType, Object> fields;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        EnumLiteMap<?> getEnumType();

        JavaType getLiteJavaType();

        FieldType getLiteType();

        int getNumber();

        Builder internalMergeFrom(Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
        this.fields = new TreeMap();
    }

    private FieldSet(boolean dummy) {
        this.fields = Collections.emptyMap();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public void makeImmutable() {
        for (Entry<FieldDescriptorType, Object> entry : this.fields.entrySet()) {
            if (((FieldDescriptorLite) entry.getKey()).isRepeated()) {
                this.fields.put(entry.getKey(), Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        this.fields = Collections.unmodifiableMap(this.fields);
    }

    public void clear() {
        this.fields.clear();
    }

    public Map<FieldDescriptorType, Object> getAllFields() {
        return Collections.unmodifiableMap(this.fields);
    }

    public Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.fields.entrySet().iterator();
    }

    public boolean hasField(FieldDescriptorType descriptor) {
        if (!descriptor.isRepeated()) {
            return this.fields.get(descriptor) != null;
        } else {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
    }

    public Object getField(FieldDescriptorType descriptor) {
        return this.fields.get(descriptor);
    }

    public void setField(FieldDescriptorType descriptor, Object value) {
        if (!descriptor.isRepeated()) {
            verifyType(descriptor.getLiteType(), value);
        } else if (value instanceof List) {
            List<Object> newList = new ArrayList();
            newList.addAll((List) value);
            for (Object element : newList) {
                verifyType(descriptor.getLiteType(), element);
            }
            value = newList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.fields.put(descriptor, value);
    }

    public void clearField(FieldDescriptorType descriptor) {
        this.fields.remove(descriptor);
    }

    public int getRepeatedFieldCount(FieldDescriptorType descriptor) {
        if (descriptor.isRepeated()) {
            Object value = this.fields.get(descriptor);
            if (value == null) {
                return 0;
            }
            return ((List) value).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(FieldDescriptorType descriptor, int index) {
        if (descriptor.isRepeated()) {
            Object value = this.fields.get(descriptor);
            if (value != null) {
                return ((List) value).get(index);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setRepeatedField(FieldDescriptorType descriptor, int index, Object value) {
        if (descriptor.isRepeated()) {
            Object list = this.fields.get(descriptor);
            if (list == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(descriptor.getLiteType(), value);
            ((List) list).set(index, value);
            return;
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void addRepeatedField(FieldDescriptorType descriptor, Object value) {
        if (descriptor.isRepeated()) {
            List list;
            verifyType(descriptor.getLiteType(), value);
            Object existingValue = this.fields.get(descriptor);
            if (existingValue == null) {
                list = new ArrayList();
                this.fields.put(descriptor, list);
            } else {
                list = (List) existingValue;
            }
            list.add(value);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private static void verifyType(FieldType type, Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        boolean isValid = false;
        switch (type.getJavaType()) {
            case INT:
                isValid = value instanceof Integer;
                break;
            case LONG:
                isValid = value instanceof Long;
                break;
            case FLOAT:
                isValid = value instanceof Float;
                break;
            case DOUBLE:
                isValid = value instanceof Double;
                break;
            case BOOLEAN:
                isValid = value instanceof Boolean;
                break;
            case STRING:
                isValid = value instanceof String;
                break;
            case BYTE_STRING:
                isValid = value instanceof ByteString;
                break;
            case ENUM:
                isValid = value instanceof EnumLite;
                break;
            case MESSAGE:
                isValid = value instanceof MessageLite;
                break;
        }
        if (!isValid) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public boolean isInitialized() {
        for (Entry<FieldDescriptorType, Object> entry : this.fields.entrySet()) {
            FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
            if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
                if (descriptor.isRepeated()) {
                    for (MessageLite element : (List) entry.getValue()) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((MessageLite) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    static int getWireFormatForFieldType(FieldType type, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type.getWireType();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> other) {
        for (Entry<FieldDescriptorType, Object> entry : other.fields.entrySet()) {
            FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
            Object otherValue = entry.getValue();
            Object value;
            if (descriptor.isRepeated()) {
                value = this.fields.get(descriptor);
                if (value == null) {
                    this.fields.put(descriptor, new ArrayList((List) otherValue));
                } else {
                    ((List) value).addAll((List) otherValue);
                }
            } else if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
                value = this.fields.get(descriptor);
                if (value == null) {
                    this.fields.put(descriptor, otherValue);
                } else {
                    this.fields.put(descriptor, descriptor.internalMergeFrom(((MessageLite) value).toBuilder(), (MessageLite) otherValue).build());
                }
            } else {
                this.fields.put(descriptor, otherValue);
            }
        }
    }

    public static Object readPrimitiveField(CodedInputStream input, FieldType type) throws IOException {
        switch (type) {
            case DOUBLE:
                return Double.valueOf(input.readDouble());
            case FLOAT:
                return Float.valueOf(input.readFloat());
            case INT64:
                return Long.valueOf(input.readInt64());
            case UINT64:
                return Long.valueOf(input.readUInt64());
            case INT32:
                return Integer.valueOf(input.readInt32());
            case FIXED64:
                return Long.valueOf(input.readFixed64());
            case FIXED32:
                return Integer.valueOf(input.readFixed32());
            case BOOL:
                return Boolean.valueOf(input.readBool());
            case STRING:
                return input.readString();
            case BYTES:
                return input.readBytes();
            case UINT32:
                return Integer.valueOf(input.readUInt32());
            case SFIXED32:
                return Integer.valueOf(input.readSFixed32());
            case SFIXED64:
                return Long.valueOf(input.readSFixed64());
            case SINT32:
                return Integer.valueOf(input.readSInt32());
            case SINT64:
                return Long.valueOf(input.readSInt64());
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public void writeTo(CodedOutputStream output) throws IOException {
        for (Entry<FieldDescriptorType, Object> entry : this.fields.entrySet()) {
            writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), output);
        }
    }

    public void writeMessageSetTo(CodedOutputStream output) throws IOException {
        for (Entry<FieldDescriptorType, Object> entry : this.fields.entrySet()) {
            FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
            if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
                writeField(descriptor, entry.getValue(), output);
            } else {
                output.writeMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
            }
        }
    }

    private static void writeElement(CodedOutputStream output, FieldType type, int number, Object value) throws IOException {
        if (type == FieldType.GROUP) {
            output.writeGroup(number, (MessageLite) value);
            return;
        }
        output.writeTag(number, getWireFormatForFieldType(type, false));
        writeElementNoTag(output, type, value);
    }

    private static void writeElementNoTag(CodedOutputStream output, FieldType type, Object value) throws IOException {
        switch (type) {
            case DOUBLE:
                output.writeDoubleNoTag(((Double) value).doubleValue());
                return;
            case FLOAT:
                output.writeFloatNoTag(((Float) value).floatValue());
                return;
            case INT64:
                output.writeInt64NoTag(((Long) value).longValue());
                return;
            case UINT64:
                output.writeUInt64NoTag(((Long) value).longValue());
                return;
            case INT32:
                output.writeInt32NoTag(((Integer) value).intValue());
                return;
            case FIXED64:
                output.writeFixed64NoTag(((Long) value).longValue());
                return;
            case FIXED32:
                output.writeFixed32NoTag(((Integer) value).intValue());
                return;
            case BOOL:
                output.writeBoolNoTag(((Boolean) value).booleanValue());
                return;
            case STRING:
                output.writeStringNoTag((String) value);
                return;
            case BYTES:
                output.writeBytesNoTag((ByteString) value);
                return;
            case UINT32:
                output.writeUInt32NoTag(((Integer) value).intValue());
                return;
            case SFIXED32:
                output.writeSFixed32NoTag(((Integer) value).intValue());
                return;
            case SFIXED64:
                output.writeSFixed64NoTag(((Long) value).longValue());
                return;
            case SINT32:
                output.writeSInt32NoTag(((Integer) value).intValue());
                return;
            case SINT64:
                output.writeSInt64NoTag(((Long) value).longValue());
                return;
            case GROUP:
                output.writeGroupNoTag((MessageLite) value);
                return;
            case MESSAGE:
                output.writeMessageNoTag((MessageLite) value);
                return;
            case ENUM:
                output.writeEnumNoTag(((EnumLite) value).getNumber());
                return;
            default:
                return;
        }
    }

    public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
        FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (descriptor.isRepeated()) {
            List<Object> valueList = (List) value;
            if (descriptor.isPacked()) {
                output.writeTag(number, 2);
                int dataSize = 0;
                for (Object element : valueList) {
                    dataSize += computeElementSizeNoTag(type, element);
                }
                output.writeRawVarint32(dataSize);
                for (Object element2 : valueList) {
                    writeElementNoTag(output, type, element2);
                }
                return;
            }
            for (Object element22 : valueList) {
                writeElement(output, type, number, element22);
            }
            return;
        }
        writeElement(output, type, number, value);
    }

    public int getSerializedSize() {
        int size = 0;
        for (Entry<FieldDescriptorType, Object> entry : this.fields.entrySet()) {
            size += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return size;
    }

    public int getMessageSetSerializedSize() {
        int size = 0;
        for (Entry<FieldDescriptorType, Object> entry : this.fields.entrySet()) {
            FieldDescriptorLite descriptor = (FieldDescriptorLite) entry.getKey();
            if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
                size += computeFieldSize(descriptor, entry.getValue());
            } else {
                size += CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
            }
        }
        return size;
    }

    private static int computeElementSize(FieldType type, int number, Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type == FieldType.GROUP) {
            tagSize *= 2;
        }
        return computeElementSizeNoTag(type, value) + tagSize;
    }

    private static int computeElementSizeNoTag(FieldType type, Object value) {
        switch (type) {
            case DOUBLE:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
            case FLOAT:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
            case INT64:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
            case UINT64:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
            case INT32:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
            case FIXED64:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
            case FIXED32:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
            case BOOL:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
            case STRING:
                return CodedOutputStream.computeStringSizeNoTag((String) value);
            case BYTES:
                return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
            case UINT32:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
            case SFIXED32:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
            case SFIXED64:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
            case SINT32:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
            case SINT64:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
            case GROUP:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
            case MESSAGE:
                return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
            case ENUM:
                return CodedOutputStream.computeEnumSizeNoTag(((EnumLite) value).getNumber());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
        FieldType type = descriptor.getLiteType();
        int number = descriptor.getNumber();
        if (!descriptor.isRepeated()) {
            return computeElementSize(type, number, value);
        }
        if (descriptor.isPacked()) {
            int dataSize = 0;
            for (Object element : (List) value) {
                dataSize += computeElementSizeNoTag(type, element);
            }
            return (CodedOutputStream.computeTagSize(number) + dataSize) + CodedOutputStream.computeRawVarint32Size(dataSize);
        }
        int size = 0;
        for (Object element2 : (List) value) {
            size += computeElementSize(type, number, element2);
        }
        return size;
    }
}
