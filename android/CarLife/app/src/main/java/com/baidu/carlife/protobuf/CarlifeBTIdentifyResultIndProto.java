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

public final class CarlifeBTIdentifyResultIndProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeBTIdentifyResultInd_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeBTIdentifyResultInd_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeBTIdentifyResultIndProto.access$902(paramAnonymousFileDescriptor);
        CarlifeBTIdentifyResultIndProto.access$002((Descriptors.Descriptor)CarlifeBTIdentifyResultIndProto.getDescriptor().getMessageTypes().get(0));
        CarlifeBTIdentifyResultIndProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeBTIdentifyResultIndProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTIdentifyResultInd_descriptor, new String[] { "Status", "Address" }, CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.class, CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n%CarlifeBTIdentifyResultIndProto.proto\022\032com.baidu.carlife.protobuf\"=\n\032CarlifeBTIdentifyResultInd\022\016\n\006status\030\001 \002(\005\022\017\n\007address\030\002 \002(\t" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeBTIdentifyResultInd
    extends GeneratedMessage
  {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private static final CarlifeBTIdentifyResultInd defaultInstance = new CarlifeBTIdentifyResultInd();
    private String address_ = "";
    private boolean hasAddress;
    private boolean hasStatus;
    private int memoizedSerializedSize = -1;
    private int status_ = 0;
    
    static
    {
      CarlifeBTIdentifyResultIndProto.getDescriptor();
      CarlifeBTIdentifyResultIndProto.internalForceInit();
    }
    
    public static CarlifeBTIdentifyResultInd getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeBTIdentifyResultIndProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTIdentifyResultInd_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeBTIdentifyResultInd paramCarlifeBTIdentifyResultInd)
    {
      return newBuilder().mergeFrom(paramCarlifeBTIdentifyResultInd);
    }
    
    public static CarlifeBTIdentifyResultInd parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeBTIdentifyResultInd parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public String getAddress()
    {
      return this.address_;
    }
    
    public CarlifeBTIdentifyResultInd getDefaultInstanceForType()
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
      if (hasAddress()) {
        j = i + CodedOutputStream.computeStringSize(2, getAddress());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getStatus()
    {
      return this.status_;
    }
    
    public boolean hasAddress()
    {
      return this.hasAddress;
    }
    
    public boolean hasStatus()
    {
      return this.hasStatus;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeBTIdentifyResultIndProto.internal_static_com_baidu_carlife_protobuf_CarlifeBTIdentifyResultInd_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasStatus) {}
      while (!this.hasAddress) {
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
      if (hasAddress()) {
        paramCodedOutputStream.writeString(2, getAddress());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd result;
      
      private CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd buildParsed()
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
        localBuilder.result = new CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd(null);
        return localBuilder;
      }
      
      public CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd localCarlifeBTIdentifyResultInd = this.result;
        this.result = null;
        return localCarlifeBTIdentifyResultInd;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd(null);
        return this;
      }
      
      public Builder clearAddress()
      {
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$702(this.result, false);
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$802(this.result, CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.getDefaultInstance().getAddress());
        return this;
      }
      
      public Builder clearStatus()
      {
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$502(this.result, false);
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$602(this.result, 0);
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
      
      public CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd getDefaultInstanceForType()
      {
        return CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.getDescriptor();
      }
      
      public int getStatus()
      {
        return this.result.getStatus();
      }
      
      public boolean hasAddress()
      {
        return this.result.hasAddress();
      }
      
      public boolean hasStatus()
      {
        return this.result.hasStatus();
      }
      
      protected CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd paramCarlifeBTIdentifyResultInd)
      {
        if (paramCarlifeBTIdentifyResultInd == CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeBTIdentifyResultInd.hasStatus()) {
          setStatus(paramCarlifeBTIdentifyResultInd.getStatus());
        }
        if (paramCarlifeBTIdentifyResultInd.hasAddress()) {
          setAddress(paramCarlifeBTIdentifyResultInd.getAddress());
        }
        mergeUnknownFields(paramCarlifeBTIdentifyResultInd.getUnknownFields());
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
          case 18: 
            setAddress(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd)) {
          return mergeFrom((CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAddress(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$702(this.result, true);
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$802(this.result, paramString);
        return this;
      }
      
      public Builder setStatus(int paramInt)
      {
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$502(this.result, true);
        CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeBTIdentifyResultIndProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */