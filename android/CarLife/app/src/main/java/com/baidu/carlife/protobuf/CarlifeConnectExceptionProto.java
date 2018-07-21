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

public final class CarlifeConnectExceptionProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeConnectExceptionProto.access$702(paramAnonymousFileDescriptor);
        CarlifeConnectExceptionProto.access$002((Descriptors.Descriptor)CarlifeConnectExceptionProto.getDescriptor().getMessageTypes().get(0));
        CarlifeConnectExceptionProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeConnectExceptionProto.internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_descriptor, new String[] { "ExceptionType" }, CarlifeConnectExceptionProto.CarlifeConnectException.class, CarlifeConnectExceptionProto.CarlifeConnectException.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeConnectExceptionProto.proto\022\032com.baidu.carlife.protobuf\"0\n\027CarlifeConnectException\022\025\n\rexceptionType\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeConnectException
    extends GeneratedMessage
  {
    public static final int EXCEPTIONTYPE_FIELD_NUMBER = 1;
    private static final CarlifeConnectException defaultInstance = new CarlifeConnectException();
    private int exceptionType_ = 0;
    private boolean hasExceptionType;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeConnectExceptionProto.getDescriptor();
      CarlifeConnectExceptionProto.internalForceInit();
    }
    
    public static CarlifeConnectException getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeConnectExceptionProto.internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeConnectException paramCarlifeConnectException)
    {
      return newBuilder().mergeFrom(paramCarlifeConnectException);
    }
    
    public static CarlifeConnectException parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeConnectException parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeConnectException parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeConnectException getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getExceptionType()
    {
      return this.exceptionType_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasExceptionType()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getExceptionType());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasExceptionType()
    {
      return this.hasExceptionType;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeConnectExceptionProto.internal_static_com_baidu_carlife_protobuf_CarlifeConnectException_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasExceptionType;
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
      if (hasExceptionType()) {
        paramCodedOutputStream.writeInt32(1, getExceptionType());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeConnectExceptionProto.CarlifeConnectException result;
      
      private CarlifeConnectExceptionProto.CarlifeConnectException buildParsed()
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
        localBuilder.result = new CarlifeConnectExceptionProto.CarlifeConnectException(null);
        return localBuilder;
      }
      
      public CarlifeConnectExceptionProto.CarlifeConnectException build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeConnectExceptionProto.CarlifeConnectException buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeConnectExceptionProto.CarlifeConnectException localCarlifeConnectException = this.result;
        this.result = null;
        return localCarlifeConnectException;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeConnectExceptionProto.CarlifeConnectException(null);
        return this;
      }
      
      public Builder clearExceptionType()
      {
        CarlifeConnectExceptionProto.CarlifeConnectException.access$502(this.result, false);
        CarlifeConnectExceptionProto.CarlifeConnectException.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeConnectExceptionProto.CarlifeConnectException getDefaultInstanceForType()
      {
        return CarlifeConnectExceptionProto.CarlifeConnectException.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeConnectExceptionProto.CarlifeConnectException.getDescriptor();
      }
      
      public int getExceptionType()
      {
        return this.result.getExceptionType();
      }
      
      public boolean hasExceptionType()
      {
        return this.result.hasExceptionType();
      }
      
      protected CarlifeConnectExceptionProto.CarlifeConnectException internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeConnectExceptionProto.CarlifeConnectException paramCarlifeConnectException)
      {
        if (paramCarlifeConnectException == CarlifeConnectExceptionProto.CarlifeConnectException.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeConnectException.hasExceptionType()) {
          setExceptionType(paramCarlifeConnectException.getExceptionType());
        }
        mergeUnknownFields(paramCarlifeConnectException.getUnknownFields());
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
            setExceptionType(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeConnectExceptionProto.CarlifeConnectException)) {
          return mergeFrom((CarlifeConnectExceptionProto.CarlifeConnectException)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setExceptionType(int paramInt)
      {
        CarlifeConnectExceptionProto.CarlifeConnectException.access$502(this.result, true);
        CarlifeConnectExceptionProto.CarlifeConnectException.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeConnectExceptionProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */