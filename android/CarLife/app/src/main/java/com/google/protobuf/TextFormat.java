package com.google.protobuf;

import com.baidu.mobstat.Config;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.MessageType;
import com.facebook.common.p262l.C5361b;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.ExtensionRegistry.ExtensionInfo;
import com.google.protobuf.Message.Builder;
import com.google.protobuf.UnknownFieldSet.Field;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextFormat {
    private static final int BUFFER_SIZE = 4096;

    static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String description) {
            super(description);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;

        public ParseException(String message) {
            super(message);
        }
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private Appendable output;

        private TextGenerator(Appendable output) {
            this.atStartOfLine = true;
            this.indent = new StringBuilder();
            this.output = output;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.delete(length - 2, length);
        }

        public void print(CharSequence text) throws IOException {
            int size = text.length();
            int pos = 0;
            for (int i = 0; i < size; i++) {
                if (text.charAt(i) == '\n') {
                    write(text.subSequence(pos, size), (i - pos) + 1);
                    pos = i + 1;
                    this.atStartOfLine = true;
                }
            }
            write(text.subSequence(pos, size), size - pos);
        }

        private void write(CharSequence data, int size) throws IOException {
            if (size != 0) {
                if (this.atStartOfLine) {
                    this.atStartOfLine = false;
                    this.output.append(this.indent);
                }
                this.output.append(data);
            }
        }
    }

    private static final class Tokenizer {
        private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
        private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
        private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);
        private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^\"\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
        private int column;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        private Tokenizer(CharSequence text) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = text;
            this.matcher = WHITESPACE.matcher(text);
            skipWhitespace();
            nextToken();
        }

        public boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = String.valueOf(this.text.charAt(this.pos));
                this.matcher.region(this.pos + 1, this.matcher.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
            }
        }

        public boolean tryConsume(String token) {
            if (!this.currentToken.equals(token)) {
                return false;
            }
            nextToken();
            return true;
        }

        public void consume(String token) throws ParseException {
            if (!tryConsume(token)) {
                throw parseException("Expected \"" + token + "\".");
            }
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char c = this.currentToken.charAt(0);
            if (('0' <= c && c <= '9') || c == '-' || c == '+') {
                return true;
            }
            return false;
        }

        public String consumeIdentifier() throws ParseException {
            for (int i = 0; i < this.currentToken.length(); i++) {
                char c = this.currentToken.charAt(i);
                if (('a' > c || c > 'z') && (('A' > c || c > 'Z') && !(('0' <= c && c <= '9') || c == '_' || c == '.'))) {
                    throw parseException("Expected identifier.");
                }
            }
            String result = this.currentToken;
            nextToken();
            return result;
        }

        public int consumeInt32() throws ParseException {
            try {
                int result = TextFormat.parseInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public int consumeUInt32() throws ParseException {
            try {
                int result = TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeInt64() throws ParseException {
            try {
                long result = TextFormat.parseInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public long consumeUInt64() throws ParseException {
            try {
                long result = TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return result;
            } catch (NumberFormatException e) {
                throw integerParseException(e);
            }
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            } else if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            } else {
                try {
                    double result = Double.parseDouble(this.currentToken);
                    nextToken();
                    return result;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean negative = this.currentToken.startsWith("-");
                nextToken();
                return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            } else if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            } else {
                try {
                    float result = Float.parseFloat(this.currentToken);
                    nextToken();
                    return result;
                } catch (NumberFormatException e) {
                    throw floatParseException(e);
                }
            }
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true")) {
                nextToken();
                return true;
            } else if (this.currentToken.equals("false")) {
                nextToken();
                return false;
            } else {
                throw parseException("Expected \"true\" or \"false\".");
            }
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public ByteString consumeByteString() throws ParseException {
            char quote = '\u0000';
            if (this.currentToken.length() > 0) {
                quote = this.currentToken.charAt(0);
            }
            if (quote != '\"' && quote != '\'') {
                throw parseException("Expected string.");
            } else if (this.currentToken.length() < 2 || this.currentToken.charAt(this.currentToken.length() - 1) != quote) {
                throw parseException("String missing ending quote.");
            } else {
                try {
                    ByteString result = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
                    nextToken();
                    return result;
                } catch (InvalidEscapeSequenceException e) {
                    throw parseException(e.getMessage());
                }
            }
        }

        public ParseException parseException(String description) {
            return new ParseException((this.line + 1) + Config.TRACE_TODAY_VISIT_SPLIT + (this.column + 1) + ": " + description);
        }

        public ParseException parseExceptionPreviousToken(String description) {
            return new ParseException((this.previousLine + 1) + Config.TRACE_TODAY_VISIT_SPLIT + (this.previousColumn + 1) + ": " + description);
        }

        private ParseException integerParseException(NumberFormatException e) {
            return parseException("Couldn't parse integer: " + e.getMessage());
        }

        private ParseException floatParseException(NumberFormatException e) {
            return parseException("Couldn't parse number: " + e.getMessage());
        }
    }

    private TextFormat() {
    }

    public static void print(Message message, Appendable output) throws IOException {
        print(message, new TextGenerator(output));
    }

    public static void print(UnknownFieldSet fields, Appendable output) throws IOException {
        printUnknownFields(fields, new TextGenerator(output));
    }

    public static String printToString(Message message) {
        try {
            Appendable text = new StringBuilder();
            print(message, text);
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", e);
        }
    }

    public static String printToString(UnknownFieldSet fields) {
        try {
            Appendable text = new StringBuilder();
            print(fields, text);
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", e);
        }
    }

    private static void print(Message message, TextGenerator generator) throws IOException {
        for (Entry<FieldDescriptor, Object> field : message.getAllFields().entrySet()) {
            printField((FieldDescriptor) field.getKey(), field.getValue(), generator);
        }
        printUnknownFields(message.getUnknownFields(), generator);
    }

    public static void printField(FieldDescriptor field, Object value, Appendable output) throws IOException {
        printField(field, value, new TextGenerator(output));
    }

    public static String printFieldToString(FieldDescriptor field, Object value) {
        try {
            Appendable text = new StringBuilder();
            printField(field, value, text);
            return text.toString();
        } catch (IOException e) {
            throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", e);
        }
    }

    private static void printField(FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
        if (field.isRepeated()) {
            for (Object element : (List) value) {
                printSingleField(field, element, generator);
            }
            return;
        }
        printSingleField(field, value, generator);
    }

    private static void printSingleField(FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
        if (field.isExtension()) {
            generator.print("[");
            if (field.getContainingType().getOptions().getMessageSetWireFormat() && field.getType() == Type.MESSAGE && field.isOptional() && field.getExtensionScope() == field.getMessageType()) {
                generator.print(field.getMessageType().getFullName());
            } else {
                generator.print(field.getFullName());
            }
            generator.print("]");
        } else if (field.getType() == Type.GROUP) {
            generator.print(field.getMessageType().getName());
        } else {
            generator.print(field.getName());
        }
        if (field.getJavaType() == JavaType.MESSAGE) {
            generator.print(" {\n");
            generator.indent();
        } else {
            generator.print(": ");
        }
        printFieldValue(field, value, generator);
        if (field.getJavaType() == JavaType.MESSAGE) {
            generator.outdent();
            generator.print("}");
        }
        generator.print("\n");
    }

    private static void printFieldValue(FieldDescriptor field, Object value, TextGenerator generator) throws IOException {
        switch (field.getType()) {
            case INT32:
            case INT64:
            case SINT32:
            case SINT64:
            case SFIXED32:
            case SFIXED64:
            case FLOAT:
            case DOUBLE:
            case BOOL:
                generator.print(value.toString());
                return;
            case UINT32:
            case FIXED32:
                generator.print(unsignedToString(((Integer) value).intValue()));
                return;
            case UINT64:
            case FIXED64:
                generator.print(unsignedToString(((Long) value).longValue()));
                return;
            case STRING:
                generator.print("\"");
                generator.print(escapeText((String) value));
                generator.print("\"");
                return;
            case BYTES:
                generator.print("\"");
                generator.print(escapeBytes((ByteString) value));
                generator.print("\"");
                return;
            case ENUM:
                generator.print(((EnumValueDescriptor) value).getName());
                return;
            case MESSAGE:
            case GROUP:
                print((Message) value, generator);
                return;
            default:
                return;
        }
    }

    private static void printUnknownFields(UnknownFieldSet unknownFields, TextGenerator generator) throws IOException {
        for (Entry<Integer, Field> entry : unknownFields.asMap().entrySet()) {
            String prefix = ((Integer) entry.getKey()).toString() + ": ";
            Field field = (Field) entry.getValue();
            for (Long longValue : field.getVarintList()) {
                long value = longValue.longValue();
                generator.print(((Integer) entry.getKey()).toString());
                generator.print(": ");
                generator.print(unsignedToString(value));
                generator.print("\n");
            }
            for (Integer intValue : field.getFixed32List()) {
                int value2 = intValue.intValue();
                generator.print(((Integer) entry.getKey()).toString());
                generator.print(": ");
                generator.print(String.format((Locale) null, "0x%08x", new Object[]{Integer.valueOf(value2)}));
                generator.print("\n");
            }
            for (Long longValue2 : field.getFixed64List()) {
                value = longValue2.longValue();
                generator.print(((Integer) entry.getKey()).toString());
                generator.print(": ");
                generator.print(String.format((Locale) null, "0x%016x", new Object[]{Long.valueOf(value)}));
                generator.print("\n");
            }
            for (ByteString value3 : field.getLengthDelimitedList()) {
                generator.print(((Integer) entry.getKey()).toString());
                generator.print(": \"");
                generator.print(escapeBytes(value3));
                generator.print("\"\n");
            }
            for (UnknownFieldSet value4 : field.getGroupList()) {
                generator.print(((Integer) entry.getKey()).toString());
                generator.print(" {\n");
                generator.indent();
                printUnknownFields(value4, generator);
                generator.outdent();
                generator.print("}\n");
            }
        }
    }

    private static String unsignedToString(int value) {
        if (value >= 0) {
            return Integer.toString(value);
        }
        return Long.toString(((long) value) & 4294967295L);
    }

    private static String unsignedToString(long value) {
        if (value >= 0) {
            return Long.toString(value);
        }
        return BigInteger.valueOf(C5361b.f21945a & value).setBit(63).toString();
    }

    public static void merge(Readable input, Builder builder) throws IOException {
        merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(CharSequence input, Builder builder) throws ParseException {
        merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
    }

    public static void merge(Readable input, ExtensionRegistry extensionRegistry, Builder builder) throws IOException {
        merge(toStringBuilder(input), extensionRegistry, builder);
    }

    private static StringBuilder toStringBuilder(Readable input) throws IOException {
        StringBuilder text = new StringBuilder();
        CharBuffer buffer = CharBuffer.allocate(4096);
        while (true) {
            int n = input.read(buffer);
            if (n == -1) {
                return text;
            }
            buffer.flip();
            text.append(buffer, 0, n);
        }
    }

    public static void merge(CharSequence input, ExtensionRegistry extensionRegistry, Builder builder) throws ParseException {
        Tokenizer tokenizer = new Tokenizer(input);
        while (!tokenizer.atEnd()) {
            mergeField(tokenizer, extensionRegistry, builder);
        }
    }

    private static void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, Builder builder) throws ParseException {
        FieldDescriptor field;
        Descriptor type = builder.getDescriptorForType();
        ExtensionInfo extension = null;
        if (tokenizer.tryConsume("[")) {
            StringBuilder name = new StringBuilder(tokenizer.consumeIdentifier());
            while (true) {
                if (!tokenizer.tryConsume(".")) {
                    break;
                }
                name.append('.');
                name.append(tokenizer.consumeIdentifier());
            }
            extension = extensionRegistry.findExtensionByName(name.toString());
            if (extension == null) {
                throw tokenizer.parseExceptionPreviousToken("Extension \"" + name + "\" not found in the ExtensionRegistry.");
            } else if (extension.descriptor.getContainingType() != type) {
                throw tokenizer.parseExceptionPreviousToken("Extension \"" + name + "\" does not extend message type \"" + type.getFullName() + "\".");
            } else {
                tokenizer.consume("]");
                field = extension.descriptor;
            }
        } else {
            String name2 = tokenizer.consumeIdentifier();
            field = type.findFieldByName(name2);
            if (field == null) {
                field = type.findFieldByName(name2.toLowerCase(Locale.US));
                if (!(field == null || field.getType() == Type.GROUP)) {
                    field = null;
                }
            }
            if (!(field == null || field.getType() != Type.GROUP || field.getMessageType().getName().equals(name2))) {
                field = null;
            }
            if (field == null) {
                throw tokenizer.parseExceptionPreviousToken("Message type \"" + type.getFullName() + "\" has no field named \"" + name2 + "\".");
            }
        }
        Object obj = null;
        if (field.getJavaType() != JavaType.MESSAGE) {
            tokenizer.consume(Config.TRACE_TODAY_VISIT_SPLIT);
            switch (field.getType()) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    obj = Integer.valueOf(tokenizer.consumeInt32());
                    break;
                case INT64:
                case SINT64:
                case SFIXED64:
                    obj = Long.valueOf(tokenizer.consumeInt64());
                    break;
                case FLOAT:
                    obj = Float.valueOf(tokenizer.consumeFloat());
                    break;
                case DOUBLE:
                    obj = Double.valueOf(tokenizer.consumeDouble());
                    break;
                case BOOL:
                    obj = Boolean.valueOf(tokenizer.consumeBoolean());
                    break;
                case UINT32:
                case FIXED32:
                    obj = Integer.valueOf(tokenizer.consumeUInt32());
                    break;
                case UINT64:
                case FIXED64:
                    obj = Long.valueOf(tokenizer.consumeUInt64());
                    break;
                case STRING:
                    obj = tokenizer.consumeString();
                    break;
                case BYTES:
                    obj = tokenizer.consumeByteString();
                    break;
                case ENUM:
                    EnumDescriptor enumType = field.getEnumType();
                    if (tokenizer.lookingAtInteger()) {
                        int number = tokenizer.consumeInt32();
                        obj = enumType.findValueByNumber(number);
                        if (obj == null) {
                            throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + number + '.');
                        }
                    }
                    String id = tokenizer.consumeIdentifier();
                    obj = enumType.findValueByName(id);
                    if (obj == null) {
                        throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value named \"" + id + "\".");
                    }
                    break;
                case MESSAGE:
                case GROUP:
                    throw new RuntimeException("Can't get here.");
                default:
                    break;
            }
        }
        String endToken;
        Builder subBuilder;
        tokenizer.tryConsume(Config.TRACE_TODAY_VISIT_SPLIT);
        if (tokenizer.tryConsume("<")) {
            endToken = ">";
        } else {
            tokenizer.consume("{");
            endToken = "}";
        }
        if (extension == null) {
            subBuilder = builder.newBuilderForField(field);
        } else {
            subBuilder = extension.defaultInstance.newBuilderForType();
        }
        while (!tokenizer.tryConsume(endToken)) {
            if (tokenizer.atEnd()) {
                throw tokenizer.parseException("Expected \"" + endToken + "\".");
            }
            mergeField(tokenizer, extensionRegistry, subBuilder);
        }
        obj = subBuilder.build();
        if (field.isRepeated()) {
            builder.addRepeatedField(field, obj);
        } else {
            builder.setField(field, obj);
        }
    }

    static String escapeBytes(ByteString input) {
        StringBuilder builder = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte b = input.byteAt(i);
            switch (b) {
                case (byte) 7:
                    builder.append("\\a");
                    break;
                case (byte) 8:
                    builder.append("\\b");
                    break;
                case (byte) 9:
                    builder.append("\\t");
                    break;
                case (byte) 10:
                    builder.append("\\n");
                    break;
                case (byte) 11:
                    builder.append("\\v");
                    break;
                case (byte) 12:
                    builder.append("\\f");
                    break;
                case (byte) 13:
                    builder.append("\\r");
                    break;
                case (byte) 34:
                    builder.append("\\\"");
                    break;
                case (byte) 39:
                    builder.append("\\'");
                    break;
                case (byte) 92:
                    builder.append("\\\\");
                    break;
                default:
                    if (b < (byte) 32) {
                        builder.append('\\');
                        builder.append((char) (((b >>> 6) & 3) + 48));
                        builder.append((char) (((b >>> 3) & 7) + 48));
                        builder.append((char) ((b & 7) + 48));
                        break;
                    }
                    builder.append((char) b);
                    break;
            }
        }
        return builder.toString();
    }

    static ByteString unescapeBytes(CharSequence input) throws InvalidEscapeSequenceException {
        byte[] result = new byte[input.length()];
        int pos = 0;
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            int pos2;
            if (c != '\\') {
                pos2 = pos + 1;
                result[pos] = (byte) c;
                pos = pos2;
            } else if (i + 1 < input.length()) {
                i++;
                c = input.charAt(i);
                int code;
                if (isOctal(c)) {
                    code = digitValue(c);
                    if (i + 1 < input.length() && isOctal(input.charAt(i + 1))) {
                        i++;
                        code = (code * 8) + digitValue(input.charAt(i));
                    }
                    if (i + 1 < input.length() && isOctal(input.charAt(i + 1))) {
                        i++;
                        code = (code * 8) + digitValue(input.charAt(i));
                    }
                    pos2 = pos + 1;
                    result[pos] = (byte) code;
                    pos = pos2;
                } else {
                    switch (c) {
                        case '\"':
                            pos2 = pos + 1;
                            result[pos] = (byte) 34;
                            pos = pos2;
                            break;
                        case '\'':
                            pos2 = pos + 1;
                            result[pos] = (byte) 39;
                            pos = pos2;
                            break;
                        case '\\':
                            pos2 = pos + 1;
                            result[pos] = (byte) 92;
                            pos = pos2;
                            break;
                        case 'a':
                            pos2 = pos + 1;
                            result[pos] = (byte) 7;
                            pos = pos2;
                            break;
                        case 'b':
                            pos2 = pos + 1;
                            result[pos] = (byte) 8;
                            pos = pos2;
                            break;
                        case 'f':
                            pos2 = pos + 1;
                            result[pos] = (byte) 12;
                            pos = pos2;
                            break;
                        case 'n':
                            pos2 = pos + 1;
                            result[pos] = (byte) 10;
                            pos = pos2;
                            break;
                        case 'r':
                            pos2 = pos + 1;
                            result[pos] = (byte) 13;
                            pos = pos2;
                            break;
                        case 't':
                            pos2 = pos + 1;
                            result[pos] = (byte) 9;
                            pos = pos2;
                            break;
                        case MessageType.BNMessageTypeTunnelUpdate /*118*/:
                            pos2 = pos + 1;
                            result[pos] = (byte) 11;
                            pos = pos2;
                            break;
                        case 'x':
                            if (i + 1 < input.length() && isHex(input.charAt(i + 1))) {
                                i++;
                                code = digitValue(input.charAt(i));
                                if (i + 1 < input.length() && isHex(input.charAt(i + 1))) {
                                    i++;
                                    code = (code * 16) + digitValue(input.charAt(i));
                                }
                                pos2 = pos + 1;
                                result[pos] = (byte) code;
                                pos = pos2;
                                break;
                            }
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            break;
                        default:
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + c + '\'');
                    }
                }
            } else {
                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
            }
            i++;
        }
        return ByteString.copyFrom(result, 0, pos);
    }

    static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    static String unescapeText(String input) throws InvalidEscapeSequenceException {
        return unescapeBytes(input).toStringUtf8();
    }

    private static boolean isOctal(char c) {
        return '0' <= c && c <= '7';
    }

    private static boolean isHex(char c) {
        return ('0' <= c && c <= '9') || (('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'));
    }

    private static int digitValue(char c) {
        if ('0' <= c && c <= '9') {
            return c - 48;
        }
        if ('a' > c || c > 'z') {
            return (c - 65) + 10;
        }
        return (c - 97) + 10;
    }

    static int parseInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, true, false);
    }

    static int parseUInt32(String text) throws NumberFormatException {
        return (int) parseInteger(text, false, false);
    }

    static long parseInt64(String text) throws NumberFormatException {
        return parseInteger(text, true, true);
    }

    static long parseUInt64(String text) throws NumberFormatException {
        return parseInteger(text, false, true);
    }

    private static long parseInteger(String text, boolean isSigned, boolean isLong) throws NumberFormatException {
        int pos = 0;
        boolean negative = false;
        if (text.startsWith("-", 0)) {
            if (isSigned) {
                pos = 0 + 1;
                negative = true;
            } else {
                throw new NumberFormatException("Number must be positive: " + text);
            }
        }
        int radix = 10;
        if (text.startsWith("0x", pos)) {
            pos += 2;
            radix = 16;
        } else if (text.startsWith("0", pos)) {
            radix = 8;
        }
        String numberText = text.substring(pos);
        if (numberText.length() < 16) {
            long result = Long.parseLong(numberText, radix);
            if (negative) {
                result = -result;
            }
            if (isLong) {
                return result;
            }
            if (isSigned) {
                if (result <= 2147483647L && result >= -2147483648L) {
                    return result;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
            } else if (result < 4294967296L && result >= 0) {
                return result;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
            }
        }
        BigInteger bigValue = new BigInteger(numberText, radix);
        if (negative) {
            bigValue = bigValue.negate();
        }
        if (isLong) {
            if (isSigned) {
                if (bigValue.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + text);
                }
            } else if (bigValue.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + text);
            }
        } else if (isSigned) {
            if (bigValue.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
            }
        } else if (bigValue.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
        }
        return bigValue.longValue();
    }
}
