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

public final class CarlifeTransferEndProtos
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_carlife_protobuf_CarlifeTransferEnd_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTransferEndProtos.access$702(paramAnonymousFileDescriptor);
        CarlifeTransferEndProtos.access$002((Descriptors.Descriptor)CarlifeTransferEndProtos.getDescriptor().getMessageTypes().get(0));
        CarlifeTransferEndProtos.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTransferEndProtos.internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor, new String[] { "NewFirmwareVersionCode" }, CarlifeTransferEndProtos.CarlifeTransferEnd.class, CarlifeTransferEndProtos.CarlifeTransferEnd.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\tend.proto\022\020carlife.protobuf\"4\n\022CarlifeTransferEnd\022\036\n\026newFirmwareVersionCode\030\001 \002(\005B6\n\032com.baidu.carlife.protobufB\030CarlifeTransferEndProtos" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTransferEnd
    extends GeneratedMessage
  {
    public static final int NEWFIRMWAREVERSIONCODE_FIELD_NUMBER = 1;
    private static final CarlifeTransferEnd defaultInstance = new CarlifeTransferEnd();
    private boolean hasNewFirmwareVersionCode;
    private int memoizedSerializedSize = -1;
    private int newFirmwareVersionCode_ = 0;
    
    static
    {
      CarlifeTransferEndProtos.getDescriptor();
      CarlifeTransferEndProtos.internalForceInit();
    }
    
    public static CarlifeTransferEnd getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTransferEndProtos.internal_static_carlife_protobuf_CarlifeTransferEnd_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTransferEnd paramCarlifeTransferEnd)
    {
      return newBuilder().mergeFrom(paramCarlifeTransferEnd);
    }
    
    public static CarlifeTransferEnd parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTransferEnd parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeTransferEnd getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getNewFirmwareVersionCode()
    {
      return this.newFirmwareVersionCode_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasNewFirmwareVersionCode()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getNewFirmwareVersionCode());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasNewFirmwareVersionCode()
    {
      return this.hasNewFirmwareVersionCode;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTransferEndProtos.internal_static_carlife_protobuf_CarlifeTransferEnd_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasNewFirmwareVersionCode;
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
      if (hasNewFirmwareVersionCode()) {
        paramCodedOutputStream.writeInt32(1, getNewFirmwareVersionCode());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTransferEndProtos.CarlifeTransferEnd result;
      
      private CarlifeTransferEndProtos.CarlifeTransferEnd buildParsed()
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
        localBuilder.result = new CarlifeTransferEndProtos.CarlifeTransferEnd(null);
        return localBuilder;
      }
      
      public CarlifeTransferEndProtos.CarlifeTransferEnd build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTransferEndProtos.CarlifeTransferEnd buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTransferEndProtos.CarlifeTransferEnd localCarlifeTransferEnd = this.result;
        this.result = null;
        return localCarlifeTransferEnd;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTransferEndProtos.CarlifeTransferEnd(null);
        return this;
      }
      
      public Builder clearNewFirmwareVersionCode()
      {
        CarlifeTransferEndProtos.CarlifeTransferEnd.access$502(this.result, false);
        CarlifeTransferEndProtos.CarlifeTransferEnd.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeTransferEndProtos.CarlifeTransferEnd getDefaultInstanceForType()
      {
        return CarlifeTransferEndProtos.CarlifeTransferEnd.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTransferEndProtos.CarlifeTransferEnd.getDescriptor();
      }
      
      public int getNewFirmwareVersionCode()
      {
        return this.result.getNewFirmwareVersionCode();
      }
      
      public boolean hasNewFirmwareVersionCode()
      {
        return this.result.hasNewFirmwareVersionCode();
      }
      
      protected CarlifeTransferEndProtos.CarlifeTransferEnd internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTransferEndProtos.CarlifeTransferEnd paramCarlifeTransferEnd)
      {
        if (paramCarlifeTransferEnd == CarlifeTransferEndProtos.CarlifeTransferEnd.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTransferEnd.hasNewFirmwareVersionCode()) {
          setNewFirmwareVersionCode(paramCarlifeTransferEnd.getNewFirmwareVersionCode());
        }
        mergeUnknownFields(paramCarlifeTransferEnd.getUnknownFields());
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
            setNewFirmwareVersionCode(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTransferEndProtos.CarlifeTransferEnd)) {
          return mergeFrom((CarlifeTransferEndProtos.CarlifeTransferEnd)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setNewFirmwareVersionCode(int paramInt)
      {
        CarlifeTransferEndProtos.CarlifeTransferEnd.access$502(this.result, true);
        CarlifeTransferEndProtos.CarlifeTransferEnd.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTransferEndProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */