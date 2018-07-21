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

public final class CarlifeGearInfoProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeGearInfoProto.access$702(paramAnonymousFileDescriptor);
        CarlifeGearInfoProto.access$002((Descriptors.Descriptor)CarlifeGearInfoProto.getDescriptor().getMessageTypes().get(0));
        CarlifeGearInfoProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeGearInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_descriptor, new String[] { "Gear" }, CarlifeGearInfoProto.CarlifeGearInfo.class, CarlifeGearInfoProto.CarlifeGearInfo.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\032CarlifeGearInfoProto.proto\022\032com.baidu.carlife.protobuf\"\037\n\017CarlifeGearInfo\022\f\n\004gear\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeGearInfo
    extends GeneratedMessage
  {
    public static final int GEAR_FIELD_NUMBER = 1;
    private static final CarlifeGearInfo defaultInstance = new CarlifeGearInfo();
    private int gear_ = 0;
    private boolean hasGear;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeGearInfoProto.getDescriptor();
      CarlifeGearInfoProto.internalForceInit();
    }
    
    public static CarlifeGearInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeGearInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeGearInfo paramCarlifeGearInfo)
    {
      return newBuilder().mergeFrom(paramCarlifeGearInfo);
    }
    
    public static CarlifeGearInfo parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeGearInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeGearInfo parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeGearInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getGear()
    {
      return this.gear_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasGear()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getGear());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasGear()
    {
      return this.hasGear;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeGearInfoProto.internal_static_com_baidu_carlife_protobuf_CarlifeGearInfo_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasGear;
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
      if (hasGear()) {
        paramCodedOutputStream.writeInt32(1, getGear());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeGearInfoProto.CarlifeGearInfo result;
      
      private CarlifeGearInfoProto.CarlifeGearInfo buildParsed()
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
        localBuilder.result = new CarlifeGearInfoProto.CarlifeGearInfo(null);
        return localBuilder;
      }
      
      public CarlifeGearInfoProto.CarlifeGearInfo build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeGearInfoProto.CarlifeGearInfo buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeGearInfoProto.CarlifeGearInfo localCarlifeGearInfo = this.result;
        this.result = null;
        return localCarlifeGearInfo;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeGearInfoProto.CarlifeGearInfo(null);
        return this;
      }
      
      public Builder clearGear()
      {
        CarlifeGearInfoProto.CarlifeGearInfo.access$502(this.result, false);
        CarlifeGearInfoProto.CarlifeGearInfo.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeGearInfoProto.CarlifeGearInfo getDefaultInstanceForType()
      {
        return CarlifeGearInfoProto.CarlifeGearInfo.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeGearInfoProto.CarlifeGearInfo.getDescriptor();
      }
      
      public int getGear()
      {
        return this.result.getGear();
      }
      
      public boolean hasGear()
      {
        return this.result.hasGear();
      }
      
      protected CarlifeGearInfoProto.CarlifeGearInfo internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeGearInfoProto.CarlifeGearInfo paramCarlifeGearInfo)
      {
        if (paramCarlifeGearInfo == CarlifeGearInfoProto.CarlifeGearInfo.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeGearInfo.hasGear()) {
          setGear(paramCarlifeGearInfo.getGear());
        }
        mergeUnknownFields(paramCarlifeGearInfo.getUnknownFields());
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
            setGear(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeGearInfoProto.CarlifeGearInfo)) {
          return mergeFrom((CarlifeGearInfoProto.CarlifeGearInfo)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setGear(int paramInt)
      {
        CarlifeGearInfoProto.CarlifeGearInfo.access$502(this.result, true);
        CarlifeGearInfoProto.CarlifeGearInfo.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeGearInfoProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */