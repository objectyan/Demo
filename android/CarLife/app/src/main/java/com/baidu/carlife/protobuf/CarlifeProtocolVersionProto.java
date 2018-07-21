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
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.GeneratedMessage.FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class CarlifeProtocolVersionProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeProtocolVersionProto.access$902(paramAnonymousFileDescriptor);
        CarlifeProtocolVersionProto.access$002((Descriptors.Descriptor)CarlifeProtocolVersionProto.getDescriptor().getMessageTypes().get(0));
        CarlifeProtocolVersionProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeProtocolVersionProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor, new String[] { "MajorVersion", "MinorVersion" }, CarlifeProtocolVersionProto.CarlifeProtocolVersion.class, CarlifeProtocolVersionProto.CarlifeProtocolVersion.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeProtocolVersionProto.proto\022\032com.baidu.carlife.protobuf\"D\n\026CarlifeProtocolVersion\022\024\n\fmajorVersion\030\001 \002(\005\022\024\n\fminorVersion\030\002 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeProtocolVersion
    extends GeneratedMessage
  {
    public static final int MAJORVERSION_FIELD_NUMBER = 1;
    public static final int MINORVERSION_FIELD_NUMBER = 2;
    private static final CarlifeProtocolVersion defaultInstance = new CarlifeProtocolVersion();
    private boolean hasMajorVersion;
    private boolean hasMinorVersion;
    private int majorVersion_ = 0;
    private int memoizedSerializedSize = -1;
    private int minorVersion_ = 0;
    
    static
    {
      CarlifeProtocolVersionProto.getDescriptor();
      CarlifeProtocolVersionProto.internalForceInit();
    }
    
    public static CarlifeProtocolVersion getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeProtocolVersionProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeProtocolVersion paramCarlifeProtocolVersion)
    {
      return newBuilder().mergeFrom(paramCarlifeProtocolVersion);
    }
    
    public static CarlifeProtocolVersion parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeProtocolVersion parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeProtocolVersion getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getMajorVersion()
    {
      return this.majorVersion_;
    }
    
    public int getMinorVersion()
    {
      return this.minorVersion_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasMajorVersion()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getMajorVersion());
      }
      int j = i;
      if (hasMinorVersion()) {
        j = i + CodedOutputStream.computeInt32Size(2, getMinorVersion());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasMajorVersion()
    {
      return this.hasMajorVersion;
    }
    
    public boolean hasMinorVersion()
    {
      return this.hasMinorVersion;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeProtocolVersionProto.internal_static_com_baidu_carlife_protobuf_CarlifeProtocolVersion_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasMajorVersion) {}
      while (!this.hasMinorVersion) {
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
      if (hasMajorVersion()) {
        paramCodedOutputStream.writeInt32(1, getMajorVersion());
      }
      if (hasMinorVersion()) {
        paramCodedOutputStream.writeInt32(2, getMinorVersion());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeProtocolVersionProto.CarlifeProtocolVersion result;
      
      private CarlifeProtocolVersionProto.CarlifeProtocolVersion buildParsed()
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
        localBuilder.result = new CarlifeProtocolVersionProto.CarlifeProtocolVersion(null);
        return localBuilder;
      }
      
      public CarlifeProtocolVersionProto.CarlifeProtocolVersion build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeProtocolVersionProto.CarlifeProtocolVersion buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeProtocolVersionProto.CarlifeProtocolVersion localCarlifeProtocolVersion = this.result;
        this.result = null;
        return localCarlifeProtocolVersion;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeProtocolVersionProto.CarlifeProtocolVersion(null);
        return this;
      }
      
      public Builder clearMajorVersion()
      {
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$502(this.result, false);
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearMinorVersion()
      {
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$702(this.result, false);
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$802(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeProtocolVersionProto.CarlifeProtocolVersion getDefaultInstanceForType()
      {
        return CarlifeProtocolVersionProto.CarlifeProtocolVersion.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeProtocolVersionProto.CarlifeProtocolVersion.getDescriptor();
      }
      
      public int getMajorVersion()
      {
        return this.result.getMajorVersion();
      }
      
      public int getMinorVersion()
      {
        return this.result.getMinorVersion();
      }
      
      public boolean hasMajorVersion()
      {
        return this.result.hasMajorVersion();
      }
      
      public boolean hasMinorVersion()
      {
        return this.result.hasMinorVersion();
      }
      
      protected CarlifeProtocolVersionProto.CarlifeProtocolVersion internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeProtocolVersionProto.CarlifeProtocolVersion paramCarlifeProtocolVersion)
      {
        if (paramCarlifeProtocolVersion == CarlifeProtocolVersionProto.CarlifeProtocolVersion.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeProtocolVersion.hasMajorVersion()) {
          setMajorVersion(paramCarlifeProtocolVersion.getMajorVersion());
        }
        if (paramCarlifeProtocolVersion.hasMinorVersion()) {
          setMinorVersion(paramCarlifeProtocolVersion.getMinorVersion());
        }
        mergeUnknownFields(paramCarlifeProtocolVersion.getUnknownFields());
        return this;
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
            setMajorVersion(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setMinorVersion(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeProtocolVersionProto.CarlifeProtocolVersion)) {
          return mergeFrom((CarlifeProtocolVersionProto.CarlifeProtocolVersion)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setMajorVersion(int paramInt)
      {
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$502(this.result, true);
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setMinorVersion(int paramInt)
      {
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$702(this.result, true);
        CarlifeProtocolVersionProto.CarlifeProtocolVersion.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeProtocolVersionProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */