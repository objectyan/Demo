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

public final class CarlifeSubscribeMobileCarLifeInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeSubscribeMobileCarLifeInfoProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeSubscribeMobileCarLifeInfoProto.access$002((Descriptors.Descriptor)CarlifeSubscribeMobileCarLifeInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeSubscribeMobileCarLifeInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeSubscribeMobileCarLifeInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_descriptor, new String[] { "ModuleID", "SupportFlag", "Frequency" }, CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.class, CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n,CarlifeSubscribeMobileCarLifeInfoProto.proto\022\032com.baidu.carlife.protobuf\"]\n!CarlifeSubscribeMobileCarLifeInfo\022\020\n\bmoduleID\030\001 \002(\005\022\023\n\013supportFlag\030\002 \001(\b\022\021\n\tfrequency\030\003 \001(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeSubscribeMobileCarLifeInfo
    extends GeneratedMessage
  {
    public static final int FREQUENCY_FIELD_NUMBER = 3;
    public static final int MODULEID_FIELD_NUMBER = 1;
    public static final int SUPPORTFLAG_FIELD_NUMBER = 2;
    private static final CarlifeSubscribeMobileCarLifeInfo defaultInstance = new CarlifeSubscribeMobileCarLifeInfo();
    private int frequency_ = 0;
    private boolean hasFrequency;
    private boolean hasModuleID;
    private boolean hasSupportFlag;
    private int memoizedSerializedSize = -1;
    private int moduleID_ = 0;
    private boolean supportFlag_ = false;
    
    static
    {
      CarlifeSubscribeMobileCarLifeInfoProto.getDescriptor();
      CarlifeSubscribeMobileCarLifeInfoProto.internalForceInit();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeSubscribeMobileCarLifeInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeSubscribeMobileCarLifeInfo paramCarlifeSubscribeMobileCarLifeInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeSubscribeMobileCarLifeInfo);
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeSubscribeMobileCarLifeInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeSubscribeMobileCarLifeInfo getDefaultInstanceForType()
    {
      return defaultInstance;
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
      if (hasSupportFlag()) {
        i = j + CodedOutputStream.computeBoolSize(2, getSupportFlag());
      }
      j = i;
      if (hasFrequency()) {
        j = i + CodedOutputStream.computeInt32Size(3, getFrequency());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean getSupportFlag()
    {
      return this.supportFlag_;
    }
    
    public boolean hasFrequency()
    {
      return this.hasFrequency;
    }
    
    public boolean hasModuleID()
    {
      return this.hasModuleID;
    }
    
    public boolean hasSupportFlag()
    {
      return this.hasSupportFlag;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeSubscribeMobileCarLifeInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeSubscribeMobileCarLifeInfo_fieldAccessorTable;
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
      if (hasSupportFlag()) {
        paramCodedOutputStream.writeBool(2, getSupportFlag());
      }
      if (hasFrequency()) {
        paramCodedOutputStream.writeInt32(3, getFrequency());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo result;
      
      private CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo buildParsed()
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
        localBuilder.result = new CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo(null);
        return localBuilder;
      }
      
      public CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo localCarlifeSubscribeMobileCarLifeInfo = this.result;
        this.result = null;
        return localCarlifeSubscribeMobileCarLifeInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo(null);
        return this;
      }
      
      public Builder clearFrequency()
      {
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$902(this.result, false);
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clearModuleID()
      {
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$502(this.result, false);
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearSupportFlag()
      {
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$702(this.result, false);
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$802(this.result, false);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo getDefaultInstanceForType()
      {
        return CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.getDescriptor();
      }
      
      public int getFrequency()
      {
        return this.result.getFrequency();
      }
      
      public int getModuleID()
      {
        return this.result.getModuleID();
      }
      
      public boolean getSupportFlag()
      {
        return this.result.getSupportFlag();
      }
      
      public boolean hasFrequency()
      {
        return this.result.hasFrequency();
      }
      
      public boolean hasModuleID()
      {
        return this.result.hasModuleID();
      }
      
      public boolean hasSupportFlag()
      {
        return this.result.hasSupportFlag();
      }
      
      protected CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo paramCarlifeSubscribeMobileCarLifeInfo)
      {
        if (paramCarlifeSubscribeMobileCarLifeInfo == CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeSubscribeMobileCarLifeInfo.hasModuleID()) {
          setModuleID(paramCarlifeSubscribeMobileCarLifeInfo.getModuleID());
        }
        if (paramCarlifeSubscribeMobileCarLifeInfo.hasSupportFlag()) {
          setSupportFlag(paramCarlifeSubscribeMobileCarLifeInfo.getSupportFlag());
        }
        if (paramCarlifeSubscribeMobileCarLifeInfo.hasFrequency()) {
          setFrequency(paramCarlifeSubscribeMobileCarLifeInfo.getFrequency());
        }
        mergeUnknownFields(paramCarlifeSubscribeMobileCarLifeInfo.getUnknownFields());
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
            setSupportFlag(paramCodedInputStream.readBool());
            break;
          case 24: 
            setFrequency(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo)) {
          return mergeFrom((CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFrequency(int paramInt)
      {
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$902(this.result, true);
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$1002(this.result, paramInt);
        return this;
      }
      
      public Builder setModuleID(int paramInt)
      {
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$502(this.result, true);
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setSupportFlag(boolean paramBoolean)
      {
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$702(this.result, true);
        CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.access$802(this.result, paramBoolean);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeSubscribeMobileCarLifeInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */