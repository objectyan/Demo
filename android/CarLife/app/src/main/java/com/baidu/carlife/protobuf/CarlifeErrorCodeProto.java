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

public final class CarlifeErrorCodeProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeErrorCodeProto.access$702(paramAnonymousFileDescriptor);
        CarlifeErrorCodeProto.access$002((Descriptors.Descriptor)CarlifeErrorCodeProto.getDescriptor().getMessageTypes().get(0));
        CarlifeErrorCodeProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeErrorCodeProto.internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_descriptor, new String[] { "ErrorCode" }, CarlifeErrorCodeProto.CarlifeErrorCode.class, CarlifeErrorCodeProto.CarlifeErrorCode.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\033CarlifeErrorCodeProto.proto\022\032com.baidu.carlife.protobuf\"%\n\020CarlifeErrorCode\022\021\n\terrorCode\030\001 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeErrorCode
    extends GeneratedMessage
  {
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    private static final CarlifeErrorCode defaultInstance = new CarlifeErrorCode();
    private String errorCode_ = "";
    private boolean hasErrorCode;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeErrorCodeProto.getDescriptor();
      CarlifeErrorCodeProto.internalForceInit();
    }
    
    public static CarlifeErrorCode getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeErrorCodeProto.internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeErrorCode paramCarlifeErrorCode)
    {
      return newBuilder().mergeFrom(paramCarlifeErrorCode);
    }
    
    public static CarlifeErrorCode parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeErrorCode parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeErrorCode parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeErrorCode getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getErrorCode()
    {
      return this.errorCode_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasErrorCode()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getErrorCode());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasErrorCode()
    {
      return this.hasErrorCode;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeErrorCodeProto.internal_static_com_baidu_carlife_protobuf_CarlifeErrorCode_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasErrorCode;
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
      if (hasErrorCode()) {
        paramCodedOutputStream.writeString(1, getErrorCode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeErrorCodeProto.CarlifeErrorCode result;
      
      private CarlifeErrorCodeProto.CarlifeErrorCode buildParsed()
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
        localBuilder.result = new CarlifeErrorCodeProto.CarlifeErrorCode(null);
        return localBuilder;
      }
      
      public CarlifeErrorCodeProto.CarlifeErrorCode build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeErrorCodeProto.CarlifeErrorCode buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeErrorCodeProto.CarlifeErrorCode localCarlifeErrorCode = this.result;
        this.result = null;
        return localCarlifeErrorCode;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeErrorCodeProto.CarlifeErrorCode(null);
        return this;
      }
      
      public Builder clearErrorCode()
      {
        CarlifeErrorCodeProto.CarlifeErrorCode.access$502(this.result, false);
        CarlifeErrorCodeProto.CarlifeErrorCode.access$602(this.result, CarlifeErrorCodeProto.CarlifeErrorCode.getDefaultInstance().getErrorCode());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeErrorCodeProto.CarlifeErrorCode getDefaultInstanceForType()
      {
        return CarlifeErrorCodeProto.CarlifeErrorCode.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeErrorCodeProto.CarlifeErrorCode.getDescriptor();
      }
      
      public String getErrorCode()
      {
        return this.result.getErrorCode();
      }
      
      public boolean hasErrorCode()
      {
        return this.result.hasErrorCode();
      }
      
      protected CarlifeErrorCodeProto.CarlifeErrorCode internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeErrorCodeProto.CarlifeErrorCode paramCarlifeErrorCode)
      {
        if (paramCarlifeErrorCode == CarlifeErrorCodeProto.CarlifeErrorCode.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeErrorCode.hasErrorCode()) {
          setErrorCode(paramCarlifeErrorCode.getErrorCode());
        }
        mergeUnknownFields(paramCarlifeErrorCode.getUnknownFields());
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
            setErrorCode(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeErrorCodeProto.CarlifeErrorCode)) {
          return mergeFrom((CarlifeErrorCodeProto.CarlifeErrorCode)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setErrorCode(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeErrorCodeProto.CarlifeErrorCode.access$502(this.result, true);
        CarlifeErrorCodeProto.CarlifeErrorCode.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeErrorCodeProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */