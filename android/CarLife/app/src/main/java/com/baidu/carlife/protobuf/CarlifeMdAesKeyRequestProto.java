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

public final class CarlifeMdAesKeyRequestProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeMdAesKeyRequestProto.access$702(paramAnonymousFileDescriptor);
        CarlifeMdAesKeyRequestProto.access$002((Descriptors.Descriptor)CarlifeMdAesKeyRequestProto.getDescriptor().getMessageTypes().get(0));
        CarlifeMdAesKeyRequestProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeMdAesKeyRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_descriptor, new String[] { "AesKey" }, CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.class, CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeMdAesKeyRequestProto.proto\022\032com.baidu.carlife.protobuf\"(\n\026CarlifeMdAesKeyRequest\022\016\n\006aesKey\030\001 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeMdAesKeyRequest
    extends GeneratedMessage
  {
    public static final int AESKEY_FIELD_NUMBER = 1;
    private static final CarlifeMdAesKeyRequest defaultInstance = new CarlifeMdAesKeyRequest();
    private String aesKey_ = "";
    private boolean hasAesKey;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeMdAesKeyRequestProto.getDescriptor();
      CarlifeMdAesKeyRequestProto.internalForceInit();
    }
    
    public static CarlifeMdAesKeyRequest getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeMdAesKeyRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeMdAesKeyRequest paramCarlifeMdAesKeyRequest)
    {
      return newBuilder().mergeFrom(paramCarlifeMdAesKeyRequest);
    }
    
    public static CarlifeMdAesKeyRequest parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeMdAesKeyRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAesKey()
    {
      return this.aesKey_;
    }
    
    public CarlifeMdAesKeyRequest getDefaultInstanceForType()
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
      if (hasAesKey()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getAesKey());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasAesKey()
    {
      return this.hasAesKey;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeMdAesKeyRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeMdAesKeyRequest_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasAesKey;
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
      if (hasAesKey()) {
        paramCodedOutputStream.writeString(1, getAesKey());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest result;
      
      private CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest buildParsed()
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
        localBuilder.result = new CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest(null);
        return localBuilder;
      }
      
      public CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest localCarlifeMdAesKeyRequest = this.result;
        this.result = null;
        return localCarlifeMdAesKeyRequest;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest(null);
        return this;
      }
      
      public Builder clearAesKey()
      {
        CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.access$502(this.result, false);
        CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.access$602(this.result, CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.getDefaultInstance().getAesKey());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public String getAesKey()
      {
        return this.result.getAesKey();
      }
      
      public CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest getDefaultInstanceForType()
      {
        return CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.getDescriptor();
      }
      
      public boolean hasAesKey()
      {
        return this.result.hasAesKey();
      }
      
      protected CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest paramCarlifeMdAesKeyRequest)
      {
        if (paramCarlifeMdAesKeyRequest == CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeMdAesKeyRequest.hasAesKey()) {
          setAesKey(paramCarlifeMdAesKeyRequest.getAesKey());
        }
        mergeUnknownFields(paramCarlifeMdAesKeyRequest.getUnknownFields());
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
            setAesKey(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest)) {
          return mergeFrom((CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAesKey(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.access$502(this.result, true);
        CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeMdAesKeyRequestProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */