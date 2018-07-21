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

public final class CarlifeDeviceVersionInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeDeviceVersionInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeDeviceVersionInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeDeviceVersionInfoProto.access$902(paramAnonymousFileDescriptor);
        CarlifeDeviceVersionInfoProto.access$002((Descriptors.Descriptor)CarlifeDeviceVersionInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeDeviceVersionInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_descriptor, new String[] { "DeviceName", "VersionCode" }, CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.class, CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n#CarlifeDeviceVersionInfoProto.proto\"C\n\030CarlifeDeviceVersionInfo\022\022\n\ndeviceName\030\001 \002(\t\022\023\n\013versionCode\030\002 \002(\tB\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeDeviceVersionInfo
    extends GeneratedMessage
  {
    public static final int DEVICENAME_FIELD_NUMBER = 1;
    public static final int VERSIONCODE_FIELD_NUMBER = 2;
    private static final CarlifeDeviceVersionInfo defaultInstance = new CarlifeDeviceVersionInfo();
    private String deviceName_ = "";
    private boolean hasDeviceName;
    private boolean hasVersionCode;
    private int memoizedSerializedSize = -1;
    private String versionCode_ = "";
    
    static
    {
      CarlifeDeviceVersionInfoProto.getDescriptor();
      CarlifeDeviceVersionInfoProto.internalForceInit();
    }
    
    public static CarlifeDeviceVersionInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeDeviceVersionInfo paramCarlifeDeviceVersionInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeDeviceVersionInfo);
    }
    
    public static CarlifeDeviceVersionInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeDeviceVersionInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeDeviceVersionInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public String getDeviceName()
    {
      return this.deviceName_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasDeviceName()) {
        i = 0 + CodedOutputStream.computeStringSize(1, getDeviceName());
      }
      int j = i;
      if (hasVersionCode()) {
        j = i + CodedOutputStream.computeStringSize(2, getVersionCode());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public String getVersionCode()
    {
      return this.versionCode_;
    }
    
    public boolean hasDeviceName()
    {
      return this.hasDeviceName;
    }
    
    public boolean hasVersionCode()
    {
      return this.hasVersionCode;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeDeviceVersionInfoProto.internal_static_CarlifeDeviceVersionInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasDeviceName) {}
      while (!this.hasVersionCode) {
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
      if (hasDeviceName()) {
        paramCodedOutputStream.writeString(1, getDeviceName());
      }
      if (hasVersionCode()) {
        paramCodedOutputStream.writeString(2, getVersionCode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo result;
      
      private CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo buildParsed()
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
        localBuilder.result = new CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo(null);
        return localBuilder;
      }
      
      public CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo localCarlifeDeviceVersionInfo = this.result;
        this.result = null;
        return localCarlifeDeviceVersionInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo(null);
        return this;
      }
      
      public Builder clearDeviceName()
      {
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$502(this.result, false);
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$602(this.result, CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.getDefaultInstance().getDeviceName());
        return this;
      }
      
      public Builder clearVersionCode()
      {
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$702(this.result, false);
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$802(this.result, CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.getDefaultInstance().getVersionCode());
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo getDefaultInstanceForType()
      {
        return CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.getDescriptor();
      }
      
      public String getDeviceName()
      {
        return this.result.getDeviceName();
      }
      
      public String getVersionCode()
      {
        return this.result.getVersionCode();
      }
      
      public boolean hasDeviceName()
      {
        return this.result.hasDeviceName();
      }
      
      public boolean hasVersionCode()
      {
        return this.result.hasVersionCode();
      }
      
      protected CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo paramCarlifeDeviceVersionInfo)
      {
        if (paramCarlifeDeviceVersionInfo == CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeDeviceVersionInfo.hasDeviceName()) {
          setDeviceName(paramCarlifeDeviceVersionInfo.getDeviceName());
        }
        if (paramCarlifeDeviceVersionInfo.hasVersionCode()) {
          setVersionCode(paramCarlifeDeviceVersionInfo.getVersionCode());
        }
        mergeUnknownFields(paramCarlifeDeviceVersionInfo.getUnknownFields());
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
            setDeviceName(paramCodedInputStream.readString());
            break;
          case 18: 
            setVersionCode(paramCodedInputStream.readString());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo)) {
          return mergeFrom((CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setDeviceName(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$502(this.result, true);
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$602(this.result, paramString);
        return this;
      }
      
      public Builder setVersionCode(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$702(this.result, true);
        CarlifeDeviceVersionInfoProto.CarlifeDeviceVersionInfo.access$802(this.result, paramString);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeDeviceVersionInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */