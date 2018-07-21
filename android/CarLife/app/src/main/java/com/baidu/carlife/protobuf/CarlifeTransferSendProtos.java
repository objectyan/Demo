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

public final class CarlifeTransferSendProtos
{
  private static Descriptors.FileDescriptor descriptor;
  private static Descriptors.Descriptor internal_static_carlife_protobuf_CarlifeTransferSend_descriptor;
  private static GeneratedMessage.FieldAccessorTable internal_static_carlife_protobuf_CarlifeTransferSend_fieldAccessorTable;
  
  static
  {
    Descriptors.FileDescriptor.InternalDescriptorAssigner local1 = new Descriptors.FileDescriptor.InternalDescriptorAssigner()
    {
      public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor paramAnonymousFileDescriptor)
      {
        CarlifeTransferSendProtos.access$902(paramAnonymousFileDescriptor);
        CarlifeTransferSendProtos.access$002((Descriptors.Descriptor)CarlifeTransferSendProtos.getDescriptor().getMessageTypes().get(0));
        CarlifeTransferSendProtos.access$102(new GeneratedMessage.FieldAccessorTable(CarlifeTransferSendProtos.internal_static_carlife_protobuf_CarlifeTransferSend_descriptor, new String[] { "PacketSize", "BodyData" }, CarlifeTransferSendProtos.CarlifeTransferSend.class, CarlifeTransferSendProtos.CarlifeTransferSend.Builder.class));
        return null;
      }
    };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\nsend.proto\022\020carlife.protobuf\";\n\023CarlifeTransferSend\022\022\n\npacketSize\030\001 \002(\005\022\020\n\bbodyData\030\002 \002(\fB7\n\032com.baidu.carlife.protobufB\031CarlifeTransferSendProtos" }, new Descriptors.FileDescriptor[0], local1);
  }
  
  public static Descriptors.FileDescriptor getDescriptor()
  {
    return descriptor;
  }
  
  public static void internalForceInit() {}
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {}
  
  public static final class CarlifeTransferSend
    extends GeneratedMessage
  {
    public static final int BODYDATA_FIELD_NUMBER = 2;
    public static final int PACKETSIZE_FIELD_NUMBER = 1;
    private static final CarlifeTransferSend defaultInstance = new CarlifeTransferSend();
    private ByteString bodyData_ = ByteString.EMPTY;
    private boolean hasBodyData;
    private boolean hasPacketSize;
    private int memoizedSerializedSize = -1;
    private int packetSize_ = 0;
    
    static
    {
      CarlifeTransferSendProtos.getDescriptor();
      CarlifeTransferSendProtos.internalForceInit();
    }
    
    public static CarlifeTransferSend getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final Descriptors.Descriptor getDescriptor()
    {
      return CarlifeTransferSendProtos.internal_static_carlife_protobuf_CarlifeTransferSend_descriptor;
    }
    
    public static Builder newBuilder()
    {
      return Builder.access$300();
    }
    
    public static Builder newBuilder(CarlifeTransferSend paramCarlifeTransferSend)
    {
      return newBuilder().mergeFrom(paramCarlifeTransferSend);
    }
    
    public static CarlifeTransferSend parseDelimitedFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferSend parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeDelimitedFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(ByteString paramByteString)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramByteString, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(CodedInputStream paramCodedInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramCodedInputStream)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return newBuilder().mergeFrom(paramCodedInputStream, paramExtensionRegistryLite).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(InputStream paramInputStream)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite)
      throws IOException
    {
      return ((Builder)newBuilder().mergeFrom(paramInputStream, paramExtensionRegistryLite)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(byte[] paramArrayOfByte)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte)).buildParsed();
    }
    
    public static CarlifeTransferSend parseFrom(byte[] paramArrayOfByte, ExtensionRegistryLite paramExtensionRegistryLite)
      throws InvalidProtocolBufferException
    {
      return ((Builder)newBuilder().mergeFrom(paramArrayOfByte, paramExtensionRegistryLite)).buildParsed();
    }
    
    public ByteString getBodyData()
    {
      return this.bodyData_;
    }
    
    public CarlifeTransferSend getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public int getPacketSize()
    {
      return this.packetSize_;
    }
    
    public int getSerializedSize()
    {
      int i = this.memoizedSerializedSize;
      if (i != -1) {
        return i;
      }
      i = 0;
      if (hasPacketSize()) {
        i = 0 + CodedOutputStream.computeInt32Size(1, getPacketSize());
      }
      int j = i;
      if (hasBodyData()) {
        j = i + CodedOutputStream.computeBytesSize(2, getBodyData());
      }
      i = j + getUnknownFields().getSerializedSize();
      this.memoizedSerializedSize = i;
      return i;
    }
    
    public boolean hasBodyData()
    {
      return this.hasBodyData;
    }
    
    public boolean hasPacketSize()
    {
      return this.hasPacketSize;
    }
    
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
    {
      return CarlifeTransferSendProtos.internal_static_carlife_protobuf_CarlifeTransferSend_fieldAccessorTable;
    }
    
    public final boolean isInitialized()
    {
      if (!this.hasPacketSize) {}
      while (!this.hasBodyData) {
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
      if (hasPacketSize()) {
        paramCodedOutputStream.writeInt32(1, getPacketSize());
      }
      if (hasBodyData()) {
        paramCodedOutputStream.writeBytes(2, getBodyData());
      }
      getUnknownFields().writeTo(paramCodedOutputStream);
    }
    
    public static final class Builder
      extends GeneratedMessage.Builder<Builder>
    {
      private CarlifeTransferSendProtos.CarlifeTransferSend result;
      
      private CarlifeTransferSendProtos.CarlifeTransferSend buildParsed()
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
        localBuilder.result = new CarlifeTransferSendProtos.CarlifeTransferSend(null);
        return localBuilder;
      }
      
      public CarlifeTransferSendProtos.CarlifeTransferSend build()
      {
        if ((this.result != null) && (!isInitialized())) {
          throw newUninitializedMessageException(this.result);
        }
        return buildPartial();
      }
      
      public CarlifeTransferSendProtos.CarlifeTransferSend buildPartial()
      {
        if (this.result == null) {
          throw new IllegalStateException("build() has already been called on this Builder.");
        }
        CarlifeTransferSendProtos.CarlifeTransferSend localCarlifeTransferSend = this.result;
        this.result = null;
        return localCarlifeTransferSend;
      }
      
      public Builder clear()
      {
        if (this.result == null) {
          throw new IllegalStateException("Cannot call clear() after build().");
        }
        this.result = new CarlifeTransferSendProtos.CarlifeTransferSend(null);
        return this;
      }
      
      public Builder clearBodyData()
      {
        CarlifeTransferSendProtos.CarlifeTransferSend.access$702(this.result, false);
        CarlifeTransferSendProtos.CarlifeTransferSend.access$802(this.result, CarlifeTransferSendProtos.CarlifeTransferSend.getDefaultInstance().getBodyData());
        return this;
      }
      
      public Builder clearPacketSize()
      {
        CarlifeTransferSendProtos.CarlifeTransferSend.access$502(this.result, false);
        CarlifeTransferSendProtos.CarlifeTransferSend.access$602(this.result, 0);
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
      
      public CarlifeTransferSendProtos.CarlifeTransferSend getDefaultInstanceForType()
      {
        return CarlifeTransferSendProtos.CarlifeTransferSend.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType()
      {
        return CarlifeTransferSendProtos.CarlifeTransferSend.getDescriptor();
      }
      
      public int getPacketSize()
      {
        return this.result.getPacketSize();
      }
      
      public boolean hasBodyData()
      {
        return this.result.hasBodyData();
      }
      
      public boolean hasPacketSize()
      {
        return this.result.hasPacketSize();
      }
      
      protected CarlifeTransferSendProtos.CarlifeTransferSend internalGetResult()
      {
        return this.result;
      }
      
      public boolean isInitialized()
      {
        return this.result.isInitialized();
      }
      
      public Builder mergeFrom(CarlifeTransferSendProtos.CarlifeTransferSend paramCarlifeTransferSend)
      {
        if (paramCarlifeTransferSend == CarlifeTransferSendProtos.CarlifeTransferSend.getDefaultInstance()) {
          return this;
        }
        if (paramCarlifeTransferSend.hasPacketSize()) {
          setPacketSize(paramCarlifeTransferSend.getPacketSize());
        }
        if (paramCarlifeTransferSend.hasBodyData()) {
          setBodyData(paramCarlifeTransferSend.getBodyData());
        }
        mergeUnknownFields(paramCarlifeTransferSend.getUnknownFields());
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
            setPacketSize(paramCodedInputStream.readInt32());
            break;
          case 18: 
            setBodyData(paramCodedInputStream.readBytes());
          }
        }
      }
      
      public Builder mergeFrom(Message paramMessage)
      {
        if ((paramMessage instanceof CarlifeTransferSendProtos.CarlifeTransferSend)) {
          return mergeFrom((CarlifeTransferSendProtos.CarlifeTransferSend)paramMessage);
        }
        super.mergeFrom(paramMessage);
        return this;
      }
      
      public Builder setBodyData(ByteString paramByteString)
      {
        if (paramByteString == null) {
          throw new NullPointerException();
        }
        CarlifeTransferSendProtos.CarlifeTransferSend.access$702(this.result, true);
        CarlifeTransferSendProtos.CarlifeTransferSend.access$802(this.result, paramByteString);
        return this;
      }
      
      public Builder setPacketSize(int paramInt)
      {
        CarlifeTransferSendProtos.CarlifeTransferSend.access$502(this.result, true);
        CarlifeTransferSendProtos.CarlifeTransferSend.access$602(this.result, paramInt);
        return this;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/protobuf/CarlifeTransferSendProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */