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

public final class CarlifeAuthenRequestProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeAuthenRequestProto.access$702(paramAnonymousFileDescriptor);
        CarlifeAuthenRequestProto.access$002((Descriptors.Descriptor)CarlifeAuthenRequestProto.getDescriptor().getMessageTypes().get(0));
        CarlifeAuthenRequestProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeAuthenRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_descriptor, new String[] { "RandomValue" }, CarlifeAuthenRequestProto.CarlifeAuthenRequest.class, CarlifeAuthenRequestProto.CarlifeAuthenRequest.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\037CarlifeAuthenRequestProto.proto\022\032com.baidu.carlife.protobuf\"+\n\024CarlifeAuthenRequest\022\023\n\013randomValue\030\001 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeAuthenRequest
    extends GeneratedMessage
  {
    public static final int RANDOMVALUE_FIELD_NUMBER = 1;
    private static final CarlifeAuthenRequest defaultInstance = new CarlifeAuthenRequest();
    private boolean hasRandomValue;
    private int memoizedSerializedSize = -1;
    private String randomValue_ = "";
    
    static
    {
      CarlifeAuthenRequestProto.getDescriptor();
      CarlifeAuthenRequestProto.internalForceInit();
    }
    
    public static CarlifeAuthenRequest getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeAuthenRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeAuthenRequest paramCarlifeAuthenRequest)
    {
      return newBuilder().mergeFrom(paramCarlifeAuthenRequest);
    }
    
    public static CarlifeAuthenRequest parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeAuthenRequest parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeAuthenRequest getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getRandomValue()
    {
      return this.randomValue_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasRandomValue()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getRandomValue());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasRandomValue()
    {
      return this.hasRandomValue;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeAuthenRequestProto.internal_static_com_baidu_carlife_protobuf_CarlifeAuthenRequest_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasRandomValue;
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
      if (hasRandomValue()) {
        paramCodedOutputStream.writeString(1, getRandomValue());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeAuthenRequestProto.CarlifeAuthenRequest result;
      
      private CarlifeAuthenRequestProto.CarlifeAuthenRequest buildParsed()
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
        localBuilder.result = new CarlifeAuthenRequestProto.CarlifeAuthenRequest(null);
        return localBuilder;
      }
      
      public CarlifeAuthenRequestProto.CarlifeAuthenRequest build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeAuthenRequestProto.CarlifeAuthenRequest buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeAuthenRequestProto.CarlifeAuthenRequest localCarlifeAuthenRequest = this.result;
        this.result = null;
        return localCarlifeAuthenRequest;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeAuthenRequestProto.CarlifeAuthenRequest(null);
        return this;
      }
      
      public Builder clearRandomValue()
      {
        CarlifeAuthenRequestProto.CarlifeAuthenRequest.access$502(this.result, false);
        CarlifeAuthenRequestProto.CarlifeAuthenRequest.access$602(this.result, CarlifeAuthenRequestProto.CarlifeAuthenRequest.getDefaultInstance().getRandomValue());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeAuthenRequestProto.CarlifeAuthenRequest getDefaultInstanceForType()
      {
        return CarlifeAuthenRequestProto.CarlifeAuthenRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeAuthenRequestProto.CarlifeAuthenRequest.getDescriptor();
      }
      
      public String getRandomValue()
      {
        return this.result.getRandomValue();
      }
      
      public boolean hasRandomValue()
      {
        return this.result.hasRandomValue();
      }
      
      protected CarlifeAuthenRequestProto.CarlifeAuthenRequest internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeAuthenRequestProto.CarlifeAuthenRequest paramCarlifeAuthenRequest)
      {
        if (paramCarlifeAuthenRequest == CarlifeAuthenRequestProto.CarlifeAuthenRequest.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeAuthenRequest.hasRandomValue()) {
          setRandomValue(paramCarlifeAuthenRequest.getRandomValue());
        }
        mergeUnknownFields(paramCarlifeAuthenRequest.getUnknownFields());
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
            setRandomValue(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeAuthenRequestProto.CarlifeAuthenRequest)) {
          return mergeFrom((CarlifeAuthenRequestProto.CarlifeAuthenRequest)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setRandomValue(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeAuthenRequestProto.CarlifeAuthenRequest.access$502(this.result, true);
        CarlifeAuthenRequestProto.CarlifeAuthenRequest.access$602(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeAuthenRequestProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */