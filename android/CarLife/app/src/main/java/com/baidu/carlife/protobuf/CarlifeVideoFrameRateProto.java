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

public final class CarlifeVideoFrameRateProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeVideoFrameRateProto.access$702(paramAnonymousFileDescriptor);
        CarlifeVideoFrameRateProto.access$002((Descriptors.Descriptor)CarlifeVideoFrameRateProto.getDescriptor().getMessageTypes().get(0));
        CarlifeVideoFrameRateProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeVideoFrameRateProto.internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_descriptor, new String[] { "FrameRate" }, CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.class, CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n CarlifeVideoFrameRateProto.proto\022\032com.baidu.carlife.protobuf\"*\n\025CarlifeVideoFrameRate\022\021\n\tframeRate\030\001 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeVideoFrameRate
    extends GeneratedMessage
  {
    public static final int FRAMERATE_FIELD_NUMBER = 1;
    private static final CarlifeVideoFrameRate defaultInstance = new CarlifeVideoFrameRate();
    private int frameRate_ = 0;
    private boolean hasFrameRate;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeVideoFrameRateProto.getDescriptor();
      CarlifeVideoFrameRateProto.internalForceInit();
    }
    
    public static CarlifeVideoFrameRate getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeVideoFrameRateProto.internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeVideoFrameRate paramCarlifeVideoFrameRate)
    {
      return newBuilder().mergeFrom(paramCarlifeVideoFrameRate);
    }
    
    public static CarlifeVideoFrameRate parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeVideoFrameRate parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeVideoFrameRate getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFrameRate()
    {
      return this.frameRate_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasFrameRate()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getFrameRate());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasFrameRate()
    {
      return this.hasFrameRate;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeVideoFrameRateProto.internal_static_com_baidu_carlife_protobuf_CarlifeVideoFrameRate_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasFrameRate;
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
      if (hasFrameRate()) {
        paramCodedOutputStream.writeInt32(1, getFrameRate());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeVideoFrameRateProto.CarlifeVideoFrameRate result;
      
      private CarlifeVideoFrameRateProto.CarlifeVideoFrameRate buildParsed()
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
        localBuilder.result = new CarlifeVideoFrameRateProto.CarlifeVideoFrameRate(null);
        return localBuilder;
      }
      
      public CarlifeVideoFrameRateProto.CarlifeVideoFrameRate build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeVideoFrameRateProto.CarlifeVideoFrameRate buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeVideoFrameRateProto.CarlifeVideoFrameRate localCarlifeVideoFrameRate = this.result;
        this.result = null;
        return localCarlifeVideoFrameRate;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeVideoFrameRateProto.CarlifeVideoFrameRate(null);
        return this;
      }
      
      public Builder clearFrameRate()
      {
        CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.access$502(this.result, false);
        CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeVideoFrameRateProto.CarlifeVideoFrameRate getDefaultInstanceForType()
      {
        return CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.getDescriptor();
      }
      
      public int getFrameRate()
      {
        return this.result.getFrameRate();
      }
      
      public boolean hasFrameRate()
      {
        return this.result.hasFrameRate();
      }
      
      protected CarlifeVideoFrameRateProto.CarlifeVideoFrameRate internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeVideoFrameRateProto.CarlifeVideoFrameRate paramCarlifeVideoFrameRate)
      {
        if (paramCarlifeVideoFrameRate == CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeVideoFrameRate.hasFrameRate()) {
          setFrameRate(paramCarlifeVideoFrameRate.getFrameRate());
        }
        mergeUnknownFields(paramCarlifeVideoFrameRate.getUnknownFields());
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
            setFrameRate(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeVideoFrameRateProto.CarlifeVideoFrameRate)) {
          return mergeFrom((CarlifeVideoFrameRateProto.CarlifeVideoFrameRate)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFrameRate(int paramInt)
      {
        CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.access$502(this.result, true);
        CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeVideoFrameRateProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */