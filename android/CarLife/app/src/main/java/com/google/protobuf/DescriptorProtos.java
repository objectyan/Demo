package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DescriptorProtos
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_DescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FieldDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FieldOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorSet_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_FileOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_MessageOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MessageOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_MethodDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_MethodOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_ServiceOptions_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_ServiceOptions_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable;
  private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        DescriptorProtos.access$19702(paramAnonymousFileDescriptor);
        DescriptorProtos.access$002((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(0));
        DescriptorProtos.access$102(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor, new String[] { "File" }, DescriptorProtos.FileDescriptorSet.class, DescriptorProtos.FileDescriptorSet.Builder.class));
        DescriptorProtos.access$602((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(1));
        DescriptorProtos.access$702(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor, new String[] { "Name", "Package", "Dependency", "MessageType", "EnumType", "Service", "Extension", "Options" }, DescriptorProtos.FileDescriptorProto.class, DescriptorProtos.FileDescriptorProto.Builder.class));
        DescriptorProtos.access$2202((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(2));
        DescriptorProtos.access$2302(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor, new String[] { "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options" }, DescriptorProtos.DescriptorProto.class, DescriptorProtos.DescriptorProto.Builder.class));
        DescriptorProtos.access$2402((Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor.getNestedTypes().get(0));
        DescriptorProtos.access$2502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor, new String[] { "Start", "End" }, DescriptorProtos.DescriptorProto.ExtensionRange.class, DescriptorProtos.DescriptorProto.ExtensionRange.Builder.class));
        DescriptorProtos.access$4502((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(3));
        DescriptorProtos.access$4602(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor, new String[] { "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options" }, DescriptorProtos.FieldDescriptorProto.class, DescriptorProtos.FieldDescriptorProto.Builder.class));
        DescriptorProtos.access$6602((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(4));
        DescriptorProtos.access$6702(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor, new String[] { "Name", "Value", "Options" }, DescriptorProtos.EnumDescriptorProto.class, DescriptorProtos.EnumDescriptorProto.Builder.class));
        DescriptorProtos.access$7602((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(5));
        DescriptorProtos.access$7702(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor, new String[] { "Name", "Number", "Options" }, DescriptorProtos.EnumValueDescriptorProto.class, DescriptorProtos.EnumValueDescriptorProto.Builder.class));
        DescriptorProtos.access$8702((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(6));
        DescriptorProtos.access$8802(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor, new String[] { "Name", "Method", "Options" }, DescriptorProtos.ServiceDescriptorProto.class, DescriptorProtos.ServiceDescriptorProto.Builder.class));
        DescriptorProtos.access$9702((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(7));
        DescriptorProtos.access$9802(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor, new String[] { "Name", "InputType", "OutputType", "Options" }, DescriptorProtos.MethodDescriptorProto.class, DescriptorProtos.MethodDescriptorProto.Builder.class));
        DescriptorProtos.access$11002((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(8));
        DescriptorProtos.access$11102(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor, new String[] { "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "OptimizeFor", "UninterpretedOption" }, DescriptorProtos.FileOptions.class, DescriptorProtos.FileOptions.Builder.class));
        DescriptorProtos.access$12402((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(9));
        DescriptorProtos.access$12502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor, new String[] { "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption" }, DescriptorProtos.MessageOptions.class, DescriptorProtos.MessageOptions.Builder.class));
        DescriptorProtos.access$13402((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(10));
        DescriptorProtos.access$13502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor, new String[] { "Ctype", "Packed", "Deprecated", "ExperimentalMapKey", "UninterpretedOption" }, DescriptorProtos.FieldOptions.class, DescriptorProtos.FieldOptions.Builder.class));
        DescriptorProtos.access$14802((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(11));
        DescriptorProtos.access$14902(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor, new String[] { "UninterpretedOption" }, DescriptorProtos.EnumOptions.class, DescriptorProtos.EnumOptions.Builder.class));
        DescriptorProtos.access$15402((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(12));
        DescriptorProtos.access$15502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor, new String[] { "UninterpretedOption" }, DescriptorProtos.EnumValueOptions.class, DescriptorProtos.EnumValueOptions.Builder.class));
        DescriptorProtos.access$16002((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(13));
        DescriptorProtos.access$16102(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor, new String[] { "UninterpretedOption" }, DescriptorProtos.ServiceOptions.class, DescriptorProtos.ServiceOptions.Builder.class));
        DescriptorProtos.access$16602((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(14));
        DescriptorProtos.access$16702(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor, new String[] { "UninterpretedOption" }, DescriptorProtos.MethodOptions.class, DescriptorProtos.MethodOptions.Builder.class));
        DescriptorProtos.access$17202((Descriptors.Descriptor)DescriptorProtos.getDescriptor().getMessageTypes().get(15));
        DescriptorProtos.access$17302(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor, new String[] { "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue" }, DescriptorProtos.UninterpretedOption.class, DescriptorProtos.UninterpretedOption.Builder.class));
        DescriptorProtos.access$17402((Descriptors.Descriptor)DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor.getNestedTypes().get(0));
        DescriptorProtos.access$17502(new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor, new String[] { "NamePart", "IsExtension" }, DescriptorProtos.UninterpretedOption.NamePart.class, DescriptorProtos.UninterpretedOption.NamePart.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n google/protobuf/descriptor.proto\022\017google.protobuf\"G\n\021FileDescriptorSet\0222\n\004file\030\001 \003(\0132$.google.protobuf.FileDescriptorProto\"Ü\002\n\023FileDescriptorProto\022\f\n\004name\030\001 \001(\t\022\017\n\007package\030\002 \001(\t\022\022\n\ndependency\030\003 \003(\t\0226\n\fmessage_type\030\004 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\005 \003(\0132$.google.protobuf.EnumDescriptorProto\0228\n\007service\030\006 \003(\0132'.google.protobuf.ServiceDescriptorProto\0228\n\textension\030\007 \003(\0132%.google.p", "rotobuf.FieldDescriptorProto\022-\n\007options\030\b \001(\0132\034.google.protobuf.FileOptions\"©\003\n\017DescriptorProto\022\f\n\004name\030\001 \001(\t\0224\n\005field\030\002 \003(\0132%.google.protobuf.FieldDescriptorProto\0228\n\textension\030\006 \003(\0132%.google.protobuf.FieldDescriptorProto\0225\n\013nested_type\030\003 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\004 \003(\0132$.google.protobuf.EnumDescriptorProto\022H\n\017extension_range\030\005 \003(\0132/.google.protobuf.DescriptorProto.Extensi", "onRange\0220\n\007options\030\007 \001(\0132\037.google.protobuf.MessageOptions\032,\n\016ExtensionRange\022\r\n\005start\030\001 \001(\005\022\013\n\003end\030\002 \001(\005\"\005\n\024FieldDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\003 \001(\005\022:\n\005label\030\004 \001(\0162+.google.protobuf.FieldDescriptorProto.Label\0228\n\004type\030\005 \001(\0162*.google.protobuf.FieldDescriptorProto.Type\022\021\n\ttype_name\030\006 \001(\t\022\020\n\bextendee\030\002 \001(\t\022\025\n\rdefault_value\030\007 \001(\t\022.\n\007options\030\b \001(\0132\035.google.protobuf.FieldOptions\"¶\002\n\004Type\022\017\n\013TYP", "E_DOUBLE\020\001\022\016\n\nTYPE_FLOAT\020\002\022\016\n\nTYPE_INT64\020\003\022\017\n\013TYPE_UINT64\020\004\022\016\n\nTYPE_INT32\020\005\022\020\n\fTYPE_FIXED64\020\006\022\020\n\fTYPE_FIXED32\020\007\022\r\n\tTYPE_BOOL\020\b\022\017\n\013TYPE_STRING\020\t\022\016\n\nTYPE_GROUP\020\n\022\020\n\fTYPE_MESSAGE\020\013\022\016\n\nTYPE_BYTES\020\f\022\017\n\013TYPE_UINT32\020\r\022\r\n\tTYPE_ENUM\020\016\022\021\n\rTYPE_SFIXED32\020\017\022\021\n\rTYPE_SFIXED64\020\020\022\017\n\013TYPE_SINT32\020\021\022\017\n\013TYPE_SINT64\020\022\"C\n\005Label\022\022\n\016LABEL_OPTIONAL\020\001\022\022\n\016LABEL_REQUIRED\020\002\022\022\n\016LABEL_REPEATED\020\003\"\001\n\023EnumDescriptorProto\022\f\n\004name\030\001", " \001(\t\0228\n\005value\030\002 \003(\0132).google.protobuf.EnumValueDescriptorProto\022-\n\007options\030\003 \001(\0132\034.google.protobuf.EnumOptions\"l\n\030EnumValueDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\002 \001(\005\0222\n\007options\030\003 \001(\0132!.google.protobuf.EnumValueOptions\"\001\n\026ServiceDescriptorProto\022\f\n\004name\030\001 \001(\t\0226\n\006method\030\002 \003(\0132&.google.protobuf.MethodDescriptorProto\0220\n\007options\030\003 \001(\0132\037.google.protobuf.ServiceOptions\"\n\025MethodDescriptorProto\022\f\n\004name\030", "\001 \001(\t\022\022\n\ninput_type\030\002 \001(\t\022\023\n\013output_type\030\003 \001(\t\022/\n\007options\030\004 \001(\0132\036.google.protobuf.MethodOptions\"¹\002\n\013FileOptions\022\024\n\fjava_package\030\001 \001(\t\022\034\n\024java_outer_classname\030\b \001(\t\022\"\n\023java_multiple_files\030\n \001(\b:\005false\022F\n\foptimize_for\030\t \001(\0162).google.protobuf.FileOptions.OptimizeMode:\005SPEED\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\022\t\n\005SPEED\020\001\022\r\n\tCODE_SIZE\020\002\022\020\n\fLITE_RUNTIME\020\003", "*\t\bè\007\020\002\"¸\001\n\016MessageOptions\022&\n\027message_set_wire_format\030\001 \001(\b:\005false\022.\n\037no_standard_descriptor_accessor\030\002 \001(\b:\005false\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"\002\n\fFieldOptions\0222\n\005ctype\030\001 \001(\0162#.google.protobuf.FieldOptions.CType\022\016\n\006packed\030\002 \001(\b\022\031\n\ndeprecated\030\003 \001(\b:\005false\022\034\n\024experimental_map_key\030\t \001(\t\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.Uninterpre", "tedOption\"#\n\005CType\022\b\n\004CORD\020\001\022\020\n\fSTRING_PIECE\020\002*\t\bè\007\020\002\"]\n\013EnumOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"b\n\020EnumValueOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"`\n\016ServiceOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"_\n\rMethodOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$", ".google.protobuf.UninterpretedOption*\t\bè\007\020\002\"\002\n\023UninterpretedOption\022;\n\004name\030\002 \003(\0132-.google.protobuf.UninterpretedOption.NamePart\022\030\n\020identifier_value\030\003 \001(\t\022\032\n\022positive_int_value\030\004 \001(\004\022\032\n\022negative_int_value\030\005 \001(\003\022\024\n\fdouble_value\030\006 \001(\001\022\024\n\fstring_value\030\007 \001(\f\0323\n\bNamePart\022\021\n\tname_part\030\001 \002(\t\022\024\n\fis_extension\030\002 \002(\bB)\n\023com.google.protobufB\020DescriptorProtosH\001" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class DescriptorProto
    extends GeneratedMessage
  {
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    public static final int FIELD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private static final DescriptorProto defaultInstance = new DescriptorProto();
    private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
    private List<ExtensionRange> extensionRange_ = Collections.emptyList();
    private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
    private List<DescriptorProtos.FieldDescriptorProto> field_ = Collections.emptyList();
    private boolean hasName;
    private boolean hasOptions;
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private List<DescriptorProto> nestedType_ = Collections.emptyList();
    private DescriptorProtos.MessageOptions options_ = DescriptorProtos.MessageOptions.getDefaultInstance();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static DescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$3400();
    }
    
    public static Builder newBuilder(DescriptorProto paramDescriptorProto)
    {
      return newBuilder().mergeFrom(paramDescriptorProto);
    }
    
    public static DescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static DescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static DescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static DescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public DescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt)
    {
      return (DescriptorProtos.EnumDescriptorProto)this.enumType_.get(paramInt);
    }
    
    public int getEnumTypeCount()
    {
      return this.enumType_.size();
    }
    
    public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
    {
      return this.enumType_;
    }
    
    public DescriptorProtos.FieldDescriptorProto getExtension(int paramInt)
    {
      return (DescriptorProtos.FieldDescriptorProto)this.extension_.get(paramInt);
    }
    
    public int getExtensionCount()
    {
      return this.extension_.size();
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
    {
      return this.extension_;
    }
    
    public ExtensionRange getExtensionRange(int paramInt)
    {
      return (ExtensionRange)this.extensionRange_.get(paramInt);
    }
    
    public int getExtensionRangeCount()
    {
      return this.extensionRange_.size();
    }
    
    public List<ExtensionRange> getExtensionRangeList()
    {
      return this.extensionRange_;
    }
    
    public DescriptorProtos.FieldDescriptorProto getField(int paramInt)
    {
      return (DescriptorProtos.FieldDescriptorProto)this.field_.get(paramInt);
    }
    
    public int getFieldCount()
    {
      return this.field_.size();
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
    {
      return this.field_;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public DescriptorProto getNestedType(int paramInt)
    {
      return (DescriptorProto)this.nestedType_.get(paramInt);
    }
    
    public int getNestedTypeCount()
    {
      return this.nestedType_.size();
    }
    
    public List<DescriptorProto> getNestedTypeList()
    {
      return this.nestedType_;
    }
    
    public DescriptorProtos.MessageOptions getOptions()
    {
      return this.options_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasName()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      Iterator localIterator = getFieldList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (DescriptorProtos.FieldDescriptorProto)localIterator.next());
      }
      localIterator = getNestedTypeList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(3, (DescriptorProto)localIterator.next());
      }
      localIterator = getEnumTypeList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(4, (DescriptorProtos.EnumDescriptorProto)localIterator.next());
      }
      localIterator = getExtensionRangeList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(5, (ExtensionRange)localIterator.next());
      }
      localIterator = getExtensionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(6, (DescriptorProtos.FieldDescriptorProto)localIterator.next());
      }
      int j = i;
      if (hasOptions()) {
        j = i + CodedOutputStream.computeMessageSize(7, getOptions());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getFieldList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.FieldDescriptorProto)localIterator.next()).isInitialized());
      do
      {
        return false;
        localIterator = getExtensionList().iterator();
        while (localIterator.hasNext()) {
          if (!((DescriptorProtos.FieldDescriptorProto)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        localIterator = getNestedTypeList().iterator();
        while (localIterator.hasNext()) {
          if (!((DescriptorProto)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        localIterator = getEnumTypeList().iterator();
        while (localIterator.hasNext()) {
          if (!((DescriptorProtos.EnumDescriptorProto)localIterator.next()).isInitialized()) {
            return false;
          }
        }
      } while ((hasOptions()) && (!getOptions().isInitialized()));
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      Iterator localIterator = getFieldList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (DescriptorProtos.FieldDescriptorProto)localIterator.next());
      }
      localIterator = getNestedTypeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(3, (DescriptorProto)localIterator.next());
      }
      localIterator = getEnumTypeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(4, (DescriptorProtos.EnumDescriptorProto)localIterator.next());
      }
      localIterator = getExtensionRangeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(5, (ExtensionRange)localIterator.next());
      }
      localIterator = getExtensionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(6, (DescriptorProtos.FieldDescriptorProto)localIterator.next());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(7, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.DescriptorProto result;
      
      private DescriptorProtos.DescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.DescriptorProto(null);
        return localBuilder;
      }
      
      public Builder addAllEnumType(Iterable<? extends DescriptorProtos.EnumDescriptorProto> paramIterable)
      {
        if (this.result.enumType_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3902(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.enumType_);
        return this;
      }
      
      public Builder addAllExtension(Iterable<? extends DescriptorProtos.FieldDescriptorProto> paramIterable)
      {
        if (this.result.extension_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3702(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.extension_);
        return this;
      }
      
      public Builder addAllExtensionRange(Iterable<? extends DescriptorProtos.DescriptorProto.ExtensionRange> paramIterable)
      {
        if (this.result.extensionRange_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$4002(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.extensionRange_);
        return this;
      }
      
      public Builder addAllField(Iterable<? extends DescriptorProtos.FieldDescriptorProto> paramIterable)
      {
        if (this.result.field_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3602(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.field_);
        return this;
      }
      
      public Builder addAllNestedType(Iterable<? extends DescriptorProtos.DescriptorProto> paramIterable)
      {
        if (this.result.nestedType_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3802(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.nestedType_);
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto.Builder paramBuilder)
      {
        if (this.result.enumType_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3902(this.result, new ArrayList());
        }
        this.result.enumType_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto)
      {
        if (paramEnumDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.enumType_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3902(this.result, new ArrayList());
        }
        this.result.enumType_.add(paramEnumDescriptorProto);
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto.Builder paramBuilder)
      {
        if (this.result.extension_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3702(this.result, new ArrayList());
        }
        this.result.extension_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.extension_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3702(this.result, new ArrayList());
        }
        this.result.extension_.add(paramFieldDescriptorProto);
        return this;
      }
      
      public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange.Builder paramBuilder)
      {
        if (this.result.extensionRange_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$4002(this.result, new ArrayList());
        }
        this.result.extensionRange_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addExtensionRange(DescriptorProtos.DescriptorProto.ExtensionRange paramExtensionRange)
      {
        if (paramExtensionRange == null) {
          throw new NullPointerException();
        }
        if (this.result.extensionRange_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$4002(this.result, new ArrayList());
        }
        this.result.extensionRange_.add(paramExtensionRange);
        return this;
      }
      
      public Builder addField(DescriptorProtos.FieldDescriptorProto.Builder paramBuilder)
      {
        if (this.result.field_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3602(this.result, new ArrayList());
        }
        this.result.field_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addField(DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.field_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3602(this.result, new ArrayList());
        }
        this.result.field_.add(paramFieldDescriptorProto);
        return this;
      }
      
      public Builder addNestedType(Builder paramBuilder)
      {
        if (this.result.nestedType_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3802(this.result, new ArrayList());
        }
        this.result.nestedType_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addNestedType(DescriptorProtos.DescriptorProto paramDescriptorProto)
      {
        if (paramDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.nestedType_.isEmpty()) {
          DescriptorProtos.DescriptorProto.access$3802(this.result, new ArrayList());
        }
        this.result.nestedType_.add(paramDescriptorProto);
        return this;
      }
      
      public DescriptorProtos.DescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.DescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.field_ != Collections.EMPTY_LIST) {
          DescriptorProtos.DescriptorProto.access$3602(this.result, Collections.unmodifiableList(this.result.field_));
        }
        if (this.result.extension_ != Collections.EMPTY_LIST) {
          DescriptorProtos.DescriptorProto.access$3702(this.result, Collections.unmodifiableList(this.result.extension_));
        }
        if (this.result.nestedType_ != Collections.EMPTY_LIST) {
          DescriptorProtos.DescriptorProto.access$3802(this.result, Collections.unmodifiableList(this.result.nestedType_));
        }
        if (this.result.enumType_ != Collections.EMPTY_LIST) {
          DescriptorProtos.DescriptorProto.access$3902(this.result, Collections.unmodifiableList(this.result.enumType_));
        }
        if (this.result.extensionRange_ != Collections.EMPTY_LIST) {
          DescriptorProtos.DescriptorProto.access$4002(this.result, Collections.unmodifiableList(this.result.extensionRange_));
        }
        DescriptorProtos.DescriptorProto localDescriptorProto = this.result;
        this.result = null;
        return localDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.DescriptorProto(null);
        return this;
      }
      
      public Builder clearEnumType()
      {
        DescriptorProtos.DescriptorProto.access$3902(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearExtension()
      {
        DescriptorProtos.DescriptorProto.access$3702(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearExtensionRange()
      {
        DescriptorProtos.DescriptorProto.access$4002(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearField()
      {
        DescriptorProtos.DescriptorProto.access$3602(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.DescriptorProto.access$4102(this.result, false);
        DescriptorProtos.DescriptorProto.access$4202(this.result, DescriptorProtos.DescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearNestedType()
      {
        DescriptorProtos.DescriptorProto.access$3802(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.DescriptorProto.access$4302(this.result, false);
        DescriptorProtos.DescriptorProto.access$4402(this.result, DescriptorProtos.MessageOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.DescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.DescriptorProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.DescriptorProto.getDescriptor();
      }
      
      public DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt)
      {
        return this.result.getEnumType(paramInt);
      }
      
      public int getEnumTypeCount()
      {
        return this.result.getEnumTypeCount();
      }
      
      public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
      {
        return Collections.unmodifiableList(this.result.enumType_);
      }
      
      public DescriptorProtos.FieldDescriptorProto getExtension(int paramInt)
      {
        return this.result.getExtension(paramInt);
      }
      
      public int getExtensionCount()
      {
        return this.result.getExtensionCount();
      }
      
      public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
      {
        return Collections.unmodifiableList(this.result.extension_);
      }
      
      public DescriptorProtos.DescriptorProto.ExtensionRange getExtensionRange(int paramInt)
      {
        return this.result.getExtensionRange(paramInt);
      }
      
      public int getExtensionRangeCount()
      {
        return this.result.getExtensionRangeCount();
      }
      
      public List<DescriptorProtos.DescriptorProto.ExtensionRange> getExtensionRangeList()
      {
        return Collections.unmodifiableList(this.result.extensionRange_);
      }
      
      public DescriptorProtos.FieldDescriptorProto getField(int paramInt)
      {
        return this.result.getField(paramInt);
      }
      
      public int getFieldCount()
      {
        return this.result.getFieldCount();
      }
      
      public List<DescriptorProtos.FieldDescriptorProto> getFieldList()
      {
        return Collections.unmodifiableList(this.result.field_);
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public DescriptorProtos.DescriptorProto getNestedType(int paramInt)
      {
        return this.result.getNestedType(paramInt);
      }
      
      public int getNestedTypeCount()
      {
        return this.result.getNestedTypeCount();
      }
      
      public List<DescriptorProtos.DescriptorProto> getNestedTypeList()
      {
        return Collections.unmodifiableList(this.result.nestedType_);
      }
      
      public DescriptorProtos.MessageOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      protected DescriptorProtos.DescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 18: 
            localObject = DescriptorProtos.FieldDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addField(((DescriptorProtos.FieldDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 26: 
            localObject = DescriptorProtos.DescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addNestedType(((Builder)localObject).buildPartial());
            break;
          case 34: 
            localObject = DescriptorProtos.EnumDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addEnumType(((DescriptorProtos.EnumDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 42: 
            localObject = DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addExtensionRange(((DescriptorProtos.DescriptorProto.ExtensionRange.Builder)localObject).buildPartial());
            break;
          case 50: 
            localObject = DescriptorProtos.FieldDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addExtension(((DescriptorProtos.FieldDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 58: 
            localObject = DescriptorProtos.MessageOptions.newBuilder();
            if (hasOptions()) {
              ((DescriptorProtos.MessageOptions.Builder)localObject).mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            setOptions(((DescriptorProtos.MessageOptions.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.DescriptorProto paramDescriptorProto)
      {
        if (paramDescriptorProto == DescriptorProtos.DescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramDescriptorProto.hasName()) {
          setName(paramDescriptorProto.getName());
        }
        if (!paramDescriptorProto.field_.isEmpty())
        {
          if (this.result.field_.isEmpty()) {
            DescriptorProtos.DescriptorProto.access$3602(this.result, new ArrayList());
          }
          this.result.field_.addAll(paramDescriptorProto.field_);
        }
        if (!paramDescriptorProto.extension_.isEmpty())
        {
          if (this.result.extension_.isEmpty()) {
            DescriptorProtos.DescriptorProto.access$3702(this.result, new ArrayList());
          }
          this.result.extension_.addAll(paramDescriptorProto.extension_);
        }
        if (!paramDescriptorProto.nestedType_.isEmpty())
        {
          if (this.result.nestedType_.isEmpty()) {
            DescriptorProtos.DescriptorProto.access$3802(this.result, new ArrayList());
          }
          this.result.nestedType_.addAll(paramDescriptorProto.nestedType_);
        }
        if (!paramDescriptorProto.enumType_.isEmpty())
        {
          if (this.result.enumType_.isEmpty()) {
            DescriptorProtos.DescriptorProto.access$3902(this.result, new ArrayList());
          }
          this.result.enumType_.addAll(paramDescriptorProto.enumType_);
        }
        if (!paramDescriptorProto.extensionRange_.isEmpty())
        {
          if (this.result.extensionRange_.isEmpty()) {
            DescriptorProtos.DescriptorProto.access$4002(this.result, new ArrayList());
          }
          this.result.extensionRange_.addAll(paramDescriptorProto.extensionRange_);
        }
        if (paramDescriptorProto.hasOptions()) {
          mergeOptions(paramDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.DescriptorProto)) {
          return mergeFrom((DescriptorProtos.DescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.MessageOptions paramMessageOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.MessageOptions.getDefaultInstance())) {
          DescriptorProtos.DescriptorProto.access$4402(this.result, DescriptorProtos.MessageOptions.newBuilder(this.result.options_).mergeFrom(paramMessageOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.DescriptorProto.access$4302(this.result, true);
          return this;
          DescriptorProtos.DescriptorProto.access$4402(this.result, paramMessageOptions);
        }
      }
      
      public Builder setEnumType(int paramInt, DescriptorProtos.EnumDescriptorProto.Builder paramBuilder)
      {
        this.result.enumType_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setEnumType(int paramInt, DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto)
      {
        if (paramEnumDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.enumType_.set(paramInt, paramEnumDescriptorProto);
        return this;
      }
      
      public Builder setExtension(int paramInt, DescriptorProtos.FieldDescriptorProto.Builder paramBuilder)
      {
        this.result.extension_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setExtension(int paramInt, DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.extension_.set(paramInt, paramFieldDescriptorProto);
        return this;
      }
      
      public Builder setExtensionRange(int paramInt, DescriptorProtos.DescriptorProto.ExtensionRange.Builder paramBuilder)
      {
        this.result.extensionRange_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setExtensionRange(int paramInt, DescriptorProtos.DescriptorProto.ExtensionRange paramExtensionRange)
      {
        if (paramExtensionRange == null) {
          throw new NullPointerException();
        }
        this.result.extensionRange_.set(paramInt, paramExtensionRange);
        return this;
      }
      
      public Builder setField(int paramInt, DescriptorProtos.FieldDescriptorProto.Builder paramBuilder)
      {
        this.result.field_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setField(int paramInt, DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.field_.set(paramInt, paramFieldDescriptorProto);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.DescriptorProto.access$4102(this.result, true);
        DescriptorProtos.DescriptorProto.access$4202(this.result, paramString);
        return this;
      }
      
      public Builder setNestedType(int paramInt, Builder paramBuilder)
      {
        this.result.nestedType_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setNestedType(int paramInt, DescriptorProtos.DescriptorProto paramDescriptorProto)
      {
        if (paramDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.nestedType_.set(paramInt, paramDescriptorProto);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.MessageOptions.Builder paramBuilder)
      {
        DescriptorProtos.DescriptorProto.access$4302(this.result, true);
        DescriptorProtos.DescriptorProto.access$4402(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.MessageOptions paramMessageOptions)
      {
        if (paramMessageOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.DescriptorProto.access$4302(this.result, true);
        DescriptorProtos.DescriptorProto.access$4402(this.result, paramMessageOptions);
        return this;
      }
    }
    
    public static final class ExtensionRange
      extends GeneratedMessage
    {
      public static final int END_FIELD_NUMBER = 2;
      public static final int START_FIELD_NUMBER = 1;
      private static final ExtensionRange defaultInstance = new ExtensionRange();
      private int end_ = 0;
      private boolean hasEnd;
      private boolean hasStart;
      private int memoizedSerializedSize = -1;
      private int start_ = 0;
      
      static
      {
        DescriptorProtos.getDescriptor();
        DescriptorProtos.internalForceInit();
      }
      
      public static ExtensionRange getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor;
      }
      
      public static Builder newBuilder()
      {
        return Builder.access$2700();
      }
      
      public static Builder newBuilder(ExtensionRange paramExtensionRange)
      {
        return newBuilder().mergeFrom(paramExtensionRange);
      }
      
      public static ExtensionRange parseDelimitedFrom(InputStream paramInputStream)
        throws IOException
      {
        return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
      }
      
      public static ExtensionRange parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(ByteString paramByteString)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(CodedInputStream paramCodedInputStream)
        throws IOException
      {
        return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
      }
      
      public static ExtensionRange parseFrom(InputStream paramInputStream)
        throws IOException
      {
        return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
      }
      
      public static ExtensionRange parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
      }
      
      public ExtensionRange getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public int getEnd()
      {
        return this.end_;
      }
      
      public int getSerializedSize()
      {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        if (hasStart()) {
          i = 0 + CodedOutputStream.computeInt32Size(1, getStart());
        }
        int j = i;
        if (hasEnd()) {
          j = i + CodedOutputStream.computeInt32Size(2, getEnd());
        }
        i = j + getUnknownFields().getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public int getStart()
      {
        return this.start_;
      }
      
      public boolean hasEnd()
      {
        return this.hasEnd;
      }
      
      public boolean hasStart()
      {
        return this.hasStart;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
      
      public Builder newBuilderForType()
      {
        return newBuilder();
      }
      
      public Builder toBuilder()
      {
        return newBuilder(this);
      }
      
      public void writeTo(CodedOutputStream paramCodedOutputStream)
        throws IOException
      {
        if (hasStart()) {
          paramCodedOutputStream.writeInt32(1, getStart());
        }
        if (hasEnd()) {
          paramCodedOutputStream.writeInt32(2, getEnd());
        }
        getUnknownFields().writeTo(paramCodedOutputStream);
      }
      
      public static final class Builder
        extends GeneratedMessage.Builder<Builder>
      {
        private DescriptorProtos.DescriptorProto.ExtensionRange result;
        
        private DescriptorProtos.DescriptorProto.ExtensionRange buildParsed()
          throws InvalidProtocolBufferException
        {
          if (!isInitialized()) {
            throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
          }
          return buildPartial();
        }
        
        private static Builder create()
        {
          Builder localBuilder = new Builder();
          localBuilder.result = new DescriptorProtos.DescriptorProto.ExtensionRange(null);
          return localBuilder;
        }
        
        public DescriptorProtos.DescriptorProto.ExtensionRange build()
        {
          if ((this.result != null) && (!isInitialized())) {
            throw newUninitializedMessageException(this.result);
          }
          return buildPartial();
        }
        
        public DescriptorProtos.DescriptorProto.ExtensionRange buildPartial()
        {
          if (this.result == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
          }
          DescriptorProtos.DescriptorProto.ExtensionRange localExtensionRange = this.result;
          this.result = null;
          return localExtensionRange;
        }
        
        public Builder clear()
        {
          if (this.result == null) {
            throw new IllegalStateException("Cannot call clear() after build().");
          }
          this.result = new DescriptorProtos.DescriptorProto.ExtensionRange(null);
          return this;
        }
        
        public Builder clearEnd()
        {
          DescriptorProtos.DescriptorProto.ExtensionRange.access$3102(this.result, false);
          DescriptorProtos.DescriptorProto.ExtensionRange.access$3202(this.result, 0);
          return this;
        }
        
        public Builder clearStart()
        {
          DescriptorProtos.DescriptorProto.ExtensionRange.access$2902(this.result, false);
          DescriptorProtos.DescriptorProto.ExtensionRange.access$3002(this.result, 0);
          return this;
        }
        
        public Builder clone()
        {
          return create().mergeFrom(this.result);
        }
        
        public DescriptorProtos.DescriptorProto.ExtensionRange getDefaultInstanceForType()
        {
          return DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance();
        }
        
        public Descriptors.Descriptor getDescriptorForType()
        {
          return DescriptorProtos.DescriptorProto.ExtensionRange.getDescriptor();
        }
        
        public int getEnd()
        {
          return this.result.getEnd();
        }
        
        public int getStart()
        {
          return this.result.getStart();
        }
        
        public boolean hasEnd()
        {
          return this.result.hasEnd();
        }
        
        public boolean hasStart()
        {
          return this.result.hasStart();
        }
        
        protected DescriptorProtos.DescriptorProto.ExtensionRange internalGetResult()
        {
          return this.result;
        }
        
        public boolean isInitialized()
        {
          return this.result.isInitialized();
        }
        
        public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
          throws IOException
        {
          UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
          for (;;)
          {
            int i = paramCodedInputStream.readTag();
            switch (i)
            {
            default: 
              if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
              {
                setUnknownFields(localBuilder.build());
                return this;
              }
              break;
            case 0: 
              setUnknownFields(localBuilder.build());
              return this;
            case 8: 
              setStart(paramCodedInputStream.readInt32());
              break;
            case 16: 
              setEnd(paramCodedInputStream.readInt32());
            }
          }
        }
        
        public Builder mergeFrom(DescriptorProtos.DescriptorProto.ExtensionRange paramExtensionRange)
        {
          if (paramExtensionRange == DescriptorProtos.DescriptorProto.ExtensionRange.getDefaultInstance()) {
            return this;
          }
          if (paramExtensionRange.hasStart()) {
            setStart(paramExtensionRange.getStart());
          }
          if (paramExtensionRange.hasEnd()) {
            setEnd(paramExtensionRange.getEnd());
          }
          mergeUnknownFields(paramExtensionRange.getUnknownFields());
          return this;
        }
        
        public Builder mergeFrom(Message paramMessage)
        {
          if ((paramMessage instanceof DescriptorProtos.DescriptorProto.ExtensionRange)) {
            return mergeFrom((DescriptorProtos.DescriptorProto.ExtensionRange)paramMessage);
          }
          super.mergeFrom(paramMessage);
          return this;
        }
        
        public Builder setEnd(int paramInt)
        {
          DescriptorProtos.DescriptorProto.ExtensionRange.access$3102(this.result, true);
          DescriptorProtos.DescriptorProto.ExtensionRange.access$3202(this.result, paramInt);
          return this;
        }
        
        public Builder setStart(int paramInt)
        {
          DescriptorProtos.DescriptorProto.ExtensionRange.access$2902(this.result, true);
          DescriptorProtos.DescriptorProto.ExtensionRange.access$3002(this.result, paramInt);
          return this;
        }
      }
    }
  }
  
  public static final class EnumDescriptorProto
    extends GeneratedMessage
  {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 2;
    private static final EnumDescriptorProto defaultInstance = new EnumDescriptorProto();
    private boolean hasName;
    private boolean hasOptions;
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private DescriptorProtos.EnumOptions options_ = DescriptorProtos.EnumOptions.getDefaultInstance();
    private List<DescriptorProtos.EnumValueDescriptorProto> value_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static EnumDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$6900();
    }
    
    public static Builder newBuilder(EnumDescriptorProto paramEnumDescriptorProto)
    {
      return newBuilder().mergeFrom(paramEnumDescriptorProto);
    }
    
    public static EnumDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static EnumDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public EnumDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public DescriptorProtos.EnumOptions getOptions()
    {
      return this.options_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasName()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      Iterator localIterator = getValueList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (DescriptorProtos.EnumValueDescriptorProto)localIterator.next());
      }
      int j = i;
      if (hasOptions()) {
        j = i + CodedOutputStream.computeMessageSize(3, getOptions());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.EnumValueDescriptorProto getValue(int paramInt)
    {
      return (DescriptorProtos.EnumValueDescriptorProto)this.value_.get(paramInt);
    }
    
    public int getValueCount()
    {
      return this.value_.size();
    }
    
    public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
    {
      return this.value_;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getValueList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.EnumValueDescriptorProto)localIterator.next()).isInitialized());
      while ((hasOptions()) && (!getOptions().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      Iterator localIterator = getValueList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (DescriptorProtos.EnumValueDescriptorProto)localIterator.next());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(3, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.EnumDescriptorProto result;
      
      private DescriptorProtos.EnumDescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.EnumDescriptorProto(null);
        return localBuilder;
      }
      
      public Builder addAllValue(Iterable<? extends DescriptorProtos.EnumValueDescriptorProto> paramIterable)
      {
        if (this.result.value_.isEmpty()) {
          DescriptorProtos.EnumDescriptorProto.access$7102(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.value_);
        return this;
      }
      
      public Builder addValue(DescriptorProtos.EnumValueDescriptorProto.Builder paramBuilder)
      {
        if (this.result.value_.isEmpty()) {
          DescriptorProtos.EnumDescriptorProto.access$7102(this.result, new ArrayList());
        }
        this.result.value_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addValue(DescriptorProtos.EnumValueDescriptorProto paramEnumValueDescriptorProto)
      {
        if (paramEnumValueDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.value_.isEmpty()) {
          DescriptorProtos.EnumDescriptorProto.access$7102(this.result, new ArrayList());
        }
        this.result.value_.add(paramEnumValueDescriptorProto);
        return this;
      }
      
      public DescriptorProtos.EnumDescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.EnumDescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.value_ != Collections.EMPTY_LIST) {
          DescriptorProtos.EnumDescriptorProto.access$7102(this.result, Collections.unmodifiableList(this.result.value_));
        }
        DescriptorProtos.EnumDescriptorProto localEnumDescriptorProto = this.result;
        this.result = null;
        return localEnumDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.EnumDescriptorProto(null);
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.EnumDescriptorProto.access$7202(this.result, false);
        DescriptorProtos.EnumDescriptorProto.access$7302(this.result, DescriptorProtos.EnumDescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.EnumDescriptorProto.access$7402(this.result, false);
        DescriptorProtos.EnumDescriptorProto.access$7502(this.result, DescriptorProtos.EnumOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clearValue()
      {
        DescriptorProtos.EnumDescriptorProto.access$7102(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.EnumDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumDescriptorProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.EnumDescriptorProto.getDescriptor();
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public DescriptorProtos.EnumOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public DescriptorProtos.EnumValueDescriptorProto getValue(int paramInt)
      {
        return this.result.getValue(paramInt);
      }
      
      public int getValueCount()
      {
        return this.result.getValueCount();
      }
      
      public List<DescriptorProtos.EnumValueDescriptorProto> getValueList()
      {
        return Collections.unmodifiableList(this.result.value_);
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      protected DescriptorProtos.EnumDescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 18: 
            localObject = DescriptorProtos.EnumValueDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addValue(((DescriptorProtos.EnumValueDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 26: 
            localObject = DescriptorProtos.EnumOptions.newBuilder();
            if (hasOptions()) {
              ((DescriptorProtos.EnumOptions.Builder)localObject).mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            setOptions(((DescriptorProtos.EnumOptions.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto)
      {
        if (paramEnumDescriptorProto == DescriptorProtos.EnumDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramEnumDescriptorProto.hasName()) {
          setName(paramEnumDescriptorProto.getName());
        }
        if (!paramEnumDescriptorProto.value_.isEmpty())
        {
          if (this.result.value_.isEmpty()) {
            DescriptorProtos.EnumDescriptorProto.access$7102(this.result, new ArrayList());
          }
          this.result.value_.addAll(paramEnumDescriptorProto.value_);
        }
        if (paramEnumDescriptorProto.hasOptions()) {
          mergeOptions(paramEnumDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramEnumDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.EnumDescriptorProto)) {
          return mergeFrom((DescriptorProtos.EnumDescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.EnumOptions paramEnumOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.EnumOptions.getDefaultInstance())) {
          DescriptorProtos.EnumDescriptorProto.access$7502(this.result, DescriptorProtos.EnumOptions.newBuilder(this.result.options_).mergeFrom(paramEnumOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.EnumDescriptorProto.access$7402(this.result, true);
          return this;
          DescriptorProtos.EnumDescriptorProto.access$7502(this.result, paramEnumOptions);
        }
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.EnumDescriptorProto.access$7202(this.result, true);
        DescriptorProtos.EnumDescriptorProto.access$7302(this.result, paramString);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.EnumOptions.Builder paramBuilder)
      {
        DescriptorProtos.EnumDescriptorProto.access$7402(this.result, true);
        DescriptorProtos.EnumDescriptorProto.access$7502(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.EnumOptions paramEnumOptions)
      {
        if (paramEnumOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.EnumDescriptorProto.access$7402(this.result, true);
        DescriptorProtos.EnumDescriptorProto.access$7502(this.result, paramEnumOptions);
        return this;
      }
      
      public Builder setValue(int paramInt, DescriptorProtos.EnumValueDescriptorProto.Builder paramBuilder)
      {
        this.result.value_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setValue(int paramInt, DescriptorProtos.EnumValueDescriptorProto paramEnumValueDescriptorProto)
      {
        if (paramEnumValueDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.value_.set(paramInt, paramEnumValueDescriptorProto);
        return this;
      }
    }
  }
  
  public static final class EnumOptions
    extends GeneratedMessage.ExtendableMessage<EnumOptions>
  {
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final EnumOptions defaultInstance = new EnumOptions();
    private int memoizedSerializedSize = -1;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static EnumOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$15100();
    }
    
    public static Builder newBuilder(EnumOptions paramEnumOptions)
    {
      return newBuilder().mergeFrom(paramEnumOptions);
    }
    
    public static EnumOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static EnumOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static EnumOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static EnumOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static EnumOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public EnumOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = i + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.EnumOptions, Builder>
    {
      private DescriptorProtos.EnumOptions result;
      
      private DescriptorProtos.EnumOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.EnumOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.EnumOptions.access$15302(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.EnumOptions.access$15302(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.EnumOptions.access$15302(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.EnumOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.EnumOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.EnumOptions.access$15302(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.EnumOptions localEnumOptions = this.result;
        this.result = null;
        return localEnumOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.EnumOptions(null);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.EnumOptions.access$15302(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.EnumOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.EnumOptions.getDescriptor();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      protected DescriptorProtos.EnumOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 7994: 
            DescriptorProtos.UninterpretedOption.Builder localBuilder1 = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addUninterpretedOption(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumOptions paramEnumOptions)
      {
        if (paramEnumOptions == DescriptorProtos.EnumOptions.getDefaultInstance()) {
          return this;
        }
        if (!paramEnumOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.EnumOptions.access$15302(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramEnumOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramEnumOptions);
        mergeUnknownFields(paramEnumOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.EnumOptions)) {
          return mergeFrom((DescriptorProtos.EnumOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
  }
  
  public static final class EnumValueDescriptorProto
    extends GeneratedMessage
  {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final EnumValueDescriptorProto defaultInstance = new EnumValueDescriptorProto();
    private boolean hasName;
    private boolean hasNumber;
    private boolean hasOptions;
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private int number_ = 0;
    private DescriptorProtos.EnumValueOptions options_ = DescriptorProtos.EnumValueOptions.getDefaultInstance();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static EnumValueDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$7900();
    }
    
    public static Builder newBuilder(EnumValueDescriptorProto paramEnumValueDescriptorProto)
    {
      return newBuilder().mergeFrom(paramEnumValueDescriptorProto);
    }
    
    public static EnumValueDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static EnumValueDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public EnumValueDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public int getNumber()
    {
      return this.number_;
    }
    
    public DescriptorProtos.EnumValueOptions getOptions()
    {
      return this.options_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasName()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      i = j;
      if (hasNumber()) {
        i = j + CodedOutputStream.computeInt32Size(2, getNumber());
      }
      j = i;
      if (hasOptions()) {
        j = i + CodedOutputStream.computeMessageSize(3, getOptions());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasNumber()
    {
      return this.hasNumber;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return (!hasOptions()) || (getOptions().isInitialized());
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      if (hasNumber()) {
        paramCodedOutputStream.writeInt32(2, getNumber());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(3, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.EnumValueDescriptorProto result;
      
      private DescriptorProtos.EnumValueDescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.EnumValueDescriptorProto(null);
        return localBuilder;
      }
      
      public DescriptorProtos.EnumValueDescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.EnumValueDescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        DescriptorProtos.EnumValueDescriptorProto localEnumValueDescriptorProto = this.result;
        this.result = null;
        return localEnumValueDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.EnumValueDescriptorProto(null);
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.EnumValueDescriptorProto.access$8102(this.result, false);
        DescriptorProtos.EnumValueDescriptorProto.access$8202(this.result, DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearNumber()
      {
        DescriptorProtos.EnumValueDescriptorProto.access$8302(this.result, false);
        DescriptorProtos.EnumValueDescriptorProto.access$8402(this.result, 0);
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.EnumValueDescriptorProto.access$8502(this.result, false);
        DescriptorProtos.EnumValueDescriptorProto.access$8602(this.result, DescriptorProtos.EnumValueOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.EnumValueDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.EnumValueDescriptorProto.getDescriptor();
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public int getNumber()
      {
        return this.result.getNumber();
      }
      
      public DescriptorProtos.EnumValueOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasNumber()
      {
        return this.result.hasNumber();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      protected DescriptorProtos.EnumValueDescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 16: 
            setNumber(paramCodedInputStream.readInt32());
            break;
          case 26: 
            DescriptorProtos.EnumValueOptions.Builder localBuilder1 = DescriptorProtos.EnumValueOptions.newBuilder();
            if (hasOptions()) {
              localBuilder1.mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            setOptions(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumValueDescriptorProto paramEnumValueDescriptorProto)
      {
        if (paramEnumValueDescriptorProto == DescriptorProtos.EnumValueDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramEnumValueDescriptorProto.hasName()) {
          setName(paramEnumValueDescriptorProto.getName());
        }
        if (paramEnumValueDescriptorProto.hasNumber()) {
          setNumber(paramEnumValueDescriptorProto.getNumber());
        }
        if (paramEnumValueDescriptorProto.hasOptions()) {
          mergeOptions(paramEnumValueDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramEnumValueDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.EnumValueDescriptorProto)) {
          return mergeFrom((DescriptorProtos.EnumValueDescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.EnumValueOptions paramEnumValueOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.EnumValueOptions.getDefaultInstance())) {
          DescriptorProtos.EnumValueDescriptorProto.access$8602(this.result, DescriptorProtos.EnumValueOptions.newBuilder(this.result.options_).mergeFrom(paramEnumValueOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.EnumValueDescriptorProto.access$8502(this.result, true);
          return this;
          DescriptorProtos.EnumValueDescriptorProto.access$8602(this.result, paramEnumValueOptions);
        }
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.EnumValueDescriptorProto.access$8102(this.result, true);
        DescriptorProtos.EnumValueDescriptorProto.access$8202(this.result, paramString);
        return this;
      }
      
      public Builder setNumber(int paramInt)
      {
        DescriptorProtos.EnumValueDescriptorProto.access$8302(this.result, true);
        DescriptorProtos.EnumValueDescriptorProto.access$8402(this.result, paramInt);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.EnumValueOptions.Builder paramBuilder)
      {
        DescriptorProtos.EnumValueDescriptorProto.access$8502(this.result, true);
        DescriptorProtos.EnumValueDescriptorProto.access$8602(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.EnumValueOptions paramEnumValueOptions)
      {
        if (paramEnumValueOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.EnumValueDescriptorProto.access$8502(this.result, true);
        DescriptorProtos.EnumValueDescriptorProto.access$8602(this.result, paramEnumValueOptions);
        return this;
      }
    }
  }
  
  public static final class EnumValueOptions
    extends GeneratedMessage.ExtendableMessage<EnumValueOptions>
  {
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final EnumValueOptions defaultInstance = new EnumValueOptions();
    private int memoizedSerializedSize = -1;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static EnumValueOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$15700();
    }
    
    public static Builder newBuilder(EnumValueOptions paramEnumValueOptions)
    {
      return newBuilder().mergeFrom(paramEnumValueOptions);
    }
    
    public static EnumValueOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumValueOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static EnumValueOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public EnumValueOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = i + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.EnumValueOptions, Builder>
    {
      private DescriptorProtos.EnumValueOptions result;
      
      private DescriptorProtos.EnumValueOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.EnumValueOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.EnumValueOptions.access$15902(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.EnumValueOptions.access$15902(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.EnumValueOptions.access$15902(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.EnumValueOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.EnumValueOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.EnumValueOptions.access$15902(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.EnumValueOptions localEnumValueOptions = this.result;
        this.result = null;
        return localEnumValueOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.EnumValueOptions(null);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.EnumValueOptions.access$15902(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.EnumValueOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.EnumValueOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.EnumValueOptions.getDescriptor();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      protected DescriptorProtos.EnumValueOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 7994: 
            DescriptorProtos.UninterpretedOption.Builder localBuilder1 = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addUninterpretedOption(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.EnumValueOptions paramEnumValueOptions)
      {
        if (paramEnumValueOptions == DescriptorProtos.EnumValueOptions.getDefaultInstance()) {
          return this;
        }
        if (!paramEnumValueOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.EnumValueOptions.access$15902(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramEnumValueOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramEnumValueOptions);
        mergeUnknownFields(paramEnumValueOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.EnumValueOptions)) {
          return mergeFrom((DescriptorProtos.EnumValueOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
  }
  
  public static final class FieldDescriptorProto
    extends GeneratedMessage
  {
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    public static final int LABEL_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private static final FieldDescriptorProto defaultInstance = new FieldDescriptorProto();
    private String defaultValue_ = "";
    private String extendee_ = "";
    private boolean hasDefaultValue;
    private boolean hasExtendee;
    private boolean hasLabel;
    private boolean hasName;
    private boolean hasNumber;
    private boolean hasOptions;
    private boolean hasType;
    private boolean hasTypeName;
    private Label label_ = Label.LABEL_OPTIONAL;
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private int number_ = 0;
    private DescriptorProtos.FieldOptions options_ = DescriptorProtos.FieldOptions.getDefaultInstance();
    private String typeName_ = "";
    private Type type_ = Type.TYPE_DOUBLE;
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static FieldDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$4800();
    }
    
    public static Builder newBuilder(FieldDescriptorProto paramFieldDescriptorProto)
    {
      return newBuilder().mergeFrom(paramFieldDescriptorProto);
    }
    
    public static FieldDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static FieldDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static FieldDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public FieldDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getDefaultValue()
    {
      return this.defaultValue_;
    }
    
    public String getExtendee()
    {
      return this.extendee_;
    }
    
    public Label getLabel()
    {
      return this.label_;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public int getNumber()
    {
      return this.number_;
    }
    
    public DescriptorProtos.FieldOptions getOptions()
    {
      return this.options_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasName()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      i = j;
      if (hasExtendee()) {
        i = j + CodedOutputStream.computeStringSize(2, getExtendee());
      }
      j = i;
      if (hasNumber()) {
        j = i + CodedOutputStream.computeInt32Size(3, getNumber());
      }
      i = j;
      if (hasLabel()) {
        i = j + CodedOutputStream.computeEnumSize(4, getLabel().getNumber());
      }
      j = i;
      if (hasType()) {
        j = i + CodedOutputStream.computeEnumSize(5, getType().getNumber());
      }
      i = j;
      if (hasTypeName()) {
        i = j + CodedOutputStream.computeStringSize(6, getTypeName());
      }
      j = i;
      if (hasDefaultValue()) {
        j = i + CodedOutputStream.computeStringSize(7, getDefaultValue());
      }
      i = j;
      if (hasOptions()) {
        i = j + CodedOutputStream.computeMessageSize(8, getOptions());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public Type getType()
    {
      return this.type_;
    }
    
    public String getTypeName()
    {
      return this.typeName_;
    }
    
    public boolean hasDefaultValue()
    {
      return this.hasDefaultValue;
    }
    
    public boolean hasExtendee()
    {
      return this.hasExtendee;
    }
    
    public boolean hasLabel()
    {
      return this.hasLabel;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasNumber()
    {
      return this.hasNumber;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    public boolean hasType()
    {
      return this.hasType;
    }
    
    public boolean hasTypeName()
    {
      return this.hasTypeName;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return (!hasOptions()) || (getOptions().isInitialized());
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      if (hasExtendee()) {
        paramCodedOutputStream.writeString(2, getExtendee());
      }
      if (hasNumber()) {
        paramCodedOutputStream.writeInt32(3, getNumber());
      }
      if (hasLabel()) {
        paramCodedOutputStream.writeEnum(4, getLabel().getNumber());
      }
      if (hasType()) {
        paramCodedOutputStream.writeEnum(5, getType().getNumber());
      }
      if (hasTypeName()) {
        paramCodedOutputStream.writeString(6, getTypeName());
      }
      if (hasDefaultValue()) {
        paramCodedOutputStream.writeString(7, getDefaultValue());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(8, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.FieldDescriptorProto result;
      
      private DescriptorProtos.FieldDescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.FieldDescriptorProto(null);
        return localBuilder;
      }
      
      public DescriptorProtos.FieldDescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.FieldDescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        DescriptorProtos.FieldDescriptorProto localFieldDescriptorProto = this.result;
        this.result = null;
        return localFieldDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.FieldDescriptorProto(null);
        return this;
      }
      
      public Builder clearDefaultValue()
      {
        DescriptorProtos.FieldDescriptorProto.access$6202(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$6302(this.result, DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getDefaultValue());
        return this;
      }
      
      public Builder clearExtendee()
      {
        DescriptorProtos.FieldDescriptorProto.access$6002(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$6102(this.result, DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getExtendee());
        return this;
      }
      
      public Builder clearLabel()
      {
        DescriptorProtos.FieldDescriptorProto.access$5402(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$5502(this.result, DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL);
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.FieldDescriptorProto.access$5002(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$5102(this.result, DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearNumber()
      {
        DescriptorProtos.FieldDescriptorProto.access$5202(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$5302(this.result, 0);
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.FieldDescriptorProto.access$6402(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$6502(this.result, DescriptorProtos.FieldOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clearType()
      {
        DescriptorProtos.FieldDescriptorProto.access$5602(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$5702(this.result, DescriptorProtos.FieldDescriptorProto.Type.TYPE_DOUBLE);
        return this;
      }
      
      public Builder clearTypeName()
      {
        DescriptorProtos.FieldDescriptorProto.access$5802(this.result, false);
        DescriptorProtos.FieldDescriptorProto.access$5902(this.result, DescriptorProtos.FieldDescriptorProto.getDefaultInstance().getTypeName());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.FieldDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.FieldDescriptorProto.getDefaultInstance();
      }
      
      public String getDefaultValue()
      {
        return this.result.getDefaultValue();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.FieldDescriptorProto.getDescriptor();
      }
      
      public String getExtendee()
      {
        return this.result.getExtendee();
      }
      
      public DescriptorProtos.FieldDescriptorProto.Label getLabel()
      {
        return this.result.getLabel();
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public int getNumber()
      {
        return this.result.getNumber();
      }
      
      public DescriptorProtos.FieldOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public DescriptorProtos.FieldDescriptorProto.Type getType()
      {
        return this.result.getType();
      }
      
      public String getTypeName()
      {
        return this.result.getTypeName();
      }
      
      public boolean hasDefaultValue()
      {
        return this.result.hasDefaultValue();
      }
      
      public boolean hasExtendee()
      {
        return this.result.hasExtendee();
      }
      
      public boolean hasLabel()
      {
        return this.result.hasLabel();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasNumber()
      {
        return this.result.hasNumber();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      public boolean hasType()
      {
        return this.result.hasType();
      }
      
      public boolean hasTypeName()
      {
        return this.result.hasTypeName();
      }
      
      protected DescriptorProtos.FieldDescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 18: 
            setExtendee(paramCodedInputStream.readString());
            break;
          case 24: 
            setNumber(paramCodedInputStream.readInt32());
            break;
          case 32: 
            i = paramCodedInputStream.readEnum();
            localObject = DescriptorProtos.FieldDescriptorProto.Label.valueOf(i);
            if (localObject == null) {
              localBuilder.mergeVarintField(4, i);
            } else {
              setLabel((DescriptorProtos.FieldDescriptorProto.Label)localObject);
            }
            break;
          case 40: 
            i = paramCodedInputStream.readEnum();
            localObject = DescriptorProtos.FieldDescriptorProto.Type.valueOf(i);
            if (localObject == null) {
              localBuilder.mergeVarintField(5, i);
            } else {
              setType((DescriptorProtos.FieldDescriptorProto.Type)localObject);
            }
            break;
          case 50: 
            setTypeName(paramCodedInputStream.readString());
            break;
          case 58: 
            setDefaultValue(paramCodedInputStream.readString());
            break;
          case 66: 
            localObject = DescriptorProtos.FieldOptions.newBuilder();
            if (hasOptions()) {
              ((DescriptorProtos.FieldOptions.Builder)localObject).mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            setOptions(((DescriptorProtos.FieldOptions.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == DescriptorProtos.FieldDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramFieldDescriptorProto.hasName()) {
          setName(paramFieldDescriptorProto.getName());
        }
        if (paramFieldDescriptorProto.hasNumber()) {
          setNumber(paramFieldDescriptorProto.getNumber());
        }
        if (paramFieldDescriptorProto.hasLabel()) {
          setLabel(paramFieldDescriptorProto.getLabel());
        }
        if (paramFieldDescriptorProto.hasType()) {
          setType(paramFieldDescriptorProto.getType());
        }
        if (paramFieldDescriptorProto.hasTypeName()) {
          setTypeName(paramFieldDescriptorProto.getTypeName());
        }
        if (paramFieldDescriptorProto.hasExtendee()) {
          setExtendee(paramFieldDescriptorProto.getExtendee());
        }
        if (paramFieldDescriptorProto.hasDefaultValue()) {
          setDefaultValue(paramFieldDescriptorProto.getDefaultValue());
        }
        if (paramFieldDescriptorProto.hasOptions()) {
          mergeOptions(paramFieldDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramFieldDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.FieldDescriptorProto)) {
          return mergeFrom((DescriptorProtos.FieldDescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.FieldOptions paramFieldOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.FieldOptions.getDefaultInstance())) {
          DescriptorProtos.FieldDescriptorProto.access$6502(this.result, DescriptorProtos.FieldOptions.newBuilder(this.result.options_).mergeFrom(paramFieldOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.FieldDescriptorProto.access$6402(this.result, true);
          return this;
          DescriptorProtos.FieldDescriptorProto.access$6502(this.result, paramFieldOptions);
        }
      }
      
      public Builder setDefaultValue(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$6202(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$6302(this.result, paramString);
        return this;
      }
      
      public Builder setExtendee(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$6002(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$6102(this.result, paramString);
        return this;
      }
      
      public Builder setLabel(DescriptorProtos.FieldDescriptorProto.Label paramLabel)
      {
        if (paramLabel == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$5402(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$5502(this.result, paramLabel);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$5002(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$5102(this.result, paramString);
        return this;
      }
      
      public Builder setNumber(int paramInt)
      {
        DescriptorProtos.FieldDescriptorProto.access$5202(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$5302(this.result, paramInt);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.FieldOptions.Builder paramBuilder)
      {
        DescriptorProtos.FieldDescriptorProto.access$6402(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$6502(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.FieldOptions paramFieldOptions)
      {
        if (paramFieldOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$6402(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$6502(this.result, paramFieldOptions);
        return this;
      }
      
      public Builder setType(DescriptorProtos.FieldDescriptorProto.Type paramType)
      {
        if (paramType == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$5602(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$5702(this.result, paramType);
        return this;
      }
      
      public Builder setTypeName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldDescriptorProto.access$5802(this.result, true);
        DescriptorProtos.FieldDescriptorProto.access$5902(this.result, paramString);
        return this;
      }
    }
    
    public static enum Label
      implements ProtocolMessageEnum
    {
      private static final Label[] VALUES;
      private static Internal.EnumLiteMap<Label> internalValueMap;
      private final int index;
      private final int value;
      
      static
      {
        LABEL_REPEATED = new Label("LABEL_REPEATED", 2, 2, 3);
        $VALUES = new Label[] { LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED };
        internalValueMap = new Internal.EnumLiteMap()
        {
          public DescriptorProtos.FieldDescriptorProto.Label findValueByNumber(int paramAnonymousInt)
          {
            return DescriptorProtos.FieldDescriptorProto.Label.valueOf(paramAnonymousInt);
          }
        };
        VALUES = new Label[] { LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED };
        DescriptorProtos.getDescriptor();
      }
      
      private Label(int paramInt1, int paramInt2)
      {
        this.index = paramInt1;
        this.value = paramInt2;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
      }
      
      public static Internal.EnumLiteMap<Label> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static Label valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return LABEL_OPTIONAL;
        case 2: 
          return LABEL_REQUIRED;
        }
        return LABEL_REPEATED;
      }
      
      public static Label valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
      {
        if (paramEnumValueDescriptor.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[paramEnumValueDescriptor.getIndex()];
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType()
      {
        return getDescriptor();
      }
      
      public final int getNumber()
      {
        return this.value;
      }
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor()
      {
        return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.index);
      }
    }
    
    public static enum Type
      implements ProtocolMessageEnum
    {
      private static final Type[] VALUES;
      private static Internal.EnumLiteMap<Type> internalValueMap;
      private final int index;
      private final int value;
      
      static
      {
        TYPE_INT32 = new Type("TYPE_INT32", 4, 4, 5);
        TYPE_FIXED64 = new Type("TYPE_FIXED64", 5, 5, 6);
        TYPE_FIXED32 = new Type("TYPE_FIXED32", 6, 6, 7);
        TYPE_BOOL = new Type("TYPE_BOOL", 7, 7, 8);
        TYPE_STRING = new Type("TYPE_STRING", 8, 8, 9);
        TYPE_GROUP = new Type("TYPE_GROUP", 9, 9, 10);
        TYPE_MESSAGE = new Type("TYPE_MESSAGE", 10, 10, 11);
        TYPE_BYTES = new Type("TYPE_BYTES", 11, 11, 12);
        TYPE_UINT32 = new Type("TYPE_UINT32", 12, 12, 13);
        TYPE_ENUM = new Type("TYPE_ENUM", 13, 13, 14);
        TYPE_SFIXED32 = new Type("TYPE_SFIXED32", 14, 14, 15);
        TYPE_SFIXED64 = new Type("TYPE_SFIXED64", 15, 15, 16);
        TYPE_SINT32 = new Type("TYPE_SINT32", 16, 16, 17);
        TYPE_SINT64 = new Type("TYPE_SINT64", 17, 17, 18);
        $VALUES = new Type[] { TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64 };
        internalValueMap = new Internal.EnumLiteMap()
        {
          public DescriptorProtos.FieldDescriptorProto.Type findValueByNumber(int paramAnonymousInt)
          {
            return DescriptorProtos.FieldDescriptorProto.Type.valueOf(paramAnonymousInt);
          }
        };
        VALUES = new Type[] { TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64 };
        DescriptorProtos.getDescriptor();
      }
      
      private Type(int paramInt1, int paramInt2)
      {
        this.index = paramInt1;
        this.value = paramInt2;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)DescriptorProtos.FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<Type> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static Type valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
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
        }
        return TYPE_SINT64;
      }
      
      public static Type valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
      {
        if (paramEnumValueDescriptor.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[paramEnumValueDescriptor.getIndex()];
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType()
      {
        return getDescriptor();
      }
      
      public final int getNumber()
      {
        return this.value;
      }
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor()
      {
        return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.index);
      }
    }
  }
  
  public static final class FieldOptions
    extends GeneratedMessage.ExtendableMessage<FieldOptions>
  {
    public static final int CTYPE_FIELD_NUMBER = 1;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int EXPERIMENTAL_MAP_KEY_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 2;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final FieldOptions defaultInstance = new FieldOptions();
    private CType ctype_ = CType.CORD;
    private boolean deprecated_ = false;
    private String experimentalMapKey_ = "";
    private boolean hasCtype;
    private boolean hasDeprecated;
    private boolean hasExperimentalMapKey;
    private boolean hasPacked;
    private int memoizedSerializedSize = -1;
    private boolean packed_ = false;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static FieldOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$13700();
    }
    
    public static Builder newBuilder(FieldOptions paramFieldOptions)
    {
      return newBuilder().mergeFrom(paramFieldOptions);
    }
    
    public static FieldOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static FieldOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FieldOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static FieldOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FieldOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static FieldOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static FieldOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static FieldOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FieldOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static FieldOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CType getCtype()
    {
      return this.ctype_;
    }
    
    public FieldOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public boolean getDeprecated()
    {
      return this.deprecated_;
    }
    
    public String getExperimentalMapKey()
    {
      return this.experimentalMapKey_;
    }
    
    public boolean getPacked()
    {
      return this.packed_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasCtype()) {
        j = 0 + CodedOutputStream.computeEnumSize(1, getCtype().getNumber());
      }
      i = j;
      if (hasPacked()) {
        i = j + CodedOutputStream.computeBoolSize(2, getPacked());
      }
      j = i;
      if (hasDeprecated()) {
        j = i + CodedOutputStream.computeBoolSize(3, getDeprecated());
      }
      i = j;
      if (hasExperimentalMapKey()) {
        i = j + CodedOutputStream.computeStringSize(9, getExperimentalMapKey());
      }
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = i + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    public boolean hasCtype()
    {
      return this.hasCtype;
    }
    
    public boolean hasDeprecated()
    {
      return this.hasDeprecated;
    }
    
    public boolean hasExperimentalMapKey()
    {
      return this.hasExperimentalMapKey;
    }
    
    public boolean hasPacked()
    {
      return this.hasPacked;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      if (hasCtype()) {
        paramCodedOutputStream.writeEnum(1, getCtype().getNumber());
      }
      if (hasPacked()) {
        paramCodedOutputStream.writeBool(2, getPacked());
      }
      if (hasDeprecated()) {
        paramCodedOutputStream.writeBool(3, getDeprecated());
      }
      if (hasExperimentalMapKey()) {
        paramCodedOutputStream.writeString(9, getExperimentalMapKey());
      }
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FieldOptions, Builder>
    {
      private DescriptorProtos.FieldOptions result;
      
      private DescriptorProtos.FieldOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.FieldOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.FieldOptions.access$13902(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.FieldOptions.access$13902(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.FieldOptions.access$13902(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.FieldOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.FieldOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FieldOptions.access$13902(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.FieldOptions localFieldOptions = this.result;
        this.result = null;
        return localFieldOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.FieldOptions(null);
        return this;
      }
      
      public Builder clearCtype()
      {
        DescriptorProtos.FieldOptions.access$14002(this.result, false);
        DescriptorProtos.FieldOptions.access$14102(this.result, DescriptorProtos.FieldOptions.CType.CORD);
        return this;
      }
      
      public Builder clearDeprecated()
      {
        DescriptorProtos.FieldOptions.access$14402(this.result, false);
        DescriptorProtos.FieldOptions.access$14502(this.result, false);
        return this;
      }
      
      public Builder clearExperimentalMapKey()
      {
        DescriptorProtos.FieldOptions.access$14602(this.result, false);
        DescriptorProtos.FieldOptions.access$14702(this.result, DescriptorProtos.FieldOptions.getDefaultInstance().getExperimentalMapKey());
        return this;
      }
      
      public Builder clearPacked()
      {
        DescriptorProtos.FieldOptions.access$14202(this.result, false);
        DescriptorProtos.FieldOptions.access$14302(this.result, false);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.FieldOptions.access$13902(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.FieldOptions.CType getCtype()
      {
        return this.result.getCtype();
      }
      
      public DescriptorProtos.FieldOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.FieldOptions.getDefaultInstance();
      }
      
      public boolean getDeprecated()
      {
        return this.result.getDeprecated();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.FieldOptions.getDescriptor();
      }
      
      public String getExperimentalMapKey()
      {
        return this.result.getExperimentalMapKey();
      }
      
      public boolean getPacked()
      {
        return this.result.getPacked();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      public boolean hasCtype()
      {
        return this.result.hasCtype();
      }
      
      public boolean hasDeprecated()
      {
        return this.result.hasDeprecated();
      }
      
      public boolean hasExperimentalMapKey()
      {
        return this.result.hasExperimentalMapKey();
      }
      
      public boolean hasPacked()
      {
        return this.result.hasPacked();
      }
      
      protected DescriptorProtos.FieldOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 8: 
            i = paramCodedInputStream.readEnum();
            localObject = DescriptorProtos.FieldOptions.CType.valueOf(i);
            if (localObject == null) {
              localBuilder.mergeVarintField(1, i);
            } else {
              setCtype((DescriptorProtos.FieldOptions.CType)localObject);
            }
            break;
          case 16: 
            setPacked(paramCodedInputStream.readBool());
            break;
          case 24: 
            setDeprecated(paramCodedInputStream.readBool());
            break;
          case 74: 
            setExperimentalMapKey(paramCodedInputStream.readString());
            break;
          case 7994: 
            localObject = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addUninterpretedOption(((DescriptorProtos.UninterpretedOption.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.FieldOptions paramFieldOptions)
      {
        if (paramFieldOptions == DescriptorProtos.FieldOptions.getDefaultInstance()) {
          return this;
        }
        if (paramFieldOptions.hasCtype()) {
          setCtype(paramFieldOptions.getCtype());
        }
        if (paramFieldOptions.hasPacked()) {
          setPacked(paramFieldOptions.getPacked());
        }
        if (paramFieldOptions.hasDeprecated()) {
          setDeprecated(paramFieldOptions.getDeprecated());
        }
        if (paramFieldOptions.hasExperimentalMapKey()) {
          setExperimentalMapKey(paramFieldOptions.getExperimentalMapKey());
        }
        if (!paramFieldOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.FieldOptions.access$13902(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramFieldOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramFieldOptions);
        mergeUnknownFields(paramFieldOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.FieldOptions)) {
          return mergeFrom((DescriptorProtos.FieldOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setCtype(DescriptorProtos.FieldOptions.CType paramCType)
      {
        if (paramCType == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldOptions.access$14002(this.result, true);
        DescriptorProtos.FieldOptions.access$14102(this.result, paramCType);
        return this;
      }
      
      public Builder setDeprecated(boolean paramBoolean)
      {
        DescriptorProtos.FieldOptions.access$14402(this.result, true);
        DescriptorProtos.FieldOptions.access$14502(this.result, paramBoolean);
        return this;
      }
      
      public Builder setExperimentalMapKey(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FieldOptions.access$14602(this.result, true);
        DescriptorProtos.FieldOptions.access$14702(this.result, paramString);
        return this;
      }
      
      public Builder setPacked(boolean paramBoolean)
      {
        DescriptorProtos.FieldOptions.access$14202(this.result, true);
        DescriptorProtos.FieldOptions.access$14302(this.result, paramBoolean);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
    
    public static enum CType
      implements ProtocolMessageEnum
    {
      private static final CType[] VALUES;
      private static Internal.EnumLiteMap<CType> internalValueMap;
      private final int index;
      private final int value;
      
      static
      {
        $VALUES = new CType[] { CORD, STRING_PIECE };
        internalValueMap = new Internal.EnumLiteMap()
        {
          public DescriptorProtos.FieldOptions.CType findValueByNumber(int paramAnonymousInt)
          {
            return DescriptorProtos.FieldOptions.CType.valueOf(paramAnonymousInt);
          }
        };
        VALUES = new CType[] { CORD, STRING_PIECE };
        DescriptorProtos.getDescriptor();
      }
      
      private CType(int paramInt1, int paramInt2)
      {
        this.index = paramInt1;
        this.value = paramInt2;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)DescriptorProtos.FieldOptions.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<CType> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static CType valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return CORD;
        }
        return STRING_PIECE;
      }
      
      public static CType valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
      {
        if (paramEnumValueDescriptor.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[paramEnumValueDescriptor.getIndex()];
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType()
      {
        return getDescriptor();
      }
      
      public final int getNumber()
      {
        return this.value;
      }
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor()
      {
        return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.index);
      }
    }
  }
  
  public static final class FileDescriptorProto
    extends GeneratedMessage
  {
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    public static final int SERVICE_FIELD_NUMBER = 6;
    private static final FileDescriptorProto defaultInstance = new FileDescriptorProto();
    private List<String> dependency_ = Collections.emptyList();
    private List<DescriptorProtos.EnumDescriptorProto> enumType_ = Collections.emptyList();
    private List<DescriptorProtos.FieldDescriptorProto> extension_ = Collections.emptyList();
    private boolean hasName;
    private boolean hasOptions;
    private boolean hasPackage;
    private int memoizedSerializedSize = -1;
    private List<DescriptorProtos.DescriptorProto> messageType_ = Collections.emptyList();
    private String name_ = "";
    private DescriptorProtos.FileOptions options_ = DescriptorProtos.FileOptions.getDefaultInstance();
    private String package_ = "";
    private List<DescriptorProtos.ServiceDescriptorProto> service_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static FileDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$900();
    }
    
    public static Builder newBuilder(FileDescriptorProto paramFileDescriptorProto)
    {
      return newBuilder().mergeFrom(paramFileDescriptorProto);
    }
    
    public static FileDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static FileDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static FileDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public FileDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getDependency(int paramInt)
    {
      return (String)this.dependency_.get(paramInt);
    }
    
    public int getDependencyCount()
    {
      return this.dependency_.size();
    }
    
    public List<String> getDependencyList()
    {
      return this.dependency_;
    }
    
    public DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt)
    {
      return (DescriptorProtos.EnumDescriptorProto)this.enumType_.get(paramInt);
    }
    
    public int getEnumTypeCount()
    {
      return this.enumType_.size();
    }
    
    public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
    {
      return this.enumType_;
    }
    
    public DescriptorProtos.FieldDescriptorProto getExtension(int paramInt)
    {
      return (DescriptorProtos.FieldDescriptorProto)this.extension_.get(paramInt);
    }
    
    public int getExtensionCount()
    {
      return this.extension_.size();
    }
    
    public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
    {
      return this.extension_;
    }
    
    public DescriptorProtos.DescriptorProto getMessageType(int paramInt)
    {
      return (DescriptorProtos.DescriptorProto)this.messageType_.get(paramInt);
    }
    
    public int getMessageTypeCount()
    {
      return this.messageType_.size();
    }
    
    public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
    {
      return this.messageType_;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public DescriptorProtos.FileOptions getOptions()
    {
      return this.options_;
    }
    
    public String getPackage()
    {
      return this.package_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasName()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      int j = i;
      if (hasPackage()) {
        j = i + CodedOutputStream.computeStringSize(2, getPackage());
      }
      i = 0;
      Iterator localIterator = getDependencyList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeStringSizeNoTag((String)localIterator.next());
      }
      i = j + i + getDependencyList().size() * 1;
      localIterator = getMessageTypeList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(4, (DescriptorProtos.DescriptorProto)localIterator.next());
      }
      localIterator = getEnumTypeList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(5, (DescriptorProtos.EnumDescriptorProto)localIterator.next());
      }
      localIterator = getServiceList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(6, (DescriptorProtos.ServiceDescriptorProto)localIterator.next());
      }
      localIterator = getExtensionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(7, (DescriptorProtos.FieldDescriptorProto)localIterator.next());
      }
      j = i;
      if (hasOptions()) {
        j = i + CodedOutputStream.computeMessageSize(8, getOptions());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.ServiceDescriptorProto getService(int paramInt)
    {
      return (DescriptorProtos.ServiceDescriptorProto)this.service_.get(paramInt);
    }
    
    public int getServiceCount()
    {
      return this.service_.size();
    }
    
    public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
    {
      return this.service_;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    public boolean hasPackage()
    {
      return this.hasPackage;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getMessageTypeList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.DescriptorProto)localIterator.next()).isInitialized());
      do
      {
        return false;
        localIterator = getEnumTypeList().iterator();
        while (localIterator.hasNext()) {
          if (!((DescriptorProtos.EnumDescriptorProto)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        localIterator = getServiceList().iterator();
        while (localIterator.hasNext()) {
          if (!((DescriptorProtos.ServiceDescriptorProto)localIterator.next()).isInitialized()) {
            return false;
          }
        }
        localIterator = getExtensionList().iterator();
        while (localIterator.hasNext()) {
          if (!((DescriptorProtos.FieldDescriptorProto)localIterator.next()).isInitialized()) {
            return false;
          }
        }
      } while ((hasOptions()) && (!getOptions().isInitialized()));
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      if (hasPackage()) {
        paramCodedOutputStream.writeString(2, getPackage());
      }
      Iterator localIterator = getDependencyList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeString(3, (String)localIterator.next());
      }
      localIterator = getMessageTypeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(4, (DescriptorProtos.DescriptorProto)localIterator.next());
      }
      localIterator = getEnumTypeList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(5, (DescriptorProtos.EnumDescriptorProto)localIterator.next());
      }
      localIterator = getServiceList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(6, (DescriptorProtos.ServiceDescriptorProto)localIterator.next());
      }
      localIterator = getExtensionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(7, (DescriptorProtos.FieldDescriptorProto)localIterator.next());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(8, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.FileDescriptorProto result;
      
      private DescriptorProtos.FileDescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.FileDescriptorProto(null);
        return localBuilder;
      }
      
      public Builder addAllDependency(Iterable<? extends String> paramIterable)
      {
        if (this.result.dependency_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1102(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.dependency_);
        return this;
      }
      
      public Builder addAllEnumType(Iterable<? extends DescriptorProtos.EnumDescriptorProto> paramIterable)
      {
        if (this.result.enumType_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1302(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.enumType_);
        return this;
      }
      
      public Builder addAllExtension(Iterable<? extends DescriptorProtos.FieldDescriptorProto> paramIterable)
      {
        if (this.result.extension_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.extension_);
        return this;
      }
      
      public Builder addAllMessageType(Iterable<? extends DescriptorProtos.DescriptorProto> paramIterable)
      {
        if (this.result.messageType_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1202(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.messageType_);
        return this;
      }
      
      public Builder addAllService(Iterable<? extends DescriptorProtos.ServiceDescriptorProto> paramIterable)
      {
        if (this.result.service_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1402(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.service_);
        return this;
      }
      
      public Builder addDependency(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        if (this.result.dependency_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1102(this.result, new ArrayList());
        }
        this.result.dependency_.add(paramString);
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto.Builder paramBuilder)
      {
        if (this.result.enumType_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1302(this.result, new ArrayList());
        }
        this.result.enumType_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addEnumType(DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto)
      {
        if (paramEnumDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.enumType_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1302(this.result, new ArrayList());
        }
        this.result.enumType_.add(paramEnumDescriptorProto);
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto.Builder paramBuilder)
      {
        if (this.result.extension_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1502(this.result, new ArrayList());
        }
        this.result.extension_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addExtension(DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.extension_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1502(this.result, new ArrayList());
        }
        this.result.extension_.add(paramFieldDescriptorProto);
        return this;
      }
      
      public Builder addMessageType(DescriptorProtos.DescriptorProto.Builder paramBuilder)
      {
        if (this.result.messageType_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1202(this.result, new ArrayList());
        }
        this.result.messageType_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addMessageType(DescriptorProtos.DescriptorProto paramDescriptorProto)
      {
        if (paramDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.messageType_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1202(this.result, new ArrayList());
        }
        this.result.messageType_.add(paramDescriptorProto);
        return this;
      }
      
      public Builder addService(DescriptorProtos.ServiceDescriptorProto.Builder paramBuilder)
      {
        if (this.result.service_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1402(this.result, new ArrayList());
        }
        this.result.service_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addService(DescriptorProtos.ServiceDescriptorProto paramServiceDescriptorProto)
      {
        if (paramServiceDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.service_.isEmpty()) {
          DescriptorProtos.FileDescriptorProto.access$1402(this.result, new ArrayList());
        }
        this.result.service_.add(paramServiceDescriptorProto);
        return this;
      }
      
      public DescriptorProtos.FileDescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.FileDescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.dependency_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileDescriptorProto.access$1102(this.result, Collections.unmodifiableList(this.result.dependency_));
        }
        if (this.result.messageType_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileDescriptorProto.access$1202(this.result, Collections.unmodifiableList(this.result.messageType_));
        }
        if (this.result.enumType_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileDescriptorProto.access$1302(this.result, Collections.unmodifiableList(this.result.enumType_));
        }
        if (this.result.service_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileDescriptorProto.access$1402(this.result, Collections.unmodifiableList(this.result.service_));
        }
        if (this.result.extension_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileDescriptorProto.access$1502(this.result, Collections.unmodifiableList(this.result.extension_));
        }
        DescriptorProtos.FileDescriptorProto localFileDescriptorProto = this.result;
        this.result = null;
        return localFileDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.FileDescriptorProto(null);
        return this;
      }
      
      public Builder clearDependency()
      {
        DescriptorProtos.FileDescriptorProto.access$1102(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearEnumType()
      {
        DescriptorProtos.FileDescriptorProto.access$1302(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearExtension()
      {
        DescriptorProtos.FileDescriptorProto.access$1502(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearMessageType()
      {
        DescriptorProtos.FileDescriptorProto.access$1202(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.FileDescriptorProto.access$1602(this.result, false);
        DescriptorProtos.FileDescriptorProto.access$1702(this.result, DescriptorProtos.FileDescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.FileDescriptorProto.access$2002(this.result, false);
        DescriptorProtos.FileDescriptorProto.access$2102(this.result, DescriptorProtos.FileOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clearPackage()
      {
        DescriptorProtos.FileDescriptorProto.access$1802(this.result, false);
        DescriptorProtos.FileDescriptorProto.access$1902(this.result, DescriptorProtos.FileDescriptorProto.getDefaultInstance().getPackage());
        return this;
      }
      
      public Builder clearService()
      {
        DescriptorProtos.FileDescriptorProto.access$1402(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.FileDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.FileDescriptorProto.getDefaultInstance();
      }
      
      public String getDependency(int paramInt)
      {
        return this.result.getDependency(paramInt);
      }
      
      public int getDependencyCount()
      {
        return this.result.getDependencyCount();
      }
      
      public List<String> getDependencyList()
      {
        return Collections.unmodifiableList(this.result.dependency_);
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.FileDescriptorProto.getDescriptor();
      }
      
      public DescriptorProtos.EnumDescriptorProto getEnumType(int paramInt)
      {
        return this.result.getEnumType(paramInt);
      }
      
      public int getEnumTypeCount()
      {
        return this.result.getEnumTypeCount();
      }
      
      public List<DescriptorProtos.EnumDescriptorProto> getEnumTypeList()
      {
        return Collections.unmodifiableList(this.result.enumType_);
      }
      
      public DescriptorProtos.FieldDescriptorProto getExtension(int paramInt)
      {
        return this.result.getExtension(paramInt);
      }
      
      public int getExtensionCount()
      {
        return this.result.getExtensionCount();
      }
      
      public List<DescriptorProtos.FieldDescriptorProto> getExtensionList()
      {
        return Collections.unmodifiableList(this.result.extension_);
      }
      
      public DescriptorProtos.DescriptorProto getMessageType(int paramInt)
      {
        return this.result.getMessageType(paramInt);
      }
      
      public int getMessageTypeCount()
      {
        return this.result.getMessageTypeCount();
      }
      
      public List<DescriptorProtos.DescriptorProto> getMessageTypeList()
      {
        return Collections.unmodifiableList(this.result.messageType_);
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public DescriptorProtos.FileOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public String getPackage()
      {
        return this.result.getPackage();
      }
      
      public DescriptorProtos.ServiceDescriptorProto getService(int paramInt)
      {
        return this.result.getService(paramInt);
      }
      
      public int getServiceCount()
      {
        return this.result.getServiceCount();
      }
      
      public List<DescriptorProtos.ServiceDescriptorProto> getServiceList()
      {
        return Collections.unmodifiableList(this.result.service_);
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      public boolean hasPackage()
      {
        return this.result.hasPackage();
      }
      
      protected DescriptorProtos.FileDescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 18: 
            setPackage(paramCodedInputStream.readString());
            break;
          case 26: 
            addDependency(paramCodedInputStream.readString());
            break;
          case 34: 
            localObject = DescriptorProtos.DescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addMessageType(((DescriptorProtos.DescriptorProto.Builder)localObject).buildPartial());
            break;
          case 42: 
            localObject = DescriptorProtos.EnumDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addEnumType(((DescriptorProtos.EnumDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 50: 
            localObject = DescriptorProtos.ServiceDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addService(((DescriptorProtos.ServiceDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 58: 
            localObject = DescriptorProtos.FieldDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addExtension(((DescriptorProtos.FieldDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 66: 
            localObject = DescriptorProtos.FileOptions.newBuilder();
            if (hasOptions()) {
              ((DescriptorProtos.FileOptions.Builder)localObject).mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            setOptions(((DescriptorProtos.FileOptions.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
      {
        if (paramFileDescriptorProto == DescriptorProtos.FileDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramFileDescriptorProto.hasName()) {
          setName(paramFileDescriptorProto.getName());
        }
        if (paramFileDescriptorProto.hasPackage()) {
          setPackage(paramFileDescriptorProto.getPackage());
        }
        if (!paramFileDescriptorProto.dependency_.isEmpty())
        {
          if (this.result.dependency_.isEmpty()) {
            DescriptorProtos.FileDescriptorProto.access$1102(this.result, new ArrayList());
          }
          this.result.dependency_.addAll(paramFileDescriptorProto.dependency_);
        }
        if (!paramFileDescriptorProto.messageType_.isEmpty())
        {
          if (this.result.messageType_.isEmpty()) {
            DescriptorProtos.FileDescriptorProto.access$1202(this.result, new ArrayList());
          }
          this.result.messageType_.addAll(paramFileDescriptorProto.messageType_);
        }
        if (!paramFileDescriptorProto.enumType_.isEmpty())
        {
          if (this.result.enumType_.isEmpty()) {
            DescriptorProtos.FileDescriptorProto.access$1302(this.result, new ArrayList());
          }
          this.result.enumType_.addAll(paramFileDescriptorProto.enumType_);
        }
        if (!paramFileDescriptorProto.service_.isEmpty())
        {
          if (this.result.service_.isEmpty()) {
            DescriptorProtos.FileDescriptorProto.access$1402(this.result, new ArrayList());
          }
          this.result.service_.addAll(paramFileDescriptorProto.service_);
        }
        if (!paramFileDescriptorProto.extension_.isEmpty())
        {
          if (this.result.extension_.isEmpty()) {
            DescriptorProtos.FileDescriptorProto.access$1502(this.result, new ArrayList());
          }
          this.result.extension_.addAll(paramFileDescriptorProto.extension_);
        }
        if (paramFileDescriptorProto.hasOptions()) {
          mergeOptions(paramFileDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramFileDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.FileDescriptorProto)) {
          return mergeFrom((DescriptorProtos.FileDescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.FileOptions paramFileOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.FileOptions.getDefaultInstance())) {
          DescriptorProtos.FileDescriptorProto.access$2102(this.result, DescriptorProtos.FileOptions.newBuilder(this.result.options_).mergeFrom(paramFileOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.FileDescriptorProto.access$2002(this.result, true);
          return this;
          DescriptorProtos.FileDescriptorProto.access$2102(this.result, paramFileOptions);
        }
      }
      
      public Builder setDependency(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.result.dependency_.set(paramInt, paramString);
        return this;
      }
      
      public Builder setEnumType(int paramInt, DescriptorProtos.EnumDescriptorProto.Builder paramBuilder)
      {
        this.result.enumType_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setEnumType(int paramInt, DescriptorProtos.EnumDescriptorProto paramEnumDescriptorProto)
      {
        if (paramEnumDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.enumType_.set(paramInt, paramEnumDescriptorProto);
        return this;
      }
      
      public Builder setExtension(int paramInt, DescriptorProtos.FieldDescriptorProto.Builder paramBuilder)
      {
        this.result.extension_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setExtension(int paramInt, DescriptorProtos.FieldDescriptorProto paramFieldDescriptorProto)
      {
        if (paramFieldDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.extension_.set(paramInt, paramFieldDescriptorProto);
        return this;
      }
      
      public Builder setMessageType(int paramInt, DescriptorProtos.DescriptorProto.Builder paramBuilder)
      {
        this.result.messageType_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setMessageType(int paramInt, DescriptorProtos.DescriptorProto paramDescriptorProto)
      {
        if (paramDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.messageType_.set(paramInt, paramDescriptorProto);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FileDescriptorProto.access$1602(this.result, true);
        DescriptorProtos.FileDescriptorProto.access$1702(this.result, paramString);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.FileOptions.Builder paramBuilder)
      {
        DescriptorProtos.FileDescriptorProto.access$2002(this.result, true);
        DescriptorProtos.FileDescriptorProto.access$2102(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.FileOptions paramFileOptions)
      {
        if (paramFileOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FileDescriptorProto.access$2002(this.result, true);
        DescriptorProtos.FileDescriptorProto.access$2102(this.result, paramFileOptions);
        return this;
      }
      
      public Builder setPackage(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FileDescriptorProto.access$1802(this.result, true);
        DescriptorProtos.FileDescriptorProto.access$1902(this.result, paramString);
        return this;
      }
      
      public Builder setService(int paramInt, DescriptorProtos.ServiceDescriptorProto.Builder paramBuilder)
      {
        this.result.service_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setService(int paramInt, DescriptorProtos.ServiceDescriptorProto paramServiceDescriptorProto)
      {
        if (paramServiceDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.service_.set(paramInt, paramServiceDescriptorProto);
        return this;
      }
    }
  }
  
  public static final class FileDescriptorSet
    extends GeneratedMessage
  {
    public static final int FILE_FIELD_NUMBER = 1;
    private static final FileDescriptorSet defaultInstance = new FileDescriptorSet();
    private List<DescriptorProtos.FileDescriptorProto> file_ = Collections.emptyList();
    private int memoizedSerializedSize = -1;
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static FileDescriptorSet getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(FileDescriptorSet paramFileDescriptorSet)
    {
      return newBuilder().mergeFrom(paramFileDescriptorSet);
    }
    
    public static FileDescriptorSet parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static FileDescriptorSet parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static FileDescriptorSet parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public FileDescriptorSet getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public DescriptorProtos.FileDescriptorProto getFile(int paramInt)
    {
      return (DescriptorProtos.FileDescriptorProto)this.file_.get(paramInt);
    }
    
    public int getFileCount()
    {
      return this.file_.size();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getFileList()
    {
      return this.file_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      Iterator localIterator = getFileList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(1, (DescriptorProtos.FileDescriptorProto)localIterator.next());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getFileList().iterator();
      while (localIterator.hasNext()) {
        if (!((DescriptorProtos.FileDescriptorProto)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      Iterator localIterator = getFileList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(1, (DescriptorProtos.FileDescriptorProto)localIterator.next());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.FileDescriptorSet result;
      
      private DescriptorProtos.FileDescriptorSet buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.FileDescriptorSet(null);
        return localBuilder;
      }
      
      public Builder addAllFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> paramIterable)
      {
        if (this.result.file_.isEmpty()) {
          DescriptorProtos.FileDescriptorSet.access$502(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.file_);
        return this;
      }
      
      public Builder addFile(DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
      {
        if (this.result.file_.isEmpty()) {
          DescriptorProtos.FileDescriptorSet.access$502(this.result, new ArrayList());
        }
        this.result.file_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addFile(DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
      {
        if (paramFileDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.file_.isEmpty()) {
          DescriptorProtos.FileDescriptorSet.access$502(this.result, new ArrayList());
        }
        this.result.file_.add(paramFileDescriptorProto);
        return this;
      }
      
      public DescriptorProtos.FileDescriptorSet build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.FileDescriptorSet buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.file_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileDescriptorSet.access$502(this.result, Collections.unmodifiableList(this.result.file_));
        }
        DescriptorProtos.FileDescriptorSet localFileDescriptorSet = this.result;
        this.result = null;
        return localFileDescriptorSet;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.FileDescriptorSet(null);
        return this;
      }
      
      public Builder clearFile()
      {
        DescriptorProtos.FileDescriptorSet.access$502(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.FileDescriptorSet getDefaultInstanceForType()
      {
        return DescriptorProtos.FileDescriptorSet.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.FileDescriptorSet.getDescriptor();
      }
      
      public DescriptorProtos.FileDescriptorProto getFile(int paramInt)
      {
        return this.result.getFile(paramInt);
      }
      
      public int getFileCount()
      {
        return this.result.getFileCount();
      }
      
      public List<DescriptorProtos.FileDescriptorProto> getFileList()
      {
        return Collections.unmodifiableList(this.result.file_);
      }
      
      protected DescriptorProtos.FileDescriptorSet internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            DescriptorProtos.FileDescriptorProto.Builder localBuilder1 = DescriptorProtos.FileDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addFile(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.FileDescriptorSet paramFileDescriptorSet)
      {
        if (paramFileDescriptorSet == DescriptorProtos.FileDescriptorSet.getDefaultInstance()) {
          return this;
        }
        if (!paramFileDescriptorSet.file_.isEmpty())
        {
          if (this.result.file_.isEmpty()) {
            DescriptorProtos.FileDescriptorSet.access$502(this.result, new ArrayList());
          }
          this.result.file_.addAll(paramFileDescriptorSet.file_);
        }
        mergeUnknownFields(paramFileDescriptorSet.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.FileDescriptorSet)) {
          return mergeFrom((DescriptorProtos.FileDescriptorSet)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFile(int paramInt, DescriptorProtos.FileDescriptorProto.Builder paramBuilder)
      {
        this.result.file_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setFile(int paramInt, DescriptorProtos.FileDescriptorProto paramFileDescriptorProto)
      {
        if (paramFileDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.file_.set(paramInt, paramFileDescriptorProto);
        return this;
      }
    }
  }
  
  public static final class FileOptions
    extends GeneratedMessage.ExtendableMessage<FileOptions>
  {
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
    private boolean javaMultipleFiles_ = false;
    private String javaOuterClassname_ = "";
    private String javaPackage_ = "";
    private int memoizedSerializedSize = -1;
    private OptimizeMode optimizeFor_ = OptimizeMode.SPEED;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static FileOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$11300();
    }
    
    public static Builder newBuilder(FileOptions paramFileOptions)
    {
      return newBuilder().mergeFrom(paramFileOptions);
    }
    
    public static FileOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static FileOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static FileOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static FileOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static FileOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static FileOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static FileOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static FileOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public FileOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public boolean getJavaMultipleFiles()
    {
      return this.javaMultipleFiles_;
    }
    
    public String getJavaOuterClassname()
    {
      return this.javaOuterClassname_;
    }
    
    public String getJavaPackage()
    {
      return this.javaPackage_;
    }
    
    public OptimizeMode getOptimizeFor()
    {
      return this.optimizeFor_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasJavaPackage()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getJavaPackage());
      }
      i = j;
      if (hasJavaOuterClassname()) {
        i = j + CodedOutputStream.computeStringSize(8, getJavaOuterClassname());
      }
      j = i;
      if (hasOptimizeFor()) {
        j = i + CodedOutputStream.computeEnumSize(9, getOptimizeFor().getNumber());
      }
      i = j;
      if (hasJavaMultipleFiles()) {
        i = j + CodedOutputStream.computeBoolSize(10, getJavaMultipleFiles());
      }
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = i + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    public boolean hasJavaMultipleFiles()
    {
      return this.hasJavaMultipleFiles;
    }
    
    public boolean hasJavaOuterClassname()
    {
      return this.hasJavaOuterClassname;
    }
    
    public boolean hasJavaPackage()
    {
      return this.hasJavaPackage;
    }
    
    public boolean hasOptimizeFor()
    {
      return this.hasOptimizeFor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      if (hasJavaPackage()) {
        paramCodedOutputStream.writeString(1, getJavaPackage());
      }
      if (hasJavaOuterClassname()) {
        paramCodedOutputStream.writeString(8, getJavaOuterClassname());
      }
      if (hasOptimizeFor()) {
        paramCodedOutputStream.writeEnum(9, getOptimizeFor().getNumber());
      }
      if (hasJavaMultipleFiles()) {
        paramCodedOutputStream.writeBool(10, getJavaMultipleFiles());
      }
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.FileOptions, Builder>
    {
      private DescriptorProtos.FileOptions result;
      
      private DescriptorProtos.FileOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.FileOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.FileOptions.access$11502(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.FileOptions.access$11502(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.FileOptions.access$11502(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.FileOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.FileOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.FileOptions.access$11502(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.FileOptions localFileOptions = this.result;
        this.result = null;
        return localFileOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.FileOptions(null);
        return this;
      }
      
      public Builder clearJavaMultipleFiles()
      {
        DescriptorProtos.FileOptions.access$12002(this.result, false);
        DescriptorProtos.FileOptions.access$12102(this.result, false);
        return this;
      }
      
      public Builder clearJavaOuterClassname()
      {
        DescriptorProtos.FileOptions.access$11802(this.result, false);
        DescriptorProtos.FileOptions.access$11902(this.result, DescriptorProtos.FileOptions.getDefaultInstance().getJavaOuterClassname());
        return this;
      }
      
      public Builder clearJavaPackage()
      {
        DescriptorProtos.FileOptions.access$11602(this.result, false);
        DescriptorProtos.FileOptions.access$11702(this.result, DescriptorProtos.FileOptions.getDefaultInstance().getJavaPackage());
        return this;
      }
      
      public Builder clearOptimizeFor()
      {
        DescriptorProtos.FileOptions.access$12202(this.result, false);
        DescriptorProtos.FileOptions.access$12302(this.result, DescriptorProtos.FileOptions.OptimizeMode.SPEED);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.FileOptions.access$11502(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.FileOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.FileOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.FileOptions.getDescriptor();
      }
      
      public boolean getJavaMultipleFiles()
      {
        return this.result.getJavaMultipleFiles();
      }
      
      public String getJavaOuterClassname()
      {
        return this.result.getJavaOuterClassname();
      }
      
      public String getJavaPackage()
      {
        return this.result.getJavaPackage();
      }
      
      public DescriptorProtos.FileOptions.OptimizeMode getOptimizeFor()
      {
        return this.result.getOptimizeFor();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      public boolean hasJavaMultipleFiles()
      {
        return this.result.hasJavaMultipleFiles();
      }
      
      public boolean hasJavaOuterClassname()
      {
        return this.result.hasJavaOuterClassname();
      }
      
      public boolean hasJavaPackage()
      {
        return this.result.hasJavaPackage();
      }
      
      public boolean hasOptimizeFor()
      {
        return this.result.hasOptimizeFor();
      }
      
      protected DescriptorProtos.FileOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setJavaPackage(paramCodedInputStream.readString());
            break;
          case 66: 
            setJavaOuterClassname(paramCodedInputStream.readString());
            break;
          case 72: 
            i = paramCodedInputStream.readEnum();
            localObject = DescriptorProtos.FileOptions.OptimizeMode.valueOf(i);
            if (localObject == null) {
              localBuilder.mergeVarintField(9, i);
            } else {
              setOptimizeFor((DescriptorProtos.FileOptions.OptimizeMode)localObject);
            }
            break;
          case 80: 
            setJavaMultipleFiles(paramCodedInputStream.readBool());
            break;
          case 7994: 
            localObject = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addUninterpretedOption(((DescriptorProtos.UninterpretedOption.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.FileOptions paramFileOptions)
      {
        if (paramFileOptions == DescriptorProtos.FileOptions.getDefaultInstance()) {
          return this;
        }
        if (paramFileOptions.hasJavaPackage()) {
          setJavaPackage(paramFileOptions.getJavaPackage());
        }
        if (paramFileOptions.hasJavaOuterClassname()) {
          setJavaOuterClassname(paramFileOptions.getJavaOuterClassname());
        }
        if (paramFileOptions.hasJavaMultipleFiles()) {
          setJavaMultipleFiles(paramFileOptions.getJavaMultipleFiles());
        }
        if (paramFileOptions.hasOptimizeFor()) {
          setOptimizeFor(paramFileOptions.getOptimizeFor());
        }
        if (!paramFileOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.FileOptions.access$11502(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramFileOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramFileOptions);
        mergeUnknownFields(paramFileOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.FileOptions)) {
          return mergeFrom((DescriptorProtos.FileOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setJavaMultipleFiles(boolean paramBoolean)
      {
        DescriptorProtos.FileOptions.access$12002(this.result, true);
        DescriptorProtos.FileOptions.access$12102(this.result, paramBoolean);
        return this;
      }
      
      public Builder setJavaOuterClassname(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FileOptions.access$11802(this.result, true);
        DescriptorProtos.FileOptions.access$11902(this.result, paramString);
        return this;
      }
      
      public Builder setJavaPackage(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FileOptions.access$11602(this.result, true);
        DescriptorProtos.FileOptions.access$11702(this.result, paramString);
        return this;
      }
      
      public Builder setOptimizeFor(DescriptorProtos.FileOptions.OptimizeMode paramOptimizeMode)
      {
        if (paramOptimizeMode == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.FileOptions.access$12202(this.result, true);
        DescriptorProtos.FileOptions.access$12302(this.result, paramOptimizeMode);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
    
    public static enum OptimizeMode
      implements ProtocolMessageEnum
    {
      private static final OptimizeMode[] VALUES;
      private static Internal.EnumLiteMap<OptimizeMode> internalValueMap;
      private final int index;
      private final int value;
      
      static
      {
        CODE_SIZE = new OptimizeMode("CODE_SIZE", 1, 1, 2);
        LITE_RUNTIME = new OptimizeMode("LITE_RUNTIME", 2, 2, 3);
        $VALUES = new OptimizeMode[] { SPEED, CODE_SIZE, LITE_RUNTIME };
        internalValueMap = new Internal.EnumLiteMap()
        {
          public DescriptorProtos.FileOptions.OptimizeMode findValueByNumber(int paramAnonymousInt)
          {
            return DescriptorProtos.FileOptions.OptimizeMode.valueOf(paramAnonymousInt);
          }
        };
        VALUES = new OptimizeMode[] { SPEED, CODE_SIZE, LITE_RUNTIME };
        DescriptorProtos.getDescriptor();
      }
      
      private OptimizeMode(int paramInt1, int paramInt2)
      {
        this.index = paramInt1;
        this.value = paramInt2;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor()
      {
        return (Descriptors.EnumDescriptor)DescriptorProtos.FileOptions.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap()
      {
        return internalValueMap;
      }
      
      public static OptimizeMode valueOf(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return null;
        case 1: 
          return SPEED;
        case 2: 
          return CODE_SIZE;
        }
        return LITE_RUNTIME;
      }
      
      public static OptimizeMode valueOf(Descriptors.EnumValueDescriptor paramEnumValueDescriptor)
      {
        if (paramEnumValueDescriptor.getType() != getDescriptor()) {
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
        return VALUES[paramEnumValueDescriptor.getIndex()];
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType()
      {
        return getDescriptor();
      }
      
      public final int getNumber()
      {
        return this.value;
      }
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor()
      {
        return (Descriptors.EnumValueDescriptor)getDescriptor().getValues().get(this.index);
      }
    }
  }
  
  public static final class MessageOptions
    extends GeneratedMessage.ExtendableMessage<MessageOptions>
  {
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final MessageOptions defaultInstance = new MessageOptions();
    private boolean hasMessageSetWireFormat;
    private boolean hasNoStandardDescriptorAccessor;
    private int memoizedSerializedSize = -1;
    private boolean messageSetWireFormat_ = false;
    private boolean noStandardDescriptorAccessor_ = false;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static MessageOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$12700();
    }
    
    public static Builder newBuilder(MessageOptions paramMessageOptions)
    {
      return newBuilder().mergeFrom(paramMessageOptions);
    }
    
    public static MessageOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static MessageOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MessageOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static MessageOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MessageOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static MessageOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static MessageOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static MessageOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MessageOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static MessageOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public MessageOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public boolean getMessageSetWireFormat()
    {
      return this.messageSetWireFormat_;
    }
    
    public boolean getNoStandardDescriptorAccessor()
    {
      return this.noStandardDescriptorAccessor_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasMessageSetWireFormat()) {
        i = 0 + CodedOutputStream.computeBoolSize(1, getMessageSetWireFormat());
      }
      int j = i;
      if (hasNoStandardDescriptorAccessor()) {
        j = i + CodedOutputStream.computeBoolSize(2, getNoStandardDescriptorAccessor());
      }
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        j += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = j + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    public boolean hasMessageSetWireFormat()
    {
      return this.hasMessageSetWireFormat;
    }
    
    public boolean hasNoStandardDescriptorAccessor()
    {
      return this.hasNoStandardDescriptorAccessor;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_MessageOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      if (hasMessageSetWireFormat()) {
        paramCodedOutputStream.writeBool(1, getMessageSetWireFormat());
      }
      if (hasNoStandardDescriptorAccessor()) {
        paramCodedOutputStream.writeBool(2, getNoStandardDescriptorAccessor());
      }
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.MessageOptions, Builder>
    {
      private DescriptorProtos.MessageOptions result;
      
      private DescriptorProtos.MessageOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.MessageOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.MessageOptions.access$12902(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.MessageOptions.access$12902(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.MessageOptions.access$12902(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.MessageOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.MessageOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.MessageOptions.access$12902(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.MessageOptions localMessageOptions = this.result;
        this.result = null;
        return localMessageOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.MessageOptions(null);
        return this;
      }
      
      public Builder clearMessageSetWireFormat()
      {
        DescriptorProtos.MessageOptions.access$13002(this.result, false);
        DescriptorProtos.MessageOptions.access$13102(this.result, false);
        return this;
      }
      
      public Builder clearNoStandardDescriptorAccessor()
      {
        DescriptorProtos.MessageOptions.access$13202(this.result, false);
        DescriptorProtos.MessageOptions.access$13302(this.result, false);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.MessageOptions.access$12902(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.MessageOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.MessageOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.MessageOptions.getDescriptor();
      }
      
      public boolean getMessageSetWireFormat()
      {
        return this.result.getMessageSetWireFormat();
      }
      
      public boolean getNoStandardDescriptorAccessor()
      {
        return this.result.getNoStandardDescriptorAccessor();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      public boolean hasMessageSetWireFormat()
      {
        return this.result.hasMessageSetWireFormat();
      }
      
      public boolean hasNoStandardDescriptorAccessor()
      {
        return this.result.hasNoStandardDescriptorAccessor();
      }
      
      protected DescriptorProtos.MessageOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 8: 
            setMessageSetWireFormat(paramCodedInputStream.readBool());
            break;
          case 16: 
            setNoStandardDescriptorAccessor(paramCodedInputStream.readBool());
            break;
          case 7994: 
            DescriptorProtos.UninterpretedOption.Builder localBuilder1 = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addUninterpretedOption(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.MessageOptions paramMessageOptions)
      {
        if (paramMessageOptions == DescriptorProtos.MessageOptions.getDefaultInstance()) {
          return this;
        }
        if (paramMessageOptions.hasMessageSetWireFormat()) {
          setMessageSetWireFormat(paramMessageOptions.getMessageSetWireFormat());
        }
        if (paramMessageOptions.hasNoStandardDescriptorAccessor()) {
          setNoStandardDescriptorAccessor(paramMessageOptions.getNoStandardDescriptorAccessor());
        }
        if (!paramMessageOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.MessageOptions.access$12902(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramMessageOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramMessageOptions);
        mergeUnknownFields(paramMessageOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.MessageOptions)) {
          return mergeFrom((DescriptorProtos.MessageOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setMessageSetWireFormat(boolean paramBoolean)
      {
        DescriptorProtos.MessageOptions.access$13002(this.result, true);
        DescriptorProtos.MessageOptions.access$13102(this.result, paramBoolean);
        return this;
      }
      
      public Builder setNoStandardDescriptorAccessor(boolean paramBoolean)
      {
        DescriptorProtos.MessageOptions.access$13202(this.result, true);
        DescriptorProtos.MessageOptions.access$13302(this.result, paramBoolean);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
  }
  
  public static final class MethodDescriptorProto
    extends GeneratedMessage
  {
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private static final MethodDescriptorProto defaultInstance = new MethodDescriptorProto();
    private boolean hasInputType;
    private boolean hasName;
    private boolean hasOptions;
    private boolean hasOutputType;
    private String inputType_ = "";
    private int memoizedSerializedSize = -1;
    private String name_ = "";
    private DescriptorProtos.MethodOptions options_ = DescriptorProtos.MethodOptions.getDefaultInstance();
    private String outputType_ = "";
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static MethodDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$10000();
    }
    
    public static Builder newBuilder(MethodDescriptorProto paramMethodDescriptorProto)
    {
      return newBuilder().mergeFrom(paramMethodDescriptorProto);
    }
    
    public static MethodDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static MethodDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static MethodDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public MethodDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getInputType()
    {
      return this.inputType_;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public DescriptorProtos.MethodOptions getOptions()
    {
      return this.options_;
    }
    
    public String getOutputType()
    {
      return this.outputType_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasName()) {
        j = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      i = j;
      if (hasInputType()) {
        i = j + CodedOutputStream.computeStringSize(2, getInputType());
      }
      j = i;
      if (hasOutputType()) {
        j = i + CodedOutputStream.computeStringSize(3, getOutputType());
      }
      i = j;
      if (hasOptions()) {
        i = j + CodedOutputStream.computeMessageSize(4, getOptions());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasInputType()
    {
      return this.hasInputType;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    public boolean hasOutputType()
    {
      return this.hasOutputType;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return (!hasOptions()) || (getOptions().isInitialized());
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      if (hasInputType()) {
        paramCodedOutputStream.writeString(2, getInputType());
      }
      if (hasOutputType()) {
        paramCodedOutputStream.writeString(3, getOutputType());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(4, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.MethodDescriptorProto result;
      
      private DescriptorProtos.MethodDescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.MethodDescriptorProto(null);
        return localBuilder;
      }
      
      public DescriptorProtos.MethodDescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.MethodDescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        DescriptorProtos.MethodDescriptorProto localMethodDescriptorProto = this.result;
        this.result = null;
        return localMethodDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.MethodDescriptorProto(null);
        return this;
      }
      
      public Builder clearInputType()
      {
        DescriptorProtos.MethodDescriptorProto.access$10402(this.result, false);
        DescriptorProtos.MethodDescriptorProto.access$10502(this.result, DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getInputType());
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.MethodDescriptorProto.access$10202(this.result, false);
        DescriptorProtos.MethodDescriptorProto.access$10302(this.result, DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.MethodDescriptorProto.access$10802(this.result, false);
        DescriptorProtos.MethodDescriptorProto.access$10902(this.result, DescriptorProtos.MethodOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clearOutputType()
      {
        DescriptorProtos.MethodDescriptorProto.access$10602(this.result, false);
        DescriptorProtos.MethodDescriptorProto.access$10702(this.result, DescriptorProtos.MethodDescriptorProto.getDefaultInstance().getOutputType());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.MethodDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.MethodDescriptorProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.MethodDescriptorProto.getDescriptor();
      }
      
      public String getInputType()
      {
        return this.result.getInputType();
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public DescriptorProtos.MethodOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public String getOutputType()
      {
        return this.result.getOutputType();
      }
      
      public boolean hasInputType()
      {
        return this.result.hasInputType();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      public boolean hasOutputType()
      {
        return this.result.hasOutputType();
      }
      
      protected DescriptorProtos.MethodDescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 18: 
            setInputType(paramCodedInputStream.readString());
            break;
          case 26: 
            setOutputType(paramCodedInputStream.readString());
            break;
          case 34: 
            DescriptorProtos.MethodOptions.Builder localBuilder1 = DescriptorProtos.MethodOptions.newBuilder();
            if (hasOptions()) {
              localBuilder1.mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            setOptions(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.MethodDescriptorProto paramMethodDescriptorProto)
      {
        if (paramMethodDescriptorProto == DescriptorProtos.MethodDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramMethodDescriptorProto.hasName()) {
          setName(paramMethodDescriptorProto.getName());
        }
        if (paramMethodDescriptorProto.hasInputType()) {
          setInputType(paramMethodDescriptorProto.getInputType());
        }
        if (paramMethodDescriptorProto.hasOutputType()) {
          setOutputType(paramMethodDescriptorProto.getOutputType());
        }
        if (paramMethodDescriptorProto.hasOptions()) {
          mergeOptions(paramMethodDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramMethodDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.MethodDescriptorProto)) {
          return mergeFrom((DescriptorProtos.MethodDescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.MethodOptions paramMethodOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.MethodOptions.getDefaultInstance())) {
          DescriptorProtos.MethodDescriptorProto.access$10902(this.result, DescriptorProtos.MethodOptions.newBuilder(this.result.options_).mergeFrom(paramMethodOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.MethodDescriptorProto.access$10802(this.result, true);
          return this;
          DescriptorProtos.MethodDescriptorProto.access$10902(this.result, paramMethodOptions);
        }
      }
      
      public Builder setInputType(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.MethodDescriptorProto.access$10402(this.result, true);
        DescriptorProtos.MethodDescriptorProto.access$10502(this.result, paramString);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.MethodDescriptorProto.access$10202(this.result, true);
        DescriptorProtos.MethodDescriptorProto.access$10302(this.result, paramString);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.MethodOptions.Builder paramBuilder)
      {
        DescriptorProtos.MethodDescriptorProto.access$10802(this.result, true);
        DescriptorProtos.MethodDescriptorProto.access$10902(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.MethodOptions paramMethodOptions)
      {
        if (paramMethodOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.MethodDescriptorProto.access$10802(this.result, true);
        DescriptorProtos.MethodDescriptorProto.access$10902(this.result, paramMethodOptions);
        return this;
      }
      
      public Builder setOutputType(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.MethodDescriptorProto.access$10602(this.result, true);
        DescriptorProtos.MethodDescriptorProto.access$10702(this.result, paramString);
        return this;
      }
    }
  }
  
  public static final class MethodOptions
    extends GeneratedMessage.ExtendableMessage<MethodOptions>
  {
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final MethodOptions defaultInstance = new MethodOptions();
    private int memoizedSerializedSize = -1;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static MethodOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$16900();
    }
    
    public static Builder newBuilder(MethodOptions paramMethodOptions)
    {
      return newBuilder().mergeFrom(paramMethodOptions);
    }
    
    public static MethodOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static MethodOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MethodOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static MethodOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MethodOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static MethodOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static MethodOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static MethodOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static MethodOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static MethodOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public MethodOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = i + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.MethodOptions, Builder>
    {
      private DescriptorProtos.MethodOptions result;
      
      private DescriptorProtos.MethodOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.MethodOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.MethodOptions.access$17102(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.MethodOptions.access$17102(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.MethodOptions.access$17102(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.MethodOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.MethodOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.MethodOptions.access$17102(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.MethodOptions localMethodOptions = this.result;
        this.result = null;
        return localMethodOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.MethodOptions(null);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.MethodOptions.access$17102(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.MethodOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.MethodOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.MethodOptions.getDescriptor();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      protected DescriptorProtos.MethodOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 7994: 
            DescriptorProtos.UninterpretedOption.Builder localBuilder1 = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addUninterpretedOption(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.MethodOptions paramMethodOptions)
      {
        if (paramMethodOptions == DescriptorProtos.MethodOptions.getDefaultInstance()) {
          return this;
        }
        if (!paramMethodOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.MethodOptions.access$17102(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramMethodOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramMethodOptions);
        mergeUnknownFields(paramMethodOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.MethodOptions)) {
          return mergeFrom((DescriptorProtos.MethodOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
  }
  
  public static final class ServiceDescriptorProto
    extends GeneratedMessage
  {
    public static final int METHOD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final ServiceDescriptorProto defaultInstance = new ServiceDescriptorProto();
    private boolean hasName;
    private boolean hasOptions;
    private int memoizedSerializedSize = -1;
    private List<DescriptorProtos.MethodDescriptorProto> method_ = Collections.emptyList();
    private String name_ = "";
    private DescriptorProtos.ServiceOptions options_ = DescriptorProtos.ServiceOptions.getDefaultInstance();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static ServiceDescriptorProto getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$9000();
    }
    
    public static Builder newBuilder(ServiceDescriptorProto paramServiceDescriptorProto)
    {
      return newBuilder().mergeFrom(paramServiceDescriptorProto);
    }
    
    public static ServiceDescriptorProto parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static ServiceDescriptorProto parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public ServiceDescriptorProto getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public DescriptorProtos.MethodDescriptorProto getMethod(int paramInt)
    {
      return (DescriptorProtos.MethodDescriptorProto)this.method_.get(paramInt);
    }
    
    public int getMethodCount()
    {
      return this.method_.size();
    }
    
    public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
    {
      return this.method_;
    }
    
    public String getName()
    {
      return this.name_;
    }
    
    public DescriptorProtos.ServiceOptions getOptions()
    {
      return this.options_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasName()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getName());
      }
      Iterator localIterator = getMethodList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(2, (DescriptorProtos.MethodDescriptorProto)localIterator.next());
      }
      int j = i;
      if (hasOptions()) {
        j = i + CodedOutputStream.computeMessageSize(3, getOptions());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasName()
    {
      return this.hasName;
    }
    
    public boolean hasOptions()
    {
      return this.hasOptions;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getMethodList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.MethodDescriptorProto)localIterator.next()).isInitialized());
      while ((hasOptions()) && (!getOptions().isInitialized())) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      if (hasName()) {
        paramCodedOutputStream.writeString(1, getName());
      }
      Iterator localIterator = getMethodList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (DescriptorProtos.MethodDescriptorProto)localIterator.next());
      }
      if (hasOptions()) {
        paramCodedOutputStream.writeMessage(3, getOptions());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.ServiceDescriptorProto result;
      
      private DescriptorProtos.ServiceDescriptorProto buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.ServiceDescriptorProto(null);
        return localBuilder;
      }
      
      public Builder addAllMethod(Iterable<? extends DescriptorProtos.MethodDescriptorProto> paramIterable)
      {
        if (this.result.method_.isEmpty()) {
          DescriptorProtos.ServiceDescriptorProto.access$9202(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.method_);
        return this;
      }
      
      public Builder addMethod(DescriptorProtos.MethodDescriptorProto.Builder paramBuilder)
      {
        if (this.result.method_.isEmpty()) {
          DescriptorProtos.ServiceDescriptorProto.access$9202(this.result, new ArrayList());
        }
        this.result.method_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addMethod(DescriptorProtos.MethodDescriptorProto paramMethodDescriptorProto)
      {
        if (paramMethodDescriptorProto == null) {
          throw new NullPointerException();
        }
        if (this.result.method_.isEmpty()) {
          DescriptorProtos.ServiceDescriptorProto.access$9202(this.result, new ArrayList());
        }
        this.result.method_.add(paramMethodDescriptorProto);
        return this;
      }
      
      public DescriptorProtos.ServiceDescriptorProto build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.ServiceDescriptorProto buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.method_ != Collections.EMPTY_LIST) {
          DescriptorProtos.ServiceDescriptorProto.access$9202(this.result, Collections.unmodifiableList(this.result.method_));
        }
        DescriptorProtos.ServiceDescriptorProto localServiceDescriptorProto = this.result;
        this.result = null;
        return localServiceDescriptorProto;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.ServiceDescriptorProto(null);
        return this;
      }
      
      public Builder clearMethod()
      {
        DescriptorProtos.ServiceDescriptorProto.access$9202(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.ServiceDescriptorProto.access$9302(this.result, false);
        DescriptorProtos.ServiceDescriptorProto.access$9402(this.result, DescriptorProtos.ServiceDescriptorProto.getDefaultInstance().getName());
        return this;
      }
      
      public Builder clearOptions()
      {
        DescriptorProtos.ServiceDescriptorProto.access$9502(this.result, false);
        DescriptorProtos.ServiceDescriptorProto.access$9602(this.result, DescriptorProtos.ServiceOptions.getDefaultInstance());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.ServiceDescriptorProto getDefaultInstanceForType()
      {
        return DescriptorProtos.ServiceDescriptorProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.ServiceDescriptorProto.getDescriptor();
      }
      
      public DescriptorProtos.MethodDescriptorProto getMethod(int paramInt)
      {
        return this.result.getMethod(paramInt);
      }
      
      public int getMethodCount()
      {
        return this.result.getMethodCount();
      }
      
      public List<DescriptorProtos.MethodDescriptorProto> getMethodList()
      {
        return Collections.unmodifiableList(this.result.method_);
      }
      
      public String getName()
      {
        return this.result.getName();
      }
      
      public DescriptorProtos.ServiceOptions getOptions()
      {
        return this.result.getOptions();
      }
      
      public boolean hasName()
      {
        return this.result.hasName();
      }
      
      public boolean hasOptions()
      {
        return this.result.hasOptions();
      }
      
      protected DescriptorProtos.ServiceDescriptorProto internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          Object localObject;
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 10: 
            setName(paramCodedInputStream.readString());
            break;
          case 18: 
            localObject = DescriptorProtos.MethodDescriptorProto.newBuilder();
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            addMethod(((DescriptorProtos.MethodDescriptorProto.Builder)localObject).buildPartial());
            break;
          case 26: 
            localObject = DescriptorProtos.ServiceOptions.newBuilder();
            if (hasOptions()) {
              ((DescriptorProtos.ServiceOptions.Builder)localObject).mergeFrom(getOptions());
            }
            paramCodedInputStream.readMessage((MessageLite.Builder)localObject, paramExtensionRegistryLite);
            setOptions(((DescriptorProtos.ServiceOptions.Builder)localObject).buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.ServiceDescriptorProto paramServiceDescriptorProto)
      {
        if (paramServiceDescriptorProto == DescriptorProtos.ServiceDescriptorProto.getDefaultInstance()) {
          return this;
        }
        if (paramServiceDescriptorProto.hasName()) {
          setName(paramServiceDescriptorProto.getName());
        }
        if (!paramServiceDescriptorProto.method_.isEmpty())
        {
          if (this.result.method_.isEmpty()) {
            DescriptorProtos.ServiceDescriptorProto.access$9202(this.result, new ArrayList());
          }
          this.result.method_.addAll(paramServiceDescriptorProto.method_);
        }
        if (paramServiceDescriptorProto.hasOptions()) {
          mergeOptions(paramServiceDescriptorProto.getOptions());
        }
        mergeUnknownFields(paramServiceDescriptorProto.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.ServiceDescriptorProto)) {
          return mergeFrom((DescriptorProtos.ServiceDescriptorProto)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder mergeOptions(DescriptorProtos.ServiceOptions paramServiceOptions)
      {
        if ((this.result.hasOptions()) && (this.result.options_ != DescriptorProtos.ServiceOptions.getDefaultInstance())) {
          DescriptorProtos.ServiceDescriptorProto.access$9602(this.result, DescriptorProtos.ServiceOptions.newBuilder(this.result.options_).mergeFrom(paramServiceOptions).buildPartial());
        }
        for (;;)
        {
          DescriptorProtos.ServiceDescriptorProto.access$9502(this.result, true);
          return this;
          DescriptorProtos.ServiceDescriptorProto.access$9602(this.result, paramServiceOptions);
        }
      }
      
      public Builder setMethod(int paramInt, DescriptorProtos.MethodDescriptorProto.Builder paramBuilder)
      {
        this.result.method_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setMethod(int paramInt, DescriptorProtos.MethodDescriptorProto paramMethodDescriptorProto)
      {
        if (paramMethodDescriptorProto == null) {
          throw new NullPointerException();
        }
        this.result.method_.set(paramInt, paramMethodDescriptorProto);
        return this;
      }
      
      public Builder setName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.ServiceDescriptorProto.access$9302(this.result, true);
        DescriptorProtos.ServiceDescriptorProto.access$9402(this.result, paramString);
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.ServiceOptions.Builder paramBuilder)
      {
        DescriptorProtos.ServiceDescriptorProto.access$9502(this.result, true);
        DescriptorProtos.ServiceDescriptorProto.access$9602(this.result, paramBuilder.build());
        return this;
      }
      
      public Builder setOptions(DescriptorProtos.ServiceOptions paramServiceOptions)
      {
        if (paramServiceOptions == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.ServiceDescriptorProto.access$9502(this.result, true);
        DescriptorProtos.ServiceDescriptorProto.access$9602(this.result, paramServiceOptions);
        return this;
      }
    }
  }
  
  public static final class ServiceOptions
    extends GeneratedMessage.ExtendableMessage<ServiceOptions>
  {
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private static final ServiceOptions defaultInstance = new ServiceOptions();
    private int memoizedSerializedSize = -1;
    private List<DescriptorProtos.UninterpretedOption> uninterpretedOption_ = Collections.emptyList();
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static ServiceOptions getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$16300();
    }
    
    public static Builder newBuilder(ServiceOptions paramServiceOptions)
    {
      return newBuilder().mergeFrom(paramServiceOptions);
    }
    
    public static ServiceOptions parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static ServiceOptions parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static ServiceOptions parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static ServiceOptions parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public ServiceOptions getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        i += CodedOutputStream.computeMessageSize(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      i = i + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
    {
      return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(paramInt);
    }
    
    public int getUninterpretedOptionCount()
    {
      return this.uninterpretedOption_.size();
    }
    
    public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
    {
      return this.uninterpretedOption_;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getUninterpretedOptionList().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((DescriptorProtos.UninterpretedOption)localIterator.next()).isInitialized());
      while (!extensionsAreInitialized()) {
        return false;
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      GeneratedMessage.ExtendableMessage.ExtensionWriter localExtensionWriter = newExtensionWriter();
      Iterator localIterator = getUninterpretedOptionList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(999, (DescriptorProtos.UninterpretedOption)localIterator.next());
      }
      localExtensionWriter.writeUntil(536870912, paramCodedOutputStream);
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.ExtendableBuilder<DescriptorProtos.ServiceOptions, Builder>
    {
      private DescriptorProtos.ServiceOptions result;
      
      private DescriptorProtos.ServiceOptions buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.ServiceOptions(null);
        return localBuilder;
      }
      
      public Builder addAllUninterpretedOption(Iterable<? extends DescriptorProtos.UninterpretedOption> paramIterable)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.ServiceOptions.access$16502(this.result, new ArrayList());
        }
        GeneratedMessage.ExtendableBuilder.addAll(paramIterable, this.result.uninterpretedOption_);
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.ServiceOptions.access$16502(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addUninterpretedOption(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        if (this.result.uninterpretedOption_.isEmpty()) {
          DescriptorProtos.ServiceOptions.access$16502(this.result, new ArrayList());
        }
        this.result.uninterpretedOption_.add(paramUninterpretedOption);
        return this;
      }
      
      public DescriptorProtos.ServiceOptions build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.ServiceOptions buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.uninterpretedOption_ != Collections.EMPTY_LIST) {
          DescriptorProtos.ServiceOptions.access$16502(this.result, Collections.unmodifiableList(this.result.uninterpretedOption_));
        }
        DescriptorProtos.ServiceOptions localServiceOptions = this.result;
        this.result = null;
        return localServiceOptions;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.ServiceOptions(null);
        return this;
      }
      
      public Builder clearUninterpretedOption()
      {
        DescriptorProtos.ServiceOptions.access$16502(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.ServiceOptions getDefaultInstanceForType()
      {
        return DescriptorProtos.ServiceOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.ServiceOptions.getDescriptor();
      }
      
      public DescriptorProtos.UninterpretedOption getUninterpretedOption(int paramInt)
      {
        return this.result.getUninterpretedOption(paramInt);
      }
      
      public int getUninterpretedOptionCount()
      {
        return this.result.getUninterpretedOptionCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption> getUninterpretedOptionList()
      {
        return Collections.unmodifiableList(this.result.uninterpretedOption_);
      }
      
      protected DescriptorProtos.ServiceOptions internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 7994: 
            DescriptorProtos.UninterpretedOption.Builder localBuilder1 = DescriptorProtos.UninterpretedOption.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addUninterpretedOption(localBuilder1.buildPartial());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.ServiceOptions paramServiceOptions)
      {
        if (paramServiceOptions == DescriptorProtos.ServiceOptions.getDefaultInstance()) {
          return this;
        }
        if (!paramServiceOptions.uninterpretedOption_.isEmpty())
        {
          if (this.result.uninterpretedOption_.isEmpty()) {
            DescriptorProtos.ServiceOptions.access$16502(this.result, new ArrayList());
          }
          this.result.uninterpretedOption_.addAll(paramServiceOptions.uninterpretedOption_);
        }
        mergeExtensionFields(paramServiceOptions);
        mergeUnknownFields(paramServiceOptions.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.ServiceOptions)) {
          return mergeFrom((DescriptorProtos.ServiceOptions)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption.Builder paramBuilder)
      {
        this.result.uninterpretedOption_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setUninterpretedOption(int paramInt, DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == null) {
          throw new NullPointerException();
        }
        this.result.uninterpretedOption_.set(paramInt, paramUninterpretedOption);
        return this;
      }
    }
  }
  
  public static final class UninterpretedOption
    extends GeneratedMessage
  {
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private static final UninterpretedOption defaultInstance = new UninterpretedOption();
    private double doubleValue_ = 0.0D;
    private boolean hasDoubleValue;
    private boolean hasIdentifierValue;
    private boolean hasNegativeIntValue;
    private boolean hasPositiveIntValue;
    private boolean hasStringValue;
    private String identifierValue_ = "";
    private int memoizedSerializedSize = -1;
    private List<NamePart> name_ = Collections.emptyList();
    private long negativeIntValue_ = 0L;
    private long positiveIntValue_ = 0L;
    private ByteString stringValue_ = ByteString.EMPTY;
    
    static
    {
      DescriptorProtos.getDescriptor();
      DescriptorProtos.internalForceInit();
    }
    
    public static UninterpretedOption getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$18400();
    }
    
    public static Builder newBuilder(UninterpretedOption paramUninterpretedOption)
    {
      return newBuilder().mergeFrom(paramUninterpretedOption);
    }
    
    public static UninterpretedOption parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static UninterpretedOption parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static UninterpretedOption parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public UninterpretedOption getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public double getDoubleValue()
    {
      return this.doubleValue_;
    }
    
    public String getIdentifierValue()
    {
      return this.identifierValue_;
    }
    
    public NamePart getName(int paramInt)
    {
      return (NamePart)this.name_.get(paramInt);
    }
    
    public int getNameCount()
    {
      return this.name_.size();
    }
    
    public List<NamePart> getNameList()
    {
      return this.name_;
    }
    
    public long getNegativeIntValue()
    {
      return this.negativeIntValue_;
    }
    
    public long getPositiveIntValue()
    {
      return this.positiveIntValue_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      Iterator localIterator = getNameList().iterator();
      while (localIterator.hasNext()) {
        j += CodedOutputStream.computeMessageSize(2, (NamePart)localIterator.next());
      }
      i = j;
      if (hasIdentifierValue()) {
        i = j + CodedOutputStream.computeStringSize(3, getIdentifierValue());
      }
      j = i;
      if (hasPositiveIntValue()) {
        j = i + CodedOutputStream.computeUInt64Size(4, getPositiveIntValue());
      }
      i = j;
      if (hasNegativeIntValue()) {
        i = j + CodedOutputStream.computeInt64Size(5, getNegativeIntValue());
      }
      j = i;
      if (hasDoubleValue()) {
        j = i + CodedOutputStream.computeDoubleSize(6, getDoubleValue());
      }
      i = j;
      if (hasStringValue()) {
        i = j + CodedOutputStream.computeBytesSize(7, getStringValue());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public ByteString getStringValue()
    {
      return this.stringValue_;
    }
    
    public boolean hasDoubleValue()
    {
      return this.hasDoubleValue;
    }
    
    public boolean hasIdentifierValue()
    {
      return this.hasIdentifierValue;
    }
    
    public boolean hasNegativeIntValue()
    {
      return this.hasNegativeIntValue;
    }
    
    public boolean hasPositiveIntValue()
    {
      return this.hasPositiveIntValue;
    }
    
    public boolean hasStringValue()
    {
      return this.hasStringValue;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      Iterator localIterator = getNameList().iterator();
      while (localIterator.hasNext()) {
        if (!((NamePart)localIterator.next()).isInitialized()) {
          return false;
        }
      }
      return true;
    }
    
    public Builder newBuilderForType()
    {
      return newBuilder();
    }
    
    public Builder toBuilder()
    {
      return newBuilder(this);
    }
    
    public void writeTo(CodedOutputStream paramCodedOutputStream)
      throws IOException
    {
      Iterator localIterator = getNameList().iterator();
      while (localIterator.hasNext()) {
        paramCodedOutputStream.writeMessage(2, (NamePart)localIterator.next());
      }
      if (hasIdentifierValue()) {
        paramCodedOutputStream.writeString(3, getIdentifierValue());
      }
      if (hasPositiveIntValue()) {
        paramCodedOutputStream.writeUInt64(4, getPositiveIntValue());
      }
      if (hasNegativeIntValue()) {
        paramCodedOutputStream.writeInt64(5, getNegativeIntValue());
      }
      if (hasDoubleValue()) {
        paramCodedOutputStream.writeDouble(6, getDoubleValue());
      }
      if (hasStringValue()) {
        paramCodedOutputStream.writeBytes(7, getStringValue());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private DescriptorProtos.UninterpretedOption result;
      
      private DescriptorProtos.UninterpretedOption buildParsed()
        throws InvalidProtocolBufferException
      {
        if (!isInitialized()) {
          throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      private static Builder create()
      {
        Builder localBuilder = new Builder();
        localBuilder.result = new DescriptorProtos.UninterpretedOption(null);
        return localBuilder;
      }
      
      public Builder addAllName(Iterable<? extends DescriptorProtos.UninterpretedOption.NamePart> paramIterable)
      {
        if (this.result.name_.isEmpty()) {
          DescriptorProtos.UninterpretedOption.access$18602(this.result, new ArrayList());
        }
        GeneratedMessage.Builder.addAll(paramIterable, this.result.name_);
        return this;
      }
      
      public Builder addName(DescriptorProtos.UninterpretedOption.NamePart.Builder paramBuilder)
      {
        if (this.result.name_.isEmpty()) {
          DescriptorProtos.UninterpretedOption.access$18602(this.result, new ArrayList());
        }
        this.result.name_.add(paramBuilder.build());
        return this;
      }
      
      public Builder addName(DescriptorProtos.UninterpretedOption.NamePart paramNamePart)
      {
        if (paramNamePart == null) {
          throw new NullPointerException();
        }
        if (this.result.name_.isEmpty()) {
          DescriptorProtos.UninterpretedOption.access$18602(this.result, new ArrayList());
        }
        this.result.name_.add(paramNamePart);
        return this;
      }
      
      public DescriptorProtos.UninterpretedOption build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public DescriptorProtos.UninterpretedOption buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        if (this.result.name_ != Collections.EMPTY_LIST) {
          DescriptorProtos.UninterpretedOption.access$18602(this.result, Collections.unmodifiableList(this.result.name_));
        }
        DescriptorProtos.UninterpretedOption localUninterpretedOption = this.result;
        this.result = null;
        return localUninterpretedOption;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new DescriptorProtos.UninterpretedOption(null);
        return this;
      }
      
      public Builder clearDoubleValue()
      {
        DescriptorProtos.UninterpretedOption.access$19302(this.result, false);
        DescriptorProtos.UninterpretedOption.access$19402(this.result, 0.0D);
        return this;
      }
      
      public Builder clearIdentifierValue()
      {
        DescriptorProtos.UninterpretedOption.access$18702(this.result, false);
        DescriptorProtos.UninterpretedOption.access$18802(this.result, DescriptorProtos.UninterpretedOption.getDefaultInstance().getIdentifierValue());
        return this;
      }
      
      public Builder clearName()
      {
        DescriptorProtos.UninterpretedOption.access$18602(this.result, Collections.emptyList());
        return this;
      }
      
      public Builder clearNegativeIntValue()
      {
        DescriptorProtos.UninterpretedOption.access$19102(this.result, false);
        DescriptorProtos.UninterpretedOption.access$19202(this.result, 0L);
        return this;
      }
      
      public Builder clearPositiveIntValue()
      {
        DescriptorProtos.UninterpretedOption.access$18902(this.result, false);
        DescriptorProtos.UninterpretedOption.access$19002(this.result, 0L);
        return this;
      }
      
      public Builder clearStringValue()
      {
        DescriptorProtos.UninterpretedOption.access$19502(this.result, false);
        DescriptorProtos.UninterpretedOption.access$19602(this.result, DescriptorProtos.UninterpretedOption.getDefaultInstance().getStringValue());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public DescriptorProtos.UninterpretedOption getDefaultInstanceForType()
      {
        return DescriptorProtos.UninterpretedOption.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return DescriptorProtos.UninterpretedOption.getDescriptor();
      }
      
      public double getDoubleValue()
      {
        return this.result.getDoubleValue();
      }
      
      public String getIdentifierValue()
      {
        return this.result.getIdentifierValue();
      }
      
      public DescriptorProtos.UninterpretedOption.NamePart getName(int paramInt)
      {
        return this.result.getName(paramInt);
      }
      
      public int getNameCount()
      {
        return this.result.getNameCount();
      }
      
      public List<DescriptorProtos.UninterpretedOption.NamePart> getNameList()
      {
        return Collections.unmodifiableList(this.result.name_);
      }
      
      public long getNegativeIntValue()
      {
        return this.result.getNegativeIntValue();
      }
      
      public long getPositiveIntValue()
      {
        return this.result.getPositiveIntValue();
      }
      
      public ByteString getStringValue()
      {
        return this.result.getStringValue();
      }
      
      public boolean hasDoubleValue()
      {
        return this.result.hasDoubleValue();
      }
      
      public boolean hasIdentifierValue()
      {
        return this.result.hasIdentifierValue();
      }
      
      public boolean hasNegativeIntValue()
      {
        return this.result.hasNegativeIntValue();
      }
      
      public boolean hasPositiveIntValue()
      {
        return this.result.hasPositiveIntValue();
      }
      
      public boolean hasStringValue()
      {
        return this.result.hasStringValue();
      }
      
      protected DescriptorProtos.UninterpretedOption internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
        for (;;)
        {
          int i = paramCodedInputStream.readTag();
          switch (i)
          {
          default: 
            if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
            {
              setUnknownFields(localBuilder.build());
              return this;
            }
            break;
          case 0: 
            setUnknownFields(localBuilder.build());
            return this;
          case 18: 
            DescriptorProtos.UninterpretedOption.NamePart.Builder localBuilder1 = DescriptorProtos.UninterpretedOption.NamePart.newBuilder();
            paramCodedInputStream.readMessage(localBuilder1, paramExtensionRegistryLite);
            addName(localBuilder1.buildPartial());
            break;
          case 26: 
            setIdentifierValue(paramCodedInputStream.readString());
            break;
          case 32: 
            setPositiveIntValue(paramCodedInputStream.readUInt64());
            break;
          case 40: 
            setNegativeIntValue(paramCodedInputStream.readInt64());
            break;
          case 49: 
            setDoubleValue(paramCodedInputStream.readDouble());
            break;
          case 58: 
            setStringValue(paramCodedInputStream.readBytes());
          }
        }
      }
      
      public Builder mergeFrom(DescriptorProtos.UninterpretedOption paramUninterpretedOption)
      {
        if (paramUninterpretedOption == DescriptorProtos.UninterpretedOption.getDefaultInstance()) {
          return this;
        }
        if (!paramUninterpretedOption.name_.isEmpty())
        {
          if (this.result.name_.isEmpty()) {
            DescriptorProtos.UninterpretedOption.access$18602(this.result, new ArrayList());
          }
          this.result.name_.addAll(paramUninterpretedOption.name_);
        }
        if (paramUninterpretedOption.hasIdentifierValue()) {
          setIdentifierValue(paramUninterpretedOption.getIdentifierValue());
        }
        if (paramUninterpretedOption.hasPositiveIntValue()) {
          setPositiveIntValue(paramUninterpretedOption.getPositiveIntValue());
        }
        if (paramUninterpretedOption.hasNegativeIntValue()) {
          setNegativeIntValue(paramUninterpretedOption.getNegativeIntValue());
        }
        if (paramUninterpretedOption.hasDoubleValue()) {
          setDoubleValue(paramUninterpretedOption.getDoubleValue());
        }
        if (paramUninterpretedOption.hasStringValue()) {
          setStringValue(paramUninterpretedOption.getStringValue());
        }
        mergeUnknownFields(paramUninterpretedOption.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof DescriptorProtos.UninterpretedOption)) {
          return mergeFrom((DescriptorProtos.UninterpretedOption)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setDoubleValue(double paramDouble)
      {
        DescriptorProtos.UninterpretedOption.access$19302(this.result, true);
        DescriptorProtos.UninterpretedOption.access$19402(this.result, paramDouble);
        return this;
      }
      
      public Builder setIdentifierValue(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.UninterpretedOption.access$18702(this.result, true);
        DescriptorProtos.UninterpretedOption.access$18802(this.result, paramString);
        return this;
      }
      
      public Builder setName(int paramInt, DescriptorProtos.UninterpretedOption.NamePart.Builder paramBuilder)
      {
        this.result.name_.set(paramInt, paramBuilder.build());
        return this;
      }
      
      public Builder setName(int paramInt, DescriptorProtos.UninterpretedOption.NamePart paramNamePart)
      {
        if (paramNamePart == null) {
          throw new NullPointerException();
        }
        this.result.name_.set(paramInt, paramNamePart);
        return this;
      }
      
      public Builder setNegativeIntValue(long paramLong)
      {
        DescriptorProtos.UninterpretedOption.access$19102(this.result, true);
        DescriptorProtos.UninterpretedOption.access$19202(this.result, paramLong);
        return this;
      }
      
      public Builder setPositiveIntValue(long paramLong)
      {
        DescriptorProtos.UninterpretedOption.access$18902(this.result, true);
        DescriptorProtos.UninterpretedOption.access$19002(this.result, paramLong);
        return this;
      }
      
      public Builder setStringValue(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        DescriptorProtos.UninterpretedOption.access$19502(this.result, true);
        DescriptorProtos.UninterpretedOption.access$19602(this.result, paramByteString);
        return this;
      }
    }
    
    public static final class NamePart
      extends GeneratedMessage
    {
      public static final int IS_EXTENSION_FIELD_NUMBER = 2;
      public static final int NAME_PART_FIELD_NUMBER = 1;
      private static final NamePart defaultInstance = new NamePart();
      private boolean hasIsExtension;
      private boolean hasNamePart;
      private boolean isExtension_ = false;
      private int memoizedSerializedSize = -1;
      private String namePart_ = "";
      
      static
      {
        DescriptorProtos.getDescriptor();
        DescriptorProtos.internalForceInit();
      }
      
      public static NamePart getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final Descriptors.Descriptor getDescriptor()
      {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor;
      }
      
      public static Builder newBuilder()
      {
        return Builder.access$17700();
      }
      
      public static Builder newBuilder(NamePart paramNamePart)
      {
        return newBuilder().mergeFrom(paramNamePart);
      }
      
      public static NamePart parseDelimitedFrom(InputStream paramInputStream)
        throws IOException
      {
        return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
      }
      
      public static NamePart parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
      }
      
      public static NamePart parseFrom(ByteString paramByteString)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
      }
      
      public static NamePart parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
      }
      
      public static NamePart parseFrom(CodedInputStream paramCodedInputStream)
        throws IOException
      {
        return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
      }
      
      public static NamePart parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
      }
      
      public static NamePart parseFrom(InputStream paramInputStream)
        throws IOException
      {
        return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
      }
      
      public static NamePart parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
        throws IOException
      {
        return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
      }
      
      public static NamePart parseFrom(byte[] paramArrayOfByte)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
      }
      
      public static NamePart parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
        throws InvalidProtocolBufferException
      {
        return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
      }
      
      public NamePart getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public boolean getIsExtension()
      {
        return this.isExtension_;
      }
      
      public String getNamePart()
      {
        return this.namePart_;
      }
      
      public int getSerializedSize()
      {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
          return i;
        }
        i = 0;
        if (hasNamePart()) {
          i = 0 + CodedOutputStream.computeStringSize(1, getNamePart());
        }
        int j = i;
        if (hasIsExtension()) {
          j = i + CodedOutputStream.computeBoolSize(2, getIsExtension());
        }
        i = j + getUnknownFields().getSerializedSize();
        this.memoizedSerializedSize = i;
        return i;
      }
      
      public boolean hasIsExtension()
      {
        return this.hasIsExtension;
      }
      
      public boolean hasNamePart()
      {
        return this.hasNamePart;
      }
      
      protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
      {
        return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable;
      }
      
      public final boolean isInitialized()
      {
        if (!this.hasNamePart) {}
        while (!this.hasIsExtension) {
          return false;
        }
        return true;
      }
      
      public Builder newBuilderForType()
      {
        return newBuilder();
      }
      
      public Builder toBuilder()
      {
        return newBuilder(this);
      }
      
      public void writeTo(CodedOutputStream paramCodedOutputStream)
        throws IOException
      {
        if (hasNamePart()) {
          paramCodedOutputStream.writeString(1, getNamePart());
        }
        if (hasIsExtension()) {
          paramCodedOutputStream.writeBool(2, getIsExtension());
        }
        getUnknownFields().writeTo(paramCodedOutputStream);
      }
      
      public static final class Builder
        extends GeneratedMessage.Builder<Builder>
      {
        private DescriptorProtos.UninterpretedOption.NamePart result;
        
        private DescriptorProtos.UninterpretedOption.NamePart buildParsed()
          throws InvalidProtocolBufferException
        {
          if (!isInitialized()) {
            throw newUninitializedMessageException(this.result).asInvalidProtocolBufferException();
          }
          return buildPartial();
        }
        
        private static Builder create()
        {
          Builder localBuilder = new Builder();
          localBuilder.result = new DescriptorProtos.UninterpretedOption.NamePart(null);
          return localBuilder;
        }
        
        public DescriptorProtos.UninterpretedOption.NamePart build()
        {
          if ((this.result != null) && (!isInitialized())) {
            throw newUninitializedMessageException(this.result);
          }
          return buildPartial();
        }
        
        public DescriptorProtos.UninterpretedOption.NamePart buildPartial()
        {
          if (this.result == null) {
            throw new IllegalStateException("build() has already been called on this Builder.");
          }
          DescriptorProtos.UninterpretedOption.NamePart localNamePart = this.result;
          this.result = null;
          return localNamePart;
        }
        
        public Builder clear()
        {
          if (this.result == null) {
            throw new IllegalStateException("Cannot call clear() after build().");
          }
          this.result = new DescriptorProtos.UninterpretedOption.NamePart(null);
          return this;
        }
        
        public Builder clearIsExtension()
        {
          DescriptorProtos.UninterpretedOption.NamePart.access$18102(this.result, false);
          DescriptorProtos.UninterpretedOption.NamePart.access$18202(this.result, false);
          return this;
        }
        
        public Builder clearNamePart()
        {
          DescriptorProtos.UninterpretedOption.NamePart.access$17902(this.result, false);
          DescriptorProtos.UninterpretedOption.NamePart.access$18002(this.result, DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance().getNamePart());
          return this;
        }
        
        public Builder clone()
        {
          return create().mergeFrom(this.result);
        }
        
        public DescriptorProtos.UninterpretedOption.NamePart getDefaultInstanceForType()
        {
          return DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance();
        }
        
        public Descriptors.Descriptor getDescriptorForType()
        {
          return DescriptorProtos.UninterpretedOption.NamePart.getDescriptor();
        }
        
        public boolean getIsExtension()
        {
          return this.result.getIsExtension();
        }
        
        public String getNamePart()
        {
          return this.result.getNamePart();
        }
        
        public boolean hasIsExtension()
        {
          return this.result.hasIsExtension();
        }
        
        public boolean hasNamePart()
        {
          return this.result.hasNamePart();
        }
        
        protected DescriptorProtos.UninterpretedOption.NamePart internalGetResult()
        {
          return this.result;
        }
        
        public boolean isInitialized()
        {
          return this.result.isInitialized();
        }
        
        public Builder mergeFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
          throws IOException
        {
          UnknownFieldSet.Builder localBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
          for (;;)
          {
            int i = paramCodedInputStream.readTag();
            switch (i)
            {
            default: 
              if (!parseUnknownField(paramCodedInputStream, localBuilder, paramExtensionRegistryLite, i))
              {
                setUnknownFields(localBuilder.build());
                return this;
              }
              break;
            case 0: 
              setUnknownFields(localBuilder.build());
              return this;
            case 10: 
              setNamePart(paramCodedInputStream.readString());
              break;
            case 16: 
              setIsExtension(paramCodedInputStream.readBool());
            }
          }
        }
        
        public Builder mergeFrom(DescriptorProtos.UninterpretedOption.NamePart paramNamePart)
        {
          if (paramNamePart == DescriptorProtos.UninterpretedOption.NamePart.getDefaultInstance()) {
            return this;
          }
          if (paramNamePart.hasNamePart()) {
            setNamePart(paramNamePart.getNamePart());
          }
          if (paramNamePart.hasIsExtension()) {
            setIsExtension(paramNamePart.getIsExtension());
          }
          mergeUnknownFields(paramNamePart.getUnknownFields());
          return this;
        }
        
        public Builder mergeFrom(Message paramMessage)
        {
          if ((paramMessage instanceof DescriptorProtos.UninterpretedOption.NamePart)) {
            return mergeFrom((DescriptorProtos.UninterpretedOption.NamePart)paramMessage);
          }
          super.mergeFrom(paramMessage);
          return this;
        }
        
        public Builder setIsExtension(boolean paramBoolean)
        {
          DescriptorProtos.UninterpretedOption.NamePart.access$18102(this.result, true);
          DescriptorProtos.UninterpretedOption.NamePart.access$18202(this.result, paramBoolean);
          return this;
        }
        
        public Builder setNamePart(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          DescriptorProtos.UninterpretedOption.NamePart.access$17902(this.result, true);
          DescriptorProtos.UninterpretedOption.NamePart.access$18002(this.result, paramString);
          return this;
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/google/protobuf/DescriptorProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */