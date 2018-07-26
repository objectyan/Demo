package com.google.protobuf;

import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumOptions;
import com.google.protobuf.DescriptorProtos.EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos.EnumValueOptions;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.DescriptorProtos.MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos.MethodOptions;
import com.google.protobuf.DescriptorProtos.ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos.ServiceOptions;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.MessageLite.Builder;
import com.google.protobuf.WireFormat.FieldType;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Descriptors {

    private interface GenericDescriptor {
        FileDescriptor getFile();

        String getFullName();

        String getName();

        Message toProto();
    }

    public static final class Descriptor implements GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private DescriptorProto proto;

        public int getIndex() {
            return this.index;
        }

        public DescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public String getFullName() {
            return this.fullName;
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public MessageOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public boolean isExtensionNumber(int number) {
            for (ExtensionRange range : this.proto.getExtensionRangeList()) {
                if (range.getStart() <= number && number < range.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        public FieldDescriptor findFieldByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result == null || !(result instanceof FieldDescriptor)) {
                return null;
            }
            return (FieldDescriptor) result;
        }

        public FieldDescriptor findFieldByNumber(int number) {
            return (FieldDescriptor) this.file.pool.fieldsByNumber.get(new DescriptorIntPair(this, number));
        }

        public Descriptor findNestedTypeByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result == null || !(result instanceof Descriptor)) {
                return null;
            }
            return (Descriptor) result;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result == null || !(result instanceof EnumDescriptor)) {
                return null;
            }
            return (EnumDescriptor) result;
        }

        private Descriptor(DescriptorProto proto, FileDescriptor file, Descriptor parent, int index) throws DescriptorValidationException {
            int i;
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            this.containingType = parent;
            this.nestedTypes = new Descriptor[proto.getNestedTypeCount()];
            for (i = 0; i < proto.getNestedTypeCount(); i++) {
                this.nestedTypes[i] = new Descriptor(proto.getNestedType(i), file, this, i);
            }
            this.enumTypes = new EnumDescriptor[proto.getEnumTypeCount()];
            for (i = 0; i < proto.getEnumTypeCount(); i++) {
                this.enumTypes[i] = new EnumDescriptor(proto.getEnumType(i), file, this, i);
            }
            this.fields = new FieldDescriptor[proto.getFieldCount()];
            for (i = 0; i < proto.getFieldCount(); i++) {
                this.fields[i] = new FieldDescriptor(proto.getField(i), file, this, i, false);
            }
            this.extensions = new FieldDescriptor[proto.getExtensionCount()];
            for (i = 0; i < proto.getExtensionCount(); i++) {
                this.extensions[i] = new FieldDescriptor(proto.getExtension(i), file, this, i, true);
            }
            file.pool.addSymbol(this);
        }

        private void crossLink() throws DescriptorValidationException {
            for (Descriptor nestedType : this.nestedTypes) {
                nestedType.crossLink();
            }
            for (FieldDescriptor field : this.fields) {
                field.crossLink();
            }
            for (FieldDescriptor extension : this.extensions) {
                extension.crossLink();
            }
        }

        private void setProto(DescriptorProto proto) {
            int i;
            this.proto = proto;
            for (i = 0; i < this.nestedTypes.length; i++) {
                this.nestedTypes[i].setProto(proto.getNestedType(i));
            }
            for (i = 0; i < this.enumTypes.length; i++) {
                this.enumTypes[i].setProto(proto.getEnumType(i));
            }
            for (i = 0; i < this.fields.length; i++) {
                this.fields[i].setProto(proto.getField(i));
            }
            for (i = 0; i < this.extensions.length; i++) {
                this.extensions[i].setProto(proto.getExtension(i));
            }
        }
    }

    private static final class DescriptorPool {
        static final /* synthetic */ boolean $assertionsDisabled = (!Descriptors.class.desiredAssertionStatus());
        private final DescriptorPool[] dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName = new HashMap();
        private final Map<DescriptorIntPair, EnumValueDescriptor> enumValuesByNumber = new HashMap();
        private final Map<DescriptorIntPair, FieldDescriptor> fieldsByNumber = new HashMap();

        private static final class DescriptorIntPair {
            private final GenericDescriptor descriptor;
            private final int number;

            DescriptorIntPair(GenericDescriptor descriptor, int number) {
                this.descriptor = descriptor;
                this.number = number;
            }

            public int hashCode() {
                return (this.descriptor.hashCode() * 65535) + this.number;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof DescriptorIntPair)) {
                    return false;
                }
                DescriptorIntPair other = (DescriptorIntPair) obj;
                if (this.descriptor == other.descriptor && this.number == other.number) {
                    return true;
                }
                return false;
            }
        }

        private static final class PackageDescriptor implements GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            public Message toProto() {
                return this.file.toProto();
            }

            public String getName() {
                return this.name;
            }

            public String getFullName() {
                return this.fullName;
            }

            public FileDescriptor getFile() {
                return this.file;
            }

            PackageDescriptor(String name, String fullName, FileDescriptor file) {
                this.file = file;
                this.fullName = fullName;
                this.name = name;
            }
        }

        DescriptorPool(FileDescriptor[] dependencies) {
            this.dependencies = new DescriptorPool[dependencies.length];
            for (int i = 0; i < dependencies.length; i++) {
                this.dependencies[i] = dependencies[i].pool;
            }
            for (FileDescriptor dependency : dependencies) {
                try {
                    addPackage(dependency.getPackage(), dependency);
                } catch (DescriptorValidationException e) {
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                }
            }
        }

        GenericDescriptor findSymbol(String fullName) {
            GenericDescriptor result = (GenericDescriptor) this.descriptorsByName.get(fullName);
            if (result != null) {
                return result;
            }
            for (DescriptorPool dependency : this.dependencies) {
                result = (GenericDescriptor) dependency.descriptorsByName.get(fullName);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        com.google.protobuf.Descriptors.GenericDescriptor lookupSymbol(java.lang.String r9, com.google.protobuf.Descriptors.GenericDescriptor r10) throws com.google.protobuf.Descriptors.DescriptorValidationException {
            /*
            r8 = this;
            r6 = -1;
            r5 = ".";
            r5 = r9.startsWith(r5);
            if (r5 == 0) goto L_0x0036;
        L_0x000a:
            r5 = 1;
            r5 = r9.substring(r5);
            r3 = r8.findSymbol(r5);
        L_0x0013:
            if (r3 != 0) goto L_0x0085;
        L_0x0015:
            r5 = new com.google.protobuf.Descriptors$DescriptorValidationException;
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = 34;
            r6 = r6.append(r7);
            r6 = r6.append(r9);
            r7 = "\" is not defined.";
            r6 = r6.append(r7);
            r6 = r6.toString();
            r7 = 0;
            r5.<init>(r10, r6);
            throw r5;
        L_0x0036:
            r5 = 46;
            r2 = r9.indexOf(r5);
            if (r2 != r6) goto L_0x0056;
        L_0x003e:
            r1 = r9;
        L_0x003f:
            r4 = new java.lang.StringBuilder;
            r5 = r10.getFullName();
            r4.<init>(r5);
        L_0x0048:
            r5 = ".";
            r0 = r4.lastIndexOf(r5);
            if (r0 != r6) goto L_0x005c;
        L_0x0051:
            r3 = r8.findSymbol(r9);
            goto L_0x0013;
        L_0x0056:
            r5 = 0;
            r1 = r9.substring(r5, r2);
            goto L_0x003f;
        L_0x005c:
            r5 = r0 + 1;
            r4.setLength(r5);
            r4.append(r1);
            r5 = r4.toString();
            r3 = r8.findSymbol(r5);
            if (r3 == 0) goto L_0x0081;
        L_0x006e:
            if (r2 == r6) goto L_0x0013;
        L_0x0070:
            r5 = r0 + 1;
            r4.setLength(r5);
            r4.append(r9);
            r5 = r4.toString();
            r3 = r8.findSymbol(r5);
            goto L_0x0013;
        L_0x0081:
            r4.setLength(r0);
            goto L_0x0048;
        L_0x0085:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Descriptors.DescriptorPool.lookupSymbol(java.lang.String, com.google.protobuf.Descriptors$GenericDescriptor):com.google.protobuf.Descriptors$GenericDescriptor");
        }

        void addSymbol(GenericDescriptor descriptor) throws DescriptorValidationException {
            validateSymbolName(descriptor);
            String fullName = descriptor.getFullName();
            int dotpos = fullName.lastIndexOf(46);
            GenericDescriptor old = (GenericDescriptor) this.descriptorsByName.put(fullName, descriptor);
            if (old != null) {
                this.descriptorsByName.put(fullName, old);
                if (descriptor.getFile() != old.getFile()) {
                    throw new DescriptorValidationException(descriptor, '\"' + fullName + "\" is already defined in file \"" + old.getFile().getName() + "\".");
                } else if (dotpos == -1) {
                    throw new DescriptorValidationException(descriptor, '\"' + fullName + "\" is already defined.");
                } else {
                    throw new DescriptorValidationException(descriptor, '\"' + fullName.substring(dotpos + 1) + "\" is already defined in \"" + fullName.substring(0, dotpos) + "\".");
                }
            }
        }

        void addPackage(String fullName, FileDescriptor file) throws DescriptorValidationException {
            String name;
            int dotpos = fullName.lastIndexOf(46);
            if (dotpos == -1) {
                name = fullName;
            } else {
                addPackage(fullName.substring(0, dotpos), file);
                name = fullName.substring(dotpos + 1);
            }
            GenericDescriptor old = (GenericDescriptor) this.descriptorsByName.put(fullName, new PackageDescriptor(name, fullName, file));
            if (old != null) {
                this.descriptorsByName.put(fullName, old);
                if (!(old instanceof PackageDescriptor)) {
                    throw new DescriptorValidationException(file, '\"' + name + "\" is already defined (as something other than a " + "package) in file \"" + old.getFile().getName() + "\".");
                }
            }
        }

        void addFieldByNumber(FieldDescriptor field) throws DescriptorValidationException {
            DescriptorIntPair key = new DescriptorIntPair(field.getContainingType(), field.getNumber());
            FieldDescriptor old = (FieldDescriptor) this.fieldsByNumber.put(key, field);
            if (old != null) {
                this.fieldsByNumber.put(key, old);
                throw new DescriptorValidationException((GenericDescriptor) field, "Field number " + field.getNumber() + "has already been used in \"" + field.getContainingType().getFullName() + "\" by field \"" + old.getName() + "\".");
            }
        }

        void addEnumValueByNumber(EnumValueDescriptor value) {
            DescriptorIntPair key = new DescriptorIntPair(value.getType(), value.getNumber());
            EnumValueDescriptor old = (EnumValueDescriptor) this.enumValuesByNumber.put(key, value);
            if (old != null) {
                this.enumValuesByNumber.put(key, old);
            }
        }

        static void validateSymbolName(GenericDescriptor descriptor) throws DescriptorValidationException {
            String name = descriptor.getName();
            if (name.length() == 0) {
                throw new DescriptorValidationException(descriptor, "Missing name.");
            }
            boolean valid = true;
            int i = 0;
            while (i < name.length()) {
                char c = name.charAt(i);
                if (c >= '') {
                    valid = false;
                }
                if (!(Character.isLetter(c) || c == '_' || (Character.isDigit(c) && i > 0))) {
                    valid = false;
                }
                i++;
            }
            if (!valid) {
                throw new DescriptorValidationException(descriptor, '\"' + name + "\" is not a valid identifier.");
            }
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        public String getProblemSymbolName() {
            return this.name;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getDescription() {
            return this.description;
        }

        private DescriptorValidationException(GenericDescriptor problemDescriptor, String description) {
            this(problemDescriptor, description, null);
        }

        private DescriptorValidationException(GenericDescriptor problemDescriptor, String description, Throwable cause) {
            super(problemDescriptor.getFullName() + ": " + description, cause);
            this.name = problemDescriptor.getFullName();
            this.proto = problemDescriptor.toProto();
            this.description = description;
        }

        private DescriptorValidationException(FileDescriptor problemDescriptor, String description) {
            super(problemDescriptor.getName() + ": " + description);
            this.name = problemDescriptor.getName();
            this.proto = problemDescriptor.toProto();
            this.description = description;
        }
    }

    public static final class EnumDescriptor implements GenericDescriptor, EnumLiteMap<EnumValueDescriptor> {
        private final Descriptor containingType;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private EnumDescriptorProto proto;
        private EnumValueDescriptor[] values;

        public int getIndex() {
            return this.index;
        }

        public EnumDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public String getFullName() {
            return this.fullName;
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public EnumOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        public EnumValueDescriptor findValueByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result == null || !(result instanceof EnumValueDescriptor)) {
                return null;
            }
            return (EnumValueDescriptor) result;
        }

        public EnumValueDescriptor findValueByNumber(int number) {
            return (EnumValueDescriptor) this.file.pool.enumValuesByNumber.get(new DescriptorIntPair(this, number));
        }

        private EnumDescriptor(EnumDescriptorProto proto, FileDescriptor file, Descriptor parent, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            this.containingType = parent;
            if (proto.getValueCount() == 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Enums must contain at least one value.");
            }
            this.values = new EnumValueDescriptor[proto.getValueCount()];
            for (int i = 0; i < proto.getValueCount(); i++) {
                this.values[i] = new EnumValueDescriptor(proto.getValue(i), file, this, i);
            }
            file.pool.addSymbol(this);
        }

        private void setProto(EnumDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.values.length; i++) {
                this.values[i].setProto(proto.getValue(i));
            }
        }
    }

    public static final class EnumValueDescriptor implements GenericDescriptor, EnumLite {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        public int getIndex() {
            return this.index;
        }

        public EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public int getNumber() {
            return this.proto.getNumber();
        }

        public String getFullName() {
            return this.fullName;
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        public EnumValueOptions getOptions() {
            return this.proto.getOptions();
        }

        private EnumValueDescriptor(EnumValueDescriptorProto proto, FileDescriptor file, EnumDescriptor parent, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.file = file;
            this.type = parent;
            this.fullName = parent.getFullName() + '.' + proto.getName();
            file.pool.addSymbol(this);
            file.pool.addEnumValueByNumber(this);
        }

        private void setProto(EnumValueDescriptorProto proto) {
            this.proto = proto;
        }
    }

    public static final class FieldDescriptor implements GenericDescriptor, FieldDescriptorLite<FieldDescriptor>, Comparable<FieldDescriptor> {
        private static final FieldType[] table = FieldType.values();
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor messageType;
        private FieldDescriptorProto proto;
        private Type type;

        public enum JavaType {
            INT(Integer.valueOf(0)),
            LONG(Long.valueOf(0)),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(Boolean.valueOf(false)),
            STRING(""),
            BYTE_STRING(ByteString.EMPTY),
            ENUM(null),
            MESSAGE(null);
            
            private final Object defaultDefault;

            private JavaType(Object defaultDefault) {
                this.defaultDefault = defaultDefault;
            }
        }

        public enum Type {
            DOUBLE(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE, JavaType.DOUBLE),
            FLOAT(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_FLOAT, JavaType.FLOAT),
            INT64(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, JavaType.LONG),
            UINT64(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_UINT64, JavaType.LONG),
            INT32(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, JavaType.INT),
            FIXED64(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_FIXED64, JavaType.LONG),
            FIXED32(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_FIXED32, JavaType.INT),
            BOOL(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, JavaType.BOOLEAN),
            STRING(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING, JavaType.STRING),
            GROUP(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP, JavaType.MESSAGE),
            MESSAGE(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_MESSAGE, JavaType.MESSAGE),
            BYTES(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_BYTES, JavaType.BYTE_STRING),
            UINT32(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_UINT32, JavaType.INT),
            ENUM(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, JavaType.ENUM),
            SFIXED32(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SFIXED32, JavaType.INT),
            SFIXED64(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SFIXED64, JavaType.LONG),
            SINT32(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, JavaType.INT),
            SINT64(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT64, JavaType.LONG);
            
            private JavaType javaType;
            private com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type proto;

            private Type(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type proto, JavaType javaType) {
                this.proto = proto;
                this.javaType = javaType;
                if (ordinal() != proto.getNumber() - 1) {
                    throw new RuntimeException("descriptor.proto changed but Desrciptors.java wasn't updated.");
                }
            }

            public com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return this.proto;
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public static Type valueOf(com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type type) {
                return values()[type.getNumber() - 1];
            }
        }

        public int getIndex() {
            return this.index;
        }

        public FieldDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public int getNumber() {
            return this.proto.getNumber();
        }

        public String getFullName() {
            return this.fullName;
        }

        public JavaType getJavaType() {
            return this.type.getJavaType();
        }

        public com.google.protobuf.WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public Type getType() {
            return this.type;
        }

        public FieldType getLiteType() {
            return table[this.type.ordinal()];
        }

        static {
            if (Type.values().length != com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
            }
        }

        public boolean isRequired() {
            return this.proto.getLabel() == Label.LABEL_REQUIRED;
        }

        public boolean isOptional() {
            return this.proto.getLabel() == Label.LABEL_OPTIONAL;
        }

        public boolean isRepeated() {
            return this.proto.getLabel() == Label.LABEL_REPEATED;
        }

        public boolean isPacked() {
            return getOptions().getPacked();
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        public Object getDefaultValue() {
            if (getJavaType() != JavaType.MESSAGE) {
                return this.defaultValue;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public FieldOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public Descriptor getExtensionScope() {
            if (isExtension()) {
                return this.extensionScope;
            }
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        public Descriptor getMessageType() {
            if (getJavaType() == JavaType.MESSAGE) {
                return this.messageType;
            }
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        public EnumDescriptor getEnumType() {
            if (getJavaType() == JavaType.ENUM) {
                return this.enumType;
            }
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        public int compareTo(FieldDescriptor other) {
            if (other.containingType == this.containingType) {
                return getNumber() - other.getNumber();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        private FieldDescriptor(FieldDescriptorProto proto, FileDescriptor file, Descriptor parent, int index, boolean isExtension) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            if (proto.hasType()) {
                this.type = Type.valueOf(proto.getType());
            }
            if (getNumber() <= 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field numbers must be positive integers.");
            } else if (proto.getOptions().getPacked() && (proto.getLabel() != Label.LABEL_REPEATED || proto.getType() == com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING || proto.getType() == com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_GROUP || proto.getType() == com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_MESSAGE || proto.getType() == com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.TYPE_BYTES)) {
                throw new DescriptorValidationException((GenericDescriptor) this, "[packed = true] can only be specified for repeated primitive fields.");
            } else {
                if (isExtension) {
                    if (proto.hasExtendee()) {
                        this.containingType = null;
                        if (parent != null) {
                            this.extensionScope = parent;
                        } else {
                            this.extensionScope = null;
                        }
                    } else {
                        throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee not set for extension field.");
                    }
                } else if (proto.hasExtendee()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee set for non-extension field.");
                } else {
                    this.containingType = parent;
                    this.extensionScope = null;
                }
                file.pool.addSymbol(this);
            }
        }

        private void crossLink() throws DescriptorValidationException {
            if (this.proto.hasExtendee()) {
                GenericDescriptor extendee = this.file.pool.lookupSymbol(this.proto.getExtendee(), this);
                if (extendee instanceof Descriptor) {
                    this.containingType = (Descriptor) extendee;
                    if (!getContainingType().isExtensionNumber(getNumber())) {
                        throw new DescriptorValidationException((GenericDescriptor) this, '\"' + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.");
                    }
                }
                throw new DescriptorValidationException((GenericDescriptor) this, '\"' + this.proto.getExtendee() + "\" is not a message type.");
            }
            if (this.proto.hasTypeName()) {
                GenericDescriptor typeDescriptor = this.file.pool.lookupSymbol(this.proto.getTypeName(), this);
                if (!this.proto.hasType()) {
                    if (typeDescriptor instanceof Descriptor) {
                        this.type = Type.MESSAGE;
                    } else if (typeDescriptor instanceof EnumDescriptor) {
                        this.type = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException((GenericDescriptor) this, '\"' + this.proto.getTypeName() + "\" is not a type.");
                    }
                }
                if (getJavaType() == JavaType.MESSAGE) {
                    if (typeDescriptor instanceof Descriptor) {
                        this.messageType = (Descriptor) typeDescriptor;
                        if (this.proto.hasDefaultValue()) {
                            throw new DescriptorValidationException((GenericDescriptor) this, "Messages can't have default values.");
                        }
                    }
                    throw new DescriptorValidationException((GenericDescriptor) this, '\"' + this.proto.getTypeName() + "\" is not a message type.");
                } else if (getJavaType() != JavaType.ENUM) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "Field with primitive type has type_name.");
                } else if (typeDescriptor instanceof EnumDescriptor) {
                    this.enumType = (EnumDescriptor) typeDescriptor;
                } else {
                    throw new DescriptorValidationException((GenericDescriptor) this, '\"' + this.proto.getTypeName() + "\" is not an enum type.");
                }
            } else if (getJavaType() == JavaType.MESSAGE || getJavaType() == JavaType.ENUM) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field with message or enum type missing type_name.");
            }
            if (!this.proto.hasDefaultValue()) {
                if (!isRepeated()) {
                    switch (getJavaType()) {
                        case ENUM:
                            this.defaultValue = this.enumType.getValues().get(0);
                            break;
                        case MESSAGE:
                            this.defaultValue = null;
                            break;
                        default:
                            this.defaultValue = getJavaType().defaultDefault;
                            break;
                    }
                }
                this.defaultValue = Collections.emptyList();
            } else if (isRepeated()) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Repeated fields cannot have default values.");
            } else {
                try {
                    switch (getType()) {
                        case INT32:
                        case SINT32:
                        case SFIXED32:
                            this.defaultValue = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));
                            break;
                        case UINT32:
                        case FIXED32:
                            this.defaultValue = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));
                            break;
                        case INT64:
                        case SINT64:
                        case SFIXED64:
                            this.defaultValue = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));
                            break;
                        case UINT64:
                        case FIXED64:
                            this.defaultValue = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));
                            break;
                        case FLOAT:
                            this.defaultValue = Float.valueOf(this.proto.getDefaultValue());
                            break;
                        case DOUBLE:
                            this.defaultValue = Double.valueOf(this.proto.getDefaultValue());
                            break;
                        case BOOL:
                            this.defaultValue = Boolean.valueOf(this.proto.getDefaultValue());
                            break;
                        case STRING:
                            this.defaultValue = this.proto.getDefaultValue();
                            break;
                        case BYTES:
                            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());
                            break;
                        case ENUM:
                            this.defaultValue = this.enumType.findValueByName(this.proto.getDefaultValue());
                            if (this.defaultValue == null) {
                                throw new DescriptorValidationException((GenericDescriptor) this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + '\"');
                            }
                            break;
                        case MESSAGE:
                        case GROUP:
                            throw new DescriptorValidationException((GenericDescriptor) this, "Message type had default value.");
                    }
                } catch (InvalidEscapeSequenceException e) {
                    throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e);
                } catch (NumberFormatException e2) {
                    DescriptorValidationException validationException = new DescriptorValidationException((GenericDescriptor) this, "Could not parse default value: \"" + this.proto.getDefaultValue() + '\"');
                    validationException.initCause(e2);
                    throw validationException;
                }
            }
            if (!isExtension()) {
                this.file.pool.addFieldByNumber(this);
            }
            if (this.containingType != null && this.containingType.getOptions().getMessageSetWireFormat()) {
                if (!isExtension()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "MessageSets cannot have fields, only extensions.");
                } else if (!isOptional() || getType() != Type.MESSAGE) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "Extensions of MessageSets must be optional messages.");
                }
            }
        }

        private void setProto(FieldDescriptorProto proto) {
            this.proto = proto;
        }

        public Builder internalMergeFrom(Builder to, MessageLite from) {
            return ((Message.Builder) to).mergeFrom((Message) from);
        }
    }

    public static final class FileDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final Descriptor[] messageTypes;
        private final DescriptorPool pool;
        private FileDescriptorProto proto;
        private final ServiceDescriptor[] services;

        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor fileDescriptor);
        }

        public FileDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        public FileOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public Descriptor findMessageTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = getPackage() + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            return (result != null && (result instanceof Descriptor) && result.getFile() == this) ? (Descriptor) result : null;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = getPackage() + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            return (result != null && (result instanceof EnumDescriptor) && result.getFile() == this) ? (EnumDescriptor) result : null;
        }

        public ServiceDescriptor findServiceByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = getPackage() + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            return (result != null && (result instanceof ServiceDescriptor) && result.getFile() == this) ? (ServiceDescriptor) result : null;
        }

        public FieldDescriptor findExtensionByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = getPackage() + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            return (result != null && (result instanceof FieldDescriptor) && result.getFile() == this) ? (FieldDescriptor) result : null;
        }

        public static FileDescriptor buildFrom(FileDescriptorProto proto, FileDescriptor[] dependencies) throws DescriptorValidationException {
            FileDescriptor result = new FileDescriptor(proto, dependencies, new DescriptorPool(dependencies));
            if (dependencies.length != proto.getDependencyCount()) {
                throw new DescriptorValidationException(result, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.");
            }
            int i = 0;
            while (i < proto.getDependencyCount()) {
                if (dependencies[i].getName().equals(proto.getDependency(i))) {
                    i++;
                } else {
                    throw new DescriptorValidationException(result, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.");
                }
            }
            result.crossLink();
            return result;
        }

        public static void internalBuildGeneratedFileFrom(String[] descriptorDataParts, FileDescriptor[] dependencies, InternalDescriptorAssigner descriptorAssigner) {
            StringBuilder descriptorData = new StringBuilder();
            for (String part : descriptorDataParts) {
                descriptorData.append(part);
            }
            try {
                byte[] descriptorBytes = descriptorData.toString().getBytes("ISO-8859-1");
                try {
                    FileDescriptorProto proto = FileDescriptorProto.parseFrom(descriptorBytes);
                    try {
                        FileDescriptor result = buildFrom(proto, dependencies);
                        ExtensionRegistryLite registry = descriptorAssigner.assignDescriptors(result);
                        if (registry != null) {
                            try {
                                result.setProto(FileDescriptorProto.parseFrom(descriptorBytes, registry));
                            } catch (InvalidProtocolBufferException e) {
                                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
                            }
                        }
                    } catch (DescriptorValidationException e2) {
                        throw new IllegalArgumentException("Invalid embedded descriptor for \"" + proto.getName() + "\".", e2);
                    }
                } catch (InvalidProtocolBufferException e3) {
                    throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
                }
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", e4);
            }
        }

        private FileDescriptor(FileDescriptorProto proto, FileDescriptor[] dependencies, DescriptorPool pool) throws DescriptorValidationException {
            int i;
            this.pool = pool;
            this.proto = proto;
            this.dependencies = (FileDescriptor[]) dependencies.clone();
            pool.addPackage(getPackage(), this);
            this.messageTypes = new Descriptor[proto.getMessageTypeCount()];
            for (i = 0; i < proto.getMessageTypeCount(); i++) {
                this.messageTypes[i] = new Descriptor(proto.getMessageType(i), this, null, i);
            }
            this.enumTypes = new EnumDescriptor[proto.getEnumTypeCount()];
            for (i = 0; i < proto.getEnumTypeCount(); i++) {
                this.enumTypes[i] = new EnumDescriptor(proto.getEnumType(i), this, null, i);
            }
            this.services = new ServiceDescriptor[proto.getServiceCount()];
            for (i = 0; i < proto.getServiceCount(); i++) {
                this.services[i] = new ServiceDescriptor(proto.getService(i), this, i);
            }
            this.extensions = new FieldDescriptor[proto.getExtensionCount()];
            for (i = 0; i < proto.getExtensionCount(); i++) {
                this.extensions[i] = new FieldDescriptor(proto.getExtension(i), this, null, i, true);
            }
        }

        private void crossLink() throws DescriptorValidationException {
            for (Descriptor messageType : this.messageTypes) {
                messageType.crossLink();
            }
            for (ServiceDescriptor service : this.services) {
                service.crossLink();
            }
            for (FieldDescriptor extension : this.extensions) {
                extension.crossLink();
            }
        }

        private void setProto(FileDescriptorProto proto) {
            int i;
            this.proto = proto;
            for (i = 0; i < this.messageTypes.length; i++) {
                this.messageTypes[i].setProto(proto.getMessageType(i));
            }
            for (i = 0; i < this.enumTypes.length; i++) {
                this.enumTypes[i].setProto(proto.getEnumType(i));
            }
            for (i = 0; i < this.services.length; i++) {
                this.services[i].setProto(proto.getService(i));
            }
            for (i = 0; i < this.extensions.length; i++) {
                this.extensions[i].setProto(proto.getExtension(i));
            }
        }
    }

    public static final class MethodDescriptor implements GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private Descriptor outputType;
        private MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        public int getIndex() {
            return this.index;
        }

        public MethodDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public String getFullName() {
            return this.fullName;
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public MethodOptions getOptions() {
            return this.proto.getOptions();
        }

        private MethodDescriptor(MethodDescriptorProto proto, FileDescriptor file, ServiceDescriptor parent, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.file = file;
            this.service = parent;
            this.fullName = parent.getFullName() + '.' + proto.getName();
            file.pool.addSymbol(this);
        }

        private void crossLink() throws DescriptorValidationException {
            GenericDescriptor input = this.file.pool.lookupSymbol(this.proto.getInputType(), this);
            if (input instanceof Descriptor) {
                this.inputType = (Descriptor) input;
                GenericDescriptor output = this.file.pool.lookupSymbol(this.proto.getOutputType(), this);
                if (output instanceof Descriptor) {
                    this.outputType = (Descriptor) output;
                    return;
                }
                throw new DescriptorValidationException((GenericDescriptor) this, '\"' + this.proto.getOutputType() + "\" is not a message type.");
            }
            throw new DescriptorValidationException((GenericDescriptor) this, '\"' + this.proto.getInputType() + "\" is not a message type.");
        }

        private void setProto(MethodDescriptorProto proto) {
            this.proto = proto;
        }
    }

    public static final class ServiceDescriptor implements GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private ServiceDescriptorProto proto;

        public int getIndex() {
            return this.index;
        }

        public ServiceDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public String getFullName() {
            return this.fullName;
        }

        public FileDescriptor getFile() {
            return this.file;
        }

        public ServiceOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        public MethodDescriptor findMethodByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(this.fullName + '.' + name);
            if (result == null || !(result instanceof MethodDescriptor)) {
                return null;
            }
            return (MethodDescriptor) result;
        }

        private ServiceDescriptor(ServiceDescriptorProto proto, FileDescriptor file, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, null, proto.getName());
            this.file = file;
            this.methods = new MethodDescriptor[proto.getMethodCount()];
            for (int i = 0; i < proto.getMethodCount(); i++) {
                this.methods[i] = new MethodDescriptor(proto.getMethod(i), file, this, i);
            }
            file.pool.addSymbol(this);
        }

        private void crossLink() throws DescriptorValidationException {
            for (MethodDescriptor method : this.methods) {
                method.crossLink();
            }
        }

        private void setProto(ServiceDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.methods.length; i++) {
                this.methods[i].setProto(proto.getMethod(i));
            }
        }
    }

    private static String computeFullName(FileDescriptor file, Descriptor parent, String name) {
        if (parent != null) {
            return parent.getFullName() + '.' + name;
        }
        if (file.getPackage().length() > 0) {
            return file.getPackage() + '.' + name;
        }
        return name;
    }
}
