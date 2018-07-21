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

public final class CarlifeCarSpeedProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeCarSpeedProto.access$902(paramAnonymousFileDescriptor);
        CarlifeCarSpeedProto.access$002((Descriptors.Descriptor)CarlifeCarSpeedProto.getDescriptor().getMessageTypes().get(0));
        CarlifeCarSpeedProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeCarSpeedProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_descriptor, new String[] { "Speed", "TimeStamp" }, CarlifeCarSpeedProto.CarlifeCarSpeed.class, CarlifeCarSpeedProto.CarlifeCarSpeed.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\032CarlifeCarSpeedProto.proto\022\032com.baidu.carlife.protobuf\"3\n\017CarlifeCarSpeed\022\r\n\005speed\030\001 \002(\005\022\021\n\ttimeStamp\030\002 \001(\004" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeCarSpeed
    extends GeneratedMessage
  {
    public static final int SPEED_FIELD_NUMBER = 1;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private static final CarlifeCarSpeed defaultInstance = new CarlifeCarSpeed();
    private boolean hasSpeed;
    private boolean hasTimeStamp;
    private int memoizedSerializedSize = -1;
    private int speed_ = 0;
    private long timeStamp_ = 0L;
    
    static
    {
      CarlifeCarSpeedProto.getDescriptor();
      CarlifeCarSpeedProto.internalForceInit();
    }
    
    public static CarlifeCarSpeed getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeCarSpeedProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeCarSpeed paramCarlifeCarSpeed)
    {
      return newBuilder().mergeFrom(paramCarlifeCarSpeed);
    }
    
    public static CarlifeCarSpeed parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeCarSpeed parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeCarSpeed getDefaultInstanceForType()
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
      if (hasSpeed()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getSpeed());
      }
      int j = i;
      if (hasTimeStamp()) {
        j = i + CodedOutputStream.computeUInt64Size(2, getTimeStamp());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getSpeed()
    {
      return this.speed_;
    }
    
    public long getTimeStamp()
    {
      return this.timeStamp_;
    }
    
    public boolean hasSpeed()
    {
      return this.hasSpeed;
    }
    
    public boolean hasTimeStamp()
    {
      return this.hasTimeStamp;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeCarSpeedProto.internal_static_com_baidu_carlife_protobuf_CarlifeCarSpeed_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasSpeed;
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
      if (hasSpeed()) {
        paramCodedOutputStream.writeInt32(1, getSpeed());
      }
      if (hasTimeStamp()) {
        paramCodedOutputStream.writeUInt64(2, getTimeStamp());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeCarSpeedProto.CarlifeCarSpeed result;
      
      private CarlifeCarSpeedProto.CarlifeCarSpeed buildParsed()
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
        localBuilder.result = new CarlifeCarSpeedProto.CarlifeCarSpeed(null);
        return localBuilder;
      }
      
      public CarlifeCarSpeedProto.CarlifeCarSpeed build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeCarSpeedProto.CarlifeCarSpeed buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeCarSpeedProto.CarlifeCarSpeed localCarlifeCarSpeed = this.result;
        this.result = null;
        return localCarlifeCarSpeed;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeCarSpeedProto.CarlifeCarSpeed(null);
        return this;
      }
      
      public Builder clearSpeed()
      {
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$502(this.result, false);
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearTimeStamp()
      {
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$702(this.result, false);
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$802(this.result, 0L);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeCarSpeedProto.CarlifeCarSpeed getDefaultInstanceForType()
      {
        return CarlifeCarSpeedProto.CarlifeCarSpeed.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeCarSpeedProto.CarlifeCarSpeed.getDescriptor();
      }
      
      public int getSpeed()
      {
        return this.result.getSpeed();
      }
      
      public long getTimeStamp()
      {
        return this.result.getTimeStamp();
      }
      
      public boolean hasSpeed()
      {
        return this.result.hasSpeed();
      }
      
      public boolean hasTimeStamp()
      {
        return this.result.hasTimeStamp();
      }
      
      protected CarlifeCarSpeedProto.CarlifeCarSpeed internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeCarSpeedProto.CarlifeCarSpeed paramCarlifeCarSpeed)
      {
        if (paramCarlifeCarSpeed == CarlifeCarSpeedProto.CarlifeCarSpeed.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeCarSpeed.hasSpeed()) {
          setSpeed(paramCarlifeCarSpeed.getSpeed());
        }
        if (paramCarlifeCarSpeed.hasTimeStamp()) {
          setTimeStamp(paramCarlifeCarSpeed.getTimeStamp());
        }
        mergeUnknownFields(paramCarlifeCarSpeed.getUnknownFields());
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
            setSpeed(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setTimeStamp(paramCodedInputStream.readUInt64());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeCarSpeedProto.CarlifeCarSpeed)) {
          return mergeFrom((CarlifeCarSpeedProto.CarlifeCarSpeed)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setSpeed(int paramInt)
      {
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$502(this.result, true);
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setTimeStamp(long paramLong)
      {
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$702(this.result, true);
        CarlifeCarSpeedProto.CarlifeCarSpeed.access$802(this.result, paramLong);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeCarSpeedProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */