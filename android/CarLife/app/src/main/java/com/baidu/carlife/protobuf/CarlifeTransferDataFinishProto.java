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

public final class CarlifeTransferDataFinishProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeTransferDataFinish_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeTransferDataFinish_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTransferDataFinishProto.access$702(paramAnonymousFileDescriptor);
        CarlifeTransferDataFinishProto.access$002((Descriptors.Descriptor)CarlifeTransferDataFinishProto.getDescriptor().getMessageTypes().get(0));
        CarlifeTransferDataFinishProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_descriptor, new String[] { "FileId" }, CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.class, CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n$CarlifeTransferDataFinishProto.proto\"+\n\031CarlifeTransferDataFinish\022\016\n\006fileId\030\001 \002(\005B\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTransferDataFinish
    extends GeneratedMessage
  {
    public static final int FILEID_FIELD_NUMBER = 1;
    private static final CarlifeTransferDataFinish defaultInstance = new CarlifeTransferDataFinish();
    private int fileId_ = 0;
    private boolean hasFileId;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeTransferDataFinishProto.getDescriptor();
      CarlifeTransferDataFinishProto.internalForceInit();
    }
    
    public static CarlifeTransferDataFinish getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTransferDataFinish paramCarlifeTransferDataFinish)
    {
      return newBuilder().mergeFrom(paramCarlifeTransferDataFinish);
    }
    
    public static CarlifeTransferDataFinish parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTransferDataFinish parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public CarlifeTransferDataFinish getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFileId()
    {
      return this.fileId_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasFileId()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getFileId());
      }
      i += getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasFileId()
    {
      return this.hasFileId;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTransferDataFinishProto.internal_static_CarlifeTransferDataFinish_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      return this.hasFileId;
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
      if (hasFileId()) {
        paramCodedOutputStream.writeInt32(1, getFileId());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTransferDataFinishProto.CarlifeTransferDataFinish result;
      
      private CarlifeTransferDataFinishProto.CarlifeTransferDataFinish buildParsed()
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
        localBuilder.result = new CarlifeTransferDataFinishProto.CarlifeTransferDataFinish(null);
        return localBuilder;
      }
      
      public CarlifeTransferDataFinishProto.CarlifeTransferDataFinish build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTransferDataFinishProto.CarlifeTransferDataFinish buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTransferDataFinishProto.CarlifeTransferDataFinish localCarlifeTransferDataFinish = this.result;
        this.result = null;
        return localCarlifeTransferDataFinish;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTransferDataFinishProto.CarlifeTransferDataFinish(null);
        return this;
      }
      
      public Builder clearFileId()
      {
        CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.access$502(this.result, false);
        CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.access$602(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public CarlifeTransferDataFinishProto.CarlifeTransferDataFinish getDefaultInstanceForType()
      {
        return CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.getDescriptor();
      }
      
      public int getFileId()
      {
        return this.result.getFileId();
      }
      
      public boolean hasFileId()
      {
        return this.result.hasFileId();
      }
      
      protected CarlifeTransferDataFinishProto.CarlifeTransferDataFinish internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTransferDataFinishProto.CarlifeTransferDataFinish paramCarlifeTransferDataFinish)
      {
        if (paramCarlifeTransferDataFinish == CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTransferDataFinish.hasFileId()) {
          setFileId(paramCarlifeTransferDataFinish.getFileId());
        }
        mergeUnknownFields(paramCarlifeTransferDataFinish.getUnknownFields());
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
            setFileId(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTransferDataFinishProto.CarlifeTransferDataFinish)) {
          return mergeFrom((CarlifeTransferDataFinishProto.CarlifeTransferDataFinish)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setFileId(int paramInt)
      {
        CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.access$502(this.result, true);
        CarlifeTransferDataFinishProto.CarlifeTransferDataFinish.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTransferDataFinishProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */