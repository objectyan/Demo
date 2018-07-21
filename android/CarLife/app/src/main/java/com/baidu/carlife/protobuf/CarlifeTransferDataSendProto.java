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

public final class CarlifeTransferDataSendProto
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_CarlifeTransferDataSend_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_CarlifeTransferDataSend_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTransferDataSendProto.access$1102(paramAnonymousFileDescriptor);
        CarlifeTransferDataSendProto.access$002((Descriptors.Descriptor)CarlifeTransferDataSendProto.getDescriptor().getMessageTypes().get(0));
        CarlifeTransferDataSendProto.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_descriptor, new String[] { "FileId", "BodyData", "Len" }, CarlifeTransferDataSendProto.CarlifeTransferDataSend.class, CarlifeTransferDataSendProto.CarlifeTransferDataSend.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\"CarlifeTransferDataSendProto.proto\"H\n\027CarlifeTransferDataSend\022\016\n\006fileId\030\001 \002(\005\022\020\n\bbodyData\030\002 \002(\f\022\013\n\003len\030\003 \002(\005B\034\n\032com.baidu.carlife.protobuf" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTransferDataSend
    extends GeneratedMessage
  {
    public static final int BODYDATA_FIELD_NUMBER = 2;
    public static final int FILEID_FIELD_NUMBER = 1;
    public static final int LEN_FIELD_NUMBER = 3;
    private static final CarlifeTransferDataSend defaultInstance = new CarlifeTransferDataSend();
    private ByteString bodyData_ = ByteString.EMPTY;
    private int fileId_ = 0;
    private boolean hasBodyData;
    private boolean hasFileId;
    private boolean hasLen;
    private int len_ = 0;
    private int memoizedSerializedSize = -1;
    
    static
    {
      CarlifeTransferDataSendProto.getDescriptor();
      CarlifeTransferDataSendProto.internalForceInit();
    }
    
    public static CarlifeTransferDataSend getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTransferDataSend paramCarlifeTransferDataSend)
    {
      return newBuilder().mergeFrom(paramCarlifeTransferDataSend);
    }
    
    public static CarlifeTransferDataSend parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTransferDataSend parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public ByteString getBodyData()
    {
      return this.bodyData_;
    }
    
    public CarlifeTransferDataSend getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getFileId()
    {
      return this.fileId_;
    }
    
    public int getLen()
    {
      return this.len_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      int j = 0;
      if (hasFileId()) {
        j = 0 + CodedOutputStream.computeInt32Size(1, getFileId());
      }
      i = j;
      if (hasBodyData()) {
        i = j + CodedOutputStream.computeBytesSize(2, getBodyData());
      }
      j = i;
      if (hasLen()) {
        j = i + CodedOutputStream.computeInt32Size(3, getLen());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasBodyData()
    {
      return this.hasBodyData;
    }
    
    public boolean hasFileId()
    {
      return this.hasFileId;
    }
    
    public boolean hasLen()
    {
      return this.hasLen;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTransferDataSendProto.internal_static_CarlifeTransferDataSend_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasFileId) {}
      while ((!this.hasBodyData) || (!this.hasLen)) {
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
      if (hasFileId()) {
        paramCodedOutputStream.writeInt32(1, getFileId());
      }
      if (hasBodyData()) {
        paramCodedOutputStream.writeBytes(2, getBodyData());
      }
      if (hasLen()) {
        paramCodedOutputStream.writeInt32(3, getLen());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTransferDataSendProto.CarlifeTransferDataSend result;
      
      private CarlifeTransferDataSendProto.CarlifeTransferDataSend buildParsed()
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
        localBuilder.result = new CarlifeTransferDataSendProto.CarlifeTransferDataSend(null);
        return localBuilder;
      }
      
      public CarlifeTransferDataSendProto.CarlifeTransferDataSend build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTransferDataSendProto.CarlifeTransferDataSend buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTransferDataSendProto.CarlifeTransferDataSend localCarlifeTransferDataSend = this.result;
        this.result = null;
        return localCarlifeTransferDataSend;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTransferDataSendProto.CarlifeTransferDataSend(null);
        return this;
      }
      
      public Builder clearBodyData()
      {
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$702(this.result, false);
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$802(this.result, CarlifeTransferDataSendProto.CarlifeTransferDataSend.getDefaultInstance().getBodyData());
        return this;
      }
      
      public Builder clearFileId()
      {
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$502(this.result, false);
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$602(this.result, 0);
        return this;
      }
      
      public Builder clearLen()
      {
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$902(this.result, false);
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$1002(this.result, 0);
        return this;
      }
      
      public Builder clone()
      {
        return create().mergeFrom(this.result);
      }
      
      public ByteString getBodyData()
      {
        return this.result.getBodyData();
      }
      
      public CarlifeTransferDataSendProto.CarlifeTransferDataSend getDefaultInstanceForType()
      {
        return CarlifeTransferDataSendProto.CarlifeTransferDataSend.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTransferDataSendProto.CarlifeTransferDataSend.getDescriptor();
      }
      
      public int getFileId()
      {
        return this.result.getFileId();
      }
      
      public int getLen()
      {
        return this.result.getLen();
      }
      
      public boolean hasBodyData()
      {
        return this.result.hasBodyData();
      }
      
      public boolean hasFileId()
      {
        return this.result.hasFileId();
      }
      
      public boolean hasLen()
      {
        return this.result.hasLen();
      }
      
      protected CarlifeTransferDataSendProto.CarlifeTransferDataSend internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTransferDataSendProto.CarlifeTransferDataSend paramCarlifeTransferDataSend)
      {
        if (paramCarlifeTransferDataSend == CarlifeTransferDataSendProto.CarlifeTransferDataSend.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTransferDataSend.hasFileId()) {
          setFileId(paramCarlifeTransferDataSend.getFileId());
        }
        if (paramCarlifeTransferDataSend.hasBodyData()) {
          setBodyData(paramCarlifeTransferDataSend.getBodyData());
        }
        if (paramCarlifeTransferDataSend.hasLen()) {
          setLen(paramCarlifeTransferDataSend.getLen());
        }
        mergeUnknownFields(paramCarlifeTransferDataSend.getUnknownFields());
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
            break;
          case 18: 
            setBodyData(paramCodedInputStream.readBytes());
            break;
          case 24: 
            setLen(paramCodedInputStream.readInt32());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTransferDataSendProto.CarlifeTransferDataSend)) {
          return mergeFrom((CarlifeTransferDataSendProto.CarlifeTransferDataSend)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setBodyData(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$702(this.result, true);
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$802(this.result, paramByteString);
        return this;
      }
      
      public Builder setFileId(int paramInt)
      {
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$502(this.result, true);
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$602(this.result, paramInt);
        return this;
      }
      
      public Builder setLen(int paramInt)
      {
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$902(this.result, true);
        CarlifeTransferDataSendProto.CarlifeTransferDataSend.access$1002(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTransferDataSendProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */