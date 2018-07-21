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

public final class CarlifeVehicleInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeVehicleInfoProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeVehicleInfoProto.access$002((Descriptors.Descriptor)CarlifeVehicleInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeVehicleInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeVehicleInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_descriptor, new String[] { "ModuleID", "Flag", "Frequency" }, CarlifeVehicleInfoProto.CarlifeVehicleInfo.class, CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\035CarlifeVehicleInfoProto.proto\022\032com.baidu.carlife.protobuf\"G\n\022CarlifeVehicleInfo\022\020\n\bmoduleID\030\001 \002(\005\022\f\n\004flag\030\002 \001(\005\022\021\n\tfrequency\030\003 \001(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeVehicleInfo
    extends GeneratedMessage
  {
    public static final int FLAG_FIELD_NUMBER = 2;
    public static final int FREQUENCY_FIELD_NUMBER = 3;
    public static final int MODULEID_FIELD_NUMBER = 1;
    private static final CarlifeVehicleInfo defaultInstance = new CarlifeVehicleInfo();
    private int flag_ = 0;
    private int frequency_ = 0;
    private boolean hasFlag;
    private boolean hasFrequency;
    private boolean hasModuleID;
    private int memoizedSerializedSize = -1;
    private int moduleID_ = 0;
    
    static
    {
      CarlifeVehicleInfoProto.getDescriptor();
      CarlifeVehicleInfoProto.internalForceInit();
    }
    
    public static CarlifeVehicleInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeVehicleInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeVehicleInfo paramCarlifeVehicleInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeVehicleInfo);
    }
    
    public static CarlifeVehicleInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeVehicleInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeVehicleInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFlag()
    {
      return this.flag_;
    }
    
    public int getFrequency()
    {
      return this.frequency_;
    }
    
    public int getModuleID()
    {
      return this.moduleID_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasModuleID()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getModuleID());
      }
      i = j;
      if (hasFlag()) {
        i = j + CodedOutputStream.computeInt32Size(2, getFlag());
      }
      j = i;
      if (hasFrequency()) {
        j = i + CodedOutputStream.computeInt32Size(3, getFrequency());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasFlag()
    {
      return this.hasFlag;
    }
    
    public boolean hasFrequency()
    {
      return this.hasFrequency;
    }
    
    public boolean hasModuleID()
    {
      return this.hasModuleID;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeVehicleInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeVehicleInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasModuleID;
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
      if (hasModuleID()) {
        paramCodedOutputStream.writeInt32(1, getModuleID());
      }
      if (hasFlag()) {
        paramCodedOutputStream.writeInt32(2, getFlag());
      }
      if (hasFrequency()) {
        paramCodedOutputStream.writeInt32(3, getFrequency());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeVehicleInfoProto.CarlifeVehicleInfo result;
      
      private CarlifeVehicleInfoProto.CarlifeVehicleInfo buildParsed()
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
        localBuilder.result = new CarlifeVehicleInfoProto.CarlifeVehicleInfo(null);
        return localBuilder;
      }
      
      public CarlifeVehicleInfoProto.CarlifeVehicleInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeVehicleInfoProto.CarlifeVehicleInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeVehicleInfoProto.CarlifeVehicleInfo localCarlifeVehicleInfo = this.result;
        this.result = null;
        return localCarlifeVehicleInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeVehicleInfoProto.CarlifeVehicleInfo(null);
        return this;
      }
      
      public Builder clearFlag()
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$702(this.result, false);
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$802(this.result, 0);
        return this;
      }
      
      public Builder clearFrequency()
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$902(this.result, false);
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearModuleID()
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$502(this.result, false);
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeVehicleInfoProto.CarlifeVehicleInfo getDefaultInstanceForType()
      {
        return CarlifeVehicleInfoProto.CarlifeVehicleInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeVehicleInfoProto.CarlifeVehicleInfo.getDescriptor();
      }
      
      public int getFlag()
      {
        return this.result.getFlag();
      }
      
      public int getFrequency()
      {
        return this.result.getFrequency();
      }
      
      public int getModuleID()
      {
        return this.result.getModuleID();
      }
      
      public boolean hasFlag()
      {
        return this.result.hasFlag();
      }
      
      public boolean hasFrequency()
      {
        return this.result.hasFrequency();
      }
      
      public boolean hasModuleID()
      {
        return this.result.hasModuleID();
      }
      
      protected CarlifeVehicleInfoProto.CarlifeVehicleInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeVehicleInfoProto.CarlifeVehicleInfo paramCarlifeVehicleInfo)
      {
        if (paramCarlifeVehicleInfo == CarlifeVehicleInfoProto.CarlifeVehicleInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeVehicleInfo.hasModuleID()) {
          setModuleID(paramCarlifeVehicleInfo.getModuleID());
        }
        if (paramCarlifeVehicleInfo.hasFlag()) {
          setFlag(paramCarlifeVehicleInfo.getFlag());
        }
        if (paramCarlifeVehicleInfo.hasFrequency()) {
          setFrequency(paramCarlifeVehicleInfo.getFrequency());
        }
        mergeUnknownFields(paramCarlifeVehicleInfo.getUnknownFields());
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
            setModuleID(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setFlag(paramCodedInputStream.readInt32());
            break;
          case 24: 
            setFrequency(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeVehicleInfoProto.CarlifeVehicleInfo)) {
          return mergeFrom((CarlifeVehicleInfoProto.CarlifeVehicleInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFlag(int paramInt)
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$702(this.result, true);
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$802(this.result, paramInt);
        return this;
      }
      
      public Builder setFrequency(int paramInt)
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$902(this.result, true);
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setModuleID(int paramInt)
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$502(this.result, true);
        CarlifeVehicleInfoProto.CarlifeVehicleInfo.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeVehicleInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */