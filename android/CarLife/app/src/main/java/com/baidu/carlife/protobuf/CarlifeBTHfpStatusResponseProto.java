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

public final class CarlifeBTHfpStatusResponseProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTHfpStatusResponseProto.access$902(paramAnonymousFileDescriptor);
        CarlifeBTHfpStatusResponseProto.access$002((Descriptors.Descriptor)CarlifeBTHfpStatusResponseProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTHfpStatusResponseProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTHfpStatusResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_descriptor, new String[] { "Status", "Type" }, CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.class, CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n%CarlifeBTHfpStatusResponseProto.proto\022\032com.baidu.carlife.protobuf\":\n\032CarlifeBTHfpStatusResponse\022\016\n\006status\030\001 \002(\005\022\f\n\004type\030\002 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTHfpStatusResponse
    extends GeneratedMessage
  {
    public static final int STATUS_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 2;
    private static final CarlifeBTHfpStatusResponse defaultInstance = new CarlifeBTHfpStatusResponse();
    private boolean hasStatus;
    private boolean hasType;
    private int memoizedSerializedSize = -1;
    private int status_ = 0;
    private int type_ = 0;
    
    static
    {
      CarlifeBTHfpStatusResponseProto.getDescriptor();
      CarlifeBTHfpStatusResponseProto.internalForceInit();
    }
    
    public static CarlifeBTHfpStatusResponse getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTHfpStatusResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTHfpStatusResponse paramCarlifeBTHfpStatusResponse)
    {
      return newBuilder().mergeFrom(paramCarlifeBTHfpStatusResponse);
    }
    
    public static CarlifeBTHfpStatusResponse parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTHfpStatusResponse parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeBTHfpStatusResponse getDefaultInstanceForType()
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
      if (hasStatus()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getStatus());
      }
      int j = i;
      if (hasType()) {
        j = i + CodedOutputStream.computeInt32Size(2, getType());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getStatus()
    {
      return this.status_;
    }
    
    public int getType()
    {
      return this.type_;
    }
    
    public boolean hasStatus()
    {
      return this.hasStatus;
    }
    
    public boolean hasType()
    {
      return this.hasType;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTHfpStatusResponseProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTHfpStatusResponse_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasStatus) {}
      while (!this.hasType) {
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
      if (hasStatus()) {
        paramCodedOutputStream.writeInt32(1, getStatus());
      }
      if (hasType()) {
        paramCodedOutputStream.writeInt32(2, getType());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse result;
      
      private CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse buildParsed()
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
        localBuilder.result = new CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse(null);
        return localBuilder;
      }
      
      public CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse localCarlifeBTHfpStatusResponse = this.result;
        this.result = null;
        return localCarlifeBTHfpStatusResponse;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse(null);
        return this;
      }
      
      public Builder clearStatus()
      {
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$502(this.result, false);
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearType()
      {
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$702(this.result, false);
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$802(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse getDefaultInstanceForType()
      {
        return CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.getDescriptor();
      }
      
      public int getStatus()
      {
        return this.result.getStatus();
      }
      
      public int getType()
      {
        return this.result.getType();
      }
      
      public boolean hasStatus()
      {
        return this.result.hasStatus();
      }
      
      public boolean hasType()
      {
        return this.result.hasType();
      }
      
      protected CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse paramCarlifeBTHfpStatusResponse)
      {
        if (paramCarlifeBTHfpStatusResponse == CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTHfpStatusResponse.hasStatus()) {
          setStatus(paramCarlifeBTHfpStatusResponse.getStatus());
        }
        if (paramCarlifeBTHfpStatusResponse.hasType()) {
          setType(paramCarlifeBTHfpStatusResponse.getType());
        }
        mergeUnknownFields(paramCarlifeBTHfpStatusResponse.getUnknownFields());
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
            setStatus(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setType(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse)) {
          return mergeFrom((CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setStatus(int paramInt)
      {
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$502(this.result, true);
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setType(int paramInt)
      {
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$702(this.result, true);
        CarlifeBTHfpStatusResponseProto.CarlifeBTHfpStatusResponse.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTHfpStatusResponseProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */