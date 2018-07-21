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

public final class CarlifeBTHfpStatusRequestProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusRequest_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusRequest_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTHfpStatusRequestProto.access$702(paramAnonymousFileDescriptor);
        CarlifeBTHfpStatusRequestProto.access$002((Descriptors.Descriptor)CarlifeBTHfpStatusRequestProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTHfpStatusRequestProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTHfpStatusRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusRequest_descriptor, new String[] { "Type" }, CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.class, CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n$CarlifeBTHfpStatusRequestProto.proto\022\032com.baidu.carlife.protobuf\")\n\031CarlifeBTHfpStatusRequest\022\f\n\004type\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTHfpStatusRequest
    extends GeneratedMessage
  {
    public static final int TYPE_FIELD_NUMBER = 1;
    private static final CarlifeBTHfpStatusRequest defaultInstance = new CarlifeBTHfpStatusRequest();
    private boolean hasType;
    private int memoizedSerializedSize = -1;
    private int type_ = 0;
    
    static
    {
      CarlifeBTHfpStatusRequestProto.getDescriptor();
      CarlifeBTHfpStatusRequestProto.internalForceInit();
    }
    
    public static CarlifeBTHfpStatusRequest getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTHfpStatusRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusRequest_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTHfpStatusRequest paramCarlifeBTHfpStatusRequest)
    {
      return newBuilder().mergeFrom(paramCarlifeBTHfpStatusRequest);
    }
    
    public static CarlifeBTHfpStatusRequest parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeBTHfpStatusRequest getDefaultInstanceForType()
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
      if (hasType()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getType());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getType()
    {
      return this.type_;
    }
    
    public boolean hasType()
    {
      return this.hasType;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTHfpStatusRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusRequest_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasType;
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
      if (hasType()) {
        paramCodedOutputStream.writeInt32(1, getType());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest result;
      
      private CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest buildParsed()
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
        localBuilder.result = new CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest(null);
        return localBuilder;
      }
      
      public CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest localCarlifeBTHfpStatusRequest = this.result;
        this.result = null;
        return localCarlifeBTHfpStatusRequest;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest(null);
        return this;
      }
      
      public Builder clearType()
      {
        CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.access$502(this.result, false);
        CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest getDefaultInstanceForType()
      {
        return CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.getDescriptor();
      }
      
      public int getType()
      {
        return this.result.getType();
      }
      
      public boolean hasType()
      {
        return this.result.hasType();
      }
      
      protected CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest paramCarlifeBTHfpStatusRequest)
      {
        if (paramCarlifeBTHfpStatusRequest == CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTHfpStatusRequest.hasType()) {
          setType(paramCarlifeBTHfpStatusRequest.getType());
        }
        mergeUnknownFields(paramCarlifeBTHfpStatusRequest.getUnknownFields());
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
            setType(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest)) {
          return mergeFrom((CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setType(int paramInt)
      {
        CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.access$502(this.result, true);
        CarlifeBTHfpStatusRequestProto.CarlifeBTHfpStatusRequest.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTHfpStatusRequestProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */