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

public final class CarlifeSystemInfoProtos
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_carlife_protobuf_CarlifeSystemInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeSystemInfoProtos.access$902(paramAnonymousFileDescriptor);
        CarlifeSystemInfoProtos.access$002((Descriptors.Descriptor)CarlifeSystemInfoProtos.getDescriptor().getMessageTypes().get(0));
        CarlifeSystemInfoProtos.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeSystemInfoProtos.internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor, new String[] { "FirmwareVersionCode", "UpdateUrl" }, CarlifeSystemInfoProtos.CarlifeSystemInfo.class, CarlifeSystemInfoProtos.CarlifeSystemInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\tota.proto\022\020carlife.protobuf\"C\n\021CarlifeSystemInfo\022\033\n\023firmwareVersionCode\030\001 \002(\005\022\021\n\tupdateUrl\030\002 \002(\tB5\n\032com.baidu.carlife.protobufB\027CarlifeSystemInfoProtos" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeSystemInfo
    extends GeneratedMessage
  {
    public static final int FIRMWAREVERSIONCODE_FIELD_NUMBER = 1;
    public static final int UPDATEURL_FIELD_NUMBER = 2;
    private static final CarlifeSystemInfo defaultInstance = new CarlifeSystemInfo();
    private int firmwareVersionCode_ = 0;
    private boolean hasFirmwareVersionCode;
    private boolean hasUpdateUrl;
    private int memoizedSerializedSize = -1;
    private String updateUrl_ = "";
    
    static
    {
      CarlifeSystemInfoProtos.getDescriptor();
      CarlifeSystemInfoProtos.internalForceInit();
    }
    
    public static CarlifeSystemInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeSystemInfoProtos.internal_static_carlife_protobuf_CarlifeSystemInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeSystemInfo paramCarlifeSystemInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeSystemInfo);
    }
    
    public static CarlifeSystemInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeSystemInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeSystemInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFirmwareVersionCode()
    {
      return this.firmwareVersionCode_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasFirmwareVersionCode()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getFirmwareVersionCode());
      }
      int j = i;
      if (hasUpdateUrl()) {
        j = i + CodedOutputStream.computeStringSize(2, getUpdateUrl());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getUpdateUrl()
    {
      return this.updateUrl_;
    }
    
    public boolean hasFirmwareVersionCode()
    {
      return this.hasFirmwareVersionCode;
    }
    
    public boolean hasUpdateUrl()
    {
      return this.hasUpdateUrl;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeSystemInfoProtos.internal_static_carlife_protobuf_CarlifeSystemInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasFirmwareVersionCode) {}
      while (!this.hasUpdateUrl) {
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
      if (hasFirmwareVersionCode()) {
        paramCodedOutputStream.writeInt32(1, getFirmwareVersionCode());
      }
      if (hasUpdateUrl()) {
        paramCodedOutputStream.writeString(2, getUpdateUrl());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeSystemInfoProtos.CarlifeSystemInfo result;
      
      private CarlifeSystemInfoProtos.CarlifeSystemInfo buildParsed()
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
        localBuilder.result = new CarlifeSystemInfoProtos.CarlifeSystemInfo(null);
        return localBuilder;
      }
      
      public CarlifeSystemInfoProtos.CarlifeSystemInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeSystemInfoProtos.CarlifeSystemInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeSystemInfoProtos.CarlifeSystemInfo localCarlifeSystemInfo = this.result;
        this.result = null;
        return localCarlifeSystemInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeSystemInfoProtos.CarlifeSystemInfo(null);
        return this;
      }
      
      public Builder clearFirmwareVersionCode()
      {
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$502(this.result, false);
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearUpdateUrl()
      {
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$702(this.result, false);
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$802(this.result, CarlifeSystemInfoProtos.CarlifeSystemInfo.getDefaultInstance().getUpdateUrl());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeSystemInfoProtos.CarlifeSystemInfo getDefaultInstanceForType()
      {
        return CarlifeSystemInfoProtos.CarlifeSystemInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeSystemInfoProtos.CarlifeSystemInfo.getDescriptor();
      }
      
      public int getFirmwareVersionCode()
      {
        return this.result.getFirmwareVersionCode();
      }
      
      public String getUpdateUrl()
      {
        return this.result.getUpdateUrl();
      }
      
      public boolean hasFirmwareVersionCode()
      {
        return this.result.hasFirmwareVersionCode();
      }
      
      public boolean hasUpdateUrl()
      {
        return this.result.hasUpdateUrl();
      }
      
      protected CarlifeSystemInfoProtos.CarlifeSystemInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeSystemInfoProtos.CarlifeSystemInfo paramCarlifeSystemInfo)
      {
        if (paramCarlifeSystemInfo == CarlifeSystemInfoProtos.CarlifeSystemInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeSystemInfo.hasFirmwareVersionCode()) {
          setFirmwareVersionCode(paramCarlifeSystemInfo.getFirmwareVersionCode());
        }
        if (paramCarlifeSystemInfo.hasUpdateUrl()) {
          setUpdateUrl(paramCarlifeSystemInfo.getUpdateUrl());
        }
        mergeUnknownFields(paramCarlifeSystemInfo.getUnknownFields());
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
            setFirmwareVersionCode(paramCodedInputStream.readInt32());
            break;
          case 18: 
            setUpdateUrl(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeSystemInfoProtos.CarlifeSystemInfo)) {
          return mergeFrom((CarlifeSystemInfoProtos.CarlifeSystemInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFirmwareVersionCode(int paramInt)
      {
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$502(this.result, true);
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setUpdateUrl(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$702(this.result, true);
        CarlifeSystemInfoProtos.CarlifeSystemInfo.access$802(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeSystemInfoProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */