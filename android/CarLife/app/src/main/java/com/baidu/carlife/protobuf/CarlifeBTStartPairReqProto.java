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

public final class CarlifeBTStartPairReqProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTStartPairReqProto.access$902(paramAnonymousFileDescriptor);
        CarlifeBTStartPairReqProto.access$002((Descriptors.Descriptor)CarlifeBTStartPairReqProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTStartPairReqProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTStartPairReqProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_descriptor, new String[] { "Ostype", "Address" }, CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.class, CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n CarlifeBTStartPairReqProto.proto\022\032com.baidu.carlife.protobuf\"8\n\025CarlifeBTStartPairReq\022\016\n\006ostype\030\001 \002(\005\022\017\n\007address\030\002 \001(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTStartPairReq
    extends GeneratedMessage
  {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int OSTYPE_FIELD_NUMBER = 1;
    private static final CarlifeBTStartPairReq defaultInstance = new CarlifeBTStartPairReq();
    private String address_ = "";
    private boolean hasAddress;
    private boolean hasOstype;
    private int memoizedSerializedSize = -1;
    private int ostype_ = 0;
    
    static
    {
      CarlifeBTStartPairReqProto.getDescriptor();
      CarlifeBTStartPairReqProto.internalForceInit();
    }
    
    public static CarlifeBTStartPairReq getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTStartPairReqProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTStartPairReq paramCarlifeBTStartPairReq)
    {
      return newBuilder().mergeFrom(paramCarlifeBTStartPairReq);
    }
    
    public static CarlifeBTStartPairReq parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTStartPairReq parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAddress()
    {
      return this.address_;
    }
    
    public CarlifeBTStartPairReq getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getOstype()
    {
      return this.ostype_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasOstype()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getOstype());
      }
      int j = i;
      if (hasAddress()) {
        j = i + CodedOutputStream.computeStringSize(2, getAddress());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAddress()
    {
      return this.hasAddress;
    }
    
    public boolean hasOstype()
    {
      return this.hasOstype;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTStartPairReqProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTStartPairReq_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasOstype;
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
      if (hasOstype()) {
        paramCodedOutputStream.writeInt32(1, getOstype());
      }
      if (hasAddress()) {
        paramCodedOutputStream.writeString(2, getAddress());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTStartPairReqProto.CarlifeBTStartPairReq result;
      
      private CarlifeBTStartPairReqProto.CarlifeBTStartPairReq buildParsed()
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
        localBuilder.result = new CarlifeBTStartPairReqProto.CarlifeBTStartPairReq(null);
        return localBuilder;
      }
      
      public CarlifeBTStartPairReqProto.CarlifeBTStartPairReq build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTStartPairReqProto.CarlifeBTStartPairReq buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq localCarlifeBTStartPairReq = this.result;
        this.result = null;
        return localCarlifeBTStartPairReq;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTStartPairReqProto.CarlifeBTStartPairReq(null);
        return this;
      }
      
      public Builder clearAddress()
      {
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$702(this.result, false);
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$802(this.result, CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.getDefaultInstance().getAddress());
        return this;
      }
      
      public Builder clearOstype()
      {
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$502(this.result, false);
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$602(this.result, 0);
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
      
      public CarlifeBTStartPairReqProto.CarlifeBTStartPairReq getDefaultInstanceForType()
      {
        return CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.getDescriptor();
      }
      
      public int getOstype()
      {
        return this.result.getOstype();
      }
      
      public boolean hasAddress()
      {
        return this.result.hasAddress();
      }
      
      public boolean hasOstype()
      {
        return this.result.hasOstype();
      }
      
      protected CarlifeBTStartPairReqProto.CarlifeBTStartPairReq internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTStartPairReqProto.CarlifeBTStartPairReq paramCarlifeBTStartPairReq)
      {
        if (paramCarlifeBTStartPairReq == CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTStartPairReq.hasOstype()) {
          setOstype(paramCarlifeBTStartPairReq.getOstype());
        }
        if (paramCarlifeBTStartPairReq.hasAddress()) {
          setAddress(paramCarlifeBTStartPairReq.getAddress());
        }
        mergeUnknownFields(paramCarlifeBTStartPairReq.getUnknownFields());
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
            setOstype(paramCodedInputStream.readInt32());
            break;
          case 18: 
            setAddress(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTStartPairReqProto.CarlifeBTStartPairReq)) {
          return mergeFrom((CarlifeBTStartPairReqProto.CarlifeBTStartPairReq)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$702(this.result, true);
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setOstype(int paramInt)
      {
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$502(this.result, true);
        CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTStartPairReqProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */