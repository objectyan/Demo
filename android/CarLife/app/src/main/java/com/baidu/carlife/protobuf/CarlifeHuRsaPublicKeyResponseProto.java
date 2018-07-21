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

public final class CarlifeHuRsaPublicKeyResponseProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeHuRsaPublicKeyResponseProto.access$702(paramAnonymousFileDescriptor);
        CarlifeHuRsaPublicKeyResponseProto.access$002((Descriptors.Descriptor)CarlifeHuRsaPublicKeyResponseProto.getDescriptor().getMessageTypes().get(0));
        CarlifeHuRsaPublicKeyResponseProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeHuRsaPublicKeyResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_descriptor, new String[] { "RsaPublicKey" }, CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.class, CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n(CarlifeHuRsaPublicKeyResponseProto.proto\022\032com.baidu.carlife.protobuf\"5\n\035CarlifeHuRsaPublicKeyResponse\022\024\n\frsaPublicKey\030\001 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeHuRsaPublicKeyResponse
    extends GeneratedMessage
  {
    public static final int RSAPUBLICKEY_FIELD_NUMBER = 1;
    private static final CarlifeHuRsaPublicKeyResponse defaultInstance = new CarlifeHuRsaPublicKeyResponse();
    private boolean hasRsaPublicKey;
    private int memoizedSerializedSize = -1;
    private String rsaPublicKey_ = "";
    
    static
    {
      CarlifeHuRsaPublicKeyResponseProto.getDescriptor();
      CarlifeHuRsaPublicKeyResponseProto.internalForceInit();
    }
    
    public static CarlifeHuRsaPublicKeyResponse getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeHuRsaPublicKeyResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeHuRsaPublicKeyResponse paramCarlifeHuRsaPublicKeyResponse)
    {
      return newBuilder().mergeFrom(paramCarlifeHuRsaPublicKeyResponse);
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeHuRsaPublicKeyResponse parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeHuRsaPublicKeyResponse getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getRsaPublicKey()
    {
      return this.rsaPublicKey_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasRsaPublicKey()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getRsaPublicKey());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasRsaPublicKey()
    {
      return this.hasRsaPublicKey;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeHuRsaPublicKeyResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeHuRsaPublicKeyResponse_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasRsaPublicKey;
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
      if (hasRsaPublicKey()) {
        paramCodedOutputStream.writeString(1, getRsaPublicKey());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse result;
      
      private CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse buildParsed()
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
        localBuilder.result = new CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse(null);
        return localBuilder;
      }
      
      public CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse localCarlifeHuRsaPublicKeyResponse = this.result;
        this.result = null;
        return localCarlifeHuRsaPublicKeyResponse;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse(null);
        return this;
      }
      
      public Builder clearRsaPublicKey()
      {
        CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.access$502(this.result, false);
        CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.access$602(this.result, CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.getDefaultInstance().getRsaPublicKey());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse getDefaultInstanceForType()
      {
        return CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.getDescriptor();
      }
      
      public String getRsaPublicKey()
      {
        return this.result.getRsaPublicKey();
      }
      
      public boolean hasRsaPublicKey()
      {
        return this.result.hasRsaPublicKey();
      }
      
      protected CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse paramCarlifeHuRsaPublicKeyResponse)
      {
        if (paramCarlifeHuRsaPublicKeyResponse == CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeHuRsaPublicKeyResponse.hasRsaPublicKey()) {
          setRsaPublicKey(paramCarlifeHuRsaPublicKeyResponse.getRsaPublicKey());
        }
        mergeUnknownFields(paramCarlifeHuRsaPublicKeyResponse.getUnknownFields());
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
            setRsaPublicKey(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse)) {
          return mergeFrom((CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setRsaPublicKey(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.access$502(this.result, true);
        CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeHuRsaPublicKeyResponseProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */