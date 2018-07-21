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

public final class CarlifeTouchSinglePointProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTouchSinglePointProto.access$902(paramAnonymousFileDescriptor);
        CarlifeTouchSinglePointProto.access$002((Descriptors.Descriptor)CarlifeTouchSinglePointProto.getDescriptor().getMessageTypes().get(0));
        CarlifeTouchSinglePointProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTouchSinglePointProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_descriptor, new String[] { "X", "Y" }, CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.class, CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeTouchSinglePointProto.proto\022\032com.baidu.carlife.protobuf\"/\n\027CarlifeTouchSinglePoint\022\t\n\001x\030\001 \002(\005\022\t\n\001y\030\002 \002(\005" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTouchSinglePoint
    extends GeneratedMessage
  {
    public static final int X_FIELD_NUMBER = 1;
    public static final int Y_FIELD_NUMBER = 2;
    private static final CarlifeTouchSinglePoint defaultInstance = new CarlifeTouchSinglePoint();
    private boolean hasX;
    private boolean hasY;
    private int memoizedSerializedSize = -1;
    private int x_ = 0;
    private int y_ = 0;
    
    static
    {
      CarlifeTouchSinglePointProto.getDescriptor();
      CarlifeTouchSinglePointProto.internalForceInit();
    }
    
    public static CarlifeTouchSinglePoint getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTouchSinglePointProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTouchSinglePoint paramCarlifeTouchSinglePoint)
    {
      return newBuilder().mergeFrom(paramCarlifeTouchSinglePoint);
    }
    
    public static CarlifeTouchSinglePoint parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTouchSinglePoint parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeTouchSinglePoint getDefaultInstanceForType()
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
      if (hasX()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getX());
      }
      int j = i;
      if (hasY()) {
        j = i + CodedOutputStream.computeInt32Size(2, getY());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getX()
    {
      return this.x_;
    }
    
    public int getY()
    {
      return this.y_;
    }
    
    public boolean hasX()
    {
      return this.hasX;
    }
    
    public boolean hasY()
    {
      return this.hasY;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTouchSinglePointProto.internal_static_com_baidu_carlife_protobuf_CarlifeTouchSinglePoint_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasX) {}
      while (!this.hasY) {
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
      if (hasX()) {
        paramCodedOutputStream.writeInt32(1, getX());
      }
      if (hasY()) {
        paramCodedOutputStream.writeInt32(2, getY());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint result;
      
      private CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint buildParsed()
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
        localBuilder.result = new CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint(null);
        return localBuilder;
      }
      
      public CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint localCarlifeTouchSinglePoint = this.result;
        this.result = null;
        return localCarlifeTouchSinglePoint;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint(null);
        return this;
      }
      
      public Builder clearX()
      {
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$502(this.result, false);
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearY()
      {
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$702(this.result, false);
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$802(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint getDefaultInstanceForType()
      {
        return CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.getDescriptor();
      }
      
      public int getX()
      {
        return this.result.getX();
      }
      
      public int getY()
      {
        return this.result.getY();
      }
      
      public boolean hasX()
      {
        return this.result.hasX();
      }
      
      public boolean hasY()
      {
        return this.result.hasY();
      }
      
      protected CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint paramCarlifeTouchSinglePoint)
      {
        if (paramCarlifeTouchSinglePoint == CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTouchSinglePoint.hasX()) {
          setX(paramCarlifeTouchSinglePoint.getX());
        }
        if (paramCarlifeTouchSinglePoint.hasY()) {
          setY(paramCarlifeTouchSinglePoint.getY());
        }
        mergeUnknownFields(paramCarlifeTouchSinglePoint.getUnknownFields());
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
            setX(paramCodedInputStream.readInt32());
            break;
          case 16: 
            setY(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint)) {
          return mergeFrom((CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setX(int paramInt)
      {
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$502(this.result, true);
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setY(int paramInt)
      {
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$702(this.result, true);
        CarlifeTouchSinglePointProto.CarlifeTouchSinglePoint.access$802(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTouchSinglePointProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */