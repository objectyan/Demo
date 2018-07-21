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

public final class CarlifeAuthenResponseProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeAuthenResponseProto.access$702(paramAnonymousFileDescriptor);
        CarlifeAuthenResponseProto.access$002((Descriptors.Descriptor)CarlifeAuthenResponseProto.getDescriptor().getMessageTypes().get(0));
        CarlifeAuthenResponseProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeAuthenResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_descriptor, new String[] { "EncryptValue" }, CarlifeAuthenResponseProto.CarlifeAuthenResponse.class, CarlifeAuthenResponseProto.CarlifeAuthenResponse.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n CarlifeAuthenResponseProto.proto\022\032com.baidu.carlife.protobuf\"-\n\025CarlifeAuthenResponse\022\024\n\fencryptValue\030\001 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeAuthenResponse
    extends GeneratedMessage
  {
    public static final int ENCRYPTVALUE_FIELD_NUMBER = 1;
    private static final CarlifeAuthenResponse defaultInstance = new CarlifeAuthenResponse();
    private String encryptValue_ = "";
    private boolean hasEncryptValue;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeAuthenResponseProto.getDescriptor();
      CarlifeAuthenResponseProto.internalForceInit();
    }
    
    public static CarlifeAuthenResponse getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeAuthenResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeAuthenResponse paramCarlifeAuthenResponse)
    {
      return newBuilder().mergeFrom(paramCarlifeAuthenResponse);
    }
    
    public static CarlifeAuthenResponse parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeAuthenResponse parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeAuthenResponse getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getEncryptValue()
    {
      return this.encryptValue_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasEncryptValue()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getEncryptValue());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasEncryptValue()
    {
      return this.hasEncryptValue;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeAuthenResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenResponse_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasEncryptValue;
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
      if (hasEncryptValue()) {
        paramCodedOutputStream.writeString(1, getEncryptValue());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeAuthenResponseProto.CarlifeAuthenResponse result;
      
      private CarlifeAuthenResponseProto.CarlifeAuthenResponse buildParsed()
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
        localBuilder.result = new CarlifeAuthenResponseProto.CarlifeAuthenResponse(null);
        return localBuilder;
      }
      
      public CarlifeAuthenResponseProto.CarlifeAuthenResponse build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeAuthenResponseProto.CarlifeAuthenResponse buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeAuthenResponseProto.CarlifeAuthenResponse localCarlifeAuthenResponse = this.result;
        this.result = null;
        return localCarlifeAuthenResponse;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeAuthenResponseProto.CarlifeAuthenResponse(null);
        return this;
      }
      
      public Builder clearEncryptValue()
      {
        CarlifeAuthenResponseProto.CarlifeAuthenResponse.access$502(this.result, false);
        CarlifeAuthenResponseProto.CarlifeAuthenResponse.access$602(this.result, CarlifeAuthenResponseProto.CarlifeAuthenResponse.getDefaultInstance().getEncryptValue());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeAuthenResponseProto.CarlifeAuthenResponse getDefaultInstanceForType()
      {
        return CarlifeAuthenResponseProto.CarlifeAuthenResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeAuthenResponseProto.CarlifeAuthenResponse.getDescriptor();
      }
      
      public String getEncryptValue()
      {
        return this.result.getEncryptValue();
      }
      
      public boolean hasEncryptValue()
      {
        return this.result.hasEncryptValue();
      }
      
      protected CarlifeAuthenResponseProto.CarlifeAuthenResponse internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeAuthenResponseProto.CarlifeAuthenResponse paramCarlifeAuthenResponse)
      {
        if (paramCarlifeAuthenResponse == CarlifeAuthenResponseProto.CarlifeAuthenResponse.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeAuthenResponse.hasEncryptValue()) {
          setEncryptValue(paramCarlifeAuthenResponse.getEncryptValue());
        }
        mergeUnknownFields(paramCarlifeAuthenResponse.getUnknownFields());
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
            setEncryptValue(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeAuthenResponseProto.CarlifeAuthenResponse)) {
          return mergeFrom((CarlifeAuthenResponseProto.CarlifeAuthenResponse)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setEncryptValue(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeAuthenResponseProto.CarlifeAuthenResponse.access$502(this.result, true);
        CarlifeAuthenResponseProto.CarlifeAuthenResponse.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeAuthenResponseProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */