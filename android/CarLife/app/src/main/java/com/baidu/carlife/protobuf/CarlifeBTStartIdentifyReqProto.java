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

public final class CarlifeBTStartIdentifyReqProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTStartIdentifyReqProto.access$702(paramAnonymousFileDescriptor);
        CarlifeBTStartIdentifyReqProto.access$002((Descriptors.Descriptor)CarlifeBTStartIdentifyReqProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTStartIdentifyReqProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTStartIdentifyReqProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_descriptor, new String[] { "Address" }, CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.class, CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n$CarlifeBTStartIdentifyReqProto.proto\022\032com.baidu.carlife.protobuf\",\n\031CarlifeBTStartIdentifyReq\022\017\n\007address\030\001 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTStartIdentifyReq
    extends GeneratedMessage
  {
    public static final int ADDRESS_FIELD_NUMBER = 1;
    private static final CarlifeBTStartIdentifyReq defaultInstance = new CarlifeBTStartIdentifyReq();
    private String address_ = "";
    private boolean hasAddress;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeBTStartIdentifyReqProto.getDescriptor();
      CarlifeBTStartIdentifyReqProto.internalForceInit();
    }
    
    public static CarlifeBTStartIdentifyReq getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTStartIdentifyReqProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTStartIdentifyReq paramCarlifeBTStartIdentifyReq)
    {
      return newBuilder().mergeFrom(paramCarlifeBTStartIdentifyReq);
    }
    
    public static CarlifeBTStartIdentifyReq parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTStartIdentifyReq parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAddress()
    {
      return this.address_;
    }
    
    public CarlifeBTStartIdentifyReq getDefaultInstanceForType()
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
      if (hasAddress()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getAddress());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAddress()
    {
      return this.hasAddress;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTStartIdentifyReqProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTStartIdentifyReq_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasAddress;
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
      if (hasAddress()) {
        paramCodedOutputStream.writeString(1, getAddress());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq result;
      
      private CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq buildParsed()
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
        localBuilder.result = new CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq(null);
        return localBuilder;
      }
      
      public CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq localCarlifeBTStartIdentifyReq = this.result;
        this.result = null;
        return localCarlifeBTStartIdentifyReq;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq(null);
        return this;
      }
      
      public Builder clearAddress()
      {
        CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.access$502(this.result, false);
        CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.access$602(this.result, CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.getDefaultInstance().getAddress());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getAddress()
      {
        return this.result.getAddress();
      }
      
      public CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq getDefaultInstanceForType()
      {
        return CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.getDescriptor();
      }
      
      public boolean hasAddress()
      {
        return this.result.hasAddress();
      }
      
      protected CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq paramCarlifeBTStartIdentifyReq)
      {
        if (paramCarlifeBTStartIdentifyReq == CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTStartIdentifyReq.hasAddress()) {
          setAddress(paramCarlifeBTStartIdentifyReq.getAddress());
        }
        mergeUnknownFields(paramCarlifeBTStartIdentifyReq.getUnknownFields());
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
            setAddress(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq)) {
          return mergeFrom((CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.access$502(this.result, true);
        CarlifeBTStartIdentifyReqProto.CarlifeBTStartIdentifyReq.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTStartIdentifyReqProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */