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

public final class CarlifeAccelerationProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeAccelerationProto.access$1302(paramAnonymousFileDescriptor);
        CarlifeAccelerationProto.access$002((Descriptors.Descriptor)CarlifeAccelerationProto.getDescriptor().getMessageTypes().get(0));
        CarlifeAccelerationProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeAccelerationProto.internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_descriptor, new String[] { "AccX", "AccY", "AccZ", "TimeStamp" }, CarlifeAccelerationProto.CarlifeAcceleration.class, CarlifeAccelerationProto.CarlifeAcceleration.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036CarlifeAccelerationProto.proto\022\032com.baidu.carlife.protobuf\"R\n\023CarlifeAcceleration\022\f\n\004accX\030\001 \002(\001\022\f\n\004accY\030\002 \002(\001\022\f\n\004accZ\030\003 \002(\001\022\021\n\ttimeStamp\030\004 \001(\004" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeAcceleration
    extends GeneratedMessage
  {
    public static final int ACCX_FIELD_NUMBER = 1;
    public static final int ACCY_FIELD_NUMBER = 2;
    public static final int ACCZ_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private static final CarlifeAcceleration defaultInstance = new CarlifeAcceleration();
    private double accX_ = 0.0D;
    private double accY_ = 0.0D;
    private double accZ_ = 0.0D;
    private boolean hasAccX;
    private boolean hasAccY;
    private boolean hasAccZ;
    private boolean hasTimeStamp;
    private int memoizedSerializedSize = -1;
    private long timeStamp_ = 0L;
    
    static
    {
      CarlifeAccelerationProto.getDescriptor();
      CarlifeAccelerationProto.internalForceInit();
    }
    
    public static CarlifeAcceleration getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeAccelerationProto.internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeAcceleration paramCarlifeAcceleration)
    {
      return newBuilder().mergeFrom(paramCarlifeAcceleration);
    }
    
    public static CarlifeAcceleration parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAcceleration parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeAcceleration parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public double getAccX()
    {
      return this.accX_;
    }
    
    public double getAccY()
    {
      return this.accY_;
    }
    
    public double getAccZ()
    {
      return this.accZ_;
    }
    
    public CarlifeAcceleration getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasAccX()) {
        j = 0 + CodedOutputStream.computeDoubleSize(1, getAccX());
      }
      i = j;
      if (hasAccY()) {
        i = j + CodedOutputStream.computeDoubleSize(2, getAccY());
      }
      j = i;
      if (hasAccZ()) {
        j = i + CodedOutputStream.computeDoubleSize(3, getAccZ());
      }
      i = j;
      if (hasTimeStamp()) {
        i = j + CodedOutputStream.computeUInt64Size(4, getTimeStamp());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public long getTimeStamp()
    {
      return this.timeStamp_;
    }
    
    public boolean hasAccX()
    {
      return this.hasAccX;
    }
    
    public boolean hasAccY()
    {
      return this.hasAccY;
    }
    
    public boolean hasAccZ()
    {
      return this.hasAccZ;
    }
    
    public boolean hasTimeStamp()
    {
      return this.hasTimeStamp;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeAccelerationProto.internal_static_com_baidu_carlife_protobuf_CarlifeAcceleration_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasAccX) {}
      while ((!this.hasAccY) || (!this.hasAccZ)) {
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
      if (hasAccX()) {
        paramCodedOutputStream.writeDouble(1, getAccX());
      }
      if (hasAccY()) {
        paramCodedOutputStream.writeDouble(2, getAccY());
      }
      if (hasAccZ()) {
        paramCodedOutputStream.writeDouble(3, getAccZ());
      }
      if (hasTimeStamp()) {
        paramCodedOutputStream.writeUInt64(4, getTimeStamp());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeAccelerationProto.CarlifeAcceleration result;
      
      private CarlifeAccelerationProto.CarlifeAcceleration buildParsed()
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
        localBuilder.result = new CarlifeAccelerationProto.CarlifeAcceleration(null);
        return localBuilder;
      }
      
      public CarlifeAccelerationProto.CarlifeAcceleration build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeAccelerationProto.CarlifeAcceleration buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeAccelerationProto.CarlifeAcceleration localCarlifeAcceleration = this.result;
        this.result = null;
        return localCarlifeAcceleration;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeAccelerationProto.CarlifeAcceleration(null);
        return this;
      }
      
      public Builder clearAccX()
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$502(this.result, false);
        CarlifeAccelerationProto.CarlifeAcceleration.access$602(this.result, 0.0D);
        return this;
      }
      
      public Builder clearAccY()
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$702(this.result, false);
        CarlifeAccelerationProto.CarlifeAcceleration.access$802(this.result, 0.0D);
        return this;
      }
      
      public Builder clearAccZ()
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$902(this.result, false);
        CarlifeAccelerationProto.CarlifeAcceleration.access$1002(this.result, 0.0D);
        return this;
      }
      
      public Builder clearTimeStamp()
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$1102(this.result, false);
        CarlifeAccelerationProto.CarlifeAcceleration.access$1202(this.result, 0L);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public double getAccX()
      {
        return this.result.getAccX();
      }
      
      public double getAccY()
      {
        return this.result.getAccY();
      }
      
      public double getAccZ()
      {
        return this.result.getAccZ();
      }
      
      public CarlifeAccelerationProto.CarlifeAcceleration getDefaultInstanceForType()
      {
        return CarlifeAccelerationProto.CarlifeAcceleration.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeAccelerationProto.CarlifeAcceleration.getDescriptor();
      }
      
      public long getTimeStamp()
      {
        return this.result.getTimeStamp();
      }
      
      public boolean hasAccX()
      {
        return this.result.hasAccX();
      }
      
      public boolean hasAccY()
      {
        return this.result.hasAccY();
      }
      
      public boolean hasAccZ()
      {
        return this.result.hasAccZ();
      }
      
      public boolean hasTimeStamp()
      {
        return this.result.hasTimeStamp();
      }
      
      protected CarlifeAccelerationProto.CarlifeAcceleration internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeAccelerationProto.CarlifeAcceleration paramCarlifeAcceleration)
      {
        if (paramCarlifeAcceleration == CarlifeAccelerationProto.CarlifeAcceleration.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeAcceleration.hasAccX()) {
          setAccX(paramCarlifeAcceleration.getAccX());
        }
        if (paramCarlifeAcceleration.hasAccY()) {
          setAccY(paramCarlifeAcceleration.getAccY());
        }
        if (paramCarlifeAcceleration.hasAccZ()) {
          setAccZ(paramCarlifeAcceleration.getAccZ());
        }
        if (paramCarlifeAcceleration.hasTimeStamp()) {
          setTimeStamp(paramCarlifeAcceleration.getTimeStamp());
        }
        mergeUnknownFields(paramCarlifeAcceleration.getUnknownFields());
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
          case 9: 
            setAccX(paramCodedInputStream.readDouble());
            break;
          case 17: 
            setAccY(paramCodedInputStream.readDouble());
            break;
          case 25: 
            setAccZ(paramCodedInputStream.readDouble());
            break;
          case 32: 
            setTimeStamp(paramCodedInputStream.readUInt64());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeAccelerationProto.CarlifeAcceleration)) {
          return mergeFrom((CarlifeAccelerationProto.CarlifeAcceleration)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setAccX(double paramDouble)
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$502(this.result, true);
        CarlifeAccelerationProto.CarlifeAcceleration.access$602(this.result, paramDouble);
        return this;
      }
      
      public Builder setAccY(double paramDouble)
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$702(this.result, true);
        CarlifeAccelerationProto.CarlifeAcceleration.access$802(this.result, paramDouble);
        return this;
      }
      
      public Builder setAccZ(double paramDouble)
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$902(this.result, true);
        CarlifeAccelerationProto.CarlifeAcceleration.access$1002(this.result, paramDouble);
        return this;
      }
      
      public Builder setTimeStamp(long paramLong)
      {
        CarlifeAccelerationProto.CarlifeAcceleration.access$1102(this.result, true);
        CarlifeAccelerationProto.CarlifeAcceleration.access$1202(this.result, paramLong);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeAccelerationProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */