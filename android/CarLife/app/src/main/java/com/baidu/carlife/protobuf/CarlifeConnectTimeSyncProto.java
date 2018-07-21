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

public final class CarlifeConnectTimeSyncProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeConnectTimeSync_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeConnectTimeSync_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeConnectTimeSyncProto.access$702(paramAnonymousFileDescriptor);
        CarlifeConnectTimeSyncProto.access$002((Descriptors.Descriptor)CarlifeConnectTimeSyncProto.getDescriptor().getMessageTypes().get(0));
        CarlifeConnectTimeSyncProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_descriptor, new String[] { "TimeStamp" }, CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.class, CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n!CarlifeConnectTimeSyncProto.proto\"+\n\026CarlifeConnectTimeSync\022\021\n\ttimeStamp\030\001 \002(\005B\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeConnectTimeSync
    extends GeneratedMessage
  {
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private static final CarlifeConnectTimeSync defaultInstance = new CarlifeConnectTimeSync();
    private boolean hasTimeStamp;
    private int memoizedSerializedSize = -1;
    private int timeStamp_ = 0;
    
    static
    {
      CarlifeConnectTimeSyncProto.getDescriptor();
      CarlifeConnectTimeSyncProto.internalForceInit();
    }
    
    public static CarlifeConnectTimeSync getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeConnectTimeSync paramCarlifeConnectTimeSync)
    {
      return newBuilder().mergeFrom(paramCarlifeConnectTimeSync);
    }
    
    public static CarlifeConnectTimeSync parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeConnectTimeSync parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeConnectTimeSync getDefaultInstanceForType()
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
      if (hasTimeStamp()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getTimeStamp());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getTimeStamp()
    {
      return this.timeStamp_;
    }
    
    public boolean hasTimeStamp()
    {
      return this.hasTimeStamp;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeConnectTimeSyncProto.internal_static_CarlifeConnectTimeSync_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasTimeStamp;
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
      if (hasTimeStamp()) {
        paramCodedOutputStream.writeInt32(1, getTimeStamp());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync result;
      
      private CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync buildParsed()
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
        localBuilder.result = new CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync(null);
        return localBuilder;
      }
      
      public CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync localCarlifeConnectTimeSync = this.result;
        this.result = null;
        return localCarlifeConnectTimeSync;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync(null);
        return this;
      }
      
      public Builder clearTimeStamp()
      {
        CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.access$502(this.result, false);
        CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync getDefaultInstanceForType()
      {
        return CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.getDescriptor();
      }
      
      public int getTimeStamp()
      {
        return this.result.getTimeStamp();
      }
      
      public boolean hasTimeStamp()
      {
        return this.result.hasTimeStamp();
      }
      
      protected CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync paramCarlifeConnectTimeSync)
      {
        if (paramCarlifeConnectTimeSync == CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeConnectTimeSync.hasTimeStamp()) {
          setTimeStamp(paramCarlifeConnectTimeSync.getTimeStamp());
        }
        mergeUnknownFields(paramCarlifeConnectTimeSync.getUnknownFields());
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
            setTimeStamp(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync)) {
          return mergeFrom((CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setTimeStamp(int paramInt)
      {
        CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.access$502(this.result, true);
        CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeConnectTimeSyncProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */