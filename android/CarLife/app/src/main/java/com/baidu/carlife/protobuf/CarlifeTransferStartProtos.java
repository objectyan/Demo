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

public final class CarlifeTransferStartProtos
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_carlife_protobuf_CarlifeTransferStart_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_carlife_protobuf_CarlifeTransferStart_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTransferStartProtos.access$702(paramAnonymousFileDescriptor);
        CarlifeTransferStartProtos.access$002((Descriptors.Descriptor)CarlifeTransferStartProtos.getDescriptor().getMessageTypes().get(0));
        CarlifeTransferStartProtos.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTransferStartProtos.internal_static_carlife_protobuf_CarlifeTransferStart_descriptor, new String[] { "UpdateSize" }, CarlifeTransferStartProtos.CarlifeTransferStart.class, CarlifeTransferStartProtos.CarlifeTransferStart.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\013start.proto\022\020carlife.protobuf\"*\n\024CarlifeTransferStart\022\022\n\nupdateSize\030\001 \002(\005B8\n\032com.baidu.carlife.protobufB\032CarlifeTransferStartProtos" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTransferStart
    extends GeneratedMessage
  {
    public static final int UPDATESIZE_FIELD_NUMBER = 1;
    private static final CarlifeTransferStart defaultInstance = new CarlifeTransferStart();
    private boolean hasUpdateSize;
    private int memoizedSerializedSize = -1;
    private int updateSize_ = 0;
    
    static
    {
      CarlifeTransferStartProtos.getDescriptor();
      CarlifeTransferStartProtos.internalForceInit();
    }
    
    public static CarlifeTransferStart getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTransferStartProtos.internal_static_carlife_protobuf_CarlifeTransferStart_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTransferStart paramCarlifeTransferStart)
    {
      return newBuilder().mergeFrom(paramCarlifeTransferStart);
    }
    
    public static CarlifeTransferStart parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferStart parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTransferStart parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeTransferStart getDefaultInstanceForType()
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
      if (hasUpdateSize()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getUpdateSize());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public int getUpdateSize()
    {
      return this.updateSize_;
    }
    
    public boolean hasUpdateSize()
    {
      return this.hasUpdateSize;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTransferStartProtos.internal_static_carlife_protobuf_CarlifeTransferStart_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasUpdateSize;
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
      if (hasUpdateSize()) {
        paramCodedOutputStream.writeInt32(1, getUpdateSize());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTransferStartProtos.CarlifeTransferStart result;
      
      private CarlifeTransferStartProtos.CarlifeTransferStart buildParsed()
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
        localBuilder.result = new CarlifeTransferStartProtos.CarlifeTransferStart(null);
        return localBuilder;
      }
      
      public CarlifeTransferStartProtos.CarlifeTransferStart build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTransferStartProtos.CarlifeTransferStart buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTransferStartProtos.CarlifeTransferStart localCarlifeTransferStart = this.result;
        this.result = null;
        return localCarlifeTransferStart;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTransferStartProtos.CarlifeTransferStart(null);
        return this;
      }
      
      public Builder clearUpdateSize()
      {
        CarlifeTransferStartProtos.CarlifeTransferStart.access$502(this.result, false);
        CarlifeTransferStartProtos.CarlifeTransferStart.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeTransferStartProtos.CarlifeTransferStart getDefaultInstanceForType()
      {
        return CarlifeTransferStartProtos.CarlifeTransferStart.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTransferStartProtos.CarlifeTransferStart.getDescriptor();
      }
      
      public int getUpdateSize()
      {
        return this.result.getUpdateSize();
      }
      
      public boolean hasUpdateSize()
      {
        return this.result.hasUpdateSize();
      }
      
      protected CarlifeTransferStartProtos.CarlifeTransferStart internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTransferStartProtos.CarlifeTransferStart paramCarlifeTransferStart)
      {
        if (paramCarlifeTransferStart == CarlifeTransferStartProtos.CarlifeTransferStart.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTransferStart.hasUpdateSize()) {
          setUpdateSize(paramCarlifeTransferStart.getUpdateSize());
        }
        mergeUnknownFields(paramCarlifeTransferStart.getUnknownFields());
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
            setUpdateSize(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTransferStartProtos.CarlifeTransferStart)) {
          return mergeFrom((CarlifeTransferStartProtos.CarlifeTransferStart)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setUpdateSize(int paramInt)
      {
        CarlifeTransferStartProtos.CarlifeTransferStart.access$502(this.result, true);
        CarlifeTransferStartProtos.CarlifeTransferStart.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTransferStartProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */