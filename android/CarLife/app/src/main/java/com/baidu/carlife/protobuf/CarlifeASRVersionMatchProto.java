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

public final class CarlifeASRVersionMatchProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeASRVersionMatch_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeASRVersionMatch_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeASRVersionMatchProto.access$902(paramAnonymousFileDescriptor);
        CarlifeASRVersionMatchProto.access$002((Descriptors.Descriptor)CarlifeASRVersionMatchProto.getDescriptor().getMessageTypes().get(0));
        CarlifeASRVersionMatchProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_descriptor, new String[] { "AsrName", "VersionCode" }, CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.class, CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeASRVersionMatchProto.proto\">\n\026CarlifeASRVersionMatch\022\017\n\007asrName\030\001 \002(\t\022\023\n\013versionCode\030\002 \002(\005B\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeASRVersionMatch
    extends GeneratedMessage
  {
    public static final int ASRNAME_FIELD_NUMBER = 1;
    public static final int VERSIONCODE_FIELD_NUMBER = 2;
    private static final CarlifeASRVersionMatch defaultInstance = new CarlifeASRVersionMatch();
    private String asrName_ = "";
    private boolean hasAsrName;
    private boolean hasVersionCode;
    private int memoizedSerializedSize = -1;
    private int versionCode_ = 0;
    
    static
    {
      CarlifeASRVersionMatchProto.getDescriptor();
      CarlifeASRVersionMatchProto.internalForceInit();
    }
    
    public static CarlifeASRVersionMatch getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeASRVersionMatch paramCarlifeASRVersionMatch)
    {
      return newBuilder().mergeFrom(paramCarlifeASRVersionMatch);
    }
    
    public static CarlifeASRVersionMatch parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeASRVersionMatch parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAsrName()
    {
      return this.asrName_;
    }
    
    public CarlifeASRVersionMatch getDefaultInstanceForType()
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
      if (hasAsrName()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getAsrName());
      }
      int j = i;
      if (hasVersionCode()) {
        j = i + CodedOutputStream.computeInt32Size(2, getVersionCode());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getVersionCode()
    {
      return this.versionCode_;
    }
    
    public boolean hasAsrName()
    {
      return this.hasAsrName;
    }
    
    public boolean hasVersionCode()
    {
      return this.hasVersionCode;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeASRVersionMatchProto.internal_static_CarlifeASRVersionMatch_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAsrName) {}
      while (!this.hasVersionCode) {
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
      if (hasAsrName()) {
        paramCodedOutputStream.writeString(1, getAsrName());
      }
      if (hasVersionCode()) {
        paramCodedOutputStream.writeInt32(2, getVersionCode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeASRVersionMatchProto.CarlifeASRVersionMatch result;
      
      private CarlifeASRVersionMatchProto.CarlifeASRVersionMatch buildParsed()
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
        localBuilder.result = new CarlifeASRVersionMatchProto.CarlifeASRVersionMatch(null);
        return localBuilder;
      }
      
      public CarlifeASRVersionMatchProto.CarlifeASRVersionMatch build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeASRVersionMatchProto.CarlifeASRVersionMatch buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch localCarlifeASRVersionMatch = this.result;
        this.result = null;
        return localCarlifeASRVersionMatch;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeASRVersionMatchProto.CarlifeASRVersionMatch(null);
        return this;
      }
      
      public Builder clearAsrName()
      {
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$502(this.result, false);
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$602(this.result, CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.getDefaultInstance().getAsrName());
        return this;
      }
      
      public Builder clearVersionCode()
      {
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$702(this.result, false);
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$802(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getAsrName()
      {
        return this.result.getAsrName();
      }
      
      public CarlifeASRVersionMatchProto.CarlifeASRVersionMatch getDefaultInstanceForType()
      {
        return CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.getDescriptor();
      }
      
      public int getVersionCode()
      {
        return this.result.getVersionCode();
      }
      
      public boolean hasAsrName()
      {
        return this.result.hasAsrName();
      }
      
      public boolean hasVersionCode()
      {
        return this.result.hasVersionCode();
      }
      
      protected CarlifeASRVersionMatchProto.CarlifeASRVersionMatch internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeASRVersionMatchProto.CarlifeASRVersionMatch paramCarlifeASRVersionMatch)
      {
        if (paramCarlifeASRVersionMatch == CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeASRVersionMatch.hasAsrName()) {
          setAsrName(paramCarlifeASRVersionMatch.getAsrName());
        }
        if (paramCarlifeASRVersionMatch.hasVersionCode()) {
          setVersionCode(paramCarlifeASRVersionMatch.getVersionCode());
        }
        mergeUnknownFields(paramCarlifeASRVersionMatch.getUnknownFields());
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
          case 10: 
            setAsrName(paramCodedInputStream.readString());
            break;
          case 16: 
            setVersionCode(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeASRVersionMatchProto.CarlifeASRVersionMatch)) {
          return mergeFrom((CarlifeASRVersionMatchProto.CarlifeASRVersionMatch)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAsrName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$502(this.result, true);
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$602(this.result, paramString);
        return this;
      }
      
      public Builder setVersionCode(int paramInt)
      {
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$702(this.result, true);
        CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeASRVersionMatchProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */